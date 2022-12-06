package com.bytedance.sdk.openadsdk.core;

import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.model.j;
import com.bytedance.sdk.openadsdk.core.nativeexpress.d;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;

/* compiled from: H5AdInteractionManager */
public class i {
    private e a;
    private d b;
    private View c;

    public void a(int i, j jVar) {
        d dVar;
        if (i != -1 && jVar != null) {
            float f = jVar.a;
            float f2 = jVar.b;
            float f3 = jVar.c;
            float f4 = jVar.d;
            SparseArray<c.a> sparseArray = jVar.n;
            if (i == 1) {
                e eVar = this.a;
                if (eVar != null) {
                    eVar.a(jVar);
                    this.a.a(this.c, f, f2, f3, f4, sparseArray, true);
                }
            } else if (i == 2 && (dVar = this.b) != null) {
                dVar.a(jVar);
                this.b.a(this.c, f, f2, f3, f4, sparseArray, true);
            }
        }
    }
}
