package com.bytedance.sdk.openadsdk;

public class TTImage {
    private int a;
    private int b;
    private String c;
    private double d;

    public TTImage(int i, int i2, String str, double d2) {
        this.d = 0.0d;
        this.a = i;
        this.b = i2;
        this.c = str;
        this.d = d2;
    }

    public TTImage(int i, int i2, String str) {
        this(i, i2, str, 0.0d);
    }

    public int getHeight() {
        return this.a;
    }

    public int getWidth() {
        return this.b;
    }

    public String getImageUrl() {
        return this.c;
    }

    public double getDuration() {
        return this.d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r0 = r1.c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isValid() {
        /*
            r1 = this;
            int r0 = r1.a
            if (r0 <= 0) goto L_0x0014
            int r0 = r1.b
            if (r0 <= 0) goto L_0x0014
            java.lang.String r0 = r1.c
            if (r0 == 0) goto L_0x0014
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.TTImage.isValid():boolean");
    }
}
