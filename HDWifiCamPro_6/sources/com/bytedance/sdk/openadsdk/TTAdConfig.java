package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.api.init.PAGConfig;
import com.bytedance.sdk.openadsdk.core.h;

@Deprecated
public final class TTAdConfig implements InitConfig {
    private boolean a = false;
    private String b;
    private boolean c = true;
    private boolean d = false;
    private boolean e = false;
    private PAGConfig f = new PAGConfig();
    private PAGConfig.Builder g = new PAGConfig.Builder();
    private String[] h;

    public String[] getNeedClearTaskReset() {
        return this.h;
    }

    /* access modifiers changed from: private */
    public void a(PAGConfig pAGConfig) {
        this.f = pAGConfig;
    }

    /* access modifiers changed from: private */
    public void a(PAGConfig.Builder builder) {
        this.g = builder;
    }

    public void setCoppa(int i) {
        this.f = this.g.setDoNotSell(i).build();
    }

    public int getCoppa() {
        return this.f.getCoppa();
    }

    public void setGDPR(int i) {
        this.f = this.g.setGDPRConsent(i).build();
    }

    public int getGdpr() {
        return this.f.getGdpr();
    }

    public void setCcpa(int i) {
        this.f = this.g.setDoNotSell(i).build();
    }

    public int getCcpa() {
        return this.f.getCcpa();
    }

    public String getAppId() {
        return this.f.getAppId();
    }

    public void setAppId(String str) {
        this.f = this.g.appId(str).build();
    }

    public String getData() {
        return this.f.getData();
    }

    public void setData(String str) {
        this.f = this.g.setUserData(str).build();
    }

    public String getAppName() {
        return h.d().g();
    }

    public void setAppName(String str) {
        h.d().b(str);
    }

    public int getAppIconId() {
        return this.f.getAppIconId();
    }

    public void setAppIcon(int i) {
        this.f = this.g.appIcon(i).build();
    }

    public boolean isPaid() {
        return this.a;
    }

    public void setPaid(boolean z) {
        this.a = z;
    }

    public String getKeywords() {
        return this.b;
    }

    public void setKeywords(String str) {
        this.b = str;
    }

    public int getTitleBarTheme() {
        return this.f.getTitleBarTheme();
    }

    public void setTitleBarTheme(int i) {
        this.f = this.g.titleBarTheme(i).build();
    }

    public boolean isAllowShowNotify() {
        return this.c;
    }

    public void setAllowShowNotify(boolean z) {
        this.c = z;
    }

    public boolean isDebug() {
        return this.d;
    }

    public void setDebug(boolean z) {
        this.d = z;
    }

    public boolean isUseTextureView() {
        return this.f.isUseTextureView();
    }

    public void setUseTextureView(boolean z) {
        this.f = this.g.useTextureView(z).build();
    }

    public boolean isSupportMultiProcess() {
        return this.f.isSupportMultiProcess();
    }

    public void setSupportMultiProcess(boolean z) {
        this.f = this.g.supportMultiProcess(z).build();
    }

    public boolean isAsyncInit() {
        return this.e;
    }

    public void setAsyncInit(boolean z) {
        this.e = z;
    }

    public void setPackageName(String str) {
        this.f = this.g.setPackageName(str).build();
    }

    public String getPackageName() {
        return this.f.getPackageName();
    }

    public int getDebugLog() {
        return this.f.getDebugLog() ? 1 : 0;
    }

    public void setDebugLog(int i) {
        PAGConfig.Builder builder = this.g;
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        this.f = builder.debugLog(z).build();
    }

    public static class Builder {
        private PAGConfig.Builder a = new PAGConfig.Builder();
        private String b;
        private boolean c = false;
        private String d;
        private boolean e = true;
        private boolean f = false;
        private boolean g = false;

        @Deprecated
        public Builder allowShowPageWhenScreenLock(boolean z) {
            return this;
        }

        public Builder coppa(int i) {
            this.a.setChildDirected(i);
            return this;
        }

        public Builder setGDPR(int i) {
            this.a.setGDPRConsent(i);
            return this;
        }

        public Builder setCCPA(int i) {
            this.a.setDoNotSell(i);
            return this;
        }

        public Builder appId(String str) {
            this.a.appId(str);
            return this;
        }

        public Builder appIcon(int i) {
            this.a.appIcon(i);
            return this;
        }

        @Deprecated
        public Builder appName(String str) {
            this.b = str;
            return this;
        }

        @Deprecated
        public Builder paid(boolean z) {
            this.c = z;
            return this;
        }

        @Deprecated
        public Builder keywords(String str) {
            this.d = str;
            return this;
        }

        public Builder data(String str) {
            this.a.setUserData(str);
            return this;
        }

        @Deprecated
        public Builder titleBarTheme(int i) {
            this.a.titleBarTheme(i);
            return this;
        }

        @Deprecated
        public Builder allowShowNotify(boolean z) {
            this.e = z;
            return this;
        }

        public Builder debug(boolean z) {
            this.f = z;
            return this;
        }

        public Builder useTextureView(boolean z) {
            this.a.useTextureView(z);
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.a.supportMultiProcess(z);
            return this;
        }

        @Deprecated
        public Builder needClearTaskReset(String... strArr) {
            this.a.needClearTaskReset(strArr);
            return this;
        }

        public Builder asyncInit(boolean z) {
            this.g = z;
            return this;
        }

        public Builder debugLog(int i) {
            PAGConfig.Builder builder = this.a;
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            builder.debugLog(z);
            return this;
        }

        public Builder setPackageName(String str) {
            this.a.setPackageName(str);
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig();
            tTAdConfig.setAppName(this.b);
            tTAdConfig.setPaid(this.c);
            tTAdConfig.setKeywords(this.d);
            tTAdConfig.setAllowShowNotify(this.e);
            tTAdConfig.setDebug(this.f);
            tTAdConfig.setAsyncInit(this.g);
            tTAdConfig.a(this.a.build());
            tTAdConfig.a(this.a);
            return tTAdConfig;
        }
    }
}
