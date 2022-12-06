package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IDislikeClosedListener;
import com.bytedance.sdk.openadsdk.core.bannerexpress.a;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;
import com.bytedance.sdk.openadsdk.l.w;

/* compiled from: DislikeClosedListenerImpl */
public class b extends IDislikeClosedListener.Stub {
    /* access modifiers changed from: private */
    public final a.C0044a a;
    /* access modifiers changed from: private */
    public final String b;

    public b(String str, a.C0044a aVar) {
        this.b = str;
        this.a = aVar;
    }

    public void onItemClickClosed() throws RemoteException {
        w.a((Runnable) new Runnable() {
            public void run() {
                if (b.this.a != null) {
                    b.this.a.a();
                    TTDislikeListView.a(6, b.this.b);
                }
            }
        });
    }
}
