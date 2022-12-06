package sg.bigo.ads.controller.b;

import android.os.Parcel;

final class a implements sg.bigo.ads.api.a.a {
    long a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;

    a() {
    }

    public final void a(Parcel parcel) {
        parcel.writeLong(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
    }

    public final void b(Parcel parcel) {
        this.a = parcel.readLong();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
    }

    public final String toString() {
        return "{expressId=" + this.a + ", name='" + this.b + '\'' + ", url='" + this.c + '\'' + ", md5='" + this.d + '\'' + ", style='" + this.e + '\'' + ", adTypes='" + this.f + '\'' + ", fileId='" + this.g + '\'' + '}';
    }
}
