package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.video.module.MBridgeContainerView;

/* compiled from: JSContainerModule */
public final class k extends d {
    private MBridgeContainerView a;

    public k(MBridgeContainerView mBridgeContainerView) {
        this.a = mBridgeContainerView;
    }

    public final boolean showAlertWebView() {
        super.showAlertWebView();
        MBridgeContainerView mBridgeContainerView = this.a;
        if (mBridgeContainerView != null) {
            return mBridgeContainerView.showAlertWebView();
        }
        return false;
    }

    public final void showVideoClickView(int i) {
        super.showVideoClickView(i);
        MBridgeContainerView mBridgeContainerView = this.a;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.showVideoClickView(i);
        }
    }

    public final void showEndcard(int i) {
        super.showEndcard(i);
        try {
            if (this.a != null) {
                this.a.showEndcard(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void showVideoEndCover() {
        super.showVideoEndCover();
        try {
            if (this.a != null) {
                this.a.showVideoEndCover();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void toggleCloseBtn(int i) {
        super.toggleCloseBtn(i);
        try {
            if (this.a != null) {
                this.a.toggleCloseBtn(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean endCardShowing() {
        try {
            if (this.a != null) {
                return this.a.endCardShowing();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.endCardShowing();
    }

    public final boolean miniCardShowing() {
        try {
            if (this.a != null) {
                return this.a.miniCardShowing();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.miniCardShowing();
    }

    public final void readyStatus(int i) {
        try {
            if (this.a != null) {
                this.a.readyStatus(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.readyStatus(i);
    }

    public final void showMiniCard(int i, int i2, int i3, int i4, int i5) {
        super.showMiniCard(i, i2, i3, i4, i5);
        try {
            if (this.a != null) {
                this.a.showMiniCard(i, i2, i3, i4, i5);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void resizeMiniCard(int i, int i2, int i3) {
        super.resizeMiniCard(i, i2, i3);
        try {
            if (this.a != null) {
                this.a.resizeMiniCard(i, i2, i3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void configurationChanged(int i, int i2, int i3) {
        super.configurationChanged(i, i2, i3);
        try {
            if (this.a != null) {
                this.a.configurationChanged(i, i2, i3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void hideAlertWebview() {
        super.hideAlertWebview();
        MBridgeContainerView mBridgeContainerView = this.a;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.hideAlertWebview();
        }
    }

    public final void ivRewardAdsWithoutVideo(String str) {
        super.ivRewardAdsWithoutVideo(str);
        MBridgeContainerView mBridgeContainerView = this.a;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.ivRewardAdsWithoutVideo(str);
        }
    }
}
