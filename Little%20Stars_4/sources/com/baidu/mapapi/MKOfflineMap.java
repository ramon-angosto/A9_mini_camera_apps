package com.baidu.mapapi;

import android.os.Bundle;
import android.util.Log;
import java.net.ServerSocket;
import java.util.ArrayList;
import object.p2pipcam.utils.DataBaseHelper;

public class MKOfflineMap {
    public static final int TYPE_DOWNLOAD_UPDATE = 0;
    public static final int TYPE_NEW_OFFLINE = 6;
    public static final int TYPE_VER_UPDATE = 4;
    private Bundle a = null;

    private boolean a() {
        if (Mj.f != null) {
            return true;
        }
        try {
            Mj.f = new ServerSocket(51232);
            return true;
        } catch (Exception e) {
            Log.d("baidumap", e.getMessage());
            return false;
        }
    }

    public ArrayList<MKOLUpdateElement> getAllUpdateInfo() {
        Bundle bundle = this.a;
        if (bundle == null) {
            this.a = new Bundle();
        } else {
            bundle.clear();
        }
        this.a.putInt("act", 16010400);
        if (Mj.sendBundle(this.a) == 0) {
            return null;
        }
        String[] stringArray = this.a.getStringArray(DataBaseHelper.KEY_NAME);
        int[] intArray = this.a.getIntArray(DataBaseHelper.KEY_ID);
        int[] intArray2 = this.a.getIntArray("size");
        int[] intArray3 = this.a.getIntArray("ratio");
        int[] intArray4 = this.a.getIntArray("cityptx");
        int[] intArray5 = this.a.getIntArray("citypty");
        int[] intArray6 = this.a.getIntArray("serversize");
        int[] intArray7 = this.a.getIntArray("download");
        ArrayList<MKOLUpdateElement> arrayList = new ArrayList<>();
        for (int i = 0; i < stringArray.length; i++) {
            MKOLUpdateElement mKOLUpdateElement = new MKOLUpdateElement();
            mKOLUpdateElement.cityName = stringArray[i];
            mKOLUpdateElement.cityID = intArray[i];
            mKOLUpdateElement.size = intArray2[i];
            mKOLUpdateElement.ratio = intArray3[i];
            if (mKOLUpdateElement.ratio == 10000) {
                mKOLUpdateElement.ratio = 100;
            }
            mKOLUpdateElement.geoPt = new GeoPoint(intArray5[i], intArray4[i]);
            mKOLUpdateElement.status = intArray7[i];
            mKOLUpdateElement.serversize = intArray6[i];
            arrayList.add(mKOLUpdateElement);
        }
        return arrayList;
    }

    public ArrayList<MKOLSearchRecord> getHotCityList() {
        Bundle bundle = this.a;
        if (bundle == null) {
            this.a = new Bundle();
        } else {
            bundle.clear();
        }
        this.a.putInt("act", 16011000);
        if (Mj.sendBundle(this.a) == 0) {
            return null;
        }
        String[] stringArray = this.a.getStringArray(DataBaseHelper.KEY_NAME);
        int[] intArray = this.a.getIntArray(DataBaseHelper.KEY_ID);
        int[] intArray2 = this.a.getIntArray("size");
        ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
        for (int i = 0; i < stringArray.length; i++) {
            MKOLSearchRecord mKOLSearchRecord = new MKOLSearchRecord();
            mKOLSearchRecord.cityName = stringArray[i];
            mKOLSearchRecord.cityID = intArray[i];
            mKOLSearchRecord.size = intArray2[i];
            arrayList.add(mKOLSearchRecord);
        }
        return arrayList;
    }

    public ArrayList<MKOLSearchRecord> getOfflineCityList() {
        Bundle bundle = this.a;
        if (bundle == null) {
            this.a = new Bundle();
        } else {
            bundle.clear();
        }
        this.a.putInt("act", 16011100);
        if (Mj.sendBundle(this.a) == 0) {
            return null;
        }
        String[] stringArray = this.a.getStringArray(DataBaseHelper.KEY_NAME);
        int[] intArray = this.a.getIntArray(DataBaseHelper.KEY_ID);
        int[] intArray2 = this.a.getIntArray("size");
        ArrayList<MKOLSearchRecord> arrayList = new ArrayList<>();
        for (int i = 0; i < stringArray.length; i++) {
            MKOLSearchRecord mKOLSearchRecord = new MKOLSearchRecord();
            mKOLSearchRecord.cityName = stringArray[i];
            mKOLSearchRecord.cityID = intArray[i];
            mKOLSearchRecord.size = intArray2[i];
            arrayList.add(mKOLSearchRecord);
        }
        return arrayList;
    }

    public MKOLUpdateElement getUpdateInfo(int i) {
        Bundle bundle = this.a;
        if (bundle == null) {
            this.a = new Bundle();
        } else {
            bundle.clear();
        }
        this.a.putInt("act", 16010500);
        this.a.putInt("opt", i);
        if (Mj.sendBundle(this.a) == 0) {
            return null;
        }
        MKOLUpdateElement mKOLUpdateElement = new MKOLUpdateElement();
        mKOLUpdateElement.cityName = this.a.getString(DataBaseHelper.KEY_NAME);
        mKOLUpdateElement.cityID = this.a.getInt(DataBaseHelper.KEY_ID);
        mKOLUpdateElement.size = this.a.getInt("size");
        mKOLUpdateElement.ratio = this.a.getInt("ratio");
        if (mKOLUpdateElement.ratio == 10000) {
            mKOLUpdateElement.ratio = 100;
        }
        mKOLUpdateElement.geoPt = new GeoPoint(this.a.getInt("citypty"), this.a.getInt("cityptx"));
        mKOLUpdateElement.serversize = this.a.getInt("serversize");
        mKOLUpdateElement.status = this.a.getInt("state");
        return mKOLUpdateElement;
    }

    public boolean init(BMapManager bMapManager, MKOfflineMapListener mKOfflineMapListener) {
        if (bMapManager == null || !a()) {
            return false;
        }
        if (mKOfflineMapListener != null) {
            bMapManager.a.a(mKOfflineMapListener);
        }
        return Mj.initOfflineCC() == 1;
    }

    public boolean pause(int i) {
        Bundle bundle = this.a;
        if (bundle == null) {
            this.a = new Bundle();
        } else {
            bundle.clear();
        }
        this.a.putInt("act", 16010200);
        this.a.putInt("opt", i);
        return Mj.sendBundle(this.a) != 0;
    }

    public boolean remove(int i) {
        Bundle bundle = this.a;
        if (bundle == null) {
            this.a = new Bundle();
        } else {
            bundle.clear();
        }
        this.a.putInt("act", 16010300);
        this.a.putInt("opt", i);
        return Mj.sendBundle(this.a) != 0;
    }

    public int scan() {
        Bundle bundle = this.a;
        if (bundle == null) {
            this.a = new Bundle();
        } else {
            bundle.clear();
        }
        this.a.putInt("act", 16011500);
        if (Mj.sendBundle(this.a) == 0) {
            return 0;
        }
        return this.a.getInt("num");
    }

    public ArrayList<MKOLSearchRecord> searchCity(String str) {
        Bundle bundle = this.a;
        if (bundle == null) {
            this.a = new Bundle();
        } else {
            bundle.clear();
        }
        this.a.putInt("act", 16011100);
        this.a.putString("key", str);
        ArrayList<MKOLSearchRecord> arrayList = null;
        if (Mj.sendBundle(this.a) == 0) {
            return null;
        }
        String[] stringArray = this.a.getStringArray(DataBaseHelper.KEY_NAME);
        int[] intArray = this.a.getIntArray(DataBaseHelper.KEY_ID);
        int[] intArray2 = this.a.getIntArray("size");
        if (!(stringArray == null || intArray == null || intArray2 == null)) {
            arrayList = new ArrayList<>();
            for (int i = 0; i < stringArray.length; i++) {
                MKOLSearchRecord mKOLSearchRecord = new MKOLSearchRecord();
                mKOLSearchRecord.cityName = stringArray[i];
                mKOLSearchRecord.cityID = intArray[i];
                mKOLSearchRecord.size = intArray2[i];
                arrayList.add(mKOLSearchRecord);
            }
        }
        return arrayList;
    }

    public boolean start(int i) {
        int i2;
        Bundle bundle;
        Bundle bundle2 = this.a;
        if (bundle2 == null) {
            this.a = new Bundle();
        } else {
            bundle2.clear();
        }
        this.a.putInt("act", 16010500);
        String str = "opt";
        this.a.putInt(str, i);
        if (Mj.sendBundle(this.a) != 0) {
            int i3 = this.a.getInt("state");
            if (i3 != 1) {
                i2 = 2;
                if (i3 != 2) {
                    if (i3 != 3) {
                        i2 = 0;
                    }
                }
            }
            this.a.clear();
            this.a.putInt("act", 16011400);
            Mj.sendBundle(this.a);
            return true;
        }
        this.a.clear();
        this.a.putInt("act", 16011300);
        this.a.putInt(str, i);
        i2 = Mj.sendBundle(this.a);
        if (i2 == 0) {
            return false;
        }
        this.a.clear();
        if (i2 == 1) {
            this.a.putInt(str, 11010108);
            this.a.putInt("act", 11010203);
            bundle = this.a;
            str = "cityid";
        } else {
            this.a.putInt("act", 16010100);
            bundle = this.a;
        }
        bundle.putInt(str, i);
        return Mj.sendBundle(this.a) != 0;
    }
}
