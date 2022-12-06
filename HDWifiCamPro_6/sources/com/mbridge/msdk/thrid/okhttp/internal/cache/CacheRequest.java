package com.mbridge.msdk.thrid.okhttp.internal.cache;

import com.mbridge.msdk.thrid.okio.Sink;
import java.io.IOException;

public interface CacheRequest {
    void abort();

    Sink body() throws IOException;
}
