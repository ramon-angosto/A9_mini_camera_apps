package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Parcelable.Creator<Configuration> {
    static void zza(Configuration configuration, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, configuration.mVersionCode);
        zzb.zzc(parcel, 2, configuration.zzbkB);
        zzb.zza(parcel, 3, (T[]) configuration.zzbkC, i, false);
        zzb.zza(parcel, 4, configuration.zzbkD, false);
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzgR */
    public Configuration createFromParcel(Parcel parcel) {
        int zzaq = com.google.android.gms.common.internal.safeparcel.zza.zzaq(parcel);
        int i = 0;
        Flag[] flagArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaq) {
            int zzap = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
            int zzcj = com.google.android.gms.common.internal.safeparcel.zza.zzcj(zzap);
            if (zzcj == 1) {
                i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzap);
            } else if (zzcj == 2) {
                i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzap);
            } else if (zzcj == 3) {
                flagArr = (Flag[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzap, Flag.CREATOR);
            } else if (zzcj != 4) {
                com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzap);
            } else {
                strArr = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, zzap);
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new Configuration(i, i2, flagArr, strArr);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaq);
        throw new zza.C0002zza(sb.toString(), parcel);
    }

    /* renamed from: zzkn */
    public Configuration[] newArray(int i) {
        return new Configuration[i];
    }
}
