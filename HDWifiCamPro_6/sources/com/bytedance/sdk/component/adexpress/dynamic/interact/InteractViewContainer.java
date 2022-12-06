package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.b.g;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.dynamic.interact.a.a;
import com.bytedance.sdk.component.adexpress.dynamic.interact.a.b;
import com.bytedance.sdk.component.adexpress.dynamic.interact.a.c;
import com.bytedance.sdk.component.adexpress.dynamic.interact.a.d;
import com.bytedance.sdk.component.adexpress.dynamic.interact.a.e;
import com.bytedance.sdk.component.adexpress.dynamic.interact.a.f;
import com.bytedance.sdk.component.adexpress.widget.CircleLongPressView;
import com.bytedance.sdk.component.adexpress.widget.DynamicBrushMaskView;
import com.bytedance.sdk.component.adexpress.widget.RippleView;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;
import com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView;

public class InteractViewContainer extends FrameLayout implements d {
    private Context a;
    private DynamicBaseWidget b;
    private g c;
    private View d;
    private c e;
    private String f;
    /* access modifiers changed from: private */
    public RippleView g;
    private View.OnTouchListener h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private DynamicBrushMaskView n;

    public InteractViewContainer(Context context, DynamicBaseWidget dynamicBaseWidget, g gVar) {
        super(context);
        this.a = context;
        this.b = dynamicBaseWidget;
        this.c = gVar;
        e();
    }

    public InteractViewContainer(Context context, DynamicBaseWidget dynamicBaseWidget, g gVar, int i2, int i3, int i4, int i5) {
        super(context);
        this.a = context;
        this.b = dynamicBaseWidget;
        this.c = gVar;
        this.j = i2;
        this.k = i3;
        this.l = i4;
        this.m = i5;
        e();
    }

    private void e() {
        setBackgroundColor(0);
        setClipChildren(false);
        setClipToPadding(false);
        this.f = this.c.F();
        this.i = this.c.H();
        this.e = e.a(this.a, this.b, this.c, this.j, this.k, this.l, this.m);
        c cVar = this.e;
        if (cVar != null) {
            this.d = cVar.d();
            if (TextUtils.equals(this.f, "6")) {
                this.g = new RippleView(this.a);
                addView(this.g, new FrameLayout.LayoutParams(-1, -1));
                post(new Runnable() {
                    public void run() {
                        InteractViewContainer.this.g.b();
                    }
                });
            }
            if (TextUtils.equals(this.f, "20")) {
                this.n = (DynamicBrushMaskView) this.e.d();
            }
            addView(this.e.d());
            a(this.e.d());
            setVisibility(0);
        }
    }

    private void a(ViewGroup viewGroup) {
        if (this.d != null) {
            String str = this.f;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 50) {
                if (hashCode != 1598) {
                    if (hashCode != 1600) {
                        switch (hashCode) {
                            case 53:
                                if (str.equals("5")) {
                                    c2 = 7;
                                    break;
                                }
                                break;
                            case 54:
                                if (str.equals("6")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case 55:
                                if (str.equals("7")) {
                                    c2 = 10;
                                    break;
                                }
                                break;
                            case 56:
                                if (str.equals("8")) {
                                    c2 = 5;
                                    break;
                                }
                                break;
                            case 57:
                                if (str.equals("9")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            default:
                                switch (hashCode) {
                                    case 1568:
                                        if (str.equals("11")) {
                                            c2 = 4;
                                            break;
                                        }
                                        break;
                                    case 1569:
                                        if (str.equals("12")) {
                                            c2 = 6;
                                            break;
                                        }
                                        break;
                                    case 1570:
                                        if (str.equals("13")) {
                                            c2 = 2;
                                            break;
                                        }
                                        break;
                                    case 1571:
                                        if (str.equals("14")) {
                                            c2 = 8;
                                            break;
                                        }
                                        break;
                                    default:
                                        switch (hashCode) {
                                            case 1573:
                                                if (str.equals("16")) {
                                                    c2 = 11;
                                                    break;
                                                }
                                                break;
                                            case 1574:
                                                if (str.equals("17")) {
                                                    c2 = 1;
                                                    break;
                                                }
                                                break;
                                            case 1575:
                                                if (str.equals("18")) {
                                                    c2 = 12;
                                                    break;
                                                }
                                                break;
                                        }
                                }
                        }
                    } else if (str.equals("22")) {
                        c2 = 14;
                    }
                } else if (str.equals("20")) {
                    c2 = 13;
                }
            } else if (str.equals("2")) {
                c2 = 9;
            }
            switch (c2) {
                case 0:
                case 1:
                    this.d.setTag(2);
                    break;
                case 2:
                    this.h = new d(this, this.i);
                    break;
                case 3:
                    setBackgroundColor(Color.parseColor("#80000000"));
                    this.h = new e(this);
                    break;
                case 4:
                case 5:
                    this.b.setClipChildren(false);
                    this.b.setClipChildren(false);
                    ViewGroup viewGroup2 = (ViewGroup) this.b.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.setClipChildren(false);
                        viewGroup2.setClipToPadding(false);
                    }
                    this.h = new e(this);
                    break;
                case 6:
                    this.h = new c(this);
                    break;
                case 7:
                    setBackgroundColor(Color.parseColor("#80000000"));
                    this.h = new c(this);
                    break;
                case 8:
                    this.h = new b(this, this);
                    break;
                case 9:
                case 10:
                    setBackgroundColor(Color.parseColor("#80000000"));
                    this.h = new b(this, this);
                    break;
                case 11:
                    View view = this.d;
                    if (!(view == null || !(view instanceof ShakeAnimationView) || ((ShakeAnimationView) view).getShakeLayout() == null)) {
                        ((ShakeAnimationView) this.d).getShakeLayout().setTag(2);
                    }
                    this.d.setTag(2);
                    break;
                case 12:
                    View view2 = this.d;
                    if (!(view2 == null || !(view2 instanceof WriggleGuideAnimationView) || ((WriggleGuideAnimationView) view2).getWriggleLayout() == null)) {
                        ((WriggleGuideAnimationView) this.d).getWriggleLayout().setTag(2);
                    }
                    this.d.setTag(2);
                    break;
                case 13:
                    this.h = new a(this, this.i, viewGroup);
                    break;
                case 14:
                    this.h = new f(this, this.i, viewGroup);
                    break;
            }
            View.OnTouchListener onTouchListener = this.h;
            if (onTouchListener != null) {
                setOnTouchListener(onTouchListener);
            }
            if (f()) {
                setOnClickListener((View.OnClickListener) this.b.getDynamicClickListener());
            }
        }
    }

    private boolean f() {
        if (!this.c.M() && !TextUtils.equals("9", this.f) && !TextUtils.equals("16", this.f) && !TextUtils.equals("17", this.f) && !TextUtils.equals("18", this.f) && !TextUtils.equals("20", this.f)) {
            return true;
        }
        return false;
    }

    public void b() {
        c cVar = this.e;
        if (cVar != null) {
            cVar.a();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.e;
        if (cVar != null) {
            cVar.b();
        }
    }

    public void c() {
        if (this.d != null && TextUtils.equals(this.f, "2")) {
            View view = this.d;
            if (view instanceof CircleLongPressView) {
                ((CircleLongPressView) view).c();
            }
        }
    }

    public void d() {
        if (this.d != null && TextUtils.equals(this.f, "2")) {
            View view = this.d;
            if (view instanceof CircleLongPressView) {
                ((CircleLongPressView) view).d();
            }
        }
    }

    public void a() {
        if (TextUtils.equals(this.f, "6")) {
            RippleView rippleView = this.g;
            if (rippleView != null) {
                rippleView.c();
                postDelayed(new Runnable() {
                    public void run() {
                        InteractViewContainer.this.g();
                    }
                }, 300);
            }
        } else if (TextUtils.equals(this.f, "20")) {
            DynamicBrushMaskView dynamicBrushMaskView = this.n;
            if (dynamicBrushMaskView != null) {
                dynamicBrushMaskView.b();
                postDelayed(new Runnable() {
                    public void run() {
                        InteractViewContainer.this.g();
                    }
                }, 400);
            }
        } else {
            g();
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        if (this.h != null) {
            setOnClickListener((View.OnClickListener) this.b.getDynamicClickListener());
            performClick();
        }
    }
}
