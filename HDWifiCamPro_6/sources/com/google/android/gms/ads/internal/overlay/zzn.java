package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.ads.zzcgv;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzn implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z = false;
        int i = 0;
        int i2 = 0;
        zzc zzc = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        String str2 = null;
        IBinder iBinder5 = null;
        String str3 = null;
        zzcgv zzcgv = null;
        String str4 = null;
        zzj zzj = null;
        IBinder iBinder6 = null;
        String str5 = null;
        IBinder iBinder7 = null;
        IBinder iBinder8 = null;
        IBinder iBinder9 = null;
        IBinder iBinder10 = null;
        String str6 = null;
        String str7 = null;
        IBinder iBinder11 = null;
        IBinder iBinder12 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    zzc = (zzc) SafeParcelReader.createParcelable(parcel2, readHeader, zzc.CREATOR);
                    break;
                case 3:
                    iBinder = SafeParcelReader.readIBinder(parcel2, readHeader);
                    break;
                case 4:
                    iBinder2 = SafeParcelReader.readIBinder(parcel2, readHeader);
                    break;
                case 5:
                    iBinder3 = SafeParcelReader.readIBinder(parcel2, readHeader);
                    break;
                case 6:
                    iBinder4 = SafeParcelReader.readIBinder(parcel2, readHeader);
                    break;
                case 7:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 8:
                    z = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 9:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 10:
                    iBinder5 = SafeParcelReader.readIBinder(parcel2, readHeader);
                    break;
                case 11:
                    i = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 12:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 13:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 14:
                    zzcgv = (zzcgv) SafeParcelReader.createParcelable(parcel2, readHeader, zzcgv.CREATOR);
                    break;
                case 16:
                    str4 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 17:
                    zzj = (zzj) SafeParcelReader.createParcelable(parcel2, readHeader, zzj.CREATOR);
                    break;
                case 18:
                    iBinder6 = SafeParcelReader.readIBinder(parcel2, readHeader);
                    break;
                case 19:
                    str5 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 20:
                    iBinder7 = SafeParcelReader.readIBinder(parcel2, readHeader);
                    break;
                case 21:
                    iBinder8 = SafeParcelReader.readIBinder(parcel2, readHeader);
                    break;
                case 22:
                    iBinder9 = SafeParcelReader.readIBinder(parcel2, readHeader);
                    break;
                case 23:
                    iBinder10 = SafeParcelReader.readIBinder(parcel2, readHeader);
                    break;
                case 24:
                    str6 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 25:
                    str7 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 26:
                    iBinder11 = SafeParcelReader.readIBinder(parcel2, readHeader);
                    break;
                case 27:
                    iBinder12 = SafeParcelReader.readIBinder(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new AdOverlayInfoParcel(zzc, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i, i2, str3, zzcgv, str4, zzj, iBinder6, str5, iBinder7, iBinder8, iBinder9, iBinder10, str6, str7, iBinder11, iBinder12);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new AdOverlayInfoParcel[i];
    }
}
