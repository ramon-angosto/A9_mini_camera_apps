package com.huawei.android.pushselfshow.richpush.tools;

import android.content.Context;

public class c {
    private String a;
    private Context b;

    public c(Context context, String str) {
        this.a = str;
        this.b = context;
    }

    private String b() {
        return "﻿<!DOCTYPE html>\t\t<html>\t\t   <head>\t\t     <meta charset=\"utf-8\">\t\t     <title></title>\t\t     <style type=\"text/css\">\t\t\t\t html { height:100%;}\t\t\t\t body { height:100%; text-align:center;}\t    \t    .centerDiv { display:inline-block; zoom:1; *display:inline; vertical-align:top; text-align:left; width:200px; padding:10px;margin-top:100px;}\t\t\t   .hiddenDiv { height:100%; overflow:hidden; display:inline-block; width:1px; overflow:hidden; margin-left:-1px; zoom:1; *display:inline; *margin-top:-1px; _margin-top:0; vertical-align:middle;}\t\t  \t</style>    \t  </head>\t\t <body>\t\t\t<div id =\"container\" class=\"centerDiv\">";
    }

    private String c() {
        return "﻿\t\t</div>  \t\t<div class=\"hiddenDiv\"></div>\t  </body>   </html>";
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ec A[SYNTHETIC, Splitter:B:37:0x00ec] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f9 A[SYNTHETIC, Splitter:B:45:0x00f9] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a() {
        /*
            r10 = this;
            java.lang.String r0 = "stream.close() error "
            android.content.Context r1 = r10.b
            r2 = 0
            java.lang.String r3 = "PushSelfShowLog"
            if (r1 != 0) goto L_0x000f
            java.lang.String r0 = "CreateHtmlFile fail ,context is null"
            com.huawei.android.pushagent.c.a.e.d(r3, r0)
            return r2
        L_0x000f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = r10.b()
            r1.append(r4)
            java.lang.String r4 = r10.a
            r1.append(r4)
            java.lang.String r4 = r10.c()
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            android.content.Context r5 = r10.b
            java.io.File r5 = r5.getFilesDir()
            java.lang.String r5 = r5.getPath()
            r4.append(r5)
            java.lang.String r5 = java.io.File.separator
            r4.append(r5)
            java.lang.String r5 = "PushService"
            r4.append(r5)
            java.lang.String r5 = java.io.File.separator
            r4.append(r5)
            java.lang.String r5 = "richpush"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "error.html"
            java.io.File r6 = new java.io.File
            r6.<init>(r4)
            java.io.File r7 = new java.io.File
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r4)
            java.lang.String r9 = java.io.File.separator
            r8.append(r9)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            boolean r8 = r6.exists()     // Catch:{ Exception -> 0x00e3, all -> 0x00e1 }
            if (r8 != 0) goto L_0x009b
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e3, all -> 0x00e1 }
            r8.<init>()     // Catch:{ Exception -> 0x00e3, all -> 0x00e1 }
            java.lang.String r9 = "Create the path:"
            r8.append(r9)     // Catch:{ Exception -> 0x00e3, all -> 0x00e1 }
            r8.append(r4)     // Catch:{ Exception -> 0x00e3, all -> 0x00e1 }
            java.lang.String r4 = r8.toString()     // Catch:{ Exception -> 0x00e3, all -> 0x00e1 }
            com.huawei.android.pushagent.c.a.e.a(r3, r4)     // Catch:{ Exception -> 0x00e3, all -> 0x00e1 }
            boolean r4 = r6.mkdirs()     // Catch:{ Exception -> 0x00e3, all -> 0x00e1 }
            if (r4 != 0) goto L_0x009b
            java.lang.String r1 = "!path.mkdirs()"
            com.huawei.android.pushagent.c.a.e.a(r3, r1)     // Catch:{ Exception -> 0x00e3, all -> 0x00e1 }
            return r2
        L_0x009b:
            boolean r4 = r7.exists()     // Catch:{ Exception -> 0x00e3, all -> 0x00e1 }
            if (r4 == 0) goto L_0x00a4
            com.huawei.android.pushselfshow.utils.a.a((java.io.File) r7)     // Catch:{ Exception -> 0x00e3, all -> 0x00e1 }
        L_0x00a4:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e3, all -> 0x00e1 }
            r4.<init>()     // Catch:{ Exception -> 0x00e3, all -> 0x00e1 }
            java.lang.String r6 = "Create the file:"
            r4.append(r6)     // Catch:{ Exception -> 0x00e3, all -> 0x00e1 }
            r4.append(r5)     // Catch:{ Exception -> 0x00e3, all -> 0x00e1 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00e3, all -> 0x00e1 }
            com.huawei.android.pushagent.c.a.e.a(r3, r4)     // Catch:{ Exception -> 0x00e3, all -> 0x00e1 }
            boolean r4 = r7.createNewFile()     // Catch:{ Exception -> 0x00e3, all -> 0x00e1 }
            if (r4 != 0) goto L_0x00c4
            java.lang.String r1 = "!file.createNewFile()"
            com.huawei.android.pushagent.c.a.e.a(r3, r1)     // Catch:{ Exception -> 0x00e3, all -> 0x00e1 }
            return r2
        L_0x00c4:
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00e3, all -> 0x00e1 }
            r4.<init>(r7)     // Catch:{ Exception -> 0x00e3, all -> 0x00e1 }
            java.lang.String r5 = "UTF-8"
            byte[] r1 = r1.getBytes(r5)     // Catch:{ Exception -> 0x00df }
            r4.write(r1)     // Catch:{ Exception -> 0x00df }
            r4.close()     // Catch:{ Exception -> 0x00d6 }
            goto L_0x00da
        L_0x00d6:
            r1 = move-exception
            com.huawei.android.pushagent.c.a.e.a((java.lang.String) r3, (java.lang.String) r0, (java.lang.Throwable) r1)
        L_0x00da:
            java.lang.String r0 = r7.getAbsolutePath()
            return r0
        L_0x00df:
            r1 = move-exception
            goto L_0x00e5
        L_0x00e1:
            r1 = move-exception
            goto L_0x00f7
        L_0x00e3:
            r1 = move-exception
            r4 = r2
        L_0x00e5:
            java.lang.String r5 = "Create html error "
            com.huawei.android.pushagent.c.a.e.a((java.lang.String) r3, (java.lang.String) r5, (java.lang.Throwable) r1)     // Catch:{ all -> 0x00f5 }
            if (r4 == 0) goto L_0x00f4
            r4.close()     // Catch:{ Exception -> 0x00f0 }
            goto L_0x00f4
        L_0x00f0:
            r1 = move-exception
            com.huawei.android.pushagent.c.a.e.a((java.lang.String) r3, (java.lang.String) r0, (java.lang.Throwable) r1)
        L_0x00f4:
            return r2
        L_0x00f5:
            r1 = move-exception
            r2 = r4
        L_0x00f7:
            if (r2 == 0) goto L_0x0101
            r2.close()     // Catch:{ Exception -> 0x00fd }
            goto L_0x0101
        L_0x00fd:
            r2 = move-exception
            com.huawei.android.pushagent.c.a.e.a((java.lang.String) r3, (java.lang.String) r0, (java.lang.Throwable) r2)
        L_0x0101:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.richpush.tools.c.a():java.lang.String");
    }
}
