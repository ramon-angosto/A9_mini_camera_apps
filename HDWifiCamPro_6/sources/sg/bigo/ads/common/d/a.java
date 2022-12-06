package sg.bigo.ads.common.d;

import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.common.utils.e;

public class a {
    public final String a;
    public String b;
    public String c;
    public String d;
    public int e = 0;
    public long f;
    public long g;
    public long h;
    public int i = 0;
    public int j = 0;
    public long k = 0;
    long l;
    public boolean m = false;
    public boolean n = false;
    public String o;
    private C0122a p;

    /* renamed from: sg.bigo.ads.common.d.a$a  reason: collision with other inner class name */
    public static class C0122a {
        int a = -1;
        public boolean b = false;

        /* access modifiers changed from: package-private */
        public final String a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("support_pd_flag", Integer.valueOf(this.a));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
    }

    public a(String str, String str2, String str3, boolean z) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = z ? 1 : 0;
        this.p = new C0122a();
        String a2 = a();
        long a3 = e.a(a2, 1);
        this.f = a3 <= 0 ? e.a(e.d(a2), 1) : a3;
        this.a = String.valueOf(str.hashCode());
        sg.bigo.ads.common.k.a.a(0, 3, "DownloadInfo", "newInstance mId = " + this.a + ", savedSize = " + this.f);
    }

    public final String a() {
        return this.c + File.separator + this.d;
    }

    public final boolean b() {
        return this.i == 3;
    }

    public final boolean c() {
        if (this.b.endsWith(".mp4") && this.p.a == -1) {
            if (e.a(e.d(a()))) {
                this.p.a = 1;
            } else {
                this.p.a = 0;
            }
        }
        return this.p.a == 1;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != a.class) {
            return false;
        }
        a aVar = (a) obj;
        return this.b.equals(aVar.b) && this.d.equals(aVar.d) && this.c.equals(aVar.c);
    }

    public String toString() {
        return " url = " + this.b + "," + " fileName = " + this.d + "," + " filePath = " + this.c + "," + " downloadCount = " + this.j + "," + " totalSize = " + this.h + "," + " loadedSize = " + this.f + "," + " mState = " + this.i + "," + " mLastDownloadEndTime = " + this.k + "," + " mExt = " + this.p.a() + "," + " contentType = " + this.o;
    }
}
