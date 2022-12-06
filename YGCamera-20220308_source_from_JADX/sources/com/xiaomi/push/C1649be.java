package com.xiaomi.push;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;

/* renamed from: com.xiaomi.push.be */
class C1649be implements C1633at {

    /* renamed from: a */
    private static String f1855a = "content://com.vivo.vms.IdProvider/IdentifierId/";

    /* renamed from: b */
    private static String f1856b = (f1855a + "OAID");

    /* renamed from: c */
    private static String f1857c = (f1855a + "VAID_");

    /* renamed from: d */
    private static String f1858d = (f1855a + "AAID_");

    /* renamed from: e */
    private static String f1859e = (f1855a + "OAIDSTATUS");

    /* renamed from: f */
    private static String f1860f = "persist.sys.identifierid.supported";

    /* renamed from: a */
    private Context f1861a;

    public C1649be(Context context) {
        this.f1861a = context;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        if (r10 != null) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
        r10.close();
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
        if (r10 != null) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003e, code lost:
        return r0;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m2657a(java.lang.String r10) {
        /*
            r9 = this;
            r0 = 0
            android.content.Context r1 = r9.f1861a     // Catch:{ Exception -> 0x003a, all -> 0x0033 }
            android.content.ContentResolver r2 = r1.getContentResolver()     // Catch:{ Exception -> 0x003a, all -> 0x0033 }
            android.net.Uri r3 = android.net.Uri.parse(r10)     // Catch:{ Exception -> 0x003a, all -> 0x0033 }
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r10 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x003a, all -> 0x0033 }
            if (r10 == 0) goto L_0x002d
            boolean r1 = r10.moveToNext()     // Catch:{ Exception -> 0x002b, all -> 0x0026 }
            if (r1 == 0) goto L_0x002d
            java.lang.String r1 = "value"
            int r1 = r10.getColumnIndex(r1)     // Catch:{ Exception -> 0x002b, all -> 0x0026 }
            java.lang.String r0 = r10.getString(r1)     // Catch:{ Exception -> 0x002b, all -> 0x0026 }
            goto L_0x002d
        L_0x0026:
            r0 = move-exception
            r8 = r0
            r0 = r10
            r10 = r8
            goto L_0x0034
        L_0x002b:
            goto L_0x003b
        L_0x002d:
            if (r10 == 0) goto L_0x003e
        L_0x002f:
            r10.close()
            goto L_0x003e
        L_0x0033:
            r10 = move-exception
        L_0x0034:
            if (r0 == 0) goto L_0x0039
            r0.close()
        L_0x0039:
            throw r10
        L_0x003a:
            r10 = r0
        L_0x003b:
            if (r10 == 0) goto L_0x003e
            goto L_0x002f
        L_0x003e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1649be.m2657a(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static boolean m2658a(Context context) {
        try {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(Uri.parse(f1855a).getAuthority(), 128);
            if (resolveContentProvider != null) {
                if ((resolveContentProvider.applicationInfo.flags & 1) != 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* renamed from: a */
    public String mo17232a() {
        return null;
    }

    /* renamed from: a */
    public boolean m2660a() {
        return "1".equals(C2086t.m5370a(f1860f, "0"));
    }

    /* renamed from: b */
    public String mo17233b() {
        return m2657a(f1856b);
    }

    /* renamed from: c */
    public String mo17234c() {
        return null;
    }

    /* renamed from: d */
    public String mo17235d() {
        return null;
    }
}
