package com.huawei.hms.framework.network.grs.p019d;

/* renamed from: com.huawei.hms.framework.network.grs.d.c */
public class C0762c {

    /* renamed from: a */
    private static final String f580a = "c";

    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        com.huawei.hms.framework.common.Logger.m480w(f580a, "local config file is not exist.filename is {%s}", r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004e, code lost:
        return "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004f, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0050, code lost:
        com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.OutputStream) r2);
        com.huawei.hms.framework.common.IoUtils.closeSecure(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        throw r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003c */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m673a(java.lang.String r6, android.content.Context r7) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            r0 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
            r2.<init>()
            r3 = 0
            android.content.res.AssetManager r7 = r7.getAssets()     // Catch:{ IOException -> 0x003c }
            java.io.InputStream r0 = r7.open(r6)     // Catch:{ IOException -> 0x003c }
            r7 = 8192(0x2000, float:1.14794E-41)
            byte[] r7 = new byte[r7]     // Catch:{ IOException -> 0x003c }
        L_0x001c:
            int r4 = r0.read(r7)     // Catch:{ IOException -> 0x003c }
            r5 = -1
            if (r4 == r5) goto L_0x0027
            r2.write(r7, r3, r4)     // Catch:{ IOException -> 0x003c }
            goto L_0x001c
        L_0x0027:
            r2.flush()     // Catch:{ IOException -> 0x003c }
            java.lang.String r7 = new java.lang.String     // Catch:{ IOException -> 0x003c }
            byte[] r4 = r2.toByteArray()     // Catch:{ IOException -> 0x003c }
            java.lang.String r5 = "UTF-8"
            r7.<init>(r4, r5)     // Catch:{ IOException -> 0x003c }
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.OutputStream) r2)
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.InputStream) r0)
            return r7
        L_0x003c:
            java.lang.String r7 = f580a     // Catch:{ all -> 0x004f }
            java.lang.String r4 = "local config file is not exist.filename is {%s}"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x004f }
            r5[r3] = r6     // Catch:{ all -> 0x004f }
            com.huawei.hms.framework.common.Logger.m480w((java.lang.String) r7, (java.lang.String) r4, (java.lang.Object[]) r5)     // Catch:{ all -> 0x004f }
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.OutputStream) r2)
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.InputStream) r0)
            return r1
        L_0x004f:
            r6 = move-exception
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.OutputStream) r2)
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.InputStream) r0)
            goto L_0x0058
        L_0x0057:
            throw r6
        L_0x0058:
            goto L_0x0057
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p019d.C0762c.m673a(java.lang.String, android.content.Context):java.lang.String");
    }
}
