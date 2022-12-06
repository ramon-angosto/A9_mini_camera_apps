package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgbi {
    private static final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public static zzgbh zza(String str) throws GeneralSecurityException {
        Iterator it = zza.iterator();
        while (it.hasNext()) {
            zzgbh zzgbh = (zzgbh) it.next();
            if (zzgbh.zza()) {
                return zzgbh;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: ".concat(String.valueOf(str)));
    }
}
