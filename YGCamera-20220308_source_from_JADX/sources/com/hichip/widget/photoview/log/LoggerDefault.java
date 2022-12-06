package com.hichip.widget.photoview.log;

import android.util.Log;

public class LoggerDefault implements Logger {
    /* renamed from: v */
    public int mo12496v(String str, String str2) {
        return Log.v(str, str2);
    }

    /* renamed from: v */
    public int mo12497v(String str, String str2, Throwable th) {
        return Log.v(str, str2, th);
    }

    /* renamed from: d */
    public int mo12490d(String str, String str2) {
        return Log.d(str, str2);
    }

    /* renamed from: d */
    public int mo12491d(String str, String str2, Throwable th) {
        return Log.d(str, str2, th);
    }

    /* renamed from: i */
    public int mo12494i(String str, String str2) {
        return Log.i(str, str2);
    }

    /* renamed from: i */
    public int mo12495i(String str, String str2, Throwable th) {
        return Log.i(str, str2, th);
    }

    /* renamed from: w */
    public int mo12498w(String str, String str2) {
        return Log.w(str, str2);
    }

    /* renamed from: w */
    public int mo12499w(String str, String str2, Throwable th) {
        return Log.w(str, str2, th);
    }

    /* renamed from: e */
    public int mo12492e(String str, String str2) {
        return Log.e(str, str2);
    }

    /* renamed from: e */
    public int mo12493e(String str, String str2, Throwable th) {
        return Log.e(str, str2, th);
    }
}
