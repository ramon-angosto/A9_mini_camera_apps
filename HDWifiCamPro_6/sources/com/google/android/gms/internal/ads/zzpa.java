package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzpa extends zzqq implements zzji {
    private final Context zzb;
    /* access modifiers changed from: private */
    public final zznr zzc;
    private final zzny zzd;
    private int zze;
    private boolean zzf;
    private zzaf zzg;
    private long zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    /* access modifiers changed from: private */
    public zzjz zzl;

    public zzpa(Context context, zzqk zzqk, zzqs zzqs, boolean z, Handler handler, zzns zzns, zzny zzny) {
        super(1, zzqk, zzqs, false, 44100.0f);
        this.zzb = context.getApplicationContext();
        this.zzd = zzny;
        this.zzc = new zznr(handler, zzns);
        zzny.zzn(new zzoz(this, (zzoy) null));
    }

    private final int zzaw(zzqn zzqn, zzaf zzaf) {
        if (!"OMX.google.raw.decoder".equals(zzqn.zza) || zzen.zza >= 24 || (zzen.zza == 23 && zzen.zzX(this.zzb))) {
            return zzaf.zzn;
        }
        return -1;
    }

    private static List zzax(zzqs zzqs, zzaf zzaf, boolean z, zzny zzny) throws zzqz {
        zzqn zzd2;
        String str = zzaf.zzm;
        if (str == null) {
            return zzfvn.zzo();
        }
        if (zzny.zzv(zzaf) && (zzd2 = zzrf.zzd()) != null) {
            return zzfvn.zzp(zzd2);
        }
        List zzf2 = zzrf.zzf(str, false, false);
        String zze2 = zzrf.zze(zzaf);
        if (zze2 == null) {
            return zzfvn.zzm(zzf2);
        }
        List zzf3 = zzrf.zzf(zze2, false, false);
        zzfvk zzi2 = zzfvn.zzi();
        zzi2.zzf(zzf2);
        zzi2.zzf(zzf3);
        return zzi2.zzg();
    }

    private final void zzay() {
        long zzb2 = this.zzd.zzb(zzM());
        if (zzb2 != Long.MIN_VALUE) {
            if (!this.zzj) {
                zzb2 = Math.max(this.zzh, zzb2);
            }
            this.zzh = zzb2;
            this.zzj = false;
        }
    }

    public final String zzK() {
        return "MediaCodecAudioRenderer";
    }

    public final boolean zzM() {
        return super.zzM() && this.zzd.zzu();
    }

    public final boolean zzN() {
        return this.zzd.zzt() || super.zzN();
    }

    /* access modifiers changed from: protected */
    public final float zzP(float f, zzaf zzaf, zzaf[] zzafArr) {
        int i = -1;
        for (zzaf zzaf2 : zzafArr) {
            int i2 = zzaf2.zzA;
            if (i2 != -1) {
                i = Math.max(i, i2);
            }
        }
        if (i == -1) {
            return -1.0f;
        }
        return ((float) i) * f;
    }

    /* access modifiers changed from: protected */
    public final int zzQ(zzqs zzqs, zzaf zzaf) throws zzqz {
        boolean z;
        int i = 128;
        if (!zzbt.zzg(zzaf.zzm)) {
            return 128;
        }
        int i2 = zzen.zza >= 21 ? 32 : 0;
        int i3 = zzaf.zzF;
        boolean zzav = zzav(zzaf);
        if (zzav && this.zzd.zzv(zzaf) && (i3 == 0 || zzrf.zzd() != null)) {
            return i2 | IronSourceConstants.USING_CACHE_FOR_INIT_EVENT;
        }
        if ((MimeTypes.AUDIO_RAW.equals(zzaf.zzm) && !this.zzd.zzv(zzaf)) || !this.zzd.zzv(zzen.zzF(2, zzaf.zzz, zzaf.zzA))) {
            return TsExtractor.TS_STREAM_TYPE_AC3;
        }
        List zzax = zzax(zzqs, zzaf, false, this.zzd);
        if (zzax.isEmpty()) {
            return TsExtractor.TS_STREAM_TYPE_AC3;
        }
        if (!zzav) {
            return TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
        }
        zzqn zzqn = (zzqn) zzax.get(0);
        boolean zzd2 = zzqn.zzd(zzaf);
        if (!zzd2) {
            int i4 = 1;
            while (true) {
                if (i4 >= zzax.size()) {
                    break;
                }
                zzqn zzqn2 = (zzqn) zzax.get(i4);
                if (zzqn2.zzd(zzaf)) {
                    z = false;
                    zzd2 = true;
                    zzqn = zzqn2;
                    break;
                }
                i4++;
            }
        }
        z = true;
        int i5 = true != zzd2 ? 3 : 4;
        int i6 = 8;
        if (zzd2 && zzqn.zze(zzaf)) {
            i6 = 16;
        }
        int i7 = true != zzqn.zzg ? 0 : 64;
        if (true != z) {
            i = 0;
        }
        return i5 | i6 | i2 | i7 | i;
    }

    /* access modifiers changed from: protected */
    public final zzgt zzR(zzqn zzqn, zzaf zzaf, zzaf zzaf2) {
        int i;
        int i2;
        zzgt zzb2 = zzqn.zzb(zzaf, zzaf2);
        int i3 = zzb2.zze;
        if (zzaw(zzqn, zzaf2) > this.zze) {
            i3 |= 64;
        }
        String str = zzqn.zza;
        if (i3 != 0) {
            i2 = 0;
            i = i3;
        } else {
            i = 0;
            i2 = zzb2.zzd;
        }
        return new zzgt(str, zzaf, zzaf2, i2, i);
    }

    /* access modifiers changed from: protected */
    public final zzgt zzS(zzjg zzjg) throws zzha {
        zzgt zzS = super.zzS(zzjg);
        this.zzc.zzg(zzjg.zza, zzS);
        return zzS;
    }

    /* access modifiers changed from: protected */
    public final zzqj zzV(zzqn zzqn, zzaf zzaf, MediaCrypto mediaCrypto, float f) {
        zzaf[] zzJ = zzJ();
        int zzaw = zzaw(zzqn, zzaf);
        if (r1 != 1) {
            int i = zzaw;
            for (zzaf zzaf2 : zzJ) {
                if (zzqn.zzb(zzaf, zzaf2).zzd != 0) {
                    i = Math.max(i, zzaw(zzqn, zzaf2));
                }
            }
            zzaw = i;
        }
        this.zze = zzaw;
        this.zzf = zzen.zza < 24 && "OMX.SEC.aac.dec".equals(zzqn.zza) && "samsung".equals(zzen.zzc) && (zzen.zzb.startsWith("zeroflte") || zzen.zzb.startsWith("herolte") || zzen.zzb.startsWith("heroqlte"));
        String str = zzqn.zzc;
        int i2 = this.zze;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", zzaf.zzz);
        mediaFormat.setInteger("sample-rate", zzaf.zzA);
        zzdy.zzb(mediaFormat, zzaf.zzo);
        zzdy.zza(mediaFormat, "max-input-size", i2);
        if (zzen.zza >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f && (zzen.zza != 23 || (!"ZTE B2017G".equals(zzen.zzd) && !"AXON 7 mini".equals(zzen.zzd)))) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (zzen.zza <= 28 && "audio/ac4".equals(zzaf.zzm)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (zzen.zza >= 24 && this.zzd.zza(zzen.zzF(4, zzaf.zzz, zzaf.zzA)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (zzen.zza >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        this.zzg = (!MimeTypes.AUDIO_RAW.equals(zzqn.zzb) || MimeTypes.AUDIO_RAW.equals(zzaf.zzm)) ? null : zzaf;
        return zzqj.zza(zzqn, mediaFormat, zzaf, (MediaCrypto) null);
    }

    /* access modifiers changed from: protected */
    public final List zzW(zzqs zzqs, zzaf zzaf, boolean z) throws zzqz {
        return zzrf.zzg(zzax(zzqs, zzaf, false, this.zzd), zzaf);
    }

    /* access modifiers changed from: protected */
    public final void zzX(Exception exc) {
        zzdw.zzc("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.zzc.zza(exc);
    }

    /* access modifiers changed from: protected */
    public final void zzY(String str, zzqj zzqj, long j, long j2) {
        this.zzc.zzc(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public final void zzZ(String str) {
        this.zzc.zzd(str);
    }

    public final long zza() {
        if (zzbe() == 2) {
            zzay();
        }
        return this.zzh;
    }

    /* access modifiers changed from: protected */
    public final void zzab() {
        this.zzj = true;
    }

    /* access modifiers changed from: protected */
    public final void zzac() {
        this.zzd.zzf();
    }

    /* access modifiers changed from: protected */
    public final void zzad(zzgi zzgi) {
        if (this.zzi && !zzgi.zzf()) {
            if (Math.abs(zzgi.zzd - this.zzh) > 500000) {
                this.zzh = zzgi.zzd;
            }
            this.zzi = false;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzag(zzaf zzaf) {
        return this.zzd.zzv(zzaf);
    }

    public final zzby zzc() {
        return this.zzd.zzc();
    }

    public final void zzg(zzby zzby) {
        this.zzd.zzo(zzby);
    }

    public final zzji zzi() {
        return this;
    }

    public final void zzp(int i, Object obj) throws zzha {
        if (i == 2) {
            this.zzd.zzr(((Float) obj).floatValue());
        } else if (i == 3) {
            this.zzd.zzk((zzk) obj);
        } else if (i != 6) {
            switch (i) {
                case 9:
                    this.zzd.zzq(((Boolean) obj).booleanValue());
                    return;
                case 10:
                    this.zzd.zzl(((Integer) obj).intValue());
                    return;
                case 11:
                    this.zzl = (zzjz) obj;
                    return;
                default:
                    return;
            }
        } else {
            this.zzd.zzm((zzl) obj);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzs() {
        this.zzk = true;
        try {
            this.zzd.zze();
            try {
                super.zzs();
            } finally {
                this.zzc.zze(this.zza);
            }
        } catch (Throwable th) {
            super.zzs();
            throw th;
        } finally {
            this.zzc.zze(this.zza);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzt(boolean z, boolean z2) throws zzha {
        super.zzt(z, z2);
        this.zzc.zzf(this.zza);
        zzk();
        this.zzd.zzp(zzl());
    }

    /* access modifiers changed from: protected */
    public final void zzu(long j, boolean z) throws zzha {
        super.zzu(j, z);
        this.zzd.zze();
        this.zzh = j;
        this.zzi = true;
        this.zzj = true;
    }

    /* access modifiers changed from: protected */
    public final void zzv() {
        try {
            super.zzv();
            if (this.zzk) {
                this.zzk = false;
                this.zzd.zzj();
            }
        } catch (Throwable th) {
            if (this.zzk) {
                this.zzk = false;
                this.zzd.zzj();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzw() {
        this.zzd.zzh();
    }

    /* access modifiers changed from: protected */
    public final void zzx() {
        zzay();
        this.zzd.zzg();
    }

    /* access modifiers changed from: protected */
    public final void zzae() throws zzha {
        try {
            this.zzd.zzi();
        } catch (zznx e) {
            throw zzbg(e, e.zzc, e.zzb, IronSourceConstants.errorCode_isReadyException);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzaf(long j, long j2, zzql zzql, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzaf zzaf) throws zzha {
        if (byteBuffer == null) {
            throw null;
        } else if (this.zzg == null || (i2 & 2) == 0) {
            if (z) {
                if (zzql != null) {
                    zzql.zzn(i, false);
                }
                this.zza.zzf += i3;
                this.zzd.zzf();
                return true;
            }
            try {
                if (!this.zzd.zzs(byteBuffer, j3, i3)) {
                    return false;
                }
                if (zzql != null) {
                    zzql.zzn(i, false);
                }
                this.zza.zze += i3;
                return true;
            } catch (zznu e) {
                throw zzbg(e, e.zzc, e.zzb, IronSourceConstants.errorCode_biddingDataException);
            } catch (zznx e2) {
                throw zzbg(e2, zzaf, e2.zzb, IronSourceConstants.errorCode_isReadyException);
            }
        } else if (zzql != null) {
            zzql.zzn(i, false);
            return true;
        } else {
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzaa(zzaf zzaf, MediaFormat mediaFormat) throws zzha {
        zzaf zzaf2;
        int i;
        int i2;
        zzaf zzaf3 = this.zzg;
        int[] iArr = null;
        if (zzaf3 != null) {
            zzaf2 = zzaf3;
        } else if (zzaj() == null) {
            zzaf2 = zzaf;
        } else {
            if (MimeTypes.AUDIO_RAW.equals(zzaf.zzm)) {
                i = zzaf.zzB;
            } else if (zzen.zza < 24 || !mediaFormat.containsKey("pcm-encoding")) {
                i = mediaFormat.containsKey("v-bits-per-sample") ? zzen.zzn(mediaFormat.getInteger("v-bits-per-sample")) : 2;
            } else {
                i = mediaFormat.getInteger("pcm-encoding");
            }
            zzad zzad = new zzad();
            zzad.zzS(MimeTypes.AUDIO_RAW);
            zzad.zzN(i);
            zzad.zzC(zzaf.zzC);
            zzad.zzD(zzaf.zzD);
            zzad.zzw(mediaFormat.getInteger("channel-count"));
            zzad.zzT(mediaFormat.getInteger("sample-rate"));
            zzaf2 = zzad.zzY();
            if (this.zzf && zzaf2.zzz == 6 && (i2 = zzaf.zzz) < 6) {
                iArr = new int[i2];
                for (int i3 = 0; i3 < zzaf.zzz; i3++) {
                    iArr[i3] = i3;
                }
            }
        }
        try {
            this.zzd.zzd(zzaf2, 0, iArr);
        } catch (zznt e) {
            throw zzbg(e, e.zza, false, IronSourceConstants.errorCode_biddingDataException);
        }
    }
}
