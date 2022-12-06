package com.mbridge.msdk.playercommon.exoplayer2.drm;

import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSession;
import com.mbridge.msdk.playercommon.exoplayer2.drm.ExoMediaCrypto;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.HttpDataSource;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.util.HashMap;
import java.util.UUID;

public final class OfflineLicenseHelper<T extends ExoMediaCrypto> {
    /* access modifiers changed from: private */
    public final ConditionVariable conditionVariable;
    private final DefaultDrmSessionManager<T> drmSessionManager;
    private final HandlerThread handlerThread = new HandlerThread("OfflineLicenseHelper");

    public static OfflineLicenseHelper<FrameworkMediaCrypto> newWidevineInstance(String str, HttpDataSource.Factory factory) throws UnsupportedDrmException {
        return newWidevineInstance(str, false, factory, (HashMap<String, String>) null);
    }

    public static OfflineLicenseHelper<FrameworkMediaCrypto> newWidevineInstance(String str, boolean z, HttpDataSource.Factory factory) throws UnsupportedDrmException {
        return newWidevineInstance(str, z, factory, (HashMap<String, String>) null);
    }

    public static OfflineLicenseHelper<FrameworkMediaCrypto> newWidevineInstance(String str, boolean z, HttpDataSource.Factory factory, HashMap<String, String> hashMap) throws UnsupportedDrmException {
        return new OfflineLicenseHelper<>(C.WIDEVINE_UUID, FrameworkMediaDrm.newInstance(C.WIDEVINE_UUID), new HttpMediaDrmCallback(str, z, factory), hashMap);
    }

    public OfflineLicenseHelper(UUID uuid, ExoMediaDrm<T> exoMediaDrm, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap) {
        this.handlerThread.start();
        this.conditionVariable = new ConditionVariable();
        AnonymousClass1 r0 = new DefaultDrmSessionEventListener() {
            public void onDrmKeysLoaded() {
                OfflineLicenseHelper.this.conditionVariable.open();
            }

            public void onDrmSessionManagerError(Exception exc) {
                OfflineLicenseHelper.this.conditionVariable.open();
            }

            public void onDrmKeysRestored() {
                OfflineLicenseHelper.this.conditionVariable.open();
            }

            public void onDrmKeysRemoved() {
                OfflineLicenseHelper.this.conditionVariable.open();
            }
        };
        this.drmSessionManager = new DefaultDrmSessionManager<>(uuid, exoMediaDrm, mediaDrmCallback, hashMap);
        this.drmSessionManager.addListener(new Handler(this.handlerThread.getLooper()), r0);
    }

    public final synchronized byte[] getPropertyByteArray(String str) {
        return this.drmSessionManager.getPropertyByteArray(str);
    }

    public final synchronized void setPropertyByteArray(String str, byte[] bArr) {
        this.drmSessionManager.setPropertyByteArray(str, bArr);
    }

    public final synchronized String getPropertyString(String str) {
        return this.drmSessionManager.getPropertyString(str);
    }

    public final synchronized void setPropertyString(String str, String str2) {
        this.drmSessionManager.setPropertyString(str, str2);
    }

    public final synchronized byte[] downloadLicense(DrmInitData drmInitData) throws DrmSession.DrmSessionException {
        Assertions.checkArgument(drmInitData != null);
        return blockingKeyRequest(2, (byte[]) null, drmInitData);
    }

    public final synchronized byte[] renewLicense(byte[] bArr) throws DrmSession.DrmSessionException {
        Assertions.checkNotNull(bArr);
        return blockingKeyRequest(2, bArr, (DrmInitData) null);
    }

    public final synchronized void releaseLicense(byte[] bArr) throws DrmSession.DrmSessionException {
        Assertions.checkNotNull(bArr);
        blockingKeyRequest(3, bArr, (DrmInitData) null);
    }

    public final synchronized Pair<Long, Long> getLicenseDurationRemainingSec(byte[] bArr) throws DrmSession.DrmSessionException {
        Assertions.checkNotNull(bArr);
        DrmSession openBlockingKeyRequest = openBlockingKeyRequest(1, bArr, (DrmInitData) null);
        DrmSession.DrmSessionException error = openBlockingKeyRequest.getError();
        Pair<Long, Long> licenseDurationRemainingSec = WidevineUtil.getLicenseDurationRemainingSec(openBlockingKeyRequest);
        this.drmSessionManager.releaseSession(openBlockingKeyRequest);
        if (error == null) {
            return licenseDurationRemainingSec;
        }
        if (error.getCause() instanceof KeysExpiredException) {
            return Pair.create(0L, 0L);
        }
        throw error;
    }

    public final void release() {
        this.handlerThread.quit();
    }

    private byte[] blockingKeyRequest(int i, byte[] bArr, DrmInitData drmInitData) throws DrmSession.DrmSessionException {
        DrmSession openBlockingKeyRequest = openBlockingKeyRequest(i, bArr, drmInitData);
        DrmSession.DrmSessionException error = openBlockingKeyRequest.getError();
        byte[] offlineLicenseKeySetId = openBlockingKeyRequest.getOfflineLicenseKeySetId();
        this.drmSessionManager.releaseSession(openBlockingKeyRequest);
        if (error == null) {
            return offlineLicenseKeySetId;
        }
        throw error;
    }

    private DrmSession<T> openBlockingKeyRequest(int i, byte[] bArr, DrmInitData drmInitData) {
        this.drmSessionManager.setMode(i, bArr);
        this.conditionVariable.close();
        DrmSession<T> acquireSession = this.drmSessionManager.acquireSession(this.handlerThread.getLooper(), drmInitData);
        this.conditionVariable.block();
        return acquireSession;
    }
}
