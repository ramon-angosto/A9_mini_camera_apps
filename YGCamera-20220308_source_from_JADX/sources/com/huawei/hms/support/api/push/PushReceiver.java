package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.push.C0878h;
import com.huawei.hms.push.C0889s;
import com.huawei.hms.push.C0891u;
import com.huawei.hms.push.C0895v;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

public final class PushReceiver extends BroadcastReceiver {

    /* renamed from: com.huawei.hms.support.api.push.PushReceiver$a */
    private static class C0912a implements Runnable {

        /* renamed from: a */
        public Context f974a;

        /* renamed from: b */
        public Intent f975b;

        public void run() {
            Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
            intent.setPackage(this.f975b.getPackage());
            JSONObject a = PushReceiver.m1358b(this.f975b);
            String string = JsonUtil.getString(a, "moduleName", "");
            int i = JsonUtil.getInt(a, "msgType", 0);
            int i2 = JsonUtil.getInt(a, "status", 0);
            if (ErrorEnum.SUCCESS.getInternalCode() != i2) {
                i2 = ErrorEnum.ERROR_APP_SERVER_NOT_ONLINE.getInternalCode();
            }
            Bundle bundle = new Bundle();
            if (!"Push".equals(string) || i != 1) {
                if (this.f975b.getExtras() != null) {
                    bundle.putAll(this.f975b.getExtras());
                }
                bundle.putString("message_type", "received_message");
                bundle.putString("message_id", this.f975b.getStringExtra("msgIdStr"));
                bundle.putByteArray(RemoteMessageConst.MSGBODY, this.f975b.getByteArrayExtra("msg_data"));
                bundle.putString(RemoteMessageConst.DEVICE_TOKEN, C0895v.m1334a(this.f975b.getByteArrayExtra(RemoteMessageConst.DEVICE_TOKEN)));
                bundle.putInt(RemoteMessageConst.INPUT_TYPE, 1);
                bundle.putString("message_proxy_type", this.f975b.getStringExtra("message_proxy_type"));
            } else {
                bundle.putString("message_type", "delivery");
                bundle.putString("message_id", JsonUtil.getString(a, RemoteMessageConst.MSGID, ""));
                bundle.putInt("error", i2);
                bundle.putString(CommonCode.MapKey.TRANSACTION_ID, JsonUtil.getString(a, "transactionId", ""));
            }
            if (new C0878h().mo14284a(this.f974a, bundle, intent)) {
                HMSLog.m1379i("PushReceiver", "receive " + this.f975b.getAction() + " and start service success");
                return;
            }
            HMSLog.m1377e("PushReceiver", "receive " + this.f975b.getAction() + " and start service failed");
        }

        public C0912a(Context context, Intent intent) {
            this.f974a = context;
            this.f975b = intent;
        }
    }

    /* renamed from: com.huawei.hms.support.api.push.PushReceiver$b */
    private static class C0913b implements Runnable {

        /* renamed from: a */
        public Context f976a;

        /* renamed from: b */
        public Intent f977b;

        public void run() {
            try {
                byte[] byteArrayExtra = this.f977b.getByteArrayExtra(RemoteMessageConst.DEVICE_TOKEN);
                if (byteArrayExtra != null) {
                    if (byteArrayExtra.length != 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("receive a push token: ");
                        sb.append(this.f976a.getPackageName());
                        HMSLog.m1379i("PushReceiver", sb.toString());
                        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
                        intent.setPackage(this.f977b.getPackage());
                        Bundle bundle = new Bundle();
                        bundle.putString("message_type", "new_token");
                        bundle.putString(RemoteMessageConst.DEVICE_TOKEN, C0895v.m1334a(byteArrayExtra));
                        bundle.putString(CommonCode.MapKey.TRANSACTION_ID, this.f977b.getStringExtra(CommonCode.MapKey.TRANSACTION_ID));
                        bundle.putString("subjectId", this.f977b.getStringExtra("subjectId"));
                        bundle.putInt("error", this.f977b.getIntExtra("error", ErrorEnum.SUCCESS.getInternalCode()));
                        bundle.putString("belongId", this.f977b.getStringExtra("belongId"));
                        if (!new C0878h().mo14284a(this.f976a, bundle, intent)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("receive ");
                            sb2.append(this.f977b.getAction());
                            sb2.append(" and start service failed");
                            HMSLog.m1377e("PushReceiver", sb2.toString());
                            return;
                        }
                        return;
                    }
                }
                HMSLog.m1379i("PushReceiver", "get a deviceToken, but it is null or empty");
            } catch (RejectedExecutionException unused) {
                HMSLog.m1377e("PushReceiver", "execute task error");
            } catch (Exception unused2) {
                HMSLog.m1377e("PushReceiver", "handle push token error");
            }
        }

        public C0913b(Context context, Intent intent) {
            this.f976a = context;
            this.f977b = intent;
        }
    }

    /* renamed from: b */
    public final void mo14523b(Context context, Intent intent) {
        try {
            if (intent.hasExtra(RemoteMessageConst.DEVICE_TOKEN)) {
                C0891u.m1326a().execute(new C0913b(context, intent));
            } else {
                HMSLog.m1379i("PushReceiver", "This message dose not sent by hwpush.");
            }
        } catch (RuntimeException unused) {
            HMSLog.m1377e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
        } catch (Exception unused2) {
            HMSLog.m1377e("PushReceiver", "handlePushTokenEvent execute task error");
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && context != null) {
            HMSLog.m1379i("PushReceiver", "push receive broadcast message, Intent:" + intent.getAction() + " pkgName:" + context.getPackageName());
            try {
                intent.getStringExtra("TestIntent");
                String action = intent.getAction();
                if (ResourceLoaderUtil.getmContext() == null) {
                    ResourceLoaderUtil.setmContext(context.getApplicationContext());
                }
                if ("com.huawei.android.push.intent.REGISTRATION".equals(action)) {
                    mo14523b(context, intent);
                } else if ("com.huawei.android.push.intent.RECEIVE".equals(action)) {
                    mo14522a(context, intent);
                } else {
                    HMSLog.m1379i("PushReceiver", "message can't be recognised:" + intent.toUri(0));
                }
            } catch (Exception unused) {
                HMSLog.m1377e("PushReceiver", "intent has some error");
            }
        }
    }

    /* renamed from: a */
    public final void mo14522a(Context context, Intent intent) {
        try {
            if (intent.hasExtra("msg_data")) {
                C0891u.m1326a().execute(new C0912a(context, intent));
            } else {
                HMSLog.m1379i("PushReceiver", "This push message dose not sent by hwpush.");
            }
        } catch (RuntimeException unused) {
            HMSLog.m1377e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
        } catch (Exception unused2) {
            HMSLog.m1377e("PushReceiver", "handlePushMessageEvent execute task error");
        }
    }

    /* renamed from: b */
    public static JSONObject m1359b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
        }
        return null;
    }

    /* renamed from: a */
    public static JSONObject m1357a(byte[] bArr) {
        try {
            return new JSONObject(C0895v.m1334a(bArr));
        } catch (JSONException unused) {
            HMSLog.m1380w("PushReceiver", "JSONException:parse message body failed.");
            return null;
        }
    }

    /* renamed from: b */
    public static JSONObject m1358b(Intent intent) {
        JSONObject a = m1357a(intent.getByteArrayExtra("msg_data"));
        JSONObject a2 = m1356a(a);
        String string = JsonUtil.getString(a2, RemoteMessageConst.DATA, (String) null);
        if (C0889s.m1317a(a2, m1359b(a2), string)) {
            return a;
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static JSONObject m1356a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
        }
        return null;
    }
}
