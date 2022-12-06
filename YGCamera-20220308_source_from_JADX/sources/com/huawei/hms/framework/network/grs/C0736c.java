package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.p014a.C0726a;
import com.huawei.hms.framework.network.grs.p014a.C0728c;
import com.huawei.hms.framework.network.grs.p015b.C0731b;
import com.huawei.hms.framework.network.grs.p016c.C0755m;
import com.huawei.hms.framework.network.grs.p016c.C0756n;
import com.huawei.hms.framework.network.grs.p016c.p018b.C0743c;
import java.util.concurrent.Callable;

/* renamed from: com.huawei.hms.framework.network.grs.c */
class C0736c implements Callable<Boolean> {

    /* renamed from: a */
    final /* synthetic */ Context f483a;

    /* renamed from: b */
    final /* synthetic */ GrsBaseInfo f484b;

    /* renamed from: c */
    final /* synthetic */ Context f485c;

    /* renamed from: d */
    final /* synthetic */ C0757d f486d;

    C0736c(C0757d dVar, Context context, GrsBaseInfo grsBaseInfo, Context context2) {
        this.f486d = dVar;
        this.f483a = context;
        this.f484b = grsBaseInfo;
        this.f485c = context2;
    }

    public Boolean call() {
        C0755m unused = this.f486d.f572g = new C0755m();
        C0728c unused2 = this.f486d.f574i = new C0728c(this.f483a, "share_pre_grs_conf_");
        C0728c unused3 = this.f486d.f575j = new C0728c(this.f483a, "share_pre_grs_services_");
        C0757d dVar = this.f486d;
        C0726a unused4 = dVar.f573h = new C0726a(dVar.f574i, this.f486d.f575j, this.f486d.f572g);
        C0757d dVar2 = this.f486d;
        C0723a unused5 = dVar2.f576k = new C0723a(dVar2.f568c, this.f486d.f573h, this.f486d.f572g, this.f486d.f575j);
        new C0731b(this.f483a, this.f484b, true).mo13829a(this.f484b);
        String c = new C0743c(this.f484b, this.f483a).mo13846c();
        String a = C0757d.f566a;
        Logger.m476v(a, "scan serviceSet is:" + c);
        String a2 = this.f486d.f575j.mo13805a("services", "");
        String a3 = C0756n.m636a(a2, c);
        if (!TextUtils.isEmpty(a3)) {
            this.f486d.f575j.mo13809b("services", a3);
            String a4 = C0757d.f566a;
            Logger.m476v(a4, "postList is:" + a3 + " currentServices:" + a2);
            if (!a3.equals(a2)) {
                this.f486d.f572g.mo13886a(this.f486d.f568c.getGrsParasKey(false, true, this.f483a));
                this.f486d.f572g.mo13885a(new C0743c(this.f484b, this.f485c), (C0729b) null, (String) null, this.f486d.f575j);
            }
        }
        C0757d dVar3 = this.f486d;
        dVar3.m646a(dVar3.f574i.mo13806a());
        this.f486d.f573h.mo13801b(this.f484b, this.f483a);
        return Boolean.valueOf(this.f486d.f569d = true);
    }
}
