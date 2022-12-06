package com.bytedance.sdk.openadsdk.i.a;

import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.component.d.h;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.d.o;
import com.bytedance.sdk.openadsdk.core.m;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;

/* compiled from: GifLoader */
public class a {

    /* compiled from: GifLoader */
    public interface b {
        void a();

        void a(int i, String str, Throwable th);

        void a(String str, b bVar);
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    public void a(com.bytedance.sdk.openadsdk.i.a aVar, b bVar, int i, int i2, String str) {
        a(aVar, bVar, i, i2, ImageView.ScaleType.CENTER_INSIDE, str, 0);
    }

    public void a(com.bytedance.sdk.openadsdk.i.a aVar, final b bVar, int i, int i2, ImageView.ScaleType scaleType, String str, final int i3) {
        com.bytedance.sdk.openadsdk.e.a.a(aVar.a).a(aVar.b).a(i).b(i2).b(str).a(Bitmap.Config.RGB_565).a(scaleType).a(!TextUtils.isEmpty(str)).a((h) new h() {
            public Bitmap a(Bitmap bitmap) {
                if (i3 <= 0) {
                    return bitmap;
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    return com.bytedance.sdk.component.adexpress.c.a.a(m.a(), bitmap, i3);
                }
                return null;
            }
        }).a((o) new o() {
            public void a(k kVar) {
                a.this.a(kVar, bVar);
            }

            public void a(int i, String str, Throwable th) {
                a.this.a(i, str, th, bVar);
            }
        });
        a();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: android.graphics.Bitmap} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.bytedance.sdk.component.d.k r5, com.bytedance.sdk.openadsdk.i.a.a.b r6) {
        /*
            r4 = this;
            if (r6 == 0) goto L_0x0048
            java.lang.Object r0 = r5.b()
            int r1 = r4.a(r5)
            boolean r2 = r0 instanceof byte[]
            if (r2 == 0) goto L_0x001f
            java.lang.String r5 = r5.a()
            com.bytedance.sdk.openadsdk.i.a.b r2 = new com.bytedance.sdk.openadsdk.i.a.b
            byte[] r0 = (byte[]) r0
            byte[] r0 = (byte[]) r0
            r2.<init>(r0, r1)
            r6.a(r5, r2)
            goto L_0x0048
        L_0x001f:
            boolean r2 = r0 instanceof android.graphics.Bitmap
            r3 = 0
            if (r2 == 0) goto L_0x0042
            java.lang.Object r2 = r5.c()
            boolean r2 = r2 instanceof android.graphics.Bitmap
            if (r2 == 0) goto L_0x0033
            java.lang.Object r2 = r5.c()
            r3 = r2
            android.graphics.Bitmap r3 = (android.graphics.Bitmap) r3
        L_0x0033:
            java.lang.String r5 = r5.a()
            com.bytedance.sdk.openadsdk.i.a.b r2 = new com.bytedance.sdk.openadsdk.i.a.b
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            r2.<init>(r0, r3, r1)
            r6.a(r5, r2)
            goto L_0x0048
        L_0x0042:
            r5 = 0
            java.lang.String r0 = "not bitmap or gif result!"
            r6.a(r5, r0, r3)
        L_0x0048:
            if (r6 == 0) goto L_0x004d
            r6.a()
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.i.a.a.a(com.bytedance.sdk.component.d.k, com.bytedance.sdk.openadsdk.i.a.a$b):void");
    }

    private int a(k kVar) {
        String str;
        Map<String, String> d = kVar.d();
        if (d == null || (str = d.get(CampaignEx.JSON_KEY_IMAGE_SIZE)) == null || !(str instanceof Integer)) {
            return 0;
        }
        return ((Integer) str).intValue();
    }

    /* access modifiers changed from: protected */
    public void a(int i, String str, Throwable th, b bVar) {
        if (bVar != null) {
            bVar.a(i, str, th);
        }
    }

    public static C0053a b() {
        return new C0053a();
    }

    /* renamed from: com.bytedance.sdk.openadsdk.i.a.a$a  reason: collision with other inner class name */
    /* compiled from: GifLoader */
    static class C0053a implements b {
        public void a() {
        }

        public void a(int i, String str, Throwable th) {
        }

        public void a(String str, b bVar) {
        }

        C0053a() {
        }
    }
}
