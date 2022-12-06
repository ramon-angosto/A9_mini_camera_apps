package com.shix.shixipc.bean;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoRecordModel {
    private int bistream;
    private int cmd;
    private int end_time;
    private int recordAudio;
    private int record_time;
    private int recordcov;
    private int result;
    private int start_time;
    private int timerecord;
    private int videoRecord;

    public int getRecordAudio() {
        return this.recordAudio;
    }

    public void setRecordAudio(int i) {
        this.recordAudio = i;
    }

    public int getVideoRecord() {
        return this.videoRecord;
    }

    public void setVideoRecord(int i) {
        this.videoRecord = i;
    }

    public int getCmd() {
        return this.cmd;
    }

    public void setCmd(int i) {
        this.cmd = i;
    }

    public int getResult() {
        return this.result;
    }

    public void setResult(int i) {
        this.result = i;
    }

    public int getRecordcov() {
        return this.recordcov;
    }

    public void setRecordcov(int i) {
        this.recordcov = i;
    }

    public int getTimerecord() {
        return this.timerecord;
    }

    public void setTimerecord(int i) {
        this.timerecord = i;
    }

    public int getStart_time() {
        return this.start_time;
    }

    public void setStart_time(int i) {
        this.start_time = i;
    }

    public int getEnd_time() {
        return this.end_time;
    }

    public void setEnd_time(int i) {
        this.end_time = i;
    }

    public int getRecord_time() {
        return this.record_time;
    }

    public void setRecord_time(int i) {
        this.record_time = i;
    }

    public int getBistream() {
        return this.bistream;
    }

    public void setBistream(int i) {
        this.bistream = i;
    }

    public static VideoRecordModel jsonToModel(String str) throws JSONException {
        VideoRecordModel videoRecordModel = new VideoRecordModel();
        JSONObject jSONObject = new JSONObject(str);
        videoRecordModel.setCmd(CommonUtil.jasonPaseInt(jSONObject, "cmd", ContentCommon.SHIXFINAL_ERRORINT));
        videoRecordModel.setResult(CommonUtil.jasonPaseInt(jSONObject, IronSourceConstants.EVENTS_RESULT, ContentCommon.SHIXFINAL_ERRORINT));
        videoRecordModel.setRecordcov(CommonUtil.jasonPaseInt(jSONObject, "recordcov", ContentCommon.SHIXFINAL_ERRORINT));
        videoRecordModel.setStart_time(CommonUtil.jasonPaseInt(jSONObject, "start_time", ContentCommon.SHIXFINAL_ERRORINT));
        videoRecordModel.setEnd_time(CommonUtil.jasonPaseInt(jSONObject, "end_time", ContentCommon.SHIXFINAL_ERRORINT));
        videoRecordModel.setRecord_time(CommonUtil.jasonPaseInt(jSONObject, "record_time", ContentCommon.SHIXFINAL_ERRORINT));
        videoRecordModel.setBistream(CommonUtil.jasonPaseInt(jSONObject, "bitStream", ContentCommon.SHIXFINAL_ERRORINT));
        videoRecordModel.setRecordAudio(CommonUtil.jasonPaseInt(jSONObject, "recordAudio", ContentCommon.SHIXFINAL_ERRORINT));
        if (CommonUtil.jasonPaseInt(jSONObject, "videoRecord", ContentCommon.SHIXFINAL_ERRORINT) != -110) {
            videoRecordModel.setTimerecord(CommonUtil.jasonPaseInt(jSONObject, "videoRecord", ContentCommon.SHIXFINAL_ERRORINT));
            videoRecordModel.setVideoRecord(CommonUtil.jasonPaseInt(jSONObject, "videoRecord", ContentCommon.SHIXFINAL_ERRORINT));
        } else {
            videoRecordModel.setTimerecord(CommonUtil.jasonPaseInt(jSONObject, "timerecord", ContentCommon.SHIXFINAL_ERRORINT));
        }
        return videoRecordModel;
    }

    public static String toJson(VideoRecordModel videoRecordModel, String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pro", "set_record_param");
        jSONObject.put("cmd", 122);
        jSONObject.put("user", str);
        jSONObject.put("pwd", str2);
        jSONObject.put("recordcov", videoRecordModel.getRecordcov());
        jSONObject.put("start_time", videoRecordModel.getStart_time());
        jSONObject.put("end_time", videoRecordModel.getEnd_time());
        jSONObject.put("record_time", videoRecordModel.getRecord_time());
        jSONObject.put("bitStream", videoRecordModel.getBistream());
        jSONObject.put("recordAudio", videoRecordModel.getRecordAudio());
        jSONObject.put("recordcov", videoRecordModel.getRecordcov());
        if (videoRecordModel.getVideoRecord() != -110) {
            jSONObject.put("videoRecord", videoRecordModel.getTimerecord());
        } else {
            jSONObject.put("timerecord", videoRecordModel.getTimerecord());
        }
        return jSONObject.toString();
    }
}
