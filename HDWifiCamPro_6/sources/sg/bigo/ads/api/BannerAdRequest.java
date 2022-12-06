package sg.bigo.ads.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sg.bigo.ads.ad.banner.a;
import sg.bigo.ads.api.core.d;

public class BannerAdRequest extends b {
    private final List<AdSize> d = new ArrayList();

    public static class Builder {
        private List<AdSize> mAdSizes;
        private String mSlotId;

        public BannerAdRequest build() {
            return new BannerAdRequest(this.mSlotId, this.mAdSizes);
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

    BannerAdRequest(String str, List<AdSize> list) {
        super(str);
        if (list != null) {
            for (AdSize next : list) {
                if (next != null) {
                    this.d.add(next);
                }
            }
        }
    }

    public final d a() {
        d a = super.a();
        if (a != null) {
            return a;
        }
        if (this.d.isEmpty()) {
            return new d(1001, 10003, "Ad sizes cannot be empty.");
        }
        return null;
    }

    public int b() {
        return 2;
    }

    public final Map<String, Object> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("ad_size", a.a(this.d));
        return hashMap;
    }
}
