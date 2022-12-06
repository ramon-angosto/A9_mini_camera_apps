package com.mbridge.msdk.playercommon.exoplayer2.drm;

import android.media.MediaCrypto;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

public final class FrameworkMediaCrypto implements ExoMediaCrypto {
    private final boolean forceAllowInsecureDecoderComponents;
    private final MediaCrypto mediaCrypto;

    public FrameworkMediaCrypto(MediaCrypto mediaCrypto2) {
        this(mediaCrypto2, false);
    }

    public FrameworkMediaCrypto(MediaCrypto mediaCrypto2, boolean z) {
        this.mediaCrypto = (MediaCrypto) Assertions.checkNotNull(mediaCrypto2);
        this.forceAllowInsecureDecoderComponents = z;
    }

    public final MediaCrypto getWrappedMediaCrypto() {
        return this.mediaCrypto;
    }

    public final boolean requiresSecureDecoderComponent(String str) {
        return !this.forceAllowInsecureDecoderComponents && this.mediaCrypto.requiresSecureDecoderComponent(str);
    }
}
