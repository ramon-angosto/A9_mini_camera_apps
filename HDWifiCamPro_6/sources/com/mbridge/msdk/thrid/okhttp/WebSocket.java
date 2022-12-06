package com.mbridge.msdk.thrid.okhttp;

import com.mbridge.msdk.thrid.okio.ByteString;
import javax.annotation.Nullable;

public interface WebSocket {

    public interface Factory {
        WebSocket newWebSocket(Request request, WebSocketListener webSocketListener);
    }

    void cancel();

    boolean close(int i, @Nullable String str);

    long queueSize();

    Request request();

    boolean send(ByteString byteString);

    boolean send(String str);
}
