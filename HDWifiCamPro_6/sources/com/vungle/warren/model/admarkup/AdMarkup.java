package com.vungle.warren.model.admarkup;

import java.io.Serializable;

public abstract class AdMarkup implements Serializable {
    String[] impressions = new String[0];

    public abstract String getEventId();

    public abstract int getVersion();

    public String[] getImpressions() {
        return this.impressions;
    }
}
