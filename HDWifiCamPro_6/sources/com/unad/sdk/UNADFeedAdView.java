package com.unad.sdk;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.unad.sdk.feed.NativeTemplateStyle;
import com.unad.sdk.feed.TemplateView;

public class UNADFeedAdView extends FrameLayout {
    private Context a;
    private String b;
    private View c;
    private NativeAd d;
    LayoutInflater e = null;
    private FrameLayout f = null;
    private boolean g;

    class a extends VideoController.VideoLifecycleCallbacks {
        a(UNADFeedAdView uNADFeedAdView) {
        }

        public void onVideoEnd() {
            super.onVideoEnd();
        }
    }

    public UNADFeedAdView(Context context, View view) {
        super(context);
        this.a = context;
        this.c = view;
        a(context);
    }

    private void a(Context context) {
        this.a = context;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.e = layoutInflater;
        FrameLayout frameLayout = (FrameLayout) layoutInflater.inflate(R.layout.unad_feed_view, this, true);
        this.f = frameLayout;
        frameLayout.removeAllViews();
    }

    public void destroy() {
        NativeAd nativeAd = this.d;
        if (nativeAd != null) {
            nativeAd.destroy();
        }
    }

    public NativeAd getAdmobNative() {
        return this.d;
    }

    public void render(NativeAdView nativeAdView) {
        if (this.g && this.d != null && nativeAdView != null) {
            this.f.removeAllViews();
            this.f.addView(nativeAdView);
        }
    }

    /* access modifiers changed from: protected */
    public void setView(View view) {
        this.f.removeAllViews();
        this.f.addView(view);
    }

    public void render() {
        try {
            if (this.g && this.d != null) {
                return;
            }
            if (this.d != null) {
                NativeTemplateStyle build = new NativeTemplateStyle.Builder().withMainBackgroundColor(new ColorDrawable(getResources().getColor(R.color.gnt_white))).build();
                if (!"imageLeft".equals(this.b)) {
                    if (!"imageRight".equals(this.b)) {
                        NativeAdView nativeAdView = (NativeAdView) LayoutInflater.from(this.a).inflate(R.layout.unad_native_ad_unified, (ViewGroup) null);
                        a(this.d, nativeAdView);
                        this.f.removeAllViews();
                        this.f.addView(nativeAdView);
                        return;
                    }
                }
                TemplateView templateView = (TemplateView) LayoutInflater.from(this.a).inflate(R.layout.unad_feed_model_small, (ViewGroup) null);
                templateView.setStyles(build);
                this.f.removeAllViews();
                this.f.addView(templateView);
                templateView.setNativeAd(this.d);
            } else if (this.c != null) {
                this.f.removeAllViews();
                this.f.addView(this.c);
            }
        } catch (Exception unused) {
        }
    }

    private void a(NativeAd nativeAd, NativeAdView nativeAdView) {
        nativeAdView.setMediaView((MediaView) nativeAdView.findViewById(R.id.ad_media));
        nativeAdView.setHeadlineView(nativeAdView.findViewById(R.id.ad_headline));
        nativeAdView.setBodyView(nativeAdView.findViewById(R.id.ad_body));
        nativeAdView.setCallToActionView(nativeAdView.findViewById(R.id.ad_call_to_action));
        nativeAdView.setIconView(nativeAdView.findViewById(R.id.ad_app_icon));
        nativeAdView.setPriceView(nativeAdView.findViewById(R.id.ad_price));
        nativeAdView.setStarRatingView(nativeAdView.findViewById(R.id.ad_stars));
        nativeAdView.setStoreView(nativeAdView.findViewById(R.id.ad_store));
        nativeAdView.setAdvertiserView(nativeAdView.findViewById(R.id.ad_advertiser));
        ((TextView) nativeAdView.getHeadlineView()).setText(nativeAd.getHeadline());
        nativeAdView.getMediaView().setMediaContent(nativeAd.getMediaContent());
        if (nativeAd.getBody() == null) {
            nativeAdView.getBodyView().setVisibility(4);
        } else {
            nativeAdView.getBodyView().setVisibility(0);
            ((TextView) nativeAdView.getBodyView()).setText(nativeAd.getBody());
        }
        if (nativeAd.getCallToAction() == null) {
            nativeAdView.getCallToActionView().setVisibility(4);
        } else {
            nativeAdView.getCallToActionView().setVisibility(0);
            ((Button) nativeAdView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }
        if (nativeAd.getIcon() == null) {
            nativeAdView.getIconView().setVisibility(8);
        } else {
            ((ImageView) nativeAdView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
            nativeAdView.getIconView().setVisibility(0);
        }
        if (nativeAd.getPrice() == null) {
            nativeAdView.getPriceView().setVisibility(4);
        } else {
            nativeAdView.getPriceView().setVisibility(0);
            ((TextView) nativeAdView.getPriceView()).setText(nativeAd.getPrice());
        }
        if (nativeAd.getStore() == null) {
            nativeAdView.getStoreView().setVisibility(4);
        } else {
            nativeAdView.getStoreView().setVisibility(0);
            ((TextView) nativeAdView.getStoreView()).setText(nativeAd.getStore());
        }
        if (nativeAd.getStarRating() == null) {
            nativeAdView.getStarRatingView().setVisibility(4);
        } else {
            ((RatingBar) nativeAdView.getStarRatingView()).setRating(nativeAd.getStarRating().floatValue());
            nativeAdView.getStarRatingView().setVisibility(0);
        }
        if (nativeAd.getAdvertiser() == null) {
            nativeAdView.getAdvertiserView().setVisibility(4);
        } else {
            ((TextView) nativeAdView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            nativeAdView.getAdvertiserView().setVisibility(0);
        }
        nativeAdView.setNativeAd(nativeAd);
        VideoController videoController = nativeAd.getMediaContent().getVideoController();
        if (videoController.hasVideoContent()) {
            videoController.setVideoLifecycleCallbacks(new a(this));
        }
    }

    public UNADFeedAdView(Context context, NativeAd nativeAd, String str, boolean z) {
        super(context);
        this.d = nativeAd;
        this.a = context;
        this.b = str;
        this.g = z;
        a(context);
    }
}
