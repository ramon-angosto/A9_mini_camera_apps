package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.xiaomi.push.gl */
public abstract class C1830gl {

    /* renamed from: a */
    private static long f2518a = 0;

    /* renamed from: a */
    protected static final String f2519a = Locale.getDefault().getLanguage().toLowerCase();

    /* renamed from: a */
    public static final DateFormat f2520a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    /* renamed from: b */
    private static String f2521b = null;

    /* renamed from: c */
    private static String f2522c = (C1844gw.m3800a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);

    /* renamed from: a */
    private C1836gp f2523a = null;

    /* renamed from: a */
    private List<C1826gi> f2524a = new CopyOnWriteArrayList();

    /* renamed from: a */
    private final Map<String, Object> f2525a = new HashMap();

    /* renamed from: d */
    private String f2526d = f2521b;

    /* renamed from: e */
    private String f2527e = null;

    /* renamed from: f */
    private String f2528f = null;

    /* renamed from: g */
    private String f2529g = null;

    /* renamed from: h */
    private String f2530h = null;

    /* renamed from: i */
    private String f2531i = null;

    static {
        f2520a.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public C1830gl() {
    }

    public C1830gl(Bundle bundle) {
        this.f2528f = bundle.getString("ext_to");
        this.f2529g = bundle.getString("ext_from");
        this.f2530h = bundle.getString("ext_chid");
        this.f2527e = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f2524a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                C1826gi a = C1826gi.m3706a((Bundle) parcelable);
                if (a != null) {
                    this.f2524a.add(a);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f2523a = new C1836gp(bundle2);
        }
    }

    /* renamed from: i */
    public static synchronized String m3747i() {
        String sb;
        synchronized (C1830gl.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(f2522c);
            long j = f2518a;
            f2518a = 1 + j;
            sb2.append(Long.toString(j));
            sb = sb2.toString();
        }
        return sb;
    }

    /* renamed from: q */
    public static String m3748q() {
        return f2519a;
    }

    /* renamed from: a */
    public Bundle mo17698a() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.f2526d)) {
            bundle.putString("ext_ns", this.f2526d);
        }
        if (!TextUtils.isEmpty(this.f2529g)) {
            bundle.putString("ext_from", this.f2529g);
        }
        if (!TextUtils.isEmpty(this.f2528f)) {
            bundle.putString("ext_to", this.f2528f);
        }
        if (!TextUtils.isEmpty(this.f2527e)) {
            bundle.putString("ext_pkt_id", this.f2527e);
        }
        if (!TextUtils.isEmpty(this.f2530h)) {
            bundle.putString("ext_chid", this.f2530h);
        }
        C1836gp gpVar = this.f2523a;
        if (gpVar != null) {
            bundle.putBundle("ext_ERROR", gpVar.mo17742a());
        }
        List<C1826gi> list = this.f2524a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i = 0;
            for (C1826gi a : this.f2524a) {
                Bundle a2 = a.mo17691a();
                if (a2 != null) {
                    bundleArr[i] = a2;
                    i++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    /* renamed from: a */
    public C1826gi mo17703a(String str) {
        return mo17704a(str, (String) null);
    }

    /* renamed from: a */
    public C1826gi mo17704a(String str, String str2) {
        for (C1826gi next : this.f2524a) {
            if ((str2 == null || str2.equals(next.mo17694b())) && str.equals(next.mo17691a())) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    public C1836gp m3752a() {
        return this.f2523a;
    }

    /* renamed from: a */
    public synchronized Object m3753a(String str) {
        if (this.f2525a == null) {
            return null;
        }
        return this.f2525a.get(str);
    }

    /* renamed from: a */
    public abstract String m3754a();

    /* renamed from: a */
    public synchronized Collection<C1826gi> m3755a() {
        if (this.f2524a == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(this.f2524a));
    }

    /* renamed from: a */
    public void mo17724a(C1826gi giVar) {
        this.f2524a.add(giVar);
    }

    /* renamed from: a */
    public void mo17725a(C1836gp gpVar) {
        this.f2523a = gpVar;
    }

    /* renamed from: b */
    public synchronized Collection<String> mo17701b() {
        if (this.f2525a == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.f2525a.keySet()));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1830gl glVar = (C1830gl) obj;
        C1836gp gpVar = this.f2523a;
        if (gpVar == null ? glVar.f2523a != null : !gpVar.equals(glVar.f2523a)) {
            return false;
        }
        String str = this.f2529g;
        if (str == null ? glVar.f2529g != null : !str.equals(glVar.f2529g)) {
            return false;
        }
        if (!this.f2524a.equals(glVar.f2524a)) {
            return false;
        }
        String str2 = this.f2527e;
        if (str2 == null ? glVar.f2527e != null : !str2.equals(glVar.f2527e)) {
            return false;
        }
        String str3 = this.f2530h;
        if (str3 == null ? glVar.f2530h != null : !str3.equals(glVar.f2530h)) {
            return false;
        }
        Map<String, Object> map = this.f2525a;
        if (map == null ? glVar.f2525a != null : !map.equals(glVar.f2525a)) {
            return false;
        }
        String str4 = this.f2528f;
        if (str4 == null ? glVar.f2528f != null : !str4.equals(glVar.f2528f)) {
            return false;
        }
        String str5 = this.f2526d;
        String str6 = glVar.f2526d;
        if (str5 != null) {
            return str5.equals(str6);
        }
        if (str6 == null) {
            return true;
        }
    }

    public int hashCode() {
        String str = this.f2526d;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f2527e;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f2528f;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f2529g;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f2530h;
        int hashCode5 = (((((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.f2524a.hashCode()) * 31) + this.f2525a.hashCode()) * 31;
        C1836gp gpVar = this.f2523a;
        if (gpVar != null) {
            i = gpVar.hashCode();
        }
        return hashCode5 + i;
    }

    /* renamed from: j */
    public String mo17726j() {
        if ("ID_NOT_AVAILABLE".equals(this.f2527e)) {
            return null;
        }
        if (this.f2527e == null) {
            this.f2527e = m3747i();
        }
        return this.f2527e;
    }

    /* renamed from: k */
    public String mo17727k() {
        return this.f2530h;
    }

    /* renamed from: k */
    public void mo17728k(String str) {
        this.f2527e = str;
    }

    /* renamed from: l */
    public String mo17729l() {
        return this.f2528f;
    }

    /* renamed from: l */
    public void mo17730l(String str) {
        this.f2530h = str;
    }

    /* renamed from: m */
    public String mo17731m() {
        return this.f2529g;
    }

    /* renamed from: m */
    public void mo17732m(String str) {
        this.f2528f = str;
    }

    /* renamed from: n */
    public String mo17733n() {
        return this.f2531i;
    }

    /* renamed from: n */
    public void mo17734n(String str) {
        this.f2529g = str;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(14:32|33|34|35|36|37|38|39|40|41|42|60|62|63) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:64|(0)|(0)|72|73) */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x010e, code lost:
        if (r4 == null) goto L_0x0111;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f0 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:72:0x0125 */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0109 A[SYNTHETIC, Splitter:B:56:0x0109] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x011b A[SYNTHETIC, Splitter:B:66:0x011b] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0122 A[SYNTHETIC, Splitter:B:70:0x0122] */
    /* renamed from: o */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String mo17735o() {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0131 }
            r0.<init>()     // Catch:{ all -> 0x0131 }
            java.util.Collection r1 = r6.mo17698a()     // Catch:{ all -> 0x0131 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0131 }
        L_0x000e:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0131 }
            if (r2 == 0) goto L_0x0022
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0131 }
            com.xiaomi.push.gm r2 = (com.xiaomi.push.C1831gm) r2     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = r2.mo17696d()     // Catch:{ all -> 0x0131 }
            r0.append(r2)     // Catch:{ all -> 0x0131 }
            goto L_0x000e
        L_0x0022:
            java.util.Map<java.lang.String, java.lang.Object> r1 = r6.f2525a     // Catch:{ all -> 0x0131 }
            if (r1 == 0) goto L_0x012b
            java.util.Map<java.lang.String, java.lang.Object> r1 = r6.f2525a     // Catch:{ all -> 0x0131 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0131 }
            if (r1 != 0) goto L_0x012b
            java.lang.String r1 = "<properties xmlns=\"http://www.jivesoftware.com/xmlns/xmpp/properties\">"
            r0.append(r1)     // Catch:{ all -> 0x0131 }
            java.util.Collection r1 = r6.mo17701b()     // Catch:{ all -> 0x0131 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0131 }
        L_0x003b:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0131 }
            if (r2 == 0) goto L_0x0126
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0131 }
            java.lang.Object r3 = r6.mo17703a((java.lang.String) r2)     // Catch:{ all -> 0x0131 }
            java.lang.String r4 = "<property>"
            r0.append(r4)     // Catch:{ all -> 0x0131 }
            java.lang.String r4 = "<name>"
            r0.append(r4)     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = com.xiaomi.push.C1844gw.m3801a((java.lang.String) r2)     // Catch:{ all -> 0x0131 }
            r0.append(r2)     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = "</name>"
            r0.append(r2)     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = "<value type=\""
            r0.append(r2)     // Catch:{ all -> 0x0131 }
            boolean r2 = r3 instanceof java.lang.Integer     // Catch:{ all -> 0x0131 }
            if (r2 == 0) goto L_0x0079
            java.lang.String r2 = "integer\">"
            r0.append(r2)     // Catch:{ all -> 0x0131 }
            r0.append(r3)     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = "</value>"
        L_0x0074:
            r0.append(r2)     // Catch:{ all -> 0x0131 }
            goto L_0x0111
        L_0x0079:
            boolean r2 = r3 instanceof java.lang.Long     // Catch:{ all -> 0x0131 }
            if (r2 == 0) goto L_0x0088
            java.lang.String r2 = "long\">"
            r0.append(r2)     // Catch:{ all -> 0x0131 }
            r0.append(r3)     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = "</value>"
            goto L_0x0074
        L_0x0088:
            boolean r2 = r3 instanceof java.lang.Float     // Catch:{ all -> 0x0131 }
            if (r2 == 0) goto L_0x0097
            java.lang.String r2 = "float\">"
            r0.append(r2)     // Catch:{ all -> 0x0131 }
            r0.append(r3)     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = "</value>"
            goto L_0x0074
        L_0x0097:
            boolean r2 = r3 instanceof java.lang.Double     // Catch:{ all -> 0x0131 }
            if (r2 == 0) goto L_0x00a6
            java.lang.String r2 = "double\">"
            r0.append(r2)     // Catch:{ all -> 0x0131 }
            r0.append(r3)     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = "</value>"
            goto L_0x0074
        L_0x00a6:
            boolean r2 = r3 instanceof java.lang.Boolean     // Catch:{ all -> 0x0131 }
            if (r2 == 0) goto L_0x00b5
            java.lang.String r2 = "boolean\">"
            r0.append(r2)     // Catch:{ all -> 0x0131 }
            r0.append(r3)     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = "</value>"
            goto L_0x0074
        L_0x00b5:
            boolean r2 = r3 instanceof java.lang.String     // Catch:{ all -> 0x0131 }
            if (r2 == 0) goto L_0x00ca
            java.lang.String r2 = "string\">"
            r0.append(r2)     // Catch:{ all -> 0x0131 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = com.xiaomi.push.C1844gw.m3801a((java.lang.String) r3)     // Catch:{ all -> 0x0131 }
            r0.append(r2)     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = "</value>"
            goto L_0x0074
        L_0x00ca:
            r2 = 0
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0100, all -> 0x00fc }
            r4.<init>()     // Catch:{ Exception -> 0x0100, all -> 0x00fc }
            java.io.ObjectOutputStream r5 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x00f9, all -> 0x00f6 }
            r5.<init>(r4)     // Catch:{ Exception -> 0x00f9, all -> 0x00f6 }
            r5.writeObject(r3)     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r2 = "java-object\">"
            r0.append(r2)     // Catch:{ Exception -> 0x00f4 }
            byte[] r2 = r4.toByteArray()     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r2 = com.xiaomi.push.C1844gw.m3803a((byte[]) r2)     // Catch:{ Exception -> 0x00f4 }
            r0.append(r2)     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r2 = "</value>"
            r0.append(r2)     // Catch:{ Exception -> 0x00f4 }
            r5.close()     // Catch:{ Exception -> 0x00f0 }
        L_0x00f0:
            r4.close()     // Catch:{ Exception -> 0x0111 }
            goto L_0x0111
        L_0x00f4:
            r2 = move-exception
            goto L_0x0104
        L_0x00f6:
            r0 = move-exception
            r5 = r2
            goto L_0x0119
        L_0x00f9:
            r3 = move-exception
            r5 = r2
            goto L_0x0103
        L_0x00fc:
            r0 = move-exception
            r4 = r2
            r5 = r4
            goto L_0x0119
        L_0x0100:
            r3 = move-exception
            r4 = r2
            r5 = r4
        L_0x0103:
            r2 = r3
        L_0x0104:
            r2.printStackTrace()     // Catch:{ all -> 0x0118 }
            if (r5 == 0) goto L_0x010e
            r5.close()     // Catch:{ Exception -> 0x010d }
            goto L_0x010e
        L_0x010d:
        L_0x010e:
            if (r4 == 0) goto L_0x0111
            goto L_0x00f0
        L_0x0111:
            java.lang.String r2 = "</property>"
            r0.append(r2)     // Catch:{ all -> 0x0131 }
            goto L_0x003b
        L_0x0118:
            r0 = move-exception
        L_0x0119:
            if (r5 == 0) goto L_0x0120
            r5.close()     // Catch:{ Exception -> 0x011f }
            goto L_0x0120
        L_0x011f:
        L_0x0120:
            if (r4 == 0) goto L_0x0125
            r4.close()     // Catch:{ Exception -> 0x0125 }
        L_0x0125:
            throw r0     // Catch:{ all -> 0x0131 }
        L_0x0126:
            java.lang.String r1 = "</properties>"
            r0.append(r1)     // Catch:{ all -> 0x0131 }
        L_0x012b:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0131 }
            monitor-exit(r6)
            return r0
        L_0x0131:
            r0 = move-exception
            monitor-exit(r6)
            goto L_0x0135
        L_0x0134:
            throw r0
        L_0x0135:
            goto L_0x0134
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1830gl.mo17735o():java.lang.String");
    }

    /* renamed from: o */
    public void mo17736o(String str) {
        this.f2531i = str;
    }

    /* renamed from: p */
    public String mo17737p() {
        return this.f2526d;
    }
}
