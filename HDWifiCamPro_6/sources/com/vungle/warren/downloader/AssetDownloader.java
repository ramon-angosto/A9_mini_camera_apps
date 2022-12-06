package com.vungle.warren.downloader;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.Pair;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.downloader.AssetDownloadListener;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.utility.FileUtility;
import com.vungle.warren.utility.NetworkProvider;
import com.vungle.warren.utility.VungleThreadPoolExecutor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLException;
import okhttp3.Cache;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okio.GzipSource;
import okio.Okio;
import okio.Source;

public class AssetDownloader implements Downloader {
    private static final String ACCEPT_ENCODING = "Accept-Encoding";
    private static final String ACCEPT_RANGES = "Accept-Ranges";
    private static final String BYTES = "bytes";
    private static final int CONNECTION_RETRY_TIMEOUT = 300;
    private static final String CONTENT_ENCODING = "Content-Encoding";
    private static final String CONTENT_RANGE = "Content-Range";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final int DOWNLOAD_CHUNK_SIZE = 2048;
    static final String DOWNLOAD_COMPLETE = "DOWNLOAD_COMPLETE";
    static final String DOWNLOAD_URL = "Download_URL";
    static final String ETAG = "ETag";
    private static final String GZIP = "gzip";
    private static final String IDENTITY = "identity";
    private static final String IF_MODIFIED_SINCE = "If-Modified-Since";
    private static final String IF_NONE_MATCH = "If-None-Match";
    private static final String IF_RANGE = "If-Range";
    private static final String KEY_TEMPLATE = "template";
    static final String LAST_CACHE_VERIFICATION = "Last-Cache-Verification";
    static final String LAST_DOWNLOAD = "Last-Download";
    static final String LAST_MODIFIED = "Last-Modified";
    private static final String LOAD_CONTEXT = "AssetDownloader#load; loadAd sequence";
    private static final long MAX_PERCENT = 100;
    private static final int MAX_RECONNECT_ATTEMPTS = 10;
    private static final String META_POSTFIX_EXT = ".vng_meta";
    private static final int PROGRESS_STEP = 5;
    private static final String RANGE = "Range";
    private static final int RANGE_NOT_SATISFIABLE = 416;
    private static final int RETRY_COUNT_ON_CONNECTION_LOST = 5;
    /* access modifiers changed from: private */
    public static final String TAG = AssetDownloader.class.getSimpleName();
    private static final int TIMEOUT = 30;
    public static final long VERIFICATION_WINDOW = TimeUnit.HOURS.toMillis(24);
    private final Object addLock;
    /* access modifiers changed from: private */
    public final DownloaderCache cache;
    private final VungleThreadPoolExecutor downloadExecutor;
    private boolean isCacheEnabled;
    int maxReconnectAttempts;
    private Map<String, DownloadRequestMediator> mediators;
    private final NetworkProvider.NetworkListener networkListener;
    private final NetworkProvider networkProvider;
    /* access modifiers changed from: private */
    public final OkHttpClient okHttpClient;
    /* access modifiers changed from: private */
    public volatile int progressStep;
    int reconnectTimeout;
    int retryCountOnConnectionLost;
    private final long timeWindow;
    private List<DownloadRequest> transitioning;
    private final ExecutorService uiExecutor;

    public @interface NetworkType {
        public static final int ANY = 3;
        public static final int CELLULAR = 1;
        public static final int WIFI = 2;
    }

    public AssetDownloader(NetworkProvider networkProvider2, VungleThreadPoolExecutor vungleThreadPoolExecutor, ExecutorService executorService) {
        this((DownloaderCache) null, 0, networkProvider2, vungleThreadPoolExecutor, executorService);
    }

    public AssetDownloader(DownloaderCache downloaderCache, long j, NetworkProvider networkProvider2, VungleThreadPoolExecutor vungleThreadPoolExecutor, ExecutorService executorService) {
        this.retryCountOnConnectionLost = 5;
        this.maxReconnectAttempts = 10;
        this.reconnectTimeout = 300;
        this.mediators = new ConcurrentHashMap();
        this.transitioning = new ArrayList();
        this.addLock = new Object();
        this.progressStep = 5;
        this.isCacheEnabled = true;
        this.networkListener = new NetworkProvider.NetworkListener() {
            public void onChanged(int i) {
                String access$000 = AssetDownloader.TAG;
                Log.d(access$000, "Network changed: " + i);
                AssetDownloader.this.onNetworkChanged(i);
            }
        };
        this.cache = downloaderCache;
        this.timeWindow = j;
        this.downloadExecutor = vungleThreadPoolExecutor;
        this.networkProvider = networkProvider2;
        this.uiExecutor = executorService;
        this.okHttpClient = new OkHttpClient.Builder().readTimeout(30, TimeUnit.SECONDS).connectTimeout(30, TimeUnit.SECONDS).cache((Cache) null).followRedirects(true).followSslRedirects(true).build();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void download(final com.vungle.warren.downloader.DownloadRequest r9, final com.vungle.warren.downloader.AssetDownloadListener r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 1
            if (r9 != 0) goto L_0x0020
            java.lang.String r9 = "AssetDownloader#download; loadAd sequence"
            java.lang.String r1 = "downloadRequest is null"
            com.vungle.warren.VungleLogger.error(r9, r1)     // Catch:{ all -> 0x005b }
            if (r10 == 0) goto L_0x001e
            r9 = 0
            com.vungle.warren.downloader.AssetDownloadListener$DownloadError r1 = new com.vungle.warren.downloader.AssetDownloadListener$DownloadError     // Catch:{ all -> 0x005b }
            r2 = -1
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x005b }
            java.lang.String r4 = "DownloadRequest is null"
            r3.<init>(r4)     // Catch:{ all -> 0x005b }
            r1.<init>(r2, r3, r0)     // Catch:{ all -> 0x005b }
            r8.deliverError(r9, r10, r1)     // Catch:{ all -> 0x005b }
        L_0x001e:
            monitor-exit(r8)
            return
        L_0x0020:
            java.lang.String r1 = TAG     // Catch:{ all -> 0x005b }
            java.lang.String r2 = "ttDownloadContext"
            java.lang.String r3 = "Waiting for download asset %1$s, at: %2$d"
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x005b }
            r5 = 0
            r4[r5] = r9     // Catch:{ all -> 0x005b }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x005b }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x005b }
            r4[r0] = r6     // Catch:{ all -> 0x005b }
            java.lang.String r3 = java.lang.String.format(r3, r4)     // Catch:{ all -> 0x005b }
            com.vungle.warren.VungleLogger.verbose(r0, r1, r2, r3)     // Catch:{ all -> 0x005b }
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r0 = r8.transitioning     // Catch:{ all -> 0x005b }
            r0.add(r9)     // Catch:{ all -> 0x005b }
            com.vungle.warren.utility.VungleThreadPoolExecutor r0 = r8.downloadExecutor     // Catch:{ all -> 0x005b }
            com.vungle.warren.downloader.AssetDownloader$1 r1 = new com.vungle.warren.downloader.AssetDownloader$1     // Catch:{ all -> 0x005b }
            com.vungle.warren.downloader.AssetPriority r2 = new com.vungle.warren.downloader.AssetPriority     // Catch:{ all -> 0x005b }
            r3 = -2147483647(0xffffffff80000001, float:-1.4E-45)
            r2.<init>(r3, r5)     // Catch:{ all -> 0x005b }
            r1.<init>(r2, r9, r10)     // Catch:{ all -> 0x005b }
            com.vungle.warren.downloader.AssetDownloader$2 r2 = new com.vungle.warren.downloader.AssetDownloader$2     // Catch:{ all -> 0x005b }
            r2.<init>(r9, r10)     // Catch:{ all -> 0x005b }
            r0.execute(r1, r2)     // Catch:{ all -> 0x005b }
            monitor-exit(r8)
            return
        L_0x005b:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.downloader.AssetDownloader.download(com.vungle.warren.downloader.DownloadRequest, com.vungle.warren.downloader.AssetDownloadListener):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r1.lock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0070, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r7.transitioning.remove(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007b, code lost:
        if (r1.is(6) != false) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0081, code lost:
        if (r1.is(3) == false) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0087, code lost:
        if (r8.isCancelled() != false) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008c, code lost:
        if (r1.isCacheable == false) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008e, code lost:
        r1.add(r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0096, code lost:
        if (r1.is(2) == false) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0098, code lost:
        load(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009c, code lost:
        com.vungle.warren.VungleLogger.warn("AssetDownloader#launchRequest; loadAd sequence", "request " + r8 + " is already running");
        deliverError(r8, r9, new com.vungle.warren.downloader.AssetDownloadListener.DownloadError(-1, new java.lang.IllegalArgumentException("DownloadRequest is already running"), 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c7, code lost:
        r8 = makeNewMediator(r8, r9);
        r7.mediators.put(r1.key, r8);
        load(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d5, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r1.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00da, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00de, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r1.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e2, code lost:
        throw r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void launchRequest(com.vungle.warren.downloader.DownloadRequest r8, com.vungle.warren.downloader.AssetDownloadListener r9) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.Object r0 = r7.addLock
            monitor-enter(r0)
            monitor-enter(r7)     // Catch:{ all -> 0x00e6 }
            boolean r1 = r8.isCancelled()     // Catch:{ all -> 0x00e3 }
            r2 = 1
            r3 = -1
            r4 = 3
            if (r1 == 0) goto L_0x0048
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r1 = r7.transitioning     // Catch:{ all -> 0x00e3 }
            r1.remove(r8)     // Catch:{ all -> 0x00e3 }
            java.lang.String r1 = TAG     // Catch:{ all -> 0x00e3 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e3 }
            r5.<init>()     // Catch:{ all -> 0x00e3 }
            java.lang.String r6 = "Request "
            r5.append(r6)     // Catch:{ all -> 0x00e3 }
            java.lang.String r6 = r8.url     // Catch:{ all -> 0x00e3 }
            r5.append(r6)     // Catch:{ all -> 0x00e3 }
            java.lang.String r6 = " is cancelled before starting"
            r5.append(r6)     // Catch:{ all -> 0x00e3 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00e3 }
            android.util.Log.d(r1, r5)     // Catch:{ all -> 0x00e3 }
            com.vungle.warren.downloader.AssetDownloadListener$Progress r1 = new com.vungle.warren.downloader.AssetDownloadListener$Progress     // Catch:{ all -> 0x00e3 }
            r1.<init>()     // Catch:{ all -> 0x00e3 }
            r1.status = r4     // Catch:{ all -> 0x00e3 }
            com.vungle.warren.downloader.AssetDownloadListener$DownloadError r1 = new com.vungle.warren.downloader.AssetDownloadListener$DownloadError     // Catch:{ all -> 0x00e3 }
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00e3 }
            java.lang.String r5 = "Cancelled"
            r4.<init>(r5)     // Catch:{ all -> 0x00e3 }
            r1.<init>(r3, r4, r2)     // Catch:{ all -> 0x00e3 }
            r7.deliverError(r8, r9, r1)     // Catch:{ all -> 0x00e3 }
            monitor-exit(r7)     // Catch:{ all -> 0x00e3 }
            monitor-exit(r0)     // Catch:{ all -> 0x00e6 }
            return
        L_0x0048:
            java.util.Map<java.lang.String, com.vungle.warren.downloader.DownloadRequestMediator> r1 = r7.mediators     // Catch:{ all -> 0x00e3 }
            java.lang.String r5 = r7.mediatorKeyFromRequest(r8)     // Catch:{ all -> 0x00e3 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x00e3 }
            com.vungle.warren.downloader.DownloadRequestMediator r1 = (com.vungle.warren.downloader.DownloadRequestMediator) r1     // Catch:{ all -> 0x00e3 }
            if (r1 != 0) goto L_0x006c
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r1 = r7.transitioning     // Catch:{ all -> 0x00e3 }
            r1.remove(r8)     // Catch:{ all -> 0x00e3 }
            com.vungle.warren.downloader.DownloadRequestMediator r8 = r7.makeNewMediator(r8, r9)     // Catch:{ all -> 0x00e3 }
            java.util.Map<java.lang.String, com.vungle.warren.downloader.DownloadRequestMediator> r9 = r7.mediators     // Catch:{ all -> 0x00e3 }
            java.lang.String r1 = r8.key     // Catch:{ all -> 0x00e3 }
            r9.put(r1, r8)     // Catch:{ all -> 0x00e3 }
            r7.load(r8)     // Catch:{ all -> 0x00e3 }
            monitor-exit(r7)     // Catch:{ all -> 0x00e3 }
            monitor-exit(r0)     // Catch:{ all -> 0x00e6 }
            return
        L_0x006c:
            monitor-exit(r7)     // Catch:{ all -> 0x00e3 }
            r1.lock()     // Catch:{ all -> 0x00de }
            monitor-enter(r7)     // Catch:{ all -> 0x00de }
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r5 = r7.transitioning     // Catch:{ all -> 0x00db }
            r5.remove(r8)     // Catch:{ all -> 0x00db }
            r5 = 6
            boolean r5 = r1.is(r5)     // Catch:{ all -> 0x00db }
            if (r5 != 0) goto L_0x00c7
            boolean r4 = r1.is(r4)     // Catch:{ all -> 0x00db }
            if (r4 == 0) goto L_0x008a
            boolean r4 = r8.isCancelled()     // Catch:{ all -> 0x00db }
            if (r4 != 0) goto L_0x008a
            goto L_0x00c7
        L_0x008a:
            boolean r4 = r1.isCacheable     // Catch:{ all -> 0x00db }
            if (r4 == 0) goto L_0x009c
            r1.add(r8, r9)     // Catch:{ all -> 0x00db }
            r8 = 2
            boolean r8 = r1.is(r8)     // Catch:{ all -> 0x00db }
            if (r8 == 0) goto L_0x00d5
            r7.load(r1)     // Catch:{ all -> 0x00db }
            goto L_0x00d5
        L_0x009c:
            java.lang.String r4 = "AssetDownloader#launchRequest; loadAd sequence"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00db }
            r5.<init>()     // Catch:{ all -> 0x00db }
            java.lang.String r6 = "request "
            r5.append(r6)     // Catch:{ all -> 0x00db }
            r5.append(r8)     // Catch:{ all -> 0x00db }
            java.lang.String r6 = " is already running"
            r5.append(r6)     // Catch:{ all -> 0x00db }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00db }
            com.vungle.warren.VungleLogger.warn(r4, r5)     // Catch:{ all -> 0x00db }
            com.vungle.warren.downloader.AssetDownloadListener$DownloadError r4 = new com.vungle.warren.downloader.AssetDownloadListener$DownloadError     // Catch:{ all -> 0x00db }
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00db }
            java.lang.String r6 = "DownloadRequest is already running"
            r5.<init>(r6)     // Catch:{ all -> 0x00db }
            r4.<init>(r3, r5, r2)     // Catch:{ all -> 0x00db }
            r7.deliverError(r8, r9, r4)     // Catch:{ all -> 0x00db }
            goto L_0x00d5
        L_0x00c7:
            com.vungle.warren.downloader.DownloadRequestMediator r8 = r7.makeNewMediator(r8, r9)     // Catch:{ all -> 0x00db }
            java.util.Map<java.lang.String, com.vungle.warren.downloader.DownloadRequestMediator> r9 = r7.mediators     // Catch:{ all -> 0x00db }
            java.lang.String r2 = r1.key     // Catch:{ all -> 0x00db }
            r9.put(r2, r8)     // Catch:{ all -> 0x00db }
            r7.load(r8)     // Catch:{ all -> 0x00db }
        L_0x00d5:
            monitor-exit(r7)     // Catch:{ all -> 0x00db }
            r1.unlock()     // Catch:{ all -> 0x00e6 }
            monitor-exit(r0)     // Catch:{ all -> 0x00e6 }
            return
        L_0x00db:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00db }
            throw r8     // Catch:{ all -> 0x00de }
        L_0x00de:
            r8 = move-exception
            r1.unlock()     // Catch:{ all -> 0x00e6 }
            throw r8     // Catch:{ all -> 0x00e6 }
        L_0x00e3:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00e3 }
            throw r8     // Catch:{ all -> 0x00e6 }
        L_0x00e6:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00e6 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.downloader.AssetDownloader.launchRequest(com.vungle.warren.downloader.DownloadRequest, com.vungle.warren.downloader.AssetDownloadListener):void");
    }

    private DownloadRequestMediator makeNewMediator(DownloadRequest downloadRequest, AssetDownloadListener assetDownloadListener) throws IOException {
        boolean z;
        String str;
        File file;
        File file2;
        if (!isCacheEnabled()) {
            file2 = new File(downloadRequest.path);
            file = new File(file2.getPath() + META_POSTFIX_EXT);
            str = downloadRequest.url + " " + downloadRequest.path;
            z = false;
        } else {
            file2 = this.cache.getFile(downloadRequest.url);
            file = this.cache.getMetaFile(file2);
            z = true;
            str = downloadRequest.url;
        }
        String str2 = str;
        boolean z2 = z;
        Log.d(TAG, "Destination file " + file2.getPath());
        return new DownloadRequestMediator(downloadRequest, assetDownloadListener, file2.getPath(), file.getPath(), z2, str2);
    }

    public synchronized List<DownloadRequest> getAllRequests() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (DownloadRequestMediator requests : new ArrayList(this.mediators.values())) {
            arrayList.addAll(requests.requests());
        }
        arrayList.addAll(this.transitioning);
        return arrayList;
    }

    private synchronized void load(final DownloadRequestMediator downloadRequestMediator) {
        addNetworkListener();
        downloadRequestMediator.set(1);
        this.downloadExecutor.execute(new DownloadPriorityRunnable(downloadRequestMediator) {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v1, resolved type: okhttp3.Call} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v0, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v1, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v4, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v2, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v3, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v4, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v5, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v6, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v7, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v8, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v9, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v10, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v11, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v12, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v13, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v14, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: java.lang.Object[]} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v17, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v18, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v19, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v20, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v21, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v22, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v13, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v23, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v24, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v17, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v70, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v14, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v15, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v73, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v29, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v74, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v75, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v35, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v36, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v37, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v38, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v16, resolved type: okio.BufferedSource} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v42, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v43, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v9, resolved type: okio.BufferedSink} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v10, resolved type: okio.BufferedSink} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v11, resolved type: okio.BufferedSink} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v44, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v45, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v46, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v49, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v50, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v51, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v19, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v52, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v143, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v144, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v146, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v20, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v45, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v46, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v27, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v25, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v54, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v29, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v31, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v51, resolved type: int} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v26, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v27, resolved type: okhttp3.Response} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v28, resolved type: okhttp3.Response} */
            /* JADX WARNING: type inference failed for: r18v0, types: [java.io.Closeable] */
            /* JADX WARNING: type inference failed for: r18v1 */
            /* JADX WARNING: type inference failed for: r18v2 */
            /* JADX WARNING: type inference failed for: r18v3 */
            /* JADX WARNING: type inference failed for: r18v4 */
            /* JADX WARNING: type inference failed for: r24v16, types: [java.lang.Long] */
            /* JADX WARNING: type inference failed for: r18v5 */
            /* JADX WARNING: type inference failed for: r18v6 */
            /* JADX WARNING: type inference failed for: r24v25 */
            /* JADX WARNING: type inference failed for: r24v26 */
            /* JADX WARNING: type inference failed for: r18v7 */
            /* JADX WARNING: type inference failed for: r24v27 */
            /* JADX WARNING: type inference failed for: r24v28 */
            /* JADX WARNING: type inference failed for: r24v31 */
            /* JADX WARNING: type inference failed for: r24v32 */
            /* JADX WARNING: type inference failed for: r24v33 */
            /* JADX WARNING: type inference failed for: r24v34 */
            /* JADX WARNING: type inference failed for: r24v39 */
            /* JADX WARNING: type inference failed for: r24v40 */
            /* JADX WARNING: type inference failed for: r24v41 */
            /* JADX WARNING: type inference failed for: r18v8 */
            /* JADX WARNING: type inference failed for: r24v47 */
            /* JADX WARNING: type inference failed for: r24v48 */
            /* JADX WARNING: type inference failed for: r18v12 */
            /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
                java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
                	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
                	at java.util.ArrayList.get(ArrayList.java:435)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
                	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:225)
                	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
                	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
                	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
                */
            /* JADX WARNING: Multi-variable type inference failed */
            public void run() {
                /*
                    r31 = this;
                    r1 = r31
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4
                    r2 = 0
                    r0.setRunnable(r2)
                    com.vungle.warren.downloader.AssetDownloadListener$Progress r3 = new com.vungle.warren.downloader.AssetDownloadListener$Progress
                    r3.<init>()
                    long r4 = java.lang.System.currentTimeMillis()
                    r3.timestampDownloadStart = r4
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4
                    java.lang.String r4 = r0.url
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4
                    java.lang.String r0 = r0.filePath
                    com.vungle.warren.downloader.DownloadRequestMediator r5 = r4
                    java.lang.String r5 = r5.metaPath
                    java.io.File r12 = new java.io.File
                    r12.<init>(r0)
                    java.io.File r13 = new java.io.File
                    r13.<init>(r5)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    if (r0 == 0) goto L_0x0040
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4
                    boolean r0 = r0.isCacheable
                    if (r0 == 0) goto L_0x0040
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.startTracking(r12)
                L_0x0040:
                    r15 = r2
                    r0 = 0
                    r11 = 0
                    r14 = 0
                L_0x0044:
                    if (r0 != 0) goto L_0x0e6d
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    java.lang.String r7 = "Start load: url: "
                    r6.append(r7)
                    r6.append(r4)
                    java.lang.String r6 = r6.toString()
                    android.util.Log.d(r0, r6)
                    r9 = 5
                    r7 = 2
                    r8 = 3
                    r6 = 4
                    r5 = 1
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4     // Catch:{ all -> 0x0a10 }
                    boolean r0 = r0.is(r5)     // Catch:{ all -> 0x0a10 }
                    if (r0 != 0) goto L_0x0160
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x014e }
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x014e }
                    r10.<init>()     // Catch:{ all -> 0x014e }
                    java.lang.String r5 = "Abort download, wrong state "
                    r10.append(r5)     // Catch:{ all -> 0x014e }
                    com.vungle.warren.downloader.AssetDownloader r5 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x014e }
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r4     // Catch:{ all -> 0x014e }
                    java.lang.String r2 = r5.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r2)     // Catch:{ all -> 0x014e }
                    r10.append(r2)     // Catch:{ all -> 0x014e }
                    java.lang.String r2 = r10.toString()     // Catch:{ all -> 0x014e }
                    android.util.Log.w(r0, r2)     // Catch:{ all -> 0x014e }
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "request is done "
                    r2.append(r3)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r4
                    java.lang.String r3 = r3.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r4)
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4
                    int r0 = r0.getStatus()
                    if (r0 == r7) goto L_0x00da
                    if (r0 == r8) goto L_0x00d3
                    if (r0 == r6) goto L_0x00cb
                    if (r0 == r9) goto L_0x00c3
                    if (r14 != 0) goto L_0x00da
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r4
                    r0.removeMediator(r2)
                    goto L_0x00da
                L_0x00c3:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r4
                    r0.onErrorMediator(r15, r2)
                    goto L_0x00da
                L_0x00cb:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r4
                    r0.onSuccessMediator(r12, r2)
                    goto L_0x00da
                L_0x00d3:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r4
                    r0.onCancelledMediator(r2)
                L_0x00da:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "Done with request in state "
                    r2.append(r3)
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r4
                    int r3 = r3.getStatus()
                    r2.append(r3)
                    java.lang.String r3 = " "
                    r2.append(r3)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r4
                    java.lang.String r3 = r3.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r4)
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r2)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x014b }
                    r0.removeNetworkListener()     // Catch:{ all -> 0x014b }
                    monitor-exit(r2)     // Catch:{ all -> 0x014b }
                    r2 = 0
                    com.vungle.warren.utility.FileUtility.closeQuietly(r2)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r2)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    if (r0 == 0) goto L_0x014a
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4
                    boolean r0 = r0.isCacheable
                    if (r0 == 0) goto L_0x014a
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r0 = r0.isCacheEnabled()
                    if (r0 != 0) goto L_0x0141
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.clear()
                    goto L_0x014a
                L_0x0141:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.purge()
                L_0x014a:
                    return
                L_0x014b:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x014b }
                    throw r0
                L_0x014e:
                    r0 = move-exception
                    r24 = r4
                    r4 = r7
                    r5 = r8
                    r7 = r9
                    r22 = r14
                    r6 = 0
                L_0x0157:
                    r8 = -1
                    r9 = 0
                    r14 = 0
                    r18 = 0
                    r26 = 0
                    goto L_0x0a22
                L_0x0160:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0a04 }
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r4     // Catch:{ all -> 0x0a04 }
                    boolean r0 = r0.isAnyConnected(r2)     // Catch:{ all -> 0x0a04 }
                    if (r0 == 0) goto L_0x09c6
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4     // Catch:{ all -> 0x0a04 }
                    r2 = 1
                    r0.setConnected(r2)     // Catch:{ all -> 0x0a04 }
                    java.io.File r0 = r12.getParentFile()     // Catch:{ all -> 0x0a04 }
                    if (r0 == 0) goto L_0x0187
                    java.io.File r0 = r12.getParentFile()     // Catch:{ all -> 0x014e }
                    boolean r0 = r0.exists()     // Catch:{ all -> 0x014e }
                    if (r0 != 0) goto L_0x0187
                    java.io.File r0 = r12.getParentFile()     // Catch:{ all -> 0x014e }
                    r0.mkdirs()     // Catch:{ all -> 0x014e }
                L_0x0187:
                    boolean r0 = r12.exists()     // Catch:{ all -> 0x0a04 }
                    r19 = 0
                    if (r0 == 0) goto L_0x0196
                    long r21 = r12.length()     // Catch:{ all -> 0x014e }
                    r9 = r21
                    goto L_0x0198
                L_0x0196:
                    r9 = r19
                L_0x0198:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x09bb }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x09bb }
                    r5.<init>()     // Catch:{ all -> 0x09bb }
                    java.lang.String r2 = "already downloaded : "
                    r5.append(r2)     // Catch:{ all -> 0x09bb }
                    r5.append(r9)     // Catch:{ all -> 0x09bb }
                    java.lang.String r2 = ", file exists = "
                    r5.append(r2)     // Catch:{ all -> 0x09bb }
                    boolean r2 = r12.exists()     // Catch:{ all -> 0x09bb }
                    r5.append(r2)     // Catch:{ all -> 0x09bb }
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x09bb }
                    com.vungle.warren.downloader.DownloadRequestMediator r8 = r4     // Catch:{ all -> 0x09b1 }
                    java.lang.String r2 = r2.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r8)     // Catch:{ all -> 0x09b1 }
                    r5.append(r2)     // Catch:{ all -> 0x09b1 }
                    java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x09b1 }
                    android.util.Log.d(r0, r2)     // Catch:{ all -> 0x09b1 }
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x09b1 }
                    java.util.HashMap r0 = r0.extractMeta(r13)     // Catch:{ all -> 0x09b1 }
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x09b1 }
                    com.vungle.warren.downloader.DownloadRequestMediator r5 = r4     // Catch:{ all -> 0x09b1 }
                    boolean r2 = r2.useCacheWithoutVerification(r5, r12, r0)     // Catch:{ all -> 0x09b1 }
                    if (r2 == 0) goto L_0x02e7
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4     // Catch:{ all -> 0x02dc }
                    java.lang.String r0 = r0.key     // Catch:{ all -> 0x02dc }
                    boolean r0 = com.vungle.warren.utility.FileUtility.isVideoFile(r0)     // Catch:{ all -> 0x02dc }
                    if (r0 == 0) goto L_0x0209
                    com.vungle.warren.SessionTracker r0 = com.vungle.warren.SessionTracker.getInstance()     // Catch:{ all -> 0x02dc }
                    com.vungle.warren.model.SessionData$Builder r2 = new com.vungle.warren.model.SessionData$Builder     // Catch:{ all -> 0x02dc }
                    r2.<init>()     // Catch:{ all -> 0x02dc }
                    com.vungle.warren.session.SessionEvent r5 = com.vungle.warren.session.SessionEvent.ADS_CACHED     // Catch:{ all -> 0x02dc }
                    com.vungle.warren.model.SessionData$Builder r2 = r2.setEvent(r5)     // Catch:{ all -> 0x02dc }
                    com.vungle.warren.session.SessionAttribute r5 = com.vungle.warren.session.SessionAttribute.URL     // Catch:{ all -> 0x02dc }
                    com.vungle.warren.downloader.DownloadRequestMediator r8 = r4     // Catch:{ all -> 0x02dc }
                    java.lang.String r8 = r8.key     // Catch:{ all -> 0x02dc }
                    com.vungle.warren.model.SessionData$Builder r2 = r2.addData((com.vungle.warren.session.SessionAttribute) r5, (java.lang.String) r8)     // Catch:{ all -> 0x02dc }
                    com.vungle.warren.session.SessionAttribute r5 = com.vungle.warren.session.SessionAttribute.VIDEO_CACHED     // Catch:{ all -> 0x02dc }
                    java.lang.String r8 = "cached"
                    com.vungle.warren.model.SessionData$Builder r2 = r2.addData((com.vungle.warren.session.SessionAttribute) r5, (java.lang.String) r8)     // Catch:{ all -> 0x02dc }
                    com.vungle.warren.model.SessionData r2 = r2.build()     // Catch:{ all -> 0x02dc }
                    r0.trackEvent(r2)     // Catch:{ all -> 0x02dc }
                L_0x0209:
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4     // Catch:{ all -> 0x02dc }
                    r0.set(r6)     // Catch:{ all -> 0x02dc }
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x02dc }
                    java.lang.String r2 = "Using cache without verification, dispatch existing file"
                    android.util.Log.d(r0, r2)     // Catch:{ all -> 0x02dc }
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "request is done "
                    r2.append(r3)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r4
                    java.lang.String r3 = r3.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r4)
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4
                    int r0 = r0.getStatus()
                    if (r0 == r7) goto L_0x0268
                    r2 = 3
                    if (r0 == r2) goto L_0x0261
                    if (r0 == r6) goto L_0x0259
                    r5 = 5
                    if (r0 == r5) goto L_0x0251
                    if (r14 != 0) goto L_0x0268
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r4
                    r0.removeMediator(r2)
                    goto L_0x0268
                L_0x0251:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r4
                    r0.onErrorMediator(r15, r2)
                    goto L_0x0268
                L_0x0259:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r4
                    r0.onSuccessMediator(r12, r2)
                    goto L_0x0268
                L_0x0261:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r4
                    r0.onCancelledMediator(r2)
                L_0x0268:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "Done with request in state "
                    r2.append(r3)
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r4
                    int r3 = r3.getStatus()
                    r2.append(r3)
                    java.lang.String r3 = " "
                    r2.append(r3)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r4
                    java.lang.String r3 = r3.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r4)
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.AssetDownloader r8 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r8)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x02d9 }
                    r0.removeNetworkListener()     // Catch:{ all -> 0x02d9 }
                    monitor-exit(r8)     // Catch:{ all -> 0x02d9 }
                    r2 = 0
                    com.vungle.warren.utility.FileUtility.closeQuietly(r2)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r2)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    if (r0 == 0) goto L_0x02d8
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4
                    boolean r0 = r0.isCacheable
                    if (r0 == 0) goto L_0x02d8
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r0 = r0.isCacheEnabled()
                    if (r0 != 0) goto L_0x02cf
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.clear()
                    goto L_0x02d8
                L_0x02cf:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.purge()
                L_0x02d8:
                    return
                L_0x02d9:
                    r0 = move-exception
                    monitor-exit(r8)     // Catch:{ all -> 0x02d9 }
                    throw r0
                L_0x02dc:
                    r0 = move-exception
                    r24 = r4
                    r4 = r7
                    r22 = r14
                    r5 = 3
                    r6 = 0
                    r7 = 5
                    goto L_0x0157
                L_0x02e7:
                    r2 = 3
                    r5 = 5
                    java.lang.String r8 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x09a4 }
                    java.lang.String r2 = "ttDownloadContext"
                    java.lang.String r5 = "Send network request: %1$s, at: %2$d"
                    java.lang.Object[] r6 = new java.lang.Object[r7]     // Catch:{ all -> 0x09b1 }
                    r16 = 0
                    r6[r16] = r4     // Catch:{ all -> 0x09b1 }
                    long r24 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x09b1 }
                    java.lang.Long r24 = java.lang.Long.valueOf(r24)     // Catch:{ all -> 0x09b1 }
                    r7 = 1
                    r6[r7] = r24     // Catch:{ all -> 0x098e }
                    java.lang.String r5 = java.lang.String.format(r5, r6)     // Catch:{ all -> 0x098e }
                    com.vungle.warren.VungleLogger.verbose(r7, r8, r2, r5)     // Catch:{ all -> 0x098e }
                    okhttp3.Request$Builder r2 = new okhttp3.Request$Builder     // Catch:{ all -> 0x098e }
                    r2.<init>()     // Catch:{ all -> 0x098e }
                    okhttp3.Request$Builder r2 = r2.url((java.lang.String) r4)     // Catch:{ all -> 0x098e }
                    com.vungle.warren.downloader.AssetDownloader r6 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x098e }
                    r5 = 4
                    r7 = r9
                    r21 = r9
                    r10 = 5
                    r9 = r12
                    r10 = r0
                    r5 = r11
                    r11 = r2
                    r6.appendHeaders(r7, r9, r10, r11)     // Catch:{ all -> 0x0981 }
                    com.vungle.warren.downloader.AssetDownloader r6 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0981 }
                    okhttp3.OkHttpClient r6 = r6.okHttpClient     // Catch:{ all -> 0x0981 }
                    okhttp3.Request r2 = r2.build()     // Catch:{ all -> 0x0981 }
                    okhttp3.Call r2 = r6.newCall(r2)     // Catch:{ all -> 0x0981 }
                    okhttp3.Response r6 = r2.execute()     // Catch:{ all -> 0x096e }
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x095f }
                    long r7 = r7.getContentLength(r6)     // Catch:{ all -> 0x095f }
                    java.lang.String r9 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x095f }
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x095f }
                    r10.<init>()     // Catch:{ all -> 0x095f }
                    java.lang.String r11 = "Response code: "
                    r10.append(r11)     // Catch:{ all -> 0x095f }
                    int r11 = r6.code()     // Catch:{ all -> 0x095f }
                    r10.append(r11)     // Catch:{ all -> 0x095f }
                    java.lang.String r11 = " "
                    r10.append(r11)     // Catch:{ all -> 0x095f }
                    com.vungle.warren.downloader.DownloadRequestMediator r11 = r4     // Catch:{ all -> 0x095f }
                    r10.append(r11)     // Catch:{ all -> 0x095f }
                    java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x095f }
                    android.util.Log.d(r9, r10)     // Catch:{ all -> 0x095f }
                    int r9 = r6.code()     // Catch:{ all -> 0x095f }
                    com.vungle.warren.downloader.AssetDownloader r10 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x094a }
                    com.vungle.warren.downloader.DownloadRequestMediator r11 = r4     // Catch:{ all -> 0x094a }
                    boolean r10 = r10.notModified(r12, r6, r11, r0)     // Catch:{ all -> 0x094a }
                    if (r10 != 0) goto L_0x0820
                    com.vungle.warren.downloader.AssetDownloader r10 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x080b }
                    com.vungle.warren.downloader.DownloadRequestMediator r11 = r4     // Catch:{ all -> 0x080b }
                    boolean r10 = r10.useCacheOnFail(r11, r12, r0, r9)     // Catch:{ all -> 0x080b }
                    if (r10 == 0) goto L_0x0378
                    goto L_0x0820
                L_0x0378:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x080b }
                    com.vungle.warren.downloader.DownloadRequestMediator r10 = r4     // Catch:{ all -> 0x080b }
                    r23 = r0
                    r24 = r21
                    r26 = r9
                    r27 = r6
                    r28 = r10
                    boolean r0 = r23.partialMalformed(r24, r26, r27, r28)     // Catch:{ all -> 0x080b }
                    if (r0 == 0) goto L_0x0428
                    int r11 = r5 + 1
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x041b }
                    int r0 = r0.maxReconnectAttempts     // Catch:{ all -> 0x041b }
                    if (r5 >= r0) goto L_0x0404
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x041b }
                    r5 = 0
                    r0.deleteFileAndMeta(r12, r13, r5)     // Catch:{ all -> 0x041b }
                    if (r6 == 0) goto L_0x03a9
                    okhttp3.ResponseBody r0 = r6.body()
                    if (r0 == 0) goto L_0x03a9
                    okhttp3.ResponseBody r0 = r6.body()
                    r0.close()
                L_0x03a9:
                    if (r2 == 0) goto L_0x03ae
                    r2.cancel()
                L_0x03ae:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r5 = "request is done "
                    r2.append(r5)
                    com.vungle.warren.downloader.AssetDownloader r5 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r6 = r4
                    java.lang.String r5 = r5.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r6)
                    r2.append(r5)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r5 = "Not removing connections and listener "
                    r2.append(r5)
                    com.vungle.warren.downloader.AssetDownloader r5 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r6 = r4
                    java.lang.String r5 = r5.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r6)
                    r2.append(r5)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.AssetDownloader r5 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r5)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0401 }
                    r0.removeNetworkListener()     // Catch:{ all -> 0x0401 }
                    monitor-exit(r5)     // Catch:{ all -> 0x0401 }
                    r2 = 0
                    com.vungle.warren.utility.FileUtility.closeQuietly(r2)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r2)
                    r0 = 0
                    goto L_0x0d60
                L_0x0401:
                    r0 = move-exception
                    monitor-exit(r5)     // Catch:{ all -> 0x0401 }
                    throw r0
                L_0x0404:
                    com.vungle.warren.downloader.Downloader$RequestException r0 = new com.vungle.warren.downloader.Downloader$RequestException     // Catch:{ all -> 0x041b }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x041b }
                    r5.<init>()     // Catch:{ all -> 0x041b }
                    java.lang.String r7 = "Code: "
                    r5.append(r7)     // Catch:{ all -> 0x041b }
                    r5.append(r9)     // Catch:{ all -> 0x041b }
                    java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x041b }
                    r0.<init>(r5)     // Catch:{ all -> 0x041b }
                    throw r0     // Catch:{ all -> 0x041b }
                L_0x041b:
                    r0 = move-exception
                    r26 = r2
                    r24 = r4
                L_0x0420:
                    r8 = r9
                    r22 = r14
                L_0x0423:
                    r4 = 2
                    r5 = 3
                    r7 = 5
                    goto L_0x081a
                L_0x0428:
                    boolean r0 = r6.isSuccessful()     // Catch:{ all -> 0x080b }
                    if (r0 == 0) goto L_0x07e1
                    r0 = 206(0xce, float:2.89E-43)
                    if (r9 == r0) goto L_0x0442
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x043b }
                    r10 = 0
                    r0.deleteFileAndMeta(r12, r13, r10)     // Catch:{ all -> 0x043b }
                    r10 = r19
                    goto L_0x0444
                L_0x043b:
                    r0 = move-exception
                    r26 = r2
                    r24 = r4
                    r11 = r5
                    goto L_0x0420
                L_0x0442:
                    r10 = r21
                L_0x0444:
                    com.vungle.warren.utility.FileUtility.deleteAndLogIfFailed(r13)     // Catch:{ all -> 0x07ce }
                    okhttp3.Headers r0 = r6.headers()     // Catch:{ all -> 0x07ce }
                    r21 = r5
                    com.vungle.warren.downloader.AssetDownloader r5 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x07c8 }
                    r5.checkEncoding(r12, r13, r0)     // Catch:{ all -> 0x07c8 }
                    com.vungle.warren.downloader.AssetDownloader r5 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x07c8 }
                    java.util.HashMap r0 = r5.makeMeta(r13, r0, r4)     // Catch:{ all -> 0x07c8 }
                    boolean r5 = okhttp3.internal.http.HttpHeaders.hasBody(r6)     // Catch:{ all -> 0x07c8 }
                    if (r5 == 0) goto L_0x07a2
                    com.vungle.warren.downloader.AssetDownloader r5 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x07c8 }
                    com.vungle.warren.downloader.DownloaderCache r5 = r5.cache     // Catch:{ all -> 0x07c8 }
                    if (r5 == 0) goto L_0x048e
                    com.vungle.warren.downloader.AssetDownloader r5 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0483 }
                    com.vungle.warren.downloader.DownloaderCache r5 = r5.cache     // Catch:{ all -> 0x0483 }
                    r22 = r14
                    r23 = r15
                    long r14 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0478 }
                    r5.setCacheLastUpdateTimestamp(r12, r14)     // Catch:{ all -> 0x0478 }
                    goto L_0x0492
                L_0x0478:
                    r0 = move-exception
                    r26 = r2
                    r24 = r4
                    r8 = r9
                    r11 = r21
                    r15 = r23
                    goto L_0x0423
                L_0x0483:
                    r0 = move-exception
                    r22 = r14
                    r26 = r2
                    r24 = r4
                    r8 = r9
                    r11 = r21
                    goto L_0x0423
                L_0x048e:
                    r22 = r14
                    r23 = r15
                L_0x0492:
                    com.vungle.warren.downloader.AssetDownloader r5 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0798 }
                    okhttp3.ResponseBody r5 = r5.decodeGzipIfNeeded(r6)     // Catch:{ all -> 0x0798 }
                    okio.BufferedSource r14 = r5.source()     // Catch:{ all -> 0x0798 }
                    java.lang.String r15 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0785 }
                    r24 = r4
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0781 }
                    r4.<init>()     // Catch:{ all -> 0x0781 }
                    r25 = r9
                    java.lang.String r9 = "Start download from bytes: "
                    r4.append(r9)     // Catch:{ all -> 0x077d }
                    r4.append(r10)     // Catch:{ all -> 0x077d }
                    com.vungle.warren.downloader.AssetDownloader r9 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x077d }
                    r26 = r2
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r4     // Catch:{ all -> 0x077b }
                    java.lang.String r2 = r9.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r2)     // Catch:{ all -> 0x077b }
                    r4.append(r2)     // Catch:{ all -> 0x077b }
                    java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x077b }
                    android.util.Log.d(r15, r2)     // Catch:{ all -> 0x077b }
                    long r7 = r7 + r10
                    java.lang.String r2 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x077b }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x077b }
                    r4.<init>()     // Catch:{ all -> 0x077b }
                    java.lang.String r9 = "final offset = "
                    r4.append(r9)     // Catch:{ all -> 0x077b }
                    r4.append(r10)     // Catch:{ all -> 0x077b }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x077b }
                    android.util.Log.d(r2, r4)     // Catch:{ all -> 0x077b }
                    int r2 = (r10 > r19 ? 1 : (r10 == r19 ? 0 : -1))
                    if (r2 != 0) goto L_0x04f3
                    okio.Sink r2 = okio.Okio.sink((java.io.File) r12)     // Catch:{ all -> 0x04e7 }
                    goto L_0x04f7
                L_0x04e7:
                    r0 = move-exception
                    r11 = r21
                    r15 = r23
                    r8 = r25
                    r4 = 2
                    r5 = 3
                    r7 = 5
                    goto L_0x0795
                L_0x04f3:
                    okio.Sink r2 = okio.Okio.appendingSink(r12)     // Catch:{ all -> 0x077b }
                L_0x04f7:
                    okio.BufferedSink r2 = okio.Okio.buffer((okio.Sink) r2)     // Catch:{ all -> 0x077b }
                    r4 = 0
                    r3.status = r4     // Catch:{ all -> 0x076c }
                    long r4 = r5.contentLength()     // Catch:{ all -> 0x076c }
                    r3.sizeBytes = r4     // Catch:{ all -> 0x076c }
                    r3.startBytes = r10     // Catch:{ all -> 0x076c }
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x076c }
                    com.vungle.warren.downloader.DownloadRequestMediator r5 = r4     // Catch:{ all -> 0x076c }
                    r4.onProgressMediator(r5, r3)     // Catch:{ all -> 0x076c }
                    r4 = r19
                    r9 = 0
                L_0x0510:
                    com.vungle.warren.downloader.DownloadRequestMediator r15 = r4     // Catch:{ all -> 0x076c }
                    r27 = r9
                    r9 = 1
                    boolean r15 = r15.is(r9)     // Catch:{ all -> 0x076c }
                    if (r15 == 0) goto L_0x05ec
                    okio.Buffer r9 = r2.buffer()     // Catch:{ all -> 0x05de }
                    r15 = r0
                    r0 = 2048(0x800, double:1.0118E-320)
                    long r0 = r14.read(r9, r0)     // Catch:{ all -> 0x05da }
                    r29 = -1
                    int r9 = (r0 > r29 ? 1 : (r0 == r29 ? 0 : -1))
                    if (r9 == 0) goto L_0x05d7
                    boolean r9 = r12.exists()     // Catch:{ all -> 0x05da }
                    if (r9 == 0) goto L_0x05bc
                    r2.emit()     // Catch:{ all -> 0x05da }
                    long r4 = r4 + r0
                    long r0 = r10 + r4
                    int r9 = (r7 > r19 ? 1 : (r7 == r19 ? 0 : -1))
                    r29 = 100
                    if (r9 <= 0) goto L_0x0557
                    long r0 = r0 * r29
                    long r0 = r0 / r7
                    int r0 = (int) r0
                    r1 = r31
                    r9 = r0
                    goto L_0x055b
                L_0x0546:
                    r0 = move-exception
                    r18 = r2
                    r11 = r21
                    r15 = r23
                    r8 = r25
                    r4 = 2
                    r5 = 3
                    r7 = 5
                    r9 = 0
                    r1 = r31
                    goto L_0x0a22
                L_0x0557:
                    r1 = r31
                    r9 = r27
                L_0x055b:
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4     // Catch:{ all -> 0x05de }
                    boolean r0 = r0.isConnected()     // Catch:{ all -> 0x05de }
                    if (r0 == 0) goto L_0x059b
                L_0x0563:
                    int r0 = r3.progressPercent     // Catch:{ all -> 0x05de }
                    r27 = r4
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x05de }
                    int r4 = r4.progressStep     // Catch:{ all -> 0x05de }
                    int r0 = r0 + r4
                    if (r0 > r9) goto L_0x0596
                    int r0 = r3.progressPercent     // Catch:{ all -> 0x05de }
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x05de }
                    int r4 = r4.progressStep     // Catch:{ all -> 0x05de }
                    int r0 = r0 + r4
                    long r4 = (long) r0     // Catch:{ all -> 0x05de }
                    int r0 = (r4 > r29 ? 1 : (r4 == r29 ? 0 : -1))
                    if (r0 > 0) goto L_0x0596
                    r4 = 1
                    r3.status = r4     // Catch:{ all -> 0x05de }
                    int r0 = r3.progressPercent     // Catch:{ all -> 0x05de }
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x05de }
                    int r4 = r4.progressStep     // Catch:{ all -> 0x05de }
                    int r0 = r0 + r4
                    r3.progressPercent = r0     // Catch:{ all -> 0x05de }
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x05de }
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r4     // Catch:{ all -> 0x05de }
                    r0.onProgressMediator(r4, r3)     // Catch:{ all -> 0x05de }
                    r4 = r27
                    goto L_0x0563
                L_0x0596:
                    r0 = r15
                    r4 = r27
                    goto L_0x0510
                L_0x059b:
                    java.lang.String r0 = "AssetDownloader#load; loadAd sequence"
                    java.lang.String r4 = "mediator %s is not connected"
                    r5 = 1
                    java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ all -> 0x05de }
                    com.vungle.warren.downloader.AssetDownloader r5 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x05de }
                    com.vungle.warren.downloader.DownloadRequestMediator r8 = r4     // Catch:{ all -> 0x05de }
                    java.lang.String r5 = r5.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r8)     // Catch:{ all -> 0x05de }
                    r8 = 0
                    r7[r8] = r5     // Catch:{ all -> 0x05de }
                    java.lang.String r4 = java.lang.String.format(r4, r7)     // Catch:{ all -> 0x05de }
                    com.vungle.warren.VungleLogger.error(r0, r4)     // Catch:{ all -> 0x05de }
                    java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x05de }
                    java.lang.String r4 = "Request is not connected"
                    r0.<init>(r4)     // Catch:{ all -> 0x05de }
                    throw r0     // Catch:{ all -> 0x05de }
                L_0x05bc:
                    r1 = r31
                    java.lang.String r0 = "AssetDownloader#load; loadAd sequence"
                    java.lang.String r4 = "file %s does not exist"
                    r5 = 1
                    java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ all -> 0x05de }
                    r5 = 0
                    r7[r5] = r12     // Catch:{ all -> 0x05de }
                    java.lang.String r4 = java.lang.String.format(r4, r7)     // Catch:{ all -> 0x05de }
                    com.vungle.warren.VungleLogger.error(r0, r4)     // Catch:{ all -> 0x05de }
                    com.vungle.warren.downloader.Downloader$RequestException r0 = new com.vungle.warren.downloader.Downloader$RequestException     // Catch:{ all -> 0x05de }
                    java.lang.String r4 = "File is not existing"
                    r0.<init>(r4)     // Catch:{ all -> 0x05de }
                    throw r0     // Catch:{ all -> 0x05de }
                L_0x05d7:
                    r1 = r31
                    goto L_0x05ed
                L_0x05da:
                    r0 = move-exception
                    r1 = r31
                    goto L_0x05df
                L_0x05de:
                    r0 = move-exception
                L_0x05df:
                    r18 = r2
                    r11 = r21
                    r15 = r23
                    r8 = r25
                    r4 = 2
                    r5 = 3
                    r7 = 5
                    goto L_0x0778
                L_0x05ec:
                    r15 = r0
                L_0x05ed:
                    r2.flush()     // Catch:{ all -> 0x076c }
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4     // Catch:{ all -> 0x076c }
                    r4 = 1
                    boolean r0 = r0.is(r4)     // Catch:{ all -> 0x076c }
                    if (r0 == 0) goto L_0x0659
                    long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x05de }
                    java.lang.String r0 = "DOWNLOAD_COMPLETE"
                    java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x05de }
                    java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x05de }
                    r8 = r15
                    r8.put(r0, r7)     // Catch:{ all -> 0x05de }
                    java.lang.String r0 = "Last-Cache-Verification"
                    java.lang.String r7 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x05de }
                    r8.put(r0, r7)     // Catch:{ all -> 0x05de }
                    java.lang.String r0 = "Last-Download"
                    java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x05de }
                    r8.put(r0, r4)     // Catch:{ all -> 0x05de }
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x05de }
                    r0.saveMeta(r13, r8)     // Catch:{ all -> 0x05de }
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4     // Catch:{ all -> 0x05de }
                    java.lang.String r0 = r0.key     // Catch:{ all -> 0x05de }
                    boolean r0 = com.vungle.warren.utility.FileUtility.isVideoFile(r0)     // Catch:{ all -> 0x05de }
                    if (r0 == 0) goto L_0x0652
                    com.vungle.warren.SessionTracker r0 = com.vungle.warren.SessionTracker.getInstance()     // Catch:{ all -> 0x05de }
                    com.vungle.warren.model.SessionData$Builder r4 = new com.vungle.warren.model.SessionData$Builder     // Catch:{ all -> 0x05de }
                    r4.<init>()     // Catch:{ all -> 0x05de }
                    com.vungle.warren.session.SessionEvent r5 = com.vungle.warren.session.SessionEvent.ADS_CACHED     // Catch:{ all -> 0x05de }
                    com.vungle.warren.model.SessionData$Builder r4 = r4.setEvent(r5)     // Catch:{ all -> 0x05de }
                    com.vungle.warren.session.SessionAttribute r5 = com.vungle.warren.session.SessionAttribute.URL     // Catch:{ all -> 0x05de }
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r4     // Catch:{ all -> 0x05de }
                    java.lang.String r7 = r7.key     // Catch:{ all -> 0x05de }
                    com.vungle.warren.model.SessionData$Builder r4 = r4.addData((com.vungle.warren.session.SessionAttribute) r5, (java.lang.String) r7)     // Catch:{ all -> 0x05de }
                    com.vungle.warren.session.SessionAttribute r5 = com.vungle.warren.session.SessionAttribute.VIDEO_CACHED     // Catch:{ all -> 0x05de }
                    java.lang.String r7 = "cdn"
                    com.vungle.warren.model.SessionData$Builder r4 = r4.addData((com.vungle.warren.session.SessionAttribute) r5, (java.lang.String) r7)     // Catch:{ all -> 0x05de }
                    com.vungle.warren.model.SessionData r4 = r4.build()     // Catch:{ all -> 0x05de }
                    r0.trackEvent(r4)     // Catch:{ all -> 0x05de }
                L_0x0652:
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4     // Catch:{ all -> 0x05de }
                    r4 = 4
                    r0.set(r4)     // Catch:{ all -> 0x05de }
                    goto L_0x0683
                L_0x0659:
                    r0 = 6
                    r3.status = r0     // Catch:{ all -> 0x076c }
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x076c }
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r4     // Catch:{ all -> 0x076c }
                    r0.onProgressMediator(r4, r3)     // Catch:{ all -> 0x076c }
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x076c }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x076c }
                    r4.<init>()     // Catch:{ all -> 0x076c }
                    java.lang.String r5 = "State has changed, cancelling download "
                    r4.append(r5)     // Catch:{ all -> 0x076c }
                    com.vungle.warren.downloader.AssetDownloader r5 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x076c }
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r4     // Catch:{ all -> 0x076c }
                    java.lang.String r5 = r5.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r7)     // Catch:{ all -> 0x076c }
                    r4.append(r5)     // Catch:{ all -> 0x076c }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x076c }
                    android.util.Log.d(r0, r4)     // Catch:{ all -> 0x076c }
                L_0x0683:
                    if (r6 == 0) goto L_0x0692
                    okhttp3.ResponseBody r0 = r6.body()
                    if (r0 == 0) goto L_0x0692
                    okhttp3.ResponseBody r0 = r6.body()
                    r0.close()
                L_0x0692:
                    if (r26 == 0) goto L_0x0697
                    r26.cancel()
                L_0x0697:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    java.lang.String r5 = "request is done "
                    r4.append(r5)
                    com.vungle.warren.downloader.AssetDownloader r5 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r6 = r4
                    java.lang.String r5 = r5.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r6)
                    r4.append(r5)
                    java.lang.String r4 = r4.toString()
                    android.util.Log.d(r0, r4)
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4
                    int r0 = r0.getStatus()
                    r4 = 2
                    if (r0 == r4) goto L_0x06d2
                    r5 = 3
                    if (r0 == r5) goto L_0x06e9
                    r4 = 4
                    if (r0 == r4) goto L_0x06df
                    r7 = 5
                    if (r0 == r7) goto L_0x06d5
                    if (r22 != 0) goto L_0x06d2
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r4
                    r0.removeMediator(r4)
                L_0x06d2:
                    r15 = r23
                    goto L_0x06f2
                L_0x06d5:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r4
                    r15 = r23
                    r0.onErrorMediator(r15, r4)
                    goto L_0x06f2
                L_0x06df:
                    r15 = r23
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r4
                    r0.onSuccessMediator(r12, r4)
                    goto L_0x06f2
                L_0x06e9:
                    r15 = r23
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r4
                    r0.onCancelledMediator(r4)
                L_0x06f2:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    java.lang.String r5 = "Done with request in state "
                    r4.append(r5)
                    com.vungle.warren.downloader.DownloadRequestMediator r5 = r4
                    int r5 = r5.getStatus()
                    r4.append(r5)
                    java.lang.String r5 = " "
                    r4.append(r5)
                    com.vungle.warren.downloader.AssetDownloader r5 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r6 = r4
                    java.lang.String r5 = r5.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r6)
                    r4.append(r5)
                    java.lang.String r4 = r4.toString()
                    android.util.Log.d(r0, r4)
                    com.vungle.warren.downloader.AssetDownloader r8 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r8)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0769 }
                    r0.removeNetworkListener()     // Catch:{ all -> 0x0769 }
                    monitor-exit(r8)     // Catch:{ all -> 0x0769 }
                    com.vungle.warren.utility.FileUtility.closeQuietly(r2)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r14)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    if (r0 == 0) goto L_0x0761
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4
                    boolean r0 = r0.isCacheable
                    if (r0 == 0) goto L_0x0761
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r0 = r0.isCacheEnabled()
                    if (r0 != 0) goto L_0x0758
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.clear()
                    goto L_0x0761
                L_0x0758:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.purge()
                L_0x0761:
                    r11 = r21
                    r14 = r22
                    r0 = 1
                    r9 = 0
                    goto L_0x0d5e
                L_0x0769:
                    r0 = move-exception
                    monitor-exit(r8)     // Catch:{ all -> 0x0769 }
                    throw r0
                L_0x076c:
                    r0 = move-exception
                    r15 = r23
                    r4 = 2
                    r5 = 3
                    r7 = 5
                    r18 = r2
                    r11 = r21
                    r8 = r25
                L_0x0778:
                    r9 = 0
                    goto L_0x0a22
                L_0x077b:
                    r0 = move-exception
                    goto L_0x078c
                L_0x077d:
                    r0 = move-exception
                    r26 = r2
                    goto L_0x078c
                L_0x0781:
                    r0 = move-exception
                    r26 = r2
                    goto L_0x078a
                L_0x0785:
                    r0 = move-exception
                    r26 = r2
                    r24 = r4
                L_0x078a:
                    r25 = r9
                L_0x078c:
                    r15 = r23
                    r4 = 2
                    r5 = 3
                    r7 = 5
                    r11 = r21
                    r8 = r25
                L_0x0795:
                    r9 = 0
                    goto L_0x081c
                L_0x0798:
                    r0 = move-exception
                    r26 = r2
                    r24 = r4
                    r25 = r9
                    r15 = r23
                    goto L_0x07d9
                L_0x07a2:
                    r26 = r2
                    r24 = r4
                    r25 = r9
                    r22 = r14
                    r4 = 2
                    r5 = 3
                    r7 = 5
                    java.lang.String r0 = "AssetDownloader#load; loadAd sequence"
                    java.lang.String r2 = "response has no body %s"
                    r8 = 1
                    java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x07c6 }
                    r8 = 0
                    r9[r8] = r6     // Catch:{ all -> 0x07c6 }
                    java.lang.String r2 = java.lang.String.format(r2, r9)     // Catch:{ all -> 0x07c6 }
                    com.vungle.warren.VungleLogger.error(r0, r2)     // Catch:{ all -> 0x07c6 }
                    java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x07c6 }
                    java.lang.String r2 = "Response body is null"
                    r0.<init>(r2)     // Catch:{ all -> 0x07c6 }
                    throw r0     // Catch:{ all -> 0x07c6 }
                L_0x07c6:
                    r0 = move-exception
                    goto L_0x07dc
                L_0x07c8:
                    r0 = move-exception
                    r26 = r2
                    r24 = r4
                    goto L_0x07d5
                L_0x07ce:
                    r0 = move-exception
                    r26 = r2
                    r24 = r4
                    r21 = r5
                L_0x07d5:
                    r25 = r9
                    r22 = r14
                L_0x07d9:
                    r4 = 2
                    r5 = 3
                    r7 = 5
                L_0x07dc:
                    r11 = r21
                    r8 = r25
                    goto L_0x081a
                L_0x07e1:
                    r26 = r2
                    r24 = r4
                    r21 = r5
                    r25 = r9
                    r22 = r14
                    r4 = 2
                    r5 = 3
                    r7 = 5
                    com.vungle.warren.downloader.Downloader$RequestException r0 = new com.vungle.warren.downloader.Downloader$RequestException     // Catch:{ all -> 0x0807 }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0807 }
                    r2.<init>()     // Catch:{ all -> 0x0807 }
                    java.lang.String r8 = "Code: "
                    r2.append(r8)     // Catch:{ all -> 0x0807 }
                    r8 = r25
                    r2.append(r8)     // Catch:{ all -> 0x084c }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x084c }
                    r0.<init>(r2)     // Catch:{ all -> 0x084c }
                    throw r0     // Catch:{ all -> 0x084c }
                L_0x0807:
                    r0 = move-exception
                    r8 = r25
                    goto L_0x0818
                L_0x080b:
                    r0 = move-exception
                    r26 = r2
                    r24 = r4
                    r21 = r5
                    r8 = r9
                    r22 = r14
                    r4 = 2
                    r5 = 3
                    r7 = 5
                L_0x0818:
                    r11 = r21
                L_0x081a:
                    r9 = 0
                    r14 = 0
                L_0x081c:
                    r18 = 0
                    goto L_0x0a22
                L_0x0820:
                    r26 = r2
                    r24 = r4
                    r21 = r5
                    r8 = r9
                    r22 = r14
                    r4 = 2
                    r5 = 3
                    r7 = 5
                    r2 = 304(0x130, float:4.26E-43)
                    if (r8 != r2) goto L_0x084e
                    java.lang.String r2 = "Last-Cache-Verification"
                    long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x084c }
                    java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x084c }
                    r0.put(r2, r9)     // Catch:{ all -> 0x084c }
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x084c }
                    r2.saveMeta(r13, r0)     // Catch:{ all -> 0x084c }
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x084c }
                    java.lang.String r2 = "Verification success, dispatch existing file"
                    android.util.Log.d(r0, r2)     // Catch:{ all -> 0x084c }
                    goto L_0x086a
                L_0x084c:
                    r0 = move-exception
                    goto L_0x0818
                L_0x084e:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0948 }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0948 }
                    r2.<init>()     // Catch:{ all -> 0x0948 }
                    java.lang.String r9 = "Using local cache file despite response code = "
                    r2.append(r9)     // Catch:{ all -> 0x0948 }
                    int r9 = r6.code()     // Catch:{ all -> 0x0948 }
                    r2.append(r9)     // Catch:{ all -> 0x0948 }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0948 }
                    android.util.Log.d(r0, r2)     // Catch:{ all -> 0x0948 }
                L_0x086a:
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4     // Catch:{ all -> 0x0948 }
                    r2 = 4
                    r0.set(r2)     // Catch:{ all -> 0x0948 }
                    if (r6 == 0) goto L_0x087f
                    okhttp3.ResponseBody r0 = r6.body()
                    if (r0 == 0) goto L_0x087f
                    okhttp3.ResponseBody r0 = r6.body()
                    r0.close()
                L_0x087f:
                    if (r26 == 0) goto L_0x0884
                    r26.cancel()
                L_0x0884:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "request is done "
                    r2.append(r3)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r6 = r4
                    java.lang.String r3 = r3.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r6)
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4
                    int r0 = r0.getStatus()
                    if (r0 == r4) goto L_0x08d4
                    if (r0 == r5) goto L_0x08cd
                    r2 = 4
                    if (r0 == r2) goto L_0x08c5
                    if (r0 == r7) goto L_0x08bd
                    if (r22 != 0) goto L_0x08d4
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r4
                    r0.removeMediator(r2)
                    goto L_0x08d4
                L_0x08bd:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r4
                    r0.onErrorMediator(r15, r2)
                    goto L_0x08d4
                L_0x08c5:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r4
                    r0.onSuccessMediator(r12, r2)
                    goto L_0x08d4
                L_0x08cd:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r4
                    r0.onCancelledMediator(r2)
                L_0x08d4:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "Done with request in state "
                    r2.append(r3)
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r4
                    int r3 = r3.getStatus()
                    r2.append(r3)
                    java.lang.String r3 = " "
                    r2.append(r3)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r4
                    java.lang.String r3 = r3.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r4)
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r2)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0945 }
                    r0.removeNetworkListener()     // Catch:{ all -> 0x0945 }
                    monitor-exit(r2)     // Catch:{ all -> 0x0945 }
                    r9 = 0
                    com.vungle.warren.utility.FileUtility.closeQuietly(r9)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r9)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    if (r0 == 0) goto L_0x0944
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4
                    boolean r0 = r0.isCacheable
                    if (r0 == 0) goto L_0x0944
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r0 = r0.isCacheEnabled()
                    if (r0 != 0) goto L_0x093b
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.clear()
                    goto L_0x0944
                L_0x093b:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.purge()
                L_0x0944:
                    return
                L_0x0945:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x0945 }
                    throw r0
                L_0x0948:
                    r0 = move-exception
                    goto L_0x0957
                L_0x094a:
                    r0 = move-exception
                    r26 = r2
                    r24 = r4
                    r21 = r5
                    r8 = r9
                    r22 = r14
                    r4 = 2
                    r5 = 3
                    r7 = 5
                L_0x0957:
                    r9 = 0
                    r14 = r9
                    r18 = r14
                    r11 = r21
                    goto L_0x0a22
                L_0x095f:
                    r0 = move-exception
                    r26 = r2
                    r24 = r4
                    r21 = r5
                    r22 = r14
                    r4 = 2
                    r5 = 3
                    r7 = 5
                    r9 = 0
                    r14 = r9
                    goto L_0x097d
                L_0x096e:
                    r0 = move-exception
                    r26 = r2
                    r24 = r4
                    r21 = r5
                    r22 = r14
                    r4 = 2
                    r5 = 3
                    r7 = 5
                    r9 = 0
                    r6 = r9
                    r14 = r6
                L_0x097d:
                    r18 = r14
                    goto L_0x0a01
                L_0x0981:
                    r0 = move-exception
                    r24 = r4
                    r21 = r5
                    r22 = r14
                    r4 = 2
                    r5 = 3
                    r7 = 5
                    r9 = 0
                    goto L_0x09fb
                L_0x098e:
                    r0 = move-exception
                    r24 = r4
                    r21 = r11
                    r22 = r14
                    r4 = 2
                    goto L_0x09b9
                L_0x0997:
                    r0 = move-exception
                    r24 = r4
                    r4 = r7
                    r21 = r11
                    r22 = r14
                    r9 = 0
                    r7 = r5
                    r5 = 3
                    goto L_0x0a1b
                L_0x09a4:
                    r0 = move-exception
                    r24 = r4
                    r4 = r7
                    r21 = r11
                    r22 = r14
                    r9 = 0
                    r7 = r5
                    r5 = r2
                    goto L_0x0a1b
                L_0x09b1:
                    r0 = move-exception
                    r24 = r4
                    r4 = r7
                    r21 = r11
                    r22 = r14
                L_0x09b9:
                    r5 = 3
                    goto L_0x09c4
                L_0x09bb:
                    r0 = move-exception
                    r24 = r4
                    r4 = r7
                    r5 = r8
                    r21 = r11
                    r22 = r14
                L_0x09c4:
                    r7 = 5
                    goto L_0x0a0e
                L_0x09c6:
                    r24 = r4
                    r4 = r7
                    r5 = r8
                    r7 = r9
                    r21 = r11
                    r22 = r14
                    r9 = 0
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x09fa }
                    java.lang.String r2 = "Request is not connected to required network"
                    android.util.Log.d(r0, r2)     // Catch:{ all -> 0x09fa }
                    java.lang.String r0 = "AssetDownloader#load; loadAd sequence"
                    java.lang.String r2 = "No connected to required network requests in %s"
                    r6 = 1
                    java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch:{ all -> 0x09fa }
                    com.vungle.warren.downloader.AssetDownloader r6 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x09fa }
                    com.vungle.warren.downloader.DownloadRequestMediator r10 = r4     // Catch:{ all -> 0x09fa }
                    java.lang.String r6 = r6.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r10)     // Catch:{ all -> 0x09fa }
                    r10 = 0
                    r8[r10] = r6     // Catch:{ all -> 0x09fa }
                    java.lang.String r2 = java.lang.String.format(r2, r8)     // Catch:{ all -> 0x09fa }
                    com.vungle.warren.VungleLogger.warn(r0, r2)     // Catch:{ all -> 0x09fa }
                    java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x09fa }
                    java.lang.String r2 = "Not connected to correct network"
                    r0.<init>(r2)     // Catch:{ all -> 0x09fa }
                    throw r0     // Catch:{ all -> 0x09fa }
                L_0x09fa:
                    r0 = move-exception
                L_0x09fb:
                    r6 = r9
                    r14 = r6
                    r18 = r14
                    r26 = r18
                L_0x0a01:
                    r11 = r21
                    goto L_0x0a21
                L_0x0a04:
                    r0 = move-exception
                    r24 = r4
                    r4 = r7
                    r5 = r8
                    r7 = r9
                    r21 = r11
                    r22 = r14
                L_0x0a0e:
                    r9 = 0
                    goto L_0x0a1b
                L_0x0a10:
                    r0 = move-exception
                    r24 = r4
                    r4 = r7
                    r5 = r8
                    r7 = r9
                    r21 = r11
                    r22 = r14
                    r9 = r2
                L_0x0a1b:
                    r6 = r9
                    r14 = r6
                    r18 = r14
                    r26 = r18
                L_0x0a21:
                    r8 = -1
                L_0x0a22:
                    java.lang.String r2 = "AssetDownloader#load; loadAd sequence"
                    java.lang.String r10 = "exception, cannot load due to %1$s, state is %2$s"
                    java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ all -> 0x0d6b }
                    r16 = 0
                    r9[r16] = r0     // Catch:{ all -> 0x0d6b }
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0d6b }
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r4     // Catch:{ all -> 0x0d6b }
                    java.lang.String r4 = r4.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r7)     // Catch:{ all -> 0x0d6b }
                    r7 = 1
                    r9[r7] = r4     // Catch:{ all -> 0x0d68 }
                    java.lang.String r4 = java.lang.String.format(r10, r9)     // Catch:{ all -> 0x0d6b }
                    com.vungle.warren.VungleLogger.error(r2, r4)     // Catch:{ all -> 0x0d6b }
                    java.lang.String r2 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0d6b }
                    java.lang.String r4 = "Exception on download"
                    android.util.Log.e(r2, r4, r0)     // Catch:{ all -> 0x0d6b }
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r4     // Catch:{ all -> 0x0d6b }
                    boolean r2 = r2.is(r5)     // Catch:{ all -> 0x0d6b }
                    if (r2 != 0) goto L_0x0a5b
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r4     // Catch:{ all -> 0x0a56 }
                    r4 = 5
                    r2.set(r4)     // Catch:{ all -> 0x0a56 }
                    goto L_0x0a5b
                L_0x0a56:
                    r0 = move-exception
                L_0x0a57:
                    r17 = 1
                    goto L_0x0d6f
                L_0x0a5b:
                    boolean r2 = r0 instanceof java.io.IOException     // Catch:{ all -> 0x0d6b }
                    if (r2 == 0) goto L_0x0c3e
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0a56 }
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r4     // Catch:{ all -> 0x0a56 }
                    boolean r2 = r2.isAnyConnected(r4)     // Catch:{ all -> 0x0a56 }
                    if (r2 != 0) goto L_0x0b63
                    if (r6 != 0) goto L_0x0b63
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0a56 }
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r4     // Catch:{ all -> 0x0a56 }
                    com.vungle.warren.downloader.AssetDownloader r9 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0a56 }
                    java.util.HashMap r9 = r9.extractMeta(r13)     // Catch:{ all -> 0x0a56 }
                    r10 = -1
                    boolean r4 = r4.useCacheOnFail(r7, r12, r9, r10)     // Catch:{ all -> 0x0a56 }
                    if (r4 == 0) goto L_0x0b63
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4     // Catch:{ all -> 0x0a56 }
                    boolean r0 = r0.is(r5)     // Catch:{ all -> 0x0a56 }
                    if (r0 != 0) goto L_0x0a8a
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4     // Catch:{ all -> 0x0a56 }
                    r2 = 4
                    r0.set(r2)     // Catch:{ all -> 0x0a56 }
                L_0x0a8a:
                    if (r6 == 0) goto L_0x0a99
                    okhttp3.ResponseBody r0 = r6.body()
                    if (r0 == 0) goto L_0x0a99
                    okhttp3.ResponseBody r0 = r6.body()
                    r0.close()
                L_0x0a99:
                    if (r26 == 0) goto L_0x0a9e
                    r26.cancel()
                L_0x0a9e:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "request is done "
                    r2.append(r3)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r4
                    java.lang.String r3 = r3.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r4)
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4
                    int r0 = r0.getStatus()
                    r2 = 2
                    if (r0 == r2) goto L_0x0af0
                    if (r0 == r5) goto L_0x0ae9
                    r2 = 4
                    if (r0 == r2) goto L_0x0ae1
                    r2 = 5
                    if (r0 == r2) goto L_0x0ad9
                    if (r22 != 0) goto L_0x0af0
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r4
                    r0.removeMediator(r2)
                    goto L_0x0af0
                L_0x0ad9:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r4
                    r0.onErrorMediator(r15, r2)
                    goto L_0x0af0
                L_0x0ae1:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r4
                    r0.onSuccessMediator(r12, r2)
                    goto L_0x0af0
                L_0x0ae9:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r4
                    r0.onCancelledMediator(r2)
                L_0x0af0:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "Done with request in state "
                    r2.append(r3)
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r4
                    int r3 = r3.getStatus()
                    r2.append(r3)
                    java.lang.String r3 = " "
                    r2.append(r3)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r4
                    java.lang.String r3 = r3.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r4)
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.d(r0, r2)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r2)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0b60 }
                    r0.removeNetworkListener()     // Catch:{ all -> 0x0b60 }
                    monitor-exit(r2)     // Catch:{ all -> 0x0b60 }
                    com.vungle.warren.utility.FileUtility.closeQuietly(r18)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r14)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    if (r0 == 0) goto L_0x0b5f
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4
                    boolean r0 = r0.isCacheable
                    if (r0 == 0) goto L_0x0b5f
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r0 = r0.isCacheEnabled()
                    if (r0 != 0) goto L_0x0b56
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.clear()
                    goto L_0x0b5f
                L_0x0b56:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.purge()
                L_0x0b5f:
                    return
                L_0x0b60:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x0b60 }
                    throw r0
                L_0x0b63:
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r4     // Catch:{ all -> 0x0a56 }
                    r4.setConnected(r2)     // Catch:{ all -> 0x0a56 }
                    com.vungle.warren.downloader.AssetDownloadListener$DownloadError r4 = new com.vungle.warren.downloader.AssetDownloadListener$DownloadError     // Catch:{ all -> 0x0a56 }
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0a56 }
                    int r7 = r7.mapExceptionToReason(r0, r2)     // Catch:{ all -> 0x0a56 }
                    r4.<init>(r8, r0, r7)     // Catch:{ all -> 0x0a56 }
                    if (r2 != 0) goto L_0x0beb
                    r2 = 5
                    r3.status = r2     // Catch:{ all -> 0x0be7 }
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0be7 }
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r4     // Catch:{ all -> 0x0be7 }
                    r0.onProgressMediator(r2, r3)     // Catch:{ all -> 0x0be7 }
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4     // Catch:{ all -> 0x0be7 }
                    boolean r0 = r0.is(r5)     // Catch:{ all -> 0x0be7 }
                    if (r0 != 0) goto L_0x0beb
                    int r0 = r11 + 1
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0be7 }
                    int r2 = r2.maxReconnectAttempts     // Catch:{ all -> 0x0be7 }
                    if (r11 >= r2) goto L_0x0be4
                    r2 = 0
                L_0x0b90:
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0be7 }
                    int r7 = r7.retryCountOnConnectionLost     // Catch:{ all -> 0x0be7 }
                    if (r2 >= r7) goto L_0x0be4
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0be7 }
                    com.vungle.warren.downloader.AssetDownloader r8 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0be7 }
                    int r8 = r8.reconnectTimeout     // Catch:{ all -> 0x0be7 }
                    long r8 = (long) r8     // Catch:{ all -> 0x0be7 }
                    r7.sleep(r8)     // Catch:{ all -> 0x0be7 }
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r4     // Catch:{ all -> 0x0be7 }
                    boolean r7 = r7.is(r5)     // Catch:{ all -> 0x0be7 }
                    if (r7 == 0) goto L_0x0ba9
                    goto L_0x0be4
                L_0x0ba9:
                    java.lang.String r7 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0be7 }
                    java.lang.String r8 = "Trying to reconnect"
                    android.util.Log.d(r7, r8)     // Catch:{ all -> 0x0be7 }
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0be7 }
                    com.vungle.warren.downloader.DownloadRequestMediator r8 = r4     // Catch:{ all -> 0x0be7 }
                    boolean r7 = r7.isAnyConnected(r8)     // Catch:{ all -> 0x0be7 }
                    if (r7 == 0) goto L_0x0bdb
                    java.lang.String r2 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0be7 }
                    java.lang.String r7 = "Reconnected, starting download again"
                    android.util.Log.d(r2, r7)     // Catch:{ all -> 0x0be7 }
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r4     // Catch:{ all -> 0x0bd5 }
                    r7 = 1
                    r2.setConnected(r7)     // Catch:{ all -> 0x0bd5 }
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r4     // Catch:{ all -> 0x0bd5 }
                    r2.set(r7)     // Catch:{ all -> 0x0bd5 }
                    r11 = r0
                    r9 = 0
                    r16 = 0
                    goto L_0x0bee
                L_0x0bd5:
                    r0 = move-exception
                    r15 = r4
                    r17 = 0
                    goto L_0x0d6f
                L_0x0bdb:
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r4     // Catch:{ all -> 0x0be7 }
                    r9 = 0
                    r7.setConnected(r9)     // Catch:{ all -> 0x0be7 }
                    int r2 = r2 + 1
                    goto L_0x0b90
                L_0x0be4:
                    r9 = 0
                    r11 = r0
                    goto L_0x0bec
                L_0x0be7:
                    r0 = move-exception
                    r15 = r4
                    goto L_0x0a57
                L_0x0beb:
                    r9 = 0
                L_0x0bec:
                    r16 = 1
                L_0x0bee:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0c38 }
                    monitor-enter(r2)     // Catch:{ all -> 0x0c38 }
                    if (r16 == 0) goto L_0x0c32
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4     // Catch:{ all -> 0x0c35 }
                    boolean r0 = r0.isConnected()     // Catch:{ all -> 0x0c35 }
                    if (r0 != 0) goto L_0x0c32
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4     // Catch:{ all -> 0x0c35 }
                    boolean r0 = r0.isPausable()     // Catch:{ all -> 0x0c35 }
                    if (r0 == 0) goto L_0x0c32
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0c35 }
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r4     // Catch:{ all -> 0x0c35 }
                    boolean r0 = r0.isAnyConnected(r7)     // Catch:{ all -> 0x0c35 }
                    if (r0 == 0) goto L_0x0c28
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG     // Catch:{ all -> 0x0c35 }
                    java.lang.String r7 = "Reconnected, starting download again"
                    android.util.Log.d(r0, r7)     // Catch:{ all -> 0x0c35 }
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4     // Catch:{ all -> 0x0c24 }
                    r7 = 1
                    r0.setConnected(r7)     // Catch:{ all -> 0x0c24 }
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4     // Catch:{ all -> 0x0c24 }
                    r0.set(r7)     // Catch:{ all -> 0x0c24 }
                    r16 = r9
                    goto L_0x0c32
                L_0x0c24:
                    r0 = move-exception
                    r16 = r9
                    goto L_0x0c36
                L_0x0c28:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0c35 }
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r4     // Catch:{ all -> 0x0c35 }
                    boolean r0 = r0.pause(r7, r3, r4)     // Catch:{ all -> 0x0c35 }
                    r22 = r0
                L_0x0c32:
                    monitor-exit(r2)     // Catch:{ all -> 0x0c35 }
                    r2 = r4
                    goto L_0x0c5f
                L_0x0c35:
                    r0 = move-exception
                L_0x0c36:
                    monitor-exit(r2)     // Catch:{ all -> 0x0c35 }
                    throw r0     // Catch:{ all -> 0x0c38 }
                L_0x0c38:
                    r0 = move-exception
                    r15 = r4
                    r17 = r16
                    goto L_0x0d6f
                L_0x0c3e:
                    r9 = 0
                    boolean r2 = r0 instanceof com.vungle.warren.downloader.Downloader.RequestException     // Catch:{ all -> 0x0d6b }
                    if (r2 == 0) goto L_0x0c51
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0a56 }
                    r4 = 1
                    r2.deleteFileAndMeta(r12, r13, r4)     // Catch:{ all -> 0x0a56 }
                    com.vungle.warren.downloader.AssetDownloadListener$DownloadError r2 = new com.vungle.warren.downloader.AssetDownloadListener$DownloadError     // Catch:{ all -> 0x0a56 }
                    r2.<init>(r8, r0, r4)     // Catch:{ all -> 0x0a56 }
                    r16 = 1
                    goto L_0x0c5f
                L_0x0c51:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0d6b }
                    r4 = 1
                    r2.deleteFileAndMeta(r12, r13, r4)     // Catch:{ all -> 0x0d66 }
                    com.vungle.warren.downloader.AssetDownloadListener$DownloadError r2 = new com.vungle.warren.downloader.AssetDownloadListener$DownloadError     // Catch:{ all -> 0x0d66 }
                    r7 = 4
                    r2.<init>(r8, r0, r7)     // Catch:{ all -> 0x0d66 }
                    r16 = r4
                L_0x0c5f:
                    if (r6 == 0) goto L_0x0c6e
                    okhttp3.ResponseBody r0 = r6.body()
                    if (r0 == 0) goto L_0x0c6e
                    okhttp3.ResponseBody r0 = r6.body()
                    r0.close()
                L_0x0c6e:
                    if (r26 == 0) goto L_0x0c73
                    r26.cancel()
                L_0x0c73:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    java.lang.String r6 = "request is done "
                    r4.append(r6)
                    com.vungle.warren.downloader.AssetDownloader r6 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r7 = r4
                    java.lang.String r6 = r6.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r7)
                    r4.append(r6)
                    java.lang.String r4 = r4.toString()
                    android.util.Log.d(r0, r4)
                    if (r16 == 0) goto L_0x0cf6
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4
                    int r0 = r0.getStatus()
                    r4 = 2
                    if (r0 == r4) goto L_0x0cc7
                    if (r0 == r5) goto L_0x0cc0
                    r4 = 4
                    if (r0 == r4) goto L_0x0cb8
                    r4 = 5
                    if (r0 == r4) goto L_0x0cb0
                    if (r22 != 0) goto L_0x0cc7
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r4
                    r0.removeMediator(r4)
                    goto L_0x0cc7
                L_0x0cb0:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r4
                    r0.onErrorMediator(r2, r4)
                    goto L_0x0cc7
                L_0x0cb8:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r4
                    r0.onSuccessMediator(r12, r4)
                    goto L_0x0cc7
                L_0x0cc0:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r4
                    r0.onCancelledMediator(r4)
                L_0x0cc7:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    java.lang.String r5 = "Done with request in state "
                    r4.append(r5)
                    com.vungle.warren.downloader.DownloadRequestMediator r5 = r4
                    int r5 = r5.getStatus()
                    r4.append(r5)
                    java.lang.String r5 = " "
                    r4.append(r5)
                    com.vungle.warren.downloader.AssetDownloader r5 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r6 = r4
                    java.lang.String r5 = r5.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r6)
                    r4.append(r5)
                    java.lang.String r4 = r4.toString()
                    android.util.Log.d(r0, r4)
                    goto L_0x0d16
                L_0x0cf6:
                    java.lang.String r0 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    java.lang.String r5 = "Not removing connections and listener "
                    r4.append(r5)
                    com.vungle.warren.downloader.AssetDownloader r5 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r6 = r4
                    java.lang.String r5 = r5.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r6)
                    r4.append(r5)
                    java.lang.String r4 = r4.toString()
                    android.util.Log.d(r0, r4)
                L_0x0d16:
                    com.vungle.warren.downloader.AssetDownloader r7 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r7)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0d63 }
                    r0.removeNetworkListener()     // Catch:{ all -> 0x0d63 }
                    monitor-exit(r7)     // Catch:{ all -> 0x0d63 }
                    com.vungle.warren.utility.FileUtility.closeQuietly(r18)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r14)
                    if (r16 == 0) goto L_0x0d59
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    if (r0 == 0) goto L_0x0d59
                    com.vungle.warren.downloader.DownloadRequestMediator r0 = r4
                    boolean r0 = r0.isCacheable
                    if (r0 == 0) goto L_0x0d59
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r0 = r0.isCacheEnabled()
                    if (r0 != 0) goto L_0x0d50
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.clear()
                    goto L_0x0d59
                L_0x0d50:
                    com.vungle.warren.downloader.AssetDownloader r0 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r0 = r0.cache
                    r0.purge()
                L_0x0d59:
                    r15 = r2
                    r0 = r16
                    r14 = r22
                L_0x0d5e:
                    r4 = r24
                L_0x0d60:
                    r2 = 0
                    goto L_0x0044
                L_0x0d63:
                    r0 = move-exception
                    monitor-exit(r7)     // Catch:{ all -> 0x0d63 }
                    throw r0
                L_0x0d66:
                    r0 = move-exception
                    goto L_0x0d6d
                L_0x0d68:
                    r0 = move-exception
                    r4 = r7
                    goto L_0x0d6d
                L_0x0d6b:
                    r0 = move-exception
                    r4 = 1
                L_0x0d6d:
                    r17 = r4
                L_0x0d6f:
                    if (r6 == 0) goto L_0x0d7e
                    okhttp3.ResponseBody r2 = r6.body()
                    if (r2 == 0) goto L_0x0d7e
                    okhttp3.ResponseBody r2 = r6.body()
                    r2.close()
                L_0x0d7e:
                    if (r26 == 0) goto L_0x0d83
                    r26.cancel()
                L_0x0d83:
                    java.lang.String r2 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = "request is done "
                    r3.append(r4)
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r6 = r4
                    java.lang.String r4 = r4.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r6)
                    r3.append(r4)
                    java.lang.String r3 = r3.toString()
                    android.util.Log.d(r2, r3)
                    if (r17 == 0) goto L_0x0e06
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r4
                    int r2 = r2.getStatus()
                    r3 = 2
                    if (r2 == r3) goto L_0x0dd7
                    if (r2 == r5) goto L_0x0dd0
                    r3 = 4
                    if (r2 == r3) goto L_0x0dc8
                    r3 = 5
                    if (r2 == r3) goto L_0x0dc0
                    if (r22 != 0) goto L_0x0dd7
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r4
                    r2.removeMediator(r3)
                    goto L_0x0dd7
                L_0x0dc0:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r4
                    r2.onErrorMediator(r15, r3)
                    goto L_0x0dd7
                L_0x0dc8:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r4
                    r2.onSuccessMediator(r12, r3)
                    goto L_0x0dd7
                L_0x0dd0:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r3 = r4
                    r2.onCancelledMediator(r3)
                L_0x0dd7:
                    java.lang.String r2 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = "Done with request in state "
                    r3.append(r4)
                    com.vungle.warren.downloader.DownloadRequestMediator r4 = r4
                    int r4 = r4.getStatus()
                    r3.append(r4)
                    java.lang.String r4 = " "
                    r3.append(r4)
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r5 = r4
                    java.lang.String r4 = r4.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r5)
                    r3.append(r4)
                    java.lang.String r3 = r3.toString()
                    android.util.Log.d(r2, r3)
                    goto L_0x0e26
                L_0x0e06:
                    java.lang.String r2 = com.vungle.warren.downloader.AssetDownloader.TAG
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = "Not removing connections and listener "
                    r3.append(r4)
                    com.vungle.warren.downloader.AssetDownloader r4 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloadRequestMediator r5 = r4
                    java.lang.String r4 = r4.debugString((com.vungle.warren.downloader.DownloadRequestMediator) r5)
                    r3.append(r4)
                    java.lang.String r3 = r3.toString()
                    android.util.Log.d(r2, r3)
                L_0x0e26:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    monitor-enter(r2)
                    com.vungle.warren.downloader.AssetDownloader r3 = com.vungle.warren.downloader.AssetDownloader.this     // Catch:{ all -> 0x0e6a }
                    r3.removeNetworkListener()     // Catch:{ all -> 0x0e6a }
                    monitor-exit(r2)     // Catch:{ all -> 0x0e6a }
                    com.vungle.warren.utility.FileUtility.closeQuietly(r18)
                    com.vungle.warren.utility.FileUtility.closeQuietly(r14)
                    if (r17 == 0) goto L_0x0e69
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    if (r2 == 0) goto L_0x0e69
                    com.vungle.warren.downloader.DownloadRequestMediator r2 = r4
                    boolean r2 = r2.isCacheable
                    if (r2 == 0) goto L_0x0e69
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    r2.stopTracking(r12)
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    boolean r2 = r2.isCacheEnabled()
                    if (r2 != 0) goto L_0x0e60
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    r2.clear()
                    goto L_0x0e69
                L_0x0e60:
                    com.vungle.warren.downloader.AssetDownloader r2 = com.vungle.warren.downloader.AssetDownloader.this
                    com.vungle.warren.downloader.DownloaderCache r2 = r2.cache
                    r2.purge()
                L_0x0e69:
                    throw r0
                L_0x0e6a:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x0e6a }
                    throw r0
                L_0x0e6d:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.downloader.AssetDownloader.AnonymousClass3.run():void");
            }
        }, new Runnable() {
            public void run() {
                AssetDownloader.this.onErrorMediator(new AssetDownloadListener.DownloadError(-1, new VungleException(39), 1), downloadRequestMediator);
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean useCacheOnFail(DownloadRequestMediator downloadRequestMediator, File file, Map<String, String> map, int i) {
        return this.cache != null && downloadRequestMediator.isCacheable && i != 200 && i != RANGE_NOT_SATISFIABLE && i != 206 && Boolean.parseBoolean(map.get(DOWNLOAD_COMPLETE)) && file.exists() && file.length() > 0;
    }

    /* access modifiers changed from: private */
    public synchronized void removeMediator(DownloadRequestMediator downloadRequestMediator) {
        this.mediators.remove(downloadRequestMediator.key);
    }

    private void addNetworkListener() {
        Log.d(TAG, "Adding network listner");
        this.networkProvider.addListener(this.networkListener);
    }

    /* access modifiers changed from: private */
    public boolean pause(DownloadRequestMediator downloadRequestMediator, AssetDownloadListener.Progress progress, AssetDownloadListener.DownloadError downloadError) {
        boolean z = false;
        if (downloadRequestMediator.is(3) || isAnyConnected(downloadRequestMediator)) {
            return false;
        }
        progress.status = 2;
        AssetDownloadListener.Progress copy = AssetDownloadListener.Progress.copy(progress);
        boolean z2 = false;
        for (Pair next : downloadRequestMediator.values()) {
            DownloadRequest downloadRequest = (DownloadRequest) next.first;
            if (downloadRequest != null) {
                if (!downloadRequest.pauseOnConnectionLost) {
                    downloadRequestMediator.remove(downloadRequest);
                    deliverError(downloadRequest, (AssetDownloadListener) next.second, downloadError);
                } else {
                    downloadRequestMediator.set(2);
                    Log.d(TAG, "Pausing download " + debugString(downloadRequest));
                    deliverProgress(copy, (DownloadRequest) next.first, (AssetDownloadListener) next.second);
                    z2 = true;
                }
            }
        }
        if (!z2) {
            downloadRequestMediator.set(5);
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Attempted to pause - ");
        if (downloadRequestMediator.getStatus() == 2) {
            z = true;
        }
        sb.append(z);
        Log.d(str, sb.toString());
        return z2;
    }

    /* access modifiers changed from: private */
    public void sleep(long j) {
        try {
            Thread.sleep(Math.max(0, j));
        } catch (InterruptedException e) {
            Log.e(TAG, "InterruptedException ", e);
            Thread.currentThread().interrupt();
        }
    }

    /* access modifiers changed from: private */
    public HashMap<String, String> makeMeta(File file, Headers headers, String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(DOWNLOAD_URL, str);
        hashMap.put("ETag", headers.get("ETag"));
        hashMap.put("Last-Modified", headers.get("Last-Modified"));
        hashMap.put(ACCEPT_RANGES, headers.get(ACCEPT_RANGES));
        hashMap.put("Content-Encoding", headers.get("Content-Encoding"));
        saveMeta(file, hashMap);
        return hashMap;
    }

    /* access modifiers changed from: private */
    public void checkEncoding(File file, File file2, Headers headers) throws IOException {
        String str = headers.get("Content-Encoding");
        if (str != null && !GZIP.equalsIgnoreCase(str) && !IDENTITY.equalsIgnoreCase(str)) {
            deleteFileAndMeta(file, file2, false);
            VungleLogger.error("AssetDownloader#checkEncoding; loadAd sequence", String.format("unknown %1$s %2$s ", new Object[]{"Content-Encoding", str}));
            throw new IOException("Unknown Content-Encoding");
        }
    }

    /* access modifiers changed from: private */
    public boolean useCacheWithoutVerification(DownloadRequestMediator downloadRequestMediator, File file, Map<String, String> map) {
        String str;
        if (map == null || this.cache == null || !downloadRequestMediator.isCacheable || (str = map.get(LAST_CACHE_VERIFICATION)) == null || !file.exists() || !Boolean.parseBoolean(map.get(DOWNLOAD_COMPLETE))) {
            return false;
        }
        try {
            long parseLong = Long.parseLong(str);
            long j = this.timeWindow;
            if (j >= Long.MAX_VALUE - parseLong || parseLong + j >= System.currentTimeMillis()) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean partialMalformed(long j, int i, Response response, DownloadRequestMediator downloadRequestMediator) {
        return (i == 206 && !satisfiesPartialDownload(response, j, downloadRequestMediator)) || i == RANGE_NOT_SATISFIABLE;
    }

    /* access modifiers changed from: private */
    public void appendHeaders(long j, File file, HashMap<String, String> hashMap, Request.Builder builder) {
        builder.addHeader(ACCEPT_ENCODING, IDENTITY);
        if (file.exists() && !hashMap.isEmpty()) {
            String str = hashMap.get("ETag");
            String str2 = hashMap.get("Last-Modified");
            if (Boolean.parseBoolean(hashMap.get(DOWNLOAD_COMPLETE))) {
                if (!TextUtils.isEmpty(str)) {
                    builder.addHeader("If-None-Match", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    builder.addHeader("If-Modified-Since", str2);
                }
            } else if (BYTES.equalsIgnoreCase(hashMap.get(ACCEPT_RANGES))) {
                if (hashMap.get("Content-Encoding") == null || IDENTITY.equalsIgnoreCase(hashMap.get("Content-Encoding"))) {
                    builder.addHeader("Range", "bytes=" + j + "-");
                    if (!TextUtils.isEmpty(str)) {
                        builder.addHeader(IF_RANGE, str);
                    } else if (!TextUtils.isEmpty(str2)) {
                        builder.addHeader(IF_RANGE, str2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public ResponseBody decodeGzipIfNeeded(Response response) {
        if (!GZIP.equalsIgnoreCase(response.header("Content-Encoding")) || !HttpHeaders.hasBody(response) || response.body() == null) {
            return response.body();
        }
        return new RealResponseBody(response.header("Content-Type"), -1, Okio.buffer((Source) new GzipSource(response.body().source())));
    }

    /* access modifiers changed from: private */
    public synchronized void onCancelledMediator(DownloadRequestMediator downloadRequestMediator) {
        for (DownloadRequest onCancelled : downloadRequestMediator.requests()) {
            onCancelled(onCancelled);
        }
    }

    private void onCancelled(DownloadRequest downloadRequest) {
        DownloadRequest downloadRequest2;
        if (!downloadRequest.isCancelled()) {
            downloadRequest.cancel();
            DownloadRequestMediator findMediatorForCancellation = findMediatorForCancellation(downloadRequest);
            if (!(findMediatorForCancellation == null || findMediatorForCancellation.getStatus() == 3)) {
                Pair<DownloadRequest, AssetDownloadListener> remove = findMediatorForCancellation.remove(downloadRequest);
                AssetDownloadListener assetDownloadListener = null;
                if (remove == null) {
                    downloadRequest2 = null;
                } else {
                    downloadRequest2 = (DownloadRequest) remove.first;
                }
                if (remove != null) {
                    assetDownloadListener = (AssetDownloadListener) remove.second;
                }
                if (findMediatorForCancellation.values().isEmpty()) {
                    findMediatorForCancellation.set(3);
                }
                if (downloadRequest2 != null) {
                    AssetDownloadListener.Progress progress = new AssetDownloadListener.Progress();
                    progress.status = 3;
                    deliverProgress(progress, downloadRequest2, assetDownloadListener);
                } else {
                    return;
                }
            }
            removeNetworkListener();
        }
    }

    private synchronized DownloadRequestMediator findMediatorForCancellation(DownloadRequest downloadRequest) {
        ArrayList<DownloadRequestMediator> arrayList = new ArrayList<>(2);
        arrayList.add(this.mediators.get(getCacheableKey(downloadRequest)));
        arrayList.add(this.mediators.get(getNonCacheableKey(downloadRequest)));
        for (DownloadRequestMediator downloadRequestMediator : arrayList) {
            if (downloadRequestMediator != null) {
                for (DownloadRequest equals : downloadRequestMediator.requests()) {
                    if (equals.equals(downloadRequest)) {
                        return downloadRequestMediator;
                    }
                }
                continue;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void removeNetworkListener() {
        if (this.mediators.isEmpty()) {
            Log.d(TAG, "Removing listener");
            this.networkProvider.removeListener(this.networkListener);
        }
    }

    /* access modifiers changed from: private */
    public int mapExceptionToReason(Throwable th, boolean z) {
        if (th instanceof RuntimeException) {
            return 4;
        }
        if (!z || (th instanceof SocketException) || (th instanceof SocketTimeoutException)) {
            return 0;
        }
        return ((th instanceof UnknownHostException) || (th instanceof SSLException)) ? 1 : 2;
    }

    /* access modifiers changed from: private */
    public long getContentLength(Response response) {
        if (response == null) {
            return -1;
        }
        String str = response.headers().get(com.alibaba.sdk.android.oss.common.utils.HttpHeaders.CONTENT_LENGTH);
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* access modifiers changed from: private */
    public boolean notModified(File file, Response response, DownloadRequestMediator downloadRequestMediator, HashMap<String, String> hashMap) {
        if (response != null && file.exists() && file.length() > 0 && downloadRequestMediator.isCacheable) {
            int code = response.code();
            if (Boolean.parseBoolean(hashMap.get(DOWNLOAD_COMPLETE)) && code == 304) {
                String str = TAG;
                Log.d(str, "304 code, data size matches file size " + debugString(downloadRequestMediator));
                return true;
            }
        }
        return false;
    }

    private boolean satisfiesPartialDownload(Response response, long j, DownloadRequestMediator downloadRequestMediator) {
        RangeResponse rangeResponse = new RangeResponse(response.headers().get(CONTENT_RANGE));
        boolean z = response.code() == 206 && BYTES.equalsIgnoreCase(rangeResponse.dimension) && rangeResponse.rangeStart >= 0 && j == rangeResponse.rangeStart;
        String str = TAG;
        Log.d(str, "satisfies partial download: " + z + " " + debugString(downloadRequestMediator));
        return z;
    }

    /* access modifiers changed from: private */
    public String debugString(DownloadRequestMediator downloadRequestMediator) {
        return ", mediator url - " + downloadRequestMediator.url + ", path - " + downloadRequestMediator.filePath + ", th - " + Thread.currentThread().getName() + "id " + downloadRequestMediator;
    }

    private String debugString(DownloadRequest downloadRequest) {
        return ", single request url - " + downloadRequest.url + ", path - " + downloadRequest.path + ", th - " + Thread.currentThread().getName() + "id " + downloadRequest.id;
    }

    /* access modifiers changed from: private */
    public boolean isAnyConnected(DownloadRequestMediator downloadRequestMediator) {
        for (DownloadRequest next : downloadRequestMediator.requests()) {
            if (next == null) {
                Log.d(TAG, "Request is null");
            } else if (isConnected(next)) {
                return true;
            }
        }
        return false;
    }

    private boolean isConnected(DownloadRequest downloadRequest) {
        int i;
        int currentNetworkType = this.networkProvider.getCurrentNetworkType();
        boolean z = true;
        if (currentNetworkType >= 0 && downloadRequest.networkType == 3) {
            return true;
        }
        if (currentNetworkType != 0) {
            if (currentNetworkType != 1) {
                if (currentNetworkType != 4) {
                    if (currentNetworkType != 9) {
                        if (currentNetworkType != 17) {
                            if (currentNetworkType != 6) {
                                if (currentNetworkType != 7) {
                                    i = -1;
                                    if (i <= 0 || (downloadRequest.networkType & i) != i) {
                                        z = false;
                                    }
                                    Log.d(TAG, "checking pause for type: " + currentNetworkType + " connected " + z + debugString(downloadRequest));
                                    return z;
                                }
                            }
                        }
                    }
                }
            }
            i = 2;
            z = false;
            Log.d(TAG, "checking pause for type: " + currentNetworkType + " connected " + z + debugString(downloadRequest));
            return z;
        }
        i = 1;
        z = false;
        Log.d(TAG, "checking pause for type: " + currentNetworkType + " connected " + z + debugString(downloadRequest));
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        sleep(10);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancelAndAwait(com.vungle.warren.downloader.DownloadRequest r6, long r7) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r5.cancel(r6)
            long r1 = java.lang.System.currentTimeMillis()
            r3 = 0
            long r7 = java.lang.Math.max(r3, r7)
            long r1 = r1 + r7
        L_0x0012:
            long r7 = java.lang.System.currentTimeMillis()
            int r7 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r7 >= 0) goto L_0x0040
            com.vungle.warren.downloader.DownloadRequestMediator r7 = r5.findMediatorForCancellation(r6)
            monitor-enter(r5)
            java.util.List<com.vungle.warren.downloader.DownloadRequest> r8 = r5.transitioning     // Catch:{ all -> 0x003d }
            boolean r8 = r8.contains(r6)     // Catch:{ all -> 0x003d }
            if (r8 != 0) goto L_0x0036
            if (r7 == 0) goto L_0x0033
            java.util.List r7 = r7.requests()     // Catch:{ all -> 0x003d }
            boolean r7 = r7.contains(r6)     // Catch:{ all -> 0x003d }
            if (r7 != 0) goto L_0x0036
        L_0x0033:
            r6 = 1
            monitor-exit(r5)     // Catch:{ all -> 0x003d }
            return r6
        L_0x0036:
            monitor-exit(r5)     // Catch:{ all -> 0x003d }
            r7 = 10
            r5.sleep(r7)
            goto L_0x0012
        L_0x003d:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x003d }
            throw r6
        L_0x0040:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.downloader.AssetDownloader.cancelAndAwait(com.vungle.warren.downloader.DownloadRequest, long):boolean");
    }

    public synchronized void cancel(DownloadRequest downloadRequest) {
        if (downloadRequest != null) {
            onCancelled(downloadRequest);
        }
    }

    public synchronized void cancelAll() {
        Log.d(TAG, "Cancelling all");
        for (DownloadRequest next : this.transitioning) {
            String str = TAG;
            Log.d(str, "Cancel in transtiotion " + next.url);
            cancel(next);
        }
        String str2 = TAG;
        Log.d(str2, "Cancel in mediator " + this.mediators.values().size());
        for (DownloadRequestMediator next2 : this.mediators.values()) {
            String str3 = TAG;
            Log.d(str3, "Cancel in mediator " + next2.key);
            onCancelledMediator(next2);
        }
    }

    public void setProgressStep(int i) {
        if (i != 0) {
            this.progressStep = i;
        }
    }

    public synchronized void init() {
        if (this.cache != null) {
            this.cache.init();
        }
    }

    public synchronized void clearCache() {
        if (this.cache != null) {
            this.cache.clear();
        }
    }

    /* access modifiers changed from: private */
    public synchronized void onNetworkChanged(int i) {
        String str = TAG;
        Log.d(str, "Num of connections: " + this.mediators.values().size());
        for (DownloadRequestMediator next : this.mediators.values()) {
            if (next.is(3)) {
                Log.d(TAG, "Result cancelled");
            } else {
                boolean isAnyConnected = isAnyConnected(next);
                String str2 = TAG;
                Log.d(str2, "Connected = " + isAnyConnected + " for " + i);
                next.setConnected(isAnyConnected);
                if (next.isPausable() && isAnyConnected && next.is(2)) {
                    load(next);
                    String str3 = TAG;
                    Log.d(str3, "resumed " + next.key + " " + next);
                }
            }
        }
    }

    private boolean responseVersionMatches(Response response, HashMap<String, String> hashMap) {
        Headers headers = response.headers();
        String str = headers.get("ETag");
        String str2 = headers.get("Last-Modified");
        String str3 = TAG;
        Log.d(str3, "server etag: " + str);
        String str4 = TAG;
        Log.d(str4, "server lastModified: " + str2);
        if (str != null && !str.equals(hashMap.get("ETag"))) {
            String str5 = TAG;
            Log.d(str5, "etags miss match current: " + hashMap.get("ETag"));
            return false;
        } else if (str2 == null || str2.equals(hashMap.get("Last-Modified"))) {
            return true;
        } else {
            String str6 = TAG;
            Log.d(str6, "lastModified miss match current: " + hashMap.get("Last-Modified"));
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void shutdown() {
        cancel((DownloadRequest) null);
        this.transitioning.clear();
        this.mediators.clear();
        this.uiExecutor.shutdownNow();
        this.downloadExecutor.shutdownNow();
        try {
            this.downloadExecutor.awaitTermination(2, TimeUnit.SECONDS);
            this.uiExecutor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Log.e(TAG, "InterruptedException ", e);
            Thread.currentThread().interrupt();
        }
        return;
    }

    public static abstract class DownloadPriorityRunnable implements Comparable, Runnable {
        private static final AtomicInteger seq = new AtomicInteger();
        private final DownloadRequestMediator mediator;
        private final int order = seq.incrementAndGet();
        private final AssetPriority priority;

        DownloadPriorityRunnable(DownloadRequestMediator downloadRequestMediator) {
            this.mediator = downloadRequestMediator;
            this.priority = downloadRequestMediator.priority;
            downloadRequestMediator.setRunnable(this);
        }

        DownloadPriorityRunnable(AssetPriority assetPriority) {
            this.priority = assetPriority;
            this.mediator = null;
        }

        /* access modifiers changed from: package-private */
        public AssetPriority getPriority() {
            DownloadRequestMediator downloadRequestMediator = this.mediator;
            return downloadRequestMediator != null ? downloadRequestMediator.getPriority() : this.priority;
        }

        public int compareTo(Object obj) {
            if (!(obj instanceof DownloadPriorityRunnable)) {
                return -1;
            }
            DownloadPriorityRunnable downloadPriorityRunnable = (DownloadPriorityRunnable) obj;
            int compareTo = getPriority().compareTo(downloadPriorityRunnable.getPriority());
            return compareTo == 0 ? Integer.valueOf(this.order).compareTo(Integer.valueOf(downloadPriorityRunnable.order)) : compareTo;
        }
    }

    /* access modifiers changed from: private */
    public HashMap<String, String> extractMeta(File file) {
        return FileUtility.readMap(file.getPath());
    }

    /* access modifiers changed from: private */
    public void saveMeta(File file, HashMap<String, String> hashMap) {
        FileUtility.writeMap(file.getPath(), hashMap);
    }

    /* access modifiers changed from: package-private */
    public synchronized void setDownloadedForTests(boolean z, String str, String str2) {
        ArrayList<File> arrayList = new ArrayList<>(2);
        if (this.cache != null) {
            try {
                arrayList.add(this.cache.getMetaFile(this.cache.getFile(str)));
            } catch (IOException e) {
                Log.e(TAG, "Cannot add or get meta file", e);
                throw new RuntimeException("Failed to get file for request");
            }
        }
        arrayList.add(new File(str2 + META_POSTFIX_EXT));
        for (File file : arrayList) {
            HashMap<String, String> extractMeta = extractMeta(file);
            extractMeta.put(DOWNLOAD_COMPLETE, Boolean.valueOf(z).toString());
            FileUtility.writeSerializable(file, extractMeta);
        }
    }

    private void copyToDestination(File file, File file2, Pair<DownloadRequest, AssetDownloadListener> pair) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        IOException e;
        if (file2.exists()) {
            FileUtility.deleteAndLogIfFailed(file2);
        }
        if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    FileChannel channel = fileInputStream.getChannel();
                    channel.transferTo(0, channel.size(), fileOutputStream.getChannel());
                    Log.d(TAG, "Copying: finished " + ((DownloadRequest) pair.first).url + " copying to " + file2.getPath());
                } catch (IOException e2) {
                    e = e2;
                    try {
                        VungleLogger.error("AssetDownloader#copyToDestination; loadAd sequence", String.format("cannot copy from %1$s(%2$s) to %3$s due to %4$s", new Object[]{file.getPath(), ((DownloadRequest) pair.first).url, file2.getPath(), e}));
                        deliverError((DownloadRequest) pair.first, (AssetDownloadListener) pair.second, new AssetDownloadListener.DownloadError(-1, e, 2));
                        Log.d(TAG, "Copying: error" + ((DownloadRequest) pair.first).url + " copying to " + file2.getPath());
                        FileUtility.closeQuietly(fileInputStream);
                        FileUtility.closeQuietly(fileOutputStream);
                    } catch (Throwable th) {
                        th = th;
                    }
                }
            } catch (IOException e3) {
                IOException iOException = e3;
                fileOutputStream = null;
                e = iOException;
                VungleLogger.error("AssetDownloader#copyToDestination; loadAd sequence", String.format("cannot copy from %1$s(%2$s) to %3$s due to %4$s", new Object[]{file.getPath(), ((DownloadRequest) pair.first).url, file2.getPath(), e}));
                deliverError((DownloadRequest) pair.first, (AssetDownloadListener) pair.second, new AssetDownloadListener.DownloadError(-1, e, 2));
                Log.d(TAG, "Copying: error" + ((DownloadRequest) pair.first).url + " copying to " + file2.getPath());
                FileUtility.closeQuietly(fileInputStream);
                FileUtility.closeQuietly(fileOutputStream);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                FileUtility.closeQuietly(fileInputStream);
                FileUtility.closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (IOException e4) {
            fileOutputStream = null;
            e = e4;
            fileInputStream = null;
            VungleLogger.error("AssetDownloader#copyToDestination; loadAd sequence", String.format("cannot copy from %1$s(%2$s) to %3$s due to %4$s", new Object[]{file.getPath(), ((DownloadRequest) pair.first).url, file2.getPath(), e}));
            deliverError((DownloadRequest) pair.first, (AssetDownloadListener) pair.second, new AssetDownloadListener.DownloadError(-1, e, 2));
            Log.d(TAG, "Copying: error" + ((DownloadRequest) pair.first).url + " copying to " + file2.getPath());
            FileUtility.closeQuietly(fileInputStream);
            FileUtility.closeQuietly(fileOutputStream);
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            fileOutputStream = null;
            FileUtility.closeQuietly(fileInputStream);
            FileUtility.closeQuietly(fileOutputStream);
            throw th;
        }
        FileUtility.closeQuietly(fileInputStream);
        FileUtility.closeQuietly(fileOutputStream);
    }

    private void deliverSuccess(Pair<DownloadRequest, AssetDownloadListener> pair, File file) {
        if (pair.second != null) {
            ((AssetDownloadListener) pair.second).onSuccess(file, (DownloadRequest) pair.first);
        }
    }

    /* access modifiers changed from: private */
    public void onSuccessMediator(File file, DownloadRequestMediator downloadRequestMediator) {
        String str = TAG;
        Log.d(str, "OnComplete - Removing connections and listener " + downloadRequestMediator);
        try {
            downloadRequestMediator.lock();
            List<Pair<DownloadRequest, AssetDownloadListener>> values = downloadRequestMediator.values();
            if (!file.exists()) {
                VungleLogger.error("AssetDownloader#onSuccessMediator; loadAd sequence", String.format("File %1$s does not exist; mediator %2$s ", new Object[]{file.getPath(), debugString(downloadRequestMediator)}));
                onErrorMediator(new AssetDownloadListener.DownloadError(-1, new IOException("File is deleted"), 2), downloadRequestMediator);
                return;
            }
            if (this.cache != null && downloadRequestMediator.isCacheable) {
                this.cache.onCacheHit(file, (long) values.size());
                this.cache.setCacheLastUpdateTimestamp(file, System.currentTimeMillis());
            }
            for (Pair next : values) {
                File file2 = new File(((DownloadRequest) next.first).path);
                if (!file2.equals(file)) {
                    copyToDestination(file, file2, next);
                } else {
                    file2 = file;
                }
                String str2 = TAG;
                Log.d(str2, "Deliver success:" + ((DownloadRequest) next.first).url + " dest file: " + file2.getPath());
                deliverSuccess(next, file2);
            }
            removeMediator(downloadRequestMediator);
            downloadRequestMediator.set(6);
            String str3 = TAG;
            Log.d(str3, "Finished " + debugString(downloadRequestMediator));
            downloadRequestMediator.unlock();
        } finally {
            downloadRequestMediator.unlock();
        }
    }

    private String mediatorKeyFromRequest(DownloadRequest downloadRequest) {
        if (isCacheEnabled()) {
            return getCacheableKey(downloadRequest);
        }
        return getNonCacheableKey(downloadRequest);
    }

    private String getNonCacheableKey(DownloadRequest downloadRequest) {
        return downloadRequest.url + " " + downloadRequest.path;
    }

    private String getCacheableKey(DownloadRequest downloadRequest) {
        return downloadRequest.url;
    }

    /* access modifiers changed from: private */
    public void onErrorMediator(AssetDownloadListener.DownloadError downloadError, DownloadRequestMediator downloadRequestMediator) {
        VungleLogger.error("AssetDownloader#onErrorMediator; loadAd sequence", String.format("Error %1$s occured; mediator %2$s", new Object[]{downloadError, debugString(downloadRequestMediator)}));
        if (downloadError == null) {
            downloadError = new AssetDownloadListener.DownloadError(-1, new RuntimeException(), 4);
        }
        try {
            downloadRequestMediator.lock();
            for (Pair next : downloadRequestMediator.values()) {
                deliverError((DownloadRequest) next.first, (AssetDownloadListener) next.second, downloadError);
            }
            removeMediator(downloadRequestMediator);
            downloadRequestMediator.set(6);
        } finally {
            downloadRequestMediator.unlock();
        }
    }

    /* access modifiers changed from: private */
    public void deliverError(final DownloadRequest downloadRequest, final AssetDownloadListener assetDownloadListener, final AssetDownloadListener.DownloadError downloadError) {
        Object[] objArr = new Object[2];
        objArr[0] = downloadError;
        objArr[1] = downloadRequest != null ? debugString(downloadRequest) : "null";
        VungleLogger.error("AssetDownloader#deliverError; loadAd sequence", String.format("Delivering error %1$s; request %2$s", objArr));
        if (assetDownloadListener != null) {
            this.uiExecutor.execute(new Runnable() {
                public void run() {
                    assetDownloadListener.onError(downloadError, downloadRequest);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void onProgressMediator(DownloadRequestMediator downloadRequestMediator, AssetDownloadListener.Progress progress) {
        if (downloadRequestMediator != null) {
            AssetDownloadListener.Progress copy = AssetDownloadListener.Progress.copy(progress);
            String str = TAG;
            Log.d(str, "Progress " + progress.progressPercent + " status " + progress.status + " " + downloadRequestMediator + " " + downloadRequestMediator.filePath);
            for (Pair next : downloadRequestMediator.values()) {
                deliverProgress(copy, (DownloadRequest) next.first, (AssetDownloadListener) next.second);
            }
        }
    }

    private void deliverProgress(final AssetDownloadListener.Progress progress, final DownloadRequest downloadRequest, final AssetDownloadListener assetDownloadListener) {
        if (assetDownloadListener != null) {
            this.uiExecutor.execute(new Runnable() {
                public void run() {
                    String access$000 = AssetDownloader.TAG;
                    Log.d(access$000, "On progress " + downloadRequest);
                    assetDownloadListener.onProgress(progress, downloadRequest);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void deleteFileAndMeta(File file, File file2, boolean z) {
        if (file != null) {
            FileUtility.deleteAndLogIfFailed(file);
            if (file2 != null) {
                FileUtility.deleteAndLogIfFailed(file2);
            }
            if (this.cache != null && isCacheEnabled()) {
                if (z) {
                    this.cache.deleteAndRemove(file);
                } else {
                    this.cache.deleteContents(file);
                }
            }
        }
    }

    public boolean dropCache(String str) {
        DownloaderCache downloaderCache = this.cache;
        if (!(downloaderCache == null || str == null)) {
            try {
                File file = downloaderCache.getFile(str);
                String str2 = TAG;
                Log.d(str2, "Deleting " + file.getPath());
                return this.cache.deleteAndRemove(file);
            } catch (IOException e) {
                VungleLogger.error("AssetDownloader#dropCache; loadAd sequence", String.format("Error %1$s occured", new Object[]{e}));
                Log.e(TAG, "There was an error to get file", e);
            }
        }
        return false;
    }

    public synchronized boolean isCacheEnabled() {
        return this.cache != null && this.isCacheEnabled;
    }

    public synchronized void setCacheEnabled(boolean z) {
        this.isCacheEnabled = z;
    }

    public void updatePriority(DownloadRequest downloadRequest) {
        Runnable runnable;
        final DownloadRequestMediator findMediatorForCancellation = findMediatorForCancellation(downloadRequest);
        if (findMediatorForCancellation != null && (runnable = findMediatorForCancellation.getRunnable()) != null && this.downloadExecutor.remove(runnable)) {
            String str = TAG;
            Log.d(str, "prio: updated to " + findMediatorForCancellation.getPriority());
            this.downloadExecutor.execute(runnable, new Runnable() {
                public void run() {
                    AssetDownloader.this.onErrorMediator(new AssetDownloadListener.DownloadError(-1, new VungleException(39), 1), findMediatorForCancellation);
                }
            });
        }
    }
}
