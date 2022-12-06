package com.bytedance.sdk.openadsdk.core.f;

import android.view.View;
import com.a.a.a.a.b.a;
import com.a.a.a.a.b.a.b;
import com.a.a.a.a.b.a.c;
import com.a.a.a.a.b.a.d;
import com.a.a.a.a.b.a.e;

/* compiled from: ViewabilityTrackerForVideo */
public class i extends g {
    private final b e;
    private boolean f;

    public i(com.a.a.a.a.b.b bVar, a aVar, View view, b bVar2) {
        super(bVar, aVar, view);
        this.e = bVar2;
    }

    public void a(boolean z, float f2) {
        if (z) {
            this.d = e.a(f2, true, d.STANDALONE);
        } else {
            this.d = e.a(true, d.STANDALONE);
        }
        a(2);
    }

    public void a(float f2, boolean z) {
        if (a()) {
            this.e.a(f2, z ? 0.0f : 1.0f);
        }
    }

    public void a(boolean z) {
        this.f = z;
        b(12);
    }

    public void b(int i) {
        if (a()) {
            switch (i) {
                case 0:
                    this.e.e();
                    return;
                case 1:
                    this.e.f();
                    return;
                case 2:
                case 14:
                    this.e.i();
                    return;
                case 4:
                    this.e.g();
                    return;
                case 5:
                    this.e.h();
                    return;
                case 6:
                    this.e.a();
                    return;
                case 7:
                    this.e.b();
                    return;
                case 8:
                    this.e.c();
                    return;
                case 9:
                    this.e.d();
                    return;
                case 10:
                    this.e.a(c.FULLSCREEN);
                    return;
                case 11:
                    this.e.a(c.NORMAL);
                    return;
                case 12:
                    this.e.a(this.f ? 0.0f : 1.0f);
                    return;
                case 13:
                    this.e.a(com.a.a.a.a.b.a.a.CLICK);
                    return;
                default:
                    return;
            }
        }
    }
}
