package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;

/* renamed from: com.huawei.hms.hatool.g */
public abstract class C0795g {
    /* renamed from: a */
    public static String m824a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(C0773a.m703a(str, str2))) {
            return C0773a.m703a(str, str2);
        }
        C0841y.m1087c("hmsSdk", "getAndroidId(): to getConfigByType()");
        return m826c(context, str, str2);
    }

    /* renamed from: b */
    public static String m825b(Context context, String str, String str2) {
        if (str2.equals("oper")) {
            return m827d(context, str, str2);
        }
        if (str2.equals("maint")) {
            return m827d(context, str, str2);
        }
        if (str2.equals("diffprivacy")) {
            return m827d(context, str, str2);
        }
        if (str2.equals("preins")) {
            return m827d(context, str, str2);
        }
        C0841y.m1092f("hmsSdk", "getChannel(): Invalid type: " + str2);
        return "";
    }

    /* renamed from: c */
    public static String m826c(Context context, String str, String str2) {
        if (!C0773a.m704b(str, str2)) {
            return "";
        }
        if (TextUtils.isEmpty(C0777b.m723b())) {
            C0801i.m860c().mo13982b().mo14044b(C0790f.m803a(context));
        }
        return C0777b.m723b();
    }

    /* renamed from: d */
    public static String m827d(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(C0781c.m744d(str, str2))) {
            return C0781c.m744d(str, str2);
        }
        C0810l b = C0801i.m860c().mo13982b();
        if (TextUtils.isEmpty(b.mo14053g())) {
            String b2 = C0790f.m807b(context);
            if (!C0824q0.m1004a("channel", b2, 256)) {
                b2 = "";
            }
            b.mo14048d(b2);
        }
        return b.mo14053g();
    }
}
