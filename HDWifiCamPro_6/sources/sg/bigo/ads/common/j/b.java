package sg.bigo.ads.common.j;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Parcel;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.common.d;
import sg.bigo.ads.common.f.c;
import sg.bigo.ads.common.k.a;

public final class b implements d {
    public static final long a = TimeUnit.HOURS.toMillis(1);
    public boolean b;
    public double c;
    public double d;
    public String e;
    public String f;
    public String g;
    public long h;
    /* access modifiers changed from: private */
    public final Context i;
    /* access modifiers changed from: private */
    public final AtomicBoolean j;
    private Runnable k;

    public b(Context context) {
        this(context, 0);
    }

    b(Context context, long j2) {
        this.b = false;
        this.j = new AtomicBoolean(false);
        this.k = new Runnable() {
            public final void run() {
                List<Address> list;
                try {
                    list = new Geocoder(b.this.i, Locale.ENGLISH).getFromLocation(b.this.d, b.this.c, 1);
                } catch (IOException e) {
                    a.a(0, HttpHeaders.LOCATION, "code io error, longitude=" + b.this.c + ", latitude=" + b.this.d + ", " + e.getMessage());
                    list = null;
                }
                if (list == null || list.isEmpty()) {
                    a.a(0, HttpHeaders.LOCATION, "address is empty, longitude=" + b.this.c + ", latitude=" + b.this.d);
                } else {
                    Address address = list.get(0);
                    if (address != null) {
                        String locality = address.getLocality();
                        if (!TextUtils.isEmpty(locality)) {
                            String unused = b.this.g = locality.toLowerCase(Locale.ENGLISH);
                        }
                        String adminArea = address.getAdminArea();
                        if (TextUtils.isEmpty(adminArea)) {
                            adminArea = address.getSubAdminArea();
                        }
                        if (!TextUtils.isEmpty(adminArea)) {
                            String unused2 = b.this.f = adminArea.toLowerCase(Locale.ENGLISH);
                        }
                        String countryCode = address.getCountryCode();
                        if (!TextUtils.isEmpty(countryCode)) {
                            String unused3 = b.this.e = countryCode.toLowerCase(Locale.ENGLISH);
                        }
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append(b.this);
                a.a(0, 3, HttpHeaders.LOCATION, sb.toString());
                b.this.j.set(false);
            }
        };
        this.i = context;
        this.h = j2;
    }

    b(Context context, Location location) {
        this.b = false;
        this.j = new AtomicBoolean(false);
        this.k = new Runnable() {
            public final void run() {
                List<Address> list;
                try {
                    list = new Geocoder(b.this.i, Locale.ENGLISH).getFromLocation(b.this.d, b.this.c, 1);
                } catch (IOException e) {
                    a.a(0, HttpHeaders.LOCATION, "code io error, longitude=" + b.this.c + ", latitude=" + b.this.d + ", " + e.getMessage());
                    list = null;
                }
                if (list == null || list.isEmpty()) {
                    a.a(0, HttpHeaders.LOCATION, "address is empty, longitude=" + b.this.c + ", latitude=" + b.this.d);
                } else {
                    Address address = list.get(0);
                    if (address != null) {
                        String locality = address.getLocality();
                        if (!TextUtils.isEmpty(locality)) {
                            String unused = b.this.g = locality.toLowerCase(Locale.ENGLISH);
                        }
                        String adminArea = address.getAdminArea();
                        if (TextUtils.isEmpty(adminArea)) {
                            adminArea = address.getSubAdminArea();
                        }
                        if (!TextUtils.isEmpty(adminArea)) {
                            String unused2 = b.this.f = adminArea.toLowerCase(Locale.ENGLISH);
                        }
                        String countryCode = address.getCountryCode();
                        if (!TextUtils.isEmpty(countryCode)) {
                            String unused3 = b.this.e = countryCode.toLowerCase(Locale.ENGLISH);
                        }
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append(b.this);
                a.a(0, 3, HttpHeaders.LOCATION, sb.toString());
                b.this.j.set(false);
            }
        };
        this.i = context.getApplicationContext();
        this.h = System.currentTimeMillis();
        this.c = location.getLongitude();
        this.d = location.getLatitude();
        if (!this.j.compareAndSet(false, true)) {
            c.a(this.k);
        }
        c.a(1, this.k);
    }

    public b(Context context, Parcel parcel) {
        this.b = false;
        this.j = new AtomicBoolean(false);
        this.k = new Runnable() {
            public final void run() {
                List<Address> list;
                try {
                    list = new Geocoder(b.this.i, Locale.ENGLISH).getFromLocation(b.this.d, b.this.c, 1);
                } catch (IOException e) {
                    a.a(0, HttpHeaders.LOCATION, "code io error, longitude=" + b.this.c + ", latitude=" + b.this.d + ", " + e.getMessage());
                    list = null;
                }
                if (list == null || list.isEmpty()) {
                    a.a(0, HttpHeaders.LOCATION, "address is empty, longitude=" + b.this.c + ", latitude=" + b.this.d);
                } else {
                    Address address = list.get(0);
                    if (address != null) {
                        String locality = address.getLocality();
                        if (!TextUtils.isEmpty(locality)) {
                            String unused = b.this.g = locality.toLowerCase(Locale.ENGLISH);
                        }
                        String adminArea = address.getAdminArea();
                        if (TextUtils.isEmpty(adminArea)) {
                            adminArea = address.getSubAdminArea();
                        }
                        if (!TextUtils.isEmpty(adminArea)) {
                            String unused2 = b.this.f = adminArea.toLowerCase(Locale.ENGLISH);
                        }
                        String countryCode = address.getCountryCode();
                        if (!TextUtils.isEmpty(countryCode)) {
                            String unused3 = b.this.e = countryCode.toLowerCase(Locale.ENGLISH);
                        }
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append(b.this);
                a.a(0, 3, HttpHeaders.LOCATION, sb.toString());
                b.this.j.set(false);
            }
        };
        this.i = context;
        b(parcel);
    }

    public final void a(Parcel parcel) {
        parcel.writeDouble(this.c);
        parcel.writeDouble(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeLong(this.h);
    }

    public final void b(Parcel parcel) {
        this.c = parcel.readDouble();
        this.d = parcel.readDouble();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readLong();
    }

    public final String toString() {
        return "{longitude=" + this.c + ", latitude=" + this.d + ", countryCode='" + this.e + '\'' + ", state='" + this.f + '\'' + ", city='" + this.g + '\'' + ", updateTime='" + this.h + '\'' + '}';
    }
}
