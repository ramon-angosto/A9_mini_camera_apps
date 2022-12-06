package com.mbridge.msdk.out;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.l;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.system.NoProGuard;
import java.util.concurrent.ConcurrentHashMap;

public class CustomInfoManager implements NoProGuard {
    private static CustomInfoManager INSTANCE = null;
    private static String TAG = "CustomInfoManager";
    public static final int TYPE_BID = 6;
    public static final int TYPE_BIDLOAD = 7;
    public static final int TYPE_LOAD = 8;
    private ConcurrentHashMap<String, String> infoMap = new ConcurrentHashMap<>();

    private CustomInfoManager() {
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static synchronized com.mbridge.msdk.out.CustomInfoManager getInstance() {
        /*
            java.lang.Class<com.mbridge.msdk.out.CustomInfoManager> r0 = com.mbridge.msdk.out.CustomInfoManager.class
            monitor-enter(r0)
            com.mbridge.msdk.out.CustomInfoManager r1 = INSTANCE     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x0018
            monitor-enter(r0)     // Catch:{ all -> 0x001c }
            com.mbridge.msdk.out.CustomInfoManager r1 = INSTANCE     // Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0013
            com.mbridge.msdk.out.CustomInfoManager r1 = new com.mbridge.msdk.out.CustomInfoManager     // Catch:{ all -> 0x0015 }
            r1.<init>()     // Catch:{ all -> 0x0015 }
            INSTANCE = r1     // Catch:{ all -> 0x0015 }
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            goto L_0x0018
        L_0x0015:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r1     // Catch:{ all -> 0x001c }
        L_0x0018:
            com.mbridge.msdk.out.CustomInfoManager r1 = INSTANCE     // Catch:{ all -> 0x001c }
            monitor-exit(r0)
            return r1
        L_0x001c:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.out.CustomInfoManager.getInstance():com.mbridge.msdk.out.CustomInfoManager");
    }

    public void setCustomInfo(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str) && str2 != null) {
            String a = l.a(str2);
            if (i == 6) {
                ConcurrentHashMap<String, String> concurrentHashMap = this.infoMap;
                concurrentHashMap.put(str + "_bid", a);
            } else if (i == 7) {
                ConcurrentHashMap<String, String> concurrentHashMap2 = this.infoMap;
                concurrentHashMap2.put(str + "_bidload", a);
            } else if (i == 8) {
                this.infoMap.put(str, a);
            }
        }
    }

    private String getCustomInfoByUnitId(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (i == 6) {
            ConcurrentHashMap<String, String> concurrentHashMap = this.infoMap;
            return concurrentHashMap.get(str + "_bid");
        } else if (i != 7) {
            return i != 8 ? "" : this.infoMap.get(str);
        } else {
            ConcurrentHashMap<String, String> concurrentHashMap2 = this.infoMap;
            return concurrentHashMap2.get(str + "_bidload");
        }
    }

    public String getCustomInfoByUnitId(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            Uri parse = Uri.parse(str2);
            if (parse != null) {
                String host = parse.getHost();
                String path = parse.getPath();
                if (!TextUtils.isEmpty(host)) {
                    if (host.contains(CampaignEx.JSON_KEY_HB) && !TextUtils.isEmpty(path) && path.contains("bid")) {
                        return getCustomInfoByUnitId(str, 6);
                    }
                }
                if (!TextUtils.isEmpty(host) && host.contains(CampaignEx.JSON_KEY_HB) && !TextUtils.isEmpty(path) && path.contains("load")) {
                    return getCustomInfoByUnitId(str, 7);
                }
                if (!TextUtils.isEmpty(path) && path.contains("v3")) {
                    return getCustomInfoByUnitId(str, 8);
                }
            }
        } catch (Throwable th) {
            q.a(TAG, "Exception", th);
        }
        return "";
    }
}
