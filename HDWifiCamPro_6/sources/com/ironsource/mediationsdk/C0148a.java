package com.ironsource.mediationsdk;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.e;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.ironsource.mediationsdk.a  reason: case insensitive filesystem */
abstract class C0148a {
    e a = null;
    int b;
    final CopyOnWriteArrayList<C0149b> c = new CopyOnWriteArrayList<>();
    C0149b d;
    C0149b e;
    String f;
    String g;
    IronSourceLoggerManager h = IronSourceLoggerManager.getLogger();
    boolean i = false;
    Boolean j;
    boolean k;
    boolean l = true;
    private String m = IronSourceConstants.EVENTS_ERROR_REASON;
    private String n = "status";
    private String o = "placement";
    private String p = IronSourceConstants.EVENTS_REWARD_NAME;
    private String q = IronSourceConstants.EVENTS_REWARD_AMOUNT;
    private String r = "providerPriority";

    C0148a() {
    }

    /* access modifiers changed from: package-private */
    public abstract void a(Context context, boolean z);

    /* access modifiers changed from: package-private */
    public final void a(C0149b bVar) {
        this.c.add(bVar);
        e eVar = this.a;
        if (eVar != null) {
            synchronized (eVar) {
                try {
                    if (bVar.m != 99) {
                        eVar.a.put(eVar.d(bVar), Integer.valueOf(bVar.m));
                    }
                } catch (Exception e2) {
                    eVar.c.logException(IronSourceLogger.IronSourceTag.INTERNAL, "addSmash", e2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean a() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public synchronized void b() {
        this.l = false;
    }

    /* access modifiers changed from: package-private */
    public final void b(C0149b bVar) {
        try {
            String str = H.a().l;
            if (!TextUtils.isEmpty(str) && bVar.b != null) {
                IronSourceLoggerManager ironSourceLoggerManager = bVar.q;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
                ironSourceLoggerManager.log(ironSourceTag, bVar.j() + ":setMediationSegment(segment:" + str + ")", 1);
                bVar.b.setMediationSegment(str);
            }
            String pluginType = ConfigFile.getConfigFile().getPluginType();
            if (!TextUtils.isEmpty(pluginType)) {
                String pluginFrameworkVersion = ConfigFile.getConfigFile().getPluginFrameworkVersion();
                if (bVar.b != null) {
                    bVar.b.setPluginData(pluginType, pluginFrameworkVersion);
                }
            }
        } catch (Exception e2) {
            IronSourceLoggerManager ironSourceLoggerManager2 = this.h;
            IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.INTERNAL;
            ironSourceLoggerManager2.log(ironSourceTag2, ":setCustomParams():" + e2.toString(), 3);
        }
    }
}
