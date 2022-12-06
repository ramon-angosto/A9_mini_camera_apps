package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.cz */
class C1710cz implements Comparable<C1710cz> {

    /* renamed from: a */
    protected int f1992a;

    /* renamed from: a */
    private long f1993a;

    /* renamed from: a */
    String f1994a;

    /* renamed from: a */
    private final LinkedList<C1697cp> f1995a;

    public C1710cz() {
        this((String) null, 0);
    }

    public C1710cz(String str) {
        this(str, 0);
    }

    public C1710cz(String str, int i) {
        this.f1995a = new LinkedList<>();
        this.f1993a = 0;
        this.f1994a = str;
        this.f1992a = i;
    }

    /* renamed from: a */
    public int compareTo(C1710cz czVar) {
        if (czVar == null) {
            return 1;
        }
        return czVar.f1992a - this.f1992a;
    }

    /* renamed from: a */
    public synchronized C1710cz mo17375a(JSONObject jSONObject) {
        this.f1993a = jSONObject.getLong("tt");
        this.f1992a = jSONObject.getInt("wt");
        this.f1994a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f1995a.add(new C1697cp().mo17329a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    /* renamed from: a */
    public synchronized JSONObject mo17376a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("tt", this.f1993a);
        jSONObject.put("wt", this.f1992a);
        jSONObject.put("host", this.f1994a);
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.f1995a.iterator();
        while (it.hasNext()) {
            jSONArray.put(((C1697cp) it.next()).mo17328a());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void mo17377a(C1697cp cpVar) {
        if (cpVar != null) {
            this.f1995a.add(cpVar);
            int a = cpVar.mo17328a();
            if (a > 0) {
                this.f1992a += cpVar.mo17328a();
            } else {
                int i = 0;
                int size = this.f1995a.size() - 1;
                while (size >= 0 && this.f1995a.get(size).mo17328a() < 0) {
                    i++;
                    size--;
                }
                this.f1992a += a * i;
            }
            if (this.f1995a.size() > 30) {
                this.f1992a -= this.f1995a.remove().mo17328a();
            }
        }
    }

    public String toString() {
        return this.f1994a + Constants.COLON_SEPARATOR + this.f1992a;
    }
}
