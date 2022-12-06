package com.vungle.warren;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.webkit.URLUtil;
import androidx.core.util.Consumer;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.vungle.warren.PrivacyManager;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.AdvertisementDBAdapter;
import com.vungle.warren.model.CacheBust;
import com.vungle.warren.model.CacheBustDBAdapter;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.JsonUtil;
import com.vungle.warren.model.SessionData;
import com.vungle.warren.model.VisionDataDBAdapter;
import com.vungle.warren.network.APIFactory;
import com.vungle.warren.network.Call;
import com.vungle.warren.network.VungleApi;
import com.vungle.warren.omsdk.OMInjector;
import com.vungle.warren.persistence.CacheManager;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.session.SessionAttribute;
import com.vungle.warren.session.SessionEvent;
import com.vungle.warren.utility.TimeoutProvider;
import com.vungle.warren.utility.platform.Platform;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;
import okio.Sink;

public class VungleApiClient {
    private static final String AMAZON_ADVERTISING_ID = "amazon_advertising_id";
    public static final String ANDROID_ID = "android_id";
    private static String BASE_URL = "https://ads.api.vungle.com/";
    public static final String GAID = "gaid";
    private static final String ID = "id";
    public static final String IFA = "ifa";
    /* access modifiers changed from: private */
    public static final String TAG = VungleApiClient.class.getCanonicalName();
    protected static WrapperFramework WRAPPER_FRAMEWORK_SELECTED;
    private static String headerUa;
    private static Set<Interceptor> logInterceptors = new HashSet();
    private static Set<Interceptor> networkInterceptors = new HashSet();
    private VungleApi api;
    private JsonObject appBody;
    private JsonObject baseDeviceInfo;
    private String biLoggingEndpoint;
    private String cacheBustEndpoint;
    private CacheManager cacheManager;
    private OkHttpClient client;
    private Context context;
    private boolean enableOm;
    private VungleApi gzipApi;
    private Boolean isGooglePlayServicesAvailable;
    private String logEndpoint;
    private String newEndpoint;
    private final OMInjector omInjector;
    private final Platform platform;
    private String reportAdEndpoint;
    private Repository repository;
    private String requestAdEndpoint;
    /* access modifiers changed from: private */
    public Map<String, Long> retryAfterDataMap = new ConcurrentHashMap();
    private String riEndpoint;
    private VungleApi timeoutApi;
    private TimeoutProvider timeoutProvider;
    /* access modifiers changed from: private */
    public String uaString = System.getProperty("http.agent");
    private boolean willPlayAdEnabled;
    private String willPlayAdEndpoint;
    private int willPlayAdTimeout;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConnectionTypeDetail {
        public static final String CDMA_1XRTT = "cdma_1xrtt";
        public static final String CDMA_EVDO_0 = "cdma_evdo_0";
        public static final String CDMA_EVDO_A = "cdma_evdo_a";
        public static final String CDMA_EVDO_B = "cdma_evdo_b";
        public static final String EDGE = "edge";
        public static final String GPRS = "gprs";
        public static final String HRPD = "hrpd";
        public static final String HSDPA = "hsdpa";
        public static final String HSUPA = "hsupa";
        public static final String LTE = "LTE";
        public static final String UNKNOWN = "unknown";
        public static final String WCDMA = "wcdma";
    }

    public enum WrapperFramework {
        admob,
        air,
        cocos2dx,
        corona,
        dfp,
        heyzap,
        marmalade,
        mopub,
        unity,
        fyber,
        ironsource,
        upsight,
        appodeal,
        aerserv,
        adtoapp,
        tapdaq,
        vunglehbs,
        max,
        none
    }

    private String getConnectionTypeDetail(int i) {
        switch (i) {
            case 1:
                return ConnectionTypeDetail.GPRS;
            case 2:
                return ConnectionTypeDetail.EDGE;
            case 4:
                return ConnectionTypeDetail.WCDMA;
            case 5:
                return ConnectionTypeDetail.CDMA_EVDO_0;
            case 6:
                return ConnectionTypeDetail.CDMA_EVDO_A;
            case 7:
                return ConnectionTypeDetail.CDMA_1XRTT;
            case 8:
                return ConnectionTypeDetail.HSDPA;
            case 9:
                return ConnectionTypeDetail.HSUPA;
            case 12:
                return ConnectionTypeDetail.CDMA_EVDO_B;
            case 13:
                return ConnectionTypeDetail.LTE;
            case 14:
                return ConnectionTypeDetail.HRPD;
            default:
                return "unknown";
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Platform.MANUFACTURER_AMAZON.equals(Build.MANUFACTURER) ? "VungleAmazon/" : "VungleDroid/");
        sb.append("6.12.0");
        headerUa = sb.toString();
    }

    VungleApiClient(Context context2, CacheManager cacheManager2, Repository repository2, OMInjector oMInjector, Platform platform2) {
        this.cacheManager = cacheManager2;
        this.context = context2.getApplicationContext();
        this.repository = repository2;
        this.omInjector = oMInjector;
        this.platform = platform2;
        OkHttpClient.Builder addInterceptor = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            public Response intercept(Interceptor.Chain chain) throws IOException {
                int code;
                Request request = chain.request();
                String encodedPath = request.url().encodedPath();
                Long l = (Long) VungleApiClient.this.retryAfterDataMap.get(encodedPath);
                if (l != null) {
                    long seconds = TimeUnit.MILLISECONDS.toSeconds(l.longValue() - System.currentTimeMillis());
                    if (seconds > 0) {
                        return new Response.Builder().request(request).addHeader("Retry-After", String.valueOf(seconds)).code(500).protocol(Protocol.HTTP_1_1).message("Server is busy").body(ResponseBody.create(MediaType.parse("application/json; charset=utf-8"), "{\"Error\":\"Retry-After\"}")).build();
                    }
                    VungleApiClient.this.retryAfterDataMap.remove(encodedPath);
                }
                Response proceed = chain.proceed(request);
                if (proceed != null && ((code = proceed.code()) == 429 || code == 500 || code == 502 || code == 503)) {
                    String str = proceed.headers().get("Retry-After");
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            long parseLong = Long.parseLong(str);
                            if (parseLong > 0) {
                                VungleApiClient.this.retryAfterDataMap.put(encodedPath, Long.valueOf((parseLong * 1000) + System.currentTimeMillis()));
                            }
                        } catch (NumberFormatException unused) {
                            Log.d(VungleApiClient.TAG, "Retry-After value is not an valid value");
                        }
                    }
                }
                return proceed;
            }
        });
        this.client = addInterceptor.build();
        OkHttpClient build = addInterceptor.addInterceptor(new GzipRequestInterceptor()).build();
        this.api = new APIFactory(this.client, BASE_URL).createAPI(Vungle._instance.appID);
        this.gzipApi = new APIFactory(build, BASE_URL).createAPI(Vungle._instance.appID);
        this.timeoutProvider = (TimeoutProvider) ServiceLocator.getInstance(context2).getService(TimeoutProvider.class);
    }

    public static String getHeaderUa() {
        return headerUa;
    }

    public static void setHeaderUa(String str) {
        headerUa = str;
    }

    public void init() {
        init(this.context);
    }

    static class GzipRequestInterceptor implements Interceptor {
        private static final String CONTENT_ENCODING = "Content-Encoding";
        private static final String GZIP = "gzip";

        GzipRequestInterceptor() {
        }

        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            if (request.body() == null || request.header("Content-Encoding") != null) {
                return chain.proceed(request);
            }
            return chain.proceed(request.newBuilder().header("Content-Encoding", GZIP).method(request.method(), gzip(request.body())).build());
        }

        private RequestBody gzip(final RequestBody requestBody) throws IOException {
            final Buffer buffer = new Buffer();
            BufferedSink buffer2 = Okio.buffer((Sink) new GzipSink(buffer));
            requestBody.writeTo(buffer2);
            buffer2.close();
            return new RequestBody() {
                public MediaType contentType() {
                    return requestBody.contentType();
                }

                public long contentLength() {
                    return buffer.size();
                }

                public void writeTo(BufferedSink bufferedSink) throws IOException {
                    bufferedSink.write(buffer.snapshot());
                }
            };
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void init(Context context2) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("bundle", context2.getPackageName());
        String str = null;
        try {
            str = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (str == null) {
            str = "1.0";
        }
        jsonObject.addProperty("ver", str);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("make", Build.MANUFACTURER);
        jsonObject2.addProperty("model", Build.MODEL);
        jsonObject2.addProperty("osv", Build.VERSION.RELEASE);
        jsonObject2.addProperty("carrier", ((TelephonyManager) context2.getSystemService("phone")).getNetworkOperatorName());
        jsonObject2.addProperty("os", Platform.MANUFACTURER_AMAZON.equals(Build.MANUFACTURER) ? "amazon" : "android");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context2.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        jsonObject2.addProperty("w", (Number) Integer.valueOf(displayMetrics.widthPixels));
        jsonObject2.addProperty("h", (Number) Integer.valueOf(displayMetrics.heightPixels));
        try {
            this.uaString = this.platform.getUserAgent();
            jsonObject2.addProperty("ua", this.uaString);
            initUserAgentLazy();
        } catch (Exception e) {
            String str2 = TAG;
            Log.e(str2, "Cannot Get UserAgent. Setting Default Device UserAgent." + e.getLocalizedMessage());
        }
        this.baseDeviceInfo = jsonObject2;
        this.appBody = jsonObject;
        this.isGooglePlayServicesAvailable = getPlayServicesAvailabilityFromAPI();
    }

    /* access modifiers changed from: package-private */
    public void setAppId(String str) {
        setAppId(str, this.appBody);
    }

    private void setAppId(String str, JsonObject jsonObject) {
        jsonObject.addProperty("id", str);
    }

    private void initUserAgentLazy() {
        this.platform.getUserAgentLazy(new Consumer<String>() {
            public void accept(String str) {
                if (str == null) {
                    Log.e(VungleApiClient.TAG, "Cannot Get UserAgent. Setting Default Device UserAgent");
                } else {
                    String unused = VungleApiClient.this.uaString = str;
                }
            }
        });
    }

    public com.vungle.warren.network.Response config() throws VungleException, IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("device", getDeviceBody(true));
        jsonObject.add("app", this.appBody);
        jsonObject.add("user", getUserBody());
        JsonObject extBody = getExtBody();
        if (extBody != null) {
            jsonObject.add("ext", extBody);
        }
        com.vungle.warren.network.Response<JsonObject> execute = this.api.config(getHeaderUa(), jsonObject).execute();
        if (!execute.isSuccessful()) {
            return execute;
        }
        JsonObject body = execute.body();
        String str = TAG;
        Log.d(str, "Config Response: " + body);
        if (JsonUtil.hasNonNull(body, "sleep")) {
            String asString = JsonUtil.hasNonNull(body, "info") ? body.get("info").getAsString() : "";
            String str2 = TAG;
            Log.e(str2, "Error Initializing Vungle. Please try again. " + asString);
            throw new VungleException(3);
        } else if (JsonUtil.hasNonNull(body, "endpoints")) {
            JsonObject asJsonObject = body.getAsJsonObject("endpoints");
            HttpUrl parse = HttpUrl.parse(asJsonObject.get("new").getAsString());
            HttpUrl parse2 = HttpUrl.parse(asJsonObject.get(CampaignUnit.JSON_KEY_ADS).getAsString());
            HttpUrl parse3 = HttpUrl.parse(asJsonObject.get("will_play_ad").getAsString());
            HttpUrl parse4 = HttpUrl.parse(asJsonObject.get("report_ad").getAsString());
            HttpUrl parse5 = HttpUrl.parse(asJsonObject.get("ri").getAsString());
            HttpUrl parse6 = HttpUrl.parse(asJsonObject.get("log").getAsString());
            HttpUrl parse7 = HttpUrl.parse(asJsonObject.get(CacheBustDBAdapter.CacheBustColumns.TABLE_NAME).getAsString());
            HttpUrl parse8 = HttpUrl.parse(asJsonObject.get("sdk_bi").getAsString());
            if (parse == null || parse2 == null || parse3 == null || parse4 == null || parse5 == null || parse6 == null || parse7 == null || parse8 == null) {
                Log.e(TAG, "Error Initializing Vungle. Please try again. ");
                throw new VungleException(3);
            }
            this.newEndpoint = parse.toString();
            this.requestAdEndpoint = parse2.toString();
            this.willPlayAdEndpoint = parse3.toString();
            this.reportAdEndpoint = parse4.toString();
            this.riEndpoint = parse5.toString();
            this.logEndpoint = parse6.toString();
            this.cacheBustEndpoint = parse7.toString();
            this.biLoggingEndpoint = parse8.toString();
            JsonObject asJsonObject2 = body.getAsJsonObject("will_play_ad");
            this.willPlayAdTimeout = asJsonObject2.get("request_timeout").getAsInt();
            this.willPlayAdEnabled = asJsonObject2.get("enabled").getAsBoolean();
            this.enableOm = JsonUtil.getAsBoolean(body.getAsJsonObject("viewability"), "om", false);
            if (this.willPlayAdEnabled) {
                Log.v(TAG, "willPlayAd is enabled, generating a timeout client.");
                this.timeoutApi = new APIFactory(this.client.newBuilder().readTimeout((long) this.willPlayAdTimeout, TimeUnit.MILLISECONDS).build(), "https://api.vungle.com/").createAPI(Vungle._instance.appID);
            }
            if (getOmEnabled()) {
                this.omInjector.init();
            } else {
                SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.OM_SDK).addData(SessionAttribute.ENABLED, false).build());
            }
            return execute;
        } else {
            Log.e(TAG, "Error Initializing Vungle. Please try again. ");
            throw new VungleException(3);
        }
    }

    public Call<JsonObject> reportNew() throws IllegalStateException {
        if (this.newEndpoint != null) {
            HashMap hashMap = new HashMap(2);
            JsonElement jsonElement = this.appBody.get("id");
            String str = "";
            hashMap.put("app_id", jsonElement != null ? jsonElement.getAsString() : str);
            JsonObject deviceBody = getDeviceBody();
            if (PrivacyManager.getInstance().shouldSendAdIds()) {
                JsonElement jsonElement2 = deviceBody.get(IFA);
                if (jsonElement2 != null) {
                    str = jsonElement2.getAsString();
                }
                hashMap.put(IFA, str);
            }
            return this.api.reportNew(getHeaderUa(), this.newEndpoint, hashMap);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    public Call<JsonObject> requestAd(String str, String str2, boolean z, JsonObject jsonObject) throws IllegalStateException {
        if (this.requestAdEndpoint != null) {
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.add("device", getDeviceBody());
            jsonObject2.add("app", this.appBody);
            JsonObject userBody = getUserBody();
            if (jsonObject != null) {
                userBody.add("vision", jsonObject);
            }
            jsonObject2.add("user", userBody);
            JsonObject extBody = getExtBody();
            if (extBody != null) {
                jsonObject2.add("ext", extBody);
            }
            JsonObject jsonObject3 = new JsonObject();
            JsonArray jsonArray = new JsonArray();
            jsonArray.add(str);
            jsonObject3.add("placements", jsonArray);
            jsonObject3.addProperty("header_bidding", Boolean.valueOf(z));
            if (!TextUtils.isEmpty(str2)) {
                jsonObject3.addProperty("ad_size", str2);
            }
            jsonObject2.add("request", jsonObject3);
            return this.gzipApi.ads(getHeaderUa(), this.requestAdEndpoint, jsonObject2);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    /* access modifiers changed from: package-private */
    public Call<JsonObject> willPlayAd(String str, boolean z, String str2) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("device", getDeviceBody());
        jsonObject.add("app", this.appBody);
        jsonObject.add("user", getUserBody());
        JsonObject jsonObject2 = new JsonObject();
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.addProperty("reference_id", str);
        jsonObject3.addProperty("is_auto_cached", Boolean.valueOf(z));
        jsonObject2.add("placement", jsonObject3);
        jsonObject2.addProperty(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_AD_TOKEN, str2);
        jsonObject.add("request", jsonObject2);
        return this.timeoutApi.willPlayAd(getHeaderUa(), this.willPlayAdEndpoint, jsonObject);
    }

    /* access modifiers changed from: package-private */
    public boolean canCallWillPlayAd() {
        return this.willPlayAdEnabled && !TextUtils.isEmpty(this.willPlayAdEndpoint);
    }

    public Call<JsonObject> reportAd(JsonObject jsonObject) {
        if (this.reportAdEndpoint != null) {
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.add("device", getDeviceBody());
            jsonObject2.add("app", this.appBody);
            jsonObject2.add("request", jsonObject);
            jsonObject2.add("user", getUserBody());
            JsonObject extBody = getExtBody();
            if (extBody != null) {
                jsonObject2.add("ext", extBody);
            }
            return this.gzipApi.reportAd(getHeaderUa(), this.reportAdEndpoint, jsonObject2);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    public Call<JsonObject> sendLog(JsonObject jsonObject) {
        if (this.logEndpoint != null) {
            return this.gzipApi.sendLog(getHeaderUa(), this.logEndpoint, jsonObject);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    public Call<JsonObject> ri(JsonObject jsonObject) {
        if (this.riEndpoint != null) {
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.add("device", getDeviceBody());
            jsonObject2.add("app", this.appBody);
            jsonObject2.add("request", jsonObject);
            jsonObject2.add("user", getUserBody());
            JsonObject extBody = getExtBody();
            if (extBody != null) {
                jsonObject2.add("ext", extBody);
            }
            return this.api.ri(getHeaderUa(), this.riEndpoint, jsonObject2);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    public boolean pingTPAT(String str) throws ClearTextTrafficException, MalformedURLException {
        boolean z;
        if (TextUtils.isEmpty(str) || HttpUrl.parse(str) == null) {
            SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.TPAT).addData(SessionAttribute.SUCCESS, false).addData(SessionAttribute.REASON, "Invalid URL").addData(SessionAttribute.URL, str).build());
            throw new MalformedURLException("Invalid URL : " + str);
        }
        try {
            String host = new URL(str).getHost();
            if (Build.VERSION.SDK_INT >= 24) {
                z = NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(host);
            } else {
                z = Build.VERSION.SDK_INT >= 23 ? NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted() : true;
            }
            if (z || !URLUtil.isHttpUrl(str)) {
                try {
                    com.vungle.warren.network.Response<Void> execute = this.api.pingTPAT(this.uaString, str).execute();
                    if (execute == null) {
                        SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.TPAT).addData(SessionAttribute.SUCCESS, false).addData(SessionAttribute.REASON, "Error on pinging TPAT").addData(SessionAttribute.URL, str).build());
                    } else if (!execute.isSuccessful()) {
                        SessionTracker instance = SessionTracker.getInstance();
                        SessionData.Builder addData = new SessionData.Builder().setEvent(SessionEvent.TPAT).addData(SessionAttribute.SUCCESS, false);
                        SessionAttribute sessionAttribute = SessionAttribute.REASON;
                        instance.trackEvent(addData.addData(sessionAttribute, execute.code() + ": " + execute.message()).addData(SessionAttribute.URL, str).build());
                    }
                    return true;
                } catch (IOException e) {
                    SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.TPAT).addData(SessionAttribute.SUCCESS, false).addData(SessionAttribute.REASON, e.getMessage()).addData(SessionAttribute.URL, str).build());
                    Log.d(TAG, "Error on pinging TPAT");
                    return false;
                }
            } else {
                SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.TPAT).addData(SessionAttribute.SUCCESS, false).addData(SessionAttribute.REASON, "Clear Text Traffic is blocked").addData(SessionAttribute.URL, str).build());
                throw new ClearTextTrafficException("Clear Text Traffic is blocked");
            }
        } catch (MalformedURLException unused) {
            SessionTracker.getInstance().trackEvent(new SessionData.Builder().setEvent(SessionEvent.TPAT).addData(SessionAttribute.SUCCESS, false).addData(SessionAttribute.REASON, "Invalid URL").addData(SessionAttribute.URL, str).build());
            throw new MalformedURLException("Invalid URL : " + str);
        }
    }

    public Call<JsonObject> cacheBust(long j) {
        if (this.cacheBustEndpoint != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("device", getDeviceBody());
            jsonObject.add("app", this.appBody);
            jsonObject.add("user", getUserBody());
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty(Cookie.LAST_CACHE_BUST, (Number) Long.valueOf(j));
            jsonObject.add("request", jsonObject2);
            return this.gzipApi.cacheBust(getHeaderUa(), this.cacheBustEndpoint, jsonObject);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    public Call<JsonObject> sendAnalytics(Collection<CacheBust> collection) {
        if (this.biLoggingEndpoint == null) {
            throw new IllegalStateException("API Client not configured yet! Must call /config first.");
        } else if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException("Cannot send analytics when bust and session data is empty");
        } else {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("device", getDeviceBody());
            jsonObject.add("app", this.appBody);
            JsonObject jsonObject2 = new JsonObject();
            JsonArray jsonArray = new JsonArray(collection.size());
            for (CacheBust next : collection) {
                for (String addProperty : next.getEventIds()) {
                    JsonObject jsonObject3 = new JsonObject();
                    jsonObject3.addProperty("target", next.getIdType() == 1 ? "campaign" : VisionDataDBAdapter.VisionDataColumns.COLUMN_CREATIVE);
                    jsonObject3.addProperty("id", next.getId());
                    jsonObject3.addProperty("event_id", addProperty);
                    jsonArray.add((JsonElement) jsonObject3);
                }
            }
            if (jsonArray.size() > 0) {
                jsonObject2.add(CacheBustDBAdapter.CacheBustColumns.TABLE_NAME, jsonArray);
            }
            jsonObject.add("request", jsonObject2);
            return this.gzipApi.sendBiAnalytics(getHeaderUa(), this.biLoggingEndpoint, jsonObject);
        }
    }

    public Call<JsonObject> sendSessionDataAnalytics(JsonArray jsonArray) {
        if (this.biLoggingEndpoint != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("device", getDeviceBody());
            jsonObject.add("app", this.appBody);
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.add("session_events", jsonArray);
            jsonObject.add("request", jsonObject2);
            return this.gzipApi.sendBiAnalytics(getHeaderUa(), this.biLoggingEndpoint, jsonObject);
        }
        throw new IllegalStateException("API Client not configured yet! Must call /config first.");
    }

    private JsonObject getDeviceBody() throws IllegalStateException {
        return getDeviceBody(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:112:0x026d, code lost:
        if (((android.app.UiModeManager) r11.context.getSystemService("uimode")).getCurrentModeType() == 4) goto L_0x026f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0321 A[Catch:{ SettingNotFoundException -> 0x0301 }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x035c A[Catch:{ SettingNotFoundException -> 0x0301 }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x035f A[Catch:{ SettingNotFoundException -> 0x0301 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.google.gson.JsonObject getDeviceBody(boolean r12) throws java.lang.IllegalStateException {
        /*
            r11 = this;
            monitor-enter(r11)
            com.google.gson.JsonObject r0 = r11.baseDeviceInfo     // Catch:{ all -> 0x0366 }
            com.google.gson.JsonObject r0 = r0.deepCopy()     // Catch:{ all -> 0x0366 }
            com.google.gson.JsonObject r1 = new com.google.gson.JsonObject     // Catch:{ all -> 0x0366 }
            r1.<init>()     // Catch:{ all -> 0x0366 }
            com.vungle.warren.utility.platform.Platform r2 = r11.platform     // Catch:{ all -> 0x0366 }
            com.vungle.warren.model.AdvertisingInfo r2 = r2.getAdvertisingInfo()     // Catch:{ all -> 0x0366 }
            boolean r3 = r2.limitAdTracking     // Catch:{ all -> 0x0366 }
            java.lang.String r2 = r2.advertisingId     // Catch:{ all -> 0x0366 }
            com.vungle.warren.PrivacyManager r4 = com.vungle.warren.PrivacyManager.getInstance()     // Catch:{ all -> 0x0366 }
            boolean r4 = r4.shouldSendAdIds()     // Catch:{ all -> 0x0366 }
            if (r4 == 0) goto L_0x005a
            if (r2 == 0) goto L_0x003a
            java.lang.String r4 = "Amazon"
            java.lang.String r5 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x0366 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0366 }
            if (r4 == 0) goto L_0x002f
            java.lang.String r4 = "amazon_advertising_id"
            goto L_0x0031
        L_0x002f:
            java.lang.String r4 = "gaid"
        L_0x0031:
            r1.addProperty((java.lang.String) r4, (java.lang.String) r2)     // Catch:{ all -> 0x0366 }
            java.lang.String r4 = "ifa"
            r0.addProperty((java.lang.String) r4, (java.lang.String) r2)     // Catch:{ all -> 0x0366 }
            goto L_0x005a
        L_0x003a:
            com.vungle.warren.utility.platform.Platform r2 = r11.platform     // Catch:{ all -> 0x0366 }
            java.lang.String r2 = r2.getAndroidId()     // Catch:{ all -> 0x0366 }
            java.lang.String r4 = "ifa"
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0366 }
            if (r5 != 0) goto L_0x004a
            r5 = r2
            goto L_0x004c
        L_0x004a:
            java.lang.String r5 = ""
        L_0x004c:
            r0.addProperty((java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x0366 }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0366 }
            if (r4 != 0) goto L_0x005a
            java.lang.String r4 = "android_id"
            r1.addProperty((java.lang.String) r4, (java.lang.String) r2)     // Catch:{ all -> 0x0366 }
        L_0x005a:
            com.vungle.warren.PrivacyManager r2 = com.vungle.warren.PrivacyManager.getInstance()     // Catch:{ all -> 0x0366 }
            boolean r2 = r2.shouldSendAdIds()     // Catch:{ all -> 0x0366 }
            if (r2 == 0) goto L_0x0066
            if (r12 == 0) goto L_0x007a
        L_0x0066:
            java.lang.String r12 = "ifa"
            r0.remove(r12)     // Catch:{ all -> 0x0366 }
            java.lang.String r12 = "android_id"
            r1.remove(r12)     // Catch:{ all -> 0x0366 }
            java.lang.String r12 = "gaid"
            r1.remove(r12)     // Catch:{ all -> 0x0366 }
            java.lang.String r12 = "amazon_advertising_id"
            r1.remove(r12)     // Catch:{ all -> 0x0366 }
        L_0x007a:
            java.lang.String r12 = "lmt"
            r2 = 0
            r4 = 1
            if (r3 == 0) goto L_0x0082
            r3 = r4
            goto L_0x0083
        L_0x0082:
            r3 = r2
        L_0x0083:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0366 }
            r0.addProperty((java.lang.String) r12, (java.lang.Number) r3)     // Catch:{ all -> 0x0366 }
            java.lang.Boolean r12 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0366 }
            java.lang.Boolean r3 = r11.isGooglePlayServicesAvailable()     // Catch:{ all -> 0x0366 }
            boolean r12 = r12.equals(r3)     // Catch:{ all -> 0x0366 }
            java.lang.String r3 = "is_google_play_services_available"
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x0366 }
            r1.addProperty((java.lang.String) r3, (java.lang.Boolean) r12)     // Catch:{ all -> 0x0366 }
            com.vungle.warren.utility.platform.Platform r12 = r11.platform     // Catch:{ all -> 0x0366 }
            java.lang.String r12 = r12.getAppSetId()     // Catch:{ all -> 0x0366 }
            boolean r3 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0366 }
            if (r3 != 0) goto L_0x00ae
            java.lang.String r3 = "app_set_id"
            r1.addProperty((java.lang.String) r3, (java.lang.String) r12)     // Catch:{ all -> 0x0366 }
        L_0x00ae:
            android.content.Context r12 = r11.context     // Catch:{ all -> 0x0366 }
            r3 = 0
            if (r12 == 0) goto L_0x00c0
            android.content.Context r12 = r11.context     // Catch:{ all -> 0x0366 }
            android.content.IntentFilter r5 = new android.content.IntentFilter     // Catch:{ all -> 0x0366 }
            java.lang.String r6 = "android.intent.action.BATTERY_CHANGED"
            r5.<init>(r6)     // Catch:{ all -> 0x0366 }
            android.content.Intent r3 = r12.registerReceiver(r3, r5)     // Catch:{ all -> 0x0366 }
        L_0x00c0:
            r12 = 4
            r5 = 2
            if (r3 == 0) goto L_0x010d
            java.lang.String r6 = "level"
            r7 = -1
            int r6 = r3.getIntExtra(r6, r7)     // Catch:{ all -> 0x0366 }
            java.lang.String r8 = "scale"
            int r8 = r3.getIntExtra(r8, r7)     // Catch:{ all -> 0x0366 }
            if (r6 <= 0) goto L_0x00e1
            if (r8 <= 0) goto L_0x00e1
            java.lang.String r9 = "battery_level"
            float r6 = (float) r6     // Catch:{ all -> 0x0366 }
            float r8 = (float) r8     // Catch:{ all -> 0x0366 }
            float r6 = r6 / r8
            java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ all -> 0x0366 }
            r1.addProperty((java.lang.String) r9, (java.lang.Number) r6)     // Catch:{ all -> 0x0366 }
        L_0x00e1:
            java.lang.String r6 = "status"
            int r6 = r3.getIntExtra(r6, r7)     // Catch:{ all -> 0x0366 }
            if (r6 != r7) goto L_0x00ec
            java.lang.String r3 = "UNKNOWN"
            goto L_0x010f
        L_0x00ec:
            if (r6 == r5) goto L_0x00f5
            r8 = 5
            if (r6 != r8) goto L_0x00f2
            goto L_0x00f5
        L_0x00f2:
            java.lang.String r3 = "NOT_CHARGING"
            goto L_0x010f
        L_0x00f5:
            java.lang.String r6 = "plugged"
            int r3 = r3.getIntExtra(r6, r7)     // Catch:{ all -> 0x0366 }
            if (r3 == r4) goto L_0x010a
            if (r3 == r5) goto L_0x0107
            if (r3 == r12) goto L_0x0104
            java.lang.String r3 = "BATTERY_PLUGGED_OTHERS"
            goto L_0x010f
        L_0x0104:
            java.lang.String r3 = "BATTERY_PLUGGED_WIRELESS"
            goto L_0x010f
        L_0x0107:
            java.lang.String r3 = "BATTERY_PLUGGED_USB"
            goto L_0x010f
        L_0x010a:
            java.lang.String r3 = "BATTERY_PLUGGED_AC"
            goto L_0x010f
        L_0x010d:
            java.lang.String r3 = "UNKNOWN"
        L_0x010f:
            java.lang.String r6 = "battery_state"
            r1.addProperty((java.lang.String) r6, (java.lang.String) r3)     // Catch:{ all -> 0x0366 }
            android.content.Context r3 = r11.context     // Catch:{ all -> 0x0366 }
            java.lang.String r6 = "power"
            java.lang.Object r3 = r3.getSystemService(r6)     // Catch:{ all -> 0x0366 }
            android.os.PowerManager r3 = (android.os.PowerManager) r3     // Catch:{ all -> 0x0366 }
            java.lang.String r6 = "battery_saver_enabled"
            if (r3 == 0) goto L_0x012a
            boolean r3 = r3.isPowerSaveMode()     // Catch:{ all -> 0x0366 }
            if (r3 == 0) goto L_0x012a
            r3 = r4
            goto L_0x012b
        L_0x012a:
            r3 = r2
        L_0x012b:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0366 }
            r1.addProperty((java.lang.String) r6, (java.lang.Number) r3)     // Catch:{ all -> 0x0366 }
            android.content.Context r3 = r11.context     // Catch:{ all -> 0x0366 }
            java.lang.String r6 = "android.permission.ACCESS_NETWORK_STATE"
            int r3 = androidx.core.content.PermissionChecker.checkCallingOrSelfPermission(r3, r6)     // Catch:{ all -> 0x0366 }
            r6 = 24
            r7 = 3
            if (r3 != 0) goto L_0x01c5
            java.lang.String r3 = "NONE"
            java.lang.String r8 = "unknown"
            android.content.Context r9 = r11.context     // Catch:{ all -> 0x0366 }
            java.lang.String r10 = "connectivity"
            java.lang.Object r9 = r9.getSystemService(r10)     // Catch:{ all -> 0x0366 }
            android.net.ConnectivityManager r9 = (android.net.ConnectivityManager) r9     // Catch:{ all -> 0x0366 }
            if (r9 == 0) goto L_0x017d
            android.net.NetworkInfo r10 = r9.getActiveNetworkInfo()     // Catch:{ all -> 0x0366 }
            if (r10 == 0) goto L_0x017d
            int r3 = r10.getType()     // Catch:{ all -> 0x0366 }
            if (r3 == 0) goto L_0x0173
            if (r3 == r4) goto L_0x0170
            r10 = 6
            if (r3 == r10) goto L_0x0170
            r10 = 7
            if (r3 == r10) goto L_0x016d
            r10 = 9
            if (r3 == r10) goto L_0x016a
            java.lang.String r3 = "UNKNOWN"
            goto L_0x017d
        L_0x016a:
            java.lang.String r3 = "ETHERNET"
            goto L_0x017d
        L_0x016d:
            java.lang.String r3 = "BLUETOOTH"
            goto L_0x017d
        L_0x0170:
            java.lang.String r3 = "WIFI"
            goto L_0x017d
        L_0x0173:
            java.lang.String r3 = "MOBILE"
            int r8 = r10.getSubtype()     // Catch:{ all -> 0x0366 }
            java.lang.String r8 = r11.getConnectionTypeDetail(r8)     // Catch:{ all -> 0x0366 }
        L_0x017d:
            java.lang.String r10 = "connection_type"
            r1.addProperty((java.lang.String) r10, (java.lang.String) r3)     // Catch:{ all -> 0x0366 }
            java.lang.String r3 = "connection_type_detail"
            r1.addProperty((java.lang.String) r3, (java.lang.String) r8)     // Catch:{ all -> 0x0366 }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0366 }
            if (r3 < r6) goto L_0x01c5
            boolean r3 = r9.isActiveNetworkMetered()     // Catch:{ all -> 0x0366 }
            if (r3 == 0) goto L_0x01b5
            int r3 = r9.getRestrictBackgroundStatus()     // Catch:{ all -> 0x0366 }
            if (r3 == r4) goto L_0x01a4
            if (r3 == r5) goto L_0x01a1
            if (r3 == r7) goto L_0x019e
            java.lang.String r3 = "UNKNOWN"
            goto L_0x01a6
        L_0x019e:
            java.lang.String r3 = "ENABLED"
            goto L_0x01a6
        L_0x01a1:
            java.lang.String r3 = "WHITELISTED"
            goto L_0x01a6
        L_0x01a4:
            java.lang.String r3 = "DISABLED"
        L_0x01a6:
            java.lang.String r5 = "data_saver_status"
            r1.addProperty((java.lang.String) r5, (java.lang.String) r3)     // Catch:{ all -> 0x0366 }
            java.lang.String r3 = "network_metered"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0366 }
            r1.addProperty((java.lang.String) r3, (java.lang.Number) r5)     // Catch:{ all -> 0x0366 }
            goto L_0x01c5
        L_0x01b5:
            java.lang.String r3 = "data_saver_status"
            java.lang.String r5 = "NOT_APPLICABLE"
            r1.addProperty((java.lang.String) r3, (java.lang.String) r5)     // Catch:{ all -> 0x0366 }
            java.lang.String r3 = "network_metered"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0366 }
            r1.addProperty((java.lang.String) r3, (java.lang.Number) r5)     // Catch:{ all -> 0x0366 }
        L_0x01c5:
            java.lang.String r3 = "locale"
            java.util.Locale r5 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0366 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0366 }
            r1.addProperty((java.lang.String) r3, (java.lang.String) r5)     // Catch:{ all -> 0x0366 }
            java.lang.String r3 = "language"
            java.util.Locale r5 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0366 }
            java.lang.String r5 = r5.getLanguage()     // Catch:{ all -> 0x0366 }
            r1.addProperty((java.lang.String) r3, (java.lang.String) r5)     // Catch:{ all -> 0x0366 }
            java.lang.String r3 = "time_zone"
            java.util.TimeZone r5 = java.util.TimeZone.getDefault()     // Catch:{ all -> 0x0366 }
            java.lang.String r5 = r5.getID()     // Catch:{ all -> 0x0366 }
            r1.addProperty((java.lang.String) r3, (java.lang.String) r5)     // Catch:{ all -> 0x0366 }
            android.content.Context r3 = r11.context     // Catch:{ all -> 0x0366 }
            java.lang.String r5 = "audio"
            java.lang.Object r3 = r3.getSystemService(r5)     // Catch:{ all -> 0x0366 }
            android.media.AudioManager r3 = (android.media.AudioManager) r3     // Catch:{ all -> 0x0366 }
            if (r3 == 0) goto L_0x021a
            int r5 = r3.getStreamMaxVolume(r7)     // Catch:{ all -> 0x0366 }
            int r3 = r3.getStreamVolume(r7)     // Catch:{ all -> 0x0366 }
            float r7 = (float) r3     // Catch:{ all -> 0x0366 }
            float r5 = (float) r5     // Catch:{ all -> 0x0366 }
            float r7 = r7 / r5
            java.lang.String r5 = "volume_level"
            java.lang.Float r7 = java.lang.Float.valueOf(r7)     // Catch:{ all -> 0x0366 }
            r1.addProperty((java.lang.String) r5, (java.lang.Number) r7)     // Catch:{ all -> 0x0366 }
            java.lang.String r5 = "sound_enabled"
            if (r3 <= 0) goto L_0x0212
            r3 = r4
            goto L_0x0213
        L_0x0212:
            r3 = r2
        L_0x0213:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0366 }
            r1.addProperty((java.lang.String) r5, (java.lang.Number) r3)     // Catch:{ all -> 0x0366 }
        L_0x021a:
            com.vungle.warren.persistence.CacheManager r3 = r11.cacheManager     // Catch:{ all -> 0x0366 }
            java.io.File r3 = r3.getCache()     // Catch:{ all -> 0x0366 }
            r3.getPath()     // Catch:{ all -> 0x0366 }
            boolean r5 = r3.exists()     // Catch:{ all -> 0x0366 }
            if (r5 == 0) goto L_0x023e
            boolean r3 = r3.isDirectory()     // Catch:{ all -> 0x0366 }
            if (r3 == 0) goto L_0x023e
            java.lang.String r3 = "storage_bytes_available"
            com.vungle.warren.persistence.CacheManager r5 = r11.cacheManager     // Catch:{ all -> 0x0366 }
            long r7 = r5.getBytesAvailable()     // Catch:{ all -> 0x0366 }
            java.lang.Long r5 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0366 }
            r1.addProperty((java.lang.String) r3, (java.lang.Number) r5)     // Catch:{ all -> 0x0366 }
        L_0x023e:
            java.lang.String r3 = "Amazon"
            java.lang.String r5 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x0366 }
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0366 }
            if (r3 == 0) goto L_0x0259
            android.content.Context r12 = r11.context     // Catch:{ all -> 0x0366 }
            android.content.Context r12 = r12.getApplicationContext()     // Catch:{ all -> 0x0366 }
            android.content.pm.PackageManager r12 = r12.getPackageManager()     // Catch:{ all -> 0x0366 }
            java.lang.String r3 = "amazon.hardware.fire_tv"
            boolean r12 = r12.hasSystemFeature(r3)     // Catch:{ all -> 0x0366 }
            goto L_0x0298
        L_0x0259:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0366 }
            r5 = 23
            if (r3 < r5) goto L_0x0273
            android.content.Context r3 = r11.context     // Catch:{ all -> 0x0366 }
            java.lang.String r5 = "uimode"
            java.lang.Object r3 = r3.getSystemService(r5)     // Catch:{ all -> 0x0366 }
            android.app.UiModeManager r3 = (android.app.UiModeManager) r3     // Catch:{ all -> 0x0366 }
            int r3 = r3.getCurrentModeType()     // Catch:{ all -> 0x0366 }
            if (r3 != r12) goto L_0x0271
        L_0x026f:
            r12 = r4
            goto L_0x0298
        L_0x0271:
            r12 = r2
            goto L_0x0298
        L_0x0273:
            android.content.Context r12 = r11.context     // Catch:{ all -> 0x0366 }
            android.content.Context r12 = r12.getApplicationContext()     // Catch:{ all -> 0x0366 }
            android.content.pm.PackageManager r12 = r12.getPackageManager()     // Catch:{ all -> 0x0366 }
            java.lang.String r3 = "com.google.android.tv"
            boolean r12 = r12.hasSystemFeature(r3)     // Catch:{ all -> 0x0366 }
            if (r12 != 0) goto L_0x026f
            android.content.Context r12 = r11.context     // Catch:{ all -> 0x0366 }
            android.content.Context r12 = r12.getApplicationContext()     // Catch:{ all -> 0x0366 }
            android.content.pm.PackageManager r12 = r12.getPackageManager()     // Catch:{ all -> 0x0366 }
            java.lang.String r3 = "android.hardware.touchscreen"
            boolean r12 = r12.hasSystemFeature(r3)     // Catch:{ all -> 0x0366 }
            if (r12 != 0) goto L_0x0271
            goto L_0x026f
        L_0x0298:
            java.lang.String r3 = "is_tv"
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x0366 }
            r1.addProperty((java.lang.String) r3, (java.lang.Boolean) r12)     // Catch:{ all -> 0x0366 }
            java.lang.String r12 = "os_api_level"
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0366 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0366 }
            r1.addProperty((java.lang.String) r12, (java.lang.Number) r3)     // Catch:{ all -> 0x0366 }
            java.lang.String r12 = "app_target_sdk_version"
            android.content.Context r3 = r11.context     // Catch:{ all -> 0x0366 }
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()     // Catch:{ all -> 0x0366 }
            int r3 = r3.targetSdkVersion     // Catch:{ all -> 0x0366 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0366 }
            r1.addProperty((java.lang.String) r12, (java.lang.Number) r3)     // Catch:{ all -> 0x0366 }
            int r12 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0366 }
            if (r12 < r6) goto L_0x02d2
            java.lang.String r12 = "app_min_sdk_version"
            android.content.Context r3 = r11.context     // Catch:{ all -> 0x0366 }
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()     // Catch:{ all -> 0x0366 }
            int r3 = r3.minSdkVersion     // Catch:{ all -> 0x0366 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0366 }
            r1.addProperty((java.lang.String) r12, (java.lang.Number) r3)     // Catch:{ all -> 0x0366 }
        L_0x02d2:
            int r12 = android.os.Build.VERSION.SDK_INT     // Catch:{ SettingNotFoundException -> 0x0301 }
            r3 = 26
            if (r12 < r3) goto L_0x02f1
            android.content.Context r12 = r11.context     // Catch:{ SettingNotFoundException -> 0x0301 }
            java.lang.String r3 = "android.permission.REQUEST_INSTALL_PACKAGES"
            int r12 = r12.checkCallingOrSelfPermission(r3)     // Catch:{ SettingNotFoundException -> 0x0301 }
            if (r12 != 0) goto L_0x0309
            android.content.Context r12 = r11.context     // Catch:{ SettingNotFoundException -> 0x0301 }
            android.content.Context r12 = r12.getApplicationContext()     // Catch:{ SettingNotFoundException -> 0x0301 }
            android.content.pm.PackageManager r12 = r12.getPackageManager()     // Catch:{ SettingNotFoundException -> 0x0301 }
            boolean r12 = r12.canRequestPackageInstalls()     // Catch:{ SettingNotFoundException -> 0x0301 }
            goto L_0x030a
        L_0x02f1:
            android.content.Context r12 = r11.context     // Catch:{ SettingNotFoundException -> 0x0301 }
            android.content.ContentResolver r12 = r12.getContentResolver()     // Catch:{ SettingNotFoundException -> 0x0301 }
            java.lang.String r3 = "install_non_market_apps"
            int r12 = android.provider.Settings.Secure.getInt(r12, r3)     // Catch:{ SettingNotFoundException -> 0x0301 }
            if (r12 != r4) goto L_0x0309
            r12 = r4
            goto L_0x030a
        L_0x0301:
            r12 = move-exception
            java.lang.String r3 = TAG     // Catch:{ all -> 0x0366 }
            java.lang.String r5 = "isInstallNonMarketAppsEnabled Settings not found"
            android.util.Log.e(r3, r5, r12)     // Catch:{ all -> 0x0366 }
        L_0x0309:
            r12 = r2
        L_0x030a:
            java.lang.String r3 = "is_sideload_enabled"
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x0366 }
            r1.addProperty((java.lang.String) r3, (java.lang.Boolean) r12)     // Catch:{ all -> 0x0366 }
            java.lang.String r12 = android.os.Environment.getExternalStorageState()     // Catch:{ all -> 0x0366 }
            java.lang.String r3 = "mounted"
            boolean r12 = r12.equals(r3)     // Catch:{ all -> 0x0366 }
            java.lang.String r3 = "sd_card_available"
            if (r12 == 0) goto L_0x0322
            r2 = r4
        L_0x0322:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0366 }
            r1.addProperty((java.lang.String) r3, (java.lang.Number) r12)     // Catch:{ all -> 0x0366 }
            java.lang.String r12 = "os_name"
            java.lang.String r2 = android.os.Build.FINGERPRINT     // Catch:{ all -> 0x0366 }
            r1.addProperty((java.lang.String) r12, (java.lang.String) r2)     // Catch:{ all -> 0x0366 }
            java.lang.String r12 = "vduid"
            java.lang.String r2 = ""
            r1.addProperty((java.lang.String) r12, (java.lang.String) r2)     // Catch:{ all -> 0x0366 }
            java.lang.String r12 = "ua"
            java.lang.String r2 = r11.uaString     // Catch:{ all -> 0x0366 }
            r0.addProperty((java.lang.String) r12, (java.lang.String) r2)     // Catch:{ all -> 0x0366 }
            com.google.gson.JsonObject r12 = new com.google.gson.JsonObject     // Catch:{ all -> 0x0366 }
            r12.<init>()     // Catch:{ all -> 0x0366 }
            com.google.gson.JsonObject r2 = new com.google.gson.JsonObject     // Catch:{ all -> 0x0366 }
            r2.<init>()     // Catch:{ all -> 0x0366 }
            java.lang.String r3 = "vungle"
            r12.add(r3, r2)     // Catch:{ all -> 0x0366 }
            java.lang.String r3 = "ext"
            r0.add(r3, r12)     // Catch:{ all -> 0x0366 }
            java.lang.String r12 = "Amazon"
            java.lang.String r3 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x0366 }
            boolean r12 = r12.equals(r3)     // Catch:{ all -> 0x0366 }
            if (r12 == 0) goto L_0x035f
            java.lang.String r12 = "amazon"
            goto L_0x0361
        L_0x035f:
            java.lang.String r12 = "android"
        L_0x0361:
            r2.add(r12, r1)     // Catch:{ all -> 0x0366 }
            monitor-exit(r11)
            return r0
        L_0x0366:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.VungleApiClient.getDeviceBody(boolean):com.google.gson.JsonObject");
    }

    private JsonObject getUserBody() {
        long j;
        String str;
        String str2;
        String str3;
        JsonObject jsonObject = new JsonObject();
        Cookie cookie = this.repository.load(Cookie.CONSENT_COOKIE, Cookie.class).get(this.timeoutProvider.getTimeout(), TimeUnit.MILLISECONDS);
        if (cookie != null) {
            str2 = cookie.getString("consent_status");
            str = cookie.getString("consent_source");
            j = cookie.getLong("timestamp").longValue();
            str3 = cookie.getString("consent_message_version");
        } else {
            j = 0;
            str2 = "unknown";
            str = "no_interaction";
            str3 = "";
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("consent_status", str2);
        jsonObject2.addProperty("consent_source", str);
        jsonObject2.addProperty("consent_timestamp", (Number) Long.valueOf(j));
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        jsonObject2.addProperty("consent_message_version", str3);
        jsonObject.add("gdpr", jsonObject2);
        Cookie cookie2 = this.repository.load(Cookie.CCPA_COOKIE, Cookie.class).get();
        String string = cookie2 != null ? cookie2.getString(Cookie.CCPA_CONSENT_STATUS) : "opted_in";
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.addProperty("status", string);
        jsonObject.add("ccpa", jsonObject3);
        if (PrivacyManager.getInstance().getCoppaStatus() != PrivacyManager.COPPA.COPPA_NOTSET) {
            JsonObject jsonObject4 = new JsonObject();
            jsonObject4.addProperty(Cookie.COPPA_STATUS_KEY, Boolean.valueOf(PrivacyManager.getInstance().getCoppaStatus().getValue()));
            jsonObject.add(Cookie.COPPA_KEY, jsonObject4);
        }
        return jsonObject;
    }

    public boolean getOmEnabled() {
        return this.enableOm;
    }

    private String getUserAgentFromCookie() {
        Cookie cookie = this.repository.load(Cookie.USER_AGENT_ID_COOKIE, Cookie.class).get();
        if (cookie == null) {
            return System.getProperty("http.agent");
        }
        String string = cookie.getString(Cookie.USER_AGENT_ID_COOKIE);
        return TextUtils.isEmpty(string) ? System.getProperty("http.agent") : string;
    }

    public long getRetryAfterHeaderValue(com.vungle.warren.network.Response response) {
        try {
            return Long.parseLong(response.headers().get("Retry-After")) * 1000;
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static class ClearTextTrafficException extends IOException {
        ClearTextTrafficException(String str) {
            super(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void overrideApi(VungleApi vungleApi) {
        this.api = vungleApi;
    }

    public Boolean isGooglePlayServicesAvailable() {
        if (this.isGooglePlayServicesAvailable == null) {
            this.isGooglePlayServicesAvailable = getPlayServicesAvailabilityFromCookie();
        }
        if (this.isGooglePlayServicesAvailable == null) {
            this.isGooglePlayServicesAvailable = getPlayServicesAvailabilityFromAPI();
        }
        return this.isGooglePlayServicesAvailable;
    }

    /* access modifiers changed from: package-private */
    public Boolean getPlayServicesAvailabilityFromCookie() {
        Cookie cookie = this.repository.load(Cookie.IS_PLAY_SERVICE_AVAILABLE, Cookie.class).get(this.timeoutProvider.getTimeout(), TimeUnit.MILLISECONDS);
        if (cookie != null) {
            return cookie.getBoolean(Cookie.IS_PLAY_SERVICE_AVAILABLE);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Boolean getPlayServicesAvailabilityFromAPI() {
        try {
            GoogleApiAvailabilityLight instance = GoogleApiAvailabilityLight.getInstance();
            if (instance == null) {
                return null;
            }
            Boolean valueOf = Boolean.valueOf(instance.isGooglePlayServicesAvailable(this.context) == 0);
            addPlaySvcAvailabilityInCookie(valueOf.booleanValue());
            return valueOf;
        } catch (NoClassDefFoundError unused) {
            Log.w(TAG, "Play services Not available");
            Boolean bool = false;
            try {
                addPlaySvcAvailabilityInCookie(bool.booleanValue());
                return bool;
            } catch (DatabaseHelper.DBException unused2) {
                Log.w(TAG, "Failure to write GPS availability to DB");
                return bool;
            }
        } catch (Exception unused3) {
            Log.w(TAG, "Unexpected exception from Play services lib.");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void addPlaySvcAvailabilityInCookie(boolean z) throws DatabaseHelper.DBException {
        Cookie cookie = new Cookie(Cookie.IS_PLAY_SERVICE_AVAILABLE);
        cookie.putValue(Cookie.IS_PLAY_SERVICE_AVAILABLE, Boolean.valueOf(z));
        this.repository.save(cookie);
    }

    private JsonObject getExtBody() {
        Cookie cookie = this.repository.load(Cookie.CONFIG_EXTENSION, Cookie.class).get(this.timeoutProvider.getTimeout(), TimeUnit.MILLISECONDS);
        String string = cookie != null ? cookie.getString(Cookie.CONFIG_EXTENSION) : "";
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(Cookie.CONFIG_EXTENSION, string);
        return jsonObject;
    }
}
