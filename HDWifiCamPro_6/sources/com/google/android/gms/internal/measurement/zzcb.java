package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public abstract class zzcb extends zzbn implements zzcc {
    public zzcb() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static zzcc asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return queryLocalInterface instanceof zzcc ? (zzcc) queryLocalInterface : new zzca(iBinder);
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v9, types: [com.google.android.gms.internal.measurement.zzcf] */
    /* JADX WARNING: type inference failed for: r3v14, types: [com.google.android.gms.internal.measurement.zzcf] */
    /* JADX WARNING: type inference failed for: r3v22, types: [com.google.android.gms.internal.measurement.zzcf] */
    /* JADX WARNING: type inference failed for: r3v28, types: [com.google.android.gms.internal.measurement.zzcf] */
    /* JADX WARNING: type inference failed for: r3v33, types: [com.google.android.gms.internal.measurement.zzcf] */
    /* JADX WARNING: type inference failed for: r3v38, types: [com.google.android.gms.internal.measurement.zzck] */
    /* JADX WARNING: type inference failed for: r3v43, types: [com.google.android.gms.internal.measurement.zzcf] */
    /* JADX WARNING: type inference failed for: r3v48, types: [com.google.android.gms.internal.measurement.zzcf] */
    /* JADX WARNING: type inference failed for: r3v53, types: [com.google.android.gms.internal.measurement.zzcf] */
    /* JADX WARNING: type inference failed for: r3v58, types: [com.google.android.gms.internal.measurement.zzcf] */
    /* JADX WARNING: type inference failed for: r3v64, types: [com.google.android.gms.internal.measurement.zzcf] */
    /* JADX WARNING: type inference failed for: r3v69, types: [com.google.android.gms.internal.measurement.zzcf] */
    /* JADX WARNING: type inference failed for: r3v76, types: [com.google.android.gms.internal.measurement.zzci] */
    /* JADX WARNING: type inference failed for: r3v81, types: [com.google.android.gms.internal.measurement.zzci] */
    /* JADX WARNING: type inference failed for: r3v86, types: [com.google.android.gms.internal.measurement.zzci] */
    /* JADX WARNING: type inference failed for: r3v91, types: [com.google.android.gms.internal.measurement.zzcf] */
    /* JADX WARNING: type inference failed for: r3v96, types: [com.google.android.gms.internal.measurement.zzcf] */
    /* JADX WARNING: type inference failed for: r3v101 */
    /* JADX WARNING: type inference failed for: r3v102 */
    /* JADX WARNING: type inference failed for: r3v103 */
    /* JADX WARNING: type inference failed for: r3v104 */
    /* JADX WARNING: type inference failed for: r3v105 */
    /* JADX WARNING: type inference failed for: r3v106 */
    /* JADX WARNING: type inference failed for: r3v107 */
    /* JADX WARNING: type inference failed for: r3v108 */
    /* JADX WARNING: type inference failed for: r3v109 */
    /* JADX WARNING: type inference failed for: r3v110 */
    /* JADX WARNING: type inference failed for: r3v111 */
    /* JADX WARNING: type inference failed for: r3v112 */
    /* JADX WARNING: type inference failed for: r3v113 */
    /* JADX WARNING: type inference failed for: r3v114 */
    /* JADX WARNING: type inference failed for: r3v115 */
    /* JADX WARNING: type inference failed for: r3v116 */
    /* JADX WARNING: type inference failed for: r3v117 */
    /* JADX WARNING: type inference failed for: r3v118 */
    /* JADX WARNING: type inference failed for: r3v119 */
    /* JADX WARNING: type inference failed for: r3v120 */
    /* JADX WARNING: type inference failed for: r3v121 */
    /* JADX WARNING: type inference failed for: r3v122 */
    /* JADX WARNING: type inference failed for: r3v123 */
    /* JADX WARNING: type inference failed for: r3v124 */
    /* JADX WARNING: type inference failed for: r3v125 */
    /* JADX WARNING: type inference failed for: r3v126 */
    /* JADX WARNING: type inference failed for: r3v127 */
    /* JADX WARNING: type inference failed for: r3v128 */
    /* JADX WARNING: type inference failed for: r3v129 */
    /* JADX WARNING: type inference failed for: r3v130 */
    /* JADX WARNING: type inference failed for: r3v131 */
    /* JADX WARNING: type inference failed for: r3v132 */
    /* JADX WARNING: type inference failed for: r3v133 */
    /* JADX WARNING: type inference failed for: r3v134 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r11, android.os.Parcel r12, android.os.Parcel r13, int r14) throws android.os.RemoteException {
        /*
            r10 = this;
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IEventHandlerProxy"
            java.lang.String r2 = "com.google.android.gms.measurement.api.internal.IBundleReceiver"
            r3 = 0
            switch(r11) {
                case 1: goto L_0x0490;
                case 2: goto L_0x046c;
                case 3: goto L_0x0433;
                case 4: goto L_0x0412;
                case 5: goto L_0x03e6;
                case 6: goto L_0x03c2;
                case 7: goto L_0x03b2;
                case 8: goto L_0x039e;
                case 9: goto L_0x0386;
                case 10: goto L_0x035e;
                case 11: goto L_0x034e;
                case 12: goto L_0x0342;
                case 13: goto L_0x0336;
                case 14: goto L_0x032a;
                case 15: goto L_0x030d;
                case 16: goto L_0x02ed;
                case 17: goto L_0x02cd;
                case 18: goto L_0x02ab;
                case 19: goto L_0x028b;
                case 20: goto L_0x026b;
                case 21: goto L_0x024b;
                case 22: goto L_0x022b;
                case 23: goto L_0x021b;
                case 24: goto L_0x020b;
                case 25: goto L_0x01f7;
                case 26: goto L_0x01e3;
                case 27: goto L_0x01c7;
                case 28: goto L_0x01b3;
                case 29: goto L_0x019f;
                case 30: goto L_0x018b;
                case 31: goto L_0x015f;
                case 32: goto L_0x0133;
                case 33: goto L_0x010a;
                case 34: goto L_0x00ea;
                case 35: goto L_0x00ca;
                case 36: goto L_0x00aa;
                case 37: goto L_0x009e;
                case 38: goto L_0x007a;
                case 39: goto L_0x006e;
                case 40: goto L_0x004e;
                case 41: goto L_0x0008;
                case 42: goto L_0x003e;
                case 43: goto L_0x0032;
                case 44: goto L_0x001e;
                case 45: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            r0 = 0
            return r0
        L_0x000a:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.zzbo.zza(r12, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            long r2 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.setConsentThirdParty(r1, r2)
            goto L_0x04aa
        L_0x001e:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.zzbo.zza(r12, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            long r2 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.setConsent(r1, r2)
            goto L_0x04aa
        L_0x0032:
            long r1 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.clearMeasurementEnabled(r1)
            goto L_0x04aa
        L_0x003e:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.zzbo.zza(r12, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.setDefaultEventParameters(r1)
            goto L_0x04aa
        L_0x004e:
            android.os.IBinder r1 = r12.readStrongBinder()
            if (r1 != 0) goto L_0x0055
            goto L_0x0066
        L_0x0055:
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcf
            if (r3 == 0) goto L_0x0061
            r3 = r2
            com.google.android.gms.internal.measurement.zzcf r3 = (com.google.android.gms.internal.measurement.zzcf) r3
            goto L_0x0066
        L_0x0061:
            com.google.android.gms.internal.measurement.zzcd r3 = new com.google.android.gms.internal.measurement.zzcd
            r3.<init>(r1)
        L_0x0066:
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.isDataCollectionEnabled(r3)
            goto L_0x04aa
        L_0x006e:
            boolean r1 = com.google.android.gms.internal.measurement.zzbo.zzg(r12)
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.setDataCollectionEnabled(r1)
            goto L_0x04aa
        L_0x007a:
            android.os.IBinder r1 = r12.readStrongBinder()
            if (r1 != 0) goto L_0x0081
            goto L_0x0092
        L_0x0081:
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcf
            if (r3 == 0) goto L_0x008d
            r3 = r2
            com.google.android.gms.internal.measurement.zzcf r3 = (com.google.android.gms.internal.measurement.zzcf) r3
            goto L_0x0092
        L_0x008d:
            com.google.android.gms.internal.measurement.zzcd r3 = new com.google.android.gms.internal.measurement.zzcd
            r3.<init>(r1)
        L_0x0092:
            int r1 = r12.readInt()
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.getTestFlag(r3, r1)
            goto L_0x04aa
        L_0x009e:
            java.util.HashMap r1 = com.google.android.gms.internal.measurement.zzbo.zzb(r12)
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.initForTests(r1)
            goto L_0x04aa
        L_0x00aa:
            android.os.IBinder r2 = r12.readStrongBinder()
            if (r2 != 0) goto L_0x00b1
            goto L_0x00c2
        L_0x00b1:
            android.os.IInterface r1 = r2.queryLocalInterface(r1)
            boolean r3 = r1 instanceof com.google.android.gms.internal.measurement.zzci
            if (r3 == 0) goto L_0x00bd
            r3 = r1
            com.google.android.gms.internal.measurement.zzci r3 = (com.google.android.gms.internal.measurement.zzci) r3
            goto L_0x00c2
        L_0x00bd:
            com.google.android.gms.internal.measurement.zzcg r3 = new com.google.android.gms.internal.measurement.zzcg
            r3.<init>(r2)
        L_0x00c2:
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.unregisterOnMeasurementEventListener(r3)
            goto L_0x04aa
        L_0x00ca:
            android.os.IBinder r2 = r12.readStrongBinder()
            if (r2 != 0) goto L_0x00d1
            goto L_0x00e2
        L_0x00d1:
            android.os.IInterface r1 = r2.queryLocalInterface(r1)
            boolean r3 = r1 instanceof com.google.android.gms.internal.measurement.zzci
            if (r3 == 0) goto L_0x00dd
            r3 = r1
            com.google.android.gms.internal.measurement.zzci r3 = (com.google.android.gms.internal.measurement.zzci) r3
            goto L_0x00e2
        L_0x00dd:
            com.google.android.gms.internal.measurement.zzcg r3 = new com.google.android.gms.internal.measurement.zzcg
            r3.<init>(r2)
        L_0x00e2:
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.registerOnMeasurementEventListener(r3)
            goto L_0x04aa
        L_0x00ea:
            android.os.IBinder r2 = r12.readStrongBinder()
            if (r2 != 0) goto L_0x00f1
            goto L_0x0102
        L_0x00f1:
            android.os.IInterface r1 = r2.queryLocalInterface(r1)
            boolean r3 = r1 instanceof com.google.android.gms.internal.measurement.zzci
            if (r3 == 0) goto L_0x00fd
            r3 = r1
            com.google.android.gms.internal.measurement.zzci r3 = (com.google.android.gms.internal.measurement.zzci) r3
            goto L_0x0102
        L_0x00fd:
            com.google.android.gms.internal.measurement.zzcg r3 = new com.google.android.gms.internal.measurement.zzcg
            r3.<init>(r2)
        L_0x0102:
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.setEventInterceptor(r3)
            goto L_0x04aa
        L_0x010a:
            int r1 = r12.readInt()
            java.lang.String r2 = r12.readString()
            android.os.IBinder r3 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            android.os.IBinder r4 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r4)
            android.os.IBinder r5 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r5)
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r0 = r10
            r0.logHealthData(r1, r2, r3, r4, r5)
            goto L_0x04aa
        L_0x0133:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.zzbo.zza(r12, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            android.os.IBinder r4 = r12.readStrongBinder()
            if (r4 != 0) goto L_0x0142
            goto L_0x0153
        L_0x0142:
            android.os.IInterface r2 = r4.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcf
            if (r3 == 0) goto L_0x014e
            r3 = r2
            com.google.android.gms.internal.measurement.zzcf r3 = (com.google.android.gms.internal.measurement.zzcf) r3
            goto L_0x0153
        L_0x014e:
            com.google.android.gms.internal.measurement.zzcd r3 = new com.google.android.gms.internal.measurement.zzcd
            r3.<init>(r4)
        L_0x0153:
            long r4 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.performAction(r1, r3, r4)
            goto L_0x04aa
        L_0x015f:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            android.os.IBinder r4 = r12.readStrongBinder()
            if (r4 != 0) goto L_0x016e
            goto L_0x017f
        L_0x016e:
            android.os.IInterface r2 = r4.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcf
            if (r3 == 0) goto L_0x017a
            r3 = r2
            com.google.android.gms.internal.measurement.zzcf r3 = (com.google.android.gms.internal.measurement.zzcf) r3
            goto L_0x017f
        L_0x017a:
            com.google.android.gms.internal.measurement.zzcd r3 = new com.google.android.gms.internal.measurement.zzcd
            r3.<init>(r4)
        L_0x017f:
            long r4 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.onActivitySaveInstanceState(r1, r3, r4)
            goto L_0x04aa
        L_0x018b:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.onActivityResumed(r1, r2)
            goto L_0x04aa
        L_0x019f:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.onActivityPaused(r1, r2)
            goto L_0x04aa
        L_0x01b3:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.onActivityDestroyed(r1, r2)
            goto L_0x04aa
        L_0x01c7:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.zzbo.zza(r12, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            long r3 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.onActivityCreated(r1, r2, r3)
            goto L_0x04aa
        L_0x01e3:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.onActivityStopped(r1, r2)
            goto L_0x04aa
        L_0x01f7:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.onActivityStarted(r1, r2)
            goto L_0x04aa
        L_0x020b:
            java.lang.String r1 = r12.readString()
            long r2 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.endAdUnitExposure(r1, r2)
            goto L_0x04aa
        L_0x021b:
            java.lang.String r1 = r12.readString()
            long r2 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.beginAdUnitExposure(r1, r2)
            goto L_0x04aa
        L_0x022b:
            android.os.IBinder r1 = r12.readStrongBinder()
            if (r1 != 0) goto L_0x0232
            goto L_0x0243
        L_0x0232:
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcf
            if (r3 == 0) goto L_0x023e
            r3 = r2
            com.google.android.gms.internal.measurement.zzcf r3 = (com.google.android.gms.internal.measurement.zzcf) r3
            goto L_0x0243
        L_0x023e:
            com.google.android.gms.internal.measurement.zzcd r3 = new com.google.android.gms.internal.measurement.zzcd
            r3.<init>(r1)
        L_0x0243:
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.generateEventId(r3)
            goto L_0x04aa
        L_0x024b:
            android.os.IBinder r1 = r12.readStrongBinder()
            if (r1 != 0) goto L_0x0252
            goto L_0x0263
        L_0x0252:
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcf
            if (r3 == 0) goto L_0x025e
            r3 = r2
            com.google.android.gms.internal.measurement.zzcf r3 = (com.google.android.gms.internal.measurement.zzcf) r3
            goto L_0x0263
        L_0x025e:
            com.google.android.gms.internal.measurement.zzcd r3 = new com.google.android.gms.internal.measurement.zzcd
            r3.<init>(r1)
        L_0x0263:
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.getGmpAppId(r3)
            goto L_0x04aa
        L_0x026b:
            android.os.IBinder r1 = r12.readStrongBinder()
            if (r1 != 0) goto L_0x0272
            goto L_0x0283
        L_0x0272:
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcf
            if (r3 == 0) goto L_0x027e
            r3 = r2
            com.google.android.gms.internal.measurement.zzcf r3 = (com.google.android.gms.internal.measurement.zzcf) r3
            goto L_0x0283
        L_0x027e:
            com.google.android.gms.internal.measurement.zzcd r3 = new com.google.android.gms.internal.measurement.zzcd
            r3.<init>(r1)
        L_0x0283:
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.getAppInstanceId(r3)
            goto L_0x04aa
        L_0x028b:
            android.os.IBinder r1 = r12.readStrongBinder()
            if (r1 != 0) goto L_0x0292
            goto L_0x02a3
        L_0x0292:
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcf
            if (r3 == 0) goto L_0x029e
            r3 = r2
            com.google.android.gms.internal.measurement.zzcf r3 = (com.google.android.gms.internal.measurement.zzcf) r3
            goto L_0x02a3
        L_0x029e:
            com.google.android.gms.internal.measurement.zzcd r3 = new com.google.android.gms.internal.measurement.zzcd
            r3.<init>(r1)
        L_0x02a3:
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.getCachedAppInstanceId(r3)
            goto L_0x04aa
        L_0x02ab:
            android.os.IBinder r1 = r12.readStrongBinder()
            if (r1 != 0) goto L_0x02b2
            goto L_0x02c5
        L_0x02b2:
            java.lang.String r2 = "com.google.android.gms.measurement.api.internal.IStringProvider"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzck
            if (r3 == 0) goto L_0x02c0
            r3 = r2
            com.google.android.gms.internal.measurement.zzck r3 = (com.google.android.gms.internal.measurement.zzck) r3
            goto L_0x02c5
        L_0x02c0:
            com.google.android.gms.internal.measurement.zzcj r3 = new com.google.android.gms.internal.measurement.zzcj
            r3.<init>(r1)
        L_0x02c5:
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.setInstanceIdProvider(r3)
            goto L_0x04aa
        L_0x02cd:
            android.os.IBinder r1 = r12.readStrongBinder()
            if (r1 != 0) goto L_0x02d4
            goto L_0x02e5
        L_0x02d4:
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcf
            if (r3 == 0) goto L_0x02e0
            r3 = r2
            com.google.android.gms.internal.measurement.zzcf r3 = (com.google.android.gms.internal.measurement.zzcf) r3
            goto L_0x02e5
        L_0x02e0:
            com.google.android.gms.internal.measurement.zzcd r3 = new com.google.android.gms.internal.measurement.zzcd
            r3.<init>(r1)
        L_0x02e5:
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.getCurrentScreenClass(r3)
            goto L_0x04aa
        L_0x02ed:
            android.os.IBinder r1 = r12.readStrongBinder()
            if (r1 != 0) goto L_0x02f4
            goto L_0x0305
        L_0x02f4:
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcf
            if (r3 == 0) goto L_0x0300
            r3 = r2
            com.google.android.gms.internal.measurement.zzcf r3 = (com.google.android.gms.internal.measurement.zzcf) r3
            goto L_0x0305
        L_0x0300:
            com.google.android.gms.internal.measurement.zzcd r3 = new com.google.android.gms.internal.measurement.zzcd
            r3.<init>(r1)
        L_0x0305:
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.getCurrentScreenName(r3)
            goto L_0x04aa
        L_0x030d:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            java.lang.String r2 = r12.readString()
            java.lang.String r3 = r12.readString()
            long r4 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r0 = r10
            r0.setCurrentScreen(r1, r2, r3, r4)
            goto L_0x04aa
        L_0x032a:
            long r1 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.setSessionTimeoutDuration(r1)
            goto L_0x04aa
        L_0x0336:
            long r1 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.setMinimumSessionDuration(r1)
            goto L_0x04aa
        L_0x0342:
            long r1 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.resetAnalyticsData(r1)
            goto L_0x04aa
        L_0x034e:
            boolean r1 = com.google.android.gms.internal.measurement.zzbo.zzg(r12)
            long r2 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.setMeasurementEnabled(r1, r2)
            goto L_0x04aa
        L_0x035e:
            java.lang.String r1 = r12.readString()
            java.lang.String r4 = r12.readString()
            android.os.IBinder r5 = r12.readStrongBinder()
            if (r5 != 0) goto L_0x036d
            goto L_0x037e
        L_0x036d:
            android.os.IInterface r2 = r5.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcf
            if (r3 == 0) goto L_0x0379
            r3 = r2
            com.google.android.gms.internal.measurement.zzcf r3 = (com.google.android.gms.internal.measurement.zzcf) r3
            goto L_0x037e
        L_0x0379:
            com.google.android.gms.internal.measurement.zzcd r3 = new com.google.android.gms.internal.measurement.zzcd
            r3.<init>(r5)
        L_0x037e:
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.getConditionalUserProperties(r1, r4, r3)
            goto L_0x04aa
        L_0x0386:
            java.lang.String r1 = r12.readString()
            java.lang.String r2 = r12.readString()
            android.os.Parcelable$Creator r3 = android.os.Bundle.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.measurement.zzbo.zza(r12, r3)
            android.os.Bundle r3 = (android.os.Bundle) r3
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.clearConditionalUserProperty(r1, r2, r3)
            goto L_0x04aa
        L_0x039e:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.zzbo.zza(r12, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            long r2 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.setConditionalUserProperty(r1, r2)
            goto L_0x04aa
        L_0x03b2:
            java.lang.String r1 = r12.readString()
            long r2 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.setUserId(r1, r2)
            goto L_0x04aa
        L_0x03c2:
            java.lang.String r1 = r12.readString()
            android.os.IBinder r4 = r12.readStrongBinder()
            if (r4 != 0) goto L_0x03cd
            goto L_0x03de
        L_0x03cd:
            android.os.IInterface r2 = r4.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcf
            if (r3 == 0) goto L_0x03d9
            r3 = r2
            com.google.android.gms.internal.measurement.zzcf r3 = (com.google.android.gms.internal.measurement.zzcf) r3
            goto L_0x03de
        L_0x03d9:
            com.google.android.gms.internal.measurement.zzcd r3 = new com.google.android.gms.internal.measurement.zzcd
            r3.<init>(r4)
        L_0x03de:
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.getMaxUserProperties(r1, r3)
            goto L_0x04aa
        L_0x03e6:
            java.lang.String r1 = r12.readString()
            java.lang.String r4 = r12.readString()
            boolean r5 = com.google.android.gms.internal.measurement.zzbo.zzg(r12)
            android.os.IBinder r6 = r12.readStrongBinder()
            if (r6 != 0) goto L_0x03f9
            goto L_0x040a
        L_0x03f9:
            android.os.IInterface r2 = r6.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcf
            if (r3 == 0) goto L_0x0405
            r3 = r2
            com.google.android.gms.internal.measurement.zzcf r3 = (com.google.android.gms.internal.measurement.zzcf) r3
            goto L_0x040a
        L_0x0405:
            com.google.android.gms.internal.measurement.zzcd r3 = new com.google.android.gms.internal.measurement.zzcd
            r3.<init>(r6)
        L_0x040a:
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.getUserProperties(r1, r4, r5, r3)
            goto L_0x04aa
        L_0x0412:
            java.lang.String r1 = r12.readString()
            java.lang.String r2 = r12.readString()
            android.os.IBinder r3 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            boolean r4 = com.google.android.gms.internal.measurement.zzbo.zzg(r12)
            long r5 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r0 = r10
            r0.setUserProperty(r1, r2, r3, r4, r5)
            goto L_0x04aa
        L_0x0433:
            java.lang.String r1 = r12.readString()
            java.lang.String r4 = r12.readString()
            android.os.Parcelable$Creator r5 = android.os.Bundle.CREATOR
            android.os.Parcelable r5 = com.google.android.gms.internal.measurement.zzbo.zza(r12, r5)
            android.os.Bundle r5 = (android.os.Bundle) r5
            android.os.IBinder r6 = r12.readStrongBinder()
            if (r6 != 0) goto L_0x044b
            r6 = r3
            goto L_0x045c
        L_0x044b:
            android.os.IInterface r2 = r6.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzcf
            if (r3 == 0) goto L_0x0456
            com.google.android.gms.internal.measurement.zzcf r2 = (com.google.android.gms.internal.measurement.zzcf) r2
            goto L_0x045b
        L_0x0456:
            com.google.android.gms.internal.measurement.zzcd r2 = new com.google.android.gms.internal.measurement.zzcd
            r2.<init>(r6)
        L_0x045b:
            r6 = r2
        L_0x045c:
            long r8 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r0 = r10
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r8
            r0.logEventAndBundle(r1, r2, r3, r4, r5)
            goto L_0x04aa
        L_0x046c:
            java.lang.String r1 = r12.readString()
            java.lang.String r2 = r12.readString()
            android.os.Parcelable$Creator r3 = android.os.Bundle.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.measurement.zzbo.zza(r12, r3)
            android.os.Bundle r3 = (android.os.Bundle) r3
            boolean r4 = com.google.android.gms.internal.measurement.zzbo.zzg(r12)
            boolean r5 = com.google.android.gms.internal.measurement.zzbo.zzg(r12)
            long r6 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r0 = r10
            r0.logEvent(r1, r2, r3, r4, r5, r6)
            goto L_0x04aa
        L_0x0490:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            android.os.Parcelable$Creator<com.google.android.gms.internal.measurement.zzcl> r2 = com.google.android.gms.internal.measurement.zzcl.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.zzbo.zza(r12, r2)
            com.google.android.gms.internal.measurement.zzcl r2 = (com.google.android.gms.internal.measurement.zzcl) r2
            long r3 = r12.readLong()
            com.google.android.gms.internal.measurement.zzbo.zzc(r12)
            r10.initialize(r1, r2, r3)
        L_0x04aa:
            r13.writeNoException()
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzcb.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
