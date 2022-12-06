package com.vungle.warren;

import com.vungle.warren.persistence.CacheManager;

public class DownloaderSizeProvider implements SizeProvider {
    private CacheManager cacheManager;
    private final float cap;
    private RuntimeValues runtimeValues;

    public DownloaderSizeProvider(CacheManager cacheManager2, RuntimeValues runtimeValues2, float f) {
        this.cacheManager = cacheManager2;
        this.runtimeValues = runtimeValues2;
        this.cap = f;
    }

    public long getTargetSize() {
        VungleSettings vungleSettings = this.runtimeValues.settings.get();
        if (vungleSettings == null) {
            return 0;
        }
        long bytesAvailable = this.cacheManager.getBytesAvailable() / 2;
        long maximumStorageForCleverCache = vungleSettings.getMaximumStorageForCleverCache();
        long max = Math.max(0, vungleSettings.getMinimumSpaceForAd() - bytesAvailable);
        float min = (float) Math.min(maximumStorageForCleverCache, bytesAvailable);
        return Math.max(0, ((long) (min - (this.cap * min))) - max);
    }
}
