package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.task.BaseVoidTask;
import com.huawei.hms.push.task.IntentCallable;
import com.huawei.hms.push.task.SendUpStreamTask;
import com.huawei.hms.push.task.SubscribeTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.EnableNotifyReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.api.entity.push.SubscribeReq;
import com.huawei.hms.support.api.entity.push.UpSendMsgReq;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.NetWorkUtil;
import java.util.regex.Pattern;

public class HmsMessaging {
    public static final String DEFAULT_TOKEN_SCOPE = "HCM";

    /* renamed from: a */
    public static final Pattern f829a = Pattern.compile("[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");

    /* renamed from: b */
    public Context f830b;

    /* renamed from: c */
    public HuaweiApi<Api.ApiOptions.NoOptions> f831c;

    public HmsMessaging(Context context) {
        Preconditions.checkNotNull(context);
        this.f830b = context;
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f831c = new HuaweiApi<>((Activity) context, api, null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f831c = new HuaweiApi<>(context, api, null, (AbstractClientBuilder) new PushClientBuilder());
        }
        this.f831c.setKitSdkVersion(50101300);
    }

    public static synchronized HmsMessaging getInstance(Context context) {
        HmsMessaging hmsMessaging;
        synchronized (HmsMessaging.class) {
            hmsMessaging = new HmsMessaging(context);
        }
        return hmsMessaging;
    }

    /* renamed from: a */
    public final Task<Void> mo14204a(String str, String str2) {
        String reportEntry = PushBiUtil.reportEntry(this.f830b, PushNaming.SUBSCRIBE);
        if (str == null || !f829a.matcher(str).matches()) {
            PushBiUtil.reportExit(this.f830b, PushNaming.SUBSCRIBE, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
            HMSLog.m1377e("HmsMessaging", "Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
            throw new IllegalArgumentException("Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
        } else if (ProxyCenter.getProxy() != null) {
            HMSLog.m1379i("HmsMessaging", "use proxy subscribe.");
            if (TextUtils.equals(str2, "Sub")) {
                return ProxyCenter.getProxy().subscribe(this.f830b, str, reportEntry);
            }
            return ProxyCenter.getProxy().unsubscribe(this.f830b, str, reportEntry);
        } else {
            try {
                ErrorEnum a = C0874d.m1219a(this.f830b);
                if (a != ErrorEnum.SUCCESS) {
                    throw a.toApiException();
                } else if (NetWorkUtil.getNetworkType(this.f830b) != 0) {
                    SubscribeReq subscribeReq = new SubscribeReq(this.f830b, str2, str);
                    subscribeReq.setToken(BaseUtils.getLocalToken(this.f830b, (String) null));
                    if (C0889s.m1319b()) {
                        return this.f831c.doWrite(new BaseVoidTask(PushNaming.SUBSCRIBE, JsonUtil.createJsonString(subscribeReq), reportEntry));
                    }
                    return this.f831c.doWrite(new SubscribeTask(PushNaming.SUBSCRIBE, JsonUtil.createJsonString(subscribeReq), reportEntry));
                } else {
                    HMSLog.m1377e("HmsMessaging", "no network");
                    throw ErrorEnum.ERROR_NO_NETWORK.toApiException();
                }
            } catch (ApiException e) {
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                taskCompletionSource.setException(e);
                PushBiUtil.reportExit(this.f830b, PushNaming.SUBSCRIBE, reportEntry, e.getStatusCode());
                return taskCompletionSource.getTask();
            } catch (Exception unused) {
                TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
                taskCompletionSource2.setException(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
                PushBiUtil.reportExit(this.f830b, PushNaming.SUBSCRIBE, reportEntry, ErrorEnum.ERROR_INTERNAL_ERROR);
                return taskCompletionSource2.getTask();
            }
        }
    }

    public boolean isAutoInitEnabled() {
        return AutoInitHelper.isAutoInitEnabled(this.f830b);
    }

    public void send(RemoteMessage remoteMessage) {
        if (ProxyCenter.getProxy() == null) {
            HMSLog.m1379i("HmsMessaging", "send upstream message");
            mo14206a(remoteMessage);
            return;
        }
        HMSLog.m1377e("HmsMessaging", "Operation(send) unsupported");
        throw new UnsupportedOperationException("Operation(send) unsupported");
    }

    public void setAutoInitEnabled(boolean z) {
        AutoInitHelper.setAutoInitEnabled(this.f830b, z);
    }

    public Task<Void> subscribe(String str) {
        HMSLog.m1379i("HmsMessaging", "invoke subscribe");
        return mo14204a(str, "Sub");
    }

    public Task<Void> turnOffPush() {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.m1379i("HmsMessaging", "turn off for proxy");
            return ProxyCenter.getProxy().turnOff(this.f830b, (String) null);
        }
        HMSLog.m1379i("HmsMessaging", "invoke turnOffPush");
        return mo14205a(false);
    }

    public Task<Void> turnOnPush() {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.m1379i("HmsMessaging", "turn on for proxy");
            return ProxyCenter.getProxy().turnOn(this.f830b, (String) null);
        }
        HMSLog.m1379i("HmsMessaging", "invoke turnOnPush");
        return mo14205a(true);
    }

    public Task<Void> unsubscribe(String str) {
        HMSLog.m1379i("HmsMessaging", "invoke unsubscribe");
        return mo14204a(str, "UnSub");
    }

    /* renamed from: a */
    public final void mo14206a(RemoteMessage remoteMessage) {
        String reportEntry = PushBiUtil.reportEntry(this.f830b, PushNaming.UPSEND_MSG);
        ErrorEnum a = C0874d.m1219a(this.f830b);
        if (a != ErrorEnum.SUCCESS) {
            HMSLog.m1377e("HmsMessaging", "Message sent failed:" + a.getExternalCode() + ':' + a.getMessage());
            PushBiUtil.reportExit(this.f830b, PushNaming.UPSEND_MSG, reportEntry, a);
            throw new UnsupportedOperationException(a.getMessage());
        } else if (TextUtils.isEmpty(remoteMessage.getTo())) {
            HMSLog.m1377e("HmsMessaging", "Mandatory parameter 'to' missing");
            PushBiUtil.reportExit(this.f830b, PushNaming.UPSEND_MSG, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
            throw new IllegalArgumentException("Mandatory parameter 'to' missing");
        } else if (TextUtils.isEmpty(remoteMessage.getMessageId())) {
            HMSLog.m1377e("HmsMessaging", "Mandatory parameter 'message_id' missing");
            PushBiUtil.reportExit(this.f830b, PushNaming.UPSEND_MSG, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
            throw new IllegalArgumentException("Mandatory parameter 'message_id' missing");
        } else if (!TextUtils.isEmpty(remoteMessage.getData())) {
            UpSendMsgReq upSendMsgReq = new UpSendMsgReq();
            upSendMsgReq.setPackageName(this.f830b.getPackageName());
            upSendMsgReq.setMessageId(remoteMessage.getMessageId());
            upSendMsgReq.setTo(remoteMessage.getTo());
            upSendMsgReq.setData(remoteMessage.getData());
            upSendMsgReq.setMessageType(remoteMessage.getMessageType());
            upSendMsgReq.setTtl(remoteMessage.getTtl());
            upSendMsgReq.setCollapseKey(remoteMessage.getCollapseKey());
            upSendMsgReq.setSendMode(remoteMessage.getSendMode());
            upSendMsgReq.setReceiptMode(remoteMessage.getReceiptMode());
            if (C0889s.m1319b()) {
                this.f831c.doWrite(new BaseVoidTask(PushNaming.UPSEND_MSG, JsonUtil.createJsonString(upSendMsgReq), reportEntry));
            } else {
                mo14207a(upSendMsgReq, reportEntry);
            }
        } else {
            HMSLog.m1377e("HmsMessaging", "Mandatory parameter 'data' missing");
            PushBiUtil.reportExit(this.f830b, PushNaming.UPSEND_MSG, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
            throw new IllegalArgumentException("Mandatory parameter 'data' missing");
        }
    }

    /* renamed from: a */
    public final Task<Void> mo14205a(boolean z) {
        String reportEntry = PushBiUtil.reportEntry(this.f830b, PushNaming.SET_NOTIFY_FLAG);
        if (!C0889s.m1322d(this.f830b) || C0889s.m1319b()) {
            HMSLog.m1379i("HmsMessaging", "turn on/off with AIDL");
            EnableNotifyReq enableNotifyReq = new EnableNotifyReq();
            enableNotifyReq.setPackageName(this.f830b.getPackageName());
            enableNotifyReq.setEnable(z);
            return this.f831c.doWrite(new BaseVoidTask(PushNaming.SET_NOTIFY_FLAG, JsonUtil.createJsonString(enableNotifyReq), reportEntry));
        } else if (HwBuildEx.VERSION.EMUI_SDK_INT < 12) {
            HMSLog.m1377e("HmsMessaging", "operation not available on Huawei device with EMUI lower than 5.1");
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException());
            PushBiUtil.reportExit(this.f830b, PushNaming.SET_NOTIFY_FLAG, reportEntry, ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED);
            return taskCompletionSource.getTask();
        } else if (C0889s.m1318b(this.f830b) < 90101310) {
            HMSLog.m1379i("HmsMessaging", "turn on/off with broadcast v1");
            Context context = this.f830b;
            Intent putExtra = new Intent("com.huawei.intent.action.SELF_SHOW_FLAG").putExtra("enalbeFlag", PushEncrypter.encrypterOld(context, this.f830b.getPackageName() + "#" + z));
            putExtra.setPackage("android");
            return Tasks.callInBackground(new IntentCallable(this.f830b, putExtra, reportEntry));
        } else {
            HMSLog.m1379i("HmsMessaging", "turn on/off with broadcast v2");
            new PushPreferences(this.f830b, "push_notify_flag").saveBoolean("notify_msg_enable", !z);
            Uri parse = Uri.parse("content://" + this.f830b.getPackageName() + ".huawei.push.provider/" + "push_notify_flag" + ".xml");
            Intent intent = new Intent("com.huawei.android.push.intent.SDK_COMMAND");
            intent.putExtra("type", "enalbeFlag");
            intent.putExtra("pkgName", this.f830b.getPackageName());
            intent.putExtra("url", parse);
            intent.setPackage("android");
            return Tasks.callInBackground(new IntentCallable(this.f830b, intent, reportEntry));
        }
    }

    /* renamed from: a */
    public final void mo14207a(UpSendMsgReq upSendMsgReq, String str) {
        upSendMsgReq.setToken(BaseUtils.getLocalToken(this.f830b, (String) null));
        try {
            this.f831c.doWrite(new SendUpStreamTask(PushNaming.UPSEND_MSG, JsonUtil.createJsonString(upSendMsgReq), str, upSendMsgReq.getPackageName(), upSendMsgReq.getMessageId()));
        } catch (Exception e) {
            if (e.getCause() instanceof ApiException) {
                PushBiUtil.reportExit(this.f830b, PushNaming.UPSEND_MSG, str, ((ApiException) e.getCause()).getStatusCode());
            } else {
                PushBiUtil.reportExit(this.f830b, PushNaming.UPSEND_MSG, str, ErrorEnum.ERROR_INTERNAL_ERROR);
            }
        }
    }
}
