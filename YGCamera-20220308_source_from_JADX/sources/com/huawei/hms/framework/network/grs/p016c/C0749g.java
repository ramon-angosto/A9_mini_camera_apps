package com.huawei.hms.framework.network.grs.p016c;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.network.grs.p016c.p018b.C0741a;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.c.g */
class C0749g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ long f547a;

    /* renamed from: b */
    final /* synthetic */ Context f548b;

    /* renamed from: c */
    final /* synthetic */ ArrayList f549c;

    /* renamed from: d */
    final /* synthetic */ JSONArray f550d;

    C0749g(long j, Context context, ArrayList arrayList, JSONArray jSONArray) {
        this.f547a = j;
        this.f548b = context;
        this.f549c = arrayList;
        this.f550d = jSONArray;
    }

    public void run() {
        boolean z;
        C0741a aVar = new C0741a();
        aVar.put("total_time", this.f547a);
        aVar.put("network_type", (long) NetworkUtil.getNetworkType(this.f548b));
        Iterator it = this.f549c.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            C0748f fVar = (C0748f) it.next();
            if (fVar.mo13877m()) {
                aVar.put(C0750h.m627b(fVar));
                it.remove();
                z = true;
                break;
            }
        }
        if (!z && this.f549c.size() > 0) {
            ArrayList arrayList = this.f549c;
            C0748f fVar2 = (C0748f) arrayList.get(arrayList.size() - 1);
            aVar.put(C0750h.m627b(fVar2));
            this.f549c.remove(fVar2);
        }
        if (this.f549c.size() > 0) {
            Iterator it2 = this.f549c.iterator();
            while (it2.hasNext()) {
                this.f550d.put(new JSONObject(C0750h.m627b((C0748f) it2.next())));
            }
        }
        if (this.f550d.length() > 0) {
            aVar.put("failed_info", this.f550d.toString());
        }
        Logger.m470d("HaReportHelper", "grssdk report data to aiops is: %s", new JSONObject(aVar.get()));
        HianalyticsHelper.getInstance().onEvent(aVar.get(), "networkkit_grs");
    }
}
