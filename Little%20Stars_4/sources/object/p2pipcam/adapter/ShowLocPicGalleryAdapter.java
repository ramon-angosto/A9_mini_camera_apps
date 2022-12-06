package object.p2pipcam.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import com.baidu.mapapi.MKEvent;
import com.jxl.app.littlestars.project.R;
import java.util.ArrayList;
import java.util.Map;
import object.p2pipcam.customComponent.MyLocalPicImageView;

public class ShowLocPicGalleryAdapter extends BaseAdapter {
    private Context context;
    private MyLocalPicImageView img;
    private ArrayList<Map<String, Object>> list;
    private Matrix matrix = new Matrix();

    public long getItemId(int i) {
        return (long) i;
    }

    public ShowLocPicGalleryAdapter(Context context2, ArrayList<Map<String, Object>> arrayList) {
        this.context = context2;
        this.list = arrayList;
        this.matrix.postScale(0.7f, 0.7f);
    }

    public int getCount() {
        return this.list.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        String str = (String) this.list.get(i).get("path");
        try {
            Bitmap bitmap = getBitmap(str);
            this.img = new MyLocalPicImageView(this.context, bitmap.getWidth(), bitmap.getHeight());
            this.img.setLayoutParams(new Gallery.LayoutParams(-1, -1));
            this.img.setImageBitmap(bitmap);
        } catch (Exception unused) {
            Bitmap bitmap2 = getBitmap(str);
            this.img = new MyLocalPicImageView(this.context, 100, 50);
            this.img.setLayoutParams(new Gallery.LayoutParams(-1, -1));
            this.img.setImageBitmap(bitmap2);
        }
        return this.img;
    }

    private Bitmap getBitmap(String str) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        if (decodeFile != null) {
            return (decodeFile.getWidth() <= 640 || decodeFile.getHeight() <= 480) ? decodeFile : Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), this.matrix, true);
        }
        return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.context.getResources(), R.drawable.camer_ico), MKEvent.ERROR_LOCATION_FAILED, MKEvent.ERROR_LOCATION_FAILED, true);
    }
}
