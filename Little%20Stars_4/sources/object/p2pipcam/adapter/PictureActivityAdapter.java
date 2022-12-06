package object.p2pipcam.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import com.tzh.ipcamera.presenter.LogUtils;
import java.util.ArrayList;
import object.p2pipcam.bean.CameraParamsBean;

public class PictureActivityAdapter extends BaseAdapter {
    public final int PHONE = 1;
    public final int REMOTE = 2;
    private Context context;
    private ViewHolder holder;
    private LayoutInflater inflater;
    private boolean isOver = false;
    private LogUtils logUtils = LogUtils.setLogger(PictureActivityAdapter.class);
    public int mode = 1;
    private ArrayList<CameraParamsBean> picList = new ArrayList<>();

    public void addBmpAndSum(Bitmap bitmap, int i) {
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public PictureActivityAdapter(Context context2, ArrayList<CameraParamsBean> arrayList) {
        this.context = context2;
        this.picList = arrayList;
        this.inflater = LayoutInflater.from(context2);
    }

    public int getCount() {
        LogUtils logUtils2 = this.logUtils;
        logUtils2.e("###count:" + this.picList.size());
        return this.picList.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        if (view == null) {
            view = this.inflater.inflate(R.layout.picturevideo_listitem, (ViewGroup) null);
            this.holder = new ViewHolder();
            this.holder.name = (TextView) view.findViewById(R.id.tv_name);
            this.holder.id = (TextView) view.findViewById(R.id.tv_did);
            this.holder.status = (TextView) view.findViewById(R.id.tv_status);
            this.holder.number = (TextView) view.findViewById(R.id.tv_pic_num);
            view.setTag(this.holder);
        } else {
            this.holder = (ViewHolder) view.getTag();
        }
        this.logUtils.e("####phone mode");
        CameraParamsBean cameraParamsBean = this.picList.get(i);
        int sum_pic = cameraParamsBean.getSum_pic();
        TextView textView = this.holder.number;
        textView.setText("(" + sum_pic + ")");
        String did = cameraParamsBean.getDid();
        String name = cameraParamsBean.getName();
        switch (cameraParamsBean.getStatus()) {
            case 0:
                i2 = R.string.pppp_status_connecting;
                break;
            case 1:
                i2 = R.string.pppp_status_initialing;
                break;
            case 2:
                i2 = R.string.pppp_status_online;
                break;
            case 3:
                i2 = R.string.pppp_status_connect_failed;
                break;
            case 4:
                i2 = R.string.pppp_status_disconnect;
                break;
            case 5:
                i2 = R.string.pppp_status_invalid_id;
                break;
            case 6:
                i2 = R.string.device_not_on_line;
                break;
            case 7:
                i2 = R.string.pppp_status_connect_timeout;
                break;
            default:
                i2 = R.string.pppp_status_unknown;
                break;
        }
        this.holder.status.setText(this.context.getResources().getString(i2));
        this.holder.id.setText(did);
        this.holder.name.setText(name);
        int i3 = this.mode;
        if (i3 == 1) {
            this.holder.number.setVisibility(0);
            this.holder.status.setVisibility(8);
        } else if (i3 == 2) {
            this.holder.number.setVisibility(8);
            this.holder.status.setVisibility(0);
        }
        return view;
    }

    public void setOver(boolean z) {
        this.isOver = z;
    }

    public int getMode() {
        return this.mode;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    private class ViewHolder {
        TextView id;
        TextView name;
        TextView number;
        TextView status;

        private ViewHolder() {
        }
    }
}
