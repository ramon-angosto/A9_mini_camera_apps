package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeeo implements zzfhk {
    protected final Context zza;
    protected final String zzb;
    protected final zzcbo zzc;

    public zzeeo(Context context, String str, zzcbo zzcbo, int i, byte[] bArr) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzcbo;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r2 = new java.io.InputStreamReader(r7.getInputStream());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        com.google.android.gms.ads.internal.zzt.zzp();
        r0 = new java.lang.StringBuilder(8192);
        r3 = new char[2048];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0144, code lost:
        r6 = r2.read(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0149, code lost:
        if (r6 == -1) goto L_0x0150;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x014b, code lost:
        r0.append(r3, 0, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0150, code lost:
        r0 = r0.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2);
        r4.zzg(r0);
        r5.zzc = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0160, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x017c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0172, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzay.zzc().zzb(com.google.android.gms.internal.ads.zzbjc.zzeC)).booleanValue() == false) goto L_0x0175;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x017b, code lost:
        throw new com.google.android.gms.internal.ads.zzebh(3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x017c, code lost:
        r5.zzd = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x018c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x020c, code lost:
        throw new com.google.android.gms.internal.ads.zzebh(r1, "Received error HTTP response code: " + r6);
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0233 A[Catch:{ all -> 0x0242 }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0241 A[Catch:{ all -> 0x0242 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:109:0x0243=Splitter:B:109:0x0243, B:64:0x0187=Splitter:B:64:0x0187} */
    /* renamed from: zzb */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzeen zza(com.google.android.gms.internal.ads.zzeem r21) throws com.google.android.gms.internal.ads.zzebh {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            java.lang.String r2 = "Received error HTTP response code: "
            java.lang.String r3 = r0.zza
            int r11 = r0.zzb
            java.util.Map r12 = r0.zzc
            byte[] r13 = r0.zzd
            java.lang.String r0 = r0.zze
            com.google.android.gms.common.util.Clock r4 = com.google.android.gms.ads.internal.zzt.zzB()
            long r14 = r4.elapsedRealtime()
            r10 = 1
            com.google.android.gms.internal.ads.zzeen r9 = new com.google.android.gms.internal.ads.zzeen     // Catch:{ IOException -> 0x0249 }
            r9.<init>()     // Catch:{ IOException -> 0x0249 }
            java.lang.String r4 = r1.zzb     // Catch:{ IOException -> 0x0249 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0249 }
            r5.<init>()     // Catch:{ IOException -> 0x0249 }
            java.lang.String r6 = "SDK version: "
            r5.append(r6)     // Catch:{ IOException -> 0x0249 }
            r5.append(r4)     // Catch:{ IOException -> 0x0249 }
            java.lang.String r4 = r5.toString()     // Catch:{ IOException -> 0x0249 }
            com.google.android.gms.ads.internal.util.zze.zzi(r4)     // Catch:{ IOException -> 0x0249 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0249 }
            r4.<init>()     // Catch:{ IOException -> 0x0249 }
            java.lang.String r5 = "AdRequestServiceImpl: Sending request: "
            r4.append(r5)     // Catch:{ IOException -> 0x0249 }
            r4.append(r3)     // Catch:{ IOException -> 0x0249 }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x0249 }
            com.google.android.gms.ads.internal.util.zze.zze(r4)     // Catch:{ IOException -> 0x0249 }
            java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x0249 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0249 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ IOException -> 0x0249 }
            r3.<init>()     // Catch:{ IOException -> 0x0249 }
            r8 = 0
            r16 = r8
        L_0x0055:
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ IOException -> 0x0249 }
            r7 = r4
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ IOException -> 0x0249 }
            com.google.android.gms.ads.internal.util.zzs r4 = com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ zzebh -> 0x021e, all -> 0x021b }
            android.content.Context r5 = r1.zza     // Catch:{ zzebh -> 0x021e, all -> 0x021b }
            java.lang.String r6 = r1.zzb     // Catch:{ zzebh -> 0x021e, all -> 0x021b }
            r17 = 0
            r18 = 0
            r21 = r7
            r7 = r17
            r8 = r21
            r19 = r9
            r9 = r18
            r1 = r10
            r10 = r11
            r4.zze(r5, r6, r7, r8, r9, r10)     // Catch:{ zzebh -> 0x0215, all -> 0x0211 }
            java.util.Set r4 = r12.entrySet()     // Catch:{ zzebh -> 0x0215, all -> 0x0211 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ zzebh -> 0x0215, all -> 0x0211 }
        L_0x007f:
            boolean r5 = r4.hasNext()     // Catch:{ zzebh -> 0x0215, all -> 0x0211 }
            if (r5 == 0) goto L_0x009f
            java.lang.Object r5 = r4.next()     // Catch:{ zzebh -> 0x0215, all -> 0x0211 }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ zzebh -> 0x0215, all -> 0x0211 }
            java.lang.Object r6 = r5.getKey()     // Catch:{ zzebh -> 0x0215, all -> 0x0211 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ zzebh -> 0x0215, all -> 0x0211 }
            java.lang.Object r5 = r5.getValue()     // Catch:{ zzebh -> 0x0215, all -> 0x0211 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ zzebh -> 0x0215, all -> 0x0211 }
            r7 = r21
            r7.addRequestProperty(r6, r5)     // Catch:{ zzebh -> 0x020f }
            r21 = r7
            goto L_0x007f
        L_0x009f:
            r7 = r21
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ zzebh -> 0x020f }
            if (r4 != 0) goto L_0x00ac
            java.lang.String r4 = "Content-Type"
            r7.setRequestProperty(r4, r0)     // Catch:{ zzebh -> 0x020f }
        L_0x00ac:
            int r4 = r13.length     // Catch:{ zzebh -> 0x020f }
            r5 = 0
            if (r4 <= 0) goto L_0x00ce
            r7.setDoOutput(r1)     // Catch:{ zzebh -> 0x020f }
            r7.setFixedLengthStreamingMode(r4)     // Catch:{ zzebh -> 0x020f }
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x00c8 }
            java.io.OutputStream r6 = r7.getOutputStream()     // Catch:{ all -> 0x00c8 }
            r4.<init>(r6)     // Catch:{ all -> 0x00c8 }
            r4.write(r13)     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r4)     // Catch:{ zzebh -> 0x020f }
            goto L_0x00ce
        L_0x00c6:
            r0 = move-exception
            goto L_0x00ca
        L_0x00c8:
            r0 = move-exception
            r4 = r5
        L_0x00ca:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r4)     // Catch:{ zzebh -> 0x020f }
            throw r0     // Catch:{ zzebh -> 0x020f }
        L_0x00ce:
            com.google.android.gms.internal.ads.zzcgo r4 = new com.google.android.gms.internal.ads.zzcgo     // Catch:{ zzebh -> 0x020f }
            r4.<init>(r5)     // Catch:{ zzebh -> 0x020f }
            r4.zzc(r7, r13)     // Catch:{ zzebh -> 0x020f }
            int r6 = r7.getResponseCode()     // Catch:{ zzebh -> 0x020f }
            java.util.Map r8 = r7.getHeaderFields()     // Catch:{ zzebh -> 0x020f }
            java.util.Set r8 = r8.entrySet()     // Catch:{ zzebh -> 0x020f }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ zzebh -> 0x020f }
        L_0x00e6:
            boolean r9 = r8.hasNext()     // Catch:{ zzebh -> 0x020f }
            if (r9 == 0) goto L_0x0118
            java.lang.Object r9 = r8.next()     // Catch:{ zzebh -> 0x020f }
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9     // Catch:{ zzebh -> 0x020f }
            java.lang.Object r10 = r9.getKey()     // Catch:{ zzebh -> 0x020f }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ zzebh -> 0x020f }
            java.lang.Object r9 = r9.getValue()     // Catch:{ zzebh -> 0x020f }
            java.util.List r9 = (java.util.List) r9     // Catch:{ zzebh -> 0x020f }
            boolean r17 = r3.containsKey(r10)     // Catch:{ zzebh -> 0x020f }
            if (r17 == 0) goto L_0x010e
            java.lang.Object r10 = r3.get(r10)     // Catch:{ zzebh -> 0x020f }
            java.util.List r10 = (java.util.List) r10     // Catch:{ zzebh -> 0x020f }
            r10.addAll(r9)     // Catch:{ zzebh -> 0x020f }
            goto L_0x00e6
        L_0x010e:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ zzebh -> 0x020f }
            r5.<init>(r9)     // Catch:{ zzebh -> 0x020f }
            r3.put(r10, r5)     // Catch:{ zzebh -> 0x020f }
            r5 = 0
            goto L_0x00e6
        L_0x0118:
            r4.zze(r7, r6)     // Catch:{ zzebh -> 0x020f }
            r5 = r19
            r5.zza = r6     // Catch:{ zzebh -> 0x020d }
            r5.zzb = r3     // Catch:{ zzebh -> 0x020d }
            java.lang.String r8 = ""
            r5.zzc = r8     // Catch:{ zzebh -> 0x020d }
            r8 = 200(0xc8, float:2.8E-43)
            r9 = 300(0x12c, float:4.2E-43)
            if (r6 < r8) goto L_0x0194
            if (r6 >= r9) goto L_0x0194
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x018e }
            java.io.InputStream r0 = r7.getInputStream()     // Catch:{ all -> 0x018e }
            r2.<init>(r0)     // Catch:{ all -> 0x018e }
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x018c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x018c }
            r3 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r3)     // Catch:{ all -> 0x018c }
            r3 = 2048(0x800, float:2.87E-42)
            char[] r3 = new char[r3]     // Catch:{ all -> 0x018c }
        L_0x0144:
            int r6 = r2.read(r3)     // Catch:{ all -> 0x018c }
            r8 = -1
            if (r6 == r8) goto L_0x0150
            r8 = 0
            r0.append(r3, r8, r6)     // Catch:{ all -> 0x018c }
            goto L_0x0144
        L_0x0150:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x018c }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2)     // Catch:{ zzebh -> 0x020d }
            r4.zzg(r0)     // Catch:{ zzebh -> 0x020d }
            r5.zzc = r0     // Catch:{ zzebh -> 0x020d }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ zzebh -> 0x020d }
            if (r0 == 0) goto L_0x017c
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzeC     // Catch:{ zzebh -> 0x020d }
            com.google.android.gms.internal.ads.zzbja r2 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ zzebh -> 0x020d }
            java.lang.Object r0 = r2.zzb(r0)     // Catch:{ zzebh -> 0x020d }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ zzebh -> 0x020d }
            boolean r0 = r0.booleanValue()     // Catch:{ zzebh -> 0x020d }
            if (r0 == 0) goto L_0x0175
            goto L_0x017c
        L_0x0175:
            com.google.android.gms.internal.ads.zzebh r0 = new com.google.android.gms.internal.ads.zzebh     // Catch:{ zzebh -> 0x020d }
            r2 = 3
            r0.<init>(r2)     // Catch:{ zzebh -> 0x020d }
            throw r0     // Catch:{ zzebh -> 0x020d }
        L_0x017c:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzt.zzB()     // Catch:{ zzebh -> 0x020d }
            long r2 = r0.elapsedRealtime()     // Catch:{ zzebh -> 0x020d }
            long r2 = r2 - r14
            r5.zzd = r2     // Catch:{ zzebh -> 0x020d }
        L_0x0187:
            r7.disconnect()     // Catch:{ IOException -> 0x0247 }
            goto L_0x0240
        L_0x018c:
            r0 = move-exception
            goto L_0x0190
        L_0x018e:
            r0 = move-exception
            r2 = 0
        L_0x0190:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2)     // Catch:{ zzebh -> 0x020d }
            throw r0     // Catch:{ zzebh -> 0x020d }
        L_0x0194:
            r8 = 0
            if (r6 < r9) goto L_0x01e6
            r4 = 400(0x190, float:5.6E-43)
            if (r6 >= r4) goto L_0x01e6
            java.lang.String r4 = "Location"
            java.lang.String r4 = r7.getHeaderField(r4)     // Catch:{ zzebh -> 0x020d }
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ zzebh -> 0x020d }
            if (r6 != 0) goto L_0x01d9
            java.net.URL r6 = new java.net.URL     // Catch:{ zzebh -> 0x020d }
            r6.<init>(r4)     // Catch:{ zzebh -> 0x020d }
            int r4 = r16 + 1
            com.google.android.gms.internal.ads.zzbiu r9 = com.google.android.gms.internal.ads.zzbjc.zzef     // Catch:{ zzebh -> 0x020d }
            com.google.android.gms.internal.ads.zzbja r10 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ zzebh -> 0x020d }
            java.lang.Object r9 = r10.zzb(r9)     // Catch:{ zzebh -> 0x020d }
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ zzebh -> 0x020d }
            int r9 = r9.intValue()     // Catch:{ zzebh -> 0x020d }
            if (r4 > r9) goto L_0x01cc
            r7.disconnect()     // Catch:{ IOException -> 0x0247 }
            r10 = r1
            r16 = r4
            r9 = r5
            r4 = r6
            r1 = r20
            goto L_0x0055
        L_0x01cc:
            java.lang.String r0 = "Too many redirects."
            com.google.android.gms.ads.internal.util.zze.zzj(r0)     // Catch:{ zzebh -> 0x020d }
            com.google.android.gms.internal.ads.zzebh r0 = new com.google.android.gms.internal.ads.zzebh     // Catch:{ zzebh -> 0x020d }
            java.lang.String r2 = "Too many redirects"
            r0.<init>(r1, r2)     // Catch:{ zzebh -> 0x020d }
            throw r0     // Catch:{ zzebh -> 0x020d }
        L_0x01d9:
            java.lang.String r0 = "No location header to follow redirect."
            com.google.android.gms.ads.internal.util.zze.zzj(r0)     // Catch:{ zzebh -> 0x020d }
            com.google.android.gms.internal.ads.zzebh r0 = new com.google.android.gms.internal.ads.zzebh     // Catch:{ zzebh -> 0x020d }
            java.lang.String r2 = "No location header to follow redirect"
            r0.<init>(r1, r2)     // Catch:{ zzebh -> 0x020d }
            throw r0     // Catch:{ zzebh -> 0x020d }
        L_0x01e6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ zzebh -> 0x020d }
            r0.<init>()     // Catch:{ zzebh -> 0x020d }
            r0.append(r2)     // Catch:{ zzebh -> 0x020d }
            r0.append(r6)     // Catch:{ zzebh -> 0x020d }
            java.lang.String r0 = r0.toString()     // Catch:{ zzebh -> 0x020d }
            com.google.android.gms.ads.internal.util.zze.zzj(r0)     // Catch:{ zzebh -> 0x020d }
            com.google.android.gms.internal.ads.zzebh r0 = new com.google.android.gms.internal.ads.zzebh     // Catch:{ zzebh -> 0x020d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ zzebh -> 0x020d }
            r3.<init>()     // Catch:{ zzebh -> 0x020d }
            r3.append(r2)     // Catch:{ zzebh -> 0x020d }
            r3.append(r6)     // Catch:{ zzebh -> 0x020d }
            java.lang.String r2 = r3.toString()     // Catch:{ zzebh -> 0x020d }
            r0.<init>(r1, r2)     // Catch:{ zzebh -> 0x020d }
            throw r0     // Catch:{ zzebh -> 0x020d }
        L_0x020d:
            r0 = move-exception
            goto L_0x0221
        L_0x020f:
            r0 = move-exception
            goto L_0x0218
        L_0x0211:
            r0 = move-exception
            r7 = r21
            goto L_0x0243
        L_0x0215:
            r0 = move-exception
            r7 = r21
        L_0x0218:
            r5 = r19
            goto L_0x0221
        L_0x021b:
            r0 = move-exception
            r1 = r10
            goto L_0x0243
        L_0x021e:
            r0 = move-exception
            r5 = r9
            r1 = r10
        L_0x0221:
            com.google.android.gms.internal.ads.zzbiu r2 = com.google.android.gms.internal.ads.zzbjc.zzhg     // Catch:{ all -> 0x0242 }
            com.google.android.gms.internal.ads.zzbja r3 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x0242 }
            java.lang.Object r2 = r3.zzb(r2)     // Catch:{ all -> 0x0242 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x0242 }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x0242 }
            if (r2 == 0) goto L_0x0241
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzt.zzB()     // Catch:{ all -> 0x0242 }
            long r2 = r0.elapsedRealtime()     // Catch:{ all -> 0x0242 }
            long r2 = r2 - r14
            r5.zzd = r2     // Catch:{ all -> 0x0242 }
            goto L_0x0187
        L_0x0240:
            return r5
        L_0x0241:
            throw r0     // Catch:{ all -> 0x0242 }
        L_0x0242:
            r0 = move-exception
        L_0x0243:
            r7.disconnect()     // Catch:{ IOException -> 0x0247 }
            throw r0     // Catch:{ IOException -> 0x0247 }
        L_0x0247:
            r0 = move-exception
            goto L_0x024b
        L_0x0249:
            r0 = move-exception
            r1 = r10
        L_0x024b:
            java.lang.String r2 = r0.getMessage()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "Error while connecting to ad server: "
            java.lang.String r2 = r3.concat(r2)
            com.google.android.gms.ads.internal.util.zze.zzj(r2)
            com.google.android.gms.internal.ads.zzebh r3 = new com.google.android.gms.internal.ads.zzebh
            r3.<init>(r1, r2, r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeeo.zza(com.google.android.gms.internal.ads.zzeem):com.google.android.gms.internal.ads.zzeen");
    }
}
