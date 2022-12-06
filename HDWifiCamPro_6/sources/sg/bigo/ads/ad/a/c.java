package sg.bigo.ads.ad.a;

import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.iab.omid.library.bigosg.c.f;
import com.iab.omid.library.bigosg.e.d;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import sg.bigo.ads.ad.b;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.api.VideoController;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.api.core.n;
import sg.bigo.ads.common.utils.o;
import sg.bigo.ads.core.c.b;
import sg.bigo.ads.core.f.a.e;
import sg.bigo.ads.core.f.a.j;
import sg.bigo.ads.core.f.a.k;
import sg.bigo.ads.core.f.a.n;
import sg.bigo.ads.core.f.a.p;
import sg.bigo.ads.core.player.a;

public final class c extends b {
    public sg.bigo.ads.core.player.c p;
    public p q;
    /* access modifiers changed from: private */
    public a.C0146a r;

    public c(g gVar) {
        super(gVar);
    }

    static /* synthetic */ void a(c cVar, String str, int[] iArr) {
        VideoController.b bVar;
        VideoController videoController = cVar.getVideoController();
        VideoController.VideoLifeCallback videoLifeCallback = null;
        if (videoController != null) {
            videoLifeCallback = videoController.getVideoLifeCallback();
            bVar = videoController.getProgressChangeListener();
        } else {
            bVar = null;
        }
        char c = 65535;
        int i = 7;
        boolean z = true;
        switch (str.hashCode()) {
            case -2104076401:
                if (str.equals("AdClosed")) {
                    c = 8;
                    break;
                }
                break;
            case -1844074968:
                if (str.equals("AdLoaded")) {
                    c = 0;
                    break;
                }
                break;
            case -799585545:
                if (str.equals("AdVideoBuffered")) {
                    c = 5;
                    break;
                }
                break;
            case 123005777:
                if (str.equals("AdVideoComplete")) {
                    c = 6;
                    break;
                }
                break;
            case 227130189:
                if (str.equals("AdVolumeChange")) {
                    c = 9;
                    break;
                }
                break;
            case 479049069:
                if (str.equals("AdSkipped")) {
                    c = 7;
                    break;
                }
                break;
            case 488344453:
                if (str.equals("AdError")) {
                    c = 11;
                    break;
                }
                break;
            case 739506502:
                if (str.equals("AdVideoPaused")) {
                    c = 3;
                    break;
                }
                break;
            case 858456394:
                if (str.equals("AdVideoStart")) {
                    c = 1;
                    break;
                }
                break;
            case 982656138:
                if (str.equals("AdVideoBuffering")) {
                    c = 4;
                    break;
                }
                break;
            case 1099014402:
                if (str.equals("AdVideoTooLate")) {
                    c = 12;
                    break;
                }
                break;
            case 1746498326:
                if (str.equals("AdVideoPlaying")) {
                    c = 2;
                    break;
                }
                break;
            case 1766207024:
                if (str.equals("AdRemainingTimeChange")) {
                    c = 10;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                sg.bigo.ads.core.player.c cVar2 = cVar.p;
                if (cVar2 != null) {
                    cVar2.c = true;
                    return;
                }
                return;
            case 1:
                if (videoLifeCallback != null) {
                    videoLifeCallback.onVideoStart();
                }
                if (cVar.p == null) {
                    return;
                }
                return;
            case 2:
                if (videoLifeCallback != null) {
                    videoLifeCallback.onVideoPlay();
                }
                sg.bigo.ads.core.player.c cVar3 = cVar.p;
                if (cVar3 != null && cVar3.d) {
                    cVar3.d = false;
                    Iterator<n> it = cVar3.a.h.iterator();
                    while (it.hasNext()) {
                        cVar3.a(it.next(), "va_res");
                    }
                    if (cVar3.e != null) {
                        cVar3.e.b(b.a.b);
                        return;
                    }
                    return;
                }
                return;
            case 3:
                if (videoLifeCallback != null) {
                    videoLifeCallback.onVideoPause();
                    return;
                }
                return;
            case 4:
                if (videoLifeCallback instanceof VideoController.a) {
                    ((VideoController.a) videoLifeCallback).a();
                    return;
                }
                return;
            case 5:
                if (videoLifeCallback instanceof VideoController.a) {
                    ((VideoController.a) videoLifeCallback).b();
                    return;
                }
                return;
            case 6:
                if (videoLifeCallback != null) {
                    videoLifeCallback.onVideoEnd();
                }
                sg.bigo.ads.core.player.c cVar4 = cVar.p;
                if (cVar4 != null) {
                    sg.bigo.ads.api.core.n nVar = cVar.l;
                    cVar4.a((List<? extends n>) cVar4.a.d, "va_comp");
                    cVar4.a((List<? extends n>) cVar4.a.b, "va_prog1");
                    cVar4.a((List<? extends n>) cVar4.a.c, "va_prog2");
                    if (!cVar4.g) {
                        cVar4.g = true;
                        sg.bigo.ads.core.player.c.a(nVar, 6);
                        if (cVar4.e != null) {
                            cVar4.e.a(b.C0135b.d);
                        }
                    }
                }
                if (sg.bigo.ads.api.core.b.d(cVar.l.m()) && cVar.b.b.g() && videoController != null) {
                    videoController.play();
                    return;
                }
                return;
            case 7:
                sg.bigo.ads.core.player.c cVar5 = cVar.p;
                if (cVar5 != null) {
                    cVar5.a((List<? extends n>) cVar5.a.f, "va_skip");
                    if (cVar5.e != null) {
                        cVar5.e.b(b.a.e);
                        return;
                    }
                    return;
                }
                return;
            case 8:
                sg.bigo.ads.core.player.c cVar6 = cVar.p;
                if (cVar6 != null) {
                    cVar6.a((List<? extends n>) cVar6.a.e, "va_close");
                    return;
                }
                return;
            case 9:
                if (iArr != null && iArr.length > 0) {
                    int i2 = iArr[0];
                    if (videoLifeCallback != null) {
                        videoLifeCallback.onMuteChange(i2 == 0);
                    }
                    sg.bigo.ads.core.player.c cVar7 = cVar.p;
                    if (cVar7 != null) {
                        sg.bigo.ads.api.core.n nVar2 = cVar.l;
                        if (i2 != 0) {
                            i = 17;
                        }
                        sg.bigo.ads.core.player.c.a(nVar2, i);
                        if (cVar7.a != null) {
                            Iterator<j> it2 = cVar7.a.g.iterator();
                            while (it2.hasNext()) {
                                j next = it2.next();
                                if ((i2 == 0 && next.a) || (i2 == 100 && !next.a)) {
                                    cVar7.a((n) next, "va_mst");
                                    it2.remove();
                                }
                            }
                        }
                        if (i2 / 100 != 0) {
                            z = false;
                        }
                        cVar7.f = z;
                        if (cVar7.e != null) {
                            b bVar2 = cVar7.e;
                            float f = ((float) i2) / 100.0f;
                            if (bVar2.a != null && bVar2.b) {
                                com.iab.omid.library.bigosg.b.a.b bVar3 = bVar2.a;
                                com.iab.omid.library.bigosg.b.a.b.a(f);
                                d.b(bVar3.a);
                                JSONObject jSONObject = new JSONObject();
                                com.iab.omid.library.bigosg.e.b.a(jSONObject, "mediaPlayerVolume", Float.valueOf(f));
                                com.iab.omid.library.bigosg.e.b.a(jSONObject, "deviceVolume", Float.valueOf(f.a().a));
                                bVar3.a.c.a("volumeChange", jSONObject);
                                bVar2.a("video volume change: ".concat(String.valueOf(f)));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 10:
                if (iArr != null && iArr.length > 2) {
                    sg.bigo.ads.core.player.c cVar8 = cVar.p;
                    if (cVar8 != null) {
                        cVar8.a(iArr, cVar.l);
                    }
                    if (bVar != null) {
                        bVar.a(iArr[0], iArr[1]);
                        return;
                    }
                    return;
                }
                return;
            case 11:
            case 12:
                sg.bigo.ads.core.player.c cVar9 = cVar.p;
                if (cVar9 != null) {
                    sg.bigo.ads.api.core.n nVar3 = cVar.l;
                    cVar9.a(sg.bigo.ads.core.f.a.f.GENERAL_LINEAR_AD_ERROR.g, (List<n>) cVar9.a.j);
                    sg.bigo.ads.core.player.c.a(nVar3, 16);
                    if (iArr != null) {
                        cVar.b(2002, "Video error: " + iArr[0]);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    static /* synthetic */ boolean a(c cVar, int i) {
        return cVar.l.m() != 4 || i >= 5;
    }

    static /* synthetic */ boolean a(c cVar, String str) {
        if (o.b(str)) {
            return false;
        }
        k kVar = new k(cVar.b.b.f());
        p a = kVar.a(str);
        int i = kVar.a;
        String str2 = kVar.c;
        long j = kVar.b;
        if (a == null || a.m == null) {
            e eVar = kVar.d;
            List<n> list = kVar.e;
            if (eVar != null) {
                int i2 = eVar.a;
                if (i2 == 10062) {
                    sg.bigo.ads.core.f.a.f fVar = sg.bigo.ads.core.f.a.f.NO_ADS_VAST_RESPONSE;
                } else if (i2 == 10073) {
                    sg.bigo.ads.core.f.a.f fVar2 = sg.bigo.ads.core.f.a.f.WRAPPER_TIMEOUT;
                } else {
                    sg.bigo.ads.core.f.a.f fVar3 = sg.bigo.ads.core.f.a.f.XML_PARSING_ERROR;
                }
                sg.bigo.ads.core.player.c.a(list);
                sg.bigo.ads.api.core.n nVar = cVar.l;
                String str3 = eVar.b;
                Map<String, String> b = sg.bigo.ads.core.d.a.b((sg.bigo.ads.api.core.c) nVar);
                b.put("rslt", MBridgeConstans.ENDCARD_URL_TYPE_PL);
                b.put("wrap", String.valueOf(i));
                b.put("wrap_url", str2);
                b.put("cost", String.valueOf(j));
                b.put("e_code", String.valueOf(i2));
                b.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, String.valueOf(str3));
                sg.bigo.ads.core.d.a.a("06002016", b);
            }
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a.m.c.hashCode());
        a.n = sb.toString();
        cVar.p = new sg.bigo.ads.core.player.c(a, cVar.d);
        cVar.l.a(a);
        cVar.q = a;
        sg.bigo.ads.api.core.n nVar2 = cVar.l;
        Map<String, String> b2 = sg.bigo.ads.core.d.a.b((sg.bigo.ads.api.core.c) nVar2);
        b2.put("rslt", "1");
        b2.put("wrap", String.valueOf(i));
        b2.put("cost", String.valueOf(j));
        if (nVar2 instanceof sg.bigo.ads.api.core.n) {
            b2.put("video_duration", String.valueOf(nVar2.ag()));
        }
        sg.bigo.ads.core.d.a.a("06002016", b2);
        return true;
    }

    public final void a(ViewGroup viewGroup, MediaView mediaView, ImageView imageView, AdOptionsView adOptionsView, List<View> list, int i, View... viewArr) {
        super.a(viewGroup, mediaView, imageView, adOptionsView, list, i, viewArr);
        sg.bigo.ads.core.player.c cVar = this.p;
        if (cVar != null) {
            cVar.e = this.m;
        }
    }

    public final void a(final b.a<NativeAd> aVar, int i) {
        sg.bigo.ads.api.core.c cVar = this.b.a;
        if (!(cVar instanceof sg.bigo.ads.api.core.n)) {
            aVar.a(this, 1006, "NativeVideo with invalid AdData class type.");
            return;
        }
        n.c R = ((sg.bigo.ads.api.core.n) cVar).R();
        if (R == null) {
            aVar.a(this, 1006, "Missing media video.");
            return;
        }
        final String a = R.a();
        sg.bigo.ads.common.f.c.a(1, new Runnable() {
            public final void run() {
                if (c.a(c.this, a)) {
                    if (!c.a(c.this, (int) ((c.this.q != null ? c.this.q.r : 0) / 1000))) {
                        aVar.a(c.this, 1006, "Invalid video duration.");
                        return;
                    }
                    a.C0146a unused = c.this.r = new a.C0146a() {
                        public final void a() {
                            aVar.a(c.this, 1006, "Failed to download media video.");
                        }

                        public final void a(boolean z) {
                            c.this.a("is_cache", (Object) Boolean.valueOf(z));
                            aVar.a(c.this);
                        }
                    };
                    a a2 = a.a();
                    sg.bigo.ads.api.core.n nVar = c.this.l;
                    a.C0146a b2 = c.this.r;
                    if (!a2.b.get()) {
                        sg.bigo.ads.common.d.b.a("please execute initAdResource first", (sg.bigo.ads.common.d.a) null);
                    } else if (sg.bigo.ads.common.f.c.a()) {
                        a2.a(nVar, b2);
                    } else {
                        sg.bigo.ads.common.f.c.a(1, new Runnable(nVar, b2) {
                            final /* synthetic */ sg.bigo.ads.api.core.n a;
                            final /* synthetic */ C0146a b;

                            {
                                this.a = r2;
                                this.b = r3;
                            }

                            public final void run() {
                                a.this.a(this.a, this.b);
                            }
                        });
                    }
                } else {
                    aVar.a(c.this, 1006, "Invalid media video.");
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void a(MediaView mediaView) {
        if (this.q != null) {
            mediaView.a(this.l, this.q, new sg.bigo.ads.core.g.a() {
                public final void a(String str, int[] iArr) {
                    c.a(c.this, str, iArr);
                }
            });
            VideoController videoController = mediaView.getVideoController();
            if (videoController != null) {
                videoController.mute(this.b.b.h());
            }
        }
    }

    public final void b(Point point, int i, int i2, sg.bigo.ads.api.core.e eVar) {
        super.b(point, i, i2, eVar);
        sg.bigo.ads.core.player.c cVar = this.p;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void d() {
        super.d();
        sg.bigo.ads.core.player.c cVar = this.p;
        if (cVar != null) {
            sg.bigo.ads.api.core.n nVar = this.l;
            if (!cVar.b) {
                cVar.b = true;
            }
            sg.bigo.ads.core.player.c.a(nVar, 1);
            for (sg.bigo.ads.core.f.a.n a : cVar.a.a) {
                cVar.a(a, "va_show");
            }
        }
    }

    public final void destroy() {
        VideoController videoController = getVideoController();
        if (videoController != null) {
            videoController.setVideoLifeCallback((VideoController.VideoLifeCallback) null);
        }
        super.destroy();
        sg.bigo.ads.core.player.c cVar = this.p;
        if (cVar != null) {
            if (cVar.c && !cVar.b) {
                cVar.b = true;
            }
            if (cVar.a != null) {
                for (sg.bigo.ads.core.f.a.n a : cVar.a.k) {
                    cVar.a(a, "va_des");
                }
            }
            sg.bigo.ads.common.k.a.a(0, 3, "AdTracker", "destroy");
            cVar.e = null;
        }
        this.r = null;
    }

    public final NativeAd.CreativeType getCreativeType() {
        return NativeAd.CreativeType.VIDEO;
    }

    public final VideoController getVideoController() {
        if (this.o != null) {
            return this.o.getVideoController();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.A;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<sg.bigo.ads.core.c.a> r() {
        /*
            r2 = this;
            sg.bigo.ads.core.f.a.p r0 = r2.q
            if (r0 == 0) goto L_0x000f
            java.util.List<sg.bigo.ads.core.c.a> r0 = r0.A
            if (r0 == 0) goto L_0x000f
            int r1 = r0.size()
            if (r1 <= 0) goto L_0x000f
            return r0
        L_0x000f:
            java.util.List r0 = super.r()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.a.c.r():java.util.List");
    }

    /* access modifiers changed from: protected */
    public final boolean s() {
        return this.l.ad();
    }
}
