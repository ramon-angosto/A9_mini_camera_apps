package com.ironsource.mediationsdk.adunit.adapter.listener;

public interface NetworkInitializationListener {
    void onInitFailed(int i, String str);

    void onInitSuccess();
}
