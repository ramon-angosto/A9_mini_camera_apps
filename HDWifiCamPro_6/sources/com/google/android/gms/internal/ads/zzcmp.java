package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public interface zzcmp extends zza, zzdkn, zzcmg, zzbsn, zzcnm, zzcnq, zzbta, zzbbq, zzcnu, zzl, zzcnx, zzcny, zzciy, zzcnz {
    boolean canGoBack();

    void destroy();

    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    int getWidth();

    void goBack();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    void setBackgroundColor(int i);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void zzE(zzcnl zzcnl);

    zzfdk zzF();

    Context zzG();

    View zzH();

    WebView zzI();

    WebViewClient zzJ();

    zzape zzK();

    zzbdd zzL();

    zzblr zzM();

    com.google.android.gms.ads.internal.overlay.zzl zzN();

    com.google.android.gms.ads.internal.overlay.zzl zzO();

    zzcoc zzP();

    zzcoe zzQ();

    zzfdn zzR();

    IObjectWrapper zzS();

    zzfzp zzT();

    String zzU();

    void zzV(zzfdk zzfdk, zzfdn zzfdn);

    void zzW();

    void zzX();

    void zzY(int i);

    void zzZ();

    boolean zzaA(boolean z, int i);

    boolean zzaB();

    boolean zzaC();

    boolean zzaD();

    boolean zzaE();

    void zzaa();

    void zzab(boolean z);

    void zzac();

    void zzad(String str, String str2, String str3);

    void zzae();

    void zzaf(String str, zzbpu zzbpu);

    void zzag();

    void zzah(com.google.android.gms.ads.internal.overlay.zzl zzl);

    void zzai(zzcoe zzcoe);

    void zzaj(zzbdd zzbdd);

    void zzak(boolean z);

    void zzal();

    void zzam(Context context);

    void zzan(boolean z);

    void zzao(zzblp zzblp);

    void zzap(boolean z);

    void zzaq(zzblr zzblr);

    void zzar(IObjectWrapper iObjectWrapper);

    void zzas(int i);

    void zzat(com.google.android.gms.ads.internal.overlay.zzl zzl);

    void zzau(boolean z);

    void zzav(boolean z);

    void zzaw(String str, zzbpu zzbpu);

    void zzax(String str, Predicate predicate);

    boolean zzay();

    boolean zzaz();

    Activity zzk();

    com.google.android.gms.ads.internal.zza zzm();

    zzbjp zzo();

    zzcgv zzp();

    zzcnl zzs();

    void zzv(String str, zzclb zzclb);
}
