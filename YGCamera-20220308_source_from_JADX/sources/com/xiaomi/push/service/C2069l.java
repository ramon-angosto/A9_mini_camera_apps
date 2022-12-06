package com.xiaomi.push.service;

import com.xiaomi.push.C1867hn;
import com.xiaomi.push.C1872hs;
import com.xiaomi.push.service.XMPushService;
import java.util.List;

/* renamed from: com.xiaomi.push.service.l */
public class C2069l implements C1867hn {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final XMPushService f3920a;

    public C2069l(XMPushService xMPushService) {
        this.f3920a = xMPushService;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m5292a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f3920a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, (String) null);
    }

    /* renamed from: a */
    public void mo17765a(List<C1872hs> list, String str, String str2) {
        this.f3920a.mo18412a((XMPushService.C1956i) new C2070m(this, 4, str, list, str2));
    }
}
