package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;

/* renamed from: com.huawei.hms.hatool.y0 */
public abstract class C0842y0 {
    /* renamed from: a */
    public final C0834v0 mo14146a(int i, Context context) {
        String str;
        if (i != 0) {
            str = mo14152f();
            if (!TextUtils.isEmpty(str)) {
                return new C0834v0(C0836w0.UDID, str);
            }
        } else {
            str = "";
        }
        if ((i & 2) != 0) {
            str = mo14149b(context);
            if (!TextUtils.isEmpty(str)) {
                return new C0834v0(C0836w0.IMEI, str);
            }
        }
        if ((i & 1) == 0) {
            return new C0834v0(C0836w0.EMPTY, str);
        }
        return new C0834v0(C0836w0.SN, mo14150c(context));
    }

    /* renamed from: a */
    public C0834v0 mo14147a(Context context) {
        C0834v0 v0Var;
        String c = mo14144c();
        if (!TextUtils.isEmpty(c)) {
            return new C0834v0(C0836w0.UDID, c);
        }
        String a = mo14141a();
        if (!TextUtils.isEmpty(a)) {
            return new C0834v0(C0836w0.IMEI, a);
        }
        boolean e = mo14151e();
        String b = mo14143b();
        if (TextUtils.isEmpty(b)) {
            return e ? mo14146a(mo14145d(), context) : mo14148b(mo14145d(), context);
        }
        if (e) {
            C0836w0 w0Var = C0836w0.SN;
            return v0Var;
        }
        v0Var = new C0834v0(C0836w0.UDID, mo14142a(b));
        return v0Var;
    }

    /* renamed from: a */
    public abstract String mo14141a();

    /* renamed from: a */
    public abstract String mo14142a(String str);

    /* renamed from: b */
    public final C0834v0 mo14148b(int i, Context context) {
        String str;
        if ((i & 4) != 0 && (i & 1) != 0) {
            return new C0834v0(C0836w0.UDID, mo14142a(mo14150c(context)));
        }
        if ((i & 1) != 0) {
            str = mo14150c(context);
            if (!TextUtils.isEmpty(str)) {
                return new C0834v0(C0836w0.SN, str);
            }
        } else {
            str = "";
        }
        if ((i & 2) == 0) {
            return new C0834v0(C0836w0.EMPTY, str);
        }
        return new C0834v0(C0836w0.IMEI, mo14149b(context));
    }

    /* renamed from: b */
    public abstract String mo14143b();

    /* renamed from: b */
    public final String mo14149b(Context context) {
        C0810l b = C0801i.m860c().mo13982b();
        if (TextUtils.isEmpty(b.mo14065m())) {
            b.mo14056h(C0844z0.m1112f(context));
        }
        return b.mo14065m();
    }

    /* renamed from: c */
    public abstract String mo14144c();

    /* renamed from: c */
    public final String mo14150c(Context context) {
        C0810l b = C0801i.m860c().mo13982b();
        if (TextUtils.isEmpty(b.mo14040a())) {
            b.mo14064l(C0844z0.m1114h(context));
        }
        return b.mo14040a();
    }

    /* renamed from: d */
    public abstract int mo14145d();

    /* renamed from: e */
    public final boolean mo14151e() {
        C0810l b = C0801i.m860c().mo13982b();
        if (TextUtils.isEmpty(b.mo14057i())) {
            b.mo14050e(C0790f.m802a());
        }
        return !TextUtils.isEmpty(b.mo14057i());
    }

    /* renamed from: f */
    public final String mo14152f() {
        C0810l b = C0801i.m860c().mo13982b();
        if (TextUtils.isEmpty(b.mo14045c())) {
            b.mo14066m(C0844z0.m1110c());
        }
        return b.mo14045c();
    }
}
