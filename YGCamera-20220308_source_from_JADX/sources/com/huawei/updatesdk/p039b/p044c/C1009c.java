package com.huawei.updatesdk.p039b.p044c;

import android.os.Build;
import android.text.TextUtils;
import java.util.List;

/* renamed from: com.huawei.updatesdk.b.c.c */
public abstract class C1009c {

    /* renamed from: a */
    private String f1370a;

    /* renamed from: b */
    private String f1371b;

    /* renamed from: a */
    public abstract String mo14972a();

    /* renamed from: b */
    public abstract int mo14973b();

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract String mo14974c();

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract String mo14975d();

    /* renamed from: e */
    public String mo14977e() {
        if (!TextUtils.isEmpty(this.f1371b)) {
            return this.f1371b;
        }
        this.f1371b = mo14974c();
        if (TextUtils.isEmpty(this.f1371b)) {
            this.f1371b = Build.MANUFACTURER;
        }
        return this.f1371b;
    }

    /* renamed from: f */
    public String mo14978f() {
        if (!TextUtils.isEmpty(this.f1370a)) {
            return this.f1370a;
        }
        this.f1370a = mo14975d();
        if (TextUtils.isEmpty(this.f1370a)) {
            this.f1370a = Build.MODEL;
        }
        return this.f1370a;
    }

    /* renamed from: g */
    public abstract List<String> mo14976g();
}
