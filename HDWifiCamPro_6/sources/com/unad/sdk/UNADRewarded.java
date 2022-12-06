package com.unad.sdk;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardItem;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.RewardedVideoListener;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.out.MBRewardVideoHandler;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.out.RewardVideoListener;
import com.unad.sdk.dto.AdError;
import com.unad.sdk.dto.AdList;
import com.unad.sdk.dto.SourceVO;
import java.util.ArrayList;
import java.util.Locale;
import sg.bigo.ads.api.AdLoadListener;
import sg.bigo.ads.api.RewardAdInteractionListener;
import sg.bigo.ads.api.RewardVideoAd;
import sg.bigo.ads.api.RewardVideoAdLoader;
import sg.bigo.ads.api.RewardVideoAdRequest;

public class UNADRewarded {
    /* access modifiers changed from: private */
    public String a = "";
    /* access modifiers changed from: private */
    public Activity b;
    private AdList c;
    /* access modifiers changed from: private */
    public AdViewListener d;
    /* access modifiers changed from: private */
    public int e = 1;
    /* access modifiers changed from: private */
    public boolean f = false;
    /* access modifiers changed from: private */
    public RewardedAd g;
    /* access modifiers changed from: private */
    public boolean h = false;
    private SourceVO i;
    /* access modifiers changed from: private */
    public ArrayList<SourceVO> j = new ArrayList<>();
    private boolean k;
    private MBRewardVideoHandler l;
    /* access modifiers changed from: private */
    public RewardVideoAd m;
    /* access modifiers changed from: private */
    public PAGRewardedAd n;
    /* access modifiers changed from: private */
    public boolean o = false;
    /* access modifiers changed from: private */
    public boolean p = true;

    public interface AdViewListener {
        void onAdClicked();

        void onAdClose();

        void onAdFailed(AdError adError);

        void onAdLoaded();

        void onAdOpen();

        void onUserEarnedReward();
    }

    class a extends FullScreenContentCallback {
        a() {
        }

        public void onAdDismissedFullScreenContent() {
            RewardedAd unused = UNADRewarded.this.g = null;
            if (UNADRewarded.this.d != null) {
                UNADRewarded.this.d.onAdClose();
            }
            boolean unused2 = UNADRewarded.this.h = false;
        }

        public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
            RewardedAd unused = UNADRewarded.this.g = null;
            boolean unused2 = UNADRewarded.this.f = false;
            UNADRewarded uNADRewarded = UNADRewarded.this;
            uNADRewarded.a("google", adError.getCode() + "", adError.getMessage());
            boolean unused3 = UNADRewarded.this.h = false;
        }

        public void onAdShowedFullScreenContent() {
            if (UNADRewarded.this.p) {
                b.a().e(UNADRewarded.this.b, UNADRewarded.this.a, "google", (String) null, MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
            }
            if (UNADRewarded.this.d != null) {
                UNADRewarded.this.d.onAdOpen();
            }
        }
    }

    class b implements OnUserEarnedRewardListener {
        b() {
        }

        public void onUserEarnedReward(RewardItem rewardItem) {
            if (UNADRewarded.this.d != null) {
                UNADRewarded.this.d.onUserEarnedReward();
            }
            boolean unused = UNADRewarded.this.h = false;
        }
    }

    class c extends RewardedAdLoadCallback {
        c() {
        }

        /* renamed from: a */
        public void onAdLoaded(RewardedAd rewardedAd) {
            if (UNADRewarded.this.p) {
                b.a().c(UNADRewarded.this.b, UNADRewarded.this.a, "google", (String) null, MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
            }
            RewardedAd unused = UNADRewarded.this.g = rewardedAd;
            if (UNADRewarded.this.d != null) {
                UNADRewarded.this.d.onAdLoaded();
            }
            boolean unused2 = UNADRewarded.this.f = true;
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            if (UNADRewarded.this.p) {
                b.a().b(UNADRewarded.this.b, UNADRewarded.this.a, "google#" + loadAdError.getMessage(), MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3, "google");
            }
            boolean unused = UNADRewarded.this.f = false;
            if (UNADRewarded.this.j.size() <= 0) {
                UNADRewarded.this.a("google", loadAdError.getCode() + "", loadAdError.getMessage() + "");
                return;
            }
            UNADRewarded.this.b();
            boolean unused2 = UNADRewarded.this.h = false;
        }
    }

    class d implements RewardVideoListener {
        d() {
        }

        public void onAdClose(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
            RewardedAd unused = UNADRewarded.this.g = null;
            if (UNADRewarded.this.d != null) {
                UNADRewarded.this.d.onAdClose();
            }
            boolean unused2 = UNADRewarded.this.h = false;
            boolean unused3 = UNADRewarded.this.f = false;
        }

        public void onAdShow(MBridgeIds mBridgeIds) {
            if (UNADRewarded.this.p) {
                b.a().e(UNADRewarded.this.b, UNADRewarded.this.a, "mintegral", (String) null, MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
            }
            if (UNADRewarded.this.d != null) {
                UNADRewarded.this.d.onAdOpen();
            }
        }

        public void onEndcardShow(MBridgeIds mBridgeIds) {
        }

        public void onLoadSuccess(MBridgeIds mBridgeIds) {
        }

        public void onShowFail(MBridgeIds mBridgeIds, String str) {
        }

        public void onVideoAdClicked(MBridgeIds mBridgeIds) {
            if (UNADRewarded.this.d != null) {
                UNADRewarded.this.d.onAdClicked();
            }
            if (UNADRewarded.this.p) {
                b.a().a((Context) UNADRewarded.this.b, UNADRewarded.this.a, "mintegral", (String) null, MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
            }
        }

        public void onVideoComplete(MBridgeIds mBridgeIds) {
            if (UNADRewarded.this.d != null) {
                UNADRewarded.this.d.onUserEarnedReward();
            }
            if (UNADRewarded.this.p) {
                b.a().d(UNADRewarded.this.b, UNADRewarded.this.a, "mintegral", (String) null, MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
            }
            boolean unused = UNADRewarded.this.f = false;
        }

        public void onVideoLoadFail(MBridgeIds mBridgeIds, String str) {
            if (UNADRewarded.this.p) {
                b a2 = b.a();
                Activity b = UNADRewarded.this.b;
                String g = UNADRewarded.this.a;
                a2.b(b, g, "mintegral#" + str, MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3, "mintegral");
            }
            boolean unused = UNADRewarded.this.f = false;
            if (UNADRewarded.this.j.size() <= 0) {
                UNADRewarded uNADRewarded = UNADRewarded.this;
                uNADRewarded.a("mintegral", "-1", str + "");
                return;
            }
            UNADRewarded.this.b();
            boolean unused2 = UNADRewarded.this.h = false;
        }

        public void onVideoLoadSuccess(MBridgeIds mBridgeIds) {
            if (UNADRewarded.this.p) {
                b.a().c(UNADRewarded.this.b, UNADRewarded.this.a, "mintegral", (String) null, MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
            }
            if (UNADRewarded.this.d != null) {
                UNADRewarded.this.d.onAdLoaded();
            }
            boolean unused = UNADRewarded.this.f = true;
        }
    }

    class e implements RewardedVideoListener {
        e() {
        }

        private void a(String str, String str2) {
            if (UNADRewarded.this.p) {
                b.a().b(UNADRewarded.this.b, UNADRewarded.this.a, "bigo#" + str, MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3, "bigo");
            }
            boolean unused = UNADRewarded.this.f = false;
            if (UNADRewarded.this.j.size() <= 0) {
                UNADRewarded.this.a("bigo", str + "", str2 + "");
                return;
            }
            UNADRewarded.this.b();
            boolean unused2 = UNADRewarded.this.h = false;
        }

        public void onRewardedVideoAdClicked(Placement placement) {
            if (UNADRewarded.this.d != null) {
                UNADRewarded.this.d.onAdClicked();
            }
            if (UNADRewarded.this.p) {
                b.a().a((Context) UNADRewarded.this.b, UNADRewarded.this.a, "ironsource", (String) null, MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
            }
        }

        public void onRewardedVideoAdClosed() {
            if (UNADRewarded.this.d != null) {
                UNADRewarded.this.d.onAdClose();
            }
            boolean unused = UNADRewarded.this.h = false;
        }

        public void onRewardedVideoAdEnded() {
        }

        public void onRewardedVideoAdOpened() {
            if (UNADRewarded.this.p) {
                b.a().e(UNADRewarded.this.b, UNADRewarded.this.a, "ironsource", (String) null, MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
            }
            if (UNADRewarded.this.d != null) {
                UNADRewarded.this.d.onAdOpen();
            }
        }

        public void onRewardedVideoAdRewarded(Placement placement) {
            if (UNADRewarded.this.d != null) {
                UNADRewarded.this.d.onUserEarnedReward();
            }
            if (UNADRewarded.this.p) {
                b.a().d(UNADRewarded.this.b, UNADRewarded.this.a, "ironsource", (String) null, MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
            }
        }

        public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
            a(ironSourceError.getErrorCode() + "", ironSourceError.getErrorMessage() + "");
        }

        public void onRewardedVideoAdStarted() {
        }

        public void onRewardedVideoAvailabilityChanged(boolean z) {
            if (z && UNADRewarded.this.e == 4) {
                if (!UNADRewarded.this.o) {
                    boolean unused = UNADRewarded.this.o = true;
                    boolean unused2 = UNADRewarded.this.f = true;
                    if (UNADRewarded.this.p) {
                        b.a().c(UNADRewarded.this.b, UNADRewarded.this.a, "ironsource", (String) null, MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
                    }
                    if (UNADRewarded.this.d != null) {
                        UNADRewarded.this.d.onAdLoaded();
                        return;
                    }
                    return;
                }
                boolean unused3 = UNADRewarded.this.f = false;
            }
        }
    }

    public UNADRewarded(Activity activity) {
        this.b = activity;
    }

    public boolean isLoaded() {
        return this.f;
    }

    public void loadAd() {
        a.a(this.b);
        if (!this.h) {
            this.h = true;
            this.k = false;
            a();
            return;
        }
        Log.i("ADGO_SDK", "已经加载不能重复加载");
    }

    public void setAdUnitId(String str) {
        this.a = str;
    }

    public void setAdViewListener(AdViewListener adViewListener) {
        this.d = adViewListener;
    }

    public void show(Activity activity) {
        PAGRewardedAd pAGRewardedAd;
        RewardVideoAd rewardVideoAd;
        this.h = false;
        int i2 = this.e;
        if (1 == i2) {
            b(activity);
        } else if (2 == i2) {
            a(activity);
        } else if (3 == i2) {
            if (this.b == null || (rewardVideoAd = this.m) == null || rewardVideoAd.isExpired()) {
                a("unadsdk", "A005", this.b.getString(R.string.unad_A005));
            } else {
                this.m.show();
            }
        } else if (4 == i2) {
            if (this.b == null || !IronSource.isRewardedVideoAvailable()) {
                a("unadsdk", "A005", this.b.getString(R.string.unad_A005));
            } else {
                IronSource.showRewardedVideo();
            }
        } else if (5 == i2) {
            Activity activity2 = this.b;
            if (activity2 == null || (pAGRewardedAd = this.n) == null) {
                a("unadsdk", "A005", activity2.getString(R.string.unad_A005));
            } else {
                pAGRewardedAd.show(activity2);
            }
        }
    }

    private void d(String str) {
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
        if (this.p) {
            b.a().a((Context) this.b, this.a, this.k, "mintegral", MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
        }
        MBRewardVideoHandler mBRewardVideoHandler = new MBRewardVideoHandler(this.b, str2, str3);
        this.l = mBRewardVideoHandler;
        mBRewardVideoHandler.playVideoMute(2);
        this.l.setRewardPlus(true);
        this.l.setRewardVideoListener(new d());
        this.l.load();
    }

    private void e(String str) {
        if (str == null) {
            a("unadsdk", "-1", "adid is null");
        } else if (!UNAD.PANGLE_INIT_BOOLEAN) {
            b();
        } else {
            if (this.p) {
                b.a().a((Context) this.b, this.a, this.k, "pangle", MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
            }
            this.f = false;
            this.e = 5;
            PAGRewardedAd.loadAd(str, new PAGRewardedRequest(), new f());
        }
    }

    private void f(String str) {
        Activity activity = this.b;
        if (activity != null) {
            new com.unad.sdk.util.b(activity.getApplicationContext()).a("rewarded_index", str);
        }
    }

    private void b(Activity activity) {
        if (this.g != null) {
            this.g.setFullScreenContentCallback(new a());
            this.g.show(this.b, new b());
            this.g = null;
            return;
        }
        a("unadsdk", "A005", this.b.getString(R.string.unad_A005));
    }

    private void c() {
        if ("google".equals(this.i.getSource())) {
            b(this.i.getId());
        } else if ("mintegral".equals(this.i.getSource())) {
            d(this.i.getId());
        } else if ("bigo".equals(this.i.getSource())) {
            a(this.i.getId());
        } else if ("pangle".equals(this.i.getSource())) {
            e(this.i.getId());
        } else if ("ironsource".equals(this.i.getSource())) {
            c(this.i.getId());
        } else {
            this.f = false;
            this.h = false;
            ArrayList<SourceVO> arrayList = this.j;
            if (arrayList == null || arrayList.size() != 0) {
                if (this.p) {
                    b.a().b(this.b, this.a, "unadsdk# ad type error", MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3, "unadsdk");
                }
                b();
                return;
            }
            a("unadsdk", "-1", "type error ad timed out");
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        this.h = false;
        String str4 = str + "#" + str2 + "#" + str3;
        if (this.p) {
            b.a().b(this.b, this.a, str4, MBridgeConstans.DYNAMIC_VIEW_TYPE_ALTER_NATIVE_STR_4, str);
        }
        AdViewListener adViewListener = this.d;
        if (adViewListener != null) {
            adViewListener.onAdFailed(new AdError(str2, str3));
        }
    }

    class f implements PAGRewardedAdLoadListener {

        class a implements PAGRewardedAdInteractionListener {
            a() {
            }

            public void onAdClicked() {
                if (UNADRewarded.this.d != null) {
                    UNADRewarded.this.d.onAdClicked();
                }
                if (UNADRewarded.this.p) {
                    b.a().a((Context) UNADRewarded.this.b, UNADRewarded.this.a, "pangle", (String) null, MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
                }
            }

            public void onAdDismissed() {
                if (UNADRewarded.this.d != null) {
                    UNADRewarded.this.d.onAdClose();
                }
                boolean unused = UNADRewarded.this.h = false;
                PAGRewardedAd unused2 = UNADRewarded.this.n = null;
            }

            public void onAdShowed() {
                if (UNADRewarded.this.p) {
                    b.a().e(UNADRewarded.this.b, UNADRewarded.this.a, "pangle", (String) null, MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
                }
                if (UNADRewarded.this.d != null) {
                    UNADRewarded.this.d.onAdOpen();
                }
            }

            public void onUserEarnedReward(PAGRewardItem pAGRewardItem) {
                if (UNADRewarded.this.d != null) {
                    UNADRewarded.this.d.onUserEarnedReward();
                }
                if (UNADRewarded.this.p) {
                    b.a().d(UNADRewarded.this.b, UNADRewarded.this.a, "pangle", (String) null, MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
                }
                PAGRewardedAd unused = UNADRewarded.this.n = null;
            }

            public void onUserEarnedRewardFail(int i, String str) {
                if (UNADRewarded.this.d != null) {
                    UNADRewarded.this.d.onAdClose();
                }
                boolean unused = UNADRewarded.this.h = false;
            }
        }

        f() {
        }

        /* renamed from: a */
        public void onAdLoaded(PAGRewardedAd pAGRewardedAd) {
            if (UNADRewarded.this.p) {
                b.a().c(UNADRewarded.this.b, UNADRewarded.this.a, "pangle", (String) null, MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
            }
            if (UNADRewarded.this.d != null) {
                UNADRewarded.this.d.onAdLoaded();
            }
            boolean unused = UNADRewarded.this.f = true;
            PAGRewardedAd unused2 = UNADRewarded.this.n = pAGRewardedAd;
            a();
        }

        public void onError(int i, String str) {
            if (UNADRewarded.this.p) {
                b.a().b(UNADRewarded.this.b, UNADRewarded.this.a, "pangle#" + str, MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3, "pangle");
            }
            boolean unused = UNADRewarded.this.f = false;
            if (UNADRewarded.this.j.size() <= 0) {
                UNADRewarded.this.a("bigo", i + "", str + "");
                return;
            }
            boolean unused2 = UNADRewarded.this.h = false;
            UNADRewarded.this.b();
        }

        private void a() {
            UNADRewarded.this.n.setAdInteractionListener(new a());
        }
    }

    class g implements AdLoadListener<RewardVideoAd> {

        class a implements RewardAdInteractionListener {
            a() {
            }

            public void onAdClicked() {
                if (UNADRewarded.this.d != null) {
                    UNADRewarded.this.d.onAdClicked();
                }
                if (UNADRewarded.this.p) {
                    b.a().a((Context) UNADRewarded.this.b, UNADRewarded.this.a, "bigo", (String) null, MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
                }
            }

            public void onAdClosed() {
                if (UNADRewarded.this.d != null) {
                    UNADRewarded.this.d.onAdClose();
                }
                boolean unused = UNADRewarded.this.h = false;
                if (UNADRewarded.this.m != null) {
                    UNADRewarded.this.m.destroy();
                    RewardVideoAd unused2 = UNADRewarded.this.m = null;
                }
            }

            public void onAdError(sg.bigo.ads.api.AdError adError) {
                if (UNADRewarded.this.p) {
                    b.a().b(UNADRewarded.this.b, UNADRewarded.this.a, "bigo#" + adError.getMessage(), MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3, "bigo");
                }
                boolean unused = UNADRewarded.this.f = false;
                UNADRewarded.this.a("bigo", adError.getCode() + "", adError.getMessage() + "");
                boolean unused2 = UNADRewarded.this.h = false;
                if (UNADRewarded.this.m != null) {
                    UNADRewarded.this.m.destroy();
                    RewardVideoAd unused3 = UNADRewarded.this.m = null;
                }
            }

            public void onAdImpression() {
                if (UNADRewarded.this.p) {
                    b.a().e(UNADRewarded.this.b, UNADRewarded.this.a, "bigo", (String) null, MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
                }
                if (UNADRewarded.this.d != null) {
                    UNADRewarded.this.d.onAdOpen();
                }
            }

            public void onAdOpened() {
            }

            public void onAdRewarded() {
                if (UNADRewarded.this.d != null) {
                    UNADRewarded.this.d.onUserEarnedReward();
                }
                if (UNADRewarded.this.p) {
                    b.a().d(UNADRewarded.this.b, UNADRewarded.this.a, "bigo", (String) null, MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
                }
            }
        }

        g() {
        }

        /* renamed from: a */
        public void onAdLoaded(RewardVideoAd rewardVideoAd) {
            if (UNADRewarded.this.p) {
                b.a().c(UNADRewarded.this.b, UNADRewarded.this.a, "bigo", (String) null, MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
            }
            if (UNADRewarded.this.d != null) {
                UNADRewarded.this.d.onAdLoaded();
            }
            RewardVideoAd unused = UNADRewarded.this.m = rewardVideoAd;
            boolean unused2 = UNADRewarded.this.f = true;
            a();
        }

        public void onError(sg.bigo.ads.api.AdError adError) {
            if (UNADRewarded.this.p) {
                b.a().b(UNADRewarded.this.b, UNADRewarded.this.a, "bigo#" + adError.getMessage(), MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3, "bigo");
            }
            boolean unused = UNADRewarded.this.f = false;
            if (UNADRewarded.this.j.size() <= 0) {
                UNADRewarded.this.a("bigo", adError.getCode() + "", adError.getMessage() + "");
                return;
            }
            UNADRewarded.this.b();
            boolean unused2 = UNADRewarded.this.h = false;
            if (UNADRewarded.this.m != null) {
                UNADRewarded.this.m.destroy();
                RewardVideoAd unused3 = UNADRewarded.this.m = null;
            }
        }

        private void a() {
            UNADRewarded.this.m.setAdInteractionListener((RewardAdInteractionListener) new a());
        }
    }

    private void a(Activity activity) {
        MBRewardVideoHandler mBRewardVideoHandler = this.l;
        if (mBRewardVideoHandler == null || !mBRewardVideoHandler.isReady()) {
            a("unadsdk", "A005", this.b.getString(R.string.unad_A005));
        } else {
            this.l.show();
        }
    }

    private void a() {
        if (this.a == null) {
            a("unadsdk", "A001", this.b.getString(R.string.unad_A001));
            return;
        }
        AdInfo adInfo = a.b;
        if (adInfo == null || adInfo.getAdUnits() == null || adInfo.getAdUnits().size() <= 0 || !MBridgeConstans.ENDCARD_URL_TYPE_PL.equals(adInfo.getStatus())) {
            a("unadsdk", "A002", this.b.getString(R.string.unad_A002));
            return;
        }
        for (AdList next : adInfo.getAdUnits()) {
            if ("Reward".equals(next.getType()) && this.a.equals(next.getAdUnitId())) {
                this.c = next;
            }
        }
        AdList adList = this.c;
        if (adList == null) {
            a("unadsdk", "A003", this.b.getString(R.string.unad_A003));
        } else if (!adList.isEnable()) {
            a("unadsdk", "A004", this.b.getString(R.string.unad_A004));
        } else {
            if (!(this.b == null || this.c.getCountrys() == null || this.c.getCountrys().length() <= 0)) {
                Locale locale = this.b.getResources().getConfiguration().locale;
                if (!this.c.getCountrys().contains((locale.getCountry() + "").toUpperCase())) {
                    a("unadsdk", "A006", this.b.getString(R.string.unad_A006));
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
            int parseInt = Integer.parseInt(new com.unad.sdk.util.b(this.b).b("rewarded_index", MBridgeConstans.ENDCARD_URL_TYPE_PL));
            if (!d.a(this.c, parseInt)) {
                i2 = parseInt;
            }
            try {
                this.p = this.c.isOpenLogs();
            } catch (Exception unused) {
            }
            SourceVO a2 = d.a(this.c, i2, this.b);
            this.i = a2;
            if (a2 == null) {
                a("unadsdk", "A003", this.b.getString(R.string.unad_A003));
                return;
            }
            if (this.j.size() <= 0) {
                this.j = d.a(this.c, this.i);
            }
            c();
            f((i2 + 1) + "");
        }
    }

    private void c(String str) {
        if (str == null) {
            a("unadsdk", "-1", "adid is null");
            return;
        }
        this.e = 4;
        this.f = false;
        if (this.p) {
            b.a().a((Context) this.b, this.a, this.k, "ironsource", MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
        }
        IronSource.init(this.b, str, IronSource.AD_UNIT.REWARDED_VIDEO);
        IronSource.onPause(this.b);
        this.h = false;
        this.o = false;
        IronSource.setRewardedVideoListener(new e());
        IronSource.loadRewardedVideo();
        if (IronSource.isRewardedVideoAvailable()) {
            AdViewListener adViewListener = this.d;
            if (adViewListener != null) {
                adViewListener.onAdLoaded();
            }
            this.o = true;
            this.f = true;
        }
    }

    private void b(String str) {
        this.e = 1;
        if (this.p) {
            b.a().a((Context) this.b, this.a, this.k, "google", MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
        }
        RewardedAd.load((Context) this.b, str, new AdManagerAdRequest.Builder().build(), (RewardedAdLoadCallback) new c());
    }

    /* access modifiers changed from: private */
    public void b() {
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
            if (this.j.size() > 0) {
                this.j.remove(0);
            }
            c();
        }
    }

    private UNADRewarded() {
    }

    private void a(String str) {
        if (str == null) {
            a("unadsdk", "-1", "adid is null");
            return;
        }
        RewardVideoAd rewardVideoAd = this.m;
        if (rewardVideoAd != null) {
            rewardVideoAd.destroy();
            this.m = null;
        }
        this.f = false;
        this.e = 3;
        RewardVideoAdRequest build = new RewardVideoAdRequest.Builder().withSlotId(str).build();
        RewardVideoAdLoader build2 = new RewardVideoAdLoader.Builder().withAdLoadListener((AdLoadListener) new g()).build();
        if (this.p) {
            b.a().a((Context) this.b, this.a, this.k, "bigo", MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
        }
        build2.loadAd(build);
    }
}
