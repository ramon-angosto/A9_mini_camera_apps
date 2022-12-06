package sg.bigo.ads.common.n;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.util.Set;
import sg.bigo.ads.common.k.a;
import sg.bigo.ads.common.n.c;

public final class b {
    public static Context a;

    public static SharedPreferences.Editor a(String str) {
        try {
            return b(str).edit();
        } catch (Exception e) {
            a.a(0, "SharedPreferenceManager", Log.getStackTraceString(e));
            return null;
        }
    }

    private static <T> void a(SharedPreferences.Editor editor, String str, T t, int i) {
        if (editor == null) {
            return;
        }
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                if (t == null || (t instanceof Set)) {
                                    editor.putStringSet(str, (Set) t);
                                    return;
                                }
                                throw new ClassCastException();
                            }
                        } else if (t instanceof Boolean) {
                            editor.putBoolean(str, ((Boolean) t).booleanValue());
                        } else {
                            throw new ClassCastException();
                        }
                    } else if (t == null || (t instanceof String)) {
                        editor.putString(str, (String) t);
                    } else {
                        throw new ClassCastException();
                    }
                } else if (t instanceof Number) {
                    editor.putFloat(str, ((Number) t).floatValue());
                } else {
                    throw new NumberFormatException();
                }
            } else if (t instanceof Number) {
                editor.putLong(str, ((Number) t).longValue());
            } else {
                throw new NumberFormatException();
            }
        } else if (t instanceof Number) {
            editor.putInt(str, ((Number) t).intValue());
        } else {
            throw new NumberFormatException();
        }
    }

    public static <T> void a(String str, T t, int i) {
        a("sp_ads", str, t, i);
    }

    private static <T> void a(String str, String str2, T t, int i) {
        try {
            SharedPreferences.Editor a2 = a(str);
            a(a2, str2, t, i);
            c.a.a();
            c.a.C0125a.a(a2);
        } catch (Exception e) {
            a.a(0, "SharedPreferenceManager", Log.getStackTraceString(e));
        }
    }

    private static SharedPreferences b(String str) {
        return a.getSharedPreferences(str, 0);
    }

    public static <T> Object b(String str, T t, int i) {
        return b("sp_ads", str, t, i);
    }

    private static <T> Object b(String str, String str2, T t, int i) {
        SharedPreferences b = b(str);
        if (b == null) {
            return null;
        }
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return null;
                            }
                            if (t == null || (t instanceof Set)) {
                                return b.getStringSet(str2, (Set) t);
                            }
                            throw new ClassCastException();
                        } else if (t instanceof Boolean) {
                            return Boolean.valueOf(b.getBoolean(str2, ((Boolean) t).booleanValue()));
                        } else {
                            throw new ClassCastException();
                        }
                    } else if (t == null || (t instanceof String)) {
                        return b.getString(str2, (String) t);
                    } else {
                        throw new ClassCastException();
                    }
                } else if (t instanceof Number) {
                    return Float.valueOf(b.getFloat(str2, ((Number) t).floatValue()));
                } else {
                    throw new NumberFormatException();
                }
            } else if (t instanceof Number) {
                return Long.valueOf(b.getLong(str2, ((Number) t).longValue()));
            } else {
                throw new NumberFormatException();
            }
        } else if (t instanceof Number) {
            return Integer.valueOf(b.getInt(str2, ((Number) t).intValue()));
        } else {
            throw new NumberFormatException();
        }
    }
}
