package cn.yah.vo;

import cn.yah.po.Enterprise;

/**
 * Created by Ww on 2018/5/16.
 */
public class VoEnterprise extends Enterprise {

    private String voImg;

    private String voIslock;

    public VoEnterprise(Enterprise enterprise) {
        this.setEid(enterprise.getEid());
        this.setName(enterprise.getName());
        this.setPassword(enterprise.getPassword());
        this.setNature(enterprise.getNature());
        this.setScale(enterprise.getScale());
        this.setWebsite(enterprise.getWebsite());
        this.setTrade(enterprise.getTrade());
        this.setAddr(enterprise.getAddr());
        this.setPhone(enterprise.getPhone());
        this.setEmail(enterprise.getEmail());
        this.setImg(enterprise.getImg());
        this.setInfo(enterprise.getInfo());
        this.setIslock(enterprise.getIslock());
    }

    public VoEnterprise() {}

    public String getVoImg() {
        return voImg;
    }

    public void setVoImg(String voImg) {
        this.voImg = voImg;
    }

    public String getVoIslock() {
        return voIslock;
    }

    public void setVoIslock(String voIslock) {
        this.voIslock = voIslock;
    }
}
