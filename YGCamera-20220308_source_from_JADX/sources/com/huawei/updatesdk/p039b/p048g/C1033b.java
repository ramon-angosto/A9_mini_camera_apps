package com.huawei.updatesdk.p039b.p048g;

import android.os.AsyncTask;
import com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a;
import com.huawei.updatesdk.p025a.p034b.p037c.C0989b;
import com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0990a;
import com.huawei.updatesdk.p039b.p043b.C1005c;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* renamed from: com.huawei.updatesdk.b.g.b */
public class C1033b {

    /* renamed from: a */
    private static List<AsyncTask> f1393a = new CopyOnWriteArrayList();

    /* renamed from: a */
    public static C0989b m1945a(C1005c cVar, C0990a aVar) {
        C0989b bVar = new C0989b(cVar, aVar);
        m1948a(bVar, cVar);
        return bVar;
    }

    /* renamed from: a */
    public static List<AsyncTask> m1946a() {
        return f1393a;
    }

    /* renamed from: a */
    public static void m1947a(AsyncTask asyncTask) {
        if (asyncTask != null) {
            for (AsyncTask next : f1393a) {
                if (next != null && (next.getStatus() == AsyncTask.Status.FINISHED || next.isCancelled())) {
                    f1393a.remove(asyncTask);
                }
            }
            f1393a.add(asyncTask);
        }
    }

    /* renamed from: a */
    private static void m1948a(C0989b bVar, C1005c cVar) {
        C0968a.m1680a("StoreAgent", "executeTask, ActiveCount:" + C1034c.f1394a.getActiveCount() + ", TaskCount:" + C1034c.f1394a.getTaskCount());
        bVar.mo14907a((Executor) C1034c.f1394a);
    }
}
