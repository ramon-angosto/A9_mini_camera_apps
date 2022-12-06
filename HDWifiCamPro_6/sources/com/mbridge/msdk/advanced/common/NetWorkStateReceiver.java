package com.mbridge.msdk.advanced.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.m;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import org.json.JSONObject;

public class NetWorkStateReceiver extends BroadcastReceiver {
    private static final String a = NetWorkStateReceiver.class.getSimpleName();
    private WebView b;
    private int c;

    public NetWorkStateReceiver(WebView webView) {
        this.b = webView;
    }

    public void onReceive(Context context, Intent intent) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                a(this.b, 0);
            } else if (a.b) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    a(this.b, 0);
                } else if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTING) {
                } else {
                    if (activeNetworkInfo.getState() != NetworkInfo.State.DISCONNECTING) {
                        if (activeNetworkInfo.getType() == 1) {
                            a(this.b, 9);
                            return;
                        }
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        if (telephonyManager == null) {
                            a(this.b, 0);
                            return;
                        }
                        this.c = telephonyManager.getNetworkType();
                        this.c = m.a(this.c);
                        a(this.b, this.c);
                    }
                }
            } else {
                a(this.b, 0);
            }
        } catch (Throwable th) {
            q.a(a, th.getMessage());
        }
    }

    public final void a() {
        this.b = null;
    }

    private void a(WebView webView, int i) {
        if (webView != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("netstat", i);
                g.a().a(webView, "onNetstatChanged", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (Throwable th) {
                q.a(a, th.getMessage());
            }
        }
    }
}
