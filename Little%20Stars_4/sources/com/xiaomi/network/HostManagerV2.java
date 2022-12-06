package com.xiaomi.network;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.network.a;
import com.xiaomi.channel.commonutils.network.c;
import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.network.HostManager;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import object.p2pipcam.utils.DataBaseHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HostManagerV2 extends HostManager {
    private final int a;
    private final int b;
    private int c;

    protected HostManagerV2(Context context, HostFilter hostFilter, HostManager.HttpGet httpGet, String str) {
        this(context, hostFilter, httpGet, str, (String) null, (String) null);
    }

    protected HostManagerV2(Context context, HostFilter hostFilter, HostManager.HttpGet httpGet, String str, String str2, String str3) {
        super(context, hostFilter, httpGet, str, str2, str3);
        this.a = 80;
        this.b = 5222;
        this.c = 80;
        addReservedHost("resolver.msg.xiaomi.net", "resolver.msg.xiaomi.net:5222");
    }

    static String a(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes("UTF-8");
            for (int i = 0; i < bytes.length; i++) {
                byte b2 = bytes[i];
                byte b3 = b2 & 240;
                if (b3 != 240) {
                    bytes[i] = (byte) (((b2 & 15) ^ ((byte) (((b2 >> 4) + length) & 15))) | b3);
                }
            }
            return new String(bytes);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    /* access modifiers changed from: protected */
    public JSONObject a() {
        JSONObject jSONObject;
        synchronized (this.mHostsMapping) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            jSONObject.put("data", toJSON());
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    public void b(String str) {
        synchronized (this.mHostsMapping) {
            this.mHostsMapping.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") == 2) {
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    Fallbacks fromJSON = new Fallbacks().fromJSON(optJSONArray.getJSONObject(i));
                    this.mHostsMapping.put(fromJSON.getHost(), fromJSON);
                }
            } else {
                throw new JSONException("Bad version");
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkHostMapping() {
        synchronized (this.mHostsMapping) {
            if (hostLoaded) {
                return true;
            }
            hostLoaded = true;
            this.mHostsMapping.clear();
            try {
                String loadHosts = loadHosts();
                if (!TextUtils.isEmpty(loadHosts)) {
                    b(loadHosts);
                    b.b("loading the new hosts succeed");
                    return true;
                }
            } catch (Throwable th) {
                b.a("load bucket failure: " + th.getMessage());
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public String getHost() {
        return "resolver.msg.xiaomi.net";
    }

    /* access modifiers changed from: protected */
    public String getRemoteFallbackJSON(ArrayList<String> arrayList, String str, String str2) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<c> arrayList3 = new ArrayList<>();
        arrayList3.add(new a(DataBaseHelper.KEY_TYPE, str));
        if (str.equals("wap")) {
            arrayList3.add(new a("conpt", a(d.g(this.sAppContext))));
        }
        arrayList3.add(new a("uuid", str2));
        arrayList3.add(new a("list", join(arrayList, Constants.ACCEPT_TIME_SEPARATOR_SP)));
        Fallback localFallback = getLocalFallback("resolver.msg.xiaomi.net");
        String format = String.format(Locale.US, "http://%1$s/gslb/?ver=3.0", new Object[]{"resolver.msg.xiaomi.net:" + this.c});
        if (localFallback == null) {
            arrayList2.add(format);
            synchronized (mReservedHosts) {
                Iterator it = ((ArrayList) mReservedHosts.get("resolver.msg.xiaomi.net")).iterator();
                while (it.hasNext()) {
                    arrayList2.add(String.format(Locale.US, "http://%1$s/gslb/?ver=3.0", new Object[]{(String) it.next()}));
                }
            }
        } else {
            arrayList2 = localFallback.a(format);
        }
        Iterator<String> it2 = arrayList2.iterator();
        IOException e = null;
        while (it2.hasNext()) {
            Uri.Builder buildUpon = Uri.parse(it2.next()).buildUpon();
            for (c cVar : arrayList3) {
                buildUpon.appendQueryParameter(cVar.a(), cVar.b());
            }
            try {
                return this.sHttpGetter == null ? d.a(this.sAppContext, new URL(buildUpon.toString())) : this.sHttpGetter.a(buildUpon.toString());
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            return super.getRemoteFallbackJSON(arrayList, str, str2);
        }
        return null;
    }

    public void persist() {
        synchronized (this.mHostsMapping) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.sAppContext.openFileOutput(getProcessName(), 0)));
                String jSONObject = a().toString();
                if (!TextUtils.isEmpty(jSONObject)) {
                    bufferedWriter.write(jSONObject);
                }
                bufferedWriter.close();
            } catch (Exception e) {
                b.a("persist bucket failure: " + e.getMessage());
            }
        }
    }

    public void purge() {
        synchronized (this.mHostsMapping) {
            for (Fallbacks purge : this.mHostsMapping.values()) {
                purge.purge(true);
            }
            while (true) {
                for (boolean z = false; !z; z = true) {
                    for (String str : this.mHostsMapping.keySet()) {
                        if (((Fallbacks) this.mHostsMapping.get(str)).getFallbacks().isEmpty()) {
                            this.mHostsMapping.remove(str);
                        }
                    }
                }
            }
        }
    }
}
