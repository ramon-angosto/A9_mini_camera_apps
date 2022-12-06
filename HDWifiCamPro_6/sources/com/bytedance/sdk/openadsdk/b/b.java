package com.bytedance.sdk.openadsdk.b;

import com.bytedance.sdk.component.utils.l;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: TotalCountLruDiskFile */
public class b extends a {
    private int a = 15;
    private int b = 3;
    private volatile boolean c;

    public b(int i, int i2) {
        if (i > 0) {
            this.a = i;
            this.b = i2;
            return;
        }
        throw new IllegalArgumentException("Max count must be positive number!");
    }

    public b(int i, int i2, boolean z) {
        if (i > 0) {
            this.a = i;
            this.b = i2;
            this.c = z;
            return;
        }
        throw new IllegalArgumentException("Max count must be positive number!");
    }

    /* access modifiers changed from: protected */
    public boolean a(long j, int i) {
        return i <= this.a;
    }

    /* access modifiers changed from: protected */
    public boolean a(File file, long j, int i) {
        return i <= this.b;
    }

    /* access modifiers changed from: protected */
    public void a(List<File> list) {
        if (this.c) {
            d(list);
            this.c = false;
            return;
        }
        c(list);
    }

    private void c(List<File> list) {
        long b2 = b(list);
        int size = list.size();
        if (!a(b2, size)) {
            for (File next : list) {
                long length = next.length();
                if (next.delete()) {
                    size--;
                    b2 -= length;
                }
                if (a(next, b2, size)) {
                    return;
                }
            }
        }
    }

    private void d(List<File> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    long b2 = b(list);
                    int size = list.size();
                    boolean a2 = a(b2, size);
                    if (a2) {
                        l.c("splashLoadAd", "Do not meet the delete condition, do not perform a delete operation(true)" + a2);
                        return;
                    }
                    TreeMap treeMap = new TreeMap();
                    for (File next : list) {
                        treeMap.put(Long.valueOf(next.lastModified()), next);
                    }
                    for (Map.Entry entry : treeMap.entrySet()) {
                        if (entry != null) {
                            if (!a2) {
                                ((Long) entry.getKey()).longValue();
                                File file = (File) entry.getValue();
                                long length = file.length();
                                if (file.delete()) {
                                    size--;
                                    b2 -= length;
                                }
                                if (a(file, b2, size)) {
                                    return;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
