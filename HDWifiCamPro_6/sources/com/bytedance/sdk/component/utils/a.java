package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.Random;

/* compiled from: AESUtils */
public class a {
    private static Random a = new SecureRandom();

    /* JADX WARNING: Can't wrap try/catch for region: R(2:9|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r2.put("message", r6.toString());
        r2.put("cypher", 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
        com.bytedance.sdk.component.utils.l.b(r6.getMessage());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject a(org.json.JSONObject r6) {
        /*
            java.lang.String r0 = "cypher"
            java.lang.String r1 = "message"
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            if (r6 != 0) goto L_0x000c
            return r2
        L_0x000c:
            r3 = 0
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x002e }
            java.lang.String r4 = a((java.lang.String) r4)     // Catch:{ all -> 0x002e }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x002e }
            if (r5 != 0) goto L_0x0023
            r2.put(r1, r4)     // Catch:{ all -> 0x002e }
            r4 = 3
            r2.put(r0, r4)     // Catch:{ all -> 0x002e }
            goto L_0x0041
        L_0x0023:
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x002e }
            r2.put(r1, r4)     // Catch:{ all -> 0x002e }
            r2.put(r0, r3)     // Catch:{ all -> 0x002e }
            goto L_0x0041
        L_0x002e:
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0039 }
            r2.put(r1, r6)     // Catch:{ all -> 0x0039 }
            r2.put(r0, r3)     // Catch:{ all -> 0x0039 }
            goto L_0x0041
        L_0x0039:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.bytedance.sdk.component.utils.l.b(r6)
        L_0x0041:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.a.a(org.json.JSONObject):org.json.JSONObject");
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String a2 = a();
        String a3 = a(a2, 32);
        String b = b();
        String str2 = null;
        if (!(a3 == null || b == null)) {
            str2 = com.bytedance.sdk.component.c.a.a(str, b, a3);
        }
        return 3 + a2 + b + str2;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 49) {
            return str;
        }
        String a2 = a(str.substring(1, 33), 32);
        String substring = str.substring(33, 49);
        return (substring == null || a2 == null) ? str : com.bytedance.sdk.component.c.a.b(str.substring(49), substring, a2);
    }

    public static String a() {
        String a2 = a(16);
        if (a2 == null || a2.length() != 32) {
            return null;
        }
        return a2;
    }

    public static String a(String str, int i) {
        if (str == null || str.length() != i) {
            return null;
        }
        int i2 = i / 2;
        return str.substring(i2, i) + str.substring(0, i2);
    }

    public static String b() {
        String a2 = a(8);
        if (a2 == null || a2.length() != 16) {
            return null;
        }
        return a2;
    }

    public static String a(int i) {
        try {
            byte[] bArr = new byte[i];
            a.nextBytes(bArr);
            return e.a(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
