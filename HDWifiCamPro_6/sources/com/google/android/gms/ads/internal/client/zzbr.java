package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzasa;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public abstract class zzbr extends zzasa implements zzbs {
    public zzbr() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzbs zzac(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        return queryLocalInterface instanceof zzbs ? (zzbs) queryLocalInterface : new zzbq(iBinder);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v18, resolved type: com.google.android.gms.ads.internal.client.zzcd} */
    /* JADX WARNING: type inference failed for: r6v1 */
    /* JADX WARNING: type inference failed for: r6v2, types: [com.google.android.gms.ads.internal.client.zzbf] */
    /* JADX WARNING: type inference failed for: r6v7, types: [com.google.android.gms.ads.internal.client.zzbz] */
    /* JADX WARNING: type inference failed for: r6v13, types: [com.google.android.gms.ads.internal.client.zzbc] */
    /* JADX WARNING: type inference failed for: r6v23, types: [com.google.android.gms.ads.internal.client.zzbw] */
    /* JADX WARNING: type inference failed for: r6v28, types: [com.google.android.gms.ads.internal.client.zzde] */
    /* JADX WARNING: type inference failed for: r6v33, types: [com.google.android.gms.ads.internal.client.zzbi] */
    /* JADX WARNING: type inference failed for: r6v38, types: [com.google.android.gms.ads.internal.client.zzcg] */
    /* JADX WARNING: type inference failed for: r6v43 */
    /* JADX WARNING: type inference failed for: r6v44 */
    /* JADX WARNING: type inference failed for: r6v45 */
    /* JADX WARNING: type inference failed for: r6v46 */
    /* JADX WARNING: type inference failed for: r6v47 */
    /* JADX WARNING: type inference failed for: r6v48 */
    /* JADX WARNING: type inference failed for: r6v49 */
    /* JADX WARNING: type inference failed for: r6v50 */
    /* JADX WARNING: type inference failed for: r6v51 */
    /* JADX WARNING: type inference failed for: r6v52 */
    /* JADX WARNING: type inference failed for: r6v53 */
    /* JADX WARNING: type inference failed for: r6v54 */
    /* JADX WARNING: type inference failed for: r6v55 */
    /* JADX WARNING: type inference failed for: r6v56 */
    /* JADX WARNING: type inference failed for: r6v57 */
    /* JADX WARNING: type inference failed for: r6v58 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzbI(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) throws android.os.RemoteException {
        /*
            r2 = this;
            r6 = 0
            switch(r3) {
                case 1: goto L_0x02ed;
                case 2: goto L_0x02e6;
                case 3: goto L_0x02db;
                case 4: goto L_0x02c5;
                case 5: goto L_0x02be;
                case 6: goto L_0x02b7;
                case 7: goto L_0x0294;
                case 8: goto L_0x0271;
                case 9: goto L_0x0269;
                case 10: goto L_0x0264;
                case 11: goto L_0x025c;
                case 12: goto L_0x0250;
                case 13: goto L_0x023d;
                case 14: goto L_0x022a;
                case 15: goto L_0x0213;
                case 16: goto L_0x0004;
                case 17: goto L_0x0004;
                case 18: goto L_0x0207;
                case 19: goto L_0x01f4;
                case 20: goto L_0x01d0;
                case 21: goto L_0x01ac;
                case 22: goto L_0x019d;
                case 23: goto L_0x0191;
                case 24: goto L_0x017e;
                case 25: goto L_0x016f;
                case 26: goto L_0x0163;
                case 27: goto L_0x0004;
                case 28: goto L_0x0004;
                case 29: goto L_0x0150;
                case 30: goto L_0x013d;
                case 31: goto L_0x0131;
                case 32: goto L_0x0125;
                case 33: goto L_0x0119;
                case 34: goto L_0x010a;
                case 35: goto L_0x00fe;
                case 36: goto L_0x00da;
                case 37: goto L_0x00ce;
                case 38: goto L_0x00bf;
                case 39: goto L_0x00ac;
                case 40: goto L_0x0099;
                case 41: goto L_0x008d;
                case 42: goto L_0x0069;
                case 43: goto L_0x003d;
                case 44: goto L_0x002a;
                case 45: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r3 = 0
            return r3
        L_0x0006:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x000d
            goto L_0x001f
        L_0x000d:
            java.lang.String r6 = "com.google.android.gms.ads.internal.client.IFullScreenContentCallback"
            android.os.IInterface r6 = r3.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.ads.internal.client.zzcg
            if (r0 == 0) goto L_0x001a
            com.google.android.gms.ads.internal.client.zzcg r6 = (com.google.android.gms.ads.internal.client.zzcg) r6
            goto L_0x001f
        L_0x001a:
            com.google.android.gms.ads.internal.client.zzce r6 = new com.google.android.gms.ads.internal.client.zzce
            r6.<init>(r3)
        L_0x001f:
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzJ(r6)
            r5.writeNoException()
            goto L_0x02f7
        L_0x002a:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzW(r3)
            r5.writeNoException()
            goto L_0x02f7
        L_0x003d:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zzl> r3 = com.google.android.gms.ads.internal.client.zzl.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzasb.zza(r4, r3)
            com.google.android.gms.ads.internal.client.zzl r3 = (com.google.android.gms.ads.internal.client.zzl) r3
            android.os.IBinder r0 = r4.readStrongBinder()
            if (r0 != 0) goto L_0x004c
            goto L_0x005e
        L_0x004c:
            java.lang.String r6 = "com.google.android.gms.ads.internal.client.IAdLoadCallback"
            android.os.IInterface r6 = r0.queryLocalInterface(r6)
            boolean r1 = r6 instanceof com.google.android.gms.ads.internal.client.zzbi
            if (r1 == 0) goto L_0x0059
            com.google.android.gms.ads.internal.client.zzbi r6 = (com.google.android.gms.ads.internal.client.zzbi) r6
            goto L_0x005e
        L_0x0059:
            com.google.android.gms.ads.internal.client.zzbg r6 = new com.google.android.gms.ads.internal.client.zzbg
            r6.<init>(r0)
        L_0x005e:
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzy(r3, r6)
            r5.writeNoException()
            goto L_0x02f7
        L_0x0069:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x0070
            goto L_0x0082
        L_0x0070:
            java.lang.String r6 = "com.google.android.gms.ads.internal.client.IOnPaidEventListener"
            android.os.IInterface r6 = r3.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.ads.internal.client.zzde
            if (r0 == 0) goto L_0x007d
            com.google.android.gms.ads.internal.client.zzde r6 = (com.google.android.gms.ads.internal.client.zzde) r6
            goto L_0x0082
        L_0x007d:
            com.google.android.gms.ads.internal.client.zzdc r6 = new com.google.android.gms.ads.internal.client.zzdc
            r6.<init>(r3)
        L_0x0082:
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzP(r6)
            r5.writeNoException()
            goto L_0x02f7
        L_0x008d:
            com.google.android.gms.ads.internal.client.zzdh r3 = r2.zzk()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzg(r5, r3)
            goto L_0x02f7
        L_0x0099:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.internal.ads.zzbdm r3 = com.google.android.gms.internal.ads.zzbdl.zze(r3)
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzH(r3)
            r5.writeNoException()
            goto L_0x02f7
        L_0x00ac:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zzw> r3 = com.google.android.gms.ads.internal.client.zzw.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzasb.zza(r4, r3)
            com.google.android.gms.ads.internal.client.zzw r3 = (com.google.android.gms.ads.internal.client.zzw) r3
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzI(r3)
            r5.writeNoException()
            goto L_0x02f7
        L_0x00bf:
            java.lang.String r3 = r4.readString()
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzR(r3)
            r5.writeNoException()
            goto L_0x02f7
        L_0x00ce:
            android.os.Bundle r3 = r2.zzd()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzf(r5, r3)
            goto L_0x02f7
        L_0x00da:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x00e1
            goto L_0x00f3
        L_0x00e1:
            java.lang.String r6 = "com.google.android.gms.ads.internal.client.IAdMetadataListener"
            android.os.IInterface r6 = r3.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.ads.internal.client.zzbw
            if (r0 == 0) goto L_0x00ee
            com.google.android.gms.ads.internal.client.zzbw r6 = (com.google.android.gms.ads.internal.client.zzbw) r6
            goto L_0x00f3
        L_0x00ee:
            com.google.android.gms.ads.internal.client.zzbu r6 = new com.google.android.gms.ads.internal.client.zzbu
            r6.<init>(r3)
        L_0x00f3:
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzE(r6)
            r5.writeNoException()
            goto L_0x02f7
        L_0x00fe:
            java.lang.String r3 = r2.zzt()
            r5.writeNoException()
            r5.writeString(r3)
            goto L_0x02f7
        L_0x010a:
            boolean r3 = com.google.android.gms.internal.ads.zzasb.zzh(r4)
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzL(r3)
            r5.writeNoException()
            goto L_0x02f7
        L_0x0119:
            com.google.android.gms.ads.internal.client.zzbf r3 = r2.zzi()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzg(r5, r3)
            goto L_0x02f7
        L_0x0125:
            com.google.android.gms.ads.internal.client.zzbz r3 = r2.zzj()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzg(r5, r3)
            goto L_0x02f7
        L_0x0131:
            java.lang.String r3 = r2.zzr()
            r5.writeNoException()
            r5.writeString(r3)
            goto L_0x02f7
        L_0x013d:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zzdo> r3 = com.google.android.gms.ads.internal.client.zzdo.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzasb.zza(r4, r3)
            com.google.android.gms.ads.internal.client.zzdo r3 = (com.google.android.gms.ads.internal.client.zzdo) r3
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzK(r3)
            r5.writeNoException()
            goto L_0x02f7
        L_0x0150:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zzff> r3 = com.google.android.gms.ads.internal.client.zzff.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzasb.zza(r4, r3)
            com.google.android.gms.ads.internal.client.zzff r3 = (com.google.android.gms.ads.internal.client.zzff) r3
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzU(r3)
            r5.writeNoException()
            goto L_0x02f7
        L_0x0163:
            com.google.android.gms.ads.internal.client.zzdk r3 = r2.zzl()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzg(r5, r3)
            goto L_0x02f7
        L_0x016f:
            java.lang.String r3 = r4.readString()
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzT(r3)
            r5.writeNoException()
            goto L_0x02f7
        L_0x017e:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.internal.ads.zzcby r3 = com.google.android.gms.internal.ads.zzcbx.zzb(r3)
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzS(r3)
            r5.writeNoException()
            goto L_0x02f7
        L_0x0191:
            boolean r3 = r2.zzY()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzd(r5, r3)
            goto L_0x02f7
        L_0x019d:
            boolean r3 = com.google.android.gms.internal.ads.zzasb.zzh(r4)
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzN(r3)
            r5.writeNoException()
            goto L_0x02f7
        L_0x01ac:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x01b3
            goto L_0x01c5
        L_0x01b3:
            java.lang.String r6 = "com.google.android.gms.ads.internal.client.ICorrelationIdProvider"
            android.os.IInterface r6 = r3.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.ads.internal.client.zzcd
            if (r0 == 0) goto L_0x01c0
            com.google.android.gms.ads.internal.client.zzcd r6 = (com.google.android.gms.ads.internal.client.zzcd) r6
            goto L_0x01c5
        L_0x01c0:
            com.google.android.gms.ads.internal.client.zzcd r6 = new com.google.android.gms.ads.internal.client.zzcd
            r6.<init>(r3)
        L_0x01c5:
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzab(r6)
            r5.writeNoException()
            goto L_0x02f7
        L_0x01d0:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x01d7
            goto L_0x01e9
        L_0x01d7:
            java.lang.String r6 = "com.google.android.gms.ads.internal.client.IAdClickListener"
            android.os.IInterface r6 = r3.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.ads.internal.client.zzbc
            if (r0 == 0) goto L_0x01e4
            com.google.android.gms.ads.internal.client.zzbc r6 = (com.google.android.gms.ads.internal.client.zzbc) r6
            goto L_0x01e9
        L_0x01e4:
            com.google.android.gms.ads.internal.client.zzba r6 = new com.google.android.gms.ads.internal.client.zzba
            r6.<init>(r3)
        L_0x01e9:
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzC(r6)
            r5.writeNoException()
            goto L_0x02f7
        L_0x01f4:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.internal.ads.zzbjx r3 = com.google.android.gms.internal.ads.zzbjw.zzb(r3)
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzO(r3)
            r5.writeNoException()
            goto L_0x02f7
        L_0x0207:
            java.lang.String r3 = r2.zzs()
            r5.writeNoException()
            r5.writeString(r3)
            goto L_0x02f7
        L_0x0213:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.internal.ads.zzbzo r3 = com.google.android.gms.internal.ads.zzbzn.zzb(r3)
            java.lang.String r6 = r4.readString()
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzQ(r3, r6)
            r5.writeNoException()
            goto L_0x02f7
        L_0x022a:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.internal.ads.zzbzl r3 = com.google.android.gms.internal.ads.zzbzk.zzb(r3)
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzM(r3)
            r5.writeNoException()
            goto L_0x02f7
        L_0x023d:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zzq> r3 = com.google.android.gms.ads.internal.client.zzq.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzasb.zza(r4, r3)
            com.google.android.gms.ads.internal.client.zzq r3 = (com.google.android.gms.ads.internal.client.zzq) r3
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzF(r3)
            r5.writeNoException()
            goto L_0x02f7
        L_0x0250:
            com.google.android.gms.ads.internal.client.zzq r3 = r2.zzg()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzf(r5, r3)
            goto L_0x02f7
        L_0x025c:
            r2.zzA()
            r5.writeNoException()
            goto L_0x02f7
        L_0x0264:
            r5.writeNoException()
            goto L_0x02f7
        L_0x0269:
            r2.zzX()
            r5.writeNoException()
            goto L_0x02f7
        L_0x0271:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x0278
            goto L_0x028a
        L_0x0278:
            java.lang.String r6 = "com.google.android.gms.ads.internal.client.IAppEventListener"
            android.os.IInterface r6 = r3.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.ads.internal.client.zzbz
            if (r0 == 0) goto L_0x0285
            com.google.android.gms.ads.internal.client.zzbz r6 = (com.google.android.gms.ads.internal.client.zzbz) r6
            goto L_0x028a
        L_0x0285:
            com.google.android.gms.ads.internal.client.zzbx r6 = new com.google.android.gms.ads.internal.client.zzbx
            r6.<init>(r3)
        L_0x028a:
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzG(r6)
            r5.writeNoException()
            goto L_0x02f7
        L_0x0294:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x029b
            goto L_0x02ad
        L_0x029b:
            java.lang.String r6 = "com.google.android.gms.ads.internal.client.IAdListener"
            android.os.IInterface r6 = r3.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.ads.internal.client.zzbf
            if (r0 == 0) goto L_0x02a8
            com.google.android.gms.ads.internal.client.zzbf r6 = (com.google.android.gms.ads.internal.client.zzbf) r6
            goto L_0x02ad
        L_0x02a8:
            com.google.android.gms.ads.internal.client.zzbd r6 = new com.google.android.gms.ads.internal.client.zzbd
            r6.<init>(r3)
        L_0x02ad:
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            r2.zzD(r6)
            r5.writeNoException()
            goto L_0x02f7
        L_0x02b7:
            r2.zzB()
            r5.writeNoException()
            goto L_0x02f7
        L_0x02be:
            r2.zzz()
            r5.writeNoException()
            goto L_0x02f7
        L_0x02c5:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zzl> r3 = com.google.android.gms.ads.internal.client.zzl.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzasb.zza(r4, r3)
            com.google.android.gms.ads.internal.client.zzl r3 = (com.google.android.gms.ads.internal.client.zzl) r3
            com.google.android.gms.internal.ads.zzasb.zzc(r4)
            boolean r3 = r2.zzaa(r3)
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzd(r5, r3)
            goto L_0x02f7
        L_0x02db:
            boolean r3 = r2.zzZ()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzd(r5, r3)
            goto L_0x02f7
        L_0x02e6:
            r2.zzx()
            r5.writeNoException()
            goto L_0x02f7
        L_0x02ed:
            com.google.android.gms.dynamic.IObjectWrapper r3 = r2.zzn()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzasb.zzg(r5, r3)
        L_0x02f7:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzbr.zzbI(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
