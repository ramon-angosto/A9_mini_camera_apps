package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Parcelable.Creator<BitmapTeleporter> {
    static void zza(BitmapTeleporter bitmapTeleporter, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, bitmapTeleporter.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) bitmapTeleporter.zzMq, i, false);
        zzb.zzc(parcel, 3, bitmapTeleporter.zzagd);
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzaf */
    public BitmapTeleporter createFromParcel(Parcel parcel) {
        int zzaq = com.google.android.gms.common.internal.safeparcel.zza.zzaq(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaq) {
            int zzap = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
            int zzcj = com.google.android.gms.common.internal.safeparcel.zza.zzcj(zzap);
            if (zzcj == 1) {
                i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzap);
            } else if (zzcj == 2) {
                parcelFileDescriptor = (ParcelFileDescriptor) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzap, ParcelFileDescriptor.CREATOR);
            } else if (zzcj != 3) {
                com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzap);
            } else {
                i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzap);
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new BitmapTeleporter(i, parcelFileDescriptor, i2);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaq);
        throw new zza.C0002zza(sb.toString(), parcel);
    }

    /* renamed from: zzbM */
    public BitmapTeleporter[] newArray(int i) {
        return new BitmapTeleporter[i];
    }
}
