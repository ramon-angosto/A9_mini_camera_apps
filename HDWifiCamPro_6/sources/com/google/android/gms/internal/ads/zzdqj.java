package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.zzbx;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzb;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdqj {
    private final zzduy zza;
    private final zzdtn zzb;
    private ViewTreeObserver.OnScrollChangedListener zzc = null;

    public zzdqj(zzduy zzduy, zzdtn zzdtn) {
        this.zza = zzduy;
        this.zzb = zzdtn;
    }

    private static final int zzf(Context context, String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        zzaw.zzb();
        return zzcgi.zzw(context, i);
    }

    public final View zza(View view, WindowManager windowManager) throws zzcna {
        zzcmp zza2 = this.zza.zza(zzq.zzc(), (zzfdk) null, (zzfdn) null);
        View view2 = (View) zza2;
        view2.setVisibility(4);
        view2.setContentDescription("policy_validator");
        zza2.zzaf("/sendMessageToSdk", new zzdqf(this));
        zza2.zzaf("/hideValidatorOverlay", new zzdqg(this, windowManager, view));
        zza2.zzaf("/open", new zzbqf((zzb) null, (zzbxz) null, (zzego) null, (zzdxq) null, (zzfir) null));
        this.zzb.zzj(new WeakReference(zza2), "/loadNativeAdPolicyViolations", new zzdqh(this, view, windowManager));
        this.zzb.zzj(new WeakReference(zza2), "/showValidatorOverlay", zzdqi.zza);
        return view2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzcmp zzcmp, Map map) {
        this.zzb.zzg("sendMessageToNativeJs", map);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(WindowManager windowManager, View view, zzcmp zzcmp, Map map) {
        zze.zze("Hide native ad policy validator overlay.");
        zzcmp.zzH().setVisibility(8);
        if (zzcmp.zzH().getWindowToken() != null) {
            windowManager.removeView(zzcmp.zzH());
        }
        zzcmp.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (this.zzc != null && viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this.zzc);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(Map map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "validatorHtmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.zzb.zzg("sendMessageToNativeJs", hashMap);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(View view, WindowManager windowManager, zzcmp zzcmp, Map map) {
        int i;
        zzcmp.zzP().zzz(new zzdqd(this, map));
        if (map != null) {
            Context context = view.getContext();
            int zzf = zzf(context, (String) map.get("validator_width"), ((Integer) zzay.zzc().zzb(zzbjc.zzgU)).intValue());
            int zzf2 = zzf(context, (String) map.get("validator_height"), ((Integer) zzay.zzc().zzb(zzbjc.zzgV)).intValue());
            int zzf3 = zzf(context, (String) map.get("validator_x"), 0);
            int zzf4 = zzf(context, (String) map.get("validator_y"), 0);
            zzcmp.zzai(zzcoe.zzb(zzf, zzf2));
            try {
                zzcmp.zzI().getSettings().setUseWideViewPort(((Boolean) zzay.zzc().zzb(zzbjc.zzgW)).booleanValue());
                zzcmp.zzI().getSettings().setLoadWithOverviewMode(((Boolean) zzay.zzc().zzb(zzbjc.zzgX)).booleanValue());
            } catch (NullPointerException unused) {
            }
            WindowManager.LayoutParams zzb2 = zzbx.zzb();
            zzb2.x = zzf3;
            zzb2.y = zzf4;
            windowManager.updateViewLayout(zzcmp.zzH(), zzb2);
            String str = (String) map.get("orientation");
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect)) {
                if ("1".equals(str) || "2".equals(str)) {
                    i = rect.bottom;
                } else {
                    i = rect.top;
                }
                this.zzc = new zzdqe(view, zzcmp, str, zzb2, i - zzf4, windowManager);
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnScrollChangedListener(this.zzc);
                }
            }
            String str2 = (String) map.get("overlay_url");
            if (!TextUtils.isEmpty(str2)) {
                zzcmp.loadUrl(str2);
            }
        }
    }
}
