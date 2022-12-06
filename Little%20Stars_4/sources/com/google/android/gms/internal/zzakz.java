package com.google.android.gms.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public final class zzakz {
    private final Map<Type, zzakb<?>> zzbWm;

    public zzakz(Map<Type, zzakb<?>> map) {
        this.zzbWm = map;
    }

    private <T> zzale<T> zzc(final Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return SortedSet.class.isAssignableFrom(cls) ? new zzale<T>() {
                public T zzVT() {
                    return new TreeSet();
                }
            } : EnumSet.class.isAssignableFrom(cls) ? new zzale<T>() {
                public T zzVT() {
                    Type type = type;
                    if (type instanceof ParameterizedType) {
                        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                        if (type2 instanceof Class) {
                            return EnumSet.noneOf((Class) type2);
                        }
                        String valueOf = String.valueOf(type.toString());
                        throw new zzakg(valueOf.length() != 0 ? "Invalid EnumSet type: ".concat(valueOf) : new String("Invalid EnumSet type: "));
                    }
                    String valueOf2 = String.valueOf(type.toString());
                    throw new zzakg(valueOf2.length() != 0 ? "Invalid EnumSet type: ".concat(valueOf2) : new String("Invalid EnumSet type: "));
                }
            } : Set.class.isAssignableFrom(cls) ? new zzale<T>() {
                public T zzVT() {
                    return new LinkedHashSet();
                }
            } : Queue.class.isAssignableFrom(cls) ? new zzale<T>() {
                public T zzVT() {
                    return new LinkedList();
                }
            } : new zzale<T>() {
                public T zzVT() {
                    return new ArrayList();
                }
            };
        }
        if (Map.class.isAssignableFrom(cls)) {
            return SortedMap.class.isAssignableFrom(cls) ? new zzale<T>() {
                public T zzVT() {
                    return new TreeMap();
                }
            } : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(zzalv.zzl(((ParameterizedType) type).getActualTypeArguments()[0]).zzWl())) ? new zzale<T>() {
                public T zzVT() {
                    return new zzald();
                }
            } : new zzale<T>() {
                public T zzVT() {
                    return new LinkedHashMap();
                }
            };
        }
        return null;
    }

    private <T> zzale<T> zzd(final Type type, final Class<? super T> cls) {
        return new zzale<T>() {
            private final zzalh zzbWP = zzalh.zzVY();

            public T zzVT() {
                try {
                    return this.zzbWP.zzf(cls);
                } catch (Exception e) {
                    String valueOf = String.valueOf(type);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 116);
                    sb.append("Unable to invoke no-args constructor for ");
                    sb.append(valueOf);
                    sb.append(". ");
                    sb.append("Register an InstanceCreator with Gson for this type may fix this problem.");
                    throw new RuntimeException(sb.toString(), e);
                }
            }
        };
    }

    private <T> zzale<T> zzl(Class<? super T> cls) {
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new zzale<T>() {
                public T zzVT() {
                    try {
                        return declaredConstructor.newInstance((Object[]) null);
                    } catch (InstantiationException e) {
                        String valueOf = String.valueOf(declaredConstructor);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 30);
                        sb.append("Failed to invoke ");
                        sb.append(valueOf);
                        sb.append(" with no args");
                        throw new RuntimeException(sb.toString(), e);
                    } catch (InvocationTargetException e2) {
                        String valueOf2 = String.valueOf(declaredConstructor);
                        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 30);
                        sb2.append("Failed to invoke ");
                        sb2.append(valueOf2);
                        sb2.append(" with no args");
                        throw new RuntimeException(sb2.toString(), e2.getTargetException());
                    } catch (IllegalAccessException e3) {
                        throw new AssertionError(e3);
                    }
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public String toString() {
        return this.zzbWm.toString();
    }

    public <T> zzale<T> zzb(zzalv<T> zzalv) {
        final Type zzWm = zzalv.zzWm();
        Class<? super T> zzWl = zzalv.zzWl();
        final zzakb zzakb = this.zzbWm.get(zzWm);
        if (zzakb != null) {
            return new zzale<T>() {
                public T zzVT() {
                    return zzakb.zza(zzWm);
                }
            };
        }
        final zzakb zzakb2 = this.zzbWm.get(zzWl);
        if (zzakb2 != null) {
            return new zzale<T>() {
                public T zzVT() {
                    return zzakb2.zza(zzWm);
                }
            };
        }
        zzale<T> zzl = zzl(zzWl);
        if (zzl != null) {
            return zzl;
        }
        zzale<T> zzc = zzc(zzWm, zzWl);
        return zzc != null ? zzc : zzd(zzWm, zzWl);
    }
}
