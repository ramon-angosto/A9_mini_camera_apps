package com.baidu.mapapi;

import java.util.ArrayList;

public class MKLine {
    public static final int LINE_TYPE_BUS = 0;
    public static final int LINE_TYPE_SUBWAY = 1;
    ArrayList<GeoPoint> a;
    private int b;
    private int c;
    private int d;
    private String e;
    private String f;
    private String g;
    private MKPoiInfo h;
    private MKPoiInfo i;
    private ArrayList<GeoPoint> j;

    /* access modifiers changed from: package-private */
    public String a() {
        return this.g;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        this.b = i2;
    }

    /* access modifiers changed from: package-private */
    public void a(MKPoiInfo mKPoiInfo) {
        this.h = mKPoiInfo;
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        this.g = str;
    }

    /* access modifiers changed from: package-private */
    public void a(ArrayList<GeoPoint> arrayList) {
        this.j = arrayList;
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        this.c = i2;
    }

    /* access modifiers changed from: package-private */
    public void b(MKPoiInfo mKPoiInfo) {
        this.i = mKPoiInfo;
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        this.e = str;
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        this.d = i2;
    }

    /* access modifiers changed from: package-private */
    public void c(String str) {
        this.f = str;
    }

    public int getDistance() {
        return this.c;
    }

    public MKPoiInfo getGetOffStop() {
        return this.i;
    }

    public MKPoiInfo getGetOnStop() {
        return this.h;
    }

    public int getNumViaStops() {
        return this.b;
    }

    public ArrayList<GeoPoint> getPoints() {
        return this.j;
    }

    public String getTitle() {
        return this.e;
    }

    public int getType() {
        return this.d;
    }

    public String getUid() {
        return this.f;
    }
}
