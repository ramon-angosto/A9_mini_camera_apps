package com.huawei.hms.framework.common;

import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.Arrays;
import java.util.IllegalFormatException;
import org.json.JSONException;

public class Logger {
    private static final boolean DEBUG = false;
    private static final int MAX_STACK_DEEP_LENGTH = 20;
    private static final int MAX_STACK_DEEP_LENGTH_NORMAL = 8;
    private static final String SPLIT = "|";
    private static final String TAG = "NetworkKit_Logger";
    private static final String TAG_NETWORKKIT_PRE = "NetworkKit_";
    private static final String TAG_NETWORK_SDK_PRE = "NetworkSdk_";
    private static ExtLogger extLogger = null;
    private static boolean println = true;

    private static class ThrowableWrapper extends Throwable {
        private static final long serialVersionUID = 7129050843360571879L;
        private String message;
        private Throwable ownerThrowable;
        private Throwable thisCause;

        private ThrowableWrapper(Throwable th) {
            this.ownerThrowable = th;
            StackTraceElement[] stackTrace = th.getStackTrace();
            int i = ((th instanceof IOException) || (th instanceof JSONException)) ? 8 : 20;
            if (stackTrace.length > i) {
                setStackTrace((StackTraceElement[]) Arrays.copyOf(stackTrace, i));
            } else {
                setStackTrace(stackTrace);
            }
            setMessage(StringUtils.anonymizeMessage(th.getMessage()));
        }

        /* access modifiers changed from: private */
        public void setCause(Throwable th) {
            this.thisCause = th;
        }

        public Throwable getCause() {
            Throwable th = this.thisCause;
            if (th == this) {
                return null;
            }
            return th;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String str) {
            this.message = str;
        }

        public String toString() {
            Throwable th = this.ownerThrowable;
            if (th == null) {
                return "";
            }
            String name = th.getClass().getName();
            if (this.message == null) {
                return name;
            }
            String str = name + ": ";
            if (this.message.startsWith(str)) {
                return this.message;
            }
            return str + this.message;
        }
    }

    private static String complexAppTag(String str) {
        return TAG_NETWORK_SDK_PRE + str;
    }

    private static String complexMsg(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getCallMethodInfo(i);
        }
        return getCallMethodInfo(i) + "|" + str;
    }

    private static String complexTag(String str) {
        return TAG_NETWORKKIT_PRE + str;
    }

    /* renamed from: d */
    public static void m469d(String str, Object obj) {
        println(3, str, obj);
    }

    /* renamed from: d */
    public static void m470d(String str, String str2, Object... objArr) {
        println(3, str, str2, objArr);
    }

    /* renamed from: e */
    public static void m471e(String str, Object obj) {
        println(6, str, obj);
    }

    /* renamed from: e */
    public static void m472e(String str, String str2, Throwable th) {
        if (isAPPLoggable(6)) {
            extLogger.mo13658e(complexAppTag(str), complexMsg(str2, 5), getNewThrowable(th));
        }
        if (println) {
            Log.e(complexTag(str), complexMsg(str2, 5), getNewThrowable(th));
        }
    }

    /* renamed from: e */
    public static void m473e(String str, String str2, Object... objArr) {
        println(6, str, str2, objArr);
    }

    private static void extLogPrintln(int i, String str, String str2) {
        if (i == 2) {
            extLogger.mo13660v(str, str2);
        } else if (i == 3) {
            extLogger.mo13656d(str, str2);
        } else if (i == 4) {
            extLogger.mo13659i(str, str2);
        } else if (i == 5) {
            extLogger.mo13661w(str, str2);
        } else if (i == 6) {
            extLogger.mo13657e(str, str2);
        }
    }

    private static String getCallMethodInfo(int i) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length <= i) {
            return "";
        }
        StackTraceElement stackTraceElement = stackTrace[i];
        return Thread.currentThread().getName() + "|" + stackTraceElement.getFileName() + "|" + stackTraceElement.getClassName() + "|" + stackTraceElement.getMethodName() + "|" + stackTraceElement.getLineNumber();
    }

    private static Throwable getNewThrowable(Throwable th) {
        if (isLoggable(3)) {
            return th;
        }
        if (th == null) {
            return null;
        }
        ThrowableWrapper throwableWrapper = new ThrowableWrapper(th);
        Throwable cause = th.getCause();
        ThrowableWrapper throwableWrapper2 = throwableWrapper;
        while (cause != null) {
            ThrowableWrapper throwableWrapper3 = new ThrowableWrapper(cause);
            throwableWrapper2.setCause(throwableWrapper3);
            cause = cause.getCause();
            throwableWrapper2 = throwableWrapper3;
        }
        return throwableWrapper;
    }

    /* renamed from: i */
    public static void m474i(String str, Object obj) {
        println(4, str, obj);
    }

    /* renamed from: i */
    public static void m475i(String str, String str2, Object... objArr) {
        println(4, str, str2, objArr);
    }

    public static boolean isAPPLoggable(int i) {
        if (extLogger != null) {
            return Log.isLoggable(TAG_NETWORK_SDK_PRE, i);
        }
        return false;
    }

    public static boolean isLoggable(int i) {
        return Log.isLoggable(TAG_NETWORKKIT_PRE, i);
    }

    private static int logPrintln(int i, String str, String str2) {
        if (isAPPLoggable(i)) {
            extLogPrintln(i, complexAppTag(str), complexMsg(str2, 7));
        }
        if (println) {
            return Log.println(i, complexTag(str), complexMsg(str2, 7));
        }
        return 1;
    }

    public static void println(int i, String str, Object obj) {
        if (i >= 3 && isLoggable(i)) {
            logPrintln(i, str, obj == null ? "null" : obj.toString());
        }
    }

    public static void println(int i, String str, String str2, Object... objArr) {
        if (i >= 3) {
            if (str2 == null) {
                Log.w(TAG, "format is null, not log");
                return;
            }
            try {
                if (isLoggable(i)) {
                    logPrintln(i, str, StringUtils.format(str2, objArr));
                }
            } catch (IllegalFormatException e) {
                m479w(TAG, "log format error" + str2, (Throwable) e);
            }
        }
    }

    public static void setExtLogger(ExtLogger extLogger2, boolean z) {
        extLogger = extLogger2;
        println = z;
        m474i(TAG, "logger = " + extLogger2 + z);
    }

    /* renamed from: v */
    public static void m476v(String str, Object obj) {
        println(2, str, obj);
    }

    /* renamed from: v */
    public static void m477v(String str, String str2, Object... objArr) {
        println(2, str, str2, objArr);
    }

    /* renamed from: w */
    public static void m478w(String str, Object obj) {
        println(5, str, obj);
    }

    /* renamed from: w */
    public static void m479w(String str, String str2, Throwable th) {
        if (isAPPLoggable(5)) {
            extLogger.mo13662w(complexAppTag(str), complexMsg(str2, 5), getNewThrowable(th));
        }
        if (println) {
            Log.w(complexTag(str), complexMsg(str2, 5), getNewThrowable(th));
        }
    }

    /* renamed from: w */
    public static void m480w(String str, String str2, Object... objArr) {
        println(5, str, str2, objArr);
    }
}
