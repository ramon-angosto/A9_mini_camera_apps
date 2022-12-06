package com.vungle.warren.ui;

import com.vungle.warren.model.Placement;
import com.vungle.warren.ui.contract.AdContract;
import com.vungle.warren.utility.ActivityManager;

public class PresenterAppLeftCallback implements ActivityManager.LeftApplicationCallback {
    private final AdContract.AdvertisementPresenter.EventListener bus;
    private final Placement placement;

    public PresenterAppLeftCallback(AdContract.AdvertisementPresenter.EventListener eventListener, Placement placement2) {
        this.bus = eventListener;
        this.placement = placement2;
    }

    public void onLeftApplication() {
        AdContract.AdvertisementPresenter.EventListener eventListener = this.bus;
        if (eventListener != null) {
            Placement placement2 = this.placement;
            eventListener.onNext("open", "adLeftApplication", placement2 == null ? null : placement2.getId());
        }
    }
}
