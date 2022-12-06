package com.google.android.gms.internal;

import com.google.android.gms.internal.zzamd;
import java.io.IOException;

public abstract class zzamd<M extends zzamd<M>> extends zzamj {
    protected zzamf zzcaa;

    public M clone() throws CloneNotSupportedException {
        M m = (zzamd) super.clone();
        zzamh.zza(this, (zzamd) m);
        return m;
    }

    public final <T> T getExtension(zzame<M, T> zzame) {
        zzamg zzok;
        zzamf zzamf = this.zzcaa;
        if (zzamf == null || (zzok = zzamf.zzok(zzamm.zzoo(zzame.tag))) == null) {
            return null;
        }
        return zzok.zza(zzame);
    }

    public final zzamf getUnknownFieldArray() {
        return this.zzcaa;
    }

    public final boolean hasExtension(zzame<M, ?> zzame) {
        zzamf zzamf = this.zzcaa;
        return (zzamf == null || zzamf.zzok(zzamm.zzoo(zzame.tag)) == null) ? false : true;
    }

    public final <T> M setExtension(zzame<M, T> zzame, T t) {
        int zzoo = zzamm.zzoo(zzame.tag);
        zzamg zzamg = null;
        if (t == null) {
            zzamf zzamf = this.zzcaa;
            if (zzamf != null) {
                zzamf.remove(zzoo);
                if (this.zzcaa.isEmpty()) {
                    this.zzcaa = null;
                }
            }
        } else {
            zzamf zzamf2 = this.zzcaa;
            if (zzamf2 == null) {
                this.zzcaa = new zzamf();
            } else {
                zzamg = zzamf2.zzok(zzoo);
            }
            if (zzamg == null) {
                this.zzcaa.zza(zzoo, new zzamg(zzame, t));
            } else {
                zzamg.zza(zzame, t);
            }
        }
        return this;
    }

    public void writeTo(zzamc zzamc) throws IOException {
        if (this.zzcaa != null) {
            for (int i = 0; i < this.zzcaa.size(); i++) {
                this.zzcaa.zzol(i).writeTo(zzamc);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzamb zzamb, int i) throws IOException {
        int position = zzamb.getPosition();
        if (!zzamb.zznU(i)) {
            return false;
        }
        int zzoo = zzamm.zzoo(i);
        zzaml zzaml = new zzaml(i, zzamb.zzD(position, zzamb.getPosition() - position));
        zzamg zzamg = null;
        zzamf zzamf = this.zzcaa;
        if (zzamf == null) {
            this.zzcaa = new zzamf();
        } else {
            zzamg = zzamf.zzok(zzoo);
        }
        if (zzamg == null) {
            zzamg = new zzamg();
            this.zzcaa.zza(zzoo, zzamg);
        }
        zzamg.zza(zzaml);
        return true;
    }

    /* access modifiers changed from: protected */
    public int zzy() {
        if (this.zzcaa == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zzcaa.size(); i2++) {
            i += this.zzcaa.zzol(i2).zzy();
        }
        return i;
    }
}
