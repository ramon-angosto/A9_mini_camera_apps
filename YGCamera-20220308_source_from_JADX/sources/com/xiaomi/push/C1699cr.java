package com.xiaomi.push;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.cr */
class C1699cr {

    /* renamed from: a */
    private String f1968a;

    /* renamed from: a */
    private final ArrayList<C1698cq> f1969a = new ArrayList<>();

    public C1699cr() {
    }

    public C1699cr(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f1968a = str;
            return;
        }
        throw new IllegalArgumentException("the host is empty");
    }

    /* renamed from: a */
    public synchronized C1698cq mo17349a() {
        for (int size = this.f1969a.size() - 1; size >= 0; size--) {
            C1698cq cqVar = this.f1969a.get(size);
            if (cqVar.mo17331a()) {
                C1702cu.mo17360a().mo17357a(cqVar.mo17331a());
                return cqVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    public synchronized C1699cr mo17350a(JSONObject jSONObject) {
        this.f1968a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f1969a.add(new C1698cq(this.f1968a).mo17330a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    /* renamed from: a */
    public String m2899a() {
        return this.f1968a;
    }

    /* renamed from: a */
    public ArrayList<C1698cq> m2900a() {
        return this.f1969a;
    }

    /* renamed from: a */
    public synchronized JSONObject m2901a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("host", this.f1968a);
        JSONArray jSONArray = new JSONArray();
        Iterator<C1698cq> it = this.f1969a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().mo17331a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    /* renamed from: a */
    public synchronized void mo17351a(C1698cq cqVar) {
        int i = 0;
        while (true) {
            if (i >= this.f1969a.size()) {
                break;
            } else if (this.f1969a.get(i).mo17342a(cqVar)) {
                this.f1969a.set(i, cqVar);
                break;
            } else {
                i++;
            }
        }
        if (i >= this.f1969a.size()) {
            this.f1969a.add(cqVar);
        }
    }

    /* renamed from: a */
    public synchronized void mo17352a(boolean z) {
        ArrayList<C1698cq> arrayList;
        for (int size = this.f1969a.size() - 1; size >= 0; size--) {
            C1698cq cqVar = this.f1969a.get(size);
            if (z) {
                if (cqVar.mo17347c()) {
                    arrayList = this.f1969a;
                }
            } else if (!cqVar.mo17346b()) {
                arrayList = this.f1969a;
            }
            arrayList.remove(size);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1968a);
        sb.append("\n");
        Iterator<C1698cq> it = this.f1969a.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }
}
