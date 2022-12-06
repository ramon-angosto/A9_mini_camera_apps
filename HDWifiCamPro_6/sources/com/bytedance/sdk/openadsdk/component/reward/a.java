package com.bytedance.sdk.openadsdk.component.reward;

import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.l.w;
import java.util.Iterator;
import java.util.List;

/* compiled from: ContinueDownloadTask */
public class a extends g {
    private final List<? extends g> a;

    public a(String str, List<? extends g> list) {
        super(str);
        this.a = list;
    }

    public void run() {
        List<? extends g> list;
        if (!(o.c(m.a()) == 0 || (list = this.a) == null)) {
            Iterator<? extends g> it = list.iterator();
            while (it.hasNext()) {
                w.a((g) it.next(), 1);
                it.remove();
            }
        }
        try {
            h.a().removeCallbacks(this);
        } catch (Exception unused) {
        }
    }
}
