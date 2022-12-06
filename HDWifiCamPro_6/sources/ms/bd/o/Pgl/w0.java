package ms.bd.o.Pgl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;

public class w0 {
    private static w0 c;
    private Context a = null;
    private List<Integer> b = new ArrayList();

    private w0(Context context) {
        this.a = context;
    }

    public static w0 a(Context context) {
        if (c == null) {
            synchronized (w0.class) {
                if (c == null) {
                    c = new w0(context);
                }
            }
        }
        return c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
        r0 = -10001;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r4 = this;
            monitor-enter(r4)     // Catch:{ Exception -> 0x0013, all -> 0x0011 }
            int r0 = r4.d()     // Catch:{ all -> 0x000e }
            int r1 = r4.c()     // Catch:{ all -> 0x000e }
            monitor-exit(r4)     // Catch:{ all -> 0x000e }
            int r0 = r0 * 10000
            int r0 = r0 + r1
            goto L_0x0015
        L_0x000e:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x000e }
            throw r0     // Catch:{ Exception -> 0x0013, all -> 0x0011 }
        L_0x0011:
            r0 = move-exception
            throw r0
        L_0x0013:
            r0 = -10001(0xffffffffffffd8ef, float:NaN)
        L_0x0015:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            if (r0 != 0) goto L_0x001c
            return
        L_0x001c:
            java.util.List<java.lang.Integer> r1 = r4.b
            r1.add(r0)
            java.util.List<java.lang.Integer> r0 = r4.b     // Catch:{ all -> 0x003f }
            int r0 = r0.size()     // Catch:{ all -> 0x003f }
            r1 = 20
            if (r0 <= r1) goto L_0x003f
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x003f }
            java.util.List<java.lang.Integer> r2 = r4.b     // Catch:{ all -> 0x003f }
            int r3 = r0 + -10
            java.util.List r0 = r2.subList(r3, r0)     // Catch:{ all -> 0x003f }
            r1.<init>(r0)     // Catch:{ all -> 0x003f }
            java.util.List<java.lang.Integer> r0 = r4.b     // Catch:{ all -> 0x003f }
            r0.clear()     // Catch:{ all -> 0x003f }
            r4.b = r1     // Catch:{ all -> 0x003f }
        L_0x003f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bd.o.Pgl.w0.a():void");
    }

    public int b() {
        Intent registerReceiver = this.a.registerReceiver((BroadcastReceiver) null, new IntentFilter((String) pblk.a(16777217, 0, 0, "377329", new byte[]{35, 59, 64, 85, 2, 39, 52, 88, 111, 109, 54, 48, 74, 83, 67, 47, 51, 2, 111, 108, 44, 123, 102, 102, 57, 26, 21, 36, 95, 92, 1, 29, 101, 105, 42, 11, 20})));
        if (registerReceiver == null) {
            return -1;
        }
        int intExtra = registerReceiver.getIntExtra((String) pblk.a(16777217, 0, 0, "ba6883", new byte[]{96, 119, 68, 88, 18, 55}), -1);
        return (intExtra == 2 || intExtra == 5) ? 1 : 0;
    }

    public int c() {
        Intent registerReceiver = this.a.registerReceiver((BroadcastReceiver) null, new IntentFilter((String) pblk.a(16777217, 0, 0, "80674a", new byte[]{40, 60, 65, 81, 4, ByteCompanionObject.MAX_VALUE, 63, 95, 110, 105, 61, 55, 75, 87, 69, 119, 56, 5, 110, 104, 39, 124, 103, 98, 63, 66, 30, 35, 94, 88, 10, 26, 100, 109, 44, 83, 31})));
        if (registerReceiver == null) {
            return -1;
        }
        return Math.round(((((float) registerReceiver.getIntExtra((String) pblk.a(16777217, 0, 0, "c49360", new byte[]{126, 51, 92, 66, 5}), -1)) / ((float) registerReceiver.getIntExtra((String) pblk.a(16777217, 0, 0, "864dbc", new byte[]{58, 55, 70, 28, 88}), -1))) * 100.0f) * 10.0f) / 10;
    }

    public int d() {
        Intent registerReceiver = this.a.registerReceiver((BroadcastReceiver) null, new IntentFilter((String) pblk.a(16777217, 0, 0, "f0700a", new byte[]{118, 60, 64, 86, 0, ByteCompanionObject.MAX_VALUE, 97, 95, 111, 110, 99, 55, 74, 80, 65, 119, 102, 5, 111, 111, 121, 124, 102, 101, 59, 66, 64, 35, 95, 95, 84, 26, 101, 106, 40, 83, 65})));
        if (registerReceiver == null) {
            return -1;
        }
        return registerReceiver.getIntExtra((String) pblk.a(16777217, 0, 0, "a8c62d", new byte[]{96, 54, 5, 69, 10, 118, 102}), -1);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:25|26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0050, code lost:
        return new int[0];
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x004d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int[] e() {
        /*
            r5 = this;
            monitor-enter(r5)
            java.util.List<java.lang.Integer> r0 = r5.b     // Catch:{ all -> 0x0051 }
            int r0 = r0.size()     // Catch:{ all -> 0x0051 }
            r1 = 0
            if (r0 > 0) goto L_0x000e
            int[] r0 = new int[r1]     // Catch:{ all -> 0x0051 }
            monitor-exit(r5)
            return r0
        L_0x000e:
            r2 = 1
            if (r0 != r2) goto L_0x0023
            int[] r0 = new int[r2]     // Catch:{ all -> 0x0051 }
            java.util.List<java.lang.Integer> r2 = r5.b     // Catch:{ all -> 0x0051 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0051 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x0051 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x0051 }
            r0[r1] = r2     // Catch:{ all -> 0x0051 }
            monitor-exit(r5)
            return r0
        L_0x0023:
            java.util.List<java.lang.Integer> r2 = r5.b     // Catch:{ all -> 0x004d }
            int r3 = r0 + -10
            if (r3 <= 0) goto L_0x002a
            goto L_0x002b
        L_0x002a:
            r3 = r1
        L_0x002b:
            java.util.List r0 = r2.subList(r3, r0)     // Catch:{ all -> 0x004d }
            int r2 = r0.size()     // Catch:{ all -> 0x004d }
            int[] r2 = new int[r2]     // Catch:{ all -> 0x004d }
            r3 = r1
        L_0x0036:
            int r4 = r0.size()     // Catch:{ all -> 0x004d }
            if (r3 >= r4) goto L_0x004b
            java.lang.Object r4 = r0.get(r3)     // Catch:{ all -> 0x004d }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x004d }
            int r4 = r4.intValue()     // Catch:{ all -> 0x004d }
            r2[r3] = r4     // Catch:{ all -> 0x004d }
            int r3 = r3 + 1
            goto L_0x0036
        L_0x004b:
            monitor-exit(r5)
            return r2
        L_0x004d:
            int[] r0 = new int[r1]     // Catch:{ all -> 0x0051 }
            monitor-exit(r5)
            return r0
        L_0x0051:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bd.o.Pgl.w0.e():int[]");
    }
}
