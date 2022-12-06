package com.huawei.hms.common.data;

import android.os.Bundle;
import com.huawei.hms.support.api.client.Result;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T> extends Result implements DataBuffer<T> {
    protected final DataHolder mDataHolder;

    protected AbstractDataBuffer(DataHolder dataHolder) {
        this.mDataHolder = dataHolder;
    }

    @Deprecated
    public final void close() {
        release();
    }

    public abstract T get(int i);

    public int getCount() {
        DataHolder dataHolder = this.mDataHolder;
        if (dataHolder == null) {
            return 0;
        }
        return dataHolder.getCount();
    }

    public Bundle getMetadata() {
        return this.mDataHolder.getMetadata();
    }

    @Deprecated
    public boolean isClosed() {
        DataHolder dataHolder = this.mDataHolder;
        if (dataHolder == null) {
            return true;
        }
        return dataHolder.isClosed();
    }

    public Iterator<T> iterator() {
        return new DBInnerIter(this);
    }

    public void release() {
        DataHolder dataHolder = this.mDataHolder;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    public Iterator<T> singleRefIterator() {
        return new SingleRefDBInnerIter(this);
    }
}
