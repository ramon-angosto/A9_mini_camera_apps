package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzagv implements zzahc {
    private final zzee zza;
    private final zzef zzb;
    private final String zzc;
    private String zzd;
    private zzaap zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private long zzi;
    private zzaf zzj;
    private int zzk;
    private long zzl;

    public zzagv() {
        this((String) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0105, code lost:
        r11.zzf = 1;
        r6 = r11.zzb;
        r6.zzH()[0] = -84;
        r3 = r6.zzH();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0115, code lost:
        if (r0 != 65) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0117, code lost:
        r4 = 65;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0118, code lost:
        r3[1] = r4;
        r11.zzg = 2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzef r12) {
        /*
            r11 = this;
            com.google.android.gms.internal.ads.zzaap r0 = r11.zze
            com.google.android.gms.internal.ads.zzdd.zzb(r0)
        L_0x0005:
            int r0 = r12.zza()
            if (r0 <= 0) goto L_0x011e
            int r0 = r11.zzf
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x00d9
            if (r0 == r2) goto L_0x004c
            int r0 = r12.zza()
            int r1 = r11.zzk
            int r2 = r11.zzg
            int r1 = r1 - r2
            int r0 = java.lang.Math.min(r0, r1)
            com.google.android.gms.internal.ads.zzaap r1 = r11.zze
            r1.zzq(r12, r0)
            int r1 = r11.zzg
            int r1 = r1 + r0
            r11.zzg = r1
            int r8 = r11.zzk
            if (r1 != r8) goto L_0x0005
            long r5 = r11.zzl
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x0049
            com.google.android.gms.internal.ads.zzaap r4 = r11.zze
            r7 = 1
            r9 = 0
            r10 = 0
            r4.zzs(r5, r7, r8, r9, r10)
            long r0 = r11.zzl
            long r4 = r11.zzi
            long r0 = r0 + r4
            r11.zzl = r0
        L_0x0049:
            r11.zzf = r3
            goto L_0x0005
        L_0x004c:
            com.google.android.gms.internal.ads.zzef r0 = r11.zzb
            byte[] r0 = r0.zzH()
            int r2 = r12.zza()
            int r4 = r11.zzg
            r5 = 16
            int r4 = 16 - r4
            int r2 = java.lang.Math.min(r2, r4)
            int r4 = r11.zzg
            r12.zzB(r0, r4, r2)
            int r0 = r11.zzg
            int r0 = r0 + r2
            r11.zzg = r0
            if (r0 != r5) goto L_0x0005
            com.google.android.gms.internal.ads.zzee r0 = r11.zza
            r0.zzh(r3)
            com.google.android.gms.internal.ads.zzee r0 = r11.zza
            com.google.android.gms.internal.ads.zzyl r0 = com.google.android.gms.internal.ads.zzym.zza(r0)
            com.google.android.gms.internal.ads.zzaf r2 = r11.zzj
            java.lang.String r4 = "audio/ac4"
            if (r2 == 0) goto L_0x008f
            int r6 = r2.zzz
            if (r6 != r1) goto L_0x008f
            int r6 = r0.zza
            int r7 = r2.zzA
            if (r6 != r7) goto L_0x008f
            java.lang.String r2 = r2.zzm
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L_0x00b6
        L_0x008f:
            com.google.android.gms.internal.ads.zzad r2 = new com.google.android.gms.internal.ads.zzad
            r2.<init>()
            java.lang.String r6 = r11.zzd
            r2.zzH(r6)
            r2.zzS(r4)
            r2.zzw(r1)
            int r4 = r0.zza
            r2.zzT(r4)
            java.lang.String r4 = r11.zzc
            r2.zzK(r4)
            com.google.android.gms.internal.ads.zzaf r2 = r2.zzY()
            r11.zzj = r2
            com.google.android.gms.internal.ads.zzaap r2 = r11.zze
            com.google.android.gms.internal.ads.zzaf r4 = r11.zzj
            r2.zzk(r4)
        L_0x00b6:
            int r2 = r0.zzb
            r11.zzk = r2
            int r0 = r0.zzc
            long r6 = (long) r0
            r8 = 1000000(0xf4240, double:4.940656E-318)
            long r6 = r6 * r8
            com.google.android.gms.internal.ads.zzaf r0 = r11.zzj
            int r0 = r0.zzA
            long r8 = (long) r0
            long r6 = r6 / r8
            r11.zzi = r6
            com.google.android.gms.internal.ads.zzef r0 = r11.zzb
            r0.zzF(r3)
            com.google.android.gms.internal.ads.zzaap r0 = r11.zze
            com.google.android.gms.internal.ads.zzef r2 = r11.zzb
            r0.zzq(r2, r5)
            r11.zzf = r1
            goto L_0x0005
        L_0x00d9:
            int r0 = r12.zza()
            if (r0 <= 0) goto L_0x0005
            boolean r0 = r11.zzh
            r4 = 172(0xac, float:2.41E-43)
            if (r0 != 0) goto L_0x00f1
            int r0 = r12.zzk()
            if (r0 != r4) goto L_0x00ed
            r0 = r2
            goto L_0x00ee
        L_0x00ed:
            r0 = r3
        L_0x00ee:
            r11.zzh = r0
            goto L_0x00d9
        L_0x00f1:
            int r0 = r12.zzk()
            if (r0 != r4) goto L_0x00f9
            r4 = r2
            goto L_0x00fa
        L_0x00f9:
            r4 = r3
        L_0x00fa:
            r11.zzh = r4
            r4 = 64
            r5 = 65
            if (r0 == r4) goto L_0x0105
            if (r0 != r5) goto L_0x00d9
            r0 = r5
        L_0x0105:
            r11.zzf = r2
            com.google.android.gms.internal.ads.zzef r6 = r11.zzb
            byte[] r7 = r6.zzH()
            r8 = -84
            r7[r3] = r8
            byte[] r3 = r6.zzH()
            if (r0 != r5) goto L_0x0118
            r4 = r5
        L_0x0118:
            r3[r2] = r4
            r11.zzg = r1
            goto L_0x0005
        L_0x011e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagv.zza(com.google.android.gms.internal.ads.zzef):void");
    }

    public final void zzb(zzzl zzzl, zzaio zzaio) {
        zzaio.zzc();
        this.zzd = zzaio.zzb();
        this.zze = zzzl.zzv(zzaio.zza(), 1);
    }

    public final void zzc() {
    }

    public final void zzd(long j, int i) {
        if (j != C.TIME_UNSET) {
            this.zzl = j;
        }
    }

    public final void zze() {
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = false;
        this.zzl = C.TIME_UNSET;
    }

    public zzagv(String str) {
        this.zza = new zzee(new byte[16], 16);
        this.zzb = new zzef(this.zza.zza);
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = false;
        this.zzl = C.TIME_UNSET;
        this.zzc = str;
    }
}
