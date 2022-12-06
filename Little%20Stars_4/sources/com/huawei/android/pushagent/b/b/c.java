package com.huawei.android.pushagent.b.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.android.pushagent.a.a;
import com.huawei.android.pushagent.b.a.b.b;
import com.huawei.android.pushagent.c.a.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class c {
    public static final HashMap a = new HashMap();
    private static c b;
    private HashMap c = new HashMap();
    private Context d = null;

    static {
        c();
    }

    private c(Context context) {
        this.d = context;
        a();
    }

    public static int a(Context context, String str, int i) {
        try {
            Object b2 = b(context, str);
            return b2 == null ? i : ((Integer) b2).intValue();
        } catch (Exception e) {
            e.c("PushLogAC2705", e.toString(), e);
            return i;
        }
    }

    public static long a(Context context, String str, long j) {
        try {
            Object b2 = b(context, str);
            return b2 == null ? j : ((Long) b2).longValue();
        } catch (Exception e) {
            e.c("PushLogAC2705", e.toString(), e);
            return j;
        }
    }

    public static a a(Context context, String str) {
        a aVar;
        if (a(context) == null || str == null || (aVar = (a) b.c.get(str)) == null) {
            return null;
        }
        return aVar;
    }

    public static synchronized c a(Context context) {
        synchronized (c.class) {
            if (b != null) {
                c cVar = b;
                return cVar;
            } else if (context == null) {
                return null;
            } else {
                b = new c(context);
                c cVar2 = b;
                return cVar2;
            }
        }
    }

    public static String a(Context context, String str, String str2) {
        Object b2 = b(context, str);
        if (b2 == null) {
            return str2;
        }
        try {
            return (String) b2;
        } catch (Exception unused) {
            e.a("PushLogAC2705", "getString from config failed!");
            return str2;
        }
    }

    public static void a(Context context, a aVar) {
        if (aVar == null || aVar.a == null) {
            e.d("PushLogAC2705", "set value err, cfg is null or itemName is null, cfg:" + aVar);
        } else if (a(context) == null) {
            e.d("PushLogAC2705", "System init failed in set Value");
        } else {
            b.c.put(aVar.a, aVar);
            b.b(context, aVar);
        }
    }

    public static boolean a(Context context, String str, boolean z) {
        try {
            Object b2 = b(context, str);
            return b2 == null ? z : ((Boolean) b2).booleanValue();
        } catch (Exception e) {
            e.c("PushLogAC2705", e.toString(), e);
            return z;
        }
    }

    public static b.a b(Context context) {
        a a2 = a(context, "USE_SSL");
        b.a aVar = b.a.ChannelType_SSL;
        if (a2 == null) {
            return aVar;
        }
        e.a("PushLogAC2705", " " + a2);
        Integer num = (Integer) a2.b;
        if (num.intValue() >= 0 && num.intValue() < b.a.values().length) {
            return b.a.values()[num.intValue()];
        }
        e.d("PushLogAC2705", "useSSL:" + a2.b + " is invalid cfg");
        return aVar;
    }

    private static Object b(Context context, String str) {
        a aVar;
        if (a(context) == null || (aVar = (a) b.c.get(str)) == null) {
            return null;
        }
        return aVar.b;
    }

    private boolean b(Context context, a aVar) {
        if (context == null) {
            context = this.d;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("pushConfig", 4).edit();
        if (Boolean.class == aVar.c) {
            edit.putBoolean(aVar.a, ((Boolean) aVar.b).booleanValue());
        } else if (String.class == aVar.c) {
            edit.putString(aVar.a, (String) aVar.b);
        } else if (Long.class == aVar.c) {
            edit.putLong(aVar.a, ((Long) aVar.b).longValue());
        } else if (Integer.class == aVar.c) {
            edit.putInt(aVar.a, ((Integer) aVar.b).intValue());
        } else if (Float.class == aVar.c) {
            edit.putFloat(aVar.a, ((Float) aVar.b).floatValue());
        }
        return edit.commit();
    }

    private static void c() {
        a.clear();
        a.put("cloudpush_isLogLocal", new a("cloudpush_isLogLocal", Boolean.class, (Object) false));
        a.put("cloudpush_pushLogLevel", new a("cloudpush_pushLogLevel", Integer.class, (Object) 4));
        a.put("cloudpush_isReportLog", new a("cloudpush_isReportLog", Boolean.class, (Object) false));
        a.put("cloudpush_isNoDelayConnect", new a("cloudpush_isNoDelayConnect", Boolean.class, (Object) false));
        a.put("cloudpush_isSupportUpdate", new a("cloudpush_isSupportUpdate", Boolean.class, (Object) false));
        a.put("cloudpush_isSupportCollectSocketInfo", new a("cloudpush_isSupportCollectSocketInfo", Boolean.class, (Object) false));
        a.put("cloudpush_trsIp", new a("cloudpush_trsIp", String.class, "push.hicloud.com"));
        a.put("cloudpush_fixHeatBeat", new a("cloudpush_fixHeatBeat", String.class, " unit sec"));
        a.put("USE_SSL", new a("USE_SSL", Integer.class, (Object) Integer.valueOf(b.a.ChannelType_SSL.ordinal())));
    }

    private void d() {
        this.c.clear();
        SharedPreferences sharedPreferences = this.d.getSharedPreferences("pushConfig", 4);
        this.c.putAll(a);
        for (Map.Entry next : sharedPreferences.getAll().entrySet()) {
            this.c.put(next.getKey(), new a((String) next.getKey(), (Class) next.getValue().getClass(), next.getValue()));
        }
    }

    public void a() {
        c();
        d();
    }

    public void b() {
        SharedPreferences.Editor edit = this.d.getSharedPreferences("pushConfig", 4).edit();
        Set<String> keySet = this.c.keySet();
        LinkedList linkedList = new LinkedList();
        for (String str : keySet) {
            if (!a.containsKey(str) && !"NeedMyServiceRun".equals(str) && !"votedPackageName".equals(str) && !"version_config".equals(str)) {
                e.a("PushLogAC2705", "item " + str + " remove from " + "pushConfig" + " in deleteNoSysCfg");
                linkedList.add(str);
                edit.remove(str);
            }
        }
        edit.commit();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            this.c.remove((String) it.next());
        }
    }
}
