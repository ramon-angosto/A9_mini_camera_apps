package com.dommy.qrcode.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

public class BitmapUtil {
    public static Bitmap decodeUri(Context context, Uri uri, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        readBitmapScale(context, uri, options);
        int i3 = 1;
        for (int i4 = 0; i4 < Integer.MAX_VALUE && ((options.outWidth / i3 > i && ((double) (options.outWidth / i3)) > ((double) i) * 1.4d) || (options.outHeight / i3 > i2 && ((double) (options.outHeight / i3)) > ((double) i2) * 1.4d)); i4++) {
            i3++;
        }
        options.inSampleSize = i3;
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        try {
            return readBitmapData(context, uri, options);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x008f A[SYNTHETIC, Splitter:B:30:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009d A[SYNTHETIC, Splitter:B:35:0x009d] */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void readBitmapScale(android.content.Context r4, android.net.Uri r5, android.graphics.BitmapFactory.Options r6) {
        /*
            if (r5 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = r5.getScheme()
            java.lang.String r1 = "content"
            boolean r1 = r1.equals(r0)
            java.lang.String r2 = "Unable to close content: "
            java.lang.String r3 = "readBitmapScale"
            if (r1 != 0) goto L_0x004a
            java.lang.String r1 = "file"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x001c
            goto L_0x004a
        L_0x001c:
            java.lang.String r4 = "android.resource"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0037
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            android.util.Log.e(r3, r4)
            goto L_0x009a
        L_0x0037:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            android.util.Log.e(r3, r4)
            goto L_0x009a
        L_0x004a:
            r0 = 0
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ Exception -> 0x0078 }
            java.io.InputStream r4 = r4.openInputStream(r5)     // Catch:{ Exception -> 0x0078 }
            android.graphics.BitmapFactory.decodeStream(r4, r0, r6)     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            if (r4 == 0) goto L_0x009a
            r4.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x009a
        L_0x005c:
            r4 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
        L_0x0062:
            r6.append(r2)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            android.util.Log.e(r3, r5, r4)
            goto L_0x009a
        L_0x0070:
            r6 = move-exception
            r0 = r4
            goto L_0x009b
        L_0x0073:
            r6 = move-exception
            r0 = r4
            goto L_0x0079
        L_0x0076:
            r6 = move-exception
            goto L_0x009b
        L_0x0078:
            r6 = move-exception
        L_0x0079:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r4.<init>()     // Catch:{ all -> 0x0076 }
            java.lang.String r1 = "Unable to open content: "
            r4.append(r1)     // Catch:{ all -> 0x0076 }
            r4.append(r5)     // Catch:{ all -> 0x0076 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0076 }
            android.util.Log.w(r3, r4, r6)     // Catch:{ all -> 0x0076 }
            if (r0 == 0) goto L_0x009a
            r0.close()     // Catch:{ IOException -> 0x0093 }
            goto L_0x009a
        L_0x0093:
            r4 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            goto L_0x0062
        L_0x009a:
            return
        L_0x009b:
            if (r0 == 0) goto L_0x00b4
            r0.close()     // Catch:{ IOException -> 0x00a1 }
            goto L_0x00b4
        L_0x00a1:
            r4 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            android.util.Log.e(r3, r5, r4)
        L_0x00b4:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dommy.qrcode.util.BitmapUtil.readBitmapScale(android.content.Context, android.net.Uri, android.graphics.BitmapFactory$Options):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0092 A[SYNTHETIC, Splitter:B:30:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ac A[SYNTHETIC, Splitter:B:35:0x00ac] */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap readBitmapData(android.content.Context r5, android.net.Uri r6, android.graphics.BitmapFactory.Options r7) {
        /*
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = r6.getScheme()
            java.lang.String r2 = "content"
            boolean r2 = r2.equals(r1)
            java.lang.String r3 = "Unable to close content: "
            java.lang.String r4 = "readBitmapData"
            if (r2 != 0) goto L_0x004c
            java.lang.String r2 = "file"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x001d
            goto L_0x004c
        L_0x001d:
            java.lang.String r5 = "android.resource"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x0039
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            android.util.Log.e(r4, r5)
            goto L_0x00a9
        L_0x0039:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            android.util.Log.e(r4, r5)
            goto L_0x00a9
        L_0x004c:
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch:{ Exception -> 0x007a, all -> 0x0077 }
            java.io.InputStream r5 = r5.openInputStream(r6)     // Catch:{ Exception -> 0x007a, all -> 0x0077 }
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeStream(r5, r0, r7)     // Catch:{ Exception -> 0x0075 }
            if (r5 == 0) goto L_0x0071
            r5.close()     // Catch:{ IOException -> 0x005e }
            goto L_0x0071
        L_0x005e:
            r5 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            android.util.Log.e(r4, r6, r5)
        L_0x0071:
            r0 = r7
            goto L_0x00a9
        L_0x0073:
            r7 = move-exception
            goto L_0x00aa
        L_0x0075:
            r7 = move-exception
            goto L_0x007c
        L_0x0077:
            r7 = move-exception
            r5 = r0
            goto L_0x00aa
        L_0x007a:
            r7 = move-exception
            r5 = r0
        L_0x007c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
            r1.<init>()     // Catch:{ all -> 0x0073 }
            java.lang.String r2 = "Unable to open content: "
            r1.append(r2)     // Catch:{ all -> 0x0073 }
            r1.append(r6)     // Catch:{ all -> 0x0073 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0073 }
            android.util.Log.e(r4, r1, r7)     // Catch:{ all -> 0x0073 }
            if (r5 == 0) goto L_0x00a9
            r5.close()     // Catch:{ IOException -> 0x0096 }
            goto L_0x00a9
        L_0x0096:
            r5 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r3)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            android.util.Log.e(r4, r6, r5)
        L_0x00a9:
            return r0
        L_0x00aa:
            if (r5 == 0) goto L_0x00c3
            r5.close()     // Catch:{ IOException -> 0x00b0 }
            goto L_0x00c3
        L_0x00b0:
            r5 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            android.util.Log.e(r4, r6, r5)
        L_0x00c3:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dommy.qrcode.util.BitmapUtil.readBitmapData(android.content.Context, android.net.Uri, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }
}
