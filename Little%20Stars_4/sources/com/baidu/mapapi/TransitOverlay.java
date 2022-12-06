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

public class TransitOverlay extends ItemizedOverlay<OverlayItem> {
    private ArrayList<a> a = null;
    private MapView b = null;
    private Context c = null;
    private int d = 1;
    private DisplayMetrics e;
    public MKTransitRoutePlan mPlan = null;
    public boolean mUseToast = true;

    private class a {
        public String a;
        public GeoPoint b;
        public int c;

        private a() {
        }
    }

    public TransitOverlay(Activity activity, MapView mapView) {
        super((Drawable) null);
        int i;
        this.c = activity;
        this.b = mapView;
        this.e = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(this.e);
        if (this.e.widthPixels <= 320 && this.e.heightPixels <= 320) {
            i = 0;
        } else if (this.e.widthPixels > 480 || this.e.heightPixels > 480) {
            i = 2;
        } else {
            this.d = 1;
            return;
        }
        this.d = i;
    }

    public void animateTo() {
        if (size() > 0) {
            onTap(0);
        }
    }

    /* access modifiers changed from: protected */
    public OverlayItem createItem(int i) {
        char[] cArr = {'l', 'm', 'h'};
        String[] strArr = {"start", "end", "bus", "foot", "rail", "car"};
        a aVar = this.a.get(i);
        OverlayItem overlayItem = new OverlayItem(aVar.b, aVar.a, (String) null);
        if (aVar.c != 3) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("icon_nav_");
            sb.append(strArr[aVar.c]);
            sb.append('_');
            sb.append(cArr[this.d]);
            sb.append(".png");
            Drawable a2 = n.a(this.c, sb.toString());
            overlayItem.setMarker((aVar.c == 0 || aVar.c == 1) ? boundCenterBottom(a2) : boundCenter(a2));
        }
        return overlayItem;
    }

    public boolean draw(Canvas canvas, MapView mapView, boolean z, long j) {
        ArrayList arrayList;
        int i;
        ArrayList arrayList2;
        int i2;
        int i3;
        Projection projection = mapView.getProjection();
        ((Activity) this.c).getWindowManager().getDefaultDisplay().getMetrics(this.e);
        MKTransitRoutePlan mKTransitRoutePlan = this.mPlan;
        if (mKTransitRoutePlan != null) {
            int numLines = mKTransitRoutePlan.getNumLines();
            if (numLines + 1 == this.mPlan.getNumRoute() && numLines != 0) {
                Paint paint = new Paint();
                int i4 = 1;
                paint.setAntiAlias(true);
                paint.setStrokeWidth(6.0f);
                Point point = new Point();
                Point point2 = new Point();
                ArrayList arrayList3 = new ArrayList();
                int zoomLevel = mapView.getZoomLevel();
                int i5 = 0;
                int i6 = 0;
                while (true) {
                    if (i6 >= numLines) {
                        break;
                    }
                    MKRoute route = this.mPlan.getRoute(i6);
                    ArrayList<ArrayList<GeoPoint>> arrayPoints = route.getArrayPoints();
                    if (arrayPoints != null && arrayPoints.size() > 0 && (arrayList2 = arrayPoints.get(i5)) != null && arrayList2.size() > 0) {
                        n.a((ArrayList<GeoPoint>) arrayList2, route.a.get(i5), zoomLevel, (ArrayList<GeoPoint>) arrayList3);
                        int size = arrayList3.size();
                        if (size > i4) {
                            paint.setColor(Color.rgb(48, 162, 8));
                            paint.setAlpha(192);
                            projection.toPixels((GeoPoint) arrayList3.get(i5), point);
                            int i7 = 1;
                            while (i7 < size) {
                                projection.toPixels((GeoPoint) arrayList3.get(i7), point2);
                                if (n.a(point, point2, this.e.widthPixels, this.e.heightPixels)) {
                                    float f = (float) point.x;
                                    i2 = size;
                                    i3 = i6;
                                    canvas.drawLine(f, (float) point.y, (float) point2.x, (float) point2.y, paint);
                                } else {
                                    i2 = size;
                                    i3 = i6;
                                }
                                point.x = point2.x;
                                point.y = point2.y;
                                i7++;
                                i6 = i3;
                                size = i2;
                            }
                        }
                    }
                    int i8 = i6;
                    MKLine line = this.mPlan.getLine(i8);
                    ArrayList<GeoPoint> points = line.getPoints();
                    if (points != null && points.size() > 0) {
                        n.a(points, line.a, zoomLevel, (ArrayList<GeoPoint>) arrayList3);
                        int size2 = arrayList3.size();
                        if (size2 > 1) {
                            paint.setColor(Color.rgb(58, 107, 189));
                            paint.setAlpha(192);
                            projection.toPixels((GeoPoint) arrayList3.get(0), point);
                            int i9 = 1;
                            while (i9 < size2) {
                                projection.toPixels((GeoPoint) arrayList3.get(i9), point2);
                                if (n.a(point, point2, this.e.widthPixels, this.e.heightPixels)) {
                                    i = i9;
                                    canvas.drawLine((float) point.x, (float) point.y, (float) point2.x, (float) point2.y, paint);
                                } else {
                                    i = i9;
                                }
                                point.x = point2.x;
                                point.y = point2.y;
                                i9 = i + 1;
                            }
                        }
                    }
                    if (i8 == numLines - 1) {
                        MKRoute route2 = this.mPlan.getRoute(i8 + 1);
                        ArrayList<ArrayList<GeoPoint>> arrayPoints2 = route2.getArrayPoints();
                        if (arrayPoints2 != null && arrayPoints2.size() > 0 && (arrayList = arrayPoints2.get(0)) != null && arrayList.size() > 0) {
                            n.a((ArrayList<GeoPoint>) arrayList, route2.a.get(0), zoomLevel, (ArrayList<GeoPoint>) arrayList3);
                            int size3 = arrayList3.size();
                            if (size3 > 1) {
                                paint.setColor(Color.rgb(48, 162, 8));
                                paint.setAlpha(192);
                                projection.toPixels((GeoPoint) arrayList3.get(0), point);
                                for (int i10 = 1; i10 < size3; i10++) {
                                    projection.toPixels((GeoPoint) arrayList3.get(i10), point2);
                                    if (n.a(point, point2, this.e.widthPixels, this.e.heightPixels)) {
                                        canvas.drawLine((float) point.x, (float) point.y, (float) point2.x, (float) point2.y, paint);
                                    }
                                    point.x = point2.x;
                                    point.y = point2.y;
                                }
                            }
                        }
                    } else {
                        i4 = 1;
                        i6 = i8 + 1;
                        i5 = 0;
                    }
                }
            }
        }
        return super.draw(canvas, mapView, z, j);
    }

    /* access modifiers changed from: protected */
    public boolean onTap(int i) {
        OverlayItem item = getItem(i);
        this.b.getController().animateTo(item.mPoint);
        if (this.mUseToast && item.mTitle != null) {
            Toast.makeText(this.c, item.mTitle, 1).show();
        }
        super.onTap(i);
        return true;
    }

    public void setData(MKTransitRoutePlan mKTransitRoutePlan) {
        if (mKTransitRoutePlan != null) {
            this.a = new ArrayList<>();
            this.mPlan = mKTransitRoutePlan;
            int numLines = mKTransitRoutePlan.getNumLines();
            if (numLines + 1 == this.mPlan.getNumRoute() && numLines != 0) {
                GeoPoint start = mKTransitRoutePlan.getStart();
                int i = 0;
                if (start != null) {
                    a aVar = new a();
                    aVar.b = start;
                    aVar.c = 0;
                    this.a.add(aVar);
                }
                while (i < numLines) {
                    MKLine line = mKTransitRoutePlan.getLine(i);
                    a aVar2 = new a();
                    aVar2.b = line.getGetOnStop().pt;
                    aVar2.a = line.a();
                    if (line.getType() == 0) {
                        aVar2.c = 2;
                    } else {
                        aVar2.c = 4;
                    }
                    this.a.add(aVar2);
                    i++;
                    MKRoute route = this.mPlan.getRoute(i);
                    a aVar3 = new a();
                    aVar3.b = line.getGetOffStop().pt;
                    aVar3.a = route.a();
                    if (line.getType() == 0) {
                        aVar3.c = 2;
                    } else {
                        aVar3.c = 4;
                    }
                    this.a.add(aVar3);
                }
                GeoPoint end = mKTransitRoutePlan.getEnd();
                if (end != null) {
                    a aVar4 = new a();
                    aVar4.b = end;
                    aVar4.c = 1;
                    this.a.add(aVar4);
                }
                super.populate();
            }
        }
    }

    public int size() {
        ArrayList<a> arrayList = this.a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }
}
