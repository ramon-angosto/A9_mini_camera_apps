package com.xiaomi.push.service;

import com.xiaomi.push.C1826gi;
import com.xiaomi.push.C1839gr;
import com.xiaomi.push.C1840gs;
import com.xiaomi.push.C1844gw;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.xiaomi.push.service.g */
public class C2059g implements C1839gr {
    /* renamed from: a */
    public static C1826gi m5226a(XmlPullParser xmlPullParser) {
        ArrayList arrayList;
        String str;
        String[] strArr;
        String[] strArr2;
        if (xmlPullParser.getEventType() != 2) {
            return null;
        }
        String name = xmlPullParser.getName();
        String namespace = xmlPullParser.getNamespace();
        if (xmlPullParser.getAttributeCount() > 0) {
            String[] strArr3 = new String[xmlPullParser.getAttributeCount()];
            String[] strArr4 = new String[xmlPullParser.getAttributeCount()];
            for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                strArr3[i] = xmlPullParser.getAttributeName(i);
                strArr4[i] = C1844gw.m3804b(xmlPullParser.getAttributeValue(i));
            }
            strArr2 = strArr3;
            str = null;
            arrayList = null;
            strArr = strArr4;
        } else {
            strArr2 = null;
            strArr = null;
            str = null;
            arrayList = null;
        }
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3) {
                return new C1826gi(name, namespace, strArr2, strArr, str, arrayList);
            }
            if (next == 4) {
                str = xmlPullParser.getText().trim();
            } else if (next == 2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                C1826gi a = m5226a(xmlPullParser);
                if (a != null) {
                    arrayList.add(a);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo18529a() {
        C1840gs.mo17746a().mo17747a("all", "xm:chat", this);
    }

    /* renamed from: b */
    public C1826gi mo18530b(XmlPullParser xmlPullParser) {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1 && eventType != 2) {
            eventType = xmlPullParser.next();
        }
        if (eventType == 2) {
            return m5226a(xmlPullParser);
        }
        return null;
    }
}
