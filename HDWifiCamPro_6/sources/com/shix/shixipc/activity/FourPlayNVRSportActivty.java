package com.shix.shixipc.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.adapter.CameraSelectAdapter;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import object.p2pipcam.nativecaller.NativeCaller;

public class FourPlayNVRSportActivty extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener, NUIMainActivity.IPPlayInterface, View.OnLongClickListener, NUIMainActivity.ConnectChannelStatusInterface1 {
    private static final String STR_DID = "did";
    private static final String STR_MSG_PARAM = "msgparam";
    private int ConnectTag = 0;
    private int CutCount = 4;
    private LinearLayout Linear_mid_four;
    private final int PLAYTAG1 = IronSourceConstants.RV_INSTANCE_LOAD_NO_FILL;
    private final int PLAYTAG2 = 1214;
    private final int PLAYTAG3 = 1215;
    private final int PLAYTAG4 = 1216;
    /* access modifiers changed from: private */
    public Handler PPPPMsgHandler = new Handler() {
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            int i = data.getInt(FourPlayNVRSportActivty.STR_MSG_PARAM);
            int i2 = message.what;
            String string = data.getString(FourPlayNVRSportActivty.STR_DID);
            if (i2 == 0) {
                Intent intent = new Intent("camera_status_change");
                intent.putExtra(ContentCommon.STR_CAMERA_ID, string);
                intent.putExtra(ContentCommon.STR_PPPP_STATUS, i);
                FourPlayNVRSportActivty.this.sendBroadcast(intent);
                if (i == 5 || i == 3 || i == 6 || i == 7 || i == 8) {
                    NativeCaller.StopPPPP(string);
                }
            } else if (i2 != 1 && i2 != 200) {
                switch (i2) {
                    case IronSourceConstants.RV_INSTANCE_LOAD_NO_FILL:
                        Log.d("taggg", "test---hangler");
                        FourPlayNVRSportActivty.this.imageView1.setImageBitmap(FourPlayNVRSportActivty.this.bitmap11);
                        return;
                    case 1214:
                        FourPlayNVRSportActivty.this.imageView2.setImageBitmap(FourPlayNVRSportActivty.this.bitmap22);
                        return;
                    case 1215:
                        FourPlayNVRSportActivty.this.imageView3.setImageBitmap(FourPlayNVRSportActivty.this.bitmap33);
                        return;
                    case 1216:
                        FourPlayNVRSportActivty.this.imageView4.setImageBitmap(FourPlayNVRSportActivty.this.bitmap44);
                        return;
                    default:
                        return;
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean PlayTag;
    private RelativeLayout Relative_top;
    private final int SLEEPTIME = 100;
    private final int SNAPSHOT = 200;
    /* access modifiers changed from: private */
    public int TAGPlay = 0;
    private CameraParamsBean bean;
    /* access modifiers changed from: private */
    public int bitMapHight = 0;
    /* access modifiers changed from: private */
    public int bitMapWidth = 0;
    Bitmap bitmap11;
    Bitmap bitmap22;
    Bitmap bitmap33;
    Bitmap bitmap44;
    /* access modifiers changed from: private */
    public Bitmap bitmap_defult;
    private Button button_cut;
    /* access modifiers changed from: private */
    public int camerSum = 0;
    private CameraSelectAdapter cameraSelectAdapter;
    private long exitTime = 0;
    private FrameLayout frameLayout1;
    private FrameLayout frameLayout2;
    private FrameLayout frameLayout3;
    private FrameLayout frameLayout4;
    boolean ifDrawOver = false;
    private boolean ifHind = true;
    /* access modifiers changed from: private */
    public int ifImageTag1;
    /* access modifiers changed from: private */
    public int ifImageTag2;
    /* access modifiers changed from: private */
    public int ifImageTag3;
    /* access modifiers changed from: private */
    public int ifImageTag4;
    /* access modifiers changed from: private */
    public int image1Higth;
    /* access modifiers changed from: private */
    public int image1IsH264;
    /* access modifiers changed from: private */
    public int image1Width;
    /* access modifiers changed from: private */
    public int image2Higth;
    /* access modifiers changed from: private */
    public int image2IsH264;
    /* access modifiers changed from: private */
    public int image2Width;
    /* access modifiers changed from: private */
    public int image3Higth;
    /* access modifiers changed from: private */
    public int image3IsH264;
    /* access modifiers changed from: private */
    public int image3Width;
    /* access modifiers changed from: private */
    public int image4Higth;
    /* access modifiers changed from: private */
    public int image4IsH264;
    /* access modifiers changed from: private */
    public int image4Width;
    /* access modifiers changed from: private */
    public TextView imageButton1;
    /* access modifiers changed from: private */
    public TextView imageButton2;
    /* access modifiers changed from: private */
    public TextView imageButton3;
    /* access modifiers changed from: private */
    public TextView imageButton4;
    private ImageButton imageButton_hind = null;
    /* access modifiers changed from: private */
    public ImageView imageView1;
    /* access modifiers changed from: private */
    public ImageView imageView2;
    /* access modifiers changed from: private */
    public ImageView imageView3;
    /* access modifiers changed from: private */
    public ImageView imageView4;
    /* access modifiers changed from: private */
    public Intent in;
    private boolean isFullPlay = false;
    private LinearLayout linear_four_one;
    private LinearLayout linear_four_two;
    private ListView listviewCamera;
    boolean mbLoop = false;
    int nVideoHeight22 = 0;
    int nVideoWidth11 = 0;
    /* access modifiers changed from: private */
    public String name1;
    /* access modifiers changed from: private */
    public String name2;
    /* access modifiers changed from: private */
    public String name3;
    /* access modifiers changed from: private */
    public String name4;
    private Handler noLineHandler = new Handler() {
        public void handleMessage(Message message) {
            String string = message.getData().getString("no_line_did");
            if (message.what == 110) {
                if (FourPlayNVRSportActivty.this.imageView1.getTag().toString().equals(string) && FourPlayNVRSportActivty.this.strDidList.size() != 0) {
                    FourPlayNVRSportActivty.access$210(FourPlayNVRSportActivty.this);
                    boolean unused = FourPlayNVRSportActivty.this.ssidTag1 = false;
                    FourPlayNVRSportActivty.this.imageButton1.setVisibility(0);
                    FourPlayNVRSportActivty.this.imageButton1.setTag(1);
                    FourPlayNVRSportActivty.this.imageButton1.setBackgroundResource(SystemValue.FourStopBg);
                    FourPlayNVRSportActivty fourPlayNVRSportActivty = FourPlayNVRSportActivty.this;
                    fourPlayNVRSportActivty.showToast(FourPlayNVRSportActivty.this.name1 + FourPlayNVRSportActivty.this.getResources().getString(R.string.pppp_status_disconnect));
                } else if (FourPlayNVRSportActivty.this.imageView2.getTag().toString().equals(string) && FourPlayNVRSportActivty.this.strDidList.size() != 0) {
                    FourPlayNVRSportActivty.access$210(FourPlayNVRSportActivty.this);
                    boolean unused2 = FourPlayNVRSportActivty.this.ssidTag2 = false;
                    FourPlayNVRSportActivty.this.imageButton2.setVisibility(0);
                    FourPlayNVRSportActivty.this.imageButton2.setTag(1);
                    FourPlayNVRSportActivty.this.imageButton2.setBackgroundResource(SystemValue.FourStopBg);
                    FourPlayNVRSportActivty fourPlayNVRSportActivty2 = FourPlayNVRSportActivty.this;
                    fourPlayNVRSportActivty2.showToast(FourPlayNVRSportActivty.this.name2 + FourPlayNVRSportActivty.this.getResources().getString(R.string.pppp_status_disconnect));
                } else if (FourPlayNVRSportActivty.this.imageView3.getTag().toString().equals(string) && FourPlayNVRSportActivty.this.strDidList.size() != 0) {
                    FourPlayNVRSportActivty.access$210(FourPlayNVRSportActivty.this);
                    boolean unused3 = FourPlayNVRSportActivty.this.ssidTag3 = false;
                    FourPlayNVRSportActivty.this.imageButton3.setVisibility(0);
                    FourPlayNVRSportActivty.this.imageButton3.setTag(1);
                    FourPlayNVRSportActivty.this.imageButton3.setBackgroundResource(SystemValue.FourStopBg);
                    FourPlayNVRSportActivty fourPlayNVRSportActivty3 = FourPlayNVRSportActivty.this;
                    fourPlayNVRSportActivty3.showToast(FourPlayNVRSportActivty.this.name3 + FourPlayNVRSportActivty.this.getResources().getString(R.string.pppp_status_disconnect));
                } else if (FourPlayNVRSportActivty.this.imageView4.getTag().toString().equals(string) && FourPlayNVRSportActivty.this.strDidList.size() != 0) {
                    FourPlayNVRSportActivty.access$210(FourPlayNVRSportActivty.this);
                    boolean unused4 = FourPlayNVRSportActivty.this.ssidTag4 = false;
                    FourPlayNVRSportActivty.this.imageButton4.setVisibility(0);
                    FourPlayNVRSportActivty.this.imageButton4.setTag(1);
                    FourPlayNVRSportActivty.this.imageButton4.setBackgroundResource(SystemValue.FourStopBg);
                    FourPlayNVRSportActivty fourPlayNVRSportActivty4 = FourPlayNVRSportActivty.this;
                    fourPlayNVRSportActivty4.showToast(FourPlayNVRSportActivty.this.name4 + FourPlayNVRSportActivty.this.getResources().getString(R.string.pppp_status_disconnect));
                }
            }
        }
    };
    int one = 0;
    BitmapFactory.Options options;
    /* access modifiers changed from: private */
    public PopupWindow popupWindow_List;
    /* access modifiers changed from: private */
    public PopupWindow popupWindow_about;
    private View popv_List;
    private String preDid1;
    private String preDid2;
    private String preDid3;
    private String preDid4;
    /* access modifiers changed from: private */
    public SharedPreferences preFourPlay;
    private ProgressDialog progressDialogCommon;
    int screenHeight;
    int screenWidth;
    /* access modifiers changed from: private */
    public boolean ssidTag1 = false;
    /* access modifiers changed from: private */
    public boolean ssidTag2 = false;
    /* access modifiers changed from: private */
    public boolean ssidTag3 = false;
    /* access modifiers changed from: private */
    public boolean ssidTag4 = false;
    private String strDid = "";
    /* access modifiers changed from: private */
    public ArrayList<String> strDidList;
    private String strName = null;
    private String strPwd = null;
    private String strUser = null;
    byte[] sufVideoBytes1;
    byte[] sufVideoBytes2;
    byte[] sufVideoBytes3;
    byte[] sufVideoBytes4;
    /* access modifiers changed from: private */
    public TextView textView1;
    /* access modifiers changed from: private */
    public TextView textView2;
    /* access modifiers changed from: private */
    public TextView textView3;
    /* access modifiers changed from: private */
    public TextView textView4;
    int two = 0;
    String uiDid = "";
    private int widthTest = 80;

    private void showPlayLastBmp(String str) {
    }

    public void BSMsgNotifyData(String str, int i, int i2) {
    }

    public void callBackAudioData(byte[] bArr, int i) {
    }

    public void callBackCameraParamNotify(String str, int i, int i2, int i3, int i4, int i5, int i6) {
    }

    public void callBackH264Data(byte[] bArr, int i, int i2) {
    }

    static /* synthetic */ int access$210(FourPlayNVRSportActivty fourPlayNVRSportActivty) {
        int i = fourPlayNVRSportActivty.camerSum;
        fourPlayNVRSportActivty.camerSum = i - 1;
        return i;
    }

    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.fourplay);
        this.preFourPlay = getSharedPreferences(ContentCommon.PREDATA, 0);
        this.strName = getIntent().getStringExtra(ContentCommon.STR_CAMERA_NAME);
        this.strDid = getIntent().getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.strUser = getIntent().getStringExtra(ContentCommon.STR_CAMERA_USER);
        this.strPwd = getIntent().getStringExtra(ContentCommon.STR_CAMERA_PWD);
        findView();
        findViewById(R.id.date_cancel).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(FourPlayNVRSportActivty.this, 10);
                }
                FourPlayNVRSportActivty.this.finish();
            }
        });
        this.options = new BitmapFactory.Options();
        this.options.inSampleSize = 2;
        setControlListener();
        SystemValue.TAG_CAMERLIST = 1;
        this.screenHeight = getWindowManager().getDefaultDisplay().getHeight();
        this.screenWidth = getWindowManager().getDefaultDisplay().getWidth();
        this.bitMapWidth = this.screenWidth / 2;
        this.bitMapHight = this.screenHeight / 2;
        Log.d("tagggg", "screenHeight==" + this.screenHeight + "screenWidth==" + this.screenWidth);
        this.strDidList = new ArrayList<>();
        NUIMainActivity.setIpPlayInterface(this);
        this.progressDialogCommon = new ProgressDialog(this);
        this.bitmap_defult = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.camer_ico), this.bitMapWidth, this.bitMapHight, true);
        initExitPopupWindow2();
        initExitPopupWindow_List();
        this.cameraSelectAdapter = new CameraSelectAdapter(this);
        this.listviewCamera.setAdapter(this.cameraSelectAdapter);
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        this.camerSum = 0;
        for (int i2 = 1; i2 < 7; i2++) {
            String GetCommonShareStringValue = CommonUtil.GetCommonShareStringValue(this, this.strDid + "channel" + i2, "");
            if (GetCommonShareStringValue != null && GetCommonShareStringValue.length() >= 2 && (i = this.camerSum) <= 3) {
                this.camerSum = i + 1;
                String str = this.strDid + "_" + this.camerSum;
                this.strDidList.add(str);
                NUIMainActivity.setConnectChannelStatusInterface1(this);
                NativeCaller.StopPPPP(str);
                CommonUtil.Log(1, "stringMac:" + this.camerSum + "  " + GetCommonShareStringValue);
                StartPPPP1(str, this.strUser, this.strPwd, GetCommonShareStringValue);
            }
        }
    }

    private CameraParamsBean returnCameraBean(String str) {
        for (int i = 0; i < SystemValue.arrayList.size(); i++) {
            if (str.equals(SystemValue.arrayList.get(i).getDev_Did())) {
                return SystemValue.arrayList.get(i);
            }
        }
        return null;
    }

    private void findView() {
        this.linear_four_one = (LinearLayout) findViewById(R.id.linear_four_one);
        this.linear_four_two = (LinearLayout) findViewById(R.id.linear_four_two);
        this.frameLayout1 = (FrameLayout) findViewById(R.id.frame1);
        this.frameLayout2 = (FrameLayout) findViewById(R.id.frame2);
        this.frameLayout3 = (FrameLayout) findViewById(R.id.frame3);
        this.frameLayout4 = (FrameLayout) findViewById(R.id.frame4);
        this.imageView1 = (ImageView) findViewById(R.id.imageView1);
        this.imageView2 = (ImageView) findViewById(R.id.imageView2);
        this.imageView3 = (ImageView) findViewById(R.id.imageView3);
        this.imageView4 = (ImageView) findViewById(R.id.imageView4);
        this.textView1 = (TextView) findViewById(R.id.textView1_ssid);
        this.textView2 = (TextView) findViewById(R.id.textView2_ssid);
        this.textView3 = (TextView) findViewById(R.id.textView3_ssid);
        this.textView4 = (TextView) findViewById(R.id.textView4_ssid);
        this.imageButton_hind = (ImageButton) findViewById(R.id.imagebutton_hind);
        this.imageView1.setTag(1);
        this.imageView2.setTag(1);
        this.imageView3.setTag(1);
        this.imageView4.setTag(1);
        this.imageButton1 = (TextView) findViewById(R.id.imagebutton1);
        this.imageButton1.setOnClickListener(this);
        this.imageButton1.setTag(0);
        this.imageButton2 = (TextView) findViewById(R.id.imagebutton2);
        this.imageButton2.setOnClickListener(this);
        this.imageButton2.setTag(0);
        this.imageButton3 = (TextView) findViewById(R.id.imagebutton3);
        this.imageButton3.setOnClickListener(this);
        this.imageButton3.setTag(0);
        this.imageButton4 = (TextView) findViewById(R.id.imagebutton4);
        this.imageButton4.setOnClickListener(this);
        this.imageButton4.setTag(0);
        this.button_cut = (Button) findViewById(R.id.button_cut);
        this.button_cut.setOnClickListener(this);
        this.Linear_mid_four = (LinearLayout) findViewById(R.id.Linear_mid_four);
    }

    private void setControlListener() {
        this.imageView1.setOnClickListener(this);
        this.imageView2.setOnClickListener(this);
        this.imageView3.setOnClickListener(this);
        this.imageView4.setOnClickListener(this);
        this.imageView1.setOnLongClickListener(this);
        this.imageView2.setOnLongClickListener(this);
        this.imageView3.setOnLongClickListener(this);
        this.imageView4.setOnLongClickListener(this);
        this.imageButton_hind.setOnClickListener(this);
    }

    public void initExitPopupWindow_List() {
        this.popv_List = LayoutInflater.from(this).inflate(R.layout.popup_list, (ViewGroup) null);
        this.popupWindow_List = new PopupWindow(this.popv_List, -1, -1);
        this.listviewCamera = (ListView) this.popv_List.findViewById(R.id.listviewCamera);
        this.Relative_top = (RelativeLayout) this.popv_List.findViewById(R.id.Relative_top);
        this.listviewCamera.setOnItemClickListener(this);
        this.popupWindow_List.setAnimationStyle(R.style.AnimationPreview);
        this.popupWindow_List.setFocusable(true);
        this.popupWindow_List.setOutsideTouchable(true);
        this.popupWindow_List.setBackgroundDrawable(new ColorDrawable(0));
        this.popv_List.findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FourPlayNVRSportActivty.this.popupWindow_List.dismiss();
            }
        });
        this.popupWindow_List.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                FourPlayNVRSportActivty.this.popupWindow_List.dismiss();
            }
        });
        this.popupWindow_List.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                FourPlayNVRSportActivty.this.popupWindow_List.dismiss();
                return false;
            }
        });
    }

    public void initExitPopupWindow2() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.popup, (ViewGroup) null);
        this.popupWindow_about = new PopupWindow(inflate, -2, -2);
        this.popupWindow_about.setAnimationStyle(R.style.AnimationPreview);
        this.popupWindow_about.setFocusable(true);
        this.popupWindow_about.setOutsideTouchable(true);
        this.popupWindow_about.setBackgroundDrawable(new ColorDrawable(0));
        ((Button) inflate.findViewById(R.id.add_check_load)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int access$1900 = FourPlayNVRSportActivty.this.TAGPlay;
                if (access$1900 == 1) {
                    String obj = FourPlayNVRSportActivty.this.imageView1.getTag().toString();
                    if (!obj.equalsIgnoreCase("1")) {
                        NativeCaller.StopPPPPLivestream(obj);
                        boolean unused = FourPlayNVRSportActivty.this.ssidTag1 = false;
                    }
                    FourPlayNVRSportActivty.this.imageButton1.setVisibility(0);
                    FourPlayNVRSportActivty.this.imageButton1.setTag(1);
                    FourPlayNVRSportActivty.this.imageButton1.setBackgroundResource(SystemValue.FourStopBg);
                } else if (access$1900 == 2) {
                    String obj2 = FourPlayNVRSportActivty.this.imageView2.getTag().toString();
                    if (!obj2.equalsIgnoreCase("1")) {
                        NativeCaller.StopPPPPLivestream(obj2);
                        boolean unused2 = FourPlayNVRSportActivty.this.ssidTag2 = false;
                    }
                    FourPlayNVRSportActivty.this.imageButton2.setVisibility(0);
                    FourPlayNVRSportActivty.this.imageButton2.setTag(1);
                    FourPlayNVRSportActivty.this.imageButton2.setBackgroundResource(SystemValue.FourStopBg);
                } else if (access$1900 == 3) {
                    String obj3 = FourPlayNVRSportActivty.this.imageView3.getTag().toString();
                    if (!obj3.equalsIgnoreCase("1")) {
                        NativeCaller.StopPPPPLivestream(obj3);
                        boolean unused3 = FourPlayNVRSportActivty.this.ssidTag3 = false;
                    }
                    FourPlayNVRSportActivty.this.imageButton3.setVisibility(0);
                    FourPlayNVRSportActivty.this.imageButton3.setTag(1);
                    FourPlayNVRSportActivty.this.imageButton3.setBackgroundResource(SystemValue.FourStopBg);
                } else if (access$1900 == 4) {
                    String obj4 = FourPlayNVRSportActivty.this.imageView4.getTag().toString();
                    if (!obj4.equalsIgnoreCase("1")) {
                        NativeCaller.StopPPPPLivestream(obj4);
                        boolean unused4 = FourPlayNVRSportActivty.this.ssidTag4 = false;
                    }
                    FourPlayNVRSportActivty.this.imageButton4.setVisibility(0);
                    FourPlayNVRSportActivty.this.imageButton4.setTag(1);
                    FourPlayNVRSportActivty.this.imageButton4.setBackgroundResource(SystemValue.FourStopBg);
                }
                FourPlayNVRSportActivty.this.popupWindow_about.dismiss();
            }
        });
        ((Button) inflate.findViewById(R.id.add_check_phone)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SharedPreferences.Editor edit = FourPlayNVRSportActivty.this.preFourPlay.edit();
                int access$1900 = FourPlayNVRSportActivty.this.TAGPlay;
                if (access$1900 == 1) {
                    NativeCaller.StopPPPPLivestream(FourPlayNVRSportActivty.this.imageView1.getTag().toString());
                    boolean unused = FourPlayNVRSportActivty.this.ssidTag1 = false;
                    FourPlayNVRSportActivty.this.strDidList.remove(FourPlayNVRSportActivty.this.strDidList.indexOf(FourPlayNVRSportActivty.this.imageView1.getTag().toString()));
                    edit.putString(ContentCommon.PLAY_FOUR_ONE, "");
                    FourPlayNVRSportActivty.this.imageView1.setTag(1);
                    FourPlayNVRSportActivty.this.textView1.setVisibility(8);
                    new AsyncTask<Void, Void, Void>() {
                        /* access modifiers changed from: protected */
                        public Void doInBackground(Void... voidArr) {
                            try {
                                Thread.sleep(2000);
                                return null;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                return null;
                            }
                        }

                        /* access modifiers changed from: protected */
                        public void onPostExecute(Void voidR) {
                            super.onPostExecute(voidR);
                            FourPlayNVRSportActivty.this.imageButton1.setVisibility(0);
                            FourPlayNVRSportActivty.this.imageButton1.setTag(0);
                            FourPlayNVRSportActivty.this.imageButton1.setBackgroundResource(SystemValue.FourAddBg);
                            FourPlayNVRSportActivty.this.imageView1.setImageBitmap(FourPlayNVRSportActivty.this.bitmap_defult);
                        }
                    }.execute(new Void[0]);
                } else if (access$1900 == 2) {
                    NativeCaller.StopPPPPLivestream(FourPlayNVRSportActivty.this.imageView2.getTag().toString());
                    boolean unused2 = FourPlayNVRSportActivty.this.ssidTag2 = false;
                    FourPlayNVRSportActivty.this.strDidList.remove(FourPlayNVRSportActivty.this.strDidList.indexOf(FourPlayNVRSportActivty.this.imageView2.getTag().toString()));
                    edit.putString(ContentCommon.PLAY_FOUR_TWO, "");
                    FourPlayNVRSportActivty.this.imageView2.setTag(1);
                    FourPlayNVRSportActivty.this.textView2.setVisibility(8);
                    new AsyncTask<Void, Void, Void>() {
                        /* access modifiers changed from: protected */
                        public Void doInBackground(Void... voidArr) {
                            try {
                                Thread.sleep(2000);
                                return null;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                return null;
                            }
                        }

                        /* access modifiers changed from: protected */
                        public void onPostExecute(Void voidR) {
                            super.onPostExecute(voidR);
                            FourPlayNVRSportActivty.this.imageButton2.setVisibility(0);
                            FourPlayNVRSportActivty.this.imageButton2.setTag(0);
                            FourPlayNVRSportActivty.this.imageButton2.setBackgroundResource(SystemValue.FourAddBg);
                            FourPlayNVRSportActivty.this.imageView2.setImageBitmap(FourPlayNVRSportActivty.this.bitmap_defult);
                        }
                    }.execute(new Void[0]);
                } else if (access$1900 == 3) {
                    NativeCaller.StopPPPPLivestream(FourPlayNVRSportActivty.this.imageView3.getTag().toString());
                    boolean unused3 = FourPlayNVRSportActivty.this.ssidTag3 = false;
                    FourPlayNVRSportActivty.this.strDidList.remove(FourPlayNVRSportActivty.this.strDidList.indexOf(FourPlayNVRSportActivty.this.imageView3.getTag().toString()));
                    edit.putString(ContentCommon.PLAY_FOUR_THREE, "");
                    FourPlayNVRSportActivty.this.imageView3.setTag(1);
                    FourPlayNVRSportActivty.this.textView3.setVisibility(8);
                    new AsyncTask<Void, Void, Void>() {
                        /* access modifiers changed from: protected */
                        public Void doInBackground(Void... voidArr) {
                            try {
                                Thread.sleep(2000);
                                return null;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                return null;
                            }
                        }

                        /* access modifiers changed from: protected */
                        public void onPostExecute(Void voidR) {
                            super.onPostExecute(voidR);
                            FourPlayNVRSportActivty.this.imageButton3.setVisibility(0);
                            FourPlayNVRSportActivty.this.imageButton3.setTag(0);
                            FourPlayNVRSportActivty.this.imageButton3.setBackgroundResource(SystemValue.FourAddBg);
                            FourPlayNVRSportActivty.this.imageView3.setImageBitmap(FourPlayNVRSportActivty.this.bitmap_defult);
                        }
                    }.execute(new Void[0]);
                } else if (access$1900 == 4) {
                    NativeCaller.StopPPPPLivestream(FourPlayNVRSportActivty.this.imageView4.getTag().toString());
                    boolean unused4 = FourPlayNVRSportActivty.this.ssidTag4 = false;
                    FourPlayNVRSportActivty.this.strDidList.remove(FourPlayNVRSportActivty.this.strDidList.indexOf(FourPlayNVRSportActivty.this.imageView4.getTag().toString()));
                    edit.putString(ContentCommon.PLAY_FOUR_FOUR, "");
                    FourPlayNVRSportActivty.this.imageView4.setTag(1);
                    FourPlayNVRSportActivty.this.textView4.setVisibility(8);
                    new AsyncTask<Void, Void, Void>() {
                        /* access modifiers changed from: protected */
                        public Void doInBackground(Void... voidArr) {
                            try {
                                Thread.sleep(2000);
                                return null;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                return null;
                            }
                        }

                        /* access modifiers changed from: protected */
                        public void onPostExecute(Void voidR) {
                            super.onPostExecute(voidR);
                            FourPlayNVRSportActivty.this.imageButton4.setVisibility(0);
                            FourPlayNVRSportActivty.this.imageButton4.setTag(0);
                            FourPlayNVRSportActivty.this.imageButton4.setBackgroundResource(SystemValue.FourAddBg);
                            FourPlayNVRSportActivty.this.imageView4.setImageBitmap(FourPlayNVRSportActivty.this.bitmap_defult);
                        }
                    }.execute(new Void[0]);
                }
                edit.commit();
                FourPlayNVRSportActivty.access$210(FourPlayNVRSportActivty.this);
                FourPlayNVRSportActivty.this.popupWindow_about.dismiss();
            }
        });
        this.popupWindow_about.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                FourPlayNVRSportActivty.this.popupWindow_about.dismiss();
            }
        });
        this.popupWindow_about.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                FourPlayNVRSportActivty.this.popupWindow_about.dismiss();
                return false;
            }
        });
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.button_cut) {
            switch (id) {
                case R.id.imageView1:
                    if (this.imageView1.getTag().toString().equalsIgnoreCase("1")) {
                        return;
                    }
                    if (System.currentTimeMillis() - this.exitTime > 2000) {
                        this.exitTime = System.currentTimeMillis();
                        return;
                    }
                    this.isFullPlay = true;
                    new AsyncTask<Void, Void, Void>() {
                        /* access modifiers changed from: protected */
                        public void onPreExecute() {
                            FourPlayNVRSportActivty fourPlayNVRSportActivty = FourPlayNVRSportActivty.this;
                            Intent unused = fourPlayNVRSportActivty.in = new Intent(fourPlayNVRSportActivty, NDNCameraLiveActivity.class);
                            FourPlayNVRSportActivty.this.in.putExtra("play_four_tag", 1);
                            FourPlayNVRSportActivty.this.in.putExtra(ContentCommon.STR_CAMERA_TYPE, 1);
                            FourPlayNVRSportActivty.this.in.putExtra(ContentCommon.STR_STREAM_TYPE, 3);
                            FourPlayNVRSportActivty.this.in.putExtra(ContentCommon.STR_CAMERA_NAME, FourPlayNVRSportActivty.this.name1);
                            FourPlayNVRSportActivty.this.in.putExtra(ContentCommon.STR_CAMERA_ID, FourPlayNVRSportActivty.this.imageView1.getTag().toString());
                        }

                        /* access modifiers changed from: protected */
                        public Void doInBackground(Void... voidArr) {
                            for (int i = 0; i < FourPlayNVRSportActivty.this.strDidList.size(); i++) {
                                if (!((String) FourPlayNVRSportActivty.this.strDidList.get(i)).endsWith(FourPlayNVRSportActivty.this.imageView1.getTag().toString())) {
                                    NativeCaller.StopPPPPLivestream((String) FourPlayNVRSportActivty.this.strDidList.get(i));
                                    try {
                                        Thread.sleep(300);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            return null;
                        }

                        /* access modifiers changed from: protected */
                        public void onPostExecute(Void voidR) {
                            boolean unused = FourPlayNVRSportActivty.this.PlayTag = false;
                            FourPlayNVRSportActivty fourPlayNVRSportActivty = FourPlayNVRSportActivty.this;
                            fourPlayNVRSportActivty.startActivityForResult(fourPlayNVRSportActivty.in, 2);
                            FourPlayNVRSportActivty.this.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                        }
                    }.execute(new Void[0]);
                    return;
                case R.id.imageView2:
                    if (this.imageView2.getTag().toString().equalsIgnoreCase("1")) {
                        return;
                    }
                    if (System.currentTimeMillis() - this.exitTime > 2000) {
                        this.exitTime = System.currentTimeMillis();
                        return;
                    }
                    this.isFullPlay = true;
                    new AsyncTask<Void, Void, Void>() {
                        /* access modifiers changed from: protected */
                        public void onPreExecute() {
                            FourPlayNVRSportActivty fourPlayNVRSportActivty = FourPlayNVRSportActivty.this;
                            Intent unused = fourPlayNVRSportActivty.in = new Intent(fourPlayNVRSportActivty, NDNCameraLiveActivity.class);
                            FourPlayNVRSportActivty.this.in.putExtra("play_four_tag", 1);
                            FourPlayNVRSportActivty.this.in.putExtra(ContentCommon.STR_CAMERA_TYPE, 1);
                            FourPlayNVRSportActivty.this.in.putExtra(ContentCommon.STR_STREAM_TYPE, 3);
                            FourPlayNVRSportActivty.this.in.putExtra(ContentCommon.STR_CAMERA_NAME, FourPlayNVRSportActivty.this.name2);
                            FourPlayNVRSportActivty.this.in.putExtra(ContentCommon.STR_CAMERA_ID, FourPlayNVRSportActivty.this.imageView2.getTag().toString());
                        }

                        /* access modifiers changed from: protected */
                        public Void doInBackground(Void... voidArr) {
                            for (int i = 0; i < FourPlayNVRSportActivty.this.strDidList.size(); i++) {
                                if (!((String) FourPlayNVRSportActivty.this.strDidList.get(i)).endsWith(FourPlayNVRSportActivty.this.imageView2.getTag().toString())) {
                                    NativeCaller.StopPPPPLivestream((String) FourPlayNVRSportActivty.this.strDidList.get(i));
                                    try {
                                        Thread.sleep(300);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            return null;
                        }

                        /* access modifiers changed from: protected */
                        public void onPostExecute(Void voidR) {
                            boolean unused = FourPlayNVRSportActivty.this.PlayTag = false;
                            FourPlayNVRSportActivty fourPlayNVRSportActivty = FourPlayNVRSportActivty.this;
                            fourPlayNVRSportActivty.startActivityForResult(fourPlayNVRSportActivty.in, 2);
                            FourPlayNVRSportActivty.this.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                        }
                    }.execute(new Void[0]);
                    return;
                case R.id.imageView3:
                    if (this.imageView3.getTag().toString().equalsIgnoreCase("1")) {
                        return;
                    }
                    if (System.currentTimeMillis() - this.exitTime > 2000) {
                        this.exitTime = System.currentTimeMillis();
                        return;
                    }
                    this.isFullPlay = true;
                    new AsyncTask<Void, Void, Void>() {
                        /* access modifiers changed from: protected */
                        public void onPreExecute() {
                            FourPlayNVRSportActivty fourPlayNVRSportActivty = FourPlayNVRSportActivty.this;
                            Intent unused = fourPlayNVRSportActivty.in = new Intent(fourPlayNVRSportActivty, NDNCameraLiveActivity.class);
                            FourPlayNVRSportActivty.this.in.putExtra("play_four_tag", 1);
                            FourPlayNVRSportActivty.this.in.putExtra(ContentCommon.STR_CAMERA_TYPE, 1);
                            FourPlayNVRSportActivty.this.in.putExtra(ContentCommon.STR_STREAM_TYPE, 3);
                            FourPlayNVRSportActivty.this.in.putExtra(ContentCommon.STR_CAMERA_NAME, FourPlayNVRSportActivty.this.name3);
                            FourPlayNVRSportActivty.this.in.putExtra(ContentCommon.STR_CAMERA_ID, FourPlayNVRSportActivty.this.imageView3.getTag().toString());
                        }

                        /* access modifiers changed from: protected */
                        public Void doInBackground(Void... voidArr) {
                            for (int i = 0; i < FourPlayNVRSportActivty.this.strDidList.size(); i++) {
                                if (!((String) FourPlayNVRSportActivty.this.strDidList.get(i)).endsWith(FourPlayNVRSportActivty.this.imageView3.getTag().toString())) {
                                    NativeCaller.StopPPPPLivestream((String) FourPlayNVRSportActivty.this.strDidList.get(i));
                                    try {
                                        Thread.sleep(300);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            return null;
                        }

                        /* access modifiers changed from: protected */
                        public void onPostExecute(Void voidR) {
                            boolean unused = FourPlayNVRSportActivty.this.PlayTag = false;
                            FourPlayNVRSportActivty fourPlayNVRSportActivty = FourPlayNVRSportActivty.this;
                            fourPlayNVRSportActivty.startActivityForResult(fourPlayNVRSportActivty.in, 2);
                            FourPlayNVRSportActivty.this.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                        }
                    }.execute(new Void[0]);
                    return;
                case R.id.imageView4:
                    if (this.imageView4.getTag().toString().equalsIgnoreCase("1")) {
                        return;
                    }
                    if (System.currentTimeMillis() - this.exitTime > 2000) {
                        this.exitTime = System.currentTimeMillis();
                        return;
                    }
                    this.isFullPlay = true;
                    new AsyncTask<Void, Void, Void>() {
                        /* access modifiers changed from: protected */
                        public void onPreExecute() {
                            FourPlayNVRSportActivty fourPlayNVRSportActivty = FourPlayNVRSportActivty.this;
                            Intent unused = fourPlayNVRSportActivty.in = new Intent(fourPlayNVRSportActivty, NDNCameraLiveActivity.class);
                            FourPlayNVRSportActivty.this.in.putExtra("play_four_tag", 1);
                            FourPlayNVRSportActivty.this.in.putExtra(ContentCommon.STR_CAMERA_TYPE, 1);
                            FourPlayNVRSportActivty.this.in.putExtra(ContentCommon.STR_STREAM_TYPE, 3);
                            FourPlayNVRSportActivty.this.in.putExtra(ContentCommon.STR_CAMERA_NAME, FourPlayNVRSportActivty.this.name4);
                            FourPlayNVRSportActivty.this.in.putExtra(ContentCommon.STR_CAMERA_ID, FourPlayNVRSportActivty.this.imageView4.getTag().toString());
                        }

                        /* access modifiers changed from: protected */
                        public Void doInBackground(Void... voidArr) {
                            for (int i = 0; i < FourPlayNVRSportActivty.this.strDidList.size(); i++) {
                                if (!((String) FourPlayNVRSportActivty.this.strDidList.get(i)).endsWith(FourPlayNVRSportActivty.this.imageView4.getTag().toString())) {
                                    NativeCaller.StopPPPPLivestream((String) FourPlayNVRSportActivty.this.strDidList.get(i));
                                    try {
                                        Thread.sleep(300);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            return null;
                        }

                        /* access modifiers changed from: protected */
                        public void onPostExecute(Void voidR) {
                            boolean unused = FourPlayNVRSportActivty.this.PlayTag = false;
                            FourPlayNVRSportActivty fourPlayNVRSportActivty = FourPlayNVRSportActivty.this;
                            fourPlayNVRSportActivty.startActivityForResult(fourPlayNVRSportActivty.in, 2);
                            FourPlayNVRSportActivty.this.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                        }
                    }.execute(new Void[0]);
                    return;
                default:
                    switch (id) {
                        case R.id.imagebutton1:
                            this.ConnectTag = 1;
                            this.cameraSelectAdapter.notifyDataSetChanged();
                            if (this.imageButton1.getTag().toString().equals("1") && !this.imageView1.getTag().toString().equals("1")) {
                                NativeCaller.StartPPPPLivestream(this.imageView1.getTag().toString(), 2);
                                this.ssidTag1 = true;
                                new MyImage1Threak().start();
                                this.imageButton1.setVisibility(8);
                                return;
                            } else if (SystemValue.arrayList.size() == 0) {
                                showToast((int) R.string.four_play_no_show);
                                return;
                            } else {
                                PopupWindow popupWindow = this.popupWindow_List;
                                if (popupWindow != null) {
                                    popupWindow.showAtLocation(this.imageButton1, 17, 0, 0);
                                    return;
                                }
                                return;
                            }
                        case R.id.imagebutton2:
                            this.ConnectTag = 2;
                            this.cameraSelectAdapter.notifyDataSetChanged();
                            if (this.imageButton2.getTag().toString().equals("1") && !this.imageView2.getTag().toString().equals("1")) {
                                NativeCaller.StartPPPPLivestream(this.imageView1.getTag().toString(), 2);
                                this.ssidTag2 = true;
                                new MyImage2Threak().start();
                                this.imageButton2.setVisibility(8);
                                return;
                            } else if (SystemValue.arrayList.size() == 0) {
                                showToast((int) R.string.four_play_no_show);
                                return;
                            } else {
                                PopupWindow popupWindow2 = this.popupWindow_List;
                                if (popupWindow2 != null) {
                                    popupWindow2.showAtLocation(this.imageButton1, 17, 0, 0);
                                    return;
                                }
                                return;
                            }
                        case R.id.imagebutton3:
                            this.ConnectTag = 3;
                            this.cameraSelectAdapter.notifyDataSetChanged();
                            if (this.imageButton3.getTag().toString().equals("1") && !this.imageView3.getTag().toString().equals("1")) {
                                NativeCaller.StartPPPPLivestream(this.imageView3.getTag().toString(), 2);
                                this.ssidTag3 = true;
                                new MyImage3Threak().start();
                                this.imageButton3.setVisibility(8);
                                return;
                            } else if (SystemValue.arrayList.size() == 0) {
                                showToast((int) R.string.four_play_no_show);
                                return;
                            } else {
                                PopupWindow popupWindow3 = this.popupWindow_List;
                                if (popupWindow3 != null) {
                                    popupWindow3.showAtLocation(this.imageButton1, 17, 0, 0);
                                    return;
                                }
                                return;
                            }
                        case R.id.imagebutton4:
                            this.ConnectTag = 4;
                            this.cameraSelectAdapter.notifyDataSetChanged();
                            if (this.imageButton4.getTag().toString().equals("1") && !this.imageView4.getTag().toString().equals("1")) {
                                NativeCaller.StartPPPPLivestream(this.imageView4.getTag().toString(), 2);
                                this.ssidTag4 = true;
                                new MyImage4Threak().start();
                                this.imageButton4.setVisibility(8);
                                return;
                            } else if (SystemValue.arrayList.size() == 0) {
                                showToast((int) R.string.four_play_no_show);
                                return;
                            } else {
                                PopupWindow popupWindow4 = this.popupWindow_List;
                                if (popupWindow4 != null) {
                                    popupWindow4.showAtLocation(this.imageButton1, 17, 0, 0);
                                    return;
                                }
                                return;
                            }
                        case R.id.imagebutton_hind:
                            if (this.ifHind) {
                                this.imageButton_hind.setImageResource(R.mipmap.hind_buttong_bg1);
                                this.ifHind = false;
                                return;
                            }
                            this.imageButton_hind.setImageResource(R.mipmap.hind_buttong_bg);
                            this.ifHind = true;
                            return;
                        default:
                            return;
                    }
            }
        } else {
            int i = this.CutCount;
            if (i == 4) {
                this.CutCount = 3;
                this.frameLayout4.setVisibility(8);
                int applyDimension = (int) TypedValue.applyDimension(1, 250.0f, getResources().getDisplayMetrics());
                CommonUtil.Log(1, "px:" + applyDimension);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.linear_four_two.getLayoutParams();
                layoutParams.height = applyDimension;
                this.linear_four_two.setLayoutParams(layoutParams);
                this.button_cut.setText("3+");
            } else if (i == 3) {
                this.CutCount = 2;
                this.frameLayout4.setVisibility(8);
                this.frameLayout2.setVisibility(8);
                int applyDimension2 = (int) TypedValue.applyDimension(1, 250.0f, getResources().getDisplayMetrics());
                CommonUtil.Log(1, "px:" + applyDimension2);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.linear_four_one.getLayoutParams();
                layoutParams2.height = applyDimension2;
                this.linear_four_one.setLayoutParams(layoutParams2);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.linear_four_two.getLayoutParams();
                layoutParams3.height = applyDimension2;
                this.linear_four_two.setLayoutParams(layoutParams3);
                this.button_cut.setText("2+");
            } else if (i == 2) {
                this.CutCount = 4;
                this.frameLayout4.setVisibility(0);
                this.frameLayout2.setVisibility(0);
                int applyDimension3 = (int) TypedValue.applyDimension(1, 150.0f, getResources().getDisplayMetrics());
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.linear_four_one.getLayoutParams();
                layoutParams4.height = applyDimension3;
                this.linear_four_one.setLayoutParams(layoutParams4);
                LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.linear_four_two.getLayoutParams();
                layoutParams5.height = applyDimension3;
                this.linear_four_two.setLayoutParams(layoutParams5);
                this.button_cut.setText("4+");
            } else {
                this.CutCount = 4;
                this.frameLayout4.setVisibility(0);
                this.frameLayout2.setVisibility(0);
                int applyDimension4 = (int) TypedValue.applyDimension(1, 150.0f, getResources().getDisplayMetrics());
                LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.linear_four_one.getLayoutParams();
                layoutParams6.height = applyDimension4;
                this.linear_four_one.setLayoutParams(layoutParams6);
                LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) this.linear_four_two.getLayoutParams();
                layoutParams7.height = applyDimension4;
                this.linear_four_two.setLayoutParams(layoutParams7);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2 && i2 == 2) {
            showPlayLastBmp(intent.getStringExtra(STR_DID));
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (ContentCommon.ISVISI.booleanValue()) {
                CommonUtil.Vibrate(this, 10);
            }
            finish();
            return true;
        } else if (i != 82) {
            return super.onKeyDown(i, keyEvent);
        } else {
            sendBroadcast(new Intent(ContentCommon.MAIN_KEY_MENU));
            return true;
        }
    }

    public void showSureDialogF() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.app1);
        builder.setTitle(returnString(R.string.play_four_exit1));
        builder.setMessage(R.string.play_four_exit2);
        builder.setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                FourPlayNVRSportActivty.this.finish();
            }
        });
        builder.setNegativeButton(R.string.str_cancel, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        this.preDid1 = this.preFourPlay.getString(ContentCommon.PLAY_FOUR_ONE, "");
        this.preDid2 = this.preFourPlay.getString(ContentCommon.PLAY_FOUR_TWO, "");
        this.preDid3 = this.preFourPlay.getString(ContentCommon.PLAY_FOUR_THREE, "");
        this.preDid4 = this.preFourPlay.getString(ContentCommon.PLAY_FOUR_FOUR, "");
        String str = this.preDid1;
        if (str == null || str.length() <= 8) {
            this.imageView1.setImageBitmap(this.bitmap_defult);
            SharedPreferences.Editor edit = this.preFourPlay.edit();
            edit.putString(ContentCommon.PLAY_FOUR_ONE, "");
            edit.commit();
            this.imageView1.setTag(1);
            this.textView1.setVisibility(8);
        } else {
            CameraParamsBean returnCameraBean = returnCameraBean(this.preDid1);
            if (returnCameraBean != null) {
                this.imageView1.setTag(returnCameraBean.getDev_Did());
                if (!this.strDidList.contains(returnCameraBean.getDev_Did())) {
                    this.strDidList.add(returnCameraBean.getDev_Did());
                }
                this.name1 = returnCameraBean.getDev_name();
                this.textView1.setText(this.name1);
                this.textView1.setVisibility(0);
            } else {
                this.imageView1.setImageBitmap(this.bitmap_defult);
                SharedPreferences.Editor edit2 = this.preFourPlay.edit();
                edit2.putString(ContentCommon.PLAY_FOUR_ONE, "");
                edit2.commit();
                this.imageView1.setTag(1);
                this.textView1.setVisibility(8);
            }
        }
        String str2 = this.preDid2;
        if (str2 == null || str2.length() <= 8) {
            this.imageView2.setImageBitmap(this.bitmap_defult);
            SharedPreferences.Editor edit3 = this.preFourPlay.edit();
            edit3.putString(ContentCommon.PLAY_FOUR_TWO, "");
            edit3.commit();
            this.imageView2.setTag(1);
            this.textView2.setVisibility(8);
        } else {
            CameraParamsBean returnCameraBean2 = returnCameraBean(this.preDid2);
            if (returnCameraBean2 != null) {
                this.imageView2.setTag(returnCameraBean2.getDev_Did());
                if (!this.strDidList.contains(returnCameraBean2.getDev_Did())) {
                    this.strDidList.add(returnCameraBean2.getDev_Did());
                }
                this.name2 = returnCameraBean2.getDev_name();
                this.textView2.setText(this.name2);
                this.textView2.setVisibility(0);
            } else {
                this.imageView2.setImageBitmap(this.bitmap_defult);
                SharedPreferences.Editor edit4 = this.preFourPlay.edit();
                edit4.putString(ContentCommon.PLAY_FOUR_TWO, "");
                edit4.commit();
                this.imageView2.setTag(1);
                this.textView2.setVisibility(8);
            }
        }
        String str3 = this.preDid3;
        if (str3 == null || str3.length() <= 8) {
            this.imageView3.setImageBitmap(this.bitmap_defult);
            SharedPreferences.Editor edit5 = this.preFourPlay.edit();
            edit5.putString(ContentCommon.PLAY_FOUR_THREE, "");
            edit5.commit();
            this.imageView3.setTag(1);
            this.textView3.setVisibility(8);
        } else {
            CameraParamsBean returnCameraBean3 = returnCameraBean(this.preDid3);
            if (returnCameraBean3 != null) {
                this.imageView3.setTag(returnCameraBean3.getDev_Did());
                if (!this.strDidList.contains(returnCameraBean3.getDev_Did())) {
                    this.strDidList.add(returnCameraBean3.getDev_Did());
                }
                this.name3 = returnCameraBean3.getDev_name();
                this.textView3.setText(this.name3);
                this.textView3.setVisibility(0);
            } else {
                this.imageView3.setImageBitmap(this.bitmap_defult);
                SharedPreferences.Editor edit6 = this.preFourPlay.edit();
                edit6.putString(ContentCommon.PLAY_FOUR_THREE, "");
                edit6.commit();
                this.imageView3.setTag(1);
                this.textView3.setVisibility(8);
            }
        }
        String str4 = this.preDid4;
        if (str4 == null || str4.length() <= 8) {
            this.imageView4.setImageBitmap(this.bitmap_defult);
            SharedPreferences.Editor edit7 = this.preFourPlay.edit();
            edit7.putString(ContentCommon.PLAY_FOUR_FOUR, "");
            edit7.commit();
            this.imageView4.setTag(1);
            this.textView4.setVisibility(8);
        } else {
            CameraParamsBean returnCameraBean4 = returnCameraBean(this.preDid4);
            if (returnCameraBean4 != null) {
                this.imageView4.setTag(returnCameraBean4.getDev_Did());
                if (!this.strDidList.contains(returnCameraBean4.getDev_Did())) {
                    this.strDidList.add(returnCameraBean4.getDev_Did());
                }
                this.name4 = returnCameraBean4.getDev_name();
                this.textView4.setText(this.name4);
                this.textView4.setVisibility(0);
            } else {
                this.imageView4.setImageBitmap(this.bitmap_defult);
                SharedPreferences.Editor edit8 = this.preFourPlay.edit();
                edit8.putString(ContentCommon.PLAY_FOUR_FOUR, "");
                edit8.commit();
                this.imageView4.setTag(1);
                this.textView4.setVisibility(8);
            }
        }
        String obj = this.imageView1.getTag().toString();
        if (!obj.equalsIgnoreCase("1")) {
            NativeCaller.StopPPPPLivestream(obj);
            this.ssidTag1 = false;
            this.imageButton1.setVisibility(0);
            this.imageButton1.setTag(1);
            this.imageButton1.setBackgroundResource(SystemValue.FourStopBg);
        } else {
            this.ssidTag1 = false;
            this.imageButton1.setVisibility(0);
            this.imageButton1.setTag(0);
            this.imageButton1.setBackgroundResource(SystemValue.FourAddBg);
        }
        String obj2 = this.imageView2.getTag().toString();
        if (!obj2.equalsIgnoreCase("1")) {
            NativeCaller.StopPPPPLivestream(obj2);
            this.ssidTag2 = false;
            this.imageButton2.setVisibility(0);
            this.imageButton2.setTag(1);
            this.imageButton2.setBackgroundResource(SystemValue.FourStopBg);
        } else {
            this.imageButton2.setVisibility(0);
            this.imageButton2.setTag(0);
            this.imageButton2.setBackgroundResource(SystemValue.FourAddBg);
        }
        String obj3 = this.imageView3.getTag().toString();
        if (!obj3.equalsIgnoreCase("1")) {
            NativeCaller.StopPPPPLivestream(obj3);
            this.ssidTag3 = false;
            this.imageButton3.setVisibility(0);
            this.imageButton3.setTag(1);
            this.imageButton3.setBackgroundResource(SystemValue.FourStopBg);
        } else {
            this.imageButton3.setVisibility(0);
            this.imageButton3.setTag(0);
            this.imageButton3.setBackgroundResource(SystemValue.FourAddBg);
        }
        String obj4 = this.imageView4.getTag().toString();
        if (!obj4.equalsIgnoreCase("1")) {
            NativeCaller.StopPPPPLivestream(obj4);
            this.ssidTag4 = false;
            this.imageButton4.setVisibility(0);
            this.imageButton4.setTag(1);
            this.imageButton4.setBackgroundResource(SystemValue.FourStopBg);
        } else {
            this.imageButton4.setVisibility(0);
            this.imageButton4.setTag(0);
            this.imageButton4.setBackgroundResource(SystemValue.FourAddBg);
        }
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        CommonUtil.Log(1, "four_onStart");
        this.PlayTag = true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        CommonUtil.Log(1, "Four----onPause");
        if (!this.isFullPlay) {
            String obj = this.imageView1.getTag().toString();
            if (!obj.equalsIgnoreCase("1")) {
                NativeCaller.StopPPPPLivestream(obj);
                this.ssidTag1 = false;
                this.imageButton1.setVisibility(0);
                this.imageButton1.setTag(1);
                this.imageButton1.setBackgroundResource(SystemValue.FourStopBg);
            }
            String obj2 = this.imageView2.getTag().toString();
            if (!obj2.equalsIgnoreCase("1")) {
                NativeCaller.StopPPPPLivestream(obj2);
                this.ssidTag2 = false;
                this.imageButton2.setVisibility(0);
                this.imageButton2.setTag(1);
                this.imageButton2.setBackgroundResource(SystemValue.FourStopBg);
            }
            String obj3 = this.imageView3.getTag().toString();
            if (!obj3.equalsIgnoreCase("1")) {
                NativeCaller.StopPPPPLivestream(obj3);
                this.ssidTag3 = false;
                this.imageButton3.setVisibility(0);
                this.imageButton3.setTag(1);
                this.imageButton3.setBackgroundResource(SystemValue.FourStopBg);
            }
            String obj4 = this.imageView4.getTag().toString();
            if (!obj4.equalsIgnoreCase("1")) {
                NativeCaller.StopPPPPLivestream(obj4);
                this.ssidTag4 = false;
                this.imageButton4.setVisibility(0);
                this.imageButton4.setTag(1);
                this.imageButton4.setBackgroundResource(SystemValue.FourStopBg);
            }
        }
        this.isFullPlay = false;
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.ssidTag1 = false;
        this.ssidTag2 = false;
        this.ssidTag3 = false;
        this.ssidTag4 = false;
        this.ifImageTag1 = 0;
        this.ifImageTag2 = 0;
        this.ifImageTag3 = 0;
        this.ifImageTag4 = 0;
        for (int i = 0; i < this.strDidList.size(); i++) {
            NativeCaller.StopPPPPLivestream(this.strDidList.get(i));
        }
        this.strDidList.clear();
        String obj = this.imageView1.getTag().toString();
        if (!obj.equalsIgnoreCase("1")) {
            SharedPreferences.Editor edit = this.preFourPlay.edit();
            edit.putString(ContentCommon.PLAY_FOUR_ONE, obj);
            edit.commit();
        }
        String obj2 = this.imageView2.getTag().toString();
        if (!obj2.equalsIgnoreCase("1")) {
            SharedPreferences.Editor edit2 = this.preFourPlay.edit();
            edit2.putString(ContentCommon.PLAY_FOUR_TWO, obj2);
            edit2.commit();
        }
        String obj3 = this.imageView3.getTag().toString();
        if (!obj3.equalsIgnoreCase("1")) {
            SharedPreferences.Editor edit3 = this.preFourPlay.edit();
            edit3.putString(ContentCommon.PLAY_FOUR_THREE, obj3);
            edit3.commit();
        }
        String obj4 = this.imageView4.getTag().toString();
        if (!obj4.equalsIgnoreCase("1")) {
            SharedPreferences.Editor edit4 = this.preFourPlay.edit();
            edit4.putString(ContentCommon.PLAY_FOUR_FOUR, obj4);
            edit4.commit();
        }
        super.onDestroy();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.bean = SystemValue.arrayList.get(i);
        CameraParamsBean cameraParamsBean = this.bean;
        if (cameraParamsBean != null) {
            if ((cameraParamsBean.getDev_p2pstatus() == 2 && checkChina(this.bean.getDev_Did(), this.bean.getResetrict())) || this.bean.getDev_p2pstatus() != 2) {
                return;
            }
            if (this.strDidList.contains(this.bean.getDev_Did())) {
                showToast((int) R.string.play_four_connected);
                return;
            }
            PopupWindow popupWindow = this.popupWindow_List;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        }
    }

    public void BSCallBack_TYPEMODE(String str, String str2) {
        CommonUtil.Log(1, "BSCallBack_TYPEMODE:" + str);
        if (str.indexOf("_") > 0) {
            this.uiDid = str;
            runOnUiThread(new Runnable() {
                public void run() {
                    CommonUtil.Log(1, "四画面：" + FourPlayNVRSportActivty.this.uiDid + "  Mac:" + FourPlayNVRSportActivty.this.camerSum);
                    FourPlayNVRSportActivty fourPlayNVRSportActivty = FourPlayNVRSportActivty.this;
                    ImageView access$000 = fourPlayNVRSportActivty.imageView1;
                    ImageView access$600 = FourPlayNVRSportActivty.this.imageView2;
                    ImageView access$1000 = FourPlayNVRSportActivty.this.imageView3;
                    ImageView access$1400 = FourPlayNVRSportActivty.this.imageView4;
                    String str = FourPlayNVRSportActivty.this.uiDid;
                    fourPlayNVRSportActivty.imageSetTag(access$000, access$600, access$1000, access$1400, str, "AP:" + FourPlayNVRSportActivty.this.camerSum);
                }
            });
        }
    }

    class MyImage1Threak extends Thread {
        MyImage1Threak() {
        }

        public void run() {
            while (FourPlayNVRSportActivty.this.ssidTag1) {
                if (FourPlayNVRSportActivty.this.ifImageTag1 == 1) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        if (FourPlayNVRSportActivty.this.image1IsH264 == 0) {
                            FourPlayNVRSportActivty.this.bitmap11 = BitmapFactory.decodeByteArray(FourPlayNVRSportActivty.this.sufVideoBytes1, 0, FourPlayNVRSportActivty.this.sufVideoBytes1.length, FourPlayNVRSportActivty.this.options);
                        } else if (FourPlayNVRSportActivty.this.image1IsH264 == 1) {
                            byte[] bArr = new byte[(FourPlayNVRSportActivty.this.image1Width * FourPlayNVRSportActivty.this.image1Higth * 2)];
                            NativeCaller.YUV4202RGB565(FourPlayNVRSportActivty.this.sufVideoBytes1, bArr, FourPlayNVRSportActivty.this.image1Width, FourPlayNVRSportActivty.this.image1Higth);
                            ByteBuffer wrap = ByteBuffer.wrap(bArr);
                            FourPlayNVRSportActivty.this.bitmap11 = Bitmap.createBitmap(FourPlayNVRSportActivty.this.image1Width, FourPlayNVRSportActivty.this.image1Higth, Bitmap.Config.RGB_565);
                            FourPlayNVRSportActivty.this.bitmap11.copyPixelsFromBuffer(wrap);
                        }
                    } catch (OutOfMemoryError unused) {
                    }
                    if (FourPlayNVRSportActivty.this.bitmap11 == null) {
                        FourPlayNVRSportActivty fourPlayNVRSportActivty = FourPlayNVRSportActivty.this;
                        fourPlayNVRSportActivty.bitmap11 = fourPlayNVRSportActivty.bitmap_defult;
                    }
                    FourPlayNVRSportActivty fourPlayNVRSportActivty2 = FourPlayNVRSportActivty.this;
                    fourPlayNVRSportActivty2.bitmap11 = Bitmap.createScaledBitmap(fourPlayNVRSportActivty2.bitmap11, FourPlayNVRSportActivty.this.bitMapWidth, FourPlayNVRSportActivty.this.bitMapHight, true);
                    FourPlayNVRSportActivty.this.PPPPMsgHandler.sendEmptyMessage(IronSourceConstants.RV_INSTANCE_LOAD_NO_FILL);
                }
            }
            super.run();
        }
    }

    class MyImage2Threak extends Thread {
        MyImage2Threak() {
        }

        public void run() {
            while (FourPlayNVRSportActivty.this.ssidTag2) {
                if (FourPlayNVRSportActivty.this.ifImageTag2 == 1) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        if (FourPlayNVRSportActivty.this.image2IsH264 == 0) {
                            FourPlayNVRSportActivty.this.bitmap22 = BitmapFactory.decodeByteArray(FourPlayNVRSportActivty.this.sufVideoBytes2, 0, FourPlayNVRSportActivty.this.sufVideoBytes2.length, FourPlayNVRSportActivty.this.options);
                        } else if (FourPlayNVRSportActivty.this.image2IsH264 == 1) {
                            byte[] bArr = new byte[(FourPlayNVRSportActivty.this.image2Width * FourPlayNVRSportActivty.this.image2Higth * 2)];
                            NativeCaller.YUV4202RGB565(FourPlayNVRSportActivty.this.sufVideoBytes2, bArr, FourPlayNVRSportActivty.this.image2Width, FourPlayNVRSportActivty.this.image2Higth);
                            ByteBuffer wrap = ByteBuffer.wrap(bArr);
                            FourPlayNVRSportActivty.this.bitmap22 = Bitmap.createBitmap(FourPlayNVRSportActivty.this.image2Width, FourPlayNVRSportActivty.this.image2Higth, Bitmap.Config.RGB_565);
                            FourPlayNVRSportActivty.this.bitmap22.copyPixelsFromBuffer(wrap);
                        }
                    } catch (OutOfMemoryError unused) {
                    }
                    if (FourPlayNVRSportActivty.this.bitmap22 == null) {
                        FourPlayNVRSportActivty fourPlayNVRSportActivty = FourPlayNVRSportActivty.this;
                        fourPlayNVRSportActivty.bitmap22 = fourPlayNVRSportActivty.bitmap_defult;
                    }
                    FourPlayNVRSportActivty fourPlayNVRSportActivty2 = FourPlayNVRSportActivty.this;
                    fourPlayNVRSportActivty2.bitmap22 = Bitmap.createScaledBitmap(fourPlayNVRSportActivty2.bitmap22, FourPlayNVRSportActivty.this.bitMapWidth, FourPlayNVRSportActivty.this.bitMapHight, true);
                    FourPlayNVRSportActivty.this.PPPPMsgHandler.sendEmptyMessage(1214);
                }
            }
            super.run();
        }
    }

    class MyImage3Threak extends Thread {
        MyImage3Threak() {
        }

        public void run() {
            while (FourPlayNVRSportActivty.this.ssidTag3) {
                if (FourPlayNVRSportActivty.this.ifImageTag3 == 1) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        if (FourPlayNVRSportActivty.this.image3IsH264 == 0) {
                            FourPlayNVRSportActivty.this.bitmap33 = BitmapFactory.decodeByteArray(FourPlayNVRSportActivty.this.sufVideoBytes3, 0, FourPlayNVRSportActivty.this.sufVideoBytes3.length, FourPlayNVRSportActivty.this.options);
                        } else if (FourPlayNVRSportActivty.this.image3IsH264 == 1) {
                            byte[] bArr = new byte[(FourPlayNVRSportActivty.this.image3Width * FourPlayNVRSportActivty.this.image3Higth * 2)];
                            NativeCaller.YUV4202RGB565(FourPlayNVRSportActivty.this.sufVideoBytes3, bArr, FourPlayNVRSportActivty.this.image3Width, FourPlayNVRSportActivty.this.image3Higth);
                            ByteBuffer wrap = ByteBuffer.wrap(bArr);
                            FourPlayNVRSportActivty.this.bitmap33 = Bitmap.createBitmap(FourPlayNVRSportActivty.this.image3Width, FourPlayNVRSportActivty.this.image3Higth, Bitmap.Config.RGB_565);
                            FourPlayNVRSportActivty.this.bitmap33.copyPixelsFromBuffer(wrap);
                        }
                    } catch (OutOfMemoryError unused) {
                    }
                    if (FourPlayNVRSportActivty.this.bitmap33 == null) {
                        FourPlayNVRSportActivty fourPlayNVRSportActivty = FourPlayNVRSportActivty.this;
                        fourPlayNVRSportActivty.bitmap33 = fourPlayNVRSportActivty.bitmap_defult;
                    }
                    FourPlayNVRSportActivty fourPlayNVRSportActivty2 = FourPlayNVRSportActivty.this;
                    fourPlayNVRSportActivty2.bitmap33 = Bitmap.createScaledBitmap(fourPlayNVRSportActivty2.bitmap33, FourPlayNVRSportActivty.this.bitMapWidth, FourPlayNVRSportActivty.this.bitMapHight, true);
                    FourPlayNVRSportActivty.this.PPPPMsgHandler.sendEmptyMessage(1215);
                }
            }
            super.run();
        }
    }

    class MyImage4Threak extends Thread {
        MyImage4Threak() {
        }

        public void run() {
            while (FourPlayNVRSportActivty.this.ssidTag4) {
                if (FourPlayNVRSportActivty.this.ifImageTag4 == 1) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        if (FourPlayNVRSportActivty.this.image4IsH264 == 0) {
                            FourPlayNVRSportActivty.this.bitmap44 = BitmapFactory.decodeByteArray(FourPlayNVRSportActivty.this.sufVideoBytes4, 0, FourPlayNVRSportActivty.this.sufVideoBytes4.length, FourPlayNVRSportActivty.this.options);
                        } else if (FourPlayNVRSportActivty.this.image4IsH264 == 1) {
                            byte[] bArr = new byte[(FourPlayNVRSportActivty.this.image4Width * FourPlayNVRSportActivty.this.image4Higth * 2)];
                            NativeCaller.YUV4202RGB565(FourPlayNVRSportActivty.this.sufVideoBytes4, bArr, FourPlayNVRSportActivty.this.image4Width, FourPlayNVRSportActivty.this.image4Higth);
                            ByteBuffer wrap = ByteBuffer.wrap(bArr);
                            FourPlayNVRSportActivty.this.bitmap44 = Bitmap.createBitmap(FourPlayNVRSportActivty.this.image4Width, FourPlayNVRSportActivty.this.image4Higth, Bitmap.Config.RGB_565);
                            FourPlayNVRSportActivty.this.bitmap44.copyPixelsFromBuffer(wrap);
                        }
                    } catch (OutOfMemoryError unused) {
                    }
                    if (FourPlayNVRSportActivty.this.bitmap44 == null) {
                        FourPlayNVRSportActivty fourPlayNVRSportActivty = FourPlayNVRSportActivty.this;
                        fourPlayNVRSportActivty.bitmap44 = fourPlayNVRSportActivty.bitmap_defult;
                    }
                    FourPlayNVRSportActivty fourPlayNVRSportActivty2 = FourPlayNVRSportActivty.this;
                    fourPlayNVRSportActivty2.bitmap44 = Bitmap.createScaledBitmap(fourPlayNVRSportActivty2.bitmap44, FourPlayNVRSportActivty.this.bitMapWidth, FourPlayNVRSportActivty.this.bitMapHight, true);
                    FourPlayNVRSportActivty.this.PPPPMsgHandler.sendEmptyMessage(1216);
                }
            }
            super.run();
        }
    }

    /* access modifiers changed from: private */
    public void imageSetTag(ImageView imageView, ImageView imageView5, ImageView imageView6, ImageView imageView7, String str, String str2) {
        if (this.imageView1.getTag().toString().equalsIgnoreCase("1")) {
            this.imageButton1.setVisibility(8);
            this.imageView1.setTag(str);
            this.textView1.setVisibility(0);
            this.textView1.setText(str2);
            SharedPreferences.Editor edit = this.preFourPlay.edit();
            edit.putString(ContentCommon.PLAY_FOUR_ONE, this.imageView1.getTag().toString());
            edit.commit();
            this.name1 = str2;
            this.ssidTag1 = true;
            new MyImage1Threak().start();
            new Thread() {
                public void run() {
                    CommonUtil.Log(1, "四画面：开始请求视频：" + FourPlayNVRSportActivty.this.imageView1.getTag().toString());
                    NativeCaller.StartPPPPLivestream(FourPlayNVRSportActivty.this.imageView1.getTag().toString(), 2);
                }
            }.start();
        } else if (this.imageView2.getTag().toString().equalsIgnoreCase("1")) {
            this.imageButton2.setVisibility(8);
            this.imageView2.setTag(str);
            this.textView2.setVisibility(0);
            this.textView2.setText(str2);
            this.name2 = str2;
            SharedPreferences.Editor edit2 = this.preFourPlay.edit();
            edit2.putString(ContentCommon.PLAY_FOUR_TWO, this.imageView2.getTag().toString());
            edit2.commit();
            this.ssidTag2 = true;
            new MyImage2Threak().start();
            new Thread() {
                public void run() {
                    CommonUtil.Log(1, "四画面：开始请求视频：" + FourPlayNVRSportActivty.this.imageView2.getTag().toString());
                    NativeCaller.StartPPPPLivestream(FourPlayNVRSportActivty.this.imageView2.getTag().toString(), 2);
                }
            }.start();
        } else if (this.imageView3.getTag().toString().equalsIgnoreCase("1")) {
            this.imageButton3.setVisibility(8);
            this.imageView3.setTag(str);
            this.textView3.setVisibility(0);
            this.textView3.setText(str2);
            this.name3 = str2;
            this.ssidTag3 = true;
            SharedPreferences.Editor edit3 = this.preFourPlay.edit();
            edit3.putString(ContentCommon.PLAY_FOUR_THREE, this.imageView3.getTag().toString());
            edit3.commit();
            new MyImage3Threak().start();
            new Thread() {
                public void run() {
                    CommonUtil.Log(1, "四画面：开始请求视频：" + FourPlayNVRSportActivty.this.imageView3.getTag().toString());
                    NativeCaller.StartPPPPLivestream(FourPlayNVRSportActivty.this.imageView3.getTag().toString(), 2);
                }
            }.start();
        } else if (this.imageView4.getTag().toString().equalsIgnoreCase("1")) {
            this.imageButton4.setVisibility(8);
            this.imageView4.setTag(str);
            this.textView4.setVisibility(0);
            this.textView4.setText(str2);
            this.name4 = str2;
            this.ssidTag4 = true;
            SharedPreferences.Editor edit4 = this.preFourPlay.edit();
            edit4.putString(ContentCommon.PLAY_FOUR_FOUR, this.imageView4.getTag().toString());
            edit4.commit();
            new MyImage4Threak().start();
            new Thread() {
                public void run() {
                    CommonUtil.Log(1, "四画面：开始请求视频：" + FourPlayNVRSportActivty.this.imageView4.getTag().toString());
                    NativeCaller.StartPPPPLivestream(FourPlayNVRSportActivty.this.imageView4.getTag().toString(), 2);
                }
            }.start();
        }
    }

    public void callBaceVideoData(String str, byte[] bArr, int i, int i2, int i3, int i4) {
        if (!this.PlayTag) {
            return;
        }
        if (str.equalsIgnoreCase(this.imageView1.getTag().toString())) {
            this.sufVideoBytes1 = bArr;
            this.image1IsH264 = i;
            this.image1Width = i3;
            this.image1Higth = i4;
            this.ifImageTag1 = 1;
        } else if (str.equalsIgnoreCase(this.imageView2.getTag().toString())) {
            this.sufVideoBytes2 = bArr;
            this.image2IsH264 = i;
            this.image2Width = i3;
            this.image2Higth = i4;
            this.ifImageTag2 = 1;
        } else if (str.equalsIgnoreCase(this.imageView3.getTag().toString())) {
            this.sufVideoBytes3 = bArr;
            this.image3IsH264 = i;
            this.image3Width = i3;
            this.image3Higth = i4;
            this.ifImageTag3 = 1;
        } else if (str.equalsIgnoreCase(this.imageView4.getTag().toString())) {
            this.sufVideoBytes4 = bArr;
            this.image4IsH264 = i;
            this.image4Width = i3;
            this.image4Higth = i4;
            this.ifImageTag4 = 1;
        }
    }

    public void callBackMessageNotify(String str, int i, int i2) {
        Log.d("test_four", "MessageNotify did: " + str + " msgType: " + i + " param: " + i2);
        if (i == 0 && i2 != 2) {
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putString("no_line_did", str);
            message.what = 110;
            message.setData(bundle);
            this.noLineHandler.sendMessage(message);
        }
    }

    public boolean onLongClick(View view) {
        switch (view.getId()) {
            case R.id.imageView1:
                if (this.imageView1.getTag().toString().equalsIgnoreCase("1")) {
                    return false;
                }
                this.TAGPlay = 1;
                PopupWindow popupWindow = this.popupWindow_about;
                ImageView imageView = this.imageView1;
                popupWindow.showAsDropDown(imageView, (imageView.getWidth() / 2) - this.widthTest, -this.imageView1.getHeight());
                return false;
            case R.id.imageView2:
                if (this.imageView2.getTag().toString().equalsIgnoreCase("1")) {
                    return false;
                }
                this.TAGPlay = 2;
                PopupWindow popupWindow2 = this.popupWindow_about;
                ImageView imageView5 = this.imageView2;
                popupWindow2.showAsDropDown(imageView5, (imageView5.getWidth() / 2) - this.widthTest, -this.imageView2.getHeight());
                return false;
            case R.id.imageView3:
                if (this.imageView3.getTag().toString().equalsIgnoreCase("1")) {
                    return false;
                }
                this.TAGPlay = 3;
                PopupWindow popupWindow3 = this.popupWindow_about;
                ImageView imageView6 = this.imageView3;
                popupWindow3.showAsDropDown(imageView6, (imageView6.getWidth() / 2) - this.widthTest, -this.imageView3.getHeight());
                return false;
            case R.id.imageView4:
                if (this.imageView4.getTag().toString().equalsIgnoreCase("1")) {
                    return false;
                }
                this.TAGPlay = 4;
                PopupWindow popupWindow4 = this.popupWindow_about;
                ImageView imageView7 = this.imageView4;
                popupWindow4.showAsDropDown(imageView7, (imageView7.getWidth() / 2) - this.widthTest, -this.imageView4.getHeight());
                return false;
            default:
                return false;
        }
    }

    public void callbacMenuEnd() {
        if (!this.isFullPlay) {
            String obj = this.imageView1.getTag().toString();
            if (!obj.equalsIgnoreCase("1")) {
                NativeCaller.StopPPPPLivestream(obj);
                this.ssidTag1 = false;
                this.imageButton1.setVisibility(0);
                this.imageButton1.setTag(1);
                this.imageButton1.setBackgroundResource(SystemValue.FourStopBg);
            }
            String obj2 = this.imageView2.getTag().toString();
            if (!obj2.equalsIgnoreCase("1")) {
                NativeCaller.StopPPPPLivestream(obj2);
                this.ssidTag2 = false;
                this.imageButton2.setVisibility(0);
                this.imageButton2.setTag(1);
                this.imageButton2.setBackgroundResource(SystemValue.FourStopBg);
            }
            String obj3 = this.imageView3.getTag().toString();
            if (!obj3.equalsIgnoreCase("1")) {
                NativeCaller.StopPPPPLivestream(obj3);
                this.ssidTag3 = false;
                this.imageButton3.setVisibility(0);
                this.imageButton3.setTag(1);
                this.imageButton3.setBackgroundResource(SystemValue.FourStopBg);
            }
            String obj4 = this.imageView4.getTag().toString();
            if (!obj4.equalsIgnoreCase("1")) {
                NativeCaller.StopPPPPLivestream(obj4);
                this.ssidTag4 = false;
                this.imageButton4.setVisibility(0);
                this.imageButton4.setTag(1);
                this.imageButton4.setBackgroundResource(SystemValue.FourStopBg);
            }
        }
        this.isFullPlay = false;
    }
}
