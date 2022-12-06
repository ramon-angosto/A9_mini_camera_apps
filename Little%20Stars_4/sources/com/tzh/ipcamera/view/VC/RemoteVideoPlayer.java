package com.tzh.ipcamera.view.VC;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.jxl.app.littlestars.project.R;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tzh.ipcamera.model.CustomBuffer;
import com.tzh.ipcamera.model.CustomBufferData;
import com.tzh.ipcamera.model.CustomBufferHead;
import com.tzh.ipcamera.presenter.LogUtils;
import com.tzh.ipcamera.view.SurfaceViews;
import object.p2pipcam.bean.MovieInfo;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.AudioPlayer;
import object.p2pipcam.utils.DataBaseHelper;
import object.p2pipcam.utils.TakeVideoThread;
import shix.ihdbell.project.BaseActivity;
import shix.ihdbell.project.BridgeService;

public class RemoteVideoPlayer extends BaseActivity implements BridgeService.PlayInterface, BridgeService.DoorBellSystemParmInterface, View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private static final int AUDIO_BUFFER_START_CODE = 16711935;
    private static final int CMD_PTZ_VIEW_CON_REQ = 19;
    private static final int CMD_PTZ_VIEW_FILE_REQ = 18;
    private static final String LOG_TAG = "RemoteVideoPlayer";
    /* access modifiers changed from: private */
    public static boolean isSendStartCmd = false;
    private static final int msgReConnect = 8;
    private static final int msgReStart = 9;
    private static final int msgReSuccess = 10;
    private CustomBuffer AudioBuffer = null;
    private AudioPlayer audioPlayer = null;
    private boolean bAudioStart = true;
    private ImageView btnUpload = null;
    private int curHideTime = 0;
    /* access modifiers changed from: private */
    public RelativeLayout imgVProcess_ly_play = null;
    private String index = null;
    /* access modifiers changed from: private */
    public boolean isPlaying = true;
    private ImageView iv_next = null;
    /* access modifiers changed from: private */
    public ImageView iv_pause = null;
    private ImageView iv_prev = null;
    private ImageView iv_stop = null;
    LogUtils logUtils = LogUtils.setLogger(RemoteVideoPlayer.class);
    private RelativeLayout ly_status_videoplayer = null;
    private RelativeLayout ly_video_time = null;
    /* access modifiers changed from: private */
    public Bitmap mBmp;
    Handler mHandler = new Handler() {
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 2) {
                RemoteVideoPlayer remoteVideoPlayer = RemoteVideoPlayer.this;
                Bitmap unused = remoteVideoPlayer.mBmp = BitmapFactory.decodeByteArray(remoteVideoPlayer.videodata, 0, RemoteVideoPlayer.this.videoDataLen);
                if (RemoteVideoPlayer.this.mBmp == null) {
                    Log.d(RemoteVideoPlayer.LOG_TAG, "bmp can't be decode...");
                    return;
                }
                RemoteVideoPlayer.this.logUtils.e("###you have recive a bitmap!");
                RemoteVideoPlayer.this.mSurface.SetBitmap(RemoteVideoPlayer.this.mBmp);
            } else if (i == 8) {
                NativeCaller.StopPPPPLivestream(RemoteVideoPlayer.this.strDID);
                boolean unused2 = RemoteVideoPlayer.isSendStartCmd = false;
                RemoteVideoPlayer.this.imgVProcess_ly_play.setVisibility(0);
                new GetDataTask().execute(new Void[0]);
            } else if (i == 9) {
                boolean unused3 = RemoteVideoPlayer.isSendStartCmd = true;
                RemoteVideoPlayer remoteVideoPlayer2 = RemoteVideoPlayer.this;
                String unused4 = remoteVideoPlayer2.pushUUID = (((int) (Math.random() * 900.0d)) + 100) + "";
                if (RemoteVideoPlayer.this.strDID.length() > 3) {
                    if (RemoteVideoPlayer.this.pushTypeInt == 3) {
                        NativeCaller.StartPPPPLivestream(RemoteVideoPlayer.this.strDID, 20, RemoteVideoPlayer.this.pushUUID, SystemValue.videFram);
                    } else {
                        NativeCaller.StartPPPPLivestream(RemoteVideoPlayer.this.strDID, 22, RemoteVideoPlayer.this.pushUUID, SystemValue.videFram);
                    }
                }
                RemoteVideoPlayer.this.startVideo();
                RemoteVideoPlayer.this.StartAudio();
                boolean unused5 = RemoteVideoPlayer.this.isPlaying = true;
                RemoteVideoPlayer.this.iv_pause.setImageResource(R.drawable.alarm_play_btn);
                RemoteVideoPlayer.this.imgVProcess_ly_play.setVisibility(4);
            }
        }
    };
    private MovieInfo mMoveInfo = null;
    /* access modifiers changed from: private */
    public SurfaceViews mSurface = null;
    private boolean p2p_STATUS = true;
    /* access modifiers changed from: private */
    public int pushTypeInt = 0;
    /* access modifiers changed from: private */
    public String pushUUID = PushConstants.PUSH_TYPE_NOTIFY;
    private SeekBar sb_time = null;
    private SeekBar sb_voice = null;
    private long startTime = 0;
    /* access modifiers changed from: private */
    public String strDID = null;
    private String strName = null;
    /* access modifiers changed from: private */
    public String strPwd = null;
    /* access modifiers changed from: private */
    public String strUser = null;
    private LinearLayout surfaceLayout = null;
    private TakeVideoThread takeVideoThread = null;
    private final String totalTime = "00:02:00";
    private TextView tvReturn = null;
    private TextView tv_cur_time = null;
    private TextView tv_left_time = null;
    /* access modifiers changed from: private */
    public int videoDataLen = 0;
    /* access modifiers changed from: private */
    public byte[] videodata = null;
    private RelativeLayout vpScreenLayout = null;
    PowerManager.WakeLock wakeLock = null;

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"InvalidWakeLockTag"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        setContentView(R.layout.videoplayer);
        this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(268435466, "MyWakeLock");
        getIntentVal();
        widget_init();
        this.AudioBuffer = new CustomBuffer();
        this.audioPlayer = new AudioPlayer(this, this.AudioBuffer);
        BridgeService.setPlayInterface(this);
        BridgeService.setDoorBellSystemParmInterface(this);
        startVideo();
        StartAudio();
    }

    private void widget_init() {
        this.mSurface = (SurfaceViews) findViewById(R.id.videoPlaySurface);
        this.surfaceLayout = (LinearLayout) findViewById(R.id.surfaceLayout);
        this.vpScreenLayout = (RelativeLayout) findViewById(R.id.vpscreenLayout);
        this.tv_cur_time = (TextView) findViewById(R.id.tv_cur_time_videoplayer);
        this.tv_left_time = (TextView) findViewById(R.id.tv_left_time_videoplayer);
        this.iv_stop = (ImageView) findViewById(R.id.iv_stop_videoplayer);
        this.iv_prev = (ImageView) findViewById(R.id.iv_prev_videoplayer);
        this.iv_next = (ImageView) findViewById(R.id.iv_next_videoplayer);
        this.tvReturn = (TextView) findViewById(R.id.back);
        this.iv_pause = (ImageView) findViewById(R.id.iv_pause_videoplayer);
        this.sb_time = (SeekBar) findViewById(R.id.sb_timebar_videoplayer);
        this.sb_voice = (SeekBar) findViewById(R.id.sb_voice_control_videoplayer);
        this.ly_video_time = (RelativeLayout) findViewById(R.id.ly_video_time);
        this.imgVProcess_ly_play = (RelativeLayout) findViewById(R.id.imgVProcess_ly_play);
        this.ly_status_videoplayer = (RelativeLayout) findViewById(R.id.ly_status_videoplayer);
        this.iv_stop.setOnClickListener(this);
        this.iv_pause.setOnClickListener(this);
        this.iv_prev.setOnClickListener(this);
        this.iv_next.setOnClickListener(this);
        this.tvReturn.setOnClickListener(this);
        this.sb_time.setOnSeekBarChangeListener(this);
        this.sb_voice.setOnSeekBarChangeListener(this);
        this.ly_video_time.setVisibility(4);
        this.imgVProcess_ly_play.setVisibility(4);
        this.ly_status_videoplayer.setVisibility(4);
        this.sb_time.setMax(120);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            onBackPressed();
        } else if (id == R.id.iv_pause_videoplayer) {
            if (!this.p2p_STATUS) {
                Toast.makeText(this, "P2P连接断开", 0).show();
            } else if (this.isPlaying) {
                pauseVideo();
                this.isPlaying = false;
                this.iv_pause.setImageResource(R.drawable.alarm_pause_btn);
            } else {
                resumeVideo();
                this.isPlaying = true;
                this.iv_pause.setImageResource(R.drawable.alarm_play_btn);
            }
        }
    }

    private void getIntentVal() {
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(DataBaseHelper.KEY_DID);
        this.mMoveInfo = (MovieInfo) intent.getSerializableExtra("MovieInfo");
        this.strUser = intent.getStringExtra(DataBaseHelper.KEY_USER);
        this.strPwd = intent.getStringExtra(DataBaseHelper.KEY_PWD);
        this.pushTypeInt = intent.getIntExtra("pushTypeInt", 3);
        this.index = intent.getStringExtra("index");
        String str = this.pushUUID;
        if (str == null || str.length() < 1) {
            this.pushUUID = (((int) (Math.random() * 900.0d)) + 100) + "";
        }
        if (this.strDID.length() <= 3) {
            return;
        }
        if (this.pushTypeInt == 3) {
            NativeCaller.StartPPPPLivestream(this.strDID, 20, this.pushUUID, SystemValue.videFram);
        } else {
            NativeCaller.StartPPPPLivestream(this.strDID, 22, this.pushUUID, SystemValue.videFram);
        }
    }

    public void startVideo() {
        this.logUtils.e("###开始申请文件回放！");
        NativeCaller.TransferMessage(this.strDID, String.format("/decoder_control.cgi?command=18&onestep=1&user=" + this.strUser + "&pwd=" + this.strPwd + "&index=" + this.index, new Object[0]), 1);
    }

    public void pauseVideo() {
        NativeCaller.PPPPPTZPlayPause(this.strDID);
        this.logUtils.e("###暂停文件回放！");
        NativeCaller.TransferMessage(this.strDID, String.format("/decoder_control.cgi?command=19&onestep=0&user=" + this.strUser + "&pwd=" + this.strPwd, new Object[0]), 1);
    }

    public void resumeVideo() {
        NativeCaller.PPPPPTZPlayPause(this.strDID);
        this.logUtils.e("###继续文件回放！");
        NativeCaller.TransferMessage(this.strDID, String.format("/decoder_control.cgi?command=19&onestep=1&user=" + this.strUser + "&pwd=" + this.strPwd, new Object[0]), 1);
    }

    public void stopVideo() {
        this.logUtils.e("###结束文件回放！");
        NativeCaller.TransferMessage(this.strDID, String.format("/decoder_control.cgi?command=18&onestep=0&user=" + this.strUser + "&pwd=" + this.strPwd, new Object[0]), 1);
    }

    /* access modifiers changed from: private */
    public void StartAudio() {
        synchronized (this) {
            this.bAudioStart = true;
            this.AudioBuffer.ClearAll();
            if (this.audioPlayer != null) {
                Log.e("###", "startPlayAudio");
                this.audioPlayer.AudioPlayStart();
            }
            NativeCaller.PPPPStartAudio(this.strDID);
        }
    }

    private void StopAudio() {
        synchronized (this) {
            this.bAudioStart = false;
            if (this.audioPlayer != null) {
                this.audioPlayer.AudioPlayStop();
            }
            this.AudioBuffer.ClearAll();
            NativeCaller.PPPPStopAudio(this.strDID);
        }
    }

    public void callBaceVideoData(String str, byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        this.p2p_STATUS = true;
        this.mBmp = BitmapFactory.decodeByteArray(bArr, 0, i2);
        if (this.mBmp == null) {
            this.logUtils.e(String.format("bmp can't decord:%02x %02x %02x %02x", new Object[]{Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[i2 - 2]), Byte.valueOf(bArr[i2 - 1])}));
            return;
        }
        this.logUtils.e("###you have recive a bitmap!");
        this.mSurface.SetBitmap(this.mBmp);
        this.mBmp = null;
    }

    public void callBackAudioData(byte[] bArr, int i) {
        this.logUtils.e("###callBackAudioData");
        AudioPlayer audioPlayer2 = this.audioPlayer;
        if (audioPlayer2 == null || audioPlayer2.isAudioPlaying()) {
            this.logUtils.e("###you have recive a audio buffer");
            CustomBufferHead customBufferHead = new CustomBufferHead();
            CustomBufferData customBufferData = new CustomBufferData();
            customBufferHead.length = i;
            customBufferHead.startcode = AUDIO_BUFFER_START_CODE;
            customBufferData.head = customBufferHead;
            customBufferData.data = bArr;
            this.AudioBuffer.addData(customBufferData);
        }
    }

    public void callBackCameraParamNotify(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.logUtils.e("###callBackCameraParamNotify");
    }

    public void callBackH264Data(String str, byte[] bArr, int i, int i2) {
        this.logUtils.e("###callBackH264Data");
    }

    public void callBackDoorBellSystemParm(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.logUtils.e("###callBackDoorBellSystemParm");
    }

    public void callBackMessageNotify(String str, int i, int i2) {
        LogUtils logUtils2 = this.logUtils;
        logUtils2.e("MessageNotify did: " + str + " msgType: " + i + " param: " + i2);
        if (i != 0 || !str.equals(this.strDID)) {
            return;
        }
        if (i2 == 4) {
            this.p2p_STATUS = false;
            this.logUtils.e("###PPPP disconnect");
            Message message = new Message();
            message.what = 8;
            this.mHandler.sendMessage(message);
        } else if (i2 == 2) {
            this.logUtils.e("###PPPP connect success");
            if (!isSendStartCmd) {
                Message message2 = new Message();
                message2.what = 9;
                this.mHandler.sendMessage(message2);
            }
        } else if (i2 == 3 || i2 == 5 || i2 == 6 || i2 == 7 || i2 == 8 || i2 == 9 || i2 == 10 || i2 == -1) {
            this.logUtils.e("###PPPP connect fail");
            Message message3 = new Message();
            message3.what = 8;
            this.mHandler.sendMessage(message3);
        }
    }

    public void CallBackAlermType(String str, int i) {
        this.logUtils.e("###CallBackAlermType");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        StartHeat(this.strDID, SystemValue.doorBellAdmin, SystemValue.doorBellPass);
        PowerManager.WakeLock wakeLock2 = this.wakeLock;
        if (wakeLock2 != null) {
            wakeLock2.acquire();
        }
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        StopHeat();
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        PowerManager.WakeLock wakeLock2 = this.wakeLock;
        if (wakeLock2 != null) {
            wakeLock2.release();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        SystemValue.isStartRun = false;
        if (this.pushTypeInt == 3) {
            NativeCaller.StartPPPPLivestream(this.strDID, 21, this.pushUUID, SystemValue.videFram);
        } else {
            NativeCaller.StartPPPPLivestream(this.strDID, 24, this.pushUUID, SystemValue.videFram);
        }
        StopAudio();
        NativeCaller.StartPPPPLivestream(this.strDID, 42, this.pushUUID, SystemValue.videFram);
        BridgeService.setPlayInterface((BridgeService.PlayInterface) null);
        BridgeService.setDoorBellSystemParmInterface((BridgeService.DoorBellSystemParmInterface) null);
        NativeCaller.StopPPPPLivestream(this.strDID);
        super.onDestroy();
    }

    public void onBackPressed() {
        super.onBackPressed();
        stopVideo();
    }

    private class GetDataTask extends AsyncTask<Void, Void, Void> {
        private GetDataTask() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            if (!SystemValue.ISRUN) {
                BridgeService.isAppClose = false;
                Intent intent = new Intent();
                intent.setClass(RemoteVideoPlayer.this, BridgeService.class);
                RemoteVideoPlayer.this.startService(intent);
                Log.d("tagx", "SystemValue.ISRUN == false--and--server is run to");
                new Thread() {
                    public void run() {
                        NativeCaller.PPPPInitial(SystemValue.SystemSerVer, SystemValue.SystemSerVer.length());
                        NativeCaller.PPPPNetworkDetect();
                        NativeCaller.Init();
                        Log.e("tagx", "GetDataTask  Init");
                    }
                }.start();
            }
        }

        /* access modifiers changed from: private */
        public void StartCameraPPPP() {
            RemoteVideoPlayer remoteVideoPlayer = RemoteVideoPlayer.this;
            remoteVideoPlayer.StartPPPP(remoteVideoPlayer.strDID, RemoteVideoPlayer.this.strUser, RemoteVideoPlayer.this.strPwd, "test");
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... voidArr) {
            new Thread(new StopPPPPThread()).start();
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void voidR) {
            super.onPostExecute(voidR);
        }

        class StopPPPPThread implements Runnable {
            StopPPPPThread() {
            }

            public void run() {
                try {
                    Thread.sleep(500);
                    GetDataTask.this.StartCameraPPPP();
                } catch (Exception unused) {
                }
            }
        }
    }
}
