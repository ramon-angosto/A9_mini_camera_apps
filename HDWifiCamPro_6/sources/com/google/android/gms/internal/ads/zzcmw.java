package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.TrafficStats;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.ViewCompat;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzx;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.Predicate;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzcmw extends WebViewClient implements zzcoc {
    public static final /* synthetic */ int zzb = 0;
    private boolean zzA;
    private final HashSet zzB;
    private View.OnAttachStateChangeListener zzC;
    protected zzcdq zza;
    private final zzcmp zzc;
    private final zzbep zzd;
    private final HashMap zze = new HashMap();
    private final Object zzf = new Object();
    private zza zzg;
    private zzo zzh;
    private zzcoa zzi;
    private zzcob zzj;
    private zzbop zzk;
    private zzbor zzl;
    private zzdkn zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private zzz zzs;
    private zzbye zzt;
    private zzb zzu;
    private zzbxz zzv;
    private zzfkm zzw;
    private boolean zzx;
    private boolean zzy;
    private int zzz;

    public zzcmw(zzcmp zzcmp, zzbep zzbep, boolean z) {
        zzbye zzbye = new zzbye(zzcmp, zzcmp.zzG(), new zzbim(zzcmp.getContext()));
        this.zzd = zzbep;
        this.zzc = zzcmp;
        this.zzp = z;
        this.zzt = zzbye;
        this.zzv = null;
        this.zzB = new HashSet(Arrays.asList(((String) zzay.zzc().zzb(zzbjc.zzeJ)).split(",")));
    }

    private static WebResourceResponse zzM() {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzaD)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    private final WebResourceResponse zzN(String str, Map map) throws IOException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(str);
        try {
            TrafficStats.setThreadStatsTag(264);
            int i = 0;
            while (true) {
                i++;
                if (i <= 20) {
                    URLConnection openConnection = url.openConnection();
                    openConnection.setConnectTimeout(10000);
                    openConnection.setReadTimeout(10000);
                    for (Map.Entry entry : map.entrySet()) {
                        openConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                    if (openConnection instanceof HttpURLConnection) {
                        httpURLConnection = (HttpURLConnection) openConnection;
                        zzt.zzp().zze(this.zzc.getContext(), this.zzc.zzp().zza, false, httpURLConnection, false, 60000);
                        zzcgo zzcgo = new zzcgo((String) null);
                        zzcgo.zzc(httpURLConnection, (byte[]) null);
                        int responseCode = httpURLConnection.getResponseCode();
                        zzcgo.zze(httpURLConnection, responseCode);
                        if (responseCode < 300 || responseCode >= 400) {
                            zzt.zzp();
                            WebResourceResponse zzM = zzs.zzM(httpURLConnection);
                        } else {
                            String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                            if (headerField == null) {
                                throw new IOException("Missing Location header in redirect");
                            } else if (headerField.startsWith("tel:")) {
                                TrafficStats.clearThreadStatsTag();
                                return null;
                            } else {
                                URL url2 = new URL(url, headerField);
                                String protocol = url2.getProtocol();
                                if (protocol == null) {
                                    zze.zzj("Protocol is null");
                                    WebResourceResponse zzM2 = zzM();
                                    TrafficStats.clearThreadStatsTag();
                                    return zzM2;
                                } else if (protocol.equals("http") || protocol.equals("https")) {
                                    zze.zze("Redirecting to " + headerField);
                                    httpURLConnection.disconnect();
                                    url = url2;
                                } else {
                                    zze.zzj("Unsupported scheme: " + protocol);
                                    return zzM();
                                }
                            }
                        }
                    } else {
                        throw new IOException("Invalid protocol.");
                    }
                } else {
                    TrafficStats.clearThreadStatsTag();
                    throw new IOException("Too many redirects (20)");
                }
            }
            zzt.zzp();
            WebResourceResponse zzM3 = zzs.zzM(httpURLConnection);
            TrafficStats.clearThreadStatsTag();
            return zzM3;
        } finally {
            TrafficStats.clearThreadStatsTag();
        }
    }

    /* access modifiers changed from: private */
    public final void zzO(Map map, List list, String str) {
        if (zze.zzc()) {
            zze.zza("Received GMSG: ".concat(str));
            for (String str2 : map.keySet()) {
                zze.zza("  " + str2 + ": " + ((String) map.get(str2)));
            }
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((zzbpu) it.next()).zza(this.zzc, map);
        }
    }

    private final void zzP() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.zzC;
        if (onAttachStateChangeListener != null) {
            ((View) this.zzc).removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
    }

    /* access modifiers changed from: private */
    public final void zzQ(View view, zzcdq zzcdq, int i) {
        if (zzcdq.zzi() && i > 0) {
            zzcdq.zzg(view);
            if (zzcdq.zzi()) {
                zzs.zza.postDelayed(new zzcms(this, view, zzcdq, i), 100);
            }
        }
    }

    private static final boolean zzR(boolean z, zzcmp zzcmp) {
        return z && !zzcmp.zzQ().zzi() && !zzcmp.zzU().equals("interstitial_mb");
    }

    public final void onAdClicked() {
        zza zza2 = this.zzg;
        if (zza2 != null) {
            zza2.onAdClicked();
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        zze.zza("Loading resource: ".concat(String.valueOf(str)));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzi(parse);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r1 == null) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        r1.zza();
        r0.zzj = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        zzg();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r0.zzx = true;
        r1 = r0.zzj;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPageFinished(android.webkit.WebView r1, java.lang.String r2) {
        /*
            r0 = this;
            java.lang.Object r1 = r0.zzf
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzcmp r2 = r0.zzc     // Catch:{ all -> 0x0029 }
            boolean r2 = r2.zzaB()     // Catch:{ all -> 0x0029 }
            if (r2 == 0) goto L_0x0017
            java.lang.String r2 = "Blank page loaded, 1..."
            com.google.android.gms.ads.internal.util.zze.zza(r2)     // Catch:{ all -> 0x0029 }
            com.google.android.gms.internal.ads.zzcmp r2 = r0.zzc     // Catch:{ all -> 0x0029 }
            r2.zzW()     // Catch:{ all -> 0x0029 }
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            return
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            r1 = 1
            r0.zzx = r1
            com.google.android.gms.internal.ads.zzcob r1 = r0.zzj
            if (r1 == 0) goto L_0x0025
            r1.zza()
            r1 = 0
            r0.zzj = r1
        L_0x0025:
            r0.zzg()
            return
        L_0x0029:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcmw.onPageFinished(android.webkit.WebView, java.lang.String):void");
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.zzo = true;
    }

    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzc.zzaA(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzc(str, Collections.emptyMap());
    }

    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case 127:
                    case 128:
                    case TsExtractor.TS_STREAM_TYPE_AC3 /*129*/:
                    case TsExtractor.TS_STREAM_TYPE_HDMV_DTS /*130*/:
                        return true;
                    default:
                        return false;
                }
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        zze.zza("AdWebView shouldOverrideUrlLoading: ".concat(String.valueOf(str)));
        Uri parse = Uri.parse(str);
        if (!"gmsg".equalsIgnoreCase(parse.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            if (this.zzn && webView == this.zzc.zzI()) {
                String scheme = parse.getScheme();
                if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    zza zza2 = this.zzg;
                    if (zza2 != null) {
                        zza2.onAdClicked();
                        zzcdq zzcdq = this.zza;
                        if (zzcdq != null) {
                            zzcdq.zzh(str);
                        }
                        this.zzg = null;
                    }
                    zzdkn zzdkn = this.zzm;
                    if (zzdkn != null) {
                        zzdkn.zzq();
                        this.zzm = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (!this.zzc.zzI().willNotDraw()) {
                try {
                    zzape zzK = this.zzc.zzK();
                    if (zzK != null && zzK.zzf(parse)) {
                        Context context = this.zzc.getContext();
                        zzcmp zzcmp = this.zzc;
                        parse = zzK.zza(parse, context, (View) zzcmp, zzcmp.zzk());
                    }
                } catch (zzapf unused) {
                    zze.zzj("Unable to append parameter to URL: ".concat(String.valueOf(str)));
                }
                zzb zzb2 = this.zzu;
                if (zzb2 == null || zzb2.zzc()) {
                    zzr(new zzc("android.intent.action.VIEW", parse.toString(), (String) null, (String) null, (String) null, (String) null, (String) null, (zzx) null), true);
                } else {
                    this.zzu.zzb(str);
                }
            } else {
                zze.zzj("AdWebView unable to handle URL: ".concat(String.valueOf(str)));
            }
        } else {
            zzi(parse);
        }
        return true;
    }

    public final void zzA(int i, int i2) {
        zzbxz zzbxz = this.zzv;
        if (zzbxz != null) {
            zzbxz.zzd(i, i2);
        }
    }

    public final void zzB(boolean z) {
        this.zzn = false;
    }

    public final void zzC(boolean z) {
        synchronized (this.zzf) {
            this.zzr = z;
        }
    }

    public final void zzD() {
        synchronized (this.zzf) {
            this.zzn = false;
            this.zzp = true;
            zzchc.zze.execute(new zzcmr(this));
        }
    }

    public final void zzE(boolean z) {
        synchronized (this.zzf) {
            this.zzq = true;
        }
    }

    public final void zzF(zzcob zzcob) {
        this.zzj = zzcob;
    }

    public final void zzG(String str, zzbpu zzbpu) {
        synchronized (this.zzf) {
            List list = (List) this.zze.get(str);
            if (list != null) {
                list.remove(zzbpu);
            }
        }
    }

    public final void zzH(String str, Predicate predicate) {
        synchronized (this.zzf) {
            List<zzbpu> list = (List) this.zze.get(str);
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (zzbpu zzbpu : list) {
                    if (predicate.apply(zzbpu)) {
                        arrayList.add(zzbpu);
                    }
                }
                list.removeAll(arrayList);
            }
        }
    }

    public final boolean zzI() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzr;
        }
        return z;
    }

    public final boolean zzJ() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzp;
        }
        return z;
    }

    public final boolean zzK() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzq;
        }
        return z;
    }

    public final void zzL(zza zza2, zzbop zzbop, zzo zzo2, zzbor zzbor, zzz zzz2, boolean z, zzbpx zzbpx, zzb zzb2, zzbyg zzbyg, zzcdq zzcdq, zzego zzego, zzfkm zzfkm, zzdxq zzdxq, zzfir zzfir, zzbpv zzbpv, zzdkn zzdkn, zzbqm zzbqm, zzbqg zzbqg) {
        zzbop zzbop2 = zzbop;
        zzbor zzbor2 = zzbor;
        zzbpx zzbpx2 = zzbpx;
        zzbyg zzbyg2 = zzbyg;
        zzcdq zzcdq2 = zzcdq;
        zzego zzego2 = zzego;
        zzfkm zzfkm2 = zzfkm;
        zzbpv zzbpv2 = zzbpv;
        zzdkn zzdkn2 = zzdkn;
        zzbqm zzbqm2 = zzbqm;
        zzbqg zzbqg2 = zzbqg;
        zzb zzb3 = zzb2 == null ? new zzb(this.zzc.getContext(), zzcdq2, (zzcaq) null) : zzb2;
        this.zzv = new zzbxz(this.zzc, zzbyg2);
        this.zza = zzcdq2;
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzaL)).booleanValue()) {
            zzx("/adMetadata", new zzboo(zzbop2));
        }
        if (zzbor2 != null) {
            zzx("/appEvent", new zzboq(zzbor2));
        }
        zzx("/backButton", zzbpt.zzj);
        zzx("/refresh", zzbpt.zzk);
        zzx("/canOpenApp", zzbpt.zzb);
        zzx("/canOpenURLs", zzbpt.zza);
        zzx("/canOpenIntents", zzbpt.zzc);
        zzx("/close", zzbpt.zzd);
        zzx("/customClose", zzbpt.zze);
        zzx("/instrument", zzbpt.zzn);
        zzx("/delayPageLoaded", zzbpt.zzp);
        zzx("/delayPageClosed", zzbpt.zzq);
        zzx("/getLocationInfo", zzbpt.zzr);
        zzx("/log", zzbpt.zzg);
        zzx("/mraid", new zzbqb(zzb3, this.zzv, zzbyg2));
        zzbye zzbye = this.zzt;
        if (zzbye != null) {
            zzx("/mraidLoaded", zzbye);
        }
        zzbqf zzbqf = r4;
        zzb zzb4 = zzb3;
        zzbqf zzbqf2 = new zzbqf(zzb3, this.zzv, zzego, zzdxq, zzfir);
        zzx("/open", zzbqf);
        zzx("/precache", new zzclc());
        zzx("/touch", zzbpt.zzi);
        zzx("/video", zzbpt.zzl);
        zzx("/videoMeta", zzbpt.zzm);
        if (zzego2 == null || zzfkm2 == null) {
            zzx("/click", zzbpt.zza(zzdkn));
            zzx("/httpTrack", zzbpt.zzf);
        } else {
            zzx("/click", new zzfem(zzdkn2, zzfkm2, zzego2));
            zzx("/httpTrack", new zzfel(zzfkm2, zzego2));
        }
        if (zzt.zzn().zzu(this.zzc.getContext())) {
            zzx("/logScionEvent", new zzbqa(this.zzc.getContext()));
        }
        if (zzbpx2 != null) {
            zzx("/setInterstitialProperties", new zzbpw(zzbpx2, (byte[]) null));
        }
        if (zzbpv2 != null) {
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzhE)).booleanValue()) {
                zzx("/inspectorNetworkExtras", zzbpv2);
            }
        }
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzhX)).booleanValue() && zzbqm2 != null) {
            zzx("/shareSheet", zzbqm2);
        }
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzia)).booleanValue() && zzbqg2 != null) {
            zzx("/inspectorOutOfContextTest", zzbqg2);
        }
        if (((Boolean) zzay.zzc().zzb(zzbjc.zziU)).booleanValue()) {
            zzx("/bindPlayStoreOverlay", zzbpt.zzu);
            zzx("/presentPlayStoreOverlay", zzbpt.zzv);
            zzx("/expandPlayStoreOverlay", zzbpt.zzw);
            zzx("/collapsePlayStoreOverlay", zzbpt.zzx);
            zzx("/closePlayStoreOverlay", zzbpt.zzy);
        }
        this.zzg = zza2;
        this.zzh = zzo2;
        this.zzk = zzbop;
        this.zzl = zzbor;
        this.zzs = zzz2;
        this.zzu = zzb4;
        this.zzm = zzdkn2;
        this.zzn = z;
        this.zzw = zzfkm2;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zza() {
        synchronized (this.zzf) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzb() {
        synchronized (this.zzf) {
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final WebResourceResponse zzc(String str, Map map) {
        zzbdy zzb2;
        try {
            if (((Boolean) zzbkt.zza.zze()).booleanValue()) {
                if (this.zzw != null && "oda".equals(Uri.parse(str).getScheme())) {
                    this.zzw.zzc(str, (zzfju) null);
                    return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
                }
            }
            String zzc2 = zzcew.zzc(str, this.zzc.getContext(), this.zzA);
            if (!zzc2.equals(str)) {
                return zzN(zzc2, map);
            }
            zzbeb zza2 = zzbeb.zza(Uri.parse(str));
            if (zza2 != null && (zzb2 = zzt.zzc().zzb(zza2)) != null && zzb2.zze()) {
                return new WebResourceResponse("", "", zzb2.zzc());
            }
            if (!zzcgo.zzl() || !((Boolean) zzbko.zzb.zze()).booleanValue()) {
                return null;
            }
            return zzN(str, map);
        } catch (Exception | NoClassDefFoundError e) {
            zzt.zzo().zzt(e, "AdWebViewClient.interceptRequest");
            return zzM();
        }
    }

    public final zzb zzd() {
        return this.zzu;
    }

    public final void zzg() {
        if (this.zzi != null && ((this.zzx && this.zzz <= 0) || this.zzy || this.zzo)) {
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzbD)).booleanValue() && this.zzc.zzo() != null) {
                zzbjj.zza(this.zzc.zzo().zza(), this.zzc.zzn(), "awfllc");
            }
            zzcoa zzcoa = this.zzi;
            boolean z = false;
            if (!this.zzy && !this.zzo) {
                z = true;
            }
            zzcoa.zza(z);
            this.zzi = null;
        }
        this.zzc.zzae();
    }

    public final void zzh(boolean z) {
        this.zzA = z;
    }

    public final void zzi(Uri uri) {
        String path = uri.getPath();
        List list = (List) this.zze.get(path);
        if (path == null || list == null) {
            zze.zza("No GMSG handler found for GMSG: ".concat(String.valueOf(String.valueOf(uri))));
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzfP)).booleanValue() && zzt.zzo().zzf() != null) {
                zzchc.zza.execute(new zzcmq((path == null || path.length() < 2) ? "null" : path.substring(1)));
                return;
            }
            return;
        }
        String encodedQuery = uri.getEncodedQuery();
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzeI)).booleanValue() && this.zzB.contains(path) && encodedQuery != null) {
            if (encodedQuery.length() >= ((Integer) zzay.zzc().zzb(zzbjc.zzeK)).intValue()) {
                zze.zza("Parsing gmsg query params on BG thread: ".concat(path));
                zzfzg.zzr(zzt.zzp().zzb(uri), new zzcmu(this, list, path, uri), zzchc.zze);
                return;
            }
        }
        zzt.zzp();
        zzO(zzs.zzL(uri), list, path);
    }

    public final void zzj() {
        zzbep zzbep = this.zzd;
        if (zzbep != null) {
            zzbep.zzc(10005);
        }
        this.zzy = true;
        zzg();
        this.zzc.destroy();
    }

    public final void zzk() {
        synchronized (this.zzf) {
        }
        this.zzz++;
        zzg();
    }

    public final void zzl() {
        this.zzz--;
        zzg();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm() {
        this.zzc.zzac();
        zzl zzN = this.zzc.zzN();
        if (zzN != null) {
            zzN.zzx();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(View view, zzcdq zzcdq, int i) {
        zzQ(view, zzcdq, i - 1);
    }

    public final void zzo(int i, int i2, boolean z) {
        zzbye zzbye = this.zzt;
        if (zzbye != null) {
            zzbye.zzb(i, i2);
        }
        zzbxz zzbxz = this.zzv;
        if (zzbxz != null) {
            zzbxz.zzc(i, i2, false);
        }
    }

    public final void zzp() {
        zzcdq zzcdq = this.zza;
        if (zzcdq != null) {
            WebView zzI = this.zzc.zzI();
            if (ViewCompat.isAttachedToWindow(zzI)) {
                zzQ(zzI, zzcdq, 10);
                return;
            }
            zzP();
            this.zzC = new zzcmt(this, zzcdq);
            ((View) this.zzc).addOnAttachStateChangeListener(this.zzC);
        }
    }

    public final void zzq() {
        zzdkn zzdkn = this.zzm;
        if (zzdkn != null) {
            zzdkn.zzq();
        }
    }

    public final void zzr(zzc zzc2, boolean z) {
        zzdkn zzdkn;
        boolean zzaC = this.zzc.zzaC();
        boolean zzR = zzR(zzaC, this.zzc);
        boolean z2 = true;
        if (!zzR && z) {
            z2 = false;
        }
        zza zza2 = zzR ? null : this.zzg;
        zzo zzo2 = zzaC ? null : this.zzh;
        zzz zzz2 = this.zzs;
        zzcgv zzp2 = this.zzc.zzp();
        zzcmp zzcmp = this.zzc;
        if (z2) {
            zzdkn = null;
        } else {
            zzdkn = this.zzm;
        }
        zzu(new AdOverlayInfoParcel(zzc2, zza2, zzo2, zzz2, zzp2, zzcmp, zzdkn));
    }

    public final void zzs(zzbr zzbr, zzego zzego, zzdxq zzdxq, zzfir zzfir, String str, String str2, int i) {
        zzcmp zzcmp = this.zzc;
        zzu(new AdOverlayInfoParcel(zzcmp, zzcmp.zzp(), zzbr, zzego, zzdxq, zzfir, str, str2, 14));
    }

    public final void zzt(boolean z, int i, boolean z2) {
        zzdkn zzdkn;
        boolean zzR = zzR(this.zzc.zzaC(), this.zzc);
        boolean z3 = true;
        if (!zzR && z2) {
            z3 = false;
        }
        zza zza2 = zzR ? null : this.zzg;
        zzo zzo2 = this.zzh;
        zzz zzz2 = this.zzs;
        zzcmp zzcmp = this.zzc;
        zzcgv zzp2 = zzcmp.zzp();
        if (z3) {
            zzdkn = null;
        } else {
            zzdkn = this.zzm;
        }
        zzu(new AdOverlayInfoParcel(zza2, zzo2, zzz2, zzcmp, z, i, zzp2, zzdkn));
    }

    public final void zzu(AdOverlayInfoParcel adOverlayInfoParcel) {
        zzc zzc2;
        zzbxz zzbxz = this.zzv;
        boolean zze2 = zzbxz != null ? zzbxz.zze() : false;
        zzt.zzi();
        zzm.zza(this.zzc.getContext(), adOverlayInfoParcel, !zze2);
        zzcdq zzcdq = this.zza;
        if (zzcdq != null) {
            String str = adOverlayInfoParcel.zzl;
            if (str == null && (zzc2 = adOverlayInfoParcel.zza) != null) {
                str = zzc2.zzb;
            }
            zzcdq.zzh(str);
        }
    }

    public final void zzv(boolean z, int i, String str, boolean z2) {
        zza zza2;
        zzdkn zzdkn;
        boolean zzaC = this.zzc.zzaC();
        boolean zzR = zzR(zzaC, this.zzc);
        boolean z3 = true;
        if (!zzR && z2) {
            z3 = false;
        }
        if (zzR) {
            zza2 = null;
        } else {
            zza2 = this.zzg;
        }
        zzcmv zzcmv = zzaC ? null : new zzcmv(this.zzc, this.zzh);
        zzbop zzbop = this.zzk;
        zzbor zzbor = this.zzl;
        zzz zzz2 = this.zzs;
        zzcmp zzcmp = this.zzc;
        zzcgv zzp2 = zzcmp.zzp();
        if (z3) {
            zzdkn = null;
        } else {
            zzdkn = this.zzm;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = r4;
        AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel(zza2, zzcmv, zzbop, zzbor, zzz2, zzcmp, z, i, str, zzp2, zzdkn);
        zzu(adOverlayInfoParcel);
    }

    public final void zzw(boolean z, int i, String str, String str2, boolean z2) {
        zza zza2;
        zzdkn zzdkn;
        boolean zzaC = this.zzc.zzaC();
        boolean zzR = zzR(zzaC, this.zzc);
        boolean z3 = true;
        if (!zzR && z2) {
            z3 = false;
        }
        if (zzR) {
            zza2 = null;
        } else {
            zza2 = this.zzg;
        }
        zzcmv zzcmv = zzaC ? null : new zzcmv(this.zzc, this.zzh);
        zzbop zzbop = this.zzk;
        zzbor zzbor = this.zzl;
        zzz zzz2 = this.zzs;
        zzcmp zzcmp = this.zzc;
        zzcgv zzp2 = zzcmp.zzp();
        if (z3) {
            zzdkn = null;
        } else {
            zzdkn = this.zzm;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = r4;
        AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel(zza2, (zzo) zzcmv, zzbop, zzbor, zzz2, zzcmp, z, i, str, str2, zzp2, zzdkn);
        zzu(adOverlayInfoParcel);
    }

    public final void zzx(String str, zzbpu zzbpu) {
        synchronized (this.zzf) {
            List list = (List) this.zze.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.zze.put(str, list);
            }
            list.add(zzbpu);
        }
    }

    public final void zzy() {
        zzcdq zzcdq = this.zza;
        if (zzcdq != null) {
            zzcdq.zze();
            this.zza = null;
        }
        zzP();
        synchronized (this.zzf) {
            this.zze.clear();
            this.zzg = null;
            this.zzh = null;
            this.zzi = null;
            this.zzj = null;
            this.zzk = null;
            this.zzl = null;
            this.zzn = false;
            this.zzp = false;
            this.zzq = false;
            this.zzs = null;
            this.zzu = null;
            this.zzt = null;
            zzbxz zzbxz = this.zzv;
            if (zzbxz != null) {
                zzbxz.zza(true);
                this.zzv = null;
            }
            this.zzw = null;
        }
    }

    public final void zzz(zzcoa zzcoa) {
        this.zzi = zzcoa;
    }
}
