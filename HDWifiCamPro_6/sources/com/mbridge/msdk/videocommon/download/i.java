package com.mbridge.msdk.videocommon.download;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ResDownloadCheckManager */
public final class i {
    private static Map<String, Boolean> b = new HashMap();
    private Map<String, Boolean> a;
    private Map<String, Boolean> c;
    private Map<String, Boolean> d;
    private Map<String, Boolean> e;

    /* compiled from: ResDownloadCheckManager */
    private static final class a {
        public static i a = new i();
    }

    private i() {
        this.a = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new HashMap();
    }

    public static i a() {
        return a.a;
    }

    public final boolean a(String str) {
        if (this.a == null || TextUtils.isEmpty(str) || !this.a.containsKey(str)) {
            return false;
        }
        return this.a.get(str).booleanValue();
    }

    public final boolean b(String str) {
        if (this.c == null || TextUtils.isEmpty(str) || !this.c.containsKey(str)) {
            return false;
        }
        return this.c.get(str).booleanValue();
    }

    public final void a(List<CampaignEx> list) {
        List<CampaignEx.c.a> f;
        List<String> list2;
        Map<String, Boolean> map;
        if (list != null && list.size() != 0) {
            for (CampaignEx next : list) {
                if (next != null) {
                    if (next != null) {
                        String videoUrlEncode = next.getVideoUrlEncode();
                        Map<String, Boolean> map2 = this.a;
                        if (map2 != null && !map2.containsKey(videoUrlEncode)) {
                            this.a.put(videoUrlEncode, false);
                        }
                        String str = next.getendcard_url();
                        Map<String, Boolean> map3 = this.c;
                        if (map3 != null && !map3.containsKey(str)) {
                            this.c.put(str, false);
                        }
                        CampaignEx.c rewardTemplateMode = next.getRewardTemplateMode();
                        if (!(rewardTemplateMode == null || (f = rewardTemplateMode.f()) == null)) {
                            for (CampaignEx.c.a next2 : f) {
                                if (!(next2 == null || (list2 = next2.b) == null || list2.size() == 0)) {
                                    for (String next3 : list2) {
                                        if (!TextUtils.isEmpty(next3) && (map = b) != null && !map.containsKey(next3)) {
                                            b.put(next3, Boolean.valueOf(b.a(com.mbridge.msdk.foundation.controller.a.e().g()).b(next3)));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    String id = next.getId();
                    if (this.d == null) {
                        this.d = new HashMap();
                    }
                    this.d.put(id, false);
                }
            }
        }
    }

    public final void a(String str, boolean z) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, Boolean.valueOf(z));
    }

    public final void b(String str, boolean z) {
        if (this.c == null) {
            this.c = new HashMap();
        }
        this.c.put(str, Boolean.valueOf(z));
    }

    public final void c(String str, boolean z) {
        if (b == null) {
            b = new HashMap();
        }
        b.put(str, Boolean.valueOf(z));
    }

    public final void d(String str, boolean z) {
        if (this.e == null) {
            this.e = new HashMap();
        }
        this.e.put(str, Boolean.valueOf(z));
    }

    public final boolean c(String str) {
        if (!TextUtils.isEmpty(str) && this.e.containsKey(str)) {
            return this.e.get(str).booleanValue();
        }
        return false;
    }
}
