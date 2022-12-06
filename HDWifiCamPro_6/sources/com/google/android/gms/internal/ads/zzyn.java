package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzyn {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final float zze;
    public final String zzf;

    private zzyn(List list, int i, int i2, int i3, float f, String str) {
        this.zza = list;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = f;
        this.zzf = str;
    }

    public static zzyn zza(zzef zzef) throws zzbu {
        String str;
        float f;
        int i;
        int i2;
        try {
            zzef.zzG(4);
            int zzk = (zzef.zzk() & 3) + 1;
            if (zzk != 3) {
                ArrayList arrayList = new ArrayList();
                int zzk2 = zzef.zzk() & 31;
                for (int i3 = 0; i3 < zzk2; i3++) {
                    arrayList.add(zzb(zzef));
                }
                int zzk3 = zzef.zzk();
                for (int i4 = 0; i4 < zzk3; i4++) {
                    arrayList.add(zzb(zzef));
                }
                if (zzk2 > 0) {
                    zzaae zzd2 = zzaaf.zzd((byte[]) arrayList.get(0), zzk + 1, ((byte[]) arrayList.get(0)).length);
                    int i5 = zzd2.zze;
                    int i6 = zzd2.zzf;
                    float f2 = zzd2.zzg;
                    str = zzdf.zza(zzd2.zza, zzd2.zzb, zzd2.zzc);
                    i2 = i5;
                    i = i6;
                    f = f2;
                } else {
                    i2 = -1;
                    i = -1;
                    f = 1.0f;
                    str = null;
                }
                return new zzyn(arrayList, zzk, i2, i, f, str);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw zzbu.zza("Error parsing AVC config", e);
        }
    }

    private static byte[] zzb(zzef zzef) {
        int zzo = zzef.zzo();
        int zzc2 = zzef.zzc();
        zzef.zzG(zzo);
        return zzdf.zzc(zzef.zzH(), zzc2, zzo);
    }
}
