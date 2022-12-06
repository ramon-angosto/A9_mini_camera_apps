package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zzby;
import com.google.android.gms.ads.internal.client.zzbz;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzbnu;
import com.google.android.gms.internal.ads.zzbnv;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class PublisherAdViewOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zzf();
    private final boolean zza;
    private final zzbz zzb;
    private final IBinder zzc;

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
    public static final class Builder {
        private ShouldDelayBannerRenderingListener zza;

        public Builder setShouldDelayBannerRenderingListener(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
            this.zza = shouldDelayBannerRenderingListener;
            return this;
        }
    }

    PublisherAdViewOptions(boolean z, IBinder iBinder, IBinder iBinder2) {
        this.zza = z;
        this.zzb = iBinder != null ? zzby.zzd(iBinder) : null;
        this.zzc = iBinder2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        IBinder iBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zza);
        zzbz zzbz = this.zzb;
        if (zzbz == null) {
            iBinder = null;
        } else {
            iBinder = zzbz.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 2, iBinder, false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzbz zza() {
        return this.zzb;
    }

    public final zzbnv zzb() {
        IBinder iBinder = this.zzc;
        if (iBinder == null) {
            return null;
        }
        return zzbnu.zzc(iBinder);
    }

    public final boolean zzc() {
        return this.zza;
    }
}
