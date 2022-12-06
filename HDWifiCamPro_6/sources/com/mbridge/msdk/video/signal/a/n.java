package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.video.module.MBridgeVideoView;

/* compiled from: JSVideoModule */
public final class n extends g {
    private MBridgeVideoView a;

    public n(MBridgeVideoView mBridgeVideoView) {
        this.a = mBridgeVideoView;
    }

    public final void showVideoLocation(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        super.showVideoLocation(i, i2, i3, i4, i5, i6, i7, i8, i9);
        MBridgeVideoView mBridgeVideoView = this.a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.showVideoLocation(i, i2, i3, i4, i5, i6, i7, i8, i9);
        }
    }

    public final void soundOperate(int i, int i2) {
        super.soundOperate(i, i2);
        MBridgeVideoView mBridgeVideoView = this.a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.soundOperate(i, i2);
        }
    }

    public final void soundOperate(int i, int i2, String str) {
        super.soundOperate(i, i2, str);
        MBridgeVideoView mBridgeVideoView = this.a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.soundOperate(i, i2, str);
        }
    }

    public final void videoOperate(int i) {
        super.videoOperate(i);
        MBridgeVideoView mBridgeVideoView = this.a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.videoOperate(i);
        }
    }

    public final void closeVideoOperate(int i, int i2) {
        super.closeVideoOperate(i, i2);
        MBridgeVideoView mBridgeVideoView = this.a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.closeVideoOperate(i, i2);
        }
    }

    public final void progressOperate(int i, int i2) {
        super.progressOperate(i, i2);
        MBridgeVideoView mBridgeVideoView = this.a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.progressOperate(i, i2);
        }
    }

    public final void progressBarOperate(int i) {
        super.progressBarOperate(i);
        MBridgeVideoView mBridgeVideoView = this.a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.progressBarOperate(i);
        }
    }

    public final String getCurrentProgress() {
        MBridgeVideoView mBridgeVideoView = this.a;
        if (mBridgeVideoView != null) {
            return mBridgeVideoView.getCurrentProgress();
        }
        return super.getCurrentProgress();
    }

    public final void setVisible(int i) {
        MBridgeVideoView mBridgeVideoView = this.a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setVisible(i);
        } else {
            super.setVisible(i);
        }
    }

    public final void setCover(boolean z) {
        MBridgeVideoView mBridgeVideoView = this.a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setCover(z);
        } else {
            super.setCover(z);
        }
    }

    public final void setScaleFitXY(int i) {
        MBridgeVideoView mBridgeVideoView = this.a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setScaleFitXY(i);
        } else {
            super.setScaleFitXY(i);
        }
    }

    public final boolean isH5Canvas() {
        MBridgeVideoView mBridgeVideoView = this.a;
        if (mBridgeVideoView != null) {
            return mBridgeVideoView.isH5Canvas();
        }
        return super.isH5Canvas();
    }

    public final int getBorderViewWidth() {
        MBridgeVideoView mBridgeVideoView = this.a;
        if (mBridgeVideoView != null) {
            return mBridgeVideoView.getBorderViewWidth();
        }
        return super.getBorderViewWidth();
    }

    public final int getBorderViewHeight() {
        MBridgeVideoView mBridgeVideoView = this.a;
        if (mBridgeVideoView != null) {
            return mBridgeVideoView.getBorderViewHeight();
        }
        return super.getBorderViewHeight();
    }

    public final int getBorderViewRadius() {
        MBridgeVideoView mBridgeVideoView = this.a;
        if (mBridgeVideoView != null) {
            return mBridgeVideoView.getBorderViewRadius();
        }
        return super.getBorderViewRadius();
    }

    public final int getBorderViewTop() {
        MBridgeVideoView mBridgeVideoView = this.a;
        if (mBridgeVideoView != null) {
            return mBridgeVideoView.getBorderViewTop();
        }
        return super.getBorderViewTop();
    }

    public final int getBorderViewLeft() {
        MBridgeVideoView mBridgeVideoView = this.a;
        if (mBridgeVideoView != null) {
            return mBridgeVideoView.getBorderViewLeft();
        }
        return super.getBorderViewLeft();
    }

    public final void showIVRewardAlertView(String str) {
        MBridgeVideoView mBridgeVideoView = this.a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.showIVRewardAlertView(str);
        } else {
            super.showIVRewardAlertView(str);
        }
    }

    public final void hideAlertView(int i) {
        MBridgeVideoView mBridgeVideoView = this.a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.hideAlertView(i);
        } else {
            super.hideAlertView(i);
        }
    }

    public final void alertWebViewShowed() {
        MBridgeVideoView mBridgeVideoView = this.a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.alertWebViewShowed();
        } else {
            super.alertWebViewShowed();
        }
    }

    public final void showAlertView() {
        MBridgeVideoView mBridgeVideoView = this.a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.showAlertView();
        } else {
            super.showAlertView();
        }
    }

    public final void dismissAllAlert() {
        MBridgeVideoView mBridgeVideoView = this.a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.dismissAllAlert();
        } else {
            super.dismissAllAlert();
        }
    }

    public final void setMiniEndCardState(boolean z) {
        MBridgeVideoView mBridgeVideoView = this.a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setMiniEndCardState(z);
        } else {
            super.setMiniEndCardState(z);
        }
    }
}
