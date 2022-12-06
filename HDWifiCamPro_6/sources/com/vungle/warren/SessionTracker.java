package com.vungle.warren;

import android.util.Log;
import com.vungle.warren.model.SessionData;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.session.SessionAttribute;
import com.vungle.warren.session.SessionConstants;
import com.vungle.warren.session.SessionEvent;
import com.vungle.warren.utility.ActivityManager;
import com.vungle.warren.utility.ListUtility;
import com.vungle.warren.utility.UtilityResource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class SessionTracker {
    private static final int MAX_EVENTS_PER_REPORT = 40;
    /* access modifiers changed from: private */
    public static final String TAG = SessionTracker.class.getSimpleName();
    private static SessionTracker _instance;
    private static long initTimestamp;
    public ActivityManager.LifeCycleCallback appLifeCycleCallback = new ActivityManager.LifeCycleCallback() {
        private long lastStoppedTimestamp;

        public void onStart() {
            if (this.lastStoppedTimestamp > 0) {
                long systemTimeMillis = SessionTracker.this.utilityResource.getSystemTimeMillis() - this.lastStoppedTimestamp;
                if (SessionTracker.this.getAppSessionTimeout() > -1 && systemTimeMillis > 0 && systemTimeMillis >= SessionTracker.this.getAppSessionTimeout() * 1000 && SessionTracker.this.sessionCallback != null) {
                    SessionTracker.this.sessionCallback.onSessionTimeout();
                }
                SessionTracker.this.trackEvent(new SessionData.Builder().setEvent(SessionEvent.APP_FOREGROUND).build());
            }
        }

        public void onStop() {
            SessionTracker.this.trackEvent(new SessionData.Builder().setEvent(SessionEvent.APP_BACKGROUND).build());
            this.lastStoppedTimestamp = SessionTracker.this.utilityResource.getSystemTimeMillis();
        }
    };
    private long appSessionTimeout;
    private final Map<String, SessionData> customVideoCacheMap = new HashMap();
    private boolean enabled = false;
    /* access modifiers changed from: private */
    public AtomicInteger eventCount = new AtomicInteger();
    private int initCounter;
    /* access modifiers changed from: private */
    public final List<SessionData> pendingEvents = Collections.synchronizedList(new ArrayList());
    private final List<String> placementLoadTracker = new ArrayList();
    /* access modifiers changed from: private */
    public Repository repository;
    /* access modifiers changed from: private */
    public int sendLimit = 40;
    /* access modifiers changed from: private */
    public SessionCallback sessionCallback;
    private ExecutorService sessionDataExecutor;
    /* access modifiers changed from: private */
    public UtilityResource utilityResource;
    private VungleApiClient vungleApiClient;

    public interface SessionCallback {
        void onSessionTimeout();
    }

    public String getOrientation(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "none" : "match_video" : "auto_rotate" : "landscape" : "portrait";
    }

    private SessionTracker() {
    }

    /* access modifiers changed from: protected */
    public void init(SessionCallback sessionCallback2, UtilityResource utilityResource2, final Repository repository2, ExecutorService executorService, VungleApiClient vungleApiClient2, final boolean z, int i) {
        this.sessionCallback = sessionCallback2;
        this.utilityResource = utilityResource2;
        this.sessionDataExecutor = executorService;
        this.repository = repository2;
        this.enabled = z;
        this.vungleApiClient = vungleApiClient2;
        if (i <= 0) {
            i = 40;
        }
        this.sendLimit = i;
        if (!z) {
            clearTracking();
        } else {
            executorService.submit(new Runnable() {
                public void run() {
                    if (!SessionTracker.this.pendingEvents.isEmpty() && z) {
                        for (SessionData trackEvent : SessionTracker.this.pendingEvents) {
                            SessionTracker.this.trackEvent(trackEvent);
                        }
                    }
                    SessionTracker.this.pendingEvents.clear();
                    for (List list : ListUtility.partition(repository2.loadAll(SessionData.class).get(), SessionTracker.this.sendLimit)) {
                        if (list.size() >= SessionTracker.this.sendLimit) {
                            try {
                                SessionTracker.this.sendData(list);
                            } catch (DatabaseHelper.DBException e) {
                                String access$300 = SessionTracker.TAG;
                                Log.e(access$300, "Unable to retrieve data to send " + e.getLocalizedMessage());
                            }
                        } else {
                            SessionTracker.this.eventCount.set(list.size());
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public int getSendLimit() {
        return this.sendLimit;
    }

    public void setInitTimestamp(long j) {
        initTimestamp = j;
    }

    public static SessionTracker getInstance() {
        if (_instance == null) {
            _instance = new SessionTracker();
        }
        return _instance;
    }

    public long getInitTimestamp() {
        return initTimestamp;
    }

    public void trackAdConfig(BannerAdConfig bannerAdConfig) {
        if (bannerAdConfig != null && bannerAdConfig.muteChangedByApi) {
            SessionData.Builder event = new SessionData.Builder().setEvent(SessionEvent.MUTE);
            SessionAttribute sessionAttribute = SessionAttribute.MUTED;
            boolean z = true;
            if ((bannerAdConfig.getSettings() & 1) != 1) {
                z = false;
            }
            trackEvent(event.addData(sessionAttribute, z).build());
        }
    }

    public void trackAdConfig(AdConfig adConfig) {
        if (adConfig != null && adConfig.muteChangedByApi) {
            SessionData.Builder event = new SessionData.Builder().setEvent(SessionEvent.MUTE);
            SessionAttribute sessionAttribute = SessionAttribute.MUTED;
            boolean z = true;
            if ((adConfig.getSettings() & 1) != 1) {
                z = false;
            }
            trackEvent(event.addData(sessionAttribute, z).build());
        }
        if (adConfig != null && adConfig.orientationChangedByApi) {
            trackEvent(new SessionData.Builder().setEvent(SessionEvent.ORIENTATION).addData(SessionAttribute.ORIENTATION, getOrientation(adConfig.getAdOrientation())).build());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void trackEvent(com.vungle.warren.model.SessionData r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 != 0) goto L_0x0005
            monitor-exit(r1)
            return
        L_0x0005:
            boolean r0 = r1.enabled     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0010
            java.util.List<com.vungle.warren.model.SessionData> r0 = r1.pendingEvents     // Catch:{ all -> 0x001b }
            r0.add(r2)     // Catch:{ all -> 0x001b }
            monitor-exit(r1)
            return
        L_0x0010:
            boolean r0 = r1.handleCustomRules(r2)     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.storeEvent(r2)     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r1)
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.SessionTracker.trackEvent(com.vungle.warren.model.SessionData):void");
    }

    private synchronized void storeEvent(final SessionData sessionData) {
        if (this.sessionDataExecutor != null) {
            this.sessionDataExecutor.submit(new Runnable() {
                public void run() {
                    try {
                        if (SessionTracker.this.repository == null) {
                            return;
                        }
                        if (sessionData != null) {
                            SessionTracker.this.repository.save(sessionData);
                            SessionTracker.this.eventCount.incrementAndGet();
                            String access$300 = SessionTracker.TAG;
                            Log.d(access$300, "Session Count: " + SessionTracker.this.eventCount + " " + sessionData.sessionEvent);
                            if (SessionTracker.this.eventCount.get() >= SessionTracker.this.sendLimit) {
                                SessionTracker.this.sendData(SessionTracker.this.repository.loadAll(SessionData.class).get());
                                String access$3002 = SessionTracker.TAG;
                                Log.d(access$3002, "SendData " + SessionTracker.this.eventCount);
                            }
                        }
                    } catch (DatabaseHelper.DBException unused) {
                        VungleLogger.error(SessionTracker.TAG, "Could not save event to DB");
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void clearTracking() {
        this.pendingEvents.clear();
    }

    /* access modifiers changed from: protected */
    public synchronized boolean handleCustomRules(SessionData sessionData) {
        if (SessionEvent.INIT == sessionData.sessionEvent) {
            this.initCounter++;
            return false;
        } else if (SessionEvent.INIT_END == sessionData.sessionEvent) {
            if (this.initCounter <= 0) {
                return true;
            }
            this.initCounter--;
            return false;
        } else if (SessionEvent.LOAD_AD == sessionData.sessionEvent) {
            this.placementLoadTracker.add(sessionData.getStringAttribute(SessionAttribute.PLACEMENT_ID));
            return false;
        } else if (SessionEvent.LOAD_AD_END == sessionData.sessionEvent) {
            if (!this.placementLoadTracker.contains(sessionData.getStringAttribute(SessionAttribute.PLACEMENT_ID))) {
                return true;
            }
            this.placementLoadTracker.remove(sessionData.getStringAttribute(SessionAttribute.PLACEMENT_ID));
            return false;
        } else if (SessionEvent.ADS_CACHED != sessionData.sessionEvent) {
            return false;
        } else {
            if (sessionData.getStringAttribute(SessionAttribute.VIDEO_CACHED) == null) {
                this.customVideoCacheMap.put(sessionData.getStringAttribute(SessionAttribute.URL), sessionData);
                return true;
            }
            SessionData sessionData2 = this.customVideoCacheMap.get(sessionData.getStringAttribute(SessionAttribute.URL));
            if (sessionData2 != null) {
                this.customVideoCacheMap.remove(sessionData.getStringAttribute(SessionAttribute.URL));
                sessionData.removeEvent(SessionAttribute.URL);
                sessionData.addAttribute(SessionAttribute.EVENT_ID, sessionData2.getStringAttribute(SessionAttribute.EVENT_ID));
                return false;
            }
            return !sessionData.getStringAttribute(SessionAttribute.VIDEO_CACHED).equals(SessionConstants.NONE);
        }
    }

    public long getAppSessionTimeout() {
        return this.appSessionTimeout;
    }

    public void setAppSessionTimeout(long j) {
        this.appSessionTimeout = j;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0096, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void sendData(java.util.List<com.vungle.warren.model.SessionData> r5) throws com.vungle.warren.persistence.DatabaseHelper.DBException {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.enabled     // Catch:{ all -> 0x0097 }
            if (r0 == 0) goto L_0x0095
            boolean r0 = r5.isEmpty()     // Catch:{ all -> 0x0097 }
            if (r0 == 0) goto L_0x000d
            goto L_0x0095
        L_0x000d:
            com.google.gson.JsonArray r0 = new com.google.gson.JsonArray     // Catch:{ all -> 0x0097 }
            r0.<init>()     // Catch:{ all -> 0x0097 }
            java.util.Iterator r1 = r5.iterator()     // Catch:{ all -> 0x0097 }
        L_0x0016:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0097 }
            if (r2 == 0) goto L_0x003a
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0097 }
            com.vungle.warren.model.SessionData r2 = (com.vungle.warren.model.SessionData) r2     // Catch:{ all -> 0x0097 }
            java.lang.String r2 = r2.getAsJsonString()     // Catch:{ all -> 0x0097 }
            com.google.gson.JsonElement r2 = com.google.gson.JsonParser.parseString(r2)     // Catch:{ all -> 0x0097 }
            if (r2 == 0) goto L_0x0016
            boolean r3 = r2.isJsonObject()     // Catch:{ all -> 0x0097 }
            if (r3 == 0) goto L_0x0016
            com.google.gson.JsonObject r2 = r2.getAsJsonObject()     // Catch:{ all -> 0x0097 }
            r0.add((com.google.gson.JsonElement) r2)     // Catch:{ all -> 0x0097 }
            goto L_0x0016
        L_0x003a:
            com.vungle.warren.VungleApiClient r1 = r4.vungleApiClient     // Catch:{ IOException -> 0x0072 }
            com.vungle.warren.network.Call r0 = r1.sendSessionDataAnalytics(r0)     // Catch:{ IOException -> 0x0072 }
            com.vungle.warren.network.Response r0 = r0.execute()     // Catch:{ IOException -> 0x0072 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x0072 }
        L_0x0048:
            boolean r1 = r5.hasNext()     // Catch:{ IOException -> 0x0072 }
            if (r1 == 0) goto L_0x008d
            java.lang.Object r1 = r5.next()     // Catch:{ IOException -> 0x0072 }
            com.vungle.warren.model.SessionData r1 = (com.vungle.warren.model.SessionData) r1     // Catch:{ IOException -> 0x0072 }
            boolean r2 = r0.isSuccessful()     // Catch:{ IOException -> 0x0072 }
            if (r2 != 0) goto L_0x006c
            int r2 = r1.getSendAttempts()     // Catch:{ IOException -> 0x0072 }
            int r3 = r4.sendLimit     // Catch:{ IOException -> 0x0072 }
            if (r2 < r3) goto L_0x0063
            goto L_0x006c
        L_0x0063:
            r1.incrementSendAttempt()     // Catch:{ IOException -> 0x0072 }
            com.vungle.warren.persistence.Repository r2 = r4.repository     // Catch:{ IOException -> 0x0072 }
            r2.save(r1)     // Catch:{ IOException -> 0x0072 }
            goto L_0x0048
        L_0x006c:
            com.vungle.warren.persistence.Repository r2 = r4.repository     // Catch:{ IOException -> 0x0072 }
            r2.delete(r1)     // Catch:{ IOException -> 0x0072 }
            goto L_0x0048
        L_0x0072:
            r5 = move-exception
            java.lang.String r0 = TAG     // Catch:{ all -> 0x0097 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0097 }
            r1.<init>()     // Catch:{ all -> 0x0097 }
            java.lang.String r2 = "Sending session analytics failed "
            r1.append(r2)     // Catch:{ all -> 0x0097 }
            java.lang.String r5 = r5.getLocalizedMessage()     // Catch:{ all -> 0x0097 }
            r1.append(r5)     // Catch:{ all -> 0x0097 }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x0097 }
            android.util.Log.e(r0, r5)     // Catch:{ all -> 0x0097 }
        L_0x008d:
            java.util.concurrent.atomic.AtomicInteger r5 = r4.eventCount     // Catch:{ all -> 0x0097 }
            r0 = 0
            r5.set(r0)     // Catch:{ all -> 0x0097 }
            monitor-exit(r4)
            return
        L_0x0095:
            monitor-exit(r4)
            return
        L_0x0097:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.SessionTracker.sendData(java.util.List):void");
    }

    public void observe() {
        ActivityManager.getInstance().addListener(this.appLifeCycleCallback);
    }
}
