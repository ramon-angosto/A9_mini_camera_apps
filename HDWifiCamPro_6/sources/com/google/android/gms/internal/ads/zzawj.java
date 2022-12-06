package com.google.android.gms.internal.ads;

import android.util.Log;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.InternalFrame;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzawj {
    private static final int zzA = zzbar.zzg("sosn");
    private static final int zzB = zzbar.zzg("tvsh");
    private static final int zzC = zzbar.zzg(InternalFrame.ID);
    private static final String[] zzD = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};
    private static final int zza = zzbar.zzg("nam");
    private static final int zzb = zzbar.zzg("trk");
    private static final int zzc = zzbar.zzg("cmt");
    private static final int zzd = zzbar.zzg("day");
    private static final int zze = zzbar.zzg("ART");
    private static final int zzf = zzbar.zzg("too");
    private static final int zzg = zzbar.zzg("alb");
    private static final int zzh = zzbar.zzg("com");
    private static final int zzi = zzbar.zzg("wrt");
    private static final int zzj = zzbar.zzg("lyr");
    private static final int zzk = zzbar.zzg(IronSourceSegment.GENDER);
    private static final int zzl = zzbar.zzg("covr");
    private static final int zzm = zzbar.zzg("gnre");
    private static final int zzn = zzbar.zzg("grp");
    private static final int zzo = zzbar.zzg("disk");
    private static final int zzp = zzbar.zzg("trkn");
    private static final int zzq = zzbar.zzg("tmpo");
    private static final int zzr = zzbar.zzg("cpil");
    private static final int zzs = zzbar.zzg("aART");
    private static final int zzt = zzbar.zzg("sonm");
    private static final int zzu = zzbar.zzg("soal");
    private static final int zzv = zzbar.zzg("soar");
    private static final int zzw = zzbar.zzg("soaa");
    private static final int zzx = zzbar.zzg("soco");
    private static final int zzy = zzbar.zzg("rtng");
    private static final int zzz = zzbar.zzg("pgap");

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035 A[Catch:{ all -> 0x01d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003b A[Catch:{ all -> 0x01d5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzaxg zza(com.google.android.gms.internal.ads.zzbak r13) {
        /*
            int r0 = r13.zzc()
            int r1 = r13.zze()
            int r0 = r0 + r1
            int r1 = r13.zze()
            int r2 = r1 >> 24
            r2 = r2 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = "und"
            java.lang.String r4 = "TCON"
            java.lang.String r5 = "MetadataUtil"
            r6 = 0
            r7 = 169(0xa9, float:2.37E-43)
            if (r2 == r7) goto L_0x01d8
            int r2 = zzm     // Catch:{ all -> 0x01d5 }
            r7 = -1
            if (r1 != r2) goto L_0x0045
            int r1 = zzb(r13)     // Catch:{ all -> 0x01d5 }
            if (r1 <= 0) goto L_0x0032
            java.lang.String[] r2 = zzD     // Catch:{ all -> 0x01d5 }
            int r3 = r2.length     // Catch:{ all -> 0x01d5 }
            r3 = 148(0x94, float:2.07E-43)
            if (r1 > r3) goto L_0x0032
            int r1 = r1 + r7
            r1 = r2[r1]     // Catch:{ all -> 0x01d5 }
            goto L_0x0033
        L_0x0032:
            r1 = r6
        L_0x0033:
            if (r1 == 0) goto L_0x003b
            com.google.android.gms.internal.ads.zzaxp r2 = new com.google.android.gms.internal.ads.zzaxp     // Catch:{ all -> 0x01d5 }
            r2.<init>(r4, r6, r1)     // Catch:{ all -> 0x01d5 }
            goto L_0x0041
        L_0x003b:
            java.lang.String r1 = "Failed to parse standard genre code"
            android.util.Log.w(r5, r1)     // Catch:{ all -> 0x01d5 }
            r2 = r6
        L_0x0041:
            r13.zzv(r0)
            return r2
        L_0x0045:
            int r2 = zzo     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x0053
            java.lang.String r2 = "TPOS"
            com.google.android.gms.internal.ads.zzaxp r1 = zzd(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzv(r0)
            return r1
        L_0x0053:
            int r2 = zzp     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x0061
            java.lang.String r2 = "TRCK"
            com.google.android.gms.internal.ads.zzaxp r1 = zzd(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzv(r0)
            return r1
        L_0x0061:
            int r2 = zzq     // Catch:{ all -> 0x01d5 }
            r4 = 1
            r8 = 0
            if (r1 != r2) goto L_0x0071
            java.lang.String r2 = "TBPM"
            com.google.android.gms.internal.ads.zzaxn r1 = zzc(r1, r2, r13, r4, r8)     // Catch:{ all -> 0x01d5 }
            r13.zzv(r0)
            return r1
        L_0x0071:
            int r2 = zzr     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x007f
            java.lang.String r2 = "TCMP"
            com.google.android.gms.internal.ads.zzaxn r1 = zzc(r1, r2, r13, r4, r4)     // Catch:{ all -> 0x01d5 }
            r13.zzv(r0)
            return r1
        L_0x007f:
            int r2 = zzl     // Catch:{ all -> 0x01d5 }
            r9 = 4
            if (r1 != r2) goto L_0x00dd
            int r1 = r13.zze()     // Catch:{ all -> 0x01d5 }
            int r2 = r13.zze()     // Catch:{ all -> 0x01d5 }
            int r3 = com.google.android.gms.internal.ads.zzavw.zzaH     // Catch:{ all -> 0x01d5 }
            if (r2 != r3) goto L_0x00d4
            int r2 = r13.zze()     // Catch:{ all -> 0x01d5 }
            int r2 = com.google.android.gms.internal.ads.zzavw.zze(r2)     // Catch:{ all -> 0x01d5 }
            r3 = 13
            r4 = 14
            if (r2 != r3) goto L_0x00a3
            java.lang.String r3 = "image/jpeg"
            r4 = r2
            r2 = r3
            goto L_0x00aa
        L_0x00a3:
            if (r2 != r4) goto L_0x00a8
            java.lang.String r2 = "image/png"
            goto L_0x00aa
        L_0x00a8:
            r4 = r2
            r2 = r6
        L_0x00aa:
            if (r2 != 0) goto L_0x00c1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d5 }
            r1.<init>()     // Catch:{ all -> 0x01d5 }
            java.lang.String r2 = "Unrecognized cover art flags: "
            r1.append(r2)     // Catch:{ all -> 0x01d5 }
            r1.append(r4)     // Catch:{ all -> 0x01d5 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01d5 }
            android.util.Log.w(r5, r1)     // Catch:{ all -> 0x01d5 }
            goto L_0x00d9
        L_0x00c1:
            r13.zzw(r9)     // Catch:{ all -> 0x01d5 }
            int r1 = r1 + -16
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x01d5 }
            int r3 = r1.length     // Catch:{ all -> 0x01d5 }
            r13.zzq(r1, r8, r3)     // Catch:{ all -> 0x01d5 }
            com.google.android.gms.internal.ads.zzaxj r3 = new com.google.android.gms.internal.ads.zzaxj     // Catch:{ all -> 0x01d5 }
            r4 = 3
            r3.<init>(r2, r6, r4, r1)     // Catch:{ all -> 0x01d5 }
            r6 = r3
            goto L_0x00d9
        L_0x00d4:
            java.lang.String r1 = "Failed to parse cover art attribute"
            android.util.Log.w(r5, r1)     // Catch:{ all -> 0x01d5 }
        L_0x00d9:
            r13.zzv(r0)
            return r6
        L_0x00dd:
            int r2 = zzs     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x00eb
            java.lang.String r2 = "TPE2"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzv(r0)
            return r1
        L_0x00eb:
            int r2 = zzt     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x00f9
            java.lang.String r2 = "TSOT"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzv(r0)
            return r1
        L_0x00f9:
            int r2 = zzu     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x0107
            java.lang.String r2 = "TSO2"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzv(r0)
            return r1
        L_0x0107:
            int r2 = zzv     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x0115
            java.lang.String r2 = "TSOA"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzv(r0)
            return r1
        L_0x0115:
            int r2 = zzw     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x0123
            java.lang.String r2 = "TSOP"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzv(r0)
            return r1
        L_0x0123:
            int r2 = zzx     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x0131
            java.lang.String r2 = "TSOC"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzv(r0)
            return r1
        L_0x0131:
            int r2 = zzy     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x013f
            java.lang.String r2 = "ITUNESADVISORY"
            com.google.android.gms.internal.ads.zzaxn r1 = zzc(r1, r2, r13, r8, r8)     // Catch:{ all -> 0x01d5 }
            r13.zzv(r0)
            return r1
        L_0x013f:
            int r2 = zzz     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x014d
            java.lang.String r2 = "ITUNESGAPLESS"
            com.google.android.gms.internal.ads.zzaxn r1 = zzc(r1, r2, r13, r8, r4)     // Catch:{ all -> 0x01d5 }
            r13.zzv(r0)
            return r1
        L_0x014d:
            int r2 = zzA     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x015b
            java.lang.String r2 = "TVSHOWSORT"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzv(r0)
            return r1
        L_0x015b:
            int r2 = zzB     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x0169
            java.lang.String r2 = "TVSHOW"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzv(r0)
            return r1
        L_0x0169:
            int r2 = zzC     // Catch:{ all -> 0x01d5 }
            if (r1 != r2) goto L_0x0282
            r1 = r6
            r2 = r1
            r4 = r7
            r5 = r4
        L_0x0171:
            int r8 = r13.zzc()     // Catch:{ all -> 0x01d5 }
            if (r8 >= r0) goto L_0x01ab
            int r8 = r13.zzc()     // Catch:{ all -> 0x01d5 }
            int r10 = r13.zze()     // Catch:{ all -> 0x01d5 }
            int r11 = r13.zze()     // Catch:{ all -> 0x01d5 }
            r13.zzw(r9)     // Catch:{ all -> 0x01d5 }
            int r12 = com.google.android.gms.internal.ads.zzavw.zzaF     // Catch:{ all -> 0x01d5 }
            if (r11 != r12) goto L_0x0191
            int r10 = r10 + -12
            java.lang.String r1 = r13.zzo(r10)     // Catch:{ all -> 0x01d5 }
            goto L_0x0171
        L_0x0191:
            int r12 = com.google.android.gms.internal.ads.zzavw.zzaG     // Catch:{ all -> 0x01d5 }
            if (r11 != r12) goto L_0x019c
            int r10 = r10 + -12
            java.lang.String r2 = r13.zzo(r10)     // Catch:{ all -> 0x01d5 }
            goto L_0x0171
        L_0x019c:
            int r12 = com.google.android.gms.internal.ads.zzavw.zzaH     // Catch:{ all -> 0x01d5 }
            if (r11 != r12) goto L_0x01a1
            r5 = r10
        L_0x01a1:
            if (r11 == r12) goto L_0x01a4
            goto L_0x01a5
        L_0x01a4:
            r4 = r8
        L_0x01a5:
            int r10 = r10 + -12
            r13.zzw(r10)     // Catch:{ all -> 0x01d5 }
            goto L_0x0171
        L_0x01ab:
            java.lang.String r8 = "com.apple.iTunes"
            boolean r1 = r8.equals(r1)     // Catch:{ all -> 0x01d5 }
            if (r1 == 0) goto L_0x01d1
            java.lang.String r1 = "iTunSMPB"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x01d5 }
            if (r1 == 0) goto L_0x01d1
            if (r4 != r7) goto L_0x01be
            goto L_0x01d1
        L_0x01be:
            r13.zzv(r4)     // Catch:{ all -> 0x01d5 }
            r1 = 16
            r13.zzw(r1)     // Catch:{ all -> 0x01d5 }
            int r5 = r5 + -16
            java.lang.String r1 = r13.zzo(r5)     // Catch:{ all -> 0x01d5 }
            com.google.android.gms.internal.ads.zzaxl r6 = new com.google.android.gms.internal.ads.zzaxl     // Catch:{ all -> 0x01d5 }
            r6.<init>(r3, r2, r1)     // Catch:{ all -> 0x01d5 }
        L_0x01d1:
            r13.zzv(r0)
            return r6
        L_0x01d5:
            r1 = move-exception
            goto L_0x02b2
        L_0x01d8:
            r2 = 16777215(0xffffff, float:2.3509886E-38)
            r2 = r2 & r1
            int r7 = zzc     // Catch:{ all -> 0x01d5 }
            if (r2 != r7) goto L_0x020e
            int r2 = r13.zze()     // Catch:{ all -> 0x01d5 }
            int r4 = r13.zze()     // Catch:{ all -> 0x01d5 }
            int r7 = com.google.android.gms.internal.ads.zzavw.zzaH     // Catch:{ all -> 0x01d5 }
            if (r4 != r7) goto L_0x01fd
            r1 = 8
            r13.zzw(r1)     // Catch:{ all -> 0x01d5 }
            int r2 = r2 + -16
            java.lang.String r1 = r13.zzo(r2)     // Catch:{ all -> 0x01d5 }
            com.google.android.gms.internal.ads.zzaxl r6 = new com.google.android.gms.internal.ads.zzaxl     // Catch:{ all -> 0x01d5 }
            r6.<init>(r3, r1, r1)     // Catch:{ all -> 0x01d5 }
            goto L_0x020a
        L_0x01fd:
            java.lang.String r1 = com.google.android.gms.internal.ads.zzavw.zzg(r1)     // Catch:{ all -> 0x01d5 }
            java.lang.String r2 = "Failed to parse comment attribute: "
            java.lang.String r1 = r2.concat(r1)     // Catch:{ all -> 0x01d5 }
            android.util.Log.w(r5, r1)     // Catch:{ all -> 0x01d5 }
        L_0x020a:
            r13.zzv(r0)
            return r6
        L_0x020e:
            int r3 = zza     // Catch:{ all -> 0x01d5 }
            if (r2 == r3) goto L_0x02a8
            int r3 = zzb     // Catch:{ all -> 0x01d5 }
            if (r2 != r3) goto L_0x0218
            goto L_0x02a8
        L_0x0218:
            int r3 = zzh     // Catch:{ all -> 0x01d5 }
            if (r2 == r3) goto L_0x029e
            int r3 = zzi     // Catch:{ all -> 0x01d5 }
            if (r2 != r3) goto L_0x0222
            goto L_0x029e
        L_0x0222:
            int r3 = zzd     // Catch:{ all -> 0x01d5 }
            if (r2 != r3) goto L_0x0230
            java.lang.String r2 = "TDRC"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzv(r0)
            return r1
        L_0x0230:
            int r3 = zze     // Catch:{ all -> 0x01d5 }
            if (r2 != r3) goto L_0x023e
            java.lang.String r2 = "TPE1"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzv(r0)
            return r1
        L_0x023e:
            int r3 = zzf     // Catch:{ all -> 0x01d5 }
            if (r2 != r3) goto L_0x024c
            java.lang.String r2 = "TSSE"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzv(r0)
            return r1
        L_0x024c:
            int r3 = zzg     // Catch:{ all -> 0x01d5 }
            if (r2 != r3) goto L_0x025a
            java.lang.String r2 = "TALB"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzv(r0)
            return r1
        L_0x025a:
            int r3 = zzj     // Catch:{ all -> 0x01d5 }
            if (r2 != r3) goto L_0x0268
            java.lang.String r2 = "USLT"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzv(r0)
            return r1
        L_0x0268:
            int r3 = zzk     // Catch:{ all -> 0x01d5 }
            if (r2 != r3) goto L_0x0274
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r4, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzv(r0)
            return r1
        L_0x0274:
            int r3 = zzn     // Catch:{ all -> 0x01d5 }
            if (r2 != r3) goto L_0x0282
            java.lang.String r2 = "TIT1"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzv(r0)
            return r1
        L_0x0282:
            java.lang.String r1 = com.google.android.gms.internal.ads.zzavw.zzg(r1)     // Catch:{ all -> 0x01d5 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d5 }
            r2.<init>()     // Catch:{ all -> 0x01d5 }
            java.lang.String r3 = "Skipped unknown metadata entry: "
            r2.append(r3)     // Catch:{ all -> 0x01d5 }
            r2.append(r1)     // Catch:{ all -> 0x01d5 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x01d5 }
            android.util.Log.d(r5, r1)     // Catch:{ all -> 0x01d5 }
            r13.zzv(r0)
            return r6
        L_0x029e:
            java.lang.String r2 = "TCOM"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzv(r0)
            return r1
        L_0x02a8:
            java.lang.String r2 = "TIT2"
            com.google.android.gms.internal.ads.zzaxp r1 = zze(r1, r2, r13)     // Catch:{ all -> 0x01d5 }
            r13.zzv(r0)
            return r1
        L_0x02b2:
            r13.zzv(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawj.zza(com.google.android.gms.internal.ads.zzbak):com.google.android.gms.internal.ads.zzaxg");
    }

    private static int zzb(zzbak zzbak) {
        zzbak.zzw(4);
        if (zzbak.zze() == zzavw.zzaH) {
            zzbak.zzw(8);
            return zzbak.zzg();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    private static zzaxn zzc(int i, String str, zzbak zzbak, boolean z, boolean z2) {
        int zzb2 = zzb(zzbak);
        if (z2) {
            zzb2 = Math.min(1, zzb2);
        }
        if (zzb2 < 0) {
            Log.w("MetadataUtil", "Failed to parse uint8 attribute: ".concat(zzavw.zzg(i)));
            return null;
        } else if (z) {
            return new zzaxp(str, (String) null, Integer.toString(zzb2));
        } else {
            return new zzaxl(C.LANGUAGE_UNDETERMINED, str, Integer.toString(zzb2));
        }
    }

    private static zzaxp zzd(int i, String str, zzbak zzbak) {
        int zze2 = zzbak.zze();
        if (zzbak.zze() == zzavw.zzaH && zze2 >= 22) {
            zzbak.zzw(10);
            int zzj2 = zzbak.zzj();
            if (zzj2 > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(zzj2);
                String sb2 = sb.toString();
                int zzj3 = zzbak.zzj();
                if (zzj3 > 0) {
                    sb2 = sb2 + "/" + zzj3;
                }
                return new zzaxp(str, (String) null, sb2);
            }
        }
        Log.w("MetadataUtil", "Failed to parse index/count attribute: ".concat(zzavw.zzg(i)));
        return null;
    }

    private static zzaxp zze(int i, String str, zzbak zzbak) {
        int zze2 = zzbak.zze();
        if (zzbak.zze() == zzavw.zzaH) {
            zzbak.zzw(8);
            return new zzaxp(str, (String) null, zzbak.zzo(zze2 - 16));
        }
        Log.w("MetadataUtil", "Failed to parse text attribute: ".concat(zzavw.zzg(i)));
        return null;
    }
}
