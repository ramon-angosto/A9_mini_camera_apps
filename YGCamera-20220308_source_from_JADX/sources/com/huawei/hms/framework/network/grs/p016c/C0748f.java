package com.huawei.hms.framework.network.grs.p016c;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.framework.common.Logger;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;

/* renamed from: com.huawei.hms.framework.network.grs.c.f */
public class C0748f {

    /* renamed from: a */
    private static final String f530a = "f";

    /* renamed from: b */
    private Map<String, List<String>> f531b;

    /* renamed from: c */
    private byte[] f532c;

    /* renamed from: d */
    private int f533d = 0;

    /* renamed from: e */
    private long f534e;

    /* renamed from: f */
    private long f535f;

    /* renamed from: g */
    private long f536g;

    /* renamed from: h */
    private String f537h;

    /* renamed from: i */
    private int f538i = 2;

    /* renamed from: j */
    private int f539j = ConnectionResult.RESOLUTION_REQUIRED;

    /* renamed from: k */
    private String f540k = "";

    /* renamed from: l */
    private String f541l = "";

    /* renamed from: m */
    private String f542m = "";

    /* renamed from: n */
    private long f543n = 0;

    /* renamed from: o */
    private Exception f544o;

    /* renamed from: p */
    private String f545p;

    /* renamed from: q */
    private int f546q;

    public C0748f(int i, Map<String, List<String>> map, byte[] bArr, long j) {
        this.f533d = i;
        this.f531b = map;
        this.f532c = ByteBuffer.wrap(bArr).array();
        this.f534e = j;
        m607q();
    }

    public C0748f(Exception exc, long j) {
        this.f544o = exc;
        this.f534e = j;
    }

    /* renamed from: a */
    private void m595a(Map<String, String> map) {
        long j;
        if (map == null || map.size() <= 0) {
            Logger.m478w(f530a, "getExpireTime {headers == null} or {headers.size() <= 0}");
            return;
        }
        if (map.containsKey(HttpHeaders.CACHE_CONTROL)) {
            String str = map.get(HttpHeaders.CACHE_CONTROL);
            if (!TextUtils.isEmpty(str) && str.contains("max-age=")) {
                try {
                    j = Long.parseLong(str.substring(str.indexOf("max-age=") + 8));
                    try {
                        Logger.m477v(f530a, "Cache-Control value{%s}", Long.valueOf(j));
                    } catch (NumberFormatException e) {
                        e = e;
                    }
                } catch (NumberFormatException e2) {
                    e = e2;
                    j = 0;
                    Logger.m479w(f530a, "getExpireTime addHeadersToResult NumberFormatException", (Throwable) e);
                    j = 86400;
                    long j2 = j * 1000;
                    Logger.m477v(f530a, "convert expireTime{%s}", Long.valueOf(j2));
                    m597b(String.valueOf(j2 + System.currentTimeMillis()));
                }
                if (j <= 0 || j > 2592000) {
                    j = 86400;
                }
                long j22 = j * 1000;
                Logger.m477v(f530a, "convert expireTime{%s}", Long.valueOf(j22));
                m597b(String.valueOf(j22 + System.currentTimeMillis()));
            }
        } else if (map.containsKey(HttpHeaders.EXPIRES)) {
            String str2 = map.get(HttpHeaders.EXPIRES);
            Logger.m477v(f530a, "expires is{%s}", str2);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.ROOT);
            String str3 = null;
            if (map.containsKey(HttpHeaders.DATE)) {
                str3 = map.get(HttpHeaders.DATE);
            }
            try {
                j = (simpleDateFormat.parse(str2).getTime() - (TextUtils.isEmpty(str3) ? new Date() : simpleDateFormat.parse(str3)).getTime()) / 1000;
            } catch (ParseException e3) {
                Logger.m479w(f530a, "getExpireTime ParseException.", (Throwable) e3);
            }
            j = 86400;
            long j222 = j * 1000;
            Logger.m477v(f530a, "convert expireTime{%s}", Long.valueOf(j222));
            m597b(String.valueOf(j222 + System.currentTimeMillis()));
        } else {
            Logger.m474i(f530a, "response headers neither contains Cache-Control nor Expires.");
        }
        j = 0;
        j = 86400;
        long j2222 = j * 1000;
        Logger.m477v(f530a, "convert expireTime{%s}", Long.valueOf(j2222));
        m597b(String.valueOf(j2222 + System.currentTimeMillis()));
    }

    /* renamed from: b */
    private void m596b(int i) {
        this.f539j = i;
    }

    /* renamed from: b */
    private void m597b(String str) {
        this.f542m = str;
    }

    /* renamed from: b */
    private void m598b(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            Logger.m478w(f530a, "getExpireTime {headers == null} or {headers.size() <= 0}");
            return;
        }
        long j = 0;
        if (map.containsKey("Retry-After")) {
            String str = map.get("Retry-After");
            if (!TextUtils.isEmpty(str)) {
                try {
                    j = Long.parseLong(str);
                } catch (NumberFormatException e) {
                    Logger.m479w(f530a, "getRetryAfter addHeadersToResult NumberFormatException", (Throwable) e);
                }
            }
        }
        long j2 = j * 1000;
        Logger.m477v(f530a, "convert retry-afterTime{%s}", Long.valueOf(j2));
        m600c(j2);
    }

    /* renamed from: c */
    private void m599c(int i) {
        this.f538i = i;
    }

    /* renamed from: c */
    private void m600c(long j) {
        this.f543n = j;
    }

    /* renamed from: c */
    private void m601c(String str) {
        this.f540k = str;
    }

    /* renamed from: d */
    private void m602d(String str) {
        this.f541l = str;
    }

    /* renamed from: e */
    private void m603e(String str) {
        this.f537h = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004a A[SYNTHETIC, Splitter:B:20:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0057 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0088 A[Catch:{ JSONException -> 0x0096 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* renamed from: n */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m604n() {
        /*
            r10 = this;
            java.lang.String r0 = "errorDesc"
            java.lang.String r1 = "errorList"
            java.lang.String r2 = "errorCode"
            java.lang.String r3 = "isSuccess"
            boolean r4 = r10.mo13877m()
            r5 = 2
            if (r4 != 0) goto L_0x001a
            java.lang.String r0 = f530a
            java.lang.String r1 = "GRSSDK parse server body all failed."
            com.huawei.hms.framework.common.Logger.m474i(r0, r1)
            r10.m599c((int) r5)
            return
        L_0x001a:
            byte[] r4 = r10.f532c     // Catch:{ JSONException -> 0x0096 }
            java.lang.String r4 = com.huawei.hms.framework.common.StringUtils.byte2Str(r4)     // Catch:{ JSONException -> 0x0096 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0096 }
            r6.<init>(r4)     // Catch:{ JSONException -> 0x0096 }
            r7 = -1
            boolean r8 = r6.has(r3)     // Catch:{ JSONException -> 0x0096 }
            java.lang.String r9 = "resultCode"
            if (r8 == 0) goto L_0x002f
            goto L_0x0036
        L_0x002f:
            boolean r3 = r6.has(r9)     // Catch:{ JSONException -> 0x0096 }
            if (r3 == 0) goto L_0x003b
            r3 = r9
        L_0x0036:
            int r7 = r6.getInt(r3)     // Catch:{ JSONException -> 0x0096 }
            goto L_0x0042
        L_0x003b:
            java.lang.String r3 = f530a     // Catch:{ JSONException -> 0x0096 }
            java.lang.String r8 = "sth. wrong because server errorcode's key."
            com.huawei.hms.framework.common.Logger.m471e(r3, r8)     // Catch:{ JSONException -> 0x0096 }
        L_0x0042:
            r10.m599c((int) r7)     // Catch:{ JSONException -> 0x0096 }
            r3 = 1
            java.lang.String r8 = "services"
            if (r7 != 0) goto L_0x0052
            boolean r4 = r4.contains(r8)     // Catch:{ JSONException -> 0x0096 }
            if (r4 == 0) goto L_0x0052
            r4 = 1
            goto L_0x0053
        L_0x0052:
            r4 = 0
        L_0x0053:
            java.lang.String r9 = ""
            if (r7 == r3) goto L_0x007b
            if (r4 == 0) goto L_0x005a
            goto L_0x007b
        L_0x005a:
            r10.m599c((int) r5)     // Catch:{ JSONException -> 0x0096 }
            boolean r1 = r6.has(r2)     // Catch:{ JSONException -> 0x0096 }
            if (r1 == 0) goto L_0x0068
            int r1 = r6.getInt(r2)     // Catch:{ JSONException -> 0x0096 }
            goto L_0x006a
        L_0x0068:
            r1 = 9001(0x2329, float:1.2613E-41)
        L_0x006a:
            r10.m596b((int) r1)     // Catch:{ JSONException -> 0x0096 }
            boolean r1 = r6.has(r0)     // Catch:{ JSONException -> 0x0096 }
            if (r1 == 0) goto L_0x0077
            java.lang.String r9 = r6.getString(r0)     // Catch:{ JSONException -> 0x0096 }
        L_0x0077:
            r10.m601c((java.lang.String) r9)     // Catch:{ JSONException -> 0x0096 }
            goto L_0x00a1
        L_0x007b:
            org.json.JSONObject r0 = r6.getJSONObject(r8)     // Catch:{ JSONException -> 0x0096 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0096 }
            r10.m603e(r0)     // Catch:{ JSONException -> 0x0096 }
            if (r4 == 0) goto L_0x00a1
            boolean r0 = r6.has(r1)     // Catch:{ JSONException -> 0x0096 }
            if (r0 == 0) goto L_0x0092
            java.lang.String r9 = r6.getString(r1)     // Catch:{ JSONException -> 0x0096 }
        L_0x0092:
            r10.m602d(r9)     // Catch:{ JSONException -> 0x0096 }
            goto L_0x00a1
        L_0x0096:
            r0 = move-exception
            java.lang.String r1 = f530a
            java.lang.String r2 = "GrsResponse GrsResponse(String result) JSONException"
            com.huawei.hms.framework.common.Logger.m479w((java.lang.String) r1, (java.lang.String) r2, (java.lang.Throwable) r0)
            r10.m599c((int) r5)
        L_0x00a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p016c.C0748f.m604n():void");
    }

    /* renamed from: o */
    private void m605o() {
        if (mo13877m() || mo13876l()) {
            Map<String, String> p = m606p();
            try {
                if (mo13877m()) {
                    m595a(p);
                }
                if (mo13876l()) {
                    m598b(p);
                }
            } catch (JSONException e) {
                Logger.m479w(f530a, "parseHeader catch JSONException", (Throwable) e);
            }
        }
    }

    /* renamed from: p */
    private Map<String, String> m606p() {
        HashMap hashMap = new HashMap(16);
        Map<String, List<String>> map = this.f531b;
        if (map == null || map.size() <= 0) {
            Logger.m476v(f530a, "parseRespHeaders {respHeaders == null} or {respHeaders.size() <= 0}");
            return hashMap;
        }
        for (Map.Entry next : this.f531b.entrySet()) {
            hashMap.put((String) next.getKey(), ((List) next.getValue()).get(0));
        }
        return hashMap;
    }

    /* renamed from: q */
    private void m607q() {
        m605o();
        m604n();
    }

    /* renamed from: a */
    public String mo13861a() {
        return this.f542m;
    }

    /* renamed from: a */
    public void mo13862a(int i) {
        this.f546q = i;
    }

    /* renamed from: a */
    public void mo13863a(long j) {
        this.f536g = j;
    }

    /* renamed from: a */
    public void mo13864a(String str) {
        this.f545p = str;
    }

    /* renamed from: b */
    public int mo13865b() {
        return this.f533d;
    }

    /* renamed from: b */
    public void mo13866b(long j) {
        this.f535f = j;
    }

    /* renamed from: c */
    public int mo13867c() {
        return this.f539j;
    }

    /* renamed from: d */
    public Exception mo13868d() {
        return this.f544o;
    }

    /* renamed from: e */
    public int mo13869e() {
        return this.f538i;
    }

    /* renamed from: f */
    public long mo13870f() {
        return this.f536g;
    }

    /* renamed from: g */
    public long mo13871g() {
        return this.f535f;
    }

    /* renamed from: h */
    public long mo13872h() {
        return this.f534e;
    }

    /* renamed from: i */
    public String mo13873i() {
        return this.f537h;
    }

    /* renamed from: j */
    public long mo13874j() {
        return this.f543n;
    }

    /* renamed from: k */
    public String mo13875k() {
        return this.f545p;
    }

    /* renamed from: l */
    public boolean mo13876l() {
        return this.f533d == 503;
    }

    /* renamed from: m */
    public boolean mo13877m() {
        return this.f533d == 200;
    }
}
