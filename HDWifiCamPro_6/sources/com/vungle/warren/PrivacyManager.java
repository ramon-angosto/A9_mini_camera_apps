package com.vungle.warren;

import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.AnalyticUrl;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.utility.CookieUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

public class PrivacyManager {
    private static final AtomicReference<Boolean> coppaStatus = new AtomicReference<>();
    private static final AtomicReference<Boolean> disableAdId = new AtomicReference<>();
    private static PrivacyManager sInstance;
    private ExecutorService backgroundExecutor;
    /* access modifiers changed from: private */
    public Repository repository;

    public enum COPPA {
        COPPA_ENABLED(true),
        COPPA_DISABLED(false),
        COPPA_NOTSET((String) null);
        
        private Boolean value;

        private COPPA(Boolean bool) {
            this.value = bool;
        }

        public boolean getValue() {
            Boolean bool = this.value;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }
    }

    private PrivacyManager() {
    }

    protected static synchronized PrivacyManager getInstance() {
        PrivacyManager privacyManager;
        synchronized (PrivacyManager.class) {
            if (sInstance == null) {
                sInstance = new PrivacyManager();
            }
            privacyManager = sInstance;
        }
        return privacyManager;
    }

    /* access modifiers changed from: protected */
    public synchronized void init(ExecutorService executorService, Repository repository2) {
        this.repository = repository2;
        this.backgroundExecutor = executorService;
        Boolean bool = CookieUtil.getBoolean(repository2, Cookie.COPPA_COOKIE, Cookie.COPPA_STATUS_KEY);
        if (coppaStatus.get() != null) {
            updateCoppaStatus(coppaStatus.get());
        } else if (bool != null) {
            coppaStatus.set(bool);
        }
    }

    /* access modifiers changed from: protected */
    public void updateCoppaStatus(final Boolean bool) {
        ExecutorService executorService;
        if (bool != null) {
            coppaStatus.set(bool);
            if (this.repository != null && (executorService = this.backgroundExecutor) != null) {
                executorService.execute(new Runnable() {
                    public void run() {
                        CookieUtil.update(PrivacyManager.this.repository, Cookie.COPPA_COOKIE, Cookie.COPPA_STATUS_KEY, bool);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: protected */
    public COPPA getCoppaStatus() {
        AtomicReference<Boolean> atomicReference = coppaStatus;
        if (atomicReference == null || atomicReference.get() == null) {
            return COPPA.COPPA_NOTSET;
        }
        if (coppaStatus.get().booleanValue()) {
            return COPPA.COPPA_ENABLED;
        }
        if (!coppaStatus.get().booleanValue()) {
            return COPPA.COPPA_DISABLED;
        }
        return COPPA.COPPA_NOTSET;
    }

    /* access modifiers changed from: protected */
    public void updateDisableAdId(boolean z) {
        disableAdId.set(Boolean.valueOf(z));
        Repository repository2 = this.repository;
        if (repository2 != null) {
            Boolean bool = CookieUtil.getBoolean(repository2, Cookie.COPPA_COOKIE, Cookie.COPPA_DISABLE_AD_ID);
            if ((bool == null || !bool.booleanValue()) && z) {
                deleteItemsWithAdIds();
            }
            CookieUtil.update(this.repository, Cookie.COPPA_COOKIE, Cookie.COPPA_DISABLE_AD_ID, Boolean.valueOf(z));
        }
    }

    /* access modifiers changed from: protected */
    public boolean shouldSendAdIds() {
        AtomicReference<Boolean> atomicReference = disableAdId;
        if (atomicReference == null || atomicReference.get() == null) {
            return false;
        }
        return !disableAdId.get().booleanValue();
    }

    /* access modifiers changed from: protected */
    public void clean() {
        disableAdId.set((Object) null);
        coppaStatus.set((Object) null);
    }

    private void deleteItemsWithAdIds() {
        this.repository.deleteAll(Advertisement.class);
        this.repository.deleteAll(AnalyticUrl.class);
    }
}
