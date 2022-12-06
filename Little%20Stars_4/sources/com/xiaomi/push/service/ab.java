package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.channel.commonutils.android.i;
import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.HostFilter;
import com.xiaomi.network.HostManager;
import com.xiaomi.network.HostManagerV2;
import com.xiaomi.push.protobuf.a;
import com.xiaomi.push.protobuf.b;
import com.xiaomi.push.service.ah;
import com.xiaomi.smack.util.g;
import com.xiaomi.stats.f;
import com.xiaomi.stats.h;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class ab extends ah.a implements HostManager.HostManagerFactory {
    private XMPushService a;
    private long b;

    static class a implements HostManager.HttpGet {
        a() {
        }

        public String a(String str) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("sdkver", String.valueOf(21));
            buildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            buildUpon.appendQueryParameter("os", g.a(Build.MODEL + ":" + Build.VERSION.INCREMENTAL));
            buildUpon.appendQueryParameter("mi", String.valueOf(i.c()));
            String builder = buildUpon.toString();
            com.xiaomi.channel.commonutils.logger.b.c("fetch bucket from : " + builder);
            URL url = new URL(builder);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String a = d.a(i.a(), url);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                h.a(url.getHost() + ":" + port, (int) currentTimeMillis2, (Exception) null);
                return a;
            } catch (IOException e) {
                h.a(url.getHost() + ":" + port, -1, e);
                throw e;
            }
        }
    }

    static class b extends HostManagerV2 {
        protected b(Context context, HostFilter hostFilter, HostManager.HttpGet httpGet, String str) {
            super(context, hostFilter, httpGet, str);
        }

        /* access modifiers changed from: protected */
        public String getRemoteFallbackJSON(ArrayList<String> arrayList, String str, String str2) {
            try {
                if (f.a().c()) {
                    str2 = ah.e();
                }
                return super.getRemoteFallbackJSON(arrayList, str, str2);
            } catch (IOException e) {
                h.a(0, com.xiaomi.push.thrift.a.GSLB_ERR.a(), 1, (String) null, d.d(this.sAppContext) ? 1 : 0);
                throw e;
            }
        }
    }

    ab(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    public static void a(XMPushService xMPushService) {
        ab abVar = new ab(xMPushService);
        ah.a().a((ah.a) abVar);
        HostManager.setHostManagerFactory(abVar);
        HostManager.init(xMPushService, (HostFilter) null, new a(), PushConstants.PUSH_TYPE_NOTIFY, "push", "2.2");
    }

    public HostManager a(Context context, HostFilter hostFilter, HostManager.HttpGet httpGet, String str) {
        return new b(context, hostFilter, httpGet, str);
    }

    public void a(a.C0052a aVar) {
    }

    public void a(b.a aVar) {
        Fallback fallbacksByHost;
        if (aVar.d() && aVar.c() && System.currentTimeMillis() - this.b > 3600000) {
            com.xiaomi.channel.commonutils.logger.b.a("fetch bucket :" + aVar.c());
            this.b = System.currentTimeMillis();
            HostManager instance = HostManager.getInstance();
            instance.clear();
            instance.refreshFallbacks();
            com.xiaomi.smack.a g = this.a.g();
            if (g != null && (fallbacksByHost = instance.getFallbacksByHost(g.a().f())) != null) {
                ArrayList<String> d = fallbacksByHost.d();
                boolean z = true;
                Iterator<String> it = d.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().equals(g.c())) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z && !d.isEmpty()) {
                    com.xiaomi.channel.commonutils.logger.b.a("bucket changed, force reconnect");
                    this.a.a(0, (Exception) null);
                    this.a.a(false);
                }
            }
        }
    }
}
