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
public final class zzdzw implements SensorEventListener {
    @Nullable
    private final SensorManager zza;
    @Nullable
    private final Sensor zzb;
    private float zzc = 0.0f;
    private Float zzd = Float.valueOf(0.0f);
    private long zze = zzt.zzB().currentTimeMillis();
    private int zzf = 0;
    private boolean zzg = false;
    private boolean zzh = false;
    @Nullable
    private zzdzv zzi = null;
    private boolean zzj = false;

    zzdzw(Context context) {
        this.zza = (SensorManager) context.getSystemService("sensor");
        SensorManager sensorManager = this.zza;
        if (sensorManager != null) {
            this.zzb = sensorManager.getDefaultSensor(4);
        } else {
            this.zzb = null;
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzhN)).booleanValue()) {
            long currentTimeMillis = zzt.zzB().currentTimeMillis();
            if (this.zze + ((long) ((Integer) zzay.zzc().zzb(zzbjc.zzhP)).intValue()) < currentTimeMillis) {
                this.zzf = 0;
                this.zze = currentTimeMillis;
                this.zzg = false;
                this.zzh = false;
                this.zzc = this.zzd.floatValue();
            }
            this.zzd = Float.valueOf(this.zzd.floatValue() + (sensorEvent.values[1] * 4.0f));
            if (this.zzd.floatValue() > this.zzc + ((Float) zzay.zzc().zzb(zzbjc.zzhO)).floatValue()) {
                this.zzc = this.zzd.floatValue();
                this.zzh = true;
            } else {
                if (this.zzd.floatValue() < this.zzc - ((Float) zzay.zzc().zzb(zzbjc.zzhO)).floatValue()) {
                    this.zzc = this.zzd.floatValue();
                    this.zzg = true;
                }
            }
            if (this.zzd.isInfinite()) {
                this.zzd = Float.valueOf(0.0f);
                this.zzc = 0.0f;
            }
            if (this.zzg && this.zzh) {
                zze.zza("Flick detected.");
                this.zze = currentTimeMillis;
                int i = this.zzf + 1;
                this.zzf = i;
                this.zzg = false;
                this.zzh = false;
                zzdzv zzdzv = this.zzi;
                if (zzdzv != null) {
                    if (i == ((Integer) zzay.zzc().zzb(zzbjc.zzhQ)).intValue()) {
                        zzeak zzeak = (zzeak) zzdzv;
                        zzeak.zzh(new zzeai(zzeak), zzeaj.GESTURE);
                    }
                }
            }
        }
    }

    public final void zza() {
        SensorManager sensorManager;
        Sensor sensor;
        synchronized (this) {
            if (!(!this.zzj || (sensorManager = this.zza) == null || (sensor = this.zzb) == null)) {
                sensorManager.unregisterListener(this, sensor);
                this.zzj = false;
                zze.zza("Stopped listening for flick gestures.");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
        if (r3.zza == null) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        if (r3.zzb != null) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0038, code lost:
        com.google.android.gms.ads.internal.util.zze.zzj("Flick detection failed to initialize. Failed to obtain gyroscope.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbiu r0 = com.google.android.gms.internal.ads.zzbjc.zzhN     // Catch:{ all -> 0x003e }
            com.google.android.gms.internal.ads.zzbja r1 = com.google.android.gms.ads.internal.client.zzay.zzc()     // Catch:{ all -> 0x003e }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x003e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x003e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x003e }
            if (r0 != 0) goto L_0x0015
            monitor-exit(r3)     // Catch:{ all -> 0x003e }
            return
        L_0x0015:
            boolean r0 = r3.zzj     // Catch:{ all -> 0x003e }
            if (r0 != 0) goto L_0x002d
            android.hardware.SensorManager r0 = r3.zza     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x002d
            android.hardware.Sensor r1 = r3.zzb     // Catch:{ all -> 0x003e }
            if (r1 == 0) goto L_0x002d
            r2 = 2
            r0.registerListener(r3, r1, r2)     // Catch:{ all -> 0x003e }
            r0 = 1
            r3.zzj = r0     // Catch:{ all -> 0x003e }
            java.lang.String r0 = "Listening for flick gestures."
            com.google.android.gms.ads.internal.util.zze.zza(r0)     // Catch:{ all -> 0x003e }
        L_0x002d:
            monitor-exit(r3)     // Catch:{ all -> 0x003e }
            android.hardware.SensorManager r0 = r3.zza
            if (r0 == 0) goto L_0x0038
            android.hardware.Sensor r0 = r3.zzb
            if (r0 != 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            return
        L_0x0038:
            java.lang.String r0 = "Flick detection failed to initialize. Failed to obtain gyroscope."
            com.google.android.gms.ads.internal.util.zze.zzj(r0)
            return
        L_0x003e:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x003e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdzw.zzb():void");
    }

    public final void zzc(zzdzv zzdzv) {
        this.zzi = zzdzv;
    }
}
