package object.p2pipcam.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import com.tzh.ipcamera.presenter.LogUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import object.p2pipcam.bean.MovieInfo;

public class AllVideoListAdapter extends BaseAdapter {
    private int count = 0;
    private LayoutInflater inflater = null;
    private LinearLayout layout = null;
    LogUtils logUtils = LogUtils.setLogger(AllVideoListAdapter.class);
    private List<MovieInfo> plays = null;
    private int posi = 0;
    private TextView textView_camer = null;
    private TextView textView_name = null;
    private TextView textView_size = null;
    private TextView textView_time = null;

    public long getItemId(int i) {
        return (long) i;
    }

    public AllVideoListAdapter(Context context, List<MovieInfo> list, int i) {
        this.plays = list;
        this.inflater = LayoutInflater.from(context);
        this.posi = i;
    }

    public int getCount() {
        return this.plays.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        this.count++;
        if (view == null) {
            view = this.inflater.inflate(R.layout.all_load_list_item, (ViewGroup) null);
            viewHolder = new ViewHolder();
            viewHolder.textView_name = (TextView) view.findViewById(R.id.file_name);
            viewHolder.layout = (LinearLayout) view.findViewById(R.id.loaded_linear_camer);
            viewHolder.textView_time = (TextView) view.findViewById(R.id.file_time);
            viewHolder.textView_size = (TextView) view.findViewById(R.id.file_size);
            viewHolder.textView_camer = (TextView) view.findViewById(R.id.file_camer);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Log.e("AllVideoListAdapter", "getView count: " + this.count);
        if (this.posi == 0) {
            viewHolder.layout.setVisibility(8);
            viewHolder.textView_camer.setText(this.plays.get(i).getCamerName());
        } else {
            viewHolder.layout.setVisibility(8);
            viewHolder.textView_camer.setVisibility(8);
        }
        viewHolder.textView_name.setText(this.plays.get(i).getVideoName());
        viewHolder.textView_size.setText(this.plays.get(i).getSize());
        viewHolder.textView_time.setText(getDateTime(this.plays.get(i).getDate()));
        return view;
    }

    private class ViewHolder {
        public LinearLayout layout;
        public TextView textView_camer;
        public TextView textView_name;
        public TextView textView_size;
        public TextView textView_time;

        private ViewHolder() {
            this.textView_name = null;
            this.textView_camer = null;
            this.textView_time = null;
            this.textView_size = null;
            this.layout = null;
        }
    }

    private String getDateTime(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(date);
    }
}
