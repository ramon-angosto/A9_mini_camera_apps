package sg.bigo.ads.core.e;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sg.bigo.ads.common.l.b;
import sg.bigo.ads.common.l.c.c;
import sg.bigo.ads.common.l.g;
import sg.bigo.ads.common.l.h;

public final class a {

    /* renamed from: sg.bigo.ads.core.e.a$a  reason: collision with other inner class name */
    public interface C0138a {
        void a();

        boolean a(int i);

        void b();
    }

    public static void a(String str, String str2, String str3, Map<String, String> map, C0138a aVar) {
        a(str, str2, str3, false, 0, map, aVar);
    }

    private static void a(String str, String str2, String str3, boolean z, int i, Map<String, String> map) {
        b(str, "start", str2, str3, z, i, map, 0, "");
    }

    public static void a(String str, String str2, String str3, boolean z, int i, Map<String, String> map, C0138a aVar) {
        if (!sg.bigo.ads.common.n.a.c()) {
            sg.bigo.ads.common.k.a.a(0, 3, "TrackerRequestHelper", "track url = ".concat(String.valueOf(str2)));
            a(str, str2, str3, z, i, map);
            final String str4 = str2;
            final C0138a aVar2 = aVar;
            final String str5 = str;
            final String str6 = str3;
            final boolean z2 = z;
            final int i2 = i;
            final Map<String, String> map2 = map;
            g.a(new sg.bigo.ads.common.l.b.a(str2), new b<sg.bigo.ads.common.l.b.a, sg.bigo.ads.common.l.c.a>() {
                private final List<Integer> i = new ArrayList();
                private int j = -1;
                private boolean k = false;

                public final /* bridge */ /* synthetic */ c a(sg.bigo.ads.common.l.c.a aVar) {
                    return aVar;
                }

                public final /* synthetic */ void a(sg.bigo.ads.common.l.b.c cVar, String str, int i2) {
                    super.a((sg.bigo.ads.common.l.b.a) cVar, str, i2);
                    this.i.add(Integer.valueOf(i2));
                }

                public final /* synthetic */ void a(sg.bigo.ads.common.l.b.c cVar, c cVar2) {
                    sg.bigo.ads.common.l.c.a aVar = (sg.bigo.ads.common.l.c.a) cVar2;
                    C0138a aVar2 = aVar2;
                    if (aVar2 != null) {
                        aVar2.b();
                    }
                    a.b(str5, "success", str4, str6, z2, i2, map2, aVar.a, "success");
                }

                public final /* synthetic */ void a(sg.bigo.ads.common.l.b.c cVar, h hVar) {
                    String str;
                    String str2;
                    String str3;
                    boolean z;
                    int i2;
                    Map map;
                    int i3;
                    String message;
                    String str4;
                    if (this.k) {
                        C0138a aVar = aVar2;
                        if (aVar != null) {
                            aVar.b();
                        }
                        str = str5;
                        str2 = str4;
                        str3 = str6;
                        z = z2;
                        i2 = i2;
                        map = map2;
                        i3 = this.j;
                        str4 = "success";
                        message = "Something wrong occurs when handling the request, but it is still successful";
                    } else {
                        sg.bigo.ads.common.k.a.a(0, 3, "TrackerRequestHelper", "track onError e=" + hVar.getMessage());
                        C0138a aVar2 = aVar2;
                        if (aVar2 != null) {
                            aVar2.a();
                        }
                        str = str5;
                        str2 = str4;
                        str3 = str6;
                        z = z2;
                        i2 = i2;
                        map = map2;
                        i3 = hVar.a;
                        message = hVar.getMessage();
                        str4 = "failure";
                    }
                    a.b(str, str4, str2, str3, z, i2, map, i3, message);
                }

                /* JADX WARNING: Removed duplicated region for block: B:3:0x0017  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final /* synthetic */ boolean a(sg.bigo.ads.common.l.b.c r3, int r4) {
                    /*
                        r2 = this;
                        sg.bigo.ads.common.l.b.a r3 = (sg.bigo.ads.common.l.b.a) r3
                        java.util.List<java.lang.Integer> r0 = r2.i
                        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                        r0.add(r4)
                        java.util.List<java.lang.Integer> r4 = r2.i
                        java.util.Iterator r4 = r4.iterator()
                    L_0x0011:
                        boolean r0 = r4.hasNext()
                        if (r0 == 0) goto L_0x0037
                        java.lang.Object r0 = r4.next()
                        java.lang.Integer r0 = (java.lang.Integer) r0
                        int r0 = r0.intValue()
                        sg.bigo.ads.core.e.a$a r1 = r2
                        if (r1 == 0) goto L_0x002b
                        boolean r1 = r1.a(r0)
                        if (r1 != 0) goto L_0x0031
                    L_0x002b:
                        boolean r1 = super.a(r3, (int) r0)
                        if (r1 == 0) goto L_0x0011
                    L_0x0031:
                        r2.j = r0
                        r3 = 1
                        r2.k = r3
                        return r3
                    L_0x0037:
                        r3 = 0
                        return r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.e.a.AnonymousClass1.a(sg.bigo.ads.common.l.b.c, int):boolean");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void b(String str, String str2, String str3, String str4, boolean z, int i, Map<String, String> map, int i2, String str5) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (TextUtils.isEmpty(str)) {
            str = "unknown";
        }
        HashMap hashMap = new HashMap(map);
        hashMap.put("action", str);
        hashMap.put("track_url", str3);
        hashMap.put("track_name", str4);
        hashMap.put("states", str2);
        hashMap.put("src", z ? "1" : MBridgeConstans.ENDCARD_URL_TYPE_PL);
        hashMap.put("res_code", String.valueOf(i2));
        if (str5 == null) {
            str5 = "";
        }
        hashMap.put("res_msg", str5);
        hashMap.put("retry", String.valueOf(i));
        char c = 65535;
        switch (str.hashCode()) {
            case -1900391442:
                if (str.equals("va_cpn_cli")) {
                    c = 5;
                    break;
                }
                break;
            case -1900385638:
                if (str.equals("va_cpn_imp")) {
                    c = 2;
                    break;
                }
                break;
            case -1080320404:
                if (str.equals("impl_track")) {
                    c = 0;
                    break;
                }
                break;
            case -824217204:
                if (str.equals("va_cli")) {
                    c = 4;
                    break;
                }
                break;
            case 219543569:
                if (str.equals("va_show")) {
                    c = 1;
                    break;
                }
                break;
            case 1686229972:
                if (str.equals("click_track")) {
                    c = 3;
                    break;
                }
                break;
        }
        if (c == 0 || c == 1 || c == 2) {
            sg.bigo.ads.core.d.a.a((Map<String, String>) hashMap);
        } else if (c == 3 || c == 4 || c == 5) {
            sg.bigo.ads.core.d.a.b((Map<String, String>) hashMap);
        } else {
            sg.bigo.ads.common.k.a.a(0, 3, "TrackerRequestHelper", "reportTrack dont report action =".concat(String.valueOf(str)));
        }
    }
}
