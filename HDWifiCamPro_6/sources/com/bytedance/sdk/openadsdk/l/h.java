package com.bytedance.sdk.openadsdk.l;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.i.a.a;
import com.bytedance.sdk.openadsdk.i.a.b;
import com.bytedance.sdk.openadsdk.i.d;

/* compiled from: ImageBytesHelper */
public class h {

    /* compiled from: ImageBytesHelper */
    public interface a {
        void a();

        void a(b bVar);

        void b();
    }

    public static void a(com.bytedance.sdk.openadsdk.i.a aVar, int i, int i2, a aVar2, String str) {
        a(aVar, i, i2, aVar2, str, 0);
    }

    public static void a(com.bytedance.sdk.openadsdk.i.a aVar, int i, int i2, final a aVar2, String str, int i3) {
        l.e("splashLoadAd", " getImageBytes url " + aVar);
        d.a().c().a(aVar, new a.b() {
            public void a(String str, b bVar) {
                a aVar;
                if (!bVar.d() || (aVar = aVar2) == null) {
                    a aVar2 = aVar2;
                    if (aVar2 != null) {
                        aVar2.a();
                        return;
                    }
                    return;
                }
                aVar.a(bVar);
            }

            public void a(int i, String str, Throwable th) {
                a aVar = aVar2;
                if (aVar != null) {
                    aVar.a();
                }
            }

            public void a() {
                a aVar = aVar2;
                if (aVar != null) {
                    aVar.b();
                }
            }
        }, i, i2, ImageView.ScaleType.CENTER_INSIDE, str, i3);
    }

    public static Drawable a(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return new ColorDrawable(0);
        }
        try {
            return new BitmapDrawable(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
        } catch (Throwable unused) {
            return new ColorDrawable(0);
        }
    }
}
