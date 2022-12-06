package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzghd extends zzgfr {
    public zzghd() {
        super(zzgla.class, new zzghb(zzgbj.class));
    }

    public static final void zzh(zzgla zzgla) throws GeneralSecurityException {
        zzgoz.zzb(zzgla.zza(), 0);
        if (zzgla.zzh().zzd() >= 16) {
            zzn(zzgla.zzg());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    static /* bridge */ /* synthetic */ zzgfp zzm(int i, int i2, int i3, int i4) {
        zzglc zzc = zzgld.zzc();
        zzglf zzc2 = zzglg.zzc();
        zzc2.zzb(i3);
        zzc2.zza(i2);
        zzc.zzb((zzglg) zzc2.zzam());
        zzc.zza(i);
        return new zzgfp((zzgld) zzc.zzam(), i4);
    }

    /* access modifiers changed from: private */
    public static void zzn(zzglg zzglg) throws GeneralSecurityException {
        if (zzglg.zza() >= 10) {
            int zzg = zzglg.zzg() - 2;
            if (zzg != 1) {
                if (zzg != 2) {
                    if (zzg != 3) {
                        if (zzg != 4) {
                            if (zzg != 5) {
                                throw new GeneralSecurityException("unknown hash type");
                            } else if (zzglg.zza() > 28) {
                                throw new GeneralSecurityException("tag size too big");
                            }
                        } else if (zzglg.zza() > 64) {
                            throw new GeneralSecurityException("tag size too big");
                        }
                    } else if (zzglg.zza() > 32) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                } else if (zzglg.zza() > 48) {
                    throw new GeneralSecurityException("tag size too big");
                }
            } else if (zzglg.zza() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            throw new GeneralSecurityException("tag size too small");
        }
    }

    public final zzgfq zza() {
        return new zzghc(this, zzgld.class);
    }

    public final /* synthetic */ zzgso zzb(zzgpw zzgpw) throws zzgrq {
        return zzgla.zzf(zzgpw, zzgqq.zza());
    }

    public final String zzc() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgso zzgso) throws GeneralSecurityException {
        zzh((zzgla) zzgso);
    }

    public final int zze() {
        return 2;
    }

    public final int zzf() {
        return 3;
    }
}
