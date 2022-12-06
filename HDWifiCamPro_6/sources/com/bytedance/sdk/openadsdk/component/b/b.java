package com.bytedance.sdk.openadsdk.component.b;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.a.b.c;
import com.bytedance.sdk.openadsdk.a.b.d;
import com.bytedance.sdk.openadsdk.a.b.h;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: TTFeedAdImpl */
class b implements TTFeedAd, a.C0055a {
    private c a;
    private com.bytedance.sdk.openadsdk.a.b.a b;
    /* access modifiers changed from: private */
    public TTFeedAd.VideoAdListener c;

    b(PAGNativeAd pAGNativeAd) {
        if (pAGNativeAd instanceof c) {
            this.a = (c) pAGNativeAd;
            this.b = this.a.i();
            this.a.a((d) new d() {
                public void a(PAGNativeAd pAGNativeAd) {
                    if (b.this.c != null) {
                        b.this.c.onVideoLoad(b.this);
                    }
                }

                public void a(int i, int i2) {
                    if (b.this.c != null) {
                        b.this.c.onVideoError(i, i2);
                    }
                }

                public void b(PAGNativeAd pAGNativeAd) {
                    if (b.this.c != null) {
                        b.this.c.onVideoAdStartPlay(b.this);
                    }
                }

                public void c(PAGNativeAd pAGNativeAd) {
                    if (b.this.c != null) {
                        b.this.c.onVideoAdPaused(b.this);
                    }
                }

                public void d(PAGNativeAd pAGNativeAd) {
                    if (b.this.c != null) {
                        b.this.c.onVideoAdContinuePlay(b.this);
                    }
                }

                public void a(long j, long j2) {
                    if (b.this.c != null) {
                        b.this.c.onProgressUpdate(j, j2);
                    }
                }

                public void e(PAGNativeAd pAGNativeAd) {
                    if (b.this.c != null) {
                        b.this.c.onVideoAdComplete(b.this);
                    }
                }
            });
        }
    }

    public TTImage getVideoCoverImage() {
        com.bytedance.sdk.openadsdk.a.b.a aVar = this.b;
        if (aVar != null) {
            return aVar.j();
        }
        return null;
    }

    public Bitmap getAdLogo() {
        com.bytedance.sdk.openadsdk.a.b.a aVar = this.b;
        if (aVar != null) {
            return aVar.l();
        }
        return null;
    }

    public String getTitle() {
        com.bytedance.sdk.openadsdk.a.b.a aVar = this.b;
        if (aVar != null) {
            return aVar.d();
        }
        return null;
    }

    public String getDescription() {
        com.bytedance.sdk.openadsdk.a.b.a aVar = this.b;
        if (aVar != null) {
            return aVar.e();
        }
        return null;
    }

    public String getButtonText() {
        com.bytedance.sdk.openadsdk.a.b.a aVar = this.b;
        if (aVar != null) {
            return aVar.f();
        }
        return null;
    }

    public int getAppScore() {
        com.bytedance.sdk.openadsdk.a.b.a aVar = this.b;
        if (aVar != null) {
            return aVar.m();
        }
        return 0;
    }

    public int getAppCommentNum() {
        com.bytedance.sdk.openadsdk.a.b.a aVar = this.b;
        if (aVar != null) {
            return aVar.n();
        }
        return 0;
    }

    public int getAppSize() {
        com.bytedance.sdk.openadsdk.a.b.a aVar = this.b;
        if (aVar != null) {
            return aVar.o();
        }
        return 0;
    }

    public String getSource() {
        com.bytedance.sdk.openadsdk.a.b.a aVar = this.b;
        if (aVar != null) {
            return aVar.p();
        }
        return null;
    }

    public TTImage getIcon() {
        com.bytedance.sdk.openadsdk.a.b.a aVar = this.b;
        if (aVar != null) {
            return aVar.q();
        }
        return null;
    }

    public List<TTImage> getImageList() {
        com.bytedance.sdk.openadsdk.a.b.a aVar = this.b;
        if (aVar != null) {
            return aVar.r();
        }
        return null;
    }

    public int getInteractionType() {
        com.bytedance.sdk.openadsdk.a.b.a aVar = this.b;
        if (aVar != null) {
            return aVar.s();
        }
        return 0;
    }

    public int getImageMode() {
        com.bytedance.sdk.openadsdk.a.b.a aVar = this.b;
        if (aVar != null) {
            return aVar.t();
        }
        return 0;
    }

    public List<FilterWord> getFilterWords() {
        com.bytedance.sdk.openadsdk.a.b.a aVar = this.b;
        if (aVar != null) {
            return aVar.u();
        }
        return null;
    }

    public TTAdDislike getDislikeDialog(Activity activity) {
        com.bytedance.sdk.openadsdk.a.b.a aVar = this.b;
        if (aVar != null) {
            return aVar.a(activity);
        }
        return null;
    }

    public TTAdDislike getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        com.bytedance.sdk.openadsdk.a.b.a aVar = this.b;
        if (aVar != null) {
            return aVar.a(tTDislikeDialogAbstract);
        }
        return null;
    }

    public void registerViewForInteraction(ViewGroup viewGroup, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        if (viewGroup == null) {
            l.d("container can't been null");
        } else if (view == null) {
            l.d("clickView can't been null");
        } else {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(view);
            registerViewForInteraction(viewGroup, arrayList, (List<View>) null, adInteractionListener);
        }
    }

    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, TTNativeAd.AdInteractionListener adInteractionListener) {
        if (viewGroup == null) {
            l.d("container can't been null");
        } else if (list == null) {
            l.d("clickView can't been null");
        } else if (list.size() <= 0) {
            l.d("clickViews size must been more than 1");
        } else {
            registerViewForInteraction(viewGroup, list, list2, (View) null, adInteractionListener);
        }
    }

    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        if (viewGroup == null) {
            l.d("container can't been null");
        } else if (list == null) {
            l.d("clickView can't been null");
        } else if (list.size() <= 0) {
            l.d("clickViews size must been more than 1");
        } else {
            registerViewForInteraction(viewGroup, (List<View>) null, list, list2, view, adInteractionListener);
        }
    }

    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        c cVar = this.a;
        if (cVar != null) {
            cVar.a(viewGroup, list, list2, list3, view, new h(this, adInteractionListener));
        }
    }

    public View getAdView() {
        c cVar = this.a;
        if (cVar != null) {
            return cVar.f();
        }
        return null;
    }

    public View getAdLogoView() {
        PAGNativeAdData nativeAdData;
        c cVar = this.a;
        if (cVar == null || (nativeAdData = cVar.getNativeAdData()) == null) {
            return null;
        }
        return nativeAdData.getAdLogoView();
    }

    public Map<String, Object> getMediaExtraInfo() {
        c cVar = this.a;
        if (cVar != null) {
            return cVar.getMediaExtraInfo();
        }
        return null;
    }

    public void showPrivacyActivity() {
        com.bytedance.sdk.openadsdk.a.b.a aVar = this.b;
        if (aVar != null) {
            aVar.i();
        }
    }

    public String getAdCreativeToken() {
        com.bytedance.sdk.openadsdk.a.b.a aVar = this.b;
        if (aVar != null) {
            return aVar.v();
        }
        return null;
    }

    public double getVideoDuration() {
        com.bytedance.sdk.openadsdk.a.b.a aVar = this.b;
        if (aVar != null) {
            return aVar.k();
        }
        return 0.0d;
    }

    public void play() {
        com.bytedance.sdk.openadsdk.a.b.a aVar = this.b;
        if (aVar != null) {
            aVar.w();
        }
    }

    public void pause() {
        com.bytedance.sdk.openadsdk.a.b.a aVar = this.b;
        if (aVar != null) {
            aVar.x();
        }
    }

    public double currentPlayTime() {
        com.bytedance.sdk.openadsdk.a.b.a aVar = this.b;
        if (aVar != null) {
            return aVar.y();
        }
        return 0.0d;
    }

    public void setVideoAdListener(TTFeedAd.VideoAdListener videoAdListener) {
        this.c = videoAdListener;
    }

    public a g() {
        c cVar = this.a;
        if (cVar != null) {
            return cVar.g();
        }
        return null;
    }

    public void win(Double d) {
        c cVar = this.a;
        if (cVar != null) {
            cVar.win(d);
        }
    }

    public void loss(Double d, String str, String str2) {
        c cVar = this.a;
        if (cVar != null) {
            cVar.loss(d, str, str2);
        }
    }

    public void setPrice(Double d) {
        c cVar = this.a;
        if (cVar != null) {
            cVar.setPrice(d);
        }
    }
}
