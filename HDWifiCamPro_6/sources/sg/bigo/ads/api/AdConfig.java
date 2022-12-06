package sg.bigo.ads.api;

public class AdConfig {
    /* access modifiers changed from: private */
    public String appKey;
    /* access modifiers changed from: private */
    public String channel;
    /* access modifiers changed from: private */
    public boolean debug;

    public static class Builder {
        private String appKey;
        private String channel;
        private boolean debug;

        public AdConfig build() {
            AdConfig adConfig = new AdConfig();
            String unused = adConfig.appKey = this.appKey;
            String unused2 = adConfig.channel = this.channel;
            boolean unused3 = adConfig.debug = this.debug;
            return adConfig;
        }

        public Builder setAppId(String str) {
            this.appKey = str;
            return this;
        }

        public Builder setChannel(String str) {
            this.channel = str;
            return this;
        }

        public Builder setDebug(boolean z) {
            this.debug = z;
            return this;
        }
    }

    private AdConfig() {
    }

    public String getAppKey() {
        return this.appKey;
    }

    public String getChannel() {
        return this.channel;
    }

    public boolean isDebug() {
        return this.debug;
    }
}
