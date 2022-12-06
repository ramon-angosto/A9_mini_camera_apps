package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcmc extends zzcip implements zzfz, zzkr {
    public static final /* synthetic */ int zzc = 0;
    private final Context zzd;
    private final zzcln zze;
    private final zzvr zzf;
    private final zzcix zzg;
    private final WeakReference zzh;
    private final zzto zzi;
    private zzkf zzj;
    private ByteBuffer zzk;
    private boolean zzl;
    private zzcio zzm;
    private int zzn;
    private int zzo;
    private long zzp;
    private final String zzq;
    private final int zzr;
    private final Object zzs = new Object();
    private final ArrayList zzt;
    private volatile zzclp zzu;
    private final Set zzv = new HashSet();

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00fd, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzay.zzc().zzb(com.google.android.gms.internal.ads.zzbjc.zzbD)).booleanValue() == false) goto L_0x00ff;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzcmc(android.content.Context r5, com.google.android.gms.internal.ads.zzcix r6, com.google.android.gms.internal.ads.zzciy r7) {
        /*
            r4 = this;
            r4.<init>()
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r4.zzs = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r4.zzv = r0
            r4.zzd = r5
            r4.zzg = r6
            java.lang.ref.WeakReference r6 = new java.lang.ref.WeakReference
            r6.<init>(r7)
            r4.zzh = r6
            com.google.android.gms.internal.ads.zzcln r6 = new com.google.android.gms.internal.ads.zzcln
            r6.<init>()
            r4.zze = r6
            com.google.android.gms.internal.ads.zzvr r6 = new com.google.android.gms.internal.ads.zzvr
            android.content.Context r0 = r4.zzd
            r6.<init>(r0)
            r4.zzf = r6
            boolean r6 = com.google.android.gms.ads.internal.util.zze.zzc()
            if (r6 == 0) goto L_0x003f
            java.lang.String r6 = r4.toString()
            java.lang.String r0 = "OfficialSimpleExoPlayerAdapter initialize "
            java.lang.String r6 = r0.concat(r6)
            com.google.android.gms.ads.internal.util.zze.zza(r6)
        L_0x003f:
            java.util.concurrent.atomic.AtomicInteger r6 = zza
            r6.incrementAndGet()
            com.google.android.gms.internal.ads.zzke r6 = new com.google.android.gms.internal.ads.zzke
            android.content.Context r0 = r4.zzd
            com.google.android.gms.internal.ads.zzcly r1 = new com.google.android.gms.internal.ads.zzcly
            r1.<init>(r4)
            r2 = 0
            r6.<init>(r0, r1, r2)
            com.google.android.gms.internal.ads.zzvr r0 = r4.zzf
            r6.zzb(r0)
            com.google.android.gms.internal.ads.zzcln r0 = r4.zze
            r6.zza(r0)
            com.google.android.gms.internal.ads.zzkf r6 = r6.zzc()
            r4.zzj = r6
            com.google.android.gms.internal.ads.zzbiu r6 = com.google.android.gms.internal.ads.zzbjc.zzbK
            com.google.android.gms.internal.ads.zzbja r0 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r6 = r0.zzb(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L_0x0078
            com.google.android.gms.internal.ads.zzkf r6 = r4.zzj
            com.google.android.gms.internal.ads.zzje.zza(r6)
        L_0x0078:
            com.google.android.gms.internal.ads.zzkf r6 = r4.zzj
            r6.zzx(r4)
            r6 = 0
            r4.zzn = r6
            r0 = 0
            r4.zzp = r0
            r4.zzo = r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r4.zzt = r0
            r4.zzu = r2
            if (r7 == 0) goto L_0x009c
            java.lang.String r0 = r7.zzt()
            if (r0 == 0) goto L_0x009c
            java.lang.String r0 = r7.zzt()
            goto L_0x009e
        L_0x009c:
            java.lang.String r0 = ""
        L_0x009e:
            r4.zzq = r0
            if (r7 == 0) goto L_0x00a7
            int r0 = r7.zzh()
            goto L_0x00a8
        L_0x00a7:
            r0 = r6
        L_0x00a8:
            r4.zzr = r0
            com.google.android.gms.internal.ads.zzto r0 = new com.google.android.gms.internal.ads.zzto
            com.google.android.gms.ads.internal.util.zzs r1 = com.google.android.gms.ads.internal.zzt.zzp()
            com.google.android.gms.internal.ads.zzcgv r7 = r7.zzp()
            java.lang.String r7 = r7.zza
            java.lang.String r5 = r1.zzc(r5, r7)
            boolean r7 = r4.zzl
            if (r7 == 0) goto L_0x00da
            java.nio.ByteBuffer r7 = r4.zzk
            int r7 = r7.limit()
            if (r7 <= 0) goto L_0x00da
            java.nio.ByteBuffer r5 = r4.zzk
            int r5 = r5.limit()
            byte[] r5 = new byte[r5]
            java.nio.ByteBuffer r6 = r4.zzk
            r6.get(r5)
            com.google.android.gms.internal.ads.zzclr r6 = new com.google.android.gms.internal.ads.zzclr
            r6.<init>(r5)
            goto L_0x014b
        L_0x00da:
            com.google.android.gms.internal.ads.zzbiu r7 = com.google.android.gms.internal.ads.zzbjc.zzbM
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r7 = r1.zzb(r7)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            r1 = 1
            if (r7 == 0) goto L_0x00ff
            com.google.android.gms.internal.ads.zzbiu r7 = com.google.android.gms.internal.ads.zzbjc.zzbD
            com.google.android.gms.internal.ads.zzbja r3 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r7 = r3.zzb(r7)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L_0x0107
        L_0x00ff:
            com.google.android.gms.internal.ads.zzcix r7 = r4.zzg
            boolean r7 = r7.zzj
            if (r7 != 0) goto L_0x0106
            goto L_0x0107
        L_0x0106:
            r1 = r6
        L_0x0107:
            com.google.android.gms.internal.ads.zzcix r6 = r4.zzg
            boolean r7 = r6.zzo
            if (r7 == 0) goto L_0x0113
            com.google.android.gms.internal.ads.zzclt r6 = new com.google.android.gms.internal.ads.zzclt
            r6.<init>(r4, r5, r1)
            goto L_0x0122
        L_0x0113:
            int r6 = r6.zzi
            if (r6 <= 0) goto L_0x011d
            com.google.android.gms.internal.ads.zzclu r6 = new com.google.android.gms.internal.ads.zzclu
            r6.<init>(r4, r5, r1)
            goto L_0x0122
        L_0x011d:
            com.google.android.gms.internal.ads.zzclv r6 = new com.google.android.gms.internal.ads.zzclv
            r6.<init>(r4, r5, r1)
        L_0x0122:
            com.google.android.gms.internal.ads.zzcix r5 = r4.zzg
            boolean r5 = r5.zzj
            if (r5 == 0) goto L_0x012e
            com.google.android.gms.internal.ads.zzclw r5 = new com.google.android.gms.internal.ads.zzclw
            r5.<init>(r4, r6)
            r6 = r5
        L_0x012e:
            java.nio.ByteBuffer r5 = r4.zzk
            if (r5 == 0) goto L_0x014b
            int r5 = r5.limit()
            if (r5 <= 0) goto L_0x014b
            java.nio.ByteBuffer r5 = r4.zzk
            int r5 = r5.limit()
            byte[] r5 = new byte[r5]
            java.nio.ByteBuffer r7 = r4.zzk
            r7.get(r5)
            com.google.android.gms.internal.ads.zzclx r7 = new com.google.android.gms.internal.ads.zzclx
            r7.<init>(r6, r5)
            r6 = r7
        L_0x014b:
            com.google.android.gms.internal.ads.zzbiu r5 = com.google.android.gms.internal.ads.zzbjc.zzm
            com.google.android.gms.internal.ads.zzbja r7 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r5 = r7.zzb(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0160
            com.google.android.gms.internal.ads.zzcma r5 = com.google.android.gms.internal.ads.zzcma.zza
            goto L_0x0162
        L_0x0160:
            com.google.android.gms.internal.ads.zzcmb r5 = com.google.android.gms.internal.ads.zzcmb.zza
        L_0x0162:
            com.google.android.gms.internal.ads.zztn r7 = new com.google.android.gms.internal.ads.zztn
            r7.<init>(r5)
            r0.<init>(r6, r7, r2)
            r4.zzi = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcmc.<init>(android.content.Context, com.google.android.gms.internal.ads.zzcix, com.google.android.gms.internal.ads.zzciy):void");
    }

    private final boolean zzZ() {
        return this.zzu != null && this.zzu.zzq();
    }

    public final void finalize() {
        zza.decrementAndGet();
        if (zze.zzc()) {
            zze.zza("OfficialSimpleExoPlayerAdapter finalize ".concat(toString()));
        }
    }

    public final long zzA() {
        if (!zzZ()) {
            return (long) this.zzn;
        }
        return 0;
    }

    public final long zzB() {
        if (zzZ()) {
            return this.zzu.zzl();
        }
        synchronized (this.zzs) {
            while (!this.zzt.isEmpty()) {
                long j = this.zzp;
                Map zze2 = ((zzfu) this.zzt.remove(0)).zze();
                long j2 = 0;
                if (zze2 != null) {
                    Iterator it = zze2.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        if (entry != null) {
                            try {
                                if (!(entry.getKey() == null || !zzfse.zzc("content-length", (CharSequence) entry.getKey()) || entry.getValue() == null || ((List) entry.getValue()).get(0) == null)) {
                                    j2 = Long.parseLong((String) ((List) entry.getValue()).get(0));
                                    break;
                                }
                            } catch (NumberFormatException unused) {
                                continue;
                            }
                        }
                    }
                }
                this.zzp = j + j2;
            }
        }
        return this.zzp;
    }

    public final void zzC(Uri[] uriArr, String str) {
        zzD(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void zzE() {
        zzkf zzkf = this.zzj;
        if (zzkf != null) {
            zzkf.zzA(this);
            this.zzj.zzz();
            this.zzj = null;
            zzb.decrementAndGet();
        }
    }

    public final void zzF(long j) {
        zzkf zzkf = this.zzj;
        zzkf.zzp(zzkf.zzf(), j);
    }

    public final void zzG(int i) {
        this.zze.zzk(i);
    }

    public final void zzH(int i) {
        this.zze.zzl(i);
    }

    public final void zzI(zzcio zzcio) {
        this.zzm = zzcio;
    }

    public final void zzJ(int i) {
        this.zze.zzm(i);
    }

    public final void zzK(int i) {
        this.zze.zzn(i);
    }

    public final void zzL(boolean z) {
        this.zzj.zzC(z);
    }

    public final void zzM(boolean z) {
        if (this.zzj != null) {
            int i = 0;
            while (true) {
                this.zzj.zzt();
                if (i < 2) {
                    zzvr zzvr = this.zzf;
                    zzvd zzc2 = zzvr.zzc().zzc();
                    zzc2.zzo(i, !z);
                    zzvr.zzj(zzc2);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void zzN(int i) {
        for (WeakReference weakReference : this.zzv) {
            zzclm zzclm = (zzclm) weakReference.get();
            if (zzclm != null) {
                zzclm.zzm(i);
            }
        }
    }

    public final void zzO(Surface surface, boolean z) {
        zzkf zzkf = this.zzj;
        if (zzkf != null) {
            zzkf.zzE(surface);
        }
    }

    public final void zzP(float f, boolean z) {
        zzkf zzkf = this.zzj;
        if (zzkf != null) {
            zzkf.zzF(f);
        }
    }

    public final void zzQ() {
        this.zzj.zzG();
    }

    public final boolean zzR() {
        return this.zzj != null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzex zzS(String str, boolean z) {
        zzcmc zzcmc = true != z ? null : this;
        zzcix zzcix = this.zzg;
        return new zzcmf(str, zzcmc, zzcix.zzd, zzcix.zzf, zzcix.zzp, zzcix.zzq);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzex zzT(String str, boolean z) {
        zzcmc zzcmc = true != z ? null : this;
        zzcix zzcix = this.zzg;
        zzclm zzclm = new zzclm(str, zzcmc, zzcix.zzd, zzcix.zzf, zzcix.zzi);
        this.zzv.add(new WeakReference(zzclm));
        return zzclm;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzex zzU(String str, boolean z) {
        zzff zzff = new zzff();
        zzff.zzf(str);
        zzff.zze(true != z ? null : this);
        zzff.zzc(this.zzg.zzd);
        zzff.zzd(this.zzg.zzf);
        zzff.zzb(true);
        return zzff.zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzex zzV(zzew zzew) {
        return new zzclp(this.zzd, zzew.zza(), this.zzq, this.zzr, this, new zzcls(this), (byte[]) null);
    }

    /* access modifiers changed from: package-private */
    public final zzsk zzW(Uri uri) {
        zzaj zzaj = new zzaj();
        zzaj.zzb(uri);
        zzbg zzc2 = zzaj.zzc();
        zzto zzto = this.zzi;
        zzto.zza(this.zzg.zzg);
        return zzto.zzb(zzc2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzX(boolean z, long j) {
        zzcio zzcio = this.zzm;
        if (zzcio != null) {
            zzcio.zzi(z, j);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzka[] zzY(Handler handler, zzyd zzyd, zzns zzns, zzuj zzuj, zzri zzri) {
        Context context = this.zzd;
        zzqs zzqs = zzqs.zzb;
        zznd zznd = zznd.zza;
        zzng[] zzngArr = new zzng[0];
        zzoi zzoi = new zzoi();
        zznd zznd2 = zznd.zza;
        if (zznd == null) {
            if (zznd2 != null) {
                zznd = zznd2;
            } else {
                throw new NullPointerException("Both parameters are null");
            }
        }
        zzoi.zzb(zznd);
        zzoi.zzc(zzngArr);
        return new zzka[]{new zzpa(context, zzqk.zza, zzqs, false, handler, zzns, zzoi.zzd()), new zzxg(this.zzd, zzqk.zza, zzqs.zzb, 0, false, handler, zzyd, -1, 30.0f)};
    }

    public final void zza(zzex zzex, zzfc zzfc, boolean z, int i) {
        this.zzn += i;
    }

    public final void zzb(zzex zzex, zzfc zzfc, boolean z) {
    }

    public final void zzc(zzex zzex, zzfc zzfc, boolean z) {
    }

    public final void zzd(zzex zzex, zzfc zzfc, boolean z) {
        if (zzex instanceof zzfu) {
            synchronized (this.zzs) {
                this.zzt.add((zzfu) zzex);
            }
        } else if (zzex instanceof zzclp) {
            this.zzu = (zzclp) zzex;
            zzciy zzciy = (zzciy) this.zzh.get();
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzbD)).booleanValue() && zzciy != null && this.zzu.zzn()) {
                HashMap hashMap = new HashMap();
                hashMap.put("gcacheHit", String.valueOf(this.zzu.zzp()));
                hashMap.put("gcacheDownloaded", String.valueOf(this.zzu.zzo()));
                zzs.zza.post(new zzclz(zzciy, hashMap));
            }
        }
    }

    public final void zze(zzkp zzkp, zzaf zzaf, zzgt zzgt) {
        zzciy zzciy = (zzciy) this.zzh.get();
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzbD)).booleanValue() && zzciy != null && zzaf != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("audioMime", zzaf.zzl);
            hashMap.put("audioSampleMime", zzaf.zzm);
            hashMap.put("audioCodec", zzaf.zzj);
            zzciy.zzd("onMetadataEvent", hashMap);
        }
    }

    public final /* synthetic */ void zzf(zzkp zzkp, int i, long j, long j2) {
    }

    public final /* synthetic */ void zzg(zzkp zzkp, zzse zzse) {
    }

    public final void zzh(zzkp zzkp, int i, long j) {
        this.zzo += i;
    }

    public final /* synthetic */ void zzi(zzcg zzcg, zzkq zzkq) {
    }

    public final void zzj(zzkp zzkp, zzrz zzrz, zzse zzse, IOException iOException, boolean z) {
        zzcio zzcio = this.zzm;
        if (zzcio == null) {
            return;
        }
        if (this.zzg.zzl) {
            zzcio.zzl("onLoadException", iOException);
        } else {
            zzcio.zzk("onLoadError", iOException);
        }
    }

    public final void zzk(zzkp zzkp, int i) {
        zzcio zzcio = this.zzm;
        if (zzcio != null) {
            zzcio.zzm(i);
        }
    }

    public final void zzl(zzkp zzkp, zzbw zzbw) {
        zzcio zzcio = this.zzm;
        if (zzcio != null) {
            zzcio.zzk("onPlayerError", zzbw);
        }
    }

    public final /* synthetic */ void zzm(zzkp zzkp, zzcf zzcf, zzcf zzcf2, int i) {
    }

    public final void zzn(zzkp zzkp, Object obj, long j) {
        zzcio zzcio = this.zzm;
        if (zzcio != null) {
            zzcio.zzv();
        }
    }

    public final /* synthetic */ void zzo(zzkp zzkp, zzgs zzgs) {
    }

    public final void zzp(zzkp zzkp, zzaf zzaf, zzgt zzgt) {
        zzciy zzciy = (zzciy) this.zzh.get();
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzbD)).booleanValue() && zzciy != null && zzaf != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("frameRate", String.valueOf(zzaf.zzt));
            hashMap.put("bitRate", String.valueOf(zzaf.zzi));
            int i = zzaf.zzr;
            int i2 = zzaf.zzs;
            hashMap.put("resolution", i + "x" + i2);
            hashMap.put("videoMime", zzaf.zzl);
            hashMap.put("videoSampleMime", zzaf.zzm);
            hashMap.put("videoCodec", zzaf.zzj);
            zzciy.zzd("onMetadataEvent", hashMap);
        }
    }

    public final void zzq(zzkp zzkp, zzda zzda) {
        zzcio zzcio = this.zzm;
        if (zzcio != null) {
            zzcio.zzC(zzda.zzc, zzda.zzd);
        }
    }

    public final int zzr() {
        return this.zzo;
    }

    public final int zzt() {
        return this.zzj.zzh();
    }

    public final long zzv() {
        return this.zzj.zzu();
    }

    public final long zzw() {
        return (long) this.zzn;
    }

    public final long zzx() {
        if (zzZ() && this.zzu.zzp()) {
            return Math.min((long) this.zzn, this.zzu.zzk());
        }
        return 0;
    }

    public final long zzy() {
        return this.zzj.zzl();
    }

    public final long zzz() {
        return this.zzj.zzv();
    }

    public final void zzD(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzsk zzsk;
        if (this.zzj != null) {
            this.zzk = byteBuffer;
            this.zzl = z;
            int length = uriArr.length;
            if (length == 1) {
                zzsk = zzW(uriArr[0]);
            } else {
                zzsk[] zzskArr = new zzsk[length];
                for (int i = 0; i < uriArr.length; i++) {
                    zzskArr[i] = zzW(uriArr[i]);
                }
                zzsk = new zzta(false, false, zzskArr);
            }
            this.zzj.zzB(zzsk);
            this.zzj.zzy();
            zzb.incrementAndGet();
        }
    }
}
