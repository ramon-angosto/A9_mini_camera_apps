package com.huawei.android.pushagent.plugin.tools;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.plugin.PushPlugins;
import com.huawei.android.pushagent.plugin.a.f;
import com.huawei.android.pushagent.plugin.c.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class b {
    private static Set a = new HashSet();
    private static b b;
    private Map c = new HashMap();

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (b == null) {
                b = new b();
                b.d(context);
            }
            bVar = b;
        }
        return bVar;
    }

    private void a(Context context, long j) {
        if (a.size() > 0) {
            e.b(BLocation.TAG, "start alarm loop:" + j);
            a.a(context, new Intent("com.huawei.android.push.PLUGIN").putExtra("plusAlarm", "alarm").setPackage(context.getPackageName()), j);
            return;
        }
        e.b(BLocation.TAG, "has no cycle tasks, donot need to set alarm loop");
    }

    private void a(Context context, Set set) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            stringBuffer.append(((f) it.next()).b());
            stringBuffer.append(";");
        }
        new com.huawei.android.pushagent.plugin.a.e(context).a("cyclePluginTypes", (Object) stringBuffer.toString());
    }

    private void b() {
        this.c.put(f.LBS, new com.huawei.android.pushagent.plugin.c.a());
        this.c.put(f.TAG, new c());
    }

    private void d(Context context) {
        b();
        String a2 = new com.huawei.android.pushagent.plugin.a.e(context).a("cyclePluginTypes", "");
        if (!TextUtils.isEmpty(a2)) {
            String[] split = a2.split(";");
            if (split.length > 0) {
                a.clear();
                for (String str : split) {
                    try {
                        a.add(new PushPlugins(context).getPluginType(Integer.parseInt(str)));
                    } catch (NumberFormatException e) {
                        e.c(BLocation.TAG, "convert string to int error:" + str, e);
                    }
                }
                if (a.size() > 0) {
                    a(context, b(context));
                }
            }
        }
    }

    public List a() {
        ArrayList arrayList = new ArrayList();
        for (f fVar : a) {
            arrayList.add(this.c.get(fVar));
        }
        return arrayList;
    }

    public void a(Context context, f fVar) {
        e.b(BLocation.TAG, "close cycle task:" + fVar.a());
        a.remove(fVar);
        a(context, a);
        if (a.size() < 1) {
            a.a(context, new Intent("com.huawei.android.push.PLUGIN").setPackage(context.getPackageName()));
        }
    }

    public long b(Context context) {
        com.huawei.android.pushagent.plugin.a.e eVar = new com.huawei.android.pushagent.plugin.a.e(context);
        long c2 = eVar.c();
        if (0 == c2) {
            c2 = eVar.d();
            long e = eVar.e();
            if (c2 <= 0 && e <= 0) {
                c2 = 1800000;
            } else if (c2 <= 0) {
                c2 = e;
            }
            eVar.a(c2);
        }
        return c2;
    }

    public void b(Context context, f fVar) {
        e.b(BLocation.TAG, "open cycle task:" + fVar.a());
        a.add(fVar);
        a(context, a);
        if (a.size() == 1) {
            a(context, b(context));
        } else {
            e.a(BLocation.TAG, "already exist cycle tasks");
        }
    }

    public void c(Context context) {
        e.b(BLocation.TAG, "close all cycle task");
        a.clear();
        new com.huawei.android.pushagent.plugin.a.e(context).e("cyclePluginTypes");
        a.a(context, new Intent("com.huawei.android.push.PLUGIN").setPackage(context.getPackageName()));
    }
}
