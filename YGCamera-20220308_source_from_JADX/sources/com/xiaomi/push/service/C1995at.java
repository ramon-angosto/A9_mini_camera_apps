package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1613af;
import com.xiaomi.push.C1660bl;
import com.xiaomi.push.C1873ht;
import com.xiaomi.push.C1874hu;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.push.service.at */
public class C1995at {

    /* renamed from: a */
    private static volatile C1995at f3716a;

    /* renamed from: a */
    protected SharedPreferences f3717a;

    /* renamed from: a */
    private HashSet<C1996a> f3718a = new HashSet<>();

    /* renamed from: b */
    protected SharedPreferences f3719b;

    /* renamed from: com.xiaomi.push.service.at$a */
    public static abstract class C1996a implements Runnable {
        private String mDescription;
        private int mId;

        public C1996a(int i, String str) {
            this.mId = i;
            this.mDescription = str;
        }

        public boolean equals(Object obj) {
            return (obj instanceof C1996a) && this.mId == ((C1996a) obj).mId;
        }

        public int hashCode() {
            return this.mId;
        }

        /* access modifiers changed from: protected */
        public abstract void onCallback();

        public final void run() {
            onCallback();
        }
    }

    private C1995at(Context context) {
        this.f3717a = context.getSharedPreferences("mipush_oc_normal", 0);
        this.f3719b = context.getSharedPreferences("mipush_oc_custom", 0);
    }

    /* renamed from: a */
    public static C1995at m5047a(Context context) {
        if (f3716a == null) {
            synchronized (C1995at.class) {
                if (f3716a == null) {
                    f3716a = new C1995at(context);
                }
            }
        }
        return f3716a;
    }

    /* renamed from: a */
    private String m5048a(int i) {
        return "oc_" + i;
    }

    /* renamed from: a */
    private String m5049a(C1874hu huVar) {
        return "oc_version_" + huVar.mo17807a();
    }

    /* renamed from: a */
    private void m5050a(SharedPreferences.Editor editor, Pair<Integer, Object> pair, String str) {
        if (pair.second instanceof Integer) {
            editor.putInt(str, ((Integer) pair.second).intValue());
        } else if (pair.second instanceof Long) {
            editor.putLong(str, ((Long) pair.second).longValue());
        } else if (pair.second instanceof String) {
            String str2 = (String) pair.second;
            if (str.equals(m5048a(C1873ht.AppIsInstalledList.mo17806a()))) {
                str2 = C1660bl.m2714a(str2);
            }
            editor.putString(str, str2);
        } else if (pair.second instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) pair.second).booleanValue());
        }
    }

    /* renamed from: a */
    public int mo18465a(int i, int i2) {
        try {
            String a = m5048a(i);
            return this.f3719b.contains(a) ? this.f3719b.getInt(a, 0) : this.f3717a.contains(a) ? this.f3717a.getInt(a, 0) : i2;
        } catch (Exception e) {
            C1524b.m2141a(i + " oc int error " + e);
            return i2;
        }
    }

    /* renamed from: a */
    public int mo18466a(C1874hu huVar, int i) {
        try {
            return this.f3717a.getInt(m5049a(huVar), i);
        } catch (Exception e) {
            C1524b.m2141a(huVar + " version error " + e);
            return i;
        }
    }

    /* renamed from: a */
    public String mo18467a(int i, String str) {
        try {
            String a = m5048a(i);
            return this.f3719b.contains(a) ? this.f3719b.getString(a, (String) null) : this.f3717a.contains(a) ? this.f3717a.getString(a, (String) null) : str;
        } catch (Exception e) {
            C1524b.m2141a(i + " oc string error " + e);
            return str;
        }
    }

    /* renamed from: a */
    public synchronized void mo18468a() {
        this.f3718a.clear();
    }

    /* renamed from: a */
    public synchronized void mo18469a(C1996a aVar) {
        if (!this.f3718a.contains(aVar)) {
            this.f3718a.add(aVar);
        }
    }

    /* renamed from: a */
    public void mo18470a(List<Pair<Integer, Object>> list) {
        if (!C1613af.m2510a(list)) {
            SharedPreferences.Editor edit = this.f3719b.edit();
            for (Pair next : list) {
                if (next.first != null) {
                    String a = m5048a(((Integer) next.first).intValue());
                    if (next.second == null) {
                        edit.remove(a);
                    } else {
                        m5050a(edit, next, a);
                    }
                }
            }
            edit.apply();
        }
    }

    /* renamed from: a */
    public void mo18471a(List<Pair<C1874hu, Integer>> list, List<Pair<Integer, Object>> list2) {
        if (C1613af.m2510a(list) || C1613af.m2510a(list2)) {
            C1524b.m2141a("not update oc, because versions or configs are empty");
            return;
        }
        SharedPreferences.Editor edit = this.f3717a.edit();
        edit.clear();
        for (Pair next : list) {
            if (!(next.first == null || next.second == null)) {
                edit.putInt(m5049a((C1874hu) next.first), ((Integer) next.second).intValue());
            }
        }
        for (Pair next2 : list2) {
            if (!(next2.first == null || next2.second == null)) {
                m5050a(edit, next2, m5048a(((Integer) next2.first).intValue()));
            }
        }
        edit.apply();
    }

    /* renamed from: a */
    public boolean mo18472a(int i, boolean z) {
        try {
            String a = m5048a(i);
            return this.f3719b.contains(a) ? this.f3719b.getBoolean(a, false) : this.f3717a.contains(a) ? this.f3717a.getBoolean(a, false) : z;
        } catch (Exception e) {
            C1524b.m2141a(i + " oc boolean error " + e);
            return z;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo18473b() {
        C1524b.m2159c("OC_Callback : receive new oc data");
        HashSet hashSet = new HashSet();
        synchronized (this) {
            hashSet.addAll(this.f3718a);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            C1996a aVar = (C1996a) it.next();
            if (aVar != null) {
                aVar.run();
            }
        }
        hashSet.clear();
    }
}
