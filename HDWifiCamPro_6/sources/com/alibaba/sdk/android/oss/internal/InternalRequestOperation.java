package com.alibaba.sdk.android.oss.internal;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.HttpMethod;
import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.utils.BinaryUtil;
import com.alibaba.sdk.android.oss.common.utils.CRC64;
import com.alibaba.sdk.android.oss.common.utils.DateUtil;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.alibaba.sdk.android.oss.common.utils.HttpUtil;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.common.utils.VersionInfoUtils;
import com.alibaba.sdk.android.oss.exception.InconsistentException;
import com.alibaba.sdk.android.oss.internal.ResponseParsers;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.AppendObjectRequest;
import com.alibaba.sdk.android.oss.model.AppendObjectResult;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.CopyObjectRequest;
import com.alibaba.sdk.android.oss.model.CopyObjectResult;
import com.alibaba.sdk.android.oss.model.CreateBucketRequest;
import com.alibaba.sdk.android.oss.model.CreateBucketResult;
import com.alibaba.sdk.android.oss.model.DeleteBucketLifecycleRequest;
import com.alibaba.sdk.android.oss.model.DeleteBucketLifecycleResult;
import com.alibaba.sdk.android.oss.model.DeleteBucketLoggingRequest;
import com.alibaba.sdk.android.oss.model.DeleteBucketLoggingResult;
import com.alibaba.sdk.android.oss.model.DeleteBucketRequest;
import com.alibaba.sdk.android.oss.model.DeleteBucketResult;
import com.alibaba.sdk.android.oss.model.DeleteMultipleObjectRequest;
import com.alibaba.sdk.android.oss.model.DeleteMultipleObjectResult;
import com.alibaba.sdk.android.oss.model.DeleteObjectRequest;
import com.alibaba.sdk.android.oss.model.DeleteObjectResult;
import com.alibaba.sdk.android.oss.model.DeleteObjectTaggingRequest;
import com.alibaba.sdk.android.oss.model.DeleteObjectTaggingResult;
import com.alibaba.sdk.android.oss.model.GetBucketACLRequest;
import com.alibaba.sdk.android.oss.model.GetBucketACLResult;
import com.alibaba.sdk.android.oss.model.GetBucketInfoRequest;
import com.alibaba.sdk.android.oss.model.GetBucketInfoResult;
import com.alibaba.sdk.android.oss.model.GetBucketLifecycleRequest;
import com.alibaba.sdk.android.oss.model.GetBucketLifecycleResult;
import com.alibaba.sdk.android.oss.model.GetBucketLoggingRequest;
import com.alibaba.sdk.android.oss.model.GetBucketLoggingResult;
import com.alibaba.sdk.android.oss.model.GetBucketRefererRequest;
import com.alibaba.sdk.android.oss.model.GetBucketRefererResult;
import com.alibaba.sdk.android.oss.model.GetObjectACLRequest;
import com.alibaba.sdk.android.oss.model.GetObjectACLResult;
import com.alibaba.sdk.android.oss.model.GetObjectMetaRequest;
import com.alibaba.sdk.android.oss.model.GetObjectMetaResult;
import com.alibaba.sdk.android.oss.model.GetObjectRequest;
import com.alibaba.sdk.android.oss.model.GetObjectResult;
import com.alibaba.sdk.android.oss.model.GetObjectTaggingRequest;
import com.alibaba.sdk.android.oss.model.GetObjectTaggingResult;
import com.alibaba.sdk.android.oss.model.GetSymlinkRequest;
import com.alibaba.sdk.android.oss.model.GetSymlinkResult;
import com.alibaba.sdk.android.oss.model.HeadObjectRequest;
import com.alibaba.sdk.android.oss.model.HeadObjectResult;
import com.alibaba.sdk.android.oss.model.ImagePersistRequest;
import com.alibaba.sdk.android.oss.model.ImagePersistResult;
import com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.ListBucketsRequest;
import com.alibaba.sdk.android.oss.model.ListBucketsResult;
import com.alibaba.sdk.android.oss.model.ListMultipartUploadsRequest;
import com.alibaba.sdk.android.oss.model.ListMultipartUploadsResult;
import com.alibaba.sdk.android.oss.model.ListObjectsRequest;
import com.alibaba.sdk.android.oss.model.ListObjectsResult;
import com.alibaba.sdk.android.oss.model.ListPartsRequest;
import com.alibaba.sdk.android.oss.model.ListPartsResult;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.OSSResult;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.model.PutBucketLifecycleRequest;
import com.alibaba.sdk.android.oss.model.PutBucketLifecycleResult;
import com.alibaba.sdk.android.oss.model.PutBucketLoggingRequest;
import com.alibaba.sdk.android.oss.model.PutBucketLoggingResult;
import com.alibaba.sdk.android.oss.model.PutBucketRefererRequest;
import com.alibaba.sdk.android.oss.model.PutBucketRefererResult;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.alibaba.sdk.android.oss.model.PutObjectTaggingRequest;
import com.alibaba.sdk.android.oss.model.PutObjectTaggingResult;
import com.alibaba.sdk.android.oss.model.PutSymlinkRequest;
import com.alibaba.sdk.android.oss.model.PutSymlinkResult;
import com.alibaba.sdk.android.oss.model.RestoreObjectRequest;
import com.alibaba.sdk.android.oss.model.RestoreObjectResult;
import com.alibaba.sdk.android.oss.model.TriggerCallbackRequest;
import com.alibaba.sdk.android.oss.model.TriggerCallbackResult;
import com.alibaba.sdk.android.oss.model.UploadPartRequest;
import com.alibaba.sdk.android.oss.model.UploadPartResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import com.alibaba.sdk.android.oss.network.OSSRequestTask;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import okhttp3.Cache;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;

public class InternalRequestOperation {
    private static final int LIST_PART_MAX_RETURNS = 1000;
    private static final int MAX_PART_NUMBER = 10000;
    private static ExecutorService executorService = Executors.newFixedThreadPool(5, new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "oss-android-api-thread");
        }
    });
    private Context applicationContext;
    private ClientConfiguration conf;
    private OSSCredentialProvider credentialProvider;
    private volatile URI endpoint;
    private OkHttpClient innerClient;
    private int maxRetryCount = 2;
    private URI service;

    public InternalRequestOperation(Context context, URI uri, OSSCredentialProvider oSSCredentialProvider, ClientConfiguration clientConfiguration) {
        this.applicationContext = context;
        this.endpoint = uri;
        this.credentialProvider = oSSCredentialProvider;
        this.conf = clientConfiguration;
        this.innerClient = buildOkHttpClient(uri.getHost(), clientConfiguration);
    }

    public InternalRequestOperation(Context context, OSSCredentialProvider oSSCredentialProvider, ClientConfiguration clientConfiguration) {
        try {
            this.service = new URI("http://oss.aliyuncs.com");
            this.endpoint = new URI("http://127.0.0.1");
            this.applicationContext = context;
            this.credentialProvider = oSSCredentialProvider;
            this.conf = clientConfiguration;
            this.innerClient = buildOkHttpClient(this.service.getHost(), clientConfiguration);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Endpoint must be a string like 'http://oss-cn-****.aliyuncs.com',or your cname like 'http://image.cnamedomain.com'!");
        }
    }

    private OkHttpClient buildOkHttpClient(final String str, ClientConfiguration clientConfiguration) {
        if (clientConfiguration.getOkHttpClient() != null) {
            return clientConfiguration.getOkHttpClient();
        }
        OkHttpClient.Builder hostnameVerifier = new OkHttpClient.Builder().followRedirects(clientConfiguration.isFollowRedirectsEnable()).followSslRedirects(clientConfiguration.isFollowRedirectsEnable()).retryOnConnectionFailure(false).cache((Cache) null).hostnameVerifier(new HostnameVerifier() {
            public boolean verify(String str, SSLSession sSLSession) {
                return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
            }
        });
        if (clientConfiguration != null) {
            Dispatcher dispatcher = new Dispatcher();
            dispatcher.setMaxRequests(clientConfiguration.getMaxConcurrentRequest());
            hostnameVerifier.connectTimeout((long) clientConfiguration.getConnectionTimeout(), TimeUnit.MILLISECONDS).readTimeout((long) clientConfiguration.getSocketTimeout(), TimeUnit.MILLISECONDS).writeTimeout((long) clientConfiguration.getSocketTimeout(), TimeUnit.MILLISECONDS).dispatcher(dispatcher);
            if (!(clientConfiguration.getProxyHost() == null || clientConfiguration.getProxyPort() == 0)) {
                hostnameVerifier.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(clientConfiguration.getProxyHost(), clientConfiguration.getProxyPort())));
            }
            this.maxRetryCount = clientConfiguration.getMaxErrorRetry();
        }
        return hostnameVerifier.build();
    }

    public PutObjectResult syncPutObject(PutObjectRequest putObjectRequest) throws ClientException, ServiceException {
        PutObjectResult result = putObject(putObjectRequest, (OSSCompletedCallback<PutObjectRequest, PutObjectResult>) null).getResult();
        checkCRC64(putObjectRequest, result);
        return result;
    }

    public OSSAsyncTask<PutObjectResult> putObject(PutObjectRequest putObjectRequest, final OSSCompletedCallback<PutObjectRequest, PutObjectResult> oSSCompletedCallback) {
        OSSLog.logDebug(" Internal putObject Start ");
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(putObjectRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.PUT);
        requestMessage.setBucketName(putObjectRequest.getBucketName());
        requestMessage.setObjectKey(putObjectRequest.getObjectKey());
        if (putObjectRequest.getUploadData() != null) {
            requestMessage.setUploadData(putObjectRequest.getUploadData());
        }
        if (putObjectRequest.getUploadFilePath() != null) {
            requestMessage.setUploadFilePath(putObjectRequest.getUploadFilePath());
        }
        if (putObjectRequest.getUploadUri() != null) {
            requestMessage.setUploadUri(putObjectRequest.getUploadUri());
        }
        if (putObjectRequest.getCallbackParam() != null) {
            requestMessage.getHeaders().put("x-oss-callback", OSSUtils.populateMapToBase64JsonString(putObjectRequest.getCallbackParam()));
        }
        if (putObjectRequest.getCallbackVars() != null) {
            requestMessage.getHeaders().put("x-oss-callback-var", OSSUtils.populateMapToBase64JsonString(putObjectRequest.getCallbackVars()));
        }
        OSSLog.logDebug(" populateRequestMetadata ");
        OSSUtils.populateRequestMetadata(requestMessage.getHeaders(), putObjectRequest.getMetadata());
        OSSLog.logDebug(" canonicalizeRequestMessage ");
        canonicalizeRequestMessage(requestMessage, putObjectRequest);
        OSSLog.logDebug(" ExecutionContext ");
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), putObjectRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
                public void onSuccess(PutObjectRequest putObjectRequest, PutObjectResult putObjectResult) {
                    InternalRequestOperation.this.checkCRC64(putObjectRequest, putObjectResult, oSSCompletedCallback);
                }

                public void onFailure(PutObjectRequest putObjectRequest, ClientException clientException, ServiceException serviceException) {
                    oSSCompletedCallback.onFailure(putObjectRequest, clientException, serviceException);
                }
            });
        }
        if (putObjectRequest.getRetryCallback() != null) {
            executionContext.setRetryCallback(putObjectRequest.getRetryCallback());
        }
        executionContext.setProgressCallback(putObjectRequest.getProgressCallback());
        OSSRequestTask oSSRequestTask = new OSSRequestTask(requestMessage, new ResponseParsers.PutObjectResponseParser(), executionContext, this.maxRetryCount);
        OSSLog.logDebug(" call OSSRequestTask ");
        return OSSAsyncTask.wrapRequestTask(executorService.submit(oSSRequestTask), executionContext);
    }

    public OSSAsyncTask<CreateBucketResult> createBucket(CreateBucketRequest createBucketRequest, OSSCompletedCallback<CreateBucketRequest, CreateBucketResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(createBucketRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.PUT);
        requestMessage.setBucketName(createBucketRequest.getBucketName());
        if (createBucketRequest.getBucketACL() != null) {
            requestMessage.getHeaders().put(OSSHeaders.OSS_CANNED_ACL, createBucketRequest.getBucketACL().toString());
        }
        try {
            HashMap hashMap = new HashMap();
            if (createBucketRequest.getLocationConstraint() != null) {
                hashMap.put(CreateBucketRequest.TAB_LOCATIONCONSTRAINT, createBucketRequest.getLocationConstraint());
            }
            hashMap.put(CreateBucketRequest.TAB_STORAGECLASS, createBucketRequest.getBucketStorageClass().toString());
            requestMessage.createBucketRequestBodyMarshall(hashMap);
            canonicalizeRequestMessage(requestMessage, createBucketRequest);
            ExecutionContext executionContext = new ExecutionContext(getInnerClient(), createBucketRequest, this.applicationContext);
            if (oSSCompletedCallback != null) {
                executionContext.setCompletedCallback(oSSCompletedCallback);
            }
            return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.CreateBucketResponseParser(), executionContext, this.maxRetryCount)), executionContext);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public OSSAsyncTask<DeleteBucketResult> deleteBucket(DeleteBucketRequest deleteBucketRequest, OSSCompletedCallback<DeleteBucketRequest, DeleteBucketResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(deleteBucketRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.DELETE);
        requestMessage.setBucketName(deleteBucketRequest.getBucketName());
        canonicalizeRequestMessage(requestMessage, deleteBucketRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), deleteBucketRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.DeleteBucketResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<GetBucketInfoResult> getBucketInfo(GetBucketInfoRequest getBucketInfoRequest, OSSCompletedCallback<GetBucketInfoRequest, GetBucketInfoResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.SUBRESOURCE_BUCKETINFO, "");
        requestMessage.setIsAuthorizationRequired(getBucketInfoRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.GET);
        requestMessage.setBucketName(getBucketInfoRequest.getBucketName());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, getBucketInfoRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), getBucketInfoRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.GetBucketInfoResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<GetBucketACLResult> getBucketACL(GetBucketACLRequest getBucketACLRequest, OSSCompletedCallback<GetBucketACLRequest, GetBucketACLResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.SUBRESOURCE_ACL, "");
        requestMessage.setIsAuthorizationRequired(getBucketACLRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.GET);
        requestMessage.setBucketName(getBucketACLRequest.getBucketName());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, getBucketACLRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), getBucketACLRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.GetBucketACLResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<PutBucketRefererResult> putBucketReferer(PutBucketRefererRequest putBucketRefererRequest, OSSCompletedCallback<PutBucketRefererRequest, PutBucketRefererResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.SUBRESOURCE_REFERER, "");
        requestMessage.setIsAuthorizationRequired(putBucketRefererRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.PUT);
        requestMessage.setBucketName(putBucketRefererRequest.getBucketName());
        requestMessage.setParameters(linkedHashMap);
        try {
            requestMessage.putBucketRefererRequestBodyMarshall(putBucketRefererRequest.getReferers(), putBucketRefererRequest.isAllowEmpty());
            canonicalizeRequestMessage(requestMessage, putBucketRefererRequest);
            ExecutionContext executionContext = new ExecutionContext(getInnerClient(), putBucketRefererRequest, this.applicationContext);
            if (oSSCompletedCallback != null) {
                executionContext.setCompletedCallback(oSSCompletedCallback);
            }
            return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.PutBucketRefererResponseParser(), executionContext, this.maxRetryCount)), executionContext);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public OSSAsyncTask<GetBucketRefererResult> getBucketReferer(GetBucketRefererRequest getBucketRefererRequest, OSSCompletedCallback<GetBucketRefererRequest, GetBucketRefererResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.SUBRESOURCE_REFERER, "");
        requestMessage.setIsAuthorizationRequired(getBucketRefererRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.GET);
        requestMessage.setBucketName(getBucketRefererRequest.getBucketName());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, getBucketRefererRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), getBucketRefererRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.GetBucketRefererResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<PutBucketLoggingResult> putBucketLogging(PutBucketLoggingRequest putBucketLoggingRequest, OSSCompletedCallback<PutBucketLoggingRequest, PutBucketLoggingResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.SUBRESOURCE_LOGGING, "");
        requestMessage.setIsAuthorizationRequired(putBucketLoggingRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.PUT);
        requestMessage.setBucketName(putBucketLoggingRequest.getBucketName());
        requestMessage.setParameters(linkedHashMap);
        try {
            requestMessage.putBucketLoggingRequestBodyMarshall(putBucketLoggingRequest.getTargetBucketName(), putBucketLoggingRequest.getTargetPrefix());
            canonicalizeRequestMessage(requestMessage, putBucketLoggingRequest);
            ExecutionContext executionContext = new ExecutionContext(getInnerClient(), putBucketLoggingRequest, this.applicationContext);
            if (oSSCompletedCallback != null) {
                executionContext.setCompletedCallback(oSSCompletedCallback);
            }
            return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.PutBucketLoggingResponseParser(), executionContext, this.maxRetryCount)), executionContext);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public OSSAsyncTask<GetBucketLoggingResult> getBucketLogging(GetBucketLoggingRequest getBucketLoggingRequest, OSSCompletedCallback<GetBucketLoggingRequest, GetBucketLoggingResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.SUBRESOURCE_LOGGING, "");
        requestMessage.setIsAuthorizationRequired(getBucketLoggingRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.GET);
        requestMessage.setBucketName(getBucketLoggingRequest.getBucketName());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, getBucketLoggingRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), getBucketLoggingRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.GetBucketLoggingResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<DeleteBucketLoggingResult> deleteBucketLogging(DeleteBucketLoggingRequest deleteBucketLoggingRequest, OSSCompletedCallback<DeleteBucketLoggingRequest, DeleteBucketLoggingResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.SUBRESOURCE_LOGGING, "");
        requestMessage.setIsAuthorizationRequired(deleteBucketLoggingRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.DELETE);
        requestMessage.setBucketName(deleteBucketLoggingRequest.getBucketName());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, deleteBucketLoggingRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), deleteBucketLoggingRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.DeleteBucketLoggingResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<PutBucketLifecycleResult> putBucketLifecycle(PutBucketLifecycleRequest putBucketLifecycleRequest, OSSCompletedCallback<PutBucketLifecycleRequest, PutBucketLifecycleResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.SUBRESOURCE_LIFECYCLE, "");
        requestMessage.setIsAuthorizationRequired(putBucketLifecycleRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.PUT);
        requestMessage.setBucketName(putBucketLifecycleRequest.getBucketName());
        requestMessage.setParameters(linkedHashMap);
        try {
            requestMessage.putBucketLifecycleRequestBodyMarshall(putBucketLifecycleRequest.getLifecycleRules());
            canonicalizeRequestMessage(requestMessage, putBucketLifecycleRequest);
            ExecutionContext executionContext = new ExecutionContext(getInnerClient(), putBucketLifecycleRequest, this.applicationContext);
            if (oSSCompletedCallback != null) {
                executionContext.setCompletedCallback(oSSCompletedCallback);
            }
            return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.PutBucketLifecycleResponseParser(), executionContext, this.maxRetryCount)), executionContext);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public OSSAsyncTask<GetBucketLifecycleResult> getBucketLifecycle(GetBucketLifecycleRequest getBucketLifecycleRequest, OSSCompletedCallback<GetBucketLifecycleRequest, GetBucketLifecycleResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.SUBRESOURCE_LIFECYCLE, "");
        requestMessage.setIsAuthorizationRequired(getBucketLifecycleRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.GET);
        requestMessage.setBucketName(getBucketLifecycleRequest.getBucketName());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, getBucketLifecycleRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), getBucketLifecycleRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.GetBucketLifecycleResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<DeleteBucketLifecycleResult> deleteBucketLifecycle(DeleteBucketLifecycleRequest deleteBucketLifecycleRequest, OSSCompletedCallback<DeleteBucketLifecycleRequest, DeleteBucketLifecycleResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.SUBRESOURCE_LIFECYCLE, "");
        requestMessage.setIsAuthorizationRequired(deleteBucketLifecycleRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.DELETE);
        requestMessage.setBucketName(deleteBucketLifecycleRequest.getBucketName());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, deleteBucketLifecycleRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), deleteBucketLifecycleRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.DeleteBucketLifecycleResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public AppendObjectResult syncAppendObject(AppendObjectRequest appendObjectRequest) throws ClientException, ServiceException {
        AppendObjectResult result = appendObject(appendObjectRequest, (OSSCompletedCallback<AppendObjectRequest, AppendObjectResult>) null).getResult();
        boolean z = appendObjectRequest.getCRC64() == OSSRequest.CRC64Config.YES;
        if (appendObjectRequest.getInitCRC64() != null && z) {
            result.setClientCRC(Long.valueOf(CRC64.combine(appendObjectRequest.getInitCRC64().longValue(), result.getClientCRC().longValue(), result.getNextPosition() - appendObjectRequest.getPosition())));
        }
        checkCRC64(appendObjectRequest, result);
        return result;
    }

    public OSSAsyncTask<AppendObjectResult> appendObject(AppendObjectRequest appendObjectRequest, final OSSCompletedCallback<AppendObjectRequest, AppendObjectResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(appendObjectRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.POST);
        requestMessage.setBucketName(appendObjectRequest.getBucketName());
        requestMessage.setObjectKey(appendObjectRequest.getObjectKey());
        if (appendObjectRequest.getUploadData() != null) {
            requestMessage.setUploadData(appendObjectRequest.getUploadData());
        }
        if (appendObjectRequest.getUploadFilePath() != null) {
            requestMessage.setUploadFilePath(appendObjectRequest.getUploadFilePath());
        }
        if (appendObjectRequest.getUploadUri() != null) {
            requestMessage.setUploadUri(appendObjectRequest.getUploadUri());
        }
        requestMessage.getParameters().put(RequestParameters.SUBRESOURCE_APPEND, "");
        requestMessage.getParameters().put("position", String.valueOf(appendObjectRequest.getPosition()));
        OSSUtils.populateRequestMetadata(requestMessage.getHeaders(), appendObjectRequest.getMetadata());
        canonicalizeRequestMessage(requestMessage, appendObjectRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), appendObjectRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(new OSSCompletedCallback<AppendObjectRequest, AppendObjectResult>() {
                public void onSuccess(AppendObjectRequest appendObjectRequest, AppendObjectResult appendObjectResult) {
                    boolean z = appendObjectRequest.getCRC64() == OSSRequest.CRC64Config.YES;
                    if (appendObjectRequest.getInitCRC64() != null && z) {
                        appendObjectResult.setClientCRC(Long.valueOf(CRC64.combine(appendObjectRequest.getInitCRC64().longValue(), appendObjectResult.getClientCRC().longValue(), appendObjectResult.getNextPosition() - appendObjectRequest.getPosition())));
                    }
                    InternalRequestOperation.this.checkCRC64(appendObjectRequest, appendObjectResult, oSSCompletedCallback);
                }

                public void onFailure(AppendObjectRequest appendObjectRequest, ClientException clientException, ServiceException serviceException) {
                    oSSCompletedCallback.onFailure(appendObjectRequest, clientException, serviceException);
                }
            });
        }
        executionContext.setProgressCallback(appendObjectRequest.getProgressCallback());
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.AppendObjectResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<HeadObjectResult> headObject(HeadObjectRequest headObjectRequest, OSSCompletedCallback<HeadObjectRequest, HeadObjectResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(headObjectRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.HEAD);
        requestMessage.setBucketName(headObjectRequest.getBucketName());
        requestMessage.setObjectKey(headObjectRequest.getObjectKey());
        canonicalizeRequestMessage(requestMessage, headObjectRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), headObjectRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.HeadObjectResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<GetObjectMetaResult> getObjectMeta(GetObjectMetaRequest getObjectMetaRequest, OSSCompletedCallback<GetObjectMetaRequest, GetObjectMetaResult> oSSCompletedCallback) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.SUBRESOURCE_OBJECT_META, "");
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(getObjectMetaRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.HEAD);
        requestMessage.setBucketName(getObjectMetaRequest.getBucketName());
        requestMessage.setObjectKey(getObjectMetaRequest.getObjectKey());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, getObjectMetaRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), getObjectMetaRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.GetObjectMetaResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<GetObjectResult> getObject(GetObjectRequest getObjectRequest, OSSCompletedCallback<GetObjectRequest, GetObjectResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(getObjectRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.GET);
        requestMessage.setBucketName(getObjectRequest.getBucketName());
        requestMessage.setObjectKey(getObjectRequest.getObjectKey());
        if (getObjectRequest.getRange() != null) {
            requestMessage.getHeaders().put("Range", getObjectRequest.getRange().toString());
        }
        if (getObjectRequest.getxOssProcess() != null) {
            requestMessage.getParameters().put(RequestParameters.X_OSS_PROCESS, getObjectRequest.getxOssProcess());
        }
        canonicalizeRequestMessage(requestMessage, getObjectRequest);
        if (getObjectRequest.getRequestHeaders() != null) {
            for (Map.Entry next : getObjectRequest.getRequestHeaders().entrySet()) {
                requestMessage.getHeaders().put(next.getKey(), next.getValue());
            }
        }
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), getObjectRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        executionContext.setProgressCallback(getObjectRequest.getProgressListener());
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.GetObjectResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<GetObjectACLResult> getObjectACL(GetObjectACLRequest getObjectACLRequest, OSSCompletedCallback<GetObjectACLRequest, GetObjectACLResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.SUBRESOURCE_ACL, "");
        requestMessage.setIsAuthorizationRequired(getObjectACLRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.GET);
        requestMessage.setParameters(linkedHashMap);
        requestMessage.setBucketName(getObjectACLRequest.getBucketName());
        requestMessage.setObjectKey(getObjectACLRequest.getObjectKey());
        canonicalizeRequestMessage(requestMessage, getObjectACLRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), getObjectACLRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.GetObjectACLResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<CopyObjectResult> copyObject(CopyObjectRequest copyObjectRequest, OSSCompletedCallback<CopyObjectRequest, CopyObjectResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(copyObjectRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.PUT);
        requestMessage.setBucketName(copyObjectRequest.getDestinationBucketName());
        requestMessage.setObjectKey(copyObjectRequest.getDestinationKey());
        OSSUtils.populateCopyObjectHeaders(copyObjectRequest, requestMessage.getHeaders());
        canonicalizeRequestMessage(requestMessage, copyObjectRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), copyObjectRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.CopyObjectResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<DeleteObjectResult> deleteObject(DeleteObjectRequest deleteObjectRequest, OSSCompletedCallback<DeleteObjectRequest, DeleteObjectResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(deleteObjectRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.DELETE);
        requestMessage.setBucketName(deleteObjectRequest.getBucketName());
        requestMessage.setObjectKey(deleteObjectRequest.getObjectKey());
        canonicalizeRequestMessage(requestMessage, deleteObjectRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), deleteObjectRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.DeleteObjectResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<DeleteMultipleObjectResult> deleteMultipleObject(DeleteMultipleObjectRequest deleteMultipleObjectRequest, OSSCompletedCallback<DeleteMultipleObjectRequest, DeleteMultipleObjectResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.SUBRESOURCE_DELETE, "");
        requestMessage.setIsAuthorizationRequired(deleteMultipleObjectRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.POST);
        requestMessage.setBucketName(deleteMultipleObjectRequest.getBucketName());
        requestMessage.setParameters(linkedHashMap);
        try {
            byte[] deleteMultipleObjectRequestBodyMarshall = requestMessage.deleteMultipleObjectRequestBodyMarshall(deleteMultipleObjectRequest.getObjectKeys(), deleteMultipleObjectRequest.getQuiet().booleanValue());
            if (deleteMultipleObjectRequestBodyMarshall != null && deleteMultipleObjectRequestBodyMarshall.length > 0) {
                requestMessage.getHeaders().put(HttpHeaders.CONTENT_MD5, BinaryUtil.calculateBase64Md5(deleteMultipleObjectRequestBodyMarshall));
                requestMessage.getHeaders().put(HttpHeaders.CONTENT_LENGTH, String.valueOf(deleteMultipleObjectRequestBodyMarshall.length));
            }
            canonicalizeRequestMessage(requestMessage, deleteMultipleObjectRequest);
            ExecutionContext executionContext = new ExecutionContext(getInnerClient(), deleteMultipleObjectRequest, this.applicationContext);
            if (oSSCompletedCallback != null) {
                executionContext.setCompletedCallback(oSSCompletedCallback);
            }
            return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.DeleteMultipleObjectResponseParser(), executionContext, this.maxRetryCount)), executionContext);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public OSSAsyncTask<ListBucketsResult> listBuckets(ListBucketsRequest listBucketsRequest, OSSCompletedCallback<ListBucketsRequest, ListBucketsResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(listBucketsRequest.isAuthorizationRequired());
        requestMessage.setMethod(HttpMethod.GET);
        requestMessage.setService(this.service);
        requestMessage.setEndpoint(this.endpoint);
        canonicalizeRequestMessage(requestMessage, listBucketsRequest);
        OSSUtils.populateListBucketRequestParameters(listBucketsRequest, requestMessage.getParameters());
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), listBucketsRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.ListBucketResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<ListObjectsResult> listObjects(ListObjectsRequest listObjectsRequest, OSSCompletedCallback<ListObjectsRequest, ListObjectsResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(listObjectsRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.GET);
        requestMessage.setBucketName(listObjectsRequest.getBucketName());
        canonicalizeRequestMessage(requestMessage, listObjectsRequest);
        OSSUtils.populateListObjectsRequestParameters(listObjectsRequest, requestMessage.getParameters());
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), listObjectsRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.ListObjectsResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<InitiateMultipartUploadResult> initMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest, OSSCompletedCallback<InitiateMultipartUploadRequest, InitiateMultipartUploadResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(initiateMultipartUploadRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.POST);
        requestMessage.setBucketName(initiateMultipartUploadRequest.getBucketName());
        requestMessage.setObjectKey(initiateMultipartUploadRequest.getObjectKey());
        requestMessage.getParameters().put(RequestParameters.SUBRESOURCE_UPLOADS, "");
        if (initiateMultipartUploadRequest.isSequential) {
            requestMessage.getParameters().put(RequestParameters.SUBRESOURCE_SEQUENTIAL, "");
        }
        OSSUtils.populateRequestMetadata(requestMessage.getHeaders(), initiateMultipartUploadRequest.getMetadata());
        canonicalizeRequestMessage(requestMessage, initiateMultipartUploadRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), initiateMultipartUploadRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.InitMultipartResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public UploadPartResult syncUploadPart(UploadPartRequest uploadPartRequest) throws ClientException, ServiceException {
        UploadPartResult result = uploadPart(uploadPartRequest, (OSSCompletedCallback<UploadPartRequest, UploadPartResult>) null).getResult();
        checkCRC64(uploadPartRequest, result);
        return result;
    }

    public OSSAsyncTask<UploadPartResult> uploadPart(UploadPartRequest uploadPartRequest, final OSSCompletedCallback<UploadPartRequest, UploadPartResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(uploadPartRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.PUT);
        requestMessage.setBucketName(uploadPartRequest.getBucketName());
        requestMessage.setObjectKey(uploadPartRequest.getObjectKey());
        requestMessage.getParameters().put(RequestParameters.UPLOAD_ID, uploadPartRequest.getUploadId());
        requestMessage.getParameters().put(RequestParameters.PART_NUMBER, String.valueOf(uploadPartRequest.getPartNumber()));
        requestMessage.setUploadData(uploadPartRequest.getPartContent());
        if (uploadPartRequest.getMd5Digest() != null) {
            requestMessage.getHeaders().put(HttpHeaders.CONTENT_MD5, uploadPartRequest.getMd5Digest());
        }
        canonicalizeRequestMessage(requestMessage, uploadPartRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), uploadPartRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(new OSSCompletedCallback<UploadPartRequest, UploadPartResult>() {
                public void onSuccess(UploadPartRequest uploadPartRequest, UploadPartResult uploadPartResult) {
                    InternalRequestOperation.this.checkCRC64(uploadPartRequest, uploadPartResult, oSSCompletedCallback);
                }

                public void onFailure(UploadPartRequest uploadPartRequest, ClientException clientException, ServiceException serviceException) {
                    oSSCompletedCallback.onFailure(uploadPartRequest, clientException, serviceException);
                }
            });
        }
        executionContext.setProgressCallback(uploadPartRequest.getProgressCallback());
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.UploadPartResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public CompleteMultipartUploadResult syncCompleteMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest) throws ClientException, ServiceException {
        CompleteMultipartUploadResult result = completeMultipartUpload(completeMultipartUploadRequest, (OSSCompletedCallback<CompleteMultipartUploadRequest, CompleteMultipartUploadResult>) null).getResult();
        if (result.getServerCRC() != null) {
            result.setClientCRC(Long.valueOf(calcObjectCRCFromParts(completeMultipartUploadRequest.getPartETags())));
        }
        checkCRC64(completeMultipartUploadRequest, result);
        return result;
    }

    public OSSAsyncTask<CompleteMultipartUploadResult> completeMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest, final OSSCompletedCallback<CompleteMultipartUploadRequest, CompleteMultipartUploadResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(completeMultipartUploadRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.POST);
        requestMessage.setBucketName(completeMultipartUploadRequest.getBucketName());
        requestMessage.setObjectKey(completeMultipartUploadRequest.getObjectKey());
        requestMessage.setStringBody(OSSUtils.buildXMLFromPartEtagList(completeMultipartUploadRequest.getPartETags()));
        requestMessage.getParameters().put(RequestParameters.UPLOAD_ID, completeMultipartUploadRequest.getUploadId());
        if (completeMultipartUploadRequest.getCallbackParam() != null) {
            requestMessage.getHeaders().put("x-oss-callback", OSSUtils.populateMapToBase64JsonString(completeMultipartUploadRequest.getCallbackParam()));
        }
        if (completeMultipartUploadRequest.getCallbackVars() != null) {
            requestMessage.getHeaders().put("x-oss-callback-var", OSSUtils.populateMapToBase64JsonString(completeMultipartUploadRequest.getCallbackVars()));
        }
        OSSUtils.populateRequestMetadata(requestMessage.getHeaders(), completeMultipartUploadRequest.getMetadata());
        canonicalizeRequestMessage(requestMessage, completeMultipartUploadRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), completeMultipartUploadRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(new OSSCompletedCallback<CompleteMultipartUploadRequest, CompleteMultipartUploadResult>() {
                public void onSuccess(CompleteMultipartUploadRequest completeMultipartUploadRequest, CompleteMultipartUploadResult completeMultipartUploadResult) {
                    if (completeMultipartUploadResult.getServerCRC() != null) {
                        completeMultipartUploadResult.setClientCRC(Long.valueOf(InternalRequestOperation.this.calcObjectCRCFromParts(completeMultipartUploadRequest.getPartETags())));
                    }
                    InternalRequestOperation.this.checkCRC64(completeMultipartUploadRequest, completeMultipartUploadResult, oSSCompletedCallback);
                }

                public void onFailure(CompleteMultipartUploadRequest completeMultipartUploadRequest, ClientException clientException, ServiceException serviceException) {
                    oSSCompletedCallback.onFailure(completeMultipartUploadRequest, clientException, serviceException);
                }
            });
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.CompleteMultipartUploadResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<AbortMultipartUploadResult> abortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest, OSSCompletedCallback<AbortMultipartUploadRequest, AbortMultipartUploadResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(abortMultipartUploadRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.DELETE);
        requestMessage.setBucketName(abortMultipartUploadRequest.getBucketName());
        requestMessage.setObjectKey(abortMultipartUploadRequest.getObjectKey());
        requestMessage.getParameters().put(RequestParameters.UPLOAD_ID, abortMultipartUploadRequest.getUploadId());
        canonicalizeRequestMessage(requestMessage, abortMultipartUploadRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), abortMultipartUploadRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.AbortMultipartUploadResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<ListPartsResult> listParts(ListPartsRequest listPartsRequest, OSSCompletedCallback<ListPartsRequest, ListPartsResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(listPartsRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.GET);
        requestMessage.setBucketName(listPartsRequest.getBucketName());
        requestMessage.setObjectKey(listPartsRequest.getObjectKey());
        requestMessage.getParameters().put(RequestParameters.UPLOAD_ID, listPartsRequest.getUploadId());
        Integer maxParts = listPartsRequest.getMaxParts();
        if (maxParts != null) {
            if (OSSUtils.checkParamRange((long) maxParts.intValue(), 0, true, 1000, true)) {
                requestMessage.getParameters().put(RequestParameters.MAX_PARTS, maxParts.toString());
            } else {
                throw new IllegalArgumentException("MaxPartsOutOfRange: 1000");
            }
        }
        Integer partNumberMarker = listPartsRequest.getPartNumberMarker();
        if (partNumberMarker != null) {
            if (OSSUtils.checkParamRange((long) partNumberMarker.intValue(), 0, false, WorkRequest.MIN_BACKOFF_MILLIS, true)) {
                requestMessage.getParameters().put(RequestParameters.PART_NUMBER_MARKER, partNumberMarker.toString());
            } else {
                throw new IllegalArgumentException("PartNumberMarkerOutOfRange: 10000");
            }
        }
        canonicalizeRequestMessage(requestMessage, listPartsRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), listPartsRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.ListPartsResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public OSSAsyncTask<ListMultipartUploadsResult> listMultipartUploads(ListMultipartUploadsRequest listMultipartUploadsRequest, OSSCompletedCallback<ListMultipartUploadsRequest, ListMultipartUploadsResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setIsAuthorizationRequired(listMultipartUploadsRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.GET);
        requestMessage.setBucketName(listMultipartUploadsRequest.getBucketName());
        requestMessage.getParameters().put(RequestParameters.SUBRESOURCE_UPLOADS, "");
        OSSUtils.populateListMultipartUploadsRequestParameters(listMultipartUploadsRequest, requestMessage.getParameters());
        canonicalizeRequestMessage(requestMessage, listMultipartUploadsRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), listMultipartUploadsRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.ListMultipartUploadsResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    private boolean checkIfHttpDnsAvailable(boolean z) {
        String str;
        boolean z2 = false;
        if (!z || this.applicationContext == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            z2 = true;
        }
        if (z2) {
            str = System.getProperty("http.proxyHost");
        } else {
            str = android.net.Proxy.getHost(this.applicationContext);
        }
        String proxyHost = this.conf.getProxyHost();
        if (!TextUtils.isEmpty(proxyHost)) {
            str = proxyHost;
        }
        return TextUtils.isEmpty(str);
    }

    public OkHttpClient getInnerClient() {
        return this.innerClient;
    }

    private void canonicalizeRequestMessage(RequestMessage requestMessage, OSSRequest oSSRequest) {
        Map headers = requestMessage.getHeaders();
        if (headers.get(HttpHeaders.DATE) == null) {
            headers.put(HttpHeaders.DATE, DateUtil.currentFixedSkewedTimeInRFC822Format());
        }
        if ((requestMessage.getMethod() == HttpMethod.POST || requestMessage.getMethod() == HttpMethod.PUT) && OSSUtils.isEmptyString((String) headers.get(HttpHeaders.CONTENT_TYPE))) {
            headers.put(HttpHeaders.CONTENT_TYPE, OSSUtils.determineContentType((String) null, requestMessage.getUploadFilePath(), requestMessage.getObjectKey()));
        }
        requestMessage.setHttpDnsEnable(checkIfHttpDnsAvailable(this.conf.isHttpDnsEnable()));
        requestMessage.setCredentialProvider(this.credentialProvider);
        requestMessage.setPathStyleAccessEnable(this.conf.isPathStyleAccessEnable());
        requestMessage.setCustomPathPrefixEnable(this.conf.isCustomPathPrefixEnable());
        requestMessage.setIpWithHeader(this.conf.getIpWithHeader());
        requestMessage.getHeaders().put("User-Agent", VersionInfoUtils.getUserAgent(this.conf.getCustomUserMark()));
        boolean z = false;
        if (requestMessage.getHeaders().containsKey("Range") || requestMessage.getParameters().containsKey(RequestParameters.X_OSS_PROCESS)) {
            requestMessage.setCheckCRC64(false);
        }
        requestMessage.setIsInCustomCnameExcludeList(OSSUtils.isInCustomCnameExcludeList(this.endpoint.getHost(), this.conf.getCustomCnameExcludeList()));
        if (oSSRequest.getCRC64() == OSSRequest.CRC64Config.NULL) {
            z = this.conf.isCheckCRC64();
        } else if (oSSRequest.getCRC64() == OSSRequest.CRC64Config.YES) {
            z = true;
        }
        requestMessage.setCheckCRC64(z);
        oSSRequest.setCRC64(z ? OSSRequest.CRC64Config.YES : OSSRequest.CRC64Config.NO);
    }

    public void setCredentialProvider(OSSCredentialProvider oSSCredentialProvider) {
        this.credentialProvider = oSSCredentialProvider;
    }

    private <Request extends OSSRequest, Result extends OSSResult> void checkCRC64(Request request, Result result) throws ClientException {
        if (request.getCRC64() == OSSRequest.CRC64Config.YES) {
            try {
                OSSUtils.checkChecksum(result.getClientCRC(), result.getServerCRC(), result.getRequestId());
            } catch (InconsistentException e) {
                throw new ClientException(e.getMessage(), e);
            }
        }
    }

    /* access modifiers changed from: private */
    public <Request extends OSSRequest, Result extends OSSResult> void checkCRC64(Request request, Result result, OSSCompletedCallback<Request, Result> oSSCompletedCallback) {
        try {
            checkCRC64(request, result);
            if (oSSCompletedCallback != null) {
                oSSCompletedCallback.onSuccess(request, result);
            }
        } catch (ClientException e) {
            if (oSSCompletedCallback != null) {
                oSSCompletedCallback.onFailure(request, e, (ServiceException) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public long calcObjectCRCFromParts(List<PartETag> list) {
        long j = 0;
        for (PartETag next : list) {
            if (next.getCRC64() == 0 || next.getPartSize() <= 0) {
                return 0;
            }
            j = CRC64.combine(j, next.getCRC64(), next.getPartSize());
        }
        return j;
    }

    public Context getApplicationContext() {
        return this.applicationContext;
    }

    public ClientConfiguration getConf() {
        return this.conf;
    }

    public OSSAsyncTask<TriggerCallbackResult> triggerCallback(TriggerCallbackRequest triggerCallbackRequest, OSSCompletedCallback<TriggerCallbackRequest, TriggerCallbackResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.X_OSS_PROCESS, "");
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.POST);
        requestMessage.setBucketName(triggerCallbackRequest.getBucketName());
        requestMessage.setObjectKey(triggerCallbackRequest.getObjectKey());
        requestMessage.setParameters(linkedHashMap);
        String buildTriggerCallbackBody = OSSUtils.buildTriggerCallbackBody(triggerCallbackRequest.getCallbackParam(), triggerCallbackRequest.getCallbackVars());
        requestMessage.setStringBody(buildTriggerCallbackBody);
        requestMessage.getHeaders().put(HttpHeaders.CONTENT_MD5, BinaryUtil.calculateBase64Md5(buildTriggerCallbackBody.getBytes()));
        canonicalizeRequestMessage(requestMessage, triggerCallbackRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), triggerCallbackRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.TriggerCallbackResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public TriggerCallbackResult asyncTriggerCallback(TriggerCallbackRequest triggerCallbackRequest) throws ClientException, ServiceException {
        return triggerCallback(triggerCallbackRequest, (OSSCompletedCallback<TriggerCallbackRequest, TriggerCallbackResult>) null).getResult();
    }

    public OSSAsyncTask<ImagePersistResult> imageActionPersist(ImagePersistRequest imagePersistRequest, OSSCompletedCallback<ImagePersistRequest, ImagePersistResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.X_OSS_PROCESS, "");
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.POST);
        requestMessage.setBucketName(imagePersistRequest.mFromBucket);
        requestMessage.setObjectKey(imagePersistRequest.mFromObjectkey);
        requestMessage.setParameters(linkedHashMap);
        requestMessage.setStringBody(OSSUtils.buildImagePersistentBody(imagePersistRequest.mToBucketName, imagePersistRequest.mToObjectKey, imagePersistRequest.mAction));
        canonicalizeRequestMessage(requestMessage, imagePersistRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), imagePersistRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.ImagePersistResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public PutSymlinkResult syncPutSymlink(PutSymlinkRequest putSymlinkRequest) throws ClientException, ServiceException {
        return putSymlink(putSymlinkRequest, (OSSCompletedCallback<PutSymlinkRequest, PutSymlinkResult>) null).getResult();
    }

    public OSSAsyncTask<PutSymlinkResult> putSymlink(PutSymlinkRequest putSymlinkRequest, OSSCompletedCallback<PutSymlinkRequest, PutSymlinkResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.X_OSS_SYMLINK, "");
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.PUT);
        requestMessage.setBucketName(putSymlinkRequest.getBucketName());
        requestMessage.setObjectKey(putSymlinkRequest.getObjectKey());
        requestMessage.setParameters(linkedHashMap);
        if (!OSSUtils.isEmptyString(putSymlinkRequest.getTargetObjectName())) {
            requestMessage.getHeaders().put(OSSHeaders.OSS_HEADER_SYMLINK_TARGET, HttpUtil.urlEncode(putSymlinkRequest.getTargetObjectName(), "utf-8"));
        }
        OSSUtils.populateRequestMetadata(requestMessage.getHeaders(), putSymlinkRequest.getMetadata());
        canonicalizeRequestMessage(requestMessage, putSymlinkRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), putSymlinkRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.PutSymlinkResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public GetSymlinkResult syncGetSymlink(GetSymlinkRequest getSymlinkRequest) throws ClientException, ServiceException {
        return getSymlink(getSymlinkRequest, (OSSCompletedCallback<GetSymlinkRequest, GetSymlinkResult>) null).getResult();
    }

    public OSSAsyncTask<GetSymlinkResult> getSymlink(GetSymlinkRequest getSymlinkRequest, OSSCompletedCallback<GetSymlinkRequest, GetSymlinkResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.X_OSS_SYMLINK, "");
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.GET);
        requestMessage.setBucketName(getSymlinkRequest.getBucketName());
        requestMessage.setObjectKey(getSymlinkRequest.getObjectKey());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, getSymlinkRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), getSymlinkRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.GetSymlinkResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public RestoreObjectResult syncRestoreObject(RestoreObjectRequest restoreObjectRequest) throws ClientException, ServiceException {
        return restoreObject(restoreObjectRequest, (OSSCompletedCallback<RestoreObjectRequest, RestoreObjectResult>) null).getResult();
    }

    public OSSAsyncTask<RestoreObjectResult> restoreObject(RestoreObjectRequest restoreObjectRequest, OSSCompletedCallback<RestoreObjectRequest, RestoreObjectResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.X_OSS_RESTORE, "");
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.POST);
        requestMessage.setBucketName(restoreObjectRequest.getBucketName());
        requestMessage.setObjectKey(restoreObjectRequest.getObjectKey());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, restoreObjectRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), restoreObjectRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.RestoreObjectResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public PutObjectTaggingResult syncPutObjectTagging(PutObjectTaggingRequest putObjectTaggingRequest) throws ClientException, ServiceException {
        return putObjectTagging(putObjectTaggingRequest, (OSSCompletedCallback<PutObjectTaggingRequest, PutObjectTaggingResult>) null).getResult();
    }

    public OSSAsyncTask<PutObjectTaggingResult> putObjectTagging(PutObjectTaggingRequest putObjectTaggingRequest, OSSCompletedCallback<PutObjectTaggingRequest, PutObjectTaggingResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.X_OSS_TAGGING, "");
        requestMessage.setIsAuthorizationRequired(putObjectTaggingRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.PUT);
        requestMessage.setBucketName(putObjectTaggingRequest.getBucketName());
        requestMessage.setObjectKey(putObjectTaggingRequest.getObjectKey());
        requestMessage.setParameters(linkedHashMap);
        try {
            byte[] putObjectTaggingRequestBodyMarshall = requestMessage.putObjectTaggingRequestBodyMarshall(putObjectTaggingRequest.getTags());
            if (putObjectTaggingRequestBodyMarshall != null && putObjectTaggingRequestBodyMarshall.length > 0) {
                requestMessage.getHeaders().put(HttpHeaders.CONTENT_MD5, BinaryUtil.calculateBase64Md5(putObjectTaggingRequestBodyMarshall));
                requestMessage.getHeaders().put(HttpHeaders.CONTENT_LENGTH, String.valueOf(putObjectTaggingRequestBodyMarshall.length));
            }
            canonicalizeRequestMessage(requestMessage, putObjectTaggingRequest);
            ExecutionContext executionContext = new ExecutionContext(getInnerClient(), putObjectTaggingRequest, this.applicationContext);
            if (oSSCompletedCallback != null) {
                executionContext.setCompletedCallback(oSSCompletedCallback);
            }
            return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.PutObjectTaggingResponseParser(), executionContext, this.maxRetryCount)), executionContext);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            if (oSSCompletedCallback != null) {
                oSSCompletedCallback.onFailure(putObjectTaggingRequest, new ClientException(e.getMessage(), e), (ServiceException) null);
            }
            return OSSAsyncTask.wrapRequestTask(executorService.submit(new Callable() {
                public Object call() throws Exception {
                    throw e;
                }
            }), (ExecutionContext) null);
        }
    }

    public GetObjectTaggingResult syncGetObjectTagging(GetObjectTaggingRequest getObjectTaggingRequest) throws ClientException, ServiceException {
        return getObjectTagging(getObjectTaggingRequest, (OSSCompletedCallback<GetObjectTaggingRequest, GetObjectTaggingResult>) null).getResult();
    }

    public OSSAsyncTask<GetObjectTaggingResult> getObjectTagging(GetObjectTaggingRequest getObjectTaggingRequest, OSSCompletedCallback<GetObjectTaggingRequest, GetObjectTaggingResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.X_OSS_TAGGING, "");
        requestMessage.setIsAuthorizationRequired(getObjectTaggingRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.GET);
        requestMessage.setBucketName(getObjectTaggingRequest.getBucketName());
        requestMessage.setObjectKey(getObjectTaggingRequest.getObjectKey());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, getObjectTaggingRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), getObjectTaggingRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.GetObjectTaggingResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public DeleteObjectTaggingResult syncDeleteObjectTagging(DeleteObjectTaggingRequest deleteObjectTaggingRequest) throws ClientException, ServiceException {
        return deleteObjectTagging(deleteObjectTaggingRequest, (OSSCompletedCallback<DeleteObjectTaggingRequest, DeleteObjectTaggingResult>) null).getResult();
    }

    public OSSAsyncTask<DeleteObjectTaggingResult> deleteObjectTagging(DeleteObjectTaggingRequest deleteObjectTaggingRequest, OSSCompletedCallback<DeleteObjectTaggingRequest, DeleteObjectTaggingResult> oSSCompletedCallback) {
        RequestMessage requestMessage = new RequestMessage();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RequestParameters.X_OSS_TAGGING, "");
        requestMessage.setIsAuthorizationRequired(deleteObjectTaggingRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(HttpMethod.DELETE);
        requestMessage.setBucketName(deleteObjectTaggingRequest.getBucketName());
        requestMessage.setObjectKey(deleteObjectTaggingRequest.getObjectKey());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, deleteObjectTaggingRequest);
        ExecutionContext executionContext = new ExecutionContext(getInnerClient(), deleteObjectTaggingRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new OSSRequestTask(requestMessage, new ResponseParsers.DeleteObjectTaggingResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }
}
