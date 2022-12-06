package com.bytedance.sdk.openadsdk.core.video.b;

import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.openadsdk.b.b;
import java.io.File;
import java.util.List;

/* compiled from: TotalCountLruDiskDir */
public class c extends b {
    public c(int i, int i2) {
        super(i, i2);
    }

    /* access modifiers changed from: protected */
    public void a(List<File> list) {
        int size = list.size();
        if (!a(0, size)) {
            for (File next : list) {
                f.c(next);
                size--;
                if (a(next, 0, size)) {
                    return;
                }
            }
        }
    }
}
