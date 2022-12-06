package com.ironsource.mediationsdk.adunit.adapter.internal.listener;

public interface AdapterAdInteractionListener extends AdapterAdListener {
    void onAdClosed();

    void onAdEnded();

    void onAdOpened();

    void onAdShowFailed(int i, String str);

    void onAdShowSuccess();

    void onAdStarted();

    void onAdVisible();
}
