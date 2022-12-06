package com.xiaomi.push.log;

import android.util.Log;
import com.xiaomi.channel.commonutils.file.c;
import com.xiaomi.channel.commonutils.misc.f;

class g extends f.b {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public void b() {
        if (!f.f.isEmpty()) {
            try {
                if (!c.d()) {
                    Log.w(this.a.d, "SDCard is unavailable.");
                } else {
                    this.a.b();
                }
            } catch (Exception e) {
                Log.e(this.a.d, "", e);
            }
        }
    }
}
