package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.tasks.OnCompleteListener;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zacd<T> implements OnCompleteListener<T> {
    private final GoogleApiManager zaa;
    private final int zab;
    private final ApiKey<?> zac;
    private final long zad;
    private final long zae;

    zacd(GoogleApiManager googleApiManager, int i, ApiKey<?> apiKey, long j, long j2, String str, String str2) {
        this.zaa = googleApiManager;
        this.zab = i;
        this.zac = apiKey;
        this.zad = j;
        this.zae = j2;
    }

    static <T> zacd<T> zaa(GoogleApiManager googleApiManager, int i, ApiKey<?> apiKey) {
        boolean z;
        if (!googleApiManager.zaF()) {
            return null;
        }
        RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
        if (config == null) {
            z = true;
        } else if (!config.getMethodInvocationTelemetryEnabled()) {
            return null;
        } else {
            z = config.getMethodTimingTelemetryEnabled();
            zabq zak = googleApiManager.zak(apiKey);
            if (zak != null) {
                if (!(zak.zaf() instanceof BaseGmsClient)) {
                    return null;
                }
                BaseGmsClient baseGmsClient = (BaseGmsClient) zak.zaf();
                if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                    ConnectionTelemetryConfiguration zab2 = zab(zak, baseGmsClient, i);
                    if (zab2 == null) {
                        return null;
                    }
                    zak.zaq();
                    z = zab2.getMethodTimingTelemetryEnabled();
                }
            }
        }
        return new zacd(googleApiManager, i, apiKey, z ? System.currentTimeMillis() : 0, z ? SystemClock.elapsedRealtime() : 0, (String) null, (String) null);
    }

    private static ConnectionTelemetryConfiguration zab(zabq<?> zabq, BaseGmsClient<?> baseGmsClient, int i) {
        int[] methodInvocationMethodKeyAllowlist;
        int[] methodInvocationMethodKeyDisallowlist;
        ConnectionTelemetryConfiguration telemetryConfiguration = baseGmsClient.getTelemetryConfiguration();
        if (telemetryConfiguration == null || !telemetryConfiguration.getMethodInvocationTelemetryEnabled() || ((methodInvocationMethodKeyAllowlist = telemetryConfiguration.getMethodInvocationMethodKeyAllowlist()) != null ? !ArrayUtils.contains(methodInvocationMethodKeyAllowlist, i) : !((methodInvocationMethodKeyDisallowlist = telemetryConfiguration.getMethodInvocationMethodKeyDisallowlist()) == null || !ArrayUtils.contains(methodInvocationMethodKeyDisallowlist, i))) || zabq.zac() >= telemetryConfiguration.getMaxMethodInvocationsLogged()) {
            return null;
        }
        return telemetryConfiguration;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onComplete(com.google.android.gms.tasks.Task<T> r22) {
        /*
            r21 = this;
            r0 = r21
            com.google.android.gms.common.api.internal.GoogleApiManager r1 = r0.zaa
            boolean r1 = r1.zaF()
            if (r1 != 0) goto L_0x000b
            return
        L_0x000b:
            com.google.android.gms.common.internal.RootTelemetryConfigManager r1 = com.google.android.gms.common.internal.RootTelemetryConfigManager.getInstance()
            com.google.android.gms.common.internal.RootTelemetryConfiguration r1 = r1.getConfig()
            if (r1 == 0) goto L_0x001d
            boolean r2 = r1.getMethodInvocationTelemetryEnabled()
            if (r2 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            return
        L_0x001d:
            com.google.android.gms.common.api.internal.GoogleApiManager r2 = r0.zaa
            com.google.android.gms.common.api.internal.ApiKey<?> r3 = r0.zac
            com.google.android.gms.common.api.internal.zabq r2 = r2.zak(r3)
            if (r2 == 0) goto L_0x00f7
            com.google.android.gms.common.api.Api$Client r3 = r2.zaf()
            boolean r3 = r3 instanceof com.google.android.gms.common.internal.BaseGmsClient
            if (r3 != 0) goto L_0x0031
            goto L_0x00f7
        L_0x0031:
            com.google.android.gms.common.api.Api$Client r3 = r2.zaf()
            com.google.android.gms.common.internal.BaseGmsClient r3 = (com.google.android.gms.common.internal.BaseGmsClient) r3
            long r4 = r0.zad
            r6 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            r5 = 1
            r8 = 0
            if (r4 <= 0) goto L_0x0043
            r4 = r5
            goto L_0x0044
        L_0x0043:
            r4 = r8
        L_0x0044:
            int r19 = r3.getGCoreServiceId()
            r9 = 100
            if (r1 == 0) goto L_0x008b
            boolean r10 = r1.getMethodTimingTelemetryEnabled()
            r4 = r4 & r10
            int r10 = r1.getBatchPeriodMillis()
            int r11 = r1.getMaxMethodInvocationsInBatch()
            int r1 = r1.getVersion()
            boolean r12 = r3.hasConnectionInfo()
            if (r12 == 0) goto L_0x0087
            boolean r12 = r3.isConnecting()
            if (r12 != 0) goto L_0x0087
            int r4 = r0.zab
            com.google.android.gms.common.internal.ConnectionTelemetryConfiguration r2 = zab(r2, r3, r4)
            if (r2 != 0) goto L_0x0072
            return
        L_0x0072:
            boolean r3 = r2.getMethodTimingTelemetryEnabled()
            if (r3 == 0) goto L_0x0080
            long r3 = r0.zad
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x0080
            r4 = r5
            goto L_0x0081
        L_0x0080:
            r4 = r8
        L_0x0081:
            int r2 = r2.getMaxMethodInvocationsLogged()
            r3 = r1
            goto L_0x008f
        L_0x0087:
            r3 = r1
            r1 = r10
            r2 = r11
            goto L_0x0090
        L_0x008b:
            r10 = 5000(0x1388, float:7.006E-42)
            r3 = r8
            r2 = r9
        L_0x008f:
            r1 = r10
        L_0x0090:
            com.google.android.gms.common.api.internal.GoogleApiManager r5 = r0.zaa
            boolean r10 = r22.isSuccessful()
            r11 = -1
            if (r10 == 0) goto L_0x009b
            r12 = r8
            goto L_0x00c8
        L_0x009b:
            boolean r8 = r22.isCanceled()
            if (r8 == 0) goto L_0x00a4
            r8 = r9
        L_0x00a2:
            r12 = r11
            goto L_0x00c8
        L_0x00a4:
            java.lang.Exception r8 = r22.getException()
            boolean r9 = r8 instanceof com.google.android.gms.common.api.ApiException
            if (r9 == 0) goto L_0x00c5
            com.google.android.gms.common.api.ApiException r8 = (com.google.android.gms.common.api.ApiException) r8
            com.google.android.gms.common.api.Status r8 = r8.getStatus()
            int r9 = r8.getStatusCode()
            com.google.android.gms.common.ConnectionResult r8 = r8.getConnectionResult()
            if (r8 != 0) goto L_0x00be
            r8 = r11
            goto L_0x00c2
        L_0x00be:
            int r8 = r8.getErrorCode()
        L_0x00c2:
            r12 = r8
            r8 = r9
            goto L_0x00c8
        L_0x00c5:
            r8 = 101(0x65, float:1.42E-43)
            goto L_0x00a2
        L_0x00c8:
            if (r4 == 0) goto L_0x00de
            long r6 = r0.zad
            long r9 = java.lang.System.currentTimeMillis()
            long r13 = android.os.SystemClock.elapsedRealtime()
            r15 = r6
            long r6 = r0.zae
            long r13 = r13 - r6
            int r4 = (int) r13
            r20 = r4
            r13 = r15
            r15 = r9
            goto L_0x00e2
        L_0x00de:
            r13 = r6
            r15 = r13
            r20 = r11
        L_0x00e2:
            com.google.android.gms.common.internal.MethodInvocation r4 = new com.google.android.gms.common.internal.MethodInvocation
            int r10 = r0.zab
            r17 = 0
            r18 = 0
            r9 = r4
            r11 = r8
            r9.<init>(r10, r11, r12, r13, r15, r17, r18, r19, r20)
            long r13 = (long) r1
            r10 = r5
            r11 = r4
            r12 = r3
            r15 = r2
            r10.zay(r11, r12, r13, r15)
        L_0x00f7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zacd.onComplete(com.google.android.gms.tasks.Task):void");
    }
}
