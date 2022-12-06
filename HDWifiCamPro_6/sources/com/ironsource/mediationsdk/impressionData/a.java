package com.ironsource.mediationsdk.impressionData;

import android.content.Context;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.G;
import com.ironsource.mediationsdk.H;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.g;
import com.ironsource.mediationsdk.server.HttpFunctions;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016J*\u0010\f\u001a\u00020\n2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\u0016\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ironsource/mediationsdk/impressionData/ExternalImpressionDataHandler;", "Lcom/ironsource/mediationsdk/utils/OnMediationInitializationListener;", "()V", "externalArmEventsUrl", "", "isExternalArmEventsEnabled", "", "buildClientParamsForRequest", "Lorg/json/JSONObject;", "onInitFailed", "", "reason", "onInitSuccess", "adUnits", "", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "revived", "configurations", "Lcom/ironsource/mediationsdk/model/Configurations;", "onStillInProgressAfter15Secs", "setAdRevenueData", "dataSource", "impressionData", "mediationsdk_release"}, k = 1, mv = {1, 4, 2})
public final class a implements i {
    private boolean a = true;
    private String b = "https://outcome-arm-ext-med-ext.sonic-us.supersonicads.com/aemData";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/ironsource/mediationsdk/impressionData/ExternalImpressionDataHandler$setAdRevenueData$1", "Lcom/ironsource/mediationsdk/server/HttpFunctionsListener;", "onResponse", "", "requestSucceeded", "", "mediationsdk_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.ironsource.mediationsdk.impressionData.a$a  reason: collision with other inner class name */
    public static final class C0092a implements com.ironsource.mediationsdk.server.a {
        C0092a() {
        }

        public final void a(boolean z) {
            if (!z) {
                IronLog.API.error("failed to send impression data");
            }
        }
    }

    private static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("deviceOS", "android");
        ContextProvider instance = ContextProvider.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "ContextProvider.getInstance()");
        Context applicationContext = instance.getApplicationContext();
        if (applicationContext != null) {
            jSONObject.put("deviceType", IronSourceUtils.getDeviceType(applicationContext));
            G ironSourceAdvId = IronSourceUtils.getIronSourceAdvId(applicationContext);
            if (ironSourceAdvId != null) {
                jSONObject.put("advId", ironSourceAdvId.a);
                jSONObject.put("advIdType", ironSourceAdvId.b);
            }
        }
        H a2 = H.a();
        Intrinsics.checkNotNullExpressionValue(a2, "IronSourceObject.getInstance()");
        String k = a2.k();
        if (k != null) {
            jSONObject.put("applicationKey", k);
        }
        return jSONObject;
    }

    public final void a(String str) {
    }

    public final void a(String str, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "dataSource");
        Intrinsics.checkNotNullParameter(jSONObject, "impressionData");
        if (!this.a) {
            IronLog.INTERNAL.verbose("disabled from server");
            return;
        }
        try {
            JSONObject a2 = a();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("externalMediationSource", str);
            jSONObject2.putOpt("externalMediationData", jSONObject);
            jSONObject2.putOpt("clientParams", a2);
            IronLog ironLog = IronLog.API;
            ironLog.info("impressionData: " + jSONObject2);
            HttpFunctions.sendPostRequest(this.b, jSONObject2.toString(), new C0092a());
        } catch (Exception e) {
            IronLog ironLog2 = IronLog.API;
            ironLog2.error("exception " + e.getMessage() + " sending impression data");
            e.printStackTrace();
        }
    }

    public final void a(List<IronSource.AD_UNIT> list, boolean z, g gVar) {
        if (gVar != null) {
            com.ironsource.sdk.f.a a2 = gVar.a();
            Intrinsics.checkNotNullExpressionValue(a2, "applicationConfigurations");
            this.a = a2.f().a;
            com.ironsource.sdk.f.a a3 = gVar.a();
            Intrinsics.checkNotNullExpressionValue(a3, "applicationConfigurations");
            this.b = a3.f().b;
        }
    }

    public final void f() {
    }
}
