package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzakc extends zzakf implements Iterable<zzakf> {
    private final List<zzakf> zzbyn = new ArrayList();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof zzakc) && ((zzakc) obj).zzbyn.equals(this.zzbyn));
    }

    public int hashCode() {
        return this.zzbyn.hashCode();
    }

    public Iterator<zzakf> iterator() {
        return this.zzbyn.iterator();
    }

    public String zzVA() {
        if (this.zzbyn.size() == 1) {
            return this.zzbyn.get(0).zzVA();
        }
        throw new IllegalStateException();
    }

    public double zzVB() {
        if (this.zzbyn.size() == 1) {
            return this.zzbyn.get(0).zzVB();
        }
        throw new IllegalStateException();
    }

    public long zzVC() {
        if (this.zzbyn.size() == 1) {
            return this.zzbyn.get(0).zzVC();
        }
        throw new IllegalStateException();
    }

    public int zzVD() {
        if (this.zzbyn.size() == 1) {
            return this.zzbyn.get(0).zzVD();
        }
        throw new IllegalStateException();
    }

    public boolean zzVE() {
        if (this.zzbyn.size() == 1) {
            return this.zzbyn.get(0).zzVE();
        }
        throw new IllegalStateException();
    }

    public Number zzVz() {
        if (this.zzbyn.size() == 1) {
            return this.zzbyn.get(0).zzVz();
        }
        throw new IllegalStateException();
    }

    public void zzc(zzakf zzakf) {
        if (zzakf == null) {
            zzakf = zzakh.zzbWr;
        }
        this.zzbyn.add(zzakf);
    }
}
