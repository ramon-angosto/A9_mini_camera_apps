package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Parcelable.Creator<RemoteMessage> {
    static void zza(RemoteMessage remoteMessage, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, remoteMessage.mVersionCode);
        zzb.zza(parcel, 2, remoteMessage.zzaay, false);
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzjy */
    public RemoteMessage createFromParcel(Parcel parcel) {
        int zzaq = zza.zzaq(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < zzaq) {
            int zzap = zza.zzap(parcel);
            int zzcj = zza.zzcj(zzap);
            if (zzcj == 1) {
                i = zza.zzg(parcel, zzap);
            } else if (zzcj != 2) {
                zza.zzb(parcel, zzap);
            } else {
                bundle = zza.zzs(parcel, zzap);
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new RemoteMessage(i, bundle);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaq);
        throw new zza.C0002zza(sb.toString(), parcel);
    }

    /* renamed from: zznI */
    public RemoteMessage[] newArray(int i) {
        return new RemoteMessage[i];
    }
}
