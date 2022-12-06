package com.ironsource.sdk.g;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new b(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new b[i];
        }
    };
    public String a;
    public String b;
    public String c;
    public boolean d;
    public int e;
    public String f;
    public String g;
    public boolean h;
    public boolean i;
    public Map<String, String> j;
    private ArrayList<String> k;
    private ArrayList<String> l;
    private ArrayList<String> m;
    private ArrayList<String> n;
    private Map<String, String> o;

    public b() {
        a();
    }

    private b(Parcel parcel) {
        a();
        try {
            boolean z = true;
            this.d = parcel.readByte() != 0;
            this.e = parcel.readInt();
            this.a = parcel.readString();
            this.b = parcel.readString();
            this.c = parcel.readString();
            this.f = parcel.readString();
            this.g = parcel.readString();
            this.o = a(parcel.readString());
            this.i = parcel.readByte() != 0;
            if (parcel.readByte() == 0) {
                z = false;
            }
            this.h = z;
            this.j = a(parcel.readString());
        } catch (Throwable unused) {
            a();
        }
    }

    /* synthetic */ b(Parcel parcel, byte b2) {
        this(parcel);
    }

    private static Map<String, String> a(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return hashMap;
    }

    private void a() {
        this.d = false;
        this.e = -1;
        this.k = new ArrayList<>();
        this.l = new ArrayList<>();
        this.m = new ArrayList<>();
        this.n = new ArrayList<>();
        this.h = true;
        this.i = false;
        this.g = "";
        this.f = "";
        this.o = new HashMap();
        this.j = new HashMap();
    }

    public final void a(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.m.indexOf(str) == -1) {
            this.m.add(str);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("shouldRestore:");
            sb.append(this.d);
            sb.append(", ");
            sb.append("displayedProduct:");
            sb.append(this.e);
            sb.append(", ");
            sb.append("ISReportInit:");
            sb.append(this.k);
            sb.append(", ");
            sb.append("ISInitSuccess:");
            sb.append(this.l);
            sb.append(", ");
            sb.append("ISAppKey");
            sb.append(this.f);
            sb.append(", ");
            sb.append("ISUserId");
            sb.append(this.g);
            sb.append(", ");
            sb.append("ISExtraParams");
            sb.append(this.o);
            sb.append(", ");
            sb.append("OWReportInit");
            sb.append(this.h);
            sb.append(", ");
            sb.append("OWInitSuccess");
            sb.append(this.i);
            sb.append(", ");
            sb.append("OWExtraParams");
            sb.append(this.j);
            sb.append(", ");
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        try {
            int i3 = 1;
            parcel.writeByte((byte) (this.d ? 1 : 0));
            parcel.writeInt(this.e);
            parcel.writeString(this.a);
            parcel.writeString(this.b);
            parcel.writeString(this.c);
            parcel.writeString(this.f);
            parcel.writeString(this.g);
            parcel.writeString(new JSONObject(this.o).toString());
            parcel.writeByte((byte) (this.i ? 1 : 0));
            if (!this.h) {
                i3 = 0;
            }
            parcel.writeByte((byte) i3);
            parcel.writeString(new JSONObject(this.j).toString());
        } catch (Throwable unused) {
        }
    }
}
