package object.p2pipcam.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.internal.view.SupportMenu;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import object.p2pipcam.utils.DataBaseHelper;
import shix.ihdbell.project.ShowLocalPicGridActivity;

public class ShowLocPicGridViewAdapter extends BaseAdapter {
    public ArrayList<Map<String, Object>> arrayList;
    private Context context;
    private ArrayList<String> delArray = null;
    private String did;
    private ViewHolder holder;
    private LayoutInflater inflater;
    private int mode = 1;

    public long getItemId(int i) {
        return (long) i;
    }

    public ShowLocPicGridViewAdapter(Context context2, String str) {
        this.context = context2;
        this.did = str;
        this.arrayList = new ArrayList<>();
        this.inflater = LayoutInflater.from(context2);
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

    public int getCount() {
        return this.arrayList.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        String obj = this.arrayList.get(i).get("path").toString();
        if (view == null) {
            view = this.inflater.inflate(R.layout.showlocalpicgrid_griditem, (ViewGroup) null);
            this.holder = new ViewHolder();
            this.holder.img = (ImageView) view.findViewById(R.id.imageView1);
            this.holder.playvideo = (ImageView) view.findViewById(R.id.playvideo);
            this.holder.img_delHook = (ImageView) view.findViewById(R.id.del_hook);
            this.holder.baFlag = (TextView) view.findViewById(R.id.tvbadfileflag);
            this.holder.textView_timeshow = (TextView) view.findViewById(R.id.locVidTimeShow);
            view.setTag(this.holder);
        } else {
            this.holder = (ViewHolder) view.getTag();
        }
        Map map = this.arrayList.get(i);
        Bitmap bitmap = (Bitmap) map.get("bmp");
        int intValue = ((Integer) map.get("status")).intValue();
        if (((Integer) map.get(DataBaseHelper.KEY_TYPE)).intValue() == 1) {
            this.holder.baFlag.setVisibility(0);
        } else {
            this.holder.baFlag.setVisibility(8);
        }
        Log.d("tag", "adapter  status:" + intValue + " position:" + i);
        if (intValue == 0) {
            this.holder.img_delHook.setVisibility(8);
            this.holder.img.setPadding(2, 2, 2, 2);
            this.holder.img.setBackgroundColor(16711680);
        } else if (intValue == 1) {
            this.holder.img_delHook.setVisibility(0);
            this.holder.img.setPadding(2, 2, 2, 2);
            this.holder.img.setBackgroundColor(SupportMenu.CATEGORY_MASK);
        }
        int i2 = this.mode;
        if (i2 == 1) {
            this.holder.playvideo.setVisibility(8);
        } else if (i2 == 2) {
            this.holder.playvideo.setVisibility(0);
        }
        this.holder.img.setImageBitmap(bitmap);
        this.holder.textView_timeshow.setText(getContent(obj));
        return view;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public ArrayList<Map<String, Object>> getArrayPics() {
        return this.arrayList;
    }

    public void clearAll() {
        this.arrayList.clear();
    }

    private String getContent(String str) {
        Log.d("tag", "filePath:" + str);
        String substring = str.substring(str.lastIndexOf("/") + 1);
        substring.substring(0, 10);
        String replace = substring.substring(11, 19).replace("_", ":");
        Log.d("tag", "result:" + replace);
        Log.d("tag", "sss:" + substring.substring(0, 16));
        return replace;
    }

    public ArrayList<Map<String, Object>> DelPics() {
        String str;
        DataBaseHelper instance = DataBaseHelper.getInstance(this.context);
        this.delArray = new ArrayList<>();
        for (int i = 0; i < this.arrayList.size(); i++) {
            Map map = this.arrayList.get(i);
            String str2 = (String) map.get("path");
            if (((Integer) map.get("status")).intValue() == 1) {
                this.delArray.add(str2);
            }
        }
        int size = this.delArray.size();
        Log.d("tag", "delArray.size():" + size);
        for (int i2 = 0; i2 < size; i2++) {
            String str3 = this.delArray.get(i2);
            Log.d("tag", "");
            boolean z = true;
            for (int i3 = 0; i3 < this.arrayList.size() && z; i3++) {
                Map map2 = this.arrayList.get(i3);
                String str4 = (String) map2.get("path");
                if (str3.equals(str4)) {
                    int i4 = this.mode;
                    if (i4 != 1) {
                        str = i4 != 2 ? "" : DataBaseHelper.TYPE_VIDEO;
                    } else {
                        str = DataBaseHelper.TYPE_PICTURE;
                    }
                    if (instance.deleteVideoOrPicture(this.did, str4, str)) {
                        File file = new File(str4);
                        if (file.exists()) {
                            file.delete();
                        }
                        map2.clear();
                        this.arrayList.remove(i3);
                        ShowLocalPicGridActivity.arrayList.remove(i3);
                    }
                    z = false;
                }
            }
        }
        this.delArray.clear();
        this.delArray = null;
        return this.arrayList;
    }

    public void addBitmap(Bitmap bitmap, String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("bmp", bitmap);
        hashMap.put("path", str);
        hashMap.put("status", 0);
        hashMap.put(DataBaseHelper.KEY_TYPE, Integer.valueOf(i));
        this.arrayList.add(hashMap);
    }

    private class ViewHolder {
        TextView baFlag;
        ImageView img;
        ImageView img_delHook;
        ImageView playvideo;
        TextView textView_timeshow;

        private ViewHolder() {
        }
    }
}
