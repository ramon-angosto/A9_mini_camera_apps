package com.huawei.updatesdk.p039b.p044c;

import com.huawei.hms.common.PackageConstants;
import com.huawei.updatesdk.p025a.p026a.p031d.p032h.C0981c;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.updatesdk.b.c.e */
public class C1011e extends C1009c {
    /* renamed from: a */
    public String mo14972a() {
        return PackageConstants.SERVICES_PACKAGE_APPMARKET_TV;
    }

    /* renamed from: b */
    public int mo14973b() {
        return 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo14974c() {
        return C0981c.m1727a("ro.product.manufacturer", "");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo14975d() {
        return C0981c.m1727a("ro.product.hw_model", "");
    }

    /* renamed from: g */
    public List<String> mo14976g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("CE1EF7188F820973C191227D95D54311ED3A65EC83E37009E898A1C058BBC775");
        return arrayList;
    }
}
