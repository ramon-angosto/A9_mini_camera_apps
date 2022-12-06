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
final class zzckk implements zzazv {
    private static final Pattern zzb = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final zzazu zzf = new zzazu();
    private final zzbab zzg;
    private zzazo zzh;
    private HttpURLConnection zzi;
    private final Queue zzj;
    private InputStream zzk;
    private boolean zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    private final long zzr;
    private final long zzs;

    zzckk(String str, zzbab zzbab, int i, int i2, long j, long j2) {
        zzbac.zzb(str);
        this.zze = str;
        this.zzg = zzbab;
        this.zzc = i;
        this.zzd = i2;
        this.zzj = new ArrayDeque();
        this.zzr = j;
        this.zzs = j2;
    }

    private final void zzg() {
        while (!this.zzj.isEmpty()) {
            try {
                ((HttpURLConnection) this.zzj.remove()).disconnect();
            } catch (Exception e) {
                zze.zzh("Unexpected error while disconnecting", e);
            }
        }
        this.zzi = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0064 A[Catch:{ IOException -> 0x007b }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0075 A[Catch:{ IOException -> 0x007b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(byte[] r18, int r19, int r20) throws com.google.android.gms.internal.ads.zzazs {
        /*
            r17 = this;
            r7 = r17
            r0 = r20
            r8 = -1
            if (r0 != 0) goto L_0x000a
            r8 = 0
            goto L_0x0074
        L_0x000a:
            long r1 = r7.zzm     // Catch:{ IOException -> 0x007b }
            long r3 = r7.zzn     // Catch:{ IOException -> 0x007b }
            long r1 = r1 - r3
            r5 = 0
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0016
            goto L_0x0074
        L_0x0016:
            long r1 = r7.zzo     // Catch:{ IOException -> 0x007b }
            long r9 = (long) r0     // Catch:{ IOException -> 0x007b }
            long r1 = r1 + r3
            long r1 = r1 + r9
            long r3 = r7.zzs     // Catch:{ IOException -> 0x007b }
            long r1 = r1 + r3
            long r5 = r7.zzq     // Catch:{ IOException -> 0x007b }
            r11 = 1
            long r13 = r5 + r11
            int r0 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r0 <= 0) goto L_0x004b
            long r0 = r7.zzp     // Catch:{ IOException -> 0x007b }
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x004b
            long r5 = r7.zzr     // Catch:{ IOException -> 0x007b }
            long r5 = r5 + r13
            long r5 = r5 - r3
            r2 = -1
            long r5 = r5 + r2
            long r15 = r13 + r9
            long r2 = r2 + r15
            long r2 = java.lang.Math.max(r5, r2)     // Catch:{ IOException -> 0x007b }
            long r4 = java.lang.Math.min(r0, r2)     // Catch:{ IOException -> 0x007b }
            r6 = 2
            r1 = r17
            r2 = r13
            r13 = r4
            r1.zzf(r2, r4, r6)     // Catch:{ IOException -> 0x007b }
            r7.zzq = r13     // Catch:{ IOException -> 0x007b }
            goto L_0x004c
        L_0x004b:
            r13 = r5
        L_0x004c:
            long r13 = r13 + r11
            long r0 = r7.zzo     // Catch:{ IOException -> 0x007b }
            long r13 = r13 - r0
            long r0 = r7.zzn     // Catch:{ IOException -> 0x007b }
            long r13 = r13 - r0
            long r0 = java.lang.Math.min(r9, r13)     // Catch:{ IOException -> 0x007b }
            int r0 = (int) r0     // Catch:{ IOException -> 0x007b }
            java.io.InputStream r1 = r7.zzk     // Catch:{ IOException -> 0x007b }
            r2 = r18
            r3 = r19
            int r0 = r1.read(r2, r3, r0)     // Catch:{ IOException -> 0x007b }
            if (r0 == r8) goto L_0x0075
            long r1 = r7.zzn     // Catch:{ IOException -> 0x007b }
            long r3 = (long) r0     // Catch:{ IOException -> 0x007b }
            long r1 = r1 + r3
            r7.zzn = r1     // Catch:{ IOException -> 0x007b }
            com.google.android.gms.internal.ads.zzbab r1 = r7.zzg     // Catch:{ IOException -> 0x007b }
            if (r1 == 0) goto L_0x0073
            com.google.android.gms.internal.ads.zzckg r1 = (com.google.android.gms.internal.ads.zzckg) r1     // Catch:{ IOException -> 0x007b }
            r1.zzW(r7, r0)     // Catch:{ IOException -> 0x007b }
        L_0x0073:
            r8 = r0
        L_0x0074:
            return r8
        L_0x0075:
            java.io.EOFException r0 = new java.io.EOFException     // Catch:{ IOException -> 0x007b }
            r0.<init>()     // Catch:{ IOException -> 0x007b }
            throw r0     // Catch:{ IOException -> 0x007b }
        L_0x007b:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzazs r1 = new com.google.android.gms.internal.ads.zzazs
            com.google.android.gms.internal.ads.zzazo r2 = r7.zzh
            r3 = 2
            r1.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zzazo) r2, (int) r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzckk.zza(byte[], int, int):int");
    }

    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final void zzd() throws zzazs {
        try {
            InputStream inputStream = this.zzk;
            if (inputStream != null) {
                inputStream.close();
            }
            this.zzk = null;
            zzg();
            if (this.zzl) {
                this.zzl = false;
            }
        } catch (IOException e) {
            throw new zzazs(e, this.zzh, 3);
        } catch (Throwable th) {
            this.zzk = null;
            zzg();
            if (this.zzl) {
                this.zzl = false;
            }
            throw th;
        }
    }

    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    /* access modifiers changed from: package-private */
    public final HttpURLConnection zzf(long j, long j2, int i) throws zzazs {
        String uri = this.zzh.zza.toString();
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
            this.zzj.add(httpURLConnection);
            String uri2 = this.zzh.zza.toString();
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode < 200 || responseCode > 299) {
                    Map headerFields = httpURLConnection.getHeaderFields();
                    zzg();
                    throw new zzckj(responseCode, headerFields, this.zzh, i);
                }
                try {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (this.zzk != null) {
                        inputStream = new SequenceInputStream(this.zzk, inputStream);
                    }
                    this.zzk = inputStream;
                    return httpURLConnection;
                } catch (IOException e) {
                    zzg();
                    throw new zzazs(e, this.zzh, i);
                }
            } catch (IOException e2) {
                zzg();
                throw new zzazs("Unable to connect to ".concat(String.valueOf(uri2)), e2, this.zzh, i);
            }
        } catch (IOException e3) {
            throw new zzazs("Unable to connect to ".concat(String.valueOf(uri)), e3, this.zzh, i);
        }
    }

    public final long zzb(zzazo zzazo) throws zzazs {
        long j;
        this.zzh = zzazo;
        this.zzn = 0;
        long j2 = zzazo.zzc;
        long j3 = zzazo.zzd;
        if (j3 == -1) {
            j = this.zzr;
        } else {
            j = Math.min(this.zzr, j3);
        }
        this.zzo = j2;
        this.zzi = zzf(j2, (j + j2) - 1, 1);
        String headerField = this.zzi.getHeaderField("Content-Range");
        if (!TextUtils.isEmpty(headerField)) {
            Matcher matcher = zzb.matcher(headerField);
            if (matcher.find()) {
                try {
                    Long.parseLong(matcher.group(1));
                    long parseLong = Long.parseLong(matcher.group(2));
                    long parseLong2 = Long.parseLong(matcher.group(3));
                    long j4 = zzazo.zzd;
                    if (j4 != -1) {
                        this.zzm = j4;
                        this.zzp = Math.max(parseLong, (this.zzo + j4) - 1);
                    } else {
                        this.zzm = parseLong2 - this.zzo;
                        this.zzp = parseLong2 - 1;
                    }
                    this.zzq = parseLong;
                    this.zzl = true;
                    zzbab zzbab = this.zzg;
                    if (zzbab != null) {
                        ((zzckg) zzbab).zzk(this, zzazo);
                    }
                    return this.zzm;
                } catch (NumberFormatException unused) {
                    zze.zzg("Unexpected Content-Range [" + headerField + "]");
                }
            }
        }
        throw new zzcki(headerField, zzazo);
    }
}
