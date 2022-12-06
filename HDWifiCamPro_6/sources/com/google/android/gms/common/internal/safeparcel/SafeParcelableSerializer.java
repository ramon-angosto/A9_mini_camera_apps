package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.common.zzag;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public final class SafeParcelableSerializer {
    private SafeParcelableSerializer() {
    }

    public static <T extends SafeParcelable> T deserializeFromBytes(byte[] bArr, Parcelable.Creator<T> creator) {
        Preconditions.checkNotNull(creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        T t = (SafeParcelable) creator.createFromParcel(obtain);
        obtain.recycle();
        return t;
    }

    public static <T extends SafeParcelable> T deserializeFromIntentExtra(Intent intent, String str, Parcelable.Creator<T> creator) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            return null;
        }
        return deserializeFromBytes(byteArrayExtra, creator);
    }

    public static <T extends SafeParcelable> T deserializeFromString(String str, Parcelable.Creator<T> creator) {
        return deserializeFromBytes(Base64Utils.decodeUrlSafe(str), creator);
    }

    @Deprecated
    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBundle(Bundle bundle, String str, Parcelable.Creator<T> creator) {
        ArrayList arrayList = (ArrayList) bundle.getSerializable(str);
        if (arrayList == null) {
            return null;
        }
        ArrayList<T> arrayList2 = new ArrayList<>(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add(deserializeFromBytes((byte[]) arrayList.get(i), creator));
        }
        return arrayList2;
    }

    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBundleSafe(Bundle bundle, String str, Parcelable.Creator<T> creator) {
        return deserializeIterableFromBytes(bundle.getByteArray(str), creator);
    }

    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBytes(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, length);
        obtain.setDataPosition(0);
        try {
            ArrayList<T> arrayList = new ArrayList<>();
            obtain.readTypedList(arrayList, creator);
            return arrayList;
        } finally {
            obtain.recycle();
        }
    }

    @Deprecated
    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromIntentExtra(Intent intent, String str, Parcelable.Creator<T> creator) {
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra(str);
        if (arrayList == null) {
            return null;
        }
        ArrayList<T> arrayList2 = new ArrayList<>(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add(deserializeFromBytes((byte[]) arrayList.get(i), creator));
        }
        return arrayList2;
    }

    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromIntentExtraSafe(Intent intent, String str, Parcelable.Creator<T> creator) {
        return deserializeIterableFromBytes(intent.getByteArrayExtra(str), creator);
    }

    @Deprecated
    public static <T extends SafeParcelable> void serializeIterableToBundle(Iterable<T> iterable, Bundle bundle, String str) {
        ArrayList arrayList = new ArrayList();
        for (T serializeToBytes : iterable) {
            arrayList.add(serializeToBytes(serializeToBytes));
        }
        bundle.putSerializable(str, arrayList);
    }

    public static <T extends SafeParcelable> void serializeIterableToBundleSafe(Iterable<T> iterable, Bundle bundle, String str) {
        bundle.putByteArray(str, zza(iterable));
    }

    @Deprecated
    public static <T extends SafeParcelable> void serializeIterableToIntentExtra(Iterable<T> iterable, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        for (T serializeToBytes : iterable) {
            arrayList.add(serializeToBytes(serializeToBytes));
        }
        intent.putExtra(str, arrayList);
    }

    public static <T extends SafeParcelable> void serializeIterableToIntentExtraSafe(Iterable<T> iterable, Intent intent, String str) {
        intent.putExtra(str, zza(iterable));
    }

    public static <T extends SafeParcelable> byte[] serializeToBytes(T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public static <T extends SafeParcelable> void serializeToIntentExtra(T t, Intent intent, String str) {
        intent.putExtra(str, serializeToBytes(t));
    }

    public static <T extends SafeParcelable> String serializeToString(T t) {
        return Base64Utils.encodeUrlSafe(serializeToBytes(t));
    }

    private static <T extends SafeParcelable> byte[] zza(Iterable<T> iterable) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeTypedList(zzag.zzj(iterable));
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }
}
