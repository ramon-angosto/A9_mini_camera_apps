package com.huawei.updatesdk.service.otaupdate;

import android.text.TextUtils;
import com.huawei.hms.common.PackageConstants;

/* renamed from: com.huawei.updatesdk.service.otaupdate.f */
public class C1085f {

    /* renamed from: e */
    private static C1085f f1482e = new C1085f();

    /* renamed from: a */
    private String f1483a;

    /* renamed from: b */
    private String f1484b;

    /* renamed from: c */
    private String f1485c = PackageConstants.SERVICES_PACKAGE_APPMARKET;

    /* renamed from: d */
    private String f1486d;

    private C1085f() {
    }

    /* renamed from: f */
    public static C1085f m2106f() {
        return f1482e;
    }

    /* renamed from: a */
    public String mo15201a() {
        return !TextUtils.isEmpty(this.f1483a) ? this.f1483a : this.f1484b;
    }

    /* renamed from: a */
    public void mo15202a(String str) {
        this.f1484b = str;
    }

    /* renamed from: b */
    public String mo15203b() {
        return this.f1483a;
    }

    /* renamed from: b */
    public void mo15204b(String str) {
        this.f1483a = str;
    }

    /* renamed from: c */
    public String mo15205c() {
        return this.f1485c;
    }

    /* renamed from: c */
    public void mo15206c(String str) {
        this.f1486d = str;
    }

    /* renamed from: d */
    public void mo15207d(String str) {
        this.f1485c = str;
    }

    /* renamed from: d */
    public boolean mo15208d() {
        String str = this.f1483a;
        if (str != null) {
            return str.equals(this.f1484b);
        }
        return true;
    }

    /* renamed from: e */
    public boolean mo15209e() {
        return TextUtils.equals(this.f1486d, "AppTouch");
    }
}
