package com.shix.shixipc.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.core.app.NotificationManagerCompat;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseFragment;
import com.shix.shixipc.CrashApplication;
import com.shix.shixipc.activity.AddCameraActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.activity.SettingActivity;
import com.shix.shixipc.adapter.CameraListAdapter;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonAppUtil;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.PayHttpUtils;
import com.shix.shixipc.view.Effectstype;
import com.shix.shixipc.view.NiftyDialogBuilder;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import object.p2pipcam.nativecaller.NativeCaller;
import org.json.JSONException;
import org.json.JSONObject;

public class FragmentCameraList extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener, AddCameraActivity.DeleInterface, SettingActivity.DeleDetInterface {
    private static final String STR_CHECK = "strcheckstr";
    private static final String STR_DID = "did";
    private static final String STR_MODE = "strmode";
    private static final String STR_MSG_PARAM = "msgparam";
    private static final String STR_TYPE = "strtype";
    public static Context contextL;
    private static NewUiMainInterface newUiMainInterface;
    private final int CHECK_APPVER = 9090;
    /* access modifiers changed from: private */
    public Handler PPPPMsgHandler = new Handler() {
        /* JADX WARNING: Removed duplicated region for block: B:91:0x0489 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:92:0x048a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r24) {
            /*
                r23 = this;
                r1 = r23
                java.lang.String r0 = "tz:"
                java.lang.String r2 = "tag"
                java.lang.String r3 = "UTF-8"
                android.os.Bundle r4 = r24.getData()
                java.lang.String r5 = "msgparam"
                int r8 = r4.getInt(r5)
                r5 = r24
                int r5 = r5.what
                com.shix.shixipc.activity.FragmentCameraList r6 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r7 = "did"
                java.lang.String r7 = r4.getString(r7)
                java.lang.String unused = r6.did = r7
                java.lang.String r6 = "strtype"
                int r10 = r4.getInt(r6)
                java.lang.String r6 = "strmode"
                int r9 = r4.getInt(r6)
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "did=="
                r6.append(r7)
                com.shix.shixipc.activity.FragmentCameraList r7 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r7 = r7.did
                r6.append(r7)
                java.lang.String r7 = "  msgType="
                r6.append(r7)
                r6.append(r5)
                java.lang.String r7 = "  devMode:"
                r6.append(r7)
                r6.append(r9)
                java.lang.String r7 = " devType:"
                r6.append(r7)
                r6.append(r10)
                java.lang.String r6 = r6.toString()
                java.lang.String r7 = "test"
                android.util.Log.d(r7, r6)
                java.lang.String r12 = "camera_type"
                java.lang.String r13 = "camera_name"
                java.lang.String r14 = "camera_pwd"
                java.lang.String r15 = "camera_user"
                java.lang.String r7 = "cameraid"
                r11 = 1
                java.lang.String r6 = ""
                if (r5 == 0) goto L_0x02c5
                if (r5 == r11) goto L_0x02ad
                r2 = 3
                if (r5 == r2) goto L_0x021b
                r0 = 200(0xc8, float:2.8E-43)
                if (r5 == r0) goto L_0x0212
                r0 = 9090(0x2382, float:1.2738E-41)
                if (r5 == r0) goto L_0x0114
                r0 = 12330(0x302a, float:1.7278E-41)
                if (r5 == r0) goto L_0x00af
                r0 = 12345(0x3039, float:1.7299E-41)
                if (r5 == r0) goto L_0x0087
                goto L_0x0556
            L_0x0087:
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                com.shix.shixipc.adapter.CameraListAdapter r0 = r0.listAdapter
                r0.notifyDataSetChanged()
                java.util.ArrayList<com.shix.shixipc.bean.CameraParamsBean> r0 = com.shix.shixipc.system.SystemValue.arrayList
                int r0 = r0.size()
                if (r0 != 0) goto L_0x00a2
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                android.widget.LinearLayout r0 = r0.layoutAdd
                r2 = 0
                r0.setVisibility(r2)
                goto L_0x0556
            L_0x00a2:
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                android.widget.LinearLayout r0 = r0.layoutAdd
                r2 = 8
                r0.setVisibility(r2)
                goto L_0x0556
            L_0x00af:
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                com.shix.shixipc.view.NiftyDialogBuilder r0 = com.shix.shixipc.view.NiftyDialogBuilder.getInstance(r0)
                com.shix.shixipc.activity.FragmentCameraList r2 = com.shix.shixipc.activity.FragmentCameraList.this
                android.content.res.Resources r2 = r2.getResources()
                r3 = 2131689801(0x7f0f0149, float:1.9008628E38)
                java.lang.String r2 = r2.getString(r3)
                r0.setTv2(r2)
                android.widget.TextView r2 = r0.getMsg()
                com.shix.shixipc.activity.FragmentCameraList$8$4 r3 = new com.shix.shixipc.activity.FragmentCameraList$8$4
                r3.<init>(r0)
                r2.setOnClickListener(r3)
                com.shix.shixipc.activity.FragmentCameraList r2 = com.shix.shixipc.activity.FragmentCameraList.this
                android.content.res.Resources r2 = r2.getResources()
                r3 = 2131689802(0x7f0f014a, float:1.900863E38)
                java.lang.String r2 = r2.getString(r3)
                com.shix.shixipc.view.NiftyDialogBuilder r2 = r0.withTitle(r2)
                com.shix.shixipc.activity.FragmentCameraList r3 = com.shix.shixipc.activity.FragmentCameraList.this
                android.content.res.Resources r3 = r3.getResources()
                r4 = 2131689803(0x7f0f014b, float:1.9008632E38)
                java.lang.String r3 = r3.getString(r4)
                com.shix.shixipc.view.NiftyDialogBuilder r2 = r2.withMessage((java.lang.CharSequence) r3)
                com.shix.shixipc.view.Effectstype r3 = com.shix.shixipc.view.Effectstype.Slidetop
                com.shix.shixipc.view.NiftyDialogBuilder r2 = r2.withEffect(r3)
                com.shix.shixipc.activity.FragmentCameraList$8$6 r3 = new com.shix.shixipc.activity.FragmentCameraList$8$6
                r3.<init>(r0)
                com.shix.shixipc.view.NiftyDialogBuilder r2 = r2.setButton1Click(r3)
                com.shix.shixipc.activity.FragmentCameraList$8$5 r3 = new com.shix.shixipc.activity.FragmentCameraList$8$5
                r3.<init>(r0)
                com.shix.shixipc.view.NiftyDialogBuilder r0 = r2.setButton2Click(r3)
                r0.show()
                goto L_0x0556
            L_0x0114:
                android.content.Context r0 = com.shix.shixipc.CrashApplication.getContext()
                java.lang.String r2 = "upPath"
                java.lang.String r0 = com.shix.shixipc.utils.CommonUtil.GetCommonShareStringValue(r0, r2, r6)
                android.content.Context r2 = com.shix.shixipc.CrashApplication.getContext()
                java.lang.String r3 = "verName"
                java.lang.String r2 = com.shix.shixipc.utils.CommonUtil.GetCommonShareStringValue(r2, r3, r6)
                if (r0 == 0) goto L_0x0211
                int r0 = r0.length()
                if (r0 < r11) goto L_0x0211
                if (r2 == 0) goto L_0x0211
                int r0 = r2.length()
                if (r0 >= r11) goto L_0x013a
                goto L_0x0211
            L_0x013a:
                android.content.Context r0 = com.shix.shixipc.CrashApplication.getContext()
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "isShow"
                r3.append(r4)
                com.shix.shixipc.activity.FragmentCameraList r4 = com.shix.shixipc.activity.FragmentCameraList.this
                int r4 = r4.t_newVer
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                int r0 = com.shix.shixipc.utils.CommonUtil.GetCommonShareIntValue(r0, r3, r11)
                if (r0 != 0) goto L_0x015a
                return
            L_0x015a:
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                com.shix.shixipc.view.NiftyDialogBuilder r0 = com.shix.shixipc.view.NiftyDialogBuilder.getInstance(r0)
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                com.shix.shixipc.activity.FragmentCameraList r4 = com.shix.shixipc.activity.FragmentCameraList.this
                android.content.res.Resources r4 = r4.getResources()
                r5 = 2131689647(0x7f0f00af, float:1.9008315E38)
                java.lang.String r4 = r4.getString(r5)
                r3.append(r4)
                r3.append(r6)
                java.lang.String r3 = r3.toString()
                r0.setTv1(r3)
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                com.shix.shixipc.activity.FragmentCameraList r4 = com.shix.shixipc.activity.FragmentCameraList.this
                android.content.res.Resources r4 = r4.getResources()
                r5 = 2131689650(0x7f0f00b2, float:1.9008321E38)
                java.lang.String r4 = r4.getString(r5)
                r3.append(r4)
                r3.append(r6)
                java.lang.String r3 = r3.toString()
                r0.setTv2(r3)
                android.widget.TextView r3 = r0.getMsg()
                com.shix.shixipc.activity.FragmentCameraList$8$1 r4 = new com.shix.shixipc.activity.FragmentCameraList$8$1
                r4.<init>(r0)
                r3.setOnClickListener(r4)
                com.shix.shixipc.activity.FragmentCameraList r3 = com.shix.shixipc.activity.FragmentCameraList.this
                android.content.res.Resources r3 = r3.getResources()
                r4 = 2131689651(0x7f0f00b3, float:1.9008323E38)
                java.lang.String r3 = r3.getString(r4)
                com.shix.shixipc.view.NiftyDialogBuilder r3 = r0.withTitle(r3)
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                com.shix.shixipc.activity.FragmentCameraList r5 = com.shix.shixipc.activity.FragmentCameraList.this
                android.content.res.Resources r5 = r5.getResources()
                r6 = 2131689648(0x7f0f00b0, float:1.9008317E38)
                java.lang.String r5 = r5.getString(r6)
                r4.append(r5)
                r4.append(r2)
                java.lang.String r2 = ","
                r4.append(r2)
                com.shix.shixipc.activity.FragmentCameraList r2 = com.shix.shixipc.activity.FragmentCameraList.this
                android.content.res.Resources r2 = r2.getResources()
                r5 = 2131689649(0x7f0f00b1, float:1.900832E38)
                java.lang.String r2 = r2.getString(r5)
                r4.append(r2)
                java.lang.String r2 = r4.toString()
                com.shix.shixipc.view.NiftyDialogBuilder r2 = r3.withMessage((java.lang.CharSequence) r2)
                com.shix.shixipc.view.Effectstype r3 = com.shix.shixipc.view.Effectstype.Slidetop
                com.shix.shixipc.view.NiftyDialogBuilder r2 = r2.withEffect(r3)
                com.shix.shixipc.activity.FragmentCameraList$8$3 r3 = new com.shix.shixipc.activity.FragmentCameraList$8$3
                r3.<init>(r0)
                com.shix.shixipc.view.NiftyDialogBuilder r2 = r2.setButton1Click(r3)
                com.shix.shixipc.activity.FragmentCameraList$8$2 r3 = new com.shix.shixipc.activity.FragmentCameraList$8$2
                r3.<init>(r0)
                com.shix.shixipc.view.NiftyDialogBuilder r0 = r2.setButton2Click(r3)
                r0.show()
                goto L_0x0556
            L_0x0211:
                return
            L_0x0212:
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                com.shix.shixipc.adapter.CameraListAdapter r0 = r0.listAdapter
                r0.notifyDataSetChanged()
                goto L_0x0556
            L_0x021b:
                r2 = 0
                java.lang.String r0 = "strcheckstr"
                java.lang.String r11 = r4.getString(r0)
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                com.shix.shixipc.adapter.CameraListAdapter r6 = r0.listAdapter
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r0 = r0.did
                r4 = r7
                r7 = r0
                r5 = r2
                r6.UpdataCameraResetrict(r7, r8, r9, r10, r11)
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r2 = r0.did
                com.shix.shixipc.bean.CameraParamsBean r0 = r0.getCameraBean(r2)
                if (r0 != 0) goto L_0x023f
                return
            L_0x023f:
                java.lang.String r2 = r0.getDev_User()
                com.shix.shixipc.system.SystemValue.doorBellAdmin = r2
                java.lang.String r2 = r0.getDev_Pwd()
                com.shix.shixipc.system.SystemValue.doorBellPass = r2
                boolean r2 = r0.isBkDoorBell()
                if (r2 == 0) goto L_0x0556
                int r2 = r0.getDevType()
                com.shix.shixipc.system.SystemValue.devType = r2
                int r0 = r0.getDevMode()
                com.shix.shixipc.system.SystemValue.devMode = r0
                android.content.Intent r0 = new android.content.Intent
                com.shix.shixipc.activity.FragmentCameraList r2 = com.shix.shixipc.activity.FragmentCameraList.this
                androidx.fragment.app.FragmentActivity r2 = r2.getActivity()
                java.lang.Class<com.shix.shixipc.activity.DoorbellNotifyActivity> r3 = com.shix.shixipc.activity.DoorbellNotifyActivity.class
                r0.<init>(r2, r3)
                com.shix.shixipc.activity.FragmentCameraList r2 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r2 = r2.did
                r0.putExtra(r4, r2)
                com.shix.shixipc.activity.FragmentCameraList r2 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r3 = r2.did
                java.lang.String r2 = r2.retrunUser(r3)
                r0.putExtra(r15, r2)
                com.shix.shixipc.activity.FragmentCameraList r2 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r3 = r2.did
                java.lang.String r2 = r2.retrunUserPWD(r3)
                r0.putExtra(r14, r2)
                com.shix.shixipc.activity.FragmentCameraList r2 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r3 = r2.did
                java.lang.String r2 = r2.retrunName(r3)
                r0.putExtra(r13, r2)
                r0.putExtra(r12, r5)
                r2 = 268435456(0x10000000, float:2.5243549E-29)
                r0.setFlags(r2)
                com.shix.shixipc.activity.FragmentCameraList r2 = com.shix.shixipc.activity.FragmentCameraList.this
                androidx.fragment.app.FragmentActivity r2 = r2.getActivity()
                r2.startActivity(r0)
                goto L_0x0556
            L_0x02ad:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "shix:"
                r0.append(r2)
                r0.append(r8)
                java.lang.String r0 = r0.toString()
                java.lang.String r2 = "shix"
                android.util.Log.d(r2, r0)
                goto L_0x0556
            L_0x02c5:
                r4 = r7
                r5 = 0
                android.content.Intent r7 = new android.content.Intent
                java.lang.String r9 = "camera_status_change"
                r7.<init>(r9)
                com.shix.shixipc.activity.FragmentCameraList r9 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r9 = r9.did
                r7.putExtra(r4, r9)
                java.lang.String r9 = "pppp_status"
                r7.putExtra(r9, r8)
                com.shix.shixipc.activity.FragmentCameraList r9 = com.shix.shixipc.activity.FragmentCameraList.this
                androidx.fragment.app.FragmentActivity r9 = r9.getActivity()
                r9.sendBroadcast(r7)
                com.shix.shixipc.activity.FragmentCameraList r7 = com.shix.shixipc.activity.FragmentCameraList.this
                com.shix.shixipc.adapter.CameraListAdapter r7 = r7.listAdapter
                com.shix.shixipc.activity.FragmentCameraList r9 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r9 = r9.did
                boolean r7 = r7.UpdataCameraStatus(r9, r8)
                if (r7 == 0) goto L_0x0556
                com.shix.shixipc.activity.FragmentCameraList r7 = com.shix.shixipc.activity.FragmentCameraList.this
                com.shix.shixipc.adapter.CameraListAdapter r7 = r7.listAdapter
                r7.notifyDataSetChanged()
                r7 = 2
                if (r8 != r7) goto L_0x0528
                com.shix.shixipc.activity.FragmentCameraList r9 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r10 = r9.did
                com.shix.shixipc.bean.CameraParamsBean r9 = r9.getCameraBean(r10)
                if (r9 != 0) goto L_0x030c
                return
            L_0x030c:
                java.lang.String r10 = r9.getDev_User()
                com.shix.shixipc.system.SystemValue.doorBellAdmin = r10
                java.lang.String r10 = r9.getDev_Pwd()
                com.shix.shixipc.system.SystemValue.doorBellPass = r10
                com.shix.shixipc.activity.FragmentCameraList r10 = com.shix.shixipc.activity.FragmentCameraList.this
                androidx.fragment.app.FragmentActivity r10 = r10.getActivity()
                java.lang.String r7 = "SHIXconfigWifiSSID"
                java.lang.String r10 = com.shix.shixipc.utils.CommonUtil.GetCommonShareStringValue(r10, r7, r6)
                com.shix.shixipc.system.SystemValue.configWifiSSID = r10
                com.shix.shixipc.activity.FragmentCameraList r10 = com.shix.shixipc.activity.FragmentCameraList.this
                androidx.fragment.app.FragmentActivity r10 = r10.getActivity()
                java.lang.String r5 = "SHIXconfigWifiPWD"
                java.lang.String r5 = com.shix.shixipc.utils.CommonUtil.GetCommonShareStringValue(r10, r5, r6)
                com.shix.shixipc.system.SystemValue.configWifiPWD = r5
                java.lang.String r5 = com.shix.shixipc.system.SystemValue.configWifiSSID
                if (r5 == 0) goto L_0x03c8
                java.lang.String r5 = com.shix.shixipc.system.SystemValue.configWifiSSID
                int r5 = r5.length()
                if (r5 <= r11) goto L_0x03c8
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r2 = r0.getWifiSSID()
                r0.nowssid = r2
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r0 = r0.nowssid
                java.lang.String r2 = "DGK"
                int r0 = r0.indexOf(r2)
                if (r0 >= 0) goto L_0x0384
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r0 = r0.nowssid
                java.lang.String r2 = "DGO"
                int r0 = r0.indexOf(r2)
                if (r0 >= 0) goto L_0x0384
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r0 = r0.nowssid
                java.lang.String r2 = "DBG"
                int r0 = r0.indexOf(r2)
                if (r0 >= 0) goto L_0x0384
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r0 = r0.nowssid
                java.lang.String r2 = "DGOA"
                int r0 = r0.indexOf(r2)
                if (r0 >= 0) goto L_0x0384
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r0 = r0.nowssid
                java.lang.String r2 = "DGOB"
                int r0 = r0.indexOf(r2)
                if (r0 < 0) goto L_0x03c5
            L_0x0384:
                java.lang.String r0 = com.shix.shixipc.system.SystemValue.configWifiSSID
                java.lang.String r2 = r0.toString()
                java.lang.String r2 = java.net.URLEncoder.encode(r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x038f }
                goto L_0x0394
            L_0x038f:
                r0 = move-exception
                r5 = r0
                r5.printStackTrace()
            L_0x0394:
                r20 = r2
                java.lang.String r0 = com.shix.shixipc.system.SystemValue.configWifiPWD
                java.lang.String r2 = r0.toString()
                java.lang.String r0 = java.net.URLEncoder.encode(r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x03a3 }
                r21 = r0
                goto L_0x03aa
            L_0x03a3:
                r0 = move-exception
                r3 = r0
                r3.printStackTrace()
                r21 = r2
            L_0x03aa:
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                r2 = -1
                com.shix.shixipc.utils.CommonUtil.SaveCommonShare(r0, r7, r6, r2)
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r17 = r9.getDev_Did()
                java.lang.String r18 = com.shix.shixipc.system.SystemValue.configWifiSSID
                java.lang.String r19 = com.shix.shixipc.system.SystemValue.configWifiPWD
                r22 = 0
                r16 = r0
                r16.setWifi(r17, r18, r19, r20, r21, r22)
            L_0x03c5:
                com.shix.shixipc.system.SystemValue.configWifiSSID = r6
                goto L_0x03e5
            L_0x03c8:
                com.shix.shixipc.activity.FragmentCameraList r3 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r3 = r3.did
                java.lang.Boolean r3 = com.shix.shixipc.utils.CommonUtil.SHIX_isBkDid(r3)
                boolean r3 = r3.booleanValue()
                if (r3 != 0) goto L_0x03e8
                com.shix.shixipc.activity.FragmentCameraList r3 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r3 = r3.did
                boolean r3 = com.shix.shixipc.utils.CommonUtil.isMJCamera(r3)
                if (r3 == 0) goto L_0x03e5
                goto L_0x03e8
            L_0x03e5:
                r7 = r12
                goto L_0x0467
            L_0x03e8:
                java.util.TimeZone r3 = java.util.TimeZone.getDefault()     // Catch:{ JSONException -> 0x0462 }
                int r3 = r3.getRawOffset()     // Catch:{ JSONException -> 0x0462 }
                int r3 = -r3
                int r3 = r3 / 1000
                java.util.Calendar r5 = java.util.Calendar.getInstance()     // Catch:{ JSONException -> 0x0462 }
                long r17 = r5.getTimeInMillis()     // Catch:{ JSONException -> 0x0462 }
                r19 = 1000(0x3e8, double:4.94E-321)
                r7 = r12
                long r11 = r17 / r19
                int r10 = (int) r11     // Catch:{ JSONException -> 0x0460 }
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0460 }
                r11.<init>()     // Catch:{ JSONException -> 0x0460 }
                r11.append(r0)     // Catch:{ JSONException -> 0x0460 }
                r11.append(r3)     // Catch:{ JSONException -> 0x0460 }
                java.lang.String r11 = r11.toString()     // Catch:{ JSONException -> 0x0460 }
                android.util.Log.d(r2, r11)     // Catch:{ JSONException -> 0x0460 }
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0460 }
                r11.<init>()     // Catch:{ JSONException -> 0x0460 }
                r11.append(r0)     // Catch:{ JSONException -> 0x0460 }
                r11.append(r10)     // Catch:{ JSONException -> 0x0460 }
                r11.append(r6)     // Catch:{ JSONException -> 0x0460 }
                java.lang.String r0 = r11.toString()     // Catch:{ JSONException -> 0x0460 }
                android.util.Log.d(r2, r0)     // Catch:{ JSONException -> 0x0460 }
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0460 }
                r0.<init>()     // Catch:{ JSONException -> 0x0460 }
                java.lang.String r2 = "pro"
                java.lang.String r11 = "set_datetime"
                r0.put(r2, r11)     // Catch:{ JSONException -> 0x0460 }
                java.lang.String r2 = "cmd"
                r11 = 126(0x7e, float:1.77E-43)
                r0.put(r2, r11)     // Catch:{ JSONException -> 0x0460 }
                java.lang.String r2 = "user"
                java.lang.String r11 = com.shix.shixipc.system.SystemValue.doorBellAdmin     // Catch:{ JSONException -> 0x0460 }
                r0.put(r2, r11)     // Catch:{ JSONException -> 0x0460 }
                java.lang.String r2 = "pwd"
                java.lang.String r11 = com.shix.shixipc.system.SystemValue.doorBellPass     // Catch:{ JSONException -> 0x0460 }
                r0.put(r2, r11)     // Catch:{ JSONException -> 0x0460 }
                java.lang.String r2 = "time"
                r0.put(r2, r10)     // Catch:{ JSONException -> 0x0460 }
                java.lang.String r2 = "tz"
                r0.put(r2, r3)     // Catch:{ JSONException -> 0x0460 }
                java.lang.String r2 = r9.getDev_Did()     // Catch:{ JSONException -> 0x0460 }
                java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0460 }
                r3 = 0
                object.p2pipcam.nativecaller.NativeCaller.TransferMessage(r2, r0, r3)     // Catch:{ JSONException -> 0x0460 }
                goto L_0x0467
            L_0x0460:
                r0 = move-exception
                goto L_0x0464
            L_0x0462:
                r0 = move-exception
                r7 = r12
            L_0x0464:
                r0.printStackTrace()
            L_0x0467:
                java.lang.String r0 = com.shix.shixipc.system.ContentCommon.AP_ADD_UID
                if (r0 == 0) goto L_0x0528
                java.lang.String r0 = com.shix.shixipc.system.ContentCommon.AP_ADD_UID
                com.shix.shixipc.activity.FragmentCameraList r2 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r2 = r2.did
                boolean r0 = r0.equalsIgnoreCase(r2)
                if (r0 == 0) goto L_0x0528
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r2 = r9.getDev_Did()
                int r3 = r9.getResetrict()
                boolean r0 = r0.checkChina1(r2, r3)
                if (r0 == 0) goto L_0x048a
                return
            L_0x048a:
                int r0 = com.shix.shixipc.system.ContentCommon.AP_ADD_OR_CON
                r2 = 1
                if (r0 != r2) goto L_0x0493
                com.shix.shixipc.system.ContentCommon.AP_ADD_UID = r6
                goto L_0x0528
            L_0x0493:
                java.lang.String r0 = r9.getDev_Did()
                java.lang.String r2 = r9.getDev_name()
                java.lang.String r3 = r9.getDev_User()
                java.lang.String r10 = r9.getDev_Pwd()
                java.lang.String r11 = r9.getDev_User()
                com.shix.shixipc.system.SystemValue.doorBellAdmin = r11
                java.lang.String r11 = r9.getDev_Pwd()
                com.shix.shixipc.system.SystemValue.doorBellPass = r11
                java.lang.String r11 = "PPCS"
                boolean r11 = r0.startsWith(r11)
                if (r11 == 0) goto L_0x04c6
                android.content.Intent r11 = new android.content.Intent
                com.shix.shixipc.activity.FragmentCameraList r12 = com.shix.shixipc.activity.FragmentCameraList.this
                androidx.fragment.app.FragmentActivity r12 = r12.getActivity()
                java.lang.Class<com.shix.shixipc.activity.SixCameraActivity> r5 = com.shix.shixipc.activity.SixCameraActivity.class
                r11.<init>(r12, r5)
            L_0x04c4:
                r5 = 1
                goto L_0x04f3
            L_0x04c6:
                boolean r5 = com.shix.shixipc.utils.CommonUtil.isMJCamera(r0)
                if (r5 != 0) goto L_0x04e5
                java.lang.Boolean r5 = com.shix.shixipc.utils.CommonUtil.SHIX_isBkDid(r0)
                boolean r5 = r5.booleanValue()
                if (r5 == 0) goto L_0x04d7
                goto L_0x04e5
            L_0x04d7:
                android.content.Intent r11 = new android.content.Intent
                com.shix.shixipc.activity.FragmentCameraList r5 = com.shix.shixipc.activity.FragmentCameraList.this
                androidx.fragment.app.FragmentActivity r5 = r5.getActivity()
                java.lang.Class<com.shix.shixipc.activity.NDNCameraLiveActivity> r12 = com.shix.shixipc.activity.NDNCameraLiveActivity.class
                r11.<init>(r5, r12)
                goto L_0x04c4
            L_0x04e5:
                android.content.Intent r11 = new android.content.Intent
                com.shix.shixipc.activity.FragmentCameraList r5 = com.shix.shixipc.activity.FragmentCameraList.this
                androidx.fragment.app.FragmentActivity r5 = r5.getActivity()
                java.lang.Class<com.shix.shixipc.activity.MJCameraLiveActivity> r12 = com.shix.shixipc.activity.MJCameraLiveActivity.class
                r11.<init>(r5, r12)
                goto L_0x04c4
            L_0x04f3:
                r11.putExtra(r7, r5)
                java.lang.String r7 = "stream_type"
                r12 = 3
                r11.putExtra(r7, r12)
                r11.putExtra(r13, r2)
                r11.putExtra(r4, r0)
                r11.putExtra(r15, r3)
                r11.putExtra(r14, r10)
                int r0 = r9.getDevType()
                java.lang.String r2 = "camera_devtype"
                r11.putExtra(r2, r0)
                int r0 = r9.getDevMode()
                java.lang.String r2 = "camera_devmode"
                r11.putExtra(r2, r0)
                java.lang.String r0 = "modep"
                r2 = 1
                r11.putExtra(r0, r2)
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                r2 = 2
                r0.startActivityForResult(r11, r2)
                com.shix.shixipc.system.ContentCommon.AP_ADD_UID = r6
            L_0x0528:
                r0 = 5
                if (r8 == r0) goto L_0x053b
                r2 = 3
                if (r8 == r2) goto L_0x053b
                r0 = 6
                if (r8 == r0) goto L_0x053b
                r0 = 7
                if (r8 == r0) goto L_0x053b
                r2 = 8
                if (r8 == r2) goto L_0x053b
                r0 = 4
                if (r8 != r0) goto L_0x0556
            L_0x053b:
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r0 = r0.did
                object.p2pipcam.nativecaller.NativeCaller.StopPlayBack(r0)
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r0 = r0.did
                object.p2pipcam.nativecaller.NativeCaller.StopPPPPLivestream(r0)
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r2 = r0.did
                r0.StopPPPP(r2)
            L_0x0556:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.FragmentCameraList.AnonymousClass8.handleMessage(android.os.Message):void");
        }
    };
    private final int SNAPSHOT = 200;
    private Button btnEdit;
    private Button buttonAdd;
    private ListView cameraListView = null;
    /* access modifiers changed from: private */
    public String did;
    private int firstGo = 0;
    private int gltag;
    private ImageButton imbtn_add;
    private ImageButton imbtn_four;
    private ImageButton imbtn_ser;
    private ImageButton imbtn_view;
    /* access modifiers changed from: private */
    public boolean isAPMode = false;
    /* access modifiers changed from: private */
    public boolean isCheckConnect = false;
    private boolean isEdited = false;
    /* access modifiers changed from: private */
    public boolean isFirstAdd = false;
    /* access modifiers changed from: private */
    public Boolean isRunCheck = false;
    /* access modifiers changed from: private */
    public LinearLayout layoutAdd;
    public CameraListAdapter listAdapter = null;
    private WifiManager mWifiManager;
    String nowssid = "";
    private SharedPreferences preuser;
    private ProgressDialog progressDialog;
    private CameraInfoReceiver receiver = null;
    /* access modifiers changed from: private */
    public String strTestStatus = "";
    private String strUUID;
    int t_newVer = 0;

    public interface NewUiMainInterface {
        void CallBackStyle(int i);
    }

    private void PushDid() {
    }

    private void initCameraList() {
    }

    /* access modifiers changed from: private */
    public String getWifiSSID() {
        this.mWifiManager = (WifiManager) getActivity().getApplicationContext().getSystemService("wifi");
        if (!this.mWifiManager.isWifiEnabled()) {
            return "null ssid";
        }
        WifiInfo connectionInfo = this.mWifiManager.getConnectionInfo();
        String ssid = connectionInfo.getSSID();
        if (ssid.indexOf(ContentCommon.SHIX_APPRE) < 0 && ssid.indexOf(ContentCommon.SHIX_APPRE1) < 0 && ssid.indexOf(ContentCommon.SHIX_APPRE2) < 0 && ssid.indexOf(ContentCommon.SHIX_APPRE3) < 0 && ssid.indexOf(ContentCommon.SHIX_APPRE4) < 0) {
            int networkId = connectionInfo.getNetworkId();
            List<WifiConfiguration> configuredNetworks = this.mWifiManager.getConfiguredNetworks();
            if (configuredNetworks != null) {
                Iterator<WifiConfiguration> it = configuredNetworks.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    WifiConfiguration next = it.next();
                    if (next.networkId == networkId) {
                        ssid = next.SSID;
                        break;
                    }
                }
            } else {
                return "null ssid";
            }
        }
        if (ssid == null) {
            return "null ssid";
        }
        return (!ssid.startsWith("\"") || !ssid.endsWith("\"")) ? ssid : ssid.substring(1, ssid.length() - 1);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int versionCode = CommonUtil.getVersionCode(getActivity());
        this.t_newVer = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), CommonAppUtil.SHIXAPP_NEWVER, 0);
        CommonUtil.Log(2, "SHIXAPPVER appVer:" + versionCode + "  t_newVer:" + this.t_newVer);
        int i = this.t_newVer;
        if (!(i == 0 || versionCode == 0 || i <= versionCode)) {
            this.PPPPMsgHandler.sendEmptyMessageDelayed(9090, 1000);
        }
        NUIMainActivity.setConnectStatusInterface1(new NUIMainActivity.ConnectStatusInterface1() {
            public void BSMsgNotifyData(String str, int i, int i2) {
                Bundle bundle = new Bundle();
                Message obtainMessage = FragmentCameraList.this.PPPPMsgHandler.obtainMessage();
                obtainMessage.what = i;
                bundle.putInt(FragmentCameraList.STR_MSG_PARAM, i2);
                bundle.putString(FragmentCameraList.STR_DID, str);
                obtainMessage.setData(bundle);
                FragmentCameraList.this.PPPPMsgHandler.sendMessage(obtainMessage);
            }

            public void BSCallBack_TYPEMODE(String str, String str2) {
                int i;
                int i2;
                String str3;
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    int i3 = -1;
                    try {
                        i = jSONObject.getInt("restrict");
                    } catch (JSONException unused) {
                        i = -1;
                    }
                    try {
                        i2 = jSONObject.getInt("type");
                    } catch (JSONException unused2) {
                        i2 = -1;
                    }
                    try {
                        i3 = jSONObject.getInt("mode");
                    } catch (JSONException unused3) {
                    }
                    try {
                        str3 = jSONObject.getString("checkstr");
                    } catch (JSONException unused4) {
                        str3 = "NO";
                    }
                    CommonUtil.Log(1, "BSCallBack_TYPEMODE:" + str2);
                    Bundle bundle = new Bundle();
                    Message obtainMessage = FragmentCameraList.this.PPPPMsgHandler.obtainMessage();
                    obtainMessage.what = 3;
                    bundle.putInt(FragmentCameraList.STR_MSG_PARAM, i);
                    bundle.putString(FragmentCameraList.STR_DID, str);
                    bundle.putString(FragmentCameraList.STR_CHECK, str3);
                    bundle.putInt(FragmentCameraList.STR_TYPE, i2);
                    bundle.putInt(FragmentCameraList.STR_MODE, i3);
                    obtainMessage.setData(bundle);
                    FragmentCameraList.this.PPPPMsgHandler.sendMessage(obtainMessage);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        this.isRunCheck = false;
        this.preuser = getActivity().getSharedPreferences("shix_zhao_user", 0);
        this.gltag = this.preuser.getInt("gltag", 0);
        ContentCommon.AP_ADD_UID = "";
        this.strUUID = this.preuser.getString("SHIXUUID", "");
        String str = this.strUUID;
        if (str == null || str.length() < 2) {
            this.strUUID = UUID.randomUUID().toString();
            SharedPreferences.Editor edit = this.preuser.edit();
            edit.putString("SHIXUUID", this.strUUID);
            edit.commit();
        }
        contextL = getContext();
        SettingActivity.setDeleDetInterface(this);
        View inflate = layoutInflater.inflate(R.layout.fragment_cameralist, viewGroup, false);
        this.buttonAdd = (Button) inflate.findViewById(R.id.buttonAdd);
        this.layoutAdd = (LinearLayout) inflate.findViewById(R.id.layoutAdd);
        this.cameraListView = (ListView) inflate.findViewById(R.id.listviewCamera);
        this.buttonAdd.setOnClickListener(this);
        this.imbtn_four = (ImageButton) inflate.findViewById(R.id.imbtn_four);
        this.imbtn_view = (ImageButton) inflate.findViewById(R.id.imbtn_view);
        this.imbtn_ser = (ImageButton) inflate.findViewById(R.id.imbtn_ser);
        this.imbtn_add = (ImageButton) inflate.findViewById(R.id.imbtn_add);
        this.imbtn_four.setOnClickListener(this);
        this.imbtn_view.setOnClickListener(this);
        this.imbtn_ser.setOnClickListener(this);
        this.imbtn_add.setOnClickListener(this);
        this.btnEdit = (Button) inflate.findViewById(R.id.main_edit);
        this.btnEdit.setOnClickListener(this);
        this.listAdapter = new CameraListAdapter(getActivity(), this, this.gltag);
        this.cameraListView.setAdapter(this.listAdapter);
        this.cameraListView.setOnItemClickListener(this);
        ContentCommon.SHIX_getDevs();
        new Thread(new StartPPPPThread()).start();
        int i2 = this.gltag;
        NewUiMainInterface newUiMainInterface2 = newUiMainInterface;
        if (newUiMainInterface2 != null) {
            newUiMainInterface2.CallBackStyle(i2);
        }
        this.cameraListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(FragmentCameraList.this.getActivity(), 10);
                }
                CameraParamsBean itemCamera = FragmentCameraList.this.listAdapter.getItemCamera(i);
                String dev_name = itemCamera.getDev_name();
                String dev_Did = itemCamera.getDev_Did();
                String dev_User = itemCamera.getDev_User();
                String dev_Pwd = itemCamera.getDev_Pwd();
                Intent intent = new Intent(FragmentCameraList.this.getActivity(), AddCameraActivity.class);
                intent.putExtra(ContentCommon.CAMERA_OPTION, 2);
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, dev_name);
                intent.putExtra(ContentCommon.STR_CAMERA_ID, dev_Did);
                intent.putExtra(ContentCommon.STR_CAMERA_USER, dev_User);
                intent.putExtra(ContentCommon.STR_CAMERA_PWD, dev_Pwd);
                FragmentCameraList.this.startActivity(intent);
                AddCameraActivity.setDeleInterface(FragmentCameraList.this);
                return true;
            }
        });
        return inflate;
    }

    public void GetWXStatus(final String str) {
        new Thread() {
            public void run() {
                PayHttpUtils payHttpUtils = new PayHttpUtils();
                try {
                    FragmentCameraList fragmentCameraList = FragmentCameraList.this;
                    String unused = fragmentCameraList.strTestStatus = payHttpUtils.get(NativeCaller.SHIXGetAPPPay(1) + str);
                    CommonUtil.Log(1, "zhaoe strTestStatus:" + FragmentCameraList.this.strTestStatus);
                } catch (IOException e) {
                    CommonUtil.Log(1, "zhaoe:" + e.toString());
                    String unused2 = FragmentCameraList.this.strTestStatus = e.toString();
                    e.printStackTrace();
                }
                CommonUtil.Log(2, "ZHAOPAYTEST:fra strTestStatus:" + FragmentCameraList.this.strTestStatus);
            }
        }.start();
    }

    public void onResume() {
        String GetCommonShareStringValue = CommonUtil.GetCommonShareStringValue(getActivity(), "wxorderid", "");
        CommonUtil.Log(2, "ZHAOPAYTEST:fra wxorderid:" + GetCommonShareStringValue);
        if (GetCommonShareStringValue != null && GetCommonShareStringValue.length() > 1) {
            CommonUtil.SaveCommonShare(getActivity(), "wxorderid", "", 0);
            GetWXStatus(GetCommonShareStringValue);
        }
        this.firstGo = this.preuser.getInt("firstGo", 0);
        if (this.firstGo == 0) {
            new Thread() {
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    FragmentCameraList.this.PPPPMsgHandler.sendEmptyMessage(12330);
                    super.run();
                }
            }.start();
        }
        SystemValue.isApMode = false;
        this.nowssid = getWifiSSID();
        CommonUtil.Log(1, "nowssid:" + this.nowssid);
        if (this.nowssid.indexOf(ContentCommon.SHIX_APPRE) >= 0 || this.nowssid.indexOf(ContentCommon.SHIX_APPRE1) >= 0 || this.nowssid.indexOf(ContentCommon.SHIX_APPRE2) >= 0 || this.nowssid.indexOf(ContentCommon.SHIX_APPRE3) >= 0 || this.nowssid.indexOf(ContentCommon.SHIX_APPRE4) >= 0) {
            this.nowssid = this.nowssid.replace("-", "");
            new Thread() {
                public void run() {
                    super.run();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    FragmentCameraList.this.getActivity().runOnUiThread(new Runnable() {
                        public void run() {
                            if (CommonUtil.SHIX_isBkDid(FragmentCameraList.this.nowssid).booleanValue()) {
                                boolean unused = FragmentCameraList.this.isFirstAdd = false;
                                boolean unused2 = FragmentCameraList.this.isAPMode = true;
                                FragmentCameraList.this.addCamera(FragmentCameraList.this.nowssid);
                            } else if (!CommonUtil.isMJCamera(FragmentCameraList.this.nowssid)) {
                                boolean unused3 = FragmentCameraList.this.isFirstAdd = false;
                                boolean unused4 = FragmentCameraList.this.isAPMode = true;
                                FragmentCameraList.this.addCamera(FragmentCameraList.this.nowssid);
                            }
                            if (SystemValue.arrayList.size() == 0) {
                                FragmentCameraList.this.layoutAdd.setVisibility(0);
                            } else {
                                FragmentCameraList.this.layoutAdd.setVisibility(8);
                            }
                        }
                    });
                }
            }.start();
            SystemValue.isApMode = true;
        } else {
            this.isAPMode = false;
        }
        if (SystemValue.arrayList.size() == 0) {
            this.layoutAdd.setVisibility(0);
        } else {
            this.layoutAdd.setVisibility(8);
        }
        this.listAdapter.notifyDataSetChanged();
        getNotification();
        super.onResume();
    }

    /* access modifiers changed from: private */
    public void addCamera(String str) {
        String replace = str.replace("-", "");
        Iterator<CameraParamsBean> it = SystemValue.arrayList.iterator();
        while (it.hasNext()) {
            if (replace.equalsIgnoreCase(it.next().getDev_Did())) {
                return;
            }
        }
        this.isFirstAdd = true;
        ContentCommon.AP_ADD_UID = replace;
        CameraParamsBean cameraParamsBean = new CameraParamsBean();
        cameraParamsBean.setDev_Did(replace);
        cameraParamsBean.setDev_name(ContentCommon.SHIX_DEFUALT_NAME);
        cameraParamsBean.setDev_User("admin");
        cameraParamsBean.setDev_Pwd(ContentCommon.SHIX_DEFUALT_PWD);
        SystemValue.arrayList.add(cameraParamsBean);
        ContentCommon.SHIX_saveDev(cameraParamsBean);
        Intent intent = new Intent();
        intent.setAction(ContentCommon.STR_CAMERA_INFO_RECEIVER);
        intent.putExtra(ContentCommon.CAMERA_OPTION, 5);
        intent.putExtra(ContentCommon.STR_CAMERA_ID, replace);
        getActivity().sendBroadcast(intent);
    }

    public void CallBackDel(String str, String str2) {
        CommonUtil.Log(1, "zhaogenghuai CallBackDel:" + str);
        CameraParamsBean cameraBean = getCameraBean(str);
        if (cameraBean != null && cameraBean.getDev_p2pstatus() == 2) {
            CommonUtil.SHIX_Delpush(cameraBean.getDev_User(), cameraBean.getDev_Pwd(), this.strUUID);
        }
        showDeleteCameraDialog(str, Effectstype.Slidetop, str2);
    }

    private void showDeleteCameraDialog(final String str, Effectstype effectstype, String str2) {
        if (str != null) {
            try {
                delPhoneKey(str);
            } catch (Exception unused) {
            }
        }
        final NiftyDialogBuilder instance = NiftyDialogBuilder.getInstance(getActivity());
        instance.withTitle(str2).withMessage((CharSequence) getString(R.string.tips_msg_delete_camera)).withEffect(effectstype).setButton1Click(new View.OnClickListener() {
            public void onClick(View view) {
                instance.dismiss();
            }
        }).setButton2Click(new View.OnClickListener() {
            public void onClick(View view) {
                FragmentCameraList.this.StopPPPP(str);
                ContentCommon.SHIX_delDev(FragmentCameraList.this.getCameraBean(str));
                FragmentCameraList.this.listAdapter.notifyDataSetChanged();
                if (SystemValue.arrayList.size() == 0) {
                    FragmentCameraList.this.layoutAdd.setVisibility(0);
                } else {
                    FragmentCameraList.this.layoutAdd.setVisibility(8);
                }
                instance.dismiss();
            }
        }).show();
    }

    public void CallBackDelSet(String str, String str2) {
        CommonUtil.Log(1, "zhaogenghuai CallBackDel:" + str);
        showDeleteCameraDialog(str, Effectstype.Slidetop, str2);
    }

    private class GetDataTask extends AsyncTask<Void, Void, Void> {
        private GetDataTask() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            Boolean unused = FragmentCameraList.this.isRunCheck = true;
        }

        class StopPPPPThread implements Runnable {
            StopPPPPThread() {
            }

            public void run() {
                try {
                    Thread.sleep(10);
                    GetDataTask.this.StopCameraPPPP();
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: private */
        public void StopCameraPPPP() {
            int count = FragmentCameraList.this.listAdapter.getCount();
            for (int i = 0; i < count; i++) {
                CameraParamsBean onItem = FragmentCameraList.this.listAdapter.getOnItem(i);
                if (!(onItem.getDev_p2pstatus() == 2 || onItem.getDev_p2pstatus() == 0)) {
                    NativeCaller.StopPPPP(onItem.getDev_Did());
                    try {
                        Thread.sleep(300);
                    } catch (Exception unused) {
                    }
                    FragmentCameraList.this.StartPPPP(onItem.getDev_Did(), onItem.getDev_User(), onItem.getDev_Pwd(), ContentCommon.SERVER_STRING);
                }
            }
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... voidArr) {
            new Thread(new StopPPPPThread()).start();
            try {
                Thread.sleep(1000);
                return null;
            } catch (InterruptedException unused) {
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void voidR) {
            FragmentCameraList.this.listAdapter.notifyDataSetChanged();
            Boolean unused = FragmentCameraList.this.isRunCheck = false;
            super.onPostExecute(voidR);
        }
    }

    class StartPPPPThread implements Runnable {
        StartPPPPThread() {
        }

        public void run() {
            try {
                Thread.sleep(1000);
                FragmentCameraList.this.StartCameraPPPP();
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void StartCameraPPPP() {
        int count = this.listAdapter.getCount();
        for (int i = 0; i < count; i++) {
            CameraParamsBean onItem = this.listAdapter.getOnItem(i);
            try {
                Thread.sleep(100);
            } catch (Exception unused) {
            }
            CommonUtil.Log(1, "SHIXZHAO isAPMode:" + this.isAPMode + "  AP_ADD_OR_CON:" + ContentCommon.AP_ADD_OR_CON + "  nowssid:" + this.nowssid + "  getDev_Did():" + onItem.getDev_Did());
            if (!this.isFirstAdd || !this.nowssid.equalsIgnoreCase(onItem.getDev_Did())) {
                StartPPPP(onItem.getDev_Did(), onItem.getDev_User(), onItem.getDev_Pwd());
            }
        }
    }

    public void onStart() {
        if (this.receiver == null) {
            this.receiver = new CameraInfoReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ContentCommon.STR_CAMERA_INFO_RECEIVER);
            intentFilter.addAction("back");
            intentFilter.addAction("other");
            getActivity().registerReceiver(this.receiver, intentFilter);
        }
        super.onStart();
    }

    public void onDestroy() {
        this.isCheckConnect = false;
        SystemValue.TAG_CAMERLIST = 0;
        getActivity().unregisterReceiver(this.receiver);
        super.onDestroy();
    }

    public void onClick(View view) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(getActivity(), 10);
        }
        int id = view.getId();
        if (id == R.id.buttonAdd) {
            startActivity(new Intent(getActivity(), AddShowActivity.class));
        } else if (id != R.id.main_edit) {
            switch (id) {
                case R.id.imbtn_add:
                    startActivity(new Intent(getActivity(), AddShowActivity.class));
                    return;
                case R.id.imbtn_four:
                    if (isTestApp(this.nowssid, 3)) {
                        showToastLong("当前使用的是生产测试软件，No use");
                        return;
                    } else {
                        startActivity(new Intent(getActivity(), FourPlaySportActivty.class));
                        return;
                    }
                case R.id.imbtn_ser:
                    if (isTestApp(this.nowssid, 1)) {
                        showToastLong("当前使用的是生产测试软件，no use 1");
                        return;
                    }
                    Intent intent = new Intent(getActivity(), SertchActivity.class);
                    intent.putExtra("sType", 110);
                    startActivity(intent);
                    return;
                case R.id.imbtn_view:
                    if (this.gltag == 0) {
                        this.gltag = 1;
                    } else {
                        this.gltag = 0;
                    }
                    NewUiMainInterface newUiMainInterface2 = newUiMainInterface;
                    if (newUiMainInterface2 != null) {
                        newUiMainInterface2.CallBackStyle(this.gltag);
                    }
                    this.listAdapter = new CameraListAdapter(getActivity(), this, this.gltag);
                    this.cameraListView.setAdapter(this.listAdapter);
                    this.listAdapter.notifyDataSetChanged();
                    SharedPreferences.Editor edit = this.preuser.edit();
                    edit.putInt("gltag", this.gltag);
                    edit.commit();
                    return;
                default:
                    return;
            }
        }
    }

    class CameraInfoReceiver extends BroadcastReceiver {
        CameraInfoReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.e("zhaogenghuai1", "CameraInfoReceiver");
            if ("other".equals(action)) {
                FragmentCameraList.this.listAdapter.sendCameraStatus();
                return;
            }
            int intExtra = intent.getIntExtra(ContentCommon.CAMERA_OPTION, 65535);
            if (intExtra != 65535) {
                final String stringExtra = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
                final String stringExtra2 = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
                String stringExtra3 = intent.getStringExtra(ContentCommon.STR_CAMERA_USER);
                String stringExtra4 = intent.getStringExtra(ContentCommon.STR_CAMERA_PWD);
                if (stringExtra2 != null && intExtra == 5) {
                    CameraParamsBean access$600 = FragmentCameraList.this.getCameraBean(stringExtra2);
                    if (access$600 != null) {
                        CommonUtil.Log(1, "zhaogenghuai1:" + access$600.getDev_Did());
                        FragmentCameraList.this.StopPPPP(stringExtra2);
                        FragmentCameraList.this.StartPPPP(access$600.getDev_Did(), access$600.getDev_User(), access$600.getDev_Pwd());
                    } else {
                        CommonUtil.Log(1, "zhaogenghuai1: bean==null");
                    }
                }
                if (intExtra == 2) {
                    if (FragmentCameraList.this.listAdapter.UpdateCamera(intent.getStringExtra(ContentCommon.STR_CAMERA_OLD_ID), stringExtra, stringExtra2, stringExtra3, stringExtra4)) {
                        FragmentCameraList.this.listAdapter.notifyDataSetChanged();
                        FragmentCameraList.this.StopPPPP(stringExtra2);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        FragmentCameraList.this.StartPPPP(stringExtra2, stringExtra3, stringExtra4);
                    }
                } else if (intExtra == 3) {
                    if (FragmentCameraList.this.listAdapter.UpdateCamera(intent.getStringExtra(ContentCommon.STR_CAMERA_OLD_ID), stringExtra, stringExtra2, stringExtra3, stringExtra4)) {
                        FragmentCameraList.this.listAdapter.notifyDataSetChanged();
                        FragmentCameraList.this.StopPPPP(stringExtra2);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        FragmentCameraList.this.StartPPPP(stringExtra2, stringExtra3, stringExtra4);
                    }
                } else if (FragmentCameraList.this.listAdapter.getCount() < 20) {
                    CommonUtil.Log(1, "zhaogenghuai2 listAdapter.getCount() < 20");
                    if (FragmentCameraList.this.listAdapter.AddCamera(stringExtra, stringExtra2, stringExtra3, stringExtra4)) {
                        FragmentCameraList.this.listAdapter.notifyDataSetChanged();
                        CommonUtil.Log(1, "zhaogenghuai2 StopPPPP(did);");
                        FragmentCameraList.this.StartPPPP(stringExtra2, stringExtra3, stringExtra4);
                        CommonUtil.Log(1, "zhaogenghuai2 StartPPPP(did):" + stringExtra2);
                        new Thread() {
                            public void run() {
                                Intent intent = new Intent("del_add_modify_camera");
                                intent.putExtra("type", 1);
                                intent.putExtra(ContentCommon.STR_CAMERA_ID, stringExtra2);
                                intent.putExtra("name", stringExtra);
                                FragmentCameraList.this.getActivity().sendBroadcast(intent);
                            }
                        }.start();
                        if (SystemValue.arrayList.size() == 0) {
                            FragmentCameraList.this.layoutAdd.setVisibility(0);
                        } else {
                            FragmentCameraList.this.layoutAdd.setVisibility(8);
                        }
                    }
                } else {
                    FragmentCameraList.this.showToast((int) R.string.add_camer_no_add);
                }
            }
        }
    }

    private synchronized boolean delCameraFromdb(String str) {
        return false;
    }

    private synchronized void addCamera2db(String str, String str2, String str3, String str4) {
    }

    public void showSetting(int i, int i2) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(getActivity(), 10);
        }
        CameraParamsBean itemCamera = this.listAdapter.getItemCamera(i);
        int resetrict = itemCamera.getResetrict();
        if (!(itemCamera.getDev_p2pstatus() == 2 || resetrict == 1)) {
            resetrict = 1;
        }
        if (isTestApp(this.nowssid, resetrict)) {
            showToastLong("当前使用的是生产测试软件，X");
            return;
        }
        SystemValue.position = i;
        SystemValue.doorBellAdmin = itemCamera.getDev_User();
        SystemValue.doorBellPass = itemCamera.getDev_Pwd();
        SystemValue.devMode = itemCamera.getDevMode();
        Intent intent = new Intent();
        if (itemCamera.getDev_p2pstatus() != 2 || !checkChina(itemCamera.getDev_Did(), itemCamera.getResetrict())) {
            switch (i2) {
                case R.id.imgBtnPPPPSetting:
                    CommonUtil.Log(1, "zhaogenghuai 5");
                    intent.setClass(getActivity(), SettingActivity.class);
                    break;
                case R.id.llAlarm:
                    CommonUtil.Log(1, "zhaogenghuai 1");
                    intent.setClass(getActivity(), ClouDateActivity.class);
                    break;
                case R.id.llPic:
                    CommonUtil.Log(1, "zhaogenghuai 3");
                    intent.setClass(getActivity(), LocalPictureActivity.class);
                    intent.putExtra("type", 0);
                    break;
                case R.id.llSetting:
                    CommonUtil.Log(1, "zhaogenghuai 4");
                    intent.setClass(getActivity(), SettingActivity.class);
                    break;
                case R.id.llVideo:
                    CommonUtil.Log(1, "zhaogenghuai 2");
                    intent.setClass(getActivity(), LocalPictureActivity.class);
                    intent.putExtra("type", 1);
                    break;
            }
            intent.putExtra(ContentCommon.STR_CAMERA_ID, itemCamera.getDev_Did());
            intent.putExtra(ContentCommon.STR_CAMERA_NAME, itemCamera.getDev_name());
            startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    public CameraParamsBean getCameraBean(String str) {
        int count = this.listAdapter.getCount();
        for (int i = 0; i < count; i++) {
            CameraParamsBean onItem = this.listAdapter.getOnItem(i);
            if (onItem.getDev_Did().equalsIgnoreCase(str)) {
                SystemValue.position = i;
                return onItem;
            }
        }
        return null;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Intent intent;
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(getActivity(), 10);
        }
        CameraParamsBean onItem = this.listAdapter.getOnItem(i);
        Log.d(ContentCommon.SERVER_STRING, "00000000");
        if (onItem == null) {
            Log.d(ContentCommon.SERVER_STRING, "111111");
            return;
        }
        int resetrict = onItem.getResetrict();
        if (!(onItem.getDev_p2pstatus() == 2 || resetrict == 1)) {
            resetrict = 1;
        }
        if (isTestApp(this.nowssid, resetrict)) {
            showToastLong("当前使用的是生产测试软件，X");
        } else if (onItem.getDev_p2pstatus() != 2 || !checkChina(onItem.getDev_Did(), onItem.getResetrict())) {
            int dev_p2pstatus = onItem.getDev_p2pstatus();
            Log.d(ContentCommon.SERVER_STRING, "22222222");
            if (dev_p2pstatus == 5 || dev_p2pstatus == 7 || dev_p2pstatus == 6 || dev_p2pstatus == 8 || dev_p2pstatus == 3 || dev_p2pstatus == 4) {
                Log.d(ContentCommon.SERVER_STRING, "33333333");
                Log.d(ContentCommon.SERVER_STRING, "55555555");
                StartPPPP(onItem.getDev_Did(), onItem.getDev_User(), onItem.getDev_Pwd(), ContentCommon.SERVER_STRING);
                return;
            }
            Log.d(ContentCommon.SERVER_STRING, "4444444444");
            if (dev_p2pstatus == 2) {
                String dev_Did = onItem.getDev_Did();
                String dev_name = onItem.getDev_name();
                String dev_User = onItem.getDev_User();
                String dev_Pwd = onItem.getDev_Pwd();
                SystemValue.doorBellAdmin = onItem.getDev_User();
                SystemValue.doorBellPass = onItem.getDev_Pwd();
                SystemValue.devType = onItem.getDevType();
                SystemValue.devMode = onItem.getDevMode();
                if (onItem.isBkDoorBell()) {
                    CommonUtil.Log(1, "bean.isBkDoorBell():" + onItem.isBkDoorBell());
                    intent = new Intent(getActivity(), BellLiveActivity.class);
                } else if (CommonUtil.SHIX_isBkDid(dev_Did).booleanValue()) {
                    CommonUtil.Log(1, "SHIX_isBkDid(did):" + dev_Did);
                    intent = new Intent(getActivity(), MJCameraLiveActivity.class);
                } else if (CommonUtil.isMJCamera(dev_Did)) {
                    CommonUtil.Log(1, "isMJCamera(did):" + dev_Did);
                    intent = new Intent(getActivity(), MJCameraLiveActivity.class);
                } else {
                    CommonUtil.Log(1, "Others(did):" + dev_Did);
                    intent = new Intent(getActivity(), NDNCameraLiveActivity.class);
                }
                intent.putExtra("callType", 1);
                intent.putExtra(ContentCommon.STR_CAMERA_TYPE, 1);
                intent.putExtra(ContentCommon.STR_STREAM_TYPE, 3);
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, dev_name);
                intent.putExtra(ContentCommon.STR_CAMERA_ID, dev_Did);
                intent.putExtra(ContentCommon.STR_CAMERA_USER, dev_User);
                intent.putExtra(ContentCommon.STR_CAMERA_PWD, dev_Pwd);
                intent.putExtra(ContentCommon.STR_CAMERA_DEVTYPE, onItem.getDevType());
                intent.putExtra(ContentCommon.STR_CAMERA_DEVMODE, onItem.getDevMode());
                intent.putExtra(ContentCommon.STR_APP_UUID, this.strUUID);
                intent.putExtra("modep", 1);
                startActivityForResult(intent, 2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void setWifi(String str, String str2, String str3, String str4, String str5, int i) {
        NativeCaller.TransferMessage(str, CommonUtil.SHIX_SetWifi(SystemValue.doorBellAdmin, SystemValue.doorBellPass, str2, str3, str4, str5, i), 0);
    }

    class CheckConnectThread extends Thread {
        CheckConnectThread() {
        }

        public void run() {
            while (FragmentCameraList.this.isCheckConnect) {
                int i = 0;
                int i2 = 0;
                while (i2 < 3) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception unused) {
                    }
                    if (FragmentCameraList.this.isCheckConnect) {
                        i2++;
                    } else {
                        return;
                    }
                }
                int size = SystemValue.arrayList.size();
                while (true) {
                    if (i < size) {
                        CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i);
                        if (FragmentCameraList.this.isCheckConnect) {
                            try {
                                Thread.sleep(100);
                            } catch (Exception unused2) {
                            }
                            if (FragmentCameraList.this.isCheckConnect) {
                                if (!cameraParamsBean.isBkDoorBell()) {
                                    try {
                                        Thread.sleep(100);
                                    } catch (Exception unused3) {
                                    }
                                } else if (cameraParamsBean.getDev_p2pstatus() == 6 || cameraParamsBean.getDev_p2pstatus() == 7) {
                                    NativeCaller.StopPPPP(cameraParamsBean.getDev_Did());
                                    try {
                                        Thread.sleep(300);
                                    } catch (Exception unused4) {
                                    }
                                    FragmentCameraList.this.StartPPPP(cameraParamsBean.getDev_Did(), cameraParamsBean.getDev_User(), cameraParamsBean.getDev_Pwd());
                                }
                                i++;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
            super.run();
        }
    }

    private void showConfigWifiDialog(final String str, Effectstype effectstype, String str2) {
        final NiftyDialogBuilder instance = NiftyDialogBuilder.getInstance(getActivity());
        instance.withTitle(str2).withMessage((CharSequence) getString(R.string.ap_add_title2)).withEffect(effectstype).setButton1Click(new View.OnClickListener() {
            public void onClick(View view) {
                instance.dismiss();
            }
        }).setButton2Click(new View.OnClickListener() {
            public void onClick(View view) {
                CameraParamsBean access$600 = FragmentCameraList.this.getCameraBean(str);
                access$600.getDev_Did();
                access$600.getDev_name();
                Intent intent = new Intent(FragmentCameraList.this.getActivity(), SettingWifiActivity.class);
                intent.putExtra(ContentCommon.STR_CAMERA_ID, access$600.getDev_Did());
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, access$600.getDev_name());
                FragmentCameraList.this.startActivity(intent);
                instance.dismiss();
            }
        }).show();
    }

    /* access modifiers changed from: private */
    public String retrunName(String str) {
        int i = 0;
        while (i < SystemValue.arrayList.size()) {
            if (str == null || !str.equals(SystemValue.arrayList.get(i).getDev_Did().replace("-", "").toUpperCase())) {
                i++;
            } else {
                Log.d("tag", "testuser:" + SystemValue.arrayList.get(i).getDev_name());
                return SystemValue.arrayList.get(i).getDev_name();
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public String retrunUser(String str) {
        int i = 0;
        while (i < SystemValue.arrayList.size()) {
            if (str == null || !str.equals(SystemValue.arrayList.get(i).getDev_Did().replace("-", "").toUpperCase())) {
                i++;
            } else {
                Log.d("tag", "testuser:" + SystemValue.arrayList.get(i).getDev_User());
                return SystemValue.arrayList.get(i).getDev_User();
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public String retrunUserPWD(String str) {
        int i = 0;
        while (i < SystemValue.arrayList.size()) {
            if (str == null || !str.equals(SystemValue.arrayList.get(i).getDev_Did().replace("-", "").toUpperCase())) {
                i++;
            } else {
                Log.d("tag", "testuserpwd:" + SystemValue.arrayList.get(i).getDev_Pwd());
                return SystemValue.arrayList.get(i).getDev_Pwd();
            }
        }
        return null;
    }

    public static void setNewUiMainInterface(NewUiMainInterface newUiMainInterface2) {
        newUiMainInterface = newUiMainInterface2;
    }

    private void getNotification() {
        if (!NotificationManagerCompat.from(getActivity()).areNotificationsEnabled()) {
            SystemValue.isExitApp = false;
            new AlertDialog.Builder(getActivity()).setCancelable(true).setTitle("检测到通知权限未开启 !").setMessage("如果不开启权限会收不到推送通知哦 ~").setNegativeButton("取消", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            }).setPositiveButton("去开启", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                    Intent intent = new Intent();
                    if (Build.VERSION.SDK_INT >= 26) {
                        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                        intent.putExtra("android.provider.extra.APP_PACKAGE", FragmentCameraList.this.getActivity().getPackageName());
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                        intent.putExtra("app_package", FragmentCameraList.this.getActivity().getPackageName());
                        intent.putExtra("app_uid", FragmentCameraList.this.getActivity().getApplicationInfo().uid);
                        FragmentCameraList.this.startActivity(intent);
                    } else if (Build.VERSION.SDK_INT == 19) {
                        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.addCategory("android.intent.category.DEFAULT");
                        intent.setData(Uri.parse("package:" + FragmentCameraList.this.getActivity().getPackageName()));
                    } else if (Build.VERSION.SDK_INT >= 15) {
                        intent.addFlags(268435456);
                        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.fromParts("package", FragmentCameraList.this.getActivity().getPackageName(), (String) null));
                    }
                    FragmentCameraList.this.startActivity(intent);
                }
            }).create().show();
        }
    }

    public void launchAppDetail(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
                if (!TextUtils.isEmpty(str2)) {
                    intent.setPackage(str2);
                }
                intent.addFlags(268435456);
                startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
