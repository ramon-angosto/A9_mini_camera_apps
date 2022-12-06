package com.xiaomi.push;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.p003os.EnvironmentCompat;
import com.bumptech.glide.load.Key;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.C1966a;
import com.xiaomi.push.service.module.PushChannelRegion;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.cu */
public class C1702cu {

    /* renamed from: a */
    protected static Context f1972a;

    /* renamed from: a */
    private static C1703a f1973a;

    /* renamed from: a */
    private static C1702cu f1974a;

    /* renamed from: a */
    protected static boolean f1975a = false;

    /* renamed from: b */
    protected static final Map<String, C1698cq> f1976b = new HashMap();

    /* renamed from: c */
    private static String f1977c;

    /* renamed from: d */
    private static String f1978d;

    /* renamed from: a */
    private long f1979a;

    /* renamed from: a */
    private C1701ct f1980a;

    /* renamed from: a */
    protected C1704b f1981a;

    /* renamed from: a */
    private String f1982a;

    /* renamed from: a */
    protected final Map<String, C1699cr> f1983a;

    /* renamed from: b */
    private final long f1984b;

    /* renamed from: b */
    private String f1985b;

    /* renamed from: c */
    private long f1986c;

    /* renamed from: com.xiaomi.push.cu$a */
    public interface C1703a {
        /* renamed from: a */
        C1702cu mo17370a(Context context, C1701ct ctVar, C1704b bVar, String str);
    }

    /* renamed from: com.xiaomi.push.cu$b */
    public interface C1704b {
        /* renamed from: a */
        String mo17371a(String str);
    }

    protected C1702cu(Context context, C1701ct ctVar, C1704b bVar, String str) {
        this(context, ctVar, bVar, str, (String) null, (String) null);
    }

    protected C1702cu(Context context, C1701ct ctVar, C1704b bVar, String str, String str2, String str3) {
        this.f1983a = new HashMap();
        this.f1982a = "0";
        this.f1979a = 0;
        this.f1984b = 15;
        this.f1986c = 0;
        this.f1985b = "isp_prov_city_country_ip";
        this.f1981a = bVar;
        this.f1980a = ctVar == null ? new C1705cv(this) : ctVar;
        this.f1982a = str;
        f1977c = str2 == null ? context.getPackageName() : str2;
        f1978d = str3 == null ? m2916f() : str3;
    }

    /* renamed from: a */
    public static synchronized C1702cu mo17360a() {
        C1702cu cuVar;
        synchronized (C1702cu.class) {
            if (f1974a != null) {
                cuVar = f1974a;
            } else {
                throw new IllegalStateException("the host manager is not initialized yet.");
            }
        }
        return cuVar;
    }

    /* renamed from: a */
    static String m2910a() {
        NetworkInfo activeNetworkInfo;
        Context context = f1972a;
        if (context == null) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return EnvironmentCompat.MEDIA_UNKNOWN;
            }
            if (activeNetworkInfo.getType() == 1) {
                WifiManager wifiManager = (WifiManager) f1972a.getSystemService("wifi");
                if (!(wifiManager == null || wifiManager.getConnectionInfo() == null)) {
                    return "WIFI-" + wifiManager.getConnectionInfo().getSSID();
                }
                return EnvironmentCompat.MEDIA_UNKNOWN;
            }
            return activeNetworkInfo.getTypeName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + activeNetworkInfo.getSubtypeName();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    static String mo17357a(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes(Key.STRING_CHARSET_NAME);
            for (int i = 0; i < bytes.length; i++) {
                byte b = bytes[i];
                byte b2 = b & 240;
                if (b2 != 240) {
                    bytes[i] = (byte) (((b & 15) ^ ((byte) (((b >> 4) + length) & 15))) | b2);
                }
            }
            return new String(bytes);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    /* renamed from: a */
    private ArrayList<C1698cq> m2912a(ArrayList<String> arrayList) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        ArrayList<String> arrayList2 = arrayList;
        mo17367d();
        synchronized (this.f1983a) {
            mo17360a();
            for (String next : this.f1983a.keySet()) {
                if (!arrayList2.contains(next)) {
                    arrayList2.add(next);
                }
            }
        }
        synchronized (f1976b) {
            for (Object obj : f1976b.values().toArray()) {
                C1698cq cqVar = (C1698cq) obj;
                if (!cqVar.mo17346b()) {
                    f1976b.remove(cqVar.f1959b);
                }
            }
        }
        if (!arrayList2.contains(mo17363b())) {
            arrayList2.add(mo17363b());
        }
        ArrayList<C1698cq> arrayList3 = new ArrayList<>(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList3.add((Object) null);
        }
        try {
            String str = C1653bi.m2688e(f1972a) ? "wifi" : "wap";
            String a = mo17359a(arrayList2, str, this.f1982a, true);
            if (!TextUtils.isEmpty(a)) {
                JSONObject jSONObject3 = new JSONObject(a);
                C1524b.m2158b(a);
                if ("OK".equalsIgnoreCase(jSONObject3.getString("S"))) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("R");
                    String string = jSONObject4.getString("province");
                    String string2 = jSONObject4.getString("city");
                    String string3 = jSONObject4.getString("isp");
                    String string4 = jSONObject4.getString("ip");
                    String string5 = jSONObject4.getString("country");
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(str);
                    C1524b.m2159c("get bucket: net=" + string3 + ", hosts=" + jSONObject5.toString());
                    int i2 = 0;
                    while (i2 < arrayList.size()) {
                        String str2 = arrayList2.get(i2);
                        JSONArray optJSONArray = jSONObject5.optJSONArray(str2);
                        if (optJSONArray == null) {
                            C1524b.m2141a("no bucket found for " + str2);
                            jSONObject = jSONObject5;
                        } else {
                            C1698cq cqVar2 = new C1698cq(str2);
                            int i3 = 0;
                            while (i3 < optJSONArray.length()) {
                                String string6 = optJSONArray.getString(i3);
                                if (!TextUtils.isEmpty(string6)) {
                                    jSONObject2 = jSONObject5;
                                    cqVar2.mo17336a(new C1710cz(string6, optJSONArray.length() - i3));
                                } else {
                                    jSONObject2 = jSONObject5;
                                }
                                i3++;
                                jSONObject5 = jSONObject2;
                            }
                            jSONObject = jSONObject5;
                            arrayList3.set(i2, cqVar2);
                            cqVar2.f1964g = string5;
                            cqVar2.f1960c = string;
                            cqVar2.f1962e = string3;
                            cqVar2.f1963f = string4;
                            cqVar2.f1961d = string2;
                            if (jSONObject4.has("stat-percent")) {
                                cqVar2.mo17334a(jSONObject4.getDouble("stat-percent"));
                            }
                            if (jSONObject4.has("stat-domain")) {
                                cqVar2.mo17343b(jSONObject4.getString("stat-domain"));
                            }
                            if (jSONObject4.has(RemoteMessageConst.TTL)) {
                                cqVar2.mo17335a(((long) jSONObject4.getInt(RemoteMessageConst.TTL)) * 1000);
                            }
                            mo17357a(cqVar2.mo17331a());
                        }
                        i2++;
                        jSONObject5 = jSONObject;
                    }
                    JSONObject optJSONObject = jSONObject4.optJSONObject("reserved");
                    if (optJSONObject != null) {
                        long j = 604800000;
                        if (jSONObject4.has("reserved-ttl")) {
                            j = ((long) jSONObject4.getInt("reserved-ttl")) * 1000;
                        }
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next2 = keys.next();
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray(next2);
                            if (optJSONArray2 == null) {
                                C1524b.m2141a("no bucket found for " + next2);
                            } else {
                                C1698cq cqVar3 = new C1698cq(next2);
                                cqVar3.mo17335a(j);
                                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                                    String string7 = optJSONArray2.getString(i4);
                                    if (!TextUtils.isEmpty(string7)) {
                                        cqVar3.mo17336a(new C1710cz(string7, optJSONArray2.length() - i4));
                                    }
                                }
                                synchronized (f1976b) {
                                    if (this.f1980a.mo17356a(next2)) {
                                        f1976b.put(next2, cqVar3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            C1524b.m2141a("failed to get bucket " + e.getMessage());
        }
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            C1698cq cqVar4 = arrayList3.get(i5);
            if (cqVar4 != null) {
                mo17361a(arrayList2.get(i5), cqVar4);
            }
        }
        mo17365c();
        return arrayList3;
    }

    /* renamed from: a */
    public static synchronized void m2913a(Context context, C1701ct ctVar, C1704b bVar, String str, String str2, String str3) {
        synchronized (C1702cu.class) {
            f1972a = context.getApplicationContext();
            if (f1972a == null) {
                f1972a = context;
            }
            if (f1974a == null) {
                if (f1973a == null) {
                    f1974a = new C1702cu(context, ctVar, bVar, str, str2, str3);
                } else {
                    f1974a = f1973a.mo17370a(context, ctVar, bVar, str);
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m2914a(C1703a aVar) {
        synchronized (C1702cu.class) {
            f1973a = aVar;
            f1974a = null;
        }
    }

    /* renamed from: a */
    public static void m2915a(String str, String str2) {
        C1698cq cqVar = f1976b.get(str);
        synchronized (f1976b) {
            if (cqVar == null) {
                C1698cq cqVar2 = new C1698cq(str);
                cqVar2.mo17335a(604800000);
                cqVar2.mo17332a(str2);
                f1976b.put(str, cqVar2);
            } else {
                cqVar.mo17332a(str2);
            }
        }
    }

    /* renamed from: f */
    private String m2916f() {
        try {
            PackageInfo packageInfo = f1972a.getPackageManager().getPackageInfo(f1972a.getPackageName(), 16384);
            return packageInfo != null ? packageInfo.versionName : "0";
        } catch (Exception unused) {
            return "0";
        }
    }

    /* renamed from: a */
    public C1698cq m2917a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return mo17358a(new URL(str).getHost(), true);
        }
        throw new IllegalArgumentException("the url is empty");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        r4 = mo17368e(r3);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.xiaomi.push.C1698cq mo17358a(java.lang.String r3, boolean r4) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L_0x0034
            com.xiaomi.push.ct r0 = r2.f1980a
            boolean r0 = r0.mo17356a(r3)
            if (r0 != 0) goto L_0x0010
            r3 = 0
            return r3
        L_0x0010:
            com.xiaomi.push.cq r0 = r2.mo17364c(r3)
            if (r0 == 0) goto L_0x001d
            boolean r1 = r0.mo17346b()
            if (r1 == 0) goto L_0x001d
            return r0
        L_0x001d:
            if (r4 == 0) goto L_0x002e
            android.content.Context r4 = f1972a
            boolean r4 = com.xiaomi.push.C1653bi.m2685b(r4)
            if (r4 == 0) goto L_0x002e
            com.xiaomi.push.cq r4 = r2.mo17368e(r3)
            if (r4 == 0) goto L_0x002e
            return r4
        L_0x002e:
            com.xiaomi.push.cw r4 = new com.xiaomi.push.cw
            r4.<init>(r2, r3, r0)
            return r4
        L_0x0034:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "the host is empty"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1702cu.mo17358a(java.lang.String, boolean):com.xiaomi.push.cq");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo17359a(ArrayList<String> arrayList, String str, String str2, boolean z) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<C1652bh> arrayList3 = new ArrayList<>();
        arrayList3.add(new C1650bf("type", str));
        if (str.equals("wap")) {
            arrayList3.add(new C1650bf("conpt", mo17357a(C1653bi.m2669a(f1972a))));
        }
        if (z) {
            arrayList3.add(new C1650bf("reserved", "1"));
        }
        arrayList3.add(new C1650bf("uuid", str2));
        arrayList3.add(new C1650bf("list", C1663bo.m2729a((Collection<?>) arrayList, Constants.ACCEPT_TIME_SEPARATOR_SP)));
        arrayList3.add(new C1650bf("countrycode", C1966a.m4862a(f1972a).mo18438b()));
        C1698cq c = mo17364c(mo17363b());
        String format = String.format(Locale.US, "https://%1$s/gslb/?ver=4.0", new Object[]{mo17363b()});
        if (c == null) {
            arrayList2.add(format);
            synchronized (f1976b) {
                C1698cq cqVar = f1976b.get("resolver.msg.xiaomi.net");
                if (cqVar != null) {
                    Iterator<String> it = cqVar.mo17333a(true).iterator();
                    while (it.hasNext()) {
                        arrayList2.add(String.format(Locale.US, "https://%1$s/gslb/?ver=4.0", new Object[]{it.next()}));
                    }
                }
            }
        } else {
            arrayList2 = c.mo17332a(format);
        }
        Iterator<String> it2 = arrayList2.iterator();
        IOException e = null;
        while (it2.hasNext()) {
            Uri.Builder buildUpon = Uri.parse(it2.next()).buildUpon();
            for (C1652bh bhVar : arrayList3) {
                buildUpon.appendQueryParameter(bhVar.mo17253a(), bhVar.mo17254b());
            }
            try {
                return this.f1981a == null ? C1653bi.m2676a(f1972a, new URL(buildUpon.toString())) : this.f1981a.mo17371a(buildUpon.toString());
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e == null) {
            return null;
        }
        C1524b.m2141a("network exception: " + e.getMessage());
        throw e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public JSONObject m2920a() {
        JSONObject jSONObject;
        synchronized (this.f1983a) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            JSONArray jSONArray = new JSONArray();
            for (C1699cr a : this.f1983a.values()) {
                jSONArray.put(a.mo17349a());
            }
            jSONObject.put(RemoteMessageConst.DATA, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (C1698cq a2 : f1976b.values()) {
                jSONArray2.put(a2.mo17331a());
            }
            jSONObject.put("reserved", jSONArray2);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public void m2921a() {
        synchronized (this.f1983a) {
            this.f1983a.clear();
        }
    }

    /* renamed from: a */
    public void m2922a(String str) {
        this.f1985b = str;
    }

    /* renamed from: a */
    public void mo17361a(String str, C1698cq cqVar) {
        if (TextUtils.isEmpty(str) || cqVar == null) {
            throw new IllegalArgumentException("the argument is invalid " + str + ", " + cqVar);
        } else if (this.f1980a.mo17356a(str)) {
            synchronized (this.f1983a) {
                mo17360a();
                if (this.f1983a.containsKey(str)) {
                    this.f1983a.get(str).mo17351a(cqVar);
                } else {
                    C1699cr crVar = new C1699cr(str);
                    crVar.mo17351a(cqVar);
                    this.f1983a.put(str, crVar);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean m2924a() {
        synchronized (this.f1983a) {
            if (f1975a) {
                return true;
            }
            f1975a = true;
            this.f1983a.clear();
            try {
                String d = mo17367d();
                if (!TextUtils.isEmpty(d)) {
                    mo17362b(d);
                    C1524b.m2158b("loading the new hosts succeed");
                    return true;
                }
            } catch (Throwable th) {
                C1524b.m2141a("load bucket failure: " + th.getMessage());
            }
        }
        return false;
    }

    /* renamed from: b */
    public C1698cq mo17362b(String str) {
        return mo17358a(str, true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo17363b() {
        String a = C1966a.m4862a(f1972a).mo18436a();
        return (TextUtils.isEmpty(a) || PushChannelRegion.China.name().equals(a)) ? "resolver.msg.xiaomi.net" : "resolver.msg.global.xiaomi.net";
    }

    /* renamed from: b */
    public void m2927b() {
        ArrayList arrayList;
        synchronized (this.f1983a) {
            mo17360a();
            arrayList = new ArrayList(this.f1983a.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                C1699cr crVar = this.f1983a.get(arrayList.get(size));
                if (!(crVar == null || crVar.mo17349a() == null)) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList<C1698cq> a = m2912a((ArrayList<String>) arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (a.get(i) != null) {
                mo17361a((String) arrayList.get(i), a.get(i));
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void m2928b(String str) {
        synchronized (this.f1983a) {
            this.f1983a.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") == 2) {
                JSONArray optJSONArray = jSONObject.optJSONArray(RemoteMessageConst.DATA);
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        C1699cr a = new C1699cr().mo17350a(optJSONArray.getJSONObject(i));
                        this.f1983a.put(a.mo17349a(), a);
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("reserved");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                        String optString = jSONObject2.optString("host");
                        if (!TextUtils.isEmpty(optString)) {
                            try {
                                C1698cq a2 = new C1698cq(optString).mo17330a(jSONObject2);
                                f1976b.put(a2.f1959b, a2);
                                C1524b.m2141a("load local reserved host for " + a2.f1959b);
                            } catch (JSONException unused) {
                                C1524b.m2141a("parse reserved host fail.");
                            }
                        }
                    }
                }
            } else {
                throw new JSONException("Bad version");
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C1698cq mo17364c(String str) {
        C1699cr crVar;
        C1698cq a;
        synchronized (this.f1983a) {
            mo17360a();
            crVar = this.f1983a.get(str);
        }
        if (crVar == null || (a = crVar.mo17349a()) == null) {
            return null;
        }
        return a;
    }

    /* renamed from: c */
    public String mo17365c() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.f1983a) {
            for (Map.Entry next : this.f1983a.entrySet()) {
                sb.append((String) next.getKey());
                sb.append(":\n");
                sb.append(((C1699cr) next.getValue()).toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* renamed from: c */
    public void m2931c() {
        synchronized (this.f1983a) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(f1972a.openFileOutput(mo17369e(), 0)));
                String jSONObject = mo17360a().toString();
                if (!TextUtils.isEmpty(jSONObject)) {
                    bufferedWriter.write(jSONObject);
                }
                bufferedWriter.close();
            } catch (Exception e) {
                C1524b.m2141a("persist bucket failure: " + e.getMessage());
            }
        }
    }

    /* renamed from: d */
    public C1698cq mo17366d(String str) {
        C1698cq cqVar;
        synchronized (f1976b) {
            cqVar = f1976b.get(str);
        }
        return cqVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo17367d() {
        BufferedReader bufferedReader;
        try {
            File file = new File(f1972a.getFilesDir(), mo17369e());
            if (file.isFile()) {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                        } else {
                            String sb2 = sb.toString();
                            C1608aa.m2491a((Closeable) bufferedReader);
                            return sb2;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        C1524b.m2141a("load host exception " + th.getMessage());
                        return null;
                    } finally {
                        C1608aa.m2491a((Closeable) bufferedReader);
                    }
                }
            } else {
                C1608aa.m2491a((Closeable) null);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            C1524b.m2141a("load host exception " + th.getMessage());
            return null;
        }
    }

    /* renamed from: d */
    public void m2934d() {
        synchronized (this.f1983a) {
            for (C1699cr a : this.f1983a.values()) {
                a.mo17352a(true);
            }
            while (true) {
                for (boolean z = false; !z; z = true) {
                    for (String next : this.f1983a.keySet()) {
                        if (this.f1983a.get(next).mo17349a().isEmpty()) {
                            this.f1983a.remove(next);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public C1698cq mo17368e(String str) {
        if (System.currentTimeMillis() - this.f1986c <= this.f1979a * 60 * 1000) {
            return null;
        }
        this.f1986c = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        C1698cq cqVar = m2912a((ArrayList<String>) arrayList).get(0);
        if (cqVar != null) {
            this.f1979a = 0;
            return cqVar;
        }
        long j = this.f1979a;
        if (j >= 15) {
            return null;
        }
        this.f1979a = j + 1;
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public String mo17369e() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) f1972a.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return "com.xiaomi";
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == Process.myPid()) {
                return next.processName;
            }
        }
        return "com.xiaomi";
    }
}
