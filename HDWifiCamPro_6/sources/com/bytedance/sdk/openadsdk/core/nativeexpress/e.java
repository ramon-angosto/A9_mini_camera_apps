package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.b.b;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.model.g;
import com.bytedance.sdk.openadsdk.core.model.j;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.l.z;
import org.json.JSONObject;

/* compiled from: ExpressClickListener */
public class e extends b {
    public e(Context context, n nVar, String str, int i) {
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
        int i5;
        int i6;
        long j3;
        long j4;
        int i7;
        char c;
        int i8;
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
                float f11 = (float) i4;
                float b2 = z.b(this.b, f2);
                float f12 = (float) i3;
                f8 = (z.b(this.b, f3) + f11) - 0.5f;
                f7 = (z.b(this.b, f4) + f12) - 0.5f;
                f9 = (b2 + f12) - 0.5f;
                f10 = (b + f11) - 0.5f;
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
            int i9 = i4;
            j3 = this.c.f;
            if (this.r == 0) {
                iArr[0] = ((int) z.b(this.b, (float) this.c.g)) + i9;
                iArr[1] = ((int) z.b(this.b, (float) this.c.h)) + i3;
                i8 = (int) z.b(this.b, (float) this.c.i);
                i7 = (int) z.b(this.b, (float) this.c.j);
                c = 0;
                i5 = 1;
            } else {
                c = 0;
                iArr[0] = this.c.g;
                i5 = 1;
                iArr[1] = this.c.h;
                i8 = this.c.i;
                i7 = this.c.j;
            }
            iArr2[c] = i8;
            iArr2[i5] = i7;
            if (i8 == 0 && i7 == 0 && view2 != null) {
                iArr = z.a(view2);
                iArr2 = z.c(view2);
            }
            i6 = 0;
        } else {
            i5 = 1;
            j4 = j;
            i6 = 0;
            j3 = j2;
        }
        this.r = i6;
        g.a f13 = new g.a().f(f10).e(f9).d(f8).c(f7).b(j4).a(j3).b(a).a(iArr).c(z.c(view)).d(iArr2).d(this.y).e(this.z).f(this.A);
        if (!h.d().b()) {
            i5 = 2;
        }
        return f13.b(i5).a(sparseArray).a(str).a(i2).a(jSONObject).a();
    }

    public void a(j jVar) {
        this.c = jVar;
    }
}
