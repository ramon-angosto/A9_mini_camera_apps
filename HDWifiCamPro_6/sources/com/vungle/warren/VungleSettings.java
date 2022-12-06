package com.vungle.warren;

import com.vungle.warren.model.SessionData;
import com.vungle.warren.session.SessionAttribute;
import com.vungle.warren.session.SessionEvent;

public final class VungleSettings {
    private static final long MEGABYTE = 1048576;
    private final boolean androidIdOptedOut;
    private final boolean disableRefresh;
    private final long maximumStorageForCleverCache;
    private final long minimumSpaceForAd;
    private final long minimumSpaceForInit;
    private final String priorityPlacement;

    public static class Builder {
        /* access modifiers changed from: private */
        public boolean androidIdOptedOut;
        /* access modifiers changed from: private */
        public boolean disableRefresh;
        /* access modifiers changed from: private */
        public long maximumStorageForCleverCache = 104857600;
        /* access modifiers changed from: private */
        public long minimumSpaceForAd = 52428800;
        /* access modifiers changed from: private */
        public long minimumSpaceForInit = 53477376;
        /* access modifiers changed from: private */
        public String priorityPlacement = null;

        public VungleSettings build() {
            return new VungleSettings(this);
        }

        public Builder setMinimumSpaceForInit(long j) {
            this.minimumSpaceForInit = j;
            return this;
        }

        public Builder setMinimumSpaceForAd(long j) {
            this.minimumSpaceForAd = j;
            return this;
        }

        public Builder setAndroidIdOptOut(boolean z) {
            this.androidIdOptedOut = z;
            SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.ANDROID_ID).addData(SessionAttribute.USED, !z).build());
            return this;
        }

        public Builder disableBannerRefresh() {
            this.disableRefresh = true;
            return this;
        }

        public Builder setMaximumStorageForCleverCache(long j) {
            this.maximumStorageForCleverCache = j;
            return this;
        }

        public Builder setPriorityPlacement(String str) {
            this.priorityPlacement = str;
            return this;
        }
    }

    private VungleSettings(Builder builder) {
        this.minimumSpaceForAd = builder.minimumSpaceForAd;
        this.minimumSpaceForInit = builder.minimumSpaceForInit;
        this.androidIdOptedOut = builder.androidIdOptedOut;
        this.disableRefresh = builder.disableRefresh;
        this.maximumStorageForCleverCache = builder.maximumStorageForCleverCache;
        this.priorityPlacement = builder.priorityPlacement;
    }

    public long getMinimumSpaceForAd() {
        return this.minimumSpaceForAd;
    }

    public long getMinimumSpaceForInit() {
        return this.minimumSpaceForInit;
    }

    public boolean getAndroidIdOptOut() {
        return this.androidIdOptedOut;
    }

    public boolean getBannerRefreshDisabled() {
        return this.disableRefresh;
    }

    public long getMaximumStorageForCleverCache() {
        return this.maximumStorageForCleverCache;
    }

    public String getPriorityPlacement() {
        return this.priorityPlacement;
    }
}
