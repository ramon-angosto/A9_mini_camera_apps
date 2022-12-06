package com.aliyun.sls.android.producer;

import java.util.Map;

public class LogProducerClient {
    private final long client;
    private final long producer;

    private static native long create_log_producer(long j, LogProducerCallback logProducerCallback);

    private static native void destroy_log_producer(long j);

    private static native long get_log_producer_client(long j);

    private static native int log_producer_client_add_log_with_len(long j, long j2, int i, String[] strArr, String[] strArr2, int i2);

    public LogProducerClient(LogProducerConfig logProducerConfig) throws LogProducerException {
        this(logProducerConfig, (LogProducerCallback) null);
    }

    public LogProducerClient(LogProducerConfig logProducerConfig, LogProducerCallback logProducerCallback) throws LogProducerException {
        this.producer = create_log_producer(logProducerConfig.getConfig(), logProducerCallback);
        long j = this.producer;
        if (j != 0) {
            this.client = get_log_producer_client(j);
            if (this.client == 0) {
                throw new LogProducerException("Can not create log producer client");
            }
            return;
        }
        throw new LogProducerException("Can not create log producer");
    }

    public LogProducerResult addLog(Log log) {
        return addLog(log, 0);
    }

    public LogProducerResult addLog(Log log, int i) {
        if (this.client == 0 || log == null) {
            return LogProducerResult.LOG_PRODUCER_INVALID;
        }
        Map<String, String> content = log.getContent();
        int size = content.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i2 = 0;
        for (Map.Entry next : content.entrySet()) {
            String str = (String) next.getKey();
            if (str == null) {
                str = "";
            }
            strArr[i2] = str;
            String str2 = (String) next.getValue();
            if (str2 == null) {
                str2 = "";
            }
            strArr2[i2] = str2;
            i2++;
        }
        return LogProducerResult.fromInt(log_producer_client_add_log_with_len(this.client, log.getLogTime(), size, strArr, strArr2, i));
    }

    public void destroyLogProducer() {
        destroy_log_producer(this.producer);
    }
}
