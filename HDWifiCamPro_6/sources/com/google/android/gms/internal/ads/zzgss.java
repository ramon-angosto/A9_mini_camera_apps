package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgss implements zzgth {
    private final zzgso zza;
    private final zzgty zzb;
    private final boolean zzc;
    private final zzgqr zzd;

    private zzgss(zzgty zzgty, zzgqr zzgqr, zzgso zzgso) {
        this.zzb = zzgty;
        this.zzc = zzgqr.zzh(zzgso);
        this.zzd = zzgqr;
        this.zza = zzgso;
    }

    static zzgss zzc(zzgty zzgty, zzgqr zzgqr, zzgso zzgso) {
        return new zzgss(zzgty, zzgqr, zzgso);
    }

    public final int zza(Object obj) {
        zzgty zzgty = this.zzb;
        int zzb2 = zzgty.zzb(zzgty.zzd(obj));
        if (!this.zzc) {
            return zzb2;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzd(obj).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final Object zze() {
        return this.zza.zzaM().zzao();
    }

    public final void zzf(Object obj) {
        this.zzb.zzm(obj);
        this.zzd.zze(obj);
    }

    public final void zzg(Object obj, Object obj2) {
        zzgtj.zzF(this.zzb, obj, obj2);
        if (this.zzc) {
            zzgtj.zzE(this.zzd, obj, obj2);
        }
    }

    public final void zzh(Object obj, zzgsz zzgsz, zzgqq zzgqq) throws IOException {
        boolean z;
        zzgty zzgty = this.zzb;
        zzgqr zzgqr = this.zzd;
        Object zzc2 = zzgty.zzc(obj);
        zzgqv zzb2 = zzgqr.zzb(obj);
        while (zzgsz.zzc() != Integer.MAX_VALUE) {
            int zzd2 = zzgsz.zzd();
            if (zzd2 != 11) {
                if ((zzd2 & 7) == 2) {
                    Object zzc3 = zzgqr.zzc(zzgqq, this.zza, zzd2 >>> 3);
                    if (zzc3 != null) {
                        zzgqr.zzf(zzgsz, zzc3, zzgqq, zzb2);
                    } else {
                        z = zzgty.zzp(zzc2, zzgsz);
                    }
                } else {
                    z = zzgsz.zzO();
                }
                if (!z) {
                    zzgty.zzn(obj, zzc2);
                    return;
                }
            } else {
                int i = 0;
                Object obj2 = null;
                zzgpw zzgpw = null;
                while (true) {
                    try {
                        if (zzgsz.zzc() == Integer.MAX_VALUE) {
                            break;
                        }
                        int zzd3 = zzgsz.zzd();
                        if (zzd3 == 16) {
                            i = zzgsz.zzj();
                            obj2 = zzgqr.zzc(zzgqq, this.zza, i);
                        } else if (zzd3 == 26) {
                            if (obj2 != null) {
                                zzgqr.zzf(zzgsz, obj2, zzgqq, zzb2);
                            } else {
                                zzgpw = zzgsz.zzp();
                            }
                        } else if (!zzgsz.zzO()) {
                            break;
                        }
                    } catch (Throwable th) {
                        zzgty.zzn(obj, zzc2);
                        throw th;
                    }
                }
                if (zzgsz.zzd() != 12) {
                    throw zzgrq.zzb();
                } else if (zzgpw != null) {
                    if (obj2 != null) {
                        zzgqr.zzg(zzgpw, obj2, zzgqq, zzb2);
                    } else {
                        zzgty.zzk(zzc2, i, zzgpw);
                    }
                }
            }
        }
        zzgty.zzn(obj, zzc2);
    }

    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzgpi zzgpi) throws IOException {
        zzgre zzgre = (zzgre) obj;
        if (zzgre.zzc == zzgtz.zzc()) {
            zzgre.zzc = zzgtz.zze();
        }
        zzgrb zzgrb = (zzgrb) obj;
        throw null;
    }

    public final boolean zzj(Object obj, Object obj2) {
        if (!this.zzb.zzd(obj).equals(this.zzb.zzd(obj2))) {
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

    public final void zzn(Object obj, zzgqm zzgqm) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }
}
