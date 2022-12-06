package sg.bigo.ads.controller.a;

import android.content.Context;
import android.os.Parcel;
import android.text.TextUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
import sg.bigo.ads.common.c;
import sg.bigo.ads.common.d;
import sg.bigo.ads.common.h;
import sg.bigo.ads.common.l.g;
import sg.bigo.ads.common.utils.j;
import sg.bigo.ads.common.utils.o;
import sg.bigo.ads.common.utils.p;
import sg.bigo.ads.controller.a.b;

public final class a implements sg.bigo.ads.common.l.a {
    final AtomicBoolean a = new AtomicBoolean(false);
    final C0128a b;
    List<String> c;
    private final Context d;
    private final b e;
    private final sg.bigo.ads.controller.b.b f;

    /* renamed from: sg.bigo.ads.controller.a.a$a  reason: collision with other inner class name */
    static class C0128a extends c implements d.a<b> {
        long a = 0;
        long d;
        private final Map<String, b> e = new HashMap();

        public C0128a(Context context) {
            super(context);
        }

        public final /* synthetic */ d a() {
            return new b();
        }

        /* access modifiers changed from: package-private */
        public final b a(String str) {
            b bVar;
            synchronized (this.e) {
                bVar = this.e.get(str);
                if (bVar == null) {
                    bVar = new b();
                    this.e.put(str, bVar);
                }
            }
            return bVar;
        }

        public final void a(Parcel parcel) {
            synchronized (this.e) {
                h.a(parcel, this.e);
                parcel.writeLong(this.a);
                parcel.writeLong(this.d);
            }
        }

        public final String a_() {
            return "bigoad_antiban.dat";
        }

        public final String b() {
            return "AntiBan";
        }

        /* access modifiers changed from: package-private */
        public final b b(String str) {
            b bVar;
            synchronized (this.e) {
                bVar = this.e.get(str);
            }
            return bVar;
        }

        public final void b(Parcel parcel) {
            Map b = h.b(parcel, this);
            this.a = parcel.readLong();
            this.d = parcel.readLong();
            if (!b.isEmpty()) {
                synchronized (this.e) {
                    this.e.putAll(b);
                }
            }
        }

        public final String toString() {
            return "items:" + j.a(this.e) + ", lastFetchNetDiskBeginTs:" + this.a + ", lastFetchNetDiskSuccessTs:" + this.d;
        }
    }

    public interface b {
        String a();
    }

    public a(Context context, sg.bigo.ads.controller.b.b bVar, b bVar2) {
        this.d = context;
        this.e = bVar2;
        this.b = new C0128a(context);
        this.f = bVar;
    }

    static /* synthetic */ void a(a aVar, String str) {
        String str2;
        String str3;
        String a2 = aVar.e.a();
        if (TextUtils.isEmpty(a2)) {
            str3 = "country is empty";
        } else {
            JSONObject a3 = c.a(str, "FEFFFFFFFFFAFFFDCBFFFFFFFFFFFF4F");
            if (a3 == null) {
                str3 = "netDiskJson is null";
            } else {
                JSONObject optJSONObject = a3.optJSONObject(a2);
                if (optJSONObject == null) {
                    str3 = "countryHostJson is null";
                } else {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys != null && keys.hasNext()) {
                        String next = keys.next();
                        JSONArray optJSONArray = optJSONObject.optJSONArray(next);
                        if (optJSONArray == null || optJSONArray.length() == 0) {
                            sg.bigo.ads.common.k.a.a("AntiBan", "originHost=" + next + " has not any backup hosts.");
                        } else {
                            ArrayList arrayList = new ArrayList();
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                String optString = optJSONArray.optString(i);
                                if (c.a(optString)) {
                                    arrayList.add(optString);
                                }
                            }
                            if (TextUtils.isEmpty(next)) {
                                str2 = "addBackupHosts fail, originHost is empty.";
                            } else if (j.a(arrayList)) {
                                str2 = "addBackupHosts fail, hosts is empty.";
                            } else if (aVar.b.a(next).a((Collection<String>) arrayList)) {
                                aVar.b.o();
                            }
                            sg.bigo.ads.common.k.a.a(0, "AntiBan", str2);
                        }
                    }
                    return;
                }
            }
        }
        sg.bigo.ads.common.k.a.a(0, "AntiBan", str3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private sg.bigo.ads.controller.a.b c(sg.bigo.ads.common.l.b.c r9) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            java.net.URL r1 = new java.net.URL     // Catch:{ MalformedURLException -> 0x001d }
            java.lang.String r2 = r9.d     // Catch:{ MalformedURLException -> 0x001d }
            r1.<init>(r2)     // Catch:{ MalformedURLException -> 0x001d }
            java.net.URL r2 = new java.net.URL     // Catch:{ MalformedURLException -> 0x001d }
            java.lang.String r9 = r9.f()     // Catch:{ MalformedURLException -> 0x001d }
            r2.<init>(r9)     // Catch:{ MalformedURLException -> 0x001d }
            java.lang.String r9 = r1.getHost()     // Catch:{ MalformedURLException -> 0x001d }
            java.lang.String r0 = r2.getHost()     // Catch:{ MalformedURLException -> 0x001b }
            goto L_0x0022
        L_0x001b:
            r1 = move-exception
            goto L_0x001f
        L_0x001d:
            r1 = move-exception
            r9 = r0
        L_0x001f:
            r1.printStackTrace()
        L_0x0022:
            boolean r1 = android.text.TextUtils.isEmpty(r9)
            java.lang.String r2 = ", latestHost="
            r3 = 0
            r4 = 3
            r5 = 0
            java.lang.String r6 = "AntiBan"
            if (r1 != 0) goto L_0x006c
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0036
            goto L_0x006c
        L_0x0036:
            sg.bigo.ads.controller.a.a$a r1 = r8.b
            sg.bigo.ads.controller.a.b r9 = r1.b((java.lang.String) r9)
            if (r9 != 0) goto L_0x0044
            java.lang.String r9 = "matchedItem return null, antiBanItem is null."
        L_0x0040:
            sg.bigo.ads.common.k.a.a(r5, r4, r6, r9)
            return r3
        L_0x0044:
            java.lang.String r1 = r9.d
            java.lang.String r1 = sg.bigo.ads.common.utils.o.a((java.lang.String) r1)
            boolean r7 = android.text.TextUtils.isEmpty(r1)
            if (r7 != 0) goto L_0x006b
            boolean r7 = android.text.TextUtils.equals(r1, r0)
            if (r7 != 0) goto L_0x006b
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r7 = "matchedItem return null, curHost is not equals, curHost="
            r9.<init>(r7)
            r9.append(r1)
            r9.append(r2)
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            goto L_0x0040
        L_0x006b:
            return r9
        L_0x006c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r7 = "matchedItem return null, host or latestHost is null, host="
            r1.<init>(r7)
            r1.append(r9)
            r1.append(r2)
            r1.append(r0)
            java.lang.String r9 = r1.toString()
            goto L_0x0040
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.controller.a.a.c(sg.bigo.ads.common.l.b.c):sg.bigo.ads.controller.a.b");
    }

    public final String a(String str) {
        if (TextUtils.isEmpty(str)) {
            sg.bigo.ads.common.k.a.a(0, "AntiBan", "getPreHost fail, host is empty.");
            return "";
        }
        b b2 = this.b.b(str);
        return b2 != null ? o.a(b2.c) : "";
    }

    public final URL a(URL url) {
        String host = url.getHost();
        if (TextUtils.isEmpty(host)) {
            sg.bigo.ads.common.k.a.a(0, 3, "AntiBan", "markReqFailure fail, host is empty, url=".concat(String.valueOf(url)));
            return null;
        }
        b b2 = this.b.b(host);
        if (b2 != null) {
            try {
                b.a a2 = b2.a(url);
                if (a2.b) {
                    this.b.o();
                }
                return a2.a;
            } catch (Exception e2) {
                sg.bigo.ads.common.k.a.a(0, "AntiBan", "processUrl fail, e=".concat(String.valueOf(e2)));
            }
        } else {
            sg.bigo.ads.common.k.a.a(0, 3, "AntiBan", "processUrl fail, antiBanItem is null, url=".concat(String.valueOf(url)));
            return url;
        }
    }

    public final void a() {
        this.b.n();
    }

    /* access modifiers changed from: package-private */
    public final void a(final List<String> list) {
        if (list == null || list.size() == 0) {
            sg.bigo.ads.common.k.a.a(0, 3, "TAG", "[net disk] stop fetching net disk url");
            this.a.set(false);
            return;
        }
        final String remove = list.remove(0);
        if (!TextUtils.isEmpty(remove)) {
            sg.bigo.ads.common.k.a.a(0, 3, "TAG", "[net disk] fetching net disk url: ".concat(String.valueOf(remove)));
            this.b.a = p.b();
            g.a(new sg.bigo.ads.common.l.b.a(remove), new sg.bigo.ads.common.l.b<sg.bigo.ads.common.l.b.a, sg.bigo.ads.common.l.c.d>() {
                public final /* synthetic */ sg.bigo.ads.common.l.c.c a(sg.bigo.ads.common.l.c.a aVar) {
                    return new sg.bigo.ads.common.l.c.d(aVar);
                }

                public final /* synthetic */ void a(sg.bigo.ads.common.l.b.c cVar, sg.bigo.ads.common.l.c.c cVar2) {
                    sg.bigo.ads.common.k.a.a(0, 3, "TAG", "[net disk] succeed to fetch net disk url: " + remove);
                    a aVar = a.this;
                    aVar.c = list;
                    aVar.a.set(false);
                    a.this.b.d = p.b();
                    a.a(a.this, ((sg.bigo.ads.common.l.c.d) cVar2).a());
                }

                public final /* synthetic */ void a(sg.bigo.ads.common.l.b.c cVar, sg.bigo.ads.common.l.h hVar) {
                    sg.bigo.ads.common.k.a.a(0, 3, "TAG", "[net disk] try another net disk url due to failed to fetch net disk url: " + remove);
                    a.this.a((List<String>) list);
                }
            });
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(sg.bigo.ads.common.l.b.c r9) {
        /*
            r8 = this;
            java.lang.String r0 = "AntiBan"
            r1 = 3
            r2 = 0
            if (r9 != 0) goto L_0x000c
            java.lang.String r9 = "markReqFailure return, request is null."
        L_0x0008:
            sg.bigo.ads.common.k.a.a(r2, r1, r0, r9)
            return
        L_0x000c:
            android.content.Context r3 = r8.d
            boolean r3 = sg.bigo.ads.common.p.c.a((android.content.Context) r3)
            if (r3 == 0) goto L_0x0110
            sg.bigo.ads.controller.a.b r9 = r8.c(r9)
            if (r9 != 0) goto L_0x001d
            java.lang.String r9 = "markReqFailure return, antiBanItem is null."
            goto L_0x0008
        L_0x001d:
            boolean r0 = r9.c()
            if (r0 == 0) goto L_0x0028
            sg.bigo.ads.controller.a.a$a r0 = r8.b
            r0.o()
        L_0x0028:
            boolean r0 = r9.a()
            if (r0 == 0) goto L_0x010f
            boolean r0 = r9.b()
            if (r0 == 0) goto L_0x010f
            java.util.Set<java.lang.String> r0 = r9.a
            boolean r0 = sg.bigo.ads.common.utils.j.a(r0)
            if (r0 == 0) goto L_0x010f
            java.lang.String r9 = r9.b
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 == 0) goto L_0x010f
            sg.bigo.ads.controller.a.a$a r9 = r8.b
            long r3 = r9.a
            long r5 = r9.d
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            r3 = 1
            if (r0 != 0) goto L_0x0051
        L_0x004f:
            r9 = r3
            goto L_0x007c
        L_0x0051:
            long r4 = r9.a
            long r6 = r9.d
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            long r4 = sg.bigo.ads.common.utils.p.b()
            if (r0 <= 0) goto L_0x006c
            long r6 = r9.a
            long r4 = r4 - r6
            long r4 = java.lang.Math.abs(r4)
            r6 = 1800000(0x1b7740, double:8.89318E-318)
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 <= 0) goto L_0x007b
            goto L_0x004f
        L_0x006c:
            long r6 = r9.d
            long r4 = r4 - r6
            long r4 = java.lang.Math.abs(r4)
            r6 = 86400000(0x5265c00, double:4.2687272E-316)
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 <= 0) goto L_0x007b
            goto L_0x004f
        L_0x007b:
            r9 = r2
        L_0x007c:
            if (r9 == 0) goto L_0x010f
            java.lang.String r9 = "TAG"
            java.lang.String r0 = "[net disk] try to start fetch net disk urls"
            sg.bigo.ads.common.k.a.a(r2, r1, r9, r0)
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.a
            boolean r0 = r0.compareAndSet(r2, r3)
            if (r0 == 0) goto L_0x010f
            java.lang.String r0 = "[net disk] start fetch net disk urls"
            sg.bigo.ads.common.k.a.a(r2, r1, r9, r0)
            java.util.List<java.lang.String> r0 = r8.c
            r3 = 0
            if (r0 == 0) goto L_0x00ba
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x00ba
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.List<java.lang.String> r4 = r8.c
            r0.<init>(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "[net disk] using old net disk urls, size = "
            r4.<init>(r5)
            int r5 = r0.size()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            sg.bigo.ads.common.k.a.a(r2, r1, r9, r4)
            goto L_0x00bb
        L_0x00ba:
            r0 = r3
        L_0x00bb:
            if (r0 != 0) goto L_0x010a
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            sg.bigo.ads.controller.b.b r4 = r8.f
            if (r4 != 0) goto L_0x00c8
            r4 = r3
            goto L_0x00d2
        L_0x00c8:
            java.lang.String r5 = "net_disk_urls"
            sg.bigo.ads.api.a.b r4 = r4.a((java.lang.String) r5)
            java.lang.String r4 = r4.toString()
        L_0x00d2:
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00d8 }
            r5.<init>(r4)     // Catch:{ JSONException -> 0x00d8 }
            goto L_0x00dd
        L_0x00d8:
            r4 = move-exception
            r4.printStackTrace()
            r5 = r3
        L_0x00dd:
            if (r5 == 0) goto L_0x00f0
            r4 = r2
        L_0x00e0:
            int r6 = r5.length()
            if (r4 >= r6) goto L_0x00f0
            java.lang.String r6 = r5.optString(r4)
            r0.add(r6)
            int r4 = r4 + 1
            goto L_0x00e0
        L_0x00f0:
            java.lang.String r4 = "https://drive.google.com/uc?export=download&id=1GONwHA_2awwNyOoYj3qvaryaYl9RBBpS"
            r0.add(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "[net disk] create net disk urls, size = "
            r4.<init>(r5)
            int r5 = r0.size()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            sg.bigo.ads.common.k.a.a(r2, r1, r9, r4)
        L_0x010a:
            r8.c = r3
            r8.a((java.util.List<java.lang.String>) r0)
        L_0x010f:
            return
        L_0x0110:
            java.lang.String r9 = "markReqFailure failure weak net"
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.controller.a.a.a(sg.bigo.ads.common.l.b.c):void");
    }

    public final boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            return this.b.a(str).a(str2);
        }
        sg.bigo.ads.common.k.a.a(0, "AntiBan", "updateConfig fail, originHost is empty.");
        return false;
    }

    public final void b() {
        this.b.m();
    }

    public final void b(sg.bigo.ads.common.l.b.c cVar) {
        if (cVar == null) {
            sg.bigo.ads.common.k.a.a(0, "AntiBan", "clearReqFailureInfo fail, request is null.");
            return;
        }
        b c2 = c(cVar);
        if (c2 != null && c2.d()) {
            this.b.o();
        }
    }

    public final boolean b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            sg.bigo.ads.common.k.a.a(0, "AntiBan", "updateConfig fail, originHost is empty.");
            return false;
        } else if (this.b.b(str) != null) {
            return true;
        } else {
            this.b.a(str).a(str2);
            return true;
        }
    }

    public final String toString() {
        return this.b.toString();
    }
}
