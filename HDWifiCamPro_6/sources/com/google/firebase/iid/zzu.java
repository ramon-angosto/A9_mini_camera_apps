package com.google.firebase.iid;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class zzu implements InstanceIdResult {
    private final String zza;
    private final String zzb;

    zzu(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final String getId() {
        return this.zza;
    }

    public final String getToken() {
        return this.zzb;
    }
}
