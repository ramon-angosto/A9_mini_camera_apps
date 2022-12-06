package com.huawei.android.pushagent.plugin;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.plugin.a.f;
import com.huawei.android.pushagent.plugin.c.b;
import com.huawei.android.pushagent.plugin.tools.BLocation;

public class PushPlugins {
    private static String a = "PushLogSC2705";
    private Context b;

    public PushPlugins(Context context) {
        this.b = context;
    }

    private void a(long j) {
        BLocation.getInstance(this.b).requestLocation();
        new Thread(new b(this, j)).start();
    }

    /* access modifiers changed from: private */
    public void a(b bVar, f fVar, long j) {
        if (j <= 0 || f.LBS != fVar) {
            e.b(a, "cycle is less than 0, only need to run once");
        } else {
            com.huawei.android.pushagent.plugin.tools.b.a(this.b).b(this.b, fVar);
            bVar.a(this.b, j);
        }
        new c(this.b).a(bVar.a(this.b), bVar.a(), bVar.c());
        bVar.b(this.b, System.currentTimeMillis());
    }

    private void a(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            new Thread(new a(this, str, j)).start();
        } else {
            e.b(a, "tagInfo is empty, cannot report");
        }
    }

    public void closeCyclePlus(int i) {
        try {
            f pluginType = getPluginType(i);
            if (pluginType == null) {
                e.a(a, "enter closeCyclePlus, pluginType is null!");
            } else {
                com.huawei.android.pushagent.plugin.tools.b.a(this.b).a(this.b, pluginType);
            }
        } catch (Exception unused) {
            String str = a;
            e.b(str, "close plus error:" + i);
        }
    }

    public f getPluginType(int i) {
        if (f.LBS.b() == i) {
            return f.LBS;
        }
        if (f.TAG.b() == i) {
            return f.TAG;
        }
        return null;
    }

    public void reportPlus(int i, String str, long j) {
        if (f.LBS.b() == i) {
            a(j);
        } else if (f.TAG.b() == i) {
            a(str, j);
        } else {
            e.b(a, "plusType is error, cannot match any plugin");
        }
    }
}
