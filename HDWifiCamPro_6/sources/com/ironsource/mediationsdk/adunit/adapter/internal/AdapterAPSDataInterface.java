package com.ironsource.mediationsdk.adunit.adapter.internal;

import com.ironsource.mediationsdk.IronSource;
import org.json.JSONObject;

public interface AdapterAPSDataInterface {
    void setAPSData(IronSource.AD_UNIT ad_unit, JSONObject jSONObject);
}
