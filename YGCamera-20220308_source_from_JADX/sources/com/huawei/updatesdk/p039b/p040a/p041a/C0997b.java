package com.huawei.updatesdk.p039b.p040a.p041a;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.huawei.updatesdk.p025a.p026a.p031d.C0972d;
import com.huawei.updatesdk.p039b.p043b.C1003a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.updatesdk.b.a.a.b */
public class C0997b {

    /* renamed from: b */
    private static C0997b f1350b;

    /* renamed from: a */
    private final Map<String, C0996a> f1351a = new HashMap();

    private C0997b() {
    }

    /* renamed from: a */
    public static synchronized C0997b m1814a() {
        C0997b bVar;
        synchronized (C0997b.class) {
            if (f1350b == null) {
                f1350b = new C0997b();
            }
            bVar = f1350b;
        }
        return bVar;
    }

    /* renamed from: a */
    public String mo14944a(PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.packageName == null || TextUtils.isEmpty(packageInfo.applicationInfo.sourceDir)) {
            return null;
        }
        C0996a aVar = this.f1351a.get(packageInfo.packageName);
        if (aVar != null && aVar.mo14942b() == packageInfo.lastUpdateTime && aVar.mo14943c() == packageInfo.versionCode) {
            return aVar.mo14938a();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(packageInfo.lastUpdateTime);
        sb.append(packageInfo.versionCode);
        sb.append(packageInfo.packageName);
        String str = "packagekey" + packageInfo.packageName;
        String str2 = "fileshakey" + packageInfo.packageName;
        boolean z = !TextUtils.equals(sb.toString(), C1003a.m1831d().mo14962c(str));
        if (z) {
            C1003a.m1831d().mo14958a(str, sb.toString());
        }
        String c = C1003a.m1831d().mo14962c(str2);
        if (TextUtils.isEmpty(c) || z) {
            c = C0972d.m1691a(packageInfo.applicationInfo.sourceDir, "SHA-256");
            C1003a.m1831d().mo14958a(str2, c);
        }
        C0996a aVar2 = new C0996a();
        aVar2.mo14941a(c);
        aVar2.mo14940a(packageInfo.lastUpdateTime);
        aVar2.mo14939a(packageInfo.versionCode);
        this.f1351a.put(packageInfo.packageName, aVar2);
        return c;
    }
}
