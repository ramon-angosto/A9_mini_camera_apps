package com.baidu.mapapi;

import android.os.Bundle;

public class CoordinateConvert {
    static Bundle a(GeoPoint geoPoint, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("act", 15010250);
        bundle.putInt("x", geoPoint.getLongitudeE6());
        bundle.putInt("y", geoPoint.getLatitudeE6());
        bundle.putInt("t", i);
        Mj.sendBundle(bundle);
        int i2 = bundle.getInt("x");
        int i3 = bundle.getInt("y");
        String valueOf = String.valueOf(c.a(String.valueOf(i2).toCharArray()));
        bundle.remove("x");
        bundle.putString("x", valueOf);
        String valueOf2 = String.valueOf(c.a(String.valueOf(i3).toCharArray()));
        bundle.remove("y");
        bundle.putString("y", valueOf2);
        return bundle;
    }

    public static GeoPoint bundleDecode(Bundle bundle) {
        GeoPoint geoPoint = new GeoPoint(0, 0);
        String string = bundle.getString("x");
        String string2 = bundle.getString("y");
        String valueOf = String.valueOf(c.b(string.toCharArray()));
        String valueOf2 = String.valueOf(c.b(string2.toCharArray()));
        int intValue = Integer.decode(valueOf).intValue();
        int intValue2 = Integer.decode(valueOf2).intValue();
        geoPoint.setLongitudeE6(intValue);
        geoPoint.setLatitudeE6(intValue2);
        return geoPoint;
    }

    public static Bundle fromGcjToBaidu(GeoPoint geoPoint) {
        return a(geoPoint, 2);
    }

    public static Bundle fromWgs84ToBaidu(GeoPoint geoPoint) {
        return a(geoPoint, 1);
    }
}
