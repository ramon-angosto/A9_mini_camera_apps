package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.meizu.cloud.pushsdk.constants.PushConstants;

public class zzf implements Parcelable.Creator<Status> {
    static void zza(Status status, Parcel parcel, int i) {
        int zzar = zzb.zzar(parcel);
        zzb.zzc(parcel, 1, status.getStatusCode());
        zzb.zza(parcel, 2, status.getStatusMessage(), false);
        zzb.zza(parcel, 3, (Parcelable) status.zzrx(), i, false);
        zzb.zzc(parcel, PushConstants.PUSHSERVICE_INFO_SENDMESSAGE_BY_NOTIFICATIONSERVICE, status.getVersionCode());
        zzb.zzJ(parcel, zzar);
    }

    /* renamed from: zzae */
    public Status createFromParcel(Parcel parcel) {
        int zzaq = zza.zzaq(parcel);
        int i = 0;
        String str = null;
        PendingIntent pendingIntent = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaq) {
            int zzap = zza.zzap(parcel);
            int zzcj = zza.zzcj(zzap);
            if (zzcj == 1) {
                i2 = zza.zzg(parcel, zzap);
            } else if (zzcj == 2) {
                str = zza.zzq(parcel, zzap);
            } else if (zzcj == 3) {
                pendingIntent = (PendingIntent) zza.zza(parcel, zzap, PendingIntent.CREATOR);
            } else if (zzcj != 1000) {
                zza.zzb(parcel, zzap);
            } else {
                i = zza.zzg(parcel, zzap);
            }
        }
        if (parcel.dataPosition() == zzaq) {
            return new Status(i, i2, str, pendingIntent);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(zzaq);
        throw new zza.C0002zza(sb.toString(), parcel);
    }

    /* renamed from: zzbF */
    public Status[] newArray(int i) {
        return new Status[i];
    }
}
