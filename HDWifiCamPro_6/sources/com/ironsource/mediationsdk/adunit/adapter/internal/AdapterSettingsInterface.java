package com.ironsource.mediationsdk.adunit.adapter.internal;

import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.model.NetworkSettings;

public interface AdapterSettingsInterface {
    LoadWhileShowSupportState getLoadWhileShowSupportedState(NetworkSettings networkSettings);
}
