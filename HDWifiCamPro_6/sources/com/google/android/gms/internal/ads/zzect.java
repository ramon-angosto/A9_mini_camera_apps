package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.util.zzay;
import com.google.android.gms.ads.internal.util.zzaz;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzect extends zzcax {
    final /* synthetic */ zzecu zza;

    protected zzect(zzecu zzecu) {
        this.zza = zzecu;
    }

    public final void zze(zzaz zzaz) {
        this.zza.zza.zze(new zzay(zzaz.zza, zzaz.zzb));
    }

    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zza.zzd(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
    }
}
