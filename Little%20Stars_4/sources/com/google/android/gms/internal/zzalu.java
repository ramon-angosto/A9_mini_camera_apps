package com.google.android.gms.internal;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;

public final class zzalu {
    public static final zzakr<String> zzbYA = new zzakr<String>() {
        public void zza(zzaly zzaly, String str) throws IOException {
            zzaly.zziU(str);
        }

        /* renamed from: zzq */
        public String zzb(zzalw zzalw) throws IOException {
            zzalx zzWa = zzalw.zzWa();
            if (zzWa != zzalx.NULL) {
                return zzWa == zzalx.BOOLEAN ? Boolean.toString(zzalw.nextBoolean()) : zzalw.nextString();
            }
            zzalw.nextNull();
            return null;
        }
    };
    public static final zzakr<BigDecimal> zzbYB = new zzakr<BigDecimal>() {
        public void zza(zzaly zzaly, BigDecimal bigDecimal) throws IOException {
            zzaly.zza(bigDecimal);
        }

        /* renamed from: zzr */
        public BigDecimal zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            try {
                return new BigDecimal(zzalw.nextString());
            } catch (NumberFormatException e) {
                throw new zzako((Throwable) e);
            }
        }
    };
    public static final zzakr<BigInteger> zzbYC = new zzakr<BigInteger>() {
        public void zza(zzaly zzaly, BigInteger bigInteger) throws IOException {
            zzaly.zza(bigInteger);
        }

        /* renamed from: zzs */
        public BigInteger zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            try {
                return new BigInteger(zzalw.nextString());
            } catch (NumberFormatException e) {
                throw new zzako((Throwable) e);
            }
        }
    };
    public static final zzaks zzbYD = zza(String.class, zzbYA);
    public static final zzakr<StringBuilder> zzbYE = new zzakr<StringBuilder>() {
        public void zza(zzaly zzaly, StringBuilder sb) throws IOException {
            zzaly.zziU(sb == null ? null : sb.toString());
        }

        /* renamed from: zzt */
        public StringBuilder zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() != zzalx.NULL) {
                return new StringBuilder(zzalw.nextString());
            }
            zzalw.nextNull();
            return null;
        }
    };
    public static final zzaks zzbYF = zza(StringBuilder.class, zzbYE);
    public static final zzakr<StringBuffer> zzbYG = new zzakr<StringBuffer>() {
        public void zza(zzaly zzaly, StringBuffer stringBuffer) throws IOException {
            zzaly.zziU(stringBuffer == null ? null : stringBuffer.toString());
        }

        /* renamed from: zzu */
        public StringBuffer zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() != zzalx.NULL) {
                return new StringBuffer(zzalw.nextString());
            }
            zzalw.nextNull();
            return null;
        }
    };
    public static final zzaks zzbYH = zza(StringBuffer.class, zzbYG);
    public static final zzakr<URL> zzbYI = new zzakr<URL>() {
        public void zza(zzaly zzaly, URL url) throws IOException {
            zzaly.zziU(url == null ? null : url.toExternalForm());
        }

        /* renamed from: zzv */
        public URL zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            String nextString = zzalw.nextString();
            if ("null".equals(nextString)) {
                return null;
            }
            return new URL(nextString);
        }
    };
    public static final zzaks zzbYJ = zza(URL.class, zzbYI);
    public static final zzakr<URI> zzbYK = new zzakr<URI>() {
        public void zza(zzaly zzaly, URI uri) throws IOException {
            zzaly.zziU(uri == null ? null : uri.toASCIIString());
        }

        /* renamed from: zzw */
        public URI zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            try {
                String nextString = zzalw.nextString();
                if ("null".equals(nextString)) {
                    return null;
                }
                return new URI(nextString);
            } catch (URISyntaxException e) {
                throw new zzakg((Throwable) e);
            }
        }
    };
    public static final zzaks zzbYL = zza(URI.class, zzbYK);
    public static final zzakr<InetAddress> zzbYM = new zzakr<InetAddress>() {
        public void zza(zzaly zzaly, InetAddress inetAddress) throws IOException {
            zzaly.zziU(inetAddress == null ? null : inetAddress.getHostAddress());
        }

        /* renamed from: zzy */
        public InetAddress zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() != zzalx.NULL) {
                return InetAddress.getByName(zzalw.nextString());
            }
            zzalw.nextNull();
            return null;
        }
    };
    public static final zzaks zzbYN = zzb(InetAddress.class, zzbYM);
    public static final zzakr<UUID> zzbYO = new zzakr<UUID>() {
        public void zza(zzaly zzaly, UUID uuid) throws IOException {
            zzaly.zziU(uuid == null ? null : uuid.toString());
        }

        /* renamed from: zzz */
        public UUID zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() != zzalx.NULL) {
                return UUID.fromString(zzalw.nextString());
            }
            zzalw.nextNull();
            return null;
        }
    };
    public static final zzaks zzbYP = zza(UUID.class, zzbYO);
    public static final zzaks zzbYQ = new zzaks() {
        public <T> zzakr<T> zza(zzajz zzajz, zzalv<T> zzalv) {
            if (zzalv.zzWl() != Timestamp.class) {
                return null;
            }
            final zzakr<Date> zzk = zzajz.zzk(Date.class);
            return new zzakr<Timestamp>() {
                /* renamed from: zzA */
                public Timestamp zzb(zzalw zzalw) throws IOException {
                    Date date = (Date) zzk.zzb(zzalw);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }

                public void zza(zzaly zzaly, Timestamp timestamp) throws IOException {
                    zzk.zza(zzaly, timestamp);
                }
            };
        }
    };
    public static final zzakr<Calendar> zzbYR = new zzakr<Calendar>() {
        /* renamed from: zzB */
        public Calendar zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            zzalw.beginObject();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (zzalw.zzWa() != zzalx.END_OBJECT) {
                String nextName = zzalw.nextName();
                int nextInt = zzalw.nextInt();
                if ("year".equals(nextName)) {
                    i = nextInt;
                } else if ("month".equals(nextName)) {
                    i2 = nextInt;
                } else if ("dayOfMonth".equals(nextName)) {
                    i3 = nextInt;
                } else if ("hourOfDay".equals(nextName)) {
                    i4 = nextInt;
                } else if ("minute".equals(nextName)) {
                    i5 = nextInt;
                } else if ("second".equals(nextName)) {
                    i6 = nextInt;
                }
            }
            zzalw.endObject();
            return new GregorianCalendar(i, i2, i3, i4, i5, i6);
        }

        public void zza(zzaly zzaly, Calendar calendar) throws IOException {
            if (calendar == null) {
                zzaly.zzWk();
                return;
            }
            zzaly.zzWi();
            zzaly.zziT("year");
            zzaly.zzaN((long) calendar.get(1));
            zzaly.zziT("month");
            zzaly.zzaN((long) calendar.get(2));
            zzaly.zziT("dayOfMonth");
            zzaly.zzaN((long) calendar.get(5));
            zzaly.zziT("hourOfDay");
            zzaly.zzaN((long) calendar.get(11));
            zzaly.zziT("minute");
            zzaly.zzaN((long) calendar.get(12));
            zzaly.zziT("second");
            zzaly.zzaN((long) calendar.get(13));
            zzaly.zzWj();
        }
    };
    public static final zzaks zzbYS = zzb(Calendar.class, GregorianCalendar.class, zzbYR);
    public static final zzakr<Locale> zzbYT = new zzakr<Locale>() {
        /* renamed from: zzC */
        public Locale zzb(zzalw zzalw) throws IOException {
            String str = null;
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(zzalw.nextString(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (stringTokenizer.hasMoreElements()) {
                str = stringTokenizer.nextToken();
            }
            return (nextToken2 == null && str == null) ? new Locale(nextToken) : str == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, str);
        }

        public void zza(zzaly zzaly, Locale locale) throws IOException {
            zzaly.zziU(locale == null ? null : locale.toString());
        }
    };
    public static final zzaks zzbYU = zza(Locale.class, zzbYT);
    public static final zzakr<zzakf> zzbYV = new zzakr<zzakf>() {
        /* renamed from: zzD */
        public zzakf zzb(zzalw zzalw) throws IOException {
            switch (AnonymousClass26.zzbXT[zzalw.zzWa().ordinal()]) {
                case 1:
                    return new zzakl((Number) new zzalc(zzalw.nextString()));
                case 2:
                    return new zzakl(Boolean.valueOf(zzalw.nextBoolean()));
                case 3:
                    return new zzakl(zzalw.nextString());
                case 4:
                    zzalw.nextNull();
                    return zzakh.zzbWr;
                case 5:
                    zzakc zzakc = new zzakc();
                    zzalw.beginArray();
                    while (zzalw.hasNext()) {
                        zzakc.zzc((zzakf) zzb(zzalw));
                    }
                    zzalw.endArray();
                    return zzakc;
                case 6:
                    zzaki zzaki = new zzaki();
                    zzalw.beginObject();
                    while (zzalw.hasNext()) {
                        zzaki.zza(zzalw.nextName(), (zzakf) zzb(zzalw));
                    }
                    zzalw.endObject();
                    return zzaki;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public void zza(zzaly zzaly, zzakf zzakf) throws IOException {
            if (zzakf == null || zzakf.zzVI()) {
                zzaly.zzWk();
            } else if (zzakf.zzVH()) {
                zzakl zzVL = zzakf.zzVL();
                if (zzVL.zzVO()) {
                    zzaly.zza(zzVL.zzVz());
                } else if (zzVL.zzVN()) {
                    zzaly.zzaX(zzVL.zzVE());
                } else {
                    zzaly.zziU(zzVL.zzVA());
                }
            } else if (zzakf.zzVF()) {
                zzaly.zzWg();
                Iterator<zzakf> it = zzakf.zzVK().iterator();
                while (it.hasNext()) {
                    zza(zzaly, it.next());
                }
                zzaly.zzWh();
            } else if (zzakf.zzVG()) {
                zzaly.zzWi();
                for (Map.Entry next : zzakf.zzVJ().entrySet()) {
                    zzaly.zziT((String) next.getKey());
                    zza(zzaly, (zzakf) next.getValue());
                }
                zzaly.zzWj();
            } else {
                String valueOf = String.valueOf(zzakf.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 15);
                sb.append("Couldn't write ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
    };
    public static final zzaks zzbYW = zzb(zzakf.class, zzbYV);
    public static final zzaks zzbYX = new zzaks() {
        /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.zzalv<T>, com.google.android.gms.internal.zzalv] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <T> com.google.android.gms.internal.zzakr<T> zza(com.google.android.gms.internal.zzajz r1, com.google.android.gms.internal.zzalv<T> r2) {
            /*
                r0 = this;
                java.lang.Class r1 = r2.zzWl()
                java.lang.Class<java.lang.Enum> r2 = java.lang.Enum.class
                boolean r2 = r2.isAssignableFrom(r1)
                if (r2 == 0) goto L_0x0021
                java.lang.Class<java.lang.Enum> r2 = java.lang.Enum.class
                if (r1 != r2) goto L_0x0011
                goto L_0x0021
            L_0x0011:
                boolean r2 = r1.isEnum()
                if (r2 != 0) goto L_0x001b
                java.lang.Class r1 = r1.getSuperclass()
            L_0x001b:
                com.google.android.gms.internal.zzalu$zza r2 = new com.google.android.gms.internal.zzalu$zza
                r2.<init>(r1)
                return r2
            L_0x0021:
                r1 = 0
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzalu.AnonymousClass19.zza(com.google.android.gms.internal.zzajz, com.google.android.gms.internal.zzalv):com.google.android.gms.internal.zzakr");
        }
    };
    public static final zzakr<Class> zzbYg = new zzakr<Class>() {
        public void zza(zzaly zzaly, Class cls) throws IOException {
            if (cls == null) {
                zzaly.zzWk();
                return;
            }
            String valueOf = String.valueOf(cls.getName());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 76);
            sb.append("Attempted to serialize java.lang.Class: ");
            sb.append(valueOf);
            sb.append(". Forgot to register a type adapter?");
            throw new UnsupportedOperationException(sb.toString());
        }

        /* renamed from: zzo */
        public Class zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    };
    public static final zzaks zzbYh = zza(Class.class, zzbYg);
    public static final zzakr<BitSet> zzbYi = new zzakr<BitSet>() {
        public void zza(zzaly zzaly, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                zzaly.zzWk();
                return;
            }
            zzaly.zzWg();
            for (int i = 0; i < bitSet.length(); i++) {
                zzaly.zzaN(bitSet.get(i) ? 1 : 0);
            }
            zzaly.zzWh();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
            if (java.lang.Integer.parseInt(r1) != 0) goto L_0x008a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0088, code lost:
            if (r8.nextInt() != 0) goto L_0x008a;
         */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x008c  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x008f A[SYNTHETIC] */
        /* renamed from: zzx */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.BitSet zzb(com.google.android.gms.internal.zzalw r8) throws java.io.IOException {
            /*
                r7 = this;
                com.google.android.gms.internal.zzalx r0 = r8.zzWa()
                com.google.android.gms.internal.zzalx r1 = com.google.android.gms.internal.zzalx.NULL
                if (r0 != r1) goto L_0x000d
                r8.nextNull()
                r8 = 0
                return r8
            L_0x000d:
                java.util.BitSet r0 = new java.util.BitSet
                r0.<init>()
                r8.beginArray()
                com.google.android.gms.internal.zzalx r1 = r8.zzWa()
                r2 = 0
                r3 = 0
            L_0x001b:
                com.google.android.gms.internal.zzalx r4 = com.google.android.gms.internal.zzalx.END_ARRAY
                if (r1 == r4) goto L_0x0096
                int[] r4 = com.google.android.gms.internal.zzalu.AnonymousClass26.zzbXT
                int r5 = r1.ordinal()
                r4 = r4[r5]
                r5 = 1
                if (r4 == r5) goto L_0x0084
                r6 = 2
                if (r4 == r6) goto L_0x007f
                r6 = 3
                if (r4 != r6) goto L_0x005a
                java.lang.String r1 = r8.nextString()
                int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x003d }
                if (r1 == 0) goto L_0x003b
                goto L_0x008a
            L_0x003b:
                r5 = 0
                goto L_0x008a
            L_0x003d:
                com.google.android.gms.internal.zzako r8 = new com.google.android.gms.internal.zzako
                java.lang.String r0 = "Error: Expecting: bitset number value (1, 0), Found: "
                java.lang.String r1 = java.lang.String.valueOf(r1)
                int r2 = r1.length()
                if (r2 == 0) goto L_0x0050
                java.lang.String r0 = r0.concat(r1)
                goto L_0x0056
            L_0x0050:
                java.lang.String r1 = new java.lang.String
                r1.<init>(r0)
                r0 = r1
            L_0x0056:
                r8.<init>((java.lang.String) r0)
                throw r8
            L_0x005a:
                com.google.android.gms.internal.zzako r8 = new com.google.android.gms.internal.zzako
                java.lang.String r0 = java.lang.String.valueOf(r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = java.lang.String.valueOf(r0)
                int r2 = r2.length()
                int r2 = r2 + 27
                r1.<init>(r2)
                java.lang.String r2 = "Invalid bitset value type: "
                r1.append(r2)
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                r8.<init>((java.lang.String) r0)
                throw r8
            L_0x007f:
                boolean r5 = r8.nextBoolean()
                goto L_0x008a
            L_0x0084:
                int r1 = r8.nextInt()
                if (r1 == 0) goto L_0x003b
            L_0x008a:
                if (r5 == 0) goto L_0x008f
                r0.set(r3)
            L_0x008f:
                int r3 = r3 + 1
                com.google.android.gms.internal.zzalx r1 = r8.zzWa()
                goto L_0x001b
            L_0x0096:
                r8.endArray()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzalu.AnonymousClass12.zzb(com.google.android.gms.internal.zzalw):java.util.BitSet");
        }
    };
    public static final zzaks zzbYj = zza(BitSet.class, zzbYi);
    public static final zzakr<Boolean> zzbYk = new zzakr<Boolean>() {
        /* renamed from: zzE */
        public Boolean zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() != zzalx.NULL) {
                return zzalw.zzWa() == zzalx.STRING ? Boolean.valueOf(Boolean.parseBoolean(zzalw.nextString())) : Boolean.valueOf(zzalw.nextBoolean());
            }
            zzalw.nextNull();
            return null;
        }

        public void zza(zzaly zzaly, Boolean bool) throws IOException {
            if (bool == null) {
                zzaly.zzWk();
            } else {
                zzaly.zzaX(bool.booleanValue());
            }
        }
    };
    public static final zzakr<Boolean> zzbYl = new zzakr<Boolean>() {
        /* renamed from: zzE */
        public Boolean zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() != zzalx.NULL) {
                return Boolean.valueOf(zzalw.nextString());
            }
            zzalw.nextNull();
            return null;
        }

        public void zza(zzaly zzaly, Boolean bool) throws IOException {
            zzaly.zziU(bool == null ? "null" : bool.toString());
        }
    };
    public static final zzaks zzbYm = zza(Boolean.TYPE, Boolean.class, zzbYk);
    public static final zzakr<Number> zzbYn = new zzakr<Number>() {
        public void zza(zzaly zzaly, Number number) throws IOException {
            zzaly.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            try {
                return Byte.valueOf((byte) zzalw.nextInt());
            } catch (NumberFormatException e) {
                throw new zzako((Throwable) e);
            }
        }
    };
    public static final zzaks zzbYo = zza(Byte.TYPE, Byte.class, zzbYn);
    public static final zzakr<Number> zzbYp = new zzakr<Number>() {
        public void zza(zzaly zzaly, Number number) throws IOException {
            zzaly.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            try {
                return Short.valueOf((short) zzalw.nextInt());
            } catch (NumberFormatException e) {
                throw new zzako((Throwable) e);
            }
        }
    };
    public static final zzaks zzbYq = zza(Short.TYPE, Short.class, zzbYp);
    public static final zzakr<Number> zzbYr = new zzakr<Number>() {
        public void zza(zzaly zzaly, Number number) throws IOException {
            zzaly.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(zzalw.nextInt());
            } catch (NumberFormatException e) {
                throw new zzako((Throwable) e);
            }
        }
    };
    public static final zzaks zzbYs = zza(Integer.TYPE, Integer.class, zzbYr);
    public static final zzakr<Number> zzbYt = new zzakr<Number>() {
        public void zza(zzaly zzaly, Number number) throws IOException {
            zzaly.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            try {
                return Long.valueOf(zzalw.nextLong());
            } catch (NumberFormatException e) {
                throw new zzako((Throwable) e);
            }
        }
    };
    public static final zzakr<Number> zzbYu = new zzakr<Number>() {
        public void zza(zzaly zzaly, Number number) throws IOException {
            zzaly.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() != zzalx.NULL) {
                return Float.valueOf((float) zzalw.nextDouble());
            }
            zzalw.nextNull();
            return null;
        }
    };
    public static final zzakr<Number> zzbYv = new zzakr<Number>() {
        public void zza(zzaly zzaly, Number number) throws IOException {
            zzaly.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() != zzalx.NULL) {
                return Double.valueOf(zzalw.nextDouble());
            }
            zzalw.nextNull();
            return null;
        }
    };
    public static final zzakr<Number> zzbYw = new zzakr<Number>() {
        public void zza(zzaly zzaly, Number number) throws IOException {
            zzaly.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzalw zzalw) throws IOException {
            zzalx zzWa = zzalw.zzWa();
            int i = AnonymousClass26.zzbXT[zzWa.ordinal()];
            if (i == 1) {
                return new zzalc(zzalw.nextString());
            }
            if (i == 4) {
                zzalw.nextNull();
                return null;
            }
            String valueOf = String.valueOf(zzWa);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Expecting number, got: ");
            sb.append(valueOf);
            throw new zzako(sb.toString());
        }
    };
    public static final zzaks zzbYx = zza(Number.class, zzbYw);
    public static final zzakr<Character> zzbYy = new zzakr<Character>() {
        public void zza(zzaly zzaly, Character ch) throws IOException {
            zzaly.zziU(ch == null ? null : String.valueOf(ch));
        }

        /* renamed from: zzp */
        public Character zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            String nextString = zzalw.nextString();
            if (nextString.length() == 1) {
                return Character.valueOf(nextString.charAt(0));
            }
            String valueOf = String.valueOf(nextString);
            throw new zzako(valueOf.length() != 0 ? "Expecting character, got: ".concat(valueOf) : new String("Expecting character, got: "));
        }
    };
    public static final zzaks zzbYz = zza(Character.TYPE, Character.class, zzbYy);

    /* renamed from: com.google.android.gms.internal.zzalu$26  reason: invalid class name */
    static /* synthetic */ class AnonymousClass26 {
        static final /* synthetic */ int[] zzbXT = new int[zzalx.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.google.android.gms.internal.zzalx[] r0 = com.google.android.gms.internal.zzalx.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                zzbXT = r0
                int[] r0 = zzbXT     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.android.gms.internal.zzalx r1 = com.google.android.gms.internal.zzalx.NUMBER     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = zzbXT     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.android.gms.internal.zzalx r1 = com.google.android.gms.internal.zzalx.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = zzbXT     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.android.gms.internal.zzalx r1 = com.google.android.gms.internal.zzalx.STRING     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = zzbXT     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.google.android.gms.internal.zzalx r1 = com.google.android.gms.internal.zzalx.NULL     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = zzbXT     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.google.android.gms.internal.zzalx r1 = com.google.android.gms.internal.zzalx.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r0 = zzbXT     // Catch:{ NoSuchFieldError -> 0x004b }
                com.google.android.gms.internal.zzalx r1 = com.google.android.gms.internal.zzalx.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r0 = zzbXT     // Catch:{ NoSuchFieldError -> 0x0056 }
                com.google.android.gms.internal.zzalx r1 = com.google.android.gms.internal.zzalx.END_DOCUMENT     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                int[] r0 = zzbXT     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.google.android.gms.internal.zzalx r1 = com.google.android.gms.internal.zzalx.NAME     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = zzbXT     // Catch:{ NoSuchFieldError -> 0x006e }
                com.google.android.gms.internal.zzalx r1 = com.google.android.gms.internal.zzalx.END_OBJECT     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = zzbXT     // Catch:{ NoSuchFieldError -> 0x007a }
                com.google.android.gms.internal.zzalx r1 = com.google.android.gms.internal.zzalx.END_ARRAY     // Catch:{ NoSuchFieldError -> 0x007a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007a }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007a }
            L_0x007a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzalu.AnonymousClass26.<clinit>():void");
        }
    }

    private static final class zza<T extends Enum<T>> extends zzakr<T> {
        private final Map<String, T> zzbZh = new HashMap();
        private final Map<T, String> zzbZi = new HashMap();

        public zza(Class<T> cls) {
            try {
                for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                    String name = enumR.name();
                    zzaku zzaku = (zzaku) cls.getField(name).getAnnotation(zzaku.class);
                    if (zzaku != null) {
                        name = zzaku.value();
                        for (String put : zzaku.zzVR()) {
                            this.zzbZh.put(put, enumR);
                        }
                    }
                    this.zzbZh.put(name, enumR);
                    this.zzbZi.put(enumR, name);
                }
            } catch (NoSuchFieldException unused) {
                throw new AssertionError();
            }
        }

        /* renamed from: zzF */
        public T zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() != zzalx.NULL) {
                return (Enum) this.zzbZh.get(zzalw.nextString());
            }
            zzalw.nextNull();
            return null;
        }

        public void zza(zzaly zzaly, T t) throws IOException {
            zzaly.zziU(t == null ? null : this.zzbZi.get(t));
        }
    }

    public static <TT> zzaks zza(final zzalv<TT> zzalv, final zzakr<TT> zzakr) {
        return new zzaks() {
            public <T> zzakr<T> zza(zzajz zzajz, zzalv<T> zzalv) {
                if (zzalv.equals(zzalv)) {
                    return zzakr;
                }
                return null;
            }
        };
    }

    public static <TT> zzaks zza(final Class<TT> cls, final zzakr<TT> zzakr) {
        return new zzaks() {
            public String toString() {
                String valueOf = String.valueOf(cls.getName());
                String valueOf2 = String.valueOf(zzakr);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23 + String.valueOf(valueOf2).length());
                sb.append("Factory[type=");
                sb.append(valueOf);
                sb.append(",adapter=");
                sb.append(valueOf2);
                sb.append("]");
                return sb.toString();
            }

            public <T> zzakr<T> zza(zzajz zzajz, zzalv<T> zzalv) {
                if (zzalv.zzWl() == cls) {
                    return zzakr;
                }
                return null;
            }
        };
    }

    public static <TT> zzaks zza(final Class<TT> cls, final Class<TT> cls2, final zzakr<? super TT> zzakr) {
        return new zzaks() {
            public String toString() {
                String valueOf = String.valueOf(cls2.getName());
                String valueOf2 = String.valueOf(cls.getName());
                String valueOf3 = String.valueOf(zzakr);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 24 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
                sb.append("Factory[type=");
                sb.append(valueOf);
                sb.append("+");
                sb.append(valueOf2);
                sb.append(",adapter=");
                sb.append(valueOf3);
                sb.append("]");
                return sb.toString();
            }

            public <T> zzakr<T> zza(zzajz zzajz, zzalv<T> zzalv) {
                Class<? super T> zzWl = zzalv.zzWl();
                if (zzWl == cls || zzWl == cls2) {
                    return zzakr;
                }
                return null;
            }
        };
    }

    public static <TT> zzaks zzb(final Class<TT> cls, final zzakr<TT> zzakr) {
        return new zzaks() {
            public String toString() {
                String valueOf = String.valueOf(cls.getName());
                String valueOf2 = String.valueOf(zzakr);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 32 + String.valueOf(valueOf2).length());
                sb.append("Factory[typeHierarchy=");
                sb.append(valueOf);
                sb.append(",adapter=");
                sb.append(valueOf2);
                sb.append("]");
                return sb.toString();
            }

            public <T> zzakr<T> zza(zzajz zzajz, zzalv<T> zzalv) {
                if (cls.isAssignableFrom(zzalv.zzWl())) {
                    return zzakr;
                }
                return null;
            }
        };
    }

    public static <TT> zzaks zzb(final Class<TT> cls, final Class<? extends TT> cls2, final zzakr<? super TT> zzakr) {
        return new zzaks() {
            public String toString() {
                String valueOf = String.valueOf(cls.getName());
                String valueOf2 = String.valueOf(cls2.getName());
                String valueOf3 = String.valueOf(zzakr);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 24 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
                sb.append("Factory[type=");
                sb.append(valueOf);
                sb.append("+");
                sb.append(valueOf2);
                sb.append(",adapter=");
                sb.append(valueOf3);
                sb.append("]");
                return sb.toString();
            }

            public <T> zzakr<T> zza(zzajz zzajz, zzalv<T> zzalv) {
                Class<? super T> zzWl = zzalv.zzWl();
                if (zzWl == cls || zzWl == cls2) {
                    return zzakr;
                }
                return null;
            }
        };
    }
}
