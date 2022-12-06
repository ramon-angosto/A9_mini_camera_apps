package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Parcelable.Creator<SignInResponse> {
    static void zza(SignInResponse signInResponse, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, signInResponse.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) signInResponse.zztR(), i, false);
        zzb.zza(parcel, 3, (Parcelable) signInResponse.zzIY(), i, false);
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzho */
    public SignInResponse createFromParcel(Parcel parcel) {
        int zzaq = zza.zzaq(parcel);
        ConnectionResult connectionResult = null;
        int i = 0;
        ResolveAccountResponse resolveAccountResponse = null;
        while (parcel.dataPosition() < zzaq) {
            int zzap = zza.zzap(parcel);
            int zzcj = zza.zzcj(zzap);
            if (zzcj == 1) {
                i = zza.zzg(parcel, zzap);
            } else if (zzcj == 2) {
                connectionResult = (ConnectionResult) zza.zza(parcel, zzap, ConnectionResult.CREATOR);
            } else if (zzcj != 3) {
                zza.zzb(parcel, zzap);
            } else {
                resolveAccountResponse = (ResolveAccountResponse) zza.zza(parcel, zzap, ResolveAccountResponse.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new SignInResponse(i, connectionResult, resolveAccountResponse);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaq);
        throw new zza.C0002zza(sb.toString(), parcel);
    }

    /* renamed from: zzkM */
    public SignInResponse[] newArray(int i) {
        return new SignInResponse[i];
    }
}
