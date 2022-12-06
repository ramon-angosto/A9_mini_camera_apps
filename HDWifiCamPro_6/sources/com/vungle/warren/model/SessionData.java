package com.vungle.warren.model;

import androidx.core.app.NotificationCompat;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.vungle.warren.session.SessionAttribute;
import com.vungle.warren.session.SessionEvent;
import com.vungle.warren.utility.HashUtility;

public class SessionData {
    private static final Gson GSON = new Gson();
    private int sendAttempts;
    public SessionEvent sessionEvent;
    private JsonObject sessionEventJsonObject;

    protected SessionData(String str, int i) {
        this.sessionEventJsonObject = (JsonObject) GSON.fromJson(str, JsonObject.class);
        this.sendAttempts = i;
    }

    private SessionData(SessionEvent sessionEvent2, JsonObject jsonObject) {
        this.sessionEvent = sessionEvent2;
        this.sessionEventJsonObject = jsonObject;
        jsonObject.addProperty(SessionAttribute.TIMESTAMP.toString(), (Number) Long.valueOf(System.currentTimeMillis()));
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof SessionData)) {
            return false;
        }
        SessionData sessionData = (SessionData) obj;
        if (this.sessionEvent.equals(sessionData.sessionEvent) && this.sessionEventJsonObject.equals(sessionData.sessionEventJsonObject)) {
            return true;
        }
        return false;
    }

    public void removeEvent(SessionAttribute sessionAttribute) {
        this.sessionEventJsonObject.remove(sessionAttribute.toString());
    }

    public void addAttribute(SessionAttribute sessionAttribute, String str) {
        this.sessionEventJsonObject.addProperty(sessionAttribute.toString(), str);
    }

    public static class Builder {
        SessionEvent event;
        JsonObject jsonObject = new JsonObject();

        public SessionData build() {
            SessionEvent sessionEvent = this.event;
            if (sessionEvent != null) {
                return new SessionData(sessionEvent, this.jsonObject);
            }
            throw new IllegalArgumentException("SessionData must have event");
        }

        public Builder setEvent(SessionEvent sessionEvent) {
            this.event = sessionEvent;
            this.jsonObject.addProperty(NotificationCompat.CATEGORY_EVENT, sessionEvent.toString());
            return this;
        }

        public Builder addData(SessionAttribute sessionAttribute, String str) {
            this.jsonObject.addProperty(sessionAttribute.toString(), str);
            return this;
        }

        public Builder addData(SessionAttribute sessionAttribute, int i) {
            this.jsonObject.addProperty(sessionAttribute.toString(), (Number) Integer.valueOf(i));
            return this;
        }

        public Builder addData(SessionAttribute sessionAttribute, double d) {
            this.jsonObject.addProperty(sessionAttribute.toString(), (Number) Double.valueOf(d));
            return this;
        }

        public Builder addData(SessionAttribute sessionAttribute, boolean z) {
            this.jsonObject.addProperty(sessionAttribute.toString(), Boolean.valueOf(z));
            return this;
        }
    }

    public String getAsJsonString() {
        return GSON.toJson((JsonElement) this.sessionEventJsonObject);
    }

    public String getStringAttribute(SessionAttribute sessionAttribute) {
        JsonElement jsonElement = this.sessionEventJsonObject.get(sessionAttribute.toString());
        if (jsonElement != null) {
            return jsonElement.getAsString();
        }
        return null;
    }

    public String getId() {
        String sha256 = HashUtility.sha256(getAsJsonString());
        return sha256 == null ? String.valueOf(getAsJsonString().hashCode()) : sha256;
    }

    public int getSendAttempts() {
        return this.sendAttempts;
    }

    public int incrementSendAttempt() {
        int i = this.sendAttempts;
        this.sendAttempts = i + 1;
        return i;
    }
}
