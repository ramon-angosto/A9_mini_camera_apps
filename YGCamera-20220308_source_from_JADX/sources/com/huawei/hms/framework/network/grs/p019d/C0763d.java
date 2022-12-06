package com.huawei.hms.framework.network.grs.p019d;

import android.os.SystemClock;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.framework.network.grs.d.d */
public class C0763d {

    /* renamed from: a */
    private static Map<String, C0764a> f581a = new ConcurrentHashMap(16);

    /* renamed from: com.huawei.hms.framework.network.grs.d.d$a */
    public static class C0764a {

        /* renamed from: a */
        private long f582a;

        /* renamed from: b */
        private long f583b;

        public C0764a(long j, long j2) {
            this.f582a = j;
            this.f583b = j2;
        }

        /* renamed from: a */
        public boolean mo13894a() {
            return SystemClock.elapsedRealtime() - this.f583b <= this.f582a;
        }
    }

    /* renamed from: a */
    public static C0764a m674a(String str) {
        Logger.m476v("RequestUtil", "map size of get is before:" + f581a.size());
        C0764a aVar = f581a.get(str);
        Logger.m476v("RequestUtil", "map size of get is after:" + f581a.size());
        return aVar;
    }

    /* renamed from: a */
    public static void m675a(String str, C0764a aVar) {
        Logger.m476v("RequestUtil", "map size of put is before:" + f581a.size());
        f581a.put(str, aVar);
        Logger.m476v("RequestUtil", "map size of put is after:" + f581a.size());
    }
}
