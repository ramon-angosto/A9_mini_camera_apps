package com.xiaomi.push;

import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1747ed;
import com.xiaomi.push.service.C2003az;
import java.util.HashMap;

/* renamed from: com.xiaomi.push.fi */
class C1792fi {
    /* renamed from: a */
    public static void m3530a(C2003az.C2005b bVar, String str, C1809fu fuVar) {
        String str2;
        C1747ed.C1750c cVar = new C1747ed.C1750c();
        if (!TextUtils.isEmpty(bVar.f3744c)) {
            cVar.mo17451a(bVar.f3744c);
        }
        if (!TextUtils.isEmpty(bVar.f3746e)) {
            cVar.mo17455d(bVar.f3746e);
        }
        if (!TextUtils.isEmpty(bVar.f3747f)) {
            cVar.mo17457e(bVar.f3747f);
        }
        cVar.mo17452b(bVar.f3740a ? "1" : "0");
        if (!TextUtils.isEmpty(bVar.f3745d)) {
            cVar.mo17453c(bVar.f3745d);
        } else {
            cVar.mo17453c("XIAOMI-SASL");
        }
        C1793fj fjVar = new C1793fj();
        fjVar.mo17626c(bVar.f3742b);
        fjVar.mo17617a(Integer.parseInt(bVar.f3748g));
        fjVar.mo17624b(bVar.f3738a);
        fjVar.mo17620a("BIND", (String) null);
        fjVar.mo17619a(fjVar.mo17627e());
        C1524b.m2141a("[Slim]: bind id=" + fjVar.mo17627e());
        HashMap hashMap = new HashMap();
        hashMap.put("challenge", str);
        hashMap.put("token", bVar.f3744c);
        hashMap.put("chid", bVar.f3748g);
        hashMap.put(RemoteMessageConst.FROM, bVar.f3742b);
        hashMap.put("id", fjVar.mo17627e());
        hashMap.put(RemoteMessageConst.f875TO, "xiaomi.com");
        if (bVar.f3740a) {
            hashMap.put("kick", "1");
        } else {
            hashMap.put("kick", "0");
        }
        if (!TextUtils.isEmpty(bVar.f3746e)) {
            hashMap.put("client_attrs", bVar.f3746e);
        } else {
            hashMap.put("client_attrs", "");
        }
        if (!TextUtils.isEmpty(bVar.f3747f)) {
            hashMap.put("cloud_attrs", bVar.f3747f);
        } else {
            hashMap.put("cloud_attrs", "");
        }
        if (bVar.f3745d.equals("XIAOMI-PASS") || bVar.f3745d.equals("XMPUSH-PASS")) {
            str2 = C1661bm.m2722a(bVar.f3745d, (String) null, hashMap, bVar.f3749h);
        } else {
            bVar.f3745d.equals("XIAOMI-SASL");
            str2 = null;
        }
        cVar.mo17459f(str2);
        fjVar.mo17622a(cVar.mo17407a(), (String) null);
        fuVar.mo17647b(fjVar);
    }

    /* renamed from: a */
    public static void m3531a(String str, String str2, C1809fu fuVar) {
        C1793fj fjVar = new C1793fj();
        fjVar.mo17626c(str2);
        fjVar.mo17617a(Integer.parseInt(str));
        fjVar.mo17620a("UBND", (String) null);
        fuVar.mo17647b(fjVar);
    }
}
