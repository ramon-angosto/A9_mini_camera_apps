package com.xiaomi.smack.util;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.xiaomi.push.service.ae;
import com.xiaomi.push.service.y;
import com.xiaomi.smack.k;
import com.xiaomi.smack.p;
import com.xiaomi.smack.packet.a;
import com.xiaomi.smack.packet.b;
import com.xiaomi.smack.packet.d;
import com.xiaomi.smack.packet.f;
import com.xiaomi.smack.packet.g;
import com.xiaomi.smack.packet.h;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import object.p2pipcam.utils.DataBaseHelper;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class c {
    private static XmlPullParser a;

    public static a a(String str, String str2, XmlPullParser xmlPullParser) {
        Object a2 = com.xiaomi.smack.provider.c.a().a("all", "xm:chat");
        if (a2 == null || !(a2 instanceof com.xiaomi.push.service.c)) {
            return null;
        }
        return ((com.xiaomi.push.service.c) a2).b(xmlPullParser);
    }

    public static b a(XmlPullParser xmlPullParser, com.xiaomi.smack.a aVar) {
        String attributeValue = xmlPullParser.getAttributeValue("", DataBaseHelper.KEY_ID);
        String attributeValue2 = xmlPullParser.getAttributeValue("", "to");
        String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        b.a a2 = b.a.a(xmlPullParser.getAttributeValue("", DataBaseHelper.KEY_TYPE));
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            hashMap.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        b bVar = null;
        h hVar = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("error")) {
                    hVar = e(xmlPullParser);
                } else {
                    bVar = new b();
                    bVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z = true;
            }
        }
        if (bVar == null) {
            if (b.a.a == a2 || b.a.b == a2) {
                d dVar = new d();
                dVar.k(attributeValue);
                dVar.m(attributeValue3);
                dVar.n(attributeValue2);
                dVar.a(b.a.d);
                dVar.l(attributeValue4);
                dVar.a(new h(h.a.e));
                aVar.a((d) dVar);
                com.xiaomi.channel.commonutils.logger.b.d("iq usage error. send packet in packet parser.");
                return null;
            }
            bVar = new e();
        }
        bVar.k(attributeValue);
        bVar.m(attributeValue2);
        bVar.l(attributeValue4);
        bVar.n(attributeValue3);
        bVar.a(a2);
        bVar.a(hVar);
        bVar.a((Map<String, String>) hashMap);
        return bVar;
    }

    public static d a(XmlPullParser xmlPullParser) {
        String str;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        boolean z = false;
        String str2 = null;
        if ("1".equals(xmlPullParser2.getAttributeValue("", NotifyType.SOUND))) {
            String attributeValue = xmlPullParser2.getAttributeValue("", "chid");
            String attributeValue2 = xmlPullParser2.getAttributeValue("", DataBaseHelper.KEY_ID);
            String attributeValue3 = xmlPullParser2.getAttributeValue("", "from");
            String attributeValue4 = xmlPullParser2.getAttributeValue("", "to");
            String attributeValue5 = xmlPullParser2.getAttributeValue("", DataBaseHelper.KEY_TYPE);
            y.b b = y.a().b(attributeValue, attributeValue4);
            if (b == null) {
                b = y.a().b(attributeValue, attributeValue3);
            }
            if (b != null) {
                d dVar = null;
                while (!z) {
                    int next = xmlPullParser.next();
                    if (next == 2) {
                        if (!NotifyType.SOUND.equals(xmlPullParser.getName())) {
                            throw new p("error while receiving a encrypted message with wrong format");
                        } else if (xmlPullParser.next() == 4) {
                            String text = xmlPullParser.getText();
                            if ("5".equals(attributeValue) || "6".equals(attributeValue)) {
                                com.xiaomi.smack.packet.c cVar = new com.xiaomi.smack.packet.c();
                                cVar.l(attributeValue);
                                cVar.b(true);
                                cVar.n(attributeValue3);
                                cVar.m(attributeValue4);
                                cVar.k(attributeValue2);
                                cVar.f(attributeValue5);
                                String[] strArr = null;
                                a aVar = new a(NotifyType.SOUND, (String) null, strArr, strArr);
                                aVar.b(text);
                                cVar.a(aVar);
                                return cVar;
                            }
                            a(ae.b(ae.a(b.i, attributeValue2), text));
                            a.next();
                            dVar = a(a);
                        } else {
                            throw new p("error while receiving a encrypted message with wrong format");
                        }
                    } else if (next == 3 && xmlPullParser.getName().equals("message")) {
                        z = true;
                    }
                }
                if (dVar != null) {
                    return dVar;
                }
                throw new p("error while receiving a encrypted message with wrong format");
            }
            throw new p("the channel id is wrong while receiving a encrypted message");
        }
        com.xiaomi.smack.packet.c cVar2 = new com.xiaomi.smack.packet.c();
        String attributeValue6 = xmlPullParser2.getAttributeValue("", DataBaseHelper.KEY_ID);
        if (attributeValue6 == null) {
            attributeValue6 = "ID_NOT_AVAILABLE";
        }
        cVar2.k(attributeValue6);
        cVar2.m(xmlPullParser2.getAttributeValue("", "to"));
        cVar2.n(xmlPullParser2.getAttributeValue("", "from"));
        cVar2.l(xmlPullParser2.getAttributeValue("", "chid"));
        cVar2.a(xmlPullParser2.getAttributeValue("", "appid"));
        try {
            str = xmlPullParser2.getAttributeValue("", "transient");
        } catch (Exception unused) {
            str = null;
        }
        try {
            String attributeValue7 = xmlPullParser2.getAttributeValue("", "seq");
            if (!TextUtils.isEmpty(attributeValue7)) {
                cVar2.b(attributeValue7);
            }
        } catch (Exception unused2) {
        }
        try {
            String attributeValue8 = xmlPullParser2.getAttributeValue("", "mseq");
            if (!TextUtils.isEmpty(attributeValue8)) {
                cVar2.c(attributeValue8);
            }
        } catch (Exception unused3) {
        }
        try {
            String attributeValue9 = xmlPullParser2.getAttributeValue("", "fseq");
            if (!TextUtils.isEmpty(attributeValue9)) {
                cVar2.d(attributeValue9);
            }
        } catch (Exception unused4) {
        }
        try {
            String attributeValue10 = xmlPullParser2.getAttributeValue("", "status");
            if (!TextUtils.isEmpty(attributeValue10)) {
                cVar2.e(attributeValue10);
            }
        } catch (Exception unused5) {
        }
        cVar2.a(!TextUtils.isEmpty(str) && str.equalsIgnoreCase("true"));
        cVar2.f(xmlPullParser2.getAttributeValue("", DataBaseHelper.KEY_TYPE));
        String g = g(xmlPullParser);
        if (g == null || "".equals(g.trim())) {
            d.u();
        } else {
            cVar2.j(g);
        }
        while (!z) {
            int next2 = xmlPullParser.next();
            if (next2 == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (TextUtils.isEmpty(namespace)) {
                    namespace = "xm";
                }
                if (name.equals("subject")) {
                    String g2 = g(xmlPullParser);
                    cVar2.g(f(xmlPullParser));
                } else if (name.equals("body")) {
                    String attributeValue11 = xmlPullParser2.getAttributeValue("", "encode");
                    String f = f(xmlPullParser);
                    if (!TextUtils.isEmpty(attributeValue11)) {
                        cVar2.a(f, attributeValue11);
                    } else {
                        cVar2.h(f);
                    }
                } else if (name.equals("thread")) {
                    if (str2 == null) {
                        str2 = xmlPullParser.nextText();
                    }
                } else if (name.equals("error")) {
                    cVar2.a(e(xmlPullParser));
                } else {
                    cVar2.a(a(name, namespace, xmlPullParser2));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals("message")) {
                z = true;
            }
        }
        cVar2.i(str2);
        return cVar2;
    }

    private static void a(byte[] bArr) {
        if (a == null) {
            try {
                a = XmlPullParserFactory.newInstance().newPullParser();
                a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
        }
        a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
    }

    public static f b(XmlPullParser xmlPullParser) {
        f.b bVar = f.b.available;
        String attributeValue = xmlPullParser.getAttributeValue("", DataBaseHelper.KEY_TYPE);
        if (attributeValue != null && !attributeValue.equals("")) {
            try {
                bVar = f.b.valueOf(attributeValue);
            } catch (IllegalArgumentException unused) {
                PrintStream printStream = System.err;
                printStream.println("Found invalid presence type " + attributeValue);
            }
        }
        f fVar = new f(bVar);
        fVar.m(xmlPullParser.getAttributeValue("", "to"));
        fVar.n(xmlPullParser.getAttributeValue("", "from"));
        fVar.l(xmlPullParser.getAttributeValue("", "chid"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", DataBaseHelper.KEY_ID);
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        fVar.k(attributeValue2);
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("status")) {
                    fVar.a(xmlPullParser.nextText());
                } else if (name.equals("priority")) {
                    try {
                        fVar.a(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException unused2) {
                    } catch (IllegalArgumentException unused3) {
                        fVar.a(0);
                    }
                } else if (name.equals("show")) {
                    String nextText = xmlPullParser.nextText();
                    try {
                        fVar.a(f.a.valueOf(nextText));
                    } catch (IllegalArgumentException unused4) {
                        PrintStream printStream2 = System.err;
                        printStream2.println("Found invalid presence mode " + nextText);
                    }
                } else if (name.equals("error")) {
                    fVar.a(e(xmlPullParser));
                } else {
                    fVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                z = true;
            }
        }
        return fVar;
    }

    public static k.b c(XmlPullParser xmlPullParser) {
        k.b bVar = new k.b();
        String attributeValue = xmlPullParser.getAttributeValue("", DataBaseHelper.KEY_ID);
        String attributeValue2 = xmlPullParser.getAttributeValue("", "to");
        String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        k.b.a a2 = k.b.a.a(xmlPullParser.getAttributeValue("", DataBaseHelper.KEY_TYPE));
        bVar.k(attributeValue);
        bVar.m(attributeValue2);
        bVar.n(attributeValue3);
        bVar.l(attributeValue4);
        bVar.a(a2);
        boolean z = false;
        h hVar = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("error")) {
                    hVar = e(xmlPullParser);
                }
            } else if (next == 3 && xmlPullParser.getName().equals("bind")) {
                z = true;
            }
        }
        bVar.a(hVar);
        return bVar;
    }

    public static g d(XmlPullParser xmlPullParser) {
        g gVar = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                gVar = new g(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals("error")) {
                z = true;
            }
        }
        return gVar;
    }

    public static h e(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        String str = null;
        String str2 = null;
        String str3 = "-1";
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            if (xmlPullParser.getAttributeName(i).equals("code")) {
                str3 = xmlPullParser.getAttributeValue("", "code");
            }
            if (xmlPullParser.getAttributeName(i).equals(DataBaseHelper.KEY_TYPE)) {
                str = xmlPullParser.getAttributeValue("", DataBaseHelper.KEY_TYPE);
            }
            if (xmlPullParser.getAttributeName(i).equals("reason")) {
                str2 = xmlPullParser.getAttributeValue("", "reason");
            }
        }
        String str4 = null;
        String str5 = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("text")) {
                    str5 = xmlPullParser.nextText();
                } else {
                    String name = xmlPullParser.getName();
                    String namespace = xmlPullParser.getNamespace();
                    if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(namespace)) {
                        str4 = name;
                    } else {
                        arrayList.add(a(name, namespace, xmlPullParser));
                    }
                }
            } else if (next == 3) {
                if (xmlPullParser.getName().equals("error")) {
                    z = true;
                }
            } else if (next == 4) {
                str5 = xmlPullParser.getText();
            }
        }
        return new h(Integer.parseInt(str3), str == null ? "cancel" : str, str2, str4, str5, arrayList);
    }

    private static String f(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        String str = "";
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            str = str + xmlPullParser.getText();
        }
    }

    private static String g(XmlPullParser xmlPullParser) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if ("xml:lang".equals(attributeName) || ("lang".equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i)))) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }
}
