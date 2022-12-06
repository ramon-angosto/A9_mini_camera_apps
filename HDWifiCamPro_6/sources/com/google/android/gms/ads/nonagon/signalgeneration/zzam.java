package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzam {
    public final String zza;
    public String zzb;
    public Bundle zzc = new Bundle();

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzam(android.util.JsonReader r8) throws java.io.IOException {
        /*
            r7 = this;
            r7.<init>()
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            r7.zzc = r0
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r8.beginObject()
            java.lang.String r1 = ""
            r2 = r0
            r0 = r1
        L_0x0016:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L_0x0073
            java.lang.String r3 = r8.nextName()
            if (r3 != 0) goto L_0x0023
            r3 = r1
        L_0x0023:
            int r4 = r3.hashCode()
            r5 = -995427962(0xffffffffc4aaf986, float:-1367.7976)
            r6 = 1
            if (r4 == r5) goto L_0x003d
            r5 = -271442291(0xffffffffefd21e8d, float:-1.3005757E29)
            if (r4 == r5) goto L_0x0033
            goto L_0x0047
        L_0x0033:
            java.lang.String r4 = "signal_dictionary"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0047
            r3 = r6
            goto L_0x0048
        L_0x003d:
            java.lang.String r4 = "params"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0047
            r3 = 0
            goto L_0x0048
        L_0x0047:
            r3 = -1
        L_0x0048:
            if (r3 == 0) goto L_0x006e
            if (r3 == r6) goto L_0x0050
            r8.skipValue()
            goto L_0x0016
        L_0x0050:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r8.beginObject()
        L_0x0058:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L_0x006a
            java.lang.String r3 = r8.nextName()
            java.lang.String r4 = r8.nextString()
            r2.put(r3, r4)
            goto L_0x0058
        L_0x006a:
            r8.endObject()
            goto L_0x0016
        L_0x006e:
            java.lang.String r0 = r8.nextString()
            goto L_0x0016
        L_0x0073:
            r7.zza = r0
            r8.endObject()
            java.util.Set r8 = r2.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x0080:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x00aa
            java.lang.Object r0 = r8.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            if (r1 == 0) goto L_0x0080
            java.lang.Object r1 = r0.getValue()
            if (r1 == 0) goto L_0x0080
            android.os.Bundle r1 = r7.zzc
            java.lang.Object r2 = r0.getKey()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r1.putString(r2, r0)
            goto L_0x0080
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzam.<init>(android.util.JsonReader):void");
    }
}
