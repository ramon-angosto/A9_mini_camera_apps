package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzclk extends zzclb implements zzcio {
    public static final /* synthetic */ int zzd = 0;
    private zzcip zze;
    private String zzf;
    private boolean zzg;
    private boolean zzh;
    private zzckt zzi;
    private long zzj;
    private long zzk;

    public zzclk(zzciy zzciy, zzcix zzcix) {
        super(zzciy);
        zzcip zzcip;
        Context context = zzciy.getContext();
        if (zzcix.zzm) {
            zzcip = new zzcmc(context, zzcix, (zzciy) this.zzc.get());
        } else {
            zzcip = new zzckg(context, zzcix, (zzciy) this.zzc.get());
        }
        this.zze = zzcip;
        this.zze.zzI(this);
    }

    protected static final String zzu(String str) {
        return "cache:".concat(String.valueOf(zzcgi.zze(str)));
    }

    private static String zzw(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        return str + "/" + canonicalName + ":" + message;
    }

    private final void zzx(long j) {
        zzs.zza.postDelayed(new zzcli(this), j);
    }

    public final void release() {
        zzcip zzcip = this.zze;
        if (zzcip != null) {
            zzcip.zzI((zzcio) null);
            this.zze.zzE();
        }
    }

    public final void zzC(int i, int i2) {
    }

    public final void zzb() {
        synchronized (this) {
            this.zzg = true;
            notify();
            release();
        }
        String str = this.zzf;
        if (str != null) {
            zzc(this.zzf, zzu(str), "externalAbort", "Programmatic precache abort.");
        }
    }

    public final void zzh(int i) {
        this.zze.zzG(i);
    }

    public final void zzi(boolean z, long j) {
        zzciy zzciy = (zzciy) this.zzc.get();
        if (zzciy != null) {
            zzchc.zze.execute(new zzclj(zzciy, z, j));
        }
    }

    public final zzcip zzj() {
        synchronized (this) {
            this.zzh = true;
            notify();
        }
        this.zze.zzI((zzcio) null);
        zzcip zzcip = this.zze;
        this.zze = null;
        return zzcip;
    }

    public final void zzk(String str, Exception exc) {
        zze.zzk("Precache error", exc);
        zzt.zzo().zzs(exc, "VideoStreamExoPlayerCache.onError");
    }

    public final void zzl(String str, Exception exc) {
        zze.zzk("Precache exception", exc);
        zzt.zzo().zzs(exc, "VideoStreamExoPlayerCache.onException");
    }

    public final void zzm(int i) {
    }

    public final void zzn(int i) {
        this.zze.zzH(i);
    }

    public final void zzo(int i) {
        this.zze.zzJ(i);
    }

    public final void zzp(int i) {
        this.zze.zzK(i);
    }

    public final boolean zzq(String str) {
        return zzr(str, new String[]{str});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x009e, code lost:
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x013e, code lost:
        r5 = r47;
        r6 = r48;
        r7 = r44;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r5.zze(r6, r7, r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzr(java.lang.String r48, java.lang.String[] r49) {
        /*
            r47 = this;
            r15 = r47
            r13 = r48
            r0 = r49
            r15.zzf = r13
            java.lang.String r14 = zzu(r48)
            java.lang.String r17 = "error"
            r18 = 0
            int r1 = r0.length     // Catch:{ Exception -> 0x01d1 }
            android.net.Uri[] r1 = new android.net.Uri[r1]     // Catch:{ Exception -> 0x01d1 }
            r2 = r18
        L_0x0015:
            int r3 = r0.length     // Catch:{ Exception -> 0x01d1 }
            if (r2 >= r3) goto L_0x0023
            r3 = r0[r2]     // Catch:{ Exception -> 0x01d1 }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x01d1 }
            r1[r2] = r3     // Catch:{ Exception -> 0x01d1 }
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0023:
            com.google.android.gms.internal.ads.zzcip r0 = r15.zze     // Catch:{ Exception -> 0x01d1 }
            java.lang.String r2 = r15.zzb     // Catch:{ Exception -> 0x01d1 }
            r0.zzC(r1, r2)     // Catch:{ Exception -> 0x01d1 }
            java.lang.ref.WeakReference r0 = r15.zzc     // Catch:{ Exception -> 0x01d1 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01d1 }
            com.google.android.gms.internal.ads.zzciy r0 = (com.google.android.gms.internal.ads.zzciy) r0     // Catch:{ Exception -> 0x01d1 }
            if (r0 == 0) goto L_0x0037
            r0.zzv(r14, r15)     // Catch:{ Exception -> 0x01d1 }
        L_0x0037:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzt.zzB()     // Catch:{ Exception -> 0x01d1 }
            long r19 = r0.currentTimeMillis()     // Catch:{ Exception -> 0x01d1 }
            com.google.android.gms.internal.ads.zzbiu r1 = com.google.android.gms.internal.ads.zzbjc.zzw     // Catch:{ Exception -> 0x01d1 }
            com.google.android.gms.internal.ads.zzbja r2 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ Exception -> 0x01d1 }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ Exception -> 0x01d1 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x01d1 }
            long r11 = r1.longValue()     // Catch:{ Exception -> 0x01d1 }
            com.google.android.gms.internal.ads.zzbiu r1 = com.google.android.gms.internal.ads.zzbjc.zzv     // Catch:{ Exception -> 0x01d1 }
            com.google.android.gms.internal.ads.zzbja r2 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ Exception -> 0x01d1 }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ Exception -> 0x01d1 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x01d1 }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x01d1 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r9 = r1 * r3
            com.google.android.gms.internal.ads.zzbiu r1 = com.google.android.gms.internal.ads.zzbjc.zzu     // Catch:{ Exception -> 0x01d1 }
            com.google.android.gms.internal.ads.zzbja r2 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ Exception -> 0x01d1 }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ Exception -> 0x01d1 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x01d1 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x01d1 }
            long r6 = (long) r1     // Catch:{ Exception -> 0x01d1 }
            com.google.android.gms.internal.ads.zzbiu r1 = com.google.android.gms.internal.ads.zzbjc.zzbD     // Catch:{ Exception -> 0x01d1 }
            com.google.android.gms.internal.ads.zzbja r2 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ Exception -> 0x01d1 }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ Exception -> 0x01d1 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ Exception -> 0x01d1 }
            boolean r21 = r1.booleanValue()     // Catch:{ Exception -> 0x01d1 }
            r22 = -1
            r1 = r22
        L_0x0088:
            monitor-enter(r47)     // Catch:{ Exception -> 0x01d1 }
            long r3 = r0.currentTimeMillis()     // Catch:{ all -> 0x01c9 }
            long r3 = r3 - r19
            int r3 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r3 > 0) goto L_0x019e
            boolean r3 = r15.zzg     // Catch:{ all -> 0x01c9 }
            if (r3 != 0) goto L_0x0191
            boolean r3 = r15.zzh     // Catch:{ all -> 0x01c9 }
            r24 = 1
            if (r3 == 0) goto L_0x00a1
            monitor-exit(r47)     // Catch:{ all -> 0x01c9 }
            r5 = r15
            goto L_0x015e
        L_0x00a1:
            com.google.android.gms.internal.ads.zzcip r3 = r15.zze     // Catch:{ all -> 0x01c9 }
            boolean r3 = r3.zzR()     // Catch:{ all -> 0x01c9 }
            if (r3 == 0) goto L_0x0184
            com.google.android.gms.internal.ads.zzcip r3 = r15.zze     // Catch:{ all -> 0x01c9 }
            long r4 = r3.zzz()     // Catch:{ all -> 0x01c9 }
            r25 = 0
            int r3 = (r4 > r25 ? 1 : (r4 == r25 ? 0 : -1))
            if (r3 <= 0) goto L_0x0162
            com.google.android.gms.internal.ads.zzcip r3 = r15.zze     // Catch:{ all -> 0x01c9 }
            long r27 = r3.zzv()     // Catch:{ all -> 0x01c9 }
            int r3 = (r27 > r1 ? 1 : (r27 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x012d
            int r1 = (r27 > r25 ? 1 : (r27 == r25 ? 0 : -1))
            if (r1 <= 0) goto L_0x00c6
            r8 = r24
            goto L_0x00c8
        L_0x00c6:
            r8 = r18
        L_0x00c8:
            if (r21 == 0) goto L_0x00d3
            com.google.android.gms.internal.ads.zzcip r1 = r15.zze     // Catch:{ all -> 0x01c9 }
            long r1 = r1.zzA()     // Catch:{ all -> 0x01c9 }
            r29 = r1
            goto L_0x00d5
        L_0x00d3:
            r29 = r22
        L_0x00d5:
            if (r21 == 0) goto L_0x00e0
            com.google.android.gms.internal.ads.zzcip r1 = r15.zze     // Catch:{ all -> 0x01c9 }
            long r1 = r1.zzx()     // Catch:{ all -> 0x01c9 }
            r31 = r1
            goto L_0x00e2
        L_0x00e0:
            r31 = r22
        L_0x00e2:
            if (r21 == 0) goto L_0x00ed
            com.google.android.gms.internal.ads.zzcip r1 = r15.zze     // Catch:{ all -> 0x01c9 }
            long r1 = r1.zzB()     // Catch:{ all -> 0x01c9 }
            r33 = r1
            goto L_0x00ef
        L_0x00ed:
            r33 = r22
        L_0x00ef:
            int r16 = com.google.android.gms.internal.ads.zzcip.zzs()     // Catch:{ all -> 0x0125 }
            int r35 = com.google.android.gms.internal.ads.zzcip.zzu()     // Catch:{ all -> 0x0125 }
            r1 = r47
            r2 = r48
            r3 = r14
            r36 = r4
            r4 = r27
            r38 = r6
            r6 = r36
            r40 = r9
            r9 = r29
            r42 = r11
            r11 = r31
            r44 = r14
            r13 = r33
            r15 = r16
            r16 = r35
            r1.zzg(r2, r3, r4, r6, r8, r9, r11, r13, r15, r16)     // Catch:{ all -> 0x011c }
            r3 = r27
            r1 = r36
            goto L_0x013a
        L_0x011c:
            r0 = move-exception
            r5 = r47
            r6 = r48
            r7 = r44
            goto L_0x01cd
        L_0x0125:
            r0 = move-exception
            r5 = r47
            r6 = r48
            r7 = r14
            goto L_0x01cd
        L_0x012d:
            r38 = r6
            r40 = r9
            r42 = r11
            r44 = r14
            r45 = r1
            r1 = r4
            r3 = r45
        L_0x013a:
            int r5 = (r27 > r1 ? 1 : (r27 == r1 ? 0 : -1))
            if (r5 < 0) goto L_0x0149
            r5 = r47
            r6 = r48
            r7 = r44
            r5.zze(r6, r7, r1)     // Catch:{ all -> 0x01c7 }
            monitor-exit(r47)     // Catch:{ all -> 0x01c7 }
            goto L_0x015e
        L_0x0149:
            r5 = r47
            r6 = r48
            r7 = r44
            com.google.android.gms.internal.ads.zzcip r1 = r5.zze     // Catch:{ all -> 0x01c7 }
            long r1 = r1.zzw()     // Catch:{ all -> 0x01c7 }
            int r1 = (r1 > r38 ? 1 : (r1 == r38 ? 0 : -1))
            if (r1 < 0) goto L_0x015f
            int r1 = (r27 > r25 ? 1 : (r27 == r25 ? 0 : -1))
            if (r1 <= 0) goto L_0x015f
            monitor-exit(r47)     // Catch:{ all -> 0x01c7 }
        L_0x015e:
            return r24
        L_0x015f:
            r1 = r42
            goto L_0x016b
        L_0x0162:
            r38 = r6
            r40 = r9
            r6 = r13
            r7 = r14
            r5 = r15
            r3 = r1
            r1 = r11
        L_0x016b:
            r5.wait(r1)     // Catch:{ InterruptedException -> 0x017a }
            monitor-exit(r47)     // Catch:{ all -> 0x01c7 }
            r11 = r1
            r1 = r3
            r15 = r5
            r13 = r6
            r14 = r7
            r6 = r38
            r9 = r40
            goto L_0x0088
        L_0x017a:
            java.lang.String r1 = "interrupted"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01c3 }
            java.lang.String r2 = "Wait interrupted."
            r0.<init>(r2)     // Catch:{ all -> 0x01c3 }
            throw r0     // Catch:{ all -> 0x01c3 }
        L_0x0184:
            r6 = r13
            r7 = r14
            r5 = r15
            java.lang.String r1 = "exoPlayerReleased"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01c3 }
            java.lang.String r2 = "ExoPlayer was released during preloading."
            r0.<init>(r2)     // Catch:{ all -> 0x01c3 }
            throw r0     // Catch:{ all -> 0x01c3 }
        L_0x0191:
            r6 = r13
            r7 = r14
            r5 = r15
            java.lang.String r1 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01c3 }
            java.lang.String r2 = "Abort requested before buffering finished. "
            r0.<init>(r2)     // Catch:{ all -> 0x01c3 }
            throw r0     // Catch:{ all -> 0x01c3 }
        L_0x019e:
            r40 = r9
            r6 = r13
            r7 = r14
            r5 = r15
            java.lang.String r1 = "downloadTimeout"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01c3 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c3 }
            r2.<init>()     // Catch:{ all -> 0x01c3 }
            java.lang.String r3 = "Timeout reached. Limit: "
            r2.append(r3)     // Catch:{ all -> 0x01c3 }
            r3 = r40
            r2.append(r3)     // Catch:{ all -> 0x01c3 }
            java.lang.String r3 = " ms"
            r2.append(r3)     // Catch:{ all -> 0x01c3 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01c3 }
            r0.<init>(r2)     // Catch:{ all -> 0x01c3 }
            throw r0     // Catch:{ all -> 0x01c3 }
        L_0x01c3:
            r0 = move-exception
            r17 = r1
            goto L_0x01cd
        L_0x01c7:
            r0 = move-exception
            goto L_0x01cd
        L_0x01c9:
            r0 = move-exception
            r6 = r13
            r7 = r14
            r5 = r15
        L_0x01cd:
            monitor-exit(r47)     // Catch:{ all -> 0x01c7 }
            throw r0     // Catch:{ Exception -> 0x01cf }
        L_0x01cf:
            r0 = move-exception
            goto L_0x01d5
        L_0x01d1:
            r0 = move-exception
            r6 = r13
            r7 = r14
            r5 = r15
        L_0x01d5:
            r1 = r17
            java.lang.String r2 = r0.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Failed to preload url "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r4 = " Exception: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            com.google.android.gms.ads.internal.util.zze.zzj(r2)
            com.google.android.gms.internal.ads.zzcfy r2 = com.google.android.gms.ads.internal.zzt.zzo()
            java.lang.String r3 = "VideoStreamExoPlayerCache.preload"
            r2.zzs(r0, r3)
            r47.release()
            java.lang.String r0 = zzw(r1, r0)
            r5.zzc(r6, r7, r1, r0)
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzclk.zzr(java.lang.String, java.lang.String[]):boolean");
    }

    public final boolean zzs(String str, String[] strArr, zzckt zzckt) {
        this.zzf = str;
        this.zzi = zzckt;
        String zzu = zzu(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                uriArr[i] = Uri.parse(strArr[i]);
            }
            this.zze.zzC(uriArr, this.zzb);
            zzciy zzciy = (zzciy) this.zzc.get();
            if (zzciy != null) {
                zzciy.zzv(zzu, this);
            }
            this.zzj = zzt.zzB().currentTimeMillis();
            this.zzk = -1;
            zzx(0);
            return true;
        } catch (Exception e) {
            zze.zzj("Failed to preload url " + str + " Exception: " + e.getMessage());
            zzt.zzo().zzs(e, "VideoStreamExoPlayerCache.preload");
            release();
            zzc(str, zzu, CampaignEx.JSON_NATIVE_VIDEO_ERROR, zzw(CampaignEx.JSON_NATIVE_VIDEO_ERROR, e));
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v24, resolved type: com.google.android.gms.internal.ads.zzclk} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v27, resolved type: com.google.android.gms.internal.ads.zzclk} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v30, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v20, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v22, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v32, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v33, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v34, resolved type: com.google.android.gms.internal.ads.zzclk} */
    /* JADX WARNING: type inference failed for: r2v11, types: [boolean] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0057, code lost:
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x010e, code lost:
        r2.zzx(((java.lang.Long) com.google.android.gms.ads.internal.client.zzay.zzc().zzb(com.google.android.gms.internal.ads.zzbjc.zzw)).longValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0121, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zzt() {
        /*
            r32 = this;
            r15 = r32
            java.lang.String r0 = r15.zzf
            java.lang.String r13 = zzu(r0)
            java.lang.String r17 = "error"
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzv     // Catch:{ Exception -> 0x016b }
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ Exception -> 0x016b }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ Exception -> 0x016b }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ Exception -> 0x016b }
            long r0 = r0.longValue()     // Catch:{ Exception -> 0x016b }
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r2
            com.google.android.gms.internal.ads.zzbiu r2 = com.google.android.gms.internal.ads.zzbjc.zzu     // Catch:{ Exception -> 0x016b }
            com.google.android.gms.internal.ads.zzbja r3 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ Exception -> 0x016b }
            java.lang.Object r2 = r3.zzb(r2)     // Catch:{ Exception -> 0x016b }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x016b }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x016b }
            long r11 = (long) r2     // Catch:{ Exception -> 0x016b }
            com.google.android.gms.internal.ads.zzbiu r2 = com.google.android.gms.internal.ads.zzbjc.zzbD     // Catch:{ Exception -> 0x016b }
            com.google.android.gms.internal.ads.zzbja r3 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ Exception -> 0x016b }
            java.lang.Object r2 = r3.zzb(r2)     // Catch:{ Exception -> 0x016b }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x016b }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x016b }
            monitor-enter(r32)     // Catch:{ Exception -> 0x016b }
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzt.zzB()     // Catch:{ all -> 0x0164 }
            long r3 = r3.currentTimeMillis()     // Catch:{ all -> 0x0164 }
            long r5 = r15.zzj     // Catch:{ all -> 0x0164 }
            long r3 = r3 - r5
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 > 0) goto L_0x013e
            boolean r0 = r15.zzg     // Catch:{ all -> 0x0164 }
            if (r0 != 0) goto L_0x012e
            boolean r0 = r15.zzh     // Catch:{ all -> 0x0164 }
            if (r0 == 0) goto L_0x005a
            monitor-exit(r32)     // Catch:{ all -> 0x0164 }
            r2 = r15
            goto L_0x01a7
        L_0x005a:
            com.google.android.gms.internal.ads.zzcip r0 = r15.zze     // Catch:{ all -> 0x0164 }
            boolean r0 = r0.zzR()     // Catch:{ all -> 0x0164 }
            if (r0 == 0) goto L_0x0122
            com.google.android.gms.internal.ads.zzcip r0 = r15.zze     // Catch:{ all -> 0x0164 }
            long r9 = r0.zzz()     // Catch:{ all -> 0x0164 }
            r18 = 0
            int r0 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1))
            if (r0 <= 0) goto L_0x010b
            com.google.android.gms.internal.ads.zzcip r0 = r15.zze     // Catch:{ all -> 0x0164 }
            long r6 = r0.zzv()     // Catch:{ all -> 0x0164 }
            long r0 = r15.zzk     // Catch:{ all -> 0x0164 }
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x00de
            int r0 = (r6 > r18 ? 1 : (r6 == r18 ? 0 : -1))
            if (r0 <= 0) goto L_0x0080
            r0 = 1
            goto L_0x0081
        L_0x0080:
            r0 = 0
        L_0x0081:
            r8 = r0
            java.lang.String r0 = r15.zzf     // Catch:{ all -> 0x00d9 }
            r3 = -1
            if (r2 == 0) goto L_0x008f
            com.google.android.gms.internal.ads.zzcip r1 = r15.zze     // Catch:{ all -> 0x0164 }
            long r20 = r1.zzA()     // Catch:{ all -> 0x0164 }
            goto L_0x0091
        L_0x008f:
            r20 = r3
        L_0x0091:
            if (r2 == 0) goto L_0x009a
            com.google.android.gms.internal.ads.zzcip r1 = r15.zze     // Catch:{ all -> 0x0164 }
            long r22 = r1.zzx()     // Catch:{ all -> 0x0164 }
            goto L_0x009c
        L_0x009a:
            r22 = r3
        L_0x009c:
            if (r2 == 0) goto L_0x00a7
            com.google.android.gms.internal.ads.zzcip r1 = r15.zze     // Catch:{ all -> 0x0164 }
            long r1 = r1.zzB()     // Catch:{ all -> 0x0164 }
            r24 = r1
            goto L_0x00a9
        L_0x00a7:
            r24 = r3
        L_0x00a9:
            int r16 = com.google.android.gms.internal.ads.zzcip.zzs()     // Catch:{ all -> 0x00d9 }
            int r26 = com.google.android.gms.internal.ads.zzcip.zzu()     // Catch:{ all -> 0x00d9 }
            r1 = r32
            r2 = r0
            r3 = r13
            r4 = r6
            r27 = r6
            r6 = r9
            r29 = r9
            r9 = r20
            r20 = r11
            r11 = r22
            r31 = r13
            r13 = r24
            r15 = r16
            r16 = r26
            r1.zzg(r2, r3, r4, r6, r8, r9, r11, r13, r15, r16)     // Catch:{ all -> 0x00d5 }
            r2 = r32
            r0 = r27
            r2.zzk = r0     // Catch:{ all -> 0x00f3 }
            r3 = r29
            goto L_0x00e5
        L_0x00d5:
            r0 = move-exception
            r2 = r32
            goto L_0x00f4
        L_0x00d9:
            r0 = move-exception
            r2 = r15
            r5 = r13
            goto L_0x0167
        L_0x00de:
            r0 = r6
            r20 = r11
            r31 = r13
            r2 = r15
            r3 = r9
        L_0x00e5:
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x00f8
            java.lang.String r0 = r2.zzf     // Catch:{ all -> 0x00f3 }
            r5 = r31
            r2.zze(r0, r5, r3)     // Catch:{ all -> 0x0162 }
            monitor-exit(r32)     // Catch:{ all -> 0x0162 }
            goto L_0x01a7
        L_0x00f3:
            r0 = move-exception
        L_0x00f4:
            r5 = r31
            goto L_0x0167
        L_0x00f8:
            r5 = r31
            com.google.android.gms.internal.ads.zzcip r3 = r2.zze     // Catch:{ all -> 0x0162 }
            long r3 = r3.zzw()     // Catch:{ all -> 0x0162 }
            int r3 = (r3 > r20 ? 1 : (r3 == r20 ? 0 : -1))
            if (r3 < 0) goto L_0x010d
            int r0 = (r0 > r18 ? 1 : (r0 == r18 ? 0 : -1))
            if (r0 <= 0) goto L_0x010d
            monitor-exit(r32)     // Catch:{ all -> 0x0162 }
            goto L_0x01a7
        L_0x010b:
            r5 = r13
            r2 = r15
        L_0x010d:
            monitor-exit(r32)     // Catch:{ all -> 0x0162 }
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzw
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            r2.zzx(r0)
            return
        L_0x0122:
            r5 = r13
            r2 = r15
            java.lang.String r1 = "exoPlayerReleased"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x013a }
            java.lang.String r3 = "ExoPlayer was released during preloading."
            r0.<init>(r3)     // Catch:{ all -> 0x013a }
            throw r0     // Catch:{ all -> 0x013a }
        L_0x012e:
            r5 = r13
            r2 = r15
            java.lang.String r1 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x013a }
            java.lang.String r3 = "Abort requested before buffering finished. "
            r0.<init>(r3)     // Catch:{ all -> 0x013a }
            throw r0     // Catch:{ all -> 0x013a }
        L_0x013a:
            r0 = move-exception
            r17 = r1
            goto L_0x0167
        L_0x013e:
            r5 = r13
            r2 = r15
            java.lang.String r3 = "downloadTimeout"
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x015e }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x015e }
            r6.<init>()     // Catch:{ all -> 0x015e }
            java.lang.String r7 = "Timeout reached. Limit: "
            r6.append(r7)     // Catch:{ all -> 0x015e }
            r6.append(r0)     // Catch:{ all -> 0x015e }
            java.lang.String r0 = " ms"
            r6.append(r0)     // Catch:{ all -> 0x015e }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x015e }
            r4.<init>(r0)     // Catch:{ all -> 0x015e }
            throw r4     // Catch:{ all -> 0x015e }
        L_0x015e:
            r0 = move-exception
            r17 = r3
            goto L_0x0167
        L_0x0162:
            r0 = move-exception
            goto L_0x0167
        L_0x0164:
            r0 = move-exception
            r5 = r13
            r2 = r15
        L_0x0167:
            monitor-exit(r32)     // Catch:{ all -> 0x0162 }
            throw r0     // Catch:{ Exception -> 0x0169 }
        L_0x0169:
            r0 = move-exception
            goto L_0x016e
        L_0x016b:
            r0 = move-exception
            r5 = r13
            r2 = r15
        L_0x016e:
            r1 = r17
            java.lang.String r3 = r2.zzf
            java.lang.String r4 = r0.getMessage()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Failed to preload url "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r3 = " Exception: "
            r6.append(r3)
            r6.append(r4)
            java.lang.String r3 = r6.toString()
            com.google.android.gms.ads.internal.util.zze.zzj(r3)
            com.google.android.gms.internal.ads.zzcfy r3 = com.google.android.gms.ads.internal.zzt.zzo()
            java.lang.String r4 = "VideoStreamExoPlayerCache.preload"
            r3.zzs(r0, r4)
            r32.release()
            java.lang.String r0 = zzw(r1, r0)
            java.lang.String r3 = r2.zzf
            r2.zzc(r3, r5, r1, r0)
        L_0x01a7:
            com.google.android.gms.internal.ads.zzcku r0 = com.google.android.gms.ads.internal.zzt.zzy()
            com.google.android.gms.internal.ads.zzckt r1 = r2.zzi
            r0.zzc(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzclk.zzt():void");
    }

    public final void zzv() {
        zze.zzj("Precache onRenderedFirstFrame");
    }
}
