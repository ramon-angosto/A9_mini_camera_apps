package com.vungle.warren.downloader;

class RangeResponse {
    private static String TAG = RangeResponse.class.getName();
    public final String dimension;
    public final long rangeEnd;
    public final long rangeStart;
    public final long total;

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0075 A[SYNTHETIC, Splitter:B:32:0x0075] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public RangeResponse(java.lang.String r12) {
        /*
            r11 = this;
            r11.<init>()
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            r1 = -1
            r3 = 0
            if (r0 != 0) goto L_0x0080
            java.lang.String r12 = r12.trim()
            java.lang.String r0 = "\\s+"
            java.lang.String[] r12 = r12.split(r0)
            int r0 = r12.length
            r4 = 2
            if (r0 < r4) goto L_0x0080
            int r0 = r12.length
            r5 = 0
            if (r0 <= 0) goto L_0x0020
            r3 = r12[r5]
        L_0x0020:
            int r0 = r12.length
            r6 = 1
            if (r0 <= r6) goto L_0x0080
            r0 = r12[r6]
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0080
            r12 = r12[r6]
            java.lang.String r0 = "/"
            java.lang.String[] r12 = r12.split(r0)
            int r0 = r12.length
            if (r0 != r4) goto L_0x0080
            r0 = r12[r5]
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x006b
            r0 = r12[r5]
            java.lang.String r7 = "-"
            java.lang.String[] r0 = r0.split(r7)
            int r7 = r0.length
            if (r7 != r4) goto L_0x006b
            r4 = r0[r5]
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x006b
            r4 = r0[r6]
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x006b
            r4 = r0[r5]     // Catch:{ all -> 0x0061 }
            long r4 = java.lang.Long.parseLong(r4)     // Catch:{ all -> 0x0061 }
            goto L_0x0062
        L_0x0061:
            r4 = r1
        L_0x0062:
            r0 = r0[r6]     // Catch:{ all -> 0x0069 }
            long r7 = java.lang.Long.parseLong(r0)     // Catch:{ all -> 0x0069 }
            goto L_0x006d
        L_0x0069:
            r7 = r1
            goto L_0x006d
        L_0x006b:
            r4 = r1
            r7 = r4
        L_0x006d:
            r0 = r12[r6]
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x007b
            r12 = r12[r6]     // Catch:{ all -> 0x007b }
            long r1 = java.lang.Long.parseLong(r12)     // Catch:{ all -> 0x007b }
        L_0x007b:
            r12 = r3
            r9 = r1
            r1 = r4
            r3 = r9
            goto L_0x0083
        L_0x0080:
            r7 = r1
            r12 = r3
            r3 = r7
        L_0x0083:
            r11.rangeStart = r1
            r11.rangeEnd = r7
            r11.total = r3
            r11.dimension = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.downloader.RangeResponse.<init>(java.lang.String):void");
    }
}
