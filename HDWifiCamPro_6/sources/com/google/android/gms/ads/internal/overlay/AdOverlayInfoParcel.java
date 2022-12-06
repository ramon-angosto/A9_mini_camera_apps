package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzbop;
import com.google.android.gms.internal.ads.zzbor;
import com.google.android.gms.internal.ads.zzcgv;
import com.google.android.gms.internal.ads.zzcmp;
import com.google.android.gms.internal.ads.zzddn;
import com.google.android.gms.internal.ads.zzdkn;
import com.google.android.gms.internal.ads.zzdxq;
import com.google.android.gms.internal.ads.zzego;
import com.google.android.gms.internal.ads.zzfir;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzn();
    public final zzc zza;
    public final zza zzb;
    public final zzo zzc;
    public final zzcmp zzd;
    public final zzbor zze;
    public final String zzf;
    public final boolean zzg;
    public final String zzh;
    public final zzz zzi;
    public final int zzj;
    public final int zzk;
    public final String zzl;
    public final zzcgv zzm;
    public final String zzn;
    public final zzj zzo;
    public final zzbop zzp;
    public final String zzq;
    public final zzego zzr;
    public final zzdxq zzs;
    public final zzfir zzt;
    public final zzbr zzu;
    public final String zzv;
    public final String zzw;
    public final zzddn zzx;
    public final zzdkn zzy;

    public AdOverlayInfoParcel(zza zza2, zzo zzo2, zzbop zzbop, zzbor zzbor, zzz zzz, zzcmp zzcmp, boolean z, int i, String str, zzcgv zzcgv, zzdkn zzdkn) {
        this.zza = null;
        this.zzb = zza2;
        this.zzc = zzo2;
        this.zzd = zzcmp;
        this.zzp = zzbop;
        this.zze = zzbor;
        this.zzf = null;
        this.zzg = z;
        this.zzh = null;
        this.zzi = zzz;
        this.zzj = i;
        this.zzk = 3;
        this.zzl = str;
        this.zzm = zzcgv;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = null;
        this.zzx = null;
        this.zzy = zzdkn;
    }

    public static AdOverlayInfoParcel zza(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception unused) {
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zza, i, false);
        SafeParcelWriter.writeIBinder(parcel, 3, ObjectWrapper.wrap(this.zzb).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 4, ObjectWrapper.wrap(this.zzc).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 5, ObjectWrapper.wrap(this.zzd).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 6, ObjectWrapper.wrap(this.zze).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzg);
        SafeParcelWriter.writeString(parcel, 9, this.zzh, false);
        SafeParcelWriter.writeIBinder(parcel, 10, ObjectWrapper.wrap(this.zzi).asBinder(), false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzj);
        SafeParcelWriter.writeInt(parcel, 12, this.zzk);
        SafeParcelWriter.writeString(parcel, 13, this.zzl, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzm, i, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzn, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.zzo, i, false);
        SafeParcelWriter.writeIBinder(parcel, 18, ObjectWrapper.wrap(this.zzp).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 19, this.zzq, false);
        SafeParcelWriter.writeIBinder(parcel, 20, ObjectWrapper.wrap(this.zzr).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 21, ObjectWrapper.wrap(this.zzs).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 22, ObjectWrapper.wrap(this.zzt).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 23, ObjectWrapper.wrap(this.zzu).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 24, this.zzv, false);
        SafeParcelWriter.writeString(parcel, 25, this.zzw, false);
        SafeParcelWriter.writeIBinder(parcel, 26, ObjectWrapper.wrap(this.zzx).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 27, ObjectWrapper.wrap(this.zzy).asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public AdOverlayInfoParcel(zza zza2, zzo zzo2, zzbop zzbop, zzbor zzbor, zzz zzz, zzcmp zzcmp, boolean z, int i, String str, String str2, zzcgv zzcgv, zzdkn zzdkn) {
        this.zza = null;
        this.zzb = zza2;
        this.zzc = zzo2;
        this.zzd = zzcmp;
        this.zzp = zzbop;
        this.zze = zzbor;
        this.zzf = str2;
        this.zzg = z;
        this.zzh = str;
        this.zzi = zzz;
        this.zzj = i;
        this.zzk = 3;
        this.zzl = null;
        this.zzm = zzcgv;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = null;
        this.zzx = null;
        this.zzy = zzdkn;
    }

    public AdOverlayInfoParcel(zza zza2, zzo zzo2, zzz zzz, zzcmp zzcmp, int i, zzcgv zzcgv, String str, zzj zzj2, String str2, String str3, String str4, zzddn zzddn) {
        this.zza = null;
        this.zzb = null;
        this.zzc = zzo2;
        this.zzd = zzcmp;
        this.zzp = null;
        this.zze = null;
        this.zzg = false;
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzaC)).booleanValue()) {
            this.zzf = null;
            this.zzh = null;
        } else {
            this.zzf = str2;
            this.zzh = str3;
        }
        this.zzi = null;
        this.zzj = i;
        this.zzk = 1;
        this.zzl = null;
        this.zzm = zzcgv;
        this.zzn = str;
        this.zzo = zzj2;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = str4;
        this.zzx = zzddn;
        this.zzy = null;
    }

    public AdOverlayInfoParcel(zza zza2, zzo zzo2, zzz zzz, zzcmp zzcmp, boolean z, int i, zzcgv zzcgv, zzdkn zzdkn) {
        this.zza = null;
        this.zzb = zza2;
        this.zzc = zzo2;
        this.zzd = zzcmp;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = z;
        this.zzh = null;
        this.zzi = zzz;
        this.zzj = i;
        this.zzk = 2;
        this.zzl = null;
        this.zzm = zzcgv;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = null;
        this.zzx = null;
        this.zzy = zzdkn;
    }

    AdOverlayInfoParcel(zzc zzc2, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i, int i2, String str3, zzcgv zzcgv, String str4, zzj zzj2, IBinder iBinder6, String str5, IBinder iBinder7, IBinder iBinder8, IBinder iBinder9, IBinder iBinder10, String str6, String str7, IBinder iBinder11, IBinder iBinder12) {
        this.zza = zzc2;
        this.zzb = (zza) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zzc = (zzo) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder2));
        this.zzd = (zzcmp) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder3));
        this.zzp = (zzbop) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder6));
        this.zze = (zzbor) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder4));
        this.zzf = str;
        this.zzg = z;
        this.zzh = str2;
        this.zzi = (zzz) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder5));
        this.zzj = i;
        this.zzk = i2;
        this.zzl = str3;
        this.zzm = zzcgv;
        this.zzn = str4;
        this.zzo = zzj2;
        this.zzq = str5;
        this.zzv = str6;
        this.zzr = (zzego) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder7));
        this.zzs = (zzdxq) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder8));
        this.zzt = (zzfir) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder9));
        this.zzu = (zzbr) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder10));
        this.zzw = str7;
        this.zzx = (zzddn) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder11));
        this.zzy = (zzdkn) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder12));
    }

    public AdOverlayInfoParcel(zzc zzc2, zza zza2, zzo zzo2, zzz zzz, zzcgv zzcgv, zzcmp zzcmp, zzdkn zzdkn) {
        this.zza = zzc2;
        this.zzb = zza2;
        this.zzc = zzo2;
        this.zzd = zzcmp;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = zzz;
        this.zzj = -1;
        this.zzk = 4;
        this.zzl = null;
        this.zzm = zzcgv;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = null;
        this.zzx = null;
        this.zzy = zzdkn;
    }

    public AdOverlayInfoParcel(zzo zzo2, zzcmp zzcmp, int i, zzcgv zzcgv) {
        this.zzc = zzo2;
        this.zzd = zzcmp;
        this.zzj = 1;
        this.zzm = zzcgv;
        this.zza = null;
        this.zzb = null;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = null;
        this.zzk = 1;
        this.zzl = null;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzv = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzw = null;
        this.zzx = null;
        this.zzy = null;
    }

    public AdOverlayInfoParcel(zzcmp zzcmp, zzcgv zzcgv, zzbr zzbr, zzego zzego, zzdxq zzdxq, zzfir zzfir, String str, String str2, int i) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzcmp;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = null;
        this.zzj = 14;
        this.zzk = 5;
        this.zzl = null;
        this.zzm = zzcgv;
        this.zzn = null;
        this.zzo = null;
        this.zzq = str;
        this.zzv = str2;
        this.zzr = zzego;
        this.zzs = zzdxq;
        this.zzt = zzfir;
        this.zzu = zzbr;
        this.zzw = null;
        this.zzx = null;
        this.zzy = null;
    }
}
