package com.baidu.mapapi;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;

public abstract class Overlay {
    protected static final float SHADOW_X_SKEW = -0.9f;
    protected static final float SHADOW_Y_SCALE = 0.5f;

    public interface Snappable {
        boolean onSnapToItem(int i, int i2, Point point, MapView mapView);
    }

    static void a(Canvas canvas, Drawable drawable, int i, int i2) {
        Rect bounds = drawable.getBounds();
        if (bounds.width() == 0) {
            bounds.right = bounds.left + drawable.getIntrinsicWidth();
        }
        if (bounds.height() == 0) {
            bounds.bottom = bounds.top + drawable.getIntrinsicHeight();
        }
        drawable.setBounds(bounds.left + i, bounds.top + i2, bounds.right + i, bounds.bottom + i2);
        drawable.draw(canvas);
        drawable.setBounds(bounds.left - i, bounds.top - i2, bounds.right - i, bounds.bottom - i2);
    }

    protected static void drawAt(Canvas canvas, Drawable drawable, int i, int i2, boolean z) {
        if (z) {
            a(canvas, drawable, i, i2);
            Drawable a = new r().a(drawable);
            r.a(a, drawable);
            a(canvas, a, i, i2);
            return;
        }
        a(canvas, drawable, i, i2);
    }

    /* access modifiers changed from: package-private */
    public void a(int i, int i2, int i3, int i4) {
    }

    public void draw(Canvas canvas, MapView mapView, boolean z) {
    }

    public boolean draw(Canvas canvas, MapView mapView, boolean z, long j) {
        draw(canvas, mapView, z);
        return false;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent, MapView mapView) {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent, MapView mapView) {
        return false;
    }

    public boolean onTap(GeoPoint geoPoint, MapView mapView) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent, MapView mapView) {
        return false;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent, MapView mapView) {
        return false;
    }
}
