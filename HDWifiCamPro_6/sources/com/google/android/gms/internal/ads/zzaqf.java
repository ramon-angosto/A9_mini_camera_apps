package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaqf {
    static zzgas zza;

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        if (r0 != null) goto L_0x0035;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean zza(com.google.android.gms.internal.ads.zzaqe r6) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            com.google.android.gms.internal.ads.zzgas r0 = zza
            r1 = 1
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzcv
            com.google.android.gms.internal.ads.zzbja r2 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r0 = r2.zzb(r0)
            java.lang.String r0 = (java.lang.String) r0
            r2 = 0
            if (r0 == 0) goto L_0x001b
            int r3 = r0.length()
            if (r3 != 0) goto L_0x0035
        L_0x001b:
            r0 = 0
            if (r6 != 0) goto L_0x001f
            goto L_0x0033
        L_0x001f:
            java.lang.String r3 = "hwvIMOeohSBrCWT4pVkQok22g/l0cZbbqOTmNbjObWwcwhLlaFMNibQmd2cIB1Vb"
            java.lang.String r4 = "24f7+wNdQe8HQwz0gPH2QIzxUp8iQNA20yBU7Dg74Sc="
            java.lang.reflect.Method r6 = r6.zzj(r3, r4)
            if (r6 != 0) goto L_0x002a
            goto L_0x0033
        L_0x002a:
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.Object r6 = r6.invoke(r0, r3)
            java.lang.String r6 = (java.lang.String) r6
            r0 = r6
        L_0x0033:
            if (r0 == 0) goto L_0x0119
        L_0x0035:
            byte[] r6 = com.google.android.gms.internal.ads.zzanp.zzb(r0, r1)     // Catch:{ IllegalArgumentException -> 0x0119 }
            com.google.android.gms.internal.ads.zzgbf r6 = com.google.android.gms.internal.ads.zzgbk.zza(r6)     // Catch:{  }
            com.google.android.gms.internal.ads.zzgng r0 = com.google.android.gms.internal.ads.zzgef.zza     // Catch:{  }
            java.util.List r0 = r0.zzd()     // Catch:{  }
            java.util.Iterator r0 = r0.iterator()     // Catch:{  }
        L_0x0047:
            boolean r3 = r0.hasNext()     // Catch:{  }
            if (r3 == 0) goto L_0x010e
            java.lang.Object r3 = r0.next()     // Catch:{  }
            com.google.android.gms.internal.ads.zzgmf r3 = (com.google.android.gms.internal.ads.zzgmf) r3     // Catch:{  }
            java.lang.String r4 = r3.zzf()     // Catch:{  }
            boolean r4 = r4.isEmpty()     // Catch:{  }
            if (r4 != 0) goto L_0x0106
            java.lang.String r4 = r3.zze()     // Catch:{  }
            boolean r4 = r4.isEmpty()     // Catch:{  }
            if (r4 != 0) goto L_0x00fe
            java.lang.String r4 = r3.zzd()     // Catch:{  }
            boolean r4 = r4.isEmpty()     // Catch:{  }
            if (r4 != 0) goto L_0x00f6
            java.lang.String r4 = r3.zzd()     // Catch:{  }
            java.lang.String r5 = "TinkAead"
            boolean r4 = r4.equals(r5)     // Catch:{  }
            if (r4 != 0) goto L_0x0047
            java.lang.String r4 = r3.zzd()     // Catch:{  }
            java.lang.String r5 = "TinkMac"
            boolean r4 = r4.equals(r5)     // Catch:{  }
            if (r4 != 0) goto L_0x0047
            java.lang.String r4 = r3.zzd()     // Catch:{  }
            java.lang.String r5 = "TinkHybridDecrypt"
            boolean r4 = r4.equals(r5)     // Catch:{  }
            if (r4 != 0) goto L_0x0047
            java.lang.String r4 = r3.zzd()     // Catch:{  }
            java.lang.String r5 = "TinkHybridEncrypt"
            boolean r4 = r4.equals(r5)     // Catch:{  }
            if (r4 != 0) goto L_0x0047
            java.lang.String r4 = r3.zzd()     // Catch:{  }
            java.lang.String r5 = "TinkPublicKeySign"
            boolean r4 = r4.equals(r5)     // Catch:{  }
            if (r4 != 0) goto L_0x0047
            java.lang.String r4 = r3.zzd()     // Catch:{  }
            java.lang.String r5 = "TinkPublicKeyVerify"
            boolean r4 = r4.equals(r5)     // Catch:{  }
            if (r4 != 0) goto L_0x0047
            java.lang.String r4 = r3.zzd()     // Catch:{  }
            java.lang.String r5 = "TinkStreamingAead"
            boolean r4 = r4.equals(r5)     // Catch:{  }
            if (r4 != 0) goto L_0x0047
            java.lang.String r4 = r3.zzd()     // Catch:{  }
            java.lang.String r5 = "TinkDeterministicAead"
            boolean r4 = r4.equals(r5)     // Catch:{  }
            if (r4 != 0) goto L_0x0047
            java.lang.String r4 = r3.zzd()     // Catch:{  }
            com.google.android.gms.internal.ads.zzgan r4 = com.google.android.gms.internal.ads.zzgby.zza(r4)     // Catch:{  }
            com.google.android.gms.internal.ads.zzgbv r5 = r4.zza()     // Catch:{  }
            com.google.android.gms.internal.ads.zzgby.zzo(r5)     // Catch:{  }
            r3.zzf()     // Catch:{  }
            r3.zze()     // Catch:{  }
            r3.zza()     // Catch:{  }
            com.google.android.gms.internal.ads.zzgau r4 = r4.zzb()     // Catch:{  }
            boolean r3 = r3.zzg()     // Catch:{  }
            com.google.android.gms.internal.ads.zzgby.zzm(r4, r3)     // Catch:{  }
            goto L_0x0047
        L_0x00f6:
            java.security.GeneralSecurityException r6 = new java.security.GeneralSecurityException     // Catch:{  }
            java.lang.String r0 = "Missing catalogue_name."
            r6.<init>(r0)     // Catch:{  }
            throw r6     // Catch:{  }
        L_0x00fe:
            java.security.GeneralSecurityException r6 = new java.security.GeneralSecurityException     // Catch:{  }
            java.lang.String r0 = "Missing primitive_name."
            r6.<init>(r0)     // Catch:{  }
            throw r6     // Catch:{  }
        L_0x0106:
            java.security.GeneralSecurityException r6 = new java.security.GeneralSecurityException     // Catch:{  }
            java.lang.String r0 = "Missing type_url."
            r6.<init>(r0)     // Catch:{  }
            throw r6     // Catch:{  }
        L_0x010e:
            com.google.android.gms.internal.ads.zzgas r6 = com.google.android.gms.internal.ads.zzgei.zza(r6)     // Catch:{  }
            zza = r6     // Catch:{  }
            com.google.android.gms.internal.ads.zzgas r6 = zza
            if (r6 == 0) goto L_0x0119
            return r1
        L_0x0119:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqf.zza(com.google.android.gms.internal.ads.zzaqe):boolean");
    }
}
