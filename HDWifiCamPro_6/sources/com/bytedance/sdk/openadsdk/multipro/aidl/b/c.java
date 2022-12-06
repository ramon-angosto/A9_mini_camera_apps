package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.l.w;

/* compiled from: FullScreenVideoListenerImpl */
public class c extends IFullScreenVideoAdInteractionListener.Stub {
    /* access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.a.c.c a;

    public c(com.bytedance.sdk.openadsdk.a.c.c cVar) {
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
                    if (c.this.a != null) {
                        c.this.a.a();
                    }
                }
            });
        }
    }

    public void onAdVideoBarClick() throws RemoteException {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    if (c.this.a != null) {
                        c.this.a.b();
                    }
                }
            });
        }
    }

    public void onAdClose() throws RemoteException {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    if (c.this.a != null) {
                        c.this.a.c();
                    }
                }
            });
        }
    }

    public void onVideoComplete() throws RemoteException {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    if (c.this.a != null) {
                        c.this.a.d();
                    }
                }
            });
        }
    }

    public void onSkippedVideo() throws RemoteException {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    if (c.this.a != null) {
                        c.this.a.e();
                    }
                }
            });
        }
    }
}
