package com.mbridge.msdk.foundation.download;

public final class Command {
    public static final int CACHE_DIRECTOR_PATH_TYPE_EXTERNAL = 1;
    public static final int CACHE_DIRECTOR_PATH_TYPE_INTERNAL = 0;
    public static final int DEFAULT_CONNECT_TIMEOUT_IN_MILLS = 20000;
    public static final String DEFAULT_DATABASE_TABLE_NAME = "downloadTable";
    public static final int DEFAULT_DOWNLOAD_RATE = 100;
    public static final int DEFAULT_MAX_REQUESTS = 64;
    public static final int DEFAULT_MAX_REQUESTS_PER_HOST = 20;
    public static final int DEFAULT_PING_INTERVAL = 10;
    public static final int DEFAULT_READ_TIMEOUT_IN_MILLS = 20000;
    public static final int DEFAULT_STREAM_BYTE_BUFFER_SIZE = 4096;
    public static final String DEFAULT_USER_AGENT = "";
    public static final int DEFAULT_WRITE_TIMEOUT_IN_MILLS = 20000;
    public static final String HTTP_HEADER_ETAG = "ETag";
    public static final String HTTP_HEADER_RANGE = "Range";
    public static final String HTTP_HEADER_USER_AGENT = "User-Agent";

    private Command() {
    }
}
