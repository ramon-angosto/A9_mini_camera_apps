package com.ironsource.sdk.i;

import android.app.Activity;
import android.content.Context;
import com.ironsource.sdk.controller.x;
import com.ironsource.sdk.g.d;
import com.ironsource.sdk.utils.b;

public final class a {

    /* renamed from: com.ironsource.sdk.i.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[d.a.a().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0018 */
        static {
            /*
                int[] r0 = com.ironsource.sdk.g.d.a.a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                r0 = 1
                int[] r1 = a     // Catch:{ NoSuchFieldError -> 0x0011 }
                int r2 = com.ironsource.sdk.g.d.a.a     // Catch:{ NoSuchFieldError -> 0x0011 }
                r2 = 0
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0011 }
            L_0x0011:
                r1 = 2
                int[] r2 = a     // Catch:{ NoSuchFieldError -> 0x0018 }
                int r3 = com.ironsource.sdk.g.d.a.b     // Catch:{ NoSuchFieldError -> 0x0018 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0018 }
            L_0x0018:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001f }
                int r2 = com.ironsource.sdk.g.d.a.c     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.i.a.AnonymousClass1.<clinit>():void");
        }
    }

    public static boolean a(Activity activity) {
        int parseInt = Integer.parseInt(b.a().a.getString("back_button_state", "2"));
        int i = AnonymousClass1.a[(parseInt == 0 ? d.a.a : parseInt == 1 ? d.a.b : d.a.c) - 1];
        if (i == 1 || i == 2 || i != 3) {
            return false;
        }
        try {
            x xVar = (x) com.ironsource.sdk.d.b.a((Context) activity).a.a;
            if (xVar != null) {
                xVar.b(x.b("nativeNavigationPressed", x.a("action", "back", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false)));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
