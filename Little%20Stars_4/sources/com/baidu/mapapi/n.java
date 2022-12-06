package com.baidu.mapapi;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

class n {
    private static Constructor<?> a;
    private static final int b = Integer.parseInt(Build.VERSION.SDK);

    /* renamed from: com.baidu.mapapi.n$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.baidu.mapapi.n$a[] r0 = com.baidu.mapapi.n.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.baidu.mapapi.n$a r1 = com.baidu.mapapi.n.a.DOUGLAS_METHOD     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.baidu.mapapi.n$a r1 = com.baidu.mapapi.n.a.DOUGLAS_MOBILE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.baidu.mapapi.n$a r1 = com.baidu.mapapi.n.a.GRID_METHOD     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.n.AnonymousClass1.<clinit>():void");
        }
    }

    private enum a {
        DOUGLAS_METHOD,
        GRID_METHOD,
        DOUGLAS_MOBILE
    }

    n() {
    }

    private static double a(int i, a aVar) {
        int i2 = AnonymousClass1.a[aVar.ordinal()];
        if (i2 == 1) {
            double log = Math.log(Math.pow(2.6d, (double) i));
            return (2.6d * log * log) + 100.0d;
        } else if (i2 == 2) {
            return Math.pow(2.0d, (double) i) * 4.0d;
        } else {
            if (i2 != 3) {
                return 100.0d;
            }
            return (Math.log(Math.pow(2.6d, (double) i)) * 65.0d) + 100.0d;
        }
    }

    static int a(ArrayList<GeoPoint> arrayList, ArrayList<GeoPoint> arrayList2, int i, ArrayList<GeoPoint> arrayList3) {
        if (arrayList == null || arrayList2 == null || arrayList3 == null) {
            return -1;
        }
        arrayList3.clear();
        a(arrayList, arrayList2, arrayList3, a(18 - i, a.DOUGLAS_MOBILE));
        return 0;
    }

    static int a(ArrayList<GeoPoint> arrayList, ArrayList<GeoPoint> arrayList2, ArrayList<GeoPoint> arrayList3, double d) {
        int size = arrayList.size();
        if (size < 2) {
            return -1;
        }
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = 1;
        }
        a(arrayList2, iArr, 0, size - 1, d);
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (iArr[i3] > 0) {
                arrayList3.add(arrayList.get(i3));
                i2++;
            }
        }
        return i2;
    }

    static int a(ArrayList<GeoPoint> arrayList, int[] iArr, int i, int i2, double d) {
        ArrayList<GeoPoint> arrayList2 = arrayList;
        int i3 = i;
        int i4 = i2;
        int i5 = i3 + 1;
        if (i4 <= i5) {
            return 0;
        }
        double d2 = d * d * 100.0d * 100.0d;
        long j = -1;
        int i6 = 0;
        for (int i7 = i5; i7 < i4; i7++) {
            long a2 = a(arrayList.get(i7), arrayList.get(i3), arrayList.get(i4));
            if (a2 > j) {
                i6 = i7;
                j = a2;
            }
        }
        if (((double) j) >= d2) {
            ArrayList<GeoPoint> arrayList3 = arrayList;
            int[] iArr2 = iArr;
            double d3 = d;
            a(arrayList3, iArr2, i, i6, d3);
            a(arrayList3, iArr2, i6, i2, d3);
        } else {
            while (i5 < i4) {
                iArr[i5] = 0;
                i5++;
            }
        }
        return 0;
    }

    static long a(GeoPoint geoPoint, GeoPoint geoPoint2, GeoPoint geoPoint3) {
        long longitudeE6 = (long) geoPoint.getLongitudeE6();
        long latitudeE6 = (long) geoPoint.getLatitudeE6();
        long longitudeE62 = (long) geoPoint2.getLongitudeE6();
        long latitudeE62 = (long) geoPoint2.getLatitudeE6();
        long longitudeE63 = (long) geoPoint3.getLongitudeE6();
        long latitudeE63 = (long) geoPoint3.getLatitudeE6();
        long j = longitudeE62 - longitudeE63;
        long j2 = latitudeE62 - latitudeE63;
        long j3 = j;
        long j4 = (j * j) + (j2 * j2);
        if (j4 == 0) {
            long j5 = longitudeE6 - longitudeE62;
            long j6 = latitudeE6 - latitudeE62;
            return (j5 * j5) + (j6 * j6);
        }
        long j7 = latitudeE62 - latitudeE6;
        long j8 = longitudeE62 - longitudeE6;
        double d = (double) ((j2 * j7) - ((longitudeE63 - longitudeE62) * j8));
        double d2 = (double) j4;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = d / d2;
        if (d3 > 1.0d || d3 < 0.0d) {
            long j9 = longitudeE6 - longitudeE62;
            long j10 = longitudeE6 - longitudeE63;
            long j11 = latitudeE6 - latitudeE62;
            long j12 = latitudeE6 - latitudeE63;
            long j13 = (j9 * j9) + (j11 * j11);
            long j14 = (j10 * j10) + (j12 * j12);
            return j13 < j14 ? j13 : j14;
        }
        double d4 = (double) ((j7 * (-j3)) - (j8 * (latitudeE63 - latitudeE62)));
        Double.isNaN(d4);
        Double.isNaN(d2);
        Double.isNaN(d4);
        return (long) ((d4 / d2) * d4);
    }

    static Drawable a(Context context, String str) {
        try {
            InputStream open = context.getAssets().open(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            open.close();
            if (b < 4) {
                return new BitmapDrawable(decodeStream);
            }
            Resources resources = context.getResources();
            if (a == null) {
                a = Class.forName("android.graphics.drawable.BitmapDrawable").getConstructor(new Class[]{Resources.class, Bitmap.class});
            }
            return (Drawable) a.newInstance(new Object[]{resources, decodeStream});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static Drawable a(Context context, String str, float f) {
        try {
            InputStream open = context.getAssets().open(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            open.close();
            Matrix matrix = new Matrix();
            matrix.reset();
            matrix.setRotate(f);
            Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 0, 0, decodeStream.getWidth(), decodeStream.getHeight(), matrix, true);
            if (b < 4) {
                return new BitmapDrawable(createBitmap);
            }
            Resources resources = context.getResources();
            if (a == null) {
                a = Class.forName("android.graphics.drawable.BitmapDrawable").getConstructor(new Class[]{Resources.class, Bitmap.class});
            }
            return (Drawable) a.newInstance(new Object[]{resources, createBitmap});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static boolean a(Point point, Point point2, int i, int i2) {
        if ((point.x > 0 || point2.x > 0) && (point.x < i || point2.x < i)) {
            return (point.y > 0 || point2.y > 0) && (point.y < i2 || point2.y < i2);
        }
        return false;
    }
}
