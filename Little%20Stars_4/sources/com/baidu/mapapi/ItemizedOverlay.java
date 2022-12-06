package com.baidu.mapapi;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.baidu.mapapi.Overlay;
import com.baidu.mapapi.OverlayItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public abstract class ItemizedOverlay<Item extends OverlayItem> extends Overlay implements Overlay.Snappable {
    private static int d = -1;
    private boolean a = true;
    private Drawable b;
    private Drawable c;
    private ItemizedOverlay<Item>.a e = null;
    private OnFocusChangeListener f = null;
    private int g = -1;
    private int h = -1;

    public interface OnFocusChangeListener {
        void onFocusChanged(ItemizedOverlay<?> itemizedOverlay, OverlayItem overlayItem);
    }

    class a implements Comparator<Integer> {
        private ArrayList<Item> b;
        private ArrayList<Integer> c;
        private ItemizedOverlay<Item> d;

        public a() {
            this.d = ItemizedOverlay.this;
            int size = ItemizedOverlay.this.size();
            this.b = new ArrayList<>(size);
            this.c = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                this.c.add(Integer.valueOf(i));
                this.b.add(ItemizedOverlay.this.createItem(i));
            }
            Collections.sort(this.c, this);
        }

        private Point a(OverlayItem overlayItem, Projection projection, Point point) {
            Point pixels = projection.toPixels(overlayItem.getPoint(), (Point) null);
            return new Point(point.x - pixels.x, point.y - pixels.y);
        }

        public final int a() {
            return this.b.size();
        }

        public final int a(Item item) {
            if (item != null) {
                for (int i = 0; i < this.b.size(); i++) {
                    if (item.equals(this.b.get(i))) {
                        return i;
                    }
                }
            }
            return -1;
        }

        /* renamed from: a */
        public int compare(Integer num, Integer num2) {
            GeoPoint point = ((OverlayItem) this.b.get(num.intValue())).getPoint();
            GeoPoint point2 = ((OverlayItem) this.b.get(num2.intValue())).getPoint();
            if (point.getLatitudeE6() > point2.getLatitudeE6()) {
                return -1;
            }
            if (point.getLatitudeE6() < point2.getLatitudeE6()) {
                return 1;
            }
            if (point.getLongitudeE6() < point2.getLongitudeE6()) {
                return -1;
            }
            return point.getLongitudeE6() == point2.getLongitudeE6() ? 0 : 1;
        }

        public final int a(boolean z) {
            if (this.b.size() == 0) {
                return 0;
            }
            int i = Integer.MIN_VALUE;
            int i2 = Integer.MAX_VALUE;
            Iterator<Item> it = this.b.iterator();
            while (it.hasNext()) {
                GeoPoint point = ((OverlayItem) it.next()).getPoint();
                int latitudeE6 = z ? point.getLatitudeE6() : point.getLongitudeE6();
                if (latitudeE6 > i) {
                    i = latitudeE6;
                }
                if (latitudeE6 < i2) {
                    i2 = latitudeE6;
                }
            }
            return i - i2;
        }

        public final Item a(int i) {
            return (OverlayItem) this.b.get(i);
        }

        public final boolean a(GeoPoint geoPoint, MapView mapView) {
            Projection projection = mapView.getProjection();
            Point pixels = projection.toPixels(geoPoint, (Point) null);
            int size = this.b.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                }
                OverlayItem overlayItem = (OverlayItem) this.b.get(i);
                double d2 = -1.0d;
                Point a2 = a(overlayItem, projection, pixels);
                Drawable drawable = overlayItem.mMarker;
                if (drawable == null) {
                    drawable = ItemizedOverlay.a(this.d);
                }
                if (this.d.hitTest(overlayItem, drawable, a2.x, a2.y)) {
                    d2 = (double) ((a2.x * a2.x) + (a2.y * a2.y));
                }
                if (d2 >= 0.0d && d2 < Double.MAX_VALUE) {
                    break;
                }
                i++;
            }
            if (-1 != i) {
                return this.d.onTap(i);
            }
            this.d.setFocus(null);
            return false;
        }

        public final int b(int i) {
            return this.c.get(i).intValue();
        }
    }

    enum b {
        Normal("Normal", 0),
        Center("Center", 1),
        CenterBottom("CenterBottom", 2);

        private b(String str, int i) {
        }
    }

    public ItemizedOverlay(Drawable drawable) {
        this.b = drawable;
        if (this.b != null) {
            this.c = new r().a(this.b);
            if (d == 0) {
                a(this.b, b.CenterBottom);
            }
        }
    }

    private static Drawable a(Drawable drawable, b bVar) {
        if (drawable == null || b.Normal == bVar) {
            return null;
        }
        Rect bounds = drawable.getBounds();
        int i = 0;
        if (bounds.height() == 0 || bounds.width() == 0) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        Rect bounds2 = drawable.getBounds();
        int width = bounds2.width() / 2;
        int i2 = -bounds2.height();
        if (bVar == b.Center) {
            i2 /= 2;
            i = -i2;
        }
        drawable.setBounds(-width, i2, width, i);
        return drawable;
    }

    static Drawable a(ItemizedOverlay<?> itemizedOverlay) {
        return itemizedOverlay.b;
    }

    private void a(Canvas canvas, MapView mapView, boolean z, OverlayItem overlayItem, int i) {
        boolean z2;
        Drawable marker = overlayItem.getMarker(i);
        if (marker != null || this.b != null) {
            if (marker != null) {
                Drawable drawable = this.b;
                z2 = drawable == null ? false : marker.equals(drawable);
            } else {
                z2 = true;
            }
            if (z2) {
                if (z) {
                    marker = this.c;
                    marker.setBounds(this.b.copyBounds());
                    r.a(this.c, this.b);
                } else {
                    marker = this.b;
                }
            }
            Point pixels = mapView.getProjection().toPixels(overlayItem.getPoint(), (Point) null);
            if (z2) {
                Overlay.a(canvas, marker, pixels.x, pixels.y);
            } else {
                Overlay.drawAt(canvas, marker, pixels.x, pixels.y, z);
            }
        }
    }

    protected static Drawable boundCenter(Drawable drawable) {
        d = 2;
        return a(drawable, b.Center);
    }

    protected static Drawable boundCenterBottom(Drawable drawable) {
        d = 1;
        return a(drawable, b.CenterBottom);
    }

    /* access modifiers changed from: protected */
    public abstract Item createItem(int i);

    public void draw(Canvas canvas, MapView mapView, boolean z) {
        OverlayItem focus;
        ItemizedOverlay<Item>.a aVar = this.e;
        if (aVar != null) {
            int a2 = aVar.a();
            for (int i = 0; i < a2; i++) {
                int indexToDraw = getIndexToDraw(i);
                if (indexToDraw != this.h) {
                    OverlayItem item = getItem(indexToDraw);
                    Point pixels = mapView.getProjection().toPixels(item.getPoint(), (Point) null);
                    int left = mapView.getLeft();
                    int right = mapView.getRight();
                    int top = mapView.getTop();
                    int bottom = mapView.getBottom();
                    pixels.x += left;
                    pixels.y += top;
                    if (pixels.x >= left && pixels.y >= top && pixels.x <= right && pixels.y <= bottom) {
                        a(canvas, mapView, z, item, 0);
                    }
                }
            }
        }
        if (this.a && (focus = getFocus()) != null) {
            a(canvas, mapView, false, focus, 4);
        }
    }

    public GeoPoint getCenter() {
        return getItem(getIndexToDraw(0)).getPoint();
    }

    public Item getFocus() {
        int i = this.h;
        if (i != -1) {
            return this.e.a(i);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int getIndexToDraw(int i) {
        return this.e.b(i);
    }

    public final Item getItem(int i) {
        return this.e.a(i);
    }

    public final int getLastFocusedIndex() {
        return this.g;
    }

    public int getLatSpanE6() {
        return this.e.a(true);
    }

    public int getLonSpanE6() {
        return this.e.a(false);
    }

    /* access modifiers changed from: protected */
    public boolean hitTest(OverlayItem overlayItem, Drawable drawable, int i, int i2) {
        Rect bounds = drawable.getBounds();
        bounds.left -= 10;
        bounds.right += 10;
        bounds.bottom += 10;
        bounds.top -= 10;
        boolean contains = bounds.contains(i, i2);
        bounds.left += 10;
        bounds.right -= 10;
        bounds.bottom -= 10;
        bounds.top += 10;
        return contains;
    }

    public Item nextFocus(boolean z) {
        ItemizedOverlay<Item>.a aVar;
        int i;
        if (this.e.a() == 0) {
            return null;
        }
        int i2 = this.g;
        if (i2 != -1) {
            int i3 = this.h;
            if (i3 != -1) {
                i2 = i3;
            }
            if (z) {
                if (i2 == this.e.a() - 1) {
                    return null;
                }
                aVar = this.e;
                i = i2 + 1;
            } else if (i2 == 0) {
                return null;
            } else {
                aVar = this.e;
                i = i2 - 1;
            }
        } else if (this.h == -1) {
            return null;
        } else {
            aVar = this.e;
            i = 0;
        }
        return aVar.a(i);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent, MapView mapView) {
        return false;
    }

    public boolean onSnapToItem(int i, int i2, Point point, MapView mapView) {
        if (this.e.a() > 0) {
            Point point2 = new Point();
            OverlayItem a2 = this.e.a(0);
            mapView.getProjection().toPixels(a2.getPoint(), point2);
            if (hitTest(a2, a2.mMarker, i - point2.x, i2 - point2.y)) {
                point.x = point2.x;
                point.y = point2.y;
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onTap(int i) {
        if (i == this.h) {
            return false;
        }
        setFocus(getItem(i));
        return false;
    }

    public boolean onTap(GeoPoint geoPoint, MapView mapView) {
        ItemizedOverlay<Item>.a aVar = this.e;
        if (aVar != null) {
            return aVar.a(geoPoint, mapView);
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent, MapView mapView) {
        return false;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent, MapView mapView) {
        return false;
    }

    /* access modifiers changed from: protected */
    public final void populate() {
        this.e = new a();
        this.g = -1;
        this.h = -1;
    }

    public void setDrawFocusedItem(boolean z) {
        this.a = z;
    }

    public void setFocus(Item item) {
        if (item != null && this.h == this.e.a(item)) {
            return;
        }
        if (item != null || this.h == -1) {
            this.h = this.e.a(item);
            int i = this.h;
            if (i != -1) {
                setLastFocusedIndex(i);
                OnFocusChangeListener onFocusChangeListener = this.f;
                if (onFocusChangeListener != null) {
                    onFocusChangeListener.onFocusChanged(this, item);
                    return;
                }
                return;
            }
            return;
        }
        OnFocusChangeListener onFocusChangeListener2 = this.f;
        if (onFocusChangeListener2 != null) {
            onFocusChangeListener2.onFocusChanged(this, item);
        }
        this.h = -1;
    }

    /* access modifiers changed from: protected */
    public void setLastFocusedIndex(int i) {
        this.g = i;
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.f = onFocusChangeListener;
    }

    public abstract int size();
}
