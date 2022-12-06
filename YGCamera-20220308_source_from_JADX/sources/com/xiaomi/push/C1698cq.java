package com.xiaomi.push;

import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.mipush.sdk.Constants;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.cq */
public class C1698cq {

    /* renamed from: a */
    private double f1954a = 0.1d;

    /* renamed from: a */
    private long f1955a;

    /* renamed from: a */
    public String f1956a = "";

    /* renamed from: a */
    private ArrayList<C1710cz> f1957a = new ArrayList<>();

    /* renamed from: b */
    private long f1958b = 86400000;

    /* renamed from: b */
    public String f1959b;

    /* renamed from: c */
    public String f1960c;

    /* renamed from: d */
    public String f1961d;

    /* renamed from: e */
    public String f1962e;

    /* renamed from: f */
    public String f1963f;

    /* renamed from: g */
    public String f1964g;

    /* renamed from: h */
    protected String f1965h;

    /* renamed from: i */
    private String f1966i;

    /* renamed from: j */
    private String f1967j = "s.mi1.cc";

    public C1698cq(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f1955a = System.currentTimeMillis();
            this.f1957a.add(new C1710cz(str, -1));
            this.f1956a = C1702cu.mo17360a();
            this.f1959b = str;
            return;
        }
        throw new IllegalArgumentException("the host is empty");
    }

    /* renamed from: c */
    private synchronized void m2874c(String str) {
        Iterator<C1710cz> it = this.f1957a.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f1994a, str)) {
                it.remove();
            }
        }
    }

    /* renamed from: a */
    public synchronized C1698cq mo17330a(JSONObject jSONObject) {
        this.f1956a = jSONObject.optString("net");
        this.f1958b = jSONObject.getLong(RemoteMessageConst.TTL);
        this.f1954a = jSONObject.getDouble("pct");
        this.f1955a = jSONObject.getLong("ts");
        this.f1961d = jSONObject.optString("city");
        this.f1960c = jSONObject.optString("prv");
        this.f1964g = jSONObject.optString("cty");
        this.f1962e = jSONObject.optString("isp");
        this.f1963f = jSONObject.optString("ip");
        this.f1959b = jSONObject.optString("host");
        this.f1965h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            mo17336a(new C1710cz().mo17375a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    /* renamed from: a */
    public synchronized String mo17331a() {
        if (!TextUtils.isEmpty(this.f1966i)) {
            return this.f1966i;
        } else if (TextUtils.isEmpty(this.f1962e)) {
            return "hardcode_isp";
        } else {
            this.f1966i = C1663bo.m2732a((Object[]) new String[]{this.f1962e, this.f1960c, this.f1961d, this.f1964g, this.f1963f}, "_");
            return this.f1966i;
        }
    }

    /* renamed from: a */
    public synchronized ArrayList<String> m2877a() {
        return mo17333a(false);
    }

    /* renamed from: a */
    public ArrayList<String> mo17332a(String str) {
        if (!TextUtils.isEmpty(str)) {
            URL url = new URL(str);
            if (TextUtils.equals(url.getHost(), this.f1959b)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<String> it = mo17333a(true).iterator();
                while (it.hasNext()) {
                    C1700cs a = C1700cs.m2904a(it.next(), url.getPort());
                    arrayList.add(new URL(url.getProtocol(), a.mo17354a(), a.mo17354a(), url.getFile()).toString());
                }
                return arrayList;
            }
            throw new IllegalArgumentException("the url is not supported by the fallback");
        }
        throw new IllegalArgumentException("the url is empty.");
    }

    /* renamed from: a */
    public synchronized ArrayList<String> mo17333a(boolean z) {
        ArrayList<String> arrayList;
        String substring;
        C1710cz[] czVarArr = new C1710cz[this.f1957a.size()];
        this.f1957a.toArray(czVarArr);
        Arrays.sort(czVarArr);
        arrayList = new ArrayList<>();
        for (C1710cz czVar : czVarArr) {
            if (z) {
                substring = czVar.f1994a;
            } else {
                int indexOf = czVar.f1994a.indexOf(Constants.COLON_SEPARATOR);
                substring = indexOf != -1 ? czVar.f1994a.substring(0, indexOf) : czVar.f1994a;
            }
            arrayList.add(substring);
        }
        return arrayList;
    }

    /* renamed from: a */
    public synchronized JSONObject m2880a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.f1956a);
        jSONObject.put(RemoteMessageConst.TTL, this.f1958b);
        jSONObject.put("pct", this.f1954a);
        jSONObject.put("ts", this.f1955a);
        jSONObject.put("city", this.f1961d);
        jSONObject.put("prv", this.f1960c);
        jSONObject.put("cty", this.f1964g);
        jSONObject.put("isp", this.f1962e);
        jSONObject.put("ip", this.f1963f);
        jSONObject.put("host", this.f1959b);
        jSONObject.put("xf", this.f1965h);
        JSONArray jSONArray = new JSONArray();
        Iterator<C1710cz> it = this.f1957a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().mo17376a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    /* renamed from: a */
    public void mo17334a(double d) {
        this.f1954a = d;
    }

    /* renamed from: a */
    public void mo17335a(long j) {
        if (j > 0) {
            this.f1958b = j;
            return;
        }
        throw new IllegalArgumentException("the duration is invalid " + j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo17336a(C1710cz czVar) {
        m2874c(czVar.f1994a);
        this.f1957a.add(czVar);
    }

    /* renamed from: a */
    public synchronized void m2884a(String str) {
        mo17336a(new C1710cz(str));
    }

    /* renamed from: a */
    public void mo17337a(String str, int i, long j, long j2, Exception exc) {
        mo17340a(str, new C1697cp(i, j, j2, exc));
    }

    /* renamed from: a */
    public void mo17338a(String str, long j, long j2) {
        try {
            mo17344b(new URL(str).getHost(), j, j2);
        } catch (MalformedURLException unused) {
        }
    }

    /* renamed from: a */
    public void mo17339a(String str, long j, long j2, Exception exc) {
        try {
            mo17345b(new URL(str).getHost(), j, j2, exc);
        } catch (MalformedURLException unused) {
        }
    }

    /* renamed from: a */
    public synchronized void mo17340a(String str, C1697cp cpVar) {
        Iterator<C1710cz> it = this.f1957a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C1710cz next = it.next();
            if (TextUtils.equals(str, next.f1994a)) {
                next.mo17377a(cpVar);
                break;
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo17341a(String[] strArr) {
        int i;
        int size = this.f1957a.size() - 1;
        while (true) {
            i = 0;
            if (size < 0) {
                break;
            }
            int length = strArr.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (TextUtils.equals(this.f1957a.get(size).f1994a, strArr[i])) {
                    this.f1957a.remove(size);
                    break;
                }
                i++;
            }
            size--;
        }
        Iterator<C1710cz> it = this.f1957a.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            C1710cz next = it.next();
            if (next.f1992a > i2) {
                i2 = next.f1992a;
            }
        }
        while (i < strArr.length) {
            mo17336a(new C1710cz(strArr[i], (strArr.length + i2) - i));
            i++;
        }
    }

    /* renamed from: a */
    public boolean m2890a() {
        return TextUtils.equals(this.f1956a, C1702cu.mo17360a());
    }

    /* renamed from: a */
    public boolean mo17342a(C1698cq cqVar) {
        return TextUtils.equals(this.f1956a, cqVar.f1956a);
    }

    /* renamed from: b */
    public void mo17343b(String str) {
        this.f1967j = str;
    }

    /* renamed from: b */
    public void mo17344b(String str, long j, long j2) {
        mo17337a(str, 0, j, j2, (Exception) null);
    }

    /* renamed from: b */
    public void mo17345b(String str, long j, long j2, Exception exc) {
        mo17337a(str, -1, j, j2, exc);
    }

    /* renamed from: b */
    public boolean mo17346b() {
        return System.currentTimeMillis() - this.f1955a < this.f1958b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo17347c() {
        long j = this.f1958b;
        if (864000000 >= j) {
            j = 864000000;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.f1955a;
        return currentTimeMillis - j2 > j || (currentTimeMillis - j2 > this.f1958b && this.f1956a.startsWith("WIFI-"));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1956a);
        sb.append("\n");
        sb.append(mo17331a());
        Iterator<C1710cz> it = this.f1957a.iterator();
        while (it.hasNext()) {
            sb.append("\n");
            sb.append(it.next().toString());
        }
        sb.append("\n");
        return sb.toString();
    }
}
