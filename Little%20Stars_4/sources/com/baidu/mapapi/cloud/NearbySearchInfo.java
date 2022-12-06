package com.baidu.mapapi.cloud;

import android.content.ContentValues;
import com.baidu.mapapi.GeoPoint;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

public class NearbySearchInfo {
    public String ak;
    public ContentValues filter = new ContentValues();
    public GeoPoint location;
    public int pageIndex = 0;
    public int pageSize = 10;
    public String queryWords;
    public int radius = PushConstants.PUSHSERVICE_INFO_SENDMESSAGE_BY_NOTIFICATIONSERVICE;
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
        if (this.location != null) {
            sb.append("&location=");
            double latitudeE6 = (double) this.location.getLatitudeE6();
            Double.isNaN(latitudeE6);
            sb.append(latitudeE6 / 1000000.0d);
            sb.append(',');
            double longitudeE6 = (double) this.location.getLongitudeE6();
            Double.isNaN(longitudeE6);
            sb.append(longitudeE6 / 1000000.0d);
        }
        sb.append("&radius=");
        sb.append(this.radius);
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
