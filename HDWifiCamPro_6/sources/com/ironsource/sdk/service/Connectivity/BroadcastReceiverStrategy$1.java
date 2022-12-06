package com.ironsource.sdk.service.Connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ironsource.d.a;
import org.json.JSONObject;

class BroadcastReceiverStrategy$1 extends BroadcastReceiver {
    private /* synthetic */ a a;

    BroadcastReceiverStrategy$1(a aVar) {
        this.a = aVar;
    }

    public void onReceive(Context context, Intent intent) {
        String a2 = a.a(context);
        if (a2.equals("none")) {
            this.a.a.a();
            return;
        }
        d dVar = this.a.a;
        new JSONObject();
        dVar.a(a2);
    }
}
