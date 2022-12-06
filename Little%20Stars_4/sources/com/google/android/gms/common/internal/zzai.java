package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzai implements Parcelable.Creator<ValidateAccountRequest> {
    static void zza(ValidateAccountRequest validateAccountRequest, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, validateAccountRequest.mVersionCode);
        zzb.zzc(parcel, 2, validateAccountRequest.zztY());
        zzb.zza(parcel, 3, validateAccountRequest.zzaqo, false);
        zzb.zza(parcel, 4, (T[]) validateAccountRequest.zztW(), i, false);
        zzb.zza(parcel, 5, validateAccountRequest.zztZ(), false);
        zzb.zza(parcel, 6, validateAccountRequest.getCallingPackage(), false);
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzao */
    public ValidateAccountRequest createFromParcel(Parcel parcel) {
        int zzaq = zza.zzaq(parcel);
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        String str = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzaq) {
            int zzap = zza.zzap(parcel);
            switch (zza.zzcj(zzap)) {
                case 1:
                    i = zza.zzg(parcel, zzap);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzap);
                    break;
                case 3:
                    iBinder = zza.zzr(parcel, zzap);
                    break;
                case 4:
                    scopeArr = (Scope[]) zza.zzb(parcel, zzap, Scope.CREATOR);
                    break;
                case 5:
                    bundle = zza.zzs(parcel, zzap);
                    break;
                case 6:
                    str = zza.zzq(parcel, zzap);
                    break;
                default:
                    zza.zzb(parcel, zzap);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new ValidateAccountRequest(i, i2, iBinder, scopeArr, bundle, str);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaq);
        throw new zza.C0002zza(sb.toString(), parcel);
    }

    /* renamed from: zzci */
    public ValidateAccountRequest[] newArray(int i) {
        return new ValidateAccountRequest[i];
    }
}
