package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
final class zzy {
    private final zzz zza;
    private final zzbw zzb;
    private int zzc = 0;

    zzy(zzz zzz, zzbw zzbw) {
        this.zza = zzz;
        this.zzb = zzbw;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0082 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.consent_sdk.zzaa zza() throws com.google.android.gms.internal.consent_sdk.zzj {
        /*
            r11 = this;
            com.google.android.gms.internal.consent_sdk.zzbw r0 = r11.zzb
            int r1 = r0.zzf
            int r2 = r1 + -1
            r3 = 0
            if (r1 == 0) goto L_0x00c3
            r1 = 2
            r4 = 3
            r5 = 1
            switch(r2) {
                case 1: goto L_0x0059;
                case 2: goto L_0x0059;
                case 3: goto L_0x0059;
                case 4: goto L_0x0056;
                case 5: goto L_0x0053;
                case 6: goto L_0x0035;
                case 7: goto L_0x0017;
                default: goto L_0x000f;
            }
        L_0x000f:
            com.google.android.gms.internal.consent_sdk.zzj r0 = new com.google.android.gms.internal.consent_sdk.zzj
            java.lang.String r1 = "Invalid response from server."
            r0.<init>(r5, r1)
            throw r0
        L_0x0017:
            com.google.android.gms.internal.consent_sdk.zzj r1 = new com.google.android.gms.internal.consent_sdk.zzj
            java.lang.String r0 = r0.zzc
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "Publisher misconfiguration: "
            int r3 = r0.length()
            if (r3 == 0) goto L_0x002c
            java.lang.String r0 = r2.concat(r0)
            goto L_0x0031
        L_0x002c:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
        L_0x0031:
            r1.<init>(r4, r0)
            throw r1
        L_0x0035:
            com.google.android.gms.internal.consent_sdk.zzj r1 = new com.google.android.gms.internal.consent_sdk.zzj
            java.lang.String r0 = r0.zzc
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "Invalid response from server: "
            int r3 = r0.length()
            if (r3 == 0) goto L_0x004a
            java.lang.String r0 = r2.concat(r0)
            goto L_0x004f
        L_0x004a:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
        L_0x004f:
            r1.<init>(r5, r0)
            throw r1
        L_0x0053:
            r11.zzc = r5
            goto L_0x005b
        L_0x0056:
            r11.zzc = r1
            goto L_0x005b
        L_0x0059:
            r11.zzc = r4
        L_0x005b:
            java.lang.String r2 = r0.zza
            if (r2 != 0) goto L_0x0061
            r4 = r3
            goto L_0x0068
        L_0x0061:
            com.google.android.gms.internal.consent_sdk.zzbc r4 = new com.google.android.gms.internal.consent_sdk.zzbc
            java.lang.String r0 = r0.zzb
            r4.<init>(r0, r2)
        L_0x0068:
            com.google.android.gms.internal.consent_sdk.zzz r0 = r11.zza
            com.google.android.gms.internal.consent_sdk.zzam r0 = r0.zzc
            java.util.HashSet r2 = new java.util.HashSet
            com.google.android.gms.internal.consent_sdk.zzbw r6 = r11.zzb
            java.util.List<java.lang.String> r6 = r6.zzd
            r2.<init>(r6)
            r0.zzg(r2)
            com.google.android.gms.internal.consent_sdk.zzbw r0 = r11.zzb
            java.util.List<com.google.android.gms.internal.consent_sdk.zzbv> r0 = r0.zze
            java.util.Iterator r0 = r0.iterator()
        L_0x0082:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00bb
            java.lang.Object r2 = r0.next()
            com.google.android.gms.internal.consent_sdk.zzbv r2 = (com.google.android.gms.internal.consent_sdk.zzbv) r2
            int r6 = r2.zzb
            int r7 = r6 + -1
            if (r6 == 0) goto L_0x00ba
            if (r7 == 0) goto L_0x009a
            if (r7 == r5) goto L_0x009f
            if (r7 == r1) goto L_0x009c
        L_0x009a:
            r6 = r3
            goto L_0x00a1
        L_0x009c:
            java.lang.String r6 = "clear"
            goto L_0x00a1
        L_0x009f:
            java.lang.String r6 = "write"
        L_0x00a1:
            if (r6 == 0) goto L_0x0082
            com.google.android.gms.internal.consent_sdk.zzz r7 = r11.zza
            com.google.android.gms.internal.consent_sdk.zzh r7 = r7.zza
            java.lang.String r2 = r2.zza
            com.google.android.gms.internal.consent_sdk.zzg[] r8 = new com.google.android.gms.internal.consent_sdk.zzg[r5]
            r9 = 0
            com.google.android.gms.internal.consent_sdk.zzz r10 = r11.zza
            com.google.android.gms.internal.consent_sdk.zzak r10 = r10.zzb
            r8[r9] = r10
            r7.zzb(r6, r2, r8)
            goto L_0x0082
        L_0x00ba:
            throw r3
        L_0x00bb:
            com.google.android.gms.internal.consent_sdk.zzaa r0 = new com.google.android.gms.internal.consent_sdk.zzaa
            int r1 = r11.zzc
            r0.<init>(r1, r4, r3)
            return r0
        L_0x00c3:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.consent_sdk.zzy.zza():com.google.android.gms.internal.consent_sdk.zzaa");
    }
}
