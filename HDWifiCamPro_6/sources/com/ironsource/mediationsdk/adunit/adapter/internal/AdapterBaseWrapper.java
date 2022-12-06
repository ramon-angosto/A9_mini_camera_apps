package com.ironsource.mediationsdk.adunit.adapter.internal;

import com.ironsource.mediationsdk.model.NetworkSettings;

public class AdapterBaseWrapper {
    AdapterBaseInterface adapterBaseInterface;
    NetworkSettings settings;

    public AdapterBaseWrapper(AdapterBaseInterface adapterBaseInterface2, NetworkSettings networkSettings) {
        this.adapterBaseInterface = adapterBaseInterface2;
        this.settings = networkSettings;
    }

    public AdapterBaseInterface getAdapterBaseInterface() {
        return this.adapterBaseInterface;
    }

    public NetworkSettings getSettings() {
        return this.settings;
    }
}
