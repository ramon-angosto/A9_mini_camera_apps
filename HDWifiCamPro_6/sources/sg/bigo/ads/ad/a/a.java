package sg.bigo.ads.ad.a;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.NativeAdView;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.common.utils.s;
import sg.bigo.ads.core.adview.f;

public final class a {
    public static List<View> a(List<View> list) {
        int intValue;
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (View next : list) {
            if (next != null) {
                Object tag = next.getTag();
                if ((tag instanceof Integer) && ((intValue = ((Integer) tag).intValue()) == 7 || intValue == 2 || intValue == 6 || intValue == 10)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public static b a(int i, g gVar) {
        if (i == 1) {
            return new b(gVar);
        }
        if (i == 2) {
            return new c(gVar);
        }
        return null;
    }

    public static void a(final View view, final View view2, final int i, final f fVar) {
        if (fVar == null) {
            view2.setOnTouchListener((View.OnTouchListener) null);
            return;
        }
        if (view2 instanceof MediaView) {
            ((MediaView) view2).getVideoExtendedDelegate().a();
        }
        view2.setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() == 1) {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    if (view instanceof sg.bigo.ads.api.a) {
                        if (!((sg.bigo.ads.api.a) view).a(x, y)) {
                            return false;
                        }
                    } else if ((view == view || view.getTag() == 1) && !s.a(view, x, y)) {
                        return false;
                    }
                    while ((view.getParent() instanceof ViewGroup) && view != view && !(view instanceof NativeAdView)) {
                        x += view.getLeft();
                        y += view.getTop();
                        view = (View) view.getParent();
                    }
                    fVar.a(x, y, i, ((Integer) view2.getTag()).intValue());
                }
                return true;
            }
        });
    }
}
