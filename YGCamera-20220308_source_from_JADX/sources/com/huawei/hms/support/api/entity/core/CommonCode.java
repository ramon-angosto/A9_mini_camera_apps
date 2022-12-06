package com.huawei.hms.support.api.entity.core;

public interface CommonCode {
    public static final int ERROR = 1;

    /* renamed from: OK */
    public static final int f966OK = 0;

    public interface ErrorCode {
        public static final int ARGUMENTS_INVALID = 907135000;
        public static final int CLIENT_API_INVALID = 907135003;
        public static final int EXECUTE_TIMEOUT = 907135004;
        public static final int HMS_VERSION_CONFIGER_INVALID = 907135007;
        public static final int INTERNAL_ERROR = 907135001;
        public static final int NAMING_INVALID = 907135002;
        public static final int NOT_IN_SERVICE = 907135005;
        public static final int SESSION_INVALID = 907135006;
    }

    public interface Resolution {
        public static final String HAS_RESOLUTION = "hasContextResolution";
        public static final String HAS_RESOLUTION_FROM_APK = "intent";
    }

    public interface StatusCode {
        public static final int API_CLIENT_EXPIRED = 1001;
        public static final int API_UNAVAILABLE = 1000;
    }
}
