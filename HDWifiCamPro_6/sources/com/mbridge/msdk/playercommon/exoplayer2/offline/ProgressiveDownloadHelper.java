package com.mbridge.msdk.playercommon.exoplayer2.offline;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import java.util.List;

public final class ProgressiveDownloadHelper extends DownloadHelper {
    private final String customCacheKey;
    private final Uri uri;

    public final int getPeriodCount() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public final void prepareInternal() {
    }

    public ProgressiveDownloadHelper(Uri uri2) {
        this(uri2, (String) null);
    }

    public ProgressiveDownloadHelper(Uri uri2, String str) {
        this.uri = uri2;
        this.customCacheKey = str;
    }

    public final TrackGroupArray getTrackGroups(int i) {
        return TrackGroupArray.EMPTY;
    }

    public final DownloadAction getDownloadAction(byte[] bArr, List<TrackKey> list) {
        return new ProgressiveDownloadAction(this.uri, false, bArr, this.customCacheKey);
    }

    public final DownloadAction getRemoveAction(byte[] bArr) {
        return new ProgressiveDownloadAction(this.uri, true, bArr, this.customCacheKey);
    }
}
