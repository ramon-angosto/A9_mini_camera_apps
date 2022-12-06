package com.bytedance.sdk.component.d.c.a.b;

import android.graphics.Bitmap;
import android.os.Build;
import com.bytedance.sdk.component.d.c.a.c;
import com.bytedance.sdk.component.d.q;

/* compiled from: LruCountBitmapCache */
public class b implements q {
    private int a;
    private int b;
    private int c;
    private c<String, Bitmap> d;

    public b(int i, int i2) {
        this.c = i;
        this.a = i2;
        this.d = new c<String, Bitmap>(i) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public int b(String str, Bitmap bitmap) {
                if (bitmap == null) {
                    return 0;
                }
                return b.a(bitmap);
            }
        };
    }

    public boolean a(String str, Bitmap bitmap) {
        int i = this.b;
        int i2 = this.a;
        if (str == null || bitmap == null) {
            return false;
        }
        this.d.a(str, bitmap);
        return true;
    }

    public Bitmap a(String str) {
        return this.d.a(str);
    }

    public boolean b(String str) {
        return this.d.a(str) != null;
    }

    public static int a(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return bitmap.getAllocationByteCount();
        }
        if (Build.VERSION.SDK_INT >= 12) {
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }
}
