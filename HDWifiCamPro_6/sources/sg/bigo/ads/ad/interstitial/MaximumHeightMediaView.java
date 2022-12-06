package sg.bigo.ads.ad.interstitial;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import sg.bigo.ads.api.MediaView;

public class MaximumHeightMediaView extends MediaView {
    private int a;

    public MaximumHeightMediaView(Context context) {
        super(context);
    }

    public MaximumHeightMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MaximumHeightMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int i3 = this.a;
        if (i3 > 0 && size > i3) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.a, View.MeasureSpec.getMode(i2));
        }
        super.onMeasure(i, i2);
    }

    public void setMaxHeight(int i) {
        this.a = i;
    }
}
