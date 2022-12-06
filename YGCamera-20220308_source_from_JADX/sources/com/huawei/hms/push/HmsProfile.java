package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.task.ProfileTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.ProfileReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.secure.android.common.encrypt.hash.SHA;

public class HmsProfile {
    public static final int CUSTOM_PROFILE = 2;
    public static final int HUAWEI_PROFILE = 1;

    /* renamed from: a */
    public static final String f832a = "HmsProfile";

    /* renamed from: b */
    public Context f833b = null;

    /* renamed from: c */
    public HuaweiApi<Api.ApiOptions.NoOptions> f834c;

    public HmsProfile(Context context) {
        Preconditions.checkNotNull(context);
        this.f833b = context;
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f834c = new HuaweiApi<>((Activity) context, api, null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f834c = new HuaweiApi<>(context, api, null, (AbstractClientBuilder) new PushClientBuilder());
        }
        this.f834c.setKitSdkVersion(50101300);
    }

    public static HmsProfile getInstance(Context context) {
        return new HmsProfile(context);
    }

    /* renamed from: a */
    public final Task<Void> mo14215a(int i, String str, int i2, String str2) {
        if (!isSupportProfile()) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException());
            return taskCompletionSource.getTask();
        }
        if (!TextUtils.isEmpty(str)) {
            String a = m1205a(this.f833b);
            if (TextUtils.isEmpty(a)) {
                HMSLog.m1379i(f832a, "agc connect services config missing project id.");
                TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
                taskCompletionSource2.setException(ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException());
                return taskCompletionSource2.getTask();
            } else if (str.equals(a)) {
                str = "";
            }
        }
        ProfileReq profileReq = new ProfileReq();
        if (i == 0) {
            profileReq.setOperation(0);
            profileReq.setType(i2);
        } else {
            profileReq.setOperation(1);
        }
        String reportEntry = PushBiUtil.reportEntry(this.f833b, PushNaming.PUSH_PROFILE);
        try {
            profileReq.setSubjectId(str);
            profileReq.setProfileId(SHA.sha256Encrypt(str2));
            profileReq.setPkgName(this.f833b.getPackageName());
            return this.f834c.doWrite(new ProfileTask(PushNaming.PUSH_PROFILE, JsonUtil.createJsonString(profileReq), reportEntry));
        } catch (Exception e) {
            if (e.getCause() instanceof ApiException) {
                TaskCompletionSource taskCompletionSource3 = new TaskCompletionSource();
                ApiException apiException = (ApiException) e.getCause();
                taskCompletionSource3.setException(apiException);
                PushBiUtil.reportExit(this.f833b, PushNaming.PUSH_PROFILE, reportEntry, apiException.getStatusCode());
                return taskCompletionSource3.getTask();
            }
            TaskCompletionSource taskCompletionSource4 = new TaskCompletionSource();
            PushBiUtil.reportExit(this.f833b, PushNaming.PUSH_PROFILE, reportEntry, ErrorEnum.ERROR_INTERNAL_ERROR);
            taskCompletionSource4.setException(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            return taskCompletionSource4.getTask();
        }
    }

    public Task<Void> addProfile(int i, String str) {
        return addProfile("", i, str);
    }

    /* renamed from: b */
    public final boolean mo14218b(Context context) {
        return C0889s.m1318b(context) >= 110001400;
    }

    public Task<Void> deleteProfile(String str) {
        return deleteProfile("", str);
    }

    public boolean isSupportProfile() {
        if (!C0889s.m1322d(this.f833b)) {
            return true;
        }
        if (C0889s.m1321c()) {
            HMSLog.m1379i(f832a, "current EMUI version below 9.1, not support profile operation.");
            return false;
        } else if (mo14218b(this.f833b)) {
            return true;
        } else {
            HMSLog.m1379i(f832a, "current HwPushService.apk version below 11.0.1.400,please upgrade your HwPushService.apk version.");
            return false;
        }
    }

    public Task<Void> addProfile(String str, int i, String str2) {
        if (i != 1 && i != 2) {
            HMSLog.m1379i(f832a, "add profile type undefined.");
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
            return taskCompletionSource.getTask();
        } else if (!TextUtils.isEmpty(str2)) {
            return mo14215a(0, str, i, str2);
        } else {
            HMSLog.m1379i(f832a, "add profile params is empty.");
            TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            taskCompletionSource2.setException(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
            return taskCompletionSource2.getTask();
        }
    }

    public Task<Void> deleteProfile(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return mo14215a(1, str, -1, str2);
        }
        HMSLog.m1377e(f832a, "del profile params is empty.");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setException(ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
        return taskCompletionSource.getTask();
    }

    /* renamed from: a */
    public static String m1205a(Context context) {
        return AGConnectServicesConfig.fromContext(context).getString("client/project_id");
    }
}
