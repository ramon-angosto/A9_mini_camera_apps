package com.unad.sdk;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.api.init.PAGConfig;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.ironsource.mediationsdk.IronSource;
import com.mbridge.msdk.out.MBridgeSDKFactory;
import com.unad.sdk.dto.AdError;
import com.unad.sdk.tool.AdInfoListener;
import sg.bigo.ads.BigoAdSdk;
import sg.bigo.ads.ConsentOptions;
import sg.bigo.ads.api.AdConfig;

public class UNAD {
    protected static final String ADGOTAG = "UNAD_SDK";
    protected static String APPID = "";
    protected static final String BIGO = "bigo";
    protected static boolean BIGO_INIT_BOOLEAN = false;
    protected static final String BIGO_IS = "bigo_is";
    /* access modifiers changed from: private */
    public static int CCPA = 1;
    /* access modifiers changed from: private */
    public static int GDPR = 1;
    protected static final String GOOGLE = "google";
    protected static final String IRONSOURCE = "ironsource";
    /* access modifiers changed from: private */
    public static boolean ISINITSUCCESS = false;
    public static boolean ISOPENTAG = true;
    protected static boolean MINTEFRAL_INIT_BOOLEAN = false;
    protected static final String MINTEGRAL = "mintegral";
    protected static boolean MOPUB_INIT_BOOLEAN = false;
    protected static final String PANGLE = "pangle";
    protected static boolean PANGLE_INIT_BOOLEAN = false;
    protected static final String UNAD_BIGO = "unad_bigo";
    protected static final String UNAD_PANGLE = "unad_pangle";
    public static final String VERSION = "2.5.9";
    private static int appLogo = 0;
    private static int coppa = 0;
    protected static boolean isOpenLogsBoolean = false;
    /* access modifiers changed from: private */
    public static final Handler mHandler = new Handler();
    protected static String serviceId;
    /* access modifiers changed from: private */
    public static boolean unadconfigurationError = false;

    public interface InitCallback {
        void onError(AdError adError);

        void onSuccess();
    }

    static class a extends AdInfoListener {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ InitCallback c;

        /* renamed from: com.unad.sdk.UNAD$a$a  reason: collision with other inner class name */
        class C0106a implements Runnable {
            C0106a() {
            }

            public void run() {
                AdInfo adInfo = a.b;
                if (adInfo != null && adInfo.getMintegral() != null && a.b.getMintegral().length() > 0 && a.b.getMintegral().contains("#")) {
                    String str = a.b.getMintegral().split("#")[0];
                    String str2 = a.b.getMintegral().split("#")[1];
                    com.mbridge.msdk.system.a mBridgeSDK = MBridgeSDKFactory.getMBridgeSDK();
                    mBridgeSDK.init(mBridgeSDK.getMBConfigurationMap(str, str2), a.this.a);
                    UNAD.MINTEFRAL_INIT_BOOLEAN = true;
                    boolean unused = UNAD.ISINITSUCCESS = true;
                }
            }
        }

        class b implements OnInitializationCompleteListener {
            b() {
            }

            public void onInitializationComplete(InitializationStatus initializationStatus) {
                InitCallback initCallback = a.this.c;
                if (initCallback != null) {
                    initCallback.onSuccess();
                }
                boolean unused = UNAD.ISINITSUCCESS = true;
            }
        }

        class c implements TTAdSdk.InitCallback {
            c(a aVar) {
            }

            public void fail(int i, String str) {
            }

            public void success() {
                boolean unused = UNAD.ISINITSUCCESS = true;
                UNAD.PANGLE_INIT_BOOLEAN = true;
            }
        }

        class d implements BigoAdSdk.InitListener {
            d(a aVar) {
            }

            public void onInitialized() {
                boolean unused = UNAD.ISINITSUCCESS = true;
                UNAD.BIGO_INIT_BOOLEAN = true;
            }
        }

        a(Context context, String str, InitCallback initCallback) {
            this.a = context;
            this.b = str;
            this.c = initCallback;
        }

        public void error(String str, String str2) {
            if ("99999".equals(str)) {
                str2 = str2 + ",init configuration error";
            }
            InitCallback initCallback = this.c;
            if (initCallback != null) {
                initCallback.onError(new AdError(str, str2));
            }
            boolean unused = UNAD.ISINITSUCCESS = false;
            boolean unused2 = UNAD.unadconfigurationError = true;
        }

        public void onAdLoadOk() {
            AdInfo adInfo = a.b;
            if (adInfo != null) {
                UNAD.isOpenLogsBoolean = adInfo.isOpenLogs();
                b.a().a(this.a, this.b);
            }
            UNAD.mHandler.post(new C0106a());
            MobileAds.initialize(this.a, new b());
            AdInfo adInfo2 = a.b;
            if (!(adInfo2 == null || adInfo2.getPangle() == null)) {
                Context context = this.a;
                PAGSdk.init(context, UNAD.buildConfig(context, a.b.getPangle()), new c(this));
            }
            AdInfo adInfo3 = a.b;
            if (adInfo3 != null && adInfo3.getBigo() != null) {
                BigoAdSdk.setUserConsent(this.a, ConsentOptions.GDPR, UNAD.GDPR == 1);
                if (UNAD.CCPA == -1 || UNAD.CCPA == 1) {
                    BigoAdSdk.setUserConsent(this.a, ConsentOptions.CCPA, true);
                } else {
                    BigoAdSdk.setUserConsent(this.a, ConsentOptions.CCPA, false);
                }
                BigoAdSdk.initialize(this.a, new AdConfig.Builder().setAppId(a.b.getBigo()).setDebug(false).build(), new d(this));
            }
        }
    }

    /* access modifiers changed from: private */
    public static PAGConfig buildConfig(Context context, String str) {
        return new PAGConfig.Builder().appId(str).useTextureView(true).setGDPRConsent(GDPR).setDoNotSell(CCPA).debugLog(false).supportMultiProcess(false).setChildDirected(coppa).appIcon(appLogo).build();
    }

    public static void initialize(String str, Context context, InitCallback initCallback, int i, int i2, int i3, int i4) {
        GDPR = i;
        CCPA = i2;
        coppa = i3;
        appLogo = i4;
        APPID = str;
        initialize(str, context, initCallback);
    }

    public static boolean isConError() {
        return unadconfigurationError;
    }

    public static boolean isInitSuccess() {
        return ISINITSUCCESS;
    }

    public static void initialize(String str, Context context, InitCallback initCallback, int i) {
        appLogo = i;
        APPID = str;
        initialize(str, context, initCallback);
    }

    public static void initialize(String str, Context context, InitCallback initCallback) {
        Log.i(ADGOTAG, "version:2.5.9T:1108");
        try {
            a.a();
            a.a(str, context, new a(context, str, initCallback));
            IronSource.setConsent(GDPR == 1);
            int i = CCPA;
            if (i == -1 || i == 1) {
                IronSource.setMetaData("do_not_sell", "false");
            } else {
                IronSource.setMetaData("do_not_sell", "true");
            }
            int i2 = coppa;
            if (i2 == -1 || i2 == 0) {
                IronSource.setMetaData("is_child_directed", "false");
            } else {
                IronSource.setMetaData("is_child_directed", "true");
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (initCallback != null) {
                initCallback.onError(new AdError("-1", "init sdk error,unad"));
            }
            ISINITSUCCESS = false;
            unadconfigurationError = true;
        }
    }
}
