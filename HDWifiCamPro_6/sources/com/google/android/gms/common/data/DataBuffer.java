package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.api.Releasable;
import java.io.Closeable;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public interface DataBuffer<T> extends Iterable<T>, Releasable, Closeable {
    void close();

    T get(int i);

    int getCount();

    Bundle getMetadata();

    @Deprecated
    boolean isClosed();

    Iterator<T> iterator();

    void release();

    Iterator<T> singleRefIterator();
}
