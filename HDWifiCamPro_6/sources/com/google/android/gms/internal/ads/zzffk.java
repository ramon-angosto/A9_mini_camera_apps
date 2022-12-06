package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zze;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzffk implements zzddd {
    private final HashSet zza = new HashSet();
    private final Context zzb;
    private final zzcgc zzc;

    public zzffk(Context context, zzcgc zzcgc) {
        this.zzb = context;
        this.zzc = zzcgc;
    }

    public final synchronized void zza(zze zze) {
        if (zze.zza != 3) {
            this.zzc.zzi(this.zza);
        }
    }

    public final Bundle zzb() {
        return this.zzc.zzk(this.zzb, this);
    }

    public final synchronized void zzc(HashSet hashSet) {
        this.zza.clear();
        this.zza.addAll(hashSet);
    }
}
