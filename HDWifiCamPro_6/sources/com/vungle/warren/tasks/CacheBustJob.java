package com.vungle.warren.tasks;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.vungle.warren.AdConfig;
import com.vungle.warren.AdLoader;
import com.vungle.warren.AdRequest;
import com.vungle.warren.CacheBustManager;
import com.vungle.warren.LoadAdCallback;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.CacheBust;
import com.vungle.warren.model.CacheBustDBAdapter;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.Placement;
import com.vungle.warren.network.Response;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CacheBustJob implements Job {
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final String TAG = CacheBustJob.class.getCanonicalName();
    private final AdLoader adLoader;
    private final VungleApiClient client;
    private final Repository repository;

    public CacheBustJob(VungleApiClient vungleApiClient, Repository repository2, AdLoader adLoader2) {
        this.client = vungleApiClient;
        this.repository = repository2;
        this.adLoader = adLoader2;
    }

    public int onRunJob(Bundle bundle, JobRunner jobRunner) {
        Repository repository2;
        Log.i(TAG, "CacheBustJob started");
        if (this.client == null || (repository2 = this.repository) == null) {
            Log.e(TAG, "CacheBustJob finished - no client or repository");
            return 1;
        }
        try {
            Cookie cookie = repository2.load(Cookie.CACHE_BUST_COOKIE, Cookie.class).get();
            if (cookie == null) {
                cookie = new Cookie(Cookie.CACHE_BUST_COOKIE);
            }
            Cookie cookie2 = cookie;
            Response<JsonObject> execute = this.client.cacheBust(cookie2.getLong(Cookie.LAST_CACHE_BUST).longValue()).execute();
            ArrayList arrayList = new ArrayList();
            List<CacheBust> unProcessedBusts = this.repository.getUnProcessedBusts();
            if (unProcessedBusts != null && !unProcessedBusts.isEmpty()) {
                arrayList.addAll(unProcessedBusts);
            }
            Gson gson = new Gson();
            if (execute.isSuccessful()) {
                JsonObject body = execute.body();
                if (body != null) {
                    if (body.has(CacheBustDBAdapter.CacheBustColumns.TABLE_NAME)) {
                        JsonObject asJsonObject = body.getAsJsonObject(CacheBustDBAdapter.CacheBustColumns.TABLE_NAME);
                        if (asJsonObject.has("last_updated") && asJsonObject.get("last_updated").getAsLong() > 0) {
                            cookie2.putValue(Cookie.LAST_CACHE_BUST, Long.valueOf(asJsonObject.get("last_updated").getAsLong()));
                            this.repository.save(cookie2);
                        }
                        parseAndSaveCacheBust(asJsonObject, "campaign_ids", 1, "cannot save campaignBust=", arrayList, gson);
                        parseAndSaveCacheBust(asJsonObject, "creative_ids", 2, "cannot save creativeBust=", arrayList, gson);
                    }
                }
                Log.e(TAG, "CacheBustJob finished - no jsonObject or cache_bust in it");
                return 1;
            }
            processBust(arrayList);
            updateTimerData(bundle, cookie2);
            sendAnalytics();
            Log.d(TAG, "CacheBustJob finished");
            return 2;
        } catch (IOException e) {
            Log.e(TAG, "CacheBustJob failed - IOException", e);
            return 2;
        } catch (DatabaseHelper.DBException e2) {
            Log.e(TAG, "CacheBustJob failed - DBException", e2);
            return 2;
        }
    }

    private void parseAndSaveCacheBust(JsonObject jsonObject, String str, int i, String str2, List<CacheBust> list, Gson gson) {
        if (jsonObject.has(str)) {
            Iterator<JsonElement> it = jsonObject.getAsJsonArray(str).iterator();
            while (it.hasNext()) {
                CacheBust cacheBust = (CacheBust) gson.fromJson(it.next(), CacheBust.class);
                cacheBust.setTimeWindowEnd(cacheBust.getTimeWindowEnd() * 1000);
                cacheBust.setIdType(i);
                list.add(cacheBust);
                try {
                    this.repository.save(cacheBust);
                } catch (DatabaseHelper.DBException unused) {
                    VungleLogger.error(CacheBustJob.class.getSimpleName() + "#onRunJob", str2 + cacheBust);
                }
            }
        }
    }

    private void processBust(Iterable<CacheBust> iterable) {
        for (CacheBust next : iterable) {
            List<Advertisement> adsByCampaign = next.getIdType() == 1 ? this.repository.getAdsByCampaign(next.getId()) : this.repository.getAdsByCreative(next.getId());
            LinkedList linkedList = new LinkedList();
            LinkedList<Advertisement> linkedList2 = new LinkedList<>();
            for (Advertisement next2 : adsByCampaign) {
                if (next2.getServerRequestTimestamp() < next.getTimeWindowEnd() && shouldAdBeBusted(next2)) {
                    linkedList.add(next2.getId());
                    linkedList2.add(next2);
                }
            }
            if (linkedList.isEmpty()) {
                Log.d(TAG, "processBust: bust has no relevant ads, deleting " + next);
                try {
                    this.repository.delete(next);
                } catch (DatabaseHelper.DBException e) {
                    VungleLogger.error(CacheBustJob.class.getSimpleName() + "#processBust", "Cannot delete obsolete bust " + next + " because of " + e);
                }
            } else {
                next.setEventIds((String[]) linkedList.toArray(EMPTY_STRING_ARRAY));
                for (Advertisement bustAd : linkedList2) {
                    bustAd(bustAd, next);
                }
            }
        }
    }

    private boolean shouldAdBeBusted(Advertisement advertisement) {
        return (advertisement.getState() == 2 || advertisement.getState() == 3) ? false : true;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:20|21|22|23|24|37|34|18) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void sendAnalytics() {
        /*
            r7 = this;
            com.vungle.warren.persistence.Repository r0 = r7.repository
            java.lang.Class<com.vungle.warren.model.CacheBust> r1 = com.vungle.warren.model.CacheBust.class
            com.vungle.warren.persistence.FutureResult r0 = r0.loadAll(r1)
            java.lang.Object r0 = r0.get()
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x00ac
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0018
            goto L_0x00ac
        L_0x0018:
            java.util.LinkedList r1 = new java.util.LinkedList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0021:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x003b
            java.lang.Object r2 = r0.next()
            com.vungle.warren.model.CacheBust r2 = (com.vungle.warren.model.CacheBust) r2
            long r3 = r2.getTimestampProcessed()
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0021
            r1.add(r2)
            goto L_0x0021
        L_0x003b:
            boolean r0 = r1.isEmpty()
            if (r0 == 0) goto L_0x0049
            java.lang.String r0 = TAG
            java.lang.String r1 = "sendAnalytics: no cachebusts to send analytics"
            android.util.Log.d(r0, r1)
            return
        L_0x0049:
            com.vungle.warren.VungleApiClient r0 = r7.client     // Catch:{ IOException -> 0x00a3 }
            com.vungle.warren.network.Call r0 = r0.sendAnalytics(r1)     // Catch:{ IOException -> 0x00a3 }
            com.vungle.warren.network.Response r0 = r0.execute()     // Catch:{ IOException -> 0x00a3 }
            boolean r2 = r0.isSuccessful()     // Catch:{ IOException -> 0x00a3 }
            if (r2 == 0) goto L_0x008c
            java.util.Iterator r0 = r1.iterator()     // Catch:{ IOException -> 0x00a3 }
        L_0x005d:
            boolean r1 = r0.hasNext()     // Catch:{ IOException -> 0x00a3 }
            if (r1 == 0) goto L_0x00ab
            java.lang.Object r1 = r0.next()     // Catch:{ IOException -> 0x00a3 }
            com.vungle.warren.model.CacheBust r1 = (com.vungle.warren.model.CacheBust) r1     // Catch:{ IOException -> 0x00a3 }
            com.vungle.warren.persistence.Repository r2 = r7.repository     // Catch:{ DBException -> 0x006f }
            r2.delete(r1)     // Catch:{ DBException -> 0x006f }
            goto L_0x005d
        L_0x006f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00a3 }
            r1.<init>()     // Catch:{ IOException -> 0x00a3 }
            java.lang.Class<com.vungle.warren.CacheBustManager> r2 = com.vungle.warren.CacheBustManager.class
            java.lang.String r2 = r2.getSimpleName()     // Catch:{ IOException -> 0x00a3 }
            r1.append(r2)     // Catch:{ IOException -> 0x00a3 }
            java.lang.String r2 = "#sendAnalytics"
            r1.append(r2)     // Catch:{ IOException -> 0x00a3 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x00a3 }
            java.lang.String r2 = "can't delete bust \" + cacheBust"
            com.vungle.warren.VungleLogger.error(r1, r2)     // Catch:{ IOException -> 0x00a3 }
            goto L_0x005d
        L_0x008c:
            java.lang.String r1 = TAG     // Catch:{ IOException -> 0x00a3 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00a3 }
            r2.<init>()     // Catch:{ IOException -> 0x00a3 }
            java.lang.String r3 = "sendAnalytics: not successful, aborting, response is "
            r2.append(r3)     // Catch:{ IOException -> 0x00a3 }
            r2.append(r0)     // Catch:{ IOException -> 0x00a3 }
            java.lang.String r0 = r2.toString()     // Catch:{ IOException -> 0x00a3 }
            android.util.Log.e(r1, r0)     // Catch:{ IOException -> 0x00a3 }
            goto L_0x00ab
        L_0x00a3:
            r0 = move-exception
            java.lang.String r1 = TAG
            java.lang.String r2 = "sendAnalytics: can't execute API call"
            android.util.Log.e(r1, r2, r0)
        L_0x00ab:
            return
        L_0x00ac:
            java.lang.String r0 = TAG
            java.lang.String r1 = "sendAnalytics: no cachebusts in repository"
            android.util.Log.d(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.tasks.CacheBustJob.sendAnalytics():void");
    }

    private void bustAd(Advertisement advertisement, CacheBust cacheBust) {
        Advertisement advertisement2 = advertisement;
        CacheBust cacheBust2 = cacheBust;
        try {
            String str = TAG;
            Log.d(str, "bustAd: deleting " + advertisement.getId());
            this.adLoader.dropCache(advertisement.getId());
            this.repository.deleteAdvertisement(advertisement.getId());
            Placement placement = this.repository.load(this.repository.getPlacementIdByAd(advertisement2), Placement.class).get();
            if (placement != null) {
                new AdConfig().setAdSize(placement.getAdSize());
                if (placement.isMultipleHBPEnabled()) {
                    this.adLoader.loadEndlessIfNeeded(placement, placement.getAdSize(), 0, false);
                } else if (placement.isAutoCached()) {
                    this.adLoader.load(new AdLoader.Operation(new AdRequest(placement.getId(), false), placement.getAdSize(), 0, 2000, 5, 1, 0, false, placement.getAutoCachePriority(), new LoadAdCallback[0]));
                }
            }
            cacheBust2.setTimestampProcessed(System.currentTimeMillis());
            this.repository.save(cacheBust2);
        } catch (DatabaseHelper.DBException e) {
            String str2 = TAG;
            Log.e(str2, "bustAd: cannot drop cache or delete advertisement for " + advertisement2, e);
        }
    }

    /* access modifiers changed from: protected */
    public void updateTimerData(Bundle bundle, Cookie cookie) throws DatabaseHelper.DBException {
        long j = bundle.getLong(CacheBustManager.CACHE_BUST_INTERVAL);
        if (j != 0) {
            cookie.putValue(CacheBustManager.NEXT_CACHE_BUST, Long.valueOf(SystemClock.elapsedRealtime() + j));
        }
        this.repository.save(cookie);
    }

    public static JobInfo makeJobInfo() {
        return new JobInfo(TAG).setPriority(0).setUpdateCurrent(true);
    }
}
