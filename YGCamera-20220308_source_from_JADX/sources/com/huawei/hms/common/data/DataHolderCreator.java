package com.huawei.hms.common.data;

import android.os.Parcelable;

public final class DataHolderCreator implements Parcelable.Creator<DataHolder> {
    /* JADX WARNING: type inference failed for: r1v3, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.huawei.hms.common.data.DataHolder createFromParcel(android.os.Parcel r11) {
        /*
            r10 = this;
            int r0 = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r11)
            r1 = 0
            r2 = 0
            r5 = r1
            r6 = r5
            r8 = r6
            r4 = 0
            r7 = 0
        L_0x000b:
            if (r2 > r0) goto L_0x004f
            int r1 = r11.dataPosition()
            if (r1 >= r0) goto L_0x004f
            int r2 = r2 + 1
            int r1 = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.readHeader(r11)
            int r3 = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            r9 = 1000(0x3e8, float:1.401E-42)
            if (r3 == r9) goto L_0x004a
            r9 = 1
            if (r3 == r9) goto L_0x0045
            r9 = 2
            if (r3 == r9) goto L_0x003b
            r9 = 3
            if (r3 == r9) goto L_0x0036
            r9 = 4
            if (r3 == r9) goto L_0x0031
            com.huawei.hms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r11, r1)
            goto L_0x000b
        L_0x0031:
            android.os.Bundle r8 = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.createBundle(r11, r1)
            goto L_0x000b
        L_0x0036:
            int r7 = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.readInt(r11, r1)
            goto L_0x000b
        L_0x003b:
            android.os.Parcelable$Creator r3 = android.database.CursorWindow.CREATOR
            java.lang.Object[] r1 = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.createTypedArray(r11, r1, r3)
            r6 = r1
            android.database.CursorWindow[] r6 = (android.database.CursorWindow[]) r6
            goto L_0x000b
        L_0x0045:
            java.lang.String[] r5 = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.createStringArray(r11, r1)
            goto L_0x000b
        L_0x004a:
            int r4 = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.readInt(r11, r1)
            goto L_0x000b
        L_0x004f:
            com.huawei.hms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r11, r0)
            com.huawei.hms.common.data.DataHolder r11 = new com.huawei.hms.common.data.DataHolder
            r3 = r11
            r3.<init>((int) r4, (java.lang.String[]) r5, (android.database.CursorWindow[]) r6, (int) r7, (android.os.Bundle) r8)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.data.DataHolderCreator.createFromParcel(android.os.Parcel):com.huawei.hms.common.data.DataHolder");
    }

    public final DataHolder[] newArray(int i) {
        return new DataHolder[i];
    }
}
