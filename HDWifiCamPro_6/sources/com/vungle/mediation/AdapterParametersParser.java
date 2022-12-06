package com.vungle.mediation;

import android.os.Bundle;

public class AdapterParametersParser {

    public static class Config {
        /* access modifiers changed from: private */
        public String appId;
        /* access modifiers changed from: private */
        public String requestUniqueId;

        public String getAppId() {
            return this.appId;
        }

        public String getRequestUniqueId() {
            return this.requestUniqueId;
        }
    }

    public static Config parse(String str, Bundle bundle) {
        String string = (bundle == null || !bundle.containsKey("uniqueVungleRequestKey")) ? null : bundle.getString("uniqueVungleRequestKey");
        Config config = new Config();
        String unused = config.appId = str;
        String unused2 = config.requestUniqueId = string;
        return config;
    }
}
