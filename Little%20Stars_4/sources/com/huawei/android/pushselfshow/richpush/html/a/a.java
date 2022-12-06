package com.huawei.android.pushselfshow.richpush.html.a;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Looper;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.richpush.html.api.NativeToJsMessageQueue;
import com.huawei.android.pushselfshow.richpush.html.api.d;
import com.huawei.android.pushselfshow.utils.b.b;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class a implements SensorEventListener, h {
    public SoundPool a = null;
    public boolean b = false;
    private SensorManager c;
    private Sensor d;
    /* access modifiers changed from: private */
    public Activity e;
    private String f;
    private NativeToJsMessageQueue g;
    private float h = 0.0f;
    private float i = 0.0f;
    private float j = 0.0f;
    private long k = 0;
    private int l;
    private int m = 0;
    private int n;
    private String o;
    private int p;
    private int q;
    private int r;
    private long s = 0;
    private Handler t = null;
    private Runnable u = new b(this);

    public a(Activity activity) {
        a(0);
        this.c = (SensorManager) activity.getSystemService("sensor");
        this.e = activity;
    }

    private void a(int i2) {
        this.l = i2;
    }

    private void a(d.a aVar) {
        try {
            e.e("PushSelfShowLog", " accelListener fail,the status is " + d.c()[aVar.ordinal()]);
            this.g.a(this.f, aVar, "error", (JSONObject) null);
        } catch (Exception | RuntimeException unused) {
            e.e("PushSelfShowLog", " accelListener fail error");
        }
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("minAccuracy")) {
                    this.n = jSONObject.getInt("minAccuracy");
                }
            } catch (Exception unused) {
                e.e("PushSelfShowLog", "read OPTIONS_MIN_ACCURACY options error");
            }
            try {
                if (jSONObject.has("minAccelX")) {
                    this.p = jSONObject.getInt("minAccelX");
                }
                if (jSONObject.has("minAccelY")) {
                    this.q = jSONObject.getInt("minAccelY");
                }
                if (jSONObject.has("minAccelZ")) {
                    this.r = jSONObject.getInt("minAccelZ");
                }
            } catch (JSONException unused2) {
                e.e("PushSelfShowLog", "read OPTIONS_MIN_ACCEL_X_Y_Z options error");
            }
        }
        e.b("PushSelfShowLog", "start with optins and the minAccuracy is %s  , minAccelX is %s ,minAccelY is %s ,minAccelZ is %s", Integer.valueOf(this.n), Integer.valueOf(this.p), Integer.valueOf(this.q), Integer.valueOf(this.r));
        int i2 = this.l;
        if (i2 != 2 && i2 != 1) {
            a(1);
            this.b = true;
            List<Sensor> sensorList = this.c.getSensorList(1);
            if (sensorList == null || sensorList.size() <= 0) {
                a(3);
                a(d.a.ACCL_NO_SENSORS);
                return;
            }
            this.d = sensorList.get(0);
            this.c.registerListener(this, this.d, 2);
            a(1);
            e.e("PushSelfShowLog", "this.setStatus(AccelListener.STARTING);");
            e();
            this.t = new Handler(Looper.getMainLooper());
            this.t.postDelayed(this.u, 2000);
        }
    }

    private void b(JSONObject jSONObject) {
        if (System.currentTimeMillis() - this.s >= 2000) {
            this.s = System.currentTimeMillis();
            if (jSONObject != null) {
                try {
                    if (jSONObject.has("soundType")) {
                        this.o = jSONObject.getString("soundType");
                    }
                } catch (Exception unused) {
                    e.e("PushSelfShowLog", "read OPTIONS_PLAY_MUSIC ,SRC options error");
                }
            }
            e.b("PushSelfShowLog", "playSound with optins and the  soundType is %s ", this.o);
            try {
                if ("TYPE_SHAKE".equals(this.o)) {
                    String c2 = b.c(this.e);
                    if (c2 == null) {
                        a(d.a.ACCL_NO_SDCARD);
                        return;
                    }
                    String str = c2 + File.separator + "pushresources/shake.mp3".substring(0, "pushresources/shake.mp3".indexOf("/"));
                    if (!new File(str).exists() && new File(str).mkdirs()) {
                        e.e("PushSelfShowLog", "resource mkdir true");
                    }
                    String str2 = c2 + File.separator + "pushresources/shake.mp3";
                    com.huawei.android.pushselfshow.utils.a.b(this.e, "pushresources/shake.mp3", str2);
                    if (!new File(str2).exists()) {
                        a(d.a.IO_EXCEPTION);
                        return;
                    }
                    this.a = new SoundPool(1, 3, 0);
                    this.a.setOnLoadCompleteListener(new c(this));
                    this.a.load(str2, 1);
                }
            } catch (Exception e2) {
                e.c("PushSelfShowLog", " error", e2);
            }
        }
    }

    private void e() {
        Handler handler = this.t;
        if (handler != null) {
            handler.removeCallbacks(this.u);
        }
    }

    private void f() {
        SoundPool soundPool = this.a;
        if (soundPool != null) {
            soundPool.release();
            this.a = null;
        }
        this.b = false;
        e();
        e.e("PushSelfShowLog", " stop this.status" + this.l);
        SensorManager sensorManager = this.c;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        a(0);
        this.m = 0;
    }

    /* access modifiers changed from: private */
    public void g() {
        if (this.l == 1) {
            a(3);
            a(d.a.ACCL_CAN_NOT_START);
        }
    }

    private void h() {
        e.e("PushSelfShowLog", " accelListener success");
        this.g.a(this.f, d.a.OK, "success", i());
    }

    private JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double) this.h);
            jSONObject.put("y", (double) this.i);
            jSONObject.put("z", (double) this.j);
            jSONObject.put("timestamp", this.k);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String a(String str, JSONObject jSONObject) {
        return null;
    }

    public void a() {
        e.e("PushSelfShowLog", "call acclListener init()");
        this.n = 2;
        this.o = "TYPE_SHAKE";
        this.p = 10;
        this.q = 10;
        this.r = 10;
    }

    public void a(int i2, int i3, Intent intent) {
    }

    public void a(NativeToJsMessageQueue nativeToJsMessageQueue, String str, String str2, JSONObject jSONObject) {
        if (nativeToJsMessageQueue == null) {
            e.a("PushSelfShowLog", "jsMessageQueue is null while run into App exec");
            return;
        }
        this.g = nativeToJsMessageQueue;
        if ("start".equals(str)) {
            e.e("PushSelfShowLog", "call acclListener exec and the method is start");
            d();
            if (str2 != null) {
                this.f = str2;
                if (this.l != 2) {
                    a(jSONObject);
                    return;
                }
                return;
            }
            e.a("PushSelfShowLog", "Audio exec callback is null ");
        } else if ("stop".equals(str)) {
            f();
        } else if ("playSound".equals(str)) {
            b(jSONObject);
        } else {
            a(d.a.METHOD_NOT_FOUND_EXCEPTION);
        }
    }

    public void b() {
        int i2 = this.l;
        if (i2 != 0 && i2 != 3) {
            f();
            a((JSONObject) null);
        }
    }

    public void c() {
        d();
    }

    public void d() {
        e.e("PushSelfShowLog", "accel reset");
        f();
        a();
    }

    public void onAccuracyChanged(Sensor sensor, int i2) {
        if (sensor.getType() == 1 && this.l != 0) {
            this.m = i2;
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1 && this.b && this.l != 0) {
            a(2);
            if (this.m >= this.n) {
                this.h = sensorEvent.values[0];
                this.i = sensorEvent.values[1];
                this.j = sensorEvent.values[2];
                this.k = System.currentTimeMillis();
                if (Math.abs(this.h) > ((float) this.p) || Math.abs(this.i) > ((float) this.q) || Math.abs(this.j) > ((float) this.r)) {
                    e.b("PushSelfShowLog", "onSensorChanged and x = %s , y=%s , z=%s ", Float.valueOf(this.h), Float.valueOf(this.i), Float.valueOf(this.j));
                    h();
                }
            }
        }
    }
}
