package sg.bigo.ads.ad.splash;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import sg.bigo.ads.R;
import sg.bigo.ads.api.a.h;

final class a {
    static void a(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bigo_ad_splash_item_ripple, viewGroup, false);
        if (inflate != null) {
            viewGroup.addView(inflate);
            Interpolator a = sg.bigo.ads.common.utils.a.a(2);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(inflate, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("alpha", new float[]{0.0f, 0.2f, 0.2f, 0.0f}), PropertyValuesHolder.ofFloat("scaleX", new float[]{0.0f, 1.0f, 2.5f, 4.5f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{0.0f, 1.0f, 2.5f, 4.5f})});
            ofPropertyValuesHolder.setDuration(1000);
            ofPropertyValuesHolder.setInterpolator(a);
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.start();
        }
    }

    static boolean a(h hVar) {
        return hVar.a("splash_orientation") == 1;
    }
}
