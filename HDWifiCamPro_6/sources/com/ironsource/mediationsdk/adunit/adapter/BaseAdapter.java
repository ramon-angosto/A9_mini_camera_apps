package com.ironsource.mediationsdk.adunit.adapter;

import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterConsentInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterMetaDataInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.List;

public abstract class BaseAdapter implements AdapterDebugInterface, AdapterBaseInterface, AdapterConsentInterface, AdapterMetaDataInterface, AdapterSettingsInterface {
    public LoadWhileShowSupportState getLoadWhileShowSupportedState(NetworkSettings networkSettings) {
        return LoadWhileShowSupportState.NONE;
    }

    public void setAdapterDebug(boolean z) {
    }

    public void setConsent(boolean z) {
    }

    public void setMetaData(String str, List<String> list) {
    }
}
