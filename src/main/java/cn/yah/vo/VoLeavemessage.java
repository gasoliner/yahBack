package cn.yah.vo;

import cn.yah.po.Leavemessage;


public class VoLeavemessage extends Leavemessage {

    private String voPublish;

    public VoLeavemessage(Leavemessage leavemessage) {
        this.setLmid(leavemessage.getLmid());
        this.setName(leavemessage.getName());
        this.setContent(leavemessage.getContent());
        this.setPublishtime(leavemessage.getPublishtime());
    }

    public VoLeavemessage() {}

    public String getVoPublish() {
        return voPublish;
    }

    public void setVoPublish(String voPublish) {
        this.voPublish = voPublish;
    }
}
