package com.google.android.gms.internal.consent_sdk;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final class zzbw {
    public String zza;
    public String zzb;
    public String zzc;
    public List<String> zzd = Collections.emptyList();
    public List<zzbv> zze = Collections.emptyList();
    public int zzf = 1;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01b1, code lost:
        if (r1.equals("CONSENT_SIGNAL_UNKNOWN") != false) goto L_0x01c9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0120  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.consent_sdk.zzbw zza(android.util.JsonReader r12) throws java.io.IOException {
        /*
            com.google.android.gms.internal.consent_sdk.zzbw r0 = new com.google.android.gms.internal.consent_sdk.zzbw
            r0.<init>()
            r12.beginObject()
        L_0x0008:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L_0x01fa
            java.lang.String r1 = r12.nextName()
            int r2 = r1.hashCode()
            r3 = 0
            r4 = 5
            r5 = 4
            r6 = -1
            r7 = 3
            r8 = 2
            r9 = 1
            switch(r2) {
                case -2001388947: goto L_0x0053;
                case -1938755376: goto L_0x0049;
                case -1851537225: goto L_0x003f;
                case -1161803523: goto L_0x0035;
                case -986806987: goto L_0x002b;
                case -790907624: goto L_0x0021;
                default: goto L_0x0020;
            }
        L_0x0020:
            goto L_0x005d
        L_0x0021:
            java.lang.String r2 = "consent_form_payload"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x005d
            r1 = r9
            goto L_0x005e
        L_0x002b:
            java.lang.String r2 = "request_info_keys"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x005d
            r1 = r5
            goto L_0x005e
        L_0x0035:
            java.lang.String r2 = "actions"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x005d
            r1 = r4
            goto L_0x005e
        L_0x003f:
            java.lang.String r2 = "consent_form_base_url"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x005d
            r1 = r8
            goto L_0x005e
        L_0x0049:
            java.lang.String r2 = "error_message"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x005d
            r1 = r7
            goto L_0x005e
        L_0x0053:
            java.lang.String r2 = "consent_signal"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x005d
            r1 = r3
            goto L_0x005e
        L_0x005d:
            r1 = r6
        L_0x005e:
            if (r1 == 0) goto L_0x016b
            if (r1 == r9) goto L_0x0163
            if (r1 == r8) goto L_0x015b
            if (r1 == r7) goto L_0x0153
            if (r1 == r5) goto L_0x0134
            if (r1 == r4) goto L_0x006e
            r12.skipValue()
            goto L_0x0008
        L_0x006e:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r0.zze = r1
            r12.beginArray()
        L_0x0078:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L_0x012f
            com.google.android.gms.internal.consent_sdk.zzbv r1 = new com.google.android.gms.internal.consent_sdk.zzbv
            r1.<init>()
            r12.beginObject()
        L_0x0086:
            boolean r2 = r12.hasNext()
            if (r2 == 0) goto L_0x0125
            java.lang.String r2 = r12.nextName()
            int r4 = r2.hashCode()
            r5 = -2105551094(0xffffffff827fd70a, float:-1.8796154E-37)
            if (r4 == r5) goto L_0x00a9
            r5 = 1583758243(0x5e663ba3, float:4.14750822E18)
            if (r4 == r5) goto L_0x009f
            goto L_0x00b3
        L_0x009f:
            java.lang.String r4 = "action_type"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x00b3
            r2 = r3
            goto L_0x00b4
        L_0x00a9:
            java.lang.String r4 = "args_json"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x00b3
            r2 = r9
            goto L_0x00b4
        L_0x00b3:
            r2 = r6
        L_0x00b4:
            if (r2 == 0) goto L_0x00c3
            if (r2 == r9) goto L_0x00bc
            r12.skipValue()
            goto L_0x0086
        L_0x00bc:
            java.lang.String r2 = r12.nextString()
            r1.zza = r2
            goto L_0x0086
        L_0x00c3:
            java.lang.String r2 = r12.nextString()
            int r4 = r2.hashCode()
            r5 = 64208429(0x3d3be2d, float:1.2445128E-36)
            if (r4 == r5) goto L_0x00ef
            r5 = 82862015(0x4f05fbf, float:5.6511658E-36)
            if (r4 == r5) goto L_0x00e5
            r5 = 1856333582(0x6ea5670e, float:2.5594806E28)
            if (r4 == r5) goto L_0x00db
            goto L_0x00f9
        L_0x00db:
            java.lang.String r4 = "UNKNOWN_ACTION_TYPE"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x00f9
            r4 = r3
            goto L_0x00fa
        L_0x00e5:
            java.lang.String r4 = "WRITE"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x00f9
            r4 = r9
            goto L_0x00fa
        L_0x00ef:
            java.lang.String r4 = "CLEAR"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x00f9
            r4 = r8
            goto L_0x00fa
        L_0x00f9:
            r4 = r6
        L_0x00fa:
            if (r4 == 0) goto L_0x0120
            if (r4 == r9) goto L_0x011e
            if (r4 == r8) goto L_0x011c
            java.io.IOException r12 = new java.io.IOException
            java.lang.String r0 = java.lang.String.valueOf(r2)
            java.lang.String r1 = "Failed to parse contentads.contributor.direct.serving.gdpr.appapi.ApplicationGdprResponse.Action.ActionTypefrom: "
            int r2 = r0.length()
            if (r2 == 0) goto L_0x0113
            java.lang.String r0 = r1.concat(r0)
            goto L_0x0118
        L_0x0113:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r1)
        L_0x0118:
            r12.<init>(r0)
            throw r12
        L_0x011c:
            r2 = r7
            goto L_0x0121
        L_0x011e:
            r2 = r8
            goto L_0x0121
        L_0x0120:
            r2 = r9
        L_0x0121:
            r1.zzb = r2
            goto L_0x0086
        L_0x0125:
            r12.endObject()
            java.util.List<com.google.android.gms.internal.consent_sdk.zzbv> r2 = r0.zze
            r2.add(r1)
            goto L_0x0078
        L_0x012f:
            r12.endArray()
            goto L_0x0008
        L_0x0134:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r0.zzd = r1
            r12.beginArray()
        L_0x013e:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L_0x014e
            java.lang.String r1 = r12.nextString()
            java.util.List<java.lang.String> r2 = r0.zzd
            r2.add(r1)
            goto L_0x013e
        L_0x014e:
            r12.endArray()
            goto L_0x0008
        L_0x0153:
            java.lang.String r1 = r12.nextString()
            r0.zzc = r1
            goto L_0x0008
        L_0x015b:
            java.lang.String r1 = r12.nextString()
            r0.zzb = r1
            goto L_0x0008
        L_0x0163:
            java.lang.String r1 = r12.nextString()
            r0.zza = r1
            goto L_0x0008
        L_0x016b:
            java.lang.String r1 = r12.nextString()
            int r2 = r1.hashCode()
            r10 = 7
            r11 = 6
            switch(r2) {
                case -2058725357: goto L_0x01be;
                case -1969035850: goto L_0x01b4;
                case -1263695752: goto L_0x01ab;
                case -954325659: goto L_0x01a1;
                case -918677260: goto L_0x0197;
                case 429411856: goto L_0x018d;
                case 467888915: goto L_0x0183;
                case 1725474845: goto L_0x0179;
                default: goto L_0x0178;
            }
        L_0x0178:
            goto L_0x01c8
        L_0x0179:
            java.lang.String r2 = "CONSENT_SIGNAL_NOT_REQUIRED"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x01c8
            r3 = r4
            goto L_0x01c9
        L_0x0183:
            java.lang.String r2 = "CONSENT_SIGNAL_PERSONALIZED_ADS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x01c8
            r3 = r9
            goto L_0x01c9
        L_0x018d:
            java.lang.String r2 = "CONSENT_SIGNAL_SUFFICIENT"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x01c8
            r3 = r7
            goto L_0x01c9
        L_0x0197:
            java.lang.String r2 = "CONSENT_SIGNAL_PUBLISHER_MISCONFIGURATION"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x01c8
            r3 = r10
            goto L_0x01c9
        L_0x01a1:
            java.lang.String r2 = "CONSENT_SIGNAL_NON_PERSONALIZED_ADS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x01c8
            r3 = r8
            goto L_0x01c9
        L_0x01ab:
            java.lang.String r2 = "CONSENT_SIGNAL_UNKNOWN"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x01c8
            goto L_0x01c9
        L_0x01b4:
            java.lang.String r2 = "CONSENT_SIGNAL_ERROR"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x01c8
            r3 = r11
            goto L_0x01c9
        L_0x01be:
            java.lang.String r2 = "CONSENT_SIGNAL_COLLECT_CONSENT"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x01c8
            r3 = r5
            goto L_0x01c9
        L_0x01c8:
            r3 = r6
        L_0x01c9:
            switch(r3) {
                case 0: goto L_0x01ec;
                case 1: goto L_0x01ea;
                case 2: goto L_0x01e8;
                case 3: goto L_0x01e6;
                case 4: goto L_0x01ed;
                case 5: goto L_0x01e4;
                case 6: goto L_0x01e2;
                case 7: goto L_0x01df;
                default: goto L_0x01cc;
            }
        L_0x01cc:
            java.io.IOException r12 = new java.io.IOException
            java.lang.String r0 = java.lang.String.valueOf(r1)
            java.lang.String r1 = "Failed to parse contentads.contributor.direct.serving.gdpr.appapi.ApplicationGdprResponse.ConsentSignalfrom: "
            int r2 = r0.length()
            if (r2 == 0) goto L_0x01f1
            java.lang.String r0 = r1.concat(r0)
            goto L_0x01f6
        L_0x01df:
            r4 = 8
            goto L_0x01ed
        L_0x01e2:
            r4 = r10
            goto L_0x01ed
        L_0x01e4:
            r4 = r11
            goto L_0x01ed
        L_0x01e6:
            r4 = r5
            goto L_0x01ed
        L_0x01e8:
            r4 = r7
            goto L_0x01ed
        L_0x01ea:
            r4 = r8
            goto L_0x01ed
        L_0x01ec:
            r4 = r9
        L_0x01ed:
            r0.zzf = r4
            goto L_0x0008
        L_0x01f1:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r1)
        L_0x01f6:
            r12.<init>(r0)
            throw r12
        L_0x01fa:
            r12.endObject()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.consent_sdk.zzbw.zza(android.util.JsonReader):com.google.android.gms.internal.consent_sdk.zzbw");
    }
}
