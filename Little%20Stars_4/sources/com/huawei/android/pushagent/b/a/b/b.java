package com.huawei.android.pushagent.b.a.b;

import java.io.InputStream;
import java.net.Socket;

public interface b {

    public enum a {
        ChannelType_Normal,
        ChannelType_SSL,
        ChannelType_SSL_Resume,
        ChannelType_Secure
    }

    void a() throws Exception;

    boolean a(Socket socket) throws Exception;

    boolean a(byte[] bArr) throws Exception;

    boolean b();

    Socket c();

    InputStream d();
}
