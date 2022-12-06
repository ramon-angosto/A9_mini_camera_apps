package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzcq;
import com.google.android.gms.ads.internal.client.zzcu;
import com.google.android.gms.ads.internal.client.zzde;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdol extends zzcze {
    public static final zzfvn zzc = zzfvn.zzt("3010", "3008", "1005", "1009", "2011", "2007");
    private final zzbbs zzA;
    private final Executor zzd;
    private final zzdoq zze;
    private final zzdoy zzf;
    private final zzdpq zzg;
    private final zzdov zzh;
    private final zzdpb zzi;
    private final zzgxc zzj;
    private final zzgxc zzk;
    private final zzgxc zzl;
    private final zzgxc zzm;
    private final zzgxc zzn;
    /* access modifiers changed from: private */
    public zzdql zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private final zzcec zzs;
    private final zzape zzt;
    private final zzcgv zzu;
    private final Context zzv;
    private final zzdon zzw;
    private final zzeoi zzx;
    /* access modifiers changed from: private */
    public final Map zzy = new HashMap();
    private final List zzz = new ArrayList();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdol(zzczd zzczd, Executor executor, zzdoq zzdoq, zzdoy zzdoy, zzdpq zzdpq, zzdov zzdov, zzdpb zzdpb, zzgxc zzgxc, zzgxc zzgxc2, zzgxc zzgxc3, zzgxc zzgxc4, zzgxc zzgxc5, zzcec zzcec, zzape zzape, zzcgv zzcgv, Context context, zzdon zzdon, zzeoi zzeoi, zzbbs zzbbs) {
        super(zzczd);
        this.zzd = executor;
        this.zze = zzdoq;
        this.zzf = zzdoy;
        this.zzg = zzdpq;
        this.zzh = zzdov;
        this.zzi = zzdpb;
        this.zzj = zzgxc;
        this.zzk = zzgxc2;
        this.zzl = zzgxc3;
        this.zzm = zzgxc4;
        this.zzn = zzgxc5;
        this.zzs = zzcec;
        this.zzt = zzape;
        this.zzu = zzcgv;
        this.zzv = context;
        this.zzw = zzdon;
        this.zzx = zzeoi;
        this.zzA = zzbbs;
    }

    public static boolean zzP(View view) {
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzio)).booleanValue()) {
            return view.isShown() && view.getGlobalVisibleRect(new Rect(), (Point) null);
        }
        zzt.zzp();
        long zzt2 = zzs.zzt(view);
        if (view.isShown() && view.getGlobalVisibleRect(new Rect(), (Point) null)) {
            if (zzt2 >= ((long) ((Integer) zzay.zzc().zzb(zzbjc.zzip)).intValue())) {
                return true;
            }
        }
        return false;
    }

    private final synchronized View zzR(Map map) {
        if (map == null) {
            return null;
        }
        zzfvn zzfvn = zzc;
        int size = zzfvn.size();
        int i = 0;
        while (i < size) {
            WeakReference weakReference = (WeakReference) map.get((String) zzfvn.get(i));
            i++;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
        }
        return null;
    }

    private final synchronized void zzS(View view, Map map, Map map2) {
        this.zzg.zzd(this.zzo);
        this.zzf.zzp(view, map, map2);
        this.zzq = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzT */
    public final synchronized void zzt(zzdql zzdql) {
        View view;
        zzapa zzc2;
        if (!this.zzp) {
            this.zzo = zzdql;
            this.zzg.zze(zzdql);
            this.zzf.zzx(zzdql.zzf(), zzdql.zzm(), zzdql.zzn(), zzdql, zzdql);
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzch)).booleanValue() && (zzc2 = this.zzt.zzc()) != null) {
                zzc2.zzn(zzdql.zzf());
            }
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzby)).booleanValue()) {
                zzfdk zzfdk = this.zzb;
                if (zzfdk.zzam) {
                    Iterator<String> keys = zzfdk.zzal.keys();
                    if (keys != null) {
                        while (keys.hasNext()) {
                            String next = keys.next();
                            WeakReference weakReference = (WeakReference) this.zzo.zzl().get(next);
                            this.zzy.put(next, false);
                            if (!(weakReference == null || (view = (View) weakReference.get()) == null)) {
                                zzbbr zzbbr = new zzbbr(this.zzv, view);
                                this.zzz.add(zzbbr);
                                zzbbr.zzc(new zzdok(this, next));
                            }
                        }
                    }
                }
            }
            if (zzdql.zzi() != null) {
                zzdql.zzi().zzc(this.zzs);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzU */
    public final void zzu(zzdql zzdql) {
        this.zzf.zzy(zzdql.zzf(), zzdql.zzl());
        if (zzdql.zzh() != null) {
            zzdql.zzh().setClickable(false);
            zzdql.zzh().removeAllViews();
        }
        if (zzdql.zzi() != null) {
            zzdql.zzi().zze(this.zzs);
        }
        this.zzo = null;
    }

    public final synchronized void zzA() {
        zzdql zzdql = this.zzo;
        if (zzdql == null) {
            zze.zze("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            this.zzd.execute(new zzdoh(this, zzdql instanceof zzdpk));
        }
    }

    public final synchronized void zzB() {
        if (!this.zzq) {
            this.zzf.zzq();
        }
    }

    public final void zzC(View view) {
        zzdoq zzdoq = this.zze;
        IObjectWrapper zzu2 = zzdoq.zzu();
        zzcmp zzq2 = zzdoq.zzq();
        if (this.zzh.zzd() && zzu2 != null && zzq2 != null && view != null) {
            zzt.zzA().zzc(zzu2, view);
        }
    }

    public final synchronized void zzD(View view, MotionEvent motionEvent, View view2) {
        this.zzf.zzr(view, motionEvent, view2);
    }

    public final synchronized void zzE(Bundle bundle) {
        this.zzf.zzs(bundle);
    }

    public final synchronized void zzF(View view) {
        this.zzf.zzt(view);
    }

    public final synchronized void zzG() {
        this.zzf.zzu();
    }

    public final synchronized void zzH(zzcq zzcq) {
        this.zzf.zzv(zzcq);
    }

    public final synchronized void zzI(zzde zzde) {
        this.zzx.zza(zzde);
    }

    public final synchronized void zzJ(zzbny zzbny) {
        this.zzf.zzw(zzbny);
    }

    public final synchronized void zzK(zzdql zzdql) {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzbw)).booleanValue()) {
            zzs.zza.post(new zzdoi(this, zzdql));
        } else {
            zzt(zzdql);
        }
    }

    public final synchronized void zzL(zzdql zzdql) {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzbw)).booleanValue()) {
            zzs.zza.post(new zzdoe(this, zzdql));
        } else {
            zzu(zzdql);
        }
    }

    public final boolean zzM() {
        return this.zzh.zze();
    }

    public final synchronized boolean zzN() {
        return this.zzf.zzz();
    }

    public final boolean zzO() {
        return this.zzh.zzd();
    }

    public final synchronized boolean zzQ(Bundle bundle) {
        if (this.zzq) {
            return true;
        }
        boolean zzA2 = this.zzf.zzA(bundle);
        this.zzq = zzA2;
        return zzA2;
    }

    public final synchronized void zzV() {
        this.zzp = true;
        this.zzd.execute(new zzdoj(this));
        super.zzV();
    }

    public final void zzW() {
        this.zzd.execute(new zzdof(this));
        if (this.zze.zzc() != 7) {
            Executor executor = this.zzd;
            zzdoy zzdoy = this.zzf;
            zzdoy.getClass();
            executor.execute(new zzdog(zzdoy));
        }
        super.zzW();
    }

    public final zzdon zza() {
        return this.zzw;
    }

    public final String zzd() {
        return this.zzh.zzb();
    }

    public final synchronized JSONObject zzf(View view, Map map, Map map2) {
        return this.zzf.zzd(view, map, map2);
    }

    public final synchronized JSONObject zzg(View view, Map map, Map map2) {
        return this.zzf.zze(view, map, map2);
    }

    public final void zzi(View view) {
        IObjectWrapper zzu2 = this.zze.zzu();
        if (this.zzh.zzd() && zzu2 != null && view != null) {
            zzt.zzA();
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzeg)).booleanValue() && zzfkp.zzb()) {
                Object unwrap = ObjectWrapper.unwrap(zzu2);
                if (unwrap instanceof zzfkr) {
                    ((zzfkr) unwrap).zzb(view, zzfkx.NOT_VISIBLE, "Ad overlay");
                }
            }
        }
    }

    public final synchronized void zzk() {
        this.zzf.zzg();
    }

    public final void zzq(String str, boolean z) {
        String str2;
        zzeha zzeha;
        zzehb zzehb;
        if (this.zzh.zzd() && !TextUtils.isEmpty(str)) {
            zzdoq zzdoq = this.zze;
            zzcmp zzq2 = zzdoq.zzq();
            zzcmp zzr2 = zzdoq.zzr();
            if (zzq2 == null && zzr2 == null) {
                zze.zzj("Omid display and video webview are null. Skipping initialization.");
                return;
            }
            boolean z2 = false;
            boolean z3 = zzq2 != null;
            boolean z4 = zzr2 != null;
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzek)).booleanValue()) {
                this.zzh.zza();
                int zzb = this.zzh.zza().zzb();
                int i = zzb - 1;
                if (i != 0) {
                    if (i != 1) {
                        zze.zzj("Unknown omid media type: " + (zzb != 1 ? zzb != 2 ? "UNKNOWN" : "DISPLAY" : "VIDEO") + ". Not initializing Omid.");
                        return;
                    } else if (zzq2 != null) {
                        z4 = false;
                        z2 = true;
                    } else {
                        zze.zzj("Omid media type was display but there was no display webview.");
                        return;
                    }
                } else if (zzr2 != null) {
                    z4 = true;
                } else {
                    zze.zzj("Omid media type was video but there was no video webview.");
                    return;
                }
            } else {
                z2 = z3;
            }
            if (z2) {
                str2 = null;
            } else {
                str2 = "javascript";
                zzq2 = zzr2;
            }
            String str3 = str2;
            zzq2.zzI();
            if (!zzt.zzA().zze(this.zzv)) {
                zze.zzj("Failed to initialize omid in InternalNativeAd");
                return;
            }
            zzcgv zzcgv = this.zzu;
            String str4 = zzcgv.zzb + "." + zzcgv.zzc;
            if (z4) {
                zzeha = zzeha.VIDEO;
                zzehb = zzehb.DEFINED_BY_JAVASCRIPT;
            } else {
                zzeha = zzeha.NATIVE_DISPLAY;
                if (this.zze.zzc() == 3) {
                    zzehb = zzehb.UNSPECIFIED;
                } else {
                    zzehb = zzehb.ONE_PIXEL;
                }
            }
            IObjectWrapper zzb2 = zzt.zzA().zzb(str4, zzq2.zzI(), "", "javascript", str3, str, zzehb, zzeha, this.zzb.zzan);
            if (zzb2 == null) {
                zze.zzj("Failed to create omid session in InternalNativeAd");
                return;
            }
            this.zze.zzaa(zzb2);
            zzq2.zzar(zzb2);
            if (z4) {
                zzt.zzA().zzc(zzb2, zzr2.zzH());
                this.zzr = true;
            }
            if (z) {
                zzt.zzA().zzd(zzb2);
                zzq2.zzd("onSdkLoaded", new ArrayMap());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzr() {
        this.zzf.zzh();
        this.zze.zzG();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzs(boolean z) {
        this.zzf.zzn(this.zzo.zzf(), this.zzo.zzl(), this.zzo.zzm(), z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0089, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00ec, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzv(android.view.View r4, java.util.Map r5, java.util.Map r6, boolean r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzq     // Catch:{ all -> 0x00f2 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzby     // Catch:{ all -> 0x00f2 }
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x00f2 }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x00f2 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00f2 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00f2 }
            if (r0 == 0) goto L_0x0045
            com.google.android.gms.internal.ads.zzfdk r0 = r3.zzb     // Catch:{ all -> 0x00f2 }
            boolean r0 = r0.zzam     // Catch:{ all -> 0x00f2 }
            if (r0 == 0) goto L_0x0045
            java.util.Map r0 = r3.zzy     // Catch:{ all -> 0x00f2 }
            java.util.Set r0 = r0.keySet()     // Catch:{ all -> 0x00f2 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00f2 }
        L_0x0029:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x00f2 }
            if (r1 == 0) goto L_0x0045
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x00f2 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00f2 }
            java.util.Map r2 = r3.zzy     // Catch:{ all -> 0x00f2 }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ all -> 0x00f2 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x00f2 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x00f2 }
            if (r1 != 0) goto L_0x0029
            monitor-exit(r3)
            return
        L_0x0045:
            if (r7 != 0) goto L_0x008a
            com.google.android.gms.internal.ads.zzbiu r7 = com.google.android.gms.internal.ads.zzbjc.zzcZ     // Catch:{ all -> 0x00f2 }
            com.google.android.gms.internal.ads.zzbja r0 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x00f2 }
            java.lang.Object r7 = r0.zzb(r7)     // Catch:{ all -> 0x00f2 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x00f2 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x00f2 }
            if (r7 == 0) goto L_0x0088
            if (r5 == 0) goto L_0x0088
            java.util.Set r7 = r5.entrySet()     // Catch:{ all -> 0x00f2 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x00f2 }
        L_0x0063:
            boolean r0 = r7.hasNext()     // Catch:{ all -> 0x00f2 }
            if (r0 == 0) goto L_0x0088
            java.lang.Object r0 = r7.next()     // Catch:{ all -> 0x00f2 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x00f2 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x00f2 }
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0     // Catch:{ all -> 0x00f2 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x00f2 }
            android.view.View r0 = (android.view.View) r0     // Catch:{ all -> 0x00f2 }
            if (r0 == 0) goto L_0x0063
            boolean r0 = zzP(r0)     // Catch:{ all -> 0x00f2 }
            if (r0 == 0) goto L_0x0063
            r3.zzS(r4, r5, r6)     // Catch:{ all -> 0x00f2 }
            monitor-exit(r3)
            return
        L_0x0088:
            monitor-exit(r3)
            return
        L_0x008a:
            android.view.View r7 = r3.zzR(r5)     // Catch:{ all -> 0x00f2 }
            if (r7 != 0) goto L_0x0095
            r3.zzS(r4, r5, r6)     // Catch:{ all -> 0x00f2 }
            monitor-exit(r3)
            return
        L_0x0095:
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzda     // Catch:{ all -> 0x00f2 }
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x00f2 }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x00f2 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00f2 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00f2 }
            if (r0 == 0) goto L_0x00b4
            boolean r7 = zzP(r7)     // Catch:{ all -> 0x00f2 }
            if (r7 == 0) goto L_0x00b2
            r3.zzS(r4, r5, r6)     // Catch:{ all -> 0x00f2 }
            monitor-exit(r3)
            return
        L_0x00b2:
            monitor-exit(r3)
            return
        L_0x00b4:
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzdb     // Catch:{ all -> 0x00f2 }
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x00f2 }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x00f2 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00f2 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00f2 }
            if (r0 == 0) goto L_0x00ed
            android.graphics.Rect r0 = new android.graphics.Rect     // Catch:{ all -> 0x00f2 }
            r0.<init>()     // Catch:{ all -> 0x00f2 }
            r1 = 0
            boolean r1 = r7.getGlobalVisibleRect(r0, r1)     // Catch:{ all -> 0x00f2 }
            if (r1 == 0) goto L_0x00eb
            int r1 = r7.getHeight()     // Catch:{ all -> 0x00f2 }
            int r2 = r0.height()     // Catch:{ all -> 0x00f2 }
            if (r1 != r2) goto L_0x00eb
            int r7 = r7.getWidth()     // Catch:{ all -> 0x00f2 }
            int r0 = r0.width()     // Catch:{ all -> 0x00f2 }
            if (r7 != r0) goto L_0x00eb
            r3.zzS(r4, r5, r6)     // Catch:{ all -> 0x00f2 }
            monitor-exit(r3)
            return
        L_0x00eb:
            monitor-exit(r3)
            return
        L_0x00ed:
            r3.zzS(r4, r5, r6)     // Catch:{ all -> 0x00f2 }
            monitor-exit(r3)
            return
        L_0x00f2:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdol.zzv(android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized void zzw(zzcu zzcu) {
        this.zzf.zzi(zzcu);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzx(android.view.View r9, android.view.View r10, java.util.Map r11, java.util.Map r12, boolean r13) {
        /*
            r8 = this;
            monitor-enter(r8)
            com.google.android.gms.internal.ads.zzdpq r0 = r8.zzg     // Catch:{ all -> 0x0031 }
            com.google.android.gms.internal.ads.zzdql r1 = r8.zzo     // Catch:{ all -> 0x0031 }
            r0.zzc(r1)     // Catch:{ all -> 0x0031 }
            com.google.android.gms.internal.ads.zzdoy r2 = r8.zzf     // Catch:{ all -> 0x0031 }
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r2.zzj(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0031 }
            boolean r9 = r8.zzr     // Catch:{ all -> 0x0031 }
            if (r9 == 0) goto L_0x002f
            com.google.android.gms.internal.ads.zzdoq r9 = r8.zze     // Catch:{ all -> 0x0031 }
            com.google.android.gms.internal.ads.zzcmp r10 = r9.zzr()     // Catch:{ all -> 0x0031 }
            if (r10 != 0) goto L_0x001f
            goto L_0x002f
        L_0x001f:
            com.google.android.gms.internal.ads.zzcmp r9 = r9.zzr()     // Catch:{ all -> 0x0031 }
            androidx.collection.ArrayMap r10 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0031 }
            r10.<init>()     // Catch:{ all -> 0x0031 }
            java.lang.String r11 = "onSdkAdUserInteractionClick"
            r9.zzd(r11, r10)     // Catch:{ all -> 0x0031 }
            monitor-exit(r8)
            return
        L_0x002f:
            monitor-exit(r8)
            return
        L_0x0031:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdol.zzx(android.view.View, android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized void zzy(String str) {
        this.zzf.zzk(str);
    }

    public final synchronized void zzz(Bundle bundle) {
        this.zzf.zzl(bundle);
    }

    public static /* synthetic */ void zzh(zzdol zzdol) {
        try {
            zzdoq zzdoq = zzdol.zze;
            int zzc2 = zzdoq.zzc();
            if (zzc2 != 1) {
                if (zzc2 != 2) {
                    if (zzc2 != 3) {
                        if (zzc2 != 6) {
                            if (zzc2 != 7) {
                                zze.zzg("Wrong native template id!");
                                return;
                            }
                            zzdpb zzdpb = zzdol.zzi;
                            if (zzdpb.zzg() != null) {
                                zzdpb.zzg().zzg((zzbsf) zzdol.zzm.zzb());
                            }
                        } else if (zzdol.zzi.zzf() != null) {
                            zzdol.zzq("Google", true);
                            zzdol.zzi.zzf().zze((zzbob) zzdol.zzl.zzb());
                        }
                    } else if (zzdol.zzi.zzd(zzdoq.zzy()) != null) {
                        if (zzdol.zze.zzr() != null) {
                            zzdol.zzq("Google", true);
                        }
                        zzdol.zzi.zzd(zzdol.zze.zzy()).zze((zzbmy) zzdol.zzn.zzb());
                    }
                } else if (zzdol.zzi.zza() != null) {
                    zzdol.zzq("Google", true);
                    zzdol.zzi.zza().zze((zzbmt) zzdol.zzk.zzb());
                }
            } else if (zzdol.zzi.zzb() != null) {
                zzdol.zzq("Google", true);
                zzdol.zzi.zzb().zze((zzbmv) zzdol.zzj.zzb());
            }
        } catch (RemoteException e) {
            zze.zzh("RemoteException when notifyAdLoad is called", e);
        }
    }
}
