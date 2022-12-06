package com.baidu.mapapi;

import java.util.ArrayList;

public class MKWalkingRouteResult {
    private MKPlanNode a;
    private MKPlanNode b;
    private ArrayList<MKRoutePlan> c;
    private MKRouteAddrResult d;

    /* access modifiers changed from: package-private */
    public void a(MKPlanNode mKPlanNode) {
        this.a = mKPlanNode;
    }

    /* access modifiers changed from: package-private */
    public void a(MKRouteAddrResult mKRouteAddrResult) {
        this.d = mKRouteAddrResult;
    }

    /* access modifiers changed from: package-private */
    public void a(ArrayList<MKRoutePlan> arrayList) {
        this.c = arrayList;
    }

    /* access modifiers changed from: package-private */
    public void b(MKPlanNode mKPlanNode) {
        this.b = mKPlanNode;
    }

    public MKRouteAddrResult getAddrResult() {
        return this.d;
    }

    public MKPlanNode getEnd() {
        return this.b;
    }

    public int getNumPlan() {
        ArrayList<MKRoutePlan> arrayList = this.c;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public MKRoutePlan getPlan(int i) {
        ArrayList<MKRoutePlan> arrayList = this.c;
        if (arrayList != null) {
            return arrayList.get(i);
        }
        return null;
    }

    public MKPlanNode getStart() {
        return this.a;
    }
}
