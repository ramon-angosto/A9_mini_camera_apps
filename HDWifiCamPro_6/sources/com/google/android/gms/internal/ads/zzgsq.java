package com.google.android.gms.internal.ads;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgsq {
    static String zza(zzgso zzgso, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzgso, sb, 0);
        return sb.toString();
    }

    static final void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zzb : (List) obj) {
                zzb(sb, i, str, zzb);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry zzb2 : ((Map) obj).entrySet()) {
                zzb(sb, i, str, zzb2);
            }
        } else {
            sb.append(10);
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzgtw.zza(zzgpw.zzx((String) obj)));
                sb.append(Typography.quote);
            } else if (obj instanceof zzgpw) {
                sb.append(": \"");
                sb.append(zzgtw.zza((zzgpw) obj));
                sb.append(Typography.quote);
            } else if (obj instanceof zzgre) {
                sb.append(" {");
                zzd((zzgre) obj, sb, i + 2);
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i4 = i + 2;
                zzb(sb, i4, "key", entry.getKey());
                zzb(sb, i4, AppMeasurementSdk.ConditionalUserProperty.VALUE, entry.getValue());
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj);
            }
        }
    }

    private static final String zzc(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    private static void zzd(zzgso zzgso, StringBuilder sb, int i) {
        boolean z;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet<>();
        for (Method method : zzgso.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String substring = str.startsWith("get") ? str.substring(3) : str;
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List")) {
                String concat = String.valueOf(substring.substring(0, 1).toLowerCase()).concat(String.valueOf(substring.substring(1, substring.length() - 4)));
                Method method2 = (Method) hashMap.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb, i, zzc(concat), zzgre.zzaO(method2, zzgso, new Object[0]));
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map")) {
                String concat2 = String.valueOf(substring.substring(0, 1).toLowerCase()).concat(String.valueOf(substring.substring(1, substring.length() - 3)));
                Method method3 = (Method) hashMap.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(sb, i, zzc(concat2), zzgre.zzaO(method3, zzgso, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set".concat(String.valueOf(substring)))) != null && (!substring.endsWith("Bytes") || !hashMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                String concat3 = String.valueOf(substring.substring(0, 1).toLowerCase()).concat(String.valueOf(substring.substring(1)));
                Method method4 = (Method) hashMap.get("get".concat(String.valueOf(substring)));
                Method method5 = (Method) hashMap.get("has".concat(String.valueOf(substring)));
                if (method4 != null) {
                    Object zzaO = zzgre.zzaO(method4, zzgso, new Object[0]);
                    if (method5 == null) {
                        if (zzaO instanceof Boolean) {
                            if (!((Boolean) zzaO).booleanValue()) {
                            }
                        } else if (zzaO instanceof Integer) {
                            if (((Integer) zzaO).intValue() == 0) {
                            }
                        } else if (zzaO instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) zzaO).floatValue()) == 0) {
                            }
                        } else if (!(zzaO instanceof Double)) {
                            if (zzaO instanceof String) {
                                z = zzaO.equals("");
                            } else if (zzaO instanceof zzgpw) {
                                z = zzaO.equals(zzgpw.zzb);
                            } else if (zzaO instanceof zzgso) {
                                if (zzaO == ((zzgso) zzaO).zzbh()) {
                                }
                            } else if ((zzaO instanceof Enum) && ((Enum) zzaO).ordinal() == 0) {
                            }
                            if (z) {
                            }
                        } else if (Double.doubleToRawLongBits(((Double) zzaO).doubleValue()) == 0) {
                        }
                    } else if (!((Boolean) zzgre.zzaO(method5, zzgso, new Object[0])).booleanValue()) {
                    }
                    zzb(sb, i, zzc(concat3), zzaO);
                }
            }
        }
        if (!(zzgso instanceof zzgrb)) {
            zzgtz zzgtz = ((zzgre) zzgso).zzc;
            if (zzgtz != null) {
                zzgtz.zzg(sb, i);
                return;
            }
            return;
        }
        zzgqv zzgqv = ((zzgrb) zzgso).zzb;
        throw null;
    }
}
