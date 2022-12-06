package androidx.core.location;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public final class LocationCompat {
    private static final String EXTRA_IS_MOCK = "mockLocation";
    private static Method sSetIsFromMockProviderMethod;

    private LocationCompat() {
    }

    public static long getElapsedRealtimeNanos(Location location) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Api17Impl.getElapsedRealtimeNanos(location);
        }
        return TimeUnit.MILLISECONDS.toNanos(getElapsedRealtimeMillis(location));
    }

    public static long getElapsedRealtimeMillis(Location location) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TimeUnit.NANOSECONDS.toMillis(Api17Impl.getElapsedRealtimeNanos(location));
        }
        long currentTimeMillis = System.currentTimeMillis() - location.getTime();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (currentTimeMillis < 0) {
            return elapsedRealtime;
        }
        if (currentTimeMillis > elapsedRealtime) {
            return 0;
        }
        return elapsedRealtime - currentTimeMillis;
    }

    public static boolean isMock(Location location) {
        if (Build.VERSION.SDK_INT >= 18) {
            return Api18Impl.isMock(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return false;
        }
        return extras.getBoolean(EXTRA_IS_MOCK, false);
    }

    public static void setMock(Location location, boolean z) {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                getSetIsFromMockProviderMethod().invoke(location, new Object[]{Boolean.valueOf(z)});
            } catch (NoSuchMethodException e) {
                NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
                noSuchMethodError.initCause(e);
                throw noSuchMethodError;
            } catch (IllegalAccessException e2) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e2);
                throw illegalAccessError;
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3);
            }
        } else {
            Bundle extras = location.getExtras();
            if (extras == null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(EXTRA_IS_MOCK, true);
                location.setExtras(bundle);
                return;
            }
            extras.putBoolean(EXTRA_IS_MOCK, true);
        }
    }

    private static class Api18Impl {
        private Api18Impl() {
        }

        static boolean isMock(Location location) {
            return location.isFromMockProvider();
        }
    }

    private static class Api17Impl {
        private Api17Impl() {
        }

        static long getElapsedRealtimeNanos(Location location) {
            return location.getElapsedRealtimeNanos();
        }
    }

    private static Method getSetIsFromMockProviderMethod() throws NoSuchMethodException {
        if (sSetIsFromMockProviderMethod == null) {
            sSetIsFromMockProviderMethod = Location.class.getDeclaredMethod("setIsFromMockProvider", new Class[]{Boolean.TYPE});
            sSetIsFromMockProviderMethod.setAccessible(true);
        }
        return sSetIsFromMockProviderMethod;
    }
}
