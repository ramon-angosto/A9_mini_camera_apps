package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzetb implements zzevd {
    public final zzfdj zza;

    public zzetb(zzfdj zzfdj) {
        this.zza = zzfdj;
    }

    public final /* bridge */ /* synthetic */ void zzf(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzfdj zzfdj = this.zza;
        if (zzfdj != null) {
            bundle.putBoolean("render_in_browser", zzfdj.zzd());
            bundle.putBoolean("disable_ml", this.zza.zzc());
        }
    }
}
