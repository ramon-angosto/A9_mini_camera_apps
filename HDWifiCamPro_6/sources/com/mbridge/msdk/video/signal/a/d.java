package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.video.signal.e;
import com.mbridge.msdk.video.signal.g;

/* compiled from: DefaultJSContainerModule */
public class d implements e, g {
    public void configurationChanged(int i, int i2, int i3) {
    }

    public void showVideoClickView(int i) {
        q.a("js", "showVideoClickView:" + i);
    }

    public void showEndcard(int i) {
        q.a("js", "showEndcard,type=" + i);
    }

    public void showVideoEndCover() {
        q.a("js", "showVideoEndCover");
    }

    public boolean endCardShowing() {
        q.a("js", "endCardShowing");
        return true;
    }

    public boolean miniCardShowing() {
        q.a("js", "miniCardShowing");
        return false;
    }

    public void notifyCloseBtn(int i) {
        q.a("js", "notifyCloseBtn:state = " + i);
    }

    public void toggleCloseBtn(int i) {
        q.a("js", "toggleCloseBtn:state=" + i);
    }

    public void readyStatus(int i) {
        q.a("js", "readyStatus:isReady=" + i);
    }

    public void showMiniCard(int i, int i2, int i3, int i4, int i5) {
        q.a("js", "showMiniCard top = " + i + " left = " + i2 + " width = " + i3 + " height = " + i4 + " radius = " + i5);
    }

    public void resizeMiniCard(int i, int i2, int i3) {
        q.a("js", "showMiniCard width = " + i + " height = " + i2 + " radius = " + i3);
    }

    public boolean showAlertWebView() {
        q.a("js", "showAlertWebView ,msg=");
        return false;
    }

    public void hideAlertWebview() {
        q.a("js", "hideAlertWebview ,msg=");
    }

    public void ivRewardAdsWithoutVideo(String str) {
        q.a("js", "ivRewardAdsWithoutVideo,params=");
    }
}
