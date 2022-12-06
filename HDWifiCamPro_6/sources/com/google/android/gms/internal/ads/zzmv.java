package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzmv implements zzmz {
    public static final zzftn zza = zzmt.zza;
    private static final Random zzb = new Random();
    /* access modifiers changed from: private */
    public final zzcm zzc;
    /* access modifiers changed from: private */
    public final zzck zzd;
    private final HashMap zze;
    private final zzftn zzf;
    private zzmy zzg;
    private zzcn zzh;
    private String zzi;

    public zzmv() {
        throw null;
    }

    private final zzmu zzk(int i, zzsi zzsi) {
        int i2;
        zzmu zzmu = null;
        long j = Long.MAX_VALUE;
        for (zzmu zzmu2 : this.zze.values()) {
            zzmu2.zzg(i, zzsi);
            if (zzmu2.zzj(i, zzsi)) {
                long zzb2 = zzmu2.zzd;
                if (zzb2 == -1 || zzb2 < j) {
                    zzmu = zzmu2;
                    j = zzb2;
                } else if (i2 == 0) {
                    int i3 = zzen.zza;
                    if (!(zzmu.zze == null || zzmu2.zze == null)) {
                        zzmu = zzmu2;
                    }
                }
            }
        }
        if (zzmu != null) {
            return zzmu;
        }
        String zzl = zzl();
        zzmu zzmu3 = new zzmu(this, zzl, i, zzsi);
        this.zze.put(zzl, zzmu3);
        return zzmu3;
    }

    /* access modifiers changed from: private */
    public static String zzl() {
        byte[] bArr = new byte[12];
        zzb.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    @RequiresNonNull({"listener"})
    private final void zzm(zzkp zzkp) {
        if (zzkp.zzb.zzo()) {
            this.zzi = null;
            return;
        }
        zzmu zzmu = (zzmu) this.zze.get(this.zzi);
        zzmu zzk = zzk(zzkp.zzc, zzkp.zzd);
        this.zzi = zzk.zzb;
        zzh(zzkp);
        zzsi zzsi = zzkp.zzd;
        if (zzsi != null && zzsi.zzb()) {
            if (zzmu == null || zzmu.zzd != zzkp.zzd.zzd || zzmu.zze == null || zzmu.zze.zzb != zzkp.zzd.zzb || zzmu.zze.zzc != zzkp.zzd.zzc) {
                zzsi zzsi2 = zzkp.zzd;
                String unused = zzk(zzkp.zzc, new zzsi(zzsi2.zza, zzsi2.zzd)).zzb;
                String unused2 = zzk.zzb;
            }
        }
    }

    public final synchronized String zzd() {
        return this.zzi;
    }

    public final synchronized String zze(zzcn zzcn, zzsi zzsi) {
        return zzk(zzcn.zzn(zzsi.zza, this.zzd).zzd, zzsi).zzb;
    }

    public final synchronized void zzf(zzkp zzkp) {
        zzmy zzmy;
        this.zzi = null;
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzmu zzmu = (zzmu) it.next();
            it.remove();
            if (zzmu.zzf && (zzmy = this.zzg) != null) {
                zzmy.zzd(zzkp, zzmu.zzb, false);
            }
        }
    }

    public final void zzg(zzmy zzmy) {
        this.zzg = zzmy;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        if (r10.zzd.zzd < r0.zzd) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c9, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzh(com.google.android.gms.internal.ads.zzkp r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.google.android.gms.internal.ads.zzmy r0 = r9.zzg     // Catch:{ all -> 0x00cc }
            if (r0 == 0) goto L_0x00ca
            com.google.android.gms.internal.ads.zzcn r0 = r10.zzb     // Catch:{ all -> 0x00cc }
            boolean r0 = r0.zzo()     // Catch:{ all -> 0x00cc }
            if (r0 == 0) goto L_0x000f
            monitor-exit(r9)
            return
        L_0x000f:
            java.util.HashMap r0 = r9.zze     // Catch:{ all -> 0x00cc }
            java.lang.String r1 = r9.zzi     // Catch:{ all -> 0x00cc }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x00cc }
            com.google.android.gms.internal.ads.zzmu r0 = (com.google.android.gms.internal.ads.zzmu) r0     // Catch:{ all -> 0x00cc }
            com.google.android.gms.internal.ads.zzsi r1 = r10.zzd     // Catch:{ all -> 0x00cc }
            if (r1 == 0) goto L_0x0040
            if (r0 == 0) goto L_0x0040
            long r1 = r0.zzd     // Catch:{ all -> 0x00cc }
            r3 = -1
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0032
            int r0 = r0.zzc     // Catch:{ all -> 0x00cc }
            int r1 = r10.zzc     // Catch:{ all -> 0x00cc }
            if (r0 != r1) goto L_0x003e
            goto L_0x0040
        L_0x0032:
            com.google.android.gms.internal.ads.zzsi r1 = r10.zzd     // Catch:{ all -> 0x00cc }
            long r1 = r1.zzd     // Catch:{ all -> 0x00cc }
            long r3 = r0.zzd     // Catch:{ all -> 0x00cc }
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0040
        L_0x003e:
            monitor-exit(r9)
            return
        L_0x0040:
            int r0 = r10.zzc     // Catch:{ all -> 0x00cc }
            com.google.android.gms.internal.ads.zzsi r1 = r10.zzd     // Catch:{ all -> 0x00cc }
            com.google.android.gms.internal.ads.zzmu r0 = r9.zzk(r0, r1)     // Catch:{ all -> 0x00cc }
            java.lang.String r1 = r9.zzi     // Catch:{ all -> 0x00cc }
            if (r1 != 0) goto L_0x0052
            java.lang.String r1 = r0.zzb     // Catch:{ all -> 0x00cc }
            r9.zzi = r1     // Catch:{ all -> 0x00cc }
        L_0x0052:
            com.google.android.gms.internal.ads.zzsi r1 = r10.zzd     // Catch:{ all -> 0x00cc }
            r2 = 1
            if (r1 == 0) goto L_0x009c
            boolean r3 = r1.zzb()     // Catch:{ all -> 0x00cc }
            if (r3 == 0) goto L_0x009c
            com.google.android.gms.internal.ads.zzsi r3 = new com.google.android.gms.internal.ads.zzsi     // Catch:{ all -> 0x00cc }
            java.lang.Object r4 = r1.zza     // Catch:{ all -> 0x00cc }
            long r5 = r1.zzd     // Catch:{ all -> 0x00cc }
            int r1 = r1.zzb     // Catch:{ all -> 0x00cc }
            r3.<init>(r4, r5, r1)     // Catch:{ all -> 0x00cc }
            int r1 = r10.zzc     // Catch:{ all -> 0x00cc }
            com.google.android.gms.internal.ads.zzmu r1 = r9.zzk(r1, r3)     // Catch:{ all -> 0x00cc }
            boolean r3 = r1.zzf     // Catch:{ all -> 0x00cc }
            if (r3 != 0) goto L_0x009c
            r1.zzf = true     // Catch:{ all -> 0x00cc }
            com.google.android.gms.internal.ads.zzcn r3 = r10.zzb     // Catch:{ all -> 0x00cc }
            com.google.android.gms.internal.ads.zzsi r4 = r10.zzd     // Catch:{ all -> 0x00cc }
            java.lang.Object r4 = r4.zza     // Catch:{ all -> 0x00cc }
            com.google.android.gms.internal.ads.zzck r5 = r9.zzd     // Catch:{ all -> 0x00cc }
            r3.zzn(r4, r5)     // Catch:{ all -> 0x00cc }
            com.google.android.gms.internal.ads.zzck r3 = r9.zzd     // Catch:{ all -> 0x00cc }
            com.google.android.gms.internal.ads.zzsi r4 = r10.zzd     // Catch:{ all -> 0x00cc }
            int r4 = r4.zzb     // Catch:{ all -> 0x00cc }
            r3.zzh(r4)     // Catch:{ all -> 0x00cc }
            r3 = 0
            long r5 = com.google.android.gms.internal.ads.zzen.zzz(r3)     // Catch:{ all -> 0x00cc }
            long r7 = com.google.android.gms.internal.ads.zzen.zzz(r3)     // Catch:{ all -> 0x00cc }
            long r5 = r5 + r7
            java.lang.Math.max(r3, r5)     // Catch:{ all -> 0x00cc }
            java.lang.String unused = r1.zzb     // Catch:{ all -> 0x00cc }
        L_0x009c:
            boolean r1 = r0.zzf     // Catch:{ all -> 0x00cc }
            if (r1 != 0) goto L_0x00a8
            r0.zzf = true     // Catch:{ all -> 0x00cc }
            java.lang.String unused = r0.zzb     // Catch:{ all -> 0x00cc }
        L_0x00a8:
            java.lang.String r1 = r0.zzb     // Catch:{ all -> 0x00cc }
            java.lang.String r3 = r9.zzi     // Catch:{ all -> 0x00cc }
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x00cc }
            if (r1 == 0) goto L_0x00c8
            boolean r1 = r0.zzg     // Catch:{ all -> 0x00cc }
            if (r1 != 0) goto L_0x00c8
            r0.zzg = true     // Catch:{ all -> 0x00cc }
            com.google.android.gms.internal.ads.zzmy r1 = r9.zzg     // Catch:{ all -> 0x00cc }
            java.lang.String r0 = r0.zzb     // Catch:{ all -> 0x00cc }
            r1.zzc(r10, r0)     // Catch:{ all -> 0x00cc }
            monitor-exit(r9)
            return
        L_0x00c8:
            monitor-exit(r9)
            return
        L_0x00ca:
            r10 = 0
            throw r10     // Catch:{ all -> 0x00cc }
        L_0x00cc:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmv.zzh(com.google.android.gms.internal.ads.zzkp):void");
    }

    public final synchronized void zzi(zzkp zzkp, int i) {
        if (this.zzg != null) {
            Iterator it = this.zze.values().iterator();
            while (it.hasNext()) {
                zzmu zzmu = (zzmu) it.next();
                if (zzmu.zzk(zzkp)) {
                    it.remove();
                    if (zzmu.zzf) {
                        boolean equals = zzmu.zzb.equals(this.zzi);
                        boolean z = false;
                        if (i == 0 && equals && zzmu.zzg) {
                            z = true;
                        }
                        if (equals) {
                            this.zzi = null;
                        }
                        this.zzg.zzd(zzkp, zzmu.zzb, z);
                    }
                }
            }
            zzm(zzkp);
        } else {
            throw null;
        }
    }

    public final synchronized void zzj(zzkp zzkp) {
        if (this.zzg != null) {
            zzcn zzcn = this.zzh;
            this.zzh = zzkp.zzb;
            Iterator it = this.zze.values().iterator();
            while (it.hasNext()) {
                zzmu zzmu = (zzmu) it.next();
                if (!zzmu.zzl(zzcn, this.zzh) || zzmu.zzk(zzkp)) {
                    it.remove();
                    if (zzmu.zzf) {
                        if (zzmu.zzb.equals(this.zzi)) {
                            this.zzi = null;
                        }
                        this.zzg.zzd(zzkp, zzmu.zzb, false);
                    }
                }
            }
            zzm(zzkp);
        } else {
            throw null;
        }
    }

    public zzmv(zzftn zzftn) {
        this.zzf = zzftn;
        this.zzc = new zzcm();
        this.zzd = new zzck();
        this.zze = new HashMap();
        this.zzh = zzcn.zza;
    }
}
