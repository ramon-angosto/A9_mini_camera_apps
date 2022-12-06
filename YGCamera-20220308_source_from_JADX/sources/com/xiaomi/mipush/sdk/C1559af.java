package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.mipush.sdk.af */
public class C1559af {

    /* renamed from: a */
    private static volatile C1559af f1647a;

    /* renamed from: a */
    private Context f1648a;

    /* renamed from: a */
    private List<C1604x> f1649a = new ArrayList();

    private C1559af(Context context) {
        this.f1648a = context.getApplicationContext();
        if (this.f1648a == null) {
            this.f1648a = context;
        }
    }

    /* renamed from: a */
    public static C1559af m2278a(Context context) {
        if (f1647a == null) {
            synchronized (C1559af.class) {
                if (f1647a == null) {
                    f1647a = new C1559af(context);
                }
            }
        }
        return f1647a;
    }

    /* renamed from: a */
    public int mo17125a(String str) {
        synchronized (this.f1649a) {
            C1604x xVar = new C1604x();
            xVar.f1746a = str;
            if (this.f1649a.contains(xVar)) {
                for (C1604x next : this.f1649a) {
                    if (next.equals(xVar)) {
                        int i = next.f1745a;
                        return i;
                    }
                }
            }
            return 0;
        }
    }

    /* renamed from: a */
    public synchronized String mo17126a(C1575au auVar) {
        return this.f1648a.getSharedPreferences("mipush_extra", 0).getString(auVar.name(), "");
    }

    /* renamed from: a */
    public synchronized void mo17127a(C1575au auVar, String str) {
        SharedPreferences sharedPreferences = this.f1648a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(auVar.name(), str).commit();
    }

    /* renamed from: a */
    public void m2282a(String str) {
        synchronized (this.f1649a) {
            C1604x xVar = new C1604x();
            xVar.f1745a = 0;
            xVar.f1746a = str;
            if (this.f1649a.contains(xVar)) {
                this.f1649a.remove(xVar);
            }
            this.f1649a.add(xVar);
        }
    }

    /* renamed from: a */
    public boolean m2283a(String str) {
        synchronized (this.f1649a) {
            C1604x xVar = new C1604x();
            xVar.f1746a = str;
            return this.f1649a.contains(xVar);
        }
    }

    /* renamed from: b */
    public void mo17128b(String str) {
        synchronized (this.f1649a) {
            C1604x xVar = new C1604x();
            xVar.f1746a = str;
            if (this.f1649a.contains(xVar)) {
                Iterator<C1604x> it = this.f1649a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C1604x next = it.next();
                    if (xVar.equals(next)) {
                        xVar = next;
                        break;
                    }
                }
            }
            xVar.f1745a++;
            this.f1649a.remove(xVar);
            this.f1649a.add(xVar);
        }
    }

    /* renamed from: c */
    public void mo17129c(String str) {
        synchronized (this.f1649a) {
            C1604x xVar = new C1604x();
            xVar.f1746a = str;
            if (this.f1649a.contains(xVar)) {
                this.f1649a.remove(xVar);
            }
        }
    }
}
