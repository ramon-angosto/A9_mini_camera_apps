package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import android.os.Handler;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.BandwidthMeter;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Clock;
import com.mbridge.msdk.playercommon.exoplayer2.util.SlidingPercentile;

public final class DefaultBandwidthMeter implements BandwidthMeter, TransferListener<Object> {
    private static final int BYTES_TRANSFERRED_FOR_ESTIMATE = 524288;
    public static final long DEFAULT_INITIAL_BITRATE_ESTIMATE = 1000000;
    public static final int DEFAULT_SLIDING_WINDOW_MAX_WEIGHT = 2000;
    private static final int ELAPSED_MILLIS_FOR_ESTIMATE = 2000;
    private long bitrateEstimate;
    private final Clock clock;
    private final Handler eventHandler;
    /* access modifiers changed from: private */
    public final BandwidthMeter.EventListener eventListener;
    private long sampleBytesTransferred;
    private long sampleStartTimeMs;
    private final SlidingPercentile slidingPercentile;
    private int streamCount;
    private long totalBytesTransferred;
    private long totalElapsedTimeMs;

    public static final class Builder {
        private Clock clock = Clock.DEFAULT;
        private Handler eventHandler;
        private BandwidthMeter.EventListener eventListener;
        private long initialBitrateEstimate = 1000000;
        private int slidingWindowMaxWeight = 2000;

        public final Builder setEventListener(Handler handler, BandwidthMeter.EventListener eventListener2) {
            Assertions.checkArgument((handler == null || eventListener2 == null) ? false : true);
            this.eventHandler = handler;
            this.eventListener = eventListener2;
            return this;
        }

        public final Builder setSlidingWindowMaxWeight(int i) {
            this.slidingWindowMaxWeight = i;
            return this;
        }

        public final Builder setInitialBitrateEstimate(long j) {
            this.initialBitrateEstimate = j;
            return this;
        }

        public final Builder setClock(Clock clock2) {
            this.clock = clock2;
            return this;
        }

        public final DefaultBandwidthMeter build() {
            return new DefaultBandwidthMeter(this.eventHandler, this.eventListener, this.initialBitrateEstimate, this.slidingWindowMaxWeight, this.clock);
        }
    }

    public DefaultBandwidthMeter() {
        this((Handler) null, (BandwidthMeter.EventListener) null, 1000000, 2000, Clock.DEFAULT);
    }

    public DefaultBandwidthMeter(Handler handler, BandwidthMeter.EventListener eventListener2) {
        this(handler, eventListener2, 1000000, 2000, Clock.DEFAULT);
    }

    public DefaultBandwidthMeter(Handler handler, BandwidthMeter.EventListener eventListener2, int i) {
        this(handler, eventListener2, 1000000, i, Clock.DEFAULT);
    }

    private DefaultBandwidthMeter(Handler handler, BandwidthMeter.EventListener eventListener2, long j, int i, Clock clock2) {
        this.eventHandler = handler;
        this.eventListener = eventListener2;
        this.slidingPercentile = new SlidingPercentile(i);
        this.clock = clock2;
        this.bitrateEstimate = j;
    }

    public final synchronized long getBitrateEstimate() {
        return this.bitrateEstimate;
    }

    public final synchronized void onTransferStart(Object obj, DataSpec dataSpec) {
        if (this.streamCount == 0) {
            this.sampleStartTimeMs = this.clock.elapsedRealtime();
        }
        this.streamCount++;
    }

    public final synchronized void onBytesTransferred(Object obj, int i) {
        this.sampleBytesTransferred += (long) i;
    }

    public final synchronized void onTransferEnd(Object obj) {
        Assertions.checkState(this.streamCount > 0);
        long elapsedRealtime = this.clock.elapsedRealtime();
        int i = (int) (elapsedRealtime - this.sampleStartTimeMs);
        long j = (long) i;
        this.totalElapsedTimeMs += j;
        this.totalBytesTransferred += this.sampleBytesTransferred;
        if (i > 0) {
            this.slidingPercentile.addSample((int) Math.sqrt((double) this.sampleBytesTransferred), (float) ((this.sampleBytesTransferred * 8000) / j));
            if (this.totalElapsedTimeMs >= 2000 || this.totalBytesTransferred >= 524288) {
                this.bitrateEstimate = (long) this.slidingPercentile.getPercentile(0.5f);
            }
        }
        notifyBandwidthSample(i, this.sampleBytesTransferred, this.bitrateEstimate);
        int i2 = this.streamCount - 1;
        this.streamCount = i2;
        if (i2 > 0) {
            this.sampleStartTimeMs = elapsedRealtime;
        }
        this.sampleBytesTransferred = 0;
    }

    private void notifyBandwidthSample(int i, long j, long j2) {
        Handler handler = this.eventHandler;
        if (handler != null && this.eventListener != null) {
            final int i2 = i;
            final long j3 = j;
            final long j4 = j2;
            handler.post(new Runnable() {
                public void run() {
                    DefaultBandwidthMeter.this.eventListener.onBandwidthSample(i2, j3, j4);
                }
            });
        }
    }
}
