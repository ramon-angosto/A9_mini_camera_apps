package com.vungle.warren.model;

import android.content.ContentValues;
import android.util.Pair;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.vungle.warren.AdConfig;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.persistence.ContentValuesUtil;
import com.vungle.warren.persistence.DBAdapter;
import com.vungle.warren.persistence.IdColumns;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdvertisementDBAdapter implements DBAdapter<Advertisement> {
    static final Type CHECKPOINT_LIST_TYPE = new TypeToken<List<Advertisement.Checkpoint>>() {
    }.getType();
    public static final String CREATE_ADVERTISEMENT_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS advertisement(_id INTEGER PRIMARY KEY AUTOINCREMENT,  item_id TEXT UNIQUE, ad_config TEXT,ad_type INT, expire_time NUMERIC, delay NUMERIC, show_close_delay INT, show_close_incentivized INT, countdown INT, video_height INT, video_width INT, cta_overlay_enabled SHORT, cta_click_area NUMERIC, retry_count INT, requires_non_market_install SHORT, app_id TEXT, campaign TEXT, video_url TEXT, md5 TEXT, postroll_bundle_url TEXT, cta_destination_url TEXT, cta_url TEXT, ad_token TEXT, video_identifier TEXT, template_url TEXT, TEMPLATE_ID TEXT, TEMPLATE_TYPE TEXT, ad_market_id TEXT,bid_token TEXT,  checkpoints TEXT, template_settings TEXT, mraid_files TEXT, cacheable_assets TEXT, state INT, placement_id TEXT, tt_download NUMERIC,asset_download_timestamp NUMERIC,asset_download_duration NUMERIC,ad_request_start_time NUMERIC,column_enable_om_sdk SHORT,column_om_sdk_extra_vast TEXT,column_request_timestamp NUMERIC,column_click_coordinates_enabled SHORT,dynamic_events_and_urls TEXT, column_deep_link TEXT, column_notifications TEXT, column_assets_fully_downloaded SHORT, column_header_bidding SHORT)";
    static final Type DYNAMIC_EVENTS_AND_URLS_TYPE = new TypeToken<Map<String, ArrayList<String>>>() {
    }.getType();
    private final Type STRING_LIST_TYPE = new TypeToken<List<String>>() {
    }.getType();
    private Type cacheableMapType = new TypeToken<Map<String, Pair<String, String>>>() {
    }.getType();
    private Gson gson = new GsonBuilder().create();
    private Type stringArrayType = new TypeToken<String[]>() {
    }.getType();
    private Type stringMapType = new TypeToken<Map<String, String>>() {
    }.getType();

    public interface AdvertisementColumns extends IdColumns {
        public static final String COLUMN_AD_CONFIG = "ad_config";
        public static final String COLUMN_AD_MARKET_ID = "ad_market_id";
        public static final String COLUMN_AD_REQUEST_START_TIMESTAMP = "ad_request_start_time";
        public static final String COLUMN_AD_TOKEN = "ad_token";
        public static final String COLUMN_AD_TYPE = "ad_type";
        public static final String COLUMN_APP_ID = "app_id";
        public static final String COLUMN_ASSETS_FULLY_DOWNLOADED = "column_assets_fully_downloaded";
        public static final String COLUMN_ASSET_DOWNLOAD_DURATION = "asset_download_duration";
        public static final String COLUMN_ASSET_DOWNLOAD_TIMESTAMP = "asset_download_timestamp";
        public static final String COLUMN_BID_TOKEN = "bid_token";
        public static final String COLUMN_CACHEABLE_ASSETS = "cacheable_assets";
        public static final String COLUMN_CAMPAIGN = "campaign";
        public static final String COLUMN_CHECKPOINTS = "checkpoints";
        public static final String COLUMN_CLICK_COORDINATES_ENABLED = "column_click_coordinates_enabled";
        public static final String COLUMN_COUNTDOWN = "countdown";
        public static final String COLUMN_CTA_CLICK_AREA = "cta_click_area";
        public static final String COLUMN_CTA_DESTINATION_URL = "cta_destination_url";
        public static final String COLUMN_CTA_OVERLAY_ENABLED = "cta_overlay_enabled";
        public static final String COLUMN_CTA_URL = "cta_url";
        public static final String COLUMN_DEEP_LINK = "column_deep_link";
        public static final String COLUMN_DELAY = "delay";
        public static final String COLUMN_DYNAMIC_EVENTS_AND_URLS = "dynamic_events_and_urls";
        public static final String COLUMN_ENABLE_OM_SDK = "column_enable_om_sdk";
        public static final String COLUMN_EXPIRE_TIME = "expire_time";
        public static final String COLUMN_HEADER_BIDDING = "column_header_bidding";
        public static final String COLUMN_MD5 = "md5";
        public static final String COLUMN_MRAID_FILES = "mraid_files";
        public static final String COLUMN_NOTIFICATIONS = "column_notifications";
        public static final String COLUMN_OM_SDK_EXTRA_VAST = "column_om_sdk_extra_vast";
        public static final String COLUMN_PLACEMENT_ID = "placement_id";
        public static final String COLUMN_POSTROLL_BUNDLE_URL = "postroll_bundle_url";
        public static final String COLUMN_REQUIRES_NON_MARKET_INSTALL = "requires_non_market_install";
        public static final String COLUMN_RETRY_COUNT = "retry_count";
        public static final String COLUMN_SERVER_REQUEST_TIMESTAMP = "column_request_timestamp";
        public static final String COLUMN_SHOW_CLOSE_DELAY = "show_close_delay";
        public static final String COLUMN_SHOW_CLOSE_INCENTIVISED = "show_close_incentivized";
        public static final String COLUMN_STATE = "state";
        public static final String COLUMN_TEMPLATE_ID = "TEMPLATE_ID";
        public static final String COLUMN_TEMPLATE_SETTINGS = "template_settings";
        public static final String COLUMN_TEMPLATE_TYPE = "TEMPLATE_TYPE";
        public static final String COLUMN_TEMPLATE_URL = "template_url";
        public static final String COLUMN_TT_DOWNLOAD = "tt_download";
        public static final String COLUMN_VIDEO_HEIGHT = "video_height";
        public static final String COLUMN_VIDEO_IDENTIFIER = "video_identifier";
        public static final String COLUMN_VIDEO_URL = "video_url";
        public static final String COLUMN_VIDEO_WIDTH = "video_width";
        public static final String TABLE_NAME = "advertisement";
    }

    public String tableName() {
        return AdvertisementColumns.TABLE_NAME;
    }

    public ContentValues toContentValues(Advertisement advertisement) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(IdColumns.COLUMN_IDENTIFIER, advertisement.identifier);
        contentValues.put("ad_type", Integer.valueOf(advertisement.getAdType()));
        contentValues.put(AdvertisementColumns.COLUMN_EXPIRE_TIME, Long.valueOf(advertisement.expireTime));
        contentValues.put(AdvertisementColumns.COLUMN_DELAY, Integer.valueOf(advertisement.delay));
        contentValues.put(AdvertisementColumns.COLUMN_SHOW_CLOSE_DELAY, Integer.valueOf(advertisement.showCloseDelay));
        contentValues.put(AdvertisementColumns.COLUMN_SHOW_CLOSE_INCENTIVISED, Integer.valueOf(advertisement.showCloseIncentivized));
        contentValues.put(AdvertisementColumns.COLUMN_COUNTDOWN, Integer.valueOf(advertisement.countdown));
        contentValues.put(AdvertisementColumns.COLUMN_VIDEO_WIDTH, Integer.valueOf(advertisement.videoWidth));
        contentValues.put(AdvertisementColumns.COLUMN_VIDEO_HEIGHT, Integer.valueOf(advertisement.videoHeight));
        contentValues.put(AdvertisementColumns.COLUMN_CTA_OVERLAY_ENABLED, Boolean.valueOf(advertisement.ctaOverlayEnabled));
        contentValues.put(AdvertisementColumns.COLUMN_CTA_CLICK_AREA, Boolean.valueOf(advertisement.ctaClickArea));
        contentValues.put("retry_count", Integer.valueOf(advertisement.retryCount));
        contentValues.put(AdvertisementColumns.COLUMN_REQUIRES_NON_MARKET_INSTALL, Boolean.valueOf(advertisement.requiresNonMarketInstall));
        contentValues.put("app_id", advertisement.appID);
        contentValues.put("campaign", advertisement.campaign);
        contentValues.put("video_url", advertisement.videoUrl);
        contentValues.put(AdvertisementColumns.COLUMN_MD5, advertisement.md5);
        contentValues.put(AdvertisementColumns.COLUMN_POSTROLL_BUNDLE_URL, advertisement.postrollBundleUrl);
        contentValues.put(AdvertisementColumns.COLUMN_CTA_DESTINATION_URL, advertisement.ctaDestinationUrl);
        contentValues.put(AdvertisementColumns.COLUMN_CTA_URL, advertisement.ctaUrl);
        contentValues.put(AdvertisementColumns.COLUMN_AD_TOKEN, advertisement.adToken);
        contentValues.put(AdvertisementColumns.COLUMN_VIDEO_IDENTIFIER, advertisement.videoIdentifier);
        contentValues.put(AdvertisementColumns.COLUMN_TEMPLATE_URL, advertisement.templateUrl);
        contentValues.put(AdvertisementColumns.COLUMN_TEMPLATE_ID, advertisement.templateId);
        contentValues.put(AdvertisementColumns.COLUMN_TEMPLATE_TYPE, advertisement.templateType);
        contentValues.put(AdvertisementColumns.COLUMN_AD_MARKET_ID, advertisement.adMarketId);
        contentValues.put(AdvertisementColumns.COLUMN_BID_TOKEN, advertisement.bidToken);
        contentValues.put(AdvertisementColumns.COLUMN_STATE, Integer.valueOf(advertisement.state));
        contentValues.put("placement_id", advertisement.placementId);
        contentValues.put(AdvertisementColumns.COLUMN_AD_CONFIG, this.gson.toJson((Object) advertisement.adConfig));
        contentValues.put(AdvertisementColumns.COLUMN_CHECKPOINTS, this.gson.toJson((Object) advertisement.checkpoints, CHECKPOINT_LIST_TYPE));
        contentValues.put(AdvertisementColumns.COLUMN_DYNAMIC_EVENTS_AND_URLS, this.gson.toJson((Object) advertisement.dynamicEventsAndUrls, DYNAMIC_EVENTS_AND_URLS_TYPE));
        contentValues.put(AdvertisementColumns.COLUMN_TEMPLATE_SETTINGS, this.gson.toJson((Object) advertisement.templateSettings, this.stringMapType));
        contentValues.put(AdvertisementColumns.COLUMN_MRAID_FILES, this.gson.toJson((Object) advertisement.mraidFiles, this.stringMapType));
        contentValues.put(AdvertisementColumns.COLUMN_CACHEABLE_ASSETS, this.gson.toJson((Object) advertisement.cacheableAssets, this.cacheableMapType));
        contentValues.put(AdvertisementColumns.COLUMN_NOTIFICATIONS, this.gson.toJson((Object) advertisement.getWinNotifications(), this.STRING_LIST_TYPE));
        contentValues.put("tt_download", Long.valueOf(advertisement.ttDownload));
        contentValues.put(AdvertisementColumns.COLUMN_ASSET_DOWNLOAD_TIMESTAMP, Long.valueOf(advertisement.assetDownloadStartTime));
        contentValues.put("asset_download_duration", Long.valueOf(advertisement.assetDownloadDuration));
        contentValues.put(AdvertisementColumns.COLUMN_AD_REQUEST_START_TIMESTAMP, Long.valueOf(advertisement.adRequestStartTime));
        contentValues.put(AdvertisementColumns.COLUMN_ENABLE_OM_SDK, Boolean.valueOf(advertisement.enableOm));
        contentValues.put(AdvertisementColumns.COLUMN_OM_SDK_EXTRA_VAST, advertisement.omExtraVast);
        contentValues.put(AdvertisementColumns.COLUMN_SERVER_REQUEST_TIMESTAMP, Long.valueOf(advertisement.serverRequestTimestamp));
        contentValues.put(AdvertisementColumns.COLUMN_CLICK_COORDINATES_ENABLED, Boolean.valueOf(advertisement.clickCoordinatesEnabled));
        contentValues.put(AdvertisementColumns.COLUMN_ASSETS_FULLY_DOWNLOADED, Boolean.valueOf(advertisement.assetsFullyDownloaded));
        contentValues.put(AdvertisementColumns.COLUMN_DEEP_LINK, advertisement.deeplink);
        contentValues.put(AdvertisementColumns.COLUMN_HEADER_BIDDING, Boolean.valueOf(advertisement.headerBidding));
        return contentValues;
    }

    public Advertisement fromContentValues(ContentValues contentValues) {
        Advertisement advertisement = new Advertisement();
        advertisement.identifier = contentValues.getAsString(IdColumns.COLUMN_IDENTIFIER);
        advertisement.adType = contentValues.getAsInteger("ad_type").intValue();
        advertisement.expireTime = contentValues.getAsLong(AdvertisementColumns.COLUMN_EXPIRE_TIME).longValue();
        advertisement.delay = contentValues.getAsInteger(AdvertisementColumns.COLUMN_DELAY).intValue();
        advertisement.showCloseDelay = contentValues.getAsInteger(AdvertisementColumns.COLUMN_SHOW_CLOSE_DELAY).intValue();
        advertisement.showCloseIncentivized = contentValues.getAsInteger(AdvertisementColumns.COLUMN_SHOW_CLOSE_INCENTIVISED).intValue();
        advertisement.countdown = contentValues.getAsInteger(AdvertisementColumns.COLUMN_COUNTDOWN).intValue();
        advertisement.videoWidth = contentValues.getAsInteger(AdvertisementColumns.COLUMN_VIDEO_WIDTH).intValue();
        advertisement.videoHeight = contentValues.getAsInteger(AdvertisementColumns.COLUMN_VIDEO_HEIGHT).intValue();
        advertisement.retryCount = contentValues.getAsInteger("retry_count").intValue();
        advertisement.requiresNonMarketInstall = ContentValuesUtil.getBoolean(contentValues, AdvertisementColumns.COLUMN_REQUIRES_NON_MARKET_INSTALL);
        advertisement.appID = contentValues.getAsString("app_id");
        advertisement.campaign = contentValues.getAsString("campaign");
        advertisement.videoUrl = contentValues.getAsString("video_url");
        advertisement.md5 = contentValues.getAsString(AdvertisementColumns.COLUMN_MD5);
        advertisement.postrollBundleUrl = contentValues.getAsString(AdvertisementColumns.COLUMN_POSTROLL_BUNDLE_URL);
        advertisement.ctaDestinationUrl = contentValues.getAsString(AdvertisementColumns.COLUMN_CTA_DESTINATION_URL);
        advertisement.ctaUrl = contentValues.getAsString(AdvertisementColumns.COLUMN_CTA_URL);
        advertisement.adToken = contentValues.getAsString(AdvertisementColumns.COLUMN_AD_TOKEN);
        advertisement.videoIdentifier = contentValues.getAsString(AdvertisementColumns.COLUMN_VIDEO_IDENTIFIER);
        advertisement.templateUrl = contentValues.getAsString(AdvertisementColumns.COLUMN_TEMPLATE_URL);
        advertisement.templateId = contentValues.getAsString(AdvertisementColumns.COLUMN_TEMPLATE_ID);
        advertisement.templateType = contentValues.getAsString(AdvertisementColumns.COLUMN_TEMPLATE_TYPE);
        advertisement.adMarketId = contentValues.getAsString(AdvertisementColumns.COLUMN_AD_MARKET_ID);
        advertisement.bidToken = contentValues.getAsString(AdvertisementColumns.COLUMN_BID_TOKEN);
        advertisement.state = contentValues.getAsInteger(AdvertisementColumns.COLUMN_STATE).intValue();
        advertisement.placementId = contentValues.getAsString("placement_id");
        advertisement.ctaOverlayEnabled = ContentValuesUtil.getBoolean(contentValues, AdvertisementColumns.COLUMN_CTA_OVERLAY_ENABLED);
        advertisement.ctaClickArea = ContentValuesUtil.getBoolean(contentValues, AdvertisementColumns.COLUMN_CTA_CLICK_AREA);
        advertisement.adConfig = (AdConfig) this.gson.fromJson(contentValues.getAsString(AdvertisementColumns.COLUMN_AD_CONFIG), AdConfig.class);
        advertisement.checkpoints = (List) this.gson.fromJson(contentValues.getAsString(AdvertisementColumns.COLUMN_CHECKPOINTS), CHECKPOINT_LIST_TYPE);
        advertisement.dynamicEventsAndUrls = (Map) this.gson.fromJson(contentValues.getAsString(AdvertisementColumns.COLUMN_DYNAMIC_EVENTS_AND_URLS), DYNAMIC_EVENTS_AND_URLS_TYPE);
        advertisement.templateSettings = (Map) this.gson.fromJson(contentValues.getAsString(AdvertisementColumns.COLUMN_TEMPLATE_SETTINGS), this.stringMapType);
        advertisement.mraidFiles = (Map) this.gson.fromJson(contentValues.getAsString(AdvertisementColumns.COLUMN_MRAID_FILES), this.stringMapType);
        advertisement.cacheableAssets = (Map) this.gson.fromJson(contentValues.getAsString(AdvertisementColumns.COLUMN_CACHEABLE_ASSETS), this.cacheableMapType);
        advertisement.ttDownload = contentValues.getAsLong("tt_download").longValue();
        advertisement.assetDownloadStartTime = contentValues.getAsLong(AdvertisementColumns.COLUMN_ASSET_DOWNLOAD_TIMESTAMP).longValue();
        advertisement.assetDownloadDuration = contentValues.getAsLong("asset_download_duration").longValue();
        advertisement.adRequestStartTime = contentValues.getAsLong(AdvertisementColumns.COLUMN_AD_REQUEST_START_TIMESTAMP).longValue();
        advertisement.enableOm = ContentValuesUtil.getBoolean(contentValues, AdvertisementColumns.COLUMN_ENABLE_OM_SDK);
        advertisement.setWinNotifications((List) this.gson.fromJson(contentValues.getAsString(AdvertisementColumns.COLUMN_NOTIFICATIONS), this.STRING_LIST_TYPE));
        advertisement.omExtraVast = contentValues.getAsString(AdvertisementColumns.COLUMN_OM_SDK_EXTRA_VAST);
        advertisement.serverRequestTimestamp = contentValues.getAsLong(AdvertisementColumns.COLUMN_SERVER_REQUEST_TIMESTAMP).longValue();
        advertisement.clickCoordinatesEnabled = contentValues.getAsBoolean(AdvertisementColumns.COLUMN_CLICK_COORDINATES_ENABLED).booleanValue();
        advertisement.assetsFullyDownloaded = ContentValuesUtil.getBoolean(contentValues, AdvertisementColumns.COLUMN_ASSETS_FULLY_DOWNLOADED);
        advertisement.deeplink = contentValues.getAsString(AdvertisementColumns.COLUMN_DEEP_LINK);
        advertisement.headerBidding = contentValues.getAsBoolean(AdvertisementColumns.COLUMN_HEADER_BIDDING).booleanValue();
        return advertisement;
    }
}
