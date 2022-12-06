package com.shix.shixipc.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import object.p2pipcam.nativecaller.NativeCaller;

public class DoorbellNotifyActivity extends BaseActivity implements View.OnClickListener, NUIMainActivity.SnapShotInterface {
    private static final String TAG = "DoorbellNotifyActivity";
    private static CallInterface cllInterface = null;
    private static boolean isShowing = false;
    private final int PARAMS = 3;
    private AnimationDrawable animationDrawable;
    Bitmap bmp = null;
    String deviceId;
    /* access modifiers changed from: private */
    public Handler exitHandler = new Handler() {
        public void handleMessage(Message message) {
            if (DoorbellNotifyActivity.this.timeCount == 1) {
                SystemValue.isCallIng = false;
                NUIMainActivity.setSnapShotInterface((NUIMainActivity.SnapShotInterface) null);
                DoorbellNotifyActivity.this.finish();
            }
        }
    };
    /* access modifiers changed from: private */
    public ImageView im_show;
    /* access modifiers changed from: private */
    public boolean isCheck = false;
    private ImageView ivGif;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 3 && DoorbellNotifyActivity.this.bmp != null) {
                DoorbellNotifyActivity.this.im_show.setImageBitmap(DoorbellNotifyActivity.this.bmp);
            }
        }
    };
    /* access modifiers changed from: private */
    public MediaPlayer mediaPlayer;
    private String strDid = "";
    private String strName = "";
    private String strPwd = "";
    private String strUser = "";
    /* access modifiers changed from: private */
    public int timeCount = 61;
    private TextView tvAlarmMsg;
    private TextView tvDevName;
    Vibrator vibratorSHIX = null;

    public interface CallInterface {
        void callType(int i);
    }

    static /* synthetic */ int access$010(DoorbellNotifyActivity doorbellNotifyActivity) {
        int i = doorbellNotifyActivity.timeCount;
        doorbellNotifyActivity.timeCount = i - 1;
        return i;
    }

    public static void setVideoTransInterface(CallInterface callInterface) {
        cllInterface = callInterface;
    }

    public void BSSnapshotNotify(String str, byte[] bArr, int i) {
        this.bmp = BitmapFactory.decodeByteArray(bArr, 0, i);
        if (this.bmp == null) {
            Log.d("TAG", "bmp can't be decode...");
        } else {
            this.mHandler.sendEmptyMessage(3);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        SystemValue.isCallIng = true;
        this.strDid = getIntent().getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.strName = getIntent().getStringExtra(ContentCommon.STR_CAMERA_NAME);
        this.strUser = getIntent().getStringExtra(ContentCommon.STR_CAMERA_USER);
        this.strPwd = getIntent().getStringExtra(ContentCommon.STR_CAMERA_PWD);
        isShowing = true;
        setContentView(R.layout.activity_doorbell_notify);
        getWindow().addFlags(1024);
        NUIMainActivity.setSnapShotInterface(this);
        NativeCaller.TransferMessage(this.strDid, CommonUtil.getSnapshot(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
        this.im_show = (ImageView) findViewById(R.id.im_show);
        this.tvDevName = (TextView) findViewById(R.id.tvDevName);
        this.tvAlarmMsg = (TextView) findViewById(R.id.tvAlarmMsg);
        TextView textView = this.tvDevName;
        textView.setText(this.strName + "");
        this.ivGif = (ImageView) findViewById(R.id.ivGif);
        this.animationDrawable = (AnimationDrawable) this.ivGif.getDrawable();
        this.animationDrawable.start();
        findViewById(R.id.ivOpen).setOnClickListener(this);
        findViewById(R.id.ivClose).setOnClickListener(this);
        findViewById(R.id.ivMes).setOnClickListener(this);
        findViewById(R.id.ivAudioOpen).setOnClickListener(this);
        this.timeCount = 61;
        playVoiceAndVibrate();
        refreshTime();
    }

    private void refreshTime() {
        this.isCheck = true;
        new Thread() {
            public void run() {
                while (DoorbellNotifyActivity.this.isCheck) {
                    DoorbellNotifyActivity.access$010(DoorbellNotifyActivity.this);
                    DoorbellNotifyActivity.this.exitHandler.sendMessage(new Message());
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    private void playVoiceAndVibrate() {
        this.mediaPlayer = MediaPlayer.create(this, R.raw.doorbell);
        new Thread(new Runnable() {
            public void run() {
                DoorbellNotifyActivity.this.mediaPlayer.setLooping(true);
                DoorbellNotifyActivity.this.mediaPlayer.start();
            }
        }).start();
        if (this.vibratorSHIX == null) {
            this.vibratorSHIX = (Vibrator) getSystemService("vibrator");
            this.vibratorSHIX.vibrate(new long[]{1000, 1000}, 0);
        }
    }

    private void exit() {
        isShowing = false;
        stopPlay();
        ((AnimationDrawable) this.ivGif.getDrawable()).stop();
        finish();
    }

    private void stopPlay() {
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.pause();
            this.mediaPlayer.stop();
            this.mediaPlayer.release();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ivAudioOpen) {
            Intent intent = new Intent(this, BellLiveActivity.class);
            intent.putExtra(ContentCommon.STR_CAMERA_TYPE, 1);
            intent.putExtra(ContentCommon.STR_STREAM_TYPE, 3);
            intent.putExtra(ContentCommon.STR_CAMERA_NAME, this.strName);
            intent.putExtra(ContentCommon.STR_CAMERA_ID, this.strDid);
            intent.putExtra(ContentCommon.STR_CAMERA_USER, this.strUser);
            intent.putExtra(ContentCommon.STR_CAMERA_PWD, this.strPwd);
            intent.putExtra("callType", 0);
            startActivityForResult(intent, 2);
            this.isCheck = false;
            finish();
        } else if (id == R.id.ivClose) {
            this.isCheck = false;
            SystemValue.isCallIng = false;
            NUIMainActivity.setSnapShotInterface((NUIMainActivity.SnapShotInterface) null);
            finish();
        } else if (id == R.id.ivOpen) {
            Intent intent2 = new Intent(this, BellLiveActivity.class);
            intent2.putExtra(ContentCommon.STR_CAMERA_TYPE, 1);
            intent2.putExtra(ContentCommon.STR_STREAM_TYPE, 3);
            intent2.putExtra(ContentCommon.STR_CAMERA_NAME, this.strName);
            intent2.putExtra(ContentCommon.STR_CAMERA_ID, this.strDid);
            intent2.putExtra(ContentCommon.STR_CAMERA_USER, this.strUser);
            intent2.putExtra(ContentCommon.STR_CAMERA_PWD, this.strPwd);
            intent2.putExtra("callType", 1);
            startActivityForResult(intent2, 2);
            this.isCheck = false;
            finish();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        Intent intent = new Intent(this, NUIMainActivity.class);
        intent.addFlags(335544320);
        startActivity(intent);
        exit();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.isCheck = false;
        Vibrator vibrator = this.vibratorSHIX;
        if (vibrator != null) {
            vibrator.cancel();
            this.vibratorSHIX = null;
        }
        AnimationDrawable animationDrawable2 = this.animationDrawable;
        if (animationDrawable2 != null) {
            animationDrawable2.stop();
        }
        stopPlay();
        this.exitHandler.removeCallbacksAndMessages((Object) null);
    }
}
