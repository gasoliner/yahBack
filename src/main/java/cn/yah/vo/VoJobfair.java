package cn.yah.vo;

import cn.yah.po.Jobfair;

/**
 * Created by cqx on 2018/5/17.
 */
public class VoJobfair extends Jobfair {

    private String voEid;

    public VoJobfair(Jobfair jobfair) {
        this.setJfid(jobfair.getJfid());
        this.setName(jobfair.getName());
        this.setEid(jobfair.getEid());
        this.setContent(jobfair.getContent());
    }

    public VoJobfair() {}

    public String getVoEid() {
        return voEid;
    }

    public void setVoEid(String voEid) {
        this.voEid = voEid;
    }
}
