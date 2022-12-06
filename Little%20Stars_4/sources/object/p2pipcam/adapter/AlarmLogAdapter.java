package object.p2pipcam.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import object.p2pipcam.bean.AlarmLogBean;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.utils.DataBaseHelper;
import shix.ihdbell.project.AlarmLogActivity;

public class AlarmLogAdapter extends BaseAdapter {
    /* access modifiers changed from: private */
    public AlarmLogActivity alarmLogActivity;
    /* access modifiers changed from: private */
    public ArrayList<AlarmLogBean> arrayList = new ArrayList<>();
    private ArrayList<AlarmLogBean> arrayList11111 = new ArrayList<>();
    private DataBaseHelper baseHelper;
    private Context context;
    private LayoutInflater inflater;

    public long getItemId(int i) {
        return (long) i;
    }

    public AlarmLogAdapter(Context context2, AlarmLogActivity alarmLogActivity2) {
        this.context = context2;
        this.inflater = LayoutInflater.from(context2);
        this.alarmLogActivity = alarmLogActivity2;
        this.baseHelper = DataBaseHelper.getInstance(context2);
    }

    public int getCount() {
        return this.arrayList.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.inflater.inflate(R.layout.alarmlog_listitem, (ViewGroup) null);
            viewHolder = new ViewHolder();
            viewHolder.content = (TextView) view.findViewById(R.id.alarm_log_content);
            viewHolder.createTime = (TextView) view.findViewById(R.id.alarm_log_time);
            viewHolder.button_check_pic = (ImageButton) view.findViewById(R.id.button_check_pic);
            viewHolder.tv_type = (TextView) view.findViewById(R.id.alarm_log_left);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        AlarmLogBean alarmLogBean = this.arrayList.get(i);
        String str = Environment.getExternalStorageDirectory() + "/" + ContentCommon.SDCARD_PATH + "/picVisitor/" + alarmLogBean.getCreatetime().replace(" ", "_").replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "_").replace(":", "_") + ".jpg";
        if (new File(str).exists()) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 4;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                if (decodeFile != null) {
                    viewHolder.button_check_pic.setImageBitmap(decodeFile);
                } else {
                    viewHolder.button_check_pic.setImageResource(R.drawable.vidicon);
                }
                alarmLogBean.setIsPic(1);
            } catch (Exception unused) {
                viewHolder.button_check_pic.setImageResource(R.drawable.vidicon);
                alarmLogBean.setIsPic(0);
            }
        } else {
            viewHolder.button_check_pic.setImageResource(R.drawable.vidicon);
            alarmLogBean.setIsPic(0);
        }
        viewHolder.button_check_pic.setOnClickListener(new MyOnClickListener(i));
        String content = alarmLogBean.getContent();
        String user = alarmLogBean.getUser();
        int status = alarmLogBean.getStatus();
        if (content.length() < 2) {
            content = "13";
        }
        int parseInt = content.length() == 2 ? Integer.parseInt(content.substring(0, 1)) : 11;
        if (content.length() == 2) {
            Integer.parseInt(content.substring(1));
        } else {
            Integer.parseInt(content.substring(2));
        }
        if (parseInt == 1) {
            viewHolder.tv_type.setText(R.string.doorbell_fangke);
        } else if (parseInt == 11) {
            viewHolder.tv_type.setText(R.string.doorbell_alerm11);
        } else {
            viewHolder.tv_type.setText(R.string.doorbell_alerm);
        }
        if (status == 0) {
            viewHolder.content.setTextColor(-1420987);
            viewHolder.content.setText(R.string.doorbell_alerm_no);
        } else if (status == 1) {
            viewHolder.content.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            viewHolder.content.setText(user + "  " + this.context.getResources().getString(R.string.doorbell_alerm_ok));
        } else if (status == 2) {
            viewHolder.content.setTextColor(-1420987);
            viewHolder.content.setText(R.string.alarm_log_no);
        } else if (status == 3) {
            viewHolder.content.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            viewHolder.content.setText(R.string.alarm_log_yes);
        }
        viewHolder.createTime.setText(alarmLogBean.getCreatetime());
        viewHolder.content.setOnLongClickListener(new MyOnLongListener(i));
        return view;
    }

    public void addAlarmLog(AlarmLogBean alarmLogBean) {
        int i = 0;
        while (i < this.arrayList.size()) {
            if (!this.arrayList.get(i).getCreatetime().equals(alarmLogBean.getCreatetime())) {
                i++;
            } else {
                return;
            }
        }
        this.arrayList.add(alarmLogBean);
    }

    public void addarrayList11111(String str, String str2, int i) {
        if (i == 0 || i == 1) {
            AlarmLogBean alarmLogBean = new AlarmLogBean();
            alarmLogBean.setUUID(str);
            alarmLogBean.setUser(str2);
            alarmLogBean.setStatus(i);
            this.arrayList11111.add(alarmLogBean);
        }
    }

    public void UpdataArrayList() {
        for (int i = 0; i < this.arrayList.size(); i++) {
            int i2 = 0;
            while (true) {
                if (i2 < this.arrayList11111.size()) {
                    if (this.arrayList.get(i).getUUID().equals(this.arrayList11111.get(i2).getUUID()) && this.arrayList.get(i).getStatus() != 2 && this.arrayList.get(i).getStatus() != 3) {
                        this.arrayList.get(i).setUser(this.arrayList11111.get(i2).getUser());
                        this.arrayList.get(i).setStatus(this.arrayList11111.get(i2).getStatus());
                        boolean updateLogs = this.baseHelper.updateLogs(this.arrayList11111.get(i2).getUUID(), this.arrayList11111.get(i2).getUser(), this.arrayList11111.get(i2).getStatus());
                        Log.d("test", "----------------------isok----------------isok" + updateLogs + "  uuid:" + this.arrayList11111.get(i2).getUUID() + "  status:" + this.arrayList11111.get(i2).getStatus());
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
        }
    }

    public void UpdataCheck(int i) {
        this.arrayList.get(i).setStatus(3);
        boolean updateLogs = this.baseHelper.updateLogs(this.arrayList.get(i).getUUID(), this.arrayList.get(i).getUser(), 3);
        Log.d("test", "----------------------isok----------------UpdataCheck isok:" + updateLogs);
    }

    public void clearAllAlarmLog() {
        this.arrayList.clear();
    }

    private class MyOnClickListener implements View.OnClickListener {
        AlarmLogBean alarmLogBean1;
        private int position;

        public MyOnClickListener(int i) {
            this.position = i;
            this.alarmLogBean1 = (AlarmLogBean) AlarmLogAdapter.this.arrayList.get(i);
        }

        public void onClick(View view) {
            AlarmLogAdapter.this.alarmLogActivity.showPic(this.position, this.alarmLogBean1.getCamName(), this.alarmLogBean1.getContent(), this.alarmLogBean1.getCreatetime(), this.alarmLogBean1.getCreatetime(), this.alarmLogBean1.getUUID(), this.alarmLogBean1.getIsPic());
        }
    }

    private class MyOnLongListener implements View.OnLongClickListener {
        private int position;

        public boolean onLongClick(View view) {
            return false;
        }

        public MyOnLongListener(int i) {
            this.position = i;
        }
    }

    private class ViewHolder {
        ImageButton button_check_pic;
        TextView content;
        TextView createTime;
        TextView tv_type;

        private ViewHolder() {
        }
    }
}
