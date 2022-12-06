package com.shix.shixipc.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.bean.DateModel;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import object.p2pipcam.nativecaller.NativeCaller;
import org.json.JSONException;

public class SettingDateActivity extends BaseActivity implements View.OnClickListener, View.OnTouchListener, NUIMainActivity.SHIXCOMMONInterface {
    private final int FAIL = 0;
    private final int PARAMS = 3;
    private final int SUCCESS = 1;
    private String TAG = "SettingDateActivity";
    private final int TIMEOUT = PathInterpolatorCompat.MAX_NUM_POINTS;
    private Button btnCancel = null;
    private Button btnCheckOut = null;
    private Button btnOk = null;
    private String cameraName;
    /* access modifiers changed from: private */
    public DateModel dateModel;
    /* access modifiers changed from: private */
    public CheckBox date_cbx_check;
    /* access modifiers changed from: private */
    public Button editNtpServer = null;
    /* access modifiers changed from: private */
    public Button editTimeZone = null;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                SettingDateActivity.this.showToast((int) R.string.date_setting_failed);
            } else if (i == 1) {
                SettingDateActivity.this.showToast((int) R.string.date_setting_success);
                SettingDateActivity.this.finish();
            } else if (i == 3) {
                boolean unused = SettingDateActivity.this.successFlag = true;
                if (SettingDateActivity.this.progressDialog.isShowing()) {
                    SettingDateActivity.this.progressDialog.cancel();
                    if (SettingDateActivity.this.dateModel != null) {
                        SettingDateActivity.this.tvDeviceTime.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(Long.valueOf(((long) SettingDateActivity.this.dateModel.getTime()) * 1000).longValue())));
                        setTimeZone();
                        Button access$400 = SettingDateActivity.this.editNtpServer;
                        access$400.setText(SettingDateActivity.this.dateModel.getNtpServer() + "");
                        if (SettingDateActivity.this.dateModel.getNtpSwitch() == 1) {
                            SettingDateActivity.this.date_cbx_check.setChecked(true);
                        } else {
                            SettingDateActivity.this.date_cbx_check.setChecked(false);
                        }
                        if (SettingDateActivity.this.dateModel.getDstSwitch() == 1) {
                            SettingDateActivity.this.xls_cbx_check.setChecked(true);
                        } else {
                            SettingDateActivity.this.xls_cbx_check.setChecked(false);
                        }
                        if (SettingDateActivity.this.dateModel.getTimeHour() == 1) {
                            SettingDateActivity.this.yees_cbx_check.setChecked(true);
                        } else {
                            SettingDateActivity.this.yees_cbx_check.setChecked(false);
                        }
                    }
                }
            }
        }

        private void setTimeZone() {
            float timeZone = SettingDateActivity.this.dateModel.getTimeZone();
            CommonUtil.Log(1, "SHIXDEV   utcF:" + timeZone);
            int i = (int) timeZone;
            double d = (double) timeZone;
            if (d == 9.5d) {
                SettingDateActivity.this.editTimeZone.setText(R.string.date_darwin);
            } else if (d == -3.5d) {
                SettingDateActivity.this.editTimeZone.setText(R.string.date_newfoundland);
            } else if (d == 4.5d) {
                SettingDateActivity.this.editTimeZone.setText(R.string.date_kebuer);
            } else if (d == 5.5d) {
                SettingDateActivity.this.editTimeZone.setText(R.string.date_calcutta);
            } else if (d == 3.5d) {
                SettingDateActivity.this.editTimeZone.setText(R.string.date_teheran);
            } else {
                CommonUtil.Log(1, "SHIXDEV   utc:" + i);
                switch (i) {
                    case -11:
                        SettingDateActivity.this.editTimeZone.setText(R.string.date_middle_island);
                        return;
                    case -10:
                        SettingDateActivity.this.editTimeZone.setText(R.string.date_hawaii);
                        return;
                    case -9:
                        SettingDateActivity.this.editTimeZone.setText(R.string.date_alaska);
                        return;
                    case -8:
                        SettingDateActivity.this.editTimeZone.setText(R.string.date_pacific_time);
                        return;
                    case -7:
                        SettingDateActivity.this.editTimeZone.setText(R.string.date_mountain_time);
                        return;
                    case -6:
                        SettingDateActivity.this.editTimeZone.setText(R.string.date_middle_part_time);
                        return;
                    case C.RESULT_FORMAT_READ:
                        SettingDateActivity.this.editTimeZone.setText(R.string.date_eastern_time);
                        return;
                    case -4:
                        SettingDateActivity.this.editTimeZone.setText(R.string.date_ocean_time);
                        return;
                    case -3:
                        SettingDateActivity.this.editTimeZone.setText(R.string.date_brasilia);
                        return;
                    case -2:
                        SettingDateActivity.this.editTimeZone.setText(R.string.date_center_ocean);
                        return;
                    case -1:
                        SettingDateActivity.this.editTimeZone.setText(R.string.date_cape_verde_island);
                        return;
                    case 0:
                        SettingDateActivity.this.editTimeZone.setText(R.string.date_greenwich);
                        return;
                    case 1:
                        SettingDateActivity.this.editTimeZone.setText(R.string.date_brussels);
                        return;
                    case 2:
                        SettingDateActivity.this.editTimeZone.setText(R.string.date_athens);
                        return;
                    case 3:
                        SettingDateActivity.this.editTimeZone.setText(R.string.date_nairobi);
                        return;
                    case 4:
                        SettingDateActivity.this.editTimeZone.setText(R.string.date_baku);
                        return;
                    case 5:
                        SettingDateActivity.this.editTimeZone.setText(R.string.date_islamabad);
                        return;
                    case 6:
                        SettingDateActivity.this.editTimeZone.setText(R.string.date_alamotu);
                        return;
                    case 7:
                        SettingDateActivity.this.editTimeZone.setText(R.string.date_bangkok);
                        return;
                    case 8:
                        SettingDateActivity.this.editTimeZone.setText(R.string.date_beijing);
                        return;
                    case 9:
                        SettingDateActivity.this.editTimeZone.setText(R.string.date_seoul);
                        return;
                    case 10:
                        SettingDateActivity.this.editTimeZone.setText(R.string.date_guam);
                        return;
                    case 11:
                        SettingDateActivity.this.editTimeZone.setText(R.string.date_suolumen);
                        return;
                    case 12:
                        SettingDateActivity.this.editTimeZone.setText(R.string.date_auckland);
                        return;
                    default:
                        return;
                }
            }
        }
    };
    private PopupWindow ntpServerPopWindow = null;
    private View ntpView = null;
    /* access modifiers changed from: private */
    public ProgressDialog progressDialog;
    private Runnable runnable = new Runnable() {
        public void run() {
            if (!SettingDateActivity.this.successFlag) {
                SettingDateActivity.this.progressDialog.dismiss();
            }
        }
    };
    private ScrollView scrollView = null;
    private String strDID;
    /* access modifiers changed from: private */
    public boolean successFlag;
    private PopupWindow timeZonePopWindow = null;
    private TextView tvCameraName = null;
    /* access modifiers changed from: private */
    public Button tvDeviceTime = null;
    /* access modifiers changed from: private */
    public CheckBox xls_cbx_check;
    /* access modifiers changed from: private */
    public CheckBox yees_cbx_check;

    /* access modifiers changed from: protected */
    public void onPause() {
        overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getDataFromOther();
        requestWindowFeature(1);
        setContentView(R.layout.settingdate);
        this.progressDialog = new ProgressDialog(this, 3);
        this.progressDialog.setProgressStyle(0);
        this.progressDialog.setMessage(getString(R.string.date_get_params));
        this.progressDialog.show();
        this.mHandler.postDelayed(this.runnable, 3000);
        findView();
        setListener();
        this.dateModel = new DateModel();
        NUIMainActivity.setSHIXCOMMONInterface(this);
        NativeCaller.TransferMessage(this.strDID, CommonUtil.SHIX_GetDateParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
    }

    private void setListener() {
        this.scrollView.setOnTouchListener(this);
        this.editTimeZone.setOnClickListener(this);
        this.editNtpServer.setOnClickListener(this);
        this.btnOk.setOnClickListener(this);
        this.btnCancel.setOnClickListener(this);
        this.btnCheckOut.setOnClickListener(this);
        this.progressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4;
            }
        });
    }

    private void findView() {
        this.btnOk = (Button) findViewById(R.id.date_ok);
        this.btnCancel = (Button) findViewById(R.id.date_cancel);
        this.btnCheckOut = (Button) findViewById(R.id.date_btn_checkout);
        this.tvDeviceTime = (Button) findViewById(R.id.date_tv_device_time);
        this.editTimeZone = (Button) findViewById(R.id.date_edit_timezone);
        this.editNtpServer = (Button) findViewById(R.id.date_edit_ntp_server);
        this.ntpView = findViewById(R.id.date_ntp_view);
        this.scrollView = (ScrollView) findViewById(R.id.scrollView1);
        this.tvCameraName = (TextView) findViewById(R.id.tv_camera_setting);
        this.date_cbx_check = (CheckBox) findViewById(R.id.date_cbx_check);
        this.xls_cbx_check = (CheckBox) findViewById(R.id.xls_cbx_check);
        this.yees_cbx_check = (CheckBox) findViewById(R.id.yees_cbx_check);
        if (CommonUtil.isMJCamera(this.strDID)) {
            findViewById(R.id.ll_hide).setVisibility(8);
        }
    }

    public void onClick(View view) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(this, 10);
        }
        switch (view.getId()) {
            case R.id.date_btn_checkout:
                this.date_cbx_check.setChecked(false);
                checkDeviceAsPhoneTime();
                try {
                    NativeCaller.TransferMessage(this.strDID, DateModel.toJson(this.dateModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                NativeCaller.TransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "clockScreen", 0), 0);
                NativeCaller.TransferMessage(this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "clockScreen", 1), 0);
                finish();
                return;
            case R.id.date_cancel:
                finish();
                overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                return;
            case R.id.date_edit_ntp_server:
                PopupWindow popupWindow = this.timeZonePopWindow;
                if (popupWindow != null && popupWindow.isShowing()) {
                    this.timeZonePopWindow.dismiss();
                    this.timeZonePopWindow = null;
                }
                showNtpServerPopWindow();
                return;
            case R.id.date_edit_timezone:
                PopupWindow popupWindow2 = this.ntpServerPopWindow;
                if (popupWindow2 != null && popupWindow2.isShowing()) {
                    this.ntpServerPopWindow.dismiss();
                    this.ntpServerPopWindow = null;
                }
                showTimeZonePopWindow();
                return;
            case R.id.date_ntpserver_kriss:
                this.ntpServerPopWindow.dismiss();
                this.editNtpServer.setText(R.string.date_ntp_server_time_kriss_re_kr);
                this.dateModel.setNtpServer(getResources().getText(R.string.date_ntp_server_time_kriss_re_kr).toString());
                return;
            case R.id.date_ntpserver_nist:
                this.ntpServerPopWindow.dismiss();
                this.editNtpServer.setText(R.string.date_ntp_server_time_nist_gov);
                this.dateModel.setNtpServer(getResources().getText(R.string.date_ntp_server_time_nist_gov).toString());
                return;
            case R.id.date_ntpserver_nuri:
                this.ntpServerPopWindow.dismiss();
                this.editNtpServer.setText(R.string.date_ntp_server_time_nuri_net);
                this.dateModel.setNtpServer(getResources().getText(R.string.date_ntp_server_time_nuri_net).toString());
                return;
            case R.id.date_ntpserver_windows:
                this.ntpServerPopWindow.dismiss();
                this.editNtpServer.setText(R.string.date_ntp_server_time_windows_com);
                this.dateModel.setNtpServer(getResources().getText(R.string.date_ntp_server_time_windows_com).toString());
                return;
            case R.id.date_ok:
                setDate();
                return;
            case R.id.date_zone_alamotu:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(6.0f);
                this.editTimeZone.setText(R.string.date_alamotu);
                return;
            case R.id.date_zone_alaska:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(-9.0f);
                this.editTimeZone.setText(R.string.date_alaska);
                return;
            case R.id.date_zone_athens:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(2.0f);
                this.editTimeZone.setText(R.string.date_athens);
                return;
            case R.id.date_zone_auckland:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(12.0f);
                this.editTimeZone.setText(R.string.date_auckland);
                return;
            case R.id.date_zone_baku:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(4.0f);
                this.editTimeZone.setText(R.string.date_baku);
                return;
            case R.id.date_zone_bangkok:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(7.0f);
                this.editTimeZone.setText(R.string.date_bangkok);
                return;
            case R.id.date_zone_beijing:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(8.0f);
                this.editTimeZone.setText(R.string.date_beijing);
                return;
            case R.id.date_zone_brasilia:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(-3.0f);
                this.editTimeZone.setText(R.string.date_brasilia);
                return;
            case R.id.date_zone_brussels:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(1.0f);
                this.editTimeZone.setText(R.string.date_brussels);
                return;
            case R.id.date_zone_calcutta:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(5.5f);
                this.editTimeZone.setText(R.string.date_calcutta);
                return;
            case R.id.date_zone_cap_verde_island:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(-1.0f);
                this.editTimeZone.setText(R.string.date_cape_verde_island);
                return;
            case R.id.date_zone_center_ocean:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(-2.0f);
                this.editTimeZone.setText(R.string.date_center_ocean);
                return;
            case R.id.date_zone_darwin:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(9.5f);
                this.editTimeZone.setText(R.string.date_darwin);
                return;
            case R.id.date_zone_eastern_time:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(-5.0f);
                this.editTimeZone.setText(R.string.date_eastern_time);
                return;
            case R.id.date_zone_greenwich:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(0.0f);
                this.editTimeZone.setText(R.string.date_greenwich);
                return;
            case R.id.date_zone_guam:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(10.0f);
                this.editTimeZone.setText(R.string.date_guam);
                return;
            case R.id.date_zone_hawaii:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(-10.0f);
                this.editTimeZone.setText(R.string.date_hawaii);
                return;
            case R.id.date_zone_islamabad:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(5.0f);
                this.editTimeZone.setText(R.string.date_islamabad);
                return;
            case R.id.date_zone_kebuer:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(4.5f);
                this.editTimeZone.setText(R.string.date_kebuer);
                return;
            case R.id.date_zone_middle_island:
                this.timeZonePopWindow.dismiss();
                this.editTimeZone.setText(R.string.date_middle_island);
                this.dateModel.setTimeZone(-11.0f);
                return;
            case R.id.date_zone_middle_part_time:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(-6.0f);
                this.editTimeZone.setText(R.string.date_middle_part_time);
                return;
            case R.id.date_zone_mountain_time:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(-7.0f);
                this.editTimeZone.setText(R.string.date_mountain_time);
                return;
            case R.id.date_zone_nairobi:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(3.0f);
                this.editTimeZone.setText(R.string.date_nairobi);
                return;
            case R.id.date_zone_newfoundland:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(-3.5f);
                this.editTimeZone.setText(R.string.date_newfoundland);
                return;
            case R.id.date_zone_ocean_time:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(-4.0f);
                this.editTimeZone.setText(R.string.date_ocean_time);
                return;
            case R.id.date_zone_pacific_time:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(-8.0f);
                this.editTimeZone.setText(R.string.date_pacific_time);
                return;
            case R.id.date_zone_seoul:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(9.0f);
                this.editTimeZone.setText(R.string.date_seoul);
                return;
            case R.id.date_zone_soulumen:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(11.0f);
                this.editTimeZone.setText(R.string.date_suolumen);
                return;
            case R.id.date_zone_teheran:
                this.timeZonePopWindow.dismiss();
                this.dateModel.setTimeZone(3.5f);
                this.editTimeZone.setText(R.string.date_teheran);
                return;
            default:
                return;
        }
    }

    private void setDate() {
        if (this.dateModel != null) {
            checkDeviceAsPhoneTime();
            try {
                NativeCaller.TransferMessage(this.strDID, DateModel.toJson(this.dateModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            finish();
        }
    }

    private void checkDeviceAsPhoneTime() {
        if (this.date_cbx_check.isChecked()) {
            this.dateModel.setNtpSwitch(1);
        } else {
            this.dateModel.setNtpSwitch(0);
        }
        if (this.xls_cbx_check.isChecked()) {
            this.dateModel.setDstSwitch(1);
        } else {
            this.dateModel.setDstSwitch(0);
        }
        if (this.yees_cbx_check.isChecked()) {
            this.dateModel.setTimeHour(1);
        } else {
            this.dateModel.setTimeHour(0);
        }
        int timeInMillis = (int) (Calendar.getInstance().getTimeInMillis() / 1000);
        Log.d("tag", "tz:" + ((-TimeZone.getDefault().getRawOffset()) / 1000));
        Log.d("tag", "tz:" + timeInMillis + "");
        this.dateModel.setTime(timeInMillis);
    }

    private void showNtpServerPopWindow() {
        PopupWindow popupWindow = this.ntpServerPopWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.settingdate_ntpserver_popwindow, (ViewGroup) null);
            ((Button) linearLayout.findViewById(R.id.date_ntpserver_kriss)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_ntpserver_nist)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_ntpserver_nuri)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_ntpserver_windows)).setOnClickListener(this);
            this.ntpServerPopWindow = new PopupWindow(linearLayout, 350, -2);
            this.ntpServerPopWindow.showAsDropDown(this.editNtpServer, -350, 0);
        }
    }

    private void showTimeZonePopWindow() {
        PopupWindow popupWindow = this.timeZonePopWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.settingdate_timezone_popwindow, (ViewGroup) null);
            Button button = (Button) linearLayout.findViewById(R.id.date_zone_brussels);
            Button button2 = (Button) linearLayout.findViewById(R.id.date_zone_athens);
            Button button3 = (Button) linearLayout.findViewById(R.id.date_zone_nairobi);
            Button button4 = (Button) linearLayout.findViewById(R.id.date_zone_teheran);
            Button button5 = (Button) linearLayout.findViewById(R.id.date_zone_baku);
            Button button6 = (Button) linearLayout.findViewById(R.id.date_zone_kebuer);
            Button button7 = (Button) linearLayout.findViewById(R.id.date_zone_islamabad);
            Button button8 = (Button) linearLayout.findViewById(R.id.date_zone_calcutta);
            Button button9 = (Button) linearLayout.findViewById(R.id.date_zone_alamotu);
            Button button10 = (Button) linearLayout.findViewById(R.id.date_zone_bangkok);
            Button button11 = (Button) linearLayout.findViewById(R.id.date_zone_beijing);
            Button button12 = (Button) linearLayout.findViewById(R.id.date_zone_seoul);
            Button button13 = (Button) linearLayout.findViewById(R.id.date_zone_darwin);
            Button button14 = (Button) linearLayout.findViewById(R.id.date_zone_guam);
            Button button15 = (Button) linearLayout.findViewById(R.id.date_zone_soulumen);
            ((Button) linearLayout.findViewById(R.id.date_zone_middle_island)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_zone_hawaii)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_zone_alaska)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_zone_pacific_time)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_zone_mountain_time)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_zone_middle_part_time)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_zone_eastern_time)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_zone_ocean_time)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_zone_newfoundland)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_zone_brasilia)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_zone_center_ocean)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_zone_cap_verde_island)).setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_zone_greenwich)).setOnClickListener(this);
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button3.setOnClickListener(this);
            button4.setOnClickListener(this);
            button5.setOnClickListener(this);
            button6.setOnClickListener(this);
            button7.setOnClickListener(this);
            button8.setOnClickListener(this);
            button9.setOnClickListener(this);
            button10.setOnClickListener(this);
            button11.setOnClickListener(this);
            button12.setOnClickListener(this);
            button13.setOnClickListener(this);
            button14.setOnClickListener(this);
            button15.setOnClickListener(this);
            ((Button) linearLayout.findViewById(R.id.date_zone_auckland)).setOnClickListener(this);
            this.timeZonePopWindow = new PopupWindow(linearLayout, -1, 700);
            PopupWindow popupWindow2 = this.timeZonePopWindow;
            popupWindow2.showAsDropDown(this.editTimeZone, -popupWindow2.getWidth(), 0);
        }
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.cameraName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        PopupWindow popupWindow = this.timeZonePopWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.timeZonePopWindow.dismiss();
            this.timeZonePopWindow = null;
        }
        PopupWindow popupWindow2 = this.ntpServerPopWindow;
        if (popupWindow2 != null && popupWindow2.isShowing()) {
            this.ntpServerPopWindow.dismiss();
            this.ntpServerPopWindow = null;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        PopupWindow popupWindow = this.timeZonePopWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.timeZonePopWindow.dismiss();
            this.timeZonePopWindow = null;
        }
        PopupWindow popupWindow2 = this.ntpServerPopWindow;
        if (popupWindow2 != null && popupWindow2.isShowing()) {
            this.ntpServerPopWindow.dismiss();
            this.ntpServerPopWindow = null;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        PopupWindow popupWindow = this.timeZonePopWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.timeZonePopWindow.dismiss();
            this.timeZonePopWindow = null;
        }
        PopupWindow popupWindow2 = this.ntpServerPopWindow;
        if (popupWindow2 == null || !popupWindow2.isShowing()) {
            return false;
        }
        this.ntpServerPopWindow.dismiss();
        this.ntpServerPopWindow = null;
        return false;
    }

    public void CallBackSHIXJasonCommon(String str, String str2) {
        if (str2.indexOf("125") > 0) {
            try {
                this.dateModel = DateModel.jsonToModel(str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mHandler.sendEmptyMessage(3);
        }
    }
}
