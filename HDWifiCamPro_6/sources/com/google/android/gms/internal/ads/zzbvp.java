package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public abstract class zzbvp extends zzasa implements zzbvq {
    public zzbvp() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public static zzbvq zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        return queryLocalInterface instanceof zzbvq ? (zzbvq) queryLocalInterface : new zzbvo(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbI(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zze();
                break;
            case 2:
                zzf();
                break;
            case 3:
                int readInt = parcel.readInt();
                zzasb.zzc(parcel);
                zzg(readInt);
                break;
            case 4:
                zzn();
                break;
            case 5:
                zzp();
                break;
            case 6:
                zzo();
                break;
            case 7:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
                    if (queryLocalInterface instanceof zzbvu) {
                        zzbvu zzbvu = (zzbvu) queryLocalInterface;
                    }
                }
                zzasb.zzc(parcel);
                break;
            case 8:
                zzm();
                break;
            case 9:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                zzasb.zzc(parcel);
                zzq(readString, readString2);
                break;
            case 10:
                zzbmx.zzb(parcel.readStrongBinder());
                parcel.readString();
                zzasb.zzc(parcel);
                break;
            case 11:
                zzv();
                break;
            case 12:
                parcel.readString();
                zzasb.zzc(parcel);
                break;
            case 13:
                zzy();
                break;
            case 14:
                zzasb.zzc(parcel);
                zzs((zzcce) zzasb.zza(parcel, zzcce.CREATOR));
                break;
            case 15:
                zzw();
                break;
            case 16:
                zzcci zzb = zzcch.zzb(parcel.readStrongBinder());
                zzasb.zzc(parcel);
                zzt(zzb);
                break;
            case 17:
                int readInt2 = parcel.readInt();
                zzasb.zzc(parcel);
                zzj(readInt2);
                break;
            case 18:
                zzu();
                break;
            case 19:
                Bundle bundle = (Bundle) zzasb.zza(parcel, Bundle.CREATOR);
                zzasb.zzc(parcel);
                break;
            case 20:
                zzx();
                break;
            case 21:
                String readString3 = parcel.readString();
                zzasb.zzc(parcel);
                zzl(readString3);
                break;
            case 22:
                int readInt3 = parcel.readInt();
                String readString4 = parcel.readString();
                zzasb.zzc(parcel);
                zzi(readInt3, readString4);
                break;
            case 23:
                zzasb.zzc(parcel);
                zzh((zze) zzasb.zza(parcel, zze.CREATOR));
                break;
            case 24:
                zzasb.zzc(parcel);
                zzk((zze) zzasb.zza(parcel, zze.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
