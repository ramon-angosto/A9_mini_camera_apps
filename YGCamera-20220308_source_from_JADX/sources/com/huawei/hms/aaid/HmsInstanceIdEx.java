package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.C0858l;
import com.huawei.hms.opendevice.C0863o;
import com.huawei.hms.opendevice.C0865q;
import com.huawei.hms.support.log.HMSLog;
import java.util.UUID;

@Deprecated
public class HmsInstanceIdEx {
    public static final String TAG = "HmsInstanceIdEx";

    /* renamed from: a */
    public Context f237a = null;

    /* renamed from: b */
    public PushPreferences f238b = null;

    /* renamed from: c */
    public HuaweiApi<Api.ApiOptions.NoOptions> f239c;

    public HmsInstanceIdEx(Context context) {
        this.f237a = context;
        this.f238b = new PushPreferences(context, "aaid");
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f239c = new HuaweiApi<>((Activity) context, api, null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f239c = new HuaweiApi<>(context, api, null, (AbstractClientBuilder) new PushClientBuilder());
        }
        this.f239c.setKitSdkVersion(50101300);
    }

    public static HmsInstanceIdEx getInstance(Context context) {
        Preconditions.checkNotNull(context);
        return new HmsInstanceIdEx(context);
    }

    /* renamed from: a */
    public final String mo12874a(String str) {
        return "creationTime" + str;
    }

    public void deleteAAID(String str) throws ApiException {
        if (str != null) {
            try {
                if (this.f238b.containsKey(str)) {
                    this.f238b.removeKey(str);
                    this.f238b.removeKey(mo12874a(str));
                }
            } catch (RuntimeException unused) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            } catch (Exception unused2) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            }
        } else {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
    }

    public String getAAId(String str) throws ApiException {
        if (str != null) {
            try {
                if (this.f238b.containsKey(str)) {
                    return this.f238b.getString(str);
                }
                String uuid = UUID.randomUUID().toString();
                this.f238b.saveString(str, uuid);
                this.f238b.saveLong(mo12874a(str), Long.valueOf(System.currentTimeMillis()));
                return uuid;
            } catch (RuntimeException unused) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            } catch (Exception unused2) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            }
        } else {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
    }

    public long getCreationTime(String str) throws ApiException {
        if (str != null) {
            try {
                if (!this.f238b.containsKey(mo12874a(str))) {
                    getAAId(str);
                }
                return this.f238b.getLong(mo12874a(str));
            } catch (RuntimeException unused) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            } catch (Exception unused2) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            }
        } else {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
    }

    public Task<TokenResult> getToken() {
        if (ProxyCenter.getProxy() != null) {
            try {
                HMSLog.m1379i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
                ProxyCenter.getProxy().getToken(this.f237a, (String) null, (String) null);
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                taskCompletionSource.setResult(new TokenResult());
                return taskCompletionSource.getTask();
            } catch (ApiException e) {
                return mo12873a((Exception) e);
            } catch (Exception unused) {
                return mo12873a((Exception) ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            }
        } else {
            String a = C0865q.m1180a(this.f237a, "push.gettoken");
            try {
                TokenReq b = C0863o.m1171b(this.f237a, (String) null, (String) null);
                b.setAaid(HmsInstanceId.getInstance(this.f237a).getId());
                return this.f239c.doWrite(new C0858l("push.gettoken", b, this.f237a, a));
            } catch (RuntimeException unused2) {
                C0865q.m1183a(this.f237a, "push.gettoken", a, ErrorEnum.ERROR_INTERNAL_ERROR);
                return mo12873a((Exception) ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            } catch (Exception unused3) {
                C0865q.m1183a(this.f237a, "push.gettoken", a, ErrorEnum.ERROR_INTERNAL_ERROR);
                return mo12873a((Exception) ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            }
        }
    }

    /* renamed from: a */
    public final Task<TokenResult> mo12873a(Exception exc) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setException(exc);
        return taskCompletionSource.getTask();
    }
}
