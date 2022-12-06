package com.huawei.android.pushselfshow.richpush.html.a.a;

import android.location.LocationManager;
import com.huawei.android.pushselfshow.richpush.html.a.j;
import com.huawei.android.pushselfshow.richpush.html.api.d;

public class a extends c {
    public a(LocationManager locationManager, j jVar) {
        super(locationManager, jVar, "GPSListener");
    }

    public void a(long j, float f) {
        if (this.b) {
            return;
        }
        if (this.a.getProvider("gps") != null) {
            this.b = true;
            this.a.requestLocationUpdates("gps", j, f, this);
            return;
        }
        a(d.a.POSITION_UNAVAILABLE_GPS);
    }
}
