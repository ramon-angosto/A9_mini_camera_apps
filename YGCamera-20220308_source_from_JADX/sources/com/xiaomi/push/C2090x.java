package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* renamed from: com.xiaomi.push.x */
public abstract class C2090x implements Runnable {

    /* renamed from: a */
    private Context f3980a;

    /* renamed from: a */
    private File f3981a;

    /* renamed from: a */
    private Runnable f3982a;

    private C2090x(Context context, File file) {
        this.f3980a = context;
        this.f3981a = file;
    }

    /* synthetic */ C2090x(Context context, File file, C2091y yVar) {
        this(context, file);
    }

    /* renamed from: a */
    public static void m5386a(Context context, File file, Runnable runnable) {
        new C2091y(context, file, runnable).run();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo18569a(Context context);

    public final void run() {
        C2089w wVar = null;
        try {
            if (this.f3981a == null) {
                this.f3981a = new File(this.f3980a.getFilesDir(), "default_locker");
            }
            wVar = C2089w.m5384a(this.f3980a, this.f3981a);
            if (this.f3982a != null) {
                this.f3982a.run();
            }
            mo18569a(this.f3980a);
            if (wVar == null) {
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (wVar == null) {
                return;
            }
        } catch (Throwable th) {
            if (wVar != null) {
                wVar.mo18568a();
            }
            throw th;
        }
        wVar.mo18568a();
    }
}
