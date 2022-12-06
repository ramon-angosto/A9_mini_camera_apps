package sg.bigo.ads.api.a;

import android.os.Parcel;
import sg.bigo.ads.common.d;

public final class b implements d {
    public static final b a = new b();
    public static final d.a<b> b = new d.a<b>() {
        public final /* synthetic */ d a() {
            return new b((byte) 0);
        }
    };
    private String c;

    private b() {
    }

    /* synthetic */ b(byte b2) {
        this();
    }

    public b(String str) {
        this.c = str;
    }

    public final void a(Parcel parcel) {
        parcel.writeString(this.c);
    }

    public final boolean a() {
        return "1".equalsIgnoreCase(this.c) || "true".equalsIgnoreCase(this.c);
    }

    public final void b(Parcel parcel) {
        this.c = parcel.readString();
    }

    public final String toString() {
        return this.c;
    }
}
