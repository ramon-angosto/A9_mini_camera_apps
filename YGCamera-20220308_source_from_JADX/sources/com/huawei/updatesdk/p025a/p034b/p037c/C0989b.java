package com.huawei.updatesdk.p025a.p034b.p037c;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.huawei.updatesdk.p025a.p026a.C0964a;
import com.huawei.updatesdk.p025a.p026a.p027b.C0966b;
import com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a;
import com.huawei.updatesdk.p025a.p026a.p031d.C0975g;
import com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0990a;
import com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0993c;
import com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0994d;
import com.huawei.updatesdk.p039b.p048g.C1032a;
import com.huawei.updatesdk.p039b.p048g.C1033b;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.Executor;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONObject;

/* renamed from: com.huawei.updatesdk.a.b.c.b */
public class C0989b extends AsyncTask<C0993c, Void, C0994d> {

    /* renamed from: a */
    protected C0993c f1331a = null;

    /* renamed from: b */
    private C0994d f1332b = null;

    /* renamed from: c */
    private C0990a f1333c = null;

    /* renamed from: d */
    private C0966b f1334d = null;

    /* renamed from: e */
    private int f1335e = 0;

    public C0989b(C0993c cVar, C0990a aVar) {
        this.f1331a = cVar;
        this.f1333c = aVar;
    }

    /* renamed from: a */
    private C0994d m1771a(String str, C0994d dVar) {
        try {
            dVar.fromJson(new JSONObject(str));
            dVar.mo14932b(0);
        } catch (Exception e) {
            C0968a.m1681a("StoreTask", "parse json error", e);
        }
        return dVar;
    }

    /* renamed from: a */
    private void m1772a(C0994d dVar, int i, C0994d.C0995a aVar, Throwable th) {
        if (dVar != null) {
            dVar.mo14932b(i);
            dVar.mo14929a(aVar);
            dVar.mo14930a(th.toString());
        }
    }

    /* renamed from: a */
    private void m1773a(C0994d dVar, Throwable th, String str) {
        C0994d.C0995a aVar;
        int i = 1;
        if (th instanceof ConnectException) {
            aVar = C0994d.C0995a.CONNECT_EXCEPTION;
        } else if ((th instanceof SocketTimeoutException) || (th instanceof ConnectTimeoutException)) {
            aVar = C0994d.C0995a.CONNECT_EXCEPTION;
            i = 2;
        } else if (th instanceof IllegalArgumentException) {
            aVar = C0994d.C0995a.PARAM_ERROR;
            i = 5;
        } else if (th instanceof IllegalAccessException) {
            aVar = C0994d.C0995a.UNKNOWN_EXCEPTION;
        } else if (th instanceof ArrayIndexOutOfBoundsException) {
            aVar = C0994d.C0995a.NO_PROGUARD;
            i = 6;
        } else if ((th instanceof InterruptedException) || (th instanceof InterruptedIOException)) {
            m1772a(dVar, 0, C0994d.C0995a.NORMAL, th);
            C0964a.m1666a("StoreTask", "UpdateSDK task is canceled");
            m1774a(str, th);
        } else if (th instanceof IOException) {
            aVar = C0994d.C0995a.IO_EXCEPTION;
        } else {
            if (dVar != null) {
                dVar.mo14930a(th.toString());
            }
            m1774a(str, th);
        }
        m1772a(dVar, i, aVar, th);
        m1774a(str, th);
    }

    /* renamed from: a */
    private void m1774a(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("invoke store error");
        sb.append(", exceptionType:");
        sb.append(th.getClass().getName());
        sb.append(", url:");
        sb.append(str);
        sb.append(", method:");
        sb.append(this.f1331a.mo14922b());
        sb.append(", retryTimes:" + this.f1335e);
        String sb2 = sb.toString();
        C0968a.m1681a("StoreTask", sb2, th);
        C0964a.m1666a("StoreTask", "UpdateSDK call store error: " + sb2);
    }

    /* renamed from: a */
    private boolean m1775a(String str) {
        return TextUtils.isEmpty(str) || !C0975g.m1706d(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1776b(com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0994d r5) {
        /*
            r4 = this;
            java.lang.String r0 = "notifyResult, create response error, method:"
            boolean r1 = r4.isCancelled()
            if (r1 != 0) goto L_0x005a
            com.huawei.updatesdk.a.b.c.c.a r1 = r4.f1333c
            if (r1 == 0) goto L_0x005a
            if (r5 != 0) goto L_0x0053
            java.lang.String r1 = "StoreTask"
            java.lang.String r2 = "notifyResult, response is null"
            com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a.m1682b(r1, r2)
            com.huawei.updatesdk.a.b.c.c.c r2 = r4.f1331a     // Catch:{ InstantiationException -> 0x0027, IllegalAccessException -> 0x0020 }
            java.lang.String r2 = r2.mo14922b()     // Catch:{ InstantiationException -> 0x0027, IllegalAccessException -> 0x0020 }
            com.huawei.updatesdk.a.b.c.c.d r5 = com.huawei.updatesdk.p025a.p034b.p037c.C0988a.m1770a(r2)     // Catch:{ InstantiationException -> 0x0027, IllegalAccessException -> 0x0020 }
            goto L_0x0040
        L_0x0020:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x002d
        L_0x0027:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
        L_0x002d:
            r3.append(r0)
            com.huawei.updatesdk.a.b.c.c.c r0 = r4.f1331a
            java.lang.String r0 = r0.mo14922b()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a.m1681a(r1, r0, r2)
        L_0x0040:
            if (r5 != 0) goto L_0x004a
            com.huawei.updatesdk.a.b.c.c.d r5 = new com.huawei.updatesdk.a.b.c.c.d
            r5.<init>()
            com.huawei.updatesdk.a.b.c.c.d$a r0 = com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0994d.C0995a.PARAM_ERROR
            goto L_0x004c
        L_0x004a:
            com.huawei.updatesdk.a.b.c.c.d$a r0 = com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0994d.C0995a.UNKNOWN_EXCEPTION
        L_0x004c:
            r5.mo14929a((com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0994d.C0995a) r0)
            r0 = 1
            r5.mo14932b(r0)
        L_0x0053:
            com.huawei.updatesdk.a.b.c.c.a r0 = r4.f1333c
            com.huawei.updatesdk.a.b.c.c.c r1 = r4.f1331a
            r0.mo14913b(r1, r5)
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.updatesdk.p025a.p034b.p037c.C0989b.m1776b(com.huawei.updatesdk.a.b.c.c.d):void");
    }

    /* renamed from: b */
    private void m1777b(String str) {
        C0964a.m1666a("StoreTask", TextUtils.isEmpty(str) ? "UpdateSDK response error, resData == null" : "UpdateSDK response error, resData is not json string");
    }

    /* renamed from: c */
    private boolean m1778c(C0994d dVar) {
        if (isCancelled()) {
            return false;
        }
        if (dVar.mo14934d() != 1 && dVar.mo14934d() != 2) {
            return false;
        }
        int i = this.f1335e;
        this.f1335e = i + 1;
        if (i >= 3) {
            C0968a.m1680a("StoreTask", "retry completed total times = " + this.f1335e + ",response.responseCode = " + dVar.mo14934d());
            return false;
        }
        C0968a.m1680a("StoreTask", "retry times = " + this.f1335e + ",response.responseCode = " + dVar.mo14934d());
        return true;
    }

    /* renamed from: d */
    private String m1779d() {
        String a = C1032a.m1944a();
        return TextUtils.isEmpty(a) ? "Android/1.0" : a;
    }

    /* renamed from: e */
    private void m1780e() {
        m1776b(this.f1332b);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0994d mo14904a() {
        /*
            r13 = this;
            java.lang.String r0 = ", body:"
            java.lang.String r1 = ", url:"
            java.lang.String r2 = "StoreTask"
            r3 = 5
            r4 = 0
            com.huawei.updatesdk.a.b.c.c.c r5 = r13.f1331a     // Catch:{ all -> 0x00f6 }
            java.lang.String r5 = r5.mo14922b()     // Catch:{ all -> 0x00f6 }
            com.huawei.updatesdk.a.b.c.c.d r5 = com.huawei.updatesdk.p025a.p034b.p037c.C0988a.m1770a(r5)     // Catch:{ all -> 0x00f6 }
            com.huawei.updatesdk.a.b.a.a r6 = com.huawei.updatesdk.p025a.p034b.p035a.C0985a.m1757c()     // Catch:{ all -> 0x00f4 }
            android.content.Context r6 = r6.mo14892a()     // Catch:{ all -> 0x00f4 }
            boolean r6 = com.huawei.updatesdk.p025a.p026a.p031d.p033i.C0984a.m1755d(r6)     // Catch:{ all -> 0x00f4 }
            if (r6 != 0) goto L_0x002b
            r0 = 3
            r5.mo14932b(r0)     // Catch:{ all -> 0x00f4 }
            com.huawei.updatesdk.a.b.c.c.d$a r0 = com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0994d.C0995a.NO_NETWORK     // Catch:{ all -> 0x00f4 }
            r5.mo14929a((com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0994d.C0995a) r0)     // Catch:{ all -> 0x00f4 }
            goto L_0x00fb
        L_0x002b:
            com.huawei.updatesdk.a.b.c.c.c r6 = r13.f1331a     // Catch:{ all -> 0x00f4 }
            java.lang.String r6 = r6.mo14920a()     // Catch:{ all -> 0x00f4 }
            com.huawei.updatesdk.a.b.c.c.c r7 = r13.f1331a     // Catch:{ all -> 0x00f4 }
            java.lang.String r4 = r7.mo14925d()     // Catch:{ all -> 0x00f4 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f4 }
            r7.<init>()     // Catch:{ all -> 0x00f4 }
            java.lang.String r8 = "callStore, method:"
            r7.append(r8)     // Catch:{ all -> 0x00f4 }
            com.huawei.updatesdk.a.b.c.c.c r8 = r13.f1331a     // Catch:{ all -> 0x00f4 }
            java.lang.String r8 = r8.mo14922b()     // Catch:{ all -> 0x00f4 }
            r7.append(r8)     // Catch:{ all -> 0x00f4 }
            r7.append(r1)     // Catch:{ all -> 0x00f4 }
            r7.append(r4)     // Catch:{ all -> 0x00f4 }
            r7.append(r0)     // Catch:{ all -> 0x00f4 }
            r7.append(r6)     // Catch:{ all -> 0x00f4 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00f4 }
            com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a.m1680a(r2, r7)     // Catch:{ all -> 0x00f4 }
            com.huawei.updatesdk.a.a.b.b r7 = new com.huawei.updatesdk.a.a.b.b     // Catch:{ all -> 0x00f4 }
            r7.<init>()     // Catch:{ all -> 0x00f4 }
            r13.f1334d = r7     // Catch:{ all -> 0x00f4 }
            com.huawei.updatesdk.a.a.b.b r7 = r13.f1334d     // Catch:{ all -> 0x00f4 }
            java.lang.String r10 = "UTF-8"
            java.lang.String r11 = r13.m1779d()     // Catch:{ all -> 0x00f4 }
            com.huawei.updatesdk.a.b.a.a r8 = com.huawei.updatesdk.p025a.p034b.p035a.C0985a.m1757c()     // Catch:{ all -> 0x00f4 }
            android.content.Context r12 = r8.mo14892a()     // Catch:{ all -> 0x00f4 }
            r8 = r4
            r9 = r6
            com.huawei.updatesdk.a.a.b.b$a r7 = r7.mo14879a(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x00f4 }
            java.lang.String r8 = r7.mo14882b()     // Catch:{ all -> 0x00f4 }
            int r9 = r7.mo14881a()     // Catch:{ all -> 0x00f4 }
            r5.mo14928a((int) r9)     // Catch:{ all -> 0x00f4 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f4 }
            r9.<init>()     // Catch:{ all -> 0x00f4 }
            java.lang.String r10 = "UpdateSDK call store responsecode: "
            r9.append(r10)     // Catch:{ all -> 0x00f4 }
            int r10 = r5.mo14931b()     // Catch:{ all -> 0x00f4 }
            r9.append(r10)     // Catch:{ all -> 0x00f4 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00f4 }
            com.huawei.updatesdk.p025a.p026a.C0964a.m1667b(r2, r9)     // Catch:{ all -> 0x00f4 }
            int r7 = r7.mo14881a()     // Catch:{ all -> 0x00f4 }
            int r7 = r7 / 100
            if (r7 != r3) goto L_0x00aa
            r0 = 0
            r5.mo14932b(r0)     // Catch:{ all -> 0x00f4 }
            return r5
        L_0x00aa:
            boolean r7 = r13.m1775a((java.lang.String) r8)     // Catch:{ all -> 0x00f4 }
            if (r7 == 0) goto L_0x00bd
            r0 = 1
            r5.mo14932b(r0)     // Catch:{ all -> 0x00f4 }
            com.huawei.updatesdk.a.b.c.c.d$a r0 = com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0994d.C0995a.JSON_ERROR     // Catch:{ all -> 0x00f4 }
            r5.mo14929a((com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0994d.C0995a) r0)     // Catch:{ all -> 0x00f4 }
            r13.m1777b((java.lang.String) r8)     // Catch:{ all -> 0x00f4 }
            goto L_0x00fb
        L_0x00bd:
            com.huawei.updatesdk.a.b.c.c.d r5 = r13.m1771a((java.lang.String) r8, (com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0994d) r5)     // Catch:{ all -> 0x00f4 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f4 }
            r7.<init>()     // Catch:{ all -> 0x00f4 }
            java.lang.String r8 = "callStore response, method:"
            r7.append(r8)     // Catch:{ all -> 0x00f4 }
            com.huawei.updatesdk.a.b.c.c.c r8 = r13.f1331a     // Catch:{ all -> 0x00f4 }
            java.lang.String r8 = r8.mo14922b()     // Catch:{ all -> 0x00f4 }
            r7.append(r8)     // Catch:{ all -> 0x00f4 }
            r7.append(r1)     // Catch:{ all -> 0x00f4 }
            r7.append(r4)     // Catch:{ all -> 0x00f4 }
            r7.append(r0)     // Catch:{ all -> 0x00f4 }
            r7.append(r6)     // Catch:{ all -> 0x00f4 }
            java.lang.String r0 = ", Receive Json msg:"
            r7.append(r0)     // Catch:{ all -> 0x00f4 }
            java.lang.String r0 = r5.toJson()     // Catch:{ all -> 0x00f4 }
            r7.append(r0)     // Catch:{ all -> 0x00f4 }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00f4 }
            com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a.m1680a(r2, r0)     // Catch:{ all -> 0x00f4 }
            goto L_0x00fb
        L_0x00f4:
            r0 = move-exception
            goto L_0x00f8
        L_0x00f6:
            r0 = move-exception
            r5 = r4
        L_0x00f8:
            r13.m1773a(r5, r0, r4)
        L_0x00fb:
            if (r5 != 0) goto L_0x010a
            com.huawei.updatesdk.a.b.c.c.d r5 = new com.huawei.updatesdk.a.b.c.c.d
            r5.<init>()
            r5.mo14932b(r3)
            com.huawei.updatesdk.a.b.c.c.d$a r0 = com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0994d.C0995a.PARAM_ERROR
            r5.mo14929a((com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0994d.C0995a) r0)
        L_0x010a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.updatesdk.p025a.p034b.p037c.C0989b.mo14904a():com.huawei.updatesdk.a.b.c.c.d");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0994d doInBackground(C0993c... cVarArr) {
        C0968a.m1680a("StoreTask", "doInBackground, method:" + this.f1331a.mo14922b());
        C1033b.m1947a(this);
        C0994d c = mo14909c();
        C0990a aVar = this.f1333c;
        if (aVar != null) {
            aVar.mo14912a(this.f1331a, c);
        }
        return c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(C0994d dVar) {
        C0968a.m1680a("StoreTask", "onPostExecute, method:" + this.f1331a.mo14922b());
        C1033b.m1946a().remove(this);
        m1780e();
    }

    /* renamed from: a */
    public final void mo14907a(Executor executor) {
        executeOnExecutor(executor, new C0993c[]{this.f1331a});
    }

    /* renamed from: b */
    public void mo14908b() {
        C0966b bVar = this.f1334d;
        if (bVar != null) {
            bVar.mo14880a();
            this.f1334d = null;
        }
    }

    /* renamed from: c */
    public final C0994d mo14909c() {
        C0994d dVar = null;
        do {
            if (this.f1335e > 0 && dVar != null) {
                C0968a.m1680a("StoreTask", "call store error! responseCode:" + dVar.mo14934d() + ", retryTimes:" + this.f1335e);
            }
            dVar = mo14904a();
        } while (m1778c(dVar));
        this.f1332b = dVar;
        return this.f1332b;
    }
}
