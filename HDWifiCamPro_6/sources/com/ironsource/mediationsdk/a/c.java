package com.ironsource.mediationsdk.a;

import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    private int a = -1;
    private long b = -1;
    private JSONObject c;

    public c(int i, long j, JSONObject jSONObject) {
        this.a = i;
        this.b = j;
        this.c = jSONObject;
    }

    public c(int i, JSONObject jSONObject) {
        this.a = i;
        this.b = System.currentTimeMillis();
        if (jSONObject == null) {
            this.c = new JSONObject();
        } else {
            this.c = jSONObject;
        }
    }

    static a a(String str, int i) {
        if ("ironbeast".equals(str)) {
            return new e(i);
        }
        if ("outcome".equals(str)) {
            return new f(i);
        }
        if (i == 2) {
            return new e(i);
        }
        if (i == 3) {
            return new f(i);
        }
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
        logger.log(ironSourceTag, "EventsFormatterFactory failed to instantiate a formatter (type: " + str + ", adUnit: " + i + ")", 2);
        return null;
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(String str, Object obj) {
        try {
            this.c.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public long b() {
        return this.b;
    }

    public String c() {
        return this.c.toString();
    }

    public JSONObject d() {
        return this.c;
    }
}
