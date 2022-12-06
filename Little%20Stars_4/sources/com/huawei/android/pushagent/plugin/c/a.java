package com.huawei.android.pushagent.plugin.c;

import android.content.Context;
import com.huawei.android.pushagent.c.a.b;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.plugin.a.d;
import com.huawei.android.pushagent.plugin.a.f;
import com.huawei.android.pushagent.plugin.tools.BLocation;
import org.json.JSONObject;

public class a extends b {
    private int a = f.LBS.b();

    public int a() {
        return f.LBS.b();
    }

    public String a(Context context) {
        if (!b.b(context)) {
            e.b(BLocation.TAG, "simcard unavailable");
            return null;
        }
        com.huawei.android.pushagent.plugin.a.e eVar = new com.huawei.android.pushagent.plugin.a.e(context);
        long g = eVar.g();
        long max = Math.max(1800000, eVar.c());
        if (System.currentTimeMillis() < g + max) {
            e.a(BLocation.TAG, "cannot report lbs twice in " + max);
            return null;
        }
        d a2 = new com.huawei.android.pushagent.plugin.tools.a().a(context);
        if (a2 == null) {
            e.b(BLocation.TAG, "cannot fetch location info");
            return null;
        }
        JSONObject a3 = a2.a();
        if (a3 == null) {
            return null;
        }
        if (a2.b()) {
            this.a = 5;
            e.a(BLocation.TAG, "getReportContent cmd is:" + this.a);
        }
        return a3.toString();
    }

    public String b() {
        return f.LBS.a();
    }

    public int c() {
        return this.a;
    }
}
