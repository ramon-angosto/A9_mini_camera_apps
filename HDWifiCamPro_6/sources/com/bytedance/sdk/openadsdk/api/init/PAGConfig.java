package com.bytedance.sdk.openadsdk.api.init;

import android.os.Build;
import com.bykv.vk.openvk.component.video.api.b;
import com.bykv.vk.openvk.component.video.api.f.c;
import com.bytedance.sdk.component.f.d.b;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.InitConfig;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.l.y;

public final class PAGConfig implements InitConfig {
    private String a;
    private boolean b;
    private int c;
    private int d = -1;
    private int e = -1;
    private int f = -1;
    private int g = 0;
    private boolean h;
    private boolean i;
    private String j;
    private String k;

    public String getData() {
        return this.k;
    }

    public void setData(String str) {
        this.k = str;
    }

    public String getAppId() {
        return this.a;
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        this.a = str;
    }

    public boolean getDebugLog() {
        return this.b;
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        this.b = z;
    }

    public int getAppIconId() {
        return this.c;
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        this.c = i2;
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        if (i2 < -1 || i2 > 1) {
            i2 = -1;
        }
        this.d = i2;
    }

    public int getCoppa() {
        return this.d;
    }

    /* access modifiers changed from: private */
    public void c(int i2) {
        if (i2 < -1 || i2 > 1) {
            i2 = -1;
        }
        this.e = i2;
    }

    public int getGdpr() {
        return this.e;
    }

    /* access modifiers changed from: private */
    public void d(int i2) {
        if (i2 < -1 || i2 > 1) {
            i2 = -1;
        }
        this.f = i2;
    }

    public int getCcpa() {
        return this.f;
    }

    public int getTitleBarTheme() {
        return this.g;
    }

    /* access modifiers changed from: private */
    public void e(int i2) {
        this.g = i2;
    }

    public boolean isUseTextureView() {
        return this.h;
    }

    /* access modifiers changed from: private */
    public void b(boolean z) {
        this.h = z;
    }

    public boolean isSupportMultiProcess() {
        return this.i;
    }

    /* access modifiers changed from: private */
    public void c(boolean z) {
        this.i = z;
        b.a(z);
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        this.j = str;
    }

    public String getPackageName() {
        return this.j;
    }

    public static void setChildDirected(int i2) {
        y.i("setCoppa");
        if (i2 < -1 || i2 > 1) {
            i2 = -1;
        }
        if (i2 != getChildDirected()) {
            com.bytedance.sdk.openadsdk.a.b.a().setCoppa(i2);
        }
    }

    public static int getChildDirected() {
        y.i("getCoppa");
        return com.bytedance.sdk.openadsdk.a.b.a().getCoppa();
    }

    public static void setGDPRConsent(int i2) {
        y.i("setGdpr");
        int i3 = -1;
        int i4 = 1;
        if (i2 >= -1 && i2 <= 1) {
            i3 = i2;
        }
        if (i3 != getGDPRConsent()) {
            if (i2 == 1) {
                i4 = 0;
            } else if (i2 != 0) {
                i4 = i3;
            }
            com.bytedance.sdk.openadsdk.a.b.a().setGdpr(i4);
        }
    }

    public static int getGDPRConsent() {
        y.i("getGdpr");
        int gdpr = com.bytedance.sdk.openadsdk.a.b.a().getGdpr();
        if (gdpr == 1) {
            return 0;
        }
        if (gdpr == 0) {
            return 1;
        }
        return gdpr;
    }

    public static void setDoNotSell(int i2) {
        y.i("setCCPA");
        if (i2 < -1 || i2 > 1) {
            i2 = -1;
        }
        if (i2 != getDoNotSell()) {
            h.d().f(i2);
        }
    }

    public static int getDoNotSell() {
        y.i("getCCPA");
        return h.d().v();
    }

    public static void debugLog(boolean z) {
        if (com.bytedance.sdk.openadsdk.a.b.a() == null) {
            return;
        }
        if (z) {
            com.bytedance.sdk.openadsdk.a.b.a().debugLog(1);
            com.bytedance.sdk.openadsdk.a.b.a().openDebugMode();
            c.a();
            return;
        }
        com.bytedance.sdk.openadsdk.a.b.a().debugLog(0);
        com.bytedance.sdk.component.f.d.b.a(b.a.OFF);
        l.c();
        c.b();
    }

    public static void setAppIconId(int i2) {
        if (com.bytedance.sdk.openadsdk.a.b.a() != null) {
            com.bytedance.sdk.openadsdk.a.b.a().setIconId(i2);
        }
    }

    public static void setUserData(String str) {
        if (com.bytedance.sdk.openadsdk.a.b.a() != null) {
            com.bytedance.sdk.openadsdk.a.b.a().setData(str);
        }
    }

    public static class Builder {
        private String a;
        private boolean b;
        private int c;
        private int d = -1;
        private int e = -1;
        private int f = -1;
        private int g = 0;
        private boolean h;
        private boolean i;
        private String[] j;
        private String k;
        private String l;

        public Builder() {
            this.h = Build.VERSION.SDK_INT >= 14;
            this.i = false;
        }

        public Builder setUserData(String str) {
            this.l = str;
            return this;
        }

        public Builder appId(String str) {
            this.a = str;
            return this;
        }

        public Builder debugLog(boolean z) {
            this.b = z;
            return this;
        }

        public Builder appIcon(int i2) {
            this.c = i2;
            return this;
        }

        public Builder setChildDirected(int i2) {
            this.d = i2;
            return this;
        }

        public Builder setGDPRConsent(int i2) {
            this.e = i2;
            return this;
        }

        public Builder setDoNotSell(int i2) {
            this.f = i2;
            return this;
        }

        public Builder titleBarTheme(int i2) {
            this.g = i2;
            return this;
        }

        public Builder useTextureView(boolean z) {
            this.h = z;
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.i = z;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            this.j = strArr;
            return this;
        }

        public Builder setPackageName(String str) {
            this.k = str;
            return this;
        }

        public PAGConfig build() {
            PAGConfig pAGConfig = new PAGConfig();
            pAGConfig.a(this.a);
            pAGConfig.b(this.d);
            pAGConfig.a(this.c);
            pAGConfig.e(this.g);
            pAGConfig.b(this.h);
            pAGConfig.c(this.i);
            pAGConfig.c(this.e);
            pAGConfig.d(this.f);
            pAGConfig.a(this.b);
            pAGConfig.b(this.k);
            pAGConfig.setData(this.l);
            return pAGConfig;
        }
    }
}
