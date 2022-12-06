package com.vungle.warren.ui.view;

import android.content.Context;
import android.view.MotionEvent;
import com.vungle.warren.ui.CloseDelegate;
import com.vungle.warren.ui.OrientationDelegate;
import com.vungle.warren.ui.contract.WebAdContract;

public class MRAIDAdView extends BaseAdView<WebAdContract.WebAdPresenter> implements WebAdContract.WebAdView {
    private OnViewTouchListener onViewTouchListener = new OnViewTouchListener() {
        public boolean onTouch(MotionEvent motionEvent) {
            if (MRAIDAdView.this.presenter == null) {
                return false;
            }
            MRAIDAdView.this.presenter.onViewTouched(motionEvent);
            return false;
        }
    };
    /* access modifiers changed from: private */
    public WebAdContract.WebAdPresenter presenter;

    public MRAIDAdView(Context context, FullAdWidget fullAdWidget, OrientationDelegate orientationDelegate, CloseDelegate closeDelegate) {
        super(context, fullAdWidget, orientationDelegate, closeDelegate);
        attachListeners();
    }

    public void updateWindow() {
        this.view.updateWindow();
    }

    public void setVisibility(boolean z) {
        this.view.setVisibility(z ? 0 : 8);
    }

    public void setPresenter(WebAdContract.WebAdPresenter webAdPresenter) {
        this.presenter = webAdPresenter;
    }

    public void showWebsite(String str) {
        this.view.showWebsite(str);
    }

    private void attachListeners() {
        this.view.setOnViewTouchListener(this.onViewTouchListener);
    }
}
