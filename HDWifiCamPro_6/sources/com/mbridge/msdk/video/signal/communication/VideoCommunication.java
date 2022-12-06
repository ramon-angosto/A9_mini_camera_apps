package com.mbridge.msdk.video.signal.communication;

import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;

public class VideoCommunication extends BaseVideoCommunication {
    private Handler e = new Handler(Looper.getMainLooper());

    public void init(final Object obj, final String str) {
        if (u.b()) {
            super.init(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.init(obj, str);
                }
            });
        }
    }

    public void click(final Object obj, final String str) {
        if (u.b()) {
            super.click(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.click(obj, str);
                }
            });
        }
    }

    public void statistics(final Object obj, final String str) {
        if (u.b()) {
            super.statistics(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.statistics(obj, str);
                }
            });
        }
    }

    public void triggerCloseBtn(final Object obj, final String str) {
        if (u.b()) {
            super.triggerCloseBtn(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.triggerCloseBtn(obj, str);
                }
            });
        }
    }

    public void showVideoLocation(final Object obj, final String str) {
        if (u.b()) {
            super.showVideoLocation(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.showVideoLocation(obj, str);
                }
            });
        }
    }

    public void soundOperate(final Object obj, final String str) {
        if (u.b()) {
            super.soundOperate(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.soundOperate(obj, str);
                }
            });
        }
    }

    public void videoOperate(final Object obj, final String str) {
        if (u.b()) {
            super.videoOperate(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.videoOperate(obj, str);
                }
            });
        }
    }

    public void closeVideoOperte(final Object obj, final String str) {
        if (u.b()) {
            super.closeVideoOperte(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.closeVideoOperte(obj, str);
                }
            });
        }
    }

    public void progressOperate(final Object obj, final String str) {
        if (u.b()) {
            super.progressOperate(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.progressOperate(obj, str);
                }
            });
        }
    }

    public void progressBarOperate(final Object obj, final String str) {
        if (u.b()) {
            super.progressBarOperate(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.progressBarOperate(obj, str);
                }
            });
        }
    }

    public void getCurrentProgress(final Object obj, final String str) {
        if (u.b()) {
            super.getCurrentProgress(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.getCurrentProgress(obj, str);
                }
            });
        }
    }

    public void showVideoClickView(final Object obj, final String str) {
        if (u.b()) {
            super.showVideoClickView(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.showVideoClickView(obj, str);
                }
            });
        }
    }

    public void setScaleFitXY(final Object obj, final String str) {
        if (u.b()) {
            super.setScaleFitXY(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.setScaleFitXY(obj, str);
                }
            });
        }
    }

    public void notifyCloseBtn(final Object obj, final String str) {
        if (u.b()) {
            super.notifyCloseBtn(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.notifyCloseBtn(obj, str);
                }
            });
        }
    }

    public void toggleCloseBtn(final Object obj, final String str) {
        if (u.b()) {
            super.toggleCloseBtn(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.toggleCloseBtn(obj, str);
                }
            });
        }
    }

    public void handlerH5Exception(final Object obj, final String str) {
        if (u.b()) {
            super.handlerH5Exception(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.handlerH5Exception(obj, str);
                }
            });
        }
    }

    public void isSystemResume(final Object obj, final String str) {
        if (u.b()) {
            super.isSystemResume(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.isSystemResume(obj, str);
                }
            });
        }
    }

    public void readyStatus(final Object obj, final String str) {
        q.b("JS-Video-Brigde", "VIDEOBridge readyStatus");
        if (u.b()) {
            super.readyStatus(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.readyStatus(obj, str);
                }
            });
        }
    }

    public void playVideoFinishOperate(final Object obj, final String str) {
        if (u.b()) {
            super.playVideoFinishOperate(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.playVideoFinishOperate(obj, str);
                }
            });
        }
    }

    public void openURL(final Object obj, final String str) {
        if (u.b()) {
            super.openURL(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.openURL(obj, str);
                }
            });
        }
    }

    public void showAlertView(final Object obj, final String str) {
        if (u.b()) {
            super.showAlertView(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.showAlertView(obj, str);
                }
            });
        }
    }

    public void closeWeb(final Object obj, final String str) {
        if (u.b()) {
            super.closeWeb(obj, str);
            return;
        }
        this.e.post(new Runnable() {
            public final void run() {
                VideoCommunication.super.closeWeb(obj, str);
            }
        });
        q.d("JS-Video-Brigde", "type" + str);
    }

    public void getSDKInfo(final Object obj, final String str) {
        if (u.b()) {
            super.getSDKInfo(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.getSDKInfo(obj, str);
                }
            });
        }
    }

    public void getFileInfo(final Object obj, final String str) {
        if (u.b()) {
            super.getFileInfo(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.getFileInfo(obj, str);
                }
            });
        }
    }

    public void loadads(final Object obj, final String str) {
        if (u.b()) {
            super.loadads(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.loadads(obj, str);
                }
            });
        }
    }

    public void reactDeveloper(final Object obj, final String str) {
        if (u.b()) {
            super.reactDeveloper(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.reactDeveloper(obj, str);
                }
            });
        }
    }

    public void reportUrls(final Object obj, final String str) {
        if (u.b()) {
            super.reportUrls(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.reportUrls(obj, str);
                }
            });
        }
    }

    public void createWebview(final Object obj, final String str) {
        if (u.b()) {
            super.createWebview(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.createWebview(obj, str);
                }
            });
        }
    }

    public void createView(final Object obj, final String str) {
        if (u.b()) {
            super.createView(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.createView(obj, str);
                }
            });
        }
    }

    public void createPlayerView(final Object obj, final String str) {
        if (u.b()) {
            super.createPlayerView(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.createPlayerView(obj, str);
                }
            });
        }
    }

    public void createSubPlayTemplateView(final Object obj, final String str) {
        if (u.b()) {
            super.createSubPlayTemplateView(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.createSubPlayTemplateView(obj, str);
                }
            });
        }
    }

    public void destroyComponent(final Object obj, final String str) {
        if (u.b()) {
            super.destroyComponent(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.destroyComponent(obj, str);
                }
            });
        }
    }

    public void getComponentOptions(final Object obj, final String str) {
        if (u.b()) {
            super.getComponentOptions(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.getComponentOptions(obj, str);
                }
            });
        }
    }

    public void setViewRect(final Object obj, final String str) {
        if (u.b()) {
            super.setViewRect(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.setViewRect(obj, str);
                }
            });
        }
    }

    public void removeFromSuperView(final Object obj, final String str) {
        if (u.b()) {
            super.removeFromSuperView(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.removeFromSuperView(obj, str);
                }
            });
        }
    }

    public void appendSubView(final Object obj, final String str) {
        if (u.b()) {
            super.appendSubView(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.appendSubView(obj, str);
                }
            });
        }
    }

    public void appendViewTo(final Object obj, final String str) {
        if (u.b()) {
            super.appendViewTo(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.appendViewTo(obj, str);
                }
            });
        }
    }

    public void onlyAppendSubView(final Object obj, final String str) {
        if (u.b()) {
            super.onlyAppendSubView(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.onlyAppendSubView(obj, str);
                }
            });
        }
    }

    public void onlyAppendViewTo(final Object obj, final String str) {
        if (u.b()) {
            super.onlyAppendViewTo(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.onlyAppendViewTo(obj, str);
                }
            });
        }
    }

    public void bringViewToFront(final Object obj, final String str) {
        if (u.b()) {
            super.bringViewToFront(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.bringViewToFront(obj, str);
                }
            });
        }
    }

    public void hideView(final Object obj, final String str) {
        if (u.b()) {
            super.hideView(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.hideView(obj, str);
                }
            });
        }
    }

    public void showView(final Object obj, final String str) {
        if (u.b()) {
            super.showView(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.showView(obj, str);
                }
            });
        }
    }

    public void setViewBgColor(final Object obj, final String str) {
        if (u.b()) {
            super.setViewBgColor(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.setViewBgColor(obj, str);
                }
            });
        }
    }

    public void setViewAlpha(final Object obj, final String str) {
        if (u.b()) {
            super.setViewAlpha(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.setViewAlpha(obj, str);
                }
            });
        }
    }

    public void setViewScale(final Object obj, final String str) {
        if (u.b()) {
            super.setViewScale(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.setViewScale(obj, str);
                }
            });
        }
    }

    public void insertViewAbove(final Object obj, final String str) {
        if (u.b()) {
            super.insertViewAbove(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.insertViewAbove(obj, str);
                }
            });
        }
    }

    public void insertViewBelow(final Object obj, final String str) {
        if (u.b()) {
            super.insertViewBelow(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.insertViewBelow(obj, str);
                }
            });
        }
    }

    public void onlyInsertViewAbove(final Object obj, final String str) {
        if (u.b()) {
            super.onlyInsertViewAbove(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.onlyInsertViewAbove(obj, str);
                }
            });
        }
    }

    public void onlyInsertViewBelow(final Object obj, final String str) {
        if (u.b()) {
            super.onlyInsertViewBelow(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.onlyInsertViewBelow(obj, str);
                }
            });
        }
    }

    public void webviewLoad(final Object obj, final String str) {
        if (u.b()) {
            super.webviewLoad(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.webviewLoad(obj, str);
                }
            });
        }
    }

    public void webviewReload(final Object obj, final String str) {
        if (u.b()) {
            super.webviewReload(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.webviewReload(obj, str);
                }
            });
        }
    }

    public void webviewGoBack(final Object obj, final String str) {
        if (u.b()) {
            super.webviewGoBack(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.webviewGoBack(obj, str);
                }
            });
        }
    }

    public void webviewGoForward(final Object obj, final String str) {
        if (u.b()) {
            super.webviewGoForward(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.webviewGoForward(obj, str);
                }
            });
        }
    }

    public void playerPlay(final Object obj, final String str) {
        if (u.b()) {
            super.playerPlay(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.playerPlay(obj, str);
                }
            });
        }
    }

    public void playerPause(final Object obj, final String str) {
        if (u.b()) {
            super.playerPause(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.playerPause(obj, str);
                }
            });
        }
    }

    public void playerResume(final Object obj, final String str) {
        if (u.b()) {
            super.playerResume(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.playerResume(obj, str);
                }
            });
        }
    }

    public void playerStop(final Object obj, final String str) {
        if (u.b()) {
            super.playerStop(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.playerStop(obj, str);
                }
            });
        }
    }

    public void playerUpdateFrame(final Object obj, final String str) {
        if (u.b()) {
            super.playerUpdateFrame(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.playerUpdateFrame(obj, str);
                }
            });
        }
    }

    public void playerMute(final Object obj, final String str) {
        if (u.b()) {
            super.playerMute(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.playerMute(obj, str);
                }
            });
        }
    }

    public void playerUnmute(final Object obj, final String str) {
        if (u.b()) {
            super.playerUnmute(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.playerUnmute(obj, str);
                }
            });
        }
    }

    public void playerGetMuteState(final Object obj, final String str) {
        if (u.b()) {
            super.playerGetMuteState(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.playerGetMuteState(obj, str);
                }
            });
        }
    }

    public void playerSetSource(final Object obj, final String str) {
        if (u.b()) {
            super.playerSetSource(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.playerSetSource(obj, str);
                }
            });
        }
    }

    public void playerSetRenderType(final Object obj, final String str) {
        if (u.b()) {
            super.playerSetRenderType(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.playerSetRenderType(obj, str);
                }
            });
        }
    }

    public void preloadSubPlayTemplateView(final Object obj, final String str) {
        if (u.b()) {
            super.preloadSubPlayTemplateView(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.preloadSubPlayTemplateView(obj, str);
                }
            });
        }
    }

    public void closeAd(final Object obj, final String str) {
        if (u.b()) {
            super.closeAd(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.closeAd(obj, str);
                }
            });
        }
    }

    public void broadcast(final Object obj, final String str) {
        if (u.b()) {
            super.broadcast(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.broadcast(obj, str);
                }
            });
        }
    }

    public void ivRewardAdsWithoutVideo(final Object obj, final String str) {
        if (u.b()) {
            super.ivRewardAdsWithoutVideo(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.ivRewardAdsWithoutVideo(obj, str);
                }
            });
        }
    }

    public void setSubPlayTemplateInfo(final Object obj, final String str) {
        if (u.b()) {
            super.setSubPlayTemplateInfo(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.setSubPlayTemplateInfo(obj, str);
                }
            });
        }
    }

    public void webviewFireEvent(final Object obj, final String str) {
        if (u.b()) {
            super.webviewFireEvent(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.webviewFireEvent(obj, str);
                }
            });
        }
    }

    public void increaseOfferFrequence(final Object obj, final String str) {
        if (u.b()) {
            super.increaseOfferFrequence(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.increaseOfferFrequence(obj, str);
                }
            });
        }
    }

    public void handleNativeObject(final Object obj, final String str) {
        if (u.b()) {
            super.handleNativeObject(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.handleNativeObject(obj, str);
                }
            });
        }
    }

    public void loadingResourceStatus(final Object obj, final String str) {
        if (u.b()) {
            super.loadingResourceStatus(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.loadingResourceStatus(obj, str);
                }
            });
        }
    }

    public void createNativeEC(final Object obj, final String str) {
        if (u.b()) {
            super.createNativeEC(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.createNativeEC(obj, str);
                }
            });
        }
    }

    public void setCacheItem(final Object obj, final String str) {
        if (u.b()) {
            super.setCacheItem(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.setCacheItem(obj, str);
                }
            });
        }
    }

    public void removeCacheItem(final Object obj, final String str) {
        if (u.b()) {
            super.removeCacheItem(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.removeCacheItem(obj, str);
                }
            });
        }
    }

    public void getAllCache(final Object obj, final String str) {
        if (u.b()) {
            super.getAllCache(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.getAllCache(obj, str);
                }
            });
        }
    }

    public void clearAllCache(final Object obj, final String str) {
        if (u.b()) {
            super.clearAllCache(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.clearAllCache(obj, str);
                }
            });
        }
    }

    public void getCutout(final Object obj, final String str) {
        if (u.b()) {
            super.getCutout(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.getCutout(obj, str);
                }
            });
        }
    }

    public void getAppSetting(final Object obj, final String str) {
        if (u.b()) {
            super.getAppSetting(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.getAppSetting(obj, str);
                }
            });
        }
    }

    public void getRewardSetting(final Object obj, final String str) {
        if (u.b()) {
            super.getRewardSetting(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.getRewardSetting(obj, str);
                }
            });
        }
    }

    public void getRewardUnitSetting(final Object obj, final String str) {
        if (u.b()) {
            super.getRewardUnitSetting(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.getRewardUnitSetting(obj, str);
                }
            });
        }
    }

    public void getUnitSetting(final Object obj, final String str) {
        if (u.b()) {
            super.getUnitSetting(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.getUnitSetting(obj, str);
                }
            });
        }
    }

    public void getEncryptPrice(final Object obj, final String str) {
        if (u.b()) {
            super.getEncryptPrice(obj, str);
        } else {
            this.e.post(new Runnable() {
                public final void run() {
                    VideoCommunication.super.getEncryptPrice(obj, str);
                }
            });
        }
    }
}
