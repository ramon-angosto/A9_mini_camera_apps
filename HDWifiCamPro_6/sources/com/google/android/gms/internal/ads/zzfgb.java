package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfgb implements zzfga {
    private final Object[] zza;

    public zzfgb(zzl zzl, String str, int i, String str2, zzw zzw) {
        HashSet hashSet = new HashSet(Arrays.asList(str2.split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        arrayList.add(str);
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(zzl.zzb));
        }
        if (hashSet.contains("extras")) {
            arrayList.add(zza(zzl.zzc));
        } else if (hashSet.contains("npa")) {
            arrayList.add(zzl.zzc.getString("npa"));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(zzl.zzd));
        }
        if (hashSet.contains("keywords")) {
            List list = zzl.zze;
            if (list != null) {
                arrayList.add(list.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(zzl.zzf));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(zzl.zzg));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(zzl.zzh));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(zzl.zzi);
        }
        if (hashSet.contains(RequestParameters.SUBRESOURCE_LOCATION)) {
            Location location = zzl.zzk;
            if (location != null) {
                arrayList.add(location.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(zzl.zzl);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(zza(zzl.zzm));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(zza(zzl.zzn));
        }
        if (hashSet.contains("categoryExclusions")) {
            List list2 = zzl.zzo;
            if (list2 != null) {
                arrayList.add(list2.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(zzl.zzp);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(zzl.zzq);
        }
        if (hashSet.contains("isDesignedForFamilies")) {
            arrayList.add(Boolean.valueOf(zzl.zzr));
        }
        if (hashSet.contains("tagForUnderAgeOfConsent")) {
            arrayList.add(Integer.valueOf(zzl.zzt));
        }
        if (hashSet.contains("maxAdContentRating")) {
            arrayList.add(zzl.zzu);
        }
        if (hashSet.contains("orientation")) {
            if (zzw != null) {
                arrayList.add(Integer.valueOf(zzw.zza));
            } else {
                arrayList.add((Object) null);
            }
        }
        this.zza = arrayList.toArray();
    }

    private static String zza(Bundle bundle) {
        String str;
        if (bundle == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj = bundle.get((String) it.next());
            if (obj == null) {
                str = "null";
            } else if (obj instanceof Bundle) {
                str = zza((Bundle) obj);
            } else {
                str = obj.toString();
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzfgb)) {
            return false;
        }
        return Arrays.equals(this.zza, ((zzfgb) obj).zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        int hashCode = Arrays.hashCode(this.zza);
        String arrays = Arrays.toString(this.zza);
        return "[PoolKey#" + hashCode + " " + arrays + "]";
    }
}
