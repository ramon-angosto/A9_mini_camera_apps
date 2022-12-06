package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfa {
    private Uri zza;
    private final int zzb = 1;
    private Map zzc = Collections.emptyMap();
    private long zzd;
    private int zze;

    public final zzfa zza(int i) {
        this.zze = 6;
        return this;
    }

    public final zzfa zzb(Map map) {
        this.zzc = map;
        return this;
    }

    public final zzfa zzc(long j) {
        this.zzd = j;
        return this;
    }

    public final zzfa zzd(Uri uri) {
        this.zza = uri;
        return this;
    }

    public final zzfc zze() {
        Uri uri = this.zza;
        if (uri != null) {
            return new zzfc(uri, 0, 1, (byte[]) null, this.zzc, this.zzd, -1, (String) null, this.zze, (Object) null, (zzfb) null);
        }
        throw new IllegalStateException("The uri must be set.");
    }
}
