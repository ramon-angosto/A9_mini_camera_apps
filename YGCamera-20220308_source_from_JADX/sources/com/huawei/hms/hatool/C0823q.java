package com.huawei.hms.hatool;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.q */
public class C0823q implements C0827s {

    /* renamed from: a */
    public String f731a;

    /* renamed from: b */
    public String f732b;

    /* renamed from: c */
    public String f733c;

    /* renamed from: d */
    public String f734d;

    /* renamed from: e */
    public String f735e;

    /* renamed from: f */
    public String f736f;

    /* renamed from: a */
    public JSONObject mo13931a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.f731a);
        jSONObject.put("eventtime", this.f734d);
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.f732b);
        jSONObject.put("event_session_name", this.f735e);
        jSONObject.put("first_session_event", this.f736f);
        if (TextUtils.isEmpty(this.f733c)) {
            return null;
        }
        jSONObject.put("properties", new JSONObject(this.f733c));
        return jSONObject;
    }

    /* renamed from: a */
    public void mo14098a(String str) {
        this.f733c = str;
    }

    /* renamed from: a */
    public void mo14099a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f732b = jSONObject.optString(NotificationCompat.CATEGORY_EVENT);
            this.f733c = jSONObject.optString("properties");
            this.f733c = C0784d.m774a(this.f733c, C0785d0.m776f().mo13938a());
            this.f731a = jSONObject.optString("type");
            this.f734d = jSONObject.optString("eventtime");
            this.f735e = jSONObject.optString("event_session_name");
            this.f736f = jSONObject.optString("first_session_event");
        }
    }

    /* renamed from: b */
    public String mo14100b() {
        return this.f734d;
    }

    /* renamed from: b */
    public void mo14101b(String str) {
        this.f732b = str;
    }

    /* renamed from: c */
    public String mo14102c() {
        return this.f731a;
    }

    /* renamed from: c */
    public void mo14103c(String str) {
        this.f734d = str;
    }

    /* renamed from: d */
    public JSONObject mo14104d() {
        JSONObject a = mo13931a();
        a.put("properties", C0784d.m775b(this.f733c, C0785d0.m776f().mo13938a()));
        return a;
    }

    /* renamed from: d */
    public void mo14105d(String str) {
        this.f731a = str;
    }

    /* renamed from: e */
    public void mo14106e(String str) {
        this.f736f = str;
    }

    /* renamed from: f */
    public void mo14107f(String str) {
        this.f735e = str;
    }
}
