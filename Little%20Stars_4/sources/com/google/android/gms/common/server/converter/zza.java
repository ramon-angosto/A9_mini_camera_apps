package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Parcelable.Creator<ConverterWrapper> {
    static void zza(ConverterWrapper converterWrapper, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, converterWrapper.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) converterWrapper.zzua(), i, false);
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzat */
    public ConverterWrapper createFromParcel(Parcel parcel) {
        int zzaq = com.google.android.gms.common.internal.safeparcel.zza.zzaq(parcel);
        int i = 0;
        StringToIntConverter stringToIntConverter = null;
        while (parcel.dataPosition() < zzaq) {
            int zzap = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
            int zzcj = com.google.android.gms.common.internal.safeparcel.zza.zzcj(zzap);
            if (zzcj == 1) {
                i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzap);
            } else if (zzcj != 2) {
                com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzap);
            } else {
                stringToIntConverter = (StringToIntConverter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzap, StringToIntConverter.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new ConverterWrapper(i, stringToIntConverter);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaq);
        throw new zza.C0002zza(sb.toString(), parcel);
    }

    /* renamed from: zzcm */
    public ConverterWrapper[] newArray(int i) {
        return new ConverterWrapper[i];
    }
}
