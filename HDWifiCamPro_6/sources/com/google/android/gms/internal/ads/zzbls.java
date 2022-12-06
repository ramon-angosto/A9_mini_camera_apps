package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.internal.client.zzff;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbls extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbls> CREATOR = new zzblt();
    public final int zza;
    public final boolean zzb;
    public final int zzc;
    public final boolean zzd;
    public final int zze;
    public final zzff zzf;
    public final boolean zzg;
    public final int zzh;

    public zzbls(int i, boolean z, int i2, boolean z2, int i3, zzff zzff, boolean z3, int i4) {
        this.zza = i;
        this.zzb = z;
        this.zzc = i2;
        this.zzd = z2;
        this.zze = i3;
        this.zzf = zzff;
        this.zzg = z3;
        this.zzh = i4;
    }

    public static NativeAdOptions zza(zzbls zzbls) {
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        if (zzbls == null) {
            return builder.build();
        }
        int i = zzbls.zza;
        if (i != 2) {
            if (i != 3) {
                if (i == 4) {
                    builder.setRequestCustomMuteThisAd(zzbls.zzg);
                    builder.setMediaAspectRatio(zzbls.zzh);
                }
                builder.setReturnUrlsForImageAssets(zzbls.zzb);
                builder.setRequestMultipleImages(zzbls.zzd);
                return builder.build();
            }
            zzff zzff = zzbls.zzf;
            if (zzff != null) {
                builder.setVideoOptions(new VideoOptions(zzff));
            }
        }
        builder.setAdChoicesPlacement(zzbls.zze);
        builder.setReturnUrlsForImageAssets(zzbls.zzb);
        builder.setRequestMultipleImages(zzbls.zzd);
        return builder.build();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzg);
        SafeParcelWriter.writeInt(parcel, 8, this.zzh);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzbls(com.google.android.gms.ads.formats.NativeAdOptions nativeAdOptions) {
        this(4, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzff(nativeAdOptions.getVideoOptions()) : null, nativeAdOptions.zza(), nativeAdOptions.getMediaAspectRatio());
    }
}
