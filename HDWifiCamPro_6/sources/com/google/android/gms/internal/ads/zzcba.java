package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcba extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcba> CREATOR = new zzcbb();
    ParcelFileDescriptor zza;
    private Parcelable zzb = null;
    private boolean zzc = true;

    public zzcba(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza = parcelFileDescriptor;
    }

    /* JADX INFO: finally extract failed */
    public final void writeToParcel(Parcel parcel, int i) {
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        if (this.zza == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.zzb.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                ParcelFileDescriptor parcelFileDescriptor = null;
                try {
                    ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                    autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(createPipe[1]);
                    try {
                        zzchc.zza.execute(new zzcaz(autoCloseOutputStream, marshall));
                        parcelFileDescriptor = createPipe[0];
                    } catch (IOException e) {
                        e = e;
                    }
                } catch (IOException e2) {
                    e = e2;
                    autoCloseOutputStream = null;
                    zze.zzh("Error transporting the ad response", e);
                    zzt.zzo().zzt(e, "LargeParcelTeleporter.pipeData.2");
                    IOUtils.closeQuietly((Closeable) autoCloseOutputStream);
                    this.zza = parcelFileDescriptor;
                    int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
                    SafeParcelWriter.writeParcelable(parcel, 2, this.zza, i, false);
                    SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
                }
                this.zza = parcelFileDescriptor;
            } catch (Throwable th) {
                obtain.recycle();
                throw th;
            }
        }
        int beginObjectHeader2 = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zza, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader2);
    }

    /* JADX INFO: finally extract failed */
    public final SafeParcelable zza(Parcelable.Creator creator) {
        if (this.zzc) {
            ParcelFileDescriptor parcelFileDescriptor = this.zza;
            if (parcelFileDescriptor == null) {
                zze.zzg("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                int length = bArr.length;
                dataInputStream.readFully(bArr, 0, length);
                IOUtils.closeQuietly((Closeable) dataInputStream);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.unmarshall(bArr, 0, length);
                    obtain.setDataPosition(0);
                    this.zzb = (Parcelable) creator.createFromParcel(obtain);
                    obtain.recycle();
                    this.zzc = false;
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            } catch (IOException e) {
                zze.zzh("Could not read from parcel file descriptor", e);
                IOUtils.closeQuietly((Closeable) dataInputStream);
                return null;
            } catch (Throwable th2) {
                IOUtils.closeQuietly((Closeable) dataInputStream);
                throw th2;
            }
        }
        return (SafeParcelable) this.zzb;
    }
}
