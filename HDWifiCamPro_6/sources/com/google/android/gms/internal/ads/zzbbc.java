package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbbc {
    private final zzbbb zza;
    private final boolean zzb;
    private final long zzc;
    private final long zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private boolean zzh;
    private long zzi;
    private long zzj;
    private long zzk;

    public zzbbc() {
        this(-1.0d);
    }

    private final boolean zzd(long j, long j2) {
        return Math.abs((j2 - this.zzi) - (j - this.zzj)) > 20000000;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0084 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zza(long r12, long r14) {
        /*
            r11 = this;
            r0 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r12
            boolean r2 = r11.zzh
            if (r2 == 0) goto L_0x0041
            long r2 = r11.zze
            int r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0018
            long r2 = r11.zzk
            r4 = 1
            long r2 = r2 + r4
            r11.zzk = r2
            long r2 = r11.zzg
            r11.zzf = r2
        L_0x0018:
            long r2 = r11.zzk
            r4 = 6
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r5 = 0
            if (r4 < 0) goto L_0x0039
            long r6 = r11.zzj
            long r6 = r0 - r6
            long r6 = r6 / r2
            long r2 = r11.zzf
            long r2 = r2 + r6
            boolean r4 = r11.zzd(r2, r14)
            if (r4 == 0) goto L_0x0032
            r11.zzh = r5
            goto L_0x0041
        L_0x0032:
            long r4 = r11.zzi
            long r4 = r4 + r2
            long r6 = r11.zzj
            long r4 = r4 - r6
            goto L_0x0043
        L_0x0039:
            boolean r2 = r11.zzd(r0, r14)
            if (r2 == 0) goto L_0x0041
            r11.zzh = r5
        L_0x0041:
            r4 = r14
            r2 = r0
        L_0x0043:
            boolean r6 = r11.zzh
            r7 = 0
            if (r6 != 0) goto L_0x0052
            r11.zzj = r0
            r11.zzi = r14
            r11.zzk = r7
            r14 = 1
            r11.zzh = r14
        L_0x0052:
            r11.zze = r12
            r11.zzg = r2
            com.google.android.gms.internal.ads.zzbbb r12 = r11.zza
            if (r12 == 0) goto L_0x0084
            long r12 = r12.zza
            int r12 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r12 != 0) goto L_0x0061
            goto L_0x0084
        L_0x0061:
            com.google.android.gms.internal.ads.zzbbb r12 = r11.zza
            long r12 = r12.zza
            long r14 = r11.zzc
            long r0 = r4 - r12
            long r0 = r0 / r14
            long r0 = r0 * r14
            long r12 = r12 + r0
            int r0 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r0 > 0) goto L_0x0073
            long r14 = r12 - r14
            goto L_0x0077
        L_0x0073:
            long r14 = r14 + r12
            r9 = r12
            r12 = r14
            r14 = r9
        L_0x0077:
            long r0 = r12 - r4
            long r4 = r4 - r14
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x007f
            goto L_0x0080
        L_0x007f:
            r12 = r14
        L_0x0080:
            long r14 = r11.zzd
            long r12 = r12 - r14
            return r12
        L_0x0084:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbc.zza(long, long):long");
    }

    public final void zzb() {
        if (this.zzb) {
            this.zza.zzc();
        }
    }

    public final void zzc() {
        this.zzh = false;
        if (this.zzb) {
            this.zza.zzb();
        }
    }

    private zzbbc(double d) {
        long j;
        boolean z = d != -1.0d;
        this.zzb = z;
        if (z) {
            this.zza = zzbbb.zza();
            long j2 = (long) (1.0E9d / d);
            this.zzc = j2;
            j = (j2 * 80) / 100;
        } else {
            this.zza = null;
            j = -1;
            this.zzc = -1;
        }
        this.zzd = j;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzbbc(android.content.Context r3) {
        /*
            r2 = this;
            java.lang.String r0 = "window"
            java.lang.Object r3 = r3.getSystemService(r0)
            android.view.WindowManager r3 = (android.view.WindowManager) r3
            android.view.Display r0 = r3.getDefaultDisplay()
            if (r0 == 0) goto L_0x0018
            android.view.Display r3 = r3.getDefaultDisplay()
            float r3 = r3.getRefreshRate()
            double r0 = (double) r3
            goto L_0x001a
        L_0x0018:
            r0 = -4616189618054758400(0xbff0000000000000, double:-1.0)
        L_0x001a:
            r2.<init>((double) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbc.<init>(android.content.Context):void");
    }
}
