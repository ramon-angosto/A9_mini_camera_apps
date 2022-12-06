package com.alibaba.sdk.android.oss.internal;

import android.text.TextUtils;
import android.util.Xml;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.CRC64;
import com.alibaba.sdk.android.oss.common.utils.DateUtil;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.AppendObjectResult;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.CopyObjectResult;
import com.alibaba.sdk.android.oss.model.CreateBucketRequest;
import com.alibaba.sdk.android.oss.model.CreateBucketResult;
import com.alibaba.sdk.android.oss.model.DeleteBucketLifecycleResult;
import com.alibaba.sdk.android.oss.model.DeleteBucketLoggingResult;
import com.alibaba.sdk.android.oss.model.DeleteBucketResult;
import com.alibaba.sdk.android.oss.model.DeleteMultipleObjectResult;
import com.alibaba.sdk.android.oss.model.DeleteObjectResult;
import com.alibaba.sdk.android.oss.model.GetBucketACLResult;
import com.alibaba.sdk.android.oss.model.GetBucketInfoResult;
import com.alibaba.sdk.android.oss.model.GetBucketLifecycleResult;
import com.alibaba.sdk.android.oss.model.GetBucketLoggingResult;
import com.alibaba.sdk.android.oss.model.GetBucketRefererResult;
import com.alibaba.sdk.android.oss.model.GetObjectACLResult;
import com.alibaba.sdk.android.oss.model.GetObjectResult;
import com.alibaba.sdk.android.oss.model.GetSymlinkResult;
import com.alibaba.sdk.android.oss.model.HeadObjectResult;
import com.alibaba.sdk.android.oss.model.ImagePersistResult;
import com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.ListBucketsResult;
import com.alibaba.sdk.android.oss.model.ListMultipartUploadsResult;
import com.alibaba.sdk.android.oss.model.ListObjectsResult;
import com.alibaba.sdk.android.oss.model.ListPartsResult;
import com.alibaba.sdk.android.oss.model.OSSBucketSummary;
import com.alibaba.sdk.android.oss.model.OSSObjectSummary;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import com.alibaba.sdk.android.oss.model.Owner;
import com.alibaba.sdk.android.oss.model.PartSummary;
import com.alibaba.sdk.android.oss.model.PutBucketLifecycleResult;
import com.alibaba.sdk.android.oss.model.PutBucketLoggingResult;
import com.alibaba.sdk.android.oss.model.PutBucketRefererResult;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.alibaba.sdk.android.oss.model.PutSymlinkResult;
import com.alibaba.sdk.android.oss.model.RestoreObjectResult;
import com.alibaba.sdk.android.oss.model.TriggerCallbackResult;
import com.alibaba.sdk.android.oss.model.UploadPartResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ResponseParsers {

    public static final class AbortMultipartUploadResponseParser extends AbstractResponseParser<AbortMultipartUploadResult> {
        public AbortMultipartUploadResult parseData(ResponseMessage responseMessage, AbortMultipartUploadResult abortMultipartUploadResult) throws Exception {
            return abortMultipartUploadResult;
        }
    }

    public static final class DeleteBucketLifecycleResponseParser extends AbstractResponseParser<DeleteBucketLifecycleResult> {
        public DeleteBucketLifecycleResult parseData(ResponseMessage responseMessage, DeleteBucketLifecycleResult deleteBucketLifecycleResult) throws Exception {
            return deleteBucketLifecycleResult;
        }
    }

    public static final class DeleteBucketLoggingResponseParser extends AbstractResponseParser<DeleteBucketLoggingResult> {
        public DeleteBucketLoggingResult parseData(ResponseMessage responseMessage, DeleteBucketLoggingResult deleteBucketLoggingResult) throws Exception {
            return deleteBucketLoggingResult;
        }
    }

    public static final class DeleteBucketResponseParser extends AbstractResponseParser<DeleteBucketResult> {
        public DeleteBucketResult parseData(ResponseMessage responseMessage, DeleteBucketResult deleteBucketResult) throws Exception {
            return deleteBucketResult;
        }
    }

    public static final class DeleteObjectResponseParser extends AbstractResponseParser<DeleteObjectResult> {
        public DeleteObjectResult parseData(ResponseMessage responseMessage, DeleteObjectResult deleteObjectResult) throws Exception {
            return deleteObjectResult;
        }
    }

    public static final class ImagePersistResponseParser extends AbstractResponseParser<ImagePersistResult> {
        public ImagePersistResult parseData(ResponseMessage responseMessage, ImagePersistResult imagePersistResult) throws Exception {
            return imagePersistResult;
        }
    }

    public static final class PutBucketLifecycleResponseParser extends AbstractResponseParser<PutBucketLifecycleResult> {
        public PutBucketLifecycleResult parseData(ResponseMessage responseMessage, PutBucketLifecycleResult putBucketLifecycleResult) throws Exception {
            return putBucketLifecycleResult;
        }
    }

    public static final class PutBucketLoggingResponseParser extends AbstractResponseParser<PutBucketLoggingResult> {
        public PutBucketLoggingResult parseData(ResponseMessage responseMessage, PutBucketLoggingResult putBucketLoggingResult) throws Exception {
            return putBucketLoggingResult;
        }
    }

    public static final class PutBucketRefererResponseParser extends AbstractResponseParser<PutBucketRefererResult> {
        public PutBucketRefererResult parseData(ResponseMessage responseMessage, PutBucketRefererResult putBucketRefererResult) throws Exception {
            return putBucketRefererResult;
        }
    }

    public static final class PutSymlinkResponseParser extends AbstractResponseParser<PutSymlinkResult> {
        /* access modifiers changed from: package-private */
        public PutSymlinkResult parseData(ResponseMessage responseMessage, PutSymlinkResult putSymlinkResult) throws Exception {
            return putSymlinkResult;
        }
    }

    public static final class RestoreObjectResponseParser extends AbstractResponseParser<RestoreObjectResult> {
        /* access modifiers changed from: package-private */
        public RestoreObjectResult parseData(ResponseMessage responseMessage, RestoreObjectResult restoreObjectResult) throws Exception {
            return restoreObjectResult;
        }
    }

    /* access modifiers changed from: private */
    public static CopyObjectResult parseCopyObjectResponseXML(InputStream inputStream, CopyObjectResult copyObjectResult) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("LastModified".equals(name)) {
                    copyObjectResult.setLastModified(DateUtil.parseIso8601Date(newPullParser.nextText()));
                } else if (HttpHeaders.ETAG.equals(name)) {
                    copyObjectResult.setEtag(newPullParser.nextText());
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return copyObjectResult;
    }

    /* access modifiers changed from: private */
    public static ListPartsResult parseListPartsResponseXML(InputStream inputStream, ListPartsResult listPartsResult) throws Exception {
        ArrayList arrayList = new ArrayList();
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        PartSummary partSummary = null;
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("Bucket".equals(name)) {
                    listPartsResult.setBucketName(newPullParser.nextText());
                } else if ("Key".equals(name)) {
                    listPartsResult.setKey(newPullParser.nextText());
                } else if ("UploadId".equals(name)) {
                    listPartsResult.setUploadId(newPullParser.nextText());
                } else if ("PartNumberMarker".equals(name)) {
                    String nextText = newPullParser.nextText();
                    if (!OSSUtils.isEmptyString(nextText)) {
                        listPartsResult.setPartNumberMarker(Integer.parseInt(nextText));
                    }
                } else if ("NextPartNumberMarker".equals(name)) {
                    String nextText2 = newPullParser.nextText();
                    if (!OSSUtils.isEmptyString(nextText2)) {
                        listPartsResult.setNextPartNumberMarker(Integer.parseInt(nextText2));
                    }
                } else if ("MaxParts".equals(name)) {
                    String nextText3 = newPullParser.nextText();
                    if (!OSSUtils.isEmptyString(nextText3)) {
                        listPartsResult.setMaxParts(Integer.parseInt(nextText3));
                    }
                } else if ("IsTruncated".equals(name)) {
                    String nextText4 = newPullParser.nextText();
                    if (!OSSUtils.isEmptyString(nextText4)) {
                        listPartsResult.setTruncated(Boolean.valueOf(nextText4).booleanValue());
                    }
                } else if (CreateBucketRequest.TAB_STORAGECLASS.equals(name)) {
                    listPartsResult.setStorageClass(newPullParser.nextText());
                } else if ("Part".equals(name)) {
                    partSummary = new PartSummary();
                } else if ("PartNumber".equals(name)) {
                    String nextText5 = newPullParser.nextText();
                    if (!OSSUtils.isEmptyString(nextText5)) {
                        partSummary.setPartNumber(Integer.valueOf(nextText5).intValue());
                    }
                } else if ("LastModified".equals(name)) {
                    partSummary.setLastModified(DateUtil.parseIso8601Date(newPullParser.nextText()));
                } else if (HttpHeaders.ETAG.equals(name)) {
                    partSummary.setETag(newPullParser.nextText());
                } else if ("Size".equals(name)) {
                    String nextText6 = newPullParser.nextText();
                    if (!OSSUtils.isEmptyString(nextText6)) {
                        partSummary.setSize(Long.valueOf(nextText6).longValue());
                    }
                }
            } else if (eventType == 3 && "Part".equals(newPullParser.getName())) {
                arrayList.add(partSummary);
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        if (arrayList.size() > 0) {
            listPartsResult.setParts(arrayList);
        }
        return listPartsResult;
    }

    /* access modifiers changed from: private */
    public static CompleteMultipartUploadResult parseCompleteMultipartUploadResponseXML(InputStream inputStream, CompleteMultipartUploadResult completeMultipartUploadResult) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if (HttpHeaders.LOCATION.equals(name)) {
                    completeMultipartUploadResult.setLocation(newPullParser.nextText());
                } else if ("Bucket".equals(name)) {
                    completeMultipartUploadResult.setBucketName(newPullParser.nextText());
                } else if ("Key".equals(name)) {
                    completeMultipartUploadResult.setObjectKey(newPullParser.nextText());
                } else if (HttpHeaders.ETAG.equals(name)) {
                    completeMultipartUploadResult.setETag(newPullParser.nextText());
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return completeMultipartUploadResult;
    }

    /* access modifiers changed from: private */
    public static InitiateMultipartUploadResult parseInitMultipartResponseXML(InputStream inputStream, InitiateMultipartUploadResult initiateMultipartUploadResult) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("Bucket".equals(name)) {
                    initiateMultipartUploadResult.setBucketName(newPullParser.nextText());
                } else if ("Key".equals(name)) {
                    initiateMultipartUploadResult.setObjectKey(newPullParser.nextText());
                } else if ("UploadId".equals(name)) {
                    initiateMultipartUploadResult.setUploadId(newPullParser.nextText());
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return initiateMultipartUploadResult;
    }

    /* access modifiers changed from: private */
    public static GetObjectACLResult parseGetObjectACLResponse(InputStream inputStream, GetObjectACLResult getObjectACLResult) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("Grant".equals(name)) {
                    getObjectACLResult.setObjectACL(newPullParser.nextText());
                } else if ("ID".equals(name)) {
                    getObjectACLResult.setObjectOwnerID(newPullParser.nextText());
                } else if ("DisplayName".equals(name)) {
                    getObjectACLResult.setObjectOwner(newPullParser.nextText());
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return getObjectACLResult;
    }

    /* access modifiers changed from: private */
    public static GetBucketInfoResult parseGetBucketInfoResponse(InputStream inputStream, GetBucketInfoResult getBucketInfoResult) throws Exception {
        String name;
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        OSSBucketSummary oSSBucketSummary = null;
        Owner owner = null;
        while (eventType != 1) {
            if (eventType == 2) {
                String name2 = newPullParser.getName();
                if (name2 != null) {
                    if ("Owner".equals(name2)) {
                        owner = new Owner();
                    } else if ("ID".equals(name2)) {
                        if (owner != null) {
                            owner.setId(newPullParser.nextText());
                        }
                    } else if ("DisplayName".equals(name2)) {
                        if (owner != null) {
                            owner.setDisplayName(newPullParser.nextText());
                        }
                    } else if ("Bucket".equals(name2)) {
                        oSSBucketSummary = new OSSBucketSummary();
                    } else if ("CreationDate".equals(name2)) {
                        if (oSSBucketSummary != null) {
                            oSSBucketSummary.createDate = DateUtil.parseIso8601Date(newPullParser.nextText());
                        }
                    } else if ("ExtranetEndpoint".equals(name2)) {
                        if (oSSBucketSummary != null) {
                            oSSBucketSummary.extranetEndpoint = newPullParser.nextText();
                        }
                    } else if ("IntranetEndpoint".equals(name2)) {
                        if (oSSBucketSummary != null) {
                            oSSBucketSummary.intranetEndpoint = newPullParser.nextText();
                        }
                    } else if (HttpHeaders.LOCATION.equals(name2)) {
                        if (oSSBucketSummary != null) {
                            oSSBucketSummary.location = newPullParser.nextText();
                        }
                    } else if ("Name".equals(name2)) {
                        if (oSSBucketSummary != null) {
                            oSSBucketSummary.name = newPullParser.nextText();
                        }
                    } else if (CreateBucketRequest.TAB_STORAGECLASS.equals(name2)) {
                        if (oSSBucketSummary != null) {
                            oSSBucketSummary.storageClass = newPullParser.nextText();
                        }
                    } else if ("Grant".equals(name2) && oSSBucketSummary != null) {
                        oSSBucketSummary.setAcl(newPullParser.nextText());
                    }
                }
            } else if (eventType == 3 && (name = newPullParser.getName()) != null) {
                if ("Bucket".equals(name)) {
                    if (oSSBucketSummary != null) {
                        getBucketInfoResult.setBucket(oSSBucketSummary);
                    }
                } else if ("Owner".equals(name) && oSSBucketSummary != null) {
                    oSSBucketSummary.owner = owner;
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return getBucketInfoResult;
    }

    /* access modifiers changed from: private */
    public static GetBucketACLResult parseGetBucketACLResponse(InputStream inputStream, GetBucketACLResult getBucketACLResult) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("Grant".equals(name)) {
                    getBucketACLResult.setBucketACL(newPullParser.nextText());
                } else if ("ID".equals(name)) {
                    getBucketACLResult.setBucketOwnerID(newPullParser.nextText());
                } else if ("DisplayName".equals(name)) {
                    getBucketACLResult.setBucketOwner(newPullParser.nextText());
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return getBucketACLResult;
    }

    /* access modifiers changed from: private */
    public static GetBucketRefererResult parseGetBucketRefererResponse(InputStream inputStream, GetBucketRefererResult getBucketRefererResult) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2 && "Referer".equals(newPullParser.getName())) {
                getBucketRefererResult.addReferer(newPullParser.nextText());
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return getBucketRefererResult;
    }

    /* access modifiers changed from: private */
    public static GetBucketLoggingResult parseGetBucketLoggingResponse(InputStream inputStream, GetBucketLoggingResult getBucketLoggingResult) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("LoggingEnabled".equals(name)) {
                    getBucketLoggingResult.setLoggingEnabled(true);
                } else if ("TargetBucket".equals(name)) {
                    getBucketLoggingResult.setTargetBucketName(newPullParser.nextText());
                } else if ("TargetPrefix".equals(name)) {
                    getBucketLoggingResult.setTargetPrefix(newPullParser.nextText());
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return getBucketLoggingResult;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0018 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.alibaba.sdk.android.oss.model.GetBucketLifecycleResult parseGetBucketLifecycleResponse(java.io.InputStream r16, com.alibaba.sdk.android.oss.model.GetBucketLifecycleResult r17) throws java.lang.Exception {
        /*
            r0 = r17
            org.xmlpull.v1.XmlPullParser r1 = android.util.Xml.newPullParser()
            java.lang.String r2 = "utf-8"
            r3 = r16
            r1.setInput(r3, r2)
            int r2 = r1.getEventType()
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x0018:
            r12 = 1
            if (r2 == r12) goto L_0x0165
            r13 = 2
            java.lang.String r14 = "Transition"
            java.lang.String r15 = "AbortMultipartUpload"
            java.lang.String r4 = "Expiration"
            java.lang.String r3 = "Rule"
            if (r2 == r13) goto L_0x0059
            r12 = 3
            if (r2 == r12) goto L_0x002a
            goto L_0x0069
        L_0x002a:
            java.lang.String r2 = r1.getName()
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x0038
            r0.addLifecycleRule(r5)
            goto L_0x0069
        L_0x0038:
            boolean r3 = r4.equals(r2)
            if (r3 == 0) goto L_0x0042
            r3 = 0
            r6 = 0
            goto L_0x0158
        L_0x0042:
            boolean r3 = r15.equals(r2)
            if (r3 == 0) goto L_0x004c
            r3 = 0
            r7 = 0
            goto L_0x0158
        L_0x004c:
            boolean r2 = r14.equals(r2)
            if (r2 == 0) goto L_0x0069
            r3 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            goto L_0x0158
        L_0x0059:
            java.lang.String r2 = r1.getName()
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x006c
            com.alibaba.sdk.android.oss.model.BucketLifecycleRule r2 = new com.alibaba.sdk.android.oss.model.BucketLifecycleRule
            r2.<init>()
            r5 = r2
        L_0x0069:
            r3 = 0
            goto L_0x0158
        L_0x006c:
            java.lang.String r3 = "ID"
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x007c
            java.lang.String r2 = r1.nextText()
            r5.setIdentifier(r2)
            goto L_0x0069
        L_0x007c:
            java.lang.String r3 = "Prefix"
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x008c
            java.lang.String r2 = r1.nextText()
            r5.setPrefix(r2)
            goto L_0x0069
        L_0x008c:
            java.lang.String r3 = "Status"
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x00aa
            java.lang.String r2 = r1.nextText()
            java.lang.String r3 = "Enabled"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x00a4
            r5.setStatus(r12)
            goto L_0x0069
        L_0x00a4:
            r3 = 0
            r5.setStatus(r3)
            goto L_0x0158
        L_0x00aa:
            r3 = 0
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L_0x00b4
            r6 = 1
            goto L_0x0158
        L_0x00b4:
            boolean r4 = r15.equals(r2)
            if (r4 == 0) goto L_0x00bd
            r7 = 1
            goto L_0x0158
        L_0x00bd:
            boolean r4 = r14.equals(r2)
            if (r4 == 0) goto L_0x00c6
            r8 = 1
            goto L_0x0158
        L_0x00c6:
            java.lang.String r4 = "Days"
            boolean r4 = r4.equals(r2)
            java.lang.String r12 = "Archive"
            java.lang.String r13 = "IA"
            if (r4 == 0) goto L_0x00fd
            java.lang.String r2 = r1.nextText()
            if (r5 == 0) goto L_0x00fb
            if (r6 == 0) goto L_0x00de
            r5.setDays(r2)
            goto L_0x00fb
        L_0x00de:
            if (r7 == 0) goto L_0x00e4
            r5.setMultipartDays(r2)
            goto L_0x00fb
        L_0x00e4:
            if (r8 == 0) goto L_0x00fb
            if (r11 == 0) goto L_0x00fb
            boolean r4 = r13.equals(r11)
            if (r4 == 0) goto L_0x00f2
            r5.setIADays(r2)
            goto L_0x00fb
        L_0x00f2:
            boolean r4 = r12.equals(r11)
            if (r4 == 0) goto L_0x00fb
            r5.setArchiveDays(r2)
        L_0x00fb:
            r9 = r2
            goto L_0x0158
        L_0x00fd:
            java.lang.String r4 = "Date"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L_0x0130
            java.lang.String r2 = r1.nextText()
            if (r5 == 0) goto L_0x012e
            if (r6 == 0) goto L_0x0111
            r5.setExpireDate(r2)
            goto L_0x012e
        L_0x0111:
            if (r7 == 0) goto L_0x0117
            r5.setMultipartExpireDate(r2)
            goto L_0x012e
        L_0x0117:
            if (r8 == 0) goto L_0x012e
            if (r11 == 0) goto L_0x012e
            boolean r4 = r13.equals(r11)
            if (r4 == 0) goto L_0x0125
            r5.setIAExpireDate(r2)
            goto L_0x012e
        L_0x0125:
            boolean r4 = r12.equals(r11)
            if (r4 == 0) goto L_0x012e
            r5.setArchiveExpireDate(r2)
        L_0x012e:
            r10 = r2
            goto L_0x0158
        L_0x0130:
            java.lang.String r4 = "StorageClass"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0158
            java.lang.String r2 = r1.nextText()
            if (r5 == 0) goto L_0x0157
            boolean r4 = r13.equals(r2)
            if (r4 == 0) goto L_0x014b
            r5.setIADays(r9)
            r5.setIAExpireDate(r10)
            goto L_0x0157
        L_0x014b:
            boolean r4 = r12.equals(r2)
            if (r4 == 0) goto L_0x0157
            r5.setArchiveDays(r10)
            r5.setArchiveExpireDate(r10)
        L_0x0157:
            r11 = r2
        L_0x0158:
            int r2 = r1.next()
            r4 = 4
            if (r2 != r4) goto L_0x0018
            int r2 = r1.next()
            goto L_0x0018
        L_0x0165:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.ResponseParsers.parseGetBucketLifecycleResponse(java.io.InputStream, com.alibaba.sdk.android.oss.model.GetBucketLifecycleResult):com.alibaba.sdk.android.oss.model.GetBucketLifecycleResult");
    }

    /* access modifiers changed from: private */
    public static DeleteMultipleObjectResult parseDeleteMultipleObjectResponse(InputStream inputStream, DeleteMultipleObjectResult deleteMultipleObjectResult) throws Exception {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2 && "Key".equals(newPullParser.getName())) {
                deleteMultipleObjectResult.addDeletedObject(newPullParser.nextText());
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return deleteMultipleObjectResult;
    }

    /* access modifiers changed from: private */
    public static ListBucketsResult parseBucketListResponse(InputStream inputStream, ListBucketsResult listBucketsResult) throws Exception {
        listBucketsResult.clearBucketList();
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        OSSBucketSummary oSSBucketSummary = null;
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if (name != null) {
                    if ("Prefix".equals(name)) {
                        listBucketsResult.setPrefix(newPullParser.nextText());
                    } else if ("Marker".equals(name)) {
                        listBucketsResult.setMarker(newPullParser.nextText());
                    } else if ("MaxKeys".equals(name)) {
                        String nextText = newPullParser.nextText();
                        if (nextText != null) {
                            listBucketsResult.setMaxKeys(Integer.valueOf(nextText).intValue());
                        }
                    } else if ("IsTruncated".equals(name)) {
                        String nextText2 = newPullParser.nextText();
                        if (nextText2 != null) {
                            listBucketsResult.setTruncated(Boolean.valueOf(nextText2).booleanValue());
                        }
                    } else if ("NextMarker".equals(name)) {
                        listBucketsResult.setNextMarker(newPullParser.nextText());
                    } else if ("ID".equals(name)) {
                        listBucketsResult.setOwnerId(newPullParser.nextText());
                    } else if ("DisplayName".equals(name)) {
                        listBucketsResult.setOwnerDisplayName(newPullParser.nextText());
                    } else if ("Bucket".equals(name)) {
                        oSSBucketSummary = new OSSBucketSummary();
                    } else if ("CreationDate".equals(name)) {
                        if (oSSBucketSummary != null) {
                            oSSBucketSummary.createDate = DateUtil.parseIso8601Date(newPullParser.nextText());
                        }
                    } else if ("ExtranetEndpoint".equals(name)) {
                        if (oSSBucketSummary != null) {
                            oSSBucketSummary.extranetEndpoint = newPullParser.nextText();
                        }
                    } else if ("IntranetEndpoint".equals(name)) {
                        if (oSSBucketSummary != null) {
                            oSSBucketSummary.intranetEndpoint = newPullParser.nextText();
                        }
                    } else if (HttpHeaders.LOCATION.equals(name)) {
                        if (oSSBucketSummary != null) {
                            oSSBucketSummary.location = newPullParser.nextText();
                        }
                    } else if ("Name".equals(name)) {
                        if (oSSBucketSummary != null) {
                            oSSBucketSummary.name = newPullParser.nextText();
                        }
                    } else if (CreateBucketRequest.TAB_STORAGECLASS.equals(name) && oSSBucketSummary != null) {
                        oSSBucketSummary.storageClass = newPullParser.nextText();
                    }
                }
            } else if (eventType == 3 && "Bucket".equals(newPullParser.getName()) && oSSBucketSummary != null) {
                listBucketsResult.addBucket(oSSBucketSummary);
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return listBucketsResult;
    }

    /* access modifiers changed from: private */
    public static ListObjectsResult parseObjectListResponse(InputStream inputStream, ListObjectsResult listObjectsResult) throws Exception {
        listObjectsResult.clearCommonPrefixes();
        listObjectsResult.clearObjectSummaries();
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "utf-8");
        int eventType = newPullParser.getEventType();
        Owner owner = null;
        OSSObjectSummary oSSObjectSummary = null;
        boolean z = false;
        while (eventType != 1) {
            if (eventType == 2) {
                String name = newPullParser.getName();
                if ("Name".equals(name)) {
                    listObjectsResult.setBucketName(newPullParser.nextText());
                } else if ("Prefix".equals(name)) {
                    if (z) {
                        String nextText = newPullParser.nextText();
                        if (!OSSUtils.isEmptyString(nextText)) {
                            listObjectsResult.addCommonPrefix(nextText);
                        }
                    } else {
                        listObjectsResult.setPrefix(newPullParser.nextText());
                    }
                } else if ("Marker".equals(name)) {
                    listObjectsResult.setMarker(newPullParser.nextText());
                } else if ("Delimiter".equals(name)) {
                    listObjectsResult.setDelimiter(newPullParser.nextText());
                } else if ("EncodingType".equals(name)) {
                    listObjectsResult.setEncodingType(newPullParser.nextText());
                } else if ("MaxKeys".equals(name)) {
                    String nextText2 = newPullParser.nextText();
                    if (!OSSUtils.isEmptyString(nextText2)) {
                        listObjectsResult.setMaxKeys(Integer.valueOf(nextText2).intValue());
                    }
                } else if ("NextMarker".equals(name)) {
                    listObjectsResult.setNextMarker(newPullParser.nextText());
                } else if ("IsTruncated".equals(name)) {
                    String nextText3 = newPullParser.nextText();
                    if (!OSSUtils.isEmptyString(nextText3)) {
                        listObjectsResult.setTruncated(Boolean.valueOf(nextText3).booleanValue());
                    }
                } else if ("Contents".equals(name)) {
                    oSSObjectSummary = new OSSObjectSummary();
                } else if ("Key".equals(name)) {
                    oSSObjectSummary.setKey(newPullParser.nextText());
                } else if ("LastModified".equals(name)) {
                    oSSObjectSummary.setLastModified(DateUtil.parseIso8601Date(newPullParser.nextText()));
                } else if ("Size".equals(name)) {
                    String nextText4 = newPullParser.nextText();
                    if (!OSSUtils.isEmptyString(nextText4)) {
                        oSSObjectSummary.setSize(Long.valueOf(nextText4).longValue());
                    }
                } else if (HttpHeaders.ETAG.equals(name)) {
                    oSSObjectSummary.setETag(newPullParser.nextText());
                } else if ("Type".equals(name)) {
                    oSSObjectSummary.setType(newPullParser.nextText());
                } else if (CreateBucketRequest.TAB_STORAGECLASS.equals(name)) {
                    oSSObjectSummary.setStorageClass(newPullParser.nextText());
                } else if ("Owner".equals(name)) {
                    owner = new Owner();
                } else if ("ID".equals(name)) {
                    owner.setId(newPullParser.nextText());
                } else if ("DisplayName".equals(name)) {
                    owner.setDisplayName(newPullParser.nextText());
                } else if ("CommonPrefixes".equals(name)) {
                    z = true;
                }
            } else if (eventType == 3) {
                String name2 = newPullParser.getName();
                if ("Owner".equals(newPullParser.getName())) {
                    if (owner != null) {
                        oSSObjectSummary.setOwner(owner);
                    }
                } else if ("Contents".equals(name2)) {
                    if (oSSObjectSummary != null) {
                        oSSObjectSummary.setBucketName(listObjectsResult.getBucketName());
                        listObjectsResult.addObjectSummary(oSSObjectSummary);
                    }
                } else if ("CommonPrefixes".equals(name2)) {
                    z = false;
                }
            }
            eventType = newPullParser.next();
            if (eventType == 4) {
                eventType = newPullParser.next();
            }
        }
        return listObjectsResult;
    }

    public static String trimQuotes(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("\"")) {
            trim = trim.substring(1);
        }
        return trim.endsWith("\"") ? trim.substring(0, trim.length() - 1) : trim;
    }

    public static ObjectMetadata parseObjectMetadata(Map<String, String> map) throws Exception {
        try {
            ObjectMetadata objectMetadata = new ObjectMetadata();
            for (String next : map.keySet()) {
                if (next.indexOf(OSSHeaders.OSS_USER_METADATA_PREFIX) >= 0) {
                    objectMetadata.addUserMetadata(next, map.get(next));
                } else {
                    if (!next.equalsIgnoreCase(HttpHeaders.LAST_MODIFIED)) {
                        if (!next.equalsIgnoreCase(HttpHeaders.DATE)) {
                            if (next.equalsIgnoreCase(HttpHeaders.CONTENT_LENGTH)) {
                                objectMetadata.setHeader(next, Long.valueOf(map.get(next)));
                            } else if (next.equalsIgnoreCase(HttpHeaders.ETAG)) {
                                objectMetadata.setHeader(next, trimQuotes(map.get(next)));
                            } else {
                                objectMetadata.setHeader(next, map.get(next));
                            }
                        }
                    }
                    objectMetadata.setHeader(next, DateUtil.parseRfc822Date(map.get(next)));
                }
            }
            return objectMetadata;
        } catch (ParseException e) {
            throw new IOException(e.getMessage(), e);
        } catch (Exception e2) {
            throw new IOException(e2.getMessage(), e2);
        }
    }

    public static Exception parseResponseErrorXML(ResponseMessage responseMessage, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int statusCode = responseMessage.getStatusCode();
        String header = responseMessage.getResponse().header(OSSHeaders.OSS_HEADER_REQUEST_ID);
        String str7 = null;
        if (!z) {
            try {
                String string = responseMessage.getResponse().body().string();
                OSSLog.logDebug("errorMessage  ：  \n " + string);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(string.getBytes());
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(byteArrayInputStream, "utf-8");
                int eventType = newPullParser.getEventType();
                String str8 = null;
                str4 = null;
                String str9 = null;
                str2 = null;
                while (eventType != 1) {
                    if (eventType == 2) {
                        if ("Code".equals(newPullParser.getName())) {
                            str7 = newPullParser.nextText();
                        } else if ("Message".equals(newPullParser.getName())) {
                            str8 = newPullParser.nextText();
                        } else if ("RequestId".equals(newPullParser.getName())) {
                            header = newPullParser.nextText();
                        } else if ("HostId".equals(newPullParser.getName())) {
                            str4 = newPullParser.nextText();
                        } else if ("PartNumber".equals(newPullParser.getName())) {
                            str9 = newPullParser.nextText();
                        } else if ("PartEtag".equals(newPullParser.getName())) {
                            str2 = newPullParser.nextText();
                        }
                    }
                    eventType = newPullParser.next();
                    if (eventType == 4) {
                        eventType = newPullParser.next();
                    }
                }
                str6 = str7;
                str7 = str8;
                str5 = header;
                String str10 = str9;
                str3 = string;
                str = str10;
            } catch (IOException e) {
                return new ClientException(e.getMessage(), e);
            } catch (XmlPullParserException e2) {
                return new ClientException(e2.getMessage(), e2);
            }
        } else {
            str5 = header;
            str = null;
            str6 = null;
            str4 = null;
            str3 = null;
            str2 = null;
        }
        ServiceException serviceException = new ServiceException(statusCode, str7, str6, str5, str4, str3);
        if (!TextUtils.isEmpty(str2)) {
            serviceException.setPartEtag(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            serviceException.setPartNumber(str);
        }
        return serviceException;
    }

    public static final class PutObjectResponseParser extends AbstractResponseParser<PutObjectResult> {
        public PutObjectResult parseData(ResponseMessage responseMessage, PutObjectResult putObjectResult) throws IOException {
            putObjectResult.setETag(ResponseParsers.trimQuotes((String) responseMessage.getHeaders().get(HttpHeaders.ETAG)));
            String string = responseMessage.getResponse().body().string();
            if (!TextUtils.isEmpty(string)) {
                putObjectResult.setServerCallbackReturnBody(string);
            }
            return putObjectResult;
        }
    }

    public static final class AppendObjectResponseParser extends AbstractResponseParser<AppendObjectResult> {
        public AppendObjectResult parseData(ResponseMessage responseMessage, AppendObjectResult appendObjectResult) throws IOException {
            String str = (String) responseMessage.getHeaders().get(OSSHeaders.OSS_NEXT_APPEND_POSITION);
            if (str != null) {
                appendObjectResult.setNextPosition(Long.valueOf(str));
            }
            appendObjectResult.setObjectCRC64((String) responseMessage.getHeaders().get(OSSHeaders.OSS_HASH_CRC64_ECMA));
            return appendObjectResult;
        }
    }

    public static final class HeadObjectResponseParser extends AbstractResponseParser<HeadObjectResult> {
        public HeadObjectResult parseData(ResponseMessage responseMessage, HeadObjectResult headObjectResult) throws Exception {
            headObjectResult.setMetadata(ResponseParsers.parseObjectMetadata(headObjectResult.getResponseHeader()));
            return headObjectResult;
        }
    }

    public static final class GetObjectResponseParser extends AbstractResponseParser<GetObjectResult> {
        public boolean needCloseResponse() {
            return false;
        }

        public GetObjectResult parseData(ResponseMessage responseMessage, GetObjectResult getObjectResult) throws Exception {
            getObjectResult.setMetadata(ResponseParsers.parseObjectMetadata(getObjectResult.getResponseHeader()));
            getObjectResult.setContentLength(responseMessage.getContentLength());
            if (responseMessage.getRequest().isCheckCRC64()) {
                getObjectResult.setObjectContent(new CheckCRC64DownloadInputStream(responseMessage.getContent(), new CRC64(), responseMessage.getContentLength(), getObjectResult.getServerCRC().longValue(), getObjectResult.getRequestId()));
            } else {
                getObjectResult.setObjectContent(responseMessage.getContent());
            }
            return getObjectResult;
        }
    }

    public static final class GetObjectACLResponseParser extends AbstractResponseParser<GetObjectACLResult> {
        /* access modifiers changed from: package-private */
        public GetObjectACLResult parseData(ResponseMessage responseMessage, GetObjectACLResult getObjectACLResult) throws Exception {
            return ResponseParsers.parseGetObjectACLResponse(responseMessage.getContent(), getObjectACLResult);
        }
    }

    public static final class CopyObjectResponseParser extends AbstractResponseParser<CopyObjectResult> {
        public CopyObjectResult parseData(ResponseMessage responseMessage, CopyObjectResult copyObjectResult) throws Exception {
            return ResponseParsers.parseCopyObjectResponseXML(responseMessage.getContent(), copyObjectResult);
        }
    }

    public static final class CreateBucketResponseParser extends AbstractResponseParser<CreateBucketResult> {
        public CreateBucketResult parseData(ResponseMessage responseMessage, CreateBucketResult createBucketResult) throws Exception {
            if (createBucketResult.getResponseHeader().containsKey(HttpHeaders.LOCATION)) {
                createBucketResult.bucketLocation = createBucketResult.getResponseHeader().get(HttpHeaders.LOCATION);
            }
            return createBucketResult;
        }
    }

    public static final class GetBucketInfoResponseParser extends AbstractResponseParser<GetBucketInfoResult> {
        public GetBucketInfoResult parseData(ResponseMessage responseMessage, GetBucketInfoResult getBucketInfoResult) throws Exception {
            return ResponseParsers.parseGetBucketInfoResponse(responseMessage.getContent(), getBucketInfoResult);
        }
    }

    public static final class GetBucketACLResponseParser extends AbstractResponseParser<GetBucketACLResult> {
        public GetBucketACLResult parseData(ResponseMessage responseMessage, GetBucketACLResult getBucketACLResult) throws Exception {
            return ResponseParsers.parseGetBucketACLResponse(responseMessage.getContent(), getBucketACLResult);
        }
    }

    public static final class GetBucketRefererResponseParser extends AbstractResponseParser<GetBucketRefererResult> {
        public GetBucketRefererResult parseData(ResponseMessage responseMessage, GetBucketRefererResult getBucketRefererResult) throws Exception {
            return ResponseParsers.parseGetBucketRefererResponse(responseMessage.getContent(), getBucketRefererResult);
        }
    }

    public static final class GetBucketLoggingResponseParser extends AbstractResponseParser<GetBucketLoggingResult> {
        public GetBucketLoggingResult parseData(ResponseMessage responseMessage, GetBucketLoggingResult getBucketLoggingResult) throws Exception {
            return ResponseParsers.parseGetBucketLoggingResponse(responseMessage.getContent(), getBucketLoggingResult);
        }
    }

    public static final class GetBucketLifecycleResponseParser extends AbstractResponseParser<GetBucketLifecycleResult> {
        public GetBucketLifecycleResult parseData(ResponseMessage responseMessage, GetBucketLifecycleResult getBucketLifecycleResult) throws Exception {
            return ResponseParsers.parseGetBucketLifecycleResponse(responseMessage.getContent(), getBucketLifecycleResult);
        }
    }

    public static final class DeleteMultipleObjectResponseParser extends AbstractResponseParser<DeleteMultipleObjectResult> {
        /* access modifiers changed from: package-private */
        public DeleteMultipleObjectResult parseData(ResponseMessage responseMessage, DeleteMultipleObjectResult deleteMultipleObjectResult) throws Exception {
            return ResponseParsers.parseDeleteMultipleObjectResponse(responseMessage.getContent(), deleteMultipleObjectResult);
        }
    }

    public static final class ListObjectsResponseParser extends AbstractResponseParser<ListObjectsResult> {
        public ListObjectsResult parseData(ResponseMessage responseMessage, ListObjectsResult listObjectsResult) throws Exception {
            return ResponseParsers.parseObjectListResponse(responseMessage.getContent(), listObjectsResult);
        }
    }

    public static final class ListBucketResponseParser extends AbstractResponseParser<ListBucketsResult> {
        /* access modifiers changed from: package-private */
        public ListBucketsResult parseData(ResponseMessage responseMessage, ListBucketsResult listBucketsResult) throws Exception {
            return ResponseParsers.parseBucketListResponse(responseMessage.getContent(), listBucketsResult);
        }
    }

    public static final class InitMultipartResponseParser extends AbstractResponseParser<InitiateMultipartUploadResult> {
        public InitiateMultipartUploadResult parseData(ResponseMessage responseMessage, InitiateMultipartUploadResult initiateMultipartUploadResult) throws Exception {
            return ResponseParsers.parseInitMultipartResponseXML(responseMessage.getContent(), initiateMultipartUploadResult);
        }
    }

    public static final class UploadPartResponseParser extends AbstractResponseParser<UploadPartResult> {
        public UploadPartResult parseData(ResponseMessage responseMessage, UploadPartResult uploadPartResult) throws Exception {
            uploadPartResult.setETag(ResponseParsers.trimQuotes((String) responseMessage.getHeaders().get(HttpHeaders.ETAG)));
            return uploadPartResult;
        }
    }

    public static final class CompleteMultipartUploadResponseParser extends AbstractResponseParser<CompleteMultipartUploadResult> {
        public CompleteMultipartUploadResult parseData(ResponseMessage responseMessage, CompleteMultipartUploadResult completeMultipartUploadResult) throws Exception {
            if (((String) responseMessage.getHeaders().get(HttpHeaders.CONTENT_TYPE)).equals("application/xml")) {
                return ResponseParsers.parseCompleteMultipartUploadResponseXML(responseMessage.getContent(), completeMultipartUploadResult);
            }
            String string = responseMessage.getResponse().body().string();
            if (TextUtils.isEmpty(string)) {
                return completeMultipartUploadResult;
            }
            completeMultipartUploadResult.setServerCallbackReturnBody(string);
            return completeMultipartUploadResult;
        }
    }

    public static final class ListPartsResponseParser extends AbstractResponseParser<ListPartsResult> {
        public ListPartsResult parseData(ResponseMessage responseMessage, ListPartsResult listPartsResult) throws Exception {
            return ResponseParsers.parseListPartsResponseXML(responseMessage.getContent(), listPartsResult);
        }
    }

    public static final class ListMultipartUploadsResponseParser extends AbstractResponseParser<ListMultipartUploadsResult> {
        public ListMultipartUploadsResult parseData(ResponseMessage responseMessage, ListMultipartUploadsResult listMultipartUploadsResult) throws Exception {
            return listMultipartUploadsResult.parseData(responseMessage);
        }
    }

    public static final class TriggerCallbackResponseParser extends AbstractResponseParser<TriggerCallbackResult> {
        public TriggerCallbackResult parseData(ResponseMessage responseMessage, TriggerCallbackResult triggerCallbackResult) throws Exception {
            String string = responseMessage.getResponse().body().string();
            if (!TextUtils.isEmpty(string)) {
                triggerCallbackResult.setServerCallbackReturnBody(string);
            }
            return triggerCallbackResult;
        }
    }

    public static final class GetSymlinkResponseParser extends AbstractResponseParser<GetSymlinkResult> {
        /* access modifiers changed from: package-private */
        public GetSymlinkResult parseData(ResponseMessage responseMessage, GetSymlinkResult getSymlinkResult) throws Exception {
            getSymlinkResult.setTargetObjectName((String) responseMessage.getHeaders().get(OSSHeaders.OSS_HEADER_SYMLINK_TARGET));
            return getSymlinkResult;
        }
    }
}
