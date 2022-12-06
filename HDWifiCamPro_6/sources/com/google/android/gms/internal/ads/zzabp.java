package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzabp extends zzabu {
    private static final int[] zzb = {5512, 11025, 22050, 44100};
    private boolean zzc;
    private boolean zzd;
    private int zze;

    public zzabp(zzaap zzaap) {
        super(zzaap);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzef zzef) throws zzabt {
        if (!this.zzc) {
            int zzk = zzef.zzk();
            int i = zzk >> 4;
            this.zze = i;
            if (i == 2) {
                int i2 = zzb[(zzk >> 2) & 3];
                zzad zzad = new zzad();
                zzad.zzS(MimeTypes.AUDIO_MPEG);
                zzad.zzw(1);
                zzad.zzT(i2);
                this.zza.zzk(zzad.zzY());
                this.zzd = true;
            } else if (i == 7 || i == 8) {
                String str = i == 7 ? MimeTypes.AUDIO_ALAW : MimeTypes.AUDIO_MLAW;
                zzad zzad2 = new zzad();
                zzad2.zzS(str);
                zzad2.zzw(1);
                zzad2.zzT(8000);
                this.zza.zzk(zzad2.zzY());
                this.zzd = true;
            } else if (i != 10) {
                throw new zzabt("Audio format not supported: " + i);
            }
            this.zzc = true;
        } else {
            zzef.zzG(1);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean zzb(zzef zzef, long j) throws zzbu {
        if (this.zze == 2) {
            int zza = zzef.zza();
            this.zza.zzq(zzef, zza);
            this.zza.zzs(j, 1, zza, 0, (zzaao) null);
            return true;
        }
        int zzk = zzef.zzk();
        if (zzk == 0 && !this.zzd) {
            byte[] bArr = new byte[zzef.zza()];
            zzef.zzB(bArr, 0, bArr.length);
            zzyf zza2 = zzyg.zza(bArr);
            zzad zzad = new zzad();
            zzad.zzS(MimeTypes.AUDIO_AAC);
            zzad.zzx(zza2.zzc);
            zzad.zzw(zza2.zzb);
            zzad.zzT(zza2.zza);
            zzad.zzI(Collections.singletonList(bArr));
            this.zza.zzk(zzad.zzY());
            this.zzd = true;
            return false;
        } else if (this.zze == 10 && zzk != 1) {
            return false;
        } else {
            int zza3 = zzef.zza();
            this.zza.zzq(zzef, zza3);
            this.zza.zzs(j, 1, zza3, 0, (zzaao) null);
            return true;
        }
    }
}
