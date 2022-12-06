package com.huawei.android.pushselfshow;

import com.huawei.android.pushagent.c.a.e;
import com.huawei.deviceCloud.microKernel.core.intf.IPluginActivator;
import com.huawei.deviceCloud.microKernel.core.intf.IPluginContext;

public class Activator implements IPluginActivator {
    public void start(IPluginContext iPluginContext) {
        e.a("PushSelfShowLog", "Start push plugin");
    }

    public void stop(IPluginContext iPluginContext) {
        e.a("PushSelfShowLog", "push Activator Stop!");
    }
}
