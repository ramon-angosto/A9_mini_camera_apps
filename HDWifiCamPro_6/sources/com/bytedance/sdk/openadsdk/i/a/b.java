package com.bytedance.sdk.openadsdk.i.a;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.utils.d;
import java.util.List;
import java.util.Map;

/* compiled from: GifRequestResult */
public class b {
    int a;
    private byte[] b = null;
    private Bitmap c = null;
    private Bitmap d = null;
    private List<Object> e = null;
    private Map<String, String> f = null;

    public b(byte[] bArr, int i) {
        this.b = bArr;
        this.a = i;
    }

    public b(Bitmap bitmap, Bitmap bitmap2, int i) {
        this.d = bitmap2;
        this.c = bitmap;
        this.a = i;
    }

    public Bitmap a() {
        return this.c;
    }

    public Bitmap b() {
        return this.d;
    }

    public byte[] c() {
        try {
            if (this.b == null) {
                this.b = d.a(this.c);
            }
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
        }
        return this.b;
    }

    public boolean d() {
        if (this.c != null) {
            return true;
        }
        byte[] bArr = this.b;
        if (bArr == null || bArr.length <= 0) {
            return false;
        }
        return true;
    }
}
