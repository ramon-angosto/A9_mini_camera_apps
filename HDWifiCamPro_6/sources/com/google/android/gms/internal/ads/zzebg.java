package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzebg implements SensorEventListener {
    private final Context zza;
    @Nullable
    private SensorManager zzb;
    private Sensor zzc;
    private long zzd;
    private int zze;
    private zzebf zzf;
    private boolean zzg;

    zzebg(Context context) {
        this.zza = context;
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzhI)).booleanValue()) {
            float f = sensorEvent.values[0] / 9.80665f;
            float f2 = sensorEvent.values[1] / 9.80665f;
            float f3 = sensorEvent.values[2] / 9.80665f;
            if (((float) Math.sqrt((double) ((f * f) + (f2 * f2) + (f3 * f3)))) >= ((Float) zzay.zzc().zzb(zzbjc.zzhJ)).floatValue()) {
                long currentTimeMillis = zzt.zzB().currentTimeMillis();
                if (this.zzd + ((long) ((Integer) zzay.zzc().zzb(zzbjc.zzhK)).intValue()) <= currentTimeMillis) {
                    if (this.zzd + ((long) ((Integer) zzay.zzc().zzb(zzbjc.zzhL)).intValue()) < currentTimeMillis) {
                        this.zze = 0;
                    }
                    zze.zza("Shake detected.");
                    this.zzd = currentTimeMillis;
                    int i = this.zze + 1;
                    this.zze = i;
                    zzebf zzebf = this.zzf;
                    if (zzebf != null) {
                        if (i == ((Integer) zzay.zzc().zzb(zzbjc.zzhM)).intValue()) {
                            zzeak zzeak = (zzeak) zzebf;
                            zzeak.zzh(new zzeah(zzeak), zzeaj.GESTURE);
                        }
                    }
                }
            }
        }
    }

    public final void zza() {
        synchronized (this) {
            if (this.zzg) {
                SensorManager sensorManager = this.zzb;
                if (sensorManager != null) {
                    sensorManager.unregisterListener(this, this.zzc);
                    zze.zza("Stopped listening for shake gestures.");
                }
                this.zzg = false;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb() {
        /*
            r6 = this;
            monitor-enter(r6)
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzhI     // Catch:{ all -> 0x006c }
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x006c }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x006c }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x006c }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x006c }
            if (r0 != 0) goto L_0x0015
            monitor-exit(r6)     // Catch:{ all -> 0x006c }
            return
        L_0x0015:
            android.hardware.SensorManager r0 = r6.zzb     // Catch:{ all -> 0x006c }
            r1 = 1
            if (r0 != 0) goto L_0x0037
            android.content.Context r0 = r6.zza     // Catch:{ all -> 0x006c }
            java.lang.String r2 = "sensor"
            java.lang.Object r0 = r0.getSystemService(r2)     // Catch:{ all -> 0x006c }
            android.hardware.SensorManager r0 = (android.hardware.SensorManager) r0     // Catch:{ all -> 0x006c }
            r6.zzb = r0     // Catch:{ all -> 0x006c }
            android.hardware.SensorManager r0 = r6.zzb     // Catch:{ all -> 0x006c }
            if (r0 != 0) goto L_0x0031
            java.lang.String r0 = "Shake detection failed to initialize. Failed to obtain accelerometer."
            com.google.android.gms.ads.internal.util.zze.zzj(r0)     // Catch:{ all -> 0x006c }
            monitor-exit(r6)     // Catch:{ all -> 0x006c }
            return
        L_0x0031:
            android.hardware.Sensor r0 = r0.getDefaultSensor(r1)     // Catch:{ all -> 0x006c }
            r6.zzc = r0     // Catch:{ all -> 0x006c }
        L_0x0037:
            boolean r0 = r6.zzg     // Catch:{ all -> 0x006c }
            if (r0 != 0) goto L_0x006a
            android.hardware.SensorManager r0 = r6.zzb     // Catch:{ all -> 0x006c }
            if (r0 == 0) goto L_0x006a
            android.hardware.Sensor r2 = r6.zzc     // Catch:{ all -> 0x006c }
            if (r2 == 0) goto L_0x006a
            r3 = 2
            r0.registerListener(r6, r2, r3)     // Catch:{ all -> 0x006c }
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzt.zzB()     // Catch:{ all -> 0x006c }
            long r2 = r0.currentTimeMillis()     // Catch:{ all -> 0x006c }
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzhK     // Catch:{ all -> 0x006c }
            com.google.android.gms.internal.ads.zzbja r4 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x006c }
            java.lang.Object r0 = r4.zzb(r0)     // Catch:{ all -> 0x006c }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x006c }
            int r0 = r0.intValue()     // Catch:{ all -> 0x006c }
            long r4 = (long) r0     // Catch:{ all -> 0x006c }
            long r2 = r2 - r4
            r6.zzd = r2     // Catch:{ all -> 0x006c }
            r6.zzg = r1     // Catch:{ all -> 0x006c }
            java.lang.String r0 = "Listening for shake gestures."
            com.google.android.gms.ads.internal.util.zze.zza(r0)     // Catch:{ all -> 0x006c }
        L_0x006a:
            monitor-exit(r6)     // Catch:{ all -> 0x006c }
            return
        L_0x006c:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x006c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzebg.zzb():void");
    }

    public final void zzc(zzebf zzebf) {
        this.zzf = zzebf;
    }
}
