package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.C1524b;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.xiaomi.push.w */
public final class C2089w {

    /* renamed from: a */
    private static final Set<String> f3975a = Collections.synchronizedSet(new HashSet());

    /* renamed from: a */
    private Context f3976a;

    /* renamed from: a */
    private RandomAccessFile f3977a;

    /* renamed from: a */
    private String f3978a;

    /* renamed from: a */
    private FileLock f3979a;

    private C2089w(Context context) {
        this.f3976a = context;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public static C2089w m5384a(Context context, File file) {
        C1524b.m2159c("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        if (f3975a.add(str)) {
            C2089w wVar = new C2089w(context);
            wVar.f3978a = str;
            try {
                wVar.f3977a = new RandomAccessFile(file2, "rw");
                wVar.f3979a = wVar.f3977a.getChannel().lock();
                C1524b.m2159c("Locked: " + str + " :" + wVar.f3979a);
                if (wVar.f3979a == null) {
                    RandomAccessFile randomAccessFile = wVar.f3977a;
                    if (randomAccessFile != null) {
                        C1608aa.m2491a((Closeable) randomAccessFile);
                    }
                    f3975a.remove(wVar.f3978a);
                }
                return wVar;
            } catch (Throwable th) {
                if (wVar.f3979a == null) {
                    RandomAccessFile randomAccessFile2 = wVar.f3977a;
                    if (randomAccessFile2 != null) {
                        C1608aa.m2491a((Closeable) randomAccessFile2);
                    }
                    f3975a.remove(wVar.f3978a);
                }
                throw th;
            }
        } else {
            throw new IOException("abtain lock failure");
        }
    }

    /* renamed from: a */
    public void mo18568a() {
        C1524b.m2159c("unLock: " + this.f3979a);
        FileLock fileLock = this.f3979a;
        if (fileLock != null && fileLock.isValid()) {
            try {
                this.f3979a.release();
            } catch (IOException unused) {
            }
            this.f3979a = null;
        }
        RandomAccessFile randomAccessFile = this.f3977a;
        if (randomAccessFile != null) {
            C1608aa.m2491a((Closeable) randomAccessFile);
        }
        f3975a.remove(this.f3978a);
    }
}
