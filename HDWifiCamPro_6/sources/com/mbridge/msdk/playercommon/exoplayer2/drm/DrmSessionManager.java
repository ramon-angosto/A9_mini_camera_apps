package com.mbridge.msdk.playercommon.exoplayer2.drm;

import android.os.Looper;
import com.mbridge.msdk.playercommon.exoplayer2.drm.ExoMediaCrypto;

public interface DrmSessionManager<T extends ExoMediaCrypto> {
    DrmSession<T> acquireSession(Looper looper, DrmInitData drmInitData);

    boolean canAcquireSession(DrmInitData drmInitData);

    void releaseSession(DrmSession<T> drmSession);
}
