package com.unad.sdk;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.RequestManager;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGImageItem;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenRequest;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerListener;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.out.MBSplashHandler;
import com.mbridge.msdk.out.MBSplashLoadListener;
import com.mbridge.msdk.out.MBSplashShowListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.unad.sdk.FBSplashView;
import com.unad.sdk.dto.AdError;
import com.unad.sdk.dto.AdList;
import com.unad.sdk.dto.SourceVO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import sg.bigo.ads.api.AdIconView;
import sg.bigo.ads.api.AdInteractionListener;
import sg.bigo.ads.api.AdLoadListener;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.InterstitialAd;
import sg.bigo.ads.api.InterstitialAdLoader;
import sg.bigo.ads.api.InterstitialAdRequest;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.api.NativeAdView;
import sg.bigo.ads.api.SplashAd;
import sg.bigo.ads.api.SplashAdInteractionListener;
import sg.bigo.ads.api.SplashAdLoader;
import sg.bigo.ads.api.SplashAdRequest;

public class UNADSplash implements LifecycleObserver, Application.ActivityLifecycleCallbacks {
    /* access modifiers changed from: private */
    public static boolean isShowingAd = false;
    private static boolean isregisterActivityLifecycleCallbacks = false;
    /* access modifiers changed from: private */
    public static long loadTime = 0;
    /* access modifiers changed from: private */
    public static int pangleType = 1;
    private HashMap<String, String> activitysMap = new HashMap<>();
    /* access modifiers changed from: private */
    public ArrayList<SourceVO> adList = new ArrayList<>();
    /* access modifiers changed from: private */
    public int adShowType = 0;
    /* access modifiers changed from: private */
    public String adUnitId = "";
    /* access modifiers changed from: private */
    public AdList adVO;
    /* access modifiers changed from: private */
    public AdViewListener adViewListener;
    /* access modifiers changed from: private */
    public AppOpenAd appOpenAd = null;
    private String appname = "";
    private int backgroundPicture = 0;
    /* access modifiers changed from: private */
    public IronSourceBannerLayout banner;
    private final Runnable bigoIsRunnable = new v();
    /* access modifiers changed from: private */
    public int bigoIsTime = 0;
    /* access modifiers changed from: private */
    public Handler bigoIshandler = new Handler();
    /* access modifiers changed from: private */
    public int bigoType = 1;
    /* access modifiers changed from: private */
    public int countTime = 0;
    /* access modifiers changed from: private */
    public Activity currentActivity;
    /* access modifiers changed from: private */
    public AlertDialog dialog;
    private int durationTime = 3;
    /* access modifiers changed from: private */
    public int errorCount = 0;
    private String errorLogs;
    /* access modifiers changed from: private */
    public String errortypeTag = "";
    /* access modifiers changed from: private */
    public long googleloadTime = 0;
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    /* access modifiers changed from: private */
    public InterstitialAd interstitiaBigolAd;
    /* access modifiers changed from: private */
    public boolean isLoadingAd = false;
    /* access modifiers changed from: private */
    public boolean isReturnErrorCallbackBoolean = false;
    /* access modifiers changed from: private */
    public boolean isRun = false;
    private boolean isSdkLoad;
    private boolean isShowAd = false;
    /* access modifiers changed from: private */
    public boolean isTimeOut;
    /* access modifiers changed from: private */
    public boolean isUpdateLogBoolean = true;
    private String loadAd;
    private AppOpenAd.AppOpenAdLoadCallback loadCallback;
    private int logoPicture = 0;
    /* access modifiers changed from: private */
    public NativeAd mNativeAd;
    private RequestManager mRequestManager;
    /* access modifiers changed from: private */
    public SplashAd mSplashAd;
    /* access modifiers changed from: private */
    public MBSplashHandler mbSplashHandler;
    /* access modifiers changed from: private */
    public Handler mintegralhandler = new Handler();
    private Application myApplication;
    /* access modifiers changed from: private */
    public AlertDialog pangleDialog;
    /* access modifiers changed from: private */
    public final Runnable pangleRunnable = new i();
    /* access modifiers changed from: private */
    public int pangleTime = 0;
    /* access modifiers changed from: private */
    public Handler panglehandler = new Handler();
    private final Runnable progressbarRunnable = new w();
    /* access modifiers changed from: private */
    public Runnable runnable = new k();
    private int second = 0;
    private int skipType = 1;
    private final int skipTypeButton = 1;
    private final int skipTypeTimer = 2;
    private SourceVO sourceVO;
    /* access modifiers changed from: private */
    public final Runnable timeOutRunnable = new q();
    /* access modifiers changed from: private */
    public Handler timeOuthandler = new Handler();
    /* access modifiers changed from: private */
    public int timeoutTime = 3;
    /* access modifiers changed from: private */
    public final Runnable unadBigoRunnable = new t();
    /* access modifiers changed from: private */
    public Handler unadBigohandler = new Handler();
    /* access modifiers changed from: private */
    public ProgressBar unad_progressBar;
    /* access modifiers changed from: private */
    public ImageView unad_splash_close;
    /* access modifiers changed from: private */
    public int unadbigoTime = 0;

    public interface AdViewListener {
        void onAdClicked();

        void onAdClose();

        void onAdFailed(AdError adError);

        void onAdLoaded();

        void onAdOpen();
    }

    public enum SKIPTYPE {
        CLICK,
        TIMING
    }

    class a implements SplashAdInteractionListener {
        a() {
        }

        public void onAdClicked() {
            if (UNADSplash.this.adViewListener != null) {
                UNADSplash.this.adViewListener.onAdClicked();
            }
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().a((Context) UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "bigo", (String) null, "1");
            }
        }

        public void onAdClosed() {
            if (UNADSplash.this.pangleDialog != null) {
                UNADSplash.this.pangleDialog.dismiss();
            }
            if (UNADSplash.this.dialog != null) {
                UNADSplash.this.dialog.dismiss();
            }
            if (UNADSplash.this.adViewListener != null) {
                UNADSplash.this.adViewListener.onAdClose();
            }
            if (UNADSplash.this.mSplashAd != null) {
                UNADSplash.this.mSplashAd.destroy();
            }
            int unused = UNADSplash.this.adShowType = 0;
        }

        public void onAdError(sg.bigo.ads.api.AdError adError) {
            if (UNADSplash.this.pangleDialog != null) {
                UNADSplash.this.pangleDialog.dismiss();
            }
            if (UNADSplash.this.dialog != null) {
                UNADSplash.this.dialog.dismiss();
            }
            int unused = UNADSplash.this.adShowType = 0;
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().b(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "bigo#" + adError.getMessage() + "," + adError.getCode(), "1", "bigo");
            }
            boolean unused2 = UNADSplash.this.isLoadingAd = false;
            if (UNADSplash.this.errorCount >= 2 || UNADSplash.this.adList.size() == 0) {
                UNADSplash.this.returnError("bigo", adError.getCode() + "", adError.getMessage() + "");
                return;
            }
            UNADSplash.this.reLoadAD();
            int unused3 = UNADSplash.this.adShowType = 0;
        }

        public void onAdFinished() {
            if (UNADSplash.this.pangleDialog != null) {
                UNADSplash.this.pangleDialog.dismiss();
            }
            if (UNADSplash.this.dialog != null) {
                UNADSplash.this.dialog.dismiss();
            }
            if (UNADSplash.this.adViewListener != null) {
                UNADSplash.this.adViewListener.onAdClose();
            }
            if (UNADSplash.this.mSplashAd != null) {
                UNADSplash.this.mSplashAd.destroy();
            }
            int unused = UNADSplash.this.adShowType = 0;
        }

        public void onAdImpression() {
            if (UNADSplash.this.adViewListener != null) {
                UNADSplash.this.adViewListener.onAdOpen();
            }
            boolean unused = UNADSplash.isShowingAd = true;
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().e(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "bigo", (String) null, "1");
            }
        }

        public void onAdOpened() {
        }

        public void onAdSkipped() {
            if (UNADSplash.this.pangleDialog != null) {
                UNADSplash.this.pangleDialog.dismiss();
            }
            if (UNADSplash.this.dialog != null) {
                UNADSplash.this.dialog.dismiss();
            }
            if (UNADSplash.this.adViewListener != null) {
                UNADSplash.this.adViewListener.onAdClose();
            }
            int unused = UNADSplash.this.adShowType = 0;
            if (UNADSplash.this.mSplashAd != null) {
                UNADSplash.this.mSplashAd.destroy();
            }
        }
    }

    class b implements View.OnClickListener {
        final /* synthetic */ FrameLayout a;

        b(FrameLayout frameLayout) {
            this.a = frameLayout;
        }

        public void onClick(View view) {
            if (UNADSplash.this.unad_splash_close.getVisibility() == 0) {
                if (UNADSplash.this.pangleDialog != null) {
                    UNADSplash.this.pangleDialog.dismiss();
                }
                if (UNADSplash.this.dialog != null) {
                    UNADSplash.this.dialog.dismiss();
                }
                if (UNADSplash.this.adViewListener != null) {
                    UNADSplash.this.adViewListener.onAdClose();
                }
                this.a.removeAllViews();
                if (UNADSplash.this.mNativeAd != null) {
                    UNADSplash.this.mNativeAd.destroy();
                }
                int unused = UNADSplash.this.adShowType = 0;
            }
        }
    }

    class c implements AdLoadListener<NativeAd> {
        final /* synthetic */ FrameLayout a;

        c(FrameLayout frameLayout) {
            this.a = frameLayout;
        }

        /* renamed from: a */
        public void onAdLoaded(NativeAd nativeAd) {
            if (nativeAd == null) {
                if (UNADSplash.this.isUpdateLogBoolean) {
                    b.a().b(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "unad_bigo# ads list is null", "1", "unad_bigo");
                }
                boolean unused = UNADSplash.this.isLoadingAd = false;
                if (UNADSplash.this.errorCount >= 2 || UNADSplash.this.adList.size() == 0) {
                    UNADSplash.this.returnError("unad_pangle", "-1", "ads list is null");
                    return;
                }
                UNADSplash.this.reLoadAD();
                int unused2 = UNADSplash.this.adShowType = 0;
                return;
            }
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().c(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "unad_bigo", (String) null, "1");
            }
            if (!UNADSplash.this.isTimeOut) {
                if (UNADSplash.this.adViewListener != null) {
                    UNADSplash.this.adViewListener.onAdLoaded();
                }
                long unused3 = UNADSplash.this.googleloadTime = new Date().getTime();
                boolean unused4 = UNADSplash.this.isReturnErrorCallbackBoolean = true;
                UNADSplash uNADSplash = UNADSplash.this;
                if (uNADSplash.isAppOnForeground(uNADSplash.currentActivity)) {
                    NativeAd unused5 = UNADSplash.this.mNativeAd = nativeAd;
                    UNADSplash uNADSplash2 = UNADSplash.this;
                    uNADSplash2.setUnadBigoListener(uNADSplash2.mNativeAd);
                    UNADSplash.this.showPangleDialog();
                    UNADSplash uNADSplash3 = UNADSplash.this;
                    uNADSplash3.handleNativeAd(nativeAd, LayoutInflater.from(uNADSplash3.currentActivity), this.a);
                    return;
                }
                UNADSplash.this.returnError("unadsdk", "-1", "Ad This display failed");
            } else if (UNAD.ISOPENTAG) {
                Log.i("UNAD_SDK", "time out..5.");
            }
        }

        public void onError(sg.bigo.ads.api.AdError adError) {
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().b(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "unad_bigo#" + adError.getMessage() + "," + adError.getCode(), "1", "unad_bigo");
            }
            boolean unused = UNADSplash.this.isLoadingAd = false;
            if (UNADSplash.this.errorCount >= 2 || UNADSplash.this.adList.size() == 0) {
                UNADSplash.this.returnError("unad_pangle", adError.getCode() + "", adError.getMessage() + "");
                return;
            }
            UNADSplash.this.reLoadAD();
            int unused2 = UNADSplash.this.adShowType = 0;
        }
    }

    class d implements AdInteractionListener {
        d() {
        }

        public void onAdClicked() {
            if (UNADSplash.this.adViewListener != null) {
                UNADSplash.this.adViewListener.onAdClicked();
            }
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().a((Context) UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "unad_bigo", (String) null, "1");
            }
        }

        public void onAdClosed() {
            if (UNADSplash.this.pangleDialog != null) {
                UNADSplash.this.pangleDialog.dismiss();
            }
            if (UNADSplash.this.dialog != null) {
                UNADSplash.this.dialog.dismiss();
            }
            if (UNADSplash.this.adViewListener != null) {
                UNADSplash.this.adViewListener.onAdClose();
            }
            int unused = UNADSplash.this.adShowType = 0;
        }

        public void onAdError(sg.bigo.ads.api.AdError adError) {
            if (UNADSplash.this.pangleDialog != null) {
                UNADSplash.this.pangleDialog.dismiss();
            }
            if (UNADSplash.this.dialog != null) {
                UNADSplash.this.dialog.dismiss();
            }
            int unused = UNADSplash.this.adShowType = 0;
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().b(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "unad_bigo#" + adError.getMessage() + "," + adError.getCode(), "1", "unad_bigo");
            }
            boolean unused2 = UNADSplash.this.isLoadingAd = false;
            if (UNADSplash.this.errorCount >= 2 || UNADSplash.this.adList.size() == 0) {
                UNADSplash.this.returnError("unad_pangle", adError.getCode() + "", adError.getMessage() + "");
                return;
            }
            UNADSplash.this.reLoadAD();
            int unused3 = UNADSplash.this.adShowType = 0;
        }

        public void onAdImpression() {
            if (UNADSplash.this.adViewListener != null) {
                UNADSplash.this.adViewListener.onAdOpen();
            }
            boolean unused = UNADSplash.isShowingAd = true;
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().e(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "unad_bigo", (String) null, "1");
            }
        }

        public void onAdOpened() {
            if (UNADSplash.this.adViewListener != null) {
                UNADSplash.this.adViewListener.onAdOpen();
            }
            boolean unused = UNADSplash.isShowingAd = true;
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().e(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "unad_bigo", (String) null, "1");
            }
        }
    }

    class e implements PAGAppOpenAdLoadListener {
        e() {
        }

        /* renamed from: a */
        public void onAdLoaded(PAGAppOpenAd pAGAppOpenAd) {
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().c(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "pangle", (String) null, "1");
            }
            if (!UNADSplash.this.isTimeOut) {
                if (UNADSplash.this.adViewListener != null) {
                    UNADSplash.this.adViewListener.onAdLoaded();
                }
                long unused = UNADSplash.this.googleloadTime = new Date().getTime();
                boolean unused2 = UNADSplash.this.isReturnErrorCallbackBoolean = true;
                int unused3 = UNADSplash.this.adShowType = 0;
                UNADSplash.this.showPangLeAdIfAvailable(pAGAppOpenAd);
            } else if (UNAD.ISOPENTAG) {
                Log.i("UNAD_SDK", "time out...pang");
            }
        }

        public void onError(int i, String str) {
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().b(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "pangle#" + str, "1", "pangle");
            }
            boolean unused = UNADSplash.this.isLoadingAd = false;
            if (UNADSplash.this.errorCount >= 2 || UNADSplash.this.adList.size() == 0) {
                UNADSplash.this.returnError("pangle", i + "", str + "");
                return;
            }
            UNADSplash.this.reLoadAD();
            int unused2 = UNADSplash.this.adShowType = 0;
        }
    }

    class f implements PAGAppOpenAdInteractionListener {
        f() {
        }

        private void a() {
            boolean unused = UNADSplash.isShowingAd = false;
            if (UNADSplash.this.adViewListener != null) {
                UNADSplash.this.adViewListener.onAdClose();
            }
            long unused2 = UNADSplash.loadTime = new Date().getTime();
        }

        public void onAdClicked() {
            if (UNADSplash.this.adViewListener != null) {
                UNADSplash.this.adViewListener.onAdClicked();
            }
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().a((Context) UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "pangle", (String) null, "1");
            }
        }

        public void onAdDismissed() {
            a();
        }

        public void onAdShowed() {
            long unused = UNADSplash.loadTime = new Date().getTime();
            if (UNADSplash.this.adViewListener != null) {
                UNADSplash.this.adViewListener.onAdOpen();
            }
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().e(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "pangle", (String) null, "1");
            }
        }
    }

    class g implements View.OnClickListener {
        final /* synthetic */ FrameLayout a;

        g(FrameLayout frameLayout) {
            this.a = frameLayout;
        }

        public void onClick(View view) {
            if (UNADSplash.this.unad_splash_close.getVisibility() == 0) {
                if (UNADSplash.this.pangleDialog != null) {
                    UNADSplash.this.pangleDialog.dismiss();
                }
                if (UNADSplash.this.dialog != null) {
                    UNADSplash.this.dialog.dismiss();
                }
                this.a.removeAllViews();
                if (UNADSplash.this.adViewListener != null) {
                    UNADSplash.this.adViewListener.onAdClose();
                }
                int unused = UNADSplash.this.adShowType = 0;
            }
        }
    }

    class h implements PAGNativeAdLoadListener {
        final /* synthetic */ FrameLayout a;

        h(FrameLayout frameLayout) {
            this.a = frameLayout;
        }

        /* renamed from: a */
        public void onAdLoaded(PAGNativeAd pAGNativeAd) {
            PAGMediaView mediaView;
            if (pAGNativeAd == null || pAGNativeAd.getNativeAdData() == null) {
                if (UNADSplash.this.isUpdateLogBoolean) {
                    b.a().b(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "unad_pangle# ads list is null", "1", "unad_pangle");
                }
                boolean unused = UNADSplash.this.isLoadingAd = false;
                if (UNADSplash.this.errorCount >= 2 || UNADSplash.this.adList.size() == 0) {
                    UNADSplash.this.returnError("unad_pangle", "-1", "ads list is null");
                    return;
                }
                UNADSplash.this.reLoadAD();
                int unused2 = UNADSplash.this.adShowType = 0;
                return;
            }
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().c(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "unad_pangle", (String) null, "1");
            }
            if (!UNADSplash.this.isTimeOut) {
                UNADSplash uNADSplash = UNADSplash.this;
                if (!uNADSplash.isAppOnForeground(uNADSplash.currentActivity)) {
                    UNADSplash.this.returnError("unadsdk", "-1", "pangle Ad This display failed");
                }
                if (UNADSplash.this.adViewListener != null) {
                    UNADSplash.this.adViewListener.onAdLoaded();
                }
                long unused3 = UNADSplash.this.googleloadTime = new Date().getTime();
                boolean unused4 = UNADSplash.this.isReturnErrorCallbackBoolean = true;
                z zVar = new z(LayoutInflater.from(UNADSplash.this.currentActivity).inflate(R.layout.unad_new_api_listitem_pangle_feed_ad_view, (ViewGroup) null));
                PAGNativeAdData nativeAdData = pAGNativeAd.getNativeAdData();
                ArrayList arrayList = new ArrayList();
                arrayList.add(zVar.g);
                UNADSplash.this.bindData(zVar, arrayList, pAGNativeAd, nativeAdData);
                if (!(zVar.g == null || (mediaView = nativeAdData.getMediaView()) == null || mediaView.getParent() != null)) {
                    zVar.g.removeAllViews();
                    zVar.g.addView(mediaView);
                }
                this.a.addView(zVar.itemView);
                UNADSplash.this.showPangleDialog();
            } else if (UNAD.ISOPENTAG) {
                Log.i("UNAD_SDK", "time out..9.");
            }
        }

        public void onError(int i, String str) {
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().b(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "unad_pangle#" + str, "1", "unad_pangle");
            }
            boolean unused = UNADSplash.this.isLoadingAd = false;
            if (UNADSplash.this.errorCount >= 2 || UNADSplash.this.adList.size() == 0) {
                UNADSplash.this.returnError("unad_pangle", i + "", str + "");
                return;
            }
            UNADSplash.this.reLoadAD();
            int unused2 = UNADSplash.this.adShowType = 0;
        }
    }

    class i implements Runnable {
        i() {
        }

        public void run() {
            if (UNAD.PANGLE_INIT_BOOLEAN) {
                if (UNADSplash.pangleType == 1) {
                    UNADSplash.this.loadUnadPangAd();
                } else {
                    UNADSplash.this.loadPangAd();
                }
                if (UNADSplash.this.panglehandler != null && UNADSplash.this.pangleRunnable != null) {
                    UNADSplash.this.panglehandler.removeCallbacks(UNADSplash.this.pangleRunnable);
                    return;
                }
                return;
            }
            if (UNADSplash.this.pangleTime < UNADSplash.this.timeoutTime) {
                UNADSplash.this.panglehandler.postDelayed(this, 1000);
            } else if (!(UNADSplash.this.panglehandler == null || UNADSplash.this.pangleRunnable == null)) {
                UNADSplash.this.panglehandler.removeCallbacks(UNADSplash.this.pangleRunnable);
            }
            UNADSplash.access$5108(UNADSplash.this);
        }
    }

    class j implements PAGNativeAdInteractionListener {
        j() {
        }

        public void onAdClicked() {
            if (UNADSplash.this.adViewListener != null) {
                UNADSplash.this.adViewListener.onAdClicked();
            }
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().a((Context) UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "unad_pangle", (String) null, "1");
            }
        }

        public void onAdDismissed() {
        }

        public void onAdShowed() {
            if (UNADSplash.this.adViewListener != null) {
                UNADSplash.this.adViewListener.onAdOpen();
            }
            boolean unused = UNADSplash.isShowingAd = true;
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().e(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "unad_pangle", (String) null, "1");
            }
        }
    }

    class k implements Runnable {
        k() {
        }

        public void run() {
            if (UNAD.isConError()) {
                UNADSplash.this.returnError("unadsdk", "-1", "init sdk error");
                UNADSplash.this.handler.removeCallbacks(UNADSplash.this.runnable);
            } else if (!UNADSplash.this.isRun || !UNAD.isInitSuccess()) {
                UNADSplash.this.handler.postDelayed(this, 50);
            } else {
                UNADSplash.this.startInitAd();
                UNADSplash.this.loadAdGoAd();
                UNADSplash.this.handler.removeCallbacks(UNADSplash.this.runnable);
            }
        }
    }

    class l extends AppOpenAd.AppOpenAdLoadCallback {
        final /* synthetic */ boolean a;

        l(boolean z) {
            this.a = z;
        }

        /* renamed from: a */
        public void onAdLoaded(AppOpenAd appOpenAd) {
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().c(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "google", (String) null, "1");
            }
            if (!UNADSplash.this.isTimeOut) {
                AppOpenAd unused = UNADSplash.this.appOpenAd = appOpenAd;
                long unused2 = UNADSplash.this.googleloadTime = new Date().getTime();
                boolean unused3 = UNADSplash.this.isLoadingAd = true;
                if (this.a && UNADSplash.this.adViewListener != null) {
                    UNADSplash.this.adViewListener.onAdLoaded();
                }
                if (this.a) {
                    int unused4 = UNADSplash.this.adShowType = 1;
                    UNADSplash uNADSplash = UNADSplash.this;
                    if (uNADSplash.isAppOnForeground(uNADSplash.currentActivity)) {
                        boolean unused5 = UNADSplash.this.isReturnErrorCallbackBoolean = true;
                        int unused6 = UNADSplash.this.adShowType = 0;
                        UNADSplash.this.showGoogleDialog();
                        if (UNADSplash.this.timeOuthandler != null) {
                            UNADSplash.this.timeOuthandler.removeCallbacks(UNADSplash.this.timeOutRunnable);
                            return;
                        }
                        return;
                    }
                    UNADSplash.this.returnError("unadsdk", "-1", "Ad This display failed");
                }
            } else if (UNAD.ISOPENTAG) {
                Log.i("UNAD_SDK", "time out...");
            }
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().b(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "google#" + loadAdError.getMessage(), "1", "google");
            }
            boolean unused = UNADSplash.this.isLoadingAd = false;
            if (UNADSplash.this.errorCount >= 2 || UNADSplash.this.adList.size() == 0) {
                UNADSplash.this.returnError("google", loadAdError.getCode() + "", loadAdError.getMessage() + "");
                return;
            }
            UNADSplash.this.reLoadAD();
            int unused2 = UNADSplash.this.adShowType = 0;
        }
    }

    class m implements MBSplashLoadListener {
        final /* synthetic */ FrameLayout a;

        m(FrameLayout frameLayout) {
            this.a = frameLayout;
        }

        public void isSupportZoomOut(MBridgeIds mBridgeIds, boolean z) {
        }

        public void onLoadFailed(MBridgeIds mBridgeIds, String str, int i) {
            if (UNADSplash.this.isUpdateLogBoolean) {
                b a2 = b.a();
                Activity access$2300 = UNADSplash.this.currentActivity;
                String access$2400 = UNADSplash.this.adUnitId;
                a2.b(access$2300, access$2400, "mintegral#" + str, "1", "mintegral");
            }
            boolean unused = UNADSplash.this.isLoadingAd = false;
            if (UNADSplash.this.errorCount >= 2 || UNADSplash.this.adList.size() == 0) {
                UNADSplash uNADSplash = UNADSplash.this;
                uNADSplash.returnError("mintegral", "-1", str + "");
                return;
            }
            UNADSplash.this.reLoadAD();
            int unused2 = UNADSplash.this.adShowType = 0;
        }

        public void onLoadSuccessed(MBridgeIds mBridgeIds, int i) {
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().c(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "mintegral", (String) null, "1");
            }
            if (!UNADSplash.this.isTimeOut) {
                if (UNADSplash.this.adViewListener != null) {
                    UNADSplash.this.adViewListener.onAdLoaded();
                    boolean unused = UNADSplash.this.isReturnErrorCallbackBoolean = true;
                }
                try {
                    int unused2 = UNADSplash.this.adShowType = 2;
                    UNADSplash uNADSplash = UNADSplash.this;
                    if (uNADSplash.isAppOnForeground(uNADSplash.currentActivity) && UNADSplash.this.currentActivity != null && !UNADSplash.this.currentActivity.isFinishing()) {
                        UNADSplash.this.dialog.show();
                        UNADSplash.this.mbSplashHandler.show(this.a);
                        int unused3 = UNADSplash.this.adShowType = 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    boolean unused4 = UNADSplash.this.isReturnErrorCallbackBoolean = false;
                    UNADSplash uNADSplash2 = UNADSplash.this;
                    uNADSplash2.returnError("unadsdk", "-1", "mintegral show Exception" + e.toString());
                    int unused5 = UNADSplash.this.adShowType = 0;
                }
            } else if (UNAD.ISOPENTAG) {
                Log.i("UNAD_SDK", "time out...3");
            }
        }
    }

    class n implements MBSplashShowListener {
        boolean a = false;
        private final Runnable b = new a();

        class a implements Runnable {
            a() {
            }

            public void run() {
                n.this.a();
            }
        }

        n() {
        }

        public void onAdClicked(MBridgeIds mBridgeIds) {
            this.a = true;
            if (UNADSplash.this.adViewListener != null) {
                UNADSplash.this.adViewListener.onAdClicked();
            }
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().a((Context) UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "mintegral", (String) null, "1");
            }
        }

        public void onAdTick(MBridgeIds mBridgeIds, long j) {
        }

        public void onDismiss(MBridgeIds mBridgeIds, int i) {
            if (this.a) {
                UNADSplash.this.mintegralhandler.postDelayed(this.b, 1000);
            } else {
                a();
            }
        }

        public void onShowFailed(MBridgeIds mBridgeIds, String str) {
            boolean unused = UNADSplash.this.isReturnErrorCallbackBoolean = false;
            if (UNADSplash.this.isUpdateLogBoolean) {
                b a2 = b.a();
                Activity access$2300 = UNADSplash.this.currentActivity;
                String access$2400 = UNADSplash.this.adUnitId;
                a2.b(access$2300, access$2400, "mintegral#" + str, "1", "mintegral");
            }
            UNADSplash uNADSplash = UNADSplash.this;
            uNADSplash.returnError("mintegral", "-1", str + "");
        }

        public void onShowSuccessed(MBridgeIds mBridgeIds) {
            long unused = UNADSplash.loadTime = new Date().getTime();
            if (UNADSplash.this.adViewListener != null) {
                UNADSplash.this.adViewListener.onAdOpen();
            }
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().e(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "mintegral", (String) null, "1");
            }
        }

        public void onZoomOutPlayFinish(MBridgeIds mBridgeIds) {
        }

        public void onZoomOutPlayStart(MBridgeIds mBridgeIds) {
        }

        /* access modifiers changed from: private */
        public void a() {
            try {
                if (UNADSplash.this.dialog != null) {
                    UNADSplash.this.dialog.dismiss();
                }
                if (UNADSplash.this.mbSplashHandler != null) {
                    UNADSplash.this.mbSplashHandler.onDestroy();
                    MBSplashHandler unused = UNADSplash.this.mbSplashHandler = null;
                }
                if (UNADSplash.this.adViewListener != null) {
                    UNADSplash.this.adViewListener.onAdClose();
                }
                int unused2 = UNADSplash.this.adShowType = 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class o implements FBSplashView.OnSplashViewActionListener {
        o() {
        }

        public void onAdViewFailed(AdError adError) {
            if (UNADSplash.this.adViewListener != null) {
                if (MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3.equals(UNADSplash.this.adVO.getShowType())) {
                    adError.setMessage("Fill failed");
                }
                UNADSplash.this.returnError("mopub", adError.getCode(), adError.getMessage());
            }
        }

        public void onAdViewLoaded() {
            boolean unused = UNADSplash.this.isReturnErrorCallbackBoolean = true;
            if (UNADSplash.this.adViewListener != null) {
                UNADSplash.this.adViewListener.onAdLoaded();
            }
        }

        public void onSplashImageClick(String str) {
        }

        public void onSplashViewDismiss(boolean z) {
            if (UNADSplash.this.adViewListener != null) {
                UNADSplash.this.adViewListener.onAdClose();
            }
            long unused = UNADSplash.loadTime = new Date().getTime();
        }
    }

    class p extends FullScreenContentCallback {
        p() {
        }

        public void onAdDismissedFullScreenContent() {
            AppOpenAd unused = UNADSplash.this.appOpenAd = null;
            boolean unused2 = UNADSplash.isShowingAd = false;
            if (UNADSplash.this.adViewListener != null) {
                UNADSplash.this.adViewListener.onAdClose();
            }
            long unused3 = UNADSplash.loadTime = new Date().getTime();
        }

        public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
            boolean unused = UNADSplash.this.isReturnErrorCallbackBoolean = false;
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().b(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "google#" + adError.getMessage(), "1", "google");
            }
            UNADSplash.this.returnError("google", adError.getCode() + "", adError.getMessage() + "");
        }

        public void onAdShowedFullScreenContent() {
            if (UNADSplash.this.adViewListener != null) {
                UNADSplash.this.adViewListener.onAdOpen();
            }
            boolean unused = UNADSplash.isShowingAd = true;
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().e(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "google", (String) null, "1");
            }
        }
    }

    class q implements Runnable {
        q() {
        }

        public void run() {
            UNADSplash.access$608(UNADSplash.this);
            if (UNADSplash.this.countTime >= UNADSplash.this.timeoutTime) {
                int unused = UNADSplash.this.errorCount = 2;
                if (!UNADSplash.this.isReturnErrorCallbackBoolean) {
                    boolean unused2 = UNADSplash.this.isTimeOut = true;
                    UNADSplash uNADSplash = UNADSplash.this;
                    uNADSplash.returnError(uNADSplash.errortypeTag, "-1", "Ad load timeout");
                    boolean unused3 = UNADSplash.this.isReturnErrorCallbackBoolean = true;
                    UNADSplash.this.timeOuthandler.removeCallbacks(UNADSplash.this.timeOutRunnable);
                    return;
                }
                return;
            }
            UNADSplash.this.timeOuthandler.postDelayed(this, 1000);
        }
    }

    class r implements View.OnClickListener {
        final /* synthetic */ FrameLayout a;

        r(FrameLayout frameLayout) {
            this.a = frameLayout;
        }

        public void onClick(View view) {
            if (UNADSplash.this.unad_splash_close.getVisibility() == 0) {
                long unused = UNADSplash.loadTime = new Date().getTime();
                if (UNADSplash.this.banner != null) {
                    IronSource.destroyBanner(UNADSplash.this.banner);
                }
                if (UNADSplash.this.pangleDialog != null) {
                    UNADSplash.this.pangleDialog.dismiss();
                }
                if (UNADSplash.this.dialog != null) {
                    UNADSplash.this.dialog.dismiss();
                }
                if (UNADSplash.this.adViewListener != null) {
                    UNADSplash.this.adViewListener.onAdClose();
                }
                this.a.removeAllViews();
                if (UNADSplash.this.mNativeAd != null) {
                    UNADSplash.this.mNativeAd.destroy();
                }
                int unused2 = UNADSplash.this.adShowType = 0;
            }
        }
    }

    class s implements BannerListener {
        final /* synthetic */ FrameLayout a;

        class a implements Runnable {
            final /* synthetic */ IronSourceError a;

            a(IronSourceError ironSourceError) {
                this.a = ironSourceError;
            }

            public void run() {
                if (UNADSplash.this.banner != null) {
                    IronSource.destroyBanner(UNADSplash.this.banner);
                }
                s.this.a.removeAllViews();
                if (UNADSplash.this.isUpdateLogBoolean) {
                    b.a().b(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "ironsource#" + this.a.getErrorMessage() + "," + this.a.getErrorCode(), "1", "unad_bigo");
                }
                boolean unused = UNADSplash.this.isLoadingAd = false;
                if (UNADSplash.this.errorCount >= 2 || UNADSplash.this.adList.size() == 0) {
                    UNADSplash.this.returnError("ironsource", this.a.getErrorCode() + "", this.a.getErrorMessage() + "");
                    return;
                }
                UNADSplash.this.reLoadAD();
                int unused2 = UNADSplash.this.adShowType = 0;
            }
        }

        s(FrameLayout frameLayout) {
            this.a = frameLayout;
        }

        public void onBannerAdClicked() {
            if (UNADSplash.this.adViewListener != null) {
                UNADSplash.this.adViewListener.onAdClicked();
            }
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().a((Context) UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "ironsource", (String) null, "1");
            }
        }

        public void onBannerAdLeftApplication() {
        }

        public void onBannerAdLoadFailed(IronSourceError ironSourceError) {
            UNADSplash.this.currentActivity.runOnUiThread(new a(ironSourceError));
        }

        public void onBannerAdLoaded() {
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().c(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "ironsource", (String) null, "1");
            }
            if (!UNADSplash.this.isTimeOut) {
                if (UNADSplash.this.adViewListener != null) {
                    UNADSplash.this.adViewListener.onAdLoaded();
                }
                long unused = UNADSplash.this.googleloadTime = new Date().getTime();
                boolean unused2 = UNADSplash.this.isReturnErrorCallbackBoolean = true;
                UNADSplash uNADSplash = UNADSplash.this;
                if (uNADSplash.isAppOnForeground(uNADSplash.currentActivity)) {
                    UNADSplash.this.showPangleDialog();
                } else {
                    UNADSplash.this.returnError("unadsdk", "-1", "Ad This display failed");
                }
            } else if (UNAD.ISOPENTAG) {
                Log.i("UNAD_SDK", "time out..7.");
            }
        }

        public void onBannerAdScreenDismissed() {
            if (UNADSplash.this.banner != null) {
                IronSource.destroyBanner(UNADSplash.this.banner);
            }
            if (UNADSplash.this.pangleDialog != null) {
                UNADSplash.this.pangleDialog.dismiss();
            }
            if (UNADSplash.this.dialog != null) {
                UNADSplash.this.dialog.dismiss();
            }
            if (UNADSplash.this.adViewListener != null) {
                UNADSplash.this.adViewListener.onAdClose();
            }
            this.a.removeAllViews();
            if (UNADSplash.this.mNativeAd != null) {
                UNADSplash.this.mNativeAd.destroy();
            }
            int unused = UNADSplash.this.adShowType = 0;
        }

        public void onBannerAdScreenPresented() {
            if (UNADSplash.this.adViewListener != null) {
                UNADSplash.this.adViewListener.onAdOpen();
            }
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().e(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "ironsource", (String) null, "1");
            }
        }
    }

    class t implements Runnable {
        t() {
        }

        public void run() {
            if (UNAD.BIGO_INIT_BOOLEAN) {
                if (UNADSplash.this.bigoType == 1) {
                    UNADSplash.this.loadUnadBigoAd();
                } else {
                    UNADSplash.this.loadBigoAd();
                }
                if (UNADSplash.this.unadBigohandler != null && UNADSplash.this.unadBigoRunnable != null) {
                    UNADSplash.this.unadBigohandler.removeCallbacks(UNADSplash.this.unadBigoRunnable);
                    return;
                }
                return;
            }
            if (UNADSplash.this.unadbigoTime < UNADSplash.this.timeoutTime) {
                UNADSplash.this.unadBigohandler.postDelayed(this, 1000);
            } else if (!(UNADSplash.this.unadBigohandler == null || UNADSplash.this.unadBigoRunnable == null)) {
                UNADSplash.this.unadBigohandler.removeCallbacks(UNADSplash.this.unadBigoRunnable);
            }
            UNADSplash.access$3508(UNADSplash.this);
        }
    }

    class u implements AdLoadListener<InterstitialAd> {

        class a implements AdInteractionListener {
            a() {
            }

            public void onAdClicked() {
                if (UNADSplash.this.adViewListener != null) {
                    UNADSplash.this.adViewListener.onAdClicked();
                }
                if (UNADSplash.this.isUpdateLogBoolean) {
                    b.a().a((Context) UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "bigo_is", (String) null, "1");
                }
            }

            public void onAdClosed() {
                if (UNADSplash.this.interstitiaBigolAd != null) {
                    UNADSplash.this.interstitiaBigolAd.destroy();
                    InterstitialAd unused = UNADSplash.this.interstitiaBigolAd = null;
                }
                if (UNADSplash.this.adViewListener != null) {
                    UNADSplash.this.adViewListener.onAdClose();
                }
            }

            public void onAdError(sg.bigo.ads.api.AdError adError) {
                if (UNADSplash.this.isUpdateLogBoolean) {
                    b.a().b(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "bigo_is#" + adError.getMessage() + "," + adError.getCode(), "1", "bigo_is");
                }
                boolean unused = UNADSplash.this.isLoadingAd = false;
                if (UNADSplash.this.errorCount >= 2 || UNADSplash.this.adList.size() == 0) {
                    UNADSplash.this.returnError("bigo_is", adError.getCode() + "", adError.getMessage() + "");
                    return;
                }
                UNADSplash.this.reLoadAD();
                int unused2 = UNADSplash.this.adShowType = 0;
            }

            public void onAdImpression() {
                if (UNADSplash.this.isUpdateLogBoolean) {
                    b.a().e(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "bigo_is", (String) null, "1");
                }
                if (UNADSplash.this.adViewListener != null) {
                    UNADSplash.this.adViewListener.onAdOpen();
                }
            }

            public void onAdOpened() {
            }
        }

        u() {
        }

        private void a(InterstitialAd interstitialAd) {
            interstitialAd.setAdInteractionListener(new a());
        }

        /* renamed from: b */
        public void onAdLoaded(InterstitialAd interstitialAd) {
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().c(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "bigo_is", (String) null, "1");
            }
            if (!UNADSplash.this.isTimeOut) {
                if (UNADSplash.this.adViewListener != null) {
                    UNADSplash.this.adViewListener.onAdLoaded();
                }
                long unused = UNADSplash.this.googleloadTime = new Date().getTime();
                boolean unused2 = UNADSplash.this.isReturnErrorCallbackBoolean = true;
                InterstitialAd unused3 = UNADSplash.this.interstitiaBigolAd = interstitialAd;
                a(interstitialAd);
                UNADSplash.this.interstitiaBigolAd.show();
            } else if (UNAD.ISOPENTAG) {
                Log.i("UNAD_SDK", "time out...bigois");
            }
        }

        public void onError(sg.bigo.ads.api.AdError adError) {
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().b(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "bigo_is#" + adError.getMessage() + "," + adError.getCode(), "1", "bigo_is");
            }
            boolean unused = UNADSplash.this.isLoadingAd = false;
            if (UNADSplash.this.errorCount >= 2 || UNADSplash.this.adList.size() == 0) {
                UNADSplash.this.returnError("bigo_is", adError.getCode() + "", adError.getMessage() + "");
                return;
            }
            UNADSplash.this.reLoadAD();
            int unused2 = UNADSplash.this.adShowType = 0;
        }
    }

    class v implements Runnable {
        v() {
        }

        public void run() {
            if (UNAD.BIGO_INIT_BOOLEAN) {
                UNADSplash.this.loadBigoInterstitialAd();
                if (UNADSplash.this.bigoIshandler != null && UNADSplash.this.bigoIshandler != null) {
                    UNADSplash.this.bigoIshandler.removeCallbacks(this);
                    return;
                }
                return;
            }
            if (UNADSplash.this.bigoIsTime < UNADSplash.this.timeoutTime) {
                UNADSplash.this.bigoIshandler.postDelayed(this, 1000);
            } else if (!(UNADSplash.this.bigoIshandler == null || UNADSplash.this.bigoIshandler == null)) {
                UNADSplash.this.bigoIshandler.removeCallbacks(this);
            }
            UNADSplash.access$3908(UNADSplash.this);
        }
    }

    class w implements Runnable {
        w() {
        }

        public void run() {
            if (UNADSplash.this.unad_progressBar != null) {
                UNADSplash.this.unad_progressBar.setVisibility(8);
            }
            if (UNADSplash.this.unad_splash_close != null) {
                UNADSplash.this.unad_splash_close.setVisibility(0);
            }
        }
    }

    class x implements AdLoadListener<SplashAd> {
        final /* synthetic */ RelativeLayout a;

        x(RelativeLayout relativeLayout) {
            this.a = relativeLayout;
        }

        /* renamed from: a */
        public void onAdLoaded(SplashAd splashAd) {
            if (splashAd == null) {
                if (UNADSplash.this.isUpdateLogBoolean) {
                    b.a().b(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "bigo# ads list is null", "1", "bigo");
                }
                boolean unused = UNADSplash.this.isLoadingAd = false;
                if (UNADSplash.this.errorCount >= 2 || UNADSplash.this.adList.size() == 0) {
                    UNADSplash.this.returnError("unad_pangle", "-1", "ads list is null");
                    return;
                }
                UNADSplash.this.reLoadAD();
                int unused2 = UNADSplash.this.adShowType = 0;
                return;
            }
            SplashAd unused3 = UNADSplash.this.mSplashAd = splashAd;
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().c(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "bigo", (String) null, "1");
            }
            if (UNADSplash.this.isTimeOut) {
                if (UNADSplash.this.mSplashAd != null) {
                    UNADSplash.this.mSplashAd.destroy();
                }
                if (UNAD.ISOPENTAG) {
                    Log.i("UNAD_SDK", "time out..88.");
                    return;
                }
                return;
            }
            if (UNADSplash.this.adViewListener != null) {
                UNADSplash.this.adViewListener.onAdLoaded();
            }
            long unused4 = UNADSplash.this.googleloadTime = new Date().getTime();
            boolean unused5 = UNADSplash.this.isReturnErrorCallbackBoolean = true;
            UNADSplash uNADSplash = UNADSplash.this;
            if (uNADSplash.isAppOnForeground(uNADSplash.currentActivity)) {
                UNADSplash.this.showPangleDialog();
                UNADSplash.this.onSplashAdLoaded(splashAd, this.a);
                return;
            }
            UNADSplash.this.returnError("unadsdk", "-1", "Ad This display failed");
        }

        public void onError(sg.bigo.ads.api.AdError adError) {
            if (UNADSplash.this.isUpdateLogBoolean) {
                b.a().b(UNADSplash.this.currentActivity, UNADSplash.this.adUnitId, "bigo#" + adError.getMessage() + "," + adError.getCode(), "1", "bigo");
            }
            boolean unused = UNADSplash.this.isLoadingAd = false;
            if (UNADSplash.this.errorCount >= 2 || UNADSplash.this.adList.size() == 0) {
                UNADSplash.this.returnError("unad_pangle", adError.getCode() + "", adError.getMessage() + "");
                return;
            }
            UNADSplash.this.reLoadAD();
            int unused2 = UNADSplash.this.adShowType = 0;
        }
    }

    private static class y extends RecyclerView.ViewHolder {
        ImageView a;
        ImageView b;
        Button c;
        TextView d;
        TextView e;
        RelativeLayout f;

        public y(View view) {
            super(view);
        }
    }

    private static class z extends y {
        FrameLayout g;

        public z(View view) {
            super(view);
            this.b = (ImageView) view.findViewById(R.id.iv_listitem_dislike);
            this.d = (TextView) view.findViewById(R.id.tv_listitem_ad_title);
            this.e = (TextView) view.findViewById(R.id.tv_listitem_ad_desc);
            this.g = (FrameLayout) view.findViewById(R.id.iv_listitem_video);
            this.a = (ImageView) view.findViewById(R.id.iv_listitem_icon);
            this.c = (Button) view.findViewById(R.id.tt_creative_btn);
            this.f = (RelativeLayout) view.findViewById(R.id.tt_ad_logo);
        }
    }

    public UNADSplash(Application application) {
        this.myApplication = application;
        if (!isregisterActivityLifecycleCallbacks) {
            application.registerActivityLifecycleCallbacks(this);
            ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
            isregisterActivityLifecycleCallbacks = true;
        }
        a.a(application);
    }

    static /* synthetic */ int access$3508(UNADSplash uNADSplash) {
        int i2 = uNADSplash.unadbigoTime;
        uNADSplash.unadbigoTime = i2 + 1;
        return i2;
    }

    static /* synthetic */ int access$3908(UNADSplash uNADSplash) {
        int i2 = uNADSplash.bigoIsTime;
        uNADSplash.bigoIsTime = i2 + 1;
        return i2;
    }

    static /* synthetic */ int access$5108(UNADSplash uNADSplash) {
        int i2 = uNADSplash.pangleTime;
        uNADSplash.pangleTime = i2 + 1;
        return i2;
    }

    static /* synthetic */ int access$608(UNADSplash uNADSplash) {
        int i2 = uNADSplash.countTime;
        uNADSplash.countTime = i2 + 1;
        return i2;
    }

    private void addAdLogoView(y yVar, PAGNativeAdData pAGNativeAdData) {
        if (yVar != null && pAGNativeAdData != null) {
            ImageView imageView = (ImageView) pAGNativeAdData.getAdLogoView();
            RelativeLayout relativeLayout = yVar.f;
            if (relativeLayout != null && imageView != null) {
                relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
            }
        }
    }

    /* access modifiers changed from: private */
    public void bindData(y yVar, List<View> list, PAGNativeAd pAGNativeAd, PAGNativeAdData pAGNativeAdData) {
        addAdLogoView(yVar, pAGNativeAd.getNativeAdData());
        ArrayList arrayList = new ArrayList();
        arrayList.add(yVar.itemView);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(yVar.c);
        pAGNativeAd.registerViewForInteraction((ViewGroup) yVar.itemView, arrayList, arrayList2, yVar.b, new j());
        ImageView imageView = yVar.b;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        if (pAGNativeAdData != null) {
            yVar.d.setText(pAGNativeAdData.getTitle());
            yVar.e.setText(pAGNativeAdData.getDescription());
            PAGImageItem icon = pAGNativeAdData.getIcon();
            if (icon != null) {
                this.mRequestManager.load(icon.getImageUrl()).into(yVar.a);
            }
            yVar.c.setText(pAGNativeAdData.getButtonText());
        }
    }

    private void fetchAd() {
        if (this.currentActivity == null) {
            returnError("google", "-1", "activity is null");
            return;
        }
        this.errortypeTag = "google";
        if (!isAdAvailable()) {
            this.isLoadingAd = true;
            loadGoogleAd(true);
            return;
        }
        this.adShowType = 0;
        showGoogleDialog();
        Handler handler2 = this.timeOuthandler;
        if (handler2 != null) {
            handler2.removeCallbacks(this.timeOutRunnable);
        }
    }

    private AdRequest getAdRequest() {
        return new AdRequest.Builder().build();
    }

    private boolean isAdAvailable() {
        return this.appOpenAd != null && wasLoadTimeLessThanNHoursAgo(4);
    }

    /* access modifiers changed from: private */
    public void loadAdGoAd() {
        if (!this.isReturnErrorCallbackBoolean) {
            int i2 = 0;
            this.adShowType = 0;
            loadTime = new Date().getTime();
            if (this.adUnitId == null) {
                returnError("unadsdk", "A001", this.myApplication.getString(R.string.unad_A001));
                return;
            }
            AdInfo adInfo = a.b;
            if (adInfo == null || adInfo.getAdUnits() == null || adInfo.getAdUnits().size() <= 0 || !MBridgeConstans.ENDCARD_URL_TYPE_PL.equals(adInfo.getStatus())) {
                returnError("unadsdk", "A002", this.myApplication.getString(R.string.unad_A002));
                return;
            }
            for (AdList next : adInfo.getAdUnits()) {
                if ("Splash".equals(next.getType()) && this.adUnitId.equals(next.getAdUnitId())) {
                    this.adVO = next;
                }
            }
            AdList adList2 = this.adVO;
            if (adList2 == null) {
                returnError("unadsdk", "A003", this.myApplication.getString(R.string.unad_A003));
            } else if (!adList2.isEnable()) {
                returnError("unadsdk", "A004", this.myApplication.getString(R.string.unad_A004));
            } else {
                if (!(this.currentActivity == null || this.adVO.getCountrys() == null || this.adVO.getCountrys().length() <= 0)) {
                    Locale locale = this.currentActivity.getResources().getConfiguration().locale;
                    if (!this.adVO.getCountrys().contains((locale.getCountry() + "").toUpperCase())) {
                        returnError("unadsdk", "A006", this.myApplication.getString(R.string.unad_A006));
                        return;
                    }
                }
                if (this.adVO.getAdSource() == null || this.adVO.getAdSource().isEmpty()) {
                    returnError("unadsdk", "A003", this.myApplication.getString(R.string.unad_A003));
                    return;
                }
                for (int i3 = 0; i3 < this.adVO.getAdSource().size(); i3++) {
                    if (this.adVO.getAdSource().get(i3) != null) {
                        this.adVO.getAdSource().get(i3).setIndex(i3);
                    }
                }
                try {
                    this.isUpdateLogBoolean = this.adVO.isOpenLogs();
                } catch (Exception unused) {
                }
                int parseInt = Integer.parseInt(new com.unad.sdk.util.b(this.myApplication.getApplicationContext()).b("splash_index", MBridgeConstans.ENDCARD_URL_TYPE_PL));
                if (!d.a(this.adVO, parseInt)) {
                    i2 = parseInt;
                }
                SourceVO a2 = d.a(this.adVO, i2, this.myApplication);
                this.sourceVO = a2;
                if (a2 == null) {
                    returnError("unadsdk", "A003", this.myApplication.getString(R.string.unad_A003));
                    return;
                }
                if (this.adList.size() <= 0) {
                    this.adList = d.a(this.adVO, this.sourceVO);
                }
                sdkLoadAd();
                saveLoadType((i2 + 1) + "");
            }
        }
    }

    /* access modifiers changed from: private */
    public void loadBigoAd() {
        if (this.currentActivity == null) {
            returnError("unadsdk", "-1", "activity is null");
        } else if (this.adVO == null) {
            returnError("unadsdk", "-1", "advo is null");
        } else if (this.loadAd == null) {
            returnError("unadsdk", "-1", "adid is null");
        } else {
            this.errortypeTag = "unad_bigo";
            try {
                AlertDialog alertDialog = this.pangleDialog;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                AlertDialog alertDialog2 = this.pangleDialog;
                if (alertDialog2 != null) {
                    alertDialog2.dismiss();
                }
                SplashAd splashAd = this.mSplashAd;
                if (splashAd != null) {
                    splashAd.destroy();
                }
                loadTime = new Date().getTime();
                RelativeLayout relativeLayout = new RelativeLayout(this.currentActivity);
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                AlertDialog.Builder builder = new AlertDialog.Builder(this.currentActivity, R.style.unad_PrivacyThemeDialog);
                builder.setView(relativeLayout);
                AlertDialog create = builder.create();
                this.pangleDialog = create;
                create.setCancelable(false);
                if (this.isUpdateLogBoolean) {
                    b.a().a((Context) this.currentActivity, this.adUnitId, this.isSdkLoad, "bigo", "1");
                }
                new SplashAdLoader.Builder().withAdLoadListener((AdLoadListener) new x(relativeLayout)).build().loadAd(new SplashAdRequest.Builder().withSlotId(this.loadAd).withAppLogo(this.logoPicture).withAppName(this.appname).build());
            } catch (Exception e2) {
                if (this.isUpdateLogBoolean) {
                    b a2 = b.a();
                    Activity activity = this.currentActivity;
                    String str = this.adUnitId;
                    a2.b(activity, str, "bigo#" + e2.getMessage(), "1", "bigo");
                }
                this.isLoadingAd = false;
                if (this.errorCount >= 2 || this.adList.size() == 0) {
                    returnError("bigo", "-1", e2.getMessage() + "");
                    return;
                }
                reLoadAD();
                this.adShowType = 0;
            }
        }
    }

    /* access modifiers changed from: private */
    public void loadBigoInterstitialAd() {
        if (this.currentActivity == null) {
            returnError("unadsdk", "-1", "activity is null");
        } else if (this.adVO == null) {
            returnError("unadsdk", "-1", "advo is null");
        } else if (this.loadAd == null) {
            returnError("unadsdk", "-1", "adid is null");
        } else {
            this.errortypeTag = "bigo_is";
            try {
                if (this.isUpdateLogBoolean) {
                    b.a().a((Context) this.currentActivity, this.adUnitId, this.isSdkLoad, "bigo_is", "1");
                }
                InterstitialAd interstitialAd = this.interstitiaBigolAd;
                if (interstitialAd != null) {
                    interstitialAd.destroy();
                    this.interstitiaBigolAd = null;
                }
                new InterstitialAdLoader.Builder().withAdLoadListener((AdLoadListener) new u()).build().loadAd(new InterstitialAdRequest.Builder().withSlotId(this.loadAd).build());
            } catch (Exception e2) {
                if (this.isUpdateLogBoolean) {
                    b a2 = b.a();
                    Activity activity = this.currentActivity;
                    String str = this.adUnitId;
                    a2.b(activity, str, "unadsdk#" + e2.getMessage(), "1", "unadsdk");
                }
                this.isLoadingAd = false;
                if (this.errorCount >= 2 || this.adList.size() == 0) {
                    returnError("unadsdk", "-1", e2.getMessage() + "");
                    return;
                }
                reLoadAD();
                this.adShowType = 0;
            }
        }
    }

    private void loadFacebookeInsertAd() {
        if (!UNAD.MINTEFRAL_INIT_BOOLEAN) {
            this.isLoadingAd = false;
            if (this.errorCount >= 2 || this.adList.size() == 0) {
                returnError("google", "-1", "mintegral not init");
                return;
            }
            reLoadAD();
            this.adShowType = 0;
        } else if (this.currentActivity == null) {
            returnError("unadsdk", "-1", "activity is null");
        } else if (this.adVO == null) {
            returnError("unadsdk", "-1", "advo is null");
        } else if (this.loadAd == null) {
            returnError("unadsdk", "-1", "adid is null");
        } else {
            if (!(this.loadAd + "").contains("#")) {
                returnError("unadsdk", "-1", "mintegral id is exception");
                return;
            }
            String str = this.loadAd.split("#")[0];
            String str2 = this.loadAd.split("#")[1];
            loadTime = new Date().getTime();
            FrameLayout frameLayout = new FrameLayout(this.currentActivity);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            AlertDialog.Builder builder = new AlertDialog.Builder(this.currentActivity, R.style.unad_PrivacyThemeDialog);
            builder.setView(frameLayout);
            AlertDialog create = builder.create();
            this.dialog = create;
            create.setCancelable(false);
            MBSplashHandler mBSplashHandler = new MBSplashHandler(str, str2);
            this.mbSplashHandler = mBSplashHandler;
            mBSplashHandler.setLoadTimeOut((long) this.timeoutTime);
            this.mbSplashHandler.setSplashLoadListener(new m(frameLayout));
            this.mbSplashHandler.setSplashShowListener(new n());
            this.mbSplashHandler.preLoad();
            if (this.isUpdateLogBoolean) {
                b.a().a((Context) this.currentActivity, this.adUnitId, this.isSdkLoad, "mintegral", "1");
            }
        }
    }

    private void loadGoogleAd(boolean z2) {
        loadTime = new Date().getTime();
        if (UNAD.ISOPENTAG) {
            Log.i("UNAD_SDK", "start load ad");
        }
        String str = this.loadAd;
        if (str == null || "".equals(str)) {
            returnError("unadsdk", "A003", this.myApplication.getString(R.string.unad_A003));
            return;
        }
        if (this.isUpdateLogBoolean) {
            b.a().a((Context) this.currentActivity, this.adUnitId, this.isSdkLoad, "google", "1");
        }
        this.loadCallback = new l(z2);
        AppOpenAd.load((Context) this.currentActivity, this.loadAd, getAdRequest(), 1, this.loadCallback);
    }

    /* access modifiers changed from: private */
    public void loadPangAd() {
        if (this.currentActivity == null) {
            returnError("unadsdk", "-1", "activity is null");
        } else if (this.adVO == null) {
            returnError("unadsdk", "-1", "advo is null");
        } else if (this.loadAd == null) {
            returnError("unadsdk", "-1", "adid is null");
        } else {
            this.errortypeTag = "pangle";
            try {
                int i2 = this.timeoutTime * 1000;
                if (this.isUpdateLogBoolean) {
                    b.a().a((Context) this.currentActivity, this.adUnitId, this.isSdkLoad, "pangle", "1");
                }
                PAGAppOpenRequest pAGAppOpenRequest = new PAGAppOpenRequest();
                pAGAppOpenRequest.setTimeout(i2);
                PAGAppOpenAd.loadAd(this.loadAd, pAGAppOpenRequest, new e());
            } catch (Exception e2) {
                if (this.isUpdateLogBoolean) {
                    b a2 = b.a();
                    Activity activity = this.currentActivity;
                    String str = this.adUnitId;
                    a2.b(activity, str, "pangle#" + e2.getMessage(), "1", "unad_pangle");
                }
                this.isLoadingAd = false;
                if (this.errorCount >= 2 || this.adList.size() == 0) {
                    returnError("unad_pangle", "-1", e2.getMessage() + "");
                    return;
                }
                reLoadAD();
                this.adShowType = 0;
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d5 A[Catch:{ Exception -> 0x011b }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e5 A[Catch:{ Exception -> 0x011b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadUnadBigoAd() {
        /*
            r12 = this;
            android.app.Activity r0 = r12.currentActivity
            java.lang.String r1 = "unadsdk"
            java.lang.String r2 = "-1"
            if (r0 != 0) goto L_0x000e
            java.lang.String r0 = "activity is null"
            r12.returnError(r1, r2, r0)
            return
        L_0x000e:
            com.unad.sdk.dto.AdList r0 = r12.adVO
            if (r0 != 0) goto L_0x0018
            java.lang.String r0 = "advo is null"
            r12.returnError(r1, r2, r0)
            return
        L_0x0018:
            java.lang.String r0 = r12.loadAd
            if (r0 != 0) goto L_0x0022
            java.lang.String r0 = "adid is null"
            r12.returnError(r1, r2, r0)
            return
        L_0x0022:
            java.lang.String r0 = "unad_bigo"
            r12.errortypeTag = r0
            r0 = 0
            android.app.AlertDialog r1 = r12.pangleDialog     // Catch:{ Exception -> 0x011b }
            if (r1 == 0) goto L_0x002e
            r1.dismiss()     // Catch:{ Exception -> 0x011b }
        L_0x002e:
            java.util.Date r1 = new java.util.Date     // Catch:{ Exception -> 0x011b }
            r1.<init>()     // Catch:{ Exception -> 0x011b }
            long r3 = r1.getTime()     // Catch:{ Exception -> 0x011b }
            loadTime = r3     // Catch:{ Exception -> 0x011b }
            android.app.Activity r1 = r12.currentActivity     // Catch:{ Exception -> 0x011b }
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r1)     // Catch:{ Exception -> 0x011b }
            int r3 = com.unad.sdk.R.layout.unad_pangle_ad_container     // Catch:{ Exception -> 0x011b }
            r4 = 0
            android.view.View r1 = r1.inflate(r3, r4)     // Catch:{ Exception -> 0x011b }
            int r3 = com.unad.sdk.R.id.unad_ad_container     // Catch:{ Exception -> 0x011b }
            android.view.View r3 = r1.findViewById(r3)     // Catch:{ Exception -> 0x011b }
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3     // Catch:{ Exception -> 0x011b }
            int r4 = com.unad.sdk.R.id.unad_logo     // Catch:{ Exception -> 0x011b }
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x011b }
            android.widget.ImageView r4 = (android.widget.ImageView) r4     // Catch:{ Exception -> 0x011b }
            int r5 = com.unad.sdk.R.id.unad_progressBar     // Catch:{ Exception -> 0x011b }
            android.view.View r5 = r1.findViewById(r5)     // Catch:{ Exception -> 0x011b }
            android.widget.ProgressBar r5 = (android.widget.ProgressBar) r5     // Catch:{ Exception -> 0x011b }
            r12.unad_progressBar = r5     // Catch:{ Exception -> 0x011b }
            int r5 = com.unad.sdk.R.id.unad_splash_close     // Catch:{ Exception -> 0x011b }
            android.view.View r5 = r1.findViewById(r5)     // Catch:{ Exception -> 0x011b }
            android.widget.ImageView r5 = (android.widget.ImageView) r5     // Catch:{ Exception -> 0x011b }
            r12.unad_splash_close = r5     // Catch:{ Exception -> 0x011b }
            int r5 = com.unad.sdk.R.id.unad_top_rl     // Catch:{ Exception -> 0x011b }
            android.view.View r5 = r1.findViewById(r5)     // Catch:{ Exception -> 0x011b }
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5     // Catch:{ Exception -> 0x011b }
            int r6 = com.unad.sdk.R.id.unad_splash_appname     // Catch:{ Exception -> 0x011b }
            android.view.View r6 = r1.findViewById(r6)     // Catch:{ Exception -> 0x011b }
            android.widget.TextView r6 = (android.widget.TextView) r6     // Catch:{ Exception -> 0x011b }
            int r7 = com.unad.sdk.R.id.unad_splash_title1     // Catch:{ Exception -> 0x011b }
            android.view.View r7 = r1.findViewById(r7)     // Catch:{ Exception -> 0x011b }
            android.widget.TextView r7 = (android.widget.TextView) r7     // Catch:{ Exception -> 0x011b }
            int r8 = com.unad.sdk.R.id.unad_splash_title2     // Catch:{ Exception -> 0x011b }
            android.view.View r8 = r1.findViewById(r8)     // Catch:{ Exception -> 0x011b }
            android.widget.TextView r8 = (android.widget.TextView) r8     // Catch:{ Exception -> 0x011b }
            r3.removeAllViews()     // Catch:{ Exception -> 0x011b }
            android.app.AlertDialog$Builder r9 = new android.app.AlertDialog$Builder     // Catch:{ Exception -> 0x011b }
            android.app.Activity r10 = r12.currentActivity     // Catch:{ Exception -> 0x011b }
            int r11 = com.unad.sdk.R.style.unad_PrivacyThemeDialog2     // Catch:{ Exception -> 0x011b }
            r9.<init>(r10, r11)     // Catch:{ Exception -> 0x011b }
            r9.setView(r1)     // Catch:{ Exception -> 0x011b }
            com.unad.sdk.UNADSplash$b r1 = new com.unad.sdk.UNADSplash$b     // Catch:{ Exception -> 0x011b }
            r1.<init>(r3)     // Catch:{ Exception -> 0x011b }
            r5.setOnClickListener(r1)     // Catch:{ Exception -> 0x011b }
            int r1 = r12.logoPicture     // Catch:{ Exception -> 0x011b }
            r4.setImageResource(r1)     // Catch:{ Exception -> 0x011b }
            java.lang.String r1 = r12.appname     // Catch:{ Exception -> 0x011b }
            if (r1 == 0) goto L_0x00ad
            r6.setText(r1)     // Catch:{ Exception -> 0x011b }
        L_0x00ad:
            int r1 = r12.logoPicture     // Catch:{ Exception -> 0x011b }
            r5 = 8
            if (r1 == 0) goto L_0x00c5
            java.lang.String r1 = r12.appname     // Catch:{ Exception -> 0x011b }
            if (r1 != 0) goto L_0x00b8
            goto L_0x00c5
        L_0x00b8:
            r6.setVisibility(r0)     // Catch:{ Exception -> 0x011b }
            r4.setVisibility(r0)     // Catch:{ Exception -> 0x011b }
            r7.setVisibility(r0)     // Catch:{ Exception -> 0x011b }
            r8.setVisibility(r5)     // Catch:{ Exception -> 0x011b }
            goto L_0x00d1
        L_0x00c5:
            r6.setVisibility(r5)     // Catch:{ Exception -> 0x011b }
            r4.setVisibility(r5)     // Catch:{ Exception -> 0x011b }
            r7.setVisibility(r5)     // Catch:{ Exception -> 0x011b }
            r8.setVisibility(r0)     // Catch:{ Exception -> 0x011b }
        L_0x00d1:
            android.app.AlertDialog r1 = r12.pangleDialog     // Catch:{ Exception -> 0x011b }
            if (r1 == 0) goto L_0x00d8
            r1.dismiss()     // Catch:{ Exception -> 0x011b }
        L_0x00d8:
            android.app.AlertDialog r1 = r9.create()     // Catch:{ Exception -> 0x011b }
            r12.pangleDialog = r1     // Catch:{ Exception -> 0x011b }
            r1.setCancelable(r0)     // Catch:{ Exception -> 0x011b }
            boolean r1 = r12.isUpdateLogBoolean     // Catch:{ Exception -> 0x011b }
            if (r1 == 0) goto L_0x00f6
            com.unad.sdk.b r4 = com.unad.sdk.b.a()     // Catch:{ Exception -> 0x011b }
            android.app.Activity r5 = r12.currentActivity     // Catch:{ Exception -> 0x011b }
            java.lang.String r6 = r12.adUnitId     // Catch:{ Exception -> 0x011b }
            boolean r7 = r12.isSdkLoad     // Catch:{ Exception -> 0x011b }
            java.lang.String r8 = "unad_bigo"
            java.lang.String r9 = "1"
            r4.a((android.content.Context) r5, (java.lang.String) r6, (boolean) r7, (java.lang.String) r8, (java.lang.String) r9)     // Catch:{ Exception -> 0x011b }
        L_0x00f6:
            sg.bigo.ads.api.NativeAdRequest$Builder r1 = new sg.bigo.ads.api.NativeAdRequest$Builder     // Catch:{ Exception -> 0x011b }
            r1.<init>()     // Catch:{ Exception -> 0x011b }
            java.lang.String r4 = r12.loadAd     // Catch:{ Exception -> 0x011b }
            sg.bigo.ads.api.NativeAdRequest$Builder r1 = r1.withSlotId(r4)     // Catch:{ Exception -> 0x011b }
            sg.bigo.ads.api.NativeAdRequest r1 = r1.build()     // Catch:{ Exception -> 0x011b }
            sg.bigo.ads.api.NativeAdLoader$Builder r4 = new sg.bigo.ads.api.NativeAdLoader$Builder     // Catch:{ Exception -> 0x011b }
            r4.<init>()     // Catch:{ Exception -> 0x011b }
            com.unad.sdk.UNADSplash$c r5 = new com.unad.sdk.UNADSplash$c     // Catch:{ Exception -> 0x011b }
            r5.<init>(r3)     // Catch:{ Exception -> 0x011b }
            sg.bigo.ads.api.NativeAdLoader$Builder r3 = r4.withAdLoadListener((sg.bigo.ads.api.AdLoadListener) r5)     // Catch:{ Exception -> 0x011b }
            sg.bigo.ads.api.NativeAdLoader r3 = r3.build()     // Catch:{ Exception -> 0x011b }
            r3.loadAd(r1)     // Catch:{ Exception -> 0x011b }
            goto L_0x0159
        L_0x011b:
            r1 = move-exception
            boolean r3 = r12.isUpdateLogBoolean
            if (r3 == 0) goto L_0x0144
            com.unad.sdk.b r4 = com.unad.sdk.b.a()
            android.app.Activity r5 = r12.currentActivity
            java.lang.String r6 = r12.adUnitId
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r7 = "unad_bigo#"
            r3.append(r7)
            java.lang.String r7 = r1.getMessage()
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            java.lang.String r8 = "1"
            java.lang.String r9 = "unad_bigo"
            r4.b(r5, r6, r7, r8, r9)
        L_0x0144:
            r12.isLoadingAd = r0
            int r3 = r12.errorCount
            r4 = 2
            if (r3 >= r4) goto L_0x015a
            java.util.ArrayList<com.unad.sdk.dto.SourceVO> r3 = r12.adList
            int r3 = r3.size()
            if (r3 != 0) goto L_0x0154
            goto L_0x015a
        L_0x0154:
            r12.reLoadAD()
            r12.adShowType = r0
        L_0x0159:
            return
        L_0x015a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r1.getMessage()
            r0.append(r1)
            java.lang.String r1 = ""
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "unad_pangle"
            r12.returnError(r1, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unad.sdk.UNADSplash.loadUnadBigoAd():void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d5 A[Catch:{ Exception -> 0x010e }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f2 A[Catch:{ Exception -> 0x010e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadUnadPangAd() {
        /*
            r13 = this;
            android.app.Activity r0 = r13.currentActivity
            java.lang.String r1 = "unadsdk"
            java.lang.String r2 = "-1"
            if (r0 != 0) goto L_0x000e
            java.lang.String r0 = "activity is null"
            r13.returnError(r1, r2, r0)
            return
        L_0x000e:
            com.unad.sdk.dto.AdList r0 = r13.adVO
            if (r0 != 0) goto L_0x0018
            java.lang.String r0 = "advo is null"
            r13.returnError(r1, r2, r0)
            return
        L_0x0018:
            java.lang.String r0 = r13.loadAd
            if (r0 != 0) goto L_0x0022
            java.lang.String r0 = "adid is null"
            r13.returnError(r1, r2, r0)
            return
        L_0x0022:
            java.lang.String r0 = "unad_pangle"
            r13.errortypeTag = r0
            r1 = 0
            android.app.AlertDialog r3 = r13.pangleDialog     // Catch:{ Exception -> 0x010e }
            if (r3 == 0) goto L_0x002e
            r3.dismiss()     // Catch:{ Exception -> 0x010e }
        L_0x002e:
            java.util.Date r3 = new java.util.Date     // Catch:{ Exception -> 0x010e }
            r3.<init>()     // Catch:{ Exception -> 0x010e }
            long r3 = r3.getTime()     // Catch:{ Exception -> 0x010e }
            loadTime = r3     // Catch:{ Exception -> 0x010e }
            android.app.Activity r3 = r13.currentActivity     // Catch:{ Exception -> 0x010e }
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)     // Catch:{ Exception -> 0x010e }
            int r4 = com.unad.sdk.R.layout.unad_pangle_ad_container     // Catch:{ Exception -> 0x010e }
            r5 = 0
            android.view.View r3 = r3.inflate(r4, r5)     // Catch:{ Exception -> 0x010e }
            int r4 = com.unad.sdk.R.id.unad_ad_container     // Catch:{ Exception -> 0x010e }
            android.view.View r4 = r3.findViewById(r4)     // Catch:{ Exception -> 0x010e }
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4     // Catch:{ Exception -> 0x010e }
            int r5 = com.unad.sdk.R.id.unad_logo     // Catch:{ Exception -> 0x010e }
            android.view.View r5 = r3.findViewById(r5)     // Catch:{ Exception -> 0x010e }
            android.widget.ImageView r5 = (android.widget.ImageView) r5     // Catch:{ Exception -> 0x010e }
            int r6 = com.unad.sdk.R.id.unad_progressBar     // Catch:{ Exception -> 0x010e }
            android.view.View r6 = r3.findViewById(r6)     // Catch:{ Exception -> 0x010e }
            android.widget.ProgressBar r6 = (android.widget.ProgressBar) r6     // Catch:{ Exception -> 0x010e }
            r13.unad_progressBar = r6     // Catch:{ Exception -> 0x010e }
            int r6 = com.unad.sdk.R.id.unad_splash_close     // Catch:{ Exception -> 0x010e }
            android.view.View r6 = r3.findViewById(r6)     // Catch:{ Exception -> 0x010e }
            android.widget.ImageView r6 = (android.widget.ImageView) r6     // Catch:{ Exception -> 0x010e }
            r13.unad_splash_close = r6     // Catch:{ Exception -> 0x010e }
            int r6 = com.unad.sdk.R.id.unad_top_rl     // Catch:{ Exception -> 0x010e }
            android.view.View r6 = r3.findViewById(r6)     // Catch:{ Exception -> 0x010e }
            android.widget.RelativeLayout r6 = (android.widget.RelativeLayout) r6     // Catch:{ Exception -> 0x010e }
            int r7 = com.unad.sdk.R.id.unad_splash_appname     // Catch:{ Exception -> 0x010e }
            android.view.View r7 = r3.findViewById(r7)     // Catch:{ Exception -> 0x010e }
            android.widget.TextView r7 = (android.widget.TextView) r7     // Catch:{ Exception -> 0x010e }
            int r8 = com.unad.sdk.R.id.unad_splash_title1     // Catch:{ Exception -> 0x010e }
            android.view.View r8 = r3.findViewById(r8)     // Catch:{ Exception -> 0x010e }
            android.widget.TextView r8 = (android.widget.TextView) r8     // Catch:{ Exception -> 0x010e }
            int r9 = com.unad.sdk.R.id.unad_splash_title2     // Catch:{ Exception -> 0x010e }
            android.view.View r9 = r3.findViewById(r9)     // Catch:{ Exception -> 0x010e }
            android.widget.TextView r9 = (android.widget.TextView) r9     // Catch:{ Exception -> 0x010e }
            r4.removeAllViews()     // Catch:{ Exception -> 0x010e }
            android.app.AlertDialog$Builder r10 = new android.app.AlertDialog$Builder     // Catch:{ Exception -> 0x010e }
            android.app.Activity r11 = r13.currentActivity     // Catch:{ Exception -> 0x010e }
            int r12 = com.unad.sdk.R.style.unad_PrivacyThemeDialog2     // Catch:{ Exception -> 0x010e }
            r10.<init>(r11, r12)     // Catch:{ Exception -> 0x010e }
            r10.setView(r3)     // Catch:{ Exception -> 0x010e }
            com.unad.sdk.UNADSplash$g r3 = new com.unad.sdk.UNADSplash$g     // Catch:{ Exception -> 0x010e }
            r3.<init>(r4)     // Catch:{ Exception -> 0x010e }
            r6.setOnClickListener(r3)     // Catch:{ Exception -> 0x010e }
            int r3 = r13.logoPicture     // Catch:{ Exception -> 0x010e }
            r5.setImageResource(r3)     // Catch:{ Exception -> 0x010e }
            java.lang.String r3 = r13.appname     // Catch:{ Exception -> 0x010e }
            if (r3 == 0) goto L_0x00ad
            r7.setText(r3)     // Catch:{ Exception -> 0x010e }
        L_0x00ad:
            int r3 = r13.logoPicture     // Catch:{ Exception -> 0x010e }
            r6 = 8
            if (r3 == 0) goto L_0x00c5
            java.lang.String r3 = r13.appname     // Catch:{ Exception -> 0x010e }
            if (r3 != 0) goto L_0x00b8
            goto L_0x00c5
        L_0x00b8:
            r7.setVisibility(r1)     // Catch:{ Exception -> 0x010e }
            r5.setVisibility(r1)     // Catch:{ Exception -> 0x010e }
            r8.setVisibility(r1)     // Catch:{ Exception -> 0x010e }
            r9.setVisibility(r6)     // Catch:{ Exception -> 0x010e }
            goto L_0x00d1
        L_0x00c5:
            r7.setVisibility(r6)     // Catch:{ Exception -> 0x010e }
            r5.setVisibility(r6)     // Catch:{ Exception -> 0x010e }
            r8.setVisibility(r6)     // Catch:{ Exception -> 0x010e }
            r9.setVisibility(r1)     // Catch:{ Exception -> 0x010e }
        L_0x00d1:
            android.app.AlertDialog r3 = r13.pangleDialog     // Catch:{ Exception -> 0x010e }
            if (r3 == 0) goto L_0x00d8
            r3.dismiss()     // Catch:{ Exception -> 0x010e }
        L_0x00d8:
            android.app.AlertDialog r3 = r10.create()     // Catch:{ Exception -> 0x010e }
            r13.pangleDialog = r3     // Catch:{ Exception -> 0x010e }
            r3.setCancelable(r1)     // Catch:{ Exception -> 0x010e }
            android.app.Activity r3 = r13.currentActivity     // Catch:{ Exception -> 0x010e }
            com.bumptech.glide.RequestManager r3 = com.bumptech.glide.Glide.with((android.app.Activity) r3)     // Catch:{ Exception -> 0x010e }
            r13.mRequestManager = r3     // Catch:{ Exception -> 0x010e }
            com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeRequest r3 = new com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeRequest     // Catch:{ Exception -> 0x010e }
            r3.<init>()     // Catch:{ Exception -> 0x010e }
            boolean r5 = r13.isUpdateLogBoolean     // Catch:{ Exception -> 0x010e }
            if (r5 == 0) goto L_0x0103
            com.unad.sdk.b r6 = com.unad.sdk.b.a()     // Catch:{ Exception -> 0x010e }
            android.app.Activity r7 = r13.currentActivity     // Catch:{ Exception -> 0x010e }
            java.lang.String r8 = r13.adUnitId     // Catch:{ Exception -> 0x010e }
            boolean r9 = r13.isSdkLoad     // Catch:{ Exception -> 0x010e }
            java.lang.String r10 = "unad_pangle"
            java.lang.String r11 = "1"
            r6.a((android.content.Context) r7, (java.lang.String) r8, (boolean) r9, (java.lang.String) r10, (java.lang.String) r11)     // Catch:{ Exception -> 0x010e }
        L_0x0103:
            java.lang.String r5 = r13.loadAd     // Catch:{ Exception -> 0x010e }
            com.unad.sdk.UNADSplash$h r6 = new com.unad.sdk.UNADSplash$h     // Catch:{ Exception -> 0x010e }
            r6.<init>(r4)     // Catch:{ Exception -> 0x010e }
            com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd.loadAd(r5, r3, r6)     // Catch:{ Exception -> 0x010e }
            goto L_0x014c
        L_0x010e:
            r3 = move-exception
            boolean r4 = r13.isUpdateLogBoolean
            if (r4 == 0) goto L_0x0137
            com.unad.sdk.b r5 = com.unad.sdk.b.a()
            android.app.Activity r6 = r13.currentActivity
            java.lang.String r7 = r13.adUnitId
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r8 = "unad_pangle#"
            r4.append(r8)
            java.lang.String r8 = r3.getMessage()
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            java.lang.String r9 = "1"
            java.lang.String r10 = "unad_pangle"
            r5.b(r6, r7, r8, r9, r10)
        L_0x0137:
            r13.isLoadingAd = r1
            int r4 = r13.errorCount
            r5 = 2
            if (r4 >= r5) goto L_0x014d
            java.util.ArrayList<com.unad.sdk.dto.SourceVO> r4 = r13.adList
            int r4 = r4.size()
            if (r4 != 0) goto L_0x0147
            goto L_0x014d
        L_0x0147:
            r13.reLoadAD()
            r13.adShowType = r1
        L_0x014c:
            return
        L_0x014d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = r3.getMessage()
            r1.append(r3)
            java.lang.String r3 = ""
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r13.returnError(r0, r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unad.sdk.UNADSplash.loadUnadPangAd():void");
    }

    /* access modifiers changed from: private */
    public void onSplashAdLoaded(SplashAd splashAd, ViewGroup viewGroup) {
        splashAd.setAdInteractionListener((SplashAdInteractionListener) new a());
        splashAd.showInAdContainer(viewGroup);
    }

    /* access modifiers changed from: private */
    public void reLoadAD() {
        if (!this.isTimeOut) {
            this.isSdkLoad = true;
            int size = this.adList.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                } else if (this.sourceVO.getIndex() == this.adList.get(size).getIndex()) {
                    this.adList.remove(size);
                    break;
                } else {
                    size--;
                }
            }
            if (this.adList.size() > 0) {
                this.sourceVO = this.adList.get(0);
                this.adList.remove(0);
                sdkLoadAd();
            }
        }
    }

    /* access modifiers changed from: private */
    public void returnError(String str, String str2, String str3) {
        if (this.isReturnErrorCallbackBoolean) {
            Log.i("UNAD_SDK", "return callback ok");
            return;
        }
        setLogError(str, "code:" + str2 + ",callback:onAdFailed,", "msg:" + str3);
        if (this.isUpdateLogBoolean) {
            b.a().b(this.currentActivity, this.adUnitId, this.errorLogs, "1", str);
        }
        AlertDialog alertDialog = this.pangleDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        AlertDialog alertDialog2 = this.dialog;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd != null) {
            nativeAd.destroy();
        }
        AdViewListener adViewListener2 = this.adViewListener;
        if (adViewListener2 != null) {
            adViewListener2.onAdFailed(new AdError(str2, str3));
            this.isReturnErrorCallbackBoolean = true;
            this.errorCount = 0;
        }
    }

    private void saveLoadType(String str) {
        Application application = this.myApplication;
        if (application != null) {
            new com.unad.sdk.util.b(application.getApplicationContext()).a("splash_index", str);
        }
    }

    private void sdkLoadAd() {
        if ("google".equals(this.sourceVO.getSource())) {
            this.loadAd = this.sourceVO.getId();
            showAdIfAvailable();
        } else if ("mintegral".equals(this.sourceVO.getSource())) {
            this.loadAd = this.sourceVO.getId();
            showAdFaceBookSplash();
        } else if ("unad_pangle".equals(this.sourceVO.getSource())) {
            this.loadAd = this.sourceVO.getId();
            showUnadPangleAd();
        } else if ("pangle".equals(this.sourceVO.getSource())) {
            this.loadAd = this.sourceVO.getId();
            showPangleAd();
        } else if ("unad_bigo".equals(this.sourceVO.getSource())) {
            this.loadAd = this.sourceVO.getId();
            showUnadBigoAd();
        } else if ("bigo".equals(this.sourceVO.getSource())) {
            this.loadAd = this.sourceVO.getId();
            showBigoAd();
        } else if ("ironsource".equals(this.sourceVO.getSource())) {
            this.loadAd = this.sourceVO.getId();
            showIronsourceAd();
        } else if ("bigo_is".equals(this.sourceVO.getSource())) {
            this.loadAd = this.sourceVO.getId();
            showBigoInterstitialAd();
        } else {
            ArrayList<SourceVO> arrayList = this.adList;
            if (arrayList == null || arrayList.size() != 0) {
                if (this.isUpdateLogBoolean) {
                    b.a().b(this.currentActivity, this.adUnitId, "unadsdk# ad type error", "1", "unadsdk");
                }
                this.isLoadingAd = false;
                reLoadAD();
                this.adShowType = 0;
                return;
            }
            this.isReturnErrorCallbackBoolean = false;
            returnError("unadsdk", "-1", " ad timed out...");
        }
    }

    private void setLogError(String str, String str2, String str3) {
        this.errorLogs = str + "#" + str2 + "#" + str3;
    }

    /* access modifiers changed from: private */
    public void setUnadBigoListener(NativeAd nativeAd) {
        nativeAd.setAdInteractionListener(new d());
    }

    private void showAdFaceBookSplash() {
        int i2 = this.skipType;
        if (i2 == 1) {
            showFacebookeInsertAd();
        } else if (i2 == 2) {
            showFacebookeNativeAd();
        }
    }

    private void showAdIfAvailable() {
        Activity activity;
        try {
            int i2 = this.skipType;
            if (i2 == 1) {
                fetchAd();
            } else if (i2 == 2 && (activity = this.currentActivity) != null && !activity.isFinishing() && this.isUpdateLogBoolean) {
                b.a().a((Context) this.currentActivity, this.adUnitId, this.isSdkLoad, "google", "1");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            this.isLoadingAd = false;
            if (this.errorCount >= 2 || this.adList.size() == 0) {
                returnError("unadsdk", "-1", e2.toString() + "");
                return;
            }
            reLoadAD();
            this.adShowType = 0;
        }
    }

    private void showBigoAd() {
        this.bigoType = 2;
        this.unadbigoTime = 0;
        if (UNAD.BIGO_INIT_BOOLEAN) {
            loadBigoAd();
            return;
        }
        this.unadBigohandler.removeCallbacks(this.unadBigoRunnable);
        this.unadBigohandler.postDelayed(this.unadBigoRunnable, 500);
    }

    private void showBigoInterstitialAd() {
        this.bigoIsTime = 0;
        if (UNAD.BIGO_INIT_BOOLEAN) {
            loadBigoInterstitialAd();
            return;
        }
        this.bigoIshandler.removeCallbacks(this.bigoIsRunnable);
        this.bigoIshandler.postDelayed(this.bigoIsRunnable, 200);
    }

    private void showFacebookeInsertAd() {
        loadFacebookeInsertAd();
    }

    private void showFacebookeNativeAd() {
        if (this.currentActivity != null && this.adVO != null) {
            if (this.isUpdateLogBoolean) {
                b.a().a((Context) this.currentActivity, this.adUnitId, this.isSdkLoad, "mopub", "1");
            }
            FBSplashView.a(this.currentActivity, Integer.valueOf(this.durationTime), Integer.valueOf(this.backgroundPicture), Integer.valueOf(this.logoPicture), new o(), this.loadAd);
        }
    }

    /* access modifiers changed from: private */
    public void showGoogleDialog() {
        try {
            this.appOpenAd.setFullScreenContentCallback(new p());
            if (!this.isTimeOut) {
                this.appOpenAd.show(this.currentActivity);
            } else if (UNAD.ISOPENTAG) {
                Log.i("UNAD_SDK", "time out...2");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.isUpdateLogBoolean) {
                b a2 = b.a();
                Activity activity = this.currentActivity;
                String str = this.adUnitId;
                a2.b(activity, str, "unadsdk#google is show error" + e2.getMessage(), "1", "unadsdk");
            }
            returnError("unadsdk", "-1", "show error");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d5 A[Catch:{ Exception -> 0x0139 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ea A[Catch:{ Exception -> 0x0139 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ff A[Catch:{ Exception -> 0x0139 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void showIronsourceAd() {
        /*
            r12 = this;
            android.app.Activity r0 = r12.currentActivity
            java.lang.String r1 = "unadsdk"
            java.lang.String r2 = "-1"
            if (r0 != 0) goto L_0x000e
            java.lang.String r0 = "activity is null"
            r12.returnError(r1, r2, r0)
            return
        L_0x000e:
            com.unad.sdk.dto.AdList r0 = r12.adVO
            if (r0 != 0) goto L_0x0018
            java.lang.String r0 = "advo is null"
            r12.returnError(r1, r2, r0)
            return
        L_0x0018:
            java.lang.String r0 = r12.loadAd
            if (r0 != 0) goto L_0x0022
            java.lang.String r0 = "adid is null"
            r12.returnError(r1, r2, r0)
            return
        L_0x0022:
            java.lang.String r0 = "unad_bigo"
            r12.errortypeTag = r0
            r0 = 0
            android.app.AlertDialog r1 = r12.pangleDialog     // Catch:{ Exception -> 0x0139 }
            if (r1 == 0) goto L_0x002e
            r1.dismiss()     // Catch:{ Exception -> 0x0139 }
        L_0x002e:
            java.util.Date r1 = new java.util.Date     // Catch:{ Exception -> 0x0139 }
            r1.<init>()     // Catch:{ Exception -> 0x0139 }
            long r3 = r1.getTime()     // Catch:{ Exception -> 0x0139 }
            loadTime = r3     // Catch:{ Exception -> 0x0139 }
            android.app.Activity r1 = r12.currentActivity     // Catch:{ Exception -> 0x0139 }
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r1)     // Catch:{ Exception -> 0x0139 }
            int r3 = com.unad.sdk.R.layout.unad_pangle_ad_container     // Catch:{ Exception -> 0x0139 }
            r4 = 0
            android.view.View r1 = r1.inflate(r3, r4)     // Catch:{ Exception -> 0x0139 }
            int r3 = com.unad.sdk.R.id.unad_ad_container     // Catch:{ Exception -> 0x0139 }
            android.view.View r3 = r1.findViewById(r3)     // Catch:{ Exception -> 0x0139 }
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3     // Catch:{ Exception -> 0x0139 }
            int r4 = com.unad.sdk.R.id.unad_logo     // Catch:{ Exception -> 0x0139 }
            android.view.View r4 = r1.findViewById(r4)     // Catch:{ Exception -> 0x0139 }
            android.widget.ImageView r4 = (android.widget.ImageView) r4     // Catch:{ Exception -> 0x0139 }
            int r5 = com.unad.sdk.R.id.unad_progressBar     // Catch:{ Exception -> 0x0139 }
            android.view.View r5 = r1.findViewById(r5)     // Catch:{ Exception -> 0x0139 }
            android.widget.ProgressBar r5 = (android.widget.ProgressBar) r5     // Catch:{ Exception -> 0x0139 }
            r12.unad_progressBar = r5     // Catch:{ Exception -> 0x0139 }
            int r5 = com.unad.sdk.R.id.unad_splash_close     // Catch:{ Exception -> 0x0139 }
            android.view.View r5 = r1.findViewById(r5)     // Catch:{ Exception -> 0x0139 }
            android.widget.ImageView r5 = (android.widget.ImageView) r5     // Catch:{ Exception -> 0x0139 }
            r12.unad_splash_close = r5     // Catch:{ Exception -> 0x0139 }
            int r5 = com.unad.sdk.R.id.unad_top_rl     // Catch:{ Exception -> 0x0139 }
            android.view.View r5 = r1.findViewById(r5)     // Catch:{ Exception -> 0x0139 }
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5     // Catch:{ Exception -> 0x0139 }
            int r6 = com.unad.sdk.R.id.unad_splash_appname     // Catch:{ Exception -> 0x0139 }
            android.view.View r6 = r1.findViewById(r6)     // Catch:{ Exception -> 0x0139 }
            android.widget.TextView r6 = (android.widget.TextView) r6     // Catch:{ Exception -> 0x0139 }
            int r7 = com.unad.sdk.R.id.unad_splash_title1     // Catch:{ Exception -> 0x0139 }
            android.view.View r7 = r1.findViewById(r7)     // Catch:{ Exception -> 0x0139 }
            android.widget.TextView r7 = (android.widget.TextView) r7     // Catch:{ Exception -> 0x0139 }
            int r8 = com.unad.sdk.R.id.unad_splash_title2     // Catch:{ Exception -> 0x0139 }
            android.view.View r8 = r1.findViewById(r8)     // Catch:{ Exception -> 0x0139 }
            android.widget.TextView r8 = (android.widget.TextView) r8     // Catch:{ Exception -> 0x0139 }
            r3.removeAllViews()     // Catch:{ Exception -> 0x0139 }
            android.app.AlertDialog$Builder r9 = new android.app.AlertDialog$Builder     // Catch:{ Exception -> 0x0139 }
            android.app.Activity r10 = r12.currentActivity     // Catch:{ Exception -> 0x0139 }
            int r11 = com.unad.sdk.R.style.unad_PrivacyThemeDialog2     // Catch:{ Exception -> 0x0139 }
            r9.<init>(r10, r11)     // Catch:{ Exception -> 0x0139 }
            r9.setView(r1)     // Catch:{ Exception -> 0x0139 }
            com.unad.sdk.UNADSplash$r r1 = new com.unad.sdk.UNADSplash$r     // Catch:{ Exception -> 0x0139 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x0139 }
            r5.setOnClickListener(r1)     // Catch:{ Exception -> 0x0139 }
            int r1 = r12.logoPicture     // Catch:{ Exception -> 0x0139 }
            r4.setImageResource(r1)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r1 = r12.appname     // Catch:{ Exception -> 0x0139 }
            if (r1 == 0) goto L_0x00ad
            r6.setText(r1)     // Catch:{ Exception -> 0x0139 }
        L_0x00ad:
            int r1 = r12.logoPicture     // Catch:{ Exception -> 0x0139 }
            r5 = 8
            if (r1 == 0) goto L_0x00c5
            java.lang.String r1 = r12.appname     // Catch:{ Exception -> 0x0139 }
            if (r1 != 0) goto L_0x00b8
            goto L_0x00c5
        L_0x00b8:
            r6.setVisibility(r0)     // Catch:{ Exception -> 0x0139 }
            r4.setVisibility(r0)     // Catch:{ Exception -> 0x0139 }
            r7.setVisibility(r0)     // Catch:{ Exception -> 0x0139 }
            r8.setVisibility(r5)     // Catch:{ Exception -> 0x0139 }
            goto L_0x00d1
        L_0x00c5:
            r6.setVisibility(r5)     // Catch:{ Exception -> 0x0139 }
            r4.setVisibility(r5)     // Catch:{ Exception -> 0x0139 }
            r7.setVisibility(r5)     // Catch:{ Exception -> 0x0139 }
            r8.setVisibility(r0)     // Catch:{ Exception -> 0x0139 }
        L_0x00d1:
            android.app.AlertDialog r1 = r12.pangleDialog     // Catch:{ Exception -> 0x0139 }
            if (r1 == 0) goto L_0x00d8
            r1.dismiss()     // Catch:{ Exception -> 0x0139 }
        L_0x00d8:
            android.app.AlertDialog r1 = r9.create()     // Catch:{ Exception -> 0x0139 }
            r12.pangleDialog = r1     // Catch:{ Exception -> 0x0139 }
            r1.setCancelable(r0)     // Catch:{ Exception -> 0x0139 }
            android.app.Activity r1 = r12.currentActivity     // Catch:{ Exception -> 0x0139 }
            com.ironsource.mediationsdk.IronSource.onPause(r1)     // Catch:{ Exception -> 0x0139 }
            boolean r1 = r12.isUpdateLogBoolean     // Catch:{ Exception -> 0x0139 }
            if (r1 == 0) goto L_0x00fb
            com.unad.sdk.b r4 = com.unad.sdk.b.a()     // Catch:{ Exception -> 0x0139 }
            android.app.Activity r5 = r12.currentActivity     // Catch:{ Exception -> 0x0139 }
            java.lang.String r6 = r12.adUnitId     // Catch:{ Exception -> 0x0139 }
            boolean r7 = r12.isSdkLoad     // Catch:{ Exception -> 0x0139 }
            java.lang.String r8 = "ironsource"
            java.lang.String r9 = "1"
            r4.a((android.content.Context) r5, (java.lang.String) r6, (boolean) r7, (java.lang.String) r8, (java.lang.String) r9)     // Catch:{ Exception -> 0x0139 }
        L_0x00fb:
            com.ironsource.mediationsdk.IronSourceBannerLayout r1 = r12.banner     // Catch:{ Exception -> 0x0139 }
            if (r1 == 0) goto L_0x0102
            com.ironsource.mediationsdk.IronSource.destroyBanner(r1)     // Catch:{ Exception -> 0x0139 }
        L_0x0102:
            r3.removeAllViews()     // Catch:{ Exception -> 0x0139 }
            android.app.Activity r1 = r12.currentActivity     // Catch:{ Exception -> 0x0139 }
            java.lang.String r4 = r12.loadAd     // Catch:{ Exception -> 0x0139 }
            r5 = 1
            com.ironsource.mediationsdk.IronSource$AD_UNIT[] r5 = new com.ironsource.mediationsdk.IronSource.AD_UNIT[r5]     // Catch:{ Exception -> 0x0139 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r6 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ Exception -> 0x0139 }
            r5[r0] = r6     // Catch:{ Exception -> 0x0139 }
            com.ironsource.mediationsdk.IronSource.init((android.app.Activity) r1, (java.lang.String) r4, (com.ironsource.mediationsdk.IronSource.AD_UNIT[]) r5)     // Catch:{ Exception -> 0x0139 }
            android.app.Activity r1 = r12.currentActivity     // Catch:{ Exception -> 0x0139 }
            com.ironsource.mediationsdk.ISBannerSize r4 = com.ironsource.mediationsdk.ISBannerSize.RECTANGLE     // Catch:{ Exception -> 0x0139 }
            com.ironsource.mediationsdk.IronSourceBannerLayout r1 = com.ironsource.mediationsdk.IronSource.createBanner(r1, r4)     // Catch:{ Exception -> 0x0139 }
            r12.banner = r1     // Catch:{ Exception -> 0x0139 }
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams     // Catch:{ Exception -> 0x0139 }
            r4 = -1
            r5 = -2
            r1.<init>(r4, r5)     // Catch:{ Exception -> 0x0139 }
            com.ironsource.mediationsdk.IronSourceBannerLayout r4 = r12.banner     // Catch:{ Exception -> 0x0139 }
            r3.addView(r4, r0, r1)     // Catch:{ Exception -> 0x0139 }
            com.ironsource.mediationsdk.IronSourceBannerLayout r1 = r12.banner     // Catch:{ Exception -> 0x0139 }
            com.unad.sdk.UNADSplash$s r4 = new com.unad.sdk.UNADSplash$s     // Catch:{ Exception -> 0x0139 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0139 }
            r1.setBannerListener(r4)     // Catch:{ Exception -> 0x0139 }
            com.ironsource.mediationsdk.IronSourceBannerLayout r1 = r12.banner     // Catch:{ Exception -> 0x0139 }
            com.ironsource.mediationsdk.IronSource.loadBanner(r1)     // Catch:{ Exception -> 0x0139 }
            goto L_0x0177
        L_0x0139:
            r1 = move-exception
            boolean r3 = r12.isUpdateLogBoolean
            if (r3 == 0) goto L_0x0162
            com.unad.sdk.b r4 = com.unad.sdk.b.a()
            android.app.Activity r5 = r12.currentActivity
            java.lang.String r6 = r12.adUnitId
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r7 = "unadsdk#"
            r3.append(r7)
            java.lang.String r7 = r1.getMessage()
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            java.lang.String r8 = "1"
            java.lang.String r9 = "unad_bigo"
            r4.b(r5, r6, r7, r8, r9)
        L_0x0162:
            r12.isLoadingAd = r0
            int r3 = r12.errorCount
            r4 = 2
            if (r3 >= r4) goto L_0x0178
            java.util.ArrayList<com.unad.sdk.dto.SourceVO> r3 = r12.adList
            int r3 = r3.size()
            if (r3 != 0) goto L_0x0172
            goto L_0x0178
        L_0x0172:
            r12.reLoadAD()
            r12.adShowType = r0
        L_0x0177:
            return
        L_0x0178:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r1.getMessage()
            r0.append(r1)
            java.lang.String r1 = ""
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ironsource"
            r12.returnError(r1, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unad.sdk.UNADSplash.showIronsourceAd():void");
    }

    private void showPangleAd() {
        pangleType = 2;
        this.pangleTime = 0;
        if (UNAD.PANGLE_INIT_BOOLEAN) {
            loadPangAd();
            return;
        }
        this.panglehandler.removeCallbacks(this.pangleRunnable);
        this.panglehandler.postDelayed(this.pangleRunnable, 200);
    }

    /* access modifiers changed from: private */
    public void showPangleDialog() {
        AlertDialog alertDialog;
        try {
            Activity activity = this.currentActivity;
            if (activity != null && !activity.isFinishing() && (alertDialog = this.pangleDialog) != null) {
                alertDialog.show();
                this.panglehandler.postDelayed(this.progressbarRunnable, 3000);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.isUpdateLogBoolean) {
                b a2 = b.a();
                Activity activity2 = this.currentActivity;
                String str = this.adUnitId;
                a2.b(activity2, str, "unadsdk#" + e2.getMessage(), "1", "unadsdk");
            }
            this.isLoadingAd = false;
            if (this.errorCount >= 2 || this.adList.size() == 0) {
                returnError("unadsdk", "-1", e2.getMessage() + "");
                return;
            }
            reLoadAD();
            this.adShowType = 0;
        }
    }

    private void showUnadBigoAd() {
        this.bigoType = 1;
        this.unadbigoTime = 0;
        if (UNAD.BIGO_INIT_BOOLEAN) {
            loadUnadBigoAd();
            return;
        }
        this.unadBigohandler.removeCallbacks(this.unadBigoRunnable);
        this.unadBigohandler.postDelayed(this.unadBigoRunnable, 500);
    }

    private void showUnadPangleAd() {
        pangleType = 1;
        this.pangleTime = 0;
        if (UNAD.PANGLE_INIT_BOOLEAN) {
            loadUnadPangAd();
            return;
        }
        this.panglehandler.removeCallbacks(this.pangleRunnable);
        this.panglehandler.postDelayed(this.pangleRunnable, 200);
    }

    /* access modifiers changed from: private */
    public void startInitAd() {
        this.countTime = 0;
        this.isShowAd = true;
        this.isReturnErrorCallbackBoolean = false;
        this.timeOuthandler.removeCallbacks(this.timeOutRunnable);
        this.timeOuthandler.postDelayed(this.timeOutRunnable, 1000);
    }

    private void startloadAd() {
        if (!this.isRun) {
            return;
        }
        if (!UNAD.isInitSuccess()) {
            this.handler.removeCallbacks(this.runnable);
            this.handler.postDelayed(this.runnable, 50);
            return;
        }
        startInitAd();
        loadAdGoAd();
    }

    private boolean wasLoadTimeLessThanNHoursAgo(long j2) {
        return new Date().getTime() - this.googleloadTime < j2 * 3600000;
    }

    /* access modifiers changed from: package-private */
    public void handleNativeAd(NativeAd nativeAd, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.unad_splash_bigo_native, viewGroup, true);
        TextView textView = (TextView) inflate.findViewById(R.id.native_title);
        textView.setTag(2);
        textView.setText(nativeAd.getTitle());
        TextView textView2 = (TextView) inflate.findViewById(R.id.native_description);
        textView2.setTag(6);
        textView2.setText(nativeAd.getDescription());
        Button button = (Button) inflate.findViewById(R.id.native_cta);
        button.setTag(7);
        button.setText(nativeAd.getCallToAction());
        TextView textView3 = (TextView) inflate.findViewById(R.id.native_warning);
        textView3.setTag(8);
        textView3.setText(nativeAd.getWarning());
        View[] viewArr = {textView, textView2, button};
        nativeAd.registerViewForInteraction((NativeAdView) inflate.findViewById(R.id.native_ad_view), (MediaView) inflate.findViewById(R.id.native_media_view), (AdIconView) inflate.findViewById(R.id.native_icon_view), (AdOptionsView) inflate.findViewById(R.id.native_option_view), (List<View>) Arrays.asList(viewArr));
    }

    public boolean isAppOnForeground(Context context) {
        if (context == null) {
            return false;
        }
        String packageName = context.getPackageName();
        List<ActivityManager.RecentTaskInfo> recentTasks = ((ActivityManager) context.getSystemService("activity")).getRecentTasks(Integer.MAX_VALUE, 1);
        if (recentTasks != null && recentTasks.get(0).baseIntent.toString().contains(packageName)) {
            return true;
        }
        return false;
    }

    public void loadAd(Activity activity) {
        this.bigoIsTime = 0;
        this.isTimeOut = false;
        this.isSdkLoad = false;
        this.currentActivity = activity;
        loadTime = 0;
        this.isRun = true;
        this.errorCount = 0;
        startloadAd();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity != null) {
            this.activitysMap.put(activity.getComponentName().getClassName(), "");
        }
    }

    public void onActivityDestroyed(Activity activity) {
        HashMap<String, String> hashMap;
        if (!(activity == null || (hashMap = this.activitysMap) == null)) {
            hashMap.remove(activity.getComponentName().getClassName());
        }
        if (this.activitysMap.size() == 0) {
            loadTime = 0;
        }
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        this.currentActivity = activity;
    }

    public void onActivityStopped(Activity activity) {
    }

    /* access modifiers changed from: protected */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onMoveToForeground() {
        if (this.currentActivity != null && loadTime != 0 && this.isRun && this.second != 0 && (new Date().getTime() - loadTime) / 1000 > ((long) this.second)) {
            AlertDialog alertDialog = this.pangleDialog;
            if (alertDialog == null || !alertDialog.isShowing()) {
                AlertDialog alertDialog2 = this.dialog;
                if (alertDialog2 == null || !alertDialog2.isShowing()) {
                    this.isTimeOut = false;
                    this.errorCount = 0;
                    this.isSdkLoad = true;
                    startInitAd();
                    loadAdGoAd();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
    }

    public void setAdUnitId(String str) {
        this.adUnitId = str;
    }

    public void setAdViewListener(AdViewListener adViewListener2) {
        this.adViewListener = adViewListener2;
    }

    public void setAppName(String str) {
        this.appname = str;
    }

    public void setBackgroundPicture(int i2) {
        this.backgroundPicture = i2;
    }

    public void setDurationTime(int i2) {
        if (i2 > 3) {
            this.durationTime = i2;
        }
    }

    public void setIntervals(int i2) {
        this.second = i2;
    }

    public void setLogoPicture(int i2) {
        this.logoPicture = i2;
    }

    public void setSkipButtonType(SKIPTYPE skiptype) {
    }

    public void setTimeoutTime(int i2) {
        if (i2 > 3) {
            this.timeoutTime = i2;
        }
    }

    public void showPangLeAdIfAvailable(PAGAppOpenAd pAGAppOpenAd) {
        pAGAppOpenAd.setAdInteractionListener(new f());
        pAGAppOpenAd.show(this.currentActivity);
    }
}
