package com.xiaomi.clientreport.data;

import com.xiaomi.channel.commonutils.logger.C1524b;
import org.json.JSONException;
import org.json.JSONObject;

public class EventClientReport extends C1526a {
    public String eventContent;
    public String eventId;
    public long eventTime;
    public int eventType;

    public static EventClientReport getBlankInstance() {
        return new EventClientReport();
    }

    public JSONObject toJson() {
        try {
            JSONObject json = super.toJson();
            if (json == null) {
                return null;
            }
            json.put("eventId", this.eventId);
            json.put("eventType", this.eventType);
            json.put("eventTime", this.eventTime);
            json.put("eventContent", this.eventContent == null ? "" : this.eventContent);
            return json;
        } catch (JSONException e) {
            C1524b.m2155a((Throwable) e);
            return null;
        }
    }

    public String toJsonString() {
        return super.toJsonString();
    }
}
