package com.shix.shixipc.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.adapter.CameraListFourAdapter;
import com.shix.shixipc.bean.CameraParamsBean;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.SharedPreferencesUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import object.p2pipcam.nativecaller.NativeCaller;
import shix.cykj.camera.R;

public class IpcamClientActivityFourTest extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener, NUIMainActivity.IPPlayInterface, View.OnLongClickListener {
    private static final String STR_DID = "did";
    private static final String STR_MSG_PARAM = "msgparam";
    private static final String TAG = "IpcamClientActivity";
    private static int cameraStatus;
    private final int PLAYTAG1 = 1213;
    private final int PLAYTAG2 = 1214;
    private final int PLAYTAG3 = 1215;
    private final int PLAYTAG4 = 1216;
    /* access modifiers changed from: private */
    public Handler PPPPMsgHandler = new Handler() {
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            int i = data.getInt(IpcamClientActivityFourTest.STR_MSG_PARAM);
            int i2 = message.what;
            String string = data.getString(IpcamClientActivityFourTest.STR_DID);
            if (i2 == 0) {
                Intent intent = new Intent("camera_status_change");
                intent.putExtra(ContentCommon.STR_CAMERA_ID, string);
                intent.putExtra(ContentCommon.STR_PPPP_STATUS, i);
                IpcamClientActivityFourTest.this.sendBroadcast(intent);
                if (IpcamClientActivityFourTest.this.cameraListFourAdapter.UpdataCameraStatus(string, i)) {
                    IpcamClientActivityFourTest.this.cameraListFourAdapter.notifyDataSetChanged();
                    if (i == 5 || i == 3 || i == 6 || i == 7 || i == 8) {
                        NativeCaller.StopPPPP(string);
                    }
                }
            } else if (i2 == 1) {
            } else {
                if (i2 != 200) {
                    switch (i2) {
                        case 1213:
                            Log.d("taggg", "test---hangler");
                            IpcamClientActivityFourTest.this.imageView1.setImageBitmap(IpcamClientActivityFourTest.this.bitmap11);
                            IpcamClientActivityFourTest.this.connection_show1.setVisibility(8);
                            return;
                        case 1214:
                            IpcamClientActivityFourTest.this.imageView2.setImageBitmap(IpcamClientActivityFourTest.this.bitmap22);
                            IpcamClientActivityFourTest.this.connection_show2.setVisibility(8);
                            return;
                        case 1215:
                            IpcamClientActivityFourTest.this.imageView3.setImageBitmap(IpcamClientActivityFourTest.this.bitmap33);
                            IpcamClientActivityFourTest.this.connection_show3.setVisibility(8);
                            return;
                        case 1216:
                            IpcamClientActivityFourTest.this.imageView4.setImageBitmap(IpcamClientActivityFourTest.this.bitmap44);
                            IpcamClientActivityFourTest.this.connection_show4.setVisibility(8);
                            return;
                        default:
                            return;
                    }
                } else {
                    IpcamClientActivityFourTest.this.cameraListFourAdapter.notifyDataSetChanged();
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean PlayTag;
    private final int SLEEPTIME = 200;
    private final int SNAPSHOT = 200;
    /* access modifiers changed from: private */
    public int TAGPlay = 0;
    private CameraParamsBean bean;
    private int bitMapHight = 0;
    private int bitMapWidth = 0;
    Bitmap bitmap11;
    Bitmap bitmap22;
    Bitmap bitmap33;
    Bitmap bitmap44;
    /* access modifiers changed from: private */
    public Bitmap bitmap_defult;
    private int camerSum = 0;
    /* access modifiers changed from: private */
    public CameraListFourAdapter cameraListFourAdapter;
    private ListView cameraListView = null;
    /* access modifiers changed from: private */
    public int connectionTag1 = 3;
    /* access modifiers changed from: private */
    public int connectionTag2 = 3;
    /* access modifiers changed from: private */
    public int connectionTag3 = 3;
    /* access modifiers changed from: private */
    public int connectionTag4 = 3;
    /* access modifiers changed from: private */
    public LinearLayout connection_show1;
    /* access modifiers changed from: private */
    public LinearLayout connection_show2;
    /* access modifiers changed from: private */
    public LinearLayout connection_show3;
    /* access modifiers changed from: private */
    public LinearLayout connection_show4;
    /* access modifiers changed from: private */
    public boolean copyTag1 = true;
    /* access modifiers changed from: private */
    public boolean copyTag2 = true;
    /* access modifiers changed from: private */
    public boolean copyTag3 = true;
    /* access modifiers changed from: private */
    public boolean copyTag4 = true;
    private Dialog dlgExit;
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
    private boolean ifOver = true;
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
    private ImageButton imageButton_hind = null;
    /* access modifiers changed from: private */
    public int imageTag1 = 0;
    /* access modifiers changed from: private */
    public int imageTag2 = 0;
    /* access modifiers changed from: private */
    public int imageTag3 = 0;
    /* access modifiers changed from: private */
    public int imageTag4 = 0;
    /* access modifiers changed from: private */
    public ImageView imageView1;
    /* access modifiers changed from: private */
    public ImageView imageView2;
    /* access modifiers changed from: private */
    public ImageView imageView3;
    /* access modifiers changed from: private */
    public ImageView imageView4;
    /* access modifiers changed from: private */

    /* renamed from: in */
    public Intent f1541in;
    private LinearLayout linear;
    private Map<String, String> maps;
    private Matrix matrix;
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
    /* access modifiers changed from: private */
    public Handler noLineHandler = new Handler() {
        public void handleMessage(Message message) {
            String string = message.getData().getString("no_line_did");
            if (message.what == 110) {
                if (IpcamClientActivityFourTest.this.imageView1.getTag().toString().equals(string) && IpcamClientActivityFourTest.this.strDidList.size() != 0) {
                    IpcamClientActivityFourTest.access$210(IpcamClientActivityFourTest.this);
                    boolean unused = IpcamClientActivityFourTest.this.ssidTag1 = false;
                    IpcamClientActivityFourTest.this.strDidList.remove(IpcamClientActivityFourTest.this.strDidList.indexOf(IpcamClientActivityFourTest.this.imageView1.getTag().toString()));
                    IpcamClientActivityFourTest.this.connection_show1.setVisibility(8);
                    IpcamClientActivityFourTest.this.imageView1.setTag(1);
                    IpcamClientActivityFourTest.this.textView1.setVisibility(8);
                    int unused2 = IpcamClientActivityFourTest.this.imageTag1 = 0;
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
                            IpcamClientActivityFourTest.this.imageView1.setImageBitmap(IpcamClientActivityFourTest.this.bitmap_defult);
                            int unused = IpcamClientActivityFourTest.this.connectionTag1 = 1;
                            IpcamClientActivityFourTest ipcamClientActivityFourTest = IpcamClientActivityFourTest.this;
                            ipcamClientActivityFourTest.showToast(IpcamClientActivityFourTest.this.name1 + IpcamClientActivityFourTest.this.getResources().getString(R.string.pppp_status_disconnect));
                            if (IpcamClientActivityFourTest.this.popupWindow_about != null && IpcamClientActivityFourTest.this.popupWindow_about.isShowing()) {
                                IpcamClientActivityFourTest.this.popupWindow_about.dismiss();
                            }
                        }
                    }.execute(new Void[0]);
                } else if (IpcamClientActivityFourTest.this.imageView2.getTag().toString().equals(string) && IpcamClientActivityFourTest.this.strDidList.size() != 0) {
                    IpcamClientActivityFourTest.access$210(IpcamClientActivityFourTest.this);
                    boolean unused3 = IpcamClientActivityFourTest.this.ssidTag2 = false;
                    IpcamClientActivityFourTest.this.strDidList.remove(IpcamClientActivityFourTest.this.strDidList.indexOf(IpcamClientActivityFourTest.this.imageView2.getTag().toString()));
                    IpcamClientActivityFourTest.this.connection_show2.setVisibility(8);
                    IpcamClientActivityFourTest.this.imageView2.setTag(1);
                    IpcamClientActivityFourTest.this.textView2.setVisibility(8);
                    int unused4 = IpcamClientActivityFourTest.this.imageTag2 = 0;
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
                            IpcamClientActivityFourTest.this.imageView2.setImageBitmap(IpcamClientActivityFourTest.this.bitmap_defult);
                            int unused = IpcamClientActivityFourTest.this.connectionTag2 = 1;
                            IpcamClientActivityFourTest ipcamClientActivityFourTest = IpcamClientActivityFourTest.this;
                            ipcamClientActivityFourTest.showToast(IpcamClientActivityFourTest.this.name2 + IpcamClientActivityFourTest.this.getResources().getString(R.string.pppp_status_disconnect));
                            if (IpcamClientActivityFourTest.this.popupWindow_about != null && IpcamClientActivityFourTest.this.popupWindow_about.isShowing()) {
                                IpcamClientActivityFourTest.this.popupWindow_about.dismiss();
                            }
                        }
                    }.execute(new Void[0]);
                } else if (IpcamClientActivityFourTest.this.imageView3.getTag().toString().equals(string) && IpcamClientActivityFourTest.this.strDidList.size() != 0) {
                    IpcamClientActivityFourTest.access$210(IpcamClientActivityFourTest.this);
                    boolean unused5 = IpcamClientActivityFourTest.this.ssidTag3 = false;
                    IpcamClientActivityFourTest.this.strDidList.remove(IpcamClientActivityFourTest.this.strDidList.indexOf(IpcamClientActivityFourTest.this.imageView3.getTag().toString()));
                    IpcamClientActivityFourTest.this.imageView3.setTag(1);
                    IpcamClientActivityFourTest.this.textView3.setVisibility(8);
                    IpcamClientActivityFourTest.this.connection_show3.setVisibility(8);
                    int unused6 = IpcamClientActivityFourTest.this.imageTag3 = 0;
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
                            IpcamClientActivityFourTest.this.imageView3.setImageBitmap(IpcamClientActivityFourTest.this.bitmap_defult);
                            int unused = IpcamClientActivityFourTest.this.connectionTag3 = 1;
                            IpcamClientActivityFourTest ipcamClientActivityFourTest = IpcamClientActivityFourTest.this;
                            ipcamClientActivityFourTest.showToast(IpcamClientActivityFourTest.this.name3 + IpcamClientActivityFourTest.this.getResources().getString(R.string.pppp_status_disconnect));
                            if (IpcamClientActivityFourTest.this.popupWindow_about != null && IpcamClientActivityFourTest.this.popupWindow_about.isShowing()) {
                                IpcamClientActivityFourTest.this.popupWindow_about.dismiss();
                            }
                        }
                    }.execute(new Void[0]);
                } else if (IpcamClientActivityFourTest.this.imageView4.getTag().toString().equals(string) && IpcamClientActivityFourTest.this.strDidList.size() != 0) {
                    IpcamClientActivityFourTest.access$210(IpcamClientActivityFourTest.this);
                    boolean unused7 = IpcamClientActivityFourTest.this.ssidTag4 = false;
                    IpcamClientActivityFourTest.this.strDidList.remove(IpcamClientActivityFourTest.this.strDidList.indexOf(IpcamClientActivityFourTest.this.imageView4.getTag().toString()));
                    IpcamClientActivityFourTest.this.imageView4.setTag(1);
                    IpcamClientActivityFourTest.this.textView4.setVisibility(8);
                    IpcamClientActivityFourTest.this.connection_show4.setVisibility(8);
                    int unused8 = IpcamClientActivityFourTest.this.imageTag4 = 0;
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
                            IpcamClientActivityFourTest.this.imageView4.setImageBitmap(IpcamClientActivityFourTest.this.bitmap_defult);
                            int unused = IpcamClientActivityFourTest.this.connectionTag4 = 1;
                            IpcamClientActivityFourTest ipcamClientActivityFourTest = IpcamClientActivityFourTest.this;
                            ipcamClientActivityFourTest.showToast(IpcamClientActivityFourTest.this.name4 + IpcamClientActivityFourTest.this.getResources().getString(R.string.pppp_status_disconnect));
                            if (IpcamClientActivityFourTest.this.popupWindow_about != null && IpcamClientActivityFourTest.this.popupWindow_about.isShowing()) {
                                IpcamClientActivityFourTest.this.popupWindow_about.dismiss();
                            }
                        }
                    }.execute(new Void[0]);
                }
            }
        }
    };
    int one = 0;
    /* access modifiers changed from: private */
    public PopupWindow popupWindow_about;
    /* access modifiers changed from: private */
    public ProgressDialog progressDialogCommon;
    private CameraInfoReceiver receiver = null;
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
    /* access modifiers changed from: private */
    public ArrayList<String> strDidList;
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
    private TextView textView_did;
    private int timeOne = 0;
    private int timeOne2 = 0;
    private int timeOne3 = 0;
    private int timeOne4 = 0;
    private int timeTag = 0;
    private int timeTag2 = 0;
    private int timeTag3 = 0;
    private int timeTag4 = 0;
    private int timeTwo = 0;
    private int timeTwo2 = 0;
    private int timeTwo3 = 0;
    private int timeTwo4 = 0;
    int two = 0;

    public void callBackAudioData(byte[] bArr, int i) {
    }

    public void callBackCameraParamNotify(String str, int i, int i2, int i3, int i4, int i5, int i6) {
    }

    public void callBackH264Data(byte[] bArr, int i, int i2) {
    }

    static /* synthetic */ int access$210(IpcamClientActivityFourTest ipcamClientActivityFourTest) {
        int i = ipcamClientActivityFourTest.camerSum;
        ipcamClientActivityFourTest.camerSum = i - 1;
        return i;
    }

    public static void changerCameraStatus(int i) {
        cameraStatus = i;
    }

    private void initExitDialog() {
        this.dlgExit = new Dialog(this, R.style.customDialog);
        this.dlgExit.setContentView(R.layout.dialog_exit_play);
        this.dlgExit.findViewById(R.id.tvCancel).setOnClickListener(this);
        this.dlgExit.findViewById(R.id.tvExit).setOnClickListener(this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.ipcamclientftestone);
        findView();
        setControlListener();
        SystemValue.TAG_CAMERLIST = 1;
        this.screenHeight = getWindowManager().getDefaultDisplay().getHeight();
        this.screenWidth = getWindowManager().getDefaultDisplay().getWidth();
        this.bitMapWidth = this.screenWidth / 2;
        this.bitMapHight = this.screenHeight / 2;
        this.strDidList = new ArrayList<>();
        NUIMainActivity.setIpPlayInterface(this);
        this.progressDialogCommon = new ProgressDialog(this);
        this.maps = new HashMap();
        this.matrix = new Matrix();
        this.matrix.postScale(0.5f, 0.3f);
        initExitPopupWindow2();
        initExitDialog();
        this.cameraListFourAdapter = new CameraListFourAdapter(this);
    }

    private Bitmap returnBitmap(Bitmap bitmap) {
        if (bitmap.getWidth() < 600 || bitmap.getHeight() < 300) {
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), this.matrix, true);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, 600, 300);
        return Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight(), this.matrix, true);
    }

    private void findView() {
        this.cameraListView = (ListView) findViewById(R.id.listviewCamera);
        this.imageView1 = (ImageView) findViewById(R.id.imageView1);
        this.imageView2 = (ImageView) findViewById(R.id.imageView2);
        this.imageView3 = (ImageView) findViewById(R.id.imageView3);
        this.imageView4 = (ImageView) findViewById(R.id.imageView4);
        this.textView1 = (TextView) findViewById(R.id.textView1_ssid);
        this.textView2 = (TextView) findViewById(R.id.textView2_ssid);
        this.textView3 = (TextView) findViewById(R.id.textView3_ssid);
        this.textView4 = (TextView) findViewById(R.id.textView4_ssid);
        this.linear = (LinearLayout) findViewById(R.id.linear);
        this.connection_show1 = (LinearLayout) findViewById(R.id.connection_show1);
        this.connection_show2 = (LinearLayout) findViewById(R.id.connection_show2);
        this.connection_show3 = (LinearLayout) findViewById(R.id.connection_show3);
        this.connection_show4 = (LinearLayout) findViewById(R.id.connection_show4);
        this.imageButton_hind = (ImageButton) findViewById(R.id.imagebutton_hind);
        this.imageView1.setTag(1);
        this.imageView2.setTag(1);
        this.imageView3.setTag(1);
        this.imageView4.setTag(1);
    }

    private void setControlListener() {
        this.cameraListView.setOnItemClickListener(this);
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

    public void initExitPopupWindow2() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.popup, (ViewGroup) null);
        this.textView_did = (TextView) inflate.findViewById(R.id.textView1_did);
        this.popupWindow_about = new PopupWindow(inflate, -2, -2);
        this.popupWindow_about.setAnimationStyle(R.style.AnimationPreview);
        this.popupWindow_about.setFocusable(true);
        this.popupWindow_about.setOutsideTouchable(true);
        this.popupWindow_about.setBackgroundDrawable(new ColorDrawable(0));
        ((Button) inflate.findViewById(R.id.add_check_load)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                IpcamClientActivityFourTest ipcamClientActivityFourTest = IpcamClientActivityFourTest.this;
                Intent unused = ipcamClientActivityFourTest.f1541in = new Intent(ipcamClientActivityFourTest, NDNCameraLiveActivity.class);
                IpcamClientActivityFourTest.this.f1541in.putExtra("play_four_tag", 1);
                IpcamClientActivityFourTest.this.f1541in.putExtra(ContentCommon.STR_CAMERA_TYPE, 1);
                IpcamClientActivityFourTest.this.f1541in.putExtra(ContentCommon.STR_STREAM_TYPE, 3);
                int access$3300 = IpcamClientActivityFourTest.this.TAGPlay;
                if (access$3300 == 1) {
                    Intent access$3200 = IpcamClientActivityFourTest.this.f1541in;
                    access$3200.putExtra(ContentCommon.STR_CAMERA_NAME, IpcamClientActivityFourTest.this.returnString(R.string.play_four_show1) + "---" + IpcamClientActivityFourTest.this.name1);
                    IpcamClientActivityFourTest.this.f1541in.putExtra(ContentCommon.STR_CAMERA_ID, IpcamClientActivityFourTest.this.imageView1.getTag().toString());
                } else if (access$3300 == 2) {
                    Intent access$32002 = IpcamClientActivityFourTest.this.f1541in;
                    access$32002.putExtra(ContentCommon.STR_CAMERA_NAME, IpcamClientActivityFourTest.this.returnString(R.string.play_four_show2) + "---" + IpcamClientActivityFourTest.this.name2);
                    IpcamClientActivityFourTest.this.f1541in.putExtra(ContentCommon.STR_CAMERA_ID, IpcamClientActivityFourTest.this.imageView2.getTag().toString());
                } else if (access$3300 == 3) {
                    Intent access$32003 = IpcamClientActivityFourTest.this.f1541in;
                    access$32003.putExtra(ContentCommon.STR_CAMERA_NAME, IpcamClientActivityFourTest.this.returnString(R.string.play_four_show3) + "---" + IpcamClientActivityFourTest.this.name3);
                    IpcamClientActivityFourTest.this.f1541in.putExtra(ContentCommon.STR_CAMERA_ID, IpcamClientActivityFourTest.this.imageView3.getTag().toString());
                } else if (access$3300 == 4) {
                    Intent access$32004 = IpcamClientActivityFourTest.this.f1541in;
                    access$32004.putExtra(ContentCommon.STR_CAMERA_NAME, IpcamClientActivityFourTest.this.returnString(R.string.play_four_show4) + "---" + IpcamClientActivityFourTest.this.name4);
                    IpcamClientActivityFourTest.this.f1541in.putExtra(ContentCommon.STR_CAMERA_ID, IpcamClientActivityFourTest.this.imageView4.getTag().toString());
                }
                new AsyncTask<Void, Void, Void>() {
                    /* access modifiers changed from: protected */
                    public void onPreExecute() {
                        IpcamClientActivityFourTest.this.progressDialogCommon.setMessage(IpcamClientActivityFourTest.this.returnString(R.string.play_four_cut));
                        IpcamClientActivityFourTest.this.progressDialogCommon.setCancelable(false);
                        IpcamClientActivityFourTest.this.progressDialogCommon.show();
                    }

                    /* access modifiers changed from: protected */
                    public Void doInBackground(Void... voidArr) {
                        for (int i = 0; i < IpcamClientActivityFourTest.this.strDidList.size(); i++) {
                            NativeCaller.StopPPPPLivestream((String) IpcamClientActivityFourTest.this.strDidList.get(i));
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            Thread.sleep(1000);
                            return null;
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                            return null;
                        }
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(Void voidR) {
                        IpcamClientActivityFourTest.this.progressDialogCommon.cancel();
                        IpcamClientActivityFourTest.this.startActivity(IpcamClientActivityFourTest.this.f1541in);
                        IpcamClientActivityFourTest.this.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                    }
                }.execute(new Void[0]);
                IpcamClientActivityFourTest.this.popupWindow_about.dismiss();
            }
        });
        ((Button) inflate.findViewById(R.id.add_check_phone)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int access$3300 = IpcamClientActivityFourTest.this.TAGPlay;
                if (access$3300 == 1) {
                    NativeCaller.StopPPPPLivestream(IpcamClientActivityFourTest.this.imageView1.getTag().toString());
                    boolean unused = IpcamClientActivityFourTest.this.ssidTag1 = false;
                    IpcamClientActivityFourTest.this.strDidList.remove(IpcamClientActivityFourTest.this.strDidList.indexOf(IpcamClientActivityFourTest.this.imageView1.getTag().toString()));
                    IpcamClientActivityFourTest.this.imageView1.setTag(1);
                    IpcamClientActivityFourTest.this.textView1.setVisibility(8);
                    IpcamClientActivityFourTest.this.connection_show1.setVisibility(8);
                    int unused2 = IpcamClientActivityFourTest.this.imageTag1 = 0;
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
                            IpcamClientActivityFourTest.this.imageView1.setImageBitmap(IpcamClientActivityFourTest.this.bitmap_defult);
                            int unused = IpcamClientActivityFourTest.this.connectionTag1 = 0;
                        }
                    }.execute(new Void[0]);
                } else if (access$3300 == 2) {
                    NativeCaller.StopPPPPLivestream(IpcamClientActivityFourTest.this.imageView2.getTag().toString());
                    boolean unused3 = IpcamClientActivityFourTest.this.ssidTag2 = false;
                    IpcamClientActivityFourTest.this.strDidList.remove(IpcamClientActivityFourTest.this.strDidList.indexOf(IpcamClientActivityFourTest.this.imageView2.getTag().toString()));
                    IpcamClientActivityFourTest.this.imageView2.setTag(1);
                    IpcamClientActivityFourTest.this.textView2.setVisibility(8);
                    IpcamClientActivityFourTest.this.connection_show2.setVisibility(8);
                    int unused4 = IpcamClientActivityFourTest.this.imageTag2 = 0;
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
                            IpcamClientActivityFourTest.this.imageView2.setImageBitmap(IpcamClientActivityFourTest.this.bitmap_defult);
                            int unused = IpcamClientActivityFourTest.this.connectionTag2 = 0;
                        }
                    }.execute(new Void[0]);
                } else if (access$3300 == 3) {
                    NativeCaller.StopPPPPLivestream(IpcamClientActivityFourTest.this.imageView3.getTag().toString());
                    boolean unused5 = IpcamClientActivityFourTest.this.ssidTag3 = false;
                    IpcamClientActivityFourTest.this.strDidList.remove(IpcamClientActivityFourTest.this.strDidList.indexOf(IpcamClientActivityFourTest.this.imageView3.getTag().toString()));
                    IpcamClientActivityFourTest.this.imageView3.setTag(1);
                    IpcamClientActivityFourTest.this.textView3.setVisibility(8);
                    IpcamClientActivityFourTest.this.connection_show3.setVisibility(8);
                    int unused6 = IpcamClientActivityFourTest.this.imageTag3 = 0;
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
                            IpcamClientActivityFourTest.this.imageView3.setImageBitmap(IpcamClientActivityFourTest.this.bitmap_defult);
                            int unused = IpcamClientActivityFourTest.this.connectionTag3 = 0;
                        }
                    }.execute(new Void[0]);
                } else if (access$3300 == 4) {
                    NativeCaller.StopPPPPLivestream(IpcamClientActivityFourTest.this.imageView4.getTag().toString());
                    boolean unused7 = IpcamClientActivityFourTest.this.ssidTag4 = false;
                    IpcamClientActivityFourTest.this.strDidList.remove(IpcamClientActivityFourTest.this.strDidList.indexOf(IpcamClientActivityFourTest.this.imageView4.getTag().toString()));
                    IpcamClientActivityFourTest.this.imageView4.setTag(1);
                    IpcamClientActivityFourTest.this.textView4.setVisibility(8);
                    IpcamClientActivityFourTest.this.connection_show4.setVisibility(8);
                    int unused8 = IpcamClientActivityFourTest.this.imageTag4 = 0;
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
                            IpcamClientActivityFourTest.this.imageView4.setImageBitmap(IpcamClientActivityFourTest.this.bitmap_defult);
                            int unused = IpcamClientActivityFourTest.this.connectionTag4 = 0;
                        }
                    }.execute(new Void[0]);
                }
                IpcamClientActivityFourTest.access$210(IpcamClientActivityFourTest.this);
                IpcamClientActivityFourTest.this.popupWindow_about.dismiss();
            }
        });
        this.popupWindow_about.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                IpcamClientActivityFourTest.this.popupWindow_about.dismiss();
            }
        });
        this.popupWindow_about.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                IpcamClientActivityFourTest.this.popupWindow_about.dismiss();
                return false;
            }
        });
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.imagebutton_hind) {
            if (id == R.id.tvCancel) {
                this.dlgExit.dismiss();
            } else if (id != R.id.tvExit) {
                switch (id) {
                    case R.id.imageView1 /*2131165510*/:
                        if (this.imageTag1 == 1) {
                            Date date = new Date();
                            int i = this.timeTag;
                            if (i == 0) {
                                this.timeOne = date.getSeconds();
                                this.timeTag = 1;
                                return;
                            } else if (i == 1) {
                                this.timeTwo = date.getSeconds();
                                if (this.timeTwo - this.timeOne <= 3) {
                                    new AsyncTask<Void, Void, Void>() {
                                        /* access modifiers changed from: protected */
                                        public void onPreExecute() {
                                            IpcamClientActivityFourTest.this.progressDialogCommon.setMessage(IpcamClientActivityFourTest.this.returnString(R.string.play_four_cut));
                                            IpcamClientActivityFourTest.this.progressDialogCommon.setCancelable(false);
                                            IpcamClientActivityFourTest.this.progressDialogCommon.show();
                                            IpcamClientActivityFourTest ipcamClientActivityFourTest = IpcamClientActivityFourTest.this;
                                            Intent unused = ipcamClientActivityFourTest.f1541in = new Intent(ipcamClientActivityFourTest, NDNCameraLiveActivity.class);
                                            IpcamClientActivityFourTest.this.f1541in.putExtra("play_four_tag", 1);
                                            IpcamClientActivityFourTest.this.f1541in.putExtra(ContentCommon.STR_CAMERA_TYPE, 1);
                                            IpcamClientActivityFourTest.this.f1541in.putExtra(ContentCommon.STR_STREAM_TYPE, 3);
                                            IpcamClientActivityFourTest.this.f1541in.putExtra(ContentCommon.STR_CAMERA_NAME, IpcamClientActivityFourTest.this.name1);
                                            IpcamClientActivityFourTest.this.f1541in.putExtra(ContentCommon.STR_CAMERA_ID, IpcamClientActivityFourTest.this.imageView1.getTag().toString());
                                        }

                                        /* access modifiers changed from: protected */
                                        public Void doInBackground(Void... voidArr) {
                                            for (int i = 0; i < IpcamClientActivityFourTest.this.strDidList.size(); i++) {
                                                NativeCaller.StopPPPPLivestream((String) IpcamClientActivityFourTest.this.strDidList.get(i));
                                                try {
                                                    Thread.sleep(500);
                                                } catch (InterruptedException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                            try {
                                                Thread.sleep(1000);
                                                return null;
                                            } catch (InterruptedException e2) {
                                                e2.printStackTrace();
                                                return null;
                                            }
                                        }

                                        /* access modifiers changed from: protected */
                                        public void onPostExecute(Void voidR) {
                                            IpcamClientActivityFourTest.this.progressDialogCommon.cancel();
                                            boolean unused = IpcamClientActivityFourTest.this.PlayTag = false;
                                            Bitmap unused2 = IpcamClientActivityFourTest.this.bitmap_defult = null;
                                            IpcamClientActivityFourTest ipcamClientActivityFourTest = IpcamClientActivityFourTest.this;
                                            ipcamClientActivityFourTest.bitmap11 = null;
                                            ipcamClientActivityFourTest.bitmap22 = null;
                                            ipcamClientActivityFourTest.bitmap33 = null;
                                            ipcamClientActivityFourTest.bitmap44 = null;
                                            ipcamClientActivityFourTest.startActivity(ipcamClientActivityFourTest.f1541in);
                                            IpcamClientActivityFourTest.this.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                                        }
                                    }.execute(new Void[0]);
                                    this.timeTag = 0;
                                    return;
                                }
                                this.timeTag = 1;
                                return;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    case R.id.imageView2 /*2131165511*/:
                        if (this.imageTag2 == 1) {
                            Date date2 = new Date();
                            int i2 = this.timeTag2;
                            if (i2 == 0) {
                                this.timeOne2 = date2.getSeconds();
                                this.timeTag2 = 1;
                                return;
                            } else if (i2 == 1) {
                                this.timeTwo2 = date2.getSeconds();
                                if (this.timeTwo2 - this.timeOne2 <= 3) {
                                    new AsyncTask<Void, Void, Void>() {
                                        /* access modifiers changed from: protected */
                                        public void onPreExecute() {
                                            IpcamClientActivityFourTest.this.progressDialogCommon.setMessage(IpcamClientActivityFourTest.this.returnString(R.string.play_four_cut));
                                            IpcamClientActivityFourTest.this.progressDialogCommon.setCancelable(false);
                                            IpcamClientActivityFourTest.this.progressDialogCommon.show();
                                            IpcamClientActivityFourTest ipcamClientActivityFourTest = IpcamClientActivityFourTest.this;
                                            Intent unused = ipcamClientActivityFourTest.f1541in = new Intent(ipcamClientActivityFourTest, NDNCameraLiveActivity.class);
                                            IpcamClientActivityFourTest.this.f1541in.putExtra("play_four_tag", 1);
                                            IpcamClientActivityFourTest.this.f1541in.putExtra(ContentCommon.STR_CAMERA_TYPE, 1);
                                            IpcamClientActivityFourTest.this.f1541in.putExtra(ContentCommon.STR_STREAM_TYPE, 3);
                                            IpcamClientActivityFourTest.this.f1541in.putExtra(ContentCommon.STR_CAMERA_NAME, IpcamClientActivityFourTest.this.name2);
                                            IpcamClientActivityFourTest.this.f1541in.putExtra(ContentCommon.STR_CAMERA_ID, IpcamClientActivityFourTest.this.imageView2.getTag().toString());
                                        }

                                        /* access modifiers changed from: protected */
                                        public Void doInBackground(Void... voidArr) {
                                            for (int i = 0; i < IpcamClientActivityFourTest.this.strDidList.size(); i++) {
                                                NativeCaller.StopPPPPLivestream((String) IpcamClientActivityFourTest.this.strDidList.get(i));
                                                try {
                                                    Thread.sleep(500);
                                                } catch (InterruptedException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                            try {
                                                Thread.sleep(1000);
                                                return null;
                                            } catch (InterruptedException e2) {
                                                e2.printStackTrace();
                                                return null;
                                            }
                                        }

                                        /* access modifiers changed from: protected */
                                        public void onPostExecute(Void voidR) {
                                            IpcamClientActivityFourTest.this.progressDialogCommon.cancel();
                                            boolean unused = IpcamClientActivityFourTest.this.PlayTag = false;
                                            Bitmap unused2 = IpcamClientActivityFourTest.this.bitmap_defult = null;
                                            IpcamClientActivityFourTest ipcamClientActivityFourTest = IpcamClientActivityFourTest.this;
                                            ipcamClientActivityFourTest.bitmap11 = null;
                                            ipcamClientActivityFourTest.bitmap22 = null;
                                            ipcamClientActivityFourTest.bitmap33 = null;
                                            ipcamClientActivityFourTest.bitmap44 = null;
                                            ipcamClientActivityFourTest.startActivity(ipcamClientActivityFourTest.f1541in);
                                            IpcamClientActivityFourTest.this.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                                        }
                                    }.execute(new Void[0]);
                                    this.timeTag2 = 0;
                                    return;
                                }
                                this.timeTag2 = 1;
                                return;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    case R.id.imageView3 /*2131165512*/:
                        if (this.imageTag3 == 1) {
                            Date date3 = new Date();
                            int i3 = this.timeTag3;
                            if (i3 == 0) {
                                this.timeOne3 = date3.getSeconds();
                                this.timeTag3 = 1;
                                return;
                            } else if (i3 == 1) {
                                this.timeTwo3 = date3.getSeconds();
                                if (this.timeTwo3 - this.timeOne3 <= 3) {
                                    new AsyncTask<Void, Void, Void>() {
                                        /* access modifiers changed from: protected */
                                        public void onPreExecute() {
                                            IpcamClientActivityFourTest.this.progressDialogCommon.setMessage(IpcamClientActivityFourTest.this.returnString(R.string.play_four_cut));
                                            IpcamClientActivityFourTest.this.progressDialogCommon.setCancelable(false);
                                            IpcamClientActivityFourTest.this.progressDialogCommon.show();
                                            IpcamClientActivityFourTest ipcamClientActivityFourTest = IpcamClientActivityFourTest.this;
                                            Intent unused = ipcamClientActivityFourTest.f1541in = new Intent(ipcamClientActivityFourTest, NDNCameraLiveActivity.class);
                                            IpcamClientActivityFourTest.this.f1541in.putExtra("play_four_tag", 1);
                                            IpcamClientActivityFourTest.this.f1541in.putExtra(ContentCommon.STR_CAMERA_TYPE, 1);
                                            IpcamClientActivityFourTest.this.f1541in.putExtra(ContentCommon.STR_STREAM_TYPE, 3);
                                            IpcamClientActivityFourTest.this.f1541in.putExtra(ContentCommon.STR_CAMERA_NAME, IpcamClientActivityFourTest.this.name3);
                                            IpcamClientActivityFourTest.this.f1541in.putExtra(ContentCommon.STR_CAMERA_ID, IpcamClientActivityFourTest.this.imageView3.getTag().toString());
                                        }

                                        /* access modifiers changed from: protected */
                                        public Void doInBackground(Void... voidArr) {
                                            for (int i = 0; i < IpcamClientActivityFourTest.this.strDidList.size(); i++) {
                                                NativeCaller.StopPPPPLivestream((String) IpcamClientActivityFourTest.this.strDidList.get(i));
                                                try {
                                                    Thread.sleep(500);
                                                } catch (InterruptedException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                            try {
                                                Thread.sleep(1000);
                                                return null;
                                            } catch (InterruptedException e2) {
                                                e2.printStackTrace();
                                                return null;
                                            }
                                        }

                                        /* access modifiers changed from: protected */
                                        public void onPostExecute(Void voidR) {
                                            IpcamClientActivityFourTest.this.progressDialogCommon.cancel();
                                            boolean unused = IpcamClientActivityFourTest.this.PlayTag = false;
                                            Bitmap unused2 = IpcamClientActivityFourTest.this.bitmap_defult = null;
                                            IpcamClientActivityFourTest ipcamClientActivityFourTest = IpcamClientActivityFourTest.this;
                                            ipcamClientActivityFourTest.bitmap11 = null;
                                            ipcamClientActivityFourTest.bitmap22 = null;
                                            ipcamClientActivityFourTest.bitmap33 = null;
                                            ipcamClientActivityFourTest.bitmap44 = null;
                                            ipcamClientActivityFourTest.startActivity(ipcamClientActivityFourTest.f1541in);
                                            IpcamClientActivityFourTest.this.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                                        }
                                    }.execute(new Void[0]);
                                    this.timeTag3 = 0;
                                    return;
                                }
                                this.timeTag3 = 1;
                                return;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    case R.id.imageView4 /*2131165513*/:
                        if (this.imageTag4 == 1) {
                            Date date4 = new Date();
                            int i4 = this.timeTag4;
                            if (i4 == 0) {
                                this.timeOne4 = date4.getSeconds();
                                this.timeTag4 = 1;
                                return;
                            } else if (i4 == 1) {
                                this.timeTwo4 = date4.getSeconds();
                                if (this.timeTwo4 - this.timeOne4 <= 3) {
                                    new AsyncTask<Void, Void, Void>() {
                                        /* access modifiers changed from: protected */
                                        public void onPreExecute() {
                                            IpcamClientActivityFourTest.this.progressDialogCommon.setMessage(IpcamClientActivityFourTest.this.returnString(R.string.play_four_cut));
                                            IpcamClientActivityFourTest.this.progressDialogCommon.setCancelable(false);
                                            IpcamClientActivityFourTest.this.progressDialogCommon.show();
                                            IpcamClientActivityFourTest ipcamClientActivityFourTest = IpcamClientActivityFourTest.this;
                                            Intent unused = ipcamClientActivityFourTest.f1541in = new Intent(ipcamClientActivityFourTest, NDNCameraLiveActivity.class);
                                            IpcamClientActivityFourTest.this.f1541in.putExtra("play_four_tag", 1);
                                            IpcamClientActivityFourTest.this.f1541in.putExtra(ContentCommon.STR_CAMERA_TYPE, 1);
                                            IpcamClientActivityFourTest.this.f1541in.putExtra(ContentCommon.STR_STREAM_TYPE, 3);
                                            IpcamClientActivityFourTest.this.f1541in.putExtra(ContentCommon.STR_CAMERA_NAME, IpcamClientActivityFourTest.this.name4);
                                            IpcamClientActivityFourTest.this.f1541in.putExtra(ContentCommon.STR_CAMERA_ID, IpcamClientActivityFourTest.this.imageView4.getTag().toString());
                                        }

                                        /* access modifiers changed from: protected */
                                        public Void doInBackground(Void... voidArr) {
                                            for (int i = 0; i < IpcamClientActivityFourTest.this.strDidList.size(); i++) {
                                                NativeCaller.StopPPPPLivestream((String) IpcamClientActivityFourTest.this.strDidList.get(i));
                                                try {
                                                    Thread.sleep(500);
                                                } catch (InterruptedException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                            try {
                                                Thread.sleep(1000);
                                                return null;
                                            } catch (InterruptedException e2) {
                                                e2.printStackTrace();
                                                return null;
                                            }
                                        }

                                        /* access modifiers changed from: protected */
                                        public void onPostExecute(Void voidR) {
                                            IpcamClientActivityFourTest.this.progressDialogCommon.cancel();
                                            boolean unused = IpcamClientActivityFourTest.this.PlayTag = false;
                                            Bitmap unused2 = IpcamClientActivityFourTest.this.bitmap_defult = null;
                                            IpcamClientActivityFourTest ipcamClientActivityFourTest = IpcamClientActivityFourTest.this;
                                            ipcamClientActivityFourTest.bitmap11 = null;
                                            ipcamClientActivityFourTest.bitmap22 = null;
                                            ipcamClientActivityFourTest.bitmap33 = null;
                                            ipcamClientActivityFourTest.bitmap44 = null;
                                            ipcamClientActivityFourTest.startActivity(ipcamClientActivityFourTest.f1541in);
                                            IpcamClientActivityFourTest.this.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                                        }
                                    }.execute(new Void[0]);
                                    this.timeTag4 = 0;
                                    return;
                                }
                                this.timeTag4 = 1;
                                return;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            } else {
                this.dlgExit.dismiss();
                SystemValue.TAG_CAMERLIST = 0;
                finish();
            }
        } else if (this.ifHind) {
            this.cameraListView.setVisibility(8);
            this.imageButton_hind.setImageResource(R.drawable.hind_buttong_bg1);
            this.ifHind = false;
        } else {
            this.cameraListView.setVisibility(0);
            this.imageButton_hind.setImageResource(R.drawable.hind_buttong_bg);
            this.ifHind = true;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82 || i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        Dialog dialog = this.dlgExit;
        if (dialog == null || dialog.isShowing()) {
            return true;
        }
        this.dlgExit.show();
        return true;
    }

    public void showSureDialogF() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.icon_camera);
        builder.setTitle(returnString(R.string.play_four_exit1));
        builder.setMessage(R.string.play_four_exit2);
        builder.setPositiveButton(R.string.str_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                SystemValue.TAG_CAMERLIST = 0;
                IpcamClientActivityFourTest.this.finish();
            }
        });
        builder.setNegativeButton(R.string.str_cancel, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* access modifiers changed from: private */
    public synchronized boolean UpdataCamera2db(String str, String str2, String str3, String str4, String str5) {
        return false;
    }

    /* access modifiers changed from: private */
    public synchronized void addCamera2db(String str, String str2, String str3, String str4) {
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        Log.d(TAG, "onResume()");
        super.onResume();
    }

    class CameraInfoReceiver extends BroadcastReceiver {
        CameraInfoReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("other".equals(intent.getAction())) {
                IpcamClientActivityFourTest.this.cameraListFourAdapter.sendCameraStatus();
                return;
            }
            int intExtra = intent.getIntExtra(ContentCommon.CAMERA_OPTION, 65535);
            if (intExtra != 65535) {
                String stringExtra = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
                String stringExtra2 = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
                String stringExtra3 = intent.getStringExtra(ContentCommon.STR_CAMERA_USER);
                String stringExtra4 = intent.getStringExtra(ContentCommon.STR_CAMERA_PWD);
                if (intExtra == 2) {
                    String stringExtra5 = intent.getStringExtra(ContentCommon.STR_CAMERA_OLD_ID);
                    if (IpcamClientActivityFourTest.this.UpdataCamera2db(stringExtra5, stringExtra, stringExtra2, stringExtra3, stringExtra4)) {
                        if (IpcamClientActivityFourTest.this.cameraListFourAdapter.UpdateCamera(stringExtra5, stringExtra, stringExtra2, stringExtra3, stringExtra4)) {
                            IpcamClientActivityFourTest.this.cameraListFourAdapter.notifyDataSetChanged();
                            NativeCaller.StopPPPP(stringExtra2);
                            IpcamClientActivityFourTest.this.StartPPPP(stringExtra2, stringExtra3, stringExtra4);
                        }
                        Intent intent2 = new Intent("del_add_modify_camera");
                        intent2.putExtra("type", 2);
                        intent2.putExtra(ContentCommon.STR_CAMERA_ID, stringExtra2);
                        intent2.putExtra("olddid", stringExtra5);
                        intent2.putExtra(SharedPreferencesUtils.USER_NAME, stringExtra);
                        IpcamClientActivityFourTest.this.sendBroadcast(intent2);
                    }
                } else if (intExtra == 3) {
                    if (IpcamClientActivityFourTest.this.cameraListFourAdapter.UpdateCamera(intent.getStringExtra(ContentCommon.STR_CAMERA_OLD_ID), stringExtra, stringExtra2, stringExtra3, stringExtra4)) {
                        Log.d(IpcamClientActivityFourTest.TAG, "did:" + stringExtra2 + " user:" + stringExtra3 + " pwd:" + stringExtra4);
                        IpcamClientActivityFourTest.this.cameraListFourAdapter.notifyDataSetChanged();
                        NativeCaller.StopPPPP(stringExtra2);
                        IpcamClientActivityFourTest.this.StartPPPP(stringExtra2, stringExtra3, stringExtra4);
                    }
                } else if (IpcamClientActivityFourTest.this.cameraListFourAdapter.getCount() >= 20) {
                    IpcamClientActivityFourTest.this.showToast((int) R.string.add_camer_no_add);
                } else if (IpcamClientActivityFourTest.this.cameraListFourAdapter.AddCamera(stringExtra, stringExtra2, stringExtra3, stringExtra4)) {
                    IpcamClientActivityFourTest.this.cameraListFourAdapter.notifyDataSetChanged();
                    IpcamClientActivityFourTest.this.StartPPPP(stringExtra2, stringExtra3, stringExtra4);
                    final String str = stringExtra;
                    final String str2 = stringExtra2;
                    final String str3 = stringExtra3;
                    final String str4 = stringExtra4;
                    new Thread() {
                        public void run() {
                            IpcamClientActivityFourTest.this.addCamera2db(str, str2, str3, str4);
                            Intent intent = new Intent("del_add_modify_camera");
                            intent.putExtra("type", 1);
                            intent.putExtra(ContentCommon.STR_CAMERA_ID, str2);
                            intent.putExtra(SharedPreferencesUtils.USER_NAME, str);
                            IpcamClientActivityFourTest.this.sendBroadcast(intent);
                        }
                    }.start();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        Log.d(TAG, "onStart()");
        super.onStart();
        SystemValue.TAG_CAMERLIST = 1;
        this.imageView1.setImageBitmap(this.bitmap_defult);
        this.imageView2.setImageBitmap(this.bitmap_defult);
        this.imageView3.setImageBitmap(this.bitmap_defult);
        this.imageView4.setImageBitmap(this.bitmap_defult);
        this.cameraListView.setAdapter(this.cameraListFourAdapter);
        this.PlayTag = true;
        this.timeTag = 0;
        this.timeOne = 0;
        this.timeTwo = 0;
        this.timeTag2 = 0;
        this.timeOne2 = 0;
        this.timeTwo2 = 0;
        this.timeTag3 = 0;
        this.timeOne3 = 0;
        this.timeTwo3 = 0;
        this.timeTag4 = 0;
        this.timeOne4 = 0;
        this.timeTwo4 = 0;
        ArrayList<String> arrayList = this.strDidList;
        if (!(arrayList == null && arrayList.size() == 0)) {
            new AsyncTask<Void, Void, Void>() {
                /* access modifiers changed from: protected */
                public void onPreExecute() {
                    IpcamClientActivityFourTest.this.progressDialogCommon.setMessage(IpcamClientActivityFourTest.this.returnString(R.string.play_four_cut2));
                    IpcamClientActivityFourTest.this.progressDialogCommon.setCancelable(false);
                    IpcamClientActivityFourTest.this.progressDialogCommon.show();
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(Void voidR) {
                    IpcamClientActivityFourTest.this.progressDialogCommon.cancel();
                }

                /* access modifiers changed from: protected */
                public Void doInBackground(Void... voidArr) {
                    for (int i = 0; i < IpcamClientActivityFourTest.this.strDidList.size(); i++) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        NativeCaller.StartPPPPLivestream((String) IpcamClientActivityFourTest.this.strDidList.get(i), 2);
                        Log.d(IpcamClientActivityFourTest.TAG, "StartPPPPLivestream()");
                    }
                    return null;
                }
            }.execute(new Void[0]);
        }
        if (this.receiver == null) {
            this.receiver = new CameraInfoReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ContentCommon.STR_CAMERA_INFO_RECEIVER);
            intentFilter.addAction("back");
            intentFilter.addAction("other");
            registerReceiver(this.receiver, intentFilter);
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        this.connectionTag1 = 0;
        this.connectionTag2 = 0;
        this.connectionTag3 = 0;
        this.connectionTag4 = 0;
        Log.d("shix", "shix play_four_onrestart");
        super.onRestart();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        SystemValue.TAG_CAMERLIST = 0;
        this.ssidTag1 = false;
        this.ssidTag2 = false;
        this.ssidTag3 = false;
        this.ssidTag4 = false;
        this.ifImageTag1 = 0;
        this.ifImageTag2 = 0;
        this.ifImageTag3 = 0;
        this.ifImageTag4 = 0;
        this.imageTag1 = 0;
        this.imageTag2 = 0;
        this.imageTag3 = 0;
        this.imageTag4 = 0;
        for (int i = 0; i < this.strDidList.size(); i++) {
            NativeCaller.StopPPPPLivestream(this.strDidList.get(i));
        }
        this.strDidList.clear();
        this.bitmap11 = null;
        this.bitmap22 = null;
        this.bitmap33 = null;
        this.bitmap44 = null;
        this.bitmap_defult = null;
        unregisterReceiver(this.receiver);
        super.onDestroy();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int dev_p2pstatus;
        this.bean = this.cameraListFourAdapter.getOnItem(i);
        CameraParamsBean cameraParamsBean = this.bean;
        if (cameraParamsBean != null && (dev_p2pstatus = cameraParamsBean.getDev_p2pstatus()) != 5) {
            if (dev_p2pstatus != 2) {
                StartPPPP(this.bean.getDev_Did(), this.bean.getDev_User(), this.bean.getDev_Pwd());
            } else if (this.strDidList.contains(this.bean.getDev_Did())) {
                showToast((int) R.string.play_four_connected);
            } else if (this.camerSum > 3) {
                showToast((int) R.string.play_four_del);
            } else {
                this.strDidList.add(this.bean.getDev_Did());
                this.camerSum++;
                imageSetTag(this.imageView1, this.imageView2, this.imageView3, this.imageView4, this.bean.getDev_Did(), this.bean.getDev_name());
            }
        }
    }

    class MyImage1Threak extends Thread {
        MyImage1Threak() {
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:26|27|28|29|30) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00dd */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
            L_0x0000:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                boolean r0 = r0.ssidTag1
                if (r0 == 0) goto L_0x0133
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                int r0 = r0.ifImageTag1
                r1 = 1
                if (r0 != r1) goto L_0x0000
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "shix connectionTag1:"
                r0.append(r2)
                com.shix.shixipc.activity.IpcamClientActivityFourTest r2 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                int r2 = r2.connectionTag1
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                java.lang.String r2 = "shix"
                android.util.Log.d(r2, r0)
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                int r0 = r0.connectionTag1
                r2 = 0
                if (r0 != r1) goto L_0x0045
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                com.shix.shixipc.activity.IpcamClientActivityFourTest$MyImage1Threak$1 r3 = new com.shix.shixipc.activity.IpcamClientActivityFourTest$MyImage1Threak$1
                r3.<init>()
                r0.runOnUiThread(r3)
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                int unused = r0.connectionTag1 = r2
            L_0x0045:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                int r0 = r0.connectionTag1
                r3 = 200(0xc8, double:9.9E-322)
                if (r0 == 0) goto L_0x0058
                java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x0053 }
                goto L_0x0000
            L_0x0053:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x0000
            L_0x0058:
                java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x005c }
                goto L_0x0060
            L_0x005c:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0060:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                boolean r0 = r0.copyTag1
                if (r0 == 0) goto L_0x0000
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                boolean unused = r0.copyTag1 = r2
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x010b }
                int r0 = r0.image1IsH264     // Catch:{ OutOfMemoryError -> 0x010b }
                if (r0 != 0) goto L_0x0088
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x010b }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r3 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x010b }
                byte[] r3 = r3.sufVideoBytes1     // Catch:{ OutOfMemoryError -> 0x010b }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r4 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x010b }
                byte[] r4 = r4.sufVideoBytes1     // Catch:{ OutOfMemoryError -> 0x010b }
                int r4 = r4.length     // Catch:{ OutOfMemoryError -> 0x010b }
                android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeByteArray(r3, r2, r4)     // Catch:{ OutOfMemoryError -> 0x010b }
                r0.bitmap11 = r2     // Catch:{ OutOfMemoryError -> 0x010b }
                goto L_0x0112
            L_0x0088:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x010b }
                int r0 = r0.image1IsH264     // Catch:{ OutOfMemoryError -> 0x010b }
                if (r0 != r1) goto L_0x0112
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x010b }
                int r0 = r0.image1Width     // Catch:{ OutOfMemoryError -> 0x010b }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r3 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x010b }
                int r3 = r3.image1Higth     // Catch:{ OutOfMemoryError -> 0x010b }
                int r0 = r0 * r3
                int r0 = r0 * 2
                byte[] r0 = new byte[r0]     // Catch:{ OutOfMemoryError -> 0x010b }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r3 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x010b }
                byte[] r3 = r3.sufVideoBytes1     // Catch:{ OutOfMemoryError -> 0x010b }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r4 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x010b }
                int r4 = r4.image1Width     // Catch:{ OutOfMemoryError -> 0x010b }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r5 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x010b }
                int r5 = r5.image1Higth     // Catch:{ OutOfMemoryError -> 0x010b }
                object.p2pipcam.nativecaller.NativeCaller.YUV4202RGB565(r3, r0, r4, r5)     // Catch:{ OutOfMemoryError -> 0x010b }
                java.nio.ByteBuffer r0 = java.nio.ByteBuffer.wrap(r0)     // Catch:{ OutOfMemoryError -> 0x010b }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r3 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x010b }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r4 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x010b }
                int r4 = r4.image1Width     // Catch:{ OutOfMemoryError -> 0x010b }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r5 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x010b }
                int r5 = r5.image1Higth     // Catch:{ OutOfMemoryError -> 0x010b }
                android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ OutOfMemoryError -> 0x010b }
                android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r4, r5, r6)     // Catch:{ OutOfMemoryError -> 0x010b }
                r3.bitmap11 = r4     // Catch:{ OutOfMemoryError -> 0x010b }
                r0.rewind()     // Catch:{ Exception -> 0x00dd }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r3 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ Exception -> 0x00dd }
                android.graphics.Bitmap r3 = r3.bitmap11     // Catch:{ Exception -> 0x00dd }
                r3.copyPixelsFromBuffer(r0)     // Catch:{ Exception -> 0x00dd }
                r0.position(r2)     // Catch:{ Exception -> 0x00dd }
                goto L_0x0112
            L_0x00dd:
                android.os.Message r0 = new android.os.Message     // Catch:{ OutOfMemoryError -> 0x010b }
                r0.<init>()     // Catch:{ OutOfMemoryError -> 0x010b }
                android.os.Bundle r2 = new android.os.Bundle     // Catch:{ OutOfMemoryError -> 0x010b }
                r2.<init>()     // Catch:{ OutOfMemoryError -> 0x010b }
                java.lang.String r3 = "no_line_did"
                com.shix.shixipc.activity.IpcamClientActivityFourTest r4 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x010b }
                android.widget.ImageView r4 = r4.imageView1     // Catch:{ OutOfMemoryError -> 0x010b }
                java.lang.Object r4 = r4.getTag()     // Catch:{ OutOfMemoryError -> 0x010b }
                java.lang.String r4 = r4.toString()     // Catch:{ OutOfMemoryError -> 0x010b }
                r2.putString(r3, r4)     // Catch:{ OutOfMemoryError -> 0x010b }
                r3 = 110(0x6e, float:1.54E-43)
                r0.what = r3     // Catch:{ OutOfMemoryError -> 0x010b }
                r0.setData(r2)     // Catch:{ OutOfMemoryError -> 0x010b }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r2 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x010b }
                android.os.Handler r2 = r2.noLineHandler     // Catch:{ OutOfMemoryError -> 0x010b }
                r2.sendMessage(r0)     // Catch:{ OutOfMemoryError -> 0x010b }
                goto L_0x0112
            L_0x010b:
                java.lang.String r0 = "tag"
                java.lang.String r2 = "�ڴ����"
                android.util.Log.e(r0, r2)
            L_0x0112:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                android.graphics.Bitmap r0 = r0.bitmap11
                if (r0 != 0) goto L_0x0121
                java.lang.String r0 = "play"
                java.lang.String r1 = "play_four_1"
                android.util.Log.d(r0, r1)
                goto L_0x0000
            L_0x0121:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                boolean unused = r0.copyTag1 = r1
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                android.os.Handler r0 = r0.PPPPMsgHandler
                r1 = 1213(0x4bd, float:1.7E-42)
                r0.sendEmptyMessage(r1)
                goto L_0x0000
            L_0x0133:
                super.run()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.IpcamClientActivityFourTest.MyImage1Threak.run():void");
        }
    }

    class MyImage2Threak extends Thread {
        MyImage2Threak() {
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:26|27|28|29|30) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00c1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
            L_0x0000:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                boolean r0 = r0.ssidTag2
                if (r0 == 0) goto L_0x0117
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                int r0 = r0.connectionTag2
                r1 = 0
                r2 = 1
                if (r0 != r2) goto L_0x0021
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                com.shix.shixipc.activity.IpcamClientActivityFourTest$MyImage2Threak$1 r3 = new com.shix.shixipc.activity.IpcamClientActivityFourTest$MyImage2Threak$1
                r3.<init>()
                r0.runOnUiThread(r3)
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                int unused = r0.connectionTag2 = r1
            L_0x0021:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                int r0 = r0.connectionTag2
                r3 = 200(0xc8, double:9.9E-322)
                if (r0 == 0) goto L_0x0034
                java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x002f }
                goto L_0x0000
            L_0x002f:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x0000
            L_0x0034:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                int r0 = r0.ifImageTag2
                if (r0 != r2) goto L_0x0000
                java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x0040 }
                goto L_0x0044
            L_0x0040:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0044:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                boolean r0 = r0.copyTag2
                if (r0 == 0) goto L_0x0000
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                boolean unused = r0.copyTag2 = r1
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r0 = r0.image2IsH264     // Catch:{ OutOfMemoryError -> 0x00ef }
                if (r0 != 0) goto L_0x006c
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r3 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                byte[] r3 = r3.sufVideoBytes2     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r4 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                byte[] r4 = r4.sufVideoBytes2     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r4 = r4.length     // Catch:{ OutOfMemoryError -> 0x00ef }
                android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeByteArray(r3, r1, r4)     // Catch:{ OutOfMemoryError -> 0x00ef }
                r0.bitmap22 = r1     // Catch:{ OutOfMemoryError -> 0x00ef }
                goto L_0x00f6
            L_0x006c:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r0 = r0.image2IsH264     // Catch:{ OutOfMemoryError -> 0x00ef }
                if (r0 != r2) goto L_0x00f6
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r0 = r0.image2Width     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r3 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r3 = r3.image2Higth     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r0 = r0 * r3
                int r0 = r0 * 2
                byte[] r0 = new byte[r0]     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r3 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                byte[] r3 = r3.sufVideoBytes2     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r4 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r4 = r4.image2Width     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r5 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r5 = r5.image2Higth     // Catch:{ OutOfMemoryError -> 0x00ef }
                object.p2pipcam.nativecaller.NativeCaller.YUV4202RGB565(r3, r0, r4, r5)     // Catch:{ OutOfMemoryError -> 0x00ef }
                java.nio.ByteBuffer r0 = java.nio.ByteBuffer.wrap(r0)     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r3 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r4 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r4 = r4.image2Width     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r5 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r5 = r5.image2Higth     // Catch:{ OutOfMemoryError -> 0x00ef }
                android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ OutOfMemoryError -> 0x00ef }
                android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r4, r5, r6)     // Catch:{ OutOfMemoryError -> 0x00ef }
                r3.bitmap22 = r4     // Catch:{ OutOfMemoryError -> 0x00ef }
                r0.rewind()     // Catch:{ Exception -> 0x00c1 }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r3 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ Exception -> 0x00c1 }
                android.graphics.Bitmap r3 = r3.bitmap22     // Catch:{ Exception -> 0x00c1 }
                r3.copyPixelsFromBuffer(r0)     // Catch:{ Exception -> 0x00c1 }
                r0.position(r1)     // Catch:{ Exception -> 0x00c1 }
                goto L_0x00f6
            L_0x00c1:
                android.os.Message r0 = new android.os.Message     // Catch:{ OutOfMemoryError -> 0x00ef }
                r0.<init>()     // Catch:{ OutOfMemoryError -> 0x00ef }
                android.os.Bundle r1 = new android.os.Bundle     // Catch:{ OutOfMemoryError -> 0x00ef }
                r1.<init>()     // Catch:{ OutOfMemoryError -> 0x00ef }
                java.lang.String r3 = "no_line_did"
                com.shix.shixipc.activity.IpcamClientActivityFourTest r4 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                android.widget.ImageView r4 = r4.imageView2     // Catch:{ OutOfMemoryError -> 0x00ef }
                java.lang.Object r4 = r4.getTag()     // Catch:{ OutOfMemoryError -> 0x00ef }
                java.lang.String r4 = r4.toString()     // Catch:{ OutOfMemoryError -> 0x00ef }
                r1.putString(r3, r4)     // Catch:{ OutOfMemoryError -> 0x00ef }
                r3 = 110(0x6e, float:1.54E-43)
                r0.what = r3     // Catch:{ OutOfMemoryError -> 0x00ef }
                r0.setData(r1)     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r1 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                android.os.Handler r1 = r1.noLineHandler     // Catch:{ OutOfMemoryError -> 0x00ef }
                r1.sendMessage(r0)     // Catch:{ OutOfMemoryError -> 0x00ef }
                goto L_0x00f6
            L_0x00ef:
                java.lang.String r0 = "tag"
                java.lang.String r1 = "�ڴ����"
                android.util.Log.e(r0, r1)
            L_0x00f6:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                android.graphics.Bitmap r0 = r0.bitmap22
                if (r0 != 0) goto L_0x0105
                java.lang.String r0 = "play"
                java.lang.String r1 = "play_four_2"
                android.util.Log.d(r0, r1)
                goto L_0x0000
            L_0x0105:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                boolean unused = r0.copyTag2 = r2
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                android.os.Handler r0 = r0.PPPPMsgHandler
                r1 = 1214(0x4be, float:1.701E-42)
                r0.sendEmptyMessage(r1)
                goto L_0x0000
            L_0x0117:
                super.run()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.IpcamClientActivityFourTest.MyImage2Threak.run():void");
        }
    }

    class MyImage3Threak extends Thread {
        MyImage3Threak() {
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:26|27|28|29|30) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00c1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
            L_0x0000:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                boolean r0 = r0.ssidTag3
                if (r0 == 0) goto L_0x0117
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                int r0 = r0.connectionTag3
                r1 = 0
                r2 = 1
                if (r0 != r2) goto L_0x0021
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                com.shix.shixipc.activity.IpcamClientActivityFourTest$MyImage3Threak$1 r3 = new com.shix.shixipc.activity.IpcamClientActivityFourTest$MyImage3Threak$1
                r3.<init>()
                r0.runOnUiThread(r3)
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                int unused = r0.connectionTag3 = r1
            L_0x0021:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                int r0 = r0.connectionTag3
                r3 = 200(0xc8, double:9.9E-322)
                if (r0 == 0) goto L_0x0034
                java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x002f }
                goto L_0x0000
            L_0x002f:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x0000
            L_0x0034:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                int r0 = r0.ifImageTag3
                if (r0 != r2) goto L_0x0000
                java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x0040 }
                goto L_0x0044
            L_0x0040:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0044:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                boolean r0 = r0.copyTag3
                if (r0 == 0) goto L_0x0000
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                boolean unused = r0.copyTag3 = r1
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r0 = r0.image3IsH264     // Catch:{ OutOfMemoryError -> 0x00ef }
                if (r0 != 0) goto L_0x006c
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r3 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                byte[] r3 = r3.sufVideoBytes3     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r4 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                byte[] r4 = r4.sufVideoBytes3     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r4 = r4.length     // Catch:{ OutOfMemoryError -> 0x00ef }
                android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeByteArray(r3, r1, r4)     // Catch:{ OutOfMemoryError -> 0x00ef }
                r0.bitmap33 = r1     // Catch:{ OutOfMemoryError -> 0x00ef }
                goto L_0x00f6
            L_0x006c:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r0 = r0.image3IsH264     // Catch:{ OutOfMemoryError -> 0x00ef }
                if (r0 != r2) goto L_0x00f6
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r0 = r0.image3Width     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r3 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r3 = r3.image3Higth     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r0 = r0 * r3
                int r0 = r0 * 2
                byte[] r0 = new byte[r0]     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r3 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                byte[] r3 = r3.sufVideoBytes3     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r4 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r4 = r4.image3Width     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r5 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r5 = r5.image3Higth     // Catch:{ OutOfMemoryError -> 0x00ef }
                object.p2pipcam.nativecaller.NativeCaller.YUV4202RGB565(r3, r0, r4, r5)     // Catch:{ OutOfMemoryError -> 0x00ef }
                java.nio.ByteBuffer r0 = java.nio.ByteBuffer.wrap(r0)     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r3 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r4 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r4 = r4.image3Width     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r5 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r5 = r5.image3Higth     // Catch:{ OutOfMemoryError -> 0x00ef }
                android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ OutOfMemoryError -> 0x00ef }
                android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r4, r5, r6)     // Catch:{ OutOfMemoryError -> 0x00ef }
                r3.bitmap33 = r4     // Catch:{ OutOfMemoryError -> 0x00ef }
                r0.rewind()     // Catch:{ Exception -> 0x00c1 }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r3 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ Exception -> 0x00c1 }
                android.graphics.Bitmap r3 = r3.bitmap33     // Catch:{ Exception -> 0x00c1 }
                r3.copyPixelsFromBuffer(r0)     // Catch:{ Exception -> 0x00c1 }
                r0.position(r1)     // Catch:{ Exception -> 0x00c1 }
                goto L_0x00f6
            L_0x00c1:
                android.os.Message r0 = new android.os.Message     // Catch:{ OutOfMemoryError -> 0x00ef }
                r0.<init>()     // Catch:{ OutOfMemoryError -> 0x00ef }
                android.os.Bundle r1 = new android.os.Bundle     // Catch:{ OutOfMemoryError -> 0x00ef }
                r1.<init>()     // Catch:{ OutOfMemoryError -> 0x00ef }
                java.lang.String r3 = "no_line_did"
                com.shix.shixipc.activity.IpcamClientActivityFourTest r4 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                android.widget.ImageView r4 = r4.imageView3     // Catch:{ OutOfMemoryError -> 0x00ef }
                java.lang.Object r4 = r4.getTag()     // Catch:{ OutOfMemoryError -> 0x00ef }
                java.lang.String r4 = r4.toString()     // Catch:{ OutOfMemoryError -> 0x00ef }
                r1.putString(r3, r4)     // Catch:{ OutOfMemoryError -> 0x00ef }
                r3 = 110(0x6e, float:1.54E-43)
                r0.what = r3     // Catch:{ OutOfMemoryError -> 0x00ef }
                r0.setData(r1)     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r1 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                android.os.Handler r1 = r1.noLineHandler     // Catch:{ OutOfMemoryError -> 0x00ef }
                r1.sendMessage(r0)     // Catch:{ OutOfMemoryError -> 0x00ef }
                goto L_0x00f6
            L_0x00ef:
                java.lang.String r0 = "tag"
                java.lang.String r1 = "�ڴ����"
                android.util.Log.e(r0, r1)
            L_0x00f6:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                android.graphics.Bitmap r0 = r0.bitmap33
                if (r0 != 0) goto L_0x0105
                java.lang.String r0 = "play"
                java.lang.String r1 = "play_four_3"
                android.util.Log.d(r0, r1)
                goto L_0x0000
            L_0x0105:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                boolean unused = r0.copyTag3 = r2
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                android.os.Handler r0 = r0.PPPPMsgHandler
                r1 = 1215(0x4bf, float:1.703E-42)
                r0.sendEmptyMessage(r1)
                goto L_0x0000
            L_0x0117:
                super.run()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.IpcamClientActivityFourTest.MyImage3Threak.run():void");
        }
    }

    class MyImage4Threak extends Thread {
        MyImage4Threak() {
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:26|27|28|29|30) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00c1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
            L_0x0000:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                boolean r0 = r0.ssidTag4
                if (r0 == 0) goto L_0x0117
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                int r0 = r0.connectionTag4
                r1 = 0
                r2 = 1
                if (r0 != r2) goto L_0x0021
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                com.shix.shixipc.activity.IpcamClientActivityFourTest$MyImage4Threak$1 r3 = new com.shix.shixipc.activity.IpcamClientActivityFourTest$MyImage4Threak$1
                r3.<init>()
                r0.runOnUiThread(r3)
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                int unused = r0.connectionTag4 = r1
            L_0x0021:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                int r0 = r0.connectionTag4
                r3 = 200(0xc8, double:9.9E-322)
                if (r0 == 0) goto L_0x0034
                java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x002f }
                goto L_0x0000
            L_0x002f:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x0000
            L_0x0034:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                int r0 = r0.ifImageTag4
                if (r0 != r2) goto L_0x0000
                java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x0040 }
                goto L_0x0044
            L_0x0040:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0044:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                boolean r0 = r0.copyTag4
                if (r0 == 0) goto L_0x0000
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                boolean unused = r0.copyTag4 = r1
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r0 = r0.image4IsH264     // Catch:{ OutOfMemoryError -> 0x00ef }
                if (r0 != 0) goto L_0x006c
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r3 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                byte[] r3 = r3.sufVideoBytes4     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r4 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                byte[] r4 = r4.sufVideoBytes4     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r4 = r4.length     // Catch:{ OutOfMemoryError -> 0x00ef }
                android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeByteArray(r3, r1, r4)     // Catch:{ OutOfMemoryError -> 0x00ef }
                r0.bitmap44 = r1     // Catch:{ OutOfMemoryError -> 0x00ef }
                goto L_0x00f6
            L_0x006c:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r0 = r0.image4IsH264     // Catch:{ OutOfMemoryError -> 0x00ef }
                if (r0 != r2) goto L_0x00f6
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r0 = r0.image4Width     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r3 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r3 = r3.image4Higth     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r0 = r0 * r3
                int r0 = r0 * 2
                byte[] r0 = new byte[r0]     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r3 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                byte[] r3 = r3.sufVideoBytes4     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r4 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r4 = r4.image4Width     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r5 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r5 = r5.image4Higth     // Catch:{ OutOfMemoryError -> 0x00ef }
                object.p2pipcam.nativecaller.NativeCaller.YUV4202RGB565(r3, r0, r4, r5)     // Catch:{ OutOfMemoryError -> 0x00ef }
                java.nio.ByteBuffer r0 = java.nio.ByteBuffer.wrap(r0)     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r3 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r4 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r4 = r4.image4Width     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r5 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                int r5 = r5.image4Higth     // Catch:{ OutOfMemoryError -> 0x00ef }
                android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ OutOfMemoryError -> 0x00ef }
                android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r4, r5, r6)     // Catch:{ OutOfMemoryError -> 0x00ef }
                r3.bitmap44 = r4     // Catch:{ OutOfMemoryError -> 0x00ef }
                r0.rewind()     // Catch:{ Exception -> 0x00c1 }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r3 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ Exception -> 0x00c1 }
                android.graphics.Bitmap r3 = r3.bitmap44     // Catch:{ Exception -> 0x00c1 }
                r3.copyPixelsFromBuffer(r0)     // Catch:{ Exception -> 0x00c1 }
                r0.position(r1)     // Catch:{ Exception -> 0x00c1 }
                goto L_0x00f6
            L_0x00c1:
                android.os.Message r0 = new android.os.Message     // Catch:{ OutOfMemoryError -> 0x00ef }
                r0.<init>()     // Catch:{ OutOfMemoryError -> 0x00ef }
                android.os.Bundle r1 = new android.os.Bundle     // Catch:{ OutOfMemoryError -> 0x00ef }
                r1.<init>()     // Catch:{ OutOfMemoryError -> 0x00ef }
                java.lang.String r3 = "no_line_did"
                com.shix.shixipc.activity.IpcamClientActivityFourTest r4 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                android.widget.ImageView r4 = r4.imageView4     // Catch:{ OutOfMemoryError -> 0x00ef }
                java.lang.Object r4 = r4.getTag()     // Catch:{ OutOfMemoryError -> 0x00ef }
                java.lang.String r4 = r4.toString()     // Catch:{ OutOfMemoryError -> 0x00ef }
                r1.putString(r3, r4)     // Catch:{ OutOfMemoryError -> 0x00ef }
                r3 = 110(0x6e, float:1.54E-43)
                r0.what = r3     // Catch:{ OutOfMemoryError -> 0x00ef }
                r0.setData(r1)     // Catch:{ OutOfMemoryError -> 0x00ef }
                com.shix.shixipc.activity.IpcamClientActivityFourTest r1 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this     // Catch:{ OutOfMemoryError -> 0x00ef }
                android.os.Handler r1 = r1.noLineHandler     // Catch:{ OutOfMemoryError -> 0x00ef }
                r1.sendMessage(r0)     // Catch:{ OutOfMemoryError -> 0x00ef }
                goto L_0x00f6
            L_0x00ef:
                java.lang.String r0 = "tag"
                java.lang.String r1 = "�ڴ����"
                android.util.Log.e(r0, r1)
            L_0x00f6:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                android.graphics.Bitmap r0 = r0.bitmap44
                if (r0 != 0) goto L_0x0105
                java.lang.String r0 = "play"
                java.lang.String r1 = "play_four_4"
                android.util.Log.d(r0, r1)
                goto L_0x0000
            L_0x0105:
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                boolean unused = r0.copyTag4 = r2
                com.shix.shixipc.activity.IpcamClientActivityFourTest r0 = com.shix.shixipc.activity.IpcamClientActivityFourTest.this
                android.os.Handler r0 = r0.PPPPMsgHandler
                r1 = 1216(0x4c0, float:1.704E-42)
                r0.sendEmptyMessage(r1)
                goto L_0x0000
            L_0x0117:
                super.run()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.IpcamClientActivityFourTest.MyImage4Threak.run():void");
        }
    }

    private void imageSetTag(ImageView imageView, ImageView imageView5, ImageView imageView6, ImageView imageView7, String str, String str2) {
        if (this.imageView1.getTag().toString().equalsIgnoreCase("1")) {
            this.connectionTag1 = 2;
            this.imageView1.setTag(str);
            this.textView1.setVisibility(0);
            this.connection_show1.setVisibility(0);
            this.textView1.setText(str2);
            this.name1 = str2;
            this.imageTag1 = 1;
            this.ssidTag1 = true;
            new Thread() {
                public void run() {
                    NativeCaller.StartPPPPLivestream(IpcamClientActivityFourTest.this.imageView1.getTag().toString(), 2);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    new MyImage1Threak().start();
                }
            }.start();
        } else if (this.imageView2.getTag().toString().equalsIgnoreCase("1")) {
            this.connectionTag2 = 2;
            this.imageView2.setTag(str);
            this.textView2.setVisibility(0);
            this.textView2.setText(str2);
            this.connection_show2.setVisibility(0);
            this.name2 = str2;
            this.imageTag2 = 1;
            this.ssidTag2 = true;
            new Thread() {
                public void run() {
                    NativeCaller.StartPPPPLivestream(IpcamClientActivityFourTest.this.imageView2.getTag().toString(), 2);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    new MyImage2Threak().start();
                }
            }.start();
        } else if (this.imageView3.getTag().toString().equalsIgnoreCase("1")) {
            this.connectionTag3 = 2;
            this.imageView3.setTag(str);
            this.textView3.setVisibility(0);
            this.textView3.setText(str2);
            this.connection_show3.setVisibility(0);
            this.name3 = str2;
            this.imageTag3 = 1;
            this.ssidTag3 = true;
            new Thread() {
                public void run() {
                    NativeCaller.StartPPPPLivestream(IpcamClientActivityFourTest.this.imageView3.getTag().toString(), 2);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    new MyImage3Threak().start();
                }
            }.start();
        } else if (this.imageView4.getTag().toString().equalsIgnoreCase("1")) {
            this.connectionTag4 = 2;
            this.imageView4.setTag(str);
            this.textView4.setVisibility(0);
            this.textView4.setText(str2);
            this.connection_show4.setVisibility(0);
            this.name4 = str2;
            this.imageTag4 = 1;
            this.ssidTag4 = true;
            new Thread() {
                public void run() {
                    NativeCaller.StartPPPPLivestream(IpcamClientActivityFourTest.this.imageView4.getTag().toString(), 2);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    new MyImage4Threak().start();
                }
            }.start();
        }
    }

    public void callBaceVideoData(String str, byte[] bArr, int i, int i2, int i3, int i4) {
        if (!this.PlayTag) {
            return;
        }
        if (str.equalsIgnoreCase(this.imageView1.getTag().toString())) {
            if (this.copyTag1) {
                if (this.connectionTag1 == 2) {
                    this.connectionTag1 = 1;
                }
                this.sufVideoBytes1 = bArr;
                this.image1IsH264 = i;
                this.image1Width = i3;
                this.image1Higth = i4;
                this.ifImageTag1 = 1;
            }
        } else if (str.equalsIgnoreCase(this.imageView2.getTag().toString())) {
            if (this.copyTag2) {
                if (this.connectionTag2 == 2) {
                    this.connectionTag2 = 1;
                }
                this.sufVideoBytes2 = bArr;
                this.image2IsH264 = i;
                this.image2Width = i3;
                this.image2Higth = i4;
                this.ifImageTag2 = 1;
            }
        } else if (str.equalsIgnoreCase(this.imageView3.getTag().toString())) {
            if (this.copyTag3) {
                if (this.connectionTag3 == 2) {
                    this.connectionTag3 = 1;
                }
                this.sufVideoBytes3 = bArr;
                this.image3IsH264 = i;
                this.image3Width = i3;
                this.image3Higth = i4;
                this.ifImageTag3 = 1;
            }
        } else if (str.equalsIgnoreCase(this.imageView4.getTag().toString()) && this.copyTag4) {
            if (this.connectionTag4 == 2) {
                this.connectionTag4 = 1;
            }
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
            case R.id.imageView1 /*2131165510*/:
                if (this.imageTag1 == 1) {
                    this.TAGPlay = 1;
                    if (this.ifHind) {
                        this.popupWindow_about.showAtLocation(this.imageView1, 0, ((this.screenWidth * 8) / 44) - 50, (((this.screenHeight / 2) - 40) / 2) - 40);
                        break;
                    } else {
                        this.popupWindow_about.showAtLocation(this.imageView1, 0, (this.screenWidth / 4) - 40, (((this.screenHeight / 2) - 40) / 2) - 40);
                        break;
                    }
                }
                break;
            case R.id.imageView2 /*2131165511*/:
                if (this.imageTag2 == 1) {
                    this.TAGPlay = 2;
                    if (this.ifHind) {
                        PopupWindow popupWindow = this.popupWindow_about;
                        ImageView imageView = this.imageView2;
                        int i = this.screenWidth;
                        int i2 = ((i * 8) / 22) + (((i * 8) / 44) - 50);
                        int i3 = this.screenHeight;
                        popupWindow.showAtLocation(imageView, 0, i2, (i3 / 2) + ((((i3 / 2) - 40) / 2) - 40));
                        break;
                    } else {
                        int i4 = this.screenHeight;
                        this.popupWindow_about.showAtLocation(this.imageView2, 0, ((this.screenWidth * 3) / 4) - 40, (i4 / 2) + ((((i4 / 2) - 40) / 2) - 40));
                        break;
                    }
                }
                break;
            case R.id.imageView3 /*2131165512*/:
                if (this.imageTag3 == 1) {
                    this.TAGPlay = 3;
                    if (this.ifHind) {
                        int i5 = this.screenHeight;
                        this.popupWindow_about.showAtLocation(this.imageView1, 0, ((this.screenWidth * 8) / 44) - 50, ((i5 / 2) + (((i5 / 2) - 40) / 2)) - 40);
                        break;
                    } else {
                        int i6 = this.screenHeight;
                        this.popupWindow_about.showAtLocation(this.imageView1, 0, (this.screenWidth / 4) - 40, ((i6 / 2) + (((i6 / 2) - 40) / 2)) - 40);
                        break;
                    }
                }
                break;
            case R.id.imageView4 /*2131165513*/:
                if (this.imageTag4 == 1) {
                    this.TAGPlay = 4;
                    if (this.ifHind) {
                        PopupWindow popupWindow2 = this.popupWindow_about;
                        ImageView imageView5 = this.imageView2;
                        int i7 = this.screenWidth;
                        popupWindow2.showAtLocation(imageView5, 0, ((i7 * 8) / 22) + (((i7 * 8) / 44) - 50), (((this.screenHeight / 2) - 40) / 2) - 40);
                        break;
                    } else {
                        this.popupWindow_about.showAtLocation(this.imageView2, 0, ((this.screenWidth * 3) / 4) - 40, (((this.screenHeight / 2) - 40) / 2) - 40);
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
