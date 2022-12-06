package com.mbridge.msdk.mbbanner.common.b;

import com.mbridge.msdk.mbbanner.common.c.b;
import com.mbridge.msdk.videocommon.download.g;

/* compiled from: DownloadBannerUrlListener */
public class e implements g.b {
    private static final String a = e.class.getSimpleName();
    private String b;
    private b c;

    public e(b bVar, String str) {
        this.c = bVar;
        this.b = str;
    }

    public final void a(String str) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.a(this.b, 3, str, true);
        }
    }

    public final void a(String str, String str2) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.a(this.b, 3, str, false);
        }
    }
}
