package com.bytedance.sdk.openadsdk;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TTAdConstant {
    public static final int AD_ID_IS_NULL_CODE = 402;
    public static final long AD_MAX_EVENT_TIME = 600000;
    public static final int AD_TYPE_COMMON_VIDEO = 0;
    public static final int AD_TYPE_PLAYABLE = 2;
    public static final int AD_TYPE_PLAYABLE_VIDEO = 1;
    public static final int AD_TYPE_UNKNOWN = -1;
    public static final String CLIENT_BIDDING_AUTION_PRICE = "client_bidding_aution_price";
    public static final int CONVERSION_LINK_LANDING_DIRECT = 5;
    public static final int CONVERSION_LINK_LANDING_PAGE = 2;
    public static final int CONVERSION_LINK_LANDING_SPLIT = 6;
    public static final int CONVERSION_LINK_LANDING_VIDEO_PAGE = 1;
    public static final int DEEPLINK_FALLBACK_CODE = 404;
    public static final int DEEPLINK_FALLBACK_TYPE_CODE = 405;
    public static final int DEEPLINK_UNAVAILABLE_CODE = 403;
    public static final int DEFAULT_ENDCARD_CLOSE_TIME = -1;
    public static final int DOWNLOAD_APP_INFO_CODE = 407;
    public static final int DOWNLOAD_URL_CODE = 408;
    public static final int FALLBACK_TYPE_DOWNLOAD = 2;
    public static final int FALLBACK_TYPE_LANDING_PAGE = 1;
    public static final int FULL_INTERACTION_MARGIN = 20;
    public static final float FULL_INTERACTION_TYPE_DEFAULT = 100.0f;
    public static final int HORIZONTAL = 2;
    public static final int IMAGE_CODE = 411;
    public static final int IMAGE_LIST_CODE = 409;
    public static final int IMAGE_LIST_SIZE_CODE = 410;
    public static final int IMAGE_MODE_GROUP_IMG = 4;
    public static final int IMAGE_MODE_LARGE_IMG = 3;
    public static final int IMAGE_MODE_SMALL_IMG = 2;
    public static final int IMAGE_MODE_SQUARE_IMG = 33;
    public static final int IMAGE_MODE_UNKNOWN = -1;
    public static final int IMAGE_MODE_VERTICAL_IMG = 16;
    public static final int IMAGE_MODE_VIDEO = 5;
    public static final int IMAGE_MODE_VIDEO_SQUARE = 50;
    public static final int IMAGE_MODE_VIDEO_VERTICAL = 15;
    public static final int IMAGE_URL_CODE = 412;
    public static final int INTERACTION_TYPE_BROWSER = 2;
    public static final int INTERACTION_TYPE_DIAL = 5;
    public static final int INTERACTION_TYPE_DOWNLOAD = 4;
    public static final int INTERACTION_TYPE_LANDING_PAGE = 3;
    public static final int INTERACTION_TYPE_UNKNOWN = -1;
    public static final int LANDING_PAGE_TYPE_CODE = 406;
    public static final int MATE_IS_NULL_CODE = 401;
    public static final int MATE_VALID = 200;
    public static final String MULTI_PROCESS_DATA = "multi_process_data";
    public static final String MULTI_PROCESS_MATERIALMETA = "multi_process_materialmeta";
    public static final String MULTI_PROCESS_META_MD5 = "multi_process_meta_md5";
    public static final int NETWORK_STATE_2G = 2;
    public static final int NETWORK_STATE_3G = 3;
    public static final int NETWORK_STATE_4G = 5;
    public static final int NETWORK_STATE_MOBILE = 1;
    public static final int NETWORK_STATE_WIFI = 4;
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int PLAYABEL_DEFAULT_DURATION_TIME = 20;
    public static final int PLAYABLE_DEFAULT_ENDCARD_CLOSE_TIME = -1;
    public static final int RENDER_CONTROL_DYNAMIC = 2;
    public static final int REQUEST_AD_TYPE_EXPRESS = 0;
    public static final int REQUEST_AD_TYPE_NATIVE = 1;
    public static final String REQUEST_HEAD_REFERER = "https://www.pangleglobal.com/";
    public static final int SDK_BIDDING_TYPE_CLIENT_BIDDING = 2;
    public static final int STYLE_SIZE_RADIO_16_9 = 1777;
    public static final int STYLE_SIZE_RADIO_1_1 = 1000;
    public static final int STYLE_SIZE_RADIO_2_3 = 666;
    public static final int STYLE_SIZE_RADIO_3_2 = 1500;
    public static final int STYLE_SIZE_RADIO_9_16 = 562;
    public static final float STYLE_SIZE_RADIO_FULL = 100.0f;
    public static final String TAG = "TT_AD_SDK";
    public static final int TITLE_BAR_THEME_DARK = 1;
    public static final int TITLE_BAR_THEME_LIGHT = 0;
    public static final int TITLE_BAR_THEME_NO_TITLE_BAR = -1;
    public static final int TT_CLOSE_CCPA = 1;
    public static final int TT_CLOSE_GDRP = 0;
    public static final int TT_OPEN_CCPA = 0;
    public static final int TT_OPEN_GDRP = 1;
    public static final int VERTICAL = 1;
    public static final int VIDEO_CLOSE_COMPLETE = 4;
    public static final int VIDEO_CLOSE_FEED_CLICK_CLOSE = 1;
    public static final int VIDEO_CLOSE_FULL_REWARD_CLICK_SKIP = 2;
    public static final int VIDEO_CLOSE_FULL_REWARD_STUCK = 3;
    public static final int VIDEO_CLOSE_PLAYER_ERROR = 5;
    public static final int VIDEO_CLOSE_TIME_OUT = 6;
    public static final int VIDEO_COVER_URL_CODE = 415;
    public static final int VIDEO_INFO_CODE = 413;
    public static final int VIDEO_URL_CODE = 414;

    @Retention(RetentionPolicy.SOURCE)
    public @interface NATIVE_AD_TYPE {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NETWORK_STATE {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ORIENTATION_STATE {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TITLE_BAR_THEME {
    }

    public enum RitScenes {
        CUSTOMIZE_SCENES("customize_scenes"),
        HOME_OPEN_BONUS("home_open_bonus"),
        HOME_SVIP_BONUS("home_svip_bonus"),
        HOME_GET_PROPS("home_get_props"),
        HOME_TRY_PROPS("home_try_props"),
        HOME_GET_BONUS("home_get_bonus"),
        HOME_GIFT_BONUS("home_gift_bonus"),
        GAME_START_BONUS("game_start_bonus"),
        GAME_REDUCE_WAITING("geme_reduce_waiting"),
        GAME_MORE_OPPORTUNITIES("game_more_opportunities"),
        GAME_FINISH_REWARDS("game_finish_rewards"),
        GAME_GIFT_BONUS("game_gift_bonus");
        
        final String a;

        private RitScenes(String str) {
            this.a = str;
        }

        public String getScenesName() {
            return this.a;
        }
    }
}
