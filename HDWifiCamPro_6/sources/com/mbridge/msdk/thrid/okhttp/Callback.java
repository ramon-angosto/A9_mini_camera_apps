package com.mbridge.msdk.thrid.okhttp;

import java.io.IOException;

public interface Callback {
    void onFailure(Call call, IOException iOException);

    void onResponse(Call call, Response response) throws IOException;
}
