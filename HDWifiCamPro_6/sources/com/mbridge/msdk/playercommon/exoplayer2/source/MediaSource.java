package com.mbridge.msdk.playercommon.exoplayer2.source;

import android.os.Handler;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import java.io.IOException;

public interface MediaSource {

    public interface SourceInfoRefreshListener {
        void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline, Object obj);
    }

    void addEventListener(Handler handler, MediaSourceEventListener mediaSourceEventListener);

    MediaPeriod createPeriod(MediaPeriodId mediaPeriodId, Allocator allocator);

    void maybeThrowSourceInfoRefreshError() throws IOException;

    void prepareSource(ExoPlayer exoPlayer, boolean z, SourceInfoRefreshListener sourceInfoRefreshListener);

    void releasePeriod(MediaPeriod mediaPeriod);

    void releaseSource(SourceInfoRefreshListener sourceInfoRefreshListener);

    void removeEventListener(MediaSourceEventListener mediaSourceEventListener);

    public static final class MediaPeriodId {
        public final int adGroupIndex;
        public final int adIndexInAdGroup;
        public final int periodIndex;
        public final long windowSequenceNumber;

        public MediaPeriodId(int i) {
            this(i, -1);
        }

        public MediaPeriodId(int i, long j) {
            this(i, -1, -1, j);
        }

        public MediaPeriodId(int i, int i2, int i3, long j) {
            this.periodIndex = i;
            this.adGroupIndex = i2;
            this.adIndexInAdGroup = i3;
            this.windowSequenceNumber = j;
        }

        public final MediaPeriodId copyWithPeriodIndex(int i) {
            if (this.periodIndex == i) {
                return this;
            }
            return new MediaPeriodId(i, this.adGroupIndex, this.adIndexInAdGroup, this.windowSequenceNumber);
        }

        public final boolean isAd() {
            return this.adGroupIndex != -1;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            MediaPeriodId mediaPeriodId = (MediaPeriodId) obj;
            if (this.periodIndex == mediaPeriodId.periodIndex && this.adGroupIndex == mediaPeriodId.adGroupIndex && this.adIndexInAdGroup == mediaPeriodId.adIndexInAdGroup && this.windowSequenceNumber == mediaPeriodId.windowSequenceNumber) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return ((((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.periodIndex) * 31) + this.adGroupIndex) * 31) + this.adIndexInAdGroup) * 31) + ((int) this.windowSequenceNumber);
        }
    }
}
