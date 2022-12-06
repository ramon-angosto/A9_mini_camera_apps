package com.ironsource.mediationsdk.adunit.adapter.internal.listener;

import com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType;

public interface AdapterAdListener {
    void onAdClicked();

    void onAdLoadFailed(AdapterErrorType adapterErrorType, int i, String str);

    void onAdLoadSuccess();
}
