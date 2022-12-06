package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
final class zzln implements zzlu {
    private final zzlj zza;
    private final zzml zzb;
    private final boolean zzc;
    private final zzjp zzd;

    private zzln(zzml zzml, zzjp zzjp, zzlj zzlj) {
        this.zzb = zzml;
        this.zzc = zzjp.zzc(zzlj);
        this.zzd = zzjp;
        this.zza = zzlj;
    }

    static zzln zzc(zzml zzml, zzjp zzjp, zzlj zzlj) {
        return new zzln(zzml, zzjp, zzlj);
    }

    public final int zza(Object obj) {
        zzml zzml = this.zzb;
        int zzb2 = zzml.zzb(zzml.zzc(obj));
        if (!this.zzc) {
            return zzb2;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzc(obj).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final Object zze() {
        return this.zza.zzbI().zzaG();
    }

    public final void zzf(Object obj) {
        this.zzb.zzg(obj);
        this.zzd.zzb(obj);
    }

    public final void zzg(Object obj, Object obj2) {
        zzlw.zzF(this.zzb, obj, obj2);
        if (this.zzc) {
            zzlw.zzE(this.zzd, obj, obj2);
        }
    }

    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzio zzio) throws IOException {
        zzkc zzkc = (zzkc) obj;
        if (zzkc.zzc == zzmm.zzc()) {
            zzkc.zzc = zzmm.zze();
        }
        zzjz zzjz = (zzjz) obj;
        throw null;
    }

    public final void zzi(Object obj, zznd zznd) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }

    public final boolean zzj(Object obj, Object obj2) {
        if (!this.zzb.zzc(obj).equals(this.zzb.zzc(obj2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(obj);
        this.zzd.zza(obj2);
        throw null;
    }

    public final boolean zzk(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }
}
