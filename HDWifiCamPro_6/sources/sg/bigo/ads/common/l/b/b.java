package sg.bigo.ads.common.l.b;

import androidx.browser.trusted.sharing.ShareTarget;
import sg.bigo.ads.common.l.f;

public final class b extends c {
    private static final f h = f.a("text/plain;charset=utf-8");
    public byte[] a;
    public String b;

    public b(int i, String str) {
        super(i, str);
    }

    public final String a() {
        return ShareTarget.METHOD_POST;
    }

    public final f b() {
        return h;
    }

    public final byte[] c() {
        return this.a;
    }

    public final String d() {
        return this.b;
    }

    public final int e() {
        byte[] bArr = this.a;
        return bArr != null ? bArr.length : super.e();
    }
}
