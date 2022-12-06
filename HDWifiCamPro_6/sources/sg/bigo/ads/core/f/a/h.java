package sg.bigo.ads.core.f.a;

import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.w3c.dom.Node;
import sg.bigo.ads.common.utils.o;
import sg.bigo.ads.core.f.a;

public final class h {
    final Node a;

    public h(Node node) {
        this.a = node;
    }

    private static void a(List<l> list, List<String> list2, float f) {
        for (String lVar : list2) {
            list.add(new l(lVar, f));
        }
    }

    private List<String> b(String str) {
        List<Node> b;
        ArrayList arrayList = new ArrayList();
        Node a2 = a.a(this.a, "TrackingEvents");
        if (a2 == null || (b = a.b(a2, "Tracking", NotificationCompat.CATEGORY_EVENT, Collections.singletonList(str))) == null) {
            return arrayList;
        }
        for (Node a3 : b) {
            String a4 = a.a(a3);
            if (a4 != null) {
                arrayList.add(a4);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        Node a2 = a.a(this.a, "VideoClicks", (String) null, (List<String>) null);
        if (a2 == null) {
            return null;
        }
        return a.a(a.a(a2, "ClickThrough", (String) null, (List<String>) null));
    }

    /* access modifiers changed from: package-private */
    public final List<n> a(String str) {
        List<String> b = b(str);
        ArrayList arrayList = new ArrayList(b.size());
        for (String nVar : b) {
            arrayList.add(new n(nVar));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final List<n> b() {
        List<Node> c;
        ArrayList arrayList = new ArrayList();
        Node a2 = a.a(this.a, "VideoClicks");
        if (a2 == null || (c = a.c(a2, "ClickTracking")) == null) {
            return arrayList;
        }
        for (Node a3 : c) {
            String a4 = a.a(a3);
            if (a4 != null) {
                arrayList.add(new n(a4));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final List<j> c() {
        List<String> b = b("mute");
        ArrayList arrayList = new ArrayList();
        for (String jVar : b) {
            arrayList.add(new j(jVar, true));
        }
        for (String jVar2 : b("unmute")) {
            arrayList.add(new j(jVar2, false));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final List<n> d() {
        List<n> a2 = a("close");
        a2.addAll(a("closeLinear"));
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final List<n> e() {
        List<String> b = b(CampaignEx.JSON_NATIVE_VIDEO_PAUSE);
        ArrayList arrayList = new ArrayList();
        for (String nVar : b) {
            arrayList.add(new n(nVar, (byte) 0));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final List<n> f() {
        List<String> b = b(CampaignEx.JSON_NATIVE_VIDEO_RESUME);
        ArrayList arrayList = new ArrayList();
        for (String nVar : b) {
            arrayList.add(new n(nVar, (byte) 0));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final List<l> g() {
        ArrayList arrayList = new ArrayList();
        a(arrayList, b("firstQuartile"), 25.0f);
        a(arrayList, b(CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT), 50.0f);
        a(arrayList, b("thirdQuartile"), 75.0f);
        List<Node> b = a.b(a.a(this.a, "TrackingEvents"), "Tracking", NotificationCompat.CATEGORY_EVENT, Collections.singletonList(NotificationCompat.CATEGORY_PROGRESS));
        if (b != null) {
            for (Node next : b) {
                String e = a.e(next, "offset");
                if (e != null) {
                    String trim = e.trim();
                    if (o.a(trim)) {
                        String a2 = a.a(next);
                        try {
                            int d = o.d(trim);
                            if (d >= 0 && o.c(a2)) {
                                arrayList.add(new l(a2, (float) d));
                            }
                        } catch (NumberFormatException unused) {
                            sg.bigo.ads.common.k.a.a(0, 3, "VastLinearNode", String.format("Failed to parse VAST progress tracker %s", new Object[]{trim}));
                        }
                    }
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final List<c> h() {
        ArrayList arrayList = new ArrayList();
        for (String cVar : b("start")) {
            arrayList.add(new c(cVar, 0));
        }
        Node a2 = a.a(this.a, "TrackingEvents");
        List<Node> b = a.b(a2, "Tracking", NotificationCompat.CATEGORY_EVENT, Collections.singletonList(NotificationCompat.CATEGORY_PROGRESS));
        if (b != null) {
            for (Node next : b) {
                String e = a.e(next, "offset");
                if (e != null) {
                    String trim = e.trim();
                    if (o.b(trim)) {
                        String b2 = a.b(next);
                        if (!o.b(b2)) {
                            try {
                                int c = o.c(trim);
                                if (c >= 0) {
                                    arrayList.add(new c(b2, c));
                                }
                            } catch (NumberFormatException unused) {
                                sg.bigo.ads.common.k.a.a(0, 3, "VastLinearNode", String.format("Failed to parse VAST progress tracker %s", new Object[]{trim}));
                            }
                        }
                    }
                }
            }
        }
        List<Node> b3 = a.b(a2, "Tracking", NotificationCompat.CATEGORY_EVENT, Collections.singletonList("creativeView"));
        if (b3 != null) {
            for (Node a3 : b3) {
                String a4 = a.a(a3);
                if (a4 != null) {
                    arrayList.add(new c(a4, 0));
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public final int i() {
        String b = a.b(this.a, "Duration");
        if (o.b(b)) {
            return -1;
        }
        return o.c(b);
    }
}
