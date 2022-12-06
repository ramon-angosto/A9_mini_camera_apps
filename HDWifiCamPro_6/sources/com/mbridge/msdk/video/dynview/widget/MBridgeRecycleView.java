package com.mbridge.msdk.video.dynview.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.foundation.tools.u;
import java.lang.ref.WeakReference;

public class MBridgeRecycleView extends RecyclerView {
    private static int c = -1;
    a a;
    private float b;
    private float d;
    private float e;
    private int f;
    private float g;
    private int h;
    private boolean i;
    private LinearLayoutManager j;
    /* access modifiers changed from: private */
    public boolean k;
    /* access modifiers changed from: private */
    public boolean l;

    public MBridgeRecycleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0.0f;
        this.d = 0.0f;
        this.e = -1.0f;
        this.f = -1;
        this.g = 1.3f;
        this.i = false;
        this.a = new a(this);
        this.h = u.b(context, 40.0f);
    }

    public MBridgeRecycleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.b = 0.0f;
        this.d = 0.0f;
        this.e = -1.0f;
        this.f = -1;
        this.g = 1.3f;
        this.i = false;
    }

    public final void a(LinearLayoutManager linearLayoutManager) {
        this.j = linearLayoutManager;
    }

    static class a implements Runnable {
        private final WeakReference<MBridgeRecycleView> a;

        public a(MBridgeRecycleView mBridgeRecycleView) {
            this.a = new WeakReference<>(mBridgeRecycleView);
        }

        public final void run() {
            MBridgeRecycleView mBridgeRecycleView = (MBridgeRecycleView) this.a.get();
            if (mBridgeRecycleView != null && mBridgeRecycleView.k && mBridgeRecycleView.l) {
                mBridgeRecycleView.scrollBy(-1, 0);
                mBridgeRecycleView.postDelayed(mBridgeRecycleView.a, 16);
            }
        }
    }

    public final void a(boolean z) {
        this.i = z;
    }

    public final void a() {
        if (this.k) {
            this.k = false;
            removeCallbacks(this.a);
        }
        if (this.i) {
            this.l = true;
            this.k = true;
            postDelayed(this.a, 16);
        }
    }
}
