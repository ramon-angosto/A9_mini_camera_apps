package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zzab;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcne extends FrameLayout implements zzcmp {
    private final zzcmp zza;
    private final zzcin zzb;
    private final AtomicBoolean zzc = new AtomicBoolean();

    public zzcne(zzcmp zzcmp) {
        super(zzcmp.getContext());
        this.zza = zzcmp;
        this.zzb = new zzcin(zzcmp.zzG(), this, this);
        addView((View) this.zza);
    }

    public final boolean canGoBack() {
        return this.zza.canGoBack();
    }

    public final void destroy() {
        IObjectWrapper zzS = zzS();
        if (zzS != null) {
            zzs.zza.post(new zzcnc(zzS));
            zzfpz zzfpz = zzs.zza;
            zzcmp zzcmp = this.zza;
            zzcmp.getClass();
            zzfpz.postDelayed(new zzcnd(zzcmp), (long) ((Integer) zzay.zzc().zzb(zzbjc.zzeh)).intValue());
            return;
        }
        this.zza.destroy();
    }

    public final void goBack() {
        this.zza.goBack();
    }

    public final void loadData(String str, String str2, String str3) {
        this.zza.loadData(str, "text/html", str3);
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zza.loadDataWithBaseURL(str, str2, "text/html", "UTF-8", (String) null);
    }

    public final void loadUrl(String str) {
        this.zza.loadUrl(str);
    }

    public final void onAdClicked() {
        zzcmp zzcmp = this.zza;
        if (zzcmp != null) {
            zzcmp.onAdClicked();
        }
    }

    public final void onPause() {
        this.zzb.zze();
        this.zza.onPause();
    }

    public final void onResume() {
        this.zza.onResume();
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zza.setOnClickListener(onClickListener);
    }

    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zza.setOnTouchListener(onTouchListener);
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zza.setWebChromeClient(webChromeClient);
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zza.setWebViewClient(webViewClient);
    }

    public final void zzA(int i) {
        this.zza.zzA(i);
    }

    public final void zzB(boolean z) {
        this.zza.zzB(false);
    }

    public final void zzC(int i) {
        this.zza.zzC(i);
    }

    public final void zzD(int i) {
        this.zzb.zzf(i);
    }

    public final void zzE(zzcnl zzcnl) {
        this.zza.zzE(zzcnl);
    }

    public final zzfdk zzF() {
        return this.zza.zzF();
    }

    public final Context zzG() {
        return this.zza.zzG();
    }

    public final View zzH() {
        return this;
    }

    public final WebView zzI() {
        return (WebView) this.zza;
    }

    public final WebViewClient zzJ() {
        return this.zza.zzJ();
    }

    public final zzape zzK() {
        return this.zza.zzK();
    }

    public final zzbdd zzL() {
        return this.zza.zzL();
    }

    public final zzblr zzM() {
        return this.zza.zzM();
    }

    public final zzl zzN() {
        return this.zza.zzN();
    }

    public final zzl zzO() {
        return this.zza.zzO();
    }

    public final zzcoc zzP() {
        return ((zzcni) this.zza).zzaL();
    }

    public final zzcoe zzQ() {
        return this.zza.zzQ();
    }

    public final zzfdn zzR() {
        return this.zza.zzR();
    }

    public final IObjectWrapper zzS() {
        return this.zza.zzS();
    }

    public final zzfzp zzT() {
        return this.zza.zzT();
    }

    public final String zzU() {
        return this.zza.zzU();
    }

    public final void zzV(zzfdk zzfdk, zzfdn zzfdn) {
        this.zza.zzV(zzfdk, zzfdn);
    }

    public final void zzW() {
        this.zzb.zzd();
        this.zza.zzW();
    }

    public final void zzX() {
        this.zza.zzX();
    }

    public final void zzY(int i) {
        this.zza.zzY(i);
    }

    public final void zzZ() {
        this.zza.zzZ();
    }

    public final void zza(String str) {
        ((zzcni) this.zza).zzaQ(str);
    }

    public final boolean zzaA(boolean z, int i) {
        if (!this.zzc.compareAndSet(false, true)) {
            return true;
        }
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzaF)).booleanValue()) {
            return false;
        }
        if (this.zza.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.zza.getParent()).removeView((View) this.zza);
        }
        this.zza.zzaA(z, i);
        return true;
    }

    public final boolean zzaB() {
        return this.zza.zzaB();
    }

    public final boolean zzaC() {
        return this.zza.zzaC();
    }

    public final boolean zzaD() {
        return this.zzc.get();
    }

    public final boolean zzaE() {
        return this.zza.zzaE();
    }

    public final void zzaF(zzc zzc2, boolean z) {
        this.zza.zzaF(zzc2, z);
    }

    public final void zzaG(zzbr zzbr, zzego zzego, zzdxq zzdxq, zzfir zzfir, String str, String str2, int i) {
        this.zza.zzaG(zzbr, zzego, zzdxq, zzfir, str, str2, 14);
    }

    public final void zzaH(boolean z, int i, boolean z2) {
        this.zza.zzaH(z, i, z2);
    }

    public final void zzaI(boolean z, int i, String str, boolean z2) {
        this.zza.zzaI(z, i, str, z2);
    }

    public final void zzaJ(boolean z, int i, String str, String str2, boolean z2) {
        this.zza.zzaJ(z, i, str, str2, z2);
    }

    public final void zzaa() {
        zzcmp zzcmp = this.zza;
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzt.zzr().zze()));
        hashMap.put("app_volume", String.valueOf(zzt.zzr().zza()));
        zzcni zzcni = (zzcni) zzcmp;
        hashMap.put("device_volume", String.valueOf(zzab.zzb(zzcni.getContext())));
        zzcni.zzd("volume", hashMap);
    }

    public final void zzab(boolean z) {
        this.zza.zzab(z);
    }

    public final void zzac() {
        this.zza.zzac();
    }

    public final void zzad(String str, String str2, String str3) {
        this.zza.zzad(str, str2, (String) null);
    }

    public final void zzae() {
        this.zza.zzae();
    }

    public final void zzaf(String str, zzbpu zzbpu) {
        this.zza.zzaf(str, zzbpu);
    }

    public final void zzag() {
        TextView textView = new TextView(getContext());
        zzt.zzp();
        textView.setText(zzs.zzv());
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        textView.setBackground(gradientDrawable);
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }

    public final void zzah(zzl zzl) {
        this.zza.zzah(zzl);
    }

    public final void zzai(zzcoe zzcoe) {
        this.zza.zzai(zzcoe);
    }

    public final void zzaj(zzbdd zzbdd) {
        this.zza.zzaj(zzbdd);
    }

    public final void zzak(boolean z) {
        this.zza.zzak(z);
    }

    public final void zzal() {
        setBackgroundColor(0);
        this.zza.setBackgroundColor(0);
    }

    public final void zzam(Context context) {
        this.zza.zzam(context);
    }

    public final void zzan(boolean z) {
        this.zza.zzan(z);
    }

    public final void zzao(zzblp zzblp) {
        this.zza.zzao(zzblp);
    }

    public final void zzap(boolean z) {
        this.zza.zzap(z);
    }

    public final void zzaq(zzblr zzblr) {
        this.zza.zzaq(zzblr);
    }

    public final void zzar(IObjectWrapper iObjectWrapper) {
        this.zza.zzar(iObjectWrapper);
    }

    public final void zzas(int i) {
        this.zza.zzas(i);
    }

    public final void zzat(zzl zzl) {
        this.zza.zzat(zzl);
    }

    public final void zzau(boolean z) {
        this.zza.zzau(z);
    }

    public final void zzav(boolean z) {
        this.zza.zzav(z);
    }

    public final void zzaw(String str, zzbpu zzbpu) {
        this.zza.zzaw(str, zzbpu);
    }

    public final void zzax(String str, Predicate predicate) {
        this.zza.zzax(str, predicate);
    }

    public final boolean zzay() {
        return this.zza.zzay();
    }

    public final boolean zzaz() {
        return this.zza.zzaz();
    }

    public final void zzb(String str, String str2) {
        this.zza.zzb("window.inspectorInfo", str2);
    }

    public final void zzbn() {
        this.zza.zzbn();
    }

    public final void zzbo() {
        this.zza.zzbo();
    }

    public final zzcin zzbp() {
        return this.zzb;
    }

    public final void zzc(zzbbp zzbbp) {
        this.zza.zzc(zzbbp);
    }

    public final void zzd(String str, Map map) {
        this.zza.zzd(str, map);
    }

    public final void zze(String str, JSONObject jSONObject) {
        this.zza.zze(str, jSONObject);
    }

    public final int zzf() {
        return this.zza.zzf();
    }

    public final int zzg() {
        return this.zza.zzg();
    }

    public final int zzh() {
        return this.zza.zzh();
    }

    public final int zzi() {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzcY)).booleanValue()) {
            return this.zza.getMeasuredHeight();
        }
        return getMeasuredHeight();
    }

    public final int zzj() {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzcY)).booleanValue()) {
            return this.zza.getMeasuredWidth();
        }
        return getMeasuredWidth();
    }

    public final Activity zzk() {
        return this.zza.zzk();
    }

    public final void zzl(String str, JSONObject jSONObject) {
        ((zzcni) this.zza).zzb(str, jSONObject.toString());
    }

    public final zza zzm() {
        return this.zza.zzm();
    }

    public final zzbjo zzn() {
        return this.zza.zzn();
    }

    public final zzbjp zzo() {
        return this.zza.zzo();
    }

    public final zzcgv zzp() {
        return this.zza.zzp();
    }

    public final void zzq() {
        zzcmp zzcmp = this.zza;
        if (zzcmp != null) {
            zzcmp.zzq();
        }
    }

    public final zzclb zzr(String str) {
        return this.zza.zzr(str);
    }

    public final zzcnl zzs() {
        return this.zza.zzs();
    }

    public final String zzt() {
        return this.zza.zzt();
    }

    public final String zzu() {
        return this.zza.zzu();
    }

    public final void zzv(String str, zzclb zzclb) {
        this.zza.zzv(str, zzclb);
    }

    public final void zzw() {
        this.zza.zzw();
    }

    public final void zzx(boolean z, long j) {
        this.zza.zzx(z, j);
    }

    public final void zzy() {
        this.zza.zzy();
    }

    public final void zzz(int i) {
        this.zza.zzz(i);
    }
}
