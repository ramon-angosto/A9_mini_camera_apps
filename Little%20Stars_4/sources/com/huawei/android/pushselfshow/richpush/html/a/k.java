package com.huawei.android.pushselfshow.richpush.html.a;

import android.content.Context;
import android.content.Intent;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.richpush.html.api.NativeToJsMessageQueue;
import com.huawei.android.pushselfshow.richpush.html.api.d;
import org.json.JSONObject;

public class k implements h {
    private NativeToJsMessageQueue a;
    private String b;
    private Context c;
    private String d = null;

    public k(Context context) {
        e.e("PushSelfShowLog", "init VideoPlayer");
        this.c = context;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:19|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        com.huawei.android.pushagent.c.a.e.e("PushSelfShowLog", "get mime-type error");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        com.huawei.android.pushagent.c.a.e.e("PushSelfShowLog", "get packageName error");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d8, code lost:
        r11 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0063 */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d8 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:8:0x0021] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.json.JSONObject r11) {
        /*
            r10 = this;
            java.lang.String r0 = "package-name"
            java.lang.String r1 = "get mime-type error"
            java.lang.String r2 = "mime-type"
            java.lang.String r3 = "startPlaying failed "
            com.huawei.android.pushselfshow.richpush.html.api.NativeToJsMessageQueue r4 = r10.a
            java.lang.String r5 = "PushSelfShowLog"
            if (r4 != 0) goto L_0x0014
            java.lang.String r11 = "jsMessageQueue is null while run into Video Player exec"
            com.huawei.android.pushagent.c.a.e.a(r5, r11)
            return
        L_0x0014:
            java.lang.String r4 = "error"
            r6 = 0
            if (r11 == 0) goto L_0x00de
            java.lang.String r7 = "url"
            boolean r8 = r11.has(r7)
            if (r8 == 0) goto L_0x00de
            java.lang.String r7 = r11.getString(r7)     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            com.huawei.android.pushselfshow.richpush.html.api.NativeToJsMessageQueue r8 = r10.a     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            java.lang.String r8 = r8.a()     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            java.lang.String r8 = com.huawei.android.pushselfshow.richpush.html.api.b.a((java.lang.String) r8, (java.lang.String) r7)     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            if (r8 == 0) goto L_0x00ba
            int r9 = r8.length()     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            if (r9 <= 0) goto L_0x00ba
            r10.d = r8     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            java.lang.String r7 = "video/*"
            boolean r8 = r11.has(r2)     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            if (r8 == 0) goto L_0x0066
            java.lang.String r2 = r11.getString(r2)     // Catch:{ Exception | JSONException -> 0x0063 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception | JSONException -> 0x0063 }
            r8.<init>()     // Catch:{ Exception | JSONException -> 0x0063 }
            java.lang.String r9 = "the custom mimetype is "
            r8.append(r9)     // Catch:{ Exception | JSONException -> 0x0063 }
            r8.append(r2)     // Catch:{ Exception | JSONException -> 0x0063 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception | JSONException -> 0x0063 }
            com.huawei.android.pushagent.c.a.e.e(r5, r8)     // Catch:{ Exception | JSONException -> 0x0063 }
            java.lang.String r8 = "video/"
            boolean r1 = r2.startsWith(r8)     // Catch:{ Exception | JSONException -> 0x0063 }
            if (r1 == 0) goto L_0x0066
            r7 = r2
            goto L_0x0066
        L_0x0063:
            com.huawei.android.pushagent.c.a.e.e(r5, r1)     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
        L_0x0066:
            android.content.Intent r1 = new android.content.Intent     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            java.lang.String r2 = "android.intent.action.VIEW"
            r1.<init>(r2)     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            java.lang.String r2 = r10.d     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            r1.setDataAndType(r2, r7)     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            boolean r2 = r11.has(r0)     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            if (r2 == 0) goto L_0x00a9
            java.lang.String r11 = r11.getString(r0)     // Catch:{ JSONException -> 0x00a4, Exception -> 0x00d8 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00a4, Exception -> 0x00d8 }
            r0.<init>()     // Catch:{ JSONException -> 0x00a4, Exception -> 0x00d8 }
            java.lang.String r2 = "the custom packageName is "
            r0.append(r2)     // Catch:{ JSONException -> 0x00a4, Exception -> 0x00d8 }
            r0.append(r11)     // Catch:{ JSONException -> 0x00a4, Exception -> 0x00d8 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x00a4, Exception -> 0x00d8 }
            com.huawei.android.pushagent.c.a.e.e(r5, r0)     // Catch:{ JSONException -> 0x00a4, Exception -> 0x00d8 }
            android.content.Context r0 = r10.c     // Catch:{ JSONException -> 0x00a4, Exception -> 0x00d8 }
            java.util.ArrayList r0 = com.huawei.android.pushselfshow.richpush.html.api.b.a((android.content.Context) r0, (android.content.Intent) r1)     // Catch:{ JSONException -> 0x00a4, Exception -> 0x00d8 }
            boolean r0 = r0.contains(r11)     // Catch:{ JSONException -> 0x00a4, Exception -> 0x00d8 }
            if (r0 == 0) goto L_0x00a9
            r1.setPackage(r11)     // Catch:{ JSONException -> 0x00a4, Exception -> 0x00d8 }
            goto L_0x00a9
        L_0x00a4:
            java.lang.String r11 = "get packageName error"
            com.huawei.android.pushagent.c.a.e.e(r5, r11)     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
        L_0x00a9:
            android.content.Context r11 = r10.c     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            r11.startActivity(r1)     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            com.huawei.android.pushselfshow.richpush.html.api.NativeToJsMessageQueue r11 = r10.a     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            java.lang.String r0 = r10.b     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            com.huawei.android.pushselfshow.richpush.html.api.d$a r1 = com.huawei.android.pushselfshow.richpush.html.api.d.a.OK     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            java.lang.String r2 = "success"
            r11.a(r0, r1, r2, r6)     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            goto L_0x00e7
        L_0x00ba:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            r11.<init>()     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            r11.append(r7)     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            java.lang.String r0 = "File not exist"
            r11.append(r0)     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            java.lang.String r11 = r11.toString()     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            com.huawei.android.pushagent.c.a.e.e(r5, r11)     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            com.huawei.android.pushselfshow.richpush.html.api.NativeToJsMessageQueue r11 = r10.a     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            java.lang.String r0 = r10.b     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            com.huawei.android.pushselfshow.richpush.html.api.d$a r1 = com.huawei.android.pushselfshow.richpush.html.api.d.a.AUDIO_ONLY_SUPPORT_HTTP     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            r11.a(r0, r1, r4, r6)     // Catch:{ JSONException -> 0x00da, Exception -> 0x00d8 }
            goto L_0x00e7
        L_0x00d8:
            r11 = move-exception
            goto L_0x00db
        L_0x00da:
            r11 = move-exception
        L_0x00db:
            com.huawei.android.pushagent.c.a.e.d(r5, r3, r11)
        L_0x00de:
            com.huawei.android.pushselfshow.richpush.html.api.NativeToJsMessageQueue r11 = r10.a
            java.lang.String r0 = r10.b
            com.huawei.android.pushselfshow.richpush.html.api.d$a r1 = com.huawei.android.pushselfshow.richpush.html.api.d.a.JSON_EXCEPTION
            r11.a(r0, r1, r4, r6)
        L_0x00e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.richpush.html.a.k.a(org.json.JSONObject):void");
    }

    public String a(String str, JSONObject jSONObject) {
        return null;
    }

    public void a(int i, int i2, Intent intent) {
    }

    public void a(NativeToJsMessageQueue nativeToJsMessageQueue, String str, String str2, JSONObject jSONObject) {
        if (nativeToJsMessageQueue == null) {
            e.a("PushSelfShowLog", "jsMessageQueue is null while run into Video Player exec");
            return;
        }
        this.a = nativeToJsMessageQueue;
        if ("playVideo".equals(str)) {
            d();
            if (str2 != null) {
                this.b = str2;
                a(jSONObject);
                return;
            }
            e.a("PushSelfShowLog", "Audio exec callback is null ");
            return;
        }
        nativeToJsMessageQueue.a(str2, d.a.METHOD_NOT_FOUND_EXCEPTION, "error", (JSONObject) null);
    }

    public void b() {
    }

    public void c() {
        d();
    }

    public void d() {
        this.b = null;
        this.d = null;
    }
}
