package com.baidu.mapapi;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MKLocationManager {
    public static final int MK_COORDINATE_BAIDU09 = 2;
    public static final int MK_COORDINATE_GCJ = 1;
    public static final int MK_COORDINATE_WGS84 = 0;
    public static final int MK_GPS_PROVIDER = 0;
    public static final int MK_NETWORK_PROVIDER = 1;
    private Location a = null;
    private Location b = null;
    private long c = 864000;
    private long d = 0;
    private List<LocationListener> e = new ArrayList();
    /* access modifiers changed from: private */
    public List<SensorEventListener> f = new ArrayList();
    private SensorEventListener g = null;

    MKLocationManager() {
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.b = null;
    }

    /* access modifiers changed from: package-private */
    public boolean a(SensorEventListener sensorEventListener) {
        if (this.f.size() != 0) {
            return this.f.add(sensorEventListener);
        }
        if (!d()) {
            return false;
        }
        if (this.f.add(sensorEventListener)) {
            return true;
        }
        e();
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean a(BMapManager bMapManager) {
        if (bMapManager == null) {
            return false;
        }
        Mj.r = true;
        this.e.clear();
        return Mj.InitLocationCC() == 1;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        Mj.DisableProviderCC(0);
        Mj.DisableProviderCC(1);
    }

    /* access modifiers changed from: package-private */
    public void b(SensorEventListener sensorEventListener) {
        this.f.remove(sensorEventListener);
        if (this.f.size() == 0) {
            e();
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        Location locationInfo = getLocationInfo();
        long currentTimeMillis = System.currentTimeMillis();
        int i = 0;
        if (locationInfo == null || currentTimeMillis - this.d < this.c * 1000) {
            Location location = this.b;
            if (location == null || locationInfo == null || ((double) locationInfo.distanceTo(location)) >= 0.1d || locationInfo.getAccuracy() != this.b.getAccuracy() || locationInfo.getBearing() != this.b.getBearing() || locationInfo.getSpeed() != this.b.getSpeed() || locationInfo.getAltitude() != this.b.getAltitude()) {
                this.d = currentTimeMillis;
                while (i < this.e.size()) {
                    this.e.get(i).onLocationChanged(locationInfo);
                    this.b = locationInfo;
                    i++;
                }
                return;
            }
            return;
        }
        this.d = currentTimeMillis;
        while (i < this.e.size()) {
            this.e.get(i).onLocationChanged(locationInfo);
            this.b = locationInfo;
            i++;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        Sensor defaultSensor;
        SensorManager sensorManager = (SensorManager) Mj.e.getSystemService("sensor");
        if (sensorManager == null || (defaultSensor = sensorManager.getDefaultSensor(3)) == null) {
            return false;
        }
        this.g = new SensorEventListener() {
            public void onAccuracyChanged(Sensor sensor, int i) {
                for (int i2 = 0; i2 < MKLocationManager.this.f.size(); i2++) {
                    ((SensorEventListener) MKLocationManager.this.f.get(i2)).onAccuracyChanged(sensor, i);
                }
            }

            public void onSensorChanged(SensorEvent sensorEvent) {
                for (int i = 0; i < MKLocationManager.this.f.size(); i++) {
                    ((SensorEventListener) MKLocationManager.this.f.get(i)).onSensorChanged(sensorEvent);
                }
            }
        };
        return sensorManager.registerListener(this.g, defaultSensor, 3);
    }

    public boolean disableProvider(int i) {
        if ((i != 0 && i != 1) || Mj.DisableProviderCC(i) == 0) {
            return false;
        }
        if (i == 0) {
            Mj.q = false;
        } else if (i == 1) {
            Mj.r = false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        SensorManager sensorManager;
        if (this.g != null && (sensorManager = (SensorManager) Mj.e.getSystemService("sensor")) != null && sensorManager.getDefaultSensor(3) != null) {
            sensorManager.unregisterListener(this.g);
        }
    }

    public boolean enableProvider(int i) {
        if ((i != 0 && i != 1) || Mj.EnableProviderCC(i) == 0) {
            return false;
        }
        if (i == 0) {
            Mj.q = true;
        } else if (i == 1) {
            Mj.r = true;
        }
        return true;
    }

    public Location getLocationInfo() {
        Bundle GetGPSStatus = Mj.GetGPSStatus();
        if (GetGPSStatus == null) {
            return null;
        }
        if (GetGPSStatus.getInt("t") == 1) {
            this.a = new Location("network");
            this.a.setLatitude((double) GetGPSStatus.getFloat("y"));
            this.a.setLongitude((double) GetGPSStatus.getFloat("x"));
            this.a.setAccuracy((float) GetGPSStatus.getInt("r"));
        } else {
            this.a = Mj.a.a;
            this.a.setLatitude((double) GetGPSStatus.getFloat("y"));
            this.a.setLongitude((double) GetGPSStatus.getFloat("x"));
        }
        return this.a;
    }

    public Bundle getNotifyInternal() {
        return Mj.GetNotifyInternal();
    }

    public void removeUpdates(LocationListener locationListener) {
        this.e.remove(locationListener);
    }

    public void requestLocationUpdates(LocationListener locationListener) {
        this.e.add(locationListener);
    }

    public void setLocationCoordinateType(int i) {
        Mj.c = i;
        Mj.SetLocationCoordinateType(i);
    }

    public boolean setNotifyInternal(int i, int i2) {
        if (i < i2 || i2 < 0) {
            return false;
        }
        this.c = (long) i;
        return Mj.SetNotifyInternal(i, i2) == 1;
    }
}
