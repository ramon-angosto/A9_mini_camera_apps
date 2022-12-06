package com.mbridge.msdk.video.signal.communication;

public interface IVideoCommunication {
    void appendSubView(Object obj, String str);

    void appendViewTo(Object obj, String str);

    void bringViewToFront(Object obj, String str);

    void broadcast(Object obj, String str);

    void cai(Object obj, String str);

    void clearAllCache(Object obj, String str);

    void click(Object obj, String str);

    void closeAd(Object obj, String str);

    void closeVideoOperte(Object obj, String str);

    void closeWeb(Object obj, String str);

    void createNativeEC(Object obj, String str);

    void createPlayerView(Object obj, String str);

    void createSubPlayTemplateView(Object obj, String str);

    void createView(Object obj, String str);

    void createWebview(Object obj, String str);

    void destroyComponent(Object obj, String str);

    void getAllCache(Object obj, String str);

    void getAppSetting(Object obj, String str);

    void getComponentOptions(Object obj, String str);

    void getCurrentProgress(Object obj, String str);

    void getCutout(Object obj, String str);

    void getEncryptPrice(Object obj, String str);

    void getFileInfo(Object obj, String str);

    void getRewardSetting(Object obj, String str);

    void getRewardUnitSetting(Object obj, String str);

    void getSDKInfo(Object obj, String str);

    void getUnitSetting(Object obj, String str);

    void handleNativeObject(Object obj, String str);

    void handlerH5Exception(Object obj, String str);

    void hideView(Object obj, String str);

    void increaseOfferFrequence(Object obj, String str);

    void init(Object obj, String str);

    void insertViewAbove(Object obj, String str);

    void insertViewBelow(Object obj, String str);

    void isSystemResume(Object obj, String str);

    void ivRewardAdsWithoutVideo(Object obj, String str);

    void loadads(Object obj, String str);

    void loadingResourceStatus(Object obj, String str);

    void notifyCloseBtn(Object obj, String str);

    void onlyAppendSubView(Object obj, String str);

    void onlyAppendViewTo(Object obj, String str);

    void onlyInsertViewAbove(Object obj, String str);

    void onlyInsertViewBelow(Object obj, String str);

    void openURL(Object obj, String str);

    void playVideoFinishOperate(Object obj, String str);

    void playerGetMuteState(Object obj, String str);

    void playerMute(Object obj, String str);

    void playerPause(Object obj, String str);

    void playerPlay(Object obj, String str);

    void playerResume(Object obj, String str);

    void playerSetRenderType(Object obj, String str);

    void playerSetSource(Object obj, String str);

    void playerStop(Object obj, String str);

    void playerUnmute(Object obj, String str);

    void playerUpdateFrame(Object obj, String str);

    void preloadSubPlayTemplateView(Object obj, String str);

    void progressBarOperate(Object obj, String str);

    void progressOperate(Object obj, String str);

    void reactDeveloper(Object obj, String str);

    void readyStatus(Object obj, String str);

    void removeCacheItem(Object obj, String str);

    void removeFromSuperView(Object obj, String str);

    void reportUrls(Object obj, String str);

    void setCacheItem(Object obj, String str);

    void setScaleFitXY(Object obj, String str);

    void setSubPlayTemplateInfo(Object obj, String str);

    void setViewAlpha(Object obj, String str);

    void setViewBgColor(Object obj, String str);

    void setViewRect(Object obj, String str);

    void setViewScale(Object obj, String str);

    void showAlertView(Object obj, String str);

    void showVideoClickView(Object obj, String str);

    void showVideoLocation(Object obj, String str);

    void showView(Object obj, String str);

    void soundOperate(Object obj, String str);

    void statistics(Object obj, String str);

    void toggleCloseBtn(Object obj, String str);

    void triggerCloseBtn(Object obj, String str);

    void videoOperate(Object obj, String str);

    void webviewFireEvent(Object obj, String str);

    void webviewGoBack(Object obj, String str);

    void webviewGoForward(Object obj, String str);

    void webviewLoad(Object obj, String str);

    void webviewReload(Object obj, String str);
}
