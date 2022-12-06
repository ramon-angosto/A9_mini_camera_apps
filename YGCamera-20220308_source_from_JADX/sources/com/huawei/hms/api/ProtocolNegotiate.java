package com.huawei.hms.api;

import java.util.List;

public class ProtocolNegotiate {

    /* renamed from: b */
    private static ProtocolNegotiate f336b = new ProtocolNegotiate();

    /* renamed from: a */
    private int f337a = 1;

    public static ProtocolNegotiate getInstance() {
        return f336b;
    }

    public int getVersion() {
        return this.f337a;
    }

    public int negotiate(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            this.f337a = 1;
            return this.f337a;
        }
        if (!list.contains(2)) {
            this.f337a = list.get(list.size() - 1).intValue();
        } else {
            this.f337a = 2;
        }
        return this.f337a;
    }
}
