package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.l.z;

/* compiled from: VideoTrafficTipLayout */
public class e {
    private View a;
    private TextView b;
    private Context c;
    /* access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.a d;
    private b e;
    private boolean f = false;
    private com.bykv.vk.openvk.component.video.api.c.b g;
    private ViewStub h;
    private View i;

    /* compiled from: VideoTrafficTipLayout */
    public enum a {
        PAUSE_VIDEO,
        RELEASE_VIDEO,
        START_VIDEO
    }

    /* compiled from: VideoTrafficTipLayout */
    public interface b {
        boolean j();

        void l();
    }

    public void a(Context context, View view) {
        if (context != null && (view instanceof ViewGroup)) {
            this.i = view;
            this.c = m.a().getApplicationContext();
            this.h = (ViewStub) LayoutInflater.from(context).inflate(t.f(context, "tt_video_traffic_tip"), (ViewGroup) view, true).findViewById(t.e(context, "tt_video_traffic_tip_layout_viewStub"));
        }
    }

    private void a(Context context, View view, boolean z) {
        ViewStub viewStub;
        if (context != null && view != null && (viewStub = this.h) != null && viewStub.getParent() != null && this.a == null) {
            this.h.inflate();
            this.a = view.findViewById(t.e(context, "tt_video_traffic_tip_layout"));
            this.b = (TextView) view.findViewById(t.e(context, "tt_video_traffic_tip_tv"));
            View findViewById = view.findViewById(t.e(context, "tt_video_traffic_continue_play_btn"));
            if (z) {
                findViewById.setClickable(true);
                findViewById.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        e.this.c();
                        if (e.this.d != null) {
                            e.this.d.a(a.START_VIDEO, (String) null);
                        }
                    }
                });
                return;
            }
            findViewById.setOnClickListener((View.OnClickListener) null);
            findViewById.setClickable(false);
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.a aVar, b bVar) {
        this.e = bVar;
        this.d = aVar;
    }

    private void b() {
        this.g = null;
    }

    public boolean a(int i2, com.bykv.vk.openvk.component.video.api.c.b bVar, boolean z) {
        Context context = this.c;
        if (context == null || bVar == null) {
            return true;
        }
        a(context, this.i, z);
        this.g = bVar;
        if (i2 == 1 || i2 == 2) {
            return a(i2);
        }
        return true;
    }

    private boolean a(int i2) {
        b bVar;
        if (a() || this.f) {
            return true;
        }
        if (!(this.d == null || (bVar = this.e) == null)) {
            if (bVar.j()) {
                this.d.e((com.bykv.vk.openvk.component.video.api.d.b) null, (View) null);
            }
            this.d.a(a.PAUSE_VIDEO, (String) null);
        }
        a(this.g, true);
        return false;
    }

    /* access modifiers changed from: private */
    public void c() {
        if (this.c != null) {
            d();
        }
    }

    public void a(boolean z) {
        if (z) {
            b();
        }
        d();
    }

    public boolean a() {
        View view = this.a;
        return view != null && view.getVisibility() == 0;
    }

    private void d() {
        View view = this.a;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void a(com.bykv.vk.openvk.component.video.api.c.b bVar, boolean z) {
        View view;
        String str;
        View view2;
        if (bVar != null && (view = this.a) != null && this.c != null && view.getVisibility() != 0) {
            b bVar2 = this.e;
            if (bVar2 != null) {
                bVar2.l();
            }
            double ceil = Math.ceil((((double) bVar.e()) * 1.0d) / 1048576.0d);
            if (z) {
                str = String.format(t.a(this.c, "tt_video_without_wifi_tips"), new Object[]{Float.valueOf(Double.valueOf(ceil).floatValue())});
            } else {
                str = t.a(this.c, "tt_video_without_wifi_tips") + t.a(this.c, "tt_video_bytesize");
            }
            z.a(this.a, 0);
            z.a(this.b, (CharSequence) str);
            Log.i("VideoTrafficTipLayout", "showTrafficTipCover: ");
            if (z.d(this.a) && (view2 = this.a) != null) {
                view2.bringToFront();
                Log.i("VideoTrafficTipLayout", "showTrafficTipCover: bringToFront");
            }
        }
    }
}
