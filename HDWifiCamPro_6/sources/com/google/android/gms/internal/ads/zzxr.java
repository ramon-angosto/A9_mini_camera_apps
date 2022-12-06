package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.Display;
import android.view.Surface;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzxr {
    private final zzxd zza = new zzxd();
    private final zzxn zzb;
    private final zzxq zzc;
    private boolean zzd;
    private Surface zze;
    private float zzf;
    private float zzg;
    private float zzh;
    private float zzi;
    private int zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;

    public zzxr(Context context) {
        zzxn zzxn;
        zzxq zzxq = null;
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            int i = zzen.zza;
            zzxn zzc2 = zzxp.zzc(applicationContext);
            zzxn = zzc2 == null ? zzxo.zzc(applicationContext) : zzc2;
        } else {
            zzxn = null;
        }
        this.zzb = zzxn;
        this.zzc = this.zzb != null ? zzxq.zza() : zzxq;
        this.zzk = C.TIME_UNSET;
        this.zzl = C.TIME_UNSET;
        this.zzf = -1.0f;
        this.zzi = 1.0f;
        this.zzj = 0;
    }

    public static /* synthetic */ void zzb(zzxr zzxr, Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            zzxr.zzk = refreshRate;
            zzxr.zzl = (refreshRate * 80) / 100;
            return;
        }
        zzdw.zze("VideoFrameReleaseHelper", "Unable to query display refresh rate");
        zzxr.zzk = C.TIME_UNSET;
        zzxr.zzl = C.TIME_UNSET;
    }

    private final void zzk() {
        Surface surface;
        if (zzen.zza >= 30 && (surface = this.zze) != null && this.zzj != Integer.MIN_VALUE && this.zzh != 0.0f) {
            this.zzh = 0.0f;
            zzxm.zza(surface, 0.0f);
        }
    }

    private final void zzl() {
        this.zzm = 0;
        this.zzp = -1;
        this.zzn = -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
        if (java.lang.Math.abs(r0 - r9.zzg) >= r2) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        if (r9.zza.zzb() >= 30) goto L_0x0064;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzm() {
        /*
            r9 = this;
            int r0 = com.google.android.gms.internal.ads.zzen.zza
            r1 = 30
            if (r0 < r1) goto L_0x006d
            android.view.Surface r0 = r9.zze
            if (r0 != 0) goto L_0x000b
            goto L_0x006d
        L_0x000b:
            com.google.android.gms.internal.ads.zzxd r0 = r9.zza
            boolean r0 = r0.zzg()
            if (r0 == 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzxd r0 = r9.zza
            float r0 = r0.zza()
            goto L_0x001c
        L_0x001a:
            float r0 = r9.zzf
        L_0x001c:
            float r2 = r9.zzg
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 != 0) goto L_0x0023
            return
        L_0x0023:
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0058
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzxd r1 = r9.zza
            boolean r1 = r1.zzg()
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L_0x004b
            com.google.android.gms.internal.ads.zzxd r1 = r9.zza
            long r3 = r1.zzd()
            r7 = 5000000000(0x12a05f200, double:2.470328229E-314)
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 < 0) goto L_0x004b
            r2 = 1017370378(0x3ca3d70a, float:0.02)
        L_0x004b:
            float r1 = r9.zzg
            float r1 = r0 - r1
            float r1 = java.lang.Math.abs(r1)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 < 0) goto L_0x0063
            goto L_0x0064
        L_0x0058:
            if (r4 != 0) goto L_0x0068
            com.google.android.gms.internal.ads.zzxd r2 = r9.zza
            int r2 = r2.zzb()
            if (r2 < r1) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r5 = r6
        L_0x0064:
            if (r5 == 0) goto L_0x0067
            goto L_0x0068
        L_0x0067:
            return
        L_0x0068:
            r9.zzg = r0
            r9.zzn(r6)
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxr.zzm():void");
    }

    private final void zzn(boolean z) {
        Surface surface;
        if (zzen.zza >= 30 && (surface = this.zze) != null && this.zzj != Integer.MIN_VALUE) {
            float f = 0.0f;
            if (this.zzd) {
                float f2 = this.zzg;
                if (f2 != -1.0f) {
                    f = this.zzi * f2;
                }
            }
            if (z || this.zzh != f) {
                this.zzh = f;
                zzxm.zza(surface, f);
            }
        }
    }

    public final long zza(long j) {
        long j2;
        if (this.zzp != -1 && this.zza.zzg()) {
            long zzc2 = this.zza.zzc();
            long j3 = ((long) (((float) (zzc2 * (this.zzm - this.zzp))) / this.zzi)) + this.zzq;
            if (Math.abs(j - j3) <= 20000000) {
                j = j3;
            } else {
                zzl();
            }
        }
        this.zzn = this.zzm;
        this.zzo = j;
        zzxq zzxq = this.zzc;
        if (zzxq == null || this.zzk == C.TIME_UNSET) {
            return j;
        }
        long j4 = zzxq.zza;
        if (j4 == C.TIME_UNSET) {
            return j;
        }
        long j5 = this.zzk;
        long j6 = j4 + (((j - j4) / j5) * j5);
        if (j <= j6) {
            j2 = j6 - j5;
        } else {
            long j7 = j6;
            j6 = j5 + j6;
            j2 = j7;
        }
        if (j6 - j >= j - j2) {
            j6 = j2;
        }
        return j6 - this.zzl;
    }

    public final void zzc(float f) {
        this.zzf = f;
        this.zza.zzf();
        zzm();
    }

    public final void zzd(long j) {
        long j2 = this.zzn;
        if (j2 != -1) {
            this.zzp = j2;
            this.zzq = this.zzo;
        }
        this.zzm++;
        this.zza.zze(j * 1000);
        zzm();
    }

    public final void zze(float f) {
        this.zzi = f;
        zzl();
        zzn(false);
    }

    public final void zzf() {
        zzl();
    }

    public final void zzg() {
        this.zzd = true;
        zzl();
        if (this.zzb != null) {
            zzxq zzxq = this.zzc;
            if (zzxq != null) {
                zzxq.zzb();
                this.zzb.zzb(new zzxl(this));
            } else {
                throw null;
            }
        }
        zzn(false);
    }

    public final void zzh() {
        this.zzd = false;
        zzxn zzxn = this.zzb;
        if (zzxn != null) {
            zzxn.zza();
            zzxq zzxq = this.zzc;
            if (zzxq != null) {
                zzxq.zzc();
            } else {
                throw null;
            }
        }
        zzk();
    }

    public final void zzi(Surface surface) {
        if (true == (surface instanceof zzxj)) {
            surface = null;
        }
        if (this.zze != surface) {
            zzk();
            this.zze = surface;
            zzn(true);
        }
    }

    public final void zzj(int i) {
        if (this.zzj != i) {
            this.zzj = i;
            zzn(true);
        }
    }
}
