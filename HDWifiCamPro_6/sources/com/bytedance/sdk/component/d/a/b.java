package com.bytedance.sdk.component.d.a;

import com.bytedance.sdk.component.d.c.c.c;
import com.bytedance.sdk.component.d.i;
import com.bytedance.sdk.component.d.l;
import java.util.WeakHashMap;

/* compiled from: KeyGeneratorFactory */
public class b {
    public static l a() {
        return new l() {
            private WeakHashMap<String, String> a = new WeakHashMap<>();

            public String b(i iVar) {
                return a(iVar.a());
            }

            public String a(i iVar) {
                return a(iVar.a() + "#width=" + iVar.b() + "#height=" + iVar.c() + "#scaletype=" + iVar.d());
            }

            private String a(String str) {
                String str2 = this.a.get(str);
                if (str2 != null) {
                    return str2;
                }
                String a2 = c.a(str);
                this.a.put(str, a2);
                return a2;
            }
        };
    }
}
