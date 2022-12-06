package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.C1618ak;
import com.xiaomi.push.C1685ci;
import com.xiaomi.push.service.C1995at;
import com.xiaomi.push.service.C2033bs;

/* renamed from: com.xiaomi.push.bw */
public class C1671bw {

    /* renamed from: a */
    private static volatile C1671bw f1890a;

    /* renamed from: a */
    private Context f1891a;

    /* renamed from: a */
    private C1618ak.C1619a f1892a = new C1672bx(this);

    /* renamed from: a */
    private C1693cl f1893a;

    /* renamed from: a */
    private C1694cm f1894a;

    /* renamed from: a */
    private final String f1895a = "push_stat_sp";

    /* renamed from: b */
    private C1618ak.C1619a f1896b = new C1673by(this);

    /* renamed from: b */
    private final String f1897b = "upload_time";

    /* renamed from: c */
    private C1618ak.C1619a f1898c = new C1674bz(this);

    /* renamed from: c */
    private final String f1899c = "delete_time";

    /* renamed from: d */
    private final String f1900d = "check_time";

    /* renamed from: e */
    private String f1901e;

    /* renamed from: f */
    private String f1902f;

    private C1671bw(Context context) {
        this.f1891a = context;
    }

    /* renamed from: a */
    public static C1671bw m2760a(Context context) {
        if (f1890a == null) {
            synchronized (C1671bw.class) {
                if (f1890a == null) {
                    f1890a = new C1671bw(context);
                }
            }
        }
        return f1890a;
    }

    /* renamed from: a */
    private boolean mo17270a() {
        return C1995at.m5047a(this.f1891a).mo18472a(C1873ht.StatDataSwitch.mo17806a(), true);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2765b(String str) {
        SharedPreferences.Editor edit = this.f1891a.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        C1945s.m4744a(edit);
    }

    /* renamed from: c */
    private String m2766c() {
        return this.f1891a.getDatabasePath(C1677ca.f1912a).getAbsolutePath();
    }

    /* renamed from: a */
    public String m2767a() {
        return this.f1901e;
    }

    /* renamed from: a */
    public void mo17271a(C1685ci.C1686a aVar) {
        C1685ci.m2838a(this.f1891a).mo17312a(aVar);
    }

    /* renamed from: a */
    public void mo17272a(C1872hs hsVar) {
        if (mo17270a() && C2033bs.m5181a(hsVar.mo17794e())) {
            mo17271a((C1685ci.C1686a) C1682cf.m2834a(this.f1891a, m2766c(), hsVar));
        }
    }

    /* renamed from: a */
    public void mo17273a(String str) {
        if (mo17270a() && !TextUtils.isEmpty(str)) {
            mo17272a(C1695cn.m2869a(this.f1891a, str));
        }
    }

    /* renamed from: a */
    public void mo17274a(String str, String str2, Boolean bool) {
        if (this.f1893a == null) {
            return;
        }
        if (bool.booleanValue()) {
            this.f1893a.mo17324a(this.f1891a, str2, str);
        } else {
            this.f1893a.mo17325b(this.f1891a, str2, str);
        }
    }

    /* renamed from: b */
    public String mo17275b() {
        return this.f1902f;
    }
}
