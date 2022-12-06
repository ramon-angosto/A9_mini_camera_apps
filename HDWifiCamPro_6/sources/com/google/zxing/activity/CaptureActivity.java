package com.google.zxing.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import com.dommy.qrcode.util.BitmapUtil;
import com.dommy.qrcode.util.Constant;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.camera.CameraManager;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.decoding.CaptureActivityHandler;
import com.google.zxing.decoding.InactivityTimer;
import com.google.zxing.decoding.RGBLuminanceSource;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.view.ViewfinderView;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.shix.qhipc.R;
import com.shix.shixipc.system.SystemValue;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Hashtable;
import java.util.Vector;

public class CaptureActivity extends Activity implements SurfaceHolder.Callback {
    private static final float BEEP_VOLUME = 0.1f;
    private static final int REQUEST_CODE_SCAN_GALLERY = 100;
    private static final long VIBRATE_DURATION = 200;
    private View.OnClickListener albumOnClick = new View.OnClickListener() {
        public void onClick(View view) {
            SystemValue.isExitBackGoudExit = false;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("image/*");
            CaptureActivity.this.startActivityForResult(intent, 100);
        }
    };
    private ImageButton back;
    private final MediaPlayer.OnCompletionListener beepListener = new MediaPlayer.OnCompletionListener() {
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.seekTo(0);
        }
    };
    private Button btnAlbum;
    /* access modifiers changed from: private */
    public ImageButton btnFlash;
    private String characterSet;
    private Vector<BarcodeFormat> decodeFormats;
    private View.OnClickListener flashListener = new View.OnClickListener() {
        public void onClick(View view) {
            try {
                if (!CameraManager.get().setFlashLight(!CaptureActivity.this.isFlashOn)) {
                    Toast.makeText(CaptureActivity.this, "暂时无法开启闪光灯", 0).show();
                } else if (CaptureActivity.this.isFlashOn) {
                    CaptureActivity.this.btnFlash.setImageResource(R.mipmap.flash_off);
                    boolean unused = CaptureActivity.this.isFlashOn = false;
                } else {
                    CaptureActivity.this.btnFlash.setImageResource(R.mipmap.flash_on);
                    boolean unused2 = CaptureActivity.this.isFlashOn = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private CaptureActivityHandler handler;
    private boolean hasSurface;
    private InactivityTimer inactivityTimer;
    /* access modifiers changed from: private */
    public boolean isFlashOn = false;
    /* access modifiers changed from: private */
    public ProgressDialog mProgress;
    private MediaPlayer mediaPlayer;
    private String photo_path;
    private boolean playBeep;
    private Bitmap scanBitmap;
    private boolean vibrate;
    private ViewfinderView viewfinderView;

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_scanner);
        CameraManager.init(getApplication());
        this.viewfinderView = (ViewfinderView) findViewById(R.id.viewfinder_content);
        this.back = (ImageButton) findViewById(R.id.btn_back);
        this.back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CaptureActivity.this.finish();
            }
        });
        this.btnFlash = (ImageButton) findViewById(R.id.btn_flash);
        this.btnFlash.setOnClickListener(this.flashListener);
        this.btnAlbum = (Button) findViewById(R.id.btn_album);
        this.btnAlbum.setOnClickListener(this.albumOnClick);
        this.hasSurface = false;
        this.inactivityTimer = new InactivityTimer(this);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 100) {
            handleAlbumPic(intent);
        }
        super.onActivityResult(i, i2, intent);
    }

    private void handleAlbumPic(Intent intent) {
        final Uri data = intent.getData();
        this.mProgress = new ProgressDialog(this);
        this.mProgress.setMessage("正在扫描...");
        this.mProgress.setCancelable(false);
        this.mProgress.show();
        runOnUiThread(new Runnable() {
            public void run() {
                Result scanningImage = CaptureActivity.this.scanningImage(data);
                CaptureActivity.this.mProgress.dismiss();
                if (scanningImage != null) {
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putString(Constant.INTENT_EXTRA_KEY_QR_SCAN, scanningImage.getText());
                    intent.putExtras(bundle);
                    CaptureActivity.this.setResult(-1, intent);
                    CaptureActivity.this.finish();
                    return;
                }
                Toast.makeText(CaptureActivity.this, "识别失败", 0).show();
            }
        });
    }

    public Result scanningImage(Uri uri) {
        if (uri == null) {
            return null;
        }
        Hashtable hashtable = new Hashtable();
        hashtable.put(DecodeHintType.CHARACTER_SET, "UTF8");
        this.scanBitmap = BitmapUtil.decodeUri(this, uri, 500, 500);
        try {
            return new QRCodeReader().decode(new BinaryBitmap(new HybridBinarizer(new RGBLuminanceSource(this.scanBitmap))), hashtable);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (ChecksumException e2) {
            e2.printStackTrace();
            return null;
        } catch (FormatException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        SurfaceHolder holder = ((SurfaceView) findViewById(R.id.scanner_view)).getHolder();
        if (this.hasSurface) {
            initCamera(holder);
        } else {
            holder.addCallback(this);
            holder.setType(3);
        }
        this.decodeFormats = null;
        this.characterSet = null;
        this.playBeep = true;
        if (((AudioManager) getSystemService(MimeTypes.BASE_TYPE_AUDIO)).getRingerMode() != 2) {
            this.playBeep = false;
        }
        initBeepSound();
        this.vibrate = true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        CaptureActivityHandler captureActivityHandler = this.handler;
        if (captureActivityHandler != null) {
            captureActivityHandler.quitSynchronously();
            this.handler = null;
        }
        CameraManager.get().closeDriver();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.inactivityTimer.shutdown();
        super.onDestroy();
    }

    public void handleDecode(Result result, Bitmap bitmap) {
        this.inactivityTimer.onActivity();
        playBeepSoundAndVibrate();
        String text = result.getText();
        if (TextUtils.isEmpty(text)) {
            Toast.makeText(this, "Scan failed!", 0).show();
        } else {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString(Constant.INTENT_EXTRA_KEY_QR_SCAN, text);
            PrintStream printStream = System.out;
            printStream.println("sssssssssssssssss scan 0 = " + text);
            intent.putExtras(bundle);
            setResult(-1, intent);
        }
        finish();
    }

    private void initCamera(SurfaceHolder surfaceHolder) {
        try {
            CameraManager.get().openDriver(surfaceHolder);
            if (this.handler == null) {
                this.handler = new CaptureActivityHandler(this, this.decodeFormats, this.characterSet);
            }
        } catch (IOException | RuntimeException unused) {
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (!this.hasSurface) {
            this.hasSurface = true;
            initCamera(surfaceHolder);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.hasSurface = false;
    }

    public ViewfinderView getViewfinderView() {
        return this.viewfinderView;
    }

    public Handler getHandler() {
        return this.handler;
    }

    public void drawViewfinder() {
        this.viewfinderView.drawViewfinder();
    }

    private void initBeepSound() {
        if (this.playBeep && this.mediaPlayer == null) {
            setVolumeControlStream(3);
            this.mediaPlayer = new MediaPlayer();
            this.mediaPlayer.setAudioStreamType(3);
            this.mediaPlayer.setOnCompletionListener(this.beepListener);
            AssetFileDescriptor openRawResourceFd = getResources().openRawResourceFd(R.raw.beep);
            try {
                this.mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                this.mediaPlayer.setVolume(0.1f, 0.1f);
                this.mediaPlayer.prepare();
            } catch (IOException unused) {
                this.mediaPlayer = null;
            }
        }
    }

    private void playBeepSoundAndVibrate() {
        MediaPlayer mediaPlayer2;
        if (this.playBeep && (mediaPlayer2 = this.mediaPlayer) != null) {
            mediaPlayer2.start();
        }
        if (this.vibrate) {
            ((Vibrator) getSystemService("vibrator")).vibrate(VIBRATE_DURATION);
        }
    }
}
