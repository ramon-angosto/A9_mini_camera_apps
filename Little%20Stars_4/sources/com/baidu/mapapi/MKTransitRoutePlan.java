package com.baidu.mapapi;

import java.util.ArrayList;

public class MKTransitRoutePlan {
    private int a;
    private String b;
    private ArrayList<MKRoute> c;
    private ArrayList<MKLine> d;
    private GeoPoint e;
    private GeoPoint f;

    /* access modifiers changed from: package-private */
    public void a(int i) {
        this.a = i;
    }

    /* access modifiers changed from: package-private */
    public void a(GeoPoint geoPoint) {
        this.e = geoPoint;
    }

    /* access modifiers changed from: package-private */
    public void a(ArrayList<MKRoute> arrayList) {
        this.c = arrayList;
    }

    /* access modifiers changed from: package-private */
    public void b(GeoPoint geoPoint) {
        this.f = geoPoint;
    }

    public String getContent() {
        return this.b;
    }

    public int getDistance() {
        return this.a;
    }

    public GeoPoint getEnd() {
        return this.f;
    }

    public MKLine getLine(int i) {
        ArrayList<MKLine> arrayList = this.d;
        if (arrayList != null) {
            return arrayList.get(i);
        }
        return null;
    }

    public int getNumLines() {
        ArrayList<MKLine> arrayList = this.d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public int getNumRoute() {
        ArrayList<MKRoute> arrayList = this.c;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public MKRoute getRoute(int i) {
        ArrayList<MKRoute> arrayList = this.c;
        if (arrayList != null) {
            return arrayList.get(i);
        }
        return null;
    }

    public GeoPoint getStart() {
        return this.e;
    }

    public void setLine(ArrayList<MKLine> arrayList) {
        this.d = arrayList;
    }
}
