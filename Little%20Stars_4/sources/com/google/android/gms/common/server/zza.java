package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Parcelable.Creator<FavaDiagnosticsEntity> {
    static void zza(FavaDiagnosticsEntity favaDiagnosticsEntity, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, favaDiagnosticsEntity.mVersionCode);
        zzb.zza(parcel, 2, favaDiagnosticsEntity.zzasB, false);
        zzb.zzc(parcel, 3, favaDiagnosticsEntity.zzasC);
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzas */
    public FavaDiagnosticsEntity createFromParcel(Parcel parcel) {
        int zzaq = com.google.android.gms.common.internal.safeparcel.zza.zzaq(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaq) {
            int zzap = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
            int zzcj = com.google.android.gms.common.internal.safeparcel.zza.zzcj(zzap);
            if (zzcj == 1) {
                i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzap);
            } else if (zzcj == 2) {
                str = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzap);
            } else if (zzcj != 3) {
                com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzap);
            } else {
                i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzap);
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new FavaDiagnosticsEntity(i, str, i2);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaq);
        throw new zza.C0002zza(sb.toString(), parcel);
    }

    /* renamed from: zzcl */
    public FavaDiagnosticsEntity[] newArray(int i) {
        return new FavaDiagnosticsEntity[i];
    }
}
