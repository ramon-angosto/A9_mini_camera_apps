package com.huawei.updatesdk.p039b.p040a.p042b;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.ArrayMap;
import android.util.ArraySet;
import com.huawei.updatesdk.p025a.p026a.p031d.C0975g;
import com.huawei.updatesdk.p039b.p040a.p042b.C0998a;
import com.huawei.updatesdk.p039b.p040a.p042b.C1001c;
import java.io.File;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.updatesdk.b.a.b.b */
public class C1000b {

    /* renamed from: b */
    private static C1000b f1356b;

    /* renamed from: a */
    private final Map<String, C0998a> f1357a = new HashMap();

    private C1000b() {
    }

    /* renamed from: a */
    public static synchronized C1000b m1824a() {
        C1000b bVar;
        synchronized (C1000b.class) {
            if (f1356b == null) {
                f1356b = new C1000b();
            }
            bVar = f1356b;
        }
        return bVar;
    }

    /* renamed from: a */
    private static void m1825a(C0998a aVar) {
        m1824a().f1357a.put(aVar.mo14950c(), aVar);
    }

    /* renamed from: b */
    private static ArrayList<String> m1826b(PackageInfo packageInfo) {
        ArraySet<String> arraySet;
        C0998a aVar = new C0998a();
        aVar.mo14948a(packageInfo.packageName);
        File file = new File(packageInfo.applicationInfo.sourceDir);
        if (!file.exists()) {
            return null;
        }
        aVar.mo14946a(file.lastModified());
        C1001c.C1002a a = C1001c.m1828a(file);
        ArrayMap<String, ArraySet<PublicKey>> arrayMap = a.f1358a;
        if (arrayMap == null || arrayMap.isEmpty() || (arraySet = a.f1359b) == null || arraySet.isEmpty()) {
            m1825a(aVar);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry next : a.f1358a.entrySet()) {
            if (a.f1359b.contains((String) next.getKey())) {
                Iterator it = ((ArraySet) next.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(C0975g.m1703a(((PublicKey) it.next()).getEncoded()));
                }
            }
        }
        C0998a.C0999a aVar2 = new C0998a.C0999a();
        aVar2.mo14952a(arrayList);
        aVar.mo14947a(aVar2);
        m1825a(aVar);
        return arrayList;
    }

    /* renamed from: a */
    public List<String> mo14953a(PackageInfo packageInfo) {
        String str;
        if (Build.VERSION.SDK_INT < 21 || packageInfo == null || (str = packageInfo.applicationInfo.sourceDir) == null) {
            return null;
        }
        long lastModified = new File(str).lastModified();
        C0998a aVar = m1824a().f1357a.get(packageInfo.packageName);
        if (aVar == null || aVar.mo14949b() != lastModified) {
            return m1826b(packageInfo);
        }
        if (aVar.mo14945a() == null) {
            return null;
        }
        return aVar.mo14945a().mo14951a();
    }
}
