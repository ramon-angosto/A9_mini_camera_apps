package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbdc {
    private final zzbcr zza;
    private final int zzb;
    private String zzc;
    private final int zzd;

    public zzbdc(int i, int i2, int i3) {
        this.zzb = i;
        int i4 = 64;
        if (i2 <= 64 && i2 >= 0) {
            i4 = i2;
        }
        if (i3 <= 0) {
            this.zzd = 1;
        } else {
            this.zzd = i3;
        }
        this.zza = new zzbda(i4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d9, code lost:
        r2.add(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e2, code lost:
        if (r2.size() >= r1.zzb) goto L_0x00f8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00f0 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zza(java.util.ArrayList r17, java.util.ArrayList r18) {
        /*
            r16 = this;
            r1 = r16
            r0 = r18
            com.google.android.gms.internal.ads.zzbdb r2 = new com.google.android.gms.internal.ads.zzbdb
            r2.<init>(r1)
            java.util.Collections.sort(r0, r2)
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            r4 = 0
        L_0x0012:
            int r5 = r18.size()
            if (r4 >= r5) goto L_0x00f8
            java.lang.Object r5 = r0.get(r4)
            com.google.android.gms.internal.ads.zzbcq r5 = (com.google.android.gms.internal.ads.zzbcq) r5
            int r5 = r5.zze()
            r6 = r17
            java.lang.Object r5 = r6.get(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.text.Normalizer$Form r7 = java.text.Normalizer.Form.NFKC
            java.lang.String r5 = java.text.Normalizer.normalize(r5, r7)
            java.util.Locale r7 = java.util.Locale.US
            java.lang.String r5 = r5.toLowerCase(r7)
            java.lang.String r7 = "\n"
            java.lang.String[] r5 = r5.split(r7)
            int r7 = r5.length
            if (r7 != 0) goto L_0x0041
            goto L_0x00f4
        L_0x0041:
            r7 = 0
        L_0x0042:
            int r8 = r5.length
            if (r7 >= r8) goto L_0x00f4
            r8 = r5[r7]
            java.lang.String r9 = "'"
            boolean r9 = r8.contains(r9)
            r10 = 1
            if (r9 == 0) goto L_0x00a7
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r8)
            r11 = r10
            r12 = 0
        L_0x0057:
            int r13 = r11 + 2
            int r14 = r9.length()
            if (r13 > r14) goto L_0x009a
            char r14 = r9.charAt(r11)
            r15 = 39
            if (r14 != r15) goto L_0x0098
            int r12 = r11 + -1
            char r12 = r9.charAt(r12)
            r14 = 32
            if (r12 == r14) goto L_0x0094
            int r12 = r11 + 1
            char r15 = r9.charAt(r12)
            r3 = 115(0x73, float:1.61E-43)
            if (r15 == r3) goto L_0x0083
            char r3 = r9.charAt(r12)
            r12 = 83
            if (r3 != r12) goto L_0x0094
        L_0x0083:
            int r3 = r9.length()
            if (r13 == r3) goto L_0x008f
            char r3 = r9.charAt(r13)
            if (r3 != r14) goto L_0x0094
        L_0x008f:
            r9.insert(r11, r14)
            r11 = r13
            goto L_0x0097
        L_0x0094:
            r9.setCharAt(r11, r14)
        L_0x0097:
            r12 = r10
        L_0x0098:
            int r11 = r11 + r10
            goto L_0x0057
        L_0x009a:
            if (r12 == 0) goto L_0x00a1
            java.lang.String r3 = r9.toString()
            goto L_0x00a2
        L_0x00a1:
            r3 = 0
        L_0x00a2:
            if (r3 == 0) goto L_0x00a7
            r1.zzc = r3
            goto L_0x00a8
        L_0x00a7:
            r3 = r8
        L_0x00a8:
            java.lang.String[] r3 = com.google.android.gms.internal.ads.zzbcv.zzb(r3, r10)
            int r8 = r3.length
            int r9 = r1.zzd
            if (r8 >= r9) goto L_0x00b2
            goto L_0x00f0
        L_0x00b2:
            r8 = 0
        L_0x00b3:
            int r9 = r3.length
            if (r8 >= r9) goto L_0x00e7
            java.lang.String r9 = ""
            r10 = r9
            r9 = 0
        L_0x00ba:
            int r11 = r1.zzd
            if (r9 >= r11) goto L_0x00d9
            int r11 = r8 + r9
            int r12 = r3.length
            if (r11 < r12) goto L_0x00c4
            goto L_0x00e7
        L_0x00c4:
            if (r9 <= 0) goto L_0x00cc
            java.lang.String r12 = " "
            java.lang.String r10 = r10.concat(r12)
        L_0x00cc:
            r11 = r3[r11]
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.String r10 = r10.concat(r11)
            int r9 = r9 + 1
            goto L_0x00ba
        L_0x00d9:
            r2.add(r10)
            int r9 = r2.size()
            int r10 = r1.zzb
            if (r9 >= r10) goto L_0x00f8
            int r8 = r8 + 1
            goto L_0x00b3
        L_0x00e7:
            int r3 = r2.size()
            int r8 = r1.zzb
            if (r3 < r8) goto L_0x00f0
            goto L_0x00f8
        L_0x00f0:
            int r7 = r7 + 1
            goto L_0x0042
        L_0x00f4:
            int r4 = r4 + 1
            goto L_0x0012
        L_0x00f8:
            com.google.android.gms.internal.ads.zzbct r3 = new com.google.android.gms.internal.ads.zzbct
            r3.<init>()
            java.util.Iterator r0 = r2.iterator()
        L_0x0101:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x011f
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            com.google.android.gms.internal.ads.zzbcr r4 = r1.zza     // Catch:{ IOException -> 0x0119 }
            byte[] r2 = r4.zzb(r2)     // Catch:{ IOException -> 0x0119 }
            android.util.Base64OutputStream r4 = r3.zzb     // Catch:{ IOException -> 0x0119 }
            r4.write(r2)     // Catch:{ IOException -> 0x0119 }
            goto L_0x0101
        L_0x0119:
            r0 = move-exception
            java.lang.String r2 = "Error while writing hash to byteStream"
            com.google.android.gms.ads.internal.util.zze.zzh(r2, r0)
        L_0x011f:
            java.lang.String r0 = r3.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdc.zza(java.util.ArrayList, java.util.ArrayList):java.lang.String");
    }
}
