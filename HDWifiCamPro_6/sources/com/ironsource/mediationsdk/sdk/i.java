package com.ironsource.mediationsdk.sdk;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ironsource.mediationsdk.a.c;
import com.ironsource.mediationsdk.a.d;
import com.ironsource.mediationsdk.a.h;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.Date;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class i implements InterstitialListener, RewardedVideoListener, SegmentListener, f {
    public RewardedVideoListener a;
    public InterstitialListener b;
    public OfferwallListener c;
    public SegmentListener d;
    public InterstitialPlacement e = null;
    public String f = null;
    private a g = new a(this, (byte) 0);
    private long h;

    class a extends Thread {
        Handler a;

        private a() {
        }

        /* synthetic */ a(i iVar, byte b2) {
            this();
        }

        public final void run() {
            Looper.prepare();
            this.a = new Handler();
            Looper.loop();
        }
    }

    public i() {
        this.g.start();
        this.h = new Date().getTime();
    }

    private void a(Runnable runnable) {
        Handler handler;
        a aVar = this.g;
        if (aVar != null && (handler = aVar.a) != null) {
            handler.post(runnable);
        }
    }

    private boolean a(Object obj) {
        return (obj == null || this.g == null) ? false : true;
    }

    public final void a(final IronSourceError ironSourceError, Map<String, Object> map) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "onRewardedVideoAdShowFailed(" + ironSourceError.toString() + ")", 1);
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
        try {
            mediationAdditionalData.put(IronSourceConstants.EVENTS_ERROR_CODE, ironSourceError.getErrorCode());
            mediationAdditionalData.put(IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage());
            if (!TextUtils.isEmpty(this.f)) {
                mediationAdditionalData.put("placement", this.f);
            }
            if (map != null) {
                for (String next : map.keySet()) {
                    mediationAdditionalData.put(next, map.get(next));
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        h.e().b(new c(IronSourceConstants.RV_CALLBACK_SHOW_FAILED, mediationAdditionalData));
        if (a((Object) this.a)) {
            a((Runnable) new Runnable() {
                public final void run() {
                    i.this.a.onRewardedVideoAdShowFailed(ironSourceError);
                }
            });
        }
    }

    public final void a(final boolean z, IronSourceError ironSourceError) {
        String str = "onOfferwallAvailable(isAvailable: " + z + ")";
        if (ironSourceError != null) {
            str = str + ", error: " + ironSourceError.getErrorMessage();
        }
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, str, 1);
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
        try {
            mediationAdditionalData.put("status", String.valueOf(z));
            if (ironSourceError != null) {
                mediationAdditionalData.put(IronSourceConstants.EVENTS_ERROR_CODE, ironSourceError.getErrorCode());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        h.e().b(new c(IronSourceConstants.OFFERWALL_AVAILABLE, mediationAdditionalData));
        if (a((Object) this.c)) {
            a((Runnable) new Runnable() {
                public final void run() {
                    i.this.c.onOfferwallAvailable(z);
                }
            });
        }
    }

    public final void a(final boolean z, Map<String, Object> map) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        logger.log(ironSourceTag, "onRewardedVideoAvailabilityChanged(available:" + z + ")", 1);
        long time = new Date().getTime() - this.h;
        this.h = new Date().getTime();
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
        try {
            mediationAdditionalData.put(IronSourceConstants.EVENTS_DURATION, time);
            if (map != null) {
                for (String next : map.keySet()) {
                    mediationAdditionalData.put(next, map.get(next));
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        h.e().b(new c(z ? IronSourceConstants.RV_CALLBACK_AVAILABILITY_TRUE : IronSourceConstants.RV_CALLBACK_AVAILABILITY_FALSE, mediationAdditionalData));
        if (a((Object) this.a)) {
            a((Runnable) new Runnable() {
                public final void run() {
                    i.this.a.onRewardedVideoAvailabilityChanged(z);
                }
            });
        }
    }

    public final void onGetOfferwallCreditsFailed(final IronSourceError ironSourceError) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        logger.log(ironSourceTag, "onGetOfferwallCreditsFailed(" + ironSourceError + ")", 1);
        if (a((Object) this.c)) {
            a((Runnable) new Runnable() {
                public final void run() {
                    i.this.c.onGetOfferwallCreditsFailed(ironSourceError);
                }
            });
        }
    }

    public final void onInterstitialAdClicked() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdClicked()", 1);
        if (a((Object) this.b)) {
            a((Runnable) new Runnable() {
                public final void run() {
                    i.this.b.onInterstitialAdClicked();
                }
            });
        }
    }

    public final void onInterstitialAdClosed() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdClosed()", 1);
        if (a((Object) this.b)) {
            a((Runnable) new Runnable() {
                public final void run() {
                    i.this.b.onInterstitialAdClosed();
                }
            });
        }
    }

    public final void onInterstitialAdLoadFailed(final IronSourceError ironSourceError) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        logger.log(ironSourceTag, "onInterstitialAdLoadFailed(" + ironSourceError + ")", 1);
        if (a((Object) this.b)) {
            a((Runnable) new Runnable() {
                public final void run() {
                    i.this.b.onInterstitialAdLoadFailed(ironSourceError);
                }
            });
        }
    }

    public final void onInterstitialAdOpened() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdOpened()", 1);
        if (a((Object) this.b)) {
            a((Runnable) new Runnable() {
                public final void run() {
                    i.this.b.onInterstitialAdOpened();
                }
            });
        }
    }

    public final void onInterstitialAdReady() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdReady()", 1);
        if (a((Object) this.b)) {
            a((Runnable) new Runnable() {
                public final void run() {
                    i.this.b.onInterstitialAdReady();
                }
            });
        }
    }

    public final void onInterstitialAdShowFailed(final IronSourceError ironSourceError) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        logger.log(ironSourceTag, "onInterstitialAdShowFailed(" + ironSourceError + ")", 1);
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
        try {
            mediationAdditionalData.put(IronSourceConstants.EVENTS_ERROR_CODE, ironSourceError.getErrorCode());
            if (this.e != null && !TextUtils.isEmpty(this.e.getPlacementName())) {
                mediationAdditionalData.put("placement", this.e.getPlacementName());
            }
            if (ironSourceError.getErrorMessage() != null) {
                mediationAdditionalData.put(IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        d.e().b(new c(IronSourceConstants.IS_CALLBACK_AD_SHOW_ERROR, mediationAdditionalData));
        if (a((Object) this.b)) {
            a((Runnable) new Runnable() {
                public final void run() {
                    i.this.b.onInterstitialAdShowFailed(ironSourceError);
                }
            });
        }
    }

    public final void onInterstitialAdShowSucceeded() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdShowSucceeded()", 1);
        if (a((Object) this.b)) {
            a((Runnable) new Runnable() {
                public final void run() {
                    i.this.b.onInterstitialAdShowSucceeded();
                }
            });
        }
    }

    public final boolean onOfferwallAdCredited(int i, int i2, boolean z) {
        OfferwallListener offerwallListener = this.c;
        boolean onOfferwallAdCredited = offerwallListener != null ? offerwallListener.onOfferwallAdCredited(i, i2, z) : false;
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        logger.log(ironSourceTag, "onOfferwallAdCredited(credits:" + i + ", totalCredits:" + i2 + ", totalCreditsFlag:" + z + "):" + onOfferwallAdCredited, 1);
        return onOfferwallAdCredited;
    }

    public final void onOfferwallAvailable(boolean z) {
        a(z, (IronSourceError) null);
    }

    public final void onOfferwallClosed() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onOfferwallClosed()", 1);
        if (a((Object) this.c)) {
            a((Runnable) new Runnable() {
                public final void run() {
                    i.this.c.onOfferwallClosed();
                }
            });
        }
    }

    public final void onOfferwallOpened() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onOfferwallOpened()", 1);
        if (a((Object) this.c)) {
            a((Runnable) new Runnable() {
                public final void run() {
                    i.this.c.onOfferwallOpened();
                }
            });
        }
    }

    public final void onOfferwallShowFailed(final IronSourceError ironSourceError) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        logger.log(ironSourceTag, "onOfferwallShowFailed(" + ironSourceError + ")", 1);
        if (a((Object) this.c)) {
            a((Runnable) new Runnable() {
                public final void run() {
                    i.this.c.onOfferwallShowFailed(ironSourceError);
                }
            });
        }
    }

    public final void onRewardedVideoAdClicked(final Placement placement) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        logger.log(ironSourceTag, "onRewardedVideoAdClicked(" + placement.getPlacementName() + ")", 1);
        if (a((Object) this.a)) {
            a((Runnable) new Runnable() {
                public final void run() {
                    i.this.a.onRewardedVideoAdClicked(placement);
                }
            });
        }
    }

    public final void onRewardedVideoAdClosed() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdClosed()", 1);
        if (a((Object) this.a)) {
            a((Runnable) new Runnable() {
                public final void run() {
                    i.this.a.onRewardedVideoAdClosed();
                }
            });
        }
    }

    public final void onRewardedVideoAdEnded() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdEnded()", 1);
        if (a((Object) this.a)) {
            a((Runnable) new Runnable() {
                public final void run() {
                    i.this.a.onRewardedVideoAdEnded();
                }
            });
        }
    }

    public final void onRewardedVideoAdOpened() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdOpened()", 1);
        if (a((Object) this.a)) {
            a((Runnable) new Runnable() {
                public final void run() {
                    i.this.a.onRewardedVideoAdOpened();
                }
            });
        }
    }

    public final void onRewardedVideoAdRewarded(final Placement placement) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        logger.log(ironSourceTag, "onRewardedVideoAdRewarded(" + placement.toString() + ")", 1);
        if (a((Object) this.a)) {
            a((Runnable) new Runnable() {
                public final void run() {
                    i.this.a.onRewardedVideoAdRewarded(placement);
                }
            });
        }
    }

    public final void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
        a(ironSourceError, (Map<String, Object>) null);
    }

    public final void onRewardedVideoAdStarted() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdStarted()", 1);
        if (a((Object) this.a)) {
            a((Runnable) new Runnable() {
                public final void run() {
                    i.this.a.onRewardedVideoAdStarted();
                }
            });
        }
    }

    public final void onRewardedVideoAvailabilityChanged(boolean z) {
        a(z, (Map<String, Object>) null);
    }

    public final void onSegmentReceived(final String str) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        logger.log(ironSourceTag, "onSegmentReceived(" + str + ")", 1);
        if (a((Object) this.d)) {
            a((Runnable) new Runnable() {
                public final void run() {
                    if (!TextUtils.isEmpty(str)) {
                        i.this.d.onSegmentReceived(str);
                    }
                }
            });
        }
    }
}
