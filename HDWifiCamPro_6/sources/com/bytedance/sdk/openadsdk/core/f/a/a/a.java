package com.bytedance.sdk.openadsdk.core.f.a.a;

/* compiled from: CompanionAdsParser */
public class a {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.bytedance.sdk.openadsdk.core.f.c a(android.content.Context r25, org.xmlpull.v1.XmlPullParser r26) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
            r0 = r25
            r1 = r26
            r2 = 0
            if (r0 != 0) goto L_0x000b
            com.bytedance.sdk.openadsdk.core.f.a.a.e.a((org.xmlpull.v1.XmlPullParser) r26)
            return r2
        L_0x000b:
            android.content.res.Resources r3 = r25.getResources()
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            int r4 = r3.widthPixels
            int r5 = r3.heightPixels
            float r4 = (float) r4
            float r6 = r3.density
            float r4 = r4 / r6
            int r4 = (int) r4
            float r5 = (float) r5
            float r3 = r3.density
            float r5 = r5 / r3
            int r3 = (int) r5
            r5 = 1
            r12 = r5
            r5 = r2
        L_0x0024:
            int r6 = r26.getEventType()
            r13 = 3
            if (r6 != r13) goto L_0x0039
            java.lang.String r6 = r26.getName()
            java.lang.String r7 = "CompanionAds"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            return r5
        L_0x0039:
            r26.next()
            int r6 = r26.getEventType()
            r14 = 2
            if (r6 == r14) goto L_0x0045
            goto L_0x0258
        L_0x0045:
            java.lang.String r6 = r26.getName()
            java.lang.String r15 = "Companion"
            boolean r6 = r6.equals(r15)
            if (r6 == 0) goto L_0x0258
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.f.a.a.e.g
            java.lang.String r7 = "width"
            java.lang.String r6 = r1.getAttributeValue(r6, r7)
            int r11 = com.bytedance.sdk.openadsdk.core.f.a.a.e.b(r6)
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.f.a.a.e.g
            java.lang.String r7 = "height"
            java.lang.String r6 = r1.getAttributeValue(r6, r7)
            int r10 = com.bytedance.sdk.openadsdk.core.f.a.a.e.b(r6)
            r6 = 300(0x12c, float:4.2E-43)
            if (r11 < r6) goto L_0x0250
            r6 = 250(0xfa, float:3.5E-43)
            if (r10 >= r6) goto L_0x0073
            goto L_0x0250
        L_0x0073:
            com.bytedance.sdk.openadsdk.core.f.a.a.e$a r9 = new com.bytedance.sdk.openadsdk.core.f.a.a.e$a
            r9.<init>()
        L_0x0078:
            int r6 = r26.getEventType()
            if (r6 != r13) goto L_0x00bf
            java.lang.String r6 = r26.getName()
            boolean r6 = r6.equals(r15)
            if (r6 != 0) goto L_0x0089
            goto L_0x00bf
        L_0x0089:
            java.lang.String r6 = r9.a
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0024
            float r6 = r9.g
            int r6 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r6 < 0) goto L_0x0024
            com.bytedance.sdk.openadsdk.core.f.c r5 = new com.bytedance.sdk.openadsdk.core.f.c
            com.bytedance.sdk.openadsdk.core.f.c.a$a r6 = r9.b
            com.bytedance.sdk.openadsdk.core.f.c.a$b r7 = r9.c
            java.lang.String r8 = r9.a
            java.util.List<com.bytedance.sdk.openadsdk.core.f.b.c> r12 = r9.e
            java.util.List<com.bytedance.sdk.openadsdk.core.f.b.c> r13 = r9.f
            java.lang.String r14 = r9.d
            r16 = r5
            r17 = r11
            r18 = r10
            r19 = r6
            r20 = r7
            r21 = r8
            r22 = r12
            r23 = r13
            r24 = r14
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24)
            float r6 = r9.g
            r12 = r6
            goto L_0x0024
        L_0x00bf:
            r26.next()
            int r6 = r26.getEventType()
            if (r6 == r14) goto L_0x00c9
            goto L_0x0078
        L_0x00c9:
            java.lang.String r6 = r26.getName()
            int r8 = r6.hashCode()
            java.lang.String r2 = "HTMLResource"
            java.lang.String r7 = "CompanionClickTracking"
            java.lang.String r13 = "StaticResource"
            java.lang.String r14 = "TrackingEvents"
            r20 = r5
            java.lang.String r5 = "CompanionClickThrough"
            r21 = r15
            java.lang.String r15 = "IFrameResource"
            r22 = r12
            r12 = 1
            switch(r8) {
                case -375340334: goto L_0x0110;
                case -348198615: goto L_0x0108;
                case 611554000: goto L_0x0100;
                case 676623548: goto L_0x00f8;
                case 1877773523: goto L_0x00f0;
                case 1928285401: goto L_0x00e8;
                default: goto L_0x00e7;
            }
        L_0x00e7:
            goto L_0x0118
        L_0x00e8:
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L_0x0118
            r6 = 0
            goto L_0x0119
        L_0x00f0:
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0118
            r6 = 5
            goto L_0x0119
        L_0x00f8:
            boolean r6 = r6.equals(r13)
            if (r6 == 0) goto L_0x0118
            r6 = 2
            goto L_0x0119
        L_0x0100:
            boolean r6 = r6.equals(r14)
            if (r6 == 0) goto L_0x0118
            r6 = 3
            goto L_0x0119
        L_0x0108:
            boolean r6 = r6.equals(r5)
            if (r6 == 0) goto L_0x0118
            r6 = 4
            goto L_0x0119
        L_0x0110:
            boolean r6 = r6.equals(r15)
            if (r6 == 0) goto L_0x0118
            r6 = r12
            goto L_0x0119
        L_0x0118:
            r6 = -1
        L_0x0119:
            if (r6 == 0) goto L_0x0211
            if (r6 == r12) goto L_0x01dd
            r2 = 2
            if (r6 == r2) goto L_0x0170
            r2 = 3
            if (r6 == r2) goto L_0x0143
            r2 = 4
            if (r6 == r2) goto L_0x013c
            r2 = 5
            if (r6 == r2) goto L_0x0134
            com.bytedance.sdk.openadsdk.core.f.a.a.e.a((org.xmlpull.v1.XmlPullParser) r26)
        L_0x012c:
            r5 = r9
            r14 = r10
            r13 = r11
        L_0x012f:
            r12 = r21
        L_0x0131:
            r6 = 3
            goto L_0x0243
        L_0x0134:
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.f.a.a.e.b((org.xmlpull.v1.XmlPullParser) r1, (java.lang.String) r7)
            r9.a(r2)
            goto L_0x012c
        L_0x013c:
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.f.a.a.e.b((org.xmlpull.v1.XmlPullParser) r1, (java.lang.String) r5)
            r9.d = r2
            goto L_0x012c
        L_0x0143:
            int r2 = r26.next()
            r5 = 3
            if (r2 != r5) goto L_0x0154
            java.lang.String r2 = r26.getName()
            boolean r2 = r2.equals(r14)
            if (r2 != 0) goto L_0x012c
        L_0x0154:
            int r2 = r26.getEventType()
            r5 = 2
            if (r2 == r5) goto L_0x015c
            goto L_0x0143
        L_0x015c:
            java.lang.String r2 = r26.getName()
            java.lang.String r6 = "Tracking"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x0143
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.f.a.a.e.b((org.xmlpull.v1.XmlPullParser) r1, (java.lang.String) r6)
            r9.b(r2)
            goto L_0x0143
        L_0x0170:
            r5 = r2
            com.bytedance.sdk.openadsdk.core.f.c.a$a r2 = com.bytedance.sdk.openadsdk.core.f.c.a.C0048a.NONE
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.f.a.a.e.g
            java.lang.String r6 = "creativeType"
            java.lang.String r2 = r1.getAttributeValue(r2, r6)
            java.lang.String r2 = r2.toLowerCase()
            java.util.Set<java.lang.String> r6 = com.bytedance.sdk.openadsdk.core.f.c.a.a
            boolean r6 = r6.contains(r2)
            if (r6 == 0) goto L_0x018a
            com.bytedance.sdk.openadsdk.core.f.c.a$a r6 = com.bytedance.sdk.openadsdk.core.f.c.a.C0048a.IMAGE
            goto L_0x018c
        L_0x018a:
            com.bytedance.sdk.openadsdk.core.f.c.a$a r6 = com.bytedance.sdk.openadsdk.core.f.c.a.C0048a.JAVASCRIPT
        L_0x018c:
            r12 = r6
            com.bytedance.sdk.openadsdk.core.f.c.a$b r6 = com.bytedance.sdk.openadsdk.core.f.c.a.b.STATIC_RESOURCE
            android.graphics.Point r6 = com.bytedance.sdk.openadsdk.core.f.c.a.a(r0, r11, r10, r6)
            int r8 = r6.x
            int r14 = r6.y
            com.bytedance.sdk.openadsdk.core.f.c.a$b r15 = com.bytedance.sdk.openadsdk.core.f.c.a.b.STATIC_RESOURCE
            r6 = r4
            r7 = r3
            r5 = r9
            r9 = r14
            r14 = r10
            r10 = r15
            r15 = r11
            r11 = r12
            float r6 = com.bytedance.sdk.openadsdk.core.f.c.a(r6, r7, r8, r9, r10, r11)
            r5.g = r6
            java.util.Set<java.lang.String> r6 = com.bytedance.sdk.openadsdk.core.f.c.a.a
            boolean r6 = r6.contains(r2)
            if (r6 != 0) goto L_0x01ba
            java.util.Set<java.lang.String> r6 = com.bytedance.sdk.openadsdk.core.f.c.a.b
            boolean r2 = r6.contains(r2)
            if (r2 == 0) goto L_0x01b8
            goto L_0x01ba
        L_0x01b8:
            r2 = 0
            goto L_0x01be
        L_0x01ba:
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.f.a.a.e.b((org.xmlpull.v1.XmlPullParser) r1, (java.lang.String) r13)
        L_0x01be:
            float r6 = r5.g
            int r6 = (r6 > r22 ? 1 : (r6 == r22 ? 0 : -1))
            if (r6 <= 0) goto L_0x01d3
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            if (r6 == 0) goto L_0x01cb
            goto L_0x01d3
        L_0x01cb:
            com.bytedance.sdk.openadsdk.core.f.c.a$b r6 = com.bytedance.sdk.openadsdk.core.f.c.a.b.STATIC_RESOURCE
            r5.a(r2, r12, r6)
            r13 = r15
            goto L_0x012f
        L_0x01d3:
            r12 = r21
            r2 = 3
            com.bytedance.sdk.openadsdk.core.f.a.a.e.a(r1, r12, r2)
            r6 = r2
            r13 = r15
            goto L_0x0243
        L_0x01dd:
            r5 = r9
            r14 = r10
            r13 = r11
            r12 = r21
            com.bytedance.sdk.openadsdk.core.f.c.a$b r2 = com.bytedance.sdk.openadsdk.core.f.c.a.b.HTML_RESOURCE
            android.graphics.Point r2 = com.bytedance.sdk.openadsdk.core.f.c.a.a(r0, r13, r14, r2)
            int r8 = r2.x
            int r9 = r2.y
            com.bytedance.sdk.openadsdk.core.f.c.a$b r10 = com.bytedance.sdk.openadsdk.core.f.c.a.b.IFRAME_RESOURCE
            com.bytedance.sdk.openadsdk.core.f.c.a$a r11 = com.bytedance.sdk.openadsdk.core.f.c.a.C0048a.NONE
            r6 = r4
            r7 = r3
            float r2 = com.bytedance.sdk.openadsdk.core.f.c.a(r6, r7, r8, r9, r10, r11)
            r5.g = r2
            float r2 = r5.g
            int r2 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r2 > 0) goto L_0x0204
            r2 = 3
            com.bytedance.sdk.openadsdk.core.f.a.a.e.a(r1, r12, r2)
            r6 = r2
            goto L_0x0243
        L_0x0204:
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.f.a.a.e.b((org.xmlpull.v1.XmlPullParser) r1, (java.lang.String) r15)
            com.bytedance.sdk.openadsdk.core.f.c.a$a r6 = com.bytedance.sdk.openadsdk.core.f.c.a.C0048a.NONE
            com.bytedance.sdk.openadsdk.core.f.c.a$b r7 = com.bytedance.sdk.openadsdk.core.f.c.a.b.IFRAME_RESOURCE
            r5.a(r2, r6, r7)
            goto L_0x0131
        L_0x0211:
            r5 = r9
            r14 = r10
            r13 = r11
            r12 = r21
            com.bytedance.sdk.openadsdk.core.f.c.a$b r6 = com.bytedance.sdk.openadsdk.core.f.c.a.b.HTML_RESOURCE
            android.graphics.Point r6 = com.bytedance.sdk.openadsdk.core.f.c.a.a(r0, r13, r14, r6)
            int r8 = r6.x
            int r9 = r6.y
            com.bytedance.sdk.openadsdk.core.f.c.a$b r10 = com.bytedance.sdk.openadsdk.core.f.c.a.b.HTML_RESOURCE
            com.bytedance.sdk.openadsdk.core.f.c.a$a r11 = com.bytedance.sdk.openadsdk.core.f.c.a.C0048a.NONE
            r6 = r4
            r7 = r3
            float r6 = com.bytedance.sdk.openadsdk.core.f.c.a(r6, r7, r8, r9, r10, r11)
            r5.g = r6
            float r6 = r5.g
            int r6 = (r6 > r22 ? 1 : (r6 == r22 ? 0 : -1))
            if (r6 > 0) goto L_0x0237
            r6 = 3
            com.bytedance.sdk.openadsdk.core.f.a.a.e.a(r1, r12, r6)
            goto L_0x0243
        L_0x0237:
            r6 = 3
            java.lang.String r2 = com.bytedance.sdk.openadsdk.core.f.a.a.e.b((org.xmlpull.v1.XmlPullParser) r1, (java.lang.String) r2)
            com.bytedance.sdk.openadsdk.core.f.c.a$a r7 = com.bytedance.sdk.openadsdk.core.f.c.a.C0048a.NONE
            com.bytedance.sdk.openadsdk.core.f.c.a$b r8 = com.bytedance.sdk.openadsdk.core.f.c.a.b.HTML_RESOURCE
            r5.a(r2, r7, r8)
        L_0x0243:
            r9 = r5
            r15 = r12
            r11 = r13
            r10 = r14
            r5 = r20
            r12 = r22
            r2 = 0
            r14 = 2
            r13 = r6
            goto L_0x0078
        L_0x0250:
            r20 = r5
            r22 = r12
            com.bytedance.sdk.openadsdk.core.f.a.a.e.a((org.xmlpull.v1.XmlPullParser) r26)
            goto L_0x025c
        L_0x0258:
            r20 = r5
            r22 = r12
        L_0x025c:
            r5 = r20
            r12 = r22
            r2 = 0
            goto L_0x0024
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.f.a.a.a.a(android.content.Context, org.xmlpull.v1.XmlPullParser):com.bytedance.sdk.openadsdk.core.f.c");
    }
}
