package com.apm.insight.runtime;

import android.content.Context;
import com.apm.insight.ICommonParams;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class i {
    public static d a(Context context) {
        return new d(context, new ICommonParams() {
            public Map<String, Object> getCommonParams() {
                return new HashMap();
            }

            public String getDeviceId() {
                return null;
            }

            public List<String> getPatchInfo() {
                return null;
            }

            public Map<String, Integer> getPluginInfo() {
                return null;
            }

            public String getSessionId() {
                return null;
            }

            public long getUserId() {
                return 0;
            }
        });
    }
}
