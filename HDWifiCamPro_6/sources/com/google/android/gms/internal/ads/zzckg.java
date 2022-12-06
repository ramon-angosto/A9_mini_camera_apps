package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
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
public final class zzckg extends zzcip implements zzbab, zzaxz, zzbbl, zzatt, zzasj {
    public static final /* synthetic */ int zzc = 0;
    private final Context zzd;
    private final zzcjv zze;
    private final zzatb zzf;
    private final zzatb zzg;
    private final zzazd zzh;
    private final zzcix zzi;
    private zzasm zzj;
    private ByteBuffer zzk;
    private boolean zzl;
    private final WeakReference zzm;
    private zzcio zzn;
    private int zzo;
    private int zzp;
    private long zzq;
    private final String zzr;
    private final int zzs;
    private final Object zzt = new Object();
    private final ArrayList zzu;
    private volatile zzcju zzv;
    private final Set zzw = new HashSet();

    public zzckg(Context context, zzcix zzcix, zzciy zzciy) {
        this.zzd = context;
        this.zzi = zzcix;
        this.zzm = new WeakReference(zzciy);
        this.zze = new zzcjv();
        this.zzf = new zzbba(this.zzd, zzaww.zza, 0, zzs.zza, this, -1);
        this.zzg = new zzaui(zzaww.zza, (zzauw) null, true, zzs.zza, this);
        this.zzh = new zzayz((zzaze) null);
        if (zze.zzc()) {
            zze.zza("ForkedExoPlayerAdapter initialize ".concat(toString()));
        }
        zza.incrementAndGet();
        int i = 0;
        this.zzj = zzasn.zza(new zzatb[]{this.zzg, this.zzf}, this.zzh, this.zze);
        this.zzj.zze(this);
        this.zzo = 0;
        this.zzq = 0;
        this.zzp = 0;
        this.zzu = new ArrayList();
        this.zzv = null;
        this.zzr = (zzciy == null || zzciy.zzt() == null) ? "" : zzciy.zzt();
        this.zzs = zzciy != null ? zzciy.zzh() : i;
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzn)).booleanValue()) {
            this.zzj.zzg();
        }
        if (zzciy != null && zzciy.zzg() > 0) {
            this.zzj.zzp(zzciy.zzg());
        }
        if (zzciy != null && zzciy.zzf() > 0) {
            this.zzj.zzo(zzciy.zzf());
        }
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzp)).booleanValue()) {
            this.zzj.zzi();
            this.zzj.zzh(((Integer) zzay.zzc().zzb(zzbjc.zzq)).intValue());
        }
    }

    private final boolean zzY() {
        return this.zzv != null && this.zzv.zzk();
    }

    public final void finalize() throws Throwable {
        zza.decrementAndGet();
        if (zze.zzc()) {
            zze.zza("ForkedExoPlayerAdapter finalize ".concat(toString()));
        }
    }

    public final long zzA() {
        if (!zzY()) {
            return (long) this.zzo;
        }
        return 0;
    }

    public final long zzB() {
        if (zzY()) {
            return this.zzv.zzf();
        }
        synchronized (this.zzt) {
            while (!this.zzu.isEmpty()) {
                long j = this.zzq;
                Map zze2 = ((zzazv) this.zzu.remove(0)).zze();
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
                this.zzq = j + j2;
            }
        }
        return this.zzq;
    }

    public final void zzC(Uri[] uriArr, String str) {
        zzD(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void zzE() {
        zzasm zzasm = this.zzj;
        if (zzasm != null) {
            zzasm.zzl(this);
            this.zzj.zzk();
            this.zzj = null;
            zzb.decrementAndGet();
        }
    }

    public final void zzF(long j) {
        this.zzj.zzm(j);
    }

    public final void zzG(int i) {
        this.zze.zzf(i);
    }

    public final void zzH(int i) {
        this.zze.zzg(i);
    }

    public final void zzI(zzcio zzcio) {
        this.zzn = zzcio;
    }

    public final void zzJ(int i) {
        this.zze.zzh(i);
    }

    public final void zzK(int i) {
        this.zze.zzi(i);
    }

    public final void zzL(boolean z) {
        this.zzj.zzq(z);
    }

    public final void zzM(boolean z) {
        if (this.zzj != null) {
            for (int i = 0; i < 2; i++) {
                this.zzh.zze(i, !z);
            }
        }
    }

    public final void zzN(int i) {
        for (WeakReference weakReference : this.zzw) {
            zzcjs zzcjs = (zzcjs) weakReference.get();
            if (zzcjs != null) {
                zzcjs.zzh(i);
            }
        }
    }

    public final void zzO(Surface surface, boolean z) {
        zzasm zzasm = this.zzj;
        if (zzasm != null) {
            zzasl zzasl = new zzasl(this.zzf, 1, surface);
            if (z) {
                zzasm.zzf(zzasl);
                return;
            }
            zzasm.zzn(zzasl);
        }
    }

    public final void zzP(float f, boolean z) {
        if (this.zzj != null) {
            zzasl zzasl = new zzasl(this.zzg, 2, Float.valueOf(f));
            this.zzj.zzn(zzasl);
        }
    }

    public final void zzQ() {
        this.zzj.zzr();
    }

    public final boolean zzR() {
        return this.zzj != null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzazm zzS(String str, boolean z) {
        zzckg zzckg = true != z ? null : this;
        zzcix zzcix = this.zzi;
        zzcjs zzcjs = new zzcjs(str, zzckg, zzcix.zzd, zzcix.zzf, zzcix.zzi);
        this.zzw.add(new WeakReference(zzcjs));
        return zzcjs;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzazm zzT(String str, boolean z) {
        zzckg zzckg = true != z ? null : this;
        zzcix zzcix = this.zzi;
        return new zzazq(str, (zzbam) null, zzckg, zzcix.zzd, zzcix.zzf, true, (zzazu) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzazm zzU(zzazl zzazl) {
        return new zzcju(this.zzd, zzazl.zza(), this.zzr, this.zzs, this, new zzckc(this), (byte[]) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzV(boolean z, long j) {
        zzcio zzcio = this.zzn;
        if (zzcio != null) {
            zzcio.zzi(z, j);
        }
    }

    public final void zzW(zzazm zzazm, int i) {
        this.zzo += i;
    }

    /* renamed from: zzX */
    public final void zzk(zzazm zzazm, zzazo zzazo) {
        if (zzazm instanceof zzazv) {
            synchronized (this.zzt) {
                this.zzu.add((zzazv) zzazm);
            }
        } else if (zzazm instanceof zzcju) {
            this.zzv = (zzcju) zzazm;
            zzciy zzciy = (zzciy) this.zzm.get();
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzbD)).booleanValue() && zzciy != null && this.zzv.zzh()) {
                HashMap hashMap = new HashMap();
                hashMap.put("gcacheHit", String.valueOf(this.zzv.zzj()));
                hashMap.put("gcacheDownloaded", String.valueOf(this.zzv.zzi()));
                zzs.zza.post(new zzckd(zzciy, hashMap));
            }
        }
    }

    public final void zza(boolean z) {
    }

    public final void zzb(zzata zzata) {
    }

    public final void zzc(zzasi zzasi) {
        zzcio zzcio = this.zzn;
        if (zzcio != null) {
            zzcio.zzk("onPlayerError", zzasi);
        }
    }

    public final void zzd(boolean z, int i) {
        zzcio zzcio = this.zzn;
        if (zzcio != null) {
            zzcio.zzm(i);
        }
    }

    public final void zze() {
    }

    public final void zzf(zzath zzath, Object obj) {
    }

    public final void zzg(zzayt zzayt, zzazf zzazf) {
    }

    public final void zzh(zzasw zzasw) {
        zzciy zzciy = (zzciy) this.zzm.get();
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzbD)).booleanValue() && zzciy != null && zzasw != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("audioMime", zzasw.zze);
            hashMap.put("audioSampleMime", zzasw.zzf);
            hashMap.put("audioCodec", zzasw.zzc);
            zzciy.zzd("onMetadataEvent", hashMap);
        }
    }

    public final void zzi(IOException iOException) {
        zzcio zzcio = this.zzn;
        if (zzcio == null) {
            return;
        }
        if (this.zzi.zzl) {
            zzcio.zzl("onLoadException", iOException);
        } else {
            zzcio.zzk("onLoadError", iOException);
        }
    }

    public final /* synthetic */ void zzj(Object obj, int i) {
        this.zzo += i;
    }

    public final void zzl(int i, long j) {
        this.zzp += i;
    }

    public final void zzm(Surface surface) {
        zzcio zzcio = this.zzn;
        if (zzcio != null) {
            zzcio.zzv();
        }
    }

    public final void zzn(zzasw zzasw) {
        zzciy zzciy = (zzciy) this.zzm.get();
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzbD)).booleanValue() && zzciy != null && zzasw != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("frameRate", String.valueOf(zzasw.zzl));
            hashMap.put("bitRate", String.valueOf(zzasw.zzb));
            int i = zzasw.zzj;
            int i2 = zzasw.zzk;
            hashMap.put("resolution", i + "x" + i2);
            hashMap.put("videoMime", zzasw.zze);
            hashMap.put("videoSampleMime", zzasw.zzf);
            hashMap.put("videoCodec", zzasw.zzc);
            zzciy.zzd("onMetadataEvent", hashMap);
        }
    }

    public final void zzo(int i, int i2, int i3, float f) {
        zzcio zzcio = this.zzn;
        if (zzcio != null) {
            zzcio.zzC(i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0046, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzay.zzc().zzb(com.google.android.gms.internal.ads.zzbjc.zzbD)).booleanValue() == false) goto L_0x0048;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzaye zzp(android.net.Uri r11, java.lang.String r12) {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzaya r9 = new com.google.android.gms.internal.ads.zzaya
            boolean r0 = r10.zzl
            if (r0 == 0) goto L_0x0023
            java.nio.ByteBuffer r0 = r10.zzk
            int r0 = r0.limit()
            if (r0 <= 0) goto L_0x0023
            java.nio.ByteBuffer r12 = r10.zzk
            int r12 = r12.limit()
            byte[] r12 = new byte[r12]
            java.nio.ByteBuffer r0 = r10.zzk
            r0.get(r12)
            com.google.android.gms.internal.ads.zzcjw r0 = new com.google.android.gms.internal.ads.zzcjw
            r0.<init>(r12)
            r2 = r0
            goto L_0x0097
        L_0x0023:
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzbM
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            if (r0 == 0) goto L_0x0048
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzbD
            com.google.android.gms.internal.ads.zzbja r2 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r0 = r2.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0050
        L_0x0048:
            com.google.android.gms.internal.ads.zzcix r0 = r10.zzi
            boolean r0 = r0.zzj
            if (r0 != 0) goto L_0x004f
            goto L_0x0050
        L_0x004f:
            r1 = 0
        L_0x0050:
            com.google.android.gms.internal.ads.zzcix r0 = r10.zzi
            boolean r2 = r0.zzo
            if (r2 == 0) goto L_0x005c
            com.google.android.gms.internal.ads.zzcjx r0 = new com.google.android.gms.internal.ads.zzcjx
            r0.<init>(r10, r12, r1)
            goto L_0x006b
        L_0x005c:
            int r0 = r0.zzi
            if (r0 <= 0) goto L_0x0066
            com.google.android.gms.internal.ads.zzcjy r0 = new com.google.android.gms.internal.ads.zzcjy
            r0.<init>(r10, r12, r1)
            goto L_0x006b
        L_0x0066:
            com.google.android.gms.internal.ads.zzcjz r0 = new com.google.android.gms.internal.ads.zzcjz
            r0.<init>(r10, r12, r1)
        L_0x006b:
            com.google.android.gms.internal.ads.zzcix r12 = r10.zzi
            boolean r12 = r12.zzj
            if (r12 == 0) goto L_0x0077
            com.google.android.gms.internal.ads.zzcka r12 = new com.google.android.gms.internal.ads.zzcka
            r12.<init>(r10, r0)
            goto L_0x0078
        L_0x0077:
            r12 = r0
        L_0x0078:
            java.nio.ByteBuffer r0 = r10.zzk
            if (r0 == 0) goto L_0x0096
            int r0 = r0.limit()
            if (r0 <= 0) goto L_0x0096
            java.nio.ByteBuffer r0 = r10.zzk
            int r0 = r0.limit()
            byte[] r0 = new byte[r0]
            java.nio.ByteBuffer r1 = r10.zzk
            r1.get(r0)
            com.google.android.gms.internal.ads.zzckb r1 = new com.google.android.gms.internal.ads.zzckb
            r1.<init>(r12, r0)
            r2 = r1
            goto L_0x0097
        L_0x0096:
            r2 = r12
        L_0x0097:
            com.google.android.gms.internal.ads.zzbiu r12 = com.google.android.gms.internal.ads.zzbjc.zzm
            com.google.android.gms.internal.ads.zzbja r0 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r12 = r0.zzb(r12)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x00ac
            com.google.android.gms.internal.ads.zzcke r12 = com.google.android.gms.internal.ads.zzcke.zza
            goto L_0x00ae
        L_0x00ac:
            com.google.android.gms.internal.ads.zzckf r12 = com.google.android.gms.internal.ads.zzckf.zza
        L_0x00ae:
            r3 = r12
            com.google.android.gms.internal.ads.zzcix r12 = r10.zzi
            int r4 = r12.zzk
            com.google.android.gms.internal.ads.zzfpz r5 = com.google.android.gms.ads.internal.util.zzs.zza
            r7 = 0
            com.google.android.gms.internal.ads.zzcix r12 = r10.zzi
            int r8 = r12.zzg
            r0 = r9
            r1 = r11
            r6 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzckg.zzp(android.net.Uri, java.lang.String):com.google.android.gms.internal.ads.zzaye");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzazm zzq(String str, boolean z) {
        zzckg zzckg = true != z ? null : this;
        zzcix zzcix = this.zzi;
        return new zzckk(str, zzckg, zzcix.zzd, zzcix.zzf, zzcix.zzp, zzcix.zzq);
    }

    public final int zzr() {
        return this.zzp;
    }

    public final int zzt() {
        return this.zzj.zza();
    }

    public final long zzv() {
        return this.zzj.zzb();
    }

    public final long zzw() {
        return (long) this.zzo;
    }

    public final long zzx() {
        if (zzY() && this.zzv.zzj()) {
            return Math.min((long) this.zzo, this.zzv.zze());
        }
        return 0;
    }

    public final long zzy() {
        return this.zzj.zzc();
    }

    public final long zzz() {
        return this.zzj.zzd();
    }

    public final void zzD(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzaye zzaye;
        if (this.zzj != null) {
            this.zzk = byteBuffer;
            this.zzl = z;
            int length = uriArr.length;
            if (length == 1) {
                zzaye = zzp(uriArr[0], str);
            } else {
                zzaye[] zzayeArr = new zzaye[length];
                for (int i = 0; i < uriArr.length; i++) {
                    zzayeArr[i] = zzp(uriArr[i], str);
                }
                zzaye = new zzayi(zzayeArr);
            }
            this.zzj.zzj(zzaye);
            zzb.incrementAndGet();
        }
    }
}
