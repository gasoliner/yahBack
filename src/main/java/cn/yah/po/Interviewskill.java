package cn.yah.po;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Interviewskill {
    private Integer iid;

    private String name;

    private String content;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date publishtime;

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }
}