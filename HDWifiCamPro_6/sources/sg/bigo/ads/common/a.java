package sg.bigo.ads.common;

import android.os.Parcel;
import java.util.concurrent.TimeUnit;
import sg.bigo.ads.common.utils.p;

public final class a implements d {
    public static final a a = new a();
    public String b;
    public boolean c;
    private long d;

    private a() {
        this.b = "";
        this.c = true;
    }

    public a(Parcel parcel) {
        b(parcel);
    }

    public a(String str, boolean z) {
        this.b = str;
        this.c = z;
        this.d = p.b();
    }

    public final void a(Parcel parcel) {
        parcel.writeString(this.b);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeLong(this.d);
    }

    public final boolean a() {
        return Math.abs(p.b() - this.d) > TimeUnit.DAYS.toMillis(1);
    }

    public final void b(Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readInt() != 0;
        this.d = parcel.readLong();
    }

    public final String toString() {
        return "{advertisingId='" + this.b + '\'' + ", isLimitAdTrackingEnabled=" + this.c + ", lastUpdateTime=" + this.d + '}';
    }
}
