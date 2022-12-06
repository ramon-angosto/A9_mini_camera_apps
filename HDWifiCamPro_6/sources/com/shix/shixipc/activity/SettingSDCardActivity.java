package com.shix.shixipc.activity;

import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.bean.SDCardModel;
import com.shix.shixipc.bean.SdcardBean;
import com.shix.shixipc.bean.VideoRecordModel;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.view.Effectstype;
import com.shix.shixipc.view.NiftyDialogBuilder;
import com.shix.shixipc.view.SwitchView;
import java.util.List;
import ms.bd.o.Pgl.c;
import object.p2pipcam.nativecaller.NativeCaller;
import org.json.JSONException;

public class SettingSDCardActivity extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, NUIMainActivity.SHIXCOMMONInterface {
    private final int FAILED = 0;
    private final int PARAMS = 2;
    private final int SUCCESS = 1;
    private final int TIMEOUT = PathInterpolatorCompat.MAX_NUM_POINTS;
    private Button btnBack = null;
    private Button btnOk = null;
    Button btn_videomode0;
    Button btn_videomode2;
    Button btn_videomode3;
    private CheckBox cbxConverage = null;
    private CheckBox cbxVoid = null;
    /* access modifiers changed from: private */
    public EditText editRecordLength = null;
    private Handler handler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                SettingSDCardActivity.this.showToast((int) R.string.sdcard_set_failed);
            } else if (i == 1) {
                SettingSDCardActivity.this.showToast((int) R.string.sdcard_set_success);
                SettingSDCardActivity.this.finish();
                SettingSDCardActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
            } else if (i == 2) {
                boolean unused = SettingSDCardActivity.this.successFlag = true;
                SettingSDCardActivity.this.progressDialog.dismiss();
                SettingSDCardActivity.this.linearLayoutSD.setVisibility(8);
                if (SettingSDCardActivity.this.sdModel.getTotal() == 0) {
                    SettingSDCardActivity.this.tvSdRemain.setText(R.string.sdcard_no_inserted);
                } else {
                    TextView access$400 = SettingSDCardActivity.this.tvSdRemain;
                    access$400.setText(((SettingSDCardActivity.this.sdModel.getFree() * 100) / SettingSDCardActivity.this.sdModel.getTotal()) + "%");
                }
                if (CommonUtil.SHIX_isBkDid(SettingSDCardActivity.this.strDID).booleanValue()) {
                    if (SettingSDCardActivity.this.sdModel.getRecMode() == 0) {
                        SettingSDCardActivity.this.tv_mode.setText(R.string.sd_setting_videomode_no);
                        SettingSDCardActivity.this.findViewById(R.id.ll_start).setVisibility(8);
                        SettingSDCardActivity.this.findViewById(R.id.ll_end).setVisibility(8);
                    } else if (SettingSDCardActivity.this.sdModel.getRecMode() == 1) {
                        SettingSDCardActivity.this.tv_mode.setText(R.string.setting_sd_videomode1);
                        SettingSDCardActivity.this.findViewById(R.id.ll_start).setVisibility(8);
                        SettingSDCardActivity.this.findViewById(R.id.ll_end).setVisibility(8);
                    }
                } else if (SettingSDCardActivity.this.videoRecordModel != null) {
                    SettingSDCardActivity settingSDCardActivity = SettingSDCardActivity.this;
                    int unused2 = settingSDCardActivity.m_start_time_hour = settingSDCardActivity.videoRecordModel.getStart_time() / 3600;
                    SettingSDCardActivity settingSDCardActivity2 = SettingSDCardActivity.this;
                    int unused3 = settingSDCardActivity2.m_start_time_min = (settingSDCardActivity2.videoRecordModel.getStart_time() % 3600) / 60;
                    SettingSDCardActivity settingSDCardActivity3 = SettingSDCardActivity.this;
                    int unused4 = settingSDCardActivity3.m_end_time_hour = settingSDCardActivity3.videoRecordModel.getEnd_time() / 3600;
                    SettingSDCardActivity settingSDCardActivity4 = SettingSDCardActivity.this;
                    int unused5 = settingSDCardActivity4.m_end_time_min = (settingSDCardActivity4.videoRecordModel.getEnd_time() % 3600) / 60;
                    TextView textView = SettingSDCardActivity.this.tv_starttime;
                    StringBuilder sb = new StringBuilder();
                    SettingSDCardActivity settingSDCardActivity5 = SettingSDCardActivity.this;
                    sb.append(settingSDCardActivity5.getStrHour(settingSDCardActivity5.m_start_time_hour));
                    sb.append(" : ");
                    SettingSDCardActivity settingSDCardActivity6 = SettingSDCardActivity.this;
                    sb.append(settingSDCardActivity6.getStrMin(settingSDCardActivity6.m_start_time_min));
                    textView.setText(sb.toString());
                    TextView textView2 = SettingSDCardActivity.this.tv_endtime;
                    StringBuilder sb2 = new StringBuilder();
                    SettingSDCardActivity settingSDCardActivity7 = SettingSDCardActivity.this;
                    sb2.append(settingSDCardActivity7.getStrHour(settingSDCardActivity7.m_end_time_hour));
                    sb2.append(" : ");
                    SettingSDCardActivity settingSDCardActivity8 = SettingSDCardActivity.this;
                    sb2.append(settingSDCardActivity8.getStrMin(settingSDCardActivity8.m_end_time_min));
                    textView2.setText(sb2.toString());
                    if (SettingSDCardActivity.this.videoRecordModel.getRecordAudio() == 1) {
                        SettingSDCardActivity.this.sv_audio.setOpened(true);
                    } else {
                        SettingSDCardActivity.this.sv_audio.setOpened(false);
                    }
                    if (SettingSDCardActivity.this.videoRecordModel.getRecordcov() == 1) {
                        SettingSDCardActivity.this.sv_loop.setOpened(true);
                    } else {
                        SettingSDCardActivity.this.sv_loop.setOpened(false);
                    }
                    if (SettingSDCardActivity.this.videoRecordModel.getBistream() == 1) {
                        SettingSDCardActivity.this.tv_bit.setText(R.string.setting_sd_bit2);
                    } else {
                        SettingSDCardActivity.this.tv_bit.setText(R.string.setting_sd_bit1);
                    }
                    if (SettingSDCardActivity.this.videoRecordModel.getVideoRecord() == -110) {
                        SettingSDCardActivity.this.btn_videomode0.setVisibility(8);
                        if (SettingSDCardActivity.this.videoRecordModel.getTimerecord() != 1) {
                            SettingSDCardActivity.this.tv_mode.setText(R.string.setting_sd_videomode2);
                            SettingSDCardActivity.this.findViewById(R.id.ll_start).setVisibility(8);
                            SettingSDCardActivity.this.findViewById(R.id.ll_end).setVisibility(8);
                        } else if (SettingSDCardActivity.this.videoRecordModel.getStart_time() == 0 && SettingSDCardActivity.this.videoRecordModel.getEnd_time() == 86400) {
                            SettingSDCardActivity.this.tv_mode.setText(R.string.setting_sd_videomode1);
                            SettingSDCardActivity.this.findViewById(R.id.ll_start).setVisibility(8);
                            SettingSDCardActivity.this.findViewById(R.id.ll_end).setVisibility(8);
                        } else {
                            SettingSDCardActivity.this.tv_mode.setText(R.string.setting_sd_videomode3);
                            SettingSDCardActivity.this.findViewById(R.id.ll_start).setVisibility(0);
                            SettingSDCardActivity.this.findViewById(R.id.ll_end).setVisibility(0);
                        }
                    } else if (SettingSDCardActivity.this.videoRecordModel.getTimerecord() == 0) {
                        SettingSDCardActivity.this.tv_mode.setText(R.string.sd_setting_videomode_no);
                        SettingSDCardActivity.this.findViewById(R.id.ll_start).setVisibility(8);
                        SettingSDCardActivity.this.findViewById(R.id.ll_end).setVisibility(8);
                    } else if (SettingSDCardActivity.this.videoRecordModel.getTimerecord() == 1) {
                        SettingSDCardActivity.this.tv_mode.setText(R.string.setting_sd_videomode1);
                        SettingSDCardActivity.this.findViewById(R.id.ll_start).setVisibility(8);
                        SettingSDCardActivity.this.findViewById(R.id.ll_end).setVisibility(8);
                    } else if (SettingSDCardActivity.this.videoRecordModel.getTimerecord() == 2) {
                        SettingSDCardActivity.this.tv_mode.setText(R.string.setting_sd_videomode3);
                        SettingSDCardActivity.this.findViewById(R.id.ll_start).setVisibility(0);
                        SettingSDCardActivity.this.findViewById(R.id.ll_end).setVisibility(0);
                    } else if (SettingSDCardActivity.this.videoRecordModel.getTimerecord() == 3) {
                        SettingSDCardActivity.this.tv_mode.setText(R.string.setting_sd_videomode2);
                        SettingSDCardActivity.this.findViewById(R.id.ll_start).setVisibility(8);
                        SettingSDCardActivity.this.findViewById(R.id.ll_end).setVisibility(8);
                    }
                    EditText access$1500 = SettingSDCardActivity.this.editRecordLength;
                    access$1500.setText((SettingSDCardActivity.this.videoRecordModel.getRecord_time() / 60) + "");
                }
            }
        }
    };
    private int ifShow = 0;
    /* access modifiers changed from: private */
    public RelativeLayout linearLayoutSD;
    /* access modifiers changed from: private */
    public int m_end_time_hour = 0;
    /* access modifiers changed from: private */
    public int m_end_time_min = 0;
    /* access modifiers changed from: private */
    public int m_start_time_hour = 0;
    /* access modifiers changed from: private */
    public int m_start_time_min = 0;
    PopupWindow popupWindow_bit;
    PopupWindow popupWindow_videomode;
    View popv_bit;
    View popv_videomode;
    /* access modifiers changed from: private */
    public ProgressDialog progressDialog = null;
    /* access modifiers changed from: private */
    public ProgressDialog progressDialog1 = null;
    private Runnable runnable = new Runnable() {
        public void run() {
            if (!SettingSDCardActivity.this.successFlag) {
                boolean unused = SettingSDCardActivity.this.successFlag = false;
                SettingSDCardActivity.this.progressDialog.dismiss();
            }
        }
    };
    /* access modifiers changed from: private */
    public SDCardModel sdModel;
    private SdcardBean sdcardBean;
    private Button set_sd_format;
    /* access modifiers changed from: private */
    public String strDID = null;
    /* access modifiers changed from: private */
    public boolean successFlag = false;
    /* access modifiers changed from: private */
    public SwitchView sv_audio;
    /* access modifiers changed from: private */
    public SwitchView sv_loop;
    private int time15;
    private int time23;
    private int time7;
    /* access modifiers changed from: private */
    public TextView tvSdRemain = null;
    private TextView tvSdStatus = null;
    private TextView tvSdTotal = null;
    TextView tv_bit;
    TextView tv_endtime;
    TextView tv_mode;
    TextView tv_starttime;
    /* access modifiers changed from: private */
    public VideoRecordModel videoRecordModel;

    /* access modifiers changed from: private */
    public String getStrHour(int i) {
        if (i < 10) {
            return MBridgeConstans.ENDCARD_URL_TYPE_PL + i;
        }
        return "" + i;
    }

    /* access modifiers changed from: private */
    public String getStrMin(int i) {
        if (i < 10) {
            return MBridgeConstans.ENDCARD_URL_TYPE_PL + i;
        }
        return "" + i;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        StartHeat(this.strDID, SystemValue.doorBellAdmin, SystemValue.doorBellPass);
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        StopHeat();
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getDataFromOther();
        requestWindowFeature(1);
        setContentView(R.layout.settingsdcard);
        this.progressDialog = new ProgressDialog(this, 3);
        this.progressDialog.setProgressStyle(0);
        this.progressDialog.setMessage(getString(R.string.sdcard_getparams));
        this.progressDialog.show();
        this.sdcardBean = new SdcardBean();
        this.handler.postDelayed(this.runnable, 3000);
        initExitPopupWindow_bit();
        initExitPopupWindow_videomode();
        findView();
        setLister();
        NUIMainActivity.setSHIXCOMMONInterface(this);
        NativeCaller.TransferMessage(this.strDID, CommonUtil.getSDParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
        NativeCaller.TransferMessage(this.strDID, CommonUtil.getRDParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
    }

    public void initExitPopupWindow_bit() {
        this.popv_bit = LayoutInflater.from(this).inflate(R.layout.popup_bit, (ViewGroup) null);
        this.popv_bit.findViewById(R.id.btn_bit1).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SettingSDCardActivity.this.tv_bit.setText(R.string.setting_sd_bit1);
                SettingSDCardActivity.this.popupWindow_bit.dismiss();
                if (SettingSDCardActivity.this.videoRecordModel != null) {
                    SettingSDCardActivity.this.videoRecordModel.setBistream(0);
                }
            }
        });
        this.popv_bit.findViewById(R.id.btn_bit2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SettingSDCardActivity.this.tv_bit.setText(R.string.setting_sd_bit2);
                SettingSDCardActivity.this.popupWindow_bit.dismiss();
                if (SettingSDCardActivity.this.videoRecordModel != null) {
                    SettingSDCardActivity.this.videoRecordModel.setBistream(1);
                }
            }
        });
        this.popupWindow_bit = new PopupWindow(this.popv_bit, -2, -2);
        this.popupWindow_bit.setAnimationStyle(R.style.AnimationPreview);
        this.popupWindow_bit.setFocusable(true);
        this.popupWindow_bit.setOutsideTouchable(true);
        this.popupWindow_bit.setBackgroundDrawable(new ColorDrawable(0));
        this.popupWindow_bit.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                SettingSDCardActivity.this.popupWindow_bit.dismiss();
            }
        });
        this.popupWindow_bit.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                SettingSDCardActivity.this.popupWindow_bit.dismiss();
                return false;
            }
        });
    }

    public void initExitPopupWindow_videomode() {
        this.popv_videomode = LayoutInflater.from(this).inflate(R.layout.popup_videomode, (ViewGroup) null);
        this.btn_videomode0 = (Button) this.popv_videomode.findViewById(R.id.btn_videomode0);
        this.btn_videomode0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SettingSDCardActivity.this.tv_mode.setText(R.string.sd_setting_videomode_no);
                SettingSDCardActivity.this.popupWindow_videomode.dismiss();
                SettingSDCardActivity.this.findViewById(R.id.ll_start).setVisibility(8);
                SettingSDCardActivity.this.findViewById(R.id.ll_end).setVisibility(8);
                if (SettingSDCardActivity.this.videoRecordModel != null) {
                    SettingSDCardActivity.this.videoRecordModel.setTimerecord(0);
                }
                if (SettingSDCardActivity.this.sdModel != null) {
                    SettingSDCardActivity.this.sdModel.setRecMode(0);
                }
            }
        });
        this.popv_videomode.findViewById(R.id.btn_videomode1).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SettingSDCardActivity.this.tv_mode.setText(R.string.setting_sd_videomode1);
                SettingSDCardActivity.this.popupWindow_videomode.dismiss();
                SettingSDCardActivity.this.findViewById(R.id.ll_start).setVisibility(8);
                SettingSDCardActivity.this.findViewById(R.id.ll_end).setVisibility(8);
                if (SettingSDCardActivity.this.sdModel != null) {
                    SettingSDCardActivity.this.sdModel.setRecMode(1);
                }
                if (SettingSDCardActivity.this.videoRecordModel == null) {
                    return;
                }
                if (SettingSDCardActivity.this.videoRecordModel.getVideoRecord() != -110) {
                    SettingSDCardActivity.this.videoRecordModel.setTimerecord(1);
                    return;
                }
                SettingSDCardActivity.this.videoRecordModel.setTimerecord(1);
                SettingSDCardActivity.this.videoRecordModel.setStart_time(0);
                SettingSDCardActivity.this.videoRecordModel.setEnd_time(86400);
            }
        });
        this.btn_videomode2 = (Button) this.popv_videomode.findViewById(R.id.btn_videomode2);
        this.popv_videomode.findViewById(R.id.btn_videomode2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SettingSDCardActivity.this.tv_mode.setText(R.string.setting_sd_videomode2);
                SettingSDCardActivity.this.popupWindow_videomode.dismiss();
                if (SettingSDCardActivity.this.videoRecordModel != null) {
                    if (SettingSDCardActivity.this.videoRecordModel.getVideoRecord() != -110) {
                        SettingSDCardActivity.this.videoRecordModel.setTimerecord(3);
                    } else {
                        SettingSDCardActivity.this.videoRecordModel.setTimerecord(0);
                    }
                }
                SettingSDCardActivity.this.findViewById(R.id.ll_start).setVisibility(8);
                SettingSDCardActivity.this.findViewById(R.id.ll_end).setVisibility(8);
            }
        });
        this.btn_videomode3 = (Button) this.popv_videomode.findViewById(R.id.btn_videomode3);
        this.popv_videomode.findViewById(R.id.btn_videomode3).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SettingSDCardActivity.this.tv_mode.setText(R.string.setting_sd_videomode3);
                SettingSDCardActivity.this.findViewById(R.id.ll_start).setVisibility(0);
                SettingSDCardActivity.this.findViewById(R.id.ll_end).setVisibility(0);
                SettingSDCardActivity.this.popupWindow_videomode.dismiss();
                if (SettingSDCardActivity.this.videoRecordModel == null) {
                    return;
                }
                if (SettingSDCardActivity.this.videoRecordModel.getVideoRecord() != -110) {
                    SettingSDCardActivity.this.videoRecordModel.setTimerecord(2);
                    return;
                }
                SettingSDCardActivity.this.videoRecordModel.setTimerecord(1);
                if (SettingSDCardActivity.this.videoRecordModel.getEnd_time() == 86400) {
                    SettingSDCardActivity.this.videoRecordModel.setEnd_time(86340);
                }
            }
        });
        this.popupWindow_videomode = new PopupWindow(this.popv_videomode, -2, -2);
        this.popupWindow_videomode.setAnimationStyle(R.style.AnimationPreview);
        this.popupWindow_videomode.setFocusable(true);
        this.popupWindow_videomode.setOutsideTouchable(true);
        this.popupWindow_videomode.setBackgroundDrawable(new ColorDrawable(0));
        this.popupWindow_videomode.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                SettingSDCardActivity.this.popupWindow_videomode.dismiss();
            }
        });
        this.popupWindow_videomode.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                SettingSDCardActivity.this.popupWindow_videomode.dismiss();
                return false;
            }
        });
    }

    private void getDataFromOther() {
        this.strDID = getIntent().getStringExtra(ContentCommon.STR_CAMERA_ID);
    }

    private void setLister() {
        this.btnBack.setOnClickListener(this);
        this.btnOk.setOnClickListener(this);
        this.cbxConverage.setOnCheckedChangeListener(this);
        this.cbxVoid.setOnCheckedChangeListener(this);
        this.editRecordLength.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                try {
                    String obj = editable.toString();
                    if (obj == null) {
                        obj = MBridgeConstans.ENDCARD_URL_TYPE_PL;
                    }
                    int parseInt = Integer.parseInt(obj);
                    if (parseInt < 5 || parseInt > 30) {
                        parseInt = 5;
                    }
                    if (SettingSDCardActivity.this.videoRecordModel != null) {
                        SettingSDCardActivity.this.videoRecordModel.setRecord_time(parseInt * 60);
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    private void findView() {
        this.linearLayoutSD = (RelativeLayout) findViewById(R.id.linearLayoutSD);
        this.tv_bit = (TextView) findViewById(R.id.tv_bit);
        this.tv_mode = (TextView) findViewById(R.id.tv_mode);
        this.tv_starttime = (TextView) findViewById(R.id.tv_starttime);
        this.tv_endtime = (TextView) findViewById(R.id.tv_endtime);
        this.tvSdTotal = (TextView) findViewById(R.id.tv_sd_total);
        this.tvSdRemain = (TextView) findViewById(R.id.tv_sd_remain);
        this.tvSdStatus = (TextView) findViewById(R.id.tv_state);
        this.cbxConverage = (CheckBox) findViewById(R.id.cbx_coverage);
        this.cbxVoid = (CheckBox) findViewById(R.id.cbx_void);
        this.editRecordLength = (EditText) findViewById(R.id.edit_record_length);
        this.btnBack = (Button) findViewById(R.id.back);
        this.btnOk = (Button) findViewById(R.id.ok);
        this.set_sd_format = (Button) findViewById(R.id.set_sd_format);
        this.set_sd_format.setOnClickListener(this);
        if (CommonUtil.SHIX_isBkDid(this.strDID).booleanValue()) {
            findViewById(R.id.ll_timevideo).setVisibility(8);
            findViewById(R.id.ll_bit).setVisibility(8);
            findViewById(R.id.ll_audio).setVisibility(8);
            findViewById(R.id.ll_loop).setVisibility(8);
            findViewById(R.id.ll_start).setVisibility(8);
            findViewById(R.id.ll_end).setVisibility(8);
        } else if (CommonUtil.isMJCamera(this.strDID)) {
            findViewById(R.id.ll_timevideo).setVisibility(8);
            findViewById(R.id.ll_bit).setVisibility(8);
            findViewById(R.id.ll_mode).setVisibility(8);
            findViewById(R.id.ll_audio).setVisibility(8);
            findViewById(R.id.ll_loop).setVisibility(8);
        }
        this.sv_audio = (SwitchView) findViewById(R.id.sv_audio);
        this.sv_audio.setOnStateChangedListener(new SwitchView.OnStateChangedListener() {
            public void toggleToOn(SwitchView switchView) {
                SettingSDCardActivity.this.sv_audio.setOpened(true);
                SettingSDCardActivity.this.videoRecordModel.setRecordAudio(1);
            }

            public void toggleToOff(SwitchView switchView) {
                SettingSDCardActivity.this.sv_audio.setOpened(false);
                SettingSDCardActivity.this.videoRecordModel.setRecordAudio(0);
            }
        });
        this.sv_loop = (SwitchView) findViewById(R.id.sv_loop);
        this.sv_loop.setOnStateChangedListener(new SwitchView.OnStateChangedListener() {
            public void toggleToOn(SwitchView switchView) {
                SettingSDCardActivity.this.sv_loop.setOpened(true);
                SettingSDCardActivity.this.videoRecordModel.setRecordcov(1);
            }

            public void toggleToOff(SwitchView switchView) {
                SettingSDCardActivity.this.sv_loop.setOpened(false);
                SettingSDCardActivity.this.videoRecordModel.setRecordcov(0);
            }
        });
        findViewById(R.id.ll_bit).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SettingSDCardActivity.this, 10);
                }
                SettingSDCardActivity.this.popupWindow_bit.showAsDropDown(SettingSDCardActivity.this.findViewById(R.id.ll_bit));
            }
        });
        findViewById(R.id.ll_mode).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SettingSDCardActivity.this, 10);
                }
                if (CommonUtil.SHIX_isBkDid(SettingSDCardActivity.this.strDID).booleanValue()) {
                    SettingSDCardActivity.this.btn_videomode2.setVisibility(8);
                    SettingSDCardActivity.this.btn_videomode3.setVisibility(8);
                }
                SettingSDCardActivity.this.popupWindow_videomode.showAsDropDown(SettingSDCardActivity.this.findViewById(R.id.ll_mode));
            }
        });
        findViewById(R.id.ll_start).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SettingSDCardActivity.this, 10);
                }
                SettingSDCardActivity settingSDCardActivity = SettingSDCardActivity.this;
                int unused = settingSDCardActivity.m_start_time_hour = settingSDCardActivity.videoRecordModel.getStart_time() / 3600;
                SettingSDCardActivity settingSDCardActivity2 = SettingSDCardActivity.this;
                int unused2 = settingSDCardActivity2.m_start_time_min = (settingSDCardActivity2.videoRecordModel.getStart_time() % 3600) / 60;
                new TimePickerDialog(SettingSDCardActivity.this, 2, new TimePickerDialog.OnTimeSetListener() {
                    public void onTimeSet(TimePicker timePicker, int i, int i2) {
                        CommonUtil.Log(1, "start hourOfDay:" + i + "  minute:" + i2);
                        int unused = SettingSDCardActivity.this.m_start_time_hour = i;
                        int unused2 = SettingSDCardActivity.this.m_start_time_min = i2;
                        int access$700 = (SettingSDCardActivity.this.m_start_time_hour * 3600) + (SettingSDCardActivity.this.m_start_time_min * 60);
                        if (SettingSDCardActivity.this.videoRecordModel != null) {
                            SettingSDCardActivity.this.videoRecordModel.setStart_time(access$700);
                        }
                        TextView textView = SettingSDCardActivity.this.tv_starttime;
                        textView.setText(SettingSDCardActivity.this.getStrHour(SettingSDCardActivity.this.m_start_time_hour) + " : " + SettingSDCardActivity.this.getStrMin(SettingSDCardActivity.this.m_start_time_min));
                    }
                }, SettingSDCardActivity.this.m_start_time_hour, SettingSDCardActivity.this.m_start_time_min, true).show();
            }
        });
        findViewById(R.id.ll_end).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(SettingSDCardActivity.this, 10);
                }
                SettingSDCardActivity settingSDCardActivity = SettingSDCardActivity.this;
                int unused = settingSDCardActivity.m_end_time_hour = settingSDCardActivity.videoRecordModel.getEnd_time() / 3600;
                SettingSDCardActivity settingSDCardActivity2 = SettingSDCardActivity.this;
                int unused2 = settingSDCardActivity2.m_end_time_min = (settingSDCardActivity2.videoRecordModel.getEnd_time() % 3600) / 60;
                new TimePickerDialog(SettingSDCardActivity.this, 2, new TimePickerDialog.OnTimeSetListener() {
                    public void onTimeSet(TimePicker timePicker, int i, int i2) {
                        CommonUtil.Log(1, "end hourOfDay:" + i + "  minute:" + i2);
                        int unused = SettingSDCardActivity.this.m_end_time_hour = i;
                        int unused2 = SettingSDCardActivity.this.m_end_time_min = i2;
                        int access$900 = (SettingSDCardActivity.this.m_end_time_hour * 3600) + (SettingSDCardActivity.this.m_end_time_min * 60);
                        if (SettingSDCardActivity.this.videoRecordModel != null) {
                            SettingSDCardActivity.this.videoRecordModel.setEnd_time(access$900);
                        }
                        TextView textView = SettingSDCardActivity.this.tv_endtime;
                        textView.setText(SettingSDCardActivity.this.getStrHour(SettingSDCardActivity.this.m_end_time_hour) + " : " + SettingSDCardActivity.this.getStrMin(SettingSDCardActivity.this.m_end_time_min));
                    }
                }, SettingSDCardActivity.this.m_end_time_hour, SettingSDCardActivity.this.m_end_time_min, true).show();
            }
        });
    }

    private ArrayAdapter<String> showSpnner(List<String> list) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, 17367048, list);
        arrayAdapter.setDropDownViewResource(17367049);
        return arrayAdapter;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            finish();
            overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
        } else if (id == R.id.ok) {
            setSDCardSchedule();
        } else if (id == R.id.set_sd_format) {
            final NiftyDialogBuilder instance = NiftyDialogBuilder.getInstance(this);
            instance.withTitle(getResources().getString(R.string.set_sd_format)).withMessage((CharSequence) getString(R.string.sd_setting_show)).withEffect(Effectstype.Slidetop).setButton1Click(new View.OnClickListener() {
                public void onClick(View view) {
                    instance.dismiss();
                }
            }).setButton2Click(new View.OnClickListener() {
                public void onClick(View view) {
                    new AsyncTask<Void, Void, Void>() {
                        /* access modifiers changed from: protected */
                        public void onPreExecute() {
                            NativeCaller.TransferMessage(SettingSDCardActivity.this.strDID, CommonUtil.formatSDParms(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
                            ProgressDialog unused = SettingSDCardActivity.this.progressDialog1 = new ProgressDialog(SettingSDCardActivity.this);
                            SettingSDCardActivity.this.progressDialog1.setProgressStyle(0);
                            SettingSDCardActivity.this.progressDialog1.setMessage(SettingSDCardActivity.this.getString(R.string.set_sd_format_show1));
                            SettingSDCardActivity.this.progressDialog1.setCancelable(false);
                            SettingSDCardActivity.this.progressDialog1.show();
                        }

                        /* access modifiers changed from: protected */
                        public Void doInBackground(Void... voidArr) {
                            try {
                                Thread.sleep(DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (CommonUtil.SHIX_isBkDid(SettingSDCardActivity.this.strDID).booleanValue()) {
                                NativeCaller.TransferMessage(SettingSDCardActivity.this.strDID, CommonUtil.CameraControl(SystemValue.doorBellAdmin, SystemValue.doorBellPass, "reboot", 1), 0);
                            }
                            try {
                                Thread.sleep(DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
                                return null;
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                                return null;
                            }
                        }

                        /* access modifiers changed from: protected */
                        public void onPostExecute(Void voidR) {
                            if (SettingSDCardActivity.this.progressDialog1 != null && SettingSDCardActivity.this.progressDialog1.isShowing()) {
                                SettingSDCardActivity.this.progressDialog1.cancel();
                            }
                            SettingSDCardActivity.this.sendBroadcast(new Intent("myback"));
                            SettingSDCardActivity.this.finish();
                        }
                    }.execute(new Void[0]);
                    instance.dismiss();
                }
            }).show();
        }
    }

    private void setSDCardSchedule() {
        this.sdcardBean.getRecord_timer();
        if (CommonUtil.SHIX_isBkDid(this.strDID).booleanValue()) {
            if (this.sdModel.getRecMode() == 0 || this.sdModel.getRecMode() == 1) {
                NativeCaller.TransferMessage(this.strDID, CommonUtil.setSDVideoMode(SystemValue.doorBellAdmin, SystemValue.doorBellPass, this.sdModel.getRecMode()), 0);
            } else {
                NativeCaller.TransferMessage(this.strDID, CommonUtil.setSDVideoMode(SystemValue.doorBellAdmin, SystemValue.doorBellPass, 1), 0);
            }
            finish();
            return;
        }
        VideoRecordModel videoRecordModel2 = this.videoRecordModel;
        if (videoRecordModel2 != null) {
            if (videoRecordModel2.getEnd_time() <= this.videoRecordModel.getStart_time()) {
                showToast((int) R.string.set_sd_show4);
                return;
            }
            if (this.videoRecordModel.getRecord_time() < 300 || this.videoRecordModel.getRecord_time() > 1800 || this.editRecordLength.getText().length() == 0) {
                this.videoRecordModel.setRecord_time(c.COLLECT_MODE_FINANCE);
            }
            try {
                NativeCaller.TransferMessage(this.strDID, VideoRecordModel.toJson(this.videoRecordModel, SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        switch (compoundButton.getId()) {
            case R.id.cbx_coverage:
                if (z) {
                    this.sdcardBean.setRecord_conver_enable(1);
                    return;
                } else {
                    this.sdcardBean.setRecord_conver_enable(0);
                    return;
                }
            case R.id.cbx_void:
                if (z) {
                    this.sdcardBean.setRecord_void_enable(1);
                    return;
                } else {
                    this.sdcardBean.setRecord_void_enable(0);
                    return;
                }
            default:
                return;
        }
    }

    public void CallBackSHIXJasonCommon(String str, String str2) {
        CommonUtil.Log(1, "ifShow:" + this.ifShow);
        if (str2 != null && str2.indexOf("109") >= 0) {
            try {
                this.sdModel = SDCardModel.jsonToModel(str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.handler.sendEmptyMessage(2);
        }
        if (str2 != null && str2.indexOf("199") >= 0) {
            try {
                this.videoRecordModel = VideoRecordModel.jsonToModel(str2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.handler.sendEmptyMessage(2);
        }
    }
}
