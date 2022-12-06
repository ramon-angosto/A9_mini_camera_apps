package com.xiaomi.push;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.xiaomi.push.fo */
public class C1802fo {

    /* renamed from: a */
    private XmlPullParser f2413a;

    C1802fo() {
        try {
            this.f2413a = XmlPullParserFactory.newInstance().newPullParser();
            this.f2413a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1830gl mo17638a(byte[] bArr, C1809fu fuVar) {
        this.f2413a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.f2413a.next();
        int eventType = this.f2413a.getEventType();
        String name = this.f2413a.getName();
        if (eventType != 2) {
            return null;
        }
        if (name.equals(CrashHianalyticsData.MESSAGE)) {
            return C1841gt.m3791a(this.f2413a);
        }
        if (name.equals("iq")) {
            return C1841gt.m3790a(this.f2413a, fuVar);
        }
        if (name.equals("presence")) {
            return C1841gt.m3791a(this.f2413a);
        }
        if (this.f2413a.getName().equals("stream")) {
            return null;
        }
        if (this.f2413a.getName().equals("error")) {
            throw new C1823gf(C1841gt.m3791a(this.f2413a));
        } else if (this.f2413a.getName().equals("warning")) {
            this.f2413a.next();
            boolean equals = this.f2413a.getName().equals("multi-login");
            return null;
        } else {
            this.f2413a.getName().equals("bind");
            return null;
        }
    }
}
