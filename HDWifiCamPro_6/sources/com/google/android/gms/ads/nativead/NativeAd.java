package com.google.android.gms.ads.nativead;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public abstract class NativeAd {

    /* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
    public static abstract class AdChoicesInfo {
        public abstract List<Image> getImages();

        public abstract CharSequence getText();
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
    public static abstract class Image {
        public abstract Drawable getDrawable();

        public abstract double getScale();

        public abstract Uri getUri();
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
    public interface OnNativeAdLoadedListener {
        void onNativeAdLoaded(NativeAd nativeAd);
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
    public interface UnconfirmedClickListener {
        void onUnconfirmedClickCancelled();

        void onUnconfirmedClickReceived(String str);
    }

    public abstract void cancelUnconfirmedClick();

    public abstract void destroy();

    public abstract void enableCustomClickGesture();

    public abstract AdChoicesInfo getAdChoicesInfo();

    public abstract String getAdvertiser();

    public abstract String getBody();

    public abstract String getCallToAction();

    public abstract Bundle getExtras();

    public abstract String getHeadline();

    public abstract Image getIcon();

    public abstract List<Image> getImages();

    public abstract MediaContent getMediaContent();

    public abstract List<MuteThisAdReason> getMuteThisAdReasons();

    public abstract String getPrice();

    public abstract ResponseInfo getResponseInfo();

    public abstract Double getStarRating();

    public abstract String getStore();

    public abstract boolean isCustomClickGestureEnabled();

    public abstract boolean isCustomMuteThisAdEnabled();

    public abstract void muteThisAd(MuteThisAdReason muteThisAdReason);

    public abstract void performClick(Bundle bundle);

    public abstract void recordCustomClickGesture();

    public abstract boolean recordImpression(Bundle bundle);

    public abstract void reportTouchEvent(Bundle bundle);

    public abstract void setMuteThisAdListener(MuteThisAdListener muteThisAdListener);

    public abstract void setOnPaidEventListener(OnPaidEventListener onPaidEventListener);

    public abstract void setUnconfirmedClickListener(UnconfirmedClickListener unconfirmedClickListener);

    /* access modifiers changed from: protected */
    public abstract Object zza();
}
