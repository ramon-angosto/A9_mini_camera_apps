package com.mbridge.msdk.thrid.okhttp;

import java.net.Socket;
import javax.annotation.Nullable;

public interface Connection {
    @Nullable
    Handshake handshake();

    Protocol protocol();

    Route route();

    Socket socket();
}
