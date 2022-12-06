package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbay {
    public final List zza;
    public final int zzb;

    private zzbay(List list, int i) {
        this.zza = list;
        this.zzb = i;
    }

    public static zzbay zza(zzbak zzbak) throws zzasz {
        List list;
        try {
            zzbak.zzw(21);
            int zzg = zzbak.zzg() & 3;
            int zzg2 = zzbak.zzg();
            int zzc = zzbak.zzc();
            int i = 0;
            int i2 = 0;
            while (i < zzg2) {
                zzbak.zzw(1);
                int zzj = zzbak.zzj();
                int i3 = i2;
                for (int i4 = 0; i4 < zzj; i4++) {
                    int zzj2 = zzbak.zzj();
                    i3 += zzj2 + 4;
                    zzbak.zzw(zzj2);
                }
                i++;
                i2 = i3;
            }
            zzbak.zzv(zzc);
            byte[] bArr = new byte[i2];
            int i5 = 0;
            int i6 = 0;
            while (i5 < zzg2) {
                zzbak.zzw(1);
                int zzj3 = zzbak.zzj();
                int i7 = i6;
                for (int i8 = 0; i8 < zzj3; i8++) {
                    int zzj4 = zzbak.zzj();
                    System.arraycopy(zzbai.zza, 0, bArr, i7, 4);
                    int i9 = i7 + 4;
                    System.arraycopy(zzbak.zza, zzbak.zzc(), bArr, i9, zzj4);
                    i7 = i9 + zzj4;
                    zzbak.zzw(zzj4);
                }
                i5++;
                i6 = i7;
            }
            if (i2 == 0) {
                list = null;
            } else {
                list = Collections.singletonList(bArr);
            }
            return new zzbay(list, zzg + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzasz("Error parsing HEVC config", e);
        }
    }
}
