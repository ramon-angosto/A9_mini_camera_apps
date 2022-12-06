package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgbb {
    private static final Logger zza = Logger.getLogger(zzgbb.class.getName());
    private final ConcurrentMap zzb;

    zzgbb() {
        this.zzb = new ConcurrentHashMap();
    }

    private final synchronized zzgba zzg(String str) throws GeneralSecurityException {
        if (this.zzb.containsKey(str)) {
        } else {
            throw new GeneralSecurityException("No key manager found for key type ".concat(String.valueOf(str)));
        }
        return (zzgba) this.zzb.get(str);
    }

    private final synchronized void zzh(zzgba zzgba, boolean z) throws GeneralSecurityException {
        String zzf = zzgba.zzb().zzf();
        zzgba zzgba2 = (zzgba) this.zzb.get(zzf);
        if (zzgba2 != null) {
            if (!zzgba2.zzc().equals(zzgba.zzc())) {
                zza.logp(Level.WARNING, "com.google.crypto.tink.KeyManagerRegistry", "registerKeyManagerContainer", "Attempted overwrite of a registered key manager for key type ".concat(zzf));
                throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", new Object[]{zzf, zzgba2.zzc().getName(), zzgba.zzc().getName()}));
            }
        }
        if (!z) {
            this.zzb.putIfAbsent(zzf, zzgba);
        } else {
            this.zzb.put(zzf, zzgba);
        }
    }

    /* access modifiers changed from: package-private */
    public final zzgau zza(String str, Class cls) throws GeneralSecurityException {
        zzgba zzg = zzg(str);
        if (zzg.zze().contains(cls)) {
            return zzg.zza(cls);
        }
        String name = cls.getName();
        String valueOf = String.valueOf(zzg.zzc());
        Set<Class> zze = zzg.zze();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class cls2 : zze) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(cls2.getCanonicalName());
            z = false;
        }
        String sb2 = sb.toString();
        throw new GeneralSecurityException("Primitive type " + name + " not supported by key manager of type " + valueOf + ", supported primitives: " + sb2);
    }

    /* access modifiers changed from: package-private */
    public final zzgau zzb(String str) throws GeneralSecurityException {
        return zzg(str).zzb();
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzc(zzggg zzggg, zzgfr zzgfr) throws GeneralSecurityException {
        Class zzd;
        int zze = zzgfr.zze();
        if (!zzgds.zza(1)) {
            String valueOf = String.valueOf(zzggg.getClass());
            throw new GeneralSecurityException("failed to register key manager " + valueOf + " as it is not FIPS compatible.");
        } else if (zzgds.zza(zze)) {
            String zzc = zzggg.zzc();
            String zzc2 = zzgfr.zzc();
            if (!(!this.zzb.containsKey(zzc) || ((zzgba) this.zzb.get(zzc)).zzd() == null || (zzd = ((zzgba) this.zzb.get(zzc)).zzd()) == null)) {
                if (!zzd.getName().equals(zzgfr.getClass().getName())) {
                    Logger logger = zza;
                    Level level = Level.WARNING;
                    logger.logp(level, "com.google.crypto.tink.KeyManagerRegistry", "registerAsymmetricKeyManagers", "Attempted overwrite of a registered key manager for key type " + zzc + " with inconsistent public key type " + zzc2);
                    throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", new Object[]{zzggg.getClass().getName(), zzd.getName(), zzgfr.getClass().getName()}));
                }
            }
            zzh(new zzgaz(zzggg, zzgfr), true);
            zzh(new zzgay(zzgfr), false);
        } else {
            String valueOf2 = String.valueOf(zzgfr.getClass());
            throw new GeneralSecurityException("failed to register key manager " + valueOf2 + " as it is not FIPS compatible.");
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzd(zzgau zzgau) throws GeneralSecurityException {
        if (zzgds.zza(1)) {
            zzh(new zzgax(zzgau), false);
        } else {
            throw new GeneralSecurityException("Registering key managers is not supported in FIPS mode");
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zze(zzgfr zzgfr) throws GeneralSecurityException {
        if (zzgds.zza(zzgfr.zze())) {
            zzh(new zzgay(zzgfr), false);
        } else {
            String valueOf = String.valueOf(zzgfr.getClass());
            throw new GeneralSecurityException("failed to register key manager " + valueOf + " as it is not FIPS compatible.");
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf(String str) {
        return this.zzb.containsKey(str);
    }

    zzgbb(zzgbb zzgbb) {
        this.zzb = new ConcurrentHashMap(zzgbb.zzb);
    }
}
