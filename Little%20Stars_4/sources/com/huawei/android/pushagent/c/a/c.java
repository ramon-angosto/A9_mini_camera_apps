package com.huawei.android.pushagent.c.a;

import android.content.Context;
import com.huawei.android.pushagent.plugin.tools.BLocation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class c {
    public String b = "";
    public HashMap c = new HashMap();
    /* access modifiers changed from: protected */
    public Context d = null;

    public c(Context context, String str) {
        this.b = str;
        this.d = context;
    }

    public static HashMap g(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String valueOf = String.valueOf(keys.next());
                hashMap.put(valueOf, jSONObject.get(valueOf));
            }
        } catch (Exception e) {
            e.c(BLocation.TAG, e.toString(), e);
        }
        return hashMap;
    }

    public int a(String str, int i) {
        Object b2 = b(str, Integer.valueOf(i));
        return b2 instanceof Integer ? ((Integer) b2).intValue() : b2 instanceof Long ? (int) ((Long) b2).longValue() : i;
    }

    public String a(String str, String str2) {
        return String.valueOf(b(str, str2));
    }

    public boolean a(String str, Object obj) {
        this.c.put(str, obj);
        new h(this.d, this.b).a(str, obj);
        return true;
    }

    public HashMap af() {
        HashMap hashMap = new HashMap();
        Map b2 = new h(this.d, this.b).b();
        if (b2 != null) {
            for (Map.Entry entry : b2.entrySet()) {
                if (entry != null) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        if (hashMap.size() != 0) {
            this.c = hashMap;
        }
        return hashMap;
    }

    public boolean ag() {
        new h(this.d, this.b).a((Map) this.c);
        return true;
    }

    public Object b(String str, Object obj) {
        Object f = f(str);
        return f == null ? obj : f;
    }

    public long c(String str, long j) {
        Object b2 = b(str, Long.valueOf(j));
        return b2 instanceof Integer ? (long) ((Integer) b2).intValue() : b2 instanceof Long ? ((Long) b2).longValue() : j;
    }

    public Object f(String str) {
        return this.c.get(str);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry entry : this.c.entrySet()) {
            stringBuffer.append((String) entry.getKey());
            stringBuffer.append(":");
            stringBuffer.append(entry.getValue());
            stringBuffer.append(" ");
        }
        return stringBuffer.toString();
    }
}
