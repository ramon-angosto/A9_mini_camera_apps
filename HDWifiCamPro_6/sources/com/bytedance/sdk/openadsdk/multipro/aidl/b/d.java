package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.a.e.b;
import com.bytedance.sdk.openadsdk.l.w;

/* compiled from: RewardVideoListenerImpl */
public class d extends IRewardAdInteractionListener.Stub {
    /* access modifiers changed from: private */
    public b a;

    public d(b bVar) {
        this.a = bVar;
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
                    if (d.this.a != null) {
                        d.this.a.a();
                    }
                }
            });
        }
    }

    public void onAdVideoBarClick() throws RemoteException {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    if (d.this.a != null) {
                        d.this.a.b();
                    }
                }
            });
        }
    }

    public void onAdClose() throws RemoteException {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    if (d.this.a != null) {
                        d.this.a.c();
                    }
                }
            });
        }
    }

    public void onVideoComplete() throws RemoteException {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    if (d.this.a != null) {
                        d.this.a.d();
                    }
                }
            });
        }
    }

    public void onVideoError() throws RemoteException {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    if (d.this.a != null) {
                        d.this.a.e();
                    }
                }
            });
        }
    }

    public void onSkippedVideo() throws RemoteException {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    if (d.this.a != null) {
                        d.this.a.f();
                    }
                }
            });
        }
    }

    public void onRewardVerify(boolean z, int i, String str, int i2, String str2) throws RemoteException {
        if (this.a != null) {
            final boolean z2 = z;
            final int i3 = i;
            final String str3 = str;
            final int i4 = i2;
            final String str4 = str2;
            w.a((Runnable) new Runnable() {
                public void run() {
                    if (d.this.a != null) {
                        d.this.a.a(z2, i3, str3, i4, str4);
                    }
                }
            });
        }
    }
}
