package com.mbridge.msdk.foundation.tools;

import android.content.Context;

/* compiled from: DomainSameDiTool */
public class d {
    public static void a(Context context) {
        if (context != null) {
            try {
                Class<?> cls = Class.forName("com.mbridge.msdk.mbsignalcommon.webEnvCheck.WebEnvCheckEntry");
                Object newInstance = cls.newInstance();
                cls.getMethod("check", new Class[]{Context.class}).invoke(newInstance, new Object[]{context});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
