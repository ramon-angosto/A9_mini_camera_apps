package com.mbridge.msdk.mbnative.controller;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/* compiled from: Views */
public final class d {
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0007 */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x000d A[Catch:{ all -> 0x0019 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x000e A[Catch:{ all -> 0x0019 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.view.View a(android.view.View r2) {
        /*
            r0 = 0
            if (r2 != 0) goto L_0x0004
            return r0
        L_0x0004:
            androidx.core.view.ViewCompat.isAttachedToWindow(r2)     // Catch:{ all -> 0x0007 }
        L_0x0007:
            android.view.View r2 = r2.getRootView()     // Catch:{ all -> 0x0019 }
            if (r2 != 0) goto L_0x000e
            return r0
        L_0x000e:
            r1 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r2.findViewById(r1)     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0018
            r2 = r0
        L_0x0018:
            return r2
        L_0x0019:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbnative.controller.d.a(android.view.View):android.view.View");
    }

    public static View a(Context context, View view) {
        View view2 = null;
        if (context != null && (context instanceof Activity)) {
            view2 = ((Activity) context).getWindow().getDecorView().findViewById(16908290);
        }
        return view2 != null ? view2 : a(view);
    }
}
