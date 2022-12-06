package com.meizu.cloud.pushsdk.handler.a.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.MPushMessage;
import com.meizu.cloud.pushsdk.notification.e;
import com.meizu.cloud.pushsdk.util.c;
import com.meizu.cloud.pushsdk.util.d;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Map;

public class a extends com.meizu.cloud.pushsdk.handler.a.a<MessageV3> {
    public int a() {
        return 64;
    }

    public a(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public MessageV3 c(Intent intent) {
        try {
            DebugLogger.e("AbstractMessageHandler", "parse message V3");
            MessageV3 messageV3 = (MessageV3) intent.getParcelableExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE);
            if (messageV3 != null) {
                return messageV3;
            }
        } catch (Exception unused) {
            DebugLogger.e("AbstractMessageHandler", "cannot get messageV3");
        } catch (Throwable th) {
            DebugLogger.e("AbstractMessageHandler", "parse MessageV2 to MessageV3");
            MPushMessage mPushMessage = (MPushMessage) intent.getSerializableExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE);
            MessageV3.parse(g(intent), d(intent), mPushMessage.getTaskId(), mPushMessage);
            throw th;
        }
        DebugLogger.e("AbstractMessageHandler", "parse MessageV2 to MessageV3");
        MPushMessage mPushMessage2 = (MPushMessage) intent.getSerializableExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE);
        return MessageV3.parse(g(intent), d(intent), mPushMessage2.getTaskId(), mPushMessage2);
    }

    /* access modifiers changed from: protected */
    public void a(MessageV3 messageV3, e eVar) {
        c.a(c(), messageV3.getPackageName(), 0);
        Intent a = a(c(), messageV3);
        if (a != null) {
            a.addFlags(268435456);
            try {
                c().startActivity(a);
            } catch (Exception e) {
                DebugLogger.e("AbstractMessageHandler", "Click message StartActivity error " + e.getMessage());
            }
        }
        if (!TextUtils.isEmpty(messageV3.getTitle()) && !TextUtils.isEmpty(messageV3.getContent())) {
            b().a(c(), messageV3.getTitle(), messageV3.getContent(), a(messageV3.getWebUrl(), messageV3.getParamsMap()));
        }
    }

    public boolean a(Intent intent) {
        DebugLogger.i("AbstractMessageHandler", "start NotificationClickMessageHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equals(i(intent));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void b(MessageV3 messageV3) {
        d.e(c(), messageV3.getUploadDataPackageName(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp());
    }

    private Intent a(Context context, MessageV3 messageV3) {
        if (messageV3.getClickType() == 0) {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(messageV3.getUploadDataPackageName());
            if (launchIntentForPackage == null || messageV3.getParamsMap() == null) {
                return launchIntentForPackage;
            }
            for (Map.Entry next : messageV3.getParamsMap().entrySet()) {
                DebugLogger.i("AbstractMessageHandler", " launcher activity key " + ((String) next.getKey()) + " value " + ((String) next.getValue()));
                if (!TextUtils.isEmpty((CharSequence) next.getKey()) && !TextUtils.isEmpty((CharSequence) next.getValue())) {
                    launchIntentForPackage.putExtra((String) next.getKey(), b((String) next.getValue()));
                }
            }
            return launchIntentForPackage;
        } else if (1 == messageV3.getClickType()) {
            String str = "";
            String str2 = ";";
            if (messageV3.getParamsMap() != null) {
                for (Map.Entry next2 : messageV3.getParamsMap().entrySet()) {
                    DebugLogger.i("AbstractMessageHandler", " key " + ((String) next2.getKey()) + " value " + ((String) next2.getValue()));
                    if (!TextUtils.isEmpty((CharSequence) next2.getKey()) && !TextUtils.isEmpty((CharSequence) next2.getValue())) {
                        str = str + "S." + ((String) next2.getKey()) + "=" + b((String) next2.getValue()) + str2;
                    }
                    DebugLogger.i("AbstractMessageHandler", "paramValue " + str);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("intent:#Intent;component=");
            sb.append(messageV3.getUploadDataPackageName());
            sb.append("/");
            sb.append(messageV3.getActivity());
            if (!TextUtils.isEmpty(str)) {
                str2 = str2 + str;
            }
            sb.append(str2);
            sb.append("end");
            String sb2 = sb.toString();
            DebugLogger.i("AbstractMessageHandler", "open activity intent uri " + sb2);
            try {
                return Intent.parseUri(sb2, 1);
            } catch (URISyntaxException e) {
                DebugLogger.e("AbstractMessageHandler", "parse Uri error " + e.getMessage());
                return null;
            }
        } else if (2 == messageV3.getClickType()) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(messageV3.getWebUrl()));
            String uriPackageName = messageV3.getUriPackageName();
            if (TextUtils.isEmpty(uriPackageName)) {
                return intent;
            }
            intent.setPackage(uriPackageName);
            DebugLogger.i("AbstractMessageHandler", "set uri package " + uriPackageName);
            return intent;
        } else if (3 != messageV3.getClickType()) {
            return null;
        } else {
            DebugLogger.i("AbstractMessageHandler", "CLICK_TYPE_SELF_DEFINE_ACTION");
            return null;
        }
    }

    private String b(String str) {
        try {
            str = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            DebugLogger.i("AbstractMessageHandler", "encode url fail");
        }
        Log.i("AbstractMessageHandler", "encode all value is " + str);
        return str;
    }
}
