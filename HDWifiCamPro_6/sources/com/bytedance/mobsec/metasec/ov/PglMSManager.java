package com.bytedance.mobsec.metasec.ov;

import java.util.Map;
import ms.bd.o.Pgl.l0;

public final class PglMSManager implements l0.pgla {
    private final l0.pgla a;

    PglMSManager(l0.pgla pgla) {
        this.a = pgla;
    }

    public Map<String, String> frameSign(String str, int i) {
        return this.a.frameSign(str, i);
    }

    public Map<String, String> getFeatureHash(String str, byte[] bArr) {
        return this.a.getFeatureHash(str, bArr);
    }

    public Map<String, String> getReportRaw(String str, int i, Map<String, String> map) {
        return this.a.getReportRaw(str, i, map);
    }

    public String getToken() {
        return this.a.getToken();
    }

    public void report(String str) {
        this.a.report(str);
    }

    public void setBDDeviceID(String str) {
        this.a.setBDDeviceID(str);
    }

    public void setCollectMode(int i) {
        this.a.setCollectMode(i);
    }

    public void setDeviceID(String str) {
        this.a.setDeviceID(str);
    }

    public void setInstallID(String str) {
        this.a.setInstallID(str);
    }

    public void setSessionID(String str) {
        this.a.setSessionID(str);
    }
}
