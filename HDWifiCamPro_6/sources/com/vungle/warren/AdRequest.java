package com.vungle.warren;

import com.vungle.warren.model.admarkup.AdMarkup;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

public final class AdRequest implements Serializable {
    private final long adCount;
    private final AdMarkup adMarkup;
    private final boolean isExplicit;
    private final String placementId;
    public AtomicLong timeStamp;
    private final int type;

    public @interface Type {
        public static final int NORMAL = 0;
        public static final int NO_ASSETS = 1;
        public static final int SINGLE_HBP = 2;
    }

    public AdRequest(String str, int i, long j, boolean z) {
        this.timeStamp = new AtomicLong(0);
        this.placementId = str;
        this.adMarkup = null;
        this.type = i;
        this.adCount = j;
        this.isExplicit = z;
    }

    public AdRequest(String str, AdMarkup adMarkup2, boolean z) {
        this.timeStamp = new AtomicLong(0);
        this.placementId = str;
        this.adMarkup = adMarkup2;
        this.type = 0;
        this.adCount = 1;
        this.isExplicit = z;
    }

    public AdRequest(String str, boolean z) {
        this(str, (AdMarkup) null, z);
    }

    public String getPlacementId() {
        return this.placementId;
    }

    public String getEventId() {
        AdMarkup adMarkup2 = this.adMarkup;
        if (adMarkup2 == null) {
            return null;
        }
        return adMarkup2.getEventId();
    }

    public String[] getImpression() {
        if (getAdMarkup() != null) {
            return getAdMarkup().getImpressions();
        }
        return null;
    }

    public int getType() {
        return this.type;
    }

    public long getAdCount() {
        return this.adCount;
    }

    public AdMarkup getAdMarkup() {
        return this.adMarkup;
    }

    public boolean getIsExplicit() {
        return this.isExplicit;
    }

    public String toString() {
        return "AdRequest{placementId='" + this.placementId + '\'' + ", adMarkup=" + this.adMarkup + ", type=" + this.type + ", adCount=" + this.adCount + ", isExplicit=" + this.isExplicit + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdRequest adRequest = (AdRequest) obj;
        if (this.type != adRequest.type || !this.placementId.equals(adRequest.placementId)) {
            return false;
        }
        AdMarkup adMarkup2 = this.adMarkup;
        AdMarkup adMarkup3 = adRequest.adMarkup;
        if (adMarkup2 != null) {
            return adMarkup2.equals(adMarkup3);
        }
        if (adMarkup3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.placementId.hashCode() * 31;
        AdMarkup adMarkup2 = this.adMarkup;
        return ((hashCode + (adMarkup2 != null ? adMarkup2.hashCode() : 0)) * 31) + this.type;
    }
}
