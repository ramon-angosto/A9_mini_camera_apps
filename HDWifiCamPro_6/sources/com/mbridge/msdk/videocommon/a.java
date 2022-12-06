package com.mbridge.msdk.videocommon;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: TemplateWebviewCache */
public final class a {
    private static ConcurrentHashMap<String, C0105a> a = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0105a> b = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0105a> c = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0105a> d = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0105a> e = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0105a> f = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0105a> g = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0105a> h = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0105a> i = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0105a> j = new ConcurrentHashMap<>();

    /* renamed from: com.mbridge.msdk.videocommon.a$a  reason: collision with other inner class name */
    /* compiled from: TemplateWebviewCache */
    public static class C0105a {
        private WindVaneWebView a;
        private boolean b;

        public final WindVaneWebView a() {
            return this.a;
        }

        public final void a(WindVaneWebView windVaneWebView) {
            this.a = windVaneWebView;
        }

        public final void a(String str) {
            WindVaneWebView windVaneWebView = this.a;
            if (windVaneWebView != null) {
                windVaneWebView.setTag(str);
            }
        }

        public final String b() {
            WindVaneWebView windVaneWebView = this.a;
            return windVaneWebView != null ? (String) windVaneWebView.getTag() : "";
        }

        public final boolean c() {
            return this.b;
        }

        public final void a(boolean z) {
            this.b = z;
        }
    }

    public static C0105a a(String str) {
        if (g.containsKey(str)) {
            return g.get(str);
        }
        if (h.containsKey(str)) {
            return h.get(str);
        }
        if (i.containsKey(str)) {
            return i.get(str);
        }
        if (j.containsKey(str)) {
            return j.get(str);
        }
        return null;
    }

    public static void a(String str, C0105a aVar, boolean z, boolean z2) {
        if (z) {
            if (z2) {
                h.put(str, aVar);
            } else {
                g.put(str, aVar);
            }
        } else if (z2) {
            j.put(str, aVar);
        } else {
            i.put(str, aVar);
        }
    }

    public static void b(String str) {
        if (g.containsKey(str)) {
            g.remove(str);
        }
        if (i.containsKey(str)) {
            i.remove(str);
        }
        if (h.containsKey(str)) {
            h.remove(str);
        }
        if (j.containsKey(str)) {
            j.remove(str);
        }
    }

    public static void a() {
        g.clear();
        h.clear();
    }

    public static void b() {
        i.clear();
        j.clear();
    }

    public static void c(String str) {
        for (Map.Entry next : g.entrySet()) {
            if (((String) next.getKey()).contains(str)) {
                g.remove(next.getKey());
            }
        }
    }

    public static void d(String str) {
        for (Map.Entry next : h.entrySet()) {
            if (((String) next.getKey()).contains(str)) {
                h.remove(next.getKey());
            }
        }
    }

    public static C0105a a(int i2, CampaignEx campaignEx) {
        if (campaignEx == null) {
            return null;
        }
        try {
            String requestIdNotice = campaignEx.getRequestIdNotice();
            if (i2 == 288) {
                requestIdNotice = campaignEx.getKeyIaUrl();
            }
            if (i2 != 94) {
                if (i2 != 287) {
                    if (i2 != 288) {
                        if (a != null && a.size() > 0) {
                            return a.get(requestIdNotice);
                        }
                    } else if (d != null && d.size() > 0) {
                        return d.get(requestIdNotice);
                    }
                } else if (campaignEx.isBidCampaign()) {
                    if (c != null && c.size() > 0) {
                        return c.get(requestIdNotice);
                    }
                } else if (f != null && f.size() > 0) {
                    return f.get(requestIdNotice);
                }
            } else if (campaignEx.isBidCampaign()) {
                if (b != null && b.size() > 0) {
                    return b.get(requestIdNotice);
                }
            } else if (e != null && e.size() > 0) {
                return e.get(requestIdNotice);
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static void b(int i2, CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                String requestIdNotice = campaignEx.getRequestIdNotice();
                if (i2 == 288) {
                    requestIdNotice = campaignEx.getKeyIaUrl();
                }
                if (i2 != 94) {
                    if (i2 != 287) {
                        if (i2 != 288) {
                            if (a != null) {
                                a.remove(requestIdNotice);
                            }
                        } else if (d != null) {
                            d.remove(requestIdNotice);
                        }
                    } else if (campaignEx.isBidCampaign()) {
                        if (c != null) {
                            c.remove(requestIdNotice);
                        }
                    } else if (f != null) {
                        f.remove(requestIdNotice);
                    }
                } else if (campaignEx.isBidCampaign()) {
                    if (b != null) {
                        b.remove(requestIdNotice);
                    }
                } else if (e != null) {
                    e.remove(requestIdNotice);
                }
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void a(int i2, String str, C0105a aVar) {
        if (i2 == 94) {
            if (b == null) {
                b = new ConcurrentHashMap<>();
            }
            b.put(str, aVar);
        } else if (i2 == 287) {
            try {
                if (c == null) {
                    c = new ConcurrentHashMap<>();
                }
                c.put(str, aVar);
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void b(int i2, String str, C0105a aVar) {
        if (i2 == 94) {
            if (e == null) {
                e = new ConcurrentHashMap<>();
            }
            e.put(str, aVar);
        } else if (i2 == 287) {
            if (f == null) {
                f = new ConcurrentHashMap<>();
            }
            f.put(str, aVar);
        } else if (i2 != 288) {
            try {
                if (a == null) {
                    a = new ConcurrentHashMap<>();
                }
                a.put(str, aVar);
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        } else {
            if (d == null) {
                d = new ConcurrentHashMap<>();
            }
            d.put(str, aVar);
        }
    }
}
