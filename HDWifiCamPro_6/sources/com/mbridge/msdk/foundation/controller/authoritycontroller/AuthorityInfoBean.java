package com.mbridge.msdk.foundation.controller.authoritycontroller;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.a.a.a;

public class AuthorityInfoBean {
    public int getAuthGenDataStatus() {
        if (!a.a().b(MBridgeConstans.AUTHORITY_GENERAL_DATA).equals("")) {
            return Integer.parseInt(a.a().b(MBridgeConstans.AUTHORITY_GENERAL_DATA));
        }
        return 1;
    }

    public int getAuthDeviceIdStatus() {
        if (!a.a().b(MBridgeConstans.AUTHORITY_DEVICE_ID).equals("")) {
            return Integer.parseInt(a.a().b(MBridgeConstans.AUTHORITY_DEVICE_ID));
        }
        return 1;
    }

    public int getAuthSerialIdStatus() {
        if (!a.a().b(MBridgeConstans.AUTHORITY_SERIAL_ID).equals("")) {
            return Integer.parseInt(a.a().b(MBridgeConstans.AUTHORITY_SERIAL_ID));
        }
        return 1;
    }

    /* access modifiers changed from: protected */
    public final AuthorityInfoBean a(int i) {
        a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA, String.valueOf(i));
        a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID, String.valueOf(i));
        a.a().a(MBridgeConstans.AUTHORITY_SERIAL_ID, String.valueOf(i));
        return this;
    }

    /* access modifiers changed from: protected */
    public final AuthorityInfoBean b(int i) {
        a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA, String.valueOf(i));
        return this;
    }

    /* access modifiers changed from: protected */
    public final AuthorityInfoBean c(int i) {
        a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID, String.valueOf(i));
        return this;
    }

    /* access modifiers changed from: protected */
    public final AuthorityInfoBean d(int i) {
        a.a().a(MBridgeConstans.AUTHORITY_SERIAL_ID, String.valueOf(i));
        return this;
    }

    /* access modifiers changed from: protected */
    public final AuthorityInfoBean e(int i) {
        a.a().a(MBridgeConstans.AUTHORITY_OTHER, String.valueOf(i));
        return this;
    }
}
