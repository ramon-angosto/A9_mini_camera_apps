package com.mbridge.msdk.out;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.mbridge.msdk.advanced.c.c;
import com.mbridge.msdk.foundation.tools.u;
import org.json.JSONObject;

public class MBNativeAdvancedHandler {
    private c nativeAdvancedProvider;

    public MBNativeAdvancedHandler(Activity activity, String str, String str2) {
        String d = u.d(str2);
        if (!TextUtils.isEmpty(d)) {
            u.a(str2, d);
        }
        this.nativeAdvancedProvider = new c(str, str2, activity);
    }

    /* renamed from: com.mbridge.msdk.out.MBNativeAdvancedHandler$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$mbridge$msdk$out$MBMultiStateEnum = new int[MBMultiStateEnum.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.mbridge.msdk.out.MBMultiStateEnum[] r0 = com.mbridge.msdk.out.MBMultiStateEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$mbridge$msdk$out$MBMultiStateEnum = r0
                int[] r0 = $SwitchMap$com$mbridge$msdk$out$MBMultiStateEnum     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.mbridge.msdk.out.MBMultiStateEnum r1 = com.mbridge.msdk.out.MBMultiStateEnum.negative     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$mbridge$msdk$out$MBMultiStateEnum     // Catch:{ NoSuchFieldError -> 0x001f }
                com.mbridge.msdk.out.MBMultiStateEnum r1 = com.mbridge.msdk.out.MBMultiStateEnum.positive     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$mbridge$msdk$out$MBMultiStateEnum     // Catch:{ NoSuchFieldError -> 0x002a }
                com.mbridge.msdk.out.MBMultiStateEnum r1 = com.mbridge.msdk.out.MBMultiStateEnum.undefined     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.out.MBNativeAdvancedHandler.AnonymousClass1.<clinit>():void");
        }
    }

    public void setCloseButtonState(MBMultiStateEnum mBMultiStateEnum) {
        int i = AnonymousClass1.$SwitchMap$com$mbridge$msdk$out$MBMultiStateEnum[mBMultiStateEnum.ordinal()];
        int i2 = 1;
        if (i == 1) {
            i2 = 0;
        } else if (i != 2) {
            i2 = -1;
        }
        this.nativeAdvancedProvider.a(i2);
    }

    public void setNativeViewSize(int i, int i2) {
        this.nativeAdvancedProvider.a(i2, i);
    }

    public void setViewElementStyle(JSONObject jSONObject) {
        c cVar = this.nativeAdvancedProvider;
        if (cVar != null) {
            cVar.a(jSONObject);
        }
    }

    public void setAdListener(NativeAdvancedAdListener nativeAdvancedAdListener) {
        c cVar = this.nativeAdvancedProvider;
        if (cVar != null) {
            cVar.a(nativeAdvancedAdListener);
        }
    }

    public String getRequestId() {
        c cVar = this.nativeAdvancedProvider;
        return cVar != null ? cVar.d() : "";
    }

    public void load() {
        c cVar = this.nativeAdvancedProvider;
        if (cVar != null) {
            cVar.b("");
        }
    }

    public void loadByToken(String str) {
        c cVar = this.nativeAdvancedProvider;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public boolean isReady() {
        return isReady("");
    }

    public boolean isReady(String str) {
        c cVar = this.nativeAdvancedProvider;
        if (cVar != null) {
            return cVar.c(str);
        }
        return false;
    }

    public void autoLoopPlay(int i) {
        c cVar = this.nativeAdvancedProvider;
        if (cVar != null) {
            cVar.c(i);
        }
    }

    public void setPlayMuteState(int i) {
        c cVar = this.nativeAdvancedProvider;
        if (cVar != null) {
            cVar.b(i);
        }
    }

    public void onResume() {
        c cVar = this.nativeAdvancedProvider;
        if (cVar != null) {
            cVar.d(3);
        }
    }

    public void onPause() {
        c cVar = this.nativeAdvancedProvider;
        if (cVar != null) {
            cVar.e(3);
        }
    }

    public void release() {
        c cVar = this.nativeAdvancedProvider;
        if (cVar != null) {
            cVar.e();
        }
    }

    public ViewGroup getAdViewGroup() {
        c cVar = this.nativeAdvancedProvider;
        if (cVar != null) {
            return cVar.b();
        }
        return null;
    }
}
