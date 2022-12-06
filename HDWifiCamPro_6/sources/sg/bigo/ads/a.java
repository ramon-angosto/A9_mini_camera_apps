package sg.bigo.ads;

import android.content.Context;
import android.os.Parcel;
import sg.bigo.ads.common.c;
import sg.bigo.ads.common.h;

public final class a extends c {
    public String a;

    public a(Context context) {
        super(context);
    }

    public final void a(Parcel parcel) {
        parcel.writeString(this.a);
    }

    public final String a_() {
        return "bigo_app.dat";
    }

    public final String b() {
        return "bigo_app.dat";
    }

    public final void b(Parcel parcel) {
        this.a = h.a(parcel, "");
    }
}
