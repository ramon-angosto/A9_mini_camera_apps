package com.bytedance.mobsec.metasec.ov;

import java.util.Map;
import ms.bd.o.Pgl.c;

public final class PglMSConfig extends c {
    private final c o;

    public static class Builder extends c.pgla<Builder> {
        public Builder(String str, String str2) {
            super(str, str2);
        }

        public Builder(String str, String str2, int i) {
            super(str, str2, i);
        }

        public Builder(String str, String str2, String str3) {
            super(str, str2, str3);
        }

        public Builder(String str, String str2, String str3, int i) {
            super(str, str2, str3, i);
        }

        public Builder addAdvanceInfo(String str, String str2) {
            addAdvanceInfo0(str, str2);
            return this;
        }

        public PglMSConfig build() {
            if (this.k != -1 && this.l != 99999) {
                return new PglMSConfig(a());
            }
            throw new IllegalArgumentException("MSConfig init error!");
        }

        public Builder setBDDeviceID(String str) {
            setBDDeviceID0(str);
            return this;
        }

        public Builder setChannel(String str) {
            setChannel0(str);
            return this;
        }

        public Builder setClientType(int i) {
            setClientType0(i);
            return this;
        }

        public Builder setCustomInfo(Map<String, String> map) {
            setCustomInfo0(map);
            return this;
        }

        public Builder setDeviceID(String str) {
            setDeviceID0(str);
            return this;
        }

        public Builder setInstallID(String str) {
            setInstallID0(str);
            return this;
        }

        public Builder setOVRegionType(int i) {
            setOVRegionType0(i);
            return this;
        }

        public Builder setSecssionID(String str) {
            setSecssionID0(str);
            return this;
        }
    }

    private PglMSConfig(c cVar) {
        this.o = cVar;
    }

    /* access modifiers changed from: package-private */
    public c a() {
        return this.o;
    }
}
