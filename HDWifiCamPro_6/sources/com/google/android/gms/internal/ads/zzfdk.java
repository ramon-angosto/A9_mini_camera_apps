package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzs;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfdk {
    public final String zzA;
    public final zzcdn zzB;
    public final String zzC;
    public final JSONObject zzD;
    public final JSONObject zzE;
    public final String zzF;
    public final String zzG;
    public final String zzH;
    public final String zzI;
    public final String zzJ;
    public final boolean zzK;
    public final boolean zzL;
    public final boolean zzM;
    public final boolean zzN;
    public final boolean zzO;
    public final boolean zzP;
    public final boolean zzQ;
    public final int zzR;
    public final int zzS;
    public final boolean zzT;
    public final boolean zzU;
    public final String zzV;
    public final zzfei zzW;
    public final boolean zzX;
    public final boolean zzY;
    public final int zzZ;
    public final List zza;
    public final String zzaa;
    public final int zzab;
    public final String zzac;
    public final boolean zzad;
    public final zzbzi zzae;
    public final boolean zzaf;
    public final zzs zzag;
    public final String zzah;
    public final boolean zzai;
    public final JSONObject zzaj;
    public final boolean zzak;
    public final JSONObject zzal;
    public final boolean zzam;
    public final String zzan;
    public final boolean zzao;
    public final String zzap;
    public final int zzb;
    public final List zzc;
    public final List zzd;
    public final List zze;
    public final int zzf;
    public final List zzg;
    public final List zzh;
    public final List zzi;
    public final List zzj;
    public final String zzk;
    public final String zzl;
    public final zzcce zzm;
    public final List zzn;
    public final List zzo;
    public final List zzp;
    public final List zzq;
    public final int zzr;
    public final List zzs;
    public final zzfdp zzt;
    public final List zzu;
    public final List zzv;
    public final JSONObject zzw;
    public final String zzx;
    public final String zzy;
    public final String zzz;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x068d, code lost:
        r15 = r81;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzfdk(android.util.JsonReader r81) throws java.lang.IllegalStateException, java.io.IOException, org.json.JSONException, java.lang.NumberFormatException {
        /*
            r80 = this;
            r0 = r80
            r80.<init>()
            java.util.List r1 = java.util.Collections.emptyList()
            java.util.List r2 = java.util.Collections.emptyList()
            java.util.List r3 = java.util.Collections.emptyList()
            java.util.List r4 = java.util.Collections.emptyList()
            java.util.List r5 = java.util.Collections.emptyList()
            java.util.List r6 = java.util.Collections.emptyList()
            java.util.List r7 = java.util.Collections.emptyList()
            java.util.List r8 = java.util.Collections.emptyList()
            java.util.List r9 = java.util.Collections.emptyList()
            java.util.List r10 = java.util.Collections.emptyList()
            java.util.List r11 = java.util.Collections.emptyList()
            java.util.List r12 = java.util.Collections.emptyList()
            java.util.List r13 = java.util.Collections.emptyList()
            java.util.List r14 = java.util.Collections.emptyList()
            org.json.JSONObject r15 = new org.json.JSONObject
            r15.<init>()
            org.json.JSONObject r16 = new org.json.JSONObject
            r16.<init>()
            org.json.JSONObject r17 = new org.json.JSONObject
            r17.<init>()
            org.json.JSONObject r18 = new org.json.JSONObject
            r18.<init>()
            org.json.JSONObject r19 = new org.json.JSONObject
            r19.<init>()
            org.json.JSONObject r20 = new org.json.JSONObject
            r20.<init>()
            com.google.android.gms.internal.ads.zzfvn r21 = com.google.android.gms.internal.ads.zzfvn.zzo()
            r81.beginObject()
            r22 = 1
            r23 = -1
            r24 = 0
            java.lang.String r25 = ""
            r26 = 0
            r27 = r11
            r29 = r12
            r31 = r13
            r32 = r14
            r34 = r15
            r40 = r16
            r41 = r17
            r53 = r18
            r66 = r19
            r73 = r20
            r77 = r21
            r62 = r22
            r49 = r23
            r58 = r49
            r12 = r24
            r30 = r12
            r38 = r30
            r61 = r38
            r63 = r61
            r75 = r63
            r11 = r25
            r33 = r11
            r35 = r33
            r36 = r35
            r37 = r36
            r39 = r37
            r52 = r39
            r57 = r52
            r59 = r57
            r64 = r59
            r67 = r64
            r68 = r67
            r69 = r68
            r70 = r69
            r71 = r70
            r79 = r71
            r28 = r26
            r42 = r28
            r43 = r42
            r44 = r43
            r45 = r44
            r46 = r45
            r47 = r46
            r48 = r47
            r50 = r48
            r51 = r50
            r54 = r51
            r55 = r54
            r56 = r55
            r60 = r56
            r65 = r60
            r72 = r65
            r74 = r72
            r76 = r74
            r78 = r76
            r13 = r8
            r14 = r9
            r15 = r10
            r10 = r79
            r8 = r6
            r9 = r7
            r6 = r78
            r7 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r6
        L_0x00e8:
            boolean r16 = r81.hasNext()
            if (r16 == 0) goto L_0x08bf
            java.lang.String r16 = r81.nextName()
            if (r16 != 0) goto L_0x00f7
            r17 = r25
            goto L_0x00f9
        L_0x00f7:
            r17 = r16
        L_0x00f9:
            int r16 = r17.hashCode()
            switch(r16) {
                case -2138196627: goto L_0x05b1;
                case -1980587809: goto L_0x05a0;
                case -1965512151: goto L_0x058f;
                case -1812055556: goto L_0x057e;
                case -1776946669: goto L_0x056d;
                case -1662989631: goto L_0x055c;
                case -1620470467: goto L_0x054a;
                case -1550155393: goto L_0x0538;
                case -1440104884: goto L_0x0526;
                case -1439500848: goto L_0x0514;
                case -1428969291: goto L_0x0502;
                case -1406227629: goto L_0x04f0;
                case -1403779768: goto L_0x04de;
                case -1375413093: goto L_0x04cc;
                case -1360811658: goto L_0x04ba;
                case -1306015996: goto L_0x04a8;
                case -1303332046: goto L_0x0496;
                case -1289032093: goto L_0x0484;
                case -1240082064: goto L_0x0472;
                case -1234181075: goto L_0x0460;
                case -1168140544: goto L_0x044e;
                case -1152230954: goto L_0x043c;
                case -1146534047: goto L_0x042a;
                case -1115838944: goto L_0x0418;
                case -1081936678: goto L_0x0406;
                case -1078050970: goto L_0x03f4;
                case -1051269058: goto L_0x03e2;
                case -982608540: goto L_0x03d0;
                case -972056451: goto L_0x03be;
                case -776859333: goto L_0x03ad;
                case -544216775: goto L_0x039b;
                case -437057161: goto L_0x038a;
                case -404433734: goto L_0x0378;
                case -404326515: goto L_0x0366;
                case -397704715: goto L_0x0354;
                case -388807511: goto L_0x0342;
                case -369773488: goto L_0x0330;
                case -213449460: goto L_0x031e;
                case -213424028: goto L_0x030c;
                case -180214626: goto L_0x02fa;
                case -154616268: goto L_0x02e8;
                case -29338502: goto L_0x02d6;
                case 3107: goto L_0x02c4;
                case 3355: goto L_0x02b2;
                case 3076010: goto L_0x02a0;
                case 37109963: goto L_0x028e;
                case 63195984: goto L_0x027c;
                case 107433883: goto L_0x026a;
                case 230323073: goto L_0x0259;
                case 418392395: goto L_0x0247;
                case 549176928: goto L_0x0235;
                case 597473788: goto L_0x0223;
                case 754887508: goto L_0x0211;
                case 791122864: goto L_0x0200;
                case 1010584092: goto L_0x01ee;
                case 1100650276: goto L_0x01dc;
                case 1186014765: goto L_0x01ca;
                case 1321720943: goto L_0x01b8;
                case 1437255331: goto L_0x01a6;
                case 1637553475: goto L_0x0194;
                case 1638957285: goto L_0x0183;
                case 1686319423: goto L_0x0171;
                case 1688341040: goto L_0x0160;
                case 1799285870: goto L_0x014e;
                case 1839650832: goto L_0x013c;
                case 1875425491: goto L_0x012a;
                case 2068142375: goto L_0x0118;
                case 2072888499: goto L_0x0106;
                default: goto L_0x0100;
            }
        L_0x0100:
            r18 = r14
            r16 = r15
            goto L_0x05c2
        L_0x0106:
            r16 = r15
            java.lang.String r15 = "manual_tracking_urls"
            r18 = r14
            r14 = r17
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 15
            goto L_0x05c4
        L_0x0118:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "rule_line_external_id"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 52
            goto L_0x05c4
        L_0x012a:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "is_analytics_logging_enabled"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 42
            goto L_0x05c4
        L_0x013c:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "renderers"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = r26
            goto L_0x05c4
        L_0x014e:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "use_third_party_container_height"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 48
            goto L_0x05c4
        L_0x0160:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "video_reward_urls"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 7
            goto L_0x05c4
        L_0x0171:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "ad_network_class_name"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 55
            goto L_0x05c4
        L_0x0183:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "video_start_urls"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 6
            goto L_0x05c4
        L_0x0194:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "bid_response"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 40
            goto L_0x05c4
        L_0x01a6:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "ad_source_id"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 57
            goto L_0x05c4
        L_0x01b8:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "allow_pub_owned_ad_view"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 31
            goto L_0x05c4
        L_0x01ca:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "cache_hit_urls"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 65
            goto L_0x05c4
        L_0x01dc:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "rewards"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 11
            goto L_0x05c4
        L_0x01ee:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "transaction_id"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 9
            goto L_0x05c4
        L_0x0200:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "impression_type"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 5
            goto L_0x05c4
        L_0x0211:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "container_sizes"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 17
            goto L_0x05c4
        L_0x0223:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "debug_dialog_string"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 27
            goto L_0x05c4
        L_0x0235:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "presentation_error_timeout_ms"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 16
            goto L_0x05c4
        L_0x0247:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "is_closable_area_disabled"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 36
            goto L_0x05c4
        L_0x0259:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "ad_load_urls"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 4
            goto L_0x05c4
        L_0x026a:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "qdata"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 24
            goto L_0x05c4
        L_0x027c:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "render_test_label"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 33
            goto L_0x05c4
        L_0x028e:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "request_id"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 67
            goto L_0x05c4
        L_0x02a0:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "data"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 22
            goto L_0x05c4
        L_0x02b2:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "id"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 23
            goto L_0x05c4
        L_0x02c4:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "ad"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 18
            goto L_0x05c4
        L_0x02d6:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "allow_custom_click_gesture"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 32
            goto L_0x05c4
        L_0x02e8:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "is_offline_ad"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 60
            goto L_0x05c4
        L_0x02fa:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "native_required_asset_viewability"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 62
            goto L_0x05c4
        L_0x030c:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "watermark"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 46
            goto L_0x05c4
        L_0x031e:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "force_disable_hardware_acceleration"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 64
            goto L_0x05c4
        L_0x0330:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "is_close_button_enabled"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 50
            goto L_0x05c4
        L_0x0342:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "content_url"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 63
            goto L_0x05c4
        L_0x0354:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "ad_close_time_ms"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 45
            goto L_0x05c4
        L_0x0366:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "render_timeout_ms"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 38
            goto L_0x05c4
        L_0x0378:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "rtb_native_required_assets"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 61
            goto L_0x05c4
        L_0x038a:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "imp_urls"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 3
            goto L_0x05c4
        L_0x039b:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "safe_browsing"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 26
            goto L_0x05c4
        L_0x03ad:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "click_urls"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 2
            goto L_0x05c4
        L_0x03be:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "ad_source_instance_id"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 59
            goto L_0x05c4
        L_0x03d0:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "valid_from_timestamp"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 10
            goto L_0x05c4
        L_0x03e2:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "active_view"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 25
            goto L_0x05c4
        L_0x03f4:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "video_complete_urls"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 8
            goto L_0x05c4
        L_0x0406:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "allocation_id"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 21
            goto L_0x05c4
        L_0x0418:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "fill_urls"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 12
            goto L_0x05c4
        L_0x042a:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "is_scroll_aware"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 43
            goto L_0x05c4
        L_0x043c:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "ad_type"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = r22
            goto L_0x05c4
        L_0x044e:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "presentation_error_urls"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 14
            goto L_0x05c4
        L_0x0460:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "allow_pub_rendered_attribution"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 30
            goto L_0x05c4
        L_0x0472:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "ad_event_value"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 51
            goto L_0x05c4
        L_0x0484:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "extras"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 29
            goto L_0x05c4
        L_0x0496:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "test_mode_enabled"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 34
            goto L_0x05c4
        L_0x04a8:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "adapters"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 20
            goto L_0x05c4
        L_0x04ba:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "ad_sizes"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 19
            goto L_0x05c4
        L_0x04cc:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "ad_cover"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 54
            goto L_0x05c4
        L_0x04de:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "showable_impression_type"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 44
            goto L_0x05c4
        L_0x04f0:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "buffer_click_url_as_ready_to_ping"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 66
            goto L_0x05c4
        L_0x0502:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "enable_omid"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 39
            goto L_0x05c4
        L_0x0514:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "orientation"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 37
            goto L_0x05c4
        L_0x0526:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "is_custom_close_blocked"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 35
            goto L_0x05c4
        L_0x0538:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "nofill_urls"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 13
            goto L_0x05c4
        L_0x054a:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "backend_query_id"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 47
            goto L_0x05c4
        L_0x055c:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "is_interscroller"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 53
            goto L_0x05c4
        L_0x056d:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "ad_source_name"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 56
            goto L_0x05c4
        L_0x057e:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "play_prewarm_options"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 49
            goto L_0x05c4
        L_0x058f:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "omid_settings"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 41
            goto L_0x05c4
        L_0x05a0:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "debug_signals"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 28
            goto L_0x05c4
        L_0x05b1:
            r18 = r14
            r16 = r15
            r14 = r17
            java.lang.String r15 = "ad_source_instance_name"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x05c2
            r14 = 58
            goto L_0x05c4
        L_0x05c2:
            r14 = r23
        L_0x05c4:
            switch(r14) {
                case 0: goto L_0x08b3;
                case 1: goto L_0x08a8;
                case 2: goto L_0x08a1;
                case 3: goto L_0x089a;
                case 4: goto L_0x0893;
                case 5: goto L_0x0888;
                case 6: goto L_0x0881;
                case 7: goto L_0x087a;
                case 8: goto L_0x0873;
                case 9: goto L_0x086c;
                case 10: goto L_0x0865;
                case 11: goto L_0x085a;
                case 12: goto L_0x0852;
                case 13: goto L_0x084a;
                case 14: goto L_0x0840;
                case 15: goto L_0x0836;
                case 16: goto L_0x082c;
                case 17: goto L_0x0822;
                case 18: goto L_0x0817;
                case 19: goto L_0x080d;
                case 20: goto L_0x0803;
                case 21: goto L_0x07f9;
                case 22: goto L_0x07ef;
                case 23: goto L_0x07e5;
                case 24: goto L_0x07db;
                case 25: goto L_0x07cd;
                case 26: goto L_0x07bf;
                case 27: goto L_0x07b5;
                case 28: goto L_0x07ab;
                case 29: goto L_0x07a1;
                case 30: goto L_0x0797;
                case 31: goto L_0x078d;
                case 32: goto L_0x0783;
                case 33: goto L_0x0779;
                case 34: goto L_0x076f;
                case 35: goto L_0x0765;
                case 36: goto L_0x075b;
                case 37: goto L_0x074d;
                case 38: goto L_0x0743;
                case 39: goto L_0x0739;
                case 40: goto L_0x072f;
                case 41: goto L_0x0725;
                case 42: goto L_0x071b;
                case 43: goto L_0x0711;
                case 44: goto L_0x0707;
                case 45: goto L_0x06fd;
                case 46: goto L_0x06f3;
                case 47: goto L_0x06e9;
                case 48: goto L_0x06df;
                case 49: goto L_0x06d1;
                case 50: goto L_0x06c7;
                case 51: goto L_0x06b9;
                case 52: goto L_0x06af;
                case 53: goto L_0x06a5;
                case 54: goto L_0x069b;
                case 55: goto L_0x0691;
                case 56: goto L_0x0672;
                case 57: goto L_0x0656;
                case 58: goto L_0x063a;
                case 59: goto L_0x061e;
                case 60: goto L_0x0614;
                case 61: goto L_0x060a;
                case 62: goto L_0x0600;
                case 63: goto L_0x05f6;
                case 64: goto L_0x05ec;
                case 65: goto L_0x05e2;
                case 66: goto L_0x05d8;
                case 67: goto L_0x05ce;
                default: goto L_0x05c7;
            }
        L_0x05c7:
            r15 = r81
            r81.skipValue()
            goto L_0x08b9
        L_0x05ce:
            java.lang.String r14 = r81.nextString()
            r15 = r81
            r79 = r14
            goto L_0x08b9
        L_0x05d8:
            boolean r14 = r81.nextBoolean()
            r15 = r81
            r78 = r14
            goto L_0x08b9
        L_0x05e2:
            java.util.List r14 = com.google.android.gms.ads.internal.util.zzbu.zzd(r81)
            r15 = r81
            r77 = r14
            goto L_0x08b9
        L_0x05ec:
            boolean r14 = r81.nextBoolean()
            r15 = r81
            r76 = r14
            goto L_0x08b9
        L_0x05f6:
            java.lang.String r14 = r81.nextString()
            r15 = r81
            r75 = r14
            goto L_0x08b9
        L_0x0600:
            boolean r14 = r81.nextBoolean()
            r15 = r81
            r74 = r14
            goto L_0x08b9
        L_0x060a:
            org.json.JSONObject r14 = com.google.android.gms.ads.internal.util.zzbu.zzh(r81)
            r15 = r81
            r73 = r14
            goto L_0x08b9
        L_0x0614:
            boolean r14 = r81.nextBoolean()
            r15 = r81
            r72 = r14
            goto L_0x08b9
        L_0x061e:
            com.google.android.gms.internal.ads.zzbiu r14 = com.google.android.gms.internal.ads.zzbjc.zzfR
            java.lang.Object r14 = r14.zzl()
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x0636
            java.lang.String r14 = r81.nextString()
            r15 = r81
            r71 = r14
            goto L_0x08b9
        L_0x0636:
            r81.skipValue()
            goto L_0x068d
        L_0x063a:
            com.google.android.gms.internal.ads.zzbiu r14 = com.google.android.gms.internal.ads.zzbjc.zzfR
            java.lang.Object r14 = r14.zzl()
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x0652
            java.lang.String r14 = r81.nextString()
            r15 = r81
            r70 = r14
            goto L_0x08b9
        L_0x0652:
            r81.skipValue()
            goto L_0x068d
        L_0x0656:
            com.google.android.gms.internal.ads.zzbiu r14 = com.google.android.gms.internal.ads.zzbjc.zzfR
            java.lang.Object r14 = r14.zzl()
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x066e
            java.lang.String r14 = r81.nextString()
            r15 = r81
            r69 = r14
            goto L_0x08b9
        L_0x066e:
            r81.skipValue()
            goto L_0x068d
        L_0x0672:
            com.google.android.gms.internal.ads.zzbiu r14 = com.google.android.gms.internal.ads.zzbjc.zzfR
            java.lang.Object r14 = r14.zzl()
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x068a
            java.lang.String r14 = r81.nextString()
            r15 = r81
            r68 = r14
            goto L_0x08b9
        L_0x068a:
            r81.skipValue()
        L_0x068d:
            r15 = r81
            goto L_0x08b9
        L_0x0691:
            java.lang.String r14 = r81.nextString()
            r15 = r81
            r67 = r14
            goto L_0x08b9
        L_0x069b:
            org.json.JSONObject r14 = com.google.android.gms.ads.internal.util.zzbu.zzh(r81)
            r15 = r81
            r66 = r14
            goto L_0x08b9
        L_0x06a5:
            boolean r14 = r81.nextBoolean()
            r15 = r81
            r65 = r14
            goto L_0x08b9
        L_0x06af:
            java.lang.String r14 = r81.nextString()
            r15 = r81
            r64 = r14
            goto L_0x08b9
        L_0x06b9:
            org.json.JSONObject r14 = com.google.android.gms.ads.internal.util.zzbu.zzh(r81)
            com.google.android.gms.ads.internal.client.zzs r14 = com.google.android.gms.ads.internal.client.zzs.zza(r14)
            r15 = r81
            r63 = r14
            goto L_0x08b9
        L_0x06c7:
            boolean r14 = r81.nextBoolean()
            r15 = r81
            r62 = r14
            goto L_0x08b9
        L_0x06d1:
            org.json.JSONObject r14 = com.google.android.gms.ads.internal.util.zzbu.zzh(r81)
            com.google.android.gms.internal.ads.zzbzi r14 = com.google.android.gms.internal.ads.zzbzi.zza(r14)
            r15 = r81
            r61 = r14
            goto L_0x08b9
        L_0x06df:
            boolean r14 = r81.nextBoolean()
            r15 = r81
            r60 = r14
            goto L_0x08b9
        L_0x06e9:
            java.lang.String r14 = r81.nextString()
            r15 = r81
            r59 = r14
            goto L_0x08b9
        L_0x06f3:
            java.lang.String r14 = r81.nextString()
            r15 = r81
            r57 = r14
            goto L_0x08b9
        L_0x06fd:
            int r14 = r81.nextInt()
            r15 = r81
            r58 = r14
            goto L_0x08b9
        L_0x0707:
            int r14 = r81.nextInt()
            r15 = r81
            r56 = r14
            goto L_0x08b9
        L_0x0711:
            boolean r14 = r81.nextBoolean()
            r15 = r81
            r55 = r14
            goto L_0x08b9
        L_0x071b:
            boolean r14 = r81.nextBoolean()
            r15 = r81
            r54 = r14
            goto L_0x08b9
        L_0x0725:
            org.json.JSONObject r14 = com.google.android.gms.ads.internal.util.zzbu.zzh(r81)
            r15 = r81
            r53 = r14
            goto L_0x08b9
        L_0x072f:
            java.lang.String r14 = r81.nextString()
            r15 = r81
            r52 = r14
            goto L_0x08b9
        L_0x0739:
            boolean r14 = r81.nextBoolean()
            r15 = r81
            r51 = r14
            goto L_0x08b9
        L_0x0743:
            int r14 = r81.nextInt()
            r15 = r81
            r50 = r14
            goto L_0x08b9
        L_0x074d:
            java.lang.String r14 = r81.nextString()
            int r14 = zzd(r14)
            r15 = r81
            r49 = r14
            goto L_0x08b9
        L_0x075b:
            boolean r14 = r81.nextBoolean()
            r15 = r81
            r48 = r14
            goto L_0x08b9
        L_0x0765:
            boolean r14 = r81.nextBoolean()
            r15 = r81
            r47 = r14
            goto L_0x08b9
        L_0x076f:
            boolean r14 = r81.nextBoolean()
            r15 = r81
            r46 = r14
            goto L_0x08b9
        L_0x0779:
            boolean r14 = r81.nextBoolean()
            r15 = r81
            r45 = r14
            goto L_0x08b9
        L_0x0783:
            boolean r14 = r81.nextBoolean()
            r15 = r81
            r44 = r14
            goto L_0x08b9
        L_0x078d:
            boolean r14 = r81.nextBoolean()
            r15 = r81
            r43 = r14
            goto L_0x08b9
        L_0x0797:
            boolean r14 = r81.nextBoolean()
            r15 = r81
            r42 = r14
            goto L_0x08b9
        L_0x07a1:
            org.json.JSONObject r14 = com.google.android.gms.ads.internal.util.zzbu.zzh(r81)
            r15 = r81
            r41 = r14
            goto L_0x08b9
        L_0x07ab:
            org.json.JSONObject r14 = com.google.android.gms.ads.internal.util.zzbu.zzh(r81)
            r15 = r81
            r40 = r14
            goto L_0x08b9
        L_0x07b5:
            java.lang.String r14 = r81.nextString()
            r15 = r81
            r39 = r14
            goto L_0x08b9
        L_0x07bf:
            org.json.JSONObject r14 = com.google.android.gms.ads.internal.util.zzbu.zzh(r81)
            com.google.android.gms.internal.ads.zzcdn r14 = com.google.android.gms.internal.ads.zzcdn.zza(r14)
            r15 = r81
            r38 = r14
            goto L_0x08b9
        L_0x07cd:
            org.json.JSONObject r14 = com.google.android.gms.ads.internal.util.zzbu.zzh(r81)
            java.lang.String r14 = r14.toString()
            r15 = r81
            r37 = r14
            goto L_0x08b9
        L_0x07db:
            java.lang.String r14 = r81.nextString()
            r15 = r81
            r36 = r14
            goto L_0x08b9
        L_0x07e5:
            java.lang.String r14 = r81.nextString()
            r15 = r81
            r35 = r14
            goto L_0x08b9
        L_0x07ef:
            org.json.JSONObject r14 = com.google.android.gms.ads.internal.util.zzbu.zzh(r81)
            r15 = r81
            r34 = r14
            goto L_0x08b9
        L_0x07f9:
            java.lang.String r14 = r81.nextString()
            r15 = r81
            r33 = r14
            goto L_0x08b9
        L_0x0803:
            java.util.List r14 = com.google.android.gms.ads.internal.util.zzbu.zzd(r81)
            r15 = r81
            r31 = r14
            goto L_0x08b9
        L_0x080d:
            java.util.List r14 = com.google.android.gms.internal.ads.zzfdl.zza(r81)
            r15 = r81
            r32 = r14
            goto L_0x08b9
        L_0x0817:
            com.google.android.gms.internal.ads.zzfdp r14 = new com.google.android.gms.internal.ads.zzfdp
            r15 = r81
            r14.<init>(r15)
            r30 = r14
            goto L_0x08b9
        L_0x0822:
            r15 = r81
            java.util.List r14 = com.google.android.gms.internal.ads.zzfdl.zza(r81)
            r29 = r14
            goto L_0x08b9
        L_0x082c:
            r15 = r81
            int r14 = r81.nextInt()
            r28 = r14
            goto L_0x08b9
        L_0x0836:
            r15 = r81
            java.util.List r14 = com.google.android.gms.ads.internal.util.zzbu.zzd(r81)
            r27 = r14
            goto L_0x08b9
        L_0x0840:
            r15 = r81
            java.util.List r14 = com.google.android.gms.ads.internal.util.zzbu.zzd(r81)
            r16 = r14
            goto L_0x08b9
        L_0x084a:
            r15 = r81
            java.util.List r14 = com.google.android.gms.ads.internal.util.zzbu.zzd(r81)
            goto L_0x08bb
        L_0x0852:
            r15 = r81
            java.util.List r13 = com.google.android.gms.ads.internal.util.zzbu.zzd(r81)
            goto L_0x08b9
        L_0x085a:
            r15 = r81
            org.json.JSONArray r12 = com.google.android.gms.ads.internal.util.zzbu.zze(r81)
            com.google.android.gms.internal.ads.zzcce r12 = com.google.android.gms.internal.ads.zzcce.zza(r12)
            goto L_0x08b9
        L_0x0865:
            r15 = r81
            java.lang.String r11 = r81.nextString()
            goto L_0x08b9
        L_0x086c:
            r15 = r81
            java.lang.String r10 = r81.nextString()
            goto L_0x08b9
        L_0x0873:
            r15 = r81
            java.util.List r9 = com.google.android.gms.ads.internal.util.zzbu.zzd(r81)
            goto L_0x08b9
        L_0x087a:
            r15 = r81
            java.util.List r8 = com.google.android.gms.ads.internal.util.zzbu.zzd(r81)
            goto L_0x08b9
        L_0x0881:
            r15 = r81
            java.util.List r7 = com.google.android.gms.ads.internal.util.zzbu.zzd(r81)
            goto L_0x08b9
        L_0x0888:
            r15 = r81
            int r6 = r81.nextInt()
            int r6 = zzc(r6)
            goto L_0x08b9
        L_0x0893:
            r15 = r81
            java.util.List r5 = com.google.android.gms.ads.internal.util.zzbu.zzd(r81)
            goto L_0x08b9
        L_0x089a:
            r15 = r81
            java.util.List r4 = com.google.android.gms.ads.internal.util.zzbu.zzd(r81)
            goto L_0x08b9
        L_0x08a1:
            r15 = r81
            java.util.List r3 = com.google.android.gms.ads.internal.util.zzbu.zzd(r81)
            goto L_0x08b9
        L_0x08a8:
            r15 = r81
            java.lang.String r2 = r81.nextString()
            int r2 = zzb(r2)
            goto L_0x08b9
        L_0x08b3:
            r15 = r81
            java.util.List r1 = com.google.android.gms.ads.internal.util.zzbu.zzd(r81)
        L_0x08b9:
            r14 = r18
        L_0x08bb:
            r15 = r16
            goto L_0x00e8
        L_0x08bf:
            r18 = r14
            r16 = r15
            r15 = r81
            r81.endObject()
            r0.zza = r1
            r0.zzb = r2
            r0.zzc = r3
            r0.zzd = r4
            r0.zzg = r5
            r0.zzf = r6
            r0.zzh = r7
            r0.zzi = r8
            r0.zzj = r9
            r0.zzk = r10
            r0.zzl = r11
            r0.zzm = r12
            r0.zzn = r13
            r0.zzo = r14
            r10 = r16
            r0.zzp = r10
            r11 = r27
            r0.zzq = r11
            r1 = r28
            r0.zzr = r1
            r12 = r29
            r0.zzs = r12
            r1 = r30
            r0.zzt = r1
            r13 = r31
            r0.zzu = r13
            r14 = r32
            r0.zzv = r14
            r1 = r33
            r0.zzx = r1
            r15 = r34
            r0.zzw = r15
            r1 = r35
            r0.zzy = r1
            r1 = r36
            r0.zzz = r1
            r1 = r37
            r0.zzA = r1
            r1 = r38
            r0.zzB = r1
            r1 = r39
            r0.zzC = r1
            r1 = r40
            r0.zzD = r1
            r1 = r41
            r0.zzE = r1
            r1 = r42
            r0.zzK = r1
            r1 = r43
            r0.zzL = r1
            r1 = r44
            r0.zzM = r1
            r1 = r45
            r0.zzN = r1
            r1 = r46
            r0.zzO = r1
            r1 = r47
            r0.zzP = r1
            r1 = r48
            r0.zzQ = r1
            r1 = r49
            r0.zzR = r1
            r1 = r50
            r0.zzS = r1
            r1 = r51
            r0.zzU = r1
            r1 = r52
            r0.zzV = r1
            com.google.android.gms.internal.ads.zzfei r1 = new com.google.android.gms.internal.ads.zzfei
            r2 = r53
            r1.<init>(r2)
            r0.zzW = r1
            r1 = r54
            r0.zzX = r1
            r1 = r55
            r0.zzY = r1
            r1 = r56
            r0.zzZ = r1
            r1 = r57
            r0.zzaa = r1
            r1 = r58
            r0.zzab = r1
            r1 = r59
            r0.zzac = r1
            r1 = r60
            r0.zzad = r1
            r1 = r61
            r0.zzae = r1
            r1 = r62
            r0.zzaf = r1
            r1 = r63
            r0.zzag = r1
            r1 = r64
            r0.zzah = r1
            r1 = r65
            r0.zzai = r1
            r1 = r66
            r0.zzaj = r1
            r1 = r67
            r0.zzF = r1
            r1 = r68
            r0.zzG = r1
            r1 = r69
            r0.zzH = r1
            r1 = r70
            r0.zzI = r1
            r1 = r71
            r0.zzJ = r1
            r1 = r72
            r0.zzak = r1
            r1 = r73
            r0.zzal = r1
            r1 = r74
            r0.zzam = r1
            r1 = r75
            r0.zzan = r1
            r1 = r76
            r0.zzao = r1
            r1 = r77
            r0.zze = r1
            r1 = r78
            r0.zzT = r1
            r1 = r79
            r0.zzap = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfdk.<init>(android.util.JsonReader):void");
    }

    public static String zza(int i) {
        switch (i) {
            case 1:
                return "BANNER";
            case 2:
                return "INTERSTITIAL";
            case 3:
                return "NATIVE_EXPRESS";
            case 4:
                return "NATIVE";
            case 5:
                return "REWARDED";
            case 6:
                return "APP_OPEN_AD";
            case 7:
                return "REWARDED_INTERSTITIAL";
            default:
                return "UNKNOWN";
        }
    }

    private static int zzb(String str) {
        if ("banner".equals(str)) {
            return 1;
        }
        if (IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE.equals(str)) {
            return 2;
        }
        if ("native_express".equals(str)) {
            return 3;
        }
        if ("native".equals(str)) {
            return 4;
        }
        if ("rewarded".equals(str)) {
            return 5;
        }
        if ("app_open_ad".equals(str) || "app_open_ad_v2".equals(str)) {
            return 6;
        }
        return "rewarded_interstitial".equals(str) ? 7 : 0;
    }

    private static int zzc(int i) {
        if (i == 0 || i == 1) {
            return i;
        }
        return 0;
    }

    private static final int zzd(String str) {
        if ("landscape".equalsIgnoreCase(str)) {
            return 6;
        }
        return "portrait".equalsIgnoreCase(str) ? 7 : -1;
    }
}
