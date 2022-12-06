package com.mbridge.msdk.videocommon.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetStateOnReceive extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                    c.getInstance().a(false);
                } else if (activeNetworkInfo.getType() == 1) {
                    c.getInstance().b(true);
                } else if (activeNetworkInfo.getType() == 0) {
                    c.getInstance().a();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
