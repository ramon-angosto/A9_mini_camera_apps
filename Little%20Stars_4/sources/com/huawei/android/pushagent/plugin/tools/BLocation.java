package com.huawei.android.pushagent.plugin.tools;

import android.content.Context;
import android.location.Location;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.LocationListener;
import com.baidu.mapapi.MKGeneralListener;
import com.huawei.android.pushagent.c.a.e;

public class BLocation {
    public static final String TAG = "PushLogSC2705";
    private static BLocation a;
    /* access modifiers changed from: private */
    public static BMapManager b;
    /* access modifiers changed from: private */
    public LocationListener c = new MyLocationListener();
    /* access modifiers changed from: private */
    public Location d;

    private static class MyGeneralListener implements MKGeneralListener {
        private MyGeneralListener() {
        }

        public void onGetNetworkState(int i) {
            e.a(BLocation.TAG, "onGetNetworkState error is " + i);
        }

        public void onGetPermissionState(int i) {
            e.a(BLocation.TAG, "onGetPermissionState error is " + i);
            if (i == 300) {
                e.a(BLocation.TAG, "key is invalid");
            }
        }
    }

    private class MyLocationListener implements LocationListener {
        private MyLocationListener() {
        }

        public void onLocationChanged(Location location) {
            e.a(BLocation.TAG, "onLocationChanged:" + com.huawei.android.pushagent.c.a.a.e.a((Object) location));
            if (location != null) {
                try {
                    Location unused = BLocation.this.d = location;
                    BLocation.b.getLocationManager().removeUpdates(BLocation.this.c);
                    BLocation.b.stop();
                } catch (Exception e) {
                    e.a(BLocation.TAG, "onLocationChanged error:" + e.getMessage(), (Throwable) e);
                }
            }
        }
    }

    private BLocation() {
    }

    private synchronized void a(Context context) {
        if (b == null) {
            try {
                b = new BMapManager(context.getApplicationContext());
                b.init("C031E14DA209AEF13B985501A3ACC7F83053D7D4", new MyGeneralListener());
                b.start();
            } catch (Exception e) {
                e.a(TAG, "initBdLocation error:" + e.getMessage(), (Throwable) e);
            }
        }
        return;
    }

    public static synchronized BLocation getInstance(Context context) {
        BLocation bLocation;
        synchronized (BLocation.class) {
            if (a == null) {
                a = new BLocation();
                a.a(context);
            }
            bLocation = a;
        }
        return bLocation;
    }

    public Location getLocation() {
        return this.d;
    }

    public void requestLocation() {
        try {
            this.d = null;
            b.getLocationManager().requestLocationUpdates(this.c);
            b.start();
        } catch (Exception e) {
            e.a(TAG, "requestLocation error:" + e.getMessage(), (Throwable) e);
        }
    }
}
