package cn.yah.vo;

import cn.yah.po.Member;

/**
 * Created by Ww on 2018/5/18.
 */
public class VoMember extends Member {

    private String voResume;

    public VoMember(Member member) {
        this.setMid(member.getMid());
//        this.setPassword(member.getPassword());
        this.setName(member.getName());
        this.setPhone(member.getPhone());
        this.setEmail(member.getEmail());
        this.setAge(member.getAge());
        this.setUniversity(member.getUniversity());
        this.setPoint(member.getPoint());
        this.setIdnumber(member.getIdnumber());
//        this.setResume("");
    }

    public VoMember() {}

    public String getVoResume() {
        return voResume;
    }

    public void setVoResume(String voResume) {
        this.voResume = voResume;
    }
}
