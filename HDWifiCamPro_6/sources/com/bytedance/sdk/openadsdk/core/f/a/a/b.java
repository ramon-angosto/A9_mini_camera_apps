package com.bytedance.sdk.openadsdk.core.f.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.f.a;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: InLineParser */
public class b {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0094, code lost:
        if (r11.getEventType() != 3) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009e, code lost:
        if ("Extensions".equals(r11.getName()) != false) goto L_0x000d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a0, code lost:
        r11.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a7, code lost:
        if (r11.getEventType() == 2) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b2, code lost:
        if ("AdVerifications".equals(r11.getName()) == false) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b4, code lost:
        r0.a(com.bytedance.sdk.openadsdk.core.f.a.a.d.a(r11));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.bytedance.sdk.openadsdk.core.f.a a(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11, java.util.List<com.bytedance.sdk.openadsdk.core.f.b.c> r12, int r13, double r14) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.f.a.a.e.g
            java.lang.String r1 = "InLine"
            r2 = 2
            r11.require(r2, r0, r1)
            com.bytedance.sdk.openadsdk.core.f.a r0 = new com.bytedance.sdk.openadsdk.core.f.a
            r0.<init>()
        L_0x000d:
            int r3 = r11.next()
            r9 = 3
            if (r3 != r9) goto L_0x0027
            java.lang.String r3 = r11.getName()
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x001f
            goto L_0x0027
        L_0x001f:
            com.bytedance.sdk.openadsdk.core.f.d r10 = r0.a()
            r10.j(r12)
            return r0
        L_0x0027:
            int r3 = r11.getEventType()
            if (r3 == r2) goto L_0x002e
            goto L_0x000d
        L_0x002e:
            java.lang.String r3 = r11.getName()
            r4 = -1
            int r5 = r3.hashCode()
            java.lang.String r6 = "Extensions"
            java.lang.String r7 = "AdVerifications"
            switch(r5) {
                case -2077435339: goto L_0x0079;
                case -1692490108: goto L_0x006f;
                case -56677412: goto L_0x0065;
                case 67232232: goto L_0x005b;
                case 184043572: goto L_0x0053;
                case 501930965: goto L_0x0049;
                case 2114088489: goto L_0x003f;
                default: goto L_0x003e;
            }
        L_0x003e:
            goto L_0x0080
        L_0x003f:
            java.lang.String r5 = "Impression"
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x0080
            r4 = r9
            goto L_0x0080
        L_0x0049:
            java.lang.String r5 = "AdTitle"
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x0080
            r4 = 0
            goto L_0x0080
        L_0x0053:
            boolean r5 = r3.equals(r6)
            if (r5 == 0) goto L_0x0080
            r4 = 5
            goto L_0x0080
        L_0x005b:
            java.lang.String r5 = "Error"
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x0080
            r4 = r2
            goto L_0x0080
        L_0x0065:
            java.lang.String r5 = "Description"
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x0080
            r4 = 1
            goto L_0x0080
        L_0x006f:
            java.lang.String r5 = "Creatives"
            boolean r5 = r3.equals(r5)
            if (r5 == 0) goto L_0x0080
            r4 = 4
            goto L_0x0080
        L_0x0079:
            boolean r5 = r3.equals(r7)
            if (r5 == 0) goto L_0x0080
            r4 = 6
        L_0x0080:
            switch(r4) {
                case 0: goto L_0x0116;
                case 1: goto L_0x010d;
                case 2: goto L_0x0104;
                case 3: goto L_0x00f7;
                case 4: goto L_0x00bc;
                case 5: goto L_0x0090;
                case 6: goto L_0x0087;
                default: goto L_0x0083;
            }
        L_0x0083:
            com.bytedance.sdk.openadsdk.core.f.a.a.e.a((org.xmlpull.v1.XmlPullParser) r11)
            goto L_0x000d
        L_0x0087:
            java.util.Set r3 = com.bytedance.sdk.openadsdk.core.f.a.a.d.a(r11)
            r0.a((java.util.Set<com.bytedance.sdk.openadsdk.core.f.j>) r3)
            goto L_0x000d
        L_0x0090:
            int r3 = r11.getEventType()
            if (r3 != r9) goto L_0x00a0
            java.lang.String r3 = r11.getName()
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L_0x000d
        L_0x00a0:
            r11.next()
            int r3 = r11.getEventType()
            if (r3 == r2) goto L_0x00aa
            goto L_0x0090
        L_0x00aa:
            java.lang.String r3 = r11.getName()
            boolean r3 = r7.equals(r3)
            if (r3 == 0) goto L_0x0090
            java.util.Set r3 = com.bytedance.sdk.openadsdk.core.f.a.a.d.a(r11)
            r0.a((java.util.Set<com.bytedance.sdk.openadsdk.core.f.j>) r3)
            goto L_0x0090
        L_0x00bc:
            java.lang.String r3 = r0.g()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x00d1
            com.bytedance.sdk.openadsdk.core.f.c r3 = r0.c()
            if (r3 == 0) goto L_0x00d1
            com.bytedance.sdk.openadsdk.core.f.a.a.e.a((org.xmlpull.v1.XmlPullParser) r11)
            goto L_0x000d
        L_0x00d1:
            int r3 = r11.next()
            if (r3 == r9) goto L_0x000d
            int r3 = r11.getEventType()
            if (r3 == r2) goto L_0x00de
            goto L_0x00d1
        L_0x00de:
            java.lang.String r3 = r11.getName()
            java.lang.String r4 = "Creative"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00f3
            r3 = r10
            r4 = r11
            r5 = r0
            r6 = r13
            r7 = r14
            a((android.content.Context) r3, (org.xmlpull.v1.XmlPullParser) r4, (com.bytedance.sdk.openadsdk.core.f.a) r5, (int) r6, (double) r7)
            goto L_0x00d1
        L_0x00f3:
            com.bytedance.sdk.openadsdk.core.f.a.a.e.a((org.xmlpull.v1.XmlPullParser) r11)
            goto L_0x00d1
        L_0x00f7:
            com.bytedance.sdk.openadsdk.core.f.d r4 = r0.a()
            java.util.List r3 = com.bytedance.sdk.openadsdk.core.f.a.a.e.a((org.xmlpull.v1.XmlPullParser) r11, (java.lang.String) r3)
            r4.a((java.util.List<com.bytedance.sdk.openadsdk.core.f.b.c>) r3)
            goto L_0x000d
        L_0x0104:
            java.util.List r3 = com.bytedance.sdk.openadsdk.core.f.a.a.e.a((org.xmlpull.v1.XmlPullParser) r11, (java.lang.String) r3)
            r12.addAll(r3)
            goto L_0x000d
        L_0x010d:
            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.f.a.a.e.b((org.xmlpull.v1.XmlPullParser) r11, (java.lang.String) r3)
            r0.b((java.lang.String) r3)
            goto L_0x000d
        L_0x0116:
            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.f.a.a.e.b((org.xmlpull.v1.XmlPullParser) r11, (java.lang.String) r3)
            r0.a((java.lang.String) r3)
            goto L_0x000d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.f.a.a.b.a(android.content.Context, org.xmlpull.v1.XmlPullParser, java.util.List, int, double):com.bytedance.sdk.openadsdk.core.f.a");
    }

    public static void a(Context context, XmlPullParser xmlPullParser, a aVar, int i, double d) throws IOException, XmlPullParserException {
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if ("Linear".equals(xmlPullParser.getName()) && TextUtils.isEmpty(aVar.g())) {
                    c.a(xmlPullParser, aVar, i, d);
                } else if (!"CompanionAds".equals(xmlPullParser.getName()) || aVar.c() != null) {
                    e.a(xmlPullParser);
                } else {
                    aVar.a(a.a(context, xmlPullParser));
                }
            }
        }
    }
}
