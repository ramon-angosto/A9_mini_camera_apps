package com.huawei.android.pushagent.plugin.tools;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.plugin.a.c;
import com.huawei.android.pushagent.plugin.a.d;
import java.util.ArrayList;
import java.util.List;

public class a {
    private ArrayList a;
    private d b = new d();
    private BLocation c;

    private static ArrayList a(ArrayList arrayList, CellLocation cellLocation, TelephonyManager telephonyManager) throws Exception {
        e.a(BLocation.TAG, "enter getGsmNetInfo");
        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
        c cVar = new c();
        cVar.a(gsmCellLocation.getCid());
        cVar.b(gsmCellLocation.getLac());
        if (Build.VERSION.SDK_INT >= 9) {
            cVar.c(gsmCellLocation.getPsc());
        }
        arrayList.add(cVar);
        List<NeighboringCellInfo> neighboringCellInfo = telephonyManager.getNeighboringCellInfo();
        if (neighboringCellInfo != null && !neighboringCellInfo.isEmpty()) {
            int size = neighboringCellInfo.size();
            e.a(BLocation.TAG, "Neighbor GSM cell amount is " + size);
            for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                c cVar2 = new c();
                cVar2.a(neighboringCellInfo2.getCid());
                if (Build.VERSION.SDK_INT >= 5) {
                    cVar2.b(neighboringCellInfo2.getLac());
                    cVar2.c(neighboringCellInfo2.getPsc());
                }
                arrayList.add(cVar2);
            }
        }
        return arrayList;
    }

    private static int b(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getPhoneType();
    }

    private static ArrayList b(ArrayList arrayList, CellLocation cellLocation, TelephonyManager telephonyManager) throws Exception {
        e.a(BLocation.TAG, "enter getCdmaNetInfo");
        com.huawei.android.pushagent.plugin.a.a aVar = new com.huawei.android.pushagent.plugin.a.a();
        if (Build.VERSION.SDK_INT >= 5) {
            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
            aVar.a(cdmaCellLocation.getBaseStationId());
            aVar.c(cdmaCellLocation.getBaseStationLongitude());
            aVar.b(cdmaCellLocation.getBaseStationLatitude());
            aVar.d(cdmaCellLocation.getNetworkId());
            aVar.e(cdmaCellLocation.getSystemId());
            arrayList.add(aVar);
        }
        List<NeighboringCellInfo> neighboringCellInfo = telephonyManager.getNeighboringCellInfo();
        if (neighboringCellInfo != null && !neighboringCellInfo.isEmpty()) {
            int size = neighboringCellInfo.size();
            e.a(BLocation.TAG, "Neighbors CDMA cell amount is " + size);
            for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                com.huawei.android.pushagent.plugin.a.a aVar2 = new com.huawei.android.pushagent.plugin.a.a();
                aVar2.a(neighboringCellInfo2.getCid());
                if (Build.VERSION.SDK_INT >= 5) {
                    neighboringCellInfo2.getNetworkType();
                    neighboringCellInfo2.getLac();
                    neighboringCellInfo2.getPsc();
                }
                neighboringCellInfo2.getRssi();
                neighboringCellInfo2.getCid();
                arrayList.add(aVar2);
            }
        }
        return arrayList;
    }

    private static String c(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
    }

    private static ArrayList d(Context context) throws Exception {
        String str;
        e.a(BLocation.TAG, " enter getNetInfo");
        ArrayList arrayList = new ArrayList();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        CellLocation cellLocation = telephonyManager.getCellLocation();
        if (cellLocation != null) {
            int b2 = b(context);
            if (b2 != 0) {
                if (b2 == 1) {
                    e.a(BLocation.TAG, "PHONE_TYPE_GSM  1");
                    a(arrayList, cellLocation, telephonyManager);
                } else if (b2 == 2) {
                    e.a(BLocation.TAG, "PHONE_TYPE_CDMA  2");
                    b(arrayList, cellLocation, telephonyManager);
                } else if (b2 == 3) {
                    str = "PHONE_TYPE_SIP   3";
                }
                return arrayList;
            }
            str = "PHONE_TYPE_NONE  0";
            e.a(BLocation.TAG, str);
            return arrayList;
        }
        throw new Exception("CellInfo is null");
    }

    public d a(Context context) {
        e.a(BLocation.TAG, "enter getLocationInfoInstance()");
        try {
            this.c = BLocation.getInstance(context);
            this.a = d(context);
        } catch (Exception e) {
            e.c(BLocation.TAG, e.toString(), e);
        }
        ArrayList arrayList = this.a;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        e.a(BLocation.TAG, "The Cell Amount is " + this.a.size());
        this.b.a((List) this.a);
        this.b.a(c(context));
        this.b.a(b(context));
        int i = 40;
        while (true) {
            if (i <= 0) {
                break;
            }
            Location location = this.c.getLocation();
            if (location != null) {
                this.b.a(location.getLongitude(), location.getLatitude());
                break;
            }
            try {
                e.a(BLocation.TAG, "sleep 500ms to get location");
                Thread.sleep(500);
            } catch (InterruptedException e2) {
                e.d(BLocation.TAG, e2.toString());
            }
            i--;
        }
        return this.b;
    }
}
