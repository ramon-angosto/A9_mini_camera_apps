package com.vungle.warren.log;

import com.google.gson.JsonObject;

class LogEntry {
    private static final String LOG_ITEM_BUNDLE_ID = "bundle_id";
    private static final String LOG_ITEM_CONTEXT = "context";
    private static final String LOG_ITEM_CREATION_DATE = "device_timestamp";
    private static final String LOG_ITEM_CUSTOM_DATA = "custom_data";
    private static final String LOG_ITEM_EVENT_ID = "event_id";
    private static final String LOG_ITEM_EX_CLASS = "exception_class";
    private static final String LOG_ITEM_LEVEL = "log_level";
    private static final String LOG_ITEM_MESSAGE = "raw_log";
    private static final String LOG_ITEM_SDK_USER_AGENT = "sdk_user_agent";
    private static final String LOG_ITEM_THREAD_ID = "thread_id";
    private static final String LOG_ITEM_TIME_ZONE = "time_zone";
    private static final String LOG_METADATA = "metadata";
    private String bundleID;
    private String context;
    private String creationDate;
    private String customData;
    private String eventID;
    private String exClass;
    private String level;
    private String message;
    private String threadId;
    private String timeZone;
    private String userAgent;

    LogEntry(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.level = str2;
        this.message = str;
        this.context = str3;
        this.eventID = str4;
        this.userAgent = str5;
        this.bundleID = str6;
        this.timeZone = str7;
        this.creationDate = str8;
        this.customData = str9;
        this.exClass = str10;
        this.threadId = str11;
    }

    public String toJsonString() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(LOG_ITEM_MESSAGE, this.message);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject.add("metadata", jsonObject2);
        addMetadataProperty(jsonObject2, LOG_ITEM_LEVEL, this.level);
        addMetadataProperty(jsonObject2, LOG_ITEM_CONTEXT, this.context);
        addMetadataProperty(jsonObject2, LOG_ITEM_EVENT_ID, this.eventID);
        addMetadataProperty(jsonObject2, LOG_ITEM_SDK_USER_AGENT, this.userAgent);
        addMetadataProperty(jsonObject2, LOG_ITEM_BUNDLE_ID, this.bundleID);
        addMetadataProperty(jsonObject2, LOG_ITEM_TIME_ZONE, this.timeZone);
        addMetadataProperty(jsonObject2, LOG_ITEM_CREATION_DATE, this.creationDate);
        addMetadataProperty(jsonObject2, LOG_ITEM_CUSTOM_DATA, this.customData);
        addMetadataProperty(jsonObject2, LOG_ITEM_EX_CLASS, this.exClass);
        addMetadataProperty(jsonObject2, LOG_ITEM_THREAD_ID, this.threadId);
        return jsonObject.toString();
    }

    private void addMetadataProperty(JsonObject jsonObject, String str, String str2) {
        if (str2 != null) {
            jsonObject.addProperty(str, str2);
        }
    }
}
