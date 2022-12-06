package com.xiaomi.push;

import android.content.Context;
import java.io.File;

/* renamed from: com.xiaomi.push.y */
final class C2091y extends C2090x {

    /* renamed from: a */
    final /* synthetic */ Runnable f3983a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2091y(Context context, File file, Runnable runnable) {
        super(context, file, (C2091y) null);
        this.f3983a = runnable;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo18569a(Context context) {
        Runnable runnable = this.f3983a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
