package com.mbridge.msdk.foundation.same.net;

import com.mbridge.msdk.foundation.tools.l;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: SocketManager */
public class m {
    private static final String a = m.class.getSimpleName();
    /* access modifiers changed from: private */
    public static String b = l.b("DkPtYdQTLkfAW+xUhoPwLkPTHkJBDkM/Yr5T");
    /* access modifiers changed from: private */
    public static int c = 9377;
    /* access modifiers changed from: private */
    public static volatile AtomicInteger d = new AtomicInteger(1);
    private ExecutorService e;

    /* compiled from: SocketManager */
    private static final class b {
        /* access modifiers changed from: private */
        public static m a = new m();
    }

    public final void a(String str) {
        b = str;
    }

    public final void a(int i) {
        c = i;
    }

    private m() {
        this.e = Executors.newCachedThreadPool();
    }

    public static m a() {
        return b.a;
    }

    public final synchronized void a(String str, e eVar) {
        this.e.execute(new a(str, eVar));
    }

    /* compiled from: SocketManager */
    private class a implements Runnable {
        private String b;
        private ByteBuffer c;
        private OutputStream d;
        private boolean e = false;
        private e f;
        private Socket g;

        a(String str, e eVar) {
            this.b = str;
            this.e = false;
            this.f = eVar;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:30|31|(1:33)|34|(2:36|37)) */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0110, code lost:
            if (r8.f != null) goto L_0x0112;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0112, code lost:
            r8.f.a(new com.mbridge.msdk.foundation.same.net.a.a(2, new com.mbridge.msdk.foundation.same.net.f.c(com.bytedance.sdk.openadsdk.TTAdConstant.DEEPLINK_FALLBACK_CODE, (byte[]) null, (java.util.List<com.mbridge.msdk.foundation.same.net.c.b>) null)));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0130, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0131, code lost:
            r1 = r8.g;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0133, code lost:
            if (r1 != null) goto L_0x0135;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0139, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x013a, code lost:
            r1.printStackTrace();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x013d, code lost:
            r8.f = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x013f, code lost:
            throw r0;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x010e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r8 = this;
                r0 = 404(0x194, float:5.66E-43)
                r1 = 2
                r2 = 0
                java.net.Socket r3 = new java.net.Socket     // Catch:{ all -> 0x010e }
                java.lang.String r4 = com.mbridge.msdk.foundation.same.net.m.b     // Catch:{ all -> 0x010e }
                int r5 = com.mbridge.msdk.foundation.same.net.m.c     // Catch:{ all -> 0x010e }
                r3.<init>(r4, r5)     // Catch:{ all -> 0x010e }
                r8.g = r3     // Catch:{ all -> 0x010e }
                java.net.Socket r3 = r8.g     // Catch:{ all -> 0x010e }
                r4 = 15000(0x3a98, float:2.102E-41)
                r3.setSoTimeout(r4)     // Catch:{ all -> 0x010e }
                java.net.Socket r3 = r8.g     // Catch:{ all -> 0x010e }
                java.io.OutputStream r3 = r3.getOutputStream()     // Catch:{ all -> 0x010e }
                r8.d = r3     // Catch:{ all -> 0x010e }
                r3 = 8
                byte[] r4 = new byte[r3]     // Catch:{ all -> 0x010e }
                java.nio.ByteBuffer r4 = java.nio.ByteBuffer.wrap(r4)     // Catch:{ all -> 0x010e }
                r8.c = r4     // Catch:{ all -> 0x010e }
                java.nio.ByteBuffer r4 = r8.c     // Catch:{ all -> 0x010e }
                java.nio.ByteOrder r5 = java.nio.ByteOrder.BIG_ENDIAN     // Catch:{ all -> 0x010e }
                r4.order(r5)     // Catch:{ all -> 0x010e }
                java.nio.ByteBuffer r4 = r8.c     // Catch:{ all -> 0x010e }
                r5 = 1
                r4.put(r5)     // Catch:{ all -> 0x010e }
                java.lang.String r4 = r8.b     // Catch:{ all -> 0x010e }
                boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x010e }
                if (r4 == 0) goto L_0x0047
                java.nio.ByteBuffer r4 = r8.c     // Catch:{ all -> 0x010e }
                r4.put(r5)     // Catch:{ all -> 0x010e }
                goto L_0x0053
            L_0x0047:
                java.nio.ByteBuffer r4 = r8.c     // Catch:{ all -> 0x010e }
                boolean r6 = r8.e     // Catch:{ all -> 0x010e }
                if (r6 == 0) goto L_0x004f
                r6 = 3
                goto L_0x0050
            L_0x004f:
                r6 = r1
            L_0x0050:
                r4.put(r6)     // Catch:{ all -> 0x010e }
            L_0x0053:
                java.nio.ByteBuffer r4 = r8.c     // Catch:{ all -> 0x010e }
                java.util.concurrent.atomic.AtomicInteger r6 = com.mbridge.msdk.foundation.same.net.m.d     // Catch:{ all -> 0x010e }
                int r6 = r6.getAndIncrement()     // Catch:{ all -> 0x010e }
                short r6 = (short) r6     // Catch:{ all -> 0x010e }
                r4.putShort(r6)     // Catch:{ all -> 0x010e }
                java.lang.String r4 = r8.b     // Catch:{ all -> 0x010e }
                boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x010e }
                r6 = 0
                if (r4 == 0) goto L_0x007b
                java.nio.ByteBuffer r4 = r8.c     // Catch:{ all -> 0x010e }
                r4.putInt(r6)     // Catch:{ all -> 0x010e }
                java.io.OutputStream r4 = r8.d     // Catch:{ all -> 0x010e }
                java.nio.ByteBuffer r7 = r8.c     // Catch:{ all -> 0x010e }
                byte[] r7 = r7.array()     // Catch:{ all -> 0x010e }
                r4.write(r7)     // Catch:{ all -> 0x010e }
                goto L_0x009d
            L_0x007b:
                java.lang.String r4 = r8.b     // Catch:{ all -> 0x010e }
                byte[] r4 = r4.getBytes()     // Catch:{ all -> 0x010e }
                int r4 = r4.length     // Catch:{ all -> 0x010e }
                java.nio.ByteBuffer r7 = r8.c     // Catch:{ all -> 0x010e }
                r7.putInt(r4)     // Catch:{ all -> 0x010e }
                java.io.OutputStream r4 = r8.d     // Catch:{ all -> 0x010e }
                java.nio.ByteBuffer r7 = r8.c     // Catch:{ all -> 0x010e }
                byte[] r7 = r7.array()     // Catch:{ all -> 0x010e }
                r4.write(r7)     // Catch:{ all -> 0x010e }
                java.io.OutputStream r4 = r8.d     // Catch:{ all -> 0x010e }
                java.lang.String r7 = r8.b     // Catch:{ all -> 0x010e }
                byte[] r7 = r7.getBytes()     // Catch:{ all -> 0x010e }
                r4.write(r7)     // Catch:{ all -> 0x010e }
            L_0x009d:
                java.io.OutputStream r4 = r8.d     // Catch:{ all -> 0x010e }
                r4.flush()     // Catch:{ all -> 0x010e }
                java.net.Socket r4 = r8.g     // Catch:{ all -> 0x010e }
                java.io.InputStream r4 = r4.getInputStream()     // Catch:{ all -> 0x010e }
                byte[] r3 = new byte[r3]     // Catch:{ all -> 0x010e }
                int r7 = r3.length     // Catch:{ all -> 0x010e }
                r4.read(r3, r6, r7)     // Catch:{ all -> 0x010e }
                java.nio.ByteBuffer r3 = java.nio.ByteBuffer.wrap(r3)     // Catch:{ all -> 0x010e }
                r8.c = r3     // Catch:{ all -> 0x010e }
                java.nio.ByteBuffer r3 = r8.c     // Catch:{ all -> 0x010e }
                java.nio.ByteOrder r7 = java.nio.ByteOrder.BIG_ENDIAN     // Catch:{ all -> 0x010e }
                r3.order(r7)     // Catch:{ all -> 0x010e }
                java.nio.ByteBuffer r3 = r8.c     // Catch:{ all -> 0x010e }
                r7 = 4
                int r3 = r3.getInt(r7)     // Catch:{ all -> 0x010e }
                byte[] r7 = new byte[r3]     // Catch:{ all -> 0x010e }
                r4.read(r7, r6, r3)     // Catch:{ all -> 0x010e }
                if (r3 < r5) goto L_0x00e2
                byte r3 = r7[r6]     // Catch:{ all -> 0x010e }
                if (r3 != r5) goto L_0x00e2
                com.mbridge.msdk.foundation.same.net.e r3 = r8.f     // Catch:{ all -> 0x010e }
                if (r3 == 0) goto L_0x00f5
                com.mbridge.msdk.foundation.same.net.e r3 = r8.f     // Catch:{ all -> 0x010e }
                com.mbridge.msdk.foundation.same.net.f.c r5 = new com.mbridge.msdk.foundation.same.net.f.c     // Catch:{ all -> 0x010e }
                r6 = 200(0xc8, float:2.8E-43)
                r5.<init>(r6, r2, r2)     // Catch:{ all -> 0x010e }
                com.mbridge.msdk.foundation.same.net.k r5 = com.mbridge.msdk.foundation.same.net.k.a(r2, r5)     // Catch:{ all -> 0x010e }
                r3.a(r5)     // Catch:{ all -> 0x010e }
                goto L_0x00f5
            L_0x00e2:
                com.mbridge.msdk.foundation.same.net.e r3 = r8.f     // Catch:{ all -> 0x010e }
                if (r3 == 0) goto L_0x00f5
                com.mbridge.msdk.foundation.same.net.e r3 = r8.f     // Catch:{ all -> 0x010e }
                com.mbridge.msdk.foundation.same.net.a.a r5 = new com.mbridge.msdk.foundation.same.net.a.a     // Catch:{ all -> 0x010e }
                com.mbridge.msdk.foundation.same.net.f.c r6 = new com.mbridge.msdk.foundation.same.net.f.c     // Catch:{ all -> 0x010e }
                r6.<init>(r0, r2, r2)     // Catch:{ all -> 0x010e }
                r5.<init>(r1, r6)     // Catch:{ all -> 0x010e }
                r3.a((com.mbridge.msdk.foundation.same.net.a.a) r5)     // Catch:{ all -> 0x010e }
            L_0x00f5:
                java.net.Socket r3 = r8.g     // Catch:{ all -> 0x010e }
                r3.close()     // Catch:{ all -> 0x010e }
                r8.c = r2     // Catch:{ all -> 0x010e }
                r4.close()     // Catch:{ all -> 0x010e }
                java.io.OutputStream r3 = r8.d     // Catch:{ all -> 0x010e }
                r3.close()     // Catch:{ all -> 0x010e }
                java.net.Socket r0 = r8.g
                if (r0 == 0) goto L_0x012d
                r0.close()     // Catch:{ IOException -> 0x010c }
                goto L_0x012d
            L_0x010c:
                r0 = move-exception
                goto L_0x012a
            L_0x010e:
                com.mbridge.msdk.foundation.same.net.e r3 = r8.f     // Catch:{ all -> 0x0130 }
                if (r3 == 0) goto L_0x0121
                com.mbridge.msdk.foundation.same.net.e r3 = r8.f     // Catch:{ all -> 0x0130 }
                com.mbridge.msdk.foundation.same.net.a.a r4 = new com.mbridge.msdk.foundation.same.net.a.a     // Catch:{ all -> 0x0130 }
                com.mbridge.msdk.foundation.same.net.f.c r5 = new com.mbridge.msdk.foundation.same.net.f.c     // Catch:{ all -> 0x0130 }
                r5.<init>(r0, r2, r2)     // Catch:{ all -> 0x0130 }
                r4.<init>(r1, r5)     // Catch:{ all -> 0x0130 }
                r3.a((com.mbridge.msdk.foundation.same.net.a.a) r4)     // Catch:{ all -> 0x0130 }
            L_0x0121:
                java.net.Socket r0 = r8.g
                if (r0 == 0) goto L_0x012d
                r0.close()     // Catch:{ IOException -> 0x0129 }
                goto L_0x012d
            L_0x0129:
                r0 = move-exception
            L_0x012a:
                r0.printStackTrace()
            L_0x012d:
                r8.f = r2
                return
            L_0x0130:
                r0 = move-exception
                java.net.Socket r1 = r8.g
                if (r1 == 0) goto L_0x013d
                r1.close()     // Catch:{ IOException -> 0x0139 }
                goto L_0x013d
            L_0x0139:
                r1 = move-exception
                r1.printStackTrace()
            L_0x013d:
                r8.f = r2
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.m.a.run():void");
        }
    }
}
