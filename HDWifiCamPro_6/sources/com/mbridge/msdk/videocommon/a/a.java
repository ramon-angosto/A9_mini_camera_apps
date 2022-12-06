package com.mbridge.msdk.videocommon.a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a.d;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.videocommon.d.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: VideoCampaignCache */
public class a {
    private static final String a = a.class.getName();
    private static a b = null;
    private e c;

    private a() {
        try {
            Context g = com.mbridge.msdk.foundation.controller.a.e().g();
            if (g != null) {
                this.c = e.a((f) g.a(g));
            } else {
                q.d(a, "RewardCampaignCache get Context is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (b == null) {
                b = new a();
            }
            aVar = b;
        }
        return aVar;
    }

    public final List<CampaignEx> a(String str, int i) {
        ArrayList arrayList;
        List<CampaignEx> a2;
        try {
            if (TextUtils.isEmpty(str) || (a2 = this.c.a(str, 0, 0, i)) == null) {
                return null;
            }
            arrayList = new ArrayList();
            try {
                for (CampaignEx next : a2) {
                    if (next != null) {
                        arrayList.add(next);
                    }
                }
                return arrayList;
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return arrayList;
            }
        } catch (Exception e2) {
            e = e2;
            arrayList = null;
            e.printStackTrace();
            return arrayList;
        }
    }

    public final void a(String str, List<CampaignEx> list, String str2, int i) {
        e eVar;
        if (!TextUtils.isEmpty(str) && list != null && list.size() > 0 && !TextUtils.isEmpty(str2) && (eVar = this.c) != null) {
            eVar.a(str, list, str2, i);
        }
    }

    public final void a(String str, List<CampaignEx> list) {
        e eVar;
        if (!TextUtils.isEmpty(str) && list != null && list.size() > 0 && (eVar = this.c) != null) {
            eVar.b(str, list);
        }
    }

    public final void a(String str, String str2) {
        if (this.c != null && !TextUtils.isEmpty(str)) {
            this.c.e(str, str2);
        }
    }

    public final List<CampaignEx> a(String str, int i, boolean z) {
        return a(str, i, z, "");
    }

    public final List<CampaignEx> a(String str, int i, boolean z, String str2) {
        List<CampaignEx> list;
        ArrayList arrayList = null;
        try {
            com.mbridge.msdk.videocommon.d.a b2 = b.a().b();
            long d = b2 != null ? b2.d() : 0;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (z) {
                list = this.c.a(str, 0, 0, i, str2);
            } else {
                list = this.c.a(str, 0, 0, i, false);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (list == null) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (CampaignEx next : list) {
                    if (next != null && (next.getReadyState() == 0 || next.getLoadTimeoutState() == 1)) {
                        long plct = next.getPlct() * 1000;
                        long timestamp = currentTimeMillis - next.getTimestamp();
                        int i2 = (plct > 0 ? 1 : (plct == 0 ? 0 : -1));
                        if ((i2 > 0 && plct >= timestamp) || (i2 <= 0 && d >= timestamp)) {
                            arrayList2.add(next);
                        }
                    }
                }
                return arrayList2;
            } catch (Exception e) {
                e = e;
                arrayList = arrayList2;
                e.printStackTrace();
                return arrayList;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return arrayList;
        }
    }

    public final List<CampaignEx> a(List<CampaignEx> list) {
        ArrayList arrayList = null;
        if (list == null) {
            return null;
        }
        try {
            com.mbridge.msdk.videocommon.d.a b2 = b.a().b();
            long d = b2 != null ? b2.d() : 0;
            long currentTimeMillis = System.currentTimeMillis();
            if (list == null || list.size() <= 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (CampaignEx next : list) {
                    if (next != null) {
                        long plct = next.getPlct() * 1000;
                        long timestamp = currentTimeMillis - next.getTimestamp();
                        int i = (plct > 0 ? 1 : (plct == 0 ? 0 : -1));
                        if ((i > 0 && plct >= timestamp) || (i <= 0 && d >= timestamp)) {
                            arrayList2.add(next);
                        }
                    }
                }
                return arrayList2;
            } catch (Exception e) {
                e = e;
                arrayList = arrayList2;
                e.printStackTrace();
                return arrayList;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return arrayList;
        }
    }

    public final List<com.mbridge.msdk.foundation.entity.b> a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return this.c.d(str);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final int b(String str, int i, boolean z, String str2) {
        List<CampaignEx> list;
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            ArrayList arrayList = new ArrayList();
            if (z) {
                list = this.c.a(str, 0, 0, i, str2);
            } else {
                list = this.c.a(str, 0, 0, i, false);
            }
            if (list == null) {
                return 0;
            }
            for (CampaignEx next : list) {
                if (next != null && next.getReadyState() == 0) {
                    arrayList.add(next);
                }
            }
            return arrayList.size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public final List<CampaignEx> b(String str, int i, boolean z) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return this.c.a(str, 0, 0, i, z);
            }
            return null;
        } catch (Exception e) {
            q.d(a, e.getLocalizedMessage());
            return null;
        }
    }

    public final List<CampaignEx> c(String str, int i, boolean z, String str2) {
        long v;
        List<CampaignEx> list;
        ArrayList arrayList = null;
        try {
            com.mbridge.msdk.b.a b2 = com.mbridge.msdk.b.b.a().b(com.mbridge.msdk.foundation.controller.a.e().h());
            if (b2 != null) {
                v = b2.v();
            } else {
                v = com.mbridge.msdk.b.b.a().b().v();
            }
            long j = v * 1000;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (z) {
                list = this.c.a(str, 0, 0, i, str2);
            } else {
                list = this.c.a(str, 0, 0, i, false);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (list == null) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (CampaignEx next : list) {
                    if (next != null && next.getReadyState() == 0) {
                        long plctb = next.getPlctb() * 1000;
                        long timestamp = currentTimeMillis - next.getTimestamp();
                        int i2 = (plctb > 0 ? 1 : (plctb == 0 ? 0 : -1));
                        if ((i2 <= 0 && j >= timestamp) || (i2 > 0 && plctb >= timestamp)) {
                            arrayList2.add(next);
                        }
                    }
                }
                return arrayList2;
            } catch (Exception e) {
                e = e;
                arrayList = arrayList2;
                e.printStackTrace();
                return arrayList;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return arrayList;
        }
    }

    public final void a(CampaignEx campaignEx, String str) {
        if (campaignEx != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (campaignEx.isBidCampaign()) {
                        d.b(str, campaignEx.getRequestId());
                    }
                    this.c.a(campaignEx.getId(), str, campaignEx.isBidCampaign(), campaignEx.getRequestId());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (!TextUtils.isEmpty(campaignEx.getId())) {
                    this.c.b(campaignEx.getId(), campaignEx.getRequestId());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void b(String str) {
        ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.b> e;
        try {
            if (!TextUtils.isEmpty(str) && (e = this.c.e(str)) != null && e.size() > 0) {
                com.mbridge.msdk.b.a b2 = com.mbridge.msdk.b.b.a().b(com.mbridge.msdk.foundation.controller.a.e().h());
                if (b2 == null) {
                    b2 = com.mbridge.msdk.b.b.a().b();
                }
                long v = b2 != null ? b2.v() : 0;
                long currentTimeMillis = System.currentTimeMillis();
                for (com.mbridge.msdk.foundation.entity.b next : e.values()) {
                    if (next != null) {
                        long d = next.d();
                        if (d <= 0) {
                            d = v;
                        }
                        if (next.e() + (d * 1000) < currentTimeMillis) {
                            if (!TextUtils.isEmpty(next.b())) {
                                b(str, next.b());
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void b(String str, int i) {
        int size;
        try {
            List<com.mbridge.msdk.foundation.entity.b> d = this.c.d(str);
            if (d != null && d.size() > 0 && (size = d.size() - i) > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    b(str, d.get(i2).b());
                    d.b(str, d.get(i2).b());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final synchronized void b(String str, String str2) {
        try {
            this.c.c(str2, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public final void a(String str, String str2, List<CampaignEx> list) {
        try {
            if (!TextUtils.isEmpty(str2) && list != null && list.size() > 0) {
                this.c.a(list, str, str2, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final synchronized void a(long j, String str) {
        try {
            this.c.a(j, str);
        } catch (Exception e) {
            e.printStackTrace();
            q.d(a, e.getMessage());
        }
        return;
    }

    public final synchronized void c(String str, int i) {
        try {
            com.mbridge.msdk.b.a b2 = com.mbridge.msdk.b.b.a().b(com.mbridge.msdk.foundation.controller.a.e().h());
            if (b2 == null) {
                b2 = com.mbridge.msdk.b.b.a().b();
            }
            int ae = b2.ae();
            if (ae != 0) {
                boolean z = true;
                List<CampaignEx> b3 = this.c.b(str, i, ae == 2);
                if (b3 != null && b3.size() > 0) {
                    for (CampaignEx next : b3) {
                        String requestIdNotice = next.getRequestIdNotice();
                        String id = next.getId();
                        com.mbridge.msdk.videocommon.a.b(next.getCampaignUnitId() + "_" + id + "_" + requestIdNotice + "_" + next.getCMPTEntryUrl());
                    }
                }
                e eVar = this.c;
                if (ae != 2) {
                    z = false;
                }
                eVar.a(str, i, z);
            } else {
                return;
            }
        } catch (Exception e) {
            q.d(a, e.getMessage());
        }
        return;
    }
}
