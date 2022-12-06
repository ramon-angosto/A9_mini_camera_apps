package com.google.android.gms.auth.api.signin.internal;

public class zze {
    static int zzacR = 31;
    private int zzacS = 1;

    public zze zzX(boolean z) {
        this.zzacS = (zzacR * this.zzacS) + (z ? 1 : 0);
        return this;
    }

    public int zzpv() {
        return this.zzacS;
    }

    public zze zzq(Object obj) {
        this.zzacS = (zzacR * this.zzacS) + (obj == null ? 0 : obj.hashCode());
        return this;
    }
}
