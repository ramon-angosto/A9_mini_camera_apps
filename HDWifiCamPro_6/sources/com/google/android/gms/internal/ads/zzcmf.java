package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.gms.ads.internal.util.zze;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcmf extends zzer implements zzfu {
    private static final Pattern zzb = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final zzft zzf = new zzft();
    private zzfc zzg;
    private HttpURLConnection zzh;
    private final Queue zzi;
    private InputStream zzj;
    private boolean zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    private final long zzr;
    private final long zzs;

    zzcmf(String str, zzfz zzfz, int i, int i2, long j, long j2) {
        super(true);
        zzdd.zzc(str);
        this.zze = str;
        this.zzc = i;
        this.zzd = i2;
        this.zzi = new ArrayDeque();
        this.zzr = j;
        this.zzs = j2;
        if (zzfz != null) {
            zzf(zzfz);
        }
    }

    private final void zzl() {
        while (!this.zzi.isEmpty()) {
            try {
                ((HttpURLConnection) this.zzi.remove()).disconnect();
            } catch (Exception e) {
                zze.zzh("Unexpected error while disconnecting", e);
            }
        }
        this.zzh = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0063 A[Catch:{ IOException -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x006e A[Catch:{ IOException -> 0x0074 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(byte[] r18, int r19, int r20) throws com.google.android.gms.internal.ads.zzfq {
        /*
            r17 = this;
            r7 = r17
            r0 = r20
            r8 = -1
            if (r0 != 0) goto L_0x0009
            r8 = 0
            goto L_0x006d
        L_0x0009:
            long r1 = r7.zzm     // Catch:{ IOException -> 0x0074 }
            long r3 = r7.zzn     // Catch:{ IOException -> 0x0074 }
            long r1 = r1 - r3
            r5 = 0
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0015
            goto L_0x006d
        L_0x0015:
            long r1 = r7.zzo     // Catch:{ IOException -> 0x0074 }
            long r9 = (long) r0     // Catch:{ IOException -> 0x0074 }
            long r1 = r1 + r3
            long r1 = r1 + r9
            long r3 = r7.zzs     // Catch:{ IOException -> 0x0074 }
            long r1 = r1 + r3
            long r5 = r7.zzq     // Catch:{ IOException -> 0x0074 }
            r11 = 1
            long r13 = r5 + r11
            int r0 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r0 <= 0) goto L_0x004a
            long r0 = r7.zzp     // Catch:{ IOException -> 0x0074 }
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x004a
            long r5 = r7.zzr     // Catch:{ IOException -> 0x0074 }
            long r5 = r5 + r13
            long r5 = r5 - r3
            r2 = -1
            long r5 = r5 + r2
            long r15 = r13 + r9
            long r2 = r2 + r15
            long r2 = java.lang.Math.max(r5, r2)     // Catch:{ IOException -> 0x0074 }
            long r4 = java.lang.Math.min(r0, r2)     // Catch:{ IOException -> 0x0074 }
            r6 = 2
            r1 = r17
            r2 = r13
            r13 = r4
            r1.zzk(r2, r4, r6)     // Catch:{ IOException -> 0x0074 }
            r7.zzq = r13     // Catch:{ IOException -> 0x0074 }
            goto L_0x004b
        L_0x004a:
            r13 = r5
        L_0x004b:
            long r13 = r13 + r11
            long r0 = r7.zzo     // Catch:{ IOException -> 0x0074 }
            long r13 = r13 - r0
            long r0 = r7.zzn     // Catch:{ IOException -> 0x0074 }
            long r13 = r13 - r0
            long r0 = java.lang.Math.min(r9, r13)     // Catch:{ IOException -> 0x0074 }
            int r0 = (int) r0     // Catch:{ IOException -> 0x0074 }
            java.io.InputStream r1 = r7.zzj     // Catch:{ IOException -> 0x0074 }
            r2 = r18
            r3 = r19
            int r0 = r1.read(r2, r3, r0)     // Catch:{ IOException -> 0x0074 }
            if (r0 == r8) goto L_0x006e
            long r1 = r7.zzn     // Catch:{ IOException -> 0x0074 }
            long r3 = (long) r0     // Catch:{ IOException -> 0x0074 }
            long r1 = r1 + r3
            r7.zzn = r1     // Catch:{ IOException -> 0x0074 }
            r7.zzg(r0)     // Catch:{ IOException -> 0x0074 }
            r8 = r0
        L_0x006d:
            return r8
        L_0x006e:
            java.io.EOFException r0 = new java.io.EOFException     // Catch:{ IOException -> 0x0074 }
            r0.<init>()     // Catch:{ IOException -> 0x0074 }
            throw r0     // Catch:{ IOException -> 0x0074 }
        L_0x0074:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzfq r1 = new com.google.android.gms.internal.ads.zzfq
            com.google.android.gms.internal.ads.zzfc r2 = r7.zzg
            r3 = 2000(0x7d0, float:2.803E-42)
            r4 = 2
            r1.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zzfc) r2, (int) r3, (int) r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcmf.zza(byte[], int, int):int");
    }

    public final long zzb(zzfc zzfc) throws zzfq {
        long j;
        this.zzg = zzfc;
        this.zzn = 0;
        long j2 = zzfc.zzf;
        long j3 = zzfc.zzg;
        if (j3 == -1) {
            j = this.zzr;
        } else {
            j = Math.min(this.zzr, j3);
        }
        this.zzo = j2;
        this.zzh = zzk(j2, (j + j2) - 1, 1);
        String headerField = this.zzh.getHeaderField("Content-Range");
        if (!TextUtils.isEmpty(headerField)) {
            Matcher matcher = zzb.matcher(headerField);
            if (matcher.find()) {
                try {
                    Long.parseLong(matcher.group(1));
                    long parseLong = Long.parseLong(matcher.group(2));
                    long parseLong2 = Long.parseLong(matcher.group(3));
                    long j4 = zzfc.zzg;
                    if (j4 != -1) {
                        this.zzm = j4;
                        this.zzp = Math.max(parseLong, (this.zzo + j4) - 1);
                    } else {
                        this.zzm = parseLong2 - this.zzo;
                        this.zzp = parseLong2 - 1;
                    }
                    this.zzq = parseLong;
                    this.zzk = true;
                    zzj(zzfc);
                    return this.zzm;
                } catch (NumberFormatException unused) {
                    zze.zzg("Unexpected Content-Range [" + headerField + "]");
                }
            }
        }
        throw new zzcmd(headerField, zzfc);
    }

    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final void zzd() throws zzfq {
        try {
            InputStream inputStream = this.zzj;
            if (inputStream != null) {
                inputStream.close();
            }
            this.zzj = null;
            zzl();
            if (this.zzk) {
                this.zzk = false;
                zzh();
            }
        } catch (IOException e) {
            throw new zzfq(e, this.zzg, 2000, 3);
        } catch (Throwable th) {
            this.zzj = null;
            zzl();
            if (this.zzk) {
                this.zzk = false;
                zzh();
            }
            throw th;
        }
    }

    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    /* access modifiers changed from: package-private */
    public final HttpURLConnection zzk(long j, long j2, int i) throws zzfq {
        String uri = this.zzg.zza.toString();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri).openConnection();
            httpURLConnection.setConnectTimeout(this.zzc);
            httpURLConnection.setReadTimeout(this.zzd);
            for (Map.Entry entry : this.zzf.zza().entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            httpURLConnection.setRequestProperty("Range", "bytes=" + j + "-" + j2);
            httpURLConnection.setRequestProperty("User-Agent", this.zze);
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
            httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
            httpURLConnection.connect();
            this.zzi.add(httpURLConnection);
            String uri2 = this.zzg.zza.toString();
            try {
                int responseCode = httpURLConnection.getResponseCode();
                this.zzl = responseCode;
                if (responseCode < 200 || responseCode > 299) {
                    Map headerFields = httpURLConnection.getHeaderFields();
                    zzl();
                    throw new zzcme(this.zzl, headerFields, this.zzg, i);
                }
                try {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (this.zzj != null) {
                        inputStream = new SequenceInputStream(this.zzj, inputStream);
                    }
                    this.zzj = inputStream;
                    return httpURLConnection;
                } catch (IOException e) {
                    zzl();
                    throw new zzfq(e, this.zzg, 2000, i);
                }
            } catch (IOException e2) {
                zzl();
                throw new zzfq("Unable to connect to ".concat(String.valueOf(uri2)), e2, this.zzg, 2000, i);
            }
        } catch (IOException e3) {
            throw new zzfq("Unable to connect to ".concat(String.valueOf(uri)), e3, this.zzg, 2000, i);
        }
    }
}
