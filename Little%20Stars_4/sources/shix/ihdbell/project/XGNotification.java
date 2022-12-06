package shix.ihdbell.project;

public class XGNotification {
    private String activity;
    private String content;
    private Integer id;
    private Long msg_id;
    private int notificationActionType;
    private String title;
    private String update_time;

    public XGNotification() {
    }

    public XGNotification(Integer num, Long l, String str, String str2, String str3, int i, String str4) {
        this.id = num;
        this.msg_id = l;
        this.title = str;
        this.content = str2;
        this.activity = str3;
        this.notificationActionType = i;
        this.update_time = str4;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public Long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(Long l) {
        this.msg_id = l;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getUpdate_time() {
        return this.update_time;
    }

    public void setUpdate_time(String str) {
        this.update_time = str;
    }

    public String getActivity() {
        return this.activity;
    }

    public void setActivity(String str) {
        this.activity = str;
    }

    public int getNotificationActionType() {
        return this.notificationActionType;
    }

    public void setNotificationActionType(int i) {
        this.notificationActionType = i;
    }
}
