package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaj {
    private String zza;
    private Uri zzb;
    private final zzal zzc = new zzal();
    private final zzar zzd = new zzar((zzaq) null);
    private final List zze = Collections.emptyList();
    private final zzfvn zzf = zzfvn.zzo();
    private final zzau zzg = new zzau();
    private final zzbd zzh = zzbd.zza;

    public final zzaj zza(String str) {
        this.zza = str;
        return this;
    }

    public final zzaj zzb(Uri uri) {
        this.zzb = uri;
        return this;
    }

    public final zzbg zzc() {
        Uri uri = this.zzb;
        zzba zzba = uri != null ? new zzba(uri, (String) null, (zzas) null, (zzai) null, this.zze, (String) null, this.zzf, (Object) null, (zzaz) null) : null;
        String str = this.zza;
        if (str == null) {
            str = "";
        }
        return new zzbg(str, new zzap(this.zzc, (zzao) null), zzba, new zzaw(this.zzg), zzbm.zza, this.zzh, (zzbf) null);
    }
}
