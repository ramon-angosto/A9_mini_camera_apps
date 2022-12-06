package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Parcelable.Creator<AuthAccountRequest> {
    static void zza(AuthAccountRequest authAccountRequest, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, authAccountRequest.mVersionCode);
        zzb.zza(parcel, 2, authAccountRequest.zzaqo, false);
        zzb.zza(parcel, 3, (T[]) authAccountRequest.zzakD, i, false);
        zzb.zza(parcel, 4, authAccountRequest.zzaqp, false);
        zzb.zza(parcel, 5, authAccountRequest.zzaqq, false);
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzai */
    public AuthAccountRequest createFromParcel(Parcel parcel) {
        int zzaq = zza.zzaq(parcel);
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Integer num = null;
        Integer num2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzaq) {
            int zzap = zza.zzap(parcel);
            int zzcj = zza.zzcj(zzap);
            if (zzcj == 1) {
                i = zza.zzg(parcel, zzap);
            } else if (zzcj == 2) {
                iBinder = zza.zzr(parcel, zzap);
            } else if (zzcj == 3) {
                scopeArr = (Scope[]) zza.zzb(parcel, zzap, Scope.CREATOR);
            } else if (zzcj == 4) {
                num = zza.zzh(parcel, zzap);
            } else if (zzcj != 5) {
                zza.zzb(parcel, zzap);
            } else {
                num2 = zza.zzh(parcel, zzap);
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new AuthAccountRequest(i, iBinder, scopeArr, num, num2);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaq);
        throw new zza.C0002zza(sb.toString(), parcel);
    }

    /* renamed from: zzbY */
    public AuthAccountRequest[] newArray(int i) {
        return new AuthAccountRequest[i];
    }
}
