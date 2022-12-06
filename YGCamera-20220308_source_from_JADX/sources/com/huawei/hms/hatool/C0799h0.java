package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.h0 */
public class C0799h0 {

    /* renamed from: b */
    public static C0799h0 f633b;

    /* renamed from: a */
    public Context f634a;

    static {
        new HashMap();
    }

    /* renamed from: a */
    public static C0799h0 m845a() {
        return m846b();
    }

    /* renamed from: b */
    public static synchronized C0799h0 m846b() {
        C0799h0 h0Var;
        synchronized (C0799h0.class) {
            if (f633b == null) {
                f633b = new C0799h0();
            }
            h0Var = f633b;
        }
        return h0Var;
    }

    /* renamed from: a */
    public void mo13966a(Context context) {
        this.f634a = context;
        mo13971b(context);
        C0801i.m860c().mo13982b().mo14050e(C0790f.m802a());
    }

    /* renamed from: a */
    public void mo13967a(String str, int i) {
        if (this.f634a == null) {
            C0841y.m1091e("hmsSdk", "onReport() null context or SDK was not init.");
            return;
        }
        C0841y.m1087c("hmsSdk", "onReport: Before calling runtaskhandler()");
        mo13970a(str, C0828s0.m1023a(i), C0777b.m727d());
    }

    /* renamed from: a */
    public void mo13968a(String str, int i, String str2, JSONObject jSONObject) {
        long currentTimeMillis = System.currentTimeMillis();
        if (2 == i) {
            currentTimeMillis = C0828s0.m1021a("yyyy-MM-dd", currentTimeMillis);
        }
        String str3 = str2;
        JSONObject jSONObject2 = jSONObject;
        String str4 = str;
        C0817n0.m971b().mo14082a(new C0805j0(str3, jSONObject2, str4, C0828s0.m1023a(i), currentTimeMillis));
    }

    /* renamed from: a */
    public void mo13969a(String str, String str2) {
        if (C0781c.m741a(str, str2)) {
            long j = C0781c.m750j(str, str2);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - j > 30000) {
                C0841y.m1081a("hmsSdk", "begin to call onReport!");
                C0781c.m740a(str, str2, currentTimeMillis);
                mo13970a(str, str2, C0777b.m727d());
                return;
            }
            C0841y.m1092f("hmsSdk", "autoReport timeout. interval < 30s ");
            return;
        }
        C0841y.m1087c("hmsSdk", "auto report is closed tag:" + str);
    }

    /* renamed from: a */
    public void mo13970a(String str, String str2, String str3) {
        Context context = this.f634a;
        if (context == null) {
            C0841y.m1091e("hmsSdk", "onReport() null context or SDK was not init.");
            return;
        }
        String a = C0798h.m844a(context);
        if (C0781c.m745e(str, str2) && !"WIFI".equals(a)) {
            C0841y.m1087c("hmsSdk", "strNetworkType is :" + a);
        } else if (TextUtils.isEmpty(a) || "2G".equals(a)) {
            C0841y.m1091e("hmsSdk", "The network is bad.");
        } else {
            C0817n0.m971b().mo14082a(new C0808k0(str, str2, str3));
        }
    }

    /* renamed from: b */
    public final void mo13971b(Context context) {
        String str;
        String d = C0790f.m809d(context);
        C0777b.m722a(d);
        if (C0832u0.m1039b().mo14121a()) {
            String a = C0796g0.m829a(context, "global_v2", "app_ver", "");
            C0796g0.m834b(context, "global_v2", "app_ver", d);
            C0777b.m724b(a);
            if (TextUtils.isEmpty(a)) {
                str = "app ver is first save!";
            } else if (!a.equals(d)) {
                C0841y.m1087c("hmsSdk", "the appVers are different!");
                m845a().mo13970a("", "alltype", a);
                return;
            } else {
                return;
            }
        } else {
            str = "userManager.isUserUnlocked() == false";
        }
        C0841y.m1087c("hmsSdk", str);
    }
}
