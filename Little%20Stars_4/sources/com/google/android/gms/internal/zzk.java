package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.zzb;
import com.google.android.gms.internal.zzm;
import com.google.android.gms.internal.zzs;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;

public abstract class zzk<T> implements Comparable<zzk<T>> {
    /* access modifiers changed from: private */
    public final zzs.zza zzC;
    private final int zzD;
    private final String zzE;
    private final int zzF;
    private final zzm.zza zzG;
    private Integer zzH;
    private zzl zzI;
    private boolean zzJ;
    private boolean zzK;
    private boolean zzL;
    private long zzM;
    private zzo zzN;
    private zzb.zza zzO;

    public enum zza {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public zzk(int i, String str, zzm.zza zza2) {
        this.zzC = zzs.zza.zzaj ? new zzs.zza() : null;
        this.zzJ = true;
        this.zzK = false;
        this.zzL = false;
        this.zzM = 0;
        this.zzO = null;
        this.zzD = i;
        this.zzE = str;
        this.zzG = zza2;
        zza((zzo) new zzd());
        this.zzF = zzb(str);
    }

    private byte[] zza(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry next : map.entrySet()) {
                sb.append(URLEncoder.encode((String) next.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode((String) next.getValue(), str));
                sb.append('&');
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e) {
            String valueOf = String.valueOf(str);
            throw new RuntimeException(valueOf.length() != 0 ? "Encoding not supported: ".concat(valueOf) : new String("Encoding not supported: "), e);
        }
    }

    private static int zzb(String str) {
        Uri parse;
        String host;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    public Map<String, String> getHeaders() throws zza {
        return Collections.emptyMap();
    }

    public int getMethod() {
        return this.zzD;
    }

    public String getUrl() {
        return this.zzE;
    }

    public boolean isCanceled() {
        return false;
    }

    public String toString() {
        String valueOf = String.valueOf(Integer.toHexString(zzf()));
        String concat = valueOf.length() != 0 ? "0x".concat(valueOf) : new String("0x");
        String valueOf2 = String.valueOf(getUrl());
        String valueOf3 = String.valueOf(zzr());
        String valueOf4 = String.valueOf(this.zzH);
        StringBuilder sb = new StringBuilder("[ ] ".length() + 3 + String.valueOf(valueOf2).length() + String.valueOf(concat).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append("[ ] ");
        sb.append(valueOf2);
        sb.append(" ");
        sb.append(concat);
        sb.append(" ");
        sb.append(valueOf3);
        sb.append(" ");
        sb.append(valueOf4);
        return sb.toString();
    }

    public final zzk<?> zza(int i) {
        this.zzH = Integer.valueOf(i);
        return this;
    }

    public zzk<?> zza(zzb.zza zza2) {
        this.zzO = zza2;
        return this;
    }

    public zzk<?> zza(zzl zzl) {
        this.zzI = zzl;
        return this;
    }

    public zzk<?> zza(zzo zzo) {
        this.zzN = zzo;
        return this;
    }

    /* access modifiers changed from: protected */
    public abstract zzm<T> zza(zzi zzi);

    /* access modifiers changed from: protected */
    public abstract void zza(T t);

    /* access modifiers changed from: protected */
    public zzr zzb(zzr zzr) {
        return zzr;
    }

    /* renamed from: zzc */
    public int compareTo(zzk<T> zzk) {
        zza zzr = zzr();
        zza zzr2 = zzk.zzr();
        return zzr == zzr2 ? this.zzH.intValue() - zzk.zzH.intValue() : zzr2.ordinal() - zzr.ordinal();
    }

    public void zzc(zzr zzr) {
        zzm.zza zza2 = this.zzG;
        if (zza2 != null) {
            zza2.zze(zzr);
        }
    }

    public void zzc(String str) {
        if (zzs.zza.zzaj) {
            this.zzC.zza(str, Thread.currentThread().getId());
        } else if (this.zzM == 0) {
            this.zzM = SystemClock.elapsedRealtime();
        }
    }

    /* access modifiers changed from: package-private */
    public void zzd(final String str) {
        zzl zzl = this.zzI;
        if (zzl != null) {
            zzl.zzf(this);
        }
        if (zzs.zza.zzaj) {
            final long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        zzk.this.zzC.zza(str, id);
                        zzk.this.zzC.zzd(toString());
                    }
                });
                return;
            }
            this.zzC.zza(str, id);
            this.zzC.zzd(toString());
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzM;
        if (elapsedRealtime >= 3000) {
            zzs.zzb("%d ms: %s", Long.valueOf(elapsedRealtime), toString());
        }
    }

    public int zzf() {
        return this.zzF;
    }

    public String zzg() {
        return getUrl();
    }

    public zzb.zza zzh() {
        return this.zzO;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public Map<String, String> zzi() throws zza {
        return zzm();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public String zzj() {
        return zzn();
    }

    @Deprecated
    public String zzk() {
        return zzo();
    }

    @Deprecated
    public byte[] zzl() throws zza {
        Map<String, String> zzi = zzi();
        if (zzi == null || zzi.size() <= 0) {
            return null;
        }
        return zza(zzi, zzj());
    }

    /* access modifiers changed from: protected */
    public Map<String, String> zzm() throws zza {
        return null;
    }

    /* access modifiers changed from: protected */
    public String zzn() {
        return "UTF-8";
    }

    public String zzo() {
        String valueOf = String.valueOf(zzn());
        return valueOf.length() != 0 ? "application/x-www-form-urlencoded; charset=".concat(valueOf) : new String("application/x-www-form-urlencoded; charset=");
    }

    public byte[] zzp() throws zza {
        Map<String, String> zzm = zzm();
        if (zzm == null || zzm.size() <= 0) {
            return null;
        }
        return zza(zzm, zzn());
    }

    public final boolean zzq() {
        return this.zzJ;
    }

    public zza zzr() {
        return zza.NORMAL;
    }

    public final int zzs() {
        return this.zzN.zzc();
    }

    public zzo zzt() {
        return this.zzN;
    }

    public void zzu() {
        this.zzL = true;
    }

    public boolean zzv() {
        return this.zzL;
    }
}
