package com.google.android.gms.auth.api.signin.internal;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public class HashAccumulator {
    static int zaa = 31;
    private int zab = 1;

    public HashAccumulator addObject(Object obj) {
        this.zab = (zaa * this.zab) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    public int hash() {
        return this.zab;
    }

    public final HashAccumulator zaa(boolean z) {
        this.zab = (zaa * this.zab) + (z ? 1 : 0);
        return this;
    }
}
