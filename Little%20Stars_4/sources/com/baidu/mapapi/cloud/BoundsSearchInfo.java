package com.baidu.mapapi.cloud;

import android.content.ContentValues;
import com.baidu.mapapi.Bounds;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

public class BoundsSearchInfo {
    public String ak;
    public Bounds bounds;
    public ContentValues filter = new ContentValues();
    public int pageIndex = 0;
    public int pageSize = 10;
    public String queryWords;
    public int scope = 1;
    public String sn;
    public int timeStamp = 0;

    /* access modifiers changed from: package-private */
    public String a() {
        if (this.queryWords == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder("?");
        if (this.queryWords != null) {
            try {
                sb.append("q=");
                sb.append(URLEncoder.encode(this.queryWords, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if (this.bounds != null) {
            sb.append("&bounds=");
            double latitudeE6 = (double) this.bounds.leftBottom.getLatitudeE6();
            Double.isNaN(latitudeE6);
            sb.append(latitudeE6 / 1000000.0d);
            sb.append(',');
            double longitudeE6 = (double) this.bounds.leftBottom.getLongitudeE6();
            Double.isNaN(longitudeE6);
            sb.append(longitudeE6 / 1000000.0d);
            sb.append(';');
            double latitudeE62 = (double) this.bounds.rightTop.getLatitudeE6();
            Double.isNaN(latitudeE62);
            sb.append(latitudeE62 / 1000000.0d);
            sb.append(',');
            double longitudeE62 = (double) this.bounds.rightTop.getLongitudeE6();
            Double.isNaN(longitudeE62);
            sb.append(longitudeE62 / 1000000.0d);
        }
        if (this.filter.size() > 0) {
            sb.append("&filter=");
            Iterator<Map.Entry<String, Object>> it = this.filter.valueSet().iterator();
            if (it.hasNext()) {
                Map.Entry next = it.next();
                Object value = next.getValue();
                sb.append((String) next.getKey());
                while (true) {
                    sb.append(':');
                    sb.append(value);
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry next2 = it.next();
                    value = next2.getValue();
                    sb.append('|');
                    sb.append((String) next2.getKey());
                }
            }
        }
        sb.append("&page_index=");
        sb.append(this.pageIndex);
        sb.append("&scope=");
        sb.append(this.scope);
        sb.append("&page_size=");
        sb.append(this.pageSize);
        if (this.ak != null) {
            sb.append("&ak=");
            sb.append(this.ak);
        }
        if (this.sn != null) {
            sb.append("&sn=");
            sb.append(this.sn);
            sb.append("&timestamp=");
            sb.append(this.timeStamp);
        }
        return sb.toString();
    }
}
