package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzape;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzbjr;
import com.google.android.gms.internal.ads.zzbkb;
import com.google.android.gms.internal.ads.zzbop;
import com.google.android.gms.internal.ads.zzbor;
import com.google.android.gms.internal.ads.zzbpv;
import com.google.android.gms.internal.ads.zzbpx;
import com.google.android.gms.internal.ads.zzbqg;
import com.google.android.gms.internal.ads.zzbqm;
import com.google.android.gms.internal.ads.zzbyg;
import com.google.android.gms.internal.ads.zzbzb;
import com.google.android.gms.internal.ads.zzcdq;
import com.google.android.gms.internal.ads.zzcgv;
import com.google.android.gms.internal.ads.zzcmp;
import com.google.android.gms.internal.ads.zzcnb;
import com.google.android.gms.internal.ads.zzcoc;
import com.google.android.gms.internal.ads.zzcoe;
import com.google.android.gms.internal.ads.zzdkn;
import com.google.android.gms.internal.ads.zzdxq;
import com.google.android.gms.internal.ads.zzego;
import com.google.android.gms.internal.ads.zzegw;
import com.google.android.gms.internal.ads.zzfdk;
import com.google.android.gms.internal.ads.zzfdn;
import com.google.android.gms.internal.ads.zzfir;
import com.google.android.gms.internal.ads.zzfkm;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzl extends zzbzb implements zzad {
    static final int zza = Color.argb(0, 0, 0, 0);
    protected final Activity zzb;
    AdOverlayInfoParcel zzc;
    zzcmp zzd;
    zzh zze;
    zzr zzf;
    boolean zzg = false;
    FrameLayout zzh;
    WebChromeClient.CustomViewCallback zzi;
    boolean zzj = false;
    boolean zzk = false;
    zzg zzl;
    boolean zzm = false;
    int zzn = 1;
    private final Object zzo = new Object();
    private Runnable zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs = false;
    private boolean zzt = false;
    private boolean zzu = true;

    public zzl(Activity activity) {
        this.zzb = activity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.zzo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzG(android.content.res.Configuration r6) {
        /*
            r5 = this;
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r5.zzc
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0010
            com.google.android.gms.ads.internal.zzj r0 = r0.zzo
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.zzb
            if (r0 == 0) goto L_0x0010
            r0 = r1
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            com.google.android.gms.ads.internal.util.zzaa r3 = com.google.android.gms.ads.internal.zzt.zzq()
            android.app.Activity r4 = r5.zzb
            boolean r6 = r3.zze(r4, r6)
            boolean r3 = r5.zzk
            if (r3 == 0) goto L_0x0021
            if (r0 == 0) goto L_0x0031
        L_0x0021:
            if (r6 != 0) goto L_0x0031
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r6 = r5.zzc
            if (r6 == 0) goto L_0x0032
            com.google.android.gms.ads.internal.zzj r6 = r6.zzo
            if (r6 == 0) goto L_0x0032
            boolean r6 = r6.zzg
            if (r6 == 0) goto L_0x0032
            r2 = r1
            goto L_0x0032
        L_0x0031:
            r1 = r2
        L_0x0032:
            android.app.Activity r6 = r5.zzb
            android.view.Window r6 = r6.getWindow()
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzaY
            com.google.android.gms.internal.ads.zzbja r3 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r0 = r3.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x005e
            android.view.View r6 = r6.getDecorView()
            if (r1 == 0) goto L_0x0058
            if (r2 == 0) goto L_0x0055
            r0 = 5894(0x1706, float:8.259E-42)
            goto L_0x005a
        L_0x0055:
            r0 = 5380(0x1504, float:7.539E-42)
            goto L_0x005a
        L_0x0058:
            r0 = 256(0x100, float:3.59E-43)
        L_0x005a:
            r6.setSystemUiVisibility(r0)
            return
        L_0x005e:
            r0 = 1024(0x400, float:1.435E-42)
            r3 = 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0076
            r6.addFlags(r0)
            r6.clearFlags(r3)
            if (r2 == 0) goto L_0x0075
            android.view.View r6 = r6.getDecorView()
            r0 = 4098(0x1002, float:5.743E-42)
            r6.setSystemUiVisibility(r0)
        L_0x0075:
            return
        L_0x0076:
            r6.addFlags(r3)
            r6.clearFlags(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzl.zzG(android.content.res.Configuration):void");
    }

    private static final void zzH(IObjectWrapper iObjectWrapper, View view) {
        if (iObjectWrapper != null && view != null) {
            zzt.zzA().zzc(iObjectWrapper, view);
        }
    }

    public final void zzA(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.zzh = new FrameLayout(this.zzb);
        this.zzh.setBackgroundColor(-16777216);
        this.zzh.addView(view, -1, -1);
        this.zzb.setContentView(this.zzh);
        this.zzr = true;
        this.zzi = customViewCallback;
        this.zzg = true;
    }

    /* access modifiers changed from: protected */
    public final void zzB(boolean z) throws zzf {
        if (!this.zzr) {
            this.zzb.requestWindowFeature(1);
        }
        Window window = this.zzb.getWindow();
        if (window != null) {
            zzcmp zzcmp = this.zzc.zzd;
            zzb zzb2 = null;
            zzcoc zzP = zzcmp != null ? zzcmp.zzP() : null;
            boolean z2 = false;
            boolean z3 = zzP != null && zzP.zzJ();
            this.zzm = false;
            if (z3) {
                int i = this.zzc.zzj;
                if (i == 6) {
                    if (this.zzb.getResources().getConfiguration().orientation == 1) {
                        z2 = true;
                    }
                    this.zzm = z2;
                } else if (i == 7) {
                    if (this.zzb.getResources().getConfiguration().orientation == 2) {
                        z2 = true;
                    }
                    this.zzm = z2;
                }
            }
            zze.zze("Delay onShow to next orientation change: " + z2);
            zzy(this.zzc.zzj);
            window.setFlags(16777216, 16777216);
            zze.zze("Hardware acceleration on the AdActivity window enabled.");
            if (!this.zzk) {
                this.zzl.setBackgroundColor(-16777216);
            } else {
                this.zzl.setBackgroundColor(zza);
            }
            this.zzb.setContentView(this.zzl);
            this.zzr = true;
            if (z) {
                try {
                    zzt.zzz();
                    Activity activity = this.zzb;
                    zzcmp zzcmp2 = this.zzc.zzd;
                    zzcoe zzQ = zzcmp2 != null ? zzcmp2.zzQ() : null;
                    zzcmp zzcmp3 = this.zzc.zzd;
                    String zzU = zzcmp3 != null ? zzcmp3.zzU() : null;
                    AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
                    zzcgv zzcgv = adOverlayInfoParcel.zzm;
                    zzcmp zzcmp4 = adOverlayInfoParcel.zzd;
                    this.zzd = zzcnb.zza(activity, zzQ, zzU, true, z3, (zzape) null, (zzbkb) null, zzcgv, (zzbjr) null, (com.google.android.gms.ads.internal.zzl) null, zzcmp4 != null ? zzcmp4.zzm() : null, zzbep.zza(), (zzfdk) null, (zzfdn) null);
                    zzcoc zzP2 = this.zzd.zzP();
                    AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
                    zzbop zzbop = adOverlayInfoParcel2.zzp;
                    zzbor zzbor = adOverlayInfoParcel2.zze;
                    zzz zzz = adOverlayInfoParcel2.zzi;
                    zzcmp zzcmp5 = adOverlayInfoParcel2.zzd;
                    if (zzcmp5 != null) {
                        zzb2 = zzcmp5.zzP().zzd();
                    }
                    zzP2.zzL((zza) null, zzbop, (zzo) null, zzbor, zzz, true, (zzbpx) null, zzb2, (zzbyg) null, (zzcdq) null, (zzego) null, (zzfkm) null, (zzdxq) null, (zzfir) null, (zzbpv) null, (zzdkn) null, (zzbqm) null, (zzbqg) null);
                    this.zzd.zzP().zzz(new zzd(this));
                    AdOverlayInfoParcel adOverlayInfoParcel3 = this.zzc;
                    String str = adOverlayInfoParcel3.zzl;
                    if (str != null) {
                        this.zzd.loadUrl(str);
                    } else {
                        String str2 = adOverlayInfoParcel3.zzh;
                        if (str2 != null) {
                            this.zzd.loadDataWithBaseURL(adOverlayInfoParcel3.zzf, str2, "text/html", "UTF-8", (String) null);
                        } else {
                            throw new zzf("No URL or HTML to display in ad overlay.");
                        }
                    }
                    zzcmp zzcmp6 = this.zzc.zzd;
                    if (zzcmp6 != null) {
                        zzcmp6.zzat(this);
                    }
                } catch (Exception e) {
                    zze.zzh("Error obtaining webview.", e);
                    throw new zzf("Could not obtain webview for the overlay.", e);
                }
            } else {
                this.zzd = this.zzc.zzd;
                this.zzd.zzam(this.zzb);
            }
            this.zzd.zzah(this);
            zzcmp zzcmp7 = this.zzc.zzd;
            if (zzcmp7 != null) {
                zzH(zzcmp7.zzS(), this.zzl);
            }
            if (this.zzc.zzk != 5) {
                ViewParent parent = this.zzd.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(this.zzd.zzH());
                }
                if (this.zzk) {
                    this.zzd.zzal();
                }
                this.zzl.addView(this.zzd.zzH(), -1, -1);
            }
            if (!z && !this.zzm) {
                zze();
            }
            AdOverlayInfoParcel adOverlayInfoParcel4 = this.zzc;
            if (adOverlayInfoParcel4.zzk != 5) {
                zzu(z3);
                if (this.zzd.zzay()) {
                    zzw(z3, true);
                    return;
                }
                return;
            }
            zzegw.zzh(this.zzb, this, adOverlayInfoParcel4.zzu, adOverlayInfoParcel4.zzr, adOverlayInfoParcel4.zzs, adOverlayInfoParcel4.zzt, adOverlayInfoParcel4.zzq, adOverlayInfoParcel4.zzv);
            return;
        }
        throw new zzf("Invalid activity, no window available.");
    }

    public final void zzC() {
        synchronized (this.zzo) {
            this.zzq = true;
            if (this.zzp != null) {
                zzs.zza.removeCallbacks(this.zzp);
                zzs.zza.post(this.zzp);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzD() {
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzo zzo2;
        if (this.zzb.isFinishing() && !this.zzs) {
            this.zzs = true;
            zzcmp zzcmp = this.zzd;
            if (zzcmp != null) {
                zzcmp.zzY(this.zzn - 1);
                synchronized (this.zzo) {
                    if (!this.zzq && this.zzd.zzaz()) {
                        if (((Boolean) zzay.zzc().zzb(zzbjc.zzdV)).booleanValue() && !this.zzt && (adOverlayInfoParcel = this.zzc) != null && (zzo2 = adOverlayInfoParcel.zzc) != null) {
                            zzo2.zzbC();
                        }
                        this.zzp = new zze(this);
                        zzs.zza.postDelayed(this.zzp, ((Long) zzay.zzc().zzb(zzbjc.zzaR)).longValue());
                        return;
                    }
                }
            }
            zzc();
        }
    }

    public final boolean zzE() {
        this.zzn = 1;
        if (this.zzd == null) {
            return true;
        }
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzhE)).booleanValue() || !this.zzd.canGoBack()) {
            boolean zzaE = this.zzd.zzaE();
            if (!zzaE) {
                this.zzd.zzd("onbackblocked", Collections.emptyMap());
            }
            return zzaE;
        }
        this.zzd.goBack();
        return false;
    }

    public final void zzb() {
        this.zzn = 3;
        this.zzb.finish();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && adOverlayInfoParcel.zzk == 5) {
            this.zzb.overridePendingTransition(0, 0);
        }
    }

    public final void zzbJ() {
        this.zzn = 2;
        this.zzb.finish();
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        zzcmp zzcmp;
        zzo zzo2;
        if (!this.zzt) {
            this.zzt = true;
            zzcmp zzcmp2 = this.zzd;
            if (zzcmp2 != null) {
                this.zzl.removeView(zzcmp2.zzH());
                zzh zzh2 = this.zze;
                if (zzh2 != null) {
                    this.zzd.zzam(zzh2.zzd);
                    this.zzd.zzap(false);
                    ViewGroup viewGroup = this.zze.zzc;
                    View zzH = this.zzd.zzH();
                    zzh zzh3 = this.zze;
                    viewGroup.addView(zzH, zzh3.zza, zzh3.zzb);
                    this.zze = null;
                } else if (this.zzb.getApplicationContext() != null) {
                    this.zzd.zzam(this.zzb.getApplicationContext());
                }
                this.zzd = null;
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
            if (!(adOverlayInfoParcel == null || (zzo2 = adOverlayInfoParcel.zzc) == null)) {
                zzo2.zzf(this.zzn);
            }
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
            if (adOverlayInfoParcel2 != null && (zzcmp = adOverlayInfoParcel2.zzd) != null) {
                zzH(zzcmp.zzS(), this.zzc.zzd.zzH());
            }
        }
    }

    public final void zzd() {
        this.zzl.zzb = true;
    }

    /* access modifiers changed from: protected */
    public final void zze() {
        this.zzd.zzZ();
    }

    public final void zzf() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && this.zzg) {
            zzy(adOverlayInfoParcel.zzj);
        }
        if (this.zzh != null) {
            this.zzb.setContentView(this.zzl);
            this.zzr = true;
            this.zzh.removeAllViews();
            this.zzh = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzi;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzi = null;
        }
        this.zzg = false;
    }

    public final void zzg(int i, int i2, Intent intent) {
    }

    public final void zzh() {
        this.zzn = 1;
    }

    public final void zzj(IObjectWrapper iObjectWrapper) {
        zzG((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0073 A[Catch:{ zzf -> 0x00f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c8 A[Catch:{ zzf -> 0x00f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ed A[Catch:{ zzf -> 0x00f9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzk(android.os.Bundle r9) {
        /*
            r8 = this;
            android.app.Activity r0 = r8.zzb
            r1 = 1
            r0.requestWindowFeature(r1)
            r0 = 0
            if (r9 == 0) goto L_0x0013
            java.lang.String r2 = "com.google.android.gms.ads.internal.overlay.hasResumed"
            boolean r2 = r9.getBoolean(r2, r0)
            if (r2 == 0) goto L_0x0013
            r2 = r1
            goto L_0x0014
        L_0x0013:
            r2 = r0
        L_0x0014:
            r8.zzj = r2
            r2 = 4
            android.app.Activity r3 = r8.zzb     // Catch:{ zzf -> 0x00f9 }
            android.content.Intent r3 = r3.getIntent()     // Catch:{ zzf -> 0x00f9 }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel.zza(r3)     // Catch:{ zzf -> 0x00f9 }
            r8.zzc = r3     // Catch:{ zzf -> 0x00f9 }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r8.zzc     // Catch:{ zzf -> 0x00f9 }
            if (r3 == 0) goto L_0x00f1
            com.google.android.gms.internal.ads.zzcgv r3 = r3.zzm     // Catch:{ zzf -> 0x00f9 }
            int r3 = r3.zzc     // Catch:{ zzf -> 0x00f9 }
            r4 = 7500000(0x7270e0, float:1.0509738E-38)
            if (r3 <= r4) goto L_0x0032
            r8.zzn = r2     // Catch:{ zzf -> 0x00f9 }
        L_0x0032:
            android.app.Activity r3 = r8.zzb     // Catch:{ zzf -> 0x00f9 }
            android.content.Intent r3 = r3.getIntent()     // Catch:{ zzf -> 0x00f9 }
            if (r3 == 0) goto L_0x0048
            android.app.Activity r3 = r8.zzb     // Catch:{ zzf -> 0x00f9 }
            android.content.Intent r3 = r3.getIntent()     // Catch:{ zzf -> 0x00f9 }
            java.lang.String r4 = "shouldCallOnOverlayOpened"
            boolean r3 = r3.getBooleanExtra(r4, r1)     // Catch:{ zzf -> 0x00f9 }
            r8.zzu = r3     // Catch:{ zzf -> 0x00f9 }
        L_0x0048:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r8.zzc     // Catch:{ zzf -> 0x00f9 }
            com.google.android.gms.ads.internal.zzj r4 = r3.zzo     // Catch:{ zzf -> 0x00f9 }
            r5 = 5
            if (r4 == 0) goto L_0x0056
            boolean r6 = r4.zza     // Catch:{ zzf -> 0x00f9 }
            r8.zzk = r6     // Catch:{ zzf -> 0x00f9 }
            if (r6 == 0) goto L_0x0071
            goto L_0x005c
        L_0x0056:
            int r6 = r3.zzk     // Catch:{ zzf -> 0x00f9 }
            if (r6 != r5) goto L_0x006f
            r8.zzk = r1     // Catch:{ zzf -> 0x00f9 }
        L_0x005c:
            int r3 = r3.zzk     // Catch:{ zzf -> 0x00f9 }
            if (r3 == r5) goto L_0x0071
            int r3 = r4.zzf     // Catch:{ zzf -> 0x00f9 }
            r4 = -1
            if (r3 == r4) goto L_0x0071
            com.google.android.gms.ads.internal.overlay.zzk r3 = new com.google.android.gms.ads.internal.overlay.zzk     // Catch:{ zzf -> 0x00f9 }
            r4 = 0
            r3.<init>(r8, r4)     // Catch:{ zzf -> 0x00f9 }
            r3.zzb()     // Catch:{ zzf -> 0x00f9 }
            goto L_0x0071
        L_0x006f:
            r8.zzk = r0     // Catch:{ zzf -> 0x00f9 }
        L_0x0071:
            if (r9 != 0) goto L_0x009f
            boolean r9 = r8.zzu     // Catch:{ zzf -> 0x00f9 }
            if (r9 == 0) goto L_0x0089
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzf -> 0x00f9 }
            com.google.android.gms.internal.ads.zzddn r9 = r9.zzx     // Catch:{ zzf -> 0x00f9 }
            if (r9 == 0) goto L_0x0080
            r9.zze()     // Catch:{ zzf -> 0x00f9 }
        L_0x0080:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzf -> 0x00f9 }
            com.google.android.gms.ads.internal.overlay.zzo r9 = r9.zzc     // Catch:{ zzf -> 0x00f9 }
            if (r9 == 0) goto L_0x0089
            r9.zzb()     // Catch:{ zzf -> 0x00f9 }
        L_0x0089:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzf -> 0x00f9 }
            int r3 = r9.zzk     // Catch:{ zzf -> 0x00f9 }
            if (r3 == r1) goto L_0x009f
            com.google.android.gms.ads.internal.client.zza r9 = r9.zzb     // Catch:{ zzf -> 0x00f9 }
            if (r9 == 0) goto L_0x0096
            r9.onAdClicked()     // Catch:{ zzf -> 0x00f9 }
        L_0x0096:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzf -> 0x00f9 }
            com.google.android.gms.internal.ads.zzdkn r9 = r9.zzy     // Catch:{ zzf -> 0x00f9 }
            if (r9 == 0) goto L_0x009f
            r9.zzq()     // Catch:{ zzf -> 0x00f9 }
        L_0x009f:
            com.google.android.gms.ads.internal.overlay.zzg r9 = new com.google.android.gms.ads.internal.overlay.zzg     // Catch:{ zzf -> 0x00f9 }
            android.app.Activity r3 = r8.zzb     // Catch:{ zzf -> 0x00f9 }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r4 = r8.zzc     // Catch:{ zzf -> 0x00f9 }
            java.lang.String r6 = r4.zzn     // Catch:{ zzf -> 0x00f9 }
            com.google.android.gms.internal.ads.zzcgv r7 = r4.zzm     // Catch:{ zzf -> 0x00f9 }
            java.lang.String r7 = r7.zza     // Catch:{ zzf -> 0x00f9 }
            java.lang.String r4 = r4.zzw     // Catch:{ zzf -> 0x00f9 }
            r9.<init>(r3, r6, r7, r4)     // Catch:{ zzf -> 0x00f9 }
            r8.zzl = r9     // Catch:{ zzf -> 0x00f9 }
            com.google.android.gms.ads.internal.overlay.zzg r9 = r8.zzl     // Catch:{ zzf -> 0x00f9 }
            r3 = 1000(0x3e8, float:1.401E-42)
            r9.setId(r3)     // Catch:{ zzf -> 0x00f9 }
            com.google.android.gms.ads.internal.util.zzaa r9 = com.google.android.gms.ads.internal.zzt.zzq()     // Catch:{ zzf -> 0x00f9 }
            android.app.Activity r3 = r8.zzb     // Catch:{ zzf -> 0x00f9 }
            r9.zzj(r3)     // Catch:{ zzf -> 0x00f9 }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r9 = r8.zzc     // Catch:{ zzf -> 0x00f9 }
            int r3 = r9.zzk     // Catch:{ zzf -> 0x00f9 }
            if (r3 == r1) goto L_0x00ed
            r4 = 2
            if (r3 == r4) goto L_0x00e0
            r9 = 3
            if (r3 == r9) goto L_0x00dc
            if (r3 != r5) goto L_0x00d4
            r8.zzB(r0)     // Catch:{ zzf -> 0x00f9 }
            return
        L_0x00d4:
            com.google.android.gms.ads.internal.overlay.zzf r9 = new com.google.android.gms.ads.internal.overlay.zzf     // Catch:{ zzf -> 0x00f9 }
            java.lang.String r0 = "Could not determine ad overlay type."
            r9.<init>(r0)     // Catch:{ zzf -> 0x00f9 }
            throw r9     // Catch:{ zzf -> 0x00f9 }
        L_0x00dc:
            r8.zzB(r1)     // Catch:{ zzf -> 0x00f9 }
            return
        L_0x00e0:
            com.google.android.gms.ads.internal.overlay.zzh r1 = new com.google.android.gms.ads.internal.overlay.zzh     // Catch:{ zzf -> 0x00f9 }
            com.google.android.gms.internal.ads.zzcmp r9 = r9.zzd     // Catch:{ zzf -> 0x00f9 }
            r1.<init>(r9)     // Catch:{ zzf -> 0x00f9 }
            r8.zze = r1     // Catch:{ zzf -> 0x00f9 }
            r8.zzB(r0)     // Catch:{ zzf -> 0x00f9 }
            return
        L_0x00ed:
            r8.zzB(r0)     // Catch:{ zzf -> 0x00f9 }
            return
        L_0x00f1:
            com.google.android.gms.ads.internal.overlay.zzf r9 = new com.google.android.gms.ads.internal.overlay.zzf     // Catch:{ zzf -> 0x00f9 }
            java.lang.String r0 = "Could not get info for ad overlay."
            r9.<init>(r0)     // Catch:{ zzf -> 0x00f9 }
            throw r9     // Catch:{ zzf -> 0x00f9 }
        L_0x00f9:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            com.google.android.gms.ads.internal.util.zze.zzj(r9)
            r8.zzn = r2
            android.app.Activity r9 = r8.zzb
            r9.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzl.zzk(android.os.Bundle):void");
    }

    public final void zzl() {
        zzcmp zzcmp = this.zzd;
        if (zzcmp != null) {
            try {
                this.zzl.removeView(zzcmp.zzH());
            } catch (NullPointerException unused) {
            }
        }
        zzD();
    }

    public final void zzm() {
        if (this.zzm) {
            this.zzm = false;
            zze();
        }
    }

    public final void zzn() {
        zzo zzo2;
        zzf();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (!(adOverlayInfoParcel == null || (zzo2 = adOverlayInfoParcel.zzc) == null)) {
            zzo2.zzbr();
        }
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzdX)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzD();
    }

    public final void zzo() {
    }

    public final void zzp() {
        zzo zzo2;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (!(adOverlayInfoParcel == null || (zzo2 = adOverlayInfoParcel.zzc) == null)) {
            zzo2.zzbK();
        }
        zzG(this.zzb.getResources().getConfiguration());
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzdX)).booleanValue()) {
            zzcmp zzcmp = this.zzd;
            if (zzcmp == null || zzcmp.zzaB()) {
                zze.zzj("The webview does not exist. Ignoring action.");
            } else {
                this.zzd.onResume();
            }
        }
    }

    public final void zzq(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzj);
    }

    public final void zzr() {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzdX)).booleanValue()) {
            zzcmp zzcmp = this.zzd;
            if (zzcmp == null || zzcmp.zzaB()) {
                zze.zzj("The webview does not exist. Ignoring action.");
            } else {
                this.zzd.onResume();
            }
        }
    }

    public final void zzs() {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzdX)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzD();
    }

    public final void zzt() {
        zzo zzo2;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzo2 = adOverlayInfoParcel.zzc) != null) {
            zzo2.zze();
        }
    }

    public final void zzu(boolean z) {
        int intValue = ((Integer) zzay.zzc().zzb(zzbjc.zzdZ)).intValue();
        int i = 0;
        boolean z2 = ((Boolean) zzay.zzc().zzb(zzbjc.zzaU)).booleanValue() || z;
        zzq zzq2 = new zzq();
        zzq2.zzd = 50;
        zzq2.zza = true != z2 ? 0 : intValue;
        if (true != z2) {
            i = intValue;
        }
        zzq2.zzb = i;
        zzq2.zzc = intValue;
        this.zzf = new zzr(this.zzb, zzq2, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(true != z2 ? 9 : 11);
        zzw(z, this.zzc.zzg);
        this.zzl.addView(this.zzf, layoutParams);
    }

    public final void zzv() {
        this.zzr = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r0 = (r0 = r6.zzc).zzo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzw(boolean r7, boolean r8) {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzaS
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r6.zzc
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.ads.internal.zzj r0 = r0.zzo
            if (r0 == 0) goto L_0x0022
            boolean r0 = r0.zzh
            if (r0 == 0) goto L_0x0022
            r0 = r1
            goto L_0x0023
        L_0x0022:
            r0 = r2
        L_0x0023:
            com.google.android.gms.internal.ads.zzbiu r3 = com.google.android.gms.internal.ads.zzbjc.zzaT
            com.google.android.gms.internal.ads.zzbja r4 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r3 = r4.zzb(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0043
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r6.zzc
            if (r3 == 0) goto L_0x0043
            com.google.android.gms.ads.internal.zzj r3 = r3.zzo
            if (r3 == 0) goto L_0x0043
            boolean r3 = r3.zzi
            if (r3 == 0) goto L_0x0043
            r3 = r1
            goto L_0x0044
        L_0x0043:
            r3 = r2
        L_0x0044:
            if (r7 == 0) goto L_0x005a
            if (r8 == 0) goto L_0x005a
            if (r0 == 0) goto L_0x005a
            if (r3 != 0) goto L_0x005a
            com.google.android.gms.internal.ads.zzbyf r7 = new com.google.android.gms.internal.ads.zzbyf
            com.google.android.gms.internal.ads.zzcmp r4 = r6.zzd
            java.lang.String r5 = "useCustomClose"
            r7.<init>(r4, r5)
            java.lang.String r4 = "Custom close has been disabled for interstitial ads in this ad slot."
            r7.zzg(r4)
        L_0x005a:
            com.google.android.gms.ads.internal.overlay.zzr r7 = r6.zzf
            if (r7 == 0) goto L_0x0069
            if (r3 != 0) goto L_0x0066
            if (r8 == 0) goto L_0x0065
            if (r0 != 0) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            r1 = r2
        L_0x0066:
            r7.zzb(r1)
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzl.zzw(boolean, boolean):void");
    }

    public final void zzx() {
        this.zzl.removeView(this.zzf);
        zzu(true);
    }

    public final void zzy(int i) {
        if (this.zzb.getApplicationInfo().targetSdkVersion >= ((Integer) zzay.zzc().zzb(zzbjc.zzfb)).intValue()) {
            if (this.zzb.getApplicationInfo().targetSdkVersion <= ((Integer) zzay.zzc().zzb(zzbjc.zzfc)).intValue()) {
                if (Build.VERSION.SDK_INT >= ((Integer) zzay.zzc().zzb(zzbjc.zzfd)).intValue()) {
                    if (Build.VERSION.SDK_INT <= ((Integer) zzay.zzc().zzb(zzbjc.zzfe)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.zzb.setRequestedOrientation(i);
        } catch (Throwable th) {
            zzt.zzo().zzs(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zzz(boolean z) {
        if (z) {
            this.zzl.setBackgroundColor(0);
        } else {
            this.zzl.setBackgroundColor(-16777216);
        }
    }
}
