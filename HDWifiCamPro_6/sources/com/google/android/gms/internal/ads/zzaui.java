package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaui extends zzawu implements zzbag {
    /* access modifiers changed from: private */
    public final zzats zzb;
    private final zzaue zzc = new zzaue((zzatj) null, new zzatl[0], new zzauh(this, (zzaug) null));
    private boolean zzd;
    private int zze;
    private int zzf;
    private long zzg;
    /* access modifiers changed from: private */
    public boolean zzh;

    public zzaui(zzaww zzaww, zzauw zzauw, boolean z, Handler handler, zzatt zzatt) {
        super(1, zzaww, (zzauw) null, true);
        this.zzb = new zzats(handler, zzatt);
    }

    public final boolean zzE() {
        return super.zzE() && this.zzc.zzo();
    }

    public final boolean zzF() {
        return this.zzc.zzn() || super.zzF();
    }

    /* access modifiers changed from: protected */
    public final int zzH(zzaww zzaww, zzasw zzasw) throws zzawz {
        int i;
        int i2;
        String str = zzasw.zzf;
        if (!zzbah.zza(str)) {
            return 0;
        }
        int i3 = zzbar.zza >= 21 ? 16 : 0;
        zzaws zzc2 = zzaxe.zzc(str, false);
        if (zzc2 == null) {
            return 1;
        }
        int i4 = 3;
        if (zzbar.zza >= 21 && (((i = zzasw.zzs) != -1 && !zzc2.zzd(i)) || ((i2 = zzasw.zzr) != -1 && !zzc2.zzc(i2)))) {
            i4 = 2;
        }
        return i3 | 4 | i4;
    }

    public final long zzI() {
        long zza = this.zzc.zza(zzE());
        if (zza != Long.MIN_VALUE) {
            if (!this.zzh) {
                zza = Math.max(this.zzg, zza);
            }
            this.zzg = zza;
            this.zzh = false;
        }
        return this.zzg;
    }

    public final zzata zzJ() {
        return this.zzc.zzc();
    }

    public final zzata zzK(zzata zzata) {
        return this.zzc.zzd(zzata);
    }

    /* access modifiers changed from: protected */
    public final zzaws zzM(zzaww zzaww, zzasw zzasw, boolean z) throws zzawz {
        return super.zzM(zzaww, zzasw, false);
    }

    /* access modifiers changed from: protected */
    public final void zzO(zzaws zzaws, MediaCodec mediaCodec, zzasw zzasw, MediaCrypto mediaCrypto) {
        String str = zzaws.zza;
        boolean z = true;
        if (zzbar.zza >= 24 || !"OMX.SEC.aac.dec".equals(str) || !"samsung".equals(zzbar.zzc) || (!zzbar.zzb.startsWith("zeroflte") && !zzbar.zzb.startsWith("herolte") && !zzbar.zzb.startsWith("heroqlte"))) {
            z = false;
        }
        this.zzd = z;
        mediaCodec.configure(zzasw.zzb(), (Surface) null, (MediaCrypto) null, 0);
    }

    /* access modifiers changed from: protected */
    public final void zzP(String str, long j, long j2) {
        this.zzb.zzd(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public final void zzQ(zzasw zzasw) throws zzasi {
        super.zzQ(zzasw);
        this.zzb.zzg(zzasw);
        this.zze = MimeTypes.AUDIO_RAW.equals(zzasw.zzf) ? zzasw.zzt : 2;
        this.zzf = zzasw.zzr;
    }

    /* access modifiers changed from: protected */
    public final void zzR(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzasi {
        int[] iArr;
        int i;
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (!this.zzd || integer != 6) {
            i = integer;
            iArr = null;
        } else {
            int i2 = this.zzf;
            if (i2 < 6) {
                int[] iArr2 = new int[i2];
                for (int i3 = 0; i3 < this.zzf; i3++) {
                    iArr2[i3] = i3;
                }
                iArr = iArr2;
            } else {
                iArr = null;
            }
            i = 6;
        }
        try {
            this.zzc.zze(MimeTypes.AUDIO_RAW, i, integer2, this.zze, 0, iArr);
        } catch (zzaty e) {
            throw zzasi.zza(e, zza());
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzT(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzasi {
        if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.zza.zze++;
            this.zzc.zzf();
            return true;
        }
        try {
            if (!this.zzc.zzm(byteBuffer, j3)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i, false);
            this.zza.zzd++;
            return true;
        } catch (zzatz | zzaud e) {
            throw zzasi.zza(e, zza());
        }
    }

    public final zzbag zzi() {
        return this;
    }

    public final void zzl(int i, Object obj) throws zzasi {
        if (i == 2) {
            this.zzc.zzl(((Float) obj).floatValue());
        }
    }

    /* access modifiers changed from: protected */
    public final void zzn() {
        try {
            this.zzc.zzj();
            try {
                super.zzn();
            } finally {
                this.zza.zza();
                this.zzb.zze(this.zza);
            }
        } catch (Throwable th) {
            super.zzn();
            throw th;
        } finally {
            this.zza.zza();
            this.zzb.zze(this.zza);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzo(boolean z) throws zzasi {
        super.zzo(z);
        this.zzb.zzf(this.zza);
        int i = zzg().zzb;
    }

    /* access modifiers changed from: protected */
    public final void zzp(long j, boolean z) throws zzasi {
        super.zzp(j, z);
        this.zzc.zzk();
        this.zzg = j;
        this.zzh = true;
    }

    /* access modifiers changed from: protected */
    public final void zzq() {
        this.zzc.zzh();
    }

    /* access modifiers changed from: protected */
    public final void zzr() {
        this.zzc.zzg();
    }

    /* access modifiers changed from: protected */
    public final void zzS() throws zzasi {
        try {
            this.zzc.zzi();
        } catch (zzaud e) {
            throw zzasi.zza(e, zza());
        }
    }
}
