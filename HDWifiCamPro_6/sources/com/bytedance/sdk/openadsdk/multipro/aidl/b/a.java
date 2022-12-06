package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener;
import com.bytedance.sdk.openadsdk.a.d.c;
import com.bytedance.sdk.openadsdk.l.w;

/* compiled from: AppOpenAdListenerImpl */
public class a extends IAppOpenAdInteractionListener.Stub {
    /* access modifiers changed from: private */
    public c a;

    public a(c cVar) {
        this.a = cVar;
    }

    private void a() {
        this.a = null;
    }

    public void onDestroy() throws RemoteException {
        a();
    }

    public void onAdShow() throws RemoteException {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    if (a.this.a != null) {
                        a.this.a.a();
                    }
                }
            });
        }
    }

    public void onAdClicked() throws RemoteException {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    if (a.this.a != null) {
                        a.this.a.b();
                    }
                }
            });
        }
    }

    public void onAdSkip() throws RemoteException {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    if (a.this.a != null) {
                        a.this.a.c();
                    }
                }
            });
        }
    }

    public void onAdTimeOver() throws RemoteException {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    if (a.this.a != null) {
                        a.this.a.d();
                    }
                }
            });
        }
    }
}
