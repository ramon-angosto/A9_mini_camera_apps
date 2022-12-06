package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfqk extends zzfrd {
    private int zza;
    private String zzb;
    private byte zzc;

    zzfqk() {
    }

    public final zzfrd zza(String str) {
        this.zzb = str;
        return this;
    }

    public final zzfrd zzb(int i) {
        this.zza = i;
        this.zzc = 1;
        return this;
    }

    public final zzfre zzc() {
        if (this.zzc == 1) {
            return new zzfqm(this.zza, this.zzb, (zzfql) null);
        }
        throw new IllegalStateException("Missing required properties: statusCode");
    }
}
