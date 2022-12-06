package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbb;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbuk {
    static final zzbb zza = new zzbui();
    static final zzbb zzb = new zzbuj();
    private final zzbtw zzc;

    public zzbuk(Context context, zzcgv zzcgv, String str, @Nullable zzfjw zzfjw) {
        this.zzc = new zzbtw(context, zzcgv, str, zza, zzb, zzfjw);
    }

    public final zzbua zza(String str, zzbud zzbud, zzbuc zzbuc) {
        return new zzbuo(this.zzc, str, zzbud, zzbuc);
    }

    public final zzbut zzb() {
        return new zzbut(this.zzc);
    }
}
