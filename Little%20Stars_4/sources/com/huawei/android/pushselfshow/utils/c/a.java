package com.huawei.android.pushselfshow.utils.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.huawei.android.pushagent.c.a.e;

public class a {
    public Bitmap a(Context context, Bitmap bitmap, float f, float f2) {
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale(f / ((float) width), f2 / ((float) height));
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            if (createBitmap != null) {
                e.a("PushSelfShowLog", "reScaleBitmap success");
                return createBitmap;
            }
        } catch (Exception e) {
            e.c("PushSelfShowLog", "reScaleBitmap fail ,error ：" + e, e);
        }
        return bitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x011a A[SYNTHETIC, Splitter:B:42:0x011a] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x014e A[SYNTHETIC, Splitter:B:57:0x014e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap a(android.content.Context r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "image delete success"
            java.lang.String r1 = "is.close() error"
            java.lang.String r2 = "PushSelfShowLog"
            r3 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            r4.<init>()     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            java.lang.String r5 = "image"
            r4.append(r5)     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            r4.append(r5)     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            java.lang.String r5 = com.huawei.android.pushselfshow.utils.b.b.a((android.content.Context) r10)     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            r6.<init>(r5)     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            boolean r7 = r6.exists()     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            if (r7 != 0) goto L_0x0061
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            r7.<init>()     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            java.lang.String r8 = "mkdir: "
            r7.append(r8)     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            java.lang.String r8 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            r7.append(r8)     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            com.huawei.android.pushagent.c.a.e.a(r2, r7)     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            boolean r7 = r6.mkdirs()     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            if (r7 != 0) goto L_0x0061
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            r7.<init>()     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            java.lang.String r8 = "file mkdir failed ,path is "
            r7.append(r8)     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            java.lang.String r6 = r6.getPath()     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            r7.append(r6)     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            java.lang.String r6 = r7.toString()     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            com.huawei.android.pushagent.c.a.e.a(r2, r6)     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
        L_0x0061:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            r6.<init>()     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            r6.append(r5)     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            java.lang.String r5 = java.io.File.separator     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            r6.append(r5)     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            r6.append(r4)     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            java.lang.String r4 = r6.toString()     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            r5.<init>()     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            java.lang.String r6 = "try to download image to "
            r5.append(r6)     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            r5.append(r4)     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            com.huawei.android.pushagent.c.a.e.a(r2, r5)     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            com.huawei.android.pushselfshow.utils.b.b r5 = new com.huawei.android.pushselfshow.utils.b.b     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            r5.<init>()     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            boolean r10 = r5.b(r10, r11, r4)     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            if (r10 == 0) goto L_0x00c2
            java.lang.String r10 = "download successed"
            com.huawei.android.pushagent.c.a.e.a(r2, r10)     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            android.graphics.BitmapFactory$Options r10 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            r10.<init>()     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            r11 = 0
            r10.inDither = r11     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            r11 = 1
            r10.inPurgeable = r11     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            r10.inSampleSize = r11     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            android.graphics.Bitmap$Config r11 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            r10.inPreferredConfig = r11     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            java.io.File r11 = new java.io.File     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            r11.<init>(r4)     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00bf, all -> 0x00bc }
            r4.<init>(r11)     // Catch:{ Exception -> 0x00bf, all -> 0x00bc }
            android.graphics.Bitmap r10 = android.graphics.BitmapFactory.decodeStream(r4, r3, r10)     // Catch:{ Exception -> 0x00ba }
            r3 = r4
            goto L_0x00c9
        L_0x00ba:
            r10 = move-exception
            goto L_0x0100
        L_0x00bc:
            r10 = move-exception
            goto L_0x014c
        L_0x00bf:
            r10 = move-exception
            r4 = r3
            goto L_0x0100
        L_0x00c2:
            java.lang.String r10 = "download failed"
            com.huawei.android.pushagent.c.a.e.a(r2, r10)     // Catch:{ Exception -> 0x00fd, all -> 0x00fa }
            r10 = r3
            r11 = r10
        L_0x00c9:
            if (r3 == 0) goto L_0x00d1
            r3.close()     // Catch:{ Exception -> 0x00cf }
            goto L_0x00d1
        L_0x00cf:
            r11 = move-exception
            goto L_0x00e3
        L_0x00d1:
            if (r11 == 0) goto L_0x0149
            boolean r3 = r11.isFile()     // Catch:{ Exception -> 0x00cf }
            if (r3 == 0) goto L_0x0149
            boolean r11 = r11.delete()     // Catch:{ Exception -> 0x00cf }
            if (r11 == 0) goto L_0x0149
            com.huawei.android.pushagent.c.a.e.a(r2, r0)     // Catch:{ Exception -> 0x00cf }
            goto L_0x0149
        L_0x00e3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r1 = r11.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.huawei.android.pushagent.c.a.e.c(r2, r0, r11)
            goto L_0x0149
        L_0x00fa:
            r10 = move-exception
            r11 = r3
            goto L_0x014c
        L_0x00fd:
            r10 = move-exception
            r11 = r3
            r4 = r11
        L_0x0100:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x014a }
            r5.<init>()     // Catch:{ all -> 0x014a }
            java.lang.String r6 = "getRemoteImage  failed  ,errorinfo is "
            r5.append(r6)     // Catch:{ all -> 0x014a }
            java.lang.String r6 = r10.toString()     // Catch:{ all -> 0x014a }
            r5.append(r6)     // Catch:{ all -> 0x014a }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x014a }
            com.huawei.android.pushagent.c.a.e.c(r2, r5, r10)     // Catch:{ all -> 0x014a }
            if (r4 == 0) goto L_0x0120
            r4.close()     // Catch:{ Exception -> 0x011e }
            goto L_0x0120
        L_0x011e:
            r10 = move-exception
            goto L_0x0132
        L_0x0120:
            if (r11 == 0) goto L_0x0148
            boolean r10 = r11.isFile()     // Catch:{ Exception -> 0x011e }
            if (r10 == 0) goto L_0x0148
            boolean r10 = r11.delete()     // Catch:{ Exception -> 0x011e }
            if (r10 == 0) goto L_0x0148
            com.huawei.android.pushagent.c.a.e.a(r2, r0)     // Catch:{ Exception -> 0x011e }
            goto L_0x0148
        L_0x0132:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r1)
            java.lang.String r0 = r10.toString()
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            com.huawei.android.pushagent.c.a.e.c(r2, r11, r10)
        L_0x0148:
            r10 = r3
        L_0x0149:
            return r10
        L_0x014a:
            r10 = move-exception
            r3 = r4
        L_0x014c:
            if (r3 == 0) goto L_0x0154
            r3.close()     // Catch:{ Exception -> 0x0152 }
            goto L_0x0154
        L_0x0152:
            r11 = move-exception
            goto L_0x0166
        L_0x0154:
            if (r11 == 0) goto L_0x017c
            boolean r3 = r11.isFile()     // Catch:{ Exception -> 0x0152 }
            if (r3 == 0) goto L_0x017c
            boolean r11 = r11.delete()     // Catch:{ Exception -> 0x0152 }
            if (r11 == 0) goto L_0x017c
            com.huawei.android.pushagent.c.a.e.a(r2, r0)     // Catch:{ Exception -> 0x0152 }
            goto L_0x017c
        L_0x0166:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r1 = r11.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.huawei.android.pushagent.c.a.e.c(r2, r0, r11)
        L_0x017c:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.utils.c.a.a(android.content.Context, java.lang.String):android.graphics.Bitmap");
    }
}
