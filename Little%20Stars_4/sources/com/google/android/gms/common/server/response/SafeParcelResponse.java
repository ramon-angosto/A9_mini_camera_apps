package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.zzc;
import com.google.android.gms.common.util.zzp;
import com.google.android.gms.common.util.zzq;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final zze CREATOR = new zze();
    private final String mClassName;
    private final int mVersionCode;
    private final FieldMappingDictionary zzasR;
    private final Parcel zzasY;
    private final int zzasZ = 2;
    private int zzata;
    private int zzatb;

    SafeParcelResponse(int i, Parcel parcel, FieldMappingDictionary fieldMappingDictionary) {
        this.mVersionCode = i;
        this.zzasY = (Parcel) zzaa.zzz(parcel);
        this.zzasR = fieldMappingDictionary;
        FieldMappingDictionary fieldMappingDictionary2 = this.zzasR;
        this.mClassName = fieldMappingDictionary2 == null ? null : fieldMappingDictionary2.zzut();
        this.zzata = 2;
    }

    private static HashMap<Integer, Map.Entry<String, FastJsonResponse.Field<?, ?>>> zzU(Map<String, FastJsonResponse.Field<?, ?>> map) {
        HashMap<Integer, Map.Entry<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        for (Map.Entry next : map.entrySet()) {
            hashMap.put(Integer.valueOf(((FastJsonResponse.Field) next.getValue()).zzul()), next);
        }
        return hashMap;
    }

    private void zza(StringBuilder sb, int i, Object obj) {
        String str;
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                str = zzp.zzdu(obj.toString());
                break;
            case 8:
                sb.append("\"");
                str = zzc.zzk((byte[]) obj);
                break;
            case 9:
                sb.append("\"");
                str = zzc.zzl((byte[]) obj);
                break;
            case 10:
                zzq.zza(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("Unknown type = ");
                sb2.append(i);
                throw new IllegalArgumentException(sb2.toString());
        }
        sb.append(str);
        sb.append("\"");
    }

    private void zza(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Parcel parcel, int i) {
        Object obj;
        switch (field.zzue()) {
            case 0:
                obj = Integer.valueOf(zza.zzg(parcel, i));
                break;
            case 1:
                obj = zza.zzk(parcel, i);
                break;
            case 2:
                obj = Long.valueOf(zza.zzi(parcel, i));
                break;
            case 3:
                obj = Float.valueOf(zza.zzl(parcel, i));
                break;
            case 4:
                obj = Double.valueOf(zza.zzn(parcel, i));
                break;
            case 5:
                obj = zza.zzp(parcel, i);
                break;
            case 6:
                obj = Boolean.valueOf(zza.zzc(parcel, i));
                break;
            case 7:
                obj = zza.zzq(parcel, i);
                break;
            case 8:
            case 9:
                obj = zza.zzt(parcel, i);
                break;
            case 10:
                obj = zzn(zza.zzs(parcel, i));
                break;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                int zzue = field.zzue();
                StringBuilder sb2 = new StringBuilder(36);
                sb2.append("Unknown field out type = ");
                sb2.append(zzue);
                throw new IllegalArgumentException(sb2.toString());
        }
        zzb(sb, field, (Object) zza(field, obj));
    }

    private void zza(StringBuilder sb, String str, FastJsonResponse.Field<?, ?> field, Parcel parcel, int i) {
        sb.append("\"");
        sb.append(str);
        sb.append("\":");
        if (field.zzuo()) {
            zza(sb, field, parcel, i);
        } else {
            zzb(sb, field, parcel, i);
        }
    }

    private void zza(StringBuilder sb, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        HashMap<Integer, Map.Entry<String, FastJsonResponse.Field<?, ?>>> zzU = zzU(map);
        sb.append('{');
        int zzaq = zza.zzaq(parcel);
        boolean z = false;
        while (parcel.dataPosition() < zzaq) {
            int zzap = zza.zzap(parcel);
            Map.Entry entry = zzU.get(Integer.valueOf(zza.zzcj(zzap)));
            if (entry != null) {
                if (z) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                zza(sb, (String) entry.getKey(), (FastJsonResponse.Field) entry.getValue(), parcel, zzap);
                z = true;
            }
        }
        if (parcel.dataPosition() == zzaq) {
            sb.append('}');
            return;
        }
        StringBuilder sb2 = new StringBuilder(37);
        sb2.append("Overread allowed size end=");
        sb2.append(zzaq);
        throw new zza.C0002zza(sb2.toString(), parcel);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0117, code lost:
        r6.append(r7);
        r6.append("\"");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0147, code lost:
        r6.append(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzb(java.lang.StringBuilder r6, com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?> r7, android.os.Parcel r8, int r9) {
        /*
            r5 = this;
            boolean r0 = r7.zzuj()
            java.lang.String r1 = ","
            r2 = 0
            if (r0 == 0) goto L_0x0089
            java.lang.String r0 = "["
            r6.append(r0)
            int r0 = r7.zzue()
            switch(r0) {
                case 0: goto L_0x007b;
                case 1: goto L_0x0073;
                case 2: goto L_0x006b;
                case 3: goto L_0x0063;
                case 4: goto L_0x005b;
                case 5: goto L_0x0053;
                case 6: goto L_0x004b;
                case 7: goto L_0x0043;
                case 8: goto L_0x003b;
                case 9: goto L_0x003b;
                case 10: goto L_0x003b;
                case 11: goto L_0x001d;
                default: goto L_0x0015;
            }
        L_0x0015:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Unknown field type out."
            r6.<init>(r7)
            throw r6
        L_0x001d:
            android.os.Parcel[] r8 = com.google.android.gms.common.internal.safeparcel.zza.zzG(r8, r9)
            int r9 = r8.length
            r0 = 0
        L_0x0023:
            if (r0 >= r9) goto L_0x0082
            if (r0 <= 0) goto L_0x002a
            r6.append(r1)
        L_0x002a:
            r3 = r8[r0]
            r3.setDataPosition(r2)
            java.util.Map r3 = r7.zzuq()
            r4 = r8[r0]
            r5.zza((java.lang.StringBuilder) r6, (java.util.Map<java.lang.String, com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>>) r3, (android.os.Parcel) r4)
            int r0 = r0 + 1
            goto L_0x0023
        L_0x003b:
            java.lang.UnsupportedOperationException r6 = new java.lang.UnsupportedOperationException
            java.lang.String r7 = "List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported"
            r6.<init>(r7)
            throw r6
        L_0x0043:
            java.lang.String[] r7 = com.google.android.gms.common.internal.safeparcel.zza.zzC(r8, r9)
            com.google.android.gms.common.util.zzb.zza((java.lang.StringBuilder) r6, (java.lang.String[]) r7)
            goto L_0x0082
        L_0x004b:
            boolean[] r7 = com.google.android.gms.common.internal.safeparcel.zza.zzv(r8, r9)
            com.google.android.gms.common.util.zzb.zza((java.lang.StringBuilder) r6, (boolean[]) r7)
            goto L_0x0082
        L_0x0053:
            java.math.BigDecimal[] r7 = com.google.android.gms.common.internal.safeparcel.zza.zzB(r8, r9)
            com.google.android.gms.common.util.zzb.zza((java.lang.StringBuilder) r6, (T[]) r7)
            goto L_0x0082
        L_0x005b:
            double[] r7 = com.google.android.gms.common.internal.safeparcel.zza.zzA(r8, r9)
            com.google.android.gms.common.util.zzb.zza((java.lang.StringBuilder) r6, (double[]) r7)
            goto L_0x0082
        L_0x0063:
            float[] r7 = com.google.android.gms.common.internal.safeparcel.zza.zzz(r8, r9)
            com.google.android.gms.common.util.zzb.zza((java.lang.StringBuilder) r6, (float[]) r7)
            goto L_0x0082
        L_0x006b:
            long[] r7 = com.google.android.gms.common.internal.safeparcel.zza.zzx(r8, r9)
            com.google.android.gms.common.util.zzb.zza((java.lang.StringBuilder) r6, (long[]) r7)
            goto L_0x0082
        L_0x0073:
            java.math.BigInteger[] r7 = com.google.android.gms.common.internal.safeparcel.zza.zzy(r8, r9)
            com.google.android.gms.common.util.zzb.zza((java.lang.StringBuilder) r6, (T[]) r7)
            goto L_0x0082
        L_0x007b:
            int[] r7 = com.google.android.gms.common.internal.safeparcel.zza.zzw(r8, r9)
            com.google.android.gms.common.util.zzb.zza((java.lang.StringBuilder) r6, (int[]) r7)
        L_0x0082:
            java.lang.String r7 = "]"
        L_0x0084:
            r6.append(r7)
            goto L_0x0152
        L_0x0089:
            int r0 = r7.zzue()
            java.lang.String r3 = "\""
            switch(r0) {
                case 0: goto L_0x014b;
                case 1: goto L_0x0143;
                case 2: goto L_0x013b;
                case 3: goto L_0x0133;
                case 4: goto L_0x012b;
                case 5: goto L_0x0126;
                case 6: goto L_0x011e;
                case 7: goto L_0x010c;
                case 8: goto L_0x0100;
                case 9: goto L_0x00f4;
                case 10: goto L_0x00aa;
                case 11: goto L_0x009a;
                default: goto L_0x0092;
            }
        L_0x0092:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Unknown field type out"
            r6.<init>(r7)
            throw r6
        L_0x009a:
            android.os.Parcel r8 = com.google.android.gms.common.internal.safeparcel.zza.zzF(r8, r9)
            r8.setDataPosition(r2)
            java.util.Map r7 = r7.zzuq()
            r5.zza((java.lang.StringBuilder) r6, (java.util.Map<java.lang.String, com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>>) r7, (android.os.Parcel) r8)
            goto L_0x0152
        L_0x00aa:
            android.os.Bundle r7 = com.google.android.gms.common.internal.safeparcel.zza.zzs(r8, r9)
            java.util.Set r8 = r7.keySet()
            r8.size()
            java.lang.String r9 = "{"
            r6.append(r9)
            java.util.Iterator r8 = r8.iterator()
            r9 = 1
        L_0x00bf:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x00f1
            java.lang.Object r0 = r8.next()
            java.lang.String r0 = (java.lang.String) r0
            if (r9 != 0) goto L_0x00d0
            r6.append(r1)
        L_0x00d0:
            r6.append(r3)
            r6.append(r0)
            r6.append(r3)
            java.lang.String r9 = ":"
            r6.append(r9)
            r6.append(r3)
            java.lang.String r9 = r7.getString(r0)
            java.lang.String r9 = com.google.android.gms.common.util.zzp.zzdu(r9)
            r6.append(r9)
            r6.append(r3)
            r9 = 0
            goto L_0x00bf
        L_0x00f1:
            java.lang.String r7 = "}"
            goto L_0x0084
        L_0x00f4:
            byte[] r7 = com.google.android.gms.common.internal.safeparcel.zza.zzt(r8, r9)
            r6.append(r3)
            java.lang.String r7 = com.google.android.gms.common.util.zzc.zzl(r7)
            goto L_0x0117
        L_0x0100:
            byte[] r7 = com.google.android.gms.common.internal.safeparcel.zza.zzt(r8, r9)
            r6.append(r3)
            java.lang.String r7 = com.google.android.gms.common.util.zzc.zzk(r7)
            goto L_0x0117
        L_0x010c:
            java.lang.String r7 = com.google.android.gms.common.internal.safeparcel.zza.zzq(r8, r9)
            r6.append(r3)
            java.lang.String r7 = com.google.android.gms.common.util.zzp.zzdu(r7)
        L_0x0117:
            r6.append(r7)
            r6.append(r3)
            goto L_0x0152
        L_0x011e:
            boolean r7 = com.google.android.gms.common.internal.safeparcel.zza.zzc(r8, r9)
            r6.append(r7)
            goto L_0x0152
        L_0x0126:
            java.math.BigDecimal r7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(r8, r9)
            goto L_0x0147
        L_0x012b:
            double r7 = com.google.android.gms.common.internal.safeparcel.zza.zzn(r8, r9)
            r6.append(r7)
            goto L_0x0152
        L_0x0133:
            float r7 = com.google.android.gms.common.internal.safeparcel.zza.zzl(r8, r9)
            r6.append(r7)
            goto L_0x0152
        L_0x013b:
            long r7 = com.google.android.gms.common.internal.safeparcel.zza.zzi(r8, r9)
            r6.append(r7)
            goto L_0x0152
        L_0x0143:
            java.math.BigInteger r7 = com.google.android.gms.common.internal.safeparcel.zza.zzk(r8, r9)
        L_0x0147:
            r6.append(r7)
            goto L_0x0152
        L_0x014b:
            int r7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(r8, r9)
            r6.append(r7)
        L_0x0152:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.SafeParcelResponse.zzb(java.lang.StringBuilder, com.google.android.gms.common.server.response.FastJsonResponse$Field, android.os.Parcel, int):void");
    }

    private void zzb(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (field.zzui()) {
            zzb(sb, field, (ArrayList<?>) (ArrayList) obj);
        } else {
            zza(sb, field.zzud(), obj);
        }
    }

    private void zzb(StringBuilder sb, FastJsonResponse.Field<?, ?> field, ArrayList<?> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            zza(sb, field.zzud(), (Object) arrayList.get(i));
        }
        sb.append("]");
    }

    public static HashMap<String, String> zzn(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        zzaa.zzb(this.zzasR, (Object) "Cannot convert to JSON on client side.");
        Parcel zzuv = zzuv();
        zzuv.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        zza(sb, this.zzasR.zzdq(this.mClassName), zzuv);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze zze = CREATOR;
        zze.zza(this, parcel, i);
    }

    public Object zzdm(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public boolean zzdn(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public Map<String, FastJsonResponse.Field<?, ?>> zzuf() {
        FieldMappingDictionary fieldMappingDictionary = this.zzasR;
        if (fieldMappingDictionary == null) {
            return null;
        }
        return fieldMappingDictionary.zzdq(this.mClassName);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        if (r0 != 1) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.os.Parcel zzuv() {
        /*
            r3 = this;
            int r0 = r3.zzata
            r1 = 2
            if (r0 == 0) goto L_0x0009
            r2 = 1
            if (r0 == r2) goto L_0x0011
            goto L_0x001a
        L_0x0009:
            android.os.Parcel r0 = r3.zzasY
            int r0 = com.google.android.gms.common.internal.safeparcel.zzb.zzar(r0)
            r3.zzatb = r0
        L_0x0011:
            android.os.Parcel r0 = r3.zzasY
            int r2 = r3.zzatb
            com.google.android.gms.common.internal.safeparcel.zzb.zzJ(r0, r2)
            r3.zzata = r1
        L_0x001a:
            android.os.Parcel r0 = r3.zzasY
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.SafeParcelResponse.zzuv():android.os.Parcel");
    }

    /* access modifiers changed from: package-private */
    public FieldMappingDictionary zzuw() {
        int i = this.zzasZ;
        if (i == 0) {
            return null;
        }
        if (i == 1) {
            return this.zzasR;
        }
        if (i == 2) {
            return this.zzasR;
        }
        StringBuilder sb = new StringBuilder(34);
        sb.append("Invalid creation type: ");
        sb.append(i);
        throw new IllegalStateException(sb.toString());
    }
}
