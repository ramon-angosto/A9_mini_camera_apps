package com.ironsource.mediationsdk.adunit.adapter;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.BaseAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdInteractionAdapter;
import com.ironsource.mediationsdk.adunit.adapter.listener.InterstitialAdListener;
import com.ironsource.mediationsdk.model.NetworkSettings;

public abstract class BaseInterstitial<NetworkAdapter extends BaseAdapter> extends BaseAdInteractionAdapter<NetworkAdapter, InterstitialAdListener> {
    public BaseInterstitial(NetworkSettings networkSettings) {
        super(IronSource.AD_UNIT.INTERSTITIAL, networkSettings);
    }
}
