package com.baidu.mapapi;

import android.graphics.Point;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;

public class MapController implements View.OnKeyListener {
    private MapView a = null;

    MapController(MapView mapView) {
        this.a = mapView;
        mapView.b.setOnKeyListener(this);
    }

    public void animateTo(GeoPoint geoPoint) {
        this.a.a(geoPoint, (Message) null, (Runnable) null);
    }

    public void animateTo(GeoPoint geoPoint, Message message) {
        this.a.a(geoPoint, message, (Runnable) null);
    }

    public void animateTo(GeoPoint geoPoint, Runnable runnable) {
        this.a.a(geoPoint, (Message) null, runnable);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.a.b != view || keyEvent.getAction() != 0) {
            return false;
        }
        switch (i) {
            case 19:
                scrollBy(0, -50);
                return true;
            case 20:
                scrollBy(0, 50);
                return true;
            case 21:
                scrollBy(-50, 0);
                return true;
            case 22:
                scrollBy(50, 0);
                return true;
            default:
                return false;
        }
    }

    public void scrollBy(int i, int i2) {
        if (i != 0 || i2 != 0) {
            this.a.b(i, i2);
        }
    }

    public void setCenter(GeoPoint geoPoint) {
        this.a.a(geoPoint);
    }

    public void setMaxZoomLevel(int i) {
        this.a.a(i);
    }

    public void setMinZoomLevel(int i) {
        this.a.b(i);
    }

    public int setZoom(int i) {
        this.a.c(i);
        return this.a.getZoomLevel();
    }

    public void stopAnimation(boolean z) {
        this.a.a(z);
    }

    public void stopPanning() {
        setCenter(this.a.getMapCenter());
    }

    public boolean zoomIn() {
        return this.a.f();
    }

    public boolean zoomInFixing(int i, int i2) {
        GeoPoint fromPixels = this.a.getProjection().fromPixels(i, i2);
        boolean zoomIn = zoomIn();
        if (zoomIn) {
            Point point = new Point();
            this.a.getProjection().toPixels(fromPixels, point);
            scrollBy(point.x - i, point.y - i2);
        }
        return zoomIn;
    }

    public boolean zoomOut() {
        return this.a.g();
    }

    public boolean zoomOutFixing(int i, int i2) {
        GeoPoint fromPixels = this.a.getProjection().fromPixels(i, i2);
        boolean zoomOut = zoomOut();
        if (zoomOut) {
            Point point = new Point();
            this.a.getProjection().toPixels(fromPixels, point);
            scrollBy(point.x - i, point.y - i2);
        }
        return zoomOut;
    }

    public void zoomToSpan(int i, int i2) {
        this.a.a(i, i2);
    }
}
