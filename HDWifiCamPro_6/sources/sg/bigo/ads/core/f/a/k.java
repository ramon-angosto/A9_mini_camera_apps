package sg.bigo.ads.core.f.a;

import android.os.SystemClock;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.model.AdvertisementDBAdapter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import sg.bigo.ads.common.l.c;
import sg.bigo.ads.common.l.c.d;
import sg.bigo.ads.common.l.g;
import sg.bigo.ads.common.utils.j;
import sg.bigo.ads.common.utils.o;
import sg.bigo.ads.common.utils.p;
import sg.bigo.ads.core.f.a.a;
import sg.bigo.ads.core.f.a.a.b;
import sg.bigo.ads.core.f.a.a.e;
import sg.bigo.ads.core.f.a.a.h;

public final class k {
    private static final String[] f = {MimeTypes.VIDEO_MP4, "video/3gp", MimeTypes.VIDEO_H263};
    public int a;
    public long b;
    public String c;
    public e d;
    public List<n> e;
    private float g;
    private final List<b> h;
    private a i;
    private final int j;
    private String k;
    private final List<sg.bigo.ads.core.c.a> l;

    public interface a {
        String a(q qVar, List<n> list);
    }

    public k(int i2) {
        this.b = 0;
        this.c = "";
        this.g = 0.1f;
        this.h = new ArrayList();
        this.i = new a() {
            public final String a(q qVar, List<n> list) {
                return k.a(k.this, qVar, (List) list);
            }
        };
        this.k = "";
        this.l = new ArrayList();
        this.g = 30.0f;
        this.j = i2;
    }

    static /* synthetic */ String a(k kVar, q qVar, List list) {
        String str;
        kVar.e = list;
        String k2 = qVar.k();
        if (o.b(k2)) {
            sg.bigo.ads.common.k.a.a(1, "VASTParser", "The redirect url from wrapper is invalid.");
            kVar.d = new e(10070, "The redirect url from wrapper is invalid.");
            return null;
        }
        int i2 = kVar.a;
        if (i2 >= 6) {
            sg.bigo.ads.common.k.a.a(1, "VASTParser", "The wrapper redirects too much times.");
            kVar.d = new e(10071, "The wrapper redirects too much times");
            return null;
        }
        kVar.a = i2 + 1;
        kVar.c = k2;
        c<sg.bigo.ads.common.l.c.a> a2 = g.a(new sg.bigo.ads.common.l.b.a(k2));
        if (a2.a != null) {
            return new d((sg.bigo.ads.common.l.c.a) a2.a).a();
        }
        sg.bigo.ads.common.k.a.a(1, "VASTParser", "The wrapper failed to redirect http request.");
        if (a2.b != null) {
            str = "The wrapper failed to redirect http request." + ", code: " + a2.b.a + ", msg: " + a2.b.getMessage();
        } else {
            str = "The wrapper failed to redirect http request." + ", response to string failed";
        }
        kVar.d = new e(10072, str);
        return null;
    }

    private b a(List<i> list) {
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            sg.bigo.ads.common.k.a.a(1, 4, "VASTParser", "Failed to parse vast data: Media file node can not found.");
            this.d = new e(10065, " media file node can not found");
            return null;
        }
        Iterator<i> it = list.iterator();
        StringBuilder sb = null;
        while (it.hasNext()) {
            String a2 = it.next().a();
            if (o.b(a2) || !Arrays.asList(f).contains(a2.toLowerCase())) {
                it.remove();
                if (sb == null) {
                    sb = new StringBuilder(" media file all mimetype unsupport, types are ");
                }
                sb.append(a2);
                sb.append(",");
                sg.bigo.ads.common.k.a.a(1, 4, "VASTParser", "Failed to parse vast data: mime type is unsupported, ignore. mediaType = ".concat(String.valueOf(a2)));
            }
        }
        if (list.isEmpty()) {
            this.d = new e(10066, sb == null ? " media file all mimetype unsupport" : sb.toString());
            return null;
        }
        Iterator<i> it2 = list.iterator();
        while (it2.hasNext()) {
            if (o.b(it2.next().b())) {
                it2.remove();
                sg.bigo.ads.common.k.a.a(1, 4, "VASTParser", "Failed to parse vast data: Video url is empty.");
            }
        }
        if (list.isEmpty()) {
            this.d = new e(10067, " though mimetype support but url is empty");
            return null;
        }
        Iterator<i> it3 = list.iterator();
        while (true) {
            boolean z = false;
            if (!it3.hasNext()) {
                break;
            }
            i next = it3.next();
            String a3 = next.a();
            String b2 = next.b();
            if (!o.b(b2)) {
                int intValue = sg.bigo.ads.core.f.a.d(next.a, "width").intValue();
                int intValue2 = sg.bigo.ads.core.f.a.d(next.a, "height").intValue();
                if (intValue <= 0 || intValue2 <= 0) {
                    it3.remove();
                    sg.bigo.ads.common.k.a.a(1, 4, "VASTParser", "Failed to parse vast data: Video width or height is invalidate, ignore.");
                } else {
                    int intValue3 = sg.bigo.ads.core.f.a.d(next.a, "fileSize").intValue();
                    int intValue4 = sg.bigo.ads.core.f.a.d(next.a, "bitrate").intValue();
                    String e2 = sg.bigo.ads.core.f.a.e(next.a, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_MD5);
                    int i2 = this.j;
                    if (i2 == 0 || (i2 != 1 ? !(i2 != 2 || intValue < intValue2) : intValue <= intValue2)) {
                        z = true;
                    }
                    if (z) {
                        arrayList.add(new b(intValue, intValue2, intValue3, intValue4, b2, a3, e2));
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            sg.bigo.ads.common.k.a.a(1, "VASTParser", "Cannot find the best network media config.");
            this.d = new e(10068, "video width to height ratio is not suitable for its direction");
            return null;
        } else if (arrayList.size() == 1) {
            sg.bigo.ads.common.k.a.a(0, 3, "VASTParser", "find best network media config, bestNetWorkMediaConfigList size  = " + arrayList.size());
            return (b) arrayList.get(0);
        } else {
            b bVar = (b) arrayList.get(0);
            ArrayList<b> arrayList2 = new ArrayList<>(arrayList);
            if (arrayList2.size() > 1) {
                int i3 = Integer.MAX_VALUE;
                for (b bVar2 : arrayList2) {
                    int abs = Math.abs(bVar2.a - sg.bigo.ads.common.utils.d.b(sg.bigo.ads.common.b.a.a));
                    if (abs < i3) {
                        bVar = bVar2;
                        i3 = abs;
                    }
                }
            }
            return bVar;
        }
    }

    private p a(String str, a aVar, List<n> list) {
        e eVar;
        this.e = list;
        m mVar = new m();
        try {
            mVar.a = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(str.replaceFirst("<\\?.*\\?>", ""))));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        List<d> a2 = mVar.a();
        if (a2.isEmpty()) {
            eVar = new e(10062, "not found ad node");
        } else {
            d dVar = a2.get(0);
            Node a3 = sg.bigo.ads.core.f.a.a(dVar.a, "InLine");
            g gVar = a3 != null ? new g(a3) : null;
            if (gVar != null) {
                p a4 = a(gVar, list);
                this.h.addAll(gVar.a);
                if (a4 != null) {
                    return a4;
                }
                if (this.d == null) {
                    this.d = new e(10063, "not match media file found other reason");
                }
                return null;
            }
            Node a5 = sg.bigo.ads.core.f.a.a(dVar.a, "Wrapper");
            q qVar = a5 != null ? new q(a5) : null;
            if (qVar != null) {
                String h2 = qVar.h();
                if (o.c(h2)) {
                    this.k = h2;
                }
                ArrayList arrayList = new ArrayList(list);
                arrayList.addAll(qVar.a());
                String a6 = aVar.a(qVar, arrayList);
                if (a6 == null) {
                    return null;
                }
                List<sg.bigo.ads.core.c.a> j2 = qVar.j();
                if (j2 != null && j2.size() > 0) {
                    this.l.addAll(j2);
                }
                p a7 = a(a6, aVar, (List<n>) arrayList);
                if (a7 == null) {
                    return null;
                }
                a7.a(qVar.b());
                List<h> a8 = qVar.a("CompanionAds");
                this.h.addAll(qVar.a);
                for (h a9 : a8) {
                    a(a9, a7);
                }
                a((g) qVar, a7);
                int i2 = qVar.i();
                if (a7.u == -1) {
                    a7.u = i2;
                }
                if (this.l.size() > 0) {
                    a7.A = this.l;
                }
                return a7;
            }
            eVar = new e(10064, "not found wrapper node");
        }
        this.d = eVar;
        return null;
    }

    private p a(g gVar, List<n> list) {
        List<Node> c2;
        List<h> a2 = gVar.a("CompanionAds");
        String h2 = gVar.h();
        if (o.c(h2)) {
            this.k = h2;
        }
        for (h next : a2) {
            ArrayList arrayList = new ArrayList();
            Node a3 = sg.bigo.ads.core.f.a.a(next.a, "MediaFiles");
            if (!(a3 == null || (c2 = sg.bigo.ads.core.f.a.c(a3, "MediaFile")) == null)) {
                for (Node iVar : c2) {
                    arrayList.add(new i(iVar));
                }
            }
            b a4 = a((List<i>) arrayList);
            if (a4 != null) {
                p pVar = new p();
                pVar.a(gVar.b());
                a(next, pVar);
                pVar.l = next.a();
                long i2 = (long) next.i();
                if (i2 > 0) {
                    pVar.r = i2;
                }
                pVar.m = a4;
                if (pVar.m != null) {
                    int i3 = pVar.m.a;
                    int i4 = pVar.m.b;
                    pVar.w = i3;
                    pVar.v = i4;
                }
                pVar.o = gVar.f();
                pVar.p = gVar.g();
                pVar.q = this.k;
                pVar.u = gVar.i();
                long a5 = p.a();
                if (a5 > 0) {
                    pVar.t = a5;
                }
                pVar.s = ((long) gVar.e()) * 1000;
                list.addAll(gVar.a());
                pVar.j.addAll(list);
                a(gVar, pVar);
                List<sg.bigo.ads.core.c.a> j2 = gVar.j();
                if (j2 != null && j2.size() > 0) {
                    this.l.addAll(j2);
                }
                if (this.l.size() > 0) {
                    pVar.A = this.l;
                }
                return pVar;
            }
        }
        return null;
    }

    private static void a(g gVar, p pVar) {
        pVar.b(gVar.c());
        pVar.c(gVar.d());
    }

    private static void a(h hVar, p pVar) {
        pVar.l(hVar.h());
        pVar.k(hVar.g());
        pVar.d(hVar.a(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE));
        pVar.e(hVar.a("skip"));
        pVar.f(hVar.d());
        pVar.g(hVar.c());
        pVar.h(hVar.f());
        pVar.i(hVar.e());
        pVar.j(hVar.b());
    }

    private void a(p pVar) {
        a.C0139a aVar;
        List<a.C0139a> list;
        List<b> list2 = this.h;
        if (!j.a(list2)) {
            for (b a2 : list2) {
                List<sg.bigo.ads.core.f.a.a.d> a3 = a2.a();
                if (!j.a(a3)) {
                    a aVar2 = new a();
                    for (sg.bigo.ads.core.f.a.a.d next : a3) {
                        if (next != null) {
                            List<sg.bigo.ads.core.f.a.a.g> c2 = next.c();
                            if (!j.a(c2)) {
                                for (sg.bigo.ads.core.f.a.a.g next2 : c2) {
                                    if (next2 instanceof h) {
                                        h hVar = (h) next2;
                                        String a4 = hVar.a();
                                        if (a4 != null && a4.contains("image/")) {
                                            aVar = new a.C0139a(hVar.b(), next.a(), next.b(), a4, next.d());
                                            list = aVar2.b;
                                        }
                                    } else if (next2 instanceof e) {
                                        aVar = new a.C0139a(((e) next2).a(), next.a(), next.b(), (String) null, next.d());
                                        list = aVar2.a;
                                    }
                                    list.add(aVar);
                                }
                                List<sg.bigo.ads.core.f.a.a.c> e2 = next.e();
                                if (!j.a(e2)) {
                                    for (sg.bigo.ads.core.f.a.a.c a5 : e2) {
                                        pVar.y.add(new n(a5.a()));
                                    }
                                }
                                List<String> f2 = next.f();
                                if (!j.a(f2)) {
                                    for (String nVar : f2) {
                                        pVar.x.add(new n(nVar));
                                    }
                                }
                            }
                        }
                    }
                    pVar.z.add(aVar2);
                }
            }
        }
    }

    public final p a(String str) {
        p pVar = null;
        this.d = null;
        this.a = 0;
        if (o.b(str)) {
            this.d = new e(10060, "invalidate delivery params");
            return null;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            pVar = a(str, this.i, (List<n>) new ArrayList());
            if (pVar != null) {
                a(pVar);
            }
            this.b = SystemClock.elapsedRealtime() - elapsedRealtime;
            sg.bigo.ads.common.k.a.a(0, 3, "VASTParser", "end cost = ".concat(String.valueOf(elapsedRealtime)));
        } catch (IOException | ParserConfigurationException | SAXException e2) {
            sg.bigo.ads.common.k.a.a(1, "VASTParser", "Parse vast xml failed: " + e2.getCause());
            this.d = new e(10061, "Parse vast xml failed.");
        }
        return pVar;
    }
}
