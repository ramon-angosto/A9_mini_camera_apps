package com.mbridge.msdk.reward.adapter;

import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.system.NoProGuard;
import com.mbridge.msdk.videocommon.d.c;
import java.util.concurrent.ConcurrentHashMap;

public final class RewardUnitCacheManager implements NoProGuard {
    private static final String TAG = "RewardUnitCacheManager";
    private ConcurrentHashMap<String, c> rewardUnitSettings;

    private static final class a {
        /* access modifiers changed from: private */
        public static final RewardUnitCacheManager a = new RewardUnitCacheManager();
    }

    private RewardUnitCacheManager() {
        this.rewardUnitSettings = new ConcurrentHashMap<>();
    }

    public static RewardUnitCacheManager getInstance() {
        return a.a;
    }

    public final void add(String str, String str2, c cVar) {
        try {
            String str3 = str + "_" + str2;
            if (cVar != null && this.rewardUnitSettings.containsKey(str3)) {
                this.rewardUnitSettings.remove(str3);
            }
            this.rewardUnitSettings.put(str3, cVar);
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public final c get(String str, String str2) {
        try {
            return this.rewardUnitSettings.remove(str + "_" + str2);
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        } catch (Throwable unused) {
        }
        return null;
    }
}
