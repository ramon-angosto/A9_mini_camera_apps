package sg.bigo.ads.core.adview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.VideoController;
import sg.bigo.ads.api.core.m;
import sg.bigo.ads.api.core.n;
import sg.bigo.ads.common.utils.s;
import sg.bigo.ads.core.f.a.p;
import sg.bigo.ads.core.player.b.b;
import sg.bigo.ads.core.player.d;

public final class d extends c implements MediaView.a {
    public b b = null;
    public sg.bigo.ads.common.view.a c = null;
    public VideoController d;

    static class a implements VideoController {
        private final b a;
        private VideoController.VideoLifeCallback b;
        private VideoController.b c;

        a(b bVar) {
            this.a = bVar;
        }

        public final VideoController.b getProgressChangeListener() {
            return this.c;
        }

        public final VideoController.VideoLifeCallback getVideoLifeCallback() {
            return this.b;
        }

        public final boolean isMuted() {
            sg.bigo.ads.core.player.d unused = d.a.a;
            return this.a.d;
        }

        public final boolean isPaused() {
            sg.bigo.ads.core.player.d unused = d.a.a;
            return this.a.getPlayStatus() == 3;
        }

        public final boolean isPlaying() {
            sg.bigo.ads.core.player.d unused = d.a.a;
            return this.a.k();
        }

        public final void mute(boolean z) {
            sg.bigo.ads.core.player.d unused = d.a.a;
            this.a.setMute(z);
        }

        public final void pause() {
            sg.bigo.ads.core.player.d unused = d.a.a;
            this.a.j();
        }

        public final void play() {
            sg.bigo.ads.core.player.d unused = d.a.a;
            this.a.b(true);
        }

        public final void setProgressChangeListener(VideoController.b bVar) {
            this.c = bVar;
        }

        public final void setVideoLifeCallback(VideoController.VideoLifeCallback videoLifeCallback) {
            this.b = videoLifeCallback;
        }
    }

    public d(sg.bigo.ads.api.a<?> aVar) {
        super(aVar);
    }

    public final void a() {
        b bVar = this.b;
        if (bVar != null) {
            bVar.setClickable(false);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(View view) {
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        }
        s.a(view, this.a, (ViewGroup.LayoutParams) null, -1);
    }

    public final void a(String str) {
        this.b = new b(this.a.getContext(), 0, 0, sg.bigo.ads.core.player.b.a(1), (n) null);
        a((View) this.b);
        this.b.setPlayInfo$505cff1c(str);
        this.d = new a(this.b);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(sg.bigo.ads.api.core.n r6, sg.bigo.ads.common.h.e r7) {
        /*
            r5 = this;
            int r0 = r6.m()
            sg.bigo.ads.core.player.b r0 = sg.bigo.ads.core.player.b.a(r0)
            sg.bigo.ads.common.view.a r1 = r5.c
            if (r1 != 0) goto L_0x0019
            sg.bigo.ads.common.view.a r1 = new sg.bigo.ads.common.view.a
            sg.bigo.ads.api.a<?> r2 = r5.a
            android.content.Context r2 = r2.getContext()
            r1.<init>(r2)
            r5.c = r1
        L_0x0019:
            int r0 = r0.a
            r1 = 1
            if (r0 == r1) goto L_0x0044
            r1 = 2
            if (r0 == r1) goto L_0x003f
            r1 = 3
            r2 = 17
            r3 = -1
            if (r0 == r1) goto L_0x0033
            r1 = 4
            if (r0 == r1) goto L_0x002b
            goto L_0x004b
        L_0x002b:
            sg.bigo.ads.common.view.a r0 = r5.c
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams
            r1.<init>(r3, r3, r2)
            goto L_0x003b
        L_0x0033:
            sg.bigo.ads.common.view.a r0 = r5.c
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams
            r4 = -2
            r1.<init>(r3, r4, r2)
        L_0x003b:
            r0.setLayoutParams(r1)
            goto L_0x0044
        L_0x003f:
            sg.bigo.ads.common.view.a r0 = r5.c
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_CROP
            goto L_0x0048
        L_0x0044:
            sg.bigo.ads.common.view.a r0 = r5.c
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER
        L_0x0048:
            r0.setScaleType(r1)
        L_0x004b:
            java.lang.String r6 = r6.ae()
            sg.bigo.ads.common.view.a r0 = r5.c
            r5.a((android.view.View) r0)
            sg.bigo.ads.common.view.a r0 = r5.c
            sg.bigo.ads.common.h.a r0 = r0.a
            if (r7 == 0) goto L_0x0064
            java.util.List<java.lang.ref.WeakReference<sg.bigo.ads.common.h.e>> r0 = r0.a
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r7)
            r0.add(r1)
        L_0x0064:
            sg.bigo.ads.common.view.a r7 = r5.c
            r7.setImageURI(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.adview.d.a(sg.bigo.ads.api.core.n, sg.bigo.ads.common.h.e):void");
    }

    public final void a(n nVar, p pVar, sg.bigo.ads.core.g.a aVar) {
        sg.bigo.ads.core.player.b a2 = sg.bigo.ads.core.player.b.a(nVar.m());
        m ah = nVar.ah();
        int i = pVar.w;
        int i2 = pVar.v;
        if (ah != null) {
            if (ah.a > 0) {
                i = ah.a;
            }
            if (ah.b > 0) {
                i2 = ah.b;
            }
        }
        Context context = this.a.getContext();
        this.b = new b(context, i, i2, a2, nVar);
        a((View) this.b);
        this.b.setPlayInfo$505cff1c(nVar.af());
        this.b.setOnEventListener(aVar);
        this.d = new a(this.b);
    }

    public final boolean a(int i, int i2) {
        sg.bigo.ads.common.view.a aVar = this.c;
        if (aVar != null) {
            return s.a(i, i2, (View) aVar);
        }
        b bVar = this.b;
        return bVar != null ? s.a(i, i2, (View) bVar) : super.a(i, i2);
    }
}
