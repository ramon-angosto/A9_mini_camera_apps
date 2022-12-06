package com.mbridge.msdk.videocommon.d;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.videocommon.b.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RewardSetting */
public class a {
    private Map<String, Integer> a;
    private Map<String, c> b;
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private String i;
    private int j = 0;

    public final String a() {
        return this.i;
    }

    public final long b() {
        return this.c * 1000;
    }

    public final void a(long j2) {
        this.c = j2;
    }

    public final long c() {
        return this.d * 1000;
    }

    public final void b(long j2) {
        this.d = j2;
    }

    public final long d() {
        return this.e * 1000;
    }

    public final void c(long j2) {
        this.e = j2;
    }

    public final long e() {
        return this.f;
    }

    public final void d(long j2) {
        this.f = j2;
    }

    public final long f() {
        return this.g;
    }

    public final void e(long j2) {
        this.g = j2;
    }

    public final void a(int i2) {
        this.j = i2;
    }

    public final long g() {
        return this.h;
    }

    public final Map<String, Integer> h() {
        if (this.a == null) {
            this.a = new HashMap();
            this.a.put("1", 1000);
            this.a.put("9", 1000);
            this.a.put("8", 1000);
        }
        return this.a;
    }

    public final void a(Map<String, Integer> map) {
        this.a = map;
    }

    public final Map<String, c> i() {
        return this.b;
    }

    public final void b(Map<String, c> map) {
        this.b = map;
    }

    public static a a(String str) {
        a aVar;
        a aVar2 = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                aVar = new a();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return aVar2;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject = jSONObject.optJSONObject("caplist");
                aVar.i = jSONObject.optString("ab_id", "");
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    HashMap hashMap = new HashMap();
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys != null && keys.hasNext()) {
                        String next = keys.next();
                        int intValue = Integer.valueOf(optJSONObject.optInt(next, 1000)).intValue();
                        if (!TextUtils.isEmpty(next)) {
                            if (TextUtils.isEmpty(next) || intValue != 0) {
                                hashMap.put(next, Integer.valueOf(intValue));
                            } else {
                                hashMap.put(next, 1000);
                            }
                        }
                    }
                    aVar.a = hashMap;
                }
                aVar.b = c.a(jSONObject.optJSONArray("reward"));
                aVar.c = jSONObject.optLong("getpf", 43200);
                aVar.d = jSONObject.optLong("ruct", 5400);
                aVar.e = jSONObject.optLong(CampaignEx.JSON_KEY_PLCT, 3600);
                aVar.f = jSONObject.optLong("dlct", 3600);
                aVar.g = jSONObject.optLong("vcct", 5);
                aVar.h = jSONObject.optLong("current_time");
                return aVar;
            } catch (Exception e3) {
                e = e3;
                aVar2 = aVar;
                e.printStackTrace();
                return aVar2;
            }
        }
        return aVar2;
    }

    public final JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.a != null && this.a.size() > 0) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry next : this.a.entrySet()) {
                        jSONObject2.put((String) next.getKey(), ((Integer) next.getValue()).intValue());
                    }
                    jSONObject.put("caplist", jSONObject2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (this.b != null && this.b.size() > 0) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry next2 : this.b.entrySet()) {
                        JSONObject jSONObject3 = new JSONObject();
                        String str = (String) next2.getKey();
                        c cVar = (c) next2.getValue();
                        if (cVar != null) {
                            jSONObject3.put("name", cVar.a());
                            jSONObject3.put(RewardPlus.AMOUNT, cVar.b());
                            jSONObject3.put("id", str);
                        }
                        jSONArray.put(jSONObject3);
                    }
                    jSONObject.put("reward", jSONArray);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            jSONObject.put("getpf", this.c);
            jSONObject.put("ruct", this.d);
            jSONObject.put(CampaignEx.JSON_KEY_PLCT, this.e);
            jSONObject.put("dlct", this.f);
            jSONObject.put("vcct", this.g);
            jSONObject.put("current_time", this.h);
            jSONObject.put("isDefault", this.j);
            return jSONObject;
        } catch (Exception e4) {
            e4.printStackTrace();
            return jSONObject;
        }
    }
}
