package sg.bigo.ads.api;

import java.util.Arrays;
import java.util.List;

public class NativeBannerAdRequest extends BannerAdRequest {

    public static class Builder {
        private List<AdSize> mAdSizes;
        private String mSlotId;

        public NativeBannerAdRequest build() {
            return new NativeBannerAdRequest(this.mSlotId, this.mAdSizes);
        }

        public Builder withAdSizes(AdSize... adSizeArr) {
            this.mAdSizes = Arrays.asList(adSizeArr);
            return this;
        }

        public Builder withSlotId(String str) {
            this.mSlotId = str;
            return this;
        }
    }

    NativeBannerAdRequest(String str, List<AdSize> list) {
        super(str, list);
    }

    public final int b() {
        return 0;
    }
}
