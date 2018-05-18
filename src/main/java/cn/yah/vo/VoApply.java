package cn.yah.vo;

import cn.yah.po.Apply;
import cn.yah.po.Member;

/**
 * Created by Ww on 2018/5/18.
 */
public class VoApply extends Apply {

    private String voMid;

    private String voRid;

    private String voResume;

    private Member member;

    private String action;

    public VoApply(Apply apply) {
        this.setAid(apply.getAid());
        this.setMid(apply.getMid());
        this.setRid(apply.getRid());
        this.setVar(apply.getVar());
    }

    public VoApply() {}

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getVoResume() {
        return voResume;
    }

    public void setVoResume(String voResume) {
        this.voResume = voResume;
    }

    public String getVoRid() {
        return voRid;
    }

    public void setVoRid(String voRid) {
        this.voRid = voRid;
    }

    public String getVoMid() {
        return voMid;
    }

    public void setVoMid(String voMid) {
        this.voMid = voMid;
    }
}
