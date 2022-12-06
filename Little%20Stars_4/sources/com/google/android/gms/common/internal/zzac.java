package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzac implements Parcelable.Creator<ResolveAccountResponse> {
    static void zza(ResolveAccountResponse resolveAccountResponse, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, resolveAccountResponse.mVersionCode);
        zzb.zza(parcel, 2, resolveAccountResponse.zzaqo, false);
        zzb.zza(parcel, 3, (Parcelable) resolveAccountResponse.zztR(), i, false);
        zzb.zza(parcel, 4, resolveAccountResponse.zztS());
        zzb.zza(parcel, 5, resolveAccountResponse.zztT());
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzam */
    public ResolveAccountResponse createFromParcel(Parcel parcel) {
        int zzaq = zza.zzaq(parcel);
        IBinder iBinder = null;
        ConnectionResult connectionResult = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < zzaq) {
            int zzap = zza.zzap(parcel);
            int zzcj = zza.zzcj(zzap);
            if (zzcj == 1) {
                i = zza.zzg(parcel, zzap);
            } else if (zzcj == 2) {
                iBinder = zza.zzr(parcel, zzap);
            } else if (zzcj == 3) {
                connectionResult = (ConnectionResult) zza.zza(parcel, zzap, ConnectionResult.CREATOR);
            } else if (zzcj == 4) {
                z = zza.zzc(parcel, zzap);
            } else if (zzcj != 5) {
                zza.zzb(parcel, zzap);
            } else {
                z2 = zza.zzc(parcel, zzap);
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new ResolveAccountResponse(i, iBinder, connectionResult, z, z2);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaq);
        throw new zza.C0002zza(sb.toString(), parcel);
    }

    /* renamed from: zzcg */
    public ResolveAccountResponse[] newArray(int i) {
        return new ResolveAccountResponse[i];
    }
}
