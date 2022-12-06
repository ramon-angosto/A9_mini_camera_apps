package com.adcolony.sdk;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class f1 {
    private final JSONObject a;

    f1() {
        this(new JSONObject());
    }

    /* access modifiers changed from: package-private */
    public void a(f1 f1Var) {
        if (f1Var != null) {
            synchronized (this.a) {
                synchronized (f1Var.a) {
                    Iterator<String> c = f1Var.c();
                    while (c.hasNext()) {
                        String next = c.next();
                        try {
                            this.a.put(next, f1Var.a.get(next));
                        } catch (JSONException unused) {
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int b(String str) throws JSONException {
        int i;
        synchronized (this.a) {
            i = this.a.getInt(str);
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public e1 c(String str) throws JSONException {
        e1 e1Var;
        synchronized (this.a) {
            e1Var = new e1(this.a.getJSONArray(str));
        }
        return e1Var;
    }

    /* access modifiers changed from: package-private */
    public long d(String str) throws JSONException {
        long j;
        synchronized (this.a) {
            j = this.a.getLong(str);
        }
        return j;
    }

    /* access modifiers changed from: package-private */
    public String e(String str) throws JSONException {
        String string;
        synchronized (this.a) {
            string = this.a.getString(str);
        }
        return string;
    }

    /* access modifiers changed from: package-private */
    public boolean f(String str) {
        boolean optBoolean;
        synchronized (this.a) {
            optBoolean = this.a.optBoolean(str);
        }
        return optBoolean;
    }

    /* access modifiers changed from: package-private */
    public Boolean g(String str) {
        Boolean valueOf;
        try {
            synchronized (this.a) {
                valueOf = Boolean.valueOf(this.a.getBoolean(str));
            }
            return valueOf;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public double h(String str) {
        double optDouble;
        synchronized (this.a) {
            optDouble = this.a.optDouble(str);
        }
        return optDouble;
    }

    /* access modifiers changed from: package-private */
    public Integer i(String str) {
        Integer valueOf;
        try {
            synchronized (this.a) {
                valueOf = Integer.valueOf(this.a.getInt(str));
            }
            return valueOf;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public int j(String str) {
        int optInt;
        synchronized (this.a) {
            optInt = this.a.optInt(str);
        }
        return optInt;
    }

    /* access modifiers changed from: package-private */
    public e1 k(String str) {
        e1 e1Var;
        synchronized (this.a) {
            JSONArray optJSONArray = this.a.optJSONArray(str);
            e1Var = optJSONArray != null ? new e1(optJSONArray) : new e1();
        }
        return e1Var;
    }

    /* access modifiers changed from: package-private */
    public e1 l(String str) {
        e1 e1Var;
        synchronized (this.a) {
            JSONArray optJSONArray = this.a.optJSONArray(str);
            e1Var = optJSONArray != null ? new e1(optJSONArray) : null;
        }
        return e1Var;
    }

    /* access modifiers changed from: package-private */
    public f1 m(String str) {
        f1 f1Var;
        synchronized (this.a) {
            JSONObject optJSONObject = this.a.optJSONObject(str);
            f1Var = optJSONObject != null ? new f1(optJSONObject) : new f1();
        }
        return f1Var;
    }

    /* access modifiers changed from: package-private */
    public f1 n(String str) {
        f1 f1Var;
        synchronized (this.a) {
            JSONObject optJSONObject = this.a.optJSONObject(str);
            f1Var = optJSONObject != null ? new f1(optJSONObject) : null;
        }
        return f1Var;
    }

    /* access modifiers changed from: package-private */
    public Object o(String str) {
        Object opt;
        synchronized (this.a) {
            opt = this.a.isNull(str) ? null : this.a.opt(str);
        }
        return opt;
    }

    /* access modifiers changed from: package-private */
    public String p(String str) {
        String optString;
        synchronized (this.a) {
            optString = this.a.optString(str);
        }
        return optString;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0022, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String q(java.lang.String r3) {
        /*
            r2 = this;
            org.json.JSONObject r0 = r2.a
            monitor-enter(r0)
            org.json.JSONObject r1 = r2.a     // Catch:{ all -> 0x0024 }
            boolean r1 = r1.isNull(r3)     // Catch:{ all -> 0x0024 }
            if (r1 != 0) goto L_0x0021
            org.json.JSONObject r1 = r2.a     // Catch:{ all -> 0x0024 }
            java.lang.Object r3 = r1.opt(r3)     // Catch:{ all -> 0x0024 }
            boolean r1 = r3 instanceof java.lang.String     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x0019
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0024 }
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            return r3
        L_0x0019:
            if (r3 == 0) goto L_0x0021
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0024 }
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            return r3
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            r3 = 0
            return r3
        L_0x0024:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.f1.q(java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public void r(String str) {
        synchronized (this.a) {
            this.a.remove(str);
        }
    }

    public String toString() {
        String jSONObject;
        synchronized (this.a) {
            jSONObject = this.a.toString();
        }
        return jSONObject;
    }

    f1(String str) throws JSONException {
        this(new JSONObject(str));
    }

    f1(Map<?, ?> map) {
        this(new JSONObject(map));
    }

    f1(JSONObject jSONObject) throws NullPointerException {
        jSONObject.getClass();
        this.a = jSONObject;
    }

    /* access modifiers changed from: package-private */
    public f1 b(String str, boolean z) throws JSONException {
        synchronized (this.a) {
            this.a.put(str, z);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean c(String str, int i) throws JSONException {
        synchronized (this.a) {
            if (this.a.has(str)) {
                return false;
            }
            this.a.put(str, i);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.a.length();
    }

    /* access modifiers changed from: package-private */
    public void e() {
        synchronized (this.a) {
            Iterator<String> c = c();
            while (c.hasNext()) {
                Object o = o(c.next());
                if (o == null || (((o instanceof JSONArray) && ((JSONArray) o).length() == 0) || (((o instanceof JSONObject) && ((JSONObject) o).length() == 0) || o.equals("")))) {
                    c.remove();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> f() {
        HashMap hashMap = new HashMap();
        synchronized (this.a) {
            Iterator<String> c = c();
            while (c.hasNext()) {
                String next = c.next();
                hashMap.put(next, p(next));
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public f1 b(String str, int i) throws JSONException {
        synchronized (this.a) {
            this.a.put(str, i);
        }
        return this;
    }

    private Iterator<String> c() {
        return this.a.keys();
    }

    /* access modifiers changed from: package-private */
    public f1 b(String str, long j) throws JSONException {
        synchronized (this.a) {
            this.a.put(str, j);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public f1 b(String str, double d) throws JSONException {
        synchronized (this.a) {
            this.a.put(str, d);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str) {
        boolean z;
        synchronized (this.a) {
            Iterator<String> c = c();
            while (true) {
                if (c.hasNext()) {
                    if (str.equals(c.next())) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return d() == 0;
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str, boolean z) {
        boolean optBoolean;
        synchronized (this.a) {
            optBoolean = this.a.optBoolean(str, z);
        }
        return optBoolean;
    }

    /* access modifiers changed from: package-private */
    public int a(String str, int i) {
        int optInt;
        synchronized (this.a) {
            optInt = this.a.optInt(str, i);
        }
        return optInt;
    }

    /* access modifiers changed from: package-private */
    public long a(String str, long j) {
        long optLong;
        synchronized (this.a) {
            optLong = this.a.optLong(str, j);
        }
        return optLong;
    }

    /* access modifiers changed from: package-private */
    public double a(String str, double d) {
        double optDouble;
        synchronized (this.a) {
            optDouble = this.a.optDouble(str, d);
        }
        return optDouble;
    }

    /* access modifiers changed from: package-private */
    public f1 a(String str, String str2) throws JSONException {
        synchronized (this.a) {
            this.a.put(str, str2);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public f1 a(String str, f1 f1Var) throws JSONException {
        synchronized (this.a) {
            this.a.put(str, f1Var.a());
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public f1 a(String str, e1 e1Var) throws JSONException {
        synchronized (this.a) {
            this.a.put(str, e1Var.a());
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public void a(String[] strArr) {
        synchronized (this.a) {
            for (String remove : strArr) {
                this.a.remove(remove);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(e1 e1Var) {
        synchronized (this.a) {
            Iterator<String> c = c();
            while (c.hasNext()) {
                if (!e1Var.a(c.next())) {
                    c.remove();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public JSONObject a() {
        return this.a;
    }
}
