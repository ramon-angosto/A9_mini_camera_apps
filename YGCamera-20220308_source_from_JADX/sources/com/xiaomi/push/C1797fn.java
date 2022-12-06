package com.xiaomi.push;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.xiaomi.push.fn */
public class C1797fn {

    /* renamed from: a */
    public static final byte[] f2406a = {80, 85, 83, 72};

    /* renamed from: a */
    private byte f2407a;

    /* renamed from: a */
    private int f2408a;

    /* renamed from: a */
    private short f2409a;

    /* renamed from: b */
    private byte[] f2410b;

    /* renamed from: com.xiaomi.push.fn$a */
    public static class C1798a {

        /* renamed from: a */
        public static final C1800c f2411a = new C1800c();

        /* renamed from: a */
        public static final C1801d f2412a = new C1801d();

        /* renamed from: a */
        public static byte[] m3575a(byte[] bArr) {
            return m3576a(bArr, f2412a);
        }

        /* renamed from: a */
        public static byte[] m3576a(byte[] bArr, C1799b bVar) {
            if (!C1797fn.m3571a(bArr)) {
                return bArr;
            }
            C1797fn a = C1797fn.m3571a(bArr);
            return (C1797fn.m3567a(a) == 0 || C1797fn.m3567a(a) != bVar.mo17636a()) ? C1797fn.m3567a(a) : bVar.mo17637a(C1797fn.m3567a(a), C1797fn.m3567a(a));
        }
    }

    /* renamed from: com.xiaomi.push.fn$b */
    public interface C1799b {
        /* renamed from: a */
        byte mo17636a();

        /* renamed from: a */
        byte[] mo17637a(byte[] bArr, int i);
    }

    /* renamed from: com.xiaomi.push.fn$c */
    public static final class C1800c {
    }

    /* renamed from: com.xiaomi.push.fn$d */
    public static final class C1801d implements C1799b {
        /* renamed from: a */
        public byte mo17636a() {
            return 2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x001c A[SYNTHETIC, Splitter:B:15:0x001c] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0023 A[SYNTHETIC, Splitter:B:21:0x0023] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public byte[] mo17637a(byte[] r4, int r5) {
            /*
                r3 = this;
                r0 = 0
                java.util.zip.GZIPInputStream r1 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0020, all -> 0x0019 }
                java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0020, all -> 0x0019 }
                r2.<init>(r4)     // Catch:{ IOException -> 0x0020, all -> 0x0019 }
                r1.<init>(r2, r5)     // Catch:{ IOException -> 0x0020, all -> 0x0019 }
                byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x0017, all -> 0x0014 }
                r1.read(r5)     // Catch:{ IOException -> 0x0017, all -> 0x0014 }
                r1.close()     // Catch:{ IOException -> 0x0013 }
            L_0x0013:
                return r5
            L_0x0014:
                r4 = move-exception
                r0 = r1
                goto L_0x001a
            L_0x0017:
                r0 = r1
                goto L_0x0021
            L_0x0019:
                r4 = move-exception
            L_0x001a:
                if (r0 == 0) goto L_0x001f
                r0.close()     // Catch:{ IOException -> 0x001f }
            L_0x001f:
                throw r4
            L_0x0020:
            L_0x0021:
                if (r0 == 0) goto L_0x0026
                r0.close()     // Catch:{ IOException -> 0x0026 }
            L_0x0026:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1797fn.C1801d.mo17637a(byte[], int):byte[]");
        }
    }

    protected C1797fn(byte b, int i, byte[] bArr) {
        this(1, b, i, bArr);
    }

    protected C1797fn(short s, byte b, int i, byte[] bArr) {
        this.f2409a = 1;
        this.f2409a = s;
        this.f2407a = b;
        this.f2408a = i;
        this.f2410b = bArr;
    }

    /* renamed from: a */
    public static C1797fn m3569a(byte b, int i, byte[] bArr) {
        return new C1797fn(b, i, bArr);
    }

    /* renamed from: a */
    public static C1797fn m3570a(short s, byte b, int i, byte[] bArr) {
        return new C1797fn(s, b, i, bArr);
    }

    /* renamed from: a */
    public static C1797fn m3571a(byte[] bArr) {
        if (!m3571a(bArr)) {
            return m3569a((byte) 0, bArr.length, bArr);
        }
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
        order.getInt();
        short s = order.getShort();
        byte b = order.get();
        int i = order.getInt();
        byte[] bArr2 = new byte[order.getInt()];
        order.get(bArr2);
        return m3570a(s, b, i, bArr2);
    }

    /* renamed from: a */
    public static boolean m3572a(byte[] bArr) {
        byte[] bArr2 = f2406a;
        return m3573a(bArr2, bArr, bArr2.length);
    }

    /* renamed from: a */
    public static boolean m3573a(byte[] bArr, byte[] bArr2, int i) {
        if (bArr.length < i || bArr2.length < i) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
