package sg.bigo.ads.core.a;

import android.text.TextUtils;

public final class m {
    public long a = -1;
    public final String b;
    public int c;
    public int d;
    public long e;
    public int f;
    public long g;
    public long h;
    public long i;
    public long j;
    public String k;
    public String l;

    public m(String str, int i2, int i3) {
        this.b = str;
        this.c = i2;
        this.d = i3;
        this.i = System.currentTimeMillis();
    }

    public final boolean a() {
        return this.a >= 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            m mVar = (m) obj;
            return TextUtils.equals(this.b, mVar.b) && this.c == mVar.c && this.d == mVar.d && this.j == mVar.j;
        }
    }

    public final String toString() {
        return "ReportAppInfo{pkgName='" + this.b + '\'' + ", status=" + this.c + ", source=" + this.d + ", sid=" + this.j + ", result=" + this.f + '}';
    }
}
