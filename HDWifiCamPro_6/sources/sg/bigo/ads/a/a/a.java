package sg.bigo.ads.a.a;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import sg.bigo.ads.a.a.b;

public final class a implements d {
    public CustomTabsClient a;
    public CustomTabsServiceConnection b;
    public C0110a c;
    public CustomTabsCallback d;
    private CustomTabsSession e;

    /* renamed from: sg.bigo.ads.a.a.a$a  reason: collision with other inner class name */
    public interface C0110a {
        void c();

        void d();
    }

    public interface b {
        void a(Context context, b.a aVar);

        void a(b.a aVar);
    }

    public final CustomTabsSession a() {
        CustomTabsSession newSession;
        CustomTabsClient customTabsClient = this.a;
        if (customTabsClient == null) {
            newSession = null;
        } else {
            if (this.e == null) {
                newSession = customTabsClient.newSession(new CustomTabsCallback() {
                    public final void extraCallback(String str, Bundle bundle) {
                        super.extraCallback(str, bundle);
                    }

                    public final void onMessageChannelReady(Bundle bundle) {
                        super.onMessageChannelReady(bundle);
                    }

                    public final void onNavigationEvent(int i, Bundle bundle) {
                        super.onNavigationEvent(i, bundle);
                        if (a.this.d != null) {
                            a.this.d.onNavigationEvent(i, bundle);
                        }
                    }

                    public final void onPostMessage(String str, Bundle bundle) {
                        super.onPostMessage(str, bundle);
                    }

                    public final void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) {
                        super.onRelationshipValidationResult(i, uri, z, bundle);
                    }
                });
            }
            return this.e;
        }
        this.e = newSession;
        return this.e;
    }

    public final void a(CustomTabsClient customTabsClient) {
        this.a = customTabsClient;
        this.a.warmup(0);
        C0110a aVar = this.c;
        if (aVar != null) {
            aVar.c();
        }
    }

    public final void b() {
        this.a = null;
        this.e = null;
        C0110a aVar = this.c;
        if (aVar != null) {
            aVar.d();
        }
    }
}
