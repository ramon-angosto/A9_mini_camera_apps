package com.bytedance.sdk.component.e.a.d.a;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdLogEvent */
public class a implements com.bytedance.sdk.component.e.a.d.a {
    protected JSONObject a;
    private b b;
    private byte c;
    private byte d;
    private long e;
    private long f;
    private long g;
    private String h;
    private String i;
    private byte j;
    private String k;

    public a(String str, JSONObject jSONObject) {
        this.i = str;
        this.a = jSONObject;
    }

    public a(String str, b bVar) {
        this.i = str;
        this.b = bVar;
    }

    public b a() {
        return this.b;
    }

    private a() {
    }

    public String j() {
        return this.k;
    }

    public synchronized JSONObject g() {
        if (this.a == null && this.b != null) {
            this.a = this.b.a(j());
        }
        return this.a;
    }

    public void a(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public static com.bytedance.sdk.component.e.a.d.a c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("type");
            int optInt2 = jSONObject.optInt("priority");
            a aVar = new a();
            aVar.a((byte) optInt);
            aVar.b((byte) optInt2);
            aVar.a(jSONObject.optJSONObject(NotificationCompat.CATEGORY_EVENT));
            aVar.a(jSONObject.optString("localId"));
            aVar.b(jSONObject.optString("genTime"));
            return aVar;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void c(byte b2) {
        this.j = b2;
    }

    public byte b() {
        return this.j;
    }

    public String c() {
        return this.i;
    }

    public byte d() {
        return this.c;
    }

    public void a(byte b2) {
        this.c = b2;
    }

    public void a(String str) {
        this.i = str;
    }

    public void b(String str) {
        this.h = str;
    }

    public void a(long j2) {
        this.e = j2;
    }

    public long h() {
        return this.e;
    }

    public void b(long j2) {
        this.f = j2;
    }

    public long i() {
        return this.f;
    }

    public void c(long j2) {
        this.g = j2;
    }

    public String k() {
        return this.h;
    }

    public void b(byte b2) {
        this.d = b2;
    }

    public byte e() {
        return this.d;
    }

    public String f() {
        if (TextUtils.isEmpty(this.i)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("localId", this.i);
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, g());
            jSONObject.put("genTime", k());
            jSONObject.put("priority", this.d);
            jSONObject.put("type", this.c);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }
}
