package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.b.a;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.model.g;
import com.bytedance.sdk.openadsdk.core.model.j;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.l.z;
import org.json.JSONObject;

/* compiled from: ExpressClickCreativeListener */
public class d extends a {
    public d(Context context, n nVar, String str, int i) {
        super(context, nVar, str, i);
    }

    /* access modifiers changed from: protected */
    public g a(float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, long j, long j2, View view, View view2, String str, float f5, int i, float f6, int i2, JSONObject jSONObject) {
        float f7;
        float f8;
        float f9;
        float f10;
        int i3;
        int i4;
        float f11;
        long j3;
        int i5;
        long j4;
        int i6;
        int i7;
        int[] a = z.a(view);
        if (a == null || a.length != 2) {
            f10 = f;
            f9 = f2;
            f8 = f3;
            f7 = f4;
            i4 = 0;
            i3 = 0;
        } else {
            i4 = a[0];
            i3 = a[1];
            if (this.r == 0) {
                float b = z.b(this.b, f);
                float f12 = (float) i4;
                float b2 = z.b(this.b, f2);
                float f13 = (float) i3;
                f8 = (z.b(this.b, f3) + f12) - 0.5f;
                f7 = (z.b(this.b, f4) + f13) - 0.5f;
                f9 = (b2 + f13) - 0.5f;
                f10 = (b + f12) - 0.5f;
            } else {
                f10 = f;
                f9 = f2;
                f8 = f3;
                f7 = f4;
            }
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        if (this.c != null) {
            j4 = this.c.e;
            f11 = f8;
            j3 = this.c.f;
            if (this.r == 0) {
                iArr[0] = ((int) z.b(this.b, (float) this.c.g)) + i4;
                iArr[1] = ((int) z.b(this.b, (float) this.c.h)) + i3;
                i7 = (int) z.b(this.b, (float) this.c.i);
                i6 = (int) z.b(this.b, (float) this.c.j);
                i5 = 1;
            } else {
                iArr[0] = this.c.g;
                i5 = 1;
                iArr[1] = this.c.h;
                i7 = this.c.i;
                i6 = this.c.j;
            }
            iArr2[0] = i7;
            iArr2[i5] = i6;
            if (i7 == 0 && i6 == 0 && view2 != null) {
                iArr = z.a(view2);
                iArr2 = z.c(view2);
            }
        } else {
            i5 = 1;
            f11 = f8;
            j4 = j;
            j3 = j2;
        }
        this.r = 0;
        g.a f14 = new g.a().f(f10).e(f9).d(f11).c(f7).b(j4).a(j3).b(a).a(iArr).c(z.c(view)).d(iArr2).d(this.y).e(this.z).f(this.A);
        if (!h.d().b()) {
            i5 = 2;
        }
        return f14.b(i5).a(sparseArray).a(str).a(f5).c(i).b(f6).a(i2).a(jSONObject).a();
    }

    public void a(j jVar) {
        this.c = jVar;
    }
}
