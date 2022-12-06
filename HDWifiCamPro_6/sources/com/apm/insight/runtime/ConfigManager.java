package com.apm.insight.runtime;

import android.content.Context;
import android.text.TextUtils;
import com.apm.insight.ICommonParams;
import com.apm.insight.d;
import com.apm.insight.h;
import com.apm.insight.j.b;
import com.apm.insight.k.a;
import com.apm.insight.l.g;
import com.apm.insight.l.j;
import com.apm.insight.l.p;
import com.vungle.warren.model.AdvertisementDBAdapter;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;

public class ConfigManager {
    public static final long BLOCK_MONITOR_INTERVAL = 1000;
    private static final long BLOCK_MONITOR_MIN_INTERVAL = 10;
    public static final String CONFIG_URL_SUFFIX = "/settings/get";
    public static final String EXCEPTION_URL_SUFFIX = "/monitor/collect/c/exception";
    public static final String JAVA_URL_SUFFIX = "/monitor/collect/c/crash";
    private static final long LAUNCH_CRASH_INTERVAL = 8000;
    public static final String LAUNCH_URL_SUFFIX = "/monitor/collect/c/exception/dump_collection";
    public static final String LOG_TYPE_ALL_STACK = "npth_enable_all_thread_stack";
    public static final String NATIVE_URL_SUFFIX = "/monitor/collect/c/native_bin_crash";
    private String mAlogUploadUrl = "";
    private String mAsanReportUploadUrl = "";
    private boolean mBlockMonitorEnable = false;
    private long mBlockMonitorInterval = 1000;
    private String mConfigUrl = "";
    private String mCoreDumpUrl = "";
    private d mEncryptImpl = new d() {
        public byte[] a(byte[] bArr) {
            return g.a(bArr);
        }
    };
    private boolean mEnsureEnable = true;
    private boolean mEnsureWithLogcat = false;
    private String mExceptionUploadUrl = "";
    private boolean mIsDebugMode = false;
    private String mJavaCrashUploadUrl = "";
    private long mLaunchCrashInterval = LAUNCH_CRASH_INTERVAL;
    private String mLaunchCrashUploadUrl = "";
    private int mLogcatDumpCount = 512;
    private int mLogcatLevel = 1;
    private boolean mNativeCrashMiniDump = true;
    private String mNativeCrashUploadUrl = "";
    private String mNativeMemUrl = "";
    private ThreadPoolExecutor mThreadPoolExecutor;
    private boolean reportErrorEnable = true;

    public static void setDefaultCommonParams(ICommonParams iCommonParams, Context context) {
        h.a(new d(context, iCommonParams));
    }

    public static void updateDid(final String str) {
        p.b().a((Runnable) new Runnable() {
            public void run() {
                h.c().a(str);
                b.d();
            }
        });
    }

    public String getAlogUploadUrl() {
        return this.mAlogUploadUrl;
    }

    public String getAsanReportUploadUrl() {
        return this.mAsanReportUploadUrl;
    }

    public long getBlockInterval() {
        return this.mBlockMonitorInterval;
    }

    public String getConfigUrl() {
        return this.mConfigUrl;
    }

    public String getCoreDumpUrl() {
        return this.mCoreDumpUrl;
    }

    public d getEncryptImpl() {
        return this.mEncryptImpl;
    }

    public String getExceptionUploadUrl() {
        return this.mExceptionUploadUrl;
    }

    public Set<String> getFilterThreadSet() {
        return j.a();
    }

    public String getJavaCrashUploadUrl() {
        return this.mJavaCrashUploadUrl;
    }

    public long getLaunchCrashInterval() {
        return this.mLaunchCrashInterval;
    }

    public String getLaunchCrashUploadUrl() {
        return this.mLaunchCrashUploadUrl;
    }

    public int getLogcatDumpCount() {
        return this.mLogcatDumpCount;
    }

    public int getLogcatLevel() {
        return this.mLogcatLevel;
    }

    public String getNativeCrashUploadUrl() {
        return this.mNativeCrashUploadUrl;
    }

    public String getNativeMemUrl() {
        return this.mNativeMemUrl;
    }

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return this.mThreadPoolExecutor;
    }

    public boolean isApmExists() {
        return a.c();
    }

    public boolean isBlockMonitorEnable() {
        return this.mBlockMonitorEnable;
    }

    public boolean isCrashIgnored(final String str) {
        try {
            AnonymousClass3 r1 = new f() {
                public Object a(String str) {
                    return str.equals(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_MD5) ? str : super.a(str);
                }
            };
            if (n.a("java_crash_ignore", (f) r1)) {
                return true;
            }
            if (!p.b(h.g())) {
                return false;
            }
            a.d();
            return n.a("java_crash_ignore", (f) r1);
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean isDebugMode() {
        return this.mIsDebugMode;
    }

    public boolean isEnsureEnable() {
        return this.mEnsureEnable;
    }

    public boolean isEnsureWithLogcat() {
        return this.mEnsureWithLogcat;
    }

    public boolean isNativeCrashMiniDump() {
        return this.mNativeCrashMiniDump;
    }

    public boolean isReportErrorEnable() {
        return this.reportErrorEnable;
    }

    public void setAlogUploadUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mAlogUploadUrl = str;
        }
    }

    public void setBlockMonitorEnable(boolean z) {
        this.mBlockMonitorEnable = z;
    }

    public void setBlockMonitorInterval(long j) {
        this.mBlockMonitorInterval = j;
    }

    public void setConfigUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mConfigUrl = str;
        }
    }

    public void setCurrentProcessName(String str) {
        com.apm.insight.l.a.a(str);
    }

    public void setDebugMode(boolean z) {
        this.mIsDebugMode = z;
    }

    public void setEncryptImpl(d dVar) {
        if (dVar != null) {
            this.mEncryptImpl = dVar;
        }
    }

    public void setEnsureEnable(boolean z) {
        this.mEnsureEnable = z;
    }

    public void setEnsureWithLogcat(boolean z) {
        this.mEnsureWithLogcat = z;
    }

    public void setJavaCrashUploadUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mJavaCrashUploadUrl = str;
        }
    }

    public void setLaunchCrashInterval(long j) {
        if (j > 0) {
            this.mLaunchCrashInterval = j;
        }
    }

    public void setLaunchCrashUrl(String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            this.mExceptionUploadUrl = str;
            int indexOf = str.indexOf("//");
            if (indexOf == -1) {
                str2 = str.substring(0, str.indexOf("/") + 1) + "monitor/collect/c/exception/dump_collection";
            } else {
                str2 = str.substring(0, str.indexOf("/", indexOf + 2) + 1) + "monitor/collect/c/exception/dump_collection";
            }
            this.mLaunchCrashUploadUrl = str2;
        }
    }

    public void setLogcatDumpCount(int i) {
        if (i > 0) {
            this.mLogcatDumpCount = i;
        }
    }

    public void setLogcatLevel(int i) {
        if (i >= 0 && i <= 4) {
            this.mLogcatLevel = i;
        }
    }

    public void setNativeCrashUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mNativeCrashUploadUrl = str;
        }
    }

    public void setReportErrorEnable(boolean z) {
        this.reportErrorEnable = z;
    }

    public void setThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
        this.mThreadPoolExecutor = threadPoolExecutor;
    }
}
