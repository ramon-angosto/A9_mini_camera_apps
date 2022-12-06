package sg.bigo.ads.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import sg.bigo.ads.api.core.n;
import sg.bigo.ads.common.h.e;
import sg.bigo.ads.core.adview.c;
import sg.bigo.ads.core.adview.d;
import sg.bigo.ads.core.f.a.p;
import sg.bigo.ads.core.player.b.b;

public class MediaView extends a<d> {

    public interface a {
        void a();
    }

    public MediaView(Context context) {
        super(context);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ c a() {
        return new d(this);
    }

    public final void a(String str) {
        ((d) getViewImpl()).a(str);
    }

    public final void a(n nVar, e eVar) {
        ((d) getViewImpl()).a(nVar, eVar);
    }

    public final void a(n nVar, p pVar, sg.bigo.ads.core.g.a aVar) {
        ((d) getViewImpl()).a(nVar, pVar, aVar);
    }

    public final void b() {
        d dVar = (d) getViewImpl();
        if (dVar.c != null) {
            dVar.c.setImageBitmap((Bitmap) null);
            dVar.c.a.a.clear();
            dVar.c = null;
        }
        if (dVar.b != null) {
            b bVar = dVar.b;
            sg.bigo.ads.common.k.a.a(0, 3, "VideoPlayView", "destroy player");
            bVar.a(false);
            bVar.l();
            bVar.setOnEventListener((sg.bigo.ads.core.g.a) null);
            bVar.c = null;
            dVar.b = null;
        }
    }

    public VideoController getVideoController() {
        return ((d) getViewImpl()).d;
    }

    public a getVideoExtendedDelegate() {
        return (a) getViewImpl();
    }
}
