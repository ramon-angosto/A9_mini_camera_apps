package com.huawei.android.microkernel;

import com.huawei.android.pushagent.PushEventReceiver;
import com.huawei.android.pushagent.PushService;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.a.h;
import com.huawei.android.pushagent.c.c;
import com.huawei.deviceCloud.microKernel.core.intf.IPluginContext;

public class Activator {
    public void start(IPluginContext iPluginContext) {
        e.a("PushLogAC2705", "Start push plugin");
        h hVar = new h(iPluginContext.getAppContext(), "push_active");
        if (2705 > hVar.c("pushPluginVersion")) {
            c.a(iPluginContext.getAppContext());
            hVar.a("pushPluginVersion", (Integer) 2705);
        } else {
            e.a("PushLogAC2705", "plugin version not changed");
        }
        iPluginContext.registerService("PushEventReceiver", new PushEventReceiver());
        MKService.setAppContext(iPluginContext.getAppContext());
        iPluginContext.registerService("PushService", new PushService());
        e.a("PushLogAC2705", "Start push plugin success,and registerService :PushEventReceiver,PushService");
    }

    public void stop(IPluginContext iPluginContext) {
        System.out.println("push Activator Stop!");
    }
}
