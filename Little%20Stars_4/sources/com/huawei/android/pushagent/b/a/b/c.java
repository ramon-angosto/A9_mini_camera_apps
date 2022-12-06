package com.huawei.android.pushagent.b.a.b;

import android.content.Context;
import com.huawei.android.pushagent.c.a.e;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class c implements b {
    Socket a;

    public c(Context context) {
    }

    public void a() throws Exception {
        Socket socket = this.a;
        if (socket != null) {
            socket.close();
        }
    }

    public boolean a(Socket socket) {
        e.a("PushLogAC2705", "enter NormalChannel:init(" + socket.getRemoteSocketAddress() + ")");
        if (!socket.isConnected()) {
            e.d("PushLogAC2705", "when init SSL Channel, socket is not ready:" + socket);
            return false;
        }
        this.a = socket;
        return true;
    }

    public boolean a(byte[] bArr) throws Exception {
        Socket socket = this.a;
        if (socket == null || socket.getOutputStream() == null) {
            e.d("PushLogAC2705", "when call send, socket is not ready!!");
            return false;
        }
        this.a.getOutputStream().write(bArr);
        this.a.getOutputStream().flush();
        return true;
    }

    public boolean b() {
        Socket socket = this.a;
        return socket != null && socket.isConnected();
    }

    public Socket c() {
        return this.a;
    }

    public InputStream d() {
        Socket socket = this.a;
        if (socket == null) {
            return null;
        }
        try {
            return socket.getInputStream();
        } catch (IOException e) {
            e.c("PushLogAC2705", "call socket.getInputStream cause:" + e.toString(), e);
            return null;
        }
    }
}
