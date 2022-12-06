package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Parcelable.Creator<Flag> {
    static void zza(Flag flag, Parcel parcel, int i) {
        int zzar = com.google.android.gms.common.internal.safeparcel.zzb.zzar(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, flag.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, flag.name, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, flag.zzbkF);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, flag.zzaTF);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, flag.zzaTH);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, flag.zzasH, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, flag.zzbkG, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 8, flag.zzbkH);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 9, flag.zzbkI);
        com.google.android.gms.common.internal.safeparcel.zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzgS */
    public Flag createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int zzaq = zza.zzaq(parcel);
        String str = null;
        String str2 = null;
        byte[] bArr = null;
        long j = 0;
        double d = 0.0d;
        int i = 0;
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaq) {
            int zzap = zza.zzap(parcel);
            switch (zza.zzcj(zzap)) {
                case 1:
                    i = zza.zzg(parcel2, zzap);
                    break;
                case 2:
                    str = zza.zzq(parcel2, zzap);
                    break;
                case 3:
                    j = zza.zzi(parcel2, zzap);
                    break;
                case 4:
                    z = zza.zzc(parcel2, zzap);
                    break;
                case 5:
                    d = zza.zzn(parcel2, zzap);
                    break;
                case 6:
                    str2 = zza.zzq(parcel2, zzap);
                    break;
                case 7:
                    bArr = zza.zzt(parcel2, zzap);
                    break;
                case 8:
                    i2 = zza.zzg(parcel2, zzap);
                    break;
                case 9:
                    i3 = zza.zzg(parcel2, zzap);
                    break;
                default:
                    zza.zzb(parcel2, zzap);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new Flag(i, str, j, z, d, str2, bArr, i2, i3);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaq);
        throw new zza.C0002zza(sb.toString(), parcel2);
    }

    /* renamed from: zzko */
    public Flag[] newArray(int i) {
        return new Flag[i];
    }
}
