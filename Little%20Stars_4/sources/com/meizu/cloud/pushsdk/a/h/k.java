package com.meizu.cloud.pushsdk.a.h;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public interface k extends Closeable, Flushable {
    void a(a aVar, long j) throws IOException;

    void close() throws IOException;

    void flush() throws IOException;
}
