package com.huawei.android.pushselfshow.utils.b;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.utils.a;
import java.io.File;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;

public class b {
    public Handler a;
    public Context b;
    public String c;
    public String d;
    public boolean e;
    private boolean f;
    private Runnable g;

    public b() {
        this.a = null;
        this.e = false;
        this.g = new c(this);
        this.f = false;
    }

    public b(Handler handler, Context context, String str, String str2) {
        this.a = null;
        this.e = false;
        this.g = new c(this);
        this.a = handler;
        this.b = context;
        this.c = str;
        this.d = str2;
        this.f = false;
    }

    public static String a(Context context) {
        return b(context) + File.separator + "richpush";
    }

    public static void a(HttpClient httpClient) {
        if (httpClient != null) {
            try {
                httpClient.getConnectionManager().shutdown();
            } catch (Exception e2) {
                e.c("PushSelfShowLog", "close input stream failed." + e2.getMessage(), e2);
            }
        }
    }

    public static void a(HttpRequestBase httpRequestBase) {
        if (httpRequestBase != null) {
            try {
                httpRequestBase.abort();
            } catch (Exception e2) {
                e.c("PushSelfShowLog", "close input stream failed." + e2.getMessage(), e2);
            }
        }
    }

    public static String b(Context context) {
        String str;
        try {
            str = (!Environment.getExternalStorageState().equals("mounted") ? context.getFilesDir() : Environment.getExternalStorageDirectory()).getPath();
        } catch (Exception e2) {
            e.c("PushSelfShowLog", "getLocalFileHeader failed ", e2);
            str = "";
        }
        String str2 = str + File.separator + "PushService";
        e.a("PushSelfShowLog", "getFileHeader:" + str2);
        return str2;
    }

    public static String c(Context context) {
        String str;
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                return null;
            }
            str = Environment.getExternalStorageDirectory().getPath();
            return str + File.separator + "PushService";
        } catch (Exception e2) {
            e.c("PushSelfShowLog", "getLocalFileHeader failed ", e2);
            str = "";
        }
    }

    public String a(Context context, String str, String str2) {
        try {
            String str3 = "" + System.currentTimeMillis();
            String str4 = str3 + str2;
            String str5 = a(context) + File.separator + str3;
            String str6 = str5 + File.separator + str4;
            File file = new File(str5);
            if (!file.exists()) {
                e.a("PushSelfShowLog", "dir is not exists()," + file.getAbsolutePath());
            } else {
                a.a(file);
            }
            if (file.mkdirs()) {
                e.a("PushSelfShowLog", "dir.mkdirs() success  ");
            }
            e.a("PushSelfShowLog", "begin to download zip file, path is " + str6 + ",dir is " + file.getAbsolutePath());
            if (b(context, str, str6)) {
                return str6;
            }
            e.a("PushSelfShowLog", "download richpush file failed，clear temp file");
            if (!file.exists()) {
                return null;
            }
            a.a(file);
            return null;
        } catch (Exception e2) {
            e.a("PushSelfShowLog", "download err" + e2.toString());
            return null;
        }
    }

    public void a() {
        this.f = true;
    }

    public void a(String str) {
        Message message = new Message();
        message.what = 1;
        message.obj = str;
        e.a("PushSelfShowLog", "mDownloadHandler = " + this.a);
        Handler handler = this.a;
        if (handler != null) {
            handler.sendMessageDelayed(message, 1);
        }
    }

    public void b() {
        new Thread(this.g).start();
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01ee A[SYNTHETIC, Splitter:B:100:0x01ee] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x020b A[SYNTHETIC, Splitter:B:105:0x020b] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0236 A[SYNTHETIC, Splitter:B:116:0x0236] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0253 A[SYNTHETIC, Splitter:B:121:0x0253] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0270 A[SYNTHETIC, Splitter:B:126:0x0270] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01d1 A[SYNTHETIC, Splitter:B:95:0x01d1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(android.content.Context r12, java.lang.String r13, java.lang.String r14) {
        /*
            r11 = this;
            java.lang.String r0 = "out download  error"
            java.lang.String r1 = " bis download  error"
            java.lang.String r2 = " bos download  error"
            java.lang.String r3 = "PushSelfShowLog"
            r4 = 0
            r5 = 0
            org.apache.http.impl.client.DefaultHttpClient r6 = new org.apache.http.impl.client.DefaultHttpClient     // Catch:{ IOException -> 0x01ac, all -> 0x01a5 }
            r6.<init>()     // Catch:{ IOException -> 0x01ac, all -> 0x01a5 }
            org.apache.http.client.methods.HttpGet r7 = new org.apache.http.client.methods.HttpGet     // Catch:{ IOException -> 0x01a0, all -> 0x019a }
            r7.<init>(r13)     // Catch:{ IOException -> 0x01a0, all -> 0x019a }
            com.huawei.android.pushselfshow.utils.b.d r8 = new com.huawei.android.pushselfshow.utils.b.d     // Catch:{ IOException -> 0x0195, all -> 0x0190 }
            r8.<init>(r12)     // Catch:{ IOException -> 0x0195, all -> 0x0190 }
            org.apache.http.HttpResponse r12 = r8.a((java.lang.String) r13, (org.apache.http.client.HttpClient) r6, (org.apache.http.client.methods.HttpGet) r7)     // Catch:{ IOException -> 0x0195, all -> 0x0190 }
            if (r12 != 0) goto L_0x002b
            java.lang.String r12 = "fail, httprespone  is null"
            com.huawei.android.pushagent.c.a.e.a(r3, r12)     // Catch:{ IOException -> 0x0195, all -> 0x0190 }
            a((org.apache.http.client.methods.HttpRequestBase) r7)
            a((org.apache.http.client.HttpClient) r6)
            return r5
        L_0x002b:
            org.apache.http.StatusLine r13 = r12.getStatusLine()     // Catch:{ IOException -> 0x0195, all -> 0x0190 }
            if (r13 == 0) goto L_0x0060
            org.apache.http.StatusLine r13 = r12.getStatusLine()     // Catch:{ IOException -> 0x0195, all -> 0x0190 }
            int r13 = r13.getStatusCode()     // Catch:{ IOException -> 0x0195, all -> 0x0190 }
            r8 = 200(0xc8, float:2.8E-43)
            if (r13 == r8) goto L_0x0060
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0195, all -> 0x0190 }
            r13.<init>()     // Catch:{ IOException -> 0x0195, all -> 0x0190 }
            java.lang.String r14 = "fail, httprespone status is "
            r13.append(r14)     // Catch:{ IOException -> 0x0195, all -> 0x0190 }
            org.apache.http.StatusLine r12 = r12.getStatusLine()     // Catch:{ IOException -> 0x0195, all -> 0x0190 }
            int r12 = r12.getStatusCode()     // Catch:{ IOException -> 0x0195, all -> 0x0190 }
            r13.append(r12)     // Catch:{ IOException -> 0x0195, all -> 0x0190 }
            java.lang.String r12 = r13.toString()     // Catch:{ IOException -> 0x0195, all -> 0x0190 }
            com.huawei.android.pushagent.c.a.e.a(r3, r12)     // Catch:{ IOException -> 0x0195, all -> 0x0190 }
            a((org.apache.http.client.methods.HttpRequestBase) r7)
            a((org.apache.http.client.HttpClient) r6)
            return r5
        L_0x0060:
            java.io.BufferedInputStream r13 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0195, all -> 0x0190 }
            org.apache.http.HttpEntity r12 = r12.getEntity()     // Catch:{ IOException -> 0x0195, all -> 0x0190 }
            java.io.InputStream r12 = r12.getContent()     // Catch:{ IOException -> 0x0195, all -> 0x0190 }
            r13.<init>(r12)     // Catch:{ IOException -> 0x0195, all -> 0x0190 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x018d, all -> 0x0189 }
            r12.<init>()     // Catch:{ IOException -> 0x018d, all -> 0x0189 }
            java.lang.String r8 = "begin to write content to "
            r12.append(r8)     // Catch:{ IOException -> 0x018d, all -> 0x0189 }
            r12.append(r14)     // Catch:{ IOException -> 0x018d, all -> 0x0189 }
            java.lang.String r12 = r12.toString()     // Catch:{ IOException -> 0x018d, all -> 0x0189 }
            com.huawei.android.pushagent.c.a.e.a(r3, r12)     // Catch:{ IOException -> 0x018d, all -> 0x0189 }
            java.io.File r12 = new java.io.File     // Catch:{ IOException -> 0x018d, all -> 0x0189 }
            r12.<init>(r14)     // Catch:{ IOException -> 0x018d, all -> 0x0189 }
            boolean r12 = r12.exists()     // Catch:{ IOException -> 0x018d, all -> 0x0189 }
            if (r12 == 0) goto L_0x00a9
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x018d, all -> 0x0189 }
            r12.<init>()     // Catch:{ IOException -> 0x018d, all -> 0x0189 }
            java.lang.String r8 = "file delete "
            r12.append(r8)     // Catch:{ IOException -> 0x018d, all -> 0x0189 }
            java.io.File r8 = new java.io.File     // Catch:{ IOException -> 0x018d, all -> 0x0189 }
            r8.<init>(r14)     // Catch:{ IOException -> 0x018d, all -> 0x0189 }
            boolean r8 = r8.delete()     // Catch:{ IOException -> 0x018d, all -> 0x0189 }
            r12.append(r8)     // Catch:{ IOException -> 0x018d, all -> 0x0189 }
            java.lang.String r12 = r12.toString()     // Catch:{ IOException -> 0x018d, all -> 0x0189 }
            com.huawei.android.pushagent.c.a.e.a(r3, r12)     // Catch:{ IOException -> 0x018d, all -> 0x0189 }
        L_0x00a9:
            java.io.FileOutputStream r12 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x018d, all -> 0x0189 }
            r12.<init>(r14)     // Catch:{ IOException -> 0x018d, all -> 0x0189 }
            java.io.BufferedOutputStream r14 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0182, all -> 0x017c }
            r14.<init>(r12)     // Catch:{ IOException -> 0x0182, all -> 0x017c }
            r4 = 32768(0x8000, float:4.5918E-41)
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x0177, all -> 0x0170 }
        L_0x00b8:
            int r8 = r13.read(r4)     // Catch:{ IOException -> 0x0177, all -> 0x0170 }
            r9 = 1
            if (r8 >= 0) goto L_0x011e
            java.lang.String r4 = "downLoad success "
            com.huawei.android.pushagent.c.a.e.a(r3, r4)     // Catch:{ IOException -> 0x0177, all -> 0x0170 }
            r11.e = r5     // Catch:{ IOException -> 0x0177, all -> 0x0170 }
            a((org.apache.http.client.methods.HttpRequestBase) r7)
            a((org.apache.http.client.HttpClient) r6)
            r14.close()     // Catch:{ IOException -> 0x00d0 }
            goto L_0x00e7
        L_0x00d0:
            r14 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.String r2 = r14.toString()
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            com.huawei.android.pushagent.c.a.e.c(r3, r2, r14)
        L_0x00e7:
            r13.close()     // Catch:{ IOException -> 0x00eb }
            goto L_0x0102
        L_0x00eb:
            r13 = move-exception
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r1)
            java.lang.String r1 = r13.toString()
            r14.append(r1)
            java.lang.String r14 = r14.toString()
            com.huawei.android.pushagent.c.a.e.c(r3, r14, r13)
        L_0x0102:
            r12.close()     // Catch:{ Exception -> 0x0106 }
            goto L_0x011d
        L_0x0106:
            r12 = move-exception
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r0)
            java.lang.String r14 = r12.toString()
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            com.huawei.android.pushagent.c.a.e.c(r3, r13, r12)
        L_0x011d:
            return r9
        L_0x011e:
            r11.e = r9     // Catch:{ IOException -> 0x0177, all -> 0x0170 }
            r14.write(r4, r5, r8)     // Catch:{ IOException -> 0x0177, all -> 0x0170 }
            boolean r8 = r11.f     // Catch:{ IOException -> 0x0177, all -> 0x0170 }
            if (r8 == 0) goto L_0x00b8
            a((org.apache.http.client.methods.HttpRequestBase) r7)
            a((org.apache.http.client.HttpClient) r6)
            r14.close()     // Catch:{ IOException -> 0x0131 }
            goto L_0x0148
        L_0x0131:
            r14 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.String r2 = r14.toString()
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            com.huawei.android.pushagent.c.a.e.c(r3, r2, r14)
        L_0x0148:
            r13.close()     // Catch:{ IOException -> 0x014c }
            goto L_0x0163
        L_0x014c:
            r13 = move-exception
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r1)
            java.lang.String r1 = r13.toString()
            r14.append(r1)
            java.lang.String r14 = r14.toString()
            com.huawei.android.pushagent.c.a.e.c(r3, r14, r13)
        L_0x0163:
            r12.close()     // Catch:{ Exception -> 0x0168 }
            goto L_0x0226
        L_0x0168:
            r12 = move-exception
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            goto L_0x0215
        L_0x0170:
            r4 = move-exception
            r10 = r14
            r14 = r12
            r12 = r4
            r4 = r10
            goto L_0x022e
        L_0x0177:
            r4 = move-exception
            r10 = r7
            r7 = r12
            r12 = r4
            goto L_0x0187
        L_0x017c:
            r14 = move-exception
            r10 = r14
            r14 = r12
            r12 = r10
            goto L_0x022e
        L_0x0182:
            r14 = move-exception
            r10 = r7
            r7 = r12
            r12 = r14
            r14 = r4
        L_0x0187:
            r4 = r10
            goto L_0x01b1
        L_0x0189:
            r12 = move-exception
            r14 = r4
            goto L_0x022e
        L_0x018d:
            r12 = move-exception
            r14 = r4
            goto L_0x0198
        L_0x0190:
            r12 = move-exception
            r13 = r4
            r14 = r13
            goto L_0x022e
        L_0x0195:
            r12 = move-exception
            r13 = r4
            r14 = r13
        L_0x0198:
            r4 = r7
            goto L_0x01a3
        L_0x019a:
            r12 = move-exception
            r13 = r4
            r14 = r13
            r7 = r14
            goto L_0x022e
        L_0x01a0:
            r12 = move-exception
            r13 = r4
            r14 = r13
        L_0x01a3:
            r7 = r14
            goto L_0x01b1
        L_0x01a5:
            r12 = move-exception
            r13 = r4
            r14 = r13
            r6 = r14
            r7 = r6
            goto L_0x022e
        L_0x01ac:
            r12 = move-exception
            r13 = r4
            r14 = r13
            r6 = r14
            r7 = r6
        L_0x01b1:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0229 }
            r8.<init>()     // Catch:{ all -> 0x0229 }
            java.lang.String r9 = "downLoadSgThread download  error"
            r8.append(r9)     // Catch:{ all -> 0x0229 }
            java.lang.String r9 = r12.toString()     // Catch:{ all -> 0x0229 }
            r8.append(r9)     // Catch:{ all -> 0x0229 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0229 }
            com.huawei.android.pushagent.c.a.e.c(r3, r8, r12)     // Catch:{ all -> 0x0229 }
            a((org.apache.http.client.methods.HttpRequestBase) r4)
            a((org.apache.http.client.HttpClient) r6)
            if (r14 == 0) goto L_0x01ec
            r14.close()     // Catch:{ IOException -> 0x01d5 }
            goto L_0x01ec
        L_0x01d5:
            r12 = move-exception
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r2)
            java.lang.String r2 = r12.toString()
            r14.append(r2)
            java.lang.String r14 = r14.toString()
            com.huawei.android.pushagent.c.a.e.c(r3, r14, r12)
        L_0x01ec:
            if (r13 == 0) goto L_0x0209
            r13.close()     // Catch:{ IOException -> 0x01f2 }
            goto L_0x0209
        L_0x01f2:
            r12 = move-exception
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r1)
            java.lang.String r14 = r12.toString()
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            com.huawei.android.pushagent.c.a.e.c(r3, r13, r12)
        L_0x0209:
            if (r7 == 0) goto L_0x0226
            r7.close()     // Catch:{ Exception -> 0x020f }
            goto L_0x0226
        L_0x020f:
            r12 = move-exception
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
        L_0x0215:
            r13.append(r0)
            java.lang.String r14 = r12.toString()
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            com.huawei.android.pushagent.c.a.e.c(r3, r13, r12)
        L_0x0226:
            r11.e = r5
            return r5
        L_0x0229:
            r12 = move-exception
            r10 = r4
            r4 = r14
            r14 = r7
            r7 = r10
        L_0x022e:
            a((org.apache.http.client.methods.HttpRequestBase) r7)
            a((org.apache.http.client.HttpClient) r6)
            if (r4 == 0) goto L_0x0251
            r4.close()     // Catch:{ IOException -> 0x023a }
            goto L_0x0251
        L_0x023a:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r2)
            java.lang.String r2 = r4.toString()
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            com.huawei.android.pushagent.c.a.e.c(r3, r2, r4)
        L_0x0251:
            if (r13 == 0) goto L_0x026e
            r13.close()     // Catch:{ IOException -> 0x0257 }
            goto L_0x026e
        L_0x0257:
            r13 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = r13.toString()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.huawei.android.pushagent.c.a.e.c(r3, r1, r13)
        L_0x026e:
            if (r14 == 0) goto L_0x028b
            r14.close()     // Catch:{ Exception -> 0x0274 }
            goto L_0x028b
        L_0x0274:
            r13 = move-exception
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r0)
            java.lang.String r0 = r13.toString()
            r14.append(r0)
            java.lang.String r14 = r14.toString()
            com.huawei.android.pushagent.c.a.e.c(r3, r14, r13)
        L_0x028b:
            goto L_0x028d
        L_0x028c:
            throw r12
        L_0x028d:
            goto L_0x028c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.utils.b.b.b(android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    public void c() {
        Message message = new Message();
        message.what = 2;
        e.a("PushSelfShowLog", "mDownloadHandler = " + this.a);
        Handler handler = this.a;
        if (handler != null) {
            handler.sendMessageDelayed(message, 1);
        }
    }
}
