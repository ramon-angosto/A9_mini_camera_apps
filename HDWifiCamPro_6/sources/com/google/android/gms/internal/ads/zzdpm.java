package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdpm extends zzbmh implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzdql {
    public static final zzfvn zza = zzfvn.zzr("2011", "1009", "3010");
    private final String zzb;
    private Map zzc = new HashMap();
    private FrameLayout zzd;
    private FrameLayout zze;
    private final zzfzq zzf;
    private View zzg;
    private final int zzh;
    private zzdol zzi;
    private zzbbr zzj;
    private IObjectWrapper zzk = null;
    private zzbmb zzl;
    private boolean zzm;
    private boolean zzn = false;

    public zzdpm(FrameLayout frameLayout, FrameLayout frameLayout2, int i) {
        this.zzd = frameLayout;
        this.zze = frameLayout2;
        this.zzh = 223104000;
        String canonicalName = frameLayout.getClass().getCanonicalName();
        String str = "3012";
        if ("com.google.android.gms.ads.formats.NativeContentAdView".equals(canonicalName)) {
            str = "1007";
        } else if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(canonicalName)) {
            str = "2009";
        } else {
            boolean equals = "com.google.android.gms.ads.formats.UnifiedNativeAdView".equals(canonicalName);
        }
        this.zzb = str;
        zzt.zzx();
        zzchp.zza(frameLayout, this);
        zzt.zzx();
        zzchp.zzb(frameLayout, this);
        this.zzf = zzchc.zze;
        this.zzj = new zzbbr(this.zzd.getContext(), this.zzd);
        frameLayout.setOnTouchListener(this);
        frameLayout.setOnClickListener(this);
    }

    private final synchronized void zzs(String str) {
        DisplayMetrics displayMetrics;
        FrameLayout frameLayout = new FrameLayout(this.zze.getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Context context = this.zze.getContext();
        frameLayout.setClickable(false);
        frameLayout.setFocusable(false);
        if (!TextUtils.isEmpty(str)) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            Resources resources = context.getResources();
            if (!(resources == null || (displayMetrics = resources.getDisplayMetrics()) == null)) {
                try {
                    byte[] decode = Base64.decode(str, 0);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeByteArray(decode, 0, decode.length));
                    bitmapDrawable.setTargetDensity(displayMetrics.densityDpi);
                    bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                    frameLayout.setBackground(bitmapDrawable);
                } catch (IllegalArgumentException e) {
                    zzcgp.zzk("Encountered invalid base64 watermark.", e);
                }
            }
        }
        this.zze.addView(frameLayout);
    }

    private final synchronized void zzt() {
        this.zzf.execute(new zzdpl(this));
    }

    public final synchronized void onClick(View view) {
        zzdol zzdol = this.zzi;
        if (zzdol != null) {
            zzdol.zzk();
            this.zzi.zzx(view, this.zzd, zzl(), zzm(), false);
        }
    }

    public final synchronized void onGlobalLayout() {
        zzdol zzdol = this.zzi;
        if (zzdol != null) {
            FrameLayout frameLayout = this.zzd;
            zzdol.zzv(frameLayout, zzl(), zzm(), zzdol.zzP(frameLayout));
        }
    }

    public final synchronized void onScrollChanged() {
        zzdol zzdol = this.zzi;
        if (zzdol != null) {
            FrameLayout frameLayout = this.zzd;
            zzdol.zzv(frameLayout, zzl(), zzm(), zzdol.zzP(frameLayout));
        }
    }

    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        zzdol zzdol = this.zzi;
        if (zzdol != null) {
            zzdol.zzD(view, motionEvent, this.zzd);
        }
        return false;
    }

    public final synchronized IObjectWrapper zzb(String str) {
        return ObjectWrapper.wrap(zzg(str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0070, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzbA(com.google.android.gms.dynamic.IObjectWrapper r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.zzn     // Catch:{ all -> 0x0071 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            java.lang.Object r2 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)     // Catch:{ all -> 0x0071 }
            boolean r0 = r2 instanceof com.google.android.gms.internal.ads.zzdol     // Catch:{ all -> 0x0071 }
            if (r0 != 0) goto L_0x0016
            java.lang.String r2 = "Not an instance of native engine. This is most likely a transient error"
            com.google.android.gms.ads.internal.util.zze.zzj(r2)     // Catch:{ all -> 0x0071 }
            monitor-exit(r1)
            return
        L_0x0016:
            com.google.android.gms.internal.ads.zzdol r0 = r1.zzi     // Catch:{ all -> 0x0071 }
            if (r0 == 0) goto L_0x001d
            r0.zzL(r1)     // Catch:{ all -> 0x0071 }
        L_0x001d:
            r1.zzt()     // Catch:{ all -> 0x0071 }
            com.google.android.gms.internal.ads.zzdol r2 = (com.google.android.gms.internal.ads.zzdol) r2     // Catch:{ all -> 0x0071 }
            r1.zzi = r2     // Catch:{ all -> 0x0071 }
            com.google.android.gms.internal.ads.zzdol r2 = r1.zzi     // Catch:{ all -> 0x0071 }
            r2.zzK(r1)     // Catch:{ all -> 0x0071 }
            com.google.android.gms.internal.ads.zzdol r2 = r1.zzi     // Catch:{ all -> 0x0071 }
            android.widget.FrameLayout r0 = r1.zzd     // Catch:{ all -> 0x0071 }
            r2.zzC(r0)     // Catch:{ all -> 0x0071 }
            com.google.android.gms.internal.ads.zzdol r2 = r1.zzi     // Catch:{ all -> 0x0071 }
            android.widget.FrameLayout r0 = r1.zze     // Catch:{ all -> 0x0071 }
            r2.zzi(r0)     // Catch:{ all -> 0x0071 }
            boolean r2 = r1.zzm     // Catch:{ all -> 0x0071 }
            if (r2 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.zzdol r2 = r1.zzi     // Catch:{ all -> 0x0071 }
            com.google.android.gms.internal.ads.zzdon r2 = r2.zza()     // Catch:{ all -> 0x0071 }
            com.google.android.gms.internal.ads.zzbmb r0 = r1.zzl     // Catch:{ all -> 0x0071 }
            r2.zzb(r0)     // Catch:{ all -> 0x0071 }
        L_0x0046:
            com.google.android.gms.internal.ads.zzbiu r2 = com.google.android.gms.internal.ads.zzbjc.zzdc     // Catch:{ all -> 0x0071 }
            com.google.android.gms.internal.ads.zzbja r0 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x0071 }
            java.lang.Object r2 = r0.zzb(r2)     // Catch:{ all -> 0x0071 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x0071 }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x0071 }
            if (r2 == 0) goto L_0x006f
            com.google.android.gms.internal.ads.zzdol r2 = r1.zzi     // Catch:{ all -> 0x0071 }
            java.lang.String r2 = r2.zzd()     // Catch:{ all -> 0x0071 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0071 }
            if (r2 != 0) goto L_0x006f
            com.google.android.gms.internal.ads.zzdol r2 = r1.zzi     // Catch:{ all -> 0x0071 }
            java.lang.String r2 = r2.zzd()     // Catch:{ all -> 0x0071 }
            r1.zzs(r2)     // Catch:{ all -> 0x0071 }
            monitor-exit(r1)
            return
        L_0x006f:
            monitor-exit(r1)
            return
        L_0x0071:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdpm.zzbA(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    public final synchronized void zzbw(String str, IObjectWrapper iObjectWrapper) {
        zzq(str, (View) ObjectWrapper.unwrap(iObjectWrapper), true);
    }

    public final synchronized void zzbx(IObjectWrapper iObjectWrapper) {
        this.zzi.zzF((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final synchronized void zzby(zzbmb zzbmb) {
        if (!this.zzn) {
            this.zzm = true;
            this.zzl = zzbmb;
            zzdol zzdol = this.zzi;
            if (zzdol != null) {
                zzdol.zza().zzb(zzbmb);
            }
        }
    }

    public final synchronized void zzbz(IObjectWrapper iObjectWrapper) {
        if (!this.zzn) {
            this.zzk = iObjectWrapper;
        }
    }

    public final synchronized void zzc() {
        if (!this.zzn) {
            zzdol zzdol = this.zzi;
            if (zzdol != null) {
                zzdol.zzL(this);
                this.zzi = null;
            }
            this.zzc.clear();
            this.zzd.removeAllViews();
            this.zze.removeAllViews();
            this.zzc = null;
            this.zzd = null;
            this.zze = null;
            this.zzg = null;
            this.zzj = null;
            this.zzn = true;
        }
    }

    public final void zzd(IObjectWrapper iObjectWrapper) {
        onTouch(this.zzd, (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper, int i) {
    }

    public final /* synthetic */ View zzf() {
        return this.zzd;
    }

    public final synchronized View zzg(String str) {
        if (this.zzn) {
            return null;
        }
        WeakReference weakReference = (WeakReference) this.zzc.get(str);
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    public final FrameLayout zzh() {
        return this.zze;
    }

    public final zzbbr zzi() {
        return this.zzj;
    }

    public final IObjectWrapper zzj() {
        return this.zzk;
    }

    public final synchronized String zzk() {
        return this.zzb;
    }

    public final synchronized Map zzl() {
        return this.zzc;
    }

    public final synchronized Map zzm() {
        return this.zzc;
    }

    public final synchronized Map zzn() {
        return null;
    }

    public final synchronized JSONObject zzo() {
        zzdol zzdol = this.zzi;
        if (zzdol == null) {
            return null;
        }
        return zzdol.zzf(this.zzd, zzl(), zzm());
    }

    public final synchronized JSONObject zzp() {
        zzdol zzdol = this.zzi;
        if (zzdol == null) {
            return null;
        }
        return zzdol.zzg(this.zzd, zzl(), zzm());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0040, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzq(java.lang.String r2, android.view.View r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r4 = r1.zzn     // Catch:{ all -> 0x0041 }
            if (r4 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            if (r3 != 0) goto L_0x0010
            java.util.Map r3 = r1.zzc     // Catch:{ all -> 0x0041 }
            r3.remove(r2)     // Catch:{ all -> 0x0041 }
            monitor-exit(r1)
            return
        L_0x0010:
            java.util.Map r4 = r1.zzc     // Catch:{ all -> 0x0041 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0041 }
            r0.<init>(r3)     // Catch:{ all -> 0x0041 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0041 }
            java.lang.String r4 = "1098"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0041 }
            if (r4 != 0) goto L_0x003f
            java.lang.String r4 = "3011"
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x002b
            goto L_0x003f
        L_0x002b:
            int r2 = r1.zzh     // Catch:{ all -> 0x0041 }
            boolean r2 = com.google.android.gms.ads.internal.util.zzbx.zzi(r2)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x0036
            r3.setOnTouchListener(r1)     // Catch:{ all -> 0x0041 }
        L_0x0036:
            r2 = 1
            r3.setClickable(r2)     // Catch:{ all -> 0x0041 }
            r3.setOnClickListener(r1)     // Catch:{ all -> 0x0041 }
            monitor-exit(r1)
            return
        L_0x003f:
            monitor-exit(r1)
            return
        L_0x0041:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdpm.zzq(java.lang.String, android.view.View, boolean):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzr() {
        if (this.zzg == null) {
            this.zzg = new View(this.zzd.getContext());
            this.zzg.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        }
        if (this.zzd != this.zzg.getParent()) {
            this.zzd.addView(this.zzg);
        }
    }
}
