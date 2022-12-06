package com.ironsource.sdk.service.Connectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.util.Log;
import com.ironsource.d.a;
import org.json.JSONObject;

public class e implements c {
    private String a = e.class.getSimpleName();
    private int b = 23;
    /* access modifiers changed from: private */
    public final d c;
    private ConnectivityManager.NetworkCallback d;

    public e(d dVar) {
        this.c = dVar;
    }

    public final void a() {
        this.d = null;
    }

    public final void a(final Context context) {
        if (Build.VERSION.SDK_INT >= this.b) {
            b(context);
            if (a.a(context).equals("none")) {
                this.c.a();
            }
            if (this.d == null) {
                this.d = new ConnectivityManager.NetworkCallback() {
                    public final void onAvailable(Network network) {
                        if (network != null) {
                            d a2 = e.this.c;
                            String a3 = a.a(network, context);
                            a.a(context, network);
                            a2.a(a3);
                            return;
                        }
                        d a4 = e.this.c;
                        String a5 = a.a(context);
                        Context context = context;
                        a.a(context, a.b(context));
                        a4.a(a5);
                    }

                    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                        if (network != null) {
                            e.this.c.a(a.a(network, context), a.a(context, network));
                        }
                    }

                    public final void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
                        if (network != null) {
                            e.this.c.a(a.a(network, context), a.a(context, network));
                        }
                    }

                    public final void onLost(Network network) {
                        if (a.a(context).equals("none")) {
                            e.this.c.a();
                        }
                    }
                };
            }
            NetworkRequest build = new NetworkRequest.Builder().addCapability(12).build();
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    connectivityManager.registerNetworkCallback(build, this.d);
                }
            } catch (Exception unused) {
                Log.e(this.a, "NetworkCallback was not able to register");
            }
        }
    }

    public final void b(Context context) {
        ConnectivityManager connectivityManager;
        if (Build.VERSION.SDK_INT >= this.b && this.d != null && context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            try {
                connectivityManager.unregisterNetworkCallback(this.d);
            } catch (Exception unused) {
                Log.e(this.a, "NetworkCallback for was not registered or already unregistered");
            }
        }
    }

    public final JSONObject c(Context context) {
        return a.a(context, a.b(context));
    }
}
