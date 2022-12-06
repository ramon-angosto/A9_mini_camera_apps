package com.vungle.warren.model;

import android.text.TextUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.vungle.warren.AdConfig;
import com.vungle.warren.SessionTracker;
import com.vungle.warren.model.AdvertisementDBAdapter;
import com.vungle.warren.model.ReportDBAdapter;
import com.vungle.warren.utility.HashUtility;
import java.util.ArrayList;
import java.util.List;

public class Report {
    private static final String DOWNLOAD_ACTION = "download";
    public static final int FAILED = 3;
    public static final int NEW = 0;
    public static final int READY = 1;
    public static final int SENDING = 2;
    long adDuration;
    String adSize;
    long adStartTime;
    String adToken;
    String adType;
    String advertisementID;
    String appId;
    public long assetDownloadDuration;
    String campaign;
    final List<String> clickedThrough;
    final List<String> errors;
    boolean headerBidding;
    boolean incentivized;
    public long initTimeStamp;
    int ordinal;
    String placementId;
    boolean playRemoteUrl;
    int status;
    String templateId;
    long ttDownload;
    String url;
    final List<UserAction> userActions;
    String userID;
    long videoLength;
    int videoViewed;
    volatile boolean wasCTAClicked;

    public @interface Status {
    }

    Report() {
        this.status = 0;
        this.userActions = new ArrayList();
        this.clickedThrough = new ArrayList();
        this.errors = new ArrayList();
    }

    public Report(Advertisement advertisement, Placement placement, long j) {
        this(advertisement, placement, j, (String) null);
    }

    public Report(Advertisement advertisement, Placement placement, long j, String str) {
        this.status = 0;
        this.userActions = new ArrayList();
        this.clickedThrough = new ArrayList();
        this.errors = new ArrayList();
        this.placementId = placement.getId();
        this.adToken = advertisement.getAdToken();
        this.advertisementID = advertisement.getId();
        this.appId = advertisement.getAppID();
        this.incentivized = placement.isIncentivized();
        this.headerBidding = placement.isHeaderBidding();
        this.adStartTime = j;
        this.url = advertisement.getUrl();
        this.ttDownload = -1;
        this.campaign = advertisement.getCampaign();
        this.initTimeStamp = SessionTracker.getInstance().getInitTimestamp();
        this.assetDownloadDuration = advertisement.getAssetDownloadDuration();
        int adType2 = advertisement.getAdType();
        if (adType2 == 0) {
            this.adType = "vungle_local";
        } else if (adType2 == 1) {
            this.adType = "vungle_mraid";
        } else {
            throw new IllegalArgumentException("Unknown ad type, cannot process!");
        }
        this.templateId = advertisement.getTemplateId();
        if (str == null) {
            this.userID = "";
        } else {
            this.userID = str;
        }
        this.ordinal = advertisement.getAdConfig().getOrdinal();
        AdConfig.AdSize adSize2 = advertisement.getAdConfig().getAdSize();
        if (AdConfig.AdSize.isNonMrecBannerAdSize(adSize2)) {
            this.adSize = adSize2.getName();
        }
    }

    public synchronized void recordAction(String str, String str2, long j) {
        this.userActions.add(new UserAction(str, str2, j));
        this.clickedThrough.add(str);
        if (str.equals("download")) {
            this.wasCTAClicked = true;
        }
    }

    public synchronized void recordError(String str) {
        this.errors.add(str);
    }

    public void recordProgress(int i) {
        this.videoViewed = i;
    }

    public void setVideoLength(long j) {
        this.videoLength = j;
    }

    public void setAdDuration(long j) {
        this.adDuration = j;
    }

    public long getAdDuration() {
        return this.adDuration;
    }

    public void setTtDownload(long j) {
        this.ttDownload = j;
    }

    public void setAllAssetDownloaded(boolean z) {
        this.playRemoteUrl = !z;
    }

    public String getPlacementId() {
        return this.placementId;
    }

    public String getAdvertisementID() {
        return this.advertisementID;
    }

    public boolean isCTAClicked() {
        return this.wasCTAClicked;
    }

    public String getUserID() {
        return this.userID;
    }

    public synchronized JsonObject toReportBody() {
        JsonObject jsonObject;
        jsonObject = new JsonObject();
        jsonObject.addProperty("placement_reference_id", this.placementId);
        jsonObject.addProperty(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_AD_TOKEN, this.adToken);
        jsonObject.addProperty("app_id", this.appId);
        jsonObject.addProperty("incentivized", (Number) Integer.valueOf(this.incentivized ? 1 : 0));
        jsonObject.addProperty("header_bidding", Boolean.valueOf(this.headerBidding));
        jsonObject.addProperty("play_remote_assets", Boolean.valueOf(this.playRemoteUrl));
        jsonObject.addProperty(ReportDBAdapter.ReportColumns.COLUMN_AD_START_TIME, (Number) Long.valueOf(this.adStartTime));
        if (!TextUtils.isEmpty(this.url)) {
            jsonObject.addProperty("url", this.url);
        }
        jsonObject.addProperty("adDuration", (Number) Long.valueOf(this.adDuration));
        jsonObject.addProperty("ttDownload", (Number) Long.valueOf(this.ttDownload));
        jsonObject.addProperty("campaign", this.campaign);
        jsonObject.addProperty("adType", this.adType);
        jsonObject.addProperty("templateId", this.templateId);
        jsonObject.addProperty(ReportDBAdapter.ReportColumns.COLUMN_INIT_TIMESTAMP, (Number) Long.valueOf(this.initTimeStamp));
        jsonObject.addProperty("asset_download_duration", (Number) Long.valueOf(this.assetDownloadDuration));
        if (!TextUtils.isEmpty(this.adSize)) {
            jsonObject.addProperty("ad_size", this.adSize);
        }
        JsonArray jsonArray = new JsonArray();
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("startTime", (Number) Long.valueOf(this.adStartTime));
        if (this.videoViewed > 0) {
            jsonObject2.addProperty(ReportDBAdapter.ReportColumns.COLUMN_VIDEO_VIEWED, (Number) Integer.valueOf(this.videoViewed));
        }
        if (this.videoLength > 0) {
            jsonObject2.addProperty("videoLength", (Number) Long.valueOf(this.videoLength));
        }
        JsonArray jsonArray2 = new JsonArray();
        for (UserAction json : this.userActions) {
            jsonArray2.add((JsonElement) json.toJson());
        }
        jsonObject2.add("userActions", jsonArray2);
        jsonArray.add((JsonElement) jsonObject2);
        jsonObject.add("plays", jsonArray);
        JsonArray jsonArray3 = new JsonArray();
        for (String add : this.errors) {
            jsonArray3.add(add);
        }
        jsonObject.add(ReportDBAdapter.ReportColumns.COLUMN_ERRORS, jsonArray3);
        JsonArray jsonArray4 = new JsonArray();
        for (String add2 : this.clickedThrough) {
            jsonArray4.add(add2);
        }
        jsonObject.add("clickedThrough", jsonArray4);
        if (this.incentivized && !TextUtils.isEmpty(this.userID)) {
            jsonObject.addProperty("user", this.userID);
        }
        if (this.ordinal > 0) {
            jsonObject.addProperty("ordinal_view", (Number) Integer.valueOf(this.ordinal));
        }
        return jsonObject;
    }

    public String getId() {
        return this.placementId + "_" + this.adStartTime;
    }

    public long getAdStartTime() {
        return this.adStartTime;
    }

    public static class UserAction {
        @SerializedName("action")
        private String action;
        @SerializedName("timestamp")
        private long timestamp;
        @SerializedName("value")
        private String value;

        public UserAction(String str, String str2, long j) {
            this.action = str;
            this.value = str2;
            this.timestamp = j;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            UserAction userAction = (UserAction) obj;
            return userAction.action.equals(this.action) && userAction.value.equals(this.value) && userAction.timestamp == this.timestamp;
        }

        public int hashCode() {
            long j = this.timestamp;
            return (((this.action.hashCode() * 31) + this.value.hashCode()) * 31) + ((int) (j ^ (j >>> 32)));
        }

        public JsonObject toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("action", this.action);
            String str = this.value;
            if (str != null && !str.isEmpty()) {
                jsonObject.addProperty(AppMeasurementSdk.ConditionalUserProperty.VALUE, this.value);
            }
            jsonObject.addProperty("timestamp_millis", (Number) Long.valueOf(this.timestamp));
            return jsonObject;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0167, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 1
            if (r6 != r7) goto L_0x0006
            monitor-exit(r6)
            return r0
        L_0x0006:
            r1 = 0
            if (r7 == 0) goto L_0x0166
            java.lang.Class r2 = r6.getClass()     // Catch:{ all -> 0x0163 }
            java.lang.Class r3 = r7.getClass()     // Catch:{ all -> 0x0163 }
            if (r2 == r3) goto L_0x0015
            goto L_0x0166
        L_0x0015:
            com.vungle.warren.model.Report r7 = (com.vungle.warren.model.Report) r7     // Catch:{ all -> 0x0163 }
            java.lang.String r2 = r7.placementId     // Catch:{ all -> 0x0163 }
            java.lang.String r3 = r6.placementId     // Catch:{ all -> 0x0163 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0163 }
            if (r2 != 0) goto L_0x0023
            monitor-exit(r6)
            return r1
        L_0x0023:
            java.lang.String r2 = r7.adToken     // Catch:{ all -> 0x0163 }
            java.lang.String r3 = r6.adToken     // Catch:{ all -> 0x0163 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0163 }
            if (r2 != 0) goto L_0x002f
            monitor-exit(r6)
            return r1
        L_0x002f:
            java.lang.String r2 = r7.appId     // Catch:{ all -> 0x0163 }
            java.lang.String r3 = r6.appId     // Catch:{ all -> 0x0163 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0163 }
            if (r2 != 0) goto L_0x003b
            monitor-exit(r6)
            return r1
        L_0x003b:
            boolean r2 = r7.incentivized     // Catch:{ all -> 0x0163 }
            boolean r3 = r6.incentivized     // Catch:{ all -> 0x0163 }
            if (r2 == r3) goto L_0x0043
            monitor-exit(r6)
            return r1
        L_0x0043:
            boolean r2 = r7.headerBidding     // Catch:{ all -> 0x0163 }
            boolean r3 = r6.headerBidding     // Catch:{ all -> 0x0163 }
            if (r2 == r3) goto L_0x004b
            monitor-exit(r6)
            return r1
        L_0x004b:
            long r2 = r7.adStartTime     // Catch:{ all -> 0x0163 }
            long r4 = r6.adStartTime     // Catch:{ all -> 0x0163 }
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0055
            monitor-exit(r6)
            return r1
        L_0x0055:
            java.lang.String r2 = r7.url     // Catch:{ all -> 0x0163 }
            java.lang.String r3 = r6.url     // Catch:{ all -> 0x0163 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0163 }
            if (r2 != 0) goto L_0x0061
            monitor-exit(r6)
            return r1
        L_0x0061:
            long r2 = r7.videoLength     // Catch:{ all -> 0x0163 }
            long r4 = r6.videoLength     // Catch:{ all -> 0x0163 }
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x006b
            monitor-exit(r6)
            return r1
        L_0x006b:
            long r2 = r7.adDuration     // Catch:{ all -> 0x0163 }
            long r4 = r6.adDuration     // Catch:{ all -> 0x0163 }
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0075
            monitor-exit(r6)
            return r1
        L_0x0075:
            long r2 = r7.ttDownload     // Catch:{ all -> 0x0163 }
            long r4 = r6.ttDownload     // Catch:{ all -> 0x0163 }
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x007f
            monitor-exit(r6)
            return r1
        L_0x007f:
            java.lang.String r2 = r7.campaign     // Catch:{ all -> 0x0163 }
            java.lang.String r3 = r6.campaign     // Catch:{ all -> 0x0163 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0163 }
            if (r2 != 0) goto L_0x008b
            monitor-exit(r6)
            return r1
        L_0x008b:
            java.lang.String r2 = r7.adType     // Catch:{ all -> 0x0163 }
            java.lang.String r3 = r6.adType     // Catch:{ all -> 0x0163 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0163 }
            if (r2 != 0) goto L_0x0097
            monitor-exit(r6)
            return r1
        L_0x0097:
            java.lang.String r2 = r7.templateId     // Catch:{ all -> 0x0163 }
            java.lang.String r3 = r6.templateId     // Catch:{ all -> 0x0163 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0163 }
            if (r2 != 0) goto L_0x00a3
            monitor-exit(r6)
            return r1
        L_0x00a3:
            boolean r2 = r7.wasCTAClicked     // Catch:{ all -> 0x0163 }
            boolean r3 = r6.wasCTAClicked     // Catch:{ all -> 0x0163 }
            if (r2 == r3) goto L_0x00ab
            monitor-exit(r6)
            return r1
        L_0x00ab:
            java.lang.String r2 = r7.userID     // Catch:{ all -> 0x0163 }
            java.lang.String r3 = r6.userID     // Catch:{ all -> 0x0163 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0163 }
            if (r2 != 0) goto L_0x00b7
            monitor-exit(r6)
            return r1
        L_0x00b7:
            long r2 = r7.initTimeStamp     // Catch:{ all -> 0x0163 }
            long r4 = r6.initTimeStamp     // Catch:{ all -> 0x0163 }
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x00c1
            monitor-exit(r6)
            return r1
        L_0x00c1:
            long r2 = r7.assetDownloadDuration     // Catch:{ all -> 0x0163 }
            long r4 = r6.assetDownloadDuration     // Catch:{ all -> 0x0163 }
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x00cb
            monitor-exit(r6)
            return r1
        L_0x00cb:
            java.util.List<java.lang.String> r2 = r7.clickedThrough     // Catch:{ all -> 0x0163 }
            int r2 = r2.size()     // Catch:{ all -> 0x0163 }
            java.util.List<java.lang.String> r3 = r6.clickedThrough     // Catch:{ all -> 0x0163 }
            int r3 = r3.size()     // Catch:{ all -> 0x0163 }
            if (r2 == r3) goto L_0x00db
            monitor-exit(r6)
            return r1
        L_0x00db:
            r2 = r1
        L_0x00dc:
            java.util.List<java.lang.String> r3 = r6.clickedThrough     // Catch:{ all -> 0x0163 }
            int r3 = r3.size()     // Catch:{ all -> 0x0163 }
            if (r2 >= r3) goto L_0x00fd
            java.util.List<java.lang.String> r3 = r7.clickedThrough     // Catch:{ all -> 0x0163 }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x0163 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0163 }
            java.util.List<java.lang.String> r4 = r6.clickedThrough     // Catch:{ all -> 0x0163 }
            java.lang.Object r4 = r4.get(r2)     // Catch:{ all -> 0x0163 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0163 }
            if (r3 != 0) goto L_0x00fa
            monitor-exit(r6)
            return r1
        L_0x00fa:
            int r2 = r2 + 1
            goto L_0x00dc
        L_0x00fd:
            java.util.List<java.lang.String> r2 = r7.errors     // Catch:{ all -> 0x0163 }
            int r2 = r2.size()     // Catch:{ all -> 0x0163 }
            java.util.List<java.lang.String> r3 = r6.errors     // Catch:{ all -> 0x0163 }
            int r3 = r3.size()     // Catch:{ all -> 0x0163 }
            if (r2 == r3) goto L_0x010d
            monitor-exit(r6)
            return r1
        L_0x010d:
            r2 = r1
        L_0x010e:
            java.util.List<java.lang.String> r3 = r6.errors     // Catch:{ all -> 0x0163 }
            int r3 = r3.size()     // Catch:{ all -> 0x0163 }
            if (r2 >= r3) goto L_0x012f
            java.util.List<java.lang.String> r3 = r7.errors     // Catch:{ all -> 0x0163 }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x0163 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0163 }
            java.util.List<java.lang.String> r4 = r6.errors     // Catch:{ all -> 0x0163 }
            java.lang.Object r4 = r4.get(r2)     // Catch:{ all -> 0x0163 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0163 }
            if (r3 != 0) goto L_0x012c
            monitor-exit(r6)
            return r1
        L_0x012c:
            int r2 = r2 + 1
            goto L_0x010e
        L_0x012f:
            java.util.List<com.vungle.warren.model.Report$UserAction> r2 = r7.userActions     // Catch:{ all -> 0x0163 }
            int r2 = r2.size()     // Catch:{ all -> 0x0163 }
            java.util.List<com.vungle.warren.model.Report$UserAction> r3 = r6.userActions     // Catch:{ all -> 0x0163 }
            int r3 = r3.size()     // Catch:{ all -> 0x0163 }
            if (r2 == r3) goto L_0x013f
            monitor-exit(r6)
            return r1
        L_0x013f:
            r2 = r1
        L_0x0140:
            java.util.List<com.vungle.warren.model.Report$UserAction> r3 = r6.userActions     // Catch:{ all -> 0x0163 }
            int r3 = r3.size()     // Catch:{ all -> 0x0163 }
            if (r2 >= r3) goto L_0x0161
            java.util.List<com.vungle.warren.model.Report$UserAction> r3 = r7.userActions     // Catch:{ all -> 0x0163 }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x0163 }
            com.vungle.warren.model.Report$UserAction r3 = (com.vungle.warren.model.Report.UserAction) r3     // Catch:{ all -> 0x0163 }
            java.util.List<com.vungle.warren.model.Report$UserAction> r4 = r6.userActions     // Catch:{ all -> 0x0163 }
            java.lang.Object r4 = r4.get(r2)     // Catch:{ all -> 0x0163 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0163 }
            if (r3 != 0) goto L_0x015e
            monitor-exit(r6)
            return r1
        L_0x015e:
            int r2 = r2 + 1
            goto L_0x0140
        L_0x0161:
            monitor-exit(r6)
            return r0
        L_0x0163:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        L_0x0166:
            monitor-exit(r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.model.Report.equals(java.lang.Object):boolean");
    }

    public synchronized int hashCode() {
        int i;
        int hashCode;
        i = 1;
        hashCode = ((((((HashUtility.getHashCode(this.placementId) * 31) + HashUtility.getHashCode(this.adToken)) * 31) + HashUtility.getHashCode(this.appId)) * 31) + (this.incentivized ? 1 : 0)) * 31;
        if (!this.headerBidding) {
            i = 0;
        }
        return ((((((((((((((((((((((((((((((hashCode + i) * 31) + ((int) (this.adStartTime ^ (this.adStartTime >>> 32)))) * 31) + HashUtility.getHashCode(this.url)) * 31) + ((int) (this.videoLength ^ (this.videoLength >>> 32)))) * 31) + ((int) (this.adDuration ^ (this.adDuration >>> 32)))) * 31) + ((int) (this.ttDownload ^ (this.ttDownload >>> 32)))) * 31) + ((int) (this.initTimeStamp ^ (this.initTimeStamp >>> 32)))) * 31) + ((int) (this.assetDownloadDuration ^ (this.assetDownloadDuration >>> 32)))) * 31) + HashUtility.getHashCode(this.campaign)) * 31) + HashUtility.getHashCode(this.userActions)) * 31) + HashUtility.getHashCode(this.clickedThrough)) * 31) + HashUtility.getHashCode(this.errors)) * 31) + HashUtility.getHashCode(this.adType)) * 31) + HashUtility.getHashCode(this.templateId)) * 31) + HashUtility.getHashCode(this.userID)) * 31) + (this.wasCTAClicked ? 1 : 0);
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
