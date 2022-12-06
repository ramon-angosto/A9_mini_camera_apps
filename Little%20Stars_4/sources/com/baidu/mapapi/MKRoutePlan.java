package com.baidu.mapapi;

import java.util.ArrayList;

public class MKRoutePlan {
    private int a;
    private ArrayList<MKRoute> b;

    /* access modifiers changed from: package-private */
    public void a(int i) {
        this.a = i;
    }

    /* access modifiers changed from: package-private */
    public void a(ArrayList<MKRoute> arrayList) {
        this.b = arrayList;
    }

    public int getDistance() {
        return this.a;
    }

    public int getNumRoutes() {
        ArrayList<MKRoute> arrayList = this.b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public MKRoute getRoute(int i) {
        ArrayList<MKRoute> arrayList = this.b;
        if (arrayList != null) {
            return arrayList.get(i);
        }
        return null;
    }
}
