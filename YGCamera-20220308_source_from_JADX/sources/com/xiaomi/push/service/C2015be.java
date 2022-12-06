package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C1653bi;
import com.xiaomi.push.C1698cq;
import com.xiaomi.push.C1701ct;
import com.xiaomi.push.C1702cu;
import com.xiaomi.push.C1745ec;
import com.xiaomi.push.C1747ed;
import com.xiaomi.push.C1789ff;
import com.xiaomi.push.C1809fu;
import com.xiaomi.push.C1844gw;
import com.xiaomi.push.C1857hg;
import com.xiaomi.push.C1860hi;
import com.xiaomi.push.C2087u;
import com.xiaomi.push.service.C2027bo;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.xiaomi.push.service.be */
public class C2015be extends C2027bo.C2028a implements C1702cu.C1703a {

    /* renamed from: a */
    private long f3808a;

    /* renamed from: a */
    private XMPushService f3809a;

    /* renamed from: com.xiaomi.push.service.be$a */
    static class C2016a implements C1702cu.C1704b {
        C2016a() {
        }

        /* renamed from: a */
        public String mo17371a(String str) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("sdkver", String.valueOf(46));
            buildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            buildUpon.appendQueryParameter("os", C1844gw.m3801a(Build.MODEL + Constants.COLON_SEPARATOR + Build.VERSION.INCREMENTAL));
            buildUpon.appendQueryParameter("mi", String.valueOf(C2087u.m5371a()));
            String builder = buildUpon.toString();
            C1524b.m2159c("fetch bucket from : " + builder);
            URL url = new URL(builder);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String a = C1653bi.m2676a(C2087u.m5371a(), url);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                C1860hi.m3866a(url.getHost() + Constants.COLON_SEPARATOR + port, (int) currentTimeMillis2, (Exception) null);
                return a;
            } catch (IOException e) {
                C1860hi.m3866a(url.getHost() + Constants.COLON_SEPARATOR + port, -1, e);
                throw e;
            }
        }
    }

    /* renamed from: com.xiaomi.push.service.be$b */
    static class C2017b extends C1702cu {
        protected C2017b(Context context, C1701ct ctVar, C1702cu.C1704b bVar, String str) {
            super(context, ctVar, bVar, str);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String mo17359a(ArrayList<String> arrayList, String str, String str2, boolean z) {
            try {
                if (C1857hg.mo17753a().mo17753a()) {
                    str2 = C2027bo.mo18506a();
                }
                return super.mo17359a(arrayList, str, str2, z);
            } catch (IOException e) {
                C1860hi.m3863a(0, C1789ff.GSLB_ERR.mo17573a(), 1, (String) null, C1653bi.m2686c(f1972a) ? 1 : 0);
                throw e;
            }
        }
    }

    C2015be(XMPushService xMPushService) {
        this.f3809a = xMPushService;
    }

    /* renamed from: a */
    public static void m5115a(XMPushService xMPushService) {
        C2015be beVar = new C2015be(xMPushService);
        C2027bo.mo18506a().mo18508a((C2027bo.C2028a) beVar);
        synchronized (C1702cu.class) {
            C1702cu.m2914a((C1702cu.C1703a) beVar);
            C1702cu.m2913a(xMPushService, (C1701ct) null, new C2016a(), "0", "push", "2.2");
        }
    }

    /* renamed from: a */
    public C1702cu mo17370a(Context context, C1701ct ctVar, C1702cu.C1704b bVar, String str) {
        return new C2017b(context, ctVar, bVar, str);
    }

    /* renamed from: a */
    public void mo18499a(C1745ec.C1746a aVar) {
    }

    /* renamed from: a */
    public void mo17758a(C1747ed.C1749b bVar) {
        C1698cq b;
        if (bVar.mo17413b() && bVar.mo17407a() && System.currentTimeMillis() - this.f3808a > 3600000) {
            C1524b.m2141a("fetch bucket :" + bVar.mo17407a());
            this.f3808a = System.currentTimeMillis();
            C1702cu a = C1702cu.mo17360a();
            a.mo17360a();
            a.mo17363b();
            C1809fu a2 = this.f3809a.mo18408a();
            if (a2 != null && (b = a.mo17362b(a2.mo17639a().mo17674c())) != null) {
                ArrayList a3 = b.mo17331a();
                boolean z = true;
                Iterator it = a3.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((String) it.next()).equals(a2.mo17639a())) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z && !a3.isEmpty()) {
                    C1524b.m2141a("bucket changed, force reconnect");
                    this.f3809a.mo18410a(0, (Exception) null);
                    this.f3809a.mo18418a(false);
                }
            }
        }
    }
}
