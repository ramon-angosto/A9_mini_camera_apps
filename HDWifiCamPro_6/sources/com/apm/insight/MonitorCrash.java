package com.apm.insight;

import android.content.Context;
import android.text.TextUtils;
import com.apm.insight.j.b;
import com.apm.insight.l.q;
import com.apm.insight.runtime.ConfigManager;
import com.apm.insight.runtime.o;
import java.util.HashMap;
import java.util.Map;

public class MonitorCrash {
    private static volatile boolean sAppMonitorCrashInit = false;
    Config mConfig = new Config();
    AttachUserData mCustomData;
    AttachUserData mCustomLongData;
    HeaderParams mParams;
    HashMap<String, String> mTagMap = new HashMap<>();

    public class Config {
        String mAid;
        String mChannel;
        String mDeviceId;
        String[] mPackageName;
        String mSSID;
        String[] mSoList;
        String mUID;
        long mVersionInt = -1;
        String mVersionStr;

        public Config() {
        }

        public Config setChannel(String str) {
            this.mChannel = str;
            b.d();
            return this;
        }

        public Config setDeviceId(String str) {
            this.mDeviceId = str;
            b.d();
            return this;
        }

        public Config setPackageName(String str) {
            return setPackageName(str);
        }

        public Config setPackageName(String... strArr) {
            this.mPackageName = strArr;
            b.d();
            return this;
        }

        public Config setSSID(String str) {
            this.mSSID = str;
            b.d();
            return this;
        }

        public Config setSoList(String[] strArr) {
            this.mSoList = strArr;
            b.d();
            return this;
        }

        public Config setUID(String str) {
            this.mUID = str;
            b.d();
            return this;
        }
    }

    public interface HeaderParams {
        Map<String, Object> getCommonParams();
    }

    private MonitorCrash(Context context, String str, long j, String str2) {
        Config config = this.mConfig;
        config.mAid = str;
        config.mVersionInt = j;
        config.mVersionStr = str2;
        g.a(context, this);
    }

    private MonitorCrash(String str, long j, String str2, String... strArr) {
        Config config = this.mConfig;
        config.mAid = str;
        config.mVersionInt = j;
        config.mVersionStr = str2;
        config.mPackageName = strArr;
        g.a(this);
    }

    public static MonitorCrash init(Context context, String str, long j, String str2) {
        if (sAppMonitorCrashInit) {
            return null;
        }
        synchronized (MonitorCrash.class) {
            if (sAppMonitorCrashInit) {
                return null;
            }
            sAppMonitorCrashInit = true;
            o.a(context, true, true, true, true, 0);
            MonitorCrash monitorCrash = new MonitorCrash(context, str, j, str2);
            return monitorCrash;
        }
    }

    public static MonitorCrash initSDK(Context context, String str, long j, String str2, String str3) {
        String str4 = str3;
        o.a(context, true, true, true, true, 0);
        MonitorCrash monitorCrash = new MonitorCrash(str, j, str2, str4);
        monitorCrash.config().setPackageName(str4);
        return monitorCrash;
    }

    public static MonitorCrash initSDK(Context context, String str, long j, String str2, String str3, String[] strArr) {
        String str4 = str3;
        o.a(context, true, true, true, true, 0);
        MonitorCrash monitorCrash = new MonitorCrash(str, j, str2, str4);
        monitorCrash.config().setPackageName(str4).setSoList(strArr);
        return monitorCrash;
    }

    public static MonitorCrash initSDK(Context context, String str, long j, String str2, String... strArr) {
        o.a(context, true, true, true, true, 0);
        MonitorCrash monitorCrash = new MonitorCrash(str, j, str2, strArr);
        monitorCrash.config().setPackageName(strArr);
        return monitorCrash;
    }

    public static MonitorCrash initSDK(Context context, String str, long j, String str2, String[] strArr, String[] strArr2) {
        o.a(context, true, true, true, true, 0);
        MonitorCrash monitorCrash = new MonitorCrash(str, j, str2, strArr);
        monitorCrash.config().setPackageName(strArr).setSoList(strArr2);
        return monitorCrash;
    }

    public MonitorCrash addTags(String str, String str2) {
        this.mTagMap.put(str, str2);
        return this;
    }

    public Config config() {
        return this.mConfig;
    }

    public void reportCustomErr(String str, String str2, Throwable th) {
        com.apm.insight.f.b.a(this, th, str, true, (Map<String, String>) null, str2, "core_exception_monitor");
    }

    public MonitorCrash setCustomDataCallback(AttachUserData attachUserData) {
        this.mCustomData = attachUserData;
        return this;
    }

    public MonitorCrash setReportUrl(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        int indexOf = str.indexOf("://");
        if (indexOf < 0) {
            i = 8;
            str = "https://" + str;
        } else {
            i = indexOf + 3;
        }
        int indexOf2 = str.indexOf("/", i);
        if (indexOf2 >= 0) {
            str = str.substring(0, indexOf2);
        }
        q.a((Object) "set url " + str);
        h.i().setLaunchCrashUrl(str + ConfigManager.EXCEPTION_URL_SUFFIX);
        h.i().setJavaCrashUploadUrl(str + ConfigManager.JAVA_URL_SUFFIX);
        h.i().setNativeCrashUrl(str + ConfigManager.NATIVE_URL_SUFFIX);
        h.i().setConfigUrl(str + ConfigManager.CONFIG_URL_SUFFIX);
        return this;
    }

    public MonitorCrash withOtherHeaders(HeaderParams headerParams) {
        this.mParams = headerParams;
        return this;
    }
}
