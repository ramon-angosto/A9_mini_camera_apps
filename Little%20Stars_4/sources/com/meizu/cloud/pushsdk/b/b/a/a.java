package com.meizu.cloud.pushsdk.b.b.a;

import com.meizu.cloud.pushsdk.a.d.i;
import com.meizu.cloud.pushsdk.b.b.c;
import com.meizu.cloud.pushsdk.b.b.g;
import com.meizu.cloud.pushsdk.b.f.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class a extends c {
    private final String t = a.class.getSimpleName();
    /* access modifiers changed from: private */
    public com.meizu.cloud.pushsdk.b.d.a u = new com.meizu.cloud.pushsdk.b.d.a(this.d, this.o);
    private int v;

    public a(c.a aVar) {
        super(aVar);
    }

    public void a(com.meizu.cloud.pushsdk.b.a.a aVar) {
        this.u.a(aVar);
        String str = this.t;
        com.meizu.cloud.pushsdk.b.f.c.a(str, "isRunning " + this.s, new Object[0]);
        if (this.s.compareAndSet(false, true)) {
            c();
        }
    }

    public void a() {
        b.a((Runnable) new Runnable() {
            public void run() {
                if (a.this.s.compareAndSet(false, true)) {
                    a.this.c();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void c() {
        if (!e.a(this.d)) {
            com.meizu.cloud.pushsdk.b.f.c.a(this.t, "Emitter loop stopping: emitter offline.", new Object[0]);
            this.s.compareAndSet(true, false);
        } else if (this.u.b() > 0) {
            this.v = 0;
            LinkedList<g> a = a(a(this.u.c()));
            com.meizu.cloud.pushsdk.b.f.c.c(this.t, "Processing emitter results.", new Object[0]);
            LinkedList linkedList = new LinkedList();
            Iterator it = a.iterator();
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                g gVar = (g) it.next();
                if (gVar.a()) {
                    Iterator it2 = gVar.b().iterator();
                    while (it2.hasNext()) {
                        linkedList.add((Long) it2.next());
                    }
                    i += gVar.b().size();
                } else {
                    i2 += gVar.b().size();
                    com.meizu.cloud.pushsdk.b.f.c.a(this.t, "Request sending failed but we will retry later.", new Object[0]);
                }
            }
            b((LinkedList<Long>) linkedList);
            com.meizu.cloud.pushsdk.b.f.c.b(this.t, "Success Count: %s", Integer.valueOf(i));
            com.meizu.cloud.pushsdk.b.f.c.b(this.t, "Failure Count: %s", Integer.valueOf(i2));
            if (this.f != null) {
                if (i2 != 0) {
                    this.f.a(i, i2);
                } else {
                    this.f.a(i);
                }
            }
            if (i2 <= 0 || i != 0) {
                c();
                return;
            }
            if (e.a(this.d)) {
                com.meizu.cloud.pushsdk.b.f.c.a(this.t, "Ensure collector path is valid: %s", b());
            }
            com.meizu.cloud.pushsdk.b.f.c.a(this.t, "Emitter loop stopping: failures.", new Object[0]);
            this.s.compareAndSet(true, false);
        } else if (this.v >= this.n) {
            com.meizu.cloud.pushsdk.b.f.c.a(this.t, "Emitter loop stopping: empty limit reached.", new Object[0]);
            this.s.compareAndSet(true, false);
        } else {
            this.v++;
            com.meizu.cloud.pushsdk.b.f.c.a(this.t, "Emitter database empty: " + this.v, new Object[0]);
            try {
                this.r.sleep((long) this.m);
            } catch (InterruptedException e) {
                com.meizu.cloud.pushsdk.b.f.c.a(this.t, "Emitter thread sleep interrupted: " + e.toString(), new Object[0]);
            }
            c();
        }
    }

    private LinkedList<g> a(LinkedList<com.meizu.cloud.pushsdk.b.b.e> linkedList) {
        LinkedList<g> linkedList2 = new LinkedList<>();
        LinkedList linkedList3 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList3.add(b.a((Callable) b(((com.meizu.cloud.pushsdk.b.b.e) it.next()).a())));
        }
        com.meizu.cloud.pushsdk.b.f.c.b(this.t, "Request Futures: %s", Integer.valueOf(linkedList3.size()));
        for (int i = 0; i < linkedList3.size(); i++) {
            int i2 = -1;
            try {
                i2 = ((Integer) ((Future) linkedList3.get(i)).get(5, TimeUnit.SECONDS)).intValue();
            } catch (InterruptedException e) {
                com.meizu.cloud.pushsdk.b.f.c.a(this.t, "Request Future was interrupted: %s", e.getMessage());
            } catch (ExecutionException e2) {
                com.meizu.cloud.pushsdk.b.f.c.a(this.t, "Request Future failed: %s", e2.getMessage());
            } catch (TimeoutException e3) {
                com.meizu.cloud.pushsdk.b.f.c.a(this.t, "Request Future had a timeout: %s", e3.getMessage());
            }
            if (linkedList.get(i).c()) {
                linkedList2.add(new g(true, linkedList.get(i).b()));
            } else {
                linkedList2.add(new g(a(i2), linkedList.get(i).b()));
            }
        }
        return linkedList2;
    }

    private LinkedList<Boolean> b(LinkedList<Long> linkedList) {
        boolean z;
        LinkedList<Boolean> linkedList2 = new LinkedList<>();
        LinkedList linkedList3 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList3.add(b.a((Callable) a((Long) it.next())));
        }
        com.meizu.cloud.pushsdk.b.f.c.b(this.t, "Removal Futures: %s", Integer.valueOf(linkedList3.size()));
        for (int i = 0; i < linkedList3.size(); i++) {
            try {
                z = ((Boolean) ((Future) linkedList3.get(i)).get(5, TimeUnit.SECONDS)).booleanValue();
            } catch (InterruptedException e) {
                com.meizu.cloud.pushsdk.b.f.c.a(this.t, "Removal Future was interrupted: %s", e.getMessage());
                z = false;
                linkedList2.add(Boolean.valueOf(z));
            } catch (ExecutionException e2) {
                com.meizu.cloud.pushsdk.b.f.c.a(this.t, "Removal Future failed: %s", e2.getMessage());
                z = false;
                linkedList2.add(Boolean.valueOf(z));
            } catch (TimeoutException e3) {
                com.meizu.cloud.pushsdk.b.f.c.a(this.t, "Removal Future had a timeout: %s", e3.getMessage());
                z = false;
                linkedList2.add(Boolean.valueOf(z));
            }
            linkedList2.add(Boolean.valueOf(z));
        }
        return linkedList2;
    }

    private Callable<Integer> b(final i iVar) {
        return new Callable<Integer>() {
            /* renamed from: a */
            public Integer call() throws Exception {
                return Integer.valueOf(a.this.a(iVar));
            }
        };
    }

    private Callable<Boolean> a(final Long l) {
        return new Callable<Boolean>() {
            /* renamed from: a */
            public Boolean call() throws Exception {
                return Boolean.valueOf(a.this.u.a(l.longValue()));
            }
        };
    }
}
