package com.vungle.warren.error;

public class VungleError extends Error {
    public static final int CONFIG_FAILED = 7;
    public static final int ID_NOT_FOUND = 2;
    public static final int INDEX_HTML_MISSING = 5;
    public static final int INVALID_URL = 10;
    public static final int MALFORMED_AD_RESPONSE = 9;
    public static final int MRAID_FILE_MISSING = 4;
    public static final int NO_AD_AVAILABLE = 0;
    static final int SLEEP = 1;
    static final int UNKNOWN_ERROR = 3;
    public static final int WILL_PLAY_AD_DISABLED = 6;
    private int code;

    public VungleError(int i) {
        this.code = i;
    }

    public int getErrorCode() {
        return this.code;
    }

    public String getLocalizedMessage() {
        switch (this.code) {
            case 0:
                return "No Advertisement is currently available";
            case 1:
                return "Sleep Code Returned";
            case 2:
                return "No object for the given identifier was found";
            case 3:
                return "Unknown Error encountered.";
            case 4:
                return "mraid.js was not found. 404!";
            case 5:
                return "index.html was not found. 404!";
            case 6:
                return "/config has disabled /will_play_ad";
            case 7:
                return "/config returned an error";
            case 9:
                return "invalid ad response";
            case 10:
                return "invalid url";
            default:
                throw new IllegalArgumentException("Error Code " + this.code + " is not recognized!");
        }
    }
}
