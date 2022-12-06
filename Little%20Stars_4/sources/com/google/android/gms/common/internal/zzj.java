package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Parcelable.Creator<GetServiceRequest> {
    static void zza(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, getServiceRequest.version);
        zzb.zzc(parcel, 2, getServiceRequest.zzary);
        zzb.zzc(parcel, 3, getServiceRequest.zzarz);
        zzb.zza(parcel, 4, getServiceRequest.zzarA, false);
        zzb.zza(parcel, 5, getServiceRequest.zzarB, false);
        zzb.zza(parcel, 6, (T[]) getServiceRequest.zzarC, i, false);
        zzb.zza(parcel, 7, getServiceRequest.zzarD, false);
        zzb.zza(parcel, 8, (Parcelable) getServiceRequest.zzarE, i, false);
        zzb.zza(parcel, 9, getServiceRequest.zzarF);
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzak */
    public GetServiceRequest createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int zzaq = zza.zzaq(parcel);
        String str = null;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        long j = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaq) {
            int zzap = zza.zzap(parcel);
            switch (zza.zzcj(zzap)) {
                case 1:
                    i = zza.zzg(parcel2, zzap);
                    break;
                case 2:
                    i2 = zza.zzg(parcel2, zzap);
                    break;
                case 3:
                    i3 = zza.zzg(parcel2, zzap);
                    break;
                case 4:
                    str = zza.zzq(parcel2, zzap);
                    break;
                case 5:
                    iBinder = zza.zzr(parcel2, zzap);
                    break;
                case 6:
                    scopeArr = (Scope[]) zza.zzb(parcel2, zzap, Scope.CREATOR);
                    break;
                case 7:
                    bundle = zza.zzs(parcel2, zzap);
                    break;
                case 8:
                    account = (Account) zza.zza(parcel2, zzap, Account.CREATOR);
                    break;
                case 9:
                    j = zza.zzi(parcel2, zzap);
                    break;
                default:
                    zza.zzb(parcel2, zzap);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new GetServiceRequest(i, i2, i3, str, iBinder, scopeArr, bundle, account, j);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaq);
        throw new zza.C0002zza(sb.toString(), parcel2);
    }

    /* renamed from: zzcb */
    public GetServiceRequest[] newArray(int i) {
        return new GetServiceRequest[i];
    }
}
