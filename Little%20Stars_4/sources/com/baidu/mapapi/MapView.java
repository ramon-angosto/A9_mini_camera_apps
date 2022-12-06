package com.baidu.mapapi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ZoomControls;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.List;

public class MapView extends ViewGroup {
    public static final int DRAG_MODE_NONE = 1;
    public static final int DRAG_MODE_SCALE = 0;
    private static int g;
    e a = new e(this);
    a b = null;
    private GeoPoint c = new GeoPoint(0, 0);
    private int d = 12;
    private int e = 0;
    private int f = 0;
    private int h = 18;
    private int i = 3;
    private boolean j = false;
    private boolean k = false;
    private Message l = null;
    private Runnable m = null;
    private MapActivity n = null;
    private MapController o;
    private ZoomControls p = new ZoomControls(getContext());
    private ImageView q = new ImageView(getContext());
    private boolean r = false;

    public static class LayoutParams extends ViewGroup.LayoutParams {
        public static final int BOTTOM = 80;
        public static final int BOTTOM_CENTER = 81;
        public static final int CENTER = 17;
        public static final int CENTER_HORIZONTAL = 1;
        public static final int CENTER_VERTICAL = 16;
        public static final int LEFT = 3;
        public static final int MODE_MAP = 0;
        public static final int MODE_VIEW = 1;
        public static final int RIGHT = 5;
        public static final int TOP = 48;
        public static final int TOP_LEFT = 51;
        public int alignment;
        public int mode;
        public GeoPoint point;
        public int x;
        public int y;

        public LayoutParams(int i, int i2, int i3, int i4, int i5) {
            super(i, i2);
            this.mode = 1;
            this.point = null;
            this.x = 0;
            this.y = 0;
            this.alignment = 51;
            this.mode = 1;
            this.x = i3;
            this.y = i4;
            this.alignment = i5;
        }

        public LayoutParams(int i, int i2, GeoPoint geoPoint, int i3) {
            this(i, i2, geoPoint, 0, 0, i3);
        }

        public LayoutParams(int i, int i2, GeoPoint geoPoint, int i3, int i4, int i5) {
            super(i, i2);
            this.mode = 1;
            this.point = null;
            this.x = 0;
            this.y = 0;
            this.alignment = 51;
            this.mode = 0;
            this.point = geoPoint;
            this.x = i3;
            this.y = i4;
            this.alignment = i5;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mode = 1;
            this.point = null;
            this.x = 0;
            this.y = 0;
            this.alignment = 51;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mode = 1;
            this.point = null;
            this.x = 0;
            this.y = 0;
            this.alignment = 51;
        }
    }

    enum a {
        DRAW_RETICLE_NEVER,
        DRAW_RETICLE_OVER,
        DRAW_RETICLE_UNDER
    }

    public MapView(Context context) {
        super(context);
        a(context);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public MapView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(View view, ViewGroup.LayoutParams layoutParams) {
        view.measure(this.e, this.f);
        int i2 = layoutParams.width;
        int i3 = layoutParams.height;
        if (i2 == -1) {
            i2 = this.e;
        } else if (i2 == -2) {
            i2 = view.getMeasuredWidth();
        }
        if (i3 == -1) {
            i3 = this.f;
        } else if (i3 == -2) {
            i3 = view.getMeasuredHeight();
        }
        if (checkLayoutParams(layoutParams)) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            int i4 = layoutParams2.x;
            int i5 = layoutParams2.y;
            if (layoutParams2.mode == 0 && layoutParams2.point != null) {
                Point pixels = getProjection().toPixels(layoutParams2.point, (Point) null);
                int i6 = pixels.x + layoutParams2.x;
                i5 = pixels.y + layoutParams2.y;
                i4 = i6;
            }
            int i7 = layoutParams2.alignment;
            if (i7 == 1) {
                i4 -= i2 / 2;
            } else if (i7 != 3) {
                if (i7 == 5) {
                    i4 -= i2;
                } else if (!(i7 == 48 || i7 == 51)) {
                    if (i7 != 16) {
                        if (i7 != 17) {
                            if (i7 != 80) {
                                if (i7 == 81) {
                                    i4 -= i2 / 2;
                                }
                            }
                            i5 -= i3;
                        } else {
                            i4 -= i2 / 2;
                        }
                    }
                    i5 -= i3 / 2;
                }
            }
            view.layout(i4, i5, i2 + i4, i3 + i5);
            return;
        }
        view.layout(0, 0, i2, i3);
    }

    private boolean a(Context context) {
        MapActivity mapActivity = (MapActivity) context;
        this.e = Mj.g;
        this.f = Mj.h;
        this.n = mapActivity;
        g++;
        return mapActivity.a(this);
    }

    private void d(int i2) {
        this.d = i2;
        c();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        this.h = i2;
        if (this.d > i2) {
            c(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3) {
        Mj.MapProc(4354, i2, i3);
    }

    /* access modifiers changed from: package-private */
    public void a(GeoPoint geoPoint) {
        Mj.MapProc(4102, geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6());
    }

    /* access modifiers changed from: package-private */
    public void a(GeoPoint geoPoint, Message message, Runnable runnable) {
        Mj.MapProc(4353, geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6());
        this.l = message;
        this.m = runnable;
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        if (z) {
            Mj.MapProc(4355, 1, 0);
        } else {
            Mj.MapProc(4355, 0, 0);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: android.graphics.Bitmap} */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r3v6, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c3, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c4, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a7 A[SYNTHETIC, Splitter:B:35:0x00a7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a() {
        /*
            r6 = this;
            com.baidu.mapapi.a r0 = r6.b
            if (r0 != 0) goto L_0x000f
            com.baidu.mapapi.a r0 = new com.baidu.mapapi.a
            android.content.Context r1 = r6.getContext()
            r0.<init>(r1, r6)
            r6.b = r0
        L_0x000f:
            com.baidu.mapapi.MapController r0 = r6.o
            if (r0 != 0) goto L_0x001a
            com.baidu.mapapi.MapController r0 = new com.baidu.mapapi.MapController
            r0.<init>(r6)
            r6.o = r0
        L_0x001a:
            com.baidu.mapapi.a r0 = r6.b
            android.view.ViewParent r0 = r0.getParent()
            if (r0 != 0) goto L_0x0027
            com.baidu.mapapi.a r0 = r6.b
            r6.addView(r0)
        L_0x0027:
            android.widget.ZoomControls r0 = r6.p
            android.view.ViewParent r0 = r0.getParent()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0054
            android.widget.ZoomControls r0 = r6.p
            com.baidu.mapapi.MapView$1 r3 = new com.baidu.mapapi.MapView$1
            r3.<init>()
            r0.setOnZoomOutClickListener(r3)
            android.widget.ZoomControls r0 = r6.p
            com.baidu.mapapi.MapView$2 r3 = new com.baidu.mapapi.MapView$2
            r3.<init>()
            r0.setOnZoomInClickListener(r3)
            android.widget.ZoomControls r0 = r6.p
            r0.setFocusable(r1)
            android.widget.ZoomControls r0 = r6.p
            r0.setVisibility(r2)
            android.widget.ZoomControls r0 = r6.p
            r0.measure(r2, r2)
        L_0x0054:
            android.widget.ImageView r0 = r6.q
            android.view.ViewParent r0 = r0.getParent()
            if (r0 != 0) goto L_0x00d8
            r0 = 2
            char[] r0 = new char[r0]     // Catch:{ Exception -> 0x00c9 }
            r3 = 108(0x6c, float:1.51E-43)
            r0[r2] = r3     // Catch:{ Exception -> 0x00c9 }
            r3 = 104(0x68, float:1.46E-43)
            r0[r1] = r3     // Catch:{ Exception -> 0x00c9 }
            int r3 = com.baidu.mapapi.Mj.i     // Catch:{ Exception -> 0x00c9 }
            r4 = 180(0xb4, float:2.52E-43)
            if (r3 > r4) goto L_0x006f
            r3 = 0
            goto L_0x0070
        L_0x006f:
            r3 = 1
        L_0x0070:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c9 }
            r4.<init>()     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r5 = "baidumap_logo_"
            r4.append(r5)     // Catch:{ Exception -> 0x00c9 }
            char r0 = r0[r3]     // Catch:{ Exception -> 0x00c9 }
            r4.append(r0)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r0 = ".png"
            r4.append(r0)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x00c9 }
            r3 = 0
            com.baidu.mapapi.MapActivity r4 = r6.n     // Catch:{ OutOfMemoryError -> 0x009f, all -> 0x009d }
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch:{ OutOfMemoryError -> 0x009f, all -> 0x009d }
            java.io.InputStream r0 = r4.open(r0)     // Catch:{ OutOfMemoryError -> 0x009f, all -> 0x009d }
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r0)     // Catch:{ OutOfMemoryError -> 0x009b }
        L_0x0097:
            r0.close()     // Catch:{ Exception -> 0x00c9 }
            goto L_0x00a5
        L_0x009b:
            r4 = move-exception
            goto L_0x00a1
        L_0x009d:
            r2 = move-exception
            goto L_0x00c5
        L_0x009f:
            r4 = move-exception
            r0 = r3
        L_0x00a1:
            r4.printStackTrace()     // Catch:{ all -> 0x00c3 }
            goto L_0x0097
        L_0x00a5:
            if (r3 == 0) goto L_0x00d8
            android.widget.ImageView r0 = r6.q     // Catch:{ Exception -> 0x00c9 }
            r0.setImageBitmap(r3)     // Catch:{ Exception -> 0x00c9 }
            android.widget.ImageView r0 = r6.q     // Catch:{ Exception -> 0x00c9 }
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x00c9 }
            android.widget.ImageView r0 = r6.q     // Catch:{ Exception -> 0x00c9 }
            r0.measure(r2, r2)     // Catch:{ Exception -> 0x00c9 }
            android.widget.ImageView r0 = r6.q     // Catch:{ Exception -> 0x00c9 }
            android.widget.ImageView$ScaleType r2 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ Exception -> 0x00c9 }
            r0.setScaleType(r2)     // Catch:{ Exception -> 0x00c9 }
            android.widget.ImageView r0 = r6.q     // Catch:{ Exception -> 0x00c9 }
            r6.addView(r0)     // Catch:{ Exception -> 0x00c9 }
            goto L_0x00d8
        L_0x00c3:
            r2 = move-exception
            r3 = r0
        L_0x00c5:
            r3.close()     // Catch:{ Exception -> 0x00c9 }
            throw r2     // Catch:{ Exception -> 0x00c9 }
        L_0x00c9:
            r0 = move-exception
            java.lang.String r2 = "MapView()"
            java.lang.String r3 = "initMapView() error!"
            android.util.Log.d(r2, r3)
            java.lang.String r0 = r0.getMessage()
            android.util.Log.d(r2, r0)
        L_0x00d8:
            com.baidu.mapapi.a r0 = r6.b
            r0.setFocusable(r1)
            com.baidu.mapapi.a r0 = r6.b
            r0.setFocusableInTouchMode(r1)
            int r0 = r6.d()
            r6.d = r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.MapView.a():boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2, int i3, int i4) {
        if (i2 == 9) {
            a aVar = this.b;
            if (aVar != null) {
                aVar.a = true;
                aVar.invalidate();
            }
        } else if (i2 == 505) {
            d(i3);
        } else if (i2 != 8020) {
            return false;
        } else {
            Message message = this.l;
            if (message == null) {
                Runnable runnable = this.m;
                if (runnable != null) {
                    runnable.run();
                }
            } else if (message.getTarget() != null) {
                this.l.getTarget().sendMessage(this.l);
                this.l = null;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        int i2 = g;
        if (i2 > 0) {
            g = i2 - 1;
            if (g == 0) {
                this.b.a();
                this.b = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        this.i = i2;
        if (this.d < i2) {
            c(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i2, int i3) {
        Mj.MapProc(4103, (this.e / 2) + i2, (this.f / 2) + i3);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        boolean z = true;
        this.p.setIsZoomOutEnabled(this.d > getMinZoomLevel());
        ZoomControls zoomControls = this.p;
        if (this.d >= getMaxZoomLevel()) {
            z = false;
        }
        zoomControls.setIsZoomInEnabled(z);
    }

    /* access modifiers changed from: package-private */
    public boolean c(int i2) {
        this.d = getZoomLevel();
        int i3 = this.i;
        if (i2 >= i3 && i2 <= (i3 = this.h)) {
            i3 = i2;
        }
        if (this.d == i3) {
            return false;
        }
        this.d = i3;
        this.b.a(i3);
        c();
        return true;
    }

    public boolean canCoverCenter() {
        Bundle bundle = new Bundle();
        bundle.putInt("act", 15010001);
        Mj.sendBundle(bundle);
        return bundle.getInt("r") != 0;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void computeScroll() {
        super.computeScroll();
    }

    /* access modifiers changed from: package-private */
    public int d() {
        Bundle newBundle = Mj.getNewBundle(10030300, 0, 0);
        if (newBundle != null) {
            return newBundle.getInt("mapLevel");
        }
        return 0;
    }

    public void displayZoomControls(boolean z) {
        if (!this.r || this.p.getParent() == null) {
            removeView(this.p);
            addView(this.p);
            this.r = true;
        }
        if (z) {
            ZoomControls zoomControls = this.p;
            requestChildFocus(zoomControls, zoomControls);
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = super.getChildAt(i2);
            if (!(childAt == this.q || childAt == this.p || childAt == this.b)) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if ((layoutParams instanceof LayoutParams) && ((LayoutParams) layoutParams).mode == 0) {
                    a(childAt, layoutParams);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        if (this.d >= this.h) {
            return false;
        }
        this.b.a(1, this.e / 2, this.f / 2);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        if (this.d <= this.i) {
            return false;
        }
        this.b.a(-1, this.e / 2, this.f / 2);
        return true;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(this.n, attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public MapController getController() {
        return this.o;
    }

    public int getLatitudeSpan() {
        e eVar = (e) getProjection();
        return Math.abs(eVar.fromPixels(0, 0).getLatitudeE6() - eVar.fromPixels(this.e - 1, this.f - 1).getLatitudeE6());
    }

    public int getLongitudeSpan() {
        e eVar = (e) getProjection();
        return Math.abs(eVar.fromPixels(this.e - 1, this.f - 1).getLongitudeE6() - eVar.fromPixels(0, 0).getLongitudeE6());
    }

    public GeoPoint getMapCenter() {
        Bundle GetMapStatus = Mj.GetMapStatus();
        if (GetMapStatus != null) {
            int i2 = GetMapStatus.getInt("x");
            int i3 = GetMapStatus.getInt("y");
            this.c.setLongitudeE6(i2);
            this.c.setLatitudeE6(i3);
        }
        return this.c;
    }

    public int getMaxZoomLevel() {
        return this.h;
    }

    public int getMinZoomLevel() {
        return this.i;
    }

    public final List<Overlay> getOverlays() {
        a aVar = this.b;
        if (aVar == null) {
            return null;
        }
        return aVar.c();
    }

    public Projection getProjection() {
        return this.a;
    }

    @Deprecated
    public View getZoomControls() {
        return this.p;
    }

    public int getZoomLevel() {
        int d2 = d();
        if (this.d != 0) {
            this.d = d2;
        }
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public double h() {
        return Math.pow(2.0d, (double) (18 - this.d));
    }

    public void invalidate() {
        a aVar = this.b;
        if (aVar != null) {
            aVar.invalidate();
        }
        ZoomControls zoomControls = this.p;
        if (zoomControls != null) {
            zoomControls.invalidate();
        }
        super.invalidate();
    }

    public boolean isDoubleClickZooming() {
        return this.b.b();
    }

    public boolean isSatellite() {
        return this.k;
    }

    public boolean isStreetView() {
        return false;
    }

    public boolean isTraffic() {
        return this.j;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        a();
        if (this.r) {
            setBuiltInZoomControls(true);
        }
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (this.r && this.p.getParent() != null) {
            removeView(this.p);
        }
        removeView(this.b);
        removeView(this.q);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void onFocusChanged(boolean z, int i2, Rect rect) {
        this.b.a(z, i2, rect);
        super.onFocusChanged(z, i2, rect);
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.b.a(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (this.b.b(i2, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6 = i4 - i2;
        this.e = i6;
        int i7 = i5 - i3;
        this.f = i7;
        this.b.setLayoutParams(new ViewGroup.LayoutParams(this.e, this.f));
        this.b.setVisibility(0);
        this.b.layout(0, 0, this.e, this.f);
        this.p.setLayoutParams(new ViewGroup.LayoutParams(this.e, this.f));
        this.p.setVisibility(0);
        this.p.measure(i6, i7);
        int measuredWidth = this.p.getMeasuredWidth();
        int measuredHeight = this.p.getMeasuredHeight();
        int i8 = i4 - 10;
        int i9 = i5 - 5;
        int i10 = i9 - i3;
        this.p.layout(i8 - measuredWidth, (i9 - measuredHeight) - i3, i8, i10);
        this.q.setLayoutParams(new ViewGroup.LayoutParams(this.e, this.f));
        this.q.setVisibility(0);
        this.q.measure(i6, i7);
        int measuredWidth2 = this.q.getMeasuredWidth();
        int measuredHeight2 = this.q.getMeasuredHeight();
        if (measuredHeight > measuredHeight2) {
            measuredHeight2 = measuredHeight;
        }
        this.q.layout(10, (i9 - measuredHeight2) - i3, measuredWidth2 + 10, i10);
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = super.getChildAt(i11);
            if (!(childAt == this.q || childAt == this.p || childAt == this.b)) {
                a(childAt, childAt.getLayoutParams());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        int i2 = bundle.getInt("lat");
        int i3 = bundle.getInt("lon");
        if (!(i2 == 0 || i3 == 0)) {
            a(new GeoPoint(i2, i3));
        }
        int i4 = bundle.getInt("zoom");
        if (i4 != 0) {
            c(i4);
        }
        setTraffic(bundle.getBoolean("traffic"));
    }

    public void onSaveInstanceState(Bundle bundle) {
        GeoPoint mapCenter = getMapCenter();
        bundle.putInt("lat", mapCenter.getLatitudeE6());
        bundle.putInt("lon", mapCenter.getLongitudeE6());
        bundle.putInt("zoom", getZoomLevel());
        bundle.putBoolean("traffic", isTraffic());
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.e = i2;
        this.f = i3;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar = this.b;
        if (aVar == null || !aVar.a(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (this.b.b(motionEvent)) {
            return true;
        }
        return super.onTrackballEvent(motionEvent);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void preLoad() {
    }

    public void regMapViewListener(BMapManager bMapManager, MKMapViewListener mKMapViewListener) {
        if (bMapManager != null && bMapManager.a != null) {
            bMapManager.a.a(mKMapViewListener);
        }
    }

    public void setBuiltInZoomControls(boolean z) {
        if (z) {
            if (this.r || this.p.getParent() != null) {
                removeView(this.p);
            }
            addView(this.p);
            this.r = true;
            return;
        }
        removeView(this.p);
    }

    public void setDoubleClickZooming(boolean z) {
        this.b.a(z);
    }

    public void setDragMode(int i2) {
        this.b.b(i2);
    }

    public void setDrawOverlayWhenZooming(boolean z) {
        this.b.b(z);
    }

    public void setReticleDrawMode(a aVar) {
        throw new RuntimeException("this feature is not implemented!!");
    }

    public void setSatellite(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("act", PushConstants.PUSHSERVICE_INFO_SENDMESSAGE_BY_BROADCAST);
        bundle.putInt("opt", 10020803);
        bundle.putInt("on", z ? 1 : 0);
        Mj.sendBundle(bundle);
        this.k = z;
    }

    public void setStreetView(boolean z) {
        throw new RuntimeException("this feature is not implemented!!");
    }

    public void setTraffic(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("act", PushConstants.PUSHSERVICE_INFO_SENDMESSAGE_BY_BROADCAST);
        bundle.putInt("opt", 10020400);
        bundle.putInt("on", z ? 1 : 0);
        Mj.sendBundle(bundle);
        this.j = z;
    }
}
