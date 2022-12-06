package com.unad.sdk;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerRequest;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.RequestConfiguration;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.out.BannerAdListener;
import com.mbridge.msdk.out.BannerSize;
import com.mbridge.msdk.out.MBBannerView;
import com.mbridge.msdk.out.MBridgeIds;
import com.unad.sdk.dto.AdError;
import com.unad.sdk.dto.AdList;
import com.unad.sdk.dto.SourceVO;
import java.util.ArrayList;
import java.util.Locale;
import sg.bigo.ads.api.AdInteractionListener;
import sg.bigo.ads.api.AdLoadListener;
import sg.bigo.ads.api.BannerAd;
import sg.bigo.ads.api.BannerAdLoader;
import sg.bigo.ads.api.BannerAdRequest;

public class UNADBannerView extends FrameLayout {
    /* access modifiers changed from: private */
    public Context a;
    private View b;
    /* access modifiers changed from: private */
    public ViewGroup c;
    private AdView d;
    /* access modifiers changed from: private */
    public String e;
    private AdList f;
    /* access modifiers changed from: private */
    public AdViewListener g;
    /* access modifiers changed from: private */
    public Handler h;
    private SourceVO i;
    /* access modifiers changed from: private */
    public ArrayList<SourceVO> j;
    private boolean k;
    /* access modifiers changed from: private */
    public boolean l;
    private MBBannerView m;
    /* access modifiers changed from: private */
    public BannerAd n;
    private int o;
    /* access modifiers changed from: private */
    public boolean p;
    /* access modifiers changed from: private */
    public Runnable q;

    public interface AdViewListener {
        void onAdClicked(UNADBannerView uNADBannerView);

        void onAdClose(UNADBannerView uNADBannerView);

        void onAdFailed(UNADBannerView uNADBannerView, AdError adError);

        void onAdLoaded(UNADBannerView uNADBannerView);

        void onAdOpen(UNADBannerView uNADBannerView);
    }

    class a implements Runnable {
        a() {
        }

        public void run() {
            if (UNAD.isInitSuccess()) {
                UNADBannerView.this.b();
                UNADBannerView.this.h.removeCallbacks(UNADBannerView.this.q);
                return;
            }
            UNADBannerView.this.h.postDelayed(this, 300);
        }
    }

    class c implements PAGBannerAdLoadListener {

        class a implements PAGBannerAdInteractionListener {
            a() {
            }

            public void onAdClicked() {
                if (UNADBannerView.this.p) {
                    b.a().a(UNADBannerView.this.a, UNADBannerView.this.e, "pangle", (String) null, MBridgeConstans.DYNAMIC_VIEW_TYPE_ALTER_NATIVE_STR_4);
                }
                if (UNADBannerView.this.g != null) {
                    UNADBannerView.this.g.onAdClicked(UNADBannerView.this);
                }
            }

            public void onAdDismissed() {
                if (UNADBannerView.this.g != null) {
                    UNADBannerView.this.g.onAdClose(UNADBannerView.this);
                }
            }

            public void onAdShowed() {
                if (UNADBannerView.this.p) {
                    b.a().e(UNADBannerView.this.a, UNADBannerView.this.e, "pangle", (String) null, MBridgeConstans.DYNAMIC_VIEW_TYPE_ALTER_NATIVE_STR_4);
                }
                if (UNADBannerView.this.g != null) {
                    UNADBannerView.this.g.onAdOpen(UNADBannerView.this);
                }
            }
        }

        c() {
        }

        private void b(PAGBannerAd pAGBannerAd) {
            pAGBannerAd.setAdInteractionListener(new a());
        }

        /* renamed from: a */
        public void onAdLoaded(PAGBannerAd pAGBannerAd) {
            if (!UNADBannerView.this.l) {
                if (pAGBannerAd == null) {
                    UNADBannerView.this.a(-1, "广告回掉加载成功，但是广告list为null", "pangle");
                    return;
                }
                boolean unused = UNADBannerView.this.l = true;
                if (UNADBannerView.this.g != null) {
                    UNADBannerView.this.g.onAdLoaded(UNADBannerView.this);
                }
                if (UNADBannerView.this.p) {
                    b.a().c(UNADBannerView.this.a, UNADBannerView.this.e, "pangle", (String) null, MBridgeConstans.DYNAMIC_VIEW_TYPE_ALTER_NATIVE_STR_4);
                }
                b(pAGBannerAd);
                UNADBannerView.this.c.removeAllViews();
                UNADBannerView.this.c.addView(pAGBannerAd.getBannerView());
            }
        }

        public void onError(int i, String str) {
            UNADBannerView.this.a(i, str, "pangle");
        }
    }

    class d implements BannerAdListener {
        d() {
        }

        public void closeFullScreen(MBridgeIds mBridgeIds) {
        }

        public void onClick(MBridgeIds mBridgeIds) {
            if (UNADBannerView.this.p) {
                b.a().a(UNADBannerView.this.a, UNADBannerView.this.e, "mintegral", (String) null, MBridgeConstans.DYNAMIC_VIEW_TYPE_ALTER_NATIVE_STR_4);
            }
            if (UNADBannerView.this.g != null) {
                UNADBannerView.this.g.onAdClicked(UNADBannerView.this);
            }
        }

        public void onCloseBanner(MBridgeIds mBridgeIds) {
            if (UNADBannerView.this.g != null) {
                UNADBannerView.this.g.onAdClose(UNADBannerView.this);
            }
        }

        public void onLeaveApp(MBridgeIds mBridgeIds) {
        }

        public void onLoadFailed(MBridgeIds mBridgeIds, String str) {
            if (UNADBannerView.this.p) {
                b a2 = b.a();
                Context j = UNADBannerView.this.a;
                String k = UNADBannerView.this.e;
                a2.b(j, k, "mintegral#" + str, MBridgeConstans.DYNAMIC_VIEW_TYPE_ALTER_NATIVE_STR_4, "mintegral");
            }
            if (!UNADBannerView.this.l) {
                if (UNADBannerView.this.j.size() <= 0) {
                    UNADBannerView uNADBannerView = UNADBannerView.this;
                    uNADBannerView.a("mintegral", "-1", str + "");
                    return;
                }
                UNADBannerView.this.c();
            }
        }

        public void onLoadSuccessed(MBridgeIds mBridgeIds) {
            if (UNADBannerView.this.p) {
                b.a().c(UNADBannerView.this.a, UNADBannerView.this.e, "mintegral", (String) null, MBridgeConstans.DYNAMIC_VIEW_TYPE_ALTER_NATIVE_STR_4);
            }
            boolean unused = UNADBannerView.this.l = true;
            if (UNADBannerView.this.g != null) {
                UNADBannerView.this.g.onAdLoaded(UNADBannerView.this);
            }
        }

        public void onLogImpression(MBridgeIds mBridgeIds) {
        }

        public void showFullScreen(MBridgeIds mBridgeIds) {
            if (UNADBannerView.this.p) {
                b.a().e(UNADBannerView.this.a, UNADBannerView.this.e, "mintegral", (String) null, MBridgeConstans.DYNAMIC_VIEW_TYPE_ALTER_NATIVE_STR_4);
            }
            if (UNADBannerView.this.g != null) {
                UNADBannerView.this.g.onAdOpen(UNADBannerView.this);
            }
        }
    }

    class e extends AdListener {
        e() {
        }

        public void onAdClicked() {
            if (UNADBannerView.this.p) {
                b.a().a(UNADBannerView.this.a, UNADBannerView.this.e, "google", (String) null, MBridgeConstans.DYNAMIC_VIEW_TYPE_ALTER_NATIVE_STR_4);
            }
            if (UNADBannerView.this.g != null) {
                UNADBannerView.this.g.onAdClicked(UNADBannerView.this);
            }
        }

        public void onAdClosed() {
            if (UNADBannerView.this.g != null) {
                UNADBannerView.this.g.onAdClose(UNADBannerView.this);
            }
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            if (UNADBannerView.this.p) {
                b.a().b(UNADBannerView.this.a, UNADBannerView.this.e, "google#" + loadAdError.getMessage(), MBridgeConstans.DYNAMIC_VIEW_TYPE_ALTER_NATIVE_STR_4, "google");
            }
            if (!UNADBannerView.this.l) {
                if (UNADBannerView.this.j.size() <= 0) {
                    UNADBannerView.this.a("google", RequestConfiguration.MAX_AD_CONTENT_RATING_G + loadAdError.getCode(), loadAdError.getMessage() + "");
                    return;
                }
                UNADBannerView.this.c();
            }
        }

        public void onAdLoaded() {
            if (UNADBannerView.this.p) {
                b.a().c(UNADBannerView.this.a, UNADBannerView.this.e, "google", (String) null, MBridgeConstans.DYNAMIC_VIEW_TYPE_ALTER_NATIVE_STR_4);
            }
            boolean unused = UNADBannerView.this.l = true;
            if (UNADBannerView.this.g != null) {
                UNADBannerView.this.g.onAdLoaded(UNADBannerView.this);
            }
        }

        public void onAdOpened() {
            if (UNADBannerView.this.p) {
                b.a().e(UNADBannerView.this.a, UNADBannerView.this.e, "google", (String) null, MBridgeConstans.DYNAMIC_VIEW_TYPE_ALTER_NATIVE_STR_4);
            }
            if (UNADBannerView.this.g != null) {
                UNADBannerView.this.g.onAdOpen(UNADBannerView.this);
            }
        }
    }

    public UNADBannerView(Context context) {
        super(context);
        this.e = null;
        this.h = new Handler();
        this.j = new ArrayList<>();
        this.p = true;
        this.q = new a();
        a(context, (AttributeSet) null);
    }

    private AdSize getAdSize() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(getContext(), (int) (((float) displayMetrics.widthPixels) / displayMetrics.density));
    }

    public void destroy() {
        ViewGroup viewGroup = this.c;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        a();
    }

    public void loadAd() {
        this.l = false;
        this.k = false;
        if (!UNAD.isInitSuccess()) {
            this.h.removeCallbacks(this.q);
            this.h.postDelayed(this.q, 300);
            return;
        }
        b();
    }

    public void pause() {
        AdView adView = this.d;
        if (adView != null) {
            adView.pause();
        }
    }

    public void removeAllViews() {
        destroy();
        View view = this.b;
        if (view != null && (view instanceof FrameLayout)) {
            ((FrameLayout) view).removeAllViews();
        }
    }

    public void resume() {
        AdView adView = this.d;
        if (adView != null) {
            adView.resume();
        }
    }

    public void setAdUnitId(String str) {
        this.e = str;
    }

    public void setAdViewListener(AdViewListener adViewListener) {
        this.g = adViewListener;
    }

    public void setWidth(int i2) {
        this.o = i2;
    }

    /* access modifiers changed from: private */
    public void b() {
        if (this.e == null) {
            a("unadsdk", "A001", this.a.getString(R.string.unad_A001));
            return;
        }
        AdInfo adInfo = a.b;
        if (adInfo == null || adInfo.getAdUnits() == null || adInfo.getAdUnits().size() <= 0 || !MBridgeConstans.ENDCARD_URL_TYPE_PL.equals(adInfo.getStatus())) {
            a("unadsdk", "A002", this.a.getString(R.string.unad_A002));
            return;
        }
        for (AdList next : adInfo.getAdUnits()) {
            if (IronSourceConstants.BANNER_AD_UNIT.equals(next.getType()) && this.e.equals(next.getAdUnitId())) {
                this.f = next;
            }
        }
        AdList adList = this.f;
        if (adList == null) {
            a("unadsdk", "A003", this.a.getString(R.string.unad_A003));
        } else if (!adList.isEnable()) {
            a("unadsdk", "A004", this.a.getString(R.string.unad_A004));
        } else {
            if (!(this.a == null || this.f.getCountrys() == null || this.f.getCountrys().length() <= 0)) {
                Locale locale = this.a.getResources().getConfiguration().locale;
                if (!this.f.getCountrys().contains((locale.getCountry() + "").toUpperCase())) {
                    if (UNAD.ISOPENTAG) {
                        Log.i("UNAD_SDK", "not font country code");
                    }
                    a("unadsdk", "A006", this.a.getString(R.string.unad_A006));
                    return;
                }
            }
            if (this.f.getAdSource() == null || this.f.getAdSource().isEmpty()) {
                a("unadsdk", "A003", this.a.getString(R.string.unad_A003));
                return;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.f.getAdSource().size(); i3++) {
                if (this.f.getAdSource().get(i3) != null) {
                    this.f.getAdSource().get(i3).setIndex(i3);
                }
            }
            try {
                this.p = this.f.isOpenLogs();
            } catch (Exception unused) {
            }
            int parseInt = Integer.parseInt(new com.unad.sdk.util.b(this.a.getApplicationContext()).b("bannerad_index", MBridgeConstans.ENDCARD_URL_TYPE_PL));
            if (!d.a(this.f, parseInt)) {
                i2 = parseInt;
            }
            SourceVO a2 = d.a(this.f, i2, this.a);
            this.i = a2;
            if (a2 == null) {
                a("unadsdk", "A003", this.a.getString(R.string.unad_A003));
                return;
            }
            if (this.j.size() <= 0) {
                this.j = d.a(this.f, this.i);
            }
            d();
            e((i2 + 1) + "");
        }
    }

    private void c(String str) {
        if (str == null) {
            a("unadsdk", "-1", "adid is null");
            return;
        }
        if (!(str + "").contains("#")) {
            a("unadsdk", "-1", "mintegral id is exception");
            return;
        }
        MBBannerView mBBannerView = this.m;
        if (mBBannerView != null) {
            mBBannerView.release();
        }
        if (this.p) {
            b.a().a(this.a, this.e, this.k, "mintegral", MBridgeConstans.DYNAMIC_VIEW_TYPE_ALTER_NATIVE_STR_4);
        }
        String str2 = str.split("#")[0];
        String str3 = str.split("#")[1];
        MBBannerView mBBannerView2 = new MBBannerView(this.a);
        this.m = mBBannerView2;
        mBBannerView2.init(new BannerSize(4, 0, 0), str2, str3);
        int i2 = this.o;
        if (i2 <= 0) {
            this.m.setLayoutParams(new FrameLayout.LayoutParams(-1, com.unad.sdk.util.a.a(this.a, 50.0f)));
        } else {
            this.m.setLayoutParams(new FrameLayout.LayoutParams(i2, com.unad.sdk.util.a.a(this.a, 50.0f)));
        }
        this.m.setAllowShowCloseBtn(true);
        this.m.setRefreshTime(15);
        this.c.removeAllViews();
        this.c.addView(this.m);
        this.m.setBannerAdListener(new d());
        this.m.load();
    }

    private void d() {
        a();
        if ("google".equals(this.i.getSource())) {
            b(this.i.getId());
        } else if ("mintegral".equals(this.i.getSource())) {
            c(this.i.getId());
        } else if ("pangle".equals(this.i.getSource())) {
            d(this.i.getId());
        } else if ("bigo".equals(this.i.getSource())) {
            a(this.i.getId());
        } else {
            ArrayList<SourceVO> arrayList = this.j;
            if (arrayList == null || arrayList.size() != 0) {
                if (this.p) {
                    b.a().b(this.a, this.e, "unadsdk# ad type error", MBridgeConstans.DYNAMIC_VIEW_TYPE_ALTER_NATIVE_STR_4, "unadsdk");
                }
                c();
                return;
            }
            a("unadsdk", "-1", "type error ad timed out");
        }
    }

    private void e(String str) {
        Context context = this.a;
        if (context != null) {
            new com.unad.sdk.util.b(context.getApplicationContext()).a("bannerad_index", str);
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.a = context;
        a.a(context);
        View inflate = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(R.layout.unad_ad_banner_view, this, true);
        this.b = inflate;
        this.c = (LinearLayout) inflate.findViewById(R.id.bannerContainer);
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        String str4 = str + "#" + str2 + "#" + str3;
        if (this.p) {
            b.a().b(this.a, this.e, str4, MBridgeConstans.DYNAMIC_VIEW_TYPE_ALTER_NATIVE_STR_4, str);
        }
        AdViewListener adViewListener = this.g;
        if (adViewListener != null) {
            adViewListener.onAdFailed(this, new AdError(str2, str3));
        }
    }

    private void a() {
        AdView adView = this.d;
        if (adView != null) {
            adView.destroy();
            this.d = null;
        }
        MBBannerView mBBannerView = this.m;
        if (mBBannerView != null) {
            mBBannerView.release();
            this.m = null;
        }
        BannerAd bannerAd = this.n;
        if (bannerAd != null) {
            bannerAd.destroy();
        }
    }

    private void d(String str) {
        if (str == null) {
            a("unadsdk", "-1", "adid is null");
        } else if (!UNAD.PANGLE_INIT_BOOLEAN) {
            c();
        } else {
            PAGBannerRequest pAGBannerRequest = new PAGBannerRequest(PAGBannerSize.BANNER_W_320_H_50);
            int i2 = this.o;
            if (i2 <= 0) {
                this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, com.unad.sdk.util.a.a(this.a, 50.0f)));
            } else {
                this.c.setLayoutParams(new LinearLayout.LayoutParams(i2, com.unad.sdk.util.a.a(this.a, 50.0f)));
            }
            if (this.p) {
                b.a().a(this.a, this.e, this.k, "pangle", MBridgeConstans.DYNAMIC_VIEW_TYPE_ALTER_NATIVE_STR_4);
            }
            PAGBannerAd.loadAd(str, pAGBannerRequest, new c());
        }
    }

    class b implements AdLoadListener<BannerAd> {

        class a implements AdInteractionListener {
            a() {
            }

            public void onAdClicked() {
                if (UNADBannerView.this.p) {
                    b.a().a(UNADBannerView.this.a, UNADBannerView.this.e, "bigo", (String) null, MBridgeConstans.DYNAMIC_VIEW_TYPE_ALTER_NATIVE_STR_4);
                }
                if (UNADBannerView.this.g != null) {
                    UNADBannerView.this.g.onAdClicked(UNADBannerView.this);
                }
            }

            public void onAdClosed() {
                if (UNADBannerView.this.g != null) {
                    UNADBannerView.this.g.onAdClose(UNADBannerView.this);
                }
            }

            public void onAdError(sg.bigo.ads.api.AdError adError) {
                UNADBannerView.this.a(adError.getCode(), adError.getMessage(), "bigo");
            }

            public void onAdImpression() {
                if (UNADBannerView.this.p) {
                    b.a().e(UNADBannerView.this.a, UNADBannerView.this.e, "bigo", (String) null, MBridgeConstans.DYNAMIC_VIEW_TYPE_ALTER_NATIVE_STR_4);
                }
                if (UNADBannerView.this.g != null) {
                    UNADBannerView.this.g.onAdOpen(UNADBannerView.this);
                }
            }

            public void onAdOpened() {
            }
        }

        b() {
        }

        /* renamed from: a */
        public void onAdLoaded(BannerAd bannerAd) {
            if (!UNADBannerView.this.l) {
                if (bannerAd == null) {
                    UNADBannerView.this.a(-1, "广告回掉加载成功，但是广告list为null", "bigo");
                    return;
                }
                boolean unused = UNADBannerView.this.l = true;
                if (UNADBannerView.this.g != null) {
                    UNADBannerView.this.g.onAdLoaded(UNADBannerView.this);
                }
                if (UNADBannerView.this.p) {
                    b.a().c(UNADBannerView.this.a, UNADBannerView.this.e, "bigo", (String) null, MBridgeConstans.DYNAMIC_VIEW_TYPE_ALTER_NATIVE_STR_4);
                }
                BannerAd unused2 = UNADBannerView.this.n = bannerAd;
                if (UNADBannerView.this.c != null) {
                    UNADBannerView.this.c.removeAllViews();
                    UNADBannerView.this.c.addView(UNADBannerView.this.n.adView());
                }
                a();
            }
        }

        public void onError(sg.bigo.ads.api.AdError adError) {
            UNADBannerView.this.a(adError.getCode(), adError.getMessage(), "bigo");
        }

        private void a() {
            UNADBannerView.this.n.setAdInteractionListener(new a());
        }
    }

    private void a(String str) {
        if (str == null) {
            a("unadsdk", "-1", "adid is null");
            return;
        }
        int i2 = this.o;
        if (i2 <= 0) {
            this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, com.unad.sdk.util.a.a(this.a, 50.0f)));
        } else {
            this.c.setLayoutParams(new LinearLayout.LayoutParams(i2, com.unad.sdk.util.a.a(this.a, 50.0f)));
        }
        BannerAdRequest build = new BannerAdRequest.Builder().withSlotId(str).withAdSizes(sg.bigo.ads.api.AdSize.BANNER).build();
        if (this.p) {
            b.a().a(this.a, this.e, this.k, "bigo", MBridgeConstans.DYNAMIC_VIEW_TYPE_ALTER_NATIVE_STR_4);
        }
        new BannerAdLoader.Builder().withAdLoadListener((AdLoadListener) new b()).build().loadAd(build);
    }

    private void b(String str) {
        AdView adView = this.d;
        if (adView != null) {
            adView.destroy();
            this.d = null;
        }
        AdView adView2 = new AdView(getContext());
        this.d = adView2;
        adView2.setAdUnitId(str);
        this.c.removeAllViews();
        this.c.addView(this.d);
        this.d.setAdSize(getAdSize());
        AdRequest build = new AdRequest.Builder().build();
        if (this.p) {
            b.a().a(this.a, this.e, this.k, "google", MBridgeConstans.DYNAMIC_VIEW_TYPE_ALTER_NATIVE_STR_4);
        }
        this.d.setAdListener(new e());
        this.d.loadAd(build);
    }

    /* access modifiers changed from: private */
    public void c() {
        this.k = true;
        int size = this.j.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            } else if (this.i.getIndex() == this.j.get(size).getIndex()) {
                this.j.remove(size);
                break;
            } else {
                size--;
            }
        }
        if (this.j.size() > 0) {
            this.i = this.j.get(0);
            this.j.remove(0);
            d();
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str, String str2) {
        if (this.p) {
            b.a().b(this.a, this.e, str2 + "#" + str, MBridgeConstans.DYNAMIC_VIEW_TYPE_ALTER_NATIVE_STR_4, str2);
        }
        if (!this.l) {
            if (this.j.size() <= 0) {
                a(str2, i2 + "", str + "");
                return;
            }
            c();
        }
    }

    public UNADBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        a(context, attributeSet);
    }

    public UNADBannerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.e = null;
        this.h = new Handler();
        this.j = new ArrayList<>();
        this.p = true;
        this.q = new a();
        a(context, attributeSet);
    }
}
