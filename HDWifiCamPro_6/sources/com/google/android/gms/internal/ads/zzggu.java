package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzggu extends zzgfr {
    zzggu() {
        super(zzghx.class, new zzggs(zzgbj.class));
    }

    /* access modifiers changed from: private */
    public static void zzm(zzgid zzgid) throws GeneralSecurityException {
        if (zzgid.zza() < 10) {
            throw new GeneralSecurityException("tag size too short");
        } else if (zzgid.zza() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    /* access modifiers changed from: private */
    public static void zzn(int i) throws GeneralSecurityException {
        if (i != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }

    public final zzgfq zza() {
        return new zzggt(this, zzgia.class);
    }

    public final /* synthetic */ zzgso zzb(zzgpw zzgpw) throws zzgrq {
        return zzghx.zze(zzgpw, zzgqq.zza());
    }

    public final String zzc() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgso zzgso) throws GeneralSecurityException {
        zzghx zzghx = (zzghx) zzgso;
        zzgoz.zzb(zzghx.zza(), 0);
        zzn(zzghx.zzg().zzd());
        zzm(zzghx.zzf());
    }

    public final int zzf() {
        return 3;
    }
}
