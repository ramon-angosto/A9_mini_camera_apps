package com.huawei.android.pushselfshow.richpush.html.a.a;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.richpush.html.a.j;
import com.huawei.android.pushselfshow.richpush.html.api.d;

public class c implements LocationListener {
    protected LocationManager a;
    protected boolean b = false;
    private j c;
    private String d = "PLocationListener";

    public c(LocationManager locationManager, j jVar, String str) {
        this.a = locationManager;
        this.c = jVar;
        this.d = str;
    }

    private void a(Location location) {
        this.c.b(location);
        if (!this.c.b) {
            e.a(this.d, "Stopping global listener");
            b();
        }
    }

    public void a() {
        b();
    }

    public void a(long j, float f) {
        try {
            if (this.b) {
                return;
            }
            if (this.a.getProvider("network") != null) {
                this.b = true;
                this.a.requestLocationUpdates("network", j, f, this);
                return;
            }
            a(d.a.POSITION_UNAVAILABLE_NETOWRK);
        } catch (Exception e) {
            e.d(this.d, "start postion error ", e);
        }
    }

    /* access modifiers changed from: protected */
    public void a(d.a aVar) {
        this.c.a(aVar);
        if (!this.c.b) {
            e.a(this.d, "Stopping global listener");
            b();
        }
    }

    public void b() {
        try {
            if (this.b) {
                this.a.removeUpdates(this);
                this.b = false;
            }
        } catch (Exception e) {
            e.d(this.d, "stop postion error ", e);
        }
    }

    public void onLocationChanged(Location location) {
        e.a(this.d, "The location has been updated!");
        a(location);
    }

    public void onProviderDisabled(String str) {
        String str2 = this.d;
        e.a(str2, "Location provider '" + str + "' disabled.");
        a(d.a.POSITION_UNAVAILABLE_GPS);
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
        StringBuilder sb;
        String str2;
        String str3;
        String str4 = this.d;
        e.a(str4, "The status of the provider " + str + " has changed");
        if (i == 0) {
            String str5 = this.d;
            e.a(str5, str + " is OUT OF SERVICE");
            a("network".equals(str) ? d.a.POSTION_OUT_OF_SERVICE_NETOWRK : d.a.POSTION_OUT_OF_SERVICE_GPS);
            return;
        }
        if (i == 1) {
            str2 = this.d;
            sb = new StringBuilder();
            sb.append(str);
            str3 = " is TEMPORARILY_UNAVAILABLE";
        } else {
            str2 = this.d;
            sb = new StringBuilder();
            sb.append(str);
            str3 = " is AVAILABLE";
        }
        sb.append(str3);
        e.a(str2, sb.toString());
    }
}
