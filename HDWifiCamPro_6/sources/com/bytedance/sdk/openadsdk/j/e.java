package com.bytedance.sdk.openadsdk.j;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.core.app.NotificationCompat;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PlayableJsBridge */
public class e {
    /* access modifiers changed from: private */
    public Context a;
    private WeakReference<g> b;
    private Map<String, a> c = new HashMap();
    /* access modifiers changed from: private */
    public SensorEventListener d = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            g a2;
            if (sensorEvent.sensor.getType() == 1 && (a2 = e.this.d()) != null) {
                float f = sensorEvent.values[0];
                float f2 = sensorEvent.values[1];
                float f3 = sensorEvent.values[2];
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("x", (double) f);
                    jSONObject.put("y", (double) f2);
                    jSONObject.put("z", (double) f3);
                    a2.a("accelerometer_callback", jSONObject);
                } catch (Throwable unused) {
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public SensorEventListener e = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            g a2;
            if (sensorEvent.sensor.getType() == 4 && (a2 = e.this.d()) != null) {
                float degrees = (float) Math.toDegrees((double) sensorEvent.values[0]);
                float degrees2 = (float) Math.toDegrees((double) sensorEvent.values[1]);
                float degrees3 = (float) Math.toDegrees((double) sensorEvent.values[2]);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("x", (double) degrees);
                    jSONObject.put("y", (double) degrees2);
                    jSONObject.put("z", (double) degrees3);
                    a2.a("gyro_callback", jSONObject);
                } catch (Throwable unused) {
                }
            }
        }
    };

    /* compiled from: PlayableJsBridge */
    interface a {
        JSONObject a(JSONObject jSONObject) throws Throwable;
    }

    public e(g gVar) {
        this.a = gVar.a();
        this.b = new WeakReference<>(gVar);
        c();
    }

    public Set<String> a() {
        return this.c.keySet();
    }

    private void c() {
        this.c.put("adInfo", new a() {
            public JSONObject a(JSONObject jSONObject) {
                g a2 = e.this.d();
                if (a2 != null) {
                    return a2.n();
                }
                return null;
            }
        });
        this.c.put("appInfo", new a() {
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "5.2.2");
                JSONArray jSONArray = new JSONArray();
                for (String put : e.this.a()) {
                    jSONArray.put(put);
                }
                jSONObject2.put("supportList", jSONArray);
                g a2 = e.this.d();
                if (a2 != null) {
                    jSONObject2.put("deviceId", a2.g());
                    jSONObject2.put("netType", a2.k());
                    jSONObject2.put("innerAppName", a2.d());
                    jSONObject2.put("appName", a2.e());
                    jSONObject2.put("appVersion", a2.f());
                    Map<String, String> b = a2.b();
                    for (String next : b.keySet()) {
                        jSONObject2.put(next, b.get(next));
                    }
                }
                return jSONObject2;
            }
        });
        this.c.put("playableSDKInfo", new a() {
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "5.2.2");
                jSONObject2.put("os", "android");
                return jSONObject2;
            }
        });
        this.c.put("subscribe_app_ad", new a() {
            public JSONObject a(JSONObject jSONObject) {
                a b = e.this.e();
                if (b == null) {
                    return null;
                }
                b.a(jSONObject);
                return null;
            }
        });
        this.c.put("download_app_ad", new a() {
            public JSONObject a(JSONObject jSONObject) {
                a b = e.this.e();
                if (b == null) {
                    return null;
                }
                b.b(jSONObject);
                return null;
            }
        });
        this.c.put("isViewable", new a() {
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                g a2 = e.this.d();
                if (a2 == null) {
                    return new JSONObject();
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("viewStatus", a2.i());
                return jSONObject2;
            }
        });
        this.c.put("getVolume", new a() {
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                g a2 = e.this.d();
                if (a2 == null) {
                    return new JSONObject();
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("endcard_mute", a2.h());
                return jSONObject2;
            }
        });
        this.c.put("getScreenSize", new a() {
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                g a2 = e.this.d();
                if (a2 == null) {
                    return new JSONObject();
                }
                return a2.m();
            }
        });
        this.c.put("start_accelerometer_observer", new a() {
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int i = 2;
                if (jSONObject != null) {
                    try {
                        i = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        f.a("PlayableJsBridge", "invoke start_accelerometer_observer error", th);
                        jSONObject2.put("code", -2);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                i.a(e.this.a, e.this.d, i);
                jSONObject2.put("code", 0);
                return jSONObject2;
            }
        });
        this.c.put("close_accelerometer_observer", new a() {
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    i.a(e.this.a, e.this.d);
                    jSONObject2.put("code", 0);
                    return jSONObject2;
                } catch (Throwable th) {
                    f.a("PlayableJsBridge", "invoke close_accelerometer_observer error", th);
                    jSONObject2.put("code", -2);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.c.put("start_gyro_observer", new a() {
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int i = 2;
                if (jSONObject != null) {
                    try {
                        i = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        f.a("PlayableJsBridge", "invoke start_gyro_observer error", th);
                        jSONObject2.put("code", -2);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                i.b(e.this.a, e.this.e, i);
                jSONObject2.put("code", 0);
                return jSONObject2;
            }
        });
        this.c.put("close_gyro_observer", new a() {
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    i.a(e.this.a, e.this.e);
                    jSONObject2.put("code", 0);
                    return jSONObject2;
                } catch (Throwable th) {
                    f.a("PlayableJsBridge", "invoke close_gyro_observer error", th);
                    jSONObject2.put("code", -2);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.c.put("device_shake", new a() {
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    i.a(e.this.a);
                    jSONObject2.put("code", 0);
                    return jSONObject2;
                } catch (Throwable th) {
                    f.a("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put("code", -2);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.c.put("playable_style", new a() {
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                g a2 = e.this.d();
                if (a2 != null) {
                    return a2.c();
                }
                return null;
            }
        });
        this.c.put("sendReward", new a() {
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                g a2 = e.this.d();
                if (a2 == null) {
                    return null;
                }
                a2.p();
                return null;
            }
        });
        this.c.put("webview_time_track", new a() {
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                return null;
            }
        });
        this.c.put("playable_event", new a() {
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                g a2 = e.this.d();
                if (a2 == null || jSONObject == null) {
                    return null;
                }
                a2.b(jSONObject.optString(NotificationCompat.CATEGORY_EVENT, (String) null), jSONObject.optJSONObject("params"));
                return null;
            }
        });
        this.c.put("reportAd", new a() {
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                g a2 = e.this.d();
                if (a2 == null) {
                    return null;
                }
                a2.c(jSONObject);
                return null;
            }
        });
        this.c.put("close", new a() {
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                g a2 = e.this.d();
                if (a2 == null) {
                    return null;
                }
                a2.d(jSONObject);
                return null;
            }
        });
        this.c.put("openAdLandPageLinks", new a() {
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                g a2 = e.this.d();
                if (a2 == null) {
                    return null;
                }
                a2.e(jSONObject);
                return null;
            }
        });
        this.c.put("get_viewport", new a() {
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                g a2 = e.this.d();
                if (a2 == null) {
                    return null;
                }
                return a2.o();
            }
        });
        this.c.put("jssdk_load_finish", new a() {
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                g a2 = e.this.d();
                if (a2 == null) {
                    return null;
                }
                a2.s();
                return null;
            }
        });
        this.c.put("material_render_result", new a() {
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                g a2 = e.this.d();
                if (a2 == null) {
                    return null;
                }
                a2.b(jSONObject);
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    public g d() {
        WeakReference<g> weakReference = this.b;
        if (weakReference == null) {
            return null;
        }
        return (g) weakReference.get();
    }

    /* access modifiers changed from: private */
    public a e() {
        g d2 = d();
        if (d2 == null) {
            return null;
        }
        return d2.l();
    }

    public JSONObject a(String str, JSONObject jSONObject) {
        try {
            a aVar = this.c.get(str);
            if (aVar == null) {
                return null;
            }
            return aVar.a(jSONObject);
        } catch (Throwable th) {
            f.a("PlayableJsBridge", "invoke error", th);
            return null;
        }
    }

    public void b() {
        i.a(this.a, this.d);
        i.a(this.a, this.e);
    }
}
