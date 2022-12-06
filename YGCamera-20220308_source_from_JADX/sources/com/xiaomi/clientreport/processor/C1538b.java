package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.clientreport.data.C1526a;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.push.C1667bs;
import java.io.File;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.xiaomi.clientreport.processor.b */
public class C1538b implements IPerfProcessor {

    /* renamed from: a */
    protected Context f1611a;

    /* renamed from: a */
    private HashMap<String, HashMap<String, C1526a>> f1612a;

    public C1538b(Context context) {
        this.f1611a = context;
    }

    /* renamed from: a */
    public static String mo16999a(C1526a aVar) {
        return String.valueOf(aVar.production) + "#" + aVar.clientInterfaceId;
    }

    /* renamed from: b */
    private String m2204b(C1526a aVar) {
        String str;
        int i = aVar.production;
        String str2 = aVar.clientInterfaceId;
        if (i <= 0 || TextUtils.isEmpty(str2)) {
            str = "";
        } else {
            str = String.valueOf(i) + "#" + str2;
        }
        File externalFilesDir = this.f1611a.getExternalFilesDir("perf");
        if (externalFilesDir == null) {
            C1524b.m2160d("cannot get folder when to write perf");
            return null;
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        return new File(externalFilesDir, str).getAbsolutePath();
    }

    /* renamed from: c */
    private String m2205c(C1526a aVar) {
        String b = m2204b(aVar);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        for (int i = 0; i < 20; i++) {
            String str = b + i;
            if (C1667bs.m2747a(this.f1611a, str)) {
                return str;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo16997a() {
        C1667bs.m2748a(this.f1611a, "perf", "perfUploading");
        File[] a = C1667bs.m2747a(this.f1611a, "perfUploading");
        if (a != null && a.length > 0) {
            for (File file : a) {
                if (file != null) {
                    List<String> a2 = C1541e.m2218a(this.f1611a, file.getAbsolutePath());
                    file.delete();
                    mo17003a(a2);
                }
            }
        }
    }

    /* renamed from: a */
    public void m2207a(C1526a aVar) {
        if ((aVar instanceof PerfClientReport) && this.f1612a != null) {
            PerfClientReport perfClientReport = (PerfClientReport) aVar;
            String a = mo16999a((C1526a) perfClientReport);
            String a2 = C1541e.m2216a(perfClientReport);
            HashMap hashMap = this.f1612a.get(a);
            if (hashMap == null) {
                hashMap = new HashMap();
            }
            PerfClientReport perfClientReport2 = (PerfClientReport) hashMap.get(a2);
            if (perfClientReport2 != null) {
                perfClientReport.perfCounts += perfClientReport2.perfCounts;
                perfClientReport.perfLatencies += perfClientReport2.perfLatencies;
            }
            hashMap.put(a2, perfClientReport);
            this.f1612a.put(a, hashMap);
        }
    }

    /* renamed from: a */
    public void mo17003a(List<String> list) {
        C1667bs.m2749a(this.f1611a, list);
    }

    /* renamed from: a */
    public void mo17004a(C1526a[] aVarArr) {
        String c = m2205c(aVarArr[0]);
        if (!TextUtils.isEmpty(c)) {
            C1541e.m2220a(c, aVarArr);
        }
    }

    /* renamed from: b */
    public void mo17002b() {
        HashMap<String, HashMap<String, C1526a>> hashMap = this.f1612a;
        if (hashMap != null) {
            if (hashMap.size() > 0) {
                for (String str : this.f1612a.keySet()) {
                    HashMap hashMap2 = this.f1612a.get(str);
                    if (hashMap2 != null && hashMap2.size() > 0) {
                        C1526a[] aVarArr = new C1526a[hashMap2.size()];
                        hashMap2.values().toArray(aVarArr);
                        mo17004a(aVarArr);
                    }
                }
            }
            this.f1612a.clear();
        }
    }

    public void setPerfMap(HashMap<String, HashMap<String, C1526a>> hashMap) {
        this.f1612a = hashMap;
    }
}
