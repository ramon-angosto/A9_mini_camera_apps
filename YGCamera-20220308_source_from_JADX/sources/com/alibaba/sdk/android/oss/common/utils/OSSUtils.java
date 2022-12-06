package com.alibaba.sdk.android.oss.common.utils;

import android.content.Context;
import android.net.InetAddresses;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.alibaba.sdk.android.oss.common.auth.HmacSHA1Signature;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSCustomSignerCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationToken;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.alibaba.sdk.android.oss.exception.InconsistentException;
import com.alibaba.sdk.android.oss.internal.RequestMessage;
import com.alibaba.sdk.android.oss.model.CopyObjectRequest;
import com.alibaba.sdk.android.oss.model.ListBucketsRequest;
import com.alibaba.sdk.android.oss.model.ListMultipartUploadsRequest;
import com.alibaba.sdk.android.oss.model.ListObjectsRequest;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

public class OSSUtils {
    private static final String NEW_LINE = "\n";
    private static final List<String> SIGNED_PARAMTERS = Arrays.asList(new String[]{RequestParameters.SUBRESOURCE_BUCKETINFO, RequestParameters.SUBRESOURCE_ACL, RequestParameters.SUBRESOURCE_UPLOADS, RequestParameters.SUBRESOURCE_LOCATION, RequestParameters.SUBRESOURCE_CORS, RequestParameters.SUBRESOURCE_LOGGING, RequestParameters.SUBRESOURCE_WEBSITE, RequestParameters.SUBRESOURCE_REFERER, RequestParameters.SUBRESOURCE_LIFECYCLE, RequestParameters.SUBRESOURCE_DELETE, RequestParameters.SUBRESOURCE_APPEND, RequestParameters.UPLOAD_ID, RequestParameters.PART_NUMBER, RequestParameters.SECURITY_TOKEN, "position", RequestParameters.RESPONSE_HEADER_CACHE_CONTROL, RequestParameters.RESPONSE_HEADER_CONTENT_DISPOSITION, RequestParameters.RESPONSE_HEADER_CONTENT_ENCODING, RequestParameters.RESPONSE_HEADER_CONTENT_LANGUAGE, RequestParameters.RESPONSE_HEADER_CONTENT_TYPE, RequestParameters.RESPONSE_HEADER_EXPIRES, RequestParameters.X_OSS_PROCESS, RequestParameters.SUBRESOURCE_SEQUENTIAL, RequestParameters.X_OSS_SYMLINK, RequestParameters.X_OSS_RESTORE});

    public static boolean checkParamRange(long j, long j2, boolean z, long j3, boolean z2) {
        return (!z || !z2) ? (!z || z2) ? (z || z2) ? j2 < j && j <= j3 : j2 < j && j < j3 : j2 <= j && j < j3 : j2 <= j && j <= j3;
    }

    public static void populateRequestMetadata(Map<String, String> map, ObjectMetadata objectMetadata) {
        if (objectMetadata != null) {
            Map<String, Object> rawMetadata = objectMetadata.getRawMetadata();
            if (rawMetadata != null) {
                for (Map.Entry next : rawMetadata.entrySet()) {
                    map.put(next.getKey(), next.getValue().toString());
                }
            }
            Map<String, String> userMetadata = objectMetadata.getUserMetadata();
            if (userMetadata != null) {
                for (Map.Entry next2 : userMetadata.entrySet()) {
                    String str = (String) next2.getKey();
                    String str2 = (String) next2.getValue();
                    if (str != null) {
                        str = str.trim();
                    }
                    if (str2 != null) {
                        str2 = str2.trim();
                    }
                    map.put(str, str2);
                }
            }
        }
    }

    public static void populateListBucketRequestParameters(ListBucketsRequest listBucketsRequest, Map<String, String> map) {
        if (listBucketsRequest.getPrefix() != null) {
            map.put(RequestParameters.PREFIX, listBucketsRequest.getPrefix());
        }
        if (listBucketsRequest.getMarker() != null) {
            map.put(RequestParameters.MARKER, listBucketsRequest.getMarker());
        }
        if (listBucketsRequest.getMaxKeys() != null) {
            map.put(RequestParameters.MAX_KEYS, Integer.toString(listBucketsRequest.getMaxKeys().intValue()));
        }
    }

    public static void populateListObjectsRequestParameters(ListObjectsRequest listObjectsRequest, Map<String, String> map) {
        if (listObjectsRequest.getPrefix() != null) {
            map.put(RequestParameters.PREFIX, listObjectsRequest.getPrefix());
        }
        if (listObjectsRequest.getMarker() != null) {
            map.put(RequestParameters.MARKER, listObjectsRequest.getMarker());
        }
        if (listObjectsRequest.getDelimiter() != null) {
            map.put(RequestParameters.DELIMITER, listObjectsRequest.getDelimiter());
        }
        if (listObjectsRequest.getMaxKeys() != null) {
            map.put(RequestParameters.MAX_KEYS, Integer.toString(listObjectsRequest.getMaxKeys().intValue()));
        }
        if (listObjectsRequest.getEncodingType() != null) {
            map.put(RequestParameters.ENCODING_TYPE, listObjectsRequest.getEncodingType());
        }
    }

    public static void populateListMultipartUploadsRequestParameters(ListMultipartUploadsRequest listMultipartUploadsRequest, Map<String, String> map) {
        if (listMultipartUploadsRequest.getDelimiter() != null) {
            map.put(RequestParameters.DELIMITER, listMultipartUploadsRequest.getDelimiter());
        }
        if (listMultipartUploadsRequest.getMaxUploads() != null) {
            map.put(RequestParameters.MAX_UPLOADS, Integer.toString(listMultipartUploadsRequest.getMaxUploads().intValue()));
        }
        if (listMultipartUploadsRequest.getKeyMarker() != null) {
            map.put(RequestParameters.KEY_MARKER, listMultipartUploadsRequest.getKeyMarker());
        }
        if (listMultipartUploadsRequest.getPrefix() != null) {
            map.put(RequestParameters.PREFIX, listMultipartUploadsRequest.getPrefix());
        }
        if (listMultipartUploadsRequest.getUploadIdMarker() != null) {
            map.put(RequestParameters.UPLOAD_ID_MARKER, listMultipartUploadsRequest.getUploadIdMarker());
        }
        if (listMultipartUploadsRequest.getEncodingType() != null) {
            map.put(RequestParameters.ENCODING_TYPE, listMultipartUploadsRequest.getEncodingType());
        }
    }

    public static void populateCopyObjectHeaders(CopyObjectRequest copyObjectRequest, Map<String, String> map) {
        map.put(OSSHeaders.COPY_OBJECT_SOURCE, "/" + copyObjectRequest.getSourceBucketName() + "/" + HttpUtil.urlEncode(copyObjectRequest.getSourceKey(), "utf-8"));
        addDateHeader(map, OSSHeaders.COPY_OBJECT_SOURCE_IF_MODIFIED_SINCE, copyObjectRequest.getModifiedSinceConstraint());
        addDateHeader(map, OSSHeaders.COPY_OBJECT_SOURCE_IF_UNMODIFIED_SINCE, copyObjectRequest.getUnmodifiedSinceConstraint());
        addStringListHeader(map, OSSHeaders.COPY_OBJECT_SOURCE_IF_MATCH, copyObjectRequest.getMatchingETagConstraints());
        addStringListHeader(map, OSSHeaders.COPY_OBJECT_SOURCE_IF_NONE_MATCH, copyObjectRequest.getNonmatchingEtagConstraints());
        addHeader(map, OSSHeaders.OSS_SERVER_SIDE_ENCRYPTION, copyObjectRequest.getServerSideEncryption());
        ObjectMetadata newObjectMetadata = copyObjectRequest.getNewObjectMetadata();
        if (newObjectMetadata != null) {
            map.put(OSSHeaders.COPY_OBJECT_METADATA_DIRECTIVE, MetadataDirective.REPLACE.toString());
            populateRequestMetadata(map, newObjectMetadata);
        }
        removeHeader(map, HttpHeaders.CONTENT_LENGTH);
    }

    public static String buildXMLFromPartEtagList(List<PartETag> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("<CompleteMultipartUpload>\n");
        for (PartETag next : list) {
            sb.append("<Part>\n");
            sb.append("<PartNumber>" + next.getPartNumber() + "</PartNumber>\n");
            sb.append("<ETag>" + next.getETag() + "</ETag>\n");
            sb.append("</Part>\n");
        }
        sb.append("</CompleteMultipartUpload>\n");
        return sb.toString();
    }

    public static void addHeader(Map<String, String> map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    public static void addDateHeader(Map<String, String> map, String str, Date date) {
        if (date != null) {
            map.put(str, DateUtil.formatRfc822Date(date));
        }
    }

    public static void addStringListHeader(Map<String, String> map, String str, List<String> list) {
        if (list != null && !list.isEmpty()) {
            map.put(str, join(list));
        }
    }

    public static void removeHeader(Map<String, String> map, String str) {
        if (str != null && map.containsKey(str)) {
            map.remove(str);
        }
    }

    public static String join(List<String> list) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String next : list) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(next);
            z = false;
        }
        return sb.toString();
    }

    public static boolean isEmptyString(String str) {
        return TextUtils.isEmpty(str);
    }

    public static String buildCanonicalString(RequestMessage requestMessage) {
        StringBuilder sb = new StringBuilder();
        sb.append(requestMessage.getMethod().toString() + NEW_LINE);
        Map headers = requestMessage.getHeaders();
        TreeMap treeMap = new TreeMap();
        if (headers != null) {
            for (Map.Entry entry : headers.entrySet()) {
                if (entry.getKey() != null) {
                    String lowerCase = ((String) entry.getKey()).toLowerCase();
                    if (lowerCase.equals(HttpHeaders.CONTENT_TYPE.toLowerCase()) || lowerCase.equals(HttpHeaders.CONTENT_MD5.toLowerCase()) || lowerCase.equals(HttpHeaders.DATE.toLowerCase()) || lowerCase.startsWith(OSSHeaders.OSS_PREFIX)) {
                        treeMap.put(lowerCase, ((String) entry.getValue()).trim());
                    }
                }
            }
        }
        if (!treeMap.containsKey(HttpHeaders.CONTENT_TYPE.toLowerCase())) {
            treeMap.put(HttpHeaders.CONTENT_TYPE.toLowerCase(), "");
        }
        if (!treeMap.containsKey(HttpHeaders.CONTENT_MD5.toLowerCase())) {
            treeMap.put(HttpHeaders.CONTENT_MD5.toLowerCase(), "");
        }
        for (Map.Entry entry2 : treeMap.entrySet()) {
            String str = (String) entry2.getKey();
            Object value = entry2.getValue();
            if (str.startsWith(OSSHeaders.OSS_PREFIX)) {
                sb.append(str);
                sb.append(':');
                sb.append(value);
            } else {
                sb.append(value);
            }
            sb.append(NEW_LINE);
        }
        sb.append(buildCanonicalizedResource(requestMessage.getBucketName(), requestMessage.getObjectKey(), requestMessage.getParameters()));
        return sb.toString();
    }

    public static String buildCanonicalizedResource(String str, String str2, Map<String, String> map) {
        String str3 = "/";
        if (!(str == null && str2 == null)) {
            if (str2 == null) {
                str3 = str3 + str + str3;
            } else {
                str3 = str3 + str + str3 + str2;
            }
        }
        return buildCanonicalizedResource(str3, map);
    }

    public static String buildCanonicalizedResource(String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (map != null) {
            String[] strArr = (String[]) map.keySet().toArray(new String[map.size()]);
            Arrays.sort(strArr);
            char c = '?';
            for (String str2 : strArr) {
                if (SIGNED_PARAMTERS.contains(str2)) {
                    sb.append(c);
                    sb.append(str2);
                    String str3 = map.get(str2);
                    if (!isEmptyString(str3)) {
                        sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                        sb.append(str3);
                    }
                    c = '&';
                }
            }
        }
        return sb.toString();
    }

    public static String paramToQueryString(Map<String, String> map, String str) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry next : map.entrySet()) {
            String str2 = (String) next.getKey();
            String str3 = (String) next.getValue();
            if (!z) {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb.append(HttpUtil.urlEncode(str2, str));
            if (!isEmptyString(str3)) {
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(HttpUtil.urlEncode(str3, str));
            }
            z = false;
        }
        return sb.toString();
    }

    public static String populateMapToBase64JsonString(Map<String, String> map) {
        return Base64.encodeToString(new JSONObject(map).toString().getBytes(), 2);
    }

    public static String sign(String str, String str2, String str3) {
        try {
            String trim = new HmacSHA1Signature().computeSignature(str2, str3).trim();
            return "OSS " + str + Constants.COLON_SEPARATOR + trim;
        } catch (Exception e) {
            throw new IllegalStateException("Compute signature failed!", e);
        }
    }

    public static boolean isOssOriginHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String endsWith : OSSConstants.OSS_ORIGN_HOST) {
            if (str.toLowerCase().endsWith(endsWith)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCname(String str) {
        for (String endsWith : OSSConstants.DEFAULT_CNAME_EXCLUDE_LIST) {
            if (str.toLowerCase().endsWith(endsWith)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isInCustomCnameExcludeList(String str, List<String> list) {
        for (String lowerCase : list) {
            if (str.endsWith(lowerCase.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static void assertTrue(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static boolean validateBucketName(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^[a-z0-9][a-z0-9\\-]{1,61}[a-z0-9]$");
    }

    public static void ensureBucketNameValid(String str) {
        if (!validateBucketName(str)) {
            throw new IllegalArgumentException("The bucket name is invalid. \nA bucket name must: \n1) be comprised of lower-case characters, numbers or dash(-); \n2) start with lower case or numbers; \n3) be between 3-63 characters long. ");
        }
    }

    public static boolean validateObjectKey(String str) {
        if (str != null && str.length() > 0 && str.length() <= 1023) {
            try {
                str.getBytes("utf-8");
                char[] charArray = str.toCharArray();
                char c = charArray[0];
                if (!(c == '/' || c == '\\')) {
                    for (char c2 : charArray) {
                        if (c2 != 9 && c2 < ' ') {
                            return false;
                        }
                    }
                    return true;
                }
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return false;
    }

    public static void ensureObjectKeyValid(String str) {
        if (!validateObjectKey(str)) {
            throw new IllegalArgumentException("The object key is invalid. \nAn object name should be: \n1) between 1 - 1023 bytes long when encoded as UTF-8 \n2) cannot contain LF or CR or unsupported chars in XML1.0, \n3) cannot begin with \"/\" or \"\\\".");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0028, code lost:
        r0 = r2 instanceof com.alibaba.sdk.android.oss.model.PutBucketLoggingRequest;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002c, code lost:
        r1 = r2 instanceof com.alibaba.sdk.android.oss.model.GetBucketLoggingRequest;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean doesRequestNeedObjectKey(com.alibaba.sdk.android.oss.model.OSSRequest r2) {
        /*
            boolean r0 = r2 instanceof com.alibaba.sdk.android.oss.model.ListObjectsRequest
            if (r0 != 0) goto L_0x0047
            boolean r0 = r2 instanceof com.alibaba.sdk.android.oss.model.ListBucketsRequest
            if (r0 != 0) goto L_0x0047
            boolean r0 = r2 instanceof com.alibaba.sdk.android.oss.model.CreateBucketRequest
            if (r0 != 0) goto L_0x0047
            boolean r0 = r2 instanceof com.alibaba.sdk.android.oss.model.DeleteBucketRequest
            if (r0 != 0) goto L_0x0047
            boolean r0 = r2 instanceof com.alibaba.sdk.android.oss.model.GetBucketInfoRequest
            if (r0 != 0) goto L_0x0047
            boolean r0 = r2 instanceof com.alibaba.sdk.android.oss.model.GetBucketACLRequest
            if (r0 != 0) goto L_0x0047
            boolean r0 = r2 instanceof com.alibaba.sdk.android.oss.model.DeleteMultipleObjectRequest
            if (r0 != 0) goto L_0x0047
            boolean r0 = r2 instanceof com.alibaba.sdk.android.oss.model.ListMultipartUploadsRequest
            if (r0 != 0) goto L_0x0047
            boolean r0 = r2 instanceof com.alibaba.sdk.android.oss.model.GetBucketRefererRequest
            if (r0 != 0) goto L_0x0047
            boolean r0 = r2 instanceof com.alibaba.sdk.android.oss.model.PutBucketRefererRequest
            if (r0 != 0) goto L_0x0047
            boolean r0 = r2 instanceof com.alibaba.sdk.android.oss.model.PutBucketLoggingRequest
            if (r0 != 0) goto L_0x0047
            boolean r1 = r2 instanceof com.alibaba.sdk.android.oss.model.GetBucketLoggingRequest
            if (r1 != 0) goto L_0x0047
            if (r0 != 0) goto L_0x0047
            if (r1 != 0) goto L_0x0047
            boolean r0 = r2 instanceof com.alibaba.sdk.android.oss.model.DeleteBucketLoggingRequest
            if (r0 != 0) goto L_0x0047
            boolean r0 = r2 instanceof com.alibaba.sdk.android.oss.model.PutBucketLifecycleRequest
            if (r0 != 0) goto L_0x0047
            boolean r0 = r2 instanceof com.alibaba.sdk.android.oss.model.GetBucketLifecycleRequest
            if (r0 != 0) goto L_0x0047
            boolean r2 = r2 instanceof com.alibaba.sdk.android.oss.model.DeleteBucketLifecycleRequest
            if (r2 == 0) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            r2 = 1
            return r2
        L_0x0047:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.common.utils.OSSUtils.doesRequestNeedObjectKey(com.alibaba.sdk.android.oss.model.OSSRequest):boolean");
    }

    public static boolean doesBucketNameValid(OSSRequest oSSRequest) {
        return !(oSSRequest instanceof ListBucketsRequest);
    }

    public static void ensureRequestValid(OSSRequest oSSRequest, RequestMessage requestMessage) {
        if (doesBucketNameValid(oSSRequest)) {
            ensureBucketNameValid(requestMessage.getBucketName());
        }
        if (doesRequestNeedObjectKey(oSSRequest)) {
            ensureObjectKeyValid(requestMessage.getObjectKey());
        }
        if (oSSRequest instanceof CopyObjectRequest) {
            ensureObjectKeyValid(((CopyObjectRequest) oSSRequest).getDestinationKey());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        r2 = r2.getMimeTypeFromExtension(r4.substring(r4.lastIndexOf(46) + 1));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String determineContentType(java.lang.String r2, java.lang.String r3, java.lang.String r4) {
        /*
            if (r2 == 0) goto L_0x0003
            return r2
        L_0x0003:
            android.webkit.MimeTypeMap r2 = android.webkit.MimeTypeMap.getSingleton()
            r0 = 46
            if (r3 == 0) goto L_0x001c
            int r1 = r3.lastIndexOf(r0)
            int r1 = r1 + 1
            java.lang.String r3 = r3.substring(r1)
            java.lang.String r3 = r2.getMimeTypeFromExtension(r3)
            if (r3 == 0) goto L_0x001c
            return r3
        L_0x001c:
            if (r4 == 0) goto L_0x002f
            int r3 = r4.lastIndexOf(r0)
            int r3 = r3 + 1
            java.lang.String r3 = r4.substring(r3)
            java.lang.String r2 = r2.getMimeTypeFromExtension(r3)
            if (r2 == 0) goto L_0x002f
            return r2
        L_0x002f:
            java.lang.String r2 = "application/octet-stream"
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.common.utils.OSSUtils.determineContentType(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static void signRequest(RequestMessage requestMessage) throws Exception {
        String str;
        OSSLog.logDebug("signRequest start");
        if (requestMessage.isAuthorizationRequired()) {
            if (requestMessage.getCredentialProvider() != null) {
                OSSCredentialProvider credentialProvider = requestMessage.getCredentialProvider();
                OSSFederationToken oSSFederationToken = null;
                boolean z = credentialProvider instanceof OSSFederationCredentialProvider;
                if (z) {
                    oSSFederationToken = ((OSSFederationCredentialProvider) credentialProvider).getValidFederationToken();
                    if (oSSFederationToken != null) {
                        requestMessage.getHeaders().put(OSSHeaders.OSS_SECURITY_TOKEN, oSSFederationToken.getSecurityToken());
                    } else {
                        OSSLog.logError("Can't get a federation token");
                        throw new IOException("Can't get a federation token");
                    }
                } else if (credentialProvider instanceof OSSStsTokenCredentialProvider) {
                    oSSFederationToken = credentialProvider.getFederationToken();
                    requestMessage.getHeaders().put(OSSHeaders.OSS_SECURITY_TOKEN, oSSFederationToken.getSecurityToken());
                }
                String buildCanonicalString = buildCanonicalString(requestMessage);
                OSSLog.logDebug("get contentToSign");
                if (z || (credentialProvider instanceof OSSStsTokenCredentialProvider)) {
                    str = sign(oSSFederationToken.getTempAK(), oSSFederationToken.getTempSK(), buildCanonicalString);
                } else if (credentialProvider instanceof OSSPlainTextAKSKCredentialProvider) {
                    OSSPlainTextAKSKCredentialProvider oSSPlainTextAKSKCredentialProvider = (OSSPlainTextAKSKCredentialProvider) credentialProvider;
                    str = sign(oSSPlainTextAKSKCredentialProvider.getAccessKeyId(), oSSPlainTextAKSKCredentialProvider.getAccessKeySecret(), buildCanonicalString);
                } else {
                    str = credentialProvider instanceof OSSCustomSignerCredentialProvider ? ((OSSCustomSignerCredentialProvider) credentialProvider).signContent(buildCanonicalString) : "---initValue---";
                }
                OSSLog.logDebug("signed content: " + buildCanonicalString + "   \n ---------   signature: " + str, false);
                OSSLog.logDebug("get signature");
                requestMessage.getHeaders().put(HttpHeaders.AUTHORIZATION, str);
                return;
            }
            throw new IllegalStateException("当前CredentialProvider为空！！！\n1. 请检查您是否在初始化OSSService时设置CredentialProvider;\n2. 如果您bucket为公共权限，请确认获取到Bucket后已经调用Bucket中接口声明ACL;");
        }
    }

    public static String buildBaseLogInfo(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("=====[device info]=====\n");
        sb.append("[INFO]: android_version：" + Build.VERSION.RELEASE + NEW_LINE);
        sb.append("[INFO]: mobile_model：" + Build.MODEL + NEW_LINE);
        return sb.toString();
    }

    public static void checkChecksum(Long l, Long l2, String str) throws InconsistentException {
        if (l != null && l2 != null && !l.equals(l2)) {
            throw new InconsistentException(l, l2, str);
        }
    }

    public static boolean isValidateIP(String str) throws Exception {
        if (str == null) {
            throw new Exception("host is null");
        } else if (Build.VERSION.SDK_INT >= 29) {
            return InetAddresses.isNumericAddress(str);
        } else {
            try {
                return ((Boolean) Class.forName("java.net.InetAddress").getMethod("isNumeric", new Class[]{String.class}).invoke((Object) null, new Object[]{str})).booleanValue();
            } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
                return false;
            }
        }
    }

    public static String buildTriggerCallbackBody(Map<String, String> map, Map<String, String> map2) {
        StringBuilder sb = new StringBuilder();
        sb.append("x-oss-process=trigger/callback,callback_");
        if (map != null && map.size() > 0) {
            sb.append(Base64.encodeToString(new JSONObject(map).toString().getBytes(), 2));
        }
        sb.append(",callback-var_");
        if (map2 != null && map2.size() > 0) {
            sb.append(Base64.encodeToString(new JSONObject(map2).toString().getBytes(), 2));
        }
        return sb.toString();
    }

    public static String buildImagePersistentBody(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("x-oss-process=");
        if (str3.startsWith("image/")) {
            sb.append(str3);
        } else {
            sb.append("image/");
            sb.append(str3);
        }
        sb.append("|sys/");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String encodeToString = Base64.encodeToString(str.getBytes(), 2);
            String encodeToString2 = Base64.encodeToString(str2.getBytes(), 2);
            sb.append("saveas,o_");
            sb.append(encodeToString2);
            sb.append(",b_");
            sb.append(encodeToString);
        }
        String sb2 = sb.toString();
        OSSLog.logDebug("ImagePersistent body : " + sb2);
        return sb2;
    }

    private enum MetadataDirective {
        COPY("COPY"),
        REPLACE("REPLACE");
        
        private final String directiveAsString;

        private MetadataDirective(String str) {
            this.directiveAsString = str;
        }

        public String toString() {
            return this.directiveAsString;
        }
    }
}
