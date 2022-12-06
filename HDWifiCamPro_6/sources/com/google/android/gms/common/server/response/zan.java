package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final class zan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zan> CREATOR = new zao();
    final int zaa;
    private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zab;
    private final String zac;

    zan(int i, ArrayList<zal> arrayList, String str) {
        this.zaa = i;
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            zal zal = arrayList.get(i2);
            String str2 = zal.zab;
            HashMap hashMap2 = new HashMap();
            int size2 = ((ArrayList) Preconditions.checkNotNull(zal.zac)).size();
            for (int i3 = 0; i3 < size2; i3++) {
                zam zam = zal.zac.get(i3);
                hashMap2.put(zam.zab, zam.zac);
            }
            hashMap.put(str2, hashMap2);
        }
        this.zab = hashMap;
        this.zac = (String) Preconditions.checkNotNull(str);
        zad();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String next : this.zab.keySet()) {
            sb.append(next);
            sb.append(":\n");
            Map map = this.zab.get(next);
            for (String str : map.keySet()) {
                sb.append("  ");
                sb.append(str);
                sb.append(": ");
                sb.append(map.get(str));
            }
        }
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        ArrayList arrayList = new ArrayList();
        for (String next : this.zab.keySet()) {
            arrayList.add(new zal(next, this.zab.get(next)));
        }
        SafeParcelWriter.writeTypedList(parcel, 2, arrayList, false);
        SafeParcelWriter.writeString(parcel, 3, this.zac, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zaa() {
        return this.zac;
    }

    public final Map<String, FastJsonResponse.Field<?, ?>> zab(String str) {
        return this.zab.get(str);
    }

    public final void zac() {
        for (String next : this.zab.keySet()) {
            Map map = this.zab.get(next);
            HashMap hashMap = new HashMap();
            for (String str : map.keySet()) {
                hashMap.put(str, ((FastJsonResponse.Field) map.get(str)).zab());
            }
            this.zab.put(next, hashMap);
        }
    }

    public final void zad() {
        for (String str : this.zab.keySet()) {
            Map map = this.zab.get(str);
            for (String str2 : map.keySet()) {
                ((FastJsonResponse.Field) map.get(str2)).zai(this);
            }
        }
    }

    public final void zae(Class<? extends FastJsonResponse> cls, Map<String, FastJsonResponse.Field<?, ?>> map) {
        this.zab.put((String) Preconditions.checkNotNull(cls.getCanonicalName()), map);
    }

    public final boolean zaf(Class<? extends FastJsonResponse> cls) {
        return this.zab.containsKey(Preconditions.checkNotNull(cls.getCanonicalName()));
    }

    public zan(Class<? extends FastJsonResponse> cls) {
        this.zaa = 1;
        this.zab = new HashMap<>();
        this.zac = (String) Preconditions.checkNotNull(cls.getCanonicalName());
    }
}
