package com.mbridge.msdk.foundation.download.utils;

public interface ILogger {
    void log(String str, Exception exc);

    void log(String str, String str2);
}
