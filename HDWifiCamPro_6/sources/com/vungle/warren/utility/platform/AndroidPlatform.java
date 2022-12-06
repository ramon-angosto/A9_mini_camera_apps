package com.vungle.warren.utility.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.Consumer;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.tasks.OnSuccessListener;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.model.AdvertisingInfo;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.utility.TimeoutProvider;
import com.vungle.warren.utility.VungleThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AndroidPlatform implements Platform {
    /* access modifiers changed from: private */
    public final String TAG = AndroidPlatform.class.getSimpleName();
    private AdvertisingInfo advertisingInfo = null;
    /* access modifiers changed from: private */
    public String appSetId;
    /* access modifiers changed from: private */
    public final Context context;
    private boolean defaultIdFallbackDisabled;
    private final PowerManager powerManager;
    /* access modifiers changed from: private */
    public final Repository repository;
    private final TimeoutProvider timeoutProvider;
    private final VungleThreadPoolExecutor uaExecutor;

    public AndroidPlatform(Context context2, Repository repository2, VungleThreadPoolExecutor vungleThreadPoolExecutor, TimeoutProvider timeoutProvider2) {
        this.context = context2;
        this.powerManager = (PowerManager) context2.getSystemService("power");
        this.repository = repository2;
        this.uaExecutor = vungleThreadPoolExecutor;
        this.timeoutProvider = timeoutProvider2;
        updateAppSetID();
    }

    public boolean isAtLeastMinimumSDK() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public boolean getIsBatterySaverEnabled() {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.powerManager.isPowerSaveMode();
        }
        return false;
    }

    public boolean getIsSideloaded() {
        if (Build.VERSION.SDK_INT < 26) {
            try {
                if (Settings.Secure.getInt(this.context.getContentResolver(), "install_non_market_apps") == 1) {
                    return true;
                }
                return false;
            } catch (Settings.SettingNotFoundException unused) {
                return false;
            }
        } else if (this.context.checkCallingOrSelfPermission("android.permission.REQUEST_INSTALL_PACKAGES") == 0) {
            return this.context.getApplicationContext().getPackageManager().canRequestPackageInstalls();
        } else {
            return false;
        }
    }

    public double getVolumeLevel() {
        AudioManager audioManager = (AudioManager) this.context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        return ((double) audioManager.getStreamVolume(3)) / ((double) audioManager.getStreamMaxVolume(3));
    }

    public boolean getIsSoundEnabled() {
        return ((AudioManager) this.context.getSystemService(MimeTypes.BASE_TYPE_AUDIO)).getStreamVolume(3) > 0;
    }

    public boolean getIsSDCardPresent() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public void getUserAgentLazy(final Consumer<String> consumer) {
        this.uaExecutor.execute(new Runnable() {
            public void run() {
                new WebViewUtil(AndroidPlatform.this.context, AndroidPlatform.this.repository).getUserAgent(consumer);
            }
        });
    }

    public AdvertisingInfo getAdvertisingInfo() {
        AdvertisingInfo advertisingInfo2 = this.advertisingInfo;
        if (advertisingInfo2 != null && !TextUtils.isEmpty(advertisingInfo2.advertisingId)) {
            return this.advertisingInfo;
        }
        this.advertisingInfo = new AdvertisingInfo();
        try {
            if (Platform.MANUFACTURER_AMAZON.equals(Build.MANUFACTURER)) {
                try {
                    ContentResolver contentResolver = this.context.getContentResolver();
                    AdvertisingInfo advertisingInfo3 = this.advertisingInfo;
                    boolean z = true;
                    if (Settings.Secure.getInt(contentResolver, "limit_ad_tracking") != 1) {
                        z = false;
                    }
                    advertisingInfo3.limitAdTracking = z;
                    this.advertisingInfo.advertisingId = Settings.Secure.getString(contentResolver, "advertising_id");
                } catch (Settings.SettingNotFoundException e) {
                    Log.w(this.TAG, "Error getting Amazon advertising info", e);
                }
                return this.advertisingInfo;
            }
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.context);
                if (advertisingIdInfo != null) {
                    this.advertisingInfo.advertisingId = advertisingIdInfo.getId();
                    this.advertisingInfo.limitAdTracking = advertisingIdInfo.isLimitAdTrackingEnabled();
                }
            } catch (NoClassDefFoundError e2) {
                String str = this.TAG;
                Log.e(str, "Play services Not available: " + e2.getLocalizedMessage());
                ContentResolver contentResolver2 = this.context.getContentResolver();
                this.advertisingInfo.advertisingId = Settings.Secure.getString(contentResolver2, "advertising_id");
            } catch (GooglePlayServicesNotAvailableException e3) {
                String str2 = this.TAG;
                Log.e(str2, "Play services Not available: " + e3.getLocalizedMessage());
            }
            return this.advertisingInfo;
        } catch (Exception unused) {
            Log.e(this.TAG, "Cannot load Advertising ID");
        }
    }

    public String getAppSetId() {
        if (TextUtils.isEmpty(this.appSetId)) {
            Cookie cookie = this.repository.load(Cookie.APP_SET_ID_COOKIE, Cookie.class).get(this.timeoutProvider.getTimeout(), TimeUnit.MILLISECONDS);
            this.appSetId = cookie != null ? cookie.getString(Cookie.APP_SET_ID) : null;
        }
        return this.appSetId;
    }

    public String getAndroidId() {
        if (this.defaultIdFallbackDisabled) {
            return "";
        }
        return Settings.Secure.getString(this.context.getContentResolver(), VungleApiClient.ANDROID_ID);
    }

    public void setAndroidIdFallbackDisabled(boolean z) {
        this.defaultIdFallbackDisabled = z;
    }

    public String getUserAgent() {
        Cookie cookie = this.repository.load(Cookie.USER_AGENT_ID_COOKIE, Cookie.class).get();
        if (cookie == null) {
            return System.getProperty("http.agent");
        }
        String string = cookie.getString(Cookie.USER_AGENT_ID_COOKIE);
        return TextUtils.isEmpty(string) ? System.getProperty("http.agent") : string;
    }

    private void updateAppSetID() {
        try {
            AppSet.getClient(this.context).getAppSetIdInfo().addOnSuccessListener(new OnSuccessListener<AppSetIdInfo>() {
                public void onSuccess(AppSetIdInfo appSetIdInfo) {
                    if (appSetIdInfo != null) {
                        String unused = AndroidPlatform.this.appSetId = appSetIdInfo.getId();
                        if (!TextUtils.isEmpty(AndroidPlatform.this.appSetId)) {
                            Cookie cookie = new Cookie(Cookie.APP_SET_ID_COOKIE);
                            cookie.putValue(Cookie.APP_SET_ID, AndroidPlatform.this.appSetId);
                            try {
                                AndroidPlatform.this.repository.save(cookie);
                            } catch (DatabaseHelper.DBException e) {
                                String access$300 = AndroidPlatform.this.TAG;
                                Log.e(access$300, "error saving AppSetId in Cookie: " + e.getLocalizedMessage());
                            }
                        }
                    }
                }
            });
        } catch (NoClassDefFoundError e) {
            String str = this.TAG;
            Log.e(str, "Required libs to get AppSetID Not available: " + e.getLocalizedMessage());
        }
    }
}
