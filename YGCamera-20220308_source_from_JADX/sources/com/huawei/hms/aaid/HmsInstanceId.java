package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.C0848c;
import com.huawei.hms.opendevice.C0855i;
import com.huawei.hms.opendevice.C0856j;
import com.huawei.hms.opendevice.C0857k;
import com.huawei.hms.opendevice.C0858l;
import com.huawei.hms.opendevice.C0863o;
import com.huawei.hms.opendevice.C0864p;
import com.huawei.hms.opendevice.C0865q;
import com.huawei.hms.support.log.HMSLog;
import com.xiaomi.mipush.sdk.Constants;

public class HmsInstanceId {
    public static final String TAG = "HmsInstanceId";

    /* renamed from: a */
    public Context f234a;

    /* renamed from: b */
    public PushPreferences f235b;

    /* renamed from: c */
    public HuaweiApi<Api.ApiOptions.NoOptions> f236c;

    public HmsInstanceId(Context context) {
        this.f234a = context.getApplicationContext();
        this.f235b = new PushPreferences(context, "aaid");
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f236c = new HuaweiApi<>((Activity) context, api, null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f236c = new HuaweiApi<>(context, api, null, (AbstractClientBuilder) new PushClientBuilder());
        }
        this.f236c.setKitSdkVersion(50101300);
    }

    public static HmsInstanceId getInstance(Context context) {
        Preconditions.checkNotNull(context);
        C0848c.m1130d(context);
        return new HmsInstanceId(context);
    }

    /* renamed from: a */
    public final void mo12862a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (C0864p.m1179c(this.f234a)) {
                String string = C0855i.m1144a(this.f234a).getString("subjectId");
                if (TextUtils.isEmpty(string)) {
                    C0855i.m1144a(this.f234a).saveString("subjectId", str);
                } else if (!string.contains(str)) {
                    C0855i a = C0855i.m1144a(this.f234a);
                    a.saveString("subjectId", string + Constants.ACCEPT_TIME_SEPARATOR_SP + str);
                }
            } else {
                C0855i.m1144a(this.f234a).removeKey("subjectId");
            }
        }
    }

    /* renamed from: b */
    public final void mo12863b() throws ApiException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw ErrorEnum.ERROR_MAIN_THREAD.toApiException();
        }
    }

    public void deleteAAID() throws ApiException {
        mo12863b();
        try {
            if (this.f235b.containsKey("aaid")) {
                this.f235b.removeKey("aaid");
                this.f235b.removeKey("creationTime");
                if (C0863o.m1175e(this.f234a)) {
                    if (ProxyCenter.getProxy() != null) {
                        HMSLog.m1379i(TAG, "use proxy delete all token after delete AaId.");
                        ProxyCenter.getProxy().deleteAllToken(this.f234a);
                        return;
                    }
                    DeleteTokenReq b = C0863o.m1169b(this.f234a);
                    b.setDeleteType(1);
                    b.setMultiSender(false);
                    mo12861a(b, 1);
                    BaseUtils.deleteAllTokenCache(this.f234a);
                }
            }
        } catch (ApiException e) {
            throw e;
        } catch (Exception unused) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
    }

    public void deleteToken(String str, String str2) throws ApiException {
        mo12863b();
        mo12860a();
        DeleteTokenReq a = C0863o.m1166a(this.f234a, str, str2);
        a.setMultiSender(false);
        mo12861a(a, 1);
    }

    public Task<AAIDResult> getAAID() {
        try {
            return Tasks.callInBackground(new C0856j(this.f234a.getApplicationContext()));
        } catch (Exception unused) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            return taskCompletionSource.getTask();
        }
    }

    public long getCreationTime() {
        try {
            if (!this.f235b.containsKey("creationTime")) {
                getAAID();
            }
            return this.f235b.getLong("creationTime");
        } catch (Exception unused) {
            return 0;
        }
    }

    public String getId() {
        return C0863o.m1173c(this.f234a);
    }

    @Deprecated
    public String getToken() {
        try {
            return getToken((String) null, (String) null);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getToken(String str, String str2) throws ApiException {
        mo12863b();
        mo12860a();
        TokenReq b = C0863o.m1171b(this.f234a, str, str2);
        b.setAaid(getId());
        b.setMultiSender(false);
        C0855i.m1144a(this.f234a).saveString(this.f234a.getPackageName(), "1");
        return mo12859a(b, 1);
    }

    public void deleteToken(String str) throws ApiException {
        mo12863b();
        mo12860a();
        if (!TextUtils.isEmpty(str)) {
            String d = C0863o.m1174d(this.f234a);
            if (TextUtils.isEmpty(d)) {
                throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
            } else if (str.equals(d)) {
                deleteToken((String) null, (String) null);
            } else {
                DeleteTokenReq a = C0863o.m1165a(this.f234a, str);
                a.setMultiSender(true);
                mo12861a(a, 2);
            }
        } else {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
    }

    public String getToken(String str) throws ApiException {
        mo12863b();
        mo12860a();
        if (!TextUtils.isEmpty(str)) {
            String d = C0863o.m1174d(this.f234a);
            if (TextUtils.isEmpty(d)) {
                throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
            } else if (str.equals(d)) {
                return getToken((String) null, (String) null);
            } else {
                TokenReq b = C0863o.m1170b(this.f234a, str);
                b.setAaid(getId());
                b.setMultiSender(true);
                return mo12859a(b, 2);
            }
        } else {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
    }

    /* renamed from: a */
    public final String mo12859a(TokenReq tokenReq, int i) throws ApiException {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.m1379i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
            ProxyCenter.getProxy().getToken(this.f234a, tokenReq.getSubjectId(), (String) null);
            return null;
        }
        mo12862a(tokenReq.getSubjectId());
        String a = C0865q.m1180a(this.f234a, "push.gettoken");
        try {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("getToken req :");
            sb.append(tokenReq.toString());
            HMSLog.m1374d(str, sb.toString());
            C0858l lVar = new C0858l("push.gettoken", tokenReq, this.f234a, a);
            lVar.setApiLevel(i);
            return ((TokenResult) Tasks.await(this.f236c.doWrite(lVar))).getToken();
        } catch (Exception e) {
            if (e.getCause() instanceof ApiException) {
                ApiException apiException = (ApiException) e.getCause();
                C0865q.m1182a(this.f234a, "push.gettoken", a, apiException.getStatusCode());
                throw apiException;
            }
            C0865q.m1183a(this.f234a, "push.gettoken", a, ErrorEnum.ERROR_INTERNAL_ERROR);
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
    }

    /* renamed from: a */
    public final void mo12861a(DeleteTokenReq deleteTokenReq, int i) throws ApiException {
        String subjectId = deleteTokenReq.getSubjectId();
        if (ProxyCenter.getProxy() != null) {
            HMSLog.m1379i(TAG, "use proxy delete token");
            ProxyCenter.getProxy().deleteToken(this.f234a, subjectId, (String) null);
            return;
        }
        String a = C0865q.m1180a(this.f234a, "push.deletetoken");
        try {
            String b = C0855i.m1144a(this.f234a).mo14167b(subjectId);
            if (!deleteTokenReq.isMultiSender() || (!TextUtils.isEmpty(b) && !b.equals(C0855i.m1144a(this.f234a).mo14167b((String) null)))) {
                deleteTokenReq.setToken(b);
                C0857k kVar = new C0857k("push.deletetoken", deleteTokenReq, a);
                kVar.setApiLevel(i);
                Tasks.await(this.f236c.doWrite(kVar));
                C0855i.m1144a(this.f234a).mo14169c(subjectId);
                return;
            }
            C0855i.m1144a(this.f234a).removeKey(subjectId);
            HMSLog.m1379i(TAG, "The local subject token is null");
        } catch (Exception e) {
            if (e.getCause() instanceof ApiException) {
                ApiException apiException = (ApiException) e.getCause();
                C0865q.m1182a(this.f234a, "push.deletetoken", a, apiException.getStatusCode());
                throw apiException;
            }
            C0865q.m1183a(this.f234a, "push.deletetoken", a, ErrorEnum.ERROR_INTERNAL_ERROR);
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
    }

    /* renamed from: a */
    public final void mo12860a() throws ApiException {
        if (BaseUtils.getProxyInit(this.f234a) && ProxyCenter.getProxy() == null && !BaseUtils.isMainProc(this.f234a)) {
            HMSLog.m1377e(TAG, "Operations in child processes are not supported.");
            throw ErrorEnum.ERROR_OPER_IN_CHILD_PROCESS.toApiException();
        }
    }
}
