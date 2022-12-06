package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final /* synthetic */ class zzcgj implements zzcgn {
    public final /* synthetic */ int zza;
    public final /* synthetic */ Map zzb;

    public /* synthetic */ zzcgj(int i, Map map) {
        this.zza = i;
        this.zzb = map;
    }

    public final void zza(JsonWriter jsonWriter) {
        zzcgo.zzb(this.zza, this.zzb, jsonWriter);
    }
}
