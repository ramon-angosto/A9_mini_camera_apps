package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public abstract class StatsEvent extends AbstractSafeParcelable {
    public abstract int getEventType();

    public abstract long getTimeMillis();

    public String toString() {
        long timeMillis = getTimeMillis();
        int eventType = getEventType();
        long zzuD = zzuD();
        String valueOf = String.valueOf(zzuG());
        StringBuilder sb = new StringBuilder("\t".length() + 51 + "\t".length() + String.valueOf(valueOf).length());
        sb.append(timeMillis);
        sb.append("\t");
        sb.append(eventType);
        sb.append("\t");
        sb.append(zzuD);
        sb.append(valueOf);
        return sb.toString();
    }

    public abstract long zzuD();

    public abstract String zzuG();
}
