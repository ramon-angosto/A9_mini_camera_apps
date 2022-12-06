package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.video.module.a.a.j;
import com.mbridge.msdk.video.signal.factory.b;
import org.json.JSONException;
import org.json.JSONObject;

public class MBridgeVideoEndCoverView extends MBridgeBaseView {
    private final String m = "MBridgeVideoEndCoverView";
    private View n;
    private ImageView o;
    private ImageView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private b t;

    public MBridgeVideoEndCoverView(Context context) {
        super(context);
    }

    public MBridgeVideoEndCoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void init(Context context) {
        int findLayout = findLayout("mbridge_reward_videoend_cover");
        if (findLayout >= 0) {
            this.n = this.c.inflate(findLayout, (ViewGroup) null);
            View view = this.n;
            if (view != null) {
                this.f = a(view);
                addView(this.n, -1, -1);
                c();
            }
        }
    }

    public void preLoadData(b bVar) {
        this.t = bVar;
        try {
            if (this.b != null && this.f && this.b != null) {
                if (!TextUtils.isEmpty(this.b.getIconUrl()) && this.o != null) {
                    com.mbridge.msdk.foundation.same.c.b.a(this.a.getApplicationContext()).a(this.b.getIconUrl(), (c) new j(this.o, u.b(a.e().g(), 8.0f)));
                }
                if (this.q != null) {
                    this.q.setText(this.b.getAppName());
                }
                if (this.s != null) {
                    this.s.setText(this.b.getAdCall());
                }
                if (this.r != null) {
                    this.r.setText(this.b.getAppDesc());
                }
            }
        } catch (Throwable th) {
            q.a("MBridgeVideoEndCoverView", th.getMessage());
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.g = motionEvent.getRawX();
        this.h = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.d = configuration.orientation;
        removeView(this.n);
        View view = this.n;
        if (view == null) {
            init(this.a);
            preLoadData(this.t);
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.n.getParent()).removeView(this.n);
        }
        addView(this.n);
        a(this.n);
        c();
    }

    private boolean a(View view) {
        if (view == null) {
            return true;
        }
        try {
            this.o = (ImageView) view.findViewById(findID("mbridge_vec_iv_icon"));
            this.p = (ImageView) view.findViewById(findID("mbridge_vec_iv_close"));
            this.q = (TextView) view.findViewById(findID("mbridge_vec_tv_title"));
            this.r = (TextView) view.findViewById(findID("mbridge_vec_tv_desc"));
            this.s = (TextView) view.findViewById(findID("mbridge_vec_btn"));
            return true;
        } catch (Throwable th) {
            q.d("MBridgeVideoEndCoverView", th.getMessage());
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        super.c();
        this.p.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MBridgeVideoEndCoverView.this.e.a(104, "");
            }
        });
        this.o.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MBridgeVideoEndCoverView.this.a();
            }
        });
        this.s.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MBridgeVideoEndCoverView.this.a();
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void a() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONException e;
        JSONObject jSONObject3 = null;
        try {
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put(com.mbridge.msdk.foundation.same.a.e, u.a(a.e().g(), this.g));
                    jSONObject.put(com.mbridge.msdk.foundation.same.a.f, u.a(a.e().g(), this.h));
                    jSONObject.put(com.mbridge.msdk.foundation.same.a.h, 0);
                    try {
                        this.d = getContext().getResources().getConfiguration().orientation;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    jSONObject.put(com.mbridge.msdk.foundation.same.a.i, this.d);
                    jSONObject.put(com.mbridge.msdk.foundation.same.a.j, (double) u.d(getContext()));
                } catch (JSONException e3) {
                    e = e3;
                    q.d("MBridgeVideoEndCoverView", e.getMessage());
                    jSONObject2 = new JSONObject();
                    jSONObject2.put(com.mbridge.msdk.foundation.same.a.g, jSONObject);
                    jSONObject3 = jSONObject2;
                    this.e.a(105, jSONObject3);
                }
            } catch (JSONException e4) {
                JSONException jSONException = e4;
                jSONObject = jSONObject4;
                e = jSONException;
                q.d("MBridgeVideoEndCoverView", e.getMessage());
                jSONObject2 = new JSONObject();
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.g, jSONObject);
                jSONObject3 = jSONObject2;
                this.e.a(105, jSONObject3);
            }
            jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.g, jSONObject);
                jSONObject3 = jSONObject2;
            } catch (JSONException e5) {
                JSONObject jSONObject5 = jSONObject2;
                e = e5;
                jSONObject3 = jSONObject5;
                e.printStackTrace();
                this.e.a(105, jSONObject3);
            }
        } catch (JSONException e6) {
            e = e6;
            e.printStackTrace();
            this.e.a(105, jSONObject3);
        }
        this.e.a(105, jSONObject3);
    }
}
