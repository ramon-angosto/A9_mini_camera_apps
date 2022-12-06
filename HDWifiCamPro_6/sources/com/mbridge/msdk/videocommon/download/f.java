package com.mbridge.msdk.videocommon.download;

import com.mbridge.msdk.foundation.same.e.b;

/* compiled from: DownloadTask */
public final class f {
    private b a;

    /* compiled from: DownloadTask */
    private static class a {
        public static f a = new f();
    }

    private f() {
        if (com.mbridge.msdk.foundation.controller.a.e().g() != null) {
            this.a = new b(com.mbridge.msdk.foundation.controller.a.e().g());
        }
    }

    public final void a(com.mbridge.msdk.foundation.same.e.a aVar) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }
}
