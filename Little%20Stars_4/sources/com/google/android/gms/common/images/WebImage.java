package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzz;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new zzb();
    private final int mVersionCode;
    private final Uri zzapT;
    private final int zzpi;
    private final int zzpj;

    WebImage(int i, Uri uri, int i2, int i3) {
        this.mVersionCode = i;
        this.zzapT = uri;
        this.zzpi = i2;
        this.zzpj = i3;
    }

    public WebImage(Uri uri) throws IllegalArgumentException {
        this(uri, 0, 0);
    }

    public WebImage(Uri uri, int i, int i2) throws IllegalArgumentException {
        this(1, uri, i, i2);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    public WebImage(JSONObject jSONObject) throws IllegalArgumentException {
        this(zzl(jSONObject), jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
    }

    private static Uri zzl(JSONObject jSONObject) {
        if (jSONObject.has(PushConstants.WEB_URL)) {
            try {
                return Uri.parse(jSONObject.getString(PushConstants.WEB_URL));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) obj;
        return zzz.equal(this.zzapT, webImage.zzapT) && this.zzpi == webImage.zzpi && this.zzpj == webImage.zzpj;
    }

    public int getHeight() {
        return this.zzpj;
    }

    public Uri getUrl() {
        return this.zzapT;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int getWidth() {
        return this.zzpi;
    }

    public int hashCode() {
        return zzz.hashCode(this.zzapT, Integer.valueOf(this.zzpi), Integer.valueOf(this.zzpj));
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PushConstants.WEB_URL, this.zzapT.toString());
            jSONObject.put("width", this.zzpi);
            jSONObject.put("height", this.zzpj);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return String.format("Image %dx%d %s", new Object[]{Integer.valueOf(this.zzpi), Integer.valueOf(this.zzpj), this.zzapT.toString()});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
