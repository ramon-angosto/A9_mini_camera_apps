package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzfmj extends zzfmk {
    protected final HashSet zza;
    protected final JSONObject zzb;
    protected final long zzc;

    public zzfmj(zzfmc zzfmc, HashSet hashSet, JSONObject jSONObject, long j, byte[] bArr) {
        super(zzfmc, (byte[]) null);
        this.zza = new HashSet(hashSet);
        this.zzb = jSONObject;
        this.zzc = j;
    }
}
