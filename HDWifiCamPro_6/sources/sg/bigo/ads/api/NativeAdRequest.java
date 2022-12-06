package sg.bigo.ads.api;

import java.util.Map;

public class NativeAdRequest extends b {

    public static class Builder {
        private String mSlotId;

        public NativeAdRequest build() {
            return new NativeAdRequest(this.mSlotId);
        }

        public Builder withSlotId(String str) {
            this.mSlotId = str;
            return this;
        }
    }

    public NativeAdRequest(String str) {
        super(str);
    }

    public final int b() {
        return 1;
    }

    public final Map<String, Object> c() {
        return null;
    }
}
