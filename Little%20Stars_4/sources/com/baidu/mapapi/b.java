package com.baidu.mapapi;

import android.content.BroadcastReceiver;

class b extends BroadcastReceiver {
    b() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        if ("WIFI".matches(r7.getTypeName()) != false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002e, code lost:
        if ("WIFI".matches(r0.getTypeName()) != false) goto L_0x0030;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r7, android.content.Intent r8) {
        /*
            r6 = this;
            java.lang.String r8 = "wifi"
            java.lang.Object r8 = r7.getSystemService(r8)
            android.net.wifi.WifiManager r8 = (android.net.wifi.WifiManager) r8
            java.lang.String r0 = "connectivity"
            java.lang.Object r7 = r7.getSystemService(r0)
            android.net.ConnectivityManager r7 = (android.net.ConnectivityManager) r7
            android.net.NetworkInfo r0 = r7.getActiveNetworkInfo()
            r1 = 0
            android.net.NetworkInfo r7 = r7.getNetworkInfo(r1)
            r2 = 1
            r3 = -1
            r4 = 3
            java.lang.String r5 = "WIFI"
            if (r0 == 0) goto L_0x0032
            int r7 = r8.getWifiState()
            if (r7 != r4) goto L_0x0047
            java.lang.String r7 = r0.getTypeName()
            boolean r7 = r5.matches(r7)
            if (r7 == 0) goto L_0x0047
        L_0x0030:
            r1 = 1
            goto L_0x0047
        L_0x0032:
            if (r7 != 0) goto L_0x0036
            r1 = -1
            goto L_0x0047
        L_0x0036:
            int r8 = r8.getWifiState()
            if (r8 != r4) goto L_0x0047
            java.lang.String r7 = r7.getTypeName()
            boolean r7 = r5.matches(r7)
            if (r7 == 0) goto L_0x0047
            goto L_0x0030
        L_0x0047:
            com.baidu.mapapi.Mj.s = r1
            android.os.Bundle r7 = new android.os.Bundle
            r7.<init>()
            r8 = 15010902(0xe50c56, float:2.1034754E-38)
            java.lang.String r0 = "opt"
            r7.putInt(r0, r8)
            r8 = 15010900(0xe50c54, float:2.1034751E-38)
            java.lang.String r0 = "act"
            r7.putInt(r0, r8)
            int r8 = com.baidu.mapapi.Mj.s
            java.lang.String r0 = "state"
            r7.putInt(r0, r8)
            com.baidu.mapapi.Mj.sendBundle(r7)
            int r7 = com.baidu.mapapi.Mj.s
            if (r3 == r7) goto L_0x006f
            com.baidu.mapapi.Mj.changeGprsConnect()
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.b.onReceive(android.content.Context, android.content.Intent):void");
    }
}
