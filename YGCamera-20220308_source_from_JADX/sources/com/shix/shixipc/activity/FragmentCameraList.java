package com.shix.shixipc.activity;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.shix.shixipc.BaseFragment;
import com.shix.shixipc.activity.AddCameraActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.activity.SettingActivity;
import com.shix.shixipc.adapter.CameraListAdapter;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.SharedPreferencesUtils;
import com.shix.shixipc.view.Effectstype;
import com.shix.shixipc.view.NiftyDialogBuilder;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.UUID;
import object.p2pipcam.nativecaller.NativeCaller;
import org.json.JSONException;
import org.json.JSONObject;
import shix.cykj.camera.R;

public class FragmentCameraList extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener, AddCameraActivity.DeleInterface, SettingActivity.DeleDetInterface {
    private static final String STR_DID = "did";
    private static final String STR_MODE = "strmode";
    private static final String STR_MSG_PARAM = "msgparam";
    private static final String STR_TYPE = "strtype";
    public static Context contextL;
    private static NewUiMainInterface newUiMainInterface;
    /* access modifiers changed from: private */
    public Handler PPPPMsgHandler = new Handler() {
        /* JADX WARNING: Removed duplicated region for block: B:42:0x0246 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x0247  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r26) {
            /*
                r25 = this;
                r1 = r25
                java.lang.String r2 = ""
                java.lang.String r3 = "tz:"
                java.lang.String r4 = "tag"
                android.os.Bundle r0 = r26.getData()
                java.lang.String r5 = "msgparam"
                int r5 = r0.getInt(r5)
                r6 = r26
                int r6 = r6.what
                com.shix.shixipc.activity.FragmentCameraList r7 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r8 = "did"
                java.lang.String r8 = r0.getString(r8)
                java.lang.String unused = r7.did = r8
                java.lang.String r7 = "strtype"
                int r7 = r0.getInt(r7)
                java.lang.String r8 = "strmode"
                int r0 = r0.getInt(r8)
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r9 = "did=="
                r8.append(r9)
                com.shix.shixipc.activity.FragmentCameraList r9 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r9 = r9.did
                r8.append(r9)
                java.lang.String r9 = "  msgType="
                r8.append(r9)
                r8.append(r6)
                java.lang.String r8 = r8.toString()
                java.lang.String r9 = "test"
                android.util.Log.d(r9, r8)
                r8 = 8
                r9 = 3
                r10 = 1
                if (r6 == 0) goto L_0x00f0
                if (r6 == r10) goto L_0x00d8
                if (r6 == r9) goto L_0x0093
                r0 = 200(0xc8, float:2.8E-43)
                if (r6 == r0) goto L_0x008a
                r0 = 12345(0x3039, float:1.7299E-41)
                if (r6 == r0) goto L_0x0065
                goto L_0x0318
            L_0x0065:
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                com.shix.shixipc.adapter.CameraListAdapter r0 = r0.listAdapter
                r0.notifyDataSetChanged()
                java.util.ArrayList<com.shix.shixipc.bean.CameraParamsBean> r0 = com.shix.shixipc.system.SystemValue.arrayList
                int r0 = r0.size()
                if (r0 != 0) goto L_0x007f
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                android.widget.LinearLayout r0 = r0.layoutAdd
                r0.setVisibility(r8)
                goto L_0x0318
            L_0x007f:
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                android.widget.LinearLayout r0 = r0.layoutAdd
                r0.setVisibility(r8)
                goto L_0x0318
            L_0x008a:
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                com.shix.shixipc.adapter.CameraListAdapter r0 = r0.listAdapter
                r0.notifyDataSetChanged()
                goto L_0x0318
            L_0x0093:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "PPPP_MSG_TYPE_AND_MODE did:"
                r2.append(r3)
                com.shix.shixipc.activity.FragmentCameraList r3 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r3 = r3.did
                r2.append(r3)
                java.lang.String r3 = "  devMode:"
                r2.append(r3)
                r2.append(r0)
                java.lang.String r3 = "   devType:"
                r2.append(r3)
                r2.append(r7)
                java.lang.String r2 = r2.toString()
                com.shix.shixipc.utils.CommonUtil.Log(r10, r2)
                com.shix.shixipc.activity.FragmentCameraList r2 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r2 = r2.did
                if (r2 == 0) goto L_0x0318
                if (r0 == 0) goto L_0x0318
                if (r7 == 0) goto L_0x0318
                com.shix.shixipc.activity.FragmentCameraList r2 = com.shix.shixipc.activity.FragmentCameraList.this
                com.shix.shixipc.adapter.CameraListAdapter r2 = r2.listAdapter
                com.shix.shixipc.activity.FragmentCameraList r3 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r3 = r3.did
                r2.UpdataCameraResetrict(r3, r5, r0, r7)
                goto L_0x0318
            L_0x00d8:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "shix:"
                r0.append(r2)
                r0.append(r5)
                java.lang.String r0 = r0.toString()
                java.lang.String r2 = "shix"
                android.util.Log.d(r2, r0)
                goto L_0x0318
            L_0x00f0:
                android.content.Intent r0 = new android.content.Intent
                java.lang.String r6 = "camera_status_change"
                r0.<init>(r6)
                com.shix.shixipc.activity.FragmentCameraList r6 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r6 = r6.did
                java.lang.String r7 = "cameraid"
                r0.putExtra(r7, r6)
                java.lang.String r6 = "pppp_status"
                r0.putExtra(r6, r5)
                com.shix.shixipc.activity.FragmentCameraList r6 = com.shix.shixipc.activity.FragmentCameraList.this
                androidx.fragment.app.FragmentActivity r6 = r6.getActivity()
                r6.sendBroadcast(r0)
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                com.shix.shixipc.adapter.CameraListAdapter r0 = r0.listAdapter
                com.shix.shixipc.activity.FragmentCameraList r6 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r6 = r6.did
                boolean r0 = r0.UpdataCameraStatus(r6, r5)
                if (r0 == 0) goto L_0x0318
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                com.shix.shixipc.adapter.CameraListAdapter r0 = r0.listAdapter
                r0.notifyDataSetChanged()
                r6 = 2
                if (r5 != r6) goto L_0x02eb
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r11 = r0.did
                com.shix.shixipc.bean.CameraParamsBean r11 = r0.getCameraBean(r11)
                if (r11 != 0) goto L_0x0137
                return
            L_0x0137:
                java.lang.String r0 = r11.getDev_User()
                com.shix.shixipc.system.SystemValue.doorBellAdmin = r0
                java.lang.String r0 = r11.getDev_Pwd()
                com.shix.shixipc.system.SystemValue.doorBellPass = r0
                r12 = 1000(0x3e8, double:4.94E-321)
                r14 = 0
                java.util.TimeZone r0 = java.util.TimeZone.getDefault()     // Catch:{ JSONException -> 0x01be }
                int r0 = r0.getRawOffset()     // Catch:{ JSONException -> 0x01be }
                int r0 = -r0
                int r0 = r0 / 1000
                java.util.Calendar r15 = java.util.Calendar.getInstance()     // Catch:{ JSONException -> 0x01be }
                long r15 = r15.getTimeInMillis()     // Catch:{ JSONException -> 0x01be }
                r26 = r7
                long r6 = r15 / r12
                int r7 = (int) r6     // Catch:{ JSONException -> 0x01bc }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01bc }
                r6.<init>()     // Catch:{ JSONException -> 0x01bc }
                r6.append(r3)     // Catch:{ JSONException -> 0x01bc }
                r6.append(r0)     // Catch:{ JSONException -> 0x01bc }
                java.lang.String r6 = r6.toString()     // Catch:{ JSONException -> 0x01bc }
                android.util.Log.d(r4, r6)     // Catch:{ JSONException -> 0x01bc }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01bc }
                r6.<init>()     // Catch:{ JSONException -> 0x01bc }
                r6.append(r3)     // Catch:{ JSONException -> 0x01bc }
                r6.append(r7)     // Catch:{ JSONException -> 0x01bc }
                r6.append(r2)     // Catch:{ JSONException -> 0x01bc }
                java.lang.String r6 = r6.toString()     // Catch:{ JSONException -> 0x01bc }
                android.util.Log.d(r4, r6)     // Catch:{ JSONException -> 0x01bc }
                org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01bc }
                r6.<init>()     // Catch:{ JSONException -> 0x01bc }
                java.lang.String r15 = "pro"
                java.lang.String r8 = "set_datetime"
                r6.put(r15, r8)     // Catch:{ JSONException -> 0x01bc }
                java.lang.String r8 = "cmd"
                r15 = 126(0x7e, float:1.77E-43)
                r6.put(r8, r15)     // Catch:{ JSONException -> 0x01bc }
                java.lang.String r8 = "user"
                java.lang.String r15 = com.shix.shixipc.system.SystemValue.doorBellAdmin     // Catch:{ JSONException -> 0x01bc }
                r6.put(r8, r15)     // Catch:{ JSONException -> 0x01bc }
                java.lang.String r8 = "pwd"
                java.lang.String r15 = com.shix.shixipc.system.SystemValue.doorBellPass     // Catch:{ JSONException -> 0x01bc }
                r6.put(r8, r15)     // Catch:{ JSONException -> 0x01bc }
                java.lang.String r8 = "time"
                r6.put(r8, r7)     // Catch:{ JSONException -> 0x01bc }
                java.lang.String r7 = "tz"
                r6.put(r7, r0)     // Catch:{ JSONException -> 0x01bc }
                java.lang.String r0 = r11.getDev_Did()     // Catch:{ JSONException -> 0x01bc }
                java.lang.String r6 = r6.toString()     // Catch:{ JSONException -> 0x01bc }
                object.p2pipcam.nativecaller.NativeCaller.TransferMessage(r0, r6, r14)     // Catch:{ JSONException -> 0x01bc }
                goto L_0x01c4
            L_0x01bc:
                r0 = move-exception
                goto L_0x01c1
            L_0x01be:
                r0 = move-exception
                r26 = r7
            L_0x01c1:
                r0.printStackTrace()
            L_0x01c4:
                java.util.TimeZone r0 = java.util.TimeZone.getDefault()
                int r0 = r0.getRawOffset()
                int r0 = r0 / 1000
                java.util.Calendar r6 = java.util.Calendar.getInstance()
                long r6 = r6.getTimeInMillis()
                long r6 = r6 / r12
                int r7 = (int) r6
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                r6.append(r3)
                r6.append(r0)
                java.lang.String r0 = r6.toString()
                android.util.Log.d(r4, r0)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r3)
                r0.append(r7)
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                android.util.Log.d(r4, r0)
                java.lang.String r0 = r11.getDev_Did()
                java.lang.String r17 = r11.getDev_User()
                java.lang.String r18 = r11.getDev_Pwd()
                java.lang.String r19 = com.shix.shixipc.system.ContentCommon.XG_TOKEN
                com.shix.shixipc.activity.FragmentCameraList r3 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r20 = r3.strUUID
                java.lang.String r22 = com.shix.shixipc.system.ContentCommon.FCM_TOKEN
                java.lang.String r24 = r11.getDev_name()
                java.lang.String r23 = " "
                r21 = r7
                java.lang.String r3 = com.shix.shixipc.utils.CommonUtil.SHIX_RegistPush(r17, r18, r19, r20, r21, r22, r23, r24)
                object.p2pipcam.nativecaller.NativeCaller.TransferMessage(r0, r3, r14)
                java.lang.String r0 = com.shix.shixipc.system.ContentCommon.AP_ADD_UID
                if (r0 == 0) goto L_0x02eb
                java.lang.String r0 = com.shix.shixipc.system.ContentCommon.AP_ADD_UID
                com.shix.shixipc.activity.FragmentCameraList r3 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r3 = r3.did
                boolean r0 = r0.equalsIgnoreCase(r3)
                if (r0 == 0) goto L_0x02eb
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r3 = r11.getDev_Did()
                int r4 = r11.getResetrict()
                boolean r0 = r0.checkChina1(r3, r4)
                if (r0 == 0) goto L_0x0247
                return
            L_0x0247:
                int r0 = com.shix.shixipc.system.ContentCommon.AP_ADD_OR_CON
                if (r0 != r10) goto L_0x025e
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r3 = r11.getDev_Did()
                com.shix.shixipc.view.Effectstype r4 = com.shix.shixipc.view.Effectstype.Slidetop
                java.lang.String r6 = r11.getDev_name()
                r0.showConfigWifiDialog(r3, r4, r6)
                com.shix.shixipc.system.ContentCommon.AP_ADD_UID = r2
                goto L_0x02eb
            L_0x025e:
                java.lang.String r0 = r11.getDev_Did()
                java.lang.String r3 = r11.getDev_name()
                java.lang.String r4 = r11.getDev_User()
                java.lang.String r6 = r11.getDev_Pwd()
                java.lang.String r7 = r11.getDev_User()
                com.shix.shixipc.system.SystemValue.doorBellAdmin = r7
                java.lang.String r7 = r11.getDev_Pwd()
                com.shix.shixipc.system.SystemValue.doorBellPass = r7
                java.lang.String r7 = r11.getDev_User()
                java.lang.String r8 = r11.getDev_Pwd()
                java.lang.String r7 = com.shix.shixipc.utils.CommonUtil.SHIX_Heat(r7, r8)
                object.p2pipcam.nativecaller.NativeCaller.TransferMessage(r0, r7, r14)
                android.content.Intent r7 = new android.content.Intent
                com.shix.shixipc.activity.FragmentCameraList r8 = com.shix.shixipc.activity.FragmentCameraList.this
                androidx.fragment.app.FragmentActivity r8 = r8.getActivity()
                java.lang.Class<com.shix.shixipc.activity.NDNCameraMjLiveActivity> r12 = com.shix.shixipc.activity.NDNCameraMjLiveActivity.class
                r7.<init>(r8, r12)
                java.lang.String r8 = "camera_type"
                r7.putExtra(r8, r10)
                java.lang.String r8 = "stream_type"
                r7.putExtra(r8, r9)
                java.lang.String r8 = "camera_name"
                r7.putExtra(r8, r3)
                r3 = r26
                r7.putExtra(r3, r0)
                java.lang.String r0 = "camera_user"
                r7.putExtra(r0, r4)
                java.lang.String r0 = "camera_pwd"
                r7.putExtra(r0, r6)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r3 = "ContentCommon.STR_CAMERA_DEVTYPE:"
                r0.append(r3)
                int r3 = r11.getDevType()
                r0.append(r3)
                java.lang.String r0 = r0.toString()
                com.shix.shixipc.utils.CommonUtil.Log(r10, r0)
                int r0 = r11.getDevType()
                java.lang.String r3 = "camera_devtype"
                r7.putExtra(r3, r0)
                int r0 = r11.getDevMode()
                java.lang.String r3 = "camera_devmode"
                r7.putExtra(r3, r0)
                java.lang.String r0 = "modep"
                r7.putExtra(r0, r10)
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                r3 = 2
                r0.startActivityForResult(r7, r3)
                com.shix.shixipc.system.ContentCommon.AP_ADD_UID = r2
            L_0x02eb:
                r0 = 5
                if (r5 == r0) goto L_0x02fd
                if (r5 == r9) goto L_0x02fd
                r0 = 6
                if (r5 == r0) goto L_0x02fd
                r0 = 7
                if (r5 == r0) goto L_0x02fd
                r2 = 8
                if (r5 == r2) goto L_0x02fd
                r0 = 4
                if (r5 != r0) goto L_0x0318
            L_0x02fd:
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r0 = r0.did
                object.p2pipcam.nativecaller.NativeCaller.StopPlayBack(r0)
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r0 = r0.did
                object.p2pipcam.nativecaller.NativeCaller.StopPPPPLivestream(r0)
                com.shix.shixipc.activity.FragmentCameraList r0 = com.shix.shixipc.activity.FragmentCameraList.this
                java.lang.String r2 = r0.did
                r0.StopPPPP(r2)
            L_0x0318:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.FragmentCameraList.C11749.handleMessage(android.os.Message):void");
        }
    };
    private final int SNAPSHOT = 200;
    private Button btnEdit;
    private Button buttonAdd;
    private ListView cameraListView = null;
    /* access modifiers changed from: private */
    public int connectCount = 0;
    /* access modifiers changed from: private */
    public String did;
    private int gltag;
    private ImageButton imbtn_add;
    private ImageButton imbtn_four;
    private ImageButton imbtn_ser;
    private ImageButton imbtn_view;
    private boolean isAPMode = false;
    /* access modifiers changed from: private */
    public boolean isCheckConnect = false;
    private boolean isEdited = false;
    /* access modifiers changed from: private */
    public Boolean isRunCheck = false;
    /* access modifiers changed from: private */
    public LinearLayout layoutAdd;
    public CameraListAdapter listAdapter = null;
    private WifiManager mWifiManager;
    private SharedPreferences preuser;
    private ProgressDialog progressDialog;
    private CameraInfoReceiver receiver = null;
    /* access modifiers changed from: private */
    public String strUUID;

    public interface NewUiMainInterface {
        void CallBackStyle(int i);
    }

    private void initCameraList() {
    }

    static /* synthetic */ int access$208(FragmentCameraList fragmentCameraList) {
        int i = fragmentCameraList.connectCount;
        fragmentCameraList.connectCount = i + 1;
        return i;
    }

    private String getWifiSSID() {
        this.mWifiManager = (WifiManager) getActivity().getApplicationContext().getSystemService("wifi");
        if (!this.mWifiManager.isWifiEnabled()) {
            return "null ssid";
        }
        WifiInfo connectionInfo = this.mWifiManager.getConnectionInfo();
        String ssid = connectionInfo.getSSID();
        if (ssid.indexOf(ContentCommon.SHIX_APPRE) < 0 || ssid.indexOf("IKB") < 0) {
            int networkId = connectionInfo.getNetworkId();
            Iterator<WifiConfiguration> it = this.mWifiManager.getConfiguredNetworks().iterator();
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
        }
        if (ssid == null) {
            return "null ssid";
        }
        return (!ssid.startsWith("\"") || !ssid.endsWith("\"")) ? ssid : ssid.substring(1, ssid.length() - 1);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
                    CommonUtil.Log(1, "BSCallBack_TYPEMODE:" + str2);
                    Bundle bundle = new Bundle();
                    Message obtainMessage = FragmentCameraList.this.PPPPMsgHandler.obtainMessage();
                    obtainMessage.what = 3;
                    bundle.putInt(FragmentCameraList.STR_MSG_PARAM, i);
                    bundle.putString(FragmentCameraList.STR_DID, str);
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
        new Thread(new StartPPPPThread()).start();
        this.isCheckConnect = true;
        int i = this.gltag;
        NewUiMainInterface newUiMainInterface2 = newUiMainInterface;
        if (newUiMainInterface2 != null) {
            newUiMainInterface2.CallBackStyle(i);
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

    class CheckConnectThread extends Thread {
        CheckConnectThread() {
        }

        public void run() {
            while (FragmentCameraList.this.isCheckConnect) {
                int i = 0;
                while (i < 15) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception unused) {
                    }
                    if (FragmentCameraList.this.isCheckConnect) {
                        i++;
                    } else {
                        return;
                    }
                }
                int count = FragmentCameraList.this.listAdapter.getCount();
                int i2 = 0;
                while (true) {
                    if (i2 >= count) {
                        break;
                    }
                    CameraParamsBean onItem = FragmentCameraList.this.listAdapter.getOnItem(i2);
                    if (FragmentCameraList.this.isCheckConnect) {
                        try {
                            Thread.sleep(100);
                        } catch (Exception unused2) {
                        }
                        if (FragmentCameraList.this.isCheckConnect) {
                            if (onItem.getDev_p2pstatus() == 6 && !onItem.isCheckint()) {
                                if (FragmentCameraList.this.connectCount == 2) {
                                    int unused3 = FragmentCameraList.this.connectCount = 0;
                                    break;
                                }
                                FragmentCameraList.access$208(FragmentCameraList.this);
                                FragmentCameraList.this.listAdapter.getOnItem(i2).setCheckint(true);
                                NativeCaller.StopPPPP(onItem.getDev_Did());
                                try {
                                    Thread.sleep(300);
                                } catch (Exception unused4) {
                                }
                                FragmentCameraList.this.StartPPPP(onItem.getDev_Did(), onItem.getDev_User(), onItem.getDev_Pwd());
                            }
                            i2++;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            super.run();
        }
    }

    public void onResume() {
        String wifiSSID = getWifiSSID();
        CommonUtil.Log(1, "SHIXAP1 wifissid:" + wifiSSID);
        if (wifiSSID.indexOf(ContentCommon.SHIX_APPRE) >= 0) {
            String replace = wifiSSID.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            this.isAPMode = true;
            addCamera(replace);
        } else {
            this.isAPMode = false;
        }
        if (SystemValue.arrayList.size() == 0) {
            this.layoutAdd.setVisibility(8);
        } else {
            this.layoutAdd.setVisibility(8);
        }
        this.listAdapter.notifyDataSetChanged();
        super.onResume();
    }

    private void addCamera(String str) {
        Iterator<CameraParamsBean> it = SystemValue.arrayList.iterator();
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(it.next().getDev_Did())) {
                showToast(getString(R.string.tip_device_add));
                return;
            }
        }
        ContentCommon.AP_ADD_UID = str;
        CameraParamsBean cameraParamsBean = new CameraParamsBean();
        cameraParamsBean.setDev_Did(str);
        cameraParamsBean.setDev_name(ContentCommon.SHIX_DEFUALT_NAME);
        cameraParamsBean.setDev_User("admin");
        cameraParamsBean.setDev_Pwd(ContentCommon.SHIX_DEFUALT_PWD);
        SystemValue.arrayList.add(cameraParamsBean);
        ContentCommon.SHIX_saveDev(cameraParamsBean);
        Intent intent = new Intent();
        intent.setAction(ContentCommon.STR_CAMERA_INFO_RECEIVER);
        intent.putExtra(ContentCommon.CAMERA_OPTION, 5);
        intent.putExtra(ContentCommon.STR_CAMERA_ID, str);
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
                    FragmentCameraList.this.layoutAdd.setVisibility(8);
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
            ContentCommon.SHIX_getDevs();
            try {
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
            StartPPPP(onItem.getDev_Did(), onItem.getDev_User(), onItem.getDev_Pwd());
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
                case R.id.imbtn_add /*2131165519*/:
                    startActivity(new Intent(getActivity(), AddShowActivity.class));
                    return;
                case R.id.imbtn_four /*2131165520*/:
                    startActivity(new Intent(getActivity(), IpcamClientActivityFourTest.class));
                    return;
                case R.id.imbtn_ser /*2131165521*/:
                    Intent intent = new Intent(getActivity(), SertchActivity.class);
                    intent.putExtra("sType", 110);
                    startActivity(intent);
                    return;
                case R.id.imbtn_view /*2131165522*/:
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
                    CameraParamsBean access$300 = FragmentCameraList.this.getCameraBean(stringExtra2);
                    if (access$300 != null) {
                        CommonUtil.Log(1, "zhaogenghuai1:" + access$300.getDev_Did());
                        FragmentCameraList.this.StopPPPP(stringExtra2);
                        FragmentCameraList.this.StartPPPP(access$300.getDev_Did(), access$300.getDev_User(), access$300.getDev_Pwd());
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
                                intent.putExtra(SharedPreferencesUtils.USER_NAME, stringExtra);
                                FragmentCameraList.this.getActivity().sendBroadcast(intent);
                            }
                        }.start();
                        if (SystemValue.arrayList.size() == 0) {
                            FragmentCameraList.this.layoutAdd.setVisibility(8);
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
        Intent intent;
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(getActivity(), 10);
        }
        CameraParamsBean itemCamera = this.listAdapter.getItemCamera(i);
        if (itemCamera != null) {
            if (itemCamera.getDev_p2pstatus() != 2 || !checkChina(itemCamera.getDev_Did(), itemCamera.getResetrict())) {
                SystemValue.position = i;
                SystemValue.doorBellAdmin = itemCamera.getDev_User();
                SystemValue.doorBellPass = itemCamera.getDev_Pwd();
                Intent intent2 = new Intent();
                switch (i2) {
                    case R.id.imgBtnPPPPSetting /*2131165524*/:
                        CommonUtil.Log(1, "zhaogenghuai 5");
                        intent2.setClass(getActivity(), SettingActivity.class);
                        break;
                    case R.id.llAlarm /*2131165599*/:
                        CommonUtil.Log(1, "zhaogenghuai 4");
                        intent2.setClass(getActivity(), SettingActivity.class);
                        break;
                    case R.id.llCZ /*2131165600*/:
                        CommonUtil.Log(1, "zhaogenghuai 4");
                        intent2.setClass(getActivity(), CZActivity.class);
                        intent2.putExtra(STR_DID, itemCamera.getDev_Did());
                        break;
                    case R.id.llPic /*2131165604*/:
                        CommonUtil.Log(1, "zhaogenghuai 3");
                        SystemValue.doorBellAdmin = itemCamera.getDev_User();
                        SystemValue.doorBellPass = itemCamera.getDev_Pwd();
                        if (CommonUtil.SHIX_is100WDev(itemCamera.getDev_Did()).booleanValue()) {
                            intent = new Intent(getActivity(), PlayBackActivity.class);
                        } else {
                            intent = new Intent(getActivity(), TfFilesActivity.class);
                        }
                        intent.putExtra(ContentCommon.STR_CAMERA_NAME, itemCamera.getDev_name());
                        intent.putExtra(ContentCommon.STR_CAMERA_ID, itemCamera.getDev_Did());
                        intent.putExtra(ContentCommon.STR_CAMERA_PWD, itemCamera.getDev_Pwd());
                        intent.putExtra(ContentCommon.STR_CAMERA_USER, itemCamera.getDev_User());
                        startActivity(intent);
                        return;
                    case R.id.llSetting /*2131165610*/:
                        CommonUtil.Log(1, "zhaogenghuai 2");
                        if (itemCamera != null && itemCamera.getDev_p2pstatus() == 2) {
                            CommonUtil.SHIX_Delpush(itemCamera.getDev_User(), itemCamera.getDev_Pwd(), this.strUUID);
                        }
                        showDeleteCameraDialog(itemCamera.getDev_Did(), Effectstype.Slidetop, itemCamera.getDev_name());
                        return;
                    case R.id.llVideo /*2131165611*/:
                        CommonUtil.Log(1, "zhaogenghuai 1");
                        intent2.setClass(getActivity(), ClouDateActivity.class);
                        break;
                }
                intent2.putExtra(ContentCommon.STR_CAMERA_ID, itemCamera.getDev_Did());
                intent2.putExtra(ContentCommon.STR_CAMERA_NAME, itemCamera.getDev_name());
                startActivity(intent2);
            }
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

    private void showLowPwdDialog(final String str, Effectstype effectstype, String str2) {
        final NiftyDialogBuilder instance = NiftyDialogBuilder.getInstance(getActivity());
        instance.withTitle(str2).withMessage((CharSequence) getString(R.string.pwd_edit_show1)).withEffect(effectstype).setButton1Click(new View.OnClickListener() {
            public void onClick(View view) {
                CameraParamsBean access$300 = FragmentCameraList.this.getCameraBean(str);
                String dev_Did = access$300.getDev_Did();
                String dev_name = access$300.getDev_name();
                String dev_User = access$300.getDev_User();
                String dev_Pwd = access$300.getDev_Pwd();
                SystemValue.doorBellAdmin = access$300.getDev_User();
                SystemValue.doorBellPass = access$300.getDev_Pwd();
                NativeCaller.TransferMessage(dev_Did, CommonUtil.SHIX_Heat(access$300.getDev_User(), access$300.getDev_Pwd()), 0);
                Intent intent = new Intent(FragmentCameraList.this.getActivity(), NDNCameraMjLiveActivity.class);
                intent.putExtra(ContentCommon.STR_CAMERA_TYPE, 1);
                intent.putExtra(ContentCommon.STR_STREAM_TYPE, 3);
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, dev_name);
                intent.putExtra(ContentCommon.STR_CAMERA_ID, dev_Did);
                intent.putExtra(ContentCommon.STR_CAMERA_USER, dev_User);
                intent.putExtra(ContentCommon.STR_CAMERA_PWD, dev_Pwd);
                CommonUtil.Log(1, "ContentCommon.STR_CAMERA_DEVTYPE:" + access$300.getDevType());
                intent.putExtra(ContentCommon.STR_CAMERA_DEVTYPE, access$300.getDevType());
                intent.putExtra(ContentCommon.STR_CAMERA_DEVMODE, access$300.getDevMode());
                intent.putExtra("modep", 1);
                FragmentCameraList.this.startActivityForResult(intent, 2);
                instance.dismiss();
            }
        }).setButton2Click(new View.OnClickListener() {
            public void onClick(View view) {
                CameraParamsBean access$300 = FragmentCameraList.this.getCameraBean(str);
                String dev_Did = access$300.getDev_Did();
                String dev_name = access$300.getDev_name();
                Intent intent = new Intent(FragmentCameraList.this.getActivity(), PasswordSettingActivity.class);
                intent.putExtra(ContentCommon.STR_CAMERA_ID, dev_Did);
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, dev_name);
                FragmentCameraList.this.startActivity(intent);
                instance.dismiss();
            }
        }).show();
    }

    /* access modifiers changed from: private */
    public void showConfigWifiDialog(final String str, Effectstype effectstype, String str2) {
        final NiftyDialogBuilder instance = NiftyDialogBuilder.getInstance(getActivity());
        instance.withTitle(str2).withMessage((CharSequence) getString(R.string.ap_add_title2)).withEffect(effectstype).setButton1Click(new View.OnClickListener() {
            public void onClick(View view) {
                instance.dismiss();
            }
        }).setButton2Click(new View.OnClickListener() {
            public void onClick(View view) {
                CameraParamsBean access$300 = FragmentCameraList.this.getCameraBean(str);
                access$300.getDev_Did();
                access$300.getDev_name();
                Intent intent = new Intent(FragmentCameraList.this.getActivity(), SettingWifiActivity.class);
                intent.putExtra(ContentCommon.STR_CAMERA_ID, access$300.getDev_Did());
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, access$300.getDev_name());
                FragmentCameraList.this.startActivity(intent);
                instance.dismiss();
            }
        }).show();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(getActivity(), 10);
        }
        CameraParamsBean onItem = this.listAdapter.getOnItem(i);
        Log.d(ContentCommon.SERVER_STRING, "00000000");
        if (onItem == null) {
            Log.d(ContentCommon.SERVER_STRING, "111111");
            return;
        }
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
            Intent intent = new Intent(getActivity(), NDNCameraMjLiveActivity.class);
            intent.putExtra(ContentCommon.STR_CAMERA_TYPE, 1);
            intent.putExtra(ContentCommon.STR_STREAM_TYPE, 3);
            intent.putExtra(ContentCommon.STR_CAMERA_NAME, dev_name);
            intent.putExtra(ContentCommon.STR_CAMERA_ID, dev_Did);
            intent.putExtra(ContentCommon.STR_CAMERA_USER, dev_User);
            intent.putExtra(ContentCommon.STR_CAMERA_PWD, dev_Pwd);
            CommonUtil.Log(1, "ContentCommon.STR_CAMERA_DEVTYPE:" + onItem.getDevType());
            intent.putExtra(ContentCommon.STR_CAMERA_DEVTYPE, onItem.getDevType());
            intent.putExtra(ContentCommon.STR_CAMERA_DEVMODE, onItem.getDevMode());
            intent.putExtra("modep", 1);
            startActivityForResult(intent, 2);
        }
    }

    public static void setNewUiMainInterface(NewUiMainInterface newUiMainInterface2) {
        newUiMainInterface = newUiMainInterface2;
    }
}
