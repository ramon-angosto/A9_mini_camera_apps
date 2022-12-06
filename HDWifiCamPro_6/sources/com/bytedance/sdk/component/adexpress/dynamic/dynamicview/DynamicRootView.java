package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.b.j;
import com.bytedance.sdk.component.adexpress.b.l;
import com.bytedance.sdk.component.adexpress.b.m;
import com.bytedance.sdk.component.adexpress.dynamic.b;
import com.bytedance.sdk.component.adexpress.dynamic.b.e;
import com.bytedance.sdk.component.adexpress.dynamic.b.f;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.adexpress.dynamic.c;
import com.bytedance.sdk.component.adexpress.dynamic.d;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.adexpress.theme.a;
import java.util.ArrayList;
import java.util.List;

public class DynamicRootView extends FrameLayout implements c, a {
    protected final m a;
    boolean b;
    private j c;
    private DynamicBaseWidget d;
    private com.bytedance.sdk.component.adexpress.dynamic.d.a e;
    private ThemeStatusBroadcastReceiver f;
    private com.bytedance.sdk.component.adexpress.dynamic.a g;
    private ViewGroup h = null;
    private int i = 0;
    private List<b> j = new ArrayList();
    private d k;
    private int l = 0;
    private int m = 0;
    private l n;
    private Context o;
    private String p;

    public DynamicRootView(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, l lVar, com.bytedance.sdk.component.adexpress.dynamic.d.a aVar) {
        super(context);
        this.o = context;
        this.a = new m();
        this.a.a(2);
        this.e = aVar;
        this.e.a((View) this);
        this.f = themeStatusBroadcastReceiver;
        this.f.a(this);
        this.b = z;
        this.n = lVar;
    }

    public String getBgColor() {
        return this.p;
    }

    public void setBgColor(String str) {
        this.p = str;
    }

    public void setRenderListener(j jVar) {
        this.c = jVar;
        this.e.a(jVar);
    }

    public void a(h hVar, int i2) {
        this.d = a(hVar, this, i2);
        this.a.a(true);
        this.a.a((double) this.d.e);
        this.a.b((double) this.d.f);
        this.c.a(this.a);
    }

    public DynamicBaseWidget a(h hVar, ViewGroup viewGroup, int i2) {
        if (hVar == null) {
            return null;
        }
        DynamicBaseWidget a2 = com.bytedance.sdk.component.adexpress.dynamic.a.b.a(this.o, this, hVar);
        if (a2 instanceof DynamicUnKnowView) {
            a(i2 == 3 ? 128 : 118);
            return null;
        }
        a(hVar);
        a2.c();
        if (viewGroup != null) {
            viewGroup.addView(a2);
            a(viewGroup, hVar);
        }
        List<h> j2 = hVar.j();
        if (j2 == null || j2.size() <= 0) {
            return null;
        }
        for (h a3 : j2) {
            a(a3, a2, i2);
        }
        return a2;
    }

    private void a(h hVar) {
        f e2;
        e i2 = hVar.i();
        if (i2 != null && (e2 = i2.e()) != null) {
            this.a.b(e2.ao());
        }
    }

    private void a(ViewGroup viewGroup, h hVar) {
        ViewGroup viewGroup2;
        if (viewGroup != null && (viewGroup2 = (ViewGroup) viewGroup.getParent()) != null && hVar.t()) {
            viewGroup2.setClipChildren(false);
            viewGroup2.setClipToPadding(false);
            ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
            if (viewGroup3 != null) {
                viewGroup3.setClipChildren(false);
                viewGroup3.setClipToPadding(false);
            }
        }
    }

    public void a(double d2, double d3, double d4, double d5, float f2) {
        this.a.c(d2);
        this.a.d(d3);
        this.a.e(d4);
        this.a.f(d5);
        this.a.a(f2);
        this.a.b(f2);
        this.a.c(f2);
        this.a.d(f2);
    }

    public void a(int i2) {
        this.a.a(false);
        this.a.b(i2);
        this.c.a(this.a);
    }

    public void setMuteListener(com.bytedance.sdk.component.adexpress.dynamic.a aVar) {
        this.g = aVar;
    }

    public void setDislikeView(View view) {
        this.e.b(view);
    }

    public j getRenderListener() {
        return this.c;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.d.a getDynamicClickListener() {
        return this.e;
    }

    public void b(int i2) {
        DynamicBaseWidget dynamicBaseWidget = this.d;
        if (dynamicBaseWidget != null) {
            dynamicBaseWidget.a(i2);
        }
    }

    public void a(CharSequence charSequence, int i2, int i3, boolean z) {
        for (int i4 = 0; i4 < this.j.size(); i4++) {
            if (this.j.get(i4) != null) {
                b bVar = this.j.get(i4);
                boolean z2 = true;
                if (i2 != 1) {
                    z2 = false;
                }
                bVar.a(charSequence, z2, i3, z);
            }
        }
    }

    public void setSoundMute(boolean z) {
        com.bytedance.sdk.component.adexpress.dynamic.a aVar = this.g;
        if (aVar != null) {
            aVar.setSoundMute(z);
        }
    }

    public void setTimeUpdate(int i2) {
        this.k.setTimeUpdate(i2);
    }

    public void f() {
        try {
            this.k.a();
        } catch (Exception unused) {
        }
    }

    public ViewGroup getTimeOut() {
        return this.h;
    }

    public void setTimeOut(ViewGroup viewGroup) {
        this.h = viewGroup;
    }

    public int getTimedown() {
        return this.i;
    }

    public void setTimedown(int i2) {
        this.i = i2;
    }

    public List<b> getTimeOutListener() {
        return this.j;
    }

    public void setTimeOutListener(b bVar) {
        this.j.add(bVar);
    }

    public void setVideoListener(d dVar) {
        this.k = dVar;
    }

    public int getScoreCountWithIcon() {
        return this.m;
    }

    public void setScoreCountWithIcon(int i2) {
        this.m = i2;
    }

    public int getLogoUnionHeight() {
        return this.l;
    }

    public void setLogoUnionHeight(int i2) {
        this.l = i2;
    }

    public l getRenderRequest() {
        return this.n;
    }
}
