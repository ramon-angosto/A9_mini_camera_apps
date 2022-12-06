package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgby {
    private static final Logger zza = Logger.getLogger(zzgby.class.getName());
    private static final AtomicReference zzb = new AtomicReference(new zzgbb());
    private static final ConcurrentMap zzc = new ConcurrentHashMap();
    private static final ConcurrentMap zzd = new ConcurrentHashMap();
    private static final ConcurrentMap zze = new ConcurrentHashMap();
    private static final ConcurrentMap zzf = new ConcurrentHashMap();
    private static final ConcurrentMap zzg = new ConcurrentHashMap();

    private zzgby() {
    }

    @Deprecated
    public static zzgan zza(String str) throws GeneralSecurityException {
        if (str != null) {
            zzgan zzgan = (zzgan) zze.get(str.toLowerCase(Locale.US));
            if (zzgan != null) {
                return zzgan;
            }
            String format = String.format("no catalogue found for %s. ", new Object[]{str});
            if (str.toLowerCase(Locale.US).startsWith("tinkaead")) {
                format = String.valueOf(format).concat("Maybe call AeadConfig.register().");
            }
            if (str.toLowerCase(Locale.US).startsWith("tinkdeterministicaead")) {
                format = String.valueOf(format).concat("Maybe call DeterministicAeadConfig.register().");
            } else if (str.toLowerCase(Locale.US).startsWith("tinkstreamingaead")) {
                format = String.valueOf(format).concat("Maybe call StreamingAeadConfig.register().");
            } else if (str.toLowerCase(Locale.US).startsWith("tinkhybriddecrypt") || str.toLowerCase(Locale.US).startsWith("tinkhybridencrypt")) {
                format = String.valueOf(format).concat("Maybe call HybridConfig.register().");
            } else if (str.toLowerCase(Locale.US).startsWith("tinkmac")) {
                format = String.valueOf(format).concat("Maybe call MacConfig.register().");
            } else if (str.toLowerCase(Locale.US).startsWith("tinkpublickeysign") || str.toLowerCase(Locale.US).startsWith("tinkpublickeyverify")) {
                format = String.valueOf(format).concat("Maybe call SignatureConfig.register().");
            } else if (str.toLowerCase(Locale.US).startsWith("tink")) {
                format = String.valueOf(format).concat("Maybe call TinkConfig.register().");
            }
            throw new GeneralSecurityException(format);
        }
        throw new IllegalArgumentException("catalogueName must be non-null.");
    }

    public static zzgau zzb(String str) throws GeneralSecurityException {
        return ((zzgbb) zzb.get()).zzb(str);
    }

    public static synchronized zzglx zzc(zzgmc zzgmc) throws GeneralSecurityException {
        zzglx zza2;
        synchronized (zzgby.class) {
            zzgau zzb2 = zzb(zzgmc.zzf());
            if (((Boolean) zzd.get(zzgmc.zzf())).booleanValue()) {
                zza2 = zzb2.zza(zzgmc.zze());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type ".concat(String.valueOf(zzgmc.zzf())));
            }
        }
        return zza2;
    }

    public static synchronized zzgso zzd(zzgmc zzgmc) throws GeneralSecurityException {
        zzgso zzb2;
        synchronized (zzgby.class) {
            zzgau zzb3 = zzb(zzgmc.zzf());
            if (((Boolean) zzd.get(zzgmc.zzf())).booleanValue()) {
                zzb2 = zzb3.zzb(zzgmc.zze());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type ".concat(String.valueOf(zzgmc.zzf())));
            }
        }
        return zzb2;
    }

    @Nullable
    public static Class zze(Class cls) {
        zzgbv zzgbv = (zzgbv) zzf.get(cls);
        if (zzgbv == null) {
            return null;
        }
        return zzgbv.zza();
    }

    public static Object zzf(zzglx zzglx, Class cls) throws GeneralSecurityException {
        return zzg(zzglx.zzf(), zzglx.zze(), cls);
    }

    public static Object zzg(String str, zzgpw zzgpw, Class cls) throws GeneralSecurityException {
        return ((zzgbb) zzb.get()).zza(str, cls).zzd(zzgpw);
    }

    public static Object zzh(String str, zzgso zzgso, Class cls) throws GeneralSecurityException {
        return ((zzgbb) zzb.get()).zza(str, cls).zze(zzgso);
    }

    public static Object zzi(String str, byte[] bArr, Class cls) throws GeneralSecurityException {
        return zzg(str, zzgpw.zzv(bArr), cls);
    }

    public static Object zzj(zzgbu zzgbu, Class cls) throws GeneralSecurityException {
        zzgbv zzgbv = (zzgbv) zzf.get(cls);
        if (zzgbv == null) {
            throw new GeneralSecurityException("No wrapper found for ".concat(String.valueOf(zzgbu.zzc().getName())));
        } else if (zzgbv.zza().equals(zzgbu.zzc())) {
            return zzgbv.zzc(zzgbu);
        } else {
            String obj = zzgbv.zza().toString();
            String obj2 = zzgbu.zzc().toString();
            throw new GeneralSecurityException("Wrong input primitive class, expected " + obj + ", got " + obj2);
        }
    }

    static synchronized Map zzk() {
        Map unmodifiableMap;
        synchronized (zzgby.class) {
            unmodifiableMap = Collections.unmodifiableMap(zzg);
        }
        return unmodifiableMap;
    }

    public static synchronized void zzl(zzggg zzggg, zzgfr zzgfr, boolean z) throws GeneralSecurityException {
        synchronized (zzgby.class) {
            zzgbb zzgbb = new zzgbb((zzgbb) zzb.get());
            zzgbb.zzc(zzggg, zzgfr);
            String zzc2 = zzggg.zzc();
            String zzc3 = zzgfr.zzc();
            zzp(zzc2, zzggg.zza().zzc(), true);
            zzp(zzc3, Collections.emptyMap(), false);
            if (!((zzgbb) zzb.get()).zzf(zzc2)) {
                zzc.put(zzc2, new zzgbx(zzggg));
                zzq(zzggg.zzc(), zzggg.zza().zzc());
            }
            zzd.put(zzc2, true);
            zzd.put(zzc3, false);
            zzb.set(zzgbb);
        }
    }

    public static synchronized void zzn(zzgfr zzgfr, boolean z) throws GeneralSecurityException {
        synchronized (zzgby.class) {
            zzgbb zzgbb = new zzgbb((zzgbb) zzb.get());
            zzgbb.zze(zzgfr);
            String zzc2 = zzgfr.zzc();
            zzp(zzc2, zzgfr.zza().zzc(), true);
            if (!((zzgbb) zzb.get()).zzf(zzc2)) {
                zzc.put(zzc2, new zzgbx(zzgfr));
                zzq(zzc2, zzgfr.zza().zzc());
            }
            zzd.put(zzc2, true);
            zzb.set(zzgbb);
        }
    }

    public static synchronized void zzo(zzgbv zzgbv) throws GeneralSecurityException {
        synchronized (zzgby.class) {
            if (zzgbv != null) {
                Class zzb2 = zzgbv.zzb();
                if (zzf.containsKey(zzb2)) {
                    zzgbv zzgbv2 = (zzgbv) zzf.get(zzb2);
                    if (!zzgbv.getClass().getName().equals(zzgbv2.getClass().getName())) {
                        zza.logp(Level.WARNING, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", "Attempted overwrite of a registered PrimitiveWrapper for type ".concat(zzb2.toString()));
                        throw new GeneralSecurityException(String.format("PrimitiveWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", new Object[]{zzb2.getName(), zzgbv2.getClass().getName(), zzgbv.getClass().getName()}));
                    }
                }
                zzf.put(zzb2, zzgbv);
            } else {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
        }
    }

    private static synchronized void zzp(String str, Map map, boolean z) throws GeneralSecurityException {
        synchronized (zzgby.class) {
            if (z) {
                if (zzd.containsKey(str)) {
                    if (!((Boolean) zzd.get(str)).booleanValue()) {
                        throw new GeneralSecurityException("New keys are already disallowed for key type ".concat(str));
                    }
                }
                if (((zzgbb) zzb.get()).zzf(str)) {
                    for (Map.Entry entry : map.entrySet()) {
                        if (!zzg.containsKey(entry.getKey())) {
                            throw new GeneralSecurityException("Attempted to register a new key template " + ((String) entry.getKey()) + " from an existing key manager of type " + str);
                        }
                    }
                } else {
                    for (Map.Entry entry2 : map.entrySet()) {
                        if (zzg.containsKey(entry2.getKey())) {
                            throw new GeneralSecurityException("Attempted overwrite of a registered key template ".concat(String.valueOf((String) entry2.getKey())));
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [com.google.android.gms.internal.ads.zzgso, java.lang.Object] */
    private static void zzq(String str, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            zzg.put((String) entry.getKey(), zzgbd.zze(str, ((zzgfp) entry.getValue()).zza.zzax(), ((zzgfp) entry.getValue()).zzb));
        }
    }

    public static synchronized void zzm(zzgau zzgau, boolean z) throws GeneralSecurityException {
        synchronized (zzgby.class) {
            if (zzgau != null) {
                try {
                    zzgbb zzgbb = new zzgbb((zzgbb) zzb.get());
                    zzgbb.zzd(zzgau);
                    if (zzgds.zza(1)) {
                        String zzf2 = zzgau.zzf();
                        zzp(zzf2, Collections.emptyMap(), z);
                        zzd.put(zzf2, Boolean.valueOf(z));
                        zzb.set(zzgbb);
                    } else {
                        throw new GeneralSecurityException("Registering key managers is not supported in FIPS mode");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
        }
    }
}
