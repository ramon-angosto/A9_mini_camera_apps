package com.google.android.gms.ads.nonagon.signalgeneration;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.zzbx;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzape;
import com.google.android.gms.internal.ads.zzapf;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzbkl;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzcaa;
import com.google.android.gms.internal.ads.zzcfd;
import com.google.android.gms.internal.ads.zzcff;
import com.google.android.gms.internal.ads.zzcfk;
import com.google.android.gms.internal.ads.zzcgp;
import com.google.android.gms.internal.ads.zzcgv;
import com.google.android.gms.internal.ads.zzchc;
import com.google.android.gms.internal.ads.zzcom;
import com.google.android.gms.internal.ads.zzdtn;
import com.google.android.gms.internal.ads.zzdxl;
import com.google.android.gms.internal.ads.zzdxv;
import com.google.android.gms.internal.ads.zzffb;
import com.google.android.gms.internal.ads.zzfji;
import com.google.android.gms.internal.ads.zzfjj;
import com.google.android.gms.internal.ads.zzfju;
import com.google.android.gms.internal.ads.zzfjw;
import com.google.android.gms.internal.ads.zzfkm;
import com.google.android.gms.internal.ads.zzftm;
import com.google.android.gms.internal.ads.zzfyx;
import com.google.android.gms.internal.ads.zzfzg;
import com.google.android.gms.internal.ads.zzfzp;
import com.google.android.gms.internal.ads.zzfzq;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaa extends zzcff {
    protected static final List zza = new ArrayList(Arrays.asList(new String[]{"/aclk", "/pcs/click", "/dbm/clk"}));
    protected static final List zzb = new ArrayList(Arrays.asList(new String[]{".doubleclick.net", ".googleadservices.com"}));
    protected static final List zzc = new ArrayList(Arrays.asList(new String[]{"/pagead/adview", "/pcs/view", "/pagead/conversion", "/dbm/ad"}));
    protected static final List zzd = new ArrayList(Arrays.asList(new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"}));
    public static final /* synthetic */ int zze = 0;
    /* access modifiers changed from: private */
    public final zzcgv zzA;
    /* access modifiers changed from: private */
    public String zzB;
    /* access modifiers changed from: private */
    public final String zzC;
    private final List zzD;
    private final List zzE;
    private final List zzF;
    private final List zzG;
    private final zzcom zzf;
    /* access modifiers changed from: private */
    public Context zzg;
    private final zzape zzh;
    private final zzffb zzi;
    /* access modifiers changed from: private */
    public zzdxl zzj = null;
    private final zzfzq zzk;
    private final ScheduledExecutorService zzl;
    private zzcaa zzm;
    private Point zzn = new Point();
    private Point zzo = new Point();
    private final Set zzp = Collections.newSetFromMap(new WeakHashMap());
    private final zzc zzq;
    /* access modifiers changed from: private */
    public final zzdxv zzr;
    /* access modifiers changed from: private */
    public final zzfkm zzs;
    /* access modifiers changed from: private */
    public final boolean zzt;
    /* access modifiers changed from: private */
    public final boolean zzu;
    /* access modifiers changed from: private */
    public final boolean zzv;
    /* access modifiers changed from: private */
    public final boolean zzw;
    /* access modifiers changed from: private */
    public final String zzx;
    /* access modifiers changed from: private */
    public final String zzy;
    /* access modifiers changed from: private */
    public final AtomicInteger zzz = new AtomicInteger(0);

    public zzaa(zzcom zzcom, Context context, zzape zzape, zzffb zzffb, zzfzq zzfzq, ScheduledExecutorService scheduledExecutorService, zzdxv zzdxv, zzfkm zzfkm, zzcgv zzcgv) {
        List list;
        this.zzf = zzcom;
        this.zzg = context;
        this.zzh = zzape;
        this.zzi = zzffb;
        this.zzk = zzfzq;
        this.zzl = scheduledExecutorService;
        this.zzq = this.zzf.zzm();
        this.zzr = zzdxv;
        this.zzs = zzfkm;
        this.zzA = zzcgv;
        this.zzt = ((Boolean) zzay.zzc().zzb(zzbjc.zzgq)).booleanValue();
        this.zzu = ((Boolean) zzay.zzc().zzb(zzbjc.zzgp)).booleanValue();
        this.zzv = ((Boolean) zzay.zzc().zzb(zzbjc.zzgr)).booleanValue();
        this.zzw = ((Boolean) zzay.zzc().zzb(zzbjc.zzgt)).booleanValue();
        this.zzx = (String) zzay.zzc().zzb(zzbjc.zzgs);
        this.zzy = (String) zzay.zzc().zzb(zzbjc.zzgu);
        this.zzC = (String) zzay.zzc().zzb(zzbjc.zzgv);
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzgw)).booleanValue()) {
            this.zzD = zzX((String) zzay.zzc().zzb(zzbjc.zzgx));
            this.zzE = zzX((String) zzay.zzc().zzb(zzbjc.zzgy));
            this.zzF = zzX((String) zzay.zzc().zzb(zzbjc.zzgz));
            list = zzX((String) zzay.zzc().zzb(zzbjc.zzgA));
        } else {
            this.zzD = zza;
            this.zzE = zzb;
            this.zzF = zzc;
            list = zzd;
        }
        this.zzG = list;
    }

    static /* bridge */ /* synthetic */ void zzF(zzaa zzaa, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (zzaa.zzN((Uri) it.next())) {
                zzaa.zzz.getAndIncrement();
                return;
            }
        }
    }

    static /* bridge */ /* synthetic */ void zzG(zzaa zzaa, String str, String str2, zzdxl zzdxl) {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzga)).booleanValue()) {
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzgg)).booleanValue()) {
                zzchc.zza.execute(new zzi(zzaa, str, str2, zzdxl));
            } else {
                zzaa.zzq.zzd(str, str2, zzdxl);
            }
        }
    }

    static final /* synthetic */ Uri zzP(Uri uri, String str) {
        return !TextUtils.isEmpty(str) ? zzW(uri, "nas", str) : uri;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.ads.nonagon.signalgeneration.zzh zzQ(android.content.Context r8, java.lang.String r9, java.lang.String r10, com.google.android.gms.ads.internal.client.zzq r11, com.google.android.gms.ads.internal.client.zzl r12) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzfed r0 = new com.google.android.gms.internal.ads.zzfed
            r0.<init>()
            com.google.android.gms.internal.ads.zzbiu r1 = com.google.android.gms.internal.ads.zzbjc.zzgC
            com.google.android.gms.internal.ads.zzbja r2 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r1 = r2.zzb(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            java.lang.String r2 = "REWARDED_INTERSTITIAL"
            java.lang.String r3 = "REWARDED"
            r4 = 3
            r5 = 2
            if (r1 == 0) goto L_0x0038
            boolean r1 = r3.equals(r10)
            if (r1 == 0) goto L_0x002b
            com.google.android.gms.internal.ads.zzfdq r1 = r0.zzo()
            r1.zza(r5)
            goto L_0x0038
        L_0x002b:
            boolean r1 = r2.equals(r10)
            if (r1 == 0) goto L_0x0038
            com.google.android.gms.internal.ads.zzfdq r1 = r0.zzo()
            r1.zza(r4)
        L_0x0038:
            com.google.android.gms.internal.ads.zzcom r1 = r7.zzf
            com.google.android.gms.ads.nonagon.signalgeneration.zzg r1 = r1.zzn()
            com.google.android.gms.internal.ads.zzdck r6 = new com.google.android.gms.internal.ads.zzdck
            r6.<init>()
            r6.zzc(r8)
            if (r9 != 0) goto L_0x004a
            java.lang.String r9 = "adUnitId"
        L_0x004a:
            r0.zzs(r9)
            if (r12 != 0) goto L_0x0058
            com.google.android.gms.ads.internal.client.zzm r9 = new com.google.android.gms.ads.internal.client.zzm
            r9.<init>()
            com.google.android.gms.ads.internal.client.zzl r12 = r9.zza()
        L_0x0058:
            r0.zzE(r12)
            r9 = 1
            if (r11 != 0) goto L_0x00c2
            com.google.android.gms.internal.ads.zzbiu r11 = com.google.android.gms.internal.ads.zzbjc.zzgC
            com.google.android.gms.internal.ads.zzbja r12 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r11 = r12.zzb(r11)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 != 0) goto L_0x0076
            com.google.android.gms.ads.internal.client.zzq r11 = new com.google.android.gms.ads.internal.client.zzq
            r11.<init>()
            goto L_0x00c2
        L_0x0076:
            int r11 = r10.hashCode()
            switch(r11) {
                case -1999289321: goto L_0x0098;
                case 543046670: goto L_0x0090;
                case 1854800829: goto L_0x0088;
                case 1951953708: goto L_0x007e;
                default: goto L_0x007d;
            }
        L_0x007d:
            goto L_0x00a2
        L_0x007e:
            java.lang.String r11 = "BANNER"
            boolean r11 = r10.equals(r11)
            if (r11 == 0) goto L_0x00a2
            r11 = 0
            goto L_0x00a3
        L_0x0088:
            boolean r11 = r10.equals(r2)
            if (r11 == 0) goto L_0x00a2
            r11 = r5
            goto L_0x00a3
        L_0x0090:
            boolean r11 = r10.equals(r3)
            if (r11 == 0) goto L_0x00a2
            r11 = r9
            goto L_0x00a3
        L_0x0098:
            java.lang.String r11 = "NATIVE"
            boolean r11 = r10.equals(r11)
            if (r11 == 0) goto L_0x00a2
            r11 = r4
            goto L_0x00a3
        L_0x00a2:
            r11 = -1
        L_0x00a3:
            if (r11 == 0) goto L_0x00bb
            if (r11 == r9) goto L_0x00b6
            if (r11 == r5) goto L_0x00b6
            if (r11 == r4) goto L_0x00b1
            com.google.android.gms.ads.internal.client.zzq r11 = new com.google.android.gms.ads.internal.client.zzq
            r11.<init>()
            goto L_0x00c2
        L_0x00b1:
            com.google.android.gms.ads.internal.client.zzq r11 = com.google.android.gms.ads.internal.client.zzq.zzc()
            goto L_0x00c2
        L_0x00b6:
            com.google.android.gms.ads.internal.client.zzq r11 = com.google.android.gms.ads.internal.client.zzq.zzd()
            goto L_0x00c2
        L_0x00bb:
            com.google.android.gms.ads.internal.client.zzq r11 = new com.google.android.gms.ads.internal.client.zzq
            com.google.android.gms.ads.AdSize r12 = com.google.android.gms.ads.AdSize.BANNER
            r11.<init>((android.content.Context) r8, (com.google.android.gms.ads.AdSize) r12)
        L_0x00c2:
            r0.zzr(r11)
            r0.zzx(r9)
            com.google.android.gms.internal.ads.zzfef r8 = r0.zzG()
            r6.zzf(r8)
            com.google.android.gms.internal.ads.zzdcm r8 = r6.zzg()
            r1.zza(r8)
            com.google.android.gms.ads.nonagon.signalgeneration.zzac r8 = new com.google.android.gms.ads.nonagon.signalgeneration.zzac
            r8.<init>()
            r8.zza(r10)
            com.google.android.gms.ads.nonagon.signalgeneration.zzae r9 = new com.google.android.gms.ads.nonagon.signalgeneration.zzae
            r10 = 0
            r9.<init>(r8, r10)
            r1.zzb(r9)
            com.google.android.gms.internal.ads.zzdik r8 = new com.google.android.gms.internal.ads.zzdik
            r8.<init>()
            com.google.android.gms.ads.nonagon.signalgeneration.zzh r8 = r1.zzc()
            com.google.android.gms.internal.ads.zzdxl r9 = r8.zza()
            r7.zzj = r9
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzQ(android.content.Context, java.lang.String, java.lang.String, com.google.android.gms.ads.internal.client.zzq, com.google.android.gms.ads.internal.client.zzl):com.google.android.gms.ads.nonagon.signalgeneration.zzh");
    }

    private final zzfzp zzR(String str) {
        zzdtn[] zzdtnArr = new zzdtn[1];
        zzfzp zzn2 = zzfzg.zzn(this.zzi.zza(), new zzk(this, zzdtnArr, str), this.zzk);
        zzn2.zzc(new zzl(this, zzdtnArr), this.zzk);
        return zzfzg.zzf(zzfzg.zzm((zzfyx) zzfzg.zzo(zzfyx.zzv(zzn2), (long) ((Integer) zzay.zzc().zzb(zzbjc.zzgG)).intValue(), TimeUnit.MILLISECONDS, this.zzl), zzv.zza, this.zzk), Exception.class, zzj.zza, this.zzk);
    }

    private final void zzS(List list, IObjectWrapper iObjectWrapper, zzbzr zzbzr, boolean z) {
        zzfzp zzfzp;
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzgF)).booleanValue()) {
            zze.zzj("The updating URL feature is not enabled.");
            try {
                zzbzr.zze("The updating URL feature is not enabled.");
            } catch (RemoteException e) {
                zzcgp.zzh("", e);
            }
        } else {
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (zzN((Uri) it.next())) {
                    i++;
                }
            }
            if (i > 1) {
                zze.zzj("Multiple google urls found: ".concat(String.valueOf(String.valueOf(list))));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Uri uri = (Uri) it2.next();
                if (!zzN(uri)) {
                    zze.zzj("Not a Google URL: ".concat(String.valueOf(String.valueOf(uri))));
                    zzfzp = zzfzg.zzi(uri);
                } else {
                    zzfzp = this.zzk.zzb(new zzq(this, uri, iObjectWrapper));
                    if (zzV()) {
                        zzfzp = zzfzg.zzn(zzfzp, new zzr(this), this.zzk);
                    } else {
                        zze.zzi("Asset view map is empty.");
                    }
                }
                arrayList.add(zzfzp);
            }
            zzfzg.zzr(zzfzg.zze(arrayList), new zzy(this, zzbzr, z), this.zzf.zzA());
        }
    }

    private final void zzT(List list, IObjectWrapper iObjectWrapper, zzbzr zzbzr, boolean z) {
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzgF)).booleanValue()) {
            try {
                zzbzr.zze("The updating URL feature is not enabled.");
            } catch (RemoteException e) {
                zzcgp.zzh("", e);
            }
        } else {
            zzfzp zzb2 = this.zzk.zzb(new zzs(this, list, iObjectWrapper));
            if (zzV()) {
                zzb2 = zzfzg.zzn(zzb2, new zzt(this), this.zzk);
            } else {
                zze.zzi("Asset view map is empty.");
            }
            zzfzg.zzr(zzb2, new zzx(this, zzbzr, z), this.zzf.zzA());
        }
    }

    private static boolean zzU(Uri uri, List list, List list2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (!(host == null || path == null)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (path.contains((String) it.next())) {
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        if (host.endsWith((String) it2.next())) {
                            return true;
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.zzb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzV() {
        /*
            r1 = this;
            com.google.android.gms.internal.ads.zzcaa r0 = r1.zzm
            if (r0 == 0) goto L_0x0010
            java.util.Map r0 = r0.zzb
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0010
            r0 = 1
            return r0
        L_0x0010:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzV():boolean");
    }

    /* access modifiers changed from: private */
    public static final Uri zzW(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl=");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl=");
        }
        if (indexOf == -1) {
            return uri.buildUpon().appendQueryParameter(str, str2).build();
        }
        int i = indexOf + 1;
        return Uri.parse(uri2.substring(0, i) + str + "=" + str2 + "&" + uri2.substring(i));
    }

    private static final List zzX(String str) {
        String[] split = TextUtils.split(str, ",");
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            if (!zzftm.zzd(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    static /* bridge */ /* synthetic */ zzfju zzr(zzfzp zzfzp, zzcfk zzcfk) {
        String str;
        if (!zzfjw.zza() || !((Boolean) zzbkl.zze.zze()).booleanValue()) {
            return null;
        }
        try {
            zzfju zzb2 = ((zzh) zzfzg.zzp(zzfzp)).zzb();
            zzb2.zzd(new ArrayList(Collections.singletonList(zzcfk.zzb)));
            zzl zzl2 = zzcfk.zzd;
            if (zzl2 == null) {
                str = "";
            } else {
                str = zzl2.zzp;
            }
            zzb2.zzb(str);
            return zzb2;
        } catch (ExecutionException e) {
            zzt.zzo().zzt(e, "SignalGeneratorImpl.getConfiguredCriticalUserJourney");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzB(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (!zzO(uri) || TextUtils.isEmpty(str)) {
                arrayList.add(uri);
            } else {
                arrayList.add(zzW(uri, "nas", str));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzC(List list, IObjectWrapper iObjectWrapper) throws Exception {
        String zzh2 = this.zzh.zzc() != null ? this.zzh.zzc().zzh(this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null) : "";
        if (!TextUtils.isEmpty(zzh2)) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Uri uri = (Uri) it.next();
                if (!zzO(uri)) {
                    zze.zzj("Not a Google URL: ".concat(String.valueOf(String.valueOf(uri))));
                    arrayList.add(uri);
                } else {
                    arrayList.add(zzW(uri, "ms", zzh2));
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
            throw new Exception("Empty impression URLs result.");
        }
        throw new Exception("Failed to get view signals.");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzH(zzdtn[] zzdtnArr) {
        zzdtn zzdtn = zzdtnArr[0];
        if (zzdtn != null) {
            this.zzi.zzb(zzfzg.zzi(zzdtn));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzI(String str, String str2, zzdxl zzdxl) {
        this.zzq.zzd(str, str2, zzdxl);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzN(Uri uri) {
        return zzU(uri, this.zzD, this.zzE);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzO(Uri uri) {
        return zzU(uri, this.zzF, this.zzG);
    }

    public final void zze(IObjectWrapper iObjectWrapper, zzcfk zzcfk, zzcfd zzcfd) {
        zzfzp zzfzp;
        zzfzp zzfzp2;
        zzcfk zzcfk2 = zzcfk;
        this.zzg = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfjj zza2 = zzfji.zza(this.zzg, 22);
        zza2.zzf();
        if (((Boolean) zzay.zzc().zzb(zzbjc.zziH)).booleanValue()) {
            zzfzp zzb2 = zzchc.zza.zzb(new zzo(this, zzcfk));
            zzfzp2 = zzb2;
            zzfzp = zzfzg.zzn(zzb2, zzp.zza, zzchc.zza);
        } else {
            zzh zzQ = zzQ(this.zzg, zzcfk2.zza, zzcfk2.zzb, zzcfk2.zzc, zzcfk2.zzd);
            zzfzp zzi2 = zzfzg.zzi(zzQ);
            zzfzp = zzQ.zzc();
            zzfzp2 = zzi2;
        }
        zzfzg.zzr(zzfzp, new zzw(this, zzfzp2, zzcfk, zzcfd, zza2, zzt.zzB().currentTimeMillis()), this.zzf.zzA());
    }

    public final void zzf(zzcaa zzcaa) {
        this.zzm = zzcaa;
        this.zzi.zzc(1);
    }

    public final void zzg(List list, IObjectWrapper iObjectWrapper, zzbzr zzbzr) {
        zzS(list, iObjectWrapper, zzbzr, true);
    }

    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbzr zzbzr) {
        zzT(list, iObjectWrapper, zzbzr, true);
    }

    public final void zzi(IObjectWrapper iObjectWrapper) {
        zzfzp zzfzp;
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzib)).booleanValue()) {
            if (Build.VERSION.SDK_INT < 21) {
                zze.zzj("Not registering the webview because the Android API level is lower than Lollopop which has security risks on webviews.");
                return;
            }
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzic)).booleanValue()) {
                if (((Boolean) zzay.zzc().zzb(zzbjc.zziH)).booleanValue()) {
                    zzfzp = zzfzg.zzl(new zzu(this), zzchc.zza);
                } else {
                    zzfzp = zzQ(this.zzg, (String) null, AdFormat.BANNER.name(), (zzq) null, (zzl) null).zzc();
                }
                zzfzg.zzr(zzfzp, new zzz(this), this.zzf.zzA());
            }
            WebView webView = (WebView) ObjectWrapper.unwrap(iObjectWrapper);
            if (webView == null) {
                zze.zzg("The webView cannot be null.");
            } else if (this.zzp.contains(webView)) {
                zze.zzi("This webview has already been registered.");
            } else {
                this.zzp.add(webView);
                webView.addJavascriptInterface(new TaggingLibraryJsInterface(webView, this.zzh, this.zzr), "gmaSdk");
            }
        }
    }

    public final void zzj(IObjectWrapper iObjectWrapper) {
        View view;
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzgF)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper);
            zzcaa zzcaa = this.zzm;
            if (zzcaa == null) {
                view = null;
            } else {
                view = zzcaa.zza;
            }
            this.zzn = zzbx.zza(motionEvent, view);
            if (motionEvent.getAction() == 0) {
                this.zzo = this.zzn;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setLocation((float) this.zzn.x, (float) this.zzn.y);
            this.zzh.zzd(obtain);
            obtain.recycle();
        }
    }

    public final void zzk(List list, IObjectWrapper iObjectWrapper, zzbzr zzbzr) {
        zzS(list, iObjectWrapper, zzbzr, false);
    }

    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbzr zzbzr) {
        zzT(list, iObjectWrapper, zzbzr, false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Uri zzm(Uri uri, IObjectWrapper iObjectWrapper) throws Exception {
        try {
            uri = this.zzh.zza(uri, this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null);
        } catch (zzapf e) {
            zzcgp.zzk("", e);
        }
        if (uri.getQueryParameter("ms") != null) {
            return uri;
        }
        throw new Exception("Failed to append spam signals to click url.");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzh zzq(zzcfk zzcfk) throws Exception {
        return zzQ(this.zzg, zzcfk.zza, zzcfk.zzb, zzcfk.zzc, zzcfk.zzd);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzu() throws Exception {
        return zzQ(this.zzg, (String) null, AdFormat.BANNER.name(), (zzq) null, (zzl) null).zzc();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzv(zzdtn[] zzdtnArr, String str, zzdtn zzdtn) throws Exception {
        zzdtnArr[0] = zzdtn;
        Context context = this.zzg;
        zzcaa zzcaa = this.zzm;
        Map map = zzcaa.zzb;
        JSONObject zzd2 = zzbx.zzd(context, map, map, zzcaa.zza);
        JSONObject zzg2 = zzbx.zzg(this.zzg, this.zzm.zza);
        JSONObject zzf2 = zzbx.zzf(this.zzm.zza);
        JSONObject zze2 = zzbx.zze(this.zzg, this.zzm.zza);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("asset_view_signal", zzd2);
        jSONObject.put("ad_view_signal", zzg2);
        jSONObject.put("scroll_view_signal", zzf2);
        jSONObject.put("lock_screen_signal", zze2);
        if ("google.afma.nativeAds.getPublisherCustomRenderedClickSignals".equals(str)) {
            jSONObject.put("click_signal", zzbx.zzc((String) null, this.zzg, this.zzo, this.zzn));
        }
        return zzdtn.zzd(str, jSONObject);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzw(ArrayList arrayList) throws Exception {
        return zzfzg.zzm(zzR("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzn(this, arrayList), this.zzk);
    }
}
