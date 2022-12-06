package com.xiaomi.network;

import java.util.ArrayList;
import java.util.Iterator;

class b extends Fallback {
    Fallback i = this.j;
    final /* synthetic */ Fallback j;
    final /* synthetic */ HostManager k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    b(HostManager hostManager, String str, Fallback fallback) {
        super(str);
        this.k = hostManager;
        this.j = fallback;
        this.b = this.b;
        Fallback fallback2 = this.j;
        if (fallback2 != null) {
            this.f = fallback2.f;
        }
    }

    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        arrayList = new ArrayList<>();
        if (this.i != null) {
            arrayList.addAll(this.i.a(true));
        }
        synchronized (HostManager.mReservedHosts) {
            ArrayList arrayList2 = HostManager.mReservedHosts.get(this.b);
            if (arrayList2 != null) {
                ArrayList<String> a = this.i != null ? this.i.a(false) : arrayList;
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (a.indexOf(str) == -1) {
                        arrayList.add(str);
                    }
                }
                arrayList.remove(this.b);
                arrayList.add(this.b);
            }
        }
        return arrayList;
    }

    public synchronized void a(String str, AccessHistory accessHistory) {
        if (this.i != null) {
            this.i.a(str, accessHistory);
        }
    }

    public boolean b() {
        return false;
    }
}
