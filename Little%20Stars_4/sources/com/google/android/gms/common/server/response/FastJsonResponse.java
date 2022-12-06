package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.util.zzc;
import com.google.android.gms.common.util.zzp;
import com.google.android.gms.common.util.zzq;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class FastJsonResponse {

    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final zza CREATOR = new zza();
        private final int mVersionCode;
        protected final int zzasJ;
        protected final boolean zzasK;
        protected final int zzasL;
        protected final boolean zzasM;
        protected final String zzasN;
        protected final int zzasO;
        protected final Class<? extends FastJsonResponse> zzasP;
        protected final String zzasQ;
        private FieldMappingDictionary zzasR;
        /* access modifiers changed from: private */
        public zza<I, O> zzasS;

        Field(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, ConverterWrapper converterWrapper) {
            this.mVersionCode = i;
            this.zzasJ = i2;
            this.zzasK = z;
            this.zzasL = i3;
            this.zzasM = z2;
            this.zzasN = str;
            this.zzasO = i4;
            zza<?, ?> zza = null;
            if (str2 == null) {
                this.zzasP = null;
                this.zzasQ = null;
            } else {
                this.zzasP = SafeParcelResponse.class;
                this.zzasQ = str2;
            }
            this.zzasS = converterWrapper != null ? converterWrapper.zzub() : zza;
        }

        protected Field(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends FastJsonResponse> cls, zza<I, O> zza) {
            this.mVersionCode = 1;
            this.zzasJ = i;
            this.zzasK = z;
            this.zzasL = i2;
            this.zzasM = z2;
            this.zzasN = str;
            this.zzasO = i3;
            this.zzasP = cls;
            this.zzasQ = cls == null ? null : cls.getCanonicalName();
            this.zzasS = zza;
        }

        public static Field zza(String str, int i, zza<?, ?> zza, boolean z) {
            return new Field(zza.zzud(), z, zza.zzue(), false, str, i, (Class<? extends FastJsonResponse>) null, zza);
        }

        public static <T extends FastJsonResponse> Field<T, T> zza(String str, int i, Class<T> cls) {
            return new Field(11, false, 11, false, str, i, cls, (zza) null);
        }

        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> zzb(String str, int i, Class<T> cls) {
            return new Field(11, true, 11, true, str, i, cls, (zza) null);
        }

        public static Field<Integer, Integer> zzi(String str, int i) {
            return new Field(0, false, 0, false, str, i, (Class<? extends FastJsonResponse>) null, (zza) null);
        }

        public static Field<Boolean, Boolean> zzj(String str, int i) {
            return new Field(6, false, 6, false, str, i, (Class<? extends FastJsonResponse>) null, (zza) null);
        }

        public static Field<String, String> zzk(String str, int i) {
            return new Field(7, false, 7, false, str, i, (Class<? extends FastJsonResponse>) null, (zza) null);
        }

        public I convertBack(O o) {
            return this.zzasS.convertBack(o);
        }

        public int getVersionCode() {
            return this.mVersionCode;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Field\n");
            sb.append("            versionCode=");
            sb.append(this.mVersionCode);
            sb.append(10);
            sb.append("                 typeIn=");
            sb.append(this.zzasJ);
            sb.append(10);
            sb.append("            typeInArray=");
            sb.append(this.zzasK);
            sb.append(10);
            sb.append("                typeOut=");
            sb.append(this.zzasL);
            sb.append(10);
            sb.append("           typeOutArray=");
            sb.append(this.zzasM);
            sb.append(10);
            sb.append("        outputFieldName=");
            sb.append(this.zzasN);
            sb.append(10);
            sb.append("      safeParcelFieldId=");
            sb.append(this.zzasO);
            sb.append(10);
            sb.append("       concreteTypeName=");
            sb.append(zzun());
            sb.append(10);
            if (zzum() != null) {
                sb.append("     concreteType.class=");
                sb.append(zzum().getCanonicalName());
                sb.append(10);
            }
            sb.append("          converterName=");
            zza<I, O> zza = this.zzasS;
            sb.append(zza == null ? "null" : zza.getClass().getCanonicalName());
            sb.append(10);
            return sb.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            zza zza = CREATOR;
            zza.zza(this, parcel, i);
        }

        public void zza(FieldMappingDictionary fieldMappingDictionary) {
            this.zzasR = fieldMappingDictionary;
        }

        public int zzud() {
            return this.zzasJ;
        }

        public int zzue() {
            return this.zzasL;
        }

        public boolean zzui() {
            return this.zzasK;
        }

        public boolean zzuj() {
            return this.zzasM;
        }

        public String zzuk() {
            return this.zzasN;
        }

        public int zzul() {
            return this.zzasO;
        }

        public Class<? extends FastJsonResponse> zzum() {
            return this.zzasP;
        }

        /* access modifiers changed from: package-private */
        public String zzun() {
            String str = this.zzasQ;
            if (str == null) {
                return null;
            }
            return str;
        }

        public boolean zzuo() {
            return this.zzasS != null;
        }

        /* access modifiers changed from: package-private */
        public ConverterWrapper zzup() {
            zza<I, O> zza = this.zzasS;
            if (zza == null) {
                return null;
            }
            return ConverterWrapper.zza(zza);
        }

        public Map<String, Field<?, ?>> zzuq() {
            zzaa.zzz(this.zzasQ);
            zzaa.zzz(this.zzasR);
            return this.zzasR.zzdq(this.zzasQ);
        }
    }

    public interface zza<I, O> {
        I convertBack(O o);

        int zzud();

        int zzue();
    }

    private void zza(StringBuilder sb, Field field, Object obj) {
        String str;
        if (field.zzud() == 11) {
            str = ((FastJsonResponse) field.zzum().cast(obj)).toString();
        } else if (field.zzud() == 7) {
            str = "\"";
            sb.append(str);
            sb.append(zzp.zzdu((String) obj));
        } else {
            sb.append(obj);
            return;
        }
        sb.append(str);
    }

    private void zza(StringBuilder sb, Field field, ArrayList<Object> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                zza(sb, field, obj);
            }
        }
        sb.append("]");
    }

    public String toString() {
        String str;
        Map<String, Field<?, ?>> zzuf = zzuf();
        StringBuilder sb = new StringBuilder(100);
        for (String next : zzuf.keySet()) {
            Field field = zzuf.get(next);
            if (zza(field)) {
                Object zza2 = zza(field, zzb(field));
                sb.append(sb.length() == 0 ? "{" : Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append("\"");
                sb.append(next);
                sb.append("\":");
                if (zza2 == null) {
                    sb.append("null");
                } else {
                    switch (field.zzue()) {
                        case 8:
                            sb.append("\"");
                            str = zzc.zzk((byte[]) zza2);
                            break;
                        case 9:
                            sb.append("\"");
                            str = zzc.zzl((byte[]) zza2);
                            break;
                        case 10:
                            zzq.zza(sb, (HashMap) zza2);
                            continue;
                        default:
                            if (!field.zzui()) {
                                zza(sb, field, zza2);
                                break;
                            } else {
                                zza(sb, field, (ArrayList<Object>) (ArrayList) zza2);
                                continue;
                            }
                    }
                    sb.append(str);
                    sb.append("\"");
                }
            }
        }
        sb.append(sb.length() > 0 ? "}" : "{}");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public <O, I> I zza(Field<I, O> field, Object obj) {
        return field.zzasS != null ? field.convertBack(obj) : obj;
    }

    /* access modifiers changed from: protected */
    public boolean zza(Field field) {
        return field.zzue() == 11 ? field.zzuj() ? zzdp(field.zzuk()) : zzdo(field.zzuk()) : zzdn(field.zzuk());
    }

    /* access modifiers changed from: protected */
    public Object zzb(Field field) {
        String zzuk = field.zzuk();
        if (field.zzum() == null) {
            return zzdm(field.zzuk());
        }
        zzaa.zza(zzdm(field.zzuk()) == null, "Concrete field shouldn't be value object: %s", field.zzuk());
        HashMap<String, Object> zzuh = field.zzuj() ? zzuh() : zzug();
        if (zzuh != null) {
            return zzuh.get(zzuk);
        }
        try {
            char upperCase = Character.toUpperCase(zzuk.charAt(0));
            String valueOf = String.valueOf(zzuk.substring(1));
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 4);
            sb.append("get");
            sb.append(upperCase);
            sb.append(valueOf);
            return getClass().getMethod(sb.toString(), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object zzdm(String str);

    /* access modifiers changed from: protected */
    public abstract boolean zzdn(String str);

    /* access modifiers changed from: protected */
    public boolean zzdo(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    /* access modifiers changed from: protected */
    public boolean zzdp(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    public abstract Map<String, Field<?, ?>> zzuf();

    public HashMap<String, Object> zzug() {
        return null;
    }

    public HashMap<String, Object> zzuh() {
        return null;
    }
}
