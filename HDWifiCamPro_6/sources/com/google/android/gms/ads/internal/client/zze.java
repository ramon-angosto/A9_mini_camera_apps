package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zze extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zze> CREATOR = new zzf();
    public final int zza;
    public final String zzb;
    public final String zzc;
    public zze zzd;
    public IBinder zze;

    public zze(int i, String str, String str2, zze zze2, IBinder iBinder) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zze2;
        this.zze = iBinder;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeIBinder(parcel, 5, this.zze, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final AdError zza() {
        zze zze2 = this.zzd;
        return new AdError(this.zza, this.zzb, this.zzc, zze2 == null ? null : new AdError(zze2.zza, zze2.zzb, zze2.zzc));
    }

    public final LoadAdError zzb() {
        AdError adError;
        zze zze2 = this.zzd;
        zzdh zzdh = null;
        if (zze2 == null) {
            adError = null;
        } else {
            adError = new AdError(zze2.zza, zze2.zzb, zze2.zzc);
        }
        int i = this.zza;
        String str = this.zzb;
        String str2 = this.zzc;
        IBinder iBinder = this.zze;
        if (iBinder != null) {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
            zzdh = queryLocalInterface instanceof zzdh ? (zzdh) queryLocalInterface : new zzdf(iBinder);
        }
        return new LoadAdError(i, str, str2, adError, ResponseInfo.zza(zzdh));
    }
}
