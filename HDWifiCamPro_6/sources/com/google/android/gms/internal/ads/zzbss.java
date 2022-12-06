package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;
import com.google.android.gms.ads.internal.util.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzbss implements zzcob {
    public final /* synthetic */ zzbtf zza;

    public /* synthetic */ zzbss(zzbtf zzbtf, byte[] bArr) {
        this.zza = zzbtf;
    }

    public final void zza() {
        zzbtf zzbtf = this.zza;
        zzs.zza.postDelayed(new zzbte(zzbtf.zza, zzbtf.zzb, zzbtf.zzc), WorkRequest.MIN_BACKOFF_MILLIS);
    }
}
