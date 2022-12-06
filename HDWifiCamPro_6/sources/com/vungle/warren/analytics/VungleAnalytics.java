package com.vungle.warren.analytics;

import android.util.Log;
import com.google.gson.JsonObject;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.model.AnalyticUrl;
import com.vungle.warren.network.Call;
import com.vungle.warren.network.Callback;
import com.vungle.warren.network.Response;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.utility.VungleUrlUtility;
import java.util.List;

public class VungleAnalytics implements AdAnalytics {
    /* access modifiers changed from: private */
    public static final String TAG = VungleAnalytics.class.getSimpleName();
    private final VungleApiClient client;
    private final Repository repository;

    public VungleAnalytics(VungleApiClient vungleApiClient, Repository repository2) {
        this.client = vungleApiClient;
        this.repository = repository2;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0044 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String[] ping(java.lang.String[] r9) {
        /*
            r8 = this;
            int r0 = r9.length
            if (r0 != 0) goto L_0x0004
            return r9
        L_0x0004:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = r9.length
            r2 = 0
            r3 = r2
        L_0x000c:
            if (r3 >= r1) goto L_0x0096
            r4 = r9[r3]
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x0092
            com.vungle.warren.VungleApiClient r5 = r8.client     // Catch:{ ClearTextTrafficException -> 0x007c, MalformedURLException -> 0x0044, DBException -> 0x002d }
            boolean r5 = r5.pingTPAT(r4)     // Catch:{ ClearTextTrafficException -> 0x007c, MalformedURLException -> 0x0044, DBException -> 0x002d }
            if (r5 != 0) goto L_0x0022
            r0.add(r4)     // Catch:{ ClearTextTrafficException -> 0x007c, MalformedURLException -> 0x0044, DBException -> 0x002d }
            goto L_0x0092
        L_0x0022:
            com.vungle.warren.persistence.Repository r5 = r8.repository     // Catch:{ ClearTextTrafficException -> 0x007c, MalformedURLException -> 0x0044, DBException -> 0x002d }
            com.vungle.warren.model.AnalyticUrl r6 = new com.vungle.warren.model.AnalyticUrl     // Catch:{ ClearTextTrafficException -> 0x007c, MalformedURLException -> 0x0044, DBException -> 0x002d }
            r6.<init>(r4)     // Catch:{ ClearTextTrafficException -> 0x007c, MalformedURLException -> 0x0044, DBException -> 0x002d }
            r5.delete(r6)     // Catch:{ ClearTextTrafficException -> 0x007c, MalformedURLException -> 0x0044, DBException -> 0x002d }
            goto L_0x0092
        L_0x002d:
            java.lang.String r5 = TAG
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Can't delete sent ping URL : "
            r6.append(r7)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            android.util.Log.e(r5, r4)
            goto L_0x0092
        L_0x0044:
            com.vungle.warren.persistence.Repository r5 = r8.repository     // Catch:{ DBException -> 0x004f }
            com.vungle.warren.model.AnalyticUrl r6 = new com.vungle.warren.model.AnalyticUrl     // Catch:{ DBException -> 0x004f }
            r6.<init>(r4)     // Catch:{ DBException -> 0x004f }
            r5.delete(r6)     // Catch:{ DBException -> 0x004f }
            goto L_0x0065
        L_0x004f:
            java.lang.String r5 = TAG
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "DBException deleting : "
            r6.append(r7)
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            android.util.Log.e(r5, r6)
        L_0x0065:
            java.lang.String r5 = TAG
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Invalid Url : "
            r6.append(r7)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            android.util.Log.e(r5, r4)
            goto L_0x0092
        L_0x007c:
            java.lang.String r5 = TAG
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Cleartext Network Traffic is Blocked : "
            r6.append(r7)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            android.util.Log.e(r5, r4)
        L_0x0092:
            int r3 = r3 + 1
            goto L_0x000c
        L_0x0096:
            java.lang.String[] r9 = new java.lang.String[r2]
            java.lang.Object[] r9 = r0.toArray(r9)
            java.lang.String[] r9 = (java.lang.String[]) r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.analytics.VungleAnalytics.ping(java.lang.String[]):java.lang.String[]");
    }

    public void ri(JsonObject jsonObject) {
        if (jsonObject != null) {
            this.client.ri(jsonObject).enqueue(new Callback<JsonObject>() {
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    Log.d(VungleAnalytics.TAG, "send RI success");
                }

                public void onFailure(Call<JsonObject> call, Throwable th) {
                    Log.d(VungleAnalytics.TAG, "send RI Failure");
                }
            });
        }
    }

    public String[] retryUnsent() {
        List list = this.repository.loadAll(AnalyticUrl.class).get();
        if (list == null || list.size() <= 0) {
            return new String[0];
        }
        String[] strArr = new String[list.size()];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = ((AnalyticUrl) list.get(i)).url;
        }
        return ping(strArr);
    }

    public void saveVungleUrls(String[] strArr) {
        for (String str : strArr) {
            if (VungleUrlUtility.isVungleUrl(str)) {
                try {
                    this.repository.save(new AnalyticUrl(str));
                } catch (DatabaseHelper.DBException unused) {
                    Log.e(TAG, "Can't save failed to ping URL : " + str);
                }
            }
        }
    }
}
