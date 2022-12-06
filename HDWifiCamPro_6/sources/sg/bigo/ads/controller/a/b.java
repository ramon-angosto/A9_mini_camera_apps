package sg.bigo.ads.controller.a;

import android.os.Parcel;
import android.text.TextUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import sg.bigo.ads.common.d;
import sg.bigo.ads.common.utils.j;
import sg.bigo.ads.common.utils.p;
import sg.bigo.ads.common.utils.r;

final class b implements d {
    final Set<String> a = new HashSet();
    String b = "";
    String c;
    String d;
    private boolean e = false;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i;
    private long j;
    private long k;
    private String l;

    static class a {
        final URL a;
        final boolean b;

        private a(URL url, boolean z) {
            this.a = url;
            this.b = z;
        }

        /* synthetic */ a(URL url, boolean z, byte b2) {
            this(url, z);
        }
    }

    private String e() {
        String str;
        synchronized (this.a) {
            ArrayList arrayList = new ArrayList(this.a);
            str = "";
            while (!j.a(arrayList) && !c.a(str)) {
                str = (String) arrayList.remove(new Random().nextInt(arrayList.size()));
                Set<String> set = this.a;
                if (!(set == null || str == null)) {
                    set.remove(str);
                }
            }
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x011e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized sg.bigo.ads.controller.a.b.a a(java.net.URL r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            java.lang.String r0 = "processUrl:"
            java.lang.String r1 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x0126 }
            r0.concat(r1)     // Catch:{ all -> 0x0126 }
            sg.bigo.ads.common.utils.r.a()     // Catch:{ all -> 0x0126 }
            boolean r0 = r10.a()     // Catch:{ all -> 0x0126 }
            r1 = 0
            if (r0 != 0) goto L_0x001b
            sg.bigo.ads.controller.a.b$a r0 = new sg.bigo.ads.controller.a.b$a     // Catch:{ all -> 0x0126 }
            r0.<init>(r11, r1, r1)     // Catch:{ all -> 0x0126 }
            monitor-exit(r10)
            return r0
        L_0x001b:
            java.lang.String r0 = r11.getHost()     // Catch:{ all -> 0x0126 }
            boolean r2 = r10.b()     // Catch:{ all -> 0x0126 }
            r3 = 3
            r4 = 1
            if (r2 == 0) goto L_0x00ac
            java.util.Set<java.lang.String> r2 = r10.a     // Catch:{ all -> 0x0126 }
            boolean r2 = sg.bigo.ads.common.utils.j.a(r2)     // Catch:{ all -> 0x0126 }
            if (r2 == 0) goto L_0x003b
            java.lang.String r2 = r10.b     // Catch:{ all -> 0x0126 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0126 }
            if (r2 != 0) goto L_0x0038
            goto L_0x003b
        L_0x0038:
            r2 = r0
            goto L_0x00ae
        L_0x003b:
            java.lang.String r2 = r10.e()     // Catch:{ all -> 0x0126 }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0126 }
            if (r5 == 0) goto L_0x006e
            long r5 = r10.j     // Catch:{ all -> 0x0126 }
            r7 = 0
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x0055
            long r5 = sg.bigo.ads.common.utils.p.b()     // Catch:{ all -> 0x0126 }
            r10.j = r5     // Catch:{ all -> 0x0126 }
            r5 = r4
            goto L_0x0056
        L_0x0055:
            r5 = r1
        L_0x0056:
            long r6 = sg.bigo.ads.common.utils.p.b()     // Catch:{ all -> 0x0126 }
            long r8 = r10.j     // Catch:{ all -> 0x0126 }
            long r6 = r6 - r8
            long r6 = java.lang.Math.abs(r6)     // Catch:{ all -> 0x0126 }
            int r8 = r10.h     // Catch:{ all -> 0x0126 }
            long r8 = (long) r8     // Catch:{ all -> 0x0126 }
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x006f
            java.lang.String r2 = r10.b     // Catch:{ all -> 0x0126 }
            java.lang.String r5 = ""
            r10.b = r5     // Catch:{ all -> 0x0126 }
        L_0x006e:
            r5 = r4
        L_0x006f:
            java.lang.String r6 = "AntiBanItem"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0126 }
            java.lang.String r8 = "removeOneHost, host="
            r7.<init>(r8)     // Catch:{ all -> 0x0126 }
            r7.append(r2)     // Catch:{ all -> 0x0126 }
            java.lang.String r8 = ", dataChanged="
            r7.append(r8)     // Catch:{ all -> 0x0126 }
            r7.append(r5)     // Catch:{ all -> 0x0126 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0126 }
            sg.bigo.ads.common.k.a.a(r1, r3, r6, r7)     // Catch:{ all -> 0x0126 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ all -> 0x0126 }
            android.util.Pair r2 = android.util.Pair.create(r2, r5)     // Catch:{ all -> 0x0126 }
            java.lang.Object r5 = r2.second     // Catch:{ all -> 0x0126 }
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ all -> 0x0126 }
            boolean r5 = r5.booleanValue()     // Catch:{ all -> 0x0126 }
            java.lang.Object r6 = r2.first     // Catch:{ all -> 0x0126 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0126 }
            boolean r6 = sg.bigo.ads.controller.a.c.a(r6)     // Catch:{ all -> 0x0126 }
            if (r6 == 0) goto L_0x00a9
            java.lang.Object r2 = r2.first     // Catch:{ all -> 0x0126 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0126 }
            goto L_0x00af
        L_0x00a9:
            java.lang.String r2 = r10.d     // Catch:{ all -> 0x0126 }
            goto L_0x00af
        L_0x00ac:
            java.lang.String r2 = r10.d     // Catch:{ all -> 0x0126 }
        L_0x00ae:
            r5 = r1
        L_0x00af:
            boolean r6 = sg.bigo.ads.controller.a.c.a(r2)     // Catch:{ all -> 0x0126 }
            if (r6 == 0) goto L_0x010c
            boolean r6 = android.text.TextUtils.equals(r2, r0)     // Catch:{ all -> 0x0126 }
            if (r6 == 0) goto L_0x00bc
            goto L_0x010c
        L_0x00bc:
            java.lang.String r6 = r10.d     // Catch:{ all -> 0x0126 }
            boolean r6 = android.text.TextUtils.equals(r2, r6)     // Catch:{ all -> 0x0126 }
            if (r6 != 0) goto L_0x00ce
            r10.d()     // Catch:{ all -> 0x0126 }
            java.lang.String r5 = r10.d     // Catch:{ all -> 0x0126 }
            r10.c = r5     // Catch:{ all -> 0x0126 }
            r10.d = r2     // Catch:{ all -> 0x0126 }
            goto L_0x00cf
        L_0x00ce:
            r4 = r5
        L_0x00cf:
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0126 }
            java.lang.String r2 = r10.d     // Catch:{ all -> 0x0126 }
            java.lang.String r11 = r11.replaceFirst(r0, r2)     // Catch:{ all -> 0x0126 }
            java.net.URL r0 = new java.net.URL     // Catch:{ all -> 0x0126 }
            r0.<init>(r11)     // Catch:{ all -> 0x0126 }
            java.lang.String r11 = "AntiBanItem"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0126 }
            java.lang.String r5 = "processUrl, url="
            r2.<init>(r5)     // Catch:{ all -> 0x0126 }
            r2.append(r0)     // Catch:{ all -> 0x0126 }
            java.lang.String r5 = ", curHost="
            r2.append(r5)     // Catch:{ all -> 0x0126 }
            java.lang.String r5 = r10.d     // Catch:{ all -> 0x0126 }
            r2.append(r5)     // Catch:{ all -> 0x0126 }
            java.lang.String r5 = "， preHost="
            r2.append(r5)     // Catch:{ all -> 0x0126 }
            java.lang.String r5 = r10.c     // Catch:{ all -> 0x0126 }
            r2.append(r5)     // Catch:{ all -> 0x0126 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0126 }
            sg.bigo.ads.common.k.a.a(r1, r3, r11, r2)     // Catch:{ all -> 0x0126 }
            sg.bigo.ads.controller.a.b$a r11 = new sg.bigo.ads.controller.a.b$a     // Catch:{ all -> 0x0126 }
            r11.<init>(r0, r4, r1)     // Catch:{ all -> 0x0126 }
            monitor-exit(r10)
            return r11
        L_0x010c:
            java.lang.String r2 = r10.d     // Catch:{ all -> 0x0126 }
            boolean r2 = android.text.TextUtils.equals(r2, r0)     // Catch:{ all -> 0x0126 }
            if (r2 != 0) goto L_0x011e
            r10.d()     // Catch:{ all -> 0x0126 }
            java.lang.String r2 = r10.d     // Catch:{ all -> 0x0126 }
            r10.c = r2     // Catch:{ all -> 0x0126 }
            r10.d = r0     // Catch:{ all -> 0x0126 }
            goto L_0x011f
        L_0x011e:
            r4 = r5
        L_0x011f:
            sg.bigo.ads.controller.a.b$a r0 = new sg.bigo.ads.controller.a.b$a     // Catch:{ all -> 0x0126 }
            r0.<init>(r11, r4, r1)     // Catch:{ all -> 0x0126 }
            monitor-exit(r10)
            return r0
        L_0x0126:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.controller.a.b.a(java.net.URL):sg.bigo.ads.controller.a.b$a");
    }

    public final void a(Parcel parcel) {
        synchronized (this.a) {
            parcel.writeInt(this.a.size());
            for (String writeString : this.a) {
                parcel.writeString(writeString);
            }
        }
        parcel.writeByte(this.e ? (byte) 1 : 0);
        parcel.writeString(this.b);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeLong(this.j);
        parcel.writeLong(this.k);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.l);
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        return this.e && this.f > 0;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    final synchronized boolean a(java.lang.String r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x00a0 }
            r1 = 0
            if (r0 != 0) goto L_0x009e
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x00a0 }
            byte[] r8 = android.util.Base64.decode(r8, r1)     // Catch:{ all -> 0x00a0 }
            r0.<init>(r8)     // Catch:{ all -> 0x00a0 }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x009a }
            r8.<init>(r0)     // Catch:{ JSONException -> 0x009a }
            java.lang.String r0 = "backup_hosts"
            java.lang.String r2 = ""
            java.lang.String r0 = r8.optString(r0, r2)     // Catch:{ JSONException -> 0x009a }
            java.lang.String r2 = ","
            java.lang.String[] r0 = r0.split(r2)     // Catch:{ JSONException -> 0x009a }
            if (r0 == 0) goto L_0x004f
            int r2 = r0.length     // Catch:{ JSONException -> 0x009a }
            if (r2 <= 0) goto L_0x004f
            java.util.Set<java.lang.String> r2 = r7.a     // Catch:{ JSONException -> 0x009a }
            monitor-enter(r2)     // Catch:{ JSONException -> 0x009a }
            int r3 = r0.length     // Catch:{ all -> 0x004c }
            r4 = r1
        L_0x002e:
            if (r4 >= r3) goto L_0x004a
            r5 = r0[r4]     // Catch:{ all -> 0x004c }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x004c }
            if (r6 != 0) goto L_0x0047
            java.lang.String r5 = r5.trim()     // Catch:{ all -> 0x004c }
            int r6 = r5.length()     // Catch:{ all -> 0x004c }
            if (r6 <= 0) goto L_0x0047
            java.util.Set<java.lang.String> r6 = r7.a     // Catch:{ all -> 0x004c }
            r6.add(r5)     // Catch:{ all -> 0x004c }
        L_0x0047:
            int r4 = r4 + 1
            goto L_0x002e
        L_0x004a:
            monitor-exit(r2)     // Catch:{ all -> 0x004c }
            goto L_0x004f
        L_0x004c:
            r8 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x004c }
            throw r8     // Catch:{ JSONException -> 0x009a }
        L_0x004f:
            java.lang.String r0 = "final_host"
            java.lang.String r2 = ""
            java.lang.String r0 = r8.optString(r0, r2)     // Catch:{ JSONException -> 0x009a }
            r7.b = r0     // Catch:{ JSONException -> 0x009a }
            java.lang.String r0 = "flag"
            int r0 = r8.optInt(r0, r1)     // Catch:{ JSONException -> 0x009a }
            r2 = 1
            if (r0 != r2) goto L_0x0064
            r0 = r2
            goto L_0x0065
        L_0x0064:
            r0 = r1
        L_0x0065:
            r7.e = r0     // Catch:{ JSONException -> 0x009a }
            java.lang.String r0 = "times"
            int r0 = r8.optInt(r0, r1)     // Catch:{ JSONException -> 0x009a }
            r7.f = r0     // Catch:{ JSONException -> 0x009a }
            java.lang.String r0 = "failure_interval"
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MINUTES     // Catch:{ JSONException -> 0x009a }
            r4 = 10
            long r3 = r3.toSeconds(r4)     // Catch:{ JSONException -> 0x009a }
            int r3 = (int) r3     // Catch:{ JSONException -> 0x009a }
            int r0 = r8.optInt(r0, r3)     // Catch:{ JSONException -> 0x009a }
            int r0 = r0 * 1000
            r7.g = r0     // Catch:{ JSONException -> 0x009a }
            java.lang.String r0 = "final_interval"
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.DAYS     // Catch:{ JSONException -> 0x009a }
            r4 = 1
            long r3 = r3.toSeconds(r4)     // Catch:{ JSONException -> 0x009a }
            int r3 = (int) r3     // Catch:{ JSONException -> 0x009a }
            int r8 = r8.optInt(r0, r3)     // Catch:{ JSONException -> 0x009a }
            int r8 = r8 * 1000
            r7.h = r8     // Catch:{ JSONException -> 0x009a }
            r7.d()     // Catch:{ JSONException -> 0x009a }
            monitor-exit(r7)
            return r2
        L_0x009a:
            r8 = move-exception
            r8.printStackTrace()     // Catch:{ all -> 0x00a0 }
        L_0x009e:
            monitor-exit(r7)
            return r1
        L_0x00a0:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.controller.a.b.a(java.lang.String):boolean");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004a, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a(java.util.Collection<java.lang.String> r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = sg.bigo.ads.common.utils.j.a(r6)     // Catch:{ all -> 0x004e }
            r1 = 0
            if (r0 == 0) goto L_0x000a
            monitor-exit(r5)
            return r1
        L_0x000a:
            java.util.Set<java.lang.String> r0 = r5.a     // Catch:{ all -> 0x004e }
            monitor-enter(r0)     // Catch:{ all -> 0x004e }
            java.util.Set<java.lang.String> r2 = r5.a     // Catch:{ all -> 0x004b }
            int r2 = r2.size()     // Catch:{ all -> 0x004b }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x004b }
        L_0x0017:
            boolean r3 = r6.hasNext()     // Catch:{ all -> 0x004b }
            if (r3 == 0) goto L_0x0039
            java.lang.Object r3 = r6.next()     // Catch:{ all -> 0x004b }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x004b }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x004b }
            if (r4 != 0) goto L_0x0017
            java.lang.String r3 = r3.trim()     // Catch:{ all -> 0x004b }
            int r4 = r3.length()     // Catch:{ all -> 0x004b }
            if (r4 <= 0) goto L_0x0017
            java.util.Set<java.lang.String> r4 = r5.a     // Catch:{ all -> 0x004b }
            r4.add(r3)     // Catch:{ all -> 0x004b }
            goto L_0x0017
        L_0x0039:
            java.util.Set<java.lang.String> r6 = r5.a     // Catch:{ all -> 0x004b }
            int r6 = r6.size()     // Catch:{ all -> 0x004b }
            if (r2 == r6) goto L_0x0042
            r1 = 1
        L_0x0042:
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            if (r1 == 0) goto L_0x0049
            r2 = 0
            r5.j = r2     // Catch:{ all -> 0x004e }
        L_0x0049:
            monitor-exit(r5)
            return r1
        L_0x004b:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            throw r6     // Catch:{ all -> 0x004e }
        L_0x004e:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.controller.a.b.a(java.util.Collection):boolean");
    }

    public final void b(Parcel parcel) {
        int readInt = parcel.readInt();
        synchronized (this.a) {
            for (int i2 = 0; i2 < readInt; i2++) {
                String readString = parcel.readString();
                if (!TextUtils.isEmpty(readString)) {
                    String trim = readString.trim();
                    if (trim.length() > 0) {
                        this.a.add(trim);
                    }
                }
            }
        }
        boolean z = true;
        if (parcel.readByte() != 1) {
            z = false;
        }
        this.e = z;
        this.b = parcel.readString();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readLong();
        this.k = parcel.readLong();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.l = parcel.readString();
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return this.i >= this.f;
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean c() {
        r.a();
        if (!a()) {
            return false;
        }
        long abs = Math.abs(p.b() - this.k);
        if (abs > ((long) this.g)) {
            this.i++;
            this.k = p.b();
            sg.bigo.ads.common.k.a.a(0, 3, "AntiBanItem", "updateReqFailureTimes success num =" + this.i);
            return true;
        }
        sg.bigo.ads.common.k.a.a(0, 3, "AntiBanItem", "updateReqFailureTimes failure last=" + this.k + ",interval=" + this.g + ",diff=" + abs);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean d() {
        r.a();
        if (this.i == 0 && this.k == 0 && this.j == 0) {
            return false;
        }
        this.i = 0;
        this.k = 0;
        this.j = 0;
        return true;
    }

    public final String toString() {
        return "{backupHosts=" + j.b(this.a) + ", isUseReplaceStrategy=" + this.e + ", finalHost='" + this.b + '\'' + ", replaceStrategyTimes=" + this.f + ", replaceStrategyFailureInterval=" + this.g + ", replaceStrategyFinalInterval=" + this.h + ", reqFailureTimes=" + this.i + ", finalHostBeginTs=" + this.j + ", reqFailureLastTs=" + this.k + ", preHost='" + this.c + '\'' + ", curHost='" + this.d + '\'' + ", extra='" + this.l + '\'' + '}';
    }
}
