package com.mbridge.msdk.mbbanner.common.util;

import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.mbbanner.common.b.b;

/* compiled from: BannerDelivery */
public class a {
    private static final String a = a.class.getSimpleName();
    private final Handler b = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public boolean c;

    public final void a(boolean z) {
        this.c = z;
    }

    public final void a(final b bVar, final CampaignUnit campaignUnit, final String str) {
        this.b.post(new Runnable() {
            public final void run() {
                b bVar = bVar;
                if (bVar != null) {
                    bVar.a(str, campaignUnit, a.this.c);
                }
            }
        });
    }

    public final void a(final b bVar, final String str, final String str2) {
        this.b.post(new Runnable() {
            public final void run() {
                b bVar = bVar;
                if (bVar != null) {
                    bVar.a(str2, str, a.this.c);
                }
            }
        });
    }

    public final void a(final b bVar, final String str) {
        this.b.post(new Runnable() {
            public final void run() {
                b bVar = bVar;
                if (bVar != null) {
                    bVar.a(str, a.this.c);
                }
            }
        });
    }

    public final void b(final b bVar, final String str) {
        this.b.post(new Runnable() {
            public final void run() {
                b bVar = bVar;
                if (bVar != null) {
                    bVar.b(str, a.this.c);
                }
            }
        });
    }
}
