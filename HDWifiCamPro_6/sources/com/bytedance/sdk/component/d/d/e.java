package com.bytedance.sdk.component.d.d;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.d.c.c;
import com.bytedance.sdk.component.d.f;

/* compiled from: DecoderVisitor */
public class e extends a {
    private byte[] a;
    private f b;

    public String a() {
        return "decode";
    }

    public e(byte[] bArr, f fVar) {
        this.a = bArr;
        this.b = fVar;
    }

    public void a(c cVar) {
        com.bytedance.sdk.component.d.c.f r = cVar.r();
        try {
            Bitmap a2 = r.a(cVar).a(this.a);
            if (a2 != null) {
                cVar.a((i) new m(a2, this.b, false));
                r.a(cVar.s()).a(cVar.e(), a2);
                return;
            }
            a(1002, "decode failed bitmap null", (Throwable) null, cVar);
        } catch (Throwable th) {
            a(1002, "decode failed:" + th.getMessage(), th, cVar);
        }
    }

    private void a(int i, String str, Throwable th, c cVar) {
        if (this.b == null) {
            cVar.a((i) new k());
        } else {
            cVar.a((i) new h(i, str, th));
        }
    }
}
