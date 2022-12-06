package com.bytedance.sdk.openadsdk.core.f;

import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.a.a.a.a.b.a;
import com.a.a.a.a.b.b;
import com.a.a.a.a.b.c;
import com.a.a.a.a.b.d;
import com.a.a.a.a.b.f;
import com.a.a.a.a.b.i;
import com.a.a.a.a.b.j;
import com.a.a.a.a.b.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* compiled from: ViewabilityTrackerFactory */
public class h {
    public static g a(View view, Set<j> set) {
        b a = a(f.VIDEO, set, i.NATIVE);
        return new i(a, a.a(a), view, com.a.a.a.a.b.a.b.a(a));
    }

    public static g a(WebView webView) {
        j a = e.a();
        if (a != null) {
            b a2 = b.a(c.a(f.HTML_DISPLAY, com.a.a.a.a.b.h.BEGIN_TO_RENDER, i.NATIVE, i.NONE, false), d.a(a, webView, "", ""));
            return new g(a2, a.a(a2), webView);
        }
        throw new IllegalArgumentException("Parameter 'partner' may not be null.");
    }

    private static b a(f fVar, Set<j> set, i iVar) {
        List<l> a = a(set);
        if (a.isEmpty()) {
            com.bytedance.sdk.component.utils.l.d("verificationScriptResources is empty");
        }
        j a2 = e.a();
        if (a2 == null) {
            return null;
        }
        return b.a(c.a(fVar, com.a.a.a.a.b.h.BEGIN_TO_RENDER, i.NATIVE, iVar, false), d.a(a2, e.b(), a, "", ""));
    }

    private static List<l> a(Set<j> set) {
        ArrayList arrayList = new ArrayList();
        for (j next : set) {
            try {
                if (!TextUtils.isEmpty(next.a())) {
                    if (!TextUtils.isEmpty(next.b())) {
                        arrayList.add(l.a(next.a(), next.c(), next.b()));
                    }
                }
                arrayList.add(l.a(next.c()));
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }
}
