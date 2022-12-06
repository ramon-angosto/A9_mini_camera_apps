package com.xiaomi.push.service.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.misc.i;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.push.service.v;
import dalvik.system.DexClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class c {
    private static c a;
    private Map<String, b> b = new HashMap();
    private List<b> c = new ArrayList();
    private Context d;
    private SharedPreferences e;
    private boolean f;

    private static class a implements Runnable {
        private String a = null;
        private String b = null;
        private String c;
        private boolean d;
        private Context e;
        /* access modifiers changed from: private */
        public boolean f = false;

        public a(Context context, String str, String str2, String str3, boolean z) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = z;
            this.e = context.getApplicationContext();
        }

        /* JADX WARNING: Unknown top exception splitter block from list: {B:26:0x00b7=Splitter:B:26:0x00b7, B:36:0x00c8=Splitter:B:36:0x00c8} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
                android.content.Context r0 = r5.e
                boolean r0 = com.xiaomi.channel.commonutils.network.d.f(r0)
                if (r0 != 0) goto L_0x0009
                return
            L_0x0009:
                java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x00cc }
                java.lang.String r1 = r5.a     // Catch:{ Exception -> 0x00cc }
                r0.<init>(r1)     // Catch:{ Exception -> 0x00cc }
                java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x00cc }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x00cc }
                java.lang.String r1 = "GET"
                r0.setRequestMethod(r1)     // Catch:{ Exception -> 0x00cc }
                r1 = 5000(0x1388, float:7.006E-42)
                r0.setConnectTimeout(r1)     // Catch:{ Exception -> 0x00cc }
                r0.connect()     // Catch:{ Exception -> 0x00cc }
                int r1 = r0.getResponseCode()     // Catch:{ Exception -> 0x00cc }
                r2 = 200(0xc8, float:2.8E-43)
                if (r1 != r2) goto L_0x00d0
                java.io.InputStream r0 = r0.getInputStream()     // Catch:{ Exception -> 0x00cc }
                byte[] r0 = com.xiaomi.channel.commonutils.file.a.b(r0)     // Catch:{ Exception -> 0x00cc }
                java.lang.String r1 = r5.b     // Catch:{ Exception -> 0x00cc }
                boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00cc }
                r2 = 0
                if (r1 != 0) goto L_0x0049
                java.lang.String r1 = com.xiaomi.channel.commonutils.string.d.a((byte[]) r0)     // Catch:{ Exception -> 0x00cc }
                java.lang.String r3 = r5.b     // Catch:{ Exception -> 0x00cc }
                boolean r1 = r3.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x00cc }
                if (r1 != 0) goto L_0x0049
                r0 = r2
            L_0x0049:
                if (r0 == 0) goto L_0x00d0
                java.lang.String r1 = "download apk success."
                com.xiaomi.channel.commonutils.logger.b.b(r1)     // Catch:{ Exception -> 0x00cc }
                java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x00c3 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c3 }
                r3.<init>()     // Catch:{ Exception -> 0x00c3 }
                java.lang.String r4 = r5.c     // Catch:{ Exception -> 0x00c3 }
                r3.append(r4)     // Catch:{ Exception -> 0x00c3 }
                java.lang.String r4 = ".tmp"
                r3.append(r4)     // Catch:{ Exception -> 0x00c3 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00c3 }
                r1.<init>(r3)     // Catch:{ Exception -> 0x00c3 }
                r1.delete()     // Catch:{ Exception -> 0x00c3 }
                java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00c3 }
                r3.<init>(r1)     // Catch:{ Exception -> 0x00c3 }
                r3.write(r0)     // Catch:{ Exception -> 0x00be, all -> 0x00bb }
                r3.flush()     // Catch:{ Exception -> 0x00be, all -> 0x00bb }
                r3.close()     // Catch:{ Exception -> 0x00be, all -> 0x00bb }
                android.content.Context r0 = r5.e     // Catch:{ Exception -> 0x00c3 }
                java.lang.String r3 = r1.getPath()     // Catch:{ Exception -> 0x00c3 }
                android.content.pm.Signature[] r0 = com.xiaomi.channel.commonutils.android.b.e(r0, r3)     // Catch:{ Exception -> 0x00c3 }
                boolean r0 = com.xiaomi.channel.commonutils.android.d.a(r0)     // Catch:{ Exception -> 0x00c3 }
                if (r0 == 0) goto L_0x00af
                java.lang.String r0 = "verify signature success"
                com.xiaomi.channel.commonutils.logger.b.b(r0)     // Catch:{ Exception -> 0x00c3 }
                java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x00c3 }
                java.lang.String r3 = r5.c     // Catch:{ Exception -> 0x00c3 }
                r0.<init>(r3)     // Catch:{ Exception -> 0x00c3 }
                r1.renameTo(r0)     // Catch:{ Exception -> 0x00c3 }
                r0 = 1
                r5.f = r0     // Catch:{ Exception -> 0x00c3 }
                boolean r0 = r5.d     // Catch:{ Exception -> 0x00c3 }
                if (r0 == 0) goto L_0x00b7
                android.content.Context r0 = r5.e     // Catch:{ Exception -> 0x00c3 }
                boolean r0 = com.xiaomi.channel.commonutils.android.b.b(r0)     // Catch:{ Exception -> 0x00c3 }
                if (r0 != 0) goto L_0x00b7
                int r0 = android.os.Process.myPid()     // Catch:{ Exception -> 0x00c3 }
                android.os.Process.killProcess(r0)     // Catch:{ Exception -> 0x00c3 }
                goto L_0x00b7
            L_0x00af:
                java.lang.String r0 = "verify signature failed"
                com.xiaomi.channel.commonutils.logger.b.d(r0)     // Catch:{ Exception -> 0x00c3 }
                r1.delete()     // Catch:{ Exception -> 0x00c3 }
            L_0x00b7:
                com.xiaomi.channel.commonutils.file.a.a((java.io.OutputStream) r2)     // Catch:{ Exception -> 0x00cc }
                goto L_0x00d0
            L_0x00bb:
                r0 = move-exception
                r2 = r3
                goto L_0x00c8
            L_0x00be:
                r0 = move-exception
                r2 = r3
                goto L_0x00c4
            L_0x00c1:
                r0 = move-exception
                goto L_0x00c8
            L_0x00c3:
                r0 = move-exception
            L_0x00c4:
                r0.printStackTrace()     // Catch:{ all -> 0x00c1 }
                goto L_0x00b7
            L_0x00c8:
                com.xiaomi.channel.commonutils.file.a.a((java.io.OutputStream) r2)     // Catch:{ Exception -> 0x00cc }
                throw r0     // Catch:{ Exception -> 0x00cc }
            L_0x00cc:
                r0 = move-exception
                r0.printStackTrace()
            L_0x00d0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.module.c.a.run():void");
        }
    }

    public interface b {
        void a(e eVar);
    }

    private c(Context context) {
        this.d = context.getApplicationContext();
        this.e = this.d.getSharedPreferences(MiPushClient.PREF_EXTRA, 0);
    }

    private b a(a aVar, DexClassLoader dexClassLoader) {
        if (dexClassLoader == null) {
            return null;
        }
        return new b(aVar.e(), aVar.f(), dexClassLoader, aVar.b(), aVar.a());
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (c.class) {
            if (a == null) {
                a = new c(context);
            }
            cVar = a;
        }
        return cVar;
    }

    private void a(d dVar, int i) {
        SharedPreferences.Editor edit = this.e.edit();
        edit.putInt("plugin_version_" + dVar.b, i).commit();
    }

    private synchronized void a(e eVar) {
        for (b a2 : this.c) {
            a2.a(eVar);
        }
    }

    private int b(d dVar) {
        SharedPreferences sharedPreferences = this.e;
        return sharedPreferences.getInt("plugin_version_" + dVar.b, 0);
    }

    private List<e> b() {
        ArrayList arrayList = new ArrayList();
        v a2 = v.a(this.d);
        e eVar = new e();
        eVar.a = d.MODULE_CDATA;
        eVar.b = a2.a(com.xiaomi.xmpush.thrift.b.CollectionDataPluginVersion.a(), 0);
        eVar.c = a2.a(com.xiaomi.xmpush.thrift.b.CollectionPluginDownloadUrl.a(), "");
        eVar.d = a2.a(com.xiaomi.xmpush.thrift.b.CollectionPluginMd5.a(), "");
        eVar.e = a2.a(com.xiaomi.xmpush.thrift.b.CollectionPluginForceStop.a(), false);
        arrayList.add(eVar);
        return arrayList;
    }

    public b a(d dVar) {
        i.a();
        if (dVar == null) {
            return null;
        }
        a();
        com.xiaomi.channel.commonutils.logger.b.b("loadModule " + dVar.b);
        String str = dVar.b;
        if (this.b.containsKey(str)) {
            return this.b.get(str);
        }
        a aVar = new a(this.d, str);
        DexClassLoader c2 = aVar.c();
        if (c2 == null) {
            return null;
        }
        b a2 = a(aVar, c2);
        a2.a(this.d);
        this.b.put(str, a2);
        com.xiaomi.channel.commonutils.logger.b.b("module load success.");
        return a2;
    }

    public synchronized void a() {
        if (!this.f) {
            this.f = true;
            for (e next : b()) {
                if (b(next.a) < next.b && !TextUtils.isEmpty(next.c)) {
                    a aVar = new a(this.d, next.c, next.d, a.a(this.d, next.a.b), next.e);
                    aVar.run();
                    if (aVar.f) {
                        a(next.a, next.b);
                        a(next);
                    }
                }
            }
            this.f = false;
        }
    }
}
