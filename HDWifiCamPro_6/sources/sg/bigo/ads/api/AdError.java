package sg.bigo.ads.api;

public class AdError {
    public static final int ERROR_CODE_AD_DISABLE = 1002;
    public static final int ERROR_CODE_AD_EXPIRED = 2000;
    public static final int ERROR_CODE_ASSETS_ERROR = 1006;
    public static final int ERROR_CODE_FULLSCREEN_AD_FAILED_TO_SHOW = 2003;
    public static final int ERROR_CODE_INTERNAL_ERROR = 1005;
    public static final int ERROR_CODE_INVALID_REQUEST = 1001;
    public static final int ERROR_CODE_NATIVE_VIEW_MISSING = 2001;
    public static final int ERROR_CODE_NETWORK_ERROR = 1003;
    public static final int ERROR_CODE_NO_FILL = 1004;
    public static final int ERROR_CODE_UNINITIALIZED = 1000;
    public static final int ERROR_CODE_VIDEO_ERROR = 2002;
    private final int errorCode;
    private final String errorMsg;

    public AdError(int i, String str) {
        this.errorCode = i;
        this.errorMsg = str;
    }

    public int getCode() {
        return this.errorCode;
    }

    public String getMessage() {
        return this.errorMsg;
    }
}
