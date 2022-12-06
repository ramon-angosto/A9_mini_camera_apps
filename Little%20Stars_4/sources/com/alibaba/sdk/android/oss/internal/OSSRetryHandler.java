package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.common.OSSLog;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

public class OSSRetryHandler {
    private int maxRetryCount = 2;

    public int getMaxRetryCount() {
        return this.maxRetryCount;
    }

    public void setMaxRetryCount(int i) {
        this.maxRetryCount = i;
    }

    public OSSRetryHandler(int i) {
        this.maxRetryCount = i;
    }

    public OSSRetryType shouldRetry(Exception exc, int i) {
        if (i >= this.maxRetryCount) {
            return OSSRetryType.OSSRetryTypeShouldNotRetry;
        }
        if (exc instanceof ClientException) {
            Exception exc2 = (Exception) exc.getCause();
            if ((exc2 instanceof InterruptedIOException) && !(exc2 instanceof SocketTimeoutException)) {
                OSSLog.logE("[shouldRetry] - is interrupted!");
                return OSSRetryType.OSSRetryTypeShouldNotRetry;
            } else if ((exc2 instanceof IOException) && exc2.getMessage() != null && exc2.getMessage().indexOf("Canceled") != -1) {
                return OSSRetryType.OSSRetryTypeShouldNotRetry;
            } else {
                if (exc2 instanceof IllegalArgumentException) {
                    return OSSRetryType.OSSRetryTypeShouldNotRetry;
                }
                OSSLog.logD("shouldRetry - " + exc.toString());
                exc.getCause().printStackTrace();
                return OSSRetryType.OSSRetryTypeShouldRetry;
            }
        } else if (!(exc instanceof ServiceException)) {
            return OSSRetryType.OSSRetryTypeShouldNotRetry;
        } else {
            ServiceException serviceException = (ServiceException) exc;
            if (serviceException.getErrorCode() != null && serviceException.getErrorCode().equalsIgnoreCase("RequestTimeTooSkewed")) {
                return OSSRetryType.OSSRetryTypeShouldFixedTimeSkewedAndRetry;
            }
            if (serviceException.getStatusCode() >= 500) {
                return OSSRetryType.OSSRetryTypeShouldRetry;
            }
            return OSSRetryType.OSSRetryTypeShouldNotRetry;
        }
    }
}
