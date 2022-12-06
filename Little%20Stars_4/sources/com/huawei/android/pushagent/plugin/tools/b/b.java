package com.huawei.android.pushagent.plugin.tools.b;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

final class b implements HostnameVerifier {
    b() {
    }

    public boolean verify(String str, SSLSession sSLSession) {
        return str != null && str.endsWith("hicloud.com");
    }
}
