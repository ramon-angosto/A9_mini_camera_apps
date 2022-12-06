package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.huawei.hms.core.aidl.b */
/* compiled from: DataBuffer */
public class C0702b implements Parcelable {
    public static final Parcelable.Creator<C0702b> CREATOR = new C0703a();

    /* renamed from: a */
    public String f436a;

    /* renamed from: b */
    public Bundle f437b;

    /* renamed from: c */
    private int f438c;

    /* renamed from: d */
    private Bundle f439d;

    /* renamed from: com.huawei.hms.core.aidl.b$a */
    /* compiled from: DataBuffer */
    static class C0703a implements Parcelable.Creator<C0702b> {
        C0703a() {
        }

        public C0702b createFromParcel(Parcel parcel) {
            return new C0702b(parcel, (C0703a) null);
        }

        public C0702b[] newArray(int i) {
            return new C0702b[i];
        }
    }

    /* synthetic */ C0702b(Parcel parcel, C0703a aVar) {
        this(parcel);
    }

    /* renamed from: a */
    private static ClassLoader m424a(Class cls) {
        return cls.getClassLoader();
    }

    /* renamed from: b */
    public int mo13625b() {
        return this.f439d == null ? 0 : 1;
    }

    /* renamed from: c */
    public int mo13626c() {
        return this.f438c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f438c);
        parcel.writeString(this.f436a);
        parcel.writeBundle(this.f437b);
        parcel.writeBundle(this.f439d);
    }

    private C0702b(Parcel parcel) {
        this.f437b = null;
        this.f438c = 1;
        this.f439d = null;
        m425a(parcel);
    }

    /* renamed from: a */
    public C0702b mo13624a(Bundle bundle) {
        this.f439d = bundle;
        return this;
    }

    /* renamed from: a */
    public Bundle mo13623a() {
        return this.f439d;
    }

    /* renamed from: a */
    private void m425a(Parcel parcel) {
        this.f438c = parcel.readInt();
        this.f436a = parcel.readString();
        this.f437b = parcel.readBundle(m424a(Bundle.class));
        this.f439d = parcel.readBundle(m424a(Bundle.class));
    }

    public C0702b() {
        this.f437b = null;
        this.f438c = 1;
        this.f439d = null;
    }

    public C0702b(String str, int i) {
        this.f437b = null;
        this.f438c = 1;
        this.f439d = null;
        this.f436a = str;
        this.f438c = i;
    }
}
