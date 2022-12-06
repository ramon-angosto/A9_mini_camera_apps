package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzgwt implements Iterator, Closeable, zzalr {
    private static final zzalq zza = new zzgws("eof ");
    private static final zzgxa zzb = zzgxa.zzb(zzgwt.class);
    protected zzaln zzc;
    protected zzgwu zzd;
    zzalq zze = null;
    long zzf = 0;
    long zzg = 0;
    private final List zzh = new ArrayList();

    public void close() throws IOException {
    }

    public final boolean hasNext() {
        zzalq zzalq = this.zze;
        if (zzalq == zza) {
            return false;
        }
        if (zzalq != null) {
            return true;
        }
        try {
            this.zze = next();
            return true;
        } catch (NoSuchElementException unused) {
            this.zze = zza;
            return false;
        }
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.zzh.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(((zzalq) this.zzh.get(i)).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: zzd */
    public final zzalq next() {
        zzalq zzb2;
        zzalq zzalq = this.zze;
        if (zzalq == null || zzalq == zza) {
            zzgwu zzgwu = this.zzd;
            if (zzgwu == null || this.zzf >= this.zzg) {
                this.zze = zza;
                throw new NoSuchElementException();
            }
            try {
                synchronized (zzgwu) {
                    this.zzd.zze(this.zzf);
                    zzb2 = this.zzc.zzb(this.zzd, this);
                    this.zzf = this.zzd.zzb();
                }
                return zzb2;
            } catch (EOFException unused) {
                throw new NoSuchElementException();
            } catch (IOException unused2) {
                throw new NoSuchElementException();
            }
        } else {
            this.zze = null;
            return zzalq;
        }
    }

    public final List zze() {
        return (this.zzd == null || this.zze == zza) ? this.zzh : new zzgwz(this.zzh, this);
    }

    public final void zzf(zzgwu zzgwu, long j, zzaln zzaln) throws IOException {
        this.zzd = zzgwu;
        this.zzf = zzgwu.zzb();
        zzgwu.zze(zzgwu.zzb() + j);
        this.zzg = zzgwu.zzb();
        this.zzc = zzaln;
    }
}
