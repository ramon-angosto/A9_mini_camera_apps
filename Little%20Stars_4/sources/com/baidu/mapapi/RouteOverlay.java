package com.baidu.mapapi;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;

public class RouteOverlay extends ItemizedOverlay<OverlayItem> {
    private ArrayList<b> a = null;
    private MapView b = null;
    private Context c = null;
    private DisplayMetrics d;
    private int e = 1;
    private HashMap<Integer, a> f;
    public MKRoute mRoute = null;

    class a {
        public GeoPoint a = new GeoPoint(0, 0);
        public ArrayList<Point> b = new ArrayList<>();

        public a() {
        }
    }

    private class b {
        public String a;
        public GeoPoint b;
        public int c;
        public int d;

        private b() {
        }
    }

    public RouteOverlay(Activity activity, MapView mapView) {
        super((Drawable) null);
        int i;
        this.c = activity;
        this.b = mapView;
        this.d = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(this.d);
        if (Mj.i <= 120) {
            i = 0;
        } else if (Mj.i <= 180) {
            this.e = 1;
            return;
        } else {
            i = 2;
        }
        this.e = i;
    }

    /* access modifiers changed from: package-private */
    public void a(int i, int i2, int i3, int i4) {
        this.f.clear();
    }

    public void animateTo() {
        if (size() > 0) {
            onTap(0);
        }
    }

    /* access modifiers changed from: protected */
    public OverlayItem createItem(int i) {
        Drawable drawable;
        char[] cArr = {'l', 'm', 'h'};
        String[] strArr = {"start", "end", "foot", "car", "bus"};
        b bVar = this.a.get(i);
        OverlayItem overlayItem = new OverlayItem(bVar.b, bVar.a, (String) null);
        StringBuilder sb = new StringBuilder(32);
        if (bVar.c == 0 || bVar.c == 1 || bVar.c == 4) {
            sb.append("icon_nav_");
            sb.append(strArr[bVar.c]);
            sb.append('_');
            sb.append(cArr[this.e]);
            sb.append(".png");
            drawable = n.a(this.c, sb.toString());
        } else {
            sb.append("icon_direction_");
            sb.append(cArr[this.e]);
            sb.append(".png");
            drawable = n.a(this.c, sb.toString(), (float) (bVar.d * 30));
        }
        overlayItem.setMarker((bVar.c == 0 || bVar.c == 1) ? boundCenterBottom(drawable) : boundCenter(drawable));
        return overlayItem;
    }

    public boolean draw(Canvas canvas, MapView mapView, boolean z, long j) {
        a aVar;
        Point point;
        int i;
        int i2;
        MapView mapView2 = mapView;
        Projection projection = mapView.getProjection();
        ((Activity) this.c).getWindowManager().getDefaultDisplay().getMetrics(this.d);
        int zoomLevel = mapView.getZoomLevel();
        MKRoute mKRoute = this.mRoute;
        if (mKRoute != null) {
            ArrayList<ArrayList<GeoPoint>> arrayPoints = mKRoute.getArrayPoints();
            ArrayList<ArrayList<GeoPoint>> arrayList = this.mRoute.a;
            if (arrayPoints != null && arrayPoints.size() > 0) {
                a aVar2 = this.f.get(Integer.valueOf(zoomLevel));
                if (aVar2 == null) {
                    aVar2 = new a();
                    int size = arrayPoints.size();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < size; i3++) {
                        n.a(arrayPoints.get(i3), arrayList.get(i3), zoomLevel, (ArrayList<GeoPoint>) arrayList2);
                        int size2 = arrayList2.size();
                        for (int i4 = 0; i4 < size2; i4++) {
                            Point point2 = new Point();
                            mapView2.a.a((GeoPoint) arrayList2.get(i4), point2);
                            aVar2.b.add(point2);
                        }
                    }
                    aVar2.a.setLatitudeE6(mapView.getMapCenter().getLatitudeE6());
                    aVar2.a.setLongitudeE6(mapView.getMapCenter().getLongitudeE6());
                    this.f.put(Integer.valueOf(zoomLevel), aVar2);
                }
                int size3 = aVar2.b.size();
                if (size3 > 1) {
                    Point point3 = new Point();
                    Point point4 = new Point();
                    Paint paint = new Paint();
                    paint.setAntiAlias(true);
                    paint.setStrokeWidth(6.0f);
                    paint.setColor(Color.rgb(58, 107, 189));
                    paint.setAlpha(192);
                    Point point5 = new Point();
                    Point point6 = new Point();
                    projection.toPixels(mapView.getMapCenter(), point5);
                    projection.toPixels(aVar2.a, point6);
                    int i5 = point5.y - point6.y;
                    int i6 = (point5.x - point6.x) - mapView2.b.c;
                    int i7 = i5 - mapView2.b.d;
                    boolean z2 = false;
                    point3.x = aVar2.b.get(0).x;
                    point3.y = aVar2.b.get(0).y;
                    if (this.b.b.e != 1.0d) {
                        double d2 = (double) (point3.x - this.b.b.f);
                        double d3 = this.b.b.e;
                        Double.isNaN(d2);
                        int i8 = (int) ((d2 * d3) + 0.5d);
                        double d4 = (double) (point3.y - this.b.b.g);
                        double d5 = this.b.b.e;
                        Double.isNaN(d4);
                        point3.x = this.b.b.f + i8;
                        point3.y = this.b.b.g + ((int) ((d4 * d5) + 0.5d));
                    }
                    point3.x -= i6;
                    point3.y -= i7;
                    int i9 = 1;
                    int i10 = 0;
                    while (i9 < size3) {
                        point4.x = aVar2.b.get(i9).x;
                        point4.y = aVar2.b.get(i9).y;
                        if (this.b.b.e != 1.0d) {
                            double d6 = (double) (point4.x - this.b.b.f);
                            point = point3;
                            double d7 = this.b.b.e;
                            Double.isNaN(d6);
                            int i11 = (int) ((d6 * d7) + 0.5d);
                            double d8 = (double) (point4.y - this.b.b.g);
                            aVar = aVar2;
                            double d9 = this.b.b.e;
                            Double.isNaN(d8);
                            point4.x = this.b.b.f + i11;
                            point4.y = this.b.b.g + ((int) ((d8 * d9) + 0.5d));
                        } else {
                            point = point3;
                            aVar = aVar2;
                        }
                        point4.x -= i6;
                        point4.y -= i7;
                        Point point7 = point;
                        if (n.a(point7, point4, this.d.widthPixels, this.d.heightPixels)) {
                            i2 = i9;
                            canvas.drawLine((float) point7.x, (float) point7.y, (float) point4.x, (float) point4.y, paint);
                            i = i10;
                            z2 = true;
                        } else {
                            i2 = i9;
                            if (z2) {
                                i = i10 + 1;
                                if (i > 50) {
                                    break;
                                }
                            } else {
                                i = i10;
                            }
                        }
                        point7.x = point4.x;
                        point7.y = point4.y;
                        if (i > 50) {
                            break;
                        }
                        i9 = i2 + 1;
                        point3 = point7;
                        i10 = i;
                        aVar2 = aVar;
                    }
                }
            }
        }
        if (zoomLevel >= 3) {
            return super.draw(canvas, mapView, z, j);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean onTap(int i) {
        OverlayItem item = getItem(i);
        this.b.getController().animateTo(item.mPoint);
        if (item.mTitle != null) {
            Toast.makeText(this.c, item.mTitle, 1).show();
        }
        super.onTap(i);
        return true;
    }

    public void setData(MKRoute mKRoute) {
        if (mKRoute != null) {
            this.mRoute = mKRoute;
            this.a = new ArrayList<>();
            int i = 3;
            if (this.mRoute.getRouteType() != 1) {
                i = this.mRoute.getRouteType() == 2 ? 2 : this.mRoute.getRouteType() == 3 ? 4 : 0;
            }
            GeoPoint start = this.mRoute.getStart();
            if (start != null) {
                b bVar = new b();
                bVar.b = start;
                bVar.c = 0;
                this.a.add(bVar);
            }
            int numSteps = mKRoute.getNumSteps();
            if (numSteps != 0) {
                if (this.a.size() > 0) {
                    this.a.get(0).a = mKRoute.getStep(0).getContent();
                }
                for (int i2 = 1; i2 < numSteps - 1; i2++) {
                    MKStep step = mKRoute.getStep(i2);
                    b bVar2 = new b();
                    bVar2.b = step.getPoint();
                    bVar2.a = step.getContent();
                    bVar2.c = i;
                    bVar2.d = step.a();
                    this.a.add(bVar2);
                }
            }
            GeoPoint end = this.mRoute.getEnd();
            if (end != null) {
                b bVar3 = new b();
                bVar3.b = end;
                bVar3.c = 1;
                this.a.add(bVar3);
            }
            this.f = new HashMap<>();
            super.populate();
        }
    }

    public int size() {
        ArrayList<b> arrayList = this.a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }
}
