package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgec extends zzggg {
    /* access modifiers changed from: private */
    public static final byte[] zza = new byte[0];

    zzgec() {
        super(zzgkn.class, zzgkq.class, new zzgea(zzgar.class));
    }

    static /* bridge */ /* synthetic */ zzgfp zzh(int i, int i2, int i3, zzgbd zzgbd, byte[] bArr, int i4) {
        zzgkg zza2 = zzgkh.zza();
        zzgks zza3 = zzgkt.zza();
        int i5 = 4;
        zza3.zzb(4);
        zza3.zzc(5);
        zza3.zza(zzgpw.zzv(bArr));
        zzgkt zzgkt = (zzgkt) zza3.zzam();
        zzgmb zza4 = zzgmc.zza();
        zza4.zza(zzgbd.zzb());
        zza4.zzb(zzgpw.zzv(zzgbd.zzc()));
        int zzd = zzgbd.zzd() - 1;
        if (zzd == 0) {
            i5 = 3;
        } else if (zzd != 1) {
            i5 = zzd != 2 ? 6 : 5;
        }
        zza4.zzc(i5);
        zzgkd zza5 = zzgke.zza();
        zza5.zza((zzgmc) zza4.zzam());
        zzgkj zzc = zzgkk.zzc();
        zzc.zzb(zzgkt);
        zzc.zza((zzgke) zza5.zzam());
        zzc.zzc(i3);
        zza2.zza((zzgkk) zzc.zzam());
        return new zzgfp((zzgkh) zza2.zzam(), i4);
    }

    public final zzgfq zza() {
        return new zzgeb(this, zzgkh.class);
    }

    public final /* synthetic */ zzgso zzb(zzgpw zzgpw) throws zzgrq {
        return zzgkn.zze(zzgpw, zzgqq.zza());
    }

    public final String zzc() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgso zzgso) throws GeneralSecurityException {
        zzgkn zzgkn = (zzgkn) zzgso;
        if (!zzgkn.zzg().zzD()) {
            zzgoz.zzb(zzgkn.zza(), 0);
            zzgel.zza(zzgkn.zzf().zzc());
            return;
        }
        throw new GeneralSecurityException("invalid ECIES private key");
    }

    public final int zzf() {
        return 4;
    }
}
