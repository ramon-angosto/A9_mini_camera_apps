package com.vungle.warren.downloader;

import android.text.TextUtils;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class DownloadRequest {
    private String advertisementId;
    private AtomicBoolean cancelled;
    public final String cookieString;
    final String id;
    public final int networkType;
    public final String path;
    public final boolean pauseOnConnectionLost;
    private AtomicReference<AssetPriority> priority;
    public final String url;

    public @interface Priority {
        public static final int CRITICAL = -2147483647;
        public static final int HIGH = 1;
        public static final int HIGHEST = 0;
        public static final int LOWEST = Integer.MAX_VALUE;
    }

    public String toString() {
        return "DownloadRequest{networkType=" + this.networkType + ", priority=" + this.priority + ", url='" + this.url + '\'' + ", path='" + this.path + '\'' + ", pauseOnConnectionLost=" + this.pauseOnConnectionLost + ", id='" + this.id + '\'' + ", cookieString='" + this.cookieString + '\'' + ", cancelled=" + this.cancelled + ", advertisementId=" + this.advertisementId + '}';
    }

    public DownloadRequest(String str, String str2) {
        this(3, 0, str, str2, false, (String) null);
    }

    public DownloadRequest(String str, String str2, String str3) {
        this(3, 0, str, str2, false, str3);
    }

    public DownloadRequest(int i, int i2, String str, String str2, boolean z, String str3) {
        this(i, new AssetPriority(i2, 0), str, str2, z, str3);
    }

    public DownloadRequest(int i, AssetPriority assetPriority, String str, String str2, boolean z, String str3) {
        this(i, assetPriority, str, str2, z, str3, (String) null);
    }

    public DownloadRequest(int i, AssetPriority assetPriority, String str, String str2, boolean z, String str3, String str4) {
        this.priority = new AtomicReference<>();
        this.cancelled = new AtomicBoolean(false);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Url or path is empty");
        }
        this.networkType = i;
        this.priority.set(assetPriority);
        this.url = str;
        this.path = str2;
        this.id = UUID.nameUUIDFromBytes((str2 + "_" + str).getBytes()).toString();
        this.pauseOnConnectionLost = z;
        this.cookieString = str3;
        this.advertisementId = str4;
    }

    /* access modifiers changed from: package-private */
    public void cancel() {
        this.cancelled.set(true);
    }

    /* access modifiers changed from: package-private */
    public boolean isCancelled() {
        return this.cancelled.get();
    }

    public void setPriority(AssetPriority assetPriority) {
        this.priority.set(assetPriority);
    }

    public AssetPriority getPriority() {
        return this.priority.get();
    }

    public String getAdvertisementId() {
        return this.advertisementId;
    }
}
