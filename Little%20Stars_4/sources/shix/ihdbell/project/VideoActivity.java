package shix.ihdbell.project;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.jxl.app.littlestars.project.R;
import com.tzh.ipcamera.presenter.LogUtils;
import com.tzh.ipcamera.view.VC.TFVideoActivity;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import object.p2pipcam.adapter.VideoActivityAdapter;
import object.p2pipcam.bean.CameraParamsBean;
import object.p2pipcam.bean.MovieInfo;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.CommonUtil;
import object.p2pipcam.utils.VibratorUtil;
import shix.ihdbell.project.other.AllVideoCheckActivity;

public class VideoActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    /* access modifiers changed from: private */
    public ArrayList<CameraParamsBean> arrayList = new ArrayList<>();
    /* access modifiers changed from: private */
    public Button bntPhone;
    /* access modifiers changed from: private */
    public Button bntRemote;
    private MyStatusBroadCast broadcast;
    private TextView btnBack;
    private Handler handler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 2) {
                VideoActivity.this.mAdapter.setOver(true);
            } else if (i == 3) {
                VideoActivity.this.sendBroadcast(new Intent("other"));
                return;
            } else if (i == 4) {
                if (VideoActivity.this.tag == 0) {
                    VideoActivity.this.bntRemote.setBackgroundResource(R.drawable.checkright_normal);
                    VideoActivity.this.bntRemote.setTextColor(VideoActivity.this.getResources().getColorStateList(R.color.text_color_video_btn));
                    VideoActivity.this.bntPhone.setTextColor(VideoActivity.this.getResources().getColorStateList(R.color.text_color));
                    if (VideoActivity.this.arrayList.indexOf(SystemValue.ApModelBean) == -1) {
                        VideoActivity.this.arrayList.add(SystemValue.ApModelBean);
                    }
                    VideoActivityAdapter access$000 = VideoActivity.this.mAdapter;
                    VideoActivity.this.mAdapter.getClass();
                    access$000.setMode(1);
                } else if (VideoActivity.this.tag == 1) {
                    if (VideoActivity.this.arrayList.indexOf(SystemValue.ApModelBean) != -1) {
                        VideoActivity.this.arrayList.remove(SystemValue.ApModelBean);
                    }
                    VideoActivity.this.bntPhone.setTextColor(VideoActivity.this.getResources().getColorStateList(R.color.text_color_video_btn));
                    VideoActivity.this.bntRemote.setTextColor(VideoActivity.this.getResources().getColorStateList(R.color.text_color));
                    VideoActivity.this.bntPhone.setBackgroundResource(R.drawable.checkleft_normal);
                    VideoActivityAdapter access$0002 = VideoActivity.this.mAdapter;
                    VideoActivity.this.mAdapter.getClass();
                    access$0002.setMode(2);
                }
                VideoActivity.this.mAdapter.notifyDataSetChanged();
            }
            VideoActivity.this.mAdapter.notifyDataSetChanged();
        }
    };
    private boolean isUpdate = true;
    private ListView listView;
    LogUtils logUtils = LogUtils.setLogger(VideoActivity.class);
    /* access modifiers changed from: private */
    public VideoActivityAdapter mAdapter;
    /* access modifiers changed from: private */
    public Map<String, List<MovieInfo>> maps = null;
    /* access modifiers changed from: private */
    public List<MovieInfo> playList = null;
    /* access modifiers changed from: private */
    public int tag = 0;
    private int timeOne = 0;
    private int timeTag = 0;
    private int timeTwo = 0;

    public static int byteToInt(byte[] bArr) {
        return ((bArr[3] & 255) << 24) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.isUpdate = false;
        Log.d("TAG", "onCreate");
        requestWindowFeature(1);
        setContentView(R.layout.videosactivity);
        findView();
        setListener();
        ap_bean_init();
        Iterator<CameraParamsBean> it = SystemValue.arrayList.iterator();
        while (it.hasNext()) {
            CameraParamsBean next = it.next();
            this.arrayList.add(next);
            LogUtils logUtils2 = this.logUtils;
            logUtils2.e("###add bean:" + next.getName());
        }
        this.arrayList.add(SystemValue.ApModelBean);
        this.mAdapter = new VideoActivityAdapter(this, this.arrayList);
        LogUtils logUtils3 = this.logUtils;
        logUtils3.e("###videoList size" + this.arrayList.size());
        this.listView.setAdapter(this.mAdapter);
        this.listView.setOnItemClickListener(this);
        this.handler.sendEmptyMessageDelayed(3, 1000);
        this.broadcast = new MyStatusBroadCast();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("camera_status_change");
        registerReceiver(this.broadcast, intentFilter);
        SystemValue.checkSDStatu = 1;
        this.btnBack = (TextView) findViewById(R.id.back);
        this.btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VibratorUtil.Vibrate(VideoActivity.this, 20);
                VideoActivity.this.finish();
                VideoActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
            }
        });
    }

    private void ap_bean_init() {
        SystemValue.ApModelBean.setAuthority(false);
        SystemValue.ApModelBean.setName("APCamera");
        SystemValue.ApModelBean.setDid("APCAMERA0000000");
        SystemValue.ApModelBean.setUser("");
        SystemValue.ApModelBean.setPwd("");
        SystemValue.ApModelBean.setStatus(-1);
        SystemValue.ApModelBean.setMode(-1);
        SystemValue.ApModelBean.setBmp((Bitmap) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        if (this.isUpdate) {
            this.arrayList.clear();
            Iterator<CameraParamsBean> it = SystemValue.arrayList.iterator();
            while (it.hasNext()) {
                this.arrayList.add(it.next());
            }
            this.arrayList.add(SystemValue.ApModelBean);
            this.handler.sendEmptyMessage(4);
        }
        if (this.arrayList.size() == 0) {
            this.listView.setVisibility(8);
        } else {
            this.listView.setVisibility(0);
        }
        if (SystemValue.checkSDStatu == 1) {
            new AsyncTask<Void, Void, Void>() {
                /* access modifiers changed from: protected */
                public void onPreExecute() {
                    List unused = VideoActivity.this.playList = new ArrayList();
                    Map unused2 = VideoActivity.this.maps = new HashMap();
                }

                /* access modifiers changed from: protected */
                public Void doInBackground(Void... voidArr) {
                    File file = new File(Environment.getExternalStorageDirectory(), "LittleStars/video");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    VideoActivity.this.getVideoFile(file);
                    for (int i = 0; i < VideoActivity.this.arrayList.size(); i++) {
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < VideoActivity.this.playList.size(); i2++) {
                            if (((CameraParamsBean) VideoActivity.this.arrayList.get(i)).getDid().equals(((MovieInfo) VideoActivity.this.playList.get(i2)).getCamerName())) {
                                arrayList.add(VideoActivity.this.playList.get(i2));
                            }
                        }
                        ((CameraParamsBean) VideoActivity.this.arrayList.get(i)).setSum(arrayList.size());
                        VideoActivity.this.maps.put(((CameraParamsBean) VideoActivity.this.arrayList.get(i)).getDid(), arrayList);
                        Log.d("TAG", arrayList.size() + "");
                    }
                    return null;
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(Void voidR) {
                    SystemValue.checkSDStatu = 0;
                    VideoActivity.this.mAdapter.notifyDataSetChanged();
                    if (VideoActivity.this.playList.size() == 0) {
                        VideoActivity videoActivity = VideoActivity.this;
                        Toast.makeText(videoActivity, videoActivity.getResources().getString(R.string.no_videoing_file), 0).show();
                    }
                    for (int i = 0; i < VideoActivity.this.playList.size(); i++) {
                        Log.d("TAG", "camerName=" + ((MovieInfo) VideoActivity.this.playList.get(i)).getCamerName() + "   videoName=" + ((MovieInfo) VideoActivity.this.playList.get(i)).getVideoName() + "  path=" + ((MovieInfo) VideoActivity.this.playList.get(i)).getPath());
                    }
                }
            }.execute(new Void[0]);
        }
        super.onResume();
        this.isUpdate = true;
    }

    private void setListener() {
        this.bntPhone.setOnClickListener(this);
        this.bntRemote.setOnClickListener(this);
    }

    private void findView() {
        this.bntPhone = (Button) findViewById(R.id.picture_phone);
        this.bntRemote = (Button) findViewById(R.id.picture_remote);
        this.listView = (ListView) findViewById(R.id.piclistview);
    }

    public void onClick(View view) {
        VibratorUtil.Vibrate(this, 20);
        switch (view.getId()) {
            case R.id.picture_phone:
                this.tag = 0;
                this.bntRemote.setBackgroundResource(R.drawable.checkright_normal);
                this.bntRemote.setTextColor(getResources().getColorStateList(R.color.text_color_video_btn));
                this.bntPhone.setTextColor(getResources().getColorStateList(R.color.text_color));
                if (this.arrayList.indexOf(SystemValue.ApModelBean) == -1) {
                    this.arrayList.add(SystemValue.ApModelBean);
                }
                VideoActivityAdapter videoActivityAdapter = this.mAdapter;
                videoActivityAdapter.getClass();
                videoActivityAdapter.setMode(1);
                break;
            case R.id.picture_remote:
                this.tag = 1;
                if (this.arrayList.indexOf(SystemValue.ApModelBean) != -1) {
                    this.arrayList.remove(SystemValue.ApModelBean);
                }
                this.bntPhone.setTextColor(getResources().getColorStateList(R.color.text_color_video_btn));
                this.bntRemote.setTextColor(getResources().getColorStateList(R.color.text_color));
                this.bntPhone.setBackgroundResource(R.drawable.checkleft_normal);
                VideoActivityAdapter videoActivityAdapter2 = this.mAdapter;
                videoActivityAdapter2.getClass();
                videoActivityAdapter2.setMode(2);
                break;
        }
        this.mAdapter.notifyDataSetChanged();
    }

    /* JADX WARNING: type inference failed for: r10v8, types: [java.lang.Object[], java.io.Serializable] */
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        VibratorUtil.Vibrate(this, 20);
        int i2 = this.tag;
        if (i2 == 0) {
            Intent intent = new Intent(this, AllVideoCheckActivity.class);
            List list = this.maps.get(this.arrayList.get(i).getDid());
            if (list.size() > 0) {
                intent.putExtra("zhaoxing", list.toArray());
            }
            intent.putExtra("zhaogeng", i);
            startActivity(intent);
            overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        } else if (i2 == 1) {
            CameraParamsBean cameraParamsBean = this.arrayList.get(i);
            String did = cameraParamsBean.getDid();
            String name = cameraParamsBean.getName();
            String pwd = cameraParamsBean.getPwd();
            String user = cameraParamsBean.getUser();
            int status = cameraParamsBean.getStatus();
            int mode = this.mAdapter.getMode();
            SystemValue.doorBellAdmin = user;
            SystemValue.doorBellPass = pwd;
            if (status == 5 || status == 7 || status == 6 || status == 3 || status == 9 || status == 10 || status == 4) {
                NativeCaller.StopPPPP(did);
                StartPPPP(did, user, pwd, "test");
                return;
            }
            NativeCaller.TransferMessage(did, CommonUtil.SHIX_Heat(SystemValue.doorBellAdmin, SystemValue.doorBellPass), 0);
            if (mode != 2) {
                return;
            }
            if (status == 2) {
                Intent intent2 = new Intent(this, TFVideoActivity.class);
                intent2.putExtra(ContentCommon.STR_CAMERA_NAME, name);
                intent2.putExtra(ContentCommon.STR_CAMERA_ID, did);
                intent2.putExtra(ContentCommon.STR_CAMERA_PWD, pwd);
                intent2.putExtra(ContentCommon.STR_CAMERA_USER, user);
                startActivity(intent2);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                return;
            }
            showToast((int) R.string.remote_video_offline);
        }
    }

    /* access modifiers changed from: private */
    public void getVideoFile(File file) {
        file.listFiles(new FileFilter() {
            public boolean accept(File file) {
                String name = file.getName();
                int lastIndexOf = name.lastIndexOf(".");
                if (lastIndexOf != -1) {
                    if (name.substring(lastIndexOf).equalsIgnoreCase(".mp4")) {
                        String name2 = file.getName();
                        MovieInfo movieInfo = new MovieInfo();
                        movieInfo.setDisplayName(name2);
                        movieInfo.setPath(file.getAbsolutePath());
                        movieInfo.setDate(new Date(file.lastModified()));
                        movieInfo.setCamerName(name2.substring(0, name2.indexOf("!")));
                        movieInfo.setVideoName(name2.substring(name2.indexOf("!") + 1));
                        movieInfo.setSize(VideoActivity.this.getSize(file.length()));
                        Log.d("test", "test-sd:size:" + file.length() + " name:" + name2.substring(name2.indexOf("!") + 1));
                        VideoActivity.this.playList.add(movieInfo);
                        return true;
                    }
                } else if (file.isDirectory()) {
                    VideoActivity.this.getVideoFile(file);
                }
                return false;
            }
        });
    }

    /* access modifiers changed from: private */
    public String getSize(long j) {
        if (j <= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            return j + "B";
        } else if (j > PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID && j <= 1048576) {
            return (j / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) + "KB";
        } else if (j > 1048576 && j <= 1073741824) {
            return (j / 1048576) + "MB";
        } else if (j > 0) {
            return (j / 1073741824) + "G";
        } else {
            return j + "B";
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.broadcast);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82) {
            sendBroadcast(new Intent(ContentCommon.MAIN_KEY_MENU));
            return false;
        } else if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        } else {
            sendBroadcast(new Intent(ContentCommon.MAIN_KEY_BACK));
            return true;
        }
    }

    private class MyStatusBroadCast extends BroadcastReceiver {
        private MyStatusBroadCast() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("camera_status_change".equals(intent.getAction())) {
                VideoActivity.this.mAdapter.notifyDataSetChanged();
                Log.d("tag", "camera_status_change");
            }
        }
    }
}
