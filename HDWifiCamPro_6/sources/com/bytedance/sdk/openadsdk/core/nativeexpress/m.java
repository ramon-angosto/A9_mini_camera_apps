package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.b.f;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.model.g;
import com.bytedance.sdk.openadsdk.l.z;

/* compiled from: ViewGestureDetector */
public class m extends GestureDetector {
    private final a a;
    private final f b;

    public m(Context context) {
        this(context, new a());
    }

    public m(Context context, a aVar) {
        super(context, aVar);
        this.a = aVar;
        this.b = new f();
        setIsLongpressEnabled(false);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.a.a();
    }

    public boolean b() {
        return this.a.b();
    }

    public g a(Context context, View view, View view2) {
        if (this.b == null) {
            return new g.a().a();
        }
        return new g.a().f(this.b.a).e(this.b.b).d(this.b.c).c(this.b.d).b(this.b.e).a(this.b.f).b(z.a(view)).a(z.a(view2)).c(z.c(view)).d(z.c(view2)).d(this.b.g).e(this.b.h).f(this.b.i).a(this.b.l).b(h.d().b() ? 1 : 2).a("vessel").a(z.e(context)).c(z.g(context)).b(z.f(context)).a();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.b.a(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    /* compiled from: ViewGestureDetector */
    static class a extends GestureDetector.SimpleOnGestureListener {
        boolean a = false;

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.a = false;
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return this.a;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            this.a = true;
            return super.onSingleTapUp(motionEvent);
        }
    }
}
