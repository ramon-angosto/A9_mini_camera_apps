package sg.bigo.ads.core.player.a;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import sg.bigo.ads.api.core.c;

public final class d {
    final ExecutorService a = new ThreadPoolExecutor(0, 3, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new sg.bigo.ads.common.f.b("Play"));
    ServerSocket b;
    public int c;
    public h d;
    private final Object e = new Object();
    private final Map<String, e> f = new ConcurrentHashMap();
    private Thread g;

    final class a implements Runnable {
        private final Socket b;

        public a(Socket socket) {
            this.b = socket;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:100:0x0260, code lost:
            sg.bigo.ads.core.player.a.d.a(r5);
            sg.bigo.ads.common.k.a.a(0, 3, "ProxyCache", "Opened connections: " + r4.a());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x0277, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:105:?, code lost:
            sg.bigo.ads.common.k.a.a(0, "ProxyCache", "Closing socket… Socket is closed by client.");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x027e, code lost:
            sg.bigo.ads.core.player.a.d.a(r5);
            sg.bigo.ads.common.k.a.a(0, 3, "ProxyCache", "Opened connections: " + r4.a());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:0x0295, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x0247, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x0249, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:?, code lost:
            sg.bigo.ads.common.k.a.a(0, "ProxyCache", "Error processing request, error message is : " + r0.toString());
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:103:? A[ExcHandler: SocketException (unused java.net.SocketException), SYNTHETIC, Splitter:B:1:0x000c] */
        /* JADX WARNING: Removed duplicated region for block: B:97:0x0249 A[ExcHandler: j (e sg.bigo.ads.core.player.a.j), Splitter:B:1:0x000c] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r21 = this;
                r1 = r21
                java.lang.String r2 = "Opened connections: "
                java.lang.String r3 = "ProxyCache"
                sg.bigo.ads.core.player.a.d r4 = sg.bigo.ads.core.player.a.d.this
                java.net.Socket r5 = r1.b
                r6 = 3
                r7 = 0
                java.io.InputStream r0 = r5.getInputStream()     // Catch:{ SocketException -> 0x0278, j -> 0x0249, IOException -> 0x0247 }
                sg.bigo.ads.core.player.a.b r0 = sg.bigo.ads.core.player.a.b.a(r0)     // Catch:{ SocketException -> 0x0278, j -> 0x0249, IOException -> 0x0247 }
                if (r0 != 0) goto L_0x002d
                sg.bigo.ads.core.player.a.d.a((java.net.Socket) r5)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>(r2)
                int r2 = r4.a()
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                sg.bigo.ads.common.k.a.a(r7, r6, r3, r0)
                return
            L_0x002d:
                java.lang.String r8 = "Request to cache proxy:request="
                java.lang.String r9 = java.lang.String.valueOf(r0)     // Catch:{ SocketException -> 0x0278, j -> 0x0249, IOException -> 0x0247 }
                java.lang.String r8 = r8.concat(r9)     // Catch:{ SocketException -> 0x0278, j -> 0x0249, IOException -> 0x0247 }
                sg.bigo.ads.common.k.a.a(r7, r6, r3, r8)     // Catch:{ SocketException -> 0x0278, j -> 0x0249, IOException -> 0x0247 }
                java.lang.String r8 = r0.a     // Catch:{ SocketException -> 0x0278, j -> 0x0249, IOException -> 0x0247 }
                java.lang.String r8 = sg.bigo.ads.common.utils.o.h(r8)     // Catch:{ SocketException -> 0x0278, j -> 0x0249, IOException -> 0x0247 }
                java.lang.String r9 = "ping"
                boolean r9 = r9.equals(r8)     // Catch:{ SocketException -> 0x0278, j -> 0x0249, IOException -> 0x0247 }
                if (r9 == 0) goto L_0x0078
                java.io.OutputStream r0 = r5.getOutputStream()     // Catch:{ IOException -> 0x0060, SocketException -> 0x0278, j -> 0x0249 }
                java.lang.String r8 = "HTTP/1.1 200 OK\n\n"
                byte[] r8 = r8.getBytes()     // Catch:{ IOException -> 0x0060, SocketException -> 0x0278, j -> 0x0249 }
                r0.write(r8)     // Catch:{ IOException -> 0x0060, SocketException -> 0x0278, j -> 0x0249 }
                java.lang.String r8 = "ping ok"
                byte[] r8 = r8.getBytes()     // Catch:{ IOException -> 0x0060, SocketException -> 0x0278, j -> 0x0249 }
                r0.write(r8)     // Catch:{ IOException -> 0x0060, SocketException -> 0x0278, j -> 0x0249 }
                goto L_0x022c
            L_0x0060:
                r0 = move-exception
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ SocketException -> 0x0278, j -> 0x0249, IOException -> 0x0247 }
                java.lang.String r9 = "Pinger#responseToPing, error message is : "
                r8.<init>(r9)     // Catch:{ SocketException -> 0x0278, j -> 0x0249, IOException -> 0x0247 }
                java.lang.String r0 = r0.toString()     // Catch:{ SocketException -> 0x0278, j -> 0x0249, IOException -> 0x0247 }
                r8.append(r0)     // Catch:{ SocketException -> 0x0278, j -> 0x0249, IOException -> 0x0247 }
                java.lang.String r0 = r8.toString()     // Catch:{ SocketException -> 0x0278, j -> 0x0249, IOException -> 0x0247 }
                sg.bigo.ads.common.k.a.a(r7, r3, r0)     // Catch:{ SocketException -> 0x0278, j -> 0x0249, IOException -> 0x0247 }
                goto L_0x022c
            L_0x0078:
                boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ SocketException -> 0x0278, j -> 0x0249, IOException -> 0x0247 }
                if (r9 != 0) goto L_0x022c
                sg.bigo.ads.core.player.a.e r8 = r4.a((java.lang.String) r8)     // Catch:{ SocketException -> 0x0278, j -> 0x0249, IOException -> 0x0247 }
                boolean r9 = r8.a()     // Catch:{ SocketException -> 0x0278, j -> 0x0249, IOException -> 0x0247 }
                if (r9 != 0) goto L_0x0092
                java.lang.String r0 = "startProcessRequest failed"
                sg.bigo.ads.common.k.a.a(r7, r3, r0)     // Catch:{ SocketException -> 0x0278, j -> 0x0249, IOException -> 0x0247 }
                r8.b()     // Catch:{ SocketException -> 0x0278, j -> 0x0249, IOException -> 0x0247 }
                goto L_0x022c
            L_0x0092:
                long r9 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0225 }
                long r11 = r8.e     // Catch:{ all -> 0x0225 }
                long r9 = r9 - r11
                r11 = 300000(0x493e0, double:1.482197E-318)
                int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                if (r9 <= 0) goto L_0x00b9
                java.util.concurrent.atomic.AtomicInteger r9 = r8.f     // Catch:{ all -> 0x0225 }
                int r9 = r9.getAndSet(r7)     // Catch:{ all -> 0x0225 }
                long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0225 }
                r8.e = r10     // Catch:{ all -> 0x0225 }
                java.lang.String r10 = "reset resetRetryCount="
                java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0225 }
                java.lang.String r9 = r10.concat(r9)     // Catch:{ all -> 0x0225 }
                sg.bigo.ads.common.k.a.a(r7, r6, r3, r9)     // Catch:{ all -> 0x0225 }
            L_0x00b9:
                java.util.concurrent.atomic.AtomicInteger r9 = r8.a     // Catch:{ all -> 0x0225 }
                r9.incrementAndGet()     // Catch:{ all -> 0x0225 }
                sg.bigo.ads.common.d.a r9 = r8.c     // Catch:{ all -> 0x0225 }
                r10 = 1
                if (r9 == 0) goto L_0x0110
                sg.bigo.ads.common.d.a r9 = r8.c     // Catch:{ all -> 0x0225 }
                int r9 = r9.i     // Catch:{ all -> 0x0225 }
                if (r9 != r10) goto L_0x00cb
                r9 = r10
                goto L_0x00cc
            L_0x00cb:
                r9 = r7
            L_0x00cc:
                if (r9 != 0) goto L_0x0110
                sg.bigo.ads.common.d.a r9 = r8.c     // Catch:{ all -> 0x0225 }
                boolean r9 = r9.b()     // Catch:{ all -> 0x0225 }
                if (r9 != 0) goto L_0x0110
                long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0225 }
                long r13 = r8.d     // Catch:{ all -> 0x0225 }
                long r11 = r11 - r13
                r13 = 15000(0x3a98, double:7.411E-320)
                int r9 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                if (r9 <= 0) goto L_0x0110
                java.util.concurrent.atomic.AtomicInteger r9 = r8.f     // Catch:{ all -> 0x0225 }
                int r9 = r9.getAndIncrement()     // Catch:{ all -> 0x0225 }
                if (r9 >= r6) goto L_0x0110
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0225 }
                java.lang.String r11 = "keepDownloadTaskAlive retryCount="
                r9.<init>(r11)     // Catch:{ all -> 0x0225 }
                java.util.concurrent.atomic.AtomicInteger r11 = r8.f     // Catch:{ all -> 0x0225 }
                int r11 = r11.get()     // Catch:{ all -> 0x0225 }
                r9.append(r11)     // Catch:{ all -> 0x0225 }
                java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0225 }
                sg.bigo.ads.common.k.a.a(r7, r6, r3, r9)     // Catch:{ all -> 0x0225 }
                long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0225 }
                r8.d = r11     // Catch:{ all -> 0x0225 }
                sg.bigo.ads.core.player.a.e$1 r9 = new sg.bigo.ads.core.player.a.e$1     // Catch:{ all -> 0x0225 }
                r9.<init>()     // Catch:{ all -> 0x0225 }
                sg.bigo.ads.common.f.c.a(r10, r9)     // Catch:{ all -> 0x0225 }
            L_0x0110:
                sg.bigo.ads.core.player.a.c r9 = r8.b     // Catch:{ all -> 0x0225 }
                java.io.BufferedOutputStream r11 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0225 }
                java.io.OutputStream r12 = r5.getOutputStream()     // Catch:{ all -> 0x0225 }
                r11.<init>(r12)     // Catch:{ all -> 0x0225 }
                java.lang.String r12 = r0.a     // Catch:{ all -> 0x0225 }
                java.lang.String r12 = sg.bigo.ads.common.utils.o.h(r12)     // Catch:{ all -> 0x0225 }
                android.webkit.MimeTypeMap r13 = android.webkit.MimeTypeMap.getSingleton()     // Catch:{ all -> 0x0225 }
                java.lang.String r12 = android.webkit.MimeTypeMap.getFileExtensionFromUrl(r12)     // Catch:{ all -> 0x0225 }
                boolean r14 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0225 }
                if (r14 == 0) goto L_0x0131
                r12 = 0
                goto L_0x0135
            L_0x0131:
                java.lang.String r12 = r13.getMimeTypeFromExtension(r12)     // Catch:{ all -> 0x0225 }
            L_0x0135:
                boolean r13 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0225 }
                if (r13 != 0) goto L_0x013d
                r13 = r10
                goto L_0x013e
            L_0x013d:
                r13 = r7
            L_0x013e:
                sg.bigo.ads.core.player.a.a.a r14 = r9.a     // Catch:{ all -> 0x0225 }
                boolean r14 = r14.c()     // Catch:{ all -> 0x0225 }
                if (r14 == 0) goto L_0x014d
                sg.bigo.ads.core.player.a.a.a r14 = r9.a     // Catch:{ all -> 0x0225 }
                long r14 = r14.a()     // Catch:{ all -> 0x0225 }
                goto L_0x0153
            L_0x014d:
                sg.bigo.ads.core.player.a.a.a r14 = r9.a     // Catch:{ all -> 0x0225 }
                sg.bigo.ads.common.d.a r14 = r14.b     // Catch:{ all -> 0x0225 }
                long r14 = r14.h     // Catch:{ all -> 0x0225 }
            L_0x0153:
                r16 = 0
                int r16 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
                if (r16 < 0) goto L_0x015c
                r16 = r10
                goto L_0x015e
            L_0x015c:
                r16 = r7
            L_0x015e:
                boolean r6 = r0.c     // Catch:{ all -> 0x0225 }
                if (r6 == 0) goto L_0x016c
                r18 = r8
                long r7 = r0.b     // Catch:{ all -> 0x0169 }
                long r7 = r14 - r7
                goto L_0x016f
            L_0x0169:
                r0 = move-exception
                goto L_0x0228
            L_0x016c:
                r18 = r8
                r7 = r14
            L_0x016f:
                if (r16 == 0) goto L_0x0178
                boolean r6 = r0.c     // Catch:{ all -> 0x0169 }
                if (r6 == 0) goto L_0x0178
                r19 = r10
                goto L_0x017a
            L_0x0178:
                r19 = 0
            L_0x017a:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0169 }
                r6.<init>()     // Catch:{ all -> 0x0169 }
                boolean r10 = r0.c     // Catch:{ all -> 0x0169 }
                if (r10 == 0) goto L_0x0186
                java.lang.String r10 = "HTTP/1.1 206 PARTIAL CONTENT\n"
                goto L_0x0188
            L_0x0186:
                java.lang.String r10 = "HTTP/1.1 200 OK\n"
            L_0x0188:
                r6.append(r10)     // Catch:{ all -> 0x0169 }
                java.lang.String r10 = "Accept-Ranges: bytes\n"
                r6.append(r10)     // Catch:{ all -> 0x0169 }
                java.lang.String r10 = ""
                if (r16 == 0) goto L_0x01ab
                java.lang.String r1 = "Content-Length: %d\n"
                r16 = r6
                r20 = r10
                r6 = 1
                java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ all -> 0x0169 }
                java.lang.Long r6 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0169 }
                r7 = 0
                r10[r7] = r6     // Catch:{ all -> 0x0169 }
                r7 = r16
                java.lang.String r10 = sg.bigo.ads.core.player.a.c.a((java.lang.String) r1, (java.lang.Object[]) r10)     // Catch:{ all -> 0x0169 }
                goto L_0x01b0
            L_0x01ab:
                r7 = r6
                r20 = r10
                r10 = r20
            L_0x01b0:
                r7.append(r10)     // Catch:{ all -> 0x0169 }
                if (r19 == 0) goto L_0x01de
                java.lang.String r1 = "Content-Range: bytes %d-%d/%d\n"
                r8 = 3
                java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch:{ all -> 0x0169 }
                r16 = r7
                long r6 = r0.b     // Catch:{ all -> 0x0169 }
                java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0169 }
                r7 = 0
                r10[r7] = r6     // Catch:{ all -> 0x0169 }
                r7 = 1
                long r7 = r14 - r7
                java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0169 }
                r8 = 1
                r10[r8] = r7     // Catch:{ all -> 0x0169 }
                r7 = 2
                java.lang.Long r8 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0169 }
                r10[r7] = r8     // Catch:{ all -> 0x0169 }
                java.lang.String r10 = sg.bigo.ads.core.player.a.c.a((java.lang.String) r1, (java.lang.Object[]) r10)     // Catch:{ all -> 0x0169 }
                r1 = r16
                goto L_0x01e4
            L_0x01de:
                r16 = r7
                r1 = r16
                r10 = r20
            L_0x01e4:
                r1.append(r10)     // Catch:{ all -> 0x0169 }
                if (r13 == 0) goto L_0x01f6
                java.lang.String r7 = "Content-Type: %s\n"
                r8 = 1
                java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x0169 }
                r6 = 0
                r8[r6] = r12     // Catch:{ all -> 0x0169 }
                java.lang.String r10 = sg.bigo.ads.core.player.a.c.a((java.lang.String) r7, (java.lang.Object[]) r8)     // Catch:{ all -> 0x0169 }
                goto L_0x01f8
            L_0x01f6:
                r10 = r20
            L_0x01f8:
                r1.append(r10)     // Catch:{ all -> 0x0169 }
                java.lang.String r7 = "\n"
                r1.append(r7)     // Catch:{ all -> 0x0169 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0169 }
                java.lang.String r7 = "newResponseHeaders ="
                java.lang.String r8 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0169 }
                java.lang.String r7 = r7.concat(r8)     // Catch:{ all -> 0x0169 }
                r6 = 3
                r8 = 0
                sg.bigo.ads.common.k.a.a(r8, r6, r3, r7)     // Catch:{ all -> 0x0169 }
                java.lang.String r7 = "UTF-8"
                byte[] r1 = r1.getBytes(r7)     // Catch:{ all -> 0x0169 }
                r11.write(r1)     // Catch:{ all -> 0x0169 }
                long r0 = r0.b     // Catch:{ all -> 0x0169 }
                r9.a((java.io.OutputStream) r11, (long) r0)     // Catch:{ all -> 0x0169 }
                r18.b()     // Catch:{ SocketException -> 0x0278, j -> 0x0249, IOException -> 0x0247 }
                goto L_0x022c
            L_0x0225:
                r0 = move-exception
                r18 = r8
            L_0x0228:
                r18.b()     // Catch:{ SocketException -> 0x0278, j -> 0x0249, IOException -> 0x0247 }
                throw r0     // Catch:{ SocketException -> 0x0278, j -> 0x0249, IOException -> 0x0247 }
            L_0x022c:
                sg.bigo.ads.core.player.a.d.a((java.net.Socket) r5)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>(r2)
                int r1 = r4.a()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r1 = 3
                r2 = 0
                sg.bigo.ads.common.k.a.a(r2, r1, r3, r0)
                return
            L_0x0245:
                r0 = move-exception
                goto L_0x0296
            L_0x0247:
                r0 = move-exception
                goto L_0x024a
            L_0x0249:
                r0 = move-exception
            L_0x024a:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0245 }
                java.lang.String r7 = "Error processing request, error message is : "
                r1.<init>(r7)     // Catch:{ all -> 0x0245 }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0245 }
                r1.append(r0)     // Catch:{ all -> 0x0245 }
                java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x0245 }
                r1 = 0
                sg.bigo.ads.common.k.a.a(r1, r3, r0)     // Catch:{ all -> 0x0245 }
                sg.bigo.ads.core.player.a.d.a((java.net.Socket) r5)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>(r2)
                int r2 = r4.a()
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                r2 = 3
                sg.bigo.ads.common.k.a.a(r1, r2, r3, r0)
                return
            L_0x0278:
                java.lang.String r0 = "Closing socket… Socket is closed by client."
                r1 = 0
                sg.bigo.ads.common.k.a.a(r1, r3, r0)     // Catch:{ all -> 0x0245 }
                sg.bigo.ads.core.player.a.d.a((java.net.Socket) r5)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>(r2)
                int r2 = r4.a()
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                r2 = 3
                sg.bigo.ads.common.k.a.a(r1, r2, r3, r0)
                return
            L_0x0296:
                sg.bigo.ads.core.player.a.d.a((java.net.Socket) r5)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>(r2)
                int r2 = r4.a()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r2 = 3
                r4 = 0
                sg.bigo.ads.common.k.a.a(r4, r2, r3, r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.player.a.d.a.run():void");
        }
    }

    final class b implements Runnable {
        private final CountDownLatch b;

        public b(CountDownLatch countDownLatch) {
            this.b = countDownLatch;
        }

        public final void run() {
            this.b.countDown();
            d dVar = d.this;
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Socket accept = dVar.b.accept();
                    sg.bigo.ads.common.k.a.a(0, 3, "ProxyCache", "Accept new socket socket=".concat(String.valueOf(accept)));
                    dVar.a.submit(new a(accept));
                } catch (IOException e) {
                    sg.bigo.ads.core.d.a.a((c) null, (int) IronSourceConstants.BN_INSTANCE_LOAD_SUCCESS, 10111, e.toString());
                    sg.bigo.ads.common.k.a.a(0, "ProxyCache", "Error during waiting connection, error message is : " + e.toString());
                    return;
                }
            }
        }
    }

    public d() {
        try {
            this.b = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.c = this.b.getLocalPort();
            f.a("127.0.0.1", this.c);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.g = new Thread(new b(countDownLatch));
            this.g.setName("BGAd-Conn");
            this.g.start();
            countDownLatch.await();
            this.d = new h("127.0.0.1", this.c);
            sg.bigo.ads.common.k.a.a(0, 3, "ProxyCache", "Proxy cache server started. Is it alive? " + this.d.a());
        } catch (IOException | InterruptedException e2) {
            this.a.shutdown();
            sg.bigo.ads.core.d.a.a((c) null, (int) IronSourceConstants.BN_INSTANCE_LOAD_SUCCESS, 10110, "Error starting local proxy server, error message is : " + e2.toString());
            sg.bigo.ads.common.k.a.a(0, "ProxyCache", "Error starting local proxy server, error message is : " + e2.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c A[Catch:{ IOException -> 0x0030 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004c A[Catch:{ IOException -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(java.net.Socket r5) {
        /*
            java.lang.String r0 = "ProxyCache"
            r1 = 0
            boolean r2 = r5.isInputShutdown()     // Catch:{ SocketException -> 0x0021, IOException -> 0x000d }
            if (r2 != 0) goto L_0x0026
            r5.shutdownInput()     // Catch:{ SocketException -> 0x0021, IOException -> 0x000d }
            goto L_0x0026
        L_0x000d:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Error closing socket input stream, error message is "
            r3.<init>(r4)
            java.lang.String r2 = r2.getMessage()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            goto L_0x0023
        L_0x0021:
            java.lang.String r2 = "Releasing input stream… Socket is closed by client."
        L_0x0023:
            sg.bigo.ads.common.k.a.a(r1, r0, r2)
        L_0x0026:
            boolean r2 = r5.isOutputShutdown()     // Catch:{ IOException -> 0x0030 }
            if (r2 != 0) goto L_0x0046
            r5.shutdownOutput()     // Catch:{ IOException -> 0x0030 }
            goto L_0x0046
        L_0x0030:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Failed to close socket on proxy side: {}. It seems client have already closed connection."
            r3.<init>(r4)
            java.lang.String r2 = r2.getMessage()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            sg.bigo.ads.common.k.a.a(r1, r0, r2)
        L_0x0046:
            boolean r2 = r5.isClosed()     // Catch:{ IOException -> 0x0050 }
            if (r2 != 0) goto L_0x004f
            r5.close()     // Catch:{ IOException -> 0x0050 }
        L_0x004f:
            return
        L_0x0050:
            r5 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Error closing socket"
            r2.<init>(r3)
            java.lang.String r5 = r5.getMessage()
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            sg.bigo.ads.common.k.a.a(r1, r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.player.a.d.a(java.net.Socket):void");
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        int i;
        synchronized (this.e) {
            i = 0;
            for (e eVar : this.f.values()) {
                i += eVar.a.get();
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public final e a(String str) {
        e eVar;
        synchronized (this.e) {
            eVar = this.f.get(str);
            if (eVar == null) {
                eVar = new e(str);
                this.f.put(str, eVar);
            }
        }
        return eVar;
    }
}
