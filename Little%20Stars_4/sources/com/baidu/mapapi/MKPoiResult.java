package com.baidu.mapapi;

import java.util.ArrayList;

public class MKPoiResult {
    private int a = 0;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private ArrayList<MKPoiResult> e;
    private ArrayList<MKPoiInfo> f;
    private ArrayList<MKCityListInfo> g;

    /* access modifiers changed from: package-private */
    public void a(int i) {
        this.b = i;
    }

    /* access modifiers changed from: package-private */
    public void a(ArrayList<MKPoiInfo> arrayList) {
        this.f = arrayList;
    }

    /* access modifiers changed from: package-private */
    public void b(int i) {
        this.a = i;
    }

    /* access modifiers changed from: package-private */
    public void b(ArrayList<MKPoiResult> arrayList) {
        this.e = arrayList;
    }

    /* access modifiers changed from: package-private */
    public void c(int i) {
        this.c = i;
    }

    /* access modifiers changed from: package-private */
    public void c(ArrayList<MKCityListInfo> arrayList) {
        this.g = arrayList;
    }

    /* access modifiers changed from: package-private */
    public void d(int i) {
        this.d = i;
    }

    public ArrayList<MKPoiInfo> getAllPoi() {
        return this.f;
    }

    public MKCityListInfo getCityListInfo(int i) {
        ArrayList<MKCityListInfo> arrayList = this.g;
        if (arrayList != null) {
            return arrayList.get(i);
        }
        return null;
    }

    public int getCityListNum() {
        ArrayList<MKCityListInfo> arrayList = this.g;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public int getCurrentNumPois() {
        return this.b;
    }

    public ArrayList<MKPoiResult> getMultiPoiResult() {
        return this.e;
    }

    public int getNumPages() {
        return this.c;
    }

    public int getNumPois() {
        return this.a;
    }

    public int getPageIndex() {
        return this.d;
    }

    public MKPoiInfo getPoi(int i) {
        ArrayList<MKPoiInfo> arrayList = this.f;
        if (arrayList != null) {
            return arrayList.get(i);
        }
        return null;
    }
}
