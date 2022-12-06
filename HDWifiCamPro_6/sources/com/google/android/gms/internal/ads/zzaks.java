package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzaks implements zzajw {
    protected final zzaku zza;
    @Deprecated
    protected final zzakr zzb;
    private final zzakr zzc;

    public zzaks(zzakr zzakr) {
        zzaku zzaku = new zzaku(4096);
        this.zzc = zzakr;
        this.zzb = zzakr;
        this.zza = zzaku;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:101:0x0220 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:93:0x020c */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x027e A[Catch:{ IOException -> 0x029a }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0294 A[Catch:{ IOException -> 0x029a }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02b6 A[SYNTHETIC, Splitter:B:139:0x02b6] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02c6  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02d6  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x02b9 A[EDGE_INSN: B:184:0x02b9->B:141:0x02b9 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.ads.zzajz zza(com.google.android.gms.internal.ads.zzakd r24) throws com.google.android.gms.internal.ads.zzakm {
        /*
            r23 = this;
            r1 = r24
            java.lang.String r2 = "Error occurred when closing InputStream"
            java.lang.String r3 = "Content-Type"
            long r4 = android.os.SystemClock.elapsedRealtime()
        L_0x000a:
            java.util.Collections.emptyList()
            r7 = 1
            r8 = 0
            r9 = 0
            com.google.android.gms.internal.ads.zzajm r0 = r24.zzd()     // Catch:{ IOException -> 0x02bc }
            if (r0 != 0) goto L_0x001b
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ IOException -> 0x02bc }
            goto L_0x003b
        L_0x001b:
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ IOException -> 0x02bc }
            r10.<init>()     // Catch:{ IOException -> 0x02bc }
            java.lang.String r11 = r0.zzb     // Catch:{ IOException -> 0x02bc }
            if (r11 == 0) goto L_0x0029
            java.lang.String r12 = "If-None-Match"
            r10.put(r12, r11)     // Catch:{ IOException -> 0x02bc }
        L_0x0029:
            long r11 = r0.zzd     // Catch:{ IOException -> 0x02bc }
            r13 = 0
            int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r0 <= 0) goto L_0x003a
            java.lang.String r0 = "If-Modified-Since"
            java.lang.String r11 = com.google.android.gms.internal.ads.zzala.zzc(r11)     // Catch:{ IOException -> 0x02bc }
            r10.put(r0, r11)     // Catch:{ IOException -> 0x02bc }
        L_0x003a:
            r0 = r10
        L_0x003b:
            java.lang.String r10 = "application/x-www-form-urlencoded; charset=UTF-8"
            java.lang.String r11 = r24.zzk()     // Catch:{ IOException -> 0x02bc }
            java.util.HashMap r12 = new java.util.HashMap     // Catch:{ IOException -> 0x02bc }
            r12.<init>()     // Catch:{ IOException -> 0x02bc }
            r12.putAll(r0)     // Catch:{ IOException -> 0x02bc }
            java.util.Map r0 = r24.zzl()     // Catch:{ IOException -> 0x02bc }
            r12.putAll(r0)     // Catch:{ IOException -> 0x02bc }
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x02bc }
            r0.<init>(r11)     // Catch:{ IOException -> 0x02bc }
            java.net.URLConnection r11 = r0.openConnection()     // Catch:{ IOException -> 0x02bc }
            java.net.HttpURLConnection r11 = (java.net.HttpURLConnection) r11     // Catch:{ IOException -> 0x02bc }
            boolean r13 = java.net.HttpURLConnection.getFollowRedirects()     // Catch:{ IOException -> 0x02bc }
            r11.setInstanceFollowRedirects(r13)     // Catch:{ IOException -> 0x02bc }
            int r13 = r24.zzb()     // Catch:{ IOException -> 0x02bc }
            r11.setConnectTimeout(r13)     // Catch:{ IOException -> 0x02bc }
            r11.setReadTimeout(r13)     // Catch:{ IOException -> 0x02bc }
            r11.setUseCaches(r9)     // Catch:{ IOException -> 0x02bc }
            r11.setDoInput(r7)     // Catch:{ IOException -> 0x02bc }
            java.lang.String r13 = "https"
            java.lang.String r0 = r0.getProtocol()     // Catch:{ IOException -> 0x02bc }
            r13.equals(r0)     // Catch:{ IOException -> 0x02bc }
            java.util.Set r0 = r12.keySet()     // Catch:{ all -> 0x02b0 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x02b0 }
        L_0x0083:
            boolean r13 = r0.hasNext()     // Catch:{ all -> 0x02b0 }
            if (r13 == 0) goto L_0x0099
            java.lang.Object r13 = r0.next()     // Catch:{ all -> 0x02b0 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x02b0 }
            java.lang.Object r14 = r12.get(r13)     // Catch:{ all -> 0x02b0 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x02b0 }
            r11.setRequestProperty(r13, r14)     // Catch:{ all -> 0x02b0 }
            goto L_0x0083
        L_0x0099:
            int r0 = r24.zza()     // Catch:{ all -> 0x02b0 }
            if (r0 == 0) goto L_0x00ca
            java.lang.String r0 = "POST"
            r11.setRequestMethod(r0)     // Catch:{ all -> 0x02b0 }
            byte[] r0 = r24.zzx()     // Catch:{ all -> 0x02b0 }
            if (r0 == 0) goto L_0x00cf
            r11.setDoOutput(r7)     // Catch:{ all -> 0x02b0 }
            java.util.Map r12 = r11.getRequestProperties()     // Catch:{ all -> 0x02b0 }
            boolean r12 = r12.containsKey(r3)     // Catch:{ all -> 0x02b0 }
            if (r12 != 0) goto L_0x00ba
            r11.setRequestProperty(r3, r10)     // Catch:{ all -> 0x02b0 }
        L_0x00ba:
            java.io.DataOutputStream r10 = new java.io.DataOutputStream     // Catch:{ all -> 0x02b0 }
            java.io.OutputStream r12 = r11.getOutputStream()     // Catch:{ all -> 0x02b0 }
            r10.<init>(r12)     // Catch:{ all -> 0x02b0 }
            r10.write(r0)     // Catch:{ all -> 0x02b0 }
            r10.close()     // Catch:{ all -> 0x02b0 }
            goto L_0x00cf
        L_0x00ca:
            java.lang.String r0 = "GET"
            r11.setRequestMethod(r0)     // Catch:{ all -> 0x02b0 }
        L_0x00cf:
            int r0 = r11.getResponseCode()     // Catch:{ all -> 0x02b0 }
            r10 = -1
            if (r0 == r10) goto L_0x02a4
            r24.zza()     // Catch:{ all -> 0x02b0 }
            r12 = 100
            r13 = 304(0x130, float:4.26E-43)
            r14 = 200(0xc8, float:2.8E-43)
            if (r0 < r12) goto L_0x00e3
            if (r0 < r14) goto L_0x0106
        L_0x00e3:
            r12 = 204(0xcc, float:2.86E-43)
            if (r0 == r12) goto L_0x0106
            if (r0 == r13) goto L_0x0106
            com.google.android.gms.internal.ads.zzalb r12 = new com.google.android.gms.internal.ads.zzalb     // Catch:{ all -> 0x0101 }
            java.util.Map r15 = r11.getHeaderFields()     // Catch:{ all -> 0x0101 }
            java.util.List r15 = com.google.android.gms.internal.ads.zzale.zza(r15)     // Catch:{ all -> 0x0101 }
            int r14 = r11.getContentLength()     // Catch:{ all -> 0x0101 }
            com.google.android.gms.internal.ads.zzalc r6 = new com.google.android.gms.internal.ads.zzalc     // Catch:{ all -> 0x0101 }
            r6.<init>(r11)     // Catch:{ all -> 0x0101 }
            r12.<init>(r0, r15, r14, r6)     // Catch:{ all -> 0x0101 }
            r6 = r12
            goto L_0x0116
        L_0x0101:
            r0 = move-exception
            r14 = r23
            goto L_0x02b4
        L_0x0106:
            com.google.android.gms.internal.ads.zzalb r6 = new com.google.android.gms.internal.ads.zzalb     // Catch:{ all -> 0x02b0 }
            java.util.Map r12 = r11.getHeaderFields()     // Catch:{ all -> 0x02b0 }
            java.util.List r12 = com.google.android.gms.internal.ads.zzale.zza(r12)     // Catch:{ all -> 0x02b0 }
            r6.<init>(r0, r12, r10, r8)     // Catch:{ all -> 0x02b0 }
            r11.disconnect()     // Catch:{ IOException -> 0x02bc }
        L_0x0116:
            int r0 = r6.zzb()     // Catch:{ IOException -> 0x02a0 }
            java.util.List r11 = r6.zzd()     // Catch:{ IOException -> 0x02a0 }
            if (r0 != r13) goto L_0x01e1
            long r12 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x02a0 }
            long r20 = r12 - r4
            com.google.android.gms.internal.ads.zzajm r0 = r24.zzd()     // Catch:{ IOException -> 0x02a0 }
            if (r0 != 0) goto L_0x013d
            com.google.android.gms.internal.ads.zzajz r0 = new com.google.android.gms.internal.ads.zzajz     // Catch:{ IOException -> 0x02a0 }
            r17 = 304(0x130, float:4.26E-43)
            r18 = 0
            r19 = 1
            r16 = r0
            r22 = r11
            r16.<init>((int) r17, (byte[]) r18, (boolean) r19, (long) r20, (java.util.List) r22)     // Catch:{ IOException -> 0x02a0 }
            goto L_0x01e0
        L_0x013d:
            java.util.TreeSet r10 = new java.util.TreeSet     // Catch:{ IOException -> 0x02a0 }
            java.util.Comparator r12 = java.lang.String.CASE_INSENSITIVE_ORDER     // Catch:{ IOException -> 0x02a0 }
            r10.<init>(r12)     // Catch:{ IOException -> 0x02a0 }
            boolean r12 = r11.isEmpty()     // Catch:{ IOException -> 0x02a0 }
            if (r12 != 0) goto L_0x0162
            java.util.Iterator r12 = r11.iterator()     // Catch:{ IOException -> 0x02a0 }
        L_0x014e:
            boolean r13 = r12.hasNext()     // Catch:{ IOException -> 0x02a0 }
            if (r13 == 0) goto L_0x0162
            java.lang.Object r13 = r12.next()     // Catch:{ IOException -> 0x02a0 }
            com.google.android.gms.internal.ads.zzajv r13 = (com.google.android.gms.internal.ads.zzajv) r13     // Catch:{ IOException -> 0x02a0 }
            java.lang.String r13 = r13.zza()     // Catch:{ IOException -> 0x02a0 }
            r10.add(r13)     // Catch:{ IOException -> 0x02a0 }
            goto L_0x014e
        L_0x0162:
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ IOException -> 0x02a0 }
            r12.<init>(r11)     // Catch:{ IOException -> 0x02a0 }
            java.util.List r11 = r0.zzh     // Catch:{ IOException -> 0x02a0 }
            if (r11 == 0) goto L_0x0191
            boolean r11 = r11.isEmpty()     // Catch:{ IOException -> 0x02a0 }
            if (r11 != 0) goto L_0x01ce
            java.util.List r11 = r0.zzh     // Catch:{ IOException -> 0x02a0 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ IOException -> 0x02a0 }
        L_0x0177:
            boolean r13 = r11.hasNext()     // Catch:{ IOException -> 0x02a0 }
            if (r13 == 0) goto L_0x01ce
            java.lang.Object r13 = r11.next()     // Catch:{ IOException -> 0x02a0 }
            com.google.android.gms.internal.ads.zzajv r13 = (com.google.android.gms.internal.ads.zzajv) r13     // Catch:{ IOException -> 0x02a0 }
            java.lang.String r14 = r13.zza()     // Catch:{ IOException -> 0x02a0 }
            boolean r14 = r10.contains(r14)     // Catch:{ IOException -> 0x02a0 }
            if (r14 != 0) goto L_0x0177
            r12.add(r13)     // Catch:{ IOException -> 0x02a0 }
            goto L_0x0177
        L_0x0191:
            java.util.Map r11 = r0.zzg     // Catch:{ IOException -> 0x02a0 }
            boolean r11 = r11.isEmpty()     // Catch:{ IOException -> 0x02a0 }
            if (r11 != 0) goto L_0x01ce
            java.util.Map r11 = r0.zzg     // Catch:{ IOException -> 0x02a0 }
            java.util.Set r11 = r11.entrySet()     // Catch:{ IOException -> 0x02a0 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ IOException -> 0x02a0 }
        L_0x01a3:
            boolean r13 = r11.hasNext()     // Catch:{ IOException -> 0x02a0 }
            if (r13 == 0) goto L_0x01ce
            java.lang.Object r13 = r11.next()     // Catch:{ IOException -> 0x02a0 }
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13     // Catch:{ IOException -> 0x02a0 }
            java.lang.Object r14 = r13.getKey()     // Catch:{ IOException -> 0x02a0 }
            boolean r14 = r10.contains(r14)     // Catch:{ IOException -> 0x02a0 }
            if (r14 != 0) goto L_0x01a3
            com.google.android.gms.internal.ads.zzajv r14 = new com.google.android.gms.internal.ads.zzajv     // Catch:{ IOException -> 0x02a0 }
            java.lang.Object r15 = r13.getKey()     // Catch:{ IOException -> 0x02a0 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ IOException -> 0x02a0 }
            java.lang.Object r13 = r13.getValue()     // Catch:{ IOException -> 0x02a0 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ IOException -> 0x02a0 }
            r14.<init>(r15, r13)     // Catch:{ IOException -> 0x02a0 }
            r12.add(r14)     // Catch:{ IOException -> 0x02a0 }
            goto L_0x01a3
        L_0x01ce:
            com.google.android.gms.internal.ads.zzajz r10 = new com.google.android.gms.internal.ads.zzajz     // Catch:{ IOException -> 0x02a0 }
            r17 = 304(0x130, float:4.26E-43)
            byte[] r0 = r0.zza     // Catch:{ IOException -> 0x02a0 }
            r19 = 1
            r16 = r10
            r18 = r0
            r22 = r12
            r16.<init>((int) r17, (byte[]) r18, (boolean) r19, (long) r20, (java.util.List) r22)     // Catch:{ IOException -> 0x02a0 }
            r0 = r10
        L_0x01e0:
            return r0
        L_0x01e1:
            java.io.InputStream r12 = r6.zzc()     // Catch:{ IOException -> 0x02a0 }
            if (r12 == 0) goto L_0x022c
            int r13 = r6.zza()     // Catch:{ IOException -> 0x02a0 }
            r14 = r23
            com.google.android.gms.internal.ads.zzaku r15 = r14.zza     // Catch:{ IOException -> 0x029e }
            com.google.android.gms.internal.ads.zzalh r8 = new com.google.android.gms.internal.ads.zzalh     // Catch:{ IOException -> 0x029e }
            r8.<init>(r15, r13)     // Catch:{ IOException -> 0x029e }
            r13 = 1024(0x400, float:1.435E-42)
            byte[] r13 = r15.zzb(r13)     // Catch:{ all -> 0x021a }
        L_0x01fa:
            int r7 = r12.read(r13)     // Catch:{ all -> 0x0218 }
            if (r7 == r10) goto L_0x0204
            r8.write(r13, r9, r7)     // Catch:{ all -> 0x0218 }
            goto L_0x01fa
        L_0x0204:
            byte[] r7 = r8.toByteArray()     // Catch:{ all -> 0x0218 }
            r12.close()     // Catch:{ IOException -> 0x020c }
            goto L_0x0211
        L_0x020c:
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ IOException -> 0x029e }
            com.google.android.gms.internal.ads.zzakp.zzd(r2, r10)     // Catch:{ IOException -> 0x029e }
        L_0x0211:
            r15.zza(r13)     // Catch:{ IOException -> 0x029e }
            r8.close()     // Catch:{ IOException -> 0x029e }
            goto L_0x0230
        L_0x0218:
            r0 = move-exception
            goto L_0x021c
        L_0x021a:
            r0 = move-exception
            r13 = 0
        L_0x021c:
            r12.close()     // Catch:{ IOException -> 0x0220 }
            goto L_0x0225
        L_0x0220:
            java.lang.Object[] r7 = new java.lang.Object[r9]     // Catch:{ IOException -> 0x029e }
            com.google.android.gms.internal.ads.zzakp.zzd(r2, r7)     // Catch:{ IOException -> 0x029e }
        L_0x0225:
            r15.zza(r13)     // Catch:{ IOException -> 0x029e }
            r8.close()     // Catch:{ IOException -> 0x029e }
            throw r0     // Catch:{ IOException -> 0x029e }
        L_0x022c:
            r14 = r23
            byte[] r7 = new byte[r9]     // Catch:{ IOException -> 0x029e }
        L_0x0230:
            long r12 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x029a }
            long r12 = r12 - r4
            boolean r8 = com.google.android.gms.internal.ads.zzakp.zzb     // Catch:{ IOException -> 0x029a }
            if (r8 != 0) goto L_0x0243
            r16 = 3000(0xbb8, double:1.482E-320)
            int r8 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r8 <= 0) goto L_0x0240
            goto L_0x0243
        L_0x0240:
            r8 = 200(0xc8, float:2.8E-43)
            goto L_0x0278
        L_0x0243:
            java.lang.String r8 = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]"
            r10 = 5
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ IOException -> 0x029a }
            r10[r9] = r1     // Catch:{ IOException -> 0x029a }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ IOException -> 0x029a }
            r13 = 1
            r10[r13] = r12     // Catch:{ IOException -> 0x029a }
            if (r7 == 0) goto L_0x0259
            int r12 = r7.length     // Catch:{ IOException -> 0x029a }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ IOException -> 0x029a }
            goto L_0x025b
        L_0x0259:
            java.lang.String r12 = "null"
        L_0x025b:
            r13 = 2
            r10[r13] = r12     // Catch:{ IOException -> 0x029a }
            r12 = 3
            java.lang.Integer r13 = java.lang.Integer.valueOf(r0)     // Catch:{ IOException -> 0x029a }
            r10[r12] = r13     // Catch:{ IOException -> 0x029a }
            r12 = 4
            com.google.android.gms.internal.ads.zzajr r13 = r24.zzy()     // Catch:{ IOException -> 0x029a }
            int r13 = r13.zza()     // Catch:{ IOException -> 0x029a }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ IOException -> 0x029a }
            r10[r12] = r13     // Catch:{ IOException -> 0x029a }
            com.google.android.gms.internal.ads.zzakp.zza(r8, r10)     // Catch:{ IOException -> 0x029a }
            goto L_0x0240
        L_0x0278:
            if (r0 < r8) goto L_0x0294
            r8 = 299(0x12b, float:4.19E-43)
            if (r0 > r8) goto L_0x0294
            com.google.android.gms.internal.ads.zzajz r8 = new com.google.android.gms.internal.ads.zzajz     // Catch:{ IOException -> 0x029a }
            r19 = 0
            long r12 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x029a }
            long r20 = r12 - r4
            r16 = r8
            r17 = r0
            r18 = r7
            r22 = r11
            r16.<init>((int) r17, (byte[]) r18, (boolean) r19, (long) r20, (java.util.List) r22)     // Catch:{ IOException -> 0x029a }
            return r8
        L_0x0294:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x029a }
            r0.<init>()     // Catch:{ IOException -> 0x029a }
            throw r0     // Catch:{ IOException -> 0x029a }
        L_0x029a:
            r0 = move-exception
            r18 = r7
            goto L_0x02c2
        L_0x029e:
            r0 = move-exception
            goto L_0x02c0
        L_0x02a0:
            r0 = move-exception
            r14 = r23
            goto L_0x02c0
        L_0x02a4:
            r14 = r23
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x02ae }
            java.lang.String r6 = "Could not retrieve response code from HttpUrlConnection."
            r0.<init>(r6)     // Catch:{ all -> 0x02ae }
            throw r0     // Catch:{ all -> 0x02ae }
        L_0x02ae:
            r0 = move-exception
            goto L_0x02b3
        L_0x02b0:
            r0 = move-exception
            r14 = r23
        L_0x02b3:
            r7 = r9
        L_0x02b4:
            if (r7 != 0) goto L_0x02b9
            r11.disconnect()     // Catch:{ IOException -> 0x02ba }
        L_0x02b9:
            throw r0     // Catch:{ IOException -> 0x02ba }
        L_0x02ba:
            r0 = move-exception
            goto L_0x02bf
        L_0x02bc:
            r0 = move-exception
            r14 = r23
        L_0x02bf:
            r6 = 0
        L_0x02c0:
            r18 = 0
        L_0x02c2:
            boolean r7 = r0 instanceof java.net.SocketTimeoutException
            if (r7 == 0) goto L_0x02d6
            com.google.android.gms.internal.ads.zzalg r0 = new com.google.android.gms.internal.ads.zzalg
            com.google.android.gms.internal.ads.zzakl r6 = new com.google.android.gms.internal.ads.zzakl
            r6.<init>()
            java.lang.String r7 = "socket"
            r8 = 0
            r0.<init>(r7, r6, r8)
        L_0x02d3:
            r6 = r0
            goto L_0x0345
        L_0x02d6:
            boolean r7 = r0 instanceof java.net.MalformedURLException
            if (r7 != 0) goto L_0x0390
            if (r6 == 0) goto L_0x038a
            int r0 = r6.zzb()
            r7 = 2
            java.lang.Object[] r8 = new java.lang.Object[r7]
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
            r8[r9] = r7
            java.lang.String r7 = r24.zzk()
            r10 = 1
            r8[r10] = r7
            java.lang.String r7 = "Unexpected response code %d for %s"
            com.google.android.gms.internal.ads.zzakp.zzb(r7, r8)
            if (r18 == 0) goto L_0x0337
            java.util.List r22 = r6.zzd()
            com.google.android.gms.internal.ads.zzajz r6 = new com.google.android.gms.internal.ads.zzajz
            r19 = 0
            long r7 = android.os.SystemClock.elapsedRealtime()
            long r20 = r7 - r4
            r16 = r6
            r17 = r0
            r16.<init>((int) r17, (byte[]) r18, (boolean) r19, (long) r20, (java.util.List) r22)
            r7 = 401(0x191, float:5.62E-43)
            if (r0 == r7) goto L_0x0329
            r7 = 403(0x193, float:5.65E-43)
            if (r0 != r7) goto L_0x0315
            goto L_0x0329
        L_0x0315:
            r1 = 400(0x190, float:5.6E-43)
            if (r0 < r1) goto L_0x0323
            r1 = 499(0x1f3, float:6.99E-43)
            if (r0 > r1) goto L_0x0323
            com.google.android.gms.internal.ads.zzajq r0 = new com.google.android.gms.internal.ads.zzajq
            r0.<init>(r6)
            throw r0
        L_0x0323:
            com.google.android.gms.internal.ads.zzakk r0 = new com.google.android.gms.internal.ads.zzakk
            r0.<init>(r6)
            throw r0
        L_0x0329:
            com.google.android.gms.internal.ads.zzalg r0 = new com.google.android.gms.internal.ads.zzalg
            com.google.android.gms.internal.ads.zzajl r7 = new com.google.android.gms.internal.ads.zzajl
            r7.<init>(r6)
            java.lang.String r6 = "auth"
            r8 = 0
            r0.<init>(r6, r7, r8)
            goto L_0x02d3
        L_0x0337:
            r8 = 0
            com.google.android.gms.internal.ads.zzalg r0 = new com.google.android.gms.internal.ads.zzalg
            com.google.android.gms.internal.ads.zzajy r6 = new com.google.android.gms.internal.ads.zzajy
            r6.<init>()
            java.lang.String r7 = "network"
            r0.<init>(r7, r6, r8)
            goto L_0x02d3
        L_0x0345:
            com.google.android.gms.internal.ads.zzajr r0 = r24.zzy()
            int r7 = r24.zzb()
            com.google.android.gms.internal.ads.zzakm r8 = r6.zzb     // Catch:{ zzakm -> 0x036f }
            r0.zzc(r8)     // Catch:{ zzakm -> 0x036f }
            r8 = 2
            java.lang.Object[] r0 = new java.lang.Object[r8]
            java.lang.String r6 = r6.zza
            r0[r9] = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            r7 = 1
            r0[r7] = r6
            java.lang.String r6 = "%s-retry [timeout=%s]"
            java.lang.String r0 = java.lang.String.format(r6, r0)
            r1.zzm(r0)
            goto L_0x000a
        L_0x036f:
            r0 = move-exception
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = r6.zza
            r2[r9] = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            r4 = 1
            r2[r4] = r3
            java.lang.String r3 = "%s-timeout-giveup [timeout=%s]"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            r1.zzm(r2)
            throw r0
        L_0x038a:
            com.google.android.gms.internal.ads.zzaka r1 = new com.google.android.gms.internal.ads.zzaka
            r1.<init>(r0)
            throw r1
        L_0x0390:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r1 = r24.zzk()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r3 = "Bad URL "
            java.lang.String r1 = r3.concat(r1)
            r2.<init>(r1, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaks.zza(com.google.android.gms.internal.ads.zzakd):com.google.android.gms.internal.ads.zzajz");
    }
}
