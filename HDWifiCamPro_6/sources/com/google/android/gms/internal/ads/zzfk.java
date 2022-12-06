package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfk extends zzer implements zzfu {
    private final boolean zzb;
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final zzft zzf;
    private final zzft zzg;
    private zzfc zzh;
    private HttpURLConnection zzi;
    private InputStream zzj;
    private boolean zzk;
    private int zzl;
    private long zzm;
    private long zzn;

    @Deprecated
    public zzfk() {
        this((String) null, 8000, 8000, false, (zzft) null, (zzfsy) null, false);
    }

    /* synthetic */ zzfk(String str, int i, int i2, boolean z, zzft zzft, zzfsy zzfsy, boolean z2, zzfj zzfj) {
        this(str, i, i2, z, zzft, (zzfsy) null, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.net.HttpURLConnection zzk(java.net.URL r3, int r4, byte[] r5, long r6, long r8, boolean r10, boolean r11, java.util.Map r12) throws java.io.IOException {
        /*
            r2 = this;
            java.net.URLConnection r3 = r3.openConnection()
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3
            int r4 = r2.zzc
            r3.setConnectTimeout(r4)
            int r4 = r2.zzd
            r3.setReadTimeout(r4)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            com.google.android.gms.internal.ads.zzft r5 = r2.zzf
            java.util.Map r5 = r5.zza()
            r4.putAll(r5)
            com.google.android.gms.internal.ads.zzft r5 = r2.zzg
            java.util.Map r5 = r5.zza()
            r4.putAll(r5)
            r4.putAll(r12)
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0032:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x004e
            java.lang.Object r5 = r4.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r12 = r5.getKey()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            r3.setRequestProperty(r12, r5)
            goto L_0x0032
        L_0x004e:
            r4 = 0
            int r12 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            r0 = -1
            if (r12 != 0) goto L_0x005c
            int r6 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r6 != 0) goto L_0x005d
            r4 = 0
            goto L_0x007c
        L_0x005c:
            r4 = r6
        L_0x005d:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "bytes="
            r6.append(r7)
            r6.append(r4)
            java.lang.String r7 = "-"
            r6.append(r7)
            int r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r7 == 0) goto L_0x0078
            long r4 = r4 + r8
            long r4 = r4 + r0
            r6.append(r4)
        L_0x0078:
            java.lang.String r4 = r6.toString()
        L_0x007c:
            if (r4 == 0) goto L_0x0083
            java.lang.String r5 = "Range"
            r3.setRequestProperty(r5, r4)
        L_0x0083:
            java.lang.String r4 = r2.zze
            if (r4 == 0) goto L_0x008c
            java.lang.String r5 = "User-Agent"
            r3.setRequestProperty(r5, r4)
        L_0x008c:
            r4 = 1
            if (r4 == r10) goto L_0x0092
            java.lang.String r5 = "identity"
            goto L_0x0094
        L_0x0092:
            java.lang.String r5 = "gzip"
        L_0x0094:
            java.lang.String r6 = "Accept-Encoding"
            r3.setRequestProperty(r6, r5)
            r3.setInstanceFollowRedirects(r11)
            r5 = 0
            r3.setDoOutput(r5)
            java.lang.String r4 = com.google.android.gms.internal.ads.zzfc.zza(r4)
            r3.setRequestMethod(r4)
            r3.connect()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfk.zzk(java.net.URL, int, byte[], long, long, boolean, boolean, java.util.Map):java.net.HttpURLConnection");
    }

    private final URL zzl(URL url, String str, zzfc zzfc) throws zzfq {
        if (str != null) {
            try {
                URL url2 = new URL(url, str);
                String protocol = url2.getProtocol();
                if (!"https".equals(protocol) && !"http".equals(protocol)) {
                    throw new zzfq("Unsupported protocol redirect: ".concat(String.valueOf(protocol)), zzfc, 2001, 1);
                } else if (this.zzb || protocol.equals(url.getProtocol())) {
                    return url2;
                } else {
                    String protocol2 = url.getProtocol();
                    throw new zzfq("Disallowed cross-protocol redirect (" + protocol2 + " to " + protocol + ")", zzfc, 2001, 1);
                }
            } catch (MalformedURLException e) {
                throw new zzfq((IOException) e, zzfc, 2001, 1);
            }
        } else {
            throw new zzfq("Null location redirect", zzfc, 2001, 1);
        }
    }

    private final void zzm() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                zzdw.zzc("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.zzi = null;
        }
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzfq {
        if (i2 == 0) {
            return 0;
        }
        try {
            long j = this.zzm;
            if (j != -1) {
                long j2 = j - this.zzn;
                if (j2 == 0) {
                    return -1;
                }
                i2 = (int) Math.min((long) i2, j2);
            }
            InputStream inputStream = this.zzj;
            int i3 = zzen.zza;
            int read = inputStream.read(bArr, i, i2);
            if (read == -1) {
                return -1;
            }
            this.zzn += (long) read;
            zzg(read);
            return read;
        } catch (IOException e) {
            zzfc zzfc = this.zzh;
            int i4 = zzen.zza;
            throw zzfq.zza(e, zzfc, 2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ba, code lost:
        if (r8 != 0) goto L_0x00be;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzb(com.google.android.gms.internal.ads.zzfc r25) throws com.google.android.gms.internal.ads.zzfq {
        /*
            r24 = this;
            r12 = r24
            r13 = r25
            r12.zzh = r13
            r14 = 0
            r12.zzn = r14
            r12.zzm = r14
            r24.zzi(r25)
            r11 = 1
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x01f9 }
            android.net.Uri r0 = r13.zza     // Catch:{ IOException -> 0x01f9 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x01f9 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x01f9 }
            int r0 = r13.zzb     // Catch:{ IOException -> 0x01f9 }
            byte[] r0 = r13.zzc     // Catch:{ IOException -> 0x01f9 }
            long r9 = r13.zzf     // Catch:{ IOException -> 0x01f9 }
            long r7 = r13.zzg     // Catch:{ IOException -> 0x01f9 }
            boolean r0 = r13.zzb(r11)     // Catch:{ IOException -> 0x01f9 }
            boolean r1 = r12.zzb     // Catch:{ IOException -> 0x01f9 }
            r5 = 0
            if (r1 != 0) goto L_0x0045
            r3 = 1
            r4 = 0
            r16 = 1
            java.util.Map r6 = r13.zzd     // Catch:{ IOException -> 0x01f9 }
            r1 = r24
            r17 = r6
            r5 = r9
            r9 = r0
            r10 = r16
            r11 = r17
            java.net.HttpURLConnection r0 = r1.zzk(r2, r3, r4, r5, r7, r9, r10, r11)     // Catch:{ IOException -> 0x0041 }
            goto L_0x008f
        L_0x0041:
            r0 = move-exception
            r5 = 1
            goto L_0x01fb
        L_0x0045:
            r11 = r2
            r1 = 0
        L_0x0047:
            int r5 = r1 + 1
            r2 = 20
            if (r1 > r2) goto L_0x01d4
            r3 = 1
            r4 = 0
            r16 = 0
            java.util.Map r6 = r13.zzd     // Catch:{ IOException -> 0x0041 }
            r1 = r24
            r2 = r11
            r18 = r5
            r17 = r6
            r5 = r9
            r19 = r7
            r21 = r9
            r9 = r0
            r10 = r16
            r23 = r11
            r11 = r17
            java.net.HttpURLConnection r1 = r1.zzk(r2, r3, r4, r5, r7, r9, r10, r11)     // Catch:{ IOException -> 0x0041 }
            int r2 = r1.getResponseCode()     // Catch:{ IOException -> 0x0041 }
            java.lang.String r3 = "Location"
            java.lang.String r3 = r1.getHeaderField(r3)     // Catch:{ IOException -> 0x0041 }
            r4 = 300(0x12c, float:4.2E-43)
            if (r2 == r4) goto L_0x01c1
            r4 = 301(0x12d, float:4.22E-43)
            if (r2 == r4) goto L_0x01c1
            r4 = 302(0x12e, float:4.23E-43)
            if (r2 == r4) goto L_0x01c1
            r4 = 303(0x12f, float:4.25E-43)
            if (r2 == r4) goto L_0x01c1
            r4 = 307(0x133, float:4.3E-43)
            if (r2 == r4) goto L_0x01c1
            r4 = 308(0x134, float:4.32E-43)
            if (r2 != r4) goto L_0x008e
            goto L_0x01c1
        L_0x008e:
            r0 = r1
        L_0x008f:
            r12.zzi = r0     // Catch:{ IOException -> 0x0041 }
            java.net.HttpURLConnection r0 = r12.zzi     // Catch:{ IOException -> 0x0041 }
            int r1 = r0.getResponseCode()     // Catch:{ IOException -> 0x0041 }
            r12.zzl = r1     // Catch:{ IOException -> 0x0041 }
            java.lang.String r3 = r0.getResponseMessage()     // Catch:{ IOException -> 0x0041 }
            int r1 = r12.zzl
            r2 = 2008(0x7d8, float:2.814E-42)
            java.lang.String r4 = "Content-Range"
            r5 = 200(0xc8, float:2.8E-43)
            r6 = -1
            if (r1 < r5) goto L_0x0169
            r8 = 299(0x12b, float:4.19E-43)
            if (r1 <= r8) goto L_0x00af
            goto L_0x0169
        L_0x00af:
            r0.getContentType()
            int r1 = r12.zzl
            if (r1 != r5) goto L_0x00bd
            long r8 = r13.zzf
            int r1 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r1 == 0) goto L_0x00bd
            goto L_0x00be
        L_0x00bd:
            r8 = r14
        L_0x00be:
            java.lang.String r1 = "Content-Encoding"
            java.lang.String r1 = r0.getHeaderField(r1)
            java.lang.String r3 = "gzip"
            boolean r1 = r3.equalsIgnoreCase(r1)
            if (r1 != 0) goto L_0x00ec
            long r10 = r13.zzg
            int r3 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r3 == 0) goto L_0x00d5
            r12.zzm = r10
            goto L_0x00f0
        L_0x00d5:
            java.lang.String r3 = "Content-Length"
            java.lang.String r3 = r0.getHeaderField(r3)
            java.lang.String r4 = r0.getHeaderField(r4)
            long r3 = com.google.android.gms.internal.ads.zzfv.zza(r3, r4)
            int r5 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r5 == 0) goto L_0x00e9
            long r6 = r3 - r8
        L_0x00e9:
            r12.zzm = r6
            goto L_0x00f0
        L_0x00ec:
            long r3 = r13.zzg
            r12.zzm = r3
        L_0x00f0:
            r3 = 2000(0x7d0, float:2.803E-42)
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x015e }
            r12.zzj = r0     // Catch:{ IOException -> 0x015e }
            if (r1 == 0) goto L_0x0103
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x015e }
            java.io.InputStream r1 = r12.zzj     // Catch:{ IOException -> 0x015e }
            r0.<init>(r1)     // Catch:{ IOException -> 0x015e }
            r12.zzj = r0     // Catch:{ IOException -> 0x015e }
        L_0x0103:
            r5 = 1
            r12.zzk = r5
            r24.zzj(r25)
            int r0 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r0 != 0) goto L_0x010e
            goto L_0x014a
        L_0x010e:
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch:{ IOException -> 0x014d }
        L_0x0112:
            int r1 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r1 <= 0) goto L_0x014a
            r6 = 4096(0x1000, double:2.0237E-320)
            long r6 = java.lang.Math.min(r8, r6)     // Catch:{ IOException -> 0x014d }
            int r1 = (int) r6     // Catch:{ IOException -> 0x014d }
            java.io.InputStream r4 = r12.zzj     // Catch:{ IOException -> 0x014d }
            int r6 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ IOException -> 0x014d }
            r6 = 0
            int r1 = r4.read(r0, r6, r1)     // Catch:{ IOException -> 0x014d }
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ IOException -> 0x014d }
            boolean r4 = r4.isInterrupted()     // Catch:{ IOException -> 0x014d }
            if (r4 != 0) goto L_0x013f
            r4 = -1
            if (r1 == r4) goto L_0x0139
            long r10 = (long) r1     // Catch:{ IOException -> 0x014d }
            long r8 = r8 - r10
            r12.zzg(r1)     // Catch:{ IOException -> 0x014d }
            goto L_0x0112
        L_0x0139:
            com.google.android.gms.internal.ads.zzfq r0 = new com.google.android.gms.internal.ads.zzfq     // Catch:{ IOException -> 0x014d }
            r0.<init>(r13, r2, r5)     // Catch:{ IOException -> 0x014d }
            throw r0     // Catch:{ IOException -> 0x014d }
        L_0x013f:
            com.google.android.gms.internal.ads.zzfq r0 = new com.google.android.gms.internal.ads.zzfq     // Catch:{ IOException -> 0x014d }
            java.io.InterruptedIOException r1 = new java.io.InterruptedIOException     // Catch:{ IOException -> 0x014d }
            r1.<init>()     // Catch:{ IOException -> 0x014d }
            r0.<init>((java.io.IOException) r1, (com.google.android.gms.internal.ads.zzfc) r13, (int) r3, (int) r5)     // Catch:{ IOException -> 0x014d }
            throw r0     // Catch:{ IOException -> 0x014d }
        L_0x014a:
            long r0 = r12.zzm
            return r0
        L_0x014d:
            r0 = move-exception
            r24.zzm()
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzfq
            if (r1 == 0) goto L_0x0158
            com.google.android.gms.internal.ads.zzfq r0 = (com.google.android.gms.internal.ads.zzfq) r0
            throw r0
        L_0x0158:
            com.google.android.gms.internal.ads.zzfq r1 = new com.google.android.gms.internal.ads.zzfq
            r1.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zzfc) r13, (int) r3, (int) r5)
            throw r1
        L_0x015e:
            r0 = move-exception
            r5 = 1
            r24.zzm()
            com.google.android.gms.internal.ads.zzfq r1 = new com.google.android.gms.internal.ads.zzfq
            r1.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zzfc) r13, (int) r3, (int) r5)
            throw r1
        L_0x0169:
            r5 = 1
            java.util.Map r8 = r0.getHeaderFields()
            int r1 = r12.zzl
            r9 = 416(0x1a0, float:5.83E-43)
            if (r1 != r9) goto L_0x0190
            java.lang.String r1 = r0.getHeaderField(r4)
            long r10 = com.google.android.gms.internal.ads.zzfv.zzb(r1)
            r4 = r3
            long r2 = r13.zzf
            int r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r2 != 0) goto L_0x0191
            r12.zzk = r5
            r24.zzj(r25)
            long r0 = r13.zzg
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x018f
            return r0
        L_0x018f:
            return r14
        L_0x0190:
            r4 = r3
        L_0x0191:
            java.io.InputStream r0 = r0.getErrorStream()
            if (r0 == 0) goto L_0x019c
            byte[] r0 = com.google.android.gms.internal.ads.zzen.zzab(r0)     // Catch:{ IOException -> 0x01a0 }
            goto L_0x019e
        L_0x019c:
            byte[] r0 = com.google.android.gms.internal.ads.zzen.zzf     // Catch:{ IOException -> 0x01a0 }
        L_0x019e:
            r7 = r0
            goto L_0x01a3
        L_0x01a0:
            byte[] r0 = com.google.android.gms.internal.ads.zzen.zzf
            goto L_0x019e
        L_0x01a3:
            r24.zzm()
            int r0 = r12.zzl
            if (r0 != r9) goto L_0x01b2
            com.google.android.gms.internal.ads.zzey r0 = new com.google.android.gms.internal.ads.zzey
            r1 = 2008(0x7d8, float:2.814E-42)
            r0.<init>(r1)
            goto L_0x01b3
        L_0x01b2:
            r0 = 0
        L_0x01b3:
            com.google.android.gms.internal.ads.zzfs r9 = new com.google.android.gms.internal.ads.zzfs
            int r2 = r12.zzl
            r1 = r9
            r3 = r4
            r4 = r0
            r5 = r8
            r6 = r25
            r1.<init>(r2, r3, r4, r5, r6, r7)
            throw r9
        L_0x01c1:
            r5 = 1
            r6 = 0
            r1.disconnect()     // Catch:{ IOException -> 0x01f7 }
            r2 = r23
            java.net.URL r11 = r12.zzl(r2, r3, r13)     // Catch:{ IOException -> 0x01f7 }
            r1 = r18
            r7 = r19
            r9 = r21
            goto L_0x0047
        L_0x01d4:
            r18 = r5
            r5 = 1
            com.google.android.gms.internal.ads.zzfq r0 = new com.google.android.gms.internal.ads.zzfq     // Catch:{ IOException -> 0x01f7 }
            java.net.NoRouteToHostException r1 = new java.net.NoRouteToHostException     // Catch:{ IOException -> 0x01f7 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01f7 }
            r2.<init>()     // Catch:{ IOException -> 0x01f7 }
            java.lang.String r3 = "Too many redirects: "
            r2.append(r3)     // Catch:{ IOException -> 0x01f7 }
            r3 = r18
            r2.append(r3)     // Catch:{ IOException -> 0x01f7 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x01f7 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x01f7 }
            r2 = 2001(0x7d1, float:2.804E-42)
            r0.<init>((java.io.IOException) r1, (com.google.android.gms.internal.ads.zzfc) r13, (int) r2, (int) r5)     // Catch:{ IOException -> 0x01f7 }
            throw r0     // Catch:{ IOException -> 0x01f7 }
        L_0x01f7:
            r0 = move-exception
            goto L_0x01fb
        L_0x01f9:
            r0 = move-exception
            r5 = r11
        L_0x01fb:
            r24.zzm()
            com.google.android.gms.internal.ads.zzfq r0 = com.google.android.gms.internal.ads.zzfq.zza(r0, r13, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfk.zzb(com.google.android.gms.internal.ads.zzfc):long");
    }

    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:4|(1:6)(1:7)|8|(3:10|11|(5:13|14|(2:16|(1:18))(2:19|(1:21))|22|(2:26|(1:28)(1:29))))|30|31) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x006c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd() throws com.google.android.gms.internal.ads.zzfq {
        /*
            r10 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r10.zzj     // Catch:{ all -> 0x008d }
            if (r2 == 0) goto L_0x007e
            long r3 = r10.zzm     // Catch:{ all -> 0x008d }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0010
            r3 = r5
            goto L_0x0013
        L_0x0010:
            long r7 = r10.zzn     // Catch:{ all -> 0x008d }
            long r3 = r3 - r7
        L_0x0013:
            java.net.HttpURLConnection r7 = r10.zzi     // Catch:{ all -> 0x008d }
            if (r7 == 0) goto L_0x006c
            int r8 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ all -> 0x008d }
            int r8 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ all -> 0x008d }
            r9 = 20
            if (r8 <= r9) goto L_0x0020
            goto L_0x006c
        L_0x0020:
            java.io.InputStream r7 = r7.getInputStream()     // Catch:{ Exception -> 0x006c }
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x0030
            int r3 = r7.read()     // Catch:{ Exception -> 0x006c }
            r4 = -1
            if (r3 == r4) goto L_0x006c
            goto L_0x0037
        L_0x0030:
            r5 = 2048(0x800, double:1.0118E-320)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x0037
            goto L_0x006c
        L_0x0037:
            java.lang.Class r3 = r7.getClass()     // Catch:{ Exception -> 0x006c }
            java.lang.String r3 = r3.getName()     // Catch:{ Exception -> 0x006c }
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x006c }
            if (r4 != 0) goto L_0x004f
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r4.equals(r3)     // Catch:{ Exception -> 0x006c }
            if (r3 == 0) goto L_0x006c
        L_0x004f:
            java.lang.Class r3 = r7.getClass()     // Catch:{ Exception -> 0x006c }
            java.lang.Class r3 = r3.getSuperclass()     // Catch:{ Exception -> 0x006c }
            if (r3 == 0) goto L_0x006b
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x006c }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x006c }
            r4 = 1
            r3.setAccessible(r4)     // Catch:{ Exception -> 0x006c }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x006c }
            r3.invoke(r7, r4)     // Catch:{ Exception -> 0x006c }
            goto L_0x006c
        L_0x006b:
            throw r0     // Catch:{ Exception -> 0x006c }
        L_0x006c:
            r2.close()     // Catch:{ IOException -> 0x0070 }
            goto L_0x007e
        L_0x0070:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzfq r3 = new com.google.android.gms.internal.ads.zzfq     // Catch:{ all -> 0x008d }
            com.google.android.gms.internal.ads.zzfc r4 = r10.zzh     // Catch:{ all -> 0x008d }
            int r5 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ all -> 0x008d }
            r5 = 2000(0x7d0, float:2.803E-42)
            r6 = 3
            r3.<init>((java.io.IOException) r2, (com.google.android.gms.internal.ads.zzfc) r4, (int) r5, (int) r6)     // Catch:{ all -> 0x008d }
            throw r3     // Catch:{ all -> 0x008d }
        L_0x007e:
            r10.zzj = r0
            r10.zzm()
            boolean r0 = r10.zzk
            if (r0 == 0) goto L_0x008c
            r10.zzk = r1
            r10.zzh()
        L_0x008c:
            return
        L_0x008d:
            r2 = move-exception
            r10.zzj = r0
            r10.zzm()
            boolean r0 = r10.zzk
            if (r0 == 0) goto L_0x009c
            r10.zzk = r1
            r10.zzh()
        L_0x009c:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfk.zzd():void");
    }

    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzi;
        return httpURLConnection == null ? zzfvq.zzd() : new zzfi(httpURLConnection.getHeaderFields());
    }

    private zzfk(String str, int i, int i2, boolean z, zzft zzft, zzfsy zzfsy, boolean z2) {
        super(true);
        this.zze = str;
        this.zzc = i;
        this.zzd = i2;
        this.zzb = z;
        this.zzf = zzft;
        this.zzg = new zzft();
    }
}
