package shix.ihdbell.project.other;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class GridAdapter extends BaseAdapter {
    public List<String> all_select = null;
    int count = 50;
    private ImageView imageView = null;
    private LayoutInflater inflater = null;
    private LinearLayout layout = null;
    public List<String> list = null;
    public Vector<Boolean> mImage = null;
    private Vector<Boolean> mImage_bs = new Vector<>();
    public ArrayList<LoadedImage> photos = new ArrayList<>();
    private TextView textView = null;

    public long getItemId(int i) {
        return (long) i;
    }

    public GridAdapter(Context context, List<String> list2) {
        this.inflater = LayoutInflater.from(context);
        this.list = list2;
        if (list2.size() < 50) {
            this.count = list2.size();
        }
    }

    public int getCount() {
        return this.count;
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        String substring = this.list.get(i).substring(this.list.get(i).lastIndexOf("/") + 1);
        String replace = substring.substring(11, 16).replace("_", ":");
        String str = substring.substring(substring.indexOf("=") + 1, substring.indexOf("!")) + "   " + substring.substring(0, 10) + "  " + replace;
        this.layout = (LinearLayout) this.inflater.inflate(R.layout.gridviewitema, (ViewGroup) null);
        this.layout.setTag(Integer.valueOf(i));
        this.imageView = (ImageView) this.layout.findViewById(R.id.gridimageviewitem1);
        this.textView = (TextView) this.layout.findViewById(R.id.all_pic_check_grid_textView1);
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 8;
            this.imageView.setImageBitmap(BitmapFactory.decodeFile(this.list.get(i).toString(), options));
            this.textView.setText(str);
        } catch (Exception unused) {
        }
        return this.layout;
    }
}
