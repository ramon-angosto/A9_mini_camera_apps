package com.unad.sdk;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGImageItem;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeRequest;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.out.MBMultiStateEnum;
import com.mbridge.msdk.out.MBNativeAdvancedHandler;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.NativeAdvancedAdListener;
import com.unad.sdk.dto.AdError;
import com.unad.sdk.dto.AdList;
import com.unad.sdk.dto.SourceVO;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UNADFeedAd {
    /* access modifiers changed from: private */
    public String a = "";
    /* access modifiers changed from: private */
    public Activity b;
    /* access modifiers changed from: private */
    public AdList c;
    /* access modifiers changed from: private */
    public AdViewListener d;
    private AdLoader e = null;
    /* access modifiers changed from: private */
    public MBNativeAdvancedHandler f;
    private SourceVO g;
    /* access modifiers changed from: private */
    public ArrayList<SourceVO> h = new ArrayList<>();
    private boolean i;
    /* access modifiers changed from: private */
    public boolean j = false;
    private boolean k;
    /* access modifiers changed from: private */
    public boolean l = true;
    private RequestManager m;

    public interface AdViewListener {
        void onAdClicked();

        void onAdClose();

        void onAdFailed(AdError adError);

        void onAdLoaded(UNADFeedAdView uNADFeedAdView);

        void onAdOpen();
    }

    class a implements PAGNativeAdLoadListener {
        a() {
        }

        /* renamed from: a */
        public void onAdLoaded(PAGNativeAd pAGNativeAd) {
            PAGMediaView mediaView;
            if (pAGNativeAd == null || pAGNativeAd.getNativeAdData() == null) {
                UNADFeedAd.this.a("-1", "pangle ad is nu;ll", "pangle");
                return;
            }
            g gVar = new g(LayoutInflater.from(UNADFeedAd.this.b).inflate(R.layout.unad_new_api_listitem_pangle_feed_ad_view, (ViewGroup) null));
            PAGNativeAdData nativeAdData = pAGNativeAd.getNativeAdData();
            ArrayList arrayList = new ArrayList();
            arrayList.add(gVar.g);
            UNADFeedAd.this.a((f) gVar, (List<View>) arrayList, pAGNativeAd, nativeAdData);
            if (!(gVar.g == null || (mediaView = nativeAdData.getMediaView()) == null || mediaView.getParent() != null)) {
                gVar.g.removeAllViews();
                gVar.g.addView(mediaView);
            }
            if (UNADFeedAd.this.l) {
                b.a().c(UNADFeedAd.this.b, UNADFeedAd.this.c.getAdUnitId(), "pangle", (String) null, "6");
            }
            if (UNADFeedAd.this.d != null) {
                UNADFeedAd.this.d.onAdLoaded(new UNADFeedAdView(UNADFeedAd.this.b, gVar.itemView));
            }
        }

        public void onError(int i, String str) {
            UNADFeedAd uNADFeedAd = UNADFeedAd.this;
            uNADFeedAd.a(i + "", str, "pangle");
        }
    }

    class b implements PAGNativeAdInteractionListener {
        b() {
        }

        public void onAdClicked() {
            if (UNADFeedAd.this.d != null) {
                UNADFeedAd.this.d.onAdClicked();
            }
            if (UNADFeedAd.this.l) {
                b.a().a((Context) UNADFeedAd.this.b, UNADFeedAd.this.a, "pangle", (String) null, "6");
            }
        }

        public void onAdDismissed() {
            if (UNADFeedAd.this.d != null) {
                UNADFeedAd.this.d.onAdClose();
            }
        }

        public void onAdShowed() {
            if (UNADFeedAd.this.d != null) {
                UNADFeedAd.this.d.onAdOpen();
            }
            if (UNADFeedAd.this.l) {
                b.a().e(UNADFeedAd.this.b, UNADFeedAd.this.a, "pangle", (String) null, "6");
            }
        }
    }

    class c extends AdListener {
        c() {
        }

        public void onAdClicked() {
            if (UNADFeedAd.this.d != null) {
                UNADFeedAd.this.d.onAdClicked();
            }
            if (UNADFeedAd.this.l) {
                b.a().a((Context) UNADFeedAd.this.b, UNADFeedAd.this.a, "google", (String) null, "6");
            }
        }

        public void onAdClosed() {
            if (UNADFeedAd.this.d != null) {
                UNADFeedAd.this.d.onAdClose();
            }
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            if (UNADFeedAd.this.l) {
                b.a().b(UNADFeedAd.this.b, UNADFeedAd.this.a, "google#" + loadAdError.getMessage(), "6", "google");
            }
            if (UNADFeedAd.this.h.size() <= 0) {
                UNADFeedAd.this.b("google", loadAdError.getCode() + "", loadAdError.getMessage() + "");
                return;
            }
            UNADFeedAd.this.b();
        }

        public void onAdImpression() {
            if (UNADFeedAd.this.d != null) {
                UNADFeedAd.this.d.onAdOpen();
            }
            if (UNADFeedAd.this.l) {
                b.a().e(UNADFeedAd.this.b, UNADFeedAd.this.a, "google", (String) null, "6");
            }
        }

        public void onAdLoaded() {
        }

        public void onAdOpened() {
        }
    }

    class d implements NativeAd.OnNativeAdLoadedListener {
        d() {
        }

        public void onNativeAdLoaded(NativeAd nativeAd) {
            if (UNADFeedAd.this.l) {
                b.a().c(UNADFeedAd.this.b, UNADFeedAd.this.c.getAdUnitId(), "google", (String) null, "6");
            }
            if (UNADFeedAd.this.d != null) {
                UNADFeedAdView uNADFeedAdView = new UNADFeedAdView(UNADFeedAd.this.b, nativeAd, UNADFeedAd.this.c.getStyle(), UNADFeedAd.this.j);
                if (UNADFeedAd.this.d != null) {
                    UNADFeedAd.this.d.onAdLoaded(uNADFeedAdView);
                }
            }
        }
    }

    class e implements NativeAdvancedAdListener {
        e() {
        }

        public void closeFullScreen(MBridgeIds mBridgeIds) {
        }

        public void onClick(MBridgeIds mBridgeIds) {
            if (UNADFeedAd.this.d != null) {
                UNADFeedAd.this.d.onAdClicked();
            }
            if (UNADFeedAd.this.l) {
                b.a().a((Context) UNADFeedAd.this.b, UNADFeedAd.this.c.getAdUnitId(), "mintegral", (String) null, "6");
            }
        }

        public void onClose(MBridgeIds mBridgeIds) {
            if (UNADFeedAd.this.d != null) {
                UNADFeedAd.this.d.onAdClose();
            }
        }

        public void onLeaveApp(MBridgeIds mBridgeIds) {
        }

        public void onLoadFailed(MBridgeIds mBridgeIds, String str) {
            if (UNADFeedAd.this.l) {
                b a2 = b.a();
                Activity a3 = UNADFeedAd.this.b;
                String g = UNADFeedAd.this.a;
                a2.b(a3, g, "mintegral#" + str, "6", "mintegral");
            }
            if (UNADFeedAd.this.h.size() <= 0) {
                UNADFeedAd.this.b("mintegral", "-1", str);
            } else {
                UNADFeedAd.this.b();
            }
        }

        public void onLoadSuccessed(MBridgeIds mBridgeIds) {
            if (UNADFeedAd.this.l) {
                b.a().c(UNADFeedAd.this.b, UNADFeedAd.this.c.getAdUnitId(), "mintegral", (String) null, "6");
            }
            if (UNADFeedAd.this.d != null) {
                UNADFeedAd.this.d.onAdLoaded(new UNADFeedAdView(UNADFeedAd.this.b, UNADFeedAd.this.f.getAdViewGroup()));
            }
        }

        public void onLogImpression(MBridgeIds mBridgeIds) {
            if (UNADFeedAd.this.d != null) {
                UNADFeedAd.this.d.onAdOpen();
            }
            if (UNADFeedAd.this.l) {
                b.a().e(UNADFeedAd.this.b, UNADFeedAd.this.c.getAdUnitId(), "mintegral", (String) null, "6");
            }
        }

        public void showFullScreen(MBridgeIds mBridgeIds) {
        }
    }

    private static class f extends RecyclerView.ViewHolder {
        ImageView a;
        ImageView b;
        Button c;
        TextView d;
        TextView e;
        RelativeLayout f;

        public f(View view) {
            super(view);
        }
    }

    private static class g extends f {
        FrameLayout g;

        public g(View view) {
            super(view);
            this.b = (ImageView) view.findViewById(R.id.iv_listitem_dislike);
            this.d = (TextView) view.findViewById(R.id.tv_listitem_ad_title);
            this.e = (TextView) view.findViewById(R.id.tv_listitem_ad_desc);
            this.g = (FrameLayout) view.findViewById(R.id.iv_listitem_video);
            this.a = (ImageView) view.findViewById(R.id.iv_listitem_icon);
            this.c = (Button) view.findViewById(R.id.tt_creative_btn);
            this.f = (RelativeLayout) view.findViewById(R.id.tt_ad_logo);
        }
    }

    public UNADFeedAd(Activity activity, String str, AdViewListener adViewListener) {
        this.b = activity;
        this.a = str;
        this.d = adViewListener;
        a.a(activity);
    }

    public void loadAd() {
        this.i = false;
        a();
    }

    public void onPause() {
        MBNativeAdvancedHandler mBNativeAdvancedHandler = this.f;
        if (mBNativeAdvancedHandler != null) {
            mBNativeAdvancedHandler.onPause();
        }
    }

    public void onResume() {
        MBNativeAdvancedHandler mBNativeAdvancedHandler = this.f;
        if (mBNativeAdvancedHandler != null) {
            mBNativeAdvancedHandler.onResume();
        }
    }

    public void release() {
        MBNativeAdvancedHandler mBNativeAdvancedHandler = this.f;
        if (mBNativeAdvancedHandler != null) {
            mBNativeAdvancedHandler.release();
        }
    }

    public void setAdmobRequestCustomMuteThisAd(boolean z) {
        this.k = z;
    }

    public void setAdmobTemplate(boolean z) {
        this.j = z;
    }

    private void c(String str) {
        if (str == null || "".equals(str)) {
            b("unadsdk", "A003", this.b.getString(R.string.unad_A003));
        } else if (!UNAD.PANGLE_INIT_BOOLEAN) {
            b();
        } else {
            this.m = Glide.with(this.b);
            PAGNativeRequest pAGNativeRequest = new PAGNativeRequest();
            if (this.l) {
                b.a().a((Context) this.b, this.a, this.i, "pangle", "6");
            }
            try {
                PAGNativeAd.loadAd(str, pAGNativeRequest, new a());
            } catch (Exception e2) {
                e2.printStackTrace();
                a("-1", " 异常" + e2.toString(), "unadsdk");
            }
        }
    }

    private void d(String str) {
        Activity activity = this.b;
        if (activity != null) {
            new com.unad.sdk.util.b(activity).a("feedad_index", str);
        }
    }

    /* access modifiers changed from: private */
    public void b(String str, String str2, String str3) {
        if (this.l) {
            b.a().b(this.b, this.a, str3, "6", str);
        }
        AdViewListener adViewListener = this.d;
        if (adViewListener != null) {
            adViewListener.onAdFailed(new AdError(str2, str3));
        }
    }

    /* access modifiers changed from: private */
    public void a(f fVar, List<View> list, PAGNativeAd pAGNativeAd, PAGNativeAdData pAGNativeAdData) {
        a(fVar, pAGNativeAd.getNativeAdData());
        ArrayList arrayList = new ArrayList();
        arrayList.add(fVar.itemView);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(fVar.c);
        pAGNativeAd.registerViewForInteraction((ViewGroup) fVar.itemView, arrayList, arrayList2, fVar.b, new b());
        ImageView imageView = fVar.b;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        if (pAGNativeAdData != null) {
            fVar.d.setText(pAGNativeAdData.getTitle());
            fVar.e.setText(pAGNativeAdData.getDescription());
            PAGImageItem icon = pAGNativeAdData.getIcon();
            if (icon != null) {
                this.m.load(icon.getImageUrl()).into(fVar.a);
            }
            fVar.c.setText(pAGNativeAdData.getButtonText());
        }
    }

    private void b(String str) {
        NativeAdOptions nativeAdOptions;
        if (str == null || "".equals(str)) {
            b("unadsdk", "A003", this.b.getString(R.string.unad_A003));
            return;
        }
        if (this.l) {
            b.a().a((Context) this.b, this.a, this.i, "google", "6");
        }
        AdLoader.Builder builder = new AdLoader.Builder(this.b, str);
        builder.forNativeAd(new d()).withAdListener(new c());
        VideoOptions build = new VideoOptions.Builder().setStartMuted(false).build();
        if (this.k) {
            nativeAdOptions = new NativeAdOptions.Builder().setRequestCustomMuteThisAd(true).setVideoOptions(build).build();
        } else {
            nativeAdOptions = new NativeAdOptions.Builder().setVideoOptions(build).build();
        }
        builder.withNativeAdOptions(nativeAdOptions);
        AdLoader build2 = builder.build();
        this.e = build2;
        build2.loadAd(new AdRequest.Builder().build());
    }

    private UNADFeedAd() {
    }

    private void a(f fVar, PAGNativeAdData pAGNativeAdData) {
        if (fVar != null && pAGNativeAdData != null) {
            ImageView imageView = (ImageView) pAGNativeAdData.getAdLogoView();
            RelativeLayout relativeLayout = fVar.f;
            if (relativeLayout != null && imageView != null) {
                relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        if (this.l) {
            b.a().b(this.b, this.a, str3 + "#" + str2, "6", str3);
        }
        if (this.h.size() <= 0) {
            b("google", str + "", str2 + "");
            return;
        }
        b();
    }

    private void c() {
        if ("google".equals(this.g.getSource())) {
            b(this.g.getId());
        } else if ("pangle".equals(this.g.getSource())) {
            c(this.g.getId());
        } else if ("mintegral".equals(this.g.getSource())) {
            try {
                a(this.g.getId());
            } catch (Exception e2) {
                b("unadsdk", "-1", "adgo feed exception mbride:" + e2.toString());
            }
        } else {
            ArrayList<SourceVO> arrayList = this.h;
            if (arrayList == null || arrayList.size() != 0) {
                if (this.l) {
                    b.a().b(this.b, this.a, "unadsdk# ad type error", "6", "unadsdk");
                }
                b();
                return;
            }
            b("unadsdk", "-1", "type error ad timed out");
        }
    }

    private void a(String str) {
        if (!UNAD.MINTEFRAL_INIT_BOOLEAN) {
            b("unadsdk", "-1", "not init");
        } else if (this.b == null) {
            b("unadsdk", "-1", "activity is null");
        } else if (this.c == null) {
            b("unadsdk", "-1", "advo is null");
        } else {
            if (!(str + "").contains("#")) {
                b("unadsdk", "-1", "mintegral id is exception");
                return;
            }
            this.f = new MBNativeAdvancedHandler(this.b, str.split("#")[0], str.split("#")[1]);
            String style = this.c.getStyle();
            if ("imageLeft".equals(style) || "imageRight".equals(style)) {
                this.f.setNativeViewSize(com.unad.sdk.util.a.a(this.b), com.unad.sdk.util.a.a(this.b, 70.0f));
            } else {
                this.f.setNativeViewSize(com.unad.sdk.util.a.a(this.b), com.unad.sdk.util.a.a(this.b, 240.0f));
            }
            this.f.setCloseButtonState(MBMultiStateEnum.positive);
            this.f.setPlayMuteState(1);
            this.f.autoLoopPlay(3);
            this.f.setAdListener(new e());
            this.f.load();
            if (this.l) {
                b.a().a((Context) this.b, this.a, this.i, "mintegral", "6");
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

    private void a() {
        if (this.a == null) {
            b("unadsdk", "A001", this.b.getString(R.string.unad_A001));
            return;
        }
        AdInfo adInfo = a.b;
        if (adInfo == null || adInfo.getAdUnits() == null || adInfo.getAdUnits().size() <= 0 || !MBridgeConstans.ENDCARD_URL_TYPE_PL.equals(adInfo.getStatus())) {
            b("unadsdk", "A002", this.b.getString(R.string.unad_A002));
            return;
        }
        for (AdList next : adInfo.getAdUnits()) {
            if ("Feed".equals(next.getType()) && this.a.equals(next.getAdUnitId())) {
                this.c = next;
            }
        }
        AdList adList = this.c;
        if (adList == null) {
            b("unadsdk", "A003", this.b.getString(R.string.unad_A003));
        } else if (!adList.isEnable()) {
            b("unadsdk", "A004", this.b.getString(R.string.unad_A004));
        } else {
            if (!(this.b == null || this.c.getCountrys() == null || this.c.getCountrys().length() <= 0)) {
                Locale locale = this.b.getResources().getConfiguration().locale;
                if (!this.c.getCountrys().contains((locale.getCountry() + "").toUpperCase())) {
                    if (UNAD.ISOPENTAG) {
                        Log.i("UNAD_SDK", "not font country code");
                    }
                    b("unadsdk", "A006", this.b.getString(R.string.unad_A006));
                    return;
                }
            }
            if (this.c.getAdSource() == null || this.c.getAdSource().isEmpty()) {
                b("unadsdk", "A003", this.b.getString(R.string.unad_A003));
                return;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.c.getAdSource().size(); i3++) {
                if (this.c.getAdSource().get(i3) != null) {
                    this.c.getAdSource().get(i3).setIndex(i3);
                }
            }
            try {
                this.l = this.c.isOpenLogs();
            } catch (Exception unused) {
            }
            int parseInt = Integer.parseInt(new com.unad.sdk.util.b(this.b).b("feedad_index", MBridgeConstans.ENDCARD_URL_TYPE_PL));
            if (!d.a(this.c, parseInt)) {
                i2 = parseInt;
            }
            SourceVO a2 = d.a(this.c, i2, this.b);
            this.g = a2;
            if (a2 == null) {
                b("unadsdk", "A003", this.b.getString(R.string.unad_A003));
                return;
            }
            if (this.h.size() <= 0) {
                this.h = d.a(this.c, this.g);
            }
            c();
            d((i2 + 1) + "");
        }
    }
}
