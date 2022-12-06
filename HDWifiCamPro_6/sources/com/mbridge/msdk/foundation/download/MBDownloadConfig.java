package com.mbridge.msdk.foundation.download;

import android.os.Handler;
import com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper;
import com.mbridge.msdk.foundation.download.utils.ILogger;
import com.mbridge.msdk.foundation.download.utils.Objects;

public class MBDownloadConfig {
    private Handler databaseHandler;
    private IDatabaseOpenHelper databaseHelper;
    private long defaultConnectTimeout;
    private long defaultPingInterval;
    private long defaultReadTimeout;
    private long defaultWriteTimeout;
    private ILogger logger;
    private int maxRequests;
    private int maxRequestsPerHost;

    private MBDownloadConfig(Builder builder) {
        this.databaseHelper = builder.databaseHelper;
        this.logger = builder.logger;
        this.databaseHandler = builder.databaseHandler;
        this.defaultConnectTimeout = builder.defaultConnectTimeout;
        this.defaultReadTimeout = builder.defaultReadTimeout;
        this.defaultWriteTimeout = builder.defaultWriteTimeout;
        this.maxRequests = builder.maxRequests;
        this.maxRequestsPerHost = builder.maxRequestsPerHost;
        this.defaultPingInterval = builder.defaultPingInterval;
    }

    public static Builder newBuilder() {
        return new Builder((MBDownloadConfig) null);
    }

    public static Builder newBuilder(MBDownloadConfig mBDownloadConfig) {
        return new Builder(mBDownloadConfig);
    }

    public ILogger getLogger() {
        return this.logger;
    }

    public Handler getDatabaseHandler() {
        return this.databaseHandler;
    }

    public long getDefaultReadTimeout() {
        return this.defaultReadTimeout;
    }

    public long getDefaultWriteTimeout() {
        return this.defaultWriteTimeout;
    }

    public long getDefaultConnectTimeout() {
        return this.defaultConnectTimeout;
    }

    public int getMaxRequests() {
        return this.maxRequests;
    }

    public int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    public long getDefaultPingInterval() {
        return this.defaultPingInterval;
    }

    public IDatabaseOpenHelper getDatabaseHelper() {
        return this.databaseHelper;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public Handler databaseHandler;
        /* access modifiers changed from: private */
        public IDatabaseOpenHelper databaseHelper;
        private String databaseName;
        private int databaseVersion;
        /* access modifiers changed from: private */
        public long defaultConnectTimeout;
        /* access modifiers changed from: private */
        public long defaultPingInterval;
        /* access modifiers changed from: private */
        public long defaultReadTimeout;
        /* access modifiers changed from: private */
        public long defaultWriteTimeout;
        /* access modifiers changed from: private */
        public ILogger logger;
        /* access modifiers changed from: private */
        public int maxRequests;
        /* access modifiers changed from: private */
        public int maxRequestsPerHost;
        private String tableName;

        public Builder(MBDownloadConfig mBDownloadConfig) {
            this.databaseName = "";
            this.tableName = Command.DEFAULT_DATABASE_TABLE_NAME;
            this.databaseVersion = -1;
            this.logger = new ILogger() {
                public void log(String str, Exception exc) {
                }

                public void log(String str, String str2) {
                }
            };
            this.defaultReadTimeout = 20000;
            this.defaultWriteTimeout = 20000;
            this.defaultConnectTimeout = 20000;
            this.maxRequests = 64;
            this.maxRequestsPerHost = 20;
            this.defaultPingInterval = 10;
            if (Objects.isNotNull(mBDownloadConfig)) {
                this.databaseHandler = mBDownloadConfig.getDatabaseHandler();
                this.logger = mBDownloadConfig.getLogger();
                this.defaultReadTimeout = mBDownloadConfig.getDefaultReadTimeout();
                this.defaultConnectTimeout = mBDownloadConfig.getDefaultConnectTimeout();
                this.maxRequests = mBDownloadConfig.getMaxRequests();
                this.defaultWriteTimeout = mBDownloadConfig.getDefaultWriteTimeout();
                this.maxRequests = mBDownloadConfig.getMaxRequests();
                this.maxRequestsPerHost = mBDownloadConfig.getMaxRequestsPerHost();
                this.defaultPingInterval = mBDownloadConfig.getDefaultPingInterval();
            }
        }

        public Builder() {
            this((MBDownloadConfig) null);
        }

        public final Builder setDatabaseHandler(Handler handler) {
            this.databaseHandler = handler;
            return this;
        }

        public final Builder setLogger(ILogger iLogger) {
            this.logger = iLogger;
            return this;
        }

        public final Builder setDatabaseOpenHelper(IDatabaseOpenHelper iDatabaseOpenHelper) {
            this.databaseHelper = iDatabaseOpenHelper;
            return this;
        }

        public final Builder setDefaultPingInterval(long j) {
            this.defaultPingInterval = j;
            return this;
        }

        public final Builder setDefaultReadTimeout(long j) {
            this.defaultReadTimeout = j;
            return this;
        }

        public final Builder setDefaultWriteTimeout(long j) {
            this.defaultWriteTimeout = j;
            return this;
        }

        public final Builder setMaxRequests(int i) {
            this.maxRequests = i;
            return this;
        }

        public final Builder setMaxRequestsPerHost(int i) {
            this.maxRequestsPerHost = i;
            return this;
        }

        public final Builder setDefaultConnectTimeout(long j) {
            this.defaultConnectTimeout = j;
            return this;
        }

        public final MBDownloadConfig build() {
            return new MBDownloadConfig(this);
        }
    }
}
