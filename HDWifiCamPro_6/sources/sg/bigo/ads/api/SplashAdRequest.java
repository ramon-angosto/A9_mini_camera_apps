package sg.bigo.ads.api;

import java.util.Map;

public class SplashAdRequest extends b {
    public final int d;
    public final String e;

    public static class Builder {
        private int mAppLogoResId;
        private String mAppName;
        private String mSlotId;

        public SplashAdRequest build() {
            return new SplashAdRequest(this.mSlotId, this.mAppLogoResId, this.mAppName);
        }

        public Builder withAppLogo(int i) {
            this.mAppLogoResId = i;
            return this;
        }

        public Builder withAppName(String str) {
            this.mAppName = str;
            return this;
        }

        public Builder withSlotId(String str) {
            this.mSlotId = str;
            return this;
        }
    }

    public SplashAdRequest(String str, int i, String str2) {
        super(str);
        this.d = i;
        this.e = str2;
    }

    public final int b() {
        return 12;
    }

    public final Map<String, Object> c() {
        return null;
    }
}
