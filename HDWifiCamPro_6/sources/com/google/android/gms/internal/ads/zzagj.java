package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.List;
import kotlin.UByte;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzagj extends zzagn {
    private static final byte[] zza = {79, 112, 117, 115, 72, 101, 97, 100};
    private static final byte[] zzb = {79, 112, 117, 115, 84, 97, 103, 115};
    private boolean zzc;

    zzagj() {
    }

    public static boolean zzd(zzef zzef) {
        return zzk(zzef, zza);
    }

    private static boolean zzk(zzef zzef, byte[] bArr) {
        if (zzef.zza() < 8) {
            return false;
        }
        int zzc2 = zzef.zzc();
        byte[] bArr2 = new byte[8];
        zzef.zzB(bArr2, 0, 8);
        zzef.zzF(zzc2);
        return Arrays.equals(bArr2, bArr);
    }

    /* access modifiers changed from: protected */
    public final long zza(zzef zzef) {
        byte[] zzH = zzef.zzH();
        byte b = zzH[0] & UByte.MAX_VALUE;
        byte b2 = b & 3;
        byte b3 = 2;
        if (b2 == 0) {
            b3 = 1;
        } else if (!(b2 == 1 || b2 == 2)) {
            b3 = zzH[1] & 63;
        }
        int i = b >> 3;
        int i2 = i & 3;
        return zzg(((long) b3) * ((long) (i >= 16 ? 2500 << i2 : i >= 12 ? 10000 << (i2 & 1) : i2 == 3 ? 60000 : 10000 << i2)));
    }

    /* access modifiers changed from: protected */
    public final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zzc = false;
        }
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public final boolean zzc(zzef zzef, long j, zzagk zzagk) throws zzbu {
        if (zzk(zzef, zza)) {
            byte[] copyOf = Arrays.copyOf(zzef.zzH(), zzef.zzd());
            byte b = copyOf[9] & UByte.MAX_VALUE;
            List zza2 = zzaag.zza(copyOf);
            if (zzagk.zza != null) {
                return true;
            }
            zzad zzad = new zzad();
            zzad.zzS(MimeTypes.AUDIO_OPUS);
            zzad.zzw(b);
            zzad.zzT(48000);
            zzad.zzI(zza2);
            zzagk.zza = zzad.zzY();
            return true;
        } else if (zzk(zzef, zzb)) {
            zzdd.zzb(zzagk.zza);
            if (this.zzc) {
                return true;
            }
            this.zzc = true;
            zzef.zzG(8);
            zzbq zzb2 = zzaav.zzb(zzfvn.zzn(zzaav.zzc(zzef, false, false).zzb));
            if (zzb2 == null) {
                return true;
            }
            zzad zzb3 = zzagk.zza.zzb();
            zzb3.zzM(zzb2.zzd(zzagk.zza.zzk));
            zzagk.zza = zzb3.zzY();
            return true;
        } else {
            zzdd.zzb(zzagk.zza);
            return false;
        }
    }
}
