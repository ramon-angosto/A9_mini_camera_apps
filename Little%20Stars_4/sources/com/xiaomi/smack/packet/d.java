package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.smack.util.g;
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

public abstract class d {
    protected static final String a = Locale.getDefault().getLanguage().toLowerCase();
    public static final DateFormat b = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    private static String c = null;
    private static String d = (g.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    private static long e = 0;
    private String f = c;
    private String g = null;
    private String h = null;
    private String i = null;
    private String j = null;
    private String k = null;
    private List<a> l = new CopyOnWriteArrayList();
    private final Map<String, Object> m = new HashMap();
    private h n = null;

    static {
        b.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public d() {
    }

    public d(Bundle bundle) {
        this.h = bundle.getString("ext_to");
        this.i = bundle.getString("ext_from");
        this.j = bundle.getString("ext_chid");
        this.g = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.l = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                a a2 = a.a((Bundle) parcelable);
                if (a2 != null) {
                    this.l.add(a2);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.n = new h(bundle2);
        }
    }

    public static synchronized String j() {
        String sb;
        synchronized (d.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(d);
            long j2 = e;
            e = 1 + j2;
            sb2.append(Long.toString(j2));
            sb = sb2.toString();
        }
        return sb;
    }

    public static String u() {
        return a;
    }

    public abstract String a();

    public void a(a aVar) {
        this.l.add(aVar);
    }

    public void a(h hVar) {
        this.n = hVar;
    }

    public a b(String str, String str2) {
        for (a next : this.l) {
            if ((str2 == null || str2.equals(next.b())) && str.equals(next.a())) {
                return next;
            }
        }
        return null;
    }

    public Bundle c() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.f)) {
            bundle.putString("ext_ns", this.f);
        }
        if (!TextUtils.isEmpty(this.i)) {
            bundle.putString("ext_from", this.i);
        }
        if (!TextUtils.isEmpty(this.h)) {
            bundle.putString("ext_to", this.h);
        }
        if (!TextUtils.isEmpty(this.g)) {
            bundle.putString("ext_pkt_id", this.g);
        }
        if (!TextUtils.isEmpty(this.j)) {
            bundle.putString("ext_chid", this.j);
        }
        h hVar = this.n;
        if (hVar != null) {
            bundle.putBundle("ext_ERROR", hVar.c());
        }
        List<a> list = this.l;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i2 = 0;
            for (a e2 : this.l) {
                Bundle e3 = e2.e();
                if (e3 != null) {
                    bundleArr[i2] = e3;
                    i2++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        h hVar = this.n;
        if (hVar == null ? dVar.n != null : !hVar.equals(dVar.n)) {
            return false;
        }
        String str = this.i;
        if (str == null ? dVar.i != null : !str.equals(dVar.i)) {
            return false;
        }
        if (!this.l.equals(dVar.l)) {
            return false;
        }
        String str2 = this.g;
        if (str2 == null ? dVar.g != null : !str2.equals(dVar.g)) {
            return false;
        }
        String str3 = this.j;
        if (str3 == null ? dVar.j != null : !str3.equals(dVar.j)) {
            return false;
        }
        Map<String, Object> map = this.m;
        if (map == null ? dVar.m != null : !map.equals(dVar.m)) {
            return false;
        }
        String str4 = this.h;
        if (str4 == null ? dVar.h != null : !str4.equals(dVar.h)) {
            return false;
        }
        String str5 = this.f;
        if (str5 != null) {
            return str5.equals(dVar.f);
        }
        if (dVar.f == null) {
            return true;
        }
    }

    public int hashCode() {
        String str = this.f;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.g;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.h;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.i;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.j;
        int hashCode5 = (((((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31;
        h hVar = this.n;
        if (hVar != null) {
            i2 = hVar.hashCode();
        }
        return hashCode5 + i2;
    }

    public String k() {
        if ("ID_NOT_AVAILABLE".equals(this.g)) {
            return null;
        }
        if (this.g == null) {
            this.g = j();
        }
        return this.g;
    }

    public void k(String str) {
        this.g = str;
    }

    public String l() {
        return this.j;
    }

    public void l(String str) {
        this.j = str;
    }

    public String m() {
        return this.h;
    }

    public void m(String str) {
        this.h = str;
    }

    public String n() {
        return this.i;
    }

    public void n(String str) {
        this.i = str;
    }

    public String o() {
        return this.k;
    }

    public void o(String str) {
        this.k = str;
    }

    public a p(String str) {
        return b(str, (String) null);
    }

    public h p() {
        return this.n;
    }

    public synchronized Object q(String str) {
        if (this.m == null) {
            return null;
        }
        return this.m.get(str);
    }

    public synchronized Collection<a> q() {
        if (this.l == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(this.l));
    }

    public synchronized Collection<String> r() {
        if (this.m == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.m.keySet()));
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
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String s() {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0131 }
            r0.<init>()     // Catch:{ all -> 0x0131 }
            java.util.Collection r1 = r6.q()     // Catch:{ all -> 0x0131 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0131 }
        L_0x000e:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0131 }
            if (r2 == 0) goto L_0x0022
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0131 }
            com.xiaomi.smack.packet.e r2 = (com.xiaomi.smack.packet.e) r2     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = r2.d()     // Catch:{ all -> 0x0131 }
            r0.append(r2)     // Catch:{ all -> 0x0131 }
            goto L_0x000e
        L_0x0022:
            java.util.Map<java.lang.String, java.lang.Object> r1 = r6.m     // Catch:{ all -> 0x0131 }
            if (r1 == 0) goto L_0x012b
            java.util.Map<java.lang.String, java.lang.Object> r1 = r6.m     // Catch:{ all -> 0x0131 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0131 }
            if (r1 != 0) goto L_0x012b
            java.lang.String r1 = "<properties xmlns=\"http://www.jivesoftware.com/xmlns/xmpp/properties\">"
            r0.append(r1)     // Catch:{ all -> 0x0131 }
            java.util.Collection r1 = r6.r()     // Catch:{ all -> 0x0131 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0131 }
        L_0x003b:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0131 }
            if (r2 == 0) goto L_0x0126
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0131 }
            java.lang.Object r3 = r6.q(r2)     // Catch:{ all -> 0x0131 }
            java.lang.String r4 = "<property>"
            r0.append(r4)     // Catch:{ all -> 0x0131 }
            java.lang.String r4 = "<name>"
            r0.append(r4)     // Catch:{ all -> 0x0131 }
            java.lang.String r2 = com.xiaomi.smack.util.g.a((java.lang.String) r2)     // Catch:{ all -> 0x0131 }
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
            java.lang.String r2 = com.xiaomi.smack.util.g.a((java.lang.String) r3)     // Catch:{ all -> 0x0131 }
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
            java.lang.String r2 = com.xiaomi.smack.util.g.a((byte[]) r2)     // Catch:{ Exception -> 0x00f4 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smack.packet.d.s():java.lang.String");
    }

    public String t() {
        return this.f;
    }
}
