package sg.bigo.ads.api.core;

import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.AdLoadListener;
import sg.bigo.ads.common.f.c;

public final class f<T extends Ad> implements AdLoadListener<T> {
    /* access modifiers changed from: private */
    public AdLoadListener<T> a;

    public f() {
    }

    public f(AdLoadListener<T> adLoadListener) {
        this.a = adLoadListener;
    }

    public final void onAdLoaded(final T t) {
        if (this.a != null) {
            c.a(2, new Runnable() {
                public final void run() {
                    f.this.a.onAdLoaded(t);
                }
            });
        }
    }

    public final void onError(final AdError adError) {
        if (this.a != null) {
            c.a(2, new Runnable() {
                public final void run() {
                    f.this.a.onError(adError);
                }
            });
        }
    }
}
