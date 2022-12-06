package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.support.log.HMSLog;
import java.util.Map;

/* renamed from: com.huawei.hms.opendevice.i */
/* compiled from: PushClientSp */
public class C0855i extends PushPreferences {
    public static final String TAG = "i";

    /* renamed from: b */
    public Context f794b;

    public C0855i(Context context) {
        super(context, "push_client_self_info");
        this.f794b = context;
    }

    /* renamed from: a */
    public static C0855i m1144a(Context context) {
        return new C0855i(context);
    }

    /* renamed from: b */
    public String mo14167b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return mo14164a("token_info_v2");
            }
            return mo14164a(str);
        } catch (Exception e) {
            String str2 = TAG;
            HMSLog.m1377e(str2, "getSecureData" + e.getMessage());
            return "";
        }
    }

    /* renamed from: c */
    public boolean mo14169c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return removeKey("token_info_v2");
            }
            return removeKey(str);
        } catch (Exception e) {
            String str2 = TAG;
            HMSLog.m1377e(str2, "removeToken" + e.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public String mo14164a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return PushEncrypter.decrypter(this.f794b, getString(str));
        } catch (Exception e) {
            String str2 = TAG;
            HMSLog.m1377e(str2, "getSecureData" + e.getMessage());
            return "";
        }
    }

    /* renamed from: a */
    public boolean mo14166a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return saveString(str, PushEncrypter.encrypter(this.f794b, str2));
        } catch (Exception e) {
            String str3 = TAG;
            HMSLog.m1377e(str3, "saveSecureData" + e.getMessage());
            return false;
        }
    }

    /* renamed from: b */
    public boolean mo14168b(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return mo14166a("token_info_v2", str2);
            }
            return mo14166a(str, str2);
        } catch (Exception e) {
            String str3 = TAG;
            HMSLog.m1377e(str3, "saveSecureData" + e.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public void mo14165a() {
        Map<String, ?> all = getAll();
        if (!all.isEmpty() && !all.keySet().isEmpty()) {
            for (String next : all.keySet()) {
                if (!"push_kit_auto_init_enabled".equals(next) && !"_proxy_init".equals(next)) {
                    removeKey(next);
                }
            }
        }
    }
}
