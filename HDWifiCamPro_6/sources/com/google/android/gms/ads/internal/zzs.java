package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbf;
import com.google.android.gms.ads.internal.client.zzbi;
import com.google.android.gms.ads.internal.client.zzbr;
import com.google.android.gms.ads.internal.client.zzbw;
import com.google.android.gms.ads.internal.client.zzbz;
import com.google.android.gms.ads.internal.client.zzcd;
import com.google.android.gms.ads.internal.client.zzcg;
import com.google.android.gms.ads.internal.client.zzde;
import com.google.android.gms.ads.internal.client.zzdh;
import com.google.android.gms.ads.internal.client.zzdk;
import com.google.android.gms.ads.internal.client.zzdo;
import com.google.android.gms.ads.internal.client.zzff;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzape;
import com.google.android.gms.internal.ads.zzapf;
import com.google.android.gms.internal.ads.zzbdm;
import com.google.android.gms.internal.ads.zzbjx;
import com.google.android.gms.internal.ads.zzbkg;
import com.google.android.gms.internal.ads.zzbzl;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzcby;
import com.google.android.gms.internal.ads.zzcgi;
import com.google.android.gms.internal.ads.zzcgv;
import com.google.android.gms.internal.ads.zzchc;
import java.util.Map;
import java.util.concurrent.Future;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzs extends zzbr {
    /* access modifiers changed from: private */
    public final zzcgv zza;
    private final zzq zzb;
    /* access modifiers changed from: private */
    public final Future zzc = zzchc.zza.zzb(new zzo(this));
    /* access modifiers changed from: private */
    public final Context zzd;
    private final zzr zze;
    /* access modifiers changed from: private */
    public WebView zzf = new WebView(this.zzd);
    /* access modifiers changed from: private */
    public zzbf zzg;
    /* access modifiers changed from: private */
    public zzape zzh;
    private AsyncTask zzi;

    public zzs(Context context, zzq zzq, String str, zzcgv zzcgv) {
        this.zzd = context;
        this.zza = zzcgv;
        this.zzb = zzq;
        this.zze = new zzr(context, str);
        zzV(0);
        this.zzf.setVerticalScrollBarEnabled(false);
        this.zzf.getSettings().setJavaScriptEnabled(true);
        this.zzf.setWebViewClient(new zzm(this));
        this.zzf.setOnTouchListener(new zzn(this));
    }

    static /* bridge */ /* synthetic */ String zzo(zzs zzs, String str) {
        if (zzs.zzh == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = zzs.zzh.zza(parse, zzs.zzd, (View) null, (Activity) null);
        } catch (zzapf e) {
            zze.zzk("Unable to process ad data", e);
        }
        return parse.toString();
    }

    static /* bridge */ /* synthetic */ void zzw(zzs zzs, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        zzs.zzd.startActivity(intent);
    }

    public final void zzA() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzB() throws RemoteException {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    public final void zzC(zzbc zzbc) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzD(zzbf zzbf) throws RemoteException {
        this.zzg = zzbf;
    }

    public final void zzE(zzbw zzbw) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzF(zzq zzq) throws RemoteException {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    public final void zzG(zzbz zzbz) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzH(zzbdm zzbdm) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzI(zzw zzw) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzJ(zzcg zzcg) {
    }

    public final void zzK(zzdo zzdo) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzL(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzM(zzbzl zzbzl) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzN(boolean z) throws RemoteException {
    }

    public final void zzO(zzbjx zzbjx) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzP(zzde zzde) {
    }

    public final void zzQ(zzbzo zzbzo, String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzR(String str) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzS(zzcby zzcby) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzT(String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzU(zzff zzff) {
        throw new IllegalStateException("Unused method");
    }

    /* access modifiers changed from: package-private */
    public final void zzV(int i) {
        if (this.zzf != null) {
            this.zzf.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
        }
    }

    public final void zzW(IObjectWrapper iObjectWrapper) {
    }

    public final void zzX() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final boolean zzY() throws RemoteException {
        return false;
    }

    public final boolean zzZ() throws RemoteException {
        return false;
    }

    public final boolean zzaa(zzl zzl) throws RemoteException {
        Preconditions.checkNotNull(this.zzf, "This Search Ad has already been torn down");
        this.zze.zzf(zzl, this.zza);
        this.zzi = new zzq(this, (zzp) null).execute(new Void[0]);
        return true;
    }

    public final void zzab(zzcd zzcd) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    /* access modifiers changed from: package-private */
    public final int zzb(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("height");
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            zzaw.zzb();
            return zzcgi.zzw(this.zzd, Integer.parseInt(queryParameter));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public final Bundle zzd() {
        throw new IllegalStateException("Unused method");
    }

    public final zzq zzg() throws RemoteException {
        return this.zzb;
    }

    public final zzbf zzi() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    public final zzbz zzj() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    public final zzdh zzk() {
        return null;
    }

    public final zzdk zzl() {
        return null;
    }

    public final IObjectWrapper zzn() throws RemoteException {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzf);
    }

    /* access modifiers changed from: package-private */
    public final String zzp() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath((String) zzbkg.zzd.zze());
        builder.appendQueryParameter(SearchIntents.EXTRA_QUERY, this.zze.zzd());
        builder.appendQueryParameter("pubId", this.zze.zzc());
        builder.appendQueryParameter("mappver", this.zze.zza());
        Map zze2 = this.zze.zze();
        for (String str : zze2.keySet()) {
            builder.appendQueryParameter(str, (String) zze2.get(str));
        }
        Uri build = builder.build();
        zzape zzape = this.zzh;
        if (zzape != null) {
            try {
                build = zzape.zzb(build, this.zzd);
            } catch (zzapf e) {
                zze.zzk("Unable to process ad data", e);
            }
        }
        String zzq = zzq();
        String encodedQuery = build.getEncodedQuery();
        return zzq + "#" + encodedQuery;
    }

    /* access modifiers changed from: package-private */
    public final String zzq() {
        String zzb2 = this.zze.zzb();
        if (true == TextUtils.isEmpty(zzb2)) {
            zzb2 = "www.google.com";
        }
        return "https://" + zzb2 + ((String) zzbkg.zzd.zze());
    }

    public final String zzr() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    public final String zzs() throws RemoteException {
        return null;
    }

    public final String zzt() throws RemoteException {
        return null;
    }

    public final void zzx() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzi.cancel(true);
        this.zzc.cancel(true);
        this.zzf.destroy();
        this.zzf = null;
    }

    public final void zzy(zzl zzl, zzbi zzbi) {
    }

    public final void zzz() throws RemoteException {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }
}
