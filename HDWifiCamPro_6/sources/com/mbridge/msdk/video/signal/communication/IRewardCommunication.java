package com.mbridge.msdk.video.signal.communication;

public interface IRewardCommunication {
    void cai(Object obj, String str);

    void getEndScreenInfo(Object obj, String str);

    void handlerPlayableException(Object obj, String str);

    void install(Object obj, String str);

    void notifyCloseBtn(Object obj, String str);

    void openURL(Object obj, String str);

    void setOrientation(Object obj, String str);

    void toggleCloseBtn(Object obj, String str);

    void triggerCloseBtn(Object obj, String str);
}
