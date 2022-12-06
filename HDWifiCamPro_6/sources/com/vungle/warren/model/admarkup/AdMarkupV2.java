package com.vungle.warren.model.admarkup;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.vungle.warren.model.Advertisement;
import java.io.Serializable;

public class AdMarkupV2 extends AdMarkup implements Serializable {
    private final String advertisementJsonObject;
    private final String placementId;

    public int getVersion() {
        return 2;
    }

    public AdMarkupV2(JsonObject jsonObject, String[] strArr) {
        this.impressions = strArr;
        JsonElement jsonElement = jsonObject.getAsJsonArray(CampaignUnit.JSON_KEY_ADS).get(0);
        this.placementId = jsonElement.getAsJsonObject().get("placement_reference_id").getAsString();
        this.advertisementJsonObject = jsonElement.getAsJsonObject().toString();
    }

    public String getEventId() {
        return getAdvertisement().getId();
    }

    public Advertisement getAdvertisement() {
        Advertisement advertisement = new Advertisement(JsonParser.parseString(this.advertisementJsonObject).getAsJsonObject());
        advertisement.setPlacementId(this.placementId);
        advertisement.setHeaderBidding(true);
        return advertisement;
    }
}
