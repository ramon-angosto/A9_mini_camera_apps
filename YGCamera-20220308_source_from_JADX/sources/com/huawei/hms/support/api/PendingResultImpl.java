package com.huawei.hms.support.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.adapter.BaseAdapter;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.gentyref.GenericTypeReflector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class PendingResultImpl<R extends Result, T extends IMessageEntity> extends InnerPendingResult<R> {
    private static final String TAG = "PendingResultImpl";
    private WeakReference<ApiClient> api;
    /* access modifiers changed from: private */
    public CountDownLatch countLatch;
    private boolean isNeedReport = true;
    /* access modifiers changed from: private */
    public R result = null;
    private String transId = null;
    protected DatagramTransport transport = null;
    private String url = null;

    /* renamed from: com.huawei.hms.support.api.PendingResultImpl$a */
    class C0902a implements DatagramTransport.C0915a {
        C0902a() {
        }

        /* renamed from: a */
        public void mo14356a(int i, IMessageEntity iMessageEntity) {
            PendingResultImpl.this.setResult(i, iMessageEntity);
            PendingResultImpl.this.countLatch.countDown();
        }
    }

    /* renamed from: com.huawei.hms.support.api.PendingResultImpl$b */
    class C0903b implements DatagramTransport.C0915a {

        /* renamed from: a */
        final /* synthetic */ AtomicBoolean f954a;

        C0903b(AtomicBoolean atomicBoolean) {
            this.f954a = atomicBoolean;
        }

        /* renamed from: a */
        public void mo14356a(int i, IMessageEntity iMessageEntity) {
            if (!this.f954a.get()) {
                PendingResultImpl.this.setResult(i, iMessageEntity);
            }
            PendingResultImpl.this.countLatch.countDown();
        }
    }

    /* renamed from: com.huawei.hms.support.api.PendingResultImpl$c */
    class C0904c implements DatagramTransport.C0915a {

        /* renamed from: a */
        final /* synthetic */ C0905d f956a;

        /* renamed from: b */
        final /* synthetic */ ResultCallback f957b;

        C0904c(C0905d dVar, ResultCallback resultCallback) {
            this.f956a = dVar;
            this.f957b = resultCallback;
        }

        /* renamed from: a */
        public void mo14356a(int i, IMessageEntity iMessageEntity) {
            PendingResultImpl.this.setResult(i, iMessageEntity);
            this.f956a.mo14357a(this.f957b, PendingResultImpl.this.result);
        }
    }

    /* renamed from: com.huawei.hms.support.api.PendingResultImpl$d */
    protected static class C0905d<R extends Result> extends Handler {
        public C0905d(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        public void mo14357a(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo14358b(ResultCallback<? super R> resultCallback, R r) {
            resultCallback.onResult(r);
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                Pair pair = (Pair) message.obj;
                mo14358b((ResultCallback) pair.first, (Result) pair.second);
            }
        }
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
        init(apiClient, str, iMessageEntity, getResponseType(), 0);
    }

    private void biReportEvent(int i, int i2) {
        SubAppInfo subAppInfo;
        HMSLog.m1379i(TAG, "biReportEvent ====== ");
        ApiClient apiClient = (ApiClient) this.api.get();
        if (apiClient != null && this.url != null && !HiAnalyticsUtil.getInstance().hasError(apiClient.getContext())) {
            HashMap hashMap = new HashMap();
            hashMap.put("package", apiClient.getPackageName());
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "5.2.0.300");
            if (i2 == 1) {
                hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
            } else {
                hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
                hashMap.put("result", String.valueOf(i));
                R r = this.result;
                if (!(r == null || r.getStatus() == null)) {
                    hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, String.valueOf(this.result.getStatus().getStatusCode()));
                }
            }
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_VERSION, "0");
            String appId = Util.getAppId(apiClient.getContext());
            if (TextUtils.isEmpty(appId) && (subAppInfo = apiClient.getSubAppInfo()) != null) {
                appId = subAppInfo.getSubAppID();
            }
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, appId);
            if (TextUtils.isEmpty(this.transId)) {
                this.transId = TransactionIdCreater.getId(appId, this.url);
                hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, this.transId);
            } else {
                hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, this.transId);
                this.transId = null;
            }
            String[] split = this.url.split("\\.");
            if (split.length >= 2) {
                hashMap.put("service", split[0]);
                hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_APINAME, split[1]);
            }
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_CALLTMEI, String.valueOf(System.currentTimeMillis()));
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
            HiAnalyticsUtil.getInstance().onEvent(apiClient.getContext(), HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, (Map<String, String>) hashMap);
        }
    }

    private void init(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<T> cls, int i) {
        HMSLog.m1379i(TAG, "init uri:" + str);
        this.url = str;
        if (apiClient == null) {
            HMSLog.m1377e(TAG, "client is null");
            return;
        }
        this.api = new WeakReference<>(apiClient);
        this.countLatch = new CountDownLatch(1);
        try {
            this.transport = (DatagramTransport) Class.forName(apiClient.getTransportName()).getConstructor(new Class[]{String.class, IMessageEntity.class, Class.class, Integer.TYPE}).newInstance(new Object[]{str, iMessageEntity, cls, Integer.valueOf(i)});
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            HMSLog.m1377e(TAG, "gen transport error:" + e.getMessage());
            throw new IllegalStateException("Instancing transport exception, " + e.getMessage(), e);
        }
    }

    /* access modifiers changed from: private */
    public void setResult(int i, IMessageEntity iMessageEntity) {
        Status status;
        HMSLog.m1379i(TAG, "setResult:" + i);
        Status commonStatus = iMessageEntity instanceof AbstractMessageEntity ? ((AbstractMessageEntity) iMessageEntity).getCommonStatus() : null;
        if (i == 0) {
            this.result = onComplete(iMessageEntity);
        } else {
            this.result = onError(i);
        }
        if (this.isNeedReport) {
            biReportEvent(i, 2);
        }
        R r = this.result;
        if (r != null && (status = r.getStatus()) != null && commonStatus != null) {
            int statusCode = status.getStatusCode();
            String statusMessage = status.getStatusMessage();
            int statusCode2 = commonStatus.getStatusCode();
            String statusMessage2 = commonStatus.getStatusMessage();
            if (statusCode != statusCode2) {
                HMSLog.m1377e(TAG, "rstStatus code (" + statusCode + ") is not equal commonStatus code (" + statusCode2 + ")");
                HMSLog.m1377e(TAG, "rstStatus msg (" + statusMessage + ") is not equal commonStatus msg (" + statusMessage2 + ")");
            } else if (TextUtils.isEmpty(statusMessage) && !TextUtils.isEmpty(statusMessage2)) {
                HMSLog.m1379i(TAG, "rstStatus msg (" + statusMessage + ") is not equal commonStatus msg (" + statusMessage2 + ")");
                this.result.setStatus(new Status(statusCode, statusMessage2, status.getResolution()));
            }
        }
    }

    public final R await() {
        HMSLog.m1379i(TAG, "await");
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return awaitOnAnyThread();
        }
        HMSLog.m1377e(TAG, "await in main thread");
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    public final R awaitOnAnyThread() {
        HMSLog.m1379i(TAG, "awaitOnAnyThread");
        WeakReference<ApiClient> weakReference = this.api;
        if (weakReference == null) {
            HMSLog.m1377e(TAG, "api is null");
            setResult(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.result;
        }
        ApiClient apiClient = (ApiClient) weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.m1377e(TAG, "client invalid");
            setResult(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.result;
        }
        if (this.isNeedReport) {
            biReportEvent(0, 1);
        }
        this.transport.send(apiClient, new C0902a());
        try {
            this.countLatch.await();
        } catch (InterruptedException unused) {
            HMSLog.m1377e(TAG, "await in anythread InterruptedException");
            setResult(CommonCode.ErrorCode.INTERNAL_ERROR, (IMessageEntity) null);
        }
        return this.result;
    }

    @Deprecated
    public void cancel() {
    }

    /* access modifiers changed from: protected */
    public boolean checkApiClient(ApiClient apiClient) {
        return true;
    }

    /* access modifiers changed from: protected */
    public Class<T> getResponseType() {
        Type type;
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass == null || (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[1]) == null) {
            return null;
        }
        return (Class) type;
    }

    @Deprecated
    public boolean isCanceled() {
        return false;
    }

    public abstract R onComplete(T t);

    /* access modifiers changed from: protected */
    public R onError(int i) {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Type type = genericSuperclass != null ? ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0] : null;
        Class type2 = type != null ? GenericTypeReflector.getType(type) : null;
        if (type2 != null) {
            try {
                this.result = (Result) type2.newInstance();
                this.result.setStatus(new Status(i));
            } catch (Exception e) {
                HMSLog.m1377e(TAG, "on Error:" + e.getMessage());
                return null;
            }
        }
        return this.result;
    }

    public void setResultCallback(ResultCallback<R> resultCallback) {
        this.isNeedReport = !(resultCallback instanceof BaseAdapter.BaseRequestResultCallback);
        setResultCallback(Looper.getMainLooper(), resultCallback);
    }

    public final void setResultCallback(Looper looper, ResultCallback<R> resultCallback) {
        HMSLog.m1379i(TAG, "setResultCallback");
        if (looper == null) {
            looper = Looper.myLooper();
        }
        C0905d dVar = new C0905d(looper);
        WeakReference<ApiClient> weakReference = this.api;
        if (weakReference == null) {
            HMSLog.m1377e(TAG, "api is null");
            setResult(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return;
        }
        ApiClient apiClient = (ApiClient) weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.m1377e(TAG, "client is invalid");
            setResult(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            dVar.mo14357a(resultCallback, this.result);
            return;
        }
        if (this.isNeedReport) {
            biReportEvent(0, 1);
        }
        this.transport.post(apiClient, new C0904c(dVar, resultCallback));
    }

    public R await(long j, TimeUnit timeUnit) {
        HMSLog.m1379i(TAG, "await timeout:" + j + " unit:" + timeUnit.toString());
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return awaitOnAnyThread(j, timeUnit);
        }
        HMSLog.m1379i(TAG, "await in main thread");
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    @Deprecated
    public void setResultCallback(ResultCallback<R> resultCallback, long j, TimeUnit timeUnit) {
        setResultCallback(resultCallback);
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<T> cls) {
        init(apiClient, str, iMessageEntity, cls, 0);
    }

    public final R awaitOnAnyThread(long j, TimeUnit timeUnit) {
        HMSLog.m1379i(TAG, "awaitOnAnyThread timeout:" + j + " unit:" + timeUnit.toString());
        WeakReference<ApiClient> weakReference = this.api;
        if (weakReference == null) {
            HMSLog.m1377e(TAG, "api is null");
            setResult(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.result;
        }
        ApiClient apiClient = (ApiClient) weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.m1377e(TAG, "client invalid");
            setResult(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.result;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        if (this.isNeedReport) {
            biReportEvent(0, 1);
        }
        this.transport.post(apiClient, new C0903b(atomicBoolean));
        try {
            if (!this.countLatch.await(j, timeUnit)) {
                atomicBoolean.set(true);
                setResult(CommonCode.ErrorCode.EXECUTE_TIMEOUT, (IMessageEntity) null);
            }
        } catch (InterruptedException unused) {
            HMSLog.m1377e(TAG, "awaitOnAnyThread InterruptedException");
            setResult(CommonCode.ErrorCode.INTERNAL_ERROR, (IMessageEntity) null);
        }
        return this.result;
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity, int i) {
        init(apiClient, str, iMessageEntity, getResponseType(), i);
    }
}
