package sg.bigo.ads.a.a;

import android.content.ComponentName;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

public final class c extends CustomTabsServiceConnection {
    private WeakReference<d> a;

    public c(d dVar) {
        this.a = new WeakReference<>(dVar);
    }

    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        d dVar = (d) this.a.get();
        if (dVar != null) {
            dVar.a(customTabsClient);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        d dVar = (d) this.a.get();
        if (dVar != null) {
            dVar.b();
        }
    }
}
