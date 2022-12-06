package com.mbridge.msdk.video.module;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.video.dynview.j.c;
import com.mbridge.msdk.video.module.a.a.e;
import com.mbridge.msdk.video.signal.factory.b;
import com.mbridge.msdk.widget.a;
import org.json.JSONException;
import org.json.JSONObject;

public class MBridgeClickCTAView extends MBridgeBaseView {
    private ViewGroup m;
    private ImageView n;
    private TextView o;
    private TextView p;
    /* access modifiers changed from: private */
    public TextView q;
    private String r;
    private float s;
    private float t;
    private int u;
    private ObjectAnimator v;

    public void init(Context context) {
    }

    public void setObjectAnimator(ObjectAnimator objectAnimator) {
        this.v = objectAnimator;
    }

    public void setUnitId(String str) {
        this.r = str;
    }

    public MBridgeClickCTAView(Context context) {
        super(context);
    }

    public MBridgeClickCTAView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public final void c() {
        super.c();
        if (this.f) {
            if (this.b != null && this.b.isDynamicView()) {
                setOnClickListener(new a() {
                    /* access modifiers changed from: protected */
                    public final void a(View view) {
                        MBridgeClickCTAView.b(MBridgeClickCTAView.this);
                    }
                });
            }
            this.p.setOnClickListener(new a() {
                /* access modifiers changed from: protected */
                public final void a(View view) {
                    MBridgeClickCTAView.b(MBridgeClickCTAView.this);
                }
            });
            ImageView imageView = this.n;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                    }
                });
            }
        }
    }

    public void preLoadData(b bVar) {
        if (this.b != null) {
            if (this.b.isDynamicView()) {
                com.mbridge.msdk.video.dynview.a.a().a(new c().a(this, this.b), new com.mbridge.msdk.video.dynview.d.c() {
                    public final void a(View view) {
                        this.addView(view);
                        MBridgeClickCTAView mBridgeClickCTAView = MBridgeClickCTAView.this;
                        mBridgeClickCTAView.f = mBridgeClickCTAView.b();
                        MBridgeClickCTAView mBridgeClickCTAView2 = MBridgeClickCTAView.this;
                        TextView unused = mBridgeClickCTAView2.q = (TextView) mBridgeClickCTAView2.findViewById(mBridgeClickCTAView2.findID("mbridge_tv_desc"));
                        MBridgeClickCTAView.this.c();
                    }

                    public final void a(com.mbridge.msdk.video.dynview.c.a aVar) {
                        q.d(MBridgeBaseView.TAG, "errorMsg:" + aVar.b());
                    }
                });
            } else {
                int findLayout = findLayout("mbridge_reward_clickable_cta");
                if (findLayout >= 0) {
                    this.c.inflate(findLayout, this);
                    this.f = b();
                    c();
                    setWrapContent();
                }
            }
            if (this.f) {
                this.p.setText(this.b.getAdCall());
                if (!TextUtils.isEmpty(this.b.getIconUrl())) {
                    this.o.setText(this.b.getAppName());
                    TextView textView = this.q;
                    if (textView != null) {
                        textView.setText(this.b.getAppDesc());
                    }
                    com.mbridge.msdk.foundation.same.c.b.a(this.a.getApplicationContext()).a(this.b.getIconUrl(), (com.mbridge.msdk.foundation.same.c.c) new e(this.n, this.b, this.r) {
                        public final void onFailedLoad(String str, String str2) {
                            super.onFailedLoad(str, str2);
                            MBridgeClickCTAView.this.a();
                        }
                    });
                    return;
                }
                a();
            }
        }
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.u = configuration.orientation;
    }

    /* access modifiers changed from: private */
    public void a() {
        this.m.setBackgroundColor(0);
        ImageView imageView = this.n;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = this.q;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public boolean b() {
        this.m = (ViewGroup) findViewById(findID("mbridge_viewgroup_ctaroot"));
        this.n = (ImageView) findViewById(findID("mbridge_iv_appicon"));
        this.o = (TextView) findViewById(findID("mbridge_tv_title"));
        this.p = (TextView) findViewById(findID("mbridge_tv_install"));
        return isNotNULL(this.m, this.n, this.o, this.p);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.s = motionEvent.getRawX();
        this.t = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ObjectAnimator objectAnimator = this.v;
        if (objectAnimator != null) {
            try {
                objectAnimator.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.v;
        if (objectAnimator != null) {
            try {
                objectAnimator.cancel();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static /* synthetic */ void b(MBridgeClickCTAView mBridgeClickCTAView) {
        JSONObject jSONObject;
        JSONException e;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(com.mbridge.msdk.foundation.same.a.g, mBridgeClickCTAView.a(0));
            } catch (JSONException e2) {
                e = e2;
            }
        } catch (JSONException e3) {
            JSONException jSONException = e3;
            jSONObject = null;
            e = jSONException;
            e.printStackTrace();
            mBridgeClickCTAView.e.a(105, jSONObject);
        }
        mBridgeClickCTAView.e.a(105, jSONObject);
    }
}
