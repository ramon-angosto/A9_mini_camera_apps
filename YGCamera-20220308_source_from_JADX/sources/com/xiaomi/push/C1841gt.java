package com.xiaomi.push;

import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1827gj;
import com.xiaomi.push.C1832gn;
import com.xiaomi.push.C1836gp;
import com.xiaomi.push.service.C2003az;
import com.xiaomi.push.service.C2021bi;
import com.xiaomi.push.service.C2059g;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.xiaomi.push.gt */
public class C1841gt {

    /* renamed from: a */
    private static XmlPullParser f2586a;

    /* renamed from: a */
    public static C1826gi m3789a(String str, String str2, XmlPullParser xmlPullParser) {
        Object a = C1840gs.mo17746a().mo17745a("all", "xm:chat");
        if (a == null || !(a instanceof C2059g)) {
            return null;
        }
        return ((C2059g) a).mo18530b(xmlPullParser);
    }

    /* renamed from: a */
    public static C1827gj m3790a(XmlPullParser xmlPullParser, C1809fu fuVar) {
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", RemoteMessageConst.f875TO);
        String attributeValue3 = xmlPullParser.getAttributeValue("", RemoteMessageConst.FROM);
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        C1827gj.C1828a a = C1827gj.C1828a.m3724a(xmlPullParser.getAttributeValue("", "type"));
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            hashMap.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        C1827gj gjVar = null;
        C1836gp gpVar = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("error")) {
                    gpVar = m3791a(xmlPullParser);
                } else {
                    gjVar = new C1827gj();
                    gjVar.mo17724a(m3789a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z = true;
            }
        }
        if (gjVar == null) {
            if (C1827gj.C1828a.f2499a == a || C1827gj.C1828a.f2500b == a) {
                C1842gu guVar = new C1842gu();
                guVar.mo17728k(attributeValue);
                guVar.mo17732m(attributeValue3);
                guVar.mo17734n(attributeValue2);
                guVar.mo17699a(C1827gj.C1828a.f2502d);
                guVar.mo17730l(attributeValue4);
                guVar.mo17725a(new C1836gp(C1836gp.C1837a.f2562e));
                fuVar.mo17642a((C1830gl) guVar);
                C1524b.m2160d("iq usage error. send packet in packet parser.");
                return null;
            }
            gjVar = new C1843gv();
        }
        gjVar.mo17728k(attributeValue);
        gjVar.mo17732m(attributeValue2);
        gjVar.mo17730l(attributeValue4);
        gjVar.mo17734n(attributeValue3);
        gjVar.mo17699a(a);
        gjVar.mo17725a(gpVar);
        gjVar.mo17700a((Map<String, String>) hashMap);
        return gjVar;
    }

    /* renamed from: a */
    public static C1830gl m3791a(XmlPullParser xmlPullParser) {
        String str;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        boolean z = false;
        String str2 = null;
        if ("1".equals(xmlPullParser2.getAttributeValue("", "s"))) {
            String attributeValue = xmlPullParser2.getAttributeValue("", "chid");
            String attributeValue2 = xmlPullParser2.getAttributeValue("", "id");
            String attributeValue3 = xmlPullParser2.getAttributeValue("", RemoteMessageConst.FROM);
            String attributeValue4 = xmlPullParser2.getAttributeValue("", RemoteMessageConst.f875TO);
            String attributeValue5 = xmlPullParser2.getAttributeValue("", "type");
            C2003az.C2005b a = C2003az.mo18481a().mo18482a(attributeValue, attributeValue4);
            if (a == null) {
                a = C2003az.mo18481a().mo18482a(attributeValue, attributeValue3);
            }
            if (a != null) {
                C1830gl glVar = null;
                while (!z) {
                    int next = xmlPullParser.next();
                    if (next == 2) {
                        if (!"s".equals(xmlPullParser.getName())) {
                            throw new C1823gf("error while receiving a encrypted message with wrong format");
                        } else if (xmlPullParser.next() == 4) {
                            String text = xmlPullParser.getText();
                            if ("5".equals(attributeValue) || "6".equals(attributeValue)) {
                                C1829gk gkVar = new C1829gk();
                                gkVar.mo17730l(attributeValue);
                                gkVar.mo17707b(true);
                                gkVar.mo17734n(attributeValue3);
                                gkVar.mo17732m(attributeValue4);
                                gkVar.mo17728k(attributeValue2);
                                gkVar.mo17716f(attributeValue5);
                                String[] strArr = null;
                                C1826gi giVar = new C1826gi("s", (String) null, strArr, strArr);
                                giVar.mo17692a(text);
                                gkVar.mo17724a(giVar);
                                return gkVar;
                            }
                            m3796a(C2021bi.m5134a(C2021bi.m5133a(a.f3749h, attributeValue2), text));
                            f2586a.next();
                            glVar = m3791a(f2586a);
                        } else {
                            throw new C1823gf("error while receiving a encrypted message with wrong format");
                        }
                    } else if (next == 3 && xmlPullParser.getName().equals(CrashHianalyticsData.MESSAGE)) {
                        z = true;
                    }
                }
                if (glVar != null) {
                    return glVar;
                }
                throw new C1823gf("error while receiving a encrypted message with wrong format");
            }
            throw new C1823gf("the channel id is wrong while receiving a encrypted message");
        }
        C1829gk gkVar2 = new C1829gk();
        String attributeValue6 = xmlPullParser2.getAttributeValue("", "id");
        if (attributeValue6 == null) {
            attributeValue6 = "ID_NOT_AVAILABLE";
        }
        gkVar2.mo17728k(attributeValue6);
        gkVar2.mo17732m(xmlPullParser2.getAttributeValue("", RemoteMessageConst.f875TO));
        gkVar2.mo17734n(xmlPullParser2.getAttributeValue("", RemoteMessageConst.FROM));
        gkVar2.mo17730l(xmlPullParser2.getAttributeValue("", "chid"));
        gkVar2.mo17703a(xmlPullParser2.getAttributeValue("", HiAnalyticsConstant.HaKey.BI_KEY_APPID));
        try {
            str = xmlPullParser2.getAttributeValue("", "transient");
        } catch (Exception unused) {
            str = null;
        }
        try {
            String attributeValue7 = xmlPullParser2.getAttributeValue("", "seq");
            if (!TextUtils.isEmpty(attributeValue7)) {
                gkVar2.mo17706b(attributeValue7);
            }
        } catch (Exception unused2) {
        }
        try {
            String attributeValue8 = xmlPullParser2.getAttributeValue("", "mseq");
            if (!TextUtils.isEmpty(attributeValue8)) {
                gkVar2.mo17709c(attributeValue8);
            }
        } catch (Exception unused3) {
        }
        try {
            String attributeValue9 = xmlPullParser2.getAttributeValue("", "fseq");
            if (!TextUtils.isEmpty(attributeValue9)) {
                gkVar2.mo17711d(attributeValue9);
            }
        } catch (Exception unused4) {
        }
        try {
            String attributeValue10 = xmlPullParser2.getAttributeValue("", "status");
            if (!TextUtils.isEmpty(attributeValue10)) {
                gkVar2.mo17713e(attributeValue10);
            }
        } catch (Exception unused5) {
        }
        gkVar2.mo17705a(!TextUtils.isEmpty(str) && str.equalsIgnoreCase("true"));
        gkVar2.mo17716f(xmlPullParser2.getAttributeValue("", "type"));
        String b = m3797b(xmlPullParser);
        if (b == null || "".equals(b.trim())) {
            C1830gl.m3748q();
        } else {
            gkVar2.mo17723j(b);
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
                    String b2 = m3797b(xmlPullParser);
                    gkVar2.mo17718g(m3791a(xmlPullParser));
                } else if (name.equals("body")) {
                    String attributeValue11 = xmlPullParser2.getAttributeValue("", "encode");
                    String a2 = m3791a(xmlPullParser);
                    if (!TextUtils.isEmpty(attributeValue11)) {
                        gkVar2.mo17704a(a2, attributeValue11);
                    } else {
                        gkVar2.mo17720h(a2);
                    }
                } else if (name.equals("thread")) {
                    if (str2 == null) {
                        str2 = xmlPullParser.nextText();
                    }
                } else if (name.equals("error")) {
                    gkVar2.mo17725a(m3791a(xmlPullParser));
                } else {
                    gkVar2.mo17724a(m3789a(name, namespace, xmlPullParser2));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals(CrashHianalyticsData.MESSAGE)) {
                z = true;
            }
        }
        gkVar2.mo17722i(str2);
        return gkVar2;
    }

    /* renamed from: a */
    public static C1832gn m3792a(XmlPullParser xmlPullParser) {
        C1832gn.C1834b bVar = C1832gn.C1834b.available;
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        if (attributeValue != null && !attributeValue.equals("")) {
            try {
                bVar = C1832gn.C1834b.valueOf(attributeValue);
            } catch (IllegalArgumentException unused) {
                PrintStream printStream = System.err;
                printStream.println("Found invalid presence type " + attributeValue);
            }
        }
        C1832gn gnVar = new C1832gn(bVar);
        gnVar.mo17732m(xmlPullParser.getAttributeValue("", RemoteMessageConst.f875TO));
        gnVar.mo17734n(xmlPullParser.getAttributeValue("", RemoteMessageConst.FROM));
        gnVar.mo17730l(xmlPullParser.getAttributeValue("", "chid"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        gnVar.mo17728k(attributeValue2);
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("status")) {
                    gnVar.mo17703a(xmlPullParser.nextText());
                } else if (name.equals(RemoteMessageConst.Notification.PRIORITY)) {
                    try {
                        gnVar.mo17738a(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException unused2) {
                    } catch (IllegalArgumentException unused3) {
                        gnVar.mo17738a(0);
                    }
                } else if (name.equals("show")) {
                    String nextText = xmlPullParser.nextText();
                    try {
                        gnVar.mo17739a(C1832gn.C1833a.valueOf(nextText));
                    } catch (IllegalArgumentException unused4) {
                        PrintStream printStream2 = System.err;
                        printStream2.println("Found invalid presence mode " + nextText);
                    }
                } else if (name.equals("error")) {
                    gnVar.mo17725a(m3791a(xmlPullParser));
                } else {
                    gnVar.mo17724a(m3789a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                z = true;
            }
        }
        return gnVar;
    }

    /* renamed from: a */
    public static C1835go m3793a(XmlPullParser xmlPullParser) {
        C1835go goVar = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                goVar = new C1835go(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals("error")) {
                z = true;
            }
        }
        return goVar;
    }

    /* renamed from: a */
    public static C1836gp m3794a(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        String str = null;
        String str2 = null;
        String str3 = "-1";
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            if (xmlPullParser.getAttributeName(i).equals("code")) {
                str3 = xmlPullParser.getAttributeValue("", "code");
            }
            if (xmlPullParser.getAttributeName(i).equals("type")) {
                str = xmlPullParser.getAttributeValue("", "type");
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
                        arrayList.add(m3789a(name, namespace, xmlPullParser));
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
        return new C1836gp(Integer.parseInt(str3), str == null ? "cancel" : str, str2, str4, str5, arrayList);
    }

    /* renamed from: a */
    private static String m3795a(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        String str = "";
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            str = str + xmlPullParser.getText();
        }
    }

    /* renamed from: a */
    private static void m3796a(byte[] bArr) {
        if (f2586a == null) {
            try {
                f2586a = XmlPullParserFactory.newInstance().newPullParser();
                f2586a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
        }
        f2586a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
    }

    /* renamed from: b */
    private static String m3797b(XmlPullParser xmlPullParser) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if ("xml:lang".equals(attributeName) || ("lang".equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i)))) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }
}
