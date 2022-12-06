package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import java.util.List;
import java.util.Map;

@Deprecated
public interface TTNativeExpressAd extends TTClientBidding {

    @Deprecated
    public interface AdInteractionListener extends ExpressAdInteractionListener {
        @Deprecated
        void onAdDismiss();
    }

    @Deprecated
    public interface ExpressAdInteractionListener {
        @Deprecated
        void onAdClicked(View view, int i);

        @Deprecated
        void onAdShow(View view, int i);

        @Deprecated
        void onRenderFail(View view, String str, int i);

        @Deprecated
        void onRenderSuccess(View view, float f, float f2);
    }

    @Deprecated
    void destroy();

    @Deprecated
    String getAdCreativeToken();

    @Deprecated
    View getExpressAdView();

    @Deprecated
    List<FilterWord> getFilterWords();

    @Deprecated
    int getImageMode();

    @Deprecated
    int getInteractionType();

    @Deprecated
    Map<String, Object> getMediaExtraInfo();

    @Deprecated
    a getVideoModel();

    @Deprecated
    void render();

    @Deprecated
    void setCanInterruptVideoPlay(boolean z);

    @Deprecated
    void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback);

    @Deprecated
    void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    @Deprecated
    void setExpressInteractionListener(AdInteractionListener adInteractionListener);

    @Deprecated
    void setExpressInteractionListener(ExpressAdInteractionListener expressAdInteractionListener);

    @Deprecated
    void setSlideIntervalTime(int i);

    @Deprecated
    void showInteractionExpressAd(Activity activity);
}
