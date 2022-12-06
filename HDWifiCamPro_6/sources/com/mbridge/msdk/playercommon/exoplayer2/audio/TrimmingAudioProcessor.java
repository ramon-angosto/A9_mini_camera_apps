package com.mbridge.msdk.playercommon.exoplayer2.audio;

import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class TrimmingAudioProcessor implements AudioProcessor {
    private ByteBuffer buffer = EMPTY_BUFFER;
    private int channelCount = -1;
    private byte[] endBuffer = new byte[0];
    private int endBufferSize;
    private boolean inputEnded;
    private boolean isActive;
    private ByteBuffer outputBuffer = EMPTY_BUFFER;
    private int pendingTrimStartBytes;
    private int sampleRateHz = -1;
    private int trimEndFrames;
    private int trimStartFrames;

    public final int getOutputEncoding() {
        return 2;
    }

    public final void setTrimFrameCount(int i, int i2) {
        this.trimStartFrames = i;
        this.trimEndFrames = i2;
    }

    public final boolean configure(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        if (i3 == 2) {
            this.channelCount = i2;
            this.sampleRateHz = i;
            int i4 = this.trimEndFrames;
            this.endBuffer = new byte[(i4 * i2 * 2)];
            this.endBufferSize = 0;
            int i5 = this.trimStartFrames;
            this.pendingTrimStartBytes = i2 * i5 * 2;
            boolean z = this.isActive;
            this.isActive = (i5 == 0 && i4 == 0) ? false : true;
            if (z != this.isActive) {
                return true;
            }
            return false;
        }
        throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final int getOutputChannelCount() {
        return this.channelCount;
    }

    public final int getOutputSampleRateHz() {
        return this.sampleRateHz;
    }

    public final void queueInput(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int min = Math.min(i, this.pendingTrimStartBytes);
        this.pendingTrimStartBytes -= min;
        byteBuffer.position(position + min);
        if (this.pendingTrimStartBytes <= 0) {
            int i2 = i - min;
            int length = (this.endBufferSize + i2) - this.endBuffer.length;
            if (this.buffer.capacity() < length) {
                this.buffer = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
            } else {
                this.buffer.clear();
            }
            int constrainValue = Util.constrainValue(length, 0, this.endBufferSize);
            this.buffer.put(this.endBuffer, 0, constrainValue);
            int constrainValue2 = Util.constrainValue(length - constrainValue, 0, i2);
            byteBuffer.limit(byteBuffer.position() + constrainValue2);
            this.buffer.put(byteBuffer);
            byteBuffer.limit(limit);
            int i3 = i2 - constrainValue2;
            this.endBufferSize -= constrainValue;
            byte[] bArr = this.endBuffer;
            System.arraycopy(bArr, constrainValue, bArr, 0, this.endBufferSize);
            byteBuffer.get(this.endBuffer, this.endBufferSize, i3);
            this.endBufferSize += i3;
            this.buffer.flip();
            this.outputBuffer = this.buffer;
        }
    }

    public final void queueEndOfStream() {
        this.inputEnded = true;
    }

    public final ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.outputBuffer;
        this.outputBuffer = EMPTY_BUFFER;
        return byteBuffer;
    }

    public final boolean isEnded() {
        return this.inputEnded && this.outputBuffer == EMPTY_BUFFER;
    }

    public final void flush() {
        this.outputBuffer = EMPTY_BUFFER;
        this.inputEnded = false;
        this.pendingTrimStartBytes = 0;
        this.endBufferSize = 0;
    }

    public final void reset() {
        flush();
        this.buffer = EMPTY_BUFFER;
        this.channelCount = -1;
        this.sampleRateHz = -1;
        this.endBuffer = new byte[0];
    }
}
