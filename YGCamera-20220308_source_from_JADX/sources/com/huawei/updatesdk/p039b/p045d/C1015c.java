package com.huawei.updatesdk.p039b.p045d;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a;
import com.huawei.updatesdk.p025a.p026a.p031d.C0972d;
import com.huawei.updatesdk.p025a.p034b.p035a.C0985a;
import com.huawei.updatesdk.p025a.p034b.p036b.C0987b;
import com.huawei.updatesdk.p039b.p047f.C1030c;
import com.huawei.updatesdk.p039b.p048g.C1033b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/* renamed from: com.huawei.updatesdk.b.d.c */
public class C1015c extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    private String f1377a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public HttpURLConnection f1378b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f1379c = false;

    /* renamed from: d */
    private C1014b f1380d;

    /* renamed from: e */
    private Handler f1381e = new C1017b((C1016a) null);

    /* renamed from: com.huawei.updatesdk.b.d.c$a */
    class C1016a implements Runnable {
        C1016a() {
        }

        public void run() {
            if (C1015c.this.f1378b != null) {
                boolean unused = C1015c.this.f1379c = true;
                C1015c.this.f1378b.disconnect();
            }
            C0972d.m1693a(new File(C1015c.m1897e()));
        }
    }

    /* renamed from: com.huawei.updatesdk.b.d.c$b */
    private static class C1017b extends Handler {
        private C1017b() {
        }

        /* synthetic */ C1017b(C1016a aVar) {
            this();
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            Object obj = message.obj;
            if (obj instanceof C1014b) {
                C1014b bVar = (C1014b) obj;
                Intent intent = new Intent();
                C0987b a = C0987b.m1761a(intent);
                int i = message.what;
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            Context a2 = C0985a.m1757c().mo14892a();
                            C1019e.m1905a(a2, C1015c.m1897e() + "/appmarket.apk", bVar.mo14984c());
                        } else if (i != 5) {
                            return;
                        }
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("download_status_param", message.what);
                    intent.putExtras(bundle);
                    C1030c.m1937b().mo15008b(a);
                    return;
                }
                intent.putExtra("download_apk_size", bVar.mo14986e());
                intent.putExtra("download_apk_already", bVar.mo14979a());
                C1030c.m1937b().mo15007a(a);
            }
        }
    }

    public C1015c(C1014b bVar) {
        this.f1380d = bVar;
        if (!TextUtils.isEmpty(bVar.mo14984c())) {
            this.f1377a = bVar.mo14984c();
        }
    }

    /* renamed from: a */
    private void m1890a(int i, long j, String str, int i2) {
        C1014b bVar = new C1014b();
        bVar.mo14980a(i);
        bVar.mo14981a(j);
        bVar.mo14982a(str);
        Handler handler = this.f1381e;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(i2, bVar));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0090 A[SYNTHETIC, Splitter:B:33:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:11:0x0040=Splitter:B:11:0x0040, B:24:0x006a=Splitter:B:24:0x006a} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:21:0x0050=Splitter:B:21:0x0050, B:27:0x006f=Splitter:B:27:0x006f} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1891a(com.huawei.updatesdk.p039b.p045d.C1014b r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "Close FileOutputStream failed!"
            java.lang.String r1 = "DownloadMarketTask"
            if (r6 == 0) goto L_0x0098
            java.lang.String r2 = r6.mo14983b()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0012
            goto L_0x0098
        L_0x0012:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            java.lang.String r7 = "/appmarket.apk"
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r7)
            r3 = 0
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x006e, Exception -> 0x004f }
            r4.<init>(r2)     // Catch:{ FileNotFoundException -> 0x006e, Exception -> 0x004f }
            boolean r6 = r5.m1893a(r6, r4, r7)     // Catch:{ FileNotFoundException -> 0x004a, Exception -> 0x0047, all -> 0x0044 }
            if (r6 != 0) goto L_0x0040
            java.io.File r6 = new java.io.File     // Catch:{ FileNotFoundException -> 0x004a, Exception -> 0x0047, all -> 0x0044 }
            java.lang.String r7 = m1897e()     // Catch:{ FileNotFoundException -> 0x004a, Exception -> 0x0047, all -> 0x0044 }
            r6.<init>(r7)     // Catch:{ FileNotFoundException -> 0x004a, Exception -> 0x0047, all -> 0x0044 }
            com.huawei.updatesdk.p025a.p026a.p031d.C0972d.m1693a((java.io.File) r6)     // Catch:{ FileNotFoundException -> 0x004a, Exception -> 0x0047, all -> 0x0044 }
        L_0x0040:
            r4.close()     // Catch:{ IOException -> 0x008a }
            goto L_0x008d
        L_0x0044:
            r6 = move-exception
            r3 = r4
            goto L_0x008e
        L_0x0047:
            r6 = move-exception
            r3 = r4
            goto L_0x0050
        L_0x004a:
            r6 = move-exception
            r3 = r4
            goto L_0x006f
        L_0x004d:
            r6 = move-exception
            goto L_0x008e
        L_0x004f:
            r6 = move-exception
        L_0x0050:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x004d }
            r7.<init>()     // Catch:{ all -> 0x004d }
            java.lang.String r2 = "DOWNLOAD market package Exception error:"
            r7.append(r2)     // Catch:{ all -> 0x004d }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x004d }
            r7.append(r6)     // Catch:{ all -> 0x004d }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x004d }
            com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a.m1682b(r1, r6)     // Catch:{ all -> 0x004d }
            if (r3 == 0) goto L_0x008d
        L_0x006a:
            r3.close()     // Catch:{ IOException -> 0x008a }
            goto L_0x008d
        L_0x006e:
            r6 = move-exception
        L_0x006f:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x004d }
            r7.<init>()     // Catch:{ all -> 0x004d }
            java.lang.String r2 = "DOWNLOAD market package FileNotFoundException error:"
            r7.append(r2)     // Catch:{ all -> 0x004d }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x004d }
            r7.append(r6)     // Catch:{ all -> 0x004d }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x004d }
            com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a.m1682b(r1, r6)     // Catch:{ all -> 0x004d }
            if (r3 == 0) goto L_0x008d
            goto L_0x006a
        L_0x008a:
            com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a.m1682b(r1, r0)
        L_0x008d:
            return
        L_0x008e:
            if (r3 == 0) goto L_0x0097
            r3.close()     // Catch:{ IOException -> 0x0094 }
            goto L_0x0097
        L_0x0094:
            com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a.m1682b(r1, r0)
        L_0x0097:
            throw r6
        L_0x0098:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.updatesdk.p039b.p045d.C1015c.m1891a(com.huawei.updatesdk.b.d.b, java.lang.String):void");
    }

    /* renamed from: a */
    private void m1892a(InputStream inputStream, OutputStream outputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                C0968a.m1682b("DownloadMarketTask", "downloadUrlToStream(String urlString,OutputStream outputStream) " + e.toString());
            }
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e2) {
                C0968a.m1682b("DownloadMarketTask", "downloadUrlToStream(String urlString,OutputStream outputStream) " + e2.toString());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:131:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00f4 A[SYNTHETIC, Splitter:B:71:0x00f4] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x011b  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m1893a(com.huawei.updatesdk.p039b.p045d.C1014b r21, java.io.OutputStream r22, java.lang.String r23) {
        /*
            r20 = this;
            r7 = r20
            r8 = 0
            r9 = 0
            r3 = -1
            r2 = 0
            com.huawei.updatesdk.b.d.d r0 = com.huawei.updatesdk.p039b.p045d.C1018d.m1901a()     // Catch:{ Exception -> 0x016a, all -> 0x0167 }
            java.lang.String r1 = r21.mo14983b()     // Catch:{ Exception -> 0x016a, all -> 0x0167 }
            java.net.HttpURLConnection r0 = r0.mo14994a(r1)     // Catch:{ Exception -> 0x016a, all -> 0x0167 }
            r7.f1378b = r0     // Catch:{ Exception -> 0x016a, all -> 0x0167 }
            java.net.HttpURLConnection r0 = r7.f1378b     // Catch:{ Exception -> 0x016a, all -> 0x0167 }
            if (r0 != 0) goto L_0x0038
            boolean r0 = r7.f1379c
            java.lang.String r5 = r7.f1377a
            r2 = 0
            r3 = -1
            if (r0 == 0) goto L_0x0024
            r6 = 3
            goto L_0x0025
        L_0x0024:
            r6 = 5
        L_0x0025:
            r1 = r20
            r1.m1890a(r2, r3, r5, r6)
            r7.m1892a((java.io.InputStream) r9, (java.io.OutputStream) r9)
        L_0x002d:
            java.util.List r0 = com.huawei.updatesdk.p039b.p048g.C1033b.m1946a()
            r0.remove(r7)
            r20.m1896d()
            return r8
        L_0x0038:
            java.net.HttpURLConnection r0 = r7.f1378b     // Catch:{ Exception -> 0x016a, all -> 0x0167 }
            r0.connect()     // Catch:{ Exception -> 0x016a, all -> 0x0167 }
            java.net.HttpURLConnection r0 = r7.f1378b     // Catch:{ Exception -> 0x016a, all -> 0x0167 }
            int r0 = r0.getResponseCode()     // Catch:{ Exception -> 0x016a, all -> 0x0167 }
            r1 = 200(0xc8, float:2.8E-43)
            if (r1 == r0) goto L_0x0058
            r1 = 206(0xce, float:2.89E-43)
            if (r1 == r0) goto L_0x0058
            boolean r0 = r7.f1379c
            java.lang.String r5 = r7.f1377a
            if (r0 == 0) goto L_0x0053
            r6 = 3
            goto L_0x0025
        L_0x0053:
            r2 = 0
            r3 = -1
            r6 = 5
            goto L_0x0025
        L_0x0058:
            long r10 = r21.mo14986e()     // Catch:{ Exception -> 0x016a, all -> 0x0167 }
            java.io.BufferedInputStream r12 = new java.io.BufferedInputStream     // Catch:{ all -> 0x014e }
            java.net.HttpURLConnection r0 = r7.f1378b     // Catch:{ all -> 0x014e }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ all -> 0x014e }
            r1 = 8192(0x2000, float:1.14794E-41)
            r12.<init>(r0, r1)     // Catch:{ all -> 0x014e }
            java.io.BufferedOutputStream r13 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x014b }
            r0 = r22
            r13.<init>(r0, r1)     // Catch:{ all -> 0x014b }
            byte[] r0 = new byte[r1]     // Catch:{ all -> 0x0148 }
            r14 = 0
            r1 = r14
            r6 = 0
        L_0x0076:
            int r3 = r12.read(r0)     // Catch:{ all -> 0x0142 }
            r4 = -1
            if (r3 == r4) goto L_0x00ba
            r13.write(r0, r8, r3)     // Catch:{ all -> 0x00b6 }
            int r6 = r6 + r3
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0142 }
            long r3 = r3 - r1
            long r3 = java.lang.Math.abs(r3)     // Catch:{ all -> 0x0142 }
            r16 = 1000(0x3e8, double:4.94E-321)
            int r5 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r5 <= 0) goto L_0x00b3
            long r16 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0142 }
            long r1 = (long) r6     // Catch:{ all -> 0x0142 }
            int r3 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r3 == 0) goto L_0x00ac
            java.lang.String r5 = r7.f1377a     // Catch:{ all -> 0x0142 }
            r18 = 2
            r1 = r20
            r2 = r6
            r3 = r10
            r19 = r6
            r6 = r18
            r1.m1890a(r2, r3, r5, r6)     // Catch:{ all -> 0x00a9 }
            goto L_0x00ae
        L_0x00a9:
            r0 = move-exception
            goto L_0x0145
        L_0x00ac:
            r19 = r6
        L_0x00ae:
            r1 = r16
            r6 = r19
            goto L_0x0076
        L_0x00b3:
            r19 = r6
            goto L_0x0076
        L_0x00b6:
            r0 = move-exception
            r2 = r6
            goto L_0x0149
        L_0x00ba:
            r7.m1892a((java.io.InputStream) r12, (java.io.OutputStream) r13)     // Catch:{ Exception -> 0x013e, all -> 0x013a }
            long r0 = (long) r6
            int r2 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r2 != 0) goto L_0x00f1
            int r0 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r0 <= 0) goto L_0x00f1
            java.lang.String r0 = r21.mo14985d()     // Catch:{ Exception -> 0x00ea, all -> 0x00e5 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00ea, all -> 0x00e5 }
            if (r0 != 0) goto L_0x00f1
            java.lang.String r0 = r21.mo14985d()     // Catch:{ Exception -> 0x00ea, all -> 0x00e5 }
            java.lang.String r1 = "SHA-256"
            r2 = r23
            java.lang.String r1 = com.huawei.updatesdk.p025a.p026a.p031d.C0972d.m1691a(r2, r1)     // Catch:{ Exception -> 0x00ea, all -> 0x00e5 }
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x00ea, all -> 0x00e5 }
            if (r0 == 0) goto L_0x00f1
            r0 = 1
            r12 = 1
            goto L_0x00f2
        L_0x00e5:
            r0 = move-exception
            r2 = r6
            r12 = r9
            goto L_0x015f
        L_0x00ea:
            r0 = move-exception
            r2 = r6
            r3 = r10
            r12 = 0
        L_0x00ee:
            r10 = r9
            goto L_0x016d
        L_0x00f1:
            r12 = 0
        L_0x00f2:
            if (r12 == 0) goto L_0x0117
            java.lang.String r5 = r7.f1377a     // Catch:{ Exception -> 0x0110, all -> 0x0106 }
            r0 = 4
            r1 = r20
            r2 = r6
            r3 = r10
            r19 = r6
            r6 = r0
            r1.m1890a(r2, r3, r5, r6)     // Catch:{ Exception -> 0x0104, all -> 0x0102 }
            goto L_0x0119
        L_0x0102:
            r0 = move-exception
            goto L_0x0109
        L_0x0104:
            r0 = move-exception
            goto L_0x0113
        L_0x0106:
            r0 = move-exception
            r19 = r6
        L_0x0109:
            r3 = r10
            r8 = r12
            r2 = r19
            r10 = r9
            goto L_0x019e
        L_0x0110:
            r0 = move-exception
            r19 = r6
        L_0x0113:
            r3 = r10
            r2 = r19
            goto L_0x00ee
        L_0x0117:
            r19 = r6
        L_0x0119:
            if (r12 != 0) goto L_0x012c
            boolean r0 = r7.f1379c
            java.lang.String r5 = r7.f1377a
            if (r0 == 0) goto L_0x0123
            r6 = 3
            goto L_0x0124
        L_0x0123:
            r6 = 5
        L_0x0124:
            r1 = r20
            r2 = r19
            r3 = r10
            r1.m1890a(r2, r3, r5, r6)
        L_0x012c:
            r7.m1892a((java.io.InputStream) r9, (java.io.OutputStream) r9)
            java.util.List r0 = com.huawei.updatesdk.p039b.p048g.C1033b.m1946a()
            r0.remove(r7)
            r20.m1896d()
            return r12
        L_0x013a:
            r0 = move-exception
            r19 = r6
            goto L_0x015d
        L_0x013e:
            r0 = move-exception
            r19 = r6
            goto L_0x0162
        L_0x0142:
            r0 = move-exception
            r19 = r6
        L_0x0145:
            r2 = r19
            goto L_0x0149
        L_0x0148:
            r0 = move-exception
        L_0x0149:
            r6 = r2
            goto L_0x0152
        L_0x014b:
            r0 = move-exception
            r13 = r9
            goto L_0x0151
        L_0x014e:
            r0 = move-exception
            r12 = r9
            r13 = r12
        L_0x0151:
            r6 = 0
        L_0x0152:
            r7.m1892a((java.io.InputStream) r12, (java.io.OutputStream) r13)     // Catch:{ Exception -> 0x0161, all -> 0x015c }
            throw r0     // Catch:{ Exception -> 0x0159, all -> 0x0156 }
        L_0x0156:
            r0 = move-exception
            r12 = r9
            goto L_0x015e
        L_0x0159:
            r0 = move-exception
            r12 = r9
            goto L_0x0163
        L_0x015c:
            r0 = move-exception
        L_0x015d:
            r9 = r13
        L_0x015e:
            r2 = r6
        L_0x015f:
            r3 = r10
            goto L_0x019f
        L_0x0161:
            r0 = move-exception
        L_0x0162:
            r9 = r13
        L_0x0163:
            r2 = r6
            r3 = r10
            r10 = r12
            goto L_0x016c
        L_0x0167:
            r0 = move-exception
            r12 = r9
            goto L_0x019f
        L_0x016a:
            r0 = move-exception
            r10 = r9
        L_0x016c:
            r12 = 0
        L_0x016d:
            java.lang.String r1 = "DownloadMarketTask"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x019c }
            r5.<init>()     // Catch:{ all -> 0x019c }
            java.lang.String r6 = "downloadUrlToStream(String urlString,OutputStream outputStream) "
            r5.append(r6)     // Catch:{ all -> 0x019c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x019c }
            r5.append(r0)     // Catch:{ all -> 0x019c }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x019c }
            com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a.m1682b(r1, r0)     // Catch:{ all -> 0x019c }
            if (r12 != 0) goto L_0x0197
            boolean r0 = r7.f1379c
            java.lang.String r5 = r7.f1377a
            if (r0 == 0) goto L_0x0191
            r6 = 3
            goto L_0x0192
        L_0x0191:
            r6 = 5
        L_0x0192:
            r1 = r20
            r1.m1890a(r2, r3, r5, r6)
        L_0x0197:
            r7.m1892a((java.io.InputStream) r10, (java.io.OutputStream) r9)
            goto L_0x002d
        L_0x019c:
            r0 = move-exception
            r8 = r12
        L_0x019e:
            r12 = r10
        L_0x019f:
            if (r8 != 0) goto L_0x01af
            boolean r1 = r7.f1379c
            java.lang.String r5 = r7.f1377a
            if (r1 == 0) goto L_0x01a9
            r6 = 3
            goto L_0x01aa
        L_0x01a9:
            r6 = 5
        L_0x01aa:
            r1 = r20
            r1.m1890a(r2, r3, r5, r6)
        L_0x01af:
            r7.m1892a((java.io.InputStream) r12, (java.io.OutputStream) r9)
            java.util.List r1 = com.huawei.updatesdk.p039b.p048g.C1033b.m1946a()
            r1.remove(r7)
            r20.m1896d()
            goto L_0x01be
        L_0x01bd:
            throw r0
        L_0x01be:
            goto L_0x01bd
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.updatesdk.p039b.p045d.C1015c.m1893a(com.huawei.updatesdk.b.d.b, java.io.OutputStream, java.lang.String):boolean");
    }

    /* renamed from: d */
    private void m1896d() {
        HttpURLConnection httpURLConnection = this.f1378b;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static String m1897e() {
        String b = C0985a.m1757c().mo14893b();
        if (TextUtils.isEmpty(b)) {
            return "";
        }
        String str = b + "/updatesdk";
        File file = new File(str);
        return (file.exists() || file.mkdirs()) ? str : "";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        C1033b.m1947a(this);
        m1891a(this.f1380d, m1897e());
        return null;
    }

    /* renamed from: a */
    public void mo14988a() {
        new Thread(new C1016a()).start();
    }

    /* renamed from: b */
    public void mo14989b() {
        this.f1381e = null;
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        super.onCancelled();
        mo14988a();
    }
}
