package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzasa;
import com.google.android.gms.internal.ads.zzasb;
import com.google.android.gms.internal.ads.zzbmi;
import com.google.android.gms.internal.ads.zzbmo;
import com.google.android.gms.internal.ads.zzbqq;
import com.google.android.gms.internal.ads.zzbqr;
import com.google.android.gms.internal.ads.zzbqu;
import com.google.android.gms.internal.ads.zzbvj;
import com.google.android.gms.internal.ads.zzbvk;
import com.google.android.gms.internal.ads.zzbyv;
import com.google.android.gms.internal.ads.zzbzc;
import com.google.android.gms.internal.ads.zzcbv;
import com.google.android.gms.internal.ads.zzccl;
import com.google.android.gms.internal.ads.zzcfg;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public abstract class zzcb extends zzasa implements zzcc {
    public zzcb() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbI(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                String readString = parcel.readString();
                zzbvk zzf = zzbvj.zzf(parcel.readStrongBinder());
                int readInt = parcel.readInt();
                zzasb.zzc(parcel);
                zzbs zzd = zzd(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzq) zzasb.zza(parcel, zzq.CREATOR), readString, zzf, readInt);
                parcel2.writeNoException();
                zzasb.zzg(parcel2, zzd);
                return true;
            case 2:
                String readString2 = parcel.readString();
                zzbvk zzf2 = zzbvj.zzf(parcel.readStrongBinder());
                int readInt2 = parcel.readInt();
                zzasb.zzc(parcel);
                zzbs zze = zze(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzq) zzasb.zza(parcel, zzq.CREATOR), readString2, zzf2, readInt2);
                parcel2.writeNoException();
                zzasb.zzg(parcel2, zze);
                return true;
            case 3:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String readString3 = parcel.readString();
                zzbvk zzf3 = zzbvj.zzf(parcel.readStrongBinder());
                int readInt3 = parcel.readInt();
                zzasb.zzc(parcel);
                zzbo zzb = zzb(asInterface, readString3, zzf3, readInt3);
                parcel2.writeNoException();
                zzasb.zzg(parcel2, zzb);
                return true;
            case 4:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzasb.zzc(parcel);
                parcel2.writeNoException();
                zzasb.zzg(parcel2, (IInterface) null);
                return true;
            case 5:
                IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzasb.zzc(parcel);
                zzbmi zzh = zzh(asInterface2, asInterface3);
                parcel2.writeNoException();
                zzasb.zzg(parcel2, zzh);
                return true;
            case 6:
                IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbvk zzf4 = zzbvj.zzf(parcel.readStrongBinder());
                int readInt4 = parcel.readInt();
                zzasb.zzc(parcel);
                zzcbv zzm = zzm(asInterface4, zzf4, readInt4);
                parcel2.writeNoException();
                zzasb.zzg(parcel2, zzm);
                return true;
            case 7:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzasb.zzc(parcel);
                parcel2.writeNoException();
                zzasb.zzg(parcel2, (IInterface) null);
                return true;
            case 8:
                IObjectWrapper asInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzasb.zzc(parcel);
                zzbzc zzl = zzl(asInterface5);
                parcel2.writeNoException();
                zzasb.zzg(parcel2, zzl);
                return true;
            case 9:
                IObjectWrapper asInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                int readInt5 = parcel.readInt();
                zzasb.zzc(parcel);
                zzcm zzg = zzg(asInterface6, readInt5);
                parcel2.writeNoException();
                zzasb.zzg(parcel2, zzg);
                return true;
            case 10:
                String readString4 = parcel.readString();
                int readInt6 = parcel.readInt();
                zzasb.zzc(parcel);
                zzbs zzf5 = zzf(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzq) zzasb.zza(parcel, zzq.CREATOR), readString4, readInt6);
                parcel2.writeNoException();
                zzasb.zzg(parcel2, zzf5);
                return true;
            case 11:
                IObjectWrapper asInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzasb.zzc(parcel);
                zzbmo zzi = zzi(asInterface7, asInterface8, asInterface9);
                parcel2.writeNoException();
                zzasb.zzg(parcel2, zzi);
                return true;
            case 12:
                IObjectWrapper asInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String readString5 = parcel.readString();
                zzbvk zzf6 = zzbvj.zzf(parcel.readStrongBinder());
                int readInt7 = parcel.readInt();
                zzasb.zzc(parcel);
                zzccl zzn = zzn(asInterface10, readString5, zzf6, readInt7);
                parcel2.writeNoException();
                zzasb.zzg(parcel2, zzn);
                return true;
            case 13:
                String readString6 = parcel.readString();
                zzbvk zzf7 = zzbvj.zzf(parcel.readStrongBinder());
                int readInt8 = parcel.readInt();
                zzasb.zzc(parcel);
                zzbs zzc = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzq) zzasb.zza(parcel, zzq.CREATOR), readString6, zzf7, readInt8);
                parcel2.writeNoException();
                zzasb.zzg(parcel2, zzc);
                return true;
            case 14:
                IObjectWrapper asInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbvk zzf8 = zzbvj.zzf(parcel.readStrongBinder());
                int readInt9 = parcel.readInt();
                zzasb.zzc(parcel);
                zzcfg zzo = zzo(asInterface11, zzf8, readInt9);
                parcel2.writeNoException();
                zzasb.zzg(parcel2, zzo);
                return true;
            case 15:
                IObjectWrapper asInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbvk zzf9 = zzbvj.zzf(parcel.readStrongBinder());
                int readInt10 = parcel.readInt();
                zzasb.zzc(parcel);
                zzbyv zzk = zzk(asInterface12, zzf9, readInt10);
                parcel2.writeNoException();
                zzasb.zzg(parcel2, zzk);
                return true;
            case 16:
                IObjectWrapper asInterface13 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbvk zzf10 = zzbvj.zzf(parcel.readStrongBinder());
                int readInt11 = parcel.readInt();
                zzbqr zzc2 = zzbqq.zzc(parcel.readStrongBinder());
                zzasb.zzc(parcel);
                zzbqu zzj = zzj(asInterface13, zzf10, readInt11, zzc2);
                parcel2.writeNoException();
                zzasb.zzg(parcel2, zzj);
                return true;
            default:
                return false;
        }
    }
}
