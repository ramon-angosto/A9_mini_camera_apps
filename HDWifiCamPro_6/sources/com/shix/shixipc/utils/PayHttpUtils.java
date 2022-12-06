package com.shix.shixipc.utils;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PayHttpUtils {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public static final MediaType XML = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    OkHttpClient client = new OkHttpClient();

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0030, code lost:
        if (r4 != null) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0037, code lost:
        r0.addSuppressed(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002f, code lost:
        r1 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String postPay(java.lang.String r4) throws java.io.IOException {
        /*
            r3 = this;
            okhttp3.Request$Builder r0 = new okhttp3.Request$Builder
            r0.<init>()
            java.lang.String r1 = "Content-Type"
            java.lang.String r2 = "application/json"
            okhttp3.Request$Builder r0 = r0.addHeader(r1, r2)
            okhttp3.Request$Builder r4 = r0.url((java.lang.String) r4)
            okhttp3.Request r4 = r4.build()
            okhttp3.OkHttpClient r0 = r3.client
            okhttp3.Call r4 = r0.newCall(r4)
            okhttp3.Response r4 = r4.execute()
            okhttp3.ResponseBody r0 = r4.body()     // Catch:{ all -> 0x002d }
            java.lang.String r0 = r0.string()     // Catch:{ all -> 0x002d }
            if (r4 == 0) goto L_0x002c
            r4.close()
        L_0x002c:
            return r0
        L_0x002d:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x002f }
        L_0x002f:
            r1 = move-exception
            if (r4 == 0) goto L_0x003a
            r4.close()     // Catch:{ all -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r4 = move-exception
            r0.addSuppressed(r4)
        L_0x003a:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.utils.PayHttpUtils.postPay(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004f, code lost:
        if (r2 != null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0055, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0056, code lost:
        r3.addSuppressed(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0059, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004e, code lost:
        r4 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String post(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5) throws java.io.IOException {
        /*
            r1 = this;
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "url:"
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            r5 = 2
            com.shix.shixipc.utils.CommonUtil.Log(r5, r4)
            okhttp3.MediaType r4 = JSON
            okhttp3.RequestBody r3 = okhttp3.RequestBody.create((okhttp3.MediaType) r4, (java.lang.String) r3)
            okhttp3.Request$Builder r4 = new okhttp3.Request$Builder
            r4.<init>()
            java.lang.String r5 = "Content-Type"
            java.lang.String r0 = "application/json"
            okhttp3.Request$Builder r4 = r4.addHeader(r5, r0)
            okhttp3.Request$Builder r2 = r4.url((java.lang.String) r2)
            okhttp3.Request$Builder r2 = r2.post(r3)
            okhttp3.Request r2 = r2.build()
            okhttp3.OkHttpClient r3 = r1.client
            okhttp3.Call r2 = r3.newCall(r2)
            okhttp3.Response r2 = r2.execute()
            okhttp3.ResponseBody r3 = r2.body()     // Catch:{ all -> 0x004c }
            java.lang.String r3 = r3.string()     // Catch:{ all -> 0x004c }
            if (r2 == 0) goto L_0x004b
            r2.close()
        L_0x004b:
            return r3
        L_0x004c:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x004e }
        L_0x004e:
            r4 = move-exception
            if (r2 == 0) goto L_0x0059
            r2.close()     // Catch:{ all -> 0x0055 }
            goto L_0x0059
        L_0x0055:
            r2 = move-exception
            r3.addSuppressed(r2)
        L_0x0059:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.utils.PayHttpUtils.post(java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0040, code lost:
        if (r4 != null) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        r5.addSuppressed(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004a, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003f, code lost:
        r6 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String postA(java.lang.String r4, java.lang.String r5, java.lang.String r6) throws java.io.IOException {
        /*
            r3 = this;
            okhttp3.MediaType r0 = JSON
            okhttp3.RequestBody r5 = okhttp3.RequestBody.create((okhttp3.MediaType) r0, (java.lang.String) r5)
            okhttp3.Request$Builder r0 = new okhttp3.Request$Builder
            r0.<init>()
            java.lang.String r1 = "Content-Type"
            java.lang.String r2 = "application/json"
            okhttp3.Request$Builder r0 = r0.addHeader(r1, r2)
            java.lang.String r1 = "Authorization"
            okhttp3.Request$Builder r6 = r0.addHeader(r1, r6)
            okhttp3.Request$Builder r4 = r6.url((java.lang.String) r4)
            okhttp3.Request$Builder r4 = r4.post(r5)
            okhttp3.Request r4 = r4.build()
            okhttp3.OkHttpClient r5 = r3.client
            okhttp3.Call r4 = r5.newCall(r4)
            okhttp3.Response r4 = r4.execute()
            okhttp3.ResponseBody r5 = r4.body()     // Catch:{ all -> 0x003d }
            java.lang.String r5 = r5.string()     // Catch:{ all -> 0x003d }
            if (r4 == 0) goto L_0x003c
            r4.close()
        L_0x003c:
            return r5
        L_0x003d:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x003f }
        L_0x003f:
            r6 = move-exception
            if (r4 == 0) goto L_0x004a
            r4.close()     // Catch:{ all -> 0x0046 }
            goto L_0x004a
        L_0x0046:
            r4 = move-exception
            r5.addSuppressed(r4)
        L_0x004a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.utils.PayHttpUtils.postA(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003a, code lost:
        if (r4 != null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0041, code lost:
        r5.addSuppressed(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0039, code lost:
        r0 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String postWXPay(java.lang.String r4, java.lang.String r5) throws java.io.IOException {
        /*
            r3 = this;
            okhttp3.MediaType r0 = XML
            okhttp3.RequestBody r5 = okhttp3.RequestBody.create((okhttp3.MediaType) r0, (java.lang.String) r5)
            okhttp3.Request$Builder r0 = new okhttp3.Request$Builder
            r0.<init>()
            java.lang.String r1 = "Content-Type"
            java.lang.String r2 = "application/x-www-form-urlencoded"
            okhttp3.Request$Builder r0 = r0.addHeader(r1, r2)
            okhttp3.Request$Builder r4 = r0.url((java.lang.String) r4)
            okhttp3.Request$Builder r4 = r4.post(r5)
            okhttp3.Request r4 = r4.build()
            okhttp3.OkHttpClient r5 = r3.client
            okhttp3.Call r4 = r5.newCall(r4)
            okhttp3.Response r4 = r4.execute()
            okhttp3.ResponseBody r5 = r4.body()     // Catch:{ all -> 0x0037 }
            java.lang.String r5 = r5.string()     // Catch:{ all -> 0x0037 }
            if (r4 == 0) goto L_0x0036
            r4.close()
        L_0x0036:
            return r5
        L_0x0037:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0039 }
        L_0x0039:
            r0 = move-exception
            if (r4 == 0) goto L_0x0044
            r4.close()     // Catch:{ all -> 0x0040 }
            goto L_0x0044
        L_0x0040:
            r4 = move-exception
            r5.addSuppressed(r4)
        L_0x0044:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.utils.PayHttpUtils.postWXPay(java.lang.String, java.lang.String):java.lang.String");
    }

    public String get(String str) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request build = new Request.Builder().url(str).build();
        CommonUtil.Log(1, "request.method():" + build.method());
        try {
            Response execute = okHttpClient.newCall(build).execute();
            if (!execute.isSuccessful()) {
                return "null";
            }
            String string = execute.body().string();
            System.out.println(string);
            return string;
        } catch (IOException e) {
            e.printStackTrace();
            return e.toString();
        }
    }
}
