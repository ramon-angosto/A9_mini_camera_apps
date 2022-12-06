package com.mbridge.msdk.thrid.okhttp.internal.http;

import androidx.browser.trusted.sharing.ShareTarget;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.ironsource.mediationsdk.config.VersionInfo;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.thrid.okhttp.Address;
import com.mbridge.msdk.thrid.okhttp.Call;
import com.mbridge.msdk.thrid.okhttp.CertificatePinner;
import com.mbridge.msdk.thrid.okhttp.EventListener;
import com.mbridge.msdk.thrid.okhttp.HttpUrl;
import com.mbridge.msdk.thrid.okhttp.Interceptor;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import com.mbridge.msdk.thrid.okhttp.Request;
import com.mbridge.msdk.thrid.okhttp.RequestBody;
import com.mbridge.msdk.thrid.okhttp.Response;
import com.mbridge.msdk.thrid.okhttp.ResponseBody;
import com.mbridge.msdk.thrid.okhttp.Route;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.connection.RealConnection;
import com.mbridge.msdk.thrid.okhttp.internal.connection.RouteException;
import com.mbridge.msdk.thrid.okhttp.internal.connection.StreamAllocation;
import com.mbridge.msdk.thrid.okhttp.internal.http2.ConnectionShutdownException;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import ms.bd.o.Pgl.c;

public final class RetryAndFollowUpInterceptor implements Interceptor {
    private static final int MAX_FOLLOW_UPS = 20;
    private Object callStackTrace;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private final boolean forWebSocket;
    private volatile StreamAllocation streamAllocation;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient, boolean z) {
        this.client = okHttpClient;
        this.forWebSocket = z;
    }

    public void cancel() {
        this.canceled = true;
        StreamAllocation streamAllocation2 = this.streamAllocation;
        if (streamAllocation2 != null) {
            streamAllocation2.cancel();
        }
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public void setCallStackTrace(Object obj) {
        this.callStackTrace = obj;
    }

    public StreamAllocation streamAllocation() {
        return this.streamAllocation;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Call call = realInterceptorChain.call();
        EventListener eventListener = realInterceptorChain.eventListener();
        StreamAllocation streamAllocation2 = new StreamAllocation(this.client.connectionPool(), createAddress(request.url()), call, eventListener, this.callStackTrace);
        this.streamAllocation = streamAllocation2;
        int i = 0;
        Response response = null;
        while (!this.canceled) {
            try {
                Response proceed = realInterceptorChain.proceed(request, streamAllocation2, (HttpCodec) null, (RealConnection) null);
                if (response != null) {
                    proceed = proceed.newBuilder().priorResponse(response.newBuilder().body((ResponseBody) null).build()).build();
                }
                try {
                    Request followUpRequest = followUpRequest(proceed, streamAllocation2.route());
                    if (followUpRequest == null) {
                        streamAllocation2.release();
                        return proceed;
                    }
                    Util.closeQuietly((Closeable) proceed.body());
                    int i2 = i + 1;
                    if (i2 > 20) {
                        streamAllocation2.release();
                        throw new ProtocolException("Too many follow-up requests: " + i2);
                    } else if (!(followUpRequest.body() instanceof UnrepeatableRequestBody)) {
                        if (!sameConnection(proceed, followUpRequest.url())) {
                            streamAllocation2.release();
                            streamAllocation2 = new StreamAllocation(this.client.connectionPool(), createAddress(followUpRequest.url()), call, eventListener, this.callStackTrace);
                            this.streamAllocation = streamAllocation2;
                        } else if (streamAllocation2.codec() != null) {
                            throw new IllegalStateException("Closing the body of " + proceed + " didn't close its backing stream. Bad interceptor?");
                        }
                        response = proceed;
                        request = followUpRequest;
                        i = i2;
                    } else {
                        streamAllocation2.release();
                        throw new HttpRetryException("Cannot retry streamed HTTP body", proceed.code());
                    }
                } catch (IOException e) {
                    streamAllocation2.release();
                    throw e;
                }
            } catch (RouteException e2) {
                if (!recover(e2.getLastConnectException(), streamAllocation2, false, request)) {
                    throw e2.getFirstConnectException();
                }
            } catch (IOException e3) {
                if (!recover(e3, streamAllocation2, !(e3 instanceof ConnectionShutdownException), request)) {
                    throw e3;
                }
            } catch (Throwable th) {
                streamAllocation2.streamFailed((IOException) null);
                streamAllocation2.release();
                throw th;
            }
        }
        streamAllocation2.release();
        throw new IOException("Canceled");
    }

    private Address createAddress(HttpUrl httpUrl) {
        CertificatePinner certificatePinner;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (httpUrl.isHttps()) {
            SSLSocketFactory sslSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            certificatePinner = this.client.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    private boolean recover(IOException iOException, StreamAllocation streamAllocation2, boolean z, Request request) {
        streamAllocation2.streamFailed(iOException);
        if (!this.client.retryOnConnectionFailure()) {
            return false;
        }
        if ((!z || !requestIsUnrepeatable(iOException, request)) && isRecoverable(iOException, z) && streamAllocation2.hasMoreRoutes()) {
            return true;
        }
        return false;
    }

    private boolean requestIsUnrepeatable(IOException iOException, Request request) {
        return (request.body() instanceof UnrepeatableRequestBody) || (iOException instanceof FileNotFoundException);
    }

    private boolean isRecoverable(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || z) {
                return false;
            }
            return true;
        } else if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return true;
        } else {
            return false;
        }
    }

    private Request followUpRequest(Response response, Route route) throws IOException {
        String header;
        HttpUrl resolve;
        if (response != null) {
            int code = response.code();
            String method = response.request().method();
            RequestBody requestBody = null;
            if (code == 307 || code == 308) {
                if (!method.equals(ShareTarget.METHOD_GET) && !method.equals(VersionInfo.GIT_BRANCH)) {
                    return null;
                }
            } else if (code == 401) {
                return this.client.authenticator().authenticate(route, response);
            } else {
                if (code != 503) {
                    if (code != 407) {
                        if (code != 408) {
                            switch (code) {
                                case c.COLLECT_MODE_FINANCE /*300*/:
                                case 301:
                                case IronSourceConstants.OFFERWALL_AVAILABLE:
                                case 303:
                                    break;
                                default:
                                    return null;
                            }
                        } else if (!this.client.retryOnConnectionFailure() || (response.request().body() instanceof UnrepeatableRequestBody)) {
                            return null;
                        } else {
                            if ((response.priorResponse() == null || response.priorResponse().code() != 408) && retryAfter(response, 0) <= 0) {
                                return response.request();
                            }
                            return null;
                        }
                    } else if (route.proxy().type() == Proxy.Type.HTTP) {
                        return this.client.proxyAuthenticator().authenticate(route, response);
                    } else {
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    }
                } else if ((response.priorResponse() == null || response.priorResponse().code() != 503) && retryAfter(response, Integer.MAX_VALUE) == 0) {
                    return response.request();
                } else {
                    return null;
                }
            }
            if (!this.client.followRedirects() || (header = response.header(HttpHeaders.LOCATION)) == null || (resolve = response.request().url().resolve(header)) == null) {
                return null;
            }
            if (!resolve.scheme().equals(response.request().url().scheme()) && !this.client.followSslRedirects()) {
                return null;
            }
            Request.Builder newBuilder = response.request().newBuilder();
            if (HttpMethod.permitsRequestBody(method)) {
                boolean redirectsWithBody = HttpMethod.redirectsWithBody(method);
                if (HttpMethod.redirectsToGet(method)) {
                    newBuilder.method(ShareTarget.METHOD_GET, (RequestBody) null);
                } else {
                    if (redirectsWithBody) {
                        requestBody = response.request().body();
                    }
                    newBuilder.method(method, requestBody);
                }
                if (!redirectsWithBody) {
                    newBuilder.removeHeader("Transfer-Encoding");
                    newBuilder.removeHeader(HttpHeaders.CONTENT_LENGTH);
                    newBuilder.removeHeader(HttpHeaders.CONTENT_TYPE);
                }
            }
            if (!sameConnection(response, resolve)) {
                newBuilder.removeHeader(HttpHeaders.AUTHORIZATION);
            }
            return newBuilder.url(resolve).build();
        }
        throw new IllegalStateException();
    }

    private int retryAfter(Response response, int i) {
        String header = response.header("Retry-After");
        if (header == null) {
            return i;
        }
        if (header.matches("\\d+")) {
            return Integer.valueOf(header).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private boolean sameConnection(Response response, HttpUrl httpUrl) {
        HttpUrl url = response.request().url();
        return url.host().equals(httpUrl.host()) && url.port() == httpUrl.port() && url.scheme().equals(httpUrl.scheme());
    }
}
