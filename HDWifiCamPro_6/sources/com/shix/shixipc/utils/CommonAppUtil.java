package com.shix.shixipc.utils;

import android.content.Context;
import com.shix.shixipc.CrashApplication;
import java.util.ArrayList;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public class CommonAppUtil {
    public static final String SHIXAPP_CLOUDLDAYS = "cloudLDays";
    public static final String SHIXAPP_DEUIP = "defaltIP";
    public static final String SHIXAPP_DEUPORT = "defaltPort";
    public static final String SHIXAPP_IP1 = "IP1";
    public static final String SHIXAPP_IP2 = "IP2";
    public static final String SHIXAPP_IP3 = "IP3";
    public static final String SHIXAPP_IP4 = "IP4";
    public static final String SHIXAPP_IP5 = "IP5";
    public static final String SHIXAPP_IPDEFAULT = "IPDefault";
    public static final String SHIXAPP_ISCLEARSETIP = "IPClearS";
    public static final String SHIXAPP_ISCLOUDL = "isCloudL";
    public static final String SHIXAPP_ISSETIP = "isSetIp";
    public static final String SHIXAPP_NEWVER = "newVer";
    public static final String SHIXAPP_PORT1 = "Port1";
    public static final String SHIXAPP_PORT2 = "Port2";
    public static final String SHIXAPP_PORT3 = "Port3";
    public static final String SHIXAPP_PORT4 = "Port4";
    public static final String SHIXAPP_PORT5 = "Port5";
    public static final String SHIXAPP_UPPATH = "upPath";
    public static final String SHIXAPP_VERNAME = "verName";
    public static final String SHIXAPP_adAdd = "adAdd";
    public static final String SHIXAPP_adCloudD = "adCloudD";
    public static final String SHIXAPP_adCloudP = "adCloudP";
    public static final String SHIXAPP_adCloudVideo = "adCloudVideo";
    public static final String SHIXAPP_adIP = "adIP";
    public static final String SHIXAPP_adMe = "adMe";
    public static final String SHIXAPP_adPort = "adPort";
    public static final String SHIXAPP_adSplash = "adSplash";
    public static final String SHIXAPP_adVideo = "adVideo";
    public static final String SHIXAPP_isOpenAd = "isOpenAd";
    public static final String SHIXAPP_isTest = "isTest";
    public static final String SHIXAPP_testIP = "testIP";
    public static final String SHIXAPP_testPort = "testPort";

    public static void SaveAppJspn(String str) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(SHIXAPP_isTest)) {
                Context context = CrashApplication.getContext();
                str2 = SHIXAPP_ISCLEARSETIP;
                CommonUtil.SaveCommonShare(context, SHIXAPP_isTest, (String) null, jSONObject.getInt(SHIXAPP_isTest));
            } else {
                str2 = SHIXAPP_ISCLEARSETIP;
            }
            if (jSONObject.has(SHIXAPP_testIP)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_testIP, jSONObject.getString(SHIXAPP_testIP), -1);
            }
            if (jSONObject.has(SHIXAPP_testPort)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_testPort, (String) null, jSONObject.getInt(SHIXAPP_testPort));
            }
            if (jSONObject.has(SHIXAPP_isOpenAd)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_isOpenAd, (String) null, jSONObject.getInt(SHIXAPP_isOpenAd));
            }
            if (jSONObject.has(SHIXAPP_adSplash)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_adSplash, (String) null, jSONObject.getInt(SHIXAPP_adSplash));
            }
            if (jSONObject.has(SHIXAPP_adMe)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_adMe, (String) null, jSONObject.getInt(SHIXAPP_adMe));
            }
            if (jSONObject.has(SHIXAPP_adAdd)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_adAdd, (String) null, jSONObject.getInt(SHIXAPP_adAdd));
            }
            if (jSONObject.has(SHIXAPP_adCloudD)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_adCloudD, (String) null, jSONObject.getInt(SHIXAPP_adCloudD));
            }
            if (jSONObject.has(SHIXAPP_adCloudP)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_adCloudP, (String) null, jSONObject.getInt(SHIXAPP_adCloudP));
            }
            if (jSONObject.has(SHIXAPP_adCloudVideo)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_adCloudVideo, (String) null, jSONObject.getInt(SHIXAPP_adCloudVideo));
            }
            if (jSONObject.has(SHIXAPP_adIP)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_adIP, jSONObject.getString(SHIXAPP_adIP), -1);
            }
            if (jSONObject.has(SHIXAPP_adPort)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_adPort, (String) null, jSONObject.getInt(SHIXAPP_adPort));
            }
            if (jSONObject.has(SHIXAPP_adVideo)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_adVideo, (String) null, jSONObject.getInt(SHIXAPP_adVideo));
            }
            if (jSONObject.has(SHIXAPP_UPPATH)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_UPPATH, jSONObject.getString(SHIXAPP_UPPATH), -1);
            }
            if (jSONObject.has(SHIXAPP_VERNAME)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_VERNAME, jSONObject.getString(SHIXAPP_VERNAME), -1);
            }
            if (jSONObject.has(SHIXAPP_NEWVER)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_NEWVER, (String) null, jSONObject.getInt(SHIXAPP_NEWVER));
            }
            if (jSONObject.has(SHIXAPP_ISCLOUDL)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_ISCLOUDL, (String) null, jSONObject.getInt(SHIXAPP_ISCLOUDL));
            }
            if (jSONObject.has(SHIXAPP_CLOUDLDAYS)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_CLOUDLDAYS, (String) null, jSONObject.getInt(SHIXAPP_CLOUDLDAYS));
            }
            if (jSONObject.has(SHIXAPP_IPDEFAULT)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_IPDEFAULT, (String) null, jSONObject.getInt(SHIXAPP_IPDEFAULT));
            }
            String str3 = str2;
            if (jSONObject.has(str3)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), str3, (String) null, jSONObject.getInt(str3));
            }
            if (jSONObject.has(SHIXAPP_IP1)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_IP1, jSONObject.getString(SHIXAPP_IP1), -1);
            }
            if (jSONObject.has(SHIXAPP_PORT1)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_PORT1, (String) null, jSONObject.getInt(SHIXAPP_PORT1));
            }
            if (jSONObject.has(SHIXAPP_IP2)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_IP2, jSONObject.getString(SHIXAPP_IP2), -1);
            }
            if (jSONObject.has(SHIXAPP_PORT2)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_PORT2, (String) null, jSONObject.getInt(SHIXAPP_PORT2));
            }
            if (jSONObject.has(SHIXAPP_IP3)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_IP3, jSONObject.getString(SHIXAPP_IP3), -1);
            }
            if (jSONObject.has(SHIXAPP_PORT3)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_PORT3, (String) null, jSONObject.getInt(SHIXAPP_PORT3));
            }
            if (jSONObject.has(SHIXAPP_IP4)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_IP4, jSONObject.getString(SHIXAPP_IP4), -1);
            }
            if (jSONObject.has(SHIXAPP_PORT4)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_PORT4, (String) null, jSONObject.getInt(SHIXAPP_PORT4));
            }
            if (jSONObject.has(SHIXAPP_IP5)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_IP5, jSONObject.getString(SHIXAPP_IP5), -1);
            }
            if (jSONObject.has(SHIXAPP_PORT5)) {
                CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_PORT5, (String) null, jSONObject.getInt(SHIXAPP_PORT5));
            }
            int GetCommonShareIntValue = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), str3, -1);
            int GetCommonShareIntValue2 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_ISSETIP, -1);
            CommonUtil.LogAPP(2, "SHIXAPP t_IPClearS：" + GetCommonShareIntValue + "  i_isSetIp:" + GetCommonShareIntValue2 + " \n");
            if (GetCommonShareIntValue == 1) {
                DoSHIXAPP(0);
                return;
            }
            String GetCommonShareStringValue = CommonUtil.GetCommonShareStringValue(CrashApplication.getContext(), SHIXAPP_DEUIP, "");
            int GetCommonShareIntValue3 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_DEUPORT, -1);
            CommonUtil.LogAPP(2, "SHIXAPP t_DeuIP：" + GetCommonShareStringValue + "  t_DeuPort:" + GetCommonShareIntValue3 + " \n");
            if (GetCommonShareIntValue2 == 0 || GetCommonShareStringValue.length() < 4 || GetCommonShareIntValue3 < 80) {
                DoSHIXAPP(0);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void DoSHIXAPP(int i) {
        int i2 = i;
        String GetCommonShareStringValue = CommonUtil.GetCommonShareStringValue(CrashApplication.getContext(), SHIXAPP_UPPATH, "");
        String GetCommonShareStringValue2 = CommonUtil.GetCommonShareStringValue(CrashApplication.getContext(), SHIXAPP_VERNAME, "");
        int GetCommonShareIntValue = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_NEWVER, 0);
        int GetCommonShareIntValue2 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_ISCLOUDL, 0);
        int GetCommonShareIntValue3 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_CLOUDLDAYS, 0);
        int GetCommonShareIntValue4 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_IPDEFAULT, 0);
        String GetCommonShareStringValue3 = CommonUtil.GetCommonShareStringValue(CrashApplication.getContext(), SHIXAPP_IP1, "");
        int GetCommonShareIntValue5 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_PORT1, 0);
        String GetCommonShareStringValue4 = CommonUtil.GetCommonShareStringValue(CrashApplication.getContext(), SHIXAPP_IP2, "");
        int GetCommonShareIntValue6 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_PORT2, 0);
        String GetCommonShareStringValue5 = CommonUtil.GetCommonShareStringValue(CrashApplication.getContext(), SHIXAPP_IP3, "");
        int GetCommonShareIntValue7 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_PORT3, 0);
        String GetCommonShareStringValue6 = CommonUtil.GetCommonShareStringValue(CrashApplication.getContext(), SHIXAPP_IP4, "");
        int GetCommonShareIntValue8 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_PORT4, 0);
        String GetCommonShareStringValue7 = CommonUtil.GetCommonShareStringValue(CrashApplication.getContext(), SHIXAPP_IP5, "");
        int GetCommonShareIntValue9 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_PORT5, 0);
        CommonUtil.LogAPP(2, "SHIXAPP t_newVer:" + GetCommonShareIntValue + " t_IP1:" + GetCommonShareStringValue3 + " t_Port1:" + GetCommonShareIntValue5 + "  t_verName:" + GetCommonShareStringValue2 + "  t_isCloudL:" + GetCommonShareIntValue2 + "  t_cloudLDays:" + GetCommonShareIntValue3 + "  t_upPath:" + GetCommonShareStringValue + " \n");
        StringBuilder sb = new StringBuilder();
        sb.append("SHIXAPP t_IP2:");
        sb.append(GetCommonShareStringValue4);
        sb.append("  t_Port2:");
        sb.append(GetCommonShareIntValue6);
        sb.append("  t_IPDefault:");
        sb.append(GetCommonShareIntValue4);
        sb.append(" \n");
        CommonUtil.LogAPP(2, sb.toString());
        CommonUtil.LogAPP(2, "SHIXAPP t_IP3:" + GetCommonShareStringValue5 + "  t_Port3:" + GetCommonShareIntValue7 + "  t_IPDefault:" + GetCommonShareIntValue4 + " \n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SHIXAPP t_IP4:");
        String str = GetCommonShareStringValue6;
        sb2.append(str);
        sb2.append("  t_Port4:");
        sb2.append(GetCommonShareIntValue8);
        sb2.append("  t_IPDefault:");
        sb2.append(GetCommonShareIntValue4);
        sb2.append(" \n");
        CommonUtil.LogAPP(2, sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("SHIXAPP t_IP5:");
        String str2 = GetCommonShareStringValue7;
        sb3.append(str2);
        sb3.append("  t_Port5:");
        sb3.append(GetCommonShareIntValue9);
        sb3.append("  t_IPDefault:");
        sb3.append(GetCommonShareIntValue4);
        sb3.append(" \n");
        CommonUtil.LogAPP(2, sb3.toString());
        int GetCommonShareIntValue10 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_isOpenAd, 0);
        int GetCommonShareIntValue11 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_adSplash, 0);
        int i3 = GetCommonShareIntValue8;
        int GetCommonShareIntValue12 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_adMe, 0);
        int i4 = GetCommonShareIntValue9;
        int GetCommonShareIntValue13 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_adAdd, 0);
        String str3 = str;
        int GetCommonShareIntValue14 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_adCloudD, 0);
        String str4 = str2;
        int GetCommonShareIntValue15 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_adCloudP, 0);
        String str5 = GetCommonShareStringValue3;
        int GetCommonShareIntValue16 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_adCloudVideo, 0);
        int i5 = GetCommonShareIntValue5;
        int GetCommonShareIntValue17 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_adVideo, 0);
        String str6 = GetCommonShareStringValue4;
        String GetCommonShareStringValue8 = CommonUtil.GetCommonShareStringValue(CrashApplication.getContext(), SHIXAPP_adIP, "");
        int i6 = GetCommonShareIntValue6;
        int GetCommonShareIntValue18 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_adPort, 0);
        CommonUtil.LogAPP(2, "SHIXAPP t_isOpenAd:" + GetCommonShareIntValue10 + "  t_adSplash:" + GetCommonShareIntValue11 + "  t_adMe:" + GetCommonShareIntValue12 + "  t_adAdd:" + GetCommonShareIntValue13 + "  t_adCloudD:" + GetCommonShareIntValue14 + "  t_adCloudP:" + GetCommonShareIntValue15 + "  t_adCloudVideo:" + GetCommonShareIntValue16 + "  t_adVideo:" + GetCommonShareIntValue17 + " \n");
        StringBuilder sb4 = new StringBuilder();
        sb4.append("SHIXAPP t_adIP:");
        sb4.append(GetCommonShareStringValue8);
        sb4.append("  t_adPort:");
        sb4.append(GetCommonShareIntValue18);
        sb4.append(" \n");
        CommonUtil.LogAPP(2, sb4.toString());
        String str7 = "120.76.133.14";
        int i7 = 80;
        int i8 = i;
        if (i8 != 0) {
            CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_ISSETIP, (String) null, 1);
            if (i8 == 1) {
                GetCommonShareStringValue5 = str5;
                GetCommonShareIntValue7 = i5;
            } else if (i8 == 2) {
                GetCommonShareIntValue7 = i6;
                GetCommonShareStringValue5 = str6;
            } else if (i8 != 3) {
                if (i8 == 4) {
                    GetCommonShareIntValue7 = i3;
                    GetCommonShareStringValue5 = str3;
                } else if (i8 != 5) {
                    GetCommonShareStringValue5 = null;
                    GetCommonShareIntValue7 = 80;
                } else {
                    GetCommonShareIntValue7 = i4;
                    GetCommonShareStringValue5 = str4;
                }
            }
            CommonUtil.LogAPP(2, "SHIXAPP 默认1 iPort：" + GetCommonShareStringValue5 + "  iPort:" + GetCommonShareIntValue7);
            if (GetCommonShareStringValue5 != null && GetCommonShareStringValue5.length() >= 4) {
                str7 = GetCommonShareStringValue5;
            }
            if (GetCommonShareIntValue7 >= 80) {
                i7 = GetCommonShareIntValue7;
            }
            CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_DEUIP, str7, 0);
            CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_DEUPORT, (String) null, i7);
        } else if (GetCommonShareIntValue4 == 0 || GetCommonShareIntValue4 > 5) {
            int nextInt = new Random().nextInt(6);
            CommonUtil.LogAPP(2, "SHIXAPP 默认随机：" + nextInt + "  \n");
            if (nextInt == 0 || nextInt > 5) {
                nextInt = 1;
            }
            if (nextInt == 1) {
                GetCommonShareStringValue5 = str5;
                GetCommonShareIntValue7 = i5;
            } else if (nextInt == 2) {
                GetCommonShareIntValue7 = i6;
                GetCommonShareStringValue5 = str6;
            } else if (nextInt != 3) {
                if (nextInt == 4) {
                    GetCommonShareIntValue7 = i3;
                    GetCommonShareStringValue5 = str3;
                } else if (nextInt != 5) {
                    GetCommonShareStringValue5 = null;
                    GetCommonShareIntValue7 = 80;
                } else {
                    GetCommonShareIntValue7 = i4;
                    GetCommonShareStringValue5 = str4;
                }
            }
            CommonUtil.LogAPP(2, "SHIXAPP 默认 iPort：" + GetCommonShareStringValue5 + "  iPort:" + GetCommonShareIntValue7);
            if (GetCommonShareStringValue5 != null && GetCommonShareStringValue5.length() >= 4) {
                str7 = GetCommonShareStringValue5;
            }
            if (GetCommonShareIntValue7 >= 80) {
                i7 = GetCommonShareIntValue7;
            }
            CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_DEUIP, str7, 0);
            CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_DEUPORT, (String) null, i7);
        } else {
            if (GetCommonShareIntValue4 == 1) {
                GetCommonShareStringValue5 = str5;
                GetCommonShareIntValue7 = i5;
            } else if (GetCommonShareIntValue4 == 2) {
                GetCommonShareIntValue7 = i6;
                GetCommonShareStringValue5 = str6;
            } else if (GetCommonShareIntValue4 != 3) {
                if (GetCommonShareIntValue4 == 4) {
                    GetCommonShareIntValue7 = i3;
                    GetCommonShareStringValue5 = str3;
                } else if (GetCommonShareIntValue4 != 5) {
                    GetCommonShareStringValue5 = null;
                    GetCommonShareIntValue7 = 80;
                } else {
                    GetCommonShareIntValue7 = i4;
                    GetCommonShareStringValue5 = str4;
                }
            }
            CommonUtil.LogAPP(2, "SHIXAPP 默认1 iPort：" + GetCommonShareStringValue5 + "  iPort:" + GetCommonShareIntValue7);
            if (GetCommonShareStringValue5 != null && GetCommonShareStringValue5.length() >= 4) {
                str7 = GetCommonShareStringValue5;
            }
            if (GetCommonShareIntValue7 >= 80) {
                i7 = GetCommonShareIntValue7;
            }
            CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_DEUIP, str7, 0);
            CommonUtil.SaveCommonShare(CrashApplication.getContext(), SHIXAPP_DEUPORT, (String) null, i7);
        }
    }

    public static String getDeuIp() {
        String str;
        if (CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_isTest, 0) > 0) {
            str = CommonUtil.GetCommonShareStringValue(CrashApplication.getContext(), SHIXAPP_testIP, "");
        } else {
            str = CommonUtil.GetCommonShareStringValue(CrashApplication.getContext(), SHIXAPP_DEUIP, "");
        }
        CommonUtil.LogAPP(2, "SHIXAPP strIP：" + str + " \n");
        return (str == null || str.length() < 4) ? "1.12.248.227" : str;
    }

    public static int getDeuPort() {
        int i;
        if (CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_isTest, 0) > 0) {
            i = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_testPort, 0);
        } else {
            i = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_DEUPORT, 0);
        }
        CommonUtil.LogAPP(2, "SHIXAPP t_DeuPort:" + i + " \n");
        if (i < 80) {
            return 80;
        }
        return i;
    }

    public static String getShowDeuIp() {
        int i;
        String str;
        if (CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_isTest, 0) > 0) {
            str = CommonUtil.GetCommonShareStringValue(CrashApplication.getContext(), SHIXAPP_testIP, "");
            i = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_testPort, 0);
        } else {
            str = CommonUtil.GetCommonShareStringValue(CrashApplication.getContext(), SHIXAPP_DEUIP, "");
            i = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_DEUPORT, 0);
        }
        int i2 = i + 5;
        CommonUtil.LogAPP(2, "SHIXAPP strIP：" + str + " \n");
        if (str == null || str.length() < 6) {
            str = "1.12.248.227";
        }
        CommonUtil.LogAPP(2, "SHIXAPP t_DeuPort:" + i2 + " \n");
        if (i2 < 80) {
            i2 = 80;
        }
        return "172." + i2 + "." + str.substring(0, 6) + "***";
    }

    public static ArrayList<String> getAllIps() {
        ArrayList<String> arrayList = new ArrayList<>();
        String GetCommonShareStringValue = CommonUtil.GetCommonShareStringValue(CrashApplication.getContext(), SHIXAPP_IP1, "");
        int GetCommonShareIntValue = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_PORT1, 0) + 5;
        String GetCommonShareStringValue2 = CommonUtil.GetCommonShareStringValue(CrashApplication.getContext(), SHIXAPP_IP2, "");
        int GetCommonShareIntValue2 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_PORT2, 0) + 5;
        String GetCommonShareStringValue3 = CommonUtil.GetCommonShareStringValue(CrashApplication.getContext(), SHIXAPP_IP3, "");
        int GetCommonShareIntValue3 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_PORT3, 0) + 5;
        String str = CommonUtil.GetCommonShareStringValue(CrashApplication.getContext(), SHIXAPP_IP4, "") + 5;
        int GetCommonShareIntValue4 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_PORT4, 0) + 5;
        String GetCommonShareStringValue4 = CommonUtil.GetCommonShareStringValue(CrashApplication.getContext(), SHIXAPP_IP5, "");
        int GetCommonShareIntValue5 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_PORT5, 0) + 5;
        if (GetCommonShareStringValue != null && GetCommonShareStringValue.length() > 6) {
            arrayList.add("172." + GetCommonShareIntValue + "." + GetCommonShareStringValue.substring(0, 6) + "***:");
        }
        if (GetCommonShareStringValue2 != null && GetCommonShareStringValue2.length() > 6) {
            arrayList.add("172." + GetCommonShareIntValue2 + "." + GetCommonShareStringValue2.substring(0, 6) + "***:");
        }
        if (GetCommonShareStringValue3 != null && GetCommonShareStringValue3.length() > 6) {
            arrayList.add("172." + GetCommonShareIntValue3 + "." + GetCommonShareStringValue3.substring(0, 6) + "***:");
        }
        if (str != null && str.length() > 6) {
            arrayList.add("172." + GetCommonShareIntValue4 + "." + str.substring(0, 6) + "***:");
        }
        if (GetCommonShareStringValue4 != null && GetCommonShareStringValue4.length() > 6) {
            arrayList.add("172." + GetCommonShareIntValue5 + "." + GetCommonShareStringValue4.substring(0, 6) + "***:");
        }
        return arrayList;
    }

    public static int APP_isOpenAd() {
        int GetCommonShareIntValue = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_isOpenAd, 0);
        CommonUtil.LogAPP(2, "SHIXAPP APP_isOpenAd:" + GetCommonShareIntValue + " \n");
        return GetCommonShareIntValue;
    }

    public static boolean APP_adSplash() {
        int GetCommonShareIntValue = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_isOpenAd, 0);
        CommonUtil.LogAPP(2, "SHIXAPP APP_isOpenAd:" + GetCommonShareIntValue + " \n");
        int GetCommonShareIntValue2 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_adSplash, 0);
        CommonUtil.LogAPP(2, "SHIXAPP APP_iadSplash:" + GetCommonShareIntValue2 + " \n");
        if (GetCommonShareIntValue <= 0 || GetCommonShareIntValue2 <= 0) {
            return false;
        }
        return true;
    }

    public static boolean APP_adMe() {
        int GetCommonShareIntValue = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_isOpenAd, 0);
        CommonUtil.LogAPP(2, "SHIXAPP isOpenAd:" + GetCommonShareIntValue + " \n");
        int GetCommonShareIntValue2 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_adMe, 0);
        CommonUtil.LogAPP(2, "SHIXAPP APP_adMe:" + GetCommonShareIntValue2 + " \n");
        if (GetCommonShareIntValue <= 0 || GetCommonShareIntValue2 <= 0) {
            return false;
        }
        return true;
    }

    public static boolean APP_adAdd() {
        int GetCommonShareIntValue = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_isOpenAd, 0);
        CommonUtil.LogAPP(2, "SHIXAPP isOpenAd:" + GetCommonShareIntValue + " \n");
        int GetCommonShareIntValue2 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_adAdd, 0);
        CommonUtil.LogAPP(2, "SHIXAPP APP_adAdd:" + GetCommonShareIntValue2 + " \n");
        if (GetCommonShareIntValue <= 0 || GetCommonShareIntValue2 <= 0) {
            return false;
        }
        return true;
    }

    public static boolean APP_adCloudD() {
        int GetCommonShareIntValue = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_isOpenAd, 0);
        CommonUtil.LogAPP(2, "SHIXAPP isOpenAd:" + GetCommonShareIntValue + " \n");
        int GetCommonShareIntValue2 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_adCloudD, 0);
        CommonUtil.LogAPP(2, "SHIXAPP APP_adCloudD:" + GetCommonShareIntValue2 + " \n");
        if (GetCommonShareIntValue <= 0 || GetCommonShareIntValue2 <= 0) {
            return false;
        }
        return true;
    }

    public static boolean APP_adCloudP() {
        int GetCommonShareIntValue = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_isOpenAd, 0);
        CommonUtil.LogAPP(2, "SHIXAPP isOpenAd:" + GetCommonShareIntValue + " \n");
        int GetCommonShareIntValue2 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_adCloudP, 0);
        CommonUtil.LogAPP(2, "SHIXAPP APP_adCloudP:" + GetCommonShareIntValue2 + " \n");
        if (GetCommonShareIntValue <= 0 || GetCommonShareIntValue2 <= 0) {
            return false;
        }
        return true;
    }

    public static boolean APP_adCloudVideo() {
        int GetCommonShareIntValue = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_isOpenAd, 0);
        CommonUtil.LogAPP(2, "SHIXAPP isOpenAd:" + GetCommonShareIntValue + " \n");
        int GetCommonShareIntValue2 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_adCloudVideo, 0);
        CommonUtil.LogAPP(2, "SHIXAPP APP_adCloudVideo:" + GetCommonShareIntValue2 + " \n");
        if (GetCommonShareIntValue <= 0 || GetCommonShareIntValue2 <= 0) {
            return false;
        }
        return true;
    }

    public static boolean APP_adVideo() {
        int GetCommonShareIntValue = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_isOpenAd, 0);
        CommonUtil.LogAPP(2, "SHIXAPP isOpenAd:" + GetCommonShareIntValue + " \n");
        int GetCommonShareIntValue2 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_adVideo, 0);
        CommonUtil.LogAPP(2, "SHIXAPP APP_adVideo:" + GetCommonShareIntValue2 + " \n");
        if (GetCommonShareIntValue <= 0 || GetCommonShareIntValue2 <= 0) {
            return false;
        }
        return true;
    }

    public static String APP_adGetDeuIp() {
        String GetCommonShareStringValue = CommonUtil.GetCommonShareStringValue(CrashApplication.getContext(), SHIXAPP_adIP, "");
        CommonUtil.LogAPP(2, "SHIXAPP adIP：" + GetCommonShareStringValue + " \n");
        return (GetCommonShareStringValue == null || GetCommonShareStringValue.length() < 4) ? "120.76.133.14" : GetCommonShareStringValue;
    }

    public static int APP_adGetDeuPort() {
        int GetCommonShareIntValue = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), SHIXAPP_adPort, 0);
        CommonUtil.LogAPP(2, "SHIXAPP t_DeuPort adPort:" + GetCommonShareIntValue + " \n");
        if (GetCommonShareIntValue < 80) {
            return 80;
        }
        return GetCommonShareIntValue;
    }
}
