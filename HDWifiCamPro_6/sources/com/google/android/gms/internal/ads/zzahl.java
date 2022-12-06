package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzahl implements zzahc {
    private final zzaid zza;
    private final zzahr zzb = new zzahr(7, 128);
    private final zzahr zzc = new zzahr(8, 128);
    private final zzahr zzd = new zzahr(6, 128);
    private long zze;
    private final boolean[] zzf = new boolean[3];
    private String zzg;
    private zzaap zzh;
    private zzahk zzi;
    private boolean zzj;
    private long zzk = C.TIME_UNSET;
    private boolean zzl;
    private final zzef zzm = new zzef();

    public zzahl(zzaid zzaid, boolean z, boolean z2) {
        this.zza = zzaid;
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzf(byte[] bArr, int i, int i2) {
        if (!this.zzj) {
            this.zzb.zza(bArr, i, i2);
            this.zzc.zza(bArr, i, i2);
        }
        this.zzd.zza(bArr, i, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0181 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzef r20) {
        /*
            r19 = this;
            r0 = r19
            com.google.android.gms.internal.ads.zzaap r1 = r0.zzh
            com.google.android.gms.internal.ads.zzdd.zzb(r1)
            int r1 = com.google.android.gms.internal.ads.zzen.zza
            int r1 = r20.zzc()
            int r2 = r20.zzd()
            byte[] r3 = r20.zzH()
            long r4 = r0.zze
            int r6 = r20.zza()
            long r6 = (long) r6
            long r4 = r4 + r6
            r0.zze = r4
            com.google.android.gms.internal.ads.zzaap r4 = r0.zzh
            int r5 = r20.zza()
            r6 = r20
            r4.zzq(r6, r5)
        L_0x002a:
            boolean[] r4 = r0.zzf
            int r4 = com.google.android.gms.internal.ads.zzaaf.zza(r3, r1, r2, r4)
            if (r4 == r2) goto L_0x0191
            int r5 = r4 + 3
            byte r6 = r3[r5]
            r10 = r6 & 31
            int r6 = r4 - r1
            if (r6 <= 0) goto L_0x003f
            r0.zzf(r3, r1, r4)
        L_0x003f:
            int r14 = r2 - r4
            long r7 = r0.zze
            long r11 = (long) r14
            long r8 = r7 - r11
            if (r6 >= 0) goto L_0x004a
            int r4 = -r6
            goto L_0x004b
        L_0x004a:
            r4 = 0
        L_0x004b:
            long r6 = r0.zzk
            boolean r11 = r0.zzj
            r12 = 4
            if (r11 == 0) goto L_0x0058
        L_0x0052:
            r18 = r2
            r17 = r5
            goto L_0x0137
        L_0x0058:
            com.google.android.gms.internal.ads.zzahr r11 = r0.zzb
            r11.zzd(r4)
            com.google.android.gms.internal.ads.zzahr r11 = r0.zzc
            r11.zzd(r4)
            boolean r11 = r0.zzj
            if (r11 != 0) goto L_0x00fc
            com.google.android.gms.internal.ads.zzahr r11 = r0.zzb
            boolean r11 = r11.zze()
            if (r11 == 0) goto L_0x0052
            com.google.android.gms.internal.ads.zzahr r11 = r0.zzc
            boolean r11 = r11.zze()
            if (r11 == 0) goto L_0x0052
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            com.google.android.gms.internal.ads.zzahr r13 = r0.zzb
            byte[] r15 = r13.zza
            int r13 = r13.zzb
            byte[] r13 = java.util.Arrays.copyOf(r15, r13)
            r11.add(r13)
            com.google.android.gms.internal.ads.zzahr r13 = r0.zzc
            byte[] r15 = r13.zza
            int r13 = r13.zzb
            byte[] r13 = java.util.Arrays.copyOf(r15, r13)
            r11.add(r13)
            com.google.android.gms.internal.ads.zzahr r13 = r0.zzb
            byte[] r15 = r13.zza
            int r13 = r13.zzb
            com.google.android.gms.internal.ads.zzaae r13 = com.google.android.gms.internal.ads.zzaaf.zzd(r15, r12, r13)
            com.google.android.gms.internal.ads.zzahr r15 = r0.zzc
            byte[] r1 = r15.zza
            int r15 = r15.zzb
            com.google.android.gms.internal.ads.zzaad r1 = com.google.android.gms.internal.ads.zzaaf.zzc(r1, r12, r15)
            int r15 = r13.zza
            int r12 = r13.zzb
            r17 = r5
            int r5 = r13.zzc
            java.lang.String r5 = com.google.android.gms.internal.ads.zzdf.zza(r15, r12, r5)
            com.google.android.gms.internal.ads.zzaap r12 = r0.zzh
            com.google.android.gms.internal.ads.zzad r15 = new com.google.android.gms.internal.ads.zzad
            r15.<init>()
            r18 = r2
            java.lang.String r2 = r0.zzg
            r15.zzH(r2)
            java.lang.String r2 = "video/avc"
            r15.zzS(r2)
            r15.zzx(r5)
            int r2 = r13.zze
            r15.zzX(r2)
            int r2 = r13.zzf
            r15.zzF(r2)
            float r2 = r13.zzg
            r15.zzP(r2)
            r15.zzI(r11)
            com.google.android.gms.internal.ads.zzaf r2 = r15.zzY()
            r12.zzk(r2)
            r2 = 1
            r0.zzj = r2
            com.google.android.gms.internal.ads.zzahk r2 = r0.zzi
            r2.zzb(r13)
            com.google.android.gms.internal.ads.zzahk r2 = r0.zzi
            r2.zza(r1)
            com.google.android.gms.internal.ads.zzahr r1 = r0.zzb
            r1.zzb()
            com.google.android.gms.internal.ads.zzahr r1 = r0.zzc
            r1.zzb()
            goto L_0x0137
        L_0x00fc:
            r18 = r2
            r17 = r5
            com.google.android.gms.internal.ads.zzahr r1 = r0.zzb
            boolean r2 = r1.zze()
            if (r2 == 0) goto L_0x011c
            byte[] r2 = r1.zza
            int r1 = r1.zzb
            r5 = 4
            com.google.android.gms.internal.ads.zzaae r1 = com.google.android.gms.internal.ads.zzaaf.zzd(r2, r5, r1)
            com.google.android.gms.internal.ads.zzahk r2 = r0.zzi
            r2.zzb(r1)
            com.google.android.gms.internal.ads.zzahr r1 = r0.zzb
            r1.zzb()
            goto L_0x0137
        L_0x011c:
            r5 = 4
            com.google.android.gms.internal.ads.zzahr r1 = r0.zzc
            boolean r2 = r1.zze()
            if (r2 == 0) goto L_0x0137
            byte[] r2 = r1.zza
            int r1 = r1.zzb
            com.google.android.gms.internal.ads.zzaad r1 = com.google.android.gms.internal.ads.zzaaf.zzc(r2, r5, r1)
            com.google.android.gms.internal.ads.zzahk r2 = r0.zzi
            r2.zza(r1)
            com.google.android.gms.internal.ads.zzahr r1 = r0.zzc
            r1.zzb()
        L_0x0137:
            com.google.android.gms.internal.ads.zzahr r1 = r0.zzd
            boolean r1 = r1.zzd(r4)
            if (r1 == 0) goto L_0x015f
            com.google.android.gms.internal.ads.zzahr r1 = r0.zzd
            byte[] r2 = r1.zza
            int r1 = r1.zzb
            int r1 = com.google.android.gms.internal.ads.zzaaf.zzb(r2, r1)
            com.google.android.gms.internal.ads.zzef r2 = r0.zzm
            com.google.android.gms.internal.ads.zzahr r4 = r0.zzd
            byte[] r4 = r4.zza
            r2.zzD(r4, r1)
            com.google.android.gms.internal.ads.zzef r1 = r0.zzm
            r2 = 4
            r1.zzF(r2)
            com.google.android.gms.internal.ads.zzaid r1 = r0.zza
            com.google.android.gms.internal.ads.zzef r2 = r0.zzm
            r1.zza(r6, r2)
        L_0x015f:
            com.google.android.gms.internal.ads.zzahk r11 = r0.zzi
            boolean r15 = r0.zzj
            boolean r1 = r0.zzl
            r12 = r8
            r16 = r1
            boolean r1 = r11.zze(r12, r14, r15, r16)
            if (r1 == 0) goto L_0x0171
            r1 = 0
            r0.zzl = r1
        L_0x0171:
            long r11 = r0.zzk
            boolean r1 = r0.zzj
            if (r1 != 0) goto L_0x0181
            com.google.android.gms.internal.ads.zzahr r1 = r0.zzb
            r1.zzc(r10)
            com.google.android.gms.internal.ads.zzahr r1 = r0.zzc
            r1.zzc(r10)
        L_0x0181:
            com.google.android.gms.internal.ads.zzahr r1 = r0.zzd
            r1.zzc(r10)
            com.google.android.gms.internal.ads.zzahk r7 = r0.zzi
            r7.zzd(r8, r10, r11)
            r1 = r17
            r2 = r18
            goto L_0x002a
        L_0x0191:
            r0.zzf(r3, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahl.zza(com.google.android.gms.internal.ads.zzef):void");
    }

    public final void zzb(zzzl zzzl, zzaio zzaio) {
        zzaio.zzc();
        this.zzg = zzaio.zzb();
        this.zzh = zzzl.zzv(zzaio.zza(), 2);
        this.zzi = new zzahk(this.zzh, false, false);
        this.zza.zzb(zzzl, zzaio);
    }

    public final void zzc() {
    }

    public final void zzd(long j, int i) {
        if (j != C.TIME_UNSET) {
            this.zzk = j;
        }
        this.zzl |= (i & 2) != 0;
    }

    public final void zze() {
        this.zze = 0;
        this.zzl = false;
        this.zzk = C.TIME_UNSET;
        zzaaf.zze(this.zzf);
        this.zzb.zzb();
        this.zzc.zzb();
        this.zzd.zzb();
        zzahk zzahk = this.zzi;
        if (zzahk != null) {
            zzahk.zzc();
        }
    }
}
