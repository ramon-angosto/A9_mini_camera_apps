package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.l.y;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class EmptyView extends View implements x.a {
    private boolean a;
    private boolean b;
    /* access modifiers changed from: private */
    public a c;
    /* access modifiers changed from: private */
    public View d;
    private List<View> e;
    private List<View> f;
    private boolean g;
    private int h;
    private final Handler i = new x(k.c().getLooper(), this);
    private final AtomicBoolean j = new AtomicBoolean(true);
    private Runnable k = new Runnable() {
        public void run() {
            if (EmptyView.this.c != null) {
                EmptyView.this.c.a(EmptyView.this.d);
            }
        }
    };

    public interface a {
        void a();

        void a(View view);

        void a(boolean z);

        void b();
    }

    public EmptyView(Context context, View view) {
        super(m.a());
        this.d = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
        this.g = false;
        b();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        b();
    }

    private void b() {
        a aVar;
        if (this.j.getAndSet(false) && (aVar = this.c) != null) {
            aVar.a();
        }
    }

    private void c() {
        a aVar;
        if (!this.j.getAndSet(true) && (aVar = this.c) != null) {
            aVar.b();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
        this.g = true;
        c();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        c();
    }

    public void setRefClickViews(List<View> list) {
        this.e = list;
    }

    public void setRefCreativeViews(List<View> list) {
        this.f = list;
    }

    public void a() {
        a(this.e, (c) null);
        a(this.f, (c) null);
    }

    public void a(List<View> list, c cVar) {
        if (j.b(list)) {
            for (View next : list) {
                if (next != null) {
                    next.setOnClickListener(cVar);
                    next.setOnTouchListener(cVar);
                }
            }
        }
    }

    private void d() {
        if (this.b && !this.a) {
            this.a = true;
            this.i.sendEmptyMessage(1);
        }
    }

    private void e() {
        if (this.a) {
            this.i.removeCallbacksAndMessages((Object) null);
            this.a = false;
        }
    }

    public void setNeedCheckingShow(boolean z) {
        this.b = z;
        if (!z && this.a) {
            e();
        } else if (z && !this.a) {
            d();
        }
    }

    public void setCallback(a aVar) {
        this.c = aVar;
    }

    public void setAdType(int i2) {
        this.h = i2;
    }

    public void a(Message message) {
        int i2 = message.what;
        if (i2 != 1) {
            if (i2 == 2) {
                boolean a2 = y.a();
                if (v.a(this.d, 20, this.h) || !a2) {
                    this.i.sendEmptyMessageDelayed(2, 1000);
                } else if (!this.g) {
                    setNeedCheckingShow(true);
                }
            }
        } else if (!this.a) {
        } else {
            if (v.a(this.d, 20, this.h)) {
                e();
                this.i.sendEmptyMessageDelayed(2, 1000);
                post(this.k);
                return;
            }
            this.i.sendEmptyMessageDelayed(1, 1000);
        }
    }
}
