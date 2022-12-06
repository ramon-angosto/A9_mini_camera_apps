package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import java.util.Map;

@Deprecated
public interface TTNativeAd extends TTClientBidding {

    @Deprecated
    public interface AdInteractionListener {
        @Deprecated
        void onAdClicked(View view, TTNativeAd tTNativeAd);

        @Deprecated
        void onAdCreativeClick(View view, TTNativeAd tTNativeAd);

        @Deprecated
        void onAdShow(TTNativeAd tTNativeAd);
    }

    @Deprecated
    String getAdCreativeToken();

    @Deprecated
    Bitmap getAdLogo();

    @Deprecated
    View getAdLogoView();

    @Deprecated
    View getAdView();

    @Deprecated
    int getAppCommentNum();

    @Deprecated
    int getAppScore();

    @Deprecated
    int getAppSize();

    @Deprecated
    String getButtonText();

    @Deprecated
    String getDescription();

    @Deprecated
    TTAdDislike getDislikeDialog(Activity activity);

    @Deprecated
    TTAdDislike getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    @Deprecated
    List<FilterWord> getFilterWords();

    @Deprecated
    TTImage getIcon();

    @Deprecated
    List<TTImage> getImageList();

    @Deprecated
    int getImageMode();

    @Deprecated
    int getInteractionType();

    @Deprecated
    Map<String, Object> getMediaExtraInfo();

    @Deprecated
    String getSource();

    @Deprecated
    String getTitle();

    @Deprecated
    TTImage getVideoCoverImage();

    @Deprecated
    void registerViewForInteraction(ViewGroup viewGroup, View view, AdInteractionListener adInteractionListener);

    @Deprecated
    void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, AdInteractionListener adInteractionListener);

    @Deprecated
    void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, AdInteractionListener adInteractionListener);

    @Deprecated
    void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, AdInteractionListener adInteractionListener);

    @Deprecated
    void showPrivacyActivity();
}
