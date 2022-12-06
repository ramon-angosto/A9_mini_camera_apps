package com.xiaomi.clientreport.manager;

import android.content.Context;
import android.os.Process;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.processor.C1537a;
import com.xiaomi.clientreport.processor.C1538b;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.push.C1816g;

public class ClientReportClient {
    public static void init(Context context) {
        init(context, Config.defaultConfig(context), new C1537a(context), new C1538b(context));
    }

    public static void init(Context context, Config config) {
        init(context, config, new C1537a(context), new C1538b(context));
    }

    public static void init(Context context, Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        C1524b.m2159c("init in process " + C1816g.m3664a(context) + " pid :" + Process.myPid() + " threadId: " + Thread.currentThread().getId());
        C1528a.m2164a(context).mo16977a(config, iEventProcessor, iPerfProcessor);
        if (C1816g.m3664a(context)) {
            C1524b.m2159c("init in process　start scheduleJob");
            C1528a.m2164a(context).mo16975a();
        }
    }

    public static void reportEvent(Context context, EventClientReport eventClientReport) {
        if (eventClientReport != null) {
            C1528a.m2164a(context).mo16978a(eventClientReport);
        }
    }

    public static void reportPerf(Context context, PerfClientReport perfClientReport) {
        if (perfClientReport != null) {
            C1528a.m2164a(context).mo16979a(perfClientReport);
        }
    }

    public static void updateConfig(Context context, Config config) {
        if (config != null) {
            C1528a.m2164a(context).mo16981a(config.isEventUploadSwitchOpen(), config.isPerfUploadSwitchOpen(), config.getEventUploadFrequency(), config.getPerfUploadFrequency());
        }
    }
}
