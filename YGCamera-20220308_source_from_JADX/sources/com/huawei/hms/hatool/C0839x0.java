package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import com.xiaomi.mipush.sdk.Constants;
import java.util.UUID;

/* renamed from: com.huawei.hms.hatool.x0 */
public class C0839x0 {

    /* renamed from: b */
    public static C0839x0 f770b;

    /* renamed from: a */
    public Context f771a;

    /* renamed from: com.huawei.hms.hatool.x0$a */
    public static class C0840a extends C0842y0 {

        /* renamed from: a */
        public String f772a;

        /* renamed from: b */
        public String f773b;

        public C0840a(String str, String str2) {
            this.f772a = str;
            this.f773b = str2;
        }

        /* renamed from: a */
        public String mo14141a() {
            return C0773a.m706d(this.f772a, this.f773b);
        }

        /* renamed from: a */
        public String mo14142a(String str) {
            return SHA.sha256Encrypt(str);
        }

        /* renamed from: b */
        public String mo14143b() {
            return C0773a.m709g(this.f772a, this.f773b);
        }

        /* renamed from: c */
        public String mo14144c() {
            return C0773a.m712j(this.f772a, this.f773b);
        }

        /* renamed from: d */
        public int mo14145d() {
            char c = 0;
            boolean z = (C0773a.m713k(this.f772a, this.f773b) ? (char) 4 : 0) | false;
            if (C0773a.m707e(this.f772a, this.f773b)) {
                c = 2;
            }
            return (z | c) | C0773a.m710h(this.f772a, this.f773b) ? 1 : 0;
        }
    }

    /* renamed from: a */
    public static C0839x0 m1066a() {
        C0839x0 x0Var;
        synchronized (C0839x0.class) {
            if (f770b == null) {
                f770b = new C0839x0();
            }
            x0Var = f770b;
        }
        return x0Var;
    }

    /* renamed from: a */
    public String mo14133a(String str, String str2) {
        return C0795g.m824a(this.f771a, str, str2);
    }

    /* renamed from: a */
    public String mo14134a(boolean z) {
        if (!z) {
            return "";
        }
        String j = C0777b.m733j();
        if (TextUtils.isEmpty(j)) {
            j = C0796g0.m829a(this.f771a, "global_v2", "uuid", "");
            if (TextUtils.isEmpty(j)) {
                j = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
                C0796g0.m834b(this.f771a, "global_v2", "uuid", j);
            }
            C0777b.m726c(j);
        }
        return j;
    }

    /* renamed from: a */
    public void mo14135a(Context context) {
        if (this.f771a == null) {
            this.f771a = context;
        }
    }

    /* renamed from: b */
    public String mo14136b(String str, String str2) {
        return C0795g.m825b(this.f771a, str, str2);
    }

    /* renamed from: c */
    public C0834v0 mo14137c(String str, String str2) {
        return new C0840a(str, str2).mo14147a(this.f771a);
    }

    /* renamed from: d */
    public String mo14138d(String str, String str2) {
        return C0776a1.m720b(str, str2);
    }

    /* renamed from: e */
    public Pair<String, String> mo14139e(String str, String str2) {
        if (!C0773a.m708f(str, str2)) {
            return new Pair<>("", "");
        }
        String n = C0801i.m860c().mo13982b().mo14067n();
        String o = C0801i.m860c().mo13982b().mo14068o();
        if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(o)) {
            return new Pair<>(n, o);
        }
        Pair<String, String> e = C0844z0.m1111e(this.f771a);
        C0801i.m860c().mo13982b().mo14058i((String) e.first);
        C0801i.m860c().mo13982b().mo14060j((String) e.second);
        return e;
    }

    /* renamed from: f */
    public String mo14140f(String str, String str2) {
        return C0776a1.m719a(str, str2);
    }
}
