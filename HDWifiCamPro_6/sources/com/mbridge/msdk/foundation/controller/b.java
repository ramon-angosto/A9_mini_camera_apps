package com.mbridge.msdk.foundation.controller;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.MBridgeSDK;
import com.mbridge.msdk.foundation.entity.k;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.a;
import com.mbridge.msdk.foundation.same.report.c;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.MBridgeSDKFactory;
import java.io.File;
import java.util.List;
import java.util.Map;

/* compiled from: SDKController */
public final class b {
    private static b h;
    public final int a = 1;
    public final int b = 2;
    public final int c = 3;
    public final int d = 4;
    public final int e = 5;
    public final int f = 6;
    Handler g = new Handler() {
        public final void handleMessage(Message message) {
            List list;
            try {
                int i = message.what;
                if (i != 2) {
                    if (i == 3) {
                        File file = (File) message.obj;
                        if (file != null) {
                            String a2 = o.a(file);
                            if (!TextUtils.isEmpty(a2)) {
                                String[] split = a2.split("====");
                                if (split.length > 0) {
                                    new c(b.this.i).a(split[0], file);
                                }
                            }
                        }
                    } else if (i == 4) {
                        String str = (String) message.obj;
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        if (a.a().c()) {
                            a.a().a(str);
                        } else {
                            new c(b.this.i, 0).a("click_duration", str, (String) null, (Frame) null);
                        }
                    } else if (i == 5) {
                        String str2 = (String) message.obj;
                        if (TextUtils.isEmpty(str2)) {
                            return;
                        }
                        if (a.a().c()) {
                            a.a().a(str2);
                        } else {
                            new c(b.this.i, 0).a("load_duration", str2, (String) null, (Frame) null);
                        }
                    } else if (i != 6) {
                        if (i == 9) {
                            if (((com.mbridge.msdk.b.a) message.obj).r() == 1) {
                                com.mbridge.msdk.foundation.same.report.b.a.a(b.this.i).a();
                            }
                        }
                    } else if (message.obj != null && (message.obj instanceof String)) {
                        String str3 = (String) message.obj;
                        if (TextUtils.isEmpty(str3)) {
                            return;
                        }
                        if (a.a().c()) {
                            a.a().a(str3);
                        } else {
                            new c(b.this.i, 0).a("device_data", str3, (String) null, (Frame) null);
                        }
                    }
                } else if ((message.obj instanceof List) && (list = (List) message.obj) != null && list.size() > 0) {
                    c cVar = new c(b.this.i, 0);
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        k kVar = (k) list.get(i2);
                        boolean z = false;
                        if (i2 == list.size() - 1) {
                            z = true;
                        }
                        cVar.a(kVar, z);
                    }
                }
            } catch (Exception e) {
                q.d("SDKController", e.getMessage());
            }
        }
    };
    /* access modifiers changed from: private */
    public Context i;
    private String j;
    /* access modifiers changed from: private */
    public String k;
    private String l;
    private boolean m = false;
    private com.mbridge.msdk.a.a n;
    private String o;
    private boolean p = false;
    private Map<String, Object> q;
    private int r;

    private b() {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (h == null) {
                h = new b();
            }
            bVar = h;
        }
        return bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x0182 A[Catch:{ Exception -> 0x01aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x018f A[Catch:{ Exception -> 0x01aa }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.Map r10, final android.content.Context r11) {
        /*
            r9 = this;
            java.lang.String r0 = "SDKController"
            if (r11 == 0) goto L_0x01bc
            java.lang.String r1 = "mbridge_appid"
            boolean r2 = r10.containsKey(r1)
            if (r2 == 0) goto L_0x0014
            java.lang.Object r2 = r10.get(r1)
            java.lang.String r2 = (java.lang.String) r2
            r9.k = r2
        L_0x0014:
            android.content.Context r2 = r11.getApplicationContext()
            r9.i = r2
            com.mbridge.msdk.foundation.controller.a r2 = com.mbridge.msdk.foundation.controller.a.e()
            android.content.Context r3 = r9.i
            r2.b((android.content.Context) r3)
            java.lang.Object r2 = r10.get(r1)     // Catch:{ Exception -> 0x003b, all -> 0x0039 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x003b, all -> 0x0039 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x003b, all -> 0x0039 }
            if (r3 != 0) goto L_0x0044
            com.mbridge.msdk.foundation.a.a.a r3 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ Exception -> 0x003b, all -> 0x0039 }
            java.lang.String r4 = "sdk_app_id"
            r3.a((java.lang.String) r4, (java.lang.String) r2)     // Catch:{ Exception -> 0x003b, all -> 0x0039 }
            goto L_0x0044
        L_0x0039:
            r2 = move-exception
            goto L_0x003d
        L_0x003b:
            r2 = move-exception
            goto L_0x0041
        L_0x003d:
            r2.printStackTrace()
            goto L_0x0044
        L_0x0041:
            r2.printStackTrace()
        L_0x0044:
            boolean r2 = r9.m
            r3 = 1
            if (r2 != r3) goto L_0x0052
            com.mbridge.msdk.foundation.same.report.c r10 = new com.mbridge.msdk.foundation.same.report.c
            r10.<init>(r11)
            r10.a()
            return
        L_0x0052:
            com.mbridge.msdk.foundation.tools.m.m(r11)
            android.os.Handler r2 = new android.os.Handler
            r2.<init>()
            com.mbridge.msdk.foundation.controller.b$1 r4 = new com.mbridge.msdk.foundation.controller.b$1
            r4.<init>(r11)
            r5 = 300(0x12c, double:1.48E-321)
            r2.postDelayed(r4, r5)
            if (r10 == 0) goto L_0x01bc
            boolean r11 = r10.containsKey(r1)
            if (r11 == 0) goto L_0x0074
            java.lang.Object r11 = r10.get(r1)
            java.lang.String r11 = (java.lang.String) r11
            r9.k = r11
        L_0x0074:
            java.lang.String r11 = "mbridge_appkey"
            boolean r1 = r10.containsKey(r11)
            if (r1 == 0) goto L_0x0084
            java.lang.Object r11 = r10.get(r11)
            java.lang.String r11 = (java.lang.String) r11
            r9.l = r11
        L_0x0084:
            java.lang.String r11 = "applicationID"
            boolean r1 = r10.containsKey(r11)
            if (r1 == 0) goto L_0x0094
            java.lang.Object r11 = r10.get(r11)
            java.lang.String r11 = (java.lang.String) r11
            r9.o = r11
        L_0x0094:
            java.lang.String r11 = "mbridge_appstartupcarsh"
            boolean r1 = r10.containsKey(r11)
            if (r1 == 0) goto L_0x00a4
            java.lang.Object r10 = r10.get(r11)
            java.lang.String r10 = (java.lang.String) r10
            r9.j = r10
        L_0x00a4:
            r9.e()
            com.mbridge.msdk.foundation.controller.a r10 = com.mbridge.msdk.foundation.controller.a.e()
            java.lang.String r11 = r9.k
            r10.b((java.lang.String) r11)
            com.mbridge.msdk.foundation.controller.a r10 = com.mbridge.msdk.foundation.controller.a.e()
            java.lang.String r11 = r9.l
            r10.c((java.lang.String) r11)
            com.mbridge.msdk.foundation.controller.a r10 = com.mbridge.msdk.foundation.controller.a.e()
            java.lang.String r11 = r9.o
            r10.a((java.lang.String) r11)
            com.mbridge.msdk.foundation.controller.a r10 = com.mbridge.msdk.foundation.controller.a.e()
            com.mbridge.msdk.foundation.controller.b$6 r11 = new com.mbridge.msdk.foundation.controller.b$6
            r11.<init>()
            android.os.Handler r1 = r9.g
            r10.a((com.mbridge.msdk.foundation.controller.a.b) r11, (android.os.Handler) r1)
            android.content.Context r10 = r9.i
            android.content.Context r10 = r10.getApplicationContext()
            java.lang.String r11 = "H+tU+FeXHM=="
            java.lang.String r11 = com.mbridge.msdk.foundation.tools.l.b(r11)     // Catch:{ all -> 0x0176 }
            r1 = 0
            android.content.SharedPreferences r10 = r10.getSharedPreferences(r11, r1)     // Catch:{ all -> 0x0176 }
            java.lang.String r11 = "H+tU+Fz8"
            java.lang.String r1 = "H+tU+bfPhM=="
            java.lang.String r2 = ""
            if (r10 == 0) goto L_0x00fd
            java.lang.String r4 = com.mbridge.msdk.foundation.tools.l.b(r1)     // Catch:{ all -> 0x0176 }
            java.lang.String r4 = r10.getString(r4, r2)     // Catch:{ all -> 0x0176 }
            java.lang.String r5 = com.mbridge.msdk.foundation.tools.l.b(r11)     // Catch:{ all -> 0x0176 }
            java.lang.String r2 = r10.getString(r5, r2)     // Catch:{ all -> 0x0176 }
            r8 = r4
            r4 = r2
            r2 = r8
            goto L_0x00fe
        L_0x00fd:
            r4 = r2
        L_0x00fe:
            java.lang.String r5 = com.mbridge.msdk.foundation.same.a.k     // Catch:{ all -> 0x0176 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0176 }
            java.lang.String r6 = "c"
            java.lang.String r7 = "b"
            if (r5 == 0) goto L_0x0126
            java.lang.String r5 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ all -> 0x0176 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0176 }
            if (r5 == 0) goto L_0x0126
            com.mbridge.msdk.foundation.a.a.a r5 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ all -> 0x0176 }
            java.lang.String r5 = r5.b(r7)     // Catch:{ all -> 0x0176 }
            com.mbridge.msdk.foundation.same.a.k = r5     // Catch:{ all -> 0x0176 }
            com.mbridge.msdk.foundation.a.a.a r5 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ all -> 0x0176 }
            java.lang.String r5 = r5.b(r6)     // Catch:{ all -> 0x0176 }
            com.mbridge.msdk.foundation.same.a.l = r5     // Catch:{ all -> 0x0176 }
        L_0x0126:
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0176 }
            if (r5 == 0) goto L_0x015f
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0176 }
            if (r5 == 0) goto L_0x015f
            java.lang.String r2 = com.mbridge.msdk.foundation.same.a.k     // Catch:{ all -> 0x0176 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0176 }
            if (r2 == 0) goto L_0x0143
            java.lang.String r2 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ all -> 0x0176 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0176 }
            if (r2 == 0) goto L_0x0143
            goto L_0x017e
        L_0x0143:
            if (r10 == 0) goto L_0x017e
            android.content.SharedPreferences$Editor r10 = r10.edit()     // Catch:{ all -> 0x0176 }
            java.lang.String r1 = com.mbridge.msdk.foundation.tools.l.b(r1)     // Catch:{ all -> 0x0176 }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.a.k     // Catch:{ all -> 0x0176 }
            r10.putString(r1, r2)     // Catch:{ all -> 0x0176 }
            java.lang.String r11 = com.mbridge.msdk.foundation.tools.l.b(r11)     // Catch:{ all -> 0x0176 }
            java.lang.String r1 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ all -> 0x0176 }
            r10.putString(r11, r1)     // Catch:{ all -> 0x0176 }
            r10.apply()     // Catch:{ all -> 0x0176 }
            goto L_0x017e
        L_0x015f:
            com.mbridge.msdk.foundation.same.a.k = r2     // Catch:{ all -> 0x0176 }
            com.mbridge.msdk.foundation.same.a.l = r4     // Catch:{ all -> 0x0176 }
            com.mbridge.msdk.foundation.a.a.a r10 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ all -> 0x0176 }
            java.lang.String r11 = com.mbridge.msdk.foundation.same.a.k     // Catch:{ all -> 0x0176 }
            r10.a((java.lang.String) r7, (java.lang.String) r11)     // Catch:{ all -> 0x0176 }
            com.mbridge.msdk.foundation.a.a.a r10 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ all -> 0x0176 }
            java.lang.String r11 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ all -> 0x0176 }
            r10.a((java.lang.String) r6, (java.lang.String) r11)     // Catch:{ all -> 0x0176 }
            goto L_0x017e
        L_0x0176:
            r10 = move-exception
            java.lang.String r11 = r10.getMessage()
            com.mbridge.msdk.foundation.tools.q.a(r0, r11, r10)
        L_0x017e:
            boolean r10 = com.mbridge.msdk.MBridgeConstans.INIT_UA_IN     // Catch:{ Exception -> 0x01aa }
            if (r10 == 0) goto L_0x018f
            java.util.concurrent.ThreadPoolExecutor r10 = com.mbridge.msdk.foundation.same.f.b.a()     // Catch:{ Exception -> 0x01aa }
            com.mbridge.msdk.foundation.controller.b$2 r11 = new com.mbridge.msdk.foundation.controller.b$2     // Catch:{ Exception -> 0x01aa }
            r11.<init>()     // Catch:{ Exception -> 0x01aa }
            r10.execute(r11)     // Catch:{ Exception -> 0x01aa }
            goto L_0x01b2
        L_0x018f:
            android.os.Looper r10 = android.os.Looper.myLooper()     // Catch:{ Exception -> 0x01aa }
            android.os.Looper r11 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x01aa }
            if (r10 != r11) goto L_0x01a6
            java.util.concurrent.ThreadPoolExecutor r10 = com.mbridge.msdk.foundation.same.f.b.a()     // Catch:{ Exception -> 0x01aa }
            com.mbridge.msdk.foundation.controller.b$3 r11 = new com.mbridge.msdk.foundation.controller.b$3     // Catch:{ Exception -> 0x01aa }
            r11.<init>()     // Catch:{ Exception -> 0x01aa }
            r10.execute(r11)     // Catch:{ Exception -> 0x01aa }
            goto L_0x01b2
        L_0x01a6:
            r9.d()     // Catch:{ Exception -> 0x01aa }
            goto L_0x01b2
        L_0x01aa:
            r10 = move-exception
            java.lang.String r10 = r10.getMessage()
            com.mbridge.msdk.foundation.tools.q.d(r0, r10)
        L_0x01b2:
            r9.c()
            android.content.Context r10 = r9.i
            com.mbridge.msdk.foundation.tools.s.a((android.content.Context) r10)
            r9.m = r3
        L_0x01bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.controller.b.a(java.util.Map, android.content.Context):void");
    }

    /* access modifiers changed from: private */
    public void d() {
        try {
            Class<?> cls = Class.forName("com.mbridge.msdk.c.b");
            cls.getDeclaredMethod("start", new Class[0]).invoke(cls.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]), new Object[0]);
        } catch (Throwable th) {
            q.a("SDKController", th.getMessage(), th);
        }
    }

    private void e() {
        List<com.mbridge.msdk.foundation.entity.a> b2;
        Class<?> cls;
        Object newInstance;
        Object newInstance2;
        try {
            com.mbridge.msdk.b.a b3 = com.mbridge.msdk.b.b.a().b(a.e().h());
            if (b3 != null && (b2 = b3.b()) != null && b2.size() > 0) {
                for (com.mbridge.msdk.foundation.entity.a next : b2) {
                    if (next.a() == 287) {
                        Class<?> cls2 = Class.forName("com.mbridge.msdk.interstitialvideo.out.MBInterstitialVideoHandler");
                        if (!(this.i == null || cls2 == null || (newInstance2 = cls2.getConstructor(new Class[]{String.class, String.class}).newInstance(new Object[]{"", next.b()})) == null)) {
                            cls2.getMethod("loadFormSelfFilling", new Class[0]).invoke(newInstance2, new Object[0]);
                        }
                    } else if (!(next.a() != 94 || (cls = Class.forName("com.mbridge.msdk.out.MBRewardVideoHandler")) == null || (newInstance = cls.getConstructor(new Class[]{String.class, String.class}).newInstance(new Object[]{"", next.b()})) == null)) {
                        cls.getMethod("loadFormSelfFilling", new Class[0]).invoke(newInstance, new Object[0]);
                    }
                }
            }
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }

    public final void b() {
        Handler handler = this.g;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public final void c() {
        new Thread(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:14:0x005c A[Catch:{ Exception -> 0x025c }] */
            /* JADX WARNING: Removed duplicated region for block: B:17:0x007e A[Catch:{ Exception -> 0x025c }] */
            /* JADX WARNING: Removed duplicated region for block: B:42:0x0228 A[Catch:{ Exception -> 0x025c }] */
            /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r11 = this;
                    com.mbridge.msdk.foundation.same.report.c.a.a()     // Catch:{ Exception -> 0x025c }
                    com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.this     // Catch:{ Exception -> 0x025c }
                    android.content.Context r0 = r0.i     // Catch:{ Exception -> 0x025c }
                    r1 = 0
                    r2 = 5
                    if (r0 != 0) goto L_0x000e
                    goto L_0x0029
                L_0x000e:
                    com.mbridge.msdk.foundation.db.g r3 = com.mbridge.msdk.foundation.db.g.a((android.content.Context) r0)     // Catch:{ Exception -> 0x025c }
                    com.mbridge.msdk.foundation.db.m r3 = com.mbridge.msdk.foundation.db.m.a((com.mbridge.msdk.foundation.db.f) r3)     // Catch:{ Exception -> 0x025c }
                    int r3 = r3.a()     // Catch:{ Exception -> 0x025c }
                    if (r3 <= 0) goto L_0x0029
                    com.mbridge.msdk.foundation.db.g r0 = com.mbridge.msdk.foundation.db.g.a((android.content.Context) r0)     // Catch:{ Exception -> 0x025c }
                    com.mbridge.msdk.foundation.db.m r0 = com.mbridge.msdk.foundation.db.m.a((com.mbridge.msdk.foundation.db.f) r0)     // Catch:{ Exception -> 0x025c }
                    java.util.List r0 = r0.a((int) r2)     // Catch:{ Exception -> 0x025c }
                    goto L_0x002a
                L_0x0029:
                    r0 = r1
                L_0x002a:
                    if (r0 == 0) goto L_0x0046
                    int r3 = r0.size()     // Catch:{ Exception -> 0x025c }
                    if (r3 <= 0) goto L_0x0046
                    com.mbridge.msdk.foundation.controller.b r3 = com.mbridge.msdk.foundation.controller.b.this     // Catch:{ Exception -> 0x025c }
                    android.os.Handler r3 = r3.g     // Catch:{ Exception -> 0x025c }
                    android.os.Message r3 = r3.obtainMessage()     // Catch:{ Exception -> 0x025c }
                    r4 = 2
                    r3.what = r4     // Catch:{ Exception -> 0x025c }
                    r3.obj = r0     // Catch:{ Exception -> 0x025c }
                    com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.this     // Catch:{ Exception -> 0x025c }
                    android.os.Handler r0 = r0.g     // Catch:{ Exception -> 0x025c }
                    r0.sendMessage(r3)     // Catch:{ Exception -> 0x025c }
                L_0x0046:
                    com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.this     // Catch:{ Exception -> 0x025c }
                    android.content.Context r0 = r0.i     // Catch:{ Exception -> 0x025c }
                    com.mbridge.msdk.foundation.db.g r0 = com.mbridge.msdk.foundation.db.g.a((android.content.Context) r0)     // Catch:{ Exception -> 0x025c }
                    com.mbridge.msdk.foundation.db.d r3 = com.mbridge.msdk.foundation.db.d.a((com.mbridge.msdk.foundation.db.f) r0)     // Catch:{ Exception -> 0x025c }
                    int r4 = r3.a()     // Catch:{ Exception -> 0x025c }
                    r5 = 20
                    if (r4 < r5) goto L_0x0074
                    java.util.List r3 = r3.a((int) r5)     // Catch:{ Exception -> 0x025c }
                    java.lang.String r3 = com.mbridge.msdk.foundation.entity.d.a((java.util.List<com.mbridge.msdk.foundation.entity.d>) r3)     // Catch:{ Exception -> 0x025c }
                    android.os.Message r4 = android.os.Message.obtain()     // Catch:{ Exception -> 0x025c }
                    r4.obj = r3     // Catch:{ Exception -> 0x025c }
                    r3 = 4
                    r4.what = r3     // Catch:{ Exception -> 0x025c }
                    com.mbridge.msdk.foundation.controller.b r3 = com.mbridge.msdk.foundation.controller.b.this     // Catch:{ Exception -> 0x025c }
                    android.os.Handler r3 = r3.g     // Catch:{ Exception -> 0x025c }
                    r3.sendMessage(r4)     // Catch:{ Exception -> 0x025c }
                L_0x0074:
                    com.mbridge.msdk.foundation.db.k r0 = com.mbridge.msdk.foundation.db.k.a((com.mbridge.msdk.foundation.db.f) r0)     // Catch:{ Exception -> 0x025c }
                    int r3 = r0.a()     // Catch:{ Exception -> 0x025c }
                    if (r3 <= r5) goto L_0x0208
                    java.util.List r0 = r0.a((int) r5)     // Catch:{ Exception -> 0x025c }
                    if (r0 == 0) goto L_0x01f9
                    int r3 = r0.size()     // Catch:{ Exception -> 0x025c }
                    if (r3 <= 0) goto L_0x01f9
                    java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x025c }
                    r1.<init>()     // Catch:{ Exception -> 0x025c }
                    java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x025c }
                L_0x0093:
                    boolean r3 = r0.hasNext()     // Catch:{ Exception -> 0x025c }
                    if (r3 == 0) goto L_0x01f5
                    java.lang.Object r3 = r0.next()     // Catch:{ Exception -> 0x025c }
                    com.mbridge.msdk.foundation.entity.g r3 = (com.mbridge.msdk.foundation.entity.g) r3     // Catch:{ Exception -> 0x025c }
                    com.mbridge.msdk.foundation.controller.authoritycontroller.a r4 = com.mbridge.msdk.foundation.controller.authoritycontroller.a.a()     // Catch:{ Exception -> 0x025c }
                    java.lang.String r5 = "authority_general_data"
                    boolean r4 = r4.a((java.lang.String) r5)     // Catch:{ Exception -> 0x025c }
                    java.lang.String r5 = "&fb="
                    java.lang.String r6 = "&key=2000006"
                    java.lang.String r7 = "&unit_id="
                    java.lang.String r8 = "&num="
                    java.lang.String r9 = "&time="
                    java.lang.String r10 = "ad_source_id="
                    if (r4 == 0) goto L_0x0159
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x025c }
                    r4.<init>()     // Catch:{ Exception -> 0x025c }
                    r4.append(r10)     // Catch:{ Exception -> 0x025c }
                    int r10 = r3.b()     // Catch:{ Exception -> 0x025c }
                    r4.append(r10)     // Catch:{ Exception -> 0x025c }
                    java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x025c }
                    r1.append(r4)     // Catch:{ Exception -> 0x025c }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x025c }
                    r4.<init>()     // Catch:{ Exception -> 0x025c }
                    r4.append(r9)     // Catch:{ Exception -> 0x025c }
                    java.lang.String r9 = r3.c()     // Catch:{ Exception -> 0x025c }
                    r4.append(r9)     // Catch:{ Exception -> 0x025c }
                    java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x025c }
                    r1.append(r4)     // Catch:{ Exception -> 0x025c }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x025c }
                    r4.<init>()     // Catch:{ Exception -> 0x025c }
                    r4.append(r8)     // Catch:{ Exception -> 0x025c }
                    int r8 = r3.d()     // Catch:{ Exception -> 0x025c }
                    r4.append(r8)     // Catch:{ Exception -> 0x025c }
                    java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x025c }
                    r1.append(r4)     // Catch:{ Exception -> 0x025c }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x025c }
                    r4.<init>()     // Catch:{ Exception -> 0x025c }
                    r4.append(r7)     // Catch:{ Exception -> 0x025c }
                    java.lang.String r7 = r3.e()     // Catch:{ Exception -> 0x025c }
                    r4.append(r7)     // Catch:{ Exception -> 0x025c }
                    java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x025c }
                    r1.append(r4)     // Catch:{ Exception -> 0x025c }
                    r1.append(r6)     // Catch:{ Exception -> 0x025c }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x025c }
                    r4.<init>()     // Catch:{ Exception -> 0x025c }
                    r4.append(r5)     // Catch:{ Exception -> 0x025c }
                    int r5 = r3.f()     // Catch:{ Exception -> 0x025c }
                    r4.append(r5)     // Catch:{ Exception -> 0x025c }
                    java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x025c }
                    r1.append(r4)     // Catch:{ Exception -> 0x025c }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x025c }
                    r4.<init>()     // Catch:{ Exception -> 0x025c }
                    java.lang.String r5 = "&network_str="
                    r4.append(r5)     // Catch:{ Exception -> 0x025c }
                    java.lang.String r5 = r3.i()     // Catch:{ Exception -> 0x025c }
                    r4.append(r5)     // Catch:{ Exception -> 0x025c }
                    java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x025c }
                    r1.append(r4)     // Catch:{ Exception -> 0x025c }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x025c }
                    r4.<init>()     // Catch:{ Exception -> 0x025c }
                    java.lang.String r5 = "&network_type="
                    r4.append(r5)     // Catch:{ Exception -> 0x025c }
                    int r5 = r3.h()     // Catch:{ Exception -> 0x025c }
                    r4.append(r5)     // Catch:{ Exception -> 0x025c }
                    java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x025c }
                    r1.append(r4)     // Catch:{ Exception -> 0x025c }
                    goto L_0x01ca
                L_0x0159:
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x025c }
                    r4.<init>()     // Catch:{ Exception -> 0x025c }
                    r4.append(r10)     // Catch:{ Exception -> 0x025c }
                    int r10 = r3.b()     // Catch:{ Exception -> 0x025c }
                    r4.append(r10)     // Catch:{ Exception -> 0x025c }
                    java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x025c }
                    r1.append(r4)     // Catch:{ Exception -> 0x025c }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x025c }
                    r4.<init>()     // Catch:{ Exception -> 0x025c }
                    r4.append(r9)     // Catch:{ Exception -> 0x025c }
                    java.lang.String r9 = r3.c()     // Catch:{ Exception -> 0x025c }
                    r4.append(r9)     // Catch:{ Exception -> 0x025c }
                    java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x025c }
                    r1.append(r4)     // Catch:{ Exception -> 0x025c }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x025c }
                    r4.<init>()     // Catch:{ Exception -> 0x025c }
                    r4.append(r8)     // Catch:{ Exception -> 0x025c }
                    int r8 = r3.d()     // Catch:{ Exception -> 0x025c }
                    r4.append(r8)     // Catch:{ Exception -> 0x025c }
                    java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x025c }
                    r1.append(r4)     // Catch:{ Exception -> 0x025c }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x025c }
                    r4.<init>()     // Catch:{ Exception -> 0x025c }
                    r4.append(r7)     // Catch:{ Exception -> 0x025c }
                    java.lang.String r7 = r3.e()     // Catch:{ Exception -> 0x025c }
                    r4.append(r7)     // Catch:{ Exception -> 0x025c }
                    java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x025c }
                    r1.append(r4)     // Catch:{ Exception -> 0x025c }
                    r1.append(r6)     // Catch:{ Exception -> 0x025c }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x025c }
                    r4.<init>()     // Catch:{ Exception -> 0x025c }
                    r4.append(r5)     // Catch:{ Exception -> 0x025c }
                    int r5 = r3.f()     // Catch:{ Exception -> 0x025c }
                    r4.append(r5)     // Catch:{ Exception -> 0x025c }
                    java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x025c }
                    r1.append(r4)     // Catch:{ Exception -> 0x025c }
                L_0x01ca:
                    int r4 = r3.a()     // Catch:{ Exception -> 0x025c }
                    r5 = 1
                    if (r4 != r5) goto L_0x01d6
                    java.lang.String r4 = "&hb=1"
                    r1.append(r4)     // Catch:{ Exception -> 0x025c }
                L_0x01d6:
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x025c }
                    r4.<init>()     // Catch:{ Exception -> 0x025c }
                    java.lang.String r5 = "&timeout="
                    r4.append(r5)     // Catch:{ Exception -> 0x025c }
                    int r3 = r3.g()     // Catch:{ Exception -> 0x025c }
                    r4.append(r3)     // Catch:{ Exception -> 0x025c }
                    java.lang.String r3 = "\n"
                    r4.append(r3)     // Catch:{ Exception -> 0x025c }
                    java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x025c }
                    r1.append(r3)     // Catch:{ Exception -> 0x025c }
                    goto L_0x0093
                L_0x01f5:
                    java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x025c }
                L_0x01f9:
                    android.os.Message r0 = android.os.Message.obtain()     // Catch:{ Exception -> 0x025c }
                    r0.obj = r1     // Catch:{ Exception -> 0x025c }
                    r0.what = r2     // Catch:{ Exception -> 0x025c }
                    com.mbridge.msdk.foundation.controller.b r1 = com.mbridge.msdk.foundation.controller.b.this     // Catch:{ Exception -> 0x025c }
                    android.os.Handler r1 = r1.g     // Catch:{ Exception -> 0x025c }
                    r1.sendMessage(r0)     // Catch:{ Exception -> 0x025c }
                L_0x0208:
                    com.mbridge.msdk.foundation.same.b.c r0 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_CRASH_INFO     // Catch:{ Exception -> 0x025c }
                    java.lang.String r0 = com.mbridge.msdk.foundation.same.b.e.b(r0)     // Catch:{ Exception -> 0x025c }
                    java.lang.String r1 = "/"
                    java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x025c }
                    r2.<init>(r0)     // Catch:{ Exception -> 0x025c }
                    boolean r3 = r2.exists()     // Catch:{ Exception -> 0x025c }
                    if (r3 == 0) goto L_0x0266
                    boolean r3 = r2.isDirectory()     // Catch:{ Exception -> 0x025c }
                    if (r3 == 0) goto L_0x0266
                    java.lang.String[] r3 = r2.list()     // Catch:{ Exception -> 0x025c }
                    int r3 = r3.length     // Catch:{ Exception -> 0x025c }
                    if (r3 <= 0) goto L_0x0266
                    java.lang.String[] r2 = r2.list()     // Catch:{ Exception -> 0x025c }
                    int r3 = r2.length     // Catch:{ Exception -> 0x025c }
                    r4 = 0
                L_0x022e:
                    if (r4 >= r3) goto L_0x0266
                    r5 = r2[r4]     // Catch:{ Exception -> 0x025c }
                    java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x025c }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x025c }
                    r7.<init>()     // Catch:{ Exception -> 0x025c }
                    r7.append(r0)     // Catch:{ Exception -> 0x025c }
                    r7.append(r1)     // Catch:{ Exception -> 0x025c }
                    r7.append(r5)     // Catch:{ Exception -> 0x025c }
                    java.lang.String r5 = r7.toString()     // Catch:{ Exception -> 0x025c }
                    r6.<init>(r5)     // Catch:{ Exception -> 0x025c }
                    android.os.Message r5 = android.os.Message.obtain()     // Catch:{ Exception -> 0x025c }
                    r5.obj = r6     // Catch:{ Exception -> 0x025c }
                    r6 = 3
                    r5.what = r6     // Catch:{ Exception -> 0x025c }
                    com.mbridge.msdk.foundation.controller.b r6 = com.mbridge.msdk.foundation.controller.b.this     // Catch:{ Exception -> 0x025c }
                    android.os.Handler r6 = r6.g     // Catch:{ Exception -> 0x025c }
                    r6.sendMessage(r5)     // Catch:{ Exception -> 0x025c }
                    int r4 = r4 + 1
                    goto L_0x022e
                L_0x025c:
                    r0 = move-exception
                    java.lang.String r0 = r0.getMessage()
                    java.lang.String r1 = "SDKController"
                    com.mbridge.msdk.foundation.tools.q.d(r1, r0)
                L_0x0266:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.controller.b.AnonymousClass5.run():void");
            }
        }).start();
    }

    public final void a(Map<String, Object> map, int i2) {
        if (MBridgeSDKFactory.getMBridgeSDK().getStatus() == MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            this.q = map;
            this.r = i2;
            a.e().h();
            if (map != null) {
                if (this.n == null) {
                    this.n = new com.mbridge.msdk.a.a();
                }
                try {
                    if (this.q != null && this.q.size() > 0 && this.q.containsKey(MBridgeConstans.PROPERTIES_LAYOUT_TYPE)) {
                        int intValue = ((Integer) this.q.get(MBridgeConstans.PROPERTIES_LAYOUT_TYPE)).intValue();
                        if (intValue == 0) {
                            com.mbridge.msdk.a.a aVar = this.n;
                            Map<String, Object> map2 = this.q;
                            int i3 = this.r;
                            try {
                                Class<?> cls = Class.forName("com.mbridge.msdk.mbnative.e.a");
                                Object newInstance = cls.newInstance();
                                cls.getMethod("preload", new Class[]{Map.class, Integer.TYPE}).invoke(newInstance, new Object[]{map2, Integer.valueOf(i3)});
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } else if (1 == intValue) {
                            com.mbridge.msdk.a.a aVar2 = this.n;
                            Map<String, Object> map3 = this.q;
                        } else if (2 == intValue) {
                            com.mbridge.msdk.a.a aVar3 = this.n;
                            Map<String, Object> map4 = this.q;
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    static /* synthetic */ void a(b bVar, String str) {
        if (com.mbridge.msdk.b.b.a() != null) {
            if (!com.mbridge.msdk.b.b.a().a(str) || !com.mbridge.msdk.b.b.a().a(str, 1, (String) null)) {
                new c(bVar.i).a();
                com.mbridge.msdk.b.b a2 = com.mbridge.msdk.b.b.a();
                if (a2 != null) {
                    com.mbridge.msdk.b.a b2 = a2.b(str);
                    if (b2 != null) {
                        MBridgeConstans.OMID_JS_SERVICE_URL = b2.ab();
                        d.c().c = b2.k();
                        d.c().e();
                        return;
                    }
                    MBridgeConstans.OMID_JS_SERVICE_URL = "https://cdn-adn-https.rayjump.com/cdn-adn/v2/portal/19/08/20/11/06/5d5b63cb457e2.js";
                    return;
                }
                return;
            }
            new com.mbridge.msdk.b.c().a(bVar.i, str, bVar.l);
        }
    }
}
