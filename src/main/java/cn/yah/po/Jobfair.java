package cn.yah.po;

public class Jobfair {
    private Integer jfid;

    private String name;

    private Integer eid;

    private String content;

    public Integer getJfid() {
        return jfid;
    }

    public void setJfid(Integer jfid) {
        this.jfid = jfid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}