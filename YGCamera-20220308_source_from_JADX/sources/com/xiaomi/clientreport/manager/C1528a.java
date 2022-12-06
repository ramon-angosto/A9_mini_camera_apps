package com.xiaomi.clientreport.manager;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.clientreport.data.C1526a;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.processor.C1539c;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.push.C1618ak;
import com.xiaomi.push.C1663bo;
import com.xiaomi.push.C1664bp;
import com.xiaomi.push.C1665bq;
import com.xiaomi.push.C1666br;
import com.xiaomi.push.C1667bs;
import com.xiaomi.push.C1670bv;
import com.xiaomi.push.C1938m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.xiaomi.clientreport.manager.a */
public class C1528a {

    /* renamed from: a */
    private static final int f1587a = (C1938m.m4713a() ? 30 : 10);

    /* renamed from: a */
    private static volatile C1528a f1588a;

    /* renamed from: a */
    private Context f1589a;

    /* renamed from: a */
    private Config f1590a;

    /* renamed from: a */
    private IEventProcessor f1591a;

    /* renamed from: a */
    private IPerfProcessor f1592a;

    /* renamed from: a */
    private String f1593a;

    /* renamed from: a */
    private HashMap<String, HashMap<String, C1526a>> f1594a = new HashMap<>();

    /* renamed from: a */
    private ExecutorService f1595a = Executors.newSingleThreadExecutor();

    /* renamed from: b */
    private HashMap<String, ArrayList<C1526a>> f1596b = new HashMap<>();

    private C1528a(Context context) {
        this.f1589a = context;
    }

    /* renamed from: a */
    private int mo16975a() {
        HashMap<String, ArrayList<C1526a>> hashMap = this.f1596b;
        if (hashMap == null) {
            return 0;
        }
        int i = 0;
        for (String str : hashMap.keySet()) {
            ArrayList arrayList = this.f1596b.get(str);
            i += arrayList != null ? arrayList.size() : 0;
        }
        return i;
    }

    /* renamed from: a */
    public static C1528a m2164a(Context context) {
        if (f1588a == null) {
            synchronized (C1528a.class) {
                if (f1588a == null) {
                    f1588a = new C1528a(context);
                }
            }
        }
        return f1588a;
    }

    /* renamed from: a */
    private void m2169a(C1618ak.C1619a aVar, int i) {
        C1618ak.m2518a(this.f1589a).mo17219b(aVar, i);
    }

    /* renamed from: b */
    private int mo16982b() {
        HashMap<String, HashMap<String, C1526a>> hashMap = this.f1594a;
        int i = 0;
        if (hashMap != null) {
            for (String str : hashMap.keySet()) {
                HashMap hashMap2 = this.f1594a.get(str);
                if (hashMap2 != null) {
                    for (String str2 : hashMap2.keySet()) {
                        C1526a aVar = (C1526a) hashMap2.get(str2);
                        if (aVar instanceof PerfClientReport) {
                            i = (int) (((long) i) + ((PerfClientReport) aVar).perfCounts);
                        }
                    }
                }
            }
        }
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2172b(EventClientReport eventClientReport) {
        IEventProcessor iEventProcessor = this.f1591a;
        if (iEventProcessor != null) {
            iEventProcessor.mo16999a(eventClientReport);
            if (mo16975a() >= 10) {
                m2175d();
                C1618ak.m2518a(this.f1589a).mo17218a("100888");
                return;
            }
            m2169a((C1618ak.C1619a) new C1531d(this), f1587a);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2173b(PerfClientReport perfClientReport) {
        IPerfProcessor iPerfProcessor = this.f1592a;
        if (iPerfProcessor != null) {
            iPerfProcessor.mo16999a(perfClientReport);
            if (mo16982b() >= 10) {
                m2176e();
                C1618ak.m2518a(this.f1589a).mo17218a("100889");
                return;
            }
            m2169a((C1618ak.C1619a) new C1533f(this), f1587a);
        }
    }

    /* renamed from: d */
    private void m2175d() {
        try {
            this.f1591a.mo17002b();
        } catch (Exception e) {
            C1524b.m2160d("we: " + e.getMessage());
        }
    }

    /* renamed from: e */
    private void m2176e() {
        try {
            this.f1592a.mo17002b();
        } catch (Exception e) {
            C1524b.m2160d("wp: " + e.getMessage());
        }
    }

    /* renamed from: f */
    private void m2177f() {
        if (m2164a(this.f1589a).mo16975a().isEventUploadSwitchOpen()) {
            C1664bp bpVar = new C1664bp(this.f1589a);
            int eventUploadFrequency = (int) m2164a(this.f1589a).mo16975a().getEventUploadFrequency();
            int i = 1800;
            if (eventUploadFrequency >= 1800) {
                i = eventUploadFrequency;
            }
            if (System.currentTimeMillis() - C1670bv.m2754a(this.f1589a).mo17268a("sp_client_report_status", "event_last_upload_time", 0) > ((long) (i * 1000))) {
                C1618ak.m2518a(this.f1589a).mo17213a((Runnable) new C1535h(this, bpVar), 10);
            }
            synchronized (C1528a.class) {
                if (!C1618ak.m2518a(this.f1589a).mo17215a((C1618ak.C1619a) bpVar, i)) {
                    C1618ak.m2518a(this.f1589a).mo17218a("100886");
                    C1618ak.m2518a(this.f1589a).mo17215a((C1618ak.C1619a) bpVar, i);
                }
            }
        }
    }

    /* renamed from: g */
    private void m2178g() {
        if (m2164a(this.f1589a).mo16975a().isPerfUploadSwitchOpen()) {
            C1665bq bqVar = new C1665bq(this.f1589a);
            int perfUploadFrequency = (int) m2164a(this.f1589a).mo16975a().getPerfUploadFrequency();
            int i = 1800;
            if (perfUploadFrequency >= 1800) {
                i = perfUploadFrequency;
            }
            if (System.currentTimeMillis() - C1670bv.m2754a(this.f1589a).mo17268a("sp_client_report_status", "perf_last_upload_time", 0) > ((long) (i * 1000))) {
                C1618ak.m2518a(this.f1589a).mo17213a((Runnable) new C1536i(this, bqVar), 15);
            }
            synchronized (C1528a.class) {
                if (!C1618ak.m2518a(this.f1589a).mo17215a((C1618ak.C1619a) bqVar, i)) {
                    C1618ak.m2518a(this.f1589a).mo17218a("100887");
                    C1618ak.m2518a(this.f1589a).mo17215a((C1618ak.C1619a) bqVar, i);
                }
            }
        }
    }

    /* renamed from: a */
    public synchronized Config m2179a() {
        if (this.f1590a == null) {
            this.f1590a = Config.defaultConfig(this.f1589a);
        }
        return this.f1590a;
    }

    /* renamed from: a */
    public EventClientReport mo16976a(int i, String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.eventContent = str;
        eventClientReport.eventTime = System.currentTimeMillis();
        eventClientReport.eventType = i;
        eventClientReport.eventId = C1663bo.m2726a(6);
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = "E100004";
        eventClientReport.setAppPackageName(this.f1589a.getPackageName());
        eventClientReport.setSdkVersion(this.f1593a);
        return eventClientReport;
    }

    /* renamed from: a */
    public void m2181a() {
        m2164a(this.f1589a).m2177f();
        m2164a(this.f1589a).m2178g();
    }

    /* renamed from: a */
    public void mo16977a(Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        this.f1590a = config;
        this.f1591a = iEventProcessor;
        this.f1592a = iPerfProcessor;
        this.f1591a.setEventMap(this.f1596b);
        this.f1592a.setPerfMap(this.f1594a);
    }

    /* renamed from: a */
    public void mo16978a(EventClientReport eventClientReport) {
        if (mo16975a().isEventUploadSwitchOpen()) {
            this.f1595a.execute(new C1529b(this, eventClientReport));
        }
    }

    /* renamed from: a */
    public void mo16979a(PerfClientReport perfClientReport) {
        if (mo16975a().isPerfUploadSwitchOpen()) {
            this.f1595a.execute(new C1530c(this, perfClientReport));
        }
    }

    /* renamed from: a */
    public void mo16980a(String str) {
        this.f1593a = str;
    }

    /* renamed from: a */
    public void mo16981a(boolean z, boolean z2, long j, long j2) {
        Config config = this.f1590a;
        if (config == null) {
            return;
        }
        if (z != config.isEventUploadSwitchOpen() || z2 != this.f1590a.isPerfUploadSwitchOpen() || j != this.f1590a.getEventUploadFrequency() || j2 != this.f1590a.getPerfUploadFrequency()) {
            long eventUploadFrequency = this.f1590a.getEventUploadFrequency();
            long perfUploadFrequency = this.f1590a.getPerfUploadFrequency();
            Config build = Config.getBuilder().setAESKey(C1667bs.m2746a(this.f1589a)).setEventEncrypted(this.f1590a.isEventEncrypted()).setEventUploadSwitchOpen(z).setEventUploadFrequency(j).setPerfUploadSwitchOpen(z2).setPerfUploadFrequency(j2).build(this.f1589a);
            this.f1590a = build;
            if (!this.f1590a.isEventUploadSwitchOpen()) {
                C1618ak.m2518a(this.f1589a).mo17218a("100886");
            } else if (eventUploadFrequency != build.getEventUploadFrequency()) {
                C1524b.m2159c(this.f1589a.getPackageName() + "reset event job " + build.getEventUploadFrequency());
                m2177f();
            }
            if (!this.f1590a.isPerfUploadSwitchOpen()) {
                C1618ak.m2518a(this.f1589a).mo17218a("100887");
            } else if (perfUploadFrequency != build.getPerfUploadFrequency()) {
                C1524b.m2159c(this.f1589a.getPackageName() + " reset perf job " + build.getPerfUploadFrequency());
                m2178g();
            }
        }
    }

    /* renamed from: b */
    public void m2187b() {
        if (mo16975a().isEventUploadSwitchOpen()) {
            C1666br brVar = new C1666br();
            brVar.mo17263a(this.f1589a);
            brVar.mo17264a((C1539c) this.f1591a);
            this.f1595a.execute(brVar);
        }
    }

    /* renamed from: c */
    public void mo16983c() {
        if (mo16975a().isPerfUploadSwitchOpen()) {
            C1666br brVar = new C1666br();
            brVar.mo17264a((C1539c) this.f1592a);
            brVar.mo17263a(this.f1589a);
            this.f1595a.execute(brVar);
        }
    }
}
