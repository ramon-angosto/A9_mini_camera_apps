package com.ironsource.sdk.h;

import com.ironsource.sdk.utils.IronSourceStorageUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public final class d {
    private String a;

    public d(String str) {
        this.a = str;
    }

    private boolean a(JSONObject jSONObject) {
        return IronSourceStorageUtils.saveFile(jSONObject.toString().getBytes(), b().getPath()) != 0;
    }

    private c b() {
        c cVar = new c(this.a, "metadata.json");
        if (!cVar.exists()) {
            IronSourceStorageUtils.saveFile(new JSONObject().toString().getBytes(), cVar.getPath());
        }
        return cVar;
    }

    public final synchronized JSONObject a() {
        return new JSONObject(IronSourceStorageUtils.readFile(b()));
    }

    public final synchronized boolean a(String str) {
        JSONObject a2 = a();
        if (!a2.has(str)) {
            return true;
        }
        a2.remove(str);
        return a(a2);
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean a(String str, JSONObject jSONObject) {
        JSONObject a2;
        a2 = a();
        a2.put(str, jSONObject);
        return a(a2);
    }

    public final boolean a(ArrayList<c> arrayList) {
        Iterator<c> it = arrayList.iterator();
        boolean z = true;
        while (it.hasNext()) {
            if (!a(it.next().getName())) {
                z = false;
            }
        }
        return z;
    }

    public final synchronized boolean b(String str, JSONObject jSONObject) {
        JSONObject a2;
        a2 = a();
        JSONObject optJSONObject = a2.optJSONObject(str);
        if (optJSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                optJSONObject.putOpt(next, jSONObject.opt(next));
            }
        } else {
            a2.putOpt(str, jSONObject);
        }
        return a(a2);
    }
}
