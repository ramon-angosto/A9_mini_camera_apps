package com.huawei.updatesdk.p039b.p049h;

import android.text.TextUtils;
import com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a;
import com.huawei.updatesdk.p025a.p026a.p031d.p032h.C0981c;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.updatesdk.b.h.a */
public final class C1036a {

    /* renamed from: b */
    private static final Map<Integer, String> f1398b = new HashMap();

    /* renamed from: c */
    private static C1036a f1399c = new C1036a();

    /* renamed from: a */
    private int f1400a;

    static {
        f1398b.put(1, "1.0");
        f1398b.put(2, "1.5");
        f1398b.put(3, "1.6");
        f1398b.put(4, "2.0");
        f1398b.put(5, "2.0");
        f1398b.put(6, "2.3");
        f1398b.put(7, "3.0");
        f1398b.put(8, "3.0.5");
        f1398b.put(8, "3.1");
        f1398b.put(9, "4.0");
        f1398b.put(10, "4.1");
        f1398b.put(11, "5.0");
        f1398b.put(12, "5.1");
    }

    private C1036a() {
        this.f1400a = 0;
        this.f1400a = m1951c();
        if (this.f1400a == 0) {
            this.f1400a = m1950b();
        }
        C0968a.m1680a("EMUISupportUtil", "emuiVersion:" + this.f1400a);
    }

    /* renamed from: a */
    private String m1949a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("_");
            if (split.length == 2) {
                return split[1];
            }
        }
        return "";
    }

    /* renamed from: b */
    private int m1950b() {
        String a = m1949a(C0981c.m1727a("ro.build.version.emui", ""));
        if (TextUtils.isEmpty(a)) {
            return 0;
        }
        for (Map.Entry next : f1398b.entrySet()) {
            if (a.equals(next.getValue())) {
                return ((Integer) next.getKey()).intValue();
            }
        }
        return 0;
    }

    /* renamed from: c */
    private int m1951c() {
        return C0981c.m1724a("ro.build.hw_emui_api_level", 0);
    }

    /* renamed from: d */
    public static C1036a m1952d() {
        return f1399c;
    }

    /* renamed from: a */
    public int mo15011a() {
        return this.f1400a;
    }
}
