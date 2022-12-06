package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.mbridge.msdk.b.b;
import com.mbridge.msdk.foundation.db.BatchReportDao;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: MBBatchReportManager */
public final class a {
    /* access modifiers changed from: private */
    public static final String a = a.class.getSimpleName();
    private static volatile a b;
    /* access modifiers changed from: private */
    public Handler c;
    private boolean d = false;
    private int e = 30;
    private long f = DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS;
    private String g = d.c().a;
    /* access modifiers changed from: private */
    public BatchReportDao h;
    /* access modifiers changed from: private */
    public AtomicInteger i;
    /* access modifiers changed from: private */
    public Stack<Long> j;

    private a() {
        com.mbridge.msdk.b.a b2 = b.a().b(com.mbridge.msdk.foundation.controller.a.e().h());
        if (b2 != null) {
            this.e = b2.S();
            this.f = (long) (b2.T() * 1000);
            this.d = b2.U() != 1 ? false : true;
        }
        if (this.d) {
            this.i = new AtomicInteger(0);
            this.j = new Stack<>();
            this.h = BatchReportDao.getInstance(com.mbridge.msdk.foundation.controller.a.e().g());
            HandlerThread handlerThread = new HandlerThread("mb_batch_report_thread");
            handlerThread.start();
            this.c = new Handler(handlerThread.getLooper()) {
                public final void handleMessage(Message message) {
                    Bundle data;
                    int i = message.what;
                    if (i == 1) {
                        Bundle data2 = message.getData();
                        if (a.this.c != null && a.this.h != null && data2 != null) {
                            a.this.c.removeMessages(2);
                            long currentTimeMillis = System.currentTimeMillis();
                            a.a(a.this, a.this.h.getBatchReportMessages(currentTimeMillis), currentTimeMillis);
                            a.this.i.set(0);
                        }
                    } else if (i == 2) {
                        Bundle data3 = message.getData();
                        if (a.this.c != null && a.this.h != null && data3 != null) {
                            a.this.c.removeMessages(1);
                            long j = data3.getLong("last_report_time");
                            a.a(a.this, a.this.h.getBatchReportMessages(j), j);
                        }
                    } else if (i == 3 && (data = message.getData()) != null) {
                        a.b(a.this, data.getParcelableArrayList("report_message"), data.getLong("last_report_time"));
                    }
                }
            };
        }
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    public final void b() {
        Handler handler;
        if (this.d && (handler = this.c) != null && !handler.hasMessages(1)) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.c.sendMessageDelayed(obtain, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        }
    }

    public final synchronized boolean c() {
        return this.d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0063, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0065, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.mbridge.msdk.foundation.db.BatchReportDao r0 = r4.h     // Catch:{ all -> 0x0066 }
            if (r0 == 0) goto L_0x0064
            boolean r0 = r4.d     // Catch:{ all -> 0x0066 }
            if (r0 != 0) goto L_0x000a
            goto L_0x0064
        L_0x000a:
            com.mbridge.msdk.foundation.db.BatchReportDao r0 = r4.h     // Catch:{ all -> 0x0066 }
            r0.addReportMessage(r5)     // Catch:{ all -> 0x0066 }
            android.os.Handler r5 = r4.c     // Catch:{ all -> 0x0066 }
            if (r5 == 0) goto L_0x0031
            long r0 = r4.f     // Catch:{ all -> 0x0066 }
            r2 = 0
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x0031
            android.os.Handler r5 = r4.c     // Catch:{ all -> 0x0066 }
            r0 = 1
            boolean r5 = r5.hasMessages(r0)     // Catch:{ all -> 0x0066 }
            if (r5 != 0) goto L_0x0031
            android.os.Message r5 = android.os.Message.obtain()     // Catch:{ all -> 0x0066 }
            r5.what = r0     // Catch:{ all -> 0x0066 }
            android.os.Handler r0 = r4.c     // Catch:{ all -> 0x0066 }
            long r1 = r4.f     // Catch:{ all -> 0x0066 }
            r0.sendMessageDelayed(r5, r1)     // Catch:{ all -> 0x0066 }
        L_0x0031:
            java.util.concurrent.atomic.AtomicInteger r5 = r4.i     // Catch:{ all -> 0x0066 }
            int r5 = r5.incrementAndGet()     // Catch:{ all -> 0x0066 }
            int r0 = r4.e     // Catch:{ all -> 0x0066 }
            if (r5 < r0) goto L_0x0062
            android.os.Handler r5 = r4.c     // Catch:{ all -> 0x0066 }
            if (r5 == 0) goto L_0x0062
            android.os.Message r5 = android.os.Message.obtain()     // Catch:{ all -> 0x0066 }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x0066 }
            r0.<init>()     // Catch:{ all -> 0x0066 }
            java.lang.String r1 = "last_report_time"
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0066 }
            r0.putLong(r1, r2)     // Catch:{ all -> 0x0066 }
            r5.setData(r0)     // Catch:{ all -> 0x0066 }
            r0 = 2
            r5.what = r0     // Catch:{ all -> 0x0066 }
            android.os.Handler r0 = r4.c     // Catch:{ all -> 0x0066 }
            r0.sendMessage(r5)     // Catch:{ all -> 0x0066 }
            java.util.concurrent.atomic.AtomicInteger r5 = r4.i     // Catch:{ all -> 0x0066 }
            r0 = 0
            r5.set(r0)     // Catch:{ all -> 0x0066 }
        L_0x0062:
            monitor-exit(r4)
            return
        L_0x0064:
            monitor-exit(r4)
            return
        L_0x0066:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.report.a.a(java.lang.String):void");
    }

    static /* synthetic */ void a(a aVar, ArrayList arrayList, long j2) {
        if (arrayList != null && arrayList.size() > 0) {
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("report_message", arrayList);
            bundle.putLong("last_report_time", j2);
            obtain.setData(bundle);
            obtain.what = 3;
            aVar.c.sendMessage(obtain);
        }
    }

    static /* synthetic */ void b(a aVar, final ArrayList arrayList, final long j2) {
        Context g2;
        if (arrayList != null && arrayList.size() > 0 && (g2 = com.mbridge.msdk.foundation.controller.a.e().g()) != null) {
            com.mbridge.msdk.foundation.same.net.h.d a2 = d.a(g2);
            a2.a("app_id", com.mbridge.msdk.foundation.controller.a.e().h());
            a2.a("m_sdk", "msdk");
            a2.a("lqswt", String.valueOf(1));
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                BatchReportMessage batchReportMessage = (BatchReportMessage) arrayList.get(i2);
                if (batchReportMessage != null) {
                    sb.append(batchReportMessage.getReportMessage() + "&ts=" + batchReportMessage.getTimestamp());
                    if (i2 >= 0 && i2 < arrayList.size() - 1) {
                        sb.append("\n");
                    }
                }
            }
            try {
                a2.a(DataSchemeDataSource.SCHEME_DATA, URLEncoder.encode(sb.toString(), "utf-8"));
                new com.mbridge.msdk.foundation.same.report.d.a(com.mbridge.msdk.foundation.controller.a.e().g()).c(0, aVar.g, a2, new com.mbridge.msdk.foundation.same.report.d.b() {
                    public final void a(String str) {
                        try {
                            if (a.this.h != null) {
                                a.this.h.deleteBatchReportMessagesByTimestamp(j2);
                            }
                        } catch (Exception e) {
                            q.d(a.a, e.getMessage());
                        }
                        synchronized (a.this.j) {
                            a.this.j.clear();
                        }
                    }

                    public final void b(String str) {
                        Stack d;
                        synchronized (a.this.j) {
                            a.this.j.add(Long.valueOf(j2));
                            if (a.this.h != null) {
                                a.this.h.updateMessagesReportState(arrayList);
                            }
                            if (a.this.j.size() >= 5) {
                                try {
                                    a.this.j.pop();
                                    long longValue = ((Long) a.this.j.pop()).longValue();
                                    a.this.j.clear();
                                    if (a.this.h != null) {
                                        a.this.h.deleteBatchReportMessagesByTimestamp(longValue);
                                    }
                                    d = a.this.j;
                                } catch (Exception e) {
                                    try {
                                        q.d(a.a, e.getMessage());
                                        d = a.this.j;
                                    } catch (Throwable th) {
                                        a.this.j.clear();
                                        throw th;
                                    }
                                }
                                d.clear();
                            }
                        }
                    }
                });
            } catch (Exception e2) {
                q.d(a, e2.getMessage());
            }
        }
    }
}
