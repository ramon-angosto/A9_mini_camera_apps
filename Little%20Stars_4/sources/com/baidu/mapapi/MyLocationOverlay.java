package com.baidu.mapapi;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.location.Location;
import android.os.Bundle;
import com.baidu.mapapi.Overlay;
import java.io.InputStream;

public class MyLocationOverlay extends Overlay implements SensorEventListener, LocationListener, Overlay.Snappable {
    private Location a = null;
    private GeoPoint b = null;
    private GeoPoint c = null;
    private Runnable d = null;
    private MapView e = null;
    private Bitmap f = null;
    private Bitmap g = null;
    private Bitmap h = null;
    private boolean i = false;
    private boolean j = false;
    private float k = 0.0f;
    private Paint l = null;

    public MyLocationOverlay(Context context, MapView mapView) {
        if (mapView != null) {
            this.e = mapView;
            this.l = new Paint();
            this.l.setARGB(35, 0, 0, 128);
            this.l.setStyle(Paint.Style.FILL_AND_STROKE);
            this.l.setAntiAlias(true);
            try {
                AssetManager assets = context.getAssets();
                InputStream open = assets.open("icon_my.png");
                this.f = BitmapFactory.decodeStream(open);
                open.close();
                InputStream open2 = assets.open("compass_bg.png");
                this.g = BitmapFactory.decodeStream(open2);
                open2.close();
                InputStream open3 = assets.open("compass_pointer.png");
                this.h = BitmapFactory.decodeStream(open3);
                open3.close();
            } catch (Exception unused) {
            }
        } else {
            throw new IllegalArgumentException("mapView is null");
        }
    }

    /* access modifiers changed from: protected */
    public GeoPoint GetBaidu09Point(GeoPoint geoPoint, int i2) {
        Bundle bundle;
        if (geoPoint == null) {
            return null;
        }
        if (i2 == 0) {
            bundle = CoordinateConvert.fromWgs84ToBaidu(geoPoint);
        } else if (i2 != 1) {
            return geoPoint;
        } else {
            bundle = CoordinateConvert.fromGcjToBaidu(geoPoint);
        }
        return CoordinateConvert.bundleDecode(bundle);
    }

    public void disableCompass() {
        this.j = false;
        Mj.b.b(this);
        this.e.b.b = 0;
        this.e.invalidate();
    }

    public void disableMyLocation() {
        this.i = false;
        this.a = null;
        this.b = null;
        this.c = null;
        Mj.b.removeUpdates(this);
        this.e.invalidate();
    }

    /* access modifiers changed from: protected */
    public boolean dispatchTap() {
        return false;
    }

    public boolean draw(Canvas canvas, MapView mapView, boolean z, long j2) {
        GeoPoint geoPoint;
        if (z) {
            return false;
        }
        Location location = this.a;
        if (!(location == null || this.b == null || (geoPoint = this.c) == null)) {
            drawMyLocation(canvas, mapView, location, geoPoint, j2);
        }
        if (!this.j) {
            return true;
        }
        drawCompass(canvas, this.k);
        return true;
    }

    /* access modifiers changed from: protected */
    public void drawCompass(Canvas canvas, float f2) {
        if (f2 <= 360.0f && f2 >= -360.0f) {
            float f3 = (float) 10;
            canvas.drawBitmap(this.g, f3, f3, (Paint) null);
            Matrix matrix = new Matrix();
            matrix.postTranslate(f3, f3);
            matrix.postRotate(-f2, (float) ((this.h.getWidth() / 2) + 10), (float) ((this.h.getHeight() / 2) + 10));
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            canvas.drawBitmap(this.h, matrix, paint);
        }
    }

    /* access modifiers changed from: protected */
    public void drawMyLocation(Canvas canvas, MapView mapView, Location location, GeoPoint geoPoint, long j2) {
        if (geoPoint != null) {
            Point pixels = mapView.getProjection().toPixels(geoPoint, (Point) null);
            canvas.drawBitmap(this.f, (float) (pixels.x - (this.f.getWidth() / 2)), (float) (pixels.y - (this.f.getHeight() / 2)), (Paint) null);
            if (location.hasAccuracy()) {
                canvas.drawCircle((float) pixels.x, (float) pixels.y, mapView.getProjection().metersToEquatorPixels(location.getAccuracy()), this.l);
            }
        }
    }

    public boolean enableCompass() {
        this.j = Mj.b.a((SensorEventListener) this);
        return this.j;
    }

    public boolean enableMyLocation() {
        Mj.b.requestLocationUpdates(this);
        this.a = Mj.b.getLocationInfo();
        Location location = this.a;
        if (location != null) {
            this.b = new GeoPoint(location.getLatitude(), this.a.getLongitude());
            this.c = GetBaidu09Point(this.b, Mj.c);
        }
        this.i = true;
        this.e.invalidate();
        return true;
    }

    public Location getLastFix() {
        return this.a;
    }

    public GeoPoint getMyLocation() {
        return this.b;
    }

    public float getOrientation() {
        return this.k;
    }

    public boolean isCompassEnabled() {
        return this.j;
    }

    public boolean isMyLocationEnabled() {
        return this.i;
    }

    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public void onLocationChanged(Location location) {
        this.a = location;
        if (this.a == null) {
            this.b = null;
            this.c = null;
            this.e.invalidate();
            return;
        }
        this.b = new GeoPoint(location.getLatitude(), location.getLongitude());
        this.c = GetBaidu09Point(this.b, Mj.c);
        this.e.invalidate();
        Runnable runnable = this.d;
        if (runnable != null) {
            runnable.run();
            this.d = null;
        }
    }

    public void onProviderDisabled(String str) {
        this.i = false;
    }

    public void onProviderEnabled(String str) {
        this.i = true;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 3) {
            int i2 = (int) sensorEvent.values[0];
            if (this.e.getResources().getConfiguration().orientation == 2) {
                i2 = (i2 + 90) % 360;
            }
            float f2 = (float) i2;
            if (Math.abs(f2 - this.k) >= 10.0f) {
                this.k = f2;
                if (this.e.b != null) {
                    this.e.b.b = i2;
                    this.e.invalidate();
                }
            }
        }
    }

    public boolean onSnapToItem(int i2, int i3, Point point, MapView mapView) {
        return false;
    }

    public boolean onTap(GeoPoint geoPoint, MapView mapView) {
        GeoPoint myLocation = getMyLocation();
        if (myLocation != null) {
            Point pixels = this.e.getProjection().toPixels(myLocation, (Point) null);
            Bitmap bitmap = this.f;
            if (bitmap == null) {
                return false;
            }
            int width = bitmap.getWidth() / 2;
            int height = this.f.getHeight() / 2;
            Rect rect = new Rect(pixels.x - width, pixels.y - height, pixels.x + width, pixels.y + height);
            Point pixels2 = this.e.getProjection().toPixels(geoPoint, (Point) null);
            if (rect.contains(pixels2.x, pixels2.y)) {
                return dispatchTap();
            }
        }
        return false;
    }

    public boolean runOnFirstFix(Runnable runnable) {
        if (this.a != null) {
            runnable.run();
            return true;
        }
        this.d = runnable;
        return false;
    }
}
