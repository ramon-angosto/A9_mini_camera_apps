package com.vungle.warren;

import android.util.Log;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Placement;
import com.vungle.warren.model.SessionData;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.session.SessionAttribute;
import com.vungle.warren.session.SessionEvent;
import com.vungle.warren.tasks.JobRunner;
import com.vungle.warren.tasks.SendReportsJob;
import com.vungle.warren.ui.contract.AdContract;
import com.vungle.warren.utility.Constants;
import java.util.Map;

public class AdEventListener implements AdContract.AdvertisementPresenter.EventListener {
    private static final String TAG = AdEventListener.class.getCanonicalName();
    private final AdLoader adLoader;
    private boolean adRewarded;
    private Advertisement advertisement;
    private final JobRunner jobRunner;
    private int percentViewed = -1;
    private Placement placement;
    private final PlayAdCallback playAdCallback;
    private final Map<String, Boolean> playOperations;
    private final Repository repository;
    private final AdRequest request;
    private boolean successfulView;
    private final VisionController visionController;

    AdEventListener(AdRequest adRequest, Map<String, Boolean> map, PlayAdCallback playAdCallback2, Repository repository2, AdLoader adLoader2, JobRunner jobRunner2, VisionController visionController2, Placement placement2, Advertisement advertisement2) {
        this.request = adRequest;
        this.playOperations = map;
        this.playAdCallback = playAdCallback2;
        this.repository = repository2;
        this.adLoader = adLoader2;
        this.jobRunner = jobRunner2;
        this.visionController = visionController2;
        this.placement = placement2;
        this.advertisement = advertisement2;
        map.put(adRequest.getPlacementId(), true);
    }

    public void onNext(String str, String str2, String str3) {
        boolean z;
        loadAdvertisement();
        if (this.advertisement == null) {
            Log.e(TAG, "No Advertisement for ID");
            onFinished();
            PlayAdCallback playAdCallback2 = this.playAdCallback;
            if (playAdCallback2 != null) {
                playAdCallback2.onError(this.request.getPlacementId(), new VungleException(10));
                VungleLogger.error("AdEventListener#PlayAdCallback", str3 + ": AD_UNABLE_TO_PLAY");
                return;
            }
            return;
        }
        loadPlacement();
        if (this.placement == null) {
            Log.e(TAG, "No Placement for ID");
            onFinished();
            PlayAdCallback playAdCallback3 = this.playAdCallback;
            if (playAdCallback3 != null) {
                playAdCallback3.onError(this.request.getPlacementId(), new VungleException(13));
                VungleLogger.error("AdEventListener#PlayAdCallback", "PLACEMENT_NOT_FOUND: " + str3);
                return;
            }
            return;
        }
        try {
            boolean z2 = false;
            if (str.equals("start")) {
                this.repository.saveAndApplyState(this.advertisement, str3, 2);
                if (this.playAdCallback != null) {
                    this.playAdCallback.onAdStart(str3);
                    VungleLogger.debug("AdEventListener#PlayAdCallback", "onAdStart: " + str3);
                }
                this.percentViewed = 0;
                this.placement = this.repository.load(this.request.getPlacementId(), Placement.class).get();
                if (this.placement != null) {
                    this.adLoader.loadEndlessIfNeeded(this.placement, this.placement.getAdSize(), 0, this.request.getIsExplicit());
                }
                if (this.visionController.isEnabled()) {
                    this.visionController.reportData(this.advertisement.getCreativeId(), this.advertisement.getCampaignId(), this.advertisement.getAdvertiserAppId());
                }
            } else if (str.equals(TtmlNode.END)) {
                Log.d(BuildConfig.OMSDK_PARTNER_NAME, "Cleaning up metadata and assets for placement " + str3 + " and advertisement " + this.advertisement.getId());
                this.repository.saveAndApplyState(this.advertisement, str3, 3);
                this.repository.updateAndSaveReportState(str3, this.advertisement.getAppID(), 0, 1);
                this.jobRunner.execute(SendReportsJob.makeJobInfo(false));
                onFinished();
                if (this.playAdCallback != null) {
                    PlayAdCallback playAdCallback4 = this.playAdCallback;
                    if (!this.successfulView) {
                        if (this.percentViewed < 80) {
                            z = false;
                            if (str2 != null && str2.equals("isCTAClicked")) {
                                z2 = true;
                            }
                            playAdCallback4.onAdEnd(str3, z, z2);
                            this.playAdCallback.onAdEnd(str3);
                            SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.DID_CLOSE).addData(SessionAttribute.EVENT_ID, this.advertisement.getId()).build());
                            VungleLogger.debug("AdEventListener#PlayAdCallback", "onAdEnd: " + str3);
                        }
                    }
                    z = true;
                    z2 = true;
                    playAdCallback4.onAdEnd(str3, z, z2);
                    this.playAdCallback.onAdEnd(str3);
                    SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.DID_CLOSE).addData(SessionAttribute.EVENT_ID, this.advertisement.getId()).build());
                    VungleLogger.debug("AdEventListener#PlayAdCallback", "onAdEnd: " + str3);
                }
            } else if (str.equals("successfulView") && this.placement.isIncentivized()) {
                this.successfulView = true;
                if (!this.adRewarded) {
                    this.adRewarded = true;
                    if (this.playAdCallback != null) {
                        this.playAdCallback.onAdRewarded(str3);
                        SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.REWARDED).addData(SessionAttribute.EVENT_ID, this.advertisement.getId()).build());
                        VungleLogger.debug("AdEventListener#PlayAdCallback", "onAdRewarded: " + str3);
                    }
                }
            } else if (!"open".equals(str) || this.playAdCallback == null) {
                if ("adViewed".equals(str) && this.playAdCallback != null) {
                    this.playAdCallback.onAdViewed(str3);
                } else if (Constants.ATTACH.equals(str) && this.playAdCallback != null) {
                    this.playAdCallback.creativeId(str2);
                }
            } else if ("adClick".equals(str2)) {
                this.playAdCallback.onAdClick(str3);
                VungleLogger.debug("AdEventListener#PlayAdCallback", "onAdClick: " + str3);
            } else if ("adLeftApplication".equals(str2)) {
                this.playAdCallback.onAdLeftApplication(str3);
                VungleLogger.debug("AdEventListener#PlayAdCallback", "onAdLeftApplication: " + str3);
            }
        } catch (DatabaseHelper.DBException unused) {
            onError(new VungleException(26), str3);
        }
    }

    public void onError(VungleException vungleException, String str) {
        loadAdvertisement();
        if (this.advertisement == null || vungleException.getExceptionCode() != 27) {
            if (!(this.advertisement == null || vungleException.getExceptionCode() == 15 || vungleException.getExceptionCode() == 25 || vungleException.getExceptionCode() == 36)) {
                try {
                    this.repository.saveAndApplyState(this.advertisement, str, 4);
                    loadPlacement();
                    if (this.placement != null) {
                        this.adLoader.loadEndlessIfNeeded(this.placement, this.placement.getAdSize(), 0, false);
                    }
                } catch (DatabaseHelper.DBException unused) {
                    vungleException = new VungleException(26);
                }
            }
            onFinished();
            PlayAdCallback playAdCallback2 = this.playAdCallback;
            if (playAdCallback2 != null) {
                playAdCallback2.onError(str, vungleException);
                VungleLogger.error("AdEventListener#PlayAdCallback", vungleException.getLocalizedMessage() + " :" + str);
                return;
            }
            return;
        }
        this.adLoader.dropCache(this.advertisement.getId());
    }

    /* access modifiers changed from: protected */
    public void onFinished() {
        this.playOperations.remove(this.request.getPlacementId());
    }

    private void loadAdvertisement() {
        if (this.advertisement == null) {
            this.advertisement = this.repository.findValidAdvertisementForPlacement(this.request.getPlacementId(), this.request.getEventId()).get();
        }
    }

    private void loadPlacement() {
        if (this.placement == null) {
            this.placement = this.repository.load(this.request.getPlacementId(), Placement.class).get();
        }
    }
}
