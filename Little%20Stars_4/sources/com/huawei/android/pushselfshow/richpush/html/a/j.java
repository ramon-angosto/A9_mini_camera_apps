package com.huawei.android.pushselfshow.richpush.html.a;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.richpush.html.a.a.a;
import com.huawei.android.pushselfshow.richpush.html.a.a.b;
import com.huawei.android.pushselfshow.richpush.html.api.NativeToJsMessageQueue;
import com.huawei.android.pushselfshow.richpush.html.api.d;
import org.json.JSONException;
import org.json.JSONObject;

public class j implements h {
    public boolean a = false;
    public boolean b = false;
    public long c = 2000;
    public int d = 0;
    public String e;
    public NativeToJsMessageQueue f;
    private a g;
    private b h;
    private LocationManager i;
    private Activity j = null;

    public j(Activity activity) {
        try {
            e.e("PushSelfShowLog", "init GeoBroker");
            this.j = activity;
        } catch (Exception e2) {
            e.d("PushSelfShowLog", "init GeoBroker error ", e2);
        }
    }

    private void a() {
        d();
    }

    private void e() {
        Location location;
        if (this.a) {
            a aVar = this.g;
            if (aVar != null) {
                aVar.a(this.c, (float) this.d);
            }
            LocationManager locationManager = this.i;
            if (locationManager == null || (location = locationManager.getLastKnownLocation("gps")) == null) {
                return;
            }
        } else {
            b bVar = this.h;
            if (bVar != null) {
                bVar.a(this.c, (float) this.d);
            }
            LocationManager locationManager2 = this.i;
            if (locationManager2 != null) {
                location = locationManager2.getLastKnownLocation("network");
                if (location == null) {
                    location = this.i.getLastKnownLocation("gps");
                }
                if (location == null) {
                    return;
                }
            } else {
                return;
            }
        }
        b(location);
    }

    public String a(String str, JSONObject jSONObject) {
        return null;
    }

    public JSONObject a(Location location) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("latitude", location.getLatitude());
            jSONObject.put("longitude", location.getLongitude());
            Float f2 = null;
            jSONObject.put("altitude", location.hasAltitude() ? Double.valueOf(location.getAltitude()) : null);
            jSONObject.put("accuracy", (double) location.getAccuracy());
            if (location.hasBearing() && location.hasSpeed()) {
                f2 = Float.valueOf(location.getBearing());
            }
            jSONObject.put("heading", f2);
            jSONObject.put("velocity", (double) location.getSpeed());
            jSONObject.put("timestamp", location.getTime());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void a(int i2, int i3, Intent intent) {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        a(com.huawei.android.pushselfshow.richpush.html.api.d.a.JSON_EXCEPTION);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0079 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.huawei.android.pushselfshow.richpush.html.api.NativeToJsMessageQueue r8, java.lang.String r9, java.lang.String r10, org.json.JSONObject r11) {
        /*
            r7 = this;
            java.lang.String r0 = "minDistance"
            java.lang.String r1 = "minTime"
            java.lang.String r2 = "keepLoc"
            java.lang.String r3 = "useGps"
            java.lang.String r4 = "PushSelfShowLog"
            java.lang.String r5 = "run into geo broker exec"
            com.huawei.android.pushagent.c.a.e.e(r4, r5)     // Catch:{ Exception -> 0x0099 }
            r7.d()     // Catch:{ Exception -> 0x0099 }
            android.app.Activity r5 = r7.j     // Catch:{ Exception -> 0x0099 }
            java.lang.String r6 = "location"
            java.lang.Object r5 = r5.getSystemService(r6)     // Catch:{ Exception -> 0x0099 }
            android.location.LocationManager r5 = (android.location.LocationManager) r5     // Catch:{ Exception -> 0x0099 }
            r7.i = r5     // Catch:{ Exception -> 0x0099 }
            com.huawei.android.pushselfshow.richpush.html.a.a.b r5 = new com.huawei.android.pushselfshow.richpush.html.a.a.b     // Catch:{ Exception -> 0x0099 }
            android.location.LocationManager r6 = r7.i     // Catch:{ Exception -> 0x0099 }
            r5.<init>(r6, r7)     // Catch:{ Exception -> 0x0099 }
            r7.h = r5     // Catch:{ Exception -> 0x0099 }
            com.huawei.android.pushselfshow.richpush.html.a.a.a r5 = new com.huawei.android.pushselfshow.richpush.html.a.a.a     // Catch:{ Exception -> 0x0099 }
            android.location.LocationManager r6 = r7.i     // Catch:{ Exception -> 0x0099 }
            r5.<init>(r6, r7)     // Catch:{ Exception -> 0x0099 }
            r7.g = r5     // Catch:{ Exception -> 0x0099 }
            r7.e = r10     // Catch:{ Exception -> 0x0099 }
            if (r8 != 0) goto L_0x003a
            java.lang.String r8 = "jsMessageQueue is null while run into App exec"
            com.huawei.android.pushagent.c.a.e.a(r4, r8)     // Catch:{ Exception -> 0x0099 }
            return
        L_0x003a:
            r7.f = r8     // Catch:{ Exception -> 0x0099 }
            java.lang.String r8 = "getLocation"
            boolean r8 = r8.equals(r9)     // Catch:{ Exception -> 0x0099 }
            if (r8 == 0) goto L_0x0082
            boolean r8 = r11.has(r3)     // Catch:{ JSONException -> 0x0079 }
            if (r8 == 0) goto L_0x0050
            boolean r8 = r11.getBoolean(r3)     // Catch:{ JSONException -> 0x0079 }
            r7.a = r8     // Catch:{ JSONException -> 0x0079 }
        L_0x0050:
            boolean r8 = r11.has(r2)     // Catch:{ JSONException -> 0x0079 }
            if (r8 == 0) goto L_0x007e
            boolean r8 = r11.getBoolean(r2)     // Catch:{ JSONException -> 0x0079 }
            r7.b = r8     // Catch:{ JSONException -> 0x0079 }
            boolean r8 = r7.b     // Catch:{ JSONException -> 0x0079 }
            if (r8 == 0) goto L_0x007e
            boolean r8 = r11.has(r1)     // Catch:{ JSONException -> 0x0079 }
            if (r8 == 0) goto L_0x006c
            long r8 = r11.getLong(r1)     // Catch:{ JSONException -> 0x0079 }
            r7.c = r8     // Catch:{ JSONException -> 0x0079 }
        L_0x006c:
            boolean r8 = r11.has(r0)     // Catch:{ JSONException -> 0x0079 }
            if (r8 == 0) goto L_0x007e
            int r8 = r11.getInt(r0)     // Catch:{ JSONException -> 0x0079 }
            r7.d = r8     // Catch:{ JSONException -> 0x0079 }
            goto L_0x007e
        L_0x0079:
            com.huawei.android.pushselfshow.richpush.html.api.d$a r8 = com.huawei.android.pushselfshow.richpush.html.api.d.a.JSON_EXCEPTION     // Catch:{ Exception -> 0x0099 }
            r7.a((com.huawei.android.pushselfshow.richpush.html.api.d.a) r8)     // Catch:{ Exception -> 0x0099 }
        L_0x007e:
            r7.e()     // Catch:{ Exception -> 0x0099 }
            goto L_0x009f
        L_0x0082:
            java.lang.String r8 = "clearWatch"
            boolean r8 = r8.equals(r9)     // Catch:{ Exception -> 0x0099 }
            if (r8 == 0) goto L_0x0093
            java.lang.String r8 = "call method clearWatch"
            com.huawei.android.pushagent.c.a.e.e(r4, r8)     // Catch:{ Exception -> 0x0099 }
            r7.a()     // Catch:{ Exception -> 0x0099 }
            goto L_0x009f
        L_0x0093:
            com.huawei.android.pushselfshow.richpush.html.api.d$a r8 = com.huawei.android.pushselfshow.richpush.html.api.d.a.METHOD_NOT_FOUND_EXCEPTION     // Catch:{ Exception -> 0x0099 }
            r7.a((com.huawei.android.pushselfshow.richpush.html.api.d.a) r8)     // Catch:{ Exception -> 0x0099 }
            goto L_0x009f
        L_0x0099:
            r8 = move-exception
            java.lang.String r9 = "run into geo broker exec error "
            com.huawei.android.pushagent.c.a.e.d(r4, r9, r8)
        L_0x009f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.richpush.html.a.j.a(com.huawei.android.pushselfshow.richpush.html.api.NativeToJsMessageQueue, java.lang.String, java.lang.String, org.json.JSONObject):void");
    }

    public void a(d.a aVar) {
        e.a("PushSelfShowLog", "geo broker fail ,reason is %s", d.c()[aVar.ordinal()]);
        NativeToJsMessageQueue nativeToJsMessageQueue = this.f;
        if (nativeToJsMessageQueue != null) {
            nativeToJsMessageQueue.a(this.e, aVar, "error", (JSONObject) null);
        }
    }

    public void b() {
    }

    public void b(Location location) {
        NativeToJsMessageQueue nativeToJsMessageQueue = this.f;
        if (nativeToJsMessageQueue != null) {
            nativeToJsMessageQueue.a(this.e, d.a.OK, "success", a(location));
        }
    }

    public void c() {
        d();
    }

    public void d() {
        e.e("PushSelfShowLog", "call geo broker reset");
        try {
            if (this.h != null) {
                this.h.a();
                this.h = null;
            }
            if (this.g != null) {
                this.g.a();
                this.g = null;
            }
            this.i = null;
            this.a = false;
            this.b = false;
            this.c = 2000;
            this.d = 0;
            this.e = null;
            this.f = null;
        } catch (Exception e2) {
            e.d("PushSelfShowLog", "call GeoBroker reset error", e2);
        }
    }
}
