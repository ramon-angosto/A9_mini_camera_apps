package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public abstract class DataBufferRef {
    protected final DataHolder mDataHolder;
    protected int mDataRow;
    private int zaa;

    public DataBufferRef(DataHolder dataHolder, int i) {
        this.mDataHolder = (DataHolder) Preconditions.checkNotNull(dataHolder);
        zaa(i);
    }

    /* access modifiers changed from: protected */
    public void copyToBuffer(String str, CharArrayBuffer charArrayBuffer) {
        this.mDataHolder.zac(str, this.mDataRow, this.zaa, charArrayBuffer);
    }

    public boolean equals(Object obj) {
        if (obj instanceof DataBufferRef) {
            DataBufferRef dataBufferRef = (DataBufferRef) obj;
            if (!Objects.equal(Integer.valueOf(dataBufferRef.mDataRow), Integer.valueOf(this.mDataRow)) || !Objects.equal(Integer.valueOf(dataBufferRef.zaa), Integer.valueOf(this.zaa)) || dataBufferRef.mDataHolder != this.mDataHolder) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean getBoolean(String str) {
        return this.mDataHolder.getBoolean(str, this.mDataRow, this.zaa);
    }

    /* access modifiers changed from: protected */
    public byte[] getByteArray(String str) {
        return this.mDataHolder.getByteArray(str, this.mDataRow, this.zaa);
    }

    /* access modifiers changed from: protected */
    public int getDataRow() {
        return this.mDataRow;
    }

    /* access modifiers changed from: protected */
    public double getDouble(String str) {
        return this.mDataHolder.zaa(str, this.mDataRow, this.zaa);
    }

    /* access modifiers changed from: protected */
    public float getFloat(String str) {
        return this.mDataHolder.zab(str, this.mDataRow, this.zaa);
    }

    /* access modifiers changed from: protected */
    public int getInteger(String str) {
        return this.mDataHolder.getInteger(str, this.mDataRow, this.zaa);
    }

    /* access modifiers changed from: protected */
    public long getLong(String str) {
        return this.mDataHolder.getLong(str, this.mDataRow, this.zaa);
    }

    /* access modifiers changed from: protected */
    public String getString(String str) {
        return this.mDataHolder.getString(str, this.mDataRow, this.zaa);
    }

    public boolean hasColumn(String str) {
        return this.mDataHolder.hasColumn(str);
    }

    /* access modifiers changed from: protected */
    public boolean hasNull(String str) {
        return this.mDataHolder.hasNull(str, this.mDataRow, this.zaa);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.mDataRow), Integer.valueOf(this.zaa), this.mDataHolder);
    }

    public boolean isDataValid() {
        return !this.mDataHolder.isClosed();
    }

    /* access modifiers changed from: protected */
    public Uri parseUri(String str) {
        String string = this.mDataHolder.getString(str, this.mDataRow, this.zaa);
        if (string == null) {
            return null;
        }
        return Uri.parse(string);
    }

    /* access modifiers changed from: protected */
    public final void zaa(int i) {
        boolean z = false;
        if (i >= 0 && i < this.mDataHolder.getCount()) {
            z = true;
        }
        Preconditions.checkState(z);
        this.mDataRow = i;
        this.zaa = this.mDataHolder.getWindowIndex(i);
    }
}
