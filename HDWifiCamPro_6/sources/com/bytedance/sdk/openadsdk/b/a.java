package com.bytedance.sdk.openadsdk.b;

import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.l;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: LruDiskFile */
public abstract class a {
    private final ExecutorService a = Executors.newSingleThreadExecutor();

    /* access modifiers changed from: protected */
    public abstract void a(List<File> list);

    /* access modifiers changed from: protected */
    public abstract boolean a(long j, int i);

    /* access modifiers changed from: protected */
    public abstract boolean a(File file, long j, int i);

    public void a(File file) throws IOException {
        this.a.submit(new C0038a(file));
    }

    /* access modifiers changed from: private */
    public void b(File file) throws IOException {
        try {
            f.b(file);
        } catch (Throwable th) {
            l.a("LruDiskFile", "setLastModifiedNowError", th);
        }
        a(f.a(file.getParentFile()));
    }

    /* access modifiers changed from: package-private */
    public long b(List<File> list) {
        long j = 0;
        for (File length : list) {
            j += length.length();
        }
        return j;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.b.a$a  reason: collision with other inner class name */
    /* compiled from: LruDiskFile */
    private class C0038a implements Callable<Void> {
        private final File b;

        private C0038a(File file) {
            this.b = file;
        }

        /* renamed from: a */
        public Void call() throws Exception {
            a.this.b(this.b);
            return null;
        }
    }
}
