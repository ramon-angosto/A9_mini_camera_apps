package com.meizu.cloud.pushsdk.platform.message;

import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SubTagsStatus extends BasicPushStatus {
    private String pushId;
    private List<Tag> tagList;

    public SubTagsStatus() {
    }

    public class Tag implements Serializable {
        /* access modifiers changed from: private */
        public int tagId;
        /* access modifiers changed from: private */
        public String tagName;

        public Tag() {
        }

        public String toString() {
            return "Tag{tagId=" + this.tagId + ", tagName='" + this.tagName + '\'' + '}';
        }

        public int getTagId() {
            return this.tagId;
        }

        public void setTagId(int i) {
            this.tagId = i;
        }

        public String getTagName() {
            return this.tagName;
        }

        public void setTagName(String str) {
            this.tagName = str;
        }
    }

    public SubTagsStatus(String str) {
        super(str);
    }

    public void parseValueData(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.isNull(PushConstants.KEY_PUSH_ID)) {
            setPushId(jSONObject.getString(PushConstants.KEY_PUSH_ID));
        }
        if (!jSONObject.isNull("tags")) {
            JSONArray jSONArray = jSONObject.getJSONArray("tags");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                Tag tag = new Tag();
                if (!jSONObject2.isNull("tagId")) {
                    int unused = tag.tagId = jSONObject2.getInt("tagId");
                }
                if (!jSONObject2.isNull("tagName")) {
                    String unused2 = tag.tagName = jSONObject2.getString("tagName");
                }
                arrayList.add(tag);
            }
            DebugLogger.e(BasicPushStatus.TAG, "tags " + arrayList);
            setTagList(arrayList);
        }
    }

    public String getPushId() {
        return this.pushId;
    }

    public void setPushId(String str) {
        this.pushId = str;
    }

    public List<Tag> getTagList() {
        return this.tagList;
    }

    public void setTagList(List<Tag> list) {
        this.tagList = list;
    }

    public String toString() {
        return super.toString() + " SubTagsStatus{" + "pushId='" + this.pushId + '\'' + ", tagList=" + this.tagList + '}';
    }
}
