package com.huawei.hms.adapter;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.p012ui.BaseResolutionAdapter;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.ResponseWrap;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseAdapter {
    private static final String TAG = "BaseAdapter";
    private WeakReference<Activity> activityWeakReference;
    private WeakReference<ApiClient> api;
    /* access modifiers changed from: private */
    public Context appContext;
    private BaseCallBack baseCallBackReplay;
    private BaseCallBack callback;
    private String jsonHeaderReplay;
    private String jsonObjectReplay;
    private SystemObserver observer;
    private Parcelable parcelableReplay;
    private RequestHeader requestHeader = new RequestHeader();
    /* access modifiers changed from: private */
    public ResponseHeader responseHeader = new ResponseHeader();
    /* access modifiers changed from: private */
    public String transactionId;

    public interface BaseCallBack {
        void onComplete(String str, String str2, Parcelable parcelable);

        void onError(String str);
    }

    public class BaseRequestResultCallback implements ResultCallback<ResolveResult<CoreBaseResponse>> {
        private AtomicBoolean isFirstRsp = new AtomicBoolean(true);

        public BaseRequestResultCallback() {
        }

        private void handleSolutionIntent(BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse) {
            HMSLog.m1379i(BaseAdapter.TAG, "baseCallBack.onComplete");
            PendingIntent pendingIntent = coreBaseResponse.getPendingIntent();
            if (pendingIntent != null) {
                baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), pendingIntent);
                return;
            }
            Intent intent = coreBaseResponse.getIntent();
            if (intent != null) {
                baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), intent);
            } else {
                baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), (Parcelable) null);
            }
        }

        public void onResult(ResolveResult<CoreBaseResponse> resolveResult) {
            BaseCallBack access$000 = BaseAdapter.this.getCallBack();
            if (access$000 == null) {
                HMSLog.m1377e(BaseAdapter.TAG, "onResult baseCallBack null");
            } else if (resolveResult == null) {
                HMSLog.m1377e(BaseAdapter.TAG, "result null");
                access$000.onError(BaseAdapter.this.getResponseHeaderForError(-1));
            } else {
                CoreBaseResponse value = resolveResult.getValue();
                if (value == null) {
                    HMSLog.m1377e(BaseAdapter.TAG, "response null");
                    access$000.onError(BaseAdapter.this.getResponseHeaderForError(-1));
                } else if (TextUtils.isEmpty(value.getJsonHeader())) {
                    HMSLog.m1377e(BaseAdapter.TAG, "jsonHeader null");
                    access$000.onError(BaseAdapter.this.getResponseHeaderForError(-1));
                } else {
                    JsonUtil.jsonToEntity(value.getJsonHeader(), BaseAdapter.this.responseHeader);
                    if (this.isFirstRsp.compareAndSet(true, false)) {
                        BaseAdapter baseAdapter = BaseAdapter.this;
                        baseAdapter.biReportRequestReturnIpc(baseAdapter.appContext, BaseAdapter.this.responseHeader);
                    }
                    if (CommonCode.Resolution.HAS_RESOLUTION_FROM_APK.equals(BaseAdapter.this.responseHeader.getResolution())) {
                        Activity access$500 = BaseAdapter.this.getCpActivity();
                        HMSLog.m1379i(BaseAdapter.TAG, "activity is " + access$500);
                        if (access$500 == null || access$500.isFinishing()) {
                            HMSLog.m1377e(BaseAdapter.TAG, "activity null");
                            handleSolutionIntent(access$000, value);
                            return;
                        }
                        PendingIntent pendingIntent = value.getPendingIntent();
                        if (pendingIntent == null) {
                            Intent intent = value.getIntent();
                            if (intent == null) {
                                HMSLog.m1377e(BaseAdapter.TAG, "hasResolution is true but NO_SOLUTION");
                                access$000.onError(BaseAdapter.this.getResponseHeaderForError(-4));
                            } else if (Util.isAvailableLibExist(BaseAdapter.this.appContext)) {
                                BaseAdapter.this.startResolution(access$500, intent);
                            } else {
                                access$000.onError(BaseAdapter.this.getResponseHeaderForError(-9));
                            }
                        } else if (Util.isAvailableLibExist(BaseAdapter.this.appContext)) {
                            BaseAdapter.this.startResolution(access$500, pendingIntent);
                        } else {
                            access$000.onError(BaseAdapter.this.getResponseHeaderForError(-9));
                        }
                    } else {
                        handleSolutionIntent(access$000, value);
                    }
                }
            }
        }
    }

    private static class MPendingResultImpl extends PendingResultImpl<ResolveResult<CoreBaseResponse>, CoreBaseResponse> {
        public MPendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        public ResolveResult<CoreBaseResponse> onComplete(CoreBaseResponse coreBaseResponse) {
            ResolveResult<CoreBaseResponse> resolveResult = new ResolveResult<>(coreBaseResponse);
            resolveResult.setStatus(Status.SUCCESS);
            return resolveResult;
        }
    }

    public BaseAdapter(ApiClient apiClient) {
        this.api = new WeakReference<>(apiClient);
    }

    private void biReportRequestEntryIpc(Context context, RequestHeader requestHeader2) {
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(requestHeader2);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_VERSION, HiAnalyticsUtil.versionCodeToName(String.valueOf(requestHeader2.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, mapFromRequestHeader);
    }

    private void biReportRequestEntrySolution(Context context, RequestHeader requestHeader2) {
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(requestHeader2);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_VERSION, HiAnalyticsUtil.versionCodeToName(String.valueOf(requestHeader2.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, mapFromRequestHeader);
    }

    /* access modifiers changed from: private */
    public void biReportRequestReturnIpc(Context context, ResponseHeader responseHeader2) {
        HiAnalyticsUtil.getInstance();
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader2);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_VERSION, HiAnalyticsUtil.versionCodeToName(String.valueOf(this.requestHeader.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, mapFromRequestHeader);
    }

    /* access modifiers changed from: private */
    public void biReportRequestReturnSolution(Context context, ResponseHeader responseHeader2, long j) {
        HiAnalyticsUtil.getInstance();
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader2);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, String.valueOf(j));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_VERSION, HiAnalyticsUtil.versionCodeToName(String.valueOf(this.requestHeader.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, mapFromRequestHeader);
    }

    /* access modifiers changed from: private */
    public String buildBodyStr(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errorCode", i);
        } catch (JSONException e) {
            HMSLog.m1377e(TAG, "buildBodyStr failed: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    /* access modifiers changed from: private */
    public ResponseWrap buildResponseWrap(int i, String str) {
        setResponseHeader(i);
        ResponseWrap responseWrap = new ResponseWrap(this.responseHeader);
        responseWrap.setBody(str);
        return responseWrap;
    }

    private BaseCallBack getBaseCallBackReplay() {
        return this.baseCallBackReplay;
    }

    /* access modifiers changed from: private */
    public BaseCallBack getCallBack() {
        BaseCallBack baseCallBack = this.callback;
        if (baseCallBack != null) {
            return baseCallBack;
        }
        HMSLog.m1377e(TAG, "callback null");
        return null;
    }

    /* access modifiers changed from: private */
    public Activity getCpActivity() {
        if (this.activityWeakReference == null) {
            HMSLog.m1379i(TAG, "activityWeakReference is " + this.activityWeakReference);
            return null;
        }
        ApiClient apiClient = (ApiClient) this.api.get();
        if (apiClient == null) {
            HMSLog.m1379i(TAG, "tmpApi is " + apiClient);
            return null;
        }
        HMSLog.m1379i(TAG, "activityWeakReference has " + this.activityWeakReference.get());
        return Util.getActiveActivity((Activity) this.activityWeakReference.get(), apiClient.getContext());
    }

    private String getJsonHeaderReplay() {
        return this.jsonHeaderReplay;
    }

    private String getJsonObjectReplay() {
        return this.jsonObjectReplay;
    }

    private Parcelable getParcelableReplay() {
        return this.parcelableReplay;
    }

    /* access modifiers changed from: private */
    public String getResponseHeaderForError(int i) {
        setResponseHeader(i);
        return this.responseHeader.toJson();
    }

    private void initObserver() {
        this.observer = new SystemObserver() {
            public boolean onSolutionResult(Intent intent, String str) {
                if (TextUtils.isEmpty(str)) {
                    HMSLog.m1377e(BaseAdapter.TAG, "onSolutionResult but id is null");
                    BaseCallBack access$000 = BaseAdapter.this.getCallBack();
                    if (access$000 == null) {
                        HMSLog.m1377e(BaseAdapter.TAG, "onSolutionResult baseCallBack null");
                        return true;
                    }
                    access$000.onError(BaseAdapter.this.getResponseHeaderForError(-6));
                    return true;
                } else if (!str.equals(BaseAdapter.this.transactionId)) {
                    return false;
                } else {
                    HMSLog.m1379i(BaseAdapter.TAG, "onSolutionResult + id is :" + str);
                    BaseCallBack access$0002 = BaseAdapter.this.getCallBack();
                    if (access$0002 == null) {
                        HMSLog.m1377e(BaseAdapter.TAG, "onResult baseCallBack null");
                        return true;
                    }
                    long j = 0;
                    if (intent == null) {
                        HMSLog.m1377e(BaseAdapter.TAG, "onSolutionResult but data is null");
                        String access$100 = BaseAdapter.this.getResponseHeaderForError(-7);
                        BaseAdapter baseAdapter = BaseAdapter.this;
                        baseAdapter.biReportRequestReturnSolution(baseAdapter.appContext, BaseAdapter.this.responseHeader, 0);
                        access$0002.onError(access$100);
                        return true;
                    } else if (intent.hasExtra(KpmsConstant.KIT_UPDATE_RESULT)) {
                        int intExtra = intent.getIntExtra(KpmsConstant.KIT_UPDATE_RESULT, 0);
                        HMSLog.m1379i(BaseAdapter.TAG, "kit_update_result is " + intExtra);
                        if (intExtra == 1) {
                            HMSLog.m1377e(BaseAdapter.TAG, "kit update success,replay request");
                            BaseAdapter.this.replayRequest();
                        } else {
                            HMSLog.m1377e(BaseAdapter.TAG, "kit update failed");
                            BaseAdapter baseAdapter2 = BaseAdapter.this;
                            access$0002.onError(baseAdapter2.buildResponseWrap(-10, baseAdapter2.buildBodyStr(intExtra)).toJson());
                        }
                        return true;
                    } else {
                        HMSLog.m1377e(BaseAdapter.TAG, "onComplete for on activity result");
                        String stringExtra = intent.getStringExtra(CommonCode.MapKey.JSON_HEADER);
                        String stringExtra2 = intent.getStringExtra(CommonCode.MapKey.JSON_BODY);
                        Object infoFromJsonobject = JsonUtil.getInfoFromJsonobject(stringExtra, "status_code");
                        Object infoFromJsonobject2 = JsonUtil.getInfoFromJsonobject(stringExtra, "error_code");
                        if (intent.hasExtra(CommonCode.MapKey.HMS_FOREGROUND_RES_UI)) {
                            Object infoFromJsonobject3 = JsonUtil.getInfoFromJsonobject(intent.getStringExtra(CommonCode.MapKey.HMS_FOREGROUND_RES_UI), "uiDuration");
                            if (infoFromJsonobject3 instanceof Long) {
                                j = ((Long) infoFromJsonobject3).longValue();
                            }
                        }
                        if (!(infoFromJsonobject instanceof Integer) || !(infoFromJsonobject2 instanceof Integer)) {
                            String unused = BaseAdapter.this.getResponseHeaderForError(-8);
                            BaseAdapter baseAdapter3 = BaseAdapter.this;
                            baseAdapter3.biReportRequestReturnSolution(baseAdapter3.appContext, BaseAdapter.this.responseHeader, j);
                        } else {
                            int intValue = ((Integer) infoFromJsonobject).intValue();
                            String unused2 = BaseAdapter.this.getResponseHeaderForError(((Integer) infoFromJsonobject2).intValue());
                            BaseAdapter.this.responseHeader.setStatusCode(intValue);
                            BaseAdapter baseAdapter4 = BaseAdapter.this;
                            baseAdapter4.biReportRequestReturnSolution(baseAdapter4.appContext, BaseAdapter.this.responseHeader, j);
                        }
                        access$0002.onComplete(stringExtra, stringExtra2, (Parcelable) null);
                        return true;
                    }
                }
            }

            public boolean onUpdateResult(int i) {
                return false;
            }
        };
    }

    /* access modifiers changed from: private */
    public void replayRequest() {
        if (this.jsonHeaderReplay != null && this.baseCallBackReplay != null) {
            this.responseHeader = null;
            this.responseHeader = new ResponseHeader();
            baseRequest(getJsonHeaderReplay(), getJsonObjectReplay(), getParcelableReplay(), getBaseCallBackReplay());
        }
    }

    private void setBaseCallBackReplay(BaseCallBack baseCallBack) {
        this.baseCallBackReplay = baseCallBack;
    }

    private void setJsonHeaderReplay(String str) {
        this.jsonHeaderReplay = str;
    }

    private void setJsonObjectReplay(String str) {
        this.jsonObjectReplay = str;
    }

    private void setParcelableReplay(Parcelable parcelable) {
        this.parcelableReplay = parcelable;
    }

    private void setReplayData(String str, String str2, Parcelable parcelable, BaseCallBack baseCallBack) {
        setJsonHeaderReplay(str);
        setJsonObjectReplay(str2);
        setParcelableReplay(parcelable);
        setBaseCallBackReplay(baseCallBack);
    }

    private void setResponseHeader(int i) {
        this.responseHeader.setTransactionId(this.requestHeader.getTransactionId());
        this.responseHeader.setAppID(this.requestHeader.getAppID());
        this.responseHeader.setApiName(this.requestHeader.getApiName());
        this.responseHeader.setSrvName(this.requestHeader.getSrvName());
        this.responseHeader.setPkgName(this.requestHeader.getPkgName());
        this.responseHeader.setStatusCode(1);
        this.responseHeader.setErrorCode(i);
        this.responseHeader.setErrorReason("Core error");
    }

    /* access modifiers changed from: private */
    public void startResolution(Activity activity, Parcelable parcelable) {
        HMSLog.m1379i(TAG, "startResolution");
        RequestHeader requestHeader2 = this.requestHeader;
        if (requestHeader2 != null) {
            biReportRequestEntrySolution(this.appContext, requestHeader2);
        }
        if (this.observer == null) {
            initObserver();
        }
        SystemManager.getSystemNotifier().registerObserver(this.observer);
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, BaseResolutionAdapter.class.getName());
        Bundle bundle = new Bundle();
        bundle.putParcelable(CommonCode.MapKey.HAS_RESOLUTION, parcelable);
        intentStartBridgeActivity.putExtras(bundle);
        intentStartBridgeActivity.putExtra(CommonCode.MapKey.TRANSACTION_ID, this.transactionId);
        activity.startActivity(intentStartBridgeActivity);
    }

    public void baseRequest(String str, String str2, Parcelable parcelable, BaseCallBack baseCallBack) {
        setReplayData(str, str2, parcelable, baseCallBack);
        if (this.api == null) {
            HMSLog.m1377e(TAG, "client is null");
            baseCallBack.onError(getResponseHeaderForError(-2));
            return;
        }
        this.callback = baseCallBack;
        JsonUtil.jsonToEntity(str, this.requestHeader);
        CoreBaseRequest coreBaseRequest = new CoreBaseRequest();
        coreBaseRequest.setJsonObject(str2);
        coreBaseRequest.setJsonHeader(str);
        coreBaseRequest.setParcelable(parcelable);
        String apiName = this.requestHeader.getApiName();
        if (TextUtils.isEmpty(apiName)) {
            HMSLog.m1377e(TAG, "get uri null");
            baseCallBack.onError(getResponseHeaderForError(-5));
            return;
        }
        this.transactionId = this.requestHeader.getTransactionId();
        if (TextUtils.isEmpty(this.transactionId)) {
            HMSLog.m1377e(TAG, "get transactionId null");
            baseCallBack.onError(getResponseHeaderForError(-6));
            return;
        }
        HMSLog.m1379i(TAG, "in baseRequest + uri is :" + apiName + ", transactionId is : " + this.transactionId);
        biReportRequestEntryIpc(this.appContext, this.requestHeader);
        baseRequest((ApiClient) this.api.get(), apiName, coreBaseRequest).setResultCallback(new BaseRequestResultCallback());
    }

    public BaseAdapter(ApiClient apiClient, Activity activity) {
        this.api = new WeakReference<>(apiClient);
        this.activityWeakReference = new WeakReference<>(activity);
        this.appContext = activity.getApplicationContext();
    }

    private PendingResult<ResolveResult<CoreBaseResponse>> baseRequest(ApiClient apiClient, String str, CoreBaseRequest coreBaseRequest) {
        return new MPendingResultImpl(apiClient, str, coreBaseRequest);
    }
}
