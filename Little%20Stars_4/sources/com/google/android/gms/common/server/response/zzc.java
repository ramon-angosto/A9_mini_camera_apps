package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.server.response.FieldMappingDictionary;
import java.util.ArrayList;

public class zzc implements Parcelable.Creator<FieldMappingDictionary> {
    static void zza(FieldMappingDictionary fieldMappingDictionary, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, fieldMappingDictionary.getVersionCode());
        zzb.zzc(parcel, 2, fieldMappingDictionary.zzus(), false);
        zzb.zza(parcel, 3, fieldMappingDictionary.zzut(), false);
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzay */
    public FieldMappingDictionary createFromParcel(Parcel parcel) {
        int zzaq = zza.zzaq(parcel);
        ArrayList arrayList = null;
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzaq) {
            int zzap = zza.zzap(parcel);
            int zzcj = zza.zzcj(zzap);
            if (zzcj == 1) {
                i = zza.zzg(parcel, zzap);
            } else if (zzcj == 2) {
                arrayList = zza.zzc(parcel, zzap, FieldMappingDictionary.Entry.CREATOR);
            } else if (zzcj != 3) {
                zza.zzb(parcel, zzap);
            } else {
                str = zza.zzq(parcel, zzap);
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new FieldMappingDictionary(i, arrayList, str);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaq);
        throw new zza.C0002zza(sb.toString(), parcel);
    }

    /* renamed from: zzcr */
    public FieldMappingDictionary[] newArray(int i) {
        return new FieldMappingDictionary[i];
    }
}
