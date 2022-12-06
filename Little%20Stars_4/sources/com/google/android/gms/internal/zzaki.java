package com.google.android.gms.internal;

import java.util.Map;
import java.util.Set;

public final class zzaki extends zzakf {
    private final zzald<String, zzakf> zzbWs = new zzald<>();

    public Set<Map.Entry<String, zzakf>> entrySet() {
        return this.zzbWs.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof zzaki) && ((zzaki) obj).zzbWs.equals(this.zzbWs));
    }

    public boolean has(String str) {
        return this.zzbWs.containsKey(str);
    }

    public int hashCode() {
        return this.zzbWs.hashCode();
    }

    public void zza(String str, zzakf zzakf) {
        if (zzakf == null) {
            zzakf = zzakh.zzbWr;
        }
        this.zzbWs.put(str, zzakf);
    }

    public zzakf zziQ(String str) {
        return this.zzbWs.get(str);
    }
}
