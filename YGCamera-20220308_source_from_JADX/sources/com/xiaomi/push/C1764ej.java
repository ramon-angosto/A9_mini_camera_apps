package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.xiaomi.push.service.C1974af;
import java.util.HashMap;

/* renamed from: com.xiaomi.push.ej */
public final class C1764ej {

    /* renamed from: a */
    private static volatile C1764ej f2222a;

    /* renamed from: a */
    private int f2223a;

    /* renamed from: a */
    private Context f2224a;

    /* renamed from: a */
    private C1768en f2225a;

    /* renamed from: a */
    private String f2226a;

    /* renamed from: a */
    private HashMap<C1766el, C1767em> f2227a = new HashMap<>();

    /* renamed from: b */
    private String f2228b;

    private C1764ej(Context context) {
        this.f2224a = context;
        this.f2227a.put(C1766el.SERVICE_ACTION, new C1770ep());
        this.f2227a.put(C1766el.SERVICE_COMPONENT, new C1771eq());
        this.f2227a.put(C1766el.ACTIVITY, new C1762eh());
        this.f2227a.put(C1766el.PROVIDER, new C1769eo());
    }

    /* renamed from: a */
    public static C1764ej m3355a(Context context) {
        if (f2222a == null) {
            synchronized (C1764ej.class) {
                if (f2222a == null) {
                    f2222a = new C1764ej(context);
                }
            }
        }
        return f2222a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3357a(C1766el elVar, Context context, C1763ei eiVar) {
        this.f2227a.get(elVar).mo17513a(context, eiVar);
    }

    /* renamed from: a */
    public static boolean m3358a(Context context) {
        return C1974af.m4894a(context, context.getPackageName());
    }

    /* renamed from: a */
    public int mo17523a() {
        return this.f2223a;
    }

    /* renamed from: a */
    public C1768en m3360a() {
        return this.f2225a;
    }

    /* renamed from: a */
    public String m3361a() {
        return this.f2226a;
    }

    /* renamed from: a */
    public void mo17524a(int i) {
        this.f2223a = i;
    }

    /* renamed from: a */
    public void mo17525a(Context context, String str, int i, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            C1760ef.m3335a(context, "" + str, PointerIconCompat.TYPE_TEXT, "A receive a incorrect message");
            return;
        }
        mo17524a(i);
        C1618ak.m2518a(this.f2224a).mo17212a((Runnable) new C1765ek(this, str, context, str2, str3));
    }

    /* renamed from: a */
    public void mo17526a(C1766el elVar, Context context, Intent intent, String str) {
        if (elVar != null) {
            this.f2227a.get(elVar).mo17512a(context, intent, str);
        } else {
            C1760ef.m3335a(context, "null", PointerIconCompat.TYPE_TEXT, "A receive a incorrect message with empty type");
        }
    }

    /* renamed from: a */
    public void mo17527a(C1768en enVar) {
        this.f2225a = enVar;
    }

    /* renamed from: a */
    public void mo17528a(String str) {
        this.f2226a = str;
    }

    /* renamed from: a */
    public void mo17529a(String str, String str2, int i, C1768en enVar) {
        mo17528a(str);
        mo17531b(str2);
        mo17524a(i);
        mo17527a(enVar);
    }

    /* renamed from: b */
    public String mo17530b() {
        return this.f2228b;
    }

    /* renamed from: b */
    public void mo17531b(String str) {
        this.f2228b = str;
    }
}
