package sg.bigo.ads.core.f.a;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sg.bigo.ads.common.utils.j;
import sg.bigo.ads.common.utils.o;
import sg.bigo.ads.core.f.a;
import sg.bigo.ads.core.f.a.a.b;

public class g {
    final List<b> a = new ArrayList();
    protected final Node b;

    public g(Node node) {
        this.b = node;
    }

    public final List<n> a() {
        ArrayList arrayList = new ArrayList();
        List<Node> c = a.c(this.b, "Error");
        if (c == null) {
            return arrayList;
        }
        for (Node a2 : c) {
            String a3 = a.a(a2);
            if (!TextUtils.isEmpty(a3)) {
                arrayList.add(new n(a3));
            }
        }
        return arrayList;
    }

    public final List<h> a(String... strArr) {
        List<Node> c;
        ArrayList arrayList = new ArrayList();
        Node a2 = a.a(this.b, "Creatives");
        if (a2 == null || (c = a.c(a2, "Creative")) == null) {
            return arrayList;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("Linear");
        if (!j.a((T[]) strArr)) {
            linkedHashSet.addAll(Arrays.asList(strArr));
        }
        for (Node next : c) {
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Node a3 = a.a(next, str);
                if (a3 != null) {
                    char c2 = 65535;
                    int hashCode = str.hashCode();
                    if (hashCode != -2018804923) {
                        if (hashCode == 1150879268 && str.equals("CompanionAds")) {
                            c2 = 1;
                        }
                    } else if (str.equals("Linear")) {
                        c2 = 0;
                    }
                    if (c2 == 0) {
                        arrayList.add(new h(a3));
                    } else if (c2 == 1) {
                        this.a.add(new sg.bigo.ads.core.f.a.a.a.b(a3));
                    }
                }
            }
        }
        return arrayList;
    }

    public final List<n> b() {
        List<Node> b2 = a.b(this.b, "Impression", (String) null, (List<String>) null);
        ArrayList arrayList = new ArrayList();
        if (b2 == null) {
            return arrayList;
        }
        for (Node a2 : b2) {
            String a3 = a.a(a2);
            if (!TextUtils.isEmpty(a3)) {
                arrayList.add(new n(a3));
            }
        }
        return arrayList;
    }

    public final List<n> c() {
        List<Node> c;
        Node a2 = a.a(this.b, "ViewableImpression", (String) null, (List<String>) null);
        ArrayList arrayList = new ArrayList();
        if (a2 == null || (c = a.c(a2, "Viewable")) == null) {
            return arrayList;
        }
        for (Node a3 : c) {
            String a4 = a.a(a3);
            if (!TextUtils.isEmpty(a4)) {
                arrayList.add(new n(a4));
            }
        }
        return arrayList;
    }

    public final List<n> d() {
        List<Node> c;
        Node a2 = a.a(this.b, "ViewableImpression", (String) null, (List<String>) null);
        ArrayList arrayList = new ArrayList();
        if (a2 == null || (c = a.c(a2, "NotViewable")) == null) {
            return arrayList;
        }
        for (Node a3 : c) {
            String a4 = a.a(a3);
            if (!TextUtils.isEmpty(a4)) {
                arrayList.add(new n(a4));
            }
        }
        return arrayList;
    }

    public final int e() {
        String b2 = a.b(this.b, HttpHeaders.EXPIRES);
        if (o.b(b2)) {
            return 0;
        }
        try {
            return Integer.parseInt(b2);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public final String f() {
        String b2 = a.b(this.b, "AdTitle");
        return b2 == null ? "" : b2;
    }

    public final String g() {
        String b2 = a.b(this.b, "Description");
        return b2 == null ? "" : b2;
    }

    public final String h() {
        String b2 = a.b(this.b, "AdSystem");
        return b2 == null ? "" : b2;
    }

    public final int i() {
        List<Node> b2;
        Node a2 = a.a(this.b, "Extensions", (String) null, (List<String>) null);
        if (!(a2 == null || (b2 = a.b(a2, "Extension", (String) null, (List<String>) null)) == null || b2.isEmpty())) {
            for (Node b3 : b2) {
                String b4 = a.b(b3, "Mute");
                if (o.c(b4)) {
                    return o.a(b4, -1);
                }
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final List<sg.bigo.ads.core.c.a> j() {
        List<Node> c;
        Node namedItem;
        NodeList childNodes;
        String str;
        NodeList childNodes2;
        String nodeValue;
        String nodeValue2;
        ArrayList arrayList = null;
        Node a2 = a.a(this.b, "Extensions", (String) null, (List<String>) null);
        if (a2 == null) {
            return null;
        }
        List<Node> b2 = a.b(a2, "Extension", (String) null, (List<String>) null);
        if (b2 != null && !b2.isEmpty()) {
            arrayList = new ArrayList();
            for (Node a3 : b2) {
                Node a4 = a.a(a3, "AdVerifications");
                if (!(a4 == null || (c = a.c(a4, "Verification")) == null || c.isEmpty())) {
                    for (Node next : c) {
                        NamedNodeMap attributes = next.getAttributes();
                        if (!(attributes == null || (namedItem = attributes.getNamedItem("vendor")) == null)) {
                            sg.bigo.ads.core.c.a aVar = new sg.bigo.ads.core.c.a();
                            aVar.b = namedItem.getNodeValue();
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(CampaignEx.KEY_OMID);
                            Node a5 = a.a(next, "JavaScriptResource", "apiFramework", arrayList2);
                            if (!(a5 == null || (childNodes = a5.getChildNodes()) == null)) {
                                int i = 0;
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= childNodes.getLength()) {
                                        str = "";
                                        break;
                                    }
                                    Node item = childNodes.item(i2);
                                    if (item != null && (nodeValue2 = item.getNodeValue()) != null && nodeValue2.trim().startsWith("http")) {
                                        str = nodeValue2.trim();
                                        break;
                                    }
                                    i2++;
                                }
                                if (!str.isEmpty()) {
                                    aVar.a = str;
                                    Node a6 = a.a(next, "VerificationParameters");
                                    if (a6 != null && (childNodes2 = a6.getChildNodes()) != null) {
                                        while (true) {
                                            if (i < childNodes2.getLength()) {
                                                Node item2 = childNodes2.item(i);
                                                if (item2 != null && (nodeValue = item2.getNodeValue()) != null && nodeValue.trim().length() > 0) {
                                                    aVar.c = nodeValue.trim();
                                                    break;
                                                }
                                                i++;
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    arrayList.add(aVar);
                                }
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }
}
