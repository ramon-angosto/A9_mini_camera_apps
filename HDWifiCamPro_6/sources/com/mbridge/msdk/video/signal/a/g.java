package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.video.signal.i;

/* compiled from: DefaultJSVideoModule */
public class g implements i {
    public int getBorderViewHeight() {
        return 0;
    }

    public int getBorderViewLeft() {
        return 0;
    }

    public int getBorderViewRadius() {
        return 0;
    }

    public int getBorderViewTop() {
        return 0;
    }

    public int getBorderViewWidth() {
        return 0;
    }

    public boolean isH5Canvas() {
        return false;
    }

    public void showVideoLocation(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        q.a("js", "showVideoLocation:marginTop=" + i + ",marginLeft=" + i2 + ",width=" + i3 + ",height=" + i4 + ",radius=" + i5 + ",borderTop=" + i6 + ",borderTop=" + i6 + ",borderLeft=" + i7 + ",borderWidth=" + i8 + ",borderHeight=" + i9);
    }

    public void soundOperate(int i, int i2) {
        q.a("js", "soundOperate:mute=" + i + ",soundViewVisible=" + i2);
    }

    public void soundOperate(int i, int i2, String str) {
        q.a("js", "soundOperate:mute=" + i + ",soundViewVisible=" + i2 + ",pt=" + str);
    }

    public void videoOperate(int i) {
        q.a("js", "videoOperate:" + i);
    }

    public void closeVideoOperate(int i, int i2) {
        q.a("js", "closeOperte:close=" + i + "closeViewVisible=" + i2);
    }

    public void progressOperate(int i, int i2) {
        q.a("js", "progressOperate:progress=" + i + "progressViewVisible=" + i2);
    }

    public void progressBarOperate(int i) {
        q.a("js", "progressBarOperate:progressViewVisible=" + i);
    }

    public String getCurrentProgress() {
        q.a("js", "getCurrentProgress");
        return "{}";
    }

    public void setScaleFitXY(int i) {
        q.a("js", "setScaleFitXY:" + i);
    }

    public void setVisible(int i) {
        q.a("js", "setVisible:" + i);
    }

    public void setCover(boolean z) {
        q.a("js", "setCover:" + z);
    }

    public void notifyCloseBtn(int i) {
        q.a("js", "notifyCloseBtn:" + i);
    }

    public void showIVRewardAlertView(String str) {
        q.a("js", "showAlertView:");
    }

    public void showAlertView() {
        q.a("js", "showAlertView:");
    }

    public void hideAlertView(int i) {
        q.a("js", "hideAlertView:");
    }

    public void alertWebViewShowed() {
        q.a("js", "alertWebViewShowed:");
    }

    public void dismissAllAlert() {
        q.a("js", "dismissAllAlert");
    }

    public void setMiniEndCardState(boolean z) {
        q.a("js", "setMiniEndCardState" + z);
    }
}
