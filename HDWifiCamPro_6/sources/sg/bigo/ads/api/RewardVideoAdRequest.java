package sg.bigo.ads.api;

import java.util.Map;

public class RewardVideoAdRequest extends b {

    public static class Builder {
        private String mSlotId;

        public RewardVideoAdRequest build() {
            return new RewardVideoAdRequest(this.mSlotId);
        }

        public Builder withSlotId(String str) {
            this.mSlotId = str;
            return this;
        }
    }

    public RewardVideoAdRequest(String str) {
        super(str);
    }

    public final int b() {
        return 4;
    }

    public final Map<String, Object> c() {
        return null;
    }
}
