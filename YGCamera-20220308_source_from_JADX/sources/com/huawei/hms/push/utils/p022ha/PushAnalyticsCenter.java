package com.huawei.hms.push.utils.p022ha;

/* renamed from: com.huawei.hms.push.utils.ha.PushAnalyticsCenter */
public class PushAnalyticsCenter {

    /* renamed from: a */
    public PushBaseAnalytics f939a;

    /* renamed from: com.huawei.hms.push.utils.ha.PushAnalyticsCenter$a */
    private static class C0894a {

        /* renamed from: a */
        public static PushAnalyticsCenter f940a = new PushAnalyticsCenter();
    }

    public static PushAnalyticsCenter getInstance() {
        return C0894a.f940a;
    }

    public PushBaseAnalytics getPushAnalytics() {
        return this.f939a;
    }

    public void register(PushBaseAnalytics pushBaseAnalytics) {
        this.f939a = pushBaseAnalytics;
    }
}
