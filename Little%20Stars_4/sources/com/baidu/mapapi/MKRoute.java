package com.baidu.mapapi;

import java.util.ArrayList;

public class MKRoute {
    public static final int ROUTE_TYPE_BUS_LINE = 3;
    public static final int ROUTE_TYPE_DRIVING = 1;
    public static final int ROUTE_TYPE_UNKNOW = 0;
    public static final int ROUTE_TYPE_WALKING = 2;
    ArrayList<ArrayList<GeoPoint>> a;
    private int b;
    private int c;
    private int d;
    private GeoPoint e;
    private GeoPoint f;
    private ArrayList<ArrayList<GeoPoint>> g;
    private ArrayList<MKStep> h;
    private String i;

    /* access modifiers changed from: package-private */
    public String a() {
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        this.c = i2;
    }

    /* access modifiers changed from: package-private */
    public void a(GeoPoint geoPoint) {
        this.e = geoPoint;
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        this.i = str;
    }

    /* access modifiers changed from: package-private */
    public void a(ArrayList<MKStep> arrayList) {
        this.h = arrayList;
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        this.d = i2;
    }

    /* access modifiers changed from: package-private */
    public void b(GeoPoint geoPoint) {
        this.f = geoPoint;
    }

    /* access modifiers changed from: package-private */
    public void b(ArrayList<ArrayList<GeoPoint>> arrayList) {
        this.g = arrayList;
    }

    public ArrayList<ArrayList<GeoPoint>> getArrayPoints() {
        return this.g;
    }

    public int getDistance() {
        return this.c;
    }

    public GeoPoint getEnd() {
        return this.f;
    }

    public int getIndex() {
        return this.b;
    }

    public int getNumSteps() {
        ArrayList<MKStep> arrayList = this.h;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public int getRouteType() {
        return this.d;
    }

    public GeoPoint getStart() {
        return this.e;
    }

    public MKStep getStep(int i2) {
        ArrayList<MKStep> arrayList = this.h;
        if (arrayList != null) {
            return arrayList.get(i2);
        }
        return null;
    }
}
