package sg.bigo.ads.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.lang.reflect.Constructor;
import sg.bigo.ads.api.core.BaseAdActivityImpl;

public final class AdActivity extends Activity {
    private BaseAdActivityImpl a;

    public static Intent a(Context context, Class<? extends BaseAdActivityImpl> cls) {
        Intent intent = new Intent(context, AdActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("impl_clazz", cls);
        return intent;
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        BaseAdActivityImpl baseAdActivityImpl = this.a;
        if (baseAdActivityImpl != null) {
            baseAdActivityImpl.a(i, i2, intent);
        }
    }

    public final void onBackPressed() {
        BaseAdActivityImpl baseAdActivityImpl = this.a;
        if (baseAdActivityImpl != null) {
            baseAdActivityImpl.v();
        }
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Constructor declaredConstructor = ((Class) getIntent().getSerializableExtra("impl_clazz")).getDeclaredConstructor(new Class[]{Activity.class});
            declaredConstructor.setAccessible(true);
            this.a = (BaseAdActivityImpl) declaredConstructor.newInstance(new Object[]{this});
            this.a.p();
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onDestroy() {
        super.onDestroy();
        BaseAdActivityImpl baseAdActivityImpl = this.a;
        if (baseAdActivityImpl != null) {
            baseAdActivityImpl.n();
        }
    }

    /* access modifiers changed from: protected */
    public final void onPause() {
        super.onPause();
        BaseAdActivityImpl baseAdActivityImpl = this.a;
        if (baseAdActivityImpl != null) {
            baseAdActivityImpl.u();
        }
    }

    /* access modifiers changed from: protected */
    public final void onResume() {
        super.onResume();
        BaseAdActivityImpl baseAdActivityImpl = this.a;
        if (baseAdActivityImpl != null) {
            baseAdActivityImpl.t();
        }
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        BaseAdActivityImpl baseAdActivityImpl = this.a;
        if (baseAdActivityImpl != null) {
            baseAdActivityImpl.a(z);
        }
    }
}
