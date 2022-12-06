package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new zaf();
    private static final Builder zaf = new zab(new String[0], (String) null);
    final int zaa;
    Bundle zab;
    int[] zac;
    int zad;
    boolean zae;
    private final String[] zag;
    private final CursorWindow[] zah;
    private final int zai;
    private final Bundle zaj;
    private boolean zak;

    /* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
    public static class Builder {
        /* access modifiers changed from: private */
        public final String[] zaa;
        /* access modifiers changed from: private */
        public final ArrayList<HashMap<String, Object>> zab = new ArrayList<>();
        private final HashMap<Object, Integer> zac = new HashMap<>();

        /* synthetic */ Builder(String[] strArr, String str, zac zac2) {
            this.zaa = (String[]) Preconditions.checkNotNull(strArr);
        }

        public DataHolder build(int i) {
            return new DataHolder(this, i);
        }

        public Builder withRow(ContentValues contentValues) {
            Asserts.checkNotNull(contentValues);
            HashMap hashMap = new HashMap(contentValues.size());
            for (Map.Entry next : contentValues.valueSet()) {
                hashMap.put((String) next.getKey(), next.getValue());
            }
            return zaa(hashMap);
        }

        public Builder zaa(HashMap<String, Object> hashMap) {
            Asserts.checkNotNull(hashMap);
            this.zab.add(hashMap);
            return this;
        }

        public DataHolder build(int i, Bundle bundle) {
            return new DataHolder(this, i, bundle);
        }
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.zae = false;
        this.zak = true;
        this.zaa = i;
        this.zag = strArr;
        this.zah = cursorWindowArr;
        this.zai = i2;
        this.zaj = bundle;
    }

    public static Builder builder(String[] strArr) {
        return new Builder(strArr, (String) null, (zac) null);
    }

    public static DataHolder empty(int i) {
        return new DataHolder(zaf, i, (Bundle) null);
    }

    private final void zae(String str, int i) {
        Bundle bundle = this.zab;
        if (bundle == null || !bundle.containsKey(str)) {
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "No such column: ".concat(valueOf) : new String("No such column: "));
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.zad) {
            throw new CursorIndexOutOfBoundsException(i, this.zad);
        }
    }

    private static CursorWindow[] zaf(Builder builder, int i) {
        if (builder.zaa.length == 0) {
            return new CursorWindow[0];
        }
        ArrayList zab2 = builder.zab;
        int size = zab2.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(builder.zaa.length);
        boolean z = false;
        CursorWindow cursorWindow2 = cursorWindow;
        int i2 = 0;
        while (i2 < size) {
            try {
                if (!cursorWindow2.allocRow()) {
                    StringBuilder sb = new StringBuilder(72);
                    sb.append("Allocating additional cursor window for large data set (row ");
                    sb.append(i2);
                    sb.append(")");
                    Log.d("DataHolder", sb.toString());
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setStartPosition(i2);
                    cursorWindow2.setNumColumns(builder.zaa.length);
                    arrayList.add(cursorWindow2);
                    if (!cursorWindow2.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow2);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) zab2.get(i2);
                int i3 = 0;
                boolean z2 = true;
                while (true) {
                    if (i3 < builder.zaa.length) {
                        if (!z2) {
                            break;
                        }
                        String str = builder.zaa[i3];
                        Object obj = map.get(str);
                        if (obj == null) {
                            z2 = cursorWindow2.putNull(i2, i3);
                        } else if (obj instanceof String) {
                            z2 = cursorWindow2.putString((String) obj, i2, i3);
                        } else if (obj instanceof Long) {
                            z2 = cursorWindow2.putLong(((Long) obj).longValue(), i2, i3);
                        } else if (obj instanceof Integer) {
                            z2 = cursorWindow2.putLong((long) ((Integer) obj).intValue(), i2, i3);
                        } else if (obj instanceof Boolean) {
                            z2 = cursorWindow2.putLong(true != ((Boolean) obj).booleanValue() ? 0 : 1, i2, i3);
                        } else if (obj instanceof byte[]) {
                            z2 = cursorWindow2.putBlob((byte[]) obj, i2, i3);
                        } else if (obj instanceof Double) {
                            z2 = cursorWindow2.putDouble(((Double) obj).doubleValue(), i2, i3);
                        } else if (obj instanceof Float) {
                            z2 = cursorWindow2.putDouble((double) ((Float) obj).floatValue(), i2, i3);
                        } else {
                            String obj2 = obj.toString();
                            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 32 + obj2.length());
                            sb2.append("Unsupported object for column ");
                            sb2.append(str);
                            sb2.append(": ");
                            sb2.append(obj2);
                            throw new IllegalArgumentException(sb2.toString());
                        }
                        i3++;
                    } else if (z2) {
                        z = false;
                    }
                }
                if (!z) {
                    StringBuilder sb3 = new StringBuilder(74);
                    sb3.append("Couldn't populate window data for row ");
                    sb3.append(i2);
                    sb3.append(" - allocating new window.");
                    Log.d("DataHolder", sb3.toString());
                    cursorWindow2.freeLastRow();
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setStartPosition(i2);
                    cursorWindow2.setNumColumns(builder.zaa.length);
                    arrayList.add(cursorWindow2);
                    i2--;
                    z = true;
                    i2++;
                } else {
                    throw new zad("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                }
            } catch (RuntimeException e) {
                int size2 = arrayList.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    ((CursorWindow) arrayList.get(i4)).close();
                }
                throw e;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public void close() {
        synchronized (this) {
            if (!this.zae) {
                this.zae = true;
                int i = 0;
                while (true) {
                    CursorWindow[] cursorWindowArr = this.zah;
                    if (i >= cursorWindowArr.length) {
                        break;
                    }
                    cursorWindowArr[i].close();
                    i++;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        try {
            if (this.zak && this.zah.length > 0 && !isClosed()) {
                close();
                String obj = toString();
                StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 178);
                sb.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb.append(obj);
                sb.append(")");
                Log.e("DataBuffer", sb.toString());
            }
        } finally {
            super.finalize();
        }
    }

    public boolean getBoolean(String str, int i, int i2) {
        zae(str, i);
        return Long.valueOf(this.zah[i2].getLong(i, this.zab.getInt(str))).longValue() == 1;
    }

    public byte[] getByteArray(String str, int i, int i2) {
        zae(str, i);
        return this.zah[i2].getBlob(i, this.zab.getInt(str));
    }

    public int getCount() {
        return this.zad;
    }

    public int getInteger(String str, int i, int i2) {
        zae(str, i);
        return this.zah[i2].getInt(i, this.zab.getInt(str));
    }

    public long getLong(String str, int i, int i2) {
        zae(str, i);
        return this.zah[i2].getLong(i, this.zab.getInt(str));
    }

    public Bundle getMetadata() {
        return this.zaj;
    }

    public int getStatusCode() {
        return this.zai;
    }

    public String getString(String str, int i, int i2) {
        zae(str, i);
        return this.zah[i2].getString(i, this.zab.getInt(str));
    }

    public int getWindowIndex(int i) {
        int length;
        int i2 = 0;
        Preconditions.checkState(i >= 0 && i < this.zad);
        while (true) {
            int[] iArr = this.zac;
            length = iArr.length;
            if (i2 >= length) {
                break;
            } else if (i < iArr[i2]) {
                i2--;
                break;
            } else {
                i2++;
            }
        }
        return i2 == length ? i2 - 1 : i2;
    }

    public boolean hasColumn(String str) {
        return this.zab.containsKey(str);
    }

    public boolean hasNull(String str, int i, int i2) {
        zae(str, i);
        return this.zah[i2].isNull(i, this.zab.getInt(str));
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.zae;
        }
        return z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, this.zag, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zah, i, false);
        SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
        SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zaa);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        if ((i & 1) != 0) {
            close();
        }
    }

    public final double zaa(String str, int i, int i2) {
        zae(str, i);
        return this.zah[i2].getDouble(i, this.zab.getInt(str));
    }

    public final float zab(String str, int i, int i2) {
        zae(str, i);
        return this.zah[i2].getFloat(i, this.zab.getInt(str));
    }

    public final void zac(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        zae(str, i);
        this.zah[i2].copyStringToBuffer(i, this.zab.getInt(str), charArrayBuffer);
    }

    public final void zad() {
        this.zab = new Bundle();
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = this.zag;
            if (i2 >= strArr.length) {
                break;
            }
            this.zab.putInt(strArr[i2], i2);
            i2++;
        }
        this.zac = new int[this.zah.length];
        int i3 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.zah;
            if (i < cursorWindowArr.length) {
                this.zac[i] = i3;
                i3 += this.zah[i].getNumRows() - (i3 - cursorWindowArr[i].getStartPosition());
                i++;
            } else {
                this.zad = i3;
                return;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DataHolder(android.database.Cursor r8, int r9, android.os.Bundle r10) {
        /*
            r7 = this;
            com.google.android.gms.common.sqlite.CursorWrapper r0 = new com.google.android.gms.common.sqlite.CursorWrapper
            r0.<init>(r8)
            java.lang.String[] r8 = r0.getColumnNames()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = r0.getCount()     // Catch:{ all -> 0x0076 }
            android.database.CursorWindow r3 = r0.getWindow()     // Catch:{ all -> 0x0076 }
            r4 = 0
            r5 = 0
            if (r3 == 0) goto L_0x002e
            int r6 = r3.getStartPosition()     // Catch:{ all -> 0x0076 }
            if (r6 != 0) goto L_0x002e
            r3.acquireReference()     // Catch:{ all -> 0x0076 }
            r0.setWindow(r4)     // Catch:{ all -> 0x0076 }
            r1.add(r3)     // Catch:{ all -> 0x0076 }
            int r3 = r3.getNumRows()     // Catch:{ all -> 0x0076 }
            goto L_0x002f
        L_0x002e:
            r3 = r5
        L_0x002f:
            if (r3 >= r2) goto L_0x0063
            boolean r6 = r0.moveToPosition(r3)     // Catch:{ all -> 0x0076 }
            if (r6 == 0) goto L_0x0063
            android.database.CursorWindow r6 = r0.getWindow()     // Catch:{ all -> 0x0076 }
            if (r6 == 0) goto L_0x0044
            r6.acquireReference()     // Catch:{ all -> 0x0076 }
            r0.setWindow(r4)     // Catch:{ all -> 0x0076 }
            goto L_0x004f
        L_0x0044:
            android.database.CursorWindow r6 = new android.database.CursorWindow     // Catch:{ all -> 0x0076 }
            r6.<init>(r5)     // Catch:{ all -> 0x0076 }
            r6.setStartPosition(r3)     // Catch:{ all -> 0x0076 }
            r0.fillWindow(r3, r6)     // Catch:{ all -> 0x0076 }
        L_0x004f:
            int r3 = r6.getNumRows()     // Catch:{ all -> 0x0076 }
            if (r3 != 0) goto L_0x0056
            goto L_0x0063
        L_0x0056:
            r1.add(r6)     // Catch:{ all -> 0x0076 }
            int r3 = r6.getStartPosition()     // Catch:{ all -> 0x0076 }
            int r6 = r6.getNumRows()     // Catch:{ all -> 0x0076 }
            int r3 = r3 + r6
            goto L_0x002f
        L_0x0063:
            r0.close()
            int r0 = r1.size()
            android.database.CursorWindow[] r0 = new android.database.CursorWindow[r0]
            java.lang.Object[] r0 = r1.toArray(r0)
            android.database.CursorWindow[] r0 = (android.database.CursorWindow[]) r0
            r7.<init>((java.lang.String[]) r8, (android.database.CursorWindow[]) r0, (int) r9, (android.os.Bundle) r10)
            return
        L_0x0076:
            r8 = move-exception
            r0.close()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.DataHolder.<init>(android.database.Cursor, int, android.os.Bundle):void");
    }

    private DataHolder(Builder builder, int i, Bundle bundle) {
        this(builder.zaa, zaf(builder, -1), i, (Bundle) null);
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.zae = false;
        this.zak = true;
        this.zaa = 1;
        this.zag = (String[]) Preconditions.checkNotNull(strArr);
        this.zah = (CursorWindow[]) Preconditions.checkNotNull(cursorWindowArr);
        this.zai = i;
        this.zaj = bundle;
        zad();
    }
}
