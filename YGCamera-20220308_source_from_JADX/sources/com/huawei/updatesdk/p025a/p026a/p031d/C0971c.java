package com.huawei.updatesdk.p025a.p026a.p031d;

import com.huawei.hms.opendevice.C0848c;
import com.huawei.hms.opendevice.C0855i;
import com.huawei.hms.push.C0875e;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.updatesdk.a.a.d.c */
public class C0971c {

    /* renamed from: a */
    private static final Map<String, String> f1308a = new HashMap();

    static {
        f1308a.put("android.hardware.audio.output", "1");
        f1308a.put("android.hardware.bluetooth", "2");
        f1308a.put("android.hardware.bluetooth_le", "3");
        f1308a.put("android.hardware.camera", "4");
        f1308a.put("android.hardware.camera.any", "5");
        f1308a.put("android.hardware.camera.autofocus", "6");
        f1308a.put("android.hardware.camera.capability.manual_post_processing", "7");
        f1308a.put("android.hardware.camera.flash", "8");
        f1308a.put("android.hardware.camera.front", "9");
        f1308a.put("android.hardware.consumerir", "A");
        f1308a.put("android.hardware.faketouch", "B");
        f1308a.put("android.hardware.fingerprint", "C");
        f1308a.put("android.hardware.location", "D");
        f1308a.put("android.hardware.location.gps", "E");
        f1308a.put("android.hardware.location.network", "F");
        f1308a.put("android.hardware.microphone", "G");
        f1308a.put("android.hardware.nfc", "H");
        f1308a.put("android.hardware.nfc.any", "I");
        f1308a.put("android.hardware.nfc.hce", "J");
        f1308a.put("android.hardware.nfc.hcef", "K");
        f1308a.put("android.hardware.opengles.aep", "L");
        f1308a.put("android.hardware.ram.normal", "M");
        f1308a.put("android.hardware.screen.landscape", "N");
        f1308a.put("android.hardware.screen.portrait", "O");
        f1308a.put("android.hardware.sensor.accelerometer", "P");
        f1308a.put("android.hardware.sensor.barometer", "Q");
        f1308a.put("android.hardware.sensor.compass", "R");
        f1308a.put("android.hardware.sensor.gyroscope", "S");
        f1308a.put("android.hardware.sensor.light", "T");
        f1308a.put("android.hardware.sensor.proximity", "U");
        f1308a.put("android.hardware.sensor.stepcounter", "V");
        f1308a.put("android.hardware.sensor.stepdetector", "W");
        f1308a.put("android.hardware.telephony", "X");
        f1308a.put("android.hardware.telephony.gsm", "Y");
        f1308a.put("android.hardware.telephony.ims", "Z");
        f1308a.put("android.hardware.touchscreen", "a");
        f1308a.put("android.hardware.touchscreen.multitouch", "b");
        f1308a.put("android.hardware.touchscreen.multitouch.distinct", C0848c.f780a);
        f1308a.put("android.hardware.touchscreen.multitouch.jazzhand", "d");
        f1308a.put("android.hardware.usb.accessory", C0875e.f876a);
        f1308a.put("android.hardware.usb.host", "f");
        f1308a.put("android.hardware.vulkan.compute", "g");
        f1308a.put("android.hardware.vulkan.level", "h");
        f1308a.put("android.hardware.vulkan.version", C0855i.TAG);
        f1308a.put("android.hardware.wifi", "j");
        f1308a.put("android.hardware.wifi.direct", "k");
        f1308a.put("android.hardware.wifi.passpoint", "l");
        f1308a.put("android.software.activities_on_secondary_displays", "m");
        f1308a.put("android.software.app_widgets", "n");
        f1308a.put("android.software.autofill", "o");
        f1308a.put("android.software.backup", "p");
        f1308a.put("android.software.cant_save_state", "q");
        f1308a.put("android.software.companion_device_setup", "r");
        f1308a.put("android.software.connectionservice", "s");
        f1308a.put("android.software.cts", "t");
        f1308a.put("android.software.device_admin", "u");
        f1308a.put("android.software.file_based_encryption", "v");
        f1308a.put("android.software.freeform_window_management", "w");
        f1308a.put("android.software.home_screen", "x");
        f1308a.put("android.software.input_methods", "y");
        f1308a.put("android.software.ipsec_tunnels", "z");
        f1308a.put("android.software.live_wallpaper", "00");
        f1308a.put("android.software.managed_users", HiAnalyticsConstant.KeyAndValue.NUMBER_01);
        f1308a.put("android.software.midi", "02");
        f1308a.put("android.software.picture_in_picture", "03");
        f1308a.put("android.software.print", "04");
        f1308a.put("android.software.secure_lock_screen", "05");
        f1308a.put("android.software.securely_removes_users", "06");
        f1308a.put("android.software.verified_boot", "07");
        f1308a.put("android.software.voice_recognizers", "08");
        f1308a.put("android.software.webview", "09");
        f1308a.put("android.sofware.nfc.beam", "0A");
        f1308a.put("com.huawei.software.features.china", "0B");
        f1308a.put("com.huawei.software.features.full", "0C");
        f1308a.put("com.huawei.system.feature", "0D");
        f1308a.put("com.nxp.mifare", "0E");
        f1308a.put("huawei.android.hardware.stylus", "0F");
        f1308a.put("android.hardware.audio.low_latency", "0G");
        f1308a.put("android.hardware.camera.capability.raw", "0H");
        f1308a.put("android.hardware.camera.external", "0I");
        f1308a.put("android.hardware.telephony.cdma", "0J");
        f1308a.put("android.software.file_based_encryption", "0K");
        f1308a.put("android.software.sip", "0L");
        f1308a.put("android.software.sip.voip", "0M");
        f1308a.put("android.software.vr.mode", "0N");
        f1308a.put("cn.google.services", "0O");
        f1308a.put("com.google.android.feature.services_updater", "0P");
        f1308a.put("com.google.android.feature.ZERO_TOUCH", "0Q");
        f1308a.put("com.huawei.software.features.oversea", "0R");
    }

    /* renamed from: a */
    public static String m1690a(String str) {
        return f1308a.containsKey(str) ? f1308a.get(str) : str;
    }
}
