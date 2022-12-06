package com.bytedance.sdk.openadsdk.core.b;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.m;

/* compiled from: TouchInfoHelper */
public class f {
    public static int j = m.b();
    private static float m = 0.0f;
    private static float n = 0.0f;
    private static float o = 0.0f;
    private static float p = 0.0f;
    private static long q = 0;
    public float a = -1.0f;
    public float b = -1.0f;
    public float c = -1.0f;
    public float d = -1.0f;
    public long e = -1;
    public long f = -1;
    public int g = -1;
    public int h = -1024;
    public int i = -1;
    public boolean k = true;
    public SparseArray<c.a> l = new SparseArray<>();
    private int r = 0;
    private int s = 0;

    static {
        if (m.a() != null) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006f, code lost:
        if (p <= ((float) r2)) goto L_0x0072;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.view.MotionEvent r13) {
        /*
            r12 = this;
            int r0 = r13.getDeviceId()
            r12.h = r0
            r0 = 0
            int r1 = r13.getToolType(r0)
            r12.g = r1
            int r1 = r13.getSource()
            r12.i = r1
            int r1 = r13.getActionMasked()
            r2 = 3
            r3 = 1
            if (r1 == 0) goto L_0x00dd
            if (r1 == r3) goto L_0x00a5
            r4 = 2
            if (r1 == r4) goto L_0x0028
            if (r1 == r2) goto L_0x0026
            r0 = -1
        L_0x0023:
            r5 = r0
            goto L_0x0119
        L_0x0026:
            r0 = 4
            goto L_0x0023
        L_0x0028:
            float r1 = o
            float r2 = r13.getX()
            float r5 = m
            float r2 = r2 - r5
            float r2 = java.lang.Math.abs(r2)
            float r1 = r1 + r2
            o = r1
            float r1 = p
            float r2 = r13.getY()
            float r5 = n
            float r2 = r2 - r5
            float r2 = java.lang.Math.abs(r2)
            float r1 = r1 + r2
            p = r1
            float r1 = r13.getX()
            m = r1
            float r1 = r13.getY()
            n = r1
            long r1 = java.lang.System.currentTimeMillis()
            long r5 = q
            long r1 = r1 - r5
            r5 = 200(0xc8, double:9.9E-322)
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x0072
            float r1 = o
            int r2 = j
            float r5 = (float) r2
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 > 0) goto L_0x0073
            float r1 = p
            float r2 = (float) r2
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x0072
            goto L_0x0073
        L_0x0072:
            r3 = r4
        L_0x0073:
            float r1 = r13.getRawX()
            r12.c = r1
            float r1 = r13.getRawY()
            r12.d = r1
            float r1 = r12.c
            int r2 = r12.r
            float r2 = (float) r2
            float r1 = r1 - r2
            float r1 = java.lang.Math.abs(r1)
            int r2 = j
            float r2 = (float) r2
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x00a1
            float r1 = r12.d
            int r2 = r12.s
            float r2 = (float) r2
            float r1 = r1 - r2
            float r1 = java.lang.Math.abs(r1)
            int r2 = j
            float r2 = (float) r2
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 < 0) goto L_0x00a3
        L_0x00a1:
            r12.k = r0
        L_0x00a3:
            r5 = r3
            goto L_0x0119
        L_0x00a5:
            float r1 = r13.getRawX()
            r12.c = r1
            float r1 = r13.getRawY()
            r12.d = r1
            long r3 = java.lang.System.currentTimeMillis()
            r12.f = r3
            float r1 = r12.c
            int r3 = r12.r
            float r3 = (float) r3
            float r1 = r1 - r3
            float r1 = java.lang.Math.abs(r1)
            int r3 = j
            float r3 = (float) r3
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x00d9
            float r1 = r12.d
            int r3 = r12.s
            float r3 = (float) r3
            float r1 = r1 - r3
            float r1 = java.lang.Math.abs(r1)
            int r3 = j
            float r3 = (float) r3
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x00db
        L_0x00d9:
            r12.k = r0
        L_0x00db:
            r5 = r2
            goto L_0x0119
        L_0x00dd:
            float r1 = r13.getRawX()
            int r1 = (int) r1
            r12.r = r1
            float r1 = r13.getRawY()
            int r1 = (int) r1
            r12.s = r1
            float r1 = r13.getRawX()
            r12.a = r1
            float r1 = r13.getRawY()
            r12.b = r1
            long r1 = java.lang.System.currentTimeMillis()
            r12.e = r1
            int r1 = r13.getToolType(r0)
            r12.g = r1
            int r1 = r13.getDeviceId()
            r12.h = r1
            int r1 = r13.getSource()
            r12.i = r1
            long r1 = java.lang.System.currentTimeMillis()
            q = r1
            r12.k = r3
            goto L_0x0023
        L_0x0119:
            android.util.SparseArray<com.bytedance.sdk.openadsdk.core.b.c$a> r0 = r12.l
            int r1 = r13.getActionMasked()
            com.bytedance.sdk.openadsdk.core.b.c$a r2 = new com.bytedance.sdk.openadsdk.core.b.c$a
            float r3 = r13.getSize()
            double r6 = (double) r3
            float r13 = r13.getPressure()
            double r8 = (double) r13
            long r10 = java.lang.System.currentTimeMillis()
            r4 = r2
            r4.<init>(r5, r6, r8, r10)
            r0.put(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.b.f.a(android.view.MotionEvent):void");
    }
}
