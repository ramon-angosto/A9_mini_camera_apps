package com.mbridge.msdk.playercommon.exoplayer2.mediacodec;

import com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecUtil;

public interface MediaCodecSelector {
    public static final MediaCodecSelector DEFAULT = new MediaCodecSelector() {
        public final MediaCodecInfo getDecoderInfo(String str, boolean z) throws MediaCodecUtil.DecoderQueryException {
            return MediaCodecUtil.getDecoderInfo(str, z);
        }

        public final MediaCodecInfo getPassthroughDecoderInfo() throws MediaCodecUtil.DecoderQueryException {
            return MediaCodecUtil.getPassthroughDecoderInfo();
        }
    };

    MediaCodecInfo getDecoderInfo(String str, boolean z) throws MediaCodecUtil.DecoderQueryException;

    MediaCodecInfo getPassthroughDecoderInfo() throws MediaCodecUtil.DecoderQueryException;
}
