package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import androidx.work.WorkRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaxy implements zzayc, zzava, zzazw, zzaym {
    private long zzA;
    private long zzB;
    private long zzC;
    private int zzD;
    private boolean zzE;
    /* access modifiers changed from: private */
    public boolean zzF;
    private final zzazp zzG;
    private final Uri zza;
    private final zzazm zzb;
    private final int zzc;
    private final Handler zzd;
    /* access modifiers changed from: private */
    public final zzaxz zze;
    private final zzayd zzf;
    /* access modifiers changed from: private */
    public final long zzg;
    private final zzbaa zzh = new zzbaa("Loader:ExtractorMediaPeriod");
    private final zzaxw zzi;
    private final zzbae zzj;
    private final Runnable zzk;
    /* access modifiers changed from: private */
    public final Runnable zzl;
    /* access modifiers changed from: private */
    public final Handler zzm;
    /* access modifiers changed from: private */
    public final SparseArray zzn;
    /* access modifiers changed from: private */
    public zzayb zzo;
    private zzavg zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private int zzu;
    private zzayt zzv;
    private long zzw;
    private boolean[] zzx;
    private boolean[] zzy;
    private boolean zzz;

    public zzaxy(Uri uri, zzazm zzazm, zzauz[] zzauzArr, int i, Handler handler, zzaxz zzaxz, zzayd zzayd, zzazp zzazp, String str, int i2, byte[] bArr) {
        this.zza = uri;
        this.zzb = zzazm;
        this.zzc = i;
        this.zzd = handler;
        this.zze = zzaxz;
        this.zzf = zzayd;
        this.zzG = zzazp;
        this.zzg = (long) i2;
        this.zzi = new zzaxw(zzauzArr, this);
        this.zzj = new zzbae();
        this.zzk = new zzaxr(this);
        this.zzl = new zzaxs(this);
        this.zzm = new Handler();
        this.zzC = C.TIME_UNSET;
        this.zzn = new SparseArray();
        this.zzA = -1;
    }

    private final int zzC() {
        int size = this.zzn.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += ((zzayn) this.zzn.valueAt(i2)).zze();
        }
        return i;
    }

    private final long zzD() {
        int size = this.zzn.size();
        long j = Long.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            j = Math.max(j, ((zzayn) this.zzn.valueAt(i)).zzg());
        }
        return j;
    }

    private final void zzE(zzaxv zzaxv) {
        if (this.zzA == -1) {
            this.zzA = zzaxv.zzj;
        }
    }

    private final void zzF() {
        zzavg zzavg;
        zzaxv zzaxv = new zzaxv(this, this.zza, this.zzb, this.zzi, this.zzj);
        if (this.zzr) {
            zzbac.zze(zzG());
            long j = this.zzw;
            if (j == C.TIME_UNSET || this.zzC < j) {
                zzaxv.zzd(this.zzp.zzb(this.zzC), this.zzC);
                this.zzC = C.TIME_UNSET;
            } else {
                this.zzE = true;
                this.zzC = C.TIME_UNSET;
                return;
            }
        }
        this.zzD = zzC();
        int i = this.zzc;
        int i2 = 3;
        if (i != -1) {
            i2 = i;
        } else if (this.zzr && this.zzA == -1 && ((zzavg = this.zzp) == null || zzavg.zza() == C.TIME_UNSET)) {
            i2 = 6;
        }
        this.zzh.zza(zzaxv, this, i2);
    }

    private final boolean zzG() {
        return this.zzC != C.TIME_UNSET;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, boolean], vars: [r4v0 ?, r4v3 ?, r4v5 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    static /* bridge */ /* synthetic */ void zzp(com.google.android.gms.internal.ads.zzaxy r8) {
        /*
            boolean r0 = r8.zzF
            if (r0 != 0) goto L_0x009c
            boolean r0 = r8.zzr
            if (r0 != 0) goto L_0x009c
            com.google.android.gms.internal.ads.zzavg r0 = r8.zzp
            if (r0 == 0) goto L_0x009c
            boolean r0 = r8.zzq
            if (r0 != 0) goto L_0x0012
            goto L_0x009c
        L_0x0012:
            android.util.SparseArray r0 = r8.zzn
            int r0 = r0.size()
            r1 = 0
            r2 = r1
        L_0x001a:
            if (r2 >= r0) goto L_0x002d
            android.util.SparseArray r3 = r8.zzn
            java.lang.Object r3 = r3.valueAt(r2)
            com.google.android.gms.internal.ads.zzayn r3 = (com.google.android.gms.internal.ads.zzayn) r3
            com.google.android.gms.internal.ads.zzasw r3 = r3.zzh()
            if (r3 == 0) goto L_0x009c
            int r2 = r2 + 1
            goto L_0x001a
        L_0x002d:
            com.google.android.gms.internal.ads.zzbae r2 = r8.zzj
            r2.zzb()
            com.google.android.gms.internal.ads.zzays[] r2 = new com.google.android.gms.internal.ads.zzays[r0]
            boolean[] r3 = new boolean[r0]
            r8.zzy = r3
            boolean[] r3 = new boolean[r0]
            r8.zzx = r3
            com.google.android.gms.internal.ads.zzavg r3 = r8.zzp
            long r3 = r3.zza()
            r8.zzw = r3
            r3 = r1
        L_0x0045:
            r4 = 1
            if (r3 >= r0) goto L_0x007b
            android.util.SparseArray r5 = r8.zzn
            java.lang.Object r5 = r5.valueAt(r3)
            com.google.android.gms.internal.ads.zzayn r5 = (com.google.android.gms.internal.ads.zzayn) r5
            com.google.android.gms.internal.ads.zzasw r5 = r5.zzh()
            com.google.android.gms.internal.ads.zzays r6 = new com.google.android.gms.internal.ads.zzays
            com.google.android.gms.internal.ads.zzasw[] r7 = new com.google.android.gms.internal.ads.zzasw[r4]
            r7[r1] = r5
            r6.<init>(r7)
            r2[r3] = r6
            java.lang.String r5 = r5.zzf
            boolean r6 = com.google.android.gms.internal.ads.zzbah.zzb(r5)
            if (r6 != 0) goto L_0x006f
            boolean r5 = com.google.android.gms.internal.ads.zzbah.zza(r5)
            if (r5 == 0) goto L_0x006e
            goto L_0x006f
        L_0x006e:
            r4 = r1
        L_0x006f:
            boolean[] r5 = r8.zzy
            r5[r3] = r4
            boolean r5 = r8.zzz
            r4 = r4 | r5
            r8.zzz = r4
            int r3 = r3 + 1
            goto L_0x0045
        L_0x007b:
            com.google.android.gms.internal.ads.zzayt r0 = new com.google.android.gms.internal.ads.zzayt
            r0.<init>(r2)
            r8.zzv = r0
            r8.zzr = r4
            com.google.android.gms.internal.ads.zzayd r0 = r8.zzf
            com.google.android.gms.internal.ads.zzayr r1 = new com.google.android.gms.internal.ads.zzayr
            long r2 = r8.zzw
            com.google.android.gms.internal.ads.zzavg r4 = r8.zzp
            boolean r4 = r4.zzc()
            r1.<init>(r2, r4)
            r2 = 0
            r0.zzg(r1, r2)
            com.google.android.gms.internal.ads.zzayb r0 = r8.zzo
            r0.zzf(r8)
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaxy.zzp(com.google.android.gms.internal.ads.zzaxy):void");
    }

    /* access modifiers changed from: package-private */
    public final boolean zzA(int i) {
        if (this.zzE) {
            return true;
        }
        if (!zzG()) {
            return ((zzayn) this.zzn.valueAt(i)).zzm();
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00bc, code lost:
        if (r1 != false) goto L_0x00c5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzB(com.google.android.gms.internal.ads.zzayx[] r7, boolean[] r8, com.google.android.gms.internal.ads.zzayo[] r9, boolean[] r10, long r11) {
        /*
            r6 = this;
            boolean r0 = r6.zzr
            com.google.android.gms.internal.ads.zzbac.zze(r0)
            r0 = 0
            r1 = r0
        L_0x0007:
            int r2 = r7.length
            if (r1 >= r2) goto L_0x003e
            r2 = r9[r1]
            if (r2 == 0) goto L_0x003b
            r3 = r7[r1]
            if (r3 == 0) goto L_0x0016
            boolean r3 = r8[r1]
            if (r3 != 0) goto L_0x003b
        L_0x0016:
            com.google.android.gms.internal.ads.zzaxx r2 = (com.google.android.gms.internal.ads.zzaxx) r2
            int r2 = r2.zzb
            boolean[] r3 = r6.zzx
            boolean r3 = r3[r2]
            com.google.android.gms.internal.ads.zzbac.zze(r3)
            int r3 = r6.zzu
            int r3 = r3 + -1
            r6.zzu = r3
            boolean[] r3 = r6.zzx
            r3[r2] = r0
            android.util.SparseArray r3 = r6.zzn
            java.lang.Object r2 = r3.valueAt(r2)
            com.google.android.gms.internal.ads.zzayn r2 = (com.google.android.gms.internal.ads.zzayn) r2
            r2.zzi()
            r2 = 0
            r9[r1] = r2
        L_0x003b:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x003e:
            r8 = r0
            r1 = r8
        L_0x0040:
            int r2 = r7.length
            r3 = 1
            if (r8 >= r2) goto L_0x0083
            r2 = r9[r8]
            if (r2 != 0) goto L_0x0080
            r2 = r7[r8]
            if (r2 == 0) goto L_0x0080
            r2.zzb()
            int r1 = r2.zza(r0)
            if (r1 != 0) goto L_0x0057
            r1 = r3
            goto L_0x0058
        L_0x0057:
            r1 = r0
        L_0x0058:
            com.google.android.gms.internal.ads.zzbac.zze(r1)
            com.google.android.gms.internal.ads.zzayt r1 = r6.zzv
            com.google.android.gms.internal.ads.zzays r2 = r2.zzd()
            int r1 = r1.zza(r2)
            boolean[] r2 = r6.zzx
            boolean r2 = r2[r1]
            r2 = r2 ^ r3
            com.google.android.gms.internal.ads.zzbac.zze(r2)
            int r2 = r6.zzu
            int r2 = r2 + r3
            r6.zzu = r2
            boolean[] r2 = r6.zzx
            r2[r1] = r3
            com.google.android.gms.internal.ads.zzaxx r2 = new com.google.android.gms.internal.ads.zzaxx
            r2.<init>(r6, r1)
            r9[r8] = r2
            r10[r8] = r3
            r1 = r3
        L_0x0080:
            int r8 = r8 + 1
            goto L_0x0040
        L_0x0083:
            boolean r7 = r6.zzs
            if (r7 != 0) goto L_0x00a4
            android.util.SparseArray r7 = r6.zzn
            int r7 = r7.size()
            r8 = r0
        L_0x008e:
            if (r8 >= r7) goto L_0x00a4
            boolean[] r2 = r6.zzx
            boolean r2 = r2[r8]
            if (r2 != 0) goto L_0x00a1
            android.util.SparseArray r2 = r6.zzn
            java.lang.Object r2 = r2.valueAt(r8)
            com.google.android.gms.internal.ads.zzayn r2 = (com.google.android.gms.internal.ads.zzayn) r2
            r2.zzi()
        L_0x00a1:
            int r8 = r8 + 1
            goto L_0x008e
        L_0x00a4:
            int r7 = r6.zzu
            r4 = 0
            if (r7 != 0) goto L_0x00b8
            r6.zzt = r0
            com.google.android.gms.internal.ads.zzbaa r7 = r6.zzh
            boolean r8 = r7.zzi()
            if (r8 == 0) goto L_0x00d5
            r7.zzf()
            goto L_0x00d5
        L_0x00b8:
            boolean r7 = r6.zzs
            if (r7 == 0) goto L_0x00bf
            if (r1 == 0) goto L_0x00d5
            goto L_0x00c5
        L_0x00bf:
            int r7 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r7 != 0) goto L_0x00c5
            r11 = r4
            goto L_0x00d5
        L_0x00c5:
            long r11 = r6.zzi(r11)
        L_0x00c9:
            int r7 = r9.length
            if (r0 >= r7) goto L_0x00d5
            r7 = r9[r0]
            if (r7 == 0) goto L_0x00d2
            r10[r0] = r3
        L_0x00d2:
            int r0 = r0 + 1
            goto L_0x00c9
        L_0x00d5:
            r6.zzs = r3
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaxy.zzB(com.google.android.gms.internal.ads.zzayx[], boolean[], com.google.android.gms.internal.ads.zzayo[], boolean[], long):long");
    }

    public final long zza() {
        if (this.zzu == 0) {
            return Long.MIN_VALUE;
        }
        return zzg();
    }

    public final void zzb() {
        this.zzq = true;
        this.zzm.post(this.zzk);
    }

    public final zzavi zzbi(int i, int i2) {
        zzayn zzayn = (zzayn) this.zzn.get(i);
        if (zzayn != null) {
            return zzayn;
        }
        zzayn zzayn2 = new zzayn(this.zzG, (byte[]) null);
        zzayn2.zzk(this);
        this.zzn.put(i, zzayn2);
        return zzayn2;
    }

    public final boolean zzbj(long j) {
        if (this.zzE) {
            return false;
        }
        if (this.zzr && this.zzu == 0) {
            return false;
        }
        boolean zzc2 = this.zzj.zzc();
        if (this.zzh.zzi()) {
            return zzc2;
        }
        zzF();
        return true;
    }

    public final void zzc(zzavg zzavg) {
        this.zzp = zzavg;
        this.zzm.post(this.zzk);
    }

    public final /* bridge */ /* synthetic */ int zzd(zzazy zzazy, long j, long j2, IOException iOException) {
        zzavg zzavg;
        zzaxv zzaxv = (zzaxv) zzazy;
        zzE(zzaxv);
        Handler handler = this.zzd;
        if (handler != null) {
            handler.post(new zzaxu(this, iOException));
        }
        if (iOException instanceof zzayu) {
            return 3;
        }
        int zzC2 = zzC();
        int i = this.zzD;
        if (this.zzA == -1 && ((zzavg = this.zzp) == null || zzavg.zza() == C.TIME_UNSET)) {
            this.zzB = 0;
            this.zzt = this.zzr;
            int size = this.zzn.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((zzayn) this.zzn.valueAt(i2)).zzj(!this.zzr || this.zzx[i2]);
            }
            zzaxv.zzd(0, 0);
        }
        this.zzD = zzC();
        if (zzC2 <= i) {
            return 0;
        }
        return 1;
    }

    /* access modifiers changed from: package-private */
    public final int zze(int i, zzasx zzasx, zzaur zzaur, boolean z) {
        if (this.zzt || zzG()) {
            return -3;
        }
        return ((zzayn) this.zzn.valueAt(i)).zzf(zzasx, zzaur, z, this.zzE, this.zzB);
    }

    public final long zzg() {
        long j;
        if (this.zzE) {
            return Long.MIN_VALUE;
        }
        if (zzG()) {
            return this.zzC;
        }
        if (this.zzz) {
            int size = this.zzn.size();
            j = Long.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                if (this.zzy[i]) {
                    j = Math.min(j, ((zzayn) this.zzn.valueAt(i)).zzg());
                }
            }
        } else {
            j = zzD();
        }
        return j == Long.MIN_VALUE ? this.zzB : j;
    }

    public final long zzh() {
        if (!this.zzt) {
            return C.TIME_UNSET;
        }
        this.zzt = false;
        return this.zzB;
    }

    public final long zzi(long j) {
        if (true != this.zzp.zzc()) {
            j = 0;
        }
        this.zzB = j;
        int size = this.zzn.size();
        boolean zzG2 = true ^ zzG();
        int i = 0;
        while (true) {
            if (zzG2) {
                if (i >= size) {
                    break;
                }
                if (this.zzx[i]) {
                    zzG2 = ((zzayn) this.zzn.valueAt(i)).zzn(j, false);
                }
                i++;
            } else {
                this.zzC = j;
                this.zzE = false;
                zzbaa zzbaa = this.zzh;
                if (zzbaa.zzi()) {
                    zzbaa.zzf();
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        ((zzayn) this.zzn.valueAt(i2)).zzj(this.zzx[i2]);
                    }
                }
            }
        }
        this.zzt = false;
        return j;
    }

    public final zzayt zzn() {
        return this.zzv;
    }

    public final void zzq(long j) {
    }

    /* access modifiers changed from: package-private */
    public final void zzr() throws IOException {
        this.zzh.zzg(Integer.MIN_VALUE);
    }

    public final void zzs() throws IOException {
        this.zzh.zzg(Integer.MIN_VALUE);
    }

    public final /* bridge */ /* synthetic */ void zzt(zzazy zzazy, long j, long j2, boolean z) {
        zzE((zzaxv) zzazy);
        if (!z && this.zzu > 0) {
            int size = this.zzn.size();
            for (int i = 0; i < size; i++) {
                ((zzayn) this.zzn.valueAt(i)).zzj(this.zzx[i]);
            }
            this.zzo.zze(this);
        }
    }

    public final /* bridge */ /* synthetic */ void zzu(zzazy zzazy, long j, long j2) {
        zzE((zzaxv) zzazy);
        this.zzE = true;
        if (this.zzw == C.TIME_UNSET) {
            long zzD2 = zzD();
            long j3 = zzD2 == Long.MIN_VALUE ? 0 : zzD2 + WorkRequest.MIN_BACKOFF_MILLIS;
            this.zzw = j3;
            this.zzf.zzg(new zzayr(j3, this.zzp.zzc()), (Object) null);
        }
        this.zzo.zze(this);
    }

    public final void zzv(zzasw zzasw) {
        this.zzm.post(this.zzk);
    }

    public final void zzw(zzayb zzayb, long j) {
        this.zzo = zzayb;
        this.zzj.zzc();
        zzF();
    }

    public final void zzx() {
        this.zzh.zzh(new zzaxt(this, this.zzi));
        this.zzm.removeCallbacksAndMessages((Object) null);
        this.zzF = true;
    }

    /* access modifiers changed from: package-private */
    public final void zzy(int i, long j) {
        zzayn zzayn = (zzayn) this.zzn.valueAt(i);
        if (!this.zzE || j <= zzayn.zzg()) {
            zzayn.zzn(j, true);
        } else {
            zzayn.zzl();
        }
    }
}
