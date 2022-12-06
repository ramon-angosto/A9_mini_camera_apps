package com.hianalytics.android.v1;

import android.content.Context;
import android.util.Base64;
import com.hianalytics.android.a.a.a;
import com.hianalytics.android.a.a.b;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.json.JSONObject;

public final class c implements Runnable {
    boolean a;
    private Context b;
    private JSONObject c;

    public c(Context context, JSONObject jSONObject, boolean z) {
        this.b = context;
        this.c = jSONObject;
        this.a = z;
    }

    private String a(byte[] bArr) {
        SecureRandom secureRandom = new SecureRandom();
        String valueOf = String.valueOf(System.currentTimeMillis());
        int length = valueOf.length();
        if (length < 13) {
            StringBuffer stringBuffer = new StringBuffer(valueOf);
            for (int i = 0; i < 13 - length; i++) {
                stringBuffer.append(PushConstants.PUSH_TYPE_NOTIFY);
            }
            valueOf = stringBuffer.toString();
        } else if (length > 13) {
            valueOf = valueOf.substring(0, 13);
        }
        String str = String.valueOf(valueOf) + String.format("%03d", new Object[]{Integer.valueOf(secureRandom.nextInt(999))});
        try {
            byte[] a2 = b.a(str, bArr);
            byte[] bytes = str.getBytes("UTF-8");
            byte[] decode = Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDf5raDExuuXbsVNCWl48yuB89W\rfNOuuhPuS2Mptii/0UorpzypBkNTTGt11E7aorCc1lFwlB+4KDMIpFyQsdChSk+A\rt9UfhFKa95uiDpMe5rMfU+DAhoXGER6WQ2qGtrHmBWVv33i3lc76u9IgEfYuLwC6\r1mhQDHzAKPiViY6oeQIDAQAB\r", 0);
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decode)));
            byte[] doFinal = instance.doFinal(bytes);
            return "{\"vs\":\"" + a.e(this.b) + "\",\"ed\":\"" + a.b(a2) + "\",\"ek\":\"" + a.b(doFinal) + "\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean a(JSONObject jSONObject, String str) {
        StringBuilder sb;
        String a2;
        String lowerCase = str.toLowerCase();
        try {
            byte[] a3 = a.a(jSONObject.toString().getBytes("UTF-8"));
            if (a3 == null || (a2 = a(a3)) == null) {
                return false;
            }
            try {
                byte[] bytes = a2.getBytes("UTF-8");
                if (lowerCase.indexOf("https") >= 0) {
                    return false;
                }
                a.h();
                return b.a(str, bytes);
            } catch (UnsupportedEncodingException e) {
                e = e;
                sb = new StringBuilder("UnsupportedEncodingException:");
                sb.append(e.getMessage());
                sb.toString();
                a.h();
                return false;
            }
        } catch (UnsupportedEncodingException e2) {
            e = e2;
            sb = new StringBuilder("UnsupportedEncodingException:");
            sb.append(e.getMessage());
            sb.toString();
            a.h();
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056 A[Catch:{ Exception -> 0x0236 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068 A[Catch:{ Exception -> 0x0236 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0083 A[Catch:{ Exception -> 0x0236 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0116 A[Catch:{ JSONException -> 0x022e }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x012c A[Catch:{ JSONException -> 0x022e }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0130 A[Catch:{ JSONException -> 0x022e }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0186 A[SYNTHETIC, Splitter:B:67:0x0186] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r24 = this;
            r1 = r24
            java.lang.String r0 = "e"
            java.lang.String r2 = "b"
            java.lang.String r3 = "type"
            java.lang.String r4 = "cached"
            org.json.JSONObject r5 = r1.c     // Catch:{ Exception -> 0x0236 }
            java.lang.String r5 = r5.getString(r3)     // Catch:{ Exception -> 0x0236 }
            if (r5 != 0) goto L_0x0013
            return
        L_0x0013:
            android.content.Context r5 = r1.b     // Catch:{ Exception -> 0x0236 }
            org.json.JSONObject r6 = r1.c     // Catch:{ Exception -> 0x0236 }
            boolean r7 = r1.a     // Catch:{ Exception -> 0x0236 }
            java.lang.StringBuffer r8 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x0236 }
            java.lang.String r9 = "1.0"
            r8.<init>(r9)     // Catch:{ Exception -> 0x0236 }
            java.lang.String r9 = com.hianalytics.android.a.a.a.a((android.content.Context) r5)     // Catch:{ Exception -> 0x0236 }
            java.lang.String r10 = "phone"
            java.lang.Object r10 = r5.getSystemService(r10)     // Catch:{ Exception -> 0x0236 }
            android.telephony.TelephonyManager r10 = (android.telephony.TelephonyManager) r10     // Catch:{ Exception -> 0x0236 }
            java.lang.String r11 = ","
            if (r10 != 0) goto L_0x0036
            com.hianalytics.android.a.a.a.h()     // Catch:{ Exception -> 0x0236 }
            r8 = 0
            goto L_0x00d0
        L_0x0036:
            android.content.res.Resources r12 = r5.getResources()     // Catch:{ Exception -> 0x0236 }
            android.content.res.Configuration r12 = r12.getConfiguration()     // Catch:{ Exception -> 0x0236 }
            java.lang.String r13 = ""
            if (r12 == 0) goto L_0x004d
            java.util.Locale r14 = r12.locale     // Catch:{ Exception -> 0x0236 }
            if (r14 == 0) goto L_0x004d
            java.util.Locale r12 = r12.locale     // Catch:{ Exception -> 0x0236 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x0236 }
            goto L_0x004e
        L_0x004d:
            r12 = r13
        L_0x004e:
            java.lang.String r14 = "android.permission.READ_PHONE_STATE"
            boolean r14 = com.hianalytics.android.a.a.a.a(r5, r14)     // Catch:{ Exception -> 0x0236 }
            if (r14 == 0) goto L_0x005e
            java.lang.String r10 = r10.getDeviceId()     // Catch:{ Exception -> 0x0236 }
            java.lang.String r13 = com.hianalytics.android.a.a.a.b((java.lang.String) r10)     // Catch:{ Exception -> 0x0236 }
        L_0x005e:
            java.lang.String r10 = com.hianalytics.android.a.a.a.e(r5)     // Catch:{ Exception -> 0x0236 }
            boolean r14 = com.hianalytics.android.a.a.a.f(r5)     // Catch:{ Exception -> 0x0236 }
            if (r14 != 0) goto L_0x0083
            java.lang.String r12 = ",,,,,"
            r8.append(r12)     // Catch:{ Exception -> 0x0236 }
            r8.append(r10)     // Catch:{ Exception -> 0x0236 }
            r8.append(r11)     // Catch:{ Exception -> 0x0236 }
            r8.append(r13)     // Catch:{ Exception -> 0x0236 }
            r8.append(r11)     // Catch:{ Exception -> 0x0236 }
            r8.append(r9)     // Catch:{ Exception -> 0x0236 }
            r8.append(r11)     // Catch:{ Exception -> 0x0236 }
        L_0x007f:
            com.hianalytics.android.a.a.a.h()     // Catch:{ Exception -> 0x0236 }
            goto L_0x00cc
        L_0x0083:
            r8.append(r11)     // Catch:{ Exception -> 0x0236 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0236 }
            java.lang.String r15 = "Android"
            r14.<init>(r15)     // Catch:{ Exception -> 0x0236 }
            java.lang.String r15 = android.os.Build.VERSION.RELEASE     // Catch:{ Exception -> 0x0236 }
            r14.append(r15)     // Catch:{ Exception -> 0x0236 }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x0236 }
            r8.append(r14)     // Catch:{ Exception -> 0x0236 }
            r8.append(r11)     // Catch:{ Exception -> 0x0236 }
            r8.append(r12)     // Catch:{ Exception -> 0x0236 }
            r8.append(r11)     // Catch:{ Exception -> 0x0236 }
            java.lang.String r12 = android.os.Build.MODEL     // Catch:{ Exception -> 0x0236 }
            r8.append(r12)     // Catch:{ Exception -> 0x0236 }
            r8.append(r11)     // Catch:{ Exception -> 0x0236 }
            java.lang.String r12 = android.os.Build.DISPLAY     // Catch:{ Exception -> 0x0236 }
            r8.append(r12)     // Catch:{ Exception -> 0x0236 }
            r8.append(r11)     // Catch:{ Exception -> 0x0236 }
            r8.append(r10)     // Catch:{ Exception -> 0x0236 }
            r8.append(r11)     // Catch:{ Exception -> 0x0236 }
            r8.append(r13)     // Catch:{ Exception -> 0x0236 }
            r8.append(r11)     // Catch:{ Exception -> 0x0236 }
            r8.append(r9)     // Catch:{ Exception -> 0x0236 }
            r8.append(r11)     // Catch:{ Exception -> 0x0236 }
            java.lang.String r9 = com.hianalytics.android.a.a.a.b((android.content.Context) r5)     // Catch:{ Exception -> 0x0236 }
            r8.append(r9)     // Catch:{ Exception -> 0x0236 }
            goto L_0x007f
        L_0x00cc:
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0236 }
        L_0x00d0:
            if (r8 != 0) goto L_0x00d6
            com.hianalytics.android.a.a.a.h()     // Catch:{ Exception -> 0x0236 }
            return
        L_0x00d6:
            org.json.JSONObject r9 = com.hianalytics.android.a.a.c.b(r5, r4)     // Catch:{ Exception -> 0x0236 }
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x0236 }
            r10.<init>()     // Catch:{ Exception -> 0x0236 }
            java.lang.String r12 = r6.getString(r3)     // Catch:{ JSONException -> 0x022e }
            if (r12 != 0) goto L_0x00e6
            return
        L_0x00e6:
            r6.remove(r3)     // Catch:{ JSONException -> 0x022e }
            r3 = 0
            r13 = 1
            if (r9 == 0) goto L_0x0100
            boolean r14 = r9.isNull(r12)     // Catch:{ JSONException -> 0x022e }
            if (r14 == 0) goto L_0x00f9
            org.json.JSONArray r14 = new org.json.JSONArray     // Catch:{ JSONException -> 0x022e }
            r14.<init>()     // Catch:{ JSONException -> 0x022e }
            goto L_0x010a
        L_0x00f9:
            org.json.JSONArray r14 = r9.getJSONArray(r12)     // Catch:{ JSONException -> 0x022e }
            r15 = r9
            r9 = 0
            goto L_0x010c
        L_0x0100:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x022e }
            r9.<init>()     // Catch:{ JSONException -> 0x022e }
            org.json.JSONArray r14 = new org.json.JSONArray     // Catch:{ JSONException -> 0x022e }
            r14.<init>()     // Catch:{ JSONException -> 0x022e }
        L_0x010a:
            r15 = r9
            r9 = 1
        L_0x010c:
            if (r7 == 0) goto L_0x0114
            if (r9 == 0) goto L_0x0114
            com.hianalytics.android.a.a.a.h()     // Catch:{ JSONException -> 0x022e }
            return
        L_0x0114:
            if (r7 != 0) goto L_0x0119
            r14.put(r6)     // Catch:{ JSONException -> 0x022e }
        L_0x0119:
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ JSONException -> 0x022e }
            r6.<init>()     // Catch:{ JSONException -> 0x022e }
            int r7 = r14.length()     // Catch:{ JSONException -> 0x022e }
        L_0x0122:
            int r9 = r7 + -1
            if (r3 <= r9) goto L_0x0186
            int r0 = r6.length()     // Catch:{ JSONException -> 0x022e }
            if (r0 > 0) goto L_0x0130
            com.hianalytics.android.a.a.a.h()     // Catch:{ JSONException -> 0x022e }
            return
        L_0x0130:
            r15.remove(r12)     // Catch:{ JSONException -> 0x022e }
            r15.put(r12, r6)     // Catch:{ JSONException -> 0x022e }
            java.lang.String r0 = "g"
            r10.put(r0, r8)     // Catch:{ JSONException -> 0x022e }
            java.lang.String r0 = "s"
            r10.put(r0, r6)     // Catch:{ JSONException -> 0x022e }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0236 }
            java.lang.String r2 = "message="
            r0.<init>(r2)     // Catch:{ Exception -> 0x0236 }
            java.lang.String r2 = r10.toString()     // Catch:{ Exception -> 0x0236 }
            r0.append(r2)     // Catch:{ Exception -> 0x0236 }
            r0.toString()     // Catch:{ Exception -> 0x0236 }
            com.hianalytics.android.a.a.a.h()     // Catch:{ Exception -> 0x0236 }
            java.lang.String r0 = com.hianalytics.android.a.a.a.i()     // Catch:{ Exception -> 0x0236 }
            boolean r0 = r1.a(r10, r0)     // Catch:{ Exception -> 0x0236 }
            if (r0 == 0) goto L_0x017f
            java.lang.String r0 = "flag"
            android.content.SharedPreferences r0 = com.hianalytics.android.a.a.c.a(r5, r0)     // Catch:{ Exception -> 0x0236 }
            boolean r2 = com.hianalytics.android.a.a.a.f(r5)     // Catch:{ Exception -> 0x0236 }
            if (r2 == 0) goto L_0x0178
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ Exception -> 0x0236 }
            java.lang.String r2 = "rom_version"
            java.lang.String r3 = android.os.Build.DISPLAY     // Catch:{ Exception -> 0x0236 }
            r0.putString(r2, r3)     // Catch:{ Exception -> 0x0236 }
            r0.commit()     // Catch:{ Exception -> 0x0236 }
        L_0x0178:
            com.hianalytics.android.a.a.c.c(r5, r4)     // Catch:{ Exception -> 0x0236 }
            com.hianalytics.android.a.a.a.h()     // Catch:{ Exception -> 0x0236 }
            return
        L_0x017f:
            com.hianalytics.android.a.a.c.a(r5, r15, r4)     // Catch:{ Exception -> 0x0236 }
            com.hianalytics.android.a.a.a.h()     // Catch:{ Exception -> 0x0236 }
            return
        L_0x0186:
            org.json.JSONObject r9 = r14.getJSONObject(r3)     // Catch:{ JSONException -> 0x022e }
            boolean r16 = r9.has(r2)     // Catch:{ JSONException -> 0x022e }
            r17 = 2
            r18 = 1000(0x3e8, double:4.94E-321)
            if (r16 == 0) goto L_0x01df
            org.json.JSONArray r13 = r9.getJSONArray(r2)     // Catch:{ JSONException -> 0x022e }
            if (r13 == 0) goto L_0x01dc
            int r20 = r13.length()     // Catch:{ JSONException -> 0x022e }
            if (r20 <= 0) goto L_0x01dc
            int r20 = r13.length()     // Catch:{ JSONException -> 0x022e }
            r21 = r2
            r16 = 1
            int r2 = r20 + -1
            java.lang.String r2 = r13.getString(r2)     // Catch:{ JSONException -> 0x022e }
            java.lang.String[] r2 = r2.split(r11)     // Catch:{ JSONException -> 0x022e }
            long r22 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x022e }
            long r22 = r22 / r18
            r13 = r2[r16]     // Catch:{ JSONException -> 0x022e }
            long r18 = com.hianalytics.android.a.a.a.a((java.lang.String) r13)     // Catch:{ JSONException -> 0x022e }
            long r22 = r22 - r18
            r2 = r2[r17]     // Catch:{ JSONException -> 0x022e }
            long r17 = java.lang.Long.parseLong(r2)     // Catch:{ JSONException -> 0x022e }
            long r22 = r22 - r17
            java.lang.Long r2 = com.hianalytics.android.a.a.a.b()     // Catch:{ JSONException -> 0x022e }
            long r17 = r2.longValue()     // Catch:{ JSONException -> 0x022e }
            int r2 = (r22 > r17 ? 1 : (r22 == r17 ? 0 : -1))
            if (r2 >= 0) goto L_0x01d8
            r6.put(r9)     // Catch:{ JSONException -> 0x022e }
            goto L_0x0225
        L_0x01d8:
            com.hianalytics.android.a.a.a.h()     // Catch:{ JSONException -> 0x022e }
            goto L_0x0225
        L_0x01dc:
            r21 = r2
            goto L_0x0225
        L_0x01df:
            r21 = r2
            boolean r2 = r9.has(r0)     // Catch:{ JSONException -> 0x022e }
            if (r2 == 0) goto L_0x0225
            org.json.JSONArray r2 = r9.getJSONArray(r0)     // Catch:{ JSONException -> 0x022e }
            if (r2 == 0) goto L_0x0225
            int r13 = r2.length()     // Catch:{ JSONException -> 0x022e }
            if (r13 <= 0) goto L_0x0225
            int r13 = r2.length()     // Catch:{ JSONException -> 0x022e }
            r16 = 1
            int r13 = r13 + -1
            java.lang.String r2 = r2.getString(r13)     // Catch:{ JSONException -> 0x022e }
            java.lang.String[] r2 = r2.split(r11)     // Catch:{ JSONException -> 0x022e }
            long r22 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x022e }
            long r22 = r22 / r18
            r2 = r2[r17]     // Catch:{ JSONException -> 0x022e }
            long r17 = com.hianalytics.android.a.a.a.a((java.lang.String) r2)     // Catch:{ JSONException -> 0x022e }
            long r22 = r22 - r17
            java.lang.Long r2 = com.hianalytics.android.a.a.a.b()     // Catch:{ JSONException -> 0x022e }
            long r17 = r2.longValue()     // Catch:{ JSONException -> 0x022e }
            int r2 = (r22 > r17 ? 1 : (r22 == r17 ? 0 : -1))
            if (r2 >= 0) goto L_0x0221
            r6.put(r9)     // Catch:{ JSONException -> 0x022e }
            goto L_0x0227
        L_0x0221:
            com.hianalytics.android.a.a.a.h()     // Catch:{ JSONException -> 0x022e }
            goto L_0x0227
        L_0x0225:
            r16 = 1
        L_0x0227:
            int r3 = r3 + 1
            r2 = r21
            r13 = 1
            goto L_0x0122
        L_0x022e:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x0236 }
            com.hianalytics.android.a.a.c.c(r5, r4)     // Catch:{ Exception -> 0x0236 }
            return
        L_0x0236:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "MessageThread.run() throw exception:"
            r2.<init>(r3)
            java.lang.String r3 = r0.getMessage()
            r2.append(r3)
            r2.toString()
            com.hianalytics.android.a.a.a.h()
            r0.printStackTrace()
            android.content.Context r0 = r1.b
            com.hianalytics.android.a.a.c.c(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hianalytics.android.v1.c.run():void");
    }
}
