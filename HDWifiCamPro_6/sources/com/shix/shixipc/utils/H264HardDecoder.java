package com.shix.shixipc.utils;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import androidx.work.WorkRequest;
import com.shix.shixipc.system.ContentCommon;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.time.DurationKt;

public class H264HardDecoder {
    private MediaCodec decoder;
    private byte[] h264IFramDate;
    private int height;
    private MediaCodec.BufferInfo info;
    private ByteBuffer[] inputBuffers;
    private int mCount;
    private ByteBuffer[] outputBuffers;
    private long startMs;
    private String strDec = "video/avc";
    private Surface surface;
    private int width;

    public H264HardDecoder(Surface surface2, Context context) {
        this.surface = surface2;
        this.decoder = null;
        this.width = 0;
        this.height = 0;
        this.h264IFramDate = null;
    }

    public int H264HardStartDecoder(int i, int i2, boolean z) {
        if (z) {
            this.strDec = "video/hevc";
        } else {
            this.strDec = "video/avc";
        }
        this.width = i;
        this.height = i2;
        if (this.decoder != null) {
            Log.e(ContentCommon.SERVER_STRING, "ZHAOPLAY now is H264HardStartDecoder,please H264HardDesdoryDecoder first");
            return -2;
        }
        try {
            this.decoder = MediaCodec.createDecoderByType(this.strDec);
        } catch (IOException e) {
            Log.e(ContentCommon.SERVER_STRING, "ZHAOPLAY !!!!!!!!!!e:" + e.toString());
            e.printStackTrace();
        }
        this.decoder.configure(MediaFormat.createVideoFormat(this.strDec, this.width, this.height), this.surface, (MediaCrypto) null, 0);
        MediaCodec mediaCodec = this.decoder;
        if (mediaCodec == null) {
            Log.e(ContentCommon.SERVER_STRING, "ZHAOPLAY can not init decoder!no info!!!!!!!!!!");
            return -1;
        }
        this.mCount = 1;
        mediaCodec.start();
        this.inputBuffers = this.decoder.getInputBuffers();
        this.outputBuffers = this.decoder.getOutputBuffers();
        this.info = new MediaCodec.BufferInfo();
        this.startMs = System.currentTimeMillis();
        return 0;
    }

    public void H264HardDesdoryDecoder() {
        MediaCodec mediaCodec = this.decoder;
        if (mediaCodec != null) {
            mediaCodec.release();
        }
        this.decoder = null;
    }

    public int H264HardDecoderOneFram(byte[] bArr, int i, int i2, int i3, int i4) {
        byte[] bArr2 = bArr;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        Log.i(ContentCommon.SERVER_STRING, "ZHAOPLAY----------- H264HardDecoderOneFram length:" + i + "  width2:" + i6 + "  height2:" + i7 + " IorBFram:" + i8 + "  width:" + this.width + "  height:" + this.height + " \n");
        if (!(this.width == i6 && this.height == i7)) {
            MediaCodec mediaCodec = this.decoder;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.decoder.release();
            }
            this.decoder = null;
            try {
                this.decoder = MediaCodec.createDecoderByType(this.strDec);
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.decoder.configure(MediaFormat.createVideoFormat(this.strDec, this.width, this.height), this.surface, (MediaCrypto) null, 0);
            MediaCodec mediaCodec2 = this.decoder;
            if (mediaCodec2 == null) {
                Log.e(ContentCommon.SERVER_STRING, "ZHAOPLAY can not init decoder!no info!!!!!!!!!!");
                return -1;
            }
            this.mCount = 1;
            mediaCodec2.start();
            this.inputBuffers = this.decoder.getInputBuffers();
            this.outputBuffers = this.decoder.getOutputBuffers();
            this.info = new MediaCodec.BufferInfo();
            this.startMs = System.currentTimeMillis();
        }
        if (this.decoder == null) {
            return -1;
        }
        if (i8 == 0) {
            this.h264IFramDate = bArr2;
        }
        Log.i(ContentCommon.SERVER_STRING, "ZHAOPLAY----------- decoder.dequeueInputBuffer");
        int dequeueInputBuffer = this.decoder.dequeueInputBuffer(-1);
        if (dequeueInputBuffer >= 0) {
            ByteBuffer byteBuffer = this.inputBuffers[dequeueInputBuffer];
            byteBuffer.clear();
            byteBuffer.put(bArr, 0, i);
            Log.i(ContentCommon.SERVER_STRING, "ZHAOPLAY----------- queueInputBuffer start");
            this.decoder.queueInputBuffer(dequeueInputBuffer, 0, i, (long) ((this.mCount * DurationKt.NANOS_IN_MILLIS) / 50), 0);
            Log.i(ContentCommon.SERVER_STRING, "ZHAOPLAY----------- queueInputBuffer end");
            this.mCount++;
        }
        Log.i(ContentCommon.SERVER_STRING, "ZHAOPLAY----------- dequeueOutputBuffer start");
        int dequeueOutputBuffer = this.decoder.dequeueOutputBuffer(this.info, WorkRequest.MIN_BACKOFF_MILLIS);
        Log.i(ContentCommon.SERVER_STRING, "ZHAOPLAY----------- dequeueOutputBuffer end");
        if (dequeueOutputBuffer == -3) {
            this.outputBuffers = this.decoder.getOutputBuffers();
        } else if (!(dequeueOutputBuffer == -2 || dequeueOutputBuffer == -1)) {
            this.decoder.releaseOutputBuffer(dequeueOutputBuffer, true);
        }
        if ((this.info.flags & 4) != 0) {
            Log.d(ContentCommon.SERVER_STRING, "OutputBuffer BUFFER_FLAG_END_OF_STREAM");
        }
        return 0;
    }
}
