package com.bytedance.sdk.component.d.c.a.b;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.d.c.a.b;
import com.bytedance.sdk.component.d.q;

/* compiled from: MemoryCacheWrapper */
public class d implements q {
    private final q a;
    private final b b;

    public d(q qVar) {
        this(qVar, (b) null);
    }

    public d(q qVar, b bVar) {
        this.a = qVar;
        this.b = bVar;
    }

    public boolean a(String str, Bitmap bitmap) {
        boolean a2 = this.a.a(str, bitmap);
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(str, Boolean.valueOf(a2));
        }
        return a2;
    }

    public Bitmap a(String str) {
        Bitmap bitmap = (Bitmap) this.a.a(str);
        b bVar = this.b;
        if (bVar != null) {
            bVar.b(str, bitmap);
        }
        return bitmap;
    }

    public boolean b(String str) {
        return this.a.b(str);
    }
}
