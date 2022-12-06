package com.huawei.android.pushagent.b.d;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.pushagent.b.b.c;
import com.huawei.android.pushagent.c.a.b;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.a.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class a {
    private static a h;
    Context a = null;
    List b = new LinkedList();
    List c = new LinkedList();
    List d = new LinkedList();
    List e = new LinkedList();
    List f = new LinkedList();
    List g = new LinkedList();

    private a(Context context) {
        this.a = context;
        f();
        if (this.b.size() == 0 && this.c.size() == 0 && this.d.size() == 0 && this.e.size() == 0 && this.f.size() == 0 && this.g.size() == 0) {
            e.a("PushLogAC2705", "Connect Control is not set, begin to config it");
            c();
        }
    }

    private boolean a(int i) {
        return a(1 == b.a(this.a) ? this.g : this.d);
    }

    public static synchronized boolean a(Context context) {
        synchronized (a.class) {
            b(context);
            if (h == null) {
                e.d("PushLogAC2705", "cannot get ConnectControlMgr instance, may be system err!!");
                return false;
            }
            boolean d2 = h.d();
            return d2;
        }
    }

    public static synchronized boolean a(Context context, int i) {
        synchronized (a.class) {
            b(context);
            if (h == null) {
                e.d("PushLogAC2705", "cannot get ConnectControlMgr instance, may be system err!!");
                return false;
            }
            boolean a2 = h.a(i);
            return a2;
        }
    }

    private boolean a(h hVar, List list, String str) throws Exception {
        list.clear();
        String b2 = hVar.b(str);
        if (TextUtils.isEmpty(b2)) {
            e.a("PushLogAC2705", str + " is not set");
            return true;
        }
        e.a("PushLogAC2705", str + "=" + b2);
        for (String str2 : b2.split("\\|")) {
            com.huawei.android.pushagent.b.d.a.a aVar = new com.huawei.android.pushagent.b.d.a.a();
            if (aVar.a(str2)) {
                list.add(aVar);
            }
        }
        return true;
    }

    private boolean a(List list) {
        if (!a(list, 1)) {
            e.b("PushLogAC2705", "volumeControl not allow to pass!!");
            return false;
        }
        b(list, 1);
        e();
        return true;
    }

    private boolean a(List list, long j) {
        if (list == null || list.size() == 0) {
            e.a("PushLogAC2705", "there is no volome control");
            return true;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.huawei.android.pushagent.b.d.a.b bVar = (com.huawei.android.pushagent.b.d.a.b) it.next();
            if (!bVar.a(j)) {
                e.b("PushLogAC2705", " not pass:" + bVar);
                return false;
            }
            e.a("PushLogAC2705", " pass:" + bVar);
        }
        return true;
    }

    private boolean a(List list, List list2) {
        boolean z;
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.huawei.android.pushagent.b.d.a.b bVar = (com.huawei.android.pushagent.b.d.a.b) it.next();
            Iterator it2 = list2.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (bVar.a((com.huawei.android.pushagent.b.d.a.b) it2.next())) {
                        z = true;
                        continue;
                        break;
                    }
                } else {
                    z = false;
                    continue;
                    break;
                }
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public static synchronized a b(Context context) {
        a aVar;
        synchronized (a.class) {
            if (h == null) {
                h = new a(context);
            }
            aVar = h;
        }
        return aVar;
    }

    private boolean b() {
        String str;
        LinkedList linkedList = new LinkedList();
        linkedList.add(new com.huawei.android.pushagent.b.d.a.a(86400000, com.huawei.android.pushagent.b.b.a.a(this.a).G()));
        linkedList.add(new com.huawei.android.pushagent.b.d.a.a(3600000, com.huawei.android.pushagent.b.b.a.a(this.a).H()));
        if (!a((List) linkedList, this.b)) {
            str = "trsFirstFlowControl cfg is change!";
        } else {
            LinkedList linkedList2 = new LinkedList();
            linkedList2.add(new com.huawei.android.pushagent.b.d.a.a(86400000, com.huawei.android.pushagent.b.b.a.a(this.a).I()));
            if (!a((List) linkedList2, this.c)) {
                str = "trsFlowControl cfg is change!!";
            } else {
                LinkedList linkedList3 = new LinkedList();
                for (Map.Entry entry : com.huawei.android.pushagent.b.b.a.a(this.a).J().entrySet()) {
                    linkedList3.add(new com.huawei.android.pushagent.b.d.a.a(((Long) entry.getKey()).longValue() * 1000, ((Long) entry.getValue()).longValue()));
                }
                if (!a((List) linkedList3, this.d)) {
                    str = "flowcControl cfg is change!!";
                } else {
                    LinkedList linkedList4 = new LinkedList();
                    linkedList4.add(new com.huawei.android.pushagent.b.d.a.a(86400000, com.huawei.android.pushagent.b.b.a.a(this.a).K()));
                    linkedList4.add(new com.huawei.android.pushagent.b.d.a.a(3600000, com.huawei.android.pushagent.b.b.a.a(this.a).L()));
                    if (!a((List) linkedList4, this.e)) {
                        str = "wifiTrsFirstFlowControl cfg is change!";
                    } else {
                        LinkedList linkedList5 = new LinkedList();
                        linkedList5.add(new com.huawei.android.pushagent.b.d.a.a(86400000, com.huawei.android.pushagent.b.b.a.a(this.a).M()));
                        if (!a((List) linkedList5, this.f)) {
                            str = "wifiTrsFlowControl cfg is change!!";
                        } else {
                            LinkedList linkedList6 = new LinkedList();
                            for (Map.Entry entry2 : com.huawei.android.pushagent.b.b.a.a(this.a).R().entrySet()) {
                                linkedList6.add(new com.huawei.android.pushagent.b.d.a.a(((Long) entry2.getKey()).longValue() * 1000, ((Long) entry2.getValue()).longValue()));
                            }
                            if (!a((List) linkedList6, this.g)) {
                                str = "wifiVolumeControl cfg is change!!";
                            } else {
                                e.a("PushLogAC2705", "cur control is equal trs cfg");
                                return true;
                            }
                        }
                    }
                }
            }
        }
        e.a("PushLogAC2705", str);
        return false;
    }

    private boolean b(h hVar, List list, String str) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            stringBuffer.append(((com.huawei.android.pushagent.b.d.a.b) it.next()).a());
            stringBuffer.append("|");
        }
        if (hVar.a(str, stringBuffer.toString())) {
            return true;
        }
        e.d("PushLogAC2705", "save " + str + " failed!!");
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0040, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean b(java.util.List r4, long r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 1
            if (r4 == 0) goto L_0x003f
            int r1 = r4.size()     // Catch:{ all -> 0x003c }
            if (r1 != 0) goto L_0x000b
            goto L_0x003f
        L_0x000b:
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x003c }
        L_0x000f:
            boolean r1 = r4.hasNext()     // Catch:{ all -> 0x003c }
            if (r1 == 0) goto L_0x003a
            java.lang.Object r1 = r4.next()     // Catch:{ all -> 0x003c }
            com.huawei.android.pushagent.b.d.a.b r1 = (com.huawei.android.pushagent.b.d.a.b) r1     // Catch:{ all -> 0x003c }
            boolean r2 = r1.b(r5)     // Catch:{ all -> 0x003c }
            if (r2 != 0) goto L_0x000f
            java.lang.String r4 = "PushLogAC2705"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x003c }
            r5.<init>()     // Catch:{ all -> 0x003c }
            java.lang.String r6 = " control info:"
            r5.append(r6)     // Catch:{ all -> 0x003c }
            r5.append(r1)     // Catch:{ all -> 0x003c }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x003c }
            com.huawei.android.pushagent.c.a.e.b(r4, r5)     // Catch:{ all -> 0x003c }
            r4 = 0
            monitor-exit(r3)
            return r4
        L_0x003a:
            monitor-exit(r3)
            return r0
        L_0x003c:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        L_0x003f:
            monitor-exit(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.b.d.a.b(java.util.List, long):boolean");
    }

    private boolean b(List list, List list2) {
        String str;
        if (0 == c.a(this.a, "lastQueryTRSsucc_time", 0)) {
            if (!a(list, 1)) {
                str = "trsFirstFlowControl not allowed to pass!!";
            } else {
                b(list, 1);
                e();
                return true;
            }
        } else if (!a(list2, 1)) {
            str = "trsFlowControl not allowed to pass!!";
        } else {
            b(list2, 1);
            e();
            return true;
        }
        e.d("PushLogAC2705", str);
        return false;
    }

    public static synchronized void c(Context context) {
        synchronized (a.class) {
            b(context);
            if (h != null && !h.b()) {
                e.a("PushLogAC2705", "TRS cfg change, need reload");
                h.c();
            }
        }
    }

    private boolean c() {
        this.b.clear();
        this.b.add(new com.huawei.android.pushagent.b.d.a.a(86400000, com.huawei.android.pushagent.b.b.a.a(this.a).G()));
        this.b.add(new com.huawei.android.pushagent.b.d.a.a(3600000, com.huawei.android.pushagent.b.b.a.a(this.a).H()));
        this.c.clear();
        this.c.add(new com.huawei.android.pushagent.b.d.a.a(86400000, com.huawei.android.pushagent.b.b.a.a(this.a).I()));
        this.d.clear();
        for (Map.Entry entry : com.huawei.android.pushagent.b.b.a.a(this.a).J().entrySet()) {
            this.d.add(new com.huawei.android.pushagent.b.d.a.a(((Long) entry.getKey()).longValue() * 1000, ((Long) entry.getValue()).longValue()));
        }
        this.e.clear();
        this.e.add(new com.huawei.android.pushagent.b.d.a.a(86400000, com.huawei.android.pushagent.b.b.a.a(this.a).K()));
        this.e.add(new com.huawei.android.pushagent.b.d.a.a(3600000, com.huawei.android.pushagent.b.b.a.a(this.a).L()));
        this.f.clear();
        this.f.add(new com.huawei.android.pushagent.b.d.a.a(86400000, com.huawei.android.pushagent.b.b.a.a(this.a).M()));
        this.g.clear();
        for (Map.Entry entry2 : com.huawei.android.pushagent.b.b.a.a(this.a).R().entrySet()) {
            this.g.add(new com.huawei.android.pushagent.b.d.a.a(((Long) entry2.getKey()).longValue() * 1000, ((Long) entry2.getValue()).longValue()));
        }
        e();
        return true;
    }

    private boolean d() {
        List list;
        List list2;
        if (1 == b.a(this.a)) {
            list = this.e;
            list2 = this.f;
        } else {
            list = this.b;
            list2 = this.c;
        }
        return b(list, list2);
    }

    private boolean e() {
        try {
            h hVar = new h(this.a, "PushConnectControl");
            return b(hVar, this.e, "wifiTrsFirstFlowControlData") && b(hVar, this.f, "wifiTrsFlowControlData") && b(hVar, this.g, "wifiVolumeControlData") && b(hVar, this.b, "trsFirstFlowControlData") && b(hVar, this.c, "trsFlowControlData") && b(hVar, this.d, "volumeControlData");
        } catch (Exception e2) {
            e.c("PushLogAC2705", e2.toString(), e2);
            return false;
        }
    }

    private boolean f() {
        try {
            h hVar = new h(this.a, "PushConnectControl");
            a(hVar, this.b, "trsFirstFlowControlData");
            a(hVar, this.c, "trsFlowControlData");
            a(hVar, this.d, "volumeControlData");
            a(hVar, this.e, "wifiTrsFirstFlowControlData");
            a(hVar, this.f, "wifiTrsFlowControlData");
            a(hVar, this.g, "wifiVolumeControlData");
            return true;
        } catch (Exception e2) {
            e.c("PushLogAC2705", e2.toString(), e2);
            return false;
        }
    }

    public void a() {
        this.b.clear();
        this.c.clear();
        this.d.clear();
        this.e.clear();
        this.f.clear();
        this.g.clear();
    }
}
