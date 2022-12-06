package com.huawei.hms.common;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.ConnectionManagerKey;
import com.huawei.hms.common.internal.HuaweiApiManager;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.hianalytics.C0917b;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class HuaweiApi<TOption extends Api.ApiOptions> {
    private static final String TAG = "HuaweiApi";
    private int apiLevel = 1;
    private String innerHmsPkg;
    private boolean isFirstReqSent = false;
    private WeakReference<Activity> mActivity;
    private String mAppID;
    private AbstractClientBuilder<?, TOption> mClientBuilder;
    private ConnectionManagerKey<TOption> mConnectionManagerKey;
    private Context mContext;
    private String mCpID;
    private String mHostAppid;
    private HuaweiApiManager mHuaweiApiManager;
    private int mKitSdkVersion;
    private TOption mOption;
    private SubAppInfo mSubAppInfo;

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.mActivity = new WeakReference<>(activity);
        init(activity, api, toption, abstractClientBuilder, i, (String) null);
    }

    private void init(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i, String str) {
        this.mContext = context.getApplicationContext();
        this.mHuaweiApiManager = HuaweiApiManager.getInstance(this.mContext);
        this.mConnectionManagerKey = ConnectionManagerKey.createConnectionManagerKey(context, api, toption, str);
        this.mOption = toption;
        this.mClientBuilder = abstractClientBuilder;
        this.mHostAppid = Util.getAppId(context);
        this.mAppID = this.mHostAppid;
        this.mCpID = Util.getCpId(context);
        this.mSubAppInfo = new SubAppInfo("");
        this.mKitSdkVersion = i;
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(this.mHostAppid)) {
                HMSLog.m1377e(TAG, "subAppId is host appid");
            } else {
                HMSLog.m1379i(TAG, "subAppId is " + str);
                this.mSubAppInfo = new SubAppInfo(str);
            }
        }
        initBI(context);
    }

    private void initBI(Context context) {
        HMSBIInitializer.getInstance(context).initBI();
    }

    private <TResult, TClient extends AnyClient> Task<TResult> sendRequest(TaskApiCall<TClient, TResult> taskApiCall) {
        TaskCompletionSource taskCompletionSource;
        if (taskApiCall.getToken() == null) {
            taskCompletionSource = new TaskCompletionSource();
        } else {
            taskCompletionSource = new TaskCompletionSource(taskApiCall.getToken());
        }
        this.mHuaweiApiManager.sendRequest(this, taskApiCall, taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public Task<Boolean> disconnectService() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.mHuaweiApiManager.disconnectService(this, taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public <TResult, TClient extends AnyClient> Task<TResult> doWrite(TaskApiCall<TClient, TResult> taskApiCall) {
        this.isFirstReqSent = true;
        if (taskApiCall == null) {
            HMSLog.m1377e(TAG, "in doWrite:taskApiCall is null");
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(new ApiException(Status.FAILURE));
            return taskCompletionSource.getTask();
        }
        C0917b.m1372a(this.mContext, taskApiCall.getUri(), TextUtils.isEmpty(this.mSubAppInfo.getSubAppID()) ? this.mAppID : this.mSubAppInfo.getSubAppID(), taskApiCall.getTransactionId(), String.valueOf(getKitSdkVersion()));
        return sendRequest(taskApiCall);
    }

    public Activity getActivity() {
        WeakReference<Activity> weakReference = this.mActivity;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    public int getApiLevel() {
        return this.apiLevel;
    }

    public String getAppID() {
        return this.mAppID;
    }

    public AnyClient getClient(Looper looper, HuaweiApiManager.ConnectionManager connectionManager) {
        return this.mClientBuilder.buildClient(this.mContext, getClientSetting(), connectionManager, connectionManager);
    }

    /* access modifiers changed from: protected */
    public ClientSettings getClientSetting() {
        ClientSettings clientSettings = new ClientSettings(this.mContext.getPackageName(), this.mContext.getClass().getName(), getScopes(), this.mHostAppid, (List<String>) null, this.mSubAppInfo);
        clientSettings.setCpID(this.mCpID);
        if (TextUtils.isEmpty(this.innerHmsPkg)) {
            this.innerHmsPkg = HMSPackageManager.getInstance(this.mContext).getHMSPackageName();
            HMSLog.m1379i(TAG, "inner hms is empty,hms pkg name is " + this.innerHmsPkg);
        }
        clientSettings.setInnerHmsPkg(this.innerHmsPkg);
        WeakReference<Activity> weakReference = this.mActivity;
        if (weakReference != null) {
            clientSettings.setCpActivity((Activity) weakReference.get());
        }
        return clientSettings;
    }

    public ConnectionManagerKey<TOption> getConnectionManagerKey() {
        return this.mConnectionManagerKey;
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getKitSdkVersion() {
        return this.mKitSdkVersion;
    }

    public TOption getOption() {
        return this.mOption;
    }

    /* access modifiers changed from: protected */
    public List<Scope> getScopes() {
        return Collections.emptyList();
    }

    public String getSubAppID() {
        return this.mSubAppInfo.getSubAppID();
    }

    public void setApiLevel(int i) {
        this.apiLevel = i;
    }

    public void setInnerHms() {
        this.innerHmsPkg = this.mContext.getPackageName();
        HMSLog.m1379i(TAG, "init inner hms pkg info:" + this.innerHmsPkg);
    }

    public void setKitSdkVersion(int i) {
        this.mKitSdkVersion = i;
    }

    public void setSubAppId(String str) throws ApiException {
        if (!setSubAppInfo(new SubAppInfo(str))) {
            throw new ApiException(Status.FAILURE);
        }
    }

    @Deprecated
    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        HMSLog.m1379i(TAG, "Enter setSubAppInfo");
        SubAppInfo subAppInfo2 = this.mSubAppInfo;
        if (subAppInfo2 != null && !TextUtils.isEmpty(subAppInfo2.getSubAppID())) {
            HMSLog.m1377e(TAG, "subAppInfo is already set");
            return false;
        } else if (subAppInfo == null) {
            HMSLog.m1377e(TAG, "subAppInfo is null");
            return false;
        } else {
            String subAppID = subAppInfo.getSubAppID();
            if (TextUtils.isEmpty(subAppID)) {
                HMSLog.m1377e(TAG, "subAppId is empty");
                return false;
            } else if (subAppID.equals(this.mHostAppid)) {
                HMSLog.m1377e(TAG, "subAppId is host appid");
                return false;
            } else if (this.isFirstReqSent) {
                HMSLog.m1377e(TAG, "Client has sent request to Huawei Mobile Services, setting subAppId is not allowed");
                return false;
            } else {
                this.mSubAppInfo = new SubAppInfo(subAppInfo);
                return true;
            }
        }
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i, String str) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.mActivity = new WeakReference<>(activity);
        init(activity, api, toption, abstractClientBuilder, i, str);
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.mActivity = new WeakReference<>(activity);
        init(activity, api, toption, abstractClientBuilder, 0, (String) null);
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        init(context, api, toption, abstractClientBuilder, i, (String) null);
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i, String str) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        init(context, api, toption, abstractClientBuilder, i, str);
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        init(context, api, toption, abstractClientBuilder, 0, (String) null);
    }
}
