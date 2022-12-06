package com.ironsource.mediationsdk.adunit.adapter.internal;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.model.NetworkSettings;

public abstract class BaseAdInteractionAdapter<NetworkAdapter extends AdapterBaseInterface, Listener extends AdapterAdInteractionListener> extends BaseAdAdapter<NetworkAdapter, Listener> {
    public BaseAdInteractionAdapter(IronSource.AD_UNIT ad_unit, NetworkSettings networkSettings) {
        super(ad_unit, networkSettings);
    }

    public abstract boolean isAdAvailable(AdData adData);

    public abstract void showAd(AdData adData, Listener listener);
}
