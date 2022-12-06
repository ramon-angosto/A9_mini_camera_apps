package com.baidu.mapapi;

public class MKStep {
    private GeoPoint a;
    private String b;
    private int c;

    /* access modifiers changed from: package-private */
    public int a() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        this.c = i;
    }

    /* access modifiers changed from: package-private */
    public void a(GeoPoint geoPoint) {
        this.a = geoPoint;
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        this.b = str;
    }

    public String getContent() {
        return this.b;
    }

    public GeoPoint getPoint() {
        return this.a;
    }
}
