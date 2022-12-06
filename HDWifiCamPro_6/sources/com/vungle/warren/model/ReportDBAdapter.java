package com.vungle.warren.model;

import android.content.ContentValues;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.vungle.warren.model.Report;
import com.vungle.warren.persistence.ContentValuesUtil;
import com.vungle.warren.persistence.DBAdapter;
import com.vungle.warren.persistence.IdColumns;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ReportDBAdapter implements DBAdapter<Report> {
    public static final String CREATE_REPORT_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS report(_id INTEGER PRIMARY KEY AUTOINCREMENT, item_id TEXT UNIQUE,appId TEXT, placementId TEXT, adToken TEXT, incentivized SHORT, header_bidding SHORT, adStartTime NUMERIC, url TEXT, ad_duration NUMERIC, tt_download NUMERIC, campaign TEXT, videoViewed NUMERIC, ad_type TEXT, template_id TEXT, was_CTAC_licked SHORT, clicked_through TEXT, errors TEXT, user_actions TEXT, user_id TEXT, ordinal INT, videoLength NUMERIC, status INT, ad_size TEXT, init_timestamp NUMERIC, asset_download_duration NUMERIC,play_remote_url SHORT )";
    private Gson gson = new GsonBuilder().create();
    Type stringType = new TypeToken<ArrayList<String>>() {
    }.getType();
    Type userActionsType = new TypeToken<ArrayList<Report.UserAction>>() {
    }.getType();

    public interface ReportColumns extends IdColumns {
        public static final String COLUMN_AD_DURATION = "ad_duration";
        public static final String COLUMN_AD_SIZE = "ad_size";
        public static final String COLUMN_AD_START_TIME = "adStartTime";
        public static final String COLUMN_AD_TOKEN = "adToken";
        public static final String COLUMN_AD_TYPE = "ad_type";
        public static final String COLUMN_APP_ID = "appId";
        public static final String COLUMN_ASSET_DOWNLOAD_DURATION = "asset_download_duration";
        public static final String COLUMN_CAMPAIGN = "campaign";
        public static final String COLUMN_CLICKED_THROUGH = "clicked_through";
        public static final String COLUMN_ERRORS = "errors";
        public static final String COLUMN_HEADERBIDDING = "header_bidding";
        public static final String COLUMN_INCENTIVIZED = "incentivized";
        public static final String COLUMN_INIT_TIMESTAMP = "init_timestamp";
        public static final String COLUMN_ORDINAL = "ordinal";
        public static final String COLUMN_PLACEMENT_ID = "placementId";
        public static final String COLUMN_PLAY_REMOTE_URL = "play_remote_url";
        public static final String COLUMN_REPORT_STATUS = "status";
        public static final String COLUMN_TEMPATE_ID = "template_id";
        public static final String COLUMN_TT_DOWNLOAD = "tt_download";
        public static final String COLUMN_URL = "url";
        public static final String COLUMN_USER_ACTIONS = "user_actions";
        public static final String COLUMN_USER_ID = "user_id";
        public static final String COLUMN_VIDEO_LENGTH = "videoLength";
        public static final String COLUMN_VIDEO_VIEWED = "videoViewed";
        public static final String COLUMN_WAS_CTA_CLICKED = "was_CTAC_licked";
        public static final String TABLE_NAME = "report";
    }

    public String tableName() {
        return ReportColumns.TABLE_NAME;
    }

    public ContentValues toContentValues(Report report) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(IdColumns.COLUMN_IDENTIFIER, report.getId());
        contentValues.put(ReportColumns.COLUMN_AD_DURATION, Long.valueOf(report.adDuration));
        contentValues.put(ReportColumns.COLUMN_AD_START_TIME, Long.valueOf(report.adStartTime));
        contentValues.put(ReportColumns.COLUMN_AD_TOKEN, report.adToken);
        contentValues.put("ad_type", report.adType);
        contentValues.put("appId", report.appId);
        contentValues.put("campaign", report.campaign);
        contentValues.put("incentivized", Boolean.valueOf(report.incentivized));
        contentValues.put("header_bidding", Boolean.valueOf(report.headerBidding));
        contentValues.put(ReportColumns.COLUMN_ORDINAL, Integer.valueOf(report.ordinal));
        contentValues.put(ReportColumns.COLUMN_PLACEMENT_ID, report.placementId);
        contentValues.put(ReportColumns.COLUMN_TEMPATE_ID, report.templateId);
        contentValues.put("tt_download", Long.valueOf(report.ttDownload));
        contentValues.put("url", report.url);
        contentValues.put(ReportColumns.COLUMN_USER_ID, report.userID);
        contentValues.put("videoLength", Long.valueOf(report.videoLength));
        contentValues.put(ReportColumns.COLUMN_VIDEO_VIEWED, Integer.valueOf(report.videoViewed));
        contentValues.put(ReportColumns.COLUMN_WAS_CTA_CLICKED, Boolean.valueOf(report.wasCTAClicked));
        contentValues.put(ReportColumns.COLUMN_USER_ACTIONS, this.gson.toJson((Object) new ArrayList(report.userActions), this.userActionsType));
        contentValues.put(ReportColumns.COLUMN_CLICKED_THROUGH, this.gson.toJson((Object) new ArrayList(report.clickedThrough), this.stringType));
        contentValues.put(ReportColumns.COLUMN_ERRORS, this.gson.toJson((Object) new ArrayList(report.errors), this.stringType));
        contentValues.put("status", Integer.valueOf(report.status));
        contentValues.put("ad_size", report.adSize);
        contentValues.put(ReportColumns.COLUMN_INIT_TIMESTAMP, Long.valueOf(report.initTimeStamp));
        contentValues.put("asset_download_duration", Long.valueOf(report.assetDownloadDuration));
        contentValues.put(ReportColumns.COLUMN_PLAY_REMOTE_URL, Boolean.valueOf(report.playRemoteUrl));
        return contentValues;
    }

    public Report fromContentValues(ContentValues contentValues) {
        Report report = new Report();
        report.adDuration = contentValues.getAsLong(ReportColumns.COLUMN_AD_DURATION).longValue();
        report.adStartTime = contentValues.getAsLong(ReportColumns.COLUMN_AD_START_TIME).longValue();
        report.adToken = contentValues.getAsString(ReportColumns.COLUMN_AD_TOKEN);
        report.adType = contentValues.getAsString("ad_type");
        report.appId = contentValues.getAsString("appId");
        report.campaign = contentValues.getAsString("campaign");
        report.ordinal = contentValues.getAsInteger(ReportColumns.COLUMN_ORDINAL).intValue();
        report.placementId = contentValues.getAsString(ReportColumns.COLUMN_PLACEMENT_ID);
        report.templateId = contentValues.getAsString(ReportColumns.COLUMN_TEMPATE_ID);
        report.ttDownload = contentValues.getAsLong("tt_download").longValue();
        report.url = contentValues.getAsString("url");
        report.userID = contentValues.getAsString(ReportColumns.COLUMN_USER_ID);
        report.videoLength = contentValues.getAsLong("videoLength").longValue();
        report.videoViewed = contentValues.getAsInteger(ReportColumns.COLUMN_VIDEO_VIEWED).intValue();
        report.wasCTAClicked = ContentValuesUtil.getBoolean(contentValues, ReportColumns.COLUMN_WAS_CTA_CLICKED);
        report.incentivized = ContentValuesUtil.getBoolean(contentValues, "incentivized");
        report.headerBidding = ContentValuesUtil.getBoolean(contentValues, "header_bidding");
        report.status = contentValues.getAsInteger("status").intValue();
        report.adSize = contentValues.getAsString("ad_size");
        report.initTimeStamp = contentValues.getAsLong(ReportColumns.COLUMN_INIT_TIMESTAMP).longValue();
        report.assetDownloadDuration = contentValues.getAsLong("asset_download_duration").longValue();
        report.playRemoteUrl = ContentValuesUtil.getBoolean(contentValues, ReportColumns.COLUMN_PLAY_REMOTE_URL);
        List list = (List) this.gson.fromJson(contentValues.getAsString(ReportColumns.COLUMN_CLICKED_THROUGH), this.stringType);
        List list2 = (List) this.gson.fromJson(contentValues.getAsString(ReportColumns.COLUMN_ERRORS), this.stringType);
        List list3 = (List) this.gson.fromJson(contentValues.getAsString(ReportColumns.COLUMN_USER_ACTIONS), this.userActionsType);
        if (list != null) {
            report.clickedThrough.addAll(list);
        }
        if (list2 != null) {
            report.errors.addAll(list2);
        }
        if (list3 != null) {
            report.userActions.addAll(list3);
        }
        return report;
    }
}
