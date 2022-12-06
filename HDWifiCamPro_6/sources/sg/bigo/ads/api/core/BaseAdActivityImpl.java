package sg.bigo.ads.api.core;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public abstract class BaseAdActivityImpl {
    public final Activity q;

    protected BaseAdActivityImpl(Activity activity) {
        this.q = activity;
    }

    public void E() {
        this.q.finish();
    }

    public abstract void a(int i, int i2, Intent intent);

    public abstract void a(boolean z);

    public void b(int i) {
        this.q.setContentView(i);
    }

    public final <T extends View> T e(int i) {
        return this.q.findViewById(i);
    }

    public abstract void n();

    public abstract void p();

    public abstract void t();

    public abstract void u();

    public abstract void v();
}
