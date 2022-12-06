package com.baidu.mapapi.cloud;

import android.os.Bundle;
import com.baidu.mapapi.Mj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import object.p2pipcam.utils.DataBaseHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements c {
    GeoSearchListener a;

    public b(GeoSearchListener geoSearchListener) {
        this.a = geoSearchListener;
    }

    public void a(a aVar) {
        GeoSearchResult geoSearchResult;
        String[] strArr;
        float[] fArr;
        int i;
        DetailResult detailResult;
        int i2;
        GeoSearchListener geoSearchListener;
        String[] strArr2;
        b bVar = this;
        a aVar2 = aVar;
        int i3 = aVar2.a;
        if (i3 != 504) {
            if (i3 == 505) {
                Bundle newBundle = Mj.getNewBundle(11010207, aVar2.c, 0);
                if (newBundle != null) {
                    detailResult = new DetailResult();
                    detailResult.status = newBundle.getInt("status");
                    detailResult.message = newBundle.getString("message");
                    int i4 = newBundle.getInt("content_size");
                    if (i4 == 1) {
                        detailResult.content = new CustomPoiInfo();
                        String[] stringArray = newBundle.getStringArray("uid");
                        String[] stringArray2 = newBundle.getStringArray("databox_id");
                        String[] stringArray3 = newBundle.getStringArray(DataBaseHelper.KEY_NAME);
                        String[] stringArray4 = newBundle.getStringArray("addr");
                        String[] stringArray5 = newBundle.getStringArray("tel");
                        String[] stringArray6 = newBundle.getStringArray("zip");
                        int[] intArray = newBundle.getIntArray("province_id");
                        int[] intArray2 = newBundle.getIntArray("city_id");
                        int[] intArray3 = newBundle.getIntArray("district_id");
                        String[] stringArray7 = newBundle.getStringArray("province");
                        String[] stringArray8 = newBundle.getStringArray("city");
                        String[] stringArray9 = newBundle.getStringArray("district");
                        float[] floatArray = newBundle.getFloatArray("latitude");
                        float[] floatArray2 = newBundle.getFloatArray("longitude");
                        String[] stringArray10 = newBundle.getStringArray("tag");
                        String[] stringArray11 = newBundle.getStringArray("ext");
                        int i5 = 0;
                        while (i5 < i4) {
                            String[] strArr3 = stringArray;
                            detailResult.content.uid = Integer.valueOf(stringArray[i5]).intValue();
                            detailResult.content.databoxId = Integer.valueOf(stringArray2[i5]).intValue();
                            detailResult.content.name = stringArray3[i5];
                            detailResult.content.address = stringArray4[i5];
                            detailResult.content.telephone = stringArray5[i5];
                            detailResult.content.postCode = stringArray6[i5];
                            detailResult.content.provinceId = intArray[i5];
                            detailResult.content.cityId = intArray2[i5];
                            detailResult.content.districtId = intArray3[i5];
                            detailResult.content.provinceName = stringArray7[i5];
                            detailResult.content.cityName = stringArray8[i5];
                            detailResult.content.districtName = stringArray9[i5];
                            detailResult.content.latitude = floatArray[i5];
                            detailResult.content.longitude = floatArray2[i5];
                            detailResult.content.tag = stringArray10[i5];
                            String str = stringArray11[i5];
                            if (str == null || "".equals(str)) {
                                strArr2 = stringArray9;
                            } else {
                                strArr2 = stringArray9;
                                detailResult.content.poiExtend = new HashMap();
                                try {
                                    JSONObject jSONObject = new JSONObject(str);
                                    Iterator<String> keys = jSONObject.keys();
                                    while (keys.hasNext()) {
                                        String next = keys.next();
                                        Iterator<String> it = keys;
                                        JSONObject jSONObject2 = jSONObject;
                                        detailResult.content.poiExtend.put(next, jSONObject.get(next));
                                        keys = it;
                                        jSONObject = jSONObject2;
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            i5++;
                            stringArray = strArr3;
                            stringArray9 = strArr2;
                        }
                    }
                    if (detailResult.content == null) {
                        bVar = this;
                        geoSearchListener = bVar.a;
                        i2 = aVar.c;
                        i = 100;
                    } else {
                        bVar = this;
                        a aVar3 = aVar;
                        bVar.a.onGetGeoDetailsResult(detailResult, aVar3.c, aVar3.b);
                    }
                } else {
                    i = 100;
                    geoSearchListener = bVar.a;
                    i2 = aVar2.c;
                    detailResult = null;
                }
                geoSearchListener.onGetGeoDetailsResult(detailResult, i2, i);
            }
            b bVar2 = bVar;
            return;
        }
        Bundle newBundle2 = Mj.getNewBundle(11010207, aVar2.c, 0);
        if (newBundle2 != null) {
            GeoSearchResult geoSearchResult2 = new GeoSearchResult();
            geoSearchResult2.status = newBundle2.getInt("status");
            geoSearchResult2.message = newBundle2.getString("message");
            geoSearchResult2.size = newBundle2.getInt("size");
            geoSearchResult2.total = newBundle2.getInt("total");
            int i6 = newBundle2.getInt("content_size");
            if (i6 > 0) {
                geoSearchResult2.poiList = new ArrayList(i6);
                String[] stringArray12 = newBundle2.getStringArray("uid");
                String[] stringArray13 = newBundle2.getStringArray("databox_id");
                String[] stringArray14 = newBundle2.getStringArray(DataBaseHelper.KEY_NAME);
                String[] stringArray15 = newBundle2.getStringArray("addr");
                String[] stringArray16 = newBundle2.getStringArray("tel");
                String[] stringArray17 = newBundle2.getStringArray("zip");
                int[] intArray4 = newBundle2.getIntArray("province_id");
                int[] intArray5 = newBundle2.getIntArray("city_id");
                int[] intArray6 = newBundle2.getIntArray("district_id");
                String[] stringArray18 = newBundle2.getStringArray("province");
                String[] stringArray19 = newBundle2.getStringArray("city");
                String[] stringArray20 = newBundle2.getStringArray("district");
                float[] floatArray3 = newBundle2.getFloatArray("latitude");
                GeoSearchResult geoSearchResult3 = geoSearchResult2;
                float[] floatArray4 = newBundle2.getFloatArray("longitude");
                String[] stringArray21 = newBundle2.getStringArray("tag");
                String[] stringArray22 = newBundle2.getStringArray("ext");
                int i7 = 0;
                while (i7 < i6) {
                    int i8 = i6;
                    CustomPoiInfo customPoiInfo = new CustomPoiInfo();
                    customPoiInfo.uid = Integer.valueOf(stringArray12[i7]).intValue();
                    customPoiInfo.databoxId = Integer.valueOf(stringArray13[i7]).intValue();
                    customPoiInfo.name = stringArray14[i7];
                    customPoiInfo.address = stringArray15[i7];
                    customPoiInfo.telephone = stringArray16[i7];
                    customPoiInfo.postCode = stringArray17[i7];
                    customPoiInfo.provinceId = intArray4[i7];
                    customPoiInfo.cityId = intArray5[i7];
                    customPoiInfo.districtId = intArray6[i7];
                    customPoiInfo.provinceName = stringArray18[i7];
                    customPoiInfo.cityName = stringArray19[i7];
                    customPoiInfo.districtName = stringArray20[i7];
                    customPoiInfo.latitude = floatArray3[i7];
                    customPoiInfo.longitude = floatArray4[i7];
                    customPoiInfo.tag = stringArray21[i7];
                    String str2 = stringArray22[i7];
                    if (str2 != null) {
                        fArr = floatArray3;
                        if (!"".equals(str2)) {
                            customPoiInfo.poiExtend = new HashMap();
                            try {
                                JSONObject jSONObject3 = new JSONObject(str2);
                                Iterator<String> keys2 = jSONObject3.keys();
                                while (keys2.hasNext()) {
                                    Iterator<String> it2 = keys2;
                                    String next2 = keys2.next();
                                    strArr = stringArray20;
                                    try {
                                        JSONObject jSONObject4 = jSONObject3;
                                        customPoiInfo.poiExtend.put(next2, jSONObject3.get(next2));
                                        stringArray20 = strArr;
                                        keys2 = it2;
                                        jSONObject3 = jSONObject4;
                                    } catch (JSONException e2) {
                                        e = e2;
                                        e.printStackTrace();
                                        GeoSearchResult geoSearchResult4 = geoSearchResult3;
                                        geoSearchResult4.poiList.add(customPoiInfo);
                                        i7++;
                                        geoSearchResult3 = geoSearchResult4;
                                        i6 = i8;
                                        floatArray3 = fArr;
                                        stringArray20 = strArr;
                                    }
                                }
                            } catch (JSONException e3) {
                                e = e3;
                                strArr = stringArray20;
                                e.printStackTrace();
                                GeoSearchResult geoSearchResult42 = geoSearchResult3;
                                geoSearchResult42.poiList.add(customPoiInfo);
                                i7++;
                                geoSearchResult3 = geoSearchResult42;
                                i6 = i8;
                                floatArray3 = fArr;
                                stringArray20 = strArr;
                            }
                        }
                    } else {
                        fArr = floatArray3;
                    }
                    strArr = stringArray20;
                    GeoSearchResult geoSearchResult422 = geoSearchResult3;
                    geoSearchResult422.poiList.add(customPoiInfo);
                    i7++;
                    geoSearchResult3 = geoSearchResult422;
                    i6 = i8;
                    floatArray3 = fArr;
                    stringArray20 = strArr;
                }
                geoSearchResult = geoSearchResult3;
            } else {
                geoSearchResult = geoSearchResult2;
            }
            if (geoSearchResult.poiList == null) {
                this.a.onGetGeoResult(geoSearchResult, aVar.c, 100);
                return;
            }
            a aVar4 = aVar;
            this.a.onGetGeoResult(geoSearchResult, aVar4.c, aVar4.b);
            return;
        }
        bVar.a.onGetGeoResult((GeoSearchResult) null, aVar2.c, 100);
    }
}
