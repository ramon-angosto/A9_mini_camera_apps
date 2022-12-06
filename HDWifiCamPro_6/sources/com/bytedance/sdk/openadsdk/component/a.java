package com.bytedance.sdk.openadsdk.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.component.g.e;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.a.d.c;
import com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.l.o;
import com.bytedance.sdk.openadsdk.multipro.b;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: PAGAppOpenAdImpl */
public class a extends PAGAppOpenAd {
    /* access modifiers changed from: private */
    public final Context a;
    private final n b;
    /* access modifiers changed from: private */
    public c c;
    private final AtomicBoolean d = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final String e;
    private final boolean f;

    public a(Context context, n nVar, boolean z) {
        this.a = context;
        this.b = nVar;
        this.f = z;
        this.e = o.a();
    }

    public void setAdInteractionListener(PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener) {
        this.c = new b(pAGAppOpenAdInteractionListener);
        a();
    }

    public void a(c cVar) {
        this.c = cVar;
        a();
    }

    private void a() {
        if (b.c()) {
            e.c(new g("AppOpenAd_registerMultiProcessListener") {
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.a a2 = com.bytedance.sdk.openadsdk.multipro.aidl.a.a(a.this.a);
                    if (a.this.c != null) {
                        l.b("MultiProcess", "start registerAppOpenListener ! ");
                        IListenerManager asInterface = com.bytedance.sdk.openadsdk.multipro.aidl.a.b.asInterface(a2.a(7));
                        if (asInterface != null) {
                            try {
                                asInterface.registerAppOpenAdListener(a.this.e, new com.bytedance.sdk.openadsdk.multipro.aidl.b.a(a.this.c));
                                c unused = a.this.c = null;
                                l.b("MultiProcess", "end registerAppOpenAdListener ! ");
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }, 5);
        }
    }

    public void show(Activity activity) {
        Context context;
        if (activity != null && activity.isFinishing()) {
            activity = null;
        }
        int i = 1;
        if (!this.d.getAndSet(true)) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                if (activity != null) {
                    context = activity;
                } else {
                    context = this.a;
                }
                if (context == null) {
                    context = m.a();
                }
                int i2 = 0;
                try {
                    i2 = activity.getWindowManager().getDefaultDisplay().getRotation();
                } catch (Exception unused) {
                }
                Intent intent = new Intent(context, TTAppOpenAdActivity.class);
                intent.putExtra("orientation_angle", i2);
                if (!this.f) {
                    i = 2;
                }
                intent.putExtra("ad_source", i);
                if (b.c()) {
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, this.b.ar().toString());
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_META_MD5, this.e);
                } else {
                    r.a().h();
                    r.a().a(this.b);
                    r.a().a(this.c);
                    this.c = null;
                }
                com.bytedance.sdk.component.utils.b.a(context, intent, new b.a() {
                    public void a() {
                        l.b("TTAppOpenAdImpl", "app open ad startActivitySuccess");
                    }

                    public void a(Throwable th) {
                        l.b("TTAppOpenAdImpl", "app open ad startActivityFail");
                    }
                });
                return;
            }
            l.e("TTAppOpenAdImpl", "showTTAppOpenAd error: not main looper");
            throw new IllegalStateException("Cannot be called in a child thread ---- TTAppOpenAdImpl.showAppOpenAd");
        }
    }
}
