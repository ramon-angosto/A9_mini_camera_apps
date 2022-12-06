package com.mbridge.msdk.playercommon.exoplayer2.video;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import androidx.work.WorkRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSessionManager;
import com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaCrypto;
import com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo;
import com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer;
import com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecSelector;
import com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecUtil;
import com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaFormatUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.TraceUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import com.mbridge.msdk.playercommon.exoplayer2.video.VideoRendererEventListener;
import java.nio.ByteBuffer;

public class MediaCodecVideoRenderer extends MediaCodecRenderer {
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int MAX_PENDING_OUTPUT_STREAM_OFFSET_COUNT = 10;
    private static final int[] STANDARD_LONG_EDGE_VIDEO_PX = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static final String TAG = "MediaCodecVideoRenderer";
    private static boolean deviceNeedsSetOutputSurfaceWorkaround;
    private static boolean evaluatedDeviceNeedsSetOutputSurfaceWorkaround;
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private CodecMaxValues codecMaxValues;
    private boolean codecNeedsSetOutputSurfaceWorkaround;
    private int consecutiveDroppedFrameCount;
    private final Context context;
    private int currentHeight;
    private float currentPixelWidthHeightRatio;
    private int currentUnappliedRotationDegrees;
    private int currentWidth;
    private final boolean deviceNeedsAutoFrcWorkaround;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private Surface dummySurface;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private final VideoFrameReleaseTimeHelper frameReleaseTimeHelper;
    private long initialPositionUs;
    private long joiningDeadlineMs;
    private long lastInputTimeUs;
    private long lastRenderTimeUs;
    private final int maxDroppedFramesToNotify;
    private long outputStreamOffsetUs;
    private int pendingOutputStreamOffsetCount;
    private final long[] pendingOutputStreamOffsetsUs;
    private final long[] pendingOutputStreamSwitchTimesUs;
    private float pendingPixelWidthHeightRatio;
    private int pendingRotationDegrees;
    private boolean renderedFirstFrame;
    private int reportedHeight;
    private float reportedPixelWidthHeightRatio;
    private int reportedUnappliedRotationDegrees;
    private int reportedWidth;
    private int scalingMode;
    private Surface surface;
    private boolean tunneling;
    private int tunnelingAudioSessionId;
    OnFrameRenderedListenerV23 tunnelingOnFrameRenderedListener;

    private static boolean isBufferLate(long j) {
        return j < -30000;
    }

    private static boolean isBufferVeryLate(long j) {
        return j < -500000;
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector) {
        this(context2, mediaCodecSelector, 0);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j) {
        this(context2, mediaCodecSelector, j, (Handler) null, (VideoRendererEventListener) null, -1);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        this(context2, mediaCodecSelector, j, (DrmSessionManager<FrameworkMediaCrypto>) null, false, handler, videoRendererEventListener, i);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        super(2, mediaCodecSelector, drmSessionManager, z);
        this.allowedJoiningTimeMs = j;
        this.maxDroppedFramesToNotify = i;
        this.context = context2.getApplicationContext();
        this.frameReleaseTimeHelper = new VideoFrameReleaseTimeHelper(this.context);
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.deviceNeedsAutoFrcWorkaround = deviceNeedsAutoFrcWorkaround();
        this.pendingOutputStreamOffsetsUs = new long[10];
        this.pendingOutputStreamSwitchTimesUs = new long[10];
        this.outputStreamOffsetUs = C.TIME_UNSET;
        this.lastInputTimeUs = C.TIME_UNSET;
        this.joiningDeadlineMs = C.TIME_UNSET;
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.pendingPixelWidthHeightRatio = -1.0f;
        this.scalingMode = 1;
        clearReportedVideoSize();
    }

    /* access modifiers changed from: protected */
    public int supportsFormat(MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z;
        String str = format.sampleMimeType;
        int i = 0;
        if (!MimeTypes.isVideo(str)) {
            return 0;
        }
        DrmInitData drmInitData = format.drmInitData;
        if (drmInitData != null) {
            z = false;
            for (int i2 = 0; i2 < drmInitData.schemeDataCount; i2++) {
                z |= drmInitData.get(i2).requiresSecureDecryption;
            }
        } else {
            z = false;
        }
        MediaCodecInfo decoderInfo = mediaCodecSelector.getDecoderInfo(str, z);
        if (decoderInfo == null) {
            if (!z || mediaCodecSelector.getDecoderInfo(str, false) == null) {
                return 1;
            }
            return 2;
        } else if (!supportsFormatDrm(drmSessionManager, drmInitData)) {
            return 2;
        } else {
            boolean isCodecSupported = decoderInfo.isCodecSupported(format.codecs);
            if (isCodecSupported && format.width > 0 && format.height > 0) {
                if (Util.SDK_INT >= 21) {
                    isCodecSupported = decoderInfo.isVideoSizeAndRateSupportedV21(format.width, format.height, (double) format.frameRate);
                } else {
                    isCodecSupported = format.width * format.height <= MediaCodecUtil.maxH264DecodableFrameSize();
                    if (!isCodecSupported) {
                        Log.d(TAG, "FalseCheck [legacyFrameSize, " + format.width + "x" + format.height + "] [" + Util.DEVICE_DEBUG_INFO + "]");
                    }
                }
            }
            int i3 = decoderInfo.adaptive ? 16 : 8;
            if (decoderInfo.tunneling) {
                i = 32;
            }
            return (isCodecSupported ? 4 : 3) | i3 | i;
        }
    }

    /* access modifiers changed from: protected */
    public void onEnabled(boolean z) throws ExoPlaybackException {
        super.onEnabled(z);
        this.tunnelingAudioSessionId = getConfiguration().tunnelingAudioSessionId;
        this.tunneling = this.tunnelingAudioSessionId != 0;
        this.eventDispatcher.enabled(this.decoderCounters);
        this.frameReleaseTimeHelper.enable();
    }

    /* access modifiers changed from: protected */
    public void onStreamChanged(Format[] formatArr, long j) throws ExoPlaybackException {
        if (this.outputStreamOffsetUs == C.TIME_UNSET) {
            this.outputStreamOffsetUs = j;
        } else {
            int i = this.pendingOutputStreamOffsetCount;
            if (i == this.pendingOutputStreamOffsetsUs.length) {
                Log.w(TAG, "Too many stream changes, so dropping offset: " + this.pendingOutputStreamOffsetsUs[this.pendingOutputStreamOffsetCount - 1]);
            } else {
                this.pendingOutputStreamOffsetCount = i + 1;
            }
            long[] jArr = this.pendingOutputStreamOffsetsUs;
            int i2 = this.pendingOutputStreamOffsetCount;
            jArr[i2 - 1] = j;
            this.pendingOutputStreamSwitchTimesUs[i2 - 1] = this.lastInputTimeUs;
        }
        super.onStreamChanged(formatArr, j);
    }

    /* access modifiers changed from: protected */
    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        super.onPositionReset(j, z);
        clearRenderedFirstFrame();
        this.initialPositionUs = C.TIME_UNSET;
        this.consecutiveDroppedFrameCount = 0;
        this.lastInputTimeUs = C.TIME_UNSET;
        int i = this.pendingOutputStreamOffsetCount;
        if (i != 0) {
            this.outputStreamOffsetUs = this.pendingOutputStreamOffsetsUs[i - 1];
            this.pendingOutputStreamOffsetCount = 0;
        }
        if (z) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = C.TIME_UNSET;
        }
    }

    public boolean isReady() {
        Surface surface2;
        if (super.isReady() && (this.renderedFirstFrame || (((surface2 = this.dummySurface) != null && this.surface == surface2) || getCodec() == null || this.tunneling))) {
            this.joiningDeadlineMs = C.TIME_UNSET;
            return true;
        } else if (this.joiningDeadlineMs == C.TIME_UNSET) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
                return true;
            }
            this.joiningDeadlineMs = C.TIME_UNSET;
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onStarted() {
        super.onStarted();
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
    }

    /* access modifiers changed from: protected */
    public void onStopped() {
        this.joiningDeadlineMs = C.TIME_UNSET;
        maybeNotifyDroppedFrames();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    public void onDisabled() {
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.pendingPixelWidthHeightRatio = -1.0f;
        this.outputStreamOffsetUs = C.TIME_UNSET;
        this.lastInputTimeUs = C.TIME_UNSET;
        this.pendingOutputStreamOffsetCount = 0;
        clearReportedVideoSize();
        clearRenderedFirstFrame();
        this.frameReleaseTimeHelper.disable();
        this.tunnelingOnFrameRenderedListener = null;
        this.tunneling = false;
        try {
            super.onDisabled();
        } finally {
            this.decoderCounters.ensureUpdated();
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
        if (i == 1) {
            setSurface((Surface) obj);
        } else if (i == 4) {
            this.scalingMode = ((Integer) obj).intValue();
            MediaCodec codec = getCodec();
            if (codec != null) {
                codec.setVideoScalingMode(this.scalingMode);
            }
        } else {
            super.handleMessage(i, obj);
        }
    }

    private void setSurface(Surface surface2) throws ExoPlaybackException {
        if (surface2 == null) {
            Surface surface3 = this.dummySurface;
            if (surface3 != null) {
                surface2 = surface3;
            } else {
                MediaCodecInfo codecInfo = getCodecInfo();
                if (codecInfo != null && shouldUseDummySurface(codecInfo)) {
                    this.dummySurface = DummySurface.newInstanceV17(this.context, codecInfo.secure);
                    surface2 = this.dummySurface;
                }
            }
        }
        if (this.surface != surface2) {
            this.surface = surface2;
            int state = getState();
            if (state == 1 || state == 2) {
                MediaCodec codec = getCodec();
                if (Util.SDK_INT < 23 || codec == null || surface2 == null || this.codecNeedsSetOutputSurfaceWorkaround) {
                    releaseCodec();
                    maybeInitCodec();
                } else {
                    setOutputSurfaceV23(codec, surface2);
                }
            }
            if (surface2 == null || surface2 == this.dummySurface) {
                clearReportedVideoSize();
                clearRenderedFirstFrame();
                return;
            }
            maybeRenotifyVideoSizeChanged();
            clearRenderedFirstFrame();
            if (state == 2) {
                setJoiningDeadlineMs();
            }
        } else if (surface2 != null && surface2 != this.dummySurface) {
            maybeRenotifyVideoSizeChanged();
            maybeRenotifyRenderedFirstFrame();
        }
    }

    /* access modifiers changed from: protected */
    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return this.surface != null || shouldUseDummySurface(mediaCodecInfo);
    }

    /* access modifiers changed from: protected */
    public void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws MediaCodecUtil.DecoderQueryException {
        this.codecMaxValues = getCodecMaxValues(mediaCodecInfo, format, getStreamFormats());
        MediaFormat mediaFormat = getMediaFormat(format, this.codecMaxValues, this.deviceNeedsAutoFrcWorkaround, this.tunnelingAudioSessionId);
        if (this.surface == null) {
            Assertions.checkState(shouldUseDummySurface(mediaCodecInfo));
            if (this.dummySurface == null) {
                this.dummySurface = DummySurface.newInstanceV17(this.context, mediaCodecInfo.secure);
            }
            this.surface = this.dummySurface;
        }
        mediaCodec.configure(mediaFormat, this.surface, mediaCrypto, 0);
        if (Util.SDK_INT >= 23 && this.tunneling) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(mediaCodec);
        }
    }

    /* access modifiers changed from: protected */
    public int canKeepCodec(MediaCodec mediaCodec, MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        if (!areAdaptationCompatible(mediaCodecInfo.adaptive, format, format2) || format2.width > this.codecMaxValues.width || format2.height > this.codecMaxValues.height || getMaxInputSize(mediaCodecInfo, format2) > this.codecMaxValues.inputSize) {
            return 0;
        }
        return format.initializationDataEquals(format2) ? 1 : 3;
    }

    /* access modifiers changed from: protected */
    public void releaseCodec() {
        try {
            super.releaseCodec();
        } finally {
            this.buffersInCodecCount = 0;
            Surface surface2 = this.dummySurface;
            if (surface2 != null) {
                if (this.surface == surface2) {
                    this.surface = null;
                }
                this.dummySurface.release();
                this.dummySurface = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void flushCodec() throws ExoPlaybackException {
        super.flushCodec();
        this.buffersInCodecCount = 0;
    }

    /* access modifiers changed from: protected */
    public void onCodecInitialized(String str, long j, long j2) {
        this.eventDispatcher.decoderInitialized(str, j, j2);
        this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(str);
    }

    /* access modifiers changed from: protected */
    public void onInputFormatChanged(Format format) throws ExoPlaybackException {
        super.onInputFormatChanged(format);
        this.eventDispatcher.inputFormatChanged(format);
        this.pendingPixelWidthHeightRatio = format.pixelWidthHeightRatio;
        this.pendingRotationDegrees = format.rotationDegrees;
    }

    /* access modifiers changed from: protected */
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        this.buffersInCodecCount++;
        this.lastInputTimeUs = Math.max(decoderInputBuffer.timeUs, this.lastInputTimeUs);
        if (Util.SDK_INT < 23 && this.tunneling) {
            maybeNotifyRenderedFirstFrame();
        }
    }

    /* access modifiers changed from: protected */
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i;
        int i2;
        boolean z = mediaFormat.containsKey(KEY_CROP_RIGHT) && mediaFormat.containsKey(KEY_CROP_LEFT) && mediaFormat.containsKey(KEY_CROP_BOTTOM) && mediaFormat.containsKey(KEY_CROP_TOP);
        if (z) {
            i = (mediaFormat.getInteger(KEY_CROP_RIGHT) - mediaFormat.getInteger(KEY_CROP_LEFT)) + 1;
        } else {
            i = mediaFormat.getInteger("width");
        }
        this.currentWidth = i;
        if (z) {
            i2 = (mediaFormat.getInteger(KEY_CROP_BOTTOM) - mediaFormat.getInteger(KEY_CROP_TOP)) + 1;
        } else {
            i2 = mediaFormat.getInteger("height");
        }
        this.currentHeight = i2;
        this.currentPixelWidthHeightRatio = this.pendingPixelWidthHeightRatio;
        if (Util.SDK_INT >= 21) {
            int i3 = this.pendingRotationDegrees;
            if (i3 == 90 || i3 == 270) {
                int i4 = this.currentWidth;
                this.currentWidth = this.currentHeight;
                this.currentHeight = i4;
                this.currentPixelWidthHeightRatio = 1.0f / this.currentPixelWidthHeightRatio;
            }
        } else {
            this.currentUnappliedRotationDegrees = this.pendingRotationDegrees;
        }
        mediaCodec.setVideoScalingMode(this.scalingMode);
    }

    /* access modifiers changed from: protected */
    public boolean processOutputBuffer(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws ExoPlaybackException {
        long j4 = j;
        long j5 = j2;
        MediaCodec mediaCodec2 = mediaCodec;
        int i3 = i;
        long j6 = j3;
        if (this.initialPositionUs == C.TIME_UNSET) {
            this.initialPositionUs = j4;
        }
        long j7 = j6 - this.outputStreamOffsetUs;
        if (z) {
            skipOutputBuffer(mediaCodec2, i3, j7);
            return true;
        }
        long j8 = j6 - j4;
        if (this.surface != this.dummySurface) {
            long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            boolean z2 = getState() == 2;
            if (this.renderedFirstFrame && (!z2 || !shouldForceRenderOutputBuffer(j8, elapsedRealtime - this.lastRenderTimeUs))) {
                if (z2 && j4 != this.initialPositionUs) {
                    long nanoTime = System.nanoTime();
                    long adjustReleaseTime = this.frameReleaseTimeHelper.adjustReleaseTime(j6, ((j8 - (elapsedRealtime - j5)) * 1000) + nanoTime);
                    long j9 = (adjustReleaseTime - nanoTime) / 1000;
                    if (shouldDropBuffersToKeyframe(j9, j5) && maybeDropBuffersToKeyframe(mediaCodec, i, j7, j)) {
                        return false;
                    }
                    if (shouldDropOutputBuffer(j9, j5)) {
                        dropOutputBuffer(mediaCodec2, i3, j7);
                        return true;
                    } else if (Util.SDK_INT >= 21) {
                        if (j9 < 50000) {
                            renderOutputBufferV21(mediaCodec, i, j7, adjustReleaseTime);
                            return true;
                        }
                    } else if (j9 < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                        if (j9 > 11000) {
                            try {
                                Thread.sleep((j9 - WorkRequest.MIN_BACKOFF_MILLIS) / 1000);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                                return false;
                            }
                        }
                        renderOutputBuffer(mediaCodec2, i3, j7);
                        return true;
                    }
                }
                return false;
            } else if (Util.SDK_INT >= 21) {
                renderOutputBufferV21(mediaCodec, i, j7, System.nanoTime());
                return true;
            } else {
                renderOutputBuffer(mediaCodec2, i3, j7);
                return true;
            }
        } else if (!isBufferLate(j8)) {
            return false;
        } else {
            skipOutputBuffer(mediaCodec2, i3, j7);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onProcessedOutputBuffer(long j) {
        this.buffersInCodecCount--;
        while (true) {
            int i = this.pendingOutputStreamOffsetCount;
            if (i != 0 && j >= this.pendingOutputStreamSwitchTimesUs[0]) {
                long[] jArr = this.pendingOutputStreamOffsetsUs;
                this.outputStreamOffsetUs = jArr[0];
                this.pendingOutputStreamOffsetCount = i - 1;
                System.arraycopy(jArr, 1, jArr, 0, this.pendingOutputStreamOffsetCount);
                long[] jArr2 = this.pendingOutputStreamSwitchTimesUs;
                System.arraycopy(jArr2, 1, jArr2, 0, this.pendingOutputStreamOffsetCount);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean shouldDropOutputBuffer(long j, long j2) {
        return isBufferLate(j);
    }

    /* access modifiers changed from: protected */
    public boolean shouldDropBuffersToKeyframe(long j, long j2) {
        return isBufferVeryLate(j);
    }

    /* access modifiers changed from: protected */
    public boolean shouldForceRenderOutputBuffer(long j, long j2) {
        return isBufferLate(j) && j2 > 100000;
    }

    /* access modifiers changed from: protected */
    public void skipOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        TraceUtil.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    /* access modifiers changed from: protected */
    public void dropOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        TraceUtil.beginSection("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        updateDroppedBufferCounters(1);
    }

    /* access modifiers changed from: protected */
    public boolean maybeDropBuffersToKeyframe(MediaCodec mediaCodec, int i, long j, long j2) throws ExoPlaybackException {
        int skipSource = skipSource(j2);
        if (skipSource == 0) {
            return false;
        }
        this.decoderCounters.droppedToKeyframeCount++;
        updateDroppedBufferCounters(this.buffersInCodecCount + skipSource);
        flushCodec();
        return true;
    }

    /* access modifiers changed from: protected */
    public void updateDroppedBufferCounters(int i) {
        this.decoderCounters.droppedBufferCount += i;
        this.droppedFrames += i;
        this.consecutiveDroppedFrameCount += i;
        this.decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(this.consecutiveDroppedFrameCount, this.decoderCounters.maxConsecutiveDroppedBufferCount);
        if (this.droppedFrames >= this.maxDroppedFramesToNotify) {
            maybeNotifyDroppedFrames();
        }
    }

    /* access modifiers changed from: protected */
    public void renderOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        TraceUtil.endSection();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    /* access modifiers changed from: protected */
    public void renderOutputBufferV21(MediaCodec mediaCodec, int i, long j, long j2) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        TraceUtil.endSection();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    private boolean shouldUseDummySurface(MediaCodecInfo mediaCodecInfo) {
        return Util.SDK_INT >= 23 && !this.tunneling && !codecNeedsSetOutputSurfaceWorkaround(mediaCodecInfo.name) && (!mediaCodecInfo.secure || DummySurface.isSecureSupported(this.context));
    }

    private void setJoiningDeadlineMs() {
        this.joiningDeadlineMs = this.allowedJoiningTimeMs > 0 ? SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs : C.TIME_UNSET;
    }

    private void clearRenderedFirstFrame() {
        MediaCodec codec;
        this.renderedFirstFrame = false;
        if (Util.SDK_INT >= 23 && this.tunneling && (codec = getCodec()) != null) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(codec);
        }
    }

    /* access modifiers changed from: package-private */
    public void maybeNotifyRenderedFirstFrame() {
        if (!this.renderedFirstFrame) {
            this.renderedFirstFrame = true;
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    private void maybeRenotifyRenderedFirstFrame() {
        if (this.renderedFirstFrame) {
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    private void clearReportedVideoSize() {
        this.reportedWidth = -1;
        this.reportedHeight = -1;
        this.reportedPixelWidthHeightRatio = -1.0f;
        this.reportedUnappliedRotationDegrees = -1;
    }

    private void maybeNotifyVideoSizeChanged() {
        if (this.currentWidth != -1 || this.currentHeight != -1) {
            if (this.reportedWidth != this.currentWidth || this.reportedHeight != this.currentHeight || this.reportedUnappliedRotationDegrees != this.currentUnappliedRotationDegrees || this.reportedPixelWidthHeightRatio != this.currentPixelWidthHeightRatio) {
                this.eventDispatcher.videoSizeChanged(this.currentWidth, this.currentHeight, this.currentUnappliedRotationDegrees, this.currentPixelWidthHeightRatio);
                this.reportedWidth = this.currentWidth;
                this.reportedHeight = this.currentHeight;
                this.reportedUnappliedRotationDegrees = this.currentUnappliedRotationDegrees;
                this.reportedPixelWidthHeightRatio = this.currentPixelWidthHeightRatio;
            }
        }
    }

    private void maybeRenotifyVideoSizeChanged() {
        if (this.reportedWidth != -1 || this.reportedHeight != -1) {
            this.eventDispatcher.videoSizeChanged(this.reportedWidth, this.reportedHeight, this.reportedUnappliedRotationDegrees, this.reportedPixelWidthHeightRatio);
        }
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, elapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = elapsedRealtime;
        }
    }

    private static void setOutputSurfaceV23(MediaCodec mediaCodec, Surface surface2) {
        mediaCodec.setOutputSurface(surface2);
    }

    private static void configureTunnelingV21(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i);
    }

    /* access modifiers changed from: protected */
    public MediaFormat getMediaFormat(Format format, CodecMaxValues codecMaxValues2, boolean z, int i) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", format.sampleMimeType);
        mediaFormat.setInteger("width", format.width);
        mediaFormat.setInteger("height", format.height);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetFloat(mediaFormat, "frame-rate", format.frameRate);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "rotation-degrees", format.rotationDegrees);
        MediaFormatUtil.maybeSetColorInfo(mediaFormat, format.colorInfo);
        mediaFormat.setInteger("max-width", codecMaxValues2.width);
        mediaFormat.setInteger("max-height", codecMaxValues2.height);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", codecMaxValues2.inputSize);
        if (Util.SDK_INT >= 23) {
            mediaFormat.setInteger("priority", 0);
        }
        if (z) {
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            configureTunnelingV21(mediaFormat, i);
        }
        return mediaFormat;
    }

    /* access modifiers changed from: protected */
    public CodecMaxValues getCodecMaxValues(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) throws MediaCodecUtil.DecoderQueryException {
        int i = format.width;
        int i2 = format.height;
        int maxInputSize = getMaxInputSize(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            return new CodecMaxValues(i, i2, maxInputSize);
        }
        int i3 = i2;
        int i4 = maxInputSize;
        boolean z = false;
        int i5 = i;
        for (Format format2 : formatArr) {
            if (areAdaptationCompatible(mediaCodecInfo.adaptive, format, format2)) {
                z |= format2.width == -1 || format2.height == -1;
                i5 = Math.max(i5, format2.width);
                i3 = Math.max(i3, format2.height);
                i4 = Math.max(i4, getMaxInputSize(mediaCodecInfo, format2));
            }
        }
        if (z) {
            Log.w(TAG, "Resolutions unknown. Codec max resolution: " + i5 + "x" + i3);
            Point codecMaxSize = getCodecMaxSize(mediaCodecInfo, format);
            if (codecMaxSize != null) {
                i5 = Math.max(i5, codecMaxSize.x);
                i3 = Math.max(i3, codecMaxSize.y);
                i4 = Math.max(i4, getMaxInputSize(mediaCodecInfo, format.sampleMimeType, i5, i3));
                Log.w(TAG, "Codec max resolution adjusted to: " + i5 + "x" + i3);
            }
        }
        return new CodecMaxValues(i5, i3, i4);
    }

    private static Point getCodecMaxSize(MediaCodecInfo mediaCodecInfo, Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z = format.height > format.width;
        int i = z ? format.height : format.width;
        int i2 = z ? format.width : format.height;
        float f = ((float) i2) / ((float) i);
        for (int i3 : STANDARD_LONG_EDGE_VIDEO_PX) {
            int i4 = (int) (((float) i3) * f);
            if (i3 <= i || i4 <= i2) {
                break;
            }
            if (Util.SDK_INT >= 21) {
                int i5 = z ? i4 : i3;
                if (!z) {
                    i3 = i4;
                }
                Point alignVideoSizeV21 = mediaCodecInfo.alignVideoSizeV21(i5, i3);
                if (mediaCodecInfo.isVideoSizeAndRateSupportedV21(alignVideoSizeV21.x, alignVideoSizeV21.y, (double) format.frameRate)) {
                    return alignVideoSizeV21;
                }
            } else {
                int ceilDivide = Util.ceilDivide(i3, 16) * 16;
                int ceilDivide2 = 16 * Util.ceilDivide(i4, 16);
                if (ceilDivide * ceilDivide2 <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                    int i6 = z ? ceilDivide2 : ceilDivide;
                    if (z) {
                        ceilDivide2 = ceilDivide;
                    }
                    return new Point(i6, ceilDivide2);
                }
            }
        }
        return null;
    }

    private static int getMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        if (format.maxInputSize == -1) {
            return getMaxInputSize(mediaCodecInfo, format.sampleMimeType, format.width, format.height);
        }
        int size = format.initializationData.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += format.initializationData.get(i2).length;
        }
        return format.maxInputSize + i;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int getMaxInputSize(com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo r7, java.lang.String r8, int r9, int r10) {
        /*
            r0 = -1
            if (r9 == r0) goto L_0x00a3
            if (r10 != r0) goto L_0x0007
            goto L_0x00a3
        L_0x0007:
            int r1 = r8.hashCode()
            r2 = 5
            r3 = 1
            r4 = 4
            r5 = 3
            r6 = 2
            switch(r1) {
                case -1664118616: goto L_0x0046;
                case -1662541442: goto L_0x003c;
                case 1187890754: goto L_0x0032;
                case 1331836730: goto L_0x0028;
                case 1599127256: goto L_0x001e;
                case 1599127257: goto L_0x0014;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0050
        L_0x0014:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x0050
            r8 = r2
            goto L_0x0051
        L_0x001e:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x0050
            r8 = r5
            goto L_0x0051
        L_0x0028:
            java.lang.String r1 = "video/avc"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x0050
            r8 = r6
            goto L_0x0051
        L_0x0032:
            java.lang.String r1 = "video/mp4v-es"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x0050
            r8 = r3
            goto L_0x0051
        L_0x003c:
            java.lang.String r1 = "video/hevc"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x0050
            r8 = r4
            goto L_0x0051
        L_0x0046:
            java.lang.String r1 = "video/3gpp"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x0050
            r8 = 0
            goto L_0x0051
        L_0x0050:
            r8 = r0
        L_0x0051:
            if (r8 == 0) goto L_0x009d
            if (r8 == r3) goto L_0x009d
            if (r8 == r6) goto L_0x0060
            if (r8 == r5) goto L_0x009d
            if (r8 == r4) goto L_0x005e
            if (r8 == r2) goto L_0x005e
            return r0
        L_0x005e:
            int r9 = r9 * r10
            goto L_0x009f
        L_0x0060:
            java.lang.String r8 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.MODEL
            java.lang.String r1 = "BRAVIA 4K 2015"
            boolean r8 = r1.equals(r8)
            if (r8 != 0) goto L_0x009c
            java.lang.String r8 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.MANUFACTURER
            java.lang.String r1 = "Amazon"
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x008d
            java.lang.String r8 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.MODEL
            java.lang.String r1 = "KFSOWI"
            boolean r8 = r1.equals(r8)
            if (r8 != 0) goto L_0x009c
            java.lang.String r8 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.MODEL
            java.lang.String r1 = "AFTS"
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x008d
            boolean r7 = r7.secure
            if (r7 == 0) goto L_0x008d
            goto L_0x009c
        L_0x008d:
            r7 = 16
            int r8 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.ceilDivide((int) r9, (int) r7)
            int r9 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.ceilDivide((int) r10, (int) r7)
            int r8 = r8 * r9
            int r8 = r8 * r7
            int r9 = r8 * 16
            goto L_0x009e
        L_0x009c:
            return r0
        L_0x009d:
            int r9 = r9 * r10
        L_0x009e:
            r4 = r6
        L_0x009f:
            int r9 = r9 * r5
            int r4 = r4 * r6
            int r9 = r9 / r4
            return r9
        L_0x00a3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.video.MediaCodecVideoRenderer.getMaxInputSize(com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo, java.lang.String, int, int):int");
    }

    private static boolean areAdaptationCompatible(boolean z, Format format, Format format2) {
        return format.sampleMimeType.equals(format2.sampleMimeType) && format.rotationDegrees == format2.rotationDegrees && (z || (format.width == format2.width && format.height == format2.height)) && Util.areEqual(format.colorInfo, format2.colorInfo);
    }

    private static boolean deviceNeedsAutoFrcWorkaround() {
        return Util.SDK_INT <= 22 && "foster".equals(Util.DEVICE) && "NVIDIA".equals(Util.MANUFACTURER);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:366:0x059a, code lost:
        r1 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:0x059b, code lost:
        switch(r1) {
            case 0: goto L_0x059f;
            case 1: goto L_0x059f;
            case 2: goto L_0x059f;
            case 3: goto L_0x059f;
            case 4: goto L_0x059f;
            case 5: goto L_0x059f;
            case 6: goto L_0x059f;
            case 7: goto L_0x059f;
            case 8: goto L_0x059f;
            case 9: goto L_0x059f;
            case 10: goto L_0x059f;
            case 11: goto L_0x059f;
            case 12: goto L_0x059f;
            case 13: goto L_0x059f;
            case 14: goto L_0x059f;
            case 15: goto L_0x059f;
            case 16: goto L_0x059f;
            case 17: goto L_0x059f;
            case 18: goto L_0x059f;
            case 19: goto L_0x059f;
            case 20: goto L_0x059f;
            case 21: goto L_0x059f;
            case 22: goto L_0x059f;
            case 23: goto L_0x059f;
            case 24: goto L_0x059f;
            case 25: goto L_0x059f;
            case 26: goto L_0x059f;
            case 27: goto L_0x059f;
            case 28: goto L_0x059f;
            case 29: goto L_0x059f;
            case 30: goto L_0x059f;
            case 31: goto L_0x059f;
            case 32: goto L_0x059f;
            case 33: goto L_0x059f;
            case 34: goto L_0x059f;
            case 35: goto L_0x059f;
            case 36: goto L_0x059f;
            case 37: goto L_0x059f;
            case 38: goto L_0x059f;
            case 39: goto L_0x059f;
            case 40: goto L_0x059f;
            case 41: goto L_0x059f;
            case 42: goto L_0x059f;
            case 43: goto L_0x059f;
            case 44: goto L_0x059f;
            case 45: goto L_0x059f;
            case 46: goto L_0x059f;
            case 47: goto L_0x059f;
            case 48: goto L_0x059f;
            case 49: goto L_0x059f;
            case 50: goto L_0x059f;
            case 51: goto L_0x059f;
            case 52: goto L_0x059f;
            case 53: goto L_0x059f;
            case 54: goto L_0x059f;
            case 55: goto L_0x059f;
            case 56: goto L_0x059f;
            case 57: goto L_0x059f;
            case 58: goto L_0x059f;
            case 59: goto L_0x059f;
            case 60: goto L_0x059f;
            case 61: goto L_0x059f;
            case 62: goto L_0x059f;
            case 63: goto L_0x059f;
            case 64: goto L_0x059f;
            case 65: goto L_0x059f;
            case 66: goto L_0x059f;
            case 67: goto L_0x059f;
            case 68: goto L_0x059f;
            case 69: goto L_0x059f;
            case 70: goto L_0x059f;
            case 71: goto L_0x059f;
            case 72: goto L_0x059f;
            case 73: goto L_0x059f;
            case 74: goto L_0x059f;
            case 75: goto L_0x059f;
            case 76: goto L_0x059f;
            case 77: goto L_0x059f;
            case 78: goto L_0x059f;
            case 79: goto L_0x059f;
            case 80: goto L_0x059f;
            case 81: goto L_0x059f;
            case 82: goto L_0x059f;
            case 83: goto L_0x059f;
            case 84: goto L_0x059f;
            case 85: goto L_0x059f;
            case 86: goto L_0x059f;
            case 87: goto L_0x059f;
            case 88: goto L_0x059f;
            case 89: goto L_0x059f;
            case 90: goto L_0x059f;
            case 91: goto L_0x059f;
            case 92: goto L_0x059f;
            case 93: goto L_0x059f;
            case 94: goto L_0x059f;
            case 95: goto L_0x059f;
            case 96: goto L_0x059f;
            case 97: goto L_0x059f;
            case 98: goto L_0x059f;
            case 99: goto L_0x059f;
            case 100: goto L_0x059f;
            case 101: goto L_0x059f;
            case 102: goto L_0x059f;
            case 103: goto L_0x059f;
            case 104: goto L_0x059f;
            case 105: goto L_0x059f;
            case 106: goto L_0x059f;
            case 107: goto L_0x059f;
            case 108: goto L_0x059f;
            case 109: goto L_0x059f;
            case 110: goto L_0x059f;
            case 111: goto L_0x059f;
            case 112: goto L_0x059f;
            case 113: goto L_0x059f;
            case 114: goto L_0x059f;
            case 115: goto L_0x059f;
            case 116: goto L_0x059f;
            case 117: goto L_0x059f;
            default: goto L_0x059e;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:0x059f, code lost:
        deviceNeedsSetOutputSurfaceWorkaround = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:370:0x05a1, code lost:
        r0 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.MODEL;
        r1 = r0.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:0x05aa, code lost:
        if (r1 == 2006354) goto L_0x05bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:373:0x05af, code lost:
        if (r1 == 2006367) goto L_0x05b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:0x05b8, code lost:
        if (r0.equals("AFTN") == false) goto L_0x05c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:377:0x05ba, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x05c2, code lost:
        if (r0.equals("AFTA") == false) goto L_0x05c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:381:0x05c5, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:382:0x05c6, code lost:
        if (r2 == false) goto L_0x05cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:383:0x05c8, code lost:
        if (r2 == true) goto L_0x05cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:385:0x05cb, code lost:
        deviceNeedsSetOutputSurfaceWorkaround = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:386:0x05cd, code lost:
        evaluatedDeviceNeedsSetOutputSurfaceWorkaround = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean codecNeedsSetOutputSurfaceWorkaround(java.lang.String r7) {
        /*
            r6 = this;
            int r0 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.SDK_INT
            r1 = 27
            r2 = 0
            if (r0 >= r1) goto L_0x05d6
            java.lang.String r0 = "OMX.google"
            boolean r7 = r7.startsWith(r0)
            if (r7 == 0) goto L_0x0011
            goto L_0x05d6
        L_0x0011:
            java.lang.Class<com.mbridge.msdk.playercommon.exoplayer2.video.MediaCodecVideoRenderer> r7 = com.mbridge.msdk.playercommon.exoplayer2.video.MediaCodecVideoRenderer.class
            monitor-enter(r7)
            boolean r0 = evaluatedDeviceNeedsSetOutputSurfaceWorkaround     // Catch:{ all -> 0x05d3 }
            if (r0 != 0) goto L_0x05cf
            java.lang.String r0 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.DEVICE     // Catch:{ all -> 0x05d3 }
            int r3 = r0.hashCode()     // Catch:{ all -> 0x05d3 }
            r4 = -1
            r5 = 1
            switch(r3) {
                case -2144781245: goto L_0x058f;
                case -2144781185: goto L_0x0584;
                case -2144781160: goto L_0x0579;
                case -2097309513: goto L_0x056e;
                case -2022874474: goto L_0x0563;
                case -1978993182: goto L_0x0558;
                case -1978990237: goto L_0x054d;
                case -1936688988: goto L_0x0542;
                case -1936688066: goto L_0x0537;
                case -1936688065: goto L_0x052b;
                case -1931988508: goto L_0x051f;
                case -1696512866: goto L_0x0513;
                case -1680025915: goto L_0x0507;
                case -1615810839: goto L_0x04fb;
                case -1554255044: goto L_0x04ef;
                case -1481772737: goto L_0x04e3;
                case -1481772730: goto L_0x04d7;
                case -1481772729: goto L_0x04cb;
                case -1320080169: goto L_0x04bf;
                case -1217592143: goto L_0x04b3;
                case -1180384755: goto L_0x04a7;
                case -1139198265: goto L_0x049b;
                case -1052835013: goto L_0x048f;
                case -993250464: goto L_0x0484;
                case -965403638: goto L_0x0478;
                case -958336948: goto L_0x046c;
                case -879245230: goto L_0x0460;
                case -842500323: goto L_0x0454;
                case -821392978: goto L_0x0449;
                case -797483286: goto L_0x043d;
                case -794946968: goto L_0x0431;
                case -788334647: goto L_0x0425;
                case -782144577: goto L_0x0419;
                case -575125681: goto L_0x040d;
                case -521118391: goto L_0x0401;
                case -430914369: goto L_0x03f5;
                case -290434366: goto L_0x03e9;
                case -282781963: goto L_0x03dd;
                case -277133239: goto L_0x03d1;
                case -173639913: goto L_0x03c5;
                case -56598463: goto L_0x03b9;
                case 2126: goto L_0x03ad;
                case 2564: goto L_0x03a1;
                case 2715: goto L_0x0395;
                case 2719: goto L_0x0389;
                case 3483: goto L_0x037d;
                case 73405: goto L_0x0371;
                case 75739: goto L_0x0365;
                case 76779: goto L_0x0359;
                case 78669: goto L_0x034d;
                case 79305: goto L_0x0341;
                case 80618: goto L_0x0335;
                case 88274: goto L_0x0329;
                case 98846: goto L_0x031d;
                case 98848: goto L_0x0311;
                case 99329: goto L_0x0305;
                case 101481: goto L_0x02f9;
                case 1513190: goto L_0x02ee;
                case 1514184: goto L_0x02e3;
                case 1514185: goto L_0x02d8;
                case 2436959: goto L_0x02cc;
                case 2463773: goto L_0x02c0;
                case 2464648: goto L_0x02b4;
                case 2689555: goto L_0x02a8;
                case 3351335: goto L_0x029c;
                case 3386211: goto L_0x0290;
                case 41325051: goto L_0x0284;
                case 55178625: goto L_0x0278;
                case 61542055: goto L_0x026d;
                case 65355429: goto L_0x0261;
                case 66214468: goto L_0x0255;
                case 66214470: goto L_0x0249;
                case 66214473: goto L_0x023d;
                case 66215429: goto L_0x0231;
                case 66215431: goto L_0x0225;
                case 66215433: goto L_0x0219;
                case 66216390: goto L_0x020d;
                case 76402249: goto L_0x0201;
                case 76404105: goto L_0x01f5;
                case 76404911: goto L_0x01e9;
                case 80963634: goto L_0x01dd;
                case 82882791: goto L_0x01d1;
                case 102844228: goto L_0x01c5;
                case 165221241: goto L_0x01ba;
                case 182191441: goto L_0x01ae;
                case 245388979: goto L_0x01a2;
                case 287431619: goto L_0x0196;
                case 307593612: goto L_0x018a;
                case 308517133: goto L_0x017e;
                case 316215098: goto L_0x0172;
                case 316215116: goto L_0x0166;
                case 316246811: goto L_0x015a;
                case 316246818: goto L_0x014e;
                case 407160593: goto L_0x0142;
                case 507412548: goto L_0x0136;
                case 793982701: goto L_0x012a;
                case 794038622: goto L_0x011e;
                case 794040393: goto L_0x0112;
                case 835649806: goto L_0x0106;
                case 917340916: goto L_0x00fb;
                case 958008161: goto L_0x00ef;
                case 1060579533: goto L_0x00e3;
                case 1150207623: goto L_0x00d7;
                case 1176899427: goto L_0x00cb;
                case 1280332038: goto L_0x00bf;
                case 1306947716: goto L_0x00b5;
                case 1349174697: goto L_0x00a9;
                case 1522194893: goto L_0x009d;
                case 1691543273: goto L_0x0091;
                case 1709443163: goto L_0x0085;
                case 1865889110: goto L_0x0079;
                case 1906253259: goto L_0x006d;
                case 1977196784: goto L_0x0061;
                case 2029784656: goto L_0x0055;
                case 2030379515: goto L_0x0049;
                case 2047190025: goto L_0x003d;
                case 2047252157: goto L_0x0031;
                case 2048319463: goto L_0x0025;
                default: goto L_0x0023;
            }     // Catch:{ all -> 0x05d3 }
        L_0x0023:
            goto L_0x059a
        L_0x0025:
            java.lang.String r1 = "HWVNS-H"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 50
            goto L_0x059b
        L_0x0031:
            java.lang.String r1 = "ELUGA_Prim"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 25
            goto L_0x059b
        L_0x003d:
            java.lang.String r1 = "ELUGA_Note"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 24
            goto L_0x059b
        L_0x0049:
            java.lang.String r1 = "HWCAM-H"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 49
            goto L_0x059b
        L_0x0055:
            java.lang.String r1 = "HWBLN-H"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 48
            goto L_0x059b
        L_0x0061:
            java.lang.String r1 = "Infinix-X572"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 52
            goto L_0x059b
        L_0x006d:
            java.lang.String r1 = "PB2-670M"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 79
            goto L_0x059b
        L_0x0079:
            java.lang.String r1 = "santoni"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 95
            goto L_0x059b
        L_0x0085:
            java.lang.String r1 = "iball8735_9806"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 51
            goto L_0x059b
        L_0x0091:
            java.lang.String r1 = "CPH1609"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 17
            goto L_0x059b
        L_0x009d:
            java.lang.String r1 = "woods_f"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 111(0x6f, float:1.56E-43)
            goto L_0x059b
        L_0x00a9:
            java.lang.String r1 = "htc_e56ml_dtul"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 46
            goto L_0x059b
        L_0x00b5:
            java.lang.String r3 = "EverStar_S"
            boolean r0 = r0.equals(r3)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            goto L_0x059b
        L_0x00bf:
            java.lang.String r1 = "hwALE-H"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 47
            goto L_0x059b
        L_0x00cb:
            java.lang.String r1 = "itel_S41"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 54
            goto L_0x059b
        L_0x00d7:
            java.lang.String r1 = "LS-5017"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 59
            goto L_0x059b
        L_0x00e3:
            java.lang.String r1 = "panell_d"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 75
            goto L_0x059b
        L_0x00ef:
            java.lang.String r1 = "j2xlteins"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 55
            goto L_0x059b
        L_0x00fb:
            java.lang.String r1 = "A7000plus"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 7
            goto L_0x059b
        L_0x0106:
            java.lang.String r1 = "manning"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 61
            goto L_0x059b
        L_0x0112:
            java.lang.String r1 = "GIONEE_WBL7519"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 44
            goto L_0x059b
        L_0x011e:
            java.lang.String r1 = "GIONEE_WBL7365"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 43
            goto L_0x059b
        L_0x012a:
            java.lang.String r1 = "GIONEE_WBL5708"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 42
            goto L_0x059b
        L_0x0136:
            java.lang.String r1 = "QM16XE_U"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 93
            goto L_0x059b
        L_0x0142:
            java.lang.String r1 = "Pixi5-10_4G"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 85
            goto L_0x059b
        L_0x014e:
            java.lang.String r1 = "TB3-850M"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 103(0x67, float:1.44E-43)
            goto L_0x059b
        L_0x015a:
            java.lang.String r1 = "TB3-850F"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 102(0x66, float:1.43E-43)
            goto L_0x059b
        L_0x0166:
            java.lang.String r1 = "TB3-730X"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 101(0x65, float:1.42E-43)
            goto L_0x059b
        L_0x0172:
            java.lang.String r1 = "TB3-730F"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 100
            goto L_0x059b
        L_0x017e:
            java.lang.String r1 = "A7020a48"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 9
            goto L_0x059b
        L_0x018a:
            java.lang.String r1 = "A7010a48"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 8
            goto L_0x059b
        L_0x0196:
            java.lang.String r1 = "griffin"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 45
            goto L_0x059b
        L_0x01a2:
            java.lang.String r1 = "marino_f"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 62
            goto L_0x059b
        L_0x01ae:
            java.lang.String r1 = "CPY83_I00"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 18
            goto L_0x059b
        L_0x01ba:
            java.lang.String r1 = "A2016a40"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 5
            goto L_0x059b
        L_0x01c5:
            java.lang.String r1 = "le_x6"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 58
            goto L_0x059b
        L_0x01d1:
            java.lang.String r1 = "X3_HK"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 113(0x71, float:1.58E-43)
            goto L_0x059b
        L_0x01dd:
            java.lang.String r1 = "V23GB"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 106(0x6a, float:1.49E-43)
            goto L_0x059b
        L_0x01e9:
            java.lang.String r1 = "Q4310"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 91
            goto L_0x059b
        L_0x01f5:
            java.lang.String r1 = "Q4260"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 89
            goto L_0x059b
        L_0x0201:
            java.lang.String r1 = "PRO7S"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 87
            goto L_0x059b
        L_0x020d:
            java.lang.String r1 = "F3311"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 34
            goto L_0x059b
        L_0x0219:
            java.lang.String r1 = "F3215"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 33
            goto L_0x059b
        L_0x0225:
            java.lang.String r1 = "F3213"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 32
            goto L_0x059b
        L_0x0231:
            java.lang.String r1 = "F3211"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 31
            goto L_0x059b
        L_0x023d:
            java.lang.String r1 = "F3116"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 30
            goto L_0x059b
        L_0x0249:
            java.lang.String r1 = "F3113"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 29
            goto L_0x059b
        L_0x0255:
            java.lang.String r1 = "F3111"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 28
            goto L_0x059b
        L_0x0261:
            java.lang.String r1 = "E5643"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 22
            goto L_0x059b
        L_0x026d:
            java.lang.String r1 = "A1601"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 4
            goto L_0x059b
        L_0x0278:
            java.lang.String r1 = "Aura_Note_2"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 11
            goto L_0x059b
        L_0x0284:
            java.lang.String r1 = "MEIZU_M5"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 63
            goto L_0x059b
        L_0x0290:
            java.lang.String r1 = "p212"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 72
            goto L_0x059b
        L_0x029c:
            java.lang.String r1 = "mido"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 65
            goto L_0x059b
        L_0x02a8:
            java.lang.String r1 = "XE2X"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 114(0x72, float:1.6E-43)
            goto L_0x059b
        L_0x02b4:
            java.lang.String r1 = "Q427"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 90
            goto L_0x059b
        L_0x02c0:
            java.lang.String r1 = "Q350"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 88
            goto L_0x059b
        L_0x02cc:
            java.lang.String r1 = "P681"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 73
            goto L_0x059b
        L_0x02d8:
            java.lang.String r1 = "1714"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 2
            goto L_0x059b
        L_0x02e3:
            java.lang.String r1 = "1713"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = r5
            goto L_0x059b
        L_0x02ee:
            java.lang.String r1 = "1601"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = r2
            goto L_0x059b
        L_0x02f9:
            java.lang.String r1 = "flo"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 35
            goto L_0x059b
        L_0x0305:
            java.lang.String r1 = "deb"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 21
            goto L_0x059b
        L_0x0311:
            java.lang.String r1 = "cv3"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 20
            goto L_0x059b
        L_0x031d:
            java.lang.String r1 = "cv1"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 19
            goto L_0x059b
        L_0x0329:
            java.lang.String r1 = "Z80"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 117(0x75, float:1.64E-43)
            goto L_0x059b
        L_0x0335:
            java.lang.String r1 = "QX1"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 94
            goto L_0x059b
        L_0x0341:
            java.lang.String r1 = "PLE"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 86
            goto L_0x059b
        L_0x034d:
            java.lang.String r1 = "P85"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 74
            goto L_0x059b
        L_0x0359:
            java.lang.String r1 = "MX6"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 66
            goto L_0x059b
        L_0x0365:
            java.lang.String r1 = "M5c"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 60
            goto L_0x059b
        L_0x0371:
            java.lang.String r1 = "JGZ"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 56
            goto L_0x059b
        L_0x037d:
            java.lang.String r1 = "mh"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 64
            goto L_0x059b
        L_0x0389:
            java.lang.String r1 = "V5"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 107(0x6b, float:1.5E-43)
            goto L_0x059b
        L_0x0395:
            java.lang.String r1 = "V1"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 105(0x69, float:1.47E-43)
            goto L_0x059b
        L_0x03a1:
            java.lang.String r1 = "Q5"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 92
            goto L_0x059b
        L_0x03ad:
            java.lang.String r1 = "C1"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 14
            goto L_0x059b
        L_0x03b9:
            java.lang.String r1 = "woods_fn"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 112(0x70, float:1.57E-43)
            goto L_0x059b
        L_0x03c5:
            java.lang.String r1 = "ELUGA_A3_Pro"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 23
            goto L_0x059b
        L_0x03d1:
            java.lang.String r1 = "Z12_PRO"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 116(0x74, float:1.63E-43)
            goto L_0x059b
        L_0x03dd:
            java.lang.String r1 = "BLACK-1X"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 12
            goto L_0x059b
        L_0x03e9:
            java.lang.String r1 = "taido_row"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 99
            goto L_0x059b
        L_0x03f5:
            java.lang.String r1 = "Pixi4-7_3G"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 84
            goto L_0x059b
        L_0x0401:
            java.lang.String r1 = "GIONEE_GBL7360"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 38
            goto L_0x059b
        L_0x040d:
            java.lang.String r1 = "GiONEE_CBL7513"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 36
            goto L_0x059b
        L_0x0419:
            java.lang.String r1 = "OnePlus5T"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 71
            goto L_0x059b
        L_0x0425:
            java.lang.String r1 = "whyred"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 110(0x6e, float:1.54E-43)
            goto L_0x059b
        L_0x0431:
            java.lang.String r1 = "watson"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 109(0x6d, float:1.53E-43)
            goto L_0x059b
        L_0x043d:
            java.lang.String r1 = "SVP-DTV15"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 97
            goto L_0x059b
        L_0x0449:
            java.lang.String r1 = "A7000-a"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 6
            goto L_0x059b
        L_0x0454:
            java.lang.String r1 = "nicklaus_f"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 68
            goto L_0x059b
        L_0x0460:
            java.lang.String r1 = "tcl_eu"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 104(0x68, float:1.46E-43)
            goto L_0x059b
        L_0x046c:
            java.lang.String r1 = "ELUGA_Ray_X"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 26
            goto L_0x059b
        L_0x0478:
            java.lang.String r1 = "s905x018"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 98
            goto L_0x059b
        L_0x0484:
            java.lang.String r1 = "A10-70F"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 3
            goto L_0x059b
        L_0x048f:
            java.lang.String r1 = "namath"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 67
            goto L_0x059b
        L_0x049b:
            java.lang.String r1 = "Slate_Pro"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 96
            goto L_0x059b
        L_0x04a7:
            java.lang.String r1 = "iris60"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 53
            goto L_0x059b
        L_0x04b3:
            java.lang.String r1 = "BRAVIA_ATV2"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 13
            goto L_0x059b
        L_0x04bf:
            java.lang.String r1 = "GiONEE_GBL7319"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 37
            goto L_0x059b
        L_0x04cb:
            java.lang.String r1 = "panell_dt"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 78
            goto L_0x059b
        L_0x04d7:
            java.lang.String r1 = "panell_ds"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 77
            goto L_0x059b
        L_0x04e3:
            java.lang.String r1 = "panell_dl"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 76
            goto L_0x059b
        L_0x04ef:
            java.lang.String r1 = "vernee_M5"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 108(0x6c, float:1.51E-43)
            goto L_0x059b
        L_0x04fb:
            java.lang.String r1 = "Phantom6"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 83
            goto L_0x059b
        L_0x0507:
            java.lang.String r1 = "ComioS1"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 15
            goto L_0x059b
        L_0x0513:
            java.lang.String r1 = "XT1663"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 115(0x73, float:1.61E-43)
            goto L_0x059b
        L_0x051f:
            java.lang.String r1 = "AquaPowerM"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 10
            goto L_0x059b
        L_0x052b:
            java.lang.String r1 = "PGN611"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 82
            goto L_0x059b
        L_0x0537:
            java.lang.String r1 = "PGN610"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 81
            goto L_0x059b
        L_0x0542:
            java.lang.String r1 = "PGN528"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 80
            goto L_0x059b
        L_0x054d:
            java.lang.String r1 = "NX573J"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 70
            goto L_0x059b
        L_0x0558:
            java.lang.String r1 = "NX541J"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 69
            goto L_0x059b
        L_0x0563:
            java.lang.String r1 = "CP8676_I02"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 16
            goto L_0x059b
        L_0x056e:
            java.lang.String r1 = "K50a40"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 57
            goto L_0x059b
        L_0x0579:
            java.lang.String r1 = "GIONEE_SWW1631"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 41
            goto L_0x059b
        L_0x0584:
            java.lang.String r1 = "GIONEE_SWW1627"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 40
            goto L_0x059b
        L_0x058f:
            java.lang.String r1 = "GIONEE_SWW1609"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x059a
            r1 = 39
            goto L_0x059b
        L_0x059a:
            r1 = r4
        L_0x059b:
            switch(r1) {
                case 0: goto L_0x059f;
                case 1: goto L_0x059f;
                case 2: goto L_0x059f;
                case 3: goto L_0x059f;
                case 4: goto L_0x059f;
                case 5: goto L_0x059f;
                case 6: goto L_0x059f;
                case 7: goto L_0x059f;
                case 8: goto L_0x059f;
                case 9: goto L_0x059f;
                case 10: goto L_0x059f;
                case 11: goto L_0x059f;
                case 12: goto L_0x059f;
                case 13: goto L_0x059f;
                case 14: goto L_0x059f;
                case 15: goto L_0x059f;
                case 16: goto L_0x059f;
                case 17: goto L_0x059f;
                case 18: goto L_0x059f;
                case 19: goto L_0x059f;
                case 20: goto L_0x059f;
                case 21: goto L_0x059f;
                case 22: goto L_0x059f;
                case 23: goto L_0x059f;
                case 24: goto L_0x059f;
                case 25: goto L_0x059f;
                case 26: goto L_0x059f;
                case 27: goto L_0x059f;
                case 28: goto L_0x059f;
                case 29: goto L_0x059f;
                case 30: goto L_0x059f;
                case 31: goto L_0x059f;
                case 32: goto L_0x059f;
                case 33: goto L_0x059f;
                case 34: goto L_0x059f;
                case 35: goto L_0x059f;
                case 36: goto L_0x059f;
                case 37: goto L_0x059f;
                case 38: goto L_0x059f;
                case 39: goto L_0x059f;
                case 40: goto L_0x059f;
                case 41: goto L_0x059f;
                case 42: goto L_0x059f;
                case 43: goto L_0x059f;
                case 44: goto L_0x059f;
                case 45: goto L_0x059f;
                case 46: goto L_0x059f;
                case 47: goto L_0x059f;
                case 48: goto L_0x059f;
                case 49: goto L_0x059f;
                case 50: goto L_0x059f;
                case 51: goto L_0x059f;
                case 52: goto L_0x059f;
                case 53: goto L_0x059f;
                case 54: goto L_0x059f;
                case 55: goto L_0x059f;
                case 56: goto L_0x059f;
                case 57: goto L_0x059f;
                case 58: goto L_0x059f;
                case 59: goto L_0x059f;
                case 60: goto L_0x059f;
                case 61: goto L_0x059f;
                case 62: goto L_0x059f;
                case 63: goto L_0x059f;
                case 64: goto L_0x059f;
                case 65: goto L_0x059f;
                case 66: goto L_0x059f;
                case 67: goto L_0x059f;
                case 68: goto L_0x059f;
                case 69: goto L_0x059f;
                case 70: goto L_0x059f;
                case 71: goto L_0x059f;
                case 72: goto L_0x059f;
                case 73: goto L_0x059f;
                case 74: goto L_0x059f;
                case 75: goto L_0x059f;
                case 76: goto L_0x059f;
                case 77: goto L_0x059f;
                case 78: goto L_0x059f;
                case 79: goto L_0x059f;
                case 80: goto L_0x059f;
                case 81: goto L_0x059f;
                case 82: goto L_0x059f;
                case 83: goto L_0x059f;
                case 84: goto L_0x059f;
                case 85: goto L_0x059f;
                case 86: goto L_0x059f;
                case 87: goto L_0x059f;
                case 88: goto L_0x059f;
                case 89: goto L_0x059f;
                case 90: goto L_0x059f;
                case 91: goto L_0x059f;
                case 92: goto L_0x059f;
                case 93: goto L_0x059f;
                case 94: goto L_0x059f;
                case 95: goto L_0x059f;
                case 96: goto L_0x059f;
                case 97: goto L_0x059f;
                case 98: goto L_0x059f;
                case 99: goto L_0x059f;
                case 100: goto L_0x059f;
                case 101: goto L_0x059f;
                case 102: goto L_0x059f;
                case 103: goto L_0x059f;
                case 104: goto L_0x059f;
                case 105: goto L_0x059f;
                case 106: goto L_0x059f;
                case 107: goto L_0x059f;
                case 108: goto L_0x059f;
                case 109: goto L_0x059f;
                case 110: goto L_0x059f;
                case 111: goto L_0x059f;
                case 112: goto L_0x059f;
                case 113: goto L_0x059f;
                case 114: goto L_0x059f;
                case 115: goto L_0x059f;
                case 116: goto L_0x059f;
                case 117: goto L_0x059f;
                default: goto L_0x059e;
            }     // Catch:{ all -> 0x05d3 }
        L_0x059e:
            goto L_0x05a1
        L_0x059f:
            deviceNeedsSetOutputSurfaceWorkaround = r5     // Catch:{ all -> 0x05d3 }
        L_0x05a1:
            java.lang.String r0 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.MODEL     // Catch:{ all -> 0x05d3 }
            int r1 = r0.hashCode()     // Catch:{ all -> 0x05d3 }
            r3 = 2006354(0x1e9d52, float:2.811501E-39)
            if (r1 == r3) goto L_0x05bc
            r2 = 2006367(0x1e9d5f, float:2.811519E-39)
            if (r1 == r2) goto L_0x05b2
            goto L_0x05c5
        L_0x05b2:
            java.lang.String r1 = "AFTN"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x05c5
            r2 = r5
            goto L_0x05c6
        L_0x05bc:
            java.lang.String r1 = "AFTA"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x05d3 }
            if (r0 == 0) goto L_0x05c5
            goto L_0x05c6
        L_0x05c5:
            r2 = r4
        L_0x05c6:
            if (r2 == 0) goto L_0x05cb
            if (r2 == r5) goto L_0x05cb
            goto L_0x05cd
        L_0x05cb:
            deviceNeedsSetOutputSurfaceWorkaround = r5     // Catch:{ all -> 0x05d3 }
        L_0x05cd:
            evaluatedDeviceNeedsSetOutputSurfaceWorkaround = r5     // Catch:{ all -> 0x05d3 }
        L_0x05cf:
            monitor-exit(r7)     // Catch:{ all -> 0x05d3 }
            boolean r7 = deviceNeedsSetOutputSurfaceWorkaround
            return r7
        L_0x05d3:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x05d3 }
            throw r0
        L_0x05d6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.video.MediaCodecVideoRenderer.codecNeedsSetOutputSurfaceWorkaround(java.lang.String):boolean");
    }

    protected static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.inputSize = i3;
        }
    }

    private final class OnFrameRenderedListenerV23 implements MediaCodec.OnFrameRenderedListener {
        private OnFrameRenderedListenerV23(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }

        public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
            if (this == MediaCodecVideoRenderer.this.tunnelingOnFrameRenderedListener) {
                MediaCodecVideoRenderer.this.maybeNotifyRenderedFirstFrame();
            }
        }
    }
}
