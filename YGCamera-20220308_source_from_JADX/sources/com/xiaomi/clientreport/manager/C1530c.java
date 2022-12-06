package com.xiaomi.clientreport.manager;

import com.xiaomi.clientreport.data.PerfClientReport;

/* renamed from: com.xiaomi.clientreport.manager.c */
class C1530c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PerfClientReport f1599a;

    /* renamed from: a */
    final /* synthetic */ C1528a f1600a;

    C1530c(C1528a aVar, PerfClientReport perfClientReport) {
        this.f1600a = aVar;
        this.f1599a = perfClientReport;
    }

    public void run() {
        this.f1600a.m2173b(this.f1599a);
    }
}
