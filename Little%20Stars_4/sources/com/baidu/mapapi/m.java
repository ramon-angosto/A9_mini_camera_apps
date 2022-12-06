package com.baidu.mapapi;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import object.p2pipcam.utils.DataBaseHelper;

class m implements j {
    private MKSearchListener a;

    public m(MKSearchListener mKSearchListener) {
        this.a = mKSearchListener;
    }

    private int a(Bundle bundle, MKRouteAddrResult mKRouteAddrResult) {
        Parcelable[] parcelableArray = bundle.getParcelableArray("aryAddr");
        Bundle bundle2 = (Bundle) parcelableArray[0];
        if (bundle2 != null) {
            ArrayList<MKPoiInfo> arrayList = new ArrayList<>();
            a(bundle2, arrayList);
            mKRouteAddrResult.mStartPoiList = arrayList;
        }
        Bundle bundle3 = (Bundle) parcelableArray[1];
        if (bundle3 != null) {
            ArrayList<MKCityListInfo> arrayList2 = new ArrayList<>();
            b(bundle3, arrayList2);
            mKRouteAddrResult.mStartCityList = arrayList2;
        }
        Bundle bundle4 = (Bundle) parcelableArray[2];
        if (bundle4 != null) {
            ArrayList<MKPoiInfo> arrayList3 = new ArrayList<>();
            a(bundle4, arrayList3);
            mKRouteAddrResult.mEndPoiList = arrayList3;
        }
        Bundle bundle5 = (Bundle) parcelableArray[3];
        if (bundle5 != null) {
            ArrayList<MKCityListInfo> arrayList4 = new ArrayList<>();
            b(bundle5, arrayList4);
            mKRouteAddrResult.mEndCityList = arrayList4;
        }
        return bundle.getInt(DataBaseHelper.KEY_TYPE);
    }

    private void a(Bundle bundle, MKAddrInfo mKAddrInfo) {
        mKAddrInfo.strAddr = bundle.getString("addr");
        mKAddrInfo.geoPt = new GeoPoint(bundle.getInt("y"), bundle.getInt("x"));
    }

    private void a(Bundle bundle, MKAddrInfo mKAddrInfo, int i) {
        Bundle bundle2 = bundle;
        MKAddrInfo mKAddrInfo2 = mKAddrInfo;
        mKAddrInfo2.strAddr = bundle2.getString("addr");
        mKAddrInfo2.strBusiness = bundle2.getString("business");
        mKAddrInfo2.addressComponents = new MKGeocoderAddressComponent();
        mKAddrInfo2.addressComponents.streetNumber = bundle2.getString("streetNumber");
        mKAddrInfo2.addressComponents.street = bundle2.getString("street");
        mKAddrInfo2.addressComponents.district = bundle2.getString("district");
        mKAddrInfo2.addressComponents.city = bundle2.getString("city");
        mKAddrInfo2.addressComponents.province = bundle2.getString("province");
        mKAddrInfo2.geoPt = new GeoPoint(bundle2.getInt("y"), bundle2.getInt("x"));
        if (bundle2.containsKey("aryCaption")) {
            String[] stringArray = bundle2.getStringArray("aryCaption");
            String[] stringArray2 = bundle2.getStringArray("aryAddr");
            String[] stringArray3 = bundle2.getStringArray("aryTel");
            String[] stringArray4 = bundle2.getStringArray("aryZip");
            int[] intArray = bundle2.getIntArray("aryType");
            int[] intArray2 = bundle2.getIntArray("aryX");
            int[] intArray3 = bundle2.getIntArray("aryY");
            String string = bundle2.getString("city");
            ArrayList<MKPoiInfo> arrayList = new ArrayList<>();
            int length = stringArray.length;
            for (int i2 = 0; i2 < length; i2++) {
                MKPoiInfo mKPoiInfo = new MKPoiInfo();
                mKPoiInfo.name = stringArray[i2];
                mKPoiInfo.address = stringArray2[i2];
                mKPoiInfo.city = string;
                mKPoiInfo.phoneNum = stringArray3[i2];
                mKPoiInfo.postCode = stringArray4[i2];
                mKPoiInfo.ePoiType = intArray[i2];
                mKPoiInfo.pt = new GeoPoint(intArray3[i2], intArray2[i2]);
                arrayList.add(mKPoiInfo);
            }
            mKAddrInfo2.poiList = arrayList;
        }
    }

    private void a(Bundle bundle, MKDrivingRouteResult mKDrivingRouteResult, int i) {
        MKPlanNode mKPlanNode;
        MKPlanNode mKPlanNode2;
        String str;
        String str2;
        Parcelable[] parcelableArr;
        int i2;
        int[] iArr;
        int[] iArr2;
        Bundle bundle2 = bundle;
        MKDrivingRouteResult mKDrivingRouteResult2 = mKDrivingRouteResult;
        String str3 = "link";
        String str4 = "distance";
        try {
            String string = bundle2.getString("st_name");
            int i3 = bundle2.getInt("st_pt_x");
            int i4 = bundle2.getInt("st_pt_y");
            MKPlanNode mKPlanNode3 = new MKPlanNode();
            mKPlanNode3.name = string;
            mKPlanNode3.pt = new GeoPoint(i4, i3);
            mKDrivingRouteResult2.a(mKPlanNode3);
            String string2 = bundle2.getString("en_name");
            int i5 = bundle2.getInt("en_pt_x");
            int i6 = bundle2.getInt("en_pt_y");
            MKPlanNode mKPlanNode4 = new MKPlanNode();
            mKPlanNode4.name = string2;
            mKPlanNode4.pt = new GeoPoint(i6, i5);
            mKDrivingRouteResult2.b(mKPlanNode4);
            ArrayList arrayList = new ArrayList();
            if (bundle2.getInt("planNum") > 0) {
                MKRoutePlan mKRoutePlan = new MKRoutePlan();
                mKRoutePlan.a(bundle2.getInt(str4));
                ArrayList arrayList2 = new ArrayList();
                Parcelable[] parcelableArray = bundle2.getParcelableArray("aryRoute");
                int i7 = 0;
                while (i7 < parcelableArray.length) {
                    MKRoute mKRoute = new MKRoute();
                    Bundle bundle3 = (Bundle) parcelableArray[i7];
                    mKRoute.a(bundle3.getInt(str4));
                    mKRoute.b(1);
                    mKRoute.a(mKPlanNode3.pt);
                    mKRoute.b(mKPlanNode4.pt);
                    if (bundle3.containsKey(str3)) {
                        int i8 = bundle3.getInt(str3);
                        ArrayList arrayList3 = new ArrayList();
                        ArrayList<ArrayList<GeoPoint>> arrayList4 = new ArrayList<>();
                        parcelableArr = parcelableArray;
                        int i9 = 0;
                        while (i9 < i8) {
                            String str5 = str3;
                            String str6 = str4;
                            MKPlanNode mKPlanNode5 = mKPlanNode3;
                            int[] intArray = bundle3.getIntArray(String.format("aryX%d", new Object[]{Integer.valueOf(i9)}));
                            MKPlanNode mKPlanNode6 = mKPlanNode4;
                            int[] intArray2 = bundle3.getIntArray(String.format("aryY%d", new Object[]{Integer.valueOf(i9)}));
                            if (intArray == null) {
                                i2 = i8;
                            } else {
                                ArrayList arrayList5 = new ArrayList();
                                i2 = i8;
                                int i10 = 0;
                                while (i10 < intArray.length) {
                                    if (i10 != 0) {
                                        int i11 = i10 - 1;
                                        if (intArray2[i10] == intArray2[i11] && intArray[i10] == intArray[i11]) {
                                            iArr2 = intArray2;
                                            i10++;
                                            MKDrivingRouteResult mKDrivingRouteResult3 = mKDrivingRouteResult;
                                            intArray2 = iArr2;
                                        }
                                    }
                                    iArr2 = intArray2;
                                    arrayList5.add(new GeoPoint(intArray2[i10], intArray[i10]));
                                    i10++;
                                    MKDrivingRouteResult mKDrivingRouteResult32 = mKDrivingRouteResult;
                                    intArray2 = iArr2;
                                }
                                arrayList3.add(arrayList5);
                                int[] intArray3 = bundle3.getIntArray(String.format("aryMcX%d", new Object[]{Integer.valueOf(i9)}));
                                int[] intArray4 = bundle3.getIntArray(String.format("aryMcY%d", new Object[]{Integer.valueOf(i9)}));
                                if (intArray3 != null) {
                                    ArrayList arrayList6 = new ArrayList();
                                    int i12 = 0;
                                    while (i12 < intArray3.length) {
                                        if (i12 != 0) {
                                            int i13 = i12 - 1;
                                            if (intArray4[i12] == intArray4[i13] && intArray3[i12] == intArray3[i13]) {
                                                iArr = intArray4;
                                                i12++;
                                                intArray4 = iArr;
                                            }
                                        }
                                        iArr = intArray4;
                                        arrayList6.add(new GeoPoint(intArray4[i12], intArray3[i12]));
                                        i12++;
                                        intArray4 = iArr;
                                    }
                                    arrayList4.add(arrayList6);
                                }
                            }
                            i9++;
                            MKDrivingRouteResult mKDrivingRouteResult4 = mKDrivingRouteResult;
                            str3 = str5;
                            str4 = str6;
                            mKPlanNode3 = mKPlanNode5;
                            mKPlanNode4 = mKPlanNode6;
                            i8 = i2;
                        }
                        str2 = str3;
                        str = str4;
                        mKPlanNode2 = mKPlanNode3;
                        mKPlanNode = mKPlanNode4;
                        mKRoute.b((ArrayList<ArrayList<GeoPoint>>) arrayList3);
                        mKRoute.a = arrayList4;
                    } else {
                        parcelableArr = parcelableArray;
                        str2 = str3;
                        str = str4;
                        mKPlanNode2 = mKPlanNode3;
                        mKPlanNode = mKPlanNode4;
                    }
                    if (bundle3.containsKey("aryStep")) {
                        ArrayList arrayList7 = new ArrayList();
                        Parcelable[] parcelableArray2 = bundle3.getParcelableArray("aryStep");
                        for (Parcelable parcelable : parcelableArray2) {
                            Bundle bundle4 = (Bundle) parcelable;
                            MKStep mKStep = new MKStep();
                            mKStep.a(new GeoPoint(bundle4.getInt("y"), bundle4.getInt("x")));
                            mKStep.a(bundle4.getInt("dir"));
                            mKStep.a(bundle4.getString("tip"));
                            arrayList7.add(mKStep);
                        }
                        mKRoute.a((ArrayList<MKStep>) arrayList7);
                    }
                    arrayList2.add(mKRoute);
                    i7++;
                    MKDrivingRouteResult mKDrivingRouteResult5 = mKDrivingRouteResult;
                    parcelableArray = parcelableArr;
                    str3 = str2;
                    str4 = str;
                    mKPlanNode3 = mKPlanNode2;
                    mKPlanNode4 = mKPlanNode;
                }
                mKRoutePlan.a((ArrayList<MKRoute>) arrayList2);
                arrayList.add(mKRoutePlan);
            }
            mKDrivingRouteResult.a((ArrayList<MKRoutePlan>) arrayList);
        } catch (Exception e) {
            Log.d("MKSearchNotifier", "parse DrivingRouteResult error!");
            Log.d("MKSearchNotifier", e.getMessage());
        }
    }

    private void a(Bundle bundle, MKPoiResult mKPoiResult, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i2;
        ArrayList arrayList;
        Bundle bundle2 = bundle;
        MKPoiResult mKPoiResult2 = mKPoiResult;
        int i3 = i;
        if (i3 != 7) {
            String str7 = "city";
            String str8 = "aryY";
            String str9 = "aryX";
            String str10 = "iCurrNumPois";
            String str11 = "parse PoiResult error!";
            String str12 = "iTotal";
            if (i3 != 21) {
                if (i3 == 45) {
                    Parcelable[] parcelableArray = bundle2.getParcelableArray("aryMultiPoiList");
                    if (parcelableArray != null) {
                        int length = parcelableArray.length;
                        ArrayList arrayList2 = new ArrayList();
                        int i4 = 0;
                        while (i4 < length) {
                            int i5 = length;
                            MKPoiResult mKPoiResult3 = new MKPoiResult();
                            Parcelable[] parcelableArr = parcelableArray;
                            Bundle bundle3 = (Bundle) parcelableArray[i4];
                            if (bundle3 == null) {
                                arrayList2.add(mKPoiResult3);
                                i2 = i4;
                                str6 = str12;
                                arrayList = arrayList2;
                                str5 = str10;
                                str4 = str7;
                                str3 = str8;
                                str2 = str9;
                            } else {
                                i2 = i4;
                                ArrayList arrayList3 = new ArrayList();
                                ArrayList arrayList4 = arrayList2;
                                int i6 = bundle3.getInt(str12);
                                str6 = str12;
                                int i7 = bundle3.getInt(str10);
                                str5 = str10;
                                int i8 = bundle2.getInt("iPageIndex");
                                mKPoiResult3.b(i6);
                                mKPoiResult3.a(i7);
                                mKPoiResult3.d(i8);
                                int poiPageCapacity = i6 / MKSearch.getPoiPageCapacity();
                                if (i6 % MKSearch.getPoiPageCapacity() > 0) {
                                    poiPageCapacity++;
                                }
                                mKPoiResult3.c(poiPageCapacity);
                                String[] stringArray = bundle3.getStringArray("aryCaption");
                                String[] stringArray2 = bundle3.getStringArray("aryAddr");
                                String[] stringArray3 = bundle3.getStringArray("aryTel");
                                String[] stringArray4 = bundle3.getStringArray("aryZip");
                                int[] intArray = bundle3.getIntArray("aryType");
                                int[] intArray2 = bundle3.getIntArray(str9);
                                int[] intArray3 = bundle3.getIntArray(str8);
                                String string = bundle3.getString(str7);
                                str4 = str7;
                                int length2 = stringArray.length;
                                str3 = str8;
                                int i9 = 0;
                                while (i9 < length2) {
                                    int i10 = length2;
                                    MKPoiInfo mKPoiInfo = new MKPoiInfo();
                                    mKPoiInfo.name = stringArray[i9];
                                    mKPoiInfo.address = stringArray2[i9];
                                    mKPoiInfo.city = string;
                                    mKPoiInfo.phoneNum = stringArray3[i9];
                                    mKPoiInfo.postCode = stringArray4[i9];
                                    mKPoiInfo.ePoiType = intArray[i9];
                                    mKPoiInfo.pt = new GeoPoint(intArray3[i9], intArray2[i9]);
                                    arrayList3.add(mKPoiInfo);
                                    i9++;
                                    length2 = i10;
                                    str9 = str9;
                                    string = string;
                                    stringArray = stringArray;
                                }
                                str2 = str9;
                                mKPoiResult3.a((ArrayList<MKPoiInfo>) arrayList3);
                                arrayList = arrayList4;
                                arrayList.add(mKPoiResult3);
                            }
                            arrayList2 = arrayList;
                            i4 = i2 + 1;
                            length = i5;
                            str12 = str6;
                            str10 = str5;
                            str7 = str4;
                            str8 = str3;
                            str9 = str2;
                            parcelableArray = parcelableArr;
                        }
                        mKPoiResult.b((ArrayList<MKPoiResult>) arrayList2);
                        return;
                    }
                    return;
                } else if (!(i3 == 11 || i3 == 12)) {
                    return;
                }
            }
            MKPoiResult mKPoiResult4 = mKPoiResult2;
            String str13 = str10;
            String str14 = str7;
            String str15 = str8;
            String str16 = str9;
            try {
                int i11 = bundle2.getInt(str12);
                int i12 = bundle2.getInt(str13);
                int i13 = bundle2.getInt("iPageIndex");
                mKPoiResult4.b(i11);
                mKPoiResult4.a(i12);
                mKPoiResult4.d(i13);
                int poiPageCapacity2 = i11 / MKSearch.getPoiPageCapacity();
                if (i11 % MKSearch.getPoiPageCapacity() > 0) {
                    poiPageCapacity2++;
                }
                mKPoiResult4.c(poiPageCapacity2);
                String[] stringArray5 = bundle2.getStringArray("aryCaption");
                String[] stringArray6 = bundle2.getStringArray("aryUid");
                String[] stringArray7 = bundle2.getStringArray("aryAddr");
                String[] stringArray8 = bundle2.getStringArray("aryTel");
                String[] stringArray9 = bundle2.getStringArray("aryZip");
                int[] intArray4 = bundle2.getIntArray("aryType");
                int[] intArray5 = bundle2.getIntArray(str16);
                int[] intArray6 = bundle2.getIntArray(str15);
                String[] stringArray10 = bundle2.getStringArray("srcName");
                String string2 = bundle2.getString(str14);
                ArrayList arrayList5 = new ArrayList();
                int i14 = 0;
                for (int length3 = stringArray5.length; i14 < length3; length3 = length3) {
                    MKPoiInfo mKPoiInfo2 = new MKPoiInfo();
                    mKPoiInfo2.name = stringArray5[i14];
                    mKPoiInfo2.address = stringArray7[i14];
                    mKPoiInfo2.uid = stringArray6[i14];
                    mKPoiInfo2.city = string2;
                    mKPoiInfo2.phoneNum = stringArray8[i14];
                    mKPoiInfo2.postCode = stringArray9[i14];
                    mKPoiInfo2.ePoiType = intArray4[i14];
                    mKPoiInfo2.hasCaterDetails = "cater".equals(stringArray10[i14]);
                    mKPoiInfo2.pt = new GeoPoint(intArray6[i14], intArray5[i14]);
                    arrayList5.add(mKPoiInfo2);
                    i14++;
                    string2 = string2;
                    stringArray5 = stringArray5;
                }
                mKPoiResult4.a((ArrayList<MKPoiInfo>) arrayList5);
            } catch (Exception e) {
                e = e;
                str = str11;
                Log.d("MKSearchNotifier", str);
                Log.d("MKSearchNotifier", e.getMessage());
            }
        } else {
            MKPoiResult mKPoiResult5 = mKPoiResult2;
            str = "parse PoiResult error!";
            try {
                String[] stringArray11 = bundle2.getStringArray("aryCity");
                int[] intArray7 = bundle2.getIntArray("aryNum");
                ArrayList arrayList6 = new ArrayList();
                int length4 = stringArray11.length;
                for (int i15 = 0; i15 < length4; i15++) {
                    MKCityListInfo mKCityListInfo = new MKCityListInfo();
                    mKCityListInfo.city = stringArray11[i15];
                    mKCityListInfo.num = intArray7[i15];
                    arrayList6.add(mKCityListInfo);
                }
                mKPoiResult5.c((ArrayList<MKCityListInfo>) arrayList6);
            } catch (Exception e2) {
                e = e2;
                Log.d("MKSearchNotifier", str);
                Log.d("MKSearchNotifier", e.getMessage());
            }
        }
    }

    private void a(Bundle bundle, MKSuggestionResult mKSuggestionResult, int i) {
        try {
            String[] stringArray = bundle.getStringArray("aryPoiName");
            String[] stringArray2 = bundle.getStringArray("aryCityName");
            ArrayList arrayList = new ArrayList();
            int length = stringArray != null ? stringArray.length : 0;
            for (int i2 = 0; i2 < length; i2++) {
                MKSuggestionInfo mKSuggestionInfo = new MKSuggestionInfo();
                mKSuggestionInfo.city = stringArray2[i2];
                mKSuggestionInfo.key = stringArray[i2];
                arrayList.add(mKSuggestionInfo);
            }
            mKSuggestionResult.a(arrayList);
            mKSuggestionResult.getSuggestionNum();
        } catch (Exception unused) {
            Log.d("MKSearchNotifier", "parse SuggestionResult error!");
        }
    }

    private void a(Bundle bundle, MKTransitRouteResult mKTransitRouteResult, int i) {
        Parcelable[] parcelableArr;
        MKPlanNode mKPlanNode;
        MKPlanNode mKPlanNode2;
        String str;
        String str2;
        int i2;
        Parcelable[] parcelableArr2;
        String str3;
        String str4;
        String str5;
        int[] iArr;
        String str6;
        String str7;
        String str8;
        String str9;
        Bundle bundle2 = bundle;
        MKTransitRouteResult mKTransitRouteResult2 = mKTransitRouteResult;
        String str10 = "getOffStopPtX";
        String str11 = "endX";
        String str12 = "getOnStopPtX";
        String str13 = "startX";
        String str14 = "distance";
        try {
            String string = bundle2.getString("st_name");
            int i3 = bundle2.getInt("st_pt_x");
            int i4 = bundle2.getInt("st_pt_y");
            MKPlanNode mKPlanNode3 = new MKPlanNode();
            mKPlanNode3.name = string;
            mKPlanNode3.pt = new GeoPoint(i4, i3);
            mKTransitRouteResult2.a(mKPlanNode3);
            String string2 = bundle2.getString("en_name");
            int i5 = bundle2.getInt("en_pt_x");
            int i6 = bundle2.getInt("en_pt_y");
            MKPlanNode mKPlanNode4 = new MKPlanNode();
            mKPlanNode4.name = string2;
            mKPlanNode4.pt = new GeoPoint(i6, i5);
            mKTransitRouteResult2.b(mKPlanNode4);
            ArrayList arrayList = new ArrayList();
            Parcelable[] parcelableArray = bundle2.getParcelableArray("aryPlan");
            if (parcelableArray == null) {
                mKTransitRouteResult2.a((ArrayList<MKTransitRoutePlan>) arrayList);
                return;
            }
            int length = parcelableArray.length;
            int i7 = 0;
            while (i7 < length) {
                MKTransitRoutePlan mKTransitRoutePlan = new MKTransitRoutePlan();
                mKTransitRoutePlan.a(mKPlanNode3.pt);
                mKTransitRoutePlan.b(mKPlanNode4.pt);
                Bundle bundle3 = (Bundle) parcelableArray[i7];
                mKTransitRoutePlan.a(bundle3.getInt(str14));
                ArrayList arrayList2 = new ArrayList();
                Parcelable[] parcelableArray2 = bundle3.getParcelableArray("aryLine");
                if (parcelableArray2 == null) {
                    parcelableArr = parcelableArray;
                    parcelableArray2 = new Parcelable[0];
                } else {
                    parcelableArr = parcelableArray;
                }
                int i8 = length;
                int i9 = 0;
                while (true) {
                    mKPlanNode = mKPlanNode3;
                    mKPlanNode2 = mKPlanNode4;
                    str = "aryY";
                    str2 = "aryMcX";
                    i2 = i7;
                    if (i9 >= parcelableArray2.length) {
                        break;
                    }
                    MKLine mKLine = new MKLine();
                    Parcelable[] parcelableArr3 = parcelableArray2;
                    Bundle bundle4 = (Bundle) parcelableArray2[i9];
                    ArrayList arrayList3 = arrayList;
                    mKLine.b(bundle4.getInt(str14));
                    mKLine.c(bundle4.getInt(DataBaseHelper.KEY_TYPE));
                    mKLine.a(bundle4.getInt("numStops"));
                    mKLine.b(bundle4.getString(PushConstants.TITLE));
                    mKLine.c(bundle4.getString("uid"));
                    mKLine.a(bundle4.getString("getOnTip"));
                    MKPoiInfo mKPoiInfo = new MKPoiInfo();
                    String str15 = str11;
                    mKPoiInfo.name = bundle4.getString("getOnStopName");
                    if (bundle4.containsKey(str12)) {
                        str7 = str12;
                        str6 = str13;
                        mKPoiInfo.pt = new GeoPoint(bundle4.getInt("getOnStopPtY"), bundle4.getInt(str12));
                    } else {
                        str7 = str12;
                        str6 = str13;
                    }
                    mKLine.a(mKPoiInfo);
                    MKPoiInfo mKPoiInfo2 = new MKPoiInfo();
                    mKPoiInfo2.name = bundle4.getString("getOffStopName");
                    if (bundle4.containsKey(str10)) {
                        mKPoiInfo2.pt = new GeoPoint(bundle4.getInt("getOffStopPtY"), bundle4.getInt(str10));
                    }
                    mKLine.b(mKPoiInfo2);
                    int[] intArray = bundle4.getIntArray("aryX");
                    if (intArray != null) {
                        ArrayList arrayList4 = new ArrayList();
                        int[] intArray2 = bundle4.getIntArray(str);
                        int i10 = 0;
                        while (i10 < intArray.length) {
                            if (i10 != 0) {
                                int i11 = i10 - 1;
                                str9 = str10;
                                if (intArray2[i10] == intArray2[i11] && intArray[i10] == intArray[i11]) {
                                    i10++;
                                    str10 = str9;
                                }
                            } else {
                                str9 = str10;
                            }
                            arrayList4.add(new GeoPoint(intArray2[i10], intArray[i10]));
                            i10++;
                            str10 = str9;
                        }
                        str8 = str10;
                        mKLine.a((ArrayList<GeoPoint>) arrayList4);
                    } else {
                        str8 = str10;
                    }
                    int[] intArray3 = bundle4.getIntArray(str2);
                    if (intArray3 != null) {
                        ArrayList<GeoPoint> arrayList5 = new ArrayList<>();
                        int[] intArray4 = bundle4.getIntArray("aryMcY");
                        for (int i12 = 0; i12 < intArray3.length; i12++) {
                            if (i12 != 0) {
                                int i13 = i12 - 1;
                                if (intArray4[i12] == intArray4[i13] && intArray3[i12] == intArray3[i13]) {
                                }
                            }
                            arrayList5.add(new GeoPoint(intArray4[i12], intArray3[i12]));
                        }
                        mKLine.a = arrayList5;
                    }
                    arrayList2.add(mKLine);
                    i9++;
                    MKTransitRouteResult mKTransitRouteResult3 = mKTransitRouteResult;
                    mKPlanNode3 = mKPlanNode;
                    mKPlanNode4 = mKPlanNode2;
                    i7 = i2;
                    arrayList = arrayList3;
                    parcelableArray2 = parcelableArr3;
                    str11 = str15;
                    str12 = str7;
                    str13 = str6;
                    str10 = str8;
                }
                String str16 = str10;
                String str17 = str11;
                String str18 = str12;
                String str19 = str13;
                ArrayList arrayList6 = arrayList;
                mKTransitRoutePlan.setLine(arrayList2);
                ArrayList arrayList7 = new ArrayList();
                Parcelable[] parcelableArray3 = bundle3.getParcelableArray("aryRoute");
                if (parcelableArray3 == null) {
                    parcelableArray3 = new Parcelable[0];
                }
                int i14 = 0;
                while (i14 < parcelableArray3.length) {
                    MKRoute mKRoute = new MKRoute();
                    Bundle bundle5 = (Bundle) parcelableArray3[i14];
                    mKRoute.a(bundle5.getInt(str14));
                    mKRoute.b(2);
                    mKRoute.a(bundle5.getString("getOffTip"));
                    ArrayList arrayList8 = new ArrayList();
                    ArrayList arrayList9 = new ArrayList();
                    String str20 = str19;
                    if (bundle5.containsKey(str20)) {
                        parcelableArr2 = parcelableArray3;
                        mKRoute.a(new GeoPoint(bundle5.getInt("startY"), bundle5.getInt(str20)));
                    } else {
                        parcelableArr2 = parcelableArray3;
                    }
                    if (bundle5.containsKey("aryX")) {
                        int[] intArray5 = bundle5.getIntArray("aryX");
                        int[] intArray6 = bundle5.getIntArray(str);
                        str3 = str14;
                        int i15 = 0;
                        while (i15 < intArray5.length) {
                            if (i15 != 0) {
                                int i16 = i15 - 1;
                                str5 = str;
                                if (intArray6[i15] == intArray6[i16] && intArray5[i15] == intArray5[i16]) {
                                    iArr = intArray6;
                                    i15++;
                                    intArray6 = iArr;
                                    str = str5;
                                }
                            } else {
                                str5 = str;
                            }
                            iArr = intArray6;
                            arrayList8.add(new GeoPoint(intArray6[i15], intArray5[i15]));
                            i15++;
                            intArray6 = iArr;
                            str = str5;
                        }
                    } else {
                        str3 = str14;
                    }
                    String str21 = str;
                    if (bundle5.containsKey(str2)) {
                        int[] intArray7 = bundle5.getIntArray(str2);
                        int[] intArray8 = bundle5.getIntArray("aryMcY");
                        int i17 = 0;
                        while (i17 < intArray7.length) {
                            if (i17 != 0) {
                                int i18 = i17 - 1;
                                str4 = str2;
                                if (intArray8[i17] == intArray8[i18] && intArray7[i17] == intArray7[i18]) {
                                    i17++;
                                    str2 = str4;
                                }
                            } else {
                                str4 = str2;
                            }
                            arrayList9.add(new GeoPoint(intArray8[i17], intArray7[i17]));
                            i17++;
                            str2 = str4;
                        }
                    }
                    String str22 = str2;
                    String str23 = str17;
                    if (bundle5.containsKey(str23)) {
                        mKRoute.b(new GeoPoint(bundle5.getInt("endY"), bundle5.getInt(str23)));
                    }
                    ArrayList arrayList10 = new ArrayList();
                    arrayList10.add(arrayList8);
                    mKRoute.b((ArrayList<ArrayList<GeoPoint>>) arrayList10);
                    ArrayList<ArrayList<GeoPoint>> arrayList11 = new ArrayList<>();
                    arrayList11.add(arrayList9);
                    mKRoute.a = arrayList11;
                    arrayList7.add(mKRoute);
                    i14++;
                    str17 = str23;
                    parcelableArray3 = parcelableArr2;
                    str14 = str3;
                    str2 = str22;
                    str = str21;
                    str19 = str20;
                }
                mKTransitRoutePlan.a((ArrayList<MKRoute>) arrayList7);
                ArrayList arrayList12 = arrayList6;
                arrayList12.add(mKTransitRoutePlan);
                i7 = i2 + 1;
                arrayList = arrayList12;
                str11 = str17;
                str13 = str19;
                length = i8;
                mKPlanNode3 = mKPlanNode;
                mKPlanNode4 = mKPlanNode2;
                str12 = str18;
                str14 = str14;
                str10 = str16;
                mKTransitRouteResult2 = mKTransitRouteResult;
                parcelableArray = parcelableArr;
            }
            mKTransitRouteResult2.a((ArrayList<MKTransitRoutePlan>) arrayList);
        } catch (Exception e) {
            Log.d("MKSearchNotifier", "parse TransitRouteResult error!");
            Log.d("MKSearchNotifier", e.getMessage());
        }
    }

    private void a(Bundle bundle, MKWalkingRouteResult mKWalkingRouteResult, int i) {
        ArrayList arrayList;
        Parcelable[] parcelableArr;
        ArrayList arrayList2;
        MKPlanNode mKPlanNode;
        MKPlanNode mKPlanNode2;
        String str;
        String str2;
        ArrayList arrayList3;
        int i2;
        ArrayList arrayList4;
        int[] iArr;
        Bundle bundle2 = bundle;
        MKWalkingRouteResult mKWalkingRouteResult2 = mKWalkingRouteResult;
        String str3 = "link";
        String str4 = "distance";
        try {
            String string = bundle2.getString("st_name");
            int i3 = bundle2.getInt("st_pt_x");
            int i4 = bundle2.getInt("st_pt_y");
            MKPlanNode mKPlanNode3 = new MKPlanNode();
            mKPlanNode3.name = string;
            mKPlanNode3.pt = new GeoPoint(i4, i3);
            mKWalkingRouteResult2.a(mKPlanNode3);
            String string2 = bundle2.getString("en_name");
            int i5 = bundle2.getInt("en_pt_x");
            int i6 = bundle2.getInt("en_pt_y");
            MKPlanNode mKPlanNode4 = new MKPlanNode();
            mKPlanNode4.name = string2;
            mKPlanNode4.pt = new GeoPoint(i6, i5);
            mKWalkingRouteResult2.b(mKPlanNode4);
            ArrayList arrayList5 = new ArrayList();
            if (bundle2.getInt("planNum") > 0) {
                MKRoutePlan mKRoutePlan = new MKRoutePlan();
                mKRoutePlan.a(bundle2.getInt(str4));
                ArrayList arrayList6 = new ArrayList();
                Parcelable[] parcelableArray = bundle2.getParcelableArray("aryRoute");
                int i7 = 0;
                while (i7 < parcelableArray.length) {
                    MKRoute mKRoute = new MKRoute();
                    Bundle bundle3 = (Bundle) parcelableArray[i7];
                    mKRoute.a(bundle3.getInt(str4));
                    mKRoute.b(2);
                    mKRoute.a(mKPlanNode3.pt);
                    mKRoute.b(mKPlanNode4.pt);
                    if (bundle3.containsKey(str3)) {
                        int i8 = bundle3.getInt(str3);
                        ArrayList arrayList7 = new ArrayList();
                        ArrayList<ArrayList<GeoPoint>> arrayList8 = new ArrayList<>();
                        parcelableArr = parcelableArray;
                        int i9 = 0;
                        while (i9 < i8) {
                            String str5 = str3;
                            String str6 = str4;
                            MKPlanNode mKPlanNode5 = mKPlanNode3;
                            int[] intArray = bundle3.getIntArray(String.format("aryX%d", new Object[]{Integer.valueOf(i9)}));
                            MKPlanNode mKPlanNode6 = mKPlanNode4;
                            int[] intArray2 = bundle3.getIntArray(String.format("aryY%d", new Object[]{Integer.valueOf(i9)}));
                            if (intArray == null) {
                                arrayList3 = arrayList5;
                                i2 = i8;
                            } else {
                                ArrayList arrayList9 = new ArrayList();
                                i2 = i8;
                                int i10 = 0;
                                while (i10 < intArray.length) {
                                    if (i10 != 0) {
                                        int i11 = i10 - 1;
                                        if (intArray2[i10] == intArray2[i11] && intArray[i10] == intArray[i11]) {
                                            iArr = intArray2;
                                            i10++;
                                            MKWalkingRouteResult mKWalkingRouteResult3 = mKWalkingRouteResult;
                                            intArray2 = iArr;
                                        }
                                    }
                                    iArr = intArray2;
                                    arrayList9.add(new GeoPoint(intArray2[i10], intArray[i10]));
                                    i10++;
                                    MKWalkingRouteResult mKWalkingRouteResult32 = mKWalkingRouteResult;
                                    intArray2 = iArr;
                                }
                                arrayList7.add(arrayList9);
                                int[] intArray3 = bundle3.getIntArray(String.format("aryMcX%d", new Object[]{Integer.valueOf(i9)}));
                                int[] intArray4 = bundle3.getIntArray(String.format("aryMcY%d", new Object[]{Integer.valueOf(i9)}));
                                if (intArray3 == null) {
                                    arrayList3 = arrayList5;
                                } else {
                                    ArrayList arrayList10 = new ArrayList();
                                    int i12 = 0;
                                    while (i12 < intArray3.length) {
                                        if (i12 != 0) {
                                            int i13 = i12 - 1;
                                            arrayList4 = arrayList5;
                                            if (intArray4[i12] == intArray4[i13] && intArray3[i12] == intArray3[i13]) {
                                                i12++;
                                                arrayList5 = arrayList4;
                                            }
                                        } else {
                                            arrayList4 = arrayList5;
                                        }
                                        arrayList10.add(new GeoPoint(intArray4[i12], intArray3[i12]));
                                        i12++;
                                        arrayList5 = arrayList4;
                                    }
                                    arrayList3 = arrayList5;
                                    arrayList8.add(arrayList10);
                                }
                            }
                            i9++;
                            MKWalkingRouteResult mKWalkingRouteResult4 = mKWalkingRouteResult;
                            str3 = str5;
                            str4 = str6;
                            mKPlanNode3 = mKPlanNode5;
                            mKPlanNode4 = mKPlanNode6;
                            i8 = i2;
                            arrayList5 = arrayList3;
                        }
                        str2 = str3;
                        str = str4;
                        arrayList2 = arrayList5;
                        mKPlanNode2 = mKPlanNode3;
                        mKPlanNode = mKPlanNode4;
                        mKRoute.b((ArrayList<ArrayList<GeoPoint>>) arrayList7);
                        mKRoute.a = arrayList8;
                    } else {
                        parcelableArr = parcelableArray;
                        str2 = str3;
                        str = str4;
                        arrayList2 = arrayList5;
                        mKPlanNode2 = mKPlanNode3;
                        mKPlanNode = mKPlanNode4;
                    }
                    if (bundle3.containsKey("aryStep")) {
                        ArrayList arrayList11 = new ArrayList();
                        for (Parcelable parcelable : bundle3.getParcelableArray("aryStep")) {
                            Bundle bundle4 = (Bundle) parcelable;
                            MKStep mKStep = new MKStep();
                            mKStep.a(new GeoPoint(bundle4.getInt("y"), bundle4.getInt("x")));
                            mKStep.a(bundle4.getInt("dir"));
                            mKStep.a(bundle4.getString("tip"));
                            arrayList11.add(mKStep);
                        }
                        mKRoute.a((ArrayList<MKStep>) arrayList11);
                    }
                    arrayList6.add(mKRoute);
                    i7++;
                    MKWalkingRouteResult mKWalkingRouteResult5 = mKWalkingRouteResult;
                    parcelableArray = parcelableArr;
                    str3 = str2;
                    str4 = str;
                    mKPlanNode3 = mKPlanNode2;
                    mKPlanNode4 = mKPlanNode;
                    arrayList5 = arrayList2;
                }
                mKRoutePlan.a((ArrayList<MKRoute>) arrayList6);
                arrayList = arrayList5;
                arrayList.add(mKRoutePlan);
            } else {
                arrayList = arrayList5;
            }
            mKWalkingRouteResult.a((ArrayList<MKRoutePlan>) arrayList);
        } catch (Exception e) {
            Log.d("MKSearchNotifier", "parse WalkingRouteResult error!");
            Log.d("MKSearchNotifier", e.getMessage());
        }
    }

    private void a(Bundle bundle, ArrayList<MKPoiInfo> arrayList) {
        String[] stringArray = bundle.getStringArray("aryCaption");
        String[] stringArray2 = bundle.getStringArray("aryAddr");
        int[] intArray = bundle.getIntArray("aryX");
        int[] intArray2 = bundle.getIntArray("aryY");
        int length = stringArray.length;
        for (int i = 0; i < length; i++) {
            MKPoiInfo mKPoiInfo = new MKPoiInfo();
            mKPoiInfo.name = stringArray[i];
            mKPoiInfo.address = stringArray2[i];
            mKPoiInfo.pt = new GeoPoint(intArray2[i], intArray[i]);
            arrayList.add(mKPoiInfo);
        }
    }

    private boolean a(Bundle bundle, MKBusLineResult mKBusLineResult) {
        Bundle bundle2 = bundle;
        MKBusLineResult mKBusLineResult2 = mKBusLineResult;
        try {
            String string = bundle2.getString("company");
            String string2 = bundle2.getString("busName");
            String string3 = bundle2.getString("startTime");
            String string4 = bundle2.getString("endTime");
            mKBusLineResult2.a(string, string2, bundle2.getInt("monTicket"));
            mKBusLineResult2.a(string3);
            mKBusLineResult2.b(string4);
            MKRoute busRoute = mKBusLineResult.getBusRoute();
            busRoute.b(3);
            ArrayList arrayList = new ArrayList();
            ArrayList<ArrayList<GeoPoint>> arrayList2 = new ArrayList<>();
            char c = 0;
            if (!bundle2.containsKey("link")) {
                return false;
            }
            int i = bundle2.getInt("link");
            int i2 = 0;
            while (i2 < i) {
                Object[] objArr = new Object[1];
                objArr[c] = Integer.valueOf(i2);
                int[] intArray = bundle2.getIntArray(String.format("aryX%d", objArr));
                Object[] objArr2 = new Object[1];
                objArr2[c] = Integer.valueOf(i2);
                int[] intArray2 = bundle2.getIntArray(String.format("aryY%d", objArr2));
                if (intArray != null) {
                    ArrayList arrayList3 = new ArrayList();
                    int length = intArray.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        if (i3 != 0) {
                            int i4 = i3 - 1;
                            if (intArray2[i3] == intArray2[i4] && intArray[i3] == intArray[i4]) {
                            }
                        }
                        arrayList3.add(new GeoPoint(intArray2[i3], intArray[i3]));
                    }
                    arrayList.add(arrayList3);
                    int[] intArray3 = bundle2.getIntArray(String.format("aryMcX%d", new Object[]{Integer.valueOf(i2)}));
                    int[] intArray4 = bundle2.getIntArray(String.format("aryMcY%d", new Object[]{Integer.valueOf(i2)}));
                    if (intArray3 != null) {
                        ArrayList arrayList4 = new ArrayList();
                        int length2 = intArray3.length;
                        for (int i5 = 0; i5 < length2; i5++) {
                            if (i5 != 0) {
                                int i6 = i5 - 1;
                                if (intArray4[i5] == intArray4[i6] && intArray3[i5] == intArray3[i6]) {
                                }
                            }
                            arrayList4.add(new GeoPoint(intArray4[i5], intArray3[i5]));
                        }
                        arrayList2.add(arrayList4);
                    }
                }
                i2++;
                c = 0;
            }
            busRoute.b((ArrayList<ArrayList<GeoPoint>>) arrayList);
            busRoute.a = arrayList2;
            int i7 = bundle2.getInt("stopSize");
            if (!bundle2.containsKey("aryStep")) {
                return false;
            }
            ArrayList arrayList5 = new ArrayList();
            Parcelable[] parcelableArray = bundle2.getParcelableArray("aryStep");
            if (parcelableArray.length != i7) {
                return false;
            }
            for (int i8 = 0; i8 < i7; i8++) {
                Bundle bundle3 = (Bundle) parcelableArray[i8];
                MKStep mKStep = new MKStep();
                mKStep.a(new GeoPoint(bundle3.getInt("y"), bundle3.getInt("x")));
                mKStep.a(bundle3.getString(DataBaseHelper.KEY_NAME));
                arrayList5.add(mKStep);
            }
            busRoute.a((ArrayList<MKStep>) arrayList5);
            busRoute.a(((MKStep) arrayList5.get(0)).getPoint());
            busRoute.b(((MKStep) arrayList5.get(i7 - 1)).getPoint());
            return true;
        } catch (Exception e) {
            Log.d("MKSearchNotifier", "parse BusDetail error!");
            Log.d("MKSearchNotifier", e.getMessage());
        }
    }

    private void b(Bundle bundle, ArrayList<MKCityListInfo> arrayList) {
        String[] stringArray = bundle.getStringArray("aryCity");
        int[] intArray = bundle.getIntArray("aryNum");
        int length = stringArray.length;
        for (int i = 0; i < length; i++) {
            MKCityListInfo mKCityListInfo = new MKCityListInfo();
            mKCityListInfo.city = stringArray[i];
            mKCityListInfo.num = intArray[i];
            arrayList.add(mKCityListInfo);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:132:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006f, code lost:
        if (r3 == false) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b0, code lost:
        if (r3 == false) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0162, code lost:
        r8.a.onGetAddrResult((com.baidu.mapapi.MKAddrInfo) null, r9.b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0193, code lost:
        r8.a.onGetAddrResult((com.baidu.mapapi.MKAddrInfo) null, 100);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0219, code lost:
        r8.a.onGetTransitRouteResult((com.baidu.mapapi.MKTransitRouteResult) null, 100);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.baidu.mapapi.MKEvent r9) {
        /*
            r8 = this;
            int r0 = r9.a
            r1 = 11010204(0xa8009c, float:1.5428582E-38)
            r2 = 11020204(0xa827ac, float:1.5442595E-38)
            r3 = 1
            r4 = 100
            r5 = 0
            r6 = 0
            switch(r0) {
                case 1: goto L_0x021f;
                case 2: goto L_0x01f4;
                case 3: goto L_0x01c7;
                case 4: goto L_0x019a;
                case 5: goto L_0x0010;
                case 6: goto L_0x015e;
                case 7: goto L_0x0010;
                case 8: goto L_0x0010;
                case 9: goto L_0x0010;
                case 10: goto L_0x0140;
                case 11: goto L_0x00f0;
                case 12: goto L_0x0010;
                case 13: goto L_0x0278;
                case 14: goto L_0x0010;
                case 15: goto L_0x00c1;
                case 16: goto L_0x0080;
                case 17: goto L_0x0043;
                case 18: goto L_0x0012;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x0278
        L_0x0012:
            int r0 = r9.b
            if (r0 == 0) goto L_0x0021
        L_0x0016:
            com.baidu.mapapi.MKSearchListener r0 = r8.a
            int r1 = r9.c
            int r9 = r9.b
            r0.onGetPoiDetailSearchResult(r1, r9)
            goto L_0x0278
        L_0x0021:
            r0 = 11010113(0xa80041, float:1.5428454E-38)
            int r1 = r9.c
            android.os.Bundle r0 = com.baidu.mapapi.Mj.getNewBundle(r0, r1, r6)
            if (r0 == 0) goto L_0x0016
            android.content.Intent r1 = new android.content.Intent
            android.content.Context r2 = com.baidu.mapapi.BMapManager.b
            java.lang.Class<com.baidu.mapapi.PlaceCaterActivity> r3 = com.baidu.mapapi.PlaceCaterActivity.class
            r1.<init>(r2, r3)
            r1.putExtras(r0)
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            r1.addFlags(r0)
            android.content.Context r0 = com.baidu.mapapi.BMapManager.b
            r0.startActivity(r1)
            goto L_0x0016
        L_0x0043:
            int r0 = r9.b
            if (r0 == 0) goto L_0x0050
            com.baidu.mapapi.MKSearchListener r0 = r8.a
            int r9 = r9.b
            r0.onGetRGCShareUrlResult(r5, r9)
            goto L_0x0278
        L_0x0050:
            r0 = 11010110(0xa8003e, float:1.542845E-38)
            int r1 = r9.c
            android.os.Bundle r0 = com.baidu.mapapi.Mj.getNewBundle(r0, r1, r6)
            if (r0 == 0) goto L_0x0079
            java.lang.String r1 = "shortUrl"
            java.lang.String r0 = r0.getString(r1)
            int r9 = r9.c
            r1 = 500(0x1f4, float:7.0E-43)
            if (r9 != r1) goto L_0x0072
            if (r0 == 0) goto L_0x006e
            java.lang.String r9 = ""
            if (r0 == r9) goto L_0x006e
            goto L_0x006f
        L_0x006e:
            r3 = 0
        L_0x006f:
            if (r3 != 0) goto L_0x0072
            goto L_0x0079
        L_0x0072:
            com.baidu.mapapi.MKSearchListener r9 = r8.a
            r9.onGetRGCShareUrlResult(r0, r6)
            goto L_0x0278
        L_0x0079:
            com.baidu.mapapi.MKSearchListener r9 = r8.a
            r9.onGetRGCShareUrlResult(r5, r4)
            goto L_0x0278
        L_0x0080:
            int r0 = r9.b
            if (r0 == 0) goto L_0x008d
            com.baidu.mapapi.MKSearchListener r0 = r8.a
            int r9 = r9.b
            r0.onGetSuggestionResult(r5, r9)
            goto L_0x0278
        L_0x008d:
            r0 = 11010107(0xa8003b, float:1.5428446E-38)
            int r1 = r9.c
            android.os.Bundle r0 = com.baidu.mapapi.Mj.getNewBundle(r0, r1, r6)
            if (r0 == 0) goto L_0x00ba
            com.baidu.mapapi.MKSuggestionResult r1 = new com.baidu.mapapi.MKSuggestionResult
            r1.<init>()
            int r2 = r9.c
            r8.a((android.os.Bundle) r0, (com.baidu.mapapi.MKSuggestionResult) r1, (int) r2)
            int r9 = r9.c
            r0 = 506(0x1fa, float:7.09E-43)
            if (r9 != r0) goto L_0x00b3
            int r9 = r1.getSuggestionNum()
            if (r9 <= 0) goto L_0x00af
            goto L_0x00b0
        L_0x00af:
            r3 = 0
        L_0x00b0:
            if (r3 != 0) goto L_0x00b3
            goto L_0x00ba
        L_0x00b3:
            com.baidu.mapapi.MKSearchListener r9 = r8.a
            r9.onGetSuggestionResult(r1, r6)
            goto L_0x0278
        L_0x00ba:
            com.baidu.mapapi.MKSearchListener r9 = r8.a
            r9.onGetSuggestionResult(r5, r4)
            goto L_0x0278
        L_0x00c1:
            int r0 = r9.b
            if (r0 == 0) goto L_0x00ce
            com.baidu.mapapi.MKSearchListener r0 = r8.a
            int r9 = r9.b
            r0.onGetBusDetailResult(r5, r9)
            goto L_0x0278
        L_0x00ce:
            int r9 = r9.c
            android.os.Bundle r9 = com.baidu.mapapi.Mj.getNewBundle(r2, r9, r6)
            if (r9 == 0) goto L_0x00e9
            com.baidu.mapapi.MKBusLineResult r0 = new com.baidu.mapapi.MKBusLineResult
            r0.<init>()
            boolean r9 = r8.a((android.os.Bundle) r9, (com.baidu.mapapi.MKBusLineResult) r0)
            if (r9 == 0) goto L_0x00e2
            r4 = 0
        L_0x00e2:
            com.baidu.mapapi.MKSearchListener r9 = r8.a
            r9.onGetBusDetailResult(r0, r4)
            goto L_0x0278
        L_0x00e9:
            com.baidu.mapapi.MKSearchListener r9 = r8.a
            r9.onGetBusDetailResult(r5, r4)
            goto L_0x0278
        L_0x00f0:
            int r9 = r9.c
            android.os.Bundle r9 = com.baidu.mapapi.Mj.getNewBundle(r2, r9, r6)
            com.baidu.mapapi.MKRouteAddrResult r0 = new com.baidu.mapapi.MKRouteAddrResult
            r0.<init>()
            int r9 = r8.a((android.os.Bundle) r9, (com.baidu.mapapi.MKRouteAddrResult) r0)
            r1 = 4
            if (r9 == 0) goto L_0x0131
            if (r9 == r3) goto L_0x0118
            r2 = 2
            if (r9 == r2) goto L_0x0109
            goto L_0x0278
        L_0x0109:
            com.baidu.mapapi.MKWalkingRouteResult r9 = new com.baidu.mapapi.MKWalkingRouteResult
            r9.<init>()
            r9.a((com.baidu.mapapi.MKRouteAddrResult) r0)
            com.baidu.mapapi.MKSearchListener r0 = r8.a
            r0.onGetWalkingRouteResult(r9, r1)
            goto L_0x0278
        L_0x0118:
            java.util.ArrayList<com.baidu.mapapi.MKPoiInfo> r9 = r0.mStartPoiList
            if (r9 == 0) goto L_0x0219
            java.util.ArrayList<com.baidu.mapapi.MKPoiInfo> r9 = r0.mEndPoiList
            if (r9 != 0) goto L_0x0122
            goto L_0x0219
        L_0x0122:
            com.baidu.mapapi.MKTransitRouteResult r9 = new com.baidu.mapapi.MKTransitRouteResult
            r9.<init>()
            r9.a((com.baidu.mapapi.MKRouteAddrResult) r0)
            com.baidu.mapapi.MKSearchListener r0 = r8.a
            r0.onGetTransitRouteResult(r9, r1)
            goto L_0x0278
        L_0x0131:
            com.baidu.mapapi.MKDrivingRouteResult r9 = new com.baidu.mapapi.MKDrivingRouteResult
            r9.<init>()
            r9.a((com.baidu.mapapi.MKRouteAddrResult) r0)
            com.baidu.mapapi.MKSearchListener r0 = r8.a
            r0.onGetDrivingRouteResult(r9, r1)
            goto L_0x0278
        L_0x0140:
            int r0 = r9.b
            if (r0 == 0) goto L_0x0145
            goto L_0x0162
        L_0x0145:
            int r9 = r9.c
            android.os.Bundle r9 = com.baidu.mapapi.Mj.getNewBundle(r1, r9, r6)
            if (r9 == 0) goto L_0x0193
            com.baidu.mapapi.MKAddrInfo r0 = new com.baidu.mapapi.MKAddrInfo
            r0.<init>()
            r0.type = r6
            r8.a((android.os.Bundle) r9, (com.baidu.mapapi.MKAddrInfo) r0)
            com.baidu.mapapi.MKSearchListener r9 = r8.a
            r9.onGetAddrResult(r0, r6)
            goto L_0x0278
        L_0x015e:
            int r0 = r9.b
            if (r0 == 0) goto L_0x016b
        L_0x0162:
            com.baidu.mapapi.MKSearchListener r0 = r8.a
            int r9 = r9.b
            r0.onGetAddrResult(r5, r9)
            goto L_0x0278
        L_0x016b:
            int r0 = r9.c
            android.os.Bundle r0 = com.baidu.mapapi.Mj.getNewBundle(r1, r0, r6)
            if (r0 == 0) goto L_0x0193
            com.baidu.mapapi.MKAddrInfo r1 = new com.baidu.mapapi.MKAddrInfo
            r1.<init>()
            r1.type = r3
            int r9 = r9.c
            r8.a((android.os.Bundle) r0, (com.baidu.mapapi.MKAddrInfo) r1, (int) r9)
            java.lang.String r9 = r1.strAddr
            if (r9 == 0) goto L_0x0193
            java.lang.String r9 = r1.strAddr
            int r9 = r9.length()
            if (r9 != 0) goto L_0x018c
            goto L_0x0193
        L_0x018c:
            com.baidu.mapapi.MKSearchListener r9 = r8.a
            r9.onGetAddrResult(r1, r6)
            goto L_0x0278
        L_0x0193:
            com.baidu.mapapi.MKSearchListener r9 = r8.a
            r9.onGetAddrResult(r5, r4)
            goto L_0x0278
        L_0x019a:
            int r0 = r9.b
            if (r0 == 0) goto L_0x01a7
            com.baidu.mapapi.MKSearchListener r0 = r8.a
            int r9 = r9.b
            r0.onGetWalkingRouteResult(r5, r9)
            goto L_0x0278
        L_0x01a7:
            int r0 = r9.c
            android.os.Bundle r0 = com.baidu.mapapi.Mj.getNewBundle(r2, r0, r6)
            if (r0 == 0) goto L_0x01c0
            com.baidu.mapapi.MKWalkingRouteResult r1 = new com.baidu.mapapi.MKWalkingRouteResult
            r1.<init>()
            int r9 = r9.c
            r8.a((android.os.Bundle) r0, (com.baidu.mapapi.MKWalkingRouteResult) r1, (int) r9)
            com.baidu.mapapi.MKSearchListener r9 = r8.a
            r9.onGetWalkingRouteResult(r1, r6)
            goto L_0x0278
        L_0x01c0:
            com.baidu.mapapi.MKSearchListener r9 = r8.a
            r9.onGetWalkingRouteResult(r5, r4)
            goto L_0x0278
        L_0x01c7:
            int r0 = r9.b
            if (r0 == 0) goto L_0x01d4
            com.baidu.mapapi.MKSearchListener r0 = r8.a
            int r9 = r9.b
            r0.onGetDrivingRouteResult(r5, r9)
            goto L_0x0278
        L_0x01d4:
            int r0 = r9.c
            android.os.Bundle r0 = com.baidu.mapapi.Mj.getNewBundle(r2, r0, r6)
            if (r0 == 0) goto L_0x01ed
            com.baidu.mapapi.MKDrivingRouteResult r1 = new com.baidu.mapapi.MKDrivingRouteResult
            r1.<init>()
            int r9 = r9.c
            r8.a((android.os.Bundle) r0, (com.baidu.mapapi.MKDrivingRouteResult) r1, (int) r9)
            com.baidu.mapapi.MKSearchListener r9 = r8.a
            r9.onGetDrivingRouteResult(r1, r6)
            goto L_0x0278
        L_0x01ed:
            com.baidu.mapapi.MKSearchListener r9 = r8.a
            r9.onGetDrivingRouteResult(r5, r4)
            goto L_0x0278
        L_0x01f4:
            int r0 = r9.b
            if (r0 == 0) goto L_0x0201
            com.baidu.mapapi.MKSearchListener r0 = r8.a
            int r9 = r9.b
            r0.onGetTransitRouteResult(r5, r9)
            goto L_0x0278
        L_0x0201:
            int r0 = r9.c
            android.os.Bundle r0 = com.baidu.mapapi.Mj.getNewBundle(r2, r0, r6)
            if (r0 == 0) goto L_0x0219
            com.baidu.mapapi.MKTransitRouteResult r1 = new com.baidu.mapapi.MKTransitRouteResult
            r1.<init>()
            int r9 = r9.c
            r8.a((android.os.Bundle) r0, (com.baidu.mapapi.MKTransitRouteResult) r1, (int) r9)
            com.baidu.mapapi.MKSearchListener r9 = r8.a
            r9.onGetTransitRouteResult(r1, r6)
            goto L_0x0278
        L_0x0219:
            com.baidu.mapapi.MKSearchListener r9 = r8.a
            r9.onGetTransitRouteResult(r5, r4)
            goto L_0x0278
        L_0x021f:
            int r0 = r9.b
            if (r0 == 0) goto L_0x022b
            com.baidu.mapapi.MKSearchListener r0 = r8.a
            int r9 = r9.b
            r0.onGetPoiResult(r5, r6, r9)
            goto L_0x0278
        L_0x022b:
            int r0 = r9.c
            android.os.Bundle r0 = com.baidu.mapapi.Mj.getNewBundle(r1, r0, r6)
            if (r0 == 0) goto L_0x0273
            com.baidu.mapapi.MKPoiResult r1 = new com.baidu.mapapi.MKPoiResult
            r1.<init>()
            int r2 = r9.c
            r8.a((android.os.Bundle) r0, (com.baidu.mapapi.MKPoiResult) r1, (int) r2)
            int r0 = r9.c
            r2 = 45
            if (r0 != r2) goto L_0x026b
            java.util.ArrayList r0 = r1.getMultiPoiResult()
            if (r0 == 0) goto L_0x0260
            r2 = 0
        L_0x024a:
            int r7 = r0.size()
            if (r2 >= r7) goto L_0x0260
            java.lang.Object r7 = r0.get(r2)
            com.baidu.mapapi.MKPoiResult r7 = (com.baidu.mapapi.MKPoiResult) r7
            java.util.ArrayList r7 = r7.getAllPoi()
            if (r7 == 0) goto L_0x025d
            goto L_0x0261
        L_0x025d:
            int r2 = r2 + 1
            goto L_0x024a
        L_0x0260:
            r3 = 0
        L_0x0261:
            if (r3 != 0) goto L_0x026b
            com.baidu.mapapi.MKSearchListener r0 = r8.a
            int r9 = r9.c
            r0.onGetPoiResult(r5, r9, r4)
            goto L_0x0278
        L_0x026b:
            com.baidu.mapapi.MKSearchListener r0 = r8.a
            int r9 = r9.c
            r0.onGetPoiResult(r1, r9, r6)
            goto L_0x0278
        L_0x0273:
            com.baidu.mapapi.MKSearchListener r9 = r8.a
            r9.onGetPoiResult(r5, r6, r4)
        L_0x0278:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.m.a(com.baidu.mapapi.MKEvent):void");
    }
}
