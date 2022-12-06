package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.EventClientReport;

/* renamed from: com.xiaomi.clientreport.manager.b */
class C1529b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ EventClientReport f1597a;

    /* renamed from: a */
    final /* synthetic */ C1528a f1598a;

    C1529b(C1528a aVar, EventClientReport eventClientReport) {
        this.f1598a = aVar;
        this.f1597a = eventClientReport;
    }

    public void run() {
        this.f1598a.m2172b(this.f1597a);
    }
}
