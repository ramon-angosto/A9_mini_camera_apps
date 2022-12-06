package com.vungle.warren.model;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.webkit.URLUtil;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.warren.AdConfig;
import com.vungle.warren.NativeAd;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.model.AdvertisementDBAdapter;
import com.vungle.warren.utility.HashUtility;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

public class Advertisement implements Comparable<Advertisement> {
    public static final int DONE = 3;
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final int ERROR = 4;
    public static final String FILE_SCHEME = "file://";
    static final String INCENTIVIZED_BODY_TEXT = "INCENTIVIZED_BODY_TEXT";
    static final String INCENTIVIZED_CLOSE_TEXT = "INCENTIVIZED_CLOSE_TEXT";
    static final String INCENTIVIZED_CONTINUE_TEXT = "INCENTIVIZED_CONTINUE_TEXT";
    static final String INCENTIVIZED_TITLE_TEXT = "INCENTIVIZED_TITLE_TEXT";
    public static final int INVALID = 5;
    public static final String KEY_POSTROLL = "postroll";
    public static final String KEY_TEMPLATE = "template";
    public static final String KEY_VIDEO = "video";
    public static final int LANDSCAPE = 1;
    private static final String MRAID_ARGS = "mraid_args";
    public static final int NEW = 0;
    public static final int PORTRAIT = 0;
    public static final int READY = 1;
    static final String START_MUTED = "START_MUTED";
    private static final Collection<String> STATIC_TPAT_EVENTS = Arrays.asList(new String[]{CampaignEx.JSON_NATIVE_VIDEO_PLAY_PERCENTAGE, "checkpoint.0", "checkpoint.25", "checkpoint.50", "checkpoint.75", "checkpoint.100"});
    private static final String TAG = "Advertisement";
    public static final String TPAT_CLICK_COORDINATES_URLS = "video.clickCoordinates";
    public static final int TYPE_VUNGLE_LOCAL = 0;
    public static final int TYPE_VUNGLE_MRAID = 1;
    private static final String UNKNOWN = "unknown";
    public static final int VIEWING = 2;
    AdConfig adConfig;
    String adMarketId;
    public long adRequestStartTime;
    String adToken;
    int adType;
    String appID;
    public long assetDownloadDuration;
    public long assetDownloadStartTime;
    public boolean assetsFullyDownloaded = false;
    String bidToken;
    Map<String, Pair<String, String>> cacheableAssets = new HashMap();
    String campaign;
    List<Checkpoint> checkpoints;
    boolean clickCoordinatesEnabled;
    int countdown;
    boolean ctaClickArea = true;
    String ctaDestinationUrl;
    boolean ctaOverlayEnabled;
    String ctaUrl;
    String deeplink;
    int delay;
    Map<String, ArrayList<String>> dynamicEventsAndUrls = new LinkedTreeMap();
    boolean enableOm;
    long expireTime;
    private Gson gson = new Gson();
    boolean headerBidding;
    String identifier;
    Map<String, String> incentivizedTextSettings = new HashMap();
    String md5;
    Map<String, String> mraidFiles = new HashMap();
    String omExtraVast;
    String placementId;
    String postrollBundleUrl;
    boolean requiresNonMarketInstall;
    int retryCount;
    long serverRequestTimestamp;
    int showCloseDelay;
    int showCloseIncentivized;
    int state = 0;
    String templateId;
    Map<String, String> templateSettings;
    String templateType;
    String templateUrl;
    long ttDownload;
    int videoHeight;
    String videoIdentifier;
    String videoUrl;
    int videoWidth;
    private List<String> winNotifications = new ArrayList();

    public @interface AdType {
    }

    public @interface CacheKey {
    }

    public @interface Orientation {
    }

    public @interface State {
    }

    public int compareTo(Advertisement advertisement) {
        if (advertisement == null) {
            return 1;
        }
        String str = advertisement.identifier;
        if (str != null) {
            String str2 = this.identifier;
            if (str2 == null) {
                return -1;
            }
            return str2.compareTo(str);
        } else if (this.identifier == null) {
            return 0;
        } else {
            return 1;
        }
    }

    Advertisement() {
    }

    public long getTtDownload() {
        return this.ttDownload;
    }

    public String getPlacementId() {
        return this.placementId;
    }

    public void setPlacementId(String str) {
        this.placementId = str;
    }

    public void setAssetDownloadStartTime(long j) {
        this.assetDownloadStartTime = j;
    }

    public void setFinishedDownloadingTime(long j) {
        this.assetDownloadDuration = j - this.assetDownloadStartTime;
        this.ttDownload = j - this.adRequestStartTime;
    }

    public void setAdRequestStartTime(long j) {
        this.adRequestStartTime = j;
    }

    public long getAssetDownloadDuration() {
        return this.assetDownloadDuration;
    }

    public boolean isCtaOverlayEnabled() {
        return this.ctaOverlayEnabled;
    }

    public boolean getCtaClickArea() {
        return this.ctaClickArea;
    }

    public long getServerRequestTimestamp() {
        return this.serverRequestTimestamp;
    }

    public boolean isRequiresNonMarketInstall() {
        return this.requiresNonMarketInstall;
    }

    public Advertisement(JsonObject jsonObject) throws IllegalArgumentException {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (JsonUtil.hasNonNull(jsonObject, "ad_markup")) {
            JsonObject asJsonObject = jsonObject.getAsJsonObject("ad_markup");
            if (JsonUtil.hasNonNull(asJsonObject, "adType")) {
                String asString = asJsonObject.get("adType").getAsString();
                char c = 65535;
                int hashCode = asString.hashCode();
                if (hashCode != -1852456483) {
                    if (hashCode == -1851445271 && asString.equals("vungle_mraid")) {
                        c = 1;
                    }
                } else if (asString.equals("vungle_local")) {
                    c = 0;
                }
                if (c == 0) {
                    this.adType = 0;
                    if (JsonUtil.hasNonNull(asJsonObject, "postBundle")) {
                        str4 = asJsonObject.get("postBundle").getAsString();
                    } else {
                        str4 = "";
                    }
                    this.postrollBundleUrl = str4;
                    if (JsonUtil.hasNonNull(asJsonObject, "url")) {
                        str5 = asJsonObject.get("url").getAsString();
                    } else {
                        str5 = "";
                    }
                    this.templateSettings = new HashMap();
                    this.templateUrl = "";
                    this.templateId = "";
                    this.templateType = "";
                } else if (c == 1) {
                    this.adType = 1;
                    this.postrollBundleUrl = "";
                    if (JsonUtil.hasNonNull(asJsonObject, "templateSettings")) {
                        this.templateSettings = new HashMap();
                        JsonObject asJsonObject2 = asJsonObject.getAsJsonObject("templateSettings");
                        if (JsonUtil.hasNonNull(asJsonObject2, "normal_replacements")) {
                            for (Map.Entry next : asJsonObject2.getAsJsonObject("normal_replacements").entrySet()) {
                                if (!TextUtils.isEmpty((CharSequence) next.getKey())) {
                                    this.templateSettings.put(next.getKey(), (next.getValue() == null || ((JsonElement) next.getValue()).isJsonNull()) ? null : ((JsonElement) next.getValue()).getAsString());
                                }
                            }
                        }
                        if (JsonUtil.hasNonNull(asJsonObject2, "cacheable_replacements")) {
                            str = "";
                            for (Map.Entry next2 : asJsonObject2.getAsJsonObject("cacheable_replacements").entrySet()) {
                                if (!TextUtils.isEmpty((CharSequence) next2.getKey()) && next2.getValue() != null && JsonUtil.hasNonNull((JsonElement) next2.getValue(), "url") && JsonUtil.hasNonNull((JsonElement) next2.getValue(), "extension")) {
                                    String asString2 = ((JsonElement) next2.getValue()).getAsJsonObject().get("url").getAsString();
                                    this.cacheableAssets.put(next2.getKey(), new Pair(asString2, ((JsonElement) next2.getValue()).getAsJsonObject().get("extension").getAsString()));
                                    if (((String) next2.getKey()).equalsIgnoreCase("MAIN_VIDEO")) {
                                        str = asString2;
                                    }
                                }
                            }
                        } else {
                            str = "";
                        }
                        if (JsonUtil.hasNonNull(asJsonObject, "templateId")) {
                            this.templateId = asJsonObject.get("templateId").getAsString();
                            if (JsonUtil.hasNonNull(asJsonObject, "template_type")) {
                                this.templateType = asJsonObject.get("template_type").getAsString();
                                if (!isNativeTemplateType()) {
                                    if (JsonUtil.hasNonNull(asJsonObject, "templateURL")) {
                                        this.templateUrl = asJsonObject.get("templateURL").getAsString();
                                    } else {
                                        throw new IllegalArgumentException("Template URL missing!");
                                    }
                                }
                            } else {
                                throw new IllegalArgumentException("Template Type missing!");
                            }
                        } else {
                            throw new IllegalArgumentException("Missing templateID!");
                        }
                    } else {
                        throw new IllegalArgumentException("Missing template adConfig!");
                    }
                } else {
                    throw new IllegalArgumentException("Unknown Ad Type " + asString + "! Please add this ad type");
                }
                if (!TextUtils.isEmpty(str)) {
                    this.videoUrl = str;
                } else {
                    this.videoUrl = "";
                }
                if (JsonUtil.hasNonNull(asJsonObject, "deeplinkUrl")) {
                    this.deeplink = asJsonObject.get("deeplinkUrl").getAsString();
                }
                if (JsonUtil.hasNonNull(asJsonObject, "id")) {
                    this.identifier = asJsonObject.get("id").getAsString();
                    if (JsonUtil.hasNonNull(asJsonObject, "campaign")) {
                        this.campaign = asJsonObject.get("campaign").getAsString();
                        if (JsonUtil.hasNonNull(asJsonObject, "app_id")) {
                            this.appID = asJsonObject.get("app_id").getAsString();
                            if (!JsonUtil.hasNonNull(asJsonObject, "expiry") || asJsonObject.get("expiry").isJsonNull()) {
                                this.expireTime = System.currentTimeMillis() / 1000;
                            } else {
                                long asLong = asJsonObject.get("expiry").getAsLong();
                                if (asLong > 0) {
                                    this.expireTime = asLong;
                                } else {
                                    this.expireTime = System.currentTimeMillis() / 1000;
                                }
                            }
                            if (JsonUtil.hasNonNull(asJsonObject, "notification")) {
                                Iterator<JsonElement> it = asJsonObject.getAsJsonArray("notification").iterator();
                                while (it.hasNext()) {
                                    this.winNotifications.add(it.next().getAsString());
                                }
                            }
                            if (JsonUtil.hasNonNull(asJsonObject, "tpat")) {
                                JsonObject asJsonObject3 = asJsonObject.getAsJsonObject("tpat");
                                this.checkpoints = new ArrayList(5);
                                int i = this.adType;
                                if (i != 0) {
                                    if (i == 1) {
                                        for (int i2 = 0; i2 < 5; i2++) {
                                            int i3 = i2 * 25;
                                            String format = String.format(Locale.ENGLISH, "checkpoint.%d", new Object[]{Integer.valueOf(i3)});
                                            this.checkpoints.add(i2, JsonUtil.hasNonNull(asJsonObject3, format) ? new Checkpoint(asJsonObject3.getAsJsonArray(format), (byte) i3) : null);
                                        }
                                    } else {
                                        throw new IllegalArgumentException("Unknown Ad Type!");
                                    }
                                } else if (JsonUtil.hasNonNull(asJsonObject3, CampaignEx.JSON_NATIVE_VIDEO_PLAY_PERCENTAGE)) {
                                    JsonArray asJsonArray = asJsonObject3.getAsJsonArray(CampaignEx.JSON_NATIVE_VIDEO_PLAY_PERCENTAGE);
                                    for (int i4 = 0; i4 < asJsonArray.size(); i4++) {
                                        if (asJsonArray.get(i4) != null) {
                                            this.checkpoints.add(new Checkpoint(asJsonArray.get(i4).getAsJsonObject()));
                                        }
                                    }
                                    Collections.sort(this.checkpoints);
                                }
                                TreeSet<String> treeSet = new TreeSet<>(asJsonObject3.keySet());
                                treeSet.remove("moat");
                                treeSet.removeAll(STATIC_TPAT_EVENTS);
                                if (!treeSet.isEmpty()) {
                                    for (String str6 : treeSet) {
                                        JsonArray asJsonArray2 = asJsonObject3.get(str6).getAsJsonArray();
                                        ArrayList arrayList = new ArrayList();
                                        for (int i5 = 0; i5 < asJsonArray2.size(); i5++) {
                                            if (asJsonArray2.get(i5) == null || "null".equalsIgnoreCase(asJsonArray2.get(i5).toString())) {
                                                arrayList.add(i5, "");
                                            } else {
                                                arrayList.add(i5, asJsonArray2.get(i5).getAsString());
                                            }
                                        }
                                        this.dynamicEventsAndUrls.put(str6, arrayList);
                                    }
                                }
                            } else {
                                this.checkpoints = new ArrayList();
                            }
                            if (JsonUtil.hasNonNull(asJsonObject, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_DELAY)) {
                                this.delay = asJsonObject.get(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_DELAY).getAsInt();
                            } else {
                                this.delay = 0;
                            }
                            if (JsonUtil.hasNonNull(asJsonObject, "showClose")) {
                                this.showCloseDelay = asJsonObject.get("showClose").getAsInt();
                            } else {
                                this.showCloseDelay = 0;
                            }
                            if (JsonUtil.hasNonNull(asJsonObject, "showCloseIncentivized")) {
                                this.showCloseIncentivized = asJsonObject.get("showCloseIncentivized").getAsInt();
                            } else {
                                this.showCloseIncentivized = 0;
                            }
                            if (JsonUtil.hasNonNull(asJsonObject, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_COUNTDOWN)) {
                                this.countdown = asJsonObject.get(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_COUNTDOWN).getAsInt();
                            } else {
                                this.countdown = 0;
                            }
                            if (JsonUtil.hasNonNull(asJsonObject, "videoWidth")) {
                                this.videoWidth = asJsonObject.get("videoWidth").getAsInt();
                                if (JsonUtil.hasNonNull(asJsonObject, "videoHeight")) {
                                    this.videoHeight = asJsonObject.get("videoHeight").getAsInt();
                                    if (JsonUtil.hasNonNull(asJsonObject, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_MD5)) {
                                        this.md5 = asJsonObject.get(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_MD5).getAsString();
                                    } else {
                                        this.md5 = "";
                                    }
                                    if (JsonUtil.hasNonNull(asJsonObject, "cta_overlay")) {
                                        JsonObject asJsonObject4 = asJsonObject.getAsJsonObject("cta_overlay");
                                        if (JsonUtil.hasNonNull(asJsonObject4, "enabled")) {
                                            this.ctaOverlayEnabled = asJsonObject4.get("enabled").getAsBoolean();
                                        } else {
                                            this.ctaOverlayEnabled = false;
                                        }
                                        if (JsonUtil.hasNonNull(asJsonObject4, "click_area") && !asJsonObject4.get("click_area").getAsString().isEmpty() && asJsonObject4.get("click_area").getAsDouble() == 0.0d) {
                                            this.ctaClickArea = false;
                                        }
                                    } else {
                                        this.ctaOverlayEnabled = false;
                                    }
                                    if (JsonUtil.hasNonNull(asJsonObject, "callToActionDest")) {
                                        str2 = asJsonObject.get("callToActionDest").getAsString();
                                    } else {
                                        str2 = "";
                                    }
                                    this.ctaDestinationUrl = str2;
                                    if (JsonUtil.hasNonNull(asJsonObject, "callToActionUrl")) {
                                        str3 = asJsonObject.get("callToActionUrl").getAsString();
                                    } else {
                                        str3 = "";
                                    }
                                    this.ctaUrl = str3;
                                    if (TextUtils.isEmpty(this.ctaUrl)) {
                                        this.ctaUrl = this.templateSettings.get(NativeAd.TOKEN_CTA_BUTTON_URL);
                                    }
                                    if (JsonUtil.hasNonNull(asJsonObject, "retryCount")) {
                                        this.retryCount = asJsonObject.get("retryCount").getAsInt();
                                    } else {
                                        this.retryCount = 1;
                                    }
                                    if (JsonUtil.hasNonNull(asJsonObject, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_AD_TOKEN)) {
                                        this.adToken = asJsonObject.get(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_AD_TOKEN).getAsString();
                                        if (JsonUtil.hasNonNull(asJsonObject, "video_object_id")) {
                                            this.videoIdentifier = asJsonObject.get("video_object_id").getAsString();
                                        } else {
                                            this.videoIdentifier = "";
                                        }
                                        if (JsonUtil.hasNonNull(asJsonObject, "requires_sideloading")) {
                                            this.requiresNonMarketInstall = asJsonObject.get("requires_sideloading").getAsBoolean();
                                        } else {
                                            this.requiresNonMarketInstall = false;
                                        }
                                        if (JsonUtil.hasNonNull(asJsonObject, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_AD_MARKET_ID)) {
                                            this.adMarketId = asJsonObject.get(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_AD_MARKET_ID).getAsString();
                                        } else {
                                            this.adMarketId = "";
                                        }
                                        if (JsonUtil.hasNonNull(asJsonObject, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_BID_TOKEN)) {
                                            this.bidToken = asJsonObject.get(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_BID_TOKEN).getAsString();
                                        } else {
                                            this.bidToken = "";
                                        }
                                        if (JsonUtil.hasNonNull(asJsonObject, "timestamp")) {
                                            this.serverRequestTimestamp = asJsonObject.get("timestamp").getAsLong();
                                        } else {
                                            this.serverRequestTimestamp = 1;
                                        }
                                        JsonObject asObject = JsonUtil.getAsObject(JsonUtil.getAsObject(asJsonObject, "viewability"), "om");
                                        this.enableOm = JsonUtil.getAsBoolean(asObject, "is_enabled", false);
                                        this.omExtraVast = JsonUtil.getAsString(asObject, "extra_vast", (String) null);
                                        this.clickCoordinatesEnabled = JsonUtil.getAsBoolean(asJsonObject, "click_coordinates_enabled", false);
                                        this.adConfig = new AdConfig();
                                        return;
                                    }
                                    throw new IllegalArgumentException("AdToken missing!");
                                }
                                throw new IllegalArgumentException("Missing video height!");
                            }
                            throw new IllegalArgumentException("Missing video width!");
                        }
                        throw new IllegalArgumentException("Missing app Id, cannot process advertisement!");
                    }
                    throw new IllegalArgumentException("Missing campaign information, cannot process advertisement!");
                }
                throw new IllegalArgumentException("Missing identifier, cannot process advertisement!");
            }
            throw new IllegalArgumentException("Advertisement did not contain an adType!");
        }
        throw new IllegalArgumentException("JSON does not contain ad markup!");
    }

    public int getAdType() {
        return this.adType;
    }

    public List<Checkpoint> getCheckpoints() {
        return this.checkpoints;
    }

    public void configure(AdConfig adConfig2) {
        if (adConfig2 == null) {
            this.adConfig = new AdConfig();
        } else {
            this.adConfig = adConfig2;
        }
    }

    public AdConfig getAdConfig() {
        return this.adConfig;
    }

    public int getOrientation() {
        return this.videoWidth > this.videoHeight ? 1 : 0;
    }

    public boolean isNativeTemplateType() {
        return "native".equals(this.templateType);
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Advertisement)) {
            return false;
        }
        Advertisement advertisement = (Advertisement) obj;
        if (advertisement.adType != this.adType || advertisement.delay != this.delay || advertisement.showCloseDelay != this.showCloseDelay || advertisement.showCloseIncentivized != this.showCloseIncentivized || advertisement.countdown != this.countdown || advertisement.videoWidth != this.videoWidth || advertisement.videoHeight != this.videoHeight || advertisement.ctaOverlayEnabled != this.ctaOverlayEnabled || advertisement.ctaClickArea != this.ctaClickArea || advertisement.retryCount != this.retryCount || advertisement.enableOm != this.enableOm || advertisement.requiresNonMarketInstall != this.requiresNonMarketInstall || advertisement.state != this.state || (str = advertisement.identifier) == null || (str2 = this.identifier) == null || !str.equals(str2) || !advertisement.campaign.equals(this.campaign) || !advertisement.videoUrl.equals(this.videoUrl) || !advertisement.md5.equals(this.md5) || !advertisement.postrollBundleUrl.equals(this.postrollBundleUrl) || !advertisement.ctaDestinationUrl.equals(this.ctaDestinationUrl) || !advertisement.ctaUrl.equals(this.ctaUrl) || !advertisement.adToken.equals(this.adToken) || !advertisement.videoIdentifier.equals(this.videoIdentifier)) {
            return false;
        }
        String str3 = advertisement.omExtraVast;
        if (str3 == null ? this.omExtraVast != null : !str3.equals(this.omExtraVast)) {
            return false;
        }
        if (!advertisement.adMarketId.equals(this.adMarketId) || !advertisement.bidToken.equals(this.bidToken) || advertisement.checkpoints.size() != this.checkpoints.size()) {
            return false;
        }
        for (int i = 0; i < this.checkpoints.size(); i++) {
            if (!advertisement.checkpoints.get(i).equals(this.checkpoints.get(i))) {
                return false;
            }
        }
        return this.dynamicEventsAndUrls.equals(advertisement.dynamicEventsAndUrls) && advertisement.serverRequestTimestamp == this.serverRequestTimestamp && advertisement.clickCoordinatesEnabled == this.clickCoordinatesEnabled && advertisement.headerBidding == this.headerBidding;
    }

    public int hashCode() {
        return (((((int) (((long) (((((((((((((((((((((((((((((((((((((((((((((((((((((((this.adType * 31) + HashUtility.getHashCode(this.identifier)) * 31) + HashUtility.getHashCode(this.checkpoints)) * 31) + HashUtility.getHashCode(this.dynamicEventsAndUrls)) * 31) + this.delay) * 31) + HashUtility.getHashCode(this.campaign)) * 31) + this.showCloseDelay) * 31) + this.showCloseIncentivized) * 31) + this.countdown) * 31) + HashUtility.getHashCode(this.videoUrl)) * 31) + this.videoWidth) * 31) + this.videoHeight) * 31) + HashUtility.getHashCode(this.md5)) * 31) + HashUtility.getHashCode(this.postrollBundleUrl)) * 31) + (this.ctaOverlayEnabled ? 1 : 0)) * 31) + (this.ctaClickArea ? 1 : 0)) * 31) + HashUtility.getHashCode(this.ctaDestinationUrl)) * 31) + HashUtility.getHashCode(this.ctaUrl)) * 31) + this.retryCount) * 31) + HashUtility.getHashCode(this.adToken)) * 31) + HashUtility.getHashCode(this.videoIdentifier)) * 31) + HashUtility.getHashCode(this.winNotifications)) * 31) + (this.enableOm ? 1 : 0)) * 31) + HashUtility.getHashCode(this.omExtraVast)) * 31) + (this.requiresNonMarketInstall ? 1 : 0)) * 31) + HashUtility.getHashCode(this.adMarketId)) * 31) + HashUtility.getHashCode(this.bidToken)) * 31) + this.state) * 31)) + this.serverRequestTimestamp)) * 31) + (this.clickCoordinatesEnabled ? 1 : 0)) * 31) + (this.headerBidding ? 1 : 0);
    }

    public String getPrivacyUrl() {
        return this.templateSettings.get(NativeAd.TOKEN_VUNGLE_PRIVACY_URL);
    }

    public String[] getTpatUrls(String str) {
        Class<Advertisement> cls = Advertisement.class;
        String str2 = "Unknown TPAT Event " + str;
        ArrayList arrayList = this.dynamicEventsAndUrls.get(str);
        int i = this.adType;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("Unknown Advertisement Type!");
            } else if (str.startsWith("checkpoint")) {
                String[] strArr = EMPTY_STRING_ARRAY;
                Checkpoint checkpoint = this.checkpoints.get(Integer.parseInt(str.split("\\.")[1]) / 25);
                return checkpoint != null ? checkpoint.getUrls() : strArr;
            } else if (arrayList != null) {
                return (String[]) arrayList.toArray(EMPTY_STRING_ARRAY);
            } else {
                VungleLogger.warn(cls.getSimpleName() + "#getTpatUrls", str2);
                return EMPTY_STRING_ARRAY;
            }
        } else if (arrayList != null) {
            return (String[]) arrayList.toArray(EMPTY_STRING_ARRAY);
        } else {
            VungleLogger.warn(cls.getSimpleName() + "#getTpatUrls", str2);
            return EMPTY_STRING_ARRAY;
        }
    }

    public String getId() {
        String str = this.identifier;
        return str == null ? "" : str;
    }

    public String getAdToken() {
        return this.adToken;
    }

    public String getAppID() {
        return this.appID;
    }

    /* access modifiers changed from: package-private */
    public String getUrl() {
        return this.videoUrl;
    }

    public String getCampaign() {
        return this.campaign;
    }

    /* access modifiers changed from: package-private */
    public String getTemplateId() {
        return this.templateId;
    }

    public String getTemplateType() {
        return this.templateType;
    }

    public int getShowCloseDelay(boolean z) {
        int i;
        if (z) {
            i = this.showCloseIncentivized;
        } else {
            i = this.showCloseDelay;
        }
        return i * 1000;
    }

    public boolean getOmEnabled() {
        return this.enableOm;
    }

    public boolean isClickCoordinatesTrackingEnabled() {
        return this.clickCoordinatesEnabled;
    }

    public String getOmExtraVast() {
        return this.omExtraVast;
    }

    public long getExpireTime() {
        return this.expireTime * 1000;
    }

    public Map<String, String> getMRAIDArgsInMap() {
        Map<String, String> map = this.templateSettings;
        if (map != null) {
            HashMap hashMap = new HashMap(map);
            for (Map.Entry next : this.cacheableAssets.entrySet()) {
                hashMap.put(next.getKey(), ((Pair) next.getValue()).first);
            }
            if (!this.mraidFiles.isEmpty()) {
                hashMap.putAll(this.mraidFiles);
            }
            if (!this.incentivizedTextSettings.isEmpty()) {
                hashMap.putAll(this.incentivizedTextSettings);
            }
            String str = "true";
            if (!str.equalsIgnoreCase((String) hashMap.get(START_MUTED))) {
                if ((getAdConfig().getSettings() & 1) == 0) {
                    str = "false";
                }
                hashMap.put(START_MUTED, str);
            }
            return hashMap;
        }
        throw new IllegalArgumentException("Advertisement does not have MRAID Arguments!");
    }

    public JsonObject createMRAIDArgs() {
        Map<String, String> mRAIDArgsInMap = getMRAIDArgsInMap();
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry next : mRAIDArgsInMap.entrySet()) {
            jsonObject.addProperty((String) next.getKey(), (String) next.getValue());
        }
        VungleLogger.verbose(true, TAG, MRAID_ARGS, jsonObject.toString());
        return jsonObject;
    }

    public String getCTAURL(boolean z) {
        int i = this.adType;
        if (i == 0) {
            return z ? this.ctaUrl : this.ctaDestinationUrl;
        }
        if (i == 1) {
            return this.ctaUrl;
        }
        throw new IllegalArgumentException("Unknown AdType " + this.adType);
    }

    public String getDeeplinkUrl() {
        return this.deeplink;
    }

    public boolean hasPostroll() {
        return !TextUtils.isEmpty(this.postrollBundleUrl);
    }

    public Map<String, String> getDownloadableUrls() {
        HashMap hashMap = new HashMap();
        int i = this.adType;
        if (i == 0) {
            hashMap.put("video", this.videoUrl);
            if (!TextUtils.isEmpty(this.postrollBundleUrl)) {
                hashMap.put(KEY_POSTROLL, this.postrollBundleUrl);
            }
        } else if (i == 1) {
            if (!isNativeTemplateType()) {
                hashMap.put("template", this.templateUrl);
            }
            for (Map.Entry<String, Pair<String, String>> value : this.cacheableAssets.entrySet()) {
                String str = (String) ((Pair) value.getValue()).first;
                if (isValidUrl(str)) {
                    hashMap.put(URLUtil.guessFileName(str, (String) null, (String) null), str);
                }
            }
        } else {
            throw new IllegalStateException("Advertisement created without adType!");
        }
        return hashMap;
    }

    private boolean isValidUrl(String str) {
        return !TextUtils.isEmpty(str) && HttpUrl.parse(str) != null;
    }

    public void setMraidAssetDir(File file) {
        for (Map.Entry next : this.cacheableAssets.entrySet()) {
            String str = (String) ((Pair) next.getValue()).first;
            if (isValidUrl(str)) {
                File file2 = new File(file, URLUtil.guessFileName(str, (String) null, (String) null));
                if (file2.exists()) {
                    Map<String, String> map = this.mraidFiles;
                    Object key = next.getKey();
                    map.put(key, FILE_SCHEME + file2.getPath());
                }
            }
        }
        this.assetsFullyDownloaded = true;
    }

    public void updateMRAIDTokensFromAssetDB(List<AdAsset> list) {
        for (Map.Entry next : this.cacheableAssets.entrySet()) {
            String str = (String) ((Pair) next.getValue()).first;
            Iterator<AdAsset> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AdAsset next2 = it.next();
                if (!TextUtils.isEmpty(next2.serverPath) && next2.serverPath.equals(str)) {
                    File file = new File(next2.localPath);
                    if (file.exists()) {
                        Map<String, String> map = this.mraidFiles;
                        Object key = next.getKey();
                        map.put(key, FILE_SCHEME + file.getPath());
                    }
                }
            }
        }
    }

    public void setIncentivizedText(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str)) {
            this.incentivizedTextSettings.put(INCENTIVIZED_TITLE_TEXT, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.incentivizedTextSettings.put(INCENTIVIZED_BODY_TEXT, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            this.incentivizedTextSettings.put(INCENTIVIZED_CONTINUE_TEXT, str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            this.incentivizedTextSettings.put(INCENTIVIZED_CLOSE_TEXT, str4);
        }
    }

    public void setState(int i) {
        this.state = i;
    }

    public int getState() {
        return this.state;
    }

    public String getAdMarketId() {
        return this.adMarketId;
    }

    public List<String> getWinNotifications() {
        return this.winNotifications;
    }

    /* access modifiers changed from: package-private */
    public void setWinNotifications(List<String> list) {
        if (list == null) {
            this.winNotifications.clear();
        } else {
            this.winNotifications = list;
        }
    }

    public String getBidToken() {
        return this.bidToken;
    }

    public boolean isHeaderBidding() {
        return this.headerBidding;
    }

    public void setHeaderBidding(boolean z) {
        this.headerBidding = z;
    }

    public static class Checkpoint implements Comparable<Checkpoint> {
        @SerializedName("percentage")
        private byte percentage;
        @SerializedName("urls")
        private String[] urls;

        public Checkpoint(JsonObject jsonObject) throws IllegalArgumentException {
            if (JsonUtil.hasNonNull(jsonObject, "checkpoint")) {
                this.percentage = (byte) ((int) (jsonObject.get("checkpoint").getAsFloat() * 100.0f));
                if (JsonUtil.hasNonNull(jsonObject, "urls")) {
                    JsonArray asJsonArray = jsonObject.getAsJsonArray("urls");
                    this.urls = new String[asJsonArray.size()];
                    for (int i = 0; i < asJsonArray.size(); i++) {
                        if (asJsonArray.get(i) == null || "null".equalsIgnoreCase(asJsonArray.get(i).toString())) {
                            this.urls[i] = "";
                        } else {
                            this.urls[i] = asJsonArray.get(i).getAsString();
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("Checkpoint missing reporting URL!");
            }
            throw new IllegalArgumentException("Checkpoint missing percentage!");
        }

        public Checkpoint(JsonArray jsonArray, byte b) {
            if (jsonArray.size() != 0) {
                this.urls = new String[jsonArray.size()];
                for (int i = 0; i < jsonArray.size(); i++) {
                    this.urls[i] = jsonArray.get(i).getAsString();
                }
                this.percentage = b;
                return;
            }
            throw new IllegalArgumentException("Empty URLS!");
        }

        public String[] getUrls() {
            return (String[]) this.urls.clone();
        }

        public byte getPercentage() {
            return this.percentage;
        }

        public int compareTo(Checkpoint checkpoint) {
            return Float.compare((float) this.percentage, (float) checkpoint.percentage);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Checkpoint)) {
                return false;
            }
            Checkpoint checkpoint = (Checkpoint) obj;
            if (checkpoint.percentage != this.percentage || checkpoint.urls.length != this.urls.length) {
                return false;
            }
            int i = 0;
            while (true) {
                String[] strArr = this.urls;
                if (i >= strArr.length) {
                    return true;
                }
                if (!checkpoint.urls[i].equals(strArr[i])) {
                    return false;
                }
                i++;
            }
        }

        public int hashCode() {
            String[] strArr = this.urls;
            return (((this.percentage * 31) + strArr.length) * 31) + Arrays.hashCode(strArr);
        }
    }

    public String toString() {
        return "Advertisement{adType=" + this.adType + ", identifier='" + this.identifier + '\'' + ", appID='" + this.appID + '\'' + ", expireTime=" + this.expireTime + ", checkpoints=" + this.gson.toJson((Object) this.checkpoints, AdvertisementDBAdapter.CHECKPOINT_LIST_TYPE) + ", winNotifications='" + TextUtils.join(",", this.winNotifications) + ", dynamicEventsAndUrls=" + this.gson.toJson((Object) this.dynamicEventsAndUrls, AdvertisementDBAdapter.DYNAMIC_EVENTS_AND_URLS_TYPE) + ", delay=" + this.delay + ", campaign='" + this.campaign + '\'' + ", showCloseDelay=" + this.showCloseDelay + ", showCloseIncentivized=" + this.showCloseIncentivized + ", countdown=" + this.countdown + ", videoUrl='" + this.videoUrl + '\'' + ", videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", md5='" + this.md5 + '\'' + ", postrollBundleUrl='" + this.postrollBundleUrl + '\'' + ", ctaOverlayEnabled=" + this.ctaOverlayEnabled + ", ctaClickArea=" + this.ctaClickArea + ", ctaDestinationUrl='" + this.ctaDestinationUrl + '\'' + ", ctaUrl='" + this.ctaUrl + '\'' + ", adConfig=" + this.adConfig + ", retryCount=" + this.retryCount + ", adToken='" + this.adToken + '\'' + ", videoIdentifier='" + this.videoIdentifier + '\'' + ", templateUrl='" + this.templateUrl + '\'' + ", templateSettings=" + this.templateSettings + ", mraidFiles=" + this.mraidFiles + ", cacheableAssets=" + this.cacheableAssets + ", templateId='" + this.templateId + '\'' + ", templateType='" + this.templateType + '\'' + ", enableOm=" + this.enableOm + ", oMSDKExtraVast='" + this.omExtraVast + '\'' + ", requiresNonMarketInstall=" + this.requiresNonMarketInstall + ", adMarketId='" + this.adMarketId + '\'' + ", bidToken='" + this.bidToken + '\'' + ", state=" + this.state + '\'' + ", assetDownloadStartTime='" + this.assetDownloadStartTime + '\'' + ", assetDownloadDuration='" + this.assetDownloadDuration + '\'' + ", adRequestStartTime='" + this.adRequestStartTime + '\'' + ", requestTimestamp='" + this.serverRequestTimestamp + '\'' + ", headerBidding='" + this.headerBidding + '}';
    }

    public String getAdvertiserAppId() {
        String appID2 = getAppID();
        String appID3 = getAppID();
        if (appID3 != null && appID3.length() > 3) {
            try {
                JSONObject jSONObject = new JSONObject(appID3.substring(3));
                appID2 = jSONObject.isNull("app_id") ? null : jSONObject.optString("app_id", (String) null);
            } catch (JSONException e) {
                Log.e(TAG, "JsonException : ", e);
            }
        }
        return TextUtils.isEmpty(appID2) ? "unknown" : appID2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getCampaignId() {
        /*
            r3 = this;
            java.lang.String r0 = r3.getCampaign()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0018
            java.lang.String r1 = "\\|"
            java.lang.String[] r0 = r0.split(r1)
            int r1 = r0.length
            r2 = 1
            if (r1 < r2) goto L_0x0018
            r1 = 0
            r0 = r0[r1]
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0021
            java.lang.String r0 = "unknown"
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.model.Advertisement.getCampaignId():java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getCreativeId() {
        /*
            r3 = this;
            java.lang.String r0 = r3.getCampaign()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0018
            java.lang.String r1 = "\\|"
            java.lang.String[] r0 = r0.split(r1)
            int r1 = r0.length
            r2 = 2
            if (r1 < r2) goto L_0x0018
            r1 = 1
            r0 = r0[r1]
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0021
            java.lang.String r0 = "unknown"
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.model.Advertisement.getCreativeId():java.lang.String");
    }
}
