package object.p2pipcam.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalPictureAdapter extends BaseAdapter {
    /* access modifiers changed from: private */
    public Map<String, ArrayList<String>> childMap;
    /* access modifiers changed from: private */
    public List<String> groupList;
    /* access modifiers changed from: private */
    public Handler handler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 2) {
                boolean unused = LocalPictureAdapter.this.isOver = true;
            }
            LocalPictureAdapter.this.notifyDataSetChanged();
        }
    };
    private ViewHolder holder = null;
    private LayoutInflater inflator;
    /* access modifiers changed from: private */
    public boolean isOver = false;
    /* access modifiers changed from: private */
    public HashMap<String, Bitmap> mapBmp = null;
    private int mode = 0;
    /* access modifiers changed from: private */
    public int width;

    public long getItemId(int i) {
        return (long) i;
    }

    public LocalPictureAdapter(Context context, List<String> list, Map<String, ArrayList<String>> map, int i) {
        this.inflator = (LayoutInflater) context.getSystemService("layout_inflater");
        this.groupList = list;
        this.childMap = map;
        this.width = i;
        this.mapBmp = new HashMap<>();
        initBmp();
    }

    public static byte[] intToByte(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = new Integer(i & 255).byteValue();
            i >>= 8;
        }
        return bArr;
    }

    public static int byteToInt(byte[] bArr) {
        return ((bArr[3] & 255) << 24) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
    }

    public void initBmp() {
        new Thread() {
            public void run() {
                int size = LocalPictureAdapter.this.groupList.size();
                for (int i = 0; i < size; i++) {
                    String str = (String) LocalPictureAdapter.this.groupList.get(i);
                    Bitmap decodeFile = BitmapFactory.decodeFile((String) ((ArrayList) LocalPictureAdapter.this.childMap.get(str)).get(0));
                    if (decodeFile != null) {
                        Matrix matrix = new Matrix();
                        matrix.postScale(((float) LocalPictureAdapter.this.width) / ((float) decodeFile.getWidth()), ((float) LocalPictureAdapter.this.width) / ((float) decodeFile.getHeight()));
                        LocalPictureAdapter.this.mapBmp.put(str, Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true));
                        LocalPictureAdapter.this.handler.sendEmptyMessage(1);
                    }
                }
                LocalPictureAdapter.this.handler.sendEmptyMessage(2);
            }
        }.start();
    }

    public int getCount() {
        return this.groupList.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.inflator.inflate(R.layout.localpicture_listitem, (ViewGroup) null);
            this.holder = new ViewHolder();
            this.holder.img = (ImageView) view.findViewById(R.id.img);
            this.holder.sum = (TextView) view.findViewById(R.id.sum);
            this.holder.time = (TextView) view.findViewById(R.id.time);
            this.holder.pBar = (ProgressBar) view.findViewById(R.id.progressBar1);
            view.setTag(this.holder);
        } else {
            this.holder = (ViewHolder) view.getTag();
        }
        int i2 = this.width;
        this.holder.img.setLayoutParams(new FrameLayout.LayoutParams(i2, i2));
        String str = this.groupList.get(i);
        this.holder.time.setText(str);
        TextView textView = this.holder.sum;
        textView.setText(this.childMap.get(str).size() + "");
        Bitmap bitmap = this.mapBmp.get(str);
        if (bitmap != null) {
            this.holder.pBar.setVisibility(8);
            this.holder.img.setImageBitmap(bitmap);
        }
        if (this.isOver) {
            this.holder.pBar.setVisibility(8);
        }
        return view;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public void setOver(boolean z) {
        this.isOver = z;
    }

    public void addBmp(String str, Bitmap bitmap) {
        this.mapBmp.put(str, bitmap);
    }

    public void updateGroup(List<String> list) {
        this.groupList = list;
    }

    public void updateChild(Map<String, ArrayList<String>> map) {
        this.childMap = map;
    }

    private class ViewHolder {
        ImageView img;
        ProgressBar pBar;
        TextView sum;
        TextView time;

        private ViewHolder() {
        }
    }
}
