package com.ironsource.mediationsdk.adunit.adapter.utility;

import java.util.Map;

public class AdData {
    private final Map<String, Object> mConfiguration;
    private final String mServerData;

    public AdData(String str, Map<String, Object> map) {
        this.mServerData = str;
        this.mConfiguration = map;
    }

    public Boolean getBoolean(String str) {
        return (Boolean) this.mConfiguration.get(str);
    }

    public Map<String, Object> getConfiguration() {
        return this.mConfiguration;
    }

    public Integer getInt(String str) {
        return (Integer) this.mConfiguration.get(str);
    }

    public String getServerData() {
        return this.mServerData;
    }

    public String getString(String str) {
        return (String) this.mConfiguration.get(str);
    }
}
