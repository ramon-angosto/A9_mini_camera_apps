package sg.bigo.ads.controller.e;

import android.app.Activity;
import android.content.Intent;
import com.vungle.warren.model.AdAssetDBAdapter;
import sg.bigo.ads.ad.b;
import sg.bigo.ads.api.core.BaseAdActivityImpl;
import sg.bigo.ads.controller.f.d;

public abstract class b<T extends sg.bigo.ads.ad.b<?>> extends BaseAdActivityImpl {
    protected T r;

    protected b(Activity activity) {
        super(activity);
    }

    public final void a(int i, int i2, Intent intent) {
    }

    public void n() {
        T t = this.r;
        if (t != null) {
            d.c(t.hashCode());
        }
    }

    public void p() {
        try {
            this.r = d.b(this.q.getIntent().getIntExtra(AdAssetDBAdapter.AdAssetColumns.COLUMN_AD_ID, -1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void t() {
    }

    public void u() {
    }

    public void v() {
    }
}
