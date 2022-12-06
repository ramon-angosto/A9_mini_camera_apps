package com.ironsource.mediationsdk.adunit.d;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import org.json.JSONObject;

public final class a {
    public IronSource.AD_UNIT a;
    public String b;
    public NetworkSettings c;
    public int d;
    public int e;
    public JSONObject f;
    public String g;
    public int h;
    public String i;

    public a(IronSource.AD_UNIT ad_unit, String str, int i2, JSONObject jSONObject, String str2, int i3, String str3, NetworkSettings networkSettings, int i4) {
        this.a = ad_unit;
        this.b = str;
        this.e = i2;
        this.f = jSONObject;
        this.g = str2;
        this.h = i3;
        this.i = str3;
        this.c = networkSettings;
        this.d = i4;
    }
}
