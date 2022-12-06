package com.vungle.warren;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.vungle.warren.AdConfig;
import com.vungle.warren.OperationSequence;
import com.vungle.warren.analytics.JobDelegateAnalytics;
import com.vungle.warren.downloader.AssetDownloadListener;
import com.vungle.warren.downloader.AssetPriority;
import com.vungle.warren.downloader.DownloadRequest;
import com.vungle.warren.downloader.Downloader;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.AdAsset;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.JsonUtil;
import com.vungle.warren.model.Placement;
import com.vungle.warren.model.SessionData;
import com.vungle.warren.model.admarkup.AdMarkupV2;
import com.vungle.warren.network.Call;
import com.vungle.warren.network.Callback;
import com.vungle.warren.network.Response;
import com.vungle.warren.omsdk.OMInjector;
import com.vungle.warren.persistence.CacheManager;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.session.SessionAttribute;
import com.vungle.warren.session.SessionEvent;
import com.vungle.warren.tasks.DownloadJob;
import com.vungle.warren.tasks.JobRunner;
import com.vungle.warren.ui.HackMraid;
import com.vungle.warren.utility.Executors;
import com.vungle.warren.utility.FileUtility;
import com.vungle.warren.utility.UnzipUtility;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class AdLoader {
    public static final boolean DEFAULT_LOAD_OPTIMIZATION_ENABLED = false;
    private static final String DOWNLOAD_AD_ASSETS_CONTEXT = "AdLoader#downloadAdAssets; loadAd sequence";
    private static final String DOWNLOAD_AD_CALLBACK_ON_DOWNLOAD_COMPLETED_CONTEXT = "AdLoader#DownloadAdCallback#onDownloadCompleted; loadAd sequence";
    public static final long EXPONENTIAL_RATE = 2;
    private static final String FETCH_AD_METADATA_CONTEXT = "AdLoader#fetchAdMetadata; loadAd sequence";
    private static final String GET_ASSET_DOWNLOAD_LISTENER_CONTEXT = "AdLoader#getAssetDownloadListener; loadAd sequence";
    private static final String LOAD_AD_EXECUTE_CONTEXT = "AdLoader#loadAd#execute; loadAd sequence";
    private static final String NOT_A_DIR = "not a dir";
    private static final String ON_ASSET_DOWNLOAD_FINISHED_CONTEXT = "AdLoader#onAssetDownloadFinished; loadAd sequence";
    private static final String OP_ID_AND_ADVERTISEMENT_FORMAT = "request = %1$s; advertisement = %2$s";
    private static final String PLACEMENT_ID_AND_ADVERTISEMENT_FORMAT_2_3 = "request = %2$s; advertisement = %3$s";
    private static final String PLACEMENT_ID_AND_ADVERTISEMENT_FORMAT_3_4 = "request = %3$s; advertisement = %4$s";
    public static final int RETRY_COUNT = 5;
    public static final long RETRY_DELAY = 2000;
    private static final String STRING_AND_OP_ID_FORMAT = "%1$s; request = %2$s";
    /* access modifiers changed from: private */
    public static final String TAG = AdLoader.class.getCanonicalName();
    public static final String TT_DOWNLOAD_CONTEXT = "ttDownloadContext";
    private boolean adLoadOptimizationEnabled = false;
    private final CacheManager cacheManager;
    private final Downloader downloader;
    private final AtomicReference<JobRunner> jobRunnerRef = new AtomicReference<>();
    /* access modifiers changed from: private */
    public final Map<AdRequest, Operation> loadOperations = new ConcurrentHashMap();
    private final OMInjector omInjector;
    private final Map<AdRequest, Operation> pendingOperations = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public final Repository repository;
    private final RuntimeValues runtimeValues;
    /* access modifiers changed from: private */
    public final Executors sdkExecutors;
    /* access modifiers changed from: private */
    public final OperationSequence sequence;
    /* access modifiers changed from: private */
    public AdRequest sequenceLoadingRequest = null;
    /* access modifiers changed from: private */
    public final List<Operation> startingOperations = new CopyOnWriteArrayList();
    private final VisionController visionController;
    private final VungleStaticApi vungleApi;
    /* access modifiers changed from: private */
    public final VungleApiClient vungleApiClient;

    public @interface Priority {
        public static final int HIGH = 1;
        public static final int HIGHEST = 0;
        public static final int LOWEST = Integer.MAX_VALUE;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ReschedulePolicy {
        public static final int EXPONENTIAL = 0;
        public static final int EXPONENTIAL_ENDLESS_AD = 1;
    }

    private boolean recoverableServerCode(int i) {
        return i == 408 || (500 <= i && i < 600);
    }

    public static class Operation {
        long delay;
        final Set<LoadAdCallback> loadAdCallbacks = new CopyOnWriteArraySet();
        final AtomicBoolean loading;
        boolean logError;
        int policy;
        int priority;
        final AdRequest request;
        List<DownloadRequest> requests = new CopyOnWriteArrayList();
        int retry;
        long retryDelay;
        int retryLimit;
        final AdConfig.AdSize size;

        public Operation(AdRequest adRequest, AdConfig.AdSize adSize, long j, long j2, int i, int i2, int i3, boolean z, int i4, LoadAdCallback... loadAdCallbackArr) {
            this.request = adRequest;
            this.delay = j;
            this.retryDelay = j2;
            this.retryLimit = i;
            this.policy = i2;
            this.retry = i3;
            this.loading = new AtomicBoolean();
            this.size = adSize;
            this.logError = z;
            this.priority = i4;
            if (loadAdCallbackArr != null) {
                this.loadAdCallbacks.addAll(Arrays.asList(loadAdCallbackArr));
            }
        }

        /* access modifiers changed from: package-private */
        public Operation delay(long j) {
            return new Operation(this.request, this.size, j, this.retryDelay, this.retryLimit, this.policy, this.retry, this.logError, this.priority, (LoadAdCallback[]) this.loadAdCallbacks.toArray(new LoadAdCallback[0]));
        }

        /* access modifiers changed from: package-private */
        public Operation retryDelay(long j) {
            return new Operation(this.request, this.size, this.delay, j, this.retryLimit, this.policy, this.retry, this.logError, this.priority, (LoadAdCallback[]) this.loadAdCallbacks.toArray(new LoadAdCallback[0]));
        }

        /* access modifiers changed from: package-private */
        public Operation retry(int i) {
            return new Operation(this.request, this.size, this.delay, this.retryDelay, this.retryLimit, this.policy, i, this.logError, this.priority, (LoadAdCallback[]) this.loadAdCallbacks.toArray(new LoadAdCallback[0]));
        }

        /* access modifiers changed from: package-private */
        public void merge(Operation operation) {
            this.delay = Math.min(this.delay, operation.delay);
            this.retryDelay = Math.min(this.retryDelay, operation.retryDelay);
            this.retryLimit = Math.min(this.retryLimit, operation.retryLimit);
            int i = operation.policy;
            if (i != 0) {
                i = this.policy;
            }
            this.policy = i;
            this.retry = Math.min(this.retry, operation.retry);
            this.logError |= operation.logError;
            this.priority = Math.min(this.priority, operation.priority);
            this.loadAdCallbacks.addAll(operation.loadAdCallbacks);
        }

        public String toString() {
            return "request=" + this.request.toString() + " size=" + this.size.toString() + " priority=" + this.priority + " policy=" + this.policy + " retry=" + this.retry + "/" + this.retryLimit + " delay=" + this.delay + "->" + this.retryDelay + " log=" + this.logError;
        }

        public AdRequest getRequest() {
            return this.request;
        }

        public AdConfig.AdSize getSize() {
            return this.size;
        }

        public boolean getLogError() {
            return this.logError;
        }

        public int getPriority() {
            return this.priority;
        }
    }

    public AdLoader(Executors executors, Repository repository2, VungleApiClient vungleApiClient2, CacheManager cacheManager2, Downloader downloader2, RuntimeValues runtimeValues2, VungleStaticApi vungleStaticApi, VisionController visionController2, OperationSequence operationSequence, OMInjector oMInjector) {
        this.sdkExecutors = executors;
        this.repository = repository2;
        this.vungleApiClient = vungleApiClient2;
        this.cacheManager = cacheManager2;
        this.downloader = downloader2;
        this.runtimeValues = runtimeValues2;
        this.vungleApi = vungleStaticApi;
        this.visionController = visionController2;
        this.sequence = operationSequence;
        this.omInjector = oMInjector;
    }

    public void init(JobRunner jobRunner) {
        this.jobRunnerRef.set(jobRunner);
        this.downloader.init();
    }

    private boolean canReDownload(Advertisement advertisement) {
        List<AdAsset> list;
        if (advertisement == null || ((advertisement.getState() != 0 && advertisement.getState() != 1) || (list = this.repository.loadAllAdAssets(advertisement.getId()).get()) == null || list.size() == 0)) {
            return false;
        }
        for (AdAsset adAsset : list) {
            if (adAsset.fileType == 1) {
                if (!fileIsValid(new File(adAsset.localPath), adAsset)) {
                    return false;
                }
            } else if (TextUtils.isEmpty(adAsset.serverPath)) {
                return false;
            }
        }
        return true;
    }

    public boolean canPlayAd(Advertisement advertisement) {
        if (advertisement == null || advertisement.getState() != 1) {
            return false;
        }
        return hasAssetsFor(advertisement);
    }

    public boolean canRenderAd(Advertisement advertisement) {
        if (advertisement == null) {
            return false;
        }
        if (advertisement.getState() == 1 || advertisement.getState() == 2) {
            return hasAssetsFor(advertisement);
        }
        return false;
    }

    public void clear() {
        HashSet<AdRequest> hashSet = new HashSet<>();
        hashSet.addAll(this.loadOperations.keySet());
        hashSet.addAll(this.pendingOperations.keySet());
        for (AdRequest adRequest : hashSet) {
            Operation remove = this.loadOperations.remove(adRequest);
            this.startingOperations.remove(remove);
            onError(remove, 25);
            onError(this.pendingOperations.remove(adRequest), 25);
        }
        for (Operation next : this.startingOperations) {
            this.startingOperations.remove(next);
            onError(next, 25);
        }
        this.sdkExecutors.getBackgroundExecutor().execute(new Runnable() {
            public void run() {
                AdRequest unused = AdLoader.this.sequenceLoadingRequest = null;
                for (OperationSequence.Entry entry : AdLoader.this.sequence.removeAll()) {
                    AdLoader.this.onError(entry.operation, 25);
                }
            }
        });
    }

    public boolean isLoading(AdRequest adRequest) {
        Operation operation = this.loadOperations.get(adRequest);
        return operation != null && operation.loading.get();
    }

    private void setLoading(AdRequest adRequest, boolean z) {
        Operation operation = this.loadOperations.get(adRequest);
        if (operation != null) {
            operation.loading.set(z);
        }
    }

    public void loadPendingInternal(AdRequest adRequest) {
        Operation remove = this.pendingOperations.remove(adRequest);
        if (remove != null) {
            load(remove.delay(0));
        }
    }

    public void load(final Operation operation) {
        JobRunner jobRunner = this.jobRunnerRef.get();
        if (jobRunner == null) {
            VungleLogger.error("AdLoader#load; loadAd sequence", String.format("Cannot load operation %s; job runner is null", new Object[]{operation}));
            onError(operation, 9);
            return;
        }
        if (operation.request.getIsExplicit()) {
            SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.LOAD_AD).addData(SessionAttribute.PLACEMENT_ID, operation.request.getPlacementId()).build());
        }
        checkAndUpdateHBPPlacementBannerSize(operation.request.getPlacementId(), operation.size);
        Operation remove = this.pendingOperations.remove(operation.request);
        if (remove != null) {
            operation.merge(remove);
        }
        if (operation.delay <= 0) {
            operation.request.timeStamp.set(System.currentTimeMillis());
            this.startingOperations.add(operation);
            this.sdkExecutors.getBackgroundExecutor().execute(new Runnable() {
                public void run() {
                    if (AdLoader.this.startingOperations.contains(operation)) {
                        Operation operation = operation;
                        Operation operation2 = (Operation) AdLoader.this.loadOperations.get(operation.request);
                        if (operation2 != null) {
                            int i = operation2.priority;
                            operation2.merge(operation);
                            if (operation2.priority < i) {
                                AdLoader.this.onChangePriority(operation2);
                            }
                        } else {
                            OperationSequence.Entry remove = AdLoader.this.sequence.remove(operation.request);
                            if (remove != null) {
                                remove.operation.merge(operation);
                                operation = remove.operation;
                            }
                            if (operation.priority <= 0) {
                                AdLoader.this.startLoading(operation);
                            } else {
                                OperationSequence access$100 = AdLoader.this.sequence;
                                if (remove == null) {
                                    remove = new OperationSequence.Entry(operation);
                                }
                                access$100.offer(remove);
                                AdLoader.this.tryLoadNextInQueue((AdRequest) null);
                            }
                        }
                        AdLoader.this.startingOperations.remove(operation);
                    }
                }
            }, new Runnable() {
                public void run() {
                    AdLoader.this.onError(operation, 39);
                }
            });
            return;
        }
        this.pendingOperations.put(operation.request, operation);
        jobRunner.execute(DownloadJob.makeJobInfo(operation.request).setDelay(operation.delay).setUpdateCurrent(true));
    }

    private void checkAndUpdateHBPPlacementBannerSize(String str, final AdConfig.AdSize adSize) {
        this.repository.load(str, Placement.class, new Repository.LoadCallback<Placement>() {
            public void onLoaded(Placement placement) {
                AdConfig.AdSize adSize;
                if (placement != null && placement.isMultipleHBPEnabled() && placement.getPlacementAdType() == 1 && placement.getAdSize() != (adSize = adSize)) {
                    placement.setAdSize(adSize);
                    AdLoader.this.repository.save(placement, (Repository.SaveCallback) null, false);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void startLoading(Operation operation) {
        this.loadOperations.put(operation.request, operation);
        loadAd(operation);
    }

    /* access modifiers changed from: private */
    public void tryLoadNextInQueue(AdRequest adRequest) {
        AdRequest adRequest2 = this.sequenceLoadingRequest;
        if (adRequest2 == null || adRequest2.equals(adRequest)) {
            this.sequenceLoadingRequest = null;
            OperationSequence.Entry poll = this.sequence.poll();
            if (poll != null) {
                this.sequenceLoadingRequest = poll.operation.request;
                startLoading(poll.operation);
            }
        }
    }

    /* access modifiers changed from: private */
    public void onChangePriority(Operation operation) {
        for (DownloadRequest next : operation.requests) {
            next.setPriority(getAssetPriority(operation.priority, next.path));
            this.downloader.updatePriority(next);
        }
    }

    /* access modifiers changed from: private */
    public void onError(Operation operation, int i) {
        Object[] objArr = new Object[2];
        objArr[0] = new VungleException(i);
        objArr[1] = operation != null ? operation : "null";
        VungleLogger.error("AdLoader#onError; loadAd sequence", String.format("Error %1$s occured; operation is %2$s", objArr));
        if (operation != null) {
            for (LoadAdCallback onError : operation.loadAdCallbacks) {
                onError.onError(operation.request.getPlacementId(), new VungleException(i));
            }
        }
    }

    /* access modifiers changed from: private */
    public VungleException reposeCodeToVungleException(int i) {
        if (recoverableServerCode(i)) {
            return new VungleException(22);
        }
        return new VungleException(21);
    }

    /* access modifiers changed from: private */
    public VungleException retrofitToVungleException(Throwable th) {
        if (th instanceof UnknownHostException) {
            return new VungleException(11);
        }
        if (th instanceof IOException) {
            return new VungleException(20);
        }
        return new VungleException(11);
    }

    private void loadAd(Operation operation) {
        Advertisement advertisement;
        List<Advertisement> list;
        Operation operation2 = operation;
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.vungleApi.isInitialized()) {
            VungleLogger.error(LOAD_AD_EXECUTE_CONTEXT, "Vungle is not initialized");
            onDownloadFailed(new VungleException(9), operation2.request, (String) null);
            return;
        }
        Placement placement = this.repository.load(operation2.request.getPlacementId(), Placement.class).get();
        if (placement == null) {
            VungleLogger.error(LOAD_AD_EXECUTE_CONTEXT, "placement not found for " + operation2.request);
            onDownloadFailed(new VungleException(13), operation2.request, (String) null);
        } else if (!placement.isValid()) {
            onDownloadFailed(new VungleException(5), operation2.request, (String) null);
        } else if (isSizeInvalid(placement, operation2.size)) {
            VungleLogger.error(LOAD_AD_EXECUTE_CONTEXT, "size is invalid, size = " + operation2.size);
            onDownloadFailed(new VungleException(28), operation2.request, (String) null);
        } else {
            if (placement.getPlacementAdType() == 1 && !placement.isMultipleHBPEnabled() && (list = this.repository.findValidAdvertisementsForPlacement(placement.getId(), operation2.request.getEventId()).get()) != null) {
                boolean z = false;
                for (Advertisement advertisement2 : list) {
                    if (advertisement2.getAdConfig().getAdSize() != operation2.size) {
                        try {
                            this.repository.deleteAdvertisement(advertisement2.getId());
                            z = true;
                        } catch (DatabaseHelper.DBException unused) {
                            VungleLogger.error(LOAD_AD_EXECUTE_CONTEXT, "cannot delete advertisement, request = " + operation2.request);
                            onDownloadFailed(new VungleException(26), operation2.request, (String) null);
                            return;
                        }
                    }
                }
                if (z) {
                    loadEndlessIfNeeded(placement, operation2.size, 0, operation2.request.getIsExplicit());
                }
            }
            int type = operation2.request.getType();
            if (type == 0 || type == 2) {
                advertisement = this.repository.findValidAdvertisementForPlacement(placement.getId(), operation2.request.getEventId()).get();
                if (operation2.request.getAdMarkup() != null && advertisement == null && operation2.request.getAdMarkup().getVersion() == 2) {
                    advertisement = ((AdMarkupV2) operation2.request.getAdMarkup()).getAdvertisement();
                    try {
                        this.repository.save(advertisement);
                    } catch (DatabaseHelper.DBException unused2) {
                        Log.e(TAG, "Failed to persist ad from Real Time Ad");
                    }
                }
                if (placement.isMultipleHBPEnabled() && operation2.request.getType() == 0) {
                    if (operation2.request.getEventId() == null) {
                        onDownloadFailed(new VungleException(36), operation2.request, (String) null);
                        return;
                    } else if (advertisement == null) {
                        onDownloadFailed(new VungleException(10), operation2.request, (String) null);
                        return;
                    }
                }
                if (advertisement != null && canPlayAd(advertisement)) {
                    tryLoadNextInQueue(operation2.request);
                    onReady(operation2.request, placement, advertisement);
                    return;
                } else if (canReDownload(advertisement)) {
                    Log.d(TAG, "Found valid adv but not ready - downloading content");
                    VungleSettings vungleSettings = this.runtimeValues.settings.get();
                    if (vungleSettings == null || this.cacheManager.getBytesAvailable() < vungleSettings.getMinimumSpaceForAd()) {
                        if (advertisement.getState() != 4) {
                            try {
                                this.repository.saveAndApplyState(advertisement, operation2.request.getPlacementId(), 4);
                            } catch (DatabaseHelper.DBException unused3) {
                                VungleLogger.error("AdLoader#loadAd#execute; loadAd sequence; canReDownload branch", "cannot save/apply ERROR state, request = " + operation2.request);
                                onDownloadFailed(new VungleException(26), operation2.request, (String) null);
                                return;
                            }
                        }
                        VungleLogger.error(LOAD_AD_EXECUTE_CONTEXT, "failed to download assets, no space; request = " + operation2.request);
                        onDownloadFailed(new VungleException(19), operation2.request, (String) null);
                        return;
                    }
                    setLoading(operation2.request, true);
                    if (advertisement.getState() != 0) {
                        try {
                            this.repository.saveAndApplyState(advertisement, operation2.request.getPlacementId(), 0);
                        } catch (DatabaseHelper.DBException unused4) {
                            VungleLogger.error("AdLoader#loadAd#execute; loadAd sequence; canReDownload branch", "cannot save/apply NEW state, request = " + operation2.request);
                            onDownloadFailed(new VungleException(26), operation2.request, (String) null);
                            return;
                        }
                    }
                    advertisement.setAdRequestStartTime(currentTimeMillis);
                    advertisement.setAssetDownloadStartTime(System.currentTimeMillis());
                    tryLoadNextInQueue(operation2.request);
                    downloadAdAssets(operation2, advertisement);
                    return;
                }
            } else if (operation2.request.getType() != 1 || !isReadyForHBP(operation2, this.repository)) {
                advertisement = null;
            } else {
                tryLoadNextInQueue(operation2.request);
                onReady(operation2.request, placement, (Advertisement) null);
                return;
            }
            if (placement.getWakeupTime() > System.currentTimeMillis()) {
                onDownloadFailed(new VungleException(1), operation2.request, (String) null);
                VungleLogger.warn("AdLoader#loadAd#execute; loadAd sequence; snoozed branch", String.format("Placement with id %s is snoozed ", new Object[]{placement.getId()}));
                Log.w(TAG, "Placement " + placement.getId() + " is  snoozed");
                Log.d(TAG, "Placement " + placement.getId() + " is sleeping rescheduling it ");
                loadEndlessIfNeeded(placement, operation2.size, placement.getWakeupTime() - System.currentTimeMillis(), false);
                return;
            }
            String str = operation2.request.getType() == 1 ? "advs" : "adv";
            Log.i(TAG, "didn't find cached " + str + " for " + operation2.request + " downloading");
            if (advertisement != null) {
                try {
                    this.repository.saveAndApplyState(advertisement, operation2.request.getPlacementId(), 4);
                } catch (DatabaseHelper.DBException unused5) {
                    VungleLogger.error("AdLoader#loadAd#execute; loadAd sequence; last else branch", "cannot save/apply ERROR state, request = " + operation2.request);
                    onDownloadFailed(new VungleException(26), operation2.request, (String) null);
                    return;
                }
            }
            VungleSettings vungleSettings2 = this.runtimeValues.settings.get();
            if (vungleSettings2 == null || this.cacheManager.getBytesAvailable() >= vungleSettings2.getMinimumSpaceForAd()) {
                Log.d(TAG, "No " + str + " for placement " + placement.getId() + " getting new data ");
                setLoading(operation2.request, true);
                fetchAdMetadata(operation2, placement);
                return;
            }
            VungleLogger.error("AdLoader#loadAd#execute; loadAd sequence; last else branch", String.format("no space to load, isAutoCached = %1$s, request = %2$s", new Object[]{Boolean.valueOf(placement.isAutoCached()), operation2.request}));
            onDownloadFailed(new VungleException(placement.isAutoCached() ? 18 : 17), operation2.request, (String) null);
        }
    }

    private boolean isReadyForHBP(Operation operation, Repository repository2) {
        List list = repository2.findValidAdvertisementsForPlacement(operation.request.getPlacementId(), (String) null).get();
        return list != null && ((long) list.size()) >= operation.request.getAdCount();
    }

    private boolean isSizeInvalid(Placement placement, AdConfig.AdSize adSize) {
        if (placement.getPlacementAdType() == 1 && !AdConfig.AdSize.isNonMrecBannerAdSize(adSize)) {
            return true;
        }
        if (placement.getPlacementAdType() != 0 || AdConfig.AdSize.isDefaultAdSize(adSize)) {
            return false;
        }
        return true;
    }

    private void fetchAdMetadata(final Operation operation, Placement placement) {
        final long currentTimeMillis = System.currentTimeMillis();
        if (operation.request.getAdMarkup() instanceof AdMarkupV2) {
            handleAdMetaData(operation, currentTimeMillis, ((AdMarkupV2) operation.request.getAdMarkup()).getAdvertisement(), placement, new JsonObject());
            return;
        }
        VungleLogger.verbose(true, TAG, TT_DOWNLOAD_CONTEXT, String.format("Start to request ad, request = %1$s, at: %2$d", new Object[]{operation.request, Long.valueOf(currentTimeMillis)}));
        this.vungleApiClient.requestAd(operation.request.getPlacementId(), AdConfig.AdSize.isNonMrecBannerAdSize(operation.size) ? operation.size.getName() : "", placement.isHeaderBidding(), this.visionController.isEnabled() ? this.visionController.getPayload() : null).enqueue(new Callback<JsonObject>() {
            public void onFailure(Call<JsonObject> call, final Throwable th) {
                VungleLogger.verbose(true, AdLoader.TAG, AdLoader.TT_DOWNLOAD_CONTEXT, String.format("Request ad failed, request = %1$s, elapsed time = %2$dms", new Object[]{operation.request, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)}));
                VungleLogger.error(AdLoader.FETCH_AD_METADATA_CONTEXT, String.format("failed to request ad, request = %1$s, throwable = %2$s", new Object[]{operation.request, th}));
                AdLoader.this.sdkExecutors.getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        AdLoader.this.onDownloadFailed(AdLoader.this.retrofitToVungleException(th), operation.request, (String) null);
                    }
                }, new Runnable() {
                    public void run() {
                        AdLoader.this.onCriticalFail(39, operation.request);
                    }
                });
            }

            public void onResponse(Call<JsonObject> call, final Response<JsonObject> response) {
                VungleLogger.verbose(true, AdLoader.TAG, AdLoader.TT_DOWNLOAD_CONTEXT, String.format("Request ad got response, request = %1$s, elapsed time = %2$dms", new Object[]{operation.request, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)}));
                AdLoader.this.sdkExecutors.getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        Placement placement = AdLoader.this.repository.load(operation.request.getPlacementId(), Placement.class).get();
                        if (placement == null) {
                            Log.e(AdLoader.TAG, "Placement metadata not found for requested advertisement.");
                            VungleLogger.error(AdLoader.FETCH_AD_METADATA_CONTEXT, "Placement metadata not found for requested advertisement. request = " + operation.request);
                            AdLoader.this.onDownloadFailed(new VungleException(2), operation.request, (String) null);
                        } else if (!response.isSuccessful()) {
                            long retryAfterHeaderValue = AdLoader.this.vungleApiClient.getRetryAfterHeaderValue(response);
                            if (retryAfterHeaderValue <= 0 || (!placement.isAutoCached() && !placement.isMultipleHBPEnabled())) {
                                Log.e(AdLoader.TAG, "Failed to retrieve advertisement information");
                                VungleLogger.error(AdLoader.FETCH_AD_METADATA_CONTEXT, String.format("Response was not successful, not retrying;request = %1$s; responseCode = %2$s", new Object[]{operation.request, Integer.valueOf(response.code())}));
                                AdLoader.this.onDownloadFailed(AdLoader.this.reposeCodeToVungleException(response.code()), operation.request, (String) null);
                                return;
                            }
                            AdLoader.this.loadEndlessIfNeeded(placement, operation.size, retryAfterHeaderValue, false);
                            VungleLogger.error(AdLoader.FETCH_AD_METADATA_CONTEXT, "Response was not successful, retrying; request = " + operation.request);
                            AdLoader.this.onDownloadFailed(new VungleException(14), operation.request, (String) null);
                        } else {
                            JsonObject jsonObject = (JsonObject) response.body();
                            String access$900 = AdLoader.TAG;
                            Log.d(access$900, "Ads Response: " + jsonObject);
                            if (jsonObject == null || !jsonObject.has(CampaignUnit.JSON_KEY_ADS) || jsonObject.get(CampaignUnit.JSON_KEY_ADS).isJsonNull()) {
                                VungleLogger.error(AdLoader.FETCH_AD_METADATA_CONTEXT, String.format("Response has no ads; placement = %1$s;op.request = %2$s; response = %3$s", new Object[]{placement, operation.request, jsonObject}));
                                AdLoader.this.onDownloadFailed(new VungleException(1), operation.request, (String) null);
                                return;
                            }
                            JsonArray asJsonArray = jsonObject.getAsJsonArray(CampaignUnit.JSON_KEY_ADS);
                            if (asJsonArray == null || asJsonArray.size() == 0) {
                                VungleLogger.error(AdLoader.FETCH_AD_METADATA_CONTEXT, "Response was successful, but no ads; request = " + operation.request);
                                AdLoader.this.onDownloadFailed(new VungleException(1), operation.request, (String) null);
                                return;
                            }
                            JsonObject asJsonObject = asJsonArray.get(0).getAsJsonObject();
                            AdLoader.this.handleAdMetaData(operation, currentTimeMillis, asJsonObject, placement, asJsonObject.get("ad_markup").getAsJsonObject());
                        }
                    }
                }, new Runnable() {
                    public void run() {
                        AdLoader.this.onCriticalFail(39, operation.request);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public void handleAdMetaData(Operation operation, long j, JsonObject jsonObject, Placement placement, JsonObject jsonObject2) {
        Operation operation2 = operation;
        Placement placement2 = placement;
        JsonObject jsonObject3 = jsonObject2;
        try {
            handleAdMetaData(operation, j, new Advertisement(jsonObject), placement, jsonObject2);
        } catch (IllegalArgumentException unused) {
            if (jsonObject3.has("sleep")) {
                long asInt = (long) jsonObject3.get("sleep").getAsInt();
                placement2.snooze(asInt);
                try {
                    VungleLogger.warn(FETCH_AD_METADATA_CONTEXT, String.format("badAd - snoozed placement %1$s; request = %2$s", new Object[]{placement2, operation2.request}));
                    this.repository.save(placement2);
                    long j2 = 1000 * asInt;
                    loadEndlessIfNeeded(placement, operation2.size, j2, false);
                } catch (DatabaseHelper.DBException unused2) {
                    VungleLogger.error(FETCH_AD_METADATA_CONTEXT, String.format("badAd - can't save snoozed placement %1$s; request = %2$s", new Object[]{placement2, operation2.request}));
                    onDownloadFailed(new VungleException(26), operation2.request, (String) null);
                    return;
                }
            }
            VungleLogger.error(FETCH_AD_METADATA_CONTEXT, String.format("badAd; can't proceed %1$s; request = %2$s", new Object[]{placement2, operation2.request}));
            onDownloadFailed(new VungleException(1), operation2.request, (String) null);
        }
    }

    private void handleAdMetaData(Operation operation, long j, Advertisement advertisement, Placement placement, JsonObject jsonObject) throws IllegalArgumentException {
        int state;
        Operation operation2 = operation;
        Advertisement advertisement2 = advertisement;
        Placement placement2 = placement;
        JsonObject jsonObject2 = jsonObject;
        HeaderBiddingCallback headerBiddingCallback = this.runtimeValues.headerBiddingCallback.get();
        try {
            if (this.visionController.isEnabled()) {
                if (JsonUtil.hasNonNull(jsonObject2, "data_science_cache")) {
                    this.visionController.setDataScienceCache(jsonObject2.get("data_science_cache").getAsString());
                } else {
                    this.visionController.setDataScienceCache((String) null);
                }
            }
            Advertisement advertisement3 = this.repository.load(advertisement.getId(), Advertisement.class).get();
            if (advertisement3 == null || !((state = advertisement3.getState()) == 0 || state == 1 || state == 2)) {
                if (placement.isHeaderBidding() && headerBiddingCallback != null) {
                    headerBiddingCallback.onBidTokenAvailable(operation2.request.getPlacementId(), advertisement.getBidToken());
                }
                this.repository.deleteAdvertisement(advertisement.getId());
                Set<Map.Entry<String, String>> entrySet = advertisement.getDownloadableUrls().entrySet();
                File destinationDir = getDestinationDir(advertisement2);
                if (destinationDir != null) {
                    if (destinationDir.isDirectory()) {
                        for (Map.Entry next : entrySet) {
                            if (isUrlValid((String) next.getValue())) {
                                saveAsset(advertisement2, destinationDir, (String) next.getKey(), (String) next.getValue());
                            } else {
                                VungleLogger.error(FETCH_AD_METADATA_CONTEXT, String.format("Response was successful, but one of downloadable urls is neither http nor https : url = %1$s; op.request = %2$s, ad.getId() = %3$s", new Object[]{next.getValue(), operation2.request, advertisement.getId()}));
                                onDownloadFailed(new VungleException(11), operation2.request, advertisement.getId());
                                return;
                            }
                        }
                        if (placement.getPlacementAdType() != 1 || (advertisement.getAdType() == 1 && "banner".equals(advertisement.getTemplateType()))) {
                            advertisement.getAdConfig().setAdSize(operation2.size);
                            advertisement2.setAdRequestStartTime(j);
                            advertisement2.setAssetDownloadStartTime(System.currentTimeMillis());
                            advertisement2.setHeaderBidding(placement.isHeaderBidding());
                            this.repository.saveAndApplyState(advertisement2, operation2.request.getPlacementId(), 0);
                            int type = operation2.request.getType();
                            if (type != 0) {
                                if (type != 2) {
                                    if (operation2.request.getType() != 1) {
                                        return;
                                    }
                                    if (isReadyForHBP(operation2, this.repository)) {
                                        tryLoadNextInQueue(operation2.request);
                                        onReady(operation2.request, placement2, (Advertisement) null);
                                        return;
                                    }
                                    fetchAdMetadata(operation2, placement2);
                                    return;
                                }
                            }
                            tryLoadNextInQueue(operation2.request);
                            downloadAdAssets(operation2, advertisement2);
                            return;
                        }
                        Object[] objArr = new Object[3];
                        objArr[0] = advertisement.getAdType() != 1 ? "ad type is not MRAID" : "advertisement template type is not banner";
                        objArr[1] = operation2.request;
                        objArr[2] = advertisement.getId();
                        VungleLogger.error(FETCH_AD_METADATA_CONTEXT, String.format("Response was successful, but placement is banner while %1$s; op.request = %2$s, ad.getId() = %3$s", objArr));
                        onDownloadFailed(new VungleException(1), operation2.request, advertisement.getId());
                        return;
                    }
                }
                Object[] objArr2 = new Object[3];
                objArr2[0] = destinationDir == null ? "null" : NOT_A_DIR;
                objArr2[1] = operation2.request;
                objArr2[2] = advertisement.getId();
                VungleLogger.error(FETCH_AD_METADATA_CONTEXT, String.format("Response was successful, but adv directory is %1$s; op.request = %2$s, ad.getId() = %3$s", objArr2));
                onDownloadFailed(new VungleException(26), operation2.request, advertisement.getId());
                return;
            }
            Log.d(TAG, "Operation Cancelled");
            onDownloadFailed(new VungleException(25), operation2.request, (String) null);
        } catch (DatabaseHelper.DBException e) {
            VungleLogger.error(FETCH_AD_METADATA_CONTEXT, String.format("BadAd - DBException; can't proceed; placement = %1$s; op.request = %2$s; exception = %3$s", new Object[]{placement2, operation2.request, e}));
            onDownloadFailed(new VungleException(26), operation2.request, (String) null);
        }
    }

    /* access modifiers changed from: package-private */
    public File getDestinationDir(Advertisement advertisement) {
        return this.repository.getAdvertisementAssetDirectory(advertisement.getId()).get();
    }

    /* access modifiers changed from: package-private */
    public void saveAsset(Advertisement advertisement, File file, String str, String str2) throws DatabaseHelper.DBException {
        String str3 = file.getPath() + File.separator + str;
        int i = (str3.endsWith(Advertisement.KEY_POSTROLL) || str3.endsWith("template")) ? 0 : 2;
        AdAsset adAsset = new AdAsset(advertisement.getId(), str2, str3);
        adAsset.status = 0;
        adAsset.fileType = i;
        try {
            this.repository.save(adAsset);
        } catch (DatabaseHelper.DBException e) {
            VungleLogger.error("AdLoader#saveAsset; loadAd sequence", String.format("Can't save adAsset %1$s; exception = %2$s", new Object[]{adAsset, e}));
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void downloadAdAssets(com.vungle.warren.AdLoader.Operation r13, com.vungle.warren.model.Advertisement r14) {
        /*
            r12 = this;
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r0 = r13.requests
            r0.clear()
            java.util.Map r0 = r14.getDownloadableUrls()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0011:
            boolean r1 = r0.hasNext()
            java.lang.String r2 = "AdLoader#downloadAdAssets; loadAd sequence"
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x007f
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r6 = r1.getKey()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0046
            java.lang.Object r6 = r1.getValue()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0046
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = android.webkit.URLUtil.isValidUrl(r1)
            if (r1 != 0) goto L_0x0011
        L_0x0046:
            java.lang.Object[] r0 = new java.lang.Object[r3]
            com.vungle.warren.AdRequest r1 = r13.request
            r0[r4] = r1
            r0[r5] = r14
            java.lang.String r1 = "One or more ad asset URLs is empty or not valid;request = %1$s; advertisement = %2$s"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            com.vungle.warren.VungleLogger.error(r2, r0)
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r1 = 11
            r0.<init>(r1)
            com.vungle.warren.AdRequest r13 = r13.request
            r1 = 0
            r12.onDownloadFailed(r0, r13, r1)
            java.lang.String r13 = TAG
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Aborting, Failed to download Ad assets for: "
            r0.append(r1)
            java.lang.String r14 = r14.getId()
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            android.util.Log.e(r13, r14)
            return
        L_0x007f:
            r0 = 26
            com.vungle.warren.persistence.Repository r1 = r12.repository     // Catch:{ DBException -> 0x0267 }
            r1.save(r14)     // Catch:{ DBException -> 0x0267 }
            com.vungle.warren.persistence.Repository r1 = r12.repository
            java.lang.String r6 = r14.getId()
            com.vungle.warren.persistence.FutureResult r1 = r1.loadAllAdAssets(r6)
            java.lang.Object r1 = r1.get()
            java.util.List r1 = (java.util.List) r1
            if (r1 != 0) goto L_0x00b8
            java.lang.Object[] r1 = new java.lang.Object[r3]
            com.vungle.warren.AdRequest r3 = r13.request
            r1[r4] = r3
            r1[r5] = r14
            java.lang.String r3 = "Cannot load all ad assets; op.request = %1$s; advertisement = %2$s"
            java.lang.String r1 = java.lang.String.format(r3, r1)
            com.vungle.warren.VungleLogger.error(r2, r1)
            com.vungle.warren.error.VungleException r1 = new com.vungle.warren.error.VungleException
            r1.<init>(r0)
            com.vungle.warren.AdRequest r13 = r13.request
            java.lang.String r14 = r14.getId()
            r12.onDownloadFailed(r1, r13, r14)
            return
        L_0x00b8:
            java.util.Iterator r1 = r1.iterator()
            r6 = r4
        L_0x00bd:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x01ef
            java.lang.Object r7 = r1.next()
            com.vungle.warren.model.AdAsset r7 = (com.vungle.warren.model.AdAsset) r7
            int r8 = r7.status
            r9 = 3
            r10 = 24
            if (r8 != r9) goto L_0x012b
            java.io.File r8 = new java.io.File
            java.lang.String r9 = r7.localPath
            r8.<init>(r9)
            boolean r8 = r12.fileIsValid(r8, r7)
            if (r8 == 0) goto L_0x0107
            java.lang.String r7 = r7.serverPath
            boolean r7 = com.vungle.warren.utility.FileUtility.isVideoFile(r7)
            if (r7 == 0) goto L_0x00bd
            com.vungle.warren.SessionTracker r6 = com.vungle.warren.SessionTracker.getInstance()
            com.vungle.warren.model.SessionData$Builder r7 = new com.vungle.warren.model.SessionData$Builder
            r7.<init>()
            com.vungle.warren.session.SessionEvent r8 = com.vungle.warren.session.SessionEvent.ADS_CACHED
            com.vungle.warren.model.SessionData$Builder r7 = r7.setEvent(r8)
            com.vungle.warren.session.SessionAttribute r8 = com.vungle.warren.session.SessionAttribute.EVENT_ID
            java.lang.String r9 = r14.getId()
            com.vungle.warren.model.SessionData$Builder r7 = r7.addData((com.vungle.warren.session.SessionAttribute) r8, (java.lang.String) r9)
            com.vungle.warren.model.SessionData r7 = r7.build()
            r6.trackEvent(r7)
        L_0x0105:
            r6 = r5
            goto L_0x00bd
        L_0x0107:
            int r8 = r7.fileType
            if (r8 != r5) goto L_0x012b
            java.lang.Object[] r0 = new java.lang.Object[r3]
            com.vungle.warren.AdRequest r1 = r13.request
            r0[r4] = r1
            r0[r5] = r14
            java.lang.String r1 = "Cannot download ad assets - asset filetype is zip_asset;request = %1$s; advertisement = %2$s"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            com.vungle.warren.VungleLogger.error(r2, r0)
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r0.<init>(r10)
            com.vungle.warren.AdRequest r13 = r13.request
            java.lang.String r14 = r14.getId()
            r12.onDownloadFailed(r0, r13, r14)
            return
        L_0x012b:
            int r8 = r7.status
            r9 = 4
            if (r8 != r9) goto L_0x0135
            int r8 = r7.fileType
            if (r8 != 0) goto L_0x0135
            goto L_0x00bd
        L_0x0135:
            java.lang.String r8 = r7.serverPath
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 == 0) goto L_0x015d
            java.lang.Object[] r0 = new java.lang.Object[r3]
            com.vungle.warren.AdRequest r1 = r13.request
            r0[r4] = r1
            r0[r5] = r14
            java.lang.String r1 = "Cannot download ad assets - empty ;request = %1$s; advertisement = %2$s"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            com.vungle.warren.VungleLogger.error(r2, r0)
            com.vungle.warren.error.VungleException r0 = new com.vungle.warren.error.VungleException
            r0.<init>(r10)
            com.vungle.warren.AdRequest r13 = r13.request
            java.lang.String r14 = r14.getId()
            r12.onDownloadFailed(r0, r13, r14)
            return
        L_0x015d:
            int r8 = r13.priority
            java.lang.String r9 = r14.getId()
            com.vungle.warren.downloader.DownloadRequest r8 = r12.getDownloadRequest(r8, r7, r9)
            int r9 = r7.status
            if (r9 != r5) goto L_0x017c
            com.vungle.warren.downloader.Downloader r9 = r12.downloader
            r10 = 1000(0x3e8, double:4.94E-321)
            r9.cancelAndAwait(r8, r10)
            int r8 = r13.priority
            java.lang.String r9 = r14.getId()
            com.vungle.warren.downloader.DownloadRequest r8 = r12.getDownloadRequest(r8, r7, r9)
        L_0x017c:
            java.lang.String r9 = TAG
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Starting download for "
            r10.append(r11)
            r10.append(r7)
            java.lang.String r10 = r10.toString()
            android.util.Log.d(r9, r10)
            r7.status = r5
            com.vungle.warren.persistence.Repository r9 = r12.repository     // Catch:{ DBException -> 0x01d0 }
            r9.save(r7)     // Catch:{ DBException -> 0x01d0 }
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r9 = r13.requests
            r9.add(r8)
            java.lang.String r8 = r7.serverPath
            boolean r8 = com.vungle.warren.utility.FileUtility.isVideoFile(r8)
            if (r8 == 0) goto L_0x00bd
            com.vungle.warren.SessionTracker r6 = com.vungle.warren.SessionTracker.getInstance()
            com.vungle.warren.model.SessionData$Builder r8 = new com.vungle.warren.model.SessionData$Builder
            r8.<init>()
            com.vungle.warren.session.SessionEvent r9 = com.vungle.warren.session.SessionEvent.ADS_CACHED
            com.vungle.warren.model.SessionData$Builder r8 = r8.setEvent(r9)
            com.vungle.warren.session.SessionAttribute r9 = com.vungle.warren.session.SessionAttribute.EVENT_ID
            java.lang.String r10 = r14.getId()
            com.vungle.warren.model.SessionData$Builder r8 = r8.addData((com.vungle.warren.session.SessionAttribute) r9, (java.lang.String) r10)
            com.vungle.warren.session.SessionAttribute r9 = com.vungle.warren.session.SessionAttribute.URL
            java.lang.String r7 = r7.serverPath
            com.vungle.warren.model.SessionData$Builder r7 = r8.addData((com.vungle.warren.session.SessionAttribute) r9, (java.lang.String) r7)
            com.vungle.warren.model.SessionData r7 = r7.build()
            r6.trackEvent(r7)
            goto L_0x0105
        L_0x01d0:
            r1 = move-exception
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r4] = r7
            r3[r5] = r1
            java.lang.String r1 = "Can't save asset %1$s; exception = %2$s"
            java.lang.String r1 = java.lang.String.format(r1, r3)
            com.vungle.warren.VungleLogger.error(r2, r1)
            com.vungle.warren.error.VungleException r1 = new com.vungle.warren.error.VungleException
            r1.<init>(r0)
            com.vungle.warren.AdRequest r13 = r13.request
            java.lang.String r14 = r14.getId()
            r12.onDownloadFailed(r1, r13, r14)
            return
        L_0x01ef:
            if (r6 != 0) goto L_0x0219
            com.vungle.warren.SessionTracker r0 = com.vungle.warren.SessionTracker.getInstance()
            com.vungle.warren.model.SessionData$Builder r1 = new com.vungle.warren.model.SessionData$Builder
            r1.<init>()
            com.vungle.warren.session.SessionEvent r2 = com.vungle.warren.session.SessionEvent.ADS_CACHED
            com.vungle.warren.model.SessionData$Builder r1 = r1.setEvent(r2)
            com.vungle.warren.session.SessionAttribute r2 = com.vungle.warren.session.SessionAttribute.EVENT_ID
            java.lang.String r6 = r14.getId()
            com.vungle.warren.model.SessionData$Builder r1 = r1.addData((com.vungle.warren.session.SessionAttribute) r2, (java.lang.String) r6)
            com.vungle.warren.session.SessionAttribute r2 = com.vungle.warren.session.SessionAttribute.VIDEO_CACHED
            java.lang.String r6 = com.vungle.warren.session.SessionConstants.NONE
            com.vungle.warren.model.SessionData$Builder r1 = r1.addData((com.vungle.warren.session.SessionAttribute) r2, (java.lang.String) r6)
            com.vungle.warren.model.SessionData r1 = r1.build()
            r0.trackEvent(r1)
        L_0x0219:
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r0 = r13.requests
            int r0 = r0.size()
            if (r0 != 0) goto L_0x022d
            java.lang.String r14 = r14.getId()
            java.util.List r0 = java.util.Collections.emptyList()
            r12.onAssetDownloadFinished(r13, r14, r0, r5)
            return
        L_0x022d:
            java.lang.String r0 = TAG
            java.lang.Object[] r1 = new java.lang.Object[r3]
            com.vungle.warren.AdRequest r2 = r13.request
            r1[r4] = r2
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r1[r5] = r2
            java.lang.String r2 = "Start to download assets,  request = %1$s at: %2$d"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            java.lang.String r2 = "ttDownloadContext"
            com.vungle.warren.VungleLogger.verbose(r5, r0, r2, r1)
            com.vungle.warren.downloader.AssetDownloadListener r14 = r12.getAssetDownloadListener(r14, r13)
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r13 = r13.requests
            java.util.Iterator r13 = r13.iterator()
        L_0x0254:
            boolean r0 = r13.hasNext()
            if (r0 == 0) goto L_0x0266
            java.lang.Object r0 = r13.next()
            com.vungle.warren.downloader.DownloadRequest r0 = (com.vungle.warren.downloader.DownloadRequest) r0
            com.vungle.warren.downloader.Downloader r1 = r12.downloader
            r1.download(r0, r14)
            goto L_0x0254
        L_0x0266:
            return
        L_0x0267:
            java.lang.Object[] r1 = new java.lang.Object[r3]
            com.vungle.warren.AdRequest r3 = r13.request
            r1[r4] = r3
            r1[r5] = r14
            java.lang.String r3 = "Cannot save advertisement op.request = %1$s; advertisement = %2$s"
            java.lang.String r1 = java.lang.String.format(r3, r1)
            com.vungle.warren.VungleLogger.error(r2, r1)
            com.vungle.warren.error.VungleException r1 = new com.vungle.warren.error.VungleException
            r1.<init>(r0)
            com.vungle.warren.AdRequest r13 = r13.request
            java.lang.String r14 = r14.getId()
            r12.onDownloadFailed(r1, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.AdLoader.downloadAdAssets(com.vungle.warren.AdLoader$Operation, com.vungle.warren.model.Advertisement):void");
    }

    private DownloadRequest getDownloadRequest(int i, AdAsset adAsset, String str) {
        return new DownloadRequest(3, getAssetPriority(i, adAsset.localPath), adAsset.serverPath, adAsset.localPath, false, adAsset.identifier, str);
    }

    private AssetPriority getAssetPriority(int i, String str) {
        return new AssetPriority(Math.max(-2147483646, i), getAssetPriority(str, this.adLoadOptimizationEnabled));
    }

    public static int getAssetPriority(String str, boolean z) {
        if (!z) {
            return 0;
        }
        return str.endsWith("template") ^ true ? 1 : 0;
    }

    private AssetDownloadListener getAssetDownloadListener(final Advertisement advertisement, final Operation operation) {
        return new AssetDownloadListener() {
            AtomicLong downloadCount = new AtomicLong((long) operation.requests.size());
            List<AssetDownloadListener.DownloadError> errors = Collections.synchronizedList(new ArrayList());

            public void onProgress(AssetDownloadListener.Progress progress, DownloadRequest downloadRequest) {
            }

            public void onError(final AssetDownloadListener.DownloadError downloadError, final DownloadRequest downloadRequest) {
                AdLoader.this.sdkExecutors.getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        AdAsset adAsset;
                        Log.e(AdLoader.TAG, "Download Failed");
                        DownloadRequest downloadRequest = downloadRequest;
                        if (downloadRequest != null) {
                            String str = downloadRequest.cookieString;
                            if (TextUtils.isEmpty(str)) {
                                adAsset = null;
                            } else {
                                adAsset = AdLoader.this.repository.load(str, AdAsset.class).get();
                            }
                            if (adAsset != null) {
                                AnonymousClass6.this.errors.add(downloadError);
                                adAsset.status = 2;
                                try {
                                    AdLoader.this.repository.save(adAsset);
                                } catch (DatabaseHelper.DBException unused) {
                                    AnonymousClass6.this.errors.add(new AssetDownloadListener.DownloadError(-1, new VungleException(26), 4));
                                }
                            } else {
                                AnonymousClass6.this.errors.add(new AssetDownloadListener.DownloadError(-1, new IOException("Downloaded file not found!"), 1));
                            }
                        } else {
                            AnonymousClass6.this.errors.add(new AssetDownloadListener.DownloadError(-1, new RuntimeException("error in request"), 4));
                        }
                        if (AnonymousClass6.this.downloadCount.decrementAndGet() <= 0) {
                            AdLoader.this.onAssetDownloadFinished(operation, advertisement.getId(), AnonymousClass6.this.errors, true);
                        }
                    }
                }, new Runnable() {
                    public void run() {
                        AdLoader.this.onCriticalFail(39, operation.request);
                    }
                });
            }

            public void onSuccess(final File file, final DownloadRequest downloadRequest) {
                AdLoader.this.sdkExecutors.getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        AdAsset adAsset;
                        boolean z = false;
                        if (!file.exists()) {
                            VungleLogger.error(AdLoader.GET_ASSET_DOWNLOAD_LISTENER_CONTEXT, String.format("Downloaded file %1$s doesn't exist", new Object[]{file.getPath()}));
                            AnonymousClass6.this.onError(new AssetDownloadListener.DownloadError(-1, new IOException("Downloaded file not found!"), 3), downloadRequest);
                            return;
                        }
                        String str = downloadRequest.cookieString;
                        if (str == null) {
                            adAsset = null;
                        } else {
                            adAsset = AdLoader.this.repository.load(str, AdAsset.class).get();
                        }
                        if (adAsset == null) {
                            Object[] objArr = new Object[2];
                            objArr[0] = str == null ? "id is null" : "repository returned null";
                            objArr[1] = downloadRequest;
                            VungleLogger.error(AdLoader.GET_ASSET_DOWNLOAD_LISTENER_CONTEXT, String.format("adAsset is null because %1$s, downloadRequest = %2$s", objArr));
                            AnonymousClass6.this.onError(new AssetDownloadListener.DownloadError(-1, new IOException("Downloaded file not found!"), 1), downloadRequest);
                            return;
                        }
                        adAsset.fileType = AdLoader.this.isZip(file) ? 0 : 2;
                        adAsset.fileSize = file.length();
                        adAsset.status = 3;
                        try {
                            AdLoader.this.repository.save(adAsset);
                            if (AdLoader.this.isZip(file)) {
                                boolean unused = AdLoader.this.injectOMIfNeeded(operation, advertisement);
                                AdLoader.this.processTemplate(operation, adAsset, advertisement);
                            }
                            if (AnonymousClass6.this.downloadCount.decrementAndGet() <= 0) {
                                if (advertisement.isNativeTemplateType() || !AdLoader.this.isAdLoadOptimizationEnabled(advertisement)) {
                                    z = true;
                                }
                                AdLoader.this.onAssetDownloadFinished(operation, advertisement.getId(), AnonymousClass6.this.errors, z);
                            }
                        } catch (DatabaseHelper.DBException e) {
                            VungleLogger.error(AdLoader.GET_ASSET_DOWNLOAD_LISTENER_CONTEXT, String.format("Can't save adAsset %1$s; exception = %2$s", new Object[]{adAsset, e}));
                            AnonymousClass6.this.onError(new AssetDownloadListener.DownloadError(-1, new VungleException(26), 4), downloadRequest);
                        }
                    }
                }, new Runnable() {
                    public void run() {
                        AdLoader.this.onCriticalFail(39, operation.request);
                    }
                });
            }
        };
    }

    /* access modifiers changed from: private */
    public boolean isZip(File file) {
        return file.getName().equals(Advertisement.KEY_POSTROLL) || file.getName().equals("template");
    }

    private boolean isUrlValid(String str) {
        return !TextUtils.isEmpty(str) && (URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str));
    }

    /* access modifiers changed from: private */
    public void processTemplate(Operation operation, AdAsset adAsset, Advertisement advertisement) {
        Operation operation2 = operation;
        AdAsset adAsset2 = adAsset;
        Advertisement advertisement2 = advertisement;
        if (adAsset2.status != 3) {
            onDownloadFailed(new VungleException(24), operation2.request, advertisement.getId());
            return;
        }
        File file = new File(adAsset2.localPath);
        if (!fileIsValid(file, adAsset2)) {
            VungleLogger.error(ON_ASSET_DOWNLOAD_FINISHED_CONTEXT, String.format("Assets file not valid %1$s; asset = %2$s,request = %3$s; advertisement = %4$s", new Object[]{file.getPath(), adAsset.toString(), operation2.request, advertisement2}));
            onDownloadFailed(new VungleException(24), operation2.request, advertisement.getId());
            return;
        }
        if (adAsset2.fileType == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            VungleLogger.verbose(true, TAG, TT_DOWNLOAD_CONTEXT, String.format("Start to unzip assets, request  = %1$s, at: %2$d", new Object[]{operation2.request, Long.valueOf(currentTimeMillis)}));
            try {
                unzipFile(advertisement2, adAsset2, file, this.repository.loadAllAdAssets(advertisement.getId()).get());
                VungleLogger.verbose(true, TAG, TT_DOWNLOAD_CONTEXT, String.format("Unzip assets completed, request  = %1$s, elapsed time = %2$dms", new Object[]{operation2.request, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)}));
            } catch (IOException unused) {
                VungleLogger.error(ON_ASSET_DOWNLOAD_FINISHED_CONTEXT, String.format("Unzip failed %1$s; asset = %2$s,request = %3$s; advertisement = %4$s", new Object[]{file.getPath(), adAsset.toString(), operation2.request, advertisement2}));
                this.downloader.dropCache(adAsset2.serverPath);
                onDownloadFailed(new VungleException(24), operation2.request, advertisement.getId());
                return;
            } catch (DatabaseHelper.DBException e) {
                VungleLogger.error(ON_ASSET_DOWNLOAD_FINISHED_CONTEXT, String.format("Issue(s) with database: exception = %1$s; asset = %2$s,request = %3$s; advertisement = %4$s", new Object[]{e, adAsset.toString(), operation2.request, advertisement2}));
                onDownloadFailed(new VungleException(26), operation2.request, advertisement.getId());
                return;
            }
        }
        if (isAdLoadOptimizationEnabled(advertisement2)) {
            VungleLogger.verbose(true, TAG, TT_DOWNLOAD_CONTEXT, String.format("Ad ready to play, request  = %1$s, elapsed time = %2$dms", new Object[]{operation2.request, Long.valueOf(System.currentTimeMillis() - advertisement2.adRequestStartTime)}));
            onDownloadCompleted(operation2.request, advertisement.getId());
        }
    }

    /* access modifiers changed from: private */
    public boolean injectOMIfNeeded(Operation operation, Advertisement advertisement) {
        if (advertisement.getOmEnabled()) {
            try {
                File destinationDir = getDestinationDir(advertisement);
                if (destinationDir != null) {
                    if (destinationDir.isDirectory()) {
                        for (File next : this.omInjector.injectJsFiles(destinationDir)) {
                            AdAsset adAsset = new AdAsset(advertisement.getId(), (String) null, next.getPath());
                            adAsset.fileSize = next.length();
                            adAsset.fileType = 2;
                            adAsset.status = 3;
                            this.repository.save(adAsset);
                        }
                    }
                }
                Object[] objArr = new Object[3];
                objArr[0] = destinationDir == null ? "null" : NOT_A_DIR;
                objArr[1] = operation.request;
                objArr[2] = advertisement;
                VungleLogger.error(ON_ASSET_DOWNLOAD_FINISHED_CONTEXT, String.format("Mraid ad; bad destinationDir - %1$srequest = %2$s; advertisement = %3$s", objArr));
                onDownloadFailed(new VungleException(26), operation.request, advertisement.getId());
                return false;
            } catch (IOException unused) {
                onDownloadFailed(new VungleException(24), operation.request, advertisement.getId());
                return false;
            } catch (DatabaseHelper.DBException unused2) {
                onDownloadFailed(new VungleException(26), operation.request, advertisement.getId());
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void onAssetDownloadFinished(Operation operation, String str, List<AssetDownloadListener.DownloadError> list, boolean z) {
        Operation operation2 = operation;
        String str2 = str;
        VungleLogger.verbose(true, TAG, TT_DOWNLOAD_CONTEXT, String.format("Assets download completed, request  = %1$s, at: %2$d", new Object[]{operation2.request, Long.valueOf(System.currentTimeMillis())}));
        if (list.isEmpty()) {
            Advertisement advertisement = this.repository.load(str2, Advertisement.class).get();
            if (advertisement == null) {
                VungleLogger.error(DOWNLOAD_AD_CALLBACK_ON_DOWNLOAD_COMPLETED_CONTEXT, String.format("advertisement is null: request = %1$s; advertisementId = %2$s", new Object[]{operation2.request, str2}));
                onDownloadFailed(new VungleException(11), operation2.request, str2);
                return;
            }
            List<AdAsset> list2 = this.repository.loadAllAdAssets(str2).get();
            String str3 = "null";
            if (list2 == null || list2.size() == 0) {
                Object[] objArr = new Object[3];
                if (list2 != null) {
                    str3 = "empty";
                }
                objArr[0] = str3;
                objArr[1] = operation2.request;
                objArr[2] = str2;
                VungleLogger.error(ON_ASSET_DOWNLOAD_FINISHED_CONTEXT, String.format("Assets are %1$s; request = %2$s; advertisement = %3$s", objArr));
                if (z) {
                    onDownloadFailed(new VungleException(24), operation2.request, str2);
                    return;
                }
                return;
            }
            for (AdAsset adAsset : list2) {
                if (adAsset.status == 3) {
                    File file = new File(adAsset.localPath);
                    if (!fileIsValid(file, adAsset)) {
                        VungleLogger.error(ON_ASSET_DOWNLOAD_FINISHED_CONTEXT, String.format("Assets file not valid %1$s; asset = %2$s,request = %3$s; advertisement = %4$s", new Object[]{file.getPath(), adAsset.toString(), operation2.request, advertisement}));
                        if (z) {
                            onDownloadFailed(new VungleException(24), operation2.request, advertisement.getId());
                            return;
                        }
                        return;
                    }
                } else if (adAsset.fileType == 0 && adAsset.status != 4) {
                    VungleLogger.error(ON_ASSET_DOWNLOAD_FINISHED_CONTEXT, String.format("Zip asset left unprocessed asset = %1$s,request = %2$s; advertisement = %3$s", new Object[]{adAsset.toString(), operation2.request, advertisement}));
                    onDownloadFailed(new VungleException(24), operation2.request, advertisement.getId());
                    return;
                }
            }
            if (advertisement.getAdType() == 1) {
                File destinationDir = getDestinationDir(advertisement);
                if (destinationDir == null || !destinationDir.isDirectory()) {
                    Object[] objArr2 = new Object[3];
                    if (destinationDir != null) {
                        str3 = NOT_A_DIR;
                    }
                    objArr2[0] = str3;
                    objArr2[1] = operation2.request;
                    objArr2[2] = advertisement;
                    VungleLogger.error(ON_ASSET_DOWNLOAD_FINISHED_CONTEXT, String.format("Mraid ad; bad destinationDir - %1$srequest = %2$s; advertisement = %3$s", objArr2));
                    if (z) {
                        onDownloadFailed(new VungleException(26), operation2.request, advertisement.getId());
                        return;
                    }
                    return;
                }
                String str4 = TAG;
                Log.d(str4, "saving MRAID for " + advertisement.getId());
                advertisement.setMraidAssetDir(destinationDir);
                try {
                    this.repository.save(advertisement);
                } catch (DatabaseHelper.DBException e) {
                    VungleLogger.error(ON_ASSET_DOWNLOAD_FINISHED_CONTEXT, String.format("Issue(s) with database: can't save advertisement;exception = %1$s; request = %2$s; advertisement = %3$s", new Object[]{e, operation2.request, advertisement}));
                    if (z) {
                        onDownloadFailed(new VungleException(26), operation2.request, advertisement.getId());
                        return;
                    }
                    return;
                }
            }
            if (z) {
                onDownloadCompleted(operation2.request, advertisement.getId());
                return;
            }
            return;
        }
        VungleException vungleException = null;
        Iterator<AssetDownloadListener.DownloadError> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AssetDownloadListener.DownloadError next = it.next();
            if (VungleException.getExceptionCode(next.cause) != 26) {
                if (recoverableServerCode(next.serverCode) && next.reason == 1) {
                    vungleException = new VungleException(23);
                } else if (next.reason == 0) {
                    vungleException = new VungleException(23);
                } else {
                    vungleException = new VungleException(24);
                }
                if (vungleException.getExceptionCode() == 24) {
                    break;
                }
            } else {
                vungleException = new VungleException(26);
                break;
            }
        }
        if (z) {
            onDownloadFailed(vungleException, operation2.request, str2);
        }
    }

    public void onDownloadCompleted(AdRequest adRequest, String str) {
        Advertisement advertisement;
        String str2 = TAG;
        Log.d(str2, "download completed " + adRequest);
        Placement placement = this.repository.load(adRequest.getPlacementId(), Placement.class).get();
        if (placement == null) {
            VungleLogger.error(DOWNLOAD_AD_CALLBACK_ON_DOWNLOAD_COMPLETED_CONTEXT, String.format("loaded placement is null: request = %1$s; advertisementId = %2$s", new Object[]{adRequest, str}));
            onDownloadFailed(new VungleException(13), adRequest, str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            advertisement = null;
        } else {
            advertisement = this.repository.load(str, Advertisement.class).get();
        }
        if (advertisement == null) {
            VungleLogger.error(DOWNLOAD_AD_CALLBACK_ON_DOWNLOAD_COMPLETED_CONTEXT, String.format("advertisement is null: request = %1$s; advertisementId = %2$s", new Object[]{adRequest, str}));
            onDownloadFailed(new VungleException(11), adRequest, str);
            return;
        }
        advertisement.setFinishedDownloadingTime(System.currentTimeMillis());
        try {
            this.repository.saveAndApplyState(advertisement, adRequest.getPlacementId(), 1);
            onReady(adRequest, placement, advertisement);
        } catch (DatabaseHelper.DBException e) {
            VungleLogger.error(DOWNLOAD_AD_CALLBACK_ON_DOWNLOAD_COMPLETED_CONTEXT, String.format("Can't save/apply state READY: exception = %1$s;request = %2$s; advertisement = %3$s", new Object[]{e, adRequest, advertisement}));
            onDownloadFailed(new VungleException(26), adRequest, str);
        }
    }

    public void onReady(AdRequest adRequest, Placement placement, Advertisement advertisement) {
        setLoading(adRequest, false);
        HeaderBiddingCallback headerBiddingCallback = this.runtimeValues.headerBiddingCallback.get();
        if (!(advertisement == null || !placement.isHeaderBidding() || headerBiddingCallback == null)) {
            headerBiddingCallback.adAvailableForBidToken(adRequest.getPlacementId(), advertisement.getBidToken());
        }
        String str = TAG;
        Log.i(str, "found already cached valid adv, calling onAdLoad callback for request " + adRequest);
        InitCallback initCallback = this.runtimeValues.initCallback.get();
        int type = adRequest.getType();
        if (placement.isAutoCached() && initCallback != null && (type == 2 || type == 0)) {
            initCallback.onAutoCacheAdAvailable(adRequest.getPlacementId());
        }
        Operation remove = this.loadOperations.remove(adRequest);
        String str2 = null;
        String id = advertisement != null ? advertisement.getId() : null;
        if (remove != null) {
            placement.setAdSize(remove.size);
            try {
                this.repository.save(placement);
                String str3 = TAG;
                Log.i(str3, "loading took " + (System.currentTimeMillis() - adRequest.timeStamp.get()) + "ms for:" + adRequest);
                if (adRequest.getIsExplicit()) {
                    SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.LOAD_AD_END).addData(SessionAttribute.SUCCESS, true).addData(SessionAttribute.PLACEMENT_ID, placement.getId()).build());
                }
                for (LoadAdCallback next : remove.loadAdCallbacks) {
                    if (next instanceof LoadNativeAdCallbackWrapper) {
                        ((LoadNativeAdCallbackWrapper) next).onAdLoad(advertisement);
                    } else {
                        next.onAdLoad(adRequest.getPlacementId());
                    }
                }
                SessionTracker instance = SessionTracker.getInstance();
                SessionData.Builder event = new SessionData.Builder().setEvent(SessionEvent.AD_AVAILABLE);
                SessionAttribute sessionAttribute = SessionAttribute.EVENT_ID;
                if (advertisement != null) {
                    str2 = advertisement.getId();
                }
                instance.trackEvent(event.addData(sessionAttribute, str2).addData(SessionAttribute.PLACEMENT_ID, adRequest.getPlacementId()).build());
                if (adRequest.getIsExplicit()) {
                    sendWinNotification(remove, advertisement != null ? advertisement.getWinNotifications() : new ArrayList());
                }
            } catch (DatabaseHelper.DBException e) {
                VungleLogger.error("AdLoader#DownloadAdCallback#onReady; loadAd sequence", String.format("Can't save placement: exception = %1$s;placement = %2$s; advertisement = %3$s", new Object[]{e, placement, advertisement}));
                onDownloadFailed(new VungleException(26), adRequest, id);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ea A[SYNTHETIC, Splitter:B:48:0x00ea] */
    /* JADX WARNING: Removed duplicated region for block: B:79:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDownloadFailed(com.vungle.warren.error.VungleException r12, com.vungle.warren.AdRequest r13, java.lang.String r14) {
        /*
            r11 = this;
            java.util.Map<com.vungle.warren.AdRequest, com.vungle.warren.AdLoader$Operation> r0 = r11.loadOperations
            java.lang.Object r0 = r0.remove(r13)
            com.vungle.warren.AdLoader$Operation r0 = (com.vungle.warren.AdLoader.Operation) r0
            r11.tryLoadNextInQueue(r13)
            com.vungle.warren.persistence.Repository r1 = r11.repository
            java.lang.String r2 = r13.getPlacementId()
            java.lang.Class<com.vungle.warren.model.Placement> r3 = com.vungle.warren.model.Placement.class
            com.vungle.warren.persistence.FutureResult r1 = r1.load(r2, r3)
            java.lang.Object r1 = r1.get()
            com.vungle.warren.model.Placement r1 = (com.vungle.warren.model.Placement) r1
            if (r14 != 0) goto L_0x0021
            r14 = 0
            goto L_0x002f
        L_0x0021:
            com.vungle.warren.persistence.Repository r2 = r11.repository
            java.lang.Class<com.vungle.warren.model.Advertisement> r3 = com.vungle.warren.model.Advertisement.class
            com.vungle.warren.persistence.FutureResult r14 = r2.load(r14, r3)
            java.lang.Object r14 = r14.get()
            com.vungle.warren.model.Advertisement r14 = (com.vungle.warren.model.Advertisement) r14
        L_0x002f:
            r2 = 26
            r3 = 4
            r4 = 0
            if (r1 != 0) goto L_0x0066
            if (r14 == 0) goto L_0x0046
            com.vungle.warren.persistence.Repository r1 = r11.repository     // Catch:{ DBException -> 0x0041 }
            java.lang.String r5 = r13.getPlacementId()     // Catch:{ DBException -> 0x0041 }
            r1.saveAndApplyState(r14, r5, r3)     // Catch:{ DBException -> 0x0041 }
            goto L_0x0046
        L_0x0041:
            com.vungle.warren.error.VungleException r12 = new com.vungle.warren.error.VungleException
            r12.<init>(r2)
        L_0x0046:
            if (r0 == 0) goto L_0x0062
            java.util.Set<com.vungle.warren.LoadAdCallback> r14 = r0.loadAdCallbacks
            java.util.Iterator r14 = r14.iterator()
        L_0x004e:
            boolean r0 = r14.hasNext()
            if (r0 == 0) goto L_0x0062
            java.lang.Object r0 = r14.next()
            com.vungle.warren.LoadAdCallback r0 = (com.vungle.warren.LoadAdCallback) r0
            java.lang.String r1 = r13.getPlacementId()
            r0.onError(r1, r12)
            goto L_0x004e
        L_0x0062:
            r11.setLoading(r13, r4)
            return
        L_0x0066:
            if (r1 == 0) goto L_0x0094
            boolean r5 = r13.getIsExplicit()
            if (r5 == 0) goto L_0x0094
            com.vungle.warren.SessionTracker r5 = com.vungle.warren.SessionTracker.getInstance()
            com.vungle.warren.model.SessionData$Builder r6 = new com.vungle.warren.model.SessionData$Builder
            r6.<init>()
            com.vungle.warren.session.SessionEvent r7 = com.vungle.warren.session.SessionEvent.LOAD_AD_END
            com.vungle.warren.model.SessionData$Builder r6 = r6.setEvent(r7)
            com.vungle.warren.session.SessionAttribute r7 = com.vungle.warren.session.SessionAttribute.SUCCESS
            com.vungle.warren.model.SessionData$Builder r6 = r6.addData((com.vungle.warren.session.SessionAttribute) r7, (boolean) r4)
            com.vungle.warren.session.SessionAttribute r7 = com.vungle.warren.session.SessionAttribute.PLACEMENT_ID
            java.lang.String r1 = r1.getId()
            com.vungle.warren.model.SessionData$Builder r1 = r6.addData((com.vungle.warren.session.SessionAttribute) r7, (java.lang.String) r1)
            com.vungle.warren.model.SessionData r1 = r1.build()
            r5.trackEvent(r1)
        L_0x0094:
            int r1 = r12.getExceptionCode()
            r5 = 1
            if (r1 == r5) goto L_0x00c1
            r6 = 14
            if (r1 == r6) goto L_0x00c1
            r6 = 20
            if (r1 == r6) goto L_0x00bd
            r6 = 25
            if (r1 == r6) goto L_0x00c1
            r6 = 36
            if (r1 == r6) goto L_0x00c1
            r6 = 22
            if (r1 == r6) goto L_0x00bd
            r6 = 23
            if (r1 == r6) goto L_0x00b4
            goto L_0x00b9
        L_0x00b4:
            if (r14 == 0) goto L_0x00b9
            r1 = r4
            r7 = r1
            goto L_0x00bf
        L_0x00b9:
            r7 = r3
            r1 = r4
            r6 = r1
            goto L_0x00c4
        L_0x00bd:
            r7 = r3
            r1 = r4
        L_0x00bf:
            r6 = r5
            goto L_0x00c4
        L_0x00c1:
            r7 = r3
            r6 = r4
            r1 = r5
        L_0x00c4:
            if (r0 == 0) goto L_0x00ca
            boolean r8 = r0.logError
            if (r8 == 0) goto L_0x00e5
        L_0x00ca:
            java.lang.String r8 = TAG
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Failed to load Ad/Assets for "
            r9.append(r10)
            r9.append(r13)
            java.lang.String r10 = ". Cause : "
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            android.util.Log.e(r8, r9, r12)
        L_0x00e5:
            r11.setLoading(r13, r4)
            if (r0 == 0) goto L_0x0177
            int r8 = r0.policy     // Catch:{ DBException -> 0x0158 }
            r9 = 2
            if (r8 != 0) goto L_0x011b
            int r1 = r0.retry     // Catch:{ DBException -> 0x0158 }
            int r4 = r0.retryLimit     // Catch:{ DBException -> 0x0158 }
            if (r1 >= r4) goto L_0x014c
            if (r6 == 0) goto L_0x014c
            if (r14 == 0) goto L_0x0103
            com.vungle.warren.persistence.Repository r12 = r11.repository     // Catch:{ DBException -> 0x0158 }
            java.lang.String r1 = r13.getPlacementId()     // Catch:{ DBException -> 0x0158 }
            r12.saveAndApplyState(r14, r1, r7)     // Catch:{ DBException -> 0x0158 }
        L_0x0103:
            long r3 = r0.retryDelay     // Catch:{ DBException -> 0x0158 }
            com.vungle.warren.AdLoader$Operation r12 = r0.delay(r3)     // Catch:{ DBException -> 0x0158 }
            long r3 = r0.retryDelay     // Catch:{ DBException -> 0x0158 }
            long r3 = r3 * r9
            com.vungle.warren.AdLoader$Operation r12 = r12.retryDelay(r3)     // Catch:{ DBException -> 0x0158 }
            int r14 = r0.retry     // Catch:{ DBException -> 0x0158 }
            int r14 = r14 + r5
            com.vungle.warren.AdLoader$Operation r12 = r12.retry(r14)     // Catch:{ DBException -> 0x0158 }
            r11.load(r12)     // Catch:{ DBException -> 0x0158 }
            return
        L_0x011b:
            int r8 = r0.policy     // Catch:{ DBException -> 0x0158 }
            if (r8 != r5) goto L_0x014c
            if (r1 != 0) goto L_0x014c
            int r12 = r0.retry     // Catch:{ DBException -> 0x0158 }
            int r1 = r0.retryLimit     // Catch:{ DBException -> 0x0158 }
            if (r12 >= r1) goto L_0x012c
            if (r6 == 0) goto L_0x012c
            int r4 = r12 + 1
            r3 = r7
        L_0x012c:
            if (r14 == 0) goto L_0x0137
            com.vungle.warren.persistence.Repository r12 = r11.repository     // Catch:{ DBException -> 0x0158 }
            java.lang.String r1 = r13.getPlacementId()     // Catch:{ DBException -> 0x0158 }
            r12.saveAndApplyState(r14, r1, r3)     // Catch:{ DBException -> 0x0158 }
        L_0x0137:
            long r5 = r0.retryDelay     // Catch:{ DBException -> 0x0158 }
            com.vungle.warren.AdLoader$Operation r12 = r0.delay(r5)     // Catch:{ DBException -> 0x0158 }
            long r5 = r0.retryDelay     // Catch:{ DBException -> 0x0158 }
            long r5 = r5 * r9
            com.vungle.warren.AdLoader$Operation r12 = r12.retryDelay(r5)     // Catch:{ DBException -> 0x0158 }
            com.vungle.warren.AdLoader$Operation r12 = r12.retry(r4)     // Catch:{ DBException -> 0x0158 }
            r11.load(r12)     // Catch:{ DBException -> 0x0158 }
            return
        L_0x014c:
            if (r14 == 0) goto L_0x015d
            com.vungle.warren.persistence.Repository r1 = r11.repository     // Catch:{ DBException -> 0x0158 }
            java.lang.String r4 = r13.getPlacementId()     // Catch:{ DBException -> 0x0158 }
            r1.saveAndApplyState(r14, r4, r3)     // Catch:{ DBException -> 0x0158 }
            goto L_0x015d
        L_0x0158:
            com.vungle.warren.error.VungleException r12 = new com.vungle.warren.error.VungleException
            r12.<init>(r2)
        L_0x015d:
            java.util.Set<com.vungle.warren.LoadAdCallback> r14 = r0.loadAdCallbacks
            java.util.Iterator r14 = r14.iterator()
        L_0x0163:
            boolean r0 = r14.hasNext()
            if (r0 == 0) goto L_0x0177
            java.lang.Object r0 = r14.next()
            com.vungle.warren.LoadAdCallback r0 = (com.vungle.warren.LoadAdCallback) r0
            java.lang.String r1 = r13.getPlacementId()
            r0.onError(r1, r12)
            goto L_0x0163
        L_0x0177:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.AdLoader.onDownloadFailed(com.vungle.warren.error.VungleException, com.vungle.warren.AdRequest, java.lang.String):void");
    }

    public void onCriticalFail(int i, AdRequest adRequest) {
        onError(this.loadOperations.remove(adRequest), i);
    }

    public void load(AdRequest adRequest, AdConfig adConfig, LoadAdCallback loadAdCallback) {
        load(new Operation(adRequest, adConfig.getAdSize(), 0, 2000, 5, 0, 0, true, 0, loadAdCallback));
    }

    public void loadEndlessIfNeeded(Placement placement, AdConfig.AdSize adSize, long j, boolean z) {
        AdConfig.AdSize adSize2;
        Placement placement2;
        if (!placement.isMultipleHBPEnabled() || placement.getPlacementAdType() != 1 || AdConfig.AdSize.isBannerAdSize(adSize)) {
            placement2 = placement;
            adSize2 = adSize;
        } else {
            adSize2 = placement.getRecommendedAdSize();
            placement2 = placement;
        }
        if (!isSizeInvalid(placement2, adSize2)) {
            int autoCachePriority = placement.getAutoCachePriority();
            VungleSettings vungleSettings = this.runtimeValues.settings.get();
            int i = (vungleSettings == null || !placement.getId().equals(vungleSettings.getPriorityPlacement())) ? autoCachePriority : 0;
            AdRequest adRequest = null;
            if (placement.isMultipleHBPEnabled() && !placement.isSingleHBPEnabled()) {
                adRequest = new AdRequest(placement.getId(), 1, (long) placement.getMaxHbCache(), z);
            } else if (placement.isSingleHBPEnabled()) {
                adRequest = new AdRequest(placement.getId(), 2, 1, z);
            } else if (placement.isAutoCached()) {
                adRequest = new AdRequest(placement.getId(), 0, 1, z);
            }
            if (adRequest != null) {
                load(new Operation(adRequest, adSize2, j, 2000, 5, 1, 0, false, i, new LoadAdCallback[0]));
            }
        }
    }

    private void unzipFile(Advertisement advertisement, AdAsset adAsset, final File file, List<AdAsset> list) throws IOException, DatabaseHelper.DBException {
        final ArrayList arrayList = new ArrayList();
        for (AdAsset next : list) {
            if (next.fileType == 2) {
                arrayList.add(next.localPath);
            }
        }
        File destinationDir = getDestinationDir(advertisement);
        if (destinationDir == null || !destinationDir.isDirectory()) {
            Object[] objArr = new Object[2];
            objArr[0] = destinationDir == null ? "null" : NOT_A_DIR;
            objArr[1] = advertisement;
            VungleLogger.error("AdLoader#unzipFile; loadAd sequence", String.format("Can't unzip file: destination dir is %1$s; advertisement = %2$s", objArr));
            throw new IOException("Unable to access Destination Directory");
        }
        List<File> unzip = UnzipUtility.unzip(file.getPath(), destinationDir.getPath(), new UnzipUtility.Filter() {
            public boolean matches(String str) {
                File file = new File(str);
                for (String file2 : arrayList) {
                    File file3 = new File(file2);
                    if (file3.equals(file)) {
                        return false;
                    }
                    String path = file.getPath();
                    if (path.startsWith(file3.getPath() + File.separator)) {
                        return false;
                    }
                }
                return true;
            }
        });
        if (file.getName().equals("template")) {
            File file2 = new File(destinationDir.getPath() + File.separator + "mraid.js");
            if (file2.exists()) {
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file2, true)));
                HackMraid.apply(printWriter);
                printWriter.close();
            }
        }
        for (File next2 : unzip) {
            AdAsset adAsset2 = new AdAsset(advertisement.getId(), (String) null, next2.getPath());
            adAsset2.fileSize = next2.length();
            adAsset2.fileType = 1;
            adAsset2.parentId = adAsset.identifier;
            adAsset2.status = 3;
            this.repository.save(adAsset2);
        }
        String str = TAG;
        Log.d(str, "Uzipped " + destinationDir);
        FileUtility.printDirectoryTree(destinationDir);
        adAsset.status = 4;
        this.repository.save(adAsset, new Repository.SaveCallback() {
            public void onError(Exception exc) {
            }

            public void onSaved() {
                AdLoader.this.sdkExecutors.getBackgroundExecutor().execute(new Runnable() {
                    public void run() {
                        try {
                            FileUtility.delete(file);
                        } catch (IOException e) {
                            Log.e(AdLoader.TAG, "Error on deleting zip assets archive", e);
                        }
                    }
                });
            }
        });
    }

    /* access modifiers changed from: package-private */
    public boolean hasAssetsFor(Advertisement advertisement) throws IllegalStateException {
        List<AdAsset> list;
        if (advertisement == null || (list = this.repository.loadAllAdAssets(advertisement.getId()).get()) == null || list.size() == 0) {
            return false;
        }
        for (AdAsset adAsset : list) {
            if (adAsset.fileType == 0) {
                if (adAsset.status != 4) {
                    return false;
                }
            } else if ((!isUrlValid(adAsset.serverPath) || !isAdLoadOptimizationEnabled(advertisement)) && (adAsset.status != 3 || !fileIsValid(new File(adAsset.localPath), adAsset))) {
                return false;
            }
        }
        return true;
    }

    public boolean isAdLoadOptimizationEnabled(Advertisement advertisement) {
        if (!this.adLoadOptimizationEnabled || advertisement == null || advertisement.getAdType() != 1) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void sendWinNotification(Operation operation, List<String> list) {
        if (!list.isEmpty()) {
            JobRunner jobRunner = this.jobRunnerRef.get();
            if (jobRunner == null) {
                VungleLogger.error("AdLoader#load; loadAd sequence", String.format("Cannot load operation %s; job runner is null", new Object[]{operation}));
                onError(operation, 9);
                return;
            }
            new JobDelegateAnalytics(jobRunner).ping((String[]) list.toArray(new String[0]));
        }
    }

    private boolean fileIsValid(File file, AdAsset adAsset) {
        return file.exists() && file.length() == adAsset.fileSize;
    }

    /* access modifiers changed from: package-private */
    public Collection<Operation> getPendingOperations() {
        return this.pendingOperations.values();
    }

    /* access modifiers changed from: package-private */
    public Collection<Operation> getRunningOperations() {
        return this.loadOperations.values();
    }

    /* access modifiers changed from: package-private */
    public void setAdLoadOptimizationEnabled(boolean z) {
        this.adLoadOptimizationEnabled = z;
    }

    public void dropCache(String str) {
        List<AdAsset> list = this.repository.loadAllAdAssets(str).get();
        if (list == null) {
            Log.w(TAG, "No assets found in ad cache to cleanup");
            return;
        }
        HashSet hashSet = new HashSet();
        for (AdAsset adAsset : list) {
            hashSet.add(adAsset.serverPath);
        }
        Advertisement advertisement = this.repository.load(str, Advertisement.class).get();
        if (advertisement != null) {
            hashSet.addAll(advertisement.getDownloadableUrls().values());
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            this.downloader.dropCache((String) it.next());
        }
    }
}
