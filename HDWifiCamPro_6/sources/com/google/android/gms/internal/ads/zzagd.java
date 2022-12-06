package com.google.android.gms.internal.ads;

import java.util.Arrays;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzagd extends zzagn {
    private zzzv zza;
    private zzagc zzb;

    zzagd() {
    }

    private static boolean zzd(byte[] bArr) {
        return bArr[0] == -1;
    }

    /* access modifiers changed from: protected */
    public final long zza(zzef zzef) {
        if (!zzd(zzef.zzH())) {
            return -1;
        }
        int i = (zzef.zzH()[2] & UByte.MAX_VALUE) >> 4;
        if (i != 6) {
            if (i == 7) {
                i = 7;
            }
            int zza2 = zzzr.zza(zzef, i);
            zzef.zzF(0);
            return (long) zza2;
        }
        zzef.zzG(4);
        zzef.zzu();
        int zza22 = zzzr.zza(zzef, i);
        zzef.zzF(0);
        return (long) zza22;
    }

    /* access modifiers changed from: protected */
    public final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zza = null;
            this.zzb = null;
        }
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public final boolean zzc(zzef zzef, long j, zzagk zzagk) {
        byte[] zzH = zzef.zzH();
        zzzv zzzv = this.zza;
        if (zzzv == null) {
            zzzv zzzv2 = new zzzv(zzH, 17);
            this.zza = zzzv2;
            zzagk.zza = zzzv2.zzc(Arrays.copyOfRange(zzH, 9, zzef.zzd()), (zzbq) null);
            return true;
        } else if ((zzH[0] & ByteCompanionObject.MAX_VALUE) == 3) {
            zzzu zzb2 = zzzs.zzb(zzef);
            zzzv zzf = zzzv.zzf(zzb2);
            this.zza = zzf;
            this.zzb = new zzagc(zzf, zzb2);
            return true;
        } else if (!zzd(zzH)) {
            return true;
        } else {
            zzagc zzagc = this.zzb;
            if (zzagc != null) {
                zzagc.zza(j);
                zzagk.zzb = this.zzb;
            }
            if (zzagk.zza != null) {
                return false;
            }
            throw null;
        }
    }
}
