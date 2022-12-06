package object.p2pipcam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import java.util.List;

public class CloudDateAdapter extends BaseAdapter {
    private Context context;
    private ViewHolder holder;
    private LayoutInflater inflater;
    private List<String> listDate;

    public long getItemId(int i) {
        return (long) i;
    }

    public CloudDateAdapter(Context context2, List<String> list) {
        this.context = context2;
        this.listDate = list;
        this.inflater = LayoutInflater.from(context2);
    }

    public int getCount() {
        return this.listDate.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.inflater.inflate(R.layout.clouddate_listitem, (ViewGroup) null);
            this.holder = new ViewHolder();
            this.holder.name = (TextView) view.findViewById(R.id.tv_name);
            view.setTag(this.holder);
        } else {
            this.holder = (ViewHolder) view.getTag();
        }
        TextView textView = this.holder.name;
        textView.setText(this.listDate.get(i) + "");
        return view;
    }

    private class ViewHolder {
        TextView name;

        private ViewHolder() {
        }
    }
}
