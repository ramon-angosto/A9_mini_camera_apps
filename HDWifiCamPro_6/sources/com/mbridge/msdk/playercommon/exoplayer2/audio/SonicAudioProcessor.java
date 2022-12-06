package com.mbridge.msdk.playercommon.exoplayer2.audio;

import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class SonicAudioProcessor implements AudioProcessor {
    private static final float CLOSE_THRESHOLD = 0.01f;
    public static final float MAXIMUM_PITCH = 8.0f;
    public static final float MAXIMUM_SPEED = 8.0f;
    public static final float MINIMUM_PITCH = 0.1f;
    public static final float MINIMUM_SPEED = 0.1f;
    private static final int MIN_BYTES_FOR_SPEEDUP_CALCULATION = 1024;
    public static final int SAMPLE_RATE_NO_CHANGE = -1;
    private ByteBuffer buffer = EMPTY_BUFFER;
    private int channelCount = -1;
    private long inputBytes;
    private boolean inputEnded;
    private ByteBuffer outputBuffer = EMPTY_BUFFER;
    private long outputBytes;
    private int outputSampleRateHz = -1;
    private int pendingOutputSampleRateHz = -1;
    private float pitch = 1.0f;
    private int sampleRateHz = -1;
    private ShortBuffer shortBuffer = this.buffer.asShortBuffer();
    private Sonic sonic;
    private float speed = 1.0f;

    public final int getOutputEncoding() {
        return 2;
    }

    public final float setSpeed(float f) {
        float constrainValue = Util.constrainValue(f, 0.1f, 8.0f);
        if (this.speed != constrainValue) {
            this.speed = constrainValue;
            this.sonic = null;
        }
        flush();
        return constrainValue;
    }

    public final float setPitch(float f) {
        float constrainValue = Util.constrainValue(f, 0.1f, 8.0f);
        if (this.pitch != constrainValue) {
            this.pitch = constrainValue;
            this.sonic = null;
        }
        flush();
        return constrainValue;
    }

    public final void setOutputSampleRateHz(int i) {
        this.pendingOutputSampleRateHz = i;
    }

    public final long scaleDurationForSpeedup(long j) {
        long j2 = this.outputBytes;
        if (j2 < 1024) {
            return (long) (((double) this.speed) * ((double) j));
        }
        int i = this.outputSampleRateHz;
        int i2 = this.sampleRateHz;
        if (i == i2) {
            return Util.scaleLargeTimestamp(j, this.inputBytes, j2);
        }
        return Util.scaleLargeTimestamp(j, this.inputBytes * ((long) i), j2 * ((long) i2));
    }

    public final boolean configure(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        if (i3 == 2) {
            int i4 = this.pendingOutputSampleRateHz;
            if (i4 == -1) {
                i4 = i;
            }
            if (this.sampleRateHz == i && this.channelCount == i2 && this.outputSampleRateHz == i4) {
                return false;
            }
            this.sampleRateHz = i;
            this.channelCount = i2;
            this.outputSampleRateHz = i4;
            this.sonic = null;
            return true;
        }
        throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
    }

    public final boolean isActive() {
        return this.sampleRateHz != -1 && (Math.abs(this.speed - 1.0f) >= CLOSE_THRESHOLD || Math.abs(this.pitch - 1.0f) >= CLOSE_THRESHOLD || this.outputSampleRateHz != this.sampleRateHz);
    }

    public final int getOutputChannelCount() {
        return this.channelCount;
    }

    public final int getOutputSampleRateHz() {
        return this.outputSampleRateHz;
    }

    public final void queueInput(ByteBuffer byteBuffer) {
        Assertions.checkState(this.sonic != null);
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.inputBytes += (long) remaining;
            this.sonic.queueInput(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int framesAvailable = this.sonic.getFramesAvailable() * this.channelCount * 2;
        if (framesAvailable > 0) {
            if (this.buffer.capacity() < framesAvailable) {
                this.buffer = ByteBuffer.allocateDirect(framesAvailable).order(ByteOrder.nativeOrder());
                this.shortBuffer = this.buffer.asShortBuffer();
            } else {
                this.buffer.clear();
                this.shortBuffer.clear();
            }
            this.sonic.getOutput(this.shortBuffer);
            this.outputBytes += (long) framesAvailable;
            this.buffer.limit(framesAvailable);
            this.outputBuffer = this.buffer;
        }
    }

    public final void queueEndOfStream() {
        Assertions.checkState(this.sonic != null);
        this.sonic.queueEndOfStream();
        this.inputEnded = true;
    }

    public final ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.outputBuffer;
        this.outputBuffer = EMPTY_BUFFER;
        return byteBuffer;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.sonic;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isEnded() {
        /*
            r1 = this;
            boolean r0 = r1.inputEnded
            if (r0 == 0) goto L_0x0010
            com.mbridge.msdk.playercommon.exoplayer2.audio.Sonic r0 = r1.sonic
            if (r0 == 0) goto L_0x000e
            int r0 = r0.getFramesAvailable()
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.audio.SonicAudioProcessor.isEnded():boolean");
    }

    public final void flush() {
        if (isActive()) {
            Sonic sonic2 = this.sonic;
            if (sonic2 == null) {
                this.sonic = new Sonic(this.sampleRateHz, this.channelCount, this.speed, this.pitch, this.outputSampleRateHz);
            } else {
                sonic2.flush();
            }
        }
        this.outputBuffer = EMPTY_BUFFER;
        this.inputBytes = 0;
        this.outputBytes = 0;
        this.inputEnded = false;
    }

    public final void reset() {
        this.speed = 1.0f;
        this.pitch = 1.0f;
        this.channelCount = -1;
        this.sampleRateHz = -1;
        this.outputSampleRateHz = -1;
        this.buffer = EMPTY_BUFFER;
        this.shortBuffer = this.buffer.asShortBuffer();
        this.outputBuffer = EMPTY_BUFFER;
        this.pendingOutputSampleRateHz = -1;
        this.sonic = null;
        this.inputBytes = 0;
        this.outputBytes = 0;
        this.inputEnded = false;
    }
}
