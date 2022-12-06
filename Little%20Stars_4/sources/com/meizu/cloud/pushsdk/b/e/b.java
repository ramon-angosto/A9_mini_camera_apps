package com.meizu.cloud.pushsdk.b.e;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import com.meizu.cloud.pushsdk.b.f.c;
import com.meizu.cloud.pushsdk.b.f.e;
import java.util.HashMap;
import java.util.Map;

public class b {
    private static String a = "b";
    private HashMap<String, String> b;
    private HashMap<String, Object> c;
    private HashMap<String, String> d;

    private b(a aVar) {
        this.b = new HashMap<>();
        this.c = new HashMap<>();
        this.d = new HashMap<>();
        d();
        e();
        f();
        g();
        if (aVar.a != null) {
            a(aVar.a);
        }
        c.c(a, "Subject created successfully.", new Object[0]);
    }

    public static class a {
        /* access modifiers changed from: private */
        public Context a = null;

        public a a(Context context) {
            this.a = context;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public void a(Context context) {
        b(context);
        c(context);
    }

    private void a(String str, String str2) {
        if (str != null && str2 != null && !str.isEmpty() && !str2.isEmpty()) {
            this.d.put(str, str2);
        }
    }

    private void a(String str, Object obj) {
        if ((str != null && obj != null && !str.isEmpty()) || ((obj instanceof String) && !((String) obj).isEmpty())) {
            this.c.put(str, obj);
        }
    }

    private void d() {
        a("osType", "android-" + Build.VERSION.RELEASE);
    }

    private void e() {
        a("osVersion", Build.DISPLAY);
    }

    private void f() {
        a("deviceModel", Build.MODEL);
    }

    private void g() {
        a("deviceManufacturer", Build.MANUFACTURER);
    }

    public void b(Context context) {
        Location c2 = e.c(context);
        if (c2 == null) {
            c.a(a, "Location information not available.", new Object[0]);
            return;
        }
        a("latitude", (Object) Double.valueOf(c2.getLatitude()));
        a("longitude", (Object) Double.valueOf(c2.getLongitude()));
        a("altitude", (Object) Double.valueOf(c2.getAltitude()));
        a("latitudeLongitudeAccuracy", (Object) Float.valueOf(c2.getAccuracy()));
        a("speed", (Object) Float.valueOf(c2.getSpeed()));
        a("bearing", (Object) Float.valueOf(c2.getBearing()));
    }

    public void c(Context context) {
        String b2 = e.b(context);
        if (b2 != null) {
            a("carrier", b2);
        }
    }

    public Map<String, Object> a() {
        return this.c;
    }

    public Map<String, String> b() {
        return this.d;
    }

    public Map<String, String> c() {
        return this.b;
    }
}
