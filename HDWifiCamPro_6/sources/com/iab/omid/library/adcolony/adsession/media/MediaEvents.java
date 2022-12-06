package com.iab.omid.library.adcolony.adsession.media;

import com.iab.omid.library.adcolony.adsession.AdSession;
import com.iab.omid.library.adcolony.adsession.a;
import com.iab.omid.library.adcolony.b.f;
import com.iab.omid.library.adcolony.d.b;
import com.iab.omid.library.adcolony.d.e;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.warren.model.AdvertisementDBAdapter;
import org.json.JSONObject;

public final class MediaEvents {
    private final a adSession;

    private MediaEvents(a aVar) {
        this.adSession = aVar;
    }

    private void confirmValidDuration(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Invalid Media duration");
        }
    }

    private void confirmValidVolume(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Invalid Media volume");
        }
    }

    public static MediaEvents createMediaEvents(AdSession adSession2) {
        a aVar = (a) adSession2;
        e.a((Object) adSession2, "AdSession is null");
        e.g(aVar);
        e.a(aVar);
        e.b(aVar);
        e.e(aVar);
        MediaEvents mediaEvents = new MediaEvents(aVar);
        aVar.getAdSessionStatePublisher().a(mediaEvents);
        return mediaEvents;
    }

    public void adUserInteraction(InteractionType interactionType) {
        e.a((Object) interactionType, "InteractionType is null");
        e.c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        b.a(jSONObject, "interactionType", interactionType);
        this.adSession.getAdSessionStatePublisher().a("adUserInteraction", jSONObject);
    }

    public void bufferFinish() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("bufferFinish");
    }

    public void bufferStart() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("bufferStart");
    }

    public void complete() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE);
    }

    public void firstQuartile() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("firstQuartile");
    }

    public void midpoint() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a(CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT);
    }

    public void pause() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a(CampaignEx.JSON_NATIVE_VIDEO_PAUSE);
    }

    public void playerStateChange(PlayerState playerState) {
        e.a((Object) playerState, "PlayerState is null");
        e.c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        b.a(jSONObject, AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE, playerState);
        this.adSession.getAdSessionStatePublisher().a("playerStateChange", jSONObject);
    }

    public void resume() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a(CampaignEx.JSON_NATIVE_VIDEO_RESUME);
    }

    public void skipped() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("skipped");
    }

    public void start(float f, float f2) {
        confirmValidDuration(f);
        confirmValidVolume(f2);
        e.c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        b.a(jSONObject, IronSourceConstants.EVENTS_DURATION, Float.valueOf(f));
        b.a(jSONObject, "mediaPlayerVolume", Float.valueOf(f2));
        b.a(jSONObject, "deviceVolume", Float.valueOf(f.a().d()));
        this.adSession.getAdSessionStatePublisher().a("start", jSONObject);
    }

    public void thirdQuartile() {
        e.c(this.adSession);
        this.adSession.getAdSessionStatePublisher().a("thirdQuartile");
    }

    public void volumeChange(float f) {
        confirmValidVolume(f);
        e.c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        b.a(jSONObject, "mediaPlayerVolume", Float.valueOf(f));
        b.a(jSONObject, "deviceVolume", Float.valueOf(f.a().d()));
        this.adSession.getAdSessionStatePublisher().a("volumeChange", jSONObject);
    }
}
