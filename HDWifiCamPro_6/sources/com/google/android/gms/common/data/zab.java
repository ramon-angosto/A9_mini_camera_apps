package com.google.android.gms.common.data;

import android.content.ContentValues;
import com.google.android.gms.common.data.DataHolder;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zab extends DataHolder.Builder {
    zab(String[] strArr, String str) {
        super(strArr, (String) null, (zac) null);
    }

    public final DataHolder.Builder withRow(ContentValues contentValues) {
        throw new UnsupportedOperationException("Cannot add data to empty builder");
    }

    public final DataHolder.Builder zaa(HashMap<String, Object> hashMap) {
        throw new UnsupportedOperationException("Cannot add data to empty builder");
    }
}
