package com.huawei.hms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import com.huawei.hms.common.sqlite.HMSCursorWrapper;
import com.huawei.hms.support.log.HMSLog;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new DataHolderCreator();
    private static final String TAG = "DataHolder";
    public static final String TYPE_BOOLEAN = "type_boolean";
    public static final String TYPE_BYTE_ARRAY = "type_byte_array";
    public static final String TYPE_DOUBLE = "type_double";
    public static final String TYPE_FLOAT = "type_float";
    public static final String TYPE_INT = "type_int";
    public static final String TYPE_LONG = "type_long";
    public static final String TYPE_STRING = "type_string";
    private static final Builder builder = new DataHolderBuilderCreator(new String[0], (String) null);
    private String[] columns;
    private Bundle columnsBundle;
    private CursorWindow[] cursorWindows;
    private int dataCount;
    private boolean isInstance;
    private boolean mClosed;
    private Bundle metadata;
    private int[] perCursorCounts;
    private int statusCode;
    private int version;

    public static class Builder {
        /* access modifiers changed from: private */
        public String[] builderColumns;
        /* access modifiers changed from: private */
        public final ArrayList<HashMap<String, Object>> dataCollectionList;
        private final String type;
        private final HashMap<Object, Integer> typeAndDataCollectionCountMapping;

        public DataHolder build(int i) {
            return new DataHolder(this, i, (Bundle) null);
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0032  */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x003d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.huawei.hms.common.data.DataHolder.Builder setDataForContentValuesHashMap(java.util.HashMap<java.lang.String, java.lang.Object> r5) {
            /*
                r4 = this;
                java.lang.String r0 = "contentValuesHashMap cannot be null"
                com.huawei.hms.common.internal.Preconditions.checkNotNull(r5, r0)
                java.lang.String r0 = r4.type
                r1 = 0
                if (r0 == 0) goto L_0x002f
                java.lang.Object r0 = r5.get(r0)
                if (r0 == 0) goto L_0x002f
                java.util.HashMap<java.lang.Object, java.lang.Integer> r2 = r4.typeAndDataCollectionCountMapping
                java.lang.Object r2 = r2.get(r0)
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0020
                int r1 = r2.intValue()
                r0 = 1
                goto L_0x0030
            L_0x0020:
                java.util.HashMap<java.lang.Object, java.lang.Integer> r2 = r4.typeAndDataCollectionCountMapping
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r3 = r4.dataCollectionList
                int r3 = r3.size()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                r2.put(r0, r3)
            L_0x002f:
                r0 = 0
            L_0x0030:
                if (r0 == 0) goto L_0x003d
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r0 = r4.dataCollectionList
                r0.remove(r1)
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r0 = r4.dataCollectionList
                r0.add(r1, r5)
                goto L_0x0042
            L_0x003d:
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r0 = r4.dataCollectionList
                r0.add(r5)
            L_0x0042:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.data.DataHolder.Builder.setDataForContentValuesHashMap(java.util.HashMap):com.huawei.hms.common.data.DataHolder$Builder");
        }

        public Builder withRow(ContentValues contentValues) {
            Preconditions.checkNotNull(contentValues, "contentValues cannot be null");
            HashMap hashMap = new HashMap(contentValues.size());
            for (Map.Entry next : contentValues.valueSet()) {
                hashMap.put(next.getKey(), next.getValue());
            }
            return setDataForContentValuesHashMap(hashMap);
        }

        private Builder(String[] strArr, String str) {
            Preconditions.checkNotNull(strArr, "builderColumnsP cannot be null");
            this.builderColumns = strArr;
            this.dataCollectionList = new ArrayList<>();
            this.type = str;
            this.typeAndDataCollectionCountMapping = new HashMap<>();
        }

        public DataHolder build(int i, Bundle bundle) {
            return new DataHolder(this, i, bundle, -1);
        }

        Builder(String[] strArr, String str, DataHolderBuilderCreator dataHolderBuilderCreator) {
            this(strArr, (String) null);
        }
    }

    public static class DataHolderException extends RuntimeException {
        public DataHolderException(String str) {
            super(str);
        }
    }

    public static Builder builder(String[] strArr) {
        return new Builder(strArr, (String) null);
    }

    private void checkAvailable(String str, int i) {
        String str2;
        Bundle bundle = this.columnsBundle;
        if (bundle == null || !bundle.containsKey(str)) {
            str2 = "cannot find column: " + str;
        } else if (isClosed()) {
            str2 = "buffer has been closed";
        } else if (i < 0 || i >= this.dataCount) {
            str2 = "row is out of index:" + i;
        } else {
            str2 = "";
        }
        Preconditions.checkArgument(str2.isEmpty(), str2);
    }

    public static DataHolder empty(int i) {
        return new DataHolder(builder, i, (Bundle) null);
    }

    private static CursorWindow[] getCursorWindows(HMSCursorWrapper hMSCursorWrapper) {
        int i;
        ArrayList arrayList = new ArrayList();
        try {
            int count = hMSCursorWrapper.getCount();
            CursorWindow window = hMSCursorWrapper.getWindow();
            if (window == null || window.getStartPosition() != 0) {
                i = 0;
            } else {
                window.acquireReference();
                hMSCursorWrapper.setWindow((CursorWindow) null);
                arrayList.add(window);
                i = window.getNumRows();
            }
            arrayList.addAll(iterCursorWrapper(hMSCursorWrapper, i, count));
            return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
        } catch (Throwable th) {
            HMSLog.m1377e(TAG, "fail to getCursorWindows: " + th.getMessage());
            return new CursorWindow[0];
        } finally {
            hMSCursorWrapper.close();
        }
    }

    private static ArrayList<CursorWindow> iterCursorWindow(Builder builder2, int i, List list) {
        ArrayList<CursorWindow> arrayList = new ArrayList<>();
        CursorWindow cursorWindow = new CursorWindow((String) null);
        cursorWindow.setNumColumns(builder2.builderColumns.length);
        arrayList.add(cursorWindow);
        CursorWindow cursorWindow2 = cursorWindow;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            try {
                if (!cursorWindow2.allocRow()) {
                    HMSLog.m1374d(TAG, "Failed to allocate a row");
                    cursorWindow2 = new CursorWindow((String) null);
                    cursorWindow2.setStartPosition(i2);
                    cursorWindow2.setNumColumns(builder2.builderColumns.length);
                    if (!cursorWindow2.allocRow()) {
                        HMSLog.m1377e(TAG, "Failed to retry to allocate a row");
                        return arrayList;
                    }
                    arrayList.add(cursorWindow2);
                }
                HashMap hashMap = (HashMap) list.get(i2);
                int i3 = 0;
                boolean z = true;
                while (true) {
                    if (i3 >= builder2.builderColumns.length) {
                        break;
                    }
                    z = putValue(cursorWindow2, hashMap.get(builder2.builderColumns[i3]), i2, i3);
                    if (!z) {
                        break;
                    }
                    i3++;
                }
                if (!z) {
                    HMSLog.m1374d(TAG, "fail to put data for row " + i2);
                    cursorWindow2.freeLastRow();
                    CursorWindow cursorWindow3 = new CursorWindow((String) null);
                    cursorWindow3.setStartPosition(i2);
                    cursorWindow3.setNumColumns(builder2.builderColumns.length);
                    arrayList.add(cursorWindow3);
                    break;
                }
                i2++;
            } catch (RuntimeException e) {
                Iterator<CursorWindow> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().close();
                }
                throw e;
            }
        }
        return arrayList;
    }

    private static ArrayList<CursorWindow> iterCursorWrapper(HMSCursorWrapper hMSCursorWrapper, int i, int i2) {
        ArrayList<CursorWindow> arrayList = new ArrayList<>();
        while (i < i2 && hMSCursorWrapper.moveToPosition(i)) {
            CursorWindow window = hMSCursorWrapper.getWindow();
            if (window == null) {
                window = new CursorWindow((String) null);
                window.setStartPosition(i);
                hMSCursorWrapper.fillWindow(i, window);
            } else {
                window.acquireReference();
                hMSCursorWrapper.setWindow((CursorWindow) null);
            }
            if (window.getNumRows() == 0) {
                break;
            }
            arrayList.add(window);
            i = window.getNumRows() + window.getStartPosition();
        }
        return arrayList;
    }

    private static boolean putValue(CursorWindow cursorWindow, Object obj, int i, int i2) throws IllegalArgumentException {
        if (obj == null) {
            return cursorWindow.putNull(i, i2);
        }
        if (obj instanceof Boolean) {
            return cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i, i2);
        } else if (obj instanceof Integer) {
            return cursorWindow.putLong((long) ((Integer) obj).intValue(), i, i2);
        } else {
            if (obj instanceof Long) {
                return cursorWindow.putLong(((Long) obj).longValue(), i, i2);
            }
            if (obj instanceof Float) {
                return cursorWindow.putDouble((double) ((Float) obj).floatValue(), i, i2);
            }
            if (obj instanceof Double) {
                return cursorWindow.putDouble(((Double) obj).doubleValue(), i, i2);
            }
            if (obj instanceof String) {
                return cursorWindow.putString((String) obj, i, i2);
            }
            if (obj instanceof byte[]) {
                return cursorWindow.putBlob((byte[]) obj, i, i2);
            }
            throw new IllegalArgumentException("unsupported type for column: " + obj);
        }
    }

    public final synchronized void close() {
        if (!this.mClosed) {
            for (CursorWindow close : this.cursorWindows) {
                close.close();
            }
            this.mClosed = true;
        }
    }

    public final void collectColumsAndCount() {
        this.columnsBundle = new Bundle();
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = this.columns;
            if (i2 >= strArr.length) {
                break;
            }
            this.columnsBundle.putInt(strArr[i2], i2);
            i2++;
        }
        this.perCursorCounts = new int[this.cursorWindows.length];
        int i3 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.cursorWindows;
            if (i < cursorWindowArr.length) {
                this.perCursorCounts[i] = i3;
                i3 = cursorWindowArr[i].getStartPosition() + this.cursorWindows[i].getNumRows();
                i++;
            } else {
                this.dataCount = i3;
                return;
            }
        }
    }

    public final void copyToBuffer(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        checkAvailable(str, i);
        this.cursorWindows[i2].copyStringToBuffer(i, this.columnsBundle.getInt(str), charArrayBuffer);
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        if (this.isInstance && this.cursorWindows.length > 0 && !isClosed()) {
            close();
        }
        super.finalize();
    }

    public final int getCount() {
        return this.dataCount;
    }

    public final Bundle getMetadata() {
        return this.metadata;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getValue(java.lang.String r4, int r5, int r6, java.lang.String r7) {
        /*
            r3 = this;
            int r0 = r7.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1092271849: goto L_0x0046;
                case -870070237: goto L_0x003c;
                case -675993238: goto L_0x0032;
                case 445002870: goto L_0x0028;
                case 519136353: goto L_0x001e;
                case 878975158: goto L_0x0014;
                case 1300508295: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0050
        L_0x000a:
            java.lang.String r0 = "type_byte_array"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0050
            r7 = 6
            goto L_0x0051
        L_0x0014:
            java.lang.String r0 = "type_string"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0050
            r7 = 2
            goto L_0x0051
        L_0x001e:
            java.lang.String r0 = "type_long"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0050
            r7 = 1
            goto L_0x0051
        L_0x0028:
            java.lang.String r0 = "type_double"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0050
            r7 = 5
            goto L_0x0051
        L_0x0032:
            java.lang.String r0 = "type_int"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0050
            r7 = 0
            goto L_0x0051
        L_0x003c:
            java.lang.String r0 = "type_boolean"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0050
            r7 = 3
            goto L_0x0051
        L_0x0046:
            java.lang.String r0 = "type_float"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0050
            r7 = 4
            goto L_0x0051
        L_0x0050:
            r7 = -1
        L_0x0051:
            switch(r7) {
                case 0: goto L_0x00da;
                case 1: goto L_0x00c4;
                case 2: goto L_0x00b2;
                case 3: goto L_0x0094;
                case 4: goto L_0x007e;
                case 5: goto L_0x0068;
                case 6: goto L_0x0056;
                default: goto L_0x0054;
            }
        L_0x0054:
            r4 = 0
            return r4
        L_0x0056:
            r3.checkAvailable(r4, r5)
            android.database.CursorWindow[] r7 = r3.cursorWindows
            r6 = r7[r6]
            android.os.Bundle r7 = r3.columnsBundle
            int r4 = r7.getInt(r4)
            byte[] r4 = r6.getBlob(r5, r4)
            return r4
        L_0x0068:
            r3.checkAvailable(r4, r5)
            android.database.CursorWindow[] r7 = r3.cursorWindows
            r6 = r7[r6]
            android.os.Bundle r7 = r3.columnsBundle
            int r4 = r7.getInt(r4)
            double r4 = r6.getDouble(r5, r4)
            java.lang.Double r4 = java.lang.Double.valueOf(r4)
            return r4
        L_0x007e:
            r3.checkAvailable(r4, r5)
            android.database.CursorWindow[] r7 = r3.cursorWindows
            r6 = r7[r6]
            android.os.Bundle r7 = r3.columnsBundle
            int r4 = r7.getInt(r4)
            float r4 = r6.getFloat(r5, r4)
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            return r4
        L_0x0094:
            r3.checkAvailable(r4, r5)
            android.database.CursorWindow[] r7 = r3.cursorWindows
            r6 = r7[r6]
            android.os.Bundle r7 = r3.columnsBundle
            int r4 = r7.getInt(r4)
            long r4 = r6.getLong(r5, r4)
            r6 = 1
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x00ac
            goto L_0x00ad
        L_0x00ac:
            r1 = 0
        L_0x00ad:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)
            return r4
        L_0x00b2:
            r3.checkAvailable(r4, r5)
            android.database.CursorWindow[] r7 = r3.cursorWindows
            r6 = r7[r6]
            android.os.Bundle r7 = r3.columnsBundle
            int r4 = r7.getInt(r4)
            java.lang.String r4 = r6.getString(r5, r4)
            return r4
        L_0x00c4:
            r3.checkAvailable(r4, r5)
            android.database.CursorWindow[] r7 = r3.cursorWindows
            r6 = r7[r6]
            android.os.Bundle r7 = r3.columnsBundle
            int r4 = r7.getInt(r4)
            long r4 = r6.getLong(r5, r4)
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            return r4
        L_0x00da:
            r3.checkAvailable(r4, r5)
            android.database.CursorWindow[] r7 = r3.cursorWindows
            r6 = r7[r6]
            android.os.Bundle r7 = r3.columnsBundle
            int r4 = r7.getInt(r4)
            int r4 = r6.getInt(r5, r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.data.DataHolder.getValue(java.lang.String, int, int, java.lang.String):java.lang.Object");
    }

    public final int getWindowIndex(int i) {
        int i2 = 0;
        Preconditions.checkArgument(i >= 0 || i < this.dataCount, "rowIndex is out of index:" + i);
        while (true) {
            int[] iArr = this.perCursorCounts;
            if (i2 >= iArr.length) {
                break;
            } else if (i < iArr[i2]) {
                i2--;
                break;
            } else {
                i2++;
            }
        }
        return i2 == this.perCursorCounts.length ? i2 - 1 : i2;
    }

    public final boolean hasColumn(String str) {
        return this.columnsBundle.containsKey(str);
    }

    public final boolean hasNull(String str, int i, int i2) {
        checkAvailable(str, i);
        return this.cursorWindows[i2].getType(i, this.columnsBundle.getInt(str)) == 0;
    }

    public final synchronized boolean isClosed() {
        return this.mClosed;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, this.columns, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.cursorWindows, i, false);
        SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
        SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.version);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        if ((i & 1) != 0) {
            close();
        }
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mClosed = false;
        this.isInstance = true;
        this.version = i;
        this.columns = strArr;
        this.cursorWindows = cursorWindowArr;
        this.statusCode = i2;
        this.metadata = bundle;
        collectColumsAndCount();
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        Preconditions.checkNotNull(strArr, "columnsP cannot be null");
        Preconditions.checkNotNull(strArr, "cursorWindowP cannot be null");
        this.mClosed = false;
        this.isInstance = true;
        this.version = 1;
        this.columns = strArr;
        this.cursorWindows = cursorWindowArr;
        this.statusCode = i;
        this.metadata = bundle;
        collectColumsAndCount();
    }

    private DataHolder(HMSCursorWrapper hMSCursorWrapper, int i, Bundle bundle) {
        this(hMSCursorWrapper.getColumnNames(), getCursorWindows(hMSCursorWrapper), i, bundle);
    }

    public DataHolder(Cursor cursor, int i, Bundle bundle) {
        this(new HMSCursorWrapper(cursor), i, bundle);
    }

    private DataHolder(Builder builder2, int i, Bundle bundle) {
        this(builder2.builderColumns, getCursorWindows(builder2, -1), i, (Bundle) null);
    }

    private DataHolder(Builder builder2, int i, Bundle bundle, int i2) {
        this(builder2.builderColumns, getCursorWindows(builder2, -1), i, bundle);
    }

    private static CursorWindow[] getCursorWindows(Builder builder2, int i) {
        if (builder2.builderColumns.length == 0) {
            return new CursorWindow[0];
        }
        if (i < 0 || i >= builder2.dataCollectionList.size()) {
            i = builder2.dataCollectionList.size();
        }
        ArrayList<CursorWindow> iterCursorWindow = iterCursorWindow(builder2, i, builder2.dataCollectionList.subList(0, i));
        return (CursorWindow[]) iterCursorWindow.toArray(new CursorWindow[iterCursorWindow.size()]);
    }
}
