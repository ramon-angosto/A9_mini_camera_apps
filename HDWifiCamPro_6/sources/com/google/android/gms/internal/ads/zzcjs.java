package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.util.zze;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcjs implements zzazv {
    private static final Pattern zzb = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference zzc = new AtomicReference();
    private final SSLSocketFactory zzd = new zzcjr(this);
    private final int zze;
    private final int zzf;
    private final String zzg;
    private final zzazu zzh;
    private final zzbab zzi;
    private zzazo zzj;
    private HttpURLConnection zzk;
    private InputStream zzl;
    private boolean zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    /* access modifiers changed from: private */
    public int zzr;
    private final Set zzs = new HashSet();

    zzcjs(String str, zzbab zzbab, int i, int i2, int i3) {
        zzbac.zzb(str);
        this.zzg = str;
        this.zzi = zzbab;
        this.zzh = new zzazu();
        this.zze = i;
        this.zzf = i2;
        this.zzr = i3;
    }

    private final void zzi() {
        HttpURLConnection httpURLConnection = this.zzk;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                zze.zzh("Unexpected error while disconnecting", e);
            }
            this.zzk = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f9, code lost:
        if (r4 != 0) goto L_0x00fe;
     */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x00df A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00dd A[Catch:{ IOException -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzb(com.google.android.gms.internal.ads.zzazo r20) throws com.google.android.gms.internal.ads.zzazs {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            java.lang.String r3 = "Unable to connect to "
            r1.zzj = r2
            r4 = 0
            r1.zzq = r4
            r1.zzp = r4
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x026b }
            android.net.Uri r7 = r2.zza     // Catch:{ IOException -> 0x026b }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x026b }
            r0.<init>(r7)     // Catch:{ IOException -> 0x026b }
            long r7 = r2.zzc     // Catch:{ IOException -> 0x026b }
            long r9 = r2.zzd     // Catch:{ IOException -> 0x026b }
            r12 = r0
            r0 = 0
        L_0x001f:
            int r13 = r0 + 1
            r14 = 20
            if (r0 > r14) goto L_0x0254
            java.net.URLConnection r0 = r12.openConnection()     // Catch:{ IOException -> 0x026b }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IOException -> 0x026b }
            boolean r14 = r0 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ IOException -> 0x026b }
            if (r14 == 0) goto L_0x0037
            r14 = r0
            javax.net.ssl.HttpsURLConnection r14 = (javax.net.ssl.HttpsURLConnection) r14     // Catch:{ IOException -> 0x026b }
            javax.net.ssl.SSLSocketFactory r15 = r1.zzd     // Catch:{ IOException -> 0x026b }
            r14.setSSLSocketFactory(r15)     // Catch:{ IOException -> 0x026b }
        L_0x0037:
            int r14 = r1.zze     // Catch:{ IOException -> 0x026b }
            r0.setConnectTimeout(r14)     // Catch:{ IOException -> 0x026b }
            int r14 = r1.zzf     // Catch:{ IOException -> 0x026b }
            r0.setReadTimeout(r14)     // Catch:{ IOException -> 0x026b }
            com.google.android.gms.internal.ads.zzazu r14 = r1.zzh     // Catch:{ IOException -> 0x026b }
            java.util.Map r14 = r14.zza()     // Catch:{ IOException -> 0x026b }
            java.util.Set r14 = r14.entrySet()     // Catch:{ IOException -> 0x026b }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ IOException -> 0x026b }
        L_0x004f:
            boolean r15 = r14.hasNext()     // Catch:{ IOException -> 0x026b }
            if (r15 == 0) goto L_0x006d
            java.lang.Object r15 = r14.next()     // Catch:{ IOException -> 0x026b }
            java.util.Map$Entry r15 = (java.util.Map.Entry) r15     // Catch:{ IOException -> 0x026b }
            java.lang.Object r16 = r15.getKey()     // Catch:{ IOException -> 0x026b }
            r6 = r16
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x026b }
            java.lang.Object r15 = r15.getValue()     // Catch:{ IOException -> 0x026b }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ IOException -> 0x026b }
            r0.setRequestProperty(r6, r15)     // Catch:{ IOException -> 0x026b }
            goto L_0x004f
        L_0x006d:
            int r6 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            r14 = -1
            if (r6 != 0) goto L_0x0078
            int r6 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x00a9
            goto L_0x0079
        L_0x0078:
            r4 = r7
        L_0x0079:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x026b }
            r6.<init>()     // Catch:{ IOException -> 0x026b }
            java.lang.String r11 = "bytes="
            r6.append(r11)     // Catch:{ IOException -> 0x026b }
            r6.append(r4)     // Catch:{ IOException -> 0x026b }
            java.lang.String r11 = "-"
            r6.append(r11)     // Catch:{ IOException -> 0x026b }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x026b }
            int r11 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
            if (r11 == 0) goto L_0x00a4
            long r4 = r4 + r9
            long r4 = r4 + r14
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x026b }
            r11.<init>()     // Catch:{ IOException -> 0x026b }
            r11.append(r6)     // Catch:{ IOException -> 0x026b }
            r11.append(r4)     // Catch:{ IOException -> 0x026b }
            java.lang.String r6 = r11.toString()     // Catch:{ IOException -> 0x026b }
        L_0x00a4:
            java.lang.String r4 = "Range"
            r0.setRequestProperty(r4, r6)     // Catch:{ IOException -> 0x026b }
        L_0x00a9:
            java.lang.String r4 = "User-Agent"
            java.lang.String r5 = r1.zzg     // Catch:{ IOException -> 0x026b }
            r0.setRequestProperty(r4, r5)     // Catch:{ IOException -> 0x026b }
            java.lang.String r4 = "Accept-Encoding"
            java.lang.String r5 = "identity"
            r0.setRequestProperty(r4, r5)     // Catch:{ IOException -> 0x026b }
            r4 = 0
            r0.setInstanceFollowRedirects(r4)     // Catch:{ IOException -> 0x026b }
            r0.setDoOutput(r4)     // Catch:{ IOException -> 0x026b }
            r0.connect()     // Catch:{ IOException -> 0x026b }
            int r4 = r0.getResponseCode()     // Catch:{ IOException -> 0x026b }
            r5 = 300(0x12c, float:4.2E-43)
            if (r4 == r5) goto L_0x020e
            r5 = 301(0x12d, float:4.22E-43)
            if (r4 == r5) goto L_0x020e
            r5 = 302(0x12e, float:4.23E-43)
            if (r4 == r5) goto L_0x020e
            r5 = 303(0x12f, float:4.25E-43)
            if (r4 == r5) goto L_0x020e
            r5 = 307(0x133, float:4.3E-43)
            if (r4 == r5) goto L_0x020e
            r5 = 308(0x134, float:4.32E-43)
            if (r4 != r5) goto L_0x00df
            goto L_0x020e
        L_0x00df:
            r1.zzk = r0     // Catch:{ IOException -> 0x026b }
            java.net.HttpURLConnection r0 = r1.zzk     // Catch:{ IOException -> 0x01f5 }
            int r0 = r0.getResponseCode()     // Catch:{ IOException -> 0x01f5 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r0 < r3) goto L_0x01d9
            r4 = 299(0x12b, float:4.19E-43)
            if (r0 <= r4) goto L_0x00f1
            goto L_0x01d9
        L_0x00f1:
            if (r0 != r3) goto L_0x00fc
            long r4 = r2.zzc
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x00fc
            goto L_0x00fe
        L_0x00fc:
            r4 = 0
        L_0x00fe:
            r1.zzn = r4
            long r3 = r2.zzd
            int r0 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x010a
            r1.zzo = r3
            goto L_0x01b7
        L_0x010a:
            java.net.HttpURLConnection r0 = r1.zzk
            java.lang.String r3 = "Content-Length"
            java.lang.String r3 = r0.getHeaderField(r3)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r5 = "]"
            if (r4 != 0) goto L_0x0136
            long r6 = java.lang.Long.parseLong(r3)     // Catch:{ NumberFormatException -> 0x011f }
            goto L_0x0137
        L_0x011f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "Unexpected Content-Length ["
            r4.append(r6)
            r4.append(r3)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.google.android.gms.ads.internal.util.zze.zzg(r4)
        L_0x0136:
            r6 = r14
        L_0x0137:
            java.lang.String r4 = "Content-Range"
            java.lang.String r0 = r0.getHeaderField(r4)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L_0x01ad
            java.util.regex.Pattern r4 = zzb
            java.util.regex.Matcher r4 = r4.matcher(r0)
            boolean r8 = r4.find()
            if (r8 == 0) goto L_0x01ad
            r8 = 2
            java.lang.String r8 = r4.group(r8)     // Catch:{ NumberFormatException -> 0x0196 }
            long r8 = java.lang.Long.parseLong(r8)     // Catch:{ NumberFormatException -> 0x0196 }
            r10 = 1
            java.lang.String r4 = r4.group(r10)     // Catch:{ NumberFormatException -> 0x0196 }
            long r10 = java.lang.Long.parseLong(r4)     // Catch:{ NumberFormatException -> 0x0196 }
            long r8 = r8 - r10
            r10 = 1
            long r8 = r8 + r10
            r17 = 0
            int r4 = (r6 > r17 ? 1 : (r6 == r17 ? 0 : -1))
            if (r4 >= 0) goto L_0x016d
            r6 = r8
            goto L_0x01ad
        L_0x016d:
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x01ad
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0196 }
            r4.<init>()     // Catch:{ NumberFormatException -> 0x0196 }
            java.lang.String r10 = "Inconsistent headers ["
            r4.append(r10)     // Catch:{ NumberFormatException -> 0x0196 }
            r4.append(r3)     // Catch:{ NumberFormatException -> 0x0196 }
            java.lang.String r3 = "] ["
            r4.append(r3)     // Catch:{ NumberFormatException -> 0x0196 }
            r4.append(r0)     // Catch:{ NumberFormatException -> 0x0196 }
            r4.append(r5)     // Catch:{ NumberFormatException -> 0x0196 }
            java.lang.String r3 = r4.toString()     // Catch:{ NumberFormatException -> 0x0196 }
            com.google.android.gms.ads.internal.util.zze.zzj(r3)     // Catch:{ NumberFormatException -> 0x0196 }
            long r3 = java.lang.Math.max(r6, r8)     // Catch:{ NumberFormatException -> 0x0196 }
            r6 = r3
            goto L_0x01ad
        L_0x0196:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unexpected Content-Range ["
            r3.append(r4)
            r3.append(r0)
            r3.append(r5)
            java.lang.String r0 = r3.toString()
            com.google.android.gms.ads.internal.util.zze.zzg(r0)
        L_0x01ad:
            int r0 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x01b5
            long r3 = r1.zzn
            long r14 = r6 - r3
        L_0x01b5:
            r1.zzo = r14
        L_0x01b7:
            java.net.HttpURLConnection r0 = r1.zzk     // Catch:{ IOException -> 0x01ce }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x01ce }
            r1.zzl = r0     // Catch:{ IOException -> 0x01ce }
            r3 = 1
            r1.zzm = r3
            com.google.android.gms.internal.ads.zzbab r0 = r1.zzi
            if (r0 == 0) goto L_0x01cb
            com.google.android.gms.internal.ads.zzckg r0 = (com.google.android.gms.internal.ads.zzckg) r0
            r0.zzk(r1, r2)
        L_0x01cb:
            long r2 = r1.zzo
            return r2
        L_0x01ce:
            r0 = move-exception
            r19.zzi()
            com.google.android.gms.internal.ads.zzazs r3 = new com.google.android.gms.internal.ads.zzazs
            r4 = 1
            r3.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zzazo) r2, (int) r4)
            throw r3
        L_0x01d9:
            java.net.HttpURLConnection r3 = r1.zzk
            java.util.Map r3 = r3.getHeaderFields()
            r19.zzi()
            com.google.android.gms.internal.ads.zzazt r4 = new com.google.android.gms.internal.ads.zzazt
            r4.<init>(r0, r3, r2)
            r2 = 416(0x1a0, float:5.83E-43)
            if (r0 != r2) goto L_0x01f4
            com.google.android.gms.internal.ads.zzazn r0 = new com.google.android.gms.internal.ads.zzazn
            r5 = 0
            r0.<init>(r5)
            r4.initCause(r0)
        L_0x01f4:
            throw r4
        L_0x01f5:
            r0 = move-exception
            r19.zzi()
            com.google.android.gms.internal.ads.zzazs r4 = new com.google.android.gms.internal.ads.zzazs
            android.net.Uri r5 = r2.zza
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r3 = r3.concat(r5)
            r5 = 1
            r4.<init>(r3, r0, r2, r5)
            throw r4
        L_0x020e:
            r5 = 0
            r17 = 0
            java.lang.String r4 = "Location"
            java.lang.String r4 = r0.getHeaderField(r4)     // Catch:{ IOException -> 0x026b }
            r0.disconnect()     // Catch:{ IOException -> 0x026b }
            if (r4 == 0) goto L_0x024c
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x026b }
            r0.<init>(r12, r4)     // Catch:{ IOException -> 0x026b }
            java.lang.String r4 = r0.getProtocol()     // Catch:{ IOException -> 0x026b }
            java.lang.String r6 = "https"
            boolean r6 = r6.equals(r4)     // Catch:{ IOException -> 0x026b }
            if (r6 != 0) goto L_0x0246
            java.lang.String r6 = "http"
            boolean r6 = r6.equals(r4)     // Catch:{ IOException -> 0x026b }
            if (r6 == 0) goto L_0x0236
            goto L_0x0246
        L_0x0236:
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x026b }
            java.lang.String r5 = "Unsupported protocol redirect: "
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ IOException -> 0x026b }
            java.lang.String r4 = r5.concat(r4)     // Catch:{ IOException -> 0x026b }
            r0.<init>(r4)     // Catch:{ IOException -> 0x026b }
            throw r0     // Catch:{ IOException -> 0x026b }
        L_0x0246:
            r12 = r0
            r0 = r13
            r4 = r17
            goto L_0x001f
        L_0x024c:
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x026b }
            java.lang.String r4 = "Null location redirect"
            r0.<init>(r4)     // Catch:{ IOException -> 0x026b }
            throw r0     // Catch:{ IOException -> 0x026b }
        L_0x0254:
            java.net.NoRouteToHostException r0 = new java.net.NoRouteToHostException     // Catch:{ IOException -> 0x026b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x026b }
            r4.<init>()     // Catch:{ IOException -> 0x026b }
            java.lang.String r5 = "Too many redirects: "
            r4.append(r5)     // Catch:{ IOException -> 0x026b }
            r4.append(r13)     // Catch:{ IOException -> 0x026b }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x026b }
            r0.<init>(r4)     // Catch:{ IOException -> 0x026b }
            throw r0     // Catch:{ IOException -> 0x026b }
        L_0x026b:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzazs r4 = new com.google.android.gms.internal.ads.zzazs
            android.net.Uri r5 = r2.zza
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r3 = r3.concat(r5)
            r5 = 1
            r4.<init>(r3, r0, r2, r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcjs.zzb(com.google.android.gms.internal.ads.zzazo):long");
    }

    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzk;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:4|(1:6)(1:7)|8|(5:13|14|(2:16|(1:18))(2:19|(1:21))|22|(1:26))|27|28) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0069 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd() throws com.google.android.gms.internal.ads.zzazs {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r9.zzl     // Catch:{ all -> 0x008a }
            if (r2 == 0) goto L_0x0079
            java.net.HttpURLConnection r2 = r9.zzk     // Catch:{ all -> 0x008a }
            long r3 = r9.zzo     // Catch:{ all -> 0x008a }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0011
            goto L_0x0014
        L_0x0011:
            long r7 = r9.zzq     // Catch:{ all -> 0x008a }
            long r3 = r3 - r7
        L_0x0014:
            int r7 = com.google.android.gms.internal.ads.zzbar.zza     // Catch:{ all -> 0x008a }
            r8 = 19
            if (r7 == r8) goto L_0x0021
            int r7 = com.google.android.gms.internal.ads.zzbar.zza     // Catch:{ all -> 0x008a }
            r8 = 20
            if (r7 == r8) goto L_0x0021
            goto L_0x0069
        L_0x0021:
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ Exception -> 0x0069 }
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x0031
            int r3 = r2.read()     // Catch:{ Exception -> 0x0069 }
            r4 = -1
            if (r3 == r4) goto L_0x0069
            goto L_0x0038
        L_0x0031:
            r5 = 2048(0x800, double:1.0118E-320)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x0038
            goto L_0x0069
        L_0x0038:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r3 = r3.getName()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x0069 }
            if (r4 != 0) goto L_0x0050
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x0069 }
            if (r3 == 0) goto L_0x0069
        L_0x0050:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x0069 }
            java.lang.Class r3 = r3.getSuperclass()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0069 }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x0069 }
            r4 = 1
            r3.setAccessible(r4)     // Catch:{ Exception -> 0x0069 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0069 }
            r3.invoke(r2, r4)     // Catch:{ Exception -> 0x0069 }
        L_0x0069:
            java.io.InputStream r2 = r9.zzl     // Catch:{ IOException -> 0x006f }
            r2.close()     // Catch:{ IOException -> 0x006f }
            goto L_0x0079
        L_0x006f:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzazs r3 = new com.google.android.gms.internal.ads.zzazs     // Catch:{ all -> 0x008a }
            com.google.android.gms.internal.ads.zzazo r4 = r9.zzj     // Catch:{ all -> 0x008a }
            r5 = 3
            r3.<init>((java.io.IOException) r2, (com.google.android.gms.internal.ads.zzazo) r4, (int) r5)     // Catch:{ all -> 0x008a }
            throw r3     // Catch:{ all -> 0x008a }
        L_0x0079:
            r9.zzl = r0
            r9.zzi()
            boolean r0 = r9.zzm
            if (r0 == 0) goto L_0x0084
            r9.zzm = r1
        L_0x0084:
            java.util.Set r0 = r9.zzs
            r0.clear()
            return
        L_0x008a:
            r2 = move-exception
            r9.zzl = r0
            r9.zzi()
            boolean r0 = r9.zzm
            if (r0 == 0) goto L_0x0096
            r9.zzm = r1
        L_0x0096:
            java.util.Set r0 = r9.zzs
            r0.clear()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcjs.zzd():void");
    }

    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzk;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    /* access modifiers changed from: package-private */
    public final void zzh(int i) {
        this.zzr = i;
        for (Socket socket : this.zzs) {
            if (!socket.isClosed()) {
                try {
                    socket.setReceiveBufferSize(this.zzr);
                } catch (SocketException e) {
                    zze.zzk("Failed to update receive buffer size.", e);
                }
            }
        }
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzazs {
        try {
            if (this.zzp != this.zzn) {
                byte[] bArr2 = (byte[]) zzc.getAndSet((Object) null);
                if (bArr2 == null) {
                    bArr2 = new byte[4096];
                }
                while (true) {
                    long j = this.zzp;
                    long j2 = this.zzn;
                    if (j == j2) {
                        zzc.set(bArr2);
                        break;
                    }
                    int read = this.zzl.read(bArr2, 0, (int) Math.min(j2 - j, (long) bArr2.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.zzp += (long) read;
                        zzbab zzbab = this.zzi;
                        if (zzbab != null) {
                            ((zzckg) zzbab).zzW(this, read);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
            if (i2 == 0) {
                return 0;
            }
            long j3 = this.zzo;
            if (j3 != -1) {
                long j4 = j3 - this.zzq;
                if (j4 != 0) {
                    i2 = (int) Math.min((long) i2, j4);
                }
                return -1;
            }
            int read2 = this.zzl.read(bArr, i, i2);
            if (read2 != -1) {
                this.zzq += (long) read2;
                zzbab zzbab2 = this.zzi;
                if (zzbab2 == null) {
                    return read2;
                }
                ((zzckg) zzbab2).zzW(this, read2);
                return read2;
            } else if (this.zzo == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } catch (IOException e) {
            throw new zzazs(e, this.zzj, 2);
        }
    }
}
