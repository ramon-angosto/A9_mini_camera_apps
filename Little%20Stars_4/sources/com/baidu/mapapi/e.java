package com.baidu.mapapi;

import android.graphics.Point;
import android.os.Bundle;

class e implements Projection {
    private MapView a = null;

    public e(MapView mapView) {
        this.a = mapView;
    }

    /* access modifiers changed from: package-private */
    public Point a(GeoPoint geoPoint, Point point) {
        Bundle bundle = new Bundle();
        bundle.putInt("act", 15010200);
        bundle.putInt("x", geoPoint.getLongitudeE6());
        bundle.putInt("y", geoPoint.getLatitudeE6());
        Mj.sendBundle(bundle);
        if (point == null) {
            point = new Point(0, 0);
        }
        point.x = bundle.getInt("x");
        point.y = bundle.getInt("y");
        return point;
    }

    public GeoPoint fromPixels(int i, int i2) {
        int i3 = i - this.a.b.c;
        int i4 = i2 - this.a.b.d;
        if (this.a.b.e != 1.0d) {
            double d = (double) (i3 - this.a.b.f);
            double d2 = this.a.b.e;
            Double.isNaN(d);
            int i5 = (int) (d / d2);
            double d3 = (double) (i4 - this.a.b.g);
            double d4 = this.a.b.e;
            Double.isNaN(d3);
            i3 = i5 + this.a.b.f;
            i4 = ((int) (d3 / d4)) + this.a.b.g;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("act", 15010100);
        bundle.putInt("x", i3);
        bundle.putInt("y", i4);
        Mj.sendBundle(bundle);
        return new GeoPoint(bundle.getInt("y"), bundle.getInt("x"));
    }

    public float metersToEquatorPixels(float f) {
        double d = (double) f;
        double h = this.a.h();
        Double.isNaN(d);
        return (float) (d / h);
    }

    public Point toPixels(GeoPoint geoPoint, Point point) {
        Bundle bundle = new Bundle();
        bundle.putInt("act", 15010200);
        bundle.putInt("x", geoPoint.getLongitudeE6());
        bundle.putInt("y", geoPoint.getLatitudeE6());
        Mj.sendBundle(bundle);
        if (point == null) {
            point = new Point(0, 0);
        }
        point.x = bundle.getInt("x");
        point.y = bundle.getInt("y");
        if (this.a.b.e != 1.0d) {
            double d = (double) (point.x - this.a.b.f);
            double d2 = this.a.b.e;
            Double.isNaN(d);
            int i = (int) ((d * d2) + 0.5d);
            double d3 = (double) (point.y - this.a.b.g);
            double d4 = this.a.b.e;
            Double.isNaN(d3);
            point.x = this.a.b.f + i;
            point.y = this.a.b.g + ((int) ((d3 * d4) + 0.5d));
        }
        point.x += this.a.b.c;
        point.y += this.a.b.d;
        return point;
    }
}
