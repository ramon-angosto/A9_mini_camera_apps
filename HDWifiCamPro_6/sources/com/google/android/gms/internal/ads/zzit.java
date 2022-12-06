package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzit extends zzm implements zzhl {
    public static final /* synthetic */ int zzd = 0;
    private final zzkm zzA;
    private final zzkn zzB;
    private final long zzC;
    private int zzD;
    private int zzE;
    private boolean zzF;
    private int zzG;
    private zzkd zzH;
    private zzcc zzI;
    private zzbm zzJ;
    private zzbm zzK;
    /* access modifiers changed from: private */
    public zzaf zzL;
    /* access modifiers changed from: private */
    public zzaf zzM;
    private AudioTrack zzN;
    /* access modifiers changed from: private */
    public Object zzO;
    private Surface zzP;
    private int zzQ;
    private int zzR;
    private int zzS;
    /* access modifiers changed from: private */
    public zzgs zzT;
    /* access modifiers changed from: private */
    public zzgs zzU;
    private int zzV;
    private zzk zzW;
    private float zzX;
    /* access modifiers changed from: private */
    public boolean zzY;
    private zzdc zzZ;
    private boolean zzaa;
    private boolean zzab;
    /* access modifiers changed from: private */
    public zzt zzac;
    /* access modifiers changed from: private */
    public zzda zzad;
    private zzbm zzae;
    private zzju zzaf;
    private int zzag;
    private long zzah;
    private final zzhw zzai;
    private zzuc zzaj;
    final zzwa zzb;
    final zzcc zzc;
    private final zzdg zze = new zzdg(zzde.zza);
    private final Context zzf;
    private final zzcg zzg;
    private final zzka[] zzh;
    private final zzvz zzi;
    private final zzdn zzj;
    private final zzjd zzk;
    /* access modifiers changed from: private */
    public final zzdt zzl;
    private final CopyOnWriteArraySet zzm;
    private final zzck zzn;
    private final List zzo;
    private final boolean zzp;
    private final zzsh zzq;
    /* access modifiers changed from: private */
    public final zzko zzr;
    private final Looper zzs;
    private final zzwh zzt;
    private final zzde zzu;
    private final zzip zzv;
    private final zzir zzw;
    private final zzgm zzx;
    private final zzgq zzy;
    /* access modifiers changed from: private */
    public final zzkl zzz;

    static {
        zzbh.zzb("media3.exoplayer");
    }

    /* JADX WARNING: type inference failed for: r2v6, types: [java.lang.Object, com.google.android.gms.internal.ads.zzko] */
    public zzit(zzhk zzhk, zzcg zzcg) {
        zznb zza;
        zzhk zzhk2 = zzhk;
        try {
            String hexString = Integer.toHexString(System.identityHashCode(this));
            String str = zzen.zze;
            zzdw.zzd("ExoPlayerImpl", "Init " + hexString + " [AndroidXMedia3/1.0.0-beta02] [" + str + "]");
            this.zzf = zzhk2.zza.getApplicationContext();
            this.zzr = zzhk2.zzh.apply(zzhk2.zzb);
            this.zzW = zzhk2.zzj;
            this.zzQ = zzhk2.zzk;
            this.zzY = false;
            this.zzC = zzhk2.zzo;
            this.zzv = new zzip(this, (zzio) null);
            this.zzw = new zzir((zziq) null);
            Handler handler = new Handler(zzhk2.zzi);
            zzcly zzcly = ((zzhe) zzhk2.zzc).zza;
            zzip zzip = this.zzv;
            this.zzh = zzcly.zza(handler, zzip, zzip, zzip, zzip);
            int length = this.zzh.length;
            this.zzi = (zzvz) zzhk2.zze.zza();
            this.zzq = zzhk.zza(((zzhf) zzhk2.zzd).zza);
            this.zzt = zzwl.zzg(((zzhi) zzhk2.zzg).zza);
            this.zzp = zzhk2.zzl;
            this.zzH = zzhk2.zzm;
            this.zzs = zzhk2.zzi;
            this.zzu = zzhk2.zzb;
            this.zzg = zzcg;
            this.zzl = new zzdt(this.zzs, this.zzu, new zzhv(this));
            this.zzm = new CopyOnWriteArraySet();
            this.zzo = new ArrayList();
            this.zzaj = new zzuc(0);
            int length2 = this.zzh.length;
            this.zzb = new zzwa(new zzkc[2], new zzvt[2], zzcy.zza, (Object) null);
            this.zzn = new zzck();
            zzca zzca = new zzca();
            zzca.zzc(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 22, 23, 24, 25, 26, 27, 28);
            this.zzi.zzl();
            zzca.zzd(29, true);
            this.zzc = zzca.zze();
            zzca zzca2 = new zzca();
            zzca2.zzb(this.zzc);
            zzca2.zza(4);
            zzca2.zza(10);
            this.zzI = zzca2.zze();
            this.zzj = this.zzu.zzb(this.zzs, (Handler.Callback) null);
            this.zzai = new zzhw(this);
            this.zzaf = zzju.zzg(this.zzb);
            this.zzr.zzS(this.zzg, this.zzs);
            if (zzen.zza < 31) {
                zza = new zznb();
            } else {
                zza = zzii.zza(this.zzf, this, zzhk2.zzp);
            }
            zznb zznb = zza;
            zzka[] zzkaArr = this.zzh;
            zzvz zzvz = this.zzi;
            zzwa zzwa = this.zzb;
            zzka[] zzkaArr2 = zzkaArr;
            zzvz zzvz2 = zzvz;
            zzwa zzwa2 = zzwa;
            this.zzk = new zzjd(zzkaArr2, zzvz2, zzwa2, (zzjh) zzhk2.zzf.zza(), this.zzt, 0, false, this.zzr, this.zzH, zzhk2.zzr, zzhk2.zzn, false, this.zzs, this.zzu, this.zzai, zznb, (byte[]) null);
            this.zzX = 1.0f;
            zzbm zzbm = zzbm.zza;
            this.zzJ = zzbm;
            this.zzK = zzbm;
            this.zzae = zzbm;
            this.zzag = -1;
            if (zzen.zza < 21) {
                AudioTrack audioTrack = this.zzN;
                if (!(audioTrack == null || audioTrack.getAudioSessionId() == 0)) {
                    this.zzN.release();
                    this.zzN = null;
                }
                if (this.zzN == null) {
                    this.zzN = new AudioTrack(3, PAGSdk.INIT_LOCAL_FAIL_CODE, 4, 2, 2, 0, 0);
                }
                this.zzV = this.zzN.getAudioSessionId();
            } else {
                this.zzV = zzen.zzi(this.zzf);
            }
            this.zzZ = new zzdc(zzfvn.zzo(), 0);
            this.zzaa = true;
            zzko zzko = this.zzr;
            zzdt zzdt = this.zzl;
            if (zzko != null) {
                zzdt.zzb(zzko);
                this.zzt.zze(new Handler(this.zzs), this.zzr);
                this.zzm.add(this.zzv);
                this.zzx = new zzgm(zzhk2.zza, handler, this.zzv);
                this.zzy = new zzgq(zzhk2.zza, handler, this.zzv);
                zzen.zzT((Object) null, (Object) null);
                this.zzz = new zzkl(zzhk2.zza, handler, this.zzv);
                zzkl zzkl = this.zzz;
                int i = this.zzW.zzc;
                zzkl.zzf(3);
                this.zzA = new zzkm(zzhk2.zza);
                this.zzB = new zzkn(zzhk2.zza);
                this.zzac = zzam(this.zzz);
                this.zzad = zzda.zza;
                this.zzi.zzi(this.zzW);
                zzaq(1, 10, Integer.valueOf(this.zzV));
                zzaq(2, 10, Integer.valueOf(this.zzV));
                zzaq(1, 3, this.zzW);
                zzaq(2, 4, Integer.valueOf(this.zzQ));
                zzaq(2, 5, 0);
                zzaq(1, 9, Boolean.valueOf(this.zzY));
                zzaq(2, 7, this.zzw);
                zzaq(6, 8, this.zzw);
                return;
            }
            throw null;
        } finally {
            this.zze.zze();
        }
    }

    static /* bridge */ /* synthetic */ void zzN(zzit zzit, SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        zzit.zzas(surface);
        zzit.zzP = surface;
    }

    private final int zzag() {
        if (this.zzaf.zza.zzo()) {
            return this.zzag;
        }
        zzju zzju = this.zzaf;
        return zzju.zza.zzn(zzju.zzb.zza, this.zzn).zzd;
    }

    /* access modifiers changed from: private */
    public static int zzah(boolean z, int i) {
        return (!z || i == 1) ? 1 : 2;
    }

    private final long zzai(zzju zzju) {
        if (zzju.zza.zzo()) {
            return zzen.zzv(this.zzah);
        }
        if (zzju.zzb.zzb()) {
            return zzju.zzr;
        }
        zzcn zzcn = zzju.zza;
        zzsi zzsi = zzju.zzb;
        long j = zzju.zzr;
        zzak(zzcn, zzsi, j);
        return j;
    }

    private static long zzaj(zzju zzju) {
        zzcm zzcm = new zzcm();
        zzck zzck = new zzck();
        zzju.zza.zzn(zzju.zzb.zza, zzck);
        long j = zzju.zzc;
        if (j != C.TIME_UNSET) {
            return j;
        }
        long j2 = zzju.zza.zze(zzck.zzd, zzcm, 0).zzm;
        return 0;
    }

    private final long zzak(zzcn zzcn, zzsi zzsi, long j) {
        zzcn.zzn(zzsi.zza, this.zzn);
        return j;
    }

    private final Pair zzal(zzcn zzcn, int i, long j) {
        if (zzcn.zzo()) {
            this.zzag = i;
            if (j == C.TIME_UNSET) {
                j = 0;
            }
            this.zzah = j;
            return null;
        }
        if (i == -1 || i >= zzcn.zzc()) {
            i = zzcn.zzg(false);
            long j2 = zzcn.zze(i, this.zza, 0).zzm;
            j = zzen.zzz(0);
        }
        return zzcn.zzl(this.zza, this.zzn, i, zzen.zzv(j));
    }

    /* access modifiers changed from: private */
    public static zzt zzam(zzkl zzkl) {
        return new zzt(0, zzkl.zzb(), zzkl.zza());
    }

    private final zzju zzan(zzju zzju, zzcn zzcn, Pair pair) {
        zzuh zzuh;
        zzwa zzwa;
        zzsi zzsi;
        List list;
        int i;
        zzju zzju2;
        long j;
        zzcn zzcn2 = zzcn;
        Pair pair2 = pair;
        zzdd.zzd(zzcn.zzo() || pair2 != null);
        zzcn zzcn3 = zzju.zza;
        zzju zzf2 = zzju.zzf(zzcn);
        if (zzcn.zzo()) {
            zzsi zzh2 = zzju.zzh();
            long zzv2 = zzen.zzv(this.zzah);
            zzju zza = zzf2.zzb(zzh2, zzv2, zzv2, zzv2, 0, zzuh.zza, this.zzb, zzfvn.zzo()).zza(zzh2);
            zza.zzp = zza.zzr;
            return zza;
        }
        Object obj = zzf2.zzb.zza;
        int i2 = zzen.zza;
        boolean z = !obj.equals(pair2.first);
        zzsi zzsi2 = z ? new zzsi(pair2.first) : zzf2.zzb;
        long longValue = ((Long) pair2.second).longValue();
        long zzv3 = zzen.zzv(zzk());
        if (!zzcn3.zzo()) {
            zzcn3.zzn(obj, this.zzn);
        }
        if (z || longValue < zzv3) {
            zzsi zzsi3 = zzsi2;
            zzdd.zzf(!zzsi3.zzb());
            if (z) {
                zzuh = zzuh.zza;
            } else {
                zzuh = zzf2.zzh;
            }
            zzuh zzuh2 = zzuh;
            if (z) {
                zzsi = zzsi3;
                zzwa = this.zzb;
            } else {
                zzsi = zzsi3;
                zzwa = zzf2.zzi;
            }
            zzwa zzwa2 = zzwa;
            if (z) {
                list = zzfvn.zzo();
            } else {
                list = zzf2.zzj;
            }
            zzju zza2 = zzf2.zzb(zzsi, longValue, longValue, longValue, 0, zzuh2, zzwa2, list).zza(zzsi);
            zza2.zzp = longValue;
            return zza2;
        }
        if (i == 0) {
            int zza3 = zzcn2.zza(zzf2.zzk.zza);
            if (zza3 != -1 && zzcn2.zzd(zza3, this.zzn, false).zzd == zzcn2.zzn(zzsi2.zza, this.zzn).zzd) {
                return zzf2;
            }
            zzcn2.zzn(zzsi2.zza, this.zzn);
            if (zzsi2.zzb()) {
                j = this.zzn.zzg(zzsi2.zzb, zzsi2.zzc);
            } else {
                j = this.zzn.zze;
            }
            zzju2 = zzf2.zzb(zzsi2, zzf2.zzr, zzf2.zzr, zzf2.zzd, j - zzf2.zzr, zzf2.zzh, zzf2.zzi, zzf2.zzj).zza(zzsi2);
            zzju2.zzp = j;
        } else {
            zzsi zzsi4 = zzsi2;
            zzdd.zzf(!zzsi4.zzb());
            long max = Math.max(0, zzf2.zzq - (longValue - zzv3));
            long j2 = zzf2.zzp;
            if (zzf2.zzk.equals(zzf2.zzb)) {
                j2 = longValue + max;
            }
            zzju2 = zzf2.zzb(zzsi4, longValue, longValue, longValue, max, zzf2.zzh, zzf2.zzi, zzf2.zzj);
            zzju2.zzp = j2;
        }
        return zzju2;
    }

    private final zzjx zzao(zzjw zzjw) {
        int zzag2 = zzag();
        zzjd zzjd = this.zzk;
        zzcn zzcn = this.zzaf.zza;
        if (zzag2 == -1) {
            zzag2 = 0;
        }
        return new zzjx(zzjd, zzjw, zzcn, zzag2, this.zzu, zzjd.zzb());
    }

    /* access modifiers changed from: private */
    public final void zzap(int i, int i2) {
        if (i != this.zzR || i2 != this.zzS) {
            this.zzR = i;
            this.zzS = i2;
            zzdt zzdt = this.zzl;
            zzdt.zzd(24, new zzhz(i, i2));
            zzdt.zzc();
        }
    }

    private final void zzaq(int i, int i2, Object obj) {
        zzka[] zzkaArr = this.zzh;
        int length = zzkaArr.length;
        for (int i3 = 0; i3 < 2; i3++) {
            zzka zzka = zzkaArr[i3];
            if (zzka.zzb() == i) {
                zzjx zzao = zzao(zzka);
                zzao.zzf(i2);
                zzao.zze(obj);
                zzao.zzd();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzar() {
        zzaq(1, 2, Float.valueOf(this.zzX * this.zzy.zza()));
    }

    /* access modifiers changed from: private */
    public final void zzas(Object obj) {
        boolean z;
        ArrayList<zzjx> arrayList = new ArrayList<>();
        zzka[] zzkaArr = this.zzh;
        int length = zzkaArr.length;
        int i = 0;
        while (true) {
            z = true;
            if (i >= 2) {
                break;
            }
            zzka zzka = zzkaArr[i];
            if (zzka.zzb() == 2) {
                zzjx zzao = zzao(zzka);
                zzao.zzf(1);
                zzao.zze(obj);
                zzao.zzd();
                arrayList.add(zzao);
            }
            i++;
        }
        Object obj2 = this.zzO;
        if (obj2 == null || obj2 == obj) {
            z = false;
        } else {
            try {
                for (zzjx zzi2 : arrayList) {
                    zzi2.zzi(this.zzC);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
            }
            z = false;
            Object obj3 = this.zzO;
            Surface surface = this.zzP;
            if (obj3 == surface) {
                surface.release();
                this.zzP = null;
            }
        }
        this.zzO = obj;
        if (z) {
            zzat(false, zzha.zzd(new zzjf(3), 1003));
        }
    }

    private final void zzat(boolean z, zzha zzha) {
        zzju zzju = this.zzaf;
        zzju zza = zzju.zza(zzju.zzb);
        zza.zzp = zza.zzr;
        zza.zzq = 0;
        zzju zze2 = zza.zze(1);
        if (zzha != null) {
            zze2 = zze2.zzd(zzha);
        }
        zzju zzju2 = zze2;
        this.zzD++;
        this.zzk.zzo();
        zzav(zzju2, 0, 1, false, zzju2.zza.zzo() && !this.zzaf.zza.zzo(), 4, zzai(zzju2), -1);
    }

    /* access modifiers changed from: private */
    public final void zzau(boolean z, int i, int i2) {
        int i3 = 0;
        boolean z2 = z && i != -1;
        if (z2 && i != 1) {
            i3 = 1;
        }
        zzju zzju = this.zzaf;
        if (zzju.zzl != z2 || zzju.zzm != i3) {
            this.zzD++;
            zzju zzc2 = zzju.zzc(z2, i3);
            this.zzk.zzn(z2, i3);
            zzav(zzc2, 0, i2, false, false, 5, C.TIME_UNSET, -1);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:78:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0283  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x02a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzav(com.google.android.gms.internal.ads.zzju r44, int r45, int r46, boolean r47, boolean r48, int r49, long r50, int r52) {
        /*
            r43 = this;
            r0 = r43
            r1 = r44
            r2 = r49
            com.google.android.gms.internal.ads.zzju r3 = r0.zzaf
            r0.zzaf = r1
            com.google.android.gms.internal.ads.zzcn r4 = r3.zza
            com.google.android.gms.internal.ads.zzcn r5 = r1.zza
            boolean r4 = r4.equals(r5)
            r5 = 1
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r5)
            r4 = r4 ^ r5
            com.google.android.gms.internal.ads.zzcn r7 = r3.zza
            com.google.android.gms.internal.ads.zzcn r8 = r1.zza
            boolean r9 = r8.zzo()
            r11 = 3
            r12 = 0
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r12)
            r14 = 0
            r10 = -1
            java.lang.Integer r12 = java.lang.Integer.valueOf(r10)
            if (r9 == 0) goto L_0x003c
            boolean r9 = r7.zzo()
            if (r9 == 0) goto L_0x003c
            android.util.Pair r4 = new android.util.Pair
            r4.<init>(r13, r12)
            goto L_0x00bf
        L_0x003c:
            boolean r9 = r8.zzo()
            boolean r10 = r7.zzo()
            if (r9 == r10) goto L_0x0051
            android.util.Pair r4 = new android.util.Pair
            java.lang.Integer r7 = java.lang.Integer.valueOf(r11)
            r4.<init>(r6, r7)
            goto L_0x00bf
        L_0x0051:
            com.google.android.gms.internal.ads.zzsi r9 = r3.zzb
            java.lang.Object r9 = r9.zza
            com.google.android.gms.internal.ads.zzck r10 = r0.zzn
            com.google.android.gms.internal.ads.zzck r9 = r7.zzn(r9, r10)
            int r9 = r9.zzd
            com.google.android.gms.internal.ads.zzcm r10 = r0.zza
            com.google.android.gms.internal.ads.zzcm r7 = r7.zze(r9, r10, r14)
            java.lang.Object r7 = r7.zzc
            com.google.android.gms.internal.ads.zzsi r9 = r1.zzb
            java.lang.Object r9 = r9.zza
            com.google.android.gms.internal.ads.zzck r10 = r0.zzn
            com.google.android.gms.internal.ads.zzck r9 = r8.zzn(r9, r10)
            int r9 = r9.zzd
            com.google.android.gms.internal.ads.zzcm r10 = r0.zza
            com.google.android.gms.internal.ads.zzcm r8 = r8.zze(r9, r10, r14)
            java.lang.Object r8 = r8.zzc
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x009f
            if (r48 == 0) goto L_0x0085
            if (r2 != 0) goto L_0x0085
            r4 = r5
            goto L_0x008e
        L_0x0085:
            if (r48 == 0) goto L_0x008b
            if (r2 != r5) goto L_0x008b
            r4 = 2
            goto L_0x008e
        L_0x008b:
            if (r4 == 0) goto L_0x0099
            r4 = r11
        L_0x008e:
            android.util.Pair r7 = new android.util.Pair
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r7.<init>(r6, r4)
            r4 = r7
            goto L_0x00bf
        L_0x0099:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x009f:
            if (r48 == 0) goto L_0x00ba
            if (r2 != 0) goto L_0x00ba
            com.google.android.gms.internal.ads.zzsi r4 = r3.zzb
            long r7 = r4.zzd
            com.google.android.gms.internal.ads.zzsi r4 = r1.zzb
            long r9 = r4.zzd
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r4 >= 0) goto L_0x00ba
            android.util.Pair r4 = new android.util.Pair
            r7 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
            r4.<init>(r6, r8)
            goto L_0x00bf
        L_0x00ba:
            android.util.Pair r4 = new android.util.Pair
            r4.<init>(r13, r12)
        L_0x00bf:
            java.lang.Object r6 = r4.first
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            java.lang.Object r4 = r4.second
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            com.google.android.gms.internal.ads.zzbm r7 = r0.zzJ
            if (r6 == 0) goto L_0x00fa
            com.google.android.gms.internal.ads.zzcn r9 = r1.zza
            boolean r9 = r9.zzo()
            if (r9 != 0) goto L_0x00f4
            com.google.android.gms.internal.ads.zzcn r9 = r1.zza
            com.google.android.gms.internal.ads.zzsi r10 = r1.zzb
            java.lang.Object r10 = r10.zza
            com.google.android.gms.internal.ads.zzck r12 = r0.zzn
            com.google.android.gms.internal.ads.zzck r9 = r9.zzn(r10, r12)
            int r9 = r9.zzd
            com.google.android.gms.internal.ads.zzcn r10 = r1.zza
            com.google.android.gms.internal.ads.zzcm r12 = r0.zza
            com.google.android.gms.internal.ads.zzcm r9 = r10.zze(r9, r12, r14)
            com.google.android.gms.internal.ads.zzbg r9 = r9.zzd
            goto L_0x00f5
        L_0x00f4:
            r9 = 0
        L_0x00f5:
            com.google.android.gms.internal.ads.zzbm r10 = com.google.android.gms.internal.ads.zzbm.zza
            r0.zzae = r10
            goto L_0x00fb
        L_0x00fa:
            r9 = 0
        L_0x00fb:
            if (r6 != 0) goto L_0x0107
            java.util.List r10 = r3.zzj
            java.util.List r12 = r1.zzj
            boolean r10 = r10.equals(r12)
            if (r10 != 0) goto L_0x015f
        L_0x0107:
            com.google.android.gms.internal.ads.zzbm r7 = r0.zzae
            com.google.android.gms.internal.ads.zzbk r7 = r7.zza()
            java.util.List r10 = r1.zzj
            r12 = 0
        L_0x0110:
            int r13 = r10.size()
            if (r12 >= r13) goto L_0x0131
            java.lang.Object r13 = r10.get(r12)
            com.google.android.gms.internal.ads.zzbq r13 = (com.google.android.gms.internal.ads.zzbq) r13
            r8 = 0
        L_0x011d:
            int r11 = r13.zza()
            if (r8 >= r11) goto L_0x012d
            com.google.android.gms.internal.ads.zzbp r11 = r13.zzb(r8)
            r11.zza(r7)
            int r8 = r8 + 1
            goto L_0x011d
        L_0x012d:
            int r12 = r12 + 1
            r11 = 3
            goto L_0x0110
        L_0x0131:
            com.google.android.gms.internal.ads.zzbm r7 = r7.zzv()
            r0.zzae = r7
            com.google.android.gms.internal.ads.zzcn r7 = r43.zzn()
            boolean r8 = r7.zzo()
            if (r8 == 0) goto L_0x0144
            com.google.android.gms.internal.ads.zzbm r7 = r0.zzae
            goto L_0x015f
        L_0x0144:
            int r8 = r43.zzf()
            com.google.android.gms.internal.ads.zzcm r10 = r0.zza
            com.google.android.gms.internal.ads.zzcm r7 = r7.zze(r8, r10, r14)
            com.google.android.gms.internal.ads.zzbg r7 = r7.zzd
            com.google.android.gms.internal.ads.zzbm r8 = r0.zzae
            com.google.android.gms.internal.ads.zzbk r8 = r8.zza()
            com.google.android.gms.internal.ads.zzbm r7 = r7.zzg
            r8.zzb(r7)
            com.google.android.gms.internal.ads.zzbm r7 = r8.zzv()
        L_0x015f:
            com.google.android.gms.internal.ads.zzbm r8 = r0.zzJ
            boolean r8 = r7.equals(r8)
            r8 = r8 ^ r5
            r0.zzJ = r7
            boolean r7 = r3.zzl
            boolean r10 = r1.zzl
            int r11 = r3.zze
            int r12 = r1.zze
            if (r11 != r12) goto L_0x0174
            if (r7 == r10) goto L_0x0177
        L_0x0174:
            r43.zzaw()
        L_0x0177:
            boolean r13 = r3.zzg
            boolean r5 = r1.zzg
            com.google.android.gms.internal.ads.zzcn r14 = r3.zza
            com.google.android.gms.internal.ads.zzcn r15 = r1.zza
            boolean r14 = r14.equals(r15)
            if (r14 != 0) goto L_0x0195
            com.google.android.gms.internal.ads.zzdt r14 = r0.zzl
            com.google.android.gms.internal.ads.zzib r15 = new com.google.android.gms.internal.ads.zzib
            r18 = r7
            r7 = r45
            r15.<init>(r1, r7)
            r7 = 0
            r14.zzd(r7, r15)
            goto L_0x0197
        L_0x0195:
            r18 = r7
        L_0x0197:
            if (r48 == 0) goto L_0x02ca
            com.google.android.gms.internal.ads.zzck r7 = new com.google.android.gms.internal.ads.zzck
            r7.<init>()
            com.google.android.gms.internal.ads.zzcn r14 = r3.zza
            boolean r14 = r14.zzo()
            if (r14 != 0) goto L_0x01dc
            com.google.android.gms.internal.ads.zzsi r14 = r3.zzb
            java.lang.Object r14 = r14.zza
            com.google.android.gms.internal.ads.zzcn r15 = r3.zza
            r15.zzn(r14, r7)
            int r15 = r7.zzd
            r16 = r10
            com.google.android.gms.internal.ads.zzcn r10 = r3.zza
            int r10 = r10.zza(r14)
            r45 = r10
            com.google.android.gms.internal.ads.zzcn r10 = r3.zza
            r48 = r14
            com.google.android.gms.internal.ads.zzcm r14 = r0.zza
            r19 = r11
            r20 = r12
            r11 = 0
            com.google.android.gms.internal.ads.zzcm r10 = r10.zze(r15, r14, r11)
            java.lang.Object r10 = r10.zzc
            com.google.android.gms.internal.ads.zzcm r11 = r0.zza
            com.google.android.gms.internal.ads.zzbg r11 = r11.zzd
            r26 = r45
            r25 = r48
            r22 = r10
            r24 = r11
            r23 = r15
            goto L_0x01ec
        L_0x01dc:
            r16 = r10
            r19 = r11
            r20 = r12
            r23 = r52
            r22 = 0
            r24 = 0
            r25 = 0
            r26 = -1
        L_0x01ec:
            if (r2 != 0) goto L_0x0216
            com.google.android.gms.internal.ads.zzsi r10 = r3.zzb
            boolean r10 = r10.zzb()
            if (r10 == 0) goto L_0x0205
            com.google.android.gms.internal.ads.zzsi r10 = r3.zzb
            int r11 = r10.zzb
            int r10 = r10.zzc
            long r10 = r7.zzg(r11, r10)
            long r14 = zzaj(r3)
            goto L_0x0228
        L_0x0205:
            com.google.android.gms.internal.ads.zzsi r10 = r3.zzb
            int r10 = r10.zze
            r11 = -1
            if (r10 == r11) goto L_0x0213
            com.google.android.gms.internal.ads.zzju r7 = r0.zzaf
            long r10 = zzaj(r7)
            goto L_0x0227
        L_0x0213:
            long r10 = r7.zze
            goto L_0x0227
        L_0x0216:
            com.google.android.gms.internal.ads.zzsi r7 = r3.zzb
            boolean r7 = r7.zzb()
            if (r7 == 0) goto L_0x0225
            long r10 = r3.zzr
            long r14 = zzaj(r3)
            goto L_0x0228
        L_0x0225:
            long r10 = r3.zzr
        L_0x0227:
            r14 = r10
        L_0x0228:
            com.google.android.gms.internal.ads.zzcf r7 = new com.google.android.gms.internal.ads.zzcf
            long r27 = com.google.android.gms.internal.ads.zzen.zzz(r10)
            com.google.android.gms.internal.ads.zzsi r10 = r3.zzb
            long r29 = com.google.android.gms.internal.ads.zzen.zzz(r14)
            int r11 = r10.zzb
            int r10 = r10.zzc
            r21 = r7
            r31 = r11
            r32 = r10
            r21.<init>(r22, r23, r24, r25, r26, r27, r29, r31, r32)
            int r10 = r43.zzf()
            com.google.android.gms.internal.ads.zzju r11 = r0.zzaf
            com.google.android.gms.internal.ads.zzcn r11 = r11.zza
            boolean r11 = r11.zzo()
            if (r11 != 0) goto L_0x0283
            com.google.android.gms.internal.ads.zzju r11 = r0.zzaf
            com.google.android.gms.internal.ads.zzsi r12 = r11.zzb
            java.lang.Object r12 = r12.zza
            com.google.android.gms.internal.ads.zzcn r11 = r11.zza
            com.google.android.gms.internal.ads.zzck r14 = r0.zzn
            r11.zzn(r12, r14)
            com.google.android.gms.internal.ads.zzju r11 = r0.zzaf
            com.google.android.gms.internal.ads.zzcn r11 = r11.zza
            int r11 = r11.zza(r12)
            com.google.android.gms.internal.ads.zzju r14 = r0.zzaf
            com.google.android.gms.internal.ads.zzcn r14 = r14.zza
            com.google.android.gms.internal.ads.zzcm r15 = r0.zza
            r45 = r11
            r17 = r12
            r11 = 0
            com.google.android.gms.internal.ads.zzcm r11 = r14.zze(r10, r15, r11)
            java.lang.Object r11 = r11.zzc
            com.google.android.gms.internal.ads.zzcm r12 = r0.zza
            com.google.android.gms.internal.ads.zzbg r12 = r12.zzd
            r36 = r45
            r32 = r11
            r34 = r12
            r35 = r17
            goto L_0x028b
        L_0x0283:
            r32 = 0
            r34 = 0
            r35 = 0
            r36 = -1
        L_0x028b:
            long r37 = com.google.android.gms.internal.ads.zzen.zzz(r50)
            com.google.android.gms.internal.ads.zzcf r11 = new com.google.android.gms.internal.ads.zzcf
            com.google.android.gms.internal.ads.zzju r12 = r0.zzaf
            com.google.android.gms.internal.ads.zzsi r12 = r12.zzb
            boolean r12 = r12.zzb()
            if (r12 == 0) goto L_0x02a8
            com.google.android.gms.internal.ads.zzju r12 = r0.zzaf
            long r14 = zzaj(r12)
            long r14 = com.google.android.gms.internal.ads.zzen.zzz(r14)
            r39 = r14
            goto L_0x02aa
        L_0x02a8:
            r39 = r37
        L_0x02aa:
            com.google.android.gms.internal.ads.zzju r12 = r0.zzaf
            com.google.android.gms.internal.ads.zzsi r12 = r12.zzb
            int r14 = r12.zzb
            int r12 = r12.zzc
            r31 = r11
            r33 = r10
            r41 = r14
            r42 = r12
            r31.<init>(r32, r33, r34, r35, r36, r37, r39, r41, r42)
            com.google.android.gms.internal.ads.zzdt r10 = r0.zzl
            com.google.android.gms.internal.ads.zzih r12 = new com.google.android.gms.internal.ads.zzih
            r12.<init>(r2, r7, r11)
            r2 = 11
            r10.zzd(r2, r12)
            goto L_0x02d0
        L_0x02ca:
            r16 = r10
            r19 = r11
            r20 = r12
        L_0x02d0:
            if (r6 == 0) goto L_0x02dd
            com.google.android.gms.internal.ads.zzdt r2 = r0.zzl
            com.google.android.gms.internal.ads.zzhm r6 = new com.google.android.gms.internal.ads.zzhm
            r6.<init>(r9, r4)
            r4 = 1
            r2.zzd(r4, r6)
        L_0x02dd:
            com.google.android.gms.internal.ads.zzha r2 = r3.zzf
            com.google.android.gms.internal.ads.zzha r4 = r1.zzf
            if (r2 == r4) goto L_0x02fd
            com.google.android.gms.internal.ads.zzdt r2 = r0.zzl
            com.google.android.gms.internal.ads.zzhn r4 = new com.google.android.gms.internal.ads.zzhn
            r4.<init>(r1)
            r6 = 10
            r2.zzd(r6, r4)
            com.google.android.gms.internal.ads.zzha r2 = r1.zzf
            if (r2 == 0) goto L_0x02fd
            com.google.android.gms.internal.ads.zzdt r2 = r0.zzl
            com.google.android.gms.internal.ads.zzho r4 = new com.google.android.gms.internal.ads.zzho
            r4.<init>(r1)
            r2.zzd(r6, r4)
        L_0x02fd:
            com.google.android.gms.internal.ads.zzwa r2 = r3.zzi
            com.google.android.gms.internal.ads.zzwa r4 = r1.zzi
            if (r2 == r4) goto L_0x0315
            com.google.android.gms.internal.ads.zzvz r2 = r0.zzi
            java.lang.Object r4 = r4.zze
            r2.zzo(r4)
            com.google.android.gms.internal.ads.zzdt r2 = r0.zzl
            com.google.android.gms.internal.ads.zzhp r4 = new com.google.android.gms.internal.ads.zzhp
            r4.<init>(r1)
            r6 = 2
            r2.zzd(r6, r4)
        L_0x0315:
            if (r8 == 0) goto L_0x0325
            com.google.android.gms.internal.ads.zzbm r2 = r0.zzJ
            com.google.android.gms.internal.ads.zzdt r4 = r0.zzl
            com.google.android.gms.internal.ads.zzhq r6 = new com.google.android.gms.internal.ads.zzhq
            r6.<init>(r2)
            r2 = 14
            r4.zzd(r2, r6)
        L_0x0325:
            if (r13 == r5) goto L_0x0332
            com.google.android.gms.internal.ads.zzdt r2 = r0.zzl
            com.google.android.gms.internal.ads.zzhr r4 = new com.google.android.gms.internal.ads.zzhr
            r4.<init>(r1)
            r5 = 3
            r2.zzd(r5, r4)
        L_0x0332:
            r2 = r19
            r4 = r20
            r6 = r16
            r5 = r18
            if (r2 != r4) goto L_0x033e
            if (r5 == r6) goto L_0x0349
        L_0x033e:
            com.google.android.gms.internal.ads.zzdt r7 = r0.zzl
            com.google.android.gms.internal.ads.zzhs r8 = new com.google.android.gms.internal.ads.zzhs
            r8.<init>(r1)
            r9 = -1
            r7.zzd(r9, r8)
        L_0x0349:
            if (r2 == r4) goto L_0x0356
            com.google.android.gms.internal.ads.zzdt r2 = r0.zzl
            com.google.android.gms.internal.ads.zzht r4 = new com.google.android.gms.internal.ads.zzht
            r4.<init>(r1)
            r7 = 4
            r2.zzd(r7, r4)
        L_0x0356:
            if (r5 == r6) goto L_0x0365
            com.google.android.gms.internal.ads.zzdt r2 = r0.zzl
            com.google.android.gms.internal.ads.zzic r4 = new com.google.android.gms.internal.ads.zzic
            r5 = r46
            r4.<init>(r1, r5)
            r5 = 5
            r2.zzd(r5, r4)
        L_0x0365:
            int r2 = r3.zzm
            int r4 = r1.zzm
            if (r2 == r4) goto L_0x0376
            com.google.android.gms.internal.ads.zzdt r2 = r0.zzl
            com.google.android.gms.internal.ads.zzid r4 = new com.google.android.gms.internal.ads.zzid
            r4.<init>(r1)
            r5 = 6
            r2.zzd(r5, r4)
        L_0x0376:
            boolean r2 = zzay(r3)
            boolean r4 = zzay(r44)
            if (r2 == r4) goto L_0x038b
            com.google.android.gms.internal.ads.zzdt r2 = r0.zzl
            com.google.android.gms.internal.ads.zzie r4 = new com.google.android.gms.internal.ads.zzie
            r4.<init>(r1)
            r5 = 7
            r2.zzd(r5, r4)
        L_0x038b:
            com.google.android.gms.internal.ads.zzby r2 = r3.zzn
            com.google.android.gms.internal.ads.zzby r4 = r1.zzn
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x03a1
            com.google.android.gms.internal.ads.zzdt r2 = r0.zzl
            com.google.android.gms.internal.ads.zzif r4 = new com.google.android.gms.internal.ads.zzif
            r4.<init>(r1)
            r5 = 12
            r2.zzd(r5, r4)
        L_0x03a1:
            if (r47 == 0) goto L_0x03ab
            com.google.android.gms.internal.ads.zzdt r2 = r0.zzl
            com.google.android.gms.internal.ads.zzig r4 = com.google.android.gms.internal.ads.zzig.zza
            r5 = -1
            r2.zzd(r5, r4)
        L_0x03ab:
            com.google.android.gms.internal.ads.zzcc r2 = r0.zzI
            com.google.android.gms.internal.ads.zzcg r4 = r0.zzg
            com.google.android.gms.internal.ads.zzcc r5 = r0.zzc
            com.google.android.gms.internal.ads.zzcc r4 = com.google.android.gms.internal.ads.zzen.zzG(r4, r5)
            r0.zzI = r4
            com.google.android.gms.internal.ads.zzcc r4 = r0.zzI
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L_0x03cb
            com.google.android.gms.internal.ads.zzdt r2 = r0.zzl
            com.google.android.gms.internal.ads.zzhu r4 = new com.google.android.gms.internal.ads.zzhu
            r4.<init>(r0)
            r5 = 13
            r2.zzd(r5, r4)
        L_0x03cb:
            com.google.android.gms.internal.ads.zzdt r2 = r0.zzl
            r2.zzc()
            boolean r2 = r3.zzo
            boolean r3 = r1.zzo
            if (r2 == r3) goto L_0x03ee
            java.util.concurrent.CopyOnWriteArraySet r2 = r0.zzm
            java.util.Iterator r2 = r2.iterator()
        L_0x03dc:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x03ee
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.ads.zzhb r3 = (com.google.android.gms.internal.ads.zzhb) r3
            boolean r4 = r1.zzo
            r3.zza(r4)
            goto L_0x03dc
        L_0x03ee:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzit.zzav(com.google.android.gms.internal.ads.zzju, int, int, boolean, boolean, int, long, int):void");
    }

    /* access modifiers changed from: private */
    public final void zzaw() {
        int zzh2 = zzh();
        if (zzh2 == 2 || zzh2 == 3) {
            zzax();
            boolean z = this.zzaf.zzo;
            zzq();
            zzq();
        }
    }

    private final void zzax() {
        IllegalStateException illegalStateException;
        this.zze.zzb();
        if (Thread.currentThread() != this.zzs.getThread()) {
            String zzI2 = zzen.zzI("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), this.zzs.getThread().getName());
            if (!this.zzaa) {
                if (this.zzab) {
                    illegalStateException = null;
                } else {
                    illegalStateException = new IllegalStateException();
                }
                zzdw.zzf("ExoPlayerImpl", zzI2, illegalStateException);
                this.zzab = true;
                return;
            }
            throw new IllegalStateException(zzI2);
        }
    }

    private static boolean zzay(zzju zzju) {
        return zzju.zze == 3 && zzju.zzl && zzju.zzm == 0;
    }

    public final zzha zzA() {
        zzax();
        return this.zzaf.zzf;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzS(zzjb zzjb) {
        long j;
        boolean z;
        long j2;
        int i = this.zzD - zzjb.zzb;
        this.zzD = i;
        boolean z2 = true;
        if (zzjb.zzc) {
            this.zzE = zzjb.zzd;
            this.zzF = true;
        }
        if (zzjb.zze) {
            this.zzG = zzjb.zzf;
        }
        if (i == 0) {
            zzcn zzcn = zzjb.zza.zza;
            if (!this.zzaf.zza.zzo() && zzcn.zzo()) {
                this.zzag = -1;
                this.zzah = 0;
            }
            if (!zzcn.zzo()) {
                List zzw2 = ((zzjy) zzcn).zzw();
                zzdd.zzf(zzw2.size() == this.zzo.size());
                for (int i2 = 0; i2 < zzw2.size(); i2++) {
                    ((zzis) this.zzo.get(i2)).zzb = (zzcn) zzw2.get(i2);
                }
            }
            if (this.zzF) {
                if (zzjb.zza.zzb.equals(this.zzaf.zzb) && zzjb.zza.zzd == this.zzaf.zzr) {
                    z2 = false;
                }
                if (z2) {
                    if (zzcn.zzo() || zzjb.zza.zzb.zzb()) {
                        j2 = zzjb.zza.zzd;
                    } else {
                        zzju zzju = zzjb.zza;
                        zzsi zzsi = zzju.zzb;
                        j2 = zzju.zzd;
                        zzak(zzcn, zzsi, j2);
                    }
                    z = z2;
                    j = j2;
                } else {
                    j = -9223372036854775807L;
                    z = z2;
                }
            } else {
                j = -9223372036854775807L;
                z = false;
            }
            this.zzF = false;
            zzav(zzjb.zza, 1, this.zzG, false, z, this.zzE, j, -1);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzT(zzjb zzjb) {
        this.zzj.zzg(new zzhx(this, zzjb));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzU(zzcd zzcd) {
        zzcd.zza(this.zzI);
    }

    public final void zzW() {
        zzax();
        boolean zzq2 = zzq();
        int i = 2;
        int zzb2 = this.zzy.zzb(zzq2, 2);
        zzau(zzq2, zzb2, zzah(zzq2, zzb2));
        zzju zzju = this.zzaf;
        if (zzju.zze == 1) {
            zzju zzd2 = zzju.zzd((zzha) null);
            if (true == zzd2.zza.zzo()) {
                i = 4;
            }
            zzju zze2 = zzd2.zze(i);
            this.zzD++;
            this.zzk.zzk();
            zzav(zze2, 1, 1, false, false, 5, C.TIME_UNSET, -1);
        }
    }

    public final void zzX() {
        AudioTrack audioTrack;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = zzen.zze;
        String zza = zzbh.zza();
        zzdw.zzd("ExoPlayerImpl", "Release " + hexString + " [AndroidXMedia3/1.0.0-beta02] [" + str + "] [" + zza + "]");
        zzax();
        if (zzen.zza < 21 && (audioTrack = this.zzN) != null) {
            audioTrack.release();
            this.zzN = null;
        }
        this.zzz.zze();
        this.zzy.zzd();
        if (!this.zzk.zzp()) {
            zzdt zzdt = this.zzl;
            zzdt.zzd(10, zzhy.zza);
            zzdt.zzc();
        }
        this.zzl.zze();
        this.zzj.zzd((Object) null);
        this.zzt.zzf(this.zzr);
        this.zzaf = this.zzaf.zze(1);
        zzju zzju = this.zzaf;
        this.zzaf = zzju.zza(zzju.zzb);
        zzju zzju2 = this.zzaf;
        zzju2.zzp = zzju2.zzr;
        this.zzaf.zzq = 0;
        this.zzr.zzQ();
        this.zzi.zzh();
        Surface surface = this.zzP;
        if (surface != null) {
            surface.release();
            this.zzP = null;
        }
        this.zzZ = new zzdc(zzfvn.zzo(), 0);
    }

    public final void zzY(zzkr zzkr) {
        this.zzr.zzR(zzkr);
    }

    public final void zzZ(zzsk zzsk) {
        zzax();
        List singletonList = Collections.singletonList(zzsk);
        zzax();
        zzax();
        zzag();
        zzl();
        this.zzD++;
        if (!this.zzo.isEmpty()) {
            int size = this.zzo.size();
            for (int i = size - 1; i >= 0; i--) {
                this.zzo.remove(i);
            }
            this.zzaj = this.zzaj.zzh(0, size);
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < singletonList.size(); i2++) {
            zzjr zzjr = new zzjr((zzsk) singletonList.get(i2), this.zzp);
            arrayList.add(zzjr);
            this.zzo.add(i2, new zzis(zzjr.zzb, zzjr.zza.zzA()));
        }
        this.zzaj = this.zzaj.zzg(0, arrayList.size());
        zzjy zzjy = new zzjy(this.zzo, this.zzaj, (byte[]) null);
        if (zzjy.zzo() || zzjy.zzc() >= 0) {
            int zzg2 = zzjy.zzg(false);
            zzju zzan = zzan(this.zzaf, zzjy, zzal(zzjy, zzg2, C.TIME_UNSET));
            int i3 = zzan.zze;
            if (!(zzg2 == -1 || i3 == 1)) {
                i3 = (zzjy.zzo() || zzg2 >= zzjy.zzc()) ? 4 : 2;
            }
            zzju zze2 = zzan.zze(i3);
            this.zzk.zzq(arrayList, zzg2, zzen.zzv(C.TIME_UNSET), this.zzaj);
            zzav(zze2, 0, 1, false, !this.zzaf.zzb.zza.equals(zze2.zzb.zza) && !this.zzaf.zza.zzo(), 4, zzai(zze2), -1);
            return;
        }
        throw new zzag(zzjy, -1, C.TIME_UNSET);
    }

    public final void zzaa(boolean z) {
        zzax();
        int zzb2 = this.zzy.zzb(z, zzh());
        zzau(z, zzb2, zzah(z, zzb2));
    }

    /* access modifiers changed from: package-private */
    public final void zzab(boolean z) {
        this.zzaa = false;
    }

    public final void zzac(Surface surface) {
        zzax();
        zzas(surface);
        int i = surface == null ? 0 : -1;
        zzap(i, i);
    }

    public final void zzad(float f) {
        zzax();
        float zza = zzen.zza(f, 0.0f, 1.0f);
        if (this.zzX != zza) {
            this.zzX = zza;
            zzar();
            zzdt zzdt = this.zzl;
            zzdt.zzd(22, new zzia(zza));
            zzdt.zzc();
        }
    }

    public final void zzae() {
        zzax();
        zzax();
        this.zzy.zzb(zzq(), 1);
        zzat(false, (zzha) null);
        this.zzZ = new zzdc(zzfvn.zzo(), this.zzaf.zzr);
    }

    public final int zzd() {
        zzax();
        if (zzs()) {
            return this.zzaf.zzb.zzb;
        }
        return -1;
    }

    public final int zze() {
        zzax();
        if (zzs()) {
            return this.zzaf.zzb.zzc;
        }
        return -1;
    }

    public final int zzf() {
        zzax();
        int zzag2 = zzag();
        if (zzag2 == -1) {
            return 0;
        }
        return zzag2;
    }

    public final int zzg() {
        zzax();
        if (this.zzaf.zza.zzo()) {
            return 0;
        }
        zzju zzju = this.zzaf;
        return zzju.zza.zza(zzju.zzb.zza);
    }

    public final int zzh() {
        zzax();
        return this.zzaf.zze;
    }

    public final int zzi() {
        zzax();
        return this.zzaf.zzm;
    }

    public final int zzj() {
        zzax();
        return 0;
    }

    public final long zzk() {
        zzax();
        if (!zzs()) {
            return zzl();
        }
        zzju zzju = this.zzaf;
        zzju.zza.zzn(zzju.zzb.zza, this.zzn);
        zzju zzju2 = this.zzaf;
        if (zzju2.zzc != C.TIME_UNSET) {
            return zzen.zzz(0) + zzen.zzz(this.zzaf.zzc);
        }
        long j = zzju2.zza.zze(zzf(), this.zza, 0).zzm;
        return zzen.zzz(0);
    }

    public final long zzl() {
        zzax();
        return zzen.zzz(zzai(this.zzaf));
    }

    public final long zzm() {
        zzax();
        return zzen.zzz(this.zzaf.zzq);
    }

    public final zzcn zzn() {
        zzax();
        return this.zzaf.zza;
    }

    public final zzcy zzo() {
        zzax();
        return this.zzaf.zzi.zzd;
    }

    public final void zzp(int i, long j) {
        int i2 = i;
        long j2 = j;
        zzax();
        this.zzr.zzx();
        zzcn zzcn = this.zzaf.zza;
        if (i2 < 0 || (!zzcn.zzo() && i2 >= zzcn.zzc())) {
            throw new zzag(zzcn, i, j2);
        }
        int i3 = 1;
        this.zzD++;
        if (zzs()) {
            zzdw.zze("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            zzjb zzjb = new zzjb(this.zzaf);
            zzjb.zza(1);
            this.zzai.zza.zzT(zzjb);
            return;
        }
        if (zzh() != 1) {
            i3 = 2;
        }
        int zzf2 = zzf();
        zzju zzan = zzan(this.zzaf.zze(i3), zzcn, zzal(zzcn, i, j2));
        this.zzk.zzl(zzcn, i, zzen.zzv(j));
        zzav(zzan, 0, 1, true, true, 1, zzai(zzan), zzf2);
    }

    public final boolean zzq() {
        zzax();
        return this.zzaf.zzl;
    }

    public final boolean zzr() {
        zzax();
        return false;
    }

    public final boolean zzs() {
        zzax();
        return this.zzaf.zzb.zzb();
    }

    public final int zzu() {
        zzax();
        int length = this.zzh.length;
        return 2;
    }

    public final long zzv() {
        zzax();
        if (zzs()) {
            zzju zzju = this.zzaf;
            if (zzju.zzk.equals(zzju.zzb)) {
                return zzen.zzz(this.zzaf.zzp);
            }
            return zzw();
        }
        zzax();
        if (this.zzaf.zza.zzo()) {
            return this.zzah;
        }
        zzju zzju2 = this.zzaf;
        if (zzju2.zzk.zzd != zzju2.zzb.zzd) {
            return zzen.zzz(zzju2.zza.zze(zzf(), this.zza, 0).zzn);
        }
        long j = zzju2.zzp;
        if (this.zzaf.zzk.zzb()) {
            zzju zzju3 = this.zzaf;
            zzju3.zza.zzn(zzju3.zzk.zza, this.zzn).zzh(this.zzaf.zzk.zzb);
            j = 0;
        }
        zzju zzju4 = this.zzaf;
        zzak(zzju4.zza, zzju4.zzk, j);
        return zzen.zzz(j);
    }

    public final long zzw() {
        zzax();
        if (!zzs()) {
            zzcn zzn2 = zzn();
            if (zzn2.zzo()) {
                return C.TIME_UNSET;
            }
            return zzen.zzz(zzn2.zze(zzf(), this.zza, 0).zzn);
        }
        zzju zzju = this.zzaf;
        zzsi zzsi = zzju.zzb;
        zzju.zza.zzn(zzsi.zza, this.zzn);
        return zzen.zzz(this.zzn.zzg(zzsi.zzb, zzsi.zzc));
    }

    public final void zzR(zzkr zzkr) {
        zzko zzko = this.zzr;
        if (zzkr != null) {
            zzko.zzw(zzkr);
            return;
        }
        throw null;
    }
}
