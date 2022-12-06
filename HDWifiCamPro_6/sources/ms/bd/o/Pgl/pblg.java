package ms.bd.o.Pgl;

import android.content.res.AssetManager;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import ms.bd.o.Pgl.pblb;

final class pblg extends pblb.pgla {
    pblg() {
    }

    /* access modifiers changed from: protected */
    public Object a(int i, long j, String str, Object obj) throws Throwable {
        InputStream inputStream;
        IOException e;
        FileOutputStream fileOutputStream;
        AssetManager assets = pgla.a().b().getAssets();
        if (!str.startsWith((String) pblk.a(16777217, 0, 0, "df24d3", new byte[]{59}))) {
            str = ((String) pblk.a(16777217, 0, 0, "6af8e7", new byte[]{105})) + str;
        }
        String[] list = assets.list("");
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.length; i2++) {
            if (list[i2].endsWith(str)) {
                String str2 = list[i2];
                String absolutePath = File.createTempFile((String) pblk.a(16777217, 0, 0, "34dbd5", new byte[]{47, 37, 18, 14, 79}), "").getAbsolutePath();
                FileOutputStream fileOutputStream2 = null;
                try {
                    inputStream = assets.open(str2);
                    try {
                        fileOutputStream = new FileOutputStream(absolutePath);
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            e.printStackTrace();
                            pblz.a((Closeable) inputStream);
                            pblz.a((Closeable) fileOutputStream2);
                        } catch (Throwable th) {
                            th = th;
                            pblz.a((Closeable) inputStream);
                            pblz.a((Closeable) fileOutputStream2);
                            throw th;
                        }
                    }
                    try {
                        if (pblz.a(inputStream, fileOutputStream) > 0) {
                            arrayList.add(absolutePath);
                        }
                        fileOutputStream2 = fileOutputStream;
                    } catch (IOException e3) {
                        e = e3;
                        fileOutputStream2 = fileOutputStream;
                        e.printStackTrace();
                        pblz.a((Closeable) inputStream);
                        pblz.a((Closeable) fileOutputStream2);
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream2 = fileOutputStream;
                        pblz.a((Closeable) inputStream);
                        pblz.a((Closeable) fileOutputStream2);
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    inputStream = null;
                    e.printStackTrace();
                    pblz.a((Closeable) inputStream);
                    pblz.a((Closeable) fileOutputStream2);
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    pblz.a((Closeable) inputStream);
                    pblz.a((Closeable) fileOutputStream2);
                    throw th;
                }
                pblz.a((Closeable) inputStream);
                pblz.a((Closeable) fileOutputStream2);
            }
        }
        return arrayList.toArray(new String[0]);
    }
}
