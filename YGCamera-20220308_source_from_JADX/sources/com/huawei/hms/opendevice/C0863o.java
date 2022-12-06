package com.huawei.hms.opendevice;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.push.HmsMessaging;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.util.UUID;

/* renamed from: com.huawei.hms.opendevice.o */
/* compiled from: AaidUtils */
public class C0863o {
    /* renamed from: a */
    public static String m1168a(Context context) {
        PushPreferences pushPreferences = new PushPreferences(context, "aaid");
        if (pushPreferences.containsKey("aaid")) {
            return pushPreferences.getString("aaid");
        }
        return null;
    }

    /* renamed from: b */
    public static TokenReq m1171b(Context context, String str, String str2) {
        return m1172b(context, str, (String) null, (String) null, str2);
    }

    /* renamed from: c */
    public static synchronized String m1173c(Context context) {
        String str;
        synchronized (C0863o.class) {
            PushPreferences pushPreferences = new PushPreferences(context, "aaid");
            if (pushPreferences.containsKey("aaid")) {
                str = pushPreferences.getString("aaid");
            } else {
                str = UUID.randomUUID().toString();
                pushPreferences.saveString("aaid", str);
                pushPreferences.saveLong("creationTime", Long.valueOf(System.currentTimeMillis()));
            }
        }
        return str;
    }

    /* renamed from: d */
    public static String m1174d(Context context) {
        return AGConnectServicesConfig.fromContext(context).getString("client/project_id");
    }

    /* renamed from: e */
    public static boolean m1175e(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                if (applicationInfo.metaData != null) {
                    if (TextUtils.isEmpty(applicationInfo.metaData.getString("com.huawei.hms.client.service.name:base"))) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.m1377e(HmsInstanceId.TAG, "isIntegratedBaseSdk failed.");
            return true;
        }
    }

    /* renamed from: b */
    public static TokenReq m1170b(Context context, String str) {
        return m1172b(context, (String) null, (String) null, str, (String) null);
    }

    /* renamed from: b */
    public static TokenReq m1172b(Context context, String str, String str2, String str3, String str4) {
        TokenReq tokenReq = new TokenReq();
        tokenReq.setPackageName(context.getPackageName());
        tokenReq.setAppId(str);
        tokenReq.setScope(str4);
        tokenReq.setProjectId(str2);
        tokenReq.setSubjectId(str3);
        tokenReq.setMultiSender(false);
        if (TextUtils.isEmpty(str)) {
            tokenReq.setAppId(Util.getAppId(context));
        }
        if (TextUtils.isEmpty(str2)) {
            tokenReq.setProjectId(m1174d(context));
        }
        if (TextUtils.isEmpty(str4)) {
            tokenReq.setScope(HmsMessaging.DEFAULT_TOKEN_SCOPE);
        }
        C0855i a = C0855i.m1144a(context);
        if (!a.getBoolean("hasRequestAgreement")) {
            tokenReq.setFirstTime(true);
            a.saveBoolean("hasRequestAgreement", true);
        } else {
            tokenReq.setFirstTime(false);
        }
        return tokenReq;
    }

    /* renamed from: a */
    public static DeleteTokenReq m1167a(Context context, String str, String str2, String str3, String str4) {
        DeleteTokenReq deleteTokenReq = new DeleteTokenReq();
        deleteTokenReq.setAppId(str);
        deleteTokenReq.setScope(str4);
        deleteTokenReq.setProjectId(str2);
        deleteTokenReq.setPkgName(context.getPackageName());
        deleteTokenReq.setSubjectId(str3);
        if (TextUtils.isEmpty(str)) {
            deleteTokenReq.setAppId(Util.getAppId(context));
        }
        if (TextUtils.isEmpty(str4)) {
            deleteTokenReq.setScope(HmsMessaging.DEFAULT_TOKEN_SCOPE);
        }
        if (TextUtils.isEmpty(str2)) {
            deleteTokenReq.setProjectId(m1174d(context));
        }
        return deleteTokenReq;
    }

    /* renamed from: a */
    public static DeleteTokenReq m1166a(Context context, String str, String str2) {
        return m1167a(context, str, (String) null, (String) null, str2);
    }

    /* renamed from: a */
    public static DeleteTokenReq m1165a(Context context, String str) {
        return m1167a(context, (String) null, (String) null, str, (String) null);
    }

    /* renamed from: b */
    public static DeleteTokenReq m1169b(Context context) {
        return m1167a(context, (String) null, (String) null, (String) null, (String) null);
    }
}
