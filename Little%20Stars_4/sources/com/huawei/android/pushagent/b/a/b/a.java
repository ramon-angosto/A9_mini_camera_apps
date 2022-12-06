package com.huawei.android.pushagent.b.a.b;

import android.content.Context;
import com.huawei.android.pushagent.c.a.a.f;
import com.huawei.android.pushagent.c.a.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.security.SecureRandom;

public class a implements b {
    private static byte[] b;
    /* access modifiers changed from: private */
    public static byte[] c;
    protected Socket a;
    private Context d;
    /* access modifiers changed from: private */
    public boolean e = false;

    /* renamed from: com.huawei.android.pushagent.b.a.b.a$a  reason: collision with other inner class name */
    private class C0034a extends InputStream {
        private InputStream b;
        private byte[] c = null;
        private int d = 0;

        public C0034a(InputStream inputStream) {
            this.b = inputStream;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
            if (r0 == null) goto L_0x0032;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
            if (r0.length <= 0) goto L_0x0032;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
            r1 = r4.d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0020, code lost:
            if (r1 >= r0.length) goto L_0x002b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0022, code lost:
            r4.d = r1 + 1;
            r0 = r0[r1];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
            return r0 & 255;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
            com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "bufferByte has read end , need read bytes from socket");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
            r4.c = null;
            r4.d = 0;
            r0 = r4.b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
            if (r0 == null) goto L_0x0079;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
            r0 = r0.read();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0040, code lost:
            if (-1 != r0) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
            r0 = "PushLogAC2705";
            r1 = "read -1 from inputstream";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0046, code lost:
            com.huawei.android.pushagent.c.a.e.c(r0, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0049, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x004c, code lost:
            if (48 != r0) goto L_0x0074;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x004e, code lost:
            r4.c = com.huawei.android.pushagent.c.a.a.f.b(com.huawei.android.pushagent.b.a.b.a.b(r4.b), com.huawei.android.pushagent.b.a.b.a.e());
            r0 = r4.c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0060, code lost:
            if (r0 == null) goto L_0x006f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0063, code lost:
            if (r0.length != 0) goto L_0x0066;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0066, code lost:
            r1 = r4.d;
            r4.d = r1 + 1;
            r0 = r0[r1];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x006f, code lost:
            r0 = "PushLogAC2705";
            r1 = "ase decrypt serverkey error";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0074, code lost:
            r0 = "PushLogAC2705";
            r1 = "read secure message error, return -1";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0079, code lost:
            r0 = "PushLogAC2705";
            r1 = "secureInputStream is null, return -1";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
            r0 = r4.c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int read() throws java.io.IOException {
            /*
                r4 = this;
                com.huawei.android.pushagent.b.a.b.a r0 = com.huawei.android.pushagent.b.a.b.a.this
                monitor-enter(r0)
                com.huawei.android.pushagent.b.a.b.a r1 = com.huawei.android.pushagent.b.a.b.a.this     // Catch:{ all -> 0x007e }
                boolean r1 = r1.e     // Catch:{ all -> 0x007e }
                r2 = -1
                if (r1 != 0) goto L_0x0015
                java.lang.String r1 = "PushLogAC2705"
                java.lang.String r3 = "secure socket is not initialized, can not read any data"
                com.huawei.android.pushagent.c.a.e.c(r1, r3)     // Catch:{ all -> 0x007e }
                monitor-exit(r0)     // Catch:{ all -> 0x007e }
                return r2
            L_0x0015:
                monitor-exit(r0)     // Catch:{ all -> 0x007e }
                byte[] r0 = r4.c
                if (r0 == 0) goto L_0x0032
                int r1 = r0.length
                if (r1 <= 0) goto L_0x0032
                int r1 = r4.d
                int r3 = r0.length
                if (r1 >= r3) goto L_0x002b
                int r2 = r1 + 1
                r4.d = r2
                byte r0 = r0[r1]
            L_0x0028:
                r0 = r0 & 255(0xff, float:3.57E-43)
                return r0
            L_0x002b:
                java.lang.String r0 = "PushLogAC2705"
                java.lang.String r1 = "bufferByte has read end , need read bytes from socket"
                com.huawei.android.pushagent.c.a.e.a(r0, r1)
            L_0x0032:
                r0 = 0
                r4.c = r0
                r0 = 0
                r4.d = r0
                java.io.InputStream r0 = r4.b
                if (r0 == 0) goto L_0x0079
                int r0 = r0.read()
                if (r2 != r0) goto L_0x004a
                java.lang.String r0 = "PushLogAC2705"
                java.lang.String r1 = "read -1 from inputstream"
            L_0x0046:
                com.huawei.android.pushagent.c.a.e.c(r0, r1)
                return r2
            L_0x004a:
                r1 = 48
                if (r1 != r0) goto L_0x0074
                java.io.InputStream r0 = r4.b
                byte[] r0 = com.huawei.android.pushagent.b.a.b.a.c((java.io.InputStream) r0)
                byte[] r1 = com.huawei.android.pushagent.b.a.b.a.c
                byte[] r0 = com.huawei.android.pushagent.c.a.a.f.b((byte[]) r0, (byte[]) r1)
                r4.c = r0
                byte[] r0 = r4.c
                if (r0 == 0) goto L_0x006f
                int r1 = r0.length
                if (r1 != 0) goto L_0x0066
                goto L_0x006f
            L_0x0066:
                int r1 = r4.d
                int r2 = r1 + 1
                r4.d = r2
                byte r0 = r0[r1]
                goto L_0x0028
            L_0x006f:
                java.lang.String r0 = "PushLogAC2705"
                java.lang.String r1 = "ase decrypt serverkey error"
                goto L_0x0046
            L_0x0074:
                java.lang.String r0 = "PushLogAC2705"
                java.lang.String r1 = "read secure message error, return -1"
                goto L_0x0046
            L_0x0079:
                java.lang.String r0 = "PushLogAC2705"
                java.lang.String r1 = "secureInputStream is null, return -1"
                goto L_0x0046
            L_0x007e:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x007e }
                goto L_0x0082
            L_0x0081:
                throw r1
            L_0x0082:
                goto L_0x0081
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.b.a.b.a.C0034a.read():int");
        }
    }

    public a(Context context) {
        this.d = context;
    }

    public static void a(InputStream inputStream, byte[] bArr) throws IOException {
        int i = 0;
        while (i < bArr.length) {
            int read = inputStream.read(bArr, i, bArr.length - i);
            if (-1 != read) {
                i += read;
            } else {
                throw new IOException("read -1 reached");
            }
        }
    }

    private byte[] a(Context context) throws IOException {
        byte T = (byte) com.huawei.android.pushagent.b.b.a.a(context).T();
        String U = com.huawei.android.pushagent.b.b.a.a(context).U();
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        e.a("PushLogAC2705", "ready to send SecureChannelReqMessage, save clientKey for decode serverKey");
        b(bArr);
        byte[] a2 = f.a(bArr, U);
        if (a2 == null) {
            e.c("PushLogAC2705", "rsa encrypr clientKey error");
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(20);
        byteArrayOutputStream.write(com.huawei.android.pushagent.c.a.b(a2.length + 1 + 1 + 2));
        byteArrayOutputStream.write(T);
        byteArrayOutputStream.write(a2);
        return byteArrayOutputStream.toByteArray();
    }

    public static synchronized void b(byte[] bArr) {
        synchronized (a.class) {
            if (bArr != null) {
                if (bArr.length != 0) {
                    b = new byte[bArr.length];
                    System.arraycopy(bArr, 0, b, 0, bArr.length);
                    return;
                }
            }
            e.a("PushLogAC2705", "key is null");
        }
    }

    private boolean b(Socket socket) {
        String str;
        if (socket == null) {
            str = "socket is null";
        } else if (socket.isConnected()) {
            return true;
        } else {
            str = "when init Channel, socket is not ready";
        }
        e.c("PushLogAC2705", str);
        return false;
    }

    public static synchronized void c(byte[] bArr) {
        synchronized (a.class) {
            if (bArr != null) {
                if (bArr.length != 0) {
                    c = new byte[bArr.length];
                    System.arraycopy(bArr, 0, c, 0, bArr.length);
                    return;
                }
            }
            e.a("PushLogAC2705", "key is null");
        }
    }

    /* access modifiers changed from: private */
    public static byte[] c(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[2];
        a(inputStream, bArr);
        byte[] bArr2 = new byte[(com.huawei.android.pushagent.c.a.c(bArr) - 3)];
        a(inputStream, bArr2);
        return bArr2;
    }

    private static byte[] d(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(48);
        byte[] a2 = f.a(bArr, c);
        if (a2 == null || a2.length == 0) {
            e.a("PushLogAC2705", "aes encrypt pushMsgData error");
            return new byte[0];
        }
        byteArrayOutputStream.write(com.huawei.android.pushagent.c.a.b(a2.length + 1 + 2));
        byteArrayOutputStream.write(a2);
        return byteArrayOutputStream.toByteArray();
    }

    private static synchronized byte[] f() {
        byte[] bArr;
        synchronized (a.class) {
            bArr = b;
        }
        return bArr;
    }

    public synchronized void a() {
        e.a("PushLogAC2705", "enter pushChannel:close()");
        this.e = false;
        try {
            if (this.a == null) {
                e.c("PushLogAC2705", "socket is null, not need close");
                this.a = null;
                return;
            }
            if (!this.a.isClosed()) {
                this.a.close();
            } else {
                e.c("PushLogAC2705", "socket has been closed");
            }
            this.a = null;
        } catch (IOException e2) {
            try {
                e.c("PushLogAC2705", "close socket error: " + e2.toString(), e2);
            } catch (Throwable th) {
                this.a = null;
                throw th;
            }
        }
    }

    public synchronized boolean a(Socket socket) {
        String str;
        String str2;
        String str3;
        String str4;
        if (!b(socket)) {
            a();
            return false;
        }
        this.a = socket;
        try {
            byte[] a2 = a(this.d);
            OutputStream outputStream = this.a.getOutputStream();
            if (outputStream == null) {
                str3 = "PushLogAC2705";
                str4 = "outputStream is null";
            } else if (a2.length == 0) {
                str3 = "PushLogAC2705";
                str4 = "data is null";
            } else {
                outputStream.write(a2);
                outputStream.flush();
                InputStream inputStream = this.a.getInputStream();
                if (b(socket)) {
                    int read = inputStream.read();
                    if (-1 == read) {
                        str = "PushLogAC2705";
                        str2 = " read -1 when init secure channel, socket maybe closed";
                    } else if (21 == read) {
                        byte[] a3 = a(inputStream);
                        if (a3 != null) {
                            c(f.b(a3, f()));
                            this.e = true;
                            return true;
                        }
                        str = "PushLogAC2705";
                        str2 = "get server key error";
                    } else {
                        str = "PushLogAC2705";
                        str2 = "cmdId is not CMD_SECUREKEYEXCHANGE_RSP";
                    }
                    e.a(str, str2);
                }
                a();
                return false;
            }
            e.c(str3, str4);
        } catch (Exception e2) {
            e.c("PushLogAC2705", "call send cause:" + e2.toString(), e2);
        }
        a();
        return false;
    }

    public synchronized boolean a(byte[] bArr) throws Exception {
        if (this.a == null) {
            e.c("PushLogAC2705", "socket is null");
            return false;
        } else if (!this.e) {
            e.c("PushLogAC2705", "secure socket is not initialized, can not write any data");
            a();
            return false;
        } else {
            try {
                byte[] d2 = d(bArr);
                OutputStream outputStream = this.a.getOutputStream();
                if (outputStream == null) {
                    e.c("PushLogAC2705", "outputStream is null");
                    return false;
                } else if (d2.length == 0) {
                    e.c("PushLogAC2705", "data is null");
                    return false;
                } else {
                    outputStream.write(d2);
                    outputStream.flush();
                    return true;
                }
            } catch (Exception e2) {
                e.c("PushLogAC2705", "call send cause:" + e2.toString(), e2);
                a();
                return false;
            }
        }
    }

    public byte[] a(InputStream inputStream) throws Exception {
        a(inputStream, new byte[2]);
        byte[] bArr = new byte[1];
        a(inputStream, bArr);
        byte b2 = bArr[0];
        e.a("PushLogAC2705", "result is " + b2);
        if (b2 == 0) {
            byte[] bArr2 = new byte[32];
            a(inputStream, bArr2);
            return bArr2;
        }
        e.c("PushLogAC2705", "secure key exchange error");
        return null;
    }

    public boolean b() {
        Socket socket = this.a;
        if (socket != null) {
            return socket.isConnected();
        }
        e.c("PushLogAC2705", "socket is null");
        return false;
    }

    public Socket c() {
        return this.a;
    }

    public InputStream d() {
        try {
            if (this.a != null) {
                return new C0034a(this.a.getInputStream());
            }
            e.c("PushLogAC2705", "socket is null");
            return null;
        } catch (IOException e2) {
            e.c("PushLogAC2705", "call socket.getInputStream cause:" + e2.toString(), e2);
            return null;
        }
    }
}
