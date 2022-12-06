package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzclh extends zzclb implements zzbab {
    private String zzd;
    private final zzcix zze;
    private boolean zzf;
    private final zzclg zzg = new zzclg();
    private final zzckm zzh = new zzckm();
    private ByteBuffer zzi;
    private boolean zzj;
    private final Object zzk = new Object();
    private final String zzl;
    private final int zzm;
    private boolean zzn;

    public zzclh(zzciy zzciy, zzcix zzcix) {
        super(zzciy);
        this.zze = zzcix;
        this.zzl = zzciy != null ? zzciy.zzt() : "";
        this.zzm = zzciy != null ? zzciy.zzh() : 0;
    }

    protected static final String zzt(String str) {
        return "cache:".concat(String.valueOf(zzcgi.zze(str)));
    }

    private final void zzu() {
        int zza = (int) this.zzg.zza();
        int zza2 = (int) this.zzh.zza(this.zzi);
        int position = this.zzi.position();
        int round = Math.round(((float) zza2) * (((float) position) / ((float) zza)));
        boolean z = round > 0;
        int zzs = zzcip.zzs();
        int zzu = zzcip.zzu();
        String str = this.zzd;
        zzf(str, zzt(str), position, zza, (long) round, (long) zza2, z, zzs, zzu);
    }

    public final void zzb() {
        this.zzf = true;
    }

    public final String zzi() {
        return this.zzd;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj, int i) {
    }

    public final /* bridge */ /* synthetic */ void zzk(Object obj, zzazo zzazo) {
        this.zzg.zzb((zzazq) obj);
    }

    public final ByteBuffer zzl() {
        synchronized (this.zzk) {
            ByteBuffer byteBuffer = this.zzi;
            if (byteBuffer != null && !this.zzj) {
                byteBuffer.flip();
                this.zzj = true;
            }
            this.zzf = true;
        }
        return this.zzi;
    }

    public final boolean zzm() {
        return this.zzn;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.google.android.gms.internal.ads.zzazq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.google.android.gms.internal.ads.zzazq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: com.google.android.gms.internal.ads.zzazq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: com.google.android.gms.internal.ads.zzazq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: com.google.android.gms.internal.ads.zzcju} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: com.google.android.gms.internal.ads.zzazq} */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ce, code lost:
        if (r9.zzi.remaining() > 0) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00d0, code lost:
        zzu();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d7, code lost:
        if (r9.zzf != false) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d9, code lost:
        r11 = r1.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00e1, code lost:
        if ((r11 - r14) < r4) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00e3, code lost:
        zzu();
        r14 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ee, code lost:
        if ((r11 - r2) > (1000 * r6)) goto L_0x00f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0114, code lost:
        throw new java.io.IOException("Timeout exceeded. Limit: " + r6 + " sec");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0115, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0117, code lost:
        r1 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x013a, code lost:
        throw new java.io.IOException("Precache abort at " + r9.zzi.limit() + " bytes");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x013b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        return true;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzq(java.lang.String r25) {
        /*
            r24 = this;
            r9 = r24
            r10 = r25
            r9.zzd = r10
            java.lang.String r11 = zzt(r25)
            com.google.android.gms.internal.ads.zzazq r0 = new com.google.android.gms.internal.ads.zzazq     // Catch:{ Exception -> 0x0144 }
            java.lang.String r2 = r9.zzb     // Catch:{ Exception -> 0x0144 }
            com.google.android.gms.internal.ads.zzcix r1 = r9.zze     // Catch:{ Exception -> 0x0144 }
            int r5 = r1.zzd     // Catch:{ Exception -> 0x0144 }
            r3 = 0
            int r6 = r1.zzf     // Catch:{ Exception -> 0x0144 }
            r7 = 1
            r8 = 0
            r1 = r0
            r4 = r24
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0144 }
            com.google.android.gms.internal.ads.zzcix r1 = r9.zze     // Catch:{ Exception -> 0x0144 }
            boolean r1 = r1.zzj     // Catch:{ Exception -> 0x0144 }
            if (r1 == 0) goto L_0x0034
            com.google.android.gms.internal.ads.zzcju r13 = new com.google.android.gms.internal.ads.zzcju     // Catch:{ Exception -> 0x0144 }
            android.content.Context r2 = r9.zza     // Catch:{ Exception -> 0x0144 }
            java.lang.String r4 = r9.zzl     // Catch:{ Exception -> 0x0144 }
            int r5 = r9.zzm     // Catch:{ Exception -> 0x0144 }
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r13
            r3 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0144 }
            r0 = r13
        L_0x0034:
            android.net.Uri r14 = android.net.Uri.parse(r25)     // Catch:{ Exception -> 0x0144 }
            com.google.android.gms.internal.ads.zzazo r1 = new com.google.android.gms.internal.ads.zzazo     // Catch:{ Exception -> 0x0144 }
            r15 = 0
            r16 = 0
            r18 = 0
            r20 = -1
            r22 = 0
            r23 = 0
            r13 = r1
            r13.<init>(r14, r15, r16, r18, r20, r22, r23)     // Catch:{ Exception -> 0x0144 }
            r0.zzb(r1)     // Catch:{ Exception -> 0x0144 }
            java.lang.ref.WeakReference r1 = r9.zzc     // Catch:{ Exception -> 0x0144 }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x0144 }
            com.google.android.gms.internal.ads.zzciy r1 = (com.google.android.gms.internal.ads.zzciy) r1     // Catch:{ Exception -> 0x0144 }
            if (r1 == 0) goto L_0x0059
            r1.zzv(r11, r9)     // Catch:{ Exception -> 0x0144 }
        L_0x0059:
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzt.zzB()     // Catch:{ Exception -> 0x0144 }
            long r2 = r1.currentTimeMillis()     // Catch:{ Exception -> 0x0144 }
            com.google.android.gms.internal.ads.zzbiu r4 = com.google.android.gms.internal.ads.zzbjc.zzw     // Catch:{ Exception -> 0x0144 }
            com.google.android.gms.internal.ads.zzbja r5 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ Exception -> 0x0144 }
            java.lang.Object r4 = r5.zzb(r4)     // Catch:{ Exception -> 0x0144 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ Exception -> 0x0144 }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x0144 }
            com.google.android.gms.internal.ads.zzbiu r6 = com.google.android.gms.internal.ads.zzbjc.zzv     // Catch:{ Exception -> 0x0144 }
            com.google.android.gms.internal.ads.zzbja r7 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ Exception -> 0x0144 }
            java.lang.Object r6 = r7.zzb(r6)     // Catch:{ Exception -> 0x0144 }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ Exception -> 0x0144 }
            long r6 = r6.longValue()     // Catch:{ Exception -> 0x0144 }
            com.google.android.gms.internal.ads.zzcix r8 = r9.zze     // Catch:{ Exception -> 0x0144 }
            int r8 = r8.zzc     // Catch:{ Exception -> 0x0144 }
            java.nio.ByteBuffer r8 = java.nio.ByteBuffer.allocate(r8)     // Catch:{ Exception -> 0x0144 }
            r9.zzi = r8     // Catch:{ Exception -> 0x0144 }
            r8 = 8192(0x2000, float:1.14794E-41)
            byte[] r13 = new byte[r8]     // Catch:{ Exception -> 0x0144 }
            r14 = r2
        L_0x0090:
            java.nio.ByteBuffer r12 = r9.zzi     // Catch:{ Exception -> 0x0144 }
            int r12 = r12.remaining()     // Catch:{ Exception -> 0x0144 }
            int r12 = java.lang.Math.min(r12, r8)     // Catch:{ Exception -> 0x0144 }
            r8 = 0
            int r12 = r0.zza(r13, r8, r12)     // Catch:{ Exception -> 0x0144 }
            r8 = -1
            r18 = r0
            r0 = 1
            if (r12 != r8) goto L_0x00b5
            r9.zzn = r0     // Catch:{ Exception -> 0x0144 }
            com.google.android.gms.internal.ads.zzckm r1 = r9.zzh     // Catch:{ Exception -> 0x0144 }
            java.nio.ByteBuffer r2 = r9.zzi     // Catch:{ Exception -> 0x0144 }
            long r1 = r1.zza(r2)     // Catch:{ Exception -> 0x0144 }
            int r1 = (int) r1     // Catch:{ Exception -> 0x0144 }
            long r1 = (long) r1     // Catch:{ Exception -> 0x0144 }
            r9.zze(r10, r11, r1)     // Catch:{ Exception -> 0x0144 }
            goto L_0x00d4
        L_0x00b5:
            java.lang.Object r8 = r9.zzk     // Catch:{ Exception -> 0x0144 }
            monitor-enter(r8)     // Catch:{ Exception -> 0x0144 }
            boolean r0 = r9.zzf     // Catch:{ all -> 0x013f }
            if (r0 != 0) goto L_0x00c5
            java.nio.ByteBuffer r0 = r9.zzi     // Catch:{ all -> 0x013f }
            r20 = r11
            r11 = 0
            r0.put(r13, r11, r12)     // Catch:{ all -> 0x013d }
            goto L_0x00c7
        L_0x00c5:
            r20 = r11
        L_0x00c7:
            monitor-exit(r8)     // Catch:{ all -> 0x013d }
            java.nio.ByteBuffer r0 = r9.zzi     // Catch:{ Exception -> 0x013b }
            int r0 = r0.remaining()     // Catch:{ Exception -> 0x013b }
            if (r0 > 0) goto L_0x00d5
            r24.zzu()     // Catch:{ Exception -> 0x013b }
            r0 = 1
        L_0x00d4:
            return r0
        L_0x00d5:
            boolean r0 = r9.zzf     // Catch:{ Exception -> 0x013b }
            if (r0 != 0) goto L_0x0117
            long r11 = r1.currentTimeMillis()     // Catch:{ Exception -> 0x013b }
            long r21 = r11 - r14
            int r0 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x00e7
            r24.zzu()     // Catch:{ Exception -> 0x013b }
            r14 = r11
        L_0x00e7:
            long r11 = r11 - r2
            r21 = 1000(0x3e8, double:4.94E-321)
            long r21 = r21 * r6
            int r0 = (r11 > r21 ? 1 : (r11 == r21 ? 0 : -1))
            if (r0 > 0) goto L_0x00f7
            r0 = r18
            r11 = r20
            r8 = 8192(0x2000, float:1.14794E-41)
            goto L_0x0090
        L_0x00f7:
            java.lang.String r1 = "downloadTimeout"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0115 }
            r0.<init>()     // Catch:{ Exception -> 0x0115 }
            java.lang.String r2 = "Timeout exceeded. Limit: "
            r0.append(r2)     // Catch:{ Exception -> 0x0115 }
            r0.append(r6)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r2 = " sec"
            r0.append(r2)     // Catch:{ Exception -> 0x0115 }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ Exception -> 0x0115 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0115 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0115 }
            throw r2     // Catch:{ Exception -> 0x0115 }
        L_0x0115:
            r0 = move-exception
            goto L_0x0149
        L_0x0117:
            java.lang.String r1 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x0115 }
            java.nio.ByteBuffer r2 = r9.zzi     // Catch:{ Exception -> 0x0115 }
            int r2 = r2.limit()     // Catch:{ Exception -> 0x0115 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0115 }
            r3.<init>()     // Catch:{ Exception -> 0x0115 }
            java.lang.String r4 = "Precache abort at "
            r3.append(r4)     // Catch:{ Exception -> 0x0115 }
            r3.append(r2)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r2 = " bytes"
            r3.append(r2)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0115 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0115 }
            throw r0     // Catch:{ Exception -> 0x0115 }
        L_0x013b:
            r0 = move-exception
            goto L_0x0147
        L_0x013d:
            r0 = move-exception
            goto L_0x0142
        L_0x013f:
            r0 = move-exception
            r20 = r11
        L_0x0142:
            monitor-exit(r8)     // Catch:{ all -> 0x013d }
            throw r0     // Catch:{ Exception -> 0x013b }
        L_0x0144:
            r0 = move-exception
            r20 = r11
        L_0x0147:
            java.lang.String r1 = "error"
        L_0x0149:
            java.lang.Class r2 = r0.getClass()
            java.lang.String r2 = r2.getCanonicalName()
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r2 = ":"
            r3.append(r2)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Failed to preload url "
            r2.append(r3)
            r2.append(r10)
            java.lang.String r3 = " Exception: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.google.android.gms.ads.internal.util.zze.zzj(r2)
            r2 = r20
            r9.zzc(r10, r2, r1, r0)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzclh.zzq(java.lang.String):boolean");
    }
}
