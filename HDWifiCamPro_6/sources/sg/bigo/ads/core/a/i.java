package sg.bigo.ads.core.a;

import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import androidx.core.view.MotionEventCompat;
import sg.bigo.ads.common.c;
import sg.bigo.ads.common.e;
import sg.bigo.ads.common.utils.b;
import sg.bigo.ads.common.utils.o;

public final class i extends c {
    long a;
    private final String d;
    private int e;
    private String f;
    private String g;
    private final e h;

    public i(Context context, e eVar) {
        this(context, eVar, "bigoad_report.dat");
    }

    public i(Context context, e eVar, String str) {
        super(context);
        this.g = "";
        this.h = eVar;
        this.d = str;
        m();
    }

    private void f() {
        this.e = 0;
        this.f = g();
    }

    private String g() {
        if (!o.b(this.g)) {
            return this.g;
        }
        byte[] bArr = new byte[16];
        e eVar = this.h;
        int hashCode = (eVar == null ? b.a(this.b) : eVar.c()).hashCode();
        bArr[0] = (byte) ((hashCode & -16777216) >> 24);
        bArr[1] = (byte) ((hashCode & 16711680) >> 16);
        bArr[2] = (byte) ((hashCode & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
        bArr[3] = (byte) (hashCode & 255);
        String str = Build.VERSION.RELEASE;
        int hashCode2 = (str != null ? str.hashCode() : 0) << 1;
        bArr[4] = (byte) ((hashCode2 & -16777216) >> 24);
        bArr[5] = (byte) ((hashCode2 & 16711680) >> 16);
        bArr[6] = (byte) ((hashCode2 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
        bArr[7] = (byte) (hashCode2 & 255);
        int i = ~hashCode;
        bArr[8] = (byte) ((-16777216 & i) >> 24);
        bArr[9] = (byte) ((16711680 & i) >> 16);
        bArr[10] = (byte) ((i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
        bArr[11] = (byte) (i & 255);
        bArr[12] = 0;
        bArr[13] = 1;
        bArr[14] = 62;
        bArr[15] = -60;
        this.g = o.a(bArr);
        return this.g;
    }

    public final void a(Parcel parcel) {
        parcel.writeLong(this.a);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
    }

    public final boolean a(int i, String str) {
        return a(this.a, i, str);
    }

    public final synchronized boolean a(long j, int i, String str) {
        boolean z;
        z = false;
        if (j > 0) {
            try {
                if (this.a != j) {
                    this.a = j;
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i > 0 && this.e != i && !o.b(str)) {
            this.e = i;
            this.f = str;
            z = true;
        }
        if (z) {
            o();
        }
        return z;
    }

    public final String a_() {
        return this.d;
    }

    public final String b() {
        return "AppCheckReport";
    }

    public final void b(Parcel parcel) {
        this.a = parcel.readLong();
        this.e = parcel.readInt();
        this.f = parcel.readString();
    }

    public final int c() {
        if (o.b(this.f)) {
            f();
        }
        return this.e;
    }

    public final String d() {
        if (o.b(this.f)) {
            f();
        }
        return this.f;
    }

    public final void e() {
        if (this.e != 0) {
            this.e = 0;
            this.f = "";
            o();
        }
    }

    public final String toString() {
        return "AppListData{mTimestamp=" + this.a + ", mCurIndex=" + this.e + ", mCurKey='" + this.f + '\'' + '}';
    }
}
