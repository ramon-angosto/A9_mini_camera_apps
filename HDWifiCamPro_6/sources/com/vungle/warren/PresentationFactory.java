package com.vungle.warren;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.ui.CloseDelegate;
import com.vungle.warren.ui.OrientationDelegate;
import com.vungle.warren.ui.contract.AdContract;
import com.vungle.warren.ui.contract.NativeAdContract;
import com.vungle.warren.ui.contract.WebAdContract;
import com.vungle.warren.ui.state.OptionsState;
import com.vungle.warren.ui.view.FullAdWidget;
import com.vungle.warren.ui.view.VungleWebClient;

public interface PresentationFactory {

    public interface FullScreenCallback {
        void onResult(Pair<AdContract.AdView, AdContract.AdvertisementPresenter> pair, VungleException vungleException);
    }

    public interface NativeViewCallback {
        void onResult(Pair<NativeAdContract.NativeView, NativeAdContract.NativePresenter> pair, VungleException vungleException);
    }

    public interface ViewCallback {
        void onResult(Pair<WebAdContract.WebAdPresenter, VungleWebClient> pair, VungleException vungleException);
    }

    void destroy();

    void getBannerViewPresentation(Context context, AdRequest adRequest, AdConfig adConfig, CloseDelegate closeDelegate, ViewCallback viewCallback);

    void getFullScreenPresentation(Context context, AdRequest adRequest, FullAdWidget fullAdWidget, OptionsState optionsState, CloseDelegate closeDelegate, OrientationDelegate orientationDelegate, Bundle bundle, FullScreenCallback fullScreenCallback);

    void getNativeViewPresentation(Context context, NativeAdLayout nativeAdLayout, AdRequest adRequest, AdConfig adConfig, NativeViewCallback nativeViewCallback);

    void saveState(Bundle bundle);
}
