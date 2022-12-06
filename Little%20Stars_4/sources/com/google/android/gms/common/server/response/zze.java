package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Parcelable.Creator<SafeParcelResponse> {
    static void zza(SafeParcelResponse safeParcelResponse, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, safeParcelResponse.getVersionCode());
        zzb.zza(parcel, 2, safeParcelResponse.zzuv(), false);
        zzb.zza(parcel, 3, (Parcelable) safeParcelResponse.zzuw(), i, false);
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzaA */
    public SafeParcelResponse createFromParcel(Parcel parcel) {
        int zzaq = zza.zzaq(parcel);
        Parcel parcel2 = null;
        int i = 0;
        FieldMappingDictionary fieldMappingDictionary = null;
        while (parcel.dataPosition() < zzaq) {
            int zzap = zza.zzap(parcel);
            int zzcj = zza.zzcj(zzap);
            if (zzcj == 1) {
                i = zza.zzg(parcel, zzap);
            } else if (zzcj == 2) {
                parcel2 = zza.zzF(parcel, zzap);
            } else if (zzcj != 3) {
                zza.zzb(parcel, zzap);
            } else {
                fieldMappingDictionary = (FieldMappingDictionary) zza.zza(parcel, zzap, FieldMappingDictionary.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new SafeParcelResponse(i, parcel2, fieldMappingDictionary);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaq);
        throw new zza.C0002zza(sb.toString(), parcel);
    }

    /* renamed from: zzct */
    public SafeParcelResponse[] newArray(int i) {
        return new SafeParcelResponse[i];
    }
}
