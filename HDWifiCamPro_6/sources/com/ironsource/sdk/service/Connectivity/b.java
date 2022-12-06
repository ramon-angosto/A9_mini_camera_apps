package com.ironsource.sdk.service.Connectivity;

import android.content.Context;
import android.os.Build;
import com.ironsource.environment.c;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONObject;

public abstract class b implements d {
    public c a;

    protected b(JSONObject jSONObject, Context context) {
        c cVar;
        if (jSONObject.optInt("connectivityStrategy") == 1) {
            cVar = new a(this);
        } else {
            cVar = (Build.VERSION.SDK_INT < 23 || !c.b(context, "android.permission.ACCESS_NETWORK_STATE")) ? new a(this) : new e(this);
        }
        this.a = cVar;
        String simpleName = b.class.getSimpleName();
        Logger.i(simpleName, "created ConnectivityAdapter with strategy " + this.a.getClass().getSimpleName());
    }

    public void a() {
    }

    public void a(String str) {
    }

    public void a(String str, JSONObject jSONObject) {
    }
}
