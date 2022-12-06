package com.huawei.hms.common.data;

import android.os.Bundle;
import com.huawei.hms.common.api.Releasable;
import java.util.Iterator;

public interface DataBuffer<T> extends Releasable, Iterable<T> {
    @Deprecated
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
