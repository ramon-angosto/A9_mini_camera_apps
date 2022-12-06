package sg.bigo.ads.common.e;

import android.content.Context;

final class a {
    public static sg.bigo.ads.common.a a(Context context) {
        try {
            Object invoke = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
            Boolean bool = (Boolean) invoke.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(invoke, new Object[0]);
            String str = (String) invoke.getClass().getMethod("getId", new Class[0]).invoke(invoke, new Object[0]);
            if (!(str == null || bool == null)) {
                return new sg.bigo.ads.common.a(str, bool.booleanValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
