package com.unad.sdk;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialRequest;
import com.facebook.ads.InterstitialAd;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAdLoadCallback;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newinterstitial.out.MBNewInterstitialHandler;
import com.mbridge.msdk.newinterstitial.out.NewInterstitialListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.unad.sdk.dto.AdError;
import com.unad.sdk.dto.AdList;
import com.unad.sdk.dto.SourceVO;
import java.util.ArrayList;
import java.util.Locale;
import sg.bigo.ads.api.AdInteractionListener;
import sg.bigo.ads.api.AdLoadListener;
import sg.bigo.ads.api.InterstitialAdLoader;
import sg.bigo.ads.api.InterstitialAdRequest;

public class UNADInterstitial {
    /* access modifiers changed from: private */
    public String a = "";
    /* access modifiers changed from: private */
    public Context b;
    private AdList c;
    /* access modifiers changed from: private */
    public AdViewListener d;
    private int e = 1;
    /* access modifiers changed from: private */
    public boolean f = true;
    private SourceVO g;
    /* access modifiers changed from: private */
    public ArrayList<SourceVO> h = new ArrayList<>();
    private boolean i;
    /* access modifiers changed from: private */
    public AdManagerInterstitialAd j;
    private InterstitialAd k;
    /* access modifiers changed from: private */
    public boolean l = false;
    private MBNewInterstitialHandler m;
    /* access modifiers changed from: private */
    public boolean n = true;
    /* access modifiers changed from: private */
    public sg.bigo.ads.api.InterstitialAd o;
    /* access modifiers changed from: private */
    public PAGInterstitialAd p;

    public interface AdViewListener {
        void onAdClicked();

        void onAdClose();

        void onAdFailed(AdError adError);

        void onAdLoaded();

        void onAdOpen();
    }

    class a extends AdManagerInterstitialAdLoadCallback {

        /* renamed from: com.unad.sdk.UNADInterstitial$a$a  reason: collision with other inner class name */
        class C0107a extends FullScreenContentCallback {
            C0107a() {
            }

            public void onAdDismissedFullScreenContent() {
                if (UNADInterstitial.this.d != null) {
                    UNADInterstitial.this.d.onAdClose();
                }
                AdManagerInterstitialAd unused = UNADInterstitial.this.j = null;
                boolean unused2 = UNADInterstitial.this.l = false;
            }

            public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                boolean unused = UNADInterstitial.this.f = false;
                UNADInterstitial uNADInterstitial = UNADInterstitial.this;
                uNADInterstitial.a("google", adError.getCode() + "", adError.getMessage());
                AdManagerInterstitialAd unused2 = UNADInterstitial.this.j = null;
                boolean unused3 = UNADInterstitial.this.l = false;
            }

            public void onAdShowedFullScreenContent() {
                if (UNADInterstitial.this.n) {
                    b.a().e(UNADInterstitial.this.b, UNADInterstitial.this.a, "google", (String) null, "2");
                }
                if (UNADInterstitial.this.d != null) {
                    UNADInterstitial.this.d.onAdOpen();
                }
            }
        }

        a() {
        }

        /* renamed from: a */
        public void onAdLoaded(AdManagerInterstitialAd adManagerInterstitialAd) {
            if (UNADInterstitial.this.n) {
                b.a().c(UNADInterstitial.this.b, UNADInterstitial.this.a, "google", (String) null, "2");
            }
            AdManagerInterstitialAd unused = UNADInterstitial.this.j = adManagerInterstitialAd;
            if (UNADInterstitial.this.d != null) {
                UNADInterstitial.this.d.onAdLoaded();
            }
            boolean unused2 = UNADInterstitial.this.f = true;
            adManagerInterstitialAd.setFullScreenContentCallback(new C0107a());
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            if (UNADInterstitial.this.n) {
                b.a().b(UNADInterstitial.this.b, UNADInterstitial.this.a, "google#" + loadAdError.getMessage(), "2", "google");
            }
            boolean unused = UNADInterstitial.this.f = false;
            if (UNADInterstitial.this.h.size() <= 0) {
                UNADInterstitial.this.a("google", loadAdError.getCode() + "", loadAdError.getMessage() + "");
                return;
            }
            UNADInterstitial.this.b();
            AdManagerInterstitialAd unused2 = UNADInterstitial.this.j = null;
            boolean unused3 = UNADInterstitial.this.l = false;
        }
    }

    class b implements PAGInterstitialAdLoadListener {

        class a implements PAGInterstitialAdInteractionListener {
            a() {
            }

            public void onAdClicked() {
                if (UNADInterstitial.this.d != null) {
                    UNADInterstitial.this.d.onAdClicked();
                }
                if (UNADInterstitial.this.n) {
                    b.a().a(UNADInterstitial.this.b, UNADInterstitial.this.a, "pangle", (String) null, "2");
                }
            }

            public void onAdDismissed() {
                if (UNADInterstitial.this.p != null) {
                    PAGInterstitialAd unused = UNADInterstitial.this.p = null;
                }
                if (UNADInterstitial.this.d != null) {
                    UNADInterstitial.this.d.onAdClose();
                }
                boolean unused2 = UNADInterstitial.this.l = false;
            }

            public void onAdShowed() {
                if (UNADInterstitial.this.n) {
                    b.a().e(UNADInterstitial.this.b, UNADInterstitial.this.a, "pangle", (String) null, "2");
                }
                if (UNADInterstitial.this.d != null) {
                    UNADInterstitial.this.d.onAdOpen();
                }
            }
        }

        b() {
        }

        private void b(PAGInterstitialAd pAGInterstitialAd) {
            pAGInterstitialAd.setAdInteractionListener(new a());
        }

        /* renamed from: a */
        public void onAdLoaded(PAGInterstitialAd pAGInterstitialAd) {
            if (UNADInterstitial.this.n) {
                b.a().c(UNADInterstitial.this.b, UNADInterstitial.this.a, "pangle", (String) null, "2");
            }
            if (UNADInterstitial.this.d != null) {
                UNADInterstitial.this.d.onAdLoaded();
            }
            PAGInterstitialAd unused = UNADInterstitial.this.p = pAGInterstitialAd;
            b(pAGInterstitialAd);
        }

        public void onError(int i, String str) {
            if (UNADInterstitial.this.n) {
                b a2 = b.a();
                Context b = UNADInterstitial.this.b;
                String e = UNADInterstitial.this.a;
                a2.b(b, e, "pangle#" + str, "2", "pangle");
            }
            boolean unused = UNADInterstitial.this.f = false;
            if (UNADInterstitial.this.h.size() <= 0) {
                UNADInterstitial uNADInterstitial = UNADInterstitial.this;
                uNADInterstitial.a("pangle", "-1", str + "");
                return;
            }
            UNADInterstitial.this.b();
            AdManagerInterstitialAd unused2 = UNADInterstitial.this.j = null;
            boolean unused3 = UNADInterstitial.this.l = false;
        }
    }

    class c implements AdLoadListener<sg.bigo.ads.api.InterstitialAd> {

        class a implements AdInteractionListener {
            a() {
            }

            public void onAdClicked() {
                if (UNADInterstitial.this.d != null) {
                    UNADInterstitial.this.d.onAdClicked();
                }
                if (UNADInterstitial.this.n) {
                    b.a().a(UNADInterstitial.this.b, UNADInterstitial.this.a, "bigo", (String) null, "2");
                }
            }

            public void onAdClosed() {
                if (UNADInterstitial.this.o != null) {
                    UNADInterstitial.this.o.destroy();
                    sg.bigo.ads.api.InterstitialAd unused = UNADInterstitial.this.o = null;
                }
                if (UNADInterstitial.this.d != null) {
                    UNADInterstitial.this.d.onAdClose();
                }
                boolean unused2 = UNADInterstitial.this.l = false;
            }

            public void onAdError(sg.bigo.ads.api.AdError adError) {
                UNADInterstitial uNADInterstitial = UNADInterstitial.this;
                uNADInterstitial.a("bigo", "-1", adError.getMessage() + "");
            }

            public void onAdImpression() {
                if (UNADInterstitial.this.n) {
                    b.a().e(UNADInterstitial.this.b, UNADInterstitial.this.a, "bigo", (String) null, "2");
                }
                if (UNADInterstitial.this.d != null) {
                    UNADInterstitial.this.d.onAdOpen();
                }
            }

            public void onAdOpened() {
            }
        }

        c() {
        }

        private void a(sg.bigo.ads.api.InterstitialAd interstitialAd) {
            interstitialAd.setAdInteractionListener(new a());
        }

        /* renamed from: b */
        public void onAdLoaded(sg.bigo.ads.api.InterstitialAd interstitialAd) {
            if (UNADInterstitial.this.n) {
                b.a().c(UNADInterstitial.this.b, UNADInterstitial.this.a, "bigo", (String) null, "2");
            }
            if (UNADInterstitial.this.d != null) {
                UNADInterstitial.this.d.onAdLoaded();
            }
            sg.bigo.ads.api.InterstitialAd unused = UNADInterstitial.this.o = interstitialAd;
            a(interstitialAd);
        }

        public void onError(sg.bigo.ads.api.AdError adError) {
            if (UNADInterstitial.this.n) {
                b a2 = b.a();
                Context b = UNADInterstitial.this.b;
                String e = UNADInterstitial.this.a;
                a2.b(b, e, "bigo#" + adError.getMessage(), "2", "bigo");
            }
            boolean unused = UNADInterstitial.this.f = false;
            if (UNADInterstitial.this.h.size() <= 0) {
                UNADInterstitial uNADInterstitial = UNADInterstitial.this;
                uNADInterstitial.a("bigo", "-1", adError.getMessage() + "");
                return;
            }
            UNADInterstitial.this.b();
            AdManagerInterstitialAd unused2 = UNADInterstitial.this.j = null;
            boolean unused3 = UNADInterstitial.this.l = false;
        }
    }

    class d implements NewInterstitialListener {
        d() {
        }

        public void onAdClicked(MBridgeIds mBridgeIds) {
            if (UNADInterstitial.this.d != null) {
                UNADInterstitial.this.d.onAdClicked();
            }
            if (UNADInterstitial.this.n) {
                b.a().a(UNADInterstitial.this.b, UNADInterstitial.this.a, "mintegral", (String) null, "2");
            }
        }

        public void onAdClose(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
            if (UNADInterstitial.this.d != null) {
                UNADInterstitial.this.d.onAdClose();
            }
            boolean unused = UNADInterstitial.this.l = false;
        }

        public void onAdCloseWithNIReward(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
        }

        public void onAdShow(MBridgeIds mBridgeIds) {
            if (UNADInterstitial.this.n) {
                b.a().e(UNADInterstitial.this.b, UNADInterstitial.this.a, "mintegral", (String) null, "2");
            }
            if (UNADInterstitial.this.d != null) {
                UNADInterstitial.this.d.onAdOpen();
            }
        }

        public void onEndcardShow(MBridgeIds mBridgeIds) {
        }

        public void onLoadCampaignSuccess(MBridgeIds mBridgeIds) {
        }

        public void onResourceLoadFail(MBridgeIds mBridgeIds, String str) {
            if (UNADInterstitial.this.n) {
                b a2 = b.a();
                Context b = UNADInterstitial.this.b;
                String e = UNADInterstitial.this.a;
                a2.b(b, e, "mintegral#" + str, "2", "mintegral");
            }
            boolean unused = UNADInterstitial.this.f = false;
            if (UNADInterstitial.this.h.size() <= 0) {
                UNADInterstitial uNADInterstitial = UNADInterstitial.this;
                uNADInterstitial.a("mintegral", "-1", str + "");
                return;
            }
            UNADInterstitial.this.b();
            AdManagerInterstitialAd unused2 = UNADInterstitial.this.j = null;
            boolean unused3 = UNADInterstitial.this.l = false;
        }

        public void onResourceLoadSuccess(MBridgeIds mBridgeIds) {
            if (UNADInterstitial.this.n) {
                b.a().c(UNADInterstitial.this.b, UNADInterstitial.this.a, "mintegral", (String) null, "2");
            }
            if (UNADInterstitial.this.d != null) {
                UNADInterstitial.this.d.onAdLoaded();
            }
        }

        public void onShowFail(MBridgeIds mBridgeIds, String str) {
            UNADInterstitial uNADInterstitial = UNADInterstitial.this;
            uNADInterstitial.a("mintegral", "-1", str + "");
        }

        public void onVideoComplete(MBridgeIds mBridgeIds) {
        }
    }

    public UNADInterstitial(Context context) {
        this.b = context;
    }

    public void destroy() {
        sg.bigo.ads.api.InterstitialAd interstitialAd = this.o;
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        InterstitialAd interstitialAd2 = this.k;
        if (interstitialAd2 != null) {
            interstitialAd2.destroy();
        }
    }

    public boolean isLoaded() {
        int i2 = this.e;
        if (i2 == 1) {
            return this.f;
        }
        if (i2 == 2) {
            return this.m.isReady();
        }
        if (i2 == 3) {
            sg.bigo.ads.api.InterstitialAd interstitialAd = this.o;
            if (interstitialAd == null || interstitialAd.isExpired()) {
                return false;
            }
            return true;
        } else if (i2 != 4) {
            return false;
        } else {
            if (this.p != null) {
                return true;
            }
            return false;
        }
    }

    public void loadAd() {
        a.a(this.b);
        if (!this.l) {
            this.l = true;
            this.i = false;
            this.f = false;
            a();
            return;
        }
        Log.i("UNAD_SDK", "已经加载不能重复加载");
    }

    public void setAdUnitId(String str) {
        this.a = str;
    }

    public void setAdViewListener(AdViewListener adViewListener) {
        this.d = adViewListener;
    }

    public void show(Activity activity) {
        this.l = false;
        int i2 = this.e;
        if (1 == i2) {
            c(activity);
        } else if (2 == i2) {
            b(activity);
        } else if (3 == i2) {
            a(activity);
        } else if (4 == i2) {
            d(activity);
        }
    }

    private void c(Activity activity) {
        AdManagerInterstitialAd adManagerInterstitialAd = this.j;
        if (adManagerInterstitialAd != null) {
            adManagerInterstitialAd.show(activity);
            this.j = null;
            return;
        }
        a("unadsdk", "A005", this.b.getString(R.string.unad_A005));
    }

    private void d(Activity activity) {
        PAGInterstitialAd pAGInterstitialAd = this.p;
        if (pAGInterstitialAd != null) {
            pAGInterstitialAd.show(activity);
        } else {
            a("unadsdk", "A005", this.b.getString(R.string.unad_A005));
        }
    }

    private void e(String str) {
        Context context = this.b;
        if (context != null) {
            new com.unad.sdk.util.b(context.getApplicationContext()).a("intersititial_index", str);
        }
    }

    private void b(Activity activity) {
        MBNewInterstitialHandler mBNewInterstitialHandler = this.m;
        if (mBNewInterstitialHandler == null || !mBNewInterstitialHandler.isReady()) {
            a("unadsdk", "A005", this.b.getString(R.string.unad_A005));
        } else {
            this.m.show();
        }
    }

    private void d(String str) {
        if (str == null) {
            a("unadsdk", "-1", "adid is null");
        } else if (!UNAD.PANGLE_INIT_BOOLEAN) {
            b();
        } else {
            this.e = 4;
            if (this.n) {
                b.a().a(this.b, this.a, this.i, "pangle", "2");
            }
            this.p = null;
            PAGInterstitialAd.loadAd(str, new PAGInterstitialRequest(), new b());
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        this.l = false;
        String str4 = str + "#" + str2 + "#" + str3;
        if (this.n) {
            b.a().b(this.b, this.a, str4, MBridgeConstans.DYNAMIC_VIEW_TYPE_ALTER_NATIVE_STR_4, str);
        }
        AdViewListener adViewListener = this.d;
        if (adViewListener != null) {
            adViewListener.onAdFailed(new AdError(str2, str3));
        }
    }

    private void b(String str) {
        this.e = 1;
        if (this.n) {
            b.a().a(this.b, this.a, this.i, "google", "2");
        }
        AdManagerInterstitialAd.load(this.b, str, new AdManagerAdRequest.Builder().build(), new a());
    }

    private void c() {
        if ("google".equals(this.g.getSource())) {
            b(this.g.getId());
        } else if ("mintegral".equals(this.g.getSource())) {
            c(this.g.getId());
        } else if ("bigo".equals(this.g.getSource())) {
            a(this.g.getId());
        } else if ("pangle".equals(this.g.getSource())) {
            d(this.g.getId());
        } else {
            if (this.n) {
                b.a().b(this.b, this.a, "unadsdk# ad type error", "2", "unadsdk");
            }
            this.f = false;
            this.j = null;
            this.l = false;
            ArrayList<SourceVO> arrayList = this.h;
            if (arrayList == null || arrayList.size() != 0) {
                b();
            } else {
                a("unadsdk", "-1", "type error ad timed out");
            }
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        this.i = true;
        int size = this.h.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            } else if (this.g.getIndex() == this.h.get(size).getIndex()) {
                this.h.remove(size);
                break;
            } else {
                size--;
            }
        }
        if (this.h.size() > 0) {
            this.g = this.h.get(0);
            this.h.remove(0);
            c();
        }
    }

    private void a(Activity activity) {
        sg.bigo.ads.api.InterstitialAd interstitialAd = this.o;
        if (interstitialAd == null || interstitialAd.isExpired()) {
            a("unadsdk", "A005", this.b.getString(R.string.unad_A005));
        } else {
            this.o.show();
        }
    }

    private void a() {
        if (this.a == null) {
            a("google", "A001", this.b.getString(R.string.unad_A001) + "");
            return;
        }
        AdInfo adInfo = a.b;
        if (adInfo == null || adInfo.getAdUnits() == null || adInfo.getAdUnits().size() <= 0 || !MBridgeConstans.ENDCARD_URL_TYPE_PL.equals(adInfo.getStatus())) {
            a("google", "A002", this.b.getString(R.string.unad_A002) + "");
            return;
        }
        for (AdList next : adInfo.getAdUnits()) {
            if (IronSourceConstants.INTERSTITIAL_AD_UNIT.equals(next.getType()) && this.a.equals(next.getAdUnitId())) {
                this.c = next;
            }
        }
        AdList adList = this.c;
        if (adList == null) {
            a("google", "A003", this.b.getString(R.string.unad_A003) + "");
        } else if (!adList.isEnable()) {
            a("google", "A004", this.b.getString(R.string.unad_A004) + "");
        } else {
            if (!(this.b == null || this.c.getCountrys() == null || this.c.getCountrys().length() <= 0)) {
                Locale locale = this.b.getResources().getConfiguration().locale;
                if (!this.c.getCountrys().contains((locale.getCountry() + "").toUpperCase())) {
                    if (UNAD.ISOPENTAG) {
                        Log.i("UNAD_SDK", "not font country code");
                    }
                    a("google", "A006", this.b.getString(R.string.unad_A006) + "");
                    return;
                }
            }
            if (this.c.getAdSource() == null || this.c.getAdSource().isEmpty()) {
                a("unadsdk", "A003", this.b.getString(R.string.unad_A003));
                return;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.c.getAdSource().size(); i3++) {
                if (this.c.getAdSource().get(i3) != null) {
                    this.c.getAdSource().get(i3).setIndex(i3);
                }
            }
            try {
                this.n = this.c.isOpenLogs();
            } catch (Exception unused) {
            }
            int parseInt = Integer.parseInt(new com.unad.sdk.util.b(this.b).b("intersititial_index", MBridgeConstans.ENDCARD_URL_TYPE_PL));
            if (!d.a(this.c, parseInt)) {
                i2 = parseInt;
            }
            SourceVO a2 = d.a(this.c, i2, this.b);
            this.g = a2;
            if (a2 == null) {
                a("unadsdk", "A003", this.b.getString(R.string.unad_A003));
                return;
            }
            if (this.h.size() <= 0) {
                this.h = d.a(this.c, this.g);
            }
            c();
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
        String str2 = str.split("#")[0];
        String str3 = str.split("#")[1];
        this.e = 2;
        if (this.n) {
            b.a().a(this.b, this.a, this.i, "mintegral", "2");
        }
        MBNewInterstitialHandler mBNewInterstitialHandler = new MBNewInterstitialHandler(this.b, str2, str3);
        this.m = mBNewInterstitialHandler;
        mBNewInterstitialHandler.playVideoMute(1);
        this.m.setInterstitialVideoListener(new d());
        this.m.load();
    }

    private UNADInterstitial() {
    }

    private void a(String str) {
        if (str == null) {
            a("unadsdk", "-1", "adid is null");
        } else if (!UNAD.BIGO_INIT_BOOLEAN) {
            b();
        } else {
            this.e = 3;
            if (this.n) {
                b.a().a(this.b, this.a, this.i, "bigo", "2");
            }
            new InterstitialAdLoader.Builder().withAdLoadListener((AdLoadListener) new c()).build().loadAd(new InterstitialAdRequest.Builder().withSlotId(str).build());
        }
    }
}
