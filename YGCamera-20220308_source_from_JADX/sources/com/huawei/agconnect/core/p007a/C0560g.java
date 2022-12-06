package com.huawei.agconnect.core.p007a;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.core.Service;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.agconnect.core.a.g */
public final class C0560g {

    /* renamed from: a */
    private Map<Class<?>, Service> f129a = new HashMap();

    /* renamed from: b */
    private Map<Class<?>, Object> f130b = new HashMap();

    C0560g(List<Service> list) {
        if (list != null) {
            for (Service next : list) {
                this.f129a.put(next.getInterface(), next);
            }
        }
    }

    /* renamed from: a */
    private Object m83a(AGConnectInstance aGConnectInstance, Service service) {
        StringBuilder sb;
        String str;
        Class<?> type = service.getType();
        if (type == null) {
            return null;
        }
        try {
            Constructor a = m84a((Class) type, Context.class, AGConnectInstance.class);
            if (a != null) {
                return a.newInstance(new Object[]{aGConnectInstance.getContext(), aGConnectInstance});
            }
            Constructor a2 = m84a((Class) type, Context.class);
            if (a2 == null) {
                return type.newInstance();
            }
            return a2.newInstance(new Object[]{aGConnectInstance.getContext()});
        } catch (InstantiationException e) {
            sb = new StringBuilder();
            sb.append("Instantiate service exception ");
            str = e.getLocalizedMessage();
            sb.append(str);
            Log.e("ServiceRepository", sb.toString());
            return null;
        } catch (InvocationTargetException e2) {
            sb = new StringBuilder();
            sb.append("Instantiate service exception ");
            str = e2.getLocalizedMessage();
            sb.append(str);
            Log.e("ServiceRepository", sb.toString());
            return null;
        } catch (IllegalAccessException e3) {
            sb = new StringBuilder();
            sb.append("Instantiate service exception ");
            str = e3.getLocalizedMessage();
            sb.append(str);
            Log.e("ServiceRepository", sb.toString());
            return null;
        }
    }

    /* renamed from: a */
    private static Constructor m84a(Class cls, Class... clsArr) {
        boolean z = false;
        for (Constructor constructor : cls.getDeclaredConstructors()) {
            Class[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == clsArr.length) {
                boolean z2 = z;
                for (int i = 0; i < clsArr.length; i++) {
                    z2 = parameterTypes[i] == clsArr[i];
                }
                if (z2) {
                    return constructor;
                }
                z = z2;
            }
        }
        return null;
    }

    /* renamed from: a */
    public <T> T mo12768a(AGConnectInstance aGConnectInstance, Class<?> cls) {
        T t;
        Service service = this.f129a.get(cls);
        if (service == null) {
            return null;
        }
        if (service.isSingleton() && (t = this.f130b.get(cls)) != null) {
            return t;
        }
        T a = m83a(aGConnectInstance, service);
        if (a != null && service.isSingleton()) {
            this.f130b.put(cls, a);
        }
        return a;
    }
}
