package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T> implements DataBuffer<T> {
    protected final DataHolder zzamz;

    protected AbstractDataBuffer(DataHolder dataHolder) {
        this.zzamz = dataHolder;
        DataHolder dataHolder2 = this.zzamz;
        if (dataHolder2 != null) {
            dataHolder2.zzu(this);
        }
    }

    @Deprecated
    public final void close() {
        release();
    }

    public abstract T get(int i);

    public int getCount() {
        DataHolder dataHolder = this.zzamz;
        if (dataHolder == null) {
            return 0;
        }
        return dataHolder.getCount();
    }

    @Deprecated
    public boolean isClosed() {
        DataHolder dataHolder = this.zzamz;
        return dataHolder == null || dataHolder.isClosed();
    }

    public Iterator<T> iterator() {
        return new zzb(this);
    }

    public void release() {
        DataHolder dataHolder = this.zzamz;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    public Iterator<T> singleRefIterator() {
        return new zzg(this);
    }

    public Bundle zzsO() {
        return this.zzamz.zzsO();
    }
}
