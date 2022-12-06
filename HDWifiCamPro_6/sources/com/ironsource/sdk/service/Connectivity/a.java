package com.ironsource.sdk.service.Connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import org.json.JSONObject;

public final class a implements c {
    final d a;
    private BroadcastReceiver b = new BroadcastReceiverStrategy$1(this);

    public a(d dVar) {
        this.a = dVar;
    }

    public final void a() {
        this.b = null;
    }

    public final void a(Context context) {
        try {
            context.registerReceiver(this.b, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void b(Context context) {
        try {
            context.unregisterReceiver(this.b);
        } catch (IllegalArgumentException unused) {
        } catch (Exception e) {
            Log.e("ContentValues", "unregisterConnectionReceiver - " + e);
        }
    }

    public final JSONObject c(Context context) {
        return new JSONObject();
    }
}
