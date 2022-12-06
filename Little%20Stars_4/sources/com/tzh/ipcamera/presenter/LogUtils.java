package com.tzh.ipcamera.presenter;

import android.util.Log;

public class LogUtils {
    private String className = "";
    private boolean debug = true;

    public LogUtils(Class<?> cls) {
        this.className = cls.getSimpleName();
    }

    public static LogUtils setLogger(Class<?> cls) {
        return new LogUtils(cls);
    }

    public void e(String str) {
        if (this.debug) {
            Log.e(this.className, str);
        }
    }

    public void d(String str) {
        if (this.debug) {
            Log.d(this.className, str);
        }
    }

    public void i(String str) {
        if (this.debug) {
            Log.i(this.className, str);
        }
    }

    public void v(String str) {
        if (this.debug) {
            Log.v(this.className, str);
        }
    }

    public void w(String str) {
        if (this.debug) {
            Log.w(this.className, str);
        }
    }
}
