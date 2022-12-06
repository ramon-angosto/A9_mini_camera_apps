package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Parcelable.Creator<UserProfileChangeRequest> {
    static void zza(UserProfileChangeRequest userProfileChangeRequest, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, userProfileChangeRequest.mVersionCode);
        zzb.zza(parcel, 2, userProfileChangeRequest.getDisplayName(), false);
        zzb.zza(parcel, 3, userProfileChangeRequest.zzOo(), false);
        zzb.zza(parcel, 4, userProfileChangeRequest.zzOp());
        zzb.zza(parcel, 5, userProfileChangeRequest.zzOq());
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzjk */
    public UserProfileChangeRequest createFromParcel(Parcel parcel) {
        int zzaq = com.google.android.gms.common.internal.safeparcel.zza.zzaq(parcel);
        String str = null;
        String str2 = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < zzaq) {
            int zzap = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
            int zzcj = com.google.android.gms.common.internal.safeparcel.zza.zzcj(zzap);
            if (zzcj == 1) {
                i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzap);
            } else if (zzcj == 2) {
                str = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzap);
            } else if (zzcj == 3) {
                str2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzap);
            } else if (zzcj == 4) {
                z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzap);
            } else if (zzcj != 5) {
                com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzap);
            } else {
                z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzap);
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new UserProfileChangeRequest(i, str, str2, z, z2);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaq);
        throw new zza.C0002zza(sb.toString(), parcel);
    }

    /* renamed from: zznk */
    public UserProfileChangeRequest[] newArray(int i) {
        return new UserProfileChangeRequest[i];
    }
}
