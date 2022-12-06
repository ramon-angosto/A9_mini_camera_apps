package com.huawei.hms.availableupdate;

/* renamed from: com.huawei.hms.availableupdate.h */
/* compiled from: UpdateStatus */
public final class C0654h {
    /* renamed from: a */
    public static String m327a(int i) {
        if (i == 1000) {
            return "CHECK_OK";
        }
        if (i == 2000) {
            return "DOWNLOAD_SUCCESS";
        }
        if (i == 2100) {
            return "DOWNLOADING";
        }
        if (i == 2101) {
            return "DOWNLOAD_CANCELED";
        }
        switch (i) {
            case 1201:
                return "CHECK_FAILURE";
            case 1202:
                return "CHECK_NO_UPDATE";
            case 1203:
                return "CHECK_NO_SUPPORTED";
            default:
                switch (i) {
                    case 2201:
                        return "DOWNLOAD_FAILURE";
                    case 2202:
                        return "DOWNLOAD_HASH_ERROR";
                    case 2203:
                        return "DOWNLOAD_NO_SPACE";
                    case 2204:
                        return "DOWNLOAD_NO_STORAGE";
                    default:
                        return "UNKNOWN - " + i;
                }
        }
    }
}
