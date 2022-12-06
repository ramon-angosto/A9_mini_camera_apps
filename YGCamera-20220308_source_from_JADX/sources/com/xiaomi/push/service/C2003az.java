package com.xiaomi.push.service;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.p003os.EnvironmentCompat;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.xiaomi.push.service.az */
public class C2003az {

    /* renamed from: a */
    private static C2003az f3726a;

    /* renamed from: a */
    private List<C2004a> f3727a = new ArrayList();

    /* renamed from: a */
    private ConcurrentHashMap<String, HashMap<String, C2005b>> f3728a = new ConcurrentHashMap<>();

    /* renamed from: com.xiaomi.push.service.az$a */
    public interface C2004a {
        /* renamed from: a */
        void mo18489a();
    }

    /* renamed from: com.xiaomi.push.service.az$b */
    public static class C2005b {

        /* renamed from: a */
        private int f3729a = 0;

        /* renamed from: a */
        public Context f3730a;

        /* renamed from: a */
        IBinder.DeathRecipient f3731a = null;

        /* renamed from: a */
        Messenger f3732a;

        /* renamed from: a */
        private XMPushService.C1949b f3733a = new XMPushService.C1949b(this);

        /* renamed from: a */
        private XMPushService f3734a;

        /* renamed from: a */
        final C2007b f3735a = new C2007b();

        /* renamed from: a */
        C2009c f3736a = C2009c.unbind;

        /* renamed from: a */
        public C2058f f3737a;

        /* renamed from: a */
        public String f3738a;

        /* renamed from: a */
        private List<C2006a> f3739a = new ArrayList();

        /* renamed from: a */
        public boolean f3740a;

        /* renamed from: b */
        C2009c f3741b = null;

        /* renamed from: b */
        public String f3742b;

        /* renamed from: b */
        private boolean f3743b = false;

        /* renamed from: c */
        public String f3744c;

        /* renamed from: d */
        public String f3745d;

        /* renamed from: e */
        public String f3746e;

        /* renamed from: f */
        public String f3747f;

        /* renamed from: g */
        public String f3748g;

        /* renamed from: h */
        public String f3749h;

        /* renamed from: i */
        public String f3750i;

        /* renamed from: com.xiaomi.push.service.az$b$a */
        public interface C2006a {
            /* renamed from: a */
            void mo17751a(C2009c cVar, C2009c cVar2, int i);
        }

        /* renamed from: com.xiaomi.push.service.az$b$b */
        class C2007b extends XMPushService.C1956i {

            /* renamed from: a */
            String f3752a;

            /* renamed from: b */
            int f3753b;

            /* renamed from: b */
            String f3754b;

            /* renamed from: c */
            int f3755c;

            public C2007b() {
                super(0);
            }

            /* renamed from: a */
            public XMPushService.C1956i mo18496a(int i, int i2, String str, String str2) {
                this.f3753b = i;
                this.f3755c = i2;
                this.f3754b = str2;
                this.f3752a = str;
                return this;
            }

            /* renamed from: a */
            public String mo17683a() {
                return "notify job";
            }

            /* renamed from: a */
            public void m5107a() {
                if (C2005b.this.m5094a(this.f3753b, this.f3755c, this.f3754b)) {
                    C2005b.this.m5092a(this.f3753b, this.f3755c, this.f3752a, this.f3754b);
                    return;
                }
                C1524b.m2158b(" ignore notify client :" + C2005b.this.f3748g);
            }
        }

        /* renamed from: com.xiaomi.push.service.az$b$c */
        class C2008c implements IBinder.DeathRecipient {

            /* renamed from: a */
            final Messenger f3756a;

            /* renamed from: a */
            final C2005b f3757a;

            C2008c(C2005b bVar, Messenger messenger) {
                this.f3757a = bVar;
                this.f3756a = messenger;
            }

            public void binderDied() {
                C1524b.m2158b("peer died, chid = " + this.f3757a.f3748g);
                C2005b.m5089a(C2005b.this).mo18413a((XMPushService.C1956i) new C2012bb(this, 0), 0);
                if ("9".equals(this.f3757a.f3748g) && "com.xiaomi.xmsf".equals(C2005b.m5089a(C2005b.this).getPackageName())) {
                    C2005b.m5089a(C2005b.this).mo18413a((XMPushService.C1956i) new C2013bc(this, 0), 60000);
                }
            }
        }

        public C2005b() {
        }

        public C2005b(XMPushService xMPushService) {
            this.f3734a = xMPushService;
            mo18493a((C2006a) new C2011ba(this));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
            r0 = r3.lastIndexOf("/");
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.String m5091a(java.lang.String r3) {
            /*
                boolean r0 = android.text.TextUtils.isEmpty(r3)
                java.lang.String r1 = ""
                if (r0 == 0) goto L_0x0009
                return r1
            L_0x0009:
                java.lang.String r0 = "/"
                int r0 = r3.lastIndexOf(r0)
                r2 = -1
                if (r0 == r2) goto L_0x0018
                int r0 = r0 + 1
                java.lang.String r1 = r3.substring(r0)
            L_0x0018:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C2003az.C2005b.m5091a(java.lang.String):java.lang.String");
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m5092a(int i, int i2, String str, String str2) {
            C2009c cVar = this.f3736a;
            this.f3741b = cVar;
            if (i == 2) {
                this.f3737a.mo18524a(this.f3730a, this, i2);
            } else if (i == 3) {
                this.f3737a.mo18525a(this.f3730a, this, str2, str);
            } else if (i == 1) {
                boolean z = cVar == C2009c.binded;
                if (!z && "wait".equals(str2)) {
                    this.f3729a++;
                } else if (z) {
                    this.f3729a = 0;
                    if (this.f3732a != null) {
                        try {
                            this.f3732a.send(Message.obtain((Handler) null, 16, this.f3734a.f3599a));
                        } catch (RemoteException unused) {
                        }
                    }
                }
                this.f3737a.mo18526a(this.f3734a, this, z, i2, str);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public boolean m5094a(int i, int i2, String str) {
            boolean z;
            StringBuilder sb;
            String str2;
            C2009c cVar = this.f3741b;
            if (cVar == null || !(z = this.f3743b)) {
                return true;
            }
            if (cVar == this.f3736a) {
                sb = new StringBuilder();
                str2 = " status recovered, don't notify client:";
            } else if (this.f3732a == null || !z) {
                sb = new StringBuilder();
                str2 = "peer died, ignore notify ";
            } else {
                C1524b.m2158b("Peer alive notify status to client:" + this.f3748g);
                return true;
            }
            sb.append(str2);
            sb.append(this.f3748g);
            C1524b.m2158b(sb.toString());
            return false;
        }

        /* renamed from: b */
        private boolean m5096b(int i, int i2, String str) {
            if (i == 1) {
                return this.f3736a != C2009c.binded && this.f3734a.mo18423c() && i2 != 21 && (i2 != 7 || !"wait".equals(str));
            }
            if (i == 2) {
                return this.f3734a.mo18423c();
            }
            if (i != 3) {
                return false;
            }
            return !"wait".equals(str);
        }

        /* renamed from: a */
        public long mo18490a() {
            return (((long) ((Math.random() * 20.0d) - 10.0d)) + ((long) ((this.f3729a + 1) * 15))) * 1000;
        }

        /* renamed from: a */
        public String mo18491a(int i) {
            return i != 1 ? i != 2 ? i != 3 ? EnvironmentCompat.MEDIA_UNKNOWN : "KICK" : "CLOSE" : "OPEN";
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void m5099a() {
            try {
                Messenger messenger = this.f3732a;
                if (!(messenger == null || this.f3731a == null)) {
                    messenger.getBinder().unlinkToDeath(this.f3731a, 0);
                }
            } catch (Exception unused) {
            }
            this.f3741b = null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo18492a(Messenger messenger) {
            mo18490a();
            if (messenger != null) {
                try {
                    this.f3732a = messenger;
                    this.f3743b = true;
                    this.f3731a = new C2008c(this, messenger);
                    messenger.getBinder().linkToDeath(this.f3731a, 0);
                } catch (Exception e) {
                    C1524b.m2158b("peer linkToDeath err: " + e.getMessage());
                    this.f3732a = null;
                    this.f3743b = false;
                }
            } else {
                C1524b.m2158b("peer linked with old sdk chid = " + this.f3748g);
            }
        }

        /* renamed from: a */
        public void mo18493a(C2006a aVar) {
            synchronized (this.f3739a) {
                this.f3739a.add(aVar);
            }
        }

        /* renamed from: a */
        public void mo18494a(C2009c cVar, int i, int i2, String str, String str2) {
            boolean z;
            synchronized (this.f3739a) {
                for (C2006a a : this.f3739a) {
                    a.mo17751a(this.f3736a, cVar, i2);
                }
            }
            C2009c cVar2 = this.f3736a;
            int i3 = 0;
            if (cVar2 != cVar) {
                C1524b.m2141a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", new Object[]{cVar2, cVar, mo18491a(i), C2014bd.m5114a(i2), str, str2, this.f3748g}));
                this.f3736a = cVar;
            }
            if (this.f3737a == null) {
                C1524b.m2160d("status changed while the client dispatcher is missing");
            } else if (cVar != C2009c.binding) {
                if (this.f3741b != null && (z = this.f3743b)) {
                    i3 = (this.f3732a == null || !z) ? 10100 : 1000;
                }
                this.f3734a.mo18422b((XMPushService.C1956i) this.f3735a);
                if (m5096b(i, i2, str2)) {
                    m5092a(i, i2, str, str2);
                } else {
                    this.f3734a.mo18413a(this.f3735a.mo18496a(i, i2, str, str2), (long) i3);
                }
            }
        }

        /* renamed from: b */
        public void mo18495b(C2006a aVar) {
            synchronized (this.f3739a) {
                this.f3739a.remove(aVar);
            }
        }
    }

    /* renamed from: com.xiaomi.push.service.az$c */
    public enum C2009c {
        unbind,
        binding,
        binded
    }

    private C2003az() {
    }

    /* renamed from: a */
    public static synchronized C2003az mo18481a() {
        C2003az azVar;
        synchronized (C2003az.class) {
            if (f3726a == null) {
                f3726a = new C2003az();
            }
            azVar = f3726a;
        }
        return azVar;
    }

    /* renamed from: a */
    private String mo18483a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("@");
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    /* renamed from: a */
    public synchronized int m5075a() {
        return this.f3728a.size();
    }

    /* renamed from: a */
    public synchronized C2005b mo18482a(String str, String str2) {
        HashMap hashMap = this.f3728a.get(str);
        if (hashMap == null) {
            return null;
        }
        return (C2005b) hashMap.get(mo18483a(str2));
    }

    /* renamed from: a */
    public synchronized ArrayList<C2005b> m5077a() {
        ArrayList<C2005b> arrayList;
        arrayList = new ArrayList<>();
        for (HashMap<String, C2005b> values : this.f3728a.values()) {
            arrayList.addAll(values.values());
        }
        return arrayList;
    }

    /* renamed from: a */
    public synchronized Collection<C2005b> m5078a(String str) {
        if (!this.f3728a.containsKey(str)) {
            return new ArrayList();
        }
        return ((HashMap) this.f3728a.get(str).clone()).values();
    }

    /* renamed from: a */
    public synchronized List<String> m5079a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (HashMap<String, C2005b> values : this.f3728a.values()) {
            for (C2005b bVar : values.values()) {
                if (str.equals(bVar.f3738a)) {
                    arrayList.add(bVar.f3748g);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public synchronized void m5080a() {
        Iterator it = mo18481a().iterator();
        while (it.hasNext()) {
            ((C2005b) it.next()).mo18490a();
        }
        this.f3728a.clear();
    }

    /* renamed from: a */
    public synchronized void mo18484a(Context context) {
        for (HashMap<String, C2005b> values : this.f3728a.values()) {
            for (C2005b a : values.values()) {
                a.mo18494a(C2009c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo18485a(Context context, int i) {
        for (HashMap<String, C2005b> values : this.f3728a.values()) {
            for (C2005b a : values.values()) {
                a.mo18494a(C2009c.unbind, 2, i, (String) null, (String) null);
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo18486a(C2004a aVar) {
        this.f3727a.add(aVar);
    }

    /* renamed from: a */
    public synchronized void mo18487a(C2005b bVar) {
        HashMap hashMap = this.f3728a.get(bVar.f3748g);
        if (hashMap == null) {
            hashMap = new HashMap();
            this.f3728a.put(bVar.f3748g, hashMap);
        }
        hashMap.put(mo18483a(bVar.f3742b), bVar);
        for (C2004a a : this.f3727a) {
            a.mo18489a();
        }
    }

    /* renamed from: a */
    public synchronized void m5085a(String str) {
        HashMap hashMap = this.f3728a.get(str);
        if (hashMap != null) {
            for (C2005b a : hashMap.values()) {
                a.mo18490a();
            }
            hashMap.clear();
            this.f3728a.remove(str);
        }
        for (C2004a a2 : this.f3727a) {
            a2.mo18489a();
        }
    }

    /* renamed from: a */
    public synchronized void m5086a(String str, String str2) {
        HashMap hashMap = this.f3728a.get(str);
        if (hashMap != null) {
            C2005b bVar = (C2005b) hashMap.get(mo18483a(str2));
            if (bVar != null) {
                bVar.mo18490a();
            }
            hashMap.remove(mo18483a(str2));
            if (hashMap.isEmpty()) {
                this.f3728a.remove(str);
            }
        }
        for (C2004a a : this.f3727a) {
            a.mo18489a();
        }
    }

    /* renamed from: b */
    public synchronized void mo18488b() {
        this.f3727a.clear();
    }
}
