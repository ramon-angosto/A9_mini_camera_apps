package sg.bigo.ads.core.f;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sg.bigo.ads.common.utils.o;

public final class a {
    public static String a(Node node) {
        String nodeValue;
        if (node != null && node.hasChildNodes()) {
            NodeList childNodes = node.getChildNodes();
            int min = Math.min(childNodes.getLength(), 5);
            if (min > 0) {
                int i = 0;
                while (true) {
                    if (i >= min) {
                        break;
                    }
                    Node item = childNodes.item(i);
                    if ((item instanceof CDATASection) && item.getNodeValue() != null) {
                        nodeValue = item.getNodeValue();
                        break;
                    }
                    i++;
                }
            }
        }
        if (node == null || node.getFirstChild() == null || node.getFirstChild().getNodeValue() == null) {
            return null;
        }
        nodeValue = node.getFirstChild().getNodeValue();
        return nodeValue.trim();
    }

    public static Node a(Node node, String str) {
        return a(node, str, (String) null, (List<String>) null);
    }

    public static Node a(Node node, String str, String str2, List<String> list) {
        List<Node> b;
        if (node == null || str == null || (b = b(node, str, str2, list)) == null || b.isEmpty()) {
            return null;
        }
        return b.get(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        r1 = r1.getNamedItem(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(org.w3c.dom.Node r1, java.lang.String r2, java.util.List<java.lang.String> r3) {
        /*
            r0 = 1
            if (r2 == 0) goto L_0x001f
            if (r3 != 0) goto L_0x0006
            goto L_0x001f
        L_0x0006:
            org.w3c.dom.NamedNodeMap r1 = r1.getAttributes()
            if (r1 == 0) goto L_0x001d
            org.w3c.dom.Node r1 = r1.getNamedItem(r2)
            if (r1 == 0) goto L_0x001d
            java.lang.String r1 = r1.getNodeValue()
            boolean r1 = r3.contains(r1)
            if (r1 == 0) goto L_0x001d
            return r0
        L_0x001d:
            r1 = 0
            return r1
        L_0x001f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.f.a.a(org.w3c.dom.Node, java.lang.String, java.util.List):boolean");
    }

    public static String b(Node node) {
        if (node != null && node.hasChildNodes()) {
            NodeList childNodes = node.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node item = childNodes.item(i);
                if (item != null && !o.d(item.getNodeValue())) {
                    return item.getNodeValue();
                }
            }
        }
        return null;
    }

    public static String b(Node node, String str) {
        Node a = a(node, str, (String) null, (List<String>) null);
        if (a == null) {
            return null;
        }
        String b = b(a);
        if (o.b(b)) {
            return null;
        }
        return b;
    }

    public static List<Node> b(Node node, String str, String str2, List<String> list) {
        if (node == null || str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeName().equals(str) && a(item, str2, list)) {
                arrayList.add(item);
            }
        }
        return arrayList;
    }

    public static List<Node> c(Node node, String str) {
        return b(node, str, (String) null, (List<String>) null);
    }

    public static Integer d(Node node, String str) {
        if (node == null) {
            return -1;
        }
        String e = e(node, str);
        if (o.b(e)) {
            return -1;
        }
        try {
            return Integer.valueOf(Integer.parseInt(e));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static String e(Node node, String str) {
        Node namedItem;
        if (node == null || str == null || (namedItem = node.getAttributes().getNamedItem(str)) == null) {
            return null;
        }
        return namedItem.getNodeValue();
    }
}
