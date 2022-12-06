package com.mbridge.msdk.playercommon.exoplayer2.drm;

import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.os.Handler;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.drm.ExoMediaDrm;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class FrameworkMediaDrm implements ExoMediaDrm<FrameworkMediaCrypto> {
    private static final String CENC_SCHEME_MIME_TYPE = "cenc";
    private final MediaDrm mediaDrm;
    private final UUID uuid;

    public static FrameworkMediaDrm newInstance(UUID uuid2) throws UnsupportedDrmException {
        try {
            return new FrameworkMediaDrm(uuid2);
        } catch (UnsupportedSchemeException e) {
            throw new UnsupportedDrmException(1, e);
        } catch (Exception e2) {
            throw new UnsupportedDrmException(2, e2);
        }
    }

    private FrameworkMediaDrm(UUID uuid2) throws UnsupportedSchemeException {
        Assertions.checkNotNull(uuid2);
        Assertions.checkArgument(!C.COMMON_PSSH_UUID.equals(uuid2), "Use C.CLEARKEY_UUID instead");
        if (Util.SDK_INT < 27 && C.CLEARKEY_UUID.equals(uuid2)) {
            uuid2 = C.COMMON_PSSH_UUID;
        }
        this.uuid = uuid2;
        this.mediaDrm = new MediaDrm(uuid2);
        if (C.WIDEVINE_UUID.equals(uuid2) && needsForceL3Workaround()) {
            this.mediaDrm.setPropertyString("securityLevel", "L3");
        }
    }

    public final void setOnEventListener(final ExoMediaDrm.OnEventListener<? super FrameworkMediaCrypto> onEventListener) {
        this.mediaDrm.setOnEventListener(onEventListener == null ? null : new MediaDrm.OnEventListener() {
            public void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
                onEventListener.onEvent(FrameworkMediaDrm.this, bArr, i, i2, bArr2);
            }
        });
    }

    public final void setOnKeyStatusChangeListener(final ExoMediaDrm.OnKeyStatusChangeListener<? super FrameworkMediaCrypto> onKeyStatusChangeListener) {
        if (Util.SDK_INT >= 23) {
            this.mediaDrm.setOnKeyStatusChangeListener(onKeyStatusChangeListener == null ? null : new MediaDrm.OnKeyStatusChangeListener() {
                public void onKeyStatusChange(MediaDrm mediaDrm, byte[] bArr, List<MediaDrm.KeyStatus> list, boolean z) {
                    ArrayList arrayList = new ArrayList();
                    for (MediaDrm.KeyStatus next : list) {
                        arrayList.add(new ExoMediaDrm.DefaultKeyStatus(next.getStatusCode(), next.getKeyId()));
                    }
                    onKeyStatusChangeListener.onKeyStatusChange(FrameworkMediaDrm.this, bArr, arrayList, z);
                }
            }, (Handler) null);
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final byte[] openSession() throws MediaDrmException {
        return this.mediaDrm.openSession();
    }

    public final void closeSession(byte[] bArr) {
        this.mediaDrm.closeSession(bArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        r0 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.PsshAtomUtil.parseSchemeSpecificData(r9, r7.uuid);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.playercommon.exoplayer2.drm.ExoMediaDrm.KeyRequest getKeyRequest(byte[] r8, byte[] r9, java.lang.String r10, int r11, java.util.HashMap<java.lang.String, java.lang.String> r12) throws android.media.NotProvisionedException {
        /*
            r7 = this;
            int r0 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.SDK_INT
            r1 = 21
            if (r0 >= r1) goto L_0x0010
            java.util.UUID r0 = com.mbridge.msdk.playercommon.exoplayer2.C.WIDEVINE_UUID
            java.util.UUID r1 = r7.uuid
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0042
        L_0x0010:
            java.util.UUID r0 = com.mbridge.msdk.playercommon.exoplayer2.C.PLAYREADY_UUID
            java.util.UUID r1 = r7.uuid
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004d
            java.lang.String r0 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.MANUFACTURER
            java.lang.String r1 = "Amazon"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x004d
            java.lang.String r0 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.MODEL
            java.lang.String r1 = "AFTB"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0042
            java.lang.String r0 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.MODEL
            java.lang.String r1 = "AFTS"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0042
            java.lang.String r0 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.MODEL
            java.lang.String r1 = "AFTM"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x004d
        L_0x0042:
            java.util.UUID r0 = r7.uuid
            byte[] r0 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.PsshAtomUtil.parseSchemeSpecificData(r9, r0)
            if (r0 != 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r3 = r0
            goto L_0x004e
        L_0x004d:
            r3 = r9
        L_0x004e:
            int r9 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.SDK_INT
            r0 = 26
            if (r9 >= r0) goto L_0x0070
            java.util.UUID r9 = com.mbridge.msdk.playercommon.exoplayer2.C.CLEARKEY_UUID
            java.util.UUID r0 = r7.uuid
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0070
            java.lang.String r9 = "video/mp4"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x006e
            java.lang.String r9 = "audio/mp4"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0070
        L_0x006e:
            java.lang.String r10 = "cenc"
        L_0x0070:
            r4 = r10
            android.media.MediaDrm r1 = r7.mediaDrm
            r2 = r8
            r5 = r11
            r6 = r12
            android.media.MediaDrm$KeyRequest r8 = r1.getKeyRequest(r2, r3, r4, r5, r6)
            byte[] r9 = r8.getData()
            java.util.UUID r10 = com.mbridge.msdk.playercommon.exoplayer2.C.CLEARKEY_UUID
            java.util.UUID r11 = r7.uuid
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x008c
            byte[] r9 = com.mbridge.msdk.playercommon.exoplayer2.drm.ClearKeyUtil.adjustRequestData(r9)
        L_0x008c:
            com.mbridge.msdk.playercommon.exoplayer2.drm.ExoMediaDrm$DefaultKeyRequest r10 = new com.mbridge.msdk.playercommon.exoplayer2.drm.ExoMediaDrm$DefaultKeyRequest
            java.lang.String r8 = r8.getDefaultUrl()
            r10.<init>(r9, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaDrm.getKeyRequest(byte[], byte[], java.lang.String, int, java.util.HashMap):com.mbridge.msdk.playercommon.exoplayer2.drm.ExoMediaDrm$KeyRequest");
    }

    public final byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException {
        if (C.CLEARKEY_UUID.equals(this.uuid)) {
            bArr2 = ClearKeyUtil.adjustResponseData(bArr2);
        }
        return this.mediaDrm.provideKeyResponse(bArr, bArr2);
    }

    public final ExoMediaDrm.ProvisionRequest getProvisionRequest() {
        MediaDrm.ProvisionRequest provisionRequest = this.mediaDrm.getProvisionRequest();
        return new ExoMediaDrm.DefaultProvisionRequest(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    public final void provideProvisionResponse(byte[] bArr) throws DeniedByServerException {
        this.mediaDrm.provideProvisionResponse(bArr);
    }

    public final Map<String, String> queryKeyStatus(byte[] bArr) {
        return this.mediaDrm.queryKeyStatus(bArr);
    }

    public final void release() {
        this.mediaDrm.release();
    }

    public final void restoreKeys(byte[] bArr, byte[] bArr2) {
        this.mediaDrm.restoreKeys(bArr, bArr2);
    }

    public final String getPropertyString(String str) {
        return this.mediaDrm.getPropertyString(str);
    }

    public final byte[] getPropertyByteArray(String str) {
        return this.mediaDrm.getPropertyByteArray(str);
    }

    public final void setPropertyString(String str, String str2) {
        this.mediaDrm.setPropertyString(str, str2);
    }

    public final void setPropertyByteArray(String str, byte[] bArr) {
        this.mediaDrm.setPropertyByteArray(str, bArr);
    }

    public final FrameworkMediaCrypto createMediaCrypto(byte[] bArr) throws MediaCryptoException {
        return new FrameworkMediaCrypto(new MediaCrypto(this.uuid, bArr), Util.SDK_INT < 21 && C.WIDEVINE_UUID.equals(this.uuid) && "L3".equals(getPropertyString("securityLevel")));
    }

    private static boolean needsForceL3Workaround() {
        return "ASUS_Z00AD".equals(Util.MODEL);
    }
}
