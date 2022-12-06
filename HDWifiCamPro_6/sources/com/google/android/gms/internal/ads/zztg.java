package com.google.android.gms.internal.ads;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zztg implements zzws, zzrx {
    final /* synthetic */ zztl zza;
    /* access modifiers changed from: private */
    public final long zzb = zzrz.zza();
    private final Uri zzc;
    /* access modifiers changed from: private */
    public final zzfy zzd;
    private final zztb zze;
    private final zzzl zzf;
    private final zzdg zzg;
    private final zzaai zzh = new zzaai();
    private volatile boolean zzi;
    private boolean zzj = true;
    /* access modifiers changed from: private */
    public long zzk;
    /* access modifiers changed from: private */
    public zzfc zzl = zzi(0);
    private zzaap zzm;
    private boolean zzn;

    public zztg(zztl zztl, Uri uri, zzex zzex, zztb zztb, zzzl zzzl, zzdg zzdg) {
        this.zza = zztl;
        this.zzc = uri;
        this.zzd = new zzfy(zzex);
        this.zze = zztb;
        this.zzf = zzzl;
        this.zzg = zzdg;
    }

    static /* bridge */ /* synthetic */ void zzf(zztg zztg, long j, long j2) {
        zztg.zzh.zza = j;
        zztg.zzk = j2;
        zztg.zzj = true;
        zztg.zzn = false;
    }

    private final zzfc zzi(long j) {
        zzfa zzfa = new zzfa();
        zzfa.zzd(this.zzc);
        zzfa.zzc(j);
        zzfa.zza(6);
        zzfa.zzb(zztl.zzb);
        return zzfa.zze();
    }

    public final void zzg() {
        this.zzi = true;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:58|59) */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        com.google.android.gms.internal.ads.zzdw.zze("IcyHeaders", "Invalid metadata interval: ".concat(java.lang.String.valueOf(r3)));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:58:0x0107 */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x020e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01ca A[EDGE_INSN: B:124:0x01ca->B:101:0x01ca ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0084 A[Catch:{ all -> 0x01ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008e A[Catch:{ all -> 0x01ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009a A[Catch:{ all -> 0x01ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a4 A[Catch:{ all -> 0x01ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b0 A[Catch:{ all -> 0x01ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ba A[Catch:{ all -> 0x01ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c6 A[Catch:{ all -> 0x01ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d6 A[Catch:{ all -> 0x01ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e2 A[Catch:{ all -> 0x01ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0113 A[Catch:{ all -> 0x01ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0117 A[Catch:{ all -> 0x01ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x011f A[Catch:{ all -> 0x01ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0135 A[Catch:{ all -> 0x01ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0153 A[Catch:{ all -> 0x01ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x016f A[Catch:{ all -> 0x01eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0178 A[Catch:{ all -> 0x01eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x018b A[SYNTHETIC, Splitter:B:86:0x018b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh() throws java.io.IOException {
        /*
            r24 = this;
            r1 = r24
            java.lang.String r0 = "Invalid metadata interval: "
        L_0x0004:
            boolean r2 = r1.zzi
            if (r2 != 0) goto L_0x020e
            r2 = -1
            r5 = 0
            com.google.android.gms.internal.ads.zzaai r6 = r1.zzh     // Catch:{ all -> 0x01ee }
            long r13 = r6.zza     // Catch:{ all -> 0x01ee }
            com.google.android.gms.internal.ads.zzfc r6 = r1.zzi(r13)     // Catch:{ all -> 0x01ee }
            r1.zzl = r6     // Catch:{ all -> 0x01ee }
            com.google.android.gms.internal.ads.zzfy r6 = r1.zzd     // Catch:{ all -> 0x01ee }
            com.google.android.gms.internal.ads.zzfc r7 = r1.zzl     // Catch:{ all -> 0x01ee }
            long r6 = r6.zzb(r7)     // Catch:{ all -> 0x01ee }
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r8 == 0) goto L_0x0027
            long r6 = r6 + r13
            com.google.android.gms.internal.ads.zztl r8 = r1.zza     // Catch:{ all -> 0x01ee }
            r8.zzp.post(new com.google.android.gms.internal.ads.zzte(r8))     // Catch:{ all -> 0x01ee }
        L_0x0027:
            r15 = r6
            com.google.android.gms.internal.ads.zztl r6 = r1.zza     // Catch:{ all -> 0x01ee }
            com.google.android.gms.internal.ads.zzfy r7 = r1.zzd     // Catch:{ all -> 0x01ee }
            java.util.Map r7 = r7.zze()     // Catch:{ all -> 0x01ee }
            java.lang.String r8 = "icy-br"
            java.lang.Object r8 = r7.get(r8)     // Catch:{ all -> 0x01ee }
            java.util.List r8 = (java.util.List) r8     // Catch:{ all -> 0x01ee }
            java.lang.String r9 = "IcyHeaders"
            r10 = -1
            if (r8 == 0) goto L_0x0076
            java.lang.Object r8 = r8.get(r5)     // Catch:{ all -> 0x01ee }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x01ee }
            int r11 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x0066 }
            int r11 = r11 * 1000
            if (r11 <= 0) goto L_0x004d
            r2 = 1
            goto L_0x0063
        L_0x004d:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0067 }
            r12.<init>()     // Catch:{ NumberFormatException -> 0x0067 }
            java.lang.String r2 = "Invalid bitrate: "
            r12.append(r2)     // Catch:{ NumberFormatException -> 0x0067 }
            r12.append(r8)     // Catch:{ NumberFormatException -> 0x0067 }
            java.lang.String r2 = r12.toString()     // Catch:{ NumberFormatException -> 0x0067 }
            com.google.android.gms.internal.ads.zzdw.zze(r9, r2)     // Catch:{ NumberFormatException -> 0x0067 }
            r2 = r5
            r11 = r10
        L_0x0063:
            r18 = r11
            goto L_0x0079
        L_0x0066:
            r11 = r10
        L_0x0067:
            java.lang.String r2 = "Invalid bitrate header: "
            java.lang.String r3 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x01ee }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ all -> 0x01ee }
            com.google.android.gms.internal.ads.zzdw.zze(r9, r2)     // Catch:{ all -> 0x01ee }
            r2 = r5
            goto L_0x0063
        L_0x0076:
            r2 = r5
            r18 = r10
        L_0x0079:
            java.lang.String r3 = "icy-genre"
            java.lang.Object r3 = r7.get(r3)     // Catch:{ all -> 0x01ee }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x01ee }
            r8 = 0
            if (r3 == 0) goto L_0x008e
            java.lang.Object r2 = r3.get(r5)     // Catch:{ all -> 0x01ee }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x01ee }
            r19 = r2
            r2 = 1
            goto L_0x0090
        L_0x008e:
            r19 = r8
        L_0x0090:
            java.lang.String r3 = "icy-name"
            java.lang.Object r3 = r7.get(r3)     // Catch:{ all -> 0x01ee }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x01ee }
            if (r3 == 0) goto L_0x00a4
            java.lang.Object r2 = r3.get(r5)     // Catch:{ all -> 0x01ee }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x01ee }
            r20 = r2
            r2 = 1
            goto L_0x00a6
        L_0x00a4:
            r20 = r8
        L_0x00a6:
            java.lang.String r3 = "icy-url"
            java.lang.Object r3 = r7.get(r3)     // Catch:{ all -> 0x01ee }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x01ee }
            if (r3 == 0) goto L_0x00ba
            java.lang.Object r2 = r3.get(r5)     // Catch:{ all -> 0x01ee }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x01ee }
            r21 = r2
            r2 = 1
            goto L_0x00bc
        L_0x00ba:
            r21 = r8
        L_0x00bc:
            java.lang.String r3 = "icy-pub"
            java.lang.Object r3 = r7.get(r3)     // Catch:{ all -> 0x01ee }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x01ee }
            if (r3 == 0) goto L_0x00d6
            java.lang.Object r2 = r3.get(r5)     // Catch:{ all -> 0x01ee }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x01ee }
            java.lang.String r3 = "1"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x01ee }
            r22 = r2
            r2 = 1
            goto L_0x00d8
        L_0x00d6:
            r22 = r5
        L_0x00d8:
            java.lang.String r3 = "icy-metaint"
            java.lang.Object r3 = r7.get(r3)     // Catch:{ all -> 0x01ee }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x01ee }
            if (r3 == 0) goto L_0x0113
            java.lang.Object r3 = r3.get(r5)     // Catch:{ all -> 0x01ee }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x01ee }
            int r7 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x0106 }
            if (r7 <= 0) goto L_0x00f0
            r2 = 1
            goto L_0x0103
        L_0x00f0:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0107 }
            r11.<init>()     // Catch:{ NumberFormatException -> 0x0107 }
            r11.append(r0)     // Catch:{ NumberFormatException -> 0x0107 }
            r11.append(r3)     // Catch:{ NumberFormatException -> 0x0107 }
            java.lang.String r11 = r11.toString()     // Catch:{ NumberFormatException -> 0x0107 }
            com.google.android.gms.internal.ads.zzdw.zze(r9, r11)     // Catch:{ NumberFormatException -> 0x0107 }
            r7 = r10
        L_0x0103:
            r23 = r7
            goto L_0x0115
        L_0x0106:
            r7 = r10
        L_0x0107:
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x01ee }
            java.lang.String r3 = r0.concat(r3)     // Catch:{ all -> 0x01ee }
            com.google.android.gms.internal.ads.zzdw.zze(r9, r3)     // Catch:{ all -> 0x01ee }
            goto L_0x0103
        L_0x0113:
            r23 = r10
        L_0x0115:
            if (r2 == 0) goto L_0x011f
            com.google.android.gms.internal.ads.zzacm r2 = new com.google.android.gms.internal.ads.zzacm     // Catch:{ all -> 0x01ee }
            r17 = r2
            r17.<init>(r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x01ee }
            goto L_0x0120
        L_0x011f:
            r2 = r8
        L_0x0120:
            r6.zzr = r2     // Catch:{ all -> 0x01ee }
            com.google.android.gms.internal.ads.zzfy r2 = r1.zzd     // Catch:{ all -> 0x01ee }
            com.google.android.gms.internal.ads.zztl r3 = r1.zza     // Catch:{ all -> 0x01ee }
            com.google.android.gms.internal.ads.zzacm r6 = r3.zzr     // Catch:{ all -> 0x01ee }
            if (r6 == 0) goto L_0x0153
            com.google.android.gms.internal.ads.zzacm r6 = r3.zzr     // Catch:{ all -> 0x01ee }
            int r6 = r6.zzf     // Catch:{ all -> 0x01ee }
            if (r6 == r10) goto L_0x0153
            com.google.android.gms.internal.ads.zzry r6 = new com.google.android.gms.internal.ads.zzry     // Catch:{ all -> 0x01ee }
            com.google.android.gms.internal.ads.zzacm r3 = r3.zzr     // Catch:{ all -> 0x01ee }
            int r3 = r3.zzf     // Catch:{ all -> 0x01ee }
            r6.<init>(r2, r3, r1)     // Catch:{ all -> 0x01ee }
            com.google.android.gms.internal.ads.zztl r2 = r1.zza     // Catch:{ all -> 0x01ee }
            com.google.android.gms.internal.ads.zzaap r2 = r2.zzu()     // Catch:{ all -> 0x01ee }
            r1.zzm = r2     // Catch:{ all -> 0x01ee }
            com.google.android.gms.internal.ads.zzaap r2 = r1.zzm     // Catch:{ all -> 0x01ee }
            com.google.android.gms.internal.ads.zzaf r3 = com.google.android.gms.internal.ads.zztl.zzc     // Catch:{ all -> 0x01ee }
            r2.zzk(r3)     // Catch:{ all -> 0x01ee }
            r8 = r6
            goto L_0x0154
        L_0x0153:
            r8 = r2
        L_0x0154:
            com.google.android.gms.internal.ads.zztb r7 = r1.zze     // Catch:{ all -> 0x01ee }
            android.net.Uri r9 = r1.zzc     // Catch:{ all -> 0x01ee }
            com.google.android.gms.internal.ads.zzfy r2 = r1.zzd     // Catch:{ all -> 0x01ee }
            java.util.Map r10 = r2.zze()     // Catch:{ all -> 0x01ee }
            com.google.android.gms.internal.ads.zzzl r2 = r1.zzf     // Catch:{ all -> 0x01ee }
            r11 = r13
            r4 = r13
            r13 = r15
            r15 = r2
            r7.zzd(r8, r9, r10, r11, r13, r15)     // Catch:{ all -> 0x01eb }
            com.google.android.gms.internal.ads.zztl r2 = r1.zza     // Catch:{ all -> 0x01eb }
            com.google.android.gms.internal.ads.zzacm r2 = r2.zzr     // Catch:{ all -> 0x01eb }
            if (r2 == 0) goto L_0x0174
            com.google.android.gms.internal.ads.zztb r2 = r1.zze     // Catch:{ all -> 0x01eb }
            r2.zzc()     // Catch:{ all -> 0x01eb }
        L_0x0174:
            boolean r2 = r1.zzj     // Catch:{ all -> 0x01eb }
            if (r2 == 0) goto L_0x0186
            com.google.android.gms.internal.ads.zztb r2 = r1.zze     // Catch:{ all -> 0x01eb }
            long r7 = r1.zzk     // Catch:{ all -> 0x01eb }
            r2.zzf(r4, r7)     // Catch:{ all -> 0x01eb }
            r2 = 0
            r1.zzj = r2     // Catch:{ all -> 0x0183 }
            goto L_0x0187
        L_0x0183:
            r0 = move-exception
            goto L_0x01f0
        L_0x0186:
            r2 = 0
        L_0x0187:
            r6 = r4
            r5 = r2
        L_0x0189:
            if (r5 != 0) goto L_0x01ca
            boolean r4 = r1.zzi     // Catch:{ all -> 0x01c1 }
            if (r4 != 0) goto L_0x01c9
            com.google.android.gms.internal.ads.zzdg r4 = r1.zzg     // Catch:{ InterruptedException -> 0x01c3 }
            r4.zza()     // Catch:{ InterruptedException -> 0x01c3 }
            com.google.android.gms.internal.ads.zztb r4 = r1.zze     // Catch:{ all -> 0x01c1 }
            com.google.android.gms.internal.ads.zzaai r8 = r1.zzh     // Catch:{ all -> 0x01c1 }
            int r5 = r4.zza(r8)     // Catch:{ all -> 0x01c1 }
            com.google.android.gms.internal.ads.zztb r4 = r1.zze     // Catch:{ all -> 0x01c1 }
            long r8 = r4.zzb()     // Catch:{ all -> 0x01c1 }
            com.google.android.gms.internal.ads.zztl r4 = r1.zza     // Catch:{ all -> 0x01c1 }
            long r10 = r4.zzj     // Catch:{ all -> 0x01c1 }
            long r10 = r10 + r6
            int r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r4 <= 0) goto L_0x0189
            com.google.android.gms.internal.ads.zzdg r4 = r1.zzg     // Catch:{ all -> 0x01c1 }
            r4.zzc()     // Catch:{ all -> 0x01c1 }
            com.google.android.gms.internal.ads.zztl r4 = r1.zza     // Catch:{ all -> 0x01c1 }
            android.os.Handler r6 = r4.zzp     // Catch:{ all -> 0x01c1 }
            java.lang.Runnable r4 = r4.zzo     // Catch:{ all -> 0x01c1 }
            r6.post(r4)     // Catch:{ all -> 0x01c1 }
            r6 = r8
            goto L_0x0189
        L_0x01c1:
            r0 = move-exception
            goto L_0x01f1
        L_0x01c3:
            java.io.InterruptedIOException r0 = new java.io.InterruptedIOException     // Catch:{ all -> 0x01c1 }
            r0.<init>()     // Catch:{ all -> 0x01c1 }
            throw r0     // Catch:{ all -> 0x01c1 }
        L_0x01c9:
            r5 = r2
        L_0x01ca:
            r3 = 1
            if (r5 != r3) goto L_0x01ce
            goto L_0x01e3
        L_0x01ce:
            com.google.android.gms.internal.ads.zztb r2 = r1.zze
            long r3 = r2.zzb()
            r6 = -1
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 == 0) goto L_0x01e2
            com.google.android.gms.internal.ads.zzaai r3 = r1.zzh
            long r6 = r2.zzb()
            r3.zza = r6
        L_0x01e2:
            r2 = r5
        L_0x01e3:
            com.google.android.gms.internal.ads.zzfy r3 = r1.zzd
            com.google.android.gms.internal.ads.zzez.zza(r3)
            if (r2 == 0) goto L_0x0004
            goto L_0x020e
        L_0x01eb:
            r0 = move-exception
            r2 = 0
            goto L_0x01f0
        L_0x01ee:
            r0 = move-exception
            r2 = r5
        L_0x01f0:
            r5 = r2
        L_0x01f1:
            r2 = 1
            if (r5 == r2) goto L_0x0208
            com.google.android.gms.internal.ads.zztb r2 = r1.zze
            long r3 = r2.zzb()
            r5 = -1
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0208
            com.google.android.gms.internal.ads.zzaai r3 = r1.zzh
            long r4 = r2.zzb()
            r3.zza = r4
        L_0x0208:
            com.google.android.gms.internal.ads.zzfy r2 = r1.zzd
            com.google.android.gms.internal.ads.zzez.zza(r2)
            throw r0
        L_0x020e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztg.zzh():void");
    }

    public final void zza(zzef zzef) {
        long j;
        if (!this.zzn) {
            j = this.zzk;
        } else {
            j = Math.max(this.zza.zzQ(true), this.zzk);
        }
        long j2 = j;
        int zza2 = zzef.zza();
        zzaap zzaap = this.zzm;
        if (zzaap != null) {
            zzaan.zzb(zzaap, zzef, zza2);
            zzaap.zzs(j2, 1, zza2, 0, (zzaao) null);
            this.zzn = true;
            return;
        }
        throw null;
    }
}
