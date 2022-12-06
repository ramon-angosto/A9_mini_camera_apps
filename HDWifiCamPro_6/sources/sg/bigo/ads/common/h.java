package sg.bigo.ads.common;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sg.bigo.ads.common.d;

public final class h {
    public static int a(Parcel parcel) {
        if (parcel.dataAvail() > 0) {
            return parcel.readInt();
        }
        return 0;
    }

    public static String a(Parcel parcel, String str) {
        return parcel.dataAvail() > 0 ? parcel.readString() : str;
    }

    public static <T extends d> List<T> a(Parcel parcel, d.a<T> aVar) {
        ArrayList arrayList = new ArrayList();
        for (int readInt = parcel.readInt(); readInt > 0; readInt--) {
            int readInt2 = parcel.readInt();
            if (readInt2 > parcel.dataAvail()) {
                break;
            }
            if (readInt2 != 0) {
                byte[] bArr = new byte[readInt2];
                parcel.readByteArray(bArr);
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(bArr, 0, readInt2);
                obtain.setDataPosition(0);
                T a = aVar.a();
                a.b(obtain);
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    public static <T extends d> Map<String, T> a(Parcel parcel, d.a<T> aVar, Map<String, T> map) {
        return parcel.dataAvail() > 0 ? b(parcel, aVar) : map;
    }

    public static <T extends d> void a(Parcel parcel, List<T> list) {
        int size = list == null ? 0 : list.size();
        parcel.writeInt(size);
        if (size != 0) {
            for (T t : list) {
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    Parcel obtain = Parcel.obtain();
                    t.a(obtain);
                    byte[] marshall = obtain.marshall();
                    parcel.writeInt(marshall.length);
                    parcel.writeByteArray(marshall);
                }
            }
        }
    }

    public static <T extends d> void a(Parcel parcel, Map<String, T> map) {
        int size = map == null ? 0 : map.size();
        parcel.writeInt(size);
        if (size != 0) {
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                d dVar = (d) next.getValue();
                if (str == null || dVar == null) {
                    parcel.writeInt(0);
                } else {
                    Parcel obtain = Parcel.obtain();
                    dVar.a(obtain);
                    byte[] marshall = obtain.marshall();
                    parcel.writeInt(marshall.length);
                    parcel.writeByteArray(marshall);
                    parcel.writeString(str);
                }
            }
        }
    }

    public static <T extends d> Map<String, T> b(Parcel parcel, d.a<T> aVar) {
        HashMap hashMap = new HashMap();
        for (int readInt = parcel.readInt(); readInt > 0; readInt--) {
            int readInt2 = parcel.readInt();
            if (readInt2 > parcel.dataAvail()) {
                break;
            }
            if (readInt2 != 0) {
                byte[] bArr = new byte[readInt2];
                parcel.readByteArray(bArr);
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(bArr, 0, readInt2);
                T t = null;
                if (aVar != null) {
                    t = aVar.a();
                }
                obtain.setDataPosition(0);
                if (t != null) {
                    t.b(obtain);
                }
                String readString = parcel.readString();
                if (!(readString == null || t == null)) {
                    hashMap.put(readString, t);
                }
            }
        }
        return hashMap;
    }
}
