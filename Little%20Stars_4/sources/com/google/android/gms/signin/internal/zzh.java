package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Parcelable.Creator<SignInRequest> {
    static void zza(SignInRequest signInRequest, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, signInRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) signInRequest.zzIX(), i, false);
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzhn */
    public SignInRequest createFromParcel(Parcel parcel) {
        int zzaq = zza.zzaq(parcel);
        int i = 0;
        ResolveAccountRequest resolveAccountRequest = null;
        while (parcel.dataPosition() < zzaq) {
            int zzap = zza.zzap(parcel);
            int zzcj = zza.zzcj(zzap);
            if (zzcj == 1) {
                i = zza.zzg(parcel, zzap);
            } else if (zzcj != 2) {
                zza.zzb(parcel, zzap);
            } else {
                resolveAccountRequest = (ResolveAccountRequest) zza.zza(parcel, zzap, ResolveAccountRequest.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new SignInRequest(i, resolveAccountRequest);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaq);
        throw new zza.C0002zza(sb.toString(), parcel);
    }

    /* renamed from: zzkL */
    public SignInRequest[] newArray(int i) {
        return new SignInRequest[i];
    }
}
