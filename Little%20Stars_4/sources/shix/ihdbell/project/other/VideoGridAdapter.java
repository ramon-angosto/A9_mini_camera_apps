package shix.ihdbell.project.other;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VideoGridAdapter extends BaseAdapter {
    public List<String> all_select = null;
    private LayoutInflater inflater = null;
    private LinearLayout layout = null;
    private List<String> list = null;
    public Vector<Boolean> mImage = null;
    public Vector<Boolean> mImage_bs = new Vector<>();
    private ArrayList<LoadedImage> photos = new ArrayList<>();
    private TextView textView = null;

    public long getItemId(int i) {
        return (long) i;
    }

    public VideoGridAdapter(Context context, List<String> list2) {
        this.inflater = LayoutInflater.from(context);
        this.list = list2;
        for (int i = 0; i < list2.size(); i++) {
            this.mImage_bs.add(false);
        }
    }

    public void addPhoto(LoadedImage loadedImage) {
        this.photos.add(loadedImage);
    }

    public int getCount() {
        return this.list.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        String substring = this.list.get(i).substring(this.list.get(i).lastIndexOf("/") + 1);
        String str = substring.substring(substring.indexOf("!") + 1) + "   " + substring.substring(0, 10) + "  " + substring.substring(11, 16).replace("_", ":");
        this.layout = (LinearLayout) this.inflater.inflate(R.layout.gridviewitemb, (ViewGroup) null);
        this.layout.setTag(Integer.valueOf(i));
        this.textView = (TextView) this.layout.findViewById(R.id.all_pic_check_grid_textView1);
        try {
            this.textView.setText(str);
        } catch (Exception unused) {
        }
        return this.layout;
    }
}
