package com.huawei.hms.aaid.plugin;

public class ProxyCenter {
    public PushProxy proxy;

    /* renamed from: com.huawei.hms.aaid.plugin.ProxyCenter$a */
    private static class C0606a {

        /* renamed from: a */
        public static ProxyCenter f241a = new ProxyCenter();
    }

    public static ProxyCenter getInstance() {
        return C0606a.f241a;
    }

    public static PushProxy getProxy() {
        return getInstance().proxy;
    }

    public static void register(PushProxy pushProxy) {
        getInstance().proxy = pushProxy;
    }
}
