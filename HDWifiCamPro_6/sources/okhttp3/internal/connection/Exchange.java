package okhttp3.internal.connection;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.ws.RealWebSocket;
import okio.Buffer;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Exchange {
    final Call call;
    final ExchangeCodec codec;
    private boolean duplex;
    final EventListener eventListener;
    final ExchangeFinder finder;
    final Transmitter transmitter;

    public Exchange(Transmitter transmitter2, Call call2, EventListener eventListener2, ExchangeFinder exchangeFinder, ExchangeCodec exchangeCodec) {
        this.transmitter = transmitter2;
        this.call = call2;
        this.eventListener = eventListener2;
        this.finder = exchangeFinder;
        this.codec = exchangeCodec;
    }

    public RealConnection connection() {
        return this.codec.connection();
    }

    public boolean isDuplex() {
        return this.duplex;
    }

    public void writeRequestHeaders(Request request) throws IOException {
        try {
            this.eventListener.requestHeadersStart(this.call);
            this.codec.writeRequestHeaders(request);
            this.eventListener.requestHeadersEnd(this.call, request);
        } catch (IOException e) {
            this.eventListener.requestFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public Sink createRequestBody(Request request, boolean z) throws IOException {
        this.duplex = z;
        long contentLength = request.body().contentLength();
        this.eventListener.requestBodyStart(this.call);
        return new RequestBodySink(this.codec.createRequestBody(request, contentLength), contentLength);
    }

    public void flushRequest() throws IOException {
        try {
            this.codec.flushRequest();
        } catch (IOException e) {
            this.eventListener.requestFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public void finishRequest() throws IOException {
        try {
            this.codec.finishRequest();
        } catch (IOException e) {
            this.eventListener.requestFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public void responseHeadersStart() {
        this.eventListener.responseHeadersStart(this.call);
    }

    @Nullable
    public Response.Builder readResponseHeaders(boolean z) throws IOException {
        try {
            Response.Builder readResponseHeaders = this.codec.readResponseHeaders(z);
            if (readResponseHeaders != null) {
                Internal.instance.initExchange(readResponseHeaders, this);
            }
            return readResponseHeaders;
        } catch (IOException e) {
            this.eventListener.responseFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public void responseHeadersEnd(Response response) {
        this.eventListener.responseHeadersEnd(this.call, response);
    }

    public ResponseBody openResponseBody(Response response) throws IOException {
        try {
            this.eventListener.responseBodyStart(this.call);
            String header = response.header(HttpHeaders.CONTENT_TYPE);
            long reportedContentLength = this.codec.reportedContentLength(response);
            return new RealResponseBody(header, reportedContentLength, Okio.buffer((Source) new ResponseBodySource(this.codec.openResponseBodySource(response), reportedContentLength)));
        } catch (IOException e) {
            this.eventListener.responseFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public Headers trailers() throws IOException {
        return this.codec.trailers();
    }

    public void timeoutEarlyExit() {
        this.transmitter.timeoutEarlyExit();
    }

    public RealWebSocket.Streams newWebSocketStreams() throws SocketException {
        this.transmitter.timeoutEarlyExit();
        return this.codec.connection().newWebSocketStreams(this);
    }

    public void webSocketUpgradeFailed() {
        bodyComplete(-1, true, true, (IOException) null);
    }

    public void noNewExchangesOnConnection() {
        this.codec.connection().noNewExchanges();
    }

    public void cancel() {
        this.codec.cancel();
    }

    public void detachWithViolence() {
        this.codec.cancel();
        this.transmitter.exchangeMessageDone(this, true, true, (IOException) null);
    }

    /* access modifiers changed from: package-private */
    public void trackFailure(IOException iOException) {
        this.finder.trackFailure();
        this.codec.connection().trackFailure(iOException);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public IOException bodyComplete(long j, boolean z, boolean z2, @Nullable IOException iOException) {
        if (iOException != null) {
            trackFailure(iOException);
        }
        if (z2) {
            if (iOException != null) {
                this.eventListener.requestFailed(this.call, iOException);
            } else {
                this.eventListener.requestBodyEnd(this.call, j);
            }
        }
        if (z) {
            if (iOException != null) {
                this.eventListener.responseFailed(this.call, iOException);
            } else {
                this.eventListener.responseBodyEnd(this.call, j);
            }
        }
        return this.transmitter.exchangeMessageDone(this, z2, z, iOException);
    }

    public void noRequestBody() {
        this.transmitter.exchangeMessageDone(this, true, false, (IOException) null);
    }

    private final class RequestBodySink extends ForwardingSink {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private long contentLength;

        RequestBodySink(Sink sink, long j) {
            super(sink);
            this.contentLength = j;
        }

        public void write(Buffer buffer, long j) throws IOException {
            if (!this.closed) {
                long j2 = this.contentLength;
                if (j2 == -1 || this.bytesReceived + j <= j2) {
                    try {
                        super.write(buffer, j);
                        this.bytesReceived += j;
                    } catch (IOException e) {
                        throw complete(e);
                    }
                } else {
                    throw new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + j));
                }
            } else {
                throw new IllegalStateException("closed");
            }
        }

        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                throw complete(e);
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                long j = this.contentLength;
                if (j == -1 || this.bytesReceived == j) {
                    try {
                        super.close();
                        complete((IOException) null);
                    } catch (IOException e) {
                        throw complete(e);
                    }
                } else {
                    throw new ProtocolException("unexpected end of stream");
                }
            }
        }

        @Nullable
        private IOException complete(@Nullable IOException iOException) {
            if (this.completed) {
                return iOException;
            }
            this.completed = true;
            return Exchange.this.bodyComplete(this.bytesReceived, false, true, iOException);
        }
    }

    final class ResponseBodySource extends ForwardingSource {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;

        ResponseBodySource(Source source, long j) {
            super(source);
            this.contentLength = j;
            if (j == 0) {
                complete((IOException) null);
            }
        }

        public long read(Buffer buffer, long j) throws IOException {
            if (!this.closed) {
                try {
                    long read = delegate().read(buffer, j);
                    if (read == -1) {
                        complete((IOException) null);
                        return -1;
                    }
                    long j2 = this.bytesReceived + read;
                    if (this.contentLength != -1) {
                        if (j2 > this.contentLength) {
                            throw new ProtocolException("expected " + this.contentLength + " bytes but received " + j2);
                        }
                    }
                    this.bytesReceived = j2;
                    if (j2 == this.contentLength) {
                        complete((IOException) null);
                    }
                    return read;
                } catch (IOException e) {
                    throw complete(e);
                }
            } else {
                throw new IllegalStateException("closed");
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                try {
                    super.close();
                    complete((IOException) null);
                } catch (IOException e) {
                    throw complete(e);
                }
            }
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public IOException complete(@Nullable IOException iOException) {
            if (this.completed) {
                return iOException;
            }
            this.completed = true;
            return Exchange.this.bodyComplete(this.bytesReceived, true, false, iOException);
        }
    }
}
