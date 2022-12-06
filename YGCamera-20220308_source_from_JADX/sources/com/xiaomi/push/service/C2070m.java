package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1868ho;
import com.xiaomi.push.C1882ib;
import com.xiaomi.push.C1891ik;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.C1905iy;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.xiaomi.push.service.m */
class C2070m extends XMPushService.C1956i {

    /* renamed from: a */
    final /* synthetic */ C2069l f3921a;

    /* renamed from: a */
    final /* synthetic */ String f3922a;

    /* renamed from: a */
    final /* synthetic */ List f3923a;

    /* renamed from: b */
    final /* synthetic */ String f3924b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2070m(C2069l lVar, int i, String str, List list, String str2) {
        super(i);
        this.f3921a = lVar;
        this.f3922a = str;
        this.f3923a = list;
        this.f3924b = str2;
    }

    /* renamed from: a */
    public String mo17683a() {
        return "Send tiny data.";
    }

    /* renamed from: a */
    public void m5295a() {
        String a = this.f3921a.m5292a(this.f3922a);
        ArrayList<C1894in> a2 = C2033bs.m5178a(this.f3923a, this.f3922a, a, 32768);
        if (a2 != null) {
            Iterator<C1894in> it = a2.iterator();
            while (it.hasNext()) {
                C1894in next = it.next();
                next.mo18083a("uploadWay", "longXMPushService");
                C1891ik a3 = C1970ab.m4880a(this.f3922a, a, next, C1868ho.Notification);
                if (!TextUtils.isEmpty(this.f3924b) && !TextUtils.equals(this.f3922a, this.f3924b)) {
                    if (a3.mo18043a() == null) {
                        C1882ib ibVar = new C1882ib();
                        ibVar.mo17879a("-1");
                        a3.mo18045a(ibVar);
                    }
                    a3.mo18043a().mo17886b("ext_traffic_source_pkg", this.f3924b);
                }
                this.f3921a.f3920a.mo18417a(this.f3922a, C1905iy.m4543a(a3), true);
            }
            return;
        }
        C1524b.m2160d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
    }
}
