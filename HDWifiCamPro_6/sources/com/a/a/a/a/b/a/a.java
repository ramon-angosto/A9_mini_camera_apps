package com.a.a.a.a.b.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;

public enum a {
    CLICK(CampaignEx.JSON_NATIVE_VIDEO_CLICK),
    INVITATION_ACCEPTED("invitationAccept");
    
    String c;

    private a(String str) {
        this.c = str;
    }

    public String toString() {
        return this.c;
    }
}
