package com.bytedance.sdk.component.adexpress.dynamic.animation.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RubInAnimation */
public class i extends d {
    /* access modifiers changed from: private */
    public a d;
    /* access modifiers changed from: private */
    public float e;
    private float f;

    public i(View view, com.bytedance.sdk.component.adexpress.dynamic.b.a aVar) {
        super(view, aVar);
    }

    /* access modifiers changed from: package-private */
    public List<ObjectAnimator> a() {
        int i;
        String str;
        if ((this.c instanceof ImageView) && (this.c.getParent() instanceof DynamicBaseWidget)) {
            this.c = (View) this.c.getParent();
        }
        this.c.setAlpha(0.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.c, "alpha", new float[]{0.0f, 1.0f}).setDuration((long) ((int) (this.b.j() * 1000.0d)));
        this.d = new a(this.c);
        final int i2 = this.c.getLayoutParams().height;
        this.e = (float) i2;
        this.f = (float) this.c.getLayoutParams().width;
        if (TtmlNode.LEFT.equals(this.b.a()) || TtmlNode.RIGHT.equals(this.b.a())) {
            i = (int) this.f;
            str = "width";
        } else {
            str = "height";
            i = i2;
        }
        ObjectAnimator duration2 = ObjectAnimator.ofInt(this.d, str, new int[]{0, i}).setDuration((long) ((int) (this.b.j() * 1000.0d)));
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(duration));
        arrayList.add(a(duration2));
        ((ObjectAnimator) arrayList.get(0)).addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator, boolean z) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationStart(Animator animator, boolean z) {
            }

            public void onAnimationEnd(Animator animator) {
                i.this.d.a(i2);
            }
        });
        return arrayList;
    }

    /* compiled from: RubInAnimation */
    private class a {
        private View b;

        public a(View view) {
            this.b = view;
        }

        public void a(int i) {
            if ("top".equals(i.this.b.a())) {
                if (i.this.c instanceof ViewGroup) {
                    for (int i2 = 0; i2 < ((ViewGroup) i.this.c).getChildCount(); i2++) {
                        ((ViewGroup) i.this.c).getChildAt(i2).setTranslationY(((float) i) - i.this.e);
                    }
                }
                i.this.c.setTranslationY(i.this.e - ((float) i));
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
            layoutParams.height = i;
            this.b.setLayoutParams(layoutParams);
            this.b.requestLayout();
        }
    }
}
