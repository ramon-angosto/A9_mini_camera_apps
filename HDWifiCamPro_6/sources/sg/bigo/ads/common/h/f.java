package sg.bigo.ads.common.h;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import sg.bigo.ads.common.f.c;
import sg.bigo.ads.common.h.b;
import sg.bigo.ads.common.i;
import sg.bigo.ads.common.l.g;
import sg.bigo.ads.common.l.h;
import sg.bigo.ads.common.utils.e;
import sg.bigo.ads.common.utils.o;

public final class f {
    public final Map<String, b> a;
    public final List<b> b;
    public sg.bigo.ads.common.d.a.a c;
    final Handler d;
    private long e;

    public static class a {
        /* access modifiers changed from: private */
        public static final f a = new f((byte) 0);
    }

    class b {
        final String a;
        final String b;
        volatile boolean c;
        private final List<e> e;
        private final Object f;

        private b(String str, String str2, e eVar) {
            this.e = new ArrayList();
            this.c = false;
            this.f = new Object();
            this.a = str;
            this.b = str2;
            this.e.add(eVar);
        }

        /* synthetic */ b(f fVar, String str, String str2, e eVar, byte b2) {
            this(str, str2, eVar);
        }

        static /* synthetic */ void a(b bVar, Bitmap bitmap, String str, long j, String str2) {
            b bVar2 = bVar;
            synchronized (bVar2.f) {
                sg.bigo.ads.common.k.a.a(0, 4, "ImageLoader", "Succeed to download image: " + bVar2.a);
                for (final e next : bVar2.e) {
                    final Bitmap bitmap2 = bitmap;
                    final String str3 = str;
                    final long j2 = j;
                    final String str4 = str2;
                    f.this.d.post(new Runnable() {
                        public final void run() {
                            next.a(bitmap2, new d(1, str3, j2, str4));
                        }
                    });
                }
                f.this.a.remove(bVar2.a);
                f.this.a();
            }
        }

        static /* synthetic */ void a(b bVar, String str, String str2) {
            synchronized (bVar.f) {
                sg.bigo.ads.common.k.a.a(0, 5, "ImageLoader", "Failed to download image: " + bVar.a);
                for (e a2 : bVar.e) {
                    a2.a(str, str2);
                }
                f.this.a.remove(bVar.a);
                f.this.a();
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(e eVar) {
            synchronized (this.f) {
                this.e.add(eVar);
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.a.equals(((b) obj).a);
        }
    }

    private f() {
        this.a = new ConcurrentHashMap();
        this.b = new CopyOnWriteArrayList();
        this.e = -1;
        this.d = new Handler(Looper.getMainLooper());
        this.c = new sg.bigo.ads.common.d.a.a();
    }

    /* synthetic */ f(byte b2) {
        this();
    }

    static File a(InputStream inputStream, String str) {
        FileOutputStream fileOutputStream;
        IOException e2;
        String d2 = i.d();
        e.a(d2, str);
        File file = new File(d2, str);
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
            } catch (IOException e3) {
                e2 = e3;
                try {
                    e2.printStackTrace();
                    sg.bigo.ads.common.utils.f.a((Closeable) inputStream);
                    sg.bigo.ads.common.utils.f.a((Closeable) fileOutputStream);
                    return file;
                } catch (Throwable th) {
                    th = th;
                    sg.bigo.ads.common.utils.f.a((Closeable) inputStream);
                    sg.bigo.ads.common.utils.f.a((Closeable) fileOutputStream);
                    throw th;
                }
            }
        } catch (IOException e4) {
            IOException iOException = e4;
            fileOutputStream = null;
            e2 = iOException;
            e2.printStackTrace();
            sg.bigo.ads.common.utils.f.a((Closeable) inputStream);
            sg.bigo.ads.common.utils.f.a((Closeable) fileOutputStream);
            return file;
        } catch (Throwable th2) {
            Throwable th3 = th2;
            fileOutputStream = null;
            th = th3;
            sg.bigo.ads.common.utils.f.a((Closeable) inputStream);
            sg.bigo.ads.common.utils.f.a((Closeable) fileOutputStream);
            throw th;
        }
        sg.bigo.ads.common.utils.f.a((Closeable) inputStream);
        sg.bigo.ads.common.utils.f.a((Closeable) fileOutputStream);
        return file;
    }

    static String a(String str) {
        return i.d() + File.separator + str;
    }

    static String a(String str, String str2) {
        return !TextUtils.isEmpty(str2) ? str2 : String.valueOf(str.hashCode());
    }

    private void b(String str, e eVar) {
        final String a2 = a(str, (String) null);
        final String a3 = a(a2);
        final e eVar2 = eVar;
        final String str2 = str;
        c.a(1, new Runnable() {
            final /* synthetic */ String e = null;

            public final void run() {
                final sg.bigo.ads.common.b b2 = sg.bigo.ads.common.utils.c.b(a3);
                if (b2 != null) {
                    b.a.a.a(a2, b2);
                    final long a2 = e.a(a3, 2);
                    sg.bigo.ads.common.k.a.a(0, 3, "ImageLoader", "Obtain the bitmap from local file, mimeType=" + b2.b);
                    f.this.d.post(new Runnable() {
                        public final void run() {
                            eVar2.a(b2.a, new d(0, b2.b, a2, b2.c));
                        }
                    });
                    new File(a3).setLastModified(System.currentTimeMillis());
                    f.this.b();
                    return;
                }
                f.this.a(str2, this.e, eVar2);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a() {
        if (!this.b.isEmpty()) {
            sg.bigo.ads.common.k.a.a(0, 3, "ImageLoader", "scheduleDownload");
            while (true) {
                if (!(this.a.size() < this.c.a)) {
                    sg.bigo.ads.common.k.a.a(0, 3, "ImageLoader", "Current size of waiting list: " + this.b.size());
                    return;
                } else if (!this.b.isEmpty()) {
                    final b remove = this.b.remove(0);
                    this.a.put(remove.a, remove);
                    c.a(1, new Runnable() {
                        public final void run() {
                            b bVar = remove;
                            if (!bVar.c) {
                                bVar.c = true;
                                g.a(new sg.bigo.ads.common.l.b.a(sg.bigo.ads.common.o.a.a(), bVar.a), new sg.bigo.ads.common.l.b<sg.bigo.ads.common.l.b.a, sg.bigo.ads.common.l.c.a>() {
                                    public final /* bridge */ /* synthetic */ sg.bigo.ads.common.l.c.c a(sg.bigo.ads.common.l.c.a aVar) {
                                        return aVar;
                                    }

                                    public final /* synthetic */ void a(sg.bigo.ads.common.l.b.c cVar, sg.bigo.ads.common.l.c.c cVar2) {
                                        sg.bigo.ads.common.l.c.a aVar = (sg.bigo.ads.common.l.c.a) cVar2;
                                        b.this.c = false;
                                        String a2 = aVar.a(HttpHeaders.CONTENT_TYPE);
                                        sg.bigo.ads.common.k.a.a(0, 4, "ImageLoader", "Content-Type:".concat(String.valueOf(a2)));
                                        if (Build.VERSION.SDK_INT != 28 || !"image/webp".equalsIgnoreCase(a2)) {
                                            String a3 = f.a(b.this.a, b.this.b);
                                            InputStream inputStream = aVar.b;
                                            sg.bigo.ads.common.b b = inputStream == null ? null : sg.bigo.ads.common.utils.c.b(f.a(inputStream, a3).getPath());
                                            if (b != null) {
                                                sg.bigo.ads.common.k.a.a(0, 4, "ImageLoader", "mimeType:" + b.b);
                                                if (o.b(b.b)) {
                                                    b.b = a2;
                                                }
                                                b.a.a.a(a3, b);
                                                b.a(b.this, b.a, b.b, e.a(f.a(a3), 2), b.c);
                                                f.this.b();
                                                return;
                                            }
                                            b.a(b.this, "Failed to parse image.", a2);
                                            return;
                                        }
                                        b.a(b.this, "Not support parsing webp images in Android P.", a2);
                                    }

                                    public final /* synthetic */ void a(sg.bigo.ads.common.l.b.c cVar, h hVar) {
                                        b bVar = b.this;
                                        bVar.c = false;
                                        b.a(bVar, hVar.getMessage(), "");
                                    }
                                });
                            }
                        }
                    });
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, String str2, e eVar) {
        if (!URLUtil.isNetworkUrl(str)) {
            eVar.a("Unknown scheme.", "");
        } else if (this.c.b()) {
            eVar.a("Unable to download image.", "");
        } else {
            sg.bigo.ads.common.k.a.a(0, 3, "ImageLoader", "Obtain the bitmap through network.");
            if (this.a.containsKey(str)) {
                sg.bigo.ads.common.k.a.a(0, 3, "ImageLoader", "The target url is already in the requesting list: ".concat(String.valueOf(str)));
                b bVar = this.a.get(str);
                if (bVar != null) {
                    bVar.a(eVar);
                    return;
                }
                return;
            }
            b bVar2 = new b(this, str, str2, eVar, (byte) 0);
            int indexOf = this.b.indexOf(bVar2);
            if (indexOf < 0) {
                this.b.add(bVar2);
                a();
                return;
            }
            sg.bigo.ads.common.k.a.a(0, 3, "ImageLoader", "The target url is already in the waiting list: ".concat(String.valueOf(str)));
            this.b.get(indexOf).a(eVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, final e eVar) {
        String a2 = a(str, (String) null);
        final sg.bigo.ads.common.b a3 = b.a.a.a(a2);
        if (a3 != null) {
            if (a3.a.isRecycled()) {
                b.a.a.b(a2);
            } else {
                sg.bigo.ads.common.k.a.a(0, 3, "ImageLoader", "Get bitmap from cache, mimeType=" + a3.b);
                this.d.post(new Runnable() {
                    public final void run() {
                        eVar.a(a3.a, new d(2, a3.b, 0, a3.c));
                    }
                });
                return;
            }
        }
        if (e.b(a(a2))) {
            b(str, eVar);
        } else {
            a(str, (String) null, eVar);
        }
    }

    public final synchronized void b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.e > 3600000) {
            this.e = currentTimeMillis;
            c.a(0, new Runnable() {
                public final void run() {
                    File[] listFiles;
                    f fVar = f.this;
                    if (!c.b()) {
                        sg.bigo.ads.common.k.a.a(0, 3, "ImageLoader", "Start check and delete expired images.");
                        File file = new File(i.d());
                        if (file.exists() && (listFiles = file.listFiles()) != null) {
                            Arrays.sort(listFiles, new Comparator<File>() {
                                public final /* synthetic */ int compare(Object obj, Object obj2) {
                                    int i = ((((File) obj).lastModified() - ((File) obj2).lastModified()) > 0 ? 1 : ((((File) obj).lastModified() - ((File) obj2).lastModified()) == 0 ? 0 : -1));
                                    if (i > 0) {
                                        return -1;
                                    }
                                    return i == 0 ? 0 : 1;
                                }
                            });
                            long currentTimeMillis = System.currentTimeMillis() - fVar.c.b;
                            for (int i = 0; i < listFiles.length; i++) {
                                File file2 = listFiles[i];
                                if (i >= fVar.c.a() || file2.lastModified() <= currentTimeMillis) {
                                    file2.delete();
                                }
                            }
                        }
                    }
                }
            });
        }
    }
}
