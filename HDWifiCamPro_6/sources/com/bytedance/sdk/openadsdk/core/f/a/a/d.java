package com.bytedance.sdk.openadsdk.core.f.a.a;

/* compiled from: VastAdVerificationsParser */
public class d {
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Set<com.bytedance.sdk.openadsdk.core.f.j> a(org.xmlpull.v1.XmlPullParser r16) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r0 = r16
            if (r0 != 0) goto L_0x000a
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            return r0
        L_0x000a:
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
        L_0x000f:
            int r2 = r16.next()
            r3 = 3
            if (r2 == r3) goto L_0x00d8
            int r2 = r16.getEventType()
            r4 = 2
            if (r2 == r4) goto L_0x001e
            goto L_0x000f
        L_0x001e:
            java.lang.String r2 = r16.getName()
            java.lang.String r5 = "Verification"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x00d3
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.f.a.a.e.g
            java.lang.String r6 = "vendor"
            java.lang.String r2 = r0.getAttributeValue(r2, r6)
            r6 = 0
            r7 = r6
            r8 = r7
        L_0x0035:
            int r9 = r16.getEventType()
            java.lang.String r10 = "omid"
            if (r9 != r3) goto L_0x0058
            java.lang.String r9 = r16.getName()
            boolean r9 = r5.equals(r9)
            if (r9 != 0) goto L_0x0048
            goto L_0x0058
        L_0x0048:
            boolean r3 = android.text.TextUtils.isEmpty(r6)
            if (r3 != 0) goto L_0x000f
            com.bytedance.sdk.openadsdk.core.f.j r2 = com.bytedance.sdk.openadsdk.core.f.j.a(r10, r6, r2, r7, r8)
            if (r2 == 0) goto L_0x000f
            r1.add(r2)
            goto L_0x000f
        L_0x0058:
            r16.next()
            int r9 = r16.getEventType()
            if (r9 == r4) goto L_0x0062
            goto L_0x0035
        L_0x0062:
            java.lang.String r9 = r16.getName()
            int r12 = r9.hashCode()
            r13 = 1335132887(0x4f9482d7, float:4.9832054E9)
            java.lang.String r14 = "VerificationParameters"
            java.lang.String r15 = "JavaScriptResource"
            java.lang.String r3 = "Tracking"
            r11 = 1
            if (r12 == r13) goto L_0x0091
            r13 = 1561251035(0x5d0eccdb, float:6.43115E17)
            if (r12 == r13) goto L_0x0089
            r13 = 1749252741(0x68437a85, float:3.6924862E24)
            if (r12 == r13) goto L_0x0081
            goto L_0x0099
        L_0x0081:
            boolean r9 = r9.equals(r14)
            if (r9 == 0) goto L_0x0099
            r9 = r4
            goto L_0x009a
        L_0x0089:
            boolean r9 = r9.equals(r15)
            if (r9 == 0) goto L_0x0099
            r9 = 0
            goto L_0x009a
        L_0x0091:
            boolean r9 = r9.equals(r3)
            if (r9 == 0) goto L_0x0099
            r9 = r11
            goto L_0x009a
        L_0x0099:
            r9 = -1
        L_0x009a:
            if (r9 == 0) goto L_0x00bd
            if (r9 == r11) goto L_0x00a7
            if (r9 == r4) goto L_0x00a1
            goto L_0x00d0
        L_0x00a1:
            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.f.a.a.e.b((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r14)
            r7 = r3
            goto L_0x00d0
        L_0x00a7:
            java.lang.String r9 = com.bytedance.sdk.openadsdk.core.f.a.a.e.g
            java.lang.String r10 = "event"
            java.lang.String r9 = r0.getAttributeValue(r9, r10)
            java.lang.String r10 = "verificationNotExecuted"
            boolean r9 = r10.equals(r9)
            if (r9 == 0) goto L_0x00d0
            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.f.a.a.e.b((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r3)
            r8 = r3
            goto L_0x00d0
        L_0x00bd:
            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.f.a.a.e.g
            java.lang.String r9 = "apiFramework"
            java.lang.String r3 = r0.getAttributeValue(r3, r9)
            boolean r3 = r10.equals(r3)
            if (r3 == 0) goto L_0x00d0
            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.f.a.a.e.b((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r15)
            r6 = r3
        L_0x00d0:
            r3 = 3
            goto L_0x0035
        L_0x00d3:
            com.bytedance.sdk.openadsdk.core.f.a.a.e.a((org.xmlpull.v1.XmlPullParser) r16)
            goto L_0x000f
        L_0x00d8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.f.a.a.d.a(org.xmlpull.v1.XmlPullParser):java.util.Set");
    }
}
