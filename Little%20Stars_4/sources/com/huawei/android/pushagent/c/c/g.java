package com.huawei.android.pushagent.c.c;

import com.huawei.android.pushagent.c.a.e;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

final class g implements HostnameVerifier {
    g() {
    }

    public boolean verify(String str, SSLSession sSLSession) {
        e.a("PushLogAC2705", "hostname=" + str);
        return str != null && str.startsWith("push") && str.endsWith("hicloud.com");
    }
}
