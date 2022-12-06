package com.apm.insight.l;

import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class m {
    final Writer a;
    private final List<a> b = new ArrayList();

    enum a {
        EMPTY_ARRAY,
        NONEMPTY_ARRAY,
        EMPTY_OBJECT,
        DANGLING_KEY,
        NONEMPTY_OBJECT,
        NULL
    }

    public m(Writer writer) {
        this.a = writer;
    }

    private void a(a aVar) {
        List<a> list = this.b;
        list.set(list.size() - 1, aVar);
    }

    private void a(JSONArray jSONArray) {
        a();
        for (int i = 0; i < jSONArray.length(); i++) {
            a(jSONArray.get(i));
        }
        b();
    }

    public static void a(JSONArray jSONArray, Writer writer) {
        new m(writer).a(jSONArray);
        writer.flush();
    }

    private void a(JSONObject jSONObject) {
        c();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            a(next).a(jSONObject.get(next));
        }
        d();
    }

    public static void a(JSONObject jSONObject, Writer writer) {
        new m(writer).a(jSONObject);
        writer.flush();
    }

    private void b(String str) {
        Writer writer;
        String str2;
        this.a.write("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == 12) {
                writer = this.a;
                str2 = "\\f";
            } else if (charAt != 13) {
                if (charAt != '\"' && charAt != '/' && charAt != '\\') {
                    switch (charAt) {
                        case 8:
                            writer = this.a;
                            str2 = "\\b";
                            break;
                        case 9:
                            writer = this.a;
                            str2 = "\\t";
                            break;
                        case 10:
                            writer = this.a;
                            str2 = "\\n";
                            break;
                        default:
                            if (charAt <= 31) {
                                this.a.write(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
                                break;
                            }
                            break;
                    }
                } else {
                    this.a.write(92);
                }
                this.a.write(charAt);
            } else {
                writer = this.a;
                str2 = "\\r";
            }
            writer.write(str2);
        }
        this.a.write("\"");
    }

    private a e() {
        List<a> list = this.b;
        return list.get(list.size() - 1);
    }

    private void f() {
        a e = e();
        if (e == a.NONEMPTY_OBJECT) {
            this.a.write(44);
        } else if (e != a.EMPTY_OBJECT) {
            throw new JSONException("Nesting problem");
        }
        a(a.DANGLING_KEY);
    }

    private void g() {
        a aVar;
        if (!this.b.isEmpty()) {
            a e = e();
            if (e == a.EMPTY_ARRAY) {
                aVar = a.NONEMPTY_ARRAY;
            } else if (e == a.NONEMPTY_ARRAY) {
                this.a.write(44);
                return;
            } else if (e == a.DANGLING_KEY) {
                this.a.write(":");
                aVar = a.NONEMPTY_OBJECT;
            } else if (e != a.NULL) {
                throw new JSONException("Nesting problem");
            } else {
                return;
            }
            a(aVar);
        }
    }

    public m a() {
        return a(a.EMPTY_ARRAY, "[");
    }

    /* access modifiers changed from: package-private */
    public m a(a aVar, a aVar2, String str) {
        e();
        List<a> list = this.b;
        list.remove(list.size() - 1);
        this.a.write(str);
        return this;
    }

    /* access modifiers changed from: package-private */
    public m a(a aVar, String str) {
        g();
        this.b.add(aVar);
        this.a.write(str);
        return this;
    }

    public m a(Object obj) {
        Writer writer;
        String numberToString;
        if (obj instanceof JSONArray) {
            a((JSONArray) obj);
            return this;
        } else if (obj instanceof JSONObject) {
            a((JSONObject) obj);
            return this;
        } else {
            g();
            if (obj == null || obj == JSONObject.NULL) {
                this.a.write("null");
            } else {
                if (obj instanceof Boolean) {
                    writer = this.a;
                    numberToString = String.valueOf(obj);
                } else if (obj instanceof Number) {
                    writer = this.a;
                    numberToString = JSONObject.numberToString((Number) obj);
                } else {
                    b(obj.toString());
                }
                writer.write(numberToString);
            }
            return this;
        }
    }

    public m a(String str) {
        f();
        b(str);
        return this;
    }

    public m b() {
        return a(a.EMPTY_ARRAY, a.NONEMPTY_ARRAY, "]");
    }

    public m c() {
        return a(a.EMPTY_OBJECT, "{");
    }

    public m d() {
        return a(a.EMPTY_OBJECT, a.NONEMPTY_OBJECT, "}");
    }

    public String toString() {
        return "";
    }
}
