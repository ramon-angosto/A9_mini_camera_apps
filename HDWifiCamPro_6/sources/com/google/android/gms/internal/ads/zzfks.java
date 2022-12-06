package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfks {
    private final zzfkz zza;
    private final zzfkz zzb;
    private final zzfkw zzc;
    private final zzfky zzd;

    private zzfks(zzfkw zzfkw, zzfky zzfky, zzfkz zzfkz, zzfkz zzfkz2, boolean z) {
        this.zzc = zzfkw;
        this.zzd = zzfky;
        this.zza = zzfkz;
        if (zzfkz2 == null) {
            this.zzb = zzfkz.NONE;
        } else {
            this.zzb = zzfkz2;
        }
    }

    public static zzfks zza(zzfkw zzfkw, zzfky zzfky, zzfkz zzfkz, zzfkz zzfkz2, boolean z) {
        zzfly.zzb(zzfky, "ImpressionType is null");
        zzfly.zzb(zzfkz, "Impression owner is null");
        if (zzfkz == zzfkz.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        } else if (zzfkw == zzfkw.DEFINED_BY_JAVASCRIPT && zzfkz == zzfkz.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        } else if (zzfky != zzfky.DEFINED_BY_JAVASCRIPT || zzfkz != zzfkz.NATIVE) {
            return new zzfks(zzfkw, zzfky, zzfkz, zzfkz2, true);
        } else {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
    }

    public final JSONObject zzb() {
        JSONObject jSONObject = new JSONObject();
        zzflw.zzh(jSONObject, "impressionOwner", this.zza);
        zzflw.zzh(jSONObject, "mediaEventsOwner", this.zzb);
        zzflw.zzh(jSONObject, "creativeType", this.zzc);
        zzflw.zzh(jSONObject, "impressionType", this.zzd);
        zzflw.zzh(jSONObject, "isolateVerificationScripts", true);
        return jSONObject;
    }
}
