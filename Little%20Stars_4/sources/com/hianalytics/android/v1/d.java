package com.hianalytics.android.v1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.hianalytics.android.a.a.a;
import com.hianalytics.android.a.a.c;
import com.xiaomi.mipush.sdk.Constants;
import object.p2pipcam.utils.DataBaseHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d implements Runnable {
    private Context a;
    private int b;
    private long c;

    public d(Context context, int i, long j) {
        this.a = context;
        this.b = i;
        this.c = j;
    }

    private static void a(Context context, SharedPreferences sharedPreferences, long j) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        String b2 = a.b(((TelephonyManager) context.getSystemService("phone")).getDeviceId());
        String valueOf = String.valueOf(String.valueOf(j) + b2);
        edit.remove("session_id");
        edit.remove("refer_id");
        edit.putString("session_id", valueOf);
        edit.putString("refer_id", "");
        edit.putLong("end_millis", j);
        edit.commit();
    }

    private void a(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong("last_millis", this.c);
        edit.commit();
    }

    private void b(SharedPreferences sharedPreferences) {
        String str;
        boolean z;
        JSONObject jSONObject = new JSONObject();
        Context context = this.a;
        StringBuffer stringBuffer = new StringBuffer("");
        SharedPreferences a2 = c.a(context, "sessioncontext");
        String string = a2.getString("session_id", "");
        if ("".equals(string)) {
            String b2 = a.b(((TelephonyManager) context.getSystemService("phone")).getDeviceId());
            long currentTimeMillis = System.currentTimeMillis();
            string = String.valueOf(String.valueOf(currentTimeMillis) + b2);
            SharedPreferences.Editor edit = a2.edit();
            edit.putString("session_id", string);
            edit.putLong("end_millis", currentTimeMillis);
            edit.commit();
        }
        String string2 = a2.getString("refer_id", "");
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            a.h();
            str = null;
        } else {
            stringBuffer.append(a.c(context)[0]);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuffer.append(telephonyManager.getNetworkOperatorName().replace(',', '&'));
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuffer.append(string);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuffer.append(string2);
            str = stringBuffer.toString();
        }
        if (str != null) {
            try {
                if (sharedPreferences.getString("activities", "").trim().length() > 0) {
                    String[] split = sharedPreferences.getString("activities", "").split(";");
                    JSONArray jSONArray = new JSONArray();
                    for (String put : split) {
                        jSONArray.put(put);
                    }
                    jSONObject.put("b", jSONArray);
                    z = false;
                } else {
                    z = true;
                }
                if (sharedPreferences.getString("events", "").trim().length() > 0) {
                    String[] split2 = sharedPreferences.getString("events", "").split(";");
                    JSONArray jSONArray2 = new JSONArray();
                    for (String put2 : split2) {
                        jSONArray2.put(put2);
                    }
                    jSONObject.put("e", jSONArray2);
                    z = false;
                }
                jSONObject.put("h", str);
                jSONObject.put(DataBaseHelper.KEY_TYPE, "termination");
                Handler f = a.f();
                if (f != null) {
                    f.post(new c(this.a, jSONObject, z));
                }
                a.h();
            } catch (JSONException e) {
                Log.e("HiAnalytics", "onTerminate: JSONException.", e);
                e.printStackTrace();
            }
        }
        SharedPreferences.Editor edit2 = sharedPreferences.edit();
        edit2.putString("activities", "");
        edit2.remove("events");
        edit2.commit();
    }

    private boolean c(SharedPreferences sharedPreferences) {
        return this.c - sharedPreferences.getLong("last_millis", -1) > a.a().longValue() * 1000;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004f A[SYNTHETIC, Splitter:B:12:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00fd A[Catch:{ Exception -> 0x012a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r19 = this;
            r1 = r19
            java.lang.String r0 = ","
            java.lang.String r2 = "duration"
            java.lang.String r3 = "end_millis"
            java.lang.String r4 = "activities"
            java.lang.String r5 = ""
            android.content.Context r6 = r1.a     // Catch:{ Exception -> 0x012a }
            long r7 = r1.c     // Catch:{ Exception -> 0x012a }
            java.lang.String r9 = "sessioncontext"
            android.content.SharedPreferences r9 = com.hianalytics.android.a.a.c.a(r6, r9)     // Catch:{ Exception -> 0x012a }
            java.lang.String r10 = "session_id"
            java.lang.String r10 = r9.getString(r10, r5)     // Catch:{ Exception -> 0x012a }
            boolean r10 = r5.equals(r10)     // Catch:{ Exception -> 0x012a }
            r11 = 1000(0x3e8, double:4.94E-321)
            r13 = 0
            if (r10 == 0) goto L_0x002a
        L_0x0026:
            a(r6, r9, r7)     // Catch:{ Exception -> 0x012a }
            goto L_0x0049
        L_0x002a:
            long r15 = r9.getLong(r3, r13)     // Catch:{ Exception -> 0x012a }
            long r15 = r7 - r15
            java.lang.Long r10 = com.hianalytics.android.a.a.a.c()     // Catch:{ Exception -> 0x012a }
            long r17 = r10.longValue()     // Catch:{ Exception -> 0x012a }
            long r17 = r17 * r11
            int r10 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r10 <= 0) goto L_0x003f
            goto L_0x0026
        L_0x003f:
            android.content.SharedPreferences$Editor r6 = r9.edit()     // Catch:{ Exception -> 0x012a }
            r6.putLong(r3, r7)     // Catch:{ Exception -> 0x012a }
            r6.commit()     // Catch:{ Exception -> 0x012a }
        L_0x0049:
            int r3 = r1.b     // Catch:{ Exception -> 0x012a }
            java.lang.String r6 = "state"
            if (r3 != 0) goto L_0x00fd
            android.content.Context r3 = r1.a     // Catch:{ Exception -> 0x012a }
            android.content.Context r7 = r1.a     // Catch:{ Exception -> 0x012a }
            if (r7 == r3) goto L_0x0059
            com.hianalytics.android.a.a.a.h()     // Catch:{ Exception -> 0x012a }
            return
        L_0x0059:
            r1.a = r3     // Catch:{ Exception -> 0x012a }
            android.content.SharedPreferences r6 = com.hianalytics.android.a.a.c.a(r3, r6)     // Catch:{ Exception -> 0x012a }
            if (r6 == 0) goto L_0x00fc
            java.lang.String r7 = "last_millis"
            r8 = -1
            long r11 = r6.getLong(r7, r8)     // Catch:{ Exception -> 0x012a }
            int r7 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x0073
            com.hianalytics.android.a.a.a.h()     // Catch:{ Exception -> 0x012a }
            r16 = r3
            goto L_0x00e3
        L_0x0073:
            long r7 = r1.c     // Catch:{ Exception -> 0x012a }
            long r7 = r7 - r11
            long r9 = r6.getLong(r2, r13)     // Catch:{ Exception -> 0x012a }
            android.content.SharedPreferences$Editor r13 = r6.edit()     // Catch:{ Exception -> 0x012a }
            java.lang.String r14 = r6.getString(r4, r5)     // Catch:{ Exception -> 0x012a }
            java.lang.Class r17 = r3.getClass()     // Catch:{ Exception -> 0x012a }
            java.lang.String r15 = r17.getName()     // Catch:{ Exception -> 0x012a }
            boolean r5 = r5.equals(r14)     // Catch:{ Exception -> 0x012a }
            if (r5 != 0) goto L_0x00a2
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012a }
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ Exception -> 0x012a }
            r5.<init>(r14)     // Catch:{ Exception -> 0x012a }
            java.lang.String r14 = ";"
            r5.append(r14)     // Catch:{ Exception -> 0x012a }
            java.lang.String r14 = r5.toString()     // Catch:{ Exception -> 0x012a }
        L_0x00a2:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012a }
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ Exception -> 0x012a }
            r5.<init>(r14)     // Catch:{ Exception -> 0x012a }
            r5.append(r15)     // Catch:{ Exception -> 0x012a }
            r5.append(r0)     // Catch:{ Exception -> 0x012a }
            java.text.SimpleDateFormat r14 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x012a }
            java.lang.String r15 = "yyyyMMddHHmmssSSS"
            r16 = r3
            java.util.Locale r3 = java.util.Locale.US     // Catch:{ Exception -> 0x012a }
            r14.<init>(r15, r3)     // Catch:{ Exception -> 0x012a }
            java.util.Date r3 = new java.util.Date     // Catch:{ Exception -> 0x012a }
            r3.<init>(r11)     // Catch:{ Exception -> 0x012a }
            java.lang.String r3 = r14.format(r3)     // Catch:{ Exception -> 0x012a }
            r5.append(r3)     // Catch:{ Exception -> 0x012a }
            r5.append(r0)     // Catch:{ Exception -> 0x012a }
            r11 = 1000(0x3e8, double:4.94E-321)
            long r11 = r7 / r11
            r5.append(r11)     // Catch:{ Exception -> 0x012a }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x012a }
            r13.remove(r4)     // Catch:{ Exception -> 0x012a }
            r13.putString(r4, r0)     // Catch:{ Exception -> 0x012a }
            long r9 = r9 + r7
            r13.putLong(r2, r9)     // Catch:{ Exception -> 0x012a }
            r13.commit()     // Catch:{ Exception -> 0x012a }
        L_0x00e3:
            boolean r0 = r1.c(r6)     // Catch:{ Exception -> 0x012a }
            if (r0 == 0) goto L_0x00f0
            r1.b(r6)     // Catch:{ Exception -> 0x012a }
            r1.a(r6)     // Catch:{ Exception -> 0x012a }
            return
        L_0x00f0:
            boolean r0 = com.hianalytics.android.a.a.a.d((android.content.Context) r16)     // Catch:{ Exception -> 0x012a }
            if (r0 == 0) goto L_0x00fc
            r1.b(r6)     // Catch:{ Exception -> 0x012a }
            r1.a(r6)     // Catch:{ Exception -> 0x012a }
        L_0x00fc:
            return
        L_0x00fd:
            int r0 = r1.b     // Catch:{ Exception -> 0x012a }
            r2 = 1
            if (r0 != r2) goto L_0x0119
            android.content.Context r0 = r1.a     // Catch:{ Exception -> 0x012a }
            r1.a = r0     // Catch:{ Exception -> 0x012a }
            android.content.SharedPreferences r0 = com.hianalytics.android.a.a.c.a(r0, r6)     // Catch:{ Exception -> 0x012a }
            if (r0 == 0) goto L_0x0118
            boolean r2 = r1.c(r0)     // Catch:{ Exception -> 0x012a }
            if (r2 == 0) goto L_0x0118
            r1.b(r0)     // Catch:{ Exception -> 0x012a }
            r1.a(r0)     // Catch:{ Exception -> 0x012a }
        L_0x0118:
            return
        L_0x0119:
            int r0 = r1.b     // Catch:{ Exception -> 0x012a }
            r2 = 2
            if (r0 != r2) goto L_0x0142
            android.content.Context r0 = r1.a     // Catch:{ Exception -> 0x012a }
            android.content.SharedPreferences r0 = com.hianalytics.android.a.a.c.a(r0, r6)     // Catch:{ Exception -> 0x012a }
            if (r0 == 0) goto L_0x0129
            r1.b(r0)     // Catch:{ Exception -> 0x012a }
        L_0x0129:
            return
        L_0x012a:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "SessionThread.run() throw exception:"
            r2.<init>(r3)
            java.lang.String r3 = r0.getMessage()
            r2.append(r3)
            r2.toString()
            com.hianalytics.android.a.a.a.h()
            r0.printStackTrace()
        L_0x0142:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hianalytics.android.v1.d.run():void");
    }
}
