package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.h1 */
public class C0800h1 {

    /* renamed from: a */
    public String f635a;

    /* renamed from: b */
    public C0813m f636b;

    public C0800h1(String str) {
        this.f635a = str;
        this.f636b = new C0813m(str);
        C0801i.m860c().mo13981a(this.f635a, this.f636b);
    }

    /* renamed from: a */
    public void mo13972a(int i) {
        C0841y.m1082a("hmsSdk", "HiAnalyticsInstance.onReport() is execute.TAG: %s,TYPE: %d", this.f635a, Integer.valueOf(i));
        C0797g1.m836a().mo13963a(this.f635a, i);
    }

    /* renamed from: a */
    public void mo13973a(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        C0841y.m1082a("hmsSdk", "HiAnalyticsInstance.onEvent(int type, String eventId, Map<String, String> mapValue) is execute.TAG: %s,TYPE: %d", this.f635a, Integer.valueOf(i));
        if (C0824q0.m1003a(str) || !mo13978c(i)) {
            C0841y.m1091e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f635a + ", TYPE: " + i);
            return;
        }
        if (!C0824q0.m1006a((Map<String, String>) linkedHashMap)) {
            C0841y.m1091e("hmsSdk", "onEvent() parameter mapValue will be cleared.TAG: " + this.f635a + ", TYPE: " + i);
            linkedHashMap = null;
        }
        C0797g1.m836a().mo13964a(this.f635a, i, str, linkedHashMap);
    }

    /* renamed from: a */
    public void mo13974a(Context context, String str, String str2) {
        C0841y.m1087c("hmsSdk", "HiAnalyticsInstance.onEvent(eventId, mapValue) is execute.TAG : " + this.f635a);
        if (context == null) {
            C0841y.m1091e("hmsSdk", "context is null in onevent ");
        } else if (C0824q0.m1003a(str) || !mo13978c(0)) {
            C0841y.m1091e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f635a);
        } else {
            if (!C0824q0.m1004a("value", str2, 65536)) {
                C0841y.m1091e("hmsSdk", "onEvent() parameter VALUE is overlong, content will be cleared.TAG: " + this.f635a);
                str2 = "";
            }
            C0797g1.m836a().mo13965a(this.f635a, context, str, str2);
        }
    }

    /* renamed from: a */
    public void mo13975a(C0807k kVar) {
        C0841y.m1087c("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf() is executed.TAG : " + this.f635a);
        if (kVar == null) {
            C0841y.m1091e("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf(): config for maint is null!");
            this.f636b.mo14073a((C0807k) null);
            return;
        }
        this.f636b.mo14073a(kVar);
    }

    /* renamed from: b */
    public final C0807k mo13976b(int i) {
        if (i == 0) {
            return this.f636b.mo14076c();
        }
        if (i == 1) {
            return this.f636b.mo14074b();
        }
        if (i == 2) {
            return this.f636b.mo14077d();
        }
        if (i != 3) {
            return null;
        }
        return this.f636b.mo14071a();
    }

    /* renamed from: b */
    public void mo13977b(C0807k kVar) {
        C0841y.m1087c("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf() is executed.TAG: " + this.f635a);
        if (kVar == null) {
            this.f636b.mo14075b((C0807k) null);
            C0841y.m1091e("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf(): config for oper is null!");
            return;
        }
        this.f636b.mo14075b(kVar);
    }

    /* renamed from: c */
    public final boolean mo13978c(int i) {
        String str;
        if (i != 2) {
            C0807k b = mo13976b(i);
            if (b != null && !TextUtils.isEmpty(b.mo14022h())) {
                return true;
            }
            str = "verifyURL(): URL check failed. type: " + i;
        } else if ("_default_config_tag".equals(this.f635a)) {
            return true;
        } else {
            str = "verifyURL(): type: preins. Only default config can report Pre-install data.";
        }
        C0841y.m1091e("hmsSdk", str);
        return false;
    }
}
