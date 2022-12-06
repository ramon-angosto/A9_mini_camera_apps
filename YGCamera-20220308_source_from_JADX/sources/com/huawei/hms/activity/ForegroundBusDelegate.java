package com.huawei.hms.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.BusResponseResult;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Map;

public class ForegroundBusDelegate implements IBridgeActivityDelegate {
    private static final String EXTRA_DELEGATE_NAME = "intent.extra.hms.core.DELEGATE_NAME";
    private static final String EXTRA_DELEGATE_VALUE = "com.huawei.hms.core.activity.ForegroundBus";
    public static final String HMS_FOREGROUND_REQ_BODY = "HMS_FOREGROUND_REQ_BODY";
    public static final String HMS_FOREGROUND_REQ_HEADER = "HMS_FOREGROUND_REQ_HEADER";
    public static final String HMS_FOREGROUND_REQ_INNER = "HMS_FOREGROUND_REQ_INNER";
    public static final String HMS_FOREGROUND_RESP_HEADER = "HMS_FOREGROUND_RESP_HEADER";
    private static final int REQUEST_CODE_BUS = 431057;
    private static final String TAG = "ForegroundBusDelegate";
    private static final String UI_JUMP_ACTIVITY_NAME = "com.huawei.hms.core.activity.UiJumpActivity";
    private String foregroundBody;
    private RequestHeader foregroundHeader;
    private ForegroundInnerHeader innerHeader = new ForegroundInnerHeader();
    private WeakReference<Activity> mThisWeakRef;
    private ResponseHeader responseHeader;

    private class MyAvailableCallBack implements AvailableAdapter.AvailableCallBack {
        private MyAvailableCallBack() {
        }

        public void onComplete(int i) {
            if (i == 0) {
                ForegroundBusDelegate.this.startApkHubActivity();
                return;
            }
            HMSLog.m1379i(ForegroundBusDelegate.TAG, "version check failed");
            ForegroundBusDelegate.this.errorReturn(0, "apk version is invalid");
        }
    }

    private void biReportRequestEntryForegroundBus() {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.foregroundHeader);
        mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_VERSION, HiAnalyticsUtil.versionCodeToName(String.valueOf(this.foregroundHeader.getKitSdkVersion())));
        if (getActivity() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(getActivity().getApplicationContext(), HiAnalyticsConstant.HMS_SDK_BASE_ACTIVITY_STARTED, mapFromForegroundRequestHeader);
        }
    }

    private void biReportRequestEntryStartCore() {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.foregroundHeader);
        mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_VERSION, HiAnalyticsUtil.versionCodeToName(String.valueOf(this.foregroundHeader.getKitSdkVersion())));
        if (getActivity() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(getActivity().getApplicationContext(), HiAnalyticsConstant.HMS_SDK_BASE_START_CORE_ACTIVITY, mapFromForegroundRequestHeader);
        }
    }

    private void biReportRequestReturnForegroundBus() {
        if (this.foregroundHeader != null) {
            Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.foregroundHeader);
            mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
            mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_VERSION, HiAnalyticsUtil.versionCodeToName(String.valueOf(this.foregroundHeader.getKitSdkVersion())));
            ResponseHeader responseHeader2 = this.responseHeader;
            if (responseHeader2 != null) {
                mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, String.valueOf(responseHeader2.getStatusCode()));
                mapFromForegroundRequestHeader.put("result", String.valueOf(this.responseHeader.getErrorCode()));
            }
            if (getActivity() != null) {
                HiAnalyticsUtil.getInstance().onNewEvent(getActivity().getApplicationContext(), HiAnalyticsConstant.HMS_SDK_BASE_ACTIVITY_STARTED, mapFromForegroundRequestHeader);
            }
        }
    }

    private void biReportRequestReturnStartCore() {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.foregroundHeader);
        mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
        mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_VERSION, HiAnalyticsUtil.versionCodeToName(String.valueOf(this.foregroundHeader.getKitSdkVersion())));
        ResponseHeader responseHeader2 = this.responseHeader;
        if (responseHeader2 != null) {
            mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, String.valueOf(responseHeader2.getStatusCode()));
            mapFromForegroundRequestHeader.put("result", String.valueOf(this.responseHeader.getErrorCode()));
        }
        if (getActivity() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(getActivity().getApplicationContext(), HiAnalyticsConstant.HMS_SDK_BASE_START_CORE_ACTIVITY, mapFromForegroundRequestHeader);
        }
    }

    private void checkMinVersion() {
        if (getActivity() == null) {
            HMSLog.m1377e(TAG, "checkMinVersion failed, activity must not be null.");
        } else if (Util.isAvailableLibExist(getActivity().getApplicationContext())) {
            MyAvailableCallBack myAvailableCallBack = new MyAvailableCallBack();
            AvailableAdapter availableAdapter = new AvailableAdapter(this.innerHeader.getApkVersion());
            int isHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(getActivity());
            if (isHuaweiMobileServicesAvailable == 0) {
                myAvailableCallBack.onComplete(isHuaweiMobileServicesAvailable);
            } else if (availableAdapter.isUserResolvableError(isHuaweiMobileServicesAvailable)) {
                resolution(getActivity(), availableAdapter, myAvailableCallBack);
            } else {
                myAvailableCallBack.onComplete(isHuaweiMobileServicesAvailable);
            }
        } else if (HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(getActivity().getApplicationContext(), this.innerHeader.getApkVersion()) != 0) {
            HMSLog.m1377e(TAG, "checkMinVersion failed, and no available lib exists.");
        } else {
            startApkHubActivity();
        }
    }

    /* access modifiers changed from: private */
    public void errorReturn(int i, String str) {
        HMSLog.m1377e(TAG, str);
        Activity activity = getActivity();
        if (activity != null) {
            BusResponseCallback responseCallback = getResponseCallback(this.innerHeader.getResponseCallbackKey());
            if (responseCallback != null) {
                BusResponseResult innerError = responseCallback.innerError((Activity) this.mThisWeakRef.get(), i, str);
                if (innerError == null) {
                    activity.setResult(0);
                } else {
                    activity.setResult(innerError.getCode(), innerError.getIntent());
                }
            } else {
                activity.setResult(0);
            }
            finishBridgeActivity();
        }
    }

    private void finishBridgeActivity() {
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            activity.finish();
        }
    }

    private Activity getActivity() {
        WeakReference<Activity> weakReference = this.mThisWeakRef;
        if (weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    private BusResponseCallback getResponseCallback(String str) {
        return ForegroundBusResponseMgr.getInstance().get(str);
    }

    private static void resolution(Activity activity, AvailableAdapter availableAdapter, AvailableAdapter.AvailableCallBack availableCallBack) {
        if (activity == null) {
            HMSLog.m1379i(TAG, "null activity, could not start resolution intent");
        }
        availableAdapter.startResolution(activity, availableCallBack);
    }

    /* access modifiers changed from: private */
    public void startApkHubActivity() {
        HMSLog.m1379i(TAG, "startApkHubActivity");
        Activity activity = getActivity();
        if (activity == null) {
            HMSLog.m1377e(TAG, "startApkHubActivity but activity is null");
            return;
        }
        String hMSPackageName = HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName();
        Intent intent = new Intent(this.innerHeader.getAction());
        intent.putExtra(HMS_FOREGROUND_REQ_BODY, this.foregroundBody);
        intent.setPackage(hMSPackageName);
        intent.setClassName(hMSPackageName, UI_JUMP_ACTIVITY_NAME);
        intent.putExtra(HMS_FOREGROUND_REQ_HEADER, this.foregroundHeader.toJson());
        intent.putExtra(EXTRA_DELEGATE_NAME, EXTRA_DELEGATE_VALUE);
        try {
            biReportRequestEntryStartCore();
            activity.startActivityForResult(intent, REQUEST_CODE_BUS);
        } catch (ActivityNotFoundException e) {
            HMSLog.m1378e(TAG, "Launch sign in Intent failed. hms is probably being updated：", (Throwable) e);
            errorReturn(0, "launch bus intent failed");
        }
    }

    private void succeedReturn(int i, Intent intent) {
        HMSLog.m1379i(TAG, "succeedReturn");
        Activity activity = getActivity();
        if (activity != null) {
            activity.setResult(i, intent);
            finishBridgeActivity();
        }
    }

    public int getRequestCode() {
        return REQUEST_CODE_BUS;
    }

    public void onBridgeActivityCreate(Activity activity) {
        this.mThisWeakRef = new WeakReference<>(activity);
        Intent intent = activity.getIntent();
        String stringExtra = intent.getStringExtra(HMS_FOREGROUND_REQ_HEADER);
        this.foregroundHeader = new RequestHeader();
        if (!this.foregroundHeader.fromJson(stringExtra)) {
            errorReturn(0, "header is invalid");
            return;
        }
        this.foregroundBody = intent.getStringExtra(HMS_FOREGROUND_REQ_BODY);
        this.innerHeader.fromJson(intent.getStringExtra(HMS_FOREGROUND_REQ_INNER));
        if (this.innerHeader == null) {
            errorReturn(0, "inner header is invalid");
        } else if (TextUtils.isEmpty(this.foregroundHeader.getApiName())) {
            errorReturn(0, "action is invalid");
        } else {
            biReportRequestEntryForegroundBus();
            checkMinVersion();
        }
    }

    public void onBridgeActivityDestroy() {
        biReportRequestReturnForegroundBus();
        this.mThisWeakRef = null;
    }

    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        if (i != REQUEST_CODE_BUS) {
            return false;
        }
        if (intent != null && intent.hasExtra(HMS_FOREGROUND_RESP_HEADER)) {
            String stringExtra = intent.getStringExtra(HMS_FOREGROUND_RESP_HEADER);
            this.responseHeader = new ResponseHeader();
            JsonUtil.jsonToEntity(stringExtra, this.responseHeader);
        }
        biReportRequestReturnStartCore();
        BusResponseCallback responseCallback = getResponseCallback(this.innerHeader.getResponseCallbackKey());
        if (responseCallback == null) {
            succeedReturn(i2, intent);
            return true;
        }
        BusResponseResult succeedReturn = responseCallback.succeedReturn((Activity) this.mThisWeakRef.get(), i2, intent);
        if (succeedReturn == null) {
            succeedReturn(i2, intent);
            return true;
        }
        succeedReturn(succeedReturn.getCode(), succeedReturn.getIntent());
        return true;
    }

    public void onBridgeConfigurationChanged() {
    }

    public void onKeyUp(int i, KeyEvent keyEvent) {
    }
}
