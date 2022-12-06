package com.jirbo.adcolony;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAdOptions;
import com.adcolony.sdk.AdColonyAppOptions;
import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import com.google.ads.mediation.adcolony.AdColonyMediationAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdConfiguration;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class AdColonyManager {
    private static AdColonyManager instance;
    private final ArrayList<String> configuredZones = new ArrayList<>();
    private boolean isConfigured = false;

    public interface InitializationListener {
        void onInitializeFailed(AdError adError);

        void onInitializeSuccess();
    }

    public static AdColonyManager getInstance() {
        if (instance == null) {
            instance = new AdColonyManager();
        }
        return instance;
    }

    public void configureAdColony(Context context, AdColonyAppOptions adColonyAppOptions, String str, ArrayList<String> arrayList, InitializationListener initializationListener) {
        boolean z;
        boolean z2 = context instanceof Activity;
        if (!z2 && !(context instanceof Application)) {
            initializationListener.onInitializeFailed(AdColonyMediationAdapter.createAdapterError(106, "AdColony SDK requires an Activity context to initialize"));
        } else if (TextUtils.isEmpty(str)) {
            initializationListener.onInitializeFailed(AdColonyMediationAdapter.createAdapterError(101, "Missing or invalid AdColony app ID."));
        } else if (arrayList.isEmpty()) {
            initializationListener.onInitializeFailed(AdColonyMediationAdapter.createAdapterError(101, "No zones provided to initialize the AdColony SDK."));
        } else {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!this.configuredZones.contains(next)) {
                    this.configuredZones.add(next);
                    this.isConfigured = false;
                }
            }
            if (this.isConfigured) {
                AdColony.setAppOptions(adColonyAppOptions);
            } else {
                String[] strArr = (String[]) this.configuredZones.toArray(new String[0]);
                adColonyAppOptions.setMediationNetwork(AdColonyAppOptions.ADMOB, BuildConfig.ADAPTER_VERSION);
                if (z2) {
                    z = AdColony.configure((Activity) context, adColonyAppOptions, str, strArr);
                } else {
                    z = AdColony.configure((Application) context, adColonyAppOptions, str, strArr);
                }
                this.isConfigured = z;
            }
            if (!this.isConfigured) {
                initializationListener.onInitializeFailed(AdColonyMediationAdapter.createAdapterError(103, "AdColony SDK failed to initialize."));
            } else {
                initializationListener.onInitializeSuccess();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void configureAdColony(Context context, Bundle bundle, MediationAdRequest mediationAdRequest, InitializationListener initializationListener) {
        Context context2 = context;
        configureAdColony(context2, buildAppOptions(mediationAdRequest), bundle.getString("app_id"), parseZoneList(bundle), initializationListener);
    }

    public void configureAdColony(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, InitializationListener initializationListener) {
        Context context = mediationRewardedAdConfiguration.getContext();
        Bundle serverParameters = mediationRewardedAdConfiguration.getServerParameters();
        String string = serverParameters.getString("app_id");
        ArrayList<String> parseZoneList = parseZoneList(serverParameters);
        configureAdColony(context, buildAppOptions(mediationRewardedAdConfiguration), string, parseZoneList, initializationListener);
    }

    private AdColonyAppOptions buildAppOptions(MediationAdRequest mediationAdRequest) {
        AdColonyAppOptions appOptions = AdColonyMediationAdapter.getAppOptions();
        if (mediationAdRequest.isTesting()) {
            appOptions.setTestModeEnabled(true);
        }
        return appOptions;
    }

    private AdColonyAppOptions buildAppOptions(MediationRewardedAdConfiguration mediationRewardedAdConfiguration) {
        AdColonyAppOptions appOptions = AdColonyMediationAdapter.getAppOptions();
        if (mediationRewardedAdConfiguration.isTestRequest()) {
            appOptions.setTestModeEnabled(true);
        }
        return appOptions;
    }

    public ArrayList<String> parseZoneList(Bundle bundle) {
        String str;
        if (bundle != null) {
            if (bundle.getString(AdColonyAdapterUtils.KEY_ZONE_IDS) != null) {
                str = bundle.getString(AdColonyAdapterUtils.KEY_ZONE_IDS);
            } else {
                str = bundle.getString(AdColonyAdapterUtils.KEY_ZONE_ID);
            }
            if (str != null) {
                return new ArrayList<>(Arrays.asList(str.split(";")));
            }
        }
        return null;
    }

    public String getZoneFromRequest(ArrayList<String> arrayList, Bundle bundle) {
        String str = (arrayList == null || arrayList.isEmpty()) ? null : arrayList.get(0);
        return (bundle == null || bundle.getString(AdColonyAdapterUtils.KEY_ZONE_ID) == null) ? str : bundle.getString(AdColonyAdapterUtils.KEY_ZONE_ID);
    }

    public AdColonyAdOptions getAdOptionsFromExtras(Bundle bundle) {
        boolean z;
        boolean z2 = false;
        if (bundle != null) {
            boolean z3 = bundle.getBoolean("show_pre_popup", false);
            z = bundle.getBoolean("show_post_popup", false);
            z2 = z3;
        } else {
            z = false;
        }
        return new AdColonyAdOptions().enableConfirmationDialog(z2).enableResultsDialog(z);
    }

    public AdColonyAdOptions getAdOptionsFromAdConfig(MediationAdConfiguration mediationAdConfiguration) {
        AdColonyAdOptions adOptionsFromExtras = getAdOptionsFromExtras(mediationAdConfiguration.getMediationExtras());
        String bidResponse = mediationAdConfiguration.getBidResponse();
        if (!bidResponse.isEmpty()) {
            adOptionsFromExtras.setOption(AdColonyAdapterUtils.KEY_ADCOLONY_BID_RESPONSE, bidResponse);
        }
        return adOptionsFromExtras;
    }
}
