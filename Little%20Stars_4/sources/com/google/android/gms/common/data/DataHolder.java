package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@KeepName
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new zze();
    private static final zza zzapm = new zza(new String[0], (String) null) {
        public zza zza(ContentValues contentValues) {
            throw new UnsupportedOperationException("Cannot add data to empty builder");
        }

        public zza zza(HashMap<String, Object> hashMap) {
            throw new UnsupportedOperationException("Cannot add data to empty builder");
        }
    };
    boolean mClosed;
    private final int mVersionCode;
    private final int zzahG;
    private final String[] zzape;
    Bundle zzapf;
    private final CursorWindow[] zzapg;
    private final Bundle zzaph;
    int[] zzapi;
    int zzapj;
    private Object zzapk;
    private boolean zzapl;

    public static class zza {
        /* access modifiers changed from: private */
        public final String[] zzape;
        /* access modifiers changed from: private */
        public final ArrayList<HashMap<String, Object>> zzapn;
        private final String zzapo;
        private final HashMap<Object, Integer> zzapp;
        private boolean zzapq;
        private String zzapr;

        private zza(String[] strArr, String str) {
            this.zzape = (String[]) zzaa.zzz(strArr);
            this.zzapn = new ArrayList<>();
            this.zzapo = str;
            this.zzapp = new HashMap<>();
            this.zzapq = false;
            this.zzapr = null;
        }

        private int zzb(HashMap<String, Object> hashMap) {
            Object obj;
            String str = this.zzapo;
            if (str == null || (obj = hashMap.get(str)) == null) {
                return -1;
            }
            Integer num = this.zzapp.get(obj);
            if (num != null) {
                return num.intValue();
            }
            this.zzapp.put(obj, Integer.valueOf(this.zzapn.size()));
            return -1;
        }

        public zza zza(ContentValues contentValues) {
            com.google.android.gms.common.internal.zzb.zzv(contentValues);
            HashMap hashMap = new HashMap(contentValues.size());
            for (Map.Entry next : contentValues.valueSet()) {
                hashMap.put((String) next.getKey(), next.getValue());
            }
            return zza((HashMap<String, Object>) hashMap);
        }

        public zza zza(HashMap<String, Object> hashMap) {
            com.google.android.gms.common.internal.zzb.zzv(hashMap);
            int zzb = zzb(hashMap);
            if (zzb == -1) {
                this.zzapn.add(hashMap);
            } else {
                this.zzapn.remove(zzb);
                this.zzapn.add(zzb, hashMap);
            }
            this.zzapq = false;
            return this;
        }

        public DataHolder zzbR(int i) {
            return new DataHolder(this, i, (Bundle) null);
        }
    }

    public static class zzb extends RuntimeException {
        public zzb(String str) {
            super(str);
        }
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mClosed = false;
        this.zzapl = true;
        this.mVersionCode = i;
        this.zzape = strArr;
        this.zzapg = cursorWindowArr;
        this.zzahG = i2;
        this.zzaph = bundle;
    }

    private DataHolder(zza zza2, int i, Bundle bundle) {
        this(zza2.zzape, zza(zza2, -1), i, bundle);
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.mClosed = false;
        this.zzapl = true;
        this.mVersionCode = 1;
        this.zzape = (String[]) zzaa.zzz(strArr);
        this.zzapg = (CursorWindow[]) zzaa.zzz(cursorWindowArr);
        this.zzahG = i;
        this.zzaph = bundle;
        zzsT();
    }

    public static DataHolder zza(int i, Bundle bundle) {
        return new DataHolder(zzapm, i, bundle);
    }

    private static CursorWindow[] zza(zza zza2, int i) {
        long j;
        if (zza2.zzape.length == 0) {
            return new CursorWindow[0];
        }
        List zzb2 = (i < 0 || i >= zza2.zzapn.size()) ? zza2.zzapn : zza2.zzapn.subList(0, i);
        int size = zzb2.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(zza2.zzape.length);
        CursorWindow cursorWindow2 = cursorWindow;
        int i2 = 0;
        boolean z = false;
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
                    cursorWindow2.setNumColumns(zza2.zzape.length);
                    arrayList.add(cursorWindow2);
                    if (!cursorWindow2.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow2);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) zzb2.get(i2);
                boolean z2 = true;
                for (int i3 = 0; i3 < zza2.zzape.length && z2; i3++) {
                    String str = zza2.zzape[i3];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z2 = cursorWindow2.putNull(i2, i3);
                    } else if (obj instanceof String) {
                        z2 = cursorWindow2.putString((String) obj, i2, i3);
                    } else {
                        if (obj instanceof Long) {
                            j = ((Long) obj).longValue();
                        } else if (obj instanceof Integer) {
                            z2 = cursorWindow2.putLong((long) ((Integer) obj).intValue(), i2, i3);
                        } else if (obj instanceof Boolean) {
                            j = ((Boolean) obj).booleanValue() ? 1 : 0;
                        } else if (obj instanceof byte[]) {
                            z2 = cursorWindow2.putBlob((byte[]) obj, i2, i3);
                        } else if (obj instanceof Double) {
                            z2 = cursorWindow2.putDouble(((Double) obj).doubleValue(), i2, i3);
                        } else if (obj instanceof Float) {
                            z2 = cursorWindow2.putDouble((double) ((Float) obj).floatValue(), i2, i3);
                        } else {
                            String valueOf = String.valueOf(obj);
                            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(valueOf).length());
                            sb2.append("Unsupported object for column ");
                            sb2.append(str);
                            sb2.append(": ");
                            sb2.append(valueOf);
                            throw new IllegalArgumentException(sb2.toString());
                        }
                        z2 = cursorWindow2.putLong(j, i2, i3);
                    }
                }
                if (z2) {
                    z = false;
                } else if (!z) {
                    StringBuilder sb3 = new StringBuilder(74);
                    sb3.append("Couldn't populate window data for row ");
                    sb3.append(i2);
                    sb3.append(" - allocating new window.");
                    Log.d("DataHolder", sb3.toString());
                    cursorWindow2.freeLastRow();
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setStartPosition(i2);
                    cursorWindow2.setNumColumns(zza2.zzape.length);
                    arrayList.add(cursorWindow2);
                    i2--;
                    z = true;
                } else {
                    throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                }
                i2++;
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

    public static zza zzb(String[] strArr) {
        return new zza(strArr, (String) null);
    }

    public static DataHolder zzbQ(int i) {
        return zza(i, (Bundle) null);
    }

    private void zzg(String str, int i) {
        Bundle bundle = this.zzapf;
        if (bundle == null || !bundle.containsKey(str)) {
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "No such column: ".concat(valueOf) : new String("No such column: "));
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.zzapj) {
            throw new CursorIndexOutOfBoundsException(i, this.zzapj);
        }
    }

    public void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (CursorWindow close : this.zzapg) {
                    close.close();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        String str;
        try {
            if (this.zzapl && this.zzapg.length > 0 && !isClosed()) {
                if (this.zzapk == null) {
                    String valueOf = String.valueOf(toString());
                    str = valueOf.length() != 0 ? "internal object: ".concat(valueOf) : new String("internal object: ");
                } else {
                    str = this.zzapk.toString();
                }
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 161);
                sb.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (");
                sb.append(str);
                sb.append(")");
                Log.e("DataBuffer", sb.toString());
                close();
            }
        } finally {
            super.finalize();
        }
    }

    public int getCount() {
        return this.zzapj;
    }

    public int getStatusCode() {
        return this.zzahG;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    public void zza(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        zzg(str, i);
        this.zzapg[i2].copyStringToBuffer(i, this.zzapf.getInt(str), charArrayBuffer);
    }

    public long zzb(String str, int i, int i2) {
        zzg(str, i);
        return this.zzapg[i2].getLong(i, this.zzapf.getInt(str));
    }

    public int zzbP(int i) {
        int i2 = 0;
        zzaa.zzai(i >= 0 && i < this.zzapj);
        while (true) {
            int[] iArr = this.zzapi;
            if (i2 >= iArr.length) {
                break;
            } else if (i < iArr[i2]) {
                i2--;
                break;
            } else {
                i2++;
            }
        }
        return i2 == this.zzapi.length ? i2 - 1 : i2;
    }

    public int zzc(String str, int i, int i2) {
        zzg(str, i);
        return this.zzapg[i2].getInt(i, this.zzapf.getInt(str));
    }

    public boolean zzcY(String str) {
        return this.zzapf.containsKey(str);
    }

    public String zzd(String str, int i, int i2) {
        zzg(str, i);
        return this.zzapg[i2].getString(i, this.zzapf.getInt(str));
    }

    public boolean zze(String str, int i, int i2) {
        zzg(str, i);
        return Long.valueOf(this.zzapg[i2].getLong(i, this.zzapf.getInt(str))).longValue() == 1;
    }

    public float zzf(String str, int i, int i2) {
        zzg(str, i);
        return this.zzapg[i2].getFloat(i, this.zzapf.getInt(str));
    }

    public byte[] zzg(String str, int i, int i2) {
        zzg(str, i);
        return this.zzapg[i2].getBlob(i, this.zzapf.getInt(str));
    }

    public Uri zzh(String str, int i, int i2) {
        String zzd = zzd(str, i, i2);
        if (zzd == null) {
            return null;
        }
        return Uri.parse(zzd);
    }

    public boolean zzi(String str, int i, int i2) {
        zzg(str, i);
        return this.zzapg[i2].isNull(i, this.zzapf.getInt(str));
    }

    public Bundle zzsO() {
        return this.zzaph;
    }

    public void zzsT() {
        this.zzapf = new Bundle();
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = this.zzape;
            if (i2 >= strArr.length) {
                break;
            }
            this.zzapf.putInt(strArr[i2], i2);
            i2++;
        }
        this.zzapi = new int[this.zzapg.length];
        int i3 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.zzapg;
            if (i < cursorWindowArr.length) {
                this.zzapi[i] = i3;
                i3 += this.zzapg[i].getNumRows() - (i3 - cursorWindowArr[i].getStartPosition());
                i++;
            } else {
                this.zzapj = i3;
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String[] zzsU() {
        return this.zzape;
    }

    /* access modifiers changed from: package-private */
    public CursorWindow[] zzsV() {
        return this.zzapg;
    }

    public void zzu(Object obj) {
        this.zzapk = obj;
    }
}
