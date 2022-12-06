package com.google.android.gms.internal;

import com.google.android.gms.internal.zzb;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

public class zzt implements zzf {
    protected static final boolean DEBUG = zzs.DEBUG;
    private static int zzan = 3000;
    private static int zzao = 4096;
    protected final zzy zzap;
    protected final zzu zzaq;

    public zzt(zzy zzy) {
        this(zzy, new zzu(zzao));
    }

    public zzt(zzy zzy, zzu zzu) {
        this.zzap = zzy;
        this.zzaq = zzu;
    }

    protected static Map<String, String> zza(Header[] headerArr) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }

    private void zza(long j, zzk<?> zzk, byte[] bArr, StatusLine statusLine) {
        if (DEBUG || j > ((long) zzan)) {
            Object[] objArr = new Object[5];
            objArr[0] = zzk;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(zzk.zzt().zzd());
            zzs.zzb("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    private static void zza(String str, zzk<?> zzk, zzr zzr) throws zzr {
        zzo zzt = zzk.zzt();
        int zzs = zzk.zzs();
        try {
            zzt.zza(zzr);
            zzk.zzc(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(zzs)}));
        } catch (zzr e) {
            zzk.zzc(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(zzs)}));
            throw e;
        }
    }

    private void zza(Map<String, String> map, zzb.zza zza) {
        if (zza != null) {
            if (zza.zza != null) {
                map.put("If-None-Match", zza.zza);
            }
            if (zza.zzc > 0) {
                map.put("If-Modified-Since", DateUtils.formatDate(new Date(zza.zzc)));
            }
        }
    }

    private byte[] zza(HttpEntity httpEntity) throws IOException, zzp {
        zzaa zzaa = new zzaa(this.zzaq, (int) httpEntity.getContentLength());
        byte[] bArr = null;
        try {
            InputStream content = httpEntity.getContent();
            if (content != null) {
                bArr = this.zzaq.zzb(1024);
                while (true) {
                    int read = content.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    zzaa.write(bArr, 0, read);
                }
                return zzaa.toByteArray();
            }
            throw new zzp();
        } finally {
            try {
                httpEntity.consumeContent();
            } catch (IOException unused) {
                zzs.zza("Error occured when calling consumingContent", new Object[0]);
            }
            this.zzaq.zza(bArr);
            zzaa.close();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ba, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00bc, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00bd, code lost:
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00be, code lost:
        r17 = r1;
        r16 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c4, code lost:
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c7, code lost:
        r17 = r1;
        r16 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00cc, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00cd, code lost:
        r17 = r1;
        r13 = null;
        r16 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d4, code lost:
        r0 = r13.getStatusLine().getStatusCode();
        com.google.android.gms.internal.zzs.zzc("Unexpected response code %d for %s", java.lang.Integer.valueOf(r0), r24.getUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f1, code lost:
        if (r16 != null) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f3, code lost:
        r14 = new com.google.android.gms.internal.zzi(r0, r16, r17, false, android.os.SystemClock.elapsedRealtime() - r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0104, code lost:
        if (r0 == 401) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0110, code lost:
        throw new com.google.android.gms.internal.zzp(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0111, code lost:
        r0 = new com.google.android.gms.internal.zza(r14);
        r1 = "auth";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x011e, code lost:
        throw new com.google.android.gms.internal.zzh((com.google.android.gms.internal.zzi) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0124, code lost:
        throw new com.google.android.gms.internal.zzj(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0125, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0126, code lost:
        r3 = java.lang.String.valueOf(r24.getUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0136, code lost:
        if (r3.length() != 0) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0138, code lost:
        r2 = "Bad URL ".concat(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x013d, code lost:
        r2 = new java.lang.String("Bad URL ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0146, code lost:
        throw new java.lang.RuntimeException(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0147, code lost:
        r0 = new com.google.android.gms.internal.zzq();
        r1 = "connection";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x014f, code lost:
        r0 = new com.google.android.gms.internal.zzq();
        r1 = "socket";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0125 A[ExcHandler: MalformedURLException (r0v3 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:2:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[ExcHandler: ConnectTimeoutException (unused org.apache.http.conn.ConnectTimeoutException), SYNTHETIC, Splitter:B:2:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), SYNTHETIC, Splitter:B:2:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x011f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzi zza(com.google.android.gms.internal.zzk<?> r24) throws com.google.android.gms.internal.zzr {
        /*
            r23 = this;
            r7 = r23
            r8 = r24
            long r9 = android.os.SystemClock.elapsedRealtime()
        L_0x0008:
            java.util.Map r1 = java.util.Collections.emptyMap()
            r11 = 0
            r12 = 0
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x00cc }
            r0.<init>()     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x00cc }
            com.google.android.gms.internal.zzb$zza r2 = r24.zzh()     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x00cc }
            r7.zza(r0, r2)     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x00cc }
            com.google.android.gms.internal.zzy r2 = r7.zzap     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x00cc }
            org.apache.http.HttpResponse r13 = r2.zza(r8, r0)     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x00cc }
            org.apache.http.StatusLine r6 = r13.getStatusLine()     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x00c6 }
            int r15 = r6.getStatusCode()     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x00c6 }
            org.apache.http.Header[] r0 = r13.getAllHeaders()     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x00c6 }
            java.util.Map r14 = zza((org.apache.http.Header[]) r0)     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x00c6 }
            r0 = 304(0x130, float:4.26E-43)
            if (r15 != r0) goto L_0x0075
            com.google.android.gms.internal.zzb$zza r0 = r24.zzh()     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x006e }
            if (r0 != 0) goto L_0x0050
            com.google.android.gms.internal.zzi r0 = new com.google.android.gms.internal.zzi     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x006e }
            r17 = 304(0x130, float:4.26E-43)
            r18 = 0
            r20 = 1
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x006e }
            long r21 = r1 - r9
            r16 = r0
            r19 = r14
            r16.<init>(r17, r18, r19, r20, r21)     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x006e }
            return r0
        L_0x0050:
            java.util.Map<java.lang.String, java.lang.String> r1 = r0.zzf     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x006e }
            r1.putAll(r14)     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x006e }
            com.google.android.gms.internal.zzi r1 = new com.google.android.gms.internal.zzi     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x006e }
            r16 = 304(0x130, float:4.26E-43)
            byte[] r2 = r0.data     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x006e }
            java.util.Map<java.lang.String, java.lang.String> r0 = r0.zzf     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x006e }
            r19 = 1
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x006e }
            long r20 = r3 - r9
            r15 = r1
            r17 = r2
            r18 = r0
            r15.<init>(r16, r17, r18, r19, r20)     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x006e }
            return r1
        L_0x006e:
            r0 = move-exception
            r16 = r12
            r17 = r14
            goto L_0x00d2
        L_0x0075:
            org.apache.http.HttpEntity r0 = r13.getEntity()     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x00c3 }
            if (r0 == 0) goto L_0x0084
            org.apache.http.HttpEntity r0 = r13.getEntity()     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x006e }
            byte[] r0 = r7.zza((org.apache.http.HttpEntity) r0)     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x006e }
            goto L_0x0086
        L_0x0084:
            byte[] r0 = new byte[r11]     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x00c3 }
        L_0x0086:
            r21 = r0
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x00bc }
            long r2 = r0 - r9
            r1 = r23
            r4 = r24
            r5 = r21
            r1.zza(r2, r4, r5, r6)     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x00bc }
            r0 = 200(0xc8, float:2.8E-43)
            if (r15 < r0) goto L_0x00b3
            r0 = 299(0x12b, float:4.19E-43)
            if (r15 > r0) goto L_0x00b3
            com.google.android.gms.internal.zzi r0 = new com.google.android.gms.internal.zzi     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x00bc }
            r18 = 0
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x00bc }
            long r19 = r1 - r9
            r1 = r14
            r14 = r0
            r16 = r21
            r17 = r1
            r14.<init>(r15, r16, r17, r18, r19)     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x00ba }
            return r0
        L_0x00b3:
            r1 = r14
            java.io.IOException r0 = new java.io.IOException     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x00ba }
            r0.<init>()     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x00ba }
            throw r0     // Catch:{ SocketTimeoutException -> 0x014f, ConnectTimeoutException -> 0x0147, MalformedURLException -> 0x0125, IOException -> 0x00ba }
        L_0x00ba:
            r0 = move-exception
            goto L_0x00be
        L_0x00bc:
            r0 = move-exception
            r1 = r14
        L_0x00be:
            r17 = r1
            r16 = r21
            goto L_0x00d2
        L_0x00c3:
            r0 = move-exception
            r1 = r14
            goto L_0x00c7
        L_0x00c6:
            r0 = move-exception
        L_0x00c7:
            r17 = r1
            r16 = r12
            goto L_0x00d2
        L_0x00cc:
            r0 = move-exception
            r17 = r1
            r13 = r12
            r16 = r13
        L_0x00d2:
            if (r13 == 0) goto L_0x011f
            org.apache.http.StatusLine r0 = r13.getStatusLine()
            int r0 = r0.getStatusCode()
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r1[r11] = r2
            r2 = 1
            java.lang.String r3 = r24.getUrl()
            r1[r2] = r3
            java.lang.String r2 = "Unexpected response code %d for %s"
            com.google.android.gms.internal.zzs.zzc(r2, r1)
            if (r16 == 0) goto L_0x0119
            com.google.android.gms.internal.zzi r1 = new com.google.android.gms.internal.zzi
            r18 = 0
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r19 = r2 - r9
            r14 = r1
            r15 = r0
            r14.<init>(r15, r16, r17, r18, r19)
            r2 = 401(0x191, float:5.62E-43)
            if (r0 == r2) goto L_0x0111
            r2 = 403(0x193, float:5.65E-43)
            if (r0 != r2) goto L_0x010b
            goto L_0x0111
        L_0x010b:
            com.google.android.gms.internal.zzp r0 = new com.google.android.gms.internal.zzp
            r0.<init>(r1)
            throw r0
        L_0x0111:
            com.google.android.gms.internal.zza r0 = new com.google.android.gms.internal.zza
            r0.<init>(r1)
            java.lang.String r1 = "auth"
            goto L_0x0156
        L_0x0119:
            com.google.android.gms.internal.zzh r0 = new com.google.android.gms.internal.zzh
            r0.<init>((com.google.android.gms.internal.zzi) r12)
            throw r0
        L_0x011f:
            com.google.android.gms.internal.zzj r1 = new com.google.android.gms.internal.zzj
            r1.<init>(r0)
            throw r1
        L_0x0125:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Bad URL "
            java.lang.String r3 = r24.getUrl()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r4 = r3.length()
            if (r4 == 0) goto L_0x013d
            java.lang.String r2 = r2.concat(r3)
            goto L_0x0143
        L_0x013d:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r2)
            r2 = r3
        L_0x0143:
            r1.<init>(r2, r0)
            throw r1
        L_0x0147:
            com.google.android.gms.internal.zzq r0 = new com.google.android.gms.internal.zzq
            r0.<init>()
            java.lang.String r1 = "connection"
            goto L_0x0156
        L_0x014f:
            com.google.android.gms.internal.zzq r0 = new com.google.android.gms.internal.zzq
            r0.<init>()
            java.lang.String r1 = "socket"
        L_0x0156:
            zza(r1, r8, r0)
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzt.zza(com.google.android.gms.internal.zzk):com.google.android.gms.internal.zzi");
    }
}
