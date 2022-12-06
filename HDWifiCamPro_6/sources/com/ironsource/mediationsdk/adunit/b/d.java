package com.ironsource.mediationsdk.adunit.b;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.a.c;
import com.ironsource.mediationsdk.a.h;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d {
    public g a;
    public h b;
    public e c;
    public a d;
    public i e;
    private final int f = -1;
    private IronSource.AD_UNIT g;
    private b h;
    private c i;
    private com.ironsource.mediationsdk.a.b j;
    private Map<b, a> k;
    private Map<b, a> l;

    class a {
        private int a;
        private int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        /* access modifiers changed from: package-private */
        public final int a(b bVar) {
            return b.MEDIATION.equals(bVar) ? this.a : this.b;
        }
    }

    public enum b {
        MEDIATION,
        PROVIDER
    }

    public d(IronSource.AD_UNIT ad_unit, b bVar, c cVar) {
        this.g = ad_unit;
        this.h = bVar;
        this.i = cVar;
        this.j = (ad_unit.equals(IronSource.AD_UNIT.REWARDED_VIDEO) || ad_unit.equals(IronSource.AD_UNIT.OFFERWALL)) ? h.e() : com.ironsource.mediationsdk.a.d.e();
        this.k = new HashMap();
        this.k.put(b.INIT_STARTED, new a(IronSourceConstants.IS_MANAGER_INIT_STARTED, -1));
        this.k.put(b.INIT_ENDED, new a(IronSourceConstants.IS_MANAGER_INIT_ENDED, -1));
        this.k.put(b.SESSION_CAPPED, new a(-1, IronSourceConstants.IS_CAP_SESSION));
        this.k.put(b.PLACEMENT_CAPPED, new a(IronSourceConstants.IS_CAP_PLACEMENT, -1));
        this.k.put(b.AUCTION_REQUEST, new a(2000, -1));
        this.k.put(b.AUCTION_SUCCESS, new a(IronSourceConstants.IS_AUCTION_SUCCESS, -1));
        this.k.put(b.AUCTION_FAILED, new a(IronSourceConstants.IS_AUCTION_FAILED, -1));
        this.k.put(b.AUCTION_REQUEST_WATERFALL, new a(IronSourceConstants.IS_AUCTION_REQUEST_WATERFALL, -1));
        this.k.put(b.AUCTION_RESULT_WATERFALL, new a(IronSourceConstants.IS_RESULT_WATERFALL, -1));
        this.k.put(b.INIT_SUCCESS, new a(-1, -1));
        this.k.put(b.INIT_FAILED, new a(-1, -1));
        this.k.put(b.SHOW_AD_SUCCESS, new a(-1, IronSourceConstants.IS_INSTANCE_SHOW_SUCCESS));
        this.k.put(b.AD_OPENED, new a(-1, IronSourceConstants.IS_INSTANCE_OPENED));
        this.k.put(b.AD_CLOSED, new a(-1, IronSourceConstants.IS_INSTANCE_CLOSED));
        this.k.put(b.AD_CLICKED, new a(-1, 2006));
        this.k.put(b.LOAD_AD, new a(2001, 2002));
        this.k.put(b.LOAD_AD_SUCCESS, new a(2004, 2003));
        this.k.put(b.LOAD_AD_FAILED, new a(IronSourceConstants.IS_CALLBACK_LOAD_ERROR, IronSourceConstants.IS_INSTANCE_LOAD_FAILED));
        this.k.put(b.LOAD_AD_NO_FILL, new a(-1, IronSourceConstants.IS_INSTANCE_LOAD_NO_FILL));
        this.k.put(b.SHOW_AD, new a(2100, IronSourceConstants.IS_INSTANCE_SHOW));
        this.k.put(b.SHOW_AD_SUCCESS, new a(-1, IronSourceConstants.IS_INSTANCE_SHOW_SUCCESS));
        this.k.put(b.SHOW_AD_FAILED, new a(IronSourceConstants.IS_CALLBACK_AD_SHOW_ERROR, IronSourceConstants.IS_INSTANCE_SHOW_FAILED));
        this.k.put(b.AD_UNIT_CAPPED, new a(IronSourceConstants.IS_AD_UNIT_CAPPED, -1));
        this.k.put(b.TROUBLESHOOT_NETWORK_ADAPTER_NOT_AVAILABLE, new a(IronSourceConstants.TROUBLESHOOTING_IS_NETWORK_ADAPTER_NOT_AVAILABLE, IronSourceConstants.TROUBLESHOOTING_IS_NETWORK_ADAPTER_NOT_AVAILABLE));
        this.k.put(b.TROUBLESHOOT_AD_ADAPTER_NOT_AVAILABLE, new a(IronSourceConstants.TROUBLESHOOTING_IS_AD_ADAPTER_NOT_AVAILABLE, IronSourceConstants.TROUBLESHOOTING_IS_AD_ADAPTER_NOT_AVAILABLE));
        this.k.put(b.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_IS_PROVIDER_SETTINGS_MISSING, IronSourceConstants.TROUBLESHOOTING_IS_PROVIDER_SETTINGS_MISSING));
        this.k.put(b.TROUBLESHOOT_BIDDING_DATA_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_IS_BIDDING_DATA_MISSING, IronSourceConstants.TROUBLESHOOTING_IS_BIDDING_DATA_MISSING));
        this.k.put(b.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_INIT_SUCCESS, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_INIT_SUCCESS));
        this.k.put(b.TROUBLESHOOT_UNEXPECTED_INIT_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_INIT_FAILED, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_INIT_FAILED));
        this.k.put(b.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_AUCTION_SUCCESS, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_AUCTION_SUCCESS));
        this.k.put(b.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_AUCTION_FAILED, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_AUCTION_FAILED));
        this.k.put(b.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_LOAD_SUCCESS, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_LOAD_SUCCESS));
        this.k.put(b.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_LOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_LOAD_FAILED));
        this.k.put(b.TROUBLESHOOT_UNEXPECTED_TIMEOUT, new a(IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_TIMEOUT, IronSourceConstants.TROUBLESHOOTING_IS_UNEXPECTED_TIMEOUT));
        this.k.put(b.TROUBLESHOOT_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_IS_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_IS_INTERNAL_ERROR));
        this.k.put(b.TROUBLESHOOT_ADAPTER_BRIDGE_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_BRIDGE_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_ADAPTER_BRIDGE_INTERNAL_ERROR));
        this.k.put(b.TROUBLESHOOT_ADAPTER_REPOSITORY_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR));
        this.k.put(b.TROUBLESHOOT_AUCTION_SUCCESSFUL_RECOVERY_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_AUCTION_SUCCESSFUL_RECOVERY_ERROR, IronSourceConstants.TROUBLESHOOTING_AUCTION_SUCCESSFUL_RECOVERY_ERROR));
        this.k.put(b.TROUBLESHOOT_NOTIFICATION_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_IS_NOTIFICATIONS_ERROR, -1));
        this.l = new HashMap();
        this.l.put(b.INIT_STARTED, new a(IronSourceConstants.RV_MANAGER_INIT_STARTED, -1));
        this.l.put(b.INIT_ENDED, new a(IronSourceConstants.RV_MANAGER_INIT_ENDED, -1));
        this.l.put(b.SESSION_CAPPED, new a(-1, IronSourceConstants.RV_CAP_SESSION));
        this.l.put(b.PLACEMENT_CAPPED, new a(IronSourceConstants.RV_CAP_PLACEMENT, -1));
        this.l.put(b.AUCTION_REQUEST, new a(IronSourceConstants.RV_AUCTION_REQUEST, -1));
        this.l.put(b.AUCTION_SUCCESS, new a(IronSourceConstants.RV_AUCTION_SUCCESS, -1));
        this.l.put(b.AUCTION_FAILED, new a(IronSourceConstants.RV_AUCTION_FAILED, -1));
        this.l.put(b.AUCTION_REQUEST_WATERFALL, new a(IronSourceConstants.RV_AUCTION_REQUEST_WATERFALL, -1));
        this.l.put(b.AUCTION_RESULT_WATERFALL, new a(IronSourceConstants.RV_AUCTION_RESPONSE_WATERFALL, -1));
        this.l.put(b.INIT_SUCCESS, new a(-1, -1));
        this.l.put(b.INIT_FAILED, new a(-1, -1));
        this.l.put(b.AD_VISIBLE, new a(-1, IronSourceConstants.RV_INSTANCE_VISIBLE));
        this.l.put(b.AD_OPENED, new a(-1, 1005));
        this.l.put(b.AD_CLOSED, new a(-1, IronSourceConstants.RV_INSTANCE_CLOSED));
        this.l.put(b.AD_STARTED, new a(-1, IronSourceConstants.RV_INSTANCE_STARTED));
        this.l.put(b.AD_ENDED, new a(-1, IronSourceConstants.RV_INSTANCE_ENDED));
        this.l.put(b.AD_CLICKED, new a(-1, 1006));
        this.l.put(b.AD_REWARDED, new a(-1, 1010));
        this.l.put(b.AD_AVAILABILITY_CHANGED_TRUE, new a(IronSourceConstants.RV_CALLBACK_AVAILABILITY_TRUE, IronSourceConstants.RV_INSTANCE_AVAILABILITY_TRUE));
        this.l.put(b.AD_AVAILABILITY_CHANGED_FALSE, new a(IronSourceConstants.RV_CALLBACK_AVAILABILITY_FALSE, IronSourceConstants.RV_INSTANCE_AVAILABILITY_FALSE));
        this.l.put(b.LOAD_AD, new a(1000, 1001));
        this.l.put(b.LOAD_AD_SUCCESS, new a(1003, 1002));
        this.l.put(b.LOAD_AD_FAILED, new a(IronSourceConstants.RV_MEDIATION_LOAD_ERROR, IronSourceConstants.RV_INSTANCE_LOAD_FAILED));
        this.l.put(b.LOAD_AD_FAILED_WITH_REASON, new a(-1, IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON));
        this.l.put(b.LOAD_AD_NO_FILL, new a(-1, IronSourceConstants.RV_INSTANCE_LOAD_NO_FILL));
        this.l.put(b.SHOW_AD, new a(IronSourceConstants.RV_API_SHOW_CALLED, IronSourceConstants.RV_INSTANCE_SHOW));
        this.l.put(b.SHOW_AD_CHANCE, new a(-1, IronSourceConstants.RV_INSTANCE_SHOW_CHANCE));
        this.l.put(b.SHOW_AD_FAILED, new a(IronSourceConstants.RV_CALLBACK_SHOW_FAILED, IronSourceConstants.RV_INSTANCE_SHOW_FAILED));
        this.l.put(b.AD_UNIT_CAPPED, new a(IronSourceConstants.RV_AD_UNIT_CAPPED, -1));
        this.l.put(b.TROUBLESHOOT_NETWORK_ADAPTER_NOT_AVAILABLE, new a(IronSourceConstants.TROUBLESHOOTING_RV_NETWORK_ADAPTER_NOT_AVAILABLE, IronSourceConstants.TROUBLESHOOTING_RV_NETWORK_ADAPTER_NOT_AVAILABLE));
        this.l.put(b.TROUBLESHOOT_AD_ADAPTER_NOT_AVAILABLE, new a(IronSourceConstants.TROUBLESHOOTING_RV_AD_ADAPTER_NOT_AVAILABLE, IronSourceConstants.TROUBLESHOOTING_RV_AD_ADAPTER_NOT_AVAILABLE));
        this.l.put(b.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_RV_PROVIDER_SETTINGS_MISSING, IronSourceConstants.TROUBLESHOOTING_RV_PROVIDER_SETTINGS_MISSING));
        this.l.put(b.TROUBLESHOOT_BIDDING_DATA_MISSING, new a(IronSourceConstants.TROUBLESHOOTING_RV_BIDDING_DATA_MISSING, IronSourceConstants.TROUBLESHOOTING_RV_BIDDING_DATA_MISSING));
        this.l.put(b.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_INIT_SUCCESS, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_INIT_SUCCESS));
        this.l.put(b.TROUBLESHOOT_UNEXPECTED_INIT_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_INIT_FAILED, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_INIT_FAILED));
        this.l.put(b.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_AUCTION_SUCCESS, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_AUCTION_SUCCESS));
        this.l.put(b.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_AUCTION_FAILED, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_AUCTION_FAILED));
        this.l.put(b.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_LOAD_SUCCESS, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_LOAD_SUCCESS));
        this.l.put(b.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_LOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_LOAD_FAILED));
        this.l.put(b.TROUBLESHOOT_UNEXPECTED_TIMEOUT, new a(IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_TIMEOUT, IronSourceConstants.TROUBLESHOOTING_RV_UNEXPECTED_TIMEOUT));
        this.l.put(b.TROUBLESHOOT_LOAD_FAILED, new a(IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED, IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED));
        this.l.put(b.TROUBLESHOOT_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_RV_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_RV_INTERNAL_ERROR));
        this.l.put(b.TROUBLESHOOT_ADAPTER_BRIDGE_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_BRIDGE_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_ADAPTER_BRIDGE_INTERNAL_ERROR));
        this.l.put(b.TROUBLESHOOT_ADAPTER_REPOSITORY_INTERNAL_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR, IronSourceConstants.TROUBLESHOOTING_ADAPTER_REPOSITORY_INTERNAL_ERROR));
        this.l.put(b.TROUBLESHOOTING_WATERFALL_OVERHEAD, new a(IronSourceConstants.TROUBLESHOOTING_RV_WATERFALL_OVERHEAD, IronSourceConstants.TROUBLESHOOTING_RV_WATERFALL_OVERHEAD));
        this.l.put(b.TROUBLESHOOT_NOTIFICATION_ERROR, new a(IronSourceConstants.TROUBLESHOOTING_RV_NOTIFICATIONS_ERROR, -1));
        this.a = new g(this);
        this.b = new h(this);
        this.c = new e(this);
        this.d = new a(this);
        this.e = new i(this);
    }

    private int a(b bVar) {
        try {
            if (IronSource.AD_UNIT.INTERSTITIAL.equals(this.g) && this.k.containsKey(bVar)) {
                return this.k.get(bVar).a(this.h);
            }
            if (!IronSource.AD_UNIT.REWARDED_VIDEO.equals(this.g) || !this.l.containsKey(bVar)) {
                return -1;
            }
            return this.l.get(bVar).a(this.h);
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public final void a() {
        this.i = null;
        this.c = null;
        this.a = null;
        this.b = null;
        this.d = null;
        this.e = null;
    }

    /* access modifiers changed from: protected */
    public final void a(b bVar, Map<String, Object> map) {
        a(bVar, map, System.currentTimeMillis());
    }

    /* access modifiers changed from: protected */
    public final void a(b bVar, Map<String, Object> map, long j2) {
        int a2 = a(bVar);
        if (-1 != a2) {
            if (map == null) {
                map = new HashMap<>();
            }
            c cVar = this.i;
            if (cVar != null) {
                map.putAll(cVar.a(bVar));
            }
            this.j.b(new c(a2, j2, new JSONObject(map)));
        }
    }
}
