package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public abstract class EntityBuffer<T> extends AbstractDataBuffer<T> {
    private boolean zaa = false;
    private ArrayList<Integer> zab;

    protected EntityBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    private final void zab() {
        synchronized (this) {
            if (!this.zaa) {
                int count = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getCount();
                this.zab = new ArrayList<>();
                if (count > 0) {
                    this.zab.add(0);
                    String primaryDataMarkerColumn = getPrimaryDataMarkerColumn();
                    String string = this.mDataHolder.getString(primaryDataMarkerColumn, 0, this.mDataHolder.getWindowIndex(0));
                    int i = 1;
                    while (i < count) {
                        int windowIndex = this.mDataHolder.getWindowIndex(i);
                        String string2 = this.mDataHolder.getString(primaryDataMarkerColumn, i, windowIndex);
                        if (string2 != null) {
                            if (!string2.equals(string)) {
                                this.zab.add(Integer.valueOf(i));
                                string = string2;
                            }
                            i++;
                        } else {
                            StringBuilder sb = new StringBuilder(String.valueOf(primaryDataMarkerColumn).length() + 78);
                            sb.append("Missing value for markerColumn: ");
                            sb.append(primaryDataMarkerColumn);
                            sb.append(", at row: ");
                            sb.append(i);
                            sb.append(", for window: ");
                            sb.append(windowIndex);
                            throw new NullPointerException(sb.toString());
                        }
                    }
                }
                this.zaa = true;
            }
        }
    }

    public final T get(int i) {
        int i2;
        int i3;
        zab();
        int zaa2 = zaa(i);
        int i4 = 0;
        if (i >= 0 && i != this.zab.size()) {
            if (i == this.zab.size() - 1) {
                i3 = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getCount();
                i2 = this.zab.get(i).intValue();
            } else {
                i3 = this.zab.get(i + 1).intValue();
                i2 = this.zab.get(i).intValue();
            }
            int i5 = i3 - i2;
            if (i5 == 1) {
                int zaa3 = zaa(i);
                int windowIndex = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getWindowIndex(zaa3);
                String childDataMarkerColumn = getChildDataMarkerColumn();
                if (childDataMarkerColumn == null || this.mDataHolder.getString(childDataMarkerColumn, zaa3, windowIndex) != null) {
                    i4 = 1;
                }
            } else {
                i4 = i5;
            }
        }
        return getEntry(zaa2, i4);
    }

    /* access modifiers changed from: protected */
    public String getChildDataMarkerColumn() {
        return null;
    }

    public int getCount() {
        zab();
        return this.zab.size();
    }

    /* access modifiers changed from: protected */
    public abstract T getEntry(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract String getPrimaryDataMarkerColumn();

    /* access modifiers changed from: package-private */
    public final int zaa(int i) {
        if (i >= 0 && i < this.zab.size()) {
            return this.zab.get(i).intValue();
        }
        StringBuilder sb = new StringBuilder(53);
        sb.append("Position ");
        sb.append(i);
        sb.append(" is out of bounds for this buffer");
        throw new IllegalArgumentException(sb.toString());
    }
}
