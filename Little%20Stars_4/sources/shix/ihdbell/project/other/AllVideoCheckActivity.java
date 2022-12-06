package shix.ihdbell.project.other;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.jxl.app.littlestars.project.R;
import com.tzh.ipcamera.presenter.LogUtils;
import com.tzh.ipcamera.view.VC.VideoViewPlay;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import object.p2pipcam.adapter.AllVideoListAdapter;
import object.p2pipcam.bean.CameraParamsBean;
import object.p2pipcam.bean.MovieInfo;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.VibratorUtil;
import shix.ihdbell.project.BaseActivity;

public class AllVideoCheckActivity extends BaseActivity {
    /* access modifiers changed from: private */
    public AllVideoListAdapter adapter = null;
    private TextView button_back = null;
    /* access modifiers changed from: private */
    public AdapterView.AdapterContextMenuInfo info = null;
    /* access modifiers changed from: private */
    public ListView listView = null;
    /* access modifiers changed from: private */
    public TextView localpic_tv_nopic;
    LogUtils logUtils = LogUtils.setLogger(AllVideoCheckActivity.class);
    /* access modifiers changed from: private */
    public List<MovieInfo> movieInfos = null;
    private int position = 0;
    private TextView textView = null;
    private ArrayList<CameraParamsBean> videoList = new ArrayList<>();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.sdcard_video);
        this.textView = (TextView) findViewById(R.id.takepic_title);
        this.localpic_tv_nopic = (TextView) findViewById(R.id.localpic_tv_nopic);
        this.button_back = (TextView) findViewById(R.id.back);
        this.listView = (ListView) findViewById(R.id.loaded_act_listview);
        ap_bean_init();
        Iterator<CameraParamsBean> it = SystemValue.arrayList.iterator();
        while (it.hasNext()) {
            CameraParamsBean next = it.next();
            this.videoList.add(next);
            this.logUtils.e("###add bean:" + next.getName());
        }
        this.videoList.add(SystemValue.ApModelBean);
        this.movieInfos = new ArrayList();
        Intent intent = getIntent();
        this.position = intent.getIntExtra("zhaogeng", 0);
        this.textView.setText(this.videoList.get(this.position).getName());
        Object[] objArr = (Object[]) intent.getSerializableExtra("zhaoxing");
        if (objArr != null) {
            for (Object obj : objArr) {
                this.movieInfos.add((MovieInfo) obj);
            }
        }
        if (this.movieInfos.size() == 0) {
            this.listView.setVisibility(8);
            this.localpic_tv_nopic.setVisibility(0);
        } else {
            Sort();
        }
        this.adapter = new AllVideoListAdapter(this, this.movieInfos, this.position);
        this.listView.setAdapter(this.adapter);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Log.e(AllVideoCheckActivity.class.getSimpleName(), "all video check activity!");
                VibratorUtil.Vibrate(AllVideoCheckActivity.this, 20);
                Intent intent = new Intent();
                intent.setClass(AllVideoCheckActivity.this, VideoViewPlay.class);
                intent.putExtra("VideoPath", ((MovieInfo) AllVideoCheckActivity.this.movieInfos.get(i)).getPath());
                AllVideoCheckActivity.this.startActivity(intent);
            }
        });
        this.button_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VibratorUtil.Vibrate(AllVideoCheckActivity.this, 20);
                AllVideoCheckActivity.this.finish();
                AllVideoCheckActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
            }
        });
        registerForContextMenu(this.listView);
        SetTab(this);
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

    private void Sort() {
        Collections.sort(this.movieInfos, new Comparator<MovieInfo>() {
            public int compare(MovieInfo movieInfo, MovieInfo movieInfo2) {
                return movieInfo.getDate().getTime() < movieInfo2.getDate().getTime() ? 1 : -1;
            }
        });
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        contextMenu.setHeaderTitle(getResources().getString(R.string.exit_show));
        contextMenu.add(0, 2, 0, getResources().getString(R.string.exit_qu));
        contextMenu.add(0, 3, 0, getResources().getString(R.string.exit_qu_all));
        contextMenu.add(0, 7, 0, getResources().getString(R.string.exit_qu_show));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 2) {
            this.info = (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
            SystemValue.checkSDStatu = 1;
            new AsyncTask<Void, Void, Void>() {
                /* access modifiers changed from: protected */
                public Void doInBackground(Void... voidArr) {
                    new File(((MovieInfo) AllVideoCheckActivity.this.movieInfos.get(AllVideoCheckActivity.this.info.position)).getPath()).delete();
                    AllVideoCheckActivity.this.movieInfos.remove(AllVideoCheckActivity.this.info.position);
                    return null;
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(Void voidR) {
                    SystemValue.checkSDStatu = 1;
                    AllVideoCheckActivity.this.adapter.notifyDataSetChanged();
                    Toast.makeText(AllVideoCheckActivity.this.getApplicationContext(), AllVideoCheckActivity.this.getResources().getString(R.string.delect_sucss), 0).show();
                }
            }.execute(new Void[0]);
        } else if (menuItem.getItemId() == 3) {
            this.info = (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
            SystemValue.checkSDStatu = 1;
            new AsyncTask<Void, Void, Void>() {
                /* access modifiers changed from: protected */
                public Void doInBackground(Void... voidArr) {
                    for (int size = AllVideoCheckActivity.this.movieInfos.size() - 1; size >= 0; size--) {
                        new File(((MovieInfo) AllVideoCheckActivity.this.movieInfos.get(size)).getPath()).delete();
                        AllVideoCheckActivity.this.movieInfos.remove(size);
                    }
                    return null;
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(Void voidR) {
                    if (AllVideoCheckActivity.this.movieInfos.size() == 0) {
                        AllVideoCheckActivity.this.listView.setVisibility(8);
                        AllVideoCheckActivity.this.localpic_tv_nopic.setVisibility(0);
                    }
                    SystemValue.checkSDStatu = 1;
                    AllVideoCheckActivity.this.adapter.notifyDataSetChanged();
                    Toast.makeText(AllVideoCheckActivity.this.getApplicationContext(), AllVideoCheckActivity.this.getResources().getString(R.string.delect_sucss), 0).show();
                }
            }.execute(new Void[0]);
        }
        return false;
    }
}
