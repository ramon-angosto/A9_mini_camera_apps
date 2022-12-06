package com.baidu.mapapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.InputDeviceCompat;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.mapapi.MapView;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.lang.reflect.Method;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.List;

public class a extends View {
    private static Method J;
    private static Method K;
    private static Method L;
    private static Bitmap h;
    private static ShortBuffer i;
    private static short[] j;
    private static int k;
    private static int l;
    private static int m;
    private float A;
    private float B;
    private float C;
    private float D;
    private int E = 0;
    private int F = 0;
    private boolean G = false;
    private int H = 0;
    private Paint I = new Paint();
    private MapView.a M = MapView.a.DRAW_RETICLE_OVER;
    boolean a = false;
    int b = 0;
    int c = 0;
    int d = 0;
    double e = 1.0d;
    int f = 0;
    int g = 0;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private int q = 0;
    private MapView r = null;
    private List<Overlay> s = new ArrayList();
    private boolean t = false;
    private boolean u = true;
    private long v = 0;
    private long w = 0;
    private long x = 0;
    private float y;
    private float z;

    /* renamed from: com.baidu.mapapi.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[MapView.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.baidu.mapapi.MapView$a[] r0 = com.baidu.mapapi.MapView.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.baidu.mapapi.MapView$a r1 = com.baidu.mapapi.MapView.a.DRAW_RETICLE_NEVER     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.baidu.mapapi.MapView$a r1 = com.baidu.mapapi.MapView.a.DRAW_RETICLE_OVER     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.baidu.mapapi.MapView$a r1 = com.baidu.mapapi.MapView.a.DRAW_RETICLE_UNDER     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.a.AnonymousClass1.<clinit>():void");
        }
    }

    public a(Context context, MapView mapView) {
        super(context);
        this.r = mapView;
        this.I.setColor(-7829368);
        this.I.setStyle(Paint.Style.STROKE);
    }

    private void c(Canvas canvas) {
    }

    private void d(Canvas canvas) {
        long nanoTime = (System.nanoTime() * 1000) / 1000000000;
        for (Overlay draw : this.s) {
            draw.draw(canvas, this.r, false, nanoTime);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        Bitmap bitmap = h;
        if (bitmap != null && bitmap.isRecycled()) {
            h.recycle();
        }
        l = 0;
        m = 0;
        h = null;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        int minZoomLevel = this.r.getMinZoomLevel();
        int maxZoomLevel = this.r.getMaxZoomLevel();
        if (minZoomLevel <= i2 && i2 <= maxZoomLevel) {
            Mj.MapProc(InputDeviceCompat.SOURCE_TOUCHSCREEN, i2, 1);
        }
    }

    public void a(int i2, int i3, int i4) {
        this.F += i2;
        this.E = 3;
        if (i3 == 0 && i4 == 0) {
            this.f = h.getWidth() / 2;
            this.g = h.getHeight() / 2;
        } else {
            this.f = i3;
            this.g = i4;
        }
        Mj.p = 1;
        invalidate();
    }

    public void a(int i2, int i3, int i4, int i5) {
        if (i5 > 0 && i4 > 0) {
            int i6 = ((i4 + 3) / 4) * 4;
            int i7 = ((i5 + 3) / 4) * 4;
            if (l != i6 || m != i7) {
                for (Overlay a2 : this.s) {
                    a2.a(i2, i3, i6, i7);
                }
                int i8 = i6 * i7 * 2;
                if (i8 > k) {
                    j = new short[i8];
                    i = ShortBuffer.allocate(i8);
                    k = i8;
                }
                Bitmap bitmap = h;
                if (bitmap != null && !bitmap.isRecycled()) {
                    h.recycle();
                }
                try {
                    h = Bitmap.createBitmap(i6, i7, Bitmap.Config.RGB_565);
                } catch (OutOfMemoryError unused) {
                    System.gc();
                    Bitmap bitmap2 = h;
                    if (bitmap2 != null && !bitmap2.isRecycled()) {
                        h.recycle();
                    }
                }
                Mj.p = 1;
                Mj.renderUpdateScreen(j, i6, i7);
                l = i6;
                m = i7;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas) {
        canvas.drawRGB(192, 192, 192);
        Matrix matrix = new Matrix();
        if (this.H != 1) {
            double d2 = this.e;
            if (d2 != 1.0d) {
                float abs = (float) Math.abs(d2);
                matrix.postScale(abs, abs, (float) this.f, (float) this.g);
                matrix.postTranslate((float) this.c, (float) this.d);
                canvas.drawBitmap(h, matrix, (Paint) null);
                return;
            }
        }
        canvas.drawBitmap(h, (float) this.c, (float) this.d, (Paint) null);
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        this.u = z2;
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2, int i2, Rect rect) {
        super.onFocusChanged(z2, i2, rect);
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2, KeyEvent keyEvent) {
        boolean z2 = false;
        for (int size = this.s.size() - 1; size >= 0; size--) {
            z2 = this.s.get(size).onKeyDown(i2, keyEvent, this.r);
            if (z2) {
                break;
            }
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x014e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x014f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.view.MotionEvent r14) {
        /*
            r13 = this;
            java.lang.String r0 = android.os.Build.VERSION.SDK
            int r0 = java.lang.Integer.parseInt(r0)
            r1 = 4
            r2 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r4 = 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            if (r0 > r1) goto L_0x0015
            r0 = 1
            goto L_0x005a
        L_0x0015:
            java.lang.reflect.Method r0 = J     // Catch:{ Exception -> 0x0055 }
            if (r0 != 0) goto L_0x0046
            java.lang.String r0 = "android.view.MotionEvent"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x0055 }
            java.lang.String r6 = "getPointerCount"
            r7 = 0
            java.lang.Class[] r7 = (java.lang.Class[]) r7     // Catch:{ Exception -> 0x0055 }
            java.lang.reflect.Method r6 = r0.getMethod(r6, r7)     // Catch:{ Exception -> 0x0055 }
            J = r6     // Catch:{ Exception -> 0x0055 }
            java.lang.String r6 = "getX"
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x0055 }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0055 }
            r7[r2] = r8     // Catch:{ Exception -> 0x0055 }
            java.lang.reflect.Method r6 = r0.getMethod(r6, r7)     // Catch:{ Exception -> 0x0055 }
            L = r6     // Catch:{ Exception -> 0x0055 }
            java.lang.String r6 = "getY"
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x0055 }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0055 }
            r7[r2] = r8     // Catch:{ Exception -> 0x0055 }
            java.lang.reflect.Method r0 = r0.getMethod(r6, r7)     // Catch:{ Exception -> 0x0055 }
            K = r0     // Catch:{ Exception -> 0x0055 }
        L_0x0046:
            java.lang.reflect.Method r0 = J     // Catch:{ Exception -> 0x0055 }
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0055 }
            java.lang.Object r0 = r0.invoke(r14, r6)     // Catch:{ Exception -> 0x0055 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x0055 }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x0055 }
            goto L_0x005a
        L_0x0055:
            r0 = move-exception
            r0.printStackTrace()
            r0 = 0
        L_0x005a:
            r6 = 2
            if (r0 != r6) goto L_0x0141
            java.lang.reflect.Method r0 = L     // Catch:{ Exception -> 0x00a6 }
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x00a6 }
            r7[r2] = r3     // Catch:{ Exception -> 0x00a6 }
            java.lang.Object r0 = r0.invoke(r14, r7)     // Catch:{ Exception -> 0x00a6 }
            java.lang.Float r0 = (java.lang.Float) r0     // Catch:{ Exception -> 0x00a6 }
            float r0 = r0.floatValue()     // Catch:{ Exception -> 0x00a6 }
            r13.y = r0     // Catch:{ Exception -> 0x00a6 }
            java.lang.reflect.Method r0 = K     // Catch:{ Exception -> 0x00a6 }
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x00a6 }
            r7[r2] = r3     // Catch:{ Exception -> 0x00a6 }
            java.lang.Object r0 = r0.invoke(r14, r7)     // Catch:{ Exception -> 0x00a6 }
            java.lang.Float r0 = (java.lang.Float) r0     // Catch:{ Exception -> 0x00a6 }
            float r0 = r0.floatValue()     // Catch:{ Exception -> 0x00a6 }
            r13.z = r0     // Catch:{ Exception -> 0x00a6 }
            java.lang.reflect.Method r0 = L     // Catch:{ Exception -> 0x00a6 }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x00a6 }
            r3[r2] = r5     // Catch:{ Exception -> 0x00a6 }
            java.lang.Object r0 = r0.invoke(r14, r3)     // Catch:{ Exception -> 0x00a6 }
            java.lang.Float r0 = (java.lang.Float) r0     // Catch:{ Exception -> 0x00a6 }
            float r0 = r0.floatValue()     // Catch:{ Exception -> 0x00a6 }
            r13.A = r0     // Catch:{ Exception -> 0x00a6 }
            java.lang.reflect.Method r0 = K     // Catch:{ Exception -> 0x00a6 }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x00a6 }
            r3[r2] = r5     // Catch:{ Exception -> 0x00a6 }
            java.lang.Object r0 = r0.invoke(r14, r3)     // Catch:{ Exception -> 0x00a6 }
            java.lang.Float r0 = (java.lang.Float) r0     // Catch:{ Exception -> 0x00a6 }
            float r0 = r0.floatValue()     // Catch:{ Exception -> 0x00a6 }
            r13.B = r0     // Catch:{ Exception -> 0x00a6 }
            goto L_0x00aa
        L_0x00a6:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00aa:
            float r0 = r13.y
            float r3 = r13.A
            float r5 = r0 - r3
            float r0 = r0 - r3
            float r5 = r5 * r0
            float r0 = r13.z
            float r3 = r13.B
            float r7 = r0 - r3
            float r0 = r0 - r3
            float r7 = r7 * r0
            float r5 = r5 + r7
            double r7 = (double) r5
            double r7 = java.lang.Math.sqrt(r7)
            float r0 = (float) r7
            r3 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r3
            r13.D = r0
            int r0 = r13.E
            if (r0 != 0) goto L_0x00fb
            float r0 = r13.D
            float r5 = com.baidu.mapapi.Mj.j
            r7 = 1106247680(0x41f00000, float:30.0)
            float r5 = r5 * r7
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x014a
            r13.t = r2
            float r0 = r13.y
            float r5 = r13.A
            float r0 = r0 + r5
            float r0 = r0 / r3
            int r5 = r13.c
            float r5 = (float) r5
            float r0 = r0 - r5
            int r0 = (int) r0
            r13.f = r0
            float r0 = r13.z
            float r5 = r13.B
            float r0 = r0 + r5
            float r0 = r0 / r3
            int r3 = r13.d
            float r3 = (float) r3
            float r0 = r0 - r3
            int r0 = (int) r0
            r13.g = r0
            float r0 = r13.D
            r13.C = r0
            r13.E = r4
            goto L_0x014a
        L_0x00fb:
            int r0 = r13.H
            if (r0 != r4) goto L_0x0138
            float r0 = r13.D
            float r3 = r13.C
            float r0 = r0 / r3
            double r7 = (double) r0
            double r7 = java.lang.Math.log(r7)
            r9 = 4613937818241073152(0x4008000000000000, double:3.0)
            double r9 = java.lang.Math.log(r9)
            double r7 = r7 / r9
            r9 = 0
            r11 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 < 0) goto L_0x011a
            double r7 = r7 + r11
            goto L_0x011b
        L_0x011a:
            double r7 = r7 - r11
        L_0x011b:
            int r0 = (int) r7
            if (r0 == 0) goto L_0x014a
            float r3 = r13.D
            r13.C = r3
            int r3 = r13.f
            int r5 = r13.c
            int r3 = r3 + r5
            int r5 = l
            int r5 = r5 / r6
            int r3 = r3 - r5
            int r5 = r13.g
            int r7 = r13.d
            int r5 = r5 + r7
            int r7 = m
            int r7 = r7 / r6
            int r5 = r5 - r7
            r13.b(r0, r3, r5)
            goto L_0x014a
        L_0x0138:
            float r0 = r13.D
            float r3 = r13.C
            float r0 = r0 / r3
            double r7 = (double) r0
            r13.e = r7
            goto L_0x0147
        L_0x0141:
            int r0 = r13.E
            if (r0 != r4) goto L_0x014a
            r13.E = r6
        L_0x0147:
            r13.invalidate()
        L_0x014a:
            int r0 = r13.E
            if (r0 == 0) goto L_0x014f
            return r2
        L_0x014f:
            java.util.List<com.baidu.mapapi.Overlay> r0 = r13.s
            int r0 = r0.size()
            int r0 = r0 - r4
        L_0x0156:
            if (r0 < 0) goto L_0x016c
            java.util.List<com.baidu.mapapi.Overlay> r3 = r13.s
            java.lang.Object r3 = r3.get(r0)
            com.baidu.mapapi.Overlay r3 = (com.baidu.mapapi.Overlay) r3
            com.baidu.mapapi.MapView r5 = r13.r
            boolean r3 = r3.onTouchEvent(r14, r5)
            if (r3 == 0) goto L_0x0169
            return r4
        L_0x0169:
            int r0 = r0 + -1
            goto L_0x0156
        L_0x016c:
            int r0 = r14.getAction()
            if (r0 == 0) goto L_0x02bc
            if (r0 == r4) goto L_0x01a2
            if (r0 == r6) goto L_0x0177
            return r2
        L_0x0177:
            boolean r0 = r13.t
            if (r0 != r4) goto L_0x02eb
            float r0 = r14.getX()
            int r0 = (int) r0
            int r1 = r13.n
            int r0 = r0 - r1
            r13.c = r0
            float r0 = r14.getY()
            int r0 = (int) r0
            int r1 = r13.o
            int r0 = r0 - r1
            r13.d = r0
            r13.invalidate()
            r0 = 3
            float r1 = r14.getX()
            int r1 = (int) r1
            float r14 = r14.getY()
            int r14 = (int) r14
            com.baidu.mapapi.Mj.MapProc(r0, r1, r14)
            goto L_0x02eb
        L_0x01a2:
            boolean r0 = r13.t
            if (r0 != 0) goto L_0x01a7
            return r4
        L_0x01a7:
            r13.t = r2
            int r0 = r13.c
            if (r0 != 0) goto L_0x01b1
            int r0 = r13.d
            if (r0 == 0) goto L_0x01b5
        L_0x01b1:
            r13.c = r2
            r13.d = r2
        L_0x01b5:
            float r0 = r14.getX()
            int r0 = (int) r0
            float r1 = r14.getY()
            int r1 = (int) r1
            boolean r2 = r13.u
            if (r2 == 0) goto L_0x0241
            r2 = 1112014848(0x42480000, float:50.0)
            float r3 = com.baidu.mapapi.Mj.j
            float r3 = r3 * r2
            int r2 = (int) r3
            long r5 = r13.x
            long r7 = r13.w
            long r5 = r5 - r7
            r7 = 1
            r9 = 1000(0x3e8, double:4.94E-321)
            int r3 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r3 >= 0) goto L_0x01f0
            int r3 = r13.n
            int r3 = r0 - r3
            int r3 = java.lang.Math.abs(r3)
            if (r3 >= r2) goto L_0x01f0
            int r3 = r13.o
            int r3 = r1 - r3
            int r3 = java.lang.Math.abs(r3)
            if (r3 >= r2) goto L_0x01f0
            long r5 = r13.v
            long r5 = r5 + r7
            r13.v = r5
        L_0x01f0:
            long r5 = r13.v
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x01fd
            long r2 = java.lang.System.currentTimeMillis()
            r13.w = r2
            goto L_0x0241
        L_0x01fd:
            r7 = 2
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 < 0) goto L_0x0241
            long r5 = java.lang.System.currentTimeMillis()
            r13.x = r5
            long r5 = r13.x
            long r7 = r13.w
            long r5 = r5 - r7
            r7 = 0
            int r3 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r3 >= 0) goto L_0x023b
            int r3 = r13.p
            int r3 = r3 - r0
            int r3 = java.lang.Math.abs(r3)
            if (r3 >= r2) goto L_0x023b
            int r3 = r13.q
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r3 >= r2) goto L_0x023b
            com.baidu.mapapi.MapView r14 = r13.r
            int r14 = r14.getZoomLevel()
            r2 = 18
            if (r14 >= r2) goto L_0x0233
            r13.a((int) r4, (int) r0, (int) r1)
        L_0x0233:
            r13.v = r7
            r13.w = r7
            r13.x = r7
            goto L_0x02eb
        L_0x023b:
            r13.v = r7
            r13.w = r7
            r13.x = r7
        L_0x0241:
            r2 = 1092616192(0x41200000, float:10.0)
            float r3 = com.baidu.mapapi.Mj.j
            float r3 = r3 * r2
            int r2 = (int) r3
            int r3 = r13.n
            int r3 = r3 - r0
            int r3 = java.lang.Math.abs(r3)
            if (r3 >= r2) goto L_0x025e
            int r3 = r13.o
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r3 >= r2) goto L_0x025e
            int r0 = r13.n
            int r1 = r13.o
        L_0x025e:
            r13.p = r0
            r13.q = r1
            com.baidu.mapapi.Mj.n = r0
            com.baidu.mapapi.Mj.o = r1
            r2 = 5
            com.baidu.mapapi.Mj.MapProc(r2, r0, r1)
            int r2 = r13.n
            int r0 = r0 - r2
            int r0 = java.lang.Math.abs(r0)
            r2 = 20
            if (r0 >= r2) goto L_0x02eb
            int r0 = r13.o
            int r1 = r1 - r0
            int r0 = java.lang.Math.abs(r1)
            if (r0 >= r2) goto L_0x02eb
            java.util.List<com.baidu.mapapi.Overlay> r0 = r13.s
            int r0 = r0.size()
            int r0 = r0 - r4
        L_0x0285:
            if (r0 < 0) goto L_0x02eb
            java.util.List<com.baidu.mapapi.Overlay> r1 = r13.s
            java.lang.Object r1 = r1.get(r0)
            com.baidu.mapapi.Overlay r1 = (com.baidu.mapapi.Overlay) r1
            com.baidu.mapapi.MapView r2 = r13.r
            com.baidu.mapapi.Projection r2 = r2.getProjection()
            float r3 = r14.getX()
            int r3 = (int) r3
            float r5 = r14.getY()
            int r5 = (int) r5
            com.baidu.mapapi.GeoPoint r2 = r2.fromPixels(r3, r5)
            boolean r3 = r1 instanceof com.baidu.mapapi.ItemizedOverlay
            if (r3 == 0) goto L_0x02b0
            com.baidu.mapapi.ItemizedOverlay r1 = (com.baidu.mapapi.ItemizedOverlay) r1
            com.baidu.mapapi.MapView r3 = r13.r
            boolean r1 = r1.onTap(r2, r3)
            goto L_0x02b6
        L_0x02b0:
            com.baidu.mapapi.MapView r3 = r13.r
            boolean r1 = r1.onTap(r2, r3)
        L_0x02b6:
            if (r1 == 0) goto L_0x02b9
            return r4
        L_0x02b9:
            int r0 = r0 + -1
            goto L_0x0285
        L_0x02bc:
            float r0 = r14.getX()
            int r0 = (int) r0
            r13.n = r0
            float r0 = r14.getY()
            int r0 = (int) r0
            r13.o = r0
            r13.c = r2
            r13.d = r2
            r13.t = r4
            float r0 = r14.getX()
            int r0 = (int) r0
            com.baidu.mapapi.Mj.l = r0
            float r0 = r14.getY()
            int r0 = (int) r0
            com.baidu.mapapi.Mj.m = r0
            float r0 = r14.getX()
            int r0 = (int) r0
            float r14 = r14.getY()
            int r14 = (int) r14
            com.baidu.mapapi.Mj.MapProc(r1, r0, r14)
        L_0x02eb:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.a.a(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        this.H = i2;
    }

    /* access modifiers changed from: package-private */
    public void b(int i2, int i3, int i4) {
        int minZoomLevel = this.r.getMinZoomLevel();
        int maxZoomLevel = this.r.getMaxZoomLevel();
        int zoomLevel = this.r.getZoomLevel() + i2;
        if (minZoomLevel <= zoomLevel && zoomLevel <= maxZoomLevel) {
            Bundle bundle = new Bundle();
            bundle.putInt("act", PushConstants.PUSHSERVICE_INFO_SENDMESSAGE_BY_BROADCAST);
            bundle.putInt("opt", 10020600);
            bundle.putInt("level", i2);
            bundle.putInt("x", this.f);
            bundle.putInt("y", this.g);
            bundle.putInt("dx", i3);
            bundle.putInt("dy", i4);
            Mj.sendBundle(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void b(Canvas canvas) {
        a(canvas);
        if (this.G || this.e == 1.0d) {
            int i2 = AnonymousClass1.a[this.M.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    c(canvas);
                } else {
                    d(canvas);
                    c(canvas);
                    return;
                }
            }
            d(canvas);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z2) {
        this.G = z2;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.u;
    }

    /* access modifiers changed from: package-private */
    public boolean b(int i2, KeyEvent keyEvent) {
        boolean z2 = false;
        for (int size = this.s.size() - 1; size >= 0; size--) {
            z2 = this.s.get(size).onKeyUp(i2, keyEvent, this.r);
            if (z2) {
                break;
            }
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public boolean b(MotionEvent motionEvent) {
        boolean z2 = false;
        for (int size = this.s.size() - 1; size >= 0; size--) {
            z2 = this.s.get(size).onTrackballEvent(motionEvent, this.r);
            if (z2) {
                break;
            }
        }
        return z2;
    }

    public final List<Overlay> c() {
        return this.s;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        for (int size = this.s.size() - 1; size >= 0; size--) {
            if (this.s.get(size) instanceof MyLocationOverlay) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006d, code lost:
        if (r1 > 0.0d) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007e, code lost:
        if (r0.e > ((double) (-1.0f / ((float) (r1 * 2))))) goto L_0x0080;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r18) {
        /*
            r17 = this;
            r0 = r17
            com.baidu.mapapi.MapView r1 = r0.r
            r1.e()
            int r1 = r0.E
            r2 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0114
            if (r1 == r4) goto L_0x00e6
            r2 = 4621819117588971520(0x4024000000000000, double:10.0)
            r6 = 0
            r8 = 2
            r9 = 4611686018427387904(0x4000000000000000, double:2.0)
            if (r1 == r8) goto L_0x0088
            r11 = 3
            if (r1 == r11) goto L_0x0022
        L_0x001d:
            r17.b((android.graphics.Canvas) r18)
            goto L_0x012d
        L_0x0022:
            int r1 = r0.H
            if (r1 != r4) goto L_0x0034
        L_0x0026:
            r17.b((android.graphics.Canvas) r18)
            int r1 = r0.F
            r0.b(r1, r5, r5)
            r0.E = r5
            r0.F = r5
            goto L_0x012d
        L_0x0034:
            double r11 = r0.e
            double r11 = java.lang.Math.log(r11)
            double r13 = java.lang.Math.log(r9)
            double r11 = r11 / r13
            int r1 = r0.F
            if (r1 <= 0) goto L_0x0050
            double r13 = r0.e
            int r1 = (int) r11
            double r11 = (double) r1
            double r9 = java.lang.Math.pow(r9, r11)
            double r9 = r9 / r2
            double r13 = r13 + r9
            r0.e = r13
            goto L_0x0060
        L_0x0050:
            if (r1 >= 0) goto L_0x0060
            double r1 = r0.e
            int r3 = (int) r11
            double r3 = (double) r3
            double r3 = java.lang.Math.pow(r9, r3)
            r9 = 4626322717216342016(0x4034000000000000, double:20.0)
            double r3 = r3 / r9
            double r1 = r1 - r3
            r0.e = r1
        L_0x0060:
            double r1 = r0.e
            int r3 = r0.F
            int r3 = r3 * 2
            double r3 = (double) r3
            int r9 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r9 >= 0) goto L_0x006f
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 > 0) goto L_0x0080
        L_0x006f:
            int r1 = r0.F
            if (r1 >= 0) goto L_0x0026
            double r2 = r0.e
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r1 = r1 * 2
            float r1 = (float) r1
            float r4 = r4 / r1
            double r6 = (double) r4
            int r1 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x0026
        L_0x0080:
            r17.b((android.graphics.Canvas) r18)
            r17.postInvalidate()
            goto L_0x012d
        L_0x0088:
            int r1 = r0.H
            if (r1 != r4) goto L_0x008f
            r0.E = r5
            goto L_0x001d
        L_0x008f:
            double r11 = r0.e
            double r11 = java.lang.Math.log(r11)
            double r13 = java.lang.Math.log(r9)
            double r11 = r11 / r13
            r13 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r1 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r1 < 0) goto L_0x00a2
            double r13 = r13 + r11
            goto L_0x00a4
        L_0x00a2:
            double r13 = r11 - r13
        L_0x00a4:
            int r1 = (int) r13
            double r13 = (double) r1
            java.lang.Double.isNaN(r13)
            double r15 = r13 - r11
            double r2 = r2 * r15
            int r2 = (int) r2
            if (r2 == 0) goto L_0x00c1
            r3 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            if (r2 <= 0) goto L_0x00b9
            double r11 = r11 + r3
            goto L_0x00ba
        L_0x00b9:
            double r11 = r11 - r3
        L_0x00ba:
            double r1 = java.lang.Math.pow(r9, r11)
            r0.e = r1
            goto L_0x0080
        L_0x00c1:
            double r2 = java.lang.Math.pow(r9, r13)
            r0.e = r2
            r17.b((android.graphics.Canvas) r18)
            int r2 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x00e3
            int r2 = r0.f
            int r3 = r0.c
            int r2 = r2 + r3
            int r3 = l
            int r3 = r3 / r8
            int r2 = r2 - r3
            int r3 = r0.g
            int r4 = r0.d
            int r3 = r3 + r4
            int r4 = m
            int r4 = r4 / r8
            int r3 = r3 - r4
            r0.b(r1, r2, r3)
        L_0x00e3:
            r0.E = r5
            goto L_0x012d
        L_0x00e6:
            int r1 = r0.H
            if (r1 != r4) goto L_0x001d
            short[] r1 = j
            if (r1 == 0) goto L_0x001d
            boolean r1 = r0.a
            if (r1 != r4) goto L_0x001d
            r0.c = r5
            r0.d = r5
            java.nio.ShortBuffer r1 = i
            r1.rewind()
            java.nio.ShortBuffer r1 = i
            short[] r4 = j
            r1.put(r4)
        L_0x0102:
            java.nio.ShortBuffer r1 = i
            r1.rewind()
            android.graphics.Bitmap r1 = h
            java.nio.ShortBuffer r4 = i
            r1.copyPixelsFromBuffer(r4)
            r0.a = r5
            r0.e = r2
            goto L_0x001d
        L_0x0114:
            short[] r1 = j
            if (r1 == 0) goto L_0x001d
            boolean r1 = r0.a
            if (r1 != r4) goto L_0x001d
            r0.c = r5
            r0.d = r5
            java.nio.ShortBuffer r1 = i
            r1.rewind()
            java.nio.ShortBuffer r1 = i
            short[] r4 = j
            r1.put(r4)
            goto L_0x0102
        L_0x012d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.a.onDraw(android.graphics.Canvas):void");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        a(i2, i3, i4 - i2, i5 - i3);
    }
}
