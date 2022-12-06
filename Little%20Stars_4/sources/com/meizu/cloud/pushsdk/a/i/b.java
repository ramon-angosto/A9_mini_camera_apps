package com.meizu.cloud.pushsdk.a.i;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.NetworkOnMainThreadException;
import android.widget.ImageView;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.meizu.cloud.pushsdk.a.a.c;
import com.meizu.cloud.pushsdk.a.c.a;
import com.meizu.cloud.pushsdk.a.d.k;
import com.meizu.cloud.pushsdk.a.h.f;
import com.meizu.cloud.pushsdk.a.h.l;
import java.io.IOException;
import java.net.URLConnection;

public class b {
    public static String a(String str) {
        String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str);
        return contentTypeFor == null ? OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE : contentTypeFor;
    }

    public static c<Bitmap> a(k kVar, int i, int i2, Bitmap.Config config, ImageView.ScaleType scaleType) {
        Bitmap bitmap;
        byte[] bArr = new byte[0];
        try {
            bArr = f.a((l) kVar.b().a()).i();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (i == 0 && i2 == 0) {
            options.inPreferredConfig = config;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i3 = options.outWidth;
            int i4 = options.outHeight;
            int a = a(i, i2, i3, i4, scaleType);
            int a2 = a(i2, i, i4, i3, scaleType);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i3, i4, a, a2);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray == null || (decodeByteArray.getWidth() <= a && decodeByteArray.getHeight() <= a2)) {
                bitmap = decodeByteArray;
            } else {
                bitmap = Bitmap.createScaledBitmap(decodeByteArray, a, a2, true);
                decodeByteArray.recycle();
            }
        }
        if (bitmap == null) {
            return c.a(b(new a(kVar)));
        }
        return c.a(bitmap);
    }

    private static int a(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        }
        if (i == 0) {
            double d = (double) i2;
            double d2 = (double) i4;
            Double.isNaN(d);
            Double.isNaN(d2);
            double d3 = (double) i3;
            Double.isNaN(d3);
            return (int) (d3 * (d / d2));
        } else if (i2 == 0) {
            return i;
        } else {
            double d4 = (double) i4;
            double d5 = (double) i3;
            Double.isNaN(d4);
            Double.isNaN(d5);
            double d6 = d4 / d5;
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                double d7 = (double) i;
                Double.isNaN(d7);
                double d8 = (double) i2;
                if (d7 * d6 >= d8) {
                    return i;
                }
                Double.isNaN(d8);
                return (int) (d8 / d6);
            }
            double d9 = (double) i;
            Double.isNaN(d9);
            double d10 = (double) i2;
            if (d9 * d6 <= d10) {
                return i;
            }
            Double.isNaN(d10);
            return (int) (d10 / d6);
        }
    }

    public static int a(int i, int i2, int i3, int i4) {
        double d = (double) i;
        double d2 = (double) i3;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = (double) i2;
        double d4 = (double) i4;
        Double.isNaN(d3);
        Double.isNaN(d4);
        double min = Math.min(d / d2, d3 / d4);
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (((double) f2) > min) {
                return (int) f;
            }
            f = f2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0050 A[SYNTHETIC, Splitter:B:28:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005a A[SYNTHETIC, Splitter:B:33:0x005a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.meizu.cloud.pushsdk.a.d.k r3, java.lang.String r4, java.lang.String r5) throws java.io.IOException {
        /*
            r0 = 2048(0x800, float:2.87E-42)
            byte[] r0 = new byte[r0]
            r1 = 0
            com.meizu.cloud.pushsdk.a.d.l r3 = r3.b()     // Catch:{ all -> 0x004c }
            java.io.InputStream r3 = r3.b()     // Catch:{ all -> 0x004c }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x004a }
            r2.<init>(r4)     // Catch:{ all -> 0x004a }
            boolean r4 = r2.exists()     // Catch:{ all -> 0x004a }
            if (r4 != 0) goto L_0x001b
            r2.mkdirs()     // Catch:{ all -> 0x004a }
        L_0x001b:
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x004a }
            r4.<init>(r2, r5)     // Catch:{ all -> 0x004a }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x004a }
            r5.<init>(r4)     // Catch:{ all -> 0x004a }
        L_0x0025:
            int r4 = r3.read(r0)     // Catch:{ all -> 0x0047 }
            r1 = -1
            if (r4 == r1) goto L_0x0031
            r1 = 0
            r5.write(r0, r1, r4)     // Catch:{ all -> 0x0047 }
            goto L_0x0025
        L_0x0031:
            r5.flush()     // Catch:{ all -> 0x0047 }
            if (r3 == 0) goto L_0x003e
            r3.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r3 = move-exception
            r3.printStackTrace()
        L_0x003e:
            r5.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0046:
            return
        L_0x0047:
            r4 = move-exception
            r1 = r5
            goto L_0x004e
        L_0x004a:
            r4 = move-exception
            goto L_0x004e
        L_0x004c:
            r4 = move-exception
            r3 = r1
        L_0x004e:
            if (r3 == 0) goto L_0x0058
            r3.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x0058
        L_0x0054:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0058:
            if (r1 == 0) goto L_0x0062
            r1.close()     // Catch:{ IOException -> 0x005e }
            goto L_0x0062
        L_0x005e:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0062:
            goto L_0x0064
        L_0x0063:
            throw r4
        L_0x0064:
            goto L_0x0063
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.a.i.b.a(com.meizu.cloud.pushsdk.a.d.k, java.lang.String, java.lang.String):void");
    }

    public static a a(a aVar) {
        aVar.a("connectionError");
        aVar.a(0);
        return aVar;
    }

    public static a a(a aVar, com.meizu.cloud.pushsdk.a.a.b bVar, int i) {
        a a = bVar.a(aVar);
        a.a(i);
        a.a("responseFromServerError");
        return a;
    }

    public static a b(a aVar) {
        aVar.a(0);
        aVar.a("parseError");
        return aVar;
    }

    public static a a(Exception exc) {
        a aVar = new a((Throwable) exc);
        if (Build.VERSION.SDK_INT < 11 || !(exc instanceof NetworkOnMainThreadException)) {
            aVar.a("connectionError");
        } else {
            aVar.a("networkOnMainThreadError");
        }
        aVar.a(0);
        return aVar;
    }
}
