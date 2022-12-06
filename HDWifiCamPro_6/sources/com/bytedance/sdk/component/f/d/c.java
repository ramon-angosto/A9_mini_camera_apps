package com.bytedance.sdk.component.f.d;

import android.content.Context;
import com.bytedance.sdk.component.f.c.g;
import java.util.LinkedHashMap;

/* compiled from: MultiProcessFileUtils */
public class c {
    public static void a(Context context, int i, String str, int i2) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (i == 1) {
                linkedHashMap.put(a(i2), str);
            }
            b.b("MultiProcessFileUtils", "saveData = " + str);
            if (g.a().a(i2).d() != null) {
                g.a().a(i2).d().a(context, linkedHashMap);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r2, int r3, int r4) {
        /*
            java.lang.String r0 = ""
            r1 = 1
            if (r3 == r1) goto L_0x0006
            goto L_0x0029
        L_0x0006:
            com.bytedance.sdk.component.f.c.g r3 = com.bytedance.sdk.component.f.c.g.a()     // Catch:{ Exception -> 0x0029 }
            com.bytedance.sdk.component.f.c.e r3 = r3.a(r4)     // Catch:{ Exception -> 0x0029 }
            com.bytedance.sdk.component.f.c.b r3 = r3.d()     // Catch:{ Exception -> 0x0029 }
            if (r3 == 0) goto L_0x0029
            com.bytedance.sdk.component.f.c.g r3 = com.bytedance.sdk.component.f.c.g.a()     // Catch:{ Exception -> 0x0029 }
            com.bytedance.sdk.component.f.c.e r3 = r3.a(r4)     // Catch:{ Exception -> 0x0029 }
            com.bytedance.sdk.component.f.c.b r3 = r3.d()     // Catch:{ Exception -> 0x0029 }
            java.lang.String r4 = a(r4)     // Catch:{ Exception -> 0x0029 }
            java.lang.String r2 = r3.a(r2, r4, r0)     // Catch:{ Exception -> 0x0029 }
            goto L_0x002a
        L_0x0029:
            r2 = r0
        L_0x002a:
            boolean r3 = r2 instanceof java.lang.String
            if (r3 == 0) goto L_0x0032
            java.lang.String r0 = java.lang.String.valueOf(r2)
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.d.c.a(android.content.Context, int, int):java.lang.String");
    }

    private static String a(int i) {
        return "tnc_config" + i;
    }
}
