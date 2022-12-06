package com.bytedance.sdk.component.a;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: PermissionConfigRepository */
class w {
    private final Collection<String> a;
    private final Map<String, v> b;
    private final k c;
    private final Set<a> d;

    /* compiled from: PermissionConfigRepository */
    interface a {
    }

    /* access modifiers changed from: package-private */
    public v a(String str) {
        if (this.a.contains(str) || TextUtils.equals(str, "host")) {
            return a(str, (JSONObject) null);
        }
        throw new IllegalArgumentException("Namespace: " + str + " not registered.");
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        this.d.add(aVar);
    }

    /* access modifiers changed from: package-private */
    public void b(a aVar) {
        this.d.remove(aVar);
    }

    private v a(String str, JSONObject jSONObject) {
        v vVar = this.b.get(str);
        if (vVar == null) {
            v vVar2 = new v(str, this.c.c(), this.c.a(), this.c.b(), jSONObject);
            this.b.put(str, vVar2);
            return vVar2;
        } else if (jSONObject == null) {
            return vVar;
        } else {
            vVar.a(jSONObject);
            return vVar;
        }
    }
}
