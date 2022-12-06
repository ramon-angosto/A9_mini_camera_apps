package com.vungle.warren.model;

import android.content.ContentValues;
import com.vungle.warren.AdConfig;
import com.vungle.warren.persistence.ContentValuesUtil;
import com.vungle.warren.persistence.DBAdapter;
import com.vungle.warren.persistence.IdColumns;

public class PlacementDBAdapter implements DBAdapter<Placement> {
    public static final String CREATE_PLACEMENT_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS placement(_id INTEGER PRIMARY KEY AUTOINCREMENT, item_id TEXT UNIQUE, incentivized SHORT, auto_cached SHORT, is_valid SHORT, wakeup_time NUMERIC, header_bidding SHORT, refresh_duration NUMERIC, supported_template_types NUMERIC, ad_size TEXT, autocache_priority NUMERIC, max_hb_cache NUMERIC, recommended_ad_size TEXT)";

    public interface PlacementColumns extends IdColumns {
        public static final String COLUMN_AD_SIZE = "ad_size";
        public static final String COLUMN_AUTOCACHED = "auto_cached";
        public static final String COLUMN_AUTOCACHE_PRIORITY = "autocache_priority";
        public static final String COLUMN_HEADERBIDDING = "header_bidding";
        public static final String COLUMN_INCENTIVIZED = "incentivized";
        public static final String COLUMN_IS_VALID = "is_valid";
        public static final String COLUMN_MAX_HB_CACHE = "max_hb_cache";
        public static final String COLUMN_RECOMMENDED_AD_SIZE = "recommended_ad_size";
        public static final String COLUMN_REFRESH_DURATION = "refresh_duration";
        public static final String COLUMN_SUPPORTED_TEMPLATE_TYPES = "supported_template_types";
        public static final String COLUMN_WAKEUP_TIME = "wakeup_time";
        public static final String TABLE_NAME = "placement";
    }

    public String tableName() {
        return "placement";
    }

    public ContentValues toContentValues(Placement placement) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(IdColumns.COLUMN_IDENTIFIER, placement.identifier);
        contentValues.put("incentivized", Boolean.valueOf(placement.incentivized));
        contentValues.put("header_bidding", Boolean.valueOf(placement.headerBidding));
        contentValues.put(PlacementColumns.COLUMN_AUTOCACHED, Boolean.valueOf(placement.autoCached));
        contentValues.put(PlacementColumns.COLUMN_WAKEUP_TIME, Long.valueOf(placement.wakeupTime));
        contentValues.put(PlacementColumns.COLUMN_IS_VALID, Boolean.valueOf(placement.isValid));
        contentValues.put(PlacementColumns.COLUMN_REFRESH_DURATION, Integer.valueOf(placement.adRefreshDuration));
        contentValues.put(PlacementColumns.COLUMN_SUPPORTED_TEMPLATE_TYPES, Integer.valueOf(placement.placementAdType));
        contentValues.put("ad_size", placement.getAdSize().getName());
        contentValues.put(PlacementColumns.COLUMN_AUTOCACHE_PRIORITY, Integer.valueOf(placement.autoCachePriority));
        contentValues.put(PlacementColumns.COLUMN_MAX_HB_CACHE, Integer.valueOf(placement.maxHbCache));
        contentValues.put(PlacementColumns.COLUMN_RECOMMENDED_AD_SIZE, placement.getRecommendedAdSize().getName());
        return contentValues;
    }

    public Placement fromContentValues(ContentValues contentValues) {
        Placement placement = new Placement();
        placement.identifier = contentValues.getAsString(IdColumns.COLUMN_IDENTIFIER);
        placement.wakeupTime = contentValues.getAsLong(PlacementColumns.COLUMN_WAKEUP_TIME).longValue();
        placement.incentivized = ContentValuesUtil.getBoolean(contentValues, "incentivized");
        placement.headerBidding = ContentValuesUtil.getBoolean(contentValues, "header_bidding");
        placement.autoCached = ContentValuesUtil.getBoolean(contentValues, PlacementColumns.COLUMN_AUTOCACHED);
        placement.isValid = ContentValuesUtil.getBoolean(contentValues, PlacementColumns.COLUMN_IS_VALID);
        placement.adRefreshDuration = contentValues.getAsInteger(PlacementColumns.COLUMN_REFRESH_DURATION).intValue();
        placement.placementAdType = contentValues.getAsInteger(PlacementColumns.COLUMN_SUPPORTED_TEMPLATE_TYPES).intValue();
        placement.adSize = AdConfig.AdSize.fromName(contentValues.getAsString("ad_size"));
        placement.autoCachePriority = contentValues.getAsInteger(PlacementColumns.COLUMN_AUTOCACHE_PRIORITY).intValue();
        placement.maxHbCache = contentValues.getAsInteger(PlacementColumns.COLUMN_MAX_HB_CACHE).intValue();
        placement.recommendedAdSize = AdConfig.AdSize.fromName(contentValues.getAsString(PlacementColumns.COLUMN_RECOMMENDED_AD_SIZE));
        return placement;
    }
}
