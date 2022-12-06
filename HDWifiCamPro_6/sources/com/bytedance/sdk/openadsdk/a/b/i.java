package com.bytedance.sdk.openadsdk.a.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.h.a.b;
import com.bytedance.sdk.openadsdk.k.a.e;
import com.bytedance.sdk.openadsdk.l.o;
import com.bytedance.sdk.openadsdk.l.s;
import com.bytedance.sdk.openadsdk.l.y;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: TTNativeAdImpl */
public class i extends PAGNativeAd {
    protected final l a;
    protected final n b;
    protected final Context c;
    protected a d;
    protected int e;
    protected int f;
    protected String g;
    private boolean h;
    private boolean i;

    private String a(int i2) {
        return i2 != 1 ? i2 != 2 ? (i2 == 5 || i2 != 9) ? "embeded_ad" : "draw_ad" : "interaction" : "banner_ad";
    }

    public void showPrivacyActivity() {
    }

    public i(Context context, n nVar, int i2) {
        if (nVar == null) {
            com.bytedance.sdk.component.utils.l.d("materialMeta can't been null");
        }
        this.b = nVar;
        this.c = context;
        this.e = i2;
        this.f = nVar.aW();
        this.g = y.b(i2);
        this.d = new a(this.c, nVar, this.g);
        this.a = new l(this.c, this, nVar, a(i2), this.d);
    }

    /* access modifiers changed from: protected */
    public List<View> a(List<View> list, List<View> list2) {
        LinkedList linkedList = new LinkedList();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                linkedList.add(list.get(i2));
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            int size2 = list2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                linkedList.add(list2.get(i3));
            }
        }
        return linkedList;
    }

    public Map<String, Object> getMediaExtraInfo() {
        n nVar = this.b;
        if (nVar != null) {
            return nVar.aj();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        b c2 = b.b().a(this.e).c(String.valueOf(this.f));
        if (z) {
            com.bytedance.sdk.openadsdk.h.b.a().c(c2);
        } else {
            com.bytedance.sdk.openadsdk.h.b.a().d(c2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        n nVar = this.b;
        if (nVar == null || nVar.L() == 5 || m.d().b(this.f) != 1) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
        this.g = str;
    }

    public void win(Double d2) {
        if (!this.h) {
            s.a(this.b, d2);
            this.h = true;
        }
    }

    public void loss(Double d2, String str, String str2) {
        if (!this.i) {
            s.a(this.b, d2, str, str2);
            this.i = true;
        }
    }

    public void setPrice(Double d2) {
        l lVar = this.a;
        if (lVar != null) {
            lVar.a(d2);
        }
    }

    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, PAGNativeAdInteractionListener pAGNativeAdInteractionListener) {
        if (viewGroup == null) {
            com.bytedance.sdk.component.utils.l.d("container can't been null");
        } else if (list == null) {
            com.bytedance.sdk.component.utils.l.d("clickView can't been null");
        } else if (list.size() <= 0) {
            com.bytedance.sdk.component.utils.l.d("clickViews size must been more than 1");
        } else {
            a(viewGroup, (List<View>) null, list, list2, view, new h(pAGNativeAdInteractionListener));
        }
    }

    public void a(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, final g gVar) {
        if (viewGroup == null) {
            com.bytedance.sdk.component.utils.l.d("container can't been null");
        } else if (list2 == null) {
            com.bytedance.sdk.component.utils.l.d("clickView can't been null");
        } else if (list2.size() <= 0) {
            com.bytedance.sdk.component.utils.l.d("clickViews size must been more than 1");
        } else {
            a(list3 != null && list3.size() > 0);
            if (h()) {
                list3 = a(list2, list3);
            }
            List<View> list4 = list3;
            if (!(view == null || gVar == null || !gVar.b())) {
                view.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        TTDelegateActivity.a(i.this.b, o.a(), (com.bytedance.sdk.openadsdk.dislike.b) new com.bytedance.sdk.openadsdk.dislike.b() {
                            public void a(int i, String str) {
                                gVar.a();
                                i.this.i().b().close();
                            }
                        });
                    }
                });
            }
            this.a.a(viewGroup, list, list2, list4, view, gVar);
            e.a(viewGroup, this.b, -1);
        }
    }

    public PAGNativeAdData getNativeAdData() {
        return new e(i());
    }

    public a i() {
        return this.d;
    }
}
