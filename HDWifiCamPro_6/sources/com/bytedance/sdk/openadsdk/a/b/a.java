package com.bytedance.sdk.openadsdk.a.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGImageItem;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoMediaView;
import com.bytedance.sdk.openadsdk.core.f.f;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.k;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.dislike.c;
import com.bytedance.sdk.openadsdk.k.a.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PAGExtraFuncationHelper */
public class a {
    protected TTAdDislike a;
    private final Context b;
    private final String c;
    private final n d;
    private boolean e;
    private WeakReference<NativeVideoTsView> f;
    private c g;
    private ImageView h;
    private PAGMediaView i;
    private com.bytedance.sdk.openadsdk.core.b.a j;
    private WeakReference<f> k;

    public a(Context context, n nVar, String str) {
        this.b = context;
        this.d = nVar;
        this.c = str;
    }

    public void a(c cVar) {
        this.g = cVar;
    }

    public void a(NativeVideoTsView nativeVideoTsView) {
        this.f = new WeakReference<>(nativeVideoTsView);
    }

    public void a(boolean z) {
        this.e = z;
    }

    public ImageView a() {
        return this.h;
    }

    public PAGMediaView b() {
        return this.i;
    }

    public void a(com.bytedance.sdk.openadsdk.core.b.a aVar) {
        this.j = aVar;
    }

    public PAGImageItem c() {
        n nVar = this.d;
        if (nVar == null || nVar.M() == null) {
            return null;
        }
        return new PAGImageItem(this.d.M().c(), this.d.M().b(), this.d.M().a(), (float) this.d.M().d());
    }

    public String d() {
        n nVar = this.d;
        if (nVar != null) {
            return nVar.U();
        }
        return null;
    }

    public String e() {
        n nVar = this.d;
        if (nVar != null) {
            return nVar.V();
        }
        return null;
    }

    public String f() {
        n nVar = this.d;
        if (nVar != null) {
            return nVar.W();
        }
        return null;
    }

    public PAGMediaView g() {
        c cVar;
        View f2;
        n nVar = this.d;
        PAGMediaView pAGMediaView = null;
        if (nVar == null) {
            return null;
        }
        if (nVar.ad() == 3 || this.d.ad() == 33 || this.d.ad() == 16) {
            List<k> P = this.d.P();
            if (P != null && !P.isEmpty()) {
                ImageView imageView = new ImageView(this.b);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                com.bytedance.sdk.openadsdk.e.a.a(P.get(0)).a(imageView);
                PAGMediaView pAGMediaView2 = new PAGMediaView(this.b);
                pAGMediaView2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                pAGMediaView2.addView(imageView, -1, -1);
                com.bytedance.sdk.openadsdk.core.b.a aVar = this.j;
                if (aVar != null) {
                    imageView.setOnClickListener(aVar);
                    imageView.setOnTouchListener(this.j);
                }
                imageView.setTag(t.e(m.a(), "tt_id_is_video_picture"), true);
                ImageView imageView2 = this.h;
                if (imageView2 != null) {
                    imageView2.setOnClickListener((View.OnClickListener) null);
                    this.h.setOnTouchListener((View.OnTouchListener) null);
                }
                this.h = imageView;
                pAGMediaView = pAGMediaView2;
            }
        } else if (!((this.d.ad() != 5 && this.d.ad() != 15 && this.d.ad() != 50) || (cVar = this.g) == null || (f2 = cVar.f()) == null)) {
            if (f2.getParent() instanceof ViewGroup) {
                ((ViewGroup) f2.getParent()).removeView(f2);
            }
            PAGMediaView pAGMediaView3 = this.i;
            if (pAGMediaView3 != null) {
                pAGMediaView3.setOnClickListener((View.OnClickListener) null);
                this.i.setOnTouchListener((View.OnTouchListener) null);
            }
            pAGMediaView = new PAGVideoMediaView(this.b, f2, this);
            pAGMediaView.setTag(t.e(m.a(), "tt_id_is_video_picture"), true);
            com.bytedance.sdk.openadsdk.core.b.a aVar2 = this.j;
            if (aVar2 != null) {
                pAGMediaView.setOnClickListener(aVar2);
                pAGMediaView.setOnTouchListener(this.j);
            }
            this.i = pAGMediaView;
            pAGMediaView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (pAGMediaView != null) {
            pAGMediaView.setTag(t.e(this.b, "tt_id_mrc_tracker_view"), e.b(this.d));
        }
        return pAGMediaView;
    }

    public View h() {
        if (m.a() == null) {
            l.e("TTNativeAdImpl", "getAdLogoView mContext == null");
            return null;
        }
        ImageView imageView = new ImageView(m.a());
        imageView.setImageResource(t.d(m.a(), "tt_ad_logo_new"));
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                a.this.i();
            }
        });
        return imageView;
    }

    public void i() {
        Context context = this.b;
        if (context != null) {
            TTWebsiteActivity.a(context, this.d, this.c);
        }
    }

    public TTImage j() {
        n nVar = this.d;
        if (nVar == null || nVar.J() == null) {
            return null;
        }
        return new TTImage(this.d.J().b(), this.d.J().c(), this.d.J().h());
    }

    public double k() {
        n nVar = this.d;
        if (nVar == null || nVar.J() == null) {
            return 0.0d;
        }
        return this.d.J().f();
    }

    public Bitmap l() {
        Context context = this.b;
        if (context != null) {
            return BitmapFactory.decodeResource(context.getResources(), t.d(this.b, "tt_ad_logo_new"));
        }
        return null;
    }

    public int m() {
        if (this.d.aa() != null) {
            return (int) this.d.aa().d();
        }
        return 0;
    }

    public int n() {
        if (this.d.aa() != null) {
            return this.d.aa().e();
        }
        return 0;
    }

    public int o() {
        if (this.d.aa() != null) {
            return this.d.aa().f();
        }
        return 0;
    }

    public String p() {
        return this.d.K();
    }

    public TTImage q() {
        if (this.d.M() == null) {
            return null;
        }
        return k.a(this.d.M());
    }

    public List<TTImage> r() {
        ArrayList arrayList = new ArrayList();
        if (this.d.P() != null && !this.d.P().isEmpty()) {
            for (k a2 : this.d.P()) {
                arrayList.add(k.a(a2));
            }
        }
        return arrayList;
    }

    public int s() {
        n nVar = this.d;
        if (nVar == null) {
            return -1;
        }
        return nVar.L();
    }

    public int t() {
        n nVar = this.d;
        if (nVar == null) {
            return -1;
        }
        return nVar.ad();
    }

    public List<FilterWord> u() {
        n nVar = this.d;
        if (nVar == null) {
            return null;
        }
        return nVar.ae();
    }

    public String v() {
        n nVar = this.d;
        if (nVar == null) {
            return null;
        }
        return nVar.n();
    }

    private void b(Activity activity) {
        Context context = this.b;
        Context context2 = activity;
        if (context instanceof Activity) {
            context2 = activity;
            if (!((Activity) context).isFinishing()) {
                context2 = this.b;
            }
        }
        n nVar = this.d;
        if (nVar != null) {
            this.a = new c(context2, nVar.ac(), this.d.ae());
        }
    }

    public TTAdDislike a(Activity activity) {
        if (this.a == null) {
            b(activity);
        }
        return this.a;
    }

    public TTAdDislike a(final TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.setMaterialMeta(this.d.ac(), this.d.ae());
            return new TTAdDislike() {
                public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
                }

                public void showDislikeDialog() {
                    if ((tTDislikeDialogAbstract.getContext() instanceof Activity) && !((Activity) tTDislikeDialogAbstract.getContext()).isFinishing()) {
                        tTDislikeDialogAbstract.show();
                    }
                }
            };
        }
        throw new IllegalArgumentException("dialog is null, please check");
    }

    public void w() {
        try {
            if (this.f != null && this.f.get() != null && this.e) {
                ((NativeVideoTsView) this.f.get()).n();
            }
        } catch (Throwable unused) {
        }
    }

    public void x() {
        try {
            if (this.f != null && this.f.get() != null && this.e) {
                ((NativeVideoTsView) this.f.get()).l();
            }
        } catch (Throwable unused) {
        }
    }

    public double y() {
        try {
            if (this.f == null || this.f.get() == null || !this.e) {
                return 0.0d;
            }
            return ((NativeVideoTsView) this.f.get()).getCurrentPlayTime();
        } catch (Throwable unused) {
            return 0.0d;
        }
    }

    public void a(final PAGVideoAdListener pAGVideoAdListener) {
        c cVar = this.g;
        if (cVar != null) {
            cVar.a((d) new d() {
                public void a(long j, long j2) {
                }

                public void a(PAGNativeAd pAGNativeAd) {
                }

                public void d(PAGNativeAd pAGNativeAd) {
                }

                public void a(int i, int i2) {
                    PAGVideoAdListener pAGVideoAdListener = pAGVideoAdListener;
                    if (pAGVideoAdListener != null) {
                        pAGVideoAdListener.onVideoError();
                    }
                }

                public void b(PAGNativeAd pAGNativeAd) {
                    PAGVideoAdListener pAGVideoAdListener = pAGVideoAdListener;
                    if (pAGVideoAdListener != null) {
                        pAGVideoAdListener.onVideoAdPlay();
                    }
                }

                public void c(PAGNativeAd pAGNativeAd) {
                    PAGVideoAdListener pAGVideoAdListener = pAGVideoAdListener;
                    if (pAGVideoAdListener != null) {
                        pAGVideoAdListener.onVideoAdPaused();
                    }
                }

                public void e(PAGNativeAd pAGNativeAd) {
                    PAGVideoAdListener pAGVideoAdListener = pAGVideoAdListener;
                    if (pAGVideoAdListener != null) {
                        pAGVideoAdListener.onVideoAdComplete();
                    }
                }
            });
        }
    }

    public void z() {
        f fVar;
        WeakReference<f> weakReference = this.k;
        if (weakReference != null && (fVar = (f) weakReference.get()) != null) {
            fVar.a(13);
        }
    }

    public void a(f fVar) {
        this.k = new WeakReference<>(fVar);
    }
}
