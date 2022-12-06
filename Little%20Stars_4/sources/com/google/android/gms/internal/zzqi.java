package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.zzc;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzqj;
import java.lang.reflect.Field;

public final class zzqi {
    private static zzqj zzaCm;
    private static final zzb.zza zzaCn = new zzb.zza() {
        public int zzd(Context context, String str, boolean z) {
            return zzqi.zzd(context, str, z);
        }

        public int zzo(Context context, String str) {
            return zzqi.zzo(context, str);
        }
    };
    public static final zzb zzaCo = new zzb() {
        public zzb.C0024zzb zza(Context context, String str, zzb.zza zza) {
            zzb.C0024zzb zzb = new zzb.C0024zzb();
            zzb.zzaCw = zza.zzd(context, str, true);
            if (zzb.zzaCw != 0) {
                zzb.zzaCx = 1;
            } else {
                zzb.zzaCv = zza.zzo(context, str);
                if (zzb.zzaCv != 0) {
                    zzb.zzaCx = -1;
                }
            }
            return zzb;
        }
    };
    public static final zzb zzaCp = new zzb() {
        public zzb.C0024zzb zza(Context context, String str, zzb.zza zza) {
            zzb.C0024zzb zzb = new zzb.C0024zzb();
            zzb.zzaCv = zza.zzo(context, str);
            if (zzb.zzaCv != 0) {
                zzb.zzaCx = -1;
            } else {
                zzb.zzaCw = zza.zzd(context, str, true);
                if (zzb.zzaCw != 0) {
                    zzb.zzaCx = 1;
                }
            }
            return zzb;
        }
    };
    public static final zzb zzaCq = new zzb() {
        public zzb.C0024zzb zza(Context context, String str, zzb.zza zza) {
            int i;
            zzb.C0024zzb zzb = new zzb.C0024zzb();
            zzb.zzaCv = zza.zzo(context, str);
            zzb.zzaCw = zza.zzd(context, str, true);
            if (zzb.zzaCv == 0 && zzb.zzaCw == 0) {
                i = 0;
            } else if (zzb.zzaCv >= zzb.zzaCw) {
                i = -1;
            } else {
                zzb.zzaCx = 1;
                return zzb;
            }
            zzb.zzaCx = i;
            return zzb;
        }
    };
    public static final zzb zzaCr = new zzb() {
        public zzb.C0024zzb zza(Context context, String str, zzb.zza zza) {
            int i;
            zzb.C0024zzb zzb = new zzb.C0024zzb();
            zzb.zzaCv = zza.zzo(context, str);
            zzb.zzaCw = zza.zzd(context, str, true);
            if (zzb.zzaCv == 0 && zzb.zzaCw == 0) {
                i = 0;
            } else if (zzb.zzaCw >= zzb.zzaCv) {
                zzb.zzaCx = 1;
                return zzb;
            } else {
                i = -1;
            }
            zzb.zzaCx = i;
            return zzb;
        }
    };
    public static final zzb zzaCs = new zzb() {
        public zzb.C0024zzb zza(Context context, String str, zzb.zza zza) {
            zzb.C0024zzb zzb = new zzb.C0024zzb();
            zzb.zzaCv = zza.zzo(context, str);
            zzb.zzaCw = zzb.zzaCv != 0 ? zza.zzd(context, str, false) : zza.zzd(context, str, true);
            if (zzb.zzaCv == 0 && zzb.zzaCw == 0) {
                zzb.zzaCx = 0;
            } else if (zzb.zzaCw >= zzb.zzaCv) {
                zzb.zzaCx = 1;
            } else {
                zzb.zzaCx = -1;
            }
            return zzb;
        }
    };
    private final Context zzaCt;

    public static class zza extends Exception {
        private zza(String str) {
            super(str);
        }

        private zza(String str, Throwable th) {
            super(str, th);
        }
    }

    public interface zzb {

        public interface zza {
            int zzd(Context context, String str, boolean z);

            int zzo(Context context, String str);
        }

        /* renamed from: com.google.android.gms.internal.zzqi$zzb$zzb  reason: collision with other inner class name */
        public static class C0024zzb {
            public int zzaCv = 0;
            public int zzaCw = 0;
            public int zzaCx = 0;
        }

        C0024zzb zza(Context context, String str, zza zza2);
    }

    private zzqi(Context context) {
        this.zzaCt = (Context) zzaa.zzz(context);
    }

    public static zzqi zza(Context context, zzb zzb2, String str) throws zza {
        zzb.C0024zzb zza2 = zzb2.zza(context, str, zzaCn);
        int i = zza2.zzaCv;
        int i2 = zza2.zzaCw;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length());
        sb.append("Considering local module ");
        sb.append(str);
        sb.append(":");
        sb.append(i);
        sb.append(" and remote module ");
        sb.append(str);
        sb.append(":");
        sb.append(i2);
        Log.i("DynamiteModule", sb.toString());
        if (zza2.zzaCx == 0 || ((zza2.zzaCx == -1 && zza2.zzaCv == 0) || (zza2.zzaCx == 1 && zza2.zzaCw == 0))) {
            int i3 = zza2.zzaCv;
            int i4 = zza2.zzaCw;
            StringBuilder sb2 = new StringBuilder(91);
            sb2.append("No acceptable module found. Local version is ");
            sb2.append(i3);
            sb2.append(" and remote version is ");
            sb2.append(i4);
            sb2.append(".");
            throw new zza(sb2.toString());
        } else if (zza2.zzaCx == -1) {
            return zzq(context, str);
        } else {
            if (zza2.zzaCx == 1) {
                try {
                    return zza(context, str, zza2.zzaCw);
                } catch (zza e) {
                    String valueOf = String.valueOf(e.getMessage());
                    Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to load remote module: ".concat(valueOf) : new String("Failed to load remote module: "));
                    if (zza2.zzaCv != 0) {
                        final int i5 = zza2.zzaCv;
                        if (zzb2.zza(context, str, new zzb.zza() {
                            public int zzd(Context context, String str, boolean z) {
                                return 0;
                            }

                            public int zzo(Context context, String str) {
                                return i5;
                            }
                        }).zzaCx == -1) {
                            return zzq(context, str);
                        }
                    }
                    throw new zza("Remote load failed. No local fallback found.", e);
                }
            } else {
                int i6 = zza2.zzaCx;
                StringBuilder sb3 = new StringBuilder(47);
                sb3.append("VersionPolicy returned invalid code:");
                sb3.append(i6);
                throw new zza(sb3.toString());
            }
        }
    }

    private static zzqi zza(Context context, String str, int i) throws zza {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i);
        Log.i("DynamiteModule", sb.toString());
        zzqj zzaJ = zzaJ(context);
        if (zzaJ != null) {
            try {
                zzd zza2 = zzaJ.zza(zze.zzD(context), str, i);
                if (zze.zzx(zza2) != null) {
                    return new zzqi((Context) zze.zzx(zza2));
                }
                throw new zza("Failed to load remote module.");
            } catch (RemoteException e) {
                throw new zza("Failed to load remote module.", e);
            }
        } else {
            throw new zza("Failed to create IDynamiteLoader.");
        }
    }

    private static zzqj zzaJ(Context context) {
        synchronized (zzqi.class) {
            if (zzaCm != null) {
                zzqj zzqj = zzaCm;
                return zzqj;
            } else if (zzc.zzqV().isGooglePlayServicesAvailable(context) != 0) {
                return null;
            } else {
                try {
                    zzqj zzbA = zzqj.zza.zzbA((IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance());
                    if (zzbA != null) {
                        zzaCm = zzbA;
                        return zzbA;
                    }
                } catch (Exception e) {
                    String valueOf = String.valueOf(e.getMessage());
                    Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
                }
            }
        }
        return null;
    }

    public static int zzd(Context context, String str, boolean z) {
        zzqj zzaJ = zzaJ(context);
        if (zzaJ == null) {
            return 0;
        }
        try {
            return zzaJ.zza(zze.zzD(context), str, z);
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    public static int zzo(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder("com.google.android.gms.dynamite.descriptors.".length() + 1 + String.valueOf(str).length() + "ModuleDescriptor".length());
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".");
            sb.append("ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get((Object) null).equals(str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (Exception e) {
            String valueOf2 = String.valueOf(e.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    public static int zzp(Context context, String str) {
        return zzd(context, str, false);
    }

    private static zzqi zzq(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new zzqi(context.getApplicationContext());
    }

    public IBinder zzdM(String str) throws zza {
        try {
            return (IBinder) this.zzaCt.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String valueOf = String.valueOf(str);
            throw new zza(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e);
        }
    }

    public Context zzxi() {
        return this.zzaCt;
    }
}
