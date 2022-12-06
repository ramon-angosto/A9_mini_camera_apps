package com.apm.insight;

public interface ICrashCallback {
    void onCrash(CrashType crashType, String str, Thread thread);
}
