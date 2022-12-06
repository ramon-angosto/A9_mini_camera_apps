package sg.bigo.ads.api.core;

import android.os.Parcel;
import sg.bigo.ads.api.a.f;
import sg.bigo.ads.common.d;

public final class k implements f, d {
    public long a = 0;

    public final void a(Parcel parcel) {
        parcel.writeLong(this.a);
    }

    public final boolean a(int i) {
        return (this.a & ((long) (1 << i))) != 0;
    }

    public final void b(Parcel parcel) {
        this.a = parcel.readLong();
    }

    public final String toString() {
        return "{value=" + this.a + '}';
    }
}
