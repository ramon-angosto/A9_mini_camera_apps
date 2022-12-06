package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hms.core.aidl.e */
/* compiled from: MessageCodec */
public class C0710e {
    /* renamed from: b */
    private void m437b(IMessageEntity iMessageEntity, Field field, Bundle bundle) throws IllegalAccessException {
        boolean isAccessible = field.isAccessible();
        field.setAccessible(true);
        mo13639a(field.getName(), field.get(iMessageEntity), bundle);
        field.setAccessible(isAccessible);
    }

    /* renamed from: a */
    public IMessageEntity mo13637a(Bundle bundle, IMessageEntity iMessageEntity) {
        if (bundle == null) {
            return iMessageEntity;
        }
        bundle.setClassLoader(getClass().getClassLoader());
        for (Class cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(Packed.class)) {
                    try {
                        m436a(iMessageEntity, field, bundle);
                    } catch (IllegalAccessException | IllegalArgumentException unused) {
                        Log.e("MessageCodec", "decode, set value of the field exception, field name:" + field.getName());
                    }
                }
            }
        }
        return iMessageEntity;
    }

    /* renamed from: b */
    private boolean m438b(String str, Object obj, Bundle bundle) {
        if (obj instanceof String) {
            bundle.putString(str, (String) obj);
            return true;
        } else if (obj instanceof Integer) {
            bundle.putInt(str, ((Integer) obj).intValue());
            return true;
        } else if (obj instanceof Short) {
            bundle.putShort(str, ((Short) obj).shortValue());
            return true;
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return true;
        } else if (obj instanceof Float) {
            bundle.putFloat(str, ((Float) obj).floatValue());
            return true;
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return true;
        } else if (!(obj instanceof Boolean)) {
            return false;
        } else {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            return true;
        }
    }

    /* renamed from: a */
    private void m436a(IMessageEntity iMessageEntity, Field field, Bundle bundle) throws IllegalAccessException {
        Object a = m435a(field, bundle);
        if (a != null) {
            boolean isAccessible = field.isAccessible();
            field.setAccessible(true);
            field.set(iMessageEntity, a);
            field.setAccessible(isAccessible);
        }
    }

    /* renamed from: a */
    private Object m435a(Field field, Bundle bundle) {
        String name = field.getName();
        Object obj = bundle.get(name);
        if (obj instanceof Bundle) {
            try {
                Bundle bundle2 = (Bundle) obj;
                int i = bundle2.getInt("_val_type_", -1);
                if (i == 1) {
                    return mo13638a(field.getGenericType(), bundle2);
                }
                if (i == 0) {
                    return mo13637a((Bundle) obj, (IMessageEntity) field.getType().newInstance());
                }
            } catch (Exception unused) {
                Log.e("MessageCodec", "decode, read value of the field exception, field name: " + name);
                return null;
            }
        }
        return obj;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public List<Object> mo13638a(Type type, Bundle bundle) throws InstantiationException, IllegalAccessException {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle2 = bundle.getBundle("_next_item_"); bundle2 != null; bundle2 = bundle2.getBundle("_next_item_")) {
            Object obj = bundle2.get("_value_");
            if (obj.getClass().isPrimitive() || (obj instanceof String) || (obj instanceof Serializable)) {
                arrayList.add(obj);
            } else if (!(obj instanceof Bundle)) {
                continue;
            } else {
                Bundle bundle3 = (Bundle) obj;
                int i = bundle3.getInt("_val_type_", -1);
                if (i == 1) {
                    throw new InstantiationException("Nested List can not be supported");
                } else if (i == 0) {
                    arrayList.add(mo13637a(bundle3, (IMessageEntity) ((Class) ((ParameterizedType) type).getActualTypeArguments()[0]).newInstance()));
                } else {
                    throw new InstantiationException("Unknown type can not be supported");
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public Bundle mo13636a(IMessageEntity iMessageEntity, Bundle bundle) {
        for (Class cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(Packed.class)) {
                    try {
                        m437b(iMessageEntity, field, bundle);
                    } catch (IllegalAccessException | IllegalArgumentException unused) {
                        Log.e("MessageCodec", "encode, get value of the field exception, field name: " + field.getName());
                    }
                }
            }
        }
        return bundle;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo13639a(String str, Object obj, Bundle bundle) {
        if (obj == null || m438b(str, obj, bundle)) {
            return;
        }
        if (obj instanceof CharSequence) {
            bundle.putCharSequence(str, (CharSequence) obj);
        } else if (obj instanceof Parcelable) {
            bundle.putParcelable(str, (Parcelable) obj);
        } else if (obj instanceof byte[]) {
            bundle.putByteArray(str, (byte[]) obj);
        } else if (obj instanceof List) {
            mo13640a(str, (List) obj, bundle);
        } else if (obj instanceof Serializable) {
            bundle.putSerializable(str, (Serializable) obj);
        } else if (obj instanceof IMessageEntity) {
            Bundle a = mo13636a((IMessageEntity) obj, new Bundle());
            a.putInt("_val_type_", 0);
            bundle.putBundle(str, a);
        } else {
            Log.e("MessageCodec", "cannot support type, " + str);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo13640a(String str, List list, Bundle bundle) {
        Bundle bundle2 = null;
        for (Object next : list) {
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(str, bundle2);
                bundle2.putInt("_val_type_", 1);
            }
            bundle2 = m434a("_value_", bundle2, next);
        }
    }

    /* renamed from: a */
    private Bundle m434a(String str, Bundle bundle, Object obj) {
        Bundle bundle2 = new Bundle();
        mo13639a(str, obj, bundle2);
        bundle.putBundle("_next_item_", bundle2);
        return bundle2;
    }
}
