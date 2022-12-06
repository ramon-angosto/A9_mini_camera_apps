package com.ironsource.mediationsdk.model;

import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.g.d;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public final class i {
    public ArrayList<j> a = new ArrayList<>();
    public j b;
    public d c;
    public JSONObject d;

    public i(d dVar) {
        this.c = dVar;
    }

    public final j a() {
        Iterator<j> it = this.a.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (next.c) {
                return next;
            }
        }
        return this.b;
    }

    public final j a(String str) {
        Iterator<j> it = this.a.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (next.b.equals(str)) {
                return next;
            }
        }
        return null;
    }

    public final String b() {
        JSONObject jSONObject = this.d;
        return (jSONObject == null || TextUtils.isEmpty(jSONObject.optString("adapterName"))) ? IronSourceConstants.SUPERSONIC_CONFIG_NAME : this.d.optString("adapterName");
    }
}
