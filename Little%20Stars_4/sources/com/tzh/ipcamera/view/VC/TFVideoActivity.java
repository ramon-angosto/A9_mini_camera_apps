package com.tzh.ipcamera.view.VC;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.os.EnvironmentCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import com.tzh.ipcamera.presenter.FileListUtils;
import com.tzh.ipcamera.presenter.LogUtils;
import com.tzh.ipcamera.presenter.bean.FileBean;
import com.tzh.ipcamera.presenter.bean.TFDateBean;
import com.tzh.ipcamera.view.delegate.FileRequestDelegate;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import object.p2pipcam.adapter.AllRemoteVideoListAdapter;
import object.p2pipcam.bean.MovieInfo;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.DataBaseHelper;
import shix.ihdbell.project.BaseActivity;

public class TFVideoActivity extends BaseActivity implements FileRequestDelegate, View.OnClickListener, AdapterView.OnItemClickListener {
    private static final int CMD_PTZ_LIST_STOP_REQ = 20;
    public static final int FILE_NUM_EACH_PAGE = 50;
    public static final int MESSAGE_REQUEST_FILE_LIST = 1;
    public static final int MESSAGE_TF_ERROR = 4;
    public static final int MESSAGE_TF_GET_FAIL = 5;
    public static final int MESSAGE_TF_NO_FILE = 2;
    public static final int MESSAGE_TF_UN_INSERT = 3;
    public static final int PIC = 2;
    public static final int VIDEO = 1;
    private int TIMEOUT = 30000;
    private boolean bStart = false;
    private FileListUtils fileListUtils = null;
    LogUtils logUtils = LogUtils.setLogger(TFVideoActivity.class);
    Handler mHandler = new Handler() {
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                TFVideoActivity.this.startGetTFFile(1, 1);
            } else if (i == 2) {
                TFVideoActivity.this.mHandler.removeCallbacks(TFVideoActivity.this.mTimeOutRunnable);
                TFVideoActivity.this.cancelDialog();
                TFVideoActivity.this.tvState.setVisibility(0);
                TFVideoActivity.this.videoList.setVisibility(4);
                TFVideoActivity.this.tvState.setText(TFVideoActivity.this.getResources().getString(R.string.tf_no_file));
            } else if (i == 3) {
                TFVideoActivity.this.mHandler.removeCallbacks(TFVideoActivity.this.mTimeOutRunnable);
                TFVideoActivity.this.cancelDialog();
                TFVideoActivity.this.tvState.setVisibility(0);
                TFVideoActivity.this.videoList.setVisibility(4);
                TFVideoActivity.this.logUtils.e("###didTFCardUnInsert");
                TFVideoActivity.this.tvState.setText(TFVideoActivity.this.getResources().getString(R.string.dev_no_tf_card));
            } else if (i == 4) {
                TFVideoActivity.this.mHandler.removeCallbacks(TFVideoActivity.this.mTimeOutRunnable);
                TFVideoActivity.this.cancelDialog();
                TFVideoActivity.this.tvState.setVisibility(0);
                TFVideoActivity.this.videoList.setVisibility(4);
                TFVideoActivity.this.logUtils.e("###didTFCardUnknowError");
                TFVideoActivity.this.tvState.setText(TFVideoActivity.this.getResources().getString(R.string.tf_card_error));
            } else if (i == 5) {
                TFVideoActivity.this.mHandler.removeCallbacks(TFVideoActivity.this.mTimeOutRunnable);
                TFVideoActivity.this.mHandler.postDelayed(TFVideoActivity.this.mTimeOutRunnable, 1000);
            }
        }
    };
    public Thread mRequestThread = null;
    Runnable mTimeOutRunnable = new Runnable() {
        public void run() {
            TFVideoActivity.this.mHandler.removeCallbacks(TFVideoActivity.this.mTimeOutRunnable);
            TFVideoActivity.this.cancelDialog();
            TFVideoActivity.this.tvState.setVisibility(0);
            TFVideoActivity.this.videoList.setVisibility(4);
            TFVideoActivity.this.logUtils.e("###didTFCardUnknowError");
            TFVideoActivity.this.tvState.setText(TFVideoActivity.this.getResources().getString(R.string.tf_card_ack_timeout));
        }
    };
    private List<MovieInfo> movieInfos = new ArrayList();
    private int nPage = 0;
    private int position = 1;
    private ProgressBar progressBar = null;
    private ProgressDialog progressDialog = null;
    private String strDID = null;
    private String strName = null;
    private String strPwd = null;
    private String strUser = null;
    private TextView tvBack = null;
    private TextView tvPath = null;
    /* access modifiers changed from: private */
    public TextView tvState = null;
    private TextView tvTitle = null;
    /* access modifiers changed from: private */
    public AllRemoteVideoListAdapter videoAdapter = null;
    /* access modifiers changed from: private */
    public ListView videoList = null;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getIntentData();
        setContentView(R.layout.sdcard_video);
        widget_init();
        sendMessage(1, 0);
        this.mHandler.postDelayed(this.mTimeOutRunnable, (long) this.TIMEOUT);
        this.logUtils.e("###onCreate TFVideoActivity");
    }

    public void widget_init() {
        this.fileListUtils = new FileListUtils(this, 0);
        this.tvTitle = (TextView) findViewById(R.id.takepic_title);
        this.tvTitle.setText(this.strName);
        this.tvBack = (TextView) findViewById(R.id.back);
        this.tvPath = (TextView) findViewById(R.id.tv_show);
        this.tvState = (TextView) findViewById(R.id.localpic_tv_nopic);
        this.tvPath.setVisibility(4);
        this.videoList = (ListView) findViewById(R.id.loaded_act_listview);
        this.videoAdapter = new AllRemoteVideoListAdapter(this, this.movieInfos, this.position);
        this.videoList.setAdapter(this.videoAdapter);
        this.videoList.setOnItemClickListener(this);
        this.videoList.setVisibility(4);
        showDialog();
        FileListUtils fileListUtils2 = this.fileListUtils;
        if (fileListUtils2 != null) {
            fileListUtils2.registerListener(this);
        }
    }

    public void getIntentData() {
        Intent intent = getIntent();
        this.strName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
        this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.strPwd = intent.getStringExtra(ContentCommon.STR_CAMERA_PWD);
        this.strUser = intent.getStringExtra(ContentCommon.STR_CAMERA_USER);
        Log.d("tag", "PlayBackTFActivity  strName:" + this.strName + " strDID:" + this.strDID + " strPwd:" + this.strPwd + " strUser:" + this.strUser);
    }

    public void startGetTFFile(int i, int i2) {
        String format = String.format("/getfilelist.cgi?loginuse=admin&loginpas=admin&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass + "&type=" + i + "&page=" + i2 + "&count=" + 50, new Object[0]);
        this.logUtils.e(format);
        NativeCaller.TransferMessage(this.strDID, format, 1);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.back) {
            onBackPressed();
        }
    }

    public void didTFCardNoFile() {
        this.logUtils.e("###didTFCardNoFile");
        sendMessage(2, 0);
    }

    public void didTFCardUnInsert() {
        sendMessage(3, 0);
    }

    public void didTFCardUnknowError() {
        sendMessage(4, 0);
    }

    public void didTFCardGetListFail() {
        sendMessage(5, 0);
    }

    public void didTFCardGetList(int i, Object obj) {
        switchTFBeanToMovieInfo(obj);
        runOnUiThread(new Runnable() {
            public void run() {
                TFVideoActivity.this.cancelDialog();
                TFVideoActivity.this.videoList.setVisibility(0);
                TFVideoActivity.this.mHandler.removeCallbacks(TFVideoActivity.this.mTimeOutRunnable);
                TFVideoActivity.this.videoAdapter.notifyDataSetInvalidated();
            }
        });
    }

    public void switchTFBeanToMovieInfo(Object obj) {
        for (TFDateBean putMoveInfo : (List) obj) {
            putMoveInfo(putMoveInfo);
        }
    }

    public Date stringToDate(String str) {
        if (str.equals(EnvironmentCompat.MEDIA_UNKNOWN)) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyyMMddHHmmss").parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getFileSize(int i) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (i <= 1024) {
            return i + "B";
        } else if (i <= 1048576) {
            return decimalFormat.format((double) (((float) i) / 1024.0f)) + "KB";
        } else if (i <= 1073741824) {
            return decimalFormat.format((double) (((float) i) / 1048576.0f)) + "MB";
        } else {
            return decimalFormat.format((double) (((float) i) / 1.07374182E9f)) + "G";
        }
    }

    public void putMoveInfo(TFDateBean tFDateBean) {
        if (tFDateBean != null) {
            for (FileBean next : tFDateBean.dateFileList) {
                MovieInfo movieInfo = new MovieInfo();
                movieInfo.camerName = this.strName;
                movieInfo.videoName = next.filename;
                movieInfo.page = tFDateBean.curPage;
                movieInfo.totalPage = tFDateBean.totalPage;
                LogUtils logUtils2 = this.logUtils;
                logUtils2.e("###movieinfo name:" + movieInfo.camerName);
                movieInfo.date = stringToDate(tFDateBean.strFileDate);
                movieInfo.displayName = next.filename;
                movieInfo.path = next.path;
                movieInfo.size = getFileSize(next.filesize);
                this.movieInfos.add(movieInfo);
            }
        }
    }

    public void showDialog() {
        this.progressDialog = new ProgressDialog(this);
        this.progressDialog.setProgressStyle(0);
        this.progressDialog.setMessage(getString(R.string.remote_video_getparams));
        this.progressDialog.setCancelable(false);
        this.progressDialog.show();
    }

    public void cancelDialog() {
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 != null) {
            progressDialog2.cancel();
        }
    }

    public void sendMessage(int i, int i2) {
        Handler handler = this.mHandler;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = i;
            obtainMessage.arg1 = i2;
            this.mHandler.sendMessage(obtainMessage);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        LogUtils logUtils2 = this.logUtils;
        logUtils2.e("you have clicked :" + i + "  l:" + j);
        startNext(RemoteVideoPlayer.class, this.movieInfos.get(i), String.valueOf(i + 1));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        LogUtils logUtils2 = this.logUtils;
        logUtils2.e("###on resume: " + this.strDID + "  " + this.strUser + "  " + this.strPwd);
        StartHeat(this.strDID, this.strUser, this.strPwd);
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        StopHeat();
        super.onStop();
    }

    public void startNext(Class<?> cls, MovieInfo movieInfo, String str) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        intent.putExtra("MovieInfo", movieInfo);
        intent.putExtra(DataBaseHelper.KEY_DID, this.strDID);
        intent.putExtra(DataBaseHelper.KEY_USER, this.strUser);
        intent.putExtra(DataBaseHelper.KEY_PWD, this.strPwd);
        intent.putExtra("index", str);
        startActivity(intent);
        overridePendingTransition(17432578, 17432579);
    }

    public void stopGetTFFile() {
        String format = String.format("/decoder_control.cgi?command=20&onestep=1&user=" + this.strUser + "&pwd=" + this.strPwd, new Object[0]);
        this.logUtils.e(format);
        NativeCaller.TransferMessage(this.strDID, format, 1);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        FileListUtils fileListUtils2 = this.fileListUtils;
        if (fileListUtils2 != null) {
            fileListUtils2.unregisterListener();
        }
        cancelDialog();
        stopGetTFFile();
    }
}
