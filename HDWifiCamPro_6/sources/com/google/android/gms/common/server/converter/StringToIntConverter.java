package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.FieldConverter<String, Integer> {
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new zad();
    final int zaa;
    private final HashMap<String, Integer> zab;
    private final SparseArray<String> zac;

    public StringToIntConverter() {
        this.zaa = 1;
        this.zab = new HashMap<>();
        this.zac = new SparseArray<>();
    }

    public StringToIntConverter add(String str, int i) {
        this.zab.put(str, Integer.valueOf(i));
        this.zac.put(i, str);
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        ArrayList arrayList = new ArrayList();
        for (String next : this.zab.keySet()) {
            arrayList.add(new zac(next, this.zab.get(next).intValue()));
        }
        SafeParcelWriter.writeTypedList(parcel, 2, arrayList, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zaa() {
        return 7;
    }

    public final int zab() {
        return 0;
    }

    public final /* bridge */ /* synthetic */ Object zac(Object obj) {
        Integer num = this.zab.get((String) obj);
        return num == null ? this.zab.get("gms_unknown") : num;
    }

    public final /* bridge */ /* synthetic */ Object zad(Object obj) {
        String str = this.zac.get(((Integer) obj).intValue());
        if (str != null || !this.zab.containsKey("gms_unknown")) {
            return str;
        }
        return "gms_unknown";
    }

    StringToIntConverter(int i, ArrayList<zac> arrayList) {
        this.zaa = i;
        this.zab = new HashMap<>();
        this.zac = new SparseArray<>();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            zac zac2 = arrayList.get(i2);
            add(zac2.zab, zac2.zac);
        }
    }
}
