package com.adcolony.sdk;

public abstract class AdColonyInterstitialListener {
    @Deprecated
    public void onAudioStarted(AdColonyInterstitial adColonyInterstitial) {
    }

    @Deprecated
    public void onAudioStopped(AdColonyInterstitial adColonyInterstitial) {
    }

    public void onClicked(AdColonyInterstitial adColonyInterstitial) {
    }

    public void onClosed(AdColonyInterstitial adColonyInterstitial) {
    }

    public void onExpiring(AdColonyInterstitial adColonyInterstitial) {
    }

    public void onIAPEvent(AdColonyInterstitial adColonyInterstitial, String str, int i) {
    }

    public void onLeftApplication(AdColonyInterstitial adColonyInterstitial) {
    }

    public void onOpened(AdColonyInterstitial adColonyInterstitial) {
    }

    public abstract void onRequestFilled(AdColonyInterstitial adColonyInterstitial);

    public void onRequestNotFilled(AdColonyZone adColonyZone) {
    }
}
