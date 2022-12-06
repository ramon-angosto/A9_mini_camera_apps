package com.mbridge.msdk.out;

import android.content.Context;
import java.util.Map;

public abstract class MBCommonHandler {
    protected Context context;
    protected Map<String, Object> properties;

    public abstract boolean load();

    public abstract void release();

    public MBCommonHandler() {
    }

    public MBCommonHandler(Map<String, Object> map, Context context2) {
        this.properties = map;
        this.context = context2;
    }
}
