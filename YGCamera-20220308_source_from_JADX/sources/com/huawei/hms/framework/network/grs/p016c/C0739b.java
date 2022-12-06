package com.huawei.hms.framework.network.grs.p016c;

import android.content.Context;
import android.net.Uri;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.p014a.C0728c;
import java.util.concurrent.Callable;

/* renamed from: com.huawei.hms.framework.network.grs.c.b */
public class C0739b {

    /* renamed from: a */
    protected C0748f f489a;

    /* renamed from: b */
    private String f490b;

    /* renamed from: c */
    private C0737a f491c;

    /* renamed from: d */
    private int f492d;

    /* renamed from: e */
    private Context f493e;

    /* renamed from: f */
    private String f494f;

    /* renamed from: g */
    private GrsBaseInfo f495g;

    /* renamed from: h */
    private C0728c f496h;

    /* renamed from: com.huawei.hms.framework.network.grs.c.b$a */
    private enum C0740a {
        GRSPOST,
        GRSGET,
        GRSDEFAULT
    }

    public C0739b(String str, int i, C0737a aVar, Context context, String str2, GrsBaseInfo grsBaseInfo, C0728c cVar) {
        this.f490b = str;
        this.f491c = aVar;
        this.f492d = i;
        this.f493e = context;
        this.f494f = str2;
        this.f495g = grsBaseInfo;
        this.f496h = cVar;
    }

    /* renamed from: a */
    private String m558a(String str) {
        return Uri.parse(str).getPath();
    }

    /* renamed from: h */
    private C0740a m559h() {
        if (this.f490b.isEmpty()) {
            return C0740a.GRSDEFAULT;
        }
        String a = m558a(this.f490b);
        return a.contains("1.0") ? C0740a.GRSGET : a.contains("2.0") ? C0740a.GRSPOST : C0740a.GRSDEFAULT;
    }

    /* renamed from: a */
    public C0737a mo13834a() {
        return this.f491c;
    }

    /* renamed from: b */
    public Context mo13835b() {
        return this.f493e;
    }

    /* renamed from: c */
    public String mo13836c() {
        return this.f490b;
    }

    /* renamed from: d */
    public int mo13837d() {
        return this.f492d;
    }

    /* renamed from: e */
    public String mo13838e() {
        return this.f494f;
    }

    /* renamed from: f */
    public C0728c mo13839f() {
        return this.f496h;
    }

    /* renamed from: g */
    public Callable<C0748f> mo13840g() {
        if (C0740a.GRSDEFAULT.equals(m559h())) {
            return null;
        }
        return C0740a.GRSGET.equals(m559h()) ? new C0751i(this.f490b, this.f492d, this.f491c, this.f493e, this.f494f, this.f495g) : new C0752j(this.f490b, this.f492d, this.f491c, this.f493e, this.f494f, this.f495g, this.f496h);
    }
}
