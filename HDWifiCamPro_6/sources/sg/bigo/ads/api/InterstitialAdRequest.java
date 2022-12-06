package sg.bigo.ads.api;

import java.util.Map;

public class InterstitialAdRequest extends b {

    public static class Builder {
        private String mSlotId;

        public InterstitialAdRequest build() {
            return new InterstitialAdRequest(this.mSlotId);
        }

        public Builder withSlotId(String str) {
            this.mSlotId = str;
            return this;
        }
    }

    public InterstitialAdRequest(String str) {
        super(str);
    }

    public final int b() {
        return 3;
    }

    public final Map<String, Object> c() {
        return null;
    }
}
