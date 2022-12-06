package com.vungle.warren;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.vungle.warren.AdConfig;
import com.vungle.warren.PresentationFactory;
import com.vungle.warren.analytics.JobDelegateAnalytics;
import com.vungle.warren.downloader.DownloadRequest;
import com.vungle.warren.downloader.Downloader;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.AdAsset;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.Placement;
import com.vungle.warren.model.SessionData;
import com.vungle.warren.omsdk.OMTracker;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.session.SessionAttribute;
import com.vungle.warren.session.SessionEvent;
import com.vungle.warren.tasks.JobRunner;
import com.vungle.warren.ui.CloseDelegate;
import com.vungle.warren.ui.JavascriptBridge;
import com.vungle.warren.ui.OrientationDelegate;
import com.vungle.warren.ui.contract.AdContract;
import com.vungle.warren.ui.contract.NativeAdContract;
import com.vungle.warren.ui.contract.WebAdContract;
import com.vungle.warren.ui.presenter.LocalAdPresenter;
import com.vungle.warren.ui.presenter.MRAIDAdPresenter;
import com.vungle.warren.ui.presenter.NativeAdPresenter;
import com.vungle.warren.ui.state.OptionsState;
import com.vungle.warren.ui.view.FullAdWidget;
import com.vungle.warren.ui.view.LocalAdView;
import com.vungle.warren.ui.view.MRAIDAdView;
import com.vungle.warren.ui.view.NativeAdView;
import com.vungle.warren.ui.view.VungleWebClient;
import com.vungle.warren.utility.Executors;
import com.vungle.warren.utility.HandlerScheduler;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

public class AdvertisementPresentationFactory implements PresentationFactory {
    private static final String EXTRA_ADVERTISEMENT = "ADV_FACTORY_ADVERTISEMENT";
    /* access modifiers changed from: private */
    public static final String TAG = AdvertisementPresentationFactory.class.getSimpleName();
    private final AdLoader adLoader;
    private VungleApiClient apiClient;
    /* access modifiers changed from: private */
    public Advertisement currentAdvertisement;
    private final JobRunner jobRunner;
    private final OMTracker.Factory omTrackerFactory;
    private BaseTask.OnModelLoadListener onModelLoadListener = new BaseTask.OnModelLoadListener() {
        public void onLoad(Advertisement advertisement, Placement placement) {
            Advertisement unused = AdvertisementPresentationFactory.this.currentAdvertisement = advertisement;
        }
    };
    private Repository repository;
    private BaseTask task;
    private final ExecutorService taskExecutor;
    private VungleStaticApi vungleStaticApi;

    AdvertisementPresentationFactory(AdLoader adLoader2, VungleStaticApi vungleStaticApi2, Repository repository2, VungleApiClient vungleApiClient, JobRunner jobRunner2, OMTracker.Factory factory, ExecutorService executorService) {
        this.vungleStaticApi = vungleStaticApi2;
        this.repository = repository2;
        this.apiClient = vungleApiClient;
        this.jobRunner = jobRunner2;
        this.adLoader = adLoader2;
        this.omTrackerFactory = factory;
        this.taskExecutor = executorService;
    }

    public void getFullScreenPresentation(Context context, AdRequest adRequest, FullAdWidget fullAdWidget, OptionsState optionsState, CloseDelegate closeDelegate, OrientationDelegate orientationDelegate, Bundle bundle, PresentationFactory.FullScreenCallback fullScreenCallback) {
        cancelTask();
        AdLoader adLoader2 = this.adLoader;
        Repository repository2 = this.repository;
        VungleStaticApi vungleStaticApi2 = this.vungleStaticApi;
        JobRunner jobRunner2 = this.jobRunner;
        VungleApiClient vungleApiClient = this.apiClient;
        BaseTask.OnModelLoadListener onModelLoadListener2 = this.onModelLoadListener;
        OMTracker.Factory factory = this.omTrackerFactory;
        FullScreenPresentationTask fullScreenPresentationTask = r1;
        FullScreenPresentationTask fullScreenPresentationTask2 = new FullScreenPresentationTask(context, adLoader2, adRequest, repository2, vungleStaticApi2, jobRunner2, vungleApiClient, fullAdWidget, optionsState, orientationDelegate, closeDelegate, fullScreenCallback, onModelLoadListener2, bundle, factory);
        FullScreenPresentationTask fullScreenPresentationTask3 = fullScreenPresentationTask;
        this.task = fullScreenPresentationTask3;
        this.task.executeOnExecutor(this.taskExecutor, new Void[0]);
    }

    private void cancelTask() {
        BaseTask baseTask = this.task;
        if (baseTask != null) {
            baseTask.cancel(true);
            this.task.clear();
        }
    }

    public void getBannerViewPresentation(Context context, AdRequest adRequest, AdConfig adConfig, CloseDelegate closeDelegate, PresentationFactory.ViewCallback viewCallback) {
        cancelTask();
        this.task = new BannerViewPresentationTask(context, adRequest, adConfig, this.adLoader, this.repository, this.vungleStaticApi, this.jobRunner, viewCallback, (Bundle) null, this.onModelLoadListener, this.apiClient, this.omTrackerFactory);
        this.task.executeOnExecutor(this.taskExecutor, new Void[0]);
    }

    public void getNativeViewPresentation(Context context, NativeAdLayout nativeAdLayout, AdRequest adRequest, AdConfig adConfig, PresentationFactory.NativeViewCallback nativeViewCallback) {
        cancelTask();
        this.task = new NativeViewPresentationTask(context, nativeAdLayout, adRequest, adConfig, this.adLoader, this.repository, this.vungleStaticApi, this.jobRunner, nativeViewCallback, (Bundle) null, this.onModelLoadListener);
        this.task.executeOnExecutor(this.taskExecutor, new Void[0]);
    }

    public void saveState(Bundle bundle) {
        Advertisement advertisement = this.currentAdvertisement;
        bundle.putString(EXTRA_ADVERTISEMENT, advertisement == null ? null : advertisement.getId());
    }

    public void destroy() {
        cancelTask();
    }

    private static class PresentationResultHolder {
        /* access modifiers changed from: private */
        public AdContract.AdView adView;
        /* access modifiers changed from: private */
        public AdContract.AdvertisementPresenter advertisementPresenter;
        /* access modifiers changed from: private */
        public VungleException exception;
        /* access modifiers changed from: private */
        public VungleWebClient webClient;

        PresentationResultHolder(VungleException vungleException) {
            this.exception = vungleException;
        }

        PresentationResultHolder(AdContract.AdView adView2, AdContract.AdvertisementPresenter advertisementPresenter2, VungleWebClient vungleWebClient) {
            this.adView = adView2;
            this.advertisementPresenter = advertisementPresenter2;
            this.webClient = vungleWebClient;
        }
    }

    private static class FullScreenPresentationTask extends BaseTask {
        private final AdLoader adLoader;
        private Advertisement advertisement;
        private final VungleApiClient apiClient;
        private final CloseDelegate closeDelegate;
        private Context context;
        private FullAdWidget fullAdWidget;
        private final PresentationFactory.FullScreenCallback fullscreenCallback;
        private final JobRunner jobRunner;
        private final OMTracker.Factory omTrackerFactory;
        private final OptionsState optionsState;
        private final OrientationDelegate orientationDelegate;
        private final AdRequest request;
        private final Bundle savedState;

        FullScreenPresentationTask(Context context2, AdLoader adLoader2, AdRequest adRequest, Repository repository, VungleStaticApi vungleStaticApi, JobRunner jobRunner2, VungleApiClient vungleApiClient, FullAdWidget fullAdWidget2, OptionsState optionsState2, OrientationDelegate orientationDelegate2, CloseDelegate closeDelegate2, PresentationFactory.FullScreenCallback fullScreenCallback, BaseTask.OnModelLoadListener onModelLoadListener, Bundle bundle, OMTracker.Factory factory) {
            super(repository, vungleStaticApi, onModelLoadListener);
            this.request = adRequest;
            this.fullAdWidget = fullAdWidget2;
            this.optionsState = optionsState2;
            this.context = context2;
            this.fullscreenCallback = fullScreenCallback;
            this.savedState = bundle;
            this.jobRunner = jobRunner2;
            this.apiClient = vungleApiClient;
            this.orientationDelegate = orientationDelegate2;
            this.closeDelegate = closeDelegate2;
            this.adLoader = adLoader2;
            this.omTrackerFactory = factory;
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            super.clear();
            this.context = null;
            this.fullAdWidget = null;
        }

        /* access modifiers changed from: protected */
        public PresentationResultHolder doInBackground(Void... voidArr) {
            try {
                Pair<Advertisement, Placement> loadPresentationData = loadPresentationData(this.request, this.savedState);
                this.advertisement = (Advertisement) loadPresentationData.first;
                Placement placement = (Placement) loadPresentationData.second;
                if (!this.adLoader.canRenderAd(this.advertisement)) {
                    Log.e(AdvertisementPresentationFactory.TAG, "Advertisement is null or assets are missing");
                    return new PresentationResultHolder(new VungleException(10));
                } else if (placement.getPlacementAdType() == 4) {
                    return new PresentationResultHolder(new VungleException(41));
                } else {
                    if (placement.getPlacementAdType() != 0) {
                        return new PresentationResultHolder(new VungleException(29));
                    }
                    JobDelegateAnalytics jobDelegateAnalytics = new JobDelegateAnalytics(this.jobRunner);
                    Cookie cookie = this.repository.load("appId", Cookie.class).get();
                    if (cookie != null && !TextUtils.isEmpty(cookie.getString("appId"))) {
                        cookie.getString("appId");
                    }
                    Cookie cookie2 = this.repository.load(Cookie.CONFIG_COOKIE, Cookie.class).get();
                    boolean z = false;
                    if ((cookie2 != null && cookie2.getBoolean("isAdDownloadOptEnabled").booleanValue()) && !this.advertisement.assetsFullyDownloaded) {
                        List<AdAsset> loadAllAdAssetByStatus = this.repository.loadAllAdAssetByStatus(this.advertisement.getId(), 3);
                        if (!loadAllAdAssetByStatus.isEmpty()) {
                            this.advertisement.updateMRAIDTokensFromAssetDB(loadAllAdAssetByStatus);
                            try {
                                this.repository.save(this.advertisement);
                            } catch (DatabaseHelper.DBException unused) {
                                Log.e(AdvertisementPresentationFactory.TAG, "Unable to update tokens");
                            }
                        }
                    }
                    VungleWebClient vungleWebClient = new VungleWebClient(this.advertisement, placement, ((Executors) ServiceLocator.getInstance(this.context).getService(Executors.class)).getOffloadExecutor());
                    File file = this.repository.getAdvertisementAssetDirectory(this.advertisement.getId()).get();
                    if (file == null || !file.isDirectory()) {
                        Log.e(AdvertisementPresentationFactory.TAG, "Advertisement assets dir is missing");
                        return new PresentationResultHolder(new VungleException(26));
                    }
                    int adType = this.advertisement.getAdType();
                    if (adType == 0) {
                        return new PresentationResultHolder(new LocalAdView(this.context, this.fullAdWidget, this.orientationDelegate, this.closeDelegate), new LocalAdPresenter(this.advertisement, placement, this.repository, new HandlerScheduler(), jobDelegateAnalytics, vungleWebClient, this.optionsState, file, this.request.getImpression()), vungleWebClient);
                    } else if (adType != 1) {
                        return new PresentationResultHolder(new VungleException(10));
                    } else {
                        OMTracker.Factory factory = this.omTrackerFactory;
                        if (this.apiClient.getOmEnabled() && this.advertisement.getOmEnabled()) {
                            z = true;
                        }
                        OMTracker make = factory.make(z);
                        vungleWebClient.setWebViewObserver(make);
                        return new PresentationResultHolder(new MRAIDAdView(this.context, this.fullAdWidget, this.orientationDelegate, this.closeDelegate), new MRAIDAdPresenter(this.advertisement, placement, this.repository, new HandlerScheduler(), jobDelegateAnalytics, vungleWebClient, this.optionsState, file, make, this.request.getImpression()), vungleWebClient);
                    }
                }
            } catch (VungleException e) {
                return new PresentationResultHolder(e);
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(PresentationResultHolder presentationResultHolder) {
            super.onPostExecute(presentationResultHolder);
            if (!isCancelled() && this.fullscreenCallback != null) {
                if (presentationResultHolder.exception != null) {
                    Log.e(AdvertisementPresentationFactory.TAG, "Exception on creating presenter", presentationResultHolder.exception);
                    this.fullscreenCallback.onResult(new Pair((Object) null, (Object) null), presentationResultHolder.exception);
                    return;
                }
                this.fullAdWidget.linkWebView(presentationResultHolder.webClient, new JavascriptBridge(presentationResultHolder.advertisementPresenter));
                this.fullscreenCallback.onResult(new Pair(presentationResultHolder.adView, presentationResultHolder.advertisementPresenter), presentationResultHolder.exception);
            }
        }
    }

    private static class BannerViewPresentationTask extends BaseTask {
        private final AdConfig adConfig;
        private final AdLoader adLoader;
        private final VungleApiClient apiClient;
        private Context context;
        private final JobRunner jobRunner;
        private final OMTracker.Factory omTrackerFactory;
        private final AdRequest request;
        private final Bundle savedState;
        private final PresentationFactory.ViewCallback viewCallback;

        BannerViewPresentationTask(Context context2, AdRequest adRequest, AdConfig adConfig2, AdLoader adLoader2, Repository repository, VungleStaticApi vungleStaticApi, JobRunner jobRunner2, PresentationFactory.ViewCallback viewCallback2, Bundle bundle, BaseTask.OnModelLoadListener onModelLoadListener, VungleApiClient vungleApiClient, OMTracker.Factory factory) {
            super(repository, vungleStaticApi, onModelLoadListener);
            this.context = context2;
            this.request = adRequest;
            this.adConfig = adConfig2;
            this.viewCallback = viewCallback2;
            this.savedState = bundle;
            this.jobRunner = jobRunner2;
            this.adLoader = adLoader2;
            this.apiClient = vungleApiClient;
            this.omTrackerFactory = factory;
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            super.clear();
            this.context = null;
        }

        /* access modifiers changed from: protected */
        public PresentationResultHolder doInBackground(Void... voidArr) {
            try {
                Pair<Advertisement, Placement> loadPresentationData = loadPresentationData(this.request, this.savedState);
                Advertisement advertisement = (Advertisement) loadPresentationData.first;
                boolean z = true;
                if (advertisement.getAdType() != 1) {
                    Log.e(AdvertisementPresentationFactory.TAG, "Invalid Ad Type for Native Ad.");
                    return new PresentationResultHolder(new VungleException(10));
                }
                Placement placement = (Placement) loadPresentationData.second;
                if (!this.adLoader.canPlayAd(advertisement)) {
                    Log.e(AdvertisementPresentationFactory.TAG, "Advertisement is null or assets are missing");
                    return new PresentationResultHolder(new VungleException(10));
                }
                Cookie cookie = this.repository.load(Cookie.CONFIG_COOKIE, Cookie.class).get();
                if ((cookie != null && cookie.getBoolean("isAdDownloadOptEnabled").booleanValue()) && !advertisement.assetsFullyDownloaded) {
                    List<AdAsset> loadAllAdAssetByStatus = this.repository.loadAllAdAssetByStatus(advertisement.getId(), 3);
                    if (!loadAllAdAssetByStatus.isEmpty()) {
                        advertisement.updateMRAIDTokensFromAssetDB(loadAllAdAssetByStatus);
                        try {
                            this.repository.save(advertisement);
                        } catch (DatabaseHelper.DBException unused) {
                            Log.e(AdvertisementPresentationFactory.TAG, "Unable to update tokens");
                        }
                    }
                }
                JobDelegateAnalytics jobDelegateAnalytics = new JobDelegateAnalytics(this.jobRunner);
                VungleWebClient vungleWebClient = new VungleWebClient(advertisement, placement, ((Executors) ServiceLocator.getInstance(this.context).getService(Executors.class)).getOffloadExecutor());
                File file = this.repository.getAdvertisementAssetDirectory(advertisement.getId()).get();
                if (file == null || !file.isDirectory()) {
                    Log.e(AdvertisementPresentationFactory.TAG, "Advertisement assets dir is missing");
                    return new PresentationResultHolder(new VungleException(26));
                } else if ("mrec".equals(advertisement.getTemplateType()) && this.adConfig.getAdSize() != AdConfig.AdSize.VUNGLE_MREC) {
                    Log.e(AdvertisementPresentationFactory.TAG, "Corresponding AdConfig#setAdSize must be passed for the type/size of banner ad");
                    return new PresentationResultHolder(new VungleException(28));
                } else if (placement.getPlacementAdType() == 0) {
                    return new PresentationResultHolder(new VungleException(10));
                } else {
                    advertisement.configure(this.adConfig);
                    try {
                        this.repository.save(advertisement);
                        OMTracker.Factory factory = this.omTrackerFactory;
                        if (!this.apiClient.getOmEnabled() || !advertisement.getOmEnabled()) {
                            z = false;
                        }
                        OMTracker make = factory.make(z);
                        vungleWebClient.setWebViewObserver(make);
                        return new PresentationResultHolder((AdContract.AdView) null, new MRAIDAdPresenter(advertisement, placement, this.repository, new HandlerScheduler(), jobDelegateAnalytics, vungleWebClient, (OptionsState) null, file, make, this.request.getImpression()), vungleWebClient);
                    } catch (DatabaseHelper.DBException unused2) {
                        return new PresentationResultHolder(new VungleException(26));
                    }
                }
            } catch (VungleException e) {
                return new PresentationResultHolder(e);
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(PresentationResultHolder presentationResultHolder) {
            PresentationFactory.ViewCallback viewCallback2;
            super.onPostExecute(presentationResultHolder);
            if (!isCancelled() && (viewCallback2 = this.viewCallback) != null) {
                viewCallback2.onResult(new Pair((WebAdContract.WebAdPresenter) presentationResultHolder.advertisementPresenter, presentationResultHolder.webClient), presentationResultHolder.exception);
            }
        }
    }

    private static class NativeViewPresentationTask extends BaseTask {
        private final AdConfig adConfig;
        private final AdLoader adLoader;
        private Context context;
        private final JobRunner jobRunner;
        private NativeAdLayout nativeAdLayout;
        private final PresentationFactory.NativeViewCallback nativeViewCallback;
        private final AdRequest request;
        private final Bundle savedState;

        NativeViewPresentationTask(Context context2, NativeAdLayout nativeAdLayout2, AdRequest adRequest, AdConfig adConfig2, AdLoader adLoader2, Repository repository, VungleStaticApi vungleStaticApi, JobRunner jobRunner2, PresentationFactory.NativeViewCallback nativeViewCallback2, Bundle bundle, BaseTask.OnModelLoadListener onModelLoadListener) {
            super(repository, vungleStaticApi, onModelLoadListener);
            this.context = context2;
            this.nativeAdLayout = nativeAdLayout2;
            this.request = adRequest;
            this.adConfig = adConfig2;
            this.nativeViewCallback = nativeViewCallback2;
            this.savedState = bundle;
            this.jobRunner = jobRunner2;
            this.adLoader = adLoader2;
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            super.clear();
            this.context = null;
            this.nativeAdLayout = null;
        }

        /* access modifiers changed from: protected */
        public PresentationResultHolder doInBackground(Void... voidArr) {
            try {
                Pair<Advertisement, Placement> loadPresentationData = loadPresentationData(this.request, this.savedState);
                Advertisement advertisement = (Advertisement) loadPresentationData.first;
                boolean z = true;
                if (advertisement.getAdType() != 1) {
                    Log.e(AdvertisementPresentationFactory.TAG, "Invalid Ad Type for Native Ad.");
                    return new PresentationResultHolder(new VungleException(10));
                }
                Placement placement = (Placement) loadPresentationData.second;
                if (!this.adLoader.canPlayAd(advertisement)) {
                    Log.e(AdvertisementPresentationFactory.TAG, "Advertisement is null or assets are missing");
                    return new PresentationResultHolder(new VungleException(10));
                }
                Cookie cookie = this.repository.load(Cookie.CONFIG_COOKIE, Cookie.class).get();
                if (cookie == null || !cookie.getBoolean("isAdDownloadOptEnabled").booleanValue()) {
                    z = false;
                }
                if (z && !advertisement.assetsFullyDownloaded) {
                    List<AdAsset> loadAllAdAssetByStatus = this.repository.loadAllAdAssetByStatus(advertisement.getId(), 3);
                    if (!loadAllAdAssetByStatus.isEmpty()) {
                        advertisement.updateMRAIDTokensFromAssetDB(loadAllAdAssetByStatus);
                        try {
                            this.repository.save(advertisement);
                        } catch (DatabaseHelper.DBException unused) {
                            Log.e(AdvertisementPresentationFactory.TAG, "Unable to update tokens");
                        }
                    }
                }
                JobDelegateAnalytics jobDelegateAnalytics = new JobDelegateAnalytics(this.jobRunner);
                File file = this.repository.getAdvertisementAssetDirectory(advertisement.getId()).get();
                if (file == null || !file.isDirectory()) {
                    Log.e(AdvertisementPresentationFactory.TAG, "Advertisement assets dir is missing");
                    return new PresentationResultHolder(new VungleException(26));
                } else if (!advertisement.isNativeTemplateType()) {
                    return new PresentationResultHolder(new VungleException(10));
                } else {
                    advertisement.configure(this.adConfig);
                    try {
                        this.repository.save(advertisement);
                        return new PresentationResultHolder(new NativeAdView(this.context, this.nativeAdLayout), new NativeAdPresenter(advertisement, placement, this.repository, new HandlerScheduler(), jobDelegateAnalytics, (OptionsState) null, this.request.getImpression()), (VungleWebClient) null);
                    } catch (DatabaseHelper.DBException unused2) {
                        return new PresentationResultHolder(new VungleException(26));
                    }
                }
            } catch (VungleException e) {
                return new PresentationResultHolder(e);
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(PresentationResultHolder presentationResultHolder) {
            PresentationFactory.NativeViewCallback nativeViewCallback2;
            super.onPostExecute(presentationResultHolder);
            if (!isCancelled() && (nativeViewCallback2 = this.nativeViewCallback) != null) {
                nativeViewCallback2.onResult(new Pair((NativeAdContract.NativeView) presentationResultHolder.adView, (NativeAdContract.NativePresenter) presentationResultHolder.advertisementPresenter), presentationResultHolder.exception);
            }
        }
    }

    private static abstract class BaseTask extends AsyncTask<Void, Void, PresentationResultHolder> {
        private AdLoader adLoader;
        private AtomicReference<Advertisement> adRef = new AtomicReference<>();
        private Downloader downloader;
        private OnModelLoadListener onDataLoadedListener;
        private AtomicReference<Placement> plRef = new AtomicReference<>();
        protected final Repository repository;
        protected final VungleStaticApi vungleStaticApi;

        interface OnModelLoadListener {
            void onLoad(Advertisement advertisement, Placement placement);
        }

        BaseTask(Repository repository2, VungleStaticApi vungleStaticApi2, OnModelLoadListener onModelLoadListener) {
            this.repository = repository2;
            this.vungleStaticApi = vungleStaticApi2;
            this.onDataLoadedListener = onModelLoadListener;
            Context appContext = Vungle.appContext();
            if (appContext != null) {
                ServiceLocator instance = ServiceLocator.getInstance(appContext);
                this.adLoader = (AdLoader) instance.getService(AdLoader.class);
                this.downloader = (Downloader) instance.getService(Downloader.class);
            }
        }

        /* access modifiers changed from: package-private */
        public Pair<Advertisement, Placement> loadPresentationData(AdRequest adRequest, Bundle bundle) throws VungleException {
            if (!this.vungleStaticApi.isInitialized()) {
                SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.PLAY_AD).addData(SessionAttribute.SUCCESS, false).build());
                throw new VungleException(9);
            } else if (adRequest == null || TextUtils.isEmpty(adRequest.getPlacementId())) {
                SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.PLAY_AD).addData(SessionAttribute.SUCCESS, false).build());
                throw new VungleException(10);
            } else {
                Placement placement = this.repository.load(adRequest.getPlacementId(), Placement.class).get();
                if (placement == null) {
                    Log.e(AdvertisementPresentationFactory.TAG, "No Placement for ID");
                    SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.PLAY_AD).addData(SessionAttribute.SUCCESS, false).build());
                    throw new VungleException(13);
                } else if (!placement.isMultipleHBPEnabled() || adRequest.getEventId() != null) {
                    this.plRef.set(placement);
                    Advertisement advertisement = null;
                    if (bundle == null) {
                        advertisement = this.repository.findValidAdvertisementForPlacement(adRequest.getPlacementId(), adRequest.getEventId()).get();
                    } else {
                        String string = bundle.getString(AdvertisementPresentationFactory.EXTRA_ADVERTISEMENT);
                        if (!TextUtils.isEmpty(string)) {
                            advertisement = this.repository.load(string, Advertisement.class).get();
                        }
                    }
                    if (advertisement != null) {
                        this.adRef.set(advertisement);
                        File file = this.repository.getAdvertisementAssetDirectory(advertisement.getId()).get();
                        if (file == null || !file.isDirectory()) {
                            Log.e(AdvertisementPresentationFactory.TAG, "Advertisement assets dir is missing");
                            SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.PLAY_AD).addData(SessionAttribute.SUCCESS, false).addData(SessionAttribute.EVENT_ID, advertisement.getId()).build());
                            throw new VungleException(26);
                        }
                        AdLoader adLoader2 = this.adLoader;
                        if (!(adLoader2 == null || this.downloader == null || !adLoader2.isAdLoadOptimizationEnabled(advertisement))) {
                            Log.d(AdvertisementPresentationFactory.TAG, "Try to cancel downloading assets.");
                            for (DownloadRequest next : this.downloader.getAllRequests()) {
                                if (advertisement.getId().equals(next.getAdvertisementId())) {
                                    String access$000 = AdvertisementPresentationFactory.TAG;
                                    Log.d(access$000, "Cancel downloading: " + next);
                                    this.downloader.cancel(next);
                                }
                            }
                        }
                        return new Pair<>(advertisement, placement);
                    }
                    SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.PLAY_AD).addData(SessionAttribute.SUCCESS, false).build());
                    throw new VungleException(10);
                } else {
                    SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.PLAY_AD).addData(SessionAttribute.SUCCESS, false).build());
                    throw new VungleException(36);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(PresentationResultHolder presentationResultHolder) {
            super.onPostExecute(presentationResultHolder);
            OnModelLoadListener onModelLoadListener = this.onDataLoadedListener;
            if (onModelLoadListener != null) {
                onModelLoadListener.onLoad(this.adRef.get(), this.plRef.get());
            }
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            this.onDataLoadedListener = null;
        }
    }
}
