package com.google.android.gms.internal.ads;

import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgog {
    public static final zzgog zza = new zzgog(new zzgoh());
    public static final zzgog zzb = new zzgog(new zzgol());
    public static final zzgog zzc = new zzgog(new zzgon());
    public static final zzgog zzd = new zzgog(new zzgom());
    public static final zzgog zze = new zzgog(new zzgoi());
    public static final zzgog zzf = new zzgog(new zzgok());
    public static final zzgog zzg = new zzgog(new zzgoj());
    private static final Logger zzh = Logger.getLogger(zzgog.class.getName());
    private static final List zzi;
    private static final boolean zzj;
    private final zzgoo zzk;

    static {
        if (zzgdt.zzb()) {
            zzi = zzb(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL", "Conscrypt");
            zzj = false;
        } else if (zzgoy.zzb()) {
            zzi = zzb(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL");
            zzj = true;
        } else {
            zzi = new ArrayList();
            zzj = true;
        }
    }

    public zzgog(zzgoo zzgoo) {
        this.zzk = zzgoo;
    }

    public static List zzb(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            } else {
                zzh.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", new Object[]{str}));
            }
        }
        return arrayList;
    }

    public final Object zza(String str) throws GeneralSecurityException {
        Exception exc = null;
        for (Provider zza2 : zzi) {
            try {
                return this.zzk.zza(str, zza2);
            } catch (Exception e) {
                if (exc == null) {
                    exc = e;
                }
            }
        }
        if (zzj) {
            return this.zzk.zza(str, (Provider) null);
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }
}
