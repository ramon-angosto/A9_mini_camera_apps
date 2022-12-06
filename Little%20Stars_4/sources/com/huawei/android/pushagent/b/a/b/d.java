package com.huawei.android.pushagent.b.a.b;

import android.content.Context;
import com.huawei.android.pushagent.c.a.a.f;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.f;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManagerFactory;

public class d implements b {
    private Context a;
    private SSLSocket b = null;
    private InputStream c;
    private OutputStream d;

    public d(Context context) {
        this.a = context;
    }

    public synchronized void a() {
        e.a("PushLogAC2705", "enter SSLPushChannel:close()");
        try {
            if (this.c != null) {
                this.c.close();
            }
        } catch (IOException e) {
            try {
                e.c("PushLogAC2705", "close dis error: " + e.toString(), e);
            } catch (Throwable th) {
                this.c = null;
                throw th;
            }
        }
        this.c = null;
        try {
            if (this.d != null) {
                this.d.close();
            }
        } catch (IOException e2) {
            e.c("PushLogAC2705", "close dos error: " + e2.toString(), e2);
        }
        this.d = null;
        try {
            if (this.b != null && !this.b.isClosed()) {
                this.b.close();
            }
        } catch (IOException e3) {
            e.c("PushLogAC2705", "close socket error: " + e3.toString(), e3);
        }
        this.b = null;
    }

    public boolean a(Socket socket) throws Exception {
        if (socket == null || !socket.isConnected()) {
            e.d("PushLogAC2705", "when init SSL Channel, socket is not ready:" + socket);
            return false;
        }
        e.a("PushLogAC2705", "enter SSLChannel:init(" + socket.getRemoteSocketAddress() + ")");
        SSLContext instance = SSLContext.getInstance("TLS");
        TrustManagerFactory instance2 = TrustManagerFactory.getInstance("X509");
        KeyStore instance3 = KeyStore.getInstance("BKS");
        InputStream open = this.a.getAssets().open("rootca_0727.bks");
        try {
            open.reset();
            instance3.load(open, f.b((Context) null, com.huawei.android.pushagent.c.a.d.b()).toCharArray());
            if (open != null) {
                open.close();
            }
            instance2.init(instance3);
            instance.init((KeyManager[]) null, instance2.getTrustManagers(), (SecureRandom) null);
            InetAddress inetAddress = socket.getInetAddress();
            if (inetAddress == null) {
                return false;
            }
            InetSocketAddress inetSocketAddress = new InetSocketAddress(inetAddress, socket.getPort());
            Socket createSocket = instance.getSocketFactory().createSocket(socket, inetAddress.getHostAddress(), socket.getPort(), true);
            if (createSocket instanceof SSLSocket) {
                this.b = (SSLSocket) createSocket;
            }
            SSLSocket sSLSocket = this.b;
            if (sSLSocket == null) {
                return false;
            }
            sSLSocket.setEnabledCipherSuites(f.a.a());
            e.a("PushLogAC2705", "server ip:" + inetSocketAddress.getAddress().getHostAddress() + ",server port:" + inetSocketAddress.getPort() + ",socket ip:" + this.b.getLocalAddress().getHostAddress() + ",socket port:" + this.b.getLocalPort() + ",pkgName:" + this.a.getPackageName());
            this.c = this.b.getInputStream();
            this.d = this.b.getOutputStream();
            this.b.setSoTimeout(0);
            return true;
        } catch (Exception e) {
            throw e;
        } catch (Throwable th) {
            if (open != null) {
                open.close();
            }
            throw th;
        }
    }

    public boolean a(byte[] bArr) throws Exception {
        try {
            if (this.d == null || bArr == null) {
                e.d("PushLogAC2705", "when send msg:" + Arrays.toString(bArr) + " dos is null, or msg is null");
                return false;
            }
            this.d.write(bArr);
            this.d.flush();
            return true;
        } catch (Exception e) {
            e.c("PushLogAC2705", "call send cause:" + e.toString(), e);
            a();
            return false;
        }
    }

    public boolean b() {
        SSLSocket sSLSocket = this.b;
        return (sSLSocket == null || !sSLSocket.isConnected() || this.c == null || this.d == null) ? false : true;
    }

    public Socket c() {
        return this.b;
    }

    public InputStream d() {
        return this.c;
    }
}
