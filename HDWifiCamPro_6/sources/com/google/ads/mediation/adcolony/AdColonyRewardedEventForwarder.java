package com.google.ads.mediation.adcolony;

import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.AdColonyInterstitialListener;
import com.adcolony.sdk.AdColonyReward;
import com.adcolony.sdk.AdColonyRewardListener;
import com.adcolony.sdk.AdColonyZone;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class AdColonyRewardedEventForwarder extends AdColonyInterstitialListener implements AdColonyRewardListener {
    private static AdColonyRewardedEventForwarder instance;
    private static HashMap<String, WeakReference<AdColonyRewardedRenderer>> mListeners;

    public static AdColonyRewardedEventForwarder getInstance() {
        if (instance == null) {
            instance = new AdColonyRewardedEventForwarder();
        }
        return instance;
    }

    private AdColonyRewardedEventForwarder() {
        mListeners = new HashMap<>();
    }

    /* access modifiers changed from: package-private */
    public void addListener(String str, AdColonyRewardedRenderer adColonyRewardedRenderer) {
        mListeners.put(str, new WeakReference(adColonyRewardedRenderer));
    }

    private void removeListener(String str) {
        mListeners.remove(str);
    }

    private AdColonyRewardedRenderer getListener(String str) {
        WeakReference weakReference = mListeners.get(str);
        if (weakReference != null) {
            return (AdColonyRewardedRenderer) weakReference.get();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean isListenerAvailable(String str) {
        return getListener(str) != null;
    }

    public void onRequestFilled(AdColonyInterstitial adColonyInterstitial) {
        AdColonyRewardedRenderer listener = getListener(adColonyInterstitial.getZoneID());
        if (listener != null) {
            listener.onRequestFilled(adColonyInterstitial);
        }
    }

    public void onRequestNotFilled(AdColonyZone adColonyZone) {
        AdColonyRewardedRenderer listener = getListener(adColonyZone.getZoneID());
        if (listener != null) {
            listener.onRequestNotFilled(adColonyZone);
            removeListener(adColonyZone.getZoneID());
        }
    }

    public void onExpiring(AdColonyInterstitial adColonyInterstitial) {
        AdColonyRewardedRenderer listener = getListener(adColonyInterstitial.getZoneID());
        if (listener != null) {
            listener.onExpiring(adColonyInterstitial);
        }
    }

    public void onClicked(AdColonyInterstitial adColonyInterstitial) {
        AdColonyRewardedRenderer listener = getListener(adColonyInterstitial.getZoneID());
        if (listener != null) {
            listener.onClicked(adColonyInterstitial);
        }
    }

    public void onOpened(AdColonyInterstitial adColonyInterstitial) {
        AdColonyRewardedRenderer listener = getListener(adColonyInterstitial.getZoneID());
        if (listener != null) {
            listener.onOpened(adColonyInterstitial);
        }
    }

    public void onLeftApplication(AdColonyInterstitial adColonyInterstitial) {
        AdColonyRewardedRenderer listener = getListener(adColonyInterstitial.getZoneID());
        if (listener != null) {
            listener.onLeftApplication(adColonyInterstitial);
        }
    }

    public void onClosed(AdColonyInterstitial adColonyInterstitial) {
        AdColonyRewardedRenderer listener = getListener(adColonyInterstitial.getZoneID());
        if (listener != null) {
            listener.onClosed(adColonyInterstitial);
            removeListener(adColonyInterstitial.getZoneID());
        }
    }

    public void onIAPEvent(AdColonyInterstitial adColonyInterstitial, String str, int i) {
        AdColonyRewardedRenderer listener = getListener(adColonyInterstitial.getZoneID());
        if (listener != null) {
            listener.onIAPEvent(adColonyInterstitial, str, i);
        }
    }

    public void onReward(AdColonyReward adColonyReward) {
        AdColonyRewardedRenderer listener = getListener(adColonyReward.getZoneID());
        if (listener != null) {
            listener.onReward(adColonyReward);
        }
    }
}
