package sg.bigo.ads.ad.interstitial;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.a.b;
import sg.bigo.ads.api.VideoController;

public abstract class h extends c<i> {
    private b a;
    private j b;
    protected ViewGroup n;
    protected Button o;

    protected h(Activity activity) {
        super(activity);
    }

    /* access modifiers changed from: private */
    public void b(boolean z) {
        Button button = this.o;
        if (button != null) {
            button.setBackgroundResource(z ? R.drawable.bigo_ad_ic_media_mute : R.drawable.bigo_ad_ic_media_unmute);
        }
    }

    /* access modifiers changed from: protected */
    public void A() {
    }

    /* access modifiers changed from: protected */
    public void B() {
    }

    /* access modifiers changed from: protected */
    public void C() {
    }

    /* access modifiers changed from: protected */
    public final boolean D() {
        return this.k != null && ((i) this.k).q();
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.a = ((i) this.k).m;
        this.n = (ViewGroup) e(R.id.inter_native_ad_view);
        if (this.n != null) {
            int i = r() ? 8 : 1;
            j y = y();
            ViewGroup viewGroup = this.n;
            y.a(viewGroup, viewGroup, x(), i, this.m);
            final VideoController videoController = this.a.getVideoController();
            if (videoController != null) {
                this.o = (Button) e(R.id.inter_btn_mute);
                Button button = this.o;
                if (button != null) {
                    button.setVisibility(0);
                    b(videoController.isMuted());
                    this.o.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            VideoController videoController = videoController;
                            videoController.mute(!videoController.isMuted());
                        }
                    });
                }
                videoController.setVideoLifeCallback(new VideoController.a() {
                    public final void a() {
                        h.this.B();
                    }

                    public final void b() {
                        h.this.C();
                    }

                    public final void onMuteChange(boolean z) {
                        h.this.b(z);
                    }

                    public final void onVideoEnd() {
                        h.this.A();
                    }

                    public final void onVideoPause() {
                        if (!h.this.m.c) {
                            h.this.m.a();
                        }
                    }

                    public final void onVideoPlay() {
                        if (!h.this.m.c) {
                            h.this.m.b();
                        }
                    }

                    public final void onVideoStart() {
                    }
                });
            }
        }
    }

    public void n() {
        super.n();
        VideoController z = z();
        if (z != null) {
            z.setVideoLifeCallback((VideoController.VideoLifeCallback) null);
            z.setProgressChangeListener((VideoController.b) null);
        }
    }

    public void t() {
        if (!D()) {
            super.t();
        }
    }

    public void u() {
        if (!D()) {
            super.u();
        }
    }

    /* access modifiers changed from: protected */
    public int x() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public final j y() {
        if (this.b == null) {
            this.b = new j(this.a);
        }
        return this.b;
    }

    /* access modifiers changed from: protected */
    public final VideoController z() {
        b bVar = this.a;
        if (bVar != null) {
            return bVar.getVideoController();
        }
        return null;
    }
}
