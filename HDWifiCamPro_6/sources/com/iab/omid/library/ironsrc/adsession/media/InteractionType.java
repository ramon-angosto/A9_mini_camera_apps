package com.iab.omid.library.ironsrc.adsession.media;

import com.mbridge.msdk.foundation.entity.CampaignEx;

public enum InteractionType {
    CLICK(CampaignEx.JSON_NATIVE_VIDEO_CLICK),
    INVITATION_ACCEPTED("invitationAccept");
    
    String interactionType;

    private InteractionType(String str) {
        this.interactionType = str;
    }

    public final String toString() {
        return this.interactionType;
    }
}
